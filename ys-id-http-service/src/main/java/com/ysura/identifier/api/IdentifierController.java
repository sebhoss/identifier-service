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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ysura.identifier.service.IdentifierService;

/**
 * Returns new identifiers as JSON and shows a single static HTML page including those identifiers
 * 
 * @see IdentifierControllerTest
 * @see IdentifierControllerIT
 */
@RestController
public class IdentifierController {

    private final IdentifierService identifierService;

    @Autowired
    public IdentifierController(final IdentifierService identifierService) {
        this.identifierService = identifierService;
    }

    @RequestMapping("/")
    public String index() {
        return "Greetings from Spring Boot!";
    }

    @RequestMapping("/sequence")
    public String sequence() {
        return identifierService.nextSequence();
    }

    @RequestMapping("/sequence-in-base36")
    public String sequenceInBase36() {
        return identifierService.nextSequenceInBase36();
    }

    @RequestMapping("/sequence-in-base64")
    public String sequenceInBase64() {
        return identifierService.nextSequenceInBase64();
    }

    @RequestMapping("/uuid")
    public String uuid() {
        return identifierService.nextUuid();
    }

    @RequestMapping("/uuid-in-base36")
    public String uuidInBase36() {
        return identifierService.nextUuidInBase36();
    }

    @RequestMapping("/uuid-in-base64")
    public String uuidInBase64() {
        return identifierService.nextUuidInBase64();
    }

    @RequestMapping("/timestamp")
    public String timestamp() {
        return identifierService.nextTimestamp();
    }

    @RequestMapping("/timestamp-in-base36")
    public String timestampInBase36() {
        return identifierService.nextTimestampInBase36();
    }

    @RequestMapping("/timestamp-in-base64")
    public String timestampInBase64() {
        return identifierService.nextTimestampInBase64();
    }

}
