public class Mark {
	private int studentCount;
	private int[] markList;
	private int[] statisticsCount = new int[100];
	java.util.Random random = new java.util.Random();

	public Mark(int max, int min, int average,int studentCount) {
		this.studentCount=studentCount;
		this.markList = new int[studentCount];
		for (int i = 0; i < studentCount; i++) {
			int mark = gaussianDistributionMarkWithRange(max, min, average);
			markList[i] = mark;
		}
	}
	public int[] getMarkList(){
		return markList;
	}
	private int gaussianDistributionMark(int average) {
		double gaussianDistribution = random.nextGaussian();
		int gaussianDistributionMark = (int) ((gaussianDistribution + 3) * 16.66 + Math
				.abs(average - 50));
		return gaussianDistributionMark;
	}

	private int gaussianDistributionMarkWithRange(int max, int min, int average) {
		int gaussianDistributionMark = -1;
		int mark = gaussianDistributionMark(average);
		while (true) {
			if (mark >= min && mark <= max) {
				gaussianDistributionMark = mark;
				break;
			}
			mark = gaussianDistributionMark(average);
		}
		return gaussianDistributionMark;
	}

	public void statisticsTest(int max, int min, int average) {
		for (int i = 0; i < 100000; i++) {
			int mark = gaussianDistributionMarkWithRange(max, min, average);
			statisticsCount[mark] += 1;
		}
		for (int i = 0; i < 100; i++) {			
			System.out.println(statisticsCount[i]);
		}
	}
	public void print() {
		for (int i = 0; i < studentCount; i++) {
			System.out.println(markList[i]);
		}
	}

	public static void main(String[] args) {
		Mark mark = new Mark(90, 30, 60,100);
		mark.print();
	}
}