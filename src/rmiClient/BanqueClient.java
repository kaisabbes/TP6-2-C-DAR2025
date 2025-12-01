package rmiClient;

import metier.Compte;
import rmiService.IBanque;

import javax.naming.Context;
import javax.naming.InitialContext;
import java.util.Hashtable;

public class BanqueClient {
    public static void main(String[] args) {
        try {
            // Configuration JNDI
            Hashtable<String, String> env = new Hashtable<>();
            env.put(Context.INITIAL_CONTEXT_FACTORY,
                    "com.sun.jndi.rmi.registry.RegistryContextFactory");
            env.put(Context.PROVIDER_URL, "rmi://localhost:1099");

            // Chargement du contexte
            Context context = new InitialContext(env);

            // Lookup via JNDI (nom simple)
            IBanque banque = (IBanque) context.lookup("Banque");

            System.out.println(">>> Connexion réussie au service Banque");

            // Test : création de compte
            //Compte c = new Compte(2, 2500.0);
            //System.out.println(banque.creerCompte(c));
            Compte c2 = new Compte(2, 2500.0);
            System.out.println(banque.creerCompte(c2));

            // Test : récupération
            System.out.println(banque.getInfoCompte(1));
            System.out.println(banque.getInfoCompte(2));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
