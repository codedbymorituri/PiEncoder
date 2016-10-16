/*
PiEncoder - a basic FFmpeg front end.
Written as part of my project for using FFmpeg to encode video and audio on a Raspberry Pi.
Copyright (C) 2016 morituri

This program is free software: you can redistribute it and/or modify
it under the terms of the GNU General Public License as published by
the Free Software Foundation, either version 3 of the License, or
(at your option) any later version.

This program is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU General Public License for more details.

You should have received a copy of the GNU General Public License
along with this program.  If not, see http://www.gnu.org/licenses.
 */

package jPiEncoder;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.TimeUnit;
import javax.swing.Timer;

public class AppTimer implements ActionListener{
    
    private final GUI updateGUI;
    public AppTimer(GUI guiForm) {
        updateGUI = guiForm;                                
    }
    
    public double PercentageDone;
    private long StartTime;
    private Timer t;
    
    public void Start() {
        StartTime=System.currentTimeMillis();
        t = new Timer(1000, this);
        t.start();        
    }
    
    public void Stop() {
        t.stop();
    }

    public void actionPerformed(ActionEvent e) {
        UpdateTimerLabels();
     }
    
    private void UpdateTimerLabels() {
        try {
            long TimeNow = System.currentTimeMillis();
            long ElapsedTime = TimeNow - StartTime;
            double RemainingTime = ElapsedTime / PercentageDone * (100 - PercentageDone);
            String FormattedElapsedTime = ConvertMilliSeconds(ElapsedTime);
            String FormattedRemainingTime = ConvertMilliSeconds((long)RemainingTime);
            updateGUI.UpdateTimeElapsed(FormattedElapsedTime);
            updateGUI.UpdateTimeRemaining(FormattedRemainingTime);  
        } 
        catch (Exception ex) {
            //ex.printStackTrace();    
        }
    }
    
    private String ConvertMilliSeconds(long milliSeconds) {
        int Hours = (int) TimeUnit.MILLISECONDS.toHours(milliSeconds) % 24;
        int Minutes = (int) TimeUnit.MILLISECONDS.toMinutes(milliSeconds) % 60;
        int Seconds = (int) TimeUnit.MILLISECONDS.toSeconds(milliSeconds) % 60;
        return String.format("%02d:%02d:%02d", Hours, Minutes, Seconds);
    }
    
}// End Class





