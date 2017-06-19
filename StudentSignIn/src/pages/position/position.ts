import {Component} from '@angular/core';
// import {FormGroup, FormControl} from '@angular/forms';
import { RedditData } from '../../providers/reddit-data';

@Component({
  selector: 'page-position',
  templateUrl: 'position.html'
})
export class PositionPage {
  // langs;
  // langForm;
  newsData: any;
  isTrue:any;

  constructor(public redditService: RedditData) {
    // this.langForm = new FormGroup({
    //   "langs": new FormControl({value: 'rust', disabled: false})
    // });
    this.redditService.getJsonData().subscribe(
      res => {
        this.newsData = res.personnels;
      }
    )
  }

  // doSubmit(event) {
  //   console.log('Submitting form', this.langForm.value);
  //   event.preventDefault();
  // }

  ionViewDidLoad(){
    this.redditService.getJsonData().subscribe(
      result => {
        for(let item of result.personnels) {
          this.newsData.push(item)
        }
        console.log("Success : "+this.newsData);
      },
      err =>{
        console.error("Error : "+err);
      } ,
      () => {
        console.log('getData completed');
      }
    );

    this.redditService.postLogin('1', '1').subscribe(
      result => {

          this.isTrue = result.state;

        console.log("Success : "+this.isTrue);
      },
      err =>{
        console.error("Error : "+err);
      } ,
      () => {
        console.log('postLogin completed');
      }

    );
  }
}
