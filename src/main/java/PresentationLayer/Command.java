package PresentationLayer;

import FunctionLayer.LoginSampleException;
import FunctionLayer.Order;
import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * The purpose of Command is to...
 *
 * @author kasper
 */
abstract class Command {

    private static HashMap<String, Command> commands;

    private static void initCommands() {
        commands = new HashMap<>();
        commands.put("login", new Login());
        commands.put("register", new Register());
        commands.put("doOrder", new doOrder());
        commands.put("viewUserOrderList", new viewUserOrderList());
        commands.put("viewRolepage", new viewRolepage());
        commands.put("logout", new logout());

    }

    static Command from(HttpServletRequest request) {
        String commandName = request.getParameter("command");
        if (commands == null) {
            initCommands();
        }
        return commands.getOrDefault(commandName, new UnknownCommand());
    }

    abstract String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException;

}
