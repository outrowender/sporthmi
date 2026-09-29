.version 50 0 
.class public super [334] 
.super [336] 
.implements [338] 
.field public static final [339] [340] 
.field private [341] [342] 
.field private final [343] [344] 
.field private final [345] [346] 
.field private final [347] [348] 
.field private [349] [350] 

.method public [352] : [353] 
    .attribute [351] .code stack 12 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     aload_2 
L3:     aload_3 
L4:     aload 4 
L6:     aload 5 
L8:     aload 6 
L10:    aload 7 
L12:    aload 8 
L14:    aload 9 
L16:    aload 10 
L18:    aload 13 
L20:    invokespecial [57] 
L23:    aload_0 
L24:    aload 11 
L26:    putfield [63] 
L29:    aload_0 
L30:    aload 12 
L32:    putfield [64] 
L35:    aload_0 
L36:    new [65] 
L39:    dup 
L40:    ldc [3] 
L42:    iconst_5 
L43:    aconst_null 
L44:    aload_0 
L45:    ldc_w [1] 
L48:    iconst_0 
L49:    invokespecial [58] 
L52:    putfield [66] 
L55:    aload_0 
L56:    aload_1 
L57:    ldc [4] 
L59:    invokevirtual [32] 
L62:    putfield [67] 
L65:    aload_0 
L66:    getfield [33] 
L69:    iconst_0 
L70:    invokeinterface [68] 0 
L75:    aload_0 
L76:    getfield [33] 
L79:    iconst_3 
L80:    invokeinterface [69] 0 
L85:    return 
L86:    nop 
L87:    nop 
L88:    
    .end code 
.end method 

.method public [354] : [355] 
    .attribute [351] .code stack 5 locals 2 
L0:     aload_1 
L1:     invokeinterface [70] 0 
L6:     istore_2 
L7:     aload_0 
L8:     getfield [34] 
L11:    ldc [5] 
L13:    ldc [6] 
L15:    iload_2 
L16:    i2l 
L17:    invokevirtual [35] 
L20:    pop 
L21:    aload_0 
L22:    getfield [33] 
L25:    iload_2 
L26:    invokeinterface [68] 0 
L31:    aload_0 
L32:    aload_1 
L33:    invokespecial [59] 
L36:    ifeq L54 
L39:    aload_0 
L40:    getfield [34] 
L43:    ldc [5] 
L45:    ldc [7] 
L47:    invokevirtual [36] 
L50:    pop 
L51:    goto L110 
L54:    aload_0 
L55:    aload_1 
L56:    putfield [71] 
L59:    aload_0 
L60:    getfield [30] 
L63:    aload_1 
L64:    getstatic [8] 
L67:    invokevirtual [38] 
L70:    aload_0 
L71:    getfield [31] 
L74:    aload_1 
L75:    getstatic [9] 
L78:    invokevirtual [39] 
L81:    aload_0 
L82:    getfield [33] 
L85:    invokeinterface [72] 0 
L90:    ifne L98 
L93:    iconst_3 
L94:    istore_3 
L95:    goto L100 
L98:    iconst_1 
L99:    istore_3 
L100:   aload_0 
L101:   getfield [30] 
L104:   iload_3 
L105:   bipush 48 
L107:   invokevirtual [40] 
L110:   return 
L111:   nop 
L112:   
    .end code 
.end method 

.method private [356] : [357] 
    .attribute [351] .code stack 7 locals 5 
