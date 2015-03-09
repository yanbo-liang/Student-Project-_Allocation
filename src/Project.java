/*Project class describes student entity in SPA*/
public class Project {

	/* 4 class variables of a project */
	private int id;
	private int type;
	private Lecturer lecturer;
	private Student student;

	/* constructor to build a project instance */
	public Project(int id, int type) {
		this.id = id;
		this.type = type;
	}

	/* algorithm method */
	/* allocate the project to student */
	public void isAllocatedTo(Student student) {
		this.student = student;
		this.student.setProject(this);
		this.lecturer.takeAProject();
	}

	/* break the allocation between student and project */
	public void breakCurrentAllocation() {
		this.student.setProject(null);
		this.student = null;
		this.lecturer.freeAProject();
	}

	/* if the project prefer a new student then his current student, return true */
	public boolean preferNewStudent(Student newStudent) {
		return ProjectPreferenceList.firstIsPreferred(newStudent.mark(), student.mark(), type);
	}

	/*
	 * if lecturer of the project prefer a new student then its current student,
	 * return true
	 */
	public boolean lecturerPreferNewStudent(Student newStudent) {
		return ProjectPreferenceList.firstIsPreferred(newStudent.mark(), student.mark(), 1);
	}

	public Boolean lecturerIsAvailable() {
		if (lecturer.availableCount() > 0) {
			return true;
		}
		return false;
	}

	public Boolean lecturerIsNotAvailable() {
		if (lecturer.availableCount() == 0) {
			return true;
		}
		return false;
	}

	public Boolean isAvailableAndLecturerIsNotFull() {
		if (student == null && lecturer.availableCount() > 0) {
			return true;
		}
		return false;
	}

	public Boolean isNotAvailableAndLecturerIsNotFull() {
		if (student != null && lecturer.availableCount() > 0) {
			return true;
		}
		return false;
	}

	public Boolean isAvailableAndLecturerIsFull() {
		if (student == null && lecturer.availableCount() == 0) {
			return true;
		}
		return false;
	}

	public Boolean isNotAvailableAndLecturerIsFull() {
		if (student != null && lecturer.availableCount() == 0) {
			return true;
		}
		return false;
	}

	/**********************/

	/* get and set method */

	public int id() {
		return id;
	}

	public int type() {
		return type;
	}

	public Lecturer lecturer() {
		return lecturer;
	}

	public void setLecturer(Lecturer lecturer) {
		this.lecturer = lecturer;
	}

	public Student student() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	/**********************/

	public String toString() {
		String tmp = "(Project: " + id + "(" + type + ") " + lecturer + ")";
		return tmp;
	}
}
