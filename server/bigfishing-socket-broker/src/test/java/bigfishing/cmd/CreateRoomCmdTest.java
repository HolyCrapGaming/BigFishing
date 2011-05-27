package bigfishing.cmd;

import bigfishing.cmd.exception.InvalidArgumentException;
import bigfishing.cmd.exception.StringArgumentLengthNotProvidedException;
import bigfishing.utils.ByteUtils;
import junit.framework.Assert;
import org.jboss.netty.util.CharsetUtil;
import org.junit.Test;

import java.nio.ByteBuffer;

/**
 * User: zhaoyao
 * Date: 11-5-27
 * Time: PM4:45
 */
public class CreateRoomCmdTest extends Assert{


    @Test
    public void testParseArguments() {
        CreateRoomCmd cmd = new CreateRoomCmd(makeBuffer((int)1, (byte)1, "新手房间", "123456"));

        assertEquals(1, cmd.getRoomType());
        assertTrue(cmd.isEncrypted());
        assertEquals("新手房间", cmd.getName());
        assertEquals("123456", cmd.getPassword());
    }

    @Test
    public void testNoRoomNameProvided() {
        try {
            new CreateRoomCmd(makeBuffer(1, (byte) 1));
        } catch (StringArgumentLengthNotProvidedException e) {
            assertEquals(Argument.NAME_OF_ROOM, e.getArgument());
        }
    }

    @Test
    public void testNegativeRoomTypeProvided() {
        try {
            CreateRoomCmd createRoomCmd = new CreateRoomCmd(makeBuffer(-11, (byte) 1));
            System.out.println(createRoomCmd);
        } catch (InvalidArgumentException e) {
            assertEquals(Argument.TYPE_OF_ROOM, e.getArgument());
        }
    }

    public static ByteBuffer makeBuffer(Object... args) {
        int len = 0;
        for (Object arg : args) {
            if (arg.getClass() == Integer.TYPE || arg instanceof Integer) {
                len += ByteUtils.SIZE_OF_INT;
            } else if (arg.getClass() == Byte.TYPE || arg instanceof Byte) {
                len += ByteUtils.SIZE_OF_BYTE;
            } else if (arg instanceof String) {
                len += (ByteUtils.SIZE_OF_INT + ((String) arg).getBytes(CharsetUtil.UTF_8).length);
            }
        }

        ByteBuffer buf = ByteBuffer.allocate(len);

        for (Object arg : args) {
            if (arg.getClass() == Integer.TYPE || arg instanceof Integer) {
                buf.putInt((Integer) arg);
            } else if (arg.getClass() == Byte.TYPE || arg instanceof Byte) {
                buf.put((Byte) arg);
            } else if (arg instanceof String) {
                String s = (String) arg;
                buf.putInt(s.getBytes(CharsetUtil.UTF_8).length);
                buf.put(s.getBytes(CharsetUtil.UTF_8));
            }
        }

        return buf;
    }


}
