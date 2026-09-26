.version 50 0 
.class public final super [208] 
.super [210] 
.field private [211] [212] 
.field private [213] [214] 
.field private [215] [216] 
.field private [217] [218] 
.field private [219] [220] 
.field private [221] [222] 
.field private [223] [224] 

.method public [226] : [227] 
    .attribute [225] .code stack 2 locals 0 
L0:     aload_0 
L1:     invokespecial [41] 
L4:     aload_0 
L5:     iconst_m1 
L6:     putfield [43] 
L9:     return 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method public [228] : [229] 
    .attribute [225] .code stack 2 locals 0 
L0:     aload_0 
L1:     getfield [26] 
L4:     aload_0 
L5:     getfield [27] 
L8:     iaload 
L9:     areturn 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method public [230] : [231] 
    .attribute [225] .code stack 5 locals 2 
L0:     iconst_m1 
L1:     istore_2 
L2:     aload_1 
L3:     invokevirtual [28] 
L6:     iconst_1 
L7:     if_icmpne L12 
L10:    iconst_1 
L11:    istore_2 
L12:    aload_0 
L13:    getfield [26] 
L16:    ifnonnull L32 
L19:    getstatic [2] 
L22:    sipush 10000 
L25:    ldc [3] 
L27:    invokevirtual [29] 
L30:    pop 
L31:    return 
L32:    iconst_0 
L33:    aload_0 
L34:    getfield [26] 
L37:    arraylength 
L38:    iconst_1 
L39:    isub 
L40:    aload_0 
L41:    getfield [27] 
L44:    iload_2 
L45:    aload_1 
L46:    invokevirtual [30] 
L49:    imul 
L50:    iadd 
L51:    invokestatic [4] 
L54:    invokestatic [5] 
L57:    istore_3 
L58:    aload_0 
L59:    getfield [31] 
L62:    invokevirtual [32] 
L65:    iconst_5 
L66:    if_icmpne L83 
L69:    aload_1 
L70:    invokevirtual [28] 
L73:    iconst_1 
L74:    if_icmpne L81 
L77:    iconst_1 
L78:    goto L82 
L81:    iconst_0 
L82:    istore_3 
L83:    aload_0 
L84:    iload_3 
L85:    invokespecial [42] 
L88:    return 
L89:    nop 
L90:    nop 
L91:    nop 
L92:    
    .end code 
.end method 

.method public [232] : [233] 
    .attribute [225] .code stack 4 locals 0 
L0:     getstatic [2] 
L3:     ldc [6] 
L5:     ldc [7] 
L7:     aload_1 
L8:     invokevirtual [33] 
L11:    pop 
L12:    aload_0 
L13:    aload_1 
L14:    putfield [47] 
L17:    return 
L18:    nop 
L19:    nop 
L20:    
    .end code 
.end method 

.method public [234] : [235] 
    .attribute [225] .code stack 2 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     putfield [48] 
L5:     return 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [236] : [237] 
    .attribute [225] .code stack 2 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     putfield [46] 
L5:     return 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method private [238] : [239] 
    .attribute [225] .code stack 5 locals 1 
L0:     aload_0 
L1:     getfield [26] 
L4:     iload_1 
L5:     iaload 
L6:     istore_2 
L7:     aload_0 
L8:     getfield [34] 
L11:    ifnull L29 
L14:    aload_0 
L15:    getfield [34] 
L18:    iload_2 
L19:    aload_0 
L20:    getfield [36] 
L23:    invokevirtual [37] 
L26:    goto L40 
L29:    getstatic [2] 
L32:    ldc [6] 
L34:    ldc [8] 
L36:    invokevirtual [29] 
L39:    pop 
L40:    aload_0 
L41:    iload_1 
L42:    putfield [45] 
L45:    getstatic [2] 
L48:    ldc [6] 
L50:    ldc [9] 
L52:    iload_2 
L53:    i2l 
L54:    invokevirtual [38] 
L57:    pop 
L58:    return 
L59:    nop 
L60:    
    .end code 
.end method 

.method protected [240] : [241] 
    .attribute [225] .code stack 5 locals 0 
