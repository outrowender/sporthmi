.version 50 0 
.class public super [347] 
.super [349] 
.implements [351] 
.field private static final [352] [353] 
.field private final [354] [355] 
.field private [356] [357] 
.field private volatile [358] [359] 
.field private volatile [360] [361] 
.field private volatile [362] [363] 
.field private final [364] [365] 
.field private final [366] [367] 
.field private volatile [368] [369] 
.field private final [370] [371] 
.field static synthetic [372] [373] 
.field static synthetic [374] [375] 

.method protected [377] : [378] 
    .attribute [376] .code stack 6 locals 0 
L0:     aload_0 
L1:     invokespecial [55] 
L4:     aload_0 
L5:     aconst_null 
L6:     putfield [63] 
L9:     aload_0 
L10:    iconst_0 
L11:    putfield [64] 
L14:    aload_0 
L15:    iconst_0 
L16:    putfield [65] 
L19:    aload_0 
L20:    new [66] 
L23:    dup 
L24:    invokespecial [55] 
L27:    putfield [67] 
L30:    aload_0 
L31:    aload_2 
L32:    putfield [61] 
L35:    aload_0 
L36:    aload_1 
L37:    putfield [60] 
L40:    aload_0 
L41:    aload_1 
L42:    getstatic [6] 
L45:    ifnonnull L60 
L48:    ldc [7] 
L50:    invokestatic [8] 
L53:    dup 
L54:    putstatic [56] 
L57:    goto L63 
L60:    getstatic [6] 
L63:    new [68] 
L66:    dup 
L67:    aload_0 
L68:    invokespecial [57] 
L71:    invokeinterface [69] 0 
L76:    putfield [70] 
L79:    return 
L80:    
    .end code 
.end method 

.method protected [379] : [380] 
    .attribute [376] .code stack 7 locals 0 
L0:     aload_0 
L1:     getfield [38] 
L4:     invokevirtual [45] 
L7:     ldc [10] 
L9:     ldc [11] 
L11:    ldc [12] 
L13:    invokevirtual [46] 
L16:    pop 
L17:    aload_0 
L18:    iconst_0 
L19:    putfield [64] 
L22:    aload_0 
L23:    iconst_0 
L24:    putfield [65] 
L27:    aload_0 
L28:    getfield [44] 
L31:    invokeinterface [71] 0 
L36:    aload_0 
L37:    aload_0 
L38:    getfield [37] 
L41:    getstatic [13] 
L44:    ifnonnull L59 
L47:    ldc [14] 
L49:    invokestatic [8] 
L52:    dup 
L53:    putstatic [58] 
L56:    goto L62 
L59:    getstatic [13] 
L62:    aload_0 
L63:    new [72] 
L66:    dup 
L67:    iconst_0 
L68:    invokespecial [59] 
L71:    invokeinterface [73] 0 
L76:    putfield [74] 
L79:    return 
L80:    
    .end code 
.end method 

.method protected [381] : [382] 
    .attribute [376] .code stack 4 locals 2 
L0:     aload_0 
L1:     getfield [38] 
L4:     invokevirtual [45] 
L7:     ldc [10] 
L9:     ldc [16] 
L11:    ldc [12] 
L13:    invokevirtual [46] 
L16:    pop 
L17:    aload_0 
L18:    getfield [44] 
L21:    invokeinterface [75] 0 
L26:    aload_0 
L27:    getfield [47] 
L30:    invokeinterface [76] 0 
L35:    aload_0 
L36:    getfield [48] 
L39:    ifnull L51 
L42:    aload_0 
L43:    getfield [48] 
L46:    invokeinterface [78] 0 
L51:    aload_0 
L52:    getfield [43] 
L55:    dup 
L56:    astore_1 
L57:    monitorenter 
        .catch [0] from L58 to L70 using L73 
L58:    aload_0 
L59:    aconst_null 
L60:    putfield [63] 
L63:    aload_0 
L64:    iconst_0 
L65:    putfield [64] 
L68:    aload_1 
L69:    monitorexit 
L70:    goto L78 
        .catch [0] from L73 to L76 using L73 
L73:    astore_2 
L74:    aload_1 
L75:    monitorexit 
L76:    aload_2 
L77:    athrow 
L78:    return 
L79:    nop 
L80:    
    .end code 
.end method 

.method private [383] : [384] 
    .attribute [376] .code stack 5 locals 3 
