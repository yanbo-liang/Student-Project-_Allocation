public class DataSimulation implements Data {
	public final int lecturerCount = 2;
	public final int studentCount = 6;
	public final int projectTypeCount[] = setProjectTypeCount();
	public final int projectCount = setProjectCount();
	public final int[][] lecturerListData = setLecturerListData();
	public final int[][] projectListData = setProjectListData();
	public final int[][] lecturerProjectListData = setLecturerProjectListData();
	public final int[][] studentListData = setStudentListData();
	public final int[][] studentPreferenceListData = setStudentPreferenceListData();

	public int[][] lecturerListData() {
		return lecturerListData;
	}

	public int[][] projectListData() {
		return projectListData;
	}

	public int[][] lecturerProjectListData() {
		return lecturerProjectListData;
	}

	public int[][] studentListData() {
		return studentListData;
	}

	public int[][] studentPreferenceListData() {
		return studentPreferenceListData;
	}

	private int[] setProjectTypeCount() {
		int[] typeCount = new int[3];
		double tmp = ((double) studentCount) / 4 * 1.5;
		typeCount[0] = (int) (tmp * 1)+1;
		typeCount[1] = (int) (tmp * 2);
		typeCount[2] = (int) (tmp * 1)+1;
		return typeCount;
	}

	private int setProjectCount() {
		int tmp = projectTypeCount[0] + projectTypeCount[1] + projectTypeCount[2];
		return tmp;
	}

	private int[][] setLecturerListData() {
		int[][] lecturerListData = new int[lecturerCount][3];
		int average = projectCount / lecturerCount;
		int remain = projectCount % lecturerCount;
		for (int i = 0; i < lecturerCount; i++) {
			lecturerListData[i][0] = i + 1;
			lecturerListData[i][1] = average-1;
			lecturerListData[i][2] = average;
		}
		for (int i = 0; i < remain; i++) {
			int tmp = (int) (Math.random() * lecturerCount);
			lecturerListData[tmp][2] += 1;
		}
		return lecturerListData;
	}

	private int[][] setProjectListData() {
		int[][] projectListData = new int[projectCount][2];
		for (int i = 0; i < projectCount; i++) {
			projectListData[i][0] = i + 1;
		}
		for (int i = 0; i < projectTypeCount[0]; i++) {
			projectListData[i][1] = 1;
			;
		}
		for (int i = projectTypeCount[0]; i < projectTypeCount[0] + projectTypeCount[1]; i++) {
			projectListData[i][1] = 2;
			;
		}
		for (int i = projectTypeCount[0] + projectTypeCount[1]; i < projectCount; i++) {
			projectListData[i][1] = 3;
			;
		}
		return projectListData;
	}

	private int[][] setLecturerProjectListData() {
		int[][] lecturerProjectListData = new int[lecturerCount][];
		int[] random = randomArray1(projectCount);
		int tmp = 0;
		for (int i = 0; i < lecturerCount; i++) {
			lecturerProjectListData[i] = new int[lecturerListData[i][2]];
			for (int j = 0; j < lecturerProjectListData[i].length; j++) {
				lecturerProjectListData[i][j] = random[tmp];
				tmp += 1;
			}
		}
		return lecturerProjectListData;
	}

	private int[][] setStudentListData() {
		int[][] studentListData = new int[studentCount][2];
		int[] markList = new Mark(90, 30, 60, studentCount).getMarkList();
		for (int i = 0; i < studentCount; i++) {
			studentListData[i][0] = i + 1;
			studentListData[i][1] = markList[i];
		}
		return studentListData;
	}

	private int[][] setStudentPreferenceListData() {
		int[][] studentPreferenceListData = new int[studentCount][projectCount];
		for (int i = 0; i < studentCount; i++) {
			studentPreferenceListData[i] = randomArray1(projectCount);

		}
		return studentPreferenceListData;
	}

	public int[] randomArray1(int count) {
		int[] random = new int[count];
		for (int i = 0; i < count; i++) {
			random[i] = i + 1;
		}
		for (int i = 0; i < count; i++) {
			int tmp = random[i];
			int j = (int) (Math.random() * count);
			tmp = random[i];
			random[i] = random[j];
			random[j] = tmp;
		}
		return random;
	}

	public int[] randomArray(int count) {
		int[] random = new int[count];
		for (int i = 0; i < count; i++) {
			random[i] = i;
		}
		for (int i = 0; i < count; i++) {
			int tmp = random[i];
			int j = (int) (Math.random() * count);
			tmp = random[i];
			random[i] = random[j];
			random[j] = tmp;
		}
		return random;
	}

	public static void main(String args[]) {
		int[][] tmp = new DataSimulation().lecturerListData();
		for (int i = 0; i < tmp.length; i++) {
			System.out.print(i + ":");

			for (int j = 0; j < tmp[i].length; j++) {
				System.out.print(" " + tmp[i][j]);
			}
			System.out.println();
		}
	}
}
