/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java_prg_03_13_internet_service_provider;

import javax.swing.JOptionPane;
/**
 *
 * @author bluebackdev
 * An Internet service provider has three different subscription packages for
 * its customers:
 * 
 *      Package A:      For $9.95 per month 10 hours of access are provided.
 *                      Additional hours are $2.00 per hour.
 *      Package B:      For $13.95 per month 20 hours of access are provided.
 *                      Additional hours are $1.00 per hours.
 *      Package C:      For $19.95 per month unlimited access is provided.
 * 
 * Write a program that calculates a customer's monthly bill. It should ask the
 * user to enter the letter of the package the customer has purchased
 * (A, B, or C) and the number of hours that were used. It should then display
 * the total charges.
 */
public class JAVA_PRG_03_13_Internet_Service_Provider {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // String to hold user inputs and formatted values
        String strUserPackage;
        String strUserHours;
        String strFormattedOutput;
        
        // Declare constant floats for package rates
        // and data overage charges
        final float FLT_PACKAGE_CHARGE_A = 9.95f;
        final float FLT_PACKAGE_OVERAGE_A = 2.0f;
        final float FLT_PACKAGE_HOURS_A = 10.0f;
        final float FLT_PACKAGE_CHARGE_B = 13.95f;
        final float FLT_PACKAGE_OVERAGE_B = 1.0f;
        final float FLT_PACKAGE_HOURS_B = 20.0f;
        final float FLT_PACKAGE_CHARGE_C = 19.95f;
                
        
        // Declare float to hold converted user input
        // for hours and calculated cost, initialize
        // fltCalculatedTotal to avoid squiggly lines
        // when formatting output message at end of program
        float fltUserHours;
        float fltCalculatedTotal = 0.0f;
        
        // Get package and hours from user
        strUserPackage = JOptionPane.showInputDialog("Please enter which plan\n"
            + "you are subscribed to (A, B, or C).");
        strUserHours = JOptionPane.showInputDialog("Please enter the total number\n"
            + "of hours you used this month.");
        
        // Convert hours to float value
        fltUserHours = Float.parseFloat(strUserHours);
        
        // Convert package selection to lower case for switch statement
        strUserPackage = strUserPackage.toLowerCase();
        
        
        switch(strUserPackage)
        {
            case "a":
                if(fltUserHours <= FLT_PACKAGE_HOURS_A && fltUserHours > 0)
                {
                    fltCalculatedTotal = FLT_PACKAGE_CHARGE_A;
                }
                else if(fltUserHours > 10)
                {
                    fltCalculatedTotal = FLT_PACKAGE_OVERAGE_A * (fltUserHours
                            - FLT_PACKAGE_HOURS_A) + FLT_PACKAGE_CHARGE_A;
                }
                else if(fltUserHours <= 0)
                {
                    JOptionPane.showMessageDialog(null, "Please enter a number\n"
                        + "of hours greater than 0.");
                    System.exit(0);
                }
                break;
            case "b":
                if(fltUserHours <= FLT_PACKAGE_HOURS_B && fltUserHours > 0)
                {
                    fltCalculatedTotal = FLT_PACKAGE_CHARGE_B;
                }
                else if(fltUserHours > 10)
                {
                    fltCalculatedTotal = FLT_PACKAGE_OVERAGE_B * (fltUserHours
                            - FLT_PACKAGE_HOURS_B) + FLT_PACKAGE_CHARGE_B;
                }
                else if(fltUserHours <= 0)
                {
                    JOptionPane.showMessageDialog(null, "Please enter a number\n"
                        + "of hours greater than 0.");
                    System.exit(0);
                }
                break;
            case "c":
                fltCalculatedTotal = FLT_PACKAGE_CHARGE_C;
                break;
            default:
                JOptionPane.showMessageDialog(null, "ERROR CALCULATING TOTAL");
                System.exit(0);
                break;
        }
        
        // Convert back to uppercase for output to console
        strUserPackage = strUserPackage.toUpperCase();
        
        // Format a string and numbers for output to the user
        strFormattedOutput = String.format("Using %.1f hours on Package " + strUserPackage
            + " cost $%.2f.", fltUserHours, fltCalculatedTotal);
        
        // Display formatted string to the user
        JOptionPane.showMessageDialog(null, strFormattedOutput);
        
        // For JOptionPane
        System.exit(0);
    }
    
}
