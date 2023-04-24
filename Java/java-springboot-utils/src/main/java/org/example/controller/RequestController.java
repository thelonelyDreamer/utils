package org.example.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 23167
 * @description Java is the best language
 * @date 2023/1/31--@20:58
 */
@RestController
@RequestMapping("/req")
public class RequestController {
    @Autowired
    private ObjectMapper mapper;
    @RequestMapping("/info")
    public Map info(HttpServletRequest request){
        HashMap<String, Object> map = new HashMap<>();
        Map<String, String[]> parameterMap = request.getParameterMap();
        System.out.println(request.getParameter("name"));
        map.putAll(parameterMap);
        return map;
    }
    @RequestMapping("/req")
    public HttpServletRequest req(HttpServletRequest req){
        return req;
    }
}
