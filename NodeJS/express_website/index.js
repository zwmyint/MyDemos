var express = require('express');
var path = require('path');
var bodyParser = require('body-parser');

var app = express();
app.use(bodyParser.json());
app.use(bodyParser.urlencoded({ extended: false }));
app.use(express.static(path.join(__dirname, 'public')));

app.set('views', path.join(__dirname, 'views'));


app.set('view engine', 'pug');

app.use(bodyParser.json());
app.use(bodyParser.urlencoded({ extended: false }));

app.listen(3000);
console.log('Server is running on port 3000');

var print_info = function(msg) {
    console.log('----' + msg + '----');
};

var print_debug = function(msg) {
    console.log('====' + msg + '====');
};



app.get('/', function(req, res) {
    print_info('index html');
    //res.send('<h1>Hello World</h1>');

    var param = {
        "title": "JackGui"
    };

    res.render('index', param);
});

app.get('/about', function(req, res) {
    print_info('about html');

    res.render('about');
});

app.get('/contact', function(req, res) {
    print_info('contact html');
    res.render('contact');
});

app.post('/contact/send', function(req, res) {
    print_debug(req.body.name);
    print_debug(req.body.email);
    print_debug(req.body.message);
    print_info('contact form submit!!!');
});