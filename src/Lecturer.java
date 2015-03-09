/*Lecturer class describes student entity in SPA*/
public class Lecturer {

	private int id;
	private int maxCount;
	private int availableCount;
	private LecturerProjectList lecturerProjectList;

	public Lecturer(int id, int maxCount, LecturerProjectList lecturerProjectList) {
		this.id = id;
		this.maxCount = maxCount;
		this.availableCount = maxCount;
		this.lecturerProjectList = lecturerProjectList;
	}

	/* algorithm method */

	public void takeAProject() {
		availableCount -= 1;
	}

	public void freeAProject() {
		availableCount += 1;
	}

	/**********************/

	/* get and set method */

	public int id() {
		return id;
	}

	public int maxCount() {
		return maxCount;
	}

	public int availableCount() {
		return availableCount;
	}

	public LecturerProjectList lecturerProjectList() {
		return lecturerProjectList;
	}

	/**********************/

	public String toString() {
		String tmp = "<Lecturer: " + id + "(" + availableCount + "-" + maxCount + "-" + lecturerProjectList.projectCount() + ")>";
		return tmp;
	}
}
