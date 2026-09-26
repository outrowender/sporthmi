.version 50 0 
.class public super [344] 
.super [346] 
.implements [348] 
.field private [349] [350] 
.field private [351] [352] 
.field [353] [354] 
.field [355] [356] 
.field static synthetic [357] [358] 
.field static synthetic [359] [360] 
.field static synthetic [361] [362] 
.field static synthetic [363] [364] 

.method public [366] : [367] 
    .attribute [365] .code stack 2 locals 0 
L0:     aload_0 
L1:     invokespecial [61] 
L4:     aload_0 
L5:     aconst_null 
L6:     putfield [74] 
L9:     aload_0 
L10:    aconst_null 
L11:    putfield [75] 
L14:    aload_0 
L15:    aconst_null 
L16:    putfield [76] 
L19:    return 
L20:    
    .end code 
.end method 

.method public [368] : [369] 
    .attribute [365] .code stack 9 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     invokespecial [62] 
L5:     aload_0 
L6:     aload_0 
L7:     getfield [48] 
L10:    ldc [5] 
L12:    invokeinterface [77] 0 
L17:    putfield [75] 
L20:    aload_0 
L21:    getfield [46] 
L24:    ldc [6] 
L26:    ldc [7] 
L28:    invokevirtual [49] 
L31:    pop 
L32:    aload_0 
L33:    new [78] 
L36:    dup 
L37:    aload_0 
L38:    getfield [48] 
L41:    aload_0 
L42:    getfield [46] 
L45:    iconst_2 
L46:    newarray int 
L48:    dup 
L49:    iconst_0 
L50:    iconst_1 
L51:    iastore 
L52:    dup 
L53:    iconst_1 
L54:    iconst_2 
L55:    iastore 
L56:    invokespecial [63] 
L59:    putfield [74] 
L62:    aload_0 
L63:    aload_0 
L64:    getfield [45] 
L67:    invokespecial [64] 
L70:    aload_0 
L71:    invokespecial [65] 
L74:    return 
L75:    nop 
L76:    
    .end code 
.end method 

.method public interface [370] : [371] 
    .attribute [365] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [45] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [372] : [373] 
    .attribute [365] .code stack 2 locals 0 
L0:     aconst_null 
L1:     aload_0 
L2:     getfield [50] 
L5:     if_acmpeq L15 
L8:     aload_0 
L9:     getfield [50] 
L12:    invokevirtual [51] 
L15:    aload_0 
L16:    aload_1 
L17:    invokespecial [66] 
L20:    return 
L21:    nop 
L22:    nop 
L23:    nop 
L24:    
    .end code 
.end method 

.method public [374] : [375] 
    .attribute [365] .code stack 5 locals 2 
L0:     aload_0 
L1:     getfield [46] 
L4:     ldc [6] 
L6:     ldc [9] 
L8:     invokevirtual [49] 
L11:    pop 
L12:    aload_0 
L13:    invokevirtual [52] 
L16:    aload_1 
L17:    invokeinterface [80] 0 
L22:    astore_2 
L23:    aload_2 
L24:    instanceof [10] 
L27:    ifeq L86 
L30:    aload_0 
L31:    getfield [46] 
L34:    ldc [11] 
L36:    ldc [12] 
L38:    invokevirtual [49] 
L41:    pop 
        .catch [13] from L42 to L54 using L57 
