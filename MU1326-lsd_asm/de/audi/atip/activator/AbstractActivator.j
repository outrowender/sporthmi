.version 50 0 
.class public super abstract [345] 
.super [347] 
.implements [349] 
.field private static final [350] [351] 
.field private static final [352] [353] 
.field private static final [354] [355] 
.field protected [356] [357] 
.field protected [358] [359] 
.field private [360] [361] 
.field static synthetic [362] [363] 

.method public [365] : [366] 
    .attribute [364] .code stack 3 locals 0 
L0:     aload_0 
L1:     invokespecial [49] 
L4:     aload_0 
L5:     aconst_null 
L6:     putfield [61] 
L9:     aload_0 
L10:    aconst_null 
L11:    putfield [62] 
L14:    aload_0 
L15:    new [63] 
L18:    dup 
L19:    invokespecial [50] 
L22:    putfield [64] 
L25:    return 
L26:    nop 
L27:    nop 
L28:    
    .end code 
.end method 

.method public [367] : [368] 
    .attribute [364] .code stack 4 locals 1 
L0:     aload_0 
L1:     aload_1 
L2:     putfield [61] 
L5:     aload_1 
L6:     getstatic [6] 
L9:     ifnonnull L24 
L12:    ldc [7] 
L14:    invokestatic [8] 
L17:    dup 
L18:    putstatic [51] 
L21:    goto L27 
L24:    getstatic [6] 
L27:    invokevirtual [39] 
L30:    invokeinterface [65] 0 
L35:    astore_2 
L36:    aload_2 
L37:    ifnull L54 
L40:    aload_0 
L41:    aload_1 
L42:    aload_2 
L43:    invokeinterface [66] 0 
L48:    checkcast [9] 
L51:    putfield [62] 
L54:    aload_0 
L55:    getfield [37] 
L58:    ifnonnull L96 
L61:    new [67] 
L64:    dup 
L65:    new [68] 
L68:    dup 
L69:    invokespecial [52] 
L72:    ldc [12] 
L74:    invokevirtual [40] 
L77:    aload_0 
L78:    invokevirtual [41] 
L81:    invokevirtual [40] 
L84:    ldc [13] 
L86:    invokevirtual [40] 
L89:    invokevirtual [42] 
L92:    invokespecial [53] 
L95:    athrow 
L96:    return 
L97:    nop 
L98:    nop 
L99:    nop 
L100:   
    .end code 
.end method 

.method private [369] : [370] 
    .attribute [364] .code stack 5 locals 1 
L0:     aload_1 
L1:     ifnull L43 
        .catch [14] from L4 to L10 using L13 
L4:     aload_1 
L5:     invokeinterface [69] 0 
L10:    goto L43 
L13:    astore_2 
L14:    aload_0 
L15:    getfield [37] 
L18:    ifnull L43 
L21:    aload_0 
L22:    getfield [37] 
L25:    ldc [15] 
L27:    invokeinterface [70] 0 
L32:    sipush 10000 
L35:    ldc [16] 
L37:    aload_1 
L38:    aload_2 
L39:    invokevirtual [43] 
L42:    pop 
L43:    return 
L44:    
    .end code 
.end method 

.method public [371] : [372] 
    .attribute [364] .code stack 4 locals 1 
L0:     aload_0 
L1:     getfield [38] 
L4:     invokeinterface [71] 0 
L9:     iconst_1 
L10:    isub 
L11:    istore_2 
L12:    iload_2 
L13:    iflt L50 
L16:    aload_0 
L17:    aload_0 
L18:    getfield [38] 
L21:    iload_2 
L22:    invokeinterface [72] 0 
L27:    checkcast [17] 
L30:    invokespecial [54] 
L33:    aload_0 
L34:    getfield [38] 
L37:    iload_2 
L38:    invokeinterface [73] 0 
L43:    pop 
L44:    iinc 2 -1 
L47:    goto L12 
L50:    aload_0 
L51:    getfield [37] 
L54:    ifnull L99 
L57:    aload_1 
L58:    aload_1 
L59:    getstatic [6] 
L62:    ifnonnull L77 
L65:    ldc [7] 
L67:    invokestatic [8] 
L70:    dup 
L71:    putstatic [51] 
L74:    goto L80 
L77:    getstatic [6] 
L80:    invokevirtual [39] 
L83:    invokeinterface [65] 0 
L88:    invokeinterface [74] 0 
L93:    pop 
L94:    aload_0 
L95:    aconst_null 
L96:    putfield [62] 
L99:    return 
L100:   
    .end code 
