package org.sfstudy.homework.loader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class USStatesLoader implements ConfigurationLoader {

    public Map<String, String> load() throws IOException {
        Path path = Paths.get("USStates.cfg");
        Stream<String> stream = Files.lines(path);
        return stream.map(pair -> pair.split("=")).collect(Collectors.toMap(pair -> pair[0], pair -> pair[1]));
    }
}