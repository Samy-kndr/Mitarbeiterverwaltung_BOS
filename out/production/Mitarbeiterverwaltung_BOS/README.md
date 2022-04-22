# Mitarbeiterverwaltung_BOS
Projekt [Marcel, Matej, André, Samy]

Planung:
-----------------------------


Designs / Abbildungen ---> 1) Matej, 2) André

einloggen/registrieren/abbrechen

[einloggen:]   ---> 1) André, 2) Matej

- überprüfung, ob name vergeben (verfügbarkeitsüberprüfung auslagern)
- optionen:
        - einstempeln / ausstempeln
                -> einstempeln: zeitmessung-start
                -> ausstempeln: zeitmessung-ende
        - abrufen
        - ausloggen

[registrieren:]   ---> 1) Samy, 2) Marcel

- name eingeben (überprüfung verfügbarkeit) -> loop
- "ist dieser korrekt?" (ja/nein) -> loop
- profilerstellung mit namen
- fulltime/parttime/minijob
- "zurück" option

--------------------------------

--> bei ausloggen profil speichern!



[Klassen]
- Main

- User   ---> 1) Marcel , 2) Samy
        -> name
        -> workingHours (fulltime, parttime, minijob)
        -> clockInTime
        -> clockOutTime
        -> overHours
        -> (isAlreadyClockedIn() ?)


(todo when still time:)
        - Urlaubstage / Urlaubsantrag
        - Beschwerden / Fehler
        - verschiedene userarten
        - Arbeitsunfälle
        - isAlreadyLoggedIn()
        
        
        
        
        
        
