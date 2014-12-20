<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<table border="1">
	<tr>
		<th>1</th>
		<th>2</th>
		<th>3</th>
		<th>4</th>
		<th>5</th>
		<th>6</th>
		<th>7</th>
		<th>8</th>
		<th>9</th>
		<th>10</th>
		<th>11</th>
		<th>12</th>
		<th>13</th>
		<th>14</th>
		<th>15</th>
	</tr>
	<c:forEach items="${imgBbsList}" var="imgBbs">
	<tr>
		<td>${imgBbs.idx}</td>
		<td>${imgBbs.subject}</td>
		<td>${imgBbs.writer}</td>
		<td>${imgBbs.content}</td>
		<td>${imgBbs.regTimestamp}</td>
		<td>${imgBbs.modTimestamp}</td>
		<td>${imgBbs.hit}</td>
		<td>${imgBbs.ip}</td>
		
		<c:forEach items="${imgBbs.imgBbsFileList}" var="imgBbsFile">
			<td>${imgBbsFile.fileIdx}</td>
			<td>${imgBbsFile.regDate}</td>
			<td>${imgBbsFile.fileSize}</td>
			<td>${imgBbsFile.fileName}</td>
			<td>${imgBbsFile.fileType}</td>
			<td>${imgBbsFile.tempFileName}</td>
			<td>${imgBbsFile.deleteYn}</td>
		</c:forEach>
	</tr>
	</c:forEach>
	<tr>
		<td colspan="15" align="center">
			<c:if test="${paging.getCurBlock() > 1}">
				[이전]
			</c:if>
			
			<c:forEach var="i" begin="${paging.getFirstPage()}" end="${paging.getLastPage()}">
				${i}
			</c:forEach>
			
			<c:if test="${paging.getCurBlock() < paging.getPageBlockCnt()}">
				[다음]
			</c:if>
		</td>
	</tr>
</table>
