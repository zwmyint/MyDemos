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