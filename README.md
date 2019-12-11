# UML

## Class Diagram

!(UML Class Diagram)[./resources/png/UML_ClassDiagram.png]

```
@startuml
set namespaceSeparator ::

class GameManager {
# listPlayers : ArrayList<Player>
--
}

class Player {
# gameBoard : UT
# score : Score
# victoryPoints : Point
--

}

class Card {
# id : int
# name : String
# type : CardType
# cost : RessourcePack
# formation : Formation
# coinEarned : Point
# listProductRessources : ArrayList<RessourcePack>
# minimumPlayerRequiredToBePlayed : PlayersAmount
# cardsBecomingFreeAfterPlayingThisCard : ArrayList<Card>
# cardRequiredToBePlayedBeforeInOrderToPlayThisCardForFree : Card
--
}

class RessourcePack {
# type : Ressource
# value : int
}

enum Ressource {
+ CS
+ TM
+ OM
+ QC
+ EC
+ ST
}

class Deck {
# listCards : ArrayList<Card>
--
}

enum Formation {
+ COMMON_CORE
+ BRANCH
+ SPECIALIZATION
}

enum PlayersAmount {
+ Two
+ Three
+ Four
+ Five
+ Six
+ Seven
+ MINIMUM
+ MAXIMUM
}

class UT {
# id : int
# name : UTCity
# deck : Deck
# playedCards : Deck
--
}

enum UTCity {
+ BELFORT
+ SEVENANS
+ MONTBELIARD
+ TROYES
+ COMPIEGNE
+ SHANGHAI
+ SANTIAGO
}

enum Action {
+ Build
+ Buy
+ Evolve
+ Discard
}

enum CardType {
+ Credit
+ Skill
+ LibraryBuilding
+ LaboratoryBuilding
+ AdministrationBuilding
+ ClassroomBuilding
+ AssociationBuilding
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
class LaboratoryCard {
--
}
class LibraryCard {
--
}
class AdministrationCard {
# listProductedRessources : ArrayList<RessourcePack>
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
# ut : Point
# library : Point
# laboratory : Point
# administration : Point
# association : Point
--
}

enum PointType {
+ Victory
+ Knowledge
+ Association
}

Action <.. GameManager
PlayersAmount <.. GameManager

GameManager *--"2..7" Player
Player *-- UT
UT *-- Deck
Deck *--"49" Card

UT *-- UTCity

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

Score o-- Point

Card *-- CardType
Card o-- RessourcePack
Card o-- Formation
Card o-- Point

Card o-- PlayersAmount

RessourcePack *-- AdministrationCard

RessourcePack *-- Ressource

@enduml
```