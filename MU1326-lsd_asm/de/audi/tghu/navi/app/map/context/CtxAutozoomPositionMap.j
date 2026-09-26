.version 50 0 
.class public super [152] 
.super [154] 

.method public annotation [156] : [157] 
    .attribute [155] .code stack 3 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     aload_2 
L3:     invokespecial [28] 
L6:     return 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [158] : [159] 
    .attribute [155] .code stack 2 locals 0 
L0:     aload_0 
L1:     invokespecial [29] 
L4:     aload_0 
L5:     aload_0 
L6:     invokevirtual [15] 
L9:     invokeinterface [33] 0 
L14:    invokespecial [30] 
L17:    ifeq L30 
L20:    aload_0 
L21:    iconst_1 
L22:    invokevirtual [16] 
L25:    aload_0 
L26:    iconst_1 
L27:    invokevirtual [17] 
L30:    return 
L31:    nop 
L32:    
    .end code 
.end method 

.method public [160] : [161] 
    .attribute [155] .code stack 2 locals 0 
L0:     aload_0 
L1:     iconst_1 
L2:     invokevirtual [18] 
L5:     aload_0 
L6:     invokevirtual [19] 
L9:     return 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method protected [162] : [163] 
    .attribute [155] .code stack 3 locals 2 
L0:     aload_0 
L1:     invokevirtual [20] 
L4:     ldc [2] 
L6:     ldc [3] 
L8:     invokevirtual [21] 
L11:    pop 
L12:    aload_0 
L13:    invokespecial [31] 
L16:    istore_1 
L17:    aload_0 
L18:    aload_0 
L19:    invokevirtual [15] 
L22:    invokeinterface [33] 0 
L27:    invokespecial [30] 
L30:    istore_2 
L31:    iload_1 
L32:    ifne L39 
L35:    iload_2 
L36:    ifeq L43 
L39:    iconst_1 
L40:    goto L44 
L43:    iconst_0 
L44:    areturn 
L45:    nop 
L46:    nop 
L47:    nop 
L48:    
    .end code 
.end method 

.method private [164] : [165] 
    .attribute [155] .code stack 7 locals 0 
L0:     aload_0 
L1:     invokevirtual [22] 
L4:     iconst_3 
L5:     if_icmpne L22 
L8:     aload_0 
L9:     invokevirtual [20] 
L12:    ldc [2] 
L14:    ldc [4] 
L16:    invokevirtual [21] 
L19:    pop 
L20:    iconst_0 
L21:    areturn 
L22:    aload_0 
L23:    invokevirtual [23] 
L26:    ifne L37 
L29:    aload_0 
L30:    invokevirtual [22] 
L33:    iconst_2 
L34:    if_icmpeq L61 
L37:    aload_0 
L38:    invokevirtual [20] 
L41:    ldc [5] 
L43:    ldc [6] 
L45:    aload_0 
L46:    invokevirtual [23] 
L49:    i2l 
L50:    aload_0 
L51:    invokevirtual [22] 
L54:    i2l 
L55:    invokevirtual [24] 
L58:    pop 
L59:    iconst_0 
L60:    areturn 
L61:    aload_0 
L62:    invokevirtual [25] 
L65:    ifeq L82 
L68:    aload_0 
L69:    invokevirtual [20] 
L72:    ldc [5] 
L74:    ldc [7] 
L76:    invokevirtual [21] 
L79:    pop 
L80:    iconst_0 
L81:    areturn 
L82:    aload_0 
L83:    getfield [26] 
L86:    iconst_0 
L87:    putfield [34] 
L90:    aload_0 
L91:    invokevirtual [20] 
L94:    ldc [5] 
L96:    ldc [8] 
L98:    fload_1 
L99:    f2d 
L100:   invokevirtual [27] 
L103:   aload_0 
L104:   invokevirtual [15] 
L107:   fload_1 
L108:   ldc [9] 
L110:   fdiv 
L111:   invokeinterface [35] 0 
L116:   iconst_1 
L117:   areturn 
L118:   nop 
L119:   nop 
L120:   
    .end code 
.end method 

.method public [166] : [167] 
    .attribute [155] .code stack 2 locals 0 
