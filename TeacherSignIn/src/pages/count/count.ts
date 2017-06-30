/**
 * Created by nanjolno on 2017/6/26.
 */

import 'rxjs/add/operator/map';
import { Component } from '@angular/core';
import { NavController, NavParams } from 'ionic-angular';
import {RedditData} from '../../providers/reddit-data';
import{GlobalStorage} from '../../providers/global-storage';
@Component({
  selector: 'page-count',
  templateUrl: 'count.html'
})
export class CountPage {
  due:boolean;
  due2:boolean;
  judge1:boolean;
  judge2:boolean;
  coursename: string;
  result:any;
  // 本地数据
  length:any;
  ID=[];
  qiandao=[];
  qingjia=[];
  kuangke=[];
  chidao=[];

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
    this.CallData.countAllCallTheRoll(this.coursename).subscribe(
      result => {
        this.result=result.counts;
        this.length=result.counts.length;
        if(result.counts != null){
          console.log(result);
          console.log(result.counts.length);
          console.log(result.counts[0][0]);
     //     for(var h:)
for(var i=0;i<result.counts.length;i++){
          for(var k in result.counts[i]) {
            console.log('key is ' + k);
            this.ID[i]=k;
            var j=0;
            for(var k2 in result.counts[i][k]) {
              console.log('key is ' + k2);
              console.log('value is' + result.counts[i][k][k2]);
              if(j==0){this.qiandao[i]=result.counts[i][k][k2];}
              if(j==1){this.qingjia[i]=result.counts[i][k][k2];}
              if(j==2){this.kuangke[i]=result.counts[i][k][k2];}
              if(j==3){this.chidao[i]=result.counts[i][k][k2];}
              j++;
          }
        }
}
          console.log(this.ID);
          console.log(this.qingjia);
        }
      else{

          this.length=1;
          this.qiandao[0]="无";
        this.qingjia[0]="无";
        this.kuangke[0]="无";
        this.chidao[0]="无";
        }

      }
    );
  }



}

