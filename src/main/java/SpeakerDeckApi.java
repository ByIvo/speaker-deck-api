import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

public class SpeakerDeckApi {
    public boolean isWorking() {
        return true;
    }

    public SpeakerProfile fetch(String username) {
        String displayName = fetchDisplayName(username);

        return new SpeakerProfile(displayName, 8);
    }

    private String fetchDisplayName(String username) {
        try {
            String pageTitle = getTitleTagValueFromUsernameHomepage(username);
            return extractDisplayNameFromTitleTagValue(pageTitle);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Not Found";
    }

    private String getTitleTagValueFromUsernameHomepage(String username) throws IOException {
        Document doc = Jsoup.connect("https://speakerdeck.com/" + username).get();
        return doc.title();
    }

    private String extractDisplayNameFromTitleTagValue(String pageTitle) {
        // The tile tag contains: Wagner Voltz - Fusca (@wagnerfusca) on Speaker Deck
        return pageTitle.substring(0, pageTitle.indexOf('(')).trim();
    }
}
