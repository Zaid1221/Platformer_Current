package com.jarz.game.Tools;

/**
 * Created by Zaid Javaid on 12/12/2017.
 */

public class Score {
    private String name;
    private int score;

    public Score(String newName, int newScore){
        setName(newName);
        setScore(newScore);
    }

    public void setName(String newName){
        name = newName;
    }

    public void setScore(int newScore){
        score = newScore;
    }

    public String getName(){
        return name;
    }

    public int getScore(){
        return score;
    }

    public String toString(){
        return name + ": " + score;
    }
}
