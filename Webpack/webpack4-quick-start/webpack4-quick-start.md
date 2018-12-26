[webpack4-quick-start](https://www.valentinog.com/blog/webpack-tutorial/)

# Webpack 4 configuration

## 1. Webpack configuration 

1. Create empty project named webpack4-quick-start and move into it

2. Initialize a package.json by running:

```js

npm init -y

```

3. Install webpack and webpack-cli

```js

//3.1 全局安装
npm i webpack -g

//3.2 Local安装

// --save-dev == -D
npm i webpack webpack-cli --save-dev
```

4. Create src/css, src/images, src/js/, src/css folder under the project

5. Create index.html and index.js(Must, because it is the default entry!!!) in src folder.

6. Edit package.json and edit scripts section.

```js

"scripts": {
    "test": "echo \"Error: no test specified\" && exit 1",
    "dev": "webpack --mode development",
    "build": "webpack --mode production"
  },


/*
* 1. Webpack will take the src/index.js as default entry point and take dist/main.js as default bludle output.
* 2. You can follow this to override the default entry point and output.
*/ 

"scripts": {
    "test": "echo \"Error: no test specified\" && exit 1",
    "dev": "webpack --mode development ./foo/src/js/index.js --output ./foo/main.js",
    "build": "webpack --mode development ./foo/src/js/index.js --output ./foo/main.js"
  },

```

7. Create webpack.config.js in the root of webpack4-quick-start folder

## 2. Configure Babel

> Transpiling Javascript ES6 

1. Install

```js

npm i @babel/core babel-loader @babel/preset-env --save-dev

```

2. Create .babelrc in the root of the webpack4-quick-start and edit it.

```js

{
    "presets": [
        "@babel/preset-env"
    ]
}

```

3. Edit webpack.config.js

```js 

module.exports = {
  module: {
    rules: [
      {
        test: /\.js$/,
        exclude: /node_modules/,
        use: {
          loader: "babel-loader" //babel loader
        }
      }
    ]
  }
}

```


## 3. Configure html-webpack-plugin

1. Install

```js

npm i html-webpack-plugin html-loader --save-dev

```

2. Update webpack.config.js

```js

// 1.Import html-webpack-plugin
const HtmlWebPackPlugin = require("html-webpack-plugin");

module.exports = {
  module: {
    rules: [
      {
        test: /\.js$/,
        exclude: /node_modules/,
        use: {
          loader: "babel-loader"
        }
      },
      {
        test: /\.html$/,
        use: [
          {
            loader: "html-loader",
            options: {minimize: true}
          }
        ]
      }
    ]
  },
  plugins: [
    new HtmlWebPackPlugin({
      template: "src/index.html",  //指定模板文件
      filename: "index.html"  //这里只需要指定文件的名字，文件会自动生成在dist目录
    })
  ]
}

```

## 4. Configure webpack dev server

1. Install 

```js

npm i webpack-dev-server --save-dev

```

## 5. Configure css loader with mini-css-extract-plugin

1. Install

```js

npm i mini-css-extract-plugin css-loader --save-dev

```

2. Update rules of webpack.config.js

```js
// 1.Import html-webpack-plugin
const HtmlWebPackPlugin = require("html-webpack-plugin");
const MiniCssExtractPlugin = require("mini-css-extract-plugin");

module.exports = {
  module: {
    rules: [
      {
        test: /\.js$/,
        exclude: /node_modules/,
        use: {
          loader: "babel-loader"
        }
      },
      {
        test: /\.html$/,
        use: [
          {
            loader: "html-loader",
            options: {minimize: true}
          }
        ]
      },
      { //Css loader
        test: /\.css$/,
        use: [MiniCssExtractPlugin.loader, "css-loader"]
      }
    ]
  },
  plugins: [
    new HtmlWebPackPlugin({
      template: "src/index.html",  //指定模板文件
      filename: "index.html"  //这里只需要指定文件的名字，文件会自动生成在dist目录
    }),
    new MiniCssExtractPlugin({ //Css loader
      filename: "[name].css",
      chunkFilename: "[id].css"
    })
  ]
}


```

3. Update src/index.js 

```js

import "./css/index.css"

```

## 6. Configure url loader  (png|jpg|gif|woff(2)|ttf|eot|svg)

1. Install

```js

npm install url-loader file-loader --save-dev

```

2. update webpack.config.js

```js

rules: [
      {
        test: /\.(png|jpg|gif)$/i,
        use: [
          {
            loader: 'url-loader',
            options: {
              limit: 8192
            }
          }
        ]
      }
    ]

```

## 7. (Optional) Install bootstrap4

1. Install

```js

npm install bootstrap jquery popper.js -D

```

2. Import bootstrap in src/index.js

```js

//import jquery
import $ from "jquery"

//import bootstrap javascript
import 'bootstrap'

//import bootstrap style
import 'bootstrap/dist/css/bootstrap.min.css'

```

8. (Optional) font-awesome



