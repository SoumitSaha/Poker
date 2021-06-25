/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package termproject;

import java.io.Serializable;

/**
 *
 * @author Soumit
 */
public class CommunicationMsg implements Serializable,Cloneable{
    int type = 0;
    Card[] hand = new Card[2];
    Card[] river = new Card[5];
    Card[] SortedCard = new Card[7];
    int balance = 1000;
    int Bet;
    int choice;
    int playerID;
    static int bidderID,pot,winnerID,foldID;
    int rank;
    String handname;
    Card[] winningcards = new Card[5];
    String message;
    Card[] powercard,kicker;
    
    
    
    /* Messege Types...
    type 11 : receiving 2 cards in hand of player from dealer
    type 1 : taking blind
    type 2 : request to choose among raise, match or fold (no card in river)
    type 3 : player message choosing among raise, match or fold
    type 4 : Show first 3 Card Instruction Msg
    type 5 : Show net river card instruction
    type 6 : Show net river card instruction
    type 7 : Winner declaration
    type 8 : req player to send all his info
    type 9 : player message choosing among raise, check or fold
    type 10 : fold msg
    type 12 : request to choose among raise, match or fold (3 card in river)
    type 13 : request to choose among raise, match or fold (4 card in river)
    type 14 : request to choose among raise, match or fold (5 card in river)
    */
}
