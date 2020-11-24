package service.Impl;

import org.springframework.stereotype.Service;
import service.DictionaryService;

import java.util.Map;
import java.util.TreeMap;

@Service
public class DictionaryServiceImpl implements DictionaryService {
    private static Map<String, String> dictionaryMap = new TreeMap<>();

    static {
        dictionaryMap.put("Một", "One");
        dictionaryMap.put("Hai", "Two");
        dictionaryMap.put("Ba", "Three");
        dictionaryMap.put("Bốn", "Four");
        dictionaryMap.put("Năm", "Five");
    }

    @Override
    public String search(String string) {
        return dictionaryMap.get(string);
    }
}
