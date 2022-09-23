package app.ui.console;

/**
 *
 * @author Paulo Maio <pam@isep.ipp.pt>
 */
public class DevTeamUI implements Runnable{

    public DevTeamUI()
    {

    }
    public void run()
    {
        System.out.println("\n");
        System.out.printf("Development Team:\n");
        System.out.printf("\t Pedro Sousa - 1201428@isep.ipp.pt \n");
        System.out.printf("\t Diogo Violante - 1201284@isep.ipp.pt \n");
        System.out.printf("\t Gonçalo Teixeira - 1200882@isep.ipp.pt \n");
        System.out.printf("\t João Oliveira - 1201183@isep.ipp.pt \n");
        System.out.println("\n");
    }
}
