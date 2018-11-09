package hm.collection;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NothingTest {
    @Test
    void doesNotExist() {
        assertFalse(Maybe.nothing().exists());
    }
    
    @Test
    void mapReturnsSelf() {
        assertSame(Maybe.nothing(), Maybe.nothing().map((ignored) -> {
            throw new RuntimeException();
        }));
    }
    
    @Test
    void doesNotRun() {
        Maybe.nothing().run((ignored) -> {
            throw new RuntimeException();
        });
    }
    
    @Test
    void orReturnsPassedValue() {
        assertEquals("default", Maybe.nothing().or("default"));
    }
    
    @Test
    void orMaybeReturnsOtherMaybe() {
        Maybe<String> otherMaybe = Maybe.of("value");
        assertSame(otherMaybe, Maybe.nothing().or(otherMaybe));
    }
    
    @Test
    void orSupplierRunsSupplier() {
        assertEquals("computed", Maybe.nothing().or(() -> "computed"));
    }
    
    @Test
    void orThrowThrows() {
        assertThrows(RuntimeException.class,
                     () -> Maybe.nothing().orThrow(RuntimeException::new));
    }
    
    @Test
    void ofNullIsNothing() {
        assertSame(Maybe.nothing(), Maybe.of(null));
    }
}
