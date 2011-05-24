package bigfishing;

import org.jboss.netty.bootstrap.ServerBootstrap;
import org.jboss.netty.channel.*;
import org.jboss.netty.channel.socket.nio.NioServerSocketChannelFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.UnknownHostException;
import java.util.concurrent.Executors;

/**
 * User: zhaoyao
 * Date: 11-5-25
 * Time: AM12:35
 */
public class BigFishingBootstrap extends ServerBootstrap{

    private static final Logger LOGGER = LoggerFactory.getLogger(BigFishingBootstrap.class);

    public BigFishingBootstrap(ChannelFactory channelFactory) {
        super(channelFactory);
    }

    public static void main(String[] args) {

        BigFishingBootstrap bootstrap = new BigFishingBootstrap(new NioServerSocketChannelFactory(
                Executors.newCachedThreadPool(),
                Executors.newCachedThreadPool()
        ));

        bootstrap.setPipelineFactory(new ChannelPipelineFactory() {
            @Override
            public ChannelPipeline getPipeline() throws Exception {
                return Channels.pipeline(new SimpleChannelUpstreamHandler(){
                    @Override
                    public void messageReceived(ChannelHandlerContext ctx, MessageEvent e) throws Exception {
                        e.getChannel().write("server said: " + e.getMessage());
                        LOGGER.info("receive msg: " + e.getMessage());
                    }

                    @Override
                    public void exceptionCaught(ChannelHandlerContext ctx, ExceptionEvent e) throws Exception {
                        LOGGER.error("cause unexpected error.", e);
                        super.exceptionCaught(ctx, e);
                    }
                });
            }
        });

        try {
            bootstrap.bind(new InetSocketAddress(InetAddress.getByName("119.161.212.41"), 9999));
        } catch (UnknownHostException e) {
            LOGGER.error("BigFishing server start failed: could not bind to localhost. " + e.getMessage(), e);
        }

        LOGGER.info("BigFishing server started successfully.");

    }

}
