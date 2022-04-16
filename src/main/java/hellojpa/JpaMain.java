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
            Member member = new Member(5L,"testMan3");

            /* 영속: JPA와 영속 상태 */
            em.persist(member);
            /* commit 전까진 DB에 넣지않음 */

            /* 수정도 마찬가지 */
            Member member2 = em.find(Member.class, 3L);
            member2.setName("testMan2");

            tx.commit();

        }catch (Exception e){
            tx.rollback();
        }finally {
            em.close();
        }

        emf.close();
    }
}
