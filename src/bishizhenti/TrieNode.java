package bishizhenti;

import java.util.HashMap;

public class TrieNode {
    public Integer frequency; //词频
    public Boolean isWords;//是否是词
    public Character values;//值
    public HashMap<String,TrieNode> childNodes ;//孩子们
}
