// window.echo = function(str, callback) {
//     cordova.exec(callback, function(err) {
//         callback('Nothing to echo.');
//     }, "Echo", "echo", [str]);
// };

// Empty constructor
// function toasty() {}

// // The function that passes work along to native shells
// // Message is a string, duration may be 'long' or 'short'
// toasty.prototype.show = function(message, duration, successCallback, errorCallback) {
//   var options = {};
//   options.message = message;
//   options.duration = duration;
//   cordova.exec(successCallback, errorCallback, 'Toasty', 'show', [options]);
// }

// // Installation constructor that binds toasty to window
// toasty.install = function() {
//   if (!window.plugins) {
//     window.plugins = {};
//   }
//   window.plugins.toasty = new toasty();
//   return window.plugins.toasty;
// };
// cordova.addConstructor(toasty.install);

function initial(){
  cordova.exec(successCallback, errorCallback, 'Toasty', 'show', [options]);
}
function successCallback(data){
  alert(data);
}
function errorCallback(data){
  alert(data);
}

