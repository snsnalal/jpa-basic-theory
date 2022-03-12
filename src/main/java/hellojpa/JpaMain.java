package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class JpaMain {
    public static void main(String[] args) {

        //db랑 연결이 된다, 애플리케이션 로딩 시점에 딱 하나만 만들어야 한다.
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");//xml파일안에 있는 persistenceUnitName

        //트랜잭션 작업할 때마다 엔티티매니저 만들어 줘야한다.
        EntityManager em = emf.createEntityManager();

        //모든 작업은 트랜잭션 단위 안에서 이뤄져야한다.
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        
        try //정석, 실제로는 스프링에서 persist만 해주면 나머지 다 해줌
        {
            /*// 비영속 상태
            Member member = new Member();
            member.setId(101L);
            member.setName("HelloJPA");
           

            // 영속성 상태
            em.persist(member);*/

            /*
            Member findMember1 = em.find(Member.class, 101L); //1차 캐시에서 가져옴
            Member findMember2 = em.find(Member.class, 101L); //1과 2는 같은 객체

             */


            /*
            Member member = em.find(Member.class, 150L);
            member.setName("ZZZZZ"); //자동으로 업데이트됨
            */

            Member member = new Member(200L, "member200");
            em.persist(member);

            em.flush();//commit 전에 flush 되면서 바로 쿼리 반영됨


            /*Member findMember = em.find(Member.class, 1L);
            findMember.setName("HelloJPA");*/

            /*List<Member> result = em.createQuery("select m from Member m", Member.class)
                    .setFirstResult(1) //1번 부터 10개 가져오기(페이징)
                    .setMaxResults(10)
                    .getResultList(); //member 객체를 대상으로 쿼리를 한다.
            
            for (Member member : result)
            {
                System.out.println("member.getName() = " + member.getName());
            }*/

            //em.remove(findMember); 삭제
            //em.persist(member);
            tx.commit();
        } catch (Exception e)
        {
            tx.rollback();
        } finally {
            em.close();
        }
        
        emf.close();

    }
}
