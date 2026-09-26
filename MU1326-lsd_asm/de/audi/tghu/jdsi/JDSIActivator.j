.version 50 0 
.class public final super [317] 
.super [319] 
.field private [320] [321] 
.field private [322] [323] 
.field private [324] [325] 
.field private [326] [327] 
.field private [328] [329] 
.field static synthetic [330] [331] 

.method public [333] : [334] 
    .attribute [332] .code stack 2 locals 0 
L0:     aload_0 
L1:     ldc [5] 
L3:     invokespecial [48] 
L6:     return 
L7:     nop 
L8:     
    .end code 
.end method 

.method public interface [335] : [336] 
    .attribute [332] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [32] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [337] : [338] 
    .attribute [332] .code stack 8 locals 0 
L0:     aload_0 
L1:     new [63] 
L4:     dup 
L5:     aload_0 
L6:     getfield [31] 
L9:     getstatic [7] 
L12:    ifnonnull L27 
L15:    ldc [8] 
L17:    invokestatic [9] 
L20:    dup 
L21:    putstatic [49] 
L24:    goto L30 
L27:    getstatic [7] 
L30:    invokevirtual [35] 
L33:    new [64] 
L36:    dup 
L37:    aload_0 
L38:    invokespecial [50] 
L41:    invokespecial [51] 
L44:    putfield [65] 
L47:    aload_0 
L48:    getfield [36] 
L51:    invokevirtual [37] 
L54:    return 
L55:    nop 
L56:    
    .end code 
.end method 

.method private [339] : [340] 
    .attribute [332] .code stack 4 locals 2 
L0:     aconst_null 
L1:     astore_1 
        .catch [12] from L2 to L14 using L17 
L2:     aload_0 
L3:     invokevirtual [29] 
L6:     ldc [11] 
L8:     invokeinterface [66] 0 
L13:    astore_1 
L14:    goto L34 
L17:    astore_2 
L18:    aload_0 
L19:    getfield [30] 
L22:    sipush 10000 
L25:    ldc [13] 
L27:    aload_2 
L28:    invokevirtual [38] 
L31:    pop 
L32:    aconst_null 
L33:    astore_1 
L34:    aload_1 
L35:    areturn 
L36:    
    .end code 
.end method 

.method private [341] : [342] 
    .attribute [332] .code stack 2 locals 2 
L0:     aload_1 
L1:     ldc [14] 
L3:     invokeinterface [67] 0 
L8:     astore_2 
L9:     aload_2 
L10:    ifnull L41 
L13:    aload_2 
L14:    instanceof [15] 
L17:    ifeq L31 
L20:    aload_2 
L21:    checkcast [15] 
L24:    invokevirtual [39] 
L27:    istore_3 
L28:    goto L39 
L31:    aload_2 
L32:    checkcast [16] 
L35:    invokestatic [17] 
L38:    istore_3 
L39:    iload_3 
L40:    areturn 
L41:    iconst_0 
L42:    areturn 
L43:    nop 
L44:    
    .end code 
.end method 

.method private [343] : [344] 
    .attribute [332] .code stack 2 locals 0 
L0:     aload_1 
L1:     ldc [18] 
L3:     invokeinterface [67] 0 
L8:     checkcast [16] 
L11:    areturn 
L12:    
    .end code 
.end method 

.method private [345] : [346] 
    .attribute [332] .code stack 9 locals 0 
L0:     aload_0 
L1:     new [63] 
L4:     dup 
L5:     aload_0 
L6:     invokevirtual [29] 
L9:     aload_0 
L10:    invokespecial [52] 
L13:    new [68] 
L16:    dup 
L17:    aload_0 
L18:    aload_1 
L19:    invokespecial [53] 
L22:    invokespecial [54] 
L25:    putfield [69] 
L28:    aload_0 
L29:    getfield [40] 
L32:    invokevirtual [37] 
L35:    return 
L36:    
    .end code 
.end method 

.method private [347] : [348] 
    .attribute [332] .code stack 2 locals 0 
