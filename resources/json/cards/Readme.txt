ressource{
    CS
    TM
    OM
    QC
    EC
    ST
    M
    MONEY
    sciencesymbol1
    sciencesymbol2
    sciencesymbol3
}
card{
    id:int
    name:String
    type:Cardtype
    cost:ArrayList<RessourcePark>//////modifier svp
    formation:int
    coinEarned:Point
    list..
    minimin..
    cardBecoming..:ArrayList<card>
    cardrequire...:ArrayList<card>////modifier svp

}

Pour les cartes avec functions, j'ai mis a le nom comment ca fonctionner.