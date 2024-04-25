public class DecompressMain {
    public static void main(String[] args) {
        Decompress d1 = new Decompress();
        int[] array = {1,2,3,4};
        int[] newArray = d1.decompressRLElist(array);
        for(int i = 0; i < newArray.length; i++) {
            System.out.print(newArray[i] + " ");
        }
    }
}
