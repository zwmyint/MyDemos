const fs = require('fs');
const path = require('path');


//Section - 1
//Promise 中的方法在创建promise之后会立即执行
// var promise = new Promise(
//   function() {
//     fs.readFile(path.join(__dirname,"./1.txt"),'utf-8', (err, data)=>{
//       if(err) throw err;
//       console.log(data);
//     })
//   }
// );


// Section -2
//将Promise的逻辑放在方法中，通过方法调用决定什么时候执行异步的逻辑。
// var getFileByPath = function (path) {
//   var promise = new Promise(
//     function () {
//       fs.readFile(path, 'utf-8', (err, data) => {
//         if (err) throw err;
//         console.log(data);
//       })
//     }
//   );
// }

// getFileByPath(path.join(__dirname, './1.txt'));

// Section -3

//读取文件并返回文件的内容

var getFileByPath = function(path){
  var promise = new Promise(function(resolve, reject){
    fs.readFile(path, 'utf-8', (err, data)=>{
      if(err) {
        reject(err);
      } else {
        resolve(data);
      }
    })
  });
  return promise;
}

var p = getFileByPath('./1.txt');
p.then(function(data){
  //对应resolve 回调
  console.log(data);
}, function(err){
  //对应reject回调
  console.log(err.message);
});

