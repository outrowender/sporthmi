.version 50 0 
.class public super [355] 
.super [357] 
.implements [359] 
.field private static final [360] [361] 
.field private final [362] [363] 
.field private final [364] [365] 
.field private final [366] [367] 
.field private final [368] [369] 
.field private final [370] [371] 
.field static synthetic [372] [373] 

.method public [375] : [376] 
    .attribute [374] .code stack 3 locals 0 
L0:     aload_0 
L1:     invokespecial [53] 
L4:     aload_0 
L5:     aload 4 
L7:     invokeinterface [65] 0 
L12:    putfield [66] 
L15:    aload_0 
L16:    aload_1 
L17:    putfield [67] 
L20:    aload_0 
L21:    aload_3 
L22:    putfield [68] 
L25:    aload_0 
L26:    aload_2 
L27:    putfield [69] 
L30:    aload_0 
L31:    new [70] 
L34:    dup 
L35:    invokespecial [54] 
L38:    putfield [63] 
L41:    return 
L42:    nop 
L43:    nop 
L44:    
    .end code 
.end method 

.method public [377] : [378] 
    .attribute [374] .code stack 5 locals 0 
L0:     aload_1 
L1:     ifnull L8 
L4:     aload_2 
L5:     ifnonnull L16 
L8:     new [71] 
L11:    dup 
L12:    invokespecial [55] 
L15:    athrow 
L16:    new [72] 
L19:    dup 
L20:    aload_0 
L21:    getfield [43] 
L24:    aload_1 
L25:    aload_2 
L26:    invokespecial [56] 
L29:    areturn 
L30:    nop 
L31:    nop 
L32:    
    .end code 
.end method 

.method public [379] : [380] 
    .attribute [374] .code stack 3 locals 1 
L0:     aload_1 
L1:     ifnonnull L12 
L4:     new [71] 
L7:     dup 
L8:     invokespecial [55] 
L11:    athrow 
        .catch [8] from L12 to L26 using L27 
L12:    aload_0 
L13:    getfield [43] 
L16:    aload_1 
L17:    invokevirtual [46] 
L20:    aconst_null 
L21:    invokeinterface [73] 0 
L26:    areturn 
L27:    astore_2 
L28:    iconst_0 
L29:    anewarray [9] 
L32:    areturn 
L33:    nop 
L34:    nop 
L35:    nop 
L36:    
    .end code 
.end method 

.method public final [381] : [382] 
    .attribute [374] .code stack 6 locals 1 
L0:     aload_1 
L1:     ifnull L12 
L4:     aload_2 
L5:     ifnull L12 
L8:     aload_3 
L9:     ifnonnull L20 
L12:    new [71] 
L15:    dup 
L16:    invokespecial [55] 
L19:    athrow 
L20:    aload_0 
L21:    getfield [42] 
L24:    ldc [10] 
L26:    ldc [11] 
L28:    ldc [12] 
L30:    aload_0 
L31:    aload_1 
L32:    invokevirtual [46] 
L35:    invokespecial [57] 
L38:    invokevirtual [47] 
L41:    aload_0 
L42:    getfield [43] 
L45:    aload_1 
L46:    invokevirtual [46] 
L49:    aload_2 
L50:    aload_3 
L51:    invokeinterface [74] 0 
L56:    astore 4 
L58:    aload_0 
L59:    getfield [40] 
L62:    aload 4 
L64:    invokeinterface [75] 0 
L69:    pop 
L70:    new [76] 
L73:    dup 
L74:    aload_0 
L75:    aload 4 
L77:    invokespecial [58] 
L80:    areturn 
L81:    nop 
L82:    nop 
L83:    nop 
L84:    
    .end code 
.end method 

.method public [383] : [384] 
    .attribute [374] .code stack 2 locals 1 
        .catch [14] from L0 to L6 using L9 
L0:     aload_1 
L1:     invokeinterface [77] 0 
L6:     goto L18 
L9:     astore_2 
L10:    new [71] 
L13:    dup 
L14:    invokespecial [55] 
L17:    athrow 
L18:    return 
L19:    nop 
L20:    
    .end code 
