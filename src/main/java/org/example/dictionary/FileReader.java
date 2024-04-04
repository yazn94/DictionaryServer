package org.example.dictionary;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.NoArgsConstructor;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@NoArgsConstructor
public class FileReader {
    private final String filePath = "src/main/resources/words.json";

    public Map<String, String> convert() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        Map<String, String> map = new HashMap<>();
        File file = new File(filePath);
        if (!file.exists() || !file.canRead()) {
            throw new IOException("File does not exist or cannot be read: " + filePath);
        }
        try (InputStream is = new FileInputStream(file)) {
            List<Map<String, String>> list = mapper.readValue(is, new TypeReference<List<Map<String, String>>>() {
            });
            for (Map<String, String> item : list) {
                map.putAll(item);
            }
        } catch (IOException e) {
            throw new IOException("Error reading or parsing file: " + filePath, e);
        }
        return map;
    }
}
