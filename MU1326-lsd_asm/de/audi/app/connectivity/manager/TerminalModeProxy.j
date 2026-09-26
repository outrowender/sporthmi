.version 50 0 
.class super [351] 
.super [353] 
.implements [355] 
.field private final [356] [357] 
.field private final [358] [359] 
.field private final [360] [361] 
.field private [362] [363] 
.field private [364] [365] 
.field private [366] [367] 
.field private [368] [369] 
.field private [370] [371] 
.field static synthetic [372] [373] 
.field static synthetic [374] [375] 

.method [377] : [378] 
    .attribute [376] .code stack 3 locals 0 
L0:     aload_0 
L1:     invokespecial [53] 
L4:     aload_0 
L5:     new [60] 
L8:     dup 
L9:     invokespecial [54] 
L12:    putfield [61] 
L15:    aload_0 
L16:    aload_3 
L17:    putfield [62] 
L20:    aload_0 
L21:    aload_1 
L22:    putfield [63] 
L25:    aload_0 
L26:    aload_2 
L27:    putfield [64] 
L30:    return 
L31:    nop 
L32:    
    .end code 
.end method 

.method [379] : [380] 
    .attribute [376] .code stack 3 locals 3 
L0:     aload_0 
L1:     getfield [39] 
L4:     ifnull L53 
L7:     aload_0 
L8:     getfield [35] 
L11:    dup 
L12:    astore_2 
L13:    monitorenter 
        .catch [0] from L14 to L40 using L43 
L14:    aload_0 
L15:    getfield [35] 
L18:    aload_1 
L19:    invokeinterface [66] 0 
L24:    checkcast [6] 
L27:    astore_3 
L28:    aload_0 
L29:    getfield [39] 
L32:    aload_3 
L33:    invokeinterface [67] 0 
L38:    aload_2 
L39:    monitorexit 
L40:    goto L50 
        .catch [0] from L43 to L47 using L43 
L43:    astore 4 
L45:    aload_2 
L46:    monitorexit 
L47:    aload 4 
L49:    athrow 
L50:    goto L65 
L53:    aload_0 
L54:    getfield [38] 
L57:    ldc [7] 
L59:    ldc [8] 
L61:    invokevirtual [40] 
L64:    pop 
L65:    return 
L66:    nop 
L67:    nop 
L68:    
    .end code 
.end method 

.method [381] : [382] 
    .attribute [376] .code stack 3 locals 3 
L0:     aload_0 
L1:     getfield [39] 
L4:     ifnull L53 
L7:     aload_0 
L8:     getfield [35] 
L11:    dup 
L12:    astore_2 
L13:    monitorenter 
        .catch [0] from L14 to L40 using L43 
L14:    aload_0 
L15:    getfield [35] 
L18:    aload_1 
L19:    invokeinterface [66] 0 
L24:    checkcast [6] 
L27:    astore_3 
L28:    aload_0 
L29:    getfield [39] 
L32:    aload_3 
L33:    invokeinterface [68] 0 
L38:    aload_2 
L39:    monitorexit 
L40:    goto L50 
        .catch [0] from L43 to L47 using L43 
L43:    astore 4 
L45:    aload_2 
L46:    monitorexit 
L47:    aload 4 
L49:    athrow 
L50:    goto L65 
L53:    aload_0 
L54:    getfield [38] 
L57:    ldc [7] 
L59:    ldc [9] 
L61:    invokevirtual [40] 
L64:    pop 
L65:    return 
L66:    nop 
L67:    nop 
L68:    
    .end code 
.end method 

.method [383] : [384] 
    .attribute [376] .code stack 3 locals 3 
L0:     aload_0 
L1:     getfield [39] 
L4:     ifnull L79 
L7:     aload_0 
L8:     getfield [35] 
L11:    dup 
L12:    astore_2 
L13:    monitorenter 
        .catch [0] from L14 to L66 using L69 
