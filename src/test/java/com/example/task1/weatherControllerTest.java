package com.example.task1;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(MockitoJUnitRunner.class)
public class weatherControllerTest {
    private MockMvc mockMvc;

    @InjectMocks
    private weatherController subject;

    @Mock
    private weatherService Service;

    @Captor
    private ArgumentCaptor<String> stringArgumentCaptor;

    @Before
    public void setup(){

        mockMvc = MockMvcBuilders.standaloneSetup(subject).build();
    }

    @Test
    public void getCurrentWeatherByCity_Success() throws Exception
    {
        when(Service.getweatherByCityName(stringArgumentCaptor.capture())).thenReturn(new WeatherResponse(21.8));
        String url= "/api/v1/{city}";

        MvcResult mvcResult = this.mockMvc.perform(get(url,"OMAHA")).andExpect(status().isOk()).andReturn();

        verify(Service,times(1)).getweatherByCityName(anyString());
        assertEquals("OMAHA",stringArgumentCaptor.getValue());
        assertEquals(HttpStatus.OK.value(),
                mvcResult.getResponse().getStatus());
        assertEquals("{\"temp\":21.8}",mvcResult.getResponse().getContentAsString());

    }

}