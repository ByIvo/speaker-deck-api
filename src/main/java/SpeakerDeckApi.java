public class SpeakerDeckApi {
    public boolean isWorking() {
        return true;
    }

    public SpeakerProfile fetch(String username) {
        return new SpeakerProfile("Wagner Voltz - Fusca", 8);
    }
}
