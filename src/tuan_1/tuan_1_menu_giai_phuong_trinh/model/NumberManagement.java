package tuan_1.tuan_1_menu_giai_phuong_trinh.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class NumberManagement {
    private ArrayList<Float> results = new ArrayList<>();
    // tao them 1 list luu dau vao
    private  List<Number> listThamSo = new ArrayList<>();
    // list gom cac tham so co dieu kien
    private  List<Number> listSoChan = new ArrayList<>();
    private  List<Number> listSoLe = new ArrayList<>();
    private  List<Number> listSoChinhPhuong = new ArrayList<>();
    // constructor
    public NumberManagement(){

    }
    // getter
    public ArrayList<Float> getResults() {
        return results;
    }
    // get tham so
    public List<Number> getThamSo() {
        return listThamSo;
    }

    public List<Number> getListSoChan() {
        return listSoChan;
    }

    public List<Number> getListSoChinhPhuong() {
        return listSoChinhPhuong;
    }

    public List<Number> getListSoLe() {
        return listSoLe;
    }
    // ham add
    public void addElement(Number e){
        listThamSo.add(e);
    }
    // ham clear thamSo
    public void clearList(){
        listThamSo.clear();
        listSoChan.clear();
        listSoLe.clear();
        listSoChinhPhuong.clear();
    }
    // Lay thong tin cac tham so
    public void thuThapThongTin(){
    listSoLe = listThamSo.stream().filter(n->n.isOdd()).collect(Collectors.toList());
    listSoChan = listThamSo.stream().filter(n->!n.isOdd()).collect(Collectors.toList());
    listSoChinhPhuong = listThamSo.stream().filter(n->n.isPerfectSquare()).collect(Collectors.toList());
}
    // Giai phuong trinh bac nhat
    public ArrayList<Float> calculateEquation(float a, float b){
        results.clear();
        if(a==0) return null;
        results.add((-b/a));
        return results;
    }
    // giai phuong trinh bac hai
    public ArrayList<Float> calculateEquation2(float a, float b, float c){
        results.clear();
        if(a==0) return null;
        float delta=b*b-4*a*c;
        if(delta<0) return null;
        else if(delta==0){
            results.add((-b/(2*a)));
            return results;
        }else{
            results.add((float)((-b+Math.sqrt(delta))/(2*a)));
            results.add((float)((-b-Math.sqrt(delta))/(2*a))); // sqrt tra ve double
            return results;
        }
    }
}
