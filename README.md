# Gestion de Vols MarocAir


Contexte du projet

Dans le Cadre de l’automatisation du système de réservation, la société MarocAir souhaite créer une application web qui va permettre la réservation des vols à ses client via un site responsive. Nous supposons que le client (code, nom, prénom, email, téléphone) accède à l’IHM réservation. Le client saisit la ville de départ/d’arrivé, l’heure départ /d’arrivé, la date de départ/Arrivé, et le nombre de places. Le système affiche une liste de propositions de vols sur le menu réservation, indiquant la description des vols. Si l’un des vols nécessite une escale, dans ce cas l’aéroport escale est affiché aussi. Le client choisit le vol qui lui intéresse, et il demande la réservation de celui-ci. Le système vérifie la disponibilité du vol. Si le vol est disponible, un message est affiché au client « la confirmation de la réservation sera complétée avec le paiement ».

​

FrontOffice:

Le client est ensuite redirigé vers la page de paiement.

Le client reçoit un email de confirmation de sa réservation avec les détails du vol choisi.

Le Système enregistre par la suite le détail de la réservation dans un fichier (txt)

Un Administrateur de la société SafiAir s’occupe de la gestion des vols (Crud)

Le client peut ajouter des extras à son vols( exemple: Assurance, Repas, Hôtel...)

la tarifications des vols est en MAD

une réducation de 15% s'applique pour les clients qui reservant aller/retour

le client peut modifer ou annuler sa réservation après la confirmation de son vol

dans le cas d'annulation: 8% des frais est retunue pour la société MarocAir

​

BackOffice:

Un responsable de réservation (déjà enregistré dans le système) prend en charge de la gestion des vols (Crud)

Le Responsable peut consulter les statistiques des réservations confirmées et annulées ( Mensuelles et annuelle)

NB : Un Vol ne doit pas dépasser 30 passagers

​

Travail à Faire :

• Réaliser une Application Web Java/JSP

• Maquetter les interfaces graphiques avec un outil de votre choix à l'aide aussi du HTML, CSS et JavaScript, EJS

• Proposez une base de données adéquate sous MySql/postgresql qui répond efficacement au cahier des charges

•Réaliser un fichier de gestion de projet sur Trello/Jira

• Réaliser le nombre de page selon votre choix à fin de garantir la procédure de réservation en ligne
