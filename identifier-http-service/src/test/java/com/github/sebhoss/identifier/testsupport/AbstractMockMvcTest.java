/*
 * This is free and unencumbered software released into the public domain.
 *
 * Anyone is free to copy, modify, publish, use, compile, sell, or
 * distribute this software, either in source code form or as a compiled
 * binary, for any purpose, commercial or non-commercial, and by any
 * means.
 *
 * In jurisdictions that recognize copyright laws, the author or authors
 * of this software dedicate any and all copyright interest in the
 * software to the public domain. We make this dedication for the benefit
 * of the public at large and to the detriment of our heirs and
 * successors. We intend this dedication to be an overt act of
 * relinquishment in perpetuity of all present and future rights to this
 * software under copyright law.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 * EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
 * MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT.
 * IN NO EVENT SHALL THE AUTHORS BE LIABLE FOR ANY CLAIM, DAMAGES OR
 * OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE,
 * ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR
 * OTHER DEALINGS IN THE SOFTWARE.
 *
 * For more information, please refer to <http://unlicense.org>
 */
package com.github.sebhoss.identifier.testsupport;

import static org.hamcrest.Matchers.equalTo;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.function.Function;
import java.util.function.Supplier;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockServletContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

/**
 * Abstract unit test that sets up Spring's MockMvc.
 *
 * @param <CONTROLLER>
 *            The type of the controller to test.
 * @param <API>
 *            The type of the controller's API to use.
 */
@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = MockServletContext.class)
public abstract class AbstractMockMvcTest<CONTROLLER, API> {

    protected String           expectedResult;
    protected Supplier<String> supplier;
    protected API              api;

    private final Function<API, CONTROLLER> constructor;
    private final Class<API>                apiClass;

    private MockMvc mvc;

    protected AbstractMockMvcTest(
            final Function<API, CONTROLLER> constructor,
            final Class<API> apiClass) {
        this.constructor = constructor;
        this.apiClass = apiClass;
    }

    /**
     * Sets up both API and MVC.
     *
     * @throws Exception
     *             In case something goes wrong.
     */
    @Before
    public final void setUp() throws Exception {
        api = Mockito.mock(apiClass);
        mvc = MockMvcBuilders.standaloneSetup(constructor.apply(api)).build();
    }

    protected final void requestAndVerify(final String path) throws Exception {
        given(supplier.get()).willReturn(expectedResult);
        text(path).andExpect(status().isOk()).andExpect(content().string(equalTo(expectedResult)));
    }

    protected final ResultActions text(final String path) throws Exception {
        return mvc.perform(MockMvcRequestBuilders.get(path).accept(MediaType.TEXT_PLAIN));
    }

    protected final void verifyHtml(final String path) throws Exception {
        html(path).andExpect(status().isOk());
    }

    protected final ResultActions html(final String path) throws Exception {
        return mvc.perform(MockMvcRequestBuilders.get(path).accept(MediaType.TEXT_HTML));
    }

}
