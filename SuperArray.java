public class SuperArray{
    private String[] data;
    private int size;

    public SuperArray(){
        data = new String[10];
        size = 0;
    }

    public int size(){
        return size;
    }

    public boolean add(String element){
        if(size==data.length)resize();
        data[size]=element;
        size++;
        return true;
    }

    public String get(int index){
        if(index<0||index>=size){
            throw new IndexOutOfBoundsException("Index"+index+" out of bounds");
        }
        return data[index];
    }

    public String set(int index, String element){
        if(index<0||index>=size){
            throw new IndexOutOfBoundsException("Index "+index+" out of bounds");
        }
        String val = data[index];
        data[index] = element;
        return val;
    }

    private void resize(){
        String[] newarr = new String[data.length*2];
        for(int i=0;i<data.length;i++){
            newarr[i] = data[i];
        }
        data = newarr;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public void clear(){
        data = new String[10];
        size = 0;
    }

    public String toString(){
        if(size==0)return "[]";
        String result = "[";
        for(int i=0;i<size-1;i++){
            result += data[i];
            result += ", ";
        }
        result += data[size-1] + "]";
        return result;
    }

    public boolean contains(String s){
        boolean result = false;
        for(int i=0;i<size;i++){
            if(data[i].equals(s)){
                result = true;
            }
        }
        return result;
    }

    public SuperArray(int initialCapacity){
        if(initialCapacity<0){
            throw new IllegalArgumentException("Initial capacity" + initialCapacity + " cannot be negative");
        }
        data = new String[initialCapacity];
        size = 0;
    }

    public void add(int index, String element){
        if(index<0||index>size){
            throw new IndexOutOfBoundsException("Index"+index+" out of bounds");
        }
        if(size==data.length)resize();
        for(int i=size-1;i>=index;i--){
            data[i+1]=data[i];
        }
        size++;
        data[index] = element;
    }

    public String remove(int index){
        if(index<0 || index>=size){
            throw new IndexOutOfBoundsException("Index "+index+" out of bounds");
        }
        String value = data[index];
        String[] newData = new String[data.length];
		for(int i=0; i<index; i++){
			newData[i] = data[i];
		}
		for(int i=index+1; i<size; i++){
			newData[i-1]=data[i];
		}
		data = newData;
		--size;
        return value;
    }

    public int indexOf(String s){
        for(int i=0;i<size;i++){
            if(data[i].equals(s))return i;
        }
        return -1;
    }

    public String[] toArray(){
        String[] result = new String[size];
        for(int i=0;i<size;i++){
            result[i] = data[i];
        }
        return result;
    }

    public int lastIndexOf(String value){
        for(int i=size-1;i>=0;i--){
            if(data[i].equals(value)){
                return i;
            }
        }
        return -1;
    }

    public boolean equals(SuperArray other){
        boolean result = true;
        if(size!=other.size){
            return false;
        }
        for(int i=0;i<size;i++){
            if(!data[i].equals(other.data[i])){
                result = false;
            }
        }
        return result;
    }
}
