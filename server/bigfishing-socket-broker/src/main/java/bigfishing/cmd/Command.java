package bigfishing.cmd;

import bigfishing.cmd.constraint.Constraint;
import bigfishing.cmd.exception.InvalidArgumentException;
import bigfishing.cmd.exception.StringArgumentLengthNotProvidedException;
import bigfishing.utils.ByteUtils;
import org.jboss.netty.util.CharsetUtil;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;

/**
 * User: zhaoyao
 * Date: 11-5-26
 * Time: AM1:15
 */
public abstract class Command {

    public static final byte CREATE_ROOM = 0;
    public static final byte JOIN_ROOM = 1;
    public static final byte LEAVE_ROOM = 2;
    protected ByteBuffer args;

    public Command(ByteBuffer args) {
        this.args = args;
    }

    public abstract void parseArguments() throws InvalidArgumentException;

    protected <T> void missingArgument(Argument<T> arg) {
        throw new InvalidArgumentException(arg);
    }

    protected void missingStringArgumentLength(Argument arg) {
        throw new StringArgumentLengthNotProvidedException(arg);
    }

    protected <T> T getArgument(Argument<T> argument) {
        Class<T> type = argument.getType();

        if (type != String.class) {
            int size = getSize(type);
            if (args.remaining() < size) {
                missingArgument(argument);
            }
            T value = (T) getArgument(type);
            validate(argument, value);
            return value;
        } else {
            if (args.remaining() < ByteUtils.SIZE_OF_INT) {
                missingStringArgumentLength(argument);
            }
            int argSize = args.getInt();
            if (args.remaining() < argSize) {
                missingArgument(argument);
            }
            T value = (T) getString(args, argSize, CharsetUtil.UTF_8);
            validate(argument, value);
            return value;
        }
    }

    private <T> void validate(Argument<T> argument, T value) {
        for (Constraint constraint : argument.getConstraints()) {
            constraint.apply(argument, value);
        }
    }

    public String getString(ByteBuffer buffer, int len, Charset charset) {
        if (len < 0) {
            throw new IllegalArgumentException("negative string length: " + len);
        }

        if (buffer.remaining() < len) {
            throw new IllegalArgumentException("not enough remaining bytes to read, " + len);
        }

        byte[] ary = new byte[len];
        buffer.get(ary);
        return new String(ary, charset);
    }

    private Object getArgument(Class<?> type) {
        if (isInteger(type)) {
            return args.getInt();
        }
        if (isBoolean(type)) {
            return (args.get() == 1);
        }

        return null;//todo unknown type arg
    }

    private <T> boolean isByte(Class<T> type) {
        return type == Byte.TYPE || type == Byte.class;
    }

    protected int getSize(Class<?> type) {
        if (isInteger(type)) {
            return ByteUtils.SIZE_OF_INT;
        }
        if (isBoolean(type)) {
            return ByteUtils.SIZE_OF_BYTE;
        }
        return -1;//todo unknown type
    }

    private boolean isBoolean(Class<?> type) {
        return type == Boolean.TYPE || type == Boolean.class;
    }

    private boolean isInteger(Class<?> type) {
        return type == Integer.TYPE || type == Integer.class;
    }

}
