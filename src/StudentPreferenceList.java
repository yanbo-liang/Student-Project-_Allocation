/*StudentPreferenceList class describes a list of student preference over project in SPA*/
public class StudentPreferenceList {
	
	/*StudentPreferenceList class describes a list of student preference over project in SPA*/
	private int projectCount;
	private Project[] studentPreferenceList;

	public StudentPreferenceList(int projectCount) {
		this.projectCount = projectCount;
		this.studentPreferenceList = new Project[projectCount];
	}

	/* algorithm method */

	public int position(Project project) {
		int position = -1;
		for (int i = 0; i < projectCount; i++) {
			if (studentPreferenceList[i].id() == project.id()) {
				position = i;
				break;
			}
		}
		return position;
	}

	public boolean firstIsPreferred(Project first, Project second) {
		int firstPosition = position(first);
		int secondPosition = position(second);
		if (firstPosition < secondPosition) {
			return true;
		} else {
			return false;
		}
	}

	/**********************/

	/* get and set method */

	public int projectCount() {
		return projectCount;
	}

	public Project studentPreferenceWithIndex(int index) {
		return studentPreferenceList[index];
	}

	public Project studentPreferenceWithId(int id) {
		for (int i = 0; i < projectCount; i++) {
			if (studentPreferenceList[i].id() == id) {
				return studentPreferenceList[i];
			}
		}
		return null;
	}

	public void setPreference(Project project, int index) {
		studentPreferenceList[index] = project;
	}

	/**********************/

	public String toString() {
		String tmp = "Preference: ";
		for (int i = 0; i < projectCount; i++) {
			tmp = tmp + studentPreferenceList[i].id() + " ";
		}
		return tmp;
	}
}
