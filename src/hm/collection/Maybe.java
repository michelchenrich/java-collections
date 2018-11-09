package hm.collection;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public interface Maybe<T> {
    static <T> Maybe<T> nothing() {
        return Nothing.INSTANCE;
    }
    
    static <T> Maybe<T> of(T value) {
        return value == null ? nothing() : new Something<>(value);
    }
    
    boolean exists();
    
    <M> Maybe<M> map(Function<T, M> mapper);
    
    void run(Consumer<T> consumer);
    
    T or(T value);
    
    T or(Supplier<T> valueSupplier);
    
    <EX extends Throwable> T orThrow(Supplier<EX> throwableSupplier) throws EX;
}
