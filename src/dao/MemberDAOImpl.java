package dao;

import java.sql.*;
import java.util.*;

import domain.MemberBean;
import enums.Domain;
import enums.MemberQuery;
import enums.Vendor;
import factory.*;
import pool.*;
import template.CountQuery;
import template.PstmtQuery;
import template.QueryTemplate;
import template.RetriveQuery;
import template.SearchQuery;

public class MemberDAOImpl implements MemberDAO {
	private static MemberDAO instance = new MemberDAOImpl();
	public static MemberDAO getInstance() {return instance;}
	private MemberDAOImpl() {}
	private QueryTemplate q = null;
	@Override
	public void insert(MemberBean member) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public List<MemberBean> selectSome(Map<?, ?> param) {
		q = new SearchQuery();
		List<MemberBean> list=new ArrayList<>(); 
		q.play(param);
		for(Object s:q.getList()) {
			list.add((MemberBean) s);
		}
		System.out.println("DAO list" + list);
		return list;
	}
	@Override
	public MemberBean selectOne(String id) {
		q=new RetriveQuery();
		MemberBean mem = new MemberBean();
		Map<String, Object> map = new HashMap<>();
		map.put("USERID", id);
		q.play(map);
		return mem;
	}
	@Override
	public int count() {
		q = new CountQuery();
		q.play();
		return q.getNumber();
	}
	@Override
	public void update(Map<?, ?> param) {

		
	}
	@Override
	public void delete(MemberBean member) {

		
	}
	@Override
	public MemberBean login(MemberBean member) {
		MemberBean mem = new MemberBean();
		return mem;
	}

	

}
