package bigfishing.pipeline;

import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.channel.ChannelStateEvent;
import org.jboss.netty.channel.ExceptionEvent;
import org.jboss.netty.channel.SimpleChannelUpstreamHandler;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

/**
 * User: zhaoyao
 * Date: 11-5-26
 * Time: AM12:53
 */
public class OnlineUserCounter extends SimpleChannelUpstreamHandler {

    private AtomicLong counter;

    @Override
    public void channelConnected(ChannelHandlerContext ctx, ChannelStateEvent e) throws Exception {
        counter.incrementAndGet();
    }

    @Override
    public void channelDisconnected(ChannelHandlerContext ctx, ChannelStateEvent e) throws Exception {
        counter.decrementAndGet();
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, ExceptionEvent e) throws Exception {
        counter.decrementAndGet();
        ctx.sendUpstream(e);
    }
}
