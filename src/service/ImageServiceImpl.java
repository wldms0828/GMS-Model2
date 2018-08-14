package service;

import java.util.Map;

import dao.MemberDAOImpl;
import domain.ImageBean;

public class ImageServiceImpl implements ImageService {
	private static ImageService instance = new ImageServiceImpl();
	public static ImageService getInstance() {return instance;}
	private ImageServiceImpl() {}

	@Override
	public void create(ImageBean image) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ImageBean retrieve(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void modify(Map<?, ?> map) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remove(ImageBean image) {
		// TODO Auto-generated method stub
		
	}

	
}