L0:     getstatic [2] 
L3:     ldc [6] 
L5:     ldc [10] 
L7:     iload_1 
L8:     i2l 
L9:     invokevirtual [38] 
L12:    pop 
L13:    aload_0 
L14:    iload_1 
L15:    putfield [45] 
L18:    return 
L19:    nop 
L20:    
    .end code 
.end method 

.method public [242] : [243] 
    .attribute [225] .code stack 7 locals 0 
L0:     getstatic [2] 
L3:     ldc [6] 
L5:     ldc [11] 
L7:     aload_0 
L8:     getfield [27] 
L11:    i2l 
L12:    iload_1 
L13:    i2l 
L14:    invokevirtual [39] 
L17:    pop 
L18:    aload_0 
L19:    getfield [26] 
L22:    ifnull L70 
L25:    iconst_0 
L26:    iload_1 
L27:    if_icmpgt L86 
L30:    iload_1 
L31:    aload_0 
L32:    getfield [26] 
L35:    arraylength 
L36:    if_icmpge L86 
L39:    iload_2 
L40:    ifeq L51 
L43:    aload_0 
L44:    iload_1 
L45:    invokespecial [42] 
L48:    goto L86 
L51:    getstatic [2] 
L54:    ldc [6] 
L56:    ldc [12] 
L58:    invokevirtual [29] 
L61:    pop 
L62:    aload_0 
L63:    iload_1 
L64:    putfield [45] 
L67:    goto L86 
L70:    aload_0 
L71:    iload_1 
L72:    putfield [43] 
L75:    getstatic [2] 
L78:    ldc [6] 
L80:    ldc [13] 
L82:    invokevirtual [29] 
L85:    pop 
L86:    return 
L87:    nop 
L88:    
    .end code 
.end method 

.method public [244] : [245] 
    .attribute [225] .code stack 3 locals 0 
