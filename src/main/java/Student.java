
public class Student {
  private String Name;
  private String LastName;
  private int Age;
  private String BirthDate;

  public Student(String name, String lastName, int age, String birthDate) {
    Name = name;
    LastName = lastName;
    Age = age;
    BirthDate = birthDate;
  }

  public String GetName() {return Name;}
  public String GetLastName() {return LastName;}
  public int GetAge() {return Age;}
  public String GetBirthDate() {return BirthDate;}

  @Override
  public String toString() {
    return Name + " " + LastName + " " + Integer.toString(Age) + " " + BirthDate;
  }

  public static Student Parse(String str) {
    String[] data = str.split(" ");
    if(data.length != 4) 
      return new Student("Parse Error", "Error", -1, "");
    return new Student(data[0], data[1], Integer.parseInt(data[2]), data[3]);
  }
}
