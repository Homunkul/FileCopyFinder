import java.io.File;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


import static java.lang.System.out;


public class Main {
	private static final List<CFile> cf = new ArrayList<>();
	//  private static final List<String> st = new ArrayList<>();
//  static String temp = "";
	//  static String type = "";
	static CFile fold;
//  static int kol;

	private static void CreateList(String filePatch) throws IOException, NoSuchAlgorithmException {
		File folder = new File(filePatch);
		for (File fileEntry : Objects.requireNonNull(folder.listFiles())) {
			if (fileEntry.isFile()) {
//        temp = fileEntry.getName();
//        fold = new CFile(fileEntry.toString());
				fold = new CFile(fileEntry.getAbsolutePath());
//        fold.setName(fileEntry.getAbsolutePath());
//        fold.CFile(fileEntry.toString());
				cf.add(fold);
//        st.add(fileEntry.getName());
				out.println(cf.get(cf.size() - 1).getName());
			} else {
				CreateList(filePatch + "/" + fileEntry.getName());
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

//  private static void sortData(List<CFile> list, int left, int right) {
//    int leftPoint = left, rightPoint = right;
//    String poin = list.get((leftPoint + rightPoint) / 2).getMDSum();
//
//    do {
//      while (list.get(leftPoint).getMDSum().compareTo(poin) > 0) {
//        leftPoint++;
//      }
//      while (list.get(rightPoint).getMDSum().compareTo(poin) < 0) {
//        rightPoint++;
//      }
//      if (leftPoint <= rightPoint) {
//        if (leftPoint < rightPoint) {
//          CFile temp = list.get(leftPoint);
//          list.set(leftPoint, list.get(rightPoint));
//          list.set(rightPoint, temp);
//        }
//        leftPoint++;
//        rightPoint--;
//      }
//    } while (leftPoint <= rightPoint);
//  }

	public static void main(String[] args) throws IOException, NoSuchAlgorithmException {
		//private static
//		List<CFile> cf = new ArrayList<>();
//		long a1,a2;
		String filePatch = "/home/apr/tmp/sippackages";
//		a1= System.currentTimeMillis();
//		out.println(a1);
		CreateList(filePatch);
//		a2=System.currentTimeMillis();
//		out.println(a2);
//		out.println((a2-a1)/cf.size() + ":" + (a1-a2) + ":" + cf.size());
//		sortData(cf,0,cf.size()-1);
		for (CFile cFile : cf) {
			out.println(cFile.getName());
//			out.println(st.get(i));
		}
//		out.println(cf.get(10).getName());
//		out.println((a2 - a1) / kol + ":" + (a2 - a1) + ":" + kol);
	}
}