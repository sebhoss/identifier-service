/*
 * ysura GmbH ("COMPANY") CONFIDENTIAL
 * Unpublished Copyright (c) 2012-2015 ysura GmbH, All Rights Reserved.
 *
 * NOTICE:  All information contained herein is, and remains the property of COMPANY. The intellectual and technical concepts contained
 * herein are proprietary to COMPANY and may be covered by U.S. and Foreign Patents, patents in process, and are protected by trade secret or copyright law.
 * Dissemination of this information or reproduction of this material is strictly forbidden unless prior written permission is obtained
 * from COMPANY.  Access to the source code contained herein is hereby forbidden to anyone except current COMPANY employees, managers or contractors who have executed
 * Confidentiality and Non-disclosure agreements explicitly covering such access.
 *
 * The copyright notice above does not evidence any actual or intended publication or disclosure  of  this source code, which includes
 * information that is confidential and/or proprietary, and is a trade secret, of COMPANY. ANY REPRODUCTION, MODIFICATION, DISTRIBUTION, PUBLIC PERFORMANCE,
 * OR PUBLIC DISPLAY OF OR THROUGH USE  OF THIS SOURCE CODE WITHOUT THE EXPRESS WRITTEN CONSENT OF COMPANY IS STRICTLY PROHIBITED, AND IN VIOLATION OF APPLICABLE
 * LAWS AND INTERNATIONAL TREATIES. THE RECEIPT OR POSSESSION OF THIS SOURCE CODE AND/OR RELATED INFORMATION DOES NOT CONVEY OR IMPLY ANY RIGHTS
 * TO REPRODUCE, DISCLOSE OR DISTRIBUTE ITS CONTENTS, OR TO MANUFACTURE, USE, OR SELL ANYTHING THAT IT MAY DESCRIBE, IN WHOLE OR IN PART.
 */
package com.ysura.identifier.api;

import static com.ysura.identifier.testsupport.UuidMatcher.isValidUUID;
import static org.hamcrest.Matchers.equalTo;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.UUID;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockServletContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.ysura.identifier.service.IdentifierService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = { MockServletContext.class })
@WebAppConfiguration
public class IdentifierControllerTest {

    private MockMvc mvc;
    private IdentifierService identifierService;

    @Before
    public void setUp() throws Exception {
        identifierService = Mockito.mock(IdentifierService.class);

        mvc = MockMvcBuilders.standaloneSetup(new IdentifierController(identifierService)).build();
    }

    @Test
    public void getIndexPage() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("Greetings from Spring Boot!")));
    }

    @Test
    public void getSequence() throws Exception {
        given(identifierService.nextSequence()).willReturn("12345");

        mvc.perform(MockMvcRequestBuilders.get("/sequence").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("12345")));
    }

    @Test
    public void getSequenceInBase36() throws Exception {
        given(identifierService.nextSequenceInBase36()).willReturn("9ix");

        mvc.perform(MockMvcRequestBuilders.get("/sequence-in-base36").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("9ix")));
    }

    @Test
    public void getSequenceInBase64() throws Exception {
        given(identifierService.nextSequenceInBase64()).willReturn("MTIzNDU=");

        mvc.perform(MockMvcRequestBuilders.get("/sequence-in-base64").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("MTIzNDU=")));
    }

    @Test
    public void getUuid() throws Exception {
        given(identifierService.nextUuid()).willReturn(UUID.randomUUID().toString());

        mvc.perform(MockMvcRequestBuilders.get("/uuid").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(isValidUUID()));
    }

    @Test
    public void getUuidInBase36() throws Exception {
        final String result = "9xyplmzaulvyb16rmz32qg1rw";
        given(identifierService.nextUuidInBase36()).willReturn(result);

        mvc.perform(MockMvcRequestBuilders.get("/uuid-in-base36").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo(result)));
    }

    @Test
    public void getUuidInBase64() throws Exception {
        final String result = "Y2UyNGI3OTM2OTFlNDViZjhmN2RhOTU3ZWZjNzNlNTU=";
        given(identifierService.nextUuidInBase64()).willReturn(result);

        mvc.perform(MockMvcRequestBuilders.get("/uuid-in-base64").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo(result)));
    }

    @Test
    public void getTimestamp() throws Exception {
        final String result = "1430921821283";
        given(identifierService.nextTimestamp()).willReturn(result);

        mvc.perform(MockMvcRequestBuilders.get("/timestamp").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo(result)));
    }

    @Test
    public void getTimestampInBase36() throws Exception {
        final String result = "i8zoo1fk";
        given(identifierService.nextTimestampInBase36()).willReturn(result);

        mvc.perform(MockMvcRequestBuilders.get("/timestamp-in-base36").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo(result)));
    }

    @Test
    public void getTimestampInBase64() throws Exception {
        final String result = "MTQzMDkyMzY2OTEyNw==";
        given(identifierService.nextTimestampInBase64()).willReturn(result);

        mvc.perform(MockMvcRequestBuilders.get("/timestamp-in-base64").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo(result)));
    }

}
