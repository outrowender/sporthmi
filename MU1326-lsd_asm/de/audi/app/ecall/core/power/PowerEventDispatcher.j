.version 50 0 
.class public super [374] 
.super [376] 
.implements [378] 
.implements [380] 
.field private final [381] [382] 
.field private final [383] [384] 
.field private final [385] [386] 
.field private [387] [388] 
.field private [389] [390] 
.field private [391] [392] 
.field private [393] [394] 
.field private final [395] [396] 
.field static synthetic [397] [398] 

.method public [400] : [401] 
    .attribute [399] .code stack 8 locals 0 
L0:     aload_0 
L1:     invokespecial [61] 
L4:     aload_0 
L5:     new [69] 
L8:     dup 
L9:     invokespecial [61] 
L12:    putfield [70] 
L15:    aload_0 
L16:    aload_1 
L17:    putfield [71] 
L20:    aload_0 
L21:    new [72] 
L24:    dup 
L25:    bipush 10 
L27:    invokespecial [62] 
L30:    putfield [73] 
L33:    aload_0 
L34:    new [74] 
L37:    dup 
L38:    getstatic [8] 
L41:    ifnonnull L56 
L44:    ldc [9] 
L46:    invokestatic [10] 
L49:    dup 
L50:    putstatic [63] 
L53:    goto L59 
L56:    getstatic [8] 
L59:    invokevirtual [40] 
L62:    aload_0 
L63:    new [75] 
L66:    dup 
L67:    iconst_0 
L68:    invokespecial [64] 
L71:    aload_2 
L72:    aload_1 
L73:    invokespecial [65] 
L76:    putfield [76] 
L79:    return 
L80:    
    .end code 
.end method 

.method public [402] : [403] 
    .attribute [399] .code stack 3 locals 0 
L0:     aload_0 
L1:     getfield [38] 
L4:     ldc [12] 
L6:     ldc [13] 
L8:     invokevirtual [42] 
L11:    pop 
L12:    aload_0 
L13:    getfield [41] 
L16:    invokevirtual [43] 
L19:    return 
L20:    
    .end code 
.end method 

.method public [404] : [405] 
    .attribute [399] .code stack 3 locals 2 
L0:     aload_0 
L1:     getfield [38] 
L4:     ldc [12] 
L6:     ldc [14] 
L8:     invokevirtual [42] 
L11:    pop 
L12:    aload_0 
L13:    getfield [41] 
L16:    invokevirtual [44] 
L19:    aload_0 
L20:    getfield [39] 
L23:    dup 
L24:    astore_1 
L25:    monitorenter 
        .catch [0] from L26 to L35 using L38 
L26:    aload_0 
L27:    getfield [39] 
L30:    invokevirtual [45] 
L33:    aload_1 
L34:    monitorexit 
L35:    goto L43 
        .catch [0] from L38 to L41 using L38 
L38:    astore_2 
L39:    aload_1 
L40:    monitorexit 
L41:    aload_2 
L42:    athrow 
L43:    return 
L44:    
    .end code 
.end method 

.method public [406] : [407] 
    .attribute [399] .code stack 5 locals 8 
L0:     aload_0 
L1:     getfield [38] 
L4:     ldc [12] 
L6:     ldc [15] 
L8:     aload_1 
L9:     invokevirtual [46] 
L12:    pop 
L13:    aload_0 
L14:    getfield [39] 
L17:    dup 
L18:    astore_2 
L19:    monitorenter 
L20:    aload_0 
L21:    getfield [39] 
L24:    aload_1 
L25:    invokevirtual [47] 
L28:    ifeq L46 
L31:    aload_0 
L32:    getfield [38] 
L35:    ldc [16] 
L37:    ldc [17] 
L39:    invokevirtual [42] 
L42:    pop 
L43:    aload_2 
L44:    monitorexit 
L45:    return 
L46:    aload_0 
L47:    getfield [39] 
L50:    aload_1 
L51:    invokevirtual [48] 
L54:    pop 
L55:    iconst_0 
L56:    istore_3 
L57:    iconst_0 
L58:    istore 4 
L60:    iconst_0 
L61:    istore 5 
L63:    iconst_0 
L64:    istore 6 
L66:    aload_0 
L67:    getfield [37] 
L70:    dup 
L71:    astore 7 
L73:    monitorenter 
        .catch [0] from L74 to L100 using L103 
