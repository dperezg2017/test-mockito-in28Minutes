package com.in28minutes.business;

import org.junit.Assert;
import org.junit.Test;
import static org.mockito.Mockito.*;
import java.util.ArrayList;
import java.util.List;

public class SpyTest {


    @Test
    public void test(){
        List arrayListMock = mock(ArrayList.class);
        when(arrayListMock.size()).thenReturn(5);
        Assert.assertEquals(5,arrayListMock.size());
    }

    @Test
    public void test_1(){
        List arrayListMock = mock(ArrayList.class);
        Assert.assertEquals(0,arrayListMock.size());
        // mocks return default value
        when(arrayListMock.size()).thenReturn(5);
        arrayListMock.add("Dummy");
        Assert.assertEquals(5,arrayListMock.size());
    }

    @Test
    public void test_2(){
        List arrayListSpy = spy(ArrayList.class);
        Assert.assertEquals(0,arrayListSpy.size());
        arrayListSpy.add("Dummy");
        Assert.assertEquals(1,arrayListSpy.size());
        arrayListSpy.remove("Dummy");
        Assert.assertEquals(0,arrayListSpy.size());
    }

    @Test
    public void test_3(){
        List arrayListSpy = spy(ArrayList.class);
        when(arrayListSpy.size()).thenReturn(5);
        Assert.assertEquals(5,arrayListSpy.size());
    }

    @Test
    public void test_4(){
        List arrayListSpy = spy(ArrayList.class);
        arrayListSpy.add("Dummy");
        verify(arrayListSpy).add("Dummy");
        verify(arrayListSpy,never()).clear();
    }

}
