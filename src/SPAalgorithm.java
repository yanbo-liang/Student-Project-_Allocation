public class SPAalgorithm {
	private LecturerList lecturerList;
	private ProjectList projectList;
	private StudentList studentList;

	public SPAalgorithm(SPAdataModel spaDataModel) {
		this.lecturerList = spaDataModel.lecturerList;
		this.projectList = spaDataModel.projectList;
		this.studentList = spaDataModel.studentList;
	}

	public void allocation() {
		while (studentList.checkFreeStudent()) {
			Student freeStudent = studentList.getFreeStudent();
			Project topProject = freeStudent.topProject();
			if (topProject.isAvailableAndLecturerIsNotFull()) {
				topProject.isAllocatedTo(freeStudent);
			} else if (topProject.isNotAvailableAndLecturerIsNotFull()) {
				if (topProject.preferNewStudent(freeStudent)) {
					topProject.breakCurrentAllocation();
					topProject.isAllocatedTo(freeStudent);
				}
			} else if (topProject.isNotAvailableAndLecturerIsFull()) {
				if (topProject.preferNewStudent(freeStudent) 
						&& topProject.lecturerPreferNewStudent(freeStudent)) {
					topProject.breakCurrentAllocation();
					topProject.isAllocatedTo(freeStudent);
				}
			}
		}
	}

	public void allocationStableTest() {
		for (int i = 0; i < studentList.studentCount(); i++) {
			Student s1 = studentList.studentWithIndex(i);
			for (int j = i + 1; j < studentList.studentCount(); j++) {
				Student s2 = studentList.studentWithIndex(j);
				if (s2.project().lecturerIsAvailable()) {
					if (studentAndProjectPreferEachOther(s1, s2.project())) {
						System.out.println("a");
						//System.out.println(s1);
						//System.out.println(s2);
					}
				}
				if (s2.project().lecturerIsNotAvailable()) {
					if (studentAndProjectPreferEachOther(s1, s2.project()) 
							&& s2.project().lecturerPreferNewStudent(s1)) {
						System.out.println("b");
						//System.out.println(s1);
						//System.out.println(s2);
					}
				}
				if (s1.project().lecturerIsAvailable()) {
					if (studentAndProjectPreferEachOther(s2, s1.project())) {
						System.out.println("c");
						//System.out.println(s1);
						//System.out.println(s2);
					}
				}
				if (s1.project().lecturerIsNotAvailable()) {
					if (studentAndProjectPreferEachOther(s2, s1.project()) 
							&& s1.project().lecturerPreferNewStudent(s2)) {
						System.out.println("d");
						//System.out.println(s1);
						//System.out.println(s2);
					}
				}
			}
		}
	}

	public boolean studentAndProjectPreferEachOther(Student student, Project project) {
		if (student.preferNewProject(project) && project.preferNewStudent(student)) {
			return true;
		} else {
			return false;
		}
	}

	public double[] worstAndAverage() {
		double[] test = new double[2];
		double worst = 0;
		double average = 0;
		for (int i = 0; i < studentList.studentCount(); i++) {
			int tmp = studentList.studentWithIndex(i).projectPostion();
			if (tmp > worst) {
				worst = tmp;
			}
			average += tmp;
		}
		test[0] = worst;
		test[1] = average / (double) studentList.studentCount();
		return test;
	}

	public int typeCheck() {
		int tmp = 0;
		for (int i = 0; i < studentList.studentCount(); i++) {
			if (studentList.studentWithIndex(i).typeFitIn()) {
				tmp += 1;
			}
		}
		return tmp;
	}
}