L0:     aload_0 
L1:     getfield [32] 
L4:     ifnull L20 
L7:     aload_0 
L8:     getfield [32] 
L11:    aconst_null 
L12:    invokevirtual [41] 
L15:    aload_0 
L16:    aconst_null 
L17:    putfield [60] 
L20:    aload_0 
L21:    getfield [33] 
L24:    ifnull L46 
L27:    aload_0 
L28:    invokevirtual [29] 
L31:    aload_0 
L32:    getfield [33] 
L35:    invokeinterface [70] 0 
L40:    pop 
L41:    aload_0 
L42:    aconst_null 
L43:    putfield [61] 
L46:    aload_0 
L47:    getfield [36] 
L50:    ifnull L65 
L53:    aload_0 
L54:    getfield [36] 
L57:    invokevirtual [42] 
L60:    aload_0 
L61:    aconst_null 
L62:    putfield [65] 
L65:    aload_0 
L66:    getfield [40] 
L69:    ifnull L84 
L72:    aload_0 
L73:    getfield [40] 
L76:    invokevirtual [42] 
L79:    aload_0 
L80:    aconst_null 
L81:    putfield [69] 
L84:    return 
L85:    nop 
L86:    nop 
L87:    nop 
L88:    
    .end code 
.end method 

.method protected [349] : [350] 
    .attribute [332] .code stack 4 locals 0 
L0:     aload_0 
L1:     aload_0 
L2:     invokevirtual [43] 
L5:     ldc [20] 
L7:     invokeinterface [71] 0 
L12:    putfield [59] 
L15:    aload_0 
L16:    new [72] 
L19:    dup 
L20:    aload_0 
L21:    invokevirtual [43] 
L24:    invokespecial [55] 
L27:    putfield [60] 
L30:    aload_0 
L31:    invokevirtual [44] 
L34:    aload_0 
L35:    aload_0 
L36:    getfield [32] 
L39:    invokespecial [56] 
L42:    return 
L43:    nop 
L44:    
    .end code 
.end method 

.method public [351] : [352] 
    .attribute [332] .code stack 2 locals 0 
L0:     aload_0 
L1:     invokespecial [57] 
L4:     aload_0 
L5:     aload_1 
L6:     invokespecial [58] 
L9:     return 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method static synthetic [353] : [354] 
    .attribute [332] .code stack 2 locals 1 
        .catch [3] from L0 to L4 using L5 
L0:     aload_0 
L1:     invokestatic [2] 
L4:     areturn 
L5:     astore_1 
L6:     new [62] 
L9:     dup 
L10:    invokespecial [47] 
L13:    aload_1 
L14:    invokevirtual [34] 
L17:    athrow 
L18:    nop 
L19:    nop 
L20:    
    .end code 
.end method 

.method static synthetic [355] : [356] 
    .attribute [332] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [31] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method static synthetic [357] : [358] 
    .attribute [332] .code stack 3 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     dup_x1 
L3:     putfield [61] 
L6:     areturn 
L7:     nop 
L8:     
    .end code 
.end method 

.method static synthetic [359] : [360] 
    .attribute [332] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [32] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method static synthetic [361] : [362] 
    .attribute [332] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [31] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method static synthetic [363] : [364] 
    .attribute [332] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [31] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method static synthetic [365] : [366] 
    .attribute [332] .code stack 1 locals 0 
L0:     aload_0 
L1:     invokevirtual [29] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method static synthetic [367] : [368] 
    .attribute [332] .code stack 2 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     invokespecial [46] 
L5:     areturn 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method static synthetic [369] : [370] 
    .attribute [332] .code stack 2 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     invokespecial [45] 
L5:     areturn 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method static synthetic [371] : [372] 
    .attribute [332] .code stack 1 locals 0 
L0:     aload_0 
L1:     invokevirtual [29] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method static synthetic [373] : [374] 
    .attribute [332] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [30] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method static synthetic [375] : [376] 
    .attribute [332] .code stack 1 locals 0 
L0:     aload_0 
L1:     invokevirtual [29] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method static synthetic [377] : [378] 
    .attribute [332] .code stack 1 locals 0 
