package proxy;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import service.MemberServiceImpl;

public class PageProxy implements Proxy {
	//request에 set하는 거 까지 해준다.
	//제네릭은 선언할 때만 쓴다.
	HttpServletRequest request;
	@Override
	public Map<?, ?> carryOut(Map<?, ?> param) {
		Map<String, Object> map = new HashMap<>();
		request=(HttpServletRequest) param.get("request");
//		request.setAttribute("list", MemberServiceImpl.getInstance().getList(param));
//		request.setAttribute("count", count);
//		request.setAttribute("beginPage", beginPage);
//		request.setAttribute("endPage", endPage );
//		request.setAttribute("", endPage );
		map.put("request", request);
		return map;
	}
}
