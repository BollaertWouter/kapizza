import {Component, OnInit} from '@angular/core';

@Component({
  selector: 'menu',
  templateUrl: './menu.component.html',
  styleUrls: ['./menu.component.css']
})

export class MenuComponent implements OnInit{
  pizzas = [{name: "Barbecue chicken medium", price: "€ 12,95"},
    {name: "Toni pepperoni medium", price:"€ 12,95"},
    {name: "New barbecue meatlovers medium", price:"€ 12,95"},
    {name: "Menu deal 1", price: "€ 22,00"},
    {name: "Menu deal 2", price: "€ 24,95"},
    {name: "Menu for one", price: "€ 13,95"}];

  title = 'Kapizza - menu';

  ngOnInit(): void {

  }
}
