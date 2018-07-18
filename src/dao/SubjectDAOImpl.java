package dao;

import java.util.List;

import domain.SubjectBean;

public class SubjectDAOImpl implements SubjectDAO{
	private static SubjectDAO instance = new SubjectDAOImpl();
		public static SubjectDAO getInstance() {return instance;}
	private SubjectDAOImpl() {}
	@Override
	public void insertSubjectBean(SubjectBean subject) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<SubjectBean> selectAllExam() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<SubjectBean> selectByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SubjectBean selectById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int countExam() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void updateExam(SubjectBean subject) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteExam(SubjectBean subject) {
		// TODO Auto-generated method stub
		
	}

}
