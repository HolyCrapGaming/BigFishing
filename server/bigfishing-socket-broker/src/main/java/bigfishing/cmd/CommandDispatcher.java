package bigfishing.cmd;

import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.channel.MessageEvent;
import org.jboss.netty.channel.SimpleChannelUpstreamHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * User: zhaoyao
 * Date: 11-5-27
 * Time: PM8:10
 */
public class CommandDispatcher extends SimpleChannelUpstreamHandler{

    private static final Logger logger = LoggerFactory.getLogger(CommandDispatcher.class);

    public CommandDispatcher() {
        System.out.println("CommandDispatcher");
    }

    @Override
    public void messageReceived(ChannelHandlerContext ctx, MessageEvent e) throws Exception {
        Command command = (Command) e.getMessage();

        logger.info("got {}", command);
    }
}
