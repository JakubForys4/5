import java.util.Collection;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
public class Service {

  public void addStudent(Student student) throws IOException {
    var f = new FileWriter("db.txt", true);
    var b = new BufferedWriter(f);
    b.append(student.ToString());
    b.newLine();
    b.close();
  }

  public Collection<Student> getStudents() throws IOException {
    var ret = new ArrayList<Student>();
    var f = new FileReader("db.txt");
    var reader = new BufferedReader(f);
    String line = "";
    while (true) {
      line = reader.readLine();
      if(line == null)
        break;
      ret.add(Student.Parse(line));
    }
    reader.close();
    return ret;
  }

  public Student findStudentByName(String name) throws IOException {
    var students = getStudents();
    for (Student student : students) {
      if (student.GetName().equals(name)) {
        System.out.println("Znaleziono studenta:");
        System.out.println("Imię: " + student.GetName());
        System.out.println("Nazwisko: " + student.GetLastName());
        System.out.println("Wiek: " + student.GetAge());
        System.out.println("Data urodzenia: " + student.GetBirthDate());
        return student;
      }
    }
    System.out.println("Nie znaleziono studenta o imieniu: " + name);
    return null;
  }
}