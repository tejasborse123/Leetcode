// Solution 1 : Using Hashing via array.

class Solution 
{
    public boolean isMatch(int arr1[], int arr2[])
    {
        for(int i=0; i<26; i++) if(arr1[i] != arr2[i]) return false;
        return true;
    }
    public boolean checkInclusion(String s1, String s2) 
    {
        int n = s1.length();
        int m = s2.length();

        int map1[] = new int[26];

        for(int i=0; i<n; i++) map1[s1.charAt(i) - 'a']++;

        for(int i=0; i<=m-n; i++) 
        {
            int map2[] = new int[26];
            for(int j=0 ;j<n; j++)
            {
                map2[s2.charAt(i+j) - 'a']++;
            }
            if(isMatch(map1,map2)) return true;
        }

        return false;      
    }
}



// Solution 2 : Using Sliding Window

class Solution 
{
    public boolean isMatch(int arr1[], int arr2[])
    {
        for(int i=0; i<26; i++) if(arr1[i] != arr2[i]) return false;
        return true;
    }
    public boolean checkInclusion(String s1, String s2) 
    {
        int n = s1.length();
        int m = s2.length();

        if(n > m) return false;

        int map1[] = new int[26];
        int map2[] = new int[26];

        for(int i=0; i<n; i++) 
        {
            map1[s1.charAt(i) - 'a']++;
            map2[s2.charAt(i) - 'a']++;
        }

        if(isMatch(map1,map2)) return true;

        for(int i=n; i<m; i++) 
        {
            map2[s2.charAt(i-n) - 'a']--;
            map2[s2.charAt(i) - 'a']++;
            if(isMatch(map1,map2)) return true;
        }

        return false;      
    }
}