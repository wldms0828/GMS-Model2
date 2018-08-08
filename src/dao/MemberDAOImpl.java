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
		// TODO Auto-generated method stub
		return null;
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
