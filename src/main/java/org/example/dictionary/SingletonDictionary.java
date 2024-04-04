package org.example.dictionary;

import java.io.IOException;
import java.util.Map;

public class SingletonDictionary {
    private static SingletonDictionary instance = null;
    private final FileReader fileReader = new FileReader();
    private final Map<String, String> dictionary;

    private SingletonDictionary() throws IOException {
        dictionary = fileReader.convert();
    }

    public static SingletonDictionary getInstance() throws IOException {
        if (instance == null) {
            instance = new SingletonDictionary();
        }
        return instance;
    }

    public void addWord(String word, String definition) {
        dictionary.put(word, definition);
    }

    public void removeWord(String word) {
        dictionary.remove(word);
    }

    public String getTranslation(String word) {
        return dictionary.get(word);
    }

    public boolean containsWord(String word) {
        return dictionary.containsKey(word);
    }

    public Map<String, String> getAllWords() {
        return dictionary;
    }
}
