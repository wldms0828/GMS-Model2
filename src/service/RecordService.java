package service;
import domain.*;
import java.util.*;
public interface RecordService {
	public void createRecord(RecordBean record);
	public List<RecordBean> listRecord();
	public List<RecordBean> findByName(String name);
	public RecordBean findById(String id);
	public int countRecord();
	public void updateRecord(RecordBean record);
	public void deleteRecord(RecordBean record);
	
	
}
