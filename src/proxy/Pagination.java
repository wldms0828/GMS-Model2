package proxy;

import java.util.HashMap;
import java.util.Map;

import lombok.Data;
import service.MemberServiceImpl;
@Data
public class Pagination implements Proxy {
	int beginRow,endRow,pageIndex,
	pageIndex2,count,beginPage,endPage,pageSize,blockSize,
	pageCount,prevBlock,nextBlock,blockCount;
	boolean existPrev,existNext;
	@Override
	public void carryOut(Object o) {
			this.pageIndex=(int) o;
			this.pageSize=5;
			this.blockSize=5;
			this.count=MemberServiceImpl.getInstance().countMember();
			this.beginRow=(pageIndex-1) * pageSize + 1 ;
			this.endRow=pageSize * (pageIndex);
			this.beginPage=pageIndex-((pageIndex-1)%blockSize);
			this.pageCount= (count%pageSize==0)?
					count/pageSize:count/pageSize+1;
			this.endPage = ((beginPage+pageSize-1)<pageCount)?
					beginPage+blockSize-1:pageCount;
			this.blockCount = (pageCount%blockSize==0)?
					pageCount/blockSize : pageCount/blockSize+1;
			this.prevBlock=beginPage-blockSize;
			this.nextBlock=beginPage+blockSize;
			this.existPrev=(prevBlock>=0);
			System.out.println("%%%%%%%%%%%%%%%%5");
			System.out.println("existPrev" + existPrev);
			this.existNext=(nextBlock<=pageCount);
			System.out.println("existNext" + existNext);
		
		
	}



}
