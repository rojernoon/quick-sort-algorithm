import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.List;
import java.io.FileNotFoundException;
import java.io.IOException;


public class app{

	// 配列要素の入れ替え用
	static void swap(List<Integer> list, int index_a, int index_b){
		int tmp = list.get(index_a);
		list.set(index_a, list.get(index_b));
		list.set(index_b, tmp);
	}

	// クイックソート
	static void quicksort(List<Integer> list, int left, int right){
		// 確認用
		//System.out.println(list);
		System.out.println(left);
		System.out.println(right);
		
		// 左グループの基準
		int pivot_left = left;
		// 右グループの基準
		int pivot_right = right;
		// 中央の要素
		int pivot_center = (pivot_left + pivot_right) / 2;
		int center_element = list.get(pivot_center);

		// 確認用
		System.out.println("pivot position : " + pivot_center);
		System.out.println("pivot element : " + center_element);
		System.out.println("before execution : " + list);

		do {
			while (list.get(pivot_left) < center_element){
				pivot_left ++;
			}
			while (list.get(pivot_right) > center_element){
				pivot_right --;
			}
			if (pivot_left <= pivot_right){
				swap(list, pivot_left++, pivot_right--);
			}
		} while (pivot_left <= pivot_right);

		System.out.println("after execution : " + list);

		if (left < pivot_right){
			quicksort(list, left, pivot_right);
		}
		if (right > pivot_left){
			quicksort(list, pivot_left, right);
		}
	}

	public static void main(String[] args){
		try{
			String file_name = "./data.txt";
			BufferedReader br = new BufferedReader(new FileReader(file_name));
			String str;
			List<Integer> list = new ArrayList<Integer>();
			// 一行ずつデータを読み込む
			while((str = br.readLine()) != null){
				// String→Integer変換
				int data = Integer.parseInt(str);
				list.add(data);
			}
			br.close();

			// 読み込んだデータの表示
			System.out.println("elements:" + list);
			System.out.println("number of elements:" + list.size());
			// 確認用
			// System.out.println(list.getClass());
			// System.out.println(list.get(0).getClass());

			// クイックソート実行
			System.out.println("Start Quick-Sort");
			quicksort(list, 0, list.size()-1);

			//結果の表示
			System.out.println("Result : " + list);

		}catch(FileNotFoundException e){
			System.out.println(e);
		}catch(IOException e){
			System.out.println(e);
		}
	}

}