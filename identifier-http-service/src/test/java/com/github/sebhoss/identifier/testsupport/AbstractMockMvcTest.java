/*
 * This file is part of identifier-service. It is subject to the license terms in the LICENSE file found in the top-level
 * directory of this distribution and at http://creativecommons.org/publicdomain/zero/1.0/. No part of identifier-service,
 * including this file, may be copied, modified, propagated, or distributed except according to the terms contained
 * in the LICENSE file.
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
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

/**
 * Abstract unit test that sets up Spring's MockMvc.
 *
 * @param <CONTROLLER>
 *          The type of the controller to test.
 * @param <API>
 *          The type of the controller's API to use.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.MOCK)
@AutoConfigureMockMvc
public abstract class AbstractMockMvcTest<CONTROLLER, API> {

  protected String                        expectedResult;
  protected Supplier<String>              supplier;
  protected API                           api;

  private final Function<API, CONTROLLER> constructor;
  private final Class<API>                apiClass;

  private MockMvc                         mvc;

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
   *           In case something goes wrong.
   */
  @Before
  public final void setUp() throws Exception {
    api = Mockito.mock(apiClass);
    mvc = MockMvcBuilders.standaloneSetup(constructor.apply(api)).build();
  }

  protected final void requestAndVerify(final String path) throws Exception {
    given(supplier.get()).willReturn(expectedResult);
    text(path).andExpect(status().isOk())
        .andExpect(content().string(equalTo(expectedResult)));
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
