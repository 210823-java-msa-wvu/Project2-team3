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
  public natural: number = 20;

  diceRoll() {
    for (let i = 0; i < this.diceValues.length; i++) {
      this.diceValues[i] = Math.floor(Math.random() * 6) + 1;
    }
  }

  diceroll(){
    this.diceNumber = Math.floor(Math.random() * (20 - 1 + 1)) + 1;
  }

}
