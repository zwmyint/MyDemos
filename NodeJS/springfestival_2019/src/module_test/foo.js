const circle = require('./circle.js');
console.log('The area of the circle with r = 3 is:', circle.area(3));

console.log(require.main.filename);
console.log(module.filename);
console.log(module.id);
console.log(module.paths);