package com.tus.roomservice;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class RoomTest {

    @Test
    public void testGettersAndSetters() {
        long id = 1L;
        String Type = "Single Room";
        String roomId = "1001";
        String bedSize = "King Size Bed";

        Room room = new Room(0, roomId, bedSize);
        room.setId(id);
        room.setRoomName(Type);
        room.setRoomNumber(roomId);
        room.setBedInfo(bedSize);

        assertThat(room.getId()).isEqualTo(id);
        assertThat(room.getRoomName()).isEqualTo(Type);
        assertThat(room.getRoomNumber()).isEqualTo(roomId);
        assertThat(room.getBedInfo()).isEqualTo(bedSize);
    }
}
