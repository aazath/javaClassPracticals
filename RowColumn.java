public class RowColumn {
    public static void main(String args[]) {
        int rowNumber, columnNumber;
        for (rowNumber = 1; rowNumber <= 3; rowNumber++) {
            for (columnNumber = 1; columnNumber <= 2; columnNumber++)
                System.out.print("Row " + rowNumber + " Column " + columnNumber);
            System.out.println();
        }
    }
}