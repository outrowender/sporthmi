.version 50 0 
.class public super [384] 
.super [386] 
.implements [388] 
.implements [390] 
.field private static [391] [392] 
.field private volatile [393] [394] 
.field private [395] [396] 
.field private [397] [398] 
.field private [399] [400] 
.field private [401] [402] 
.field static synthetic [403] [404] 
.field static synthetic [405] [406] 
.field static synthetic [407] [408] 

.method public [410] : [411] 
    .attribute [409] .code stack 9 locals 1 
L0:     aload_0 
L1:     invokespecial [64] 
L4:     aload_0 
L5:     iconst_0 
L6:     putfield [74] 
L9:     aload_0 
L10:    aload_1 
L11:    putfield [75] 
L14:    new [76] 
L17:    dup 
L18:    invokespecial [65] 
L21:    astore_2 
L22:    aload_2 
L23:    ldc [7] 
L25:    getstatic [8] 
L28:    invokevirtual [48] 
L31:    pop 
L32:    aload_1 
L33:    getstatic [9] 
L36:    ifnonnull L51 
L39:    ldc [10] 
L41:    invokestatic [11] 
L44:    dup 
L45:    putstatic [66] 
L48:    goto L54 
L51:    getstatic [9] 
L54:    invokevirtual [49] 
L57:    aload_0 
L58:    aload_2 
L59:    invokeinterface [77] 0 
L64:    pop 
L65:    aload_0 
L66:    new [78] 
L69:    dup 
L70:    aload_1 
L71:    iconst_2 
L72:    anewarray [13] 
L75:    dup 
L76:    iconst_0 
L77:    getstatic [14] 
L80:    ifnonnull L95 
L83:    ldc [15] 
L85:    invokestatic [11] 
L88:    dup 
L89:    putstatic [67] 
L92:    goto L98 
L95:    getstatic [14] 
L98:    invokevirtual [49] 
L101:   aastore 
L102:   dup 
L103:   iconst_1 
L104:   getstatic [16] 
L107:   ifnonnull L122 
L110:   ldc [17] 
L112:   invokestatic [11] 
L115:   dup 
L116:   putstatic [68] 
L119:   goto L125 
L122:   getstatic [16] 
L125:   invokevirtual [49] 
L128:   aastore 
L129:   aload_0 
L130:   invokespecial [69] 
L133:   putfield [79] 
L136:   aload_0 
L137:   getfield [50] 
L140:   invokevirtual [51] 
L143:   return 
L144:   
    .end code 
.end method 

.method private [412] : [413] 
    .attribute [409] .code stack 5 locals 0 
L0:     getstatic [2] 
L3:     ldc [18] 
L5:     ldc [19] 
L7:     invokevirtual [52] 
L10:    pop 
L11:    aload_1 
L12:    new [80] 
L15:    dup 
L16:    aload_0 
L17:    aconst_null 
L18:    invokespecial [70] 
L21:    invokeinterface [81] 0 
L26:    aload_0 
L27:    aload_1 
L28:    putfield [82] 
L31:    return 
L32:    
    .end code 
.end method 

.method public [414] : [415] 
    .attribute [409] .code stack 3 locals 0 
L0:     getstatic [2] 
L3:     ldc [18] 
L5:     ldc [21] 
L7:     invokevirtual [52] 
L10:    pop 
L11:    aload_0 
L12:    getfield [54] 
L15:    ifnull L34 
L18:    aload_0 
L19:    getfield [54] 
L22:    bipush 120 
L24:    invokeinterface [84] 0 
L29:    aload_0 
L30:    iconst_1 
L31:    putfield [74] 
L34:    return 
L35:    nop 
L36:    
    .end code 
.end method 

.method private [416] : [417] 
    .attribute [409] .code stack 4 locals 1 
L0:     aload_0 
L1:     getfield [53] 
L4:     ifnull L43 
        .catch [22] from L7 to L19 using L22 
