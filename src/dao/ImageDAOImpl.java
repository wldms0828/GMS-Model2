package dao;

import java.util.Map;

import domain.ImageBean;
import template.AddQuery;

public class ImageDAOImpl implements ImageDAO {
	private static ImageDAO instance = new ImageDAOImpl();
	public static ImageDAO getInstance() {return instance;}
	private ImageDAOImpl() {}

	@Override
	public void insert(String image) {
		q=new AddQuery();
	}

	@Override
	public ImageBean retrieve(String id) {		
		return null;
	}

	@Override
	public void update(Map<?, ?> map) {
				
	}

	@Override
	public void remove(ImageBean image) {
				
	}

}
