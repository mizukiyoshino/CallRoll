import {BrowserModule} from '@angular/platform-browser';
import {ErrorHandler, NgModule} from '@angular/core';
import {IonicApp, IonicErrorHandler, IonicModule} from 'ionic-angular';
import { HttpModule } from '@angular/http';
import {IonicStorageModule} from '@ionic/storage'

import {MyApp} from './app.component';
import {HomePage} from '../pages/home/home';
import {ListPage} from '../pages/list/list';
import {LoginOnePage} from "../pages/login-one/login-one";
import {SitePage} from '../pages/site/site';

import {StatusBar} from '@ionic-native/status-bar';
import {SplashScreen} from '@ionic-native/splash-screen';
import {PositionPage} from "../pages/position/position";
import { RedditData} from '../providers/reddit-data';
import {GlobalStorage} from '../providers/global-storage'


@NgModule({
  declarations: [
    MyApp,
    LoginOnePage,
    HomePage,
    ListPage,
    PositionPage,
    SitePage
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
    PositionPage,
    SitePage
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
