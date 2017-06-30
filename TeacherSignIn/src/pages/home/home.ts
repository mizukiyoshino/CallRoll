import {Component} from '@angular/core';
import {NavController,ToastController} from 'ionic-angular';
import {PositionPage} from "../position/position";
import{GlobalStorage} from '../../providers/global-storage'
import {HistoryPage} from "../history/history";
import {RedditData} from '../../providers/reddit-data';
@Component({
  selector: 'page-home',
  templateUrl: 'home.html'
})
export class HomePage {
  stuInf: any;
  public temp:string;
  A=[];
  courseList=[];
  finalWeight=[];
  classDate=[];
  dailyWeight=[];
  shape=[];
  picketLine=[];
  classOrder=[];
  classLocation=[];
  classSession=[];
kong:string;
pname:"老师";
  constructor(public toastCtrl:ToastController,private globalStorage: GlobalStorage, public navCtrl: NavController,public CallData: RedditData) {
    this.globalStorage.getStorage('stuId').then((res) => {
      this.stuInf = res;
      console.log('home page: ' + this.stuInf);
      this.CallData.getCourseByIDHql(this.stuInf).subscribe(
        result=>{
          console.log(result);
          console.log(result.courses.length);
          for(var i=0;i<result.courses.length;i++){
            this.courseList.push(result.courses[i].courseName);
            this.finalWeight.push(result.courses[i].finalWeight);
            this.dailyWeight.push(result.courses[i].dailyWeight);
            this.classDate.push(result.courses[i].classDate);
            this.shape.push(result.courses[i].shape);
            this.picketLine.push(result.courses[i].picketLine);
            this.classOrder.push(result.courses[i].classOrder);
            this.classLocation.push(result.courses[i].classLocation);
            this.classSession.push(result.courses[i].classSession);
          }
          console.log(this.courseList);
          this.kong='*********';
          for(var y=0;y<result.courses.length;y++) {
            this.A[y] = `
周序：${this.classDate[y]}
节次：${this.classOrder[y]}
上课地点：${this.classLocation[y]}
学时：${this.classSession[y]}
警戒线：${this.picketLine[y]}
日常权重：${this.dailyWeight[y]}
期末权重：${this.finalWeight[y]}
布局：${this.shape[y]}
          `;//new Array(

            /*
             this.courseList[y] + this.kong+
             "周序：" + this.classDate[y] +"\n" +
             "节次：" + this.classOrder[y] +" \t  " +
             "上课地点：" + this.classLocation[y] +"  " +
             "学时" + this.classSession[y] +"\r\n" +
             "警戒线：" + this.picketLine[y] +"  " +
             "日常权重：" + this.dailyWeight[y] +"  " +
             "期末权重：" + this.finalWeight[y] +"  " +
             "布局：" + this.shape[y];*/
          }
        }
      )
    });

  }
getName(){

  }

  courseSelected(course) {
    // this.navCtrl.push(HomePage);
    let toast = this.toastCtrl.create({
      message: '您已成功选择课程:'+course+'！！！请进入侧边栏选择功能',
      duration:3000
    });
    toast.present();
    this.temp=course;
    this.globalStorage.setStorage('coursename',this.temp);
  }


}
