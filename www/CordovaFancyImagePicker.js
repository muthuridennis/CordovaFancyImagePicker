var exec = require('cordova/exec');

var cordovaFancyImagePicker = {};

cordovaFancyImagePicker.selectPhotos = function(arg0, success, error) {
		console.log("exec >>> ", exec);
    exec(success, error, "CordovaFancyImagePicke", "selectPhotos", [arg0]);
};

module.exports = cordovaFancyImagePicker;