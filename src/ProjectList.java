public class ProjectList {

	private int projectCount;
	private Project[] projectList;

	public ProjectList(int[][] projectListData) {
		this.projectCount = projectListData.length;
		this.projectList = new Project[projectCount];
		for (int i = 0; i < projectCount; i++) {
			projectList[i] = new Project(projectListData[i][0], projectListData[i][1]);
		}
	}

	/* get and set method */
	
	public int projectCount() {
		return projectCount;
	}

	public Project projectWithIndex(int index) {
		return projectList[index];
	}

	public Project projectWithId(int id) {
		for (int i = 0; i < projectCount; i++) {
			if (projectList[i].id() == id) {
				return projectList[i];
			}
		}
		return null;
	}

	/**********************/

	public String toString() {
		String tmp = "";
		for (int i = 0; i < projectCount; i++) {
			Student student = projectList[i].student();
			if (student != null) {
				tmp += student + "\n";
			}

		}
		for (int i = 0; i < projectCount; i++) {
			Student student = projectList[i].student();
			if (student == null) {
				tmp += projectList[i] + "\n";
			}
		}
		return tmp;
	}
}