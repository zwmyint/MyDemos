var redis = require('redis');
const logUtil = require('./logutil');
const host = '9.30.160.68';
const port = 6379;
var client = redis.createClient(port, host);

client.on('connect', function() {
    logUtil.info('Redis client connected');
});

client.on('error', function(err) {
    logUtil.error('Something went wrong ' + err);
});

exports.client = client;

exports.getUser = (key, property) => {
    client.hget(key, property, (error, result) => {
        if (error) {
            logUtil.error(error);
            throw error;
        } else {
            logUtil.debug('here!!!!!!!!!!!!!');
            logUtil.debug(result);
            return result;
        }

    });
}

exports.setUser = (key, property, value) => {
    client.hset(key, property, value, (error, result) => {
        if (error) {
            logUtil.error(error);
            throw error;
        }
        logUtil.debug(result);
    });
}