 module.exports = {
  getPhotos: function(arg0, successCallback, errorCallback) {
  	var maxImages = arg0.maxImages || 5;
  	var quality = arg0.quality || 10;

    cordova.exec(successCallback,
                 errorCallback, // No failure callback
                 "CordovaFancyImagePicker",
                 "selectPhotos",
                 [maxImages, quality]);
  }
};