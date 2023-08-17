import java.util.Scanner;

class TaxCalculatorNew {
    public static void main(String[] args) {
        mainMenu();
    }

    public static void mainMenu() {
        Scanner input = new Scanner(System.in);

        System.out.println("\t\t\t\t\t\t __  ______   ________  ________");
        System.out.println("\t\t\t\t\t\t|  \\/      \\ |        \\|        \\");
        System.out.println("\t\t\t\t\t\t \\$|  $$$$$$\\| $$$$$$$$ \\$$$$$$$$");
        System.out.println("\t\t\t\t\t\t|  | $$    \\$| $$__       | $$");
        System.out.println("\t\t\t\t\t\t| $| $$      | $$  \\      | $$");
        System.out.println("\t\t\t\t\t\t| $| $$   ___| $$$$$      | $$");
        System.out.println("\t\t\t\t\t\t| $| $$__/   | $$_____    | $$");
        System.out.println("\t\t\t\t\t\t| $$\\$$     $| $$     \\   | $$");
        System.out.println("\t\t\t\t\t\t \\$$ \\$$$$$$  \\$$$$$$$$    \\$$ \n\n");

        System.out.println(
                " _______             __   __    _____              _         _____   _    _   _                   _______    ____    _____");
        System.out.println(
                "|__   __|     /\\     \\ \\ / /   / ____|     /\\     | |       / ____| | |  | | | |          /\\     |__   __|  / __ \\  |  __ \\");
        System.out.println(
                "   | |       /  \\     \\ V /   | |         /  \\    | |      | |      | |  | | | |         /  \\       | |    | |  | | | |__) |");
        System.out.println(
                "   | |      / /\\ \\     > <    | |        / /\\ \\   | |      | |      | |  | | | |        / /\\ \\      | |    | |  | | |  _  /");
        System.out.println(
                "   | |     / ____ \\   / . \\   | |____   / ____ \\  | |____  | |____  | |__| | | |____   / ____ \\     | |    | |__| | | | \\ \\");
        System.out.println(
                "   |_|    /_/    \\_\\ /_/ \\_\\   \\_____| /_/    \\_\\ |______|  \\_____|  \\____/  |______| /_/    \\_\\    |_|     \\____/  |_|  \\_\\");
        System.out.println(
                "\n\n================================================================================================================================");

        System.out.println("\n\n\t[1] Withholding Tax");
        System.out.println("\n\t[2] Payable Tax");
        System.out.println("\n\t[3] Income Tax");
        System.out.println("\n\t[4] Social Security Contribution Levy (SSCL) Tax");
        System.out.println("\n\t[5] Leasing Payment");
        System.out.println("\n\t[6] Exit");

        System.out.print("\n\n Enter an option to continue -> ");
        int first_option = input.nextInt();

        switch (first_option) {
            case 1:
                clearConsole();
                withholdingTax();
                break;

            case 2:
                clearConsole();
                payableTax();
                break;

            case 3:
                clearConsole();
                incomeTax();
                break;

            case 4:
                clearConsole();
                ssclTax();
                break;

            case 5:
                clearConsole();
                leasingPayment();
                break;

            case 6:
                System.out.println("\n\nPROGRAM EXITED... THANK YOU FOR USING TAX CALCULATOR");
                return;

            default:
                System.out.println("\n\nINVALID INPUT... PLEASE CHECK AVAILABLE OPTIONS & RUN AGAIN");
        }
    }

    // -------------------Withholding Tax Category------------------------------
    public static void withholdingTax() {
        Scanner input = new Scanner(System.in);
        System.out.println("\n\n+---------------------------------------------------------------+");
        System.out.println("|\t\t\tWITHHOLDING TAX\t\t\t\t|");
        System.out.println("+---------------------------------------------------------------+");
        System.out.println("\n\n\t[1] Rent Tax");
        System.out.println("\n\t[2] Bank Interest Tax");
        System.out.println("\n\t[3] Dividend Tax");
        System.out.println("\n\t[4] Exit");

        System.out.print("\n\nEnter an option to continue -> ");
        int wt_option = input.nextInt();

        switch (wt_option) {
            case 1:
                clearConsole();
                rentTax();
                break;

            case 2:
                clearConsole();
                bankInterestTax();
                break;

            case 3:
                clearConsole();
                dividendTax();
                break;

            case 4:
                clearConsole();
                mainMenu();
                return;

            default:
                System.out.println("\n\nINVALID INPUT... PLEASE CHECK AVAILABLE OPTIONS & RUN AGAIN");
                withholdingTax();
        }
    }

