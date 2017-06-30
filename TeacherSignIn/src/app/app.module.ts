import {BrowserModule} from '@angular/platform-browser';
import {ErrorHandler, NgModule} from '@angular/core';
import {IonicApp, IonicErrorHandler, IonicModule} from 'ionic-angular';
import { HttpModule } from '@angular/http';
import {IonicStorageModule} from '@ionic/storage'

import {MyApp} from './app.component';
import {HomePage} from '../pages/home/home';
import {ListPage} from '../pages/list/list';
import {CallRollPage} from '../pages/callroll/callroll';
import {LoginOnePage} from "../pages/login-one/login-one";
import {HistoryPage} from "../pages/history/history";
import {CoursePage} from "../pages/course/course";
import {MarkPage} from "../pages/mark/mark";
import {PersonPage} from "../pages/person/person";
import {ClassPage} from '../pages/class/class';
import {CountPage} from '../pages/count/count';
import {PositionPage} from "../pages/position/position";

import {StatusBar} from '@ionic-native/status-bar';
import {SplashScreen} from '@ionic-native/splash-screen';
import { RedditData} from '../providers/reddit-data';
import {GlobalStorage} from '../providers/global-storage'


@NgModule({
  declarations: [
    MyApp,
    LoginOnePage,
    HomePage,
    ListPage,
    CallRollPage,
    PositionPage,
    HistoryPage,
    CoursePage,
    MarkPage,
    PersonPage,
    ClassPage,
    CountPage
  ],
  imports: [
    BrowserModule,
    IonicModule.forRoot(MyApp),
    HttpModule,
    IonicStorageModule.forRoot()
  ],
  bootstrap: [IonicApp],
  entryComponents: [
    MyApp,
    LoginOnePage,
    HomePage,
    ListPage,
    CallRollPage,
    PositionPage,
    HistoryPage,
    CoursePage,
    MarkPage,
    PersonPage,
    ClassPage,
    CountPage
  ],
  providers: [
    StatusBar,
    SplashScreen,
    {provide: ErrorHandler, useClass: IonicErrorHandler},
    RedditData,
    GlobalStorage
  ]
})
export class AppModule {
}
