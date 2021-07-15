

exports.showToast = function (string) {
    cordova.exec(null, null, 'hello', 'showToast', string);
};