    public static void rentTax() {
        Scanner input = new Scanner(System.in);
        boolean tax_validate = true;
        double renttax = 1;

        do {
            System.out.println(
                    "+-------------------------------------------------------------------------------+");
            System.out.println("|\t\t\t\tRENT TAX\t\t\t\t\t|");
            System.out.println(
                    "+-------------------------------------------------------------------------------+\n\n");

            System.out.print("Enter your rent                 : ");
            double rent = input.nextDouble();

            if (rent <= 0) {
                System.out.print(
                        "\n\tInvalid input...\n\nDo you want to enter the correct value again (Y/N) : ");
                String choice = input.next();

                tax_validate = mainMenu_validator(choice);
                clearConsole();
            } else {

                if (rent > 100000) {
                    renttax = (rent - 100000) * 0.1;
                    System.out.println("\nYou have to pay Rent Tax\t: " + renttax);
                } else {
                    System.out.println("\n\tYou dont have to pay rent tax...");
                }

                System.out.print("\nDo you want to calculate another Rent Tax (Y/N) : ");
                String choice = input.next();
                tax_validate = mainMenu_validator(choice);
                clearConsole();
            }
        } while (tax_validate);
    }

    public static void bankInterestTax() {
        Scanner input = new Scanner(System.in);
        boolean bank_validate = true;
        do {
            System.out.println(
                    "+-------------------------------------------------------------------------------+");
            System.out.println("|\t\t\t\tBANK INTEREST TAX\t\t\t\t|");
            System.out.println(
                    "+-------------------------------------------------------------------------------+\n\n");

            System.out.print("Enter your bank interest per year               : ");
            double bank_interest = input.nextDouble();
            if (bank_interest <= 0) {
                System.out.print(
                        "\n\tInvalid input...\n\nDo you want to enter the correct value again (Y/N) : ");
                String choice = input.next();

                bank_validate = mainMenu_validator(choice);
                clearConsole();
            } else {
                System.out.println("\nYou have to pay Bank Interest Tax per year\t: "
                        + (bank_interest * 0.05));

                System.out.print("\nDo you want to calculate another Bank Interest (Y/N) : ");
                String choice = input.next();

                bank_validate = mainMenu_validator(choice);
                clearConsole();
            }
        } while (bank_validate);
    }

    public static void dividendTax() {
        Scanner input = new Scanner(System.in);
        boolean dividend_validate = true;
        do {
            System.out.println(
                    "+-------------------------------------------------------------------------------+");
            System.out.println("|\t\t\t\tDIVIDEND TAX\t\t\t\t\t|");
            System.out.println(
                    "+-------------------------------------------------------------------------------+\n\n");

            System.out.print("Enter your total dividend per year      : ");
            double dividend = input.nextDouble();

            double dividend_tax = 1;

            if (dividend <= 0) {
                System.out.print(
                        "\n\tInvalid input...\n\nDo you want to enter the correct value again (Y/N) : ");
                String choice = input.next();

                dividend_validate = mainMenu_validator(choice);
                clearConsole();
            } else {
                if (dividend > 100000) {
                    dividend_tax = (int) ((dividend - 100000) * 0.14);
                    System.out
                            .println("\nYou have to pay Dividend Tax per year\t: " + dividend_tax);

                } else {
                    System.out.println("\n\tYou dont have to pay Dividend Tax...");
                }

                System.out.print("\nDo you want to calculate another Dividend Tax (Y/N) : ");
                String choice = input.next();

                dividend_validate = mainMenu_validator(choice);
                clearConsole();
            }
        } while (dividend_validate);
    }
    // -------------------Withholding Tax Category------------------------------

