package bigfishing.cmd.constraint;

import bigfishing.cmd.Argument;
import bigfishing.cmd.exception.InvalidArgumentException;

/**
 * User: zhaoyao
 * Date: 11-5-27
 * Time: PM6:14
 */
public class IntegerRangeBasedConstraint extends SimpleConstraint<Integer> {

    private int min;
    private int max;

    public IntegerRangeBasedConstraint(int min, int max) {
        this.min = min;
        this.max = max;
    }


    @Override
    public boolean apply(Integer value) throws InvalidArgumentException {
        return value > min && value < max;
    }
}