# Projet rent manager

## Lancement du projet
Pour lancer le projet : `mvn tomcat7:run` parfois `sudo mvn tomcat7:run` 
Pour stopper le projet : `mvn tomcat7:shutdown`
Ensuite ouvrir le l'adresse `localhost:8000/rentmanager` dans votre navigateur web
## Points fonctionnels
- Opérations type **CRUD** complète sur les clients
- Opérations type **CRUD** complète sur les véhicules
- Opérations type **CRD** sur les réservations pas de **Update**...
- Un client n'ayant pas 18ans ne peut pas être créé (JS : fonction event listener sur l'input)
- Le nom et le prénom d'un client doivent faire au moins 3 caractères (HTML : attributs)
- Si un client ou un véhicule est supprimé, alors il faut supprimer les
réservations associées (SQL : ONDELETE CASCADE)
- une voiture doit avoir un modèle et un constructeur, son nombre de place doit
être compris entre 2 et 9 (HTML : attributs)
- Une voiture ne peux pas être réservé plus de 7 jours de suite par le même
utilisateur (JS : fonction event listener sur l'input)
- Un client ayant une adresse mail déjà prise ne peut pas être créé (JS : fonction qui check les adresses mails)
## Points non réussis
- Une voiture ne peux pas être réservé 2 fois le même jour
- Une voiture ne peux pas être réservé 30 jours de suite sans pause

## Commandes utilisées pendant le projets *(ne pas les utiliser ici)*
To init the project : `mvn archetype:generate -DarchetypeGroupId=org.apache.maven.archetypes -DarchetypeArtifactId=maven-archetype-simple -DgroupId=epf -DartifactId=rentmanager`

To compile the project : `mvn clean install exec:java`


