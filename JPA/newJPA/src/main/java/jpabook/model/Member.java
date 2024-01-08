package jpabook.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/*@Entity
@Table(name = "ch4-member")
@Getter
@Setter*/
public class Member {

    @Id
    @GeneratedValue
    @Column(name = "MEMBER_ID")
    private Long id;

    private String name;


}
