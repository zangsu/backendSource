package jpabook.ch5.dao;

import jpabook.ch5.model.Member;
import jpabook.ch5.model.Team;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import java.util.List;
import java.util.function.Consumer;

class MemberDAOTest {
    MemberDAO memberDAO = new MemberDAO();

    @Test
    @Transactional
    public void mappingOwnerTest1() throws Exception{
        //given
        memberDAO.execute(memberDAO::testSave);

        //when
        Consumer<EntityManager> removeMemberInTeam = em -> {
            Team team1 = em.find(Team.class, "team1");
            Member member1 = em.find(Member.class, "member1");

            List<Member> members = team1.getMembers();

            System.out.println("삭제 시작");
            members.remove(member1);
            System.out.println("삭제 끝");
        };
        /*
        Consumer<EntityManager> mappingOwnerTestConsumer = (EntityManager em) -> {

            System.out.println("테스트 시작");

            Team team1 = em.find(Team.class, "team1");
            System.out.println("team1 = " + team1.getName());
            Member member1 = em.find(Member.class, "member1");
            System.out.println("member1 = " + member1);

            team1.getMembers().remove(member1);
            for (Member member : team1.getMembers()) {
                System.out.println(member.getUsername());
            }
        };*/
        memberDAO.execute(removeMemberInTeam);

        //then
        memberDAO.execute(memberDAO::queryLogicJoin);
    }

    @Test
    @Transactional
    public void mappingOwnerTest2() throws Exception {
        //given
        Consumer<EntityManager> wrongDataSave = em -> {
            Member member1 = new Member("member1", "회원1");
            em.persist(member1);

            Team team = new Team("team1", "팀1");
            team.getMembers().add(member1);
            em.persist(team);
        };
        memberDAO.execute(wrongDataSave);

        //when
        memberDAO.execute(em -> {
            Member member1 = em.find(Member.class, "member1");
            System.out.println(member1.getTeam().getName());

            Assertions.assertThat(member1.getTeam())
                    .isNull();
        });
        //then
    }

    @Test
    @Transactional
    public void MappingTest() throws Exception{
        //given
        memberDAO.execute(em -> {
            Member member1 = new Member("mamber1", "member1");
            em.persist(member1);

            Team team1 = new Team("team1", "team1");
            member1.setTeam(team1);
            em.persist(team1);

            Team team2 = new Team("team2", "team2");
            member1.setTeam(team2);
        });

        //when
        memberDAO.execute(em -> {
            Team team1 = em.find(Team.class, "team1");
            for (Member m : team1.getMembers()) {
                System.out.println(m);
            }
        });

        //then
    }
}