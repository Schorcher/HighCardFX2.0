package com.GameEngine;


import com.GameEngine.Deck;
import com.GameEngine.Player;

import java.util.ArrayList;

/**
 * Created by davidmcfall on 3/23/15.
 */
public class HighCard
{
    public ArrayList<Player> players;
    public Deck cardDeck;
    public boolean started = false;
    public int numOfPlayers;

    HighCard()
    {
        setUp();
    }

    public void setUp()
    {
        this.numOfPlayers=0;
        this.players = new ArrayList<Player>();
        this.cardDeck = new Deck();
        this.started = false;
    }

    public void play()
    {
        currentGameReset();
        if(started==false)
        {
            setUpPlayers();
        }
        dealRound();
        this.started=true;
    }

    public void setNumOfPlayers(int num)
    {
        this.numOfPlayers=num;
    }

    public void setUpPlayers()
    {
        for(int i=1; i<=this.numOfPlayers; i++)
        {
            this.players.add(new Player(i));
        }
    }

    public void dealRound()
    {
        resetRoundWinner();
        for(int i=0; i<this.players.size(); i++)
        {
            this.players.get(i).setCurrentCard(this.cardDeck.dealCard());
        }
        checkRoundWinner();
    }

    public void checkRoundWinner()
    {
        int count=0;
        double max=0, current;
        for(int i=0; i<this.players.size(); i++)
        {
            current = this.players.get(i).getCurrentCard().rankCard();
            if(current > max)
            {
                max=current;
                resetRoundWinner();
                count=i;
            }
        }
        this.players.get(count).win();
    }

    public int finalWinner()
    {
        double max=0, current;
        int winner=0;
        for(int i=0; i<this.players.size(); i++)
        {
            current = this.players.get(i).getWins();
            if(current > max)
            {
                max = current;
                winner=this.players.get(i).getPlayerID()-1;
            }
        }
        return winner;
    }

    public void newGameReset()
    {
        this.cardDeck.resetDeck();
        this.players.clear();
        this.started=false;
        this.numOfPlayers=0;
    }

    public void currentGameReset()
    {
        this.cardDeck.resetDeck();
        for(int i=0; i<this.players.size(); i++)
        {
            this.players.get(i).resetWins();
        }
    }

    public void resetRoundWinner()
    {
        for(int i=0; i<this.players.size(); i++)
        {
            this.players.get(i).setRoundWinner(false);
        }
    }

    public Player getPlayer(int i)
    {
        return this.players.get(i);
    }

    public boolean hasStarted()
    {
        return started;
    }

    public int getNumOfPlayers()
    {
        return numOfPlayers;
    }

    public void resetWins()
    {
        for(int i=0; i<this.players.size(); i++)
        {
            this.players.get(i).resetWins();
        }
    }
}
