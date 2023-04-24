package com.tus.roomservice;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.assertj.core.api.Assert;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.netflix.discovery.shared.Application;


public class RoomWebServiceTest {

	@Mock
    private RoomRepository roomRepository;

    @InjectMocks
    private RoomWebService roomWebService;

	@Autowired
	private MockMvc mockMvc;



	 @BeforeEach
	    public void setup() {
	        MockitoAnnotations.initMocks(this);
	        roomWebService = new RoomWebService(roomRepository);
	    }

	    @Test
	    public void totalrooms() {
	        Room roomaug = new Room(1, "Room Aug", "single");
	        Room roomsep = new Room(2, "Room Sep","small");
	        Mockito.when(roomRepository.findAll()).thenReturn(Arrays.asList(roomaug, roomsep));
	        Iterable<Room> results = roomWebService.getAllRooms();
	        assertThat(results).hasSize(2);
	        assertThat(results).contains(roomaug, roomsep);
	    }

	    @Test
	    public void Roomcheck() {
	        Room roommoon = new Room(1, "Room Moon", "Double Large");
	        Mockito.when(roomRepository.findById(1L)).thenReturn(Optional.of(roommoon));

	        Room resulting = roomWebService.getRoom(1);

	        assertThat(resulting).isEqualTo(roommoon);

	}
} 
	







