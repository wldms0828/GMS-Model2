package service;
import java.util.*;
import domain.*;

public interface SubjectService {
	public void createSubject(SubjectBean subject);
	public List<SubjectBean> listSubject();
	public List<SubjectBean> findByName(String name);
	public SubjectBean findById (String id);
	public int countSubject();
	public void updateSubject(SubjectBean subject);
	public void deleteSubject(SubjectBean subject);
}
