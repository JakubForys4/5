
import java.io.IOException;//
import java.util.Scanner;

class Main {
  public static void main(String[] args) {
    try { 
      Service s = new Service();
      Scanner scanner = new Scanner(System.in);
      

      System.out.println("1. Dodaj studenta");
      System.out.println("2. Wyświetl studentów");
      System.out.println("3. Znajdź studenta po imieniu");
      System.out.println("4. Usuń studenta");
      System.out.print("Wybierz opcję: ");

      int choice = scanner.nextInt();
      scanner.nextLine();

      if (choice == 1) {
        System.out.print("Podaj imię: ");
        String name = scanner.nextLine().trim();
        System.out.print("Podaj nazwisko: ");
        String lastName = scanner.nextLine();
        System.out.print("Podaj wiek: ");
        int age = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Podaj datę urodzenia (YYYY-MM-DD): ");
        String birthDate = scanner.nextLine();

        s.addStudent(new Student(name, lastName, age, birthDate));
        System.out.println("Dodano studenta!");
      } else if (choice == 2) {
        var students = s.getStudents();
        System.out.println("Lista studentów:");
        for (Student current : students) {
          System.out.println(current.toString());
        }
      } else if (choice == 3) {
        System.out.print("Podaj imię studenta: ");
        String searchName = scanner.nextLine().trim();
        s.findStudentByName(searchName);
      }
      else if(choice ==4){
        System.out.print("Podaj imię studenta do usunięcia: ");
                  String nameToDelete = scanner.nextLine().trim();
                  System.out.print("Podaj nazwisko studenta do usunięcia: ");
                  String lastNameToDelete = scanner.nextLine().trim();
                  boolean removed = s.removeStudent(nameToDelete, lastNameToDelete);

                  if (removed) {
                    System.out.println("Student został usunięty.");
                  } else {
                    System.out.println("Nie znaleziono studenta o podanym imieniu i nazwisku.");
                  }
                } else if (choice == 5) {
                  System.out.println("Zakończono działanie programu.");
                  break;
                } else {
                  System.out.println("Niepoprawny wybór, spróbuj ponownie.");
                }
              }

              scanner.close();
            } catch (IOException e) {
              System.out.println("Wystąpił błąd: " + e.getMessage());
            }
          }
        }
      }

      scanner.close();
    } catch (IOException e) {
      System.out.println("Wystąpił błąd: " + e.getMessage());
    }
  }
}
