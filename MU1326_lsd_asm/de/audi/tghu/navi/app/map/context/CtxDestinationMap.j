.version 50 0 
.class public super [273] 
.super [275] 
.implements [277] 

.method public annotation [279] : [280] 
    .attribute [278] .code stack 3 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     aload_2 
L3:     invokespecial [46] 
L6:     return 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [281] : [282] 
    .attribute [278] .code stack 3 locals 3 
L0:     aload_0 
L1:     invokespecial [47] 
L4:     aload_0 
L5:     invokevirtual [22] 
L8:     astore_1 
L9:     aload_1 
L10:    getfield [23] 
L13:    aload_1 
L14:    getfield [24] 
L17:    iconst_1 
L18:    ishr 
L19:    iadd 
L20:    istore_2 
L21:    aload_1 
L22:    getfield [25] 
L25:    aload_1 
L26:    getfield [26] 
L29:    iconst_1 
L30:    ishr 
L31:    iadd 
L32:    istore_3 
L33:    aload_0 
L34:    iload_2 
L35:    iload_3 
L36:    invokevirtual [27] 
L39:    aload_0 
L40:    getfield [28] 
L43:    invokevirtual [29] 
L46:    iconst_0 
L47:    invokeinterface [54] 0 
L52:    aload_0 
L53:    getfield [28] 
L56:    invokevirtual [29] 
L59:    iconst_0 
L60:    invokeinterface [55] 0 
L65:    aload_0 
L66:    getfield [28] 
L69:    invokevirtual [29] 
L72:    iconst_2 
L73:    invokeinterface [56] 0 
L78:    aload_0 
L79:    invokevirtual [30] 
L82:    return 
L83:    nop 
L84:    
    .end code 
.end method 

.method public [283] : [284] 
    .attribute [278] .code stack 1 locals 0 
L0:     aload_0 
L1:     invokespecial [48] 
L4:     aload_0 
L5:     invokevirtual [31] 
L8:     return 
L9:     nop 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method public [285] : [286] 
    .attribute [278] .code stack 1 locals 0 
L0:     aload_0 
L1:     invokespecial [49] 
L4:     aload_0 
L5:     invokevirtual [31] 
L8:     return 
L9:     nop 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method public [287] : [288] 
    .attribute [278] .code stack 5 locals 0 
L0:     aload_0 
L1:     iload_1 
L2:     invokespecial [50] 
L5:     aload_0 
L6:     invokevirtual [32] 
L9:     ldc [2] 
L11:    ldc [3] 
L13:    iload_1 
L14:    i2l 
L15:    invokevirtual [33] 
L18:    pop 
L19:    aload_0 
L20:    invokevirtual [31] 
L23:    return 
L24:    
    .end code 
.end method 

.method public [289] : [290] 
    .attribute [278] .code stack 5 locals 1 
L0:     aload_0 
L1:     iload_1 
L2:     invokespecial [51] 
L5:     aload_0 
L6:     invokevirtual [34] 
L9:     istore_2 
L10:    aload_0 
L11:    invokevirtual [32] 
L14:    ldc [2] 
L16:    ldc [4] 
L18:    iload_2 
L19:    i2l 
L20:    invokevirtual [33] 
L23:    pop 
L24:    iload_2 
L25:    iconst_1 
L26:    if_icmpeq L33 
L29:    iload_2 
L30:    ifne L60 
L33:    aload_0 
L34:    invokevirtual [32] 
L37:    ldc [5] 
L39:    ldc [6] 
L41:    iload_1 
L42:    i2l 
L43:    invokevirtual [33] 
L46:    pop 
L47:    iload_1 
L48:    iconst_3 
L49:    if_icmpne L60 
L52:    aload_0 
L53:    getfield [35] 
L56:    iconst_0 
L57:    putfield [57] 
L60:    return 
L61:    nop 
L62:    nop 
L63:    nop 
L64:    
    .end code 
.end method 

.method public [291] : [292] 
    .attribute [278] .code stack 5 locals 3 
