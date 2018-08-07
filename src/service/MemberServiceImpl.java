package service;

import java.util.*;
import dao.*;
import domain.*;

public class MemberServiceImpl implements MemberService{
	private static MemberService instance = new MemberServiceImpl();
	public static MemberService getInstance() {return instance;}
	private MemberServiceImpl() {}
	@Override
	public void createMember(MemberBean member) {
		MemberDAOImpl.getInstance().insertMemberBean(member);
	}

	@Override
	public List<MemberBean> listMember() {
		
		return MemberDAOImpl.getInstance().selectAllMember();
	}

	@Override
	public List<MemberBean> findMemberByName(String name) {
		return MemberDAOImpl.getInstance().selectByName(name);
	}

	@Override
	public MemberBean findMemberById(String id) {
		return MemberDAOImpl.getInstance().selectById(id);
	}

	@Override
	public int countMember() {
		return MemberDAOImpl.getInstance().countMember();
	}

	@Override
	public void updateMember(MemberBean member) {
		MemberDAOImpl.getInstance().updateMember(member);
		
	}

	@Override
	public void deleteMember(MemberBean member) {
		MemberDAOImpl.getInstance().deleteMember(member);
		
	}
	@Override
	public boolean login(MemberBean member) {
		boolean flag = false;
		if(MemberDAOImpl.getInstance().login(member)!=null) {
			flag=true;
		}
		
		return  flag;
	}
	@Override
	public MemberBean join(MemberBean member) {
		return MemberDAOImpl.getInstance().join(member);
	}
	@Override
	public List<MemberBean> getList(Map<?, ?> param) {
		return MemberDAOImpl.getInstance().selectAllList(param);
	}

	
}
