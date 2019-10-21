package poc.validations;

public interface Validavel<T> {

    boolean apply(T validable);
}
