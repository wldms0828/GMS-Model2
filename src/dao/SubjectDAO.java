package dao;

import java.util.List;

import domain.SubjectBean;

public interface SubjectDAO {
	public void insertSubjectBean(SubjectBean subject); 
	public List<SubjectBean> selectAllExam();
	public List<SubjectBean> selectByName(String name);
	public SubjectBean selectById(String id);
	public int countExam();
	public void updateExam(SubjectBean subject);
	public void deleteExam(SubjectBean subject);
	
}
