import org.json.JSONStringer;

public class SPA {

	public static void main(String[] args) {
		Data data = new DataJSON();
		SPAdataModel spaDataModel = new SPAdataModel(data);
		System.out.println(spaDataModel);
		SPAalgorithm spaAlgorithm = new SPAalgorithm(spaDataModel);
		spaAlgorithm.allocation();
		//spaAlgorithm.allocationStableTest();
		// System.out.println(spaDataModel.studentList);
		// System.out.println(spaDataModel.lecturerList);
		// System.out.println(spaDataModel.projectList);
		int[][] tmp = spaDataModel.result();
		JSONStringer js = new JSONStringer();
		js.object();
		for (int i = 0; i < tmp.length; i++) {
			js.key(String.valueOf(tmp[i][0]));
			js.value(String.valueOf(tmp[i][1]));
		}
		js.endObject();

		System.out.println(js);
		APIConnector.uploadToURLWithToken("http://spa.liangyanbo.com/SPA/API/allocation_result.php", "123456789", "result=" + js.toString());
	}
}
