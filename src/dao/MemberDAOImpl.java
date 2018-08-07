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
	public void insertMemberBean(MemberBean member) {
		try {
			DatabaseFactory.createDatabase(Vendor.ORACLE, DBConstant.USER_NAME, DBConstant.PASSWORD)
			.getConnection().createStatement().executeUpdate(
					String.format(MemberQuery.INSERT_MEMBER.toString()
							,member.getUserId()
							,member.getName()
							,member.getSsn()
							,member.getPassword()
							,member.getGender()
							,member.getAge()
							,member.getRoll()
							,member.getTeamId()));
			
		} catch (Exception e) {
		
			e.printStackTrace();
		}
	}

	@Override
	public List<MemberBean> selectAllMember() {
		List<MemberBean> list= new ArrayList<>();
		try {
			ResultSet rs = DatabaseFactory.createDatabase(Vendor.ORACLE, DBConstant.USER_NAME, DBConstant.PASSWORD)
					.getConnection()
					.createStatement()
					.executeQuery(
							MemberQuery.SELECT_ALL.toString());
			
			MemberBean mem = null;
			while(rs.next()) {
				mem = new MemberBean();
				mem.setUserId(rs.getString("USERID"));
				mem.setTeamId(rs.getString("TEAMID"));
				mem.setName(rs.getString("NAME"));
				mem.setSsn(rs.getString("SSN"));
				mem.setRoll(rs.getString("ROLL"));
				mem.setPassword(rs.getString("PASSWORD"));
				mem.setGender(rs.getString("GENDER"));
				mem.setAge(rs.getString("AGE"));
				list.add(mem);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}
//	@Override
//	public List<MemberBean> selectAllList(Map<?, ?> param) {
//		List<MemberBean> list1=new ArrayList<>(); 
//		try {
//			String sql=String.format(MemberQuery.SELECT_LIST.toString(), param.get("beginRow"),param.get("endRow"));
//		
//			System.out.println(sql);
//			ResultSet rs = DatabaseFactory.createDatabase(Vendor.ORACLE,DBConstant.USER_NAME ,DBConstant.PASSWORD)
//					.getConnection().createStatement().executeQuery(sql);
//			MemberBean mem = null;
//			while(rs.next()) {
//				mem = new MemberBean();
//				mem.setUserId(rs.getString("USERID"));
//				mem.setTeamId(rs.getString("TEAMID"));
//				mem.setName(rs.getString("NAME"));
//				mem.setSsn(rs.getString("SSN"));
//				mem.setRoll(rs.getString("ROLL"));
//				mem.setPassword(rs.getString("PASSWORD"));
//				mem.setGender(rs.getString("GENDER"));
//				mem.setAge(rs.getString("AGE"));
//				list1.add(mem);
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//
//
//		String beginRow = (String) param.get("beginRow");
//		System.out.println("-----시작 하는 행--------" +beginRow );
//		String endRow = (String) param.get("endRow");
//		System.out.println("-----마지막 행--------" +endRow);	
//		System.out.println(list1);
//		return list1;
//	}
	@Override
	public List<MemberBean> selectAllList(Map<?, ?> param) {
		QueryTemplate q = new PstmtQuery();
		List<MemberBean> list1=new ArrayList<>(); 
		HashMap<String, Object> map = new HashMap<>();
		String beginRow = (String) param.get("beginRow");
		System.out.println("-----시작 하는 행--------" +beginRow );
		String endRow = (String) param.get("endRow");
		System.out.println("-----마지막 행--------" +endRow);	
		map.put("beginRow", beginRow);
		map.put("endRow", endRow);
		map.put("query", MemberQuery.SELECT_LIST);
		q.play(map);
		for(Object s:q.getList()) {
			list1.add((MemberBean) s);
		}
		System.out.println(list1);
		return list1;
	}
	@Override
	public List<MemberBean> selectByName(String name) {
		QueryTemplate q = new PstmtQuery();
		List<MemberBean> list = new ArrayList<>();
		HashMap<String ,Object> map = new HashMap<>();
		//요고요고 틀렸어, Search Command에서 search랑 search option한 문자열로 합칠때 순서가
		//입력한 문자가 index 0번째에, 컬럼명이 index 1번째로 해서 합쳤는데
		//여기 와서 map에 넣어줄때 반대로 넣었어, 요롷게 되어있었어!ㅋㅋㅋㅋ
		/*map.put("column", name.split("/")[0]);
		map.put("value", name.split("/")[1]);*/
		map.put("column", name.split("/")[1]);
		map.put("value", name.split("/")[0]);
		map.put("table", Domain.MEMBER);
		map.put("query",MemberQuery.SELECT_SOME );
		q.play(map);
		for(Object s:q.getList()) {
			list.add((MemberBean) s);
		}
		
	return list;
	}

	@Override
	public MemberBean selectById(String id) {
		MemberBean mem = null;
		try {
			ResultSet rs = DatabaseFactory.createDatabase(Vendor.ORACLE, DBConstant.USER_NAME, DBConstant.PASSWORD)
					.getConnection()
					.createStatement()
					.executeQuery(String.format(MemberQuery.SEARCH_BY_ID.toString(), id ));
			while(rs.next()) {
				mem = new MemberBean();
				mem.setName(rs.getString("NAME"));
				mem.setSsn(rs.getString("SSN"));
				mem.setUserId(rs.getString("USERID"));
				mem.setTeamId(rs.getString("TEAMID"));
				mem.setPassword(rs.getString("PASSWORD"));
				mem.setRoll(rs.getString("ROLL"));
				mem.setGender(rs.getString("GENDER"));
				mem.setAge(rs.getString("AGE"));
				
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return mem;
	}

	@Override
	public int countMember() {
		int count = 0;
		try {
			ResultSet rs = DatabaseFactory.createDatabase(Vendor.ORACLE, DBConstant.USER_NAME, DBConstant.PASSWORD)
						   .getConnection()
						   .createStatement()
						   .executeQuery(MemberQuery.COUNT_MEMBER.toString());
			
			while(rs.next()) {
				count = rs.getInt("count");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}

	@Override
	public void updateMember(MemberBean member) {
		try {
			DatabaseFactory
			.createDatabase(Vendor.ORACLE, DBConstant.USER_NAME,DBConstant.PASSWORD)
			.getConnection()
			.createStatement()
			.executeUpdate(
					String.format(MemberQuery.UPDATE_MEMBER.toString(), member.getPassword().split("/")[1],member.getTeamId(),member.getRoll(), member.getUserId(), member.getPassword().split("/")[0])
					);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void deleteMember(MemberBean member) {
		try {
			DatabaseFactory.createDatabase(Vendor.ORACLE,DBConstant.USER_NAME , DBConstant.PASSWORD)
			.getConnection().createStatement().executeQuery(String.format(MemberQuery.DELETE_MEMBER.toString(), member.getUserId(),member.getPassword()));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	// <!-- "oracle.jdbc.driver.OracleDriver" -->
	// <!-- "jdbc:oracle:thin:@localhost:1521:xe" -->
	// <!-- "wldms" -->
	// <!-- "wldms0828" -->
	@Override
	public MemberBean login(MemberBean member) {
		MemberBean mem = null;
		try {

			System.out.println("멤버 파라미터" + member.getUserId());
			System.out.println("멤버 파라미터" + member.getPassword());
			ResultSet rs = DatabaseFactory
						   .createDatabase(Vendor.ORACLE
						   , DBConstant.USER_NAME
						   , DBConstant.PASSWORD)
						   .getConnection()
						   .createStatement()
						   .executeQuery(
							String.format(MemberQuery.LOGIN.toString()
						   , member.getUserId(), member.getPassword()));
			
			while (rs.next()) {
				mem = new MemberBean();
				mem.setUserId(rs.getString("MEM_ID"));
				mem.setTeamId(rs.getString("TEAM_ID"));
				mem.setPassword(rs.getString("PASSWORD"));
				mem.setName(rs.getString("NAME"));
				mem.setSsn(rs.getString("SSN"));	
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mem;
	}

	@Override
	public MemberBean join(MemberBean member) {
		MemberBean mem2 = null;
		try {
			ResultSet rs = DatabaseFactory.createDatabase(Vendor.ORACLE, 
						   DBConstant.USER_NAME, 
						   DBConstant.PASSWORD)
						   .getConnection()
						   .createStatement()
						   .executeQuery(String.format(MemberQuery.JOIN.toString()
						   ,member.getUserId(), member.getPassword()
						   ,member.getSsn(), member.getName()));
			if (rs.next()) {
				mem2 = new MemberBean();
				mem2.setUserId(rs.getString("USERID"));
				mem2.setPassword(rs.getString("PASSWORD"));
				mem2.setSsn(rs.getString("SSN"));
				mem2.setName(rs.getString("NAME"));
			}
		} catch (Exception e) {

			e.printStackTrace();
		}

		return mem2;
	}

}
