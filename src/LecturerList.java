public class LecturerList {

	private int lecturerCount;
	private Lecturer[] lecturerList;
	private int[][] lecturerProjectListData;

	public LecturerList(int[][] lecturerListData, int[][] lecturerProjectListData) {
		this.lecturerCount = lecturerListData.length;
		this.lecturerList = new Lecturer[lecturerCount];
		this.lecturerProjectListData = lecturerProjectListData;
		for (int i = 0; i < lecturerCount; i++) {
			lecturerList[i] = new Lecturer(lecturerListData[i][0], lecturerListData[i][1], new LecturerProjectList(lecturerProjectListData[i].length));
		}
	}

	/* model method, link lecturerProjectList with projectList */

	public void linkTo(ProjectList projectList) {
		for (int i = 0; i < lecturerCount; i++) {
			Lecturer l = lecturerList[i];
			LecturerProjectList lpl = l.lecturerProjectList();
			for (int j = 0; j < lpl.projectCount(); j++) {
				Project p = projectList.projectWithId(lecturerProjectListData[i][j]);
				lpl.setProject(p, j);
				p.setLecturer(l);
			}
		}
	}

	/**********************/

	/* get and set method */
	
	public int lecturerCount() {
		return lecturerCount;
	}

	public Lecturer lecturerWithIndex(int index) {
		return lecturerList[index];
	}

	public Lecturer lecturerWithId(int id) {
		for (int i = 0; i < lecturerCount; i++) {
			if (lecturerList[i].id() == id) {
				return lecturerList[i];
			}
		}
		return null;
	}

	/**********************/

	public String toString() {
		String tmp = "";
		for (int i = 0; i < lecturerCount; i++) {
			tmp += lecturerList[i] + "" + lecturerList[i].lecturerProjectList() + "\n";
		}
		return tmp;
	}
}
