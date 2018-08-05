package loader;

import java.util.Map;

public interface ConfigurationLoader {
    Map<String, String> load() throws Exception;
}