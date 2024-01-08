package jpabook.ch5;

import jpabook.ch5.dao.MemberDAO;
import jpabook.start.Member;

public class Main {
    public static void main(String[] args) {
        MemberDAO memberDAO = new MemberDAO();

        memberDAO.execute(memberDAO::testSave);
        //memberDAO.execute(memberDAO::deleteRelation);
        //memberDAO.execute(memberDAO::queryLogicJoin);
        memberDAO.execute(memberDAO::biDirection);

    }
}
