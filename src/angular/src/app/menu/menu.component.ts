import {Component, OnInit} from '@angular/core';
import {Product} from "../product";

@Component({
  selector: 'menu',
  templateUrl: './menu.component.html',
  styleUrls: ['./menu.component.css']
})

export class MenuComponent implements OnInit {
  products = [new Product("Barbecue chicken medium", "€ 12,95"),
    new Product("Toni pepperoni medium", "€ 12,95"),
    new Product("New barbecue meatlovers medium", "€ 12,95"),
    new Product("Menu deal 1", "€ 22,00"),
    new Product("Menu deal 2", "€ 24,95"),
    new Product("Menu for one", "€ 13,95")];

  added_products = [];

  title = 'Kapizza - menu';

  ngOnInit(): void {

  }

  addPizza(product: Product): void {
    this.added_products.push({name: product.name, price: product.price});
  }

  removePizza(product: Product): void {
    this.arrayRemove(product);
  }

  arrayRemove(value) {
    const index: number = this.added_products.indexOf(value);
    if (index !== -1) {
      this.added_products.splice(index, 1);
    }
  }
}
