import org.json.JSONArray;
import org.json.JSONObject;

public class DataJSON implements Data {
	private final JSONObject lecturerList = new JSONObject(APIConnector.downloadFromURLWithToken("http://spa.liangyanbo.com/SPA/API/lecturer_list.php", "123456789"));
	private final JSONObject projectList = new JSONObject(APIConnector.downloadFromURLWithToken("http://spa.liangyanbo.com/SPA/API/project_list.php", "123456789"));
	private final JSONObject studentList = new JSONObject(APIConnector.downloadFromURLWithToken("http://spa.liangyanbo.com/SPA/API/student_list.php", "123456789"));
	public final int lecturerCount = getLecturerCount();
	public final int projectCount = getProjectCount();
	public final int studentCount = getStudentCount();
	public final int[][] lecturerListData = getLecturerWithProjectCount();
	public final int[][] projectListData = getProjectWithType();
	public final int[][] lecturerProjectListData = getRelationBetweenProjectAndLecturer();
	public final int[][] studentListData = getStudentWithMark();
	public final int[][] studentPreferenceListData = getPreference();

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

	private  int getLecturerCount() {
		return lecturerList.getInt("lecturer_count");
	}

	private  int getProjectCount() {
		return projectList.getInt("project_count");
	}

	private  int getStudentCount() {
		return studentList.getInt("student_count");
	}

	private  int[][] getLecturerWithProjectCount() {
		int[][] tmp = new int[lecturerCount][3];
		JSONArray array = lecturerList.getJSONArray("lecturer_list");
		for (int i = 0; i < lecturerCount; i++) {
			tmp[i][0] = array.getJSONObject(i).getInt("lecturer_id");
			tmp[i][1] = array.getJSONObject(i).getInt("max_count");
			tmp[i][2] = array.getJSONObject(i).getInt("project_count");
		}
		return tmp;
	}

	private  int[][] getProjectWithType() {
		int[][] tmp = new int[projectCount][2];
		JSONArray array = projectList.getJSONArray("project_list");
		for (int i = 0; i < projectCount; i++) {
			tmp[i][0] = array.getJSONObject(i).getInt("project_id");
			tmp[i][1] = array.getJSONObject(i).getInt("project_type");
		}
		return tmp;
	}

	private  int[][] getRelationBetweenProjectAndLecturer() {
		int[][] tmp = new int[lecturerCount][];
		JSONArray array = lecturerList.getJSONArray("lecturer_list");
		for (int i = 0; i < lecturerCount; i++) {
			int[] list = new int[array.getJSONObject(i).getInt("project_count")];
			for (int j = 0; j < list.length; j++) {
				list[j] = array.getJSONObject(i).getJSONArray("project_list").getInt(j);
			}
			tmp[i] = list;
		}
		return tmp;
	}

	private  int[][] getStudentWithMark() {
		int[][] tmp = new int[studentCount][2];
		JSONArray array = studentList.getJSONArray("student_list");
		for (int i = 0; i < studentCount; i++) {
			tmp[i][0] = array.getJSONObject(i).getInt("student_id");
			tmp[i][1] = array.getJSONObject(i).getInt("student_mark");
		}
		return tmp;
	}

	private  int[][] getPreference() {
		int[][] tmp = new int[studentCount][];
		JSONArray array = studentList.getJSONArray("student_list");
		for (int i = 0; i < studentCount; i++) {
			int[] list = new int[projectCount];
			for (int j = 0; j < list.length; j++) {
				list[j] = array.getJSONObject(i).getJSONArray("preference_list").getInt(j);
			}
			tmp[i] = list;
		}
		return tmp;
	}

}