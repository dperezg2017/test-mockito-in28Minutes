package com.in28minutes.business;

import org.junit.Test;
import org.mockito.BDDMockito;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;
import java.util.List;

public class ListTest {


    @Test
    public void letsMockListGet(){
        List listMock = mock(List.class);
        when(listMock.get(0)).thenReturn("in28Minutes");
        assertEquals("in28Minutes",listMock.get(0));
        assertEquals(null,listMock.get(1));
    }

    @Test
    public void letsMockListGet_2(){
        List listMock = mock(List.class);
        when(listMock.get(anyInt())).thenReturn("in28Minutes");
        assertEquals("in28Minutes",listMock.get(0));
        assertEquals("in28Minutes",listMock.get(1));
        assertEquals("in28Minutes",listMock.get(2));
        assertEquals("in28Minutes",listMock.get(3));
    }

    @Test
    public void letsMockListGet_usingBDD(){
        List<String> listMock = mock(List.class);
        BDDMockito.given(listMock.get(anyInt())).willReturn("in28Minutes");
        String firstElement = listMock.get(0);

       // assertEquals(firstElement,is("in28Minutes"));

    }

    @Test(expected = RuntimeException.class)
    public void letsMockListGet_3(){
        List listMock = mock(List.class);
        when(listMock.get(anyInt())).thenThrow(new RuntimeException("Something"));
        listMock.get(0);
    }

    @Test
    public void letsMockListSizeMethod_ReturnMultipleValues(){
        List listMock = mock(List.class);
        when(listMock.size()).thenReturn(2).thenReturn(3).thenReturn(4).thenReturn(5).thenReturn(6);
        assertEquals(2,listMock.size());
        assertEquals(3,listMock.size());
        assertEquals(4,listMock.size());
        assertEquals(5,listMock.size());
        assertEquals(6,listMock.size());
    }

    @Test
    public void letsMockListSizeMethod(){
        List listMock = mock(List.class);
        when(listMock.size()).thenReturn(2);
        assertEquals(2,listMock.size());
    }
}
