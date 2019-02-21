package com.progressoft.induction;

public class Snack {
  private SnackType type;
  private int quantity;

  Snack(SnackType type, int quantity){
    this.type = type;
    this.quantity = quantity;
  }

  int quantity(){
    return this.quantity;
  }

  void decreaseQuantity(){
    this.quantity--;
  }
}