    // -------------------Payable Tax Category------------------------------
    public static void payableTax() {
        Scanner input = new Scanner(System.in);
        boolean payable_validate = true;
        do {
            System.out.println("\n\n+---------------------------------------------------------------+");
            System.out.println("|\t\t\tPAYABLE TAX\t\t\t\t|");
            System.out.println("+---------------------------------------------------------------+\n\n");

            System.out.print("Enter your employee payment per month : ");
            double emp_payment = input.nextDouble();

            if (emp_payment <= 0) {
                System.out.print(
                        "\n\tInvalid input...\n\nDo you want to enter the correct value again (Y/N) : ");
                String choice = input.next();

                payable_validate = mainMenu_validator(choice);
                clearConsole();
            } else {
                payableTax_Calculator(emp_payment);

                System.out.print("\n\nDo you want to calculate another Payable Tax (Y/N) : ");
                String choice = input.next();

                payable_validate = mainMenu_validator(choice);
                clearConsole();
            }
        } while (payable_validate);
    }

    public static void payableTax_Calculator(double emp_payment) {
        double payable_tax = (int) (emp_payment - 100000);
        if (emp_payment > 100000) {
            if (emp_payment > 100000 & emp_payment <= 141667) {
                payable_tax = (int) ((emp_payment - 100000) * 0.06);
                System.out.println("\nYou have to pay Payable Tax per month : " + payable_tax);

            } else if (emp_payment > 141667 & emp_payment <= 183333) {
                payable_tax = (((emp_payment - 100000) - 41667) * 0.12) + (41667 * 0.06);
                System.out.print("\nYou have to pay Payable Tax per month : ");
                System.out.printf("%5.0f%n", payable_tax);

            } else if (emp_payment > 183333 & emp_payment <= 225000) {
                payable_tax = (int) (((emp_payment - 100000) - 83333) * 0.18) + (int) (41667 * 0.06)
                        + (int) (41667 * 0.12);
                System.out.println("\nYou have to pay Payable Tax per month : " + payable_tax);

            } else if (emp_payment > 225000 & emp_payment <= 266667) {
                payable_tax = (int) (((emp_payment - 100000) - 125000) * 0.24)
                        + (int) (41667 * 0.06)
                        + (int) (41667 * 0.12) + (int) (41667 * 0.18);
                System.out.println("\nYou have to pay Payable Tax per month : " + payable_tax);

            } else if (emp_payment > 266667 & emp_payment <= 308333) {
                payable_tax = (((emp_payment - 100000) - 166667) * 0.3) + (41667 * 0.06)
                        + (41667 * 0.12) + (41667 * 0.18) + (41667 * 0.24);
                System.out.print("\nYou have to pay Payable Tax per month : ");
                System.out.printf("%5.0f.00", payable_tax);

            } else {
                payable_tax = (int) (((emp_payment - 100000) - 208333) * 0.36)
                        + (int) (41667 * 0.06)
                        + (int) (41667 * 0.12) + (int) (41667 * 0.18) + (int) (41667 * 0.24)
                        + (int) (41667 * 0.3);
                System.out.println("\nYou have to pay Payable Tax per month : " + payable_tax);
            }
        } else {
            System.out.println("\n\tYou dont have to pay Payable Tax...");
        }
    }
    // -------------------Payable Tax Category------------------------------

    // -------------------Income Tax Category------------------------------
    public static void incomeTax() {
        Scanner input = new Scanner(System.in);
        boolean income_tax_validate = true;

        do {
            System.out.println("\n\n+---------------------------------------------------------------+");
            System.out.println("|\t\t\tINCOME TAX\t\t\t\t|");
            System.out.println("+---------------------------------------------------------------+\n\n");

            System.out.print("Enter your total income per year    : ");
            double annual_income = input.nextDouble();

            if (annual_income <= 0) {
                System.out.print(
                        "\n\tInvalid input...\n\nDo you want to enter the correct value again (Y/N) : ");
                String choice = input.next();

                income_tax_validate = mainMenu_validator(choice);
                clearConsole();
            } else {
                incomeTax_Calculator(annual_income);

                System.out.print("\n\nDo you want to calculate another Income Tax (Y/N) : ");
                String choice = input.next();

                income_tax_validate = mainMenu_validator(choice);
                clearConsole();
            }

        } while (income_tax_validate);
    }

