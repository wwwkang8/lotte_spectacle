<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script type="text/javascript">
	alert("세션이 만료되었습니다. 다시 로그인 해주세요");
	location.href="${pageContext.request.contextPath}/index.do";
</script>