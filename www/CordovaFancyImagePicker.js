 module.exports = {
  getPhotos: function(arg0, successCallback, errorCallback) {
    cordova.exec(successCallback,
                 errorCallback, // No failure callback
                 "CordovaFancyImagePicker",
                 "selectPhotos",
                 [arg0]);
  }
};