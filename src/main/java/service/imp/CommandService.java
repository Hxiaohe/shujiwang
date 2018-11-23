package service.imp;

import dao.IBookDAO;
import dao.ICommandDAO;
import dao.imp.BookDAO;
import dao.imp.CommandDAO;
import domain.Command;
import service.ICommandService;

import java.util.List;

public class CommandService implements ICommandService {

    private ICommandDAO commandDAO = new CommandDAO();



    public CommandService() {

    }
    @Override
    public void alterCommand(Command command) {
        commandDAO.alterCommand(command);
    }

    @Override
    public void addCommand(Command command) {
        commandDAO.addCommand(command);
    }

    @Override
    public Command getCommandByID(String id) {
        return commandDAO.getCommandById(id);
    }

    @Override
    public List<Command> getCommandByBookId(String bookid) {
        return commandDAO.getCommandsByBookId(bookid);
    }

    @Override
    public List<Command> getCommandByUserId(String userId) {
        return commandDAO.getCommandsByUserId(userId);
    }

    @Override
    public List<Command> getAllCommands() {
        return commandDAO.getAllCommands();
    }

    @Override
    public boolean isBybookIdAndUserId(String bookId, String userId) {
        return commandDAO.isBybookIdAndUserId(bookId,userId);
    }

    @Override
    public Command getCommandBybookIdAndUserId(String bookId, String userId) {
        return commandDAO.getCommandBybookIdAndUserId(bookId, userId);
    }

}
