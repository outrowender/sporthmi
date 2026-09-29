.version 50 0 
.class public final super [207] 
.super [209] 
.implements [211] 
.field private [212] [213] 
.field private [214] [215] 
.field private [216] [217] 
.field private [218] [219] 

.method public [221] : [222] 
    .attribute [220] .code stack 2 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     invokevirtual [19] 
L5:     invokespecial [37] 
L8:     aload_0 
L9:     iconst_0 
L10:    putfield [38] 
L13:    aload_0 
L14:    iconst_0 
L15:    putfield [39] 
L18:    aload_0 
L19:    iconst_m1 
L20:    putfield [40] 
L23:    aload_0 
L24:    ldc [2] 
L26:    putfield [41] 
L29:    aload_0 
L30:    aload_1 
L31:    invokevirtual [24] 
L34:    return 
L35:    nop 
L36:    
    .end code 
.end method 

.method public [223] : [224] 
    .attribute [220] .code stack 2 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     invokespecial [37] 
L5:     aload_0 
L6:     iconst_0 
L7:     putfield [38] 
L10:    aload_0 
L11:    iconst_0 
L12:    putfield [39] 
L15:    aload_0 
L16:    iconst_m1 
L17:    putfield [40] 
L20:    aload_0 
L21:    ldc [2] 
L23:    putfield [41] 
L26:    return 
L27:    nop 
L28:    
    .end code 
.end method 

.method public [225] : [226] 
    .attribute [220] .code stack 1 locals 0 
L0:     ldc [3] 
L2:     areturn 
L3:     nop 
L4:     
    .end code 
.end method 

.method public [227] : [228] 
    .attribute [220] .code stack 4 locals 0 
L0:     iload_2 
L1:     iconst_1 
L2:     if_icmpne L36 
L5:     aload_0 
L6:     invokevirtual [25] 
L9:     ldc [4] 
L11:    ldc [5] 
L13:    iload_1 
L14:    invokevirtual [26] 
L17:    pop 
L18:    aload_0 
L19:    iload_1 
L20:    putfield [38] 
L23:    aload_0 
L24:    getfield [27] 
L27:    invokevirtual [28] 
L30:    iload_1 
L31:    invokeinterface [42] 0 
L36:    return 
L37:    nop 
L38:    nop 
L39:    nop 
L40:    
    .end code 
.end method 

.method public interface [229] : [230] 
    .attribute [220] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [20] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [231] : [232] 
    .attribute [220] .code stack 4 locals 0 
L0:     iload_2 
L1:     iconst_1 
L2:     if_icmpne L36 
L5:     aload_0 
L6:     invokevirtual [25] 
L9:     ldc [4] 
L11:    ldc [6] 
L13:    iload_1 
L14:    invokevirtual [26] 
L17:    pop 
L18:    aload_0 
L19:    iload_1 
L20:    putfield [39] 
L23:    aload_0 
L24:    getfield [27] 
L27:    invokevirtual [28] 
L30:    iload_1 
L31:    invokeinterface [43] 0 
L36:    return 
L37:    nop 
L38:    nop 
L39:    nop 
L40:    
    .end code 
.end method 

.method public interface [233] : [234] 
    .attribute [220] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [21] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [235] : [236] 
    .attribute [220] .code stack 5 locals 0 
L0:     iload_2 
L1:     iconst_1 
L2:     if_icmpne L104 
L5:     aload_0 
L6:     invokevirtual [25] 
L9:     ldc [4] 
L11:    ldc [7] 
L13:    iload_1 
L14:    i2l 
L15:    invokevirtual [29] 
L18:    pop 
L19:    aload_0 
L20:    iload_1 
L21:    putfield [40] 
L24:    aload_0 
L25:    getfield [27] 
L28:    invokevirtual [28] 
L31:    iload_1 
L32:    invokeinterface [44] 0 
L37:    aload_0 
L38:    invokevirtual [30] 
L41:    ifnonnull L45 
L44:    return 
L45:    aload_0 
L46:    invokevirtual [30] 
L49:    invokevirtual [31] 
L52:    ifeq L76 
L55:    aload_0 
L56:    getfield [27] 
L59:    invokevirtual [32] 
L62:    invokevirtual [33] 
L65:    bipush 104 
L67:    iload_1 
L68:    invokeinterface [45] 0 
L73:    goto L104 
L76:    aload_0 
L77:    invokevirtual [30] 
L80:    invokevirtual [34] 
L83:    ifeq L104 
L86:    aload_0 
L87:    getfield [27] 
L90:    invokevirtual [32] 
L93:    invokevirtual [33] 
L96:    bipush 107 
L98:    iload_1 
L99:    invokeinterface [45] 0 
L104:   return 
L105:   nop 
L106:   nop 
L107:   nop 
L108:   
    .end code 
