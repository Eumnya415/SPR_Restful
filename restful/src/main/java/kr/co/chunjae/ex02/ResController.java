package kr.co.chunjae.ex02;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ResController {
    @RequestMapping(value = "/res1")
    // 메소드 호출시 데이터를 전송하도록 설정
    @ResponseBody
    // Map 데이터를 브라우저로 전송
    public Map<String, Object> res1() {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("id", "lee");
        map.put("name", "이자바");
        return map;
    }

    // 메소드 호출 시 home.jsp를 브라우저로 전송한다
    @RequestMapping(value = "/res2")
    public ModelAndView res2() {
        return new ModelAndView("home");
    }
}