.version 50 0 
.class public final super [406] 
.super [408] 
.field private volatile [409] [410] 
.field private volatile [411] [412] 
.field private volatile [413] [414] 
.field private volatile [415] [416] 
.field static synthetic [417] [418] 
.field static synthetic [419] [420] 

.method public [422] : [423] 
    .attribute [421] .code stack 3 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     ldc [7] 
L4:     invokespecial [74] 
L7:     aload_0 
L8:     ldc [8] 
L10:    putfield [86] 
L13:    aload_0 
L14:    ldc [8] 
L16:    putfield [87] 
L19:    aload_0 
L20:    ldc [8] 
L22:    putfield [88] 
L25:    aload_0 
L26:    iconst_0 
L27:    putfield [84] 
L30:    return 
L31:    nop 
L32:    
    .end code 
.end method 

.method public [424] : [425] 
    .attribute [421] .code stack 5 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     invokespecial [75] 
L5:     aload_1 
L6:     invokevirtual [52] 
L9:     new [89] 
L12:    dup 
L13:    aload_0 
L14:    aconst_null 
L15:    invokespecial [76] 
L18:    invokevirtual [53] 
L21:    return 
L22:    nop 
L23:    nop 
L24:    
    .end code 
.end method 

.method public [426] : [427] 
    .attribute [421] .code stack 4 locals 1 
        .catch [10] from L0 to L15 using L18 
L0:     aload_0 
L1:     aload_1 
L2:     invokespecial [77] 
L5:     aload_1 
L6:     aload_0 
L7:     invokespecial [78] 
L10:    invokeinterface [90] 0 
L15:    goto L33 
L18:    astore_2 
L19:    aload_0 
L20:    getfield [45] 
L23:    sipush 10000 
L26:    ldc [11] 
L28:    aload_2 
L29:    invokevirtual [54] 
L32:    pop 
L33:    return 
L34:    nop 
L35:    nop 
L36:    
    .end code 
.end method 

.method private [428] : [429] 
    .attribute [421] .code stack 5 locals 6 
L0:     new [91] 
L3:     dup 
L4:     invokespecial [79] 
L7:     astore_3 
L8:     aload_3 
L9:     invokevirtual [55] 
L12:    pop 
L13:    aload_3 
L14:    invokevirtual [56] 
L17:    pop 
L18:    aload_3 
L19:    ldc [13] 
L21:    getstatic [14] 
L24:    ifnonnull L39 
L27:    ldc [15] 
L29:    invokestatic [16] 
L32:    dup 
L33:    putstatic [80] 
L36:    goto L42 
L39:    getstatic [14] 
L42:    invokevirtual [57] 
L45:    invokevirtual [58] 
L48:    pop 
L49:    aload_3 
L50:    ldc [17] 
L52:    iconst_0 
L53:    invokestatic [18] 
L56:    invokevirtual [58] 
L59:    pop 
L60:    aload_3 
L61:    invokevirtual [59] 
L64:    pop 
L65:    aload_3 
L66:    invokevirtual [56] 
L69:    pop 
L70:    aload_3 
L71:    ldc [13] 
L73:    getstatic [19] 
L76:    ifnonnull L91 
L79:    ldc [20] 
L81:    invokestatic [16] 
L84:    dup 
L85:    putstatic [81] 
L88:    goto L94 
L91:    getstatic [19] 
L94:    invokevirtual [57] 
L97:    invokevirtual [58] 
L100:   pop 
L101:   aload_3 
L102:   ldc [17] 
L104:   iconst_0 
L105:   invokestatic [18] 
L108:   invokevirtual [58] 
L111:   pop 
L112:   aload_3 
L113:   invokevirtual [59] 
L116:   pop 
L117:   aload_3 
L118:   invokevirtual [60] 
L121:   pop 
L122:   aload_3 
L123:   invokevirtual [61] 
L126:   astore 4 
L128:   aload_0 
L129:   getfield [62] 
L132:   aload 4 
L134:   invokeinterface [92] 0 
L139:   astore 5 
L141:   new [93] 
L144:   dup 
L145:   aload_0 
L146:   aload_0 
L147:   getfield [45] 
L150:   aload_0 
L151:   getfield [62] 
L154:   invokespecial [82] 
L157:   astore 6 
L159:   new [94] 
L162:   dup 
L163:   aload_0 
L164:   getfield [62] 
L167:   aload 5 
L169:   aload 6 
L171:   invokespecial [83] 
L174:   areturn 
L175:   nop 
L176:   
    .end code 
.end method 

.method private [430] : [431] 
    .attribute [421] .code stack 4 locals 1 
L0:     aload_0 
L1:     getfield [45] 
L4:     ldc [23] 
L6:     ldc [24] 
L8:     aload_1 
L9:     invokestatic [25] 
L12:    invokevirtual [63] 
L15:    pop 
L16:    aload_1 
L17:    ifnonnull L25 
L20:    ldc [8] 
L22:    goto L26 
L25:    aload_1 
L26:    astore_2 
L27:    aload_0 
L28:    getfield [49] 
L31:    aload_2 
L32:    invokevirtual [64] 
L35:    ifne L47 
L38:    aload_0 
L39:    aload_2 
L40:    putfield [86] 
L43:    aload_0 
L44:    invokespecial [72] 
L47:    return 
L48:    
    .end code 
