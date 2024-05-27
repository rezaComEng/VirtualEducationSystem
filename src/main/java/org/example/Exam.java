package org.example;

import net.miginfocom.layout.DimConstraint;
import net.miginfocom.swing.MigLayout;
import org.example.question.ExamMode;
import org.example.question.Question;

import javax.swing.*;
import java.sql.Time;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Exam {
    public ExamPane examPane ;
    private String description ;
    private ArrayList<Question> questions = new ArrayList<Question>() ;
    private ExamMode examMode ;
    private Date creationTime ;
    private Date closingTime ;
    private Time examTime ;

    public Exam(ExamMode examMode, Time examTime) {
        creationTime = new Date() ;
        this.examMode = examMode;
        this.examTime = examTime;
    }

    public Exam(ExamMode examMode, Date closingTime, Time examTime) {
        creationTime = new Date();
        this.examMode = examMode;
        this.closingTime = closingTime;
        this.examTime = examTime;
    }

    public Exam(ExamMode examMode) {
        creationTime = new Date() ;
        this.examMode = examMode;
    }

    public void addQuestion (Question q) {
        questions.add( q ) ;
    }

    public class ExamPane extends JPanel {

        private final ClockPane clockPane  = new ClockPane();
        private final JLabel titleLabel = new JLabel() ;

        private void initTitlePane () {
            String title = new String("description :" + description +
                    "\n creation Time : " + DateFormat.getDateTimeInstance().format(creationTime)) ;
            if ( closingTime != null ) title.concat("\n closing time : " + DateFormat.getDateTimeInstance().format(closingTime));
            else title.concat("\n closing time : unlimited!");
            if ( examTime != null ) title.concat("\n exam Time : " + DateFormat.getTimeInstance().format(examTime)) ;
            else title.concat("\n exam Time : unlimited!") ;

            titleLabel.setText(title);
        }
        private final JScrollPane questionsPane = new JScrollPane() ;

        public ExamPane () {
            init();
        }

        private void init () {
            setLayout( new MigLayout("fill , center") );

            add(clockPane,"push") ;
            add(titleLabel,"wrap") ;
            add(questionsPane, "span 2 1") ;
        }
    }
}
