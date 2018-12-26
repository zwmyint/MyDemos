// 1.Import html-webpack-plugin
const HtmlWebPackPlugin = require("html-webpack-plugin");
const MiniCssExtractPlugin = require("mini-css-extract-plugin");
const VueLoaderPlugin = require('vue-loader/lib/plugin');

module.exports = {
  module: {
    rules: [
      {
        test: /\.js$/i,
        exclude: /node_modules/,
        use: {
          loader: "babel-loader"
        }
      },
      {
        test: /\.html$/i,
        use: [
          {
            loader: "html-loader",
            options: {minimize: true}
          }
        ]
      },
      { //Css loader
        test: /\.css$/i,
        use: [MiniCssExtractPlugin.loader, "css-loader"]
      },
      {
        //Url loader
        test: /\.(png|jpg|jpeg|gif)$/i,
        use: [
          {
            loader: "url-loader",
            options: {
              limit: 8192  //当文件的size小于这个数值时，将返回一个base64 str
            }
          }
        ]
      },
      {
        test: /\.woff(2)?(\?v=[0-9]\.[0-9]\.[0-9])?$/i,
        loader: "url-loader?limit=10000&mimetype=application/font-woff" 
      },
      {
        test: /\.(ttf|eot|svg)(\?v=[0-9]\.[0-9]\.[0-9])?$/i,
        loader: "file-loader" 
      },
      {
        test: /\.vue$/,
        loader: 'vue-loader'
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
    }),
    new VueLoaderPlugin()
  ],
  resolve: {
    alias: {
      // "vue$" : "vue/dist/vue.common.dev"  不推荐使用
    }
  }
  
}