L0:     aload_0 
L1:     getfield [37] 
L4:     ifnonnull L21 
L7:     aload_0 
L8:     getfield [34] 
L11:    ldc [5] 
L13:    ldc [10] 
L15:    invokevirtual [36] 
L18:    pop 
L19:    iconst_0 
L20:    areturn 
L21:    aload_0 
L22:    getfield [37] 
L25:    invokeinterface [70] 0 
L30:    istore_2 
L31:    aload_1 
L32:    invokeinterface [70] 0 
L37:    istore_3 
L38:    iload_2 
L39:    iload_3 
L40:    if_icmpeq L61 
L43:    aload_0 
L44:    getfield [34] 
L47:    ldc [5] 
L49:    ldc [11] 
L51:    iload_2 
L52:    i2l 
L53:    iload_3 
L54:    i2l 
L55:    invokevirtual [41] 
L58:    pop 
L59:    iconst_0 
L60:    areturn 
L61:    iconst_0 
L62:    istore 4 
L64:    iload 4 
L66:    iload_2 
L67:    if_icmpge L117 
L70:    aload_0 
L71:    getfield [37] 
L74:    iload 4 
L76:    invokeinterface [73] 0 
L81:    checkcast [12] 
L84:    astore 5 
L86:    aload_1 
L87:    iload 4 
L89:    invokeinterface [73] 0 
L94:    checkcast [12] 
L97:    astore 6 
L99:    aload 5 
L101:   aload 6 
L103:   invokevirtual [42] 
L106:   ifne L111 
L109:   iconst_0 
L110:   areturn 
L111:   iinc 4 1 
L114:   goto L64 
L117:   iconst_1 
L118:   areturn 
L119:   nop 
L120:   
    .end code 
.end method 

.method public [358] : [359] 
    .attribute [351] .code stack 3 locals 0 
L0:     aload_0 
L1:     getfield [34] 
L4:     ldc [5] 
L6:     ldc [13] 
L8:     invokevirtual [36] 
L11:    pop 
L12:    aload_0 
L13:    getfield [30] 
L16:    invokevirtual [43] 
L19:    return 
L20:    
    .end code 
.end method 

.method protected [360] : [361] 
    .attribute [351] .code stack 4 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     aload_2 
L3:     iload_3 
L4:     invokespecial [60] 
L7:     aload_1 
L8:     iload_3 
L9:     aaload 
L10:    getfield [44] 
L13:    ldc [14] 
L15:    if_acmpeq L71 
L18:    aload_1 
L19:    iload_3 
L20:    aaload 
L21:    getfield [45] 
L24:    ldc [14] 
L26:    if_acmpeq L71 
L29:    aload_2 
L30:    iload_3 
L31:    aaload 
L32:    new [74] 
L35:    dup 
L36:    invokespecial [61] 
L39:    aload_1 
L40:    iload_3 
L41:    aaload 
L42:    getfield [44] 
L45:    invokevirtual [46] 
L48:    ldc [16] 
L50:    invokevirtual [46] 
L53:    aload_1 
L54:    iload_3 
L55:    aaload 
L56:    getfield [45] 
L59:    invokevirtual [46] 
L62:    invokevirtual [47] 
L65:    putfield [75] 
L68:    goto L83 
L71:    aload_2 
L72:    iload_3 
L73:    aaload 
L74:    aload_1 
L75:    iload_3 
L76:    aaload 
L77:    getfield [44] 
L80:    putfield [75] 
L83:    return 
L84:    
    .end code 
.end method 

.method public synchronized [362] : [363] 
    .attribute [351] .code stack 5 locals 1 
L0:     aload_0 
L1:     aload_0 
L2:     getfield [48] 
L5:     aload_1 
L6:     aload_2 
L7:     aload_3 
L8:     invokespecial [62] 
L11:    istore 6 
L13:    iload 6 
L15:    iconst_m1 
L16:    if_icmple L37 
L19:    aload_0 
L20:    getfield [49] 
L23:    iload 6 
L25:    iload 4 
L27:    iastore 
L28:    aload_0 
L29:    getfield [50] 
L32:    iload 6 
L34:    iload 5 
L36:    iastore 
L37:    aload_0 
L38:    aload_0 
L39:    getfield [51] 
L42:    aload_1 
L43:    aload_2 
L44:    aload_3 
L45:    invokespecial [62] 
L48:    pop 
L49:    return 
L50:    nop 
L51:    nop 
L52:    
    .end code 
.end method 

.method private [364] : [365] 
    .attribute [351] .code stack 2 locals 3 