L14:    aload_0 
L15:    getfield [35] 
L18:    aload_1 
L19:    invokeinterface [66] 0 
L24:    checkcast [6] 
L27:    astore_3 
L28:    aload_0 
L29:    getfield [39] 
L32:    aload_3 
L33:    invokeinterface [69] 0 
L38:    aload_0 
L39:    getfield [41] 
L42:    ifnull L64 
L45:    aload_0 
L46:    getfield [41] 
L49:    invokevirtual [42] 
L52:    aload_1 
L53:    invokevirtual [43] 
L56:    ifeq L64 
L59:    aload_0 
L60:    aconst_null 
L61:    putfield [70] 
L64:    aload_2 
L65:    monitorexit 
L66:    goto L76 
        .catch [0] from L69 to L73 using L69 
L69:    astore 4 
L71:    aload_2 
L72:    monitorexit 
L73:    aload 4 
L75:    athrow 
L76:    goto L91 
L79:    aload_0 
L80:    getfield [38] 
L83:    ldc [7] 
L85:    ldc [10] 
L87:    invokevirtual [40] 
L90:    pop 
L91:    return 
L92:    
    .end code 
.end method 

.method public [385] : [386] 
    .attribute [376] .code stack 4 locals 5 
L0:     aload_0 
L1:     getfield [38] 
L4:     ldc [11] 
L6:     ldc [12] 
L8:     aload_1 
L9:     invokestatic [13] 
L12:    invokevirtual [44] 
L15:    pop 
L16:    aload_1 
L17:    ifnull L128 
L20:    aload_0 
L21:    getfield [35] 
L24:    dup 
L25:    astore_2 
L26:    monitorenter 
        .catch [0] from L27 to L115 using L118 
L27:    aload_0 
L28:    getfield [35] 
L31:    invokeinterface [71] 0 
L36:    iconst_0 
L37:    istore_3 
L38:    iload_3 
L39:    aload_1 
L40:    arraylength 
L41:    if_icmpge L105 
L44:    aload_1 
L45:    iload_3 
L46:    aaload 
L47:    astore 4 
L49:    aload 4 
L51:    ifnull L62 
L54:    aload 4 
L56:    invokevirtual [42] 
L59:    goto L64 
L62:    ldc [14] 
L64:    astore 5 
L66:    aload_0 
L67:    getfield [35] 
L70:    aload 5 
L72:    aload 4 
L74:    invokeinterface [72] 0 
L79:    pop 
L80:    aload 4 
L82:    ifnull L99 
L85:    aload 4 
L87:    invokevirtual [45] 
L90:    ifeq L99 
L93:    aload_0 
L94:    aload 4 
L96:    putfield [70] 
L99:    iinc 3 1 
L102:   goto L38 
L105:   aload_0 
L106:   getfield [36] 
L109:   aload_1 
L110:   invokevirtual [46] 
L113:   aload_2 
L114:   monitorexit 
L115:   goto L125 
        .catch [0] from L118 to L122 using L118 
L118:   astore 6 
L120:   aload_2 
L121:   monitorexit 
L122:   aload 6 
L124:   athrow 
L125:   goto L141 
L128:   aload_0 
L129:   getfield [38] 
L132:   sipush 10000 
L135:   ldc [15] 
L137:   invokevirtual [40] 
L140:   pop 
L141:   return 
L142:   nop 
L143:   nop 
L144:   
    .end code 
.end method 

.method public [387] : [388] 
    .attribute [376] .code stack 2 locals 1 
L0:     aload_0 
L1:     getfield [37] 
L4:     aload_1 
L5:     invokeinterface [73] 0 
L10:    astore_2 
L11:    aload_2 
L12:    instanceof [16] 
L15:    ifeq L28 
L18:    aload_0 
L19:    aload_2 
L20:    checkcast [16] 
L23:    putfield [65] 
L26:    aload_2 
L27:    areturn 
L28:    aconst_null 
L29:    areturn 
L30:    nop 
L31:    nop 
L32:    
    .end code 
.end method 

.method public [389] : [390] 
    .attribute [376] .code stack 2 locals 0 
L0:     aload_2 
L1:     instanceof [16] 
L4:     ifeq L23 
L7:     aload_0 
L8:     aconst_null 
L9:     putfield [65] 
L12:    aload_0 
L13:    getfield [37] 
L16:    aload_1 
L17:    invokeinterface [74] 0 
L22:    pop 
L23:    return 
L24:    
    .end code 
