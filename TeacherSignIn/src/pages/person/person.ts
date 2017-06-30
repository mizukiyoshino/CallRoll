/**
 * Created by nanjolno on 2017/6/26.
 */

import 'rxjs/add/operator/map';
import { Component } from '@angular/core';
import { NavController, NavParams } from 'ionic-angular';
import {RedditData} from '../../providers/reddit-data';
import{GlobalStorage} from '../../providers/global-storage';
@Component({
  selector: 'page-person',
  templateUrl: 'person.html'
})
export class PersonPage {
  due:boolean;
  due2:boolean;
  judge1:boolean;
  judge2:boolean;
  coursename: string;
  result:any;
  // 本地数据
  ID:any;
  dailyScore:any;
  finalScore:any;
  constructor(public navCtrl: NavController, public navParams: NavParams,public CallData: RedditData,public globalStorage:GlobalStorage) {

    this.globalStorage.getStorage('coursename').then((res) => {
      this.coursename = res;
      console.log(this.coursename);
    });
  }
  judge11(){this.judge1=true;this.judge2=false;}
  judge22(){this.judge2=true;this.judge1=false;}

  find() {
    this.due=true;
    this.due2=false;
    this.CallData.getMarkByName(this.coursename).subscribe(
      result => {
        this.result=result.marks;

        if(result.marks != null){
          console.log(result);
          console.log(result.marks[0]);
          console.log(result.marks[0].dailyScore);
          console.log(result.marks[0].cnameAndID.ID);
        }}
    );
  }



}

