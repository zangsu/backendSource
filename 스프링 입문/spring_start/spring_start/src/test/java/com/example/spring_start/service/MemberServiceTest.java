package com.example.spring_start.service;

import com.example.spring_start.domain.Member;
import com.example.spring_start.repository.MemoryMemberRepository;
import org.assertj.core.api.Assert;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class MemberServiceTest {

    MemberService memberService;
    //MemoryMemberRepository memberRepository = new MemoryMemberRepository();// 본 소스코드의 저장소와 다른 저장소를 쓸 필요는 없긴 함,,,
    MemoryMemberRepository memberRepository;

    @BeforeEach
    public void beforeEach() {
        memberRepository = new MemoryMemberRepository();
        memberService = new MemberService(memberRepository);
    }
    @AfterEach
    public void afterEach() {
        memberRepository.clearStore();
    }

    @Test
    void join() {
        //given
        Member member = new Member();
        member.setName("hello");

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


        /*try{
            memberService.join(member2);
            fail();
        } catch (IllegalStateException e) {
            Assertions.assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");

        }*/

        //then
    }

    @Test
    void findMembers() {
    }

    @Test
    void findOne() {
    }
}