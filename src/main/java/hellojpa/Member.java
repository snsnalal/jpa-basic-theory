package hellojpa;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity //jpa 사용하는 애라고 인식
//@Table(name = "") 테이블과 매핑해줌
public class Member {

    @Id //pk가 누군지
    private Long id;

    //@Column DB 필드와 매핑해줌
    private String name;

    public Member() {
    }

    public Member(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
