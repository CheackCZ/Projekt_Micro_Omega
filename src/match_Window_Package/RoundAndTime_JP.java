package match_Window_Package;

import javax.swing.Timer;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

import javax.swing.SwingConstants;

/**
 * JPanel including button with time and JTextField with match round
 * @author ondra
 */
public class RoundAndTime_JP extends JPanel {

    /** JTextField - text and the number of the ring */
    public JTextField txtMatchRound;

    /** JLabel - where the time will count */
    public JButton btnClock;

    /** Timer using for the countdown timer */
    public Timer timer;

    /** Values for the time */
    private int second, minute;
    /** String values for the time */
    String ddSecond, ddMinute;

    /** Formatting the time */
    DecimalFormat dFormat = new DecimalFormat("00");

    /** Controlling if time currently running or not */
    public boolean started = false;

    /**
     * Create the panel.
     */
    public RoundAndTime_JP() {

        setLayout(null);
        setBackground(Color.WHITE);
        setSize(370, 300);


        txtMatchRound = new JTextField();
        txtMatchRound.setEditable(false);
        txtMatchRound.setHorizontalAlignment(SwingConstants.CENTER);
        txtMatchRound.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 36));
        txtMatchRound.setForeground(Color.BLACK);
        txtMatchRound.setBackground(Color.WHITE);
        txtMatchRound.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        txtMatchRound.setBounds(60, 110, 250, 40);
        add(txtMatchRound);


        btnClock = new JButton("");
        btnClock.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnClock.setEnabled(false);
        btnClock.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if ((e.getSource()==btnClock)) {
                    if (started == false) {
                        started = true;
                        Stop();
                    } else {
                        started = false;
                        Start();
                    }
                }
            }
        });
        btnClock.setFocusable(false);
        btnClock.setOpaque(true);
        btnClock.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        btnClock.setFont(new Font("Dialog", Font.PLAIN, 135));
        btnClock.setHorizontalAlignment(SwingConstants.CENTER);
        btnClock.setForeground(Color.BLACK);
        btnClock.setBackground(Color.WHITE);
        btnClock.setBounds(10, 150, 350, 150);
        add(btnClock);

        btnClock.setText("00:30");
        countdownTimer();

    }

    /**
     * Method for the timer to count down to zero
     */
    public void countdownTimer() {

        timer = new Timer(1000, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                second--;
                ddSecond = dFormat.format(getSecond());
                ddMinute = dFormat.format(getMinute());
                btnClock.setText(ddMinute + ":" + ddSecond);

                if (second == -1) {
                    second = 59;
                    minute--;
                    ddSecond = dFormat.format(second);
                    ddMinute = dFormat.format(minute);
                    btnClock.setText(ddMinute + ":" + ddSecond);
                }

                if (minute == 0 && second == 0) {
                    timer.stop();
                }

            }
        });
    }

    /**
     * Method that starts the count down of the timer
     */
    void Start() {
        timer.start();
    }

    /**
     * Method that stops the count down of the timer
     */
    void Stop() {
        timer.stop();
    }

    //Getters and Setters
    /**
     * @return second
     */
    public int getSecond() {
        return second;
    }
    /**
     * @param second of the time being set
     */
    public void setSecond(int second) {
        this.second = second;
    }

    /**
     * @return minute
     */
    public int getMinute() {
        return minute;
    }
    /**
     * @param minute of the time being set
     */
    public void setMinute(int minute) {
        this.minute = minute;
    }}
