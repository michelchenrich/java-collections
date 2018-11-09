package hm.collection;

import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;

public interface List<T> {
    static <T> List<T> empty() {
        return EmptyList.INSTANCE;
    }
    
    boolean isEmpty();
    
    long count();
    
    void run(Consumer<T> consumer);
    
    void run(BiConsumer<Long, T> consumer);
    
    <M> List<M> map(Function<T, M> mapper);
    
    Maybe<T> reduce(BiFunction<T, T, T> reducer);
    
    T reduce(T startValue, BiFunction<T, T, T> reducer);
}
