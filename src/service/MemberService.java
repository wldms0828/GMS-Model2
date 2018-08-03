package service;
import domain.*;
import java.util.*;
public interface MemberService {
	public void createMember(MemberBean member);
	public List<MemberBean> listMember();
	public List<MemberBean> findMemberByName(String name);

	public MemberBean findMemberById(String id);
	public int countMember();
	public void updateMember(MemberBean member);
	public void deleteMember(MemberBean member);
	public boolean login(MemberBean member);
	public MemberBean join(MemberBean member);
	
}