L7:     aload_0 
L8:     getfield [53] 
L11:    iconst_0 
L12:    bipush 17 
L14:    invokeinterface [85] 0 
L19:    goto L59 
L22:    astore_1 
L23:    getstatic [2] 
L26:    sipush 10000 
L29:    ldc [23] 
L31:    aload_1 
L32:    invokevirtual [55] 
L35:    pop 
L36:    aload_0 
L37:    invokespecial [61] 
L40:    goto L59 
L43:    getstatic [2] 
L46:    sipush 10000 
L49:    ldc [24] 
L51:    invokevirtual [52] 
L54:    pop 
L55:    aload_0 
L56:    invokespecial [61] 
L59:    return 
L60:    
    .end code 
.end method 

.method private [418] : [419] 
    .attribute [409] .code stack 2 locals 0 
L0:     aload_0 
L1:     iconst_0 
L2:     putfield [74] 
L5:     aload_0 
L6:     getfield [54] 
L9:     ifnull L23 
L12:    aload_0 
L13:    getfield [54] 
L16:    bipush 120 
L18:    invokeinterface [86] 0 
L23:    return 
L24:    
    .end code 
.end method 

.method public [420] : [421] 
    .attribute [409] .code stack 4 locals 0 
L0:     getstatic [2] 
L3:     ldc [18] 
L5:     ldc [25] 
L7:     iload_1 
L8:     invokevirtual [56] 
L11:    pop 
L12:    return 
L13:    nop 
L14:    nop 
L15:    nop 
L16:    
    .end code 
.end method 

.method public [422] : [423] 
    .attribute [409] .code stack 5 locals 0 
L0:     getstatic [2] 
L3:     ldc [18] 
L5:     ldc [26] 
L7:     iload_1 
L8:     i2l 
L9:     invokevirtual [57] 
L12:    pop 
L13:    return 
L14:    nop 
L15:    nop 
L16:    
    .end code 
.end method 

.method public [424] : [425] 
    .attribute [409] .code stack 5 locals 0 
L0:     getstatic [2] 
L3:     ldc [18] 
L5:     ldc [27] 
L7:     iload_1 
L8:     i2l 
L9:     invokevirtual [57] 
L12:    pop 
L13:    return 
L14:    nop 
L15:    nop 
L16:    
    .end code 
.end method 

.method public [426] : [427] 
    .attribute [409] .code stack 6 locals 0 
L0:     getstatic [2] 
L3:     ldc [28] 
L5:     ldc [29] 
L7:     aload_0 
L8:     getfield [46] 
L11:    iload_1 
L12:    i2l 
L13:    invokevirtual [58] 
L16:    pop 
L17:    iload_1 
L18:    bipush 120 
L20:    if_icmpne L40 
L23:    aload_0 
L24:    getfield [46] 
L27:    ifeq L40 
L30:    aload_0 
L31:    getfield [54] 
L34:    iload_1 
L35:    invokeinterface [87] 0 
L40:    return 
L41:    nop 
L42:    nop 
L43:    nop 
L44:    
    .end code 
.end method 

.method public [428] : [429] 
    .attribute [409] .code stack 7 locals 0 
L0:     getstatic [2] 
L3:     ldc [30] 
L5:     ldc [31] 
L7:     iload_1 
L8:     i2l 
L9:     iload_3 
L10:    i2l 
L11:    invokevirtual [59] 
L14:    pop 
L15:    return 
L16:    
    .end code 
.end method 

.method public [430] : [431] 
    .attribute [409] .code stack 6 locals 0 
L0:     getstatic [2] 
L3:     ldc [28] 
L5:     ldc [32] 
L7:     aload_0 
L8:     getfield [46] 
L11:    iload_1 
L12:    i2l 
L13:    invokevirtual [58] 
L16:    pop 
L17:    iload_1 
L18:    bipush 120 
L20:    if_icmpne L34 
L23:    aload_0 
L24:    getfield [46] 
L27:    ifeq L34 
L30:    aload_0 
L31:    invokespecial [71] 
L34:    return 
L35:    nop 
L36:    
    .end code 
.end method 

.method public [432] : [433] 
    .attribute [409] .code stack 3 locals 2 
