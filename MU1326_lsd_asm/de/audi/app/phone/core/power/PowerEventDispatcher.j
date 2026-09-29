.version 50 0 
.class public super [345] 
.super [347] 
.implements [349] 
.implements [351] 
.field private final [352] [353] 
.field private final [354] [355] 
.field private final [356] [357] 
.field private [358] [359] 
.field private [360] [361] 
.field private [362] [363] 
.field private [364] [365] 
.field private final [366] [367] 
.field private final [368] [369] 
.field static synthetic [370] [371] 

.method public [373] : [374] 
    .attribute [372] .code stack 8 locals 0 
L0:     aload_0 
L1:     invokespecial [56] 
L4:     aload_0 
L5:     new [72] 
L8:     dup 
L9:     invokespecial [56] 
L12:    putfield [65] 
L15:    aload_0 
L16:    aload_1 
L17:    putfield [70] 
L20:    aload_0 
L21:    new [73] 
L24:    dup 
L25:    bipush 10 
L27:    invokespecial [57] 
L30:    putfield [74] 
L33:    aload_0 
L34:    new [75] 
L37:    dup 
L38:    getstatic [8] 
L41:    ifnonnull L56 
L44:    ldc [9] 
L46:    invokestatic [10] 
L49:    dup 
L50:    putstatic [58] 
L53:    goto L59 
L56:    getstatic [8] 
L59:    invokevirtual [41] 
L62:    aload_0 
L63:    new [76] 
L66:    dup 
L67:    iconst_0 
L68:    invokespecial [59] 
L71:    aload_2 
L72:    aload_1 
L73:    invokespecial [60] 
L76:    putfield [77] 
L79:    aload_0 
L80:    aload_3 
L81:    putfield [78] 
L84:    return 
L85:    nop 
L86:    nop 
L87:    nop 
L88:    
    .end code 
.end method 

.method public [375] : [376] 
    .attribute [372] .code stack 3 locals 0 
L0:     aload_0 
L1:     getfield [38] 
L4:     ldc [12] 
L6:     ldc [13] 
L8:     invokevirtual [44] 
L11:    pop 
L12:    aload_0 
L13:    getfield [42] 
L16:    invokevirtual [45] 
L19:    return 
L20:    
    .end code 
.end method 

.method public [377] : [378] 
    .attribute [372] .code stack 3 locals 2 
L0:     aload_0 
L1:     getfield [38] 
L4:     ldc [12] 
L6:     ldc [14] 
L8:     invokevirtual [44] 
L11:    pop 
L12:    aload_0 
L13:    getfield [42] 
L16:    invokevirtual [46] 
L19:    aload_0 
L20:    getfield [40] 
L23:    dup 
L24:    astore_1 
L25:    monitorenter 
        .catch [0] from L26 to L35 using L38 
L26:    aload_0 
L27:    getfield [40] 
L30:    invokevirtual [47] 
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

.method public [379] : [380] 
    .attribute [372] .code stack 5 locals 8 
L0:     aload_0 
L1:     getfield [38] 
L4:     ldc [12] 
L6:     ldc [15] 
L8:     aload_1 
L9:     invokevirtual [48] 
L12:    pop 
L13:    aload_0 
L14:    getfield [40] 
L17:    dup 
L18:    astore_2 
L19:    monitorenter 
L20:    aload_0 
L21:    getfield [40] 
L24:    aload_1 
L25:    invokevirtual [49] 
L28:    ifeq L46 
L31:    aload_0 
L32:    getfield [38] 
L35:    ldc [16] 
L37:    ldc [17] 
L39:    invokevirtual [44] 
L42:    pop 
L43:    aload_2 
L44:    monitorexit 
L45:    return 
L46:    aload_0 
L47:    getfield [40] 
L50:    aload_1 
L51:    invokevirtual [50] 
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
L67:    getfield [33] 
L70:    dup 
L71:    astore 7 
L73:    monitorenter 
        .catch [0] from L74 to L100 using L103 
L74:    aload_0 
L75:    getfield [34] 
L78:    istore_3 
L79:    aload_0 
L80:    getfield [35] 
L83:    istore 4 
L85:    aload_0 
L86:    getfield [36] 
L89:    istore 5 
L91:    aload_0 
L92:    getfield [37] 
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
L119:   invokeinterface [79] 0 
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

