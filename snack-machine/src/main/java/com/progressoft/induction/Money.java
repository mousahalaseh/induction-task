package com.progressoft.induction;

import java.math.BigDecimal;

public class Money {
  static final BigDecimal ZERO          = BigDecimal.valueOf(0);
  static final BigDecimal QUARTER_DINAR = BigDecimal.valueOf(0.25);
  static final BigDecimal HALF_DINAR    = BigDecimal.valueOf(0.5);
  static final BigDecimal DINAR         = BigDecimal.valueOf(1.0);
  static final BigDecimal FIVE_DINAR    = BigDecimal.valueOf(5.0);
  static final BigDecimal TEN_DINAR     = BigDecimal.valueOf(10.0);
               BigDecimal state         = ZERO;

  public Money(){}

  public Money(BigDecimal amount) throws IllegalArgumentException{
    if (amount != null && !isNegative(amount)){
      this.state = amount;
    }else{
      throw new IllegalArgumentException();
    }
  }

  boolean isLessThan(Money amount){
    if (amount == null)
      return false;
    return this.state.compareTo(amount.state) == -1;
  }

  boolean isNegative(BigDecimal amount){
    return amount.compareTo(BigDecimal.ZERO) == -1;
  }

  Money subtract(Money amount) throws IllegalArgumentException{
    if (this.isLessThan(amount))
      throw new IllegalArgumentException();
    return new Money(this.state.subtract(amount.state));
  }

  Money add(Money amount){
    return new Money(this.state.add(amount.state));
  }

  BigDecimal getState(){
    return this.state;
  }

  @Override
  public boolean equals(Object obj){
    if (obj instanceof Money)
      return this.state.compareTo(((Money)obj).state) == 0;
    else if (obj instanceof BigDecimal)
      return this.state.compareTo((BigDecimal)(obj)) == 0;
    return false;
  }
}

