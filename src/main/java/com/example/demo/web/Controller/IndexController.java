package com.example.demo.web.Controller;

import com.example.demo.config.auth.dto.SessionUser;
import com.example.demo.service.FoodService;
import com.example.demo.service.MemberService;
import com.example.demo.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


import javax.servlet.http.HttpSession;

@RequiredArgsConstructor
@Controller
public class IndexController {

    private final FoodService foodService;
    private final OrderService orderService;
    private final MemberService memberService;
    private final HttpSession httpSession;



    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("food", foodService.findAllDesc());

        //CustomOAuth2UserService에서 로그인 성공시 세션에 SessionUser를 저장하도록 구성함.
        //즉 로그인 성공시 httpSession.getAttribute("user")에서 값을 가져올수 있다.
        SessionUser user = (SessionUser) httpSession.getAttribute("user"); //세션값을 가져오는 부분

        if (user != null) { // 세션에 저장된 값이 있을때만 model에 userName으로 등록한다.
            //세션에 저장된 값이 없으면 model엔 아무런 값이 없는 상태이니 로그인 버튼이 보인다.
            model.addAttribute("userName", user.getName());
        }

        return "index"; //index.mustache로 자동 변환되어 반환한다.
    }

    @GetMapping("posts/mydata")
    public String postsMyData(Model model) {
        SessionUser user = (SessionUser) httpSession.getAttribute("user"); //세션값을 가져오는 부분

        if (user != null) { // 세션에 저장된 값이 있을때만 model에 userName으로 등록한다.
            //세션에 저장된 값이 없으면 model엔 아무런 값이 없는 상태이니 로그인 버튼이 보인다.
            model.addAttribute("userName", user.getName());
            model.addAttribute("userEmail", user.getEmail());
            model.addAttribute("userPicture", user.getPicture());
        }

        return "mydata-page";
    }


    //유저 댓글
    @GetMapping("/posts/Guest/comment")
    public String CommentSaveUser() {
        return "guest-comment";
    }

    @GetMapping("/posts/Chairman/comment")
    public String CommentSaveChairman() {
        return "chairman-comment";
    }


    //유저댓글을 보여주는 페이지만들기

    //유저댓글을 보여준페이지 밑에 사장님이 댓글을 달 수 있는 페이지를 만들기.


    //배송을 알리는 사장님 페이지
    @GetMapping("/posts/chairman")
    public String postsChairman() {
        return "chairman";
    }
}