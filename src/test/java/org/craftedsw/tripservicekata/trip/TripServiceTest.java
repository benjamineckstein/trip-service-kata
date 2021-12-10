package org.craftedsw.tripservicekata.trip;

import org.craftedsw.tripservicekata.user.User;
import org.craftedsw.tripservicekata.user.UserSession;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class TripServiceTest {

    @Test
    void getTripsByUserTest() {
        //given
        User user = new User();
        User loggedInUser = new User();

        user.addTrip(new Trip());
        user.addFriend(loggedInUser);

        UserSession userSession = mock(UserSession.class);
        when(userSession.getLoggedUser()).thenReturn(loggedInUser);

        try (MockedStatic<TripDAO> tripDAOMockedStatic = Mockito.mockStatic(TripDAO.class)) {
            tripDAOMockedStatic.when(() -> TripDAO.findTripsByUser(user)).thenReturn(user.trips());
            var cut = new TripService(userSession);
            final List<Trip> tripsByUser = cut.getTripsByUser(user);

            assertThat(tripsByUser).isNotNull();
            assertThat(tripsByUser.size()).isEqualTo(1);
        }
    }
}



