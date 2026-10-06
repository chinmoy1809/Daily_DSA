class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for(String str : strs){
            int freq[] = new int[26];
            for(char ch : str.toCharArray()){
                freq[ch - 'a']++;
            }
            String freqString = Arrays.toString(freq);
            map.putIfAbsent(freqString,new ArrayList<>());
            map.get(freqString).add(str);
        }
        return new ArrayList<>(map.values());
    }
}