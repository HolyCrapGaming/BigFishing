package bigfishing.cmd.exception;


import bigfishing.cmd.Argument;

/**
 * User: zhaoyao
 * Date: 11-5-27
 * Time: PM5:24
 */
public class StringArgumentLengthNotProvidedException extends InvalidArgumentException{

    public StringArgumentLengthNotProvidedException(Argument argCode) {
        super(argCode);
    }

}
