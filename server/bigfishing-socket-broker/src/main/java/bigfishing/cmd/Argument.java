package bigfishing.cmd;

import bigfishing.cmd.constraint.Constraint;
import bigfishing.cmd.constraint.Constraints;

import java.util.Arrays;
import java.util.List;

/**
 * User: zhaoyao
 * Date: 11-5-27
 * Time: PM5:16
 */
public class Argument<T> {

    public static final Argument<Integer> TYPE_OF_ROOM =
            new Argument<Integer>(Integer.TYPE, 101, Constraints.POSITIVE_INTEGER);

    public static final Argument<Boolean> IS_ROOM_ENCRYPTED = new Argument<Boolean>(Boolean.TYPE, 102);
    public static final Argument<String> NAME_OF_ROOM = new Argument<String>(String.class, 103);
    public static final Argument<String> PASSWORD_OF_ROOM = new Argument<String>(String.class, 104);

    private int code;
    private Class<T> type;
    private List<Constraint> constraints;

    private Argument(Class<T> type, int code, Constraint... constraints) {
        this.type = type;
        this.code = code;
        this.constraints = Arrays.asList(constraints);
    }

    public Class<T> getType() {
        return type;
    }

    public int getCode() {
        return code;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Argument argument = (Argument) o;

        if (code != argument.code) return false;
        if (type != null ? !type.equals(argument.type) : argument.type != null) return false;

        return true;
    }

    public List<Constraint> getConstraints() {
        return constraints;
    }

    @Override
    public int hashCode() {
        int result = code;
        result = 31 * result + (type != null ? type.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Argument{" +
                "code=" + code +
                ", type=" + type +
                '}';
    }
}
