import {Component} from '@angular/core';
import {GlobalStorage} from '../../providers/global-storage'
import {RedditData} from '../../providers/reddit-data'

@Component({
  selector: 'page-kaoqin',
  templateUrl: 'kaoqin.html'
})

export class KaoqinPage {
  qj:string[];
  kk:string[];
  id:any;
  courses:any;
  record:Array<{c:string, q:string, k:string}>

  constructor(public courseData: RedditData, public globalStorage: GlobalStorage) {

    globalStorage.getStorage('stuId').then(res => {
      this.id = res;
      console.log('kq page ' + this.id);
      this.courseData.getCoursesById(res).subscribe(
        result => {
          this.courses = result.marks;
          // for(let item of result.marks) {
          //   this.courses.push(item);
          // }
          this.qj = [];
          this.kk = [];
          for(let item of this.courses) {
            this.courseData.countCallTheRoll(this.id, 2, item.cnameAndID.courseName).subscribe(r1 => {
              this.qj.push(r1.countnum);
              console.log('kq page res ' + r1.countnum);
            });
            this.courseData.countCallTheRoll(this.id, 3, item.cnameAndID.courseName).subscribe(r2 => {
              this.kk.push(r2.countnum);
              console.log('kq page res 2 ' + r2.countnum);
            });
            this.record = [];
            for(let i = 0; i < this.courses.length; i++) {
              this.record.push({c:this.courses[i], q:this.qj[i], k:this.kk[i]});
              console.log('kq page 1' + this.qj[i]);
            }
          }

          console.log('kq page 2' + result.marks[0].cnameAndID.courseName);
        }
      );
    });


  }
}
