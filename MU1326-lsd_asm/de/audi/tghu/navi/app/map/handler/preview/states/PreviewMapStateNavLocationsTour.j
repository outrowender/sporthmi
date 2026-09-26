.version 50 0 
.class public super [134] 
.super [136] 
.field [137] [138] 

.method public [140] : [141] 
    .attribute [139] .code stack 5 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     aload_2 
L3:     aload_3 
L4:     aload 4 
L6:     invokespecial [22] 
L9:     aload_0 
L10:    iconst_1 
L11:    putfield [25] 
L14:    aload_0 
L15:    aload 5 
L17:    putfield [26] 
L20:    return 
L21:    nop 
L22:    nop 
L23:    nop 
L24:    
    .end code 
.end method 

.method public [142] : [143] 
    .attribute [139] .code stack 3 locals 1 
L0:     aload_0 
L1:     getfield [16] 
L4:     ldc [2] 
L6:     ldc [3] 
L8:     invokevirtual [17] 
L11:    pop 
L12:    aload_0 
L13:    invokevirtual [18] 
L16:    invokevirtual [19] 
L19:    invokeinterface [27] 0 
L24:    invokeinterface [28] 0 
L29:    astore_1 
L30:    aload_0 
L31:    aload_1 
L32:    invokestatic [4] 
L35:    putfield [29] 
L38:    aload_0 
L39:    iconst_1 
L40:    putfield [30] 
L43:    aload_0 
L44:    invokespecial [23] 
L47:    return 
L48:    
    .end code 
.end method 

.method public [144] : [145] 
    .attribute [139] .code stack 3 locals 0 
L0:     aload_0 
L1:     getfield [20] 
L4:     ifnull L15 
L7:     aload_0 
L8:     getfield [20] 
L11:    arraylength 
L12:    ifne L29 
L15:    aload_0 
L16:    getfield [16] 
L19:    sipush 10000 
L22:    ldc [5] 
L24:    invokevirtual [17] 
L27:    pop 
L28:    return 
L29:    aload_0 
L30:    getfield [21] 
L33:    ifnull L61 
L36:    aload_0 
L37:    getfield [20] 
L40:    arraylength 
L41:    iflt L61 
L44:    aload_0 
L45:    getfield [21] 
L48:    aload_0 
L49:    getfield [20] 
L52:    aload_0 
L53:    getfield [15] 
L56:    invokeinterface [31] 0 
L61:    return 
L62:    nop 
L63:    nop 
L64:    
    .end code 
.end method 

.method public [146] : [147] 
    .attribute [139] .code stack 3 locals 1 
L0:     aload_0 
L1:     getfield [16] 
L4:     ldc [2] 
L6:     ldc [6] 
L8:     invokevirtual [17] 
L11:    pop 
L12:    aload_0 
L13:    invokevirtual [18] 
L16:    invokevirtual [19] 
L19:    invokeinterface [27] 0 
L24:    invokeinterface [28] 0 
L29:    astore_1 
L30:    aload_0 
L31:    aload_1 
L32:    invokestatic [4] 
L35:    putfield [29] 
L38:    aload_0 
L39:    iconst_1 
L40:    putfield [30] 
L43:    aload_0 
L44:    invokespecial [24] 
L47:    return 
L48:    
    .end code 
.end method 

.method protected interface [148] : [149] 
    .attribute [139] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [15] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [150] : [151] 
    .attribute [139] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [20] 
