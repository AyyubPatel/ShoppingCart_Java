package shopping.cart;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class AddItem {

	AddItem(Item item){
		try{
			FileOutputStream fos = new FileOutputStream("IventoryList.txt");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(item);
			System.out.println("Item added to Inventory List.");
		}catch (Exception e){
			e.printStackTrace();
		}
	}
}