L0:     aload_1 
L1:     ifnonnull L6 
L4:     iconst_m1 
L5:     areturn 
L6:     iconst_0 
L7:     istore 5 
L9:     aload_1 
L10:    invokevirtual [52] 
L13:    istore 6 
L15:    iload 5 
L17:    iload 6 
L19:    if_icmpge L67 
L22:    aload_1 
L23:    iload 5 
L25:    invokevirtual [53] 
L28:    checkcast [17] 
L31:    astore 7 
L33:    aload 7 
L35:    invokevirtual [54] 
L38:    aload_2 
L39:    if_acmpne L61 
L42:    aload 7 
L44:    invokevirtual [55] 
L47:    aload_3 
L48:    if_acmpne L61 
L51:    aload 7 
L53:    aload 4 
L55:    invokevirtual [56] 
L58:    iload 5 
L60:    areturn 
L61:    iinc 5 1 
L64:    goto L15 
L67:    iconst_m1 
L68:    areturn 
L69:    nop 
L70:    nop 
L71:    nop 
L72:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [77] 
.const [3] = String [78] 
.const [4] = Int -2128607744 
.const [5] = Int -2137614336 
.const [6] = String [79] 
.const [7] = String [80] 
.const [8] = Field [81] [82] 
.const [9] = Field [83] [84] 
.const [10] = String [85] 
.const [11] = String [86] 
.const [12] = Class [87] 
.const [13] = String [88] 
.const [14] = String [89] 
.const [15] = Class [90] 
.const [16] = String [91] 
.const [17] = Class [92] 
.const [18] = Class [93] 
.const [19] = Class [94] 
.const [20] = Class [95] 
.const [21] = Class [96] 
.const [22] = Class [97] 
.const [23] = Class [98] 
.const [24] = Class [99] 
.const [25] = Class [100] 
.const [26] = Class [101] 
.const [27] = Class [102] 
.const [28] = Class [103] 
.const [29] = Class [104] 
.const [30] = Field [105] [106] 
.const [31] = Field [107] [108] 
.const [32] = Method [109] [110] 
.const [33] = Field [111] [112] 
.const [34] = Field [113] [114] 
.const [35] = Method [115] [116] 
.const [36] = Method [117] [118] 
.const [37] = Field [119] [120] 
.const [38] = Method [121] [122] 
.const [39] = Method [123] [124] 
.const [40] = Method [125] [126] 
.const [41] = Method [127] [128] 
.const [42] = Method [129] [130] 
.const [43] = Method [131] [132] 
.const [44] = Field [133] [134] 
.const [45] = Field [135] [136] 
.const [46] = Method [137] [138] 
.const [47] = Method [139] [140] 
.const [48] = Field [141] [142] 
.const [49] = Field [143] [144] 
.const [50] = Field [145] [146] 
.const [51] = Field [147] [148] 
.const [52] = Method [149] [150] 
.const [53] = Method [151] [152] 
.const [54] = Method [153] [154] 
.const [55] = Method [155] [156] 
.const [56] = Method [157] [158] 
.const [57] = Method [159] [160] 
.const [58] = Method [161] [162] 
.const [59] = Method [163] [164] 
.const [60] = Method [165] [166] 
.const [61] = Method [167] [168] 
.const [62] = Method [169] [170] 
.const [63] = Field [171] [172] 
.const [64] = Field [173] [174] 
.const [65] = Class [175] 
.const [66] = Field [176] [177] 
.const [67] = Field [178] [179] 
.const [68] = InterfaceMethod [180] [181] 
.const [69] = InterfaceMethod [182] [183] 
.const [70] = InterfaceMethod [184] [185] 
.const [71] = Field [186] [187] 
.const [72] = InterfaceMethod [188] [189] 
.const [73] = InterfaceMethod [190] [191] 
.const [74] = Class [192] 
.const [75] = Field [193] [194] 
.const [76] = Int -2012020736 
.const [77] = Utf8 de/audi/atip/timer/Timer 
.const [78] = Utf8 NaviOnlineServiceImplEvo 
.const [79] = Utf8 "NaviOnlineServiceImplEvo#sendRemoteHMIAppsUpdateToNaviAndMap: Called with list size '%1'" 
.const [80] = Utf8 'NaviOnlineServiceImplEvo#sendRemoteHMIAppsUpdateToNaviAndMap: new and old list are same so not updating' 
.const [81] = Class [195] 
.const [82] = NameAndType [196] [197] 
.const [83] = Class [198] 
.const [84] = NameAndType [199] [200] 
.const [85] = Utf8 'NaviOnlineServiceImplEvo#sameAsPreviousApps: no previous apps exist' 
.const [86] = Utf8 'NaviOnlineServiceImplEvo#sameAsPreviousApps: number of apps different, previous list size = %1, new list size = %2' 
.const [87] = Utf8 de/audi/atip/interapp/online/OnlineApplicationOtherContext 
.const [88] = Utf8 'NaviOnlineServiceImplEvo#sendMiniAppsDownloadError: Called' 
.const [89] = Utf8 '' 
.const [90] = Utf8 java/lang/StringBuffer 
.const [91] = Utf8 '\n' 
.const [92] = Utf8 de/audi/atip/interapp/NaviOnlineService$RrdData 
.const [93] = Utf8 de/audi/app/navi/evo/online/NaviOnlineServiceImplEvo 
.const [94] = Utf8 de/audi/tghu/navi/app/online/NaviOnlineServiceImpl 
.const [95] = Utf8 de/audi/atip/interapp/NaviOnlineService$POIOnlineData 
.const [96] = Utf8 de/audi/tghu/navi/app/NavigationEnv 
.const [97] = Utf8 de/audi/atip/hmi/modelaccess/ChoiceModelApp 
.const [98] = Utf8 java/util/List 
.const [99] = Utf8 de/audi/atip/log/LogChannel 
.const [100] = Utf8 de/audi/app/navi/evo/online/RemoteHMIAppsDestinationListener 
.const [101] = Utf8 de/audi/app/navi/evo/online/RemoteHMIAppsMapListener 
.const [102] = Utf8 java/lang/Object 
.const [103] = Utf8 org/dsi/ifc/online/PoiOnlineSearchValuelistElement 
.const [104] = Utf8 java/util/ArrayList 
.const [105] = Class [201] 
.const [106] = NameAndType [202] [203] 
.const [107] = Class [204] 
.const [108] = NameAndType [205] [206] 
.const [109] = Class [207] 
.const [110] = NameAndType [208] [209] 
.const [111] = Class [210] 
.const [112] = NameAndType [211] [212] 
.const [113] = Class [213] 
.const [114] = NameAndType [214] [215] 
.const [115] = Class [216] 
.const [116] = NameAndType [217] [218] 
.const [117] = Class [219] 
.const [118] = NameAndType [220] [221] 
.const [119] = Class [222] 
.const [120] = NameAndType [223] [224] 
.const [121] = Class [225] 
.const [122] = NameAndType [226] [227] 
.const [123] = Class [228] 
.const [124] = NameAndType [229] [230] 
.const [125] = Class [231] 
.const [126] = NameAndType [232] [233] 
.const [127] = Class [234] 
.const [128] = NameAndType [235] [236] 
.const [129] = Class [237] 
.const [130] = NameAndType [238] [239] 
.const [131] = Class [240] 
.const [132] = NameAndType [241] [242] 
.const [133] = Class [243] 
.const [134] = NameAndType [244] [245] 
.const [135] = Class [246] 
.const [136] = NameAndType [247] [248] 
.const [137] = Class [249] 
.const [138] = NameAndType [250] [251] 
.const [139] = Class [252] 
.const [140] = NameAndType [253] [254] 
.const [141] = Class [255] 
.const [142] = NameAndType [256] [257] 
.const [143] = Class [258] 
.const [144] = NameAndType [259] [260] 
.const [145] = Class [261] 
.const [146] = NameAndType [262] [263] 
.const [147] = Class [264] 
.const [148] = NameAndType [265] [266] 
.const [149] = Class [267] 
.const [150] = NameAndType [268] [269] 
.const [151] = Class [270] 
.const [152] = NameAndType [271] [272] 
.const [153] = Class [273] 
.const [154] = NameAndType [274] [275] 
.const [155] = Class [276] 
.const [156] = NameAndType [277] [278] 
.const [157] = Class [279] 
.const [158] = NameAndType [280] [281] 
.const [159] = Class [282] 
.const [160] = NameAndType [283] [284] 
.const [161] = Class [285] 
.const [162] = NameAndType [286] [287] 
.const [163] = Class [288] 
.const [164] = NameAndType [289] [290] 
.const [165] = Class [291] 
.const [166] = NameAndType [292] [293] 
.const [167] = Class [294] 
.const [168] = NameAndType [295] [296] 
.const [169] = Class [297] 
.const [170] = NameAndType [298] [299] 
.const [171] = Class [300] 
.const [172] = NameAndType [301] [302] 
.const [173] = Class [303] 
.const [174] = NameAndType [304] [305] 
.const [175] = Utf8 de/audi/atip/timer/Timer 
.const [176] = Class [306] 
.const [177] = NameAndType [307] [308] 
.const [178] = Class [309] 
.const [179] = NameAndType [310] [311] 
.const [180] = Class [312] 
.const [181] = NameAndType [313] [314] 
.const [182] = Class [315] 
.const [183] = NameAndType [316] [317] 
.const [184] = Class [318] 
.const [185] = NameAndType [319] [320] 
.const [186] = Class [321] 
.const [187] = NameAndType [322] [323] 
.const [188] = Class [324] 
.const [189] = NameAndType [325] [326] 
.const [190] = Class [327] 
.const [191] = NameAndType [328] [329] 
.const [192] = Utf8 java/lang/StringBuffer 
.const [193] = Class [330] 
.const [194] = NameAndType [331] [332] 
.const [195] = Utf8 de/audi/app/navi/evo/online/RemoteHMIAppsDestinationListener 
.const [196] = Utf8 ONLINE_RIGHT_DRAWER_ENTRIES_MODELS_FOR_DESTINATION 
.const [197] = Utf8 [Lde/audi/app/navi/evo/online/RemoteHMIAppsBaseListener$ModelEntry; 
.const [198] = Utf8 de/audi/app/navi/evo/online/RemoteHMIAppsMapListener 
.const [199] = Utf8 ONLINE_RIGHT_DRAWER_ENTRIES_MODELS_FOR_MAP 
.const [200] = Utf8 [Lde/audi/app/navi/evo/online/RemoteHMIAppsBaseListener$ModelEntry; 
.const [201] = Utf8 de/audi/app/navi/evo/online/NaviOnlineServiceImplEvo 
.const [202] = Utf8 remoteHMIAppsDestinationListener 
.const [203] = Utf8 Lde/audi/app/navi/evo/online/RemoteHMIAppsDestinationListener; 
.const [204] = Utf8 de/audi/app/navi/evo/online/NaviOnlineServiceImplEvo 
.const [205] = Utf8 remoteHMIAppsMapListener 
.const [206] = Utf8 Lde/audi/app/navi/evo/online/RemoteHMIAppsMapListener; 
.const [207] = Utf8 de/audi/tghu/navi/app/NavigationEnv 
.const [208] = Utf8 getChoiceModel 
.const [209] = Utf8 (I)Lde/audi/atip/hmi/modelaccess/ChoiceModelApp; 
.const [210] = Utf8 de/audi/app/navi/evo/online/NaviOnlineServiceImplEvo 
.const [211] = Utf8 numberOfMiniAppsModel 
.const [212] = Utf8 Lde/audi/atip/hmi/modelaccess/ChoiceModelApp; 
.const [213] = Utf8 de/audi/app/navi/evo/online/NaviOnlineServiceImplEvo 
.const [214] = Utf8 logChannel 
.const [215] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [216] = Utf8 de/audi/atip/log/LogChannel 
.const [217] = Utf8 log 
.const [218] = Utf8 (ILjava/lang/String;J)Z 
.const [219] = Utf8 de/audi/atip/log/LogChannel 
.const [220] = Utf8 log 
.const [221] = Utf8 (ILjava/lang/String;)Z 
.const [222] = Utf8 de/audi/app/navi/evo/online/NaviOnlineServiceImplEvo 
.const [223] = Utf8 previousRemoteHMIApps 
.const [224] = Utf8 Ljava/util/List; 
.const [225] = Utf8 de/audi/app/navi/evo/online/RemoteHMIAppsDestinationListener 
.const [226] = Utf8 setMiniApps 
.const [227] = Utf8 (Ljava/util/List;[Lde/audi/app/navi/evo/online/RemoteHMIAppsBaseListener$ModelEntry;)V 
.const [228] = Utf8 de/audi/app/navi/evo/online/RemoteHMIAppsMapListener 
.const [229] = Utf8 setMiniApps 
.const [230] = Utf8 (Ljava/util/List;[Lde/audi/app/navi/evo/online/RemoteHMIAppsBaseListener$ModelEntry;)V 
.const [231] = Utf8 de/audi/app/navi/evo/online/RemoteHMIAppsDestinationListener 
.const [232] = Utf8 configureModelsMiniApps 
.const [233] = Utf8 (II)V 
.const [234] = Utf8 de/audi/atip/log/LogChannel 
.const [235] = Utf8 log 
.const [236] = Utf8 (ILjava/lang/String;JJ)Z 
.const [237] = Utf8 java/lang/Object 
.const [238] = Utf8 equals 
.const [239] = Utf8 (Ljava/lang/Object;)Z 
.const [240] = Utf8 de/audi/app/navi/evo/online/RemoteHMIAppsDestinationListener 
.const [241] = Utf8 errorOccured 
.const [242] = Utf8 ()V 
.const [243] = Utf8 de/audi/atip/interapp/NaviOnlineService$POIOnlineData 
.const [244] = Utf8 line0 
.const [245] = Utf8 Ljava/lang/String; 
.const [246] = Utf8 de/audi/atip/interapp/NaviOnlineService$POIOnlineData 
.const [247] = Utf8 line1 
.const [248] = Utf8 Ljava/lang/String; 
.const [249] = Utf8 java/lang/StringBuffer 
.const [250] = Utf8 append 
.const [251] = Utf8 (Ljava/lang/String;)Ljava/lang/StringBuffer; 
.const [252] = Utf8 java/lang/StringBuffer 
.const [253] = Utf8 toString 
.const [254] = Utf8 ()Ljava/lang/String; 
.const [255] = Utf8 de/audi/app/navi/evo/online/NaviOnlineServiceImplEvo 
.const [256] = Utf8 rrdRequestList 
.const [257] = Utf8 Ljava/util/ArrayList; 
.const [258] = Utf8 de/audi/app/navi/evo/online/NaviOnlineServiceImplEvo 
.const [259] = Utf8 latitudes 
.const [260] = Utf8 [I 
.const [261] = Utf8 de/audi/app/navi/evo/online/NaviOnlineServiceImplEvo 
.const [262] = Utf8 longitudes 
.const [263] = Utf8 [I 
.const [264] = Utf8 de/audi/app/navi/evo/online/NaviOnlineServiceImplEvo 
.const [265] = Utf8 airDistanceListEvo 
.const [266] = Utf8 Ljava/util/ArrayList; 
.const [267] = Utf8 java/util/ArrayList 
.const [268] = Utf8 size 
.const [269] = Utf8 ()I 
.const [270] = Utf8 java/util/ArrayList 
.const [271] = Utf8 get 
.const [272] = Utf8 (I)Ljava/lang/Object; 
.const [273] = Utf8 de/audi/atip/interapp/NaviOnlineService$RrdData 
.const [274] = Utf8 getModelContainer 
.const [275] = Utf8 ()Ljava/lang/Object; 
.const [276] = Utf8 de/audi/atip/interapp/NaviOnlineService$RrdData 
.const [277] = Utf8 getModel 
.const [278] = Utf8 ()Ljava/lang/Object; 
.const [279] = Utf8 de/audi/atip/interapp/NaviOnlineService$RrdData 
.const [280] = Utf8 setModel 
.const [281] = Utf8 (Ljava/lang/Object;)V 
.const [282] = Utf8 de/audi/tghu/navi/app/online/NaviOnlineServiceImpl 
.const [283] = Utf8 <init> 
.const [284] = Utf8 (Lde/audi/tghu/navi/app/NavigationEnv;Lde/audi/atip/log/LogChannel;Lde/audi/tghu/navi/app/guidance/IVehicle;Lde/audi/tghu/navi/app/map/MapInterface;Lde/audi/tghu/navi/app/routeguidance/IRouteManager;Lde/audi/tghu/navi/app/OperationManager;Lde/audi/tghu/command/ICommandListFactory;Lde/audi/tghu/navi/app/addressinput/IAddressInputForm;Lde/audi/tghu/navi/app/addressinput/poi/rrd/IRRDListener;Lde/audi/tghu/navi/app/routeguidance/IStartGuidanceToDestinationSequence;Lde/audi/tghu/navi/app/routeguidance/AddSelectedDestinationAtIndexCommandListCreator;)V 
.const [285] = Utf8 de/audi/atip/timer/Timer 
.const [286] = Utf8 <init> 
.const [287] = Utf8 (Ljava/lang/String;ILde/audi/atip/log/LogChannel;Lde/audi/atip/timer/TimerListener;JZ)V 
.const [288] = Utf8 de/audi/app/navi/evo/online/NaviOnlineServiceImplEvo 
.const [289] = Utf8 sameAsPreviousApps 
.const [290] = Utf8 (Ljava/util/List;)Z 
.const [291] = Utf8 de/audi/tghu/navi/app/online/NaviOnlineServiceImpl 
.const [292] = Utf8 overrideVariantSpecificPOIViewportValues 
.const [293] = Utf8 ([Lde/audi/atip/interapp/NaviOnlineService$POIOnlineData;[Lorg/dsi/ifc/online/PoiOnlineSearchValuelistElement;I)V 
.const [294] = Utf8 java/lang/StringBuffer 
.const [295] = Utf8 <init> 
.const [296] = Utf8 ()V 
.const [297] = Utf8 de/audi/app/navi/evo/online/NaviOnlineServiceImplEvo 
.const [298] = Utf8 swapModel 
.const [299] = Utf8 (Ljava/util/ArrayList;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)I 
.const [300] = Utf8 de/audi/app/navi/evo/online/NaviOnlineServiceImplEvo 
.const [301] = Utf8 remoteHMIAppsDestinationListener 
.const [302] = Utf8 Lde/audi/app/navi/evo/online/RemoteHMIAppsDestinationListener; 
.const [303] = Utf8 de/audi/app/navi/evo/online/NaviOnlineServiceImplEvo 
.const [304] = Utf8 remoteHMIAppsMapListener 
.const [305] = Utf8 Lde/audi/app/navi/evo/online/RemoteHMIAppsMapListener; 
.const [306] = Utf8 de/audi/app/navi/evo/online/NaviOnlineServiceImplEvo 
.const [307] = Utf8 updateAirdistanceTimer 
.const [308] = Utf8 Lde/audi/atip/timer/Timer; 
.const [309] = Utf8 de/audi/app/navi/evo/online/NaviOnlineServiceImplEvo 
.const [310] = Utf8 numberOfMiniAppsModel 
.const [311] = Utf8 Lde/audi/atip/hmi/modelaccess/ChoiceModelApp; 
.const [312] = Utf8 de/audi/atip/hmi/modelaccess/ChoiceModelApp 
.const [313] = Utf8 setValue 
.const [314] = Utf8 (I)V 
.const [315] = Utf8 de/audi/atip/hmi/modelaccess/ChoiceModelApp 
.const [316] = Utf8 setStatus 
.const [317] = Utf8 (I)V 
.const [318] = Utf8 java/util/List 
.const [319] = Utf8 size 
.const [320] = Utf8 ()I 
.const [321] = Utf8 de/audi/app/navi/evo/online/NaviOnlineServiceImplEvo 
.const [322] = Utf8 previousRemoteHMIApps 
.const [323] = Utf8 Ljava/util/List; 
.const [324] = Utf8 de/audi/atip/hmi/modelaccess/ChoiceModelApp 
.const [325] = Utf8 getValue 
.const [326] = Utf8 ()I 
.const [327] = Utf8 java/util/List 
.const [328] = Utf8 get 
.const [329] = Utf8 (I)Ljava/lang/Object; 
.const [330] = Utf8 org/dsi/ifc/online/PoiOnlineSearchValuelistElement 
.const [331] = Utf8 name 
.const [332] = Utf8 Ljava/lang/String; 
.const [333] = Utf8 de/audi/app/navi/evo/online/NaviOnlineServiceImplEvo 
.const [334] = Class [333] 
.const [335] = Utf8 de/audi/tghu/navi/app/online/NaviOnlineServiceImpl 
.const [336] = Class [335] 
.const [337] = Utf8 de/audi/atip/timer/TimerListener 
.const [338] = Class [337] 
.const [339] = Utf8 AIR_DELAY 
.const [340] = Utf8 J 
.const [341] = Utf8 airDistanceListEvo 
.const [342] = Utf8 Ljava/util/ArrayList; 
.const [343] = Utf8 remoteHMIAppsMapListener 
.const [344] = Utf8 Lde/audi/app/navi/evo/online/RemoteHMIAppsMapListener; 
.const [345] = Utf8 remoteHMIAppsDestinationListener 
.const [346] = Utf8 Lde/audi/app/navi/evo/online/RemoteHMIAppsDestinationListener; 
.const [347] = Utf8 numberOfMiniAppsModel 
.const [348] = Utf8 Lde/audi/atip/hmi/modelaccess/ChoiceModelApp; 
.const [349] = Utf8 previousRemoteHMIApps 
.const [350] = Utf8 Ljava/util/List; 
.const [351] = Utf8 Code 
.const [352] = Utf8 <init> 
.const [353] = Utf8 (Lde/audi/tghu/navi/app/NavigationEnv;Lde/audi/atip/log/LogChannel;Lde/audi/tghu/navi/app/guidance/IVehicle;Lde/audi/tghu/navi/app/map/MapInterface;Lde/audi/tghu/navi/app/routeguidance/IRouteManager;Lde/audi/tghu/navi/app/OperationManager;Lde/audi/tghu/command/ICommandListFactory;Lde/audi/tghu/navi/app/addressinput/IAddressInputForm;Lde/audi/tghu/navi/app/addressinput/poi/rrd/IRRDListener;Lde/audi/tghu/navi/app/routeguidance/IStartGuidanceToDestinationSequence;Lde/audi/app/navi/evo/online/RemoteHMIAppsDestinationListener;Lde/audi/app/navi/evo/online/RemoteHMIAppsMapListener;Lde/audi/tghu/navi/app/routeguidance/AddSelectedDestinationAtIndexCommandListCreator;)V 
.const [354] = Utf8 sendRemoteHMIAppsUpdateToNaviAndMap 
.const [355] = Utf8 (Ljava/util/List;)V 
.const [356] = Utf8 sameAsPreviousApps 
.const [357] = Utf8 (Ljava/util/List;)Z 
.const [358] = Utf8 sendMiniAppsDownloadError 
.const [359] = Utf8 ()V 
.const [360] = Utf8 overrideVariantSpecificPOIViewportValues 
.const [361] = Utf8 ([Lde/audi/atip/interapp/NaviOnlineService$POIOnlineData;[Lorg/dsi/ifc/online/PoiOnlineSearchValuelistElement;I)V 
.const [362] = Utf8 swapModel 
.const [363] = Utf8 (Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;II)V 
.const [364] = Utf8 swapModel 
.const [365] = Utf8 (Ljava/util/ArrayList;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)I 
.end class 
