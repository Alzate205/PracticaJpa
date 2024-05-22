package org.example.ejecutables;

import jakarta.persistence.EntityManager;
import org.example.Cliente;
import org.example.utils.JpaUtil;
import java.util.List;


public class HibernateListar {
    public static void main(String[] args) {
        EntityManager em = JpaUtil.getEntityManager();
        List<Cliente> clientes = em.createQuery("select c from org.example.Cliente c",
                Cliente.class).getResultList();
        clientes.forEach(System.out::println);
        em.close();
    }
}

