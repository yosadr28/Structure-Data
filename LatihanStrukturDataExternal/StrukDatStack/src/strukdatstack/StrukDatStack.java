/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package strukdatstack;
import java.util.Stack;
import javafx.scene.input.KeyCode;
/**
 *
 * @author asus
 */
public class StrukDatStack {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Stack<String> commands = new Stack<>();
        commands.push("Import Stack");
        commands.push("Membuat kelas Undo");
        commands.push("Membuat main");
        commands.push("Inisiasi Stack");
        
        System.out.println("command Terakhir : " + commands.peek());
        
     try{   
        for(int i = 0; i<2; i++){
            System.out.println("Undo command : " + commands.pop());
        }
        commands.push("Inisiasi ArrayList");
        while(!commands.isEmpty()){
            System.out.println("Undo command : " + commands.pop());
        }  
        
     } catch (Exception StackException){
         System.out.println("This is the Last you Undo");
     }
    }
    
}