L42:    aload_0 
L43:    getfield [45] 
L46:    aload_2 
L47:    checkcast [10] 
L50:    invokevirtual [53] 
L53:    pop 
L54:    goto L161 
L57:    astore_3 
L58:    aload_0 
L59:    invokevirtual [52] 
L62:    aload_1 
L63:    invokeinterface [81] 0 
L68:    pop 
L69:    aload_0 
L70:    getfield [46] 
L73:    sipush 10000 
L76:    ldc [14] 
L78:    aload_2 
L79:    aload_3 
L80:    invokevirtual [54] 
L83:    pop 
L84:    aconst_null 
L85:    areturn 
L86:    aload_2 
L87:    instanceof [15] 
L90:    ifeq L136 
L93:    aload_0 
L94:    getfield [46] 
L97:    ldc [11] 
L99:    ldc [16] 
L101:   invokevirtual [49] 
L104:   pop 
L105:   aload_0 
L106:   new [82] 
L109:   dup 
L110:   aload_0 
L111:   getfield [45] 
L114:   invokespecial [67] 
L117:   putfield [76] 
L120:   aload_2 
L121:   checkcast [15] 
L124:   aload_0 
L125:   getfield [47] 
L128:   invokeinterface [83] 0 
L133:   goto L161 
L136:   aload_0 
L137:   invokevirtual [52] 
L140:   aload_1 
L141:   invokeinterface [81] 0 
L146:   pop 
L147:   aload_0 
L148:   getfield [46] 
L151:   ldc [18] 
L153:   ldc [19] 
L155:   invokevirtual [49] 
L158:   pop 
L159:   aconst_null 
L160:   areturn 
L161:   aload_0 
L162:   getfield [46] 
L165:   ldc [11] 
L167:   ldc [20] 
L169:   aload_2 
L170:   invokevirtual [55] 
L173:   pop 
L174:   aload_2 
L175:   areturn 
L176:   
    .end code 
.end method 

.method public enum [376] : [377] 
    .attribute [365] .code stack 0 locals 0 
L0:     return 
L1:     nop 
L2:     nop 
L3:     nop 
L4:     
    .end code 
.end method 

.method public [378] : [379] 
    .attribute [365] .code stack 4 locals 0 
L0:     aload_0 
L1:     getfield [46] 
L4:     ldc [6] 
L6:     ldc [21] 
L8:     invokevirtual [49] 
L11:    pop 
L12:    aload_2 
L13:    instanceof [10] 
L16:    ifeq L46 
L19:    aload_0 
L20:    getfield [46] 
L23:    ldc [11] 
L25:    ldc [22] 
L27:    invokevirtual [49] 
L30:    pop 
L31:    aload_0 
L32:    getfield [45] 
L35:    aload_2 
L36:    checkcast [10] 
L39:    invokevirtual [56] 
L42:    pop 
L43:    goto L91 
L46:    aload_2 
L47:    instanceof [15] 
L50:    ifeq L91 
L53:    aload_0 
L54:    getfield [46] 
L57:    ldc [11] 
L59:    ldc [23] 
L61:    invokevirtual [49] 
L64:    pop 
L65:    aconst_null 
L66:    aload_0 
L67:    getfield [47] 
L70:    if_acmpeq L91 
L73:    aload_2 
L74:    checkcast [15] 
L77:    aload_0 
L78:    getfield [47] 
L81:    invokeinterface [84] 0 
L86:    aload_0 
L87:    aconst_null 
L88:    putfield [76] 
L91:    aload_0 
L92:    getfield [46] 
L95:    ldc [11] 
L97:    ldc [24] 
L99:    aload_2 
L100:   invokevirtual [55] 
L103:   pop 
L104:   aload_0 
L105:   invokevirtual [52] 
L108:   aload_1 
L109:   invokeinterface [81] 0 
L114:   pop 
L115:   return 
L116:   
    .end code 
.end method 

.method private [380] : [381] 
    .attribute [365] .code stack 6 locals 0 
L0:     aload_0 
L1:     getfield [46] 
L4:     ldc [6] 
L6:     ldc [25] 
L8:     invokevirtual [49] 
L11:    pop 
L12:    aload_0 
L13:    iconst_2 
L14:    anewarray [26] 
L17:    dup 
L18:    iconst_0 
L19:    getstatic [27] 
L22:    ifnonnull L37 
L25:    ldc [28] 
L27:    invokestatic [29] 
L30:    dup 
L31:    putstatic [68] 
L34:    goto L40 
L37:    getstatic [27] 
L40:    invokevirtual [57] 
L43:    aastore 
L44:    dup 
L45:    iconst_1 
L46:    getstatic [30] 
L49:    ifnonnull L64 
L52:    ldc [31] 
L54:    invokestatic [29] 
L57:    dup 
L58:    putstatic [69] 
L61:    goto L67 
L64:    getstatic [30] 
L67:    invokevirtual [57] 
L70:    aastore 
L71:    aload_1 
L72:    aconst_null 
L73:    invokevirtual [58] 
L76:    return 
L77:    nop 
L78:    nop 
L79:    nop 
L80:    
    .end code 