.end method 

.method public [391] : [392] 
    .attribute [376] .code stack 2 locals 0 
L0:     aload_2 
L1:     instanceof [16] 
L4:     ifeq L15 
L7:     aload_0 
L8:     aload_2 
L9:     checkcast [16] 
L12:    putfield [65] 
L15:    return 
L16:    
    .end code 
.end method 

.method [393] : [394] 
    .attribute [376] .code stack 9 locals 0 
L0:     aload_0 
L1:     new [75] 
L4:     dup 
L5:     aload_0 
L6:     getfield [37] 
L9:     iconst_1 
L10:    anewarray [18] 
L13:    dup 
L14:    iconst_0 
L15:    getstatic [19] 
L18:    ifnonnull L33 
L21:    ldc [20] 
L23:    invokestatic [21] 
L26:    dup 
L27:    putstatic [55] 
L30:    goto L36 
L33:    getstatic [19] 
L36:    invokevirtual [47] 
L39:    aastore 
L40:    aload_0 
L41:    invokespecial [56] 
L44:    putfield [76] 
L47:    aload_0 
L48:    getfield [48] 
L51:    invokevirtual [49] 
L54:    aload_0 
L55:    aload_0 
L56:    getfield [37] 
L59:    getstatic [22] 
L62:    ifnonnull L77 
L65:    ldc [23] 
L67:    invokestatic [21] 
L70:    dup 
L71:    putstatic [57] 
L74:    goto L80 
L77:    getstatic [22] 
L80:    invokevirtual [47] 
L83:    aload_0 
L84:    new [77] 
L87:    dup 
L88:    iconst_0 
L89:    invokespecial [58] 
L92:    invokeinterface [78] 0 
L97:    putfield [79] 
L100:   return 
L101:   nop 
L102:   nop 
L103:   nop 
L104:   
    .end code 
.end method 

.method [395] : [396] 
    .attribute [376] .code stack 2 locals 0 
L0:     aload_0 
L1:     getfield [50] 
L4:     invokeinterface [80] 0 
L9:     aload_0 
L10:    aconst_null 
L11:    putfield [79] 
L14:    aload_0 
L15:    aconst_null 
L16:    putfield [65] 
L19:    aload_0 
L20:    getfield [48] 
L23:    invokevirtual [51] 
L26:    aload_0 
L27:    aconst_null 
L28:    putfield [76] 
L31:    return 
L32:    
    .end code 
.end method 

.method public interface [397] : [398] 
    .attribute [376] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [41] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method static synthetic [399] : [400] 
    .attribute [376] .code stack 2 locals 1 
        .catch [3] from L0 to L4 using L5 
