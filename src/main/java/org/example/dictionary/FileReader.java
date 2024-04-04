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


    public Map<String, String> convert() {
        ObjectMapper mapper = new ObjectMapper();
        Map<String, String> map = new HashMap<>();
        try {
            InputStream is = new FileInputStream(new File(filePath));
            List<Map<String, String>> list = mapper.readValue(is, new TypeReference<List<Map<String, String>>>() {
            });
            for (Map<String, String> item : list) {
                map.putAll(item);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return map;
    }
}