    public static void incomeTax_Calculator(double annual_income) {
        double income_tax = 1;

        if (annual_income > 1200000) {
            if (annual_income > 1200000 & annual_income <= 1700000) {
                income_tax = (int) ((annual_income - 1200000) * 0.06);
                System.out.println("\nYou have to pay Income Tax per year : " + income_tax);

            } else if (annual_income > 1700000 & annual_income <= 2200000) {
                income_tax = (int) ((annual_income - 1700000) * 0.12) + (int) (500000 * 0.06);
                System.out.println("\nYou have to pay Income Tax per year : " + income_tax);

            } else if (annual_income > 2200000 & annual_income <= 2700000) {
                income_tax = (int) ((annual_income - 2200000) * 0.18) + (int) (500000 * 0.06)
                        + (int) (500000 * 0.12);
                System.out.println("\nYou have to pay Income Tax per year : " + income_tax);

            } else if (annual_income > 2700000 & annual_income <= 3200000) {
                income_tax = (int) ((annual_income - 2700000) * 0.24) + (int) (500000 * 0.06)
                        + (int) (500000 * 0.12) + (int) (500000 * 0.18);
                System.out.println("\nYou have to pay Income Tax per year : " + income_tax);

            } else if (annual_income > 3200000 & annual_income <= 3700000) {
                income_tax = (int) ((annual_income - 3200000) * 0.3) + (int) (500000 * 0.06)
                        + (int) (500000 * 0.12) + (int) (500000 * 0.18) + (int) (500000 * 0.24);
                System.out.println("\nYou have to pay Income Tax per year : " + income_tax);

            } else {
                income_tax = (int) ((annual_income - 3700000) * 0.36) + (int) (500000 * 0.06)
                        + (int) (500000 * 0.12) + (int) (500000 * 0.18) + (int) (500000 * 0.24)
                        + (int) (500000 * 0.3);
                System.out.println("\nYou have to pay Income Tax per year : " + income_tax);
            }
        } else {
            System.out.println("\n\tYou dont have to pay Income Tax...");
        }
    }
    // -------------------Income Tax Category------------------------------

    // -------------------SSCL Tax Category------------------------------
    public static void ssclTax() {
        Scanner input = new Scanner(System.in);
        boolean sscl_validate = false;

        do {
            System.out.println("\n\n+---------------------------------------------------------------+");
            System.out.println("|\tSocial Security Contribution Levy (SSCL) Tax\t\t|");
            System.out.println("+---------------------------------------------------------------+\n");

            System.out.print("Enter value of Good or Service : ");
            double value = input.nextDouble();

            if (value <= 0) {
                System.out.print(
                        "\n\tInvalid input...\n\nDo you want to enter the correct value again (Y/N) : ");
                String choice = input.next();

                sscl_validate = mainMenu_validator(choice);
                clearConsole();
            } else {
                double sales_tax = value * 0.025;

                double net_value = value + sales_tax;

                double sscl_tax = net_value * 0.15 + sales_tax;

                System.out.println("\nYou have to pay SSCL Tax       : " + sscl_tax);

                System.out.print("\n\nDo you want to calculate another SSCL Tax (Y/N) : ");
                String choice = input.next();

                sscl_validate = mainMenu_validator(choice);
                clearConsole();
            }
        } while (sscl_validate);
    }
    // -------------------SSCL Tax Category------------------------------

