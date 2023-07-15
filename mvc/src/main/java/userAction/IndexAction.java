package userAction;

import mvcAction.SupportAction;

public class IndexAction extends SupportAction {
	@Override
	public String execute() {
		// 判断用户是否登录   session- username
		if(session.getAttribute("username") == null) {
			return FAIL;
		}
		return super.execute();
	}

}
