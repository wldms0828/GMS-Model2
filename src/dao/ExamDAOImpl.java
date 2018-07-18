package dao;

import java.util.List;

import domain.ExamBean;

public class ExamDAOImpl implements ExamDAO{
	private static ExamDAO instance = new ExamDAOImpl();
	public static ExamDAO getInstance() {return instance;}
	private ExamDAOImpl() {}

	@Override
	public void insertExamBean(ExamBean exam) {
	
	}

	@Override
	public List<ExamBean> selectAllExam() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ExamBean> selectByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ExamBean selectById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int countExam() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void updateExam(ExamBean exam) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteExam(ExamBean exam) {
		// TODO Auto-generated method stub
		
	}

}
