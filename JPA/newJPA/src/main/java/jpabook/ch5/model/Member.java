package jpabook.ch5.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "CH5_MEMBER")
public class Member {
    @Id
    @Column(name = "MEMBER_ID")
    private String id;

    private String username;

    @ManyToOne
    @JoinColumn(name = "TEAM_ID")
    private Team team;

    public Member(String id, String username) {
        this.id = id;
        this.username = username;
    }

    @Override
    public String toString() {

        String teamName = "null";
        if(team!= null)
            teamName = this.team.getName();
        return "Member{" +
                "id='" + id + '\'' +
                ", username='" + username + '\'' +
                ", team=" + teamName +
                '}';
    }
}
