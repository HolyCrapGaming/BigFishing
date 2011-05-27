package bigfishing.cmd.constraint;

import bigfishing.cmd.Argument;
import bigfishing.cmd.exception.InvalidArgumentException;

/**
 * User: zhaoyao
 * Date: 11-5-27
 * Time: PM6:28
 */
public abstract class SimpleConstraint<T> implements Constraint<T>{


    @Override
    public void apply(Argument<T> arg, T value) {
        if (!apply(value)) {
            throw new InvalidArgumentException(arg);
        }
    }

    protected abstract boolean apply(T value);
}
