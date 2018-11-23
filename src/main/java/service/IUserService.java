package service;

import domain.User;

import java.util.List;

/**
 * User对应的业务逻辑接口，提供一些与信息相关的业务逻辑操作的公开的方法声明
 */
public interface IUserService {
	
	
	public void alterUser(User user);
	//添加注册用户信息到数据库
	public void addUser(User user);

	//根据用户编号获取用户信息
	public User getUserByID(String id);

	//根据用户名获取用户信息
	public List<User> getUserByName(String name);

	//验证用户登录名和密码是否合法
	public User validateUser(String userName, String password);
	
	//验证用户名是否已经存在
	public boolean isUserExist(String userName);
}

