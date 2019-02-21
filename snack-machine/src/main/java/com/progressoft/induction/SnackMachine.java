package com.progressoft.induction;

import java.math.BigDecimal;
import java.util.List;
import java.util.Arrays;

public class SnackMachine{
  static final int DEFAULT_QUANTITY = 10;
  private BigDecimal money_inside   = Money.ZERO;
  private BigDecimal money_in_trx   = Money.ZERO;

  final List<BigDecimal> MONEY_UNITS = Arrays.asList(Money.QUARTER_DINAR,
              Money.HALF_DINAR, Money.DINAR, Money.FIVE_DINAR, Money.TEN_DINAR);

  private Snack chewingGums;
  private Snack chips;
  private Snack chocolates;

  SnackMachine(){
    chewingGums = new Snack(SnackType.CHEWING_GUM, DEFAULT_QUANTITY);
    chips       = new Snack(SnackType.CHIPS, DEFAULT_QUANTITY);
    chocolates  = new Snack(SnackType.CHOCOLATE, DEFAULT_QUANTITY);
  }

  BigDecimal moneyInside(){
    return money_inside;
  }

  Money moneyInTransaction(){
    return new Money(money_in_trx);
  }

  void insertMoney(BigDecimal amount) throws IllegalArgumentException{
    if (amount != null && MONEY_UNITS.contains(amount))
      money_in_trx = money_in_trx.add(amount);
    else
      throw new IllegalArgumentException();
  }

  void insertMoney(Object obj) throws IllegalArgumentException{
    Money amount = (Money) obj;

    if (MONEY_UNITS.contains(amount.state))
      money_in_trx = money_in_trx.add(amount.state);
    else
      throw new IllegalArgumentException();
  }

  Money buySnack(SnackType snack) throws IllegalStateException{
    BigDecimal price = snack.getPrice();

    if (money_in_trx.compareTo(BigDecimal.ZERO) != 1 // buy without inserting money should fail
          || money_in_trx.compareTo(price) == -1)   // money less than price should fail
      fail();

    switch(snack){
      case CHEWING_GUM:
        if (chewingGums.quantity() <= 0) fail();
        chewingGums.decreaseQuantity();
        break;
      case CHIPS:
        if (chips.quantity() <= 0) fail();
        chips.decreaseQuantity();
        break;
      case CHOCOLATE:
        if (chocolates.quantity() <= 0) fail();
        chocolates.decreaseQuantity();
    }
    BigDecimal change = money_in_trx.subtract(price);

    money_inside = money_inside.add(price);
    money_in_trx = BigDecimal.valueOf(0);

    return new Money(change);
  }

  Snack chocolates(){
    return chocolates;
  }

  Snack chewingGums(){
    return chewingGums;
  }

  Snack chips(){
    return chips;
  }

  void fail() throws IllegalStateException{
    throw new IllegalStateException();
  }
}

