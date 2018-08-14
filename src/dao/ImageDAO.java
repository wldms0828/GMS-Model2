package dao;

import java.util.Map;

import domain.ImageBean;

public interface ImageDAO {
	public void insert(String image);
	public ImageBean retrieve(String id);
	public void update(Map<?, ?> map);
	public void remove(ImageBean image);
}
