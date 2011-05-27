package bigfishing.cmd.constraint;

import bigfishing.cmd.exception.InvalidArgumentException;

/**
 * User: zhaoyao
 * Date: 11-5-27
 * Time: PM6:14
 */
public interface ValidationFunction<T> {
    boolean validate(T value) throws InvalidArgumentException;
}