L0:     aload_0 
L1:     invokestatic [2] 
L4:     areturn 
L5:     astore_1 
L6:     new [59] 
L9:     dup 
L10:    invokespecial [52] 
L13:    aload_1 
L14:    invokevirtual [34] 
L17:    athrow 
L18:    nop 
L19:    nop 
L20:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Method [81] [82] 
.const [3] = Class [83] 
.const [4] = Class [84] 
.const [5] = Class [85] 
.const [6] = Class [86] 
.const [7] = Int -1601830656 
.const [8] = String [87] 
.const [9] = String [88] 
.const [10] = String [89] 
.const [11] = Int 1078071040 
.const [12] = String [90] 
.const [13] = Method [91] [92] 
.const [14] = String [93] 
.const [15] = String [94] 
.const [16] = Class [95] 
.const [17] = Class [96] 
.const [18] = Class [97] 
.const [19] = Field [98] [99] 
.const [20] = String [100] 
.const [21] = Method [101] [102] 
.const [22] = Field [103] [104] 
.const [23] = String [105] 
.const [24] = Class [106] 
.const [25] = Class [107] 
.const [26] = Class [108] 
.const [27] = Class [109] 
.const [28] = Class [110] 
.const [29] = Class [111] 
.const [30] = Class [112] 
.const [31] = Class [113] 
.const [32] = Class [114] 
.const [33] = Class [115] 
.const [34] = Method [116] [117] 
.const [35] = Field [118] [119] 
.const [36] = Field [120] [121] 
.const [37] = Field [122] [123] 
.const [38] = Field [124] [125] 
.const [39] = Field [126] [127] 
.const [40] = Method [128] [129] 
.const [41] = Field [130] [131] 
.const [42] = Method [132] [133] 
.const [43] = Method [134] [135] 
.const [44] = Method [136] [137] 
.const [45] = Method [138] [139] 
.const [46] = Method [140] [141] 
.const [47] = Method [142] [143] 
.const [48] = Field [144] [145] 
.const [49] = Method [146] [147] 
.const [50] = Field [148] [149] 
.const [51] = Method [150] [151] 
.const [52] = Method [152] [153] 
.const [53] = Method [154] [155] 
.const [54] = Method [156] [157] 
.const [55] = Field [158] [159] 
.const [56] = Method [160] [161] 
.const [57] = Field [162] [163] 
.const [58] = Method [164] [165] 
.const [59] = Class [166] 
.const [60] = Class [167] 
.const [61] = Field [168] [169] 
.const [62] = Field [170] [171] 
.const [63] = Field [172] [173] 
.const [64] = Field [174] [175] 
.const [65] = Field [176] [177] 
.const [66] = InterfaceMethod [178] [179] 
.const [67] = InterfaceMethod [180] [181] 
.const [68] = InterfaceMethod [182] [183] 
.const [69] = InterfaceMethod [184] [185] 
.const [70] = Field [186] [187] 
.const [71] = InterfaceMethod [188] [189] 
.const [72] = InterfaceMethod [190] [191] 
.const [73] = InterfaceMethod [192] [193] 
.const [74] = InterfaceMethod [194] [195] 
.const [75] = Class [196] 
.const [76] = Field [197] [198] 
.const [77] = Class [199] 
.const [78] = InterfaceMethod [200] [201] 
.const [79] = Field [202] [203] 
.const [80] = InterfaceMethod [204] [205] 
.const [81] = Class [206] 
.const [82] = NameAndType [207] [208] 
.const [83] = Utf8 java/lang/ClassNotFoundException 
.const [84] = Utf8 java/lang/NoClassDefFoundError 
.const [85] = Utf8 java/util/HashMap 
.const [86] = Utf8 de/audi/atip/interapp/terminalmode/TerminalModeDevice 
.const [87] = Utf8 'TerminalModeProxy#activateSmartphone(): no ITerminalModeUpdateService available' 
.const [88] = Utf8 'TerminalModeProxy#deactivateSmartphone(): no ITerminalModeUpdateService available' 
.const [89] = Utf8 'TerminalModeProxy#deleteSmartphone(): no ITerminalModeUpdateService available' 
.const [90] = Utf8 'TerminalModeProxy#updateDeviceList(): pDeviceList=%1' 
.const [91] = Class [209] 
.const [92] = NameAndType [210] [211] 
.const [93] = Utf8 '' 
.const [94] = Utf8 'TerminalModeProxy#updateDeviceList(): pDeviceList is NULL' 
.const [95] = Utf8 de/audi/atip/interapp/terminalmode/ITerminalModeUpdateService 
.const [96] = Utf8 org/osgi/util/tracker/ServiceTracker 
.const [97] = Utf8 java/lang/String 
.const [98] = Class [212] 
.const [99] = NameAndType [213] [214] 
.const [100] = Utf8 'de.audi.atip.interapp.terminalmode.ITerminalModeUpdateService' 
.const [101] = Class [215] 
.const [102] = NameAndType [216] [217] 
.const [103] = Class [218] 
.const [104] = NameAndType [219] [220] 
.const [105] = Utf8 'de.audi.atip.interapp.terminalmode.ITerminalModeUpdateListener' 
.const [106] = Utf8 java/util/Hashtable 
.const [107] = Utf8 de/audi/app/connectivity/manager/TerminalModeProxy 
.const [108] = Utf8 de/audi/atip/interapp/terminalmode/DefaultTerminalModeUpdateListener 
.const [109] = Utf8 java/lang/Class 
.const [110] = Utf8 java/util/Map 
.const [111] = Utf8 de/audi/atip/log/LogChannel 
.const [112] = Utf8 de/esolutions/fw/util/commons/StringUtils 
.const [113] = Utf8 de/audi/app/connectivity/manager/ConnectivityManager 
.const [114] = Utf8 org/osgi/framework/BundleContext 
.const [115] = Utf8 org/osgi/framework/ServiceRegistration 
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
.const [136] = Class [251] 
.const [137] = NameAndType [252] [253] 
.const [138] = Class [254] 
.const [139] = NameAndType [255] [256] 
.const [140] = Class [257] 
.const [141] = NameAndType [258] [259] 
.const [142] = Class [260] 
.const [143] = NameAndType [261] [262] 
.const [144] = Class [263] 
.const [145] = NameAndType [264] [265] 
.const [146] = Class [266] 
.const [147] = NameAndType [267] [268] 
.const [148] = Class [269] 
.const [149] = NameAndType [270] [271] 
.const [150] = Class [272] 
.const [151] = NameAndType [273] [274] 
.const [152] = Class [275] 
.const [153] = NameAndType [276] [277] 
.const [154] = Class [278] 
.const [155] = NameAndType [279] [280] 
.const [156] = Class [281] 
.const [157] = NameAndType [282] [283] 
.const [158] = Class [284] 
.const [159] = NameAndType [285] [286] 
.const [160] = Class [287] 
.const [161] = NameAndType [288] [289] 
.const [162] = Class [290] 
.const [163] = NameAndType [291] [292] 
.const [164] = Class [293] 
.const [165] = NameAndType [294] [295] 
.const [166] = Utf8 java/lang/NoClassDefFoundError 
.const [167] = Utf8 java/util/HashMap 
.const [168] = Class [296] 
.const [169] = NameAndType [297] [298] 
.const [170] = Class [299] 
.const [171] = NameAndType [300] [301] 
.const [172] = Class [302] 
.const [173] = NameAndType [303] [304] 
.const [174] = Class [305] 
.const [175] = NameAndType [306] [307] 
.const [176] = Class [308] 
.const [177] = NameAndType [309] [310] 
.const [178] = Class [311] 
.const [179] = NameAndType [312] [313] 
.const [180] = Class [314] 
.const [181] = NameAndType [315] [316] 
.const [182] = Class [317] 
.const [183] = NameAndType [318] [319] 
.const [184] = Class [320] 
.const [185] = NameAndType [321] [322] 
.const [186] = Class [323] 
.const [187] = NameAndType [324] [325] 
.const [188] = Class [326] 
.const [189] = NameAndType [327] [328] 
.const [190] = Class [329] 
.const [191] = NameAndType [330] [331] 
.const [192] = Class [332] 
.const [193] = NameAndType [333] [334] 
.const [194] = Class [335] 
.const [195] = NameAndType [336] [337] 
.const [196] = Utf8 org/osgi/util/tracker/ServiceTracker 
.const [197] = Class [338] 
.const [198] = NameAndType [339] [340] 
.const [199] = Utf8 java/util/Hashtable 
.const [200] = Class [341] 
.const [201] = NameAndType [342] [343] 
.const [202] = Class [344] 
.const [203] = NameAndType [345] [346] 
.const [204] = Class [347] 
.const [205] = NameAndType [348] [349] 
.const [206] = Utf8 java/lang/Class 
.const [207] = Utf8 forName 
.const [208] = Utf8 (Ljava/lang/String;)Ljava/lang/Class; 
.const [209] = Utf8 de/esolutions/fw/util/commons/StringUtils 
.const [210] = Utf8 toString 
.const [211] = Utf8 ([Ljava/lang/Object;)Ljava/lang/String; 
.const [212] = Utf8 de/audi/app/connectivity/manager/TerminalModeProxy 
.const [213] = Utf8 class$de$audi$atip$interapp$terminalmode$ITerminalModeUpdateService 
.const [214] = Utf8 Ljava/lang/Class; 
.const [215] = Utf8 de/audi/app/connectivity/manager/TerminalModeProxy 
.const [216] = Utf8 class$ 
.const [217] = Utf8 (Ljava/lang/String;)Ljava/lang/Class; 
.const [218] = Utf8 de/audi/app/connectivity/manager/TerminalModeProxy 
.const [219] = Utf8 class$de$audi$atip$interapp$terminalmode$ITerminalModeUpdateListener 
.const [220] = Utf8 Ljava/lang/Class; 
.const [221] = Utf8 java/lang/NoClassDefFoundError 
.const [222] = Utf8 initCause 
.const [223] = Utf8 (Ljava/lang/Throwable;)Ljava/lang/Throwable; 
.const [224] = Utf8 de/audi/app/connectivity/manager/TerminalModeProxy 
.const [225] = Utf8 smartphones 
.const [226] = Utf8 Ljava/util/Map; 
.const [227] = Utf8 de/audi/app/connectivity/manager/TerminalModeProxy 
.const [228] = Utf8 coma 
.const [229] = Utf8 Lde/audi/app/connectivity/manager/ConnectivityManager; 
.const [230] = Utf8 de/audi/app/connectivity/manager/TerminalModeProxy 
.const [231] = Utf8 bundleContext 
.const [232] = Utf8 Lorg/osgi/framework/BundleContext; 
.const [233] = Utf8 de/audi/app/connectivity/manager/TerminalModeProxy 
.const [234] = Utf8 log 
.const [235] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [236] = Utf8 de/audi/app/connectivity/manager/TerminalModeProxy 
.const [237] = Utf8 service 
.const [238] = Utf8 Lde/audi/atip/interapp/terminalmode/ITerminalModeUpdateService; 
.const [239] = Utf8 de/audi/atip/log/LogChannel 
.const [240] = Utf8 log 
.const [241] = Utf8 (ILjava/lang/String;)Z 
.const [242] = Utf8 de/audi/app/connectivity/manager/TerminalModeProxy 
.const [243] = Utf8 carplayActiveDevice 
.const [244] = Utf8 Lde/audi/atip/interapp/terminalmode/TerminalModeDevice; 
.const [245] = Utf8 de/audi/atip/interapp/terminalmode/TerminalModeDevice 
.const [246] = Utf8 getDeviceUniqueId 
.const [247] = Utf8 ()Ljava/lang/String; 
.const [248] = Utf8 java/lang/String 
.const [249] = Utf8 equals 
.const [250] = Utf8 (Ljava/lang/Object;)Z 
.const [251] = Utf8 de/audi/atip/log/LogChannel 
.const [252] = Utf8 log 
.const [253] = Utf8 (ILjava/lang/String;Ljava/lang/Object;)Z 
.const [254] = Utf8 de/audi/atip/interapp/terminalmode/TerminalModeDevice 
.const [255] = Utf8 isActive 
.const [256] = Utf8 ()Z 
.const [257] = Utf8 de/audi/app/connectivity/manager/ConnectivityManager 
.const [258] = Utf8 updateSmartphones 
.const [259] = Utf8 ([Lde/audi/atip/interapp/terminalmode/TerminalModeDevice;)V 
.const [260] = Utf8 java/lang/Class 
.const [261] = Utf8 getName 
.const [262] = Utf8 ()Ljava/lang/String; 
.const [263] = Utf8 de/audi/app/connectivity/manager/TerminalModeProxy 
.const [264] = Utf8 serviceTracker 
.const [265] = Utf8 Lorg/osgi/util/tracker/ServiceTracker; 
.const [266] = Utf8 org/osgi/util/tracker/ServiceTracker 
.const [267] = Utf8 'open' 
.const [268] = Utf8 ()V 
.const [269] = Utf8 de/audi/app/connectivity/manager/TerminalModeProxy 
.const [270] = Utf8 registration 
.const [271] = Utf8 Lorg/osgi/framework/ServiceRegistration; 
.const [272] = Utf8 org/osgi/util/tracker/ServiceTracker 
.const [273] = Utf8 close 
.const [274] = Utf8 ()V 
.const [275] = Utf8 java/lang/NoClassDefFoundError 
.const [276] = Utf8 <init> 
.const [277] = Utf8 ()V 
.const [278] = Utf8 de/audi/atip/interapp/terminalmode/DefaultTerminalModeUpdateListener 
.const [279] = Utf8 <init> 
.const [280] = Utf8 ()V 
.const [281] = Utf8 java/util/HashMap 
.const [282] = Utf8 <init> 
.const [283] = Utf8 ()V 
.const [284] = Utf8 de/audi/app/connectivity/manager/TerminalModeProxy 
.const [285] = Utf8 class$de$audi$atip$interapp$terminalmode$ITerminalModeUpdateService 
.const [286] = Utf8 Ljava/lang/Class; 
.const [287] = Utf8 org/osgi/util/tracker/ServiceTracker 
.const [288] = Utf8 <init> 
.const [289] = Utf8 (Lorg/osgi/framework/BundleContext;[Ljava/lang/String;Lorg/osgi/util/tracker/ServiceTrackerCustomizer;)V 
.const [290] = Utf8 de/audi/app/connectivity/manager/TerminalModeProxy 
.const [291] = Utf8 class$de$audi$atip$interapp$terminalmode$ITerminalModeUpdateListener 
.const [292] = Utf8 Ljava/lang/Class; 
.const [293] = Utf8 java/util/Hashtable 
.const [294] = Utf8 <init> 
.const [295] = Utf8 (I)V 
.const [296] = Utf8 de/audi/app/connectivity/manager/TerminalModeProxy 
.const [297] = Utf8 smartphones 
.const [298] = Utf8 Ljava/util/Map; 
.const [299] = Utf8 de/audi/app/connectivity/manager/TerminalModeProxy 
.const [300] = Utf8 coma 
.const [301] = Utf8 Lde/audi/app/connectivity/manager/ConnectivityManager; 
.const [302] = Utf8 de/audi/app/connectivity/manager/TerminalModeProxy 
.const [303] = Utf8 bundleContext 
.const [304] = Utf8 Lorg/osgi/framework/BundleContext; 
.const [305] = Utf8 de/audi/app/connectivity/manager/TerminalModeProxy 
.const [306] = Utf8 log 
.const [307] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [308] = Utf8 de/audi/app/connectivity/manager/TerminalModeProxy 
.const [309] = Utf8 service 
.const [310] = Utf8 Lde/audi/atip/interapp/terminalmode/ITerminalModeUpdateService; 
.const [311] = Utf8 java/util/Map 
.const [312] = Utf8 get 
.const [313] = Utf8 (Ljava/lang/Object;)Ljava/lang/Object; 
.const [314] = Utf8 de/audi/atip/interapp/terminalmode/ITerminalModeUpdateService 
.const [315] = Utf8 activateDevice 
.const [316] = Utf8 (Lde/audi/atip/interapp/terminalmode/TerminalModeDevice;)V 
.const [317] = Utf8 de/audi/atip/interapp/terminalmode/ITerminalModeUpdateService 
.const [318] = Utf8 deactivateDevice 
.const [319] = Utf8 (Lde/audi/atip/interapp/terminalmode/TerminalModeDevice;)V 
.const [320] = Utf8 de/audi/atip/interapp/terminalmode/ITerminalModeUpdateService 
.const [321] = Utf8 deleteDeviceFromPersistence 
.const [322] = Utf8 (Lde/audi/atip/interapp/terminalmode/TerminalModeDevice;)V 
.const [323] = Utf8 de/audi/app/connectivity/manager/TerminalModeProxy 
.const [324] = Utf8 carplayActiveDevice 
.const [325] = Utf8 Lde/audi/atip/interapp/terminalmode/TerminalModeDevice; 
.const [326] = Utf8 java/util/Map 
.const [327] = Utf8 clear 
.const [328] = Utf8 ()V 
.const [329] = Utf8 java/util/Map 
.const [330] = Utf8 put 
.const [331] = Utf8 (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object; 
.const [332] = Utf8 org/osgi/framework/BundleContext 
.const [333] = Utf8 getService 
.const [334] = Utf8 (Lorg/osgi/framework/ServiceReference;)Ljava/lang/Object; 
.const [335] = Utf8 org/osgi/framework/BundleContext 
.const [336] = Utf8 ungetService 
.const [337] = Utf8 (Lorg/osgi/framework/ServiceReference;)Z 
.const [338] = Utf8 de/audi/app/connectivity/manager/TerminalModeProxy 
.const [339] = Utf8 serviceTracker 
.const [340] = Utf8 Lorg/osgi/util/tracker/ServiceTracker; 
.const [341] = Utf8 org/osgi/framework/BundleContext 
.const [342] = Utf8 registerService 
.const [343] = Utf8 (Ljava/lang/String;Ljava/lang/Object;Ljava/util/Dictionary;)Lorg/osgi/framework/ServiceRegistration; 
.const [344] = Utf8 de/audi/app/connectivity/manager/TerminalModeProxy 
.const [345] = Utf8 registration 
.const [346] = Utf8 Lorg/osgi/framework/ServiceRegistration; 
.const [347] = Utf8 org/osgi/framework/ServiceRegistration 
.const [348] = Utf8 unregister 
.const [349] = Utf8 ()V 
.const [350] = Utf8 de/audi/app/connectivity/manager/TerminalModeProxy 
.const [351] = Class [350] 
.const [352] = Utf8 de/audi/atip/interapp/terminalmode/DefaultTerminalModeUpdateListener 
.const [353] = Class [352] 
.const [354] = Utf8 org/osgi/util/tracker/ServiceTrackerCustomizer 
.const [355] = Class [354] 
.const [356] = Utf8 bundleContext 
.const [357] = Utf8 Lorg/osgi/framework/BundleContext; 
.const [358] = Utf8 log 
.const [359] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [360] = Utf8 coma 
.const [361] = Utf8 Lde/audi/app/connectivity/manager/ConnectivityManager; 
.const [362] = Utf8 carplayActiveDevice 
.const [363] = Utf8 Lde/audi/atip/interapp/terminalmode/TerminalModeDevice; 
.const [364] = Utf8 serviceTracker 
.const [365] = Utf8 Lorg/osgi/util/tracker/ServiceTracker; 
.const [366] = Utf8 service 
.const [367] = Utf8 Lde/audi/atip/interapp/terminalmode/ITerminalModeUpdateService; 
.const [368] = Utf8 registration 
.const [369] = Utf8 Lorg/osgi/framework/ServiceRegistration; 
.const [370] = Utf8 smartphones 
.const [371] = Utf8 Ljava/util/Map; 
.const [372] = Utf8 class$de$audi$atip$interapp$terminalmode$ITerminalModeUpdateService 
.const [373] = Utf8 Ljava/lang/Class; 
.const [374] = Utf8 class$de$audi$atip$interapp$terminalmode$ITerminalModeUpdateListener 
.const [375] = Utf8 Ljava/lang/Class; 
.const [376] = Utf8 Code 
.const [377] = Utf8 <init> 
.const [378] = Utf8 (Lorg/osgi/framework/BundleContext;Lde/audi/atip/log/LogChannel;Lde/audi/app/connectivity/manager/ConnectivityManager;)V 
.const [379] = Utf8 activateSmartphone 
.const [380] = Utf8 (Ljava/lang/String;)V 
.const [381] = Utf8 deactivateSmartphone 
.const [382] = Utf8 (Ljava/lang/String;)V 
.const [383] = Utf8 deleteSmartphone 
.const [384] = Utf8 (Ljava/lang/String;)V 
.const [385] = Utf8 updateDeviceList 
.const [386] = Utf8 ([Lde/audi/atip/interapp/terminalmode/TerminalModeDevice;)V 
.const [387] = Utf8 addingService 
.const [388] = Utf8 (Lorg/osgi/framework/ServiceReference;)Ljava/lang/Object; 
.const [389] = Utf8 removedService 
.const [390] = Utf8 (Lorg/osgi/framework/ServiceReference;Ljava/lang/Object;)V 
.const [391] = Utf8 modifiedService 
.const [392] = Utf8 (Lorg/osgi/framework/ServiceReference;Ljava/lang/Object;)V 
.const [393] = Utf8 init 
.const [394] = Utf8 ()V 
.const [395] = Utf8 deinit 
.const [396] = Utf8 ()V 
.const [397] = Utf8 getCarplayActiveDevice 
.const [398] = Utf8 ()Lde/audi/atip/interapp/terminalmode/TerminalModeDevice; 
.const [399] = Utf8 class$ 
.const [400] = Utf8 (Ljava/lang/String;)Ljava/lang/Class; 
.end class 
