public class SpeakerProfile {

    private final String displayName;
    private final int countOfTalks;

    public SpeakerProfile(String displayName, int countOfTalks) {
        this.displayName = displayName;
        this.countOfTalks = countOfTalks;
    }

    public String getDisplayName() {
        return displayName;
    }

    public int getCountOfTalks() {
        return countOfTalks;
    }

    @Override
    public String toString() {
        return "SpeakerProfile{" +
                "displayName='" + displayName + '\'' +
                ", countOfTalks=" + countOfTalks +
                '}';
    }
}