.end method 

.method private [382] : [383] 
    .attribute [365] .code stack 6 locals 1 
L0:     aload_0 
L1:     getfield [46] 
L4:     ldc [6] 
L6:     ldc [32] 
L8:     invokevirtual [49] 
L11:    pop 
L12:    iconst_2 
L13:    anewarray [26] 
L16:    dup 
L17:    iconst_0 
L18:    getstatic [33] 
L21:    ifnonnull L36 
L24:    ldc [34] 
L26:    invokestatic [29] 
L29:    dup 
L30:    putstatic [70] 
L33:    goto L39 
L36:    getstatic [33] 
L39:    invokevirtual [57] 
L42:    aastore 
L43:    dup 
L44:    iconst_1 
L45:    getstatic [35] 
L48:    ifnonnull L63 
L51:    ldc [36] 
L53:    invokestatic [29] 
L56:    dup 
L57:    putstatic [71] 
L60:    goto L66 
L63:    getstatic [35] 
L66:    invokevirtual [57] 
L69:    aastore 
L70:    astore_1 
L71:    aload_0 
L72:    new [85] 
L75:    dup 
L76:    aload_0 
L77:    invokevirtual [52] 
L80:    aload_1 
L81:    aload_0 
L82:    invokespecial [72] 
L85:    putfield [79] 
L88:    aload_0 
L89:    getfield [50] 
L92:    invokevirtual [59] 
L95:    return 
L96:    
    .end code 
.end method 

.method static synthetic [384] : [385] 
    .attribute [365] .code stack 2 locals 1 
        .catch [3] from L0 to L4 using L5 
