package app.ui.console;

import app.ui.console.utils.Utils;

import java.util.ArrayList;
import java.util.List;

public class SpecialistDoctorUI implements Runnable{




        private Long lab = 0L;

        @Override
        public void run()
        {
            System.out.println();

       /* if (lab== 0L) {
            System.out.println("Insert the Laboratory ID of your place of work!");

        } else {

        */
            List<MenuItem> options = new ArrayList<MenuItem>();
            options.add(new MenuItem("Do a test report", new DiagnosisUI()));

            int option = 0;
            do
            {
                option = Utils.showAndSelectIndex(options, "\n\nSpecialist Doctor Menu");

                if ( (option >= 0) && (option < options.size()))
                {
                    options.get(option).run();
                }
            }
            while (option != -1 );
            //}

        }
    }


