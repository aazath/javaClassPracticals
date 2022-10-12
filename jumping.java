public class jumping {
    public static void main(final String args[]) {
        loop: for (int i = 10; i < 20; i++) {
            System.out.print(i);
            System.out.println();
            if (i == 15) {
                break;
            }

            for (int j = 1; j < 10; j++) {
                System.out.println(j);
                if (j == 5) {
                    continue loop;
                }
            }
        }
    }
}