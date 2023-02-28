package OOPS;

public class DynamicArray {
    private int data[]; //here we created a reference
    private int nextIndex;

    public DynamicArray(){
        data =new int[5]; //here we are assigning the array toh the reference
        nextIndex = 0;
    }

    public int size(){
        return nextIndex;
    }

    public void add(int element){
        if (nextIndex == data.length ) {
            restructure();//array bhar gaya hai uski length badha do
        }
        data[nextIndex] = element;
        nextIndex++;
    }

    public void setData(int index, int element){
        if (index > nextIndex) { // because array mai kuch hoga nahi beech mai so we didnot allow
            return;
        }
        if (index < nextIndex) {// in this case we are replacing the existing element with it
            data[index] = element;
        }else{// if it is equal to the nextIndex
            add(element);
        }
    }

    public int getData(int index) {
        if (index >= nextIndex) {// because array mai kuch hai hi nahi
            //TODO error out
            return -1;
        }
        return data[index];
    }

    public boolean isEmpty(){
        if (size() == 0) {
            return true;
        }else{
            return false;
        }
    }

    public int removeLast(){
        if (size() == 0) {
            return -1;
        }
        int value = data[nextIndex-1];// here we are storing the last value for returning in the value
        data[nextIndex-1] = 0;// then we are 0 the last value
        nextIndex--;//and then moving backwards
        return value;
    }

    public void restructure(){
        int temp[] = data; //here we are creating a temp reference and referring to the data array
        data = new int[2* data.length];// we are creating new array with new size then data is referring to it 
        for (int i = 0; i < temp.length ; i++) {
            data[i] = temp[i];//we are copying the temp int to the newly created data
        }


    }

}
