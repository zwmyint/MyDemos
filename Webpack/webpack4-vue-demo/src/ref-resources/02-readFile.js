const fs = require('fs');
const path = require('path');

//Get file content by path
var readFileByPath = function (path, successCallback, failCallback) {
  fs.readFile(path, 'utf-8', (err, data) => {
    if (err) {
      failCallback(err);
    } else {
      successCallback(data);
    }
  });
}

//读取多个文件，并且想保持读取文件的顺序，可以通过嵌套调用的方式，不过这会造成代码结构不够温雅
readFileByPath(path.join(__dirname, './1.txt'), function (data) {
  console.log('Success! ' + data);
  readFileByPath(path.join(__dirname, './2.txt'), function (data) {
    console.log('Success! ' + data);
    readFileByPath(path.join(__dirname, './3.txt'), function (data) {
      console.log('Success! ' + data);
    }, function (err) {
    })
  }, function (err) {
  })

}, function (err) {
  console.log('Failed! ' + err.message);
});


