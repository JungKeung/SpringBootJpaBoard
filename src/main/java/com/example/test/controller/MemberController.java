package com.example.test.controller;

import com.example.test.domain.Member;
import com.example.test.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/member")
    public String createForm(Model model){
        model.addAttribute ( "memberForm", new MemberForm());
        return "members/createdMember";
    }

    @PostMapping("/member")
    public String create(@Valid MemberForm form, BindingResult result){

        if (result.hasErrors()) {
            return "members/createdMember";
        }

        Member member = new Member () ;
        member.setName(form.getName());
        member.setCity(form.getCity());
        member.setEmail(form.getEmail());
        member.setPassword(form.getPassword());
        member.setBirthDate(form.getBirthDate());
        member.setPhoneNumber(form.getPhoneNumber());

        memberService.join (member);
        return "redirect:/";

    }

    @GetMapping("/members/list")
    public String list(Model model){
        List<Member> members = memberService.findMembers ();
        model.addAttribute ("members", members);
        return "/members/memberList";
    }
}
