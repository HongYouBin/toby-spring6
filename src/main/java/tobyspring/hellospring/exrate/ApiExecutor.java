package tobyspring.hellospring.exrate;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;

public interface ApiExecutor {
    String execute(URI uri) throws MalformedURLException, IOException;
}
