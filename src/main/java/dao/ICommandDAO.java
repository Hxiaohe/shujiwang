package dao;

import domain.Command;

import java.util.List;

public interface ICommandDAO {
	//添加一个命令到数据库中
		 void addCommand(Command command);
		//修改命令
		 void alterCommand(Command command);
		
		//根据命令编号获取命令信息，以Command对象的形式返回
		 Command getCommandById(String id);
		
		//根据用户名获取评论信息，以Command对象返回
		 List<Command> getCommandsByUserId(String userId);


	//根据用户名获取评论信息，以Command对象返回
	 List<Command> getCommandsByBookId(String bookId);
		
		//获得所有评论
		 List<Command> getAllCommands();

		 //某用户是否评论某书
		 boolean isBybookIdAndUserId(String bookId,String userId);

    //根据用户名和书籍名获得唯一Command
    Command getCommandBybookIdAndUserId(String bookId,String userId);
}