L0:     aload_0 
L1:     getfield [38] 
L4:     invokevirtual [45] 
L7:     ldc [10] 
L9:     ldc [17] 
L11:    ldc [12] 
L13:    invokevirtual [46] 
L16:    pop 
L17:    aload_0 
L18:    getfield [43] 
L21:    dup 
L22:    astore_2 
L23:    monitorenter 
L24:    aload_0 
L25:    aload_1 
L26:    putfield [63] 
L29:    aload_0 
L30:    getfield [40] 
L33:    ifnull L81 
L36:    aload_0 
L37:    getfield [41] 
L40:    ifeq L81 
        .catch [18] from L43 to L59 using L62 
        .catch [0] from L24 to L83 using L86 
L43:    aload_0 
L44:    getfield [40] 
L47:    aload_0 
L48:    iconst_3 
L49:    invokeinterface [79] 0 
L54:    aload_0 
L55:    iconst_1 
L56:    putfield [65] 
L59:    goto L81 
L62:    astore_3 
L63:    aload_0 
L64:    getfield [38] 
L67:    invokevirtual [45] 
L70:    ldc [10] 
L72:    ldc [19] 
L74:    ldc [12] 
L76:    aload_3 
L77:    invokevirtual [49] 
L80:    pop 
L81:    aload_2 
L82:    monitorexit 
L83:    goto L93 
        .catch [0] from L86 to L90 using L86 
L86:    astore 4 
L88:    aload_2 
L89:    monitorexit 
L90:    aload 4 
L92:    athrow 
L93:    return 
L94:    nop 
L95:    nop 
L96:    
    .end code 
.end method 

.method public [385] : [386] 
    .attribute [376] .code stack 5 locals 3 
L0:     aload_0 
L1:     getfield [38] 
L4:     invokevirtual [45] 
L7:     ldc [10] 
L9:     ldc [20] 
L11:    iload_1 
L12:    ldc [12] 
L14:    invokevirtual [50] 
L17:    pop 
L18:    aload_0 
L19:    getfield [43] 
L22:    dup 
L23:    astore_2 
L24:    monitorenter 
L25:    aload_0 
L26:    getfield [40] 
L29:    ifnull L203 
L32:    iload_1 
L33:    ifeq L140 
L36:    aload_0 
L37:    getfield [42] 
L40:    ifne L85 
        .catch [18] from L43 to L59 using L62 
L43:    aload_0 
L44:    getfield [40] 
L47:    aload_0 
L48:    iconst_3 
L49:    invokeinterface [79] 0 
L54:    aload_0 
L55:    iconst_1 
L56:    putfield [65] 
L59:    goto L220 
L62:    astore_3 
L63:    aload_0 
L64:    getfield [38] 
L67:    invokevirtual [45] 
L70:    ldc [10] 
L72:    ldc [21] 
L74:    ldc [12] 
L76:    aload_3 
L77:    invokevirtual [49] 
L80:    pop 
L81:    iconst_0 
L82:    aload_2 
L83:    monitorexit 
L84:    areturn 
L85:    aload_0 
L86:    getfield [40] 
L89:    aload_0 
L90:    invokeinterface [80] 0 
L95:    ifne L220 
L98:    aload_0 
L99:    iconst_0 
L100:   putfield [64] 
L103:   aload_0 
L104:   getfield [48] 
L107:   ifnull L119 
L110:   aload_0 
L111:   getfield [48] 
L114:   invokeinterface [81] 0 
L119:   aload_0 
L120:   getfield [38] 
L123:   invokevirtual [45] 
L126:   ldc [22] 
L128:   ldc [23] 
L130:   ldc [12] 
L132:   invokevirtual [46] 
L135:   pop 
L136:   iconst_0 
L137:   aload_2 
L138:   monitorexit 
L139:   areturn 
L140:   aload_0 
L141:   getfield [42] 
L144:   ifne L189 
        .catch [18] from L147 to L163 using L166 
        .catch [0] from L25 to L84 using L230 
        .catch [0] from L85 to L139 using L230 
        .catch [0] from L140 to L188 using L230 
