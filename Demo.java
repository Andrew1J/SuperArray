public class Demo{
    public static void main(String[]args){
      SuperArray words = new SuperArray();
      //grouped to save vertical space
      words.add("kani");   words.add("uni");     words.add("ebi");     words.add("una");
      words.add("una");    words.add("ebi");     words.add("kani");    words.add("una");
      words.add("una");    words.add("ebi");     words.add("toro");

      System.out.println(words);
      removeDuplicates(words);
      System.out.println(words);

      //findOverlap test
      SuperArray a = new SuperArray();
      SuperArray b = new SuperArray();
      a.add("9"); a.add("1"); a.add("2"); a.add("2"); a.add("2"); a.add("3"); a.add("4");
      b.add("0"); b.add("4"); b.add("2"); b.add("2"); b.add("9");
      System.out.println(findOverlap(a,b));
      a.clear(); b.clear();
      b.add("9"); b.add("1"); b.add("2"); b.add("2"); b.add("2"); b.add("3"); b.add("4");
      a.add("0"); a.add("4"); a.add("2"); a.add("2"); a.add("9");
      System.out.println(findOverlap(a,b));
    }

    public static void removeDuplicates(SuperArray s){
        for(int i=0;i<s.size();i++){
            if(i!=s.indexOf(s.get(i))){
                s.remove(i);
                i--;
            }
        }
    }

    public static SuperArray findOverlap(SuperArray a, SuperArray b){
        SuperArray c = new SuperArray();
        for(int i=0;i<a.size();i++){
            if(b.contains(a.get(i))){
                c.add(a.get(i));
            }
        }
        removeDuplicates(c);
        return c;
    }


}
