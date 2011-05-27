package bigfishing.exceptions;

import bigfishing.utils.I18nAware;

/**
 * User: zhaoyao
 * Date: 11-5-26
 * Time: AM12:59
 */
public class BigFishingException extends RuntimeException implements I18nAware{

    private static final long serialVersionUID = 1L;

    public BigFishingException() {
    }

    public BigFishingException(String message) {
        super(message);
    }

    public BigFishingException(String message, Throwable cause) {
        super(message, cause);
    }

    public BigFishingException(Throwable cause) {
        super(cause);
    }

    @Override
    public String getLanguageEntryKey() {
        return null;
    }
}
