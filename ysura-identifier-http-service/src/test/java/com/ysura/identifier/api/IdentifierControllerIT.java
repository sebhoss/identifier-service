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
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.client.RestTemplate;

import com.ysura.identifier.IdentifierApplication;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = IdentifierApplication.class)
@WebAppConfiguration
@IntegrationTest({"server.port=0"})
public class IdentifierControllerIT {

    @Value("${local.server.port}")
    private int port;

    private String base;
    private RestTemplate template;

    @Before
    public void setUp() throws Exception {
        base = "http://localhost:" + port + "/";
        template = new TestRestTemplate();
    }

    @Test
    public void getIndexPage() throws Exception {
        ResponseEntity<String> response = template.getForEntity(base, String.class);
        assertThat(response.getStatusCode(), equalTo(HttpStatus.OK));
    }

    @Test
    public void getSequence() throws Exception {
        ResponseEntity<String> response = template.getForEntity(base + "sequence", String.class);
        assertThat(response.getBody(), equalTo("0"));
    }

    @Test
    public void getSequenceInBase36() throws Exception {
        ResponseEntity<String> response = template.getForEntity(base + "sequence-in-base36", String.class);
        assertThat(response.getBody(), equalTo("0"));
    }

    @Test
    public void getSequenceInBase64() throws Exception {
        ResponseEntity<String> response = template.getForEntity(base + "sequence-in-base64", String.class);
        assertThat(response.getBody(), equalTo("MA=="));
    }

    @Test
    public void getUuid() throws Exception {
        ResponseEntity<String> response = template.getForEntity(base + "uuid", String.class);
        assertThat(response.getBody(), isValidUUID());
    }

    @Test
    public void getUuidInBase36() throws Exception {
        ResponseEntity<String> response = template.getForEntity(base + "uuid-in-base36", String.class);
        assertNotNull(response.getBody());
    }

    @Test
    public void getUuidInBase64() throws Exception {
        ResponseEntity<String> response = template.getForEntity(base + "uuid-in-base64", String.class);
        assertNotNull(response.getBody());
    }

    @Test
    public void getTimestamp() throws Exception {
        ResponseEntity<String> response = template.getForEntity(base + "timestamp", String.class);
        assertNotNull(response.getBody());
    }

    @Test
    public void getTimestampInBase36() throws Exception {
        ResponseEntity<String> response = template.getForEntity(base + "timestamp-in-base36", String.class);
        assertNotNull(response.getBody());
    }

    @Test
    public void getTimestampInBase64() throws Exception {
        ResponseEntity<String> response = template.getForEntity(base + "timestamp-in-base64", String.class);
        assertNotNull(response.getBody());
    }

}
