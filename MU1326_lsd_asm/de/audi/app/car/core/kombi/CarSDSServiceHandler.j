.version 50 0 
.class public super [351] 
.super [353] 
.implements [355] 
.field private final [356] [357] 
.field private final [358] [359] 
.field private final [360] [361] 
.field private final [362] [363] 
.field private volatile [364] [365] 
.field private volatile [366] [367] 
.field private volatile [368] [369] 
.field private volatile [370] [371] 
.field private final [372] [373] 
.field static synthetic [374] [375] 

.method public [377] : [378] 
    .attribute [376] .code stack 8 locals 0 
L0:     aload_0 
L1:     invokespecial [57] 
L4:     aload_0 
L5:     new [69] 
L8:     dup 
L9:     invokespecial [57] 
L12:    putfield [67] 
L15:    aload_0 
L16:    iconst_1 
L17:    putfield [66] 
L20:    aload_0 
L21:    iconst_0 
L22:    putfield [65] 
L25:    aload_0 
L26:    iconst_0 
L27:    putfield [64] 
L30:    aload_0 
L31:    iconst_0 
L32:    putfield [63] 
L35:    aload_0 
L36:    new [70] 
L39:    dup 
L40:    iconst_1 
L41:    invokespecial [58] 
L44:    putfield [71] 
L47:    aload_0 
L48:    aload_1 
L49:    putfield [72] 
L52:    aload_0 
L53:    aload_2 
L54:    putfield [62] 
L57:    aload_0 
L58:    new [73] 
L61:    dup 
L62:    getstatic [8] 
L65:    ifnonnull L80 
L68:    ldc [9] 
L70:    invokestatic [10] 
L73:    dup 
L74:    putstatic [59] 
L77:    goto L83 
L80:    getstatic [8] 
L83:    invokevirtual [38] 
L86:    aload_0 
L87:    aconst_null 
L88:    aload_1 
L89:    invokeinterface [74] 0 
L94:    aload_2 
L95:    invokespecial [60] 
L98:    putfield [75] 
L101:   return 
L102:   nop 
L103:   nop 
L104:   
    .end code 
.end method 

.method protected [379] : [380] 
    .attribute [376] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [39] 
L4:     invokevirtual [40] 
L7:     return 
L8:     
    .end code 
.end method 

.method protected [381] : [382] 
    .attribute [376] .code stack 2 locals 2 
L0:     aload_0 
L1:     getfield [39] 
L4:     invokevirtual [41] 
L7:     aload_0 
L8:     getfield [34] 
L11:    dup 
L12:    astore_1 
L13:    monitorenter 
        .catch [0] from L14 to L23 using L26 
L14:    aload_0 
L15:    getfield [36] 
L18:    invokevirtual [42] 
L21:    aload_1 
L22:    monitorexit 
L23:    goto L31 
        .catch [0] from L26 to L29 using L26 
L26:    astore_2 
L27:    aload_1 
L28:    monitorexit 
L29:    aload_2 
L30:    athrow 
L31:    return 
L32:    
    .end code 
.end method 

.method protected [383] : [384] 
    .attribute [376] .code stack 5 locals 0 
L0:     aload_0 
L1:     getfield [29] 
L4:     ldc [11] 
L6:     ldc [12] 
L8:     iload_1 
L9:     i2l 
L10:    invokevirtual [43] 
L13:    pop 
L14:    aload_0 
L15:    iload_1 
L16:    putfield [66] 
L19:    aload_0 
L20:    aload_0 
L21:    getfield [32] 
L24:    aload_0 
L25:    getfield [31] 
L28:    aload_0 
L29:    getfield [30] 
L32:    invokevirtual [44] 
L35:    return 
L36:    
    .end code 
.end method 

.method protected [385] : [386] 
    .attribute [376] .code stack 8 locals 5 
