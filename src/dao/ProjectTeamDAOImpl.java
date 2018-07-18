package dao;

import java.util.List;

import domain.ProjectTeamBean;

public class ProjectTeamDAOImpl implements ProjectTeamDAO{
	private ProjectTeamDAO instance = new ProjectTeamDAOImpl();	
	public ProjectTeamDAO getInstance() {return instance;}
	private ProjectTeamDAOImpl() {}
	@Override
	public void insertProjectTeamBean(ProjectTeamBean project) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<ProjectTeamBean> selectAllExam() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ProjectTeamBean> selectByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ProjectTeamBean selectById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int countExam() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void updateExam(ProjectTeamBean project) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteExam(ProjectTeamBean project) {
		// TODO Auto-generated method stub
		
	}

}
