var exec = require('cordova/exec');

var cordovaFancyImagePicker = {};

cordovaFancyImagePicker.selectPhotos = function(arg0, success, error) {
    exec(success, error, "CordovaFancyImagePicker", "selectPhoto", [arg0]);
};

module.exports = cordovaFancyImagePicker;