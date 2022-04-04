# Mitarbeiterverwaltung_BOS
Projekt [Marcel, Matej, André, Samy]

Planung:
-----------------------------

einloggen/registrieren/abbrechen

[einloggen:]

- überprüfung, ob name vergeben (verfügbarkeitsüberprüfung auslagern)
- optionen:
        - einstempeln / ausstempeln
                -> einstempeln: zeitmessung-start
                -> ausstempeln: zeitmessung-ende
        - abrufen
        - ausloggen

[registrieren:]

- name eingeben (überprüfung verfügbarkeit) -> loop
- "ist dieser korrekt?" (ja/nein) -> loop
- profilerstellung mit namen
- fulltime/parttime/minijob
- "zurück" option

--------------------------------

--> bei ausloggen profil speichern!



[Klassen]
- Main

- User
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
        
        
        
        
        
        
