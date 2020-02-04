const net = require('net');

const server = net.createServer((c) => {
    c.on('end', () => {
        console.log('client disconnected.');
    });
    c.on('data', function(data) {
        console.log('receive from client: ', data.toString());
        c.write(data.toString());
    });
});

server.listen(8080, () => {
    console.log('Server start on port 8080.');
});

