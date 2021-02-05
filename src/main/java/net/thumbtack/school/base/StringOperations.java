package net.thumbtack.school.base;

public class StringOperations {
    public static int getSummaryLength(String[] strings) {
        int length = 0;
        for (String elem:strings) {
            length+=elem.length();
        }
        return  length;
    }

    public static String getFirstAndLastLetterString(String string){
        return string.substring(0,1).concat(string.substring(string.length()-1));
    }

    public static boolean isSameCharAtPosition(String string1, String string2, int index){
        return string1.charAt(index) == string2.charAt(index);
    }

    public static boolean isSameFirstCharPosition(String string1, String string2, char character){
        return string1.indexOf(character) == string2.indexOf(character);
    }

    public static boolean isSameLastCharPosition(String string1, String string2, char character){
        return string1.lastIndexOf(character) == string2.lastIndexOf(character);
    }

    public static boolean isSameFirstStringPosition(String string1, String string2, String str){
        return string1.indexOf(str) == string2.indexOf(str);
    }

    public static boolean isSameLastStringPosition(String string1, String string2, String str){
        return string1.lastIndexOf(str) == string2.lastIndexOf(str);
    }

    public static boolean isEqual(String string1, String string2){
        return string1.equals(string2);
    }

    public static boolean isEqualIgnoreCase(String string1, String string2){
        return string1.equalsIgnoreCase(string2);
    }

    public static boolean isLess(String string1, String string2){
        return  string1.compareTo(string2) < 0;
    }

    public static boolean isLessIgnoreCase(String string1, String string2){
        return  string1.compareToIgnoreCase(string2) < 0;
    }

    public static String concat(String string1, String string2){
        return string1.concat(string2);
    }

    public static boolean isSamePrefix(String string1, String string2, String prefix){
        return string1.startsWith(prefix) & string2.startsWith(prefix);
    }

    public static boolean isSameSuffix(String string1, String string2, String suffix){
        return string1.endsWith(suffix) & string2.endsWith(suffix);
    }

    public static String getCommonPrefix(String string1, String string2){
        if (string1.charAt(0) != string2.charAt(0)) return "";
        StringBuilder prefix = new StringBuilder();
        prefix.append(string1.charAt(0));
        for (int i = 1; i<string1.length() & i<string2.length(); i++){
            if (string1.charAt(i) == string2.charAt(i))
                prefix.append(string1.charAt(i));
        }
        return prefix.toString();
    }

    public static String reverse(String string){
        StringBuilder reversedStr = new StringBuilder(string);
        return reversedStr.reverse().toString();
    }

    public static boolean isPalindrome(String string){
        return isEqual(string,reverse(string));
    }

    public static boolean isPalindromeIgnoreCase(String string){
        return isEqualIgnoreCase(string,reverse(string));
    }

    public static String getLongestPalindromeIgnoreCase(String[] strings){
        StringBuilder longestPalindrome = new StringBuilder();
        for (String elem: strings)
            if (isPalindromeIgnoreCase(elem) & elem.length()>longestPalindrome.length()){
                longestPalindrome.setLength(0);
                longestPalindrome.append(elem);
            }
        return longestPalindrome.toString();
    }

    public static boolean hasSameSubstring(String string1, String string2, int index, int length){
        if (string1.charAt(index) != string2.charAt(index) ||
            index+length>string1.length() || index+length>string2.length()) return false;
        int i;
        for (i = index+1; i<string1.length() & i<string2.length() & i<=length; i++)
            if (string1.charAt(i) != string2.charAt(i))
                return false;
        if (i>=length)
            return true;
        else
            return false;
    }

    public static boolean isEqualAfterReplaceCharacters(String string1, char replaceInStr1, char replaceByInStr1, String string2, char replaceInStr2, char replaceByInStr2){
        return isEqual(string1.replace(replaceInStr1,replaceByInStr1),string2.replace(replaceInStr2,replaceByInStr2));
    }

    public static boolean isEqualAfterReplaceStrings(String string1, String replaceInStr1, String replaceByInStr1, String string2, String replaceInStr2, String replaceByInStr2){
        return isEqual(string1.replaceAll(replaceInStr1,replaceByInStr1),string2.replaceAll(replaceInStr2,replaceByInStr2));
    }

    public static boolean isPalindromeAfterRemovingSpacesIgnoreCase(String string){
        return isPalindromeIgnoreCase(string.replace(" ",""));
    }

    public static boolean isEqualAfterTrimming(String string1, String string2){
        return isEqual(string1.trim(),string2.trim());
    }

    public static String makeCsvStringFromInts(int[] array){
        return makeCsvStringBuilderFromInts(array).toString();
    }

    public static String makeCsvStringFromDoubles(double[] array){
        return makeCsvStringBuilderFromDoubles(array).toString();
    }

    public static StringBuilder makeCsvStringBuilderFromInts(int[] array){
        StringBuilder csvString = new StringBuilder();
        if (array.length == 0) return csvString;
        for (int i = 0; i<array.length-1; i++) {
            csvString.append(array[i]).append(",");
        }
        return csvString.append(array[array.length-1]);
    }

    public static StringBuilder makeCsvStringBuilderFromDoubles(double[] array){
        StringBuilder csvString = new StringBuilder();
        if (array.length == 0) return csvString;
        for (int i = 0; i<array.length-1; i++) {
            csvString.append(String.format("%.2f",array[i])).append(",");
        }
        return csvString.append(String.format("%.2f",array[array.length-1]));
    }


    public static StringBuilder removeCharacters(String string, int[] positions){
        StringBuilder newString = new StringBuilder(string);
        int i;
        for (i=0; i<positions.length; i++) {
            newString.delete(positions[i]-i,positions[i]+1-i);
        }
        return newString;
    }

    public static StringBuilder insertCharacters(String string, int[] positions, char[] characters){
        StringBuilder newString = new StringBuilder(string);
        int i;
        for (i=0; i<positions.length; i++) {
            newString.insert(positions[i]+i,characters[i]);
        }
        return newString;
    }

}