L147:   aload_0 
L148:   getfield [40] 
L151:   aload_0 
L152:   iconst_4 
L153:   invokeinterface [79] 0 
L158:   aload_0 
L159:   iconst_1 
L160:   putfield [65] 
L163:   goto L220 
L166:   astore_3 
L167:   aload_0 
L168:   getfield [38] 
L171:   invokevirtual [45] 
L174:   ldc [10] 
L176:   ldc [24] 
L178:   ldc [12] 
L180:   aload_3 
L181:   invokevirtual [49] 
L184:   pop 
L185:   iconst_0 
L186:   aload_2 
L187:   monitorexit 
L188:   areturn 
        .catch [0] from L189 to L227 using L230 
L189:   aload_0 
L190:   getfield [40] 
L193:   aload_0 
L194:   invokeinterface [82] 0 
L199:   pop 
L200:   goto L220 
L203:   aload_0 
L204:   getfield [38] 
L207:   invokevirtual [45] 
L210:   ldc [10] 
L212:   ldc [25] 
L214:   ldc [12] 
L216:   invokevirtual [46] 
L219:   pop 
L220:   aload_0 
L221:   iload_1 
L222:   putfield [64] 
L225:   aload_2 
L226:   monitorexit 
L227:   goto L237 
        .catch [0] from L230 to L234 using L230 
L230:   astore 4 
L232:   aload_2 
L233:   monitorexit 
L234:   aload 4 
L236:   athrow 
L237:   iconst_1 
L238:   areturn 
L239:   nop 
L240:   
    .end code 
.end method 

.method public [387] : [388] 
    .attribute [376] .code stack 4 locals 0 
L0:     aload_0 
L1:     getfield [38] 
L4:     invokevirtual [51] 
L7:     ldc [10] 
L9:     ldc [26] 
L11:    ldc [12] 
L13:    invokevirtual [46] 
L16:    pop 
L17:    aload_0 
L18:    aload_1 
L19:    putfield [77] 
L22:    return 
L23:    nop 
L24:    
    .end code 
.end method 

.method public [389] : [390] 
    .attribute [376] .code stack 1 locals 0 
L0:     iconst_2 
L1:     areturn 
L2:     nop 
L3:     nop 
L4:     
    .end code 
.end method 

.method public [391] : [392] 
    .attribute [376] .code stack 8 locals 0 
L0:     aload_0 
L1:     getfield [38] 
L4:     invokevirtual [45] 
L7:     ldc [10] 
L9:     ldc [27] 
L11:    ldc [12] 
L13:    iload_1 
L14:    i2l 
L15:    iload_2 
L16:    i2l 
L17:    invokevirtual [52] 
L20:    pop 
L21:    iload_1 
L22:    iconst_3 
L23:    if_icmpne L38 
L26:    aload_0 
L27:    getfield [48] 
L30:    invokeinterface [81] 0 
L35:    goto L52 
L38:    iload_1 
L39:    iconst_4 
L40:    if_icmpne L52 
L43:    aload_0 
L44:    getfield [48] 
L47:    invokeinterface [78] 0 
L52:    return 
L53:    nop 
L54:    nop 
L55:    nop 
L56:    
    .end code 
.end method 

.method static synthetic [393] : [394] 
    .attribute [376] .code stack 2 locals 1 
        .catch [3] from L0 to L4 using L5 
L0:     aload_0 
L1:     invokestatic [2] 
L4:     areturn 
L5:     astore_1 
L6:     new [62] 
L9:     dup 
L10:    invokespecial [54] 
L13:    aload_1 
L14:    invokevirtual [39] 
L17:    athrow 
L18:    nop 
L19:    nop 
L20:    
    .end code 
.end method 

.method static synthetic [395] : [396] 
    .attribute [376] .code stack 1 locals 0 
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
    .attribute [376] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [37] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method static synthetic [399] : [400] 
    .attribute [376] .code stack 2 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     invokespecial [53] 
