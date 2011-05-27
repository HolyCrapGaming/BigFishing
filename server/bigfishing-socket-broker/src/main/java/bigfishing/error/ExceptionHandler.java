package bigfishing.error;

import bigfishing.exceptions.BigFishingException;
import bigfishing.utils.ByteUtils;
import bigfishing.utils.I18nResource;
import org.jboss.netty.buffer.ByteBufferBackedChannelBuffer;
import org.jboss.netty.buffer.ChannelBuffer;
import org.jboss.netty.buffer.ChannelBuffers;
import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.channel.ExceptionEvent;
import org.jboss.netty.channel.SimpleChannelUpstreamHandler;
import org.jboss.netty.util.CharsetUtil;

import java.io.Serializable;
import java.nio.channels.Channels;
import java.util.Locale;
import java.util.Map;

/**
 * User: zhaoyao
 * Date: 11-5-26
 * Time: AM1:13
 */
public class ExceptionHandler extends SimpleChannelUpstreamHandler {

    private I18nResource i18nResource = new I18nResource();


    //todo 应该存在一个ResponseSerializer, serialize(Response resp) serialize(Exception e, Map ctx);
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, ExceptionEvent e) throws Exception {
        Map<String, Object> ctxInfo = (Map<String, Object>) ctx.getAttachment();
        Throwable cause = e.getCause();
        Locale sessionLocale = null;//(Locale) ctxInfo.get("locale");

        if (cause instanceof BigFishingException) {
            BigFishingException fishingException = (BigFishingException) cause;
            String key = fishingException.getLanguageEntryKey();
            String errorMsg = fishingException.getMessage();

            byte[] bytes = ByteUtils.getBytes(errorMsg, "utf-8");

            ChannelBuffer buffer = ChannelBuffers.dynamicBuffer();
            buffer.writeByte(0);
            buffer.writeByte(bytes.length);
            buffer.writeBytes(bytes);
            buffer.resetReaderIndex();
            e.getChannel().write(buffer, e.getChannel().getRemoteAddress());
            //extract i18n msg
            //serialize error msg
        } else {
            //unexpected error
            //log error
            ctx.getChannel().close();
        }

    }

}
