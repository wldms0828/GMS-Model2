package dao;

import java.util.Map;

import domain.ImageBean;

public class ImageDAOImpl implements ImageDAO {
	private static ImageDAO instance = new ImageDAOImpl();
	public static ImageDAO getInstance() {return instance;}
	private ImageDAOImpl() {}

	@Override
	public void insert(ImageBean image) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ImageBean retrieve(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Map<?, ?> map) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remove(ImageBean image) {
		// TODO Auto-generated method stub
		
	}

}
