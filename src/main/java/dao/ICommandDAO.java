package dao;

import domain.Command;

import java.util.List;

public interface ICommandDAO {
	//添加一个用户到数据库中
		public void addCommand(Command command);
		//修改用户
		public void alterCommand(Command command);
		
		//根据用户编号获取用户信息，以User对象的形式返回
		public Command getCommandById(String id);
		
		//根据用户名获取用户信息，以User对象返回
		public List<Command> getUserByUserName(String userName);
		
		//获得所有评论
		public List<Command> getAllCommands();
}
