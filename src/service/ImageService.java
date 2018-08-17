package service;

import java.util.Map;

import com.sun.prism.Image;

import domain.ImageBean;

public interface ImageService {
	public void create(Map<?, ?> map);
	public ImageBean retrieve(String id);
	public void modify(Map<?, ?> map);
	public void remove(ImageBean image);
}