L74:    aload_0 
L75:    getfield [49] 
L78:    istore_3 
L79:    aload_0 
L80:    getfield [50] 
L83:    istore 4 
L85:    aload_0 
L86:    getfield [51] 
L89:    istore 5 
L91:    aload_0 
L92:    getfield [52] 
L95:    istore 6 
L97:    aload 7 
L99:    monitorexit 
L100:   goto L111 
        .catch [0] from L103 to L108 using L103 
        .catch [0] from L20 to L45 using L129 
        .catch [0] from L46 to L126 using L129 
L103:   astore 8 
L105:   aload 7 
L107:   monitorexit 
L108:   aload 8 
L110:   athrow 
L111:   aload_1 
L112:   iload_3 
L113:   iload 4 
L115:   iload 5 
L117:   iload 6 
L119:   invokeinterface [81] 0 
L124:   aload_2 
L125:   monitorexit 
L126:   goto L136 
        .catch [0] from L129 to L133 using L129 
L129:   astore 9 
L131:   aload_2 
L132:   monitorexit 
L133:   aload 9 
L135:   athrow 
L136:   return 
L137:   nop 
L138:   nop 
L139:   nop 
L140:   
    .end code 
.end method 

.method public [408] : [409] 
    .attribute [399] .code stack 4 locals 2 
L0:     aload_0 
L1:     getfield [38] 
L4:     ldc [12] 
L6:     ldc [18] 
L8:     aload_1 
L9:     invokevirtual [46] 
L12:    pop 
L13:    aload_0 
L14:    getfield [39] 
L17:    dup 
L18:    astore_2 
L19:    monitorenter 
        .catch [0] from L20 to L57 using L60 
L20:    aload_0 
L21:    getfield [39] 
L24:    aload_1 
L25:    invokevirtual [47] 
L28:    ifeq L43 
L31:    aload_0 
L32:    getfield [39] 
L35:    aload_1 
L36:    invokevirtual [53] 
L39:    pop 
L40:    goto L55 
L43:    aload_0 
L44:    getfield [38] 
L47:    ldc [16] 
L49:    ldc [19] 
L51:    invokevirtual [42] 
L54:    pop 
L55:    aload_2 
L56:    monitorexit 
L57:    goto L65 
        .catch [0] from L60 to L63 using L60 
L60:    astore_3 
L61:    aload_2 
L62:    monitorexit 
L63:    aload_3 
L64:    athrow 
L65:    return 
L66:    nop 
L67:    nop 
L68:    
    .end code 
.end method 

.method public [410] : [411] 
    .attribute [399] .code stack 7 locals 1 
L0:     aload_0 
L1:     getfield [38] 
L4:     ldc [20] 
L6:     ldc [21] 
L8:     iload_1 
L9:     i2l 
L10:    iload_2 
L11:    i2l 
L12:    invokevirtual [54] 
L15:    pop 
L16:    aload_0 
L17:    invokespecial [66] 
L20:    invokeinterface [82] 0 
L25:    astore_3 
L26:    aload_3 
L27:    invokeinterface [83] 0 
L32:    ifeq L53 
L35:    aload_3 
L36:    invokeinterface [84] 0 
L41:    checkcast [22] 
L44:    iload_1 
L45:    invokeinterface [85] 0 
L50:    goto L26 
L53:    return 
L54:    nop 
L55:    nop 
L56:    
    .end code 
.end method 

.method public [412] : [413] 
    .attribute [399] .code stack 7 locals 1 
L0:     aload_0 
L1:     getfield [38] 
L4:     ldc [20] 
L6:     ldc [23] 
L8:     iload_1 
L9:     i2l 
L10:    iload_2 
L11:    i2l 
L12:    invokevirtual [54] 
L15:    pop 
L16:    aload_0 
L17:    invokespecial [66] 
L20:    invokeinterface [82] 0 
L25:    astore_3 
L26:    aload_3 
L27:    invokeinterface [83] 0 
L32:    ifeq L53 
L35:    aload_3 
L36:    invokeinterface [84] 0 
L41:    checkcast [22] 
L44:    iload_1 
L45:    invokeinterface [86] 0 
L50:    goto L26 
L53:    return 
L54:    nop 
L55:    nop 
L56:    
    .end code 
.end method 

.method public [414] : [415] 
    .attribute [399] .code stack 7 locals 1 
