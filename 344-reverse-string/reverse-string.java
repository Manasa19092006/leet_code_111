class Solution {
    public void reverseString(char[] s) {
    int j=s.length;
    for(int i=0;i<j/2;i++){
        char temp = s[i];
        s[i]=s[j-1-i];
        s[j-1-i]=temp;
        }
    }
}