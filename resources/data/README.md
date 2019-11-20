# Evolution des noms


> #### Ancien nom => Nouveau nom
>
> military => classroom </br>
> civilian => library </br>
> commercial => administration </br>
> scientific => laboratory </br>
> guild => association </br>
> </br>
> rawMaterial => credits </br>
> ManufacturedProduct => skills </br>
>  </br>
> militaryPower => knowledge </br>
> </br>
> Age 1 => TC </br>
> Age 2 => branch </br>
> Age 3 => specialization </br>

</br>

# Diagramme UML

[Accès direct](http://www.plantuml.com/plantuml/uml/XLNDRiCs3BxxAGpqjY4l41H5asmT2ZHhrsJOReLgiuuGMqebELtMxTr7KZKjpGPwiSIFFoO_VR9lVL0kz5rRU0YbKHtuawfW1oVbLB2kN2wBecgLz-KlwDmgenfmvMTnLRRQXwTMNS3vSbckd5EN1uIk8tPJB1R5lqDkn3YjmJ9hgroDINzOKuD3q5VM0G8xMj4-wmfVVdcosWIgpfkiuWOhS3rDXSXxHUrpaU2qQT0EbnFQ7Bh7BIALzO4GND32KQZp9dgq-Lav0_NmEWHFpjPz5RGr-OGHXlePlBUzg-06WpjjTDTtSTHdUE-rWtflry08burihJhRS_aA6_Dhg2ocDdSEOFKMm54Kslk3zZna-cO2RhuofwzOmvjrS6yU7RAwjmGELUwimnSCREHC4YUV8rqo59s3Qdk8_582cBuR_PZqOxdPlLJOX0wuts_7_MEo_sqpxd7OauC368-illYZRbj4MzleIYnx0XHVwk-KEuuT_mJLKIH8y_WfIJYYTBngOg_x3JvUdJBL0JV-19LMhVwRNoN1sI5nMlYmz3mu05pVS7PQz9aih_-Y9vp1uBgz__L--_kMTgi_UISzHwb_fzYQ9bloW2G_FjLXG0RJgLYOtE5hhzkQrmi-uMnRRgxMdeGY6SD5u1mv4Ja3ZTIuomiNmtO8Kg-MFmCPgcgIkW_nZ58FZ-gixL8G8LlfF7RaPNgNc2CdLYx8zrwPeCCbCZYMaPZuNM2U1dtpe8Hdy8x6dg3hhmQdPHw4YnaVKpVZM6LKaLzqEntSV_kHIQSQg9vvwKXuuXJ2hJRPVMU0P97Vzoo9lykS94SyP1A6Qs9-HAaBC2WhHOJC1CnrbJfa847JYy30eElXru6xex4VBTGDv2AalA98_sO_B1PVrxxWXP7XvnGNHlW6qeCj_f0MpF3rFsXd4apmL5A518bVz3dl5PaMKaTy8hjvht0y7p0HvtpGIDnyHAx4eeZwOaf5M2cjBAKKYETPC9u2L4w8vZA2yFzRh5KZhY5PpEajmhEdTFOcu3JmVn6tOEg-Q_y3).


```
@startuml
set namespaceSeparator ::

class GameManager {
# listPlayers : ArrayList<Player>
--
}

class Player {
# gameBoard : Wonder
# score : Score
# victoryPoints : Point
--
}

class Card {
# id : int
# name : String
# type : CardType
# cost : Cost
# age : Age
# coinEarned : Point
# production : ArrayList<ProductedRessource>
# minimumPlayerRequiredToBePlayed : PlayersAmount
# cardsBecomingFreeAfterPlayingThisCard : ArrayList<Card>
# cardRequiredToBePlayedBeforeInOrderToPlayThisCardForFree : Card
--
}

class Cost {
# type : Ressource
# value : int
}

enum Ressource {
+ CS_credit
+ TM_credit
+ OM_credit
+ QC_credit
+ comprehension_skill
+ logic_skill
+ operation_skill
+ mark
}

class Deck {
# listCards : ArrayList<Card>
--
}

enum Age {
+ TC
+ branch
+ specialization
}

enum PlayersAmount {
+ two
+ three
+ four
+ five
+ six
+ seven
+ MINIMUM
+ MAXIMUM
}

class Wonder {
# id : int
# name : String
# deck : Deck
# playedCards : Deck
--
}

enum Action {
+ build
+ buy
+ evolve
+ discard
}

enum CardType {
+ credit
+ skill
+ library_building
+ laboratory_building
+ administration_building
+ classroom_building
+ association_building
}

class ProductedRessource {
# ressource : Ressource
# quantity : int
}

class RessourceCard {
--
}
class CreditCard{
--
}
class SkillCard{
--
}
class BuildingCard {
--
}
class LaboratoryCard {
--
}
class LibraryCard {
--
}
class AdministrationCard {
# listProductedRessources : ArrayList<ProductedRessource>
--
}
class ClassroomCard {
--
}
class AssociationCard {
--
}

class Point {
# type : PointType
# value : int
--
}

class Score {
# classroom : Point
# coin : Point
# wonder : Point
# library : Point
# laboratory : Point
# administration : Point
# association : Point
--
}

enum PointType {
+ victory
+ knowledge
+ association
}



GameManager *-- Player
Player *-- Wonder
Wonder *-- Deck
Deck *-- Card

Card <|-- RessourceCard
Card <|-- BuildingCard
RessourceCard <|-- CreditCard
RessourceCard <|-- SkillCard
BuildingCard <|-- LibraryCard
BuildingCard <|-- LaboratoryCard
BuildingCard <|-- AdministrationCard
BuildingCard <|-- AssociationCard
BuildingCard <|-- ClassroomCard

Point *-- PointType

Player *-- Score
Player *-- Point

Score *-- Point

Card *-- CardType
Card *-- Cost
Card *-- Age
Card *-- Point
Card *-- ProductedRessource


Cost *-- Ressource

ProductedRessource *-- Ressource
@enduml
```