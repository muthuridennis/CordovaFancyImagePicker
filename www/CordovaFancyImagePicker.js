var exec = require('cordova/exec');

exports.selectPhotos = function(arg0, success, error) {
    exec(success, error, "CordovaFancyImagePicker", "selectPhotos", [arg0]);
};
