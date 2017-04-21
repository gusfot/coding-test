package com.gusfot.problem;

/**
 * 5. 숫자 N이 들어왔을 때 다음을 출력하는 프로그램 작성, (언어는 자유 선택:JAVA)
 * @author hyunlaekim
 *
 */
public class Problem {
		
	private static final String ASTERIK = "*";
	private static final String SPACE = " ";

	public static void main(String[] args) {
		
		int n = 10;	// 변수n: 입력받은 값에 따라 출력이 달라진다. ex) n=4, 10, ....
		Problem problem = new Problem();
		String result = problem.solve(n);
		
		System.out.println(result); // 최종결과가 출력된다.
	}
	
	/**
	 * 변수n을 입력 받아 실제 실행을 한다. 
	 * @param n
	 * @return
	 */
	public String solve(int n) {
		
		String[][] resultArr = new String[n][n];
		getOutterArray(n, resultArr);
		
		return toString(resultArr);
	}
	
	/**
	 * 최종 외부(2차)배열을 만든다.
	 * @param n
	 * @param outerArr
	 */
	private void getOutterArray(int n, String[][] resultArr) {
		
		String[] tempArr = null;
		
		for(int j=0; j<n;j++) {
			
			tempArr = new String[n];
			getInnerArrays(n, j, tempArr);
			resultArr[j]= tempArr;
		}
	}

	/**
	 * 한 라인을 내부(1차)배열로 만든다. 
	 * @param n
	 * @param j
	 * @param innerArr
	 */
	private void getInnerArrays(int n, int j, String[] innerArr) {
		for(int i=0;i<n; i++) {
			
			int first=0;
			boolean isFirst = false, 	// 내부배열의 첫번째 원소 여부 
					isLast  = false, 	// 이중배열의 마지막 원소배열 여부 
					isEqual = false; 	// 이중배열의 행렬의 번호 동일 여부 
			
			isFirst = (i == first);
			isLast  = (j == n-1);
			isEqual = (i==j);
			
			String tmp = getString(isFirst, isLast, isEqual);	// 
			
			innerArr[i]=tmp;
			
		}
	}

	/**
	 * "*"(asterik)인지 " "(space) 판단 
	 * isFirst 또는 isLast 또는 isEqual이 '참'일 경우, "*"을 아니면 " "을 반환한다.
	 * @param isFirst
	 * @param isLast
	 * @param isEqual
	 * @return
	 */
	private String getString(boolean isFirst, boolean isLast, boolean isEqual) {
		return isLast||isFirst||isEqual ? ASTERIK : SPACE;
	}

	/**
	 * 최종2차배열을 String으로 출력한다.
	 * @param arr2
	 * @return
	 */
	private String toString(String[][] arr) {
		
		StringBuffer sb = new StringBuffer();
		for(int i=0;i<arr.length;i++) {
			for(int j=0;j<arr[i].length;j++) {
				sb.append(arr[i][j]);
			}
			sb.append("\n");
		}
		
		return sb.toString();
	}
}
