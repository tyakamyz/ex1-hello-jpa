package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try{
            Team team = new Team();
            team.setName("팀팀");
            em.persist(team);

            Member member = new Member();
            member.setUsername("테스트맨");
            member.setTeam(team);

            em.persist(member);

            em.flush();
            em.clear();

            //Member findMember = em.find(Member.class, member.getId());
            //System.out.println("findMember = " + findMember.getUsername());

            Member findMember = em.find(Member.class, member.getId());

            System.out.println("====");
            System.out.println("team = " + findMember.getTeam().getName());
            System.out.println("====");

            tx.commit();

        }catch (Exception e){
            tx.rollback();
        }finally {
            em.close();
        }

        emf.close();
    }
}
