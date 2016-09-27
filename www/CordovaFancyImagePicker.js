var exec = require('cordova/exec');

var cordovaFancyImagePicker = {};

cordovaFancyImagePicker.getPhotos = function(arg0, success, error) {
   	console.log("arg0 >>>>>> getPhotos", arg0, cordova.exec);
    exec(success, error, "CordovaFancyImagePicker", "selectPhotos", [arg0]);
};

module.exports = cordovaFancyImagePicker;