package proxy;

import java.util.HashMap;
import java.util.Map;

import lombok.Data;
@Data
public class Pagination implements Proxy {
	String beginRow,endRow,pageIndex,pageIndex2;
	int beginPage,endPage,pageSize,blockSize = 5;

	@Override
	public Map<?, ?> carryOut(Map<?, ?> param) {
		Map<String, Object> map = new HashMap<>();
		map.put("beginRow", beginRow);
		map.put("endRow", endRow);
		return null;
	}

}