L0:     aload_0 
L1:     invokestatic [2] 
L4:     areturn 
L5:     astore_1 
L6:     new [73] 
L9:     dup 
L10:    invokespecial [60] 
L13:    aload_1 
L14:    invokevirtual [44] 
L17:    athrow 
L18:    nop 
L19:    nop 
L20:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Method [86] [87] 
.const [3] = Class [88] 
.const [4] = Class [89] 
.const [5] = String [90] 
.const [6] = Int 1078071040 
.const [7] = String [91] 
.const [8] = Class [92] 
.const [9] = String [93] 
.const [10] = Class [94] 
.const [11] = Int -2137614336 
.const [12] = String [95] 
.const [13] = Class [96] 
.const [14] = String [97] 
.const [15] = Class [98] 
.const [16] = String [99] 
.const [17] = Class [100] 
.const [18] = Int -1601830656 
.const [19] = String [101] 
.const [20] = String [102] 
.const [21] = String [103] 
.const [22] = String [104] 
.const [23] = String [105] 
.const [24] = String [106] 
.const [25] = String [107] 
.const [26] = Class [108] 
.const [27] = Field [109] [110] 
.const [28] = String [111] 
.const [29] = Method [112] [113] 
.const [30] = Field [114] [115] 
.const [31] = String [116] 
.const [32] = String [117] 
.const [33] = Field [118] [119] 
.const [34] = String [120] 
.const [35] = Field [121] [122] 
.const [36] = String [123] 
.const [37] = Class [124] 
.const [38] = Class [125] 
.const [39] = Class [126] 
.const [40] = Class [127] 
.const [41] = Class [128] 
.const [42] = Class [129] 
.const [43] = Class [130] 
.const [44] = Method [131] [132] 
.const [45] = Field [133] [134] 
.const [46] = Field [135] [136] 
.const [47] = Field [137] [138] 
.const [48] = Field [139] [140] 
.const [49] = Method [141] [142] 
.const [50] = Field [143] [144] 
.const [51] = Method [145] [146] 
.const [52] = Method [147] [148] 
.const [53] = Method [149] [150] 
.const [54] = Method [151] [152] 
.const [55] = Method [153] [154] 
.const [56] = Method [155] [156] 
.const [57] = Method [157] [158] 
.const [58] = Method [159] [160] 
.const [59] = Method [161] [162] 
.const [60] = Method [163] [164] 
.const [61] = Method [165] [166] 
.const [62] = Method [167] [168] 
.const [63] = Method [169] [170] 
.const [64] = Method [171] [172] 
.const [65] = Method [173] [174] 
.const [66] = Method [175] [176] 
.const [67] = Method [177] [178] 
.const [68] = Field [179] [180] 
.const [69] = Field [181] [182] 
.const [70] = Field [183] [184] 
.const [71] = Field [185] [186] 
.const [72] = Method [187] [188] 
.const [73] = Class [189] 
.const [74] = Field [190] [191] 
.const [75] = Field [192] [193] 
.const [76] = Field [194] [195] 
.const [77] = InterfaceMethod [196] [197] 
.const [78] = Class [198] 
.const [79] = Field [199] [200] 
.const [80] = InterfaceMethod [201] [202] 
.const [81] = InterfaceMethod [203] [204] 
.const [82] = Class [205] 
.const [83] = InterfaceMethod [206] [207] 
.const [84] = InterfaceMethod [208] [209] 
.const [85] = Class [210] 
.const [86] = Class [211] 
.const [87] = NameAndType [212] [213] 
.const [88] = Utf8 java/lang/ClassNotFoundException 
.const [89] = Utf8 java/lang/NoClassDefFoundError 
.const [90] = Utf8 'Fw.BulkCopy' 
.const [91] = Utf8 'BulkCopyActivator.start()' 
.const [92] = Utf8 de/audi/atip/bulkcopy/BulkCopyManagerImpl 
.const [93] = Utf8 'BulkCopyActivator.addingService(..)' 
.const [94] = Utf8 de/audi/atip/bulkcopy/IBulkCopyClient 
.const [95] = Utf8 'register bulkcopyclient' 
.const [96] = Utf8 de/audi/atip/bulkcopy/BulkCopyException 
.const [97] = Utf8 'register of bulkcopyclient %1 failed!' 
.const [98] = Utf8 de/audi/atip/diag/sw/SwDiagnosisManager 
.const [99] = Utf8 'register me to diagnosis manager' 
.const [100] = Utf8 de/mib/swdiagnosis/BulkCopyDiag 
.const [101] = Utf8 'adding unwanted service!' 
.const [102] = Utf8 'added service = %1' 
.const [103] = Utf8 'BulkCopyActivator.removedService(..)' 
.const [104] = Utf8 'unregister bulkcopyclient' 
.const [105] = Utf8 'unregister me from diagnosis manager' 
.const [106] = Utf8 'removed service = %1' 
.const [107] = Utf8 'BulkCopyActivator.registerServices(..)' 
.const [108] = Utf8 java/lang/String 
.const [109] = Class [214] 
.const [110] = NameAndType [215] [216] 
.const [111] = Utf8 'de.audi.atip.bulkcopy.IBulkCopyManager' 
.const [112] = Class [217] 
.const [113] = NameAndType [218] [219] 
.const [114] = Class [220] 
.const [115] = NameAndType [221] [222] 
.const [116] = Utf8 'de.esolutions.fw.util.commons.error.DumpInfoProvider' 
.const [117] = Utf8 'BulkCopyActivator.initTracker()' 
.const [118] = Class [223] 
.const [119] = NameAndType [224] [225] 
.const [120] = Utf8 'de.audi.atip.bulkcopy.IBulkCopyClient' 
.const [121] = Class [226] 
.const [122] = NameAndType [227] [228] 
.const [123] = Utf8 'de.audi.atip.diag.sw.SwDiagnosisManager' 
.const [124] = Utf8 org/osgi/util/tracker/ServiceTracker 
.const [125] = Utf8 de/audi/atip/bulkcopy/BulkCopyActivator 
.const [126] = Utf8 de/audi/atip/activator/AbstractActivator 
.const [127] = Utf8 java/lang/Class 
.const [128] = Utf8 de/audi/atip/base/IFrameworkAccess 
.const [129] = Utf8 de/audi/atip/log/LogChannel 
.const [130] = Utf8 org/osgi/framework/BundleContext 
.const [131] = Class [229] 
.const [132] = NameAndType [230] [231] 
.const [133] = Class [232] 
.const [134] = NameAndType [233] [234] 
.const [135] = Class [235] 
.const [136] = NameAndType [236] [237] 
.const [137] = Class [238] 
.const [138] = NameAndType [239] [240] 
.const [139] = Class [241] 
.const [140] = NameAndType [242] [243] 
.const [141] = Class [244] 
.const [142] = NameAndType [245] [246] 
.const [143] = Class [247] 
.const [144] = NameAndType [248] [249] 
.const [145] = Class [250] 
.const [146] = NameAndType [251] [252] 
.const [147] = Class [253] 
.const [148] = NameAndType [254] [255] 
.const [149] = Class [256] 
.const [150] = NameAndType [257] [258] 
.const [151] = Class [259] 
.const [152] = NameAndType [260] [261] 
.const [153] = Class [262] 
.const [154] = NameAndType [263] [264] 
.const [155] = Class [265] 
.const [156] = NameAndType [266] [267] 
.const [157] = Class [268] 
.const [158] = NameAndType [269] [270] 
.const [159] = Class [271] 
.const [160] = NameAndType [272] [273] 
.const [161] = Class [274] 
.const [162] = NameAndType [275] [276] 
.const [163] = Class [277] 
.const [164] = NameAndType [278] [279] 
.const [165] = Class [280] 
.const [166] = NameAndType [281] [282] 
.const [167] = Class [283] 
.const [168] = NameAndType [284] [285] 
.const [169] = Class [286] 
.const [170] = NameAndType [287] [288] 
.const [171] = Class [289] 
.const [172] = NameAndType [290] [291] 
.const [173] = Class [292] 
.const [174] = NameAndType [293] [294] 
.const [175] = Class [295] 
.const [176] = NameAndType [296] [297] 
.const [177] = Class [298] 
.const [178] = NameAndType [299] [300] 
.const [179] = Class [301] 
.const [180] = NameAndType [302] [303] 
.const [181] = Class [304] 
.const [182] = NameAndType [305] [306] 
.const [183] = Class [307] 
.const [184] = NameAndType [308] [309] 
.const [185] = Class [310] 
.const [186] = NameAndType [311] [312] 
.const [187] = Class [313] 
.const [188] = NameAndType [314] [315] 
.const [189] = Utf8 java/lang/NoClassDefFoundError 
.const [190] = Class [316] 
.const [191] = NameAndType [317] [318] 
.const [192] = Class [319] 
.const [193] = NameAndType [320] [321] 
.const [194] = Class [322] 
.const [195] = NameAndType [323] [324] 
.const [196] = Class [325] 
.const [197] = NameAndType [326] [327] 
.const [198] = Utf8 de/audi/atip/bulkcopy/BulkCopyManagerImpl 
.const [199] = Class [328] 
.const [200] = NameAndType [329] [330] 
.const [201] = Class [331] 
.const [202] = NameAndType [332] [333] 
.const [203] = Class [334] 
.const [204] = NameAndType [335] [336] 
.const [205] = Utf8 de/mib/swdiagnosis/BulkCopyDiag 
.const [206] = Class [337] 
.const [207] = NameAndType [338] [339] 
.const [208] = Class [340] 
.const [209] = NameAndType [341] [342] 
.const [210] = Utf8 org/osgi/util/tracker/ServiceTracker 
.const [211] = Utf8 java/lang/Class 
.const [212] = Utf8 forName 
.const [213] = Utf8 (Ljava/lang/String;)Ljava/lang/Class; 
.const [214] = Utf8 de/audi/atip/bulkcopy/BulkCopyActivator 
.const [215] = Utf8 class$de$audi$atip$bulkcopy$IBulkCopyManager 
.const [216] = Utf8 Ljava/lang/Class; 
.const [217] = Utf8 de/audi/atip/bulkcopy/BulkCopyActivator 
.const [218] = Utf8 class$ 
.const [219] = Utf8 (Ljava/lang/String;)Ljava/lang/Class; 
.const [220] = Utf8 de/audi/atip/bulkcopy/BulkCopyActivator 
.const [221] = Utf8 class$de$esolutions$fw$util$commons$error$DumpInfoProvider 
.const [222] = Utf8 Ljava/lang/Class; 
.const [223] = Utf8 de/audi/atip/bulkcopy/BulkCopyActivator 
.const [224] = Utf8 class$de$audi$atip$bulkcopy$IBulkCopyClient 
.const [225] = Utf8 Ljava/lang/Class; 
.const [226] = Utf8 de/audi/atip/bulkcopy/BulkCopyActivator 
.const [227] = Utf8 class$de$audi$atip$diag$sw$SwDiagnosisManager 
.const [228] = Utf8 Ljava/lang/Class; 
.const [229] = Utf8 java/lang/NoClassDefFoundError 
.const [230] = Utf8 initCause 
.const [231] = Utf8 (Ljava/lang/Throwable;)Ljava/lang/Throwable; 
.const [232] = Utf8 de/audi/atip/bulkcopy/BulkCopyActivator 
.const [233] = Utf8 m_manager 
.const [234] = Utf8 Lde/audi/atip/bulkcopy/BulkCopyManagerImpl; 
.const [235] = Utf8 de/audi/atip/bulkcopy/BulkCopyActivator 
.const [236] = Utf8 m_log 
.const [237] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [238] = Utf8 de/audi/atip/bulkcopy/BulkCopyActivator 
.const [239] = Utf8 m_diag 
.const [240] = Utf8 Lde/mib/swdiagnosis/BulkCopyDiag; 
.const [241] = Utf8 de/audi/atip/bulkcopy/BulkCopyActivator 
.const [242] = Utf8 framework 
.const [243] = Utf8 Lde/audi/atip/base/IFrameworkAccess; 
.const [244] = Utf8 de/audi/atip/log/LogChannel 
.const [245] = Utf8 log 
.const [246] = Utf8 (ILjava/lang/String;)Z 
.const [247] = Utf8 de/audi/atip/bulkcopy/BulkCopyActivator 
.const [248] = Utf8 m_tracker 
.const [249] = Utf8 Lorg/osgi/util/tracker/ServiceTracker; 
.const [250] = Utf8 org/osgi/util/tracker/ServiceTracker 
.const [251] = Utf8 close 
.const [252] = Utf8 ()V 
.const [253] = Utf8 de/audi/atip/bulkcopy/BulkCopyActivator 
.const [254] = Utf8 getBundleContext 
.const [255] = Utf8 ()Lorg/osgi/framework/BundleContext; 
.const [256] = Utf8 de/audi/atip/bulkcopy/BulkCopyManagerImpl 
.const [257] = Utf8 registerClient 
.const [258] = Utf8 (Lde/audi/atip/bulkcopy/IBulkCopyClient;)Z 
.const [259] = Utf8 de/audi/atip/log/LogChannel 
.const [260] = Utf8 log 
.const [261] = Utf8 (ILjava/lang/String;Ljava/lang/Object;Ljava/lang/Throwable;)Z 
.const [262] = Utf8 de/audi/atip/log/LogChannel 
.const [263] = Utf8 log 
.const [264] = Utf8 (ILjava/lang/String;Ljava/lang/Object;)Z 
.const [265] = Utf8 de/audi/atip/bulkcopy/BulkCopyManagerImpl 
.const [266] = Utf8 unregisterClient 
.const [267] = Utf8 (Lde/audi/atip/bulkcopy/IBulkCopyClient;)Z 
.const [268] = Utf8 java/lang/Class 
.const [269] = Utf8 getName 
.const [270] = Utf8 ()Ljava/lang/String; 
.const [271] = Utf8 de/audi/atip/bulkcopy/BulkCopyActivator 
.const [272] = Utf8 registerService 
.const [273] = Utf8 ([Ljava/lang/String;Ljava/lang/Object;Ljava/util/Dictionary;)V 
.const [274] = Utf8 org/osgi/util/tracker/ServiceTracker 
.const [275] = Utf8 'open' 
.const [276] = Utf8 ()V 
.const [277] = Utf8 java/lang/NoClassDefFoundError 
.const [278] = Utf8 <init> 
.const [279] = Utf8 ()V 
.const [280] = Utf8 de/audi/atip/activator/AbstractActivator 
.const [281] = Utf8 <init> 
.const [282] = Utf8 ()V 
.const [283] = Utf8 de/audi/atip/activator/AbstractActivator 
.const [284] = Utf8 start 
.const [285] = Utf8 (Lorg/osgi/framework/BundleContext;)V 
.const [286] = Utf8 de/audi/atip/bulkcopy/BulkCopyManagerImpl 
.const [287] = Utf8 <init> 
.const [288] = Utf8 (Lde/audi/atip/base/IFrameworkAccess;Lde/audi/atip/log/LogChannel;[I)V 
.const [289] = Utf8 de/audi/atip/bulkcopy/BulkCopyActivator 
.const [290] = Utf8 registerServices 
.const [291] = Utf8 (Lde/audi/atip/bulkcopy/BulkCopyManagerImpl;)V 
.const [292] = Utf8 de/audi/atip/bulkcopy/BulkCopyActivator 
.const [293] = Utf8 initTracker 
.const [294] = Utf8 ()V 
.const [295] = Utf8 de/audi/atip/activator/AbstractActivator 
.const [296] = Utf8 stop 
.const [297] = Utf8 (Lorg/osgi/framework/BundleContext;)V 
.const [298] = Utf8 de/mib/swdiagnosis/BulkCopyDiag 
.const [299] = Utf8 <init> 
.const [300] = Utf8 (Lde/audi/atip/bulkcopy/IBulkCopyManager;)V 
.const [301] = Utf8 de/audi/atip/bulkcopy/BulkCopyActivator 
.const [302] = Utf8 class$de$audi$atip$bulkcopy$IBulkCopyManager 
.const [303] = Utf8 Ljava/lang/Class; 
.const [304] = Utf8 de/audi/atip/bulkcopy/BulkCopyActivator 
.const [305] = Utf8 class$de$esolutions$fw$util$commons$error$DumpInfoProvider 
.const [306] = Utf8 Ljava/lang/Class; 
.const [307] = Utf8 de/audi/atip/bulkcopy/BulkCopyActivator 
.const [308] = Utf8 class$de$audi$atip$bulkcopy$IBulkCopyClient 
.const [309] = Utf8 Ljava/lang/Class; 
.const [310] = Utf8 de/audi/atip/bulkcopy/BulkCopyActivator 
.const [311] = Utf8 class$de$audi$atip$diag$sw$SwDiagnosisManager 
.const [312] = Utf8 Ljava/lang/Class; 
.const [313] = Utf8 org/osgi/util/tracker/ServiceTracker 
.const [314] = Utf8 <init> 
.const [315] = Utf8 (Lorg/osgi/framework/BundleContext;[Ljava/lang/String;Lorg/osgi/util/tracker/ServiceTrackerCustomizer;)V 
.const [316] = Utf8 de/audi/atip/bulkcopy/BulkCopyActivator 
.const [317] = Utf8 m_manager 
.const [318] = Utf8 Lde/audi/atip/bulkcopy/BulkCopyManagerImpl; 
.const [319] = Utf8 de/audi/atip/bulkcopy/BulkCopyActivator 
.const [320] = Utf8 m_log 
.const [321] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [322] = Utf8 de/audi/atip/bulkcopy/BulkCopyActivator 
.const [323] = Utf8 m_diag 
.const [324] = Utf8 Lde/mib/swdiagnosis/BulkCopyDiag; 
.const [325] = Utf8 de/audi/atip/base/IFrameworkAccess 
.const [326] = Utf8 getLogChannel 
.const [327] = Utf8 (Ljava/lang/String;)Lde/audi/atip/log/LogChannel; 
.const [328] = Utf8 de/audi/atip/bulkcopy/BulkCopyActivator 
.const [329] = Utf8 m_tracker 
.const [330] = Utf8 Lorg/osgi/util/tracker/ServiceTracker; 
.const [331] = Utf8 org/osgi/framework/BundleContext 
.const [332] = Utf8 getService 
.const [333] = Utf8 (Lorg/osgi/framework/ServiceReference;)Ljava/lang/Object; 
.const [334] = Utf8 org/osgi/framework/BundleContext 
.const [335] = Utf8 ungetService 
.const [336] = Utf8 (Lorg/osgi/framework/ServiceReference;)Z 
.const [337] = Utf8 de/audi/atip/diag/sw/SwDiagnosisManager 
.const [338] = Utf8 addDiagGateway 
.const [339] = Utf8 (Lde/audi/atip/diag/sw/AbstractSwDiagnosis;)V 
.const [340] = Utf8 de/audi/atip/diag/sw/SwDiagnosisManager 
.const [341] = Utf8 removeDiagGateway 
.const [342] = Utf8 (Lde/audi/atip/diag/sw/AbstractSwDiagnosis;)V 
.const [343] = Utf8 de/audi/atip/bulkcopy/BulkCopyActivator 
.const [344] = Class [343] 
.const [345] = Utf8 de/audi/atip/activator/AbstractActivator 
.const [346] = Class [345] 
.const [347] = Utf8 org/osgi/util/tracker/ServiceTrackerCustomizer 
.const [348] = Class [347] 
.const [349] = Utf8 m_manager 
.const [350] = Utf8 Lde/audi/atip/bulkcopy/BulkCopyManagerImpl; 
.const [351] = Utf8 m_log 
.const [352] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [353] = Utf8 m_tracker 
.const [354] = Utf8 Lorg/osgi/util/tracker/ServiceTracker; 
.const [355] = Utf8 m_diag 
.const [356] = Utf8 Lde/mib/swdiagnosis/BulkCopyDiag; 
.const [357] = Utf8 class$de$audi$atip$bulkcopy$IBulkCopyManager 
.const [358] = Utf8 Ljava/lang/Class; 
.const [359] = Utf8 class$de$esolutions$fw$util$commons$error$DumpInfoProvider 
.const [360] = Utf8 Ljava/lang/Class; 
.const [361] = Utf8 class$de$audi$atip$bulkcopy$IBulkCopyClient 
.const [362] = Utf8 Ljava/lang/Class; 
.const [363] = Utf8 class$de$audi$atip$diag$sw$SwDiagnosisManager 
.const [364] = Utf8 Ljava/lang/Class; 
.const [365] = Utf8 Code 
.const [366] = Utf8 <init> 
.const [367] = Utf8 ()V 
.const [368] = Utf8 start 
.const [369] = Utf8 (Lorg/osgi/framework/BundleContext;)V 
.const [370] = Utf8 getService 
.const [371] = Utf8 ()Lde/audi/atip/bulkcopy/BulkCopyManagerImpl; 
.const [372] = Utf8 stop 
.const [373] = Utf8 (Lorg/osgi/framework/BundleContext;)V 
.const [374] = Utf8 addingService 
.const [375] = Utf8 (Lorg/osgi/framework/ServiceReference;)Ljava/lang/Object; 
.const [376] = Utf8 modifiedService 
.const [377] = Utf8 (Lorg/osgi/framework/ServiceReference;Ljava/lang/Object;)V 
.const [378] = Utf8 removedService 
.const [379] = Utf8 (Lorg/osgi/framework/ServiceReference;Ljava/lang/Object;)V 
.const [380] = Utf8 registerServices 
.const [381] = Utf8 (Lde/audi/atip/bulkcopy/BulkCopyManagerImpl;)V 
.const [382] = Utf8 initTracker 
.const [383] = Utf8 ()V 
.const [384] = Utf8 class$ 
.const [385] = Utf8 (Ljava/lang/String;)Ljava/lang/Class; 
.end class 
