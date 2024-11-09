# Pokemon

## Feladat
Mobil Applikáció implementálása/létrehozása Android platformra, Kotlin nyelven.
Pokémon listázó app létrehozása, minden egyes Pokémonnak legyen egy detail nézete.
A projekt tartalmazzon egy flutter modult is - .aar állomány - gyakorlatilag egy library ként
kezeljük. MEthod channelt alakítsunk ki a két modul között - natív és flutter - majd építsünk
ki kétirányú kommunikációt. A flutter modulban nagyon egyszerű network hívás legyen, itt
kérjük le a Pokémon detail adatait, ez legyen maga a detail page. A kiválasztott pokémon id
ját -lsd API call pokemonName - adjuk át a flutternek a fluter oldalon kérjük le az aktuális
detail adatokat és jelenítsük meg egy egyszerű UI nézeten.
Architektúra
MVVM architekturális sablon használata.
Screenek
● Launch/Splash
● Lista
● Detail - Flutter
● Kedvencek lista - Opciónális
UX/UI
Szabadon választott, OS specifikus elemek használata - natívon XML vagy Jetpack
compose.
Lista screen
● Pokémon neve jelenjen meg, elemei kattinthatóak.
Detail screen - Flutter:
● Pokémon képe
● Pokemon leírása, főbb infók róla
● Kedvencelés lehetősége, csak lokálban tároljuk - opcionális
Kedvencek Lista - opcionális
● Pokémon neve és képe jelenjen meg, elemei kattinthatóak.

## API
Lista - GET
https://pokeapi.co/api/v2/pokemon/
Detail - GET
https://pokeapi.co/api/v2/pokemon/{pokemonName} pl ->
https://pokeapi.co/api/v2/pokemon/ivysaur
Image - GET
https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/{id}.png
pl: https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/1.png

## Egyéb kritériumok
● Különböző sémák létrehozása, legyen egy dev és egy prod, a launch ikon legyen
különböző a kettő esetében - szabadon választott launch app ikon
● Reachability
● Cachelés használata
● Loader használata javasolt,
● Offline, net nélkül tartalom elérése - természetesen ha volt már előtte betöltve adat