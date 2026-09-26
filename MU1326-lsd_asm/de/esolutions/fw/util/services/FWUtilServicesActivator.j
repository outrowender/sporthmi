.version 50 0 
.class public final super [447] 
.super [449] 
.implements [451] 
.field private [452] [453] 
.field private [454] [455] 
.field private [456] [457] 
.field private [458] [459] 
.field private [460] [461] 
.field private [462] [463] 
.field private [464] [465] 
.field private [466] [467] 
.field private [468] [469] 
.field private [470] [471] 
.field static synthetic [472] [473] 
.field static synthetic [474] [475] 
.field static synthetic [476] [477] 
.field static synthetic [478] [479] 
.field static synthetic [480] [481] 

.method public annotation [483] : [484] 
    .attribute [482] .code stack 1 locals 0 
L0:     aload_0 
L1:     invokespecial [62] 
L4:     return 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [485] : [486] 
    .attribute [482] .code stack 7 locals 1 
L0:     ldc [5] 
L2:     invokestatic [6] 
        .catch [11] from L5 to L63 using L66 
L5:     aload_0 
L6:     aload_1 
L7:     getstatic [7] 
L10:    ifnonnull L25 
L13:    ldc [8] 
L15:    invokestatic [9] 
L18:    dup 
L19:    putstatic [63] 
L22:    goto L28 
L25:    getstatic [7] 
L28:    invokevirtual [45] 
L31:    invokeinterface [78] 0 
L36:    putfield [79] 
L39:    aload_0 
L40:    getfield [46] 
L43:    ifnull L63 
L46:    aload_0 
L47:    aload_1 
L48:    aload_0 
L49:    getfield [46] 
L52:    invokeinterface [80] 0 
L57:    checkcast [10] 
L60:    putfield [81] 
L63:    goto L67 
L66:    astore_2 
L67:    aload_0 
L68:    getfield [47] 
L71:    ifnonnull L85 
L74:    aload_0 
L75:    new [82] 
L78:    dup 
L79:    invokespecial [64] 
L82:    putfield [81] 
L85:    aload_0 
L86:    new [83] 
L89:    dup 
L90:    invokespecial [65] 
L93:    putfield [84] 
L96:    aload_0 
L97:    aload_1 
L98:    aload_0 
L99:    getfield [48] 
L102:   invokespecial [66] 
L105:   aload_0 
L106:   new [85] 
L109:   dup 
L110:   aload_0 
L111:   getfield [48] 
L114:   invokevirtual [49] 
L117:   aload_0 
L118:   getfield [47] 
L121:   invokespecial [67] 
L124:   putfield [86] 
L127:   aload_0 
L128:   aload_1 
L129:   getstatic [15] 
L132:   ifnonnull L147 
L135:   ldc [16] 
L137:   invokestatic [9] 
L140:   dup 
L141:   putstatic [68] 
L144:   goto L150 
L147:   getstatic [15] 
L150:   invokevirtual [45] 
L153:   aload_0 
L154:   getfield [50] 
L157:   new [87] 
L160:   dup 
L161:   invokespecial [69] 
L164:   invokeinterface [88] 0 
L169:   putfield [89] 
L172:   aload_0 
L173:   aload_1 
L174:   getstatic [18] 
L177:   ifnonnull L192 
L180:   ldc [19] 
L182:   invokestatic [9] 
L185:   dup 
L186:   putstatic [70] 
L189:   goto L195 
L192:   getstatic [18] 
L195:   invokevirtual [45] 
L198:   aload_0 
L199:   getfield [50] 
L202:   aconst_null 
L203:   invokeinterface [88] 0 
L208:   putfield [90] 
L211:   aload_0 
L212:   new [91] 
L215:   dup 
L216:   aload_0 
L217:   getfield [48] 
L220:   invokevirtual [53] 
L223:   aload_0 
L224:   getfield [47] 
L227:   aload_0 
L228:   getfield [50] 
L231:   aload_1 
L232:   invokespecial [71] 
L235:   putfield [92] 
L238:   aload_0 
L239:   getfield [48] 
L242:   invokevirtual [55] 
L245:   ifeq L277 
        .catch [23] from L248 to L257 using L260 
