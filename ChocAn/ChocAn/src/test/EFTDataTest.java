package test;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import reportController.eftReportController.EFTData;
import service.serviceProvidedPackage.serviceProvidedList.ServiceProvidedList;

public class EFTDataTest {

    private ServiceProvidedList serviceProvidedList = new ServiceProvidedList();

    @Test
    public void testEFTDataConstructor() {
        try {
            EFTData eftController = new EFTData(this.serviceProvidedList, this.serviceProvidedList.getWeeklyProviders());
        } catch (Exception e) {
            System.out.println("Constructor doesn't work fool");
        }
    }

    @Test
    public void testEFTDataCanCreateFile() {
        EFTData eftController = new EFTData(this.serviceProvidedList, this.serviceProvidedList.getWeeklyProviders());

        eftController.writeToTxtFile("testing_file.txt");
    }
}
