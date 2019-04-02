/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

/**
 *  https://stackoverflow.com/a/13380339
 * 
 * @author Gilbert Le Blanc
 */
    
public class  DateTimer extends Thread {

    protected boolean isRunning;

    protected JLabel dateLabel;
    protected JLabel timeLabel;

    protected SimpleDateFormat dateFormat = 
            new SimpleDateFormat("Y MM dd");
    protected SimpleDateFormat timeFormat =
            new SimpleDateFormat("H:mm:ss");

    public DateTimer(JLabel dateLabel, JLabel timeLabel) {
        this.dateLabel = dateLabel;
        this.timeLabel = timeLabel;
        this.isRunning = true;
    }

    @Override
    public void run() {
        while (isRunning) {
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    Calendar currentCalendar = Calendar.getInstance();
                    Date currentTime = currentCalendar.getTime();
                    dateLabel.setText(dateFormat.format(currentTime));
                    timeLabel.setText(timeFormat.format(currentTime));
                }
            });

            try {
                Thread.sleep(100L);
            } catch (InterruptedException e) {
            }
        }
    }

    public void setRunning(boolean isRunning) {
        this.isRunning = isRunning;
    }
    public void exitProcedure() {
        setRunning(false);
        System.exit(0);
    }
}

