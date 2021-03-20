package com.jackfruit.algorithmdemo;

import android.util.Log;

import java.util.Arrays;

public class CharuPaixu {

  // 插入排序：从数组中获取数字，并跟以后的数据进行对比，选择自己插入的位置；
  int[] arrays = {11, 3, 1, 2, 6, 9, 33, 22, 55, 66};

  //插入排序
  public void insertSort() {
    int insertVal = 0;
    int insertIndex = 0;
    //使用for循环来把代码简化
    for (int i = 1; i < arrays.length; i++) {
      //定义待插入的数
      insertVal = arrays[i];
      insertIndex = i - 1; // 即arr[1]的前面这个数的下标

      // 给insertVal 找到插入的位置
      // 说明
      // 1. insertIndex >= 0 保证在给insertVal 找插入位置，不越界
      // 2. insertVal < arr[insertIndex] 待插入的数，还没有找到插入位置
      // 3. 就需要将 arr[insertIndex] 后移
      while (insertIndex >= 0 && insertVal < arrays[insertIndex]) {
        arrays[insertIndex + 1] = arrays[insertIndex];// arr[insertIndex]
        insertIndex--;
      }
      // 当退出while循环时，说明插入的位置找到, insertIndex + 1
      // 举例：理解不了，我们一会 debug
      //这里我们判断是否需要赋值
      if (insertIndex + 1 != i) {
        arrays[insertIndex + 1] = insertVal;
      }
      //System.out.println("第"+i+"轮插入");
      //System.out.println(Arrays.toString(arr));
    }
    Log.i("TAG", "插入: " + Arrays.toString(arrays));
		/*

		//使用逐步推导的方式来讲解，便利理解
		//第1轮 {101, 34, 119, 1};  => {34, 101, 119, 1}

		//{101, 34, 119, 1}; => {101,101,119,1}
		//定义待插入的数
		int insertVal = arr[1];
		int insertIndex = 1 - 1; //即arr[1]的前面这个数的下标

		//给insertVal 找到插入的位置
		//说明
		//1. insertIndex >= 0 保证在给insertVal 找插入位置，不越界
		//2. insertVal < arr[insertIndex] 待插入的数，还没有找到插入位置
		//3. 就需要将 arr[insertIndex] 后移
		while(insertIndex >= 0 && insertVal < arr[insertIndex] ) {
			arr[insertIndex + 1] = arr[insertIndex];// arr[insertIndex]
			insertIndex--;
		}
		//当退出while循环时，说明插入的位置找到, insertIndex + 1
		//举例：理解不了，我们一会 debug
		arr[insertIndex + 1] = insertVal;

		System.out.println("第1轮插入");
		System.out.println(Arrays.toString(arr));

		//第2轮
		insertVal = arr[2];
		insertIndex = 2 - 1;

		while(insertIndex >= 0 && insertVal < arr[insertIndex] ) {
			arr[insertIndex + 1] = arr[insertIndex];// arr[insertIndex]
			insertIndex--;
		}

		arr[insertIndex + 1] = insertVal;
		System.out.println("第2轮插入");
		System.out.println(Arrays.toString(arr));


		//第3轮
		insertVal = arr[3];
		insertIndex = 3 - 1;
		while (insertIndex >= 0 && insertVal < arr[insertIndex]) {
			arr[insertIndex + 1] = arr[insertIndex];// arr[insertIndex]
			insertIndex--;
		}
		arr[insertIndex + 1] = insertVal;
		System.out.println("第3轮插入");
		System.out.println(Arrays.toString(arr)); */

  }

  public void paixu() {
    //int[] arrays = {11, 3, 1, 2, 6, 9, 33, 22, 55, 66};
    int cur;
    for (int i = 0; i < arrays.length - 1; i++) {
      cur = arrays[i + 1];
      int preIndex = i;
      while (preIndex >= 0 && cur < arrays[preIndex]) {
        arrays[preIndex + 1] = arrays[preIndex];
        preIndex--;
      }
      arrays[preIndex + 1] = cur;
    }
    Log.i("TAG", "插入: " + Arrays.toString(arrays));
  }

}
