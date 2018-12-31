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

var filePath = path.join(__dirname, './11.txt');
readFileByPath(filePath, function(data) {
  console.log('Success! ' + data);
}, function(err){
  console.log('Failed! ' + err.message);
});


