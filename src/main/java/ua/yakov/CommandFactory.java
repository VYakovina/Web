package ua.yakov;

import org.springframework.stereotype.Component;
import ua.yakov.Command;

import java.util.HashMap;
import java.util.Map;
@Component
public class CommandFactory {

private  static  CommandFactory instance;

    private Map<String, Command> comMap = new HashMap<>();

    private CommandFactory(){
      //  comMap.put("registration", new RegCommand());
        comMap.put("login", new LogCommand());
        }

    public static CommandFactory getInstance() {
        if (instance == null){
            instance = new CommandFactory();
        }
        return instance;
    }

    public Command getCommand(String conName){
        return comMap.get(conName);
    }

}
