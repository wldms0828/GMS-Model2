package dao;

import java.util.List;

import domain.MemberBean;

public interface MemberDAO {
	public void insertMemberBean(MemberBean member); 
	public List<MemberBean> selectAllMember();
	public List<MemberBean> selectByName(String name);
	public MemberBean selectById(String id);
	public int countMember();
	public void updateMember(MemberBean member);
	public void deleteMember(MemberBean member);
	public MemberBean login(MemberBean member); //비밀번호 감춰서 보내려고 만들었다.
	public MemberBean join(MemberBean member);
}
