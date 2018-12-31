const fs = require('fs');
const path = require('path');


// Section -1 
// var getFileByPath = function(path){
//   return new Promise(function(resolve, reject){
//     fs.readFile(path, 'utf-8', (err, data)=>{
//       if(err) {
//         reject(err);
//       } else {
//         resolve(data);
//       }
//     });
//   });
// };

// getFileByPath("./11.txt").then(data=>{
//   console.log(data);
// }, err=> {
//   console.log(err.message);
// });

// section -2 顺序读取三个文件

// var getFileByPath = function(path) {
//   return new Promise(function(resolve, reject) {
//     fs.readFile(path, 'utf-8', (err, data)=>{
//       if(err) {
//         reject(err);
//       }else {
//         resolve(data);
//       }
//     });
//   });
// }

// //恶心的三层嵌套，有没有？？？
// getFileByPath("./1.txt").then(data=>{
//   console.log(data);
//   getFileByPath("./2.txt").then(data=> {
//     console.log(data);
//     getFileByPath("./3.txt").then(data=>{
//       console.log(data);
//     }, err=> {});
//   }, err=>{});
// }, err=>{});

// Section -3

var getFileByPath = function(path){
  return new Promise(function(resolve, reject){
    fs.readFile(path, 'utf-8', (err, data)=>{
      if(err) {
        reject(err);
      } else {
        resolve(data);
      }
    });
  });
}
//在上一个then()中返回一个Promises实例，可以继续使用then()处理后面的逻辑
// getFileByPath("./1.txt").then(data=>{
//   console.log(data);
//   return getFileByPath("./2.txt");
// }, err=>{
//   // 不管前面的promise是否成功，都继续走下去，就在err中return一个新的promise
//   //return getFileByPath("./2.txt");
// }).
// then(data=>{
//   console.log(data);
//   return getFileByPath("./3.txt");
// }, err=> {}).
// then(data=>{
//   console.log(data);
// }, err=>{});

//Section -5
//使用catch方法捕获then中的异常，任何一个then中的异常都会阻止后面then方法的继续执行
getFileByPath("./1.txt").then(data=> {
  console.log(data);
  return getFileByPath("./2.txt");
}).then(data=>{
  console.log(data);
  return getFileByPath("./33.txt");
}).then(data=>{
  console.log(data);
}).catch(err=>{
  console.log(err.message)
});