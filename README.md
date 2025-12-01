This module implements the RMI server for the Banque application. 

It starts the RMI registry on port 1099, creates the remote banking service, and registers it via JNDI under the name "Banque".

Run BanqueServer first to make the remote service available to clients.
