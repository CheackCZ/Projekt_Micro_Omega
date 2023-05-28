package userMatchScreen_Window_Package;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.Timer;

import userMatch_Window_Package.UserMatch_Window;

/**
 * JPanel including button with time and JTextField with match round
 * @author ondra
 */
public class RoundAndTimeUserMatch_JP extends JPanel {

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

    /**
     * Create the panel
     * @param userMatchWindow for all the things inside
     */
    public RoundAndTimeUserMatch_JP(UserMatch_Window userMatchWindow) {

        setLayout(null);
        setBackground(Color.WHITE);
        setSize(195, 110);


        txtMatchRound = new JTextField();
        txtMatchRound.setEditable(false);
        txtMatchRound.setHorizontalAlignment(SwingConstants.CENTER);
        txtMatchRound.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 28));
        txtMatchRound.setForeground(Color.BLACK);
        txtMatchRound.setBackground(Color.WHITE);
        txtMatchRound.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        txtMatchRound.setBounds(0, 0, 195, 30);
        add(txtMatchRound);


        btnClock = new JButton("");
        btnClock.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnClock.setEnabled(false);
        btnClock.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if ((e.getSource()==btnClock)) {
                    if (userMatchWindow.matchWindow.RoundAndTime.started == false) {
                        userMatchWindow.matchWindow.RoundAndTime.started = true;
                        userMatchWindow.matchWindow.RoundAndTime.timer.stop();
                        Stop();
                    } else {
                        userMatchWindow.matchWindow.RoundAndTime.started = false;
                        userMatchWindow.matchWindow.RoundAndTime.timer.start();
                        Start();
                    }
                }
            }
        });
        btnClock.setFocusable(false);
        btnClock.setOpaque(true);
        btnClock.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        btnClock.setFont(new Font("Dialog", Font.PLAIN, 68));
        btnClock.setHorizontalAlignment(SwingConstants.CENTER);
        btnClock.setForeground(Color.BLACK);
        btnClock.setBackground(Color.WHITE);
        btnClock.setBounds(10, 30, 175, 75);
        add(btnClock);

        btnClock.setText("00:30");
        countdownTimer();

    }

    /**
     * Method for the timer to countdown to zero
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

    /**
     * @return second (int)
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
     * @return minute (int)
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