.end method 

.method private [432] : [433] 
    .attribute [421] .code stack 4 locals 1 
L0:     aload_0 
L1:     getfield [45] 
L4:     ldc [23] 
L6:     ldc [26] 
L8:     aload_1 
L9:     invokestatic [25] 
L12:    invokevirtual [63] 
L15:    pop 
L16:    aload_1 
L17:    ifnonnull L25 
L20:    ldc [8] 
L22:    goto L26 
L25:    aload_1 
L26:    astore_2 
L27:    aload_0 
L28:    getfield [50] 
L31:    aload_2 
L32:    invokevirtual [64] 
L35:    ifne L47 
L38:    aload_0 
L39:    aload_2 
L40:    putfield [87] 
L43:    aload_0 
L44:    invokespecial [72] 
L47:    return 
L48:    
    .end code 
.end method 

.method private [434] : [435] 
    .attribute [421] .code stack 4 locals 1 
L0:     aload_0 
L1:     getfield [45] 
L4:     ldc [23] 
L6:     ldc [27] 
L8:     aload_1 
L9:     invokestatic [25] 
L12:    invokevirtual [63] 
L15:    pop 
L16:    aload_1 
L17:    ifnonnull L25 
L20:    ldc [8] 
L22:    goto L26 
L25:    aload_1 
L26:    astore_2 
L27:    aload_0 
L28:    getfield [51] 
L31:    aload_2 
L32:    invokevirtual [64] 
L35:    ifne L47 
L38:    aload_0 
L39:    aload_2 
L40:    putfield [88] 
L43:    aload_0 
L44:    invokespecial [72] 
L47:    return 
L48:    
    .end code 
.end method 

.method private [436] : [437] 
    .attribute [421] .code stack 3 locals 2 
L0:     aload_0 
L1:     getfield [45] 
L4:     ldc [23] 
L6:     ldc [28] 
L8:     invokevirtual [65] 
L11:    pop 
L12:    aload_0 
L13:    getfield [46] 
L16:    ifeq L98 
L19:    ldc [8] 
L21:    astore_1 
L22:    aload_0 
L23:    getfield [51] 
L26:    invokestatic [29] 
L29:    ifne L40 
L32:    aload_0 
L33:    getfield [51] 
L36:    astore_1 
L37:    goto L73 
L40:    aload_0 
L41:    getfield [50] 
L44:    invokestatic [29] 
L47:    ifne L58 
L50:    aload_0 
L51:    getfield [50] 
L54:    astore_1 
L55:    goto L73 
L58:    aload_0 
L59:    getfield [49] 
L62:    invokestatic [29] 
L65:    ifne L73 
L68:    aload_0 
L69:    getfield [49] 
L72:    astore_1 
        .catch [10] from L73 to L84 using L87 
L73:    aload_0 
L74:    getfield [66] 
L77:    invokevirtual [52] 
L80:    aload_1 
L81:    invokevirtual [67] 
L84:    goto L98 
L87:    astore_2 
L88:    aload_0 
L89:    getfield [47] 
L92:    aload_2 
L93:    ldc [30] 
L95:    invokestatic [31] 
L98:    return 
L99:    nop 
L100:   
    .end code 
.end method 

.method private static [438] : [439] 
    .attribute [421] .code stack 2 locals 3 
L0:     aload_0 
L1:     invokevirtual [68] 
L4:     istore_1 
L5:     iload_1 
L6:     ldc [32] 
L8:     iand 
L9:     ifeq L16 
L12:    iconst_1 
L13:    goto L17 
L16:    iconst_0 
L17:    istore_2 
L18:    iload_1 
L19:    ldc [33] 
L21:    iand 
L22:    ifeq L29 
L25:    iconst_1 
L26:    goto L30 
L29:    iconst_0 
L30:    istore_3 
L31:    iload_2 
L32:    ifne L39 
L35:    iload_3 
L36:    ifeq L43 
L39:    iconst_1 
L40:    goto L44 
L43:    iconst_0 
L44:    areturn 
L45:    nop 
L46:    nop 
L47:    nop 
L48:    
    .end code 
.end method 

.method private static [440] : [441] 
    .attribute [421] .code stack 2 locals 0 
L0:     aload_0 
L1:     invokevirtual [68] 
L4:     iconst_4 
L5:     iand 
L6:     ifeq L13 
L9:     iconst_1 
L10:    goto L14 
L13:    iconst_0 
L14:    areturn 
L15:    nop 
L16:    
    .end code 
.end method 

.method static synthetic [442] : [443] 
    .attribute [421] .code stack 2 locals 1 
        .catch [5] from L0 to L4 using L5 
L0:     aload_0 
L1:     invokestatic [4] 
L4:     areturn 
L5:     astore_1 
L6:     new [85] 
L9:     dup 
L10:    invokespecial [73] 
L13:    aload_1 
L14:    invokevirtual [48] 
L17:    athrow 
L18:    nop 
L19:    nop 
L20:    
    .end code 
