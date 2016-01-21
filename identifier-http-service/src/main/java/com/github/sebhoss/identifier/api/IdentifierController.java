package com.github.sebhoss.identifier.api;

import com.github.sebhoss.identifier.service.IdentifierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Returns new identifiers as JSON and shows a single static HTML page including those identifiers
 *
 * @see IdentifierControllerTest
 * @see IdentifierControllerIT
 */
@Controller
public class IdentifierController {

    private final IdentifierService identifierService;

    @Autowired
    public IdentifierController(final IdentifierService identifierService) {
        this.identifierService = identifierService;
    }

    @RequestMapping("/")
    public String index(Model model) {
        model.addAttribute("sequence", identifierService.nextSequence());
        model.addAttribute("sequence36", identifierService.nextSequenceInBase36());
        model.addAttribute("sequence64", identifierService.nextSequenceInBase64());

        model.addAttribute("uuid", identifierService.nextUuid());
        model.addAttribute("uuid36", identifierService.nextUuidInBase36());
        model.addAttribute("uuid64", identifierService.nextUuidInBase64());

        model.addAttribute("timestamp", identifierService.nextTimestamp());
        model.addAttribute("timestamp36", identifierService.nextTimestampInBase36());
        model.addAttribute("timestamp64", identifierService.nextTimestampInBase64());

        return "index"; // delegates to the view 'index'
    }

    @ResponseBody
    @RequestMapping("/sequence")
    public String sequence() {
        return identifierService.nextSequence();
    }

    @ResponseBody
    @RequestMapping("/sequence-in-base36")
    public String sequenceInBase36() {
        return identifierService.nextSequenceInBase36();
    }

    @ResponseBody
    @RequestMapping("/sequence-in-base64")
    public String sequenceInBase64() {
        return identifierService.nextSequenceInBase64();
    }

    @ResponseBody
    @RequestMapping("/uuid")
    public String uuid() {
        return identifierService.nextUuid();
    }

    @ResponseBody
    @RequestMapping("/uuid-in-base36")
    public String uuidInBase36() {
        return identifierService.nextUuidInBase36();
    }

    @ResponseBody
    @RequestMapping("/uuid-in-base64")
    public String uuidInBase64() {
        return identifierService.nextUuidInBase64();
    }

    @ResponseBody
    @RequestMapping("/timestamp")
    public String timestamp() {
        return identifierService.nextTimestamp();
    }

    @ResponseBody
    @RequestMapping("/timestamp-in-base36")
    public String timestampInBase36() {
        return identifierService.nextTimestampInBase36();
    }

    @ResponseBody
    @RequestMapping("/timestamp-in-base64")
    public String timestampInBase64() {
        return identifierService.nextTimestampInBase64();
    }

}
