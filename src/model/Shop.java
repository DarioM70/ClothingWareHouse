package model;

import java.util.ArrayList;

public class Shop {
    private String name;
    public final short MAX_PRODUCTS = 150;
    public final short MAX_ROWS = 10;
    public final short MAX_COLUMNS = 8;
    private Product[][] shelf;
    private Product[] catalog;

    public Shop(String name) {
        this.name = name;
        catalog = new Product[MAX_PRODUCTS];
        shelf = new Product[MAX_ROWS][MAX_COLUMNS];
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public Product searchProduct(String product){
        Product objetoEncontrado = null;
        boolean valid = false;
        for (int i = 0; i<MAX_PRODUCTS && !valid; i++){
            if(catalog[i] !=null && catalog[i].getId().equals(product)){
                objetoEncontrado = catalog[i];
                valid = true;
            }
        }
        return objetoEncontrado;
    }
    public int searchPosition(){
        boolean found = false;
        int index = -1;
        int i=0;
        while (i<catalog.length && !found){
            if(catalog[i] == null){
                index = i;
                found = true;
            }
            i++;
        }
        return index;
    }
    public String addProductToCatalog(String id, String material, int width, int price ){
        String message = "Producto almacenado exitosamente en la tienda";
        Product objProduct = searchProduct(id);
        if (objProduct != null){
            message = "Error, el producto id ya existe";
        }
        else{
            int poss = searchPosition();
            if(poss == -1){
                message = "No, lamentablemente no se encuentra espacio";
            }
            else{
                catalog[poss] = new Tie(id,material,width,price);
            }
        }
        return message;
    }
    public String addProductToCatalog(String id, char size, String[] materials, String color){
        String message = "Producto almacenado exitosamente en la tienda";
        Product objProduct = searchProduct(id);
        if (objProduct != null){
            message = "Error, el producto id ya existe";
        }
        else{
            int poss = searchPosition();
            if(poss == -1){
                message = "No, lamentablemente no se encuentra espacio";
            }
            else{
                catalog[poss] = new Blouse(id,color, size, materials);
            }
        }
        return message;
    }

    public String addProductToCatalog(String id, boolean gender, int length ){
        String message = "Producto almacenado exitosamente en la tienda";
        Product objProduct = searchProduct(id);
        if (objProduct != null){
            message = "Error, el producto id ya existe";
        }
        else{
            int poss = searchPosition();
            if(poss == -1){
                message = "No, lamentablemente no se encuentra espacio";
            }
            else{
                catalog[poss] = new Jeans(id,gender,length);
            }
        }
        return message;
    }

    public void addProductToShelf(Product objP){
        boolean found = false;
        for (int i = 0; i < MAX_ROWS && !found; i++) {
            for (int j = 0; j < MAX_COLUMNS && !found; j++) {
                if(shelf[i][j] == null){
                    shelf[i][j] = objP;
                    found = true;
                }
            }
        }
    }

    public String showCatalog(){
        StringBuilder message = new StringBuilder("| Catalog Information | \n");
        boolean thereAreProducts = false;
        for (int i = 0; i < MAX_PRODUCTS; i++) {
            if(catalog[i] != null){
                message.append(catalog[i]).append("\n");
                thereAreProducts = true;
            }
        }
        if (!thereAreProducts ){
            message = new StringBuilder("There are any products in catalog");
        }
        return message.toString();
    }

    public String showShelf () {
        String message="";
        for (int i = 0; i < MAX_ROWS; i++) {
            for (int j = 0; j < MAX_COLUMNS; j++) {
                if(shelf[i][j]==null){
                    message = "     ";
                } else if (shelf[i][j] instanceof Tie) {
                    message += "TIES ";
                }else if (shelf[i][j] instanceof Blouse) {
                    message += "BLOU";
                }else if (shelf[i][j] instanceof Jeans) {
                    message += "JEAN ";
                }else if (shelf[i][j] instanceof Tie) {
                    message += "Ties ";
                }
            }
        }
        return message;
    }
    public double averagePrice(){
        double average = 0;
        double suma = 0;
        int count = 0;
        for (int i = 0; i<MAX_PRODUCTS;i++){
            if (catalog[i] != null ){
                suma += catalog[i].getPrice();
                count++;
            }
        }
        if(count !=0){
            average = suma / count;
        }
        return average;
    }

    public int blouseOfSameSize(char size){
        int countBlouses = 0;
        for (int i = 0; i < MAX_PRODUCTS; i++) {
            if (catalog[i] != null && catalog[i] instanceof Blouse){
                if (((Blouse) catalog[i]).getSize() == size){
                    countBlouses++;
                }
            }
        }
        return countBlouses;
    }
    public String generateTestCases() {
        String message = "Test cases generated successfully";

        for (int i = 0; i < 8; i++) {
            // Randomly choose a product type (1 for Jean, 2 for Blouse, 3 for Tie)
            int productType = (int) (Math.random() * 3) + 1;
            switch (productType) {
                case 1 -> {
                    // Test case for Jean
                    String id = "JeanID" + i;
                    // Randomly choose gender type (1 for Male, 2 for Female)
                    int genderType = (int) (Math.random() * 2) + 1;
                    boolean gender;
                    switch (genderType){
                        case 1 -> gender = true;
                        case 2 -> gender = false;
                        default -> gender = true;
                    }
                    // Randomly choose length
                    short length = (short) (Math.random() * 30 + 10); // Assuming length between 10 and 40
                    addProductToCatalog(id, gender, length);
                }
                case 2 -> {
                    // Test case for Blouse
                    String idB = "BlouseID" + i;

                    // Randomly choose size
                    char size = (char) ('S' + Math.random() * 3); // Assuming sizes are S, M, L

                    // Randomly choose the number of materials (between 1 and 5)
                    int numMaterials = (int) (Math.random() * 5) + 1;
                    // Randomly generate materials
                    String[] materials = new String[numMaterials];
                    for (int j = 0; j < numMaterials; j++) {
                        materials[j] = "Material" + j;
                    }
                    // Randomly choose color
                    String color = "Color" + i;
                    addProductToCatalog(idB, size, materials, color);
                }
                case 3 -> {
                    // Test case for Tie
                    String idT = "TieID" + i;

                    // Randomly choose material
                    String material = "Material" + i;

                    // Randomly choose width and price
                    int width = (int) (Math.random() * 50 + 10); // Assuming width between 10 and 60
                    int price = (int) (Math.random() * 100 + 50); // Assuming price between 50 and 150
                    addProductToCatalog(idT,material, width, price);
                }
            }


        }

        return message;
    }

}
