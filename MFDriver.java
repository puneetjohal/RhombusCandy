public class MFDriver {

  //populates matricies with random integer values between 0 and 1000
  public static void populate (int[][] arr) {
    for (int r = 0; r < arr.length; r++) {
      for (int c = 0; c < arr.length; c++) {
        arr[r][c] = (int)(Math.random() * 1000);
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

    //10 "warm up" trials
    for (int w = 0; w < 10; w++){
      int[][] foo = new int[1000][1000];
      populate(foo);
      getTime(foo);
    }

    //1000 experimental trials
    for (int i = 0; i < 1000; i++) {
      //for each trial test search method on 100 different randomly generated matricies for the worst case (bottom left corner)
      int n = 1000 + (i*100); //n increases by 100 after each trial
      long totalTime = 0;
      for (int x = 0; x < 100; x++) {
        int[][] arr = new int[n][n];
        populate(arr);
        totalTime += getTime(arr);
      }
      System.out.println( n + "," + (double)totalTime/100 );
    }

  }

}
