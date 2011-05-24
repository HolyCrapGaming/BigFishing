package bigfishing;

import org.jboss.netty.bootstrap.ServerBootstrap;
import org.jboss.netty.channel.ChannelFactory;
import org.jboss.netty.channel.ChannelPipeline;
import org.jboss.netty.channel.ChannelPipelineFactory;
import org.jboss.netty.channel.Channels;
import org.jboss.netty.channel.socket.nio.NioServerSocketChannelFactory;

import java.util.concurrent.Executors;

/**
 * User: zhaoyao
 * Date: 11-5-25
 * Time: AM12:35
 */
public class BigFishingBootstrap extends ServerBootstrap{

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
                return Channels.pipeline();
            }
        });

        bootstrap.bind();


    }

}
