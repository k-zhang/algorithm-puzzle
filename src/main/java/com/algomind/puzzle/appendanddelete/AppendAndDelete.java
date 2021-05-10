package com.algomind.puzzle.appendanddelete;

public class AppendAndDelete {
    String appendAndDelete(String s, String t, int k) {
        if(k >= s.length() + t.length()) return "Yes";

        char[] sCharArray = s.toCharArray();
        char[] tCharArray = t.toCharArray();

        int searchLength = Math.min(sCharArray.length, tCharArray.length);

        int diffIndex = -1;
        int currentIndex = 0;
        for(int i = 0 ; i < searchLength ; i ++) {
            currentIndex = i;
            if(sCharArray[i] != tCharArray[i]) {
                diffIndex = i;
                break;
            }
        }

        if(diffIndex == -1) {
            if(currentIndex == sCharArray.length - 1) {
                return isSuccess(k, tCharArray.length - currentIndex - 1) ? "Yes" : "No";
            }else if(currentIndex == t.length() - 1) {
                return isSuccess(k, sCharArray.length - currentIndex - 1) ? "Yes" : "No";
            }else{
                return "No";
            }
        }else{
            int requiredMove = (sCharArray.length - diffIndex) + (tCharArray.length - diffIndex);
            boolean success = isSuccess(k, requiredMove);
            return success ? "Yes" : "No";
        }
    }

    private boolean isSuccess(int k, int requiredMove) {
        return k == requiredMove || (k > requiredMove && (k - requiredMove) % 2 == 0);
    }
}
