package Services;

import Models.Cliente;
import Utils.Utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;

public class ClienteService {
    private static List<Cliente> clienteList = new ArrayList<>();

    public boolean validateDocument(String dni){
      return clienteList.stream().anyMatch(o -> dni.equals(o.getNumeroDocumento()));
    }

    public void handlerMenuInsertCliente() {
        Cliente clientes = new Cliente(
                Utils.getTerminalValue("Inserte su DNI: "),
                Utils.getTerminalValue("Inserte sus nombres: "),
                Utils.getTerminalValue("Inserte sus apellidos: "),
                Utils.getTerminalValue("Inserte su numero de contacto: "),
                Utils.getTerminalValue("Inserte su direccion: ")
        );

        if(insertCliente(clientes))
            System.out.println("Se ha insertado el cliente");
        else
            System.out.println("No se ha podido insertar el cliente ya que ya existe en nuestra base de datos.");
    }

    public void handlerMenuShowCliente() {
        clienteList.forEach(clientes -> {
            System.out.println("Nombres: " + clientes.getNombre());
            System.out.println("Apellidos: " + clientes.getApellido());
            System.out.println("Celular: " + clientes.getNumeroContacto());
            System.out.println("Dirección: " + clientes.getDireccion());
            System.out.println("DNI: " + clientes.getNumeroDocumento() + "\n");
        });

        Utils.getTerminalValue("\nEnter para continuar...");
    }

    public boolean insertCliente(Cliente cliente) {
        AtomicBoolean insert = new AtomicBoolean(true);

        clienteList.forEach(user -> {
            if(Objects.equals(user.getNumeroDocumento(), cliente.getNumeroDocumento())) insert.set(false);
        });

        if (insert.get()) clienteList.add(cliente);

        return insert.get();
    }

    public List<Cliente> getAllCliente() {
        return clienteList;
    }
}