L0:     aload_0 
L1:     fload_1 
L2:     invokespecial [52] 
L5:     aload_0 
L6:     invokevirtual [34] 
L9:     istore_2 
L10:    aload_0 
L11:    invokevirtual [32] 
L14:    ldc [2] 
L16:    ldc [7] 
L18:    iload_2 
L19:    i2l 
L20:    invokevirtual [33] 
L23:    pop 
L24:    iload_2 
L25:    iconst_1 
L26:    if_icmpeq L33 
L29:    iload_2 
L30:    ifne L87 
L33:    aload_0 
L34:    invokevirtual [37] 
L37:    istore_3 
L38:    aload_0 
L39:    invokevirtual [32] 
L42:    ldc [5] 
L44:    ldc [8] 
L46:    iload_3 
L47:    i2l 
L48:    invokevirtual [33] 
L51:    pop 
L52:    aload_0 
L53:    getfield [35] 
L56:    getfield [36] 
L59:    ifne L87 
L62:    iload_3 
L63:    iconst_3 
L64:    if_icmpne L87 
L67:    aload_0 
L68:    getfield [28] 
L71:    astore 4 
L73:    aload 4 
L75:    bipush 8 
L77:    invokevirtual [38] 
L80:    aload 4 
L82:    bipush 11 
L84:    invokevirtual [39] 
L87:    return 
L88:    
    .end code 
.end method 

.method protected [293] : [294] 
    .attribute [278] .code stack 7 locals 4 
L0:     aload_0 
L1:     getfield [28] 
L4:     invokevirtual [40] 
L7:     astore_1 
L8:     aload_1 
L9:     invokeinterface [58] 0 
L14:    istore_3 
L15:    aload_1 
L16:    invokeinterface [59] 0 
L21:    istore 4 
L23:    aload_0 
L24:    invokevirtual [32] 
L27:    ldc [2] 
L29:    ldc [9] 
L31:    iload_3 
L32:    i2l 
L33:    iload 4 
L35:    i2l 
L36:    invokevirtual [41] 
L39:    pop 
L40:    aload_0 
L41:    invokevirtual [42] 
L44:    ifeq L84 
L47:    iload 4 
L49:    iconst_1 
L50:    if_icmpeq L61 
L53:    iload_3 
L54:    iload 4 
L56:    iconst_1 
L57:    isub 
L58:    if_icmpne L66 
L61:    iconst_1 
L62:    istore_2 
L63:    goto L88 
L66:    iload 4 
L68:    iconst_1 
L69:    if_icmple L77 
L72:    iconst_2 
L73:    istore_2 
L74:    goto L88 
L77:    iconst_0 
L78:    istore_2 
L79:    iconst_m1 
L80:    istore_3 
L81:    goto L88 
L84:    iconst_0 
L85:    istore_2 
L86:    iconst_m1 
L87:    istore_3 
L88:    aload_0 
L89:    invokevirtual [32] 
L92:    ldc [10] 
L94:    ldc [11] 
L96:    iload_2 
L97:    i2l 
L98:    iload_3 
L99:    i2l 
L100:   invokevirtual [41] 
L103:   pop 
L104:   aload_0 
L105:   invokevirtual [43] 
L108:   aload_0 
L109:   getfield [28] 
L112:   invokevirtual [29] 
L115:   iload_2 
L116:   iload_3 
L117:   invokeinterface [60] 0 
L122:   return 
L123:   nop 
L124:   
    .end code 
.end method 

.method public [295] : [296] 
    .attribute [278] .code stack 2 locals 0 
L0:     aload_0 
L1:     iload_1 
L2:     invokespecial [53] 
L5:     aload_0 
L6:     invokevirtual [31] 
L9:     return 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method public [297] : [298] 
    .attribute [278] .code stack 1 locals 0 
L0:     iconst_1 
L1:     areturn 
L2:     nop 
L3:     nop 
L4:     
    .end code 
.end method 

.method public [299] : [300] 
    .attribute [278] .code stack 1 locals 0 
L0:     ldc [12] 
L2:     areturn 
L3:     nop 
L4:     
    .end code 
.end method 

.method protected [301] : [302] 
    .attribute [278] .code stack 3 locals 0 