.end method 

.method public final interface [373] : [374] 
    .attribute [364] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [36] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public final interface [375] : [376] 
    .attribute [364] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [37] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [377] : [378] 
    .attribute [364] .code stack 2 locals 2 
        .catch [14] from L0 to L30 using L33 
L0:     aload_0 
L1:     getfield [36] 
L4:     invokeinterface [75] 0 
L9:     invokeinterface [76] 0 
L14:    ldc [18] 
L16:    invokevirtual [44] 
L19:    checkcast [19] 
L22:    astore_1 
L23:    aload_1 
L24:    ifnonnull L30 
L27:    ldc [20] 
L29:    astore_1 
L30:    goto L37 
L33:    astore_2 
L34:    ldc [20] 
L36:    astore_1 
L37:    aload_1 
L38:    areturn 
L39:    nop 
L40:    
    .end code 
.end method 

.method public [379] : [380] 
    .attribute [364] .code stack 5 locals 0 
L0:     aload_0 
L1:     getfield [38] 
L4:     aload_0 
L5:     getfield [36] 
L8:     aload_1 
L9:     aload_2 
L10:    aload_3 
L11:    invokeinterface [77] 0 
L16:    invokeinterface [78] 0 
L21:    pop 
L22:    return 
L23:    nop 
L24:    
    .end code 
.end method 

.method protected [381] : [382] 
    .attribute [364] .code stack 5 locals 0 
L0:     aload_0 
L1:     getfield [38] 
L4:     aload_0 
L5:     getfield [36] 
L8:     aload_1 
L9:     invokevirtual [39] 
L12:    aload_2 
L13:    getstatic [21] 
L16:    invokeinterface [77] 0 
L21:    invokeinterface [78] 0 
L26:    pop 
L27:    return 
L28:    
    .end code 
.end method 

.method public [383] : [384] 
    .attribute [364] .code stack 5 locals 0 
L0:     aload_0 
L1:     getfield [38] 
L4:     aload_0 
L5:     getfield [36] 
L8:     aload_1 
L9:     aload_2 
L10:    aload_3 
L11:    invokeinterface [79] 0 
L16:    invokeinterface [78] 0 
L21:    pop 
L22:    return 
L23:    nop 
L24:    
    .end code 
.end method 

.method public [385] : [386] 
    .attribute [364] .code stack 5 locals 1 
L0:     new [80] 
L3:     dup 
L4:     bipush 8 
L6:     invokespecial [56] 
L9:     astore 5 
L11:    aload 5 
L13:    ldc [23] 
L15:    aload_3 
L16:    invokevirtual [45] 
L19:    pop 
L20:    aload 5 
L22:    ldc [24] 
L24:    new [81] 
L27:    dup 
L28:    iload 4 
L30:    invokespecial [57] 
L33:    invokevirtual [45] 
L36:    pop 
L37:    aload_0 
L38:    getfield [38] 
L41:    aload_0 
L42:    getfield [36] 
L45:    aload_1 
L46:    aload_2 
L47:    aload 5 
L49:    invokeinterface [77] 0 
L54:    invokeinterface [78] 0 
L59:    pop 
L60:    return 
L61:    nop 
L62:    nop 
L63:    nop 
L64:    
    .end code 
.end method 

.method protected [387] : [388] 
    .attribute [364] .code stack 5 locals 1 
L0:     new [82] 
L3:     dup 
L4:     aload_0 
L5:     getfield [36] 
L8:     aload_1 
L9:     invokevirtual [39] 
L12:    aload_2 
L13:    invokespecial [58] 
L16:    astore_3 
L17:    aload_3 
L18:    invokevirtual [46] 
L21:    aload_3 
L22:    areturn 
L23:    nop 
L24:    
    .end code 
.end method 

.method public [389] : [390] 
    .attribute [364] .code stack 1 locals 0 
