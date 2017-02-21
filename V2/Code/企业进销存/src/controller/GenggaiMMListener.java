package controller;

import dao.Dao;
import main.login;
import model.TbUserlist;
import view.dialog.GenggaiMM;

public class GenggaiMMListener {
	private TbUserlist user = login.getUser();
	GenggaiMM gm;
	
	public GenggaiMMListener(GenggaiMM ggmm) {
		this.gm = ggmm;
		ggmm.getText_1().setText(user.getUsername());
		ggmm.getText_2().setText(user.getName());	
	}
	
	public String update() {
		if(gm.getText_4().getText().equals("")||gm.getText_5().getText().equals(""))
			return "密码不能为空!";
		if(user.getPass().equals(gm.getText_3().getText().trim())) {
			if(gm.getText_4().getText().trim().equals(gm.getText_5().getText().trim())) {
				user.setPass(gm.getText_4().getText().trim());
				Dao.updateUser(user);
				gm.getText_3().setText("");
				gm.getText_4().setText("");
				gm.getText_5().setText("");
			} else {
				return "输入的密码不一致!";
			}
		} else {
			return "密码错误!";
		}
		return "修改成功!";
	}
}
