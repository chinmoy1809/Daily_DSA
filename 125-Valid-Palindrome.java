class Solution {
    public boolean isTrue(String s){
        for(int i=0;i<s.length()/2;i++){
            if(s.charAt(i) != s.charAt(s.length()-i-1)) return false;
        }
        return true;
    }
    public boolean isPalindrome(String s) {
        StringBuilder str = new StringBuilder();
        for(char ch : s.toCharArray()){
            if((ch >= 'a' && ch <= 'z') ||(ch >= 'A' && ch <= 'Z') || (ch >= '0' && ch <= '9')){
                str.append(ch);
            }
        }
        String input = str.toString().toLowerCase();
        return isTrue(input);
    }
}