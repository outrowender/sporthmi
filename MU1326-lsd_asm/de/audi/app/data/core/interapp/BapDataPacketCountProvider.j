.version 50 0 
.class public super [312] 
.super [314] 
.implements [316] 
.field private static final [317] [318] 
.field private static final [319] [320] 
.field private final [321] [322] 
.field private [323] [324] 
.field private [325] [326] 
.field private [327] [328] 
.field private static final [329] [330] 
.field private [331] [332] 
.field private [333] [334] 
.field static synthetic [335] [336] 
.field static synthetic [337] [338] 

.method public [340] : [341] 
    .attribute [339] .code stack 6 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     invokespecial [36] 
L5:     aload_0 
L6:     new [48] 
L9:     dup 
L10:    aload_0 
L11:    getfield [22] 
L14:    getstatic [6] 
L17:    ifnonnull L32 
L20:    ldc [7] 
L22:    invokestatic [8] 
L25:    dup 
L26:    putstatic [37] 
L29:    goto L35 
L32:    getstatic [6] 
L35:    invokevirtual [23] 
L38:    aload_0 
L39:    invokespecial [38] 
L42:    putfield [49] 
L45:    return 
L46:    nop 
L47:    nop 
L48:    
    .end code 
.end method 

.method protected [342] : [343] 
    .attribute [339] .code stack 1 locals 0 
L0:     getstatic [9] 
L3:     areturn 
L4:     
    .end code 
.end method 

.method public [344] : [345] 
    .attribute [339] .code stack 2 locals 0 
L0:     aload_3 
L1:     ifnull L34 
L4:     aload_3 
L5:     invokeinterface [50] 0 
L10:    ifeq L34 
L13:    aload_3 
L14:    invokeinterface [51] 0 
L19:    ifeq L43 
L22:    aload_0 
L23:    iconst_1 
L24:    putfield [52] 
L27:    aload_0 
L28:    invokespecial [40] 
L31:    goto L43 
L34:    aload_0 
L35:    iconst_0 
L36:    putfield [52] 
L39:    aload_0 
L40:    invokespecial [40] 
L43:    return 
L44:    
    .end code 
.end method 

.method public enum [346] : [347] 
    .attribute [339] .code stack 0 locals 0 
L0:     return 
L1:     nop 
L2:     nop 
L3:     nop 
L4:     
    .end code 
.end method 

.method public enum [348] : [349] 
    .attribute [339] .code stack 0 locals 0 
L0:     return 
L1:     nop 
L2:     nop 
L3:     nop 
L4:     
    .end code 
.end method 

.method public enum [350] : [351] 
    .attribute [339] .code stack 0 locals 0 
L0:     return 
L1:     nop 
L2:     nop 
L3:     nop 
L4:     
    .end code 
.end method 

.method public enum [352] : [353] 
    .attribute [339] .code stack 0 locals 0 
L0:     return 
L1:     nop 
L2:     nop 
L3:     nop 
L4:     
    .end code 
.end method 

.method public enum [354] : [355] 
    .attribute [339] .code stack 0 locals 0 
L0:     return 
L1:     nop 
L2:     nop 
L3:     nop 
L4:     
    .end code 
.end method 

.method public enum [356] : [357] 
    .attribute [339] .code stack 0 locals 0 
L0:     return 
L1:     nop 
L2:     nop 
L3:     nop 
L4:     
    .end code 
.end method 

.method public enum [358] : [359] 
    .attribute [339] .code stack 0 locals 0 
L0:     return 
L1:     nop 
L2:     nop 
L3:     nop 
L4:     
    .end code 
.end method 

.method public [360] : [361] 
    .attribute [339] .code stack 5 locals 0 
L0:     iload_2 
L1:     iconst_1 
L2:     if_icmpne L9 
L5:     aload_1 
L6:     ifnonnull L10 
L9:     return 
L10:    aload_0 
L11:    aload_1 
L12:    invokevirtual [26] 
L15:    ldc_w [1] 
L18:    ldiv 
L19:    putfield [53] 
L22:    aload_0 
L23:    aload_1 
L24:    invokevirtual [28] 
L27:    ldc_w [1] 
L30:    ldiv 
L31:    putfield [54] 
L34:    aload_0 
L35:    invokespecial [40] 
L38:    return 
L39:    nop 
L40:    
    .end code 
.end method 

.method private [362] : [363] 
    .attribute [339] .code stack 5 locals 0 
