$(function() {
	
	//도/시 select선택상자
	AreaArry();
	
	branchRegImg();

	//비여있는지 검사
	emptyProsecutor();
	
	
	
	
	
	
	
	
	
	
})

function AreaArry() {

	var area0 = [ "시/도 선택", "서울특별시", "인천광역시", "대전광역시", "광주광역시", "대구광역시",
			"울산광역시", "부산광역시", "경기도", "강원도", "충청북도", "충청남도", "전라북도", "전라남도",
			"경상북도", "경상남도", "제주도" ];
	var area1 = [ "전체", "강남구", "강동구", "강북구", "강서구", "관악구", "광진구", "구로구", "금천구",
			"노원구", "도봉구", "동대문구", "동작구", "마포구", "서대문구", "서초구", "성동구", "성북구",
			"송파구", "양천구", "영등포구", "용산구", "은평구", "종로구", "중구", "중랑구" ];
	var area2 = [ "전체", "계양구", "남구", "남동구", "동구", "부평구", "서구", "연수구", "중구",
			"강화군", "옹진군" ];
	var area3 = [ "전체", "대덕구", "동구", "서구", "유성구", "중구" ];
	var area4 = [ "전체", "광산구", "남구", "동구", "북구", "서구" ];
	var area5 = [ "전체", "남구", "달서구", "동구", "북구", "서구", "수성구", "중구", "달성군" ];
	var area6 = [ "전체", "남구", "동구", "북구", "중구", "울주군" ];
	var area7 = [ "전체", "강서구", "금정구", "남구", "동구", "동래구", "부산진구", "북구", "사상구",
			"사하구", "서구", "수영구", "연제구", "영도구", "중구", "해운대구", "기장군" ];
	var area8 = [ "전체", "고양시", "과천시", "광명시", "광주시", "구리시", "군포시", "김포시",
			"남양주시", "동두천시", "부천시", "성남시", "수원시", "시흥시", "안산시", "안성시", "안양시",
			"양주시", "오산시", "용인시", "의왕시", "의정부시", "이천시", "파주시", "평택시", "포천시",
			"하남시", "화성시", "가평군", "양평군", "여주군", "연천군" ];
	var area9 = [ "전체", "강릉시", "동해시", "삼척시", "속초시", "원주시", "춘천시", "태백시", "고성군",
			"양구군", "양양군", "영월군", "인제군", "정선군", "철원군", "평창군", "홍천군", "화천군",
			"횡성군" ];
	var area10 = [ "전체", "제천시", "청주시", "충주시", "괴산군", "단양군", "보은군", "영동군",
			"옥천군", "음성군", "증평군", "진천군", "청원군" ];
	var area11 = [ "전체", "계룡시", "공주시", "논산시", "보령시", "서산시", "아산시", "천안시",
			"금산군", "당진군", "부여군", "서천군", "연기군", "예산군", "청양군", "태안군", "홍성군" ];
	var area12 = [ "전체", "군산시", "김제시", "남원시", "익산시", "전주시", "정읍시", "고창군",
			"무주군", "부안군", "순창군", "완주군", "임실군", "장수군", "진안군" ];
	var area13 = [ "전체", "광양시", "나주시", "목포시", "순천시", "여수시", "강진군", "고흥군",
			"곡성군", "구례군", "담양군", "무안군", "보성군", "신안군", "영광군", "영암군", "완도군",
			"장성군", "장흥군", "진도군", "함평군", "해남군", "화순군" ];
	var area14 = [ "전체", "경산시", "경주시", "구미시", "김천시", "문경시", "상주시", "안동시",
			"영주시", "영천시", "포항시", "고령군", "군위군", "봉화군", "성주군", "영덕군", "영양군",
			"예천군", "울릉군", "울진군", "의성군", "청도군", "청송군", "칠곡군" ];
	var area15 = [ "전체", "거제시", "김해시", "마산시", "밀양시", "사천시", "양산시", "진주시",
			"진해시", "창원시", "통영시", "거창군", "고성군", "남해군", "산청군", "의령군", "창녕군",
			"하동군", "함안군", "함양군", "합천군" ];
	var area16 = [ "전체", "서귀포시", "제주시", "남제주군", "북제주군" ];

	// 시/도 선택 박스 초기화

	$("select[name^=b_area1]").each(function() {
		$selsido = $(this);
		$.each(eval(area0), function() {
			$selsido.append("<option value='" + this + "'>" + this
					+ "</option>");
		});
		$selsido.next().append("<option value=''>구/군 선택</option>");
	});

	// 시/도 선택시 구/군 설정

	$("select[name^=b_area1]").change(function() {
		var area = "area" + $("option", $(this)).index($("option:selected", $(this))); // 선택지역의
			// 구군
			// Array
		var $gugun = $(this).next(); // 선택영역 군구 객체
		$("option", $gugun).remove(); // 구군 초기화
		if (area == "area0")
			$gugun.append("<option value=''>구/군 선택 </option>");
		else {
			$.each(eval(area), function() {
				$gugun.append("<option value='" + this + "'>" + this
				+ "</option>");
			});
		}

	});
	
	$(".branchsearchButton").click(function() {
		let b_area = $("#listsido1").val();
		if ($("#listgugun1").val() != "전체") {
			b_area += $("#listgugun1").val()
		}

		$("#hidden_b_area").val(b_area);
		if ($("#hidden_b_area").val() == "시/도 선택") {
			$("#hidden_b_area").val("");
		}
	})
	$(".admin-store-reg-button").click(function() {
		let b_area = $("#storeRegDo").val();
		if ($("#storeRegSi").val() != "전체") {
			b_area += $("#storeRegSi").val()
		}

		$("#hiddenStoreReg_b_area").val(b_area);
		if ($("#hiddenStoreReg_b_area").val() == "시/도 선택") {
			$("#hiddenStoreReg_b_area").val("");
		}
	})
	

	//업데이트  $("#hiddenB_id").val() 이 숫자이면 true 아니면 false
	if($.isNumeric($("#hiddenB_id").val())){
		let b_sortation = $("#hiddenB_sortation").val();
		let b_id = $("#hiddenB_id").val();
		let b_area = $("#hiddenB_area").val();

		let b_area1;
		let b_area2;
		
		//구분 체크드
		if(b_sortation=="직영점 (당일 장착점)"){
			$(".partnership").prop("checked", false)
			$(".directManagement").prop("checked", true);
		}
		//지역 구하기
		for (var i = 0; i < area0.length; i++) {
			if(b_area.includes(area0[i])){	
				b_area1 = area0[i];
				b_area2 = b_area.replace(area0[i],"");
			}
		}
		$("#storeRegDo").append("<option selected='selected'>" + b_area1 + "</option>");
		$("#storeRegSi").append("<option selected='selected'>" + b_area2 + "</option>");
		
		$(".admin-store-reg-button").text("저장");
		$("#admin_store_table_container").attr("action", "admin.store.update.do");
		//theForm.action = "test01.asp";
		$(".admin-store-reg-button").click(function() {
			if($("#file1").val()==""){
				$("#file1").remove();
			}
		})
		
		
		
	}
}

function branchRegImg() {
	let formData = new FormData();
	$("#file1").on('change',function(e){
		var arSplitUrl = $("#file1").val().split("\\");
		var nArLength = arSplitUrl.length;
		var fileName = arSplitUrl[nArLength-1];
		$(".upload-name1").val(fileName);
		
		
		//사진 미리보기
		var files = e.target.files;
		var filesArr = Array.prototype.slice.call(files);

		filesArr.forEach(function(f) {
			if(!f.type.match("image.*")){
				alert("이미지 파일만 업로드 가능합니다.");
				return;
			}
			var sel_file =f;
	
			var reader = new FileReader();
			reader.onload = function(e) {
				$("#imagePreview").attr('src',e.target.result);
				
			}
			reader.readAsDataURL(f);
		})

	});
	

	$("#file2").on('change',function(e){
		var arSplitUrl = $("#file2").val().split("\\");
		var nArLength = arSplitUrl.length;
		var fileName = arSplitUrl[nArLength-1];
		$(".upload-name2").val(fileName);
		
		
		//사진 미리보기
		var files = e.target.files;
		var filesArr = Array.prototype.slice.call(files);

		filesArr.forEach(function(f) {
			if(!f.type.match("image.*")){
				alert("이미지 파일만 업로드 가능합니다.");
				return;
			}
			var sel_file =f;
	
			var reader = new FileReader();
			reader.onload = function(e) {
				$("#imagePreview2").attr('src',e.target.result);
				
			}
			reader.readAsDataURL(f);
		})

	});
	
	
	
}
function emptyProsecutor() {
	$(".admin-store-reg-button").click(function() {
		if(!$.isNumeric($("#hiddenB_id").val())){
			if($("#hiddenStoreReg_b_area").val()==""){
				alert("지역을 선택해주세요");
				return false;
			}
			if($("#file1").val()==""){
				alert("사진을 업로드해주세요");
				return false;
			}
		}
	})
}

function deletebranch(iddd) {
	let ok = confirm('정말 삭제하시겠습니까?');
	if (ok) {
		location.href = 'admin.store.delete.go?b_id=' + iddd;
	}
}


