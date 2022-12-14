package app.ui.console;

import app.ui.console.utils.Utils;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Paulo Maio <pam@isep.ipp.pt>
 */

public class ClinicalChemistryTechnologistUI implements Runnable{


    public void run()
    {
        List<MenuItem> options = new ArrayList<MenuItem>();
        options.add(new MenuItem("Check Client's History ", new ConsultHistoryUI()));
        options.add(new MenuItem("Registers Result", new RegisterResultUI()));
        int option = 0;
        do
        {
            option = Utils.showAndSelectIndex(options, "\n\n Clinical Chemistry Technologist Menu:");

            if ( (option >= 0) && (option < options.size()))
            {
                options.get(option).run();
            }
        }
        while (option != -1 );


    }
}
