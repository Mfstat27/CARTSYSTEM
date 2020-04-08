package cartSystemExample.mainTest;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import cartSystemExample.AppSystem;
import cartSystemExample.CartSystem;
import cartSystemExample.Item;
import cartSystemExample.TheSystem;

public class MainTest {
	static HashMap<String, Item> map = new HashMap<String, Item>();
	public static void main(String[] args) throws IOException {
//		MainTest mt = new MainTest();
//		String[] holder = mt.test2(); //
//		System.out.println(Arrays.toString(holder));
//		System.out.println(map.toString());
//		CartSystem cs = new CartSystem();
//		cs.display();
//		HashMap<String,Item> cart = cs.getItemCollection();
		AppSystem as = new AppSystem();
		as.display();
		as.add(new Item("cheeseburger","beefy",10.99,15));
		as.display();
		Item item = new Item("cheeseburger", "beefy", 10.99, 15);
		System.out.println(as.checkAvailability(item));
		System.out.println(as.remove("cheeseburger"));
		as.display();
	
	

	}
	public void test() throws IOException {
		Path path = Paths.get("/Users/traceythomas/Desktop/eclipse-workspace/Cart_Assignment_Tracey_Thomas/src/sample.txt");
		try {
			List<String> lines = Files.readAllLines(path, StandardCharsets.UTF_8);
			System.out.println(lines.toString());
			for(int i = 0; i < lines.size(); i++) {
				if(!map.containsKey(lines.get(i))) {
					map.put(lines.get(i), new Item());
				}
			}
		}catch(IOException e) {
			e.printStackTrace();
		}

		//		BufferedReader reader = new BufferedReader(new FileReader(filepath));
		//		StringBuffer sb = new StringBuffer(reader.readLine());
		//		





		//		if(getClass().getSimpleName().equals("AppSystem")) {
		//			
		//		}
	}

	public String[] test2() {
		String content = "";
		String[] itemInfo = null;
		try {
			content = new String(Files.readAllBytes(Paths.get
					("/Users/traceythomas/Desktop/eclipse-workspace/Cart_Assignment_Template/src/sample.txt")));
			itemInfo = content.split("[ \t\\n\\x0B\\f\\r][ \r\n]"); 
			for(int i=0;i<itemInfo.length;i+=4) {
					map.put("MenuItem " + i, new Item(itemInfo[i], itemInfo[i + 1], Double.parseDouble(itemInfo[i +2]), Integer.parseInt(itemInfo[i+3])));
				}
			}catch(IOException e) {
			e.printStackTrace();
		}
		return itemInfo;
	}
}

