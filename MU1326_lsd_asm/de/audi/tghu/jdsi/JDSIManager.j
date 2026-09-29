.version 50 0 
.class public final super [515] 
.super [517] 
.implements [519] 
.field public static final [520] [521] 
.field public static final [522] [523] 
.field public static final [524] [525] 
.field private static final [526] [527] 
.field private final [528] [529] 
.field private [530] [531] 
.field private [532] [533] 
.field private final [534] [535] 
.field private final [536] [537] 
.field private final [538] [539] 
.field static synthetic [540] [541] 

.method [543] : [544] 
    .attribute [542] .code stack 4 locals 0 
L0:     aload_0 
L1:     invokespecial [86] 
L4:     aload_0 
L5:     aconst_null 
L6:     putfield [103] 
L9:     aload_0 
L10:    new [104] 
L13:    dup 
L14:    sipush 200 
L17:    invokespecial [87] 
L20:    putfield [105] 
L23:    aload_0 
L24:    new [104] 
L27:    dup 
L28:    sipush 200 
L31:    invokespecial [87] 
L34:    putfield [106] 
L37:    aload_0 
L38:    aload_1 
L39:    putfield [101] 
L42:    aload_0 
L43:    aload_1 
L44:    ldc [6] 
L46:    invokeinterface [107] 0 
L51:    putfield [108] 
L54:    aload_0 
L55:    new [109] 
L58:    dup 
L59:    bipush 120 
L61:    invokespecial [88] 
L64:    putfield [110] 
L67:    aload_1 
L68:    invokeinterface [111] 0 
L73:    aload_0 
L74:    invokeinterface [112] 0 
L79:    return 
L80:    
    .end code 
.end method 

.method [545] : [546] 
    .attribute [542] .code stack 4 locals 2 
L0:     aload_0 
L1:     getfield [59] 
L4:     ldc [8] 
L6:     ldc [9] 
L8:     aload_1 
L9:     invokevirtual [61] 
L12:    pop 
L13:    aload_0 
L14:    dup 
L15:    astore_2 
L16:    monitorenter 
        .catch [0] from L17 to L24 using L27 
L17:    aload_0 
L18:    aload_1 
L19:    putfield [103] 
L22:    aload_2 
L23:    monitorexit 
L24:    goto L32 
        .catch [0] from L27 to L30 using L27 
L27:    astore_3 
L28:    aload_2 
L29:    monitorexit 
L30:    aload_3 
L31:    athrow 
L32:    aload_1 
L33:    ifnull L40 
L36:    aload_0 
L37:    invokespecial [89] 
L40:    return 
L41:    nop 
L42:    nop 
L43:    nop 
L44:    
    .end code 
.end method 

.method public interface [547] : [548] 
    .attribute [542] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [60] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method private [549] : [550] 
    .attribute [542] .code stack 6 locals 2 
L0:     new [113] 
L3:     dup 
L4:     invokespecial [90] 
L7:     ldc [11] 
L9:     invokevirtual [62] 
L12:    aload_1 
L13:    invokevirtual [62] 
L16:    ldc [12] 
L18:    invokevirtual [62] 
L21:    iload_2 
L22:    invokevirtual [63] 
L25:    ldc [13] 
L27:    invokevirtual [62] 
L30:    invokevirtual [64] 
L33:    astore_3 
        .catch [20] from L34 to L107 using L111 
L34:    aload_0 
L35:    getfield [59] 
L38:    ldc [14] 
L40:    ldc [15] 
L42:    aload_1 
L43:    iload_2 
L44:    i2l 
L45:    invokevirtual [65] 
L48:    pop 
L49:    aload_0 
L50:    getfield [54] 
L53:    invokeinterface [114] 0 
L58:    getstatic [16] 
L61:    ifnonnull L76 
L64:    ldc [17] 
L66:    invokestatic [18] 
L69:    dup 
L70:    putstatic [91] 
L73:    goto L79 
L76:    getstatic [16] 
L79:    invokevirtual [66] 
L82:    aload_3 
L83:    invokeinterface [115] 0 
L88:    ifnull L108 
L91:    aload_0 
L92:    getfield [59] 
L95:    ldc [14] 
L97:    ldc [19] 
L99:    aload_1 
L100:   iload_2 
L101:   i2l 
L102:   invokevirtual [65] 
L105:   pop 
L106:   iconst_1 
L107:   areturn 
L108:   goto L130 
L111:   astore 4 
L113:   aload_0 
L114:   getfield [59] 
L117:   sipush 10000 
L120:   ldc [21] 
L122:   aload 4 
L124:   aload_3 
L125:   invokevirtual [67] 
L128:   iconst_0 
L129:   areturn 
L130:   iconst_0 
L131:   areturn 
L132:   
    .end code 
.end method 

.method private [551] : [552] 
    .attribute [542] .code stack 6 locals 0 
L0:     aload_0 
L1:     getfield [59] 
L4:     ldc [14] 
L6:     ldc [22] 
L8:     aload_2 
L9:     iload_3 
L10:    i2l 
L11:    invokevirtual [65] 
L14:    pop 
L15:    aload_1 
L16:    ifnull L47 
L19:    aload_1 
L20:    aload_2 
L21:    iload_3 
L22:    invokeinterface [116] 0 
L27:    ifeq L47 
L30:    aload_0 
L31:    getfield [57] 
L34:    new [117] 
L37:    dup 
L38:    aload_0 
L39:    aload_2 
L40:    iload_3 
L41:    invokespecial [92] 
L44:    invokevirtual [68] 
L47:    return 
L48:    
    .end code 
.end method 

.method private [553] : [554] 
    .attribute [542] .code stack 6 locals 0 
L0:     aload_0 
L1:     getfield [59] 
L4:     ldc [14] 
L6:     ldc [24] 
L8:     aload_2 
L9:     iload_3 
L10:    i2l 
L11:    invokevirtual [65] 
L14:    pop 
L15:    aload_1 
L16:    aload_2 
L17:    iload_3 
L18:    invokeinterface [118] 0 
L23:    ifeq L43 
L26:    aload_0 
L27:    getfield [57] 
L30:    new [119] 
L33:    dup 
L34:    aload_0 
L35:    aload_2 
L36:    iload_3 
L37:    invokespecial [93] 
L40:    invokevirtual [68] 
L43:    return 
L44:    
    .end code 
