package org.example.ejecutables;

import jakarta.persistence.EntityManager;
import org.example.Cliente;
import org.example.utils.JpaUtil;

import java.util.Scanner;

public class HibernateEditar {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        System.out.println("Ingrese el id que quiere editar: ");
        Long id = s.nextLong();
        s.nextLine(); // Consumir la nueva línea pendiente después de nextLong()

        EntityManager em = JpaUtil.getEntityManager();
        try {
            Cliente cliente = em.find(Cliente.class, id);
            if (cliente == null) {
                System.out.println("Cliente no encontrado");
                return;
            }
            System.out.println("Cliente encontrado: " + cliente);

            System.out.println("Ingrese el nombre:");
            String nombre = s.nextLine();
            System.out.println("Nombre ingresado: " + nombre);

            System.out.println("Ingrese el apellido:");
            String apellido = s.nextLine();
            System.out.println("Apellido ingresado: " + apellido);

            System.out.println("Ingrese la forma de pago:");
            String pago = s.nextLine();
            System.out.println("Forma de pago ingresada: " + pago);

            em.getTransaction().begin();
            cliente.setNombre(nombre);
            cliente.setApellido(apellido);
            cliente.setFormaPago(pago);
            em.getTransaction().commit();

            System.out.println("El cliente quedó registrado como Id: " + cliente.getId() +
                    ", Nombre: " + cliente.getNombre() +
                    ", Apellido: " + cliente.getApellido() +
                    ", Forma de pago: " + cliente.getFormaPago() + " Gracias");
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            e.printStackTrace();
        } finally {
            em.close();
        }
    }
}

