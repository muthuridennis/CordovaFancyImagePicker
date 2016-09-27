var exec = require('cordova/exec');

var cordovaFancyImagePicker = {};

cordovaFancyImagePicker.getPhotos = function(arg0, success, error) {
    // exec(success, error, "CordovaFancyImagePicker", "selectPhotos", [arg0]);
    exec(success, error, "CordovaFancyImagePicker", "selectPhotos", [arg0]);
};

module.exports = cordovaFancyImagePicker;