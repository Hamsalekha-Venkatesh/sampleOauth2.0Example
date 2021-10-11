package com.hamsa.springcloudgatewayservice;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GatewayController {
    @RequestMapping("countriesfallback")
    public String countries() {
        return "Countries APi is taking too long to respond! Sorry its not available";
    }

    @RequestMapping("jokefallback")
    public String jokes() {
        return "Jokes APi is taking too long to respond! Sorry its not available";
    }
}
