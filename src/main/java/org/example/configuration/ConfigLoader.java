package org.example.configuration;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.nio.file.Path;

public class ConfigLoader {

    private ConfigLoader() {}

    public static ConfigSimulateur load(Path path) throws IOException {
        return new ObjectMapper().readValue(path.toFile(), ConfigSimulateur.class);
    }
}
