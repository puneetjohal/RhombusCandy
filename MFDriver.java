public class MFDriver {

  //populates matricies with random integer values between 0 and 1000
  public static void populate (int[][] arr) {
    for (int r = 0; r < arr.length; r++) {
      for (int c = 0; c < arr.length; c++) {
        arr[r][c] = (int)(Math.random() * 1000);
      }
    }
  }

  public static void main (String[] args) {

    //1 thousand trials
    for (int i = 0; i < 1000; i++) {
      long startTime = System.currentTimeMillis();
      //for each trial test 100 different randomly generated matrices of the same length for the worst case
      for (int x = 0; i < 100; x++) {
        int[][] arr = new int[1000 + (i*100)][1000 + (i*100)];
        populate(arr);
        int worstCase = arr[arr.length-1][0]; //worst case the value at the bottom left
        MatrixFinder test = new MatrixFinder();
        test.search( worstCase, arr );
        //note to self: creating + populating a new array affects the runtime
      }
      long endTime = System.currentTimeMillis();
      System.out.println(endTime-startTime/100);
    }

  }

}
