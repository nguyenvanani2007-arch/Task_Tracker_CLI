
import java.util.Scanner;


class Task {
    private int id;
    private String description;
    private String status;
    private String createdAt;
    private String updatedAt;

    public void getId(int id){
        this.id = id;
    }

    public void getDescription(String description){
        this.description = description;
    }

    public void getStatus(String status){
        this.status = status;
    }

    public void getCreatedAt(String createdAt){
        this.createdAt = createdAt;
    }

    public void getUpdatedAt(String updatedAt){
        this.updatedAt = updatedAt;
    }


}

public class TaskTracker {
    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);

        while(true){
            System.out.println("1. Them task");
            System.out.println("2. Xoa tat ca cac task");
            System.out.println("3. Sua task");
            System.out.println("4. Xoa task");
            System.out.println("5. Set status cho task");
            System.out.println("6. Ket thuc");
            System.out.println("Lua chon cua ban");

            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1 -> addTask(scanner);
                case 6 -> {
                    return;
                }
            }

        }
    }

    public static void addTask(Scanner scanner){
        System.out.println("Mo ta todo cua ban");
        String description = scanner.nextLine();
    }

    public static void deleteTask(){

    }

    public static void renameTask(){

    }

    public static void deteleAllTask(){

    }

    public static void setStatus(){
        
    }

}