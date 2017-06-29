import {Component} from '@angular/core';

import {LoadingController, ToastController} from 'ionic-angular';
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

  pai: string;
  lie: string;

  // public time = '2017-05-10';

  constructor(public toastCtrl: ToastController, public loadingCtrl: LoadingController, public courseData: RedditData, public globalStorage: GlobalStorage) {
    globalStorage.getStorage('courseName').then(res => {
      this.c = res;
      console.log('site page ' + res);
      courseData.getCourseByName(res).subscribe(result => {
        this.site = result.course.shape.split('*');
        this.row = this.site[0];
        this.col = this.site[1];
        console.log('site page row ' + this.row);
        console.log('site page col ' + this.col);
        this.cols = [];
        this.rows = [];
        for (let i = 1; i <= this.col; i++) {
          // console.log('cols ' + i);
          this.cols.push(i);
        }
        for (let i = 1; i <= this.row; i++) {
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
    let loading = this.loadingCtrl.create({
      duration: 1000
    });
    // console.log('site page sign() time ' + this.event);
    // console.log('site page sign() pai ' + this.pai);
    // console.log('site page sign() lie ' + this.lie);
    let w = this.pai + '*' + this.lie;

    this.globalStorage.getStorage('stuId').then(res => {
      console.log('site page ' + this.c + ' ' + res + ' ' + w);
      this.courseData.updateCallTheRoll(res, w, this.c, 1);
      console.log('site page final' + this.c + ' ' + res + ' ' + w);
    });


    // console.log('site page ' + w);
    let toast = this.toastCtrl.create({
      message: '签到成功',
      duration: 1000,
      position: 'bottom',
    });
    toast.present();
    loading.present();
  }
}
