package com.jackfruit.algorithmdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    // MaoPao maoPao = new MaoPao();
    // maoPao.maoPao1();
    // maoPao.maoPao2();
    // maoPao.maoPao3();
    // SelectionOrder selectionOrder = new SelectionOrder();
    // selectionOrder.selection();
    CharuPaixu charuPaixu = new CharuPaixu();
    charuPaixu.insertSort();
  }
}