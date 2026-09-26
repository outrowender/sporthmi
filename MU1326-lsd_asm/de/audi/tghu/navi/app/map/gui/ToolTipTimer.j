.version 50 0 
.class public final super [291] 
.super [293] 
.implements [295] 
.field private final [296] [297] 
.field private [298] [299] 
.field private [300] [301] 
.field private [302] [303] 
.field private [304] [305] 
.field private [306] [307] 
.field private [308] [309] 
.field private [310] [311] 
.field private [312] [313] 
.field private [314] [315] 
.field private [316] [317] 
.field private [318] [319] 
.field private [320] [321] 

.method public [323] : [324] 
    .attribute [322] .code stack 8 locals 0 
L0:     aload_0 
L1:     invokespecial [43] 
L4:     aload_0 
L5:     aload_2 
L6:     putfield [45] 
L9:     aload_0 
L10:    aload_3 
L11:    putfield [46] 
L14:    aload_0 
L15:    new [47] 
L18:    dup 
L19:    ldc [3] 
L21:    ldc_w [1] 
L24:    iconst_1 
L25:    aload_0 
L26:    invokespecial [44] 
L29:    putfield [48] 
L32:    aload_0 
L33:    new [49] 
L36:    dup 
L37:    invokespecial [43] 
L40:    putfield [50] 
L43:    aload_0 
L44:    aload_1 
L45:    invokevirtual [23] 
L48:    invokestatic [5] 
L51:    putfield [51] 
L54:    return 
L55:    nop 
L56:    
    .end code 
.end method 

.method public [325] : [326] 
    .attribute [322] .code stack 4 locals 2 
L0:     aload_0 
L1:     getfield [22] 
L4:     dup 
L5:     astore 9 
L7:     monitorenter 
        .catch [0] from L8 to L84 using L87 
L8:     aload_0 
L9:     aload_1 
L10:    putfield [52] 
L13:    aload_0 
L14:    iload_2 
L15:    putfield [53] 
L18:    aload_0 
L19:    iload_3 
L20:    putfield [54] 
L23:    aload_0 
L24:    aload 4 
L26:    putfield [55] 
L29:    aload_0 
L30:    aload 5 
L32:    putfield [56] 
L35:    aload_0 
L36:    iload 6 
L38:    putfield [57] 
L41:    aload_0 
L42:    iload 7 
L44:    putfield [58] 
L47:    aload_0 
L48:    aload 8 
L50:    putfield [59] 
L53:    aload_0 
L54:    getfield [19] 
L57:    ldc [6] 
L59:    ldc [7] 
L61:    aload_0 
L62:    getfield [25] 
L65:    invokevirtual [33] 
L68:    pop 
L69:    aload_0 
L70:    iconst_0 
L71:    putfield [51] 
L74:    aload_0 
L75:    getfield [21] 
L78:    invokevirtual [34] 
L81:    aload 9 
L83:    monitorexit 
L84:    goto L95 
        .catch [0] from L87 to L92 using L87 
L87:    astore 10 
L89:    aload 9 
L91:    monitorexit 
L92:    aload 10 
L94:    athrow 
L95:    return 
L96:    
    .end code 
.end method 

.method public [327] : [328] 
    .attribute [322] .code stack 3 locals 2 
L0:     aload_0 
L1:     getfield [22] 
L4:     dup 
L5:     astore_3 
L6:     monitorenter 
        .catch [0] from L7 to L17 using L20 
L7:     aload_0 
L8:     getfield [21] 
L11:    lload_1 
L12:    invokevirtual [35] 
L15:    aload_3 
L16:    monitorexit 
L17:    goto L27 
        .catch [0] from L20 to L24 using L20 
L20:    astore 4 
L22:    aload_3 
L23:    monitorexit 
L24:    aload 4 
L26:    athrow 
L27:    return 
L28:    
    .end code 
.end method 

.method public [329] : [330] 
    .attribute [322] .code stack 3 locals 2 
L0:     aload_0 
L1:     getfield [22] 
L4:     dup 
L5:     astore_1 
L6:     monitorenter 
        .catch [0] from L7 to L66 using L69 
