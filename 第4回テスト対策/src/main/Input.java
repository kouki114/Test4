package main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Input {
	List<String[]> text = new ArrayList<>();
	public Input() {
		// TODO 自動生成されたメソッド・スタブ
		File file = new File("test4File_2.csv");
		BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));
		try {
			br1 = new BufferedReader(new FileReader(file));
		} catch (FileNotFoundException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		String line;
		String[] data = null;;
		List<String[]> lines = new ArrayList<>();
			try {
				while ((line = br1.readLine()) != null) {
					
				    text.add(csvSplit(line));
				    
				    }
			} catch (IOException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}
//		for(String[] a : text) {
//			for(String str : a) {
//				System.out.print(str);
//			}
//			System.out.println();
//		}
	}
	private static String[] csvSplit(String line) {

        char c;
        StringBuilder s = new StringBuilder();
        List<String> data = new ArrayList<String>();
        boolean singleQuoteFlg = false;

        for(int i=0; i < line.length(); i++){
            c = line.charAt(i);
            if (c == ',' && !singleQuoteFlg) {
                data.add(s.toString());
                s.delete(0,s.length());
            } else if (c == ',' && singleQuoteFlg) {
                s.append(c);
            } else if (c == '\'') {
                singleQuoteFlg = !singleQuoteFlg;
//                s.append(c);
            } else {
                s.append(c);
            }
        }
        String[] str = new String[data.size()];
        for(int i = 0 ; i < data.size() ; i++) {
        	str[i] = data.get(i);
        }
        return str;
    }

}
