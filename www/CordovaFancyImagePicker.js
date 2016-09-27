var exec = require('cordova/exec');

var CordovaFancyImagePicker = {};

CordovaFancyImagePicker.selectPhotos = function(arg0, success, error) {
    exec(success, error, "CordovaFancyImagePicker", "selectPhotos", [arg0]);
};

module.exports = CordovaFancyImagePicker;