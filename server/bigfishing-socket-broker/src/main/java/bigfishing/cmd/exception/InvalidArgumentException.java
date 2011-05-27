package bigfishing.cmd.exception;

import bigfishing.cmd.Argument;
import bigfishing.exceptions.BigFishingException;
import bigfishing.utils.I18nAware;

/**
 * User: zhaoyao
 * Date: 11-5-27
 * Time: PM5:12
 */
public class InvalidArgumentException extends BigFishingException implements I18nAware{

    protected Argument arg;
    //todo, 附加详细说明？

    public InvalidArgumentException(Argument arg) {
        this.arg = arg;
    }

    public Argument getArgument() {
        return arg;
    }

    @Override
    public String getLanguageEntryKey() {
        return "error." + arg.getCode();
    }
}
