<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="hello.servlet.domain.member.Member" %>
<%@ page import="hello.servlet.domain.member.MemberRepository" %>
<%
    //request, response는 사용가능하다. 왜? 결국 JSP 역시 서블릿으로 변환되기 때문

    MemberRepository memberRepository = MemberRepository.getInstance();

    String username = request.getParameter("username");
    int age = Integer.parseInt(request.getParameter("age"));

    Member member = new Member(username, age);
    memberRepository.save(member);
%>
<html>
<head>
    <title>Title</title>
</head>
<body>
성공
<ul>
    <li> id=<%=member.getId()%> </li>
    <li> username=<%=member.getUsername()%> </li>
    <li> age=<%=member.getAge()%> </li>
</ul>
<a href="/index.html">메인</a>
</body>
</html>
