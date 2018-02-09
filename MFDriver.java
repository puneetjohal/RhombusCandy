public class MFDriver {

  //populates matricies with random integer values between 0 and 1000
  public static void populate (int[][] arr) {
    int cntr = 0;
    for (int r = 0; r < arr.length; r++) {
      for (int c = 0; c < arr.length; c++) {
        arr[r][c] = cntr;
        cntr++;
      }
    }
  }

  public static long getTime (int[][] arr) {
    MatrixFinder test = new MatrixFinder();
    int worstCase = arr[arr.length-1][0]; //worst case the value at the bottom left
    long startTime = System.currentTimeMillis();
    test.search( worstCase, arr );
    long endTime = System.currentTimeMillis();
    return endTime - startTime;
  }

  public static void main (String[] args) {

    //1 thousand trials
    for (int i = 0; i < 1000; i++) {
      //for each trial test 100 different randomly generated matrices of the same length for the worst case
      int n = 1000 + (i*100); //n increases by 100 after each trial
      long totalTime = 0;
      for (int x = 0; x < 100; x++) {
        int[][] arr = new int[n][n];
        populate(arr);
        totalTime += getTime(arr);
      }
      System.out.println( n + "," + totalTime/100 );
    }

  }

}
