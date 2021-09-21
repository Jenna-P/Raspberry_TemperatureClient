# Raspberry PI 
*  Bunden forudsætning Teknologi og Programmering
*  Daniella (ellamusen), Mikkel A. (TheProphet4000), Jenna (Jenna-P) og Sara (sasaje)

## Overvejelser over implementeringsstrategi
1. Vi startede med at undersøge dokumentation for DHT11 sensoren. 
2. Så konfigurerede vi Raspberry PI'en til at køre Rasparian. 
3. Så oprettede vi det trådløse netværk forbindelse til ssh (opsætning af ssh til etablering af forbindelsen). 
4. Oprettede python fil mydht.py, som skal agere serverdelen på vores Raspberry Pi. 
5. Overstående virker på serveren (kan ses via terminalen kommandoen - python3 mydht.py).  
6. Så gjorde vi det muligt at sende data fra server(raspberry pi'en) til clienten(vores computere) via oprettelsen af en socket forbindelse fra serverdelen. 
7. Vi har etableret muligheden at sende data (her en String) fra server til clienten. 
8. Næste trin vil være, at sende temperatur og luftfugtigheds data videre (bytes) til clienten. (vi er nået hertil, men er stødt på nogle udfordringer it. encoding/decoding delen. 
9. Det sidste, som vi mangler er at den overførste data afspejles på et line chart via javafx.
 
## Valg af protokol(ler)
TCP (beskriv hvorfor dette er et godt valg)
Vi anvender TCP protokollen fordi denne protokol sikre at alt vores data sendes.
Denne forsikre sig mod at der sker et datatab, idet der er en "godkendelses" process som hedder et three-way-handshake.
Dette vil sige, at der ______________.
 
## Konklusion på udviklingsarbejdet
*  Herunder beskrivelse af mangler
   *  Vi mangler, at sende de indsamlede data fra Raspberry'en videre til clienten. Vi har fået den til at sende en fastlagt String. Men stødte ind i nogle problemer undervejs i denne process, som har sænket os ift afleveringsfristen. 
      
*  Forslag til forbedringer og nye features
   *  Det kunne være nice-to-have at vores javafx graf afspejlede begge grafer i ét diagram. På baggrund af at der var forskellige y-akse-skalaer, har det for os ikke været muligt at merge dem sammen i det samme line chart. 
   *  En anden feature, som kunne være virkelig god at have med er en liveopdatere line chart, så den lige så snart at den modtager nyt data fra serverside, kunne opdatere og afspejles i vores client line chart. 
