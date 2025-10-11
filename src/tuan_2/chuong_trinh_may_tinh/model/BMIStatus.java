package tuan_2.chuong_trinh_may_tinh.model;
public enum BMIStatus {
    UNDER_STANDARD("Under-standard"),
    STANDARD("Standard"),
    OVERWEIGHT("Overweight"),
    FAT("Fat - should lose weight"),
    VERY_FAT("Very fat - should lose weight immediately");

    private String message;

    BMIStatus(String message) {
        this.message = message;
    }
    
    public String getMessage() {
        return message;
    }
}
