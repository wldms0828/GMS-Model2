package template;

import java.lang.reflect.Field;
//reflect 진짜 모습을 보여주는 객체


import domain.MemberBean;
import enums.Domain;

public class ColumnFinder {
	public static String find(Domain dom) {
		String s="";
		Class<MemberBean> clazz=null;
		//classforname의 Class와 같은것
		switch (dom) {
		case MEMBER:
			clazz=MemberBean.class;			
			break;

		default:
			break;
		}
		Field[] f =clazz.getDeclaredFields();
		for(int i=0;i<f.length;i++) {
			s+=(i!=(f.length-1))?
					f[1].getName()+",":
						f[i].getName();
		}
		return s;
	}
}
