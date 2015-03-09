public class LecturerProjectList {

	private int projectCount;
	private Project[] lecturerProjectList;

	public LecturerProjectList(int projectCount) {
		this.projectCount = projectCount;
		this.lecturerProjectList = new Project[projectCount];
	}

	/* get and set method */

	public int projectCount() {
		return projectCount;
	}

	public Project projectWithIndex(int index) {
		return lecturerProjectList[index];
	}

	public Project projectWithId(int id) {
		for (int i = 0; i < projectCount; i++) {
			if (lecturerProjectList[i].id() == id) {
				return lecturerProjectList[i];
			}
		}
		return null;
	}

	public void setProject(Project project, int index) {
		lecturerProjectList[index] = project;
	}

	/**********************/

	public String toString() {
		String tmp = "\n";
		for (int i = 0; i < projectCount; i++) {
			Student student = lecturerProjectList[i].student();
			if (student != null) {
				tmp += student + "\n";
			}

		}
		for (int i = 0; i < projectCount; i++) {
			Student student = lecturerProjectList[i].student();
			if (student == null) {
				tmp += lecturerProjectList[i] + "\n";
			}
		}
		return tmp;
	}
}
