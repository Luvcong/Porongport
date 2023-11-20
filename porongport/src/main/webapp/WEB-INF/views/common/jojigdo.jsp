<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>조직도</title>
    <!-- CSS -->
    <link rel="stylesheet" href="resources/css/jojigdo.css">

</head>
<body>
	<jsp:include page="../common/sidebar.jsp" />

	<div class="pp-content">
	
	    <div class="outer">
	        
	        <div id="jojigdo">
	            <h2>
	            	<b>${ jojigdoList[0].deptName }</b> 조직도
	            </h2>
	            <!-- <span>20명</span> -->
	
	            <div id="jojigdo_chart">
	                <table class="table table-bordered">
	                    <thead>
	                        <tr>
	                            <th>직급</th>
	                            <th>이름</th>
	                        </tr>
	                    </thead>
	                    <tbody>
	                    	<c:choose>
	                    		<c:when test="${ not empty jojigdoList }">
	                    			<c:forEach var="i" items="${ jojigdoList }">
				                        <tr>
				                            <td>${ i.jobName }</td>
				                            <td>${ i.empName }</td>
				                        </tr>
	                    			</c:forEach>
	                    		</c:when>
	                    		<c:otherwise>
	                    			<tr>
	                    				<td>해당 부서에는 직원이 존재하지 않습니다.</td>
	                    			</tr>
	                    		</c:otherwise>
	                    	</c:choose>
	                    </tbody>
	                </table>
	            </div>
		    </div>
		</div>
	</div>
</body>
</html>