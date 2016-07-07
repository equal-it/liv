function initData() {
  jimData.variables["ProductList"] = "";
  jimData.datamasters["ProductList"] = [
    {
      "id": 1,
      "datamaster": "ProductList",
      "userdata": {
        "Produktname": "Nutella",
        "EAN": "8000500093641",
        "Laktose": "true",
        "Gluten": "false",
        "Nuss": "true"
      }
    },
    {
      "id": 2,
      "datamaster": "ProductList",
      "userdata": {
        "Produktname": "Griesson Soft Cake Orange",
        "EAN": "4001518000267",
        "Laktose": "false",
        "Gluten": "true",
        "Nuss": "true"
      }
    },
    {
      "id": 3,
      "datamaster": "ProductList",
      "userdata": {
        "Produktname": "müller - Milchreis Erdbeere",
        "EAN": "4025500095697",
        "Laktose": "true",
        "Gluten": "false",
        "Nuss": "false"
      }
    }
  ];

  jimData.isInitialized = true;
}