L4:     ifnull L19 
L7:     aload_0 
L8:     getfield [20] 
L11:    arraylength 
L12:    ifeq L19 
L15:    iconst_1 
L16:    goto L20 
L19:    iconst_0 
L20:    areturn 
L21:    nop 
L22:    nop 
L23:    nop 
L24:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Int -2137614336 
.const [3] = String [32] 
.const [4] = Method [33] [34] 
.const [5] = String [35] 
.const [6] = String [36] 
.const [7] = Class [37] 
.const [8] = Class [38] 
.const [9] = Class [39] 
.const [10] = Class [40] 
.const [11] = Class [41] 
.const [12] = Class [42] 
.const [13] = Class [43] 
.const [14] = Class [44] 
.const [15] = Field [45] [46] 
.const [16] = Field [47] [48] 
.const [17] = Method [49] [50] 
.const [18] = Method [51] [52] 
.const [19] = Method [53] [54] 
.const [20] = Field [55] [56] 
.const [21] = Field [57] [58] 
.const [22] = Method [59] [60] 
.const [23] = Method [61] [62] 
.const [24] = Method [63] [64] 
.const [25] = Field [65] [66] 
.const [26] = Field [67] [68] 
.const [27] = InterfaceMethod [69] [70] 
.const [28] = InterfaceMethod [71] [72] 
.const [29] = Field [73] [74] 
.const [30] = Field [75] [76] 
.const [31] = InterfaceMethod [77] [78] 
.const [32] = Utf8 'PreviewMapStateNavLocationsTour#applyToScreenDetail()' 
.const [33] = Class [79] 
.const [34] = NameAndType [80] [81] 
.const [35] = Utf8 'PreviewMapStateNavLocationsTour#applyToScreenDetailModels() no nav location given' 
.const [36] = Utf8 'PreviewMapStateNavLocationsTour#applyToScreenFullMap()' 
.const [37] = Utf8 de/audi/tghu/navi/app/map/handler/preview/states/PreviewMapStateNavLocationsTour 
.const [38] = Utf8 de/audi/tghu/navi/app/map/handler/preview/states/PreviewMapStateNavLocations 
.const [39] = Utf8 de/audi/atip/log/LogChannel 
.const [40] = Utf8 de/audi/tghu/navi/app/map/AbstractMap 
.const [41] = Utf8 de/audi/tghu/navi/app/map/INaviInterface 
.const [42] = Utf8 de/audi/tghu/navi/app/guidance/IVehicle 
.const [43] = Utf8 de/audi/tghu/navi/app/util/Util 
.const [44] = Utf8 de/audi/atip/interapp/navigation/previewmap/gui/GuiModelAccessForPreviewMapDetailScreen 
.const [45] = Class [82] 
.const [46] = NameAndType [83] [84] 
.const [47] = Class [85] 
.const [48] = NameAndType [86] [87] 
.const [49] = Class [88] 
.const [50] = NameAndType [89] [90] 
.const [51] = Class [91] 
.const [52] = NameAndType [92] [93] 
.const [53] = Class [94] 
.const [54] = NameAndType [95] [96] 
.const [55] = Class [97] 
.const [56] = NameAndType [98] [99] 
.const [57] = Class [100] 
.const [58] = NameAndType [101] [102] 
.const [59] = Class [103] 
.const [60] = NameAndType [104] [105] 
.const [61] = Class [106] 
.const [62] = NameAndType [107] [108] 
.const [63] = Class [109] 
.const [64] = NameAndType [110] [111] 
.const [65] = Class [112] 
.const [66] = NameAndType [113] [114] 
.const [67] = Class [115] 
.const [68] = NameAndType [116] [117] 
.const [69] = Class [118] 
.const [70] = NameAndType [119] [120] 
.const [71] = Class [121] 
.const [72] = NameAndType [122] [123] 
.const [73] = Class [124] 
.const [74] = NameAndType [125] [126] 
.const [75] = Class [127] 
.const [76] = NameAndType [128] [129] 
.const [77] = Class [130] 
.const [78] = NameAndType [131] [132] 
.const [79] = Utf8 de/audi/tghu/navi/app/util/Util 
.const [80] = Utf8 navLocationToWgs84 
.const [81] = Utf8 (Lorg/dsi/ifc/global/NavLocation;)Lorg/dsi/ifc/global/NavLocationWgs84; 
.const [82] = Utf8 de/audi/tghu/navi/app/map/handler/preview/states/PreviewMapStateNavLocationsTour 
.const [83] = Utf8 tourName 
.const [84] = Utf8 Ljava/lang/String; 
.const [85] = Utf8 de/audi/tghu/navi/app/map/handler/preview/states/PreviewMapStateNavLocationsTour 
.const [86] = Utf8 logger 
.const [87] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [88] = Utf8 de/audi/atip/log/LogChannel 
.const [89] = Utf8 log 
.const [90] = Utf8 (ILjava/lang/String;)Z 
.const [91] = Utf8 de/audi/tghu/navi/app/map/handler/preview/states/PreviewMapStateNavLocationsTour 
.const [92] = Utf8 getMapForPreview 
.const [93] = Utf8 ()Lde/audi/tghu/navi/app/map/AbstractMap; 
.const [94] = Utf8 de/audi/tghu/navi/app/map/AbstractMap 
.const [95] = Utf8 getNaviInterface 
.const [96] = Utf8 ()Lde/audi/tghu/navi/app/map/INaviInterface; 
.const [97] = Utf8 de/audi/tghu/navi/app/map/handler/preview/states/PreviewMapStateNavLocationsTour 
.const [98] = Utf8 navLocations 
.const [99] = Utf8 [Lorg/dsi/ifc/global/NavLocation; 
.const [100] = Utf8 de/audi/tghu/navi/app/map/handler/preview/states/PreviewMapStateNavLocationsTour 
.const [101] = Utf8 guiModelAccess 
.const [102] = Utf8 Lde/audi/atip/interapp/navigation/previewmap/gui/GuiModelAccessForPreviewMapDetailScreen; 
.const [103] = Utf8 de/audi/tghu/navi/app/map/handler/preview/states/PreviewMapStateNavLocations 
.const [104] = Utf8 <init> 
.const [105] = Utf8 (Lde/audi/tghu/navi/app/map/handler/preview/PreviewMapHandlerAbstract;Lde/audi/atip/interapp/navigation/previewmap/gui/GuiModelAccessForPreviewMapDetailScreen;Lde/audi/atip/interapp/navigation/previewmap/gui/GuiTooltipInformationContainer;[Lorg/dsi/ifc/global/NavLocation;)V 
.const [106] = Utf8 de/audi/tghu/navi/app/map/handler/preview/states/PreviewMapStateNavLocations 
.const [107] = Utf8 applyToScreenDetail 
.const [108] = Utf8 ()V 
.const [109] = Utf8 de/audi/tghu/navi/app/map/handler/preview/states/PreviewMapStateNavLocations 
.const [110] = Utf8 applyToScreenFullMap 
.const [111] = Utf8 ()V 
.const [112] = Utf8 de/audi/tghu/navi/app/map/handler/preview/states/PreviewMapStateNavLocationsTour 
.const [113] = Utf8 forTourShowNumberedMapPins 
.const [114] = Utf8 Z 
.const [115] = Utf8 de/audi/tghu/navi/app/map/handler/preview/states/PreviewMapStateNavLocationsTour 
.const [116] = Utf8 tourName 
.const [117] = Utf8 Ljava/lang/String; 
.const [118] = Utf8 de/audi/tghu/navi/app/map/INaviInterface 
.const [119] = Utf8 getVehicle 
.const [120] = Utf8 ()Lde/audi/tghu/navi/app/guidance/IVehicle; 
.const [121] = Utf8 de/audi/tghu/navi/app/guidance/IVehicle 
.const [122] = Utf8 getVehicleLocation 
.const [123] = Utf8 ()Lorg/dsi/ifc/global/NavLocation; 
.const [124] = Utf8 de/audi/tghu/navi/app/map/handler/preview/states/PreviewMapStateNavLocationsTour 
.const [125] = Utf8 navLocationPivot 
.const [126] = Utf8 Lorg/dsi/ifc/global/NavLocationWgs84; 
.const [127] = Utf8 de/audi/tghu/navi/app/map/handler/preview/states/PreviewMapStateNavLocationsTour 
.const [128] = Utf8 centerOnPivot 
.const [129] = Utf8 Z 
.const [130] = Utf8 de/audi/atip/interapp/navigation/previewmap/gui/GuiModelAccessForPreviewMapDetailScreen 
.const [131] = Utf8 onUpdateLocationsForTour 
.const [132] = Utf8 ([Lorg/dsi/ifc/global/NavLocation;Ljava/lang/String;)V 
.const [133] = Utf8 de/audi/tghu/navi/app/map/handler/preview/states/PreviewMapStateNavLocationsTour 
.const [134] = Class [133] 
.const [135] = Utf8 de/audi/tghu/navi/app/map/handler/preview/states/PreviewMapStateNavLocations 
.const [136] = Class [135] 
.const [137] = Utf8 tourName 
.const [138] = Utf8 Ljava/lang/String; 
.const [139] = Utf8 Code 
.const [140] = Utf8 <init> 
.const [141] = Utf8 (Lde/audi/tghu/navi/app/map/handler/preview/PreviewMapHandlerAbstract;Lde/audi/atip/interapp/navigation/previewmap/gui/GuiModelAccessForPreviewMapDetailScreen;Lde/audi/atip/interapp/navigation/previewmap/gui/GuiTooltipInformationContainer;[Lorg/dsi/ifc/global/NavLocation;Ljava/lang/String;)V 
.const [142] = Utf8 applyToScreenDetail 
.const [143] = Utf8 ()V 
.const [144] = Utf8 applyToScreenDetailModels 
.const [145] = Utf8 ()V 
.const [146] = Utf8 applyToScreenFullMap 
.const [147] = Utf8 ()V 
.const [148] = Utf8 getTourName 
.const [149] = Utf8 ()Ljava/lang/String; 
.const [150] = Utf8 isPreviewMapItemArea 
.const [151] = Utf8 ()Z 
.end class 
