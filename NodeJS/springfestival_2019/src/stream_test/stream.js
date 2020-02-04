const assert = require('assert');
const fs = require('fs');
const kSource = Symbol('source');


//Write stream
const fileWs = fs.createWriteStream('./foo.txt');
fileWs.write('some data. \r\n');
//fileWs.end('end writing.');
fileWs.on('finish', () => {
    console.log('finish writing.');
});


const fileRs = fs.createReadStream('./test.txt');
fileRs.setEncoding('utf-8');
//pipe
fileWs.on('pipe', (src) => {
    console.log("Something is piping into writer.");
    assert.equal(src, fileRs);
});
//fileWs can not be end!!!
fileRs.pipe(fileWs);

//unPipe
//fileRs.unpipe(fileWs);

//read 

fileRs.on('data', (chunk)=> {
    console.log(`Received ${chunk.length} bytes of data.`);
    console.log(chunk);
});

fileRs.on('end', ()=> {
    console.log('finish reading.');
});



