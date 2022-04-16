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
            /* 비영속: JPA와 연관이 없는 상태 */
            Member member = new Member(77L,"7777");

            /* 영속: JPA와 영속 상태 */
            em.persist(member);

            /* 준영속 상태 테스트 */
            Member member2 = em.find(Member.class, 3L);
            member2.setName("ZZZZZZ");

            em.clear();

            System.out.println("===============");

            tx.commit();

        }catch (Exception e){
            tx.rollback();
        }finally {
            em.close();
        }

        emf.close();
    }
}
