package dao;

import java.sql.*;
import java.util.*;

import domain.MemberBean;
import enums.Domain;
import enums.MemberQuery;
import enums.Vendor;
import factory.*;
import pool.*;
import template.PstmtQuery;
import template.QueryTemplate;

public class MemberDAOImpl implements MemberDAO {
	private static MemberDAO instance = new MemberDAOImpl();
	public static MemberDAO getInstance() {return instance;}
	private MemberDAOImpl() {}
	@Override
	public void insert(MemberBean member) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public List<MemberBean> selectSome(Map<?, ?> param) {
		QueryTemplate q = new PstmtQuery();
		List<MemberBean> list=new ArrayList<>(); 
		HashMap<String, Object> map = new HashMap<>();
		String beginRow = (String) param.get("beginRow");
		System.out.println("5. DAO : " +beginRow );
		String endRow = (String) param.get("endRow");
		System.out.println("6. DAO : " +endRow);	
		String sql = MemberQuery.SEARCH.toString();
		map.put("beginRow", beginRow);
		map.put("endRow", endRow);
/*
 * 
 * map.put("query", MemberQuery.LIST);
		map.put("column", null);
		map.put("value", null);
		map.put("table", Domain.MEMBER);		
		map.put("query",MemberQuery.SEARCH );*/
		q.play(map);
		for(Object s:q.getList()) {
			list.add((MemberBean) s);
		}
		return list;
	}
	@Override
	public MemberBean selectOne(String id) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public int count() {
		// TODO Auto-generated method stub
		return 0;
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
