package hm.collection;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

enum Nothing implements Maybe {
    INSTANCE;
    
    public boolean exists() {
        return false;
    }
    
    public void run(Consumer ignored) {
    }
    
    public Object or(Object value) {
        return value;
    }
    
    public Object or(Supplier valueSupplier) {
        return valueSupplier.get();
    }
    
    public Object orThrow(Supplier throwableSupplier) throws Throwable {
        throw (Throwable) throwableSupplier.get();
    }
    
    public Maybe map(Function mapper) {
        return this;
    }
}
