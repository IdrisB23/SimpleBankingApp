package banking.model.dataComputer;

public interface DataComputer<T> {
    T computeData(T s) throws Exception;
}