.end method 

.method public final [385] : [386] 
    .attribute [374] .code stack 7 locals 2 
L0:     aload_0 
L1:     getfield [42] 
L4:     ldc [15] 
L6:     ldc [16] 
L8:     ldc [12] 
L10:    aload_0 
L11:    aload_2 
L12:    invokespecial [57] 
L15:    iload_1 
L16:    i2l 
L17:    invokevirtual [48] 
L20:    aload_2 
L21:    ifnull L28 
L24:    aload_3 
L25:    ifnonnull L36 
L28:    new [71] 
L31:    dup 
L32:    invokespecial [55] 
L35:    athrow 
L36:    aload_0 
L37:    getfield [45] 
L40:    aload_2 
L41:    aload_3 
L42:    invokeinterface [78] 0 
L47:    astore 4 
L49:    new [79] 
L52:    dup 
L53:    iconst_2 
L54:    invokespecial [59] 
L57:    astore 5 
L59:    aload 5 
L61:    ldc [18] 
L63:    aload_2 
L64:    invokevirtual [49] 
L67:    pop 
L68:    aload 5 
L70:    ldc [19] 
L72:    new [80] 
L75:    dup 
L76:    iload_1 
L77:    invokespecial [60] 
L80:    invokevirtual [49] 
L83:    pop 
L84:    aload_0 
L85:    getstatic [21] 
L88:    ifnonnull L103 
L91:    ldc [22] 
L93:    invokestatic [23] 
L96:    dup 
L97:    putstatic [61] 
L100:   goto L106 
L103:   getstatic [21] 
L106:   aload 4 
L108:   aload 5 
L110:   invokespecial [62] 
L113:   areturn 
L114:   nop 
L115:   nop 
L116:   
    .end code 
.end method 

.method public [387] : [388] 
    .attribute [374] .code stack 4 locals 1 
L0:     aload_1 
L1:     ifnonnull L12 
L4:     new [71] 
L7:     dup 
L8:     invokespecial [55] 
L11:    athrow 
L12:    aload_1 
L13:    ldc [24] 
L15:    invokeinterface [81] 0 
L20:    checkcast [25] 
L23:    checkcast [25] 
L26:    astore_2 
L27:    aload_2 
L28:    arraylength 
L29:    iconst_1 
L30:    if_icmpne L56 
L33:    aload_0 
L34:    getfield [45] 
L37:    aload_2 
L38:    iconst_0 
L39:    aaload 
L40:    aload_0 
L41:    getfield [43] 
L44:    aload_1 
L45:    invokeinterface [82] 0 
L50:    invokeinterface [78] 0 
L55:    areturn 
L56:    aload_0 
L57:    getfield [43] 
L60:    aload_1 
L61:    invokeinterface [82] 0 
L66:    areturn 
L67:    nop 
L68:    
    .end code 
.end method 

.method public [389] : [390] 
    .attribute [374] .code stack 2 locals 0 
L0:     aload_1 
L1:     ifnonnull L12 
L4:     new [71] 
L7:     dup 
L8:     invokespecial [55] 
L11:    athrow 
L12:    aload_0 
L13:    getfield [43] 
L16:    aload_1 
L17:    invokeinterface [83] 0 
L22:    pop 
L23:    return 
L24:    
    .end code 
.end method 

.method public [391] : [392] 
    .attribute [374] .code stack 7 locals 0 
L0:     aload_0 
L1:     getfield [42] 
L4:     ldc [15] 
L6:     ldc [26] 
L8:     ldc [12] 
L10:    aload_0 
L11:    aload_1 
L12:    invokespecial [57] 
L15:    iload_2 
L16:    i2l 
L17:    invokevirtual [48] 
L20:    aload_0 
L21:    getfield [44] 
L24:    aload_1 
L25:    iload_2 
L26:    invokeinterface [84] 0 
L31:    areturn 
L32:    
    .end code 
.end method 

.method private [393] : [394] 
    .attribute [374] .code stack 3 locals 0 
