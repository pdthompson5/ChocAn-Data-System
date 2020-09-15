
/**
 * Verify Member Status use case
 */
import java.util.Scanner; // Import the Scanner class

public class VerifyMemberStatus {
    String verificationResult;

    public VerifyMemberStatus(String memberNumber) {
        verificationResult = verifyMemberNumber(memberNumber);
    }

    public String getVerificationResult() {
        return this.verificationResult;
    }

    private static String verifyMemberNumber(String memberNumber) {
        // Given a member number, check if the member is valid or not
        String validMember = "Validated";
        String invalidMember = "Invalid or Suspended";

        // Dial the ChocAn database (hardcoding to validMember)
        String chocAnResult = validMember;
        if (chocAnResult == validMember) {
            System.out.println(validMember);
        } else {
            System.out.println(invalidMember);
        }

        return validMember;
    }

}