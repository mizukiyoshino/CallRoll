import {Component} from '@angular/core';
// import {FormGroup, FormControl} from '@angular/forms';
import {NavParams, NavController,LoadingController, ToastController} from 'ionic-angular';
import {RedditData} from '../../providers/reddit-data';
import {SitePage} from "../site/site";
import {GlobalStorage} from '../../providers/global-storage'

@Component({
  selector: 'page-position',
  templateUrl: 'position.html'
})
export class PositionPage {
  // langs;
  // langForm;
  // newsData: any;
  // isTrue: any;

  homeItem: any;

  constructor(public toastCtrl: ToastController, public loadingCtrl: LoadingController,public globalStorage:GlobalStorage,
              public navCtrl: NavController, public navParams: NavParams, public redditService: RedditData) {
    // this.langForm = new FormGroup({
    //   "langs": new FormControl({value: 'rust', disabled: false})
    // });
    // this.redditService.getJsonData().subscribe(
    //   res => {
    //     this.newsData = res.personnels;
    //   }
    // );

    this.homeItem = navParams.get('item');
    // console.log('position page con 1' + this.homeItem.cnameAndID.courseName);
    globalStorage.setStorage('courseName', this.homeItem.cnameAndID.courseName);
    // globalStorage.getStorage('courseName').then(res => {
    //   console.log('position page con 2 ' + res);
    // })
  }

  // doSubmit(event) {
  //   console.log('Submitting form', this.langForm.value);
  //   event.preventDefault();
  // }

  ionViewDidLoad() {
    // this.redditService.getJsonData().subscribe(
    //   result => {
    //     for (let item of result.personnels) {
    //       this.newsData.push(item)
    //     }
    //     // console.log("position page jsondata Success : " + result.personnels[0].Pname);
    //     // console.log("position page jsondata Success : " + this.newsData);
    //   },
    //   err => {
    //     console.error("Error : " + err);
    //   },
    //   () => {
    //     console.log('position page getData completed');
    //   }
    // );
    //
    // this.redditService.postLogin('1', '1').subscribe(
    //   result => {
    //
    //     this.isTrue = result.state;
    //
    //     console.log("position Success : " + this.isTrue);
    //   },
    //   err => {
    //     console.error("Error : " + err);
    //   },
    //   () => {
    //     console.log('postLogin completed');
    //   }
    // );
  }

  choseSiteSign() {

    this.navCtrl.push(SitePage);
  }

  askForLeave() {
    let loading = this.loadingCtrl.create({
      duration: 1000
    });
    this.globalStorage.getStorage('stuId').then(res => {

      this.redditService.updateCallTheRoll(res, '0*0', this.homeItem.cnameAndID.courseName, 2).subscribe(r => {
        if(r.state == '1') {
          let toast = this.toastCtrl.create({
            message: '请假申请成功',
            duration: 1500,
            position: 'bottom',
          });
          toast.present();
          loading.present();
        }
        else {
          let toast = this.toastCtrl.create({
            message: r.state,
            duration: 1500,
            position: 'middle',
          });
          toast.present();
          loading.present();
        }
      });
    });

    // let toast = this.toastCtrl.create({
    //   message: '请假申请成功',
    //   duration: 1500,
    //   position: 'bottom',
    // });
    // toast.present();
    // loading.present();
    // console.log('position page askForLeave ' + this.homeItem.cnameAndID.courseName);
  }
}
