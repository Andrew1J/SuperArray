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

      //zip test
      System.out.println(zip(a,b));
      a.clear(); b.clear();
      a.add("0"); a.add("4"); a.add("2"); a.add("6"); a.add("9");
      b.add("9"); b.add("1"); b.add("3"); b.add("2"); b.add("2");
      System.out.println(zip(a,b));
      System.out.println(zip(b,a));

      //error testing
      int errors = 0;
      try{
          SuperArray newSuperArray = new SuperArray(-5);
      } catch(IllegalArgumentException e){
          errors++;
      }
      try{
          words.get(1000);
      } catch(IndexOutOfBoundsException e){
          errors++;
      }
      try{
          words.set(words.size(),"okay");
      } catch(IndexOutOfBoundsException e){
          errors++;
      }
      try{
          words.add(1000,"okay");
      } catch(IndexOutOfBoundsException e){
          errors++;
      }
      try{
          words.remove(-1);
      } catch(IndexOutOfBoundsException e){
          errors++;
      }
      System.out.println(errors + " errors out of 5");
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

    public static SuperArray zip(SuperArray a, SuperArray b){
        SuperArray c = new SuperArray();
        int minsize = Math.min(a.size(),b.size());
        for(int i=0;i<minsize;i++){
            c.add(a.get(i));
            c.add(b.get(i));
        }
        if(a.size()>b.size()){
            for(int i=minsize;i<a.size();i++){
                c.add(a.get(i));
            }
        } else {
            for(int i=minsize;i<b.size();i++){
                c.add(b.get(i));
            }
        }
        return c;
    }
}
