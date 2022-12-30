import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/*
* Harrison Holsinger
* This program displays the current day, date, and time
*/

public class MyFrame extends JFrame {

    SimpleDateFormat dayFormat;
    SimpleDateFormat dateFormat;
    SimpleDateFormat timeFormat;

    JLabel dayLabel;
    JLabel dateLabel;
    JLabel timeLabel;

    String day;
    String date;
    String time;

    MyFrame() {

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("My Clock Program");
        this.setLayout(new FlowLayout());
        this.setSize(600, 200);
        this.getContentPane().setBackground(Color.BLACK);

        dayFormat = new SimpleDateFormat("EEEE, ");
        dateFormat = new SimpleDateFormat("MMMM d, YYYY");
        timeFormat = new SimpleDateFormat("hh:mm:ss a");

        dayLabel = new JLabel();
        dayLabel.setFont(new Font("Times New Roman", Font.PLAIN, 50));
        dayLabel.setForeground(Color.WHITE);

        dateLabel = new JLabel();
        dateLabel.setFont(new Font("Times New Roman", Font.PLAIN, 50));
        dateLabel.setForeground(Color.WHITE);

        timeLabel = new JLabel();
        timeLabel.setFont(new Font("Times New Roman", Font.PLAIN, 50));
        timeLabel.setForeground(Color.WHITE);

        this.add(dayLabel);
        this.add(dateLabel);
        this.add(timeLabel);
        this.setLocationRelativeTo(null);
        this.setVisible(true);

        setTime();

    }

    /*
    * This method gets the current day, date, and time
    * It utilizes a while loop to constantly update the current time
    * The sleep function pauses the loop so the method updates roughly every second
    */
    public void setTime() {

        while(true) {
            day = dayFormat.format(Calendar.getInstance().getTime());
            dayLabel.setText(day);

            date = dateFormat.format(Calendar.getInstance().getTime());
            dateLabel.setText(date);

            time = timeFormat.format(Calendar.getInstance().getTime());
            timeLabel.setText(time);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
