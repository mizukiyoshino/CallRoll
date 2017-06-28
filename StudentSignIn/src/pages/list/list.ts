import {Component} from '@angular/core';
import {NavController, NavParams} from 'ionic-angular';
import {GlobalStorage} from '../../providers/global-storage'
import {RedditData} from '../../providers/reddit-data'
import {KaoqinPage} from "../kaoqin/kaoqin";

@Component({
  selector: 'page-list',
  templateUrl: 'list.html'
})
export class ListPage {
  // selectedItem: any;
  // icons: string[];
  // items: Array<{title: string, note: string, icon: string}>;
  calltherolls: any;

  constructor(public absentData: RedditData, public globalStorage: GlobalStorage, public navCtrl: NavController, public navParams: NavParams) {
    // If we navigated to this page, we will have an item available as a nav param
    // this.selectedItem = navParams.get('t');

    // Let's populate this page with some filler content for funzies
    // this.icons = ['flask', 'wifi', 'beer', 'football', 'basketball', 'paper-plane',
    // 'american-football', 'boat', 'bluetooth', 'build'];
    //
    // this.items = [];
    // for (let i = 1; i < 11; i++) {
    //   this.items.push({
    //     title: '请假/旷课 ' + i,
    //     note: '事由' + i,
    //     icon: this.icons[Math.floor(Math.random() * this.icons.length)]
    //   });
    // }
    globalStorage.getStorage('stuId').then(res => {
      absentData.getCallTheRollByID(res).subscribe(result => {
        this.calltherolls = result.callTheRolls;
      })
    });
  }

  // itemTapped(event, item) {
  //   // That's right, we're pushing to ourselves!
  //   this.navCtrl.push(ListPage, {
  //     t: item
  //   });
  // }
  gotoKaoqin() {
    this.navCtrl.push(KaoqinPage);
  }
}
