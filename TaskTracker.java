import java.io.*;
import java.util.*;
import com.google.gson.Gson;

         

class Task {
    private int id;
    private String description;
    private String status;
    private String createdAt;
    private String updatedAt;

    public void setId(int id){
        this.id = id;
    }

    public void setDescription(String description){
        this.description = description;
    }

    public void setStatus(String status){
        this.status = status;
    }

    public void setCreatedAt(String createdAt){
        this.createdAt = createdAt;
    }

    public void setUpdatedAt(String updatedAt){
        this.updatedAt = updatedAt;
    }
}


public class TaskTracker {

    private static ArrayList<String> ListTasks = new ArrayList<>();
    static Gson gson = new Gson();  
    

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
        Task task = new Task();
        task.setDescription(description);
        String json = gson.toJson(task);
        ListTasks.add(json);
        System.out.println(ListTasks);

        writetofile(json);


    }

    public static void writetofile(String s){
        try {
            FileWriter filewriter = new FileWriter("Example.json");
            filewriter.write(s);
            filewriter.close();    

        } catch (IOException e) {
            System.out.println("Co loi");
        }
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