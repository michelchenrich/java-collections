package hm.collection;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

class Something<T> implements Maybe<T> {
    private T value;
    
    Something(T value) {
        this.value = value;
    }
    
    public boolean exists() {
        return true;
    }
    
    public <M> Maybe<M> map(Function<T, M> mapper) {
        return Maybe.of(mapper.apply(value));
    }
    
    public <M> Maybe<M> flatMap(Function<T, Maybe<M>> mapper) {
        return mapper.apply(value);
    }
    
    public void run(Consumer<T> consumer) {
        consumer.accept(value);
    }
    
    public T or(T ignored) {
        return value;
    }
    
    public T or(Supplier<T> ignored) {
        return value;
    }
    
    public <EX extends Throwable> T orThrow(Supplier<EX> ignored) {
        return value;
    }
    
    public boolean equals(Object other) {
        return other instanceof Something &&
               equalsSomething((Something) other);
    }
    
    private boolean equalsSomething(Something other) {
        return this.value.equals(other.value);
    }
    
    public int hashCode() {
        return value.hashCode();
    }
}
