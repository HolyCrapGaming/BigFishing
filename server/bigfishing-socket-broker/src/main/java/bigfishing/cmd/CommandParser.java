package bigfishing.cmd;

import org.jboss.netty.buffer.ChannelBuffer;
import org.jboss.netty.channel.Channel;
import org.jboss.netty.channel.ChannelHandler;
import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.handler.codec.frame.FrameDecoder;

/**
 * User: zhaoyao
 * Date: 11-5-26
 * Time: AM12:33
 */
@ChannelHandler.Sharable
public class CommandParser extends FrameDecoder {

    private CommandFactory commandFactory = new CommandFactory();

    public CommandParser() {
        super();
        commandFactory.registerCommand(Command.CREATE_ROOM, CreateRoomCmd.class);
        System.out.println("CommandParser");
    }

    @Override
    protected Object decode(ChannelHandlerContext ctx, Channel channel, ChannelBuffer buffer) throws Exception {

        if (buffer.readableBytes() < 5) {
            return null;
        }

        buffer.markReaderIndex();

        byte cmdType = buffer.readByte();
        int cmdLength = buffer.readInt();

        if (buffer.readableBytes() < cmdLength) {
            buffer.resetReaderIndex();
            return null;
        }

        ChannelBuffer cmdArgs = buffer.readBytes(cmdLength);

        return commandFactory.create(cmdType, cmdArgs.toByteBuffer());
    }



}
