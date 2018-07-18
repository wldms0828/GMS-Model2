package dao;

import java.util.List;

import domain.ExamBean;

public interface ExamDAO {
	public void insertExamBean(ExamBean exam); 
	public List<ExamBean> selectAllExam();
	public List<ExamBean> selectByName(String name);
	public ExamBean selectById(String id);
	public int countExam();
	public void updateExam(ExamBean exam);
	public void deleteExam(ExamBean exam);
	
}
