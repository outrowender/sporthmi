.version 50 0 
.class public super [396] 
.super [398] 
.implements [400] 
.field private static final [401] [402] 
.field private static final [403] [404] 
.field private static final [405] [406] 
.field private [407] [408] 
.field private [409] [410] 
.field private [411] [412] 
.field private [413] [414] 
.field private [415] [416] 

.method public [418] : [419] 
    .attribute [417] .code stack 3 locals 0 
L0:     aload_0 
L1:     invokespecial [55] 
L4:     aload_0 
L5:     new [68] 
L8:     dup 
L9:     invokespecial [56] 
L12:    putfield [69] 
L15:    aload_0 
L16:    iconst_m1 
L17:    putfield [70] 
L20:    aload_0 
L21:    new [68] 
L24:    dup 
L25:    invokespecial [56] 
L28:    putfield [71] 
L31:    aload_0 
L32:    iconst_0 
L33:    putfield [72] 
L36:    aload_0 
L37:    getstatic [3] 
L40:    ldc [4] 
L42:    invokeinterface [73] 0 
L47:    putfield [74] 
L50:    return 
L51:    nop 
L52:    
    .end code 
.end method 

.method public [420] : [421] 
    .attribute [417] .code stack 5 locals 1 
L0:     aload_0 
L1:     getfield [43] 
L4:     ifeq L8 
L7:     return 
L8:     aload_1 
L9:     invokeinterface [75] 0 
L14:    istore_2 
L15:    iload_2 
L16:    iconst_2 
L17:    if_icmpne L21 
L20:    return 
L21:    aload_0 
L22:    aload_1 
L23:    invokespecial [57] 
L26:    iload_2 
L27:    iconst_1 
L28:    if_icmpne L39 
L31:    aload_0 
L32:    aload_1 
L33:    invokespecial [58] 
L36:    goto L58 
L39:    aload_0 
L40:    getfield [44] 
L43:    ldc [5] 
L45:    ldc [6] 
L47:    aload_1 
L48:    invokeinterface [76] 0 
L53:    i2l 
L54:    invokevirtual [45] 
L57:    pop 
L58:    return 
L59:    nop 
L60:    
    .end code 
.end method 

.method private [422] : [423] 
    .attribute [417] .code stack 7 locals 1 
L0:     aload_1 
L1:     invokeinterface [76] 0 
L6:     ldc [7] 
L8:     idiv 
L9:     istore_2 
L10:    iload_2 
L11:    aload_0 
L12:    getfield [41] 
L15:    if_icmpne L43 
L18:    aload_0 
L19:    getfield [44] 
L22:    ldc [8] 
L24:    ldc [9] 
L26:    aload_0 
L27:    getfield [41] 
L30:    i2l 
L31:    invokevirtual [45] 
L34:    pop 
L35:    aload_0 
L36:    aload_1 
L37:    invokespecial [59] 
L40:    goto L76 
L43:    aload_0 
L44:    getfield [44] 
L47:    ldc [8] 
L49:    ldc [10] 
L51:    aload_0 
L52:    getfield [41] 
L55:    i2l 
L56:    iload_2 
L57:    i2l 
L58:    invokevirtual [46] 
L61:    pop 
L62:    aload_0 
L63:    invokespecial [60] 
L66:    aload_0 
L67:    iload_2 
L68:    putfield [70] 
L71:    aload_0 
L72:    aload_1 
L73:    invokespecial [59] 
L76:    return 
L77:    nop 
L78:    nop 
L79:    nop 
L80:    
    .end code 
.end method 

.method public [424] : [425] 
    .attribute [417] .code stack 4 locals 1 
L0:     aload_0 
L1:     getfield [40] 
L4:     new [77] 
L7:     dup 
L8:     iload_1 
L9:     invokespecial [61] 
L12:    invokeinterface [78] 0 
L17:    checkcast [12] 
L20:    astore_2 
L21:    aload_2 
L22:    ifnull L40 
L25:    aload_2 
L26:    invokeinterface [75] 0 
L31:    iconst_1 
L32:    if_icmpne L40 
L35:    aload_0 
L36:    aload_2 
L37:    invokespecial [58] 
L40:    aload_2 
L41:    areturn 
L42:    nop 
L43:    nop 
L44:    
    .end code 
.end method 

.method private [426] : [427] 
    .attribute [417] .code stack 4 locals 2 
