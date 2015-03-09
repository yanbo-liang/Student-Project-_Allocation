/*Student class describes student entity in SPA*/
public class Student {

	/* 4 class variables of a student */
	private int id;
	private int mark;
	private StudentPreferenceList studentPreferenceList;
	private Project project;

	private int currentProject = 0;

	/* constructor to build a student instance */
	public Student(int id, int mark, StudentPreferenceList studentPreferenceList) {
		this.id = id;
		this.mark = mark;
		this.studentPreferenceList = studentPreferenceList;
	}

	/* algorithm method */

	public Project topProject() {
		if (currentProject < studentPreferenceList.projectCount()) {
			Project tmp = studentPreferenceList.studentPreferenceWithIndex(currentProject);
			currentProject += 1;
			return tmp;
		} else {
			return null;
		}
	}

	/* if the student prefer a new project then his current project, return true */
	public boolean preferNewProject(Project newProject) {
		return studentPreferenceList.firstIsPreferred(newProject, project);
	}

	/* return the current project position in the student preference list */
	public int projectPostion() {
		return studentPreferenceList.position(project) + 1;
	}

	public boolean typeFitIn() {
		int tmp = ProjectPreferenceList.bestType(mark);
		if (tmp == project.type()) {
			return true;
		}
		return false;
	}

	/**********************/

	/* get and set method */

	public int id() {
		return id;
	}

	public int mark() {
		return mark;
	}

	public StudentPreferenceList studentPreferenceList() {
		return studentPreferenceList;
	}

	public Project project() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	/**********************/

	public String toString() {
		String tmp = "Student: " + id + "(" + mark + ")=>" + project + "\t" + studentPreferenceList;
		return tmp;
	}
}
