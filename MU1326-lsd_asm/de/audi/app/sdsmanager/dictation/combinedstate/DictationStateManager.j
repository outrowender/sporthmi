.version 50 0 
.class public final super [315] 
.super [317] 
.implements [319] 
.implements [321] 
.field private static final [322] [323] 
.field private volatile [324] [325] 
.field private volatile [326] [327] 
.field private volatile [328] [329] 
.field private volatile [330] [331] 
.field private volatile [332] [333] 
.field private volatile [334] [335] 

.method private static [337] : [338] 
    .attribute [336] .code stack 3 locals 7 
L0:     ldc_w [1] 
L3:     lstore_3 
L4:     ldc [2] 
L6:     ldc_w [1] 
L9:     invokestatic [3] 
L12:    invokestatic [4] 
L15:    astore 5 
        .catch [6] from L17 to L23 using L26 
L17:    aload 5 
L19:    invokestatic [5] 
L22:    lstore_3 
L23:    goto L32 
L26:    astore 6 
L28:    ldc_w [1] 
L31:    lstore_3 
L32:    lload_3 
L33:    freturn 
L34:    nop 
L35:    nop 
L36:    
    .end code 
.end method 

.method public [339] : [340] 
    .attribute [336] .code stack 3 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     ldc [7] 
L4:     invokespecial [49] 
L7:     aload_0 
L8:     iconst_0 
L9:     putfield [59] 
L12:    aload_0 
L13:    iconst_0 
L14:    putfield [60] 
L17:    aload_0 
L18:    iconst_0 
L19:    putfield [61] 
L22:    aload_0 
L23:    iconst_0 
L24:    putfield [62] 
L27:    return 
L28:    
    .end code 
.end method 

.method public [341] : [342] 
    .attribute [336] .code stack 5 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     invokespecial [50] 
L5:     aload_0 
L6:     aload_1 
L7:     invokevirtual [33] 
L10:    invokeinterface [63] 0 
L15:    putfield [58] 
L18:    aload_0 
L19:    invokespecial [51] 
L22:    aload_1 
L23:    invokevirtual [34] 
L26:    new [64] 
L29:    dup 
L30:    aload_0 
L31:    aconst_null 
L32:    invokespecial [52] 
L35:    invokevirtual [35] 
L38:    return 
L39:    nop 
L40:    
    .end code 
.end method 

.method private [343] : [344] 
    .attribute [336] .code stack 5 locals 1 
L0:     aload_0 
L1:     getfield [36] 
L4:     invokevirtual [33] 
L7:     invokeinterface [65] 0 
L12:    astore_1 
L13:    aload_0 
L14:    new [66] 
L17:    dup 
L18:    aload_1 
L19:    aload_0 
L20:    getfield [27] 
L23:    invokespecial [53] 
L26:    putfield [67] 
L29:    aload_0 
L30:    getfield [37] 
L33:    getstatic [10] 
L36:    invokevirtual [38] 
L39:    aload_0 
L40:    getfield [37] 
L43:    aload_0 
L44:    getfield [32] 
L47:    invokevirtual [39] 
L50:    return 
L51:    nop 
L52:    
    .end code 
.end method 

.method private [345] : [346] 
    .attribute [336] .code stack 2 locals 0 
L0:     aload_0 
L1:     iload_1 
L2:     putfield [59] 
L5:     aload_0 
L6:     invokespecial [55] 
L9:     return 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method private [347] : [348] 
    .attribute [336] .code stack 2 locals 0 
L0:     aload_0 
L1:     iload_1 
L2:     putfield [60] 
L5:     aload_0 
L6:     invokespecial [55] 
L9:     return 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method private [349] : [350] 
    .attribute [336] .code stack 2 locals 0 
L0:     aload_0 
L1:     iload_1 
L2:     putfield [61] 
L5:     aload_0 
L6:     invokespecial [55] 
L9:     return 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method private [351] : [352] 
    .attribute [336] .code stack 2 locals 1 
L0:     aload_0 
L1:     getfield [32] 
L4:     istore_1 
L5:     aload_0 
L6:     getfield [29] 
L9:     ifeq L19 
L12:    aload_0 
L13:    getfield [31] 
L16:    ifne L27 
L19:    aload_0 
L20:    iconst_0 
L21:    putfield [62] 
L24:    goto L72 
L27:    aload_0 
L28:    getfield [31] 
L31:    iconst_1 
L32:    if_icmpne L43 
L35:    aload_0 
L36:    iconst_1 
L37:    putfield [62] 
L40:    goto L72 
L43:    aload_0 
L44:    getfield [31] 
L47:    iconst_2 
L48:    if_icmpne L59 
L51:    aload_0 
L52:    iconst_2 
L53:    putfield [62] 
L56:    goto L72 
L59:    aload_0 
L60:    getfield [31] 
L63:    iconst_3 
L64:    if_icmpne L72 
L67:    aload_0 
L68:    iconst_4 
L69:    putfield [62] 
L72:    aload_0 
L73:    getfield [32] 
L76:    iconst_2 
L77:    if_icmpeq L88 
L80:    aload_0 
L81:    getfield [32] 
L84:    iconst_4 
L85:    if_icmpne L100 
L88:    aload_0 
L89:    getfield [30] 
L92:    ifeq L100 
L95:    aload_0 
L96:    iconst_3 
L97:    putfield [62] 
L100:   aload_0 
L101:   getfield [37] 
L104:   aload_0 
L105:   getfield [32] 
L108:   invokevirtual [39] 
L111:   aload_0 
L112:   getfield [32] 
L115:   iconst_3 
L116:   if_icmpne L134 
L119:   iload_1 
L120:   iconst_3 
L121:   if_icmpeq L134 
L124:   aload_0 
L125:   getfield [37] 
L128:   invokevirtual [40] 
L131:   goto L154 
L134:   aload_0 
L135:   getfield [32] 
L138:   iconst_3 
L139:   if_icmpeq L154 
L142:   iload_1 
L143:   iconst_3 
L144:   if_icmpne L154 
L147:   aload_0 
L148:   getfield [37] 
L151:   invokevirtual [41] 
L154:   return 
L155:   nop 
L156:   
    .end code 
.end method 

.method public [353] : [354] 
    .attribute [336] .code stack 4 locals 0 
L0:     aload_0 
L1:     getfield [27] 
L4:     ldc [11] 
L6:     ldc [12] 
L8:     aload_1 
L9:     invokevirtual [42] 
L12:    pop 
L13:    aload_0 
L14:    getfield [37] 
L17:    aload_1 
L18:    invokevirtual [43] 
L21:    return 
L22:    nop 
L23:    nop 
L24:    
    .end code 
.end method 

.method public [355] : [356] 
    .attribute [336] .code stack 4 locals 0 
L0:     aload_0 
L1:     getfield [27] 
L4:     ldc [11] 
L6:     ldc [13] 
L8:     aload_1 
L9:     invokevirtual [42] 
L12:    pop 
L13:    aload_0 
L14:    getfield [37] 
L17:    aload_1 
L18:    invokevirtual [44] 
L21:    return 
L22:    nop 
L23:    nop 
L24:    
    .end code 
.end method 

.method public [357] : [358] 
    .attribute [336] .code stack 4 locals 0 
L0:     aload_0 
L1:     getfield [28] 
L4:     new [68] 
L7:     dup 
L8:     aload_0 
L9:     invokespecial [56] 
L12:    invokevirtual [45] 
L15:    pop 
L16:    return 
L17:    nop 
L18:    nop 
L19:    nop 
L20:    
    .end code 
.end method 

.method public [359] : [360] 
    .attribute [336] .code stack 4 locals 0 
L0:     aload_0 
L1:     getfield [28] 
L4:     new [69] 
L7:     dup 
L8:     aload_0 
L9:     invokespecial [57] 
L12:    invokevirtual [45] 
L15:    pop 
L16:    return 
L17:    nop 
L18:    nop 
L19:    nop 
L20:    
    .end code 
.end method 

.method static synthetic [361] : [362] 
    .attribute [336] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [27] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method static synthetic [363] : [364] 
    .attribute [336] .code stack 2 locals 0 
L0:     aload_0 
L1:     iload_1 
L2:     invokespecial [48] 
L5:     return 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method static synthetic [365] : [366] 
    .attribute [336] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [27] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method static synthetic [367] : [368] 
    .attribute [336] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [27] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method static synthetic [369] : [370] 
    .attribute [336] .code stack 2 locals 0 
L0:     aload_0 
L1:     iload_1 
L2:     invokespecial [47] 
L5:     return 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method static synthetic [371] : [372] 
    .attribute [336] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [28] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method static synthetic [373] : [374] 
    .attribute [336] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [27] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method static synthetic [375] : [376] 
    .attribute [336] .code stack 2 locals 0 
L0:     aload_0 
L1:     iload_1 
L2:     invokespecial [46] 
L5:     return 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method static [377] : [378] 
    .attribute [336] .code stack 2 locals 0 
L0:     invokestatic [16] 
L3:     putstatic [54] 
L6:     return 
L7:     nop 
L8:     
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = String [71] 
.const [3] = Method [72] [73] 
.const [4] = Method [74] [75] 
.const [5] = Method [76] [77] 
.const [6] = Class [78] 
.const [7] = String [79] 
.const [8] = Class [80] 
.const [9] = Class [81] 
.const [10] = Field [82] [83] 
.const [11] = Int 1078071040 
.const [12] = String [84] 
.const [13] = String [85] 
.const [14] = Class [86] 
.const [15] = Class [87] 
.const [16] = Method [88] [89] 
.const [17] = Class [90] 
.const [18] = Class [91] 
.const [19] = Class [92] 
.const [20] = Class [93] 
.const [21] = Class [94] 
.const [22] = Class [95] 
.const [23] = Class [96] 
.const [24] = Class [97] 
.const [25] = Class [98] 
.const [26] = Class [99] 
.const [27] = Field [100] [101] 
.const [28] = Field [102] [103] 
.const [29] = Field [104] [105] 
.const [30] = Field [106] [107] 
.const [31] = Field [108] [109] 
.const [32] = Field [110] [111] 
.const [33] = Method [112] [113] 
.const [34] = Method [114] [115] 
.const [35] = Method [116] [117] 
.const [36] = Field [118] [119] 
.const [37] = Field [120] [121] 
.const [38] = Method [122] [123] 
.const [39] = Method [124] [125] 
.const [40] = Method [126] [127] 
.const [41] = Method [128] [129] 
.const [42] = Method [130] [131] 
.const [43] = Method [132] [133] 
.const [44] = Method [134] [135] 
.const [45] = Method [136] [137] 
.const [46] = Method [138] [139] 
.const [47] = Method [140] [141] 
.const [48] = Method [142] [143] 
.const [49] = Method [144] [145] 
.const [50] = Method [146] [147] 
.const [51] = Method [148] [149] 
.const [52] = Method [150] [151] 
.const [53] = Method [152] [153] 
.const [54] = Field [154] [155] 
.const [55] = Method [156] [157] 
.const [56] = Method [158] [159] 
.const [57] = Method [160] [161] 
.const [58] = Field [162] [163] 
.const [59] = Field [164] [165] 
.const [60] = Field [166] [167] 
.const [61] = Field [168] [169] 
.const [62] = Field [170] [171] 
.const [63] = InterfaceMethod [172] [173] 
.const [64] = Class [174] 
.const [65] = InterfaceMethod [175] [176] 
.const [66] = Class [177] 
.const [67] = Field [178] [179] 
.const [68] = Class [180] 
.const [69] = Class [181] 
.const [70] = Int 743178240 
.const [71] = Utf8 'dictation.maxDuration' 
.const [72] = Class [182] 
.const [73] = NameAndType [183] [184] 
.const [74] = Class [185] 
.const [75] = NameAndType [186] [187] 
.const [76] = Class [188] 
.const [77] = NameAndType [189] [190] 
.const [78] = Utf8 java/lang/Exception 
.const [79] = Utf8 'App.SDS.Dictation' 
.const [80] = Utf8 de/audi/app/sdsmanager/dictation/combinedstate/DictationStateManager$DsiDictationAdapterListener 
.const [81] = Utf8 de/audi/app/sdsmanager/dictation/combinedstate/DictationStateObserverProxy 
.const [82] = Class [191] 
.const [83] = NameAndType [192] [193] 
.const [84] = Utf8 '[DictationStateManager#addObserver] observer = %1' 
.const [85] = Utf8 '[DictationStateManager#removeObserver] observer = %1' 
.const [86] = Utf8 de/audi/app/sdsmanager/dictation/combinedstate/DictationStateManager$1 
.const [87] = Utf8 de/audi/app/sdsmanager/dictation/combinedstate/DictationStateManager$2 
.const [88] = Class [194] 
.const [89] = NameAndType [195] [196] 
.const [90] = Utf8 de/audi/app/sdsmanager/dictation/combinedstate/DictationStateManager 
.const [91] = Utf8 de/audi/app/sdsmanager/dictation/component/AbstractDictationComponent 
.const [92] = Utf8 java/lang/String 
.const [93] = Utf8 java/lang/System 
.const [94] = Utf8 java/lang/Long 
.const [95] = Utf8 de/audi/app/sdsmanager/dictation/DictationComponentManager 
.const [96] = Utf8 de/audi/app/sdsmanager/dictation/dispatcher/IDispatcherManager 
.const [97] = Utf8 de/audi/app/sdsmanager/dictation/dsiadapter/DsiDictationAdapter 
.const [98] = Utf8 de/audi/atip/log/LogChannel 
.const [99] = Utf8 de/esolutions/fw/util/commons/job/DispatcherBase 
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
.const [166] = Class [296] 
.const [167] = NameAndType [297] [298] 
.const [168] = Class [299] 
.const [169] = NameAndType [300] [301] 
.const [170] = Class [302] 
.const [171] = NameAndType [303] [304] 
.const [172] = Class [305] 
.const [173] = NameAndType [306] [307] 
.const [174] = Utf8 de/audi/app/sdsmanager/dictation/combinedstate/DictationStateManager$DsiDictationAdapterListener 
.const [175] = Class [308] 
.const [176] = NameAndType [309] [310] 
.const [177] = Utf8 de/audi/app/sdsmanager/dictation/combinedstate/DictationStateObserverProxy 
.const [178] = Class [311] 
.const [179] = NameAndType [312] [313] 
.const [180] = Utf8 de/audi/app/sdsmanager/dictation/combinedstate/DictationStateManager$1 
.const [181] = Utf8 de/audi/app/sdsmanager/dictation/combinedstate/DictationStateManager$2 
.const [182] = Utf8 java/lang/String 
.const [183] = Utf8 valueOf 
.const [184] = Utf8 (J)Ljava/lang/String; 
.const [185] = Utf8 java/lang/System 
.const [186] = Utf8 getProperty 
.const [187] = Utf8 (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String; 
.const [188] = Utf8 java/lang/Long 
.const [189] = Utf8 parseLong 
.const [190] = Utf8 (Ljava/lang/String;)J 
.const [191] = Utf8 de/audi/app/sdsmanager/dictation/combinedstate/DictationStateManager 
.const [192] = Utf8 DICTATION_MAX_DURATION 
.const [193] = Utf8 J 
.const [194] = Utf8 de/audi/app/sdsmanager/dictation/combinedstate/DictationStateManager 
.const [195] = Utf8 getDictationMaxDuration 
.const [196] = Utf8 ()J 
.const [197] = Utf8 de/audi/app/sdsmanager/dictation/combinedstate/DictationStateManager 
.const [198] = Utf8 log 
.const [199] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [200] = Utf8 de/audi/app/sdsmanager/dictation/combinedstate/DictationStateManager 
.const [201] = Utf8 dispatcher 
.const [202] = Utf8 Lde/esolutions/fw/util/commons/job/DispatcherBase; 
.const [203] = Utf8 de/audi/app/sdsmanager/dictation/combinedstate/DictationStateManager 
.const [204] = Utf8 dsiAvailable 
.const [205] = Utf8 Z 
.const [206] = Utf8 de/audi/app/sdsmanager/dictation/combinedstate/DictationStateManager 
.const [207] = Utf8 isSpeechInProgress 
.const [208] = Utf8 Z 
.const [209] = Utf8 de/audi/app/sdsmanager/dictation/combinedstate/DictationStateManager 
.const [210] = Utf8 activationState 
.const [211] = Utf8 I 
.const [212] = Utf8 de/audi/app/sdsmanager/dictation/combinedstate/DictationStateManager 
.const [213] = Utf8 dictationState 
.const [214] = Utf8 I 
.const [215] = Utf8 de/audi/app/sdsmanager/dictation/DictationComponentManager 
.const [216] = Utf8 getDispatcherManager 
.const [217] = Utf8 ()Lde/audi/app/sdsmanager/dictation/dispatcher/IDispatcherManager; 
.const [218] = Utf8 de/audi/app/sdsmanager/dictation/DictationComponentManager 
.const [219] = Utf8 getDsiDictationAdapter 
.const [220] = Utf8 ()Lde/audi/app/sdsmanager/dictation/dsiadapter/DsiDictationAdapter; 
.const [221] = Utf8 de/audi/app/sdsmanager/dictation/dsiadapter/DsiDictationAdapter 
.const [222] = Utf8 addListener 
.const [223] = Utf8 (Lde/audi/app/sdsmanager/dictation/dsiadapter/IDsiDictationAdapterListener;)V 
.const [224] = Utf8 de/audi/app/sdsmanager/dictation/combinedstate/DictationStateManager 
.const [225] = Utf8 dictationComponentManager 
.const [226] = Utf8 Lde/audi/app/sdsmanager/dictation/DictationComponentManager; 
.const [227] = Utf8 de/audi/app/sdsmanager/dictation/combinedstate/DictationStateManager 
.const [228] = Utf8 observerProxy 
.const [229] = Utf8 Lde/audi/app/sdsmanager/dictation/combinedstate/DictationStateObserverProxy; 
.const [230] = Utf8 de/audi/app/sdsmanager/dictation/combinedstate/DictationStateObserverProxy 
.const [231] = Utf8 updateDictationMaxDuration 
.const [232] = Utf8 (J)V 
.const [233] = Utf8 de/audi/app/sdsmanager/dictation/combinedstate/DictationStateObserverProxy 
.const [234] = Utf8 updateDictationState 
.const [235] = Utf8 (I)V 
.const [236] = Utf8 de/audi/app/sdsmanager/dictation/combinedstate/DictationStateObserverProxy 
.const [237] = Utf8 indicateRecordingStarted 
.const [238] = Utf8 ()V 
.const [239] = Utf8 de/audi/app/sdsmanager/dictation/combinedstate/DictationStateObserverProxy 
.const [240] = Utf8 indicateRecordingStopped 
.const [241] = Utf8 ()V 
.const [242] = Utf8 de/audi/atip/log/LogChannel 
.const [243] = Utf8 log 
.const [244] = Utf8 (ILjava/lang/String;Ljava/lang/Object;)Z 
.const [245] = Utf8 de/audi/app/sdsmanager/dictation/combinedstate/DictationStateObserverProxy 
.const [246] = Utf8 addObserver 
.const [247] = Utf8 (Lde/audi/app/sdsmanager/dictation/combinedstate/IDictationStateObserver;)V 
.const [248] = Utf8 de/audi/app/sdsmanager/dictation/combinedstate/DictationStateObserverProxy 
.const [249] = Utf8 removeObserver 
.const [250] = Utf8 (Lde/audi/app/sdsmanager/dictation/combinedstate/IDictationStateObserver;)V 
.const [251] = Utf8 de/esolutions/fw/util/commons/job/DispatcherBase 
.const [252] = Utf8 execute 
.const [253] = Utf8 (Ljava/lang/Object;)Lde/esolutions/fw/util/commons/job/Job; 
.const [254] = Utf8 de/audi/app/sdsmanager/dictation/combinedstate/DictationStateManager 
.const [255] = Utf8 setDsiAvailable 
.const [256] = Utf8 (Z)V 
.const [257] = Utf8 de/audi/app/sdsmanager/dictation/combinedstate/DictationStateManager 
.const [258] = Utf8 setActivationState 
.const [259] = Utf8 (I)V 
.const [260] = Utf8 de/audi/app/sdsmanager/dictation/combinedstate/DictationStateManager 
.const [261] = Utf8 setSpeechInProgress 
.const [262] = Utf8 (Z)V 
.const [263] = Utf8 de/audi/app/sdsmanager/dictation/component/AbstractDictationComponent 
.const [264] = Utf8 <init> 
.const [265] = Utf8 (Lde/audi/app/sdsmanager/dictation/osgi/BundleEnvironment;Ljava/lang/String;)V 
.const [266] = Utf8 de/audi/app/sdsmanager/dictation/component/AbstractDictationComponent 
.const [267] = Utf8 init 
.const [268] = Utf8 (Lde/audi/app/sdsmanager/dictation/DictationComponentManager;)V 
.const [269] = Utf8 de/audi/app/sdsmanager/dictation/combinedstate/DictationStateManager 
.const [270] = Utf8 initObserverProxy 
.const [271] = Utf8 ()V 
.const [272] = Utf8 de/audi/app/sdsmanager/dictation/combinedstate/DictationStateManager$DsiDictationAdapterListener 
.const [273] = Utf8 <init> 
.const [274] = Utf8 (Lde/audi/app/sdsmanager/dictation/combinedstate/DictationStateManager;Lde/audi/app/sdsmanager/dictation/combinedstate/DictationStateManager$1;)V 
.const [275] = Utf8 de/audi/app/sdsmanager/dictation/combinedstate/DictationStateObserverProxy 
.const [276] = Utf8 <init> 
.const [277] = Utf8 (Lde/esolutions/fw/util/commons/job/DispatcherBase;Lde/audi/atip/log/LogChannel;)V 
.const [278] = Utf8 de/audi/app/sdsmanager/dictation/combinedstate/DictationStateManager 
.const [279] = Utf8 DICTATION_MAX_DURATION 
.const [280] = Utf8 J 
.const [281] = Utf8 de/audi/app/sdsmanager/dictation/combinedstate/DictationStateManager 
.const [282] = Utf8 setDictationState 
.const [283] = Utf8 ()V 
.const [284] = Utf8 de/audi/app/sdsmanager/dictation/combinedstate/DictationStateManager$1 
.const [285] = Utf8 <init> 
.const [286] = Utf8 (Lde/audi/app/sdsmanager/dictation/combinedstate/DictationStateManager;)V 
.const [287] = Utf8 de/audi/app/sdsmanager/dictation/combinedstate/DictationStateManager$2 
.const [288] = Utf8 <init> 
.const [289] = Utf8 (Lde/audi/app/sdsmanager/dictation/combinedstate/DictationStateManager;)V 
.const [290] = Utf8 de/audi/app/sdsmanager/dictation/combinedstate/DictationStateManager 
.const [291] = Utf8 dispatcher 
.const [292] = Utf8 Lde/esolutions/fw/util/commons/job/DispatcherBase; 
.const [293] = Utf8 de/audi/app/sdsmanager/dictation/combinedstate/DictationStateManager 
.const [294] = Utf8 dsiAvailable 
.const [295] = Utf8 Z 
.const [296] = Utf8 de/audi/app/sdsmanager/dictation/combinedstate/DictationStateManager 
.const [297] = Utf8 isSpeechInProgress 
.const [298] = Utf8 Z 
.const [299] = Utf8 de/audi/app/sdsmanager/dictation/combinedstate/DictationStateManager 
.const [300] = Utf8 activationState 
.const [301] = Utf8 I 
.const [302] = Utf8 de/audi/app/sdsmanager/dictation/combinedstate/DictationStateManager 
.const [303] = Utf8 dictationState 
.const [304] = Utf8 I 
.const [305] = Utf8 de/audi/app/sdsmanager/dictation/dispatcher/IDispatcherManager 
.const [306] = Utf8 getInternalTaskDispatcher 
.const [307] = Utf8 ()Lde/esolutions/fw/util/commons/job/DispatcherBase; 
.const [308] = Utf8 de/audi/app/sdsmanager/dictation/dispatcher/IDispatcherManager 
.const [309] = Utf8 getExternalTaskDispatcher 
.const [310] = Utf8 ()Lde/esolutions/fw/util/commons/job/DispatcherBase; 
.const [311] = Utf8 de/audi/app/sdsmanager/dictation/combinedstate/DictationStateManager 
.const [312] = Utf8 observerProxy 
.const [313] = Utf8 Lde/audi/app/sdsmanager/dictation/combinedstate/DictationStateObserverProxy; 
.const [314] = Utf8 de/audi/app/sdsmanager/dictation/combinedstate/DictationStateManager 
.const [315] = Class [314] 
.const [316] = Utf8 de/audi/app/sdsmanager/dictation/component/AbstractDictationComponent 
.const [317] = Class [316] 
.const [318] = Utf8 de/audi/app/sdsmanager/dictation/recognizer/IRecognizerStateObserver 
.const [319] = Class [318] 
.const [320] = Utf8 de/audi/app/sdsmanager/dictation/combinedstate/IDictationStateManager 
.const [321] = Class [320] 
.const [322] = Utf8 DICTATION_MAX_DURATION 
.const [323] = Utf8 J 
.const [324] = Utf8 dispatcher 
.const [325] = Utf8 Lde/esolutions/fw/util/commons/job/DispatcherBase; 
.const [326] = Utf8 observerProxy 
.const [327] = Utf8 Lde/audi/app/sdsmanager/dictation/combinedstate/DictationStateObserverProxy; 
.const [328] = Utf8 dsiAvailable 
.const [329] = Utf8 Z 
.const [330] = Utf8 isSpeechInProgress 
.const [331] = Utf8 Z 
.const [332] = Utf8 activationState 
.const [333] = Utf8 I 
.const [334] = Utf8 dictationState 
.const [335] = Utf8 I 
.const [336] = Utf8 Code 
.const [337] = Utf8 getDictationMaxDuration 
.const [338] = Utf8 ()J 
.const [339] = Utf8 <init> 
.const [340] = Utf8 (Lde/audi/app/sdsmanager/dictation/osgi/BundleEnvironment;)V 
.const [341] = Utf8 init 
.const [342] = Utf8 (Lde/audi/app/sdsmanager/dictation/DictationComponentManager;)V 
.const [343] = Utf8 initObserverProxy 
.const [344] = Utf8 ()V 
.const [345] = Utf8 setDsiAvailable 
.const [346] = Utf8 (Z)V 
.const [347] = Utf8 setSpeechInProgress 
.const [348] = Utf8 (Z)V 
.const [349] = Utf8 setActivationState 
.const [350] = Utf8 (I)V 
.const [351] = Utf8 setDictationState 
.const [352] = Utf8 ()V 
.const [353] = Utf8 addObserver 
.const [354] = Utf8 (Lde/audi/app/sdsmanager/dictation/combinedstate/IDictationStateObserver;)V 
.const [355] = Utf8 removeObserver 
.const [356] = Utf8 (Lde/audi/app/sdsmanager/dictation/combinedstate/IDictationStateObserver;)V 
.const [357] = Utf8 indicateStartOfSpeech 
.const [358] = Utf8 ()V 
.const [359] = Utf8 indicateEndOfSpeech 
.const [360] = Utf8 ()V 
.const [361] = Utf8 access$100 
.const [362] = Utf8 (Lde/audi/app/sdsmanager/dictation/combinedstate/DictationStateManager;)Lde/audi/atip/log/LogChannel; 
.const [363] = Utf8 access$200 
.const [364] = Utf8 (Lde/audi/app/sdsmanager/dictation/combinedstate/DictationStateManager;Z)V 
.const [365] = Utf8 access$300 
.const [366] = Utf8 (Lde/audi/app/sdsmanager/dictation/combinedstate/DictationStateManager;)Lde/audi/atip/log/LogChannel; 
.const [367] = Utf8 access$500 
.const [368] = Utf8 (Lde/audi/app/sdsmanager/dictation/combinedstate/DictationStateManager;)Lde/audi/atip/log/LogChannel; 
.const [369] = Utf8 access$600 
.const [370] = Utf8 (Lde/audi/app/sdsmanager/dictation/combinedstate/DictationStateManager;I)V 
.const [371] = Utf8 access$700 
.const [372] = Utf8 (Lde/audi/app/sdsmanager/dictation/combinedstate/DictationStateManager;)Lde/esolutions/fw/util/commons/job/DispatcherBase; 
.const [373] = Utf8 access$800 
.const [374] = Utf8 (Lde/audi/app/sdsmanager/dictation/combinedstate/DictationStateManager;)Lde/audi/atip/log/LogChannel; 
.const [375] = Utf8 access$900 
.const [376] = Utf8 (Lde/audi/app/sdsmanager/dictation/combinedstate/DictationStateManager;Z)V 
.const [377] = Utf8 <clinit> 
.const [378] = Utf8 ()V 
.end class 
