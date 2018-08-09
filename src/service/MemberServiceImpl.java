package service;

import java.util.*;
import dao.*;
import domain.*;

public class MemberServiceImpl implements MemberService{
	private static MemberService instance = new MemberServiceImpl();
	public static MemberService getInstance() {return instance;}
	private MemberServiceImpl() {}
	@Override
	public void add(MemberBean member) {
		MemberDAOImpl.getInstance().insert(member);
		
	}
	@Override
	public List<MemberBean> search(Map<?, ?> param) {
		System.out.println("4.serviceImpl List");
		return MemberDAOImpl.getInstance().selectSome(param);
	}
	@Override
	public MemberBean retrive(String id) {
		return MemberDAOImpl.getInstance().selectOne(id);
	}
	@Override
	public int count() {
		return MemberDAOImpl.getInstance().count();
	}
	@Override
	public void modify(Map<?, ?> param) {
		MemberDAOImpl.getInstance().update(param);
		
	}
	@Override
	public void remove(MemberBean member) {
		MemberDAOImpl.getInstance().delete(member);
		
	}


	@Override
	public boolean login(MemberBean member) {
		return false;
	}

	
}
