package com.example.test.service;

import com.example.test.domain.Member;
import com.example.test.repository.MemberRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

@WebAppConfiguration
@RunWith (SpringRunner.class)
@SpringBootTest
@Transactional
public class MemberServiceTest {

    @Autowired MemberService memberService;
    @Autowired MemberRepository memberRepository;
    @Autowired EntityManager em;

    @Rollback(value = false)
    @Test
    public void 회원가입() throws Exception{
        //given

        Member member = new Member ();
        member.setName ("kim");

        //when
        Long saveId = memberService.join(member);

        //then
        assertEquals(member, memberRepository.findOne (saveId));
    }

//    @Rollback(false)
    @Test(expected = IllegalStateException.class)
    public void 중복_회원_예외() throws Exception{
        //given
        Member member1 = new Member ();
        member1.setName ("kim1" );

        Member member2 = new Member ();
        member2.setName ("kim1" );

        //when
        memberService.join ( member1 );
        memberService.join ( member2 ); //예외가 발생해야 한다

        //then
        fail("예외가 발생해야한다.");
    }
}
