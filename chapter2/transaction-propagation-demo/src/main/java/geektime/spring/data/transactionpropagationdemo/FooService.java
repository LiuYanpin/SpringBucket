package geektime.spring.data.transactionpropagationdemo;

public interface FooService {
    void insertThenRollback() throws RollbackException;
    void invokeInsertThenRollback();
}
