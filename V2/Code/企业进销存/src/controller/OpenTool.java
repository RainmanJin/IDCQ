package controller;

public class OpenTool {
	
	public String open() {
		Runtime run = Runtime.getRuntime(); 
		try {
			run.exec("C:\\Windows\\System32\\calc.exe");
		} catch (Exception e) {
			return "打开计算器失败!";
		}
		return "ok";
	}

}
