package hm.collection;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmptyListTest {
    @Test
    void empty() {
        assertTrue(List.empty().isEmpty());
    }
    
    @Test
    void zeroCount() {
        assertEquals(0, List.empty().count());
    }
    
    @Test
    void runDoesNotRun() {
        List.empty().run((ignored) -> {
            throw new RuntimeException();
        });
    }
    
    @Test
    void indexedRunDoesNotRun() {
        List.empty().run((index, ignored) -> {
            throw new RuntimeException();
        });
    }
    
    @Test
    void mapReturnsSelf() {
        assertSame(List.empty(), List.empty().map((ignored) -> {
            throw new RuntimeException();
        }));
    }
    
    @Test
    void reduceReturnsNothing() {
        assertFalse(List.empty().reduce((a, b) -> {
            throw new RuntimeException();
        }).exists());
    }
    
    @Test
    void safeReduceReturnsStartingValue() {
        assertEquals("start",
                     List.empty().reduce("start",
                                         (a, b) -> {
                                             throw new RuntimeException();
                                         }));
    }
}