.method public [381] : [382] 
    .attribute [372] .code stack 4 locals 2 
L0:     aload_0 
L1:     getfield [38] 
L4:     ldc [12] 
L6:     ldc [18] 
L8:     aload_1 
L9:     invokevirtual [48] 
L12:    pop 
L13:    aload_0 
L14:    getfield [40] 
L17:    dup 
L18:    astore_2 
L19:    monitorenter 
        .catch [0] from L20 to L57 using L60 
L20:    aload_0 
L21:    getfield [40] 
L24:    aload_1 
L25:    invokevirtual [49] 
L28:    ifeq L43 
L31:    aload_0 
L32:    getfield [40] 
L35:    aload_1 
L36:    invokevirtual [51] 
L39:    pop 
L40:    goto L55 
L43:    aload_0 
L44:    getfield [38] 
L47:    ldc [16] 
L49:    ldc [19] 
L51:    invokevirtual [44] 
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

.method public [383] : [384] 
    .attribute [372] .code stack 7 locals 0 
L0:     aload_0 
L1:     getfield [43] 
L4:     new [80] 
L7:     dup 
L8:     aload_0 
L9:     ldc [21] 
L11:    iload_1 
L12:    iload_2 
L13:    invokespecial [61] 
L16:    invokevirtual [52] 
L19:    return 
L20:    
    .end code 
.end method 

.method public [385] : [386] 
    .attribute [372] .code stack 7 locals 0 
L0:     aload_0 
L1:     getfield [43] 
L4:     new [81] 
L7:     dup 
L8:     aload_0 
L9:     ldc [23] 
L11:    iload_1 
L12:    iload_2 
L13:    invokespecial [62] 
L16:    invokevirtual [52] 
L19:    return 
L20:    
    .end code 
.end method 

.method public [387] : [388] 
    .attribute [372] .code stack 7 locals 0 
L0:     aload_0 
L1:     getfield [43] 
L4:     new [82] 
L7:     dup 
L8:     aload_0 
L9:     ldc [25] 
L11:    iload_1 
L12:    iload_2 
L13:    invokespecial [63] 
L16:    invokevirtual [52] 
L19:    return 
L20:    
    .end code 
.end method 

.method public [389] : [390] 
    .attribute [372] .code stack 9 locals 0 
L0:     aload_0 
L1:     getfield [43] 
L4:     new [83] 
L7:     dup 
L8:     aload_0 
L9:     ldc [27] 
L11:    iload_1 
L12:    iload_2 
L13:    iload_3 
L14:    iload 4 
L16:    invokespecial [64] 
L19:    invokevirtual [52] 
L22:    return 
L23:    nop 
L24:    
    .end code 
.end method 

.method private [391] : [392] 
    .attribute [372] .code stack 2 locals 3 
L0:     aload_0 
L1:     getfield [40] 
L4:     dup 
L5:     astore_2 
L6:     monitorenter 
        .catch [0] from L7 to L20 using L23 
L7:     aload_0 
L8:     getfield [40] 
L11:    invokevirtual [53] 
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

.method static synthetic [393] : [394] 
    .attribute [372] .code stack 2 locals 1 
        .catch [3] from L0 to L4 using L5 
L0:     aload_0 
L1:     invokestatic [2] 
L4:     areturn 
L5:     astore_1 
L6:     new [71] 
L9:     dup 
L10:    invokespecial [55] 
L13:    aload_1 
L14:    invokevirtual [39] 
L17:    athrow 
L18:    nop 
L19:    nop 
L20:    
    .end code 
.end method 

.method static synthetic [395] : [396] 
    .attribute [372] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [38] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method static synthetic [397] : [398] 
    .attribute [372] .code stack 1 locals 0 
L0:     aload_0 
L1:     invokespecial [54] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method static synthetic [399] : [400] 
    .attribute [372] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [37] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method static synthetic [401] : [402] 
    .attribute [372] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [36] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method static synthetic [403] : [404] 
    .attribute [372] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [35] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method static synthetic [405] : [406] 
    .attribute [372] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [34] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method static synthetic [407] : [408] 
    .attribute [372] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [33] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method static synthetic [409] : [410] 
    .attribute [372] .code stack 3 locals 0 
L0:     aload_0 
L1:     iload_1 
L2:     dup_x1 
L3:     putfield [66] 
L6:     areturn 
L7:     nop 
L8:     
    .end code 
