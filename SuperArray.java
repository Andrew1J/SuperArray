public class SuperArray{
    private String[] data;
    private int size;

    public SuperArray(){
        String[] data = new String[10];
        size = 0;
    }

    public int size(){
        return size;
    }

    public boolean add(String element){
        data[size]=element;
        size++;
    }

    public String get(int index){
        return data[index];
    }

    public String set(int index, String element){
        String val = data[index];
        data[index] = element;
        return val;
    }

    private void resize(){
        String[] new = new String[data.length+1];
        for(int i=0;i<data.length;i++){
            new[i] = data[i];
        }
        data = new;
    }
}
