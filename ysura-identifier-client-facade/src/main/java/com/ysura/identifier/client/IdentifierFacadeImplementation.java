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
package com.ysura.identifier.client;

import java.io.IOException;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;

/**
 * OkHttp-based implementation
 */
class IdentifierFacadeImplementation implements IdentifierFacade {

    private final OkHttpClient httpClient;
    private final String baseUrl;

    /**
     * Configures a client facade to access the ysura ID service
     * 
     * @param httpClient The HTTP client to use (might be reused by other components)
     * @param baseUrl The base-URL for the ID server to use. Should look like this: `http://some-address.com/whatever/`. It's required that the URL
     * contains a closing "/"
     */
    IdentifierFacadeImplementation(final OkHttpClient httpClient, final String baseUrl) {
        this.httpClient = httpClient;
        this.baseUrl = baseUrl;
    }

    public String getNextSequence() {
        return get("sequence");
    }

    public String getNextSequenceInBase36() {
        return get("sequence-in-base36");
    }

    public String getNextSequenceInBase64() {
        return get("sequence-in-base64");
    }

    public String getNextUuid() {
        return get("uuid");
    }

    public String getNextUuidInBase36() {
        return get("uuid-in-base36");
    }

    public String getNextUuidInBase64() {
        return get("uuid-in-base64");
    }

    public String getNextTimestamp() {
        return get("timestamp");
    }

    public String getNextTimestampInBase36() {
        return get("timestamp-in-base36");
    }

    public String getNextTimestampInBase64() {
        return get("timestamp-in-base64");
    }

    private String get(final String path) {
        Request request = new Request.Builder()
                .get()
                .url(baseUrl + path)
                .build();

        try {
            return httpClient.newCall(request).execute().body().string();
        } catch (final IOException exception) {
            throw new IllegalStateException(exception);
        }
    }

}
