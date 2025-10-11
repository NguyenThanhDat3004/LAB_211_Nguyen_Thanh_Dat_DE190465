package tuan_5.quanLiKhoaHoc.dao;

import tuan_5.quanLiKhoaHoc.model.OfflineCourse;

import java.util.List;

public class OfflineCourseDAO implements DAOInterface<tuan_5.quanLiKhoaHoc.model.OfflineCourse>{
    // goi ham nay ma khong can tao doi tuong cua lop nay, thay vi dung constructor
    // tuc la neu khai bao:
    //OfflineCourseDAO dao1 = OfflineCourseDAO.getInstance();
    //OfflineCourseDAO dao2 = OfflineCourseDAO.getInstance();
    // dao1 và dao2 cùng trỏ tới 1 đối tượng duy nhất
    // con neu tao bang constructor thi 2 cai nay se tro toi 2 vung nho khac nhau ,tuc 2 doi tuong khac nhau
    public static OfflineCourseDAO getInstance(){
        return new OfflineCourseDAO();
    }



    @Override
    public int add(OfflineCourse offlineCourse) {
        return 0;
    }

    @Override
    public int update(OfflineCourse offlineCourse) {
        return 0;
    }

    @Override
    public int delete(OfflineCourse offlineCourse) {
        return 0;
    }

    @Override
    public List<OfflineCourse> selectAll() {
        return List.of();
    }

    @Override
    public OfflineCourse selectById(OfflineCourse offlineCourse) {
        return null;
    }

    @Override
    public List<OfflineCourse> selectByCondition(String condition) {
        return List.of();
    }
}
