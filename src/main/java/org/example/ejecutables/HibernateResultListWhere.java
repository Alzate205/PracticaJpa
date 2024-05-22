package org.example.ejecutables;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.example.Cliente;
import org.example.utils.JpaUtil;
import java.util.List;
import java.util.Scanner;

public class HibernateResultListWhere {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        EntityManager em = JpaUtil.getEntityManager();
        Query query = em.createQuery("select c from org.example.Cliente c where c.formaPago=?1", org.example.Cliente.class);
        System.out.println("Ingrese una forma de pago: ");
        String pago = s.next();
        query.setParameter(1, pago);
        List<Cliente> clientes = query.getResultList();
        System.out.println(clientes);
        em.close();
    }
}