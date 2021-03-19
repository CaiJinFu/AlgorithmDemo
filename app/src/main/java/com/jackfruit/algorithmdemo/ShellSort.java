package com.jackfruit.algorithmdemo;

import android.util.Log;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ShellSort {

  private int[] array = {12, 20, 30, 3, 6, 22, 55, 100};

  /**
   * 希尔排序 将序列分成一个矩阵，分为m列，逐列进行排序；
   * m从某个整数逐渐减为1
   * 当m为1时，整个序列将完全有序；
   * 步长序列  希尔本人给出的步长序列  n/2的k次方；  n代表数组的长度；  n=16；假设k=1的时候，步长序列为8；当k=2的时候 步长序列为4 然后2  然后1；
   */
  public void paixu() {
    List< Integer > sequence = shellSequence();
    for (Integer step : sequence) {
      shellByStep(step);
    }
    Log.i("TAG", "希尔排序: " + Arrays.toString(array));
  }

  private List< Integer > shellSequence() {
    List< Integer > sequence = new ArrayList<>();
    int step = array.length;
    while ((step = step >> 1) > 0) {
      sequence.add(step);
    }
    return sequence;
  }
  //{12,1,6,3,
  // 5,2,7,16}

  //{12,1,6,3,5,
  // 2, 7,16 }

  private void shellByStep(int step) {
    int cur = 0;
    int j = 0;
    // 第一次 step =4
    for (int i = step; i < array.length; i++) {
      // int[] array = {12,1,6,3,5,2,7,16};
      cur = array[i]; // 这里的cur = 5；
      for (j = i - step; j >= 0; j -= step) {
        int a = array[j];
        if (cur < a) {
          //  如果拿出来对比的数据 比已经存在的某个数据小
          array[j + step] = array[j];
        } else {
          //直接跳出循环
          break;
        }
      }
      array[j + step] = cur;
    }
  }

  private List< Integer > mySequence() {
    List< Integer > sequence = new ArrayList<>();
    sequence.add(9);
    sequence.add(5);
    sequence.add(3);
    sequence.add(1);
    return sequence;
  }

}
