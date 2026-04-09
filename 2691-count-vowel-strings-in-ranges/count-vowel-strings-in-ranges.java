class Solution {
    public int[] vowelStrings(String[] words, int[][] queries) {
        int n = words.length;
        int[] prefix = new int[n];

        // first word
        if(isValid(words[0])) prefix[0] = 1;
        else prefix[0] = 0;

        // build prefix
        for(int i = 1; i < n; i++){
            prefix[i] = prefix[i-1];
            if(isValid(words[i])){
                prefix[i]++;
            }
        }

        // answer queriesassb
        int[] ans = new int[queries.length];

        for(int i = 0; i < queries.length; i++){
            int l = queries[i][0];
            int r = queries[i][1];

            if(l == 0){
                ans[i] = prefix[r];
            } else {
                ans[i] = prefix[r] - prefix[l-1];
            }
        }

        return ans;
    }

    private boolean isValid(String word){
        char first = word.charAt(0);
        char last = word.charAt(word.length()-1);

        return isVowel(first) && isVowel(last);
    }

    private boolean isVowel(char c){
        return c=='a' || c=='e' || c=='i' || c=='o' || c=='u';
    }
}