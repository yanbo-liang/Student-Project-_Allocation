public class SPADemonstration {

	public static void main(String[] args) {
		int times = 100000;
		double[][] test = new double[times][];
		for (int i = 0; i < times; i++) {
			Data data = new DataSimulation();
			SPAdataModel spaDataModel = new SPAdataModel(data);
			SPAalgorithm spaAlgorithm = new SPAalgorithm(spaDataModel);
			spaAlgorithm.allocation();
			spaAlgorithm.allocationStableTest();
			// System.out.println(spaDataModel.studentList);
			// System.out.println(spaDataModel.lecturerList);
			// System.out.println(spaDataModel.projectList);
			test[i] = spaAlgorithm.worstAndAverage();
		}
		average(test);

		Data data = new DataSimulation();
		SPAdataModel spaDataModel = new SPAdataModel(data);
		System.out.println(spaDataModel);
		SPAalgorithm spaAlgorithm = new SPAalgorithm(spaDataModel);
		spaAlgorithm.allocation();
		spaAlgorithm.allocationStableTest();
		System.out.println(spaDataModel.studentList);
		System.out.println(spaDataModel.lecturerList);
		System.out.println(spaDataModel.projectList);
	}

	public static void average(double[][] test) {
		double worst = 0;
		double average = 0;
		for (int i = 0; i < test.length; i++) {
			worst += test[i][0];
			average += test[i][1];
		}
		System.out.println("average worst position:"+worst / (double) test.length);
		System.out.println("average position:"+average / (double) test.length);

	}
}
