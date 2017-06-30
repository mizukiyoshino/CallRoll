import {Component, ViewChild} from '@angular/core';
import {Nav, Platform} from 'ionic-angular';
import {StatusBar} from '@ionic-native/status-bar';
import {SplashScreen} from '@ionic-native/splash-screen';


import {HomePage} from '../pages/home/home';
import {ListPage} from '../pages/list/list';
import {CallRollPage} from '../pages/callroll/callroll';
import {LoginOnePage} from '../pages/login-one/login-one'
import {HistoryPage} from '../pages/history/history'
import {CoursePage} from '../pages/course/course'
import {MarkPage} from '../pages/mark/mark'
import {PersonPage} from '../pages/person/person'
import {ClassPage} from '../pages/class/class'
import {CountPage} from '../pages/count/count'
import {PositionPage} from '../pages/position/position'
import { RedditData } from '../providers/reddit-data';


@Component({
  templateUrl: 'app.html'
})
export class MyApp {
  @ViewChild(Nav) nav: Nav;

  // rootPage: any =HomePage; //LoginOnePage
  rootPage: any =LoginOnePage;
  pages: Array<{title: string, component: any}>;





  constructor(public personData:RedditData,
              public platform: Platform, public statusBar: StatusBar, public splashScreen: SplashScreen) {
    this.initializeApp();

    // used for an example of ngFor and navigation
    this.pages = [
      {title: '首页', component: HomePage},
      {title:'设置签到',component:PositionPage},
      {title:'设置课程',component:CoursePage},
      {title:'设置成绩',component:MarkPage},
      {title: '查看考勤历史', component: HistoryPage},
      {title:'查看人员信息',component:PersonPage},
      {title:'查看班级信息',component:ClassPage},
      {title:'查看统计信息',component:CountPage},
      {title: '登出', component: LoginOnePage}
    ];

  }

  initializeApp() {
    this.platform.ready().then(() => {
      // Okay, so the platform is ready and our plugins are available.
      // Here you can do any higher level native things you might need.
      this.statusBar.styleDefault();
      this.splashScreen.hide();
    });
  }

  openPage(page) {
    // Reset the content nav to have just this page
    // we wouldn't want the back button to show in this scenario
    this.nav.setRoot(page.component);
  }

}
