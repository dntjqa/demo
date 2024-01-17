package com.thc.sprapi.controller.page;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping("")
@Controller //페이지를 보여주는 컨트롤러
public class DefaultController {

    @GetMapping("/doc")
    public String getSwagger() {
        return "redirect:/swagger-ui/index.html";
    }

    //컨트롤러 : url에서 /aa로 호출하면 aa()메서드가 실행!! => aa.html 을 찾아감("aa"를 리턴하기 때문)
    @GetMapping("/aa")
    public String aa(){
        System.out.println("aa 잘 탔습니다!");
        return "aa";
    }
    @GetMapping("/wtest")
    public String wtest(){
        return "wtest"; // => wtest.html로 가는겁니다!!
    }

    @GetMapping("/btest")
    public String btest(){
        return "btest";
    }

    @GetMapping({"", "/", "/index"})
    public String getIndex() {
        return "index";
    }

    @GetMapping({"/test"}) //어떤 url과 연결할 것인가
    public String getTest() {
        return "test";
        //리턴으로 정한 "test"를 파일명으로 갖는 test.html 을 templates 폴더 밑에서 찾아서 뿌려줌
    }
    @GetMapping({"/dirTest"})
    public String getDirTest() {
        return "/testdir/t123"; //폴더 명을 지정해주면, 찾아갈 수 있습니다.
    }

    @GetMapping({"/write"})
    public String getWrite() {
        return "write";
    }

    @GetMapping({"/params"})
    public String getParams(
            @RequestParam(value = "tbcrew_title", required = false) String tbcrew_title
           // HttpServletRequest request
    ) {
        System.out.println(tbcrew_title);
        return "params";
    }

    @GetMapping({"/create"})
    public String getCreate(
    ) {
        System.out.println("create");
        return "create";
    }

}
