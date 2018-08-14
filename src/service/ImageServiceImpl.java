package service;

import java.util.Map;

import dao.ImageDAOImpl;
import dao.MemberDAOImpl;
import domain.ImageBean;

public class ImageServiceImpl implements ImageService {
	private static ImageService instance = new ImageServiceImpl();
	public static ImageService getInstance() {return instance;}
	private ImageServiceImpl() {}

	@Override
	public void create(String image) {
		ImageDAOImpl.getInstance().insert(image);
	}

	@Override
	public ImageBean retrieve(String id) {
		return ImageDAOImpl.getInstance().retrieve(id);
	}

	@Override
	public void modify(Map<?, ?> map) {
				ImageDAOImpl.getInstance().update(map);
	}

	@Override
	public void remove(ImageBean image) {
			ImageDAOImpl.getInstance().remove(image);
	}

	
}
