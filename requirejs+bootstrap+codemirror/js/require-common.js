require.config({
    baseUrl: "../js/lib", //从index.html页面导航到js文件夹
    "paths": {
        "jquery": "jquery.1.11.3.min",
        "codemirror": "codemirror",
        "javascript": "javascript",
        "scheme": "scheme"
    },
    "shim": {
        "jquery": {
            exports: "jquery"
        },
        "codemirror": {
            exports: "codemirror"
        },
        "javascript": {
            exports: "javascript"
        },
        "scheme": {
            exports: "scheme"
        }
    }
});