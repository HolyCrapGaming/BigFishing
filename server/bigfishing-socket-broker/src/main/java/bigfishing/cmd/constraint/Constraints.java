package bigfishing.cmd.constraint;

/**
 * User: zhaoyao
 * Date: 11-5-27
 * Time: PM6:30
 */
public class Constraints {

    public static final Constraint<Integer> POSITIVE_INTEGER =
            new IntegerRangeBasedConstraint(0, Integer.MAX_VALUE);


}