L0:     aload_1 
L1:     ifnull L8 
L4:     aload_1 
L5:     invokevirtual [47] 
L8:     aconst_null 
L9:     areturn 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method static synthetic [391] : [392] 
    .attribute [364] .code stack 2 locals 1 
        .catch [3] from L0 to L4 using L5 
L0:     aload_0 
L1:     invokestatic [2] 
L4:     areturn 
L5:     astore_1 
L6:     new [60] 
L9:     dup 
L10:    invokespecial [48] 
L13:    aload_1 
L14:    invokevirtual [35] 
L17:    athrow 
L18:    nop 
L19:    nop 
L20:    
    .end code 
.end method 

.method static [393] : [394] 
    .attribute [364] .code stack 2 locals 0 
L0:     new [80] 
L3:     dup 
L4:     invokespecial [59] 
L7:     putstatic [55] 
L10:    return 
L11:    nop 
L12:    
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
.const [10] = Class [94] 
.const [11] = Class [95] 
.const [12] = String [96] 
.const [13] = String [97] 
.const [14] = Class [98] 
.const [15] = String [99] 
.const [16] = String [100] 
.const [17] = Class [101] 
.const [18] = String [102] 
.const [19] = Class [103] 
.const [20] = String [104] 
.const [21] = Field [105] [106] 
.const [22] = Class [107] 
.const [23] = String [108] 
.const [24] = String [109] 
.const [25] = Class [110] 
.const [26] = Class [111] 
.const [27] = Class [112] 
.const [28] = Class [113] 
.const [29] = Class [114] 
.const [30] = Class [115] 
.const [31] = Class [116] 
.const [32] = Class [117] 
.const [33] = Class [118] 
.const [34] = Class [119] 
.const [35] = Method [120] [121] 
.const [36] = Field [122] [123] 
.const [37] = Field [124] [125] 
.const [38] = Field [126] [127] 
.const [39] = Method [128] [129] 
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
.const [51] = Field [152] [153] 
.const [52] = Method [154] [155] 
.const [53] = Method [156] [157] 
.const [54] = Method [158] [159] 
.const [55] = Field [160] [161] 
.const [56] = Method [162] [163] 
.const [57] = Method [164] [165] 
.const [58] = Method [166] [167] 
.const [59] = Method [168] [169] 
.const [60] = Class [170] 
.const [61] = Field [171] [172] 
.const [62] = Field [173] [174] 
.const [63] = Class [175] 
.const [64] = Field [176] [177] 
.const [65] = InterfaceMethod [178] [179] 
.const [66] = InterfaceMethod [180] [181] 
.const [67] = Class [182] 
.const [68] = Class [183] 
.const [69] = InterfaceMethod [184] [185] 
.const [70] = InterfaceMethod [186] [187] 
.const [71] = InterfaceMethod [188] [189] 
.const [72] = InterfaceMethod [190] [191] 
.const [73] = InterfaceMethod [192] [193] 
.const [74] = InterfaceMethod [194] [195] 
.const [75] = InterfaceMethod [196] [197] 
.const [76] = InterfaceMethod [198] [199] 
.const [77] = InterfaceMethod [200] [201] 
.const [78] = InterfaceMethod [202] [203] 
.const [79] = InterfaceMethod [204] [205] 
.const [80] = Class [206] 
.const [81] = Class [207] 
.const [82] = Class [208] 
.const [83] = Class [209] 
.const [84] = NameAndType [210] [211] 
.const [85] = Utf8 java/lang/ClassNotFoundException 
.const [86] = Utf8 java/lang/NoClassDefFoundError 
.const [87] = Utf8 java/util/LinkedList 
.const [88] = Class [212] 
.const [89] = NameAndType [213] [214] 
.const [90] = Utf8 'de.audi.atip.base.IFrameworkAccess' 
.const [91] = Class [215] 
.const [92] = NameAndType [216] [217] 
.const [93] = Utf8 de/audi/atip/base/IFrameworkAccess 
.const [94] = Utf8 de/audi/atip/activator/FrameworkException 
.const [95] = Utf8 java/lang/StringBuffer 
.const [96] = Utf8 'Framework service not available, starting of ' 
.const [97] = Utf8 ' aborted' 
.const [98] = Utf8 java/lang/Exception 
.const [99] = Utf8 'Fw.Startup' 
.const [100] = Utf8 'unregistering Service %1 failed!' 
.const [101] = Utf8 org/osgi/framework/ServiceRegistration 
.const [102] = Utf8 Bundle-Name 
.const [103] = Utf8 java/lang/String 
.const [104] = Utf8 '???' 
.const [105] = Class [218] 
.const [106] = NameAndType [219] [220] 
.const [107] = Utf8 java/util/Hashtable 
.const [108] = Utf8 DEVICE_NAME 
.const [109] = Utf8 DEVICE_INSTANCE 
.const [110] = Utf8 java/lang/Integer 
.const [111] = Utf8 org/osgi/util/tracker/ServiceTracker 
.const [112] = Utf8 de/audi/atip/activator/AbstractActivator 
.const [113] = Utf8 java/lang/Object 
.const [114] = Utf8 java/lang/Class 
.const [115] = Utf8 org/osgi/framework/BundleContext 
.const [116] = Utf8 de/audi/atip/log/LogChannel 
.const [117] = Utf8 java/util/List 
.const [118] = Utf8 org/osgi/framework/Bundle 
.const [119] = Utf8 java/util/Dictionary 
.const [120] = Class [221] 
.const [121] = NameAndType [222] [223] 
.const [122] = Class [224] 
.const [123] = NameAndType [225] [226] 
.const [124] = Class [227] 
.const [125] = NameAndType [228] [229] 
.const [126] = Class [230] 
.const [127] = NameAndType [231] [232] 
.const [128] = Class [233] 
.const [129] = NameAndType [234] [235] 
.const [130] = Class [236] 
.const [131] = NameAndType [237] [238] 
.const [132] = Class [239] 
.const [133] = NameAndType [240] [241] 
.const [134] = Class [242] 
.const [135] = NameAndType [243] [244] 
.const [136] = Class [245] 
.const [137] = NameAndType [246] [247] 
.const [138] = Class [248] 
.const [139] = NameAndType [249] [250] 
.const [140] = Class [251] 
.const [141] = NameAndType [252] [253] 
.const [142] = Class [254] 
.const [143] = NameAndType [255] [256] 
.const [144] = Class [257] 
.const [145] = NameAndType [258] [259] 
.const [146] = Class [260] 
.const [147] = NameAndType [261] [262] 
.const [148] = Class [263] 
.const [149] = NameAndType [264] [265] 
.const [150] = Class [266] 
.const [151] = NameAndType [267] [268] 
.const [152] = Class [269] 
.const [153] = NameAndType [270] [271] 
.const [154] = Class [272] 
.const [155] = NameAndType [273] [274] 
.const [156] = Class [275] 
.const [157] = NameAndType [276] [277] 
.const [158] = Class [278] 
.const [159] = NameAndType [279] [280] 
.const [160] = Class [281] 
.const [161] = NameAndType [282] [283] 
.const [162] = Class [284] 
.const [163] = NameAndType [285] [286] 
.const [164] = Class [287] 
.const [165] = NameAndType [288] [289] 
.const [166] = Class [290] 
.const [167] = NameAndType [291] [292] 
.const [168] = Class [293] 
.const [169] = NameAndType [294] [295] 
.const [170] = Utf8 java/lang/NoClassDefFoundError 
.const [171] = Class [296] 
.const [172] = NameAndType [297] [298] 
.const [173] = Class [299] 
.const [174] = NameAndType [300] [301] 
.const [175] = Utf8 java/util/LinkedList 
.const [176] = Class [302] 
.const [177] = NameAndType [303] [304] 
.const [178] = Class [305] 
.const [179] = NameAndType [306] [307] 
.const [180] = Class [308] 
.const [181] = NameAndType [309] [310] 
.const [182] = Utf8 de/audi/atip/activator/FrameworkException 
.const [183] = Utf8 java/lang/StringBuffer 
.const [184] = Class [311] 
.const [185] = NameAndType [312] [313] 
.const [186] = Class [314] 
.const [187] = NameAndType [315] [316] 
.const [188] = Class [317] 
.const [189] = NameAndType [318] [319] 
.const [190] = Class [320] 
.const [191] = NameAndType [321] [322] 
.const [192] = Class [323] 
.const [193] = NameAndType [324] [325] 
.const [194] = Class [326] 
.const [195] = NameAndType [327] [328] 
.const [196] = Class [329] 
.const [197] = NameAndType [330] [331] 
.const [198] = Class [332] 
.const [199] = NameAndType [333] [334] 
.const [200] = Class [335] 
.const [201] = NameAndType [336] [337] 
.const [202] = Class [338] 
.const [203] = NameAndType [339] [340] 
.const [204] = Class [341] 
.const [205] = NameAndType [342] [343] 
.const [206] = Utf8 java/util/Hashtable 
.const [207] = Utf8 java/lang/Integer 
.const [208] = Utf8 org/osgi/util/tracker/ServiceTracker 
.const [209] = Utf8 java/lang/Class 
.const [210] = Utf8 forName 
.const [211] = Utf8 (Ljava/lang/String;)Ljava/lang/Class; 
.const [212] = Utf8 de/audi/atip/activator/AbstractActivator 
.const [213] = Utf8 class$de$audi$atip$base$IFrameworkAccess 
.const [214] = Utf8 Ljava/lang/Class; 
.const [215] = Utf8 de/audi/atip/activator/AbstractActivator 
.const [216] = Utf8 class$ 
.const [217] = Utf8 (Ljava/lang/String;)Ljava/lang/Class; 
.const [218] = Utf8 de/audi/atip/activator/AbstractActivator 
.const [219] = Utf8 EMPTY_DICTIONARY 
.const [220] = Utf8 Ljava/util/Dictionary; 
.const [221] = Utf8 java/lang/NoClassDefFoundError 
.const [222] = Utf8 initCause 
.const [223] = Utf8 (Ljava/lang/Throwable;)Ljava/lang/Throwable; 
.const [224] = Utf8 de/audi/atip/activator/AbstractActivator 
.const [225] = Utf8 bundleContext 
.const [226] = Utf8 Lorg/osgi/framework/BundleContext; 
.const [227] = Utf8 de/audi/atip/activator/AbstractActivator 
.const [228] = Utf8 framework 
.const [229] = Utf8 Lde/audi/atip/base/IFrameworkAccess; 
.const [230] = Utf8 de/audi/atip/activator/AbstractActivator 
.const [231] = Utf8 serviceRegistrations 
.const [232] = Utf8 Ljava/util/List; 
.const [233] = Utf8 java/lang/Class 
.const [234] = Utf8 getName 
.const [235] = Utf8 ()Ljava/lang/String; 
.const [236] = Utf8 java/lang/StringBuffer 
.const [237] = Utf8 append 
.const [238] = Utf8 (Ljava/lang/String;)Ljava/lang/StringBuffer; 
.const [239] = Utf8 de/audi/atip/activator/AbstractActivator 
.const [240] = Utf8 getName 
.const [241] = Utf8 ()Ljava/lang/String; 
.const [242] = Utf8 java/lang/StringBuffer 
.const [243] = Utf8 toString 
.const [244] = Utf8 ()Ljava/lang/String; 
.const [245] = Utf8 de/audi/atip/log/LogChannel 
.const [246] = Utf8 log 
.const [247] = Utf8 (ILjava/lang/String;Ljava/lang/Object;Ljava/lang/Throwable;)Z 
.const [248] = Utf8 java/util/Dictionary 
.const [249] = Utf8 get 
.const [250] = Utf8 (Ljava/lang/Object;)Ljava/lang/Object; 
.const [251] = Utf8 java/util/Hashtable 
.const [252] = Utf8 put 
.const [253] = Utf8 (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object; 
.const [254] = Utf8 org/osgi/util/tracker/ServiceTracker 
.const [255] = Utf8 'open' 
.const [256] = Utf8 ()V 
.const [257] = Utf8 org/osgi/util/tracker/ServiceTracker 
.const [258] = Utf8 close 
.const [259] = Utf8 ()V 
.const [260] = Utf8 java/lang/NoClassDefFoundError 
.const [261] = Utf8 <init> 
.const [262] = Utf8 ()V 
.const [263] = Utf8 java/lang/Object 
.const [264] = Utf8 <init> 
.const [265] = Utf8 ()V 
.const [266] = Utf8 java/util/LinkedList 
.const [267] = Utf8 <init> 
.const [268] = Utf8 ()V 
.const [269] = Utf8 de/audi/atip/activator/AbstractActivator 
.const [270] = Utf8 class$de$audi$atip$base$IFrameworkAccess 
.const [271] = Utf8 Ljava/lang/Class; 
.const [272] = Utf8 java/lang/StringBuffer 
.const [273] = Utf8 <init> 
.const [274] = Utf8 ()V 
.const [275] = Utf8 de/audi/atip/activator/FrameworkException 
.const [276] = Utf8 <init> 
.const [277] = Utf8 (Ljava/lang/String;)V 
.const [278] = Utf8 de/audi/atip/activator/AbstractActivator 
.const [279] = Utf8 removeService 
.const [280] = Utf8 (Lorg/osgi/framework/ServiceRegistration;)V 
.const [281] = Utf8 de/audi/atip/activator/AbstractActivator 
.const [282] = Utf8 EMPTY_DICTIONARY 
.const [283] = Utf8 Ljava/util/Dictionary; 
.const [284] = Utf8 java/util/Hashtable 
.const [285] = Utf8 <init> 
.const [286] = Utf8 (I)V 
.const [287] = Utf8 java/lang/Integer 
.const [288] = Utf8 <init> 
.const [289] = Utf8 (I)V 
.const [290] = Utf8 org/osgi/util/tracker/ServiceTracker 
.const [291] = Utf8 <init> 
.const [292] = Utf8 (Lorg/osgi/framework/BundleContext;Ljava/lang/String;Lorg/osgi/util/tracker/ServiceTrackerCustomizer;)V 
.const [293] = Utf8 java/util/Hashtable 
.const [294] = Utf8 <init> 
.const [295] = Utf8 ()V 
.const [296] = Utf8 de/audi/atip/activator/AbstractActivator 
.const [297] = Utf8 bundleContext 
.const [298] = Utf8 Lorg/osgi/framework/BundleContext; 
.const [299] = Utf8 de/audi/atip/activator/AbstractActivator 
.const [300] = Utf8 framework 
.const [301] = Utf8 Lde/audi/atip/base/IFrameworkAccess; 
.const [302] = Utf8 de/audi/atip/activator/AbstractActivator 
.const [303] = Utf8 serviceRegistrations 
.const [304] = Utf8 Ljava/util/List; 
.const [305] = Utf8 org/osgi/framework/BundleContext 
.const [306] = Utf8 getServiceReference 
.const [307] = Utf8 (Ljava/lang/String;)Lorg/osgi/framework/ServiceReference; 
.const [308] = Utf8 org/osgi/framework/BundleContext 
.const [309] = Utf8 getService 
.const [310] = Utf8 (Lorg/osgi/framework/ServiceReference;)Ljava/lang/Object; 
.const [311] = Utf8 org/osgi/framework/ServiceRegistration 
.const [312] = Utf8 unregister 
.const [313] = Utf8 ()V 
.const [314] = Utf8 de/audi/atip/base/IFrameworkAccess 
.const [315] = Utf8 getLogChannel 
.const [316] = Utf8 (Ljava/lang/String;)Lde/audi/atip/log/LogChannel; 
.const [317] = Utf8 java/util/List 
.const [318] = Utf8 size 
.const [319] = Utf8 ()I 
.const [320] = Utf8 java/util/List 
.const [321] = Utf8 get 
.const [322] = Utf8 (I)Ljava/lang/Object; 
.const [323] = Utf8 java/util/List 
.const [324] = Utf8 remove 
.const [325] = Utf8 (I)Ljava/lang/Object; 
.const [326] = Utf8 org/osgi/framework/BundleContext 
.const [327] = Utf8 ungetService 
.const [328] = Utf8 (Lorg/osgi/framework/ServiceReference;)Z 
.const [329] = Utf8 org/osgi/framework/BundleContext 
.const [330] = Utf8 getBundle 
.const [331] = Utf8 ()Lorg/osgi/framework/Bundle; 
.const [332] = Utf8 org/osgi/framework/Bundle 
.const [333] = Utf8 getHeaders 
.const [334] = Utf8 ()Ljava/util/Dictionary; 
.const [335] = Utf8 org/osgi/framework/BundleContext 
.const [336] = Utf8 registerService 
.const [337] = Utf8 (Ljava/lang/String;Ljava/lang/Object;Ljava/util/Dictionary;)Lorg/osgi/framework/ServiceRegistration; 
.const [338] = Utf8 java/util/List 
.const [339] = Utf8 add 
.const [340] = Utf8 (Ljava/lang/Object;)Z 
.const [341] = Utf8 org/osgi/framework/BundleContext 
.const [342] = Utf8 registerService 
.const [343] = Utf8 ([Ljava/lang/String;Ljava/lang/Object;Ljava/util/Dictionary;)Lorg/osgi/framework/ServiceRegistration; 
.const [344] = Utf8 de/audi/atip/activator/AbstractActivator 
.const [345] = Class [344] 
.const [346] = Utf8 java/lang/Object 
.const [347] = Class [346] 
.const [348] = Utf8 org/osgi/framework/BundleActivator 
.const [349] = Class [348] 
.const [350] = Utf8 MNFST_HDR_BUNDLE_NAME 
.const [351] = Utf8 Ljava/lang/String; 
.const [352] = Utf8 BUNDLE_NAME_UNKNOWN 
.const [353] = Utf8 Ljava/lang/String; 
.const [354] = Utf8 EMPTY_DICTIONARY 
.const [355] = Utf8 Ljava/util/Dictionary; 
.const [356] = Utf8 bundleContext 
.const [357] = Utf8 Lorg/osgi/framework/BundleContext; 
.const [358] = Utf8 framework 
.const [359] = Utf8 Lde/audi/atip/base/IFrameworkAccess; 
.const [360] = Utf8 serviceRegistrations 
.const [361] = Utf8 Ljava/util/List; 
.const [362] = Utf8 class$de$audi$atip$base$IFrameworkAccess 
.const [363] = Utf8 Ljava/lang/Class; 
.const [364] = Utf8 Code 
.const [365] = Utf8 <init> 
.const [366] = Utf8 ()V 
.const [367] = Utf8 start 
.const [368] = Utf8 (Lorg/osgi/framework/BundleContext;)V 
.const [369] = Utf8 removeService 
.const [370] = Utf8 (Lorg/osgi/framework/ServiceRegistration;)V 
.const [371] = Utf8 stop 
.const [372] = Utf8 (Lorg/osgi/framework/BundleContext;)V 
.const [373] = Utf8 getBundleContext 
.const [374] = Utf8 ()Lorg/osgi/framework/BundleContext; 
.const [375] = Utf8 getFramework 
.const [376] = Utf8 ()Lde/audi/atip/base/IFrameworkAccess; 
.const [377] = Utf8 getName 
.const [378] = Utf8 ()Ljava/lang/String; 
.const [379] = Utf8 registerService 
.const [380] = Utf8 (Ljava/lang/String;Ljava/lang/Object;Ljava/util/Dictionary;)V 
.const [381] = Utf8 registerService 
.const [382] = Utf8 (Ljava/lang/Class;Ljava/lang/Object;)V 
.const [383] = Utf8 registerService 
.const [384] = Utf8 ([Ljava/lang/String;Ljava/lang/Object;Ljava/util/Dictionary;)V 
.const [385] = Utf8 registerDSIListener 
.const [386] = Utf8 (Ljava/lang/String;Ljava/lang/Object;Ljava/lang/String;I)V 
.const [387] = Utf8 openTracker 
.const [388] = Utf8 (Ljava/lang/Class;Lorg/osgi/util/tracker/ServiceTrackerCustomizer;)Lorg/osgi/util/tracker/ServiceTracker; 
.const [389] = Utf8 closeTracker 
.const [390] = Utf8 (Lorg/osgi/util/tracker/ServiceTracker;)Lorg/osgi/util/tracker/ServiceTracker; 
.const [391] = Utf8 class$ 
.const [392] = Utf8 (Ljava/lang/String;)Ljava/lang/Class; 
.const [393] = Utf8 <clinit> 
.const [394] = Utf8 ()V 
.end class 
