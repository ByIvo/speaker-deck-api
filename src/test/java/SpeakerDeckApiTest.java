import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SpeakerDeckApiTest {

    @Test
    public void shouldFetchTheSpeakerProfile() {
        SpeakerProfile speakerProfile = new SpeakerDeckApi().fetch("wagnerfusca");
        Assertions.assertEquals("Wagner Voltz - Fusca", speakerProfile.getDisplayName(), "It got the wrong display name");
        Assertions.assertEquals(8 , speakerProfile.getCountOfTalks(), "It got the wrong count of talks -- Did you check whether they've changed their profile or not?");
    }
}