package OOPS._OOPS.src;

public class StudentUser extends Student {
    public static void main(String[] args) throws Exception {

        Student s = new Student();

        s.name = "Kiran";
        s.rollNumber = 1111;

        System.out.println("Hello, World!");
        System.out.println(s.name);
        System.out.println(s.rollNumber);

        Student s1 = new Student();

        s1.name = "Vamsi";
        s1.rollNumber = 1112;

        System.out.println(s1.name);
        System.out.println(s1.rollNumber);

        System.out.println(s);
    }
}
