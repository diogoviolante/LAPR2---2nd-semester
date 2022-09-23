package app.ui.console;

import app.ui.console.utils.Utils;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Paulo Maio <pam@isep.ipp.pt>
 */

public class AdminUI implements Runnable{
    public AdminUI()
    {
    }

    public void run()
    {
        List<MenuItem> options = new ArrayList<MenuItem>();
        options.add(new MenuItem("Create New Test Type ", new NewTestUI()));
        options.add(new MenuItem("Register a new Parameter Category", new CreateParameterCategoryUI()));
        options.add(new MenuItem("Create new Clinical Analysis Laboratory", new CreateClinicalAnalysisLabUI()));
        options.add(new MenuItem("Register Employee ", new RegisterEmployeeUI()));
        options.add(new MenuItem("Create Parameter",new ParameterUI()));
        int option = 0;
        do
        {
            option = Utils.showAndSelectIndex(options, "\n\nAdmin Menu:");

            if ( (option >= 0) && (option < options.size()))
            {
                options.get(option).run();
            }
        }
        while (option != -1 );


    }
}
