// Solution 1 : Using PriorityQueue

class Solution 
{
    class Pair implements Comparable<Pair>
    {
        int freq;
        char ch;

        Pair(int freq, char ch)
        {
            this.freq = freq;
            this.ch = ch;
        }

        @Override
        public int compareTo(Pair that)
        {
            return that.freq - this.freq;
        }
    }
    public String longestDiverseString(int a, int b, int c) 
    {
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        StringBuilder ans = new StringBuilder();

        if(a > 0) pq.add(new Pair(a,'a'));
        if(b > 0) pq.add(new Pair(b,'b'));
        if(c > 0) pq.add(new Pair(c,'c'));

        while(!pq.isEmpty())
        {
            Pair curr = pq.poll();

            int n = ans.length();
            char ch = curr.ch;
            int freq = curr.freq;

            if(n>=2 && ans.charAt(n-1) == ch && ans.charAt(n-2) == ch)
            {
                if(pq.isEmpty()) break;
                Pair sec = pq.poll();
                ans.append(sec.ch);
                sec.freq--;

                if(sec.freq > 0) pq.add(new Pair(sec.freq, sec.ch));
            } 
            else
            {
                ans.append(curr.ch);
                curr.freq--;
            }

            if(curr.freq > 0) pq.add(new Pair(curr.freq, curr.ch));
        }

        return ans.toString();
    }
}

// Using 3 pointers 


class Solution 
{
    public String longestDiverseString(int a, int b, int c) 
    {
        StringBuilder sb = new StringBuilder();
        
        int totalLength = a + b + c;
        int continuousA = 0, continuousB = 0, continuousC = 0;
        
        for(int i = 0; i < totalLength; i++) 
        {
            if ((a >= b && a >= c && continuousA != 2) || (continuousB == 2 && a > 0) || (continuousC == 2 && a > 0))  
            {
                sb.append("a");
                a--;
                continuousA++;
                continuousB = 0;
                continuousC = 0;  
            } 
            else if ((b >= a && b >= c && continuousB != 2) || (continuousA == 2 && b > 0) || (continuousC == 2 && b > 0)) 
            {
                sb.append("b");
                b--;
                continuousB++;
                continuousA = 0;
                continuousC = 0;
            } 
            else if ((c >= a && c >= b && continuousC != 2) || (continuousB == 2 && c > 0) || (continuousA == 2 && c > 0)) 
            {
                sb.append("c");
                c--;
                continuousC++;
                continuousA = 0;
                continuousB = 0;  
            }
        }
        return sb.toString();
    }
}