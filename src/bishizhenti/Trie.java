package bishizhenti;

import java.util.*;

public class Trie {

    private static Integer[] level = { 1,0,0,0, 0,0,0,0 }; //trie树 词应该不会超过8的长度   树也最高也就五六层  词语

    private TrieNode trieRoot;
    public Trie(){
        trieRoot = new TrieNode();
        trieRoot.frequency = 0;
    }

    /**
     * 插入中文词组
     * @param data
     * @return
     */
    public Boolean insert(String data){
        ArrayList<String> arrays =  toStringArrays(data);
        TrieNode point = trieRoot;
        TrieNode nextChild = null;
        String nowArraysStr = "";
        for (int i = 0; i < arrays.size(); i++) {
            point.frequency++;
            nowArraysStr = arrays.get(i);
            nextChild = point.childNodes.get(nowArraysStr);
            if (nextChild == null){
                TrieNode addTire = new TrieNode(nowArraysStr.charAt(0));
                if (i == arrays.size()-1){
                    addTire.isWords = true;
                    addTire.frequency = 1;
                    point.childNodes.put(nowArraysStr,addTire);
                    level[i+1]++;
                    break;
                }
                point.childNodes.put(nowArraysStr,addTire);
                level[i+1]++;
                point = addTire;
            }else {
                point = nextChild;
            }
        }
        return true;
    }

    /**
     * 查询词组
     * @param data
     * @return
     */
    public Boolean searchWords(String data){
        ArrayList<String> arrays =  toStringArrays(data);
        TrieNode point = trieRoot;
        TrieNode nextChild = null;
        String s = "";
        for (int i = 0; i < arrays.size(); i++) {
            nextChild = point.childNodes.get(arrays.get(i));
            if (nextChild == null){
                return false;
            }else {
                point = nextChild;
                showPointInfo(point);
                s += point.values;
            }
        }
        System.out.println(s);
        return true;
    }


    /**
     * 查询前缀词频
     * @param data
     * @return
     */
    public boolean searchPreWord(String data){
        ArrayList<String> arrays =  toStringArrays(data);
        TrieNode point = trieRoot;
        TrieNode nextChild = null;
        String s = "";
        for (int i = 0; i < arrays.size(); i++) {
            nextChild = point.childNodes.get(arrays.get(i));
            if (nextChild == null){
                System.out.println("没有此前缀！");
                return false;
            }else {
                point = nextChild;

            }
        }
        showPointInfo(point);
        return true;
    }

    /**
     * 层序遍历trie树
     */
    public void showTrieTree(){
        TrieNode point = trieRoot;
        MyLinkedQueue<TrieNode> queue = new MyLinkedQueue<TrieNode>();
        queue.enQueue(point);
        Integer lev = 0;
        Integer count = 0;
        while (queue.getCount()>0){
            TrieNode trieNode = queue.deQueue();
            Collection<TrieNode> childs = trieNode.childNodes.values();
            Iterator<TrieNode> iterator = childs.iterator();
            while (iterator.hasNext()){
                queue.enQueue(iterator.next());
            }
            System.out.print(trieNode.values + "  ");
            count++;
            if (count == level[lev]){
                System.out.println();
                lev++;
                count = 0;
            }
        }
    }

    /**
     * 主函数
     * @param args
     */
    public static void main(String[] args) {
        String[] strings = {"天天向上","天人合一","天天学习","我是大神","快马加鞭"};
        Trie trie = new Trie();
        for (String s:
                strings) {
            trie.insert(s);
        }
        //  trie.searchWords("天天向上");
        // trie.searchPreWord("天天");
        trie.showTrieTree();

    }

    public class TrieNode {

        public TrieNode(){
            childNodes = new HashMap<String,TrieNode>(8);
            isWords = false;
            frequency = 0;
            values = '根';
        }
        public TrieNode(Character data) {
            childNodes = new HashMap<String,TrieNode>(8);
            isWords = false;
            frequency = 0;
            values = data;
        }

        public Integer frequency;
        public Boolean isWords;
        public Character values;
        public HashMap<String,TrieNode> childNodes ;

        @Override
        public String toString() {
            return "TrieNode{" +
                    "frequency=" + frequency +
                    ", isWords=" + isWords +
                    ", values=" + values +
                    ", childNodes=" + childNodes.toString() +
                    '}'+'\n';
        }
    }

    private void showPointInfo(TrieNode point){
        System.out.println("当前  结点值：" + point.values);
        System.out.println("当前结点词频：" + point.frequency);
        System.out.print("当前结点孩子：");
        Set<String> chs = point.childNodes.keySet();
        Iterator<String> iterator = chs.iterator();
        while (iterator.hasNext()){
            System.out.print(" " + iterator.next());
        }
        System.out.println();
    }

    private static ArrayList<String> toStringArrays(String data){
        ArrayList<String> result = new ArrayList<String>(data.length());
        for (int i = 0; i < data.length(); i++) {
            result.add("" + data.charAt(i));
        }
        return result;
    }

    @Override
    public String toString() {
        return "Trie{" +
                "trieRoot=" + trieRoot.toString() +
                '}';
    }
}