L0:     aload_0 
L1:     getfield [42] 
L4:     new [77] 
L7:     dup 
L8:     aload_0 
L9:     getfield [41] 
L12:    invokespecial [61] 
L15:    invokeinterface [78] 0 
L20:    checkcast [13] 
L23:    astore_2 
L24:    aload_2 
L25:    ifnonnull L69 
L28:    new [79] 
L31:    dup 
L32:    bipush 10 
L34:    invokespecial [62] 
L37:    astore_2 
L38:    aload_0 
L39:    getfield [42] 
L42:    new [77] 
L45:    dup 
L46:    aload_0 
L47:    getfield [41] 
L50:    invokespecial [61] 
L53:    aload_2 
L54:    invokeinterface [80] 0 
L59:    pop 
L60:    aload_2 
L61:    aload_1 
L62:    invokevirtual [47] 
L65:    pop 
L66:    goto L137 
L69:    aload_2 
L70:    aload_1 
L71:    invokevirtual [48] 
L74:    ifeq L102 
L77:    aload_2 
L78:    aload_1 
L79:    invokevirtual [49] 
L82:    istore_3 
L83:    iload_3 
L84:    ifeq L99 
L87:    aload_2 
L88:    iload_3 
L89:    invokevirtual [50] 
L92:    pop 
L93:    aload_2 
L94:    iconst_1 
L95:    aload_1 
L96:    invokevirtual [51] 
L99:    goto L137 
L102:   aload_2 
L103:   invokevirtual [52] 
L106:   getstatic [14] 
L109:   if_icmpne L131 
L112:   aload_2 
L113:   aload_2 
L114:   invokevirtual [52] 
L117:   iconst_1 
L118:   isub 
L119:   invokevirtual [50] 
L122:   checkcast [12] 
L125:   astore_3 
L126:   aload_0 
L127:   aload_3 
L128:   invokespecial [64] 
L131:   aload_2 
L132:   iconst_1 
L133:   aload_1 
L134:   invokevirtual [51] 
L137:   return 
L138:   nop 
L139:   nop 
L140:   
    .end code 
.end method 

.method private [428] : [429] 
    .attribute [417] .code stack 5 locals 1 
L0:     new [77] 
L3:     dup 
L4:     aload_1 
L5:     invokeinterface [76] 0 
L10:    invokespecial [61] 
L13:    astore_2 
L14:    aload_0 
L15:    getfield [40] 
L18:    aload_2 
L19:    invokeinterface [78] 0 
L24:    ifnonnull L61 
L27:    aload_0 
L28:    getfield [40] 
L31:    aload_2 
L32:    aload_1 
L33:    invokeinterface [80] 0 
L38:    pop 
L39:    aload_0 
L40:    getfield [44] 
L43:    ldc [8] 
L45:    ldc [15] 
L47:    aload_1 
L48:    invokeinterface [76] 0 
L53:    i2l 
L54:    invokevirtual [45] 
L57:    pop 
L58:    goto L80 
L61:    aload_0 
L62:    getfield [44] 
L65:    ldc [8] 
L67:    ldc [16] 
L69:    aload_1 
L70:    invokeinterface [76] 0 
L75:    i2l 
L76:    invokevirtual [45] 
L79:    pop 
L80:    return 
L81:    nop 
L82:    nop 
L83:    nop 
L84:    
    .end code 
.end method 

.method private [430] : [431] 
    .attribute [417] .code stack 5 locals 1 
L0:     new [77] 
L3:     dup 
L4:     aload_1 
L5:     invokeinterface [76] 0 
L10:    invokespecial [61] 
L13:    astore_2 
L14:    aload_0 
L15:    getfield [40] 
L18:    aload_2 
L19:    invokeinterface [78] 0 
L24:    ifnull L60 
L27:    aload_0 
L28:    getfield [40] 
L31:    aload_2 
L32:    invokeinterface [81] 0 
L37:    pop 
L38:    aload_0 
L39:    getfield [44] 
L42:    ldc [8] 
L44:    ldc [17] 
L46:    aload_1 
L47:    invokeinterface [76] 0 
L52:    i2l 
L53:    invokevirtual [45] 
L56:    pop 
L57:    goto L79 
L60:    aload_0 
L61:    getfield [44] 
L64:    ldc [8] 
L66:    ldc [18] 
L68:    aload_1 
L69:    invokeinterface [76] 0 
L74:    i2l 
L75:    invokevirtual [45] 
L78:    pop 
L79:    return 
L80:    
    .end code 
.end method 

.method private [432] : [433] 
    .attribute [417] .code stack 9 locals 4 
