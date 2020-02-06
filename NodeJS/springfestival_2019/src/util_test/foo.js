const util = require('util');

async function fn() {
  return 'hello world';
}

const callbackFunction = util.callbackify(fn);

callbackFunction((err, ret) => {
  if (err) throw err;
  console.log(ret);
});



const debuglog = util.debuglog('com.wait.play');

debuglog('hello from foo [%d]', 123);



var student = {
  "name" : "yun",
  "age": 30
}

console.log(util.format("%s, %d, %f, %j \n", "hello", 12, 12.3, student));

console.log(util.formatWithOptions({ colors: true }, 'See object %O', { foo: "42" }));

console.log('\x1B[36m%s\x1B[0m', "Colorful text!");