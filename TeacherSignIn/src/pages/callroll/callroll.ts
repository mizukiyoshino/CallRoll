/**
 * Created by nanjolno on 2017/6/26.
 */

import 'rxjs/add/operator/map';
import { Component } from '@angular/core';
import { NavController, NavParams } from 'ionic-angular';
import {RedditData} from '../../providers/reddit-data';
import{GlobalStorage} from '../../providers/global-storage';
@Component({
  selector: 'page-callroll',
  templateUrl: 'callroll.html'
})
export class CallRollPage {
  coursename: string;
  id: any;

  constructor(public navCtrl: NavController, public navParams: NavParams, public CallData: RedditData, public globalStorage: GlobalStorage) {
    this.globalStorage.getStorage('stuId').then((res) => {
      this.id = res;
      // this.coursename="网络工程";
      // this.coursename=;
      console.log(this.id);
    });
    this.globalStorage.getStorage('coursename').then((res) => {
      this.coursename = res;

      // this.coursename=;
      console.log(this.coursename);
    });
    // console.log(this.homepage.temp);
  }

  find() {
    this.CallData.updateCallTheRoll(0,1,"电子技术","2017-6-29","3*4","160327101").subscribe(
      result => {
        console.log(result);
      }
    )
    // }
    // );
    //   this.CallData.getCallTheRollByIDAndCoursename1(this.id,this.coursename).subscribe(
    //     result => {
    //       console.log(result);
    //       console.log(result.callTheRolls);
    //       console.log(result.callTheRolls[0].ID);
    //       console.log(result.callTheRolls[0].autoid);
    //       console.log(result.callTheRolls[0].calldate);
    //       console.log(result.callTheRolls[0].callposition);
    //       console.log(result.callTheRolls[0].callstate);
    //       console.log(result.callTheRolls[0].courseName);
    //     }
    //   )
    //   // console.log(this.CallData.getCallTheRollByIDAndCoursename(this.id,this.coursename));
    // }
  }
}