L0:     aload_0 
L1:     getfield [47] 
L4:     aload_1 
L5:     invokeinterface [88] 0 
L10:    astore_2 
L11:    aload_2 
L12:    instanceof [33] 
L15:    ifeq L59 
L18:    getstatic [8] 
L21:    aload_1 
L22:    ldc [7] 
L24:    invokeinterface [89] 0 
L29:    invokevirtual [60] 
L32:    ifne L48 
L35:    aload_0 
L36:    getfield [47] 
L39:    aload_1 
L40:    invokeinterface [90] 0 
L45:    pop 
L46:    aconst_null 
L47:    areturn 
L48:    aload_0 
L49:    aload_2 
L50:    checkcast [33] 
L53:    putfield [83] 
L56:    goto L97 
L59:    aload_2 
L60:    instanceof [34] 
L63:    ifeq L84 
L66:    aload_2 
L67:    checkcast [34] 
L70:    invokeinterface [91] 0 
L75:    astore_3 
L76:    aload_0 
L77:    aload_3 
L78:    invokespecial [72] 
L81:    goto L97 
L84:    aload_0 
L85:    getfield [47] 
L88:    aload_1 
L89:    invokeinterface [90] 0 
L94:    pop 
L95:    aconst_null 
L96:    areturn 
L97:    aload_2 
L98:    areturn 
L99:    nop 
L100:   
    .end code 
.end method 

.method public enum [434] : [435] 
    .attribute [409] .code stack 0 locals 0 
L0:     return 
L1:     nop 
L2:     nop 
L3:     nop 
L4:     
    .end code 
.end method 

.method public enum [436] : [437] 
    .attribute [409] .code stack 0 locals 0 
L0:     return 
L1:     nop 
L2:     nop 
L3:     nop 
L4:     
    .end code 
.end method 

.method public enum [438] : [439] 
    .attribute [409] .code stack 0 locals 0 
L0:     return 
L1:     nop 
L2:     nop 
L3:     nop 
L4:     
    .end code 
.end method 

.method static synthetic [440] : [441] 
    .attribute [409] .code stack 2 locals 1 
        .catch [4] from L0 to L4 using L5 
L0:     aload_0 
L1:     invokestatic [3] 
L4:     areturn 
L5:     astore_1 
L6:     new [73] 
L9:     dup 
L10:    invokespecial [63] 
L13:    aload_1 
L14:    invokevirtual [45] 
L17:    athrow 
L18:    nop 
L19:    nop 
L20:    
    .end code 
.end method 

.method static synthetic [442] : [443] 
    .attribute [409] .code stack 1 locals 0 
L0:     getstatic [2] 
L3:     areturn 
L4:     
    .end code 
.end method 

.method static synthetic [444] : [445] 
    .attribute [409] .code stack 1 locals 0 
L0:     aload_0 
L1:     invokespecial [61] 
L4:     return 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method static [446] : [447] 
    .attribute [409] .code stack 1 locals 0 
