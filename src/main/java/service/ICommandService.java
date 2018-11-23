package service;

import domain.Command;

import java.util.List;

public interface ICommandService {

     void alterCommand(Command command);

     void addCommand(Command command);

     Command getCommandByID(String id);


     List<Command> getCommandByBookId(String bookId);


     List<Command> getCommandByUserId(String userId);

     List<Command> getAllCommands();


     boolean isBybookIdAndUserId(String bookId, String userId) ;

    //根据用户名和书籍名获得唯一Command
    Command getCommandBybookIdAndUserId(String bookId,String userId);
}
