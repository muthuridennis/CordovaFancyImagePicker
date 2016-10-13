 module.exports = {
  getPhotos: function(args, successCallback, errorCallback) {
  	var selectionLimit = args.selectionLimit || 5;

  	var args = [selectionLimit];
  	
    cordova.exec(successCallback,
                 errorCallback, // No failure callback
                 "CordovaFancyImagePicker",
                 "selectPhotos",
                 args);
  }
};