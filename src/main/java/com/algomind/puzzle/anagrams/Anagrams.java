package com.algomind.puzzle.anagrams;

import java.util.ArrayList;
import java.util.List;

public class Anagrams {
    public List<String> findAnagram(String word) {
        if(word.length() == 1) return List.of(word);

        List<String> results = new ArrayList<>();
        for(int i = 0 ; i < word.length() ; i++) {
            char character = word.charAt(i);
            String subStr = getSubStringWithoutChari(i, word);
            List<String> subResults = findAnagram(subStr);
            subResults.stream().map(result -> character + result).forEach(results::add);
        }

        return results;
    }

    private String getSubStringWithoutChari(int i, String word) {
        if(i == 0) return word.substring(i + 1);
        else if(i == word.length() - 1) return word.substring(0, i);
        else return word.substring(0, i) + word.substring(i + 1);
    }
}
