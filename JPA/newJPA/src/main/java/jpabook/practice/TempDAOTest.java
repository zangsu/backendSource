package jpabook.practice;

import jpabook.ch5.dao.MemberDAO;
import jpabook.ch5.model.Member;
import jpabook.ch5.model.Team;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;
import java.util.function.Consumer;

class TempDAOTest {


    TempDAO tempDAO = new TempDAO();//given

    @Test
    @Transactional
    public void save(){
        Temp temp = new Temp();
        temp.name = "temp";
        temp.date = LocalDate.now();
        //when

        tempDAO.save(temp);

        //then
    }
}