L0:     getstatic [35] 
L3:     putstatic [62] 
L6:     return 
L7:     nop 
L8:     
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Field [92] [93] 
.const [3] = Method [94] [95] 
.const [4] = Class [96] 
.const [5] = Class [97] 
.const [6] = Class [98] 
.const [7] = String [99] 
.const [8] = Field [100] [101] 
.const [9] = Field [102] [103] 
.const [10] = String [104] 
.const [11] = Method [105] [106] 
.const [12] = Class [107] 
.const [13] = Class [108] 
.const [14] = Field [109] [110] 
.const [15] = String [111] 
.const [16] = Field [112] [113] 
.const [17] = String [114] 
.const [18] = Int -2137614336 
.const [19] = String [115] 
.const [20] = Class [116] 
.const [21] = String [117] 
.const [22] = Class [118] 
.const [23] = String [119] 
.const [24] = String [120] 
.const [25] = String [121] 
.const [26] = String [122] 
.const [27] = String [123] 
.const [28] = Int 1078071040 
.const [29] = String [124] 
.const [30] = Int -1601830656 
.const [31] = String [125] 
.const [32] = String [126] 
.const [33] = Class [127] 
.const [34] = Class [128] 
.const [35] = Field [129] [130] 
.const [36] = Class [131] 
.const [37] = Class [132] 
.const [38] = Class [133] 
.const [39] = Class [134] 
.const [40] = Class [135] 
.const [41] = Class [136] 
.const [42] = Class [137] 
.const [43] = Class [138] 
.const [44] = Class [139] 
.const [45] = Method [140] [141] 
.const [46] = Field [142] [143] 
.const [47] = Field [144] [145] 
.const [48] = Method [146] [147] 
.const [49] = Method [148] [149] 
.const [50] = Field [150] [151] 
.const [51] = Method [152] [153] 
.const [52] = Method [154] [155] 
.const [53] = Field [156] [157] 
.const [54] = Field [158] [159] 
.const [55] = Method [160] [161] 
.const [56] = Method [162] [163] 
.const [57] = Method [164] [165] 
.const [58] = Method [166] [167] 
.const [59] = Method [168] [169] 
.const [60] = Method [170] [171] 
.const [61] = Method [172] [173] 
.const [62] = Field [174] [175] 
.const [63] = Method [176] [177] 
.const [64] = Method [178] [179] 
.const [65] = Method [180] [181] 
.const [66] = Field [182] [183] 
.const [67] = Field [184] [185] 
.const [68] = Field [186] [187] 
.const [69] = Method [188] [189] 
.const [70] = Method [190] [191] 
.const [71] = Method [192] [193] 
.const [72] = Method [194] [195] 
.const [73] = Class [196] 
.const [74] = Field [197] [198] 
.const [75] = Field [199] [200] 
.const [76] = Class [201] 
.const [77] = InterfaceMethod [202] [203] 
.const [78] = Class [204] 
.const [79] = Field [205] [206] 
.const [80] = Class [207] 
.const [81] = InterfaceMethod [208] [209] 
.const [82] = Field [210] [211] 
.const [83] = Field [212] [213] 
.const [84] = InterfaceMethod [214] [215] 
.const [85] = InterfaceMethod [216] [217] 
.const [86] = InterfaceMethod [218] [219] 
.const [87] = InterfaceMethod [220] [221] 
.const [88] = InterfaceMethod [222] [223] 
.const [89] = InterfaceMethod [224] [225] 
.const [90] = InterfaceMethod [226] [227] 
.const [91] = InterfaceMethod [228] [229] 
.const [92] = Class [230] 
.const [93] = NameAndType [231] [232] 
.const [94] = Class [233] 
.const [95] = NameAndType [234] [235] 
.const [96] = Utf8 java/lang/ClassNotFoundException 
.const [97] = Utf8 java/lang/NoClassDefFoundError 
.const [98] = Utf8 java/util/Hashtable 
.const [99] = Utf8 AUDIO_CLIENT_ID 
.const [100] = Class [236] 
.const [101] = NameAndType [237] [238] 
.const [102] = Class [239] 
.const [103] = NameAndType [240] [241] 
.const [104] = Utf8 'de.audi.atip.audio.HMIAudioServiceListener' 
.const [105] = Class [242] 
.const [106] = NameAndType [243] [244] 
.const [107] = Utf8 org/osgi/util/tracker/ServiceTracker 
.const [108] = Utf8 java/lang/String 
.const [109] = Class [245] 
.const [110] = NameAndType [246] [247] 
.const [111] = Utf8 'de.audi.tghu.waveplayer.WavePlayer' 
.const [112] = Class [248] 
.const [113] = NameAndType [249] [250] 
.const [114] = Utf8 'de.audi.atip.audio.HMIAudioService' 
.const [115] = Utf8 'BeepHandler#registerSystemTonePlayer' 
.const [116] = Utf8 de/eso/widgets/preset/BeepHandler$MyWavePlayerListener 
.const [117] = Utf8 'BeepHandler#requestBeep' 
.const [118] = Utf8 java/lang/Exception 
.const [119] = Utf8 'BeepHandler#playBeep' 
.const [120] = Utf8 'BeepHandler#SystemTonePlayer systemTone is null!' 
.const [121] = Utf8 'BeepHandler#updateAMAvailable available=%1' 
.const [122] = Utf8 'BeepHandler#stopConnection connection=%1' 
.const [123] = Utf8 'BeepHandler#pauseConnection connection=%1' 
.const [124] = Utf8 'BeepHandler#startConnection now fade to connection=%2 if systemToneRequested(%1)' 
.const [125] = Utf8 'BeepHandler#errorConnection connection=%1, errorCode=%2' 
.const [126] = Utf8 'BeepHandler#fadeIn now play beep if systemToneRequested(%1)(connection=%2)' 
.const [127] = Utf8 de/audi/atip/audio/HMIAudioService 
.const [128] = Utf8 de/audi/tghu/waveplayer/WavePlayer 
.const [129] = Class [251] 
.const [130] = NameAndType [252] [253] 
.const [131] = Utf8 de/eso/widgets/preset/BeepHandler 
.const [132] = Utf8 java/lang/Object 
.const [133] = Utf8 java/lang/Class 
.const [134] = Utf8 org/osgi/framework/BundleContext 
.const [135] = Utf8 de/audi/atip/log/LogChannel 
.const [136] = Utf8 de/audi/tghu/waveplayer/SystemTonePlayer 
.const [137] = Utf8 org/osgi/framework/ServiceReference 
.const [138] = Utf8 java/lang/Integer 
.const [139] = Utf8 de/esolutions/hmi/widgets/audi/base/IWidgetLogChannel 
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
.const [192] = Class [332] 
.const [193] = NameAndType [333] [334] 
.const [194] = Class [335] 
.const [195] = NameAndType [336] [337] 
.const [196] = Utf8 java/lang/NoClassDefFoundError 
.const [197] = Class [338] 
.const [198] = NameAndType [339] [340] 
.const [199] = Class [341] 
.const [200] = NameAndType [342] [343] 
.const [201] = Utf8 java/util/Hashtable 
.const [202] = Class [344] 
.const [203] = NameAndType [345] [346] 
.const [204] = Utf8 org/osgi/util/tracker/ServiceTracker 
.const [205] = Class [347] 
.const [206] = NameAndType [348] [349] 
.const [207] = Utf8 de/eso/widgets/preset/BeepHandler$MyWavePlayerListener 
.const [208] = Class [350] 
.const [209] = NameAndType [351] [352] 
.const [210] = Class [353] 
.const [211] = NameAndType [354] [355] 
.const [212] = Class [356] 
.const [213] = NameAndType [357] [358] 
.const [214] = Class [359] 
.const [215] = NameAndType [360] [361] 
.const [216] = Class [362] 
.const [217] = NameAndType [363] [364] 
.const [218] = Class [365] 
.const [219] = NameAndType [366] [367] 
.const [220] = Class [368] 
.const [221] = NameAndType [369] [370] 
.const [222] = Class [371] 
.const [223] = NameAndType [372] [373] 
.const [224] = Class [374] 
.const [225] = NameAndType [375] [376] 
.const [226] = Class [377] 
.const [227] = NameAndType [378] [379] 
.const [228] = Class [380] 
.const [229] = NameAndType [381] [382] 
.const [230] = Utf8 de/eso/widgets/preset/BeepHandler 
.const [231] = Utf8 lc 
.const [232] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [233] = Utf8 java/lang/Class 
.const [234] = Utf8 forName 
.const [235] = Utf8 (Ljava/lang/String;)Ljava/lang/Class; 
.const [236] = Utf8 de/audi/atip/audio/HMIAudioService 
.const [237] = Utf8 CLIENT_TTS_TOUCHPAD 
.const [238] = Utf8 Ljava/lang/Integer; 
.const [239] = Utf8 de/eso/widgets/preset/BeepHandler 
.const [240] = Utf8 class$de$audi$atip$audio$HMIAudioServiceListener 
.const [241] = Utf8 Ljava/lang/Class; 
.const [242] = Utf8 de/eso/widgets/preset/BeepHandler 
.const [243] = Utf8 class$ 
.const [244] = Utf8 (Ljava/lang/String;)Ljava/lang/Class; 
.const [245] = Utf8 de/eso/widgets/preset/BeepHandler 
.const [246] = Utf8 class$de$audi$tghu$waveplayer$WavePlayer 
.const [247] = Utf8 Ljava/lang/Class; 
.const [248] = Utf8 de/eso/widgets/preset/BeepHandler 
.const [249] = Utf8 class$de$audi$atip$audio$HMIAudioService 
.const [250] = Utf8 Ljava/lang/Class; 
.const [251] = Utf8 de/esolutions/hmi/widgets/audi/base/IWidgetLogChannel 
.const [252] = Utf8 logPreset 
.const [253] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [254] = Utf8 java/lang/NoClassDefFoundError 
.const [255] = Utf8 initCause 
.const [256] = Utf8 (Ljava/lang/Throwable;)Ljava/lang/Throwable; 
.const [257] = Utf8 de/eso/widgets/preset/BeepHandler 
.const [258] = Utf8 systemToneRequested 
.const [259] = Utf8 Z 
.const [260] = Utf8 de/eso/widgets/preset/BeepHandler 
.const [261] = Utf8 bundleContext 
.const [262] = Utf8 Lorg/osgi/framework/BundleContext; 
.const [263] = Utf8 java/util/Hashtable 
.const [264] = Utf8 put 
.const [265] = Utf8 (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object; 
.const [266] = Utf8 java/lang/Class 
.const [267] = Utf8 getName 
.const [268] = Utf8 ()Ljava/lang/String; 
.const [269] = Utf8 de/eso/widgets/preset/BeepHandler 
.const [270] = Utf8 tracker 
.const [271] = Utf8 Lorg/osgi/util/tracker/ServiceTracker; 
.const [272] = Utf8 org/osgi/util/tracker/ServiceTracker 
.const [273] = Utf8 'open' 
.const [274] = Utf8 ()V 
.const [275] = Utf8 de/audi/atip/log/LogChannel 
.const [276] = Utf8 log 
.const [277] = Utf8 (ILjava/lang/String;)Z 
.const [278] = Utf8 de/eso/widgets/preset/BeepHandler 
.const [279] = Utf8 systemTone 
.const [280] = Utf8 Lde/audi/tghu/waveplayer/SystemTonePlayer; 
.const [281] = Utf8 de/eso/widgets/preset/BeepHandler 
.const [282] = Utf8 audioService 
.const [283] = Utf8 Lde/audi/atip/audio/HMIAudioService; 
.const [284] = Utf8 de/audi/atip/log/LogChannel 
.const [285] = Utf8 log 
.const [286] = Utf8 (ILjava/lang/String;Ljava/lang/Throwable;)Z 
.const [287] = Utf8 de/audi/atip/log/LogChannel 
.const [288] = Utf8 log 
.const [289] = Utf8 (ILjava/lang/String;Z)Z 
.const [290] = Utf8 de/audi/atip/log/LogChannel 
.const [291] = Utf8 log 
.const [292] = Utf8 (ILjava/lang/String;J)Z 
.const [293] = Utf8 de/audi/atip/log/LogChannel 
.const [294] = Utf8 log 
.const [295] = Utf8 (ILjava/lang/String;ZJ)Z 
.const [296] = Utf8 de/audi/atip/log/LogChannel 
.const [297] = Utf8 log 
.const [298] = Utf8 (ILjava/lang/String;JJ)Z 
.const [299] = Utf8 java/lang/Integer 
.const [300] = Utf8 equals 
.const [301] = Utf8 (Ljava/lang/Object;)Z 
.const [302] = Utf8 de/eso/widgets/preset/BeepHandler 
.const [303] = Utf8 releaseAudio 
.const [304] = Utf8 ()V 
.const [305] = Utf8 de/eso/widgets/preset/BeepHandler 
.const [306] = Utf8 lc 
.const [307] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [308] = Utf8 java/lang/NoClassDefFoundError 
.const [309] = Utf8 <init> 
.const [310] = Utf8 ()V 
.const [311] = Utf8 java/lang/Object 
.const [312] = Utf8 <init> 
.const [313] = Utf8 ()V 
.const [314] = Utf8 java/util/Hashtable 
.const [315] = Utf8 <init> 
.const [316] = Utf8 ()V 
.const [317] = Utf8 de/eso/widgets/preset/BeepHandler 
.const [318] = Utf8 class$de$audi$atip$audio$HMIAudioServiceListener 
.const [319] = Utf8 Ljava/lang/Class; 
.const [320] = Utf8 de/eso/widgets/preset/BeepHandler 
.const [321] = Utf8 class$de$audi$tghu$waveplayer$WavePlayer 
.const [322] = Utf8 Ljava/lang/Class; 
.const [323] = Utf8 de/eso/widgets/preset/BeepHandler 
.const [324] = Utf8 class$de$audi$atip$audio$HMIAudioService 
.const [325] = Utf8 Ljava/lang/Class; 
.const [326] = Utf8 org/osgi/util/tracker/ServiceTracker 
.const [327] = Utf8 <init> 
.const [328] = Utf8 (Lorg/osgi/framework/BundleContext;[Ljava/lang/String;Lorg/osgi/util/tracker/ServiceTrackerCustomizer;)V 
.const [329] = Utf8 de/eso/widgets/preset/BeepHandler$MyWavePlayerListener 
.const [330] = Utf8 <init> 
.const [331] = Utf8 (Lde/eso/widgets/preset/BeepHandler;Lde/eso/widgets/preset/BeepHandler$1;)V 
.const [332] = Utf8 de/eso/widgets/preset/BeepHandler 
.const [333] = Utf8 playBeep 
.const [334] = Utf8 ()V 
.const [335] = Utf8 de/eso/widgets/preset/BeepHandler 
.const [336] = Utf8 registerSystemTonePlayer 
.const [337] = Utf8 (Lde/audi/tghu/waveplayer/SystemTonePlayer;)V 
.const [338] = Utf8 de/eso/widgets/preset/BeepHandler 
.const [339] = Utf8 systemToneRequested 
.const [340] = Utf8 Z 
.const [341] = Utf8 de/eso/widgets/preset/BeepHandler 
.const [342] = Utf8 bundleContext 
.const [343] = Utf8 Lorg/osgi/framework/BundleContext; 
.const [344] = Utf8 org/osgi/framework/BundleContext 
.const [345] = Utf8 registerService 
.const [346] = Utf8 (Ljava/lang/String;Ljava/lang/Object;Ljava/util/Dictionary;)Lorg/osgi/framework/ServiceRegistration; 
.const [347] = Utf8 de/eso/widgets/preset/BeepHandler 
.const [348] = Utf8 tracker 
.const [349] = Utf8 Lorg/osgi/util/tracker/ServiceTracker; 
.const [350] = Utf8 de/audi/tghu/waveplayer/SystemTonePlayer 
.const [351] = Utf8 setListener 
.const [352] = Utf8 (Lde/audi/tghu/waveplayer/WavePlayerListener;)V 
.const [353] = Utf8 de/eso/widgets/preset/BeepHandler 
.const [354] = Utf8 systemTone 
.const [355] = Utf8 Lde/audi/tghu/waveplayer/SystemTonePlayer; 
.const [356] = Utf8 de/eso/widgets/preset/BeepHandler 
.const [357] = Utf8 audioService 
.const [358] = Utf8 Lde/audi/atip/audio/HMIAudioService; 
.const [359] = Utf8 de/audi/atip/audio/HMIAudioService 
.const [360] = Utf8 requestConnection 
.const [361] = Utf8 (I)V 
.const [362] = Utf8 de/audi/tghu/waveplayer/SystemTonePlayer 
.const [363] = Utf8 playTone 
.const [364] = Utf8 (II)V 
.const [365] = Utf8 de/audi/atip/audio/HMIAudioService 
.const [366] = Utf8 releaseConnection 
.const [367] = Utf8 (I)V 
.const [368] = Utf8 de/audi/atip/audio/HMIAudioService 
.const [369] = Utf8 fadeToConnection 
.const [370] = Utf8 (I)V 
.const [371] = Utf8 org/osgi/framework/BundleContext 
.const [372] = Utf8 getService 
.const [373] = Utf8 (Lorg/osgi/framework/ServiceReference;)Ljava/lang/Object; 
.const [374] = Utf8 org/osgi/framework/ServiceReference 
.const [375] = Utf8 getProperty 
.const [376] = Utf8 (Ljava/lang/String;)Ljava/lang/Object; 
.const [377] = Utf8 org/osgi/framework/BundleContext 
.const [378] = Utf8 ungetService 
.const [379] = Utf8 (Lorg/osgi/framework/ServiceReference;)Z 
.const [380] = Utf8 de/audi/tghu/waveplayer/WavePlayer 
.const [381] = Utf8 getSystemTonePlayer 
.const [382] = Utf8 ()Lde/audi/tghu/waveplayer/SystemTonePlayer; 
.const [383] = Utf8 de/eso/widgets/preset/BeepHandler 
.const [384] = Class [383] 
.const [385] = Utf8 java/lang/Object 
.const [386] = Class [385] 
.const [387] = Utf8 de/audi/atip/audio/HMIAudioServiceListener 
.const [388] = Class [387] 
.const [389] = Utf8 org/osgi/util/tracker/ServiceTrackerCustomizer 
.const [390] = Class [389] 
.const [391] = Utf8 lc 
.const [392] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [393] = Utf8 audioService 
.const [394] = Utf8 Lde/audi/atip/audio/HMIAudioService; 
.const [395] = Utf8 systemTone 
.const [396] = Utf8 Lde/audi/tghu/waveplayer/SystemTonePlayer; 
.const [397] = Utf8 tracker 
.const [398] = Utf8 Lorg/osgi/util/tracker/ServiceTracker; 
.const [399] = Utf8 systemToneRequested 
.const [400] = Utf8 Z 
.const [401] = Utf8 bundleContext 
.const [402] = Utf8 Lorg/osgi/framework/BundleContext; 
.const [403] = Utf8 class$de$audi$atip$audio$HMIAudioServiceListener 
.const [404] = Utf8 Ljava/lang/Class; 
.const [405] = Utf8 class$de$audi$tghu$waveplayer$WavePlayer 
.const [406] = Utf8 Ljava/lang/Class; 
.const [407] = Utf8 class$de$audi$atip$audio$HMIAudioService 
.const [408] = Utf8 Ljava/lang/Class; 
.const [409] = Utf8 Code 
.const [410] = Utf8 <init> 
.const [411] = Utf8 (Lorg/osgi/framework/BundleContext;)V 
.const [412] = Utf8 registerSystemTonePlayer 
.const [413] = Utf8 (Lde/audi/tghu/waveplayer/SystemTonePlayer;)V 
.const [414] = Utf8 requestBeep 
.const [415] = Utf8 ()V 
.const [416] = Utf8 playBeep 
.const [417] = Utf8 ()V 
.const [418] = Utf8 releaseAudio 
.const [419] = Utf8 ()V 
.const [420] = Utf8 updateAMAvailable 
.const [421] = Utf8 (Z)V 
.const [422] = Utf8 stopConnection 
.const [423] = Utf8 (II)V 
.const [424] = Utf8 pauseConnection 
.const [425] = Utf8 (II)V 
.const [426] = Utf8 startConnection 
.const [427] = Utf8 (II)V 
.const [428] = Utf8 errorConnection 
.const [429] = Utf8 (III)V 
.const [430] = Utf8 fadedIn 
.const [431] = Utf8 (II)V 
.const [432] = Utf8 addingService 
.const [433] = Utf8 (Lorg/osgi/framework/ServiceReference;)Ljava/lang/Object; 
.const [434] = Utf8 modifiedService 
.const [435] = Utf8 (Lorg/osgi/framework/ServiceReference;Ljava/lang/Object;)V 
.const [436] = Utf8 removedService 
.const [437] = Utf8 (Lorg/osgi/framework/ServiceReference;Ljava/lang/Object;)V 
.const [438] = Utf8 updateVolumeLock 
.const [439] = Utf8 (IIZ)V 
.const [440] = Utf8 class$ 
.const [441] = Utf8 (Ljava/lang/String;)Ljava/lang/Class; 
.const [442] = Utf8 access$100 
.const [443] = Utf8 ()Lde/audi/atip/log/LogChannel; 
.const [444] = Utf8 access$200 
.const [445] = Utf8 (Lde/eso/widgets/preset/BeepHandler;)V 
.const [446] = Utf8 <clinit> 
.const [447] = Utf8 ()V 
.end class 
