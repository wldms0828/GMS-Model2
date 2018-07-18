package dao;

import java.util.List;

import domain.RecordBean;

public class RecordDAOImpl implements RecordDAO {
	private static RecordDAO instance = new RecordDAOImpl();
	public static RecordDAO getInstance() {return instance;}
	private RecordDAOImpl() {}
	@Override
	public void insertRecordBean(RecordBean record) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<RecordBean> selectAllExam() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<RecordBean> selectByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RecordBean selectById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int countExam() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void updateExam(RecordBean record) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteExam(RecordBean record) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public String selectFirstRownum() {
		// TODO Auto-generated method stub
		return null;
	}

}
