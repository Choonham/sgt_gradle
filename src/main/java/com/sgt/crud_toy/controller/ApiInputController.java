package com.sgt.crud_toy.controller;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import com.sgt.crud_toy.service.InputService;
import com.sgt.crud_toy.vo.InputVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Type;
import java.util.List;

@Controller
@RequestMapping(value = "/apiInput")
public class ApiInputController {
    @Autowired
    InputService inputService;

    @RequestMapping(value = "/getInputList.do", produces = "application/json; charset=utf8")
    @ResponseBody
    public String getInputList(@ModelAttribute("inputVo") final InputVo inputVo, final Model model, HttpServletRequest request) throws Exception {
        System.out.println(inputVo.getInputIp());
        List<InputVo> list = inputService.getInputList(inputVo.getInputIp());

        Type listType = new TypeToken<List<InputVo>>() {}.getType();

        JsonObject jsonObject = new JsonObject();

        Gson gson = new Gson();
        String json = gson.toJson(list, listType);

        jsonObject.addProperty("result", json);

        return jsonObject.toString();
    }

    @RequestMapping(value = "/insertInput.do", produces = "application/json; charset=utf8")
    @ResponseBody
    public String insertInput(@ModelAttribute("inputVo") final InputVo inputVo, final Model model) throws Exception {
        int rtnVal = inputService.insertInput(inputVo);

        return "{\"result\":\"" + rtnVal + "\"}";
    }

    @RequestMapping(value = "/updateInput.do", produces = "application/json; charset=utf8")
    @ResponseBody
    public String updateInput(@ModelAttribute("inputVo") final InputVo inputVo, final Model model) throws Exception {

        int rtnVal = inputService.updateInput(inputVo);

        return "{\"result\":\"" + rtnVal + "\"}";
    }

    @RequestMapping(value = "/deleteInput.do", produces = "application/json; charset=utf8")
    @ResponseBody
    public String deleteInput(@ModelAttribute("inputVo") final InputVo inputVo, final Model model) throws Exception {

        int rtnVal = inputService.deleteInput(inputVo);

        return "{\"result\":\"" + rtnVal + "\"}";
    }

}

