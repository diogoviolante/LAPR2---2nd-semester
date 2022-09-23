package app.ui.console;
import app.ui.console.utils.Utils;

        import java.util.ArrayList;
        import java.util.List;

/*
 *
 * @author Paulo Maio <pam@isep.ipp.pt>
 */

public class LabCoordinatorUI implements Runnable{
    public LabCoordinatorUI(){
    }

    public void run()
    {
        List<MenuItem> options = new ArrayList<MenuItem>();
        options.add(new MenuItem("Validate Tests",  new LabValidationUI()));
        options.add(new MenuItem("Import files",new CVSfilesUI()));
        options.add(new MenuItem("Check Company's performance", new PerformanceUI()));

        int option = 0;
        do
        {
            option = Utils.showAndSelectIndex(options, "\n\nLaboratory Coordinator Menu:");

            if ( (option >= 0) && (option < options.size()))
            {
                options.get(option).run();
            }
        }
        while (option != -1 );


    }
}
