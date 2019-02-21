package com.progressoft.induction;

import java.math.BigDecimal;

public enum SnackType {
  CHEWING_GUM(Money.HALF_DINAR),
  CHIPS(Money.QUARTER_DINAR),
  CHOCOLATE(Money.DINAR);

  private BigDecimal price;

  SnackType(BigDecimal price){
    this.price = price;
  }

  BigDecimal getPrice(){
    return this.price;
  }
}