L248:   ldc [21] 
L250:   invokestatic [2] 
L253:   pop 
L254:   invokestatic [22] 
L257:   goto L289 
L260:   astore_2 
L261:   getstatic [24] 
L264:   iconst_2 
L265:   ldc [25] 
L267:   aload_2 
L268:   invokeinterface [93] 0 
L273:   pop 
L274:   goto L289 
L277:   getstatic [24] 
L280:   iconst_2 
L281:   ldc [26] 
L283:   invokeinterface [94] 0 
L288:   pop 
L289:   aload_0 
L290:   aload_1 
L291:   getstatic [27] 
L294:   ifnonnull L309 
L297:   ldc [28] 
L299:   invokestatic [9] 
L302:   dup 
L303:   putstatic [72] 
L306:   goto L312 
L309:   getstatic [27] 
L312:   invokevirtual [45] 
L315:   aload_0 
L316:   getfield [54] 
L319:   new [87] 
L322:   dup 
L323:   invokespecial [69] 
L326:   invokeinterface [88] 0 
L331:   putfield [95] 
L334:   invokestatic [29] 
L337:   astore_2 
L338:   aload_2 
L339:   ifnull L356 
L342:   aload_2 
L343:   ldc [30] 
L345:   new [96] 
L348:   dup 
L349:   invokespecial [73] 
L352:   invokevirtual [57] 
L355:   pop 
L356:   return 
L357:   nop 
L358:   nop 
L359:   nop 
L360:   
    .end code 
.end method 

.method public [487] : [488] 
    .attribute [482] .code stack 2 locals 0 
L0:     aload_0 
L1:     invokespecial [74] 
L4:     aload_0 
L5:     getfield [56] 
L8:     ifnull L20 
L11:    aload_0 
L12:    getfield [56] 
L15:    invokeinterface [97] 0 
L20:    aload_0 
L21:    getfield [51] 
L24:    ifnull L36 
L27:    aload_0 
L28:    getfield [51] 
L31:    invokeinterface [97] 0 
L36:    aload_0 
L37:    getfield [52] 
L40:    ifnull L52 
L43:    aload_0 
L44:    getfield [52] 
L47:    invokeinterface [97] 0 
L52:    aload_0 
L53:    getfield [46] 
L56:    ifnull L70 
L59:    aload_1 
L60:    aload_0 
L61:    getfield [46] 
L64:    invokeinterface [98] 0 
L69:    pop 
L70:    aload_0 
L71:    aconst_null 
L72:    putfield [92] 
L75:    aload_0 
L76:    aconst_null 
L77:    putfield [95] 
L80:    aload_0 
L81:    aconst_null 
L82:    putfield [90] 
L85:    aload_0 
L86:    aconst_null 
L87:    putfield [86] 
L90:    aload_0 
L91:    aconst_null 
L92:    putfield [89] 
L95:    aload_0 
L96:    aconst_null 
L97:    putfield [84] 
L100:   aload_0 
L101:   aconst_null 
L102:   putfield [79] 
L105:   aload_0 
L106:   aconst_null 
L107:   putfield [81] 
L110:   aload_0 
L111:   aconst_null 
L112:   putfield [99] 
L115:   return 
L116:   
    .end code 
.end method 

.method private [489] : [490] 
    .attribute [482] .code stack 6 locals 1 
L0:     aload_2 
L1:     invokevirtual [59] 
L4:     istore_3 
L5:     aload_0 
L6:     new [100] 
L9:     dup 
L10:    iload_3 
L11:    invokespecial [75] 
L14:    putfield [99] 
L17:    aload_0 
L18:    aload_1 
L19:    getstatic [33] 
L22:    ifnonnull L37 
L25:    ldc [34] 
L27:    invokestatic [9] 
L30:    dup 
L31:    putstatic [76] 
L34:    goto L40 
L37:    getstatic [33] 
L40:    invokevirtual [45] 
L43:    aload_0 
L44:    getfield [58] 
L47:    new [87] 
L50:    dup 
L51:    invokespecial [69] 
L54:    invokeinterface [88] 0 
L59:    putfield [101] 
L62:    return 
L63:    nop 
L64:    
    .end code 
.end method 

.method private [491] : [492] 
    .attribute [482] .code stack 2 locals 0 
L0:     aload_0 
L1:     getfield [60] 
L4:     ifnull L21 
L7:     aload_0 
L8:     getfield [60] 
L11:    invokeinterface [97] 0 
L16:    aload_0 
L17:    aconst_null 
L18:    putfield [101] 
L21:    aload_0 
L22:    aconst_null 
L23:    putfield [99] 
L26:    return 
L27:    nop 
L28:    
    .end code 
.end method 

.method static synthetic [493] : [494] 
    .attribute [482] .code stack 2 locals 1 
        .catch [3] from L0 to L4 using L5 
