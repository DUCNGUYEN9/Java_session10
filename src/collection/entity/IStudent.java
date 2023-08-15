package collection.entity;
import java.util.List;
import java.util.Scanner;
public interface IStudent {
    float MARK_PASS = 5;

    void inputData(Scanner scanner, List<Student> studentList);

    void displayData();
    void calAvgMark();
}
