package service;
import domain.*;
import java.util.*;

public interface ExamService {
	public void createExamBean(ExamBean exam); 
	public List<ExamBean> listExam();
	public List<ExamBean> findByName(String name);
	public ExamBean findById(String id);
	public int countExam();
	public void updateExam(ExamBean exam);
	public void deleteExam(ExamBean exam);
	
}
