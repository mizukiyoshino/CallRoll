// import { FormBuilder, FormControl, Validator } from '@angular/forms';
import {Component} from '@angular/core';
import {AlertController, App, LoadingController, NavController, IonicPage, ToastController} from 'ionic-angular';
import {HomePage} from "../home/home";
import {RedditData} from '../../providers/reddit-data';
import{GlobalStorage} from '../../providers/global-storage'


@IonicPage()
@Component({
  selector: 'page-login-one',
  templateUrl: './login-one.html',
})
export class LoginOnePage {
  user = {
    name: '',
    pwd: ''
  };
  isPass = '';
  stuInf: any;

  // private usercreds: any;
  // private service: any;
  // private nav: any;
  public loginForm: any;
  public backgroundImage = "assets/img/background/5.jpg";

  constructor(private globalStorage: GlobalStorage, public loginData: RedditData, public toastCtrl: ToastController, private navCtrl: NavController,
              public loadingCtrl: LoadingController, public alertCtrl: AlertController, public app: App) {
  }

  login() {
    let loading = this.loadingCtrl.create({
      duration: 1000
    });

    // this.loginData.getPersonById(this.user.name).subscribe(
    //   res => {
    //     this.stuInf = res.personnel;
    //     this.globalStorage.setStorage('stuId', this.stuInf.ID);
    //     this.globalStorage.getStorage('stuId');
    //     this.globalStorage.setStorage('stuName', this.stuInf.Pname);
    //     this.globalStorage.getStorage('stuName');
    //   }
    // );
    this.globalStorage.setStorage('stuId', this.user.name);

    this.loginData.postLogin(this.user.name, this.user.pwd).subscribe(
      result => {

        this.isPass = result.state;

        if (this.isPass == '1') {
          console.log('setRoot stage');
          loading.present();
          this.navCtrl.setRoot(HomePage);
        }
        else if (this.isPass == '0') {
          let toast = this.toastCtrl.create({
            message: '学号不存在，请确认输入',
            duration: 2000,
            position: 'middle',
            showCloseButton: true,
            closeButtonText: 'OK'
          });
          toast.present();
        }
        else {
          let toast = this.toastCtrl.create({
            message: '密码错误，请重输',
            duration: 2000,
            position: 'middle',
            showCloseButton: true,
            closeButtonText: 'OK'
          });
          toast.present();
        }

        console.log("Success : " + this.isPass);
      },
      err => {
        console.error("Error : " + err);
      },
      () => {
        console.log('postLogin completed');
      }
    );


    console.log(this.user);
    // loading.onDidDismiss(() => {
    //   let alert = this.alertCtrl.create({
    //     title: 'Logged in!',
    //     subTitle: 'Thanks for logging in.',
    //     buttons: ['Dismiss']
    //   });
    //   alert.present();
    // });


  }

  getID() {
    return this.user.name;
  }

  goToSignup() {
    // this.navCtrl.push(SignupPage);
  }

  goToResetPassword() {
    // this.navCtrl.push(ResetPasswordPage);
  }
}