L0:     aload_0 
L1:     getfield [42] 
L4:     new [77] 
L7:     dup 
L8:     aload_0 
L9:     getfield [41] 
L12:    invokespecial [61] 
L15:    invokeinterface [78] 0 
L20:    checkcast [13] 
L23:    astore_1 
L24:    aload_1 
L25:    ifnull L115 
L28:    aload_0 
L29:    getfield [44] 
L32:    ldc [8] 
L34:    ldc [19] 
L36:    aload_0 
L37:    getfield [41] 
L40:    i2l 
L41:    aload_1 
L42:    invokevirtual [52] 
L45:    i2l 
L46:    invokevirtual [46] 
L49:    pop 
L50:    getstatic [3] 
L53:    invokeinterface [82] 0 
L58:    lstore_2 
L59:    aload_1 
L60:    invokevirtual [52] 
L63:    getstatic [20] 
L66:    if_icmple L93 
L69:    aload_1 
L70:    aload_1 
L71:    invokevirtual [52] 
L74:    iconst_1 
L75:    isub 
L76:    invokevirtual [50] 
L79:    checkcast [12] 
L82:    astore 4 
L84:    aload_0 
L85:    aload 4 
L87:    invokespecial [64] 
L90:    goto L59 
L93:    aload_0 
L94:    getfield [44] 
L97:    ldc [8] 
L99:    ldc [21] 
L101:   aload_0 
L102:   getfield [41] 
L105:   i2l 
L106:   invokestatic [22] 
L109:   lload_2 
L110:   lsub 
L111:   invokevirtual [46] 
L114:   pop 
L115:   return 
L116:   
    .end code 
.end method 

.method public [434] : [435] 
    .attribute [417] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [40] 
L4:     invokeinterface [83] 0 
L9:     aload_0 
L10:    getfield [42] 
L13:    invokeinterface [83] 0 
L18:    aload_0 
L19:    invokespecial [66] 
L22:    return 
L23:    nop 
L24:    
    .end code 
.end method 

.method private [436] : [437] 
    .attribute [417] .code stack 2 locals 1 
L0:     getstatic [3] 
L3:     invokeinterface [84] 0 
L8:     iconst_0 
L9:     invokeinterface [85] 0 
L14:    astore_1 
L15:    aload_1 
L16:    instanceof [23] 
L19:    ifeq L34 
L22:    aload_1 
L23:    checkcast [23] 
L26:    invokevirtual [53] 
L29:    invokeinterface [86] 0 
L34:    return 
L35:    nop 
L36:    
    .end code 
.end method 

.method public [438] : [439] 
    .attribute [417] .code stack 5 locals 0 
L0:     aload_0 
L1:     getfield [44] 
L4:     ldc [8] 
L6:     ldc [24] 
L8:     iload_1 
L9:     i2l 
L10:    invokevirtual [45] 
L13:    pop 
L14:    aload_0 
L15:    iload_1 
L16:    invokespecial [67] 
L19:    aload_0 
L20:    invokespecial [66] 
L23:    return 
L24:    
    .end code 
.end method 

.method private [440] : [441] 
    .attribute [417] .code stack 5 locals 5 
L0:     aload_0 
L1:     getfield [40] 
L4:     invokeinterface [87] 0 
L9:     astore_2 
L10:    aload_2 
L11:    invokeinterface [88] 0 
L16:    astore_3 
L17:    aload_3 
L18:    invokeinterface [89] 0 
L23:    ifeq L83 
L26:    aload_3 
L27:    invokeinterface [90] 0 
L32:    checkcast [12] 
L35:    astore 4 
L37:    aload 4 
L39:    invokeinterface [76] 0 
L44:    istore 5 
L46:    iload 5 
L48:    ldc [7] 
L50:    idiv 
L51:    istore 6 
L53:    iload 6 
L55:    iload_1 
L56:    if_icmpne L80 
L59:    aload_0 
L60:    getfield [44] 
L63:    ldc [5] 
L65:    ldc [25] 
L67:    iload 5 
L69:    i2l 
L70:    invokevirtual [45] 
L73:    pop 
L74:    aload_3 
L75:    invokeinterface [91] 0 
L80:    goto L17 
L83:    aload_0 
L84:    getfield [42] 
L87:    new [77] 
L90:    dup 
L91:    iload_1 
L92:    invokespecial [61] 
L95:    invokeinterface [81] 0 
L100:   pop 
L101:   return 
L102:   nop 
L103:   nop 
L104:   
    .end code 
.end method 

.method public [442] : [443] 
    .attribute [417] .code stack 2 locals 0 
L0:     aload_0 
L1:     iload_1 
L2:     putfield [72] 
L5:     return 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method static [444] : [445] 
    .attribute [417] .code stack 2 locals 0 
