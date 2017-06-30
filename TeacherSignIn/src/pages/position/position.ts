/**
 * Created by nanjolno on 2017/6/26.
 */

import 'rxjs/add/operator/map';
import { Component } from '@angular/core';
import { NavController, NavParams,AlertController,ToastController } from 'ionic-angular';
import {RedditData} from '../../providers/reddit-data';
import{GlobalStorage} from '../../providers/global-storage';
import { DatePipe } from '@angular/common';
import {combineAll} from "rxjs/operator/combineAll";
@Component({
  selector: 'page-position',
  templateUrl: 'position.html'
})
export class PositionPage {
  score:any;
  testRadioOpen: boolean;
  testRadioResult;
  due:boolean;
  due2:boolean;
  judge1:boolean;
  judge2:boolean;
  coursename: string;
  id:any;
  bcalldate:any;
  acalldate:any;
  ccalldate:any;
  result:any;
  result2:any;
  callposition:any;
  call1=[];
  call2=[];
  pname=[];
  hang:any;
  lie:any;
  position:any;
  hangT=[];
  lieT=[];
  final:any;
  now = new Date();
  constructor(public toastCtrl:ToastController,public alerCtrl:AlertController,public navCtrl: NavController, public navParams: NavParams,public CallData: RedditData,public globalStorage:GlobalStorage) {

    this.globalStorage.getStorage('coursename').then((res) => {
      this.coursename = res;
      console.log(this.coursename);
    });
  }



