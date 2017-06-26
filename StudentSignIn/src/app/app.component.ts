import {Component, ViewChild} from '@angular/core';
import {Nav, Platform} from 'ionic-angular';
import {StatusBar} from '@ionic-native/status-bar';
import {SplashScreen} from '@ionic-native/splash-screen';


import {HomePage} from '../pages/home/home';
import {ListPage} from '../pages/list/list';
import {LoginOnePage} from '../pages/login-one/login-one'
import {RedditData} from '../providers/reddit-data';
import{GlobalStorage} from '../providers/global-storage'

@Component({
  templateUrl: 'app.html'
})
export class MyApp {
  @ViewChild(Nav) nav: Nav;

  rootPage: any = HomePage; //LoginOnePage

  pages: Array<{title: string, component: any}>;

  // Name: any;
  // Id: any;


  constructor(private globalStorage: GlobalStorage, private personData: RedditData,
              public platform: Platform, public statusBar: StatusBar, public splashScreen: SplashScreen) {
    this.initializeApp();

    // used for an example of ngFor and navigation
    this.pages = [
      {title: '首页', component: HomePage},
      {title: '请假旷课记录', component: ListPage},
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

  // ionViewDidLoad() {
  //   this.globalStorage.getStorage('stuId').then((res) => {
  //     console.log('app page: ' + res);
  //     // this.personData.getPersonById(res).subscribe(
  //     //   result => {
  //     //     this.Name = result.personnel.Pname;
  //     //     this.Id = result.personnel.ID;
  //     //   }
  //     // )
  //   });
  // }
}
