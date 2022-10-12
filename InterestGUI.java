import javax.swing.JOptionPane;

public class InterestGUI {
    public static void main(final String[] args) {
        // I = ptr
        final double interest, principal, rate;
        final int time;

        String strprincipal = JOptionPane.showInputDialog("What is your Principle? ");
        principal = Double.parseDouble(strprincipal);
        String strrate = JOptionPane.showInputDialog("What is the Interest Rate?(yearly) ");
        rate = Double.parseDouble(strrate);
        String strTime = JOptionPane.showInputDialog("What is your Time of Investment?(In months) ");
        time = Integer.parseInt(strTime);

        interest = (principal * time * rate) / 100;

        JOptionPane.showMessageDialog(null, "Your interest for the investment is :" + interest);
        System.exit(0);

    }
}