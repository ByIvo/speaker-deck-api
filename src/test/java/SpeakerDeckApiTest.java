import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SpeakerDeckApiTest {

    @Test
    public void shouldWork() {
        boolean isWorking = new SpeakerDeckApi().isWorking();
        Assertions.assertTrue(isWorking, "SpeakerDeckAPI is not working!");
    }
}