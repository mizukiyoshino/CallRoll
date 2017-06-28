import {Component} from '@angular/core';
// import {NavParams} from 'ionic-angular';
import {GlobalStorage} from '../../providers/global-storage'
import {RedditData} from '../../providers/reddit-data'

@Component({
  selector: 'page-site',
  templateUrl: 'site.html'
})

export class SitePage {

  c: any;
  site: string[];
  row: any;
  col: any;
  rows: number[];
  cols: number[];

  constructor(public courseData: RedditData, public globalStorage: GlobalStorage) {
    globalStorage.getStorage('courseName').then(res => {
      this.c = res;
      console.log('site page ' + res);
      courseData.getCourseByName(res).subscribe(result => {
        this.site = result.course.shape.split('*');
        this.row = this.site[0];
        this.col = this.site[1];
        console.log('site page ' + this.row);
        console.log('site page ' + this.col);
        this.cols = [];
        this.rows = [];
        for(let i = 1; i <= this.col; i++) {
          // console.log('cols ' + i);
          this.cols.push(i);
        }
        for(let i = 1; i <= this.row; i++) {
          // console.log('cols ' + i);
          this.rows.push(i);
        }
        // console.log('site page site ' + this.site[0] + ':' + this.site[1]);
        // console.log('site page getCourse ' + result.course.shape);
      });
    });



    // for(let i = 1; i <= this.row; i++) {
    //   console.log('rows ' + i);
    //   this.rows.push(i);
    // }
    // for(let i = 1; i <= this.col; i++) {
    //   console.log('cols ' + i);
    //   this.cols.push(i);
    // }
  }

  sign() {

  }
}
