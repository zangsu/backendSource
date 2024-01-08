package jpabook.practice;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "TEMP")
public class Temp {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    @Column(name = "NAME")
    String name;

    @Column(name="Date")
    LocalDate date;
}
