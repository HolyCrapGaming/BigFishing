package bigfishing.cmd.exception;

import bigfishing.exceptions.BigFishingException;

/**
 * User: zhaoyao
 * Date: 11-5-27
 * Time: PM8:02
 */
public class UnknownCommandException extends BigFishingException {


    private byte type;

    public UnknownCommandException(byte type) {
        super("Unknown command: " + type);
        this.type = type;
    }

    public byte getType() {
        return type;
    }


    @Override
    public String getLanguageEntryKey() {
        return "error.unknown.command." + type;
    }
}
