package jdbc.dao;

public class JdbcDaoDemo {
	public static void main(String[] args) throws Exception {
	StudentDAO dao = new StudentDAO();
	dao.connect();
	Student s1 = dao.getStduent(3);
	System.out.println(s1.name);
	Student s2 = new Student("Priyanka", 4);
	dao.addStudent(s2);
	}
}