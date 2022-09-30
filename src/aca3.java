import Services.AutomovilService;
import Services.ClienteService;
import Services.AlquilerService;
import Utils.Utils;

public class aca3 {
    public static void main(String[] args) {
        int option;
        do {
            option = Utils.optionMenu();

            switch (option) {
                case 1 -> new AutomovilService().handlerMenuInsertAutomovil();
                case 2 -> new ClienteService().handlerMenuInsertCliente();
                case 3 -> new AlquilerService().handlerMenuInsertAlquiler();
                case 4 -> new AutomovilService().handlerMenuShowAutomovil();
                case 5 -> new ClienteService().handlerMenuShowCliente();
                case 6 -> new AlquilerService().handlerMenuShowAlquiler();
                case 7 -> new AlquilerService().handlerMenuShowClientRented();
            }
        } while (option != 8);
    }
}
