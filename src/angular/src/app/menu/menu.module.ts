import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';

import {MenuComponent} from './menu.component';
import {MatSidenavModule} from "@angular/material/sidenav";
import {BrowserAnimationsModule} from "@angular/platform-browser/animations";
import {MatDividerModule} from "@angular/material/divider";
import {MatListModule} from "@angular/material/list";
import {FormsModule} from "@angular/forms";

@NgModule({
  declarations: [
    MenuComponent
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    MatSidenavModule,
    MatDividerModule,
    MatListModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [MenuComponent]
})

export class MenuModule { }
