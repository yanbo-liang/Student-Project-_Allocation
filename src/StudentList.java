public class StudentList {

	private int studentCount;
	private Student[] studentList;
	private int[][] studentPreferenceListData;
	private int freeStudent = 0;

	public StudentList(int[][] studentListData, int[][] studentPreferenceListData) {
		this.studentCount = studentListData.length;
		this.studentList = new Student[studentCount];
		this.studentPreferenceListData = studentPreferenceListData;
		for (int i = 0; i < studentCount; i++) {
			studentList[i] = new Student(studentListData[i][0], studentListData[i][1], new StudentPreferenceList(studentPreferenceListData[i].length));
		}

	}

	/* model method, link studentPreferenceList with projectList */

	public void linkTo(ProjectList projectList) {
		for (int i = 0; i < studentCount; i++) {
			Student s = studentList[i];
			StudentPreferenceList spl = s.studentPreferenceList();
			for (int j = 0; j < spl.projectCount(); j++) {
				Project p = projectList.projectWithId(studentPreferenceListData[i][j]);
				spl.setPreference(p, j);
			}
		}
	}

	/**********************/

	/* algorithm method */

	public boolean checkFreeStudent() {
		for (int i = 0; i < studentCount; i++) {
			if (studentList[i].project() == null) {
				return true;
			}
		}
		return false;
	}

	public Student getFreeStudent() {
		int i = freeStudent;
		while (true) {
			if (studentList[i].project() == null) {
				freeStudent = i + 1;
				if (freeStudent == studentCount) {
					freeStudent = 0;
				}
				return studentList[i];
			}
			i += 1;
			if (i == studentCount) {
				i = 0;
			}
		}
	}

	/**********************/

	/* get and set method */

	public int studentCount() {
		return studentCount;
	}

	public Student studentWithIndex(int index) {
		return studentList[index];
	}

	public Student studentWithId(int id) {
		for (int i = 0; i < studentCount; i++) {
			if (studentList[i].id() == id) {
				return studentList[i];
			}
		}
		return null;
	}

	/**********************/

	public String toString() {
		String tmp = "";
		for (int i = 0; i < studentCount; i++) {
			tmp = tmp + studentList[i] + "\n";
		}
		return tmp;
	}

}
