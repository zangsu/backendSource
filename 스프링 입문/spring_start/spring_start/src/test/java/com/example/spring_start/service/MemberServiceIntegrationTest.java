package com.example.spring_start.service;

import com.example.spring_start.domain.Member;
import com.example.spring_start.repository.MemberRepository;
import com.example.spring_start.repository.MemoryMemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
@Transactional
class MemberServiceIntegrationTest {



   /* @BeforeEach
    public void beforeEach() {
        memberRepository = new MemoryMemberRepository();
        memberService = new MemberService(memberRepository);
    }
    얘로 직접 객체생성 하는 대신 spring boot한테 받아올거임
    어떻게? 위의 autowired로*/

    @Autowired MemberService memberService;
    @Autowired MemberRepository memberRepository;

    /*@AfterEach
    public void afterEach() {
        memberRepository.clearStore();
    }
    얘도 필요가 없어졌음
    왜? @Transactional 때문에
    Transaction
    */

    @Test
    void join() {
        //given
        Member member = new Member();
        member.setName("hello!!");

        //when
        Long saveId = memberService.join(member);

        //then
        Member findMember = memberService.findOne(saveId).get();
        Assertions.assertThat(member.getName()).isEqualTo(findMember.getName());
    }

    @Test
    public void 중복_회원_예외() {
        //given
        Member member1 = new Member();
        member1.setName("spring");

        Member member2 = new Member();
        member2.setName("spring");

        //when
        memberService.join(member1);
        //memberService.join(member2);//얘를 try-catch해도 됨
        IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(member2));//param2가 실행이 되면 param1 에러가 나와야한다.

        Assertions.assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");//메세지 확인

    }

}