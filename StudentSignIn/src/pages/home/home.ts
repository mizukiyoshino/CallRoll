import {Component} from '@angular/core';
import {NavController} from 'ionic-angular';
import {PositionPage} from "../position/position";
import{GlobalStorage} from '../../providers/global-storage'

@Component({
  selector: 'page-home',
  templateUrl: 'home.html'
})
export class HomePage {
  stuInf: any;

  courses: Array<string>;

  constructor(private globalStorage: GlobalStorage, public navCtrl: NavController) {
    this.courses = ['工程训练', '分布式数据库', '软件体系结构', '专业英语'];
    this.globalStorage.getStorage('stuId').then((res) => {
      this.stuInf = res;
      console.log('home page: ' + this.stuInf);
    });

  }

  courseSelected(course) {
    this.navCtrl.push(PositionPage)
  }

}