L0:     aload_0 
L1:     getfield [29] 
L4:     invokevirtual [45] 
L7:     ifeq L30 
L10:    aload_0 
L11:    getfield [29] 
L14:    ldc [11] 
L16:    ldc [13] 
L18:    iload_1 
L19:    invokestatic [14] 
L22:    iload_2 
L23:    i2l 
L24:    iload_3 
L25:    i2l 
L26:    invokevirtual [46] 
L29:    pop 
L30:    aload_0 
L31:    getfield [34] 
L34:    dup 
L35:    astore 4 
L37:    monitorenter 
L38:    aload_0 
L39:    iload_1 
L40:    putfield [65] 
L43:    aload_0 
L44:    iload_2 
L45:    putfield [64] 
L48:    aload_0 
L49:    iload_3 
L50:    putfield [63] 
L53:    iconst_0 
L54:    istore 5 
L56:    iload 5 
L58:    aload_0 
L59:    getfield [36] 
L62:    invokevirtual [47] 
L65:    if_icmpge L135 
L68:    aload_0 
L69:    getfield [36] 
L72:    iload 5 
L74:    invokevirtual [48] 
L77:    checkcast [15] 
L80:    astore 6 
        .catch [16] from L82 to L109 using L112 
        .catch [0] from L38 to L138 using L141 
L82:    aload 6 
L84:    aload_0 
L85:    aload_0 
L86:    getfield [33] 
L89:    aload_0 
L90:    getfield [32] 
L93:    invokespecial [55] 
L96:    aload_0 
L97:    getfield [31] 
L100:   aload_0 
L101:   getfield [30] 
L104:   invokeinterface [76] 0 
L109:   goto L129 
L112:   astore 7 
L114:   aload_0 
L115:   getfield [29] 
L118:   sipush 1000 
L121:   ldc [17] 
L123:   aload 7 
L125:   invokevirtual [49] 
L128:   pop 
L129:   iinc 5 1 
L132:   goto L56 
L135:   aload 4 
L137:   monitorexit 
L138:   goto L149 
        .catch [0] from L141 to L146 using L141 
L141:   astore 8 
L143:   aload 4 
L145:   monitorexit 
L146:   aload 8 
L148:   athrow 
L149:   return 
L150:   nop 
L151:   nop 
L152:   
    .end code 
.end method 

.method public [387] : [388] 
    .attribute [376] .code stack 5 locals 2 
L0:     aload_0 
L1:     getfield [29] 
L4:     ldc [11] 
L6:     ldc [18] 
L8:     invokevirtual [50] 
L11:    pop 
L12:    aload_0 
L13:    getfield [34] 
L16:    dup 
L17:    astore_2 
L18:    monitorenter 
        .catch [0] from L19 to L78 using L81 
L19:    aload_0 
L20:    getfield [36] 
L23:    aload_1 
L24:    invokevirtual [51] 
L27:    ifne L64 
L30:    aload_0 
L31:    getfield [36] 
L34:    aload_1 
L35:    invokevirtual [52] 
L38:    pop 
L39:    aload_0 
L40:    getfield [37] 
L43:    invokeinterface [77] 0 
L48:    new [78] 
L51:    dup 
L52:    aload_0 
L53:    aload_1 
L54:    invokespecial [61] 
L57:    invokevirtual [53] 
L60:    pop 
L61:    goto L76 
L64:    aload_0 
L65:    getfield [29] 
L68:    ldc [20] 
L70:    ldc [21] 
L72:    invokevirtual [50] 
L75:    pop 
L76:    aload_2 
L77:    monitorexit 
L78:    goto L86 
        .catch [0] from L81 to L84 using L81 
L81:    astore_3 
L82:    aload_2 
L83:    monitorexit 
L84:    aload_3 
L85:    athrow 
L86:    return 
L87:    nop 
L88:    
    .end code 
.end method 

.method public [389] : [390] 
    .attribute [376] .code stack 3 locals 2 
L0:     aload_0 
L1:     getfield [29] 
L4:     ldc [11] 
L6:     ldc [22] 
L8:     invokevirtual [50] 
L11:    pop 
L12:    aload_0 
L13:    getfield [34] 
L16:    dup 
L17:    astore_2 
L18:    monitorenter 
        .catch [0] from L19 to L30 using L33 
