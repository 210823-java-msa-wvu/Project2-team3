import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-dice',
  templateUrl: './dice.component.html',
  styleUrls: ['./dice.component.css']
})
export class DiceComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
    
  }
  public diceValues: Array<number> = [0, 0 ,0 ,0 ,0 ,0];
  public diceNumber: number = 0;
  public diceNumberOne: number = 0;
  public diceNumberTwo: number = 0;
  public natural: number = 20;
  public result: string = '';

  diceRoll() {
    for (let i = 0; i < this.diceValues.length; i++) {
      this.diceValues[i] = Math.floor(Math.random() * 6) + 1;
    }
  }

  diceroll(){
    this.diceNumber = Math.floor(Math.random() * (20 - 1 + 1)) + 1;
  }

  dicerollOne(){
    this.diceNumberOne = Math.floor(Math.random() * (20 - 1 + 1)) + 1;
  }

  dicerollTwo(){
    this.diceNumberTwo = Math.floor(Math.random() * (20 - 1 + 1)) + 1;
  }

  clearRoll() {
    this.diceNumber = 0;
  }
  
  clearDiceOne(){
    this.diceNumberOne = 0;
  }

  clearDiceTwo() {
    this.diceNumberTwo = 0;
  }

  rollResults() {
    if (this.diceNumber > this.diceNumberTwo){
      this.result = 'Attacking Player has Landed a Hit on the Target!';
    } else if (this.diceNumberTwo > this.diceNumber){
      this.result = 'The Defending Player has Successfully Evaded the Attack!';
    } else if (this.diceNumber == this.diceNumberTwo){
      this.result = 'The Attacker and Defender are at a Stand Still!';
    } else {
      this.result = '';
    }
  }



}