.end method 

.method static synthetic [411] : [412] 
    .attribute [372] .code stack 3 locals 0 
L0:     aload_0 
L1:     iload_1 
L2:     dup_x1 
L3:     putfield [67] 
L6:     areturn 
L7:     nop 
L8:     
    .end code 
.end method 

.method static synthetic [413] : [414] 
    .attribute [372] .code stack 3 locals 0 
L0:     aload_0 
L1:     iload_1 
L2:     dup_x1 
L3:     putfield [68] 
L6:     areturn 
L7:     nop 
L8:     
    .end code 
.end method 

.method static synthetic [415] : [416] 
    .attribute [372] .code stack 3 locals 0 
L0:     aload_0 
L1:     iload_1 
L2:     dup_x1 
L3:     putfield [69] 
L6:     areturn 
L7:     nop 
L8:     
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Method [84] [85] 
.const [3] = Class [86] 
.const [4] = Class [87] 
.const [5] = Class [88] 
.const [6] = Class [89] 
.const [7] = Class [90] 
.const [8] = Field [91] [92] 
.const [9] = String [93] 
.const [10] = Method [94] [95] 
.const [11] = Class [96] 
.const [12] = Int -2137614336 
.const [13] = String [97] 
.const [14] = String [98] 
.const [15] = String [99] 
.const [16] = Int -1601830656 
.const [17] = String [100] 
.const [18] = String [101] 
.const [19] = String [102] 
.const [20] = Class [103] 
.const [21] = String [104] 
.const [22] = Class [105] 
.const [23] = String [106] 
.const [24] = Class [107] 
.const [25] = String [108] 
.const [26] = Class [109] 
.const [27] = String [110] 
.const [28] = Class [111] 
.const [29] = Class [112] 
.const [30] = Class [113] 
.const [31] = Class [114] 
.const [32] = Class [115] 
.const [33] = Field [116] [117] 
.const [34] = Field [118] [119] 
.const [35] = Field [120] [121] 
.const [36] = Field [122] [123] 
.const [37] = Field [124] [125] 
.const [38] = Field [126] [127] 
.const [39] = Method [128] [129] 
.const [40] = Field [130] [131] 
.const [41] = Method [132] [133] 
.const [42] = Field [134] [135] 
.const [43] = Field [136] [137] 
.const [44] = Method [138] [139] 
.const [45] = Method [140] [141] 
.const [46] = Method [142] [143] 
.const [47] = Method [144] [145] 
.const [48] = Method [146] [147] 
.const [49] = Method [148] [149] 
.const [50] = Method [150] [151] 
.const [51] = Method [152] [153] 
.const [52] = Method [154] [155] 
.const [53] = Method [156] [157] 
.const [54] = Method [158] [159] 
.const [55] = Method [160] [161] 
.const [56] = Method [162] [163] 
.const [57] = Method [164] [165] 
.const [58] = Field [166] [167] 
.const [59] = Method [168] [169] 
.const [60] = Method [170] [171] 
.const [61] = Method [172] [173] 
.const [62] = Method [174] [175] 
.const [63] = Method [176] [177] 
.const [64] = Method [178] [179] 
.const [65] = Field [180] [181] 
.const [66] = Field [182] [183] 
.const [67] = Field [184] [185] 
.const [68] = Field [186] [187] 
.const [69] = Field [188] [189] 
.const [70] = Field [190] [191] 
.const [71] = Class [192] 
.const [72] = Class [193] 
.const [73] = Class [194] 
.const [74] = Field [195] [196] 
.const [75] = Class [197] 
.const [76] = Class [198] 
.const [77] = Field [199] [200] 
.const [78] = Field [201] [202] 
.const [79] = InterfaceMethod [203] [204] 
.const [80] = Class [205] 
.const [81] = Class [206] 
.const [82] = Class [207] 
.const [83] = Class [208] 
.const [84] = Class [209] 
.const [85] = NameAndType [210] [211] 
.const [86] = Utf8 java/lang/ClassNotFoundException 
.const [87] = Utf8 java/lang/NoClassDefFoundError 
.const [88] = Utf8 java/lang/Object 
.const [89] = Utf8 java/util/ArrayList 
.const [90] = Utf8 de/audi/app/phone/core/PhoneServiceProvider 
.const [91] = Class [212] 
.const [92] = NameAndType [213] [214] 
.const [93] = Utf8 'de.audi.atip.power.PowerEventListener' 
.const [94] = Class [215] 
.const [95] = NameAndType [216] [217] 
.const [96] = Utf8 java/util/Hashtable 
.const [97] = Utf8 '[PowerEventDispatcher#init] called' 
.const [98] = Utf8 '[PowerEventDispatcher#deinit] called' 
.const [99] = Utf8 "[PowerEventDispatcher#addPowerEventListener] listener='%1'" 
.const [100] = Utf8 '[PowerEventDispatcher#addPowerEventListener] listener already registered' 
.const [101] = Utf8 "[PowerEventDispatcher#removePowerEventListener] listener='%1'" 
.const [102] = Utf8 '[PowerEventDispatcher#removePowerEventListener] listener not registered, cannot be removed' 
.const [103] = Utf8 de/audi/app/phone/core/power/PowerEventDispatcher$1 
.const [104] = Utf8 notifyPowerListenerOnEnterState 
.const [105] = Utf8 de/audi/app/phone/core/power/PowerEventDispatcher$2 
.const [106] = Utf8 notifyPowerListenerOnExitState 
.const [107] = Utf8 de/audi/app/phone/core/power/PowerEventDispatcher$3 
.const [108] = Utf8 notifyPowerTriggerAction 
.const [109] = Utf8 de/audi/app/phone/core/power/PowerEventDispatcher$4 
.const [110] = Utf8 updateClampState 
.const [111] = Utf8 de/audi/app/phone/core/power/PowerEventDispatcher 
.const [112] = Utf8 java/lang/Class 
.const [113] = Utf8 de/audi/atip/log/LogChannel 
.const [114] = Utf8 de/audi/app/phone/core/power/IPowerEventListener 
.const [115] = Utf8 de/audi/app/phone/core/event/TelEventQueue 
.const [116] = Class [218] 
.const [117] = NameAndType [219] [220] 
.const [118] = Class [221] 
.const [119] = NameAndType [222] [223] 
.const [120] = Class [224] 
.const [121] = NameAndType [225] [226] 
.const [122] = Class [227] 
.const [123] = NameAndType [228] [229] 
.const [124] = Class [230] 
.const [125] = NameAndType [231] [232] 
.const [126] = Class [233] 
.const [127] = NameAndType [234] [235] 
.const [128] = Class [236] 
.const [129] = NameAndType [237] [238] 
.const [130] = Class [239] 
.const [131] = NameAndType [240] [241] 
.const [132] = Class [242] 
.const [133] = NameAndType [243] [244] 
.const [134] = Class [245] 
.const [135] = NameAndType [246] [247] 
.const [136] = Class [248] 
.const [137] = NameAndType [249] [250] 
.const [138] = Class [251] 
.const [139] = NameAndType [252] [253] 
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
.const [164] = Class [290] 
.const [165] = NameAndType [291] [292] 
.const [166] = Class [293] 
.const [167] = NameAndType [294] [295] 
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
.const [192] = Utf8 java/lang/NoClassDefFoundError 
.const [193] = Utf8 java/lang/Object 
.const [194] = Utf8 java/util/ArrayList 
.const [195] = Class [332] 
.const [196] = NameAndType [333] [334] 
.const [197] = Utf8 de/audi/app/phone/core/PhoneServiceProvider 
.const [198] = Utf8 java/util/Hashtable 
.const [199] = Class [335] 
.const [200] = NameAndType [336] [337] 
.const [201] = Class [338] 
.const [202] = NameAndType [339] [340] 
.const [203] = Class [341] 
.const [204] = NameAndType [342] [343] 
.const [205] = Utf8 de/audi/app/phone/core/power/PowerEventDispatcher$1 
.const [206] = Utf8 de/audi/app/phone/core/power/PowerEventDispatcher$2 
.const [207] = Utf8 de/audi/app/phone/core/power/PowerEventDispatcher$3 
.const [208] = Utf8 de/audi/app/phone/core/power/PowerEventDispatcher$4 
.const [209] = Utf8 java/lang/Class 
.const [210] = Utf8 forName 
.const [211] = Utf8 (Ljava/lang/String;)Ljava/lang/Class; 
.const [212] = Utf8 de/audi/app/phone/core/power/PowerEventDispatcher 
.const [213] = Utf8 class$de$audi$atip$power$PowerEventListener 
.const [214] = Utf8 Ljava/lang/Class; 
.const [215] = Utf8 de/audi/app/phone/core/power/PowerEventDispatcher 
.const [216] = Utf8 class$ 
.const [217] = Utf8 (Ljava/lang/String;)Ljava/lang/Class; 
.const [218] = Utf8 de/audi/app/phone/core/power/PowerEventDispatcher 
.const [219] = Utf8 clampLock 
.const [220] = Utf8 Ljava/lang/Object; 
.const [221] = Utf8 de/audi/app/phone/core/power/PowerEventDispatcher 
.const [222] = Utf8 clampS 
.const [223] = Utf8 Z 
.const [224] = Utf8 de/audi/app/phone/core/power/PowerEventDispatcher 
.const [225] = Utf8 clamp15 
.const [226] = Utf8 Z 
.const [227] = Utf8 de/audi/app/phone/core/power/PowerEventDispatcher 
.const [228] = Utf8 clampX 
.const [229] = Utf8 Z 
.const [230] = Utf8 de/audi/app/phone/core/power/PowerEventDispatcher 
.const [231] = Utf8 clamp50 
.const [232] = Utf8 Z 
.const [233] = Utf8 de/audi/app/phone/core/power/PowerEventDispatcher 
.const [234] = Utf8 logChannel 
.const [235] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [236] = Utf8 java/lang/NoClassDefFoundError 
.const [237] = Utf8 initCause 
.const [238] = Utf8 (Ljava/lang/Throwable;)Ljava/lang/Throwable; 
.const [239] = Utf8 de/audi/app/phone/core/power/PowerEventDispatcher 
.const [240] = Utf8 listeners 
.const [241] = Utf8 Ljava/util/ArrayList; 
.const [242] = Utf8 java/lang/Class 
.const [243] = Utf8 getName 
.const [244] = Utf8 ()Ljava/lang/String; 
.const [245] = Utf8 de/audi/app/phone/core/power/PowerEventDispatcher 
.const [246] = Utf8 powerEventServiceProvider 
.const [247] = Utf8 Lde/audi/app/phone/core/PhoneServiceProvider; 
.const [248] = Utf8 de/audi/app/phone/core/power/PowerEventDispatcher 
.const [249] = Utf8 eventQueue 
.const [250] = Utf8 Lde/audi/app/phone/core/event/TelEventQueue; 
.const [251] = Utf8 de/audi/atip/log/LogChannel 
.const [252] = Utf8 log 
.const [253] = Utf8 (ILjava/lang/String;)Z 
.const [254] = Utf8 de/audi/app/phone/core/PhoneServiceProvider 
.const [255] = Utf8 startService 
.const [256] = Utf8 ()V 
.const [257] = Utf8 de/audi/app/phone/core/PhoneServiceProvider 
.const [258] = Utf8 stopService 
.const [259] = Utf8 ()V 
.const [260] = Utf8 java/util/ArrayList 
.const [261] = Utf8 clear 
.const [262] = Utf8 ()V 
.const [263] = Utf8 de/audi/atip/log/LogChannel 
.const [264] = Utf8 log 
.const [265] = Utf8 (ILjava/lang/String;Ljava/lang/Object;)Z 
.const [266] = Utf8 java/util/ArrayList 
.const [267] = Utf8 contains 
.const [268] = Utf8 (Ljava/lang/Object;)Z 
.const [269] = Utf8 java/util/ArrayList 
.const [270] = Utf8 add 
.const [271] = Utf8 (Ljava/lang/Object;)Z 
.const [272] = Utf8 java/util/ArrayList 
.const [273] = Utf8 remove 
.const [274] = Utf8 (Ljava/lang/Object;)Z 
.const [275] = Utf8 de/audi/app/phone/core/event/TelEventQueue 
.const [276] = Utf8 enqueue 
.const [277] = Utf8 (Lde/audi/app/phone/core/event/AbstractTelEvent;)V 
.const [278] = Utf8 java/util/ArrayList 
.const [279] = Utf8 clone 
.const [280] = Utf8 ()Ljava/lang/Object; 
.const [281] = Utf8 de/audi/app/phone/core/power/PowerEventDispatcher 
.const [282] = Utf8 getListeners 
.const [283] = Utf8 ()Ljava/util/List; 
.const [284] = Utf8 java/lang/NoClassDefFoundError 
.const [285] = Utf8 <init> 
.const [286] = Utf8 ()V 
.const [287] = Utf8 java/lang/Object 
.const [288] = Utf8 <init> 
.const [289] = Utf8 ()V 
.const [290] = Utf8 java/util/ArrayList 
.const [291] = Utf8 <init> 
.const [292] = Utf8 (I)V 
.const [293] = Utf8 de/audi/app/phone/core/power/PowerEventDispatcher 
.const [294] = Utf8 class$de$audi$atip$power$PowerEventListener 
.const [295] = Utf8 Ljava/lang/Class; 
.const [296] = Utf8 java/util/Hashtable 
.const [297] = Utf8 <init> 
.const [298] = Utf8 (I)V 
.const [299] = Utf8 de/audi/app/phone/core/PhoneServiceProvider 
.const [300] = Utf8 <init> 
.const [301] = Utf8 (Ljava/lang/String;Ljava/lang/Object;Ljava/util/Hashtable;Lorg/osgi/framework/BundleContext;Lde/audi/atip/log/LogChannel;)V 
.const [302] = Utf8 de/audi/app/phone/core/power/PowerEventDispatcher$1 
.const [303] = Utf8 <init> 
.const [304] = Utf8 (Lde/audi/app/phone/core/power/PowerEventDispatcher;Ljava/lang/String;II)V 
.const [305] = Utf8 de/audi/app/phone/core/power/PowerEventDispatcher$2 
.const [306] = Utf8 <init> 
.const [307] = Utf8 (Lde/audi/app/phone/core/power/PowerEventDispatcher;Ljava/lang/String;II)V 
.const [308] = Utf8 de/audi/app/phone/core/power/PowerEventDispatcher$3 
.const [309] = Utf8 <init> 
.const [310] = Utf8 (Lde/audi/app/phone/core/power/PowerEventDispatcher;Ljava/lang/String;II)V 
.const [311] = Utf8 de/audi/app/phone/core/power/PowerEventDispatcher$4 
.const [312] = Utf8 <init> 
.const [313] = Utf8 (Lde/audi/app/phone/core/power/PowerEventDispatcher;Ljava/lang/String;ZZZZ)V 
.const [314] = Utf8 de/audi/app/phone/core/power/PowerEventDispatcher 
.const [315] = Utf8 clampLock 
.const [316] = Utf8 Ljava/lang/Object; 
.const [317] = Utf8 de/audi/app/phone/core/power/PowerEventDispatcher 
.const [318] = Utf8 clampS 
.const [319] = Utf8 Z 
.const [320] = Utf8 de/audi/app/phone/core/power/PowerEventDispatcher 
.const [321] = Utf8 clamp15 
.const [322] = Utf8 Z 
.const [323] = Utf8 de/audi/app/phone/core/power/PowerEventDispatcher 
.const [324] = Utf8 clampX 
.const [325] = Utf8 Z 
.const [326] = Utf8 de/audi/app/phone/core/power/PowerEventDispatcher 
.const [327] = Utf8 clamp50 
.const [328] = Utf8 Z 
.const [329] = Utf8 de/audi/app/phone/core/power/PowerEventDispatcher 
.const [330] = Utf8 logChannel 
.const [331] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [332] = Utf8 de/audi/app/phone/core/power/PowerEventDispatcher 
.const [333] = Utf8 listeners 
.const [334] = Utf8 Ljava/util/ArrayList; 
.const [335] = Utf8 de/audi/app/phone/core/power/PowerEventDispatcher 
.const [336] = Utf8 powerEventServiceProvider 
.const [337] = Utf8 Lde/audi/app/phone/core/PhoneServiceProvider; 
.const [338] = Utf8 de/audi/app/phone/core/power/PowerEventDispatcher 
.const [339] = Utf8 eventQueue 
.const [340] = Utf8 Lde/audi/app/phone/core/event/TelEventQueue; 
.const [341] = Utf8 de/audi/app/phone/core/power/IPowerEventListener 
.const [342] = Utf8 updateClampState 
.const [343] = Utf8 (ZZZZ)V 
.const [344] = Utf8 de/audi/app/phone/core/power/PowerEventDispatcher 
.const [345] = Class [344] 
.const [346] = Utf8 java/lang/Object 
.const [347] = Class [346] 
.const [348] = Utf8 de/audi/app/phone/core/power/IPowerEventDispatcher 
.const [349] = Class [348] 
.const [350] = Utf8 de/audi/atip/power/PowerEventListener 
.const [351] = Class [350] 
.const [352] = Utf8 logChannel 
.const [353] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [354] = Utf8 listeners 
.const [355] = Utf8 Ljava/util/ArrayList; 
.const [356] = Utf8 powerEventServiceProvider 
.const [357] = Utf8 Lde/audi/app/phone/core/PhoneServiceProvider; 
.const [358] = Utf8 clampS 
.const [359] = Utf8 Z 
.const [360] = Utf8 clamp15 
.const [361] = Utf8 Z 
.const [362] = Utf8 clampX 
.const [363] = Utf8 Z 
.const [364] = Utf8 clamp50 
.const [365] = Utf8 Z 
.const [366] = Utf8 clampLock 
.const [367] = Utf8 Ljava/lang/Object; 
.const [368] = Utf8 eventQueue 
.const [369] = Utf8 Lde/audi/app/phone/core/event/TelEventQueue; 
.const [370] = Utf8 class$de$audi$atip$power$PowerEventListener 
.const [371] = Utf8 Ljava/lang/Class; 
.const [372] = Utf8 Code 
.const [373] = Utf8 <init> 
.const [374] = Utf8 (Lde/audi/atip/log/LogChannel;Lorg/osgi/framework/BundleContext;Lde/audi/app/phone/core/event/TelEventQueue;)V 
.const [375] = Utf8 init 
.const [376] = Utf8 ()V 
.const [377] = Utf8 deinit 
.const [378] = Utf8 ()V 
.const [379] = Utf8 addPowerEventListener 
.const [380] = Utf8 (Lde/audi/app/phone/core/power/IPowerEventListener;)V 
.const [381] = Utf8 removePowerEventListener 
.const [382] = Utf8 (Lde/audi/app/phone/core/power/IPowerEventListener;)V 
.const [383] = Utf8 notifyPowerListenerOnEnterState 
.const [384] = Utf8 (II)V 
.const [385] = Utf8 notifyPowerListenerOnExitState 
.const [386] = Utf8 (II)V 
.const [387] = Utf8 notifyPowerTriggerAction 
.const [388] = Utf8 (II)V 
.const [389] = Utf8 updateClampState 
.const [390] = Utf8 (ZZZZ)V 
.const [391] = Utf8 getListeners 
.const [392] = Utf8 ()Ljava/util/List; 
.const [393] = Utf8 class$ 
.const [394] = Utf8 (Ljava/lang/String;)Ljava/lang/Class; 
.const [395] = Utf8 access$000 
.const [396] = Utf8 (Lde/audi/app/phone/core/power/PowerEventDispatcher;)Lde/audi/atip/log/LogChannel; 
.const [397] = Utf8 access$100 
.const [398] = Utf8 (Lde/audi/app/phone/core/power/PowerEventDispatcher;)Ljava/util/List; 
.const [399] = Utf8 access$200 
.const [400] = Utf8 (Lde/audi/app/phone/core/power/PowerEventDispatcher;)Z 
.const [401] = Utf8 access$300 
.const [402] = Utf8 (Lde/audi/app/phone/core/power/PowerEventDispatcher;)Z 
.const [403] = Utf8 access$400 
.const [404] = Utf8 (Lde/audi/app/phone/core/power/PowerEventDispatcher;)Z 
.const [405] = Utf8 access$500 
.const [406] = Utf8 (Lde/audi/app/phone/core/power/PowerEventDispatcher;)Z 
.const [407] = Utf8 access$600 
.const [408] = Utf8 (Lde/audi/app/phone/core/power/PowerEventDispatcher;)Ljava/lang/Object; 
.const [409] = Utf8 access$502 
.const [410] = Utf8 (Lde/audi/app/phone/core/power/PowerEventDispatcher;Z)Z 
.const [411] = Utf8 access$402 
.const [412] = Utf8 (Lde/audi/app/phone/core/power/PowerEventDispatcher;Z)Z 
.const [413] = Utf8 access$302 
.const [414] = Utf8 (Lde/audi/app/phone/core/power/PowerEventDispatcher;Z)Z 
.const [415] = Utf8 access$202 
.const [416] = Utf8 (Lde/audi/app/phone/core/power/PowerEventDispatcher;Z)Z 
.end class 
