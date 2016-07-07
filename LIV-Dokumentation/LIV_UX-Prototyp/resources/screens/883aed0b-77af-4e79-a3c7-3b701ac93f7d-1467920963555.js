jQuery("#simulation")
  .on("click", ".s-883aed0b-77af-4e79-a3c7-3b701ac93f7d .click", function(event, data) {
    var jEvent, jFirer, cases;
    if(data === undefined) { data = event; }
    jEvent = jimEvent(event);
    jFirer = jEvent.getEventFirer();
    if(jFirer.is("#s-Label_126")) {
      cases = [
        {
          "blocks": [
            {
              "actions": [
                {
                  "action": "jimChangeStyle",
                  "parameter": [ {
                    "#s-883aed0b-77af-4e79-a3c7-3b701ac93f7d #s-Label_8": {
                      "attributes": {
                        "border-top-width": "0px",
                        "border-top-style": "none",
                        "border-top-color": "#000000",
                        "border-right-width": "0px",
                        "border-right-style": "none",
                        "border-right-color": "#000000",
                        "border-bottom-width": "1px",
                        "border-bottom-style": "solid",
                        "border-bottom-color": "#980000",
                        "border-left-width": "0px",
                        "border-left-style": "none",
                        "border-left-color": "#000000",
                        "border-radius": "0px 0px 0px 0px"
                      }
                    }
                  },{
                    "#s-883aed0b-77af-4e79-a3c7-3b701ac93f7d #s-Label_8": {
                      "attributes-ie": {
                        "border-top-width": "0px",
                        "border-top-style": "none",
                        "border-top-color": "#000000",
                        "border-right-width": "0px",
                        "border-right-style": "none",
                        "border-right-color": "#000000",
                        "border-bottom-width": "1px",
                        "border-bottom-style": "solid",
                        "border-bottom-color": "#980000",
                        "border-left-width": "0px",
                        "border-left-style": "none",
                        "border-left-color": "#000000",
                        "border-radius": "0px 0px 0px 0px"
                      }
                    }
                  } ],
                  "exectype": "serial",
                  "delay": 0
                }
              ]
            }
          ],
          "exectype": "serial",
          "delay": 0
        },
        {
          "blocks": [
            {
              "actions": [
                {
                  "action": "jimNavigation",
                  "parameter": {
                    "target": "screens/825d8d4d-d97b-4a27-8c53-9894f5e6cd0b",
                    "transition": "pop"
                  },
                  "exectype": "serial",
                  "delay": 0
                }
              ]
            }
          ],
          "exectype": "timed",
          "delay": 500
        }
      ];
      event.data = data;
      jEvent.launchCases(cases);
    } else if(jFirer.is("#s-Label_185")) {
      cases = [
        {
          "blocks": [
            {
              "actions": [
                {
                  "action": "jimChangeStyle",
                  "parameter": [ {
                    "#s-883aed0b-77af-4e79-a3c7-3b701ac93f7d #s-Label_9": {
                      "attributes": {
                        "border-top-width": "0px",
                        "border-top-style": "none",
                        "border-top-color": "#000000",
                        "border-right-width": "0px",
                        "border-right-style": "none",
                        "border-right-color": "#000000",
                        "border-bottom-width": "1px",
                        "border-bottom-style": "solid",
                        "border-bottom-color": "#980000",
                        "border-left-width": "0px",
                        "border-left-style": "none",
                        "border-left-color": "#000000",
                        "border-radius": "0px 0px 0px 0px"
                      }
                    }
                  },{
                    "#s-883aed0b-77af-4e79-a3c7-3b701ac93f7d #s-Label_9": {
                      "attributes-ie": {
                        "border-top-width": "0px",
                        "border-top-style": "none",
                        "border-top-color": "#000000",
                        "border-right-width": "0px",
                        "border-right-style": "none",
                        "border-right-color": "#000000",
                        "border-bottom-width": "1px",
                        "border-bottom-style": "solid",
                        "border-bottom-color": "#980000",
                        "border-left-width": "0px",
                        "border-left-style": "none",
                        "border-left-color": "#000000",
                        "border-radius": "0px 0px 0px 0px"
                      }
                    }
                  } ],
                  "exectype": "serial",
                  "delay": 0
                }
              ]
            }
          ],
          "exectype": "serial",
          "delay": 0
        },
        {
          "blocks": [
            {
              "actions": [
                {
                  "action": "jimNavigation",
                  "parameter": {
                    "target": "screens/6f7f7e16-6686-402a-94ad-a2c5a1160750",
                    "transition": "pop"
                  },
                  "exectype": "serial",
                  "delay": 0
                }
              ]
            }
          ],
          "exectype": "timed",
          "delay": 500
        }
      ];
      event.data = data;
      jEvent.launchCases(cases);
    } else if(jFirer.is("#s-Label_53")) {
      cases = [
        {
          "blocks": [
            {
              "actions": [
                {
                  "action": "jimChangeStyle",
                  "parameter": [ {
                    "#s-883aed0b-77af-4e79-a3c7-3b701ac93f7d #s-Label_53": {
                      "attributes": {
                        "font-size": "20.0pt",
                        "font-family": "IOS9-Icons-Regular,Arial"
                      }
                    }
                  },{
                    "#s-883aed0b-77af-4e79-a3c7-3b701ac93f7d #s-Label_53 .valign": {
                      "attributes": {
                        "vertical-align": "middle",
                        "text-align": "left"
                      }
                    }
                  },{
                    "#s-883aed0b-77af-4e79-a3c7-3b701ac93f7d #s-Label_53 span": {
                      "attributes": {
                        "color": "#980000",
                        "text-align": "left",
                        "text-decoration": "none",
                        "font-family": "IOS9-Icons-Regular,Arial",
                        "font-size": "20.0pt"
                      }
                    }
                  } ],
                  "exectype": "serial",
                  "delay": 0
                }
              ]
            }
          ],
          "exectype": "serial",
          "delay": 0
        },
        {
          "blocks": [
            {
              "actions": [
                {
                  "action": "jimNavigation",
                  "parameter": {
                    "target": "screens/883aed0b-77af-4e79-a3c7-3b701ac93f7d",
                    "transition": "pop"
                  },
                  "exectype": "serial",
                  "delay": 0
                }
              ]
            }
          ],
          "exectype": "timed",
          "delay": 500
        }
      ];
      event.data = data;
      jEvent.launchCases(cases);
    } else if(jFirer.is("#s-Label_272")) {
      cases = [
        {
          "blocks": [
            {
              "actions": [
                {
                  "action": "jimChangeStyle",
                  "parameter": [ {
                    "#s-883aed0b-77af-4e79-a3c7-3b701ac93f7d #s-Label_7": {
                      "attributes": {
                        "border-top-width": "0px",
                        "border-top-style": "none",
                        "border-top-color": "#000000",
                        "border-right-width": "0px",
                        "border-right-style": "none",
                        "border-right-color": "#000000",
                        "border-bottom-width": "1px",
                        "border-bottom-style": "solid",
                        "border-bottom-color": "#980000",
                        "border-left-width": "0px",
                        "border-left-style": "none",
                        "border-left-color": "#000000",
                        "border-radius": "0px 0px 0px 0px"
                      }
                    }
                  },{
                    "#s-883aed0b-77af-4e79-a3c7-3b701ac93f7d #s-Label_7": {
                      "attributes-ie": {
                        "border-top-width": "0px",
                        "border-top-style": "none",
                        "border-top-color": "#000000",
                        "border-right-width": "0px",
                        "border-right-style": "none",
                        "border-right-color": "#000000",
                        "border-bottom-width": "1px",
                        "border-bottom-style": "solid",
                        "border-bottom-color": "#980000",
                        "border-left-width": "0px",
                        "border-left-style": "none",
                        "border-left-color": "#000000",
                        "border-radius": "0px 0px 0px 0px"
                      }
                    }
                  } ],
                  "exectype": "serial",
                  "delay": 0
                }
              ]
            }
          ],
          "exectype": "serial",
          "delay": 0
        },
        {
          "blocks": [
            {
              "actions": [
                {
                  "action": "jimNavigation",
                  "parameter": {
                    "target": "screens/70cd42b1-78db-4d0f-a724-9ca3d034a4c9",
                    "transition": "pop"
                  },
                  "exectype": "serial",
                  "delay": 0
                }
              ]
            }
          ],
          "exectype": "timed",
          "delay": 500
        }
      ];
      event.data = data;
      jEvent.launchCases(cases);
    } else if(jFirer.is("#s-Label_20")) {
      cases = [
        {
          "blocks": [
            {
              "actions": [
                {
                  "action": "jimChangeStyle",
                  "parameter": [ {
                    "#s-883aed0b-77af-4e79-a3c7-3b701ac93f7d #s-Label_5": {
                      "attributes": {
                        "border-top-width": "0px",
                        "border-top-style": "none",
                        "border-top-color": "#000000",
                        "border-right-width": "0px",
                        "border-right-style": "none",
                        "border-right-color": "#000000",
                        "border-bottom-width": "1px",
                        "border-bottom-style": "solid",
                        "border-bottom-color": "#980000",
                        "border-left-width": "0px",
                        "border-left-style": "none",
                        "border-left-color": "#000000",
                        "border-radius": "0px 0px 0px 0px"
                      }
                    }
                  },{
                    "#s-883aed0b-77af-4e79-a3c7-3b701ac93f7d #s-Label_5": {
                      "attributes-ie": {
                        "border-top-width": "0px",
                        "border-top-style": "none",
                        "border-top-color": "#000000",
                        "border-right-width": "0px",
                        "border-right-style": "none",
                        "border-right-color": "#000000",
                        "border-bottom-width": "1px",
                        "border-bottom-style": "solid",
                        "border-bottom-color": "#980000",
                        "border-left-width": "0px",
                        "border-left-style": "none",
                        "border-left-color": "#000000",
                        "border-radius": "0px 0px 0px 0px"
                      }
                    }
                  } ],
                  "exectype": "serial",
                  "delay": 0
                }
              ]
            }
          ],
          "exectype": "serial",
          "delay": 0
        },
        {
          "blocks": [
            {
              "actions": [
                {
                  "action": "jimNavigation",
                  "parameter": {
                    "target": "screens/8a638ee1-d936-47c6-b4d7-1fa17ca84294",
                    "transition": "pop"
                  },
                  "exectype": "serial",
                  "delay": 0
                }
              ]
            }
          ],
          "exectype": "timed",
          "delay": 500
        }
      ];
      event.data = data;
      jEvent.launchCases(cases);
    } else if(jFirer.is("#s-Rich_text_51")) {
      cases = [
        {
          "blocks": [
            {
              "actions": [
                {
                  "action": "jimHide",
                  "parameter": {
                    "target": "#s-Image_4"
                  },
                  "exectype": "serial",
                  "delay": 0
                }
              ]
            }
          ],
          "exectype": "serial",
          "delay": 0
        },
        {
          "blocks": [
            {
              "actions": [
                {
                  "action": "jimShow",
                  "parameter": {
                    "target": "#s-Image_1"
                  },
                  "exectype": "serial",
                  "delay": 0
                }
              ]
            }
          ],
          "exectype": "parallel",
          "delay": 0
        },
        {
          "blocks": [
            {
              "actions": [
                {
                  "action": "jimChangeStyle",
                  "parameter": [ {
                    "#s-883aed0b-77af-4e79-a3c7-3b701ac93f7d #s-Rich_text_51": {
                      "attributes": {
                        "border-top-width": "1px",
                        "border-top-style": "solid",
                        "border-top-color": "#6ACA25",
                        "border-right-width": "1px",
                        "border-right-style": "solid",
                        "border-right-color": "#6ACA25",
                        "border-bottom-width": "1px",
                        "border-bottom-style": "solid",
                        "border-bottom-color": "#6ACA25",
                        "border-left-width": "1px",
                        "border-left-style": "solid",
                        "border-left-color": "#6ACA25",
                        "border-radius": "0px 0px 0px 0px"
                      }
                    }
                  },{
                    "#s-883aed0b-77af-4e79-a3c7-3b701ac93f7d #s-Rich_text_51": {
                      "attributes-ie": {
                        "border-top-width": "1px",
                        "border-top-style": "solid",
                        "border-top-color": "#6ACA25",
                        "border-right-width": "1px",
                        "border-right-style": "solid",
                        "border-right-color": "#6ACA25",
                        "border-bottom-width": "1px",
                        "border-bottom-style": "solid",
                        "border-bottom-color": "#6ACA25",
                        "border-left-width": "1px",
                        "border-left-style": "solid",
                        "border-left-color": "#6ACA25",
                        "border-radius": "0px 0px 0px 0px"
                      }
                    }
                  } ],
                  "exectype": "serial",
                  "delay": 0
                }
              ]
            }
          ],
          "exectype": "parallel",
          "delay": 0
        }
      ];
      event.data = data;
      jEvent.launchCases(cases);
    } else if(jFirer.is("#s-Image_4")) {
      cases = [
        {
          "blocks": [
            {
              "actions": [
                {
                  "action": "jimHide",
                  "parameter": {
                    "target": "#s-Image_4"
                  },
                  "exectype": "serial",
                  "delay": 0
                }
              ]
            }
          ],
          "exectype": "serial",
          "delay": 0
        },
        {
          "blocks": [
            {
              "actions": [
                {
                  "action": "jimShow",
                  "parameter": {
                    "target": "#s-Image_1"
                  },
                  "exectype": "serial",
                  "delay": 0
                }
              ]
            }
          ],
          "exectype": "parallel",
          "delay": 0
        },
        {
          "blocks": [
            {
              "actions": [
                {
                  "action": "jimChangeStyle",
                  "parameter": [ {
                    "#s-883aed0b-77af-4e79-a3c7-3b701ac93f7d #s-Rich_text_51": {
                      "attributes": {
                        "border-top-width": "1px",
                        "border-top-style": "solid",
                        "border-top-color": "#6ACA25",
                        "border-right-width": "1px",
                        "border-right-style": "solid",
                        "border-right-color": "#6ACA25",
                        "border-bottom-width": "1px",
                        "border-bottom-style": "solid",
                        "border-bottom-color": "#6ACA25",
                        "border-left-width": "1px",
                        "border-left-style": "solid",
                        "border-left-color": "#6ACA25",
                        "border-radius": "0px 0px 0px 0px"
                      }
                    }
                  },{
                    "#s-883aed0b-77af-4e79-a3c7-3b701ac93f7d #s-Rich_text_51": {
                      "attributes-ie": {
                        "border-top-width": "1px",
                        "border-top-style": "solid",
                        "border-top-color": "#6ACA25",
                        "border-right-width": "1px",
                        "border-right-style": "solid",
                        "border-right-color": "#6ACA25",
                        "border-bottom-width": "1px",
                        "border-bottom-style": "solid",
                        "border-bottom-color": "#6ACA25",
                        "border-left-width": "1px",
                        "border-left-style": "solid",
                        "border-left-color": "#6ACA25",
                        "border-radius": "0px 0px 0px 0px"
                      }
                    }
                  } ],
                  "exectype": "serial",
                  "delay": 0
                }
              ]
            }
          ],
          "exectype": "parallel",
          "delay": 0
        }
      ];
      event.data = data;
      jEvent.launchCases(cases);
    } else if(jFirer.is("#s-Rich_text_50")) {
      cases = [
        {
          "blocks": [
            {
              "actions": [
                {
                  "action": "jimHide",
                  "parameter": {
                    "target": "#s-Image_6"
                  },
                  "exectype": "serial",
                  "delay": 0
                }
              ]
            }
          ],
          "exectype": "serial",
          "delay": 0
        },
        {
          "blocks": [
            {
              "actions": [
                {
                  "action": "jimShow",
                  "parameter": {
                    "target": "#s-Image_2"
                  },
                  "exectype": "serial",
                  "delay": 0
                }
              ]
            }
          ],
          "exectype": "parallel",
          "delay": 0
        },
        {
          "blocks": [
            {
              "actions": [
                {
                  "action": "jimChangeStyle",
                  "parameter": [ {
                    "#s-883aed0b-77af-4e79-a3c7-3b701ac93f7d #s-Rich_text_50": {
                      "attributes": {
                        "border-top-width": "1px",
                        "border-top-style": "solid",
                        "border-top-color": "#6ACA25",
                        "border-right-width": "1px",
                        "border-right-style": "solid",
                        "border-right-color": "#6ACA25",
                        "border-bottom-width": "1px",
                        "border-bottom-style": "solid",
                        "border-bottom-color": "#6ACA25",
                        "border-left-width": "1px",
                        "border-left-style": "solid",
                        "border-left-color": "#6ACA25",
                        "border-radius": "0px 0px 0px 0px"
                      }
                    }
                  },{
                    "#s-883aed0b-77af-4e79-a3c7-3b701ac93f7d #s-Rich_text_50": {
                      "attributes-ie": {
                        "border-top-width": "1px",
                        "border-top-style": "solid",
                        "border-top-color": "#6ACA25",
                        "border-right-width": "1px",
                        "border-right-style": "solid",
                        "border-right-color": "#6ACA25",
                        "border-bottom-width": "1px",
                        "border-bottom-style": "solid",
                        "border-bottom-color": "#6ACA25",
                        "border-left-width": "1px",
                        "border-left-style": "solid",
                        "border-left-color": "#6ACA25",
                        "border-radius": "0px 0px 0px 0px"
                      }
                    }
                  } ],
                  "exectype": "serial",
                  "delay": 0
                }
              ]
            }
          ],
          "exectype": "parallel",
          "delay": 0
        }
      ];
      event.data = data;
      jEvent.launchCases(cases);
    } else if(jFirer.is("#s-Image_6")) {
      cases = [
        {
          "blocks": [
            {
              "actions": [
                {
                  "action": "jimHide",
                  "parameter": {
                    "target": "#s-Image_6"
                  },
                  "exectype": "serial",
                  "delay": 0
                }
              ]
            }
          ],
          "exectype": "serial",
          "delay": 0
        },
        {
          "blocks": [
            {
              "actions": [
                {
                  "action": "jimShow",
                  "parameter": {
                    "target": "#s-Image_2"
                  },
                  "exectype": "serial",
                  "delay": 0
                }
              ]
            }
          ],
          "exectype": "parallel",
          "delay": 0
        },
        {
          "blocks": [
            {
              "actions": [
                {
                  "action": "jimChangeStyle",
                  "parameter": [ {
                    "#s-883aed0b-77af-4e79-a3c7-3b701ac93f7d #s-Rich_text_50": {
                      "attributes": {
                        "border-top-width": "1px",
                        "border-top-style": "solid",
                        "border-top-color": "#6ACA25",
                        "border-right-width": "1px",
                        "border-right-style": "solid",
                        "border-right-color": "#6ACA25",
                        "border-bottom-width": "1px",
                        "border-bottom-style": "solid",
                        "border-bottom-color": "#6ACA25",
                        "border-left-width": "1px",
                        "border-left-style": "solid",
                        "border-left-color": "#6ACA25",
                        "border-radius": "0px 0px 0px 0px"
                      }
                    }
                  },{
                    "#s-883aed0b-77af-4e79-a3c7-3b701ac93f7d #s-Rich_text_50": {
                      "attributes-ie": {
                        "border-top-width": "1px",
                        "border-top-style": "solid",
                        "border-top-color": "#6ACA25",
                        "border-right-width": "1px",
                        "border-right-style": "solid",
                        "border-right-color": "#6ACA25",
                        "border-bottom-width": "1px",
                        "border-bottom-style": "solid",
                        "border-bottom-color": "#6ACA25",
                        "border-left-width": "1px",
                        "border-left-style": "solid",
                        "border-left-color": "#6ACA25",
                        "border-radius": "0px 0px 0px 0px"
                      }
                    }
                  } ],
                  "exectype": "serial",
                  "delay": 0
                }
              ]
            }
          ],
          "exectype": "parallel",
          "delay": 0
        }
      ];
      event.data = data;
      jEvent.launchCases(cases);
    } else if(jFirer.is("#s-Rich_text_52")) {
      cases = [
        {
          "blocks": [
            {
              "actions": [
                {
                  "action": "jimHide",
                  "parameter": {
                    "target": "#s-Image_5"
                  },
                  "exectype": "serial",
                  "delay": 0
                }
              ]
            }
          ],
          "exectype": "serial",
          "delay": 0
        },
        {
          "blocks": [
            {
              "actions": [
                {
                  "action": "jimShow",
                  "parameter": {
                    "target": "#s-Image_3"
                  },
                  "exectype": "serial",
                  "delay": 0
                }
              ]
            }
          ],
          "exectype": "parallel",
          "delay": 0
        },
        {
          "blocks": [
            {
              "actions": [
                {
                  "action": "jimChangeStyle",
                  "parameter": [ {
                    "#s-883aed0b-77af-4e79-a3c7-3b701ac93f7d #s-Rich_text_52": {
                      "attributes": {
                        "border-top-width": "1px",
                        "border-top-style": "solid",
                        "border-top-color": "#6ACA25",
                        "border-right-width": "1px",
                        "border-right-style": "solid",
                        "border-right-color": "#6ACA25",
                        "border-bottom-width": "1px",
                        "border-bottom-style": "solid",
                        "border-bottom-color": "#6ACA25",
                        "border-left-width": "1px",
                        "border-left-style": "solid",
                        "border-left-color": "#6ACA25",
                        "border-radius": "0px 0px 0px 0px"
                      }
                    }
                  },{
                    "#s-883aed0b-77af-4e79-a3c7-3b701ac93f7d #s-Rich_text_52": {
                      "attributes-ie": {
                        "border-top-width": "1px",
                        "border-top-style": "solid",
                        "border-top-color": "#6ACA25",
                        "border-right-width": "1px",
                        "border-right-style": "solid",
                        "border-right-color": "#6ACA25",
                        "border-bottom-width": "1px",
                        "border-bottom-style": "solid",
                        "border-bottom-color": "#6ACA25",
                        "border-left-width": "1px",
                        "border-left-style": "solid",
                        "border-left-color": "#6ACA25",
                        "border-radius": "0px 0px 0px 0px"
                      }
                    }
                  } ],
                  "exectype": "serial",
                  "delay": 0
                }
              ]
            }
          ],
          "exectype": "parallel",
          "delay": 0
        }
      ];
      event.data = data;
      jEvent.launchCases(cases);
    } else if(jFirer.is("#s-Image_5")) {
      cases = [
        {
          "blocks": [
            {
              "actions": [
                {
                  "action": "jimHide",
                  "parameter": {
                    "target": "#s-Image_5"
                  },
                  "exectype": "serial",
                  "delay": 0
                }
              ]
            }
          ],
          "exectype": "serial",
          "delay": 0
        },
        {
          "blocks": [
            {
              "actions": [
                {
                  "action": "jimShow",
                  "parameter": {
                    "target": "#s-Image_3"
                  },
                  "exectype": "serial",
                  "delay": 0
                }
              ]
            }
          ],
          "exectype": "parallel",
          "delay": 0
        },
        {
          "blocks": [
            {
              "actions": [
                {
                  "action": "jimChangeStyle",
                  "parameter": [ {
                    "#s-883aed0b-77af-4e79-a3c7-3b701ac93f7d #s-Rich_text_52": {
                      "attributes": {
                        "border-top-width": "1px",
                        "border-top-style": "solid",
                        "border-top-color": "#6ACA25",
                        "border-right-width": "1px",
                        "border-right-style": "solid",
                        "border-right-color": "#6ACA25",
                        "border-bottom-width": "1px",
                        "border-bottom-style": "solid",
                        "border-bottom-color": "#6ACA25",
                        "border-left-width": "1px",
                        "border-left-style": "solid",
                        "border-left-color": "#6ACA25",
                        "border-radius": "0px 0px 0px 0px"
                      }
                    }
                  },{
                    "#s-883aed0b-77af-4e79-a3c7-3b701ac93f7d #s-Rich_text_52": {
                      "attributes-ie": {
                        "border-top-width": "1px",
                        "border-top-style": "solid",
                        "border-top-color": "#6ACA25",
                        "border-right-width": "1px",
                        "border-right-style": "solid",
                        "border-right-color": "#6ACA25",
                        "border-bottom-width": "1px",
                        "border-bottom-style": "solid",
                        "border-bottom-color": "#6ACA25",
                        "border-left-width": "1px",
                        "border-left-style": "solid",
                        "border-left-color": "#6ACA25",
                        "border-radius": "0px 0px 0px 0px"
                      }
                    }
                  } ],
                  "exectype": "serial",
                  "delay": 0
                }
              ]
            }
          ],
          "exectype": "parallel",
          "delay": 0
        }
      ];
      event.data = data;
      jEvent.launchCases(cases);
    } else if(jFirer.is("#s-Label_28")) {
      cases = [
        {
          "blocks": [
            {
              "actions": [
                {
                  "action": "jimChangeStyle",
                  "parameter": [ {
                    "#s-883aed0b-77af-4e79-a3c7-3b701ac93f7d #s-Label_28": {
                      "attributes": {
                        "font-size": "12.0pt",
                        "font-family": "Roboto-Medium,Arial"
                      }
                    }
                  },{
                    "#s-883aed0b-77af-4e79-a3c7-3b701ac93f7d #s-Label_28 .valign": {
                      "attributes": {
                        "vertical-align": "middle",
                        "text-align": "center"
                      }
                    }
                  },{
                    "#s-883aed0b-77af-4e79-a3c7-3b701ac93f7d #s-Label_28 span": {
                      "attributes": {
                        "color": "#980000",
                        "text-align": "center",
                        "text-decoration": "none",
                        "font-family": "Roboto-Medium,Arial",
                        "font-size": "12.0pt"
                      }
                    }
                  } ],
                  "exectype": "serial",
                  "delay": 0
                },
                {
                  "action": "jimPause",
                  "parameter": {
                    "pause": 750
                  },
                  "exectype": "serial",
                  "delay": 0
                },
                {
                  "action": "jimChangeStyle",
                  "parameter": [ {
                    "#s-883aed0b-77af-4e79-a3c7-3b701ac93f7d #s-Label_28": {
                      "attributes": {
                        "font-size": "12.0pt",
                        "font-family": "Roboto-Regular,Arial"
                      }
                    }
                  },{
                    "#s-883aed0b-77af-4e79-a3c7-3b701ac93f7d #s-Label_28 .valign": {
                      "attributes": {
                        "vertical-align": "middle",
                        "text-align": "center"
                      }
                    }
                  },{
                    "#s-883aed0b-77af-4e79-a3c7-3b701ac93f7d #s-Label_28 span": {
                      "attributes": {
                        "color": "#666666",
                        "text-align": "center",
                        "text-decoration": "none",
                        "font-family": "Roboto-Regular,Arial",
                        "font-size": "12.0pt"
                      }
                    }
                  } ],
                  "exectype": "serial",
                  "delay": 0
                }
              ]
            }
          ],
          "exectype": "serial",
          "delay": 0
        },
        {
          "blocks": [
            {
              "actions": [
                {
                  "action": "jimNavigation",
                  "parameter": {
                    "target": "screens/70cd42b1-78db-4d0f-a724-9ca3d034a4c9",
                    "transition": "slideleft"
                  },
                  "exectype": "serial",
                  "delay": 0
                }
              ]
            }
          ],
          "exectype": "serial",
          "delay": 0
        }
      ];
      event.data = data;
      jEvent.launchCases(cases);
    }
  });