L0:     aload_0 
L1:     getfield [38] 
L4:     ldc [20] 
L6:     ldc [24] 
L8:     iload_1 
L9:     i2l 
L10:    iload_2 
L11:    i2l 
L12:    invokevirtual [54] 
L15:    pop 
L16:    aload_0 
L17:    invokespecial [66] 
L20:    invokeinterface [82] 0 
L25:    astore_3 
L26:    aload_3 
L27:    invokeinterface [83] 0 
L32:    ifeq L53 
L35:    aload_3 
L36:    invokeinterface [84] 0 
L41:    checkcast [22] 
L44:    iload_1 
L45:    invokeinterface [87] 0 
L50:    goto L26 
L53:    return 
L54:    nop 
L55:    nop 
L56:    
    .end code 
.end method 

.method public [416] : [417] 
    .attribute [399] .code stack 5 locals 2 
L0:     aload_0 
L1:     getfield [38] 
L4:     invokevirtual [55] 
L7:     ifeq L78 
L10:    new [88] 
L13:    dup 
L14:    bipush 30 
L16:    invokespecial [67] 
L19:    astore 5 
L21:    aload 5 
L23:    ldc [26] 
L25:    invokevirtual [56] 
L28:    iload_1 
L29:    invokevirtual [57] 
L32:    ldc [27] 
L34:    invokevirtual [56] 
L37:    iload_2 
L38:    invokevirtual [57] 
L41:    ldc [28] 
L43:    invokevirtual [56] 
L46:    iload_3 
L47:    invokevirtual [57] 
L50:    ldc [29] 
L52:    invokevirtual [56] 
L55:    iload 4 
L57:    invokevirtual [57] 
L60:    pop 
L61:    aload_0 
L62:    getfield [38] 
L65:    ldc [20] 
L67:    ldc [30] 
L69:    aload 5 
L71:    invokevirtual [58] 
L74:    invokevirtual [46] 
L77:    pop 
L78:    aload_0 
L79:    getfield [37] 
L82:    dup 
L83:    astore 5 
L85:    monitorenter 
        .catch [0] from L86 to L110 using L113 
L86:    aload_0 
L87:    iload_1 
L88:    putfield [77] 
L91:    aload_0 
L92:    iload_2 
L93:    putfield [78] 
L96:    aload_0 
L97:    iload_3 
L98:    putfield [79] 
L101:   aload_0 
L102:   iload 4 
L104:   putfield [80] 
L107:   aload 5 
L109:   monitorexit 
L110:   goto L121 
        .catch [0] from L113 to L118 using L113 
L113:   astore 6 
L115:   aload 5 
L117:   monitorexit 
L118:   aload 6 
L120:   athrow 
L121:   aload_0 
L122:   invokespecial [66] 
L125:   invokeinterface [82] 0 
L130:   astore 5 
L132:   aload 5 
L134:   invokeinterface [83] 0 
L139:   ifeq L165 
L142:   aload 5 
L144:   invokeinterface [84] 0 
L149:   checkcast [22] 
L152:   iload_1 
L153:   iload_2 
L154:   iload_3 
L155:   iload 4 
L157:   invokeinterface [81] 0 
L162:   goto L132 
L165:   return 
L166:   nop 
L167:   nop 
L168:   
    .end code 
.end method 

.method private [418] : [419] 
    .attribute [399] .code stack 2 locals 3 
L0:     aload_0 
L1:     getfield [39] 
L4:     dup 
L5:     astore_2 
L6:     monitorenter 
        .catch [0] from L7 to L20 using L23 
L7:     aload_0 
L8:     getfield [39] 
L11:    invokevirtual [59] 
L14:    checkcast [6] 
L17:    astore_1 
L18:    aload_2 
L19:    monitorexit 
L20:    goto L28 
        .catch [0] from L23 to L26 using L23 
L23:    astore_3 
L24:    aload_2 
L25:    monitorexit 
L26:    aload_3 
L27:    athrow 
L28:    aload_1 
L29:    areturn 
L30:    nop 
L31:    nop 
L32:    
    .end code 
.end method 

.method static synthetic [420] : [421] 
    .attribute [399] .code stack 2 locals 1 
        .catch [3] from L0 to L4 using L5 
