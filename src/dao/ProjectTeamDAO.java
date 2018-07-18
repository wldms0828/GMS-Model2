package dao;

import java.util.List;

import domain.ProjectTeamBean;

public interface ProjectTeamDAO {
	public void insertProjectTeamBean(ProjectTeamBean project); 
	public List<ProjectTeamBean> selectAllExam();
	public List<ProjectTeamBean> selectByName(String name);
	public ProjectTeamBean selectById(String id);
	public int countExam();
	public void updateExam(ProjectTeamBean project);
	public void deleteExam(ProjectTeamBean project);
	
}