L0:     aload_0 
L1:     getfield [30] 
L4:     ifnull L38 
L7:     aload_0 
L8:     getfield [30] 
L11:    iconst_0 
L12:    aload_0 
L13:    getfield [25] 
L16:    invokeinterface [56] 0 
L21:    aload_0 
L22:    getfield [30] 
L25:    aload_0 
L26:    getfield [27] 
L29:    aload_0 
L30:    getfield [29] 
L33:    invokeinterface [57] 0 
L38:    return 
L39:    nop 
L40:    
    .end code 
.end method 

.method public [364] : [365] 
    .attribute [339] .code stack 2 locals 1 
L0:     aload_0 
L1:     getfield [22] 
L4:     aload_1 
L5:     invokeinterface [58] 0 
L10:    astore_2 
L11:    aload_2 
L12:    instanceof [10] 
L15:    ifeq L32 
L18:    aload_0 
L19:    aload_2 
L20:    checkcast [10] 
L23:    putfield [55] 
L26:    aload_0 
L27:    invokespecial [40] 
L30:    aload_2 
L31:    areturn 
L32:    aload_0 
L33:    aload_1 
L34:    invokespecial [41] 
L37:    areturn 
L38:    nop 
L39:    nop 
L40:    
    .end code 
.end method 

.method public [366] : [367] 
    .attribute [339] .code stack 3 locals 0 
L0:     aload_2 
L1:     instanceof [10] 
L4:     ifeq L18 
L7:     aload_0 
L8:     aload_2 
L9:     checkcast [10] 
L12:    putfield [55] 
L15:    goto L24 
L18:    aload_0 
L19:    aload_1 
L20:    aload_2 
L21:    invokespecial [42] 
L24:    return 
L25:    nop 
L26:    nop 
L27:    nop 
L28:    
    .end code 
.end method 

.method public [368] : [369] 
    .attribute [339] .code stack 3 locals 0 
L0:     aload_2 
L1:     instanceof [10] 
L4:     ifeq L29 
L7:     aload_0 
L8:     aload_2 
L9:     checkcast [10] 
L12:    putfield [55] 
L15:    aload_0 
L16:    getfield [22] 
L19:    aload_1 
L20:    invokeinterface [59] 0 
L25:    pop 
L26:    goto L35 
L29:    aload_0 
L30:    aload_1 
L31:    aload_2 
L32:    invokespecial [43] 
L35:    return 
L36:    
    .end code 
.end method 

.method public [370] : [371] 
    .attribute [339] .code stack 5 locals 0 
L0:     aload_0 
L1:     invokespecial [44] 
L4:     aload_0 
L5:     getfield [24] 
L8:     invokevirtual [31] 
L11:    aload_0 
L12:    aload_0 
L13:    getfield [32] 
L16:    invokeinterface [60] 0 
L21:    getstatic [11] 
L24:    ifnonnull L39 
L27:    ldc [12] 
L29:    invokestatic [8] 
L32:    dup 
L33:    putstatic [45] 
L36:    goto L42 
L39:    getstatic [11] 
L42:    invokevirtual [23] 
L45:    aload_0 
L46:    aconst_null 
L47:    invokeinterface [61] 0 
L52:    putfield [62] 
L55:    return 
L56:    
    .end code 
.end method 

.method public [372] : [373] 
    .attribute [339] .code stack 2 locals 0 
L0:     aload_0 
L1:     getfield [33] 
L4:     invokeinterface [63] 0 
L9:     aload_0 
L10:    aconst_null 
L11:    putfield [62] 
L14:    aload_0 
L15:    getfield [24] 
L18:    invokevirtual [34] 
L21:    aload_0 
L22:    invokespecial [46] 
L25:    return 
L26:    nop 
L27:    nop 
L28:    
    .end code 
.end method 

.method static synthetic [374] : [375] 
    .attribute [339] .code stack 2 locals 1 
        .catch [3] from L0 to L4 using L5 
L0:     aload_0 
L1:     invokestatic [2] 
L4:     areturn 
L5:     astore_1 
L6:     new [47] 
L9:     dup 
L10:    invokespecial [35] 
L13:    aload_1 
L14:    invokevirtual [21] 
L17:    athrow 
L18:    nop 
L19:    nop 
L20:    
    .end code 
.end method 

.method static [376] : [377] 
    .attribute [339] .code stack 4 locals 0 