    // -------------------Leasing Category------------------------------
    public static void leasingPayment() {
        Scanner input = new Scanner(System.in);
        System.out.println("\n\n+---------------------------------------------------------------+");
        System.out.println("|\t\t\tLEASING PAYMENT\t\t\t\t|");
        System.out.println("+---------------------------------------------------------------+\n");

        System.out.println("\n\t[1] Calculate Monthly Installment");
        System.out.println("\n\t[2] Search Leasing Category");
        System.out.println("\n\t[3] Find Leasing Amount");
        System.out.println("\n\t[4] Exit");

        System.out.print("\n\nEnter an option to continue -> ");
        int lease_option = input.nextInt();

        switch (lease_option) {
            case 1:
                clearConsole();
                monthlyInstallment();
                break;

            case 2:
                clearConsole();
                leasingCategory();
                break;

            case 3:
                clearConsole();
                leasingAmount();
                break;

            case 4:
                clearConsole();
                mainMenu();
                return;

            default:
                System.out.println("\n\nINVALID INPUT... PLEASE CHECK AVAILABLE OPTIONS & RUN AGAIN");
                leasingPayment();

        }
    }

    private static void monthlyInstallment() {
        Scanner input = new Scanner(System.in);
        boolean lease_pay_validate = true;
        do {
            System.out.println(
                    "+-------------------------------------------------------------------------------+");
            System.out.println("|\t\t\tCALCULATE LEASING PAYMENT\t\t\t\t|");
            System.out.println(
                    "+-------------------------------------------------------------------------------+\n");

            boolean notValidAmount;
            double amount;
            do {
                notValidAmount = false;
                System.out.print("\nEnter lease amount         : ");
                amount = input.nextDouble();
                if (!(leasingPayment_validator(amount))) {
                    notValidAmount = true;
                    System.out.println("\n\tInvalid Amount... Enter the correct value again...");
                }
            } while (notValidAmount);

            boolean notValidrate;
            double rate;
            do {
                notValidrate = false;
                System.out.print("\nEnter annual interest rate : ");
                rate = input.nextDouble();
                if (!(leasingPayment_validator(rate))) {
                    notValidrate = true;
                    System.out
                            .println("\n\tInvalid Annual rate... Enter the correct value again...");
                }
            } while (notValidrate);
            double i = (rate / 12) / 100;

            boolean notValidYear;
            int years;
            do {
                notValidYear = false;
                System.out.print("\nEnter nummber of year      : ");
                years = input.nextInt();
                if (years > 5 | years <= 0) {
                    notValidYear = true;
                    System.out.println(
                            "\n\tInvalid Number of Year... Enter the correct value again...");
                }
            } while (notValidYear);
            int n = (int) (years * 12);

            double installment = amount * i / (1 - (1 / (Math.pow((1 + i), n))));

            System.out.print("\nYour monthly installment   : ");
            System.out.printf("%5.2f%n", installment);

            System.out.print("\n\nDo you want to calculate another Lease Payment (Y/N) : ");
            String choice = input.next();

            lease_pay_validate = mainMenu_validator(choice);
            clearConsole();
        } while (lease_pay_validate);
    }

    private static void leasingCategory() {
        Scanner input = new Scanner(System.in);
        boolean search_validate = true;
        do {
            System.out.println(
                    "+-------------------------------------------------------------------------------+");
            System.out.println("|\t\t\tSEARCH LEASING CATEGORY\t\t\t\t\t|");
            System.out.println(
                    "+-------------------------------------------------------------------------------+\n");

            boolean notaValidAmount;
            double lease_amount;
            do {
                notaValidAmount = false;
                System.out.print("Enter lease amount         : ");
                lease_amount = input.nextDouble();
                if (!(leasingPayment_validator(lease_amount))) {
                    notaValidAmount = true;
                    System.out.println("\n\tInvalid Amount... Enter the correct value again...");
                }
            } while (notaValidAmount);

            boolean notaValidrate;
            double annual_rate;
            do {
                notaValidrate = false;
                System.out.print("\nEnter annual interest rate : ");
                annual_rate = input.nextDouble();
                if (!(leasingPayment_validator(annual_rate))) {
                    notaValidrate = true;
                    System.out
                            .println("\n\tInvalid Annual rate... Enter the correct value again...");
                }
            } while (notaValidrate);
            double monthly_rate = (annual_rate / 12) / 100;

            double three_installment = lease_amount * monthly_rate
                    / (1 - (1 / (Math.pow((1 + monthly_rate), 36))));
            System.out.print("\nYour monthly installment for 3 year leasing plan - ");
            System.out.printf("%5.2f%n", three_installment);

            double four_installment = lease_amount * monthly_rate
                    / (1 - (1 / (Math.pow((1 + monthly_rate), 48))));
            System.out.print("Your monthly installment for 4 year leasing plan - ");
            System.out.printf("%5.2f%n", four_installment);

            double five_installment = lease_amount * monthly_rate
                    / (1 - (1 / (Math.pow((1 + monthly_rate), 60))));
            System.out.print("Your monthly installment for 5 year leasing plan - ");
            System.out.printf("%5.2f%n", five_installment);

            System.out.print("\n\nDo you want to search another Leasing Category (Y/N) : ");
            String choice = input.next();

            search_validate = mainMenu_validator(choice);
            clearConsole();

        } while (search_validate);
    }

