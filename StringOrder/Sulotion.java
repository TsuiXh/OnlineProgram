import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class Solution {
    public ArrayList<String> Permutation(String str) {
        ArrayList<String> result = new ArrayList<>();

        if (null == str || str.length() < 1) {
            return result;
        }

        char[] charArray = str.toCharArray();
        HashSet<String> mediateResult = new HashSet<>();
        fullPermutation(mediateResult, charArray, 0, charArray.length - 1);
        result.addAll(mediateResult);
        Collections.sort(result);
        return result;

    }

    private void fullPermutation(HashSet<String> mediateResult, char[] charArray, int start, int end) {
        if (start == end) {
            StringBuilder sb = new StringBuilder();
            for (char c : charArray) {
                sb.append(c);
            }
            mediateResult.add(sb.toString());
            return;
        } else {
            for (int i = start; i <= end; ++i) {
                swap(charArray, start, i);
                fullPermutation(mediateResult, charArray, start + 1, end);
                swap(charArray, start, i);
            }
        }
    }

    private void swap(char[] targetArray, int start, int end) {
        char temp;
        temp = targetArray[start];
        targetArray[start] = targetArray[end];
        targetArray[end] = temp;
    }
 }