.end method 

.method public synchronized [555] : [556] 
    .attribute [542] .code stack 6 locals 1 
L0:     aload_0 
L1:     getfield [59] 
L4:     ldc [14] 
L6:     ldc [26] 
L8:     aload_1 
L9:     iload_2 
L10:    i2l 
L11:    invokevirtual [65] 
L14:    pop 
L15:    aload_0 
L16:    aload_1 
L17:    iload_2 
L18:    invokevirtual [69] 
L21:    astore_3 
L22:    aload_3 
L23:    invokevirtual [70] 
L26:    ifeq L65 
L29:    aload_0 
L30:    getfield [56] 
L33:    ifnull L49 
L36:    aload_0 
L37:    aload_0 
L38:    getfield [56] 
L41:    aload_1 
L42:    iload_2 
L43:    invokespecial [94] 
L46:    goto L80 
L49:    aload_0 
L50:    getfield [59] 
L53:    ldc [8] 
L55:    ldc [27] 
L57:    aload_1 
L58:    invokevirtual [61] 
L61:    pop 
L62:    goto L80 
L65:    aload_0 
L66:    getfield [59] 
L69:    ldc [14] 
L71:    ldc [28] 
L73:    aload_1 
L74:    iload_2 
L75:    i2l 
L76:    invokevirtual [65] 
L79:    pop 
L80:    return 
L81:    nop 
L82:    nop 
L83:    nop 
L84:    
    .end code 
.end method 

.method public synchronized [557] : [558] 
    .attribute [542] .code stack 6 locals 1 
L0:     aload_0 
L1:     getfield [59] 
L4:     ldc [14] 
L6:     ldc [29] 
L8:     aload_1 
L9:     iload_2 
L10:    i2l 
L11:    invokevirtual [65] 
L14:    pop 
L15:    aload_0 
L16:    aload_1 
L17:    iload_2 
L18:    invokevirtual [69] 
L21:    astore_3 
L22:    aload_3 
L23:    invokevirtual [71] 
L26:    ifeq L70 
L29:    aload_0 
L30:    getfield [56] 
L33:    ifnull L49 
L36:    aload_0 
L37:    aload_0 
L38:    getfield [56] 
L41:    aload_1 
L42:    iload_2 
L43:    invokespecial [95] 
L46:    goto L68 
L49:    aload_0 
L50:    getfield [59] 
L53:    ldc [8] 
L55:    ldc [30] 
L57:    aload_1 
L58:    invokevirtual [61] 
L61:    pop 
L62:    aload_0 
L63:    aload_1 
L64:    iload_2 
L65:    invokespecial [96] 
L68:    iconst_1 
L69:    areturn 
L70:    aload_0 
L71:    getfield [59] 
L74:    ldc [14] 
L76:    ldc [31] 
L78:    aload_1 
L79:    iload_2 
L80:    i2l 
L81:    invokevirtual [65] 
L84:    pop 
L85:    iconst_0 
L86:    areturn 
L87:    nop 
L88:    
    .end code 
.end method 

.method [559] : [560] 
    .attribute [542] .code stack 5 locals 1 
L0:     aload_0 
L1:     getfield [60] 
L4:     aload_1 
L5:     iload_2 
L6:     invokevirtual [72] 
L9:     astore_3 
L10:    aload_3 
L11:    ifnonnull L33 
L14:    new [120] 
L17:    dup 
L18:    aconst_null 
L19:    aload_1 
L20:    iload_2 
L21:    invokespecial [97] 
L24:    astore_3 
L25:    aload_0 
L26:    getfield [60] 
L29:    aload_3 
L30:    invokevirtual [73] 
L33:    aload_3 
L34:    areturn 
L35:    nop 
L36:    
    .end code 
.end method 

.method [561] : [562] 
    .attribute [542] .code stack 6 locals 1 
L0:     aload_0 
L1:     aload_1 
L2:     iload_2 
L3:     invokevirtual [69] 
L6:     astore_3 
L7:     aload_0 
L8:     getfield [59] 
L11:    ldc [14] 
L13:    ldc [33] 
L15:    aload_1 
L16:    iload_2 
L17:    i2l 
L18:    invokevirtual [65] 
L21:    pop 
L22:    aload_3 
L23:    aconst_null 
L24:    invokevirtual [74] 
L27:    return 
L28:    
    .end code 
.end method 

.method private [563] : [564] 
    .attribute [542] .code stack 6 locals 1 
L0:     aload_0 
L1:     getfield [59] 
L4:     ldc [14] 
L6:     ldc [34] 
L8:     aload_1 
L9:     iload_2 
L10:    i2l 
L11:    invokevirtual [65] 
L14:    pop 
L15:    aload_0 
L16:    aload_1 
L17:    iload_2 
L18:    invokevirtual [69] 
L21:    astore_3 
L22:    aload_3 
L23:    new [121] 
L26:    dup 
L27:    aload_0 
L28:    iconst_0 
L29:    iconst_0 
L30:    invokespecial [98] 
L33:    invokevirtual [74] 
L36:    return 
L37:    nop 
L38:    nop 
L39:    nop 
L40:    
    .end code 
.end method 

.method private synchronized [565] : [566] 
    .attribute [542] .code stack 4 locals 2 
L0:     aload_0 
L1:     getfield [59] 
L4:     ldc [8] 
L6:     ldc [36] 
L8:     invokevirtual [75] 
L11:    pop 
L12:    aload_0 
L13:    getfield [56] 
L16:    ifnonnull L20 
L19:    return 
L20:    aload_0 
L21:    getfield [60] 
L24:    invokevirtual [76] 
L27:    astore_1 
L28:    aload_1 
L29:    invokeinterface [122] 0 
L34:    ifeq L38 
L37:    return 
L38:    aload_1 
L39:    iconst_0 
L40:    invokeinterface [123] 0 
L45:    checkcast [32] 
L48:    astore_2 
L49:    aload_2 
L50:    aconst_null 
L51:    invokevirtual [74] 
L54:    aload_0 
L55:    aload_0 
L56:    getfield [56] 
L59:    aload_2 
L60:    invokevirtual [77] 
L63:    aload_2 
L64:    invokevirtual [78] 
L67:    invokespecial [95] 
L70:    goto L12 
L73:    nop 
L74:    nop 
L75:    nop 
L76:    
    .end code 
