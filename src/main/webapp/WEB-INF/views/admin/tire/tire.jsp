<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="resources/css/admin/tire/admin_tire.css">
<link rel="stylesheet" href="resources/css/admin/board/notice_board.css">
</head>
<body>
	<input id="whatMenu" value="tire" type="hidden">
	<input id="sm" value="1" type="hidden"> 
	<div class="container sub">
		<div id="tire_container">

			<form action="admin.tire.search.do" class="tire_form">
				<div id="tire_searchBox">
					<div class="tire_searchTitle">
						<div>
							브랜드 <select id="tire_brand" name="tg_brand">
								<option value="1">전체</option>
								<option value="2">미쉐린타이어</option>
								<option value="3">금호타이어</option>
								<option value="4">콘티넨탈타이어</option>
								<option value="5">한국타이어</option>
								<option value="6">넥센타이어</option>
								<option value="7">요코하마타이어</option>
								<option value="8">브리지스톤타이어</option>
								<option value="9">굳이어타이어</option>
								<option value="10">던롭타이어</option>
								<option value="11">피렐리타이어</option>
								<option value="12">BF굿리치타이어</option>
							</select>
						</div>
					</div>
					<div class="tire_searchTitle">
						<div class="tire_searchID">
							<label for="tire_searchid">모델명</label> <input id="tire_Name"
								name="tg_name">
						</div>
					</div>
					<div id="searchBtn">
						<button>검색</button>
						<div id="admin_tire_reg"
							onclick="location.href='admin.tire.reg.go'">신규등록</div>
					</div>
				</div>
			</form>


			<table id="admin_tire_content">
				<tr>
					<td class="admin_tire_content_title admin_tire_no">No.</td>
					<td class="admin_tire_content_title admin_tire_brand">브랜드</td>
					<td class="admin_tire_content_title admin_tire_name">모델명</td>
					<td class="admin_tire_content_title admin_tire_print">출력</td>
					<td class="admin_tire_content_title admin_tire_sedanPrint">승용추천</td>
					<td class="admin_tire_content_title admin_tire_SUVPrint">SUV추천</td>
					<td class="admin_tire_content_title authadmin_tire_sizeNum_date">사이즈</td>
					<td class="admin_tire_content_title admin_tire_management">관리</td>
				</tr>
				<c:if test="${empty tires}">
					<tr>
						<td colspan="8">해당 타이어가 없습니다</td>
					</tr>

				</c:if>

				<c:forEach items="${tires }" var="t" varStatus="status">
					<tr id="admin_tires_content">
						<td class="admin_tire_table_td">${status.count + (curPage-1)*count}</td>
						<td class="admin_tire_table_td">${t.tg_brand }</td>
						<td class="admin_tire_table_td">${t.tg_name }</td>
						<td class="admin_tire_table_td">출력${t.tg_print }</td>
						<td class="admin_tire_table_td">세단${t.tg_sedan }</td>
						<td class="admin_tire_table_td">suv${t.tg_suv }
						<td class="admin_tire_table_td">${t.tg_num }개</td>
						<td id="auth_Btn" class="admin_tire_table_td">
							<button class="tire_update">수정</button>
							<button type="button">삭제</button>
						</td>
					</tr>
				</c:forEach>
			</table>


			<div id="paging-box">
				<c:if test="${curPage != 1 }">
					<a style="color: black;" href="tire.page.change?p=${curPage - 1 }">이전</a>
				</c:if>

				<c:forEach var="page" begin="1" end="${pageCount }">
					<c:choose>
						<c:when
							test="${page eq param.p or (curPage == 1 and curPage == page)}">
							<a style="color: white; background-color: #333;"
								href="tire.page.change?p=${page }" style="color: black">${page }
							</a>
						</c:when>
						<c:otherwise>
							<a style="color: black;" href="tire.page.change?p=${page }">${page }
							</a>
						</c:otherwise>
					</c:choose>
				</c:forEach>
				<c:if test="${curPage != pageCount }">
					<a style="color: black;" href="tire.page.change?p=${curPage + 1 }">다음</a>
				</c:if>
			</div>









		</div>
	</div>
</body>
</html>