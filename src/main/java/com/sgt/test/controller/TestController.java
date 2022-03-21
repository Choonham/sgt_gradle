package com.sgt.test.controller;

import com.sgt.test.service.TestService;
import com.sgt.test.vo.TestVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class TestController {

    @Autowired
    TestService testService;

    @RequestMapping("/test.do")
    public String test(Model model) {
        TestVo testVo = new TestVo();
        testVo.setTestValue("10");
        int val = testService.countTestValue(testVo);
        model.addAttribute("val", val);
        return "index";
    }
}
