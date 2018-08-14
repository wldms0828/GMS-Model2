package dao;

import java.sql.*;
import java.util.*;

import command.AddCommand;
import domain.MemberBean;
import enums.Domain;
import enums.MemberQuery;
import enums.Vendor;
import factory.*;
import pool.*;
import template.AddQuery;
import template.CountQuery;
import template.LoginQuery;
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
		q=new AddQuery();
		Map<String, Object> map = new HashMap<>();
		map.put("USERID", member.getUserId());
		map.put("PASSWORD", member.getPassword());
		map.put("NAME", member.getName());
		map.put("AGE", member.getAge());
		map.put("GENDER", member.getGender());
		map.put("ROLL", member.getRoll());
		map.put("SSN", member.getSsn());
		map.put("TEAMID", member.getTeamId());
		q.play(map);

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
		Map<String, Object> map = new HashMap<>();
		map.put("USERID", id);
		q.play(map);
		System.out.println("++++++++++ MemberBean selectOne ++++++++++++");
		System.out.println((MemberBean) q.getO());
		return (MemberBean) q.getO();
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
		q= new LoginQuery();
		Map<String, Object> map = new HashMap<>();
		map.put("USERID", member.getUserId());
		map.put("PASSWORD", member.getPassword());
		q.play(map);
		
		return (MemberBean) q.getO();
	}

	

}
