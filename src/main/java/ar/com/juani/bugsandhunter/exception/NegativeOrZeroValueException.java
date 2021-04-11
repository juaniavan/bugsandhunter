package ar.com.juani.bugsandhunter.exception;

/**
 * General exception for non accepted negative values
 * 
 * @author javantario
 *
 */
public class NegativeOrZeroValueException extends RuntimeException {

    public NegativeOrZeroValueException(String message) {
        super(message);
    }

    /**
     * 
     */
    private static final long serialVersionUID = -8802596811475307366L;

}