.end method 

.method public interface [237] : [238] 
    .attribute [220] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [22] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [239] : [240] 
    .attribute [220] .code stack 4 locals 0 
L0:     iload_2 
L1:     iconst_1 
L2:     if_icmpne L42 
L5:     aload_0 
L6:     invokevirtual [25] 
L9:     ldc [4] 
L11:    ldc [8] 
L13:    fload_1 
L14:    invokestatic [9] 
L17:    invokevirtual [35] 
L20:    pop 
L21:    aload_0 
L22:    fload_1 
L23:    putfield [41] 
L26:    aload_0 
L27:    getfield [27] 
L30:    invokevirtual [28] 
L33:    aload_0 
L34:    getfield [23] 
L37:    invokeinterface [46] 0 
L42:    return 
L43:    nop 
L44:    
    .end code 
.end method 

.method public interface [241] : [242] 
    .attribute [220] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [23] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [243] : [244] 
    .attribute [220] .code stack 8 locals 0 
L0:     aload_0 
L1:     invokevirtual [25] 
L4:     sipush 10000 
L7:     ldc [10] 
L9:     aload_2 
L10:    iload_1 
L11:    i2l 
L12:    iload_3 
L13:    i2l 
L14:    invokevirtual [36] 
L17:    pop 
L18:    return 
L19:    nop 
L20:    
    .end code 
.end method 

.method public [245] : [246] 
    .attribute [220] .code stack 2 locals 0 
