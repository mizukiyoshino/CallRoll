/**
 * Created by nanjolno on 2017/6/26.
 */

import 'rxjs/add/operator/map';
import { Component } from '@angular/core';
import { NavController, NavParams,ToastController  } from 'ionic-angular';
import {RedditData} from '../../providers/reddit-data';
import{GlobalStorage} from '../../providers/global-storage';
@Component({
  selector: 'page-course',
  templateUrl: 'course.html'
})
export class CoursePage {
  due:boolean;
  due2:boolean;
  judge1:boolean;
  judge2:boolean;
  coursename: string;
  oldcoursename:any;
  id:any;
  result:any;
  // 本地数据
  ID:any;
  dailyWeight:any;
  finalWeight=1-this.dailyWeight;
  picketLine:any;
  classSession:any;
  classLocation:any;
  classDate:any;
  classOrder:any;
  shape:any;
  constructor(public navCtrl: NavController, public navParams: NavParams,public CallData: RedditData,public globalStorage:GlobalStorage,public toastCtrl:ToastController) {


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
    this.CallData.getCourseByNameHql(this.coursename).subscribe(
      result => {
        this.result=result.course;
        this.ID=result.course.ID;
        this.dailyWeight=result.course.dailyWeight;
        this.finalWeight=result.course.finalWeight;
        this.picketLine=result.course.picketLine;
        this.classSession=result.course.classSession;
        this.classLocation=result.course.classLocation;
        this.classDate=result.course.classDate;
        this.classOrder=result.course.classOrder;
        this.shape=result.course.shape;

        if(result.course != null){
          console.log(result);
          console.log(result.course);
          console.log(result.course.courseName);
        }}
    );
  }
  find2(){
    this.due2=true;
    this.due=false;
    this.CallData.getCourseByNameHql(this.coursename).subscribe(
      result => {
        this.result=result.course;
        this.ID=result.course.ID;
        this.dailyWeight=result.course.dailyWeight;
        this.finalWeight=result.course.finalWeight;
        this.picketLine=result.course.picketLine;
        this.classSession=result.course.classSession;
        this.classLocation=result.course.classLocation;
        this.classDate=result.course.classDate;
        this.classOrder=result.course.classOrder;
        this.shape=result.course.shape;
      }
    );

    // this.CallData.updateCourse(this.oldcoursename,this.coursename,this.shape,this.ID,this.classDate,this.classLocation,this.classOrder,this.classSession,this.dailyWeight,this.finalWeight,this.picketLine).subscribe(
    //   result=>{
    //     console.log("成功");
    //   }
    // )
  }
  post(){
    this.finalWeight=1-this.dailyWeight;
    this.oldcoursename=this.coursename;
    this.CallData.updateCourse(this.oldcoursename,this.coursename,this.dailyWeight,this.finalWeight,this.picketLine,this.classSession,this.classLocation,this.classDate,this.classOrder,this.ID,this.shape).subscribe(
      result=>{
        console.log("成功");
        let toast = this.toastCtrl.create({
          message: 'so 期末权重：'+this.finalWeight,
          duration:3000
        });
        toast.present();
      }
    )
    this.due=true;
    this.due2=false;
  }

}

