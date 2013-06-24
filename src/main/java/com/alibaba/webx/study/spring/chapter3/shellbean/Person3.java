/**
 * Project: study
 * File Created at 2013-6-24下午10:02:24
 */
package com.alibaba.webx.study.spring.chapter3.shellbean;

/**
 * 
 * @author zhaoyuanli
 * 2013-6-24下午10:02:24
 */
public class Person3 {
    
    private Drink drink;

    public void setDrink(Drink drink) {
        this.drink = drink;
    }
    
    public void drinkThing(){
        this.drink.getDrinkThing();
    }

}
