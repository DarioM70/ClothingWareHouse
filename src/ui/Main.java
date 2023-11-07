package ui;
import java.util.Scanner;
import model.Shop;
public class Main{
    public static Scanner reader = new Scanner(System.in);
    public static Shop shopManager = new Shop("Shopy Center");
    public static void main(String[] args){

        while(true){
            menu();
        }
    }
    public static void menu(){
        System.out.println("Bienvenido a la tienda de ropa mas exclusiva del mundo:");
        System.out.println(" [1] Calculate product price \n [2] View catalog \n [3] add products to catalog \n [4] if you wish to count blouses of the same size \n [5] generate test cases \n [6] exit:");
        int answerUser = reader.nextInt();
        reader.nextLine();
        switch (answerUser) {
            case 1 -> calculatePrice();
            case 2 -> showCatalog();
            case 3 -> addProductCatalog();
            case 4 -> countBlouses();
            case 5 -> testCases();
            case 6 -> System.exit(0);
        }
    }
    public static void calculatePrice(){
        System.out.println("Este sistema se encuenta en mantenimiento por el momento, intentelo mas tarde");
    }

    public static void addProductCatalog(){
        String message = "nada";
        System.out.println("What kind of product do you will do add? \n [1] Jean \n [2] Blouse \n [3] Tie");
        short product;
        product = reader.nextShort();
        reader.nextLine();
        while(product <1 || product>3){
            System.out.println("Choose a valid input: \n [1] Jean \n [2] Blouse \n [3] Tie");
            product = reader.nextShort();
            reader.nextLine();
        }
        switch (product) {
            case 1 -> {
                System.out.println("Enter the jean id");
                String id = reader.nextLine();
                System.out.println("Enter the gender of the jean \n [1] Male \n [2] Female");
                short genderType = reader.nextShort();
                reader.nextLine();
                boolean gender;
                switch (genderType) {
                    case 1 -> gender = true;
                    case 2 -> gender = false;
                    default -> gender = true;
                }
                System.out.println("Enter the length of the jean");
                short length = reader.nextShort();
                reader.nextLine();
                message = shopManager.addProductToCatalog(id, gender, length);
            }
            case 2 -> {
                System.out.println("Ingrese el ID del producto:");
                String idB = reader.nextLine();
                System.out.println("Ingrese el tamaño del producto:");
                char size = reader.nextLine().charAt(0);
                System.out.println("Cuántos materiales tiene el producto?");
                int numMaterials = reader.nextInt();
                reader.nextLine();
                String[] materials = new String[numMaterials];
                for (int i = 0; i < numMaterials; i++) {
                    System.out.println("Ingrese el material " + (i + 1) + ":");
                    materials[i] = reader.next();
                }
                System.out.println("Ingrese el color del producto:");
                String color = reader.next();
                message = shopManager.addProductToCatalog(idB, size, materials, color);
            }
            case 3 -> {
                System.out.print("Enter product ID: ");
                String idT = reader.nextLine();
                System.out.print("Enter material: ");
                String material = reader.nextLine();
                System.out.print("Enter width: ");
                int width = reader.nextInt();
                System.out.print("Enter price: ");
                int price = reader.nextInt();
                message = shopManager.addProductToCatalog(idT, material, width, price);
            }
        }
        System.out.println(message);
    }

    public static void countBlouses(){
        System.out.println("Enter the size that you want to consult");
        char size = reader.nextLine().charAt(0);
        int number = shopManager.blouseOfSameSize(size);
        System.out.println("There are " + number + " of elements with the size " + size);
    }
    public static void addProductToShelf(){

    }

    public static void testCases(){
        String message = shopManager.generateTestCases();
        System.out.println(message);
    }
    public static void showCatalog(){
        String message = shopManager.showCatalog();
        System.out.println(message);
    }
}