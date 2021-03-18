package com.jackfruit.algorithmdemo;

import android.util.Log;

import java.util.Arrays;

/**
 * @author 猿小蔡
 * @name AlgorithmDemo
 * @class name：com.jackfruit.algorithmdemo
 * @class describe
 * @createTime 2021/3/18 15:32
 * @change
 * @changTime
 */

public class SelectionOrder {

  public void selection() {
    // 核心原理：不断的从数组中找出最大值 然后放入末尾；
    int[] arrays = new int[]{1, 2, 56, 32, 33, 5, 6, 87, 88, 100};
    for (int i = arrays.length - 1; i > 0; i--) {
      int maxIndex = 0;
      for (int j = 0; j < i; j++) {
        if (arrays[maxIndex] < arrays[j + 1]) {
          maxIndex = j + 1;
        }
      }
      int temp = arrays[maxIndex];
      arrays[maxIndex] = arrays[i];
      arrays[i] = temp;
    }
    Log.i("TAG", "选择: " + Arrays.toString(arrays));
  }

}
