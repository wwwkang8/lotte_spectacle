<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script type="text/javascript">
	alert("아이디, 비밀번호를 다시 확인해주십시오");
	location.href="${pageContext.request.contextPath}/index.do";
</script>