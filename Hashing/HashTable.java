package ChatGPT_Problems.Hashing;

public class HashTable {
    public static void main(String[] args) {

        MyHashTable hashtable = new MyHashTable();

        hashtable.insert(43);
        hashtable.insert(32);
        hashtable.insert(27);
        hashtable.insert(18);
        hashtable.insert(10);
        hashtable.insert(112);
        hashtable.insert(154);

        hashtable.display();
        hashtable.delete(32);

        hashtable.search(43);
        hashtable.search(27);

        hashtable.display();
    }
    static class MyHashTable{
        private int size = 10;
        private Integer[]table = new Integer[size];

        // hash Function
        public int hash(int key){
            return key % size;
        }

        // insert
        public void insert(int key){
            int index = hash(key);

            if(table[index] == null ){
                table[index] = key;
                System.out.println(key + " is inserted in " + index);
            }else{
                System.out.println("Collision occurred! Cannot insert " + key);
            }
        }

        // Search
        public void search(int key){
            int index = hash(key);
            if(table[index] != null && table[index] == key){
                System.out.println(key + " is found at " + index);
            }else{
                System.out.println("Key is not found ");
            }
        }

        // Delete
        public void delete(int key){
            int index = hash(key);
            if(table[index] != null && table[index] == key){
                table[index] = null;
                System.out.println(key + " is deleted ");
            }else{
                System.out.println("Key not found");
            }
        }

        // Display
        public void display(){
            System.out.println("\nHash Table");

            for(int i= 0; i< size ; i++){
                System.out.println(i + " -> " + table[i]);
            }
        }
    }
}
