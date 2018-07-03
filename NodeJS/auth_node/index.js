var sessions = require('express-session');
var express = require('express');
var bodyParser = require('body-parser');
var path = require('path');
var bcrypt = require('bcrypt');

const logUtil = require('./user_modules/logutil');
const redisUtil = require('./user_modules/redisutil');

var app = express();
app.use(bodyParser.json());
app.use(bodyParser.urlencoded({ extended: false }));
app.use(express.static(path.join(__dirname, 'public')));
app.set('views', path.join(__dirname, 'views'));
app.set('view engine', 'pug');
app.use(bodyParser.json());
app.use(bodyParser.urlencoded({ extended: false }));
app.listen(3000);
app.use(sessions({
    secret: 'secret',
    saveUninitialized: true,
    resave: true
}));

logUtil.info('Server is running on port 3000');

app.get('/', function(req, res) {
    logUtil.info('index html');
    res.render('index');
});

app.get('/about', function(req, res) {
    //res.send('<h1>Hello World</h1>');
    if (req.session.name) {
        var param = {
            "name": req.session.name,
            "email": req.session.email
        }
        res.render('about', param);
    } else {
        res.render('signin');
    }

});

app.get('/register', function(req, res) {
    res.render('register');
});

app.get('/signin', function(req, res) {
    logUtil.info('signin html');
    res.render('signin');
});

app.get('/signout', (req, res) => {
    req.session.destroy((err) => {
        if (err) {
            logUtil.error("Destory session error!");
        } else {
            logUtil.debug('Destory session.');
            res.render('signin');
        }

    });
});


app.post('/users/get', (req, res) => {
    var name = req.body.name + ''.trim();
    var planPassword = req.body.password + ''.trim();
    var flag = false;
    //使用hgetall方法返回key所对应的所有字段
    //redis client是异步执行的，因此校验逻辑要放在callback中
    redisUtil.client.hgetall(name, (err, result) => {
        if (result) {
            flag = bcrypt.compareSync(planPassword, result.password);
            if (flag) {
                req.session.name = name;
                req.session.email = result.email;
                var param = {
                    "name": name,
                    "email": result.email
                }
                res.render('about', param);
            } else {
                res.render('signin');
            }
        } else {
            throw err;
        }
    });

});

app.post('/users/post', (req, res) => {
    var name = req.body.name + ''.trim();
    var email = req.body.email + ''.trim();
    var password = req.body.password + ''.trim();
    bcrypt.hash(password, 10, function(err, hash) {
        redisUtil.setUser(name, 'password', hash);
    });
    redisUtil.setUser(name, 'name', name);
    redisUtil.setUser(name, 'email', email);
    res.render('signin');

});