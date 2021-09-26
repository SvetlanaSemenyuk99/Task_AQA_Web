package Pages2;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class Api {

    public String convertAPIImage() throws IOException, InterruptedException {

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("http://apimeme.com/meme?meme=Alarm-Clock&top=Top+text&bottom=Bottom+text"))
                .build();

        HttpResponse<String> response = client.send(request,
                HttpResponse.BodyHandlers.ofString());
        String image = response.body();
        String encoded = Base64.getEncoder().encodeToString(image.getBytes(StandardCharsets.UTF_8));
        //System.out.println(encoded);
        return encoded;

    }

    public String convertJPEGImage() throws IOException {
        File myfile = new File("src/image/meme.jpg");
        String contents = FileUtils.readFileToString(myfile,
                StandardCharsets.UTF_8.name());
        String encoded2 = Base64.getEncoder().encodeToString(contents.getBytes(StandardCharsets.UTF_8));
        //System.out.println(encoded2);
        return encoded2;
    }

}