L0:     getstatic [2] 
L3:     ldc [6] 
L5:     ldc [14] 
L7:     invokevirtual [29] 
L10:    pop 
L11:    aload_0 
L12:    aload_0 
L13:    getfield [35] 
L16:    invokestatic [15] 
L19:    putfield [44] 
L22:    aload_0 
L23:    getfield [25] 
L26:    iconst_m1 
L27:    if_icmpeq L44 
L30:    aload_0 
L31:    aload_0 
L32:    getfield [25] 
L35:    iconst_1 
L36:    invokevirtual [40] 
L39:    aload_0 
L40:    iconst_m1 
L41:    putfield [43] 
L44:    return 
L45:    nop 
L46:    nop 
L47:    nop 
L48:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Field [49] [50] 
.const [3] = String [51] 
.const [4] = Method [52] [53] 
.const [5] = Method [54] [55] 
.const [6] = Int -2137614336 
.const [7] = String [56] 
.const [8] = String [57] 
.const [9] = String [58] 
.const [10] = String [59] 
.const [11] = String [60] 
.const [12] = String [61] 
.const [13] = String [62] 
.const [14] = String [63] 
.const [15] = Method [64] [65] 
.const [16] = Class [66] 
.const [17] = Class [67] 
.const [18] = Class [68] 
.const [19] = Class [69] 
.const [20] = Class [70] 
.const [21] = Class [71] 
.const [22] = Class [72] 
.const [23] = Class [73] 
.const [24] = Class [74] 
.const [25] = Field [75] [76] 
.const [26] = Field [77] [78] 
.const [27] = Field [79] [80] 
.const [28] = Method [81] [82] 
.const [29] = Method [83] [84] 
.const [30] = Method [85] [86] 
.const [31] = Field [87] [88] 
.const [32] = Method [89] [90] 
.const [33] = Method [91] [92] 
.const [34] = Field [93] [94] 
.const [35] = Field [95] [96] 
.const [36] = Field [97] [98] 
.const [37] = Method [99] [100] 
.const [38] = Method [101] [102] 
.const [39] = Method [103] [104] 
.const [40] = Method [105] [106] 
.const [41] = Method [107] [108] 
.const [42] = Method [109] [110] 
.const [43] = Field [111] [112] 
.const [44] = Field [113] [114] 
.const [45] = Field [115] [116] 
.const [46] = Field [117] [118] 
.const [47] = Field [119] [120] 
.const [48] = Field [121] [122] 
.const [49] = Class [123] 
.const [50] = NameAndType [124] [125] 
.const [51] = Utf8 'MapScrollHandler#keyTurned zoomLevels is null.' 
.const [52] = Class [126] 
.const [53] = NameAndType [127] [128] 
.const [54] = Class [129] 
.const [55] = NameAndType [130] [131] 
.const [56] = Utf8 'MapScrollHandler#setModel model = %1' 
.const [57] = Utf8 'MapScrollHandler#setZoomLevel Model is not set.' 
.const [58] = Utf8 'MapScrollHandler#setZoomLevel zoomLevelToSet = %1' 
.const [59] = Utf8 'MapScrollHandler#setZoomLevelNoModelWrite newZoomLevelIndex = %1' 
.const [60] = Utf8 'MapZoomHandler#updateZoomLevel magnification range update (oldValue = %1, newValue = %2)' 
.const [61] = Utf8 'MapZoomHandler#updateZoomLevel only update zoomLevelIndex - used for autoZoom' 
.const [62] = Utf8 'MapZoomHandler#updateZoomLevel Zoomlevels not initialized yet.' 
.const [63] = Utf8 'MapZoomHandler#updateZoomLevels' 
.const [64] = Class [132] 
.const [65] = NameAndType [133] [134] 
.const [66] = Utf8 de/esolutions/hmi/widgets/audi/evo/high/widgets/MapDynamicSidebar$MapZoomHandler 
.const [67] = Utf8 java/lang/Object 
.const [68] = Utf8 de/audi/atip/hmi/event/WheelButtonEvent 
.const [69] = Utf8 de/esolutions/hmi/widgets/audi/base/IWidgetLogChannel 
.const [70] = Utf8 de/audi/atip/log/LogChannel 
.const [71] = Utf8 java/lang/Math 
.const [72] = Utf8 de/esolutions/hmi/widgets/audi/evo/high/widgets/MapDynamicSidebar 
.const [73] = Utf8 de/audi/atip/hmi/model/RangeModel 
.const [74] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/TouchMapHandler 
.const [75] = Class [135] 
.const [76] = NameAndType [136] [137] 
.const [77] = Class [138] 
.const [78] = NameAndType [139] [140] 
.const [79] = Class [141] 
.const [80] = NameAndType [142] [143] 
.const [81] = Class [144] 
.const [82] = NameAndType [145] [146] 
.const [83] = Class [147] 
.const [84] = NameAndType [148] [149] 
.const [85] = Class [150] 
.const [86] = NameAndType [151] [152] 
.const [87] = Class [153] 
.const [88] = NameAndType [154] [155] 
.const [89] = Class [156] 
.const [90] = NameAndType [157] [158] 
.const [91] = Class [159] 
.const [92] = NameAndType [160] [161] 
.const [93] = Class [162] 
.const [94] = NameAndType [163] [164] 
.const [95] = Class [165] 
.const [96] = NameAndType [166] [167] 
.const [97] = Class [168] 
.const [98] = NameAndType [169] [170] 
.const [99] = Class [171] 
.const [100] = NameAndType [172] [173] 
.const [101] = Class [174] 
.const [102] = NameAndType [175] [176] 
.const [103] = Class [177] 
.const [104] = NameAndType [178] [179] 
.const [105] = Class [180] 
.const [106] = NameAndType [181] [182] 
.const [107] = Class [183] 
.const [108] = NameAndType [184] [185] 
.const [109] = Class [186] 
.const [110] = NameAndType [187] [188] 
.const [111] = Class [189] 
.const [112] = NameAndType [190] [191] 
.const [113] = Class [192] 
.const [114] = NameAndType [193] [194] 
.const [115] = Class [195] 
.const [116] = NameAndType [196] [197] 
.const [117] = Class [198] 
.const [118] = NameAndType [199] [200] 
.const [119] = Class [201] 
.const [120] = NameAndType [202] [203] 
.const [121] = Class [204] 
.const [122] = NameAndType [205] [206] 
.const [123] = Utf8 de/esolutions/hmi/widgets/audi/base/IWidgetLogChannel 
.const [124] = Utf8 sideBarLogChannel 
.const [125] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [126] = Utf8 java/lang/Math 
.const [127] = Utf8 min 
.const [128] = Utf8 (II)I 
.const [129] = Utf8 java/lang/Math 
.const [130] = Utf8 max 
.const [131] = Utf8 (II)I 
.const [132] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/TouchMapHandler 
.const [133] = Utf8 updateZoomLevels 
.const [134] = Utf8 (Lde/audi/atip/hmi/model/list/TiledListModelGUI;)[I 
.const [135] = Utf8 de/esolutions/hmi/widgets/audi/evo/high/widgets/MapDynamicSidebar$MapZoomHandler 
.const [136] = Utf8 zoomLevelIndexTmp 
.const [137] = Utf8 I 
.const [138] = Utf8 de/esolutions/hmi/widgets/audi/evo/high/widgets/MapDynamicSidebar$MapZoomHandler 
.const [139] = Utf8 zoomLevels 
.const [140] = Utf8 [I 
.const [141] = Utf8 de/esolutions/hmi/widgets/audi/evo/high/widgets/MapDynamicSidebar$MapZoomHandler 
.const [142] = Utf8 zoomLevelIndex 
.const [143] = Utf8 I 
.const [144] = Utf8 de/audi/atip/hmi/event/WheelButtonEvent 
.const [145] = Utf8 getDirection 
.const [146] = Utf8 ()I 
.const [147] = Utf8 de/audi/atip/log/LogChannel 
.const [148] = Utf8 log 
.const [149] = Utf8 (ILjava/lang/String;)Z 
.const [150] = Utf8 de/audi/atip/hmi/event/WheelButtonEvent 
.const [151] = Utf8 getClickCount 
.const [152] = Utf8 ()I 
.const [153] = Utf8 de/esolutions/hmi/widgets/audi/evo/high/widgets/MapDynamicSidebar$MapZoomHandler 
.const [154] = Utf8 parentRef 
.const [155] = Utf8 Lde/esolutions/hmi/widgets/audi/evo/high/widgets/MapDynamicSidebar; 
.const [156] = Utf8 de/esolutions/hmi/widgets/audi/evo/high/widgets/MapDynamicSidebar 
.const [157] = Utf8 getCurrentState 
.const [158] = Utf8 ()I 
.const [159] = Utf8 de/audi/atip/log/LogChannel 
.const [160] = Utf8 log 
.const [161] = Utf8 (ILjava/lang/String;Ljava/lang/Object;)Z 
.const [162] = Utf8 de/esolutions/hmi/widgets/audi/evo/high/widgets/MapDynamicSidebar$MapZoomHandler 
.const [163] = Utf8 modelRef 
.const [164] = Utf8 Lde/audi/atip/hmi/model/RangeModel; 
.const [165] = Utf8 de/esolutions/hmi/widgets/audi/evo/high/widgets/MapDynamicSidebar$MapZoomHandler 
.const [166] = Utf8 zoomLevelModelRef 
.const [167] = Utf8 Lde/audi/atip/hmi/model/list/TiledListModelGUI; 
.const [168] = Utf8 de/esolutions/hmi/widgets/audi/evo/high/widgets/MapDynamicSidebar$MapZoomHandler 
.const [169] = Utf8 terminalID 
.const [170] = Utf8 I 
.const [171] = Utf8 de/audi/atip/hmi/model/RangeModel 
.const [172] = Utf8 increment 
.const [173] = Utf8 (II)V 
.const [174] = Utf8 de/audi/atip/log/LogChannel 
.const [175] = Utf8 log 
.const [176] = Utf8 (ILjava/lang/String;J)Z 
.const [177] = Utf8 de/audi/atip/log/LogChannel 
.const [178] = Utf8 log 
.const [179] = Utf8 (ILjava/lang/String;JJ)Z 
.const [180] = Utf8 de/esolutions/hmi/widgets/audi/evo/high/widgets/MapDynamicSidebar$MapZoomHandler 
.const [181] = Utf8 updateZoomLevel 
.const [182] = Utf8 (IZ)V 
.const [183] = Utf8 java/lang/Object 
.const [184] = Utf8 <init> 
.const [185] = Utf8 ()V 
.const [186] = Utf8 de/esolutions/hmi/widgets/audi/evo/high/widgets/MapDynamicSidebar$MapZoomHandler 
.const [187] = Utf8 setZoomLevel 
.const [188] = Utf8 (I)V 
.const [189] = Utf8 de/esolutions/hmi/widgets/audi/evo/high/widgets/MapDynamicSidebar$MapZoomHandler 
.const [190] = Utf8 zoomLevelIndexTmp 
.const [191] = Utf8 I 
.const [192] = Utf8 de/esolutions/hmi/widgets/audi/evo/high/widgets/MapDynamicSidebar$MapZoomHandler 
.const [193] = Utf8 zoomLevels 
.const [194] = Utf8 [I 
.const [195] = Utf8 de/esolutions/hmi/widgets/audi/evo/high/widgets/MapDynamicSidebar$MapZoomHandler 
.const [196] = Utf8 zoomLevelIndex 
.const [197] = Utf8 I 
.const [198] = Utf8 de/esolutions/hmi/widgets/audi/evo/high/widgets/MapDynamicSidebar$MapZoomHandler 
.const [199] = Utf8 parentRef 
.const [200] = Utf8 Lde/esolutions/hmi/widgets/audi/evo/high/widgets/MapDynamicSidebar; 
.const [201] = Utf8 de/esolutions/hmi/widgets/audi/evo/high/widgets/MapDynamicSidebar$MapZoomHandler 
.const [202] = Utf8 modelRef 
.const [203] = Utf8 Lde/audi/atip/hmi/model/RangeModel; 
.const [204] = Utf8 de/esolutions/hmi/widgets/audi/evo/high/widgets/MapDynamicSidebar$MapZoomHandler 
.const [205] = Utf8 zoomLevelModelRef 
.const [206] = Utf8 Lde/audi/atip/hmi/model/list/TiledListModelGUI; 
.const [207] = Utf8 de/esolutions/hmi/widgets/audi/evo/high/widgets/MapDynamicSidebar$MapZoomHandler 
.const [208] = Class [207] 
.const [209] = Utf8 java/lang/Object 
.const [210] = Class [209] 
.const [211] = Utf8 modelRef 
.const [212] = Utf8 Lde/audi/atip/hmi/model/RangeModel; 
.const [213] = Utf8 zoomLevelModelRef 
.const [214] = Utf8 Lde/audi/atip/hmi/model/list/TiledListModelGUI; 
.const [215] = Utf8 terminalID 
.const [216] = Utf8 I 
.const [217] = Utf8 zoomLevelIndex 
.const [218] = Utf8 I 
.const [219] = Utf8 zoomLevels 
.const [220] = Utf8 [I 
.const [221] = Utf8 zoomLevelIndexTmp 
.const [222] = Utf8 I 
.const [223] = Utf8 parentRef 
.const [224] = Utf8 Lde/esolutions/hmi/widgets/audi/evo/high/widgets/MapDynamicSidebar; 
.const [225] = Utf8 Code 
.const [226] = Utf8 <init> 
.const [227] = Utf8 ()V 
.const [228] = Utf8 getZoomLevel 
.const [229] = Utf8 ()I 
.const [230] = Utf8 keyTurned 
.const [231] = Utf8 (Lde/audi/atip/hmi/event/WheelButtonEvent;)V 
.const [232] = Utf8 setModel 
.const [233] = Utf8 (Lde/audi/atip/hmi/model/RangeModel;)V 
.const [234] = Utf8 setModel 
.const [235] = Utf8 (Lde/audi/atip/hmi/model/list/TiledListModelGUI;)V 
.const [236] = Utf8 setParent 
.const [237] = Utf8 (Lde/esolutions/hmi/widgets/audi/evo/high/widgets/MapDynamicSidebar;)V 
.const [238] = Utf8 setZoomLevel 
.const [239] = Utf8 (I)V 
.const [240] = Utf8 setZoomLevelNoModelWrite 
.const [241] = Utf8 (I)V 
.const [242] = Utf8 updateZoomLevel 
.const [243] = Utf8 (IZ)V 
.const [244] = Utf8 updateZoomLevels 
.const [245] = Utf8 ()V 
.end class 
