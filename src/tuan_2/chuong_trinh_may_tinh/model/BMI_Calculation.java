package tuan_2.chuong_trinh_may_tinh.model;

public class BMI_Calculation {
    private BMIStatus status;
    private double height;
    private double weight;
    // constructor
    public BMI_Calculation(double height, double weight) {
        this.height = height;
        this.weight = weight;
    }
    //constructor mac dinh
    public BMI_Calculation() {

    }
    // getter, setter
    public double getHeight() {
        return height;
    }
    public void setHeight(double height) {
        this.height = height;
    }
    public double getWeight() {
        return weight;
    }
    public void setWeight(double weight) {
        this.weight = weight;
    }
    public BMIStatus getStatus() {
        return status;
    }
    public void setStatus(BMIStatus status) {
        this.status = status;
    }
    // tinh BMI
    // tinh BMI
    public double calculateBMI() {
        double bmi = weight*10000 / (height * height);// tinh theo cm
        // xac dinh trang thai
        if (bmi < 19) {
            status = BMIStatus.UNDER_STANDARD;
        } else if (bmi <= 25) {
            status = BMIStatus.STANDARD;
        } else if (bmi <= 30) {
            status = BMIStatus.OVERWEIGHT;
        } else if (bmi <= 40) {
            status = BMIStatus.FAT;
        } else {
            status = BMIStatus.VERY_FAT;
        }
        return bmi;
    }
}