.end method 

.method public [567] : [568] 
    .attribute [542] .code stack 3 locals 2 
L0:     aload_1 
L1:     ldc [37] 
L3:     invokevirtual [79] 
L6:     aload_0 
L7:     getfield [60] 
L10:    invokevirtual [76] 
L13:    astore_3 
L14:    iconst_0 
L15:    istore 4 
L17:    iload 4 
L19:    aload_3 
L20:    invokeinterface [124] 0 
L25:    if_icmpge L46 
L28:    aload_1 
L29:    aload_3 
L30:    iload 4 
L32:    invokeinterface [123] 0 
L37:    invokevirtual [80] 
L40:    iinc 4 1 
L43:    goto L17 
L46:    aload_1 
L47:    invokevirtual [81] 
L50:    aload_1 
L51:    ldc [38] 
L53:    invokevirtual [79] 
L56:    aload_1 
L57:    invokevirtual [81] 
L60:    aload_1 
L61:    ldc [39] 
L63:    invokevirtual [79] 
L66:    iconst_0 
L67:    istore 4 
L69:    iload 4 
L71:    aload_0 
L72:    getfield [57] 
L75:    invokevirtual [82] 
L78:    if_icmpge L100 
L81:    aload_1 
L82:    aload_0 
L83:    getfield [57] 
L86:    iload 4 
L88:    invokevirtual [83] 
L91:    invokevirtual [80] 
L94:    iinc 4 1 
L97:    goto L69 
L100:   aload_1 
L101:   ldc [40] 
L103:   invokevirtual [79] 
L106:   iconst_0 
L107:   istore 4 
L109:   iload 4 
L111:   aload_0 
L112:   getfield [58] 
L115:   invokevirtual [82] 
L118:   if_icmpge L140 
L121:   aload_1 
L122:   aload_0 
L123:   getfield [58] 
L126:   iload 4 
L128:   invokevirtual [83] 
L131:   invokevirtual [80] 
L134:   iinc 4 1 
L137:   goto L109 
L140:   return 
L141:   nop 
L142:   nop 
L143:   nop 
L144:   
    .end code 
.end method 

.method public [569] : [570] 
    .attribute [542] .code stack 1 locals 0 
L0:     ldc [41] 
L2:     areturn 
L3:     nop 
L4:     
    .end code 
.end method 

.method [571] : [572] 
    .attribute [542] .code stack 6 locals 1 
L0:     aload_1 
L1:     ifnull L21 
L4:     aload_0 
L5:     getfield [58] 
L8:     new [125] 
L11:    dup 
L12:    aload_0 
L13:    aload_2 
L14:    iload_3 
L15:    invokespecial [99] 
L18:    invokevirtual [68] 
L21:    aload_0 
L22:    aload_2 
L23:    iload_3 
L24:    invokevirtual [69] 
L27:    astore 4 
L29:    aload 4 
L31:    aload_1 
L32:    invokevirtual [84] 
L35:    return 
L36:    
    .end code 
.end method 

.method [573] : [574] 
    .attribute [542] .code stack 6 locals 1 
L0:     aload_0 
L1:     getfield [58] 
L4:     new [126] 
L7:     dup 
L8:     aload_0 
L9:     aload_2 
L10:    iload_3 
L11:    invokespecial [100] 
L14:    invokevirtual [68] 
L17:    aload_0 
L18:    aload_2 
L19:    iload_3 
L20:    invokevirtual [69] 
L23:    astore 4 
L25:    aload 4 
L27:    aconst_null 
L28:    invokevirtual [84] 
L31:    return 
L32:    
    .end code 
.end method 

.method static synthetic [575] : [576] 
    .attribute [542] .code stack 2 locals 1 
        .catch [3] from L0 to L4 using L5 
L0:     aload_0 
L1:     invokestatic [2] 
L4:     areturn 
L5:     astore_1 
L6:     new [102] 
L9:     dup 
L10:    invokespecial [85] 
L13:    aload_1 
L14:    invokevirtual [55] 
L17:    athrow 
L18:    nop 
L19:    nop 
L20:    
    .end code 
.end method 

.method static synthetic [577] : [578] 
    .attribute [542] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [54] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Method [127] [128] 
