package userAction;

import mvcAction.SupportAction;

public class LoginAction extends SupportAction {
	@Override
	public String execute() {
		String name = params.get("name");
		String password = params.get("password");
		
		if(("aaa").equals(name)||("bbb").equals(name) & "123".equals(password)) {
			session.setAttribute("username", name);
			return "ok";
		}
		
		
		return "no";
	}
}
