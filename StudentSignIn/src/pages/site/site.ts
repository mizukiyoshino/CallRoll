import {Component} from '@angular/core';
// import {NavParams} from 'ionic-angular';
import {GlobalStorage} from '../../providers/global-storage'

@Component({
  selector: 'page-site',
  templateUrl: 'site.html'
})

export class SitePage {

  course: any;

  constructor(public globalStorage:GlobalStorage) {
    globalStorage.getStorage('courseName').then(res =>{
      this.course = res;
      console.log('site page ' + res);
    });
  }
}
