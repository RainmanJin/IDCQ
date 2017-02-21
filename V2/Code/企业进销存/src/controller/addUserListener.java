package controller;

import dao.Dao;
import model.TbUserlist;
import view.dialog.addUser;

public class addUserListener {
	
	
	public String add(addUser au) {
		String username = au.getText_1().getText().trim();
		String name = au.getText_2().getText().trim();
		String pass = au.getText_3().getText().trim();
		String passOk = au.getText_4().getText().trim();
		if(username.equals("")||name.equals("")||pass.equals("")||passOk.equals(""))
			return "输入的内容不能为空!";
		if(!pass.equals(passOk))
			return "输入的密码不一致!";
		TbUserlist user = Dao.getUser(name,username, pass);
		if(user.getUsername() != null && !user.getUsername().equals("")) {
			return "该操作员已存在!";
		} else {
			if(pass.equals(passOk)) {
				TbUserlist tbUserlist = new TbUserlist();
				tbUserlist.setQuan("c");
				tbUserlist.setPass(pass);
				tbUserlist.setName(username);
				tbUserlist.setUsername(name);
				Dao.addUser(tbUserlist);
				au.getText_1().setText("");
				au.getText_2().setText("");
				au.getText_3().setText("");
				au.getText_4().setText("");
			}
		}	
		return "添加操作员成功!";
	}	
}