L0:     aload_0 
L1:     invokevirtual [29] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Method [73] [74] 
.const [3] = Class [75] 
.const [4] = Class [76] 
.const [5] = String [77] 
.const [6] = Class [78] 
.const [7] = Field [79] [80] 
.const [8] = String [81] 
.const [9] = Method [82] [83] 
.const [10] = Class [84] 
.const [11] = String [85] 
.const [12] = Class [86] 
.const [13] = String [87] 
.const [14] = String [88] 
.const [15] = Class [89] 
.const [16] = Class [90] 
.const [17] = Method [91] [92] 
.const [18] = String [93] 
.const [19] = Class [94] 
.const [20] = String [95] 
.const [21] = Class [96] 
.const [22] = Class [97] 
.const [23] = Class [98] 
.const [24] = Class [99] 
.const [25] = Class [100] 
.const [26] = Class [101] 
.const [27] = Class [102] 
.const [28] = Class [103] 
.const [29] = Method [104] [105] 
.const [30] = Field [106] [107] 
.const [31] = Field [108] [109] 
.const [32] = Field [110] [111] 
.const [33] = Field [112] [113] 
.const [34] = Method [114] [115] 
.const [35] = Method [116] [117] 
.const [36] = Field [118] [119] 
.const [37] = Method [120] [121] 
.const [38] = Method [122] [123] 
.const [39] = Method [124] [125] 
.const [40] = Field [126] [127] 
.const [41] = Method [128] [129] 
.const [42] = Method [130] [131] 
.const [43] = Method [132] [133] 
.const [44] = Method [134] [135] 
.const [45] = Method [136] [137] 
.const [46] = Method [138] [139] 
.const [47] = Method [140] [141] 
.const [48] = Method [142] [143] 
.const [49] = Field [144] [145] 
.const [50] = Method [146] [147] 
.const [51] = Method [148] [149] 
.const [52] = Method [150] [151] 
.const [53] = Method [152] [153] 
.const [54] = Method [154] [155] 
.const [55] = Method [156] [157] 
.const [56] = Method [158] [159] 
.const [57] = Method [160] [161] 
.const [58] = Method [162] [163] 
.const [59] = Field [164] [165] 
.const [60] = Field [166] [167] 
.const [61] = Field [168] [169] 
.const [62] = Class [170] 
.const [63] = Class [171] 
.const [64] = Class [172] 
.const [65] = Field [173] [174] 
.const [66] = InterfaceMethod [175] [176] 
.const [67] = InterfaceMethod [177] [178] 
.const [68] = Class [179] 
.const [69] = Field [180] [181] 
.const [70] = InterfaceMethod [182] [183] 
.const [71] = InterfaceMethod [184] [185] 
.const [72] = Class [186] 
.const [73] = Class [187] 
.const [74] = NameAndType [188] [189] 
.const [75] = Utf8 java/lang/ClassNotFoundException 
.const [76] = Utf8 java/lang/NoClassDefFoundError 
.const [77] = Utf8 JDSIAdmin 
.const [78] = Utf8 org/osgi/util/tracker/ServiceTracker 
.const [79] = Class [190] 
.const [80] = NameAndType [191] [192] 
.const [81] = Utf8 'org.dsi.ifc.base.ServiceAdmin' 
.const [82] = Class [193] 
.const [83] = NameAndType [194] [195] 
.const [84] = Utf8 de/audi/tghu/jdsi/JDSIActivator$1 
.const [85] = Utf8 '(&(objectClass=org.dsi.ifc.*) (!(objectClass=*Listener)))' 
.const [86] = Utf8 org/osgi/framework/InvalidSyntaxException 
.const [87] = Utf8 'JDSIManager.getDSIFilter() invalid syntax!' 
.const [88] = Utf8 DEVICE_INSTANCE 
.const [89] = Utf8 java/lang/Integer 
.const [90] = Utf8 java/lang/String 
.const [91] = Class [196] 
.const [92] = NameAndType [197] [198] 
.const [93] = Utf8 DEVICE_NAME 
.const [94] = Utf8 de/audi/tghu/jdsi/JDSIActivator$2 
.const [95] = Utf8 'Fw.JDSI.Admin' 
.const [96] = Utf8 de/audi/tghu/jdsi/JDSIManager 
.const [97] = Utf8 de/audi/tghu/jdsi/JDSIActivator 
.const [98] = Utf8 de/audi/atip/activator/AbstractFrameworkActivator 
.const [99] = Utf8 java/lang/Class 
.const [100] = Utf8 org/osgi/framework/BundleContext 
.const [101] = Utf8 de/audi/atip/log/LogChannel 
.const [102] = Utf8 org/osgi/framework/ServiceReference 
.const [103] = Utf8 de/audi/atip/base/IFrameworkAccess 
.const [104] = Class [199] 
.const [105] = NameAndType [200] [201] 
.const [106] = Class [202] 
.const [107] = NameAndType [203] [204] 
.const [108] = Class [205] 
.const [109] = NameAndType [206] [207] 
.const [110] = Class [208] 
.const [111] = NameAndType [209] [210] 
.const [112] = Class [211] 
.const [113] = NameAndType [212] [213] 
.const [114] = Class [214] 
.const [115] = NameAndType [215] [216] 
.const [116] = Class [217] 
.const [117] = NameAndType [218] [219] 
.const [118] = Class [220] 
.const [119] = NameAndType [221] [222] 
.const [120] = Class [223] 
.const [121] = NameAndType [224] [225] 
.const [122] = Class [226] 
.const [123] = NameAndType [227] [228] 
.const [124] = Class [229] 
.const [125] = NameAndType [230] [231] 
.const [126] = Class [232] 
.const [127] = NameAndType [233] [234] 
.const [128] = Class [235] 
.const [129] = NameAndType [236] [237] 
.const [130] = Class [238] 
.const [131] = NameAndType [239] [240] 
.const [132] = Class [241] 
.const [133] = NameAndType [242] [243] 
.const [134] = Class [244] 
.const [135] = NameAndType [245] [246] 
.const [136] = Class [247] 
.const [137] = NameAndType [248] [249] 
.const [138] = Class [250] 
.const [139] = NameAndType [251] [252] 
.const [140] = Class [253] 
.const [141] = NameAndType [254] [255] 
.const [142] = Class [256] 
.const [143] = NameAndType [257] [258] 
.const [144] = Class [259] 
.const [145] = NameAndType [260] [261] 
.const [146] = Class [262] 
.const [147] = NameAndType [263] [264] 
.const [148] = Class [265] 
.const [149] = NameAndType [266] [267] 
.const [150] = Class [268] 
.const [151] = NameAndType [269] [270] 
.const [152] = Class [271] 
.const [153] = NameAndType [272] [273] 
.const [154] = Class [274] 
.const [155] = NameAndType [275] [276] 
.const [156] = Class [277] 
.const [157] = NameAndType [278] [279] 
.const [158] = Class [280] 
.const [159] = NameAndType [281] [282] 
.const [160] = Class [283] 
.const [161] = NameAndType [284] [285] 
.const [162] = Class [286] 
.const [163] = NameAndType [287] [288] 
.const [164] = Class [289] 
.const [165] = NameAndType [290] [291] 
.const [166] = Class [292] 
.const [167] = NameAndType [293] [294] 
.const [168] = Class [295] 
.const [169] = NameAndType [296] [297] 
.const [170] = Utf8 java/lang/NoClassDefFoundError 
.const [171] = Utf8 org/osgi/util/tracker/ServiceTracker 
.const [172] = Utf8 de/audi/tghu/jdsi/JDSIActivator$1 
.const [173] = Class [298] 
.const [174] = NameAndType [299] [300] 
.const [175] = Class [301] 
.const [176] = NameAndType [302] [303] 
.const [177] = Class [304] 
.const [178] = NameAndType [305] [306] 
.const [179] = Utf8 de/audi/tghu/jdsi/JDSIActivator$2 
.const [180] = Class [307] 
.const [181] = NameAndType [308] [309] 
.const [182] = Class [310] 
.const [183] = NameAndType [311] [312] 
.const [184] = Class [313] 
.const [185] = NameAndType [314] [315] 
.const [186] = Utf8 de/audi/tghu/jdsi/JDSIManager 
.const [187] = Utf8 java/lang/Class 
.const [188] = Utf8 forName 
.const [189] = Utf8 (Ljava/lang/String;)Ljava/lang/Class; 
.const [190] = Utf8 de/audi/tghu/jdsi/JDSIActivator 
.const [191] = Utf8 class$org$dsi$ifc$base$ServiceAdmin 
.const [192] = Utf8 Ljava/lang/Class; 
.const [193] = Utf8 de/audi/tghu/jdsi/JDSIActivator 
.const [194] = Utf8 class$ 
.const [195] = Utf8 (Ljava/lang/String;)Ljava/lang/Class; 
.const [196] = Utf8 java/lang/Integer 
.const [197] = Utf8 parseInt 
.const [198] = Utf8 (Ljava/lang/String;)I 
.const [199] = Utf8 de/audi/tghu/jdsi/JDSIActivator 
.const [200] = Utf8 getBundleContext 
.const [201] = Utf8 ()Lorg/osgi/framework/BundleContext; 
.const [202] = Utf8 de/audi/tghu/jdsi/JDSIActivator 
.const [203] = Utf8 lc 
.const [204] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [205] = Utf8 de/audi/tghu/jdsi/JDSIActivator 
.const [206] = Utf8 bundleContext 
.const [207] = Utf8 Lorg/osgi/framework/BundleContext; 
.const [208] = Utf8 de/audi/tghu/jdsi/JDSIActivator 
.const [209] = Utf8 service 
.const [210] = Utf8 Lde/audi/tghu/jdsi/JDSIManager; 
.const [211] = Utf8 de/audi/tghu/jdsi/JDSIActivator 
.const [212] = Utf8 serviceAdminReference 
.const [213] = Utf8 Lorg/osgi/framework/ServiceReference; 
.const [214] = Utf8 java/lang/NoClassDefFoundError 
.const [215] = Utf8 initCause 
.const [216] = Utf8 (Ljava/lang/Throwable;)Ljava/lang/Throwable; 
.const [217] = Utf8 java/lang/Class 
.const [218] = Utf8 getName 
.const [219] = Utf8 ()Ljava/lang/String; 
.const [220] = Utf8 de/audi/tghu/jdsi/JDSIActivator 
.const [221] = Utf8 serviceAdminTracker 
.const [222] = Utf8 Lorg/osgi/util/tracker/ServiceTracker; 
.const [223] = Utf8 org/osgi/util/tracker/ServiceTracker 
.const [224] = Utf8 'open' 
.const [225] = Utf8 ()V 
.const [226] = Utf8 de/audi/atip/log/LogChannel 
.const [227] = Utf8 log 
.const [228] = Utf8 (ILjava/lang/String;Ljava/lang/Throwable;)Z 
.const [229] = Utf8 java/lang/Integer 
.const [230] = Utf8 intValue 
.const [231] = Utf8 ()I 
.const [232] = Utf8 de/audi/tghu/jdsi/JDSIActivator 
.const [233] = Utf8 dsiTracker 
.const [234] = Utf8 Lorg/osgi/util/tracker/ServiceTracker; 
.const [235] = Utf8 de/audi/tghu/jdsi/JDSIManager 
.const [236] = Utf8 setServiceAdmin 
.const [237] = Utf8 (Lorg/dsi/ifc/base/ServiceAdmin;)V 
.const [238] = Utf8 org/osgi/util/tracker/ServiceTracker 
.const [239] = Utf8 close 
.const [240] = Utf8 ()V 
.const [241] = Utf8 de/audi/tghu/jdsi/JDSIActivator 
.const [242] = Utf8 getFramework 
.const [243] = Utf8 ()Lde/audi/atip/base/IFrameworkAccess; 
.const [244] = Utf8 de/audi/tghu/jdsi/JDSIActivator 
.const [245] = Utf8 initTracker 
.const [246] = Utf8 ()V 
.const [247] = Utf8 de/audi/tghu/jdsi/JDSIActivator 
.const [248] = Utf8 getDeviceInstance 
.const [249] = Utf8 (Lorg/osgi/framework/ServiceReference;)I 
.const [250] = Utf8 de/audi/tghu/jdsi/JDSIActivator 
.const [251] = Utf8 getDeviceName 
.const [252] = Utf8 (Lorg/osgi/framework/ServiceReference;)Ljava/lang/String; 
.const [253] = Utf8 java/lang/NoClassDefFoundError 
.const [254] = Utf8 <init> 
.const [255] = Utf8 ()V 
.const [256] = Utf8 de/audi/atip/activator/AbstractFrameworkActivator 
.const [257] = Utf8 <init> 
.const [258] = Utf8 (Ljava/lang/String;)V 
.const [259] = Utf8 de/audi/tghu/jdsi/JDSIActivator 
.const [260] = Utf8 class$org$dsi$ifc$base$ServiceAdmin 
.const [261] = Utf8 Ljava/lang/Class; 
.const [262] = Utf8 de/audi/tghu/jdsi/JDSIActivator$1 
.const [263] = Utf8 <init> 
.const [264] = Utf8 (Lde/audi/tghu/jdsi/JDSIActivator;)V 
.const [265] = Utf8 org/osgi/util/tracker/ServiceTracker 
.const [266] = Utf8 <init> 
.const [267] = Utf8 (Lorg/osgi/framework/BundleContext;Ljava/lang/String;Lorg/osgi/util/tracker/ServiceTrackerCustomizer;)V 
.const [268] = Utf8 de/audi/tghu/jdsi/JDSIActivator 
.const [269] = Utf8 getDSIFilter 
.const [270] = Utf8 ()Lorg/osgi/framework/Filter; 
.const [271] = Utf8 de/audi/tghu/jdsi/JDSIActivator$2 
.const [272] = Utf8 <init> 
.const [273] = Utf8 (Lde/audi/tghu/jdsi/JDSIActivator;Lde/audi/tghu/jdsi/JDSIManager;)V 
.const [274] = Utf8 org/osgi/util/tracker/ServiceTracker 
.const [275] = Utf8 <init> 
.const [276] = Utf8 (Lorg/osgi/framework/BundleContext;Lorg/osgi/framework/Filter;Lorg/osgi/util/tracker/ServiceTrackerCustomizer;)V 
.const [277] = Utf8 de/audi/tghu/jdsi/JDSIManager 
.const [278] = Utf8 <init> 
.const [279] = Utf8 (Lde/audi/atip/base/IFrameworkAccess;)V 
.const [280] = Utf8 de/audi/tghu/jdsi/JDSIActivator 
.const [281] = Utf8 initDSITracker 
.const [282] = Utf8 (Lde/audi/tghu/jdsi/JDSIManager;)V 
.const [283] = Utf8 de/audi/tghu/jdsi/JDSIActivator 
.const [284] = Utf8 cleanupDSI 
.const [285] = Utf8 ()V 
.const [286] = Utf8 de/audi/atip/activator/AbstractFrameworkActivator 
.const [287] = Utf8 stop 
.const [288] = Utf8 (Lorg/osgi/framework/BundleContext;)V 
.const [289] = Utf8 de/audi/tghu/jdsi/JDSIActivator 
.const [290] = Utf8 lc 
.const [291] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [292] = Utf8 de/audi/tghu/jdsi/JDSIActivator 
.const [293] = Utf8 service 
.const [294] = Utf8 Lde/audi/tghu/jdsi/JDSIManager; 
.const [295] = Utf8 de/audi/tghu/jdsi/JDSIActivator 
.const [296] = Utf8 serviceAdminReference 
.const [297] = Utf8 Lorg/osgi/framework/ServiceReference; 
.const [298] = Utf8 de/audi/tghu/jdsi/JDSIActivator 
.const [299] = Utf8 serviceAdminTracker 
.const [300] = Utf8 Lorg/osgi/util/tracker/ServiceTracker; 
.const [301] = Utf8 org/osgi/framework/BundleContext 
.const [302] = Utf8 createFilter 
.const [303] = Utf8 (Ljava/lang/String;)Lorg/osgi/framework/Filter; 
.const [304] = Utf8 org/osgi/framework/ServiceReference 
.const [305] = Utf8 getProperty 
.const [306] = Utf8 (Ljava/lang/String;)Ljava/lang/Object; 
.const [307] = Utf8 de/audi/tghu/jdsi/JDSIActivator 
.const [308] = Utf8 dsiTracker 
.const [309] = Utf8 Lorg/osgi/util/tracker/ServiceTracker; 
.const [310] = Utf8 org/osgi/framework/BundleContext 
.const [311] = Utf8 ungetService 
.const [312] = Utf8 (Lorg/osgi/framework/ServiceReference;)Z 
.const [313] = Utf8 de/audi/atip/base/IFrameworkAccess 
.const [314] = Utf8 getLogChannel 
.const [315] = Utf8 (Ljava/lang/String;)Lde/audi/atip/log/LogChannel; 
.const [316] = Utf8 de/audi/tghu/jdsi/JDSIActivator 
.const [317] = Class [316] 
.const [318] = Utf8 de/audi/atip/activator/AbstractFrameworkActivator 
.const [319] = Class [318] 
.const [320] = Utf8 service 
.const [321] = Utf8 Lde/audi/tghu/jdsi/JDSIManager; 
.const [322] = Utf8 serviceAdminReference 
.const [323] = Utf8 Lorg/osgi/framework/ServiceReference; 
.const [324] = Utf8 serviceAdminTracker 
.const [325] = Utf8 Lorg/osgi/util/tracker/ServiceTracker; 
.const [326] = Utf8 dsiTracker 
.const [327] = Utf8 Lorg/osgi/util/tracker/ServiceTracker; 
.const [328] = Utf8 lc 
.const [329] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [330] = Utf8 class$org$dsi$ifc$base$ServiceAdmin 
.const [331] = Utf8 Ljava/lang/Class; 
.const [332] = Utf8 Code 
.const [333] = Utf8 <init> 
.const [334] = Utf8 ()V 
.const [335] = Utf8 getService 
.const [336] = Utf8 ()Lde/audi/tghu/jdsi/JDSIManager; 
.const [337] = Utf8 initTracker 
.const [338] = Utf8 ()V 
.const [339] = Utf8 getDSIFilter 
.const [340] = Utf8 ()Lorg/osgi/framework/Filter; 
.const [341] = Utf8 getDeviceInstance 
.const [342] = Utf8 (Lorg/osgi/framework/ServiceReference;)I 
.const [343] = Utf8 getDeviceName 
.const [344] = Utf8 (Lorg/osgi/framework/ServiceReference;)Ljava/lang/String; 
.const [345] = Utf8 initDSITracker 
.const [346] = Utf8 (Lde/audi/tghu/jdsi/JDSIManager;)V 
.const [347] = Utf8 cleanupDSI 
.const [348] = Utf8 ()V 
.const [349] = Utf8 startInternal 
.const [350] = Utf8 (Lorg/osgi/framework/BundleContext;)V 
.const [351] = Utf8 stop 
.const [352] = Utf8 (Lorg/osgi/framework/BundleContext;)V 
.const [353] = Utf8 class$ 
.const [354] = Utf8 (Ljava/lang/String;)Ljava/lang/Class; 
.const [355] = Utf8 access$000 
.const [356] = Utf8 (Lde/audi/tghu/jdsi/JDSIActivator;)Lorg/osgi/framework/BundleContext; 
.const [357] = Utf8 access$102 
.const [358] = Utf8 (Lde/audi/tghu/jdsi/JDSIActivator;Lorg/osgi/framework/ServiceReference;)Lorg/osgi/framework/ServiceReference; 
.const [359] = Utf8 access$200 
.const [360] = Utf8 (Lde/audi/tghu/jdsi/JDSIActivator;)Lde/audi/tghu/jdsi/JDSIManager; 
.const [361] = Utf8 access$300 
.const [362] = Utf8 (Lde/audi/tghu/jdsi/JDSIActivator;)Lorg/osgi/framework/BundleContext; 
.const [363] = Utf8 access$400 
.const [364] = Utf8 (Lde/audi/tghu/jdsi/JDSIActivator;)Lorg/osgi/framework/BundleContext; 
.const [365] = Utf8 access$500 
.const [366] = Utf8 (Lde/audi/tghu/jdsi/JDSIActivator;)Lorg/osgi/framework/BundleContext; 
.const [367] = Utf8 access$600 
.const [368] = Utf8 (Lde/audi/tghu/jdsi/JDSIActivator;Lorg/osgi/framework/ServiceReference;)Ljava/lang/String; 
.const [369] = Utf8 access$700 
.const [370] = Utf8 (Lde/audi/tghu/jdsi/JDSIActivator;Lorg/osgi/framework/ServiceReference;)I 
.const [371] = Utf8 access$800 
.const [372] = Utf8 (Lde/audi/tghu/jdsi/JDSIActivator;)Lorg/osgi/framework/BundleContext; 
.const [373] = Utf8 access$900 
.const [374] = Utf8 (Lde/audi/tghu/jdsi/JDSIActivator;)Lde/audi/atip/log/LogChannel; 
.const [375] = Utf8 access$1000 
.const [376] = Utf8 (Lde/audi/tghu/jdsi/JDSIActivator;)Lorg/osgi/framework/BundleContext; 
.const [377] = Utf8 access$1100 
.const [378] = Utf8 (Lde/audi/tghu/jdsi/JDSIActivator;)Lorg/osgi/framework/BundleContext; 
.end class 
