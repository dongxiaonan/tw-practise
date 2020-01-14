package com.thoughtworks.marsrover;

import com.thoughtworks.marsrover.model.Direction;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class HelloWorldTest {
    @Test
    public void hello_world_test() {
        //given
        Dependency dependency = new Dependency();
        HelloWorld helloWorld = new HelloWorld(dependency);

        //when
        String actual = helloWorld.beenCalled();

        //then
        assertEquals(actual,"Leave me alone.");
    }

    @Test
    public void should_be_mocked() {
        //given
        Dependency dependency = mock(Dependency.class);
        when(dependency.say()).thenReturn("Hello World");
        HelloWorld helloWorld = new HelloWorld(dependency);

        //when
        String actual = helloWorld.beenCalled();

        //then
        assertEquals(actual, "Hello World");
    }
    @Test
    public void  test(){
        Direction[] values = Direction.values();
        Direction x = Direction.valueOf("N");
        int hashCode = Direction.N.hashCode();
        int ordinal = Direction.N.ordinal();
        assertTrue(true);
    }
}
