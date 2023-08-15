package collection.run;

import collection.entity.Student;

import java.util.*;
import java.util.Collections;
import java.util.Comparator;

public class StudentManager {
    static List<Student> studentList = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("******************MENU*****************");
            System.out.println("1. Nhập thông tin các sinh viên");
            System.out.println("2. Tính điểm trung bình các sinh viên");
            System.out.println("3. Đánh giá xếp loại sinh viên");
            System.out.println("4. Tính trạng thái sinh viên");
            System.out.println("5. In thông tin các sinh viên");
            System.out.println("6. Sắp xếp sinh viên tăng dần theo điểm trung bình");
            System.out.println("7. Tìm kiếm sinh viên theo tên sinh viên");
            System.out.println("8. Thống kê sinh viên theo xếp loại");
            System.out.println("9. Thống kê sinh viên theo trạng thái");
            System.out.println("10. Thoát");
            System.out.print("Sự lựa chọn của bạn: ");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    StudentManager.inputListStudent(scanner);
                    break;
                case 2:
                    StudentManager.calAvgMark();
                    break;
                case 3:
                    StudentManager.calRank();
                    break;
                case 4:
                    StudentManager.calStudentStatus();
                    break;
                case 5:
                    StudentManager.displayListStudent();
                    break;
                case 6:
                    StudentManager.sortStudentByAvgMarkASC();
                    break;
                case 7:
                    StudentManager.searchStudentByName(scanner);
                    break;
                case 8:
                    StudentManager.thongKeSinhVien();
                    break;
                case 9:
                    StudentManager.thongKeTrangThai();
                    break;
                case 10:
                    System.exit(0);
                default:
                    System.err.println("Vui lòng nhập từ 1-10");
            }
        } while (true);
    }

    public static void inputListStudent(Scanner scanner) {
        System.out.println("Nhập số sinh viên cần nhập thông tin: ");
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            Student student = new Student();
            student.inputData(scanner,studentList);
            studentList.add(student);
        }
    }
    public static void calAvgMark() {
        for(Student st:studentList){
            st.calAvgMark();
        }
        System.out.println("Đã tính xong điểm trung bình cho tất cả sinh viên");
    }

    public static void calRank() {
        for (int i = 0; i < studentList.size(); i++) {
            studentList.get(i).calRank();
        }
        System.out.println("Đã xếp loại xong cho tất cả các sinh viên");
    }

    public static void calStudentStatus() {
        for (int i = 0; i < studentList.size(); i++) {
            studentList.get(i).calStudentStatus();
        }
        System.out.println("Đã tính xong trạng thái tất cả sinh viên");
    }

    public static void displayListStudent() {
        for (int i = 0; i < studentList.size(); i++) {
            studentList.get(i).displayData();
        }
    }

    public static void sortStudentByAvgMarkASC() {
        for (int i = 0; i < studentList.size()-1; i++) {
            for (int j = i+1; j < studentList.size(); j++) {
                if (studentList.get(i).getAvgMark()>studentList.get(j).getAvgMark()){
                    Student temp=studentList.get(i);
                    studentList.set(i,studentList.get(j));
                    studentList.set(j,temp);
                }
            }
        }
        System.out.println("Đã sắp xếp xong sinh viên theo điểm trung bình tăng dần");
    }
    public static void searchStudentByName(Scanner scanner) {
        System.out.println("Nhập vào tên sinh viên cần tìm:");
        String searchName = scanner.nextLine();
        System.out.println("Các sinh viên tìm thấy: ");
        boolean searchResult = false;
        for (int i = 0; i < studentList.size(); i++) {
            if (studentList.get(i).getStudentName().toLowerCase().contains(searchName.toLowerCase())) {
                searchResult = true;
                studentList.get(i).displayData();
            }
        }
        if (!searchResult) {
            System.out.println("Không tìm thấy sinh viên nào");
        }
    }

    public static void thongKeSinhVien() {
        int cntYeu = 0, cntTB = 0, cntKha = 0, cntGioi = 0, cntXuatSac = 0;
        for (int i = 0; i < studentList.size(); i++) {
            switch (studentList.get(i).getRank()) {
                case "Yếu":
                    cntYeu++;
                    break;
                case "Trung bình":
                    cntTB++;
                    break;
                case "Khá":
                    cntKha++;
                    break;
                case "Giỏi":
                    cntGioi++;
                    break;
                default:
                    cntXuatSac++;
            }
        }
        System.out.printf("Xuất sắc: %d - Giỏi: %d - Khá: %d - Trung bình: %d - Yếu: %d\n", cntXuatSac, cntGioi, cntKha, cntTB, cntYeu);
    }
    public static void thongKeTrangThai() {
        int cntFail = 0, cntPass = 0;
        for (int i = 0; i < studentList.size(); i++) {
            if (studentList.get(i).getStudentStatus().equals("PASS")) {
                cntPass++;
            } else {
                cntFail++;
            }
        }
        System.out.printf("PASS: %d - FAIL: %d\n", cntPass, cntFail);
    }
}