L7:     aload_0 
L8:     getfield [24] 
L11:    ifne L64 
L14:    aload_0 
L15:    getfield [19] 
L18:    ldc [6] 
L20:    ldc [8] 
L22:    invokevirtual [36] 
L25:    pop 
L26:    aload_0 
L27:    iconst_1 
L28:    putfield [51] 
L31:    aload_0 
L32:    getfield [21] 
L35:    invokevirtual [37] 
L38:    pop 
L39:    aload_0 
L40:    getfield [19] 
L43:    ldc [6] 
L45:    ldc [9] 
L47:    invokevirtual [36] 
L50:    pop 
L51:    aload_0 
L52:    getfield [20] 
L55:    invokevirtual [38] 
L58:    invokeinterface [60] 0 
L63:    pop 
L64:    aload_1 
L65:    monitorexit 
L66:    goto L74 
        .catch [0] from L69 to L72 using L69 
L69:    astore_2 
L70:    aload_1 
L71:    monitorexit 
L72:    aload_2 
L73:    athrow 
L74:    return 
L75:    nop 
L76:    
    .end code 
.end method 

.method public [331] : [332] 
    .attribute [322] .code stack 9 locals 2 
L0:     aload_0 
L1:     getfield [22] 
L4:     dup 
L5:     astore_2 
L6:     monitorenter 
        .catch [0] from L7 to L109 using L112 
L7:     aload_0 
L8:     getfield [19] 
L11:    ldc [6] 
L13:    ldc [10] 
L15:    aload_0 
L16:    getfield [20] 
L19:    invokevirtual [39] 
L22:    getfield [40] 
L25:    i2l 
L26:    aload_0 
L27:    getfield [24] 
L30:    ifeq L37 
L33:    iconst_1 
L34:    goto L38 
L37:    iconst_0 
L38:    i2l 
L39:    invokevirtual [41] 
L42:    pop 
L43:    aload_0 
L44:    getfield [20] 
L47:    invokevirtual [39] 
L50:    getfield [40] 
L53:    ifge L107 
L56:    aload_0 
L57:    getfield [24] 
L60:    ifne L107 
L63:    aload_0 
L64:    getfield [20] 
L67:    invokevirtual [42] 
L70:    aload_0 
L71:    getfield [25] 
L74:    aload_0 
L75:    getfield [26] 
L78:    aload_0 
L79:    getfield [27] 
L82:    aload_0 
L83:    getfield [28] 
L86:    aload_0 
L87:    getfield [29] 
L90:    aload_0 
L91:    getfield [30] 
L94:    aload_0 
L95:    getfield [31] 
L98:    aload_0 
L99:    getfield [32] 
L102:   invokeinterface [61] 0 
L107:   aload_2 
L108:   monitorexit 
L109:   goto L117 
        .catch [0] from L112 to L115 using L112 
L112:   astore_3 
L113:   aload_2 
L114:   monitorexit 
L115:   aload_3 
L116:   athrow 
L117:   return 
L118:   nop 
L119:   nop 
L120:   
    .end code 
.end method 

.method public enum [333] : [334] 
    .attribute [322] .code stack 0 locals 0 
