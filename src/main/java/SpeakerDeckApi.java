import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

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
            String body = getHTMLBodyContentFromUsernameProfile(username);

            String pageTitle = getTitleTagValueFromBody(body);
            return extractDisplayNameFromTitleTagValue(pageTitle);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Not Found";
    }

    private String getHTMLBodyContentFromUsernameProfile(String username) throws java.io.IOException, InterruptedException {
        HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest httpRequest = HttpRequest.newBuilder()
                .uri(URI.create("https://speakerdeck.com/" + username))
                .build();

        return httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString()).body();
    }

    private String getTitleTagValueFromBody(String body) {
        int start = body.indexOf("<title>") + "<title>".length();
        int end = body.indexOf("</title>", start);

       return body.substring(start, end);
    }

    private String extractDisplayNameFromTitleTagValue(String pageTitle) {
        // The tile tag contains: Wagner Voltz - Fusca (@wagnerfusca) on Speaker Deck
        return pageTitle.substring(0, pageTitle.indexOf('(')).trim();
    }
}
