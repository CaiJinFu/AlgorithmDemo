package com.jackfruit.algorithmdemo;

import android.util.Log;

import java.util.Arrays;

/**
 * @author 猿小蔡
 * @name AlgorithmDemo
 * @class name：com.jackfruit.algorithmdemo
 * @class describe
 * @createTime 2021/3/18 14:31
 * @change
 * @changTime
 */

public class MaoPao {

  public void maoPao1() {
    //两个数比较大小，较大的数下沉，较小的数冒出来
    int[] arrays = new int[]{1, 3, 56, 32, 33, 5, 6, 87, 10, 100};
    //最外层循环代表要进行几轮的对比
    for (int i = arrays.length - 1; i > 0; i--) {
      //内循环代表一轮需要进行多少次的对比
      for (int j = 0; j < i; j++) {
        if (arrays[j] > arrays[j + 1]) {
          int temp = arrays[j];
          arrays[j] = arrays[j + 1];
          arrays[j + 1] = temp;
        }
      }
    }
    Log.i("TAG", "冒泡: " + Arrays.toString(arrays));
  }

  public void maoPao2() {
    int[] arrays = new int[]{1, 3, 5, 7, 10, 18, 100};
    //假设给出的数组就是有个有顺序的数组，那么就需要做个判断，提前结束排序。
    for (int i = arrays.length - 1; i > 0; i--) {
      //添加一个临时变量，如果为false，那么就代表是排过序了，如果是true，那么就代表没有进行过排序，这已经是一个有序的数组了。
      boolean sorted = true;
      for (int j = 0; j < i; j++) {
        if (arrays[j] > arrays[j + 1]) {
          int temp = arrays[j];
          arrays[j] = arrays[j + 1];
          arrays[j + 1] = temp;
          sorted = false;
        }
      }
      if (sorted) {
        break;
      }
    }
    Log.i("TAG", "冒泡: " + Arrays.toString(arrays));
  }

  public void maoPao3() {
    int[] arrays = new int[]{1, 3, 56, 32, 33, 6, 5, 60, 61, 62, 63, 64};
    //假设给出的数组后半部分都是排好序的，那么后面的数字是不需要排序的。
    //此时可以记录下来最后一次交换的位置，那么最外层循环的时候，就从最后一次交换的位置开始，避免了多余的循环排序
    for (int i = arrays.length - 1; i > 0; i--) {
      //最后一次交换的索引
      int changeIndex = 0;
      for (int j = 0; j < i; j++) {
        if (arrays[j] > arrays[j + 1]) {
          int temp = arrays[j];
          arrays[j] = arrays[j + 1];
          arrays[j + 1] = temp;
          changeIndex = j + 1;
        }
      }
      i = changeIndex;
    }
    Log.i("TAG", "冒泡: " + Arrays.toString(arrays));
  }
}
