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

import com.squareup.okhttp.OkHttpClient;

/**
 * Constructs new facades to use. In general, those are thread-safe, so there is no reason to construct multiple facades, but it won't really hurt
 * either (extra memory wasted).
 */
public final class Identifiers {

    private Identifiers() {
        // factory class
    }

    /**
     * @return A new client facade using the default options
     */
    public static IdentifierFacade facade() {
        return facade("http://id.int.ysura.com/");
    }

    /**
     * @param The remote base-URL to talk to. Since this is used as the basis to construct URLs, the given base-URL is required to end in a "/"
     * @return A new client facade which talks to the given baseUrl
     */
    public static IdentifierFacade facade(final String baseUrl) {
        return facade(new OkHttpClient(), baseUrl);
    }

    /**
     * @param client The HTTP client to use
     * @param baseUrl The remote base-URL to talk to. Since this is used as the basis to construct URLs, the given base-URL is required to end in a "/"
     * @return A new client facade which talks to the given baseUrl using the given HTTP client
     */
    public static IdentifierFacade facade(final OkHttpClient client, final String baseUrl) {
        return new IdentifierFacadeImplementation(client, baseUrl);
    }

}
