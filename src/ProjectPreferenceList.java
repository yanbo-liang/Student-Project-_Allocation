public class ProjectPreferenceList {
	// Research Project
	// 100-1
	private static final int[] type1 = projectPreferenceListType1();
	// Problem Solving Project
	// 69-50 100-70 49-1
	private static final int[] type2 = projectPreferenceListType2();
	// Software Development Project
	// 49-1 69-50 100-70
	private static final int[] type3 = projectPreferenceListType3();

	public static int bestType(int mark) {
		if (mark >= 70) {
			return 1;
		} else if (mark >= 50 && mark <= 69) {
			return 2;
		} else if (mark <= 50) {
			return 3;
		}
		return 0;
	}

	public static boolean firstIsPreferred(int first, int second, int type) {
		int[] tmp = null;
		if (type == 1) {
			tmp = type1;
		} else if (type == 2) {
			tmp = type2;
		} else if (type == 3) {
			tmp = type3;
		}
		int firstPosition = -1;
		int secondPosition = -1;
		for (int i = 0; i < 100; i++) {
			if (first == tmp[i]) {
				firstPosition = i;
			}
			if (second == tmp[i]) {
				secondPosition = i;
			}
		}
		if (firstPosition < secondPosition) {
			return true;
		} else {
			return false;
		}
	}

	private static int[] projectPreferenceListType1() {
		int[] type1 = new int[100];
		for (int i = 0; i < 100; i++) {
			type1[i] = 100 - i;
		}

		return type1;
	}

	private static int[] projectPreferenceListType2() {
		int[] type2 = new int[100];
		for (int i = 0; i < 20; i++) {
			type2[i] = 69 - i;
		}
		for (int i = 20; i < 51; i++) {
			type2[i] = 120 - i;
		}
		for (int i = 51; i < 100; i++) {
			type2[i] = 100 - i;
		}

		return type2;
	}

	private static int[] projectPreferenceListType3() {
		int[] type3 = new int[100];
		for (int i = 0; i < 49; i++) {
			type3[i] = 49 - i;
		}
		for (int i = 49; i < 69; i++) {
			type3[i] = 118 - i;
		}
		for (int i = 69; i < 100; i++) {
			type3[i] = 169 - i;
		}

		return type3;
	}

	public static void main(String args[]) {
		for (int i = 0; i < 100; i++) {
			System.out.print(type1[i] + " ");
		}
		System.out.println();

		for (int i = 0; i < 100; i++) {
			System.out.print(type2[i] + " ");
		}
		System.out.println();

		for (int i = 0; i < 100; i++) {
			System.out.print(type3[i] + " ");
		}
		System.out.println(firstIsPreferred(4, 2, 1));
	}
}
