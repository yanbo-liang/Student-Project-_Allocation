public class SPAdataModel {

	public LecturerList lecturerList;
	public ProjectList projectList;
	public StudentList studentList;

	public SPAdataModel(Data data) {
		this.lecturerList = new LecturerList(data.lecturerListData(), data.lecturerProjectListData());
		this.projectList = new ProjectList(data.projectListData());
		this.studentList = new StudentList(data.studentListData(), data.studentPreferenceListData());
		lecturerList.linkTo(projectList);
		studentList.linkTo(projectList);
	}

	public int[][] result() {
		int[][] result = new int[studentList.studentCount()][2];
		for (int i = 0; i < result.length; i++) {
			result[i][0] = studentList.studentWithIndex(i).id();
			result[i][1] = studentList.studentWithIndex(i).project().id();
		}
		return result;
	}

	/* get and set method */

	public LecturerList lecturerList() {
		return lecturerList;
	}

	public ProjectList projectList() {
		return projectList;
	}

	public StudentList studentList() {
		return studentList;
	}

	/**********************/

	public String toString() {
		return lecturerList + "\n" + projectList + "\n" + studentList;
	}
}