    private static void leasingAmount() {
        Scanner input = new Scanner(System.in);
        boolean find_lease_validate = true;
        do {
            System.out.println(
                    "+-------------------------------------------------------------------------------+");
            System.out.println("|\t\t\t\tFIND LEASING AMOUNT\t\t\t\t|");
            System.out.println(
                    "+-------------------------------------------------------------------------------+\n");

            boolean isValidAmount;
            double monthly_pay;
            do {
                isValidAmount = true;
                System.out.print("\nEnter the monthly lease payment amount you can afford : ");
                monthly_pay = input.nextDouble();
                if (!(leasingPayment_validator(monthly_pay))) {
                    isValidAmount = false;
                    System.out.println("\n\tInvalid Amount... Enter the correct value again...");
                }
            } while (!isValidAmount);

            boolean isValidYear;
            double no_years;
            do {
                isValidYear = true;
                System.out.print("\nEnter nummber of year                                 : ");
                no_years = input.nextDouble();
                if (no_years > 5 | no_years <= 0) {
                    isValidYear = false;
                    System.out.println(
                            "\n\tInvalid Number of Year... Enter the correct value again...");
                }
            } while (!isValidYear);
            double no_months = (int) (no_years * 12);

            boolean isValidrate;
            double annum_rate;
            do {
                isValidrate = true;
                System.out.print("\nEnter annual interest rate                            : ");
                annum_rate = input.nextDouble();
                if (!(leasingPayment_validator(annum_rate))) {
                    isValidrate = false;
                    System.out
                            .println("\n\tInvalid Annual rate... Enter the correct value again...");
                }
            } while (!isValidrate);
            double month_rate = (annum_rate / 12) / 100;

            double possible_amount = (monthly_pay
                    * (1 - (1 / (Math.pow((1 + month_rate), no_months)))))
                    / month_rate;

            System.out.print("\nYou can get lease amount                              : ");
            System.out.printf("%5.0f.00", possible_amount);

            System.out.print("\n\nDo you want to find another Lease amount (Y/N) : ");
            String choice = input.next();

            find_lease_validate = mainMenu_validator(choice);
            clearConsole();
        } while (find_lease_validate);
    }
    // -------------------Leasing Category------------------------------

    // -------------------Common Utilities------------------------------

    public static boolean leasingPayment_validator(double x) {
        if (x <= 0) {
            return false;
        }
        return true;
    }

    public static boolean mainMenu_validator(String choice) {
        if (choice.equals("N")) {
            clearConsole();
            mainMenu();
            return false;
        }
        return true;
    }

    public final static void clearConsole() {
        try {
            final String os = System.getProperty("os.name");
            if (os.contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (final Exception e) {
            e.printStackTrace();
            // Handle any exceptions.
        }
    }

    /*
     * public static boolean inputValidator(double value) {
     * Scanner input = new Scanner(System.in);
     * if (value <= 0) {
     * System.out.print(
     * "\n\tInvalid input...\n\nDo you want to enter the correct value again (Y/N) : "
     * );
     * String choice = input.next();
     * 
     * if (choice.equals("N")) {
     * clearConsole();
     * mainMenu();
     * return false;
     * }
     * }
     * return true;
     * }
     */
    // -------------------Common Utilities------------------------------
}