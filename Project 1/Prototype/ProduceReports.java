import java.text.SimpleDateFormat;
import java.util.Date;

public class ProduceReports {
    //This variable acts as our file right now
    String report;

    public ProduceReports() {
        report = "";
    }

    public Integer produceBillingReport(String memberNumber, String dateOfService, String serviceCode,
            String serviceComments) {
        // grab the current date and time
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date();
        String currentDate = formatter.format(date);

        // Create a record and save it to a file
        String serviceRecord = "Current date and time: " + currentDate + "\n";
        serviceRecord += "Date service was provided: " + dateOfService + "\n";
        serviceRecord += "Provider number: " + "notImplemented.." + "\n";
        serviceRecord += "Member number: " + memberNumber + "\n";
        serviceRecord += "Service code: " + serviceCode + "\n";
        serviceRecord += "Comments: " + serviceComments + "\n";

        this.report = serviceRecord;

        System.out.println("Saving billing report to a file");
        System.out.println(this.report);
        return 0;
    }

    public String getReport() {
        return this.report;
    }
}