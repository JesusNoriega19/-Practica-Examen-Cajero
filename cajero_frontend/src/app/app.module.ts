import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http'; 
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { FormsModule } from '@angular/forms'; // Importar FormsModule

@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule, // Agregar el módulo HTTP
    FormsModule       // Agregar FormsModule para usar ngModel
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
