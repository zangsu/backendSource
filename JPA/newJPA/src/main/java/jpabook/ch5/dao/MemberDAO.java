package jpabook.ch5.dao;

import jpabook.ch5.model.Member;
import jpabook.ch5.model.Team;
import jpabook.start.DataSource;
import lombok.Getter;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import java.util.List;
import java.util.function.Consumer;

@Getter
public class MemberDAO {
    DataSource dataSource = DataSource.getDataSource();
    EntityManagerFactory emf = dataSource.getEmf();

    public void execute(Consumer<EntityManager> consumer){
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        try{
            tx.begin();
            consumer.accept(em);
            tx.commit();
            System.out.println("committed");
        }catch (Exception e){
            e.printStackTrace();
            tx.rollback();
            System.out.println("rollback");
        }finally {
            em.close();
        }
    }
    public void testSave(EntityManager em){
        Team team1 = new Team("team1", "팀1");
        em.persist(team1);

        Member member1 = new Member("member1", "회원1");
        member1.setTeam(team1);
        em.persist(member1);

        Member member2 = new Member("member2", "회원2");
        member2.setTeam(team1);
        em.persist(member2);
    }

    public void queryLogicJoin(EntityManager em){
        String jpql = "select m from Member m join m.team t where t.name=: teamName";

        List<Member> resultList = em.createQuery(jpql, Member.class)
                .setParameter("teamName", "팀1")
                .getResultList();

        for (Member member : resultList) {
            System.out.println(member.getUsername() + ", " + member.getTeam().getName());
        }
    }

    public void deleteRelation(EntityManager em){
        Member member1 = em.find(Member.class, "member1");
        System.out.println(member1.getUsername() + " 팀 탈퇴");
        member1.setTeam(null);
        System.out.println("member1.getTeam() = " + member1.getTeam());
    }

    public void biDirection(EntityManager em){
        Team team = em.find(Team.class, "team1");
        List<Member> members = team.getMembers();

        for (Member member : members) {
            System.out.println(member);
        }
    }

}
