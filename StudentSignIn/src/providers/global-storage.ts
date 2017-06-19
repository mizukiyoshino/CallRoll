import { Injectable } from '@angular/core';
import 'rxjs/add/operator/map';
import { Storage } from '@ionic/storage';

@Injectable()
export class GlobalStorage {

  constructor(
    private storage: Storage) {
    console.log('Hello GlobalStorage Provider');
  }

  setStorage(key, val) {
    this.storage.set(key, val);
  }

  getStorage(key) {
    return this.storage.get(key);
    //   .then((val) => {
    //   console.log('globalstorage return is ', val);
    // });
  }
}