L0:     aload_0 
L1:     fload_1 
L2:     invokespecial [32] 
L5:     aload_0 
L6:     fload_1 
L7:     invokespecial [30] 
L10:    ifeq L23 
L13:    aload_0 
L14:    iconst_1 
L15:    invokevirtual [16] 
L18:    aload_0 
L19:    iconst_1 
L20:    invokevirtual [17] 
L23:    return 
L24:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Int 14808325 
.const [3] = String [36] 
.const [4] = String [37] 
.const [5] = Int -2137614336 
.const [6] = String [38] 
.const [7] = String [39] 
.const [8] = String [40] 
.const [9] = Int 51266 
.const [10] = Class [41] 
.const [11] = Class [42] 
.const [12] = Class [43] 
.const [13] = Class [44] 
.const [14] = Class [45] 
.const [15] = Method [46] [47] 
.const [16] = Method [48] [49] 
.const [17] = Method [50] [51] 
.const [18] = Method [52] [53] 
.const [19] = Method [54] [55] 
.const [20] = Method [56] [57] 
.const [21] = Method [58] [59] 
.const [22] = Method [60] [61] 
.const [23] = Method [62] [63] 
.const [24] = Method [64] [65] 
.const [25] = Method [66] [67] 
.const [26] = Field [68] [69] 
.const [27] = Method [70] [71] 
.const [28] = Method [72] [73] 
.const [29] = Method [74] [75] 
.const [30] = Method [76] [77] 
.const [31] = Method [78] [79] 
.const [32] = Method [80] [81] 
.const [33] = InterfaceMethod [82] [83] 
.const [34] = Field [84] [85] 
.const [35] = InterfaceMethod [86] [87] 
.const [36] = Utf8 'CtxAutozoomPositionMap#setPendingZoomLevel()' 
.const [37] = Utf8 'CtxAutozoomPositionMap#setZoomIndexAZ() - handled by CtxManoeuvrezoomPositionMap, ignored' 
.const [38] = Utf8 'CtxAutozoomPositionMap#setZoomIndexAZ() - failed: setting=%1, zoomEngineState=%2' 
.const [39] = Utf8 'CtxAutozoomPositionMap#setZoomIndexAZ() - failed: temporarily disabled' 
.const [40] = Utf8 'CtxAutozoomPositionMap#setZoomIndexAZ( %1cm )' 
.const [41] = Utf8 de/audi/tghu/navi/app/map/context/CtxAutozoomPositionMap 
.const [42] = Utf8 de/audi/tghu/navi/app/map/context/CtxManoeuvrezoomPositionMap 
.const [43] = Utf8 de/audi/tghu/navi/app/map/handler/IZoomHandler 
.const [44] = Utf8 de/audi/atip/log/LogChannel 
.const [45] = Utf8 de/audi/tghu/navi/app/map/MapDataContainer 
.const [46] = Class [88] 
.const [47] = NameAndType [89] [90] 
.const [48] = Class [91] 
.const [49] = NameAndType [92] [93] 
.const [50] = Class [94] 
.const [51] = NameAndType [95] [96] 
.const [52] = Class [97] 
.const [53] = NameAndType [98] [99] 
.const [54] = Class [100] 
.const [55] = NameAndType [101] [102] 
.const [56] = Class [103] 
.const [57] = NameAndType [104] [105] 
.const [58] = Class [106] 
.const [59] = NameAndType [107] [108] 
.const [60] = Class [109] 
.const [61] = NameAndType [110] [111] 
.const [62] = Class [112] 
.const [63] = NameAndType [113] [114] 
.const [64] = Class [115] 
.const [65] = NameAndType [116] [117] 
.const [66] = Class [118] 
.const [67] = NameAndType [119] [120] 
.const [68] = Class [121] 
.const [69] = NameAndType [122] [123] 
.const [70] = Class [124] 
.const [71] = NameAndType [125] [126] 
.const [72] = Class [127] 
.const [73] = NameAndType [128] [129] 
.const [74] = Class [130] 
.const [75] = NameAndType [131] [132] 
.const [76] = Class [133] 
.const [77] = NameAndType [134] [135] 
.const [78] = Class [136] 
.const [79] = NameAndType [137] [138] 
.const [80] = Class [139] 
.const [81] = NameAndType [140] [141] 
.const [82] = Class [142] 
.const [83] = NameAndType [143] [144] 
.const [84] = Class [145] 
.const [85] = NameAndType [146] [147] 
.const [86] = Class [148] 
.const [87] = NameAndType [149] [150] 
.const [88] = Utf8 de/audi/tghu/navi/app/map/context/CtxAutozoomPositionMap 
.const [89] = Utf8 getZoomHandler 
.const [90] = Utf8 ()Lde/audi/tghu/navi/app/map/handler/IZoomHandler; 
.const [91] = Utf8 de/audi/tghu/navi/app/map/context/CtxAutozoomPositionMap 
.const [92] = Utf8 setAutoZoomIcon 
.const [93] = Utf8 (Z)V 
.const [94] = Utf8 de/audi/tghu/navi/app/map/context/CtxAutozoomPositionMap 
.const [95] = Utf8 setSoftZoom 
.const [96] = Utf8 (Z)V 
.const [97] = Utf8 de/audi/tghu/navi/app/map/context/CtxAutozoomPositionMap 
.const [98] = Utf8 showMap 
.const [99] = Utf8 (Z)V 
.const [100] = Utf8 de/audi/tghu/navi/app/map/context/CtxAutozoomPositionMap 
.const [101] = Utf8 unfreezeMap 
.const [102] = Utf8 ()V 
.const [103] = Utf8 de/audi/tghu/navi/app/map/context/CtxAutozoomPositionMap 
.const [104] = Utf8 getLogChannel 
.const [105] = Utf8 ()Lde/audi/atip/log/LogChannel; 
.const [106] = Utf8 de/audi/atip/log/LogChannel 
.const [107] = Utf8 log 
.const [108] = Utf8 (ILjava/lang/String;)Z 
.const [109] = Utf8 de/audi/tghu/navi/app/map/context/CtxAutozoomPositionMap 
.const [110] = Utf8 getZoomEngineState 
.const [111] = Utf8 ()I 
.const [112] = Utf8 de/audi/tghu/navi/app/map/context/CtxAutozoomPositionMap 
.const [113] = Utf8 getSetupAutoZoom 
.const [114] = Utf8 ()I 
.const [115] = Utf8 de/audi/atip/log/LogChannel 
.const [116] = Utf8 log 
.const [117] = Utf8 (ILjava/lang/String;JJ)Z 
.const [118] = Utf8 de/audi/tghu/navi/app/map/context/CtxAutozoomPositionMap 
.const [119] = Utf8 isAutozoomTemporarilyDisabled 
.const [120] = Utf8 ()Z 
.const [121] = Utf8 de/audi/tghu/navi/app/map/context/CtxAutozoomPositionMap 
.const [122] = Utf8 container 
.const [123] = Utf8 Lde/audi/tghu/navi/app/map/MapDataContainer; 
.const [124] = Utf8 de/audi/atip/log/LogChannel 
.const [125] = Utf8 log 
.const [126] = Utf8 (ILjava/lang/String;D)V 
.const [127] = Utf8 de/audi/tghu/navi/app/map/context/CtxManoeuvrezoomPositionMap 
.const [128] = Utf8 <init> 
.const [129] = Utf8 (Lde/audi/tghu/navi/app/NavigationEnv;Lde/audi/tghu/navi/app/map/AbstractMap;)V 
.const [130] = Utf8 de/audi/tghu/navi/app/map/context/CtxManoeuvrezoomPositionMap 
.const [131] = Utf8 enter 
.const [132] = Utf8 ()V 
.const [133] = Utf8 de/audi/tghu/navi/app/map/context/CtxAutozoomPositionMap 
.const [134] = Utf8 setZoomIndexAZ 
.const [135] = Utf8 (F)Z 
.const [136] = Utf8 de/audi/tghu/navi/app/map/context/CtxManoeuvrezoomPositionMap 
.const [137] = Utf8 setPendingZoomLevel 
.const [138] = Utf8 ()Z 
.const [139] = Utf8 de/audi/tghu/navi/app/map/context/CtxManoeuvrezoomPositionMap 
.const [140] = Utf8 updateRecommendedZoom 
.const [141] = Utf8 (F)V 
.const [142] = Utf8 de/audi/tghu/navi/app/map/handler/IZoomHandler 
.const [143] = Utf8 getRecommendedZoom 
.const [144] = Utf8 ()F 
.const [145] = Utf8 de/audi/tghu/navi/app/map/MapDataContainer 
.const [146] = Utf8 sForceRestoreUserZoomLevel 
.const [147] = Utf8 Z 
.const [148] = Utf8 de/audi/tghu/navi/app/map/handler/IZoomHandler 
.const [149] = Utf8 setZoomLevel 
.const [150] = Utf8 (F)V 
.const [151] = Utf8 de/audi/tghu/navi/app/map/context/CtxAutozoomPositionMap 
.const [152] = Class [151] 
.const [153] = Utf8 de/audi/tghu/navi/app/map/context/CtxManoeuvrezoomPositionMap 
.const [154] = Class [153] 
.const [155] = Utf8 Code 
.const [156] = Utf8 <init> 
.const [157] = Utf8 (Lde/audi/tghu/navi/app/NavigationEnv;Lde/audi/tghu/navi/app/map/AbstractMap;)V 
.const [158] = Utf8 enter 
.const [159] = Utf8 ()V 
.const [160] = Utf8 enterEpilogue 
.const [161] = Utf8 ()V 
.const [162] = Utf8 setPendingZoomLevel 
.const [163] = Utf8 ()Z 
.const [164] = Utf8 setZoomIndexAZ 
.const [165] = Utf8 (F)Z 
.const [166] = Utf8 updateRecommendedZoom 
.const [167] = Utf8 (F)V 
.end class 