.end method 

.method static synthetic [444] : [445] 
    .attribute [421] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [47] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method static synthetic [446] : [447] 
    .attribute [421] .code stack 3 locals 0 
L0:     aload_0 
L1:     iload_1 
L2:     dup_x1 
L3:     putfield [84] 
L6:     areturn 
L7:     nop 
L8:     
    .end code 
.end method 

.method static synthetic [448] : [449] 
    .attribute [421] .code stack 1 locals 0 
L0:     aload_0 
L1:     invokespecial [72] 
L4:     return 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method static synthetic [450] : [451] 
    .attribute [421] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [45] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method static synthetic [452] : [453] 
    .attribute [421] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [45] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method static synthetic [454] : [455] 
    .attribute [421] .code stack 1 locals 0 
L0:     aload_0 
L1:     invokestatic [3] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method static synthetic [456] : [457] 
    .attribute [421] .code stack 1 locals 0 
L0:     aload_0 
L1:     invokestatic [2] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method static synthetic [458] : [459] 
    .attribute [421] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [45] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method static synthetic [460] : [461] 
    .attribute [421] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [45] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method static synthetic [462] : [463] 
    .attribute [421] .code stack 2 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     invokespecial [71] 
L5:     return 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method static synthetic [464] : [465] 
    .attribute [421] .code stack 2 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     invokespecial [70] 
L5:     return 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method static synthetic [466] : [467] 
    .attribute [421] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [45] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method static synthetic [468] : [469] 
    .attribute [421] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [45] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method static synthetic [470] : [471] 
    .attribute [421] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [45] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method static synthetic [472] : [473] 
    .attribute [421] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [45] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method static synthetic [474] : [475] 
    .attribute [421] .code stack 2 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     invokespecial [69] 
