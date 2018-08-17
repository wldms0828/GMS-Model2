package dao;

import java.util.HashMap;
import java.util.Map;

import domain.ImageBean;
import domain.MemberBean;
import jdk.nashorn.internal.ir.RuntimeNode.Request;
import service.MemberServiceImpl;
import template.AddQuery;
import template.QueryTemplate;
import template.RetriveQuery;

public class ImageDAOImpl implements ImageDAO {
	private static ImageDAO instance = new ImageDAOImpl();
	public static ImageDAO getInstance() {return instance;}
	private ImageDAOImpl() {}
	private QueryTemplate q = null;

	@Override
	public void insert(Map<?, ?> map) {
		System.out.println(" ImageDAO의 insert입장 ");
		q=new AddQuery();
		@SuppressWarnings("unchecked")
		Map<String, Object> param = (Map<String, Object>) map;
		System.out.println("ImageDAO에 넘어온 map의 IMGNAME 값 : " + map.get("IMGNAME"));
		System.out.println("ImageDAO에 넘어온 map의 EXTENSION 값 : " + map.get("EXTENSION"));
		System.out.println("ImageDAO에 넘어온 map의 USERID 값 : " + map.get("USERID"));
		param.put("table", "IMAGE");
		q.play(param);
		}

	@Override
	public ImageBean retrieve(String id) {		
		ImageBean image = new ImageBean();
		q=new RetriveQuery();
		Map<String, Object> map=new HashMap<>();
		map.put("USERID", id);
		q.play(map);
		image=(ImageBean) map;
		return image;
	}

	@Override
	public void update(Map<?, ?> map) {
				
	}

	@Override
	public void remove(ImageBean image) {
				
	}

}
