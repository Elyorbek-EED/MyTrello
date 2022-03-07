package uz.boom.ergashov.exceptions;

/**
 * Created by Elyor Ergashov
 *
 * @author : mreed
 * @date : 3/7/2022
 * @project : mealDeliver
 */

public class ValidationException extends RuntimeException {
    public ValidationException(String message) {
        super(message);
    }
}
