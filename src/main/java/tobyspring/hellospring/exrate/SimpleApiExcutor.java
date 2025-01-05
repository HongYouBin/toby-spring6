package tobyspring.hellospring.exrate;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URLConnection;
import java.util.stream.Collectors;

public class SimpleApiExcutor implements ApiExecutor {
    @Override
    public String execute(URI uri) throws IOException {
        URLConnection urlConnection = uri.toURL().openConnection();
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()))) {
            return bufferedReader.lines().collect(Collectors.joining());
        }
    }
}
