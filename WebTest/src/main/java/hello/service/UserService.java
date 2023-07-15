package hello.service;

import hello.dao.UserDao;
import hello.domain.User;

public class UserService {
	//Service层依赖dao层
	private UserDao userDao = new UserDao();
	
	//service的查询需要依赖dao来完成
	public User find() {
		return userDao.find();
	}
}