  judge11(){this.judge1=true;this.judge2=false;}
  judge22(){this.judge2=true;this.judge1=false;}
test(){
  var temp=[];
  var pname=[];
  var ID=[];
  this.CallData.getCallTheRollBetweenDateAndCoursename(this.bcalldate,this.bcalldate,this.coursename).subscribe(
    result=>{
      this.result=result.callTheRolls;
      for(var i=0;i<result.callTheRolls.length;i++){
        if(result.callTheRolls[i].callstate!="旷课"){
          temp.push(result.callTheRolls[i].callposition);
          //pname.push(result.callTheRolls[i].pname);
          pname.push(result.callTheRolls[i].pname);
          ID.push(result.callTheRolls[i].ID);
        }
      }
      console.log(temp);
      console.log(pname);
      //console.log(this.now);
      for(var i=0;i<temp.length;i++){
        this.call1[i]=parseInt(temp[i].split("*")[0]);
        this.call2[i]=parseInt(temp[i].split("*")[1]);
        console.log(this.call1[i]);
        console.log(this.call2[i]);
      }



      // this.hang=9;
      // this.lie=9;
      console.log(this.hang);
      console.log(this.lie);
      for(var j=0;j<this.hang;j++){  this.hangT[j]=j;}
      for(var x=0;x<this.lie;x++){  this.lieT[x]=x;}
      console.log(this.hangT);
      console.log(this.lieT);
      var state=[this.hang];
      // var state=[this.hang][this.lie];
      // state=0;
      // console.log(state);


      var n=this.hang,m=this.lie;
      var hhh=new Array();
      for(var i=0; i<n; i++) {
        hhh[i] = new Array();
        for (var j = 0; j < m; j++)
        {
          hhh[i][j]=new Array();
          hhh[i][j][0]="null";
          hhh[i][j][1]=0;
          hhh[i][j][2]=0;
        }
      }

      for(var i=0; i<this.call1.length; i++) {
        hhh[this.call1[i]-1][this.call2[i]-1][0]=pname[i];
        hhh[this.call1[i]-1][this.call2[i]-1][1]=1;
        hhh[this.call1[i]-1][this.call2[i]-1][2]=ID[i];
      }
      this.position=hhh;
      this.id=ID;
      console.log(this.id);
    })
}
  find() {//图
    this.due=true;
    this.due2=false;
    this.bcalldate=""+this.now.getFullYear()+"-"+(this.now.getMonth()+1)+"-"+this.now.getDate();//this.now;
    this.acalldate=this.bcalldate;//"2017-4-6";//this.now;
    this.ccalldate=this.bcalldate;//"2017-4-6";
    // this.acalldate="2017-4-6";
    // this.ccalldate="2017-4-6";
    var temp=[];
    var pname=[];
    var ID=[];
    this.CallData.getCourseByNameHql(this.coursename).subscribe(
      result=>{
        this.result=result.course;
        this.callposition=result.course.shape;
        console.log(this.callposition);
        console.log(this.callposition);
        console.log(typeof (this.callposition));
        this.hang=parseInt(this.callposition.split("*")[0]);
        this.lie=parseInt(this.callposition.split("*")[1]);
      }
    );

    this.CallData.getCallTheRollBetweenDateAndCoursename(this.acalldate,this.ccalldate,this.coursename).subscribe(
      result=>{
        this.result=result.callTheRolls;
        for(var i=0;i<result.callTheRolls.length;i++){
          if(result.callTheRolls[i].callstate!="旷课"){
            temp.push(result.callTheRolls[i].callposition);
            //pname.push(result.callTheRolls[i].pname);
            pname.push(result.callTheRolls[i].pname);
            ID.push(result.callTheRolls[i].ID);
          }
        }
        console.log(temp);
        console.log(pname);
        //console.log(this.now);
        for(var i=0;i<temp.length;i++){
          this.call1[i]=parseInt(temp[i].split("*")[0]);
          this.call2[i]=parseInt(temp[i].split("*")[1]);
          console.log(this.call1[i]);
          console.log(this.call2[i]);
        }



        // this.hang=9;
        // this.lie=9;
        console.log(this.hang);
        console.log(this.lie);
        for(var j=0;j<this.hang;j++){  this.hangT[j]=j;}
        for(var x=0;x<this.lie;x++){  this.lieT[x]=x;}
        console.log(this.hangT);
        console.log(this.lieT);
        var state=[this.hang];
        // var state=[this.hang][this.lie];
        // state=0;
        // console.log(state);


        var n=this.hang,m=this.lie;
        var hhh=new Array();
        for(var i=0; i<n; i++) {
          hhh[i] = new Array();
          for (var j = 0; j < m; j++)
          {
            hhh[i][j]=new Array();
            hhh[i][j][0]="null";
            hhh[i][j][1]=0;
            hhh[i][j][2]=0;
          }
        }

        for(var i=0; i<this.call1.length; i++) {
            hhh[this.call1[i]-1][this.call2[i]-1][0]=pname[i];
            hhh[this.call1[i]-1][this.call2[i]-1][1]=1;
            hhh[this.call1[i]-1][this.call2[i]-1][2]=ID[i];
        }
        this.position=hhh;
        this.id=ID;
        console.log(this.id);
      }
    )
  }
  find2(){ this.due2=true;
    this.due=false;
    var temp=[];
    // this.dataPipe.transform(this.now,'MMM DD YYYY');
    // console.log(this.now);
    // console.log(this.now.getFullYear());
    // console.log(this.now.getMonth()+1);
    // console.log(this.now.getDate());
    // console.log(this.now);
    // console.log(this.now);
    // console.log(this.now);
    this.bcalldate=""+this.now.getFullYear()+"-"+(this.now.getMonth()+1)+"-"+this.now.getDate();//this.now;
    this.acalldate=this.bcalldate;//"2017-4-6";//this.now;
    this.ccalldate=this.bcalldate;//"2017-4-6";
    console.log(this.bcalldate);
    this.CallData.getCallTheRollBetweenDateAndCoursename(this.acalldate,this.ccalldate,this.coursename).subscribe(
      result=>{
        this.result2=result.callTheRolls;
console.log(result.callTheRolls);
        for(var i=0;i<result.callTheRolls.length;i++){
         if(result.callTheRolls[i].callstate!="旷课"){
            // console.log("成功");
           temp.push(result.callTheRolls[i].callposition);
         }
        }
        console.log(temp);
        //console.log(this.now);

      }
    )

  }


start(){
this.CallData.callOverByCoursenameAndDate(this.coursename).subscribe(
  result=>{
    console.log(result);
  }
)
}
  question(j, i){
  console.log(j);
  console.log(i);
    let alert = this.alerCtrl.create();
    alert.setTitle('课堂打分'+this.position[j-1][i-1][2]);
    alert.addInput({
      type: 'radio',
      label: '95',
      value: '95',
      checked: true
    });

    alert.addInput({
      type: 'radio',
      label: '85',
      value: '85'
    });

    alert.addInput({
      type: 'radio',
      label: '75',
      value: '75'
    });

    alert.addInput({
      type: 'radio',
      label: '65',
      value: '65'
    });

    alert.addInput({
      type: 'radio',
      label: '55',
      value: '55'
    });
    alert.addButton('取消');
    var score;
    alert.addButton({
      text: '确认',
      handler: data => {
        console.log('Radio data:', data);
        this.testRadioOpen = false;
        this.testRadioResult = data;
        score=data;
        console.log(score);
        var TheID=this.position[j-1][i-1][2];
        console.log(TheID);
        this.CallData.createQuestion(score,TheID,this.coursename).subscribe(
          result=>{
            let toast = this.toastCtrl.create({
              message: 'ID'+TheID+''+j+'行'+i+'列'+'分数'+score,
              duration:3000
            });
            toast.present();
          }
        )
      }
    });
    alert.present().then(() => {
      this.testRadioOpen = true;
    });
    // this.CallData.

}
}

