package Services;

import Models.Automovil;
import Utils.Utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;

public class AutomovilService {
    private static List<Automovil> automovilList = new ArrayList<>();

    public boolean validatePlaca(String placa){
      return automovilList.stream().anyMatch(o -> placa.equals(o.getPlaca()));
    }

    public void handlerMenuInsertAutomovil() {
        Automovil automovil = new Automovil(
                Utils.getTerminalValue("Inserte la marca: "),
                Utils.getTerminalValue("Inserte la linea: "),
                Utils.getTerminalValue("Inserte la placa: "),
                Utils.getTerminalValue("Inserte el estado: ")
        );

        if(insertAutomovil(automovil))
            System.out.println("Se ha insertado el automovil");
        else
            System.out.println("No se ha poido insertar el automovils");
    }

    public void handlerMenuShowAutomovil() {
        automovilList.forEach(automovil -> {
            System.out.println("Marca: " + automovil.getMarca());
            System.out.println("Linea: " + automovil.getLinea());
            System.out.println("Placa: " + automovil.getPlaca());
            System.out.println("Estado: " + automovil.getEstado() + "\n");
        });

        Utils.getTerminalValue("\nEnter para continuar...");
    }

    public boolean insertAutomovil(Automovil automovil) {
        AtomicBoolean insert = new AtomicBoolean(true);

        automovilList.forEach(auto -> {
            if(Objects.equals(auto.getPlaca(), automovil.getPlaca())) insert.set(false);
        });

        if (insert.get()) automovilList.add(automovil);

        return insert.get();
    }

    public List<Automovil> getAllAutomovil() {
        return automovilList;
    }
}
