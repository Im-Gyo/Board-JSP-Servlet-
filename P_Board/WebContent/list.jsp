<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@  taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv = "Content-type" content = "text/html; charset=EUC-KR"> <%-- ����Ÿ�� �� ���� --%>
<title>Insert title here</title>
</head>
<body>

	<table width="500" cellpadding="0" cellspacing="0" border="1">
		<tr>
			<td>��ȣ</td>
			<td>�̸�</td>
			<td>����</td>
			<td>��¥</td>
			<td>��ȸ��</td>
		</tr>
		<c:forEach items="${list}" var = "dto">	<%--Arraylist ��� --%>
		<tr>
			<td>${dto.bId}</td>
			<td>${dto.Name}</td>
			<td>
				<c:forEach begin="1" end="${dto.bIndent}">-</c:forEach>
				<a href="content_view.do?bId=${dto.bId}">${dto.bTitle}</a></td>
			<td>${dto.bDate}</td>
			<td>${dto.bHit}</td>
		</tr>
		</c:forEach>
		<tr>
			<td colspans="5"><a href="write_view.do">���ۼ�</a></td>
	</table>

</body>
</html>