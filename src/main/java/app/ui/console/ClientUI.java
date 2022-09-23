package app.ui.console;

import app.ui.console.utils.Utils;
import auth.UserSession;
import auth.domain.model.Email;

import java.util.ArrayList;
import java.util.List;

public class ClientUI implements Runnable {

    @Override
    public void run() {

        List<MenuItem> options = new ArrayList<MenuItem>();
        options.add(new MenuItem("Check my results.", new CheckResultsUI()));
        options.add(new MenuItem("Update my personal data.", new UpdateDataUI()));
        int option = 0;
        do {
            option = Utils.showAndSelectIndex(options, "\n\nClient Menu");

            if ((option >= 0) && (option < options.size())) {
                options.get(option).run();
            }
        }
        while (option != -1);
    }
}
