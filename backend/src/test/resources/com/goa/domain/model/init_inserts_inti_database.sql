CREATE TABLE anforderungen (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL
);

INSERT INTO anforderungen (name) VALUES
    ('Compilerbau'),
    ('Programmierung'),
    ('Rechnerarchitektur'),
    ('Algorithmen und Datenstrukturen');

INSERT INTO betreuer (name, email) VALUES
    ('Anna Schmidt','anna.schmidt@test.de'),
    ('Ben Müller','ben.mueller@test.de'),
    ('Clara Weber','clara.weber@test.de'),
    ('David Fischer','david.fischer@test.de'),
    ('Eva Wagner','eva.wagner@test.de'),
    ('Frank Becker','frank.becker@test.de'),
    ('Gina Hoffmann','gina.hoffmann@test.de'),
    ('Henry Neumann','henry.neumann@test.de'),
    ('Iris König','iris.koenig@test.de'),
    ('Jonas Braun','jonas.braun@test.de'),
    ('Klara Schmitz','klara.schmitz@test.de'),
    ('Lukas Wolf','lukas.wolf@test.de'),
    ('Mara Richter','mara.richter@test.de'),
    ('Nico Lange','nico.lange@test.de'),
    ('Olga Peters','olga.peters@test.de'),
    ('Paul Jung','paul.jung@test.de'),
    ('Quirin Busch','quirin.busch@test.de'),
    ('Rita Keller','rita.keller@test.de'),
    ('Stefan Frank','stefan.frank@test.de'),
    ('Tina Zimmer','tina.zimmer@test.de');

-- Fachgebiete der Betreuer
INSERT INTO betreuer_fachgebiete VALUES
    (1,'Programmierung'),(1,'Compilerbau'),
    (2,'Rechnerarchitektur'),(2,'Algorithmen'),
    (3,'Programmierung'),
    (4,'Compilerbau'),
    (5,'Algorithmen'),(5,'Datenbanken'),
    (6,'Rechnerarchitektur'),
    (7,'Programmierung'),(7,'Webentwicklung'),
    (8,'Datenbanken'),
    (9,'Webentwicklung'),
    (10,'Compilerbau'),
    (11,'Algorithmen'),
    (12,'Rechnerarchitektur'),
    (13,'Programmierung'),(13,'Algorithmen'),
    (14,'Compilerbau'),
    (15,'Datenbanken'),
    (16,'Webentwicklung'),
    (17,'Programmierung'),
    (18,'Algorithmen'),
    (19,'Compilerbau'),
    (20,'Rechnerarchitektur');

-- ========================================
-- Beispieldaten: Themen
-- ========================================

INSERT INTO thema (titel, beschreibung) VALUES
    ('KI in der Medizin','Analyse von Patientendaten mittels KI'),
    ('Blockchain Anwendungen','Blockchain in Supply Chains'),
    ('Compiler Optimierung','Optimierung von Compiler Pipelines'),
    ('Webentwicklung mit React','Moderne Webapps mit React'),
    ('Datenbanksysteme','SQL vs NoSQL'),
    ('Parallelprogrammierung','Multithreading Konzepte'),
    ('Rechnerarchitektur Grundlagen','CPU Aufbau und Pipelines'),
    ('Programmiersprachenvergleich','Vergleich zwischen Java, Python und C++'),
    ('Algorithmen Analyse','Komplexität von Such- und Sortieralgorithmen'),
    ('Software Testing','Automatisierte Tests'),
    ('Machine Learning Projekte','ML Modelle implementieren'),
    ('IT-Sicherheit','Verschlüsselungstechniken'),
    ('Cloud Computing','AWS und Azure Grundlagen'),
    ('Big Data Analytics','Hadoop und Spark'),
    ('Mobile Entwicklung','Apps für Android und iOS'),
    ('Embedded Systeme','Mikrocontroller programmieren'),
    ('Internet der Dinge','IoT Geräte verbinden'),
    ('DevOps Prozesse','CI/CD Pipelines implementieren'),
    ('Spielentwicklung','2D und 3D Spiele mit Unity'),
    ('Graphentheorie','Algorithmen auf Graphen anwenden');

-- Fachgebiete zu Themen
INSERT INTO thema_dto_fachgebiete VALUES
    (1,'KI'),(2,'Blockchain'),(3,'Compilerbau'),(4,'Webentwicklung'),
    (5,'Datenbanken'),(6,'Programmierung'),(7,'Rechnerarchitektur'),
    (8,'Programmierung'),(9,'Algorithmen'),(10,'Testing'),
    (11,'ML'),(12,'IT-Sicherheit'),(13,'Cloud'),(14,'Big Data'),
    (15,'Mobile'),(16,'Embedded'),(17,'IoT'),(18,'DevOps'),
    (19,'Spielentwicklung'),(20,'Graphentheorie');

-- Themen <-> Veranstaltungen
INSERT INTO thema_anforderungen VALUES
    (1,2),(2,2),(3,1),(4,2),(5,4),
    (6,2),(7,3),(8,2),(9,4),(10,2),
    (11,2),(12,2),(13,2),(14,4),(15,2),
    (16,3),(17,2),(18,2),(19,2),(20,4);

-- ========================================
-- Beispieldaten: Dateien
-- ========================================

INSERT INTO datei (daten, datei_uploader, upload_datum, titel, beschreibung) VALUES
    (X'48656C6C6F','Anna Schmidt', CURRENT_TIMESTAMP,'Intro KI','Grundlagen der KI'),
    (X'48656C6C6F','Ben Müller', CURRENT_TIMESTAMP,'Blockchain Tutorial','Blockchain Einführung'),
    (X'48656C6C6F','Clara Weber', CURRENT_TIMESTAMP,'Compiler Optimierung',''),
    (X'48656C6C6F','David Fischer', CURRENT_TIMESTAMP,'React Guide','Webentwicklung mit React'),
    (X'48656C6C6F','Eva Wagner', CURRENT_TIMESTAMP,'SQL vs NoSQL','Datenbankvergleich');

-- Verknüpfung Thema-Datei
INSERT INTO thema_dateien VALUES
    (1,1),(2,2),(3,3),(4,4),(5,5);

-- Verknüpfung Betreuer-Datei
INSERT INTO betreuer_datei VALUES
    (1,1),(2,2),(3,3),(4,4),(5,5);

-- ========================================
-- Beispieldaten: Links
-- ========================================

INSERT INTO link (url, text) VALUES
    ('https://ki.example.com','KI Ressource'),
    ('https://blockchain.example.com','Blockchain'),
    ('https://compiler.example.com','Compilerbau Tutorial'),
    ('https://react.example.com','React Guide'),
    ('https://sql.example.com','SQL Tutorial');

-- Verknüpfung Thema-Link
INSERT INTO thema_links VALUES
    (1,1),(2,2),(3,3),(4,4),(5,5);

-- ========================================
-- Verknüpfung Betreuer-Thema
-- ========================================

INSERT INTO betreuer_thema VALUES
    (1,1),(2,2),(3,3),(4,4),(5,5),
    (6,6),(7,7),(8,8),(9,9),(10,10),
    (11,11),(12,12),(13,13),(14,14),(15,15),
    (16,16),(17,17),(18,18),(19,19),(20,20);