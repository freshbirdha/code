package userAction;

import java.util.List;

import com.alibaba.fastjson2.JSON;

import bean.Tags;
import dao.TagsDao;
import mvcAction.SupportAction;

public class TagsAction extends SupportAction {
	TagsDao dao;
	@Override
	public String execute() {
		List<Tags> tagList = dao.findAll();
		
		String json = JSON.toJSONString(tagList);
		return json;
	}
}
