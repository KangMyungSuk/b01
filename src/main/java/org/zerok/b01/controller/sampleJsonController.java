package org.zerok.b01.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Log4j2
public class sampleJsonController {

    @GetMapping("/helloArr")
    public String[] helloArr(){
        log.info("helloArr....................");

        return new String[]{"aaa", "bbb", "CCC"};
    }
}
