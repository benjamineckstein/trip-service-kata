package org.craftedsw.tripservicekata.trip;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Collections;

import static java.util.Collections.emptyList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class TripServiceTest {

    @Test
    void simpleAssertTest() {
        assertThat(new Object()).isNotNull();
    }

    @Test
    void simpleMockTest() {
        TripService tripService = mock(TripService.class);
        when(tripService.getTripsByUser(any())).thenReturn(emptyList());
        assertThat(tripService.getTripsByUser(null)).isEqualTo(emptyList());
    }

}
