<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="include/top.html"%>
<%@ page import="com.rubypaper.controller.*"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h2 align=center>
		<a href="index.html">목록보기</a>
	</h2>
	<table align=center border=1>
		<tr>
			<td>idx</td>
			<td>이름</td>
			<td>나이</td>
			<td>메모</td>
			<td>날짜</td>
		</tr>
		<c:forEach var="m" items="${li}">
			<tr>
				<td>${m.idx}</td>
				<td>${m.name}</td>
				<td>${m.age}</td>
				<td>${m.memo}</td>
				<td>${m.regdate}</td>
			</tr>
		</c:forEach>
	</table>
	<br>
	<form action=/list align=center>
	  <input type=hidden name=start  value="1"  size=2> 
	  <select  name=ch1>
	   <option value="name"> 이름 </option>
	   <option value="memo"> 메모 </option>  
	  </select>
	  <input  type=text  name=ch2 >
	  <input  type=submit value="검색하기" >
	 </form>
	<br>
	<div align = center>
        <!-- 처음페이지 링크 -->
        <a href="${pageContext.request.contextPath}/list?start=1&ch1=${ch1}&ch2=${ch2}">처음페이지</a>
        
        <!-- 이전10페이지 링크 -->
        <c:if test="${listStartPage > pageListSize}">
            <c:set var="start" value="${(listStartPage - pageListSize - 1) * pageSize + 1}" />
            <a href="${pageContext.request.contextPath}/list?start=${start}&ch1=${ch1}&ch2=${ch2}">이전10페이지</a>
        </c:if>
        
        <!-- 이전10페이지 비활성화 -->
        <c:if test="${listStartPage <= pageListSize}">
            이전10페이지
        </c:if>
        
        <!-- 페이지 번호 링크 -->
        <c:forEach var="i" begin="${listStartPage}" end="${listEndPage}">
            <c:set var="start" value="${(i - 1) * pageSize + 1}" />
            <c:if test="${i <= totalPage}">
                <a href="${pageContext.request.contextPath}/list?start=${start}&ch1=${ch1}&ch2=${ch2}">[${i}]</a>
            </c:if>
        </c:forEach>
        
        <!-- 다음10페이지 링크 -->
        <c:if test="${listEndPage < totalPage}">
            <c:set var="start" value="${listEndPage * pageSize + 1}" />
            <a href="${pageContext.request.contextPath}/list?start=${start}&ch1=${ch1}&ch2=${ch2}">다음10페이지</a>
        </c:if>
        
        <!-- 다음10페이지 비활성화 -->
        <c:if test="${listEndPage >= totalPage}">
            다음10페이지
        </c:if>
        
        <!-- 마지막페이지 링크 -->
        <c:set var="endPage" value="${lastPage}" />
        <a href="${pageContext.request.contextPath}/list?start=${endPage}&ch1=${ch1}&ch2=${ch2}">마지막페이지</a>
    </div>
	<br>
</body>
</html>
