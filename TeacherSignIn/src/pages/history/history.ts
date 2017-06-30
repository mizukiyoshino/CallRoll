/**
 * Created by nanjolno on 2017/6/26.
 */

import 'rxjs/add/operator/map';
import { Component } from '@angular/core';
import { NavController, NavParams } from 'ionic-angular';
import {RedditData} from '../../providers/reddit-data';
import{GlobalStorage} from '../../providers/global-storage';
import {subscribeToResult} from "rxjs/util/subscribeToResult";
@Component({
  selector: 'page-history',
  templateUrl: 'history.html'
})
export class HistoryPage {
  due:boolean;
  due2:boolean;
  judge1:boolean;
  judge2:boolean;
  coursename: string;
  id:any;
  bcalldate:any;
  acalldate:any;
  result:any;
  result2:any;
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
    console.log(this.id);
    this.CallData.getCallTheRollByIDAndCoursename1(this.id,this.coursename).subscribe(
      result => {
        this.result=result.callTheRolls;
        if(result.callTheRolls != null){
          console.log(result);
          console.log(result.callTheRolls);

        }}
    );
  }
  find2(){ this.due2=true;
    this.due=false;
    this.CallData.getCallTheRollBetweenDateAndCoursename(this.bcalldate,this.acalldate,this.coursename).subscribe(
      result=>{
        this.result2=result.callTheRolls;
      }
    )}

}

