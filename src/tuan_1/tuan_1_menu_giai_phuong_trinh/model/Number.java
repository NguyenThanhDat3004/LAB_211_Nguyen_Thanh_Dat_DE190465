package tuan_1.tuan_1_menu_giai_phuong_trinh.model;

public class Number {
    private float value;
    public Number(){
    }
    public float getValue() {
        return value;
    }
    public void setValue(float value) {
        this.value = value;
    }
    // check co phai so thuc khong
    public Float checkIn(String floatString){
        try {
            return Float.valueOf(floatString);
        }catch(Exception e){
            return null;
        }   
    }
    //Kiem tra so le
    public boolean isOdd(){
        return this.value % 2 != 0;
    }
    //kiem tra so chinh phuong 
    public boolean isPerfectSquare(){
        if((Double)(Math.pow(Math.ceil(Math.sqrt(value)), 2))==(double)value)
            return true;
        else return false;
    }

    @Override
    public String toString() {
        return this.value+"";
    }
    
}
