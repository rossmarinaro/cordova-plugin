// window.echo = function(str, callback) {
//     cordova.exec(callback, function(err) {
//         callback('Nothing to echo.');
//     }, "Echo", "echo", [str]);
// };

class ToastyPlugin {
    constructor() { }
    // The function that passes work along to native shells
    // Message is a string, duration may be 'long' or 'short'
    show(message, duration, successCallback, errorCallback) {
        var options = {};
        options.message = message;
        options.duration = duration;
        cordova.exec(successCallback, errorCallback, 'ToastyPlugin', 'show', [options]);
    }
    // Installation constructor that binds ToastyPlugin to window
    static install() {
        if (!window.plugins) {
            window.plugins = {};
        }
        window.plugins.toastyPlugin = new ToastyPlugin();
        return window.plugins.toastyPlugin;
    }
}


cordova.addConstructor(ToastyPlugin.install);