L19:    aload_0 
L20:    getfield [36] 
L23:    aload_1 
L24:    invokevirtual [54] 
L27:    pop 
L28:    aload_2 
L29:    monitorexit 
L30:    goto L38 
        .catch [0] from L33 to L36 using L33 
L33:    astore_3 
L34:    aload_2 
L35:    monitorexit 
L36:    aload_3 
L37:    athrow 
L38:    return 
L39:    nop 
L40:    
    .end code 
.end method 

.method private [391] : [392] 
    .attribute [376] .code stack 1 locals 0 
L0:     iload_1 
L1:     lookupswitch 
            0 : L30 
            1 : L28 
            default : L40 

L28:    iconst_0 
L29:    areturn 
L30:    iload_2 
L31:    ifeq L38 
L34:    iconst_2 
L35:    goto L39 
L38:    iconst_1 
L39:    areturn 
L40:    iconst_1 
L41:    areturn 
L42:    nop 
L43:    nop 
L44:    
    .end code 
.end method 

.method static synthetic [393] : [394] 
    .attribute [376] .code stack 2 locals 1 
        .catch [3] from L0 to L4 using L5 
L0:     aload_0 
L1:     invokestatic [2] 
L4:     areturn 
L5:     astore_1 
L6:     new [68] 
L9:     dup 
L10:    invokespecial [56] 
L13:    aload_1 
L14:    invokevirtual [35] 
L17:    athrow 
L18:    nop 
L19:    nop 
L20:    
    .end code 
.end method 

.method static synthetic [395] : [396] 
    .attribute [376] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [34] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method static synthetic [397] : [398] 
    .attribute [376] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [33] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method static synthetic [399] : [400] 
    .attribute [376] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [32] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method static synthetic [401] : [402] 
    .attribute [376] .code stack 3 locals 0 
L0:     aload_0 
L1:     iload_1 
L2:     iload_2 
L3:     invokespecial [55] 
L6:     areturn 
L7:     nop 
L8:     
    .end code 
.end method 

.method static synthetic [403] : [404] 
    .attribute [376] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [31] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method static synthetic [405] : [406] 
    .attribute [376] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [30] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method static synthetic [407] : [408] 
    .attribute [376] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [29] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Method [79] [80] 
