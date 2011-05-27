package bigfishing.cmd;

import bigfishing.cmd.exception.InvalidArgumentException;
import org.jboss.netty.util.CharsetUtil;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;

import static bigfishing.utils.ByteUtils.SIZE_OF_BYTE;
import static bigfishing.utils.ByteUtils.SIZE_OF_INT;

/**
 *
 * 创建房间命令
 * <pre>
 * +----------------+-----------------+--------------------------+-------------------+--------------------+-------------+
 * | room type(int) | encrypted(byte) | length of room name(int) | room name(string) | length of pwd(int) | pwd(string) |
 * +----------------+-----------------+--------------------------+-------------------+--------------------+-------------+
 * </pre>
 *
 *
 *
 *
 *
 * User: zhaoyao
 * Date: 11-5-27
 * Time: PM4:07
 */
public class CreateRoomCmd extends Command {

    public CreateRoomCmd(ByteBuffer args) {
        super(args);
    }

    private int roomType;
    private boolean encrypted;
    private String name;
    private String password;

    @Override
    public void parseArguments() throws InvalidArgumentException {
        args.rewind();
        roomType = getArgument(Argument.TYPE_OF_ROOM);
        encrypted = getArgument(Argument.IS_ROOM_ENCRYPTED);
        name = getArgument(Argument.NAME_OF_ROOM);
        password = getArgument(Argument.PASSWORD_OF_ROOM);
    }

    public int getRoomType() {
        return roomType;
    }

    public boolean isEncrypted() {
        return encrypted;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "CreateRoomCmd{" +
                "roomType=" + roomType +
                ", encrypted=" + encrypted +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
