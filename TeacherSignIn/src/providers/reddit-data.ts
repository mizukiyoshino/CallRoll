import {Injectable} from '@angular/core';
import {Http, Headers, RequestOptions} from '@angular/http';
import 'rxjs/add/operator/map';
import {resolveDep} from "@angular/core/src/view/provider";
/*
 Generated class for the RedditData provider.

 See https://angular.io/docs/ts/latest/guide/dependency-injection.html
 for more info on providers and Angular 2 DI.
 */
@Injectable()
export class RedditData {
  // const
  // hurl = 'http://17p4n01859.iok.la:15814';
  hurl = 'http://868179d8.ngrok.io';

  constructor(public http: Http) {
    console.log('Hello SignInData Provider');
  }

  getJsonData() {
    let url = this.hurl + '/shhTest/personnelaction/getAllPersonnelHql';
    return this.http.get(url).map(res => res.json());
  }

  postLogin(id, password) {
    let url = this.hurl + '/shhTest/personnelaction/CheckPersonnel?id=' + id + '&password=' + password;
    return this.http.get(url).map(res => res.json());
  }

  getPersonById(id) {
    let url = this.hurl + '/shhTest/personnelaction/getPersonnelByID?id=' + id;
    return this.http.get(url).map(res => res.json());
  }
  getCallTheRollByID(id) {
    let url = this.hurl + '/shhTest/calltherollaction/getCallTheRollByID?id=' + id;
    return this.http.get(url).map(res => res.json());
  }
  getCallTheRollByIDAndCoursename1(id,coursename){
    let url = this.hurl + '/shhTest/calltherollaction/getCallTheRollByIDAndCoursenameHql?id='+id+'&coursename=' + coursename;
    return this.http.get(url).map(res => res.json());
  }
  getCallTheRollBetweenDateHql(bcalldate,acalldate)
  {
    let url=this.hurl+'/shhTest/calltherollaction/getCallTheRollBetweenDateHql?bcalldate='+bcalldate+'&acalldate='+acalldate;
    return this.http.get(url).map(res=>res.json());
  }
  getCourseByNameHql(coursrname) {
    let url = this.hurl + '/shhTest/courseaction/getCourseByName?coursename=' +coursrname;
    return this.http.get(url).map(res => res.json());
  }
  getAllCourseHql() {
    let url = this.hurl + '/shhTest/courseaction/getAllPersonnelHql';
    return this.http.get(url).map(res => res.json());
  }
  updateCourse(oldcoursename,coursename,dailyweight,finalweight,picketline,classsession,classlocation,classdate,classorder,id,shape){

let url=this.hurl+'/shhTest/courseaction/updateCourse?oldcoursename='+oldcoursename+'&coursename='+coursename+'&dailyweight='+dailyweight+'&finalweight='+finalweight+'&picketline='+picketline+'&classsession='+classsession+'&classlocation='+classlocation+'&classdate='+classdate+'&classorder='+classorder+'&id='+id+'&shape='+shape;
    return this.http.get(url).map(res => res.json());
  }
  getMarkByName(courseName){
    let url=this.hurl+'/shhTest/markaction/getMarkByName?courseName='+courseName;
    return this.http.get(url).map(res => res.json());
  }
  updateMark(id,courseName,dailyScore,finalScore){
    let url=this.hurl+'/shhTest/markaction/updateMark?id='+id+'&courseName='+courseName+'&dailyScore='+dailyScore+'&finalScore='+finalScore;
    return this.http.get(url).map(res => res.json());
  }
  getMarkByNameAndID(id,courseName){
    let url=this.hurl+'/shhTest/markaction/getMarkByNameAndID?id='+id+'&courseName='+courseName;
    return this.http.get(url).map(res => res.json());
  }
  countAllCallTheRoll(coursename){
    let url=this.hurl+'/shhTest/calltherollaction/countAllCallTheRoll?coursename='+coursename;
    return this.http.get(url).map(res => res.json());
  }
  callOverByCoursenameAndDate(coursename){
    let url=this.hurl+'/shhTest/calltherollaction/callOverByCoursenameAndDate?coursename='+coursename;
    return this.http.get(url).map(res => res.json());
  }
  createQuestion(score,ID,courseName){
    let url=this.hurl+'/shhTest/questionaction/createQuestion?score='+score+'&ID='+ID+'&courseName='+courseName;
    return this.http.get(url).map(res => res.json());
  }
  updateCallTheRoll(autoid,callstate,coursename,calldate,callposition,id){
    let url=this.hurl+'/shhTest/calltherollaction/updateCallTheRoll?autoid='+autoid+'&callstate='+callstate+'&calldate='+calldate+'&callposition='+callposition+'&coursename='+coursename+'&id='+id;
    console.log(url);
    return this.http.get(url).map(res => res.json());
  }
  updateCallTheRollHH(){
    let url=this.hurl+'/shhTest/calltherollaction/updateCallTheRoll?autoid=0&callstate=1&calldate=2017-06-29&callposition=5*2&coursename=电子技术&id=160327101';
    return this.http.get(url).map(res => res.json());
  }
  getCallTheRollBetweenDateAndCoursename(bcalldate,acalldate,coursename)
  {
    let url=this.hurl+'/shhTest/calltherollaction/getCallTheRollBetweenDateAndCoursename?bcalldate='+bcalldate+'&acalldate='+acalldate+"&coursename="+coursename;
    return this.http.get(url).map(res=>res.json());
  }
  getCourseByIDHql(id){
    let url=this.hurl+'/shhTest/courseaction/getCourseByIDHql?id='+id;
    return this.http.get(url).map(res => res.json());
  }
  getPersonnelByID(id){
    let url=this.hurl+'/shhTest/personnelaction/getPersonnelByID?id='+id;
    return this.http.get(url).map(res => res.json());
  }
  }
