# Space Travel Booking App

Desktop application for booking travel to celestial bodies. 
Users can register, browse destinations and residential facilities, purchase tickets, and manage missions.

# Tech Stack
Java 11 + JavaFX 12 — UI
JDBC + MySQL — database access
Maven + Lombok — build & utilities

# Database (zus)

Tables: korisnik, nebeski_objekat, stambeni_objekat, karta, putovanje, misije, posed

# Setup
Import the database:
bashmysql -u your_user -p < "zus (1).sql"
Run the app:
bashmvn javafx:run

Milica Jocić & Anastasija Jovanović
