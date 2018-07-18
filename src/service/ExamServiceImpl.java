package service;

import java.util.List;

import dao.ExamDAOImpl;
import dao.RecordDAOImpl;
import dao.SubjectDAOImpl;
import domain.ExamBean;
import domain.RecordBean;
import domain.SubjectBean;

public class ExamServiceImpl implements ExamService {
	private static ExamService instance = new ExamServiceImpl();
	public static ExamService getInstance() {return instance;}
	private ExamServiceImpl() {}
	
	
	@Override
	public void createExamBean(ExamBean exam) {
		System.out.println("----------ExamService---------");
		System.out.println(exam);
		//성적SEQ=null
		//List<SubjectBean> list = SubjectDAOImpl.getInstance().selectByName("JAVA");
		exam.setScore(exam.getScore().split("/")[0]);
		//과목SEQ=null
		exam.setSubSeq(SubjectDAOImpl.getInstance().selectByName("JAVA").get(0).getSubSeq());  
		//성적SEQ=null
		System.out.println("-----RECORD-----");
		RecordBean rec = new RecordBean();
		rec.setAge("80");
		rec.setGrade("B");
		RecordDAOImpl.getInstance().insertRecordBean(rec);
		System.out.println("-----SCORE------");
		exam.setRecordSeq(RecordDAOImpl.getInstance().selectFirstRownum());
		
		ExamDAOImpl.getInstance().insertExamBean(exam); 
		
	}

	@Override
	public List<ExamBean> listExam() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ExamBean> findByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ExamBean findById(String id) {
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
