class TrieNode
{
    TrieNode[] alphabets = new TrieNode[26];
    boolean endofWord;
    TrieNode()
    {
        for(int i=0;i<26;i++)
        {
            this.alphabets[i]=null;
            
        }
    }
    void insert(String s)
    {
        TrieNode p =this;
        for(int i=0;i<s.length();i++)
        {
            int k=s.charAt(i)-'a';
            if(p.alphabets[k]==null)
            p.alphabets[k]=new TrieNode();
            p=p.alphabets[k];
        }
        p.endofWord=true;
        
    }
    boolean search(String s)
    {
        TrieNode p=this;
        for(int i=0;i<s.length();i++)
        {
            int k=s.charAt(i)-'a';
            if(p.alphabets[k]==null)
            return false;
            else
            p=p.alphabets[k];
        }
        return (p!=null && p.endofWord==true);
        
        
        
    }
}

public class Main
{
	public static void main(String[] args) {
		TrieNode root = new TrieNode();
		root.insert("hey");
		System.out.println(root.search("he"));
	}
}
