package service;

import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.TreeMap;

@Service
public class DictionaryServiceImpl implements DictionaryService {
    @Override
    public String search(String string) {
        Map<String, String> dictionaryMap = new TreeMap<>();
        dictionaryMap.put("Một", "One");
        dictionaryMap.put("Hai", "Two");
        dictionaryMap.put("Ba", "Three");
        dictionaryMap.put("Bốn", "Four");
        dictionaryMap.put("Năm", "Five");
        String result = dictionaryMap.get(string);
        return result;
    }
}
