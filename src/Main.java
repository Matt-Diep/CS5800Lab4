

import java.text.DecimalFormat;
import java.util.Iterator;

/**
 *  Driver to test the Roster/Student classes.
 *  @author Jill Seaman
 *  https://userweb.cs.txstate.edu/~js236/cs3354/
 */

public class Main {
    
	public static void main(String[] args) {

        Student student = new Student("Matt Diep");
        student.addAssignmentScore(98.5);
        student.addAssignmentScore(90.1);
        student.addAssignmentScore(78.3);
        student.addExamScore(95);
        student.addExamScore(87);

        DecimalFormat df = new DecimalFormat("0.0");
        // should use algorithm A by default:
        System.out.println(student.getName() + "  " +
                           df.format(student.getAverage()));

        // switch to algorithm B:
        student.setDropLowestAssign(true);
        System.out.println(student.getName() + "  " +
                           df.format(student.getAverage()));
        // switch back to algorithm A:
        student.setDropLowestAssign(false);
        System.out.println(student.getName() + "  " +
                df.format(student.getAverage()));
        
        //test the GradeTracker
        GradeTracker gt = new GradeTracker(student);
        System.out.println("letter grade: " + gt.getLetterGrade());
        student.addExamScore(33);
        System.out.println("Added an exam score.");
        System.out.println("letter grade: " + gt.getLetterGrade());
        
        //add a new student
        Student hg = new Student("Hermione Granger");
        hg.addAssignmentScore(96.2);
        hg.addAssignmentScore(98.1);
        hg.addAssignmentScore(99.3);
        hg.addExamScore(95);
        hg.addExamScore(97);
        
        //new roster
        Roster potions = new Roster("Potions","MAG2308");
        potions.addStudent(student);
        potions.addStudent(hg);
        
        //test the roster traversal
        System.out.println("Potions grades:");
        AvgDispenser ad = potions.getDispenser();
        while (!ad.done()) {
            System.out.println("next average "  +
                               df.format(ad.getNextAvg()));
        }

    }
}
