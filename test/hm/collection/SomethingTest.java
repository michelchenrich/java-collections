package hm.collection;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SomethingTest {
    @Test
    void equalsOtherWithSameValue() {
        assertEquals(Maybe.of("something"),
                     Maybe.of("something"));
    }
    
    @Test
    void differsFromOtherNotTypedAsSomething() {
        assertNotEquals("something",
                        Maybe.of("something"));
    }
    
    @Test
    void hashCodeEqualsValue() {
        assertEquals("something".hashCode(),
                     Maybe.of("something").hashCode());
    }
    
    @Test
    void doubleMaybeIsFlattened() {
        assertEquals(Maybe.of("something"),
                     Maybe.of(Maybe.of("something")));
    }
    
    @Test
    void exists() {
        assertTrue(Maybe.of("something").exists());
    }
    
    @Test
    void mapToNothing() {
        assertSame(Maybe.nothing(),
                   Maybe.of("something").map((ignored) -> null));
    }
    
    @Test
    void mapToSomethingElse() {
        assertEquals(Maybe.of("SOMETHING"),
                     Maybe.of("something").map(String::toUpperCase));
    }
    
    @Test
    void runsWithValue() {
        StringBuilder builder = new StringBuilder();
        Maybe.of("something").run(builder::append);
        assertEquals("something", builder.toString());
    }
    
    @Test
    void orReturnsOwnValue() {
        assertEquals("something",
                     Maybe.of("something").or("something else"));
    }
    
    @Test
    void computedOrReturnsOwnValue() {
        assertEquals("something",
                     Maybe.of("something").or(() -> "something else"));
    }
    
    @Test
    void orThrowReturnsOwnValue() {
        assertEquals("something",
                     Maybe.of("something").orThrow(RuntimeException::new));
    }
}
