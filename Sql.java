package sms;

public class Sql {

    static String allStudents = "SELECT * FROM `students` ORDER BY `id`;";
    static String allTrainers = "SELECT * FROM `trainers`ORDER BY `id`;";
    static String allAssignments = "SELECT * FROM `assignments`ORDER BY `id`;";
    static String allCourses = "SELECT * FROM `courses`ORDER BY `id`;";
    static String allStudentsPerCourse = "SELECT `students`.* FROM `students`INNER JOIN `courses_students` ON `courses_students`.`studentID`=`students`.`id` INNER JOIN  `courses` ON `courses`.`id`=`courses_students`.`courseID` WHERE `courses`.`id` = ? ORDER BY `students`.`id`;";
    static String allTrainersPerCourse = "SELECT  `trainers`.* FROM `trainers` INNER JOIN `courses_trainers`  ON `courses_trainers`.`trainerid` = `trainers`.`id` JOIN `courses` ON `courses`.`id` = `courses_trainers`.`courseID` WHERE `courses`.`id` = ? ORDER BY `trainers`.`id`;";
    static String allAssignmentsPerCourse = "SELECT `assignments`.* FROM `assignments` INNER JOIN `courses`  ON `courses`.`id` = `assignments`.`courseID` WHERE `courses`.`id` = ? ORDER BY `courses`.`title`;";
    static String allAssignmentsPerCoursePerStudent = "SELECT `assignments`.`id`, `assignments`.`title`, `assignments`.`description`, `assignments`.`subdatetime` FROM `assignments` WHERE `assignments`.`courseID`IN (SELECT `courses_students`.`courseID` FROM `courses_students` WHERE `courses_students`.`courseid` = ?  AND `courses_students`.`studentid` = ?);";
    static String allStudentsMoreThanOneCourses = "SELECT `students`.* FROM `students` WHERE `students`.`id` IN (SELECT `studentID` FROM `courses_students` GROUP BY `studentID` HAVING COUNT(`studentID`) > 1);";
}
