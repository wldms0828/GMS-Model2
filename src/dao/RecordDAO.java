package dao;

import java.util.List;

import domain.RecordBean;

public interface RecordDAO {
	public void insertRecordBean(RecordBean record); 
	public List<RecordBean> selectAllExam();
	public List<RecordBean> selectByName(String name);
	public RecordBean selectById(String id);
	public int countExam();
	public void updateExam(RecordBean record);
	public void deleteExam(RecordBean record);
	public String selectFirstRownum();
	
}
