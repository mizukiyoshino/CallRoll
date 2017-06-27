import {Component} from '@angular/core';
import {NavController} from 'ionic-angular';
import {PositionPage} from "../position/position";
import{GlobalStorage} from '../../providers/global-storage'
import {RedditData} from '../../providers/reddit-data'

@Component({
  selector: 'page-home',
  templateUrl: 'home.html'
})
export class HomePage {
  name: any;
  id:any;

  courses: any;

  constructor(private stuData: RedditData, private globalStorage: GlobalStorage, public navCtrl: NavController) {
    // this.courses = ['工程训练', '分布式数据库', '软件体系结构', '专业英语'];
    this.globalStorage.getStorage('stuId').then((res) => {
      // this.stuInf = res;
      console.log('home page ' + res);
      this.stuData.getPersonById(res).subscribe(
        result => {
          this.name = result.personnel.Pname;
          this.id = result.personnel.ID;
          console.log('home page 1' + result.personnel.Pname);
        }
      );

      this.stuData.getCoursesById(res).subscribe(
        result => {
          this.courses = result.marks;
          // for(let item of result.marks) {
          //   this.courses.push(item);
          // }
          console.log('home page 2' + result.marks[0].cnameAndID.courseName);
        }
      );
    });

  }

  courseSelected(event, course) {
    this.navCtrl.push(PositionPage,{
      item:course
    })
  }
}
