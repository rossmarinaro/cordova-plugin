

exports.showToast = function (arg0) {
    cordova.exec(null, null, 'hello', 'showToast', [arg0]);
};
