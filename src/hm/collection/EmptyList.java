package hm.collection;

import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;

enum EmptyList implements List {
    INSTANCE;
    
    public boolean isEmpty() {
        return true;
    }
    
    public long count() {
        return 0;
    }
    
    public void run(Consumer ignored) {
    }
    
    public void run(BiConsumer ignored) {
    }
    
    public Maybe reduce(BiFunction ignored) {
        return Maybe.nothing();
    }
    
    public Object reduce(Object startValue, BiFunction ignored) {
        return startValue;
    }
    
    public List map(Function ignored) {
        return this;
    }
}
