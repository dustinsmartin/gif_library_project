import { Component, OnInit } from '@angular/core';
import {GphApiClient} from 'giphy-js-sdk-core';
@Component({
  selector: 'app-gif-library',
  templateUrl: './gif-library.component.html',
  styleUrls: ['./gif-library.component.css']
})
export class GifLibraryComponent implements OnInit {

  apiKey:string = "Yw7GxnRo7xxIn56OvGsjCLYMlVDpO5nG";
  trendingGIFs:any[];
  constructor() { }
  ngOnInit() {
    //hard-coded gifs
    this.trendingGIFs = [
      "../../assets/gifs/apeescape.gif",
      "../../assets/gifs/baby.gif",
      "../../assets/gifs/bryant.webp",
      "../../assets/gifs/clapback.webp",
      "../../assets/gifs/daaaawwwwwhhhhh.webp",
      "../../assets/gifs/dave.gif",
      "../../assets/gifs/dontatme.gif",
      "../../assets/gifs/leavingtraininglike.webp",
      "../../assets/gifs/reaction.webp",
      "../../assets/gifs/tellingmyclassmateshowIfeel.webp",
      "../../assets/gifs/whenmomaskswhyIdonthaveagf.gif",
      "../../assets/gifs/whenwetakeatestthelastfriday.webp",
      "../../assets/gifs/wiggle.gif"
    ];
    ///Get trending gifs
/*     let GphApiClient = require('giphy-js-sdk-core');
    var client = new GphApiClient(this.apiKey);

    client.trending("gifs", {"limit": 5})
    .then((response) => {
      this.trendingGIFs = response.data;
      console.log(response);
    })
    .catch((err) => {
      console.log("There was a problem getting the gifs!");
    }) */
  }

}