L0:     aload_0 
L1:     invokestatic [2] 
L4:     areturn 
L5:     astore_1 
L6:     new [68] 
L9:     dup 
L10:    invokespecial [60] 
L13:    aload_1 
L14:    invokevirtual [36] 
L17:    athrow 
L18:    nop 
L19:    nop 
L20:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Method [89] [90] 
.const [3] = Class [91] 
.const [4] = Class [92] 
.const [5] = Class [93] 
.const [6] = Class [94] 
.const [7] = Class [95] 
.const [8] = Field [96] [97] 
.const [9] = String [98] 
.const [10] = Method [99] [100] 
.const [11] = Class [101] 
.const [12] = Int -2137614336 
.const [13] = String [102] 
.const [14] = String [103] 
.const [15] = String [104] 
.const [16] = Int -1601830656 
.const [17] = String [105] 
.const [18] = String [106] 
.const [19] = String [107] 
.const [20] = Int 1078071040 
.const [21] = String [108] 
.const [22] = Class [109] 
.const [23] = String [110] 
.const [24] = String [111] 
.const [25] = Class [112] 
.const [26] = String [113] 
.const [27] = String [114] 
.const [28] = String [115] 
.const [29] = String [116] 
.const [30] = String [117] 
.const [31] = Class [118] 
.const [32] = Class [119] 
.const [33] = Class [120] 
.const [34] = Class [121] 
.const [35] = Class [122] 
.const [36] = Method [123] [124] 
.const [37] = Field [125] [126] 
.const [38] = Field [127] [128] 
.const [39] = Field [129] [130] 
.const [40] = Method [131] [132] 
.const [41] = Field [133] [134] 
.const [42] = Method [135] [136] 
.const [43] = Method [137] [138] 
.const [44] = Method [139] [140] 
.const [45] = Method [141] [142] 
.const [46] = Method [143] [144] 
.const [47] = Method [145] [146] 
.const [48] = Method [147] [148] 
.const [49] = Field [149] [150] 
.const [50] = Field [151] [152] 
.const [51] = Field [153] [154] 
.const [52] = Field [155] [156] 
.const [53] = Method [157] [158] 
.const [54] = Method [159] [160] 
.const [55] = Method [161] [162] 
.const [56] = Method [163] [164] 
.const [57] = Method [165] [166] 
.const [58] = Method [167] [168] 
.const [59] = Method [169] [170] 
.const [60] = Method [171] [172] 
.const [61] = Method [173] [174] 
.const [62] = Method [175] [176] 
.const [63] = Field [177] [178] 
.const [64] = Method [179] [180] 
.const [65] = Method [181] [182] 
.const [66] = Method [183] [184] 
.const [67] = Method [185] [186] 
.const [68] = Class [187] 
.const [69] = Class [188] 
.const [70] = Field [189] [190] 
.const [71] = Field [191] [192] 
.const [72] = Class [193] 
.const [73] = Field [194] [195] 
.const [74] = Class [196] 
.const [75] = Class [197] 
.const [76] = Field [198] [199] 
.const [77] = Field [200] [201] 
.const [78] = Field [202] [203] 
.const [79] = Field [204] [205] 
.const [80] = Field [206] [207] 
.const [81] = InterfaceMethod [208] [209] 
.const [82] = InterfaceMethod [210] [211] 
.const [83] = InterfaceMethod [212] [213] 
.const [84] = InterfaceMethod [214] [215] 
.const [85] = InterfaceMethod [216] [217] 
.const [86] = InterfaceMethod [218] [219] 
.const [87] = InterfaceMethod [220] [221] 
.const [88] = Class [222] 
.const [89] = Class [223] 
.const [90] = NameAndType [224] [225] 
.const [91] = Utf8 java/lang/ClassNotFoundException 
.const [92] = Utf8 java/lang/NoClassDefFoundError 
.const [93] = Utf8 java/lang/Object 
.const [94] = Utf8 java/util/ArrayList 
.const [95] = Utf8 de/audi/app/ecall/core/osgi/EcallServiceProvider 
.const [96] = Class [226] 
.const [97] = NameAndType [227] [228] 
.const [98] = Utf8 'de.audi.atip.power.PowerEventListener' 
.const [99] = Class [229] 
.const [100] = NameAndType [230] [231] 
.const [101] = Utf8 java/util/Hashtable 
.const [102] = Utf8 '[PowerEventDispatcher#init] called' 
.const [103] = Utf8 '[PowerEventDispatcher#deinit] called' 
.const [104] = Utf8 "[PowerEventDispatcher#addPowerEventListener] listener='%1'" 
.const [105] = Utf8 '[PowerEventDispatcher#addPowerEventListener] listener already registered' 
.const [106] = Utf8 "[PowerEventDispatcher#removePowerEventListener] listener='%1'" 
.const [107] = Utf8 '[PowerEventDispatcher#removePowerEventListener] listener not registered, cannot be removed' 
.const [108] = Utf8 "[PowerEventDispatcher#notifyPowerListenerOnEnterState] pwrevt='%1', terminalID='%2'" 
.const [109] = Utf8 de/audi/app/ecall/core/power/IPowerEventListener 
.const [110] = Utf8 "[PowerEventDispatcher#notifyPowerListenerOnExitState] pwrevt='%1', terminalID='%2'" 
.const [111] = Utf8 "[PowerEventDispatcher#notifyPowerTriggerAction] trigger='%1', terminalID='%2'" 
.const [112] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [113] = Utf8 'clampS=' 
.const [114] = Utf8 ', clamp15=' 
.const [115] = Utf8 ', clampX=' 
.const [116] = Utf8 ', clamp50=' 
.const [117] = Utf8 '[PowerEventDispatcher#updateClampState] %1' 
.const [118] = Utf8 de/audi/app/ecall/core/power/PowerEventDispatcher 
.const [119] = Utf8 java/lang/Class 
.const [120] = Utf8 de/audi/atip/log/LogChannel 
.const [121] = Utf8 java/util/List 
.const [122] = Utf8 java/util/Iterator 
.const [123] = Class [232] 
.const [124] = NameAndType [233] [234] 
.const [125] = Class [235] 
.const [126] = NameAndType [236] [237] 
.const [127] = Class [238] 
.const [128] = NameAndType [239] [240] 
.const [129] = Class [241] 
.const [130] = NameAndType [242] [243] 
.const [131] = Class [244] 
.const [132] = NameAndType [245] [246] 
.const [133] = Class [247] 
.const [134] = NameAndType [248] [249] 
.const [135] = Class [250] 
.const [136] = NameAndType [251] [252] 
.const [137] = Class [253] 
.const [138] = NameAndType [254] [255] 
.const [139] = Class [256] 
.const [140] = NameAndType [257] [258] 
.const [141] = Class [259] 
.const [142] = NameAndType [260] [261] 
.const [143] = Class [262] 
.const [144] = NameAndType [263] [264] 
.const [145] = Class [265] 
.const [146] = NameAndType [266] [267] 
.const [147] = Class [268] 
.const [148] = NameAndType [269] [270] 
.const [149] = Class [271] 
.const [150] = NameAndType [272] [273] 
.const [151] = Class [274] 
.const [152] = NameAndType [275] [276] 
.const [153] = Class [277] 
.const [154] = NameAndType [278] [279] 
.const [155] = Class [280] 
.const [156] = NameAndType [281] [282] 
.const [157] = Class [283] 
.const [158] = NameAndType [284] [285] 
.const [159] = Class [286] 
.const [160] = NameAndType [287] [288] 
.const [161] = Class [289] 
.const [162] = NameAndType [290] [291] 
.const [163] = Class [292] 
.const [164] = NameAndType [293] [294] 
.const [165] = Class [295] 
.const [166] = NameAndType [296] [297] 
.const [167] = Class [298] 
.const [168] = NameAndType [299] [300] 
.const [169] = Class [301] 
.const [170] = NameAndType [302] [303] 
.const [171] = Class [304] 
.const [172] = NameAndType [305] [306] 
.const [173] = Class [307] 
.const [174] = NameAndType [308] [309] 
.const [175] = Class [310] 
.const [176] = NameAndType [311] [312] 
.const [177] = Class [313] 
.const [178] = NameAndType [314] [315] 
.const [179] = Class [316] 
.const [180] = NameAndType [317] [318] 
.const [181] = Class [319] 
.const [182] = NameAndType [320] [321] 
.const [183] = Class [322] 
.const [184] = NameAndType [323] [324] 
.const [185] = Class [325] 
.const [186] = NameAndType [326] [327] 
.const [187] = Utf8 java/lang/NoClassDefFoundError 
.const [188] = Utf8 java/lang/Object 
.const [189] = Class [328] 
.const [190] = NameAndType [329] [330] 
.const [191] = Class [331] 
.const [192] = NameAndType [332] [333] 
.const [193] = Utf8 java/util/ArrayList 
.const [194] = Class [334] 
.const [195] = NameAndType [335] [336] 
.const [196] = Utf8 de/audi/app/ecall/core/osgi/EcallServiceProvider 
.const [197] = Utf8 java/util/Hashtable 
.const [198] = Class [337] 
.const [199] = NameAndType [338] [339] 
.const [200] = Class [340] 
.const [201] = NameAndType [341] [342] 
.const [202] = Class [343] 
.const [203] = NameAndType [344] [345] 
.const [204] = Class [346] 
.const [205] = NameAndType [347] [348] 
.const [206] = Class [349] 
.const [207] = NameAndType [350] [351] 
.const [208] = Class [352] 
.const [209] = NameAndType [353] [354] 
.const [210] = Class [355] 
.const [211] = NameAndType [356] [357] 
.const [212] = Class [358] 
.const [213] = NameAndType [359] [360] 
.const [214] = Class [361] 
.const [215] = NameAndType [362] [363] 
.const [216] = Class [364] 
.const [217] = NameAndType [365] [366] 
.const [218] = Class [367] 
.const [219] = NameAndType [368] [369] 
.const [220] = Class [370] 
.const [221] = NameAndType [371] [372] 
.const [222] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [223] = Utf8 java/lang/Class 
.const [224] = Utf8 forName 
.const [225] = Utf8 (Ljava/lang/String;)Ljava/lang/Class; 
.const [226] = Utf8 de/audi/app/ecall/core/power/PowerEventDispatcher 
.const [227] = Utf8 class$de$audi$atip$power$PowerEventListener 
.const [228] = Utf8 Ljava/lang/Class; 
.const [229] = Utf8 de/audi/app/ecall/core/power/PowerEventDispatcher 
.const [230] = Utf8 class$ 
.const [231] = Utf8 (Ljava/lang/String;)Ljava/lang/Class; 
.const [232] = Utf8 java/lang/NoClassDefFoundError 
.const [233] = Utf8 initCause 
.const [234] = Utf8 (Ljava/lang/Throwable;)Ljava/lang/Throwable; 
.const [235] = Utf8 de/audi/app/ecall/core/power/PowerEventDispatcher 
.const [236] = Utf8 clampLock 
.const [237] = Utf8 Ljava/lang/Object; 
.const [238] = Utf8 de/audi/app/ecall/core/power/PowerEventDispatcher 
.const [239] = Utf8 logChannel 
.const [240] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [241] = Utf8 de/audi/app/ecall/core/power/PowerEventDispatcher 
.const [242] = Utf8 listeners 
.const [243] = Utf8 Ljava/util/ArrayList; 
.const [244] = Utf8 java/lang/Class 
.const [245] = Utf8 getName 
.const [246] = Utf8 ()Ljava/lang/String; 
.const [247] = Utf8 de/audi/app/ecall/core/power/PowerEventDispatcher 
.const [248] = Utf8 powerEventServiceProvider 
.const [249] = Utf8 Lde/audi/app/ecall/core/osgi/EcallServiceProvider; 
.const [250] = Utf8 de/audi/atip/log/LogChannel 
.const [251] = Utf8 log 
.const [252] = Utf8 (ILjava/lang/String;)Z 
.const [253] = Utf8 de/audi/app/ecall/core/osgi/EcallServiceProvider 
.const [254] = Utf8 startService 
.const [255] = Utf8 ()V 
.const [256] = Utf8 de/audi/app/ecall/core/osgi/EcallServiceProvider 
.const [257] = Utf8 stopService 
.const [258] = Utf8 ()V 
.const [259] = Utf8 java/util/ArrayList 
.const [260] = Utf8 clear 
.const [261] = Utf8 ()V 
.const [262] = Utf8 de/audi/atip/log/LogChannel 
.const [263] = Utf8 log 
.const [264] = Utf8 (ILjava/lang/String;Ljava/lang/Object;)Z 
.const [265] = Utf8 java/util/ArrayList 
.const [266] = Utf8 contains 
.const [267] = Utf8 (Ljava/lang/Object;)Z 
.const [268] = Utf8 java/util/ArrayList 
.const [269] = Utf8 add 
.const [270] = Utf8 (Ljava/lang/Object;)Z 
.const [271] = Utf8 de/audi/app/ecall/core/power/PowerEventDispatcher 
.const [272] = Utf8 clampS 
.const [273] = Utf8 Z 
.const [274] = Utf8 de/audi/app/ecall/core/power/PowerEventDispatcher 
.const [275] = Utf8 clamp15 
.const [276] = Utf8 Z 
.const [277] = Utf8 de/audi/app/ecall/core/power/PowerEventDispatcher 
.const [278] = Utf8 clampX 
.const [279] = Utf8 Z 
.const [280] = Utf8 de/audi/app/ecall/core/power/PowerEventDispatcher 
.const [281] = Utf8 clamp50 
.const [282] = Utf8 Z 
.const [283] = Utf8 java/util/ArrayList 
.const [284] = Utf8 remove 
.const [285] = Utf8 (Ljava/lang/Object;)Z 
.const [286] = Utf8 de/audi/atip/log/LogChannel 
.const [287] = Utf8 log 
.const [288] = Utf8 (ILjava/lang/String;JJ)Z 
.const [289] = Utf8 de/audi/atip/log/LogChannel 
.const [290] = Utf8 isInfo 
.const [291] = Utf8 ()Z 
.const [292] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [293] = Utf8 append 
.const [294] = Utf8 (Ljava/lang/String;)Lde/esolutions/fw/util/commons/Buffer; 
.const [295] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [296] = Utf8 append 
.const [297] = Utf8 (Z)Lde/esolutions/fw/util/commons/Buffer; 
.const [298] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [299] = Utf8 toString 
.const [300] = Utf8 ()Ljava/lang/String; 
.const [301] = Utf8 java/util/ArrayList 
.const [302] = Utf8 clone 
.const [303] = Utf8 ()Ljava/lang/Object; 
.const [304] = Utf8 java/lang/NoClassDefFoundError 
.const [305] = Utf8 <init> 
.const [306] = Utf8 ()V 
.const [307] = Utf8 java/lang/Object 
.const [308] = Utf8 <init> 
.const [309] = Utf8 ()V 
.const [310] = Utf8 java/util/ArrayList 
.const [311] = Utf8 <init> 
.const [312] = Utf8 (I)V 
.const [313] = Utf8 de/audi/app/ecall/core/power/PowerEventDispatcher 
.const [314] = Utf8 class$de$audi$atip$power$PowerEventListener 
.const [315] = Utf8 Ljava/lang/Class; 
.const [316] = Utf8 java/util/Hashtable 
.const [317] = Utf8 <init> 
.const [318] = Utf8 (I)V 
.const [319] = Utf8 de/audi/app/ecall/core/osgi/EcallServiceProvider 
.const [320] = Utf8 <init> 
.const [321] = Utf8 (Ljava/lang/String;Ljava/lang/Object;Ljava/util/Hashtable;Lorg/osgi/framework/BundleContext;Lde/audi/atip/log/LogChannel;)V 
.const [322] = Utf8 de/audi/app/ecall/core/power/PowerEventDispatcher 
.const [323] = Utf8 getListeners 
.const [324] = Utf8 ()Ljava/util/List; 
.const [325] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [326] = Utf8 <init> 
.const [327] = Utf8 (I)V 
.const [328] = Utf8 de/audi/app/ecall/core/power/PowerEventDispatcher 
.const [329] = Utf8 clampLock 
.const [330] = Utf8 Ljava/lang/Object; 
.const [331] = Utf8 de/audi/app/ecall/core/power/PowerEventDispatcher 
.const [332] = Utf8 logChannel 
.const [333] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [334] = Utf8 de/audi/app/ecall/core/power/PowerEventDispatcher 
.const [335] = Utf8 listeners 
.const [336] = Utf8 Ljava/util/ArrayList; 
.const [337] = Utf8 de/audi/app/ecall/core/power/PowerEventDispatcher 
.const [338] = Utf8 powerEventServiceProvider 
.const [339] = Utf8 Lde/audi/app/ecall/core/osgi/EcallServiceProvider; 
.const [340] = Utf8 de/audi/app/ecall/core/power/PowerEventDispatcher 
.const [341] = Utf8 clampS 
.const [342] = Utf8 Z 
.const [343] = Utf8 de/audi/app/ecall/core/power/PowerEventDispatcher 
.const [344] = Utf8 clamp15 
.const [345] = Utf8 Z 
.const [346] = Utf8 de/audi/app/ecall/core/power/PowerEventDispatcher 
.const [347] = Utf8 clampX 
.const [348] = Utf8 Z 
.const [349] = Utf8 de/audi/app/ecall/core/power/PowerEventDispatcher 
.const [350] = Utf8 clamp50 
.const [351] = Utf8 Z 
.const [352] = Utf8 de/audi/app/ecall/core/power/IPowerEventListener 
.const [353] = Utf8 updateClampState 
.const [354] = Utf8 (ZZZZ)V 
.const [355] = Utf8 java/util/List 
.const [356] = Utf8 iterator 
.const [357] = Utf8 ()Ljava/util/Iterator; 
.const [358] = Utf8 java/util/Iterator 
.const [359] = Utf8 hasNext 
.const [360] = Utf8 ()Z 
.const [361] = Utf8 java/util/Iterator 
.const [362] = Utf8 next 
.const [363] = Utf8 ()Ljava/lang/Object; 
.const [364] = Utf8 de/audi/app/ecall/core/power/IPowerEventListener 
.const [365] = Utf8 notifyPowerListenerOnEnterState 
.const [366] = Utf8 (I)V 
.const [367] = Utf8 de/audi/app/ecall/core/power/IPowerEventListener 
.const [368] = Utf8 notifyPowerListenerOnExitState 
.const [369] = Utf8 (I)V 
.const [370] = Utf8 de/audi/app/ecall/core/power/IPowerEventListener 
.const [371] = Utf8 notifyPowerTriggerAction 
.const [372] = Utf8 (I)V 
.const [373] = Utf8 de/audi/app/ecall/core/power/PowerEventDispatcher 
.const [374] = Class [373] 
.const [375] = Utf8 java/lang/Object 
.const [376] = Class [375] 
.const [377] = Utf8 de/audi/app/ecall/core/power/IPowerEventDispatcher 
.const [378] = Class [377] 
.const [379] = Utf8 de/audi/atip/power/PowerEventListener 
.const [380] = Class [379] 
.const [381] = Utf8 logChannel 
.const [382] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [383] = Utf8 listeners 
.const [384] = Utf8 Ljava/util/ArrayList; 
.const [385] = Utf8 powerEventServiceProvider 
.const [386] = Utf8 Lde/audi/app/ecall/core/osgi/EcallServiceProvider; 
.const [387] = Utf8 clampS 
.const [388] = Utf8 Z 
.const [389] = Utf8 clamp15 
.const [390] = Utf8 Z 
.const [391] = Utf8 clampX 
.const [392] = Utf8 Z 
.const [393] = Utf8 clamp50 
.const [394] = Utf8 Z 
.const [395] = Utf8 clampLock 
.const [396] = Utf8 Ljava/lang/Object; 
.const [397] = Utf8 class$de$audi$atip$power$PowerEventListener 
.const [398] = Utf8 Ljava/lang/Class; 
.const [399] = Utf8 Code 
.const [400] = Utf8 <init> 
.const [401] = Utf8 (Lde/audi/atip/log/LogChannel;Lorg/osgi/framework/BundleContext;)V 
.const [402] = Utf8 init 
.const [403] = Utf8 ()V 
.const [404] = Utf8 deinit 
.const [405] = Utf8 ()V 
.const [406] = Utf8 addPowerEventListener 
.const [407] = Utf8 (Lde/audi/app/ecall/core/power/IPowerEventListener;)V 
.const [408] = Utf8 removePowerEventListener 
.const [409] = Utf8 (Lde/audi/app/ecall/core/power/IPowerEventListener;)V 
.const [410] = Utf8 notifyPowerListenerOnEnterState 
.const [411] = Utf8 (II)V 
.const [412] = Utf8 notifyPowerListenerOnExitState 
.const [413] = Utf8 (II)V 
.const [414] = Utf8 notifyPowerTriggerAction 
.const [415] = Utf8 (II)V 
.const [416] = Utf8 updateClampState 
.const [417] = Utf8 (ZZZZ)V 
.const [418] = Utf8 getListeners 
.const [419] = Utf8 ()Ljava/util/List; 
.const [420] = Utf8 class$ 
.const [421] = Utf8 (Ljava/lang/String;)Ljava/lang/Class; 
.end class 