L0:     aload_0 
L1:     invokestatic [2] 
L4:     areturn 
L5:     astore_1 
L6:     new [77] 
L9:     dup 
L10:    invokespecial [61] 
L13:    aload_1 
L14:    invokevirtual [44] 
L17:    athrow 
L18:    nop 
L19:    nop 
L20:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Method [102] [103] 
.const [3] = Class [104] 
.const [4] = Class [105] 
.const [5] = String [106] 
.const [6] = Method [107] [108] 
.const [7] = Field [109] [110] 
.const [8] = String [111] 
.const [9] = Method [112] [113] 
.const [10] = Class [114] 
.const [11] = Class [115] 
.const [12] = Class [116] 
.const [13] = Class [117] 
.const [14] = Class [118] 
.const [15] = Field [119] [120] 
.const [16] = String [121] 
.const [17] = Class [122] 
.const [18] = Field [123] [124] 
.const [19] = String [125] 
.const [20] = Class [126] 
.const [21] = String [127] 
.const [22] = Method [128] [129] 
.const [23] = Class [130] 
.const [24] = Field [131] [132] 
.const [25] = String [133] 
.const [26] = String [134] 
.const [27] = Field [135] [136] 
.const [28] = String [137] 
.const [29] = Method [138] [139] 
.const [30] = String [140] 
.const [31] = Class [141] 
.const [32] = Class [142] 
.const [33] = Field [143] [144] 
.const [34] = String [145] 
.const [35] = Class [146] 
.const [36] = Class [147] 
.const [37] = Class [148] 
.const [38] = Class [149] 
.const [39] = Class [150] 
.const [40] = Class [151] 
.const [41] = Class [152] 
.const [42] = Class [153] 
.const [43] = Class [154] 
.const [44] = Method [155] [156] 
.const [45] = Method [157] [158] 
.const [46] = Field [159] [160] 
.const [47] = Field [161] [162] 
.const [48] = Field [163] [164] 
.const [49] = Method [165] [166] 
.const [50] = Field [167] [168] 
.const [51] = Field [169] [170] 
.const [52] = Field [171] [172] 
.const [53] = Method [173] [174] 
.const [54] = Field [175] [176] 
.const [55] = Method [177] [178] 
.const [56] = Field [179] [180] 
.const [57] = Method [181] [182] 
.const [58] = Field [183] [184] 
.const [59] = Method [185] [186] 
.const [60] = Field [187] [188] 
.const [61] = Method [189] [190] 
.const [62] = Method [191] [192] 
.const [63] = Field [193] [194] 
.const [64] = Method [195] [196] 
.const [65] = Method [197] [198] 
.const [66] = Method [199] [200] 
.const [67] = Method [201] [202] 
.const [68] = Field [203] [204] 
.const [69] = Method [205] [206] 
.const [70] = Field [207] [208] 
.const [71] = Method [209] [210] 
.const [72] = Field [211] [212] 
.const [73] = Method [213] [214] 
.const [74] = Method [215] [216] 
.const [75] = Method [217] [218] 
.const [76] = Field [219] [220] 
.const [77] = Class [221] 
.const [78] = InterfaceMethod [222] [223] 
.const [79] = Field [224] [225] 
.const [80] = InterfaceMethod [226] [227] 
.const [81] = Field [228] [229] 
.const [82] = Class [230] 
.const [83] = Class [231] 
.const [84] = Field [232] [233] 
.const [85] = Class [234] 
.const [86] = Field [235] [236] 
.const [87] = Class [237] 
.const [88] = InterfaceMethod [238] [239] 
.const [89] = Field [240] [241] 
.const [90] = Field [242] [243] 
.const [91] = Class [244] 
.const [92] = Field [245] [246] 
.const [93] = InterfaceMethod [247] [248] 
.const [94] = InterfaceMethod [249] [250] 
.const [95] = Field [251] [252] 
.const [96] = Class [253] 
.const [97] = InterfaceMethod [254] [255] 
.const [98] = InterfaceMethod [256] [257] 
.const [99] = Field [258] [259] 
.const [100] = Class [260] 
.const [101] = Field [261] [262] 
.const [102] = Class [263] 
.const [103] = NameAndType [264] [265] 
.const [104] = Utf8 java/lang/ClassNotFoundException 
.const [105] = Utf8 java/lang/NoClassDefFoundError 
.const [106] = Utf8 hmi 
.const [107] = Class [266] 
.const [108] = NameAndType [267] [268] 
.const [109] = Class [269] 
.const [110] = NameAndType [270] [271] 
.const [111] = Utf8 'de.esolutions.fw.util.commons.timeout.ITimeSource' 
.const [112] = Class [272] 
.const [113] = NameAndType [273] [274] 
.const [114] = Utf8 de/esolutions/fw/util/commons/timeout/ITimeSource 
.const [115] = Utf8 java/lang/ClassCastException 
.const [116] = Utf8 de/esolutions/fw/util/commons/timeout/SystemTimeSource 
.const [117] = Utf8 de/esolutions/fw/util/services/ServicesConfigProvider 
.const [118] = Utf8 de/esolutions/fw/util/services/threading/ThreadPoolManager 
.const [119] = Class [275] 
.const [120] = NameAndType [276] [277] 
.const [121] = Utf8 'de.esolutions.fw.util.commons.threading.IThreadPoolManager' 
.const [122] = Utf8 java/util/Hashtable 
.const [123] = Class [278] 
.const [124] = NameAndType [279] [280] 
.const [125] = Utf8 'de.esolutions.fw.util.commons.error.DumpInfoProvider' 
.const [126] = Utf8 de/esolutions/fw/util/services/job/DispatcherManager 
.const [127] = Utf8 'com.microdoc.j9.IGCListener' 
.const [128] = Class [281] 
.const [129] = NameAndType [282] [283] 
.const [130] = Utf8 java/lang/Throwable 
.const [131] = Class [284] 
.const [132] = NameAndType [285] [286] 
.const [133] = Utf8 'garbage collector tracing is not available! reason=%1' 
.const [134] = Utf8 'garbage collector tracing is not activated' 
.const [135] = Class [287] 
.const [136] = NameAndType [288] [289] 
.const [137] = Utf8 'de.esolutions.fw.util.commons.job.IDispatcherManager' 
.const [138] = Class [290] 
.const [139] = NameAndType [291] [292] 
.const [140] = Utf8 test_recurse 
.const [141] = Utf8 de/esolutions/fw/util/services/RecurseErrorTestCallback 
.const [142] = Utf8 de/esolutions/fw/util/commons/error/DefaultFatalErrorHandler 
.const [143] = Class [293] 
.const [144] = NameAndType [294] [295] 
.const [145] = Utf8 'de.esolutions.fw.util.commons.error.IFatalErrorHandler' 
.const [146] = Utf8 de/esolutions/fw/util/services/FWUtilServicesActivator 
.const [147] = Utf8 java/lang/Object 
.const [148] = Utf8 java/lang/Class 
.const [149] = Utf8 de/esolutions/fw/util/tracing/TraceClient 
.const [150] = Utf8 org/osgi/framework/BundleContext 
.const [151] = Utf8 de/esolutions/fw/util/services/gctracing/GCTracing 
.const [152] = Utf8 de/esolutions/fw/util/services/tracing/FwServicesTracing 
.const [153] = Utf8 de/esolutions/fw/util/commons/tracing/ITraceChannel 
.const [154] = Utf8 org/osgi/framework/ServiceRegistration 
.const [155] = Class [296] 
.const [156] = NameAndType [297] [298] 
.const [157] = Class [299] 
.const [158] = NameAndType [300] [301] 
.const [159] = Class [302] 
.const [160] = NameAndType [303] [304] 
.const [161] = Class [305] 
.const [162] = NameAndType [306] [307] 
.const [163] = Class [308] 
.const [164] = NameAndType [309] [310] 
.const [165] = Class [311] 
.const [166] = NameAndType [312] [313] 
.const [167] = Class [314] 
.const [168] = NameAndType [315] [316] 
.const [169] = Class [317] 
.const [170] = NameAndType [318] [319] 
.const [171] = Class [320] 
.const [172] = NameAndType [321] [322] 
.const [173] = Class [323] 
.const [174] = NameAndType [324] [325] 
.const [175] = Class [326] 
.const [176] = NameAndType [327] [328] 
.const [177] = Class [329] 
.const [178] = NameAndType [330] [331] 
.const [179] = Class [332] 
.const [180] = NameAndType [333] [334] 
.const [181] = Class [335] 
.const [182] = NameAndType [336] [337] 
.const [183] = Class [338] 
.const [184] = NameAndType [339] [340] 
.const [185] = Class [341] 
.const [186] = NameAndType [342] [343] 
.const [187] = Class [344] 
.const [188] = NameAndType [345] [346] 
.const [189] = Class [347] 
.const [190] = NameAndType [348] [349] 
.const [191] = Class [350] 
.const [192] = NameAndType [351] [352] 
.const [193] = Class [353] 
.const [194] = NameAndType [354] [355] 
.const [195] = Class [356] 
.const [196] = NameAndType [357] [358] 
.const [197] = Class [359] 
.const [198] = NameAndType [360] [361] 
.const [199] = Class [362] 
.const [200] = NameAndType [363] [364] 
.const [201] = Class [365] 
.const [202] = NameAndType [366] [367] 
.const [203] = Class [368] 
.const [204] = NameAndType [369] [370] 
.const [205] = Class [371] 
.const [206] = NameAndType [372] [373] 
.const [207] = Class [374] 
.const [208] = NameAndType [375] [376] 
.const [209] = Class [377] 
.const [210] = NameAndType [378] [379] 
.const [211] = Class [380] 
.const [212] = NameAndType [381] [382] 
.const [213] = Class [383] 
.const [214] = NameAndType [384] [385] 
.const [215] = Class [386] 
.const [216] = NameAndType [387] [388] 
.const [217] = Class [389] 
.const [218] = NameAndType [390] [391] 
.const [219] = Class [392] 
.const [220] = NameAndType [393] [394] 
.const [221] = Utf8 java/lang/NoClassDefFoundError 
.const [222] = Class [395] 
.const [223] = NameAndType [396] [397] 
.const [224] = Class [398] 
.const [225] = NameAndType [399] [400] 
.const [226] = Class [401] 
.const [227] = NameAndType [402] [403] 
.const [228] = Class [404] 
.const [229] = NameAndType [405] [406] 
.const [230] = Utf8 de/esolutions/fw/util/commons/timeout/SystemTimeSource 
.const [231] = Utf8 de/esolutions/fw/util/services/ServicesConfigProvider 
.const [232] = Class [407] 
.const [233] = NameAndType [408] [409] 
.const [234] = Utf8 de/esolutions/fw/util/services/threading/ThreadPoolManager 
.const [235] = Class [410] 
.const [236] = NameAndType [411] [412] 
.const [237] = Utf8 java/util/Hashtable 
.const [238] = Class [413] 
.const [239] = NameAndType [414] [415] 
.const [240] = Class [416] 
.const [241] = NameAndType [417] [418] 
.const [242] = Class [419] 
.const [243] = NameAndType [420] [421] 
.const [244] = Utf8 de/esolutions/fw/util/services/job/DispatcherManager 
.const [245] = Class [422] 
.const [246] = NameAndType [423] [424] 
.const [247] = Class [425] 
.const [248] = NameAndType [426] [427] 
.const [249] = Class [428] 
.const [250] = NameAndType [429] [430] 
.const [251] = Class [431] 
.const [252] = NameAndType [432] [433] 
.const [253] = Utf8 de/esolutions/fw/util/services/RecurseErrorTestCallback 
.const [254] = Class [434] 
.const [255] = NameAndType [435] [436] 
.const [256] = Class [437] 
.const [257] = NameAndType [438] [439] 
.const [258] = Class [440] 
.const [259] = NameAndType [441] [442] 
.const [260] = Utf8 de/esolutions/fw/util/commons/error/DefaultFatalErrorHandler 
.const [261] = Class [443] 
.const [262] = NameAndType [444] [445] 
.const [263] = Utf8 java/lang/Class 
.const [264] = Utf8 forName 
.const [265] = Utf8 (Ljava/lang/String;)Ljava/lang/Class; 
.const [266] = Utf8 de/esolutions/fw/util/tracing/TraceClient 
.const [267] = Utf8 init 
.const [268] = Utf8 (Ljava/lang/String;)V 
.const [269] = Utf8 de/esolutions/fw/util/services/FWUtilServicesActivator 
.const [270] = Utf8 class$de$esolutions$fw$util$commons$timeout$ITimeSource 
.const [271] = Utf8 Ljava/lang/Class; 
.const [272] = Utf8 de/esolutions/fw/util/services/FWUtilServicesActivator 
.const [273] = Utf8 class$ 
.const [274] = Utf8 (Ljava/lang/String;)Ljava/lang/Class; 
.const [275] = Utf8 de/esolutions/fw/util/services/FWUtilServicesActivator 
.const [276] = Utf8 class$de$esolutions$fw$util$commons$threading$IThreadPoolManager 
.const [277] = Utf8 Ljava/lang/Class; 
.const [278] = Utf8 de/esolutions/fw/util/services/FWUtilServicesActivator 
.const [279] = Utf8 class$de$esolutions$fw$util$commons$error$DumpInfoProvider 
.const [280] = Utf8 Ljava/lang/Class; 
.const [281] = Utf8 de/esolutions/fw/util/services/gctracing/GCTracing 
.const [282] = Utf8 activate 
.const [283] = Utf8 ()V 
.const [284] = Utf8 de/esolutions/fw/util/services/tracing/FwServicesTracing 
.const [285] = Utf8 GARBAGE_COLLECTOR 
.const [286] = Utf8 Lde/esolutions/fw/util/commons/tracing/ITraceChannel; 
.const [287] = Utf8 de/esolutions/fw/util/services/FWUtilServicesActivator 
.const [288] = Utf8 class$de$esolutions$fw$util$commons$job$IDispatcherManager 
.const [289] = Utf8 Ljava/lang/Class; 
.const [290] = Utf8 de/esolutions/fw/util/tracing/TraceClient 
.const [291] = Utf8 getTraceClient 
.const [292] = Utf8 ()Lde/esolutions/fw/util/tracing/TraceClient; 
.const [293] = Utf8 de/esolutions/fw/util/services/FWUtilServicesActivator 
.const [294] = Utf8 class$de$esolutions$fw$util$commons$error$IFatalErrorHandler 
.const [295] = Utf8 Ljava/lang/Class; 
.const [296] = Utf8 java/lang/NoClassDefFoundError 
.const [297] = Utf8 initCause 
.const [298] = Utf8 (Ljava/lang/Throwable;)Ljava/lang/Throwable; 
.const [299] = Utf8 java/lang/Class 
.const [300] = Utf8 getName 
.const [301] = Utf8 ()Ljava/lang/String; 
.const [302] = Utf8 de/esolutions/fw/util/services/FWUtilServicesActivator 
.const [303] = Utf8 srefTimeSource 
.const [304] = Utf8 Lorg/osgi/framework/ServiceReference; 
.const [305] = Utf8 de/esolutions/fw/util/services/FWUtilServicesActivator 
.const [306] = Utf8 timeSource 
.const [307] = Utf8 Lde/esolutions/fw/util/commons/timeout/ITimeSource; 
.const [308] = Utf8 de/esolutions/fw/util/services/FWUtilServicesActivator 
.const [309] = Utf8 configProvider 
.const [310] = Utf8 Lde/esolutions/fw/util/services/ServicesConfigProvider; 
.const [311] = Utf8 de/esolutions/fw/util/services/ServicesConfigProvider 
.const [312] = Utf8 getThreadPoolsConfig 
.const [313] = Utf8 ()Lde/esolutions/fw/util/config/ConfigValue; 
.const [314] = Utf8 de/esolutions/fw/util/services/FWUtilServicesActivator 
.const [315] = Utf8 threadPoolManager 
.const [316] = Utf8 Lde/esolutions/fw/util/services/threading/ThreadPoolManager; 
.const [317] = Utf8 de/esolutions/fw/util/services/FWUtilServicesActivator 
.const [318] = Utf8 threadPoolManagerService 
.const [319] = Utf8 Lorg/osgi/framework/ServiceRegistration; 
.const [320] = Utf8 de/esolutions/fw/util/services/FWUtilServicesActivator 
.const [321] = Utf8 dumpInfoProvService 
.const [322] = Utf8 Lorg/osgi/framework/ServiceRegistration; 
.const [323] = Utf8 de/esolutions/fw/util/services/ServicesConfigProvider 
.const [324] = Utf8 getDispatchersConfig 
.const [325] = Utf8 ()Lde/esolutions/fw/util/config/ConfigValue; 
.const [326] = Utf8 de/esolutions/fw/util/services/FWUtilServicesActivator 
.const [327] = Utf8 dispatcherManager 
.const [328] = Utf8 Lde/esolutions/fw/util/services/job/DispatcherManager; 
.const [329] = Utf8 de/esolutions/fw/util/services/ServicesConfigProvider 
.const [330] = Utf8 getGCTracingEnabled 
.const [331] = Utf8 ()Z 
.const [332] = Utf8 de/esolutions/fw/util/services/FWUtilServicesActivator 
.const [333] = Utf8 dispatcherManagerService 
.const [334] = Utf8 Lorg/osgi/framework/ServiceRegistration; 
.const [335] = Utf8 de/esolutions/fw/util/tracing/TraceClient 
.const [336] = Utf8 registerCallback 
.const [337] = Utf8 (Ljava/lang/String;Lde/esolutions/fw/util/tracing/ITraceCallback;)I 
.const [338] = Utf8 de/esolutions/fw/util/services/FWUtilServicesActivator 
.const [339] = Utf8 fatalErrorHandler 
.const [340] = Utf8 Lde/esolutions/fw/util/commons/error/IFatalErrorHandler; 
.const [341] = Utf8 de/esolutions/fw/util/services/ServicesConfigProvider 
.const [342] = Utf8 getKillOnError 
.const [343] = Utf8 ()Z 
.const [344] = Utf8 de/esolutions/fw/util/services/FWUtilServicesActivator 
.const [345] = Utf8 fatalErrorHandlerService 
.const [346] = Utf8 Lorg/osgi/framework/ServiceRegistration; 
.const [347] = Utf8 java/lang/NoClassDefFoundError 
.const [348] = Utf8 <init> 
.const [349] = Utf8 ()V 
.const [350] = Utf8 java/lang/Object 
.const [351] = Utf8 <init> 
.const [352] = Utf8 ()V 
.const [353] = Utf8 de/esolutions/fw/util/services/FWUtilServicesActivator 
.const [354] = Utf8 class$de$esolutions$fw$util$commons$timeout$ITimeSource 
.const [355] = Utf8 Ljava/lang/Class; 
.const [356] = Utf8 de/esolutions/fw/util/commons/timeout/SystemTimeSource 
.const [357] = Utf8 <init> 
.const [358] = Utf8 ()V 
.const [359] = Utf8 de/esolutions/fw/util/services/ServicesConfigProvider 
.const [360] = Utf8 <init> 
.const [361] = Utf8 ()V 
.const [362] = Utf8 de/esolutions/fw/util/services/FWUtilServicesActivator 
.const [363] = Utf8 registerFatalErrorHandler 
.const [364] = Utf8 (Lorg/osgi/framework/BundleContext;Lde/esolutions/fw/util/services/ServicesConfigProvider;)V 
.const [365] = Utf8 de/esolutions/fw/util/services/threading/ThreadPoolManager 
.const [366] = Utf8 <init> 
.const [367] = Utf8 (Lde/esolutions/fw/util/config/ConfigValue;Lde/esolutions/fw/util/commons/timeout/ITimeSource;)V 
.const [368] = Utf8 de/esolutions/fw/util/services/FWUtilServicesActivator 
.const [369] = Utf8 class$de$esolutions$fw$util$commons$threading$IThreadPoolManager 
.const [370] = Utf8 Ljava/lang/Class; 
.const [371] = Utf8 java/util/Hashtable 
.const [372] = Utf8 <init> 
.const [373] = Utf8 ()V 
.const [374] = Utf8 de/esolutions/fw/util/services/FWUtilServicesActivator 
.const [375] = Utf8 class$de$esolutions$fw$util$commons$error$DumpInfoProvider 
.const [376] = Utf8 Ljava/lang/Class; 
.const [377] = Utf8 de/esolutions/fw/util/services/job/DispatcherManager 
.const [378] = Utf8 <init> 
.const [379] = Utf8 (Lde/esolutions/fw/util/config/ConfigValue;Lde/esolutions/fw/util/commons/timeout/ITimeSource;Lde/esolutions/fw/util/services/threading/ThreadPoolManager;Lorg/osgi/framework/BundleContext;)V 
.const [380] = Utf8 de/esolutions/fw/util/services/FWUtilServicesActivator 
.const [381] = Utf8 class$de$esolutions$fw$util$commons$job$IDispatcherManager 
.const [382] = Utf8 Ljava/lang/Class; 
.const [383] = Utf8 de/esolutions/fw/util/services/RecurseErrorTestCallback 
.const [384] = Utf8 <init> 
.const [385] = Utf8 ()V 
.const [386] = Utf8 de/esolutions/fw/util/services/FWUtilServicesActivator 
.const [387] = Utf8 unregisterFatalErrorHandler 
.const [388] = Utf8 ()V 
.const [389] = Utf8 de/esolutions/fw/util/commons/error/DefaultFatalErrorHandler 
.const [390] = Utf8 <init> 
.const [391] = Utf8 (Z)V 
.const [392] = Utf8 de/esolutions/fw/util/services/FWUtilServicesActivator 
.const [393] = Utf8 class$de$esolutions$fw$util$commons$error$IFatalErrorHandler 
.const [394] = Utf8 Ljava/lang/Class; 
.const [395] = Utf8 org/osgi/framework/BundleContext 
.const [396] = Utf8 getServiceReference 
.const [397] = Utf8 (Ljava/lang/String;)Lorg/osgi/framework/ServiceReference; 
.const [398] = Utf8 de/esolutions/fw/util/services/FWUtilServicesActivator 
.const [399] = Utf8 srefTimeSource 
.const [400] = Utf8 Lorg/osgi/framework/ServiceReference; 
.const [401] = Utf8 org/osgi/framework/BundleContext 
.const [402] = Utf8 getService 
.const [403] = Utf8 (Lorg/osgi/framework/ServiceReference;)Ljava/lang/Object; 
.const [404] = Utf8 de/esolutions/fw/util/services/FWUtilServicesActivator 
.const [405] = Utf8 timeSource 
.const [406] = Utf8 Lde/esolutions/fw/util/commons/timeout/ITimeSource; 
.const [407] = Utf8 de/esolutions/fw/util/services/FWUtilServicesActivator 
.const [408] = Utf8 configProvider 
.const [409] = Utf8 Lde/esolutions/fw/util/services/ServicesConfigProvider; 
.const [410] = Utf8 de/esolutions/fw/util/services/FWUtilServicesActivator 
.const [411] = Utf8 threadPoolManager 
.const [412] = Utf8 Lde/esolutions/fw/util/services/threading/ThreadPoolManager; 
.const [413] = Utf8 org/osgi/framework/BundleContext 
.const [414] = Utf8 registerService 
.const [415] = Utf8 (Ljava/lang/String;Ljava/lang/Object;Ljava/util/Dictionary;)Lorg/osgi/framework/ServiceRegistration; 
.const [416] = Utf8 de/esolutions/fw/util/services/FWUtilServicesActivator 
.const [417] = Utf8 threadPoolManagerService 
.const [418] = Utf8 Lorg/osgi/framework/ServiceRegistration; 
.const [419] = Utf8 de/esolutions/fw/util/services/FWUtilServicesActivator 
.const [420] = Utf8 dumpInfoProvService 
.const [421] = Utf8 Lorg/osgi/framework/ServiceRegistration; 
.const [422] = Utf8 de/esolutions/fw/util/services/FWUtilServicesActivator 
.const [423] = Utf8 dispatcherManager 
.const [424] = Utf8 Lde/esolutions/fw/util/services/job/DispatcherManager; 
.const [425] = Utf8 de/esolutions/fw/util/commons/tracing/ITraceChannel 
.const [426] = Utf8 log 
.const [427] = Utf8 (SLjava/lang/String;Ljava/lang/Object;)Z 
.const [428] = Utf8 de/esolutions/fw/util/commons/tracing/ITraceChannel 
.const [429] = Utf8 log 
.const [430] = Utf8 (SLjava/lang/String;)Z 
.const [431] = Utf8 de/esolutions/fw/util/services/FWUtilServicesActivator 
.const [432] = Utf8 dispatcherManagerService 
.const [433] = Utf8 Lorg/osgi/framework/ServiceRegistration; 
.const [434] = Utf8 org/osgi/framework/ServiceRegistration 
.const [435] = Utf8 unregister 
.const [436] = Utf8 ()V 
.const [437] = Utf8 org/osgi/framework/BundleContext 
.const [438] = Utf8 ungetService 
.const [439] = Utf8 (Lorg/osgi/framework/ServiceReference;)Z 
.const [440] = Utf8 de/esolutions/fw/util/services/FWUtilServicesActivator 
.const [441] = Utf8 fatalErrorHandler 
.const [442] = Utf8 Lde/esolutions/fw/util/commons/error/IFatalErrorHandler; 
.const [443] = Utf8 de/esolutions/fw/util/services/FWUtilServicesActivator 
.const [444] = Utf8 fatalErrorHandlerService 
.const [445] = Utf8 Lorg/osgi/framework/ServiceRegistration; 
.const [446] = Utf8 de/esolutions/fw/util/services/FWUtilServicesActivator 
.const [447] = Class [446] 
.const [448] = Utf8 java/lang/Object 
.const [449] = Class [448] 
.const [450] = Utf8 org/osgi/framework/BundleActivator 
.const [451] = Class [450] 
.const [452] = Utf8 srefTimeSource 
.const [453] = Utf8 Lorg/osgi/framework/ServiceReference; 
.const [454] = Utf8 timeSource 
.const [455] = Utf8 Lde/esolutions/fw/util/commons/timeout/ITimeSource; 
.const [456] = Utf8 configProvider 
.const [457] = Utf8 Lde/esolutions/fw/util/services/ServicesConfigProvider; 
.const [458] = Utf8 threadPoolManager 
.const [459] = Utf8 Lde/esolutions/fw/util/services/threading/ThreadPoolManager; 
.const [460] = Utf8 threadPoolManagerService 
.const [461] = Utf8 Lorg/osgi/framework/ServiceRegistration; 
.const [462] = Utf8 dumpInfoProvService 
.const [463] = Utf8 Lorg/osgi/framework/ServiceRegistration; 
.const [464] = Utf8 dispatcherManager 
.const [465] = Utf8 Lde/esolutions/fw/util/services/job/DispatcherManager; 
.const [466] = Utf8 dispatcherManagerService 
.const [467] = Utf8 Lorg/osgi/framework/ServiceRegistration; 
.const [468] = Utf8 fatalErrorHandler 
.const [469] = Utf8 Lde/esolutions/fw/util/commons/error/IFatalErrorHandler; 
.const [470] = Utf8 fatalErrorHandlerService 
.const [471] = Utf8 Lorg/osgi/framework/ServiceRegistration; 
.const [472] = Utf8 class$de$esolutions$fw$util$commons$timeout$ITimeSource 
.const [473] = Utf8 Ljava/lang/Class; 
.const [474] = Utf8 class$de$esolutions$fw$util$commons$threading$IThreadPoolManager 
.const [475] = Utf8 Ljava/lang/Class; 
.const [476] = Utf8 class$de$esolutions$fw$util$commons$error$DumpInfoProvider 
.const [477] = Utf8 Ljava/lang/Class; 
.const [478] = Utf8 class$de$esolutions$fw$util$commons$job$IDispatcherManager 
.const [479] = Utf8 Ljava/lang/Class; 
.const [480] = Utf8 class$de$esolutions$fw$util$commons$error$IFatalErrorHandler 
.const [481] = Utf8 Ljava/lang/Class; 
.const [482] = Utf8 Code 
.const [483] = Utf8 <init> 
.const [484] = Utf8 ()V 
.const [485] = Utf8 start 
.const [486] = Utf8 (Lorg/osgi/framework/BundleContext;)V 
.const [487] = Utf8 stop 
.const [488] = Utf8 (Lorg/osgi/framework/BundleContext;)V 
.const [489] = Utf8 registerFatalErrorHandler 
.const [490] = Utf8 (Lorg/osgi/framework/BundleContext;Lde/esolutions/fw/util/services/ServicesConfigProvider;)V 
.const [491] = Utf8 unregisterFatalErrorHandler 
.const [492] = Utf8 ()V 
.const [493] = Utf8 class$ 
.const [494] = Utf8 (Ljava/lang/String;)Ljava/lang/Class; 
.end class 