L0:     aload_0 
L1:     iconst_0 
L2:     putfield [38] 
L5:     aload_0 
L6:     iconst_0 
L7:     putfield [39] 
L10:    aload_0 
L11:    iconst_m1 
L12:    putfield [40] 
L15:    aload_0 
L16:    ldc [2] 
L18:    putfield [41] 
L21:    return 
L22:    nop 
L23:    nop 
L24:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Int 32959 
.const [3] = String [47] 
.const [4] = Int -2137614336 
.const [5] = String [48] 
.const [6] = String [49] 
.const [7] = String [50] 
.const [8] = String [51] 
.const [9] = Method [52] [53] 
.const [10] = String [54] 
.const [11] = Class [55] 
.const [12] = Class [56] 
.const [13] = Class [57] 
.const [14] = Class [58] 
.const [15] = Class [59] 
.const [16] = Class [60] 
.const [17] = Class [61] 
.const [18] = Class [62] 
.const [19] = Method [63] [64] 
.const [20] = Field [65] [66] 
.const [21] = Field [67] [68] 
.const [22] = Field [69] [70] 
.const [23] = Field [71] [72] 
.const [24] = Method [73] [74] 
.const [25] = Method [75] [76] 
.const [26] = Method [77] [78] 
.const [27] = Field [79] [80] 
.const [28] = Method [81] [82] 
.const [29] = Method [83] [84] 
.const [30] = Method [85] [86] 
.const [31] = Method [87] [88] 
.const [32] = Method [89] [90] 
.const [33] = Method [91] [92] 
.const [34] = Method [93] [94] 
.const [35] = Method [95] [96] 
.const [36] = Method [97] [98] 
.const [37] = Method [99] [100] 
.const [38] = Field [101] [102] 
.const [39] = Field [103] [104] 
.const [40] = Field [105] [106] 
.const [41] = Field [107] [108] 
.const [42] = InterfaceMethod [109] [110] 
.const [43] = InterfaceMethod [111] [112] 
.const [44] = InterfaceMethod [113] [114] 
.const [45] = InterfaceMethod [115] [116] 
.const [46] = InterfaceMethod [117] [118] 
.const [47] = Utf8 MVResponseZoomEngine 
.const [48] = Utf8 'MVResponseZoomEngine#updateAutoZoomEnabled(%1)' 
.const [49] = Utf8 'MVResponseZoomEngine#updateManoeuvreZoomEnabled(%1)' 
.const [50] = Utf8 'MVResponseZoomEngine#updateZoomEngineState(%1) - 0:off/1:ready/2:auto/3:mano' 
.const [51] = Utf8 'MVResponseZoomEngine#updateRecommendedZoom(%1)' 
.const [52] = Class [119] 
.const [53] = NameAndType [120] [121] 
.const [54] = Utf8 'MVResponseZoomEngine#asyncException(): code = %2, msg = %1, type = %3' 
.const [55] = Utf8 de/audi/tghu/navi/app/map/dsi/MVResponseZoomEngine 
.const [56] = Utf8 de/audi/tghu/navi/app/map/dsi/AbstractResponser 
.const [57] = Utf8 de/audi/tghu/navi/app/map/AbstractMap 
.const [58] = Utf8 de/audi/atip/log/LogChannel 
.const [59] = Utf8 de/audi/tghu/navi/app/map/handler/ZoomEventListener 
.const [60] = Utf8 de/audi/tghu/navi/app/map/MapManager 
.const [61] = Utf8 de/audi/tghu/navi/app/map/event/IEventBroker 
.const [62] = Utf8 java/lang/Float 
.const [63] = Class [122] 
.const [64] = NameAndType [123] [124] 
.const [65] = Class [125] 
.const [66] = NameAndType [126] [127] 
.const [67] = Class [128] 
.const [68] = NameAndType [129] [130] 
.const [69] = Class [131] 
.const [70] = NameAndType [132] [133] 
.const [71] = Class [134] 
.const [72] = NameAndType [135] [136] 
.const [73] = Class [137] 
.const [74] = NameAndType [138] [139] 
.const [75] = Class [140] 
.const [76] = NameAndType [141] [142] 
.const [77] = Class [143] 
.const [78] = NameAndType [144] [145] 
.const [79] = Class [146] 
.const [80] = NameAndType [147] [148] 
.const [81] = Class [149] 
.const [82] = NameAndType [150] [151] 
.const [83] = Class [152] 
.const [84] = NameAndType [153] [154] 
.const [85] = Class [155] 
.const [86] = NameAndType [156] [157] 
.const [87] = Class [158] 
.const [88] = NameAndType [159] [160] 
.const [89] = Class [161] 
.const [90] = NameAndType [162] [163] 
.const [91] = Class [164] 
.const [92] = NameAndType [165] [166] 
.const [93] = Class [167] 
.const [94] = NameAndType [168] [169] 
.const [95] = Class [170] 
.const [96] = NameAndType [171] [172] 
.const [97] = Class [173] 
.const [98] = NameAndType [174] [175] 
.const [99] = Class [176] 
.const [100] = NameAndType [177] [178] 
.const [101] = Class [179] 
.const [102] = NameAndType [180] [181] 
.const [103] = Class [182] 
.const [104] = NameAndType [183] [184] 
.const [105] = Class [185] 
.const [106] = NameAndType [186] [187] 
.const [107] = Class [188] 
.const [108] = NameAndType [189] [190] 
.const [109] = Class [191] 
.const [110] = NameAndType [192] [193] 
.const [111] = Class [194] 
.const [112] = NameAndType [195] [196] 
.const [113] = Class [197] 
.const [114] = NameAndType [198] [199] 
.const [115] = Class [200] 
.const [116] = NameAndType [201] [202] 
.const [117] = Class [203] 
.const [118] = NameAndType [204] [205] 
.const [119] = Utf8 java/lang/Float 
.const [120] = Utf8 toString 
.const [121] = Utf8 (F)Ljava/lang/String; 
.const [122] = Utf8 de/audi/tghu/navi/app/map/AbstractMap 
.const [123] = Utf8 getMapDSILogChannel 
.const [124] = Utf8 ()Lde/audi/atip/log/LogChannel; 
.const [125] = Utf8 de/audi/tghu/navi/app/map/dsi/MVResponseZoomEngine 
.const [126] = Utf8 mAutoZoom 
.const [127] = Utf8 Z 
.const [128] = Utf8 de/audi/tghu/navi/app/map/dsi/MVResponseZoomEngine 
.const [129] = Utf8 mManoeuvreZoom 
.const [130] = Utf8 Z 
.const [131] = Utf8 de/audi/tghu/navi/app/map/dsi/MVResponseZoomEngine 
.const [132] = Utf8 mZoomEngineState 
.const [133] = Utf8 I 
.const [134] = Utf8 de/audi/tghu/navi/app/map/dsi/MVResponseZoomEngine 
.const [135] = Utf8 mRecommendedZoom 
.const [136] = Utf8 F 
.const [137] = Utf8 de/audi/tghu/navi/app/map/dsi/MVResponseZoomEngine 
.const [138] = Utf8 bind 
.const [139] = Utf8 (Lde/audi/tghu/navi/app/map/AbstractMap;)V 
.const [140] = Utf8 de/audi/tghu/navi/app/map/dsi/MVResponseZoomEngine 
.const [141] = Utf8 getLogger 
.const [142] = Utf8 ()Lde/audi/atip/log/LogChannel; 
.const [143] = Utf8 de/audi/atip/log/LogChannel 
.const [144] = Utf8 log 
.const [145] = Utf8 (ILjava/lang/String;Z)Z 
.const [146] = Utf8 de/audi/tghu/navi/app/map/dsi/MVResponseZoomEngine 
.const [147] = Utf8 naviMap 
.const [148] = Utf8 Lde/audi/tghu/navi/app/map/AbstractMap; 
.const [149] = Utf8 de/audi/tghu/navi/app/map/AbstractMap 
.const [150] = Utf8 getZoomEventListener 
.const [151] = Utf8 ()Lde/audi/tghu/navi/app/map/handler/ZoomEventListener; 
.const [152] = Utf8 de/audi/atip/log/LogChannel 
.const [153] = Utf8 log 
.const [154] = Utf8 (ILjava/lang/String;J)Z 
.const [155] = Utf8 de/audi/tghu/navi/app/map/dsi/MVResponseZoomEngine 
.const [156] = Utf8 getMap 
.const [157] = Utf8 ()Lde/audi/tghu/navi/app/map/AbstractMap; 
.const [158] = Utf8 de/audi/tghu/navi/app/map/AbstractMap 
.const [159] = Utf8 isMapMain 
.const [160] = Utf8 ()Z 
.const [161] = Utf8 de/audi/tghu/navi/app/map/AbstractMap 
.const [162] = Utf8 getMapManager 
.const [163] = Utf8 ()Lde/audi/tghu/navi/app/map/MapManager; 
.const [164] = Utf8 de/audi/tghu/navi/app/map/MapManager 
.const [165] = Utf8 getMapEventDispatcher 
.const [166] = Utf8 ()Lde/audi/tghu/navi/app/map/event/IEventBroker; 
.const [167] = Utf8 de/audi/tghu/navi/app/map/AbstractMap 
.const [168] = Utf8 isMapKombi 
.const [169] = Utf8 ()Z 
.const [170] = Utf8 de/audi/atip/log/LogChannel 
.const [171] = Utf8 log 
.const [172] = Utf8 (ILjava/lang/String;Ljava/lang/Object;)Z 
.const [173] = Utf8 de/audi/atip/log/LogChannel 
.const [174] = Utf8 log 
.const [175] = Utf8 (ILjava/lang/String;Ljava/lang/Object;JJ)Z 
.const [176] = Utf8 de/audi/tghu/navi/app/map/dsi/AbstractResponser 
.const [177] = Utf8 <init> 
.const [178] = Utf8 (Lde/audi/atip/log/LogChannel;)V 
.const [179] = Utf8 de/audi/tghu/navi/app/map/dsi/MVResponseZoomEngine 
.const [180] = Utf8 mAutoZoom 
.const [181] = Utf8 Z 
.const [182] = Utf8 de/audi/tghu/navi/app/map/dsi/MVResponseZoomEngine 
.const [183] = Utf8 mManoeuvreZoom 
.const [184] = Utf8 Z 
.const [185] = Utf8 de/audi/tghu/navi/app/map/dsi/MVResponseZoomEngine 
.const [186] = Utf8 mZoomEngineState 
.const [187] = Utf8 I 
.const [188] = Utf8 de/audi/tghu/navi/app/map/dsi/MVResponseZoomEngine 
.const [189] = Utf8 mRecommendedZoom 
.const [190] = Utf8 F 
.const [191] = Utf8 de/audi/tghu/navi/app/map/handler/ZoomEventListener 
.const [192] = Utf8 updateAutoZoomEnabled 
.const [193] = Utf8 (Z)V 
.const [194] = Utf8 de/audi/tghu/navi/app/map/handler/ZoomEventListener 
.const [195] = Utf8 updateManoeuvreZoomEnabled 
.const [196] = Utf8 (Z)V 
.const [197] = Utf8 de/audi/tghu/navi/app/map/handler/ZoomEventListener 
.const [198] = Utf8 updateZoomEngineState 
.const [199] = Utf8 (I)V 
.const [200] = Utf8 de/audi/tghu/navi/app/map/event/IEventBroker 
.const [201] = Utf8 fireEvent 
.const [202] = Utf8 (II)V 
.const [203] = Utf8 de/audi/tghu/navi/app/map/handler/ZoomEventListener 
.const [204] = Utf8 updateRecommendedZoom 
.const [205] = Utf8 (F)V 
.const [206] = Utf8 de/audi/tghu/navi/app/map/dsi/MVResponseZoomEngine 
.const [207] = Class [206] 
.const [208] = Utf8 de/audi/tghu/navi/app/map/dsi/AbstractResponser 
.const [209] = Class [208] 
.const [210] = Utf8 org/dsi/ifc/map/DSIMapViewerZoomEngineListener 
.const [211] = Class [210] 
.const [212] = Utf8 mAutoZoom 
.const [213] = Utf8 Z 
.const [214] = Utf8 mManoeuvreZoom 
.const [215] = Utf8 Z 
.const [216] = Utf8 mZoomEngineState 
.const [217] = Utf8 I 
.const [218] = Utf8 mRecommendedZoom 
.const [219] = Utf8 F 
.const [220] = Utf8 Code 
.const [221] = Utf8 <init> 
.const [222] = Utf8 (Lde/audi/tghu/navi/app/map/AbstractMap;)V 
.const [223] = Utf8 <init> 
.const [224] = Utf8 (Lde/audi/atip/log/LogChannel;)V 
.const [225] = Utf8 getName 
.const [226] = Utf8 ()Ljava/lang/String; 
.const [227] = Utf8 updateAutoZoomEnabled 
.const [228] = Utf8 (ZI)V 
.const [229] = Utf8 getAutoZoom 
.const [230] = Utf8 ()Z 
.const [231] = Utf8 updateManoeuvreZoomEnabled 
.const [232] = Utf8 (ZI)V 
.const [233] = Utf8 getManoeuvreZoom 
.const [234] = Utf8 ()Z 
.const [235] = Utf8 updateZoomEngineState 
.const [236] = Utf8 (II)V 
.const [237] = Utf8 getZoomEngineState 
.const [238] = Utf8 ()I 
.const [239] = Utf8 updateRecommendedZoom 
.const [240] = Utf8 (FI)V 
.const [241] = Utf8 getRecommendedZoom 
.const [242] = Utf8 ()F 
.const [243] = Utf8 asyncException 
.const [244] = Utf8 (ILjava/lang/String;I)V 
.const [245] = Utf8 resetMemberVariables 
.const [246] = Utf8 ()V 
.end class 
