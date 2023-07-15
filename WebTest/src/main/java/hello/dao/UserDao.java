package hello.dao;

import hello.domain.User;

public class UserDao {
	/**
	 * 把Xml中的数据查询出来周，封装到user对象中
	 * @return
	 */
	public User find() {
		return new User("zhangsan","123");
	}
}