L0:     ldc [26] 
L2:     iconst_3 
L3:     invokestatic [27] 
L6:     invokevirtual [54] 
L9:     putstatic [65] 
L12:    ldc [28] 
L14:    bipush 6 
L16:    invokestatic [27] 
L19:    invokevirtual [54] 
L22:    putstatic [63] 
L25:    return 
L26:    nop 
L27:    nop 
L28:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [92] 
.const [3] = Field [93] [94] 
.const [4] = String [95] 
.const [5] = Int -2137614336 
.const [6] = String [96] 
.const [7] = Int -1601830656 
.const [8] = Int 1078071040 
.const [9] = String [97] 
.const [10] = String [98] 
.const [11] = Class [99] 
.const [12] = Class [100] 
.const [13] = Class [101] 
.const [14] = Field [102] [103] 
.const [15] = String [104] 
.const [16] = String [105] 
.const [17] = String [106] 
.const [18] = String [107] 
.const [19] = String [108] 
.const [20] = Field [109] [110] 
.const [21] = String [111] 
.const [22] = Method [112] [113] 
.const [23] = Class [114] 
.const [24] = String [115] 
.const [25] = String [116] 
.const [26] = String [117] 
.const [27] = Method [118] [119] 
.const [28] = String [120] 
.const [29] = Class [121] 
.const [30] = Class [122] 
.const [31] = Class [123] 
.const [32] = Class [124] 
.const [33] = Class [125] 
.const [34] = Class [126] 
.const [35] = Class [127] 
.const [36] = Class [128] 
.const [37] = Class [129] 
.const [38] = Class [130] 
.const [39] = Class [131] 
.const [40] = Field [132] [133] 
.const [41] = Field [134] [135] 
.const [42] = Field [136] [137] 
.const [43] = Field [138] [139] 
.const [44] = Field [140] [141] 
.const [45] = Method [142] [143] 
.const [46] = Method [144] [145] 
.const [47] = Method [146] [147] 
.const [48] = Method [148] [149] 
.const [49] = Method [150] [151] 
.const [50] = Method [152] [153] 
.const [51] = Method [154] [155] 
.const [52] = Method [156] [157] 
.const [53] = Method [158] [159] 
.const [54] = Method [160] [161] 
.const [55] = Method [162] [163] 
.const [56] = Method [164] [165] 
.const [57] = Method [166] [167] 
.const [58] = Method [168] [169] 
.const [59] = Method [170] [171] 
.const [60] = Method [172] [173] 
.const [61] = Method [174] [175] 
.const [62] = Method [176] [177] 
.const [63] = Field [178] [179] 
.const [64] = Method [180] [181] 
.const [65] = Field [182] [183] 
.const [66] = Method [184] [185] 
.const [67] = Method [186] [187] 
.const [68] = Class [188] 
.const [69] = Field [189] [190] 
.const [70] = Field [191] [192] 
.const [71] = Field [193] [194] 
.const [72] = Field [195] [196] 
.const [73] = InterfaceMethod [197] [198] 
.const [74] = Field [199] [200] 
.const [75] = InterfaceMethod [201] [202] 
.const [76] = InterfaceMethod [203] [204] 
.const [77] = Class [205] 
.const [78] = InterfaceMethod [206] [207] 
.const [79] = Class [208] 
.const [80] = InterfaceMethod [209] [210] 
.const [81] = InterfaceMethod [211] [212] 
.const [82] = InterfaceMethod [213] [214] 
.const [83] = InterfaceMethod [215] [216] 
.const [84] = InterfaceMethod [217] [218] 
.const [85] = InterfaceMethod [219] [220] 
.const [86] = InterfaceMethod [221] [222] 
.const [87] = InterfaceMethod [223] [224] 
.const [88] = InterfaceMethod [225] [226] 
.const [89] = InterfaceMethod [227] [228] 
.const [90] = InterfaceMethod [229] [230] 
.const [91] = InterfaceMethod [231] [232] 
.const [92] = Utf8 java/util/HashMap 
.const [93] = Class [233] 
.const [94] = NameAndType [234] [235] 
.const [95] = Utf8 'Fw.ScreenCache' 
.const [96] = Utf8 'ScreenCacheImpl#putScreen screen with id: %1 is always cached' 
.const [97] = Utf8 'ScreenCacheImpl#handleScreenChange screenchange in application: %1' 
.const [98] = Utf8 'ScreenCacheImpl#handleScreenChange screenchange from application: %1 to new application: %2' 
.const [99] = Utf8 java/lang/Integer 
.const [100] = Utf8 de/audi/atip/hmi/view/Screen 
.const [101] = Utf8 java/util/ArrayList 
.const [102] = Class [236] 
.const [103] = NameAndType [237] [238] 
.const [104] = Utf8 'ScreenCacheImpl#insertIntoCache put screen with id %1 in cache' 
.const [105] = Utf8 'ScreenCacheImpl#insertIntoCache screen with id %1 is already in cache' 
.const [106] = Utf8 'ScreenCacheImpl#removeFromCache removed screen with id %1 from cache' 
.const [107] = Utf8 'ScreenCacheImpl#removeFromCache screen with id %1 was not in the cache' 
.const [108] = Utf8 'ScreenCacheImpl#leaveCurrentApplication leaving application: %1 no of cached screens: %2' 
.const [109] = Class [239] 
.const [110] = NameAndType [240] [241] 
.const [111] = Utf8 'ScreenCacheImpl#leaveCurrentApplication leaving application: %1 took: %2' 
.const [112] = Class [242] 
.const [113] = NameAndType [243] [244] 
.const [114] = Utf8 de/esolutions/hmi/widgets/audi/base/HMITerminalImpl 
.const [115] = Utf8 'ScreenCacheImpl#clear applicationId=%1' 
.const [116] = Utf8 'ScreenCacheImpl#clear remove screen(%1) from cache' 
.const [117] = Utf8 screenCacheSizePassive 
.const [118] = Class [245] 
.const [119] = NameAndType [246] [247] 
.const [120] = Utf8 screenCacheSizeActive 
.const [121] = Utf8 de/esolutions/hmi/widgets/audi/base/ScreenCacheImpl 
.const [122] = Utf8 java/lang/Object 
.const [123] = Utf8 de/esolutions/hmi/widgets/audi/base/AbstractWidget 
.const [124] = Utf8 de/audi/atip/base/IFrameworkAccess 
.const [125] = Utf8 de/audi/atip/log/LogChannel 
.const [126] = Utf8 java/util/Map 
.const [127] = Utf8 java/lang/System 
.const [128] = Utf8 de/audi/atip/hmi/IHMITerminalRegistry 
.const [129] = Utf8 de/esolutions/hmi/widgets/audi/base/IDrawerManager 
.const [130] = Utf8 java/util/Collection 
.const [131] = Utf8 java/util/Iterator 
.const [132] = Class [248] 
.const [133] = NameAndType [249] [250] 
.const [134] = Class [251] 
.const [135] = NameAndType [252] [253] 
.const [136] = Class [254] 
.const [137] = NameAndType [255] [256] 
.const [138] = Class [257] 
.const [139] = NameAndType [258] [259] 
.const [140] = Class [260] 
.const [141] = NameAndType [261] [262] 
.const [142] = Class [263] 
.const [143] = NameAndType [264] [265] 
.const [144] = Class [266] 
.const [145] = NameAndType [267] [268] 
.const [146] = Class [269] 
.const [147] = NameAndType [270] [271] 
.const [148] = Class [272] 
.const [149] = NameAndType [273] [274] 
.const [150] = Class [275] 
.const [151] = NameAndType [276] [277] 
.const [152] = Class [278] 
.const [153] = NameAndType [279] [280] 
.const [154] = Class [281] 
.const [155] = NameAndType [282] [283] 
.const [156] = Class [284] 
.const [157] = NameAndType [285] [286] 
.const [158] = Class [287] 
.const [159] = NameAndType [288] [289] 
.const [160] = Class [290] 
.const [161] = NameAndType [291] [292] 
.const [162] = Class [293] 
.const [163] = NameAndType [294] [295] 
.const [164] = Class [296] 
.const [165] = NameAndType [297] [298] 
.const [166] = Class [299] 
.const [167] = NameAndType [300] [301] 
.const [168] = Class [302] 
.const [169] = NameAndType [303] [304] 
.const [170] = Class [305] 
.const [171] = NameAndType [306] [307] 
.const [172] = Class [308] 
.const [173] = NameAndType [309] [310] 
.const [174] = Class [311] 
.const [175] = NameAndType [312] [313] 
.const [176] = Class [314] 
.const [177] = NameAndType [315] [316] 
.const [178] = Class [317] 
.const [179] = NameAndType [318] [319] 
.const [180] = Class [320] 
.const [181] = NameAndType [321] [322] 
.const [182] = Class [323] 
.const [183] = NameAndType [324] [325] 
.const [184] = Class [326] 
.const [185] = NameAndType [327] [328] 
.const [186] = Class [329] 
.const [187] = NameAndType [330] [331] 
.const [188] = Utf8 java/util/HashMap 
.const [189] = Class [332] 
.const [190] = NameAndType [333] [334] 
.const [191] = Class [335] 
.const [192] = NameAndType [336] [337] 
.const [193] = Class [338] 
.const [194] = NameAndType [339] [340] 
.const [195] = Class [341] 
.const [196] = NameAndType [342] [343] 
.const [197] = Class [344] 
.const [198] = NameAndType [345] [346] 
.const [199] = Class [347] 
.const [200] = NameAndType [348] [349] 
.const [201] = Class [350] 
.const [202] = NameAndType [351] [352] 
.const [203] = Class [353] 
.const [204] = NameAndType [354] [355] 
.const [205] = Utf8 java/lang/Integer 
.const [206] = Class [356] 
.const [207] = NameAndType [357] [358] 
.const [208] = Utf8 java/util/ArrayList 
.const [209] = Class [359] 
.const [210] = NameAndType [360] [361] 
.const [211] = Class [362] 
.const [212] = NameAndType [363] [364] 
.const [213] = Class [365] 
.const [214] = NameAndType [366] [367] 
.const [215] = Class [368] 
.const [216] = NameAndType [369] [370] 
.const [217] = Class [371] 
.const [218] = NameAndType [372] [373] 
.const [219] = Class [374] 
.const [220] = NameAndType [375] [376] 
.const [221] = Class [377] 
.const [222] = NameAndType [378] [379] 
.const [223] = Class [380] 
.const [224] = NameAndType [381] [382] 
.const [225] = Class [383] 
.const [226] = NameAndType [384] [385] 
.const [227] = Class [386] 
.const [228] = NameAndType [387] [388] 
.const [229] = Class [389] 
.const [230] = NameAndType [390] [391] 
.const [231] = Class [392] 
.const [232] = NameAndType [393] [394] 
.const [233] = Utf8 de/esolutions/hmi/widgets/audi/base/AbstractWidget 
.const [234] = Utf8 framework 
.const [235] = Utf8 Lde/audi/atip/base/IFrameworkAccess; 
.const [236] = Utf8 de/esolutions/hmi/widgets/audi/base/ScreenCacheImpl 
.const [237] = Utf8 MAX_SCREENS_ACTIVE_APPLICATION 
.const [238] = Utf8 I 
.const [239] = Utf8 de/esolutions/hmi/widgets/audi/base/ScreenCacheImpl 
.const [240] = Utf8 MAX_SCREENS_PASSIVE_APPLICATION 
.const [241] = Utf8 I 
.const [242] = Utf8 java/lang/System 
.const [243] = Utf8 currentTimeMillis 
.const [244] = Utf8 ()J 
.const [245] = Utf8 java/lang/Integer 
.const [246] = Utf8 getInteger 
.const [247] = Utf8 (Ljava/lang/String;I)Ljava/lang/Integer; 
.const [248] = Utf8 de/esolutions/hmi/widgets/audi/base/ScreenCacheImpl 
.const [249] = Utf8 screenCache 
.const [250] = Utf8 Ljava/util/Map; 
.const [251] = Utf8 de/esolutions/hmi/widgets/audi/base/ScreenCacheImpl 
.const [252] = Utf8 currentApplicationID 
.const [253] = Utf8 I 
.const [254] = Utf8 de/esolutions/hmi/widgets/audi/base/ScreenCacheImpl 
.const [255] = Utf8 cachedScreensPerApplication 
.const [256] = Utf8 Ljava/util/Map; 
.const [257] = Utf8 de/esolutions/hmi/widgets/audi/base/ScreenCacheImpl 
.const [258] = Utf8 cachingDisabled 
.const [259] = Utf8 Z 
.const [260] = Utf8 de/esolutions/hmi/widgets/audi/base/ScreenCacheImpl 
.const [261] = Utf8 logScreenCache 
.const [262] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [263] = Utf8 de/audi/atip/log/LogChannel 
.const [264] = Utf8 log 
.const [265] = Utf8 (ILjava/lang/String;J)Z 
.const [266] = Utf8 de/audi/atip/log/LogChannel 
.const [267] = Utf8 log 
.const [268] = Utf8 (ILjava/lang/String;JJ)Z 
.const [269] = Utf8 java/util/ArrayList 
.const [270] = Utf8 add 
.const [271] = Utf8 (Ljava/lang/Object;)Z 
.const [272] = Utf8 java/util/ArrayList 
.const [273] = Utf8 contains 
.const [274] = Utf8 (Ljava/lang/Object;)Z 
.const [275] = Utf8 java/util/ArrayList 
.const [276] = Utf8 indexOf 
.const [277] = Utf8 (Ljava/lang/Object;)I 
.const [278] = Utf8 java/util/ArrayList 
.const [279] = Utf8 remove 
.const [280] = Utf8 (I)Ljava/lang/Object; 
.const [281] = Utf8 java/util/ArrayList 
.const [282] = Utf8 add 
.const [283] = Utf8 (ILjava/lang/Object;)V 
.const [284] = Utf8 java/util/ArrayList 
.const [285] = Utf8 size 
.const [286] = Utf8 ()I 
.const [287] = Utf8 de/esolutions/hmi/widgets/audi/base/HMITerminalImpl 
.const [288] = Utf8 getDrawerManager 
.const [289] = Utf8 ()Lde/esolutions/hmi/widgets/audi/base/IDrawerManager; 
.const [290] = Utf8 java/lang/Integer 
.const [291] = Utf8 intValue 
.const [292] = Utf8 ()I 
.const [293] = Utf8 java/lang/Object 
.const [294] = Utf8 <init> 
.const [295] = Utf8 ()V 
.const [296] = Utf8 java/util/HashMap 
.const [297] = Utf8 <init> 
.const [298] = Utf8 ()V 
.const [299] = Utf8 de/esolutions/hmi/widgets/audi/base/ScreenCacheImpl 
.const [300] = Utf8 insertIntoCache 
.const [301] = Utf8 (Lde/audi/atip/hmi/view/Screen;)V 
.const [302] = Utf8 de/esolutions/hmi/widgets/audi/base/ScreenCacheImpl 
.const [303] = Utf8 handleScreenChange 
.const [304] = Utf8 (Lde/audi/atip/hmi/view/Screen;)V 
.const [305] = Utf8 de/esolutions/hmi/widgets/audi/base/ScreenCacheImpl 
.const [306] = Utf8 changeInSameApplication 
.const [307] = Utf8 (Lde/audi/atip/hmi/view/Screen;)V 
.const [308] = Utf8 de/esolutions/hmi/widgets/audi/base/ScreenCacheImpl 
.const [309] = Utf8 leaveCurrentApplication 
.const [310] = Utf8 ()V 
.const [311] = Utf8 java/lang/Integer 
.const [312] = Utf8 <init> 
.const [313] = Utf8 (I)V 
.const [314] = Utf8 java/util/ArrayList 
.const [315] = Utf8 <init> 
.const [316] = Utf8 (I)V 
.const [317] = Utf8 de/esolutions/hmi/widgets/audi/base/ScreenCacheImpl 
.const [318] = Utf8 MAX_SCREENS_ACTIVE_APPLICATION 
.const [319] = Utf8 I 
.const [320] = Utf8 de/esolutions/hmi/widgets/audi/base/ScreenCacheImpl 
.const [321] = Utf8 removeFromCache 
.const [322] = Utf8 (Lde/audi/atip/hmi/view/Screen;)V 
.const [323] = Utf8 de/esolutions/hmi/widgets/audi/base/ScreenCacheImpl 
.const [324] = Utf8 MAX_SCREENS_PASSIVE_APPLICATION 
.const [325] = Utf8 I 
.const [326] = Utf8 de/esolutions/hmi/widgets/audi/base/ScreenCacheImpl 
.const [327] = Utf8 clearDrawerCache 
.const [328] = Utf8 ()V 
.const [329] = Utf8 de/esolutions/hmi/widgets/audi/base/ScreenCacheImpl 
.const [330] = Utf8 removeScreensFromCache 
.const [331] = Utf8 (I)V 
.const [332] = Utf8 de/esolutions/hmi/widgets/audi/base/ScreenCacheImpl 
.const [333] = Utf8 screenCache 
.const [334] = Utf8 Ljava/util/Map; 
.const [335] = Utf8 de/esolutions/hmi/widgets/audi/base/ScreenCacheImpl 
.const [336] = Utf8 currentApplicationID 
.const [337] = Utf8 I 
.const [338] = Utf8 de/esolutions/hmi/widgets/audi/base/ScreenCacheImpl 
.const [339] = Utf8 cachedScreensPerApplication 
.const [340] = Utf8 Ljava/util/Map; 
.const [341] = Utf8 de/esolutions/hmi/widgets/audi/base/ScreenCacheImpl 
.const [342] = Utf8 cachingDisabled 
.const [343] = Utf8 Z 
.const [344] = Utf8 de/audi/atip/base/IFrameworkAccess 
.const [345] = Utf8 getLogChannel 
.const [346] = Utf8 (Ljava/lang/String;)Lde/audi/atip/log/LogChannel; 
.const [347] = Utf8 de/esolutions/hmi/widgets/audi/base/ScreenCacheImpl 
.const [348] = Utf8 logScreenCache 
.const [349] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [350] = Utf8 de/audi/atip/hmi/view/Screen 
.const [351] = Utf8 getCacheBehaviour 
.const [352] = Utf8 ()I 
.const [353] = Utf8 de/audi/atip/hmi/view/Screen 
.const [354] = Utf8 getID 
.const [355] = Utf8 ()I 
.const [356] = Utf8 java/util/Map 
.const [357] = Utf8 get 
.const [358] = Utf8 (Ljava/lang/Object;)Ljava/lang/Object; 
.const [359] = Utf8 java/util/Map 
.const [360] = Utf8 put 
.const [361] = Utf8 (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object; 
.const [362] = Utf8 java/util/Map 
.const [363] = Utf8 remove 
.const [364] = Utf8 (Ljava/lang/Object;)Ljava/lang/Object; 
.const [365] = Utf8 de/audi/atip/base/IFrameworkAccess 
.const [366] = Utf8 getMonotonicTime 
.const [367] = Utf8 ()J 
.const [368] = Utf8 java/util/Map 
.const [369] = Utf8 clear 
.const [370] = Utf8 ()V 
.const [371] = Utf8 de/audi/atip/base/IFrameworkAccess 
.const [372] = Utf8 getHMITerminalRegistry 
.const [373] = Utf8 ()Lde/audi/atip/hmi/IHMITerminalRegistry; 
.const [374] = Utf8 de/audi/atip/hmi/IHMITerminalRegistry 
.const [375] = Utf8 getTerminal 
.const [376] = Utf8 (I)Lde/audi/atip/hmi/HMITerminal; 
.const [377] = Utf8 de/esolutions/hmi/widgets/audi/base/IDrawerManager 
.const [378] = Utf8 clear 
.const [379] = Utf8 ()V 
.const [380] = Utf8 java/util/Map 
.const [381] = Utf8 values 
.const [382] = Utf8 ()Ljava/util/Collection; 
.const [383] = Utf8 java/util/Collection 
.const [384] = Utf8 iterator 
.const [385] = Utf8 ()Ljava/util/Iterator; 
.const [386] = Utf8 java/util/Iterator 
.const [387] = Utf8 hasNext 
.const [388] = Utf8 ()Z 
.const [389] = Utf8 java/util/Iterator 
.const [390] = Utf8 next 
.const [391] = Utf8 ()Ljava/lang/Object; 
.const [392] = Utf8 java/util/Iterator 
.const [393] = Utf8 remove 
.const [394] = Utf8 ()V 
.const [395] = Utf8 de/esolutions/hmi/widgets/audi/base/ScreenCacheImpl 
.const [396] = Class [395] 
.const [397] = Utf8 java/lang/Object 
.const [398] = Class [397] 
.const [399] = Utf8 de/audi/atip/hmi/view/ScreenCache 
.const [400] = Class [399] 
.const [401] = Utf8 MAX_SCREENS_PASSIVE_APPLICATION 
.const [402] = Utf8 I 
.const [403] = Utf8 APPLICATION_MULTIPLIER 
.const [404] = Utf8 I 
.const [405] = Utf8 MAX_SCREENS_ACTIVE_APPLICATION 
.const [406] = Utf8 I 
.const [407] = Utf8 screenCache 
.const [408] = Utf8 Ljava/util/Map; 
.const [409] = Utf8 currentApplicationID 
.const [410] = Utf8 I 
.const [411] = Utf8 cachedScreensPerApplication 
.const [412] = Utf8 Ljava/util/Map; 
.const [413] = Utf8 cachingDisabled 
.const [414] = Utf8 Z 
.const [415] = Utf8 logScreenCache 
.const [416] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [417] = Utf8 Code 
.const [418] = Utf8 <init> 
.const [419] = Utf8 ()V 
.const [420] = Utf8 putScreen 
.const [421] = Utf8 (Lde/audi/atip/hmi/view/Screen;)V 
.const [422] = Utf8 handleScreenChange 
.const [423] = Utf8 (Lde/audi/atip/hmi/view/Screen;)V 
.const [424] = Utf8 getScreen 
.const [425] = Utf8 (I)Lde/audi/atip/hmi/view/Screen; 
.const [426] = Utf8 changeInSameApplication 
.const [427] = Utf8 (Lde/audi/atip/hmi/view/Screen;)V 
.const [428] = Utf8 insertIntoCache 
.const [429] = Utf8 (Lde/audi/atip/hmi/view/Screen;)V 
.const [430] = Utf8 removeFromCache 
.const [431] = Utf8 (Lde/audi/atip/hmi/view/Screen;)V 
.const [432] = Utf8 leaveCurrentApplication 
.const [433] = Utf8 ()V 
.const [434] = Utf8 clear 
.const [435] = Utf8 ()V 
.const [436] = Utf8 clearDrawerCache 
.const [437] = Utf8 ()V 
.const [438] = Utf8 clear 
.const [439] = Utf8 (I)V 
.const [440] = Utf8 removeScreensFromCache 
.const [441] = Utf8 (I)V 
.const [442] = Utf8 setCachingDisabled 
.const [443] = Utf8 (Z)V 
.const [444] = Utf8 <clinit> 
.const [445] = Utf8 ()V 
.end class 