.const [3] = Class [81] 
.const [4] = Class [82] 
.const [5] = Class [83] 
.const [6] = Class [84] 
.const [7] = Class [85] 
.const [8] = Field [86] [87] 
.const [9] = String [88] 
.const [10] = Method [89] [90] 
.const [11] = Int 1078071040 
.const [12] = String [91] 
.const [13] = String [92] 
.const [14] = Method [93] [94] 
.const [15] = Class [95] 
.const [16] = Class [96] 
.const [17] = String [97] 
.const [18] = String [98] 
.const [19] = Class [99] 
.const [20] = Int -1601830656 
.const [21] = String [100] 
.const [22] = String [101] 
.const [23] = Class [102] 
.const [24] = Class [103] 
.const [25] = Class [104] 
.const [26] = Class [105] 
.const [27] = Class [106] 
.const [28] = Class [107] 
.const [29] = Field [108] [109] 
.const [30] = Field [110] [111] 
.const [31] = Field [112] [113] 
.const [32] = Field [114] [115] 
.const [33] = Field [116] [117] 
.const [34] = Field [118] [119] 
.const [35] = Method [120] [121] 
.const [36] = Field [122] [123] 
.const [37] = Field [124] [125] 
.const [38] = Method [126] [127] 
.const [39] = Field [128] [129] 
.const [40] = Method [130] [131] 
.const [41] = Method [132] [133] 
.const [42] = Method [134] [135] 
.const [43] = Method [136] [137] 
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
.const [58] = Method [166] [167] 
.const [59] = Field [168] [169] 
.const [60] = Method [170] [171] 
.const [61] = Method [172] [173] 
.const [62] = Field [174] [175] 
.const [63] = Field [176] [177] 
.const [64] = Field [178] [179] 
.const [65] = Field [180] [181] 
.const [66] = Field [182] [183] 
.const [67] = Field [184] [185] 
.const [68] = Class [186] 
.const [69] = Class [187] 
.const [70] = Class [188] 
.const [71] = Field [189] [190] 
.const [72] = Field [191] [192] 
.const [73] = Class [193] 
.const [74] = InterfaceMethod [194] [195] 
.const [75] = Field [196] [197] 
.const [76] = InterfaceMethod [198] [199] 
.const [77] = InterfaceMethod [200] [201] 
.const [78] = Class [202] 
.const [79] = Class [203] 
.const [80] = NameAndType [204] [205] 
.const [81] = Utf8 java/lang/ClassNotFoundException 
.const [82] = Utf8 java/lang/NoClassDefFoundError 
.const [83] = Utf8 java/lang/Object 
.const [84] = Utf8 java/util/ArrayList 
.const [85] = Utf8 de/audi/app/car/common/service/CarServiceProvider 
.const [86] = Class [206] 
.const [87] = NameAndType [207] [208] 
.const [88] = Utf8 'de.audi.atip.interapp.car.CarSDSService' 
.const [89] = Class [209] 
.const [90] = NameAndType [210] [211] 
.const [91] = Utf8 "[CarSDSServiceHandler#updateRemainingRangeViewOption] vo='%1'" 
.const [92] = Utf8 "[CarSDSServiceHandler#updateRemainingRange] valid='%1', value='%2', unit='%3'" 
.const [93] = Class [212] 
.const [94] = NameAndType [213] [214] 
.const [95] = Utf8 de/audi/atip/interapp/car/ICarRemainingRangeListener 
.const [96] = Utf8 java/lang/Exception 
.const [97] = Utf8 '[CarSDSServiceHandler#updateRemainingRange] exception occured within the listener' 
.const [98] = Utf8 '[CarSDSServiceHandler#addRemaningRangeListener]' 
.const [99] = Utf8 de/audi/app/car/core/kombi/CarSDSServiceHandler$1 
.const [100] = Utf8 '[CarSDSServiceHandler#addRemaningRangeListener] listener already registered' 
.const [101] = Utf8 '[CarSDSServiceHandler#removeRemaningRangeListener]' 
.const [102] = Utf8 de/audi/app/car/core/kombi/CarSDSServiceHandler 
.const [103] = Utf8 java/lang/Class 
.const [104] = Utf8 de/audi/app/car/common/app/ICarApplication 
.const [105] = Utf8 de/audi/atip/log/LogChannel 
.const [106] = Utf8 java/lang/Boolean 
.const [107] = Utf8 de/esolutions/fw/util/commons/job/DispatcherBase 
.const [108] = Class [215] 
.const [109] = NameAndType [216] [217] 
.const [110] = Class [218] 
.const [111] = NameAndType [219] [220] 
.const [112] = Class [221] 
.const [113] = NameAndType [222] [223] 
.const [114] = Class [224] 
.const [115] = NameAndType [225] [226] 
.const [116] = Class [227] 
.const [117] = NameAndType [228] [229] 
.const [118] = Class [230] 
.const [119] = NameAndType [231] [232] 
.const [120] = Class [233] 
.const [121] = NameAndType [234] [235] 
.const [122] = Class [236] 
.const [123] = NameAndType [237] [238] 
.const [124] = Class [239] 
.const [125] = NameAndType [240] [241] 
.const [126] = Class [242] 
.const [127] = NameAndType [243] [244] 
.const [128] = Class [245] 
.const [129] = NameAndType [246] [247] 
.const [130] = Class [248] 
.const [131] = NameAndType [249] [250] 
.const [132] = Class [251] 
.const [133] = NameAndType [252] [253] 
.const [134] = Class [254] 
.const [135] = NameAndType [255] [256] 
.const [136] = Class [257] 
.const [137] = NameAndType [258] [259] 
.const [138] = Class [260] 
.const [139] = NameAndType [261] [262] 
.const [140] = Class [263] 
.const [141] = NameAndType [264] [265] 
.const [142] = Class [266] 
.const [143] = NameAndType [267] [268] 
.const [144] = Class [269] 
.const [145] = NameAndType [270] [271] 
.const [146] = Class [272] 
.const [147] = NameAndType [273] [274] 
.const [148] = Class [275] 
.const [149] = NameAndType [276] [277] 
.const [150] = Class [278] 
.const [151] = NameAndType [279] [280] 
.const [152] = Class [281] 
.const [153] = NameAndType [282] [283] 
.const [154] = Class [284] 
.const [155] = NameAndType [285] [286] 
.const [156] = Class [287] 
.const [157] = NameAndType [288] [289] 
.const [158] = Class [290] 
.const [159] = NameAndType [291] [292] 
.const [160] = Class [293] 
.const [161] = NameAndType [294] [295] 
.const [162] = Class [296] 
.const [163] = NameAndType [297] [298] 
.const [164] = Class [299] 
.const [165] = NameAndType [300] [301] 
.const [166] = Class [302] 
.const [167] = NameAndType [303] [304] 
.const [168] = Class [305] 
.const [169] = NameAndType [306] [307] 
.const [170] = Class [308] 
.const [171] = NameAndType [309] [310] 
.const [172] = Class [311] 
.const [173] = NameAndType [312] [313] 
.const [174] = Class [314] 
.const [175] = NameAndType [315] [316] 
.const [176] = Class [317] 
.const [177] = NameAndType [318] [319] 
.const [178] = Class [320] 
.const [179] = NameAndType [321] [322] 
.const [180] = Class [323] 
.const [181] = NameAndType [324] [325] 
.const [182] = Class [326] 
.const [183] = NameAndType [327] [328] 
.const [184] = Class [329] 
.const [185] = NameAndType [330] [331] 
.const [186] = Utf8 java/lang/NoClassDefFoundError 
.const [187] = Utf8 java/lang/Object 
.const [188] = Utf8 java/util/ArrayList 
.const [189] = Class [332] 
.const [190] = NameAndType [333] [334] 
.const [191] = Class [335] 
.const [192] = NameAndType [336] [337] 
.const [193] = Utf8 de/audi/app/car/common/service/CarServiceProvider 
.const [194] = Class [338] 
.const [195] = NameAndType [339] [340] 
.const [196] = Class [341] 
.const [197] = NameAndType [342] [343] 
.const [198] = Class [344] 
.const [199] = NameAndType [345] [346] 
.const [200] = Class [347] 
.const [201] = NameAndType [348] [349] 
.const [202] = Utf8 de/audi/app/car/core/kombi/CarSDSServiceHandler$1 
.const [203] = Utf8 java/lang/Class 
.const [204] = Utf8 forName 
.const [205] = Utf8 (Ljava/lang/String;)Ljava/lang/Class; 
.const [206] = Utf8 de/audi/app/car/core/kombi/CarSDSServiceHandler 
.const [207] = Utf8 class$de$audi$atip$interapp$car$CarSDSService 
.const [208] = Utf8 Ljava/lang/Class; 
.const [209] = Utf8 de/audi/app/car/core/kombi/CarSDSServiceHandler 
.const [210] = Utf8 class$ 
.const [211] = Utf8 (Ljava/lang/String;)Ljava/lang/Class; 
.const [212] = Utf8 java/lang/Boolean 
.const [213] = Utf8 toString 
.const [214] = Utf8 (Z)Ljava/lang/String; 
.const [215] = Utf8 de/audi/app/car/core/kombi/CarSDSServiceHandler 
.const [216] = Utf8 logChannel 
.const [217] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [218] = Utf8 de/audi/app/car/core/kombi/CarSDSServiceHandler 
.const [219] = Utf8 unit 
.const [220] = Utf8 I 
.const [221] = Utf8 de/audi/app/car/core/kombi/CarSDSServiceHandler 
.const [222] = Utf8 value 
.const [223] = Utf8 I 
.const [224] = Utf8 de/audi/app/car/core/kombi/CarSDSServiceHandler 
.const [225] = Utf8 valid 
.const [226] = Utf8 Z 
.const [227] = Utf8 de/audi/app/car/core/kombi/CarSDSServiceHandler 
.const [228] = Utf8 vo 
.const [229] = Utf8 I 
.const [230] = Utf8 de/audi/app/car/core/kombi/CarSDSServiceHandler 
.const [231] = Utf8 mutex 
.const [232] = Utf8 Ljava/lang/Object; 
.const [233] = Utf8 java/lang/NoClassDefFoundError 
.const [234] = Utf8 initCause 
.const [235] = Utf8 (Ljava/lang/Throwable;)Ljava/lang/Throwable; 
.const [236] = Utf8 de/audi/app/car/core/kombi/CarSDSServiceHandler 
.const [237] = Utf8 listeners 
.const [238] = Utf8 Ljava/util/ArrayList; 
.const [239] = Utf8 de/audi/app/car/core/kombi/CarSDSServiceHandler 
.const [240] = Utf8 application 
.const [241] = Utf8 Lde/audi/app/car/common/app/ICarApplication; 
.const [242] = Utf8 java/lang/Class 
.const [243] = Utf8 getName 
.const [244] = Utf8 ()Ljava/lang/String; 
.const [245] = Utf8 de/audi/app/car/core/kombi/CarSDSServiceHandler 
.const [246] = Utf8 serviceProvider 
.const [247] = Utf8 Lde/audi/app/car/common/service/CarServiceProvider; 
.const [248] = Utf8 de/audi/app/car/common/service/CarServiceProvider 
.const [249] = Utf8 startService 
.const [250] = Utf8 ()V 
.const [251] = Utf8 de/audi/app/car/common/service/CarServiceProvider 
.const [252] = Utf8 stopService 
.const [253] = Utf8 ()V 
.const [254] = Utf8 java/util/ArrayList 
.const [255] = Utf8 clear 
.const [256] = Utf8 ()V 
.const [257] = Utf8 de/audi/atip/log/LogChannel 
.const [258] = Utf8 log 
.const [259] = Utf8 (ILjava/lang/String;J)Z 
.const [260] = Utf8 de/audi/app/car/core/kombi/CarSDSServiceHandler 
.const [261] = Utf8 updateRemainingRange 
.const [262] = Utf8 (ZII)V 
.const [263] = Utf8 de/audi/atip/log/LogChannel 
.const [264] = Utf8 isInfo 
.const [265] = Utf8 ()Z 
.const [266] = Utf8 de/audi/atip/log/LogChannel 
.const [267] = Utf8 log 
.const [268] = Utf8 (ILjava/lang/String;Ljava/lang/Object;JJ)Z 
.const [269] = Utf8 java/util/ArrayList 
.const [270] = Utf8 size 
.const [271] = Utf8 ()I 
.const [272] = Utf8 java/util/ArrayList 
.const [273] = Utf8 get 
.const [274] = Utf8 (I)Ljava/lang/Object; 
.const [275] = Utf8 de/audi/atip/log/LogChannel 
.const [276] = Utf8 log 
.const [277] = Utf8 (ILjava/lang/String;Ljava/lang/Throwable;)Z 
.const [278] = Utf8 de/audi/atip/log/LogChannel 
.const [279] = Utf8 log 
.const [280] = Utf8 (ILjava/lang/String;)Z 
.const [281] = Utf8 java/util/ArrayList 
.const [282] = Utf8 contains 
.const [283] = Utf8 (Ljava/lang/Object;)Z 
.const [284] = Utf8 java/util/ArrayList 
.const [285] = Utf8 add 
.const [286] = Utf8 (Ljava/lang/Object;)Z 
.const [287] = Utf8 de/esolutions/fw/util/commons/job/DispatcherBase 
.const [288] = Utf8 execute 
.const [289] = Utf8 (Ljava/lang/Object;)Lde/esolutions/fw/util/commons/job/Job; 
.const [290] = Utf8 java/util/ArrayList 
.const [291] = Utf8 remove 
.const [292] = Utf8 (Ljava/lang/Object;)Z 
.const [293] = Utf8 de/audi/app/car/core/kombi/CarSDSServiceHandler 
.const [294] = Utf8 calculateRemainingRangeState 
.const [295] = Utf8 (IZ)I 
.const [296] = Utf8 java/lang/NoClassDefFoundError 
.const [297] = Utf8 <init> 
.const [298] = Utf8 ()V 
.const [299] = Utf8 java/lang/Object 
.const [300] = Utf8 <init> 
.const [301] = Utf8 ()V 
.const [302] = Utf8 java/util/ArrayList 
.const [303] = Utf8 <init> 
.const [304] = Utf8 (I)V 
.const [305] = Utf8 de/audi/app/car/core/kombi/CarSDSServiceHandler 
.const [306] = Utf8 class$de$audi$atip$interapp$car$CarSDSService 
.const [307] = Utf8 Ljava/lang/Class; 
.const [308] = Utf8 de/audi/app/car/common/service/CarServiceProvider 
.const [309] = Utf8 <init> 
.const [310] = Utf8 (Ljava/lang/String;Ljava/lang/Object;Ljava/util/Hashtable;Lorg/osgi/framework/BundleContext;Lde/audi/atip/log/LogChannel;)V 
.const [311] = Utf8 de/audi/app/car/core/kombi/CarSDSServiceHandler$1 
.const [312] = Utf8 <init> 
.const [313] = Utf8 (Lde/audi/app/car/core/kombi/CarSDSServiceHandler;Lde/audi/atip/interapp/car/ICarRemainingRangeListener;)V 
.const [314] = Utf8 de/audi/app/car/core/kombi/CarSDSServiceHandler 
.const [315] = Utf8 logChannel 
.const [316] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [317] = Utf8 de/audi/app/car/core/kombi/CarSDSServiceHandler 
.const [318] = Utf8 unit 
.const [319] = Utf8 I 
.const [320] = Utf8 de/audi/app/car/core/kombi/CarSDSServiceHandler 
.const [321] = Utf8 value 
.const [322] = Utf8 I 
.const [323] = Utf8 de/audi/app/car/core/kombi/CarSDSServiceHandler 
.const [324] = Utf8 valid 
.const [325] = Utf8 Z 
.const [326] = Utf8 de/audi/app/car/core/kombi/CarSDSServiceHandler 
.const [327] = Utf8 vo 
.const [328] = Utf8 I 
.const [329] = Utf8 de/audi/app/car/core/kombi/CarSDSServiceHandler 
.const [330] = Utf8 mutex 
.const [331] = Utf8 Ljava/lang/Object; 
.const [332] = Utf8 de/audi/app/car/core/kombi/CarSDSServiceHandler 
.const [333] = Utf8 listeners 
.const [334] = Utf8 Ljava/util/ArrayList; 
.const [335] = Utf8 de/audi/app/car/core/kombi/CarSDSServiceHandler 
.const [336] = Utf8 application 
.const [337] = Utf8 Lde/audi/app/car/common/app/ICarApplication; 
.const [338] = Utf8 de/audi/app/car/common/app/ICarApplication 
.const [339] = Utf8 getBundleContext 
.const [340] = Utf8 ()Lorg/osgi/framework/BundleContext; 
.const [341] = Utf8 de/audi/app/car/core/kombi/CarSDSServiceHandler 
.const [342] = Utf8 serviceProvider 
.const [343] = Utf8 Lde/audi/app/car/common/service/CarServiceProvider; 
.const [344] = Utf8 de/audi/atip/interapp/car/ICarRemainingRangeListener 
.const [345] = Utf8 updateRemainingRange 
.const [346] = Utf8 (III)V 
.const [347] = Utf8 de/audi/app/car/common/app/ICarApplication 
.const [348] = Utf8 getJobDispatcher 
.const [349] = Utf8 ()Lde/esolutions/fw/util/commons/job/DispatcherBase; 
.const [350] = Utf8 de/audi/app/car/core/kombi/CarSDSServiceHandler 
.const [351] = Class [350] 
.const [352] = Utf8 java/lang/Object 
.const [353] = Class [352] 
.const [354] = Utf8 de/audi/atip/interapp/car/CarSDSService 
.const [355] = Class [354] 
.const [356] = Utf8 serviceProvider 
.const [357] = Utf8 Lde/audi/app/car/common/service/CarServiceProvider; 
.const [358] = Utf8 mutex 
.const [359] = Utf8 Ljava/lang/Object; 
.const [360] = Utf8 application 
.const [361] = Utf8 Lde/audi/app/car/common/app/ICarApplication; 
.const [362] = Utf8 logChannel 
.const [363] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [364] = Utf8 vo 
.const [365] = Utf8 I 
.const [366] = Utf8 valid 
.const [367] = Utf8 Z 
.const [368] = Utf8 value 
.const [369] = Utf8 I 
.const [370] = Utf8 unit 
.const [371] = Utf8 I 
.const [372] = Utf8 listeners 
.const [373] = Utf8 Ljava/util/ArrayList; 
.const [374] = Utf8 class$de$audi$atip$interapp$car$CarSDSService 
.const [375] = Utf8 Ljava/lang/Class; 
.const [376] = Utf8 Code 
.const [377] = Utf8 <init> 
.const [378] = Utf8 (Lde/audi/app/car/common/app/ICarApplication;Lde/audi/atip/log/LogChannel;)V 
.const [379] = Utf8 init 
.const [380] = Utf8 ()V 
.const [381] = Utf8 deinit 
.const [382] = Utf8 ()V 
.const [383] = Utf8 updateRemainingRangeViewOption 
.const [384] = Utf8 (I)V 
.const [385] = Utf8 updateRemainingRange 
.const [386] = Utf8 (ZII)V 
.const [387] = Utf8 addRemainingRangeListener 
.const [388] = Utf8 (Lde/audi/atip/interapp/car/ICarRemainingRangeListener;)V 
.const [389] = Utf8 removeRemainingRangeListener 
.const [390] = Utf8 (Lde/audi/atip/interapp/car/ICarRemainingRangeListener;)V 
.const [391] = Utf8 calculateRemainingRangeState 
.const [392] = Utf8 (IZ)I 
.const [393] = Utf8 class$ 
.const [394] = Utf8 (Ljava/lang/String;)Ljava/lang/Class; 
.const [395] = Utf8 access$000 
.const [396] = Utf8 (Lde/audi/app/car/core/kombi/CarSDSServiceHandler;)Ljava/lang/Object; 
.const [397] = Utf8 access$100 
.const [398] = Utf8 (Lde/audi/app/car/core/kombi/CarSDSServiceHandler;)I 
.const [399] = Utf8 access$200 
.const [400] = Utf8 (Lde/audi/app/car/core/kombi/CarSDSServiceHandler;)Z 
.const [401] = Utf8 access$300 
.const [402] = Utf8 (Lde/audi/app/car/core/kombi/CarSDSServiceHandler;IZ)I 
.const [403] = Utf8 access$400 
.const [404] = Utf8 (Lde/audi/app/car/core/kombi/CarSDSServiceHandler;)I 
.const [405] = Utf8 access$500 
.const [406] = Utf8 (Lde/audi/app/car/core/kombi/CarSDSServiceHandler;)I 
.const [407] = Utf8 access$600 
.const [408] = Utf8 (Lde/audi/app/car/core/kombi/CarSDSServiceHandler;)Lde/audi/atip/log/LogChannel; 
.end class 
