var ExtractTextPlugin = require("extract-text-webpack-plugin");

module.exports = {
  entry: __dirname+"/app.js",
  output: {
    path: __dirname+"/dist",
    filename: "bundle.js"
  },
  module: {
    loaders: [
      {
        test: /\.jsx?$/,
        loader: 'babel-loader',
        exclude: /node_modules/,
        query: {
          presets: ['react','es2015']
        }
      },
      { test: /\.css$/, loader: "style-loader!css-loader" },
      {
        test: /\.(png|jpg|jpeg|gif|svg|woff|woff2|ttf|eot)$/,
        loader: 'file-loader'
      },
      
    ]
  },
  resolve: {
    extensions: ['.coffee','.js']
  },
  watch: true
}