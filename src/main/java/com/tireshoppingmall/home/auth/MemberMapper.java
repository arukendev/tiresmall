package com.tireshoppingmall.home.auth;

import java.util.List;

import com.tireshoppingmall.home.order.MainOrderDTO;

public interface MemberMapper {

	int regMember(MemberDTO mDTO);

	String checkMember(MemberDTO mDTO);

	int checkIDkko(String kakaoID);

	AuthUserDTO getMember(MemberDTO mDTO);

	AuthUserDTO getSocialMember(String socialID);

	int regMemberSocial(MemberDTO mDTO);

	List<MainOrderDTO> getMyOrder(AuthUserDTO aDTO);


	int checkPw(MemberDTO mDTO);

	int deleteMember(int u_no);

	int updateInfo(MemberDTO mDTO);

	String idFind(AuthUserDTO aDTO);



}
