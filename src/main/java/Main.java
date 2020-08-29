import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.*;
import java.io.File;

import static java.lang.System.*;


public class Main {
	private static List<CFile> cf = new ArrayList<>();
	private static List<String> st = new ArrayList<>();
	static String temp = "", type = "";
	static CFile fold;
	static int kol;

	private static void CreateList(String filePatch) throws IOException, NoSuchAlgorithmException {
		File folder = new File(filePatch);
		for (final File fileEntry : folder.listFiles()) {
			if (fileEntry.isFile()) {
				temp = fileEntry.getName();
				fold = new CFile();
				fold.CFile(fileEntry.toString());
				cf.add(fold);
				st.add(fileEntry.getName());
				out.println(cf.get(cf.size()-1).getName());
			}else {
				CreateList(filePatch + "\\" + fileEntry.getName());
			}
		}
	}

//	private static int GetKol(String filePatch) throws IOException, NoSuchAlgorithmException {
//		String tm;
//		int koll;
//		File folder = new File(filePatch);
//		for (final File fileEntry : folder.listFiles()) {
//			if (fileEntry.isFile()) {
//				tm = fileEntry.getName();
//				koll++;
////				out.print(filePatch + "\\" + fileEntry.getName() + " " + cf.size() + " " + fold.getMDSum());
//			}else {
//				CreateList(filePatch + "\\" + fileEntry.getName());
//			}
//		}
//		return koll;
//	}

	private static  void sortData(List<CFile> list, int left, int right){
		int leftPoint = left, rightPoint = right;
		String poin = list.get((leftPoint + rightPoint) / 2).getMDSum();

		do {
			while (list.get(leftPoint).getMDSum().compareTo(poin) > 0) {
				leftPoint ++;
			}
			while (list.get(rightPoint).getMDSum().compareTo(poin) < 0) {
				rightPoint ++;
			}
			if (leftPoint <= rightPoint) {
				if (leftPoint < rightPoint) {
					CFile temp = list.get(leftPoint);
					list.set(leftPoint, list.get(rightPoint));
					list.set(rightPoint, temp);
				}
				leftPoint ++;
				rightPoint --;
			}
		}while (leftPoint <= rightPoint);
	}

	public static void main(String[] args) throws IOException, NoSuchAlgorithmException {
		//private static
//		List<CFile> cf = new ArrayList<>();
		long a1,a2;
		String filePatch = "D:\\ProgramData";
		a1= System.currentTimeMillis();
		out.println(a1);
		CreateList(filePatch);
		a2=System.currentTimeMillis();
		out.println(a2);
		out.println((a2-a1)/cf.size() + ":" + (a1-a2) + ":" + cf.size());
//		sortData(cf,0,cf.size()-1);
		for (int i = 0; i < cf.size(); i++){
			out.println(cf.get(cf.size()-1).getName());
		}
		out.println(cf.get(10).getName());
		out.println((a2 - a1) / kol + ":" + (a2 - a1) + ":" + kol);
	}
}