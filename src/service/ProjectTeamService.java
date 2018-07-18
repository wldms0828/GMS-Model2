package service;
import domain.*;
import java.util.*;
public interface ProjectTeamService {
	public void createProjectTeam(ProjectTeamBean bean);
	public List<ProjectTeamBean> listProjectTeam();
	public List<ProjectTeamBean> findByName(String name);
	public ProjectTeamBean findById(String id);
	public int countProjectTeam();
	public void updateProject(ProjectTeamBean bean);
	public void deleteProject(ProjectTeamBean bean);
	
}