L0:     iconst_1 
L1:     newarray int 
L3:     dup 
L4:     iconst_0 
L5:     bipush 12 
L7:     iastore 
L8:     putstatic [39] 
L11:    return 
L12:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Method [65] [66] 
.const [3] = Class [67] 
.const [4] = Class [68] 
.const [5] = Class [69] 
.const [6] = Field [70] [71] 
.const [7] = String [72] 
.const [8] = Method [73] [74] 
.const [9] = Field [75] [76] 
.const [10] = Class [77] 
.const [11] = Field [78] [79] 
.const [12] = String [80] 
.const [13] = Class [81] 
.const [14] = Class [82] 
.const [15] = Class [83] 
.const [16] = Class [84] 
.const [17] = Class [85] 
.const [18] = Class [86] 
.const [19] = Class [87] 
.const [20] = Class [88] 
.const [21] = Method [89] [90] 
.const [22] = Field [91] [92] 
.const [23] = Method [93] [94] 
.const [24] = Field [95] [96] 
.const [25] = Field [97] [98] 
.const [26] = Method [99] [100] 
.const [27] = Field [101] [102] 
.const [28] = Method [103] [104] 
.const [29] = Field [105] [106] 
.const [30] = Field [107] [108] 
.const [31] = Method [109] [110] 
.const [32] = Field [111] [112] 
.const [33] = Field [113] [114] 
.const [34] = Method [115] [116] 
.const [35] = Method [117] [118] 
.const [36] = Method [119] [120] 
.const [37] = Field [121] [122] 
.const [38] = Method [123] [124] 
.const [39] = Field [125] [126] 
.const [40] = Method [127] [128] 
.const [41] = Method [129] [130] 
.const [42] = Method [131] [132] 
.const [43] = Method [133] [134] 
.const [44] = Method [135] [136] 
.const [45] = Field [137] [138] 
.const [46] = Method [139] [140] 
.const [47] = Class [141] 
.const [48] = Class [142] 
.const [49] = Field [143] [144] 
.const [50] = InterfaceMethod [145] [146] 
.const [51] = InterfaceMethod [147] [148] 
.const [52] = Field [149] [150] 
.const [53] = Field [151] [152] 
.const [54] = Field [153] [154] 
.const [55] = Field [155] [156] 
.const [56] = InterfaceMethod [157] [158] 
.const [57] = InterfaceMethod [159] [160] 
.const [58] = InterfaceMethod [161] [162] 
.const [59] = InterfaceMethod [163] [164] 
.const [60] = InterfaceMethod [165] [166] 
.const [61] = InterfaceMethod [167] [168] 
.const [62] = Field [169] [170] 
.const [63] = InterfaceMethod [171] [172] 
.const [64] = Int -402456576 
.const [65] = Class [173] 
.const [66] = NameAndType [174] [175] 
.const [67] = Utf8 java/lang/ClassNotFoundException 
.const [68] = Utf8 java/lang/NoClassDefFoundError 
.const [69] = Utf8 org/osgi/util/tracker/ServiceTracker 
.const [70] = Class [176] 
.const [71] = NameAndType [177] [178] 
.const [72] = Utf8 'de.audi.atip.interapp.combi.bap.phone.CombiBAPServiceConnectivity' 
.const [73] = Class [179] 
.const [74] = NameAndType [180] [181] 
.const [75] = Class [182] 
.const [76] = NameAndType [183] [184] 
.const [77] = Utf8 de/audi/atip/interapp/combi/bap/phone/CombiBAPServiceConnectivity 
.const [78] = Class [185] 
.const [79] = NameAndType [186] [187] 
.const [80] = Utf8 'de.audi.atip.interapp.IConnectivityPhoneStateListener' 
.const [81] = Utf8 de/audi/app/data/core/interapp/BapDataPacketCountProvider 
.const [82] = Utf8 de/audi/app/data/core/AbstractDataConfigurationComponent 
.const [83] = Utf8 java/lang/Class 
.const [84] = Utf8 de/audi/atip/interapp/phone/ITelMESlotState 
.const [85] = Utf8 org/dsi/ifc/networking/CPacketCounter 
.const [86] = Utf8 org/osgi/framework/BundleContext 
.const [87] = Utf8 de/audi/app/data/core/IDataApplication 
.const [88] = Utf8 org/osgi/framework/ServiceRegistration 
.const [89] = Class [188] 
.const [90] = NameAndType [189] [190] 
.const [91] = Class [191] 
.const [92] = NameAndType [192] [193] 
.const [93] = Class [194] 
.const [94] = NameAndType [195] [196] 
.const [95] = Class [197] 
.const [96] = NameAndType [198] [199] 
.const [97] = Class [200] 
.const [98] = NameAndType [201] [202] 
.const [99] = Class [203] 
.const [100] = NameAndType [204] [205] 
.const [101] = Class [206] 
.const [102] = NameAndType [207] [208] 
.const [103] = Class [209] 
.const [104] = NameAndType [210] [211] 
.const [105] = Class [212] 
.const [106] = NameAndType [213] [214] 
.const [107] = Class [215] 
.const [108] = NameAndType [216] [217] 
.const [109] = Class [218] 
.const [110] = NameAndType [219] [220] 
.const [111] = Class [221] 
.const [112] = NameAndType [222] [223] 
.const [113] = Class [224] 
.const [114] = NameAndType [225] [226] 
.const [115] = Class [227] 
.const [116] = NameAndType [228] [229] 
.const [117] = Class [230] 
.const [118] = NameAndType [231] [232] 
.const [119] = Class [233] 
.const [120] = NameAndType [234] [235] 
.const [121] = Class [236] 
.const [122] = NameAndType [237] [238] 
.const [123] = Class [239] 
.const [124] = NameAndType [240] [241] 
.const [125] = Class [242] 
.const [126] = NameAndType [243] [244] 
.const [127] = Class [245] 
.const [128] = NameAndType [246] [247] 
.const [129] = Class [248] 
.const [130] = NameAndType [249] [250] 
.const [131] = Class [251] 
.const [132] = NameAndType [252] [253] 
.const [133] = Class [254] 
.const [134] = NameAndType [255] [256] 
.const [135] = Class [257] 
.const [136] = NameAndType [258] [259] 
.const [137] = Class [260] 
.const [138] = NameAndType [261] [262] 
.const [139] = Class [263] 
.const [140] = NameAndType [264] [265] 
.const [141] = Utf8 java/lang/NoClassDefFoundError 
.const [142] = Utf8 org/osgi/util/tracker/ServiceTracker 
.const [143] = Class [266] 
.const [144] = NameAndType [267] [268] 
.const [145] = Class [269] 
.const [146] = NameAndType [270] [271] 
.const [147] = Class [272] 
.const [148] = NameAndType [273] [274] 
.const [149] = Class [275] 
.const [150] = NameAndType [276] [277] 
.const [151] = Class [278] 
.const [152] = NameAndType [279] [280] 
.const [153] = Class [281] 
.const [154] = NameAndType [282] [283] 
.const [155] = Class [284] 
.const [156] = NameAndType [285] [286] 
.const [157] = Class [287] 
.const [158] = NameAndType [288] [289] 
.const [159] = Class [290] 
.const [160] = NameAndType [291] [292] 
.const [161] = Class [293] 
.const [162] = NameAndType [294] [295] 
.const [163] = Class [296] 
.const [164] = NameAndType [297] [298] 
.const [165] = Class [299] 
.const [166] = NameAndType [300] [301] 
.const [167] = Class [302] 
.const [168] = NameAndType [303] [304] 
.const [169] = Class [305] 
.const [170] = NameAndType [306] [307] 
.const [171] = Class [308] 
.const [172] = NameAndType [309] [310] 
.const [173] = Utf8 java/lang/Class 
.const [174] = Utf8 forName 
.const [175] = Utf8 (Ljava/lang/String;)Ljava/lang/Class; 
.const [176] = Utf8 de/audi/app/data/core/interapp/BapDataPacketCountProvider 
.const [177] = Utf8 class$de$audi$atip$interapp$combi$bap$phone$CombiBAPServiceConnectivity 
.const [178] = Utf8 Ljava/lang/Class; 
.const [179] = Utf8 de/audi/app/data/core/interapp/BapDataPacketCountProvider 
.const [180] = Utf8 class$ 
.const [181] = Utf8 (Ljava/lang/String;)Ljava/lang/Class; 
.const [182] = Utf8 de/audi/app/data/core/interapp/BapDataPacketCountProvider 
.const [183] = Utf8 ATTRIBUTE_NOTIFICATIONS 
.const [184] = Utf8 [I 
.const [185] = Utf8 de/audi/app/data/core/interapp/BapDataPacketCountProvider 
.const [186] = Utf8 class$de$audi$atip$interapp$IConnectivityPhoneStateListener 
.const [187] = Utf8 Ljava/lang/Class; 
.const [188] = Utf8 java/lang/NoClassDefFoundError 
.const [189] = Utf8 initCause 
.const [190] = Utf8 (Ljava/lang/Throwable;)Ljava/lang/Throwable; 
.const [191] = Utf8 de/audi/app/data/core/interapp/BapDataPacketCountProvider 
.const [192] = Utf8 bundleContext 
.const [193] = Utf8 Lorg/osgi/framework/BundleContext; 
.const [194] = Utf8 java/lang/Class 
.const [195] = Utf8 getName 
.const [196] = Utf8 ()Ljava/lang/String; 
.const [197] = Utf8 de/audi/app/data/core/interapp/BapDataPacketCountProvider 
.const [198] = Utf8 tracker 
.const [199] = Utf8 Lorg/osgi/util/tracker/ServiceTracker; 
.const [200] = Utf8 de/audi/app/data/core/interapp/BapDataPacketCountProvider 
.const [201] = Utf8 dataConnectionIndication2Supported 
.const [202] = Utf8 Z 
.const [203] = Utf8 org/dsi/ifc/networking/CPacketCounter 
.const [204] = Utf8 getTxBytesSinceReset 
.const [205] = Utf8 ()J 
.const [206] = Utf8 de/audi/app/data/core/interapp/BapDataPacketCountProvider 
.const [207] = Utf8 dataVolumeUplink 
.const [208] = Utf8 J 
.const [209] = Utf8 org/dsi/ifc/networking/CPacketCounter 
.const [210] = Utf8 getRxBytesSinceReset 
.const [211] = Utf8 ()J 
.const [212] = Utf8 de/audi/app/data/core/interapp/BapDataPacketCountProvider 
.const [213] = Utf8 dataVolumeDownlink 
.const [214] = Utf8 J 
.const [215] = Utf8 de/audi/app/data/core/interapp/BapDataPacketCountProvider 
.const [216] = Utf8 bapService 
.const [217] = Utf8 Lde/audi/atip/interapp/combi/bap/phone/CombiBAPServiceConnectivity; 
.const [218] = Utf8 org/osgi/util/tracker/ServiceTracker 
.const [219] = Utf8 'open' 
.const [220] = Utf8 ()V 
.const [221] = Utf8 de/audi/app/data/core/interapp/BapDataPacketCountProvider 
.const [222] = Utf8 dataApplication 
.const [223] = Utf8 Lde/audi/app/data/core/IDataApplication; 
.const [224] = Utf8 de/audi/app/data/core/interapp/BapDataPacketCountProvider 
.const [225] = Utf8 serviceRegistration 
.const [226] = Utf8 Lorg/osgi/framework/ServiceRegistration; 
.const [227] = Utf8 org/osgi/util/tracker/ServiceTracker 
.const [228] = Utf8 close 
.const [229] = Utf8 ()V 
.const [230] = Utf8 java/lang/NoClassDefFoundError 
.const [231] = Utf8 <init> 
.const [232] = Utf8 ()V 
.const [233] = Utf8 de/audi/app/data/core/AbstractDataConfigurationComponent 
.const [234] = Utf8 <init> 
.const [235] = Utf8 (Lde/audi/app/data/core/IDataApplication;)V 
.const [236] = Utf8 de/audi/app/data/core/interapp/BapDataPacketCountProvider 
.const [237] = Utf8 class$de$audi$atip$interapp$combi$bap$phone$CombiBAPServiceConnectivity 
.const [238] = Utf8 Ljava/lang/Class; 
.const [239] = Utf8 org/osgi/util/tracker/ServiceTracker 
.const [240] = Utf8 <init> 
.const [241] = Utf8 (Lorg/osgi/framework/BundleContext;Ljava/lang/String;Lorg/osgi/util/tracker/ServiceTrackerCustomizer;)V 
.const [242] = Utf8 de/audi/app/data/core/interapp/BapDataPacketCountProvider 
.const [243] = Utf8 ATTRIBUTE_NOTIFICATIONS 
.const [244] = Utf8 [I 
.const [245] = Utf8 de/audi/app/data/core/interapp/BapDataPacketCountProvider 
.const [246] = Utf8 updateState 
.const [247] = Utf8 ()V 
.const [248] = Utf8 de/audi/app/data/core/AbstractDataConfigurationComponent 
.const [249] = Utf8 addingService 
.const [250] = Utf8 (Lorg/osgi/framework/ServiceReference;)Ljava/lang/Object; 
.const [251] = Utf8 de/audi/app/data/core/AbstractDataConfigurationComponent 
.const [252] = Utf8 modifiedService 
.const [253] = Utf8 (Lorg/osgi/framework/ServiceReference;Ljava/lang/Object;)V 
.const [254] = Utf8 de/audi/app/data/core/AbstractDataConfigurationComponent 
.const [255] = Utf8 removedService 
.const [256] = Utf8 (Lorg/osgi/framework/ServiceReference;Ljava/lang/Object;)V 
.const [257] = Utf8 de/audi/app/data/core/AbstractDataConfigurationComponent 
.const [258] = Utf8 init 
.const [259] = Utf8 ()V 
.const [260] = Utf8 de/audi/app/data/core/interapp/BapDataPacketCountProvider 
.const [261] = Utf8 class$de$audi$atip$interapp$IConnectivityPhoneStateListener 
.const [262] = Utf8 Ljava/lang/Class; 
.const [263] = Utf8 de/audi/app/data/core/AbstractDataConfigurationComponent 
.const [264] = Utf8 deinit 
.const [265] = Utf8 ()V 
.const [266] = Utf8 de/audi/app/data/core/interapp/BapDataPacketCountProvider 
.const [267] = Utf8 tracker 
.const [268] = Utf8 Lorg/osgi/util/tracker/ServiceTracker; 
.const [269] = Utf8 de/audi/atip/interapp/phone/ITelMESlotState 
.const [270] = Utf8 isUnlocked 
.const [271] = Utf8 ()Z 
.const [272] = Utf8 de/audi/atip/interapp/phone/ITelMESlotState 
.const [273] = Utf8 isSim 
.const [274] = Utf8 ()Z 
.const [275] = Utf8 de/audi/app/data/core/interapp/BapDataPacketCountProvider 
.const [276] = Utf8 dataConnectionIndication2Supported 
.const [277] = Utf8 Z 
.const [278] = Utf8 de/audi/app/data/core/interapp/BapDataPacketCountProvider 
.const [279] = Utf8 dataVolumeUplink 
.const [280] = Utf8 J 
.const [281] = Utf8 de/audi/app/data/core/interapp/BapDataPacketCountProvider 
.const [282] = Utf8 dataVolumeDownlink 
.const [283] = Utf8 J 
.const [284] = Utf8 de/audi/app/data/core/interapp/BapDataPacketCountProvider 
.const [285] = Utf8 bapService 
.const [286] = Utf8 Lde/audi/atip/interapp/combi/bap/phone/CombiBAPServiceConnectivity; 
.const [287] = Utf8 de/audi/atip/interapp/combi/bap/phone/CombiBAPServiceConnectivity 
.const [288] = Utf8 updateMobileServiceSupportConnectionIndication 
.const [289] = Utf8 (ZZ)V 
.const [290] = Utf8 de/audi/atip/interapp/combi/bap/phone/CombiBAPServiceConnectivity 
.const [291] = Utf8 updateDataConnection2PacketCount 
.const [292] = Utf8 (JJ)V 
.const [293] = Utf8 org/osgi/framework/BundleContext 
.const [294] = Utf8 getService 
.const [295] = Utf8 (Lorg/osgi/framework/ServiceReference;)Ljava/lang/Object; 
.const [296] = Utf8 org/osgi/framework/BundleContext 
.const [297] = Utf8 ungetService 
.const [298] = Utf8 (Lorg/osgi/framework/ServiceReference;)Z 
.const [299] = Utf8 de/audi/app/data/core/IDataApplication 
.const [300] = Utf8 getBundleContext 
.const [301] = Utf8 ()Lorg/osgi/framework/BundleContext; 
.const [302] = Utf8 org/osgi/framework/BundleContext 
.const [303] = Utf8 registerService 
.const [304] = Utf8 (Ljava/lang/String;Ljava/lang/Object;Ljava/util/Dictionary;)Lorg/osgi/framework/ServiceRegistration; 
.const [305] = Utf8 de/audi/app/data/core/interapp/BapDataPacketCountProvider 
.const [306] = Utf8 serviceRegistration 
.const [307] = Utf8 Lorg/osgi/framework/ServiceRegistration; 
.const [308] = Utf8 org/osgi/framework/ServiceRegistration 
.const [309] = Utf8 unregister 
.const [310] = Utf8 ()V 
.const [311] = Utf8 de/audi/app/data/core/interapp/BapDataPacketCountProvider 
.const [312] = Class [311] 
.const [313] = Utf8 de/audi/app/data/core/AbstractDataConfigurationComponent 
.const [314] = Class [313] 
.const [315] = Utf8 de/audi/atip/interapp/IConnectivityPhoneStateListener 
.const [316] = Class [315] 
.const [317] = Utf8 ATTRIBUTE_NOTIFICATIONS 
.const [318] = Utf8 [I 
.const [319] = Utf8 KB 
.const [320] = Utf8 I 
.const [321] = Utf8 tracker 
.const [322] = Utf8 Lorg/osgi/util/tracker/ServiceTracker; 
.const [323] = Utf8 bapService 
.const [324] = Utf8 Lde/audi/atip/interapp/combi/bap/phone/CombiBAPServiceConnectivity; 
.const [325] = Utf8 serviceRegistration 
.const [326] = Utf8 Lorg/osgi/framework/ServiceRegistration; 
.const [327] = Utf8 dataConnectionIndication2Supported 
.const [328] = Utf8 Z 
.const [329] = Utf8 DATA_CONNECTION_INDICATION_SUPPORTED 
.const [330] = Utf8 Z 
.const [331] = Utf8 dataVolumeUplink 
.const [332] = Utf8 J 
.const [333] = Utf8 dataVolumeDownlink 
.const [334] = Utf8 J 
.const [335] = Utf8 class$de$audi$atip$interapp$combi$bap$phone$CombiBAPServiceConnectivity 
.const [336] = Utf8 Ljava/lang/Class; 
.const [337] = Utf8 class$de$audi$atip$interapp$IConnectivityPhoneStateListener 
.const [338] = Utf8 Ljava/lang/Class; 
.const [339] = Utf8 Code 
.const [340] = Utf8 <init> 
.const [341] = Utf8 (Lde/audi/app/data/core/IDataApplication;)V 
.const [342] = Utf8 getAttributeNotifications 
.const [343] = Utf8 ()[I 
.const [344] = Utf8 updateMESlotInfo 
.const [345] = Utf8 (Lde/audi/atip/interapp/phone/ITelMESlotState;Lde/audi/atip/interapp/phone/ITelMESlotState;Lde/audi/atip/interapp/phone/ITelMESlotState;)V 
.const [346] = Utf8 updatePhoneState 
.const [347] = Utf8 (II)V 
.const [348] = Utf8 updateESIMInfo 
.const [349] = Utf8 (Ljava/lang/String;Ljava/lang/String;ZZ)V 
.const [350] = Utf8 telAppEntered 
.const [351] = Utf8 ()V 
.const [352] = Utf8 telAppLeft 
.const [353] = Utf8 ()V 
.const [354] = Utf8 telUnlockEntered 
.const [355] = Utf8 ()V 
.const [356] = Utf8 telUnlockLeft 
.const [357] = Utf8 ()V 
.const [358] = Utf8 updateConnectedGatewayState 
.const [359] = Utf8 (Z)V 
.const [360] = Utf8 updatePacketCounter 
.const [361] = Utf8 (Lorg/dsi/ifc/networking/CPacketCounter;I)V 
.const [362] = Utf8 updateState 
.const [363] = Utf8 ()V 
.const [364] = Utf8 addingService 
.const [365] = Utf8 (Lorg/osgi/framework/ServiceReference;)Ljava/lang/Object; 
.const [366] = Utf8 modifiedService 
.const [367] = Utf8 (Lorg/osgi/framework/ServiceReference;Ljava/lang/Object;)V 
.const [368] = Utf8 removedService 
.const [369] = Utf8 (Lorg/osgi/framework/ServiceReference;Ljava/lang/Object;)V 
.const [370] = Utf8 init 
.const [371] = Utf8 ()V 
.const [372] = Utf8 deinit 
.const [373] = Utf8 ()V 
.const [374] = Utf8 class$ 
.const [375] = Utf8 (Ljava/lang/String;)Ljava/lang/Class; 
.const [376] = Utf8 <clinit> 
.const [377] = Utf8 ()V 
.end class 
