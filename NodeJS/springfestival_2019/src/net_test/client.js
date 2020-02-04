const net = require('net');

const client = net.createConnection({port:8080}, ()=> {
    console.log('Connect to localhost:8080');
    client.write('hello server!....', 'utf-8');
});


client.on('data', function(data) {
    console.log('receive from server: ', data.toString());
});

client.on('end', () => {
    console.log('disconnected from server');
});

