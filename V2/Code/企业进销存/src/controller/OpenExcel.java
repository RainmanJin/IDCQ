package controller;

public class OpenExcel {
	
	public String open() {
		Runtime run = Runtime.getRuntime(); 
		try {
			run.exec("C:\\Program Files\\Microsoft Office\\Office16\\EXCEL.EXE /res/c.xls");
		} catch (Exception e) {
			return "打开excel失败!";
		}
		return "ok";
	}

}
