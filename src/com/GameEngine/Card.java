package com.GameEngine;

import javafx.scene.image.Image;

/**
 * Created by davidmcfall on 3/23/15.
 */
public class Card
{
    private String suit;
    private String value;
    private int s;
    private int v;

    Card(int suit, int val)
    {
        this.setSuit(suit);
        this.setValue(val);
        this.s=suit;
        this.v=val;
    }
    public void setSuit(int num)
    {
        switch (num)
        {
            case 1:
                suit="Clubs";
                break;
            case 2:
                suit="Hearts";
                break;
            case 3:
                suit="Diamonds";
                break;
            case 4:
                suit="Spades";
                break;
        }
    }
    public String getSuit()
    {
        return suit;
    }
    public void setValue(int num)
    {
        switch (num)
        {
            case 2:
                value="Two";
                break;
            case 3:
                value="Three";
                break;
            case 4:
                value="Four";
                break;
            case 5:
                value="Five";
                break;
            case 6:
                value="Six";
                break;
            case 7:
                value="Seven";
                break;
            case 8:
                value="Eight";
                break;
            case 9:
                value="Nine";
                break;
            case 10:
                value="Ten";
                break;
            case 11:
                value="Jack";
                break;
            case 12:
                value="Queen";
                break;
            case 13:
                value="King";
                break;
            case 14:
                value="Ace";
                break;
        }



        if(num==13)
        {
            value="King";
        }
    }

    public Image getImage()
    {
        String str;
        if(v==1 || v>10)
        {
            str = ("/com/Resources/PNG-cards/" + getValue().toLowerCase() + "_of_" + getSuit().toLowerCase() + ".png");
        }
        else
        {
            str = ("/com/Resources/PNG-cards/" + v + "_of_" + getSuit().toLowerCase() + ".png");
        }
        return new Image(str);
    }

    public String getValue()
    {
        return value;
    }

    public double rankCard()
    {
        String str = (v+ "."+s);
        double rank = Double.parseDouble(str);
        return rank;
    }

    public String toString()
    {
        return (getValue() + " of " + getSuit());
    }
}