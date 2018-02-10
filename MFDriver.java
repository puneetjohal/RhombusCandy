public class MFDriver {

  //populates matrices with intergers in numerical order
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
    long startTime = System.nanoTime();
    test.search( worstCase, arr );
    long endTime = System.nanoTime();
    return endTime - startTime;
  }

  public static void main (String[] args) {

    //100 "warm up" trials
    for (int w = 0; w < 100; w++){
      int[][] foo = new int[1000][1000];
      populate(foo);
      getTime(foo);
    }

    //360 experimental cases
    for (int i = 0; i < 360; i++) {
      //for each trial test search method 1000 times on the same, ordered matrix for the worst case (bottom left corner) --> 360,000 trials total
      int n = 1000 + (i*25); //array length n increases by 25 between cases
      long totalTime = 0;
      int[][]arr = new int[n][n];
      populate(arr);
      for (int x = 0; x < 1000; x++) {
        totalTime += getTime(arr);
      }
      System.out.println( n + "," + totalTime/(long)100 );
    }

  }

}
