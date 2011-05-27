package bigfishing;

import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.channel.MessageEvent;
import org.jboss.netty.channel.SimpleChannelDownstreamHandler;

/**
 * User: zhaoyao
 * Date: 11-5-28
 * Time: AM1:20
 */
public class ResponseSerializer extends SimpleChannelDownstreamHandler{

    @Override
    public void writeRequested(ChannelHandlerContext ctx, MessageEvent e) throws Exception {
        super.writeRequested(ctx, e);    //To change body of overridden methods use File | Settings | File Templates.
    }
}
