package proxy;

import java.util.HashMap;
import java.util.Map;

import lombok.Data;
import service.MemberServiceImpl;
@Data
public class Pagination implements Proxy {
	int beginRow,endRow,pageIndex,
	pageIndex2,count,beginPage,endPage,pageRow,blockSize,
	pageTotal,prevBlock,nextBlock,blockCount;
	boolean existPrev,existNext;
	@Override
	public void carryOut(Object o) {
			this.pageIndex=(int) o;
			this.pageRow=5;
			this.blockSize=5;
			this.beginPage=pageIndex-((pageIndex-1)%blockSize);
			this.count=MemberServiceImpl.getInstance().count();
			this.beginRow=(pageIndex-1) * pageRow + 1 ;
			this.endRow=pageRow * (pageIndex);
			this.pageTotal= (count%pageRow==0)?
					count/pageRow:count/pageRow+1;
			this.endPage = ((beginPage+pageRow-1)<pageTotal)?
					beginPage+blockSize-1:pageTotal;
			this.blockCount = (pageTotal%blockSize==0)?
					pageTotal/blockSize : pageTotal/blockSize+1;
			this.prevBlock=beginPage-blockSize;
			this.nextBlock=beginPage+blockSize;
			this.existPrev=(prevBlock>=0);
			System.out.println("%%%%%%%%%%%%%%%%5");
			System.out.println("existPrev" + existPrev);
			this.existNext=(nextBlock<=pageTotal);
			System.out.println("nextBlock" + nextBlock);
		
		
	}



}
