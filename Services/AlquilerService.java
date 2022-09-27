package Services;

import Models.Alquiler;
import Utils.Utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.time.LocalDateTime;
import java.util.concurrent.atomic.AtomicBoolean;

public class AlquilerService {
    private static List<Alquiler> alquilerList = new ArrayList<>();

    public void handlerMenuInsertAlquiler() {
        LocalDateTime fecha = LocalDateTime.now();
        Alquiler alquiler = new Alquiler(
                Utils.getTerminalValue("Inserte su numero de documento: "),
                Utils.getTerminalValue("Inserte su placa: "),
                fecha,
                Utils.getTerminalValue("Inserte los días que fue alquilado: ")
        );

        if(insertAlquiler(alquiler))
            System.out.println("Se ha insertado el automovil");
        else
            System.out.println("No se ha poido insertar el alquiler porque no existe el DNI o la placa del auto.");
    }

    public void handlerMenuShowAlquiler() {
        alquilerList.forEach(alquiler -> {
            System.out.println("Numero de documento: " + alquiler.getDocumentoCliente());
            System.out.println("Placa: " + alquiler.getPlacaAutomovil());
            System.out.println("Fecha: " + alquiler.getFecha());
            System.out.println("Días: " + alquiler.getDias() + "\n");
        });

        Utils.getTerminalValue("\nEnter para continuar...");
    }

    public void handlerMenuShowClientRented() {
      String documento = Utils.getTerminalValue("Inserte el documento del cliente que quiere ver sus alquileres: ");
      AtomicBoolean existe = new AtomicBoolean(true);
      alquilerList.forEach(alquilar -> {
        if (Objects.equals(alquilar.getDocumentoCliente(), documento))
           System.out.println("\n\nNumero de documento: " + alquilar.getDocumentoCliente());
           System.out.println("Placa: " + alquilar.getPlacaAutomovil());
           System.out.println("Fecha: " + alquilar.getFecha());
           System.out.println("Días: " + alquilar.getDias() + "\n");
           existe.set(false);
      });

      if (existe.get()) Utils.getTerminalValue("\nEl usuario no esta regitrado en ningun alquiler...");
    }

    public boolean insertAlquiler(Alquiler alquilado) {
        AtomicBoolean insert = new AtomicBoolean(false);

        alquilerList.forEach(alquilar-> {
            if(AutomovilService().validatePlaca(alquilar.getDocumentoCliente) &&
               ClienteService().validatePlaca(alquilar.getDocumentoCliente)) insert.set(true);
        });

        if (insert.get()) alquilerList.add(alquilado);

        return insert.get();
    }

    public List<Alquiler> getAllAutomovil() {
        return alquilerList;
    }
}