L0:     aload_1 
L1:     ifnonnull L12 
L4:     new [71] 
L7:     dup 
L8:     invokespecial [55] 
L11:    athrow 
L12:    aload_1 
L13:    aload_1 
L14:    bipush 46 
L16:    invokevirtual [50] 
L19:    iconst_1 
L20:    iadd 
L21:    invokevirtual [51] 
L24:    areturn 
L25:    nop 
L26:    nop 
L27:    nop 
L28:    
    .end code 
.end method 

.method public interface [395] : [396] 
    .attribute [374] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [44] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public interface [397] : [398] 
    .attribute [374] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [43] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [399] : [400] 
    .attribute [374] .code stack 1 locals 1 
L0:     aload_0 
L1:     getfield [40] 
L4:     invokeinterface [85] 0 
L9:     astore_1 
L10:    aload_1 
L11:    invokeinterface [86] 0 
L16:    ifeq L36 
L19:    aload_1 
L20:    invokeinterface [87] 0 
L25:    checkcast [27] 
L28:    invokeinterface [77] 0 
L33:    goto L10 
L36:    aload_0 
L37:    getfield [40] 
L40:    invokeinterface [88] 0 
L45:    return 
L46:    nop 
L47:    nop 
L48:    
    .end code 
.end method 

.method static synthetic [401] : [402] 
    .attribute [374] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [40] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method static synthetic [403] : [404] 
    .attribute [374] .code stack 2 locals 1 
        .catch [3] from L0 to L4 using L5 
