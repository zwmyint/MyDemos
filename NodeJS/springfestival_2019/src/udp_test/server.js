const dgram = require('dgram');
const server = dgram.createSocket('udp4');


server.on('error', (err) => {
  console.log(`server error:\n ${err.stack}`);
  server.close();
});

server.on('message', (msg, rinfo) => {
  console.log(`server got: ${msg} from ${rinfo.address}:${rinfo.port}`);
  
  server.send('hello from server!', rinfo.port, rinfo.address, (err, bytes)=> {
    console.log(err);
    console.log(bytes);
  });
});


server.on('listening', () => {
  const address = server.address();
  console.log(`server listening ${address.address}:${address.port}`);
});

server.bind(41234);