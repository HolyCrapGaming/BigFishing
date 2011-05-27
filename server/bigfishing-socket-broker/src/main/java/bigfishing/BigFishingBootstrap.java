package bigfishing;

import bigfishing.cmd.CommandDispatcher;
import bigfishing.cmd.CommandParser;
import bigfishing.error.ExceptionHandler;
import bigfishing.utils.Props;
import org.jboss.netty.bootstrap.ServerBootstrap;
import org.jboss.netty.channel.*;
import org.jboss.netty.channel.socket.nio.NioServerSocketChannelFactory;
import org.jboss.netty.handler.codec.string.StringDecoder;
import org.jboss.netty.handler.codec.string.StringEncoder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.UnknownHostException;
import java.util.concurrent.Executors;

/**
 * User: zhaoyao
 * Date: 11-5-25
 * Time: AM12:35
 */
public class BigFishingBootstrap extends ServerBootstrap {

    private static final Logger LOGGER = LoggerFactory.getLogger(BigFishingBootstrap.class);

    private String bindAddress;
    private int bindPort;

    public BigFishingBootstrap(Props bootstrapProps) {

        bindAddress = bootstrapProps.getString("server.bind.address", "localhost");
        bindPort = bootstrapProps.getInt("server.bind.port", 9999);

        this.setFactory(new NioServerSocketChannelFactory(
                Executors.newCachedThreadPool(),
                Executors.newCachedThreadPool()
        ));
        configurePipeline();

    }

    public void start() {
        try {
            this.bind(new InetSocketAddress(InetAddress.getByName(bindAddress), bindPort));
        } catch (UnknownHostException e) {
            LOGGER.error("BigFishing server start failed: could not bind to " + bindAddress + ":" + bindPort + ". ", e);
        }
    }

    private void configurePipeline() {
        this.setPipelineFactory(new ChannelPipelineFactory() {
            @Override
            public ChannelPipeline getPipeline() throws Exception {
                return Channels.pipeline(
                        new CommandParser(),
                        new CommandDispatcher(),
                        new ExceptionHandler()
                );
            }
        });
    }



    public static void main(String[] args) throws IOException {

        BigFishingBootstrap bootstrap = new BigFishingBootstrap(new Props());

        bootstrap.start();

        LOGGER.info("BigFishing server started successfully.");

    }

}
