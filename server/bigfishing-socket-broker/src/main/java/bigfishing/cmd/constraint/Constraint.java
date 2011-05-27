package bigfishing.cmd.constraint;

import bigfishing.cmd.Argument;
import bigfishing.cmd.exception.InvalidArgumentException;

import java.util.List;

/**
 * User: zhaoyao
 * Date: 11-5-27
 * Time: PM5:58
 */
public interface Constraint<T> {



    void apply(Argument<T> arg, T value);




}
