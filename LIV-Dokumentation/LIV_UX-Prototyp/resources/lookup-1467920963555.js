(function(window, undefined) {
  var dictionary = {
    "724d6129-a5ed-4b21-a1a7-3ef200a06710": "Barcode Scanner - yellow",
    "883aed0b-77af-4e79-a3c7-3b701ac93f7d": "Filter",
    "f3a3edb4-1297-4c0d-96d4-2c1ec9870070": "Ampel_red",
    "ed74f470-4343-4380-a864-f8dbad599122": "Barcode Scanner - green",
    "a55013df-bea6-4693-86cc-1c4c6e922cbe": "Barcode Scanner - red",
    "825d8d4d-d97b-4a27-8c53-9894f5e6cd0b": "Impressum",
    "8cbba4f8-8373-40d3-9672-c51ef00654fa": "Datenbank - Produktliste",
    "e92c9fb5-5803-4083-ae7c-cf8c435fc4e2": "Datenbankeintrag",
    "8a638ee1-d936-47c6-b4d7-1fa17ca84294": "Home",
    "95adc887-3e85-4566-95d6-d7b6077c8c85": "Login",
    "7198b126-8045-4499-9acf-878838131f88": "Ampel_green",
    "6f7f7e16-6686-402a-94ad-a2c5a1160750": "AppStart",
    "70cd42b1-78db-4d0f-a724-9ca3d034a4c9": "Barcode Scanner - Abfrage Kamera",
    "c059d41f-6c0e-4b56-a064-91bd05da5a78": "Ampel_yellow",
    "2e9426dc-03b4-4405-9be7-1bc23b03cf97": "Template Barcode",
    "1e8a452c-0c3e-434b-9a69-9f88c989dab1": "Template 1",
    "c5041d43-32bf-4cdb-9123-16f002dfc5d8": "Temp2",
    "default": "default"
  };

  var uriRE = /^(\/#)?(screens|templates|masters|scenarios)\/(.*)(\.html)?/;
  window.lookUpURL = function(fragment) {
    var matches = uriRE.exec(fragment || "") || [],
        folder = matches[2] || "",
        canvas = matches[3] || "",
        name, url;
    if(dictionary.hasOwnProperty(canvas)) { /* search by name */
      url = folder + "/" + canvas;
    }
    return url;
  };

  window.lookUpName = function(fragment) {
    var matches = uriRE.exec(fragment || "") || [],
        folder = matches[2] || "",
        canvas = matches[3] || "",
        name, canvasName;
    if(dictionary.hasOwnProperty(canvas)) { /* search by name */
      canvasName = dictionary[canvas];
    }
    return canvasName;
  };
})(window);