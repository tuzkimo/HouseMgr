<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>列表</title>
</head>
<body>
	<p>你好，${session.username }</p>
	<!-- 搜索栏 -->
	<form action="search.action" method="post">
		<label for="title">标题：</label><input type="text" name="title" id="title" value="${param.title }" style="width: 100px">
		<label for="startPrice">房价：</label><input type="text" name="startPrice" id="startPrice" value="${param.startPrice }" style="width: 100px">~
		<input type="text" name="endPrice" id="endPrice" value="${param.endPrice }" style="width: 100px">
		<label for="startDate">发布时间：</label><input type="text" name="startDate" id="startDate" value="${param.startDate }" style="width: 100px">~
		<input type="text" name="endDate" id="endDate" value="${param.endDate }" style="width: 100px">
		<input type="submit" value="搜索">
	</form>
	<!-- 内容 -->
	<c:forEach items="${requestScope.pageInfo.pageList }" var="house">
		${house.id }~${house.name }~${house.price }~${house.pubdate }<br>
	</c:forEach><br>
	<!-- 导航栏 -->
	总记录数：${requestScope.pageInfo.count }&nbsp;&nbsp;&nbsp;&nbsp;
	当前第&nbsp;${requestScope.pageInfo.pageIndex }&nbsp;页/共&nbsp;${requestScope.pageInfo.totalPages }&nbsp;页&nbsp;&nbsp;&nbsp;&nbsp;
	<c:if test="${requestScope.pageInfo.pageIndex > 1 }">
		<a href="javascript:goPage(${requestScope.pageInfo.pageIndex-1 })">上一页</a>
	</c:if>&nbsp;&nbsp;
	<c:if test="${requestScope.pageInfo.pageIndex < requestScope.pageInfo.totalPages }">
		<a href="javascript:goPage(${requestScope.pageInfo.pageIndex+1 })">下一页</a>
	</c:if>
	<script>
		function goPage(pageIndex){
			document.forms[0].action="search.action?pageIndex="+pageIndex;
			document.forms[0].submit();
		}
	</script>
</body>
</html>