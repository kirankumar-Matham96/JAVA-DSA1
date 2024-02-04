package Tries;

public class TrieUse {
    public static void main(String[] args) {
        TriesClass t = new TriesClass();
        t.add("NOTE");
        t.add("AND");
        t.add("NOT");
        t.add("ANDERSON");
        t.add("MEN");
        t.add("MENIN");
        t.add("MENINBLACK");
        System.out.println(t.search("NOTE"));
        System.out.println(t.search("AND"));
        System.out.println(t.search("NOT"));
        t.remove("NOT");
        t.remove("ANDERSON");
        System.out.println("search for Not: "+t.search("NOT"));
        System.out.println("Search for Note: " + t.search("NOTE"));
        System.out.println("Search for AND: " + t.search("AND"));
        System.out.println("Search for ANDERSON: " + t.search("ANDERSON"));
        System.out.println("Words cont: "+t.wordsInTrie());
    }
}
