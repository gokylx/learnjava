package com.kylx.action;

import java.util.Date;


import com.kylx.dao.GoddessDao;
import com.kylx.model.Goddess;

public class GoddessAction {
	public static void main(String[] args) throws Exception {
		GoddessDao g = new GoddessDao();
		
		Goddess g1 = new Goddess();
		
		g1.setUser_name("lucy");
		g1.setAge(28);
		g1.setSex(1);
		g1.setBirthday(new Date());
		g1.setEmail("lucy@imooc.com");
		g1.setMobile("17711211111");
		g1.setUpdate_user("ADMIN");
		g1.setIsdel(1);
		
		Goddess g2 = g.get(3);
		System.out.println(g2);
		
//		g1.setId(4);
//		g.delGoddess(4);
//		g.updateGoddess(g1);
		
//		g.addGoddess(g1);
	}
}
