package bigfishing.cmd;

import bigfishing.cmd.exception.UnknownCommandException;
import bigfishing.utils.ReflectUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.util.ReflectionUtils;

import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Map;

/**
 * User: zhaoyao
 * Date: 11-5-27
 * Time: PM7:57
 */
public class CommandFactory {

    private Map<Byte, Class<? extends Command>> commands = new HashMap<Byte, Class<? extends Command>>();

    public CommandFactory() {
    }

    public CommandFactory(Map<Byte, Class<? extends Command>> commands) {
        this.commands = commands;
    }

    public Command create(byte type, ByteBuffer args) {
        Class<? extends Command> cmdClass = commands.get(type);

        if (cmdClass == null) {
            throw new UnknownCommandException(type);
        }

        Command command = ReflectUtils.callConstructor(cmdClass, new Class[]{ByteBuffer.class}, new Object[]{args});
        command.parseArguments();
        return command;
    }

    public void registerCommand(byte type, Class<? extends Command> cmdClass) {
        commands.put(type, cmdClass);
    }
}
