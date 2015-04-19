package com.GameEngine;

import com.GameEngine.Card;

import java.util.ArrayList;

/**
 * Created by davidmcfall on 3/23/15.
 */
public class Player
{
    private int wins;
    private ArrayList<Card> cards;
    private boolean roundWinner;
    private String playerName = "Player";
    private int playerID;

    Player(int playerID)
    {
        this.playerID = playerID;
        setUp();
    }

    Player(String playerName, int playerID)
    {
        this.playerName = playerName;
        this.playerID = playerID;
        setUp();
    }

    private void setUp()
    {
        resetWins();
        setRoundWinner(false);
        this.cards = new ArrayList<Card>();
    }

    public void setCurrentCard(Card c)
    {
        this.cards.add(c);
    }

    public Card getCurrentCard()
    {
        return cards.get(cards.size()-1);
    }

    public void win()
    {
        this.wins++;
    }

    public int getWins()
    {
        return this.wins;
    }

    public String getPlayerName()
    {
        return this.playerName;
    }

    public int getPlayerID()
    {
        return this.playerID;
    }

    public void resetWins()
    {
        this.wins=0;
    }

    public boolean isRoundWinner()
    {
        return this.roundWinner;
    }

    public void setRoundWinner(boolean v)
    {
        this.roundWinner = v;
    }

}