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
package com.github.sebhoss.identifier.usecases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
class IndexPage {

    private final Identifiers identifiers;

    @Autowired
    IndexPage(final Identifiers identifiers) {
        this.identifiers = identifiers;
    }

    @RequestMapping("/")
    public String index(final Model model) {
        model.addAttribute("sequence", identifiers.nextSequence());
        model.addAttribute("sequence36", identifiers.nextSequenceInBase36());
        model.addAttribute("sequence64", identifiers.nextSequenceInBase64());

        model.addAttribute("uuid", identifiers.nextUuid());
        model.addAttribute("uuid36", identifiers.nextUuidInBase36());
        model.addAttribute("uuid64", identifiers.nextUuidInBase64());

        model.addAttribute("timestamp", identifiers.nextTimestamp());
        model.addAttribute("timestamp36", identifiers.nextTimestampInBase36());
        model.addAttribute("timestamp64", identifiers.nextTimestampInBase64());

        return "index"; // delegates to the view 'index'
    }

}
