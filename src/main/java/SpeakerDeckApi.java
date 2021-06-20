import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class SpeakerDeckApi {

    public static void main(String[] args) {
        String username = args[0];
        SpeakerProfile speakerProfile = new SpeakerDeckApi().fetch(username);
        System.out.println(speakerProfile);
    }

    public SpeakerProfile fetch(String username) {
        String displayName =  "Not Found";
        int countOfTalks = 0;
        try {
            Document doc = Jsoup.connect("https://speakerdeck.com/" + username).get();
            displayName = extractDisplayNameFromDocument(doc);
            countOfTalks = extractCountOfTalksFromDocument(doc);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return new SpeakerProfile(displayName, countOfTalks);
    }

    private String extractDisplayNameFromDocument(Document doc) {
        String pageTitle = doc.title();

        // The tile tag contains: Wagner Voltz - Fusca (@wagnerfusca) on Speaker Deck
        return pageTitle.substring(0, pageTitle.indexOf('(')).trim();
    }

    private int extractCountOfTalksFromDocument(Document doc) {
        return doc.select("a div.deck-preview").size();
    }
}