L5:     return 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Method [83] [84] 
.const [3] = Class [85] 
.const [4] = Class [86] 
.const [5] = Class [87] 
.const [6] = Field [88] [89] 
.const [7] = String [90] 
.const [8] = Method [91] [92] 
.const [9] = Class [93] 
.const [10] = Int 1078071040 
.const [11] = String [94] 
.const [12] = String [95] 
.const [13] = Field [96] [97] 
.const [14] = String [98] 
.const [15] = Class [99] 
.const [16] = String [100] 
.const [17] = String [101] 
.const [18] = Class [102] 
.const [19] = String [103] 
.const [20] = String [104] 
.const [21] = String [105] 
.const [22] = Int -1601830656 
.const [23] = String [106] 
.const [24] = String [107] 
.const [25] = String [108] 
.const [26] = String [109] 
.const [27] = String [110] 
.const [28] = Class [111] 
.const [29] = Class [112] 
.const [30] = Class [113] 
.const [31] = Class [114] 
.const [32] = Class [115] 
.const [33] = Class [116] 
.const [34] = Class [117] 
.const [35] = Class [118] 
.const [36] = Class [119] 
.const [37] = Field [120] [121] 
.const [38] = Field [122] [123] 
.const [39] = Method [124] [125] 
.const [40] = Field [126] [127] 
.const [41] = Field [128] [129] 
.const [42] = Field [130] [131] 
.const [43] = Field [132] [133] 
.const [44] = Field [134] [135] 
.const [45] = Method [136] [137] 
.const [46] = Method [138] [139] 
.const [47] = Field [140] [141] 
.const [48] = Field [142] [143] 
.const [49] = Method [144] [145] 
.const [50] = Method [146] [147] 
.const [51] = Method [148] [149] 
.const [52] = Method [150] [151] 
.const [53] = Method [152] [153] 
.const [54] = Method [154] [155] 
.const [55] = Method [156] [157] 
.const [56] = Field [158] [159] 
.const [57] = Method [160] [161] 
.const [58] = Field [162] [163] 
.const [59] = Method [164] [165] 
.const [60] = Field [166] [167] 
.const [61] = Field [168] [169] 
.const [62] = Class [170] 
.const [63] = Field [171] [172] 
.const [64] = Field [173] [174] 
.const [65] = Field [175] [176] 
.const [66] = Class [177] 
.const [67] = Field [178] [179] 
.const [68] = Class [180] 
.const [69] = InterfaceMethod [181] [182] 
.const [70] = Field [183] [184] 
.const [71] = InterfaceMethod [185] [186] 
.const [72] = Class [187] 
.const [73] = InterfaceMethod [188] [189] 
.const [74] = Field [190] [191] 
.const [75] = InterfaceMethod [192] [193] 
.const [76] = InterfaceMethod [194] [195] 
.const [77] = Field [196] [197] 
.const [78] = InterfaceMethod [198] [199] 
.const [79] = InterfaceMethod [200] [201] 
.const [80] = InterfaceMethod [202] [203] 
.const [81] = InterfaceMethod [204] [205] 
.const [82] = InterfaceMethod [206] [207] 
.const [83] = Class [208] 
.const [84] = NameAndType [209] [210] 
.const [85] = Utf8 java/lang/ClassNotFoundException 
.const [86] = Utf8 java/lang/NoClassDefFoundError 
.const [87] = Utf8 java/lang/Object 
.const [88] = Class [211] 
.const [89] = NameAndType [212] [213] 
.const [90] = Utf8 'de.audi.atip.bulkcopy.IBulkCopyManager' 
.const [91] = Class [214] 
.const [92] = NameAndType [215] [216] 
.const [93] = Utf8 de/audi/app/media/transfer/TransferLockHandler$1 
.const [94] = Utf8 '[%1.init]' 
.const [95] = Utf8 TransferLockHandler 
.const [96] = Class [217] 
.const [97] = NameAndType [218] [219] 
.const [98] = Utf8 'de.audi.atip.bulkcopy.IBulkCopyClient' 
.const [99] = Utf8 java/util/Hashtable 
.const [100] = Utf8 '[%1.deinit]' 
.const [101] = Utf8 '[%1.setBulkCopyManager]' 
.const [102] = Utf8 de/audi/atip/bulkcopy/BulkCopyException 
.const [103] = Utf8 '[%1.setBulkCopyManager] exception occured during setting clientState to BUSY' 
.const [104] = Utf8 "[%2.importActive] '%1'" 
.const [105] = Utf8 '[%1.importActive] exception occured during setting clientState to BUSY' 
.const [106] = Utf8 '[%1.importActive] other resource has locks. aborting import.' 
.const [107] = Utf8 '[%1.importActive] exception occured during setting clientState to IDLE' 
.const [108] = Utf8 '[%1.importActive] no lock manager available' 
.const [109] = Utf8 '[%1.setTransferLockListener]' 
.const [110] = Utf8 "[%1.onChangeStateBulkCopy] state='%2', initiatedByType='%3'" 
.const [111] = Utf8 de/audi/app/media/transfer/TransferLockHandler 
.const [112] = Utf8 java/lang/Class 
.const [113] = Utf8 de/audi/app/media/osgi/IServiceManager 
.const [114] = Utf8 de/audi/app/media/transfer/TransferLogger 
.const [115] = Utf8 de/audi/atip/log/LogChannel 
.const [116] = Utf8 de/audi/app/media/osgi/IServiceTracker 
.const [117] = Utf8 org/osgi/framework/ServiceRegistration 
.const [118] = Utf8 de/audi/app/media/transfer/ITransferLockListener 
.const [119] = Utf8 de/audi/atip/bulkcopy/IBulkCopyManager 
.const [120] = Class [220] 
.const [121] = NameAndType [221] [222] 
.const [122] = Class [223] 
.const [123] = NameAndType [224] [225] 
.const [124] = Class [226] 
.const [125] = NameAndType [227] [228] 
.const [126] = Class [229] 
.const [127] = NameAndType [230] [231] 
.const [128] = Class [232] 
.const [129] = NameAndType [233] [234] 
.const [130] = Class [235] 
.const [131] = NameAndType [236] [237] 
.const [132] = Class [238] 
.const [133] = NameAndType [239] [240] 
.const [134] = Class [241] 
.const [135] = NameAndType [242] [243] 
.const [136] = Class [244] 
.const [137] = NameAndType [245] [246] 
.const [138] = Class [247] 
.const [139] = NameAndType [248] [249] 
.const [140] = Class [250] 
.const [141] = NameAndType [251] [252] 
.const [142] = Class [253] 
.const [143] = NameAndType [254] [255] 
.const [144] = Class [256] 
.const [145] = NameAndType [257] [258] 
.const [146] = Class [259] 
.const [147] = NameAndType [260] [261] 
.const [148] = Class [262] 
.const [149] = NameAndType [263] [264] 
.const [150] = Class [265] 
.const [151] = NameAndType [266] [267] 
.const [152] = Class [268] 
.const [153] = NameAndType [269] [270] 
.const [154] = Class [271] 
.const [155] = NameAndType [272] [273] 
.const [156] = Class [274] 
.const [157] = NameAndType [275] [276] 
.const [158] = Class [277] 
.const [159] = NameAndType [278] [279] 
.const [160] = Class [280] 
.const [161] = NameAndType [281] [282] 
.const [162] = Class [283] 
.const [163] = NameAndType [284] [285] 
.const [164] = Class [286] 
.const [165] = NameAndType [287] [288] 
.const [166] = Class [289] 
.const [167] = NameAndType [290] [291] 
.const [168] = Class [292] 
.const [169] = NameAndType [293] [294] 
.const [170] = Utf8 java/lang/NoClassDefFoundError 
.const [171] = Class [295] 
.const [172] = NameAndType [296] [297] 
.const [173] = Class [298] 
.const [174] = NameAndType [299] [300] 
.const [175] = Class [301] 
.const [176] = NameAndType [302] [303] 
.const [177] = Utf8 java/lang/Object 
.const [178] = Class [304] 
.const [179] = NameAndType [305] [306] 
.const [180] = Utf8 de/audi/app/media/transfer/TransferLockHandler$1 
.const [181] = Class [307] 
.const [182] = NameAndType [308] [309] 
.const [183] = Class [310] 
.const [184] = NameAndType [311] [312] 
.const [185] = Class [313] 
.const [186] = NameAndType [314] [315] 
.const [187] = Utf8 java/util/Hashtable 
.const [188] = Class [316] 
.const [189] = NameAndType [317] [318] 
.const [190] = Class [319] 
.const [191] = NameAndType [320] [321] 
.const [192] = Class [322] 
.const [193] = NameAndType [323] [324] 
.const [194] = Class [325] 
.const [195] = NameAndType [326] [327] 
.const [196] = Class [328] 
.const [197] = NameAndType [329] [330] 
.const [198] = Class [331] 
.const [199] = NameAndType [332] [333] 
.const [200] = Class [334] 
.const [201] = NameAndType [335] [336] 
.const [202] = Class [337] 
.const [203] = NameAndType [338] [339] 
.const [204] = Class [340] 
.const [205] = NameAndType [341] [342] 
.const [206] = Class [343] 
.const [207] = NameAndType [344] [345] 
.const [208] = Utf8 java/lang/Class 
.const [209] = Utf8 forName 
.const [210] = Utf8 (Ljava/lang/String;)Ljava/lang/Class; 
.const [211] = Utf8 de/audi/app/media/transfer/TransferLockHandler 
.const [212] = Utf8 class$de$audi$atip$bulkcopy$IBulkCopyManager 
.const [213] = Utf8 Ljava/lang/Class; 
.const [214] = Utf8 de/audi/app/media/transfer/TransferLockHandler 
.const [215] = Utf8 class$ 
.const [216] = Utf8 (Ljava/lang/String;)Ljava/lang/Class; 
.const [217] = Utf8 de/audi/app/media/transfer/TransferLockHandler 
.const [218] = Utf8 class$de$audi$atip$bulkcopy$IBulkCopyClient 
.const [219] = Utf8 Ljava/lang/Class; 
.const [220] = Utf8 de/audi/app/media/transfer/TransferLockHandler 
.const [221] = Utf8 serviceManager 
.const [222] = Utf8 Lde/audi/app/media/osgi/IServiceManager; 
.const [223] = Utf8 de/audi/app/media/transfer/TransferLockHandler 
.const [224] = Utf8 logger 
.const [225] = Utf8 Lde/audi/app/media/transfer/TransferLogger; 
.const [226] = Utf8 java/lang/NoClassDefFoundError 
.const [227] = Utf8 initCause 
.const [228] = Utf8 (Ljava/lang/Throwable;)Ljava/lang/Throwable; 
.const [229] = Utf8 de/audi/app/media/transfer/TransferLockHandler 
.const [230] = Utf8 bulkCopyManager 
.const [231] = Utf8 Lde/audi/atip/bulkcopy/IBulkCopyManager; 
.const [232] = Utf8 de/audi/app/media/transfer/TransferLockHandler 
.const [233] = Utf8 importActive 
.const [234] = Utf8 Z 
.const [235] = Utf8 de/audi/app/media/transfer/TransferLockHandler 
.const [236] = Utf8 clientStateSend 
.const [237] = Utf8 Z 
.const [238] = Utf8 de/audi/app/media/transfer/TransferLockHandler 
.const [239] = Utf8 bulkCopySync 
.const [240] = Utf8 Ljava/lang/Object; 
.const [241] = Utf8 de/audi/app/media/transfer/TransferLockHandler 
.const [242] = Utf8 bulkCopyManagerTracker 
.const [243] = Utf8 Lde/audi/app/media/osgi/IServiceTracker; 
.const [244] = Utf8 de/audi/app/media/transfer/TransferLogger 
.const [245] = Utf8 hmi 
.const [246] = Utf8 ()Lde/audi/atip/log/LogChannel; 
.const [247] = Utf8 de/audi/atip/log/LogChannel 
.const [248] = Utf8 log 
.const [249] = Utf8 (ILjava/lang/String;Ljava/lang/Object;)Z 
.const [250] = Utf8 de/audi/app/media/transfer/TransferLockHandler 
.const [251] = Utf8 bulkCopyClientService 
.const [252] = Utf8 Lorg/osgi/framework/ServiceRegistration; 
.const [253] = Utf8 de/audi/app/media/transfer/TransferLockHandler 
.const [254] = Utf8 transferLockListener 
.const [255] = Utf8 Lde/audi/app/media/transfer/ITransferLockListener; 
.const [256] = Utf8 de/audi/atip/log/LogChannel 
.const [257] = Utf8 log 
.const [258] = Utf8 (ILjava/lang/String;Ljava/lang/Object;Ljava/lang/Throwable;)Z 
.const [259] = Utf8 de/audi/atip/log/LogChannel 
.const [260] = Utf8 log 
.const [261] = Utf8 (ILjava/lang/String;ZLjava/lang/Object;)Z 
.const [262] = Utf8 de/audi/app/media/transfer/TransferLogger 
.const [263] = Utf8 main 
.const [264] = Utf8 ()Lde/audi/atip/log/LogChannel; 
.const [265] = Utf8 de/audi/atip/log/LogChannel 
.const [266] = Utf8 log 
.const [267] = Utf8 (ILjava/lang/String;Ljava/lang/Object;JJ)Z 
.const [268] = Utf8 de/audi/app/media/transfer/TransferLockHandler 
.const [269] = Utf8 setBulkCopyManager 
.const [270] = Utf8 (Lde/audi/atip/bulkcopy/IBulkCopyManager;)V 
.const [271] = Utf8 java/lang/NoClassDefFoundError 
.const [272] = Utf8 <init> 
.const [273] = Utf8 ()V 
.const [274] = Utf8 java/lang/Object 
.const [275] = Utf8 <init> 
.const [276] = Utf8 ()V 
.const [277] = Utf8 de/audi/app/media/transfer/TransferLockHandler 
.const [278] = Utf8 class$de$audi$atip$bulkcopy$IBulkCopyManager 
.const [279] = Utf8 Ljava/lang/Class; 
.const [280] = Utf8 de/audi/app/media/transfer/TransferLockHandler$1 
.const [281] = Utf8 <init> 
.const [282] = Utf8 (Lde/audi/app/media/transfer/TransferLockHandler;)V 
.const [283] = Utf8 de/audi/app/media/transfer/TransferLockHandler 
.const [284] = Utf8 class$de$audi$atip$bulkcopy$IBulkCopyClient 
.const [285] = Utf8 Ljava/lang/Class; 
.const [286] = Utf8 java/util/Hashtable 
.const [287] = Utf8 <init> 
.const [288] = Utf8 (I)V 
.const [289] = Utf8 de/audi/app/media/transfer/TransferLockHandler 
.const [290] = Utf8 serviceManager 
.const [291] = Utf8 Lde/audi/app/media/osgi/IServiceManager; 
.const [292] = Utf8 de/audi/app/media/transfer/TransferLockHandler 
.const [293] = Utf8 logger 
.const [294] = Utf8 Lde/audi/app/media/transfer/TransferLogger; 
.const [295] = Utf8 de/audi/app/media/transfer/TransferLockHandler 
.const [296] = Utf8 bulkCopyManager 
.const [297] = Utf8 Lde/audi/atip/bulkcopy/IBulkCopyManager; 
.const [298] = Utf8 de/audi/app/media/transfer/TransferLockHandler 
.const [299] = Utf8 importActive 
.const [300] = Utf8 Z 
.const [301] = Utf8 de/audi/app/media/transfer/TransferLockHandler 
.const [302] = Utf8 clientStateSend 
.const [303] = Utf8 Z 
.const [304] = Utf8 de/audi/app/media/transfer/TransferLockHandler 
.const [305] = Utf8 bulkCopySync 
.const [306] = Utf8 Ljava/lang/Object; 
.const [307] = Utf8 de/audi/app/media/osgi/IServiceManager 
.const [308] = Utf8 createServiceTracker 
.const [309] = Utf8 (Ljava/lang/Class;Lorg/osgi/util/tracker/ServiceTrackerCustomizer;)Lde/audi/app/media/osgi/IServiceTracker; 
.const [310] = Utf8 de/audi/app/media/transfer/TransferLockHandler 
.const [311] = Utf8 bulkCopyManagerTracker 
.const [312] = Utf8 Lde/audi/app/media/osgi/IServiceTracker; 
.const [313] = Utf8 de/audi/app/media/osgi/IServiceTracker 
.const [314] = Utf8 'open' 
.const [315] = Utf8 ()V 
.const [316] = Utf8 de/audi/app/media/osgi/IServiceManager 
.const [317] = Utf8 registerService 
.const [318] = Utf8 (Ljava/lang/Class;Ljava/lang/Object;Ljava/util/Dictionary;)Lorg/osgi/framework/ServiceRegistration; 
.const [319] = Utf8 de/audi/app/media/transfer/TransferLockHandler 
.const [320] = Utf8 bulkCopyClientService 
.const [321] = Utf8 Lorg/osgi/framework/ServiceRegistration; 
.const [322] = Utf8 de/audi/app/media/osgi/IServiceTracker 
.const [323] = Utf8 close 
.const [324] = Utf8 ()V 
.const [325] = Utf8 org/osgi/framework/ServiceRegistration 
.const [326] = Utf8 unregister 
.const [327] = Utf8 ()V 
.const [328] = Utf8 de/audi/app/media/transfer/TransferLockHandler 
.const [329] = Utf8 transferLockListener 
.const [330] = Utf8 Lde/audi/app/media/transfer/ITransferLockListener; 
.const [331] = Utf8 de/audi/app/media/transfer/ITransferLockListener 
.const [332] = Utf8 unblockImportFunctionality 
.const [333] = Utf8 ()V 
.const [334] = Utf8 de/audi/atip/bulkcopy/IBulkCopyManager 
.const [335] = Utf8 setClientState 
.const [336] = Utf8 (Lde/audi/atip/bulkcopy/IBulkCopyClient;I)V 
.const [337] = Utf8 de/audi/atip/bulkcopy/IBulkCopyManager 
.const [338] = Utf8 lock 
.const [339] = Utf8 (Lde/audi/atip/bulkcopy/IBulkCopyClient;)Z 
.const [340] = Utf8 de/audi/app/media/transfer/ITransferLockListener 
.const [341] = Utf8 blockImportFunctionality 
.const [342] = Utf8 ()V 
.const [343] = Utf8 de/audi/atip/bulkcopy/IBulkCopyManager 
.const [344] = Utf8 unlock 
.const [345] = Utf8 (Lde/audi/atip/bulkcopy/IBulkCopyClient;)Z 
.const [346] = Utf8 de/audi/app/media/transfer/TransferLockHandler 
.const [347] = Class [346] 
.const [348] = Utf8 java/lang/Object 
.const [349] = Class [348] 
.const [350] = Utf8 de/audi/atip/bulkcopy/IBulkCopyClient 
.const [351] = Class [350] 
.const [352] = Utf8 LOGCLASS 
.const [353] = Utf8 Ljava/lang/String; 
.const [354] = Utf8 logger 
.const [355] = Utf8 Lde/audi/app/media/transfer/TransferLogger; 
.const [356] = Utf8 transferLockListener 
.const [357] = Utf8 Lde/audi/app/media/transfer/ITransferLockListener; 
.const [358] = Utf8 bulkCopyManager 
.const [359] = Utf8 Lde/audi/atip/bulkcopy/IBulkCopyManager; 
.const [360] = Utf8 importActive 
.const [361] = Utf8 Z 
.const [362] = Utf8 clientStateSend 
.const [363] = Utf8 Z 
.const [364] = Utf8 bulkCopySync 
.const [365] = Utf8 Ljava/lang/Object; 
.const [366] = Utf8 bulkCopyManagerTracker 
.const [367] = Utf8 Lde/audi/app/media/osgi/IServiceTracker; 
.const [368] = Utf8 bulkCopyClientService 
.const [369] = Utf8 Lorg/osgi/framework/ServiceRegistration; 
.const [370] = Utf8 serviceManager 
.const [371] = Utf8 Lde/audi/app/media/osgi/IServiceManager; 
.const [372] = Utf8 class$de$audi$atip$bulkcopy$IBulkCopyManager 
.const [373] = Utf8 Ljava/lang/Class; 
.const [374] = Utf8 class$de$audi$atip$bulkcopy$IBulkCopyClient 
.const [375] = Utf8 Ljava/lang/Class; 
.const [376] = Utf8 Code 
.const [377] = Utf8 <init> 
.const [378] = Utf8 (Lde/audi/app/media/osgi/IServiceManager;Lde/audi/app/media/transfer/TransferLogger;)V 
.const [379] = Utf8 init 
.const [380] = Utf8 ()V 
.const [381] = Utf8 deinit 
.const [382] = Utf8 ()V 
.const [383] = Utf8 setBulkCopyManager 
.const [384] = Utf8 (Lde/audi/atip/bulkcopy/IBulkCopyManager;)V 
.const [385] = Utf8 importActive 
.const [386] = Utf8 (Z)Z 
.const [387] = Utf8 setTransferLockListener 
.const [388] = Utf8 (Lde/audi/app/media/transfer/ITransferLockListener;)V 
.const [389] = Utf8 getClientType 
.const [390] = Utf8 ()I 
.const [391] = Utf8 onChangeStateBulkCopy 
.const [392] = Utf8 (II)V 
.const [393] = Utf8 class$ 
.const [394] = Utf8 (Ljava/lang/String;)Ljava/lang/Class; 
.const [395] = Utf8 access$000 
.const [396] = Utf8 (Lde/audi/app/media/transfer/TransferLockHandler;)Lde/audi/app/media/transfer/TransferLogger; 
.const [397] = Utf8 access$100 
.const [398] = Utf8 (Lde/audi/app/media/transfer/TransferLockHandler;)Lde/audi/app/media/osgi/IServiceManager; 
.const [399] = Utf8 access$200 
.const [400] = Utf8 (Lde/audi/app/media/transfer/TransferLockHandler;Lde/audi/atip/bulkcopy/IBulkCopyManager;)V 
.end class 
