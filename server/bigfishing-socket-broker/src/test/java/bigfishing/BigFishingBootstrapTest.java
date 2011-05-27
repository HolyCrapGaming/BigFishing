package bigfishing;

import bigfishing.cmd.Command;
import bigfishing.utils.ByteUtils;
import bigfishing.utils.Props;
import org.jboss.netty.bootstrap.ClientBootstrap;
import org.jboss.netty.buffer.ChannelBuffer;
import org.jboss.netty.buffer.ChannelBuffers;
import org.jboss.netty.channel.*;
import org.jboss.netty.channel.local.DefaultLocalClientChannelFactory;
import org.jboss.netty.channel.socket.nio.NioClientSocketChannelFactory;
import org.jboss.netty.util.CharsetUtil;

import java.io.*;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.nio.ByteBuffer;
import java.util.concurrent.Executors;

/**
 * User: zhaoyao
 * Date: 11-5-27
 * Time: PM11:26
 */
public class BigFishingBootstrapTest {

    public static void main(String[] args) throws IOException {

        ByteBuffer b = makeBuffer((int) 1, (byte) 1, "新手房间", "123456");
        Socket sock = new Socket("localhost", 9999);
        OutputStream os = sock.getOutputStream();
        DataOutputStream dos = new DataOutputStream(os);
        b.rewind();
        System.out.println(b.remaining());
        dos.write(10);

        dos.writeInt(b.remaining());
        dos.write(b.array());
        dos.flush();

        DataInputStream dis = new DataInputStream(sock.getInputStream());
        int l;
        byte[] buf = new byte[4096];
        ChannelBuffer cb = ChannelBuffers.dynamicBuffer(40960);
        while ((l = dis.read(buf)) != -1) {
            cb.writeBytes(buf, 0, l);
        }

        cb.resetReaderIndex();
        int i = cb.readInt();
        if (i == 1) {
            int len = cb.readInt();
            String s = new String(cb.readBytes(len).array(), "utf-8");
            System.out.println(s);
        } else {
            System.out.println("unknown");
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