L0:     return 
L1:     nop 
L2:     nop 
L3:     nop 
L4:     
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [63] 
.const [3] = String [64] 
.const [4] = Class [65] 
.const [5] = Method [66] [67] 
.const [6] = Int -2137614336 
.const [7] = String [68] 
.const [8] = String [69] 
.const [9] = String [70] 
.const [10] = String [71] 
.const [11] = Class [72] 
.const [12] = Class [73] 
.const [13] = Class [74] 
.const [14] = Class [75] 
.const [15] = Class [76] 
.const [16] = Class [77] 
.const [17] = Class [78] 
.const [18] = Class [79] 
.const [19] = Field [80] [81] 
.const [20] = Field [82] [83] 
.const [21] = Field [84] [85] 
.const [22] = Field [86] [87] 
.const [23] = Method [88] [89] 
.const [24] = Field [90] [91] 
.const [25] = Field [92] [93] 
.const [26] = Field [94] [95] 
.const [27] = Field [96] [97] 
.const [28] = Field [98] [99] 
.const [29] = Field [100] [101] 
.const [30] = Field [102] [103] 
.const [31] = Field [104] [105] 
.const [32] = Field [106] [107] 
.const [33] = Method [108] [109] 
.const [34] = Method [110] [111] 
.const [35] = Method [112] [113] 
.const [36] = Method [114] [115] 
.const [37] = Method [116] [117] 
.const [38] = Method [118] [119] 
.const [39] = Method [120] [121] 
.const [40] = Field [122] [123] 
.const [41] = Method [124] [125] 
.const [42] = Method [126] [127] 
.const [43] = Method [128] [129] 
.const [44] = Method [130] [131] 
.const [45] = Field [132] [133] 
.const [46] = Field [134] [135] 
.const [47] = Class [136] 
.const [48] = Field [137] [138] 
.const [49] = Class [139] 
.const [50] = Field [140] [141] 
.const [51] = Field [142] [143] 
.const [52] = Field [144] [145] 
.const [53] = Field [146] [147] 
.const [54] = Field [148] [149] 
.const [55] = Field [150] [151] 
.const [56] = Field [152] [153] 
.const [57] = Field [154] [155] 
.const [58] = Field [156] [157] 
.const [59] = Field [158] [159] 
.const [60] = InterfaceMethod [160] [161] 
.const [61] = InterfaceMethod [162] [163] 
.const [62] = Int -1140719616 
.const [63] = Utf8 de/audi/atip/timer/Timer 
.const [64] = Utf8 ToolTipTimer 
.const [65] = Utf8 java/lang/Object 
.const [66] = Class [164] 
.const [67] = NameAndType [165] [166] 
.const [68] = Utf8 'CtxFreeMap#ToolTipTimer#restart(%1, ...)' 
.const [69] = Utf8 'CtxFreeMap#ToolTipTimer#cancelAndHideToolTip()' 
.const [70] = Utf8 'CtxShown#hideToolTip()' 
.const [71] = Utf8 'CtxFreeMap#ToolTipTimer#fireTimer - mapScrollDir: %1 mCancelled: %2' 
.const [72] = Utf8 de/audi/tghu/navi/app/map/gui/ToolTipTimer 
.const [73] = Utf8 de/audi/tghu/navi/app/NavigationEnv 
.const [74] = Utf8 de/audi/tghu/navi/app/util/Util 
.const [75] = Utf8 de/audi/atip/log/LogChannel 
.const [76] = Utf8 de/audi/tghu/navi/app/map/AbstractMap 
.const [77] = Utf8 de/audi/tghu/navi/app/map/GUIInterface 
.const [78] = Utf8 de/audi/tghu/navi/app/map/MapDataContainer 
.const [79] = Utf8 de/audi/tghu/navi/app/map/gui/IMapTooltip 
.const [80] = Class [167] 
.const [81] = NameAndType [168] [169] 
.const [82] = Class [170] 
.const [83] = NameAndType [171] [172] 
.const [84] = Class [173] 
.const [85] = NameAndType [174] [175] 
.const [86] = Class [176] 
.const [87] = NameAndType [177] [178] 
.const [88] = Class [179] 
.const [89] = NameAndType [180] [181] 
.const [90] = Class [182] 
.const [91] = NameAndType [183] [184] 
.const [92] = Class [185] 
.const [93] = NameAndType [186] [187] 
.const [94] = Class [188] 
.const [95] = NameAndType [189] [190] 
.const [96] = Class [191] 
.const [97] = NameAndType [192] [193] 
.const [98] = Class [194] 
.const [99] = NameAndType [195] [196] 
.const [100] = Class [197] 
.const [101] = NameAndType [198] [199] 
.const [102] = Class [200] 
.const [103] = NameAndType [201] [202] 
.const [104] = Class [203] 
.const [105] = NameAndType [204] [205] 
.const [106] = Class [206] 
.const [107] = NameAndType [207] [208] 
.const [108] = Class [209] 
.const [109] = NameAndType [210] [211] 
.const [110] = Class [212] 
.const [111] = NameAndType [213] [214] 
.const [112] = Class [215] 
.const [113] = NameAndType [216] [217] 
.const [114] = Class [218] 
.const [115] = NameAndType [219] [220] 
.const [116] = Class [221] 
.const [117] = NameAndType [222] [223] 
.const [118] = Class [224] 
.const [119] = NameAndType [225] [226] 
.const [120] = Class [227] 
.const [121] = NameAndType [228] [229] 
.const [122] = Class [230] 
.const [123] = NameAndType [231] [232] 
.const [124] = Class [233] 
.const [125] = NameAndType [234] [235] 
.const [126] = Class [236] 
.const [127] = NameAndType [237] [238] 
.const [128] = Class [239] 
.const [129] = NameAndType [240] [241] 
.const [130] = Class [242] 
.const [131] = NameAndType [243] [244] 
.const [132] = Class [245] 
.const [133] = NameAndType [246] [247] 
.const [134] = Class [248] 
.const [135] = NameAndType [249] [250] 
.const [136] = Utf8 de/audi/atip/timer/Timer 
.const [137] = Class [251] 
.const [138] = NameAndType [252] [253] 
.const [139] = Utf8 java/lang/Object 
.const [140] = Class [254] 
.const [141] = NameAndType [255] [256] 
.const [142] = Class [257] 
.const [143] = NameAndType [258] [259] 
.const [144] = Class [260] 
.const [145] = NameAndType [261] [262] 
.const [146] = Class [263] 
.const [147] = NameAndType [264] [265] 
.const [148] = Class [266] 
.const [149] = NameAndType [267] [268] 
.const [150] = Class [269] 
.const [151] = NameAndType [270] [271] 
.const [152] = Class [272] 
.const [153] = NameAndType [273] [274] 
.const [154] = Class [275] 
.const [155] = NameAndType [276] [277] 
.const [156] = Class [278] 
.const [157] = NameAndType [279] [280] 
.const [158] = Class [281] 
.const [159] = NameAndType [282] [283] 
.const [160] = Class [284] 
.const [161] = NameAndType [285] [286] 
.const [162] = Class [287] 
.const [163] = NameAndType [288] [289] 
.const [164] = Utf8 de/audi/tghu/navi/app/util/Util 
.const [165] = Utf8 isPorsche 
.const [166] = Utf8 (Lde/audi/atip/base/IFrameworkAccess;)Z 
.const [167] = Utf8 de/audi/tghu/navi/app/map/gui/ToolTipTimer 
.const [168] = Utf8 logChannel 
.const [169] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [170] = Utf8 de/audi/tghu/navi/app/map/gui/ToolTipTimer 
.const [171] = Utf8 naviMap 
.const [172] = Utf8 Lde/audi/tghu/navi/app/map/AbstractMap; 
.const [173] = Utf8 de/audi/tghu/navi/app/map/gui/ToolTipTimer 
.const [174] = Utf8 mTimer 
.const [175] = Utf8 Lde/audi/atip/timer/Timer; 
.const [176] = Utf8 de/audi/tghu/navi/app/map/gui/ToolTipTimer 
.const [177] = Utf8 mMutex 
.const [178] = Utf8 Ljava/lang/Object; 
.const [179] = Utf8 de/audi/tghu/navi/app/NavigationEnv 
.const [180] = Utf8 getFramework 
.const [181] = Utf8 ()Lde/audi/atip/base/IFrameworkAccess; 
.const [182] = Utf8 de/audi/tghu/navi/app/map/gui/ToolTipTimer 
.const [183] = Utf8 mCancelled 
.const [184] = Utf8 Z 
.const [185] = Utf8 de/audi/tghu/navi/app/map/gui/ToolTipTimer 
.const [186] = Utf8 mMessage 
.const [187] = Utf8 Ljava/lang/String; 
.const [188] = Utf8 de/audi/tghu/navi/app/map/gui/ToolTipTimer 
.const [189] = Utf8 mX 
.const [190] = Utf8 I 
.const [191] = Utf8 de/audi/tghu/navi/app/map/gui/ToolTipTimer 
.const [192] = Utf8 mY 
.const [193] = Utf8 I 
.const [194] = Utf8 de/audi/tghu/navi/app/map/gui/ToolTipTimer 
.const [195] = Utf8 mPositionInfo 
.const [196] = Utf8 Lorg/dsi/ifc/map/PosInfo; 
.const [197] = Utf8 de/audi/tghu/navi/app/map/gui/ToolTipTimer 
.const [198] = Utf8 mURL 
.const [199] = Utf8 Ljava/lang/String; 
.const [200] = Utf8 de/audi/tghu/navi/app/map/gui/ToolTipTimer 
.const [201] = Utf8 mIsStack 
.const [202] = Utf8 Z 
.const [203] = Utf8 de/audi/tghu/navi/app/map/gui/ToolTipTimer 
.const [204] = Utf8 mIsPicNav 
.const [205] = Utf8 Z 
.const [206] = Utf8 de/audi/tghu/navi/app/map/gui/ToolTipTimer 
.const [207] = Utf8 mPicNavLocator 
.const [208] = Utf8 Lorg/dsi/ifc/global/ResourceLocator; 
.const [209] = Utf8 de/audi/atip/log/LogChannel 
.const [210] = Utf8 log 
.const [211] = Utf8 (ILjava/lang/String;Ljava/lang/Object;)Z 
.const [212] = Utf8 de/audi/atip/timer/Timer 
.const [213] = Utf8 restart 
.const [214] = Utf8 ()V 
.const [215] = Utf8 de/audi/atip/timer/Timer 
.const [216] = Utf8 setDelay 
.const [217] = Utf8 (J)V 
.const [218] = Utf8 de/audi/atip/log/LogChannel 
.const [219] = Utf8 log 
.const [220] = Utf8 (ILjava/lang/String;)Z 
.const [221] = Utf8 de/audi/atip/timer/Timer 
.const [222] = Utf8 cancel 
.const [223] = Utf8 ()Z 
.const [224] = Utf8 de/audi/tghu/navi/app/map/AbstractMap 
.const [225] = Utf8 getGuiInterface 
.const [226] = Utf8 ()Lde/audi/tghu/navi/app/map/GUIInterface; 
.const [227] = Utf8 de/audi/tghu/navi/app/map/AbstractMap 
.const [228] = Utf8 getMapDataContainer 
.const [229] = Utf8 ()Lde/audi/tghu/navi/app/map/MapDataContainer; 
.const [230] = Utf8 de/audi/tghu/navi/app/map/MapDataContainer 
.const [231] = Utf8 sMapScrollDir 
.const [232] = Utf8 I 
.const [233] = Utf8 de/audi/atip/log/LogChannel 
.const [234] = Utf8 log 
.const [235] = Utf8 (ILjava/lang/String;JJ)Z 
.const [236] = Utf8 de/audi/tghu/navi/app/map/AbstractMap 
.const [237] = Utf8 getMapTooltip 
.const [238] = Utf8 ()Lde/audi/tghu/navi/app/map/gui/IMapTooltip; 
.const [239] = Utf8 java/lang/Object 
.const [240] = Utf8 <init> 
.const [241] = Utf8 ()V 
.const [242] = Utf8 de/audi/atip/timer/Timer 
.const [243] = Utf8 <init> 
.const [244] = Utf8 (Ljava/lang/String;JZLde/audi/atip/timer/TimerListener;)V 
.const [245] = Utf8 de/audi/tghu/navi/app/map/gui/ToolTipTimer 
.const [246] = Utf8 logChannel 
.const [247] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [248] = Utf8 de/audi/tghu/navi/app/map/gui/ToolTipTimer 
.const [249] = Utf8 naviMap 
.const [250] = Utf8 Lde/audi/tghu/navi/app/map/AbstractMap; 
.const [251] = Utf8 de/audi/tghu/navi/app/map/gui/ToolTipTimer 
.const [252] = Utf8 mTimer 
.const [253] = Utf8 Lde/audi/atip/timer/Timer; 
.const [254] = Utf8 de/audi/tghu/navi/app/map/gui/ToolTipTimer 
.const [255] = Utf8 mMutex 
.const [256] = Utf8 Ljava/lang/Object; 
.const [257] = Utf8 de/audi/tghu/navi/app/map/gui/ToolTipTimer 
.const [258] = Utf8 mCancelled 
.const [259] = Utf8 Z 
.const [260] = Utf8 de/audi/tghu/navi/app/map/gui/ToolTipTimer 
.const [261] = Utf8 mMessage 
.const [262] = Utf8 Ljava/lang/String; 
.const [263] = Utf8 de/audi/tghu/navi/app/map/gui/ToolTipTimer 
.const [264] = Utf8 mX 
.const [265] = Utf8 I 
.const [266] = Utf8 de/audi/tghu/navi/app/map/gui/ToolTipTimer 
.const [267] = Utf8 mY 
.const [268] = Utf8 I 
.const [269] = Utf8 de/audi/tghu/navi/app/map/gui/ToolTipTimer 
.const [270] = Utf8 mPositionInfo 
.const [271] = Utf8 Lorg/dsi/ifc/map/PosInfo; 
.const [272] = Utf8 de/audi/tghu/navi/app/map/gui/ToolTipTimer 
.const [273] = Utf8 mURL 
.const [274] = Utf8 Ljava/lang/String; 
.const [275] = Utf8 de/audi/tghu/navi/app/map/gui/ToolTipTimer 
.const [276] = Utf8 mIsStack 
.const [277] = Utf8 Z 
.const [278] = Utf8 de/audi/tghu/navi/app/map/gui/ToolTipTimer 
.const [279] = Utf8 mIsPicNav 
.const [280] = Utf8 Z 
.const [281] = Utf8 de/audi/tghu/navi/app/map/gui/ToolTipTimer 
.const [282] = Utf8 mPicNavLocator 
.const [283] = Utf8 Lorg/dsi/ifc/global/ResourceLocator; 
.const [284] = Utf8 de/audi/tghu/navi/app/map/GUIInterface 
.const [285] = Utf8 hideToolTip 
.const [286] = Utf8 ()Lde/audi/tghu/navi/app/map/handler/selection/MapItemSelectionAction; 
.const [287] = Utf8 de/audi/tghu/navi/app/map/gui/IMapTooltip 
.const [288] = Utf8 showToolTip 
.const [289] = Utf8 (Ljava/lang/String;IILorg/dsi/ifc/map/PosInfo;Ljava/lang/String;ZZLorg/dsi/ifc/global/ResourceLocator;)V 
.const [290] = Utf8 de/audi/tghu/navi/app/map/gui/ToolTipTimer 
.const [291] = Class [290] 
.const [292] = Utf8 java/lang/Object 
.const [293] = Class [292] 
.const [294] = Utf8 de/audi/atip/timer/TimerListener 
.const [295] = Class [294] 
.const [296] = Utf8 mTimer 
.const [297] = Utf8 Lde/audi/atip/timer/Timer; 
.const [298] = Utf8 mMutex 
.const [299] = Utf8 Ljava/lang/Object; 
.const [300] = Utf8 mMessage 
.const [301] = Utf8 Ljava/lang/String; 
.const [302] = Utf8 mX 
.const [303] = Utf8 I 
.const [304] = Utf8 mY 
.const [305] = Utf8 I 
.const [306] = Utf8 mPositionInfo 
.const [307] = Utf8 Lorg/dsi/ifc/map/PosInfo; 
.const [308] = Utf8 mURL 
.const [309] = Utf8 Ljava/lang/String; 
.const [310] = Utf8 mIsStack 
.const [311] = Utf8 Z 
.const [312] = Utf8 mIsPicNav 
.const [313] = Utf8 Z 
.const [314] = Utf8 mPicNavLocator 
.const [315] = Utf8 Lorg/dsi/ifc/global/ResourceLocator; 
.const [316] = Utf8 mCancelled 
.const [317] = Utf8 Z 
.const [318] = Utf8 logChannel 
.const [319] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [320] = Utf8 naviMap 
.const [321] = Utf8 Lde/audi/tghu/navi/app/map/AbstractMap; 
.const [322] = Utf8 Code 
.const [323] = Utf8 <init> 
.const [324] = Utf8 (Lde/audi/tghu/navi/app/NavigationEnv;Lde/audi/atip/log/LogChannel;Lde/audi/tghu/navi/app/map/AbstractMap;)V 
.const [325] = Utf8 restart 
.const [326] = Utf8 (Ljava/lang/String;IILorg/dsi/ifc/map/PosInfo;Ljava/lang/String;ZZLorg/dsi/ifc/global/ResourceLocator;)V 
.const [327] = Utf8 setDelay 
.const [328] = Utf8 (J)V 
.const [329] = Utf8 cancelAndHideToolTip 
.const [330] = Utf8 ()V 
.const [331] = Utf8 fireTimer 
.const [332] = Utf8 (Lde/audi/atip/timer/Timer;)V 
.const [333] = Utf8 cancelTimer 
.const [334] = Utf8 (Lde/audi/atip/timer/Timer;)V 
.end class 