L0:     aload_0 
L1:     invokevirtual [32] 
L4:     ldc [2] 
L6:     ldc [13] 
L8:     invokevirtual [44] 
L11:    pop 
L12:    aload_0 
L13:    invokevirtual [45] 
L16:    bipush 11 
L18:    invokevirtual [39] 
L21:    aload_0 
L22:    invokevirtual [45] 
L25:    bipush 12 
L27:    invokevirtual [38] 
L30:    return 
L31:    nop 
L32:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Int -2137614336 
.const [3] = String [61] 
.const [4] = String [62] 
.const [5] = Int 14808325 
.const [6] = String [63] 
.const [7] = String [64] 
.const [8] = String [65] 
.const [9] = String [66] 
.const [10] = Int 1078071040 
.const [11] = String [67] 
.const [12] = Int 51267 
.const [13] = String [68] 
.const [14] = Class [69] 
.const [15] = Class [70] 
.const [16] = Class [71] 
.const [17] = Class [72] 
.const [18] = Class [73] 
.const [19] = Class [74] 
.const [20] = Class [75] 
.const [21] = Class [76] 
.const [22] = Method [77] [78] 
.const [23] = Field [79] [80] 
.const [24] = Field [81] [82] 
.const [25] = Field [83] [84] 
.const [26] = Field [85] [86] 
.const [27] = Method [87] [88] 
.const [28] = Field [89] [90] 
.const [29] = Method [91] [92] 
.const [30] = Method [93] [94] 
.const [31] = Method [95] [96] 
.const [32] = Method [97] [98] 
.const [33] = Method [99] [100] 
.const [34] = Method [101] [102] 
.const [35] = Field [103] [104] 
.const [36] = Field [105] [106] 
.const [37] = Method [107] [108] 
.const [38] = Method [109] [110] 
.const [39] = Method [111] [112] 
.const [40] = Method [113] [114] 
.const [41] = Method [115] [116] 
.const [42] = Method [117] [118] 
.const [43] = Method [119] [120] 
.const [44] = Method [121] [122] 
.const [45] = Method [123] [124] 
.const [46] = Method [125] [126] 
.const [47] = Method [127] [128] 
.const [48] = Method [129] [130] 
.const [49] = Method [131] [132] 
.const [50] = Method [133] [134] 
.const [51] = Method [135] [136] 
.const [52] = Method [137] [138] 
.const [53] = Method [139] [140] 
.const [54] = InterfaceMethod [141] [142] 
.const [55] = InterfaceMethod [143] [144] 
.const [56] = InterfaceMethod [145] [146] 
.const [57] = Field [147] [148] 
.const [58] = InterfaceMethod [149] [150] 
.const [59] = InterfaceMethod [151] [152] 
.const [60] = InterfaceMethod [153] [154] 
.const [61] = Utf8 'CtxDestinationMap#updateManoeuvreViewActive( %1 )' 
.const [62] = Utf8 'CtxDestinationMap#updateZoomEngineState - setupAutoZoom = %1' 
.const [63] = Utf8 'CtxDestinationMap#updateZoomEngineState - zoomEngineState = %1' 
.const [64] = Utf8 'CtxDestinationMap#updateRecommendedZoom - setupAutoZoom = %1' 
.const [65] = Utf8 'CtxDestinationMap#updateRecommendedZoom - zoomEngineState = %1' 
.const [66] = Utf8 'CtxDestinationMap#setMapPosition(): currentDestIndex=%1, routeLength=%2' 
.const [67] = Utf8 'CtxDestinationMap#setMapPosition(): locationType=%1, stopoverNumber=%2' 
.const [68] = Utf8 'CtxDestinationMap#onDDSClicked()' 
.const [69] = Utf8 de/audi/tghu/navi/app/map/context/CtxDestinationMap 
.const [70] = Utf8 de/audi/tghu/navi/app/map/context/CtxShown 
.const [71] = Utf8 org/dsi/ifc/map/Rect 
.const [72] = Utf8 de/audi/tghu/navi/app/map/AbstractMap 
.const [73] = Utf8 de/audi/tghu/navi/app/map/dsi/IMapRequest 
.const [74] = Utf8 de/audi/atip/log/LogChannel 
.const [75] = Utf8 de/audi/tghu/navi/app/map/MapDataContainer 
.const [76] = Utf8 de/audi/tghu/navi/app/map/INaviInterface 
.const [77] = Class [155] 
.const [78] = NameAndType [156] [157] 
.const [79] = Class [158] 
.const [80] = NameAndType [159] [160] 
.const [81] = Class [161] 
.const [82] = NameAndType [162] [163] 
.const [83] = Class [164] 
.const [84] = NameAndType [165] [166] 
.const [85] = Class [167] 
.const [86] = NameAndType [168] [169] 
.const [87] = Class [170] 
.const [88] = NameAndType [171] [172] 
.const [89] = Class [173] 
.const [90] = NameAndType [174] [175] 
.const [91] = Class [176] 
.const [92] = NameAndType [177] [178] 
.const [93] = Class [179] 
.const [94] = NameAndType [180] [181] 
.const [95] = Class [182] 
.const [96] = NameAndType [183] [184] 
.const [97] = Class [185] 
.const [98] = NameAndType [186] [187] 
.const [99] = Class [188] 
.const [100] = NameAndType [189] [190] 
.const [101] = Class [191] 
.const [102] = NameAndType [192] [193] 
.const [103] = Class [194] 
.const [104] = NameAndType [195] [196] 
.const [105] = Class [197] 
.const [106] = NameAndType [198] [199] 
.const [107] = Class [200] 
.const [108] = NameAndType [201] [202] 
.const [109] = Class [203] 
.const [110] = NameAndType [204] [205] 
.const [111] = Class [206] 
.const [112] = NameAndType [207] [208] 
.const [113] = Class [209] 
.const [114] = NameAndType [210] [211] 
.const [115] = Class [212] 
.const [116] = NameAndType [213] [214] 
.const [117] = Class [215] 
.const [118] = NameAndType [216] [217] 
.const [119] = Class [218] 
.const [120] = NameAndType [219] [220] 
.const [121] = Class [221] 
.const [122] = NameAndType [222] [223] 
.const [123] = Class [224] 
.const [124] = NameAndType [225] [226] 
.const [125] = Class [227] 
.const [126] = NameAndType [228] [229] 
.const [127] = Class [230] 
.const [128] = NameAndType [231] [232] 
.const [129] = Class [233] 
.const [130] = NameAndType [234] [235] 
.const [131] = Class [236] 
.const [132] = NameAndType [237] [238] 
.const [133] = Class [239] 
.const [134] = NameAndType [240] [241] 
.const [135] = Class [242] 
.const [136] = NameAndType [243] [244] 
.const [137] = Class [245] 
.const [138] = NameAndType [246] [247] 
.const [139] = Class [248] 
.const [140] = NameAndType [249] [250] 
.const [141] = Class [251] 
.const [142] = NameAndType [252] [253] 
.const [143] = Class [254] 
.const [144] = NameAndType [255] [256] 
.const [145] = Class [257] 
.const [146] = NameAndType [258] [259] 
.const [147] = Class [260] 
.const [148] = NameAndType [261] [262] 
.const [149] = Class [263] 
.const [150] = NameAndType [264] [265] 
.const [151] = Class [266] 
.const [152] = NameAndType [267] [268] 
.const [153] = Class [269] 
.const [154] = NameAndType [270] [271] 
.const [155] = Utf8 de/audi/tghu/navi/app/map/context/CtxDestinationMap 
.const [156] = Utf8 getVisibleArea 
.const [157] = Utf8 ()Lorg/dsi/ifc/map/Rect; 
.const [158] = Utf8 org/dsi/ifc/map/Rect 
.const [159] = Utf8 kordX 
.const [160] = Utf8 I 
.const [161] = Utf8 org/dsi/ifc/map/Rect 
.const [162] = Utf8 diffX 
.const [163] = Utf8 I 
.const [164] = Utf8 org/dsi/ifc/map/Rect 
.const [165] = Utf8 kordY 
.const [166] = Utf8 I 
.const [167] = Utf8 org/dsi/ifc/map/Rect 
.const [168] = Utf8 diffY 
.const [169] = Utf8 I 
.const [170] = Utf8 de/audi/tghu/navi/app/map/context/CtxDestinationMap 
.const [171] = Utf8 setHotPoint 
.const [172] = Utf8 (II)V 
.const [173] = Utf8 de/audi/tghu/navi/app/map/context/CtxDestinationMap 
.const [174] = Utf8 naviMap 
.const [175] = Utf8 Lde/audi/tghu/navi/app/map/AbstractMap; 
.const [176] = Utf8 de/audi/tghu/navi/app/map/AbstractMap 
.const [177] = Utf8 getMVRequest 
.const [178] = Utf8 ()Lde/audi/tghu/navi/app/map/dsi/IMapRequest; 
.const [179] = Utf8 de/audi/tghu/navi/app/map/context/CtxDestinationMap 
.const [180] = Utf8 refreshCarPositionForZoomEngine 
.const [181] = Utf8 ()V 
.const [182] = Utf8 de/audi/tghu/navi/app/map/context/CtxDestinationMap 
.const [183] = Utf8 setMapPosition 
.const [184] = Utf8 ()V 
.const [185] = Utf8 de/audi/tghu/navi/app/map/context/CtxDestinationMap 
.const [186] = Utf8 getLogChannel 
.const [187] = Utf8 ()Lde/audi/atip/log/LogChannel; 
.const [188] = Utf8 de/audi/atip/log/LogChannel 
.const [189] = Utf8 log 
.const [190] = Utf8 (ILjava/lang/String;J)Z 
.const [191] = Utf8 de/audi/tghu/navi/app/map/context/CtxDestinationMap 
.const [192] = Utf8 getSetupAutoZoom 
.const [193] = Utf8 ()I 
.const [194] = Utf8 de/audi/tghu/navi/app/map/context/CtxDestinationMap 
.const [195] = Utf8 container 
.const [196] = Utf8 Lde/audi/tghu/navi/app/map/MapDataContainer; 
.const [197] = Utf8 de/audi/tghu/navi/app/map/MapDataContainer 
.const [198] = Utf8 sManoeuvreZoomDisabledWithReturn 
.const [199] = Utf8 Z 
.const [200] = Utf8 de/audi/tghu/navi/app/map/context/CtxDestinationMap 
.const [201] = Utf8 getZoomEngineState 
.const [202] = Utf8 ()I 
.const [203] = Utf8 de/audi/tghu/navi/app/map/AbstractMap 
.const [204] = Utf8 switchToContext 
.const [205] = Utf8 (I)V 
.const [206] = Utf8 de/audi/tghu/navi/app/map/AbstractMap 
.const [207] = Utf8 setSwitchBackToContext 
.const [208] = Utf8 (I)V 
.const [209] = Utf8 de/audi/tghu/navi/app/map/AbstractMap 
.const [210] = Utf8 getNaviInterface 
.const [211] = Utf8 ()Lde/audi/tghu/navi/app/map/INaviInterface; 
.const [212] = Utf8 de/audi/atip/log/LogChannel 
.const [213] = Utf8 log 
.const [214] = Utf8 (ILjava/lang/String;JJ)Z 
.const [215] = Utf8 de/audi/tghu/navi/app/map/context/CtxDestinationMap 
.const [216] = Utf8 getRGActive 
.const [217] = Utf8 ()Z 
.const [218] = Utf8 de/audi/tghu/navi/app/map/context/CtxDestinationMap 
.const [219] = Utf8 setVisibleArea 
.const [220] = Utf8 ()V 
.const [221] = Utf8 de/audi/atip/log/LogChannel 
.const [222] = Utf8 log 
.const [223] = Utf8 (ILjava/lang/String;)Z 
.const [224] = Utf8 de/audi/tghu/navi/app/map/context/CtxDestinationMap 
.const [225] = Utf8 getMap 
.const [226] = Utf8 ()Lde/audi/tghu/navi/app/map/AbstractMap; 
.const [227] = Utf8 de/audi/tghu/navi/app/map/context/CtxShown 
.const [228] = Utf8 <init> 
.const [229] = Utf8 (Lde/audi/tghu/navi/app/NavigationEnv;Lde/audi/tghu/navi/app/map/AbstractMap;)V 
.const [230] = Utf8 de/audi/tghu/navi/app/map/context/CtxShown 
.const [231] = Utf8 enter 
.const [232] = Utf8 ()V 
.const [233] = Utf8 de/audi/tghu/navi/app/map/context/CtxShown 
.const [234] = Utf8 stopoverHasBeenPassed 
.const [235] = Utf8 ()V 
.const [236] = Utf8 de/audi/tghu/navi/app/map/context/CtxShown 
.const [237] = Utf8 initAdditionalInfos 
.const [238] = Utf8 ()V 
.const [239] = Utf8 de/audi/tghu/navi/app/map/context/CtxShown 
.const [240] = Utf8 updateManoeuvreViewActive 
.const [241] = Utf8 (I)V 
.const [242] = Utf8 de/audi/tghu/navi/app/map/context/CtxShown 
.const [243] = Utf8 updateZoomEngineState 
.const [244] = Utf8 (I)V 
.const [245] = Utf8 de/audi/tghu/navi/app/map/context/CtxShown 
.const [246] = Utf8 updateRecommendedZoom 
.const [247] = Utf8 (F)V 
.const [248] = Utf8 de/audi/tghu/navi/app/map/context/CtxShown 
.const [249] = Utf8 updateRgActive 
.const [250] = Utf8 (Z)V 
.const [251] = Utf8 de/audi/tghu/navi/app/map/dsi/IMapRequest 
.const [252] = Utf8 setViewType 
.const [253] = Utf8 (I)V 
.const [254] = Utf8 de/audi/tghu/navi/app/map/dsi/IMapRequest 
.const [255] = Utf8 setRotation 
.const [256] = Utf8 (S)V 
.const [257] = Utf8 de/audi/tghu/navi/app/map/dsi/IMapRequest 
.const [258] = Utf8 setOrientation 
.const [259] = Utf8 (I)V 
.const [260] = Utf8 de/audi/tghu/navi/app/map/MapDataContainer 
.const [261] = Utf8 sManoeuvreZoomDisabledWithReturn 
.const [262] = Utf8 Z 
.const [263] = Utf8 de/audi/tghu/navi/app/map/INaviInterface 
.const [264] = Utf8 getIndexOfCurrentDestination 
.const [265] = Utf8 ()I 
.const [266] = Utf8 de/audi/tghu/navi/app/map/INaviInterface 
.const [267] = Utf8 getRouteListLength 
.const [268] = Utf8 ()I 
.const [269] = Utf8 de/audi/tghu/navi/app/map/dsi/IMapRequest 
.const [270] = Utf8 setLocation 
.const [271] = Utf8 (II)V 
.const [272] = Utf8 de/audi/tghu/navi/app/map/context/CtxDestinationMap 
.const [273] = Class [272] 
.const [274] = Utf8 de/audi/tghu/navi/app/map/context/CtxShown 
.const [275] = Class [274] 
.const [276] = Utf8 de/audi/tghu/navi/app/map/context/CTags$HasDefaultZoom 
.const [277] = Class [276] 
.const [278] = Utf8 Code 
.const [279] = Utf8 <init> 
.const [280] = Utf8 (Lde/audi/tghu/navi/app/NavigationEnv;Lde/audi/tghu/navi/app/map/AbstractMap;)V 
.const [281] = Utf8 enter 
.const [282] = Utf8 ()V 
.const [283] = Utf8 stopoverHasBeenPassed 
.const [284] = Utf8 ()V 
.const [285] = Utf8 initAdditionalInfos 
.const [286] = Utf8 ()V 
.const [287] = Utf8 updateManoeuvreViewActive 
.const [288] = Utf8 (I)V 
.const [289] = Utf8 updateZoomEngineState 
.const [290] = Utf8 (I)V 
.const [291] = Utf8 updateRecommendedZoom 
.const [292] = Utf8 (F)V 
.const [293] = Utf8 setMapPosition 
.const [294] = Utf8 ()V 
.const [295] = Utf8 updateRgActive 
.const [296] = Utf8 (Z)V 
.const [297] = Utf8 supportsAdditionalInfo 
.const [298] = Utf8 ()Z 
.const [299] = Utf8 getDefaultZoomLevel 
.const [300] = Utf8 ()F 
.const [301] = Utf8 onDDSClicked 
.const [302] = Utf8 ()V 
.end class 
