/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
//2.Vending machine

package com.mycompany.statepattern;
// State interface
interface State {
    void insertCoin();
    void ejectCoin();
    void pressButton();
    void dispense();
}

// Context
class VendingMachine {
    State noCoinState;
    State hasCoinState;
    State soldState;
    State soldOutState;

    State state;
    int count = 0;

    public VendingMachine(int numberOfItems) {
        noCoinState = new NoCoinState(this);
        hasCoinState = new HasCoinState(this);
        soldState = new SoldState(this);
        soldOutState = new SoldOutState(this);

        this.count = numberOfItems;
        if (numberOfItems > 0) {
            state = noCoinState;
        } else {
            state = soldOutState;
        }
    }

    public void insertCoin() {
        state.insertCoin();
    }

    public void ejectCoin() {
        state.ejectCoin();
    }

    public void pressButton() {
        state.pressButton();
        state.dispense();
    }

    void setState(State state) {
        this.state = state;
    }

    void releaseItem() {
        System.out.println("A item is rolling out of the slot...");
        if (count != 0) {
            count--;
        }
    }

    int getCount() {
        return count;
    }

    State getNoCoinState() {
        return noCoinState;
    }

    State getHasCoinState() {
        return hasCoinState;
    }

    State getSoldState() {
        return soldState;
    }

    State getSoldOutState() {
        return soldOutState;
    }
}

// Concrete States
class NoCoinState implements State {
    VendingMachine vendingMachine;

    public NoCoinState(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    @Override
    public void insertCoin() {
        System.out.println("Coin inserted");
        vendingMachine.setState(vendingMachine.getHasCoinState());
    }

    @Override
    public void ejectCoin() {
        System.out.println("No coin to eject");
    }

    @Override
    public void pressButton() {
        System.out.println("Insert coin first");
    }

    @Override
    public void dispense() {
        System.out.println("No item dispensed");
    }
}

class HasCoinState implements State {
    VendingMachine vendingMachine;

    public HasCoinState(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    @Override
    public void insertCoin() {
        System.out.println("Coin already inserted");
    }

    @Override
    public void ejectCoin() {
        System.out.println("Coin returned");
        vendingMachine.setState(vendingMachine.getNoCoinState());
    }

    @Override
    public void pressButton() {
        System.out.println("Button pressed");
        vendingMachine.setState(vendingMachine.getSoldState());
    }

    @Override
    public void dispense() {
        System.out.println("No item dispensed");
    }
}

class SoldState implements State {
    VendingMachine vendingMachine;

    public SoldState(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    @Override
    public void insertCoin() {
        System.out.println("Please wait, we're already giving you an item");
    }

    @Override
    public void ejectCoin() {
        System.out.println("Sorry, you already pressed the button");
    }

    @Override
    public void pressButton() {
        System.out.println("Pressing twice doesn't get you another item!");
    }

    @Override
    public void dispense() {
        vendingMachine.releaseItem();
        if (vendingMachine.getCount() > 0) {
            vendingMachine.setState(vendingMachine.getNoCoinState());
        } else {
            System.out.println("Oops, out of items!");
            vendingMachine.setState(vendingMachine.getSoldOutState());
        }
    }
}

class SoldOutState implements State {
    VendingMachine vendingMachine;

    public SoldOutState(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    @Override
    public void insertCoin() {
        System.out.println("No items available");
    }

    @Override
    public void ejectCoin() {
        System.out.println("You haven't inserted a coin");
    }

    @Override
    public void pressButton() {
        System.out.println("No items available");
    }

    @Override
    public void dispense() {
        System.out.println("No item dispensed");
    }
}

// Main class
public class Statepattern{
    public static void main(String[] args) {
        VendingMachine vendingMachine = new VendingMachine(5);

        vendingMachine.insertCoin();
        vendingMachine.pressButton();

        vendingMachine.insertCoin();
        vendingMachine.pressButton();

        vendingMachine.insertCoin();
        vendingMachine.pressButton();

        vendingMachine.insertCoin();
        vendingMachine.pressButton();

        vendingMachine.insertCoin();
        vendingMachine.pressButton();
    }
}
