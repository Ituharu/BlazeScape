
package com.iClarity.player.Skills;


import java.io.*;
import com.iClarity.misc.*;
import com.iClarity.player.*;
import com.iClarity.GameEngine;
/**
* @name timer.java
* @author tj007razor
* @version 1.7 1/27/2009
*/


public class Timer {
    private int timeToRun; // time to run (in seconds)
    private long startTime; // the time the timer started at
    private boolean activeTimer; // is the timer currently active?
    
    /**
     * constructor sets up the amount of time to run and converts input from seconds to ms, gets the starting time of the timer, and sets the timer as active
     * @param timeToRun The amout of time for the timer to run for (in seconds)
     **/
    public Timer(int timeToRun)
    {
        this.timeToRun = timeToRun*1000;
        startTime = getStartTime();
        activeTimer = true;
    }
    
    /**
     * default constructor which initializes the variables to 0 and false(for the boolean)
     **/
    public Timer()
    {
        timeToRun = 0;
        startTime = 0;
        activeTimer = false;
    }
    
    /**
     * determines the starting time of the timer
     * @return the starting time of the timer
     **/
    private long getStartTime()
    {
        return System.currentTimeMillis();
    }
    
    /**
     * calculates the amount of time that has passed since the start of the timer
     * @return the amout of time has passed since the timer started
     **/
    private long timeSinceStart()
    {
        return System.currentTimeMillis() - startTime;
    }
    
    /**
     * @return whether the timer is active or not
     **/
    public boolean isActive()
    {
        return activeTimer;
    }
    
    /**
     * set whether the timer is active or not
     * @param activeTimer is the timer active?
     **/
    public void setActive(boolean activeTimer)
    {
        this.activeTimer = activeTimer;
    }
    
    /**
     * set the amount of time for the timer to run and gets the starting time of the timer
     * @param timeToRun The amout of time for the timer to run for (in seconds)
     **/
    public void setTimeToRun(int timeToRun)
    {
        this.timeToRun = timeToRun*1000;
        startTime = getStartTime();
    }
    
    /**
     * @return how much time is left for the timer(in seconds)
     **/
    public int getTimeLeft()
    {
        return Misc.round((double)((timeToRun - timeSinceStart())/1000));
    }
    
    /**
     * determines whether or not the timer is finished running
     * @return if the timer is finished running
     **/
    public boolean stop()
    {
        if (timeSinceStart() >= timeToRun)
            return true;
        return false;
    }
}