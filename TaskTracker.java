import java.io.*;
import java.util.*;
import java.time.LocalDate;
import com.google.gson.Gson;

class Task {
    private int id;
    private String description;
    private String status;
    private String createdAt;
    private String updatedAt;

    public Task(){

    }

    public Task(int id, String description, String status, String createdAt, String updatedAt){
        this.id = id;
        this.description = description;
        this.status = status;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public void setId(int id){
        this.id = id;
    }

    public int getId(){
        return id;
    }

    public void setDescription(String description){
        this.description = description;
    }

    public String getDescription(){
        return description;
    }

    public void setStatus(String status){
        this.status = status;
    }

    public String getStatus(){
        return status;
    }

    public void setCreatedAt(String createdAt){
        this.createdAt = createdAt;
    }

    public String getCreatedAt(){
        return createdAt;
    }

    public void setUpdatedAt(String updatedAt){
        this.updatedAt = updatedAt;
    }

    public String getUpdatedAt(){
        return updatedAt;
    }
}


public class TaskTracker {

    private static ArrayList<Task> ListTasks = new ArrayList<>();
    private static ArrayList<String> nameTasks = new ArrayList<>();
    private static int nextId = 1;
    private static String today = LocalDate.now().toString();
    private static List<String> statuses = Arrays.asList("to-do","in-progress","done");
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
                case 2 -> deleteAllTask(scanner);
                case 3 -> renameTask(scanner);
                case 4 -> deleteTask(scanner);
                case 5 -> setStatus(scanner);
                case 6 -> {
                    return;
                }
            }

        }
    }

    public static void addTask(Scanner scanner){
        System.out.println("Mo ta todo cua ban");
        String description = scanner.nextLine();
        nameTasks.add(description);

        Task task = new Task();

        task.setDescription(description);
        task.setId(nextId++);
        task.setCreatedAt(today);
        task.setStatus(statuses.get(0));
        ListTasks.add(task);

        writetofile();
    }

    public static void writetofile(){
        try {
            FileWriter filewriter = new FileWriter("Data.json");
            filewriter.write(gson.toJson(ListTasks));
            filewriter.close();    

        } catch (IOException e) {
            System.out.println("Co loi");
        }
    }

    public static void deleteTask(Scanner scanner){
        System.out.println("Ban muon thay doi to-do nao");
        int TaskId = 1;
        for(String x : nameTasks){
            System.out.println(TaskId + ". " + x);
        }
        int choiceTask = Integer.parseInt(scanner.nextLine());
        System.out.println("Da xoa task thanh cong");
        ListTasks.remove(choiceTask-1);
        writetofile();
    }

    public static void renameTask(Scanner scanner){
        System.out.println("Ban muon thay doi to-do nao");
        int TaskId = 1;
        for(String x : nameTasks){
            System.out.println(TaskId + ". " + x);
        }
        int choiceTask = Integer.parseInt(scanner.nextLine());
        System.out.println("Hay thay doi ten to-do");
        String rename = scanner.nextLine();
        ListTasks.get(choiceTask-1).setDescription(rename);
        writetofile();
    }

    public static void deleteAllTask(Scanner scanner){
        System.out.println("Da xoa het task cua ban");
        ListTasks.clear();
        nextId = 1;
        writetofile();
    }

    public static void setStatus(Scanner scanner){
        System.out.println("Ban muon thay doi to-do nao");
        int nameTaskId = 1;
        for(String x : nameTasks){
            System.out.println(nameTaskId + ". " + x);
        }
        int choiceTask = Integer.parseInt(scanner.nextLine());
        System.out.println("Lua chon cua ban");
        System.out.println("1. to-do");
        System.out.println("2. in-progress");
        System.out.println("3. done");
        int choiceStatus = Integer.parseInt(scanner.nextLine());
        switch (choiceStatus) {
            case 1: {
                ListTasks.get(choiceTask-1).setStatus(statuses.get(0));
            };
            case 2: {
                ListTasks.get(choiceTask-1).setStatus(statuses.get(1));
            };
            case 3: {
                ListTasks.get(choiceTask-1).setStatus(statuses.get(2));
            };
        }
        writetofile();
    }

}