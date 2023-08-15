package collection.entity;

import java.util.List;
import java.util.Scanner;

public class Student implements IStudent{
    private String studentId;
    private String studentName;
    private int age;
    private float html;
    private float css;
    private float javascript;
    private float avgMark;
    private boolean sex;
    private String rank;
    private String studentStatus;

    public Student() {
    }

    public Student(String studentId, String studentName, int age, float html, float css, float javascript, float avgMark, boolean sex, String rank, String studentStatus) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.age = age;
        this.html = html;
        this.css = css;
        this.javascript = javascript;
        this.avgMark = avgMark;
        this.sex = sex;
        this.rank = rank;
        this.studentStatus = studentStatus;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public float getHtml() {
        return html;
    }

    public void setHtml(float html) {
        this.html = html;
    }

    public float getCss() {
        return css;
    }

    public void setCss(float css) {
        this.css = css;
    }

    public float getJavascript() {
        return javascript;
    }

    public void setJavascript(float javascript) {
        this.javascript = javascript;
    }

    public float getAvgMark() {
        return avgMark;
    }

    public void setAvgMark(float avgMark) {
        this.avgMark = avgMark;
    }

    public boolean isSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public String getStudentStatus() {
        return studentStatus;
    }

    public void setStudentStatus(String studentStatus) {
        this.studentStatus = studentStatus;
    }


    @Override
    public void inputData(Scanner scanner, List<Student> studentList) {
        System.out.println("Nhập vào mã sinh viên: ");
        boolean checkStudentId = true;
        do {
            this.studentId = scanner.nextLine();
            boolean checkExistStudentId = false;
            for (int i = 0; i < studentList.size(); i++) {
                if (studentList.get(i).studentId.equals(this.studentId)) {
                    checkExistStudentId = true;
                    break;
                }
            }
            if (checkExistStudentId) {
                System.err.println("Mã sinh viên đã tồn tại, vui lòng nhập lại");
            } else {
                if (this.studentId.length() == 4) {
                    if (this.studentId.startsWith("SV")) {
                        break;
                    } else {
                        System.err.println("Mã sinh viên phải bắt đầu là SV, vui lòng nhập lại");
                    }
                } else {
                    System.err.println("Mã sinh viên phải gồm 4 ký tự, vui lòng nhập lại");
                }
            }
        } while (checkStudentId);
        boolean checkStudentName = true;
        System.out.println("Nhập vào tên sinh viên: ");
        do {
            this.studentName = scanner.nextLine();
            if (this.studentName.length() >= 6 && this.studentName.length() <= 50) {
                break;
            } else {
                System.err.println("Tên sinh viên có từ 6-50 ký tự, vui lòng nhập lại");
            }
        } while (checkStudentName);
        boolean checkAge = true;
        System.out.println("Nhập vào tuổi sinh viên: ");
        do {
            this.age = Integer.parseInt(scanner.nextLine());
            if (this.age >= 18) {
                break;
            } else {
                System.err.println("Tuổi sinh viên phải lớn hơn hoặc bằng 18, vui lòng nhập lại");
            }
        } while (checkAge);
        boolean checkHTML = true;
        System.out.println("Nhập vào điểm html:");
        do {
            this.html = Float.parseFloat(scanner.nextLine());
            if (this.html >= 0 && this.html <= 10) {
                break;
            } else {
                System.err.println("Điểm html có giá trị 0-10, vui lòng nhập lại");
            }

        } while (checkHTML);
        boolean checkCSS = true;
        System.out.println("Nhập vào điểm css:");
        do {
            this.css = Float.parseFloat(scanner.nextLine());
            if (this.css >= 0 && this.css <= 10) {
                break;
            } else {
                System.err.println("Điểm css có giá trị 0-10, vui lòng nhập lại");
            }

        } while (checkCSS);
        boolean checkJavascript = true;
        System.out.println("Nhập vào điểm javascript:");
        do {
            this.javascript = Float.parseFloat(scanner.nextLine());
            if (this.javascript >= 0 && this.javascript <= 10) {
                break;
            } else {
                System.err.println("Điểm javascript có giá trị 0-10, vui lòng nhập lại");
            }

        } while (checkJavascript);
        System.out.println("Nhập vào giới tính của sinh viên: ");
        this.sex = Boolean.parseBoolean(scanner.nextLine());
    }
    public void calRank() {
        if (this.avgMark < 5) {
            this.rank = "Yếu";
        } else if (this.avgMark < 7) {
            this.rank = "Trung bình";
        } else if (this.avgMark < 8) {
            this.rank = "Khá";
        } else if (this.avgMark < 9) {
            this.rank = "Giỏi";
        } else {
            this.rank = "Xuất sắc";
        }
    }
    public void calStudentStatus() {
        if (this.avgMark < MARK_PASS) {
            this.studentStatus = "FAIL";
        } else {
            this.studentStatus = "PASS";
        }
    }
    @Override
    public void displayData() {
        System.out.printf("Mã SV: %s - Tên SV: %s - Tuổi: %d\n", this.studentId, this.studentName, this.age);
        System.out.printf("HTML: %.1f - CSS: %.1f - Javascript: %.1f - AvgMark: %.1f\n", this.html, this.css, this.javascript, this.avgMark);
        String studentSex = (this.sex) ? "Nam" : "Nữ";
        System.out.printf("Giới tính: %s - Xếp loại: %s - Trạng thái: %s\n", studentSex, this.rank, this.studentStatus);
    }

    @Override
    public void calAvgMark() {
        this.avgMark = (this.html + this.css + this.javascript) / 3;
    }

}