L5:     return 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Method [95] [96] 
.const [3] = Method [97] [98] 
.const [4] = Method [99] [100] 
.const [5] = Class [101] 
.const [6] = Class [102] 
.const [7] = String [103] 
.const [8] = String [104] 
.const [9] = Class [105] 
.const [10] = Class [106] 
.const [11] = String [107] 
.const [12] = Class [108] 
.const [13] = String [109] 
.const [14] = Field [110] [111] 
.const [15] = String [112] 
.const [16] = Method [113] [114] 
.const [17] = String [115] 
.const [18] = Method [116] [117] 
.const [19] = Field [118] [119] 
.const [20] = String [120] 
.const [21] = Class [121] 
.const [22] = Class [122] 
.const [23] = Int -2137614336 
.const [24] = String [123] 
.const [25] = Method [124] [125] 
.const [26] = String [126] 
.const [27] = String [127] 
.const [28] = String [128] 
.const [29] = Method [129] [130] 
.const [30] = String [131] 
.const [31] = Method [132] [133] 
.const [32] = Int 8192 
.const [33] = Int 16384 
.const [34] = Class [134] 
.const [35] = Class [135] 
.const [36] = Class [136] 
.const [37] = Class [137] 
.const [38] = Class [138] 
.const [39] = Class [139] 
.const [40] = Class [140] 
.const [41] = Class [141] 
.const [42] = Class [142] 
.const [43] = Class [143] 
.const [44] = Class [144] 
.const [45] = Field [145] [146] 
.const [46] = Field [147] [148] 
.const [47] = Field [149] [150] 
.const [48] = Method [151] [152] 
.const [49] = Field [153] [154] 
.const [50] = Field [155] [156] 
.const [51] = Field [157] [158] 
.const [52] = Method [159] [160] 
.const [53] = Method [161] [162] 
.const [54] = Method [163] [164] 
.const [55] = Method [165] [166] 
.const [56] = Method [167] [168] 
.const [57] = Method [169] [170] 
.const [58] = Method [171] [172] 
.const [59] = Method [173] [174] 
.const [60] = Method [175] [176] 
.const [61] = Method [177] [178] 
.const [62] = Field [179] [180] 
.const [63] = Method [181] [182] 
.const [64] = Method [183] [184] 
.const [65] = Method [185] [186] 
.const [66] = Field [187] [188] 
.const [67] = Method [189] [190] 
.const [68] = Method [191] [192] 
.const [69] = Method [193] [194] 
.const [70] = Method [195] [196] 
.const [71] = Method [197] [198] 
.const [72] = Method [199] [200] 
.const [73] = Method [201] [202] 
.const [74] = Method [203] [204] 
.const [75] = Method [205] [206] 
.const [76] = Method [207] [208] 
.const [77] = Method [209] [210] 
.const [78] = Method [211] [212] 
.const [79] = Method [213] [214] 
.const [80] = Field [215] [216] 
.const [81] = Field [217] [218] 
.const [82] = Method [219] [220] 
.const [83] = Method [221] [222] 
.const [84] = Field [223] [224] 
.const [85] = Class [225] 
.const [86] = Field [226] [227] 
.const [87] = Field [228] [229] 
.const [88] = Field [230] [231] 
.const [89] = Class [232] 
.const [90] = InterfaceMethod [233] [234] 
.const [91] = Class [235] 
.const [92] = InterfaceMethod [236] [237] 
.const [93] = Class [238] 
.const [94] = Class [239] 
.const [95] = Class [240] 
.const [96] = NameAndType [241] [242] 
.const [97] = Class [243] 
.const [98] = NameAndType [244] [245] 
.const [99] = Class [246] 
.const [100] = NameAndType [247] [248] 
.const [101] = Utf8 java/lang/ClassNotFoundException 
.const [102] = Utf8 java/lang/NoClassDefFoundError 
.const [103] = Utf8 'App.SDS.Dictation' 
.const [104] = Utf8 '' 
.const [105] = Utf8 de/audi/app/sdsmanager/dictation/user/UserIdManager$DsiDictationAdapterListener 
.const [106] = Utf8 java/lang/Exception 
.const [107] = Utf8 '[UserIdManager#connect] An error occurred: ' 
.const [108] = Utf8 de/audi/app/sdsmanager/dictation/osgi/ServiceFilterBuilder 
.const [109] = Utf8 objectClass 
.const [110] = Class [249] 
.const [111] = NameAndType [250] [251] 
.const [112] = Utf8 'org.dsi.ifc.bluetooth.DSIBluetooth' 
.const [113] = Class [252] 
.const [114] = NameAndType [253] [254] 
.const [115] = Utf8 DEVICE_INSTANCE 
.const [116] = Class [255] 
.const [117] = NameAndType [256] [257] 
.const [118] = Class [258] 
.const [119] = NameAndType [259] [260] 
.const [120] = Utf8 'org.dsi.ifc.telephone.DSITelephone' 
.const [121] = Utf8 de/audi/app/sdsmanager/dictation/user/UserIdManager$1 
.const [122] = Utf8 org/osgi/util/tracker/ServiceTracker 
.const [123] = Utf8 '[UserIdManager#setImsi] pImsi = %1' 
.const [124] = Class [261] 
.const [125] = NameAndType [262] [263] 
.const [126] = Utf8 '[UserIdManager#setMapDevice] pMapDeviceAddress = %1' 
.const [127] = Utf8 '[UserIdManager#setSapDevice] pSapDeviceAddress = %1' 
.const [128] = Utf8 '[UserIdManager#computeAndSetUserId]' 
.const [129] = Class [264] 
.const [130] = NameAndType [265] [266] 
.const [131] = Utf8 '[LanguageManager#setUserId]' 
.const [132] = Class [267] 
.const [133] = NameAndType [268] [269] 
.const [134] = Utf8 de/audi/app/sdsmanager/dictation/user/UserIdManager 
.const [135] = Utf8 de/audi/app/sdsmanager/dictation/component/AbstractDictationComponent 
.const [136] = Utf8 java/lang/Class 
.const [137] = Utf8 de/audi/app/sdsmanager/dictation/DictationComponentManager 
.const [138] = Utf8 de/audi/app/sdsmanager/dictation/dsiadapter/DsiDictationAdapter 
.const [139] = Utf8 de/audi/app/sdsmanager/dictation/osgi/IServiceRegistry 
.const [140] = Utf8 de/audi/atip/log/LogChannel 
.const [141] = Utf8 java/lang/String 
.const [142] = Utf8 org/osgi/framework/BundleContext 
.const [143] = Utf8 de/audi/app/sdsmanager/dictation/util/DictationUtil 
.const [144] = Utf8 org/dsi/ifc/bluetooth/TrustedDevice 
.const [145] = Class [270] 
.const [146] = NameAndType [271] [272] 
.const [147] = Class [273] 
.const [148] = NameAndType [274] [275] 
.const [149] = Class [276] 
.const [150] = NameAndType [277] [278] 
.const [151] = Class [279] 
.const [152] = NameAndType [280] [281] 
.const [153] = Class [282] 
.const [154] = NameAndType [283] [284] 
.const [155] = Class [285] 
.const [156] = NameAndType [286] [287] 
.const [157] = Class [288] 
.const [158] = NameAndType [289] [290] 
.const [159] = Class [291] 
.const [160] = NameAndType [292] [293] 
.const [161] = Class [294] 
.const [162] = NameAndType [295] [296] 
.const [163] = Class [297] 
.const [164] = NameAndType [298] [299] 
.const [165] = Class [300] 
.const [166] = NameAndType [301] [302] 
.const [167] = Class [303] 
.const [168] = NameAndType [304] [305] 
.const [169] = Class [306] 
.const [170] = NameAndType [307] [308] 
.const [171] = Class [309] 
.const [172] = NameAndType [310] [311] 
.const [173] = Class [312] 
.const [174] = NameAndType [313] [314] 
.const [175] = Class [315] 
.const [176] = NameAndType [316] [317] 
.const [177] = Class [318] 
.const [178] = NameAndType [319] [320] 
.const [179] = Class [321] 
.const [180] = NameAndType [322] [323] 
.const [181] = Class [324] 
.const [182] = NameAndType [325] [326] 
.const [183] = Class [327] 
.const [184] = NameAndType [328] [329] 
.const [185] = Class [330] 
.const [186] = NameAndType [331] [332] 
.const [187] = Class [333] 
.const [188] = NameAndType [334] [335] 
.const [189] = Class [336] 
.const [190] = NameAndType [337] [338] 
.const [191] = Class [339] 
.const [192] = NameAndType [340] [341] 
.const [193] = Class [342] 
.const [194] = NameAndType [343] [344] 
.const [195] = Class [345] 
.const [196] = NameAndType [346] [347] 
.const [197] = Class [348] 
.const [198] = NameAndType [349] [350] 
.const [199] = Class [351] 
.const [200] = NameAndType [352] [353] 
.const [201] = Class [354] 
.const [202] = NameAndType [355] [356] 
.const [203] = Class [357] 
.const [204] = NameAndType [358] [359] 
.const [205] = Class [360] 
.const [206] = NameAndType [361] [362] 
.const [207] = Class [363] 
.const [208] = NameAndType [364] [365] 
.const [209] = Class [366] 
.const [210] = NameAndType [367] [368] 
.const [211] = Class [369] 
.const [212] = NameAndType [370] [371] 
.const [213] = Class [372] 
.const [214] = NameAndType [373] [374] 
.const [215] = Class [375] 
.const [216] = NameAndType [376] [377] 
.const [217] = Class [378] 
.const [218] = NameAndType [379] [380] 
.const [219] = Class [381] 
.const [220] = NameAndType [382] [383] 
.const [221] = Class [384] 
.const [222] = NameAndType [385] [386] 
.const [223] = Class [387] 
.const [224] = NameAndType [388] [389] 
.const [225] = Utf8 java/lang/NoClassDefFoundError 
.const [226] = Class [390] 
.const [227] = NameAndType [391] [392] 
.const [228] = Class [393] 
.const [229] = NameAndType [394] [395] 
.const [230] = Class [396] 
.const [231] = NameAndType [397] [398] 
.const [232] = Utf8 de/audi/app/sdsmanager/dictation/user/UserIdManager$DsiDictationAdapterListener 
.const [233] = Class [399] 
.const [234] = NameAndType [400] [401] 
.const [235] = Utf8 de/audi/app/sdsmanager/dictation/osgi/ServiceFilterBuilder 
.const [236] = Class [402] 
.const [237] = NameAndType [403] [404] 
.const [238] = Utf8 de/audi/app/sdsmanager/dictation/user/UserIdManager$1 
.const [239] = Utf8 org/osgi/util/tracker/ServiceTracker 
.const [240] = Utf8 de/audi/app/sdsmanager/dictation/user/UserIdManager 
.const [241] = Utf8 isSapConnected 
.const [242] = Utf8 (Lorg/dsi/ifc/bluetooth/TrustedDevice;)Z 
.const [243] = Utf8 de/audi/app/sdsmanager/dictation/user/UserIdManager 
.const [244] = Utf8 isMapConnected 
.const [245] = Utf8 (Lorg/dsi/ifc/bluetooth/TrustedDevice;)Z 
.const [246] = Utf8 java/lang/Class 
.const [247] = Utf8 forName 
.const [248] = Utf8 (Ljava/lang/String;)Ljava/lang/Class; 
.const [249] = Utf8 de/audi/app/sdsmanager/dictation/user/UserIdManager 
.const [250] = Utf8 class$org$dsi$ifc$bluetooth$DSIBluetooth 
.const [251] = Utf8 Ljava/lang/Class; 
.const [252] = Utf8 de/audi/app/sdsmanager/dictation/user/UserIdManager 
.const [253] = Utf8 class$ 
.const [254] = Utf8 (Ljava/lang/String;)Ljava/lang/Class; 
.const [255] = Utf8 java/lang/String 
.const [256] = Utf8 valueOf 
.const [257] = Utf8 (I)Ljava/lang/String; 
.const [258] = Utf8 de/audi/app/sdsmanager/dictation/user/UserIdManager 
.const [259] = Utf8 class$org$dsi$ifc$telephone$DSITelephone 
.const [260] = Utf8 Ljava/lang/Class; 
.const [261] = Utf8 java/lang/String 
.const [262] = Utf8 valueOf 
.const [263] = Utf8 (Ljava/lang/Object;)Ljava/lang/String; 
.const [264] = Utf8 de/audi/app/sdsmanager/dictation/util/DictationUtil 
.const [265] = Utf8 isNullOrEmpty 
.const [266] = Utf8 (Ljava/lang/String;)Z 
.const [267] = Utf8 de/audi/app/sdsmanager/dictation/util/DictationUtil 
.const [268] = Utf8 logException 
.const [269] = Utf8 (Lde/audi/atip/log/LogChannel;Ljava/lang/Throwable;Ljava/lang/String;)V 
.const [270] = Utf8 de/audi/app/sdsmanager/dictation/user/UserIdManager 
.const [271] = Utf8 log 
.const [272] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [273] = Utf8 de/audi/app/sdsmanager/dictation/user/UserIdManager 
.const [274] = Utf8 dsiAvailable 
.const [275] = Utf8 Z 
.const [276] = Utf8 de/audi/app/sdsmanager/dictation/component/AbstractDictationComponent 
.const [277] = Utf8 log 
.const [278] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [279] = Utf8 java/lang/NoClassDefFoundError 
.const [280] = Utf8 initCause 
.const [281] = Utf8 (Ljava/lang/Throwable;)Ljava/lang/Throwable; 
.const [282] = Utf8 de/audi/app/sdsmanager/dictation/user/UserIdManager 
.const [283] = Utf8 imsi 
.const [284] = Utf8 Ljava/lang/String; 
.const [285] = Utf8 de/audi/app/sdsmanager/dictation/user/UserIdManager 
.const [286] = Utf8 mapDeviceAddress 
.const [287] = Utf8 Ljava/lang/String; 
.const [288] = Utf8 de/audi/app/sdsmanager/dictation/user/UserIdManager 
.const [289] = Utf8 sapDeviceAddress 
.const [290] = Utf8 Ljava/lang/String; 
.const [291] = Utf8 de/audi/app/sdsmanager/dictation/DictationComponentManager 
.const [292] = Utf8 getDsiDictationAdapter 
.const [293] = Utf8 ()Lde/audi/app/sdsmanager/dictation/dsiadapter/DsiDictationAdapter; 
.const [294] = Utf8 de/audi/app/sdsmanager/dictation/dsiadapter/DsiDictationAdapter 
.const [295] = Utf8 addListener 
.const [296] = Utf8 (Lde/audi/app/sdsmanager/dictation/dsiadapter/IDsiDictationAdapterListener;)V 
.const [297] = Utf8 de/audi/atip/log/LogChannel 
.const [298] = Utf8 log 
.const [299] = Utf8 (ILjava/lang/String;Ljava/lang/Throwable;)Z 
.const [300] = Utf8 de/audi/app/sdsmanager/dictation/osgi/ServiceFilterBuilder 
.const [301] = Utf8 beginOr 
.const [302] = Utf8 ()Lde/audi/app/sdsmanager/dictation/osgi/ServiceFilterBuilder; 
.const [303] = Utf8 de/audi/app/sdsmanager/dictation/osgi/ServiceFilterBuilder 
.const [304] = Utf8 beginAnd 
.const [305] = Utf8 ()Lde/audi/app/sdsmanager/dictation/osgi/ServiceFilterBuilder; 
.const [306] = Utf8 java/lang/Class 
.const [307] = Utf8 getName 
.const [308] = Utf8 ()Ljava/lang/String; 
.const [309] = Utf8 de/audi/app/sdsmanager/dictation/osgi/ServiceFilterBuilder 
.const [310] = Utf8 addProperty 
.const [311] = Utf8 (Ljava/lang/String;Ljava/lang/String;)Lde/audi/app/sdsmanager/dictation/osgi/ServiceFilterBuilder; 
.const [312] = Utf8 de/audi/app/sdsmanager/dictation/osgi/ServiceFilterBuilder 
.const [313] = Utf8 endAnd 
.const [314] = Utf8 ()Lde/audi/app/sdsmanager/dictation/osgi/ServiceFilterBuilder; 
.const [315] = Utf8 de/audi/app/sdsmanager/dictation/osgi/ServiceFilterBuilder 
.const [316] = Utf8 endOr 
.const [317] = Utf8 ()Lde/audi/app/sdsmanager/dictation/osgi/ServiceFilterBuilder; 
.const [318] = Utf8 de/audi/app/sdsmanager/dictation/osgi/ServiceFilterBuilder 
.const [319] = Utf8 createFilterString 
.const [320] = Utf8 ()Ljava/lang/String; 
.const [321] = Utf8 de/audi/app/sdsmanager/dictation/user/UserIdManager 
.const [322] = Utf8 bundleContext 
.const [323] = Utf8 Lorg/osgi/framework/BundleContext; 
.const [324] = Utf8 de/audi/atip/log/LogChannel 
.const [325] = Utf8 log 
.const [326] = Utf8 (ILjava/lang/String;Ljava/lang/Object;)Z 
.const [327] = Utf8 java/lang/String 
.const [328] = Utf8 equals 
.const [329] = Utf8 (Ljava/lang/Object;)Z 
.const [330] = Utf8 de/audi/atip/log/LogChannel 
.const [331] = Utf8 log 
.const [332] = Utf8 (ILjava/lang/String;)Z 
.const [333] = Utf8 de/audi/app/sdsmanager/dictation/component/AbstractDictationComponent 
.const [334] = Utf8 dictationComponentManager 
.const [335] = Utf8 Lde/audi/app/sdsmanager/dictation/DictationComponentManager; 
.const [336] = Utf8 de/audi/app/sdsmanager/dictation/dsiadapter/DsiDictationAdapter 
.const [337] = Utf8 requestSetUserId 
.const [338] = Utf8 (Ljava/lang/String;)V 
.const [339] = Utf8 org/dsi/ifc/bluetooth/TrustedDevice 
.const [340] = Utf8 getActiveServiceTypes 
.const [341] = Utf8 ()I 
.const [342] = Utf8 de/audi/app/sdsmanager/dictation/user/UserIdManager 
.const [343] = Utf8 setImsi 
.const [344] = Utf8 (Ljava/lang/String;)V 
.const [345] = Utf8 de/audi/app/sdsmanager/dictation/user/UserIdManager 
.const [346] = Utf8 setSapDeviceAddress 
.const [347] = Utf8 (Ljava/lang/String;)V 
.const [348] = Utf8 de/audi/app/sdsmanager/dictation/user/UserIdManager 
.const [349] = Utf8 setMapDeviceAddress 
.const [350] = Utf8 (Ljava/lang/String;)V 
.const [351] = Utf8 de/audi/app/sdsmanager/dictation/user/UserIdManager 
.const [352] = Utf8 computeAndSetUserId 
.const [353] = Utf8 ()V 
.const [354] = Utf8 java/lang/NoClassDefFoundError 
.const [355] = Utf8 <init> 
.const [356] = Utf8 ()V 
.const [357] = Utf8 de/audi/app/sdsmanager/dictation/component/AbstractDictationComponent 
.const [358] = Utf8 <init> 
.const [359] = Utf8 (Lde/audi/app/sdsmanager/dictation/osgi/BundleEnvironment;Ljava/lang/String;)V 
.const [360] = Utf8 de/audi/app/sdsmanager/dictation/component/AbstractDictationComponent 
.const [361] = Utf8 init 
.const [362] = Utf8 (Lde/audi/app/sdsmanager/dictation/DictationComponentManager;)V 
.const [363] = Utf8 de/audi/app/sdsmanager/dictation/user/UserIdManager$DsiDictationAdapterListener 
.const [364] = Utf8 <init> 
.const [365] = Utf8 (Lde/audi/app/sdsmanager/dictation/user/UserIdManager;Lde/audi/app/sdsmanager/dictation/user/UserIdManager$1;)V 
.const [366] = Utf8 de/audi/app/sdsmanager/dictation/component/AbstractDictationComponent 
.const [367] = Utf8 connect 
.const [368] = Utf8 (Lde/audi/app/sdsmanager/dictation/osgi/IServiceRegistry;)V 
.const [369] = Utf8 de/audi/app/sdsmanager/dictation/user/UserIdManager 
.const [370] = Utf8 createServiceTracker 
.const [371] = Utf8 ()Lorg/osgi/util/tracker/ServiceTracker; 
.const [372] = Utf8 de/audi/app/sdsmanager/dictation/osgi/ServiceFilterBuilder 
.const [373] = Utf8 <init> 
.const [374] = Utf8 ()V 
.const [375] = Utf8 de/audi/app/sdsmanager/dictation/user/UserIdManager 
.const [376] = Utf8 class$org$dsi$ifc$bluetooth$DSIBluetooth 
.const [377] = Utf8 Ljava/lang/Class; 
.const [378] = Utf8 de/audi/app/sdsmanager/dictation/user/UserIdManager 
.const [379] = Utf8 class$org$dsi$ifc$telephone$DSITelephone 
.const [380] = Utf8 Ljava/lang/Class; 
.const [381] = Utf8 de/audi/app/sdsmanager/dictation/user/UserIdManager$1 
.const [382] = Utf8 <init> 
.const [383] = Utf8 (Lde/audi/app/sdsmanager/dictation/user/UserIdManager;Lde/audi/atip/log/LogChannel;Lorg/osgi/framework/BundleContext;)V 
.const [384] = Utf8 org/osgi/util/tracker/ServiceTracker 
.const [385] = Utf8 <init> 
.const [386] = Utf8 (Lorg/osgi/framework/BundleContext;Lorg/osgi/framework/Filter;Lorg/osgi/util/tracker/ServiceTrackerCustomizer;)V 
.const [387] = Utf8 de/audi/app/sdsmanager/dictation/user/UserIdManager 
.const [388] = Utf8 dsiAvailable 
.const [389] = Utf8 Z 
.const [390] = Utf8 de/audi/app/sdsmanager/dictation/user/UserIdManager 
.const [391] = Utf8 imsi 
.const [392] = Utf8 Ljava/lang/String; 
.const [393] = Utf8 de/audi/app/sdsmanager/dictation/user/UserIdManager 
.const [394] = Utf8 mapDeviceAddress 
.const [395] = Utf8 Ljava/lang/String; 
.const [396] = Utf8 de/audi/app/sdsmanager/dictation/user/UserIdManager 
.const [397] = Utf8 sapDeviceAddress 
.const [398] = Utf8 Ljava/lang/String; 
.const [399] = Utf8 de/audi/app/sdsmanager/dictation/osgi/IServiceRegistry 
.const [400] = Utf8 addTracker 
.const [401] = Utf8 (Lorg/osgi/util/tracker/ServiceTracker;)V 
.const [402] = Utf8 org/osgi/framework/BundleContext 
.const [403] = Utf8 createFilter 
.const [404] = Utf8 (Ljava/lang/String;)Lorg/osgi/framework/Filter; 
.const [405] = Utf8 de/audi/app/sdsmanager/dictation/user/UserIdManager 
.const [406] = Class [405] 
.const [407] = Utf8 de/audi/app/sdsmanager/dictation/component/AbstractDictationComponent 
.const [408] = Class [407] 
.const [409] = Utf8 imsi 
.const [410] = Utf8 Ljava/lang/String; 
.const [411] = Utf8 mapDeviceAddress 
.const [412] = Utf8 Ljava/lang/String; 
.const [413] = Utf8 sapDeviceAddress 
.const [414] = Utf8 Ljava/lang/String; 
.const [415] = Utf8 dsiAvailable 
.const [416] = Utf8 Z 
.const [417] = Utf8 class$org$dsi$ifc$bluetooth$DSIBluetooth 
.const [418] = Utf8 Ljava/lang/Class; 
.const [419] = Utf8 class$org$dsi$ifc$telephone$DSITelephone 
.const [420] = Utf8 Ljava/lang/Class; 
.const [421] = Utf8 Code 
.const [422] = Utf8 <init> 
.const [423] = Utf8 (Lde/audi/app/sdsmanager/dictation/osgi/BundleEnvironment;)V 
.const [424] = Utf8 init 
.const [425] = Utf8 (Lde/audi/app/sdsmanager/dictation/DictationComponentManager;)V 
.const [426] = Utf8 connect 
.const [427] = Utf8 (Lde/audi/app/sdsmanager/dictation/osgi/IServiceRegistry;)V 
.const [428] = Utf8 createServiceTracker 
.const [429] = Utf8 ()Lorg/osgi/util/tracker/ServiceTracker; 
.const [430] = Utf8 setImsi 
.const [431] = Utf8 (Ljava/lang/String;)V 
.const [432] = Utf8 setMapDeviceAddress 
.const [433] = Utf8 (Ljava/lang/String;)V 
.const [434] = Utf8 setSapDeviceAddress 
.const [435] = Utf8 (Ljava/lang/String;)V 
.const [436] = Utf8 computeAndSetUserId 
.const [437] = Utf8 ()V 
.const [438] = Utf8 isMapConnected 
.const [439] = Utf8 (Lorg/dsi/ifc/bluetooth/TrustedDevice;)Z 
.const [440] = Utf8 isSapConnected 
.const [441] = Utf8 (Lorg/dsi/ifc/bluetooth/TrustedDevice;)Z 
.const [442] = Utf8 class$ 
.const [443] = Utf8 (Ljava/lang/String;)Ljava/lang/Class; 
.const [444] = Utf8 access$301 
.const [445] = Utf8 (Lde/audi/app/sdsmanager/dictation/user/UserIdManager;)Lde/audi/atip/log/LogChannel; 
.const [446] = Utf8 access$402 
.const [447] = Utf8 (Lde/audi/app/sdsmanager/dictation/user/UserIdManager;Z)Z 
.const [448] = Utf8 access$500 
.const [449] = Utf8 (Lde/audi/app/sdsmanager/dictation/user/UserIdManager;)V 
.const [450] = Utf8 access$600 
.const [451] = Utf8 (Lde/audi/app/sdsmanager/dictation/user/UserIdManager;)Lde/audi/atip/log/LogChannel; 
.const [452] = Utf8 access$700 
.const [453] = Utf8 (Lde/audi/app/sdsmanager/dictation/user/UserIdManager;)Lde/audi/atip/log/LogChannel; 
.const [454] = Utf8 access$800 
.const [455] = Utf8 (Lorg/dsi/ifc/bluetooth/TrustedDevice;)Z 
.const [456] = Utf8 access$900 
.const [457] = Utf8 (Lorg/dsi/ifc/bluetooth/TrustedDevice;)Z 
.const [458] = Utf8 access$1000 
.const [459] = Utf8 (Lde/audi/app/sdsmanager/dictation/user/UserIdManager;)Lde/audi/atip/log/LogChannel; 
.const [460] = Utf8 access$1100 
.const [461] = Utf8 (Lde/audi/app/sdsmanager/dictation/user/UserIdManager;)Lde/audi/atip/log/LogChannel; 
.const [462] = Utf8 access$1200 
.const [463] = Utf8 (Lde/audi/app/sdsmanager/dictation/user/UserIdManager;Ljava/lang/String;)V 
.const [464] = Utf8 access$1300 
.const [465] = Utf8 (Lde/audi/app/sdsmanager/dictation/user/UserIdManager;Ljava/lang/String;)V 
.const [466] = Utf8 access$1400 
.const [467] = Utf8 (Lde/audi/app/sdsmanager/dictation/user/UserIdManager;)Lde/audi/atip/log/LogChannel; 
.const [468] = Utf8 access$1500 
.const [469] = Utf8 (Lde/audi/app/sdsmanager/dictation/user/UserIdManager;)Lde/audi/atip/log/LogChannel; 
.const [470] = Utf8 access$1600 
.const [471] = Utf8 (Lde/audi/app/sdsmanager/dictation/user/UserIdManager;)Lde/audi/atip/log/LogChannel; 
.const [472] = Utf8 access$1700 
.const [473] = Utf8 (Lde/audi/app/sdsmanager/dictation/user/UserIdManager;)Lde/audi/atip/log/LogChannel; 
.const [474] = Utf8 access$1800 
.const [475] = Utf8 (Lde/audi/app/sdsmanager/dictation/user/UserIdManager;Ljava/lang/String;)V 
.end class 
