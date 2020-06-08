package net.voovo.enums;

public enum Color implements IEnum{
    RED(1),BLUE(2);

    int val;
    Color(int val) {
        this.val = val;
    }

    public static void main(String[] args) {
        for(Color i:Color.values()){
            System.out.println(i);
        }
    }

    @Override
    public int getVal() {
        return val;
    }


}