L0:     aload_0 
L1:     invokestatic [2] 
L4:     areturn 
L5:     astore_1 
L6:     new [64] 
L9:     dup 
L10:    invokespecial [52] 
L13:    aload_1 
L14:    invokevirtual [41] 
L17:    athrow 
L18:    nop 
L19:    nop 
L20:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Method [89] [90] 
.const [3] = Class [91] 
.const [4] = Class [92] 
.const [5] = Class [93] 
.const [6] = Class [94] 
.const [7] = Class [95] 
.const [8] = Class [96] 
.const [9] = Class [97] 
.const [10] = Int -2137614336 
.const [11] = String [98] 
.const [12] = String [99] 
.const [13] = Class [100] 
.const [14] = Class [101] 
.const [15] = Int 14808325 
.const [16] = String [102] 
.const [17] = Class [103] 
.const [18] = String [104] 
.const [19] = String [105] 
.const [20] = Class [106] 
.const [21] = Field [107] [108] 
.const [22] = String [109] 
.const [23] = Method [110] [111] 
.const [24] = String [112] 
.const [25] = Class [113] 
.const [26] = String [114] 
.const [27] = Class [115] 
.const [28] = Class [116] 
.const [29] = Class [117] 
.const [30] = Class [118] 
.const [31] = Class [119] 
.const [32] = Class [120] 
.const [33] = Class [121] 
.const [34] = Class [122] 
.const [35] = Class [123] 
.const [36] = Class [124] 
.const [37] = Class [125] 
.const [38] = Class [126] 
.const [39] = Class [127] 
.const [40] = Field [128] [129] 
.const [41] = Method [130] [131] 
.const [42] = Field [132] [133] 
.const [43] = Field [134] [135] 
.const [44] = Field [136] [137] 
.const [45] = Field [138] [139] 
.const [46] = Method [140] [141] 
.const [47] = Method [142] [143] 
.const [48] = Method [144] [145] 
.const [49] = Method [146] [147] 
.const [50] = Method [148] [149] 
.const [51] = Method [150] [151] 
.const [52] = Method [152] [153] 
.const [53] = Method [154] [155] 
.const [54] = Method [156] [157] 
.const [55] = Method [158] [159] 
.const [56] = Method [160] [161] 
.const [57] = Method [162] [163] 
.const [58] = Method [164] [165] 
.const [59] = Method [166] [167] 
.const [60] = Method [168] [169] 
.const [61] = Field [170] [171] 
.const [62] = Method [172] [173] 
.const [63] = Field [174] [175] 
.const [64] = Class [176] 
.const [65] = InterfaceMethod [177] [178] 
.const [66] = Field [179] [180] 
.const [67] = Field [181] [182] 
.const [68] = Field [183] [184] 
.const [69] = Field [185] [186] 
.const [70] = Class [187] 
.const [71] = Class [188] 
.const [72] = Class [189] 
.const [73] = InterfaceMethod [190] [191] 
.const [74] = InterfaceMethod [192] [193] 
.const [75] = InterfaceMethod [194] [195] 
.const [76] = Class [196] 
.const [77] = InterfaceMethod [197] [198] 
.const [78] = InterfaceMethod [199] [200] 
.const [79] = Class [201] 
.const [80] = Class [202] 
.const [81] = InterfaceMethod [203] [204] 
.const [82] = InterfaceMethod [205] [206] 
.const [83] = InterfaceMethod [207] [208] 
.const [84] = InterfaceMethod [209] [210] 
.const [85] = InterfaceMethod [211] [212] 
.const [86] = InterfaceMethod [213] [214] 
.const [87] = InterfaceMethod [215] [216] 
.const [88] = InterfaceMethod [217] [218] 
.const [89] = Class [219] 
.const [90] = NameAndType [220] [221] 
.const [91] = Utf8 java/lang/ClassNotFoundException 
.const [92] = Utf8 java/lang/NoClassDefFoundError 
.const [93] = Utf8 java/util/ArrayList 
.const [94] = Utf8 java/lang/IllegalArgumentException 
.const [95] = Utf8 de/audi/app/terminalmode/osgi/ServiceTrackerImpl 
.const [96] = Utf8 java/lang/Exception 
.const [97] = Utf8 org/osgi/framework/ServiceReference 
.const [98] = Utf8 "[%1.registerService] '%2'." 
.const [99] = Utf8 ServiceManagerImpl 
.const [100] = Utf8 de/audi/app/terminalmode/osgi/ServiceManagerImpl$1 
.const [101] = Utf8 java/lang/NullPointerException 
.const [102] = Utf8 '[%1.registerDSIListener] [%2,%3]' 
.const [103] = Utf8 java/util/Hashtable 
.const [104] = Utf8 DEVICE_NAME 
.const [105] = Utf8 DEVICE_INSTANCE 
.const [106] = Utf8 java/lang/Integer 
.const [107] = Class [222] 
.const [108] = NameAndType [223] [224] 
.const [109] = Utf8 'org.dsi.ifc.base.DSIListener' 
.const [110] = Class [225] 
.const [111] = NameAndType [226] [227] 
.const [112] = Utf8 objectClass 
.const [113] = Utf8 [Ljava/lang/String; 
.const [114] = Utf8 '[%1.startDSIService] [%2,%3]' 
.const [115] = Utf8 org/osgi/framework/ServiceRegistration 
.const [116] = Utf8 de/audi/app/terminalmode/osgi/ServiceManagerImpl 
.const [117] = Utf8 java/lang/Object 
.const [118] = Utf8 java/lang/Class 
.const [119] = Utf8 de/audi/app/terminalmode/ITerminalLogger 
.const [120] = Utf8 org/osgi/framework/BundleContext 
.const [121] = Utf8 de/audi/atip/log/LogChannel 
.const [122] = Utf8 java/util/List 
.const [123] = Utf8 de/audi/app/terminalmode/logging/ILoggingDecoratorFactory 
.const [124] = Utf8 java/util/Dictionary 
.const [125] = Utf8 de/audi/atip/base/IFrameworkAccess 
.const [126] = Utf8 java/lang/String 
.const [127] = Utf8 java/util/Iterator 
.const [128] = Class [228] 
.const [129] = NameAndType [229] [230] 
.const [130] = Class [231] 
.const [131] = NameAndType [232] [233] 
.const [132] = Class [234] 
.const [133] = NameAndType [235] [236] 
.const [134] = Class [237] 
.const [135] = NameAndType [238] [239] 
.const [136] = Class [240] 
.const [137] = NameAndType [241] [242] 
.const [138] = Class [243] 
.const [139] = NameAndType [244] [245] 
.const [140] = Class [246] 
.const [141] = NameAndType [247] [248] 
.const [142] = Class [249] 
.const [143] = NameAndType [250] [251] 
.const [144] = Class [252] 
.const [145] = NameAndType [253] [254] 
.const [146] = Class [255] 
.const [147] = NameAndType [256] [257] 
.const [148] = Class [258] 
.const [149] = NameAndType [259] [260] 
.const [150] = Class [261] 
.const [151] = NameAndType [262] [263] 
.const [152] = Class [264] 
.const [153] = NameAndType [265] [266] 
.const [154] = Class [267] 
.const [155] = NameAndType [268] [269] 
.const [156] = Class [270] 
.const [157] = NameAndType [271] [272] 
.const [158] = Class [273] 
.const [159] = NameAndType [274] [275] 
.const [160] = Class [276] 
.const [161] = NameAndType [277] [278] 
.const [162] = Class [279] 
.const [163] = NameAndType [280] [281] 
.const [164] = Class [282] 
.const [165] = NameAndType [283] [284] 
.const [166] = Class [285] 
.const [167] = NameAndType [286] [287] 
.const [168] = Class [288] 
.const [169] = NameAndType [289] [290] 
.const [170] = Class [291] 
.const [171] = NameAndType [292] [293] 
.const [172] = Class [294] 
.const [173] = NameAndType [295] [296] 
.const [174] = Class [297] 
.const [175] = NameAndType [298] [299] 
.const [176] = Utf8 java/lang/NoClassDefFoundError 
.const [177] = Class [300] 
.const [178] = NameAndType [301] [302] 
.const [179] = Class [303] 
.const [180] = NameAndType [304] [305] 
.const [181] = Class [306] 
.const [182] = NameAndType [307] [308] 
.const [183] = Class [309] 
.const [184] = NameAndType [310] [311] 
.const [185] = Class [312] 
.const [186] = NameAndType [313] [314] 
.const [187] = Utf8 java/util/ArrayList 
.const [188] = Utf8 java/lang/IllegalArgumentException 
.const [189] = Utf8 de/audi/app/terminalmode/osgi/ServiceTrackerImpl 
.const [190] = Class [315] 
.const [191] = NameAndType [316] [317] 
.const [192] = Class [318] 
.const [193] = NameAndType [319] [320] 
.const [194] = Class [321] 
.const [195] = NameAndType [322] [323] 
.const [196] = Utf8 de/audi/app/terminalmode/osgi/ServiceManagerImpl$1 
.const [197] = Class [324] 
.const [198] = NameAndType [325] [326] 
.const [199] = Class [327] 
.const [200] = NameAndType [328] [329] 
.const [201] = Utf8 java/util/Hashtable 
.const [202] = Utf8 java/lang/Integer 
.const [203] = Class [330] 
.const [204] = NameAndType [331] [332] 
.const [205] = Class [333] 
.const [206] = NameAndType [334] [335] 
.const [207] = Class [336] 
.const [208] = NameAndType [337] [338] 
.const [209] = Class [339] 
.const [210] = NameAndType [340] [341] 
.const [211] = Class [342] 
.const [212] = NameAndType [343] [344] 
.const [213] = Class [345] 
.const [214] = NameAndType [346] [347] 
.const [215] = Class [348] 
.const [216] = NameAndType [349] [350] 
.const [217] = Class [351] 
.const [218] = NameAndType [352] [353] 
.const [219] = Utf8 java/lang/Class 
.const [220] = Utf8 forName 
.const [221] = Utf8 (Ljava/lang/String;)Ljava/lang/Class; 
.const [222] = Utf8 de/audi/app/terminalmode/osgi/ServiceManagerImpl 
.const [223] = Utf8 class$org$dsi$ifc$base$DSIListener 
.const [224] = Utf8 Ljava/lang/Class; 
.const [225] = Utf8 de/audi/app/terminalmode/osgi/ServiceManagerImpl 
.const [226] = Utf8 class$ 
.const [227] = Utf8 (Ljava/lang/String;)Ljava/lang/Class; 
.const [228] = Utf8 de/audi/app/terminalmode/osgi/ServiceManagerImpl 
.const [229] = Utf8 registeredServices 
.const [230] = Utf8 Ljava/util/List; 
.const [231] = Utf8 java/lang/NoClassDefFoundError 
.const [232] = Utf8 initCause 
.const [233] = Utf8 (Ljava/lang/Throwable;)Ljava/lang/Throwable; 
.const [234] = Utf8 de/audi/app/terminalmode/osgi/ServiceManagerImpl 
.const [235] = Utf8 logger 
.const [236] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [237] = Utf8 de/audi/app/terminalmode/osgi/ServiceManagerImpl 
.const [238] = Utf8 osgiBundleContext 
.const [239] = Utf8 Lorg/osgi/framework/BundleContext; 
.const [240] = Utf8 de/audi/app/terminalmode/osgi/ServiceManagerImpl 
.const [241] = Utf8 framework 
.const [242] = Utf8 Lde/audi/atip/base/IFrameworkAccess; 
.const [243] = Utf8 de/audi/app/terminalmode/osgi/ServiceManagerImpl 
.const [244] = Utf8 loggingDecoratorFactory 
.const [245] = Utf8 Lde/audi/app/terminalmode/logging/ILoggingDecoratorFactory; 
.const [246] = Utf8 java/lang/Class 
.const [247] = Utf8 getName 
.const [248] = Utf8 ()Ljava/lang/String; 
.const [249] = Utf8 de/audi/atip/log/LogChannel 
.const [250] = Utf8 log 
.const [251] = Utf8 (ILjava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V 
.const [252] = Utf8 de/audi/atip/log/LogChannel 
.const [253] = Utf8 log 
.const [254] = Utf8 (ILjava/lang/String;Ljava/lang/Object;Ljava/lang/Object;J)V 
.const [255] = Utf8 java/util/Dictionary 
.const [256] = Utf8 put 
.const [257] = Utf8 (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object; 
.const [258] = Utf8 java/lang/String 
.const [259] = Utf8 lastIndexOf 
.const [260] = Utf8 (I)I 
.const [261] = Utf8 java/lang/String 
.const [262] = Utf8 substring 
.const [263] = Utf8 (I)Ljava/lang/String; 
.const [264] = Utf8 java/lang/NoClassDefFoundError 
.const [265] = Utf8 <init> 
.const [266] = Utf8 ()V 
.const [267] = Utf8 java/lang/Object 
.const [268] = Utf8 <init> 
.const [269] = Utf8 ()V 
.const [270] = Utf8 java/util/ArrayList 
.const [271] = Utf8 <init> 
.const [272] = Utf8 ()V 
.const [273] = Utf8 java/lang/IllegalArgumentException 
.const [274] = Utf8 <init> 
.const [275] = Utf8 ()V 
.const [276] = Utf8 de/audi/app/terminalmode/osgi/ServiceTrackerImpl 
.const [277] = Utf8 <init> 
.const [278] = Utf8 (Lorg/osgi/framework/BundleContext;Ljava/lang/Class;Lorg/osgi/util/tracker/ServiceTrackerCustomizer;)V 
.const [279] = Utf8 de/audi/app/terminalmode/osgi/ServiceManagerImpl 
.const [280] = Utf8 getClassnameWithoutPackage 
.const [281] = Utf8 (Ljava/lang/String;)Ljava/lang/String; 
.const [282] = Utf8 de/audi/app/terminalmode/osgi/ServiceManagerImpl$1 
.const [283] = Utf8 <init> 
.const [284] = Utf8 (Lde/audi/app/terminalmode/osgi/ServiceManagerImpl;Lorg/osgi/framework/ServiceRegistration;)V 
.const [285] = Utf8 java/util/Hashtable 
.const [286] = Utf8 <init> 
.const [287] = Utf8 (I)V 
.const [288] = Utf8 java/lang/Integer 
.const [289] = Utf8 <init> 
.const [290] = Utf8 (I)V 
.const [291] = Utf8 de/audi/app/terminalmode/osgi/ServiceManagerImpl 
.const [292] = Utf8 class$org$dsi$ifc$base$DSIListener 
.const [293] = Utf8 Ljava/lang/Class; 
.const [294] = Utf8 de/audi/app/terminalmode/osgi/ServiceManagerImpl 
.const [295] = Utf8 registerService 
.const [296] = Utf8 (Ljava/lang/Class;Ljava/lang/Object;Ljava/util/Dictionary;)Lorg/osgi/framework/ServiceRegistration; 
.const [297] = Utf8 de/audi/app/terminalmode/osgi/ServiceManagerImpl 
.const [298] = Utf8 registeredServices 
.const [299] = Utf8 Ljava/util/List; 
.const [300] = Utf8 de/audi/app/terminalmode/ITerminalLogger 
.const [301] = Utf8 osgi 
.const [302] = Utf8 ()Lde/audi/atip/log/LogChannel; 
.const [303] = Utf8 de/audi/app/terminalmode/osgi/ServiceManagerImpl 
.const [304] = Utf8 logger 
.const [305] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [306] = Utf8 de/audi/app/terminalmode/osgi/ServiceManagerImpl 
.const [307] = Utf8 osgiBundleContext 
.const [308] = Utf8 Lorg/osgi/framework/BundleContext; 
.const [309] = Utf8 de/audi/app/terminalmode/osgi/ServiceManagerImpl 
.const [310] = Utf8 framework 
.const [311] = Utf8 Lde/audi/atip/base/IFrameworkAccess; 
.const [312] = Utf8 de/audi/app/terminalmode/osgi/ServiceManagerImpl 
.const [313] = Utf8 loggingDecoratorFactory 
.const [314] = Utf8 Lde/audi/app/terminalmode/logging/ILoggingDecoratorFactory; 
.const [315] = Utf8 org/osgi/framework/BundleContext 
.const [316] = Utf8 getServiceReferences 
.const [317] = Utf8 (Ljava/lang/String;Ljava/lang/String;)[Lorg/osgi/framework/ServiceReference; 
.const [318] = Utf8 org/osgi/framework/BundleContext 
.const [319] = Utf8 registerService 
.const [320] = Utf8 (Ljava/lang/String;Ljava/lang/Object;Ljava/util/Dictionary;)Lorg/osgi/framework/ServiceRegistration; 
.const [321] = Utf8 java/util/List 
.const [322] = Utf8 add 
.const [323] = Utf8 (Ljava/lang/Object;)Z 
.const [324] = Utf8 org/osgi/framework/ServiceRegistration 
.const [325] = Utf8 unregister 
.const [326] = Utf8 ()V 
.const [327] = Utf8 de/audi/app/terminalmode/logging/ILoggingDecoratorFactory 
.const [328] = Utf8 wrap 
.const [329] = Utf8 (Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object; 
.const [330] = Utf8 org/osgi/framework/ServiceReference 
.const [331] = Utf8 getProperty 
.const [332] = Utf8 (Ljava/lang/String;)Ljava/lang/Object; 
.const [333] = Utf8 org/osgi/framework/BundleContext 
.const [334] = Utf8 getService 
.const [335] = Utf8 (Lorg/osgi/framework/ServiceReference;)Ljava/lang/Object; 
.const [336] = Utf8 org/osgi/framework/BundleContext 
.const [337] = Utf8 ungetService 
.const [338] = Utf8 (Lorg/osgi/framework/ServiceReference;)Z 
.const [339] = Utf8 de/audi/atip/base/IFrameworkAccess 
.const [340] = Utf8 startDSIService 
.const [341] = Utf8 (Ljava/lang/String;I)Z 
.const [342] = Utf8 java/util/List 
.const [343] = Utf8 iterator 
.const [344] = Utf8 ()Ljava/util/Iterator; 
.const [345] = Utf8 java/util/Iterator 
.const [346] = Utf8 hasNext 
.const [347] = Utf8 ()Z 
.const [348] = Utf8 java/util/Iterator 
.const [349] = Utf8 next 
.const [350] = Utf8 ()Ljava/lang/Object; 
.const [351] = Utf8 java/util/List 
.const [352] = Utf8 clear 
.const [353] = Utf8 ()V 
.const [354] = Utf8 de/audi/app/terminalmode/osgi/ServiceManagerImpl 
.const [355] = Class [354] 
.const [356] = Utf8 java/lang/Object 
.const [357] = Class [356] 
.const [358] = Utf8 de/audi/app/terminalmode/osgi/IServiceManager 
.const [359] = Class [358] 
.const [360] = Utf8 LOGCLASS 
.const [361] = Utf8 Ljava/lang/String; 
.const [362] = Utf8 osgiBundleContext 
.const [363] = Utf8 Lorg/osgi/framework/BundleContext; 
.const [364] = Utf8 framework 
.const [365] = Utf8 Lde/audi/atip/base/IFrameworkAccess; 
.const [366] = Utf8 logger 
.const [367] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [368] = Utf8 loggingDecoratorFactory 
.const [369] = Utf8 Lde/audi/app/terminalmode/logging/ILoggingDecoratorFactory; 
.const [370] = Utf8 registeredServices 
.const [371] = Utf8 Ljava/util/List; 
.const [372] = Utf8 class$org$dsi$ifc$base$DSIListener 
.const [373] = Utf8 Ljava/lang/Class; 
.const [374] = Utf8 Code 
.const [375] = Utf8 <init> 
.const [376] = Utf8 (Lorg/osgi/framework/BundleContext;Lde/audi/app/terminalmode/logging/TerminalModeLoggingDecoratorFactory;Lde/audi/atip/base/IFrameworkAccess;Lde/audi/app/terminalmode/ITerminalLogger;)V 
.const [377] = Utf8 createServiceTracker 
.const [378] = Utf8 (Ljava/lang/Class;Lorg/osgi/util/tracker/ServiceTrackerCustomizer;)Lde/audi/app/terminalmode/osgi/IServiceTracker; 
.const [379] = Utf8 getServiceReferences 
.const [380] = Utf8 (Ljava/lang/Class;)[Lorg/osgi/framework/ServiceReference; 
.const [381] = Utf8 registerService 
.const [382] = Utf8 (Ljava/lang/Class;Ljava/lang/Object;Ljava/util/Dictionary;)Lorg/osgi/framework/ServiceRegistration; 
.const [383] = Utf8 unregisterService 
.const [384] = Utf8 (Lorg/osgi/framework/ServiceRegistration;)V 
.const [385] = Utf8 registerDSIListener 
.const [386] = Utf8 (ILjava/lang/String;Lorg/dsi/ifc/base/DSIListener;)Lorg/osgi/framework/ServiceRegistration; 
.const [387] = Utf8 getService 
.const [388] = Utf8 (Lorg/osgi/framework/ServiceReference;)Ljava/lang/Object; 
.const [389] = Utf8 releaseService 
.const [390] = Utf8 (Lorg/osgi/framework/ServiceReference;)V 
.const [391] = Utf8 startDSIService 
.const [392] = Utf8 (Ljava/lang/String;I)Z 
.const [393] = Utf8 getClassnameWithoutPackage 
.const [394] = Utf8 (Ljava/lang/String;)Ljava/lang/String; 
.const [395] = Utf8 getFrameworkAccess 
.const [396] = Utf8 ()Lde/audi/atip/base/IFrameworkAccess; 
.const [397] = Utf8 getBundleContext 
.const [398] = Utf8 ()Lorg/osgi/framework/BundleContext; 
.const [399] = Utf8 cleanup 
.const [400] = Utf8 ()V 
.const [401] = Utf8 access$000 
.const [402] = Utf8 (Lde/audi/app/terminalmode/osgi/ServiceManagerImpl;)Ljava/util/List; 
.const [403] = Utf8 class$ 
.const [404] = Utf8 (Ljava/lang/String;)Ljava/lang/Class; 
.end class 
