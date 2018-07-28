<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script type="text/javascript">
	alert(" ${requestScope.memberVO.name}님 환영합니다!");
	location.href="${pageContext.request.contextPath}/index.do";
</script>
</script>