# AlgorithmDemo

[TOC]

# 排序算法

## 冒泡排序

**冒泡排序：两个数比较大小，较大的数下沉，较小的数冒出来**

```java
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
```

**假设给出的数组就是有个有顺序的数组，那么就需要做个判断，提前结束排序。**

```java
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
```

**假设给出的数组后半部分都是排好序的，那么后面的数字是不需要排序的。此时可以记录下来最后一次交换的位置，那么最外层循环的时候，就从最后一次交换的位置开始，避免了多余的循环排序。**

```java
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
```

## 选择排序

**选择排序：从所有数据中选择数值最大的数，记住下标，和第一个位置的数据进行交换，这样第一个位置排好了顺序；然后在从剩下的数据中选择数值最大的数，记住下标，和剩下的数据中的第一个位置交换，这样剩下的数据中第一个位置也排好了顺序…依次这样循环执行到所有数据都排好了顺序。**

```java
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
```

## 插入排序

**插入排序：插入算法把要排序的数组分成两部分：第一部分包含了这个数组的所有元素，但将最后一个元素除外（让数组多一个空间才有插入的位置）， 而第二部分就只包含这一个元素（即待插入元素）。 在第一部分排序完成后，再将这个最后元素插入到已排好序的第一部分中。**

```java
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
```



```java
public void paixu() {
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
```

参考：[https://blog.csdn.net/qq_27248989/article/details/105074946](https://blog.csdn.net/qq_27248989/article/details/105074946)

## 希尔排序

希尔排序：希尔排序通过将比较的全部元素分为几个区域来提升插入排序的性能。这样可以让一个元素可以一次性地朝最终位置前进一大步。然后算法再取越来越小的步长进行排序，算法的最后一步就是普通的插入排序，但是到了这步，需排序的数据几乎是已排好的了（此时插入排序较快）。



```java
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
```
