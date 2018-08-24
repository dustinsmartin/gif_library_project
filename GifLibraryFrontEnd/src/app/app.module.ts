import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { GifLibraryComponent } from './gif-library/gif-library.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    GifLibraryComponent
  ],
  imports: [
    BrowserModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