.const [3] = Class [129] 
.const [4] = Class [130] 
.const [5] = Class [131] 
.const [6] = String [132] 
.const [7] = Class [133] 
.const [8] = Int -1601830656 
.const [9] = String [134] 
.const [10] = Class [135] 
.const [11] = String [136] 
.const [12] = String [137] 
.const [13] = String [138] 
.const [14] = Int 1078071040 
.const [15] = String [139] 
.const [16] = Field [140] [141] 
.const [17] = String [142] 
.const [18] = Method [143] [144] 
.const [19] = String [145] 
.const [20] = Class [146] 
.const [21] = String [147] 
.const [22] = String [148] 
.const [23] = Class [149] 
.const [24] = String [150] 
.const [25] = Class [151] 
.const [26] = String [152] 
.const [27] = String [153] 
.const [28] = String [154] 
.const [29] = String [155] 
.const [30] = String [156] 
.const [31] = String [157] 
.const [32] = Class [158] 
.const [33] = String [159] 
.const [34] = String [160] 
.const [35] = Class [161] 
.const [36] = String [162] 
.const [37] = String [163] 
.const [38] = String [164] 
.const [39] = String [165] 
.const [40] = String [166] 
.const [41] = String [167] 
.const [42] = Class [168] 
.const [43] = Class [169] 
.const [44] = Class [170] 
.const [45] = Class [171] 
.const [46] = Class [172] 
.const [47] = Class [173] 
.const [48] = Class [174] 
.const [49] = Class [175] 
.const [50] = Class [176] 
.const [51] = Class [177] 
.const [52] = Class [178] 
.const [53] = Class [179] 
.const [54] = Field [180] [181] 
.const [55] = Method [182] [183] 
.const [56] = Field [184] [185] 
.const [57] = Field [186] [187] 
.const [58] = Field [188] [189] 
.const [59] = Field [190] [191] 
.const [60] = Field [192] [193] 
.const [61] = Method [194] [195] 
.const [62] = Method [196] [197] 
.const [63] = Method [198] [199] 
.const [64] = Method [200] [201] 
.const [65] = Method [202] [203] 
.const [66] = Method [204] [205] 
.const [67] = Method [206] [207] 
.const [68] = Method [208] [209] 
.const [69] = Method [210] [211] 
.const [70] = Method [212] [213] 
.const [71] = Method [214] [215] 
.const [72] = Method [216] [217] 
.const [73] = Method [218] [219] 
.const [74] = Method [220] [221] 
.const [75] = Method [222] [223] 
.const [76] = Method [224] [225] 
.const [77] = Method [226] [227] 
.const [78] = Method [228] [229] 
.const [79] = Method [230] [231] 
.const [80] = Method [232] [233] 
.const [81] = Method [234] [235] 
.const [82] = Method [236] [237] 
.const [83] = Method [238] [239] 
.const [84] = Method [240] [241] 
.const [85] = Method [242] [243] 
.const [86] = Method [244] [245] 
.const [87] = Method [246] [247] 
.const [88] = Method [248] [249] 
.const [89] = Method [250] [251] 
.const [90] = Method [252] [253] 
.const [91] = Field [254] [255] 
.const [92] = Method [256] [257] 
.const [93] = Method [258] [259] 
.const [94] = Method [260] [261] 
.const [95] = Method [262] [263] 
.const [96] = Method [264] [265] 
.const [97] = Method [266] [267] 
.const [98] = Method [268] [269] 
.const [99] = Method [270] [271] 
.const [100] = Method [272] [273] 
.const [101] = Field [274] [275] 
.const [102] = Class [276] 
.const [103] = Field [277] [278] 
.const [104] = Class [279] 
.const [105] = Field [280] [281] 
.const [106] = Field [282] [283] 
.const [107] = InterfaceMethod [284] [285] 
.const [108] = Field [286] [287] 
.const [109] = Class [288] 
.const [110] = Field [289] [290] 
.const [111] = InterfaceMethod [291] [292] 
.const [112] = InterfaceMethod [293] [294] 
.const [113] = Class [295] 
.const [114] = InterfaceMethod [296] [297] 
.const [115] = InterfaceMethod [298] [299] 
.const [116] = InterfaceMethod [300] [301] 
.const [117] = Class [302] 
.const [118] = InterfaceMethod [303] [304] 
.const [119] = Class [305] 
.const [120] = Class [306] 
.const [121] = Class [307] 
.const [122] = InterfaceMethod [308] [309] 
.const [123] = InterfaceMethod [310] [311] 
.const [124] = InterfaceMethod [312] [313] 
.const [125] = Class [314] 
.const [126] = Class [315] 
.const [127] = Class [316] 
.const [128] = NameAndType [317] [318] 
.const [129] = Utf8 java/lang/ClassNotFoundException 
.const [130] = Utf8 java/lang/NoClassDefFoundError 
.const [131] = Utf8 de/esolutions/fw/util/commons/RingBuffer 
.const [132] = Utf8 'Fw.JDSI.Admin' 
.const [133] = Utf8 de/audi/tghu/jdsi/JDSIServiceMap 
.const [134] = Utf8 'JDSIManager.setServiceAdmin(%1)' 
.const [135] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [136] = Utf8 '(&(DEVICE_NAME=' 
.const [137] = Utf8 'Listener)(DEVICE_INSTANCE=' 
.const [138] = Utf8 '))' 
.const [139] = Utf8 'Searching Listener for DSI Service %1, Instance %2' 
.const [140] = Class [319] 
.const [141] = NameAndType [320] [321] 
.const [142] = Utf8 'org.dsi.ifc.base.DSIListener' 
.const [143] = Class [322] 
.const [144] = NameAndType [323] [324] 
.const [145] = Utf8 'Found DSI Listener for %1 Instance %2!' 
.const [146] = Utf8 org/osgi/framework/InvalidSyntaxException 
.const [147] = Utf8 'This should never happen! filter is : %1' 
.const [148] = Utf8 'startServiceInternal(DSI Service %1, Instance %2)' 
.const [149] = Utf8 de/audi/tghu/jdsi/JDSIManager$DSIHistoryStartService 
.const [150] = Utf8 'stopServiceInternal(DSI Service %1, Instance %2)' 
.const [151] = Utf8 de/audi/tghu/jdsi/JDSIManager$DSIHistoryStopService 
.const [152] = Utf8 'Stopping DSI Service: %1 Instance: %2!' 
.const [153] = Utf8 'Stopping DSI Service: %1 - ServiceAdmin not available!' 
.const [154] = Utf8 'Skip stopping DSI Service %1 Instance %2!' 
.const [155] = Utf8 'Starting DSI Service %1 Instance %2!' 
.const [156] = Utf8 'Starting DSI Service: %1 delayed! ServiceAdmin not available!' 
.const [157] = Utf8 'DSI Service: %1 Instance: %2 has already started!' 
.const [158] = Utf8 de/audi/tghu/jdsi/JDSIManager$DSIInstance 
.const [159] = Utf8 'removePendingDSIStart(%1,%2)' 
.const [160] = Utf8 'enqueueDSIStart(%1:%2)' 
.const [161] = Utf8 de/audi/tghu/jdsi/JDSIManager$PendingDSIStart 
.const [162] = Utf8 startQueuedDSIs 
.const [163] = Utf8 'Pending:' 
.const [164] = Utf8 'History:' 
.const [165] = Utf8 'Start-Service:' 
.const [166] = Utf8 'Service-Registered/Removed:' 
.const [167] = Utf8 JDSIManager 
.const [168] = Utf8 de/audi/tghu/jdsi/JDSIManager$DSIHistoryServiceRegistered 
.const [169] = Utf8 de/audi/tghu/jdsi/JDSIManager$DSIHistoryServiceRemoved 
.const [170] = Utf8 de/audi/tghu/jdsi/JDSIManager 
.const [171] = Utf8 java/lang/Object 
.const [172] = Utf8 java/lang/Class 
.const [173] = Utf8 de/audi/atip/base/IFrameworkAccess 
.const [174] = Utf8 de/audi/atip/error/IErrorManager 
.const [175] = Utf8 de/audi/atip/log/LogChannel 
.const [176] = Utf8 org/osgi/framework/BundleContext 
.const [177] = Utf8 org/dsi/ifc/base/ServiceAdmin 
.const [178] = Utf8 java/util/List 
.const [179] = Utf8 java/io/PrintStream 
.const [180] = Class [325] 
.const [181] = NameAndType [326] [327] 
.const [182] = Class [328] 
.const [183] = NameAndType [329] [330] 
.const [184] = Class [331] 
.const [185] = NameAndType [332] [333] 
.const [186] = Class [334] 
.const [187] = NameAndType [335] [336] 
.const [188] = Class [337] 
.const [189] = NameAndType [338] [339] 
.const [190] = Class [340] 
.const [191] = NameAndType [341] [342] 
.const [192] = Class [343] 
.const [193] = NameAndType [344] [345] 
.const [194] = Class [346] 
.const [195] = NameAndType [347] [348] 
.const [196] = Class [349] 
.const [197] = NameAndType [350] [351] 
.const [198] = Class [352] 
.const [199] = NameAndType [353] [354] 
.const [200] = Class [355] 
.const [201] = NameAndType [356] [357] 
.const [202] = Class [358] 
.const [203] = NameAndType [359] [360] 
.const [204] = Class [361] 
.const [205] = NameAndType [362] [363] 
.const [206] = Class [364] 
.const [207] = NameAndType [365] [366] 
.const [208] = Class [367] 
.const [209] = NameAndType [368] [369] 
.const [210] = Class [370] 
.const [211] = NameAndType [371] [372] 
.const [212] = Class [373] 
.const [213] = NameAndType [374] [375] 
.const [214] = Class [376] 
.const [215] = NameAndType [377] [378] 
.const [216] = Class [379] 
.const [217] = NameAndType [380] [381] 
.const [218] = Class [382] 
.const [219] = NameAndType [383] [384] 
.const [220] = Class [385] 
.const [221] = NameAndType [386] [387] 
.const [222] = Class [388] 
.const [223] = NameAndType [389] [390] 
.const [224] = Class [391] 
.const [225] = NameAndType [392] [393] 
.const [226] = Class [394] 
.const [227] = NameAndType [395] [396] 
.const [228] = Class [397] 
.const [229] = NameAndType [398] [399] 
.const [230] = Class [400] 
.const [231] = NameAndType [401] [402] 
.const [232] = Class [403] 
.const [233] = NameAndType [404] [405] 
.const [234] = Class [406] 
.const [235] = NameAndType [407] [408] 
.const [236] = Class [409] 
.const [237] = NameAndType [410] [411] 
.const [238] = Class [412] 
.const [239] = NameAndType [413] [414] 
.const [240] = Class [415] 
.const [241] = NameAndType [416] [417] 
.const [242] = Class [418] 
.const [243] = NameAndType [419] [420] 
.const [244] = Class [421] 
.const [245] = NameAndType [422] [423] 
.const [246] = Class [424] 
.const [247] = NameAndType [425] [426] 
.const [248] = Class [427] 
.const [249] = NameAndType [428] [429] 
.const [250] = Class [430] 
.const [251] = NameAndType [431] [432] 
.const [252] = Class [433] 
.const [253] = NameAndType [434] [435] 
.const [254] = Class [436] 
.const [255] = NameAndType [437] [438] 
.const [256] = Class [439] 
.const [257] = NameAndType [440] [441] 
.const [258] = Class [442] 
.const [259] = NameAndType [443] [444] 
.const [260] = Class [445] 
.const [261] = NameAndType [446] [447] 
.const [262] = Class [448] 
.const [263] = NameAndType [449] [450] 
.const [264] = Class [451] 
.const [265] = NameAndType [452] [453] 
.const [266] = Class [454] 
.const [267] = NameAndType [455] [456] 
.const [268] = Class [457] 
.const [269] = NameAndType [458] [459] 
.const [270] = Class [460] 
.const [271] = NameAndType [461] [462] 
.const [272] = Class [463] 
.const [273] = NameAndType [464] [465] 
.const [274] = Class [466] 
.const [275] = NameAndType [467] [468] 
.const [276] = Utf8 java/lang/NoClassDefFoundError 
.const [277] = Class [469] 
.const [278] = NameAndType [470] [471] 
.const [279] = Utf8 de/esolutions/fw/util/commons/RingBuffer 
.const [280] = Class [472] 
.const [281] = NameAndType [473] [474] 
.const [282] = Class [475] 
.const [283] = NameAndType [476] [477] 
.const [284] = Class [478] 
.const [285] = NameAndType [479] [480] 
.const [286] = Class [481] 
.const [287] = NameAndType [482] [483] 
.const [288] = Utf8 de/audi/tghu/jdsi/JDSIServiceMap 
.const [289] = Class [484] 
.const [290] = NameAndType [485] [486] 
.const [291] = Class [487] 
.const [292] = NameAndType [488] [489] 
.const [293] = Class [490] 
.const [294] = NameAndType [491] [492] 
.const [295] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [296] = Class [493] 
.const [297] = NameAndType [494] [495] 
.const [298] = Class [496] 
.const [299] = NameAndType [497] [498] 
.const [300] = Class [499] 
.const [301] = NameAndType [500] [501] 
.const [302] = Utf8 de/audi/tghu/jdsi/JDSIManager$DSIHistoryStartService 
.const [303] = Class [502] 
.const [304] = NameAndType [503] [504] 
.const [305] = Utf8 de/audi/tghu/jdsi/JDSIManager$DSIHistoryStopService 
.const [306] = Utf8 de/audi/tghu/jdsi/JDSIManager$DSIInstance 
.const [307] = Utf8 de/audi/tghu/jdsi/JDSIManager$PendingDSIStart 
.const [308] = Class [505] 
.const [309] = NameAndType [506] [507] 
.const [310] = Class [508] 
.const [311] = NameAndType [509] [510] 
.const [312] = Class [511] 
.const [313] = NameAndType [512] [513] 
.const [314] = Utf8 de/audi/tghu/jdsi/JDSIManager$DSIHistoryServiceRegistered 
.const [315] = Utf8 de/audi/tghu/jdsi/JDSIManager$DSIHistoryServiceRemoved 
.const [316] = Utf8 java/lang/Class 
.const [317] = Utf8 forName 
.const [318] = Utf8 (Ljava/lang/String;)Ljava/lang/Class; 
.const [319] = Utf8 de/audi/tghu/jdsi/JDSIManager 
.const [320] = Utf8 class$org$dsi$ifc$base$DSIListener 
.const [321] = Utf8 Ljava/lang/Class; 
.const [322] = Utf8 de/audi/tghu/jdsi/JDSIManager 
.const [323] = Utf8 class$ 
.const [324] = Utf8 (Ljava/lang/String;)Ljava/lang/Class; 
.const [325] = Utf8 de/audi/tghu/jdsi/JDSIManager 
.const [326] = Utf8 fw 
.const [327] = Utf8 Lde/audi/atip/base/IFrameworkAccess; 
.const [328] = Utf8 java/lang/NoClassDefFoundError 
.const [329] = Utf8 initCause 
.const [330] = Utf8 (Ljava/lang/Throwable;)Ljava/lang/Throwable; 
.const [331] = Utf8 de/audi/tghu/jdsi/JDSIManager 
.const [332] = Utf8 serviceAdmin 
.const [333] = Utf8 Lorg/dsi/ifc/base/ServiceAdmin; 
.const [334] = Utf8 de/audi/tghu/jdsi/JDSIManager 
.const [335] = Utf8 historyStartStopService 
.const [336] = Utf8 Lde/esolutions/fw/util/commons/RingBuffer; 
.const [337] = Utf8 de/audi/tghu/jdsi/JDSIManager 
.const [338] = Utf8 serviceHistory 
.const [339] = Utf8 Lde/esolutions/fw/util/commons/RingBuffer; 
.const [340] = Utf8 de/audi/tghu/jdsi/JDSIManager 
.const [341] = Utf8 lc 
.const [342] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [343] = Utf8 de/audi/tghu/jdsi/JDSIManager 
.const [344] = Utf8 dsiServiceMap 
.const [345] = Utf8 Lde/audi/tghu/jdsi/JDSIServiceMap; 
.const [346] = Utf8 de/audi/atip/log/LogChannel 
.const [347] = Utf8 log 
.const [348] = Utf8 (ILjava/lang/String;Ljava/lang/Object;)Z 
.const [349] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [350] = Utf8 append 
.const [351] = Utf8 (Ljava/lang/String;)Lde/esolutions/fw/util/commons/Buffer; 
.const [352] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [353] = Utf8 append 
.const [354] = Utf8 (I)Lde/esolutions/fw/util/commons/Buffer; 
.const [355] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [356] = Utf8 toString 
.const [357] = Utf8 ()Ljava/lang/String; 
.const [358] = Utf8 de/audi/atip/log/LogChannel 
.const [359] = Utf8 log 
.const [360] = Utf8 (ILjava/lang/String;Ljava/lang/Object;J)Z 
.const [361] = Utf8 java/lang/Class 
.const [362] = Utf8 getName 
.const [363] = Utf8 ()Ljava/lang/String; 
.const [364] = Utf8 de/audi/atip/log/LogChannel 
.const [365] = Utf8 log 
.const [366] = Utf8 (ILjava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V 
.const [367] = Utf8 de/esolutions/fw/util/commons/RingBuffer 
.const [368] = Utf8 put 
.const [369] = Utf8 (Ljava/lang/Object;)V 
.const [370] = Utf8 de/audi/tghu/jdsi/JDSIManager 
.const [371] = Utf8 getDSIInstance 
.const [372] = Utf8 (Ljava/lang/String;I)Lde/audi/tghu/jdsi/JDSIManager$DSIInstance; 
.const [373] = Utf8 de/audi/tghu/jdsi/JDSIManager$DSIInstance 
.const [374] = Utf8 decrementStartCounter 
.const [375] = Utf8 ()Z 
.const [376] = Utf8 de/audi/tghu/jdsi/JDSIManager$DSIInstance 
.const [377] = Utf8 incrementStartCounter 
.const [378] = Utf8 ()Z 
.const [379] = Utf8 de/audi/tghu/jdsi/JDSIServiceMap 
.const [380] = Utf8 getDSIInstance 
.const [381] = Utf8 (Ljava/lang/String;I)Lde/audi/tghu/jdsi/JDSIManager$DSIInstance; 
.const [382] = Utf8 de/audi/tghu/jdsi/JDSIServiceMap 
.const [383] = Utf8 mapDSIInstance 
.const [384] = Utf8 (Lde/audi/tghu/jdsi/JDSIManager$DSIInstance;)V 
.const [385] = Utf8 de/audi/tghu/jdsi/JDSIManager$DSIInstance 
.const [386] = Utf8 setPendingDSIHandler 
.const [387] = Utf8 (Lde/audi/tghu/jdsi/JDSIManager$PendingDSIStart;)V 
.const [388] = Utf8 de/audi/atip/log/LogChannel 
.const [389] = Utf8 log 
.const [390] = Utf8 (ILjava/lang/String;)Z 
.const [391] = Utf8 de/audi/tghu/jdsi/JDSIServiceMap 
.const [392] = Utf8 getPendingDSIInstances 
.const [393] = Utf8 ()Ljava/util/List; 
.const [394] = Utf8 de/audi/tghu/jdsi/JDSIManager$DSIInstance 
.const [395] = Utf8 getServiceName 
.const [396] = Utf8 ()Ljava/lang/String; 
.const [397] = Utf8 de/audi/tghu/jdsi/JDSIManager$DSIInstance 
.const [398] = Utf8 getInstanceID 
.const [399] = Utf8 ()I 
.const [400] = Utf8 java/io/PrintStream 
.const [401] = Utf8 println 
.const [402] = Utf8 (Ljava/lang/String;)V 
.const [403] = Utf8 java/io/PrintStream 
.const [404] = Utf8 println 
.const [405] = Utf8 (Ljava/lang/Object;)V 
.const [406] = Utf8 java/io/PrintStream 
.const [407] = Utf8 println 
.const [408] = Utf8 ()V 
.const [409] = Utf8 de/esolutions/fw/util/commons/RingBuffer 
.const [410] = Utf8 size 
.const [411] = Utf8 ()I 
.const [412] = Utf8 de/esolutions/fw/util/commons/RingBuffer 
.const [413] = Utf8 get 
.const [414] = Utf8 (I)Ljava/lang/Object; 
.const [415] = Utf8 de/audi/tghu/jdsi/JDSIManager$DSIInstance 
.const [416] = Utf8 setService 
.const [417] = Utf8 (Ljava/lang/Object;)V 
.const [418] = Utf8 java/lang/NoClassDefFoundError 
.const [419] = Utf8 <init> 
.const [420] = Utf8 ()V 
.const [421] = Utf8 java/lang/Object 
.const [422] = Utf8 <init> 
.const [423] = Utf8 ()V 
.const [424] = Utf8 de/esolutions/fw/util/commons/RingBuffer 
.const [425] = Utf8 <init> 
.const [426] = Utf8 (I)V 
.const [427] = Utf8 de/audi/tghu/jdsi/JDSIServiceMap 
.const [428] = Utf8 <init> 
.const [429] = Utf8 (I)V 
.const [430] = Utf8 de/audi/tghu/jdsi/JDSIManager 
.const [431] = Utf8 startQueuedDSIs 
.const [432] = Utf8 ()V 
.const [433] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [434] = Utf8 <init> 
.const [435] = Utf8 ()V 
.const [436] = Utf8 de/audi/tghu/jdsi/JDSIManager 
.const [437] = Utf8 class$org$dsi$ifc$base$DSIListener 
.const [438] = Utf8 Ljava/lang/Class; 
.const [439] = Utf8 de/audi/tghu/jdsi/JDSIManager$DSIHistoryStartService 
.const [440] = Utf8 <init> 
.const [441] = Utf8 (Lde/audi/tghu/jdsi/JDSIManager;Ljava/lang/String;I)V 
.const [442] = Utf8 de/audi/tghu/jdsi/JDSIManager$DSIHistoryStopService 
.const [443] = Utf8 <init> 
.const [444] = Utf8 (Lde/audi/tghu/jdsi/JDSIManager;Ljava/lang/String;I)V 
.const [445] = Utf8 de/audi/tghu/jdsi/JDSIManager 
.const [446] = Utf8 stopServiceInternal 
.const [447] = Utf8 (Lorg/dsi/ifc/base/ServiceAdmin;Ljava/lang/String;I)V 
.const [448] = Utf8 de/audi/tghu/jdsi/JDSIManager 
.const [449] = Utf8 startServiceInternal 
.const [450] = Utf8 (Lorg/dsi/ifc/base/ServiceAdmin;Ljava/lang/String;I)V 
.const [451] = Utf8 de/audi/tghu/jdsi/JDSIManager 
.const [452] = Utf8 enqueueDSIStart 
.const [453] = Utf8 (Ljava/lang/String;I)V 
.const [454] = Utf8 de/audi/tghu/jdsi/JDSIManager$DSIInstance 
.const [455] = Utf8 <init> 
.const [456] = Utf8 (Ljava/lang/Object;Ljava/lang/String;I)V 
.const [457] = Utf8 de/audi/tghu/jdsi/JDSIManager$PendingDSIStart 
.const [458] = Utf8 <init> 
.const [459] = Utf8 (Lde/audi/tghu/jdsi/JDSIManager;II)V 
.const [460] = Utf8 de/audi/tghu/jdsi/JDSIManager$DSIHistoryServiceRegistered 
.const [461] = Utf8 <init> 
.const [462] = Utf8 (Lde/audi/tghu/jdsi/JDSIManager;Ljava/lang/String;I)V 
.const [463] = Utf8 de/audi/tghu/jdsi/JDSIManager$DSIHistoryServiceRemoved 
.const [464] = Utf8 <init> 
.const [465] = Utf8 (Lde/audi/tghu/jdsi/JDSIManager;Ljava/lang/String;I)V 
.const [466] = Utf8 de/audi/tghu/jdsi/JDSIManager 
.const [467] = Utf8 fw 
.const [468] = Utf8 Lde/audi/atip/base/IFrameworkAccess; 
.const [469] = Utf8 de/audi/tghu/jdsi/JDSIManager 
.const [470] = Utf8 serviceAdmin 
.const [471] = Utf8 Lorg/dsi/ifc/base/ServiceAdmin; 
.const [472] = Utf8 de/audi/tghu/jdsi/JDSIManager 
.const [473] = Utf8 historyStartStopService 
.const [474] = Utf8 Lde/esolutions/fw/util/commons/RingBuffer; 
.const [475] = Utf8 de/audi/tghu/jdsi/JDSIManager 
.const [476] = Utf8 serviceHistory 
.const [477] = Utf8 Lde/esolutions/fw/util/commons/RingBuffer; 
.const [478] = Utf8 de/audi/atip/base/IFrameworkAccess 
.const [479] = Utf8 getLogChannel 
.const [480] = Utf8 (Ljava/lang/String;)Lde/audi/atip/log/LogChannel; 
.const [481] = Utf8 de/audi/tghu/jdsi/JDSIManager 
.const [482] = Utf8 lc 
.const [483] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [484] = Utf8 de/audi/tghu/jdsi/JDSIManager 
.const [485] = Utf8 dsiServiceMap 
.const [486] = Utf8 Lde/audi/tghu/jdsi/JDSIServiceMap; 
.const [487] = Utf8 de/audi/atip/base/IFrameworkAccess 
.const [488] = Utf8 getErrorMgr 
.const [489] = Utf8 ()Lde/audi/atip/error/IErrorManager; 
.const [490] = Utf8 de/audi/atip/error/IErrorManager 
.const [491] = Utf8 registerDumpInfoProvider 
.const [492] = Utf8 (Lde/esolutions/fw/util/commons/error/DumpInfoProvider;)V 
.const [493] = Utf8 de/audi/atip/base/IFrameworkAccess 
.const [494] = Utf8 getBundleCxt 
.const [495] = Utf8 ()Lorg/osgi/framework/BundleContext; 
.const [496] = Utf8 org/osgi/framework/BundleContext 
.const [497] = Utf8 getServiceReferences 
.const [498] = Utf8 (Ljava/lang/String;Ljava/lang/String;)[Lorg/osgi/framework/ServiceReference; 
.const [499] = Utf8 org/dsi/ifc/base/ServiceAdmin 
.const [500] = Utf8 startService 
.const [501] = Utf8 (Ljava/lang/String;I)Z 
.const [502] = Utf8 org/dsi/ifc/base/ServiceAdmin 
.const [503] = Utf8 stopService 
.const [504] = Utf8 (Ljava/lang/String;I)Z 
.const [505] = Utf8 java/util/List 
.const [506] = Utf8 isEmpty 
.const [507] = Utf8 ()Z 
.const [508] = Utf8 java/util/List 
.const [509] = Utf8 get 
.const [510] = Utf8 (I)Ljava/lang/Object; 
.const [511] = Utf8 java/util/List 
.const [512] = Utf8 size 
.const [513] = Utf8 ()I 
.const [514] = Utf8 de/audi/tghu/jdsi/JDSIManager 
.const [515] = Class [514] 
.const [516] = Utf8 java/lang/Object 
.const [517] = Class [516] 
.const [518] = Utf8 de/esolutions/fw/util/commons/error/DumpInfoProvider 
.const [519] = Class [518] 
.const [520] = Utf8 DOMAIN_FAILED 
.const [521] = Utf8 I 
.const [522] = Utf8 DOMAIN_NOT_STARTED 
.const [523] = Utf8 I 
.const [524] = Utf8 DOMAIN_STARTED 
.const [525] = Utf8 I 
.const [526] = Utf8 DEBUG 
.const [527] = Utf8 Z 
.const [528] = Utf8 fw 
.const [529] = Utf8 Lde/audi/atip/base/IFrameworkAccess; 
.const [530] = Utf8 lc 
.const [531] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [532] = Utf8 serviceAdmin 
.const [533] = Utf8 Lorg/dsi/ifc/base/ServiceAdmin; 
.const [534] = Utf8 historyStartStopService 
.const [535] = Utf8 Lde/esolutions/fw/util/commons/RingBuffer; 
.const [536] = Utf8 serviceHistory 
.const [537] = Utf8 Lde/esolutions/fw/util/commons/RingBuffer; 
.const [538] = Utf8 dsiServiceMap 
.const [539] = Utf8 Lde/audi/tghu/jdsi/JDSIServiceMap; 
.const [540] = Utf8 class$org$dsi$ifc$base$DSIListener 
.const [541] = Utf8 Ljava/lang/Class; 
.const [542] = Utf8 Code 
.const [543] = Utf8 <init> 
.const [544] = Utf8 (Lde/audi/atip/base/IFrameworkAccess;)V 
.const [545] = Utf8 setServiceAdmin 
.const [546] = Utf8 (Lorg/dsi/ifc/base/ServiceAdmin;)V 
.const [547] = Utf8 getJDSIServiceMap 
.const [548] = Utf8 ()Lde/audi/tghu/jdsi/JDSIServiceMap; 
.const [549] = Utf8 isListenerRegistered 
.const [550] = Utf8 (Ljava/lang/String;I)Z 
.const [551] = Utf8 startServiceInternal 
.const [552] = Utf8 (Lorg/dsi/ifc/base/ServiceAdmin;Ljava/lang/String;I)V 
.const [553] = Utf8 stopServiceInternal 
.const [554] = Utf8 (Lorg/dsi/ifc/base/ServiceAdmin;Ljava/lang/String;I)V 
.const [555] = Utf8 stopDSIService 
.const [556] = Utf8 (Ljava/lang/String;I)V 
.const [557] = Utf8 startDSIService 
.const [558] = Utf8 (Ljava/lang/String;I)Z 
.const [559] = Utf8 getDSIInstance 
.const [560] = Utf8 (Ljava/lang/String;I)Lde/audi/tghu/jdsi/JDSIManager$DSIInstance; 
.const [561] = Utf8 removePendingDSIStart 
.const [562] = Utf8 (Ljava/lang/String;I)V 
.const [563] = Utf8 enqueueDSIStart 
.const [564] = Utf8 (Ljava/lang/String;I)V 
.const [565] = Utf8 startQueuedDSIs 
.const [566] = Utf8 ()V 
.const [567] = Utf8 dump 
.const [568] = Utf8 (Ljava/io/PrintStream;Ljava/lang/String;)V 
.const [569] = Utf8 getName 
.const [570] = Utf8 ()Ljava/lang/String; 
.const [571] = Utf8 addDSIService 
.const [572] = Utf8 (Lorg/dsi/ifc/base/DSIBase;Ljava/lang/String;I)V 
.const [573] = Utf8 removedDSIService 
.const [574] = Utf8 (Lorg/dsi/ifc/base/DSIBase;Ljava/lang/String;I)V 
.const [575] = Utf8 class$ 
.const [576] = Utf8 (Ljava/lang/String;)Ljava/lang/Class; 
.const [577] = Utf8 access$000 
.const [578] = Utf8 (Lde/audi/tghu/jdsi/JDSIManager;)Lde/audi/atip/base/IFrameworkAccess; 
.end class 
