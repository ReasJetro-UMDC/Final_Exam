import java.util.Scanner;

public class STACK_EXAM {
    private class InventoryManagementStack {
        String data;
        int qnty;
        InventoryManagementStack next;
    }

    private InventoryManagementStack  top;
    private int size;

    private InventoryManagementStack  createNewNode(String productName, int quantity)throws Exception {
        InventoryManagementStack  node = new InventoryManagementStack ();
        if (node==null) {
            throw new Exception("Inventory is empty");
        } else {
                node.data = productName;
                node.qnty = quantity;
            node.next = null;
            return node;
        }
    }

    public void addProduct(String productName, int quantity)throws Exception {
        InventoryManagementStack  node = createNewNode(productName, quantity);
        if (size == 0) {
            top = node;
        } else {
            node.next = top;
            top = node;
        }
                size++;
    }

        public String sellProduct(int quantity)throws Exception {
        if (quantity == 0) {
            throw new Exception("Inventory is empty");
        }
        String temp = peek();
        top = top.next;
                size--;
                
        return temp;
    }
         public String sellProductName()throws Exception {
        if (size == 0) {
            throw new Exception("Inventory is empty");
        }
        String temp = peek();
        top = top.next;
                size--;
                
        return temp;
    }

         public void displayInventory()throws Exception {
        if (size == 0) {
            throw new Exception("Inventory is empty");
        }
        InventoryManagementStack  temp = top;
        while (temp!=null) {
            System.out.println("Product Name: " +temp.data + "    Quantity: " + temp.qnty );
            temp = temp.next;
        }
        
     }

    public String peek()throws Exception {
        if (size==0) {
            throw new Exception("Inventory is empty");
             }
        return top.data;
        }

        public static void main(String[] args) {
        STACK_EXAM stack = new STACK_EXAM(); 

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("=======troysss Management Store System=======");
            System.out.println("1. insert a product and quntity");
            System.out.println("2. sell product");
            System.out.println("3. Display inventoty");
            System.out.println("4. Quit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); 

            try {
     switch (choice) {
        case 1:
             System.out.print("type name of the product: ");
             String element = scanner.nextLine();
             System.out.println("quantity of the product");
             int qnty = scanner.nextInt();
             stack.addProduct(element,qnty);
             break;
             
             case 2:
                  System.out.print("type name of the product: ");
             String element1 = scanner.nextLine();
             System.out.println("sell quantity of the product");
             int qnty1 = scanner.nextInt();
             stack.sellProduct(qnty1 );
             
             break;
             
             case 3:
             stack.displayInventory();
             break;
                    
             case 4:
             System.out.println("Exiting the program.");
             scanner.close();
             System.exit(0);
             break;
             
                default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
         }
         }
 }
