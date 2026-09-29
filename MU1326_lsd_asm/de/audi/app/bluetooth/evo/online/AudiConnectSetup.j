.version 50 0 
.class public super [313] 
.super [315] 
.implements [317] 
.field private static final [318] [319] 
.field private static final [320] [321] 
.field private static final [322] [323] 
.field private static final [324] [325] 
.field private [326] [327] 
.field private final [328] [329] 
.field private [330] [331] 
.field private [332] [333] 
.field private [334] [335] 
.field static synthetic [336] [337] 

.method public [339] : [340] 
    .attribute [338] .code stack 3 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     invokespecial [52] 
L5:     aload_0 
L6:     aload_0 
L7:     ldc [5] 
L9:     invokevirtual [32] 
L12:    putfield [62] 
L15:    return 
L16:    
    .end code 
.end method 

.method protected [341] : [342] 
    .attribute [338] .code stack 6 locals 4 
L0:     aload_0 
L1:     aload_1 
L2:     invokespecial [53] 
L5:     istore_2 
L6:     aload_0 
L7:     aload_1 
L8:     invokespecial [54] 
L11:    istore_3 
L12:    aload_0 
L13:    invokespecial [55] 
L16:    istore 4 
L18:    aload_0 
L19:    invokespecial [56] 
L22:    istore 5 
L24:    aload_0 
L25:    getfield [34] 
L28:    ldc [6] 
L30:    new [63] 
L33:    dup 
L34:    invokespecial [57] 
L37:    ldc [8] 
L39:    invokevirtual [35] 
L42:    iload 5 
L44:    invokevirtual [36] 
L47:    invokevirtual [37] 
L50:    iload_2 
L51:    iload_3 
L52:    iload 4 
L54:    invokevirtual [38] 
L57:    iload_2 
L58:    ifeq L96 
L61:    iload 4 
L63:    ifne L96 
L66:    iload 5 
L68:    ifeq L96 
L71:    aload_0 
L72:    getfield [34] 
L75:    ldc [9] 
L77:    ldc [10] 
L79:    invokevirtual [39] 
L82:    pop 
L83:    aload_0 
L84:    getfield [33] 
L87:    iconst_1 
L88:    invokeinterface [64] 0 
L93:    goto L129 
L96:    iload_3 
L97:    ifeq L125 
L100:   aload_0 
L101:   getfield [34] 
L104:   ldc [9] 
L106:   ldc [11] 
L108:   invokevirtual [39] 
L111:   pop 
L112:   aload_0 
L113:   getfield [33] 
L116:   iconst_2 
L117:   invokeinterface [64] 0 
L122:   goto L129 
L125:   aload_0 
L126:   invokevirtual [40] 
L129:   return 
L130:   nop 
L131:   nop 
L132:   
    .end code 
.end method 

.method private [343] : [344] 
    .attribute [338] .code stack 2 locals 0 
L0:     aload_0 
L1:     getfield [41] 
L4:     invokeinterface [65] 0 
L9:     sipush 4442 
L12:    invokeinterface [66] 0 
L17:    iconst_1 
L18:    if_icmpne L25 
L21:    iconst_1 
L22:    goto L26 
L25:    iconst_0 
L26:    areturn 
L27:    nop 
L28:    
    .end code 
.end method 

.method private [345] : [346] 
    .attribute [338] .code stack 2 locals 0 
L0:     aload_1 
L1:     ifnull L27 
L4:     aload_1 
L5:     invokevirtual [42] 
L8:     iconst_4 
L9:     iand 
L10:    ifle L27 
L13:    aload_1 
L14:    invokevirtual [43] 
L17:    ldc [12] 
L19:    iand 
L20:    ifle L27 
L23:    iconst_1 
L24:    goto L28 
L27:    iconst_0 
L28:    areturn 
L29:    nop 
L30:    nop 
L31:    nop 
L32:    
    .end code 
.end method 

.method private [347] : [348] 
    .attribute [338] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [44] 
L4:     ifne L21 
L7:     aload_0 
L8:     getfield [45] 
L11:    ifne L21 
L14:    aload_0 
L15:    getfield [46] 
L18:    ifeq L25 
L21:    iconst_1 
L22:    goto L26 
L25:    iconst_0 
L26:    areturn 
L27:    nop 
L28:    
    .end code 
.end method 

.method private [349] : [350] 
    .attribute [338] .code stack 2 locals 0 
L0:     aload_1 
L1:     ifnull L26 
L4:     aload_1 
L5:     invokevirtual [42] 
L8:     iconst_2 
L9:     iand 
L10:    ifle L26 
L13:    aload_1 
L14:    invokevirtual [43] 
L17:    iconst_4 
L18:    iand 
L19:    ifne L26 
L22:    iconst_1 
L23:    goto L27 
L26:    iconst_0 
L27:    areturn 
L28:    
    .end code 
.end method 

.method protected [351] : [352] 
    .attribute [338] .code stack 3 locals 0 
L0:     aload_0 
L1:     getfield [34] 
L4:     ldc [9] 
L6:     ldc [13] 
L8:     invokevirtual [39] 
L11:    pop 
L12:    aload_0 
L13:    getfield [33] 
L16:    iconst_0 
L17:    invokeinterface [64] 0 
L22:    return 
L23:    nop 
L24:    
    .end code 
.end method 

.method public [353] : [354] 
    .attribute [338] .code stack 4 locals 0 
L0:     aload_0 
L1:     getfield [34] 
L4:     ldc [9] 
L6:     ldc [14] 
L8:     iload_1 
L9:     invokevirtual [47] 
L12:    pop 
L13:    aload_0 
L14:    iload_1 
L15:    putfield [67] 
L18:    return 
L19:    nop 
L20:    
    .end code 
.end method 

.method public [355] : [356] 
    .attribute [338] .code stack 4 locals 0 
L0:     aload_0 
L1:     getfield [34] 
L4:     ldc [9] 
L6:     ldc [15] 
L8:     iload_1 
L9:     invokevirtual [47] 
L12:    pop 
L13:    aload_0 
L14:    iload_1 
L15:    putfield [69] 
L18:    return 
L19:    nop 
L20:    
    .end code 
.end method 

.method public [357] : [358] 
    .attribute [338] .code stack 4 locals 0 
L0:     aload_0 
L1:     getfield [34] 
L4:     ldc [6] 
L6:     ldc [16] 
L8:     iload_1 
L9:     invokevirtual [47] 
L12:    pop 
L13:    aload_0 
L14:    iload_1 
L15:    putfield [68] 
L18:    return 
L19:    nop 
L20:    
    .end code 
.end method 

.method public [359] : [360] 
    .attribute [338] .code stack 3 locals 0 
L0:     aload_0 
L1:     getfield [34] 
L4:     ldc [9] 
L6:     ldc [17] 
L8:     invokevirtual [39] 
L11:    pop 
L12:    aload_0 
L13:    getfield [33] 
L16:    iconst_0 
L17:    invokeinterface [64] 0 
L22:    return 
L23:    nop 
L24:    
    .end code 
.end method 

.method public [361] : [362] 
    .attribute [338] .code stack 5 locals 0 
L0:     aload_0 
L1:     invokespecial [58] 
L4:     aload_0 
L5:     aload_0 
L6:     getfield [48] 
L9:     getstatic [18] 
L12:    ifnonnull L27 
L15:    ldc [19] 
L17:    invokestatic [20] 
L20:    dup 
L21:    putstatic [59] 
L24:    goto L30 
L27:    getstatic [18] 
L30:    invokevirtual [49] 
L33:    aload_0 
L34:    aconst_null 
L35:    invokeinterface [70] 0 
L40:    putfield [71] 
L43:    return 
L44:    
    .end code 
.end method 

.method public [363] : [364] 
    .attribute [338] .code stack 2 locals 0 
L0:     aload_0 
L1:     getfield [50] 
L4:     invokeinterface [72] 0 
L9:     aload_0 
L10:    aconst_null 
L11:    putfield [71] 
L14:    aload_0 
L15:    invokespecial [60] 
L18:    return 
L19:    nop 
L20:    
    .end code 
.end method 

.method static synthetic [365] : [366] 
    .attribute [338] .code stack 2 locals 1 
        .catch [3] from L0 to L4 using L5 
L0:     aload_0 
L1:     invokestatic [2] 
L4:     areturn 
L5:     astore_1 
L6:     new [61] 
L9:     dup 
L10:    invokespecial [51] 
L13:    aload_1 
L14:    invokevirtual [31] 
L17:    athrow 
L18:    nop 
L19:    nop 
L20:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Method [73] [74] 
.const [3] = Class [75] 
.const [4] = Class [76] 
.const [5] = Int 1780884992 
.const [6] = Int 1078071040 
.const [7] = Class [77] 
.const [8] = String [78] 
.const [9] = Int -2137614336 
.const [10] = String [79] 
.const [11] = String [80] 
.const [12] = Int 24576 
.const [13] = String [81] 
.const [14] = String [82] 
.const [15] = String [83] 
.const [16] = String [84] 
.const [17] = String [85] 
.const [18] = Field [86] [87] 
.const [19] = String [88] 
.const [20] = Method [89] [90] 
.const [21] = Class [91] 
.const [22] = Class [92] 
.const [23] = Class [93] 
.const [24] = Class [94] 
.const [25] = Class [95] 
.const [26] = Class [96] 
.const [27] = Class [97] 
.const [28] = Class [98] 
.const [29] = Class [99] 
.const [30] = Class [100] 
.const [31] = Method [101] [102] 
.const [32] = Method [103] [104] 
.const [33] = Field [105] [106] 
.const [34] = Field [107] [108] 
.const [35] = Method [109] [110] 
.const [36] = Method [111] [112] 
.const [37] = Method [113] [114] 
.const [38] = Method [115] [116] 
.const [39] = Method [117] [118] 
.const [40] = Method [119] [120] 
.const [41] = Field [121] [122] 
.const [42] = Method [123] [124] 
.const [43] = Method [125] [126] 
.const [44] = Field [127] [128] 
.const [45] = Field [129] [130] 
.const [46] = Field [131] [132] 
.const [47] = Method [133] [134] 
.const [48] = Field [135] [136] 
.const [49] = Method [137] [138] 
.const [50] = Field [139] [140] 
.const [51] = Method [141] [142] 
.const [52] = Method [143] [144] 
.const [53] = Method [145] [146] 
.const [54] = Method [147] [148] 
.const [55] = Method [149] [150] 
.const [56] = Method [151] [152] 
.const [57] = Method [153] [154] 
.const [58] = Method [155] [156] 
.const [59] = Field [157] [158] 
.const [60] = Method [159] [160] 
.const [61] = Class [161] 
.const [62] = Field [162] [163] 
.const [63] = Class [164] 
.const [64] = InterfaceMethod [165] [166] 
.const [65] = InterfaceMethod [167] [168] 
.const [66] = InterfaceMethod [169] [170] 
.const [67] = Field [171] [172] 
.const [68] = Field [173] [174] 
.const [69] = Field [175] [176] 
.const [70] = InterfaceMethod [177] [178] 
.const [71] = Field [179] [180] 
.const [72] = InterfaceMethod [181] [182] 
.const [73] = Class [183] 
.const [74] = NameAndType [184] [185] 
.const [75] = Utf8 java/lang/ClassNotFoundException 
.const [76] = Utf8 java/lang/NoClassDefFoundError 
.const [77] = Utf8 java/lang/StringBuffer 
.const [78] = Utf8 'AudiConnectSetup#handleNewDevice(): hfp=%1, sap=%2, data=%3, tetheringAllowed=' 
.const [79] = Utf8 'AudiConnectSetup#handleNewDevice(): Paired HFP device' 
.const [80] = Utf8 'AudiConnectSetup#handleNewDevice(): Paired SAP device' 
.const [81] = Utf8 'AudiConnectSetup#cleanupAfterPairing()' 
.const [82] = Utf8 'AudiConnectSetup#updateSimState(): simInserted=%1' 
.const [83] = Utf8 'AudiConnectSetup#updateESimState(): eSimActive=%1' 
.const [84] = Utf8 'AudiConnectSetup#updateWlanState(): tetheringConnected=%1' 
.const [85] = Utf8 'AudiConnectSetup#officeSetupLeft(): Resetting office setup model' 
.const [86] = Class [186] 
.const [87] = NameAndType [187] [188] 
.const [88] = Utf8 'de.audi.app.bluetooth.core.online.IConnectAppSetup' 
.const [89] = Class [189] 
.const [90] = NameAndType [190] [191] 
.const [91] = Utf8 de/audi/app/bluetooth/evo/online/AudiConnectSetup 
.const [92] = Utf8 de/audi/app/bluetooth/core/security/AbstractPostPairingHandler 
.const [93] = Utf8 java/lang/Class 
.const [94] = Utf8 de/audi/atip/log/LogChannel 
.const [95] = Utf8 de/audi/atip/hmi/modelaccess/ChoiceModelApp 
.const [96] = Utf8 de/audi/app/bluetooth/core/IBluetoothApplication 
.const [97] = Utf8 de/audi/atip/base/IFrameworkAccess 
.const [98] = Utf8 org/dsi/ifc/bluetooth/TrustedDevice 
.const [99] = Utf8 org/osgi/framework/BundleContext 
.const [100] = Utf8 org/osgi/framework/ServiceRegistration 
.const [101] = Class [192] 
.const [102] = NameAndType [193] [194] 
.const [103] = Class [195] 
.const [104] = NameAndType [196] [197] 
.const [105] = Class [198] 
.const [106] = NameAndType [199] [200] 
.const [107] = Class [201] 
.const [108] = NameAndType [202] [203] 
.const [109] = Class [204] 
.const [110] = NameAndType [205] [206] 
.const [111] = Class [207] 
.const [112] = NameAndType [208] [209] 
.const [113] = Class [210] 
.const [114] = NameAndType [211] [212] 
.const [115] = Class [213] 
.const [116] = NameAndType [214] [215] 
.const [117] = Class [216] 
.const [118] = NameAndType [217] [218] 
.const [119] = Class [219] 
.const [120] = NameAndType [220] [221] 
.const [121] = Class [222] 
.const [122] = NameAndType [223] [224] 
.const [123] = Class [225] 
.const [124] = NameAndType [226] [227] 
.const [125] = Class [228] 
.const [126] = NameAndType [229] [230] 
.const [127] = Class [231] 
.const [128] = NameAndType [232] [233] 
.const [129] = Class [234] 
.const [130] = NameAndType [235] [236] 
.const [131] = Class [237] 
.const [132] = NameAndType [238] [239] 
.const [133] = Class [240] 
.const [134] = NameAndType [241] [242] 
.const [135] = Class [243] 
.const [136] = NameAndType [244] [245] 
.const [137] = Class [246] 
.const [138] = NameAndType [247] [248] 
.const [139] = Class [249] 
.const [140] = NameAndType [250] [251] 
.const [141] = Class [252] 
.const [142] = NameAndType [253] [254] 
.const [143] = Class [255] 
.const [144] = NameAndType [256] [257] 
.const [145] = Class [258] 
.const [146] = NameAndType [259] [260] 
.const [147] = Class [261] 
.const [148] = NameAndType [262] [263] 
.const [149] = Class [264] 
.const [150] = NameAndType [265] [266] 
.const [151] = Class [267] 
.const [152] = NameAndType [268] [269] 
.const [153] = Class [270] 
.const [154] = NameAndType [271] [272] 
.const [155] = Class [273] 
.const [156] = NameAndType [274] [275] 
.const [157] = Class [276] 
.const [158] = NameAndType [277] [278] 
.const [159] = Class [279] 
.const [160] = NameAndType [280] [281] 
.const [161] = Utf8 java/lang/NoClassDefFoundError 
.const [162] = Class [282] 
.const [163] = NameAndType [283] [284] 
.const [164] = Utf8 java/lang/StringBuffer 
.const [165] = Class [285] 
.const [166] = NameAndType [286] [287] 
.const [167] = Class [288] 
.const [168] = NameAndType [289] [290] 
.const [169] = Class [291] 
.const [170] = NameAndType [292] [293] 
.const [171] = Class [294] 
.const [172] = NameAndType [295] [296] 
.const [173] = Class [297] 
.const [174] = NameAndType [298] [299] 
.const [175] = Class [300] 
.const [176] = NameAndType [301] [302] 
.const [177] = Class [303] 
.const [178] = NameAndType [304] [305] 
.const [179] = Class [306] 
.const [180] = NameAndType [307] [308] 
.const [181] = Class [309] 
.const [182] = NameAndType [310] [311] 
.const [183] = Utf8 java/lang/Class 
.const [184] = Utf8 forName 
.const [185] = Utf8 (Ljava/lang/String;)Ljava/lang/Class; 
.const [186] = Utf8 de/audi/app/bluetooth/evo/online/AudiConnectSetup 
.const [187] = Utf8 class$de$audi$app$bluetooth$core$online$IConnectAppSetup 
.const [188] = Utf8 Ljava/lang/Class; 
.const [189] = Utf8 de/audi/app/bluetooth/evo/online/AudiConnectSetup 
.const [190] = Utf8 class$ 
.const [191] = Utf8 (Ljava/lang/String;)Ljava/lang/Class; 
.const [192] = Utf8 java/lang/NoClassDefFoundError 
.const [193] = Utf8 initCause 
.const [194] = Utf8 (Ljava/lang/Throwable;)Ljava/lang/Throwable; 
.const [195] = Utf8 de/audi/app/bluetooth/evo/online/AudiConnectSetup 
.const [196] = Utf8 getChoiceModel 
.const [197] = Utf8 (I)Lde/audi/atip/hmi/modelaccess/ChoiceModelApp; 
.const [198] = Utf8 de/audi/app/bluetooth/evo/online/AudiConnectSetup 
.const [199] = Utf8 blueOfficeSetupChoice 
.const [200] = Utf8 Lde/audi/atip/hmi/modelaccess/ChoiceModelApp; 
.const [201] = Utf8 de/audi/app/bluetooth/evo/online/AudiConnectSetup 
.const [202] = Utf8 log 
.const [203] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [204] = Utf8 java/lang/StringBuffer 
.const [205] = Utf8 append 
.const [206] = Utf8 (Ljava/lang/String;)Ljava/lang/StringBuffer; 
.const [207] = Utf8 java/lang/StringBuffer 
.const [208] = Utf8 append 
.const [209] = Utf8 (Z)Ljava/lang/StringBuffer; 
.const [210] = Utf8 java/lang/StringBuffer 
.const [211] = Utf8 toString 
.const [212] = Utf8 ()Ljava/lang/String; 
.const [213] = Utf8 de/audi/atip/log/LogChannel 
.const [214] = Utf8 log 
.const [215] = Utf8 (ILjava/lang/String;ZZZ)V 
.const [216] = Utf8 de/audi/atip/log/LogChannel 
.const [217] = Utf8 log 
.const [218] = Utf8 (ILjava/lang/String;)Z 
.const [219] = Utf8 de/audi/app/bluetooth/evo/online/AudiConnectSetup 
.const [220] = Utf8 cleanupAfterPairing 
.const [221] = Utf8 ()V 
.const [222] = Utf8 de/audi/app/bluetooth/evo/online/AudiConnectSetup 
.const [223] = Utf8 bluetoothApplication 
.const [224] = Utf8 Lde/audi/app/bluetooth/core/IBluetoothApplication; 
.const [225] = Utf8 org/dsi/ifc/bluetooth/TrustedDevice 
.const [226] = Utf8 getActiveServiceTypes 
.const [227] = Utf8 ()I 
.const [228] = Utf8 org/dsi/ifc/bluetooth/TrustedDevice 
.const [229] = Utf8 getOfferedServiceTypes 
.const [230] = Utf8 ()I 
.const [231] = Utf8 de/audi/app/bluetooth/evo/online/AudiConnectSetup 
.const [232] = Utf8 simInserted 
.const [233] = Utf8 Z 
.const [234] = Utf8 de/audi/app/bluetooth/evo/online/AudiConnectSetup 
.const [235] = Utf8 tetheringConnected 
.const [236] = Utf8 Z 
.const [237] = Utf8 de/audi/app/bluetooth/evo/online/AudiConnectSetup 
.const [238] = Utf8 eSimActive 
.const [239] = Utf8 Z 
.const [240] = Utf8 de/audi/atip/log/LogChannel 
.const [241] = Utf8 log 
.const [242] = Utf8 (ILjava/lang/String;Z)Z 
.const [243] = Utf8 de/audi/app/bluetooth/evo/online/AudiConnectSetup 
.const [244] = Utf8 bundleContext 
.const [245] = Utf8 Lorg/osgi/framework/BundleContext; 
.const [246] = Utf8 java/lang/Class 
.const [247] = Utf8 getName 
.const [248] = Utf8 ()Ljava/lang/String; 
.const [249] = Utf8 de/audi/app/bluetooth/evo/online/AudiConnectSetup 
.const [250] = Utf8 registration 
.const [251] = Utf8 Lorg/osgi/framework/ServiceRegistration; 
.const [252] = Utf8 java/lang/NoClassDefFoundError 
.const [253] = Utf8 <init> 
.const [254] = Utf8 ()V 
.const [255] = Utf8 de/audi/app/bluetooth/core/security/AbstractPostPairingHandler 
.const [256] = Utf8 <init> 
.const [257] = Utf8 (Lde/audi/app/bluetooth/core/IBluetoothApplication;)V 
.const [258] = Utf8 de/audi/app/bluetooth/evo/online/AudiConnectSetup 
.const [259] = Utf8 deviceSupportsOnlyHfp 
.const [260] = Utf8 (Lorg/dsi/ifc/bluetooth/TrustedDevice;)Z 
.const [261] = Utf8 de/audi/app/bluetooth/evo/online/AudiConnectSetup 
.const [262] = Utf8 deviceSupportsSapAndMap 
.const [263] = Utf8 (Lorg/dsi/ifc/bluetooth/TrustedDevice;)Z 
.const [264] = Utf8 de/audi/app/bluetooth/evo/online/AudiConnectSetup 
.const [265] = Utf8 isDataDeviceConnected 
.const [266] = Utf8 ()Z 
.const [267] = Utf8 de/audi/app/bluetooth/evo/online/AudiConnectSetup 
.const [268] = Utf8 isTetheringCoded 
.const [269] = Utf8 ()Z 
.const [270] = Utf8 java/lang/StringBuffer 
.const [271] = Utf8 <init> 
.const [272] = Utf8 ()V 
.const [273] = Utf8 de/audi/app/bluetooth/core/security/AbstractPostPairingHandler 
.const [274] = Utf8 init 
.const [275] = Utf8 ()V 
.const [276] = Utf8 de/audi/app/bluetooth/evo/online/AudiConnectSetup 
.const [277] = Utf8 class$de$audi$app$bluetooth$core$online$IConnectAppSetup 
.const [278] = Utf8 Ljava/lang/Class; 
.const [279] = Utf8 de/audi/app/bluetooth/core/security/AbstractPostPairingHandler 
.const [280] = Utf8 deinit 
.const [281] = Utf8 ()V 
.const [282] = Utf8 de/audi/app/bluetooth/evo/online/AudiConnectSetup 
.const [283] = Utf8 blueOfficeSetupChoice 
.const [284] = Utf8 Lde/audi/atip/hmi/modelaccess/ChoiceModelApp; 
.const [285] = Utf8 de/audi/atip/hmi/modelaccess/ChoiceModelApp 
.const [286] = Utf8 setValue 
.const [287] = Utf8 (I)V 
.const [288] = Utf8 de/audi/app/bluetooth/core/IBluetoothApplication 
.const [289] = Utf8 getFramework 
.const [290] = Utf8 ()Lde/audi/atip/base/IFrameworkAccess; 
.const [291] = Utf8 de/audi/atip/base/IFrameworkAccess 
.const [292] = Utf8 getSysConst 
.const [293] = Utf8 (I)I 
.const [294] = Utf8 de/audi/app/bluetooth/evo/online/AudiConnectSetup 
.const [295] = Utf8 simInserted 
.const [296] = Utf8 Z 
.const [297] = Utf8 de/audi/app/bluetooth/evo/online/AudiConnectSetup 
.const [298] = Utf8 tetheringConnected 
.const [299] = Utf8 Z 
.const [300] = Utf8 de/audi/app/bluetooth/evo/online/AudiConnectSetup 
.const [301] = Utf8 eSimActive 
.const [302] = Utf8 Z 
.const [303] = Utf8 org/osgi/framework/BundleContext 
.const [304] = Utf8 registerService 
.const [305] = Utf8 (Ljava/lang/String;Ljava/lang/Object;Ljava/util/Dictionary;)Lorg/osgi/framework/ServiceRegistration; 
.const [306] = Utf8 de/audi/app/bluetooth/evo/online/AudiConnectSetup 
.const [307] = Utf8 registration 
.const [308] = Utf8 Lorg/osgi/framework/ServiceRegistration; 
.const [309] = Utf8 org/osgi/framework/ServiceRegistration 
.const [310] = Utf8 unregister 
.const [311] = Utf8 ()V 
.const [312] = Utf8 de/audi/app/bluetooth/evo/online/AudiConnectSetup 
.const [313] = Class [312] 
.const [314] = Utf8 de/audi/app/bluetooth/core/security/AbstractPostPairingHandler 
.const [315] = Class [314] 
.const [316] = Utf8 de/audi/app/bluetooth/core/online/IConnectAppSetup 
.const [317] = Class [316] 
.const [318] = Utf8 MESSAGING 
.const [319] = Utf8 I 
.const [320] = Utf8 NO_CHECK 
.const [321] = Utf8 I 
.const [322] = Utf8 PAIRED_HFP 
.const [323] = Utf8 I 
.const [324] = Utf8 PAIRED_SAP 
.const [325] = Utf8 I 
.const [326] = Utf8 registration 
.const [327] = Utf8 Lorg/osgi/framework/ServiceRegistration; 
.const [328] = Utf8 blueOfficeSetupChoice 
.const [329] = Utf8 Lde/audi/atip/hmi/modelaccess/ChoiceModelApp; 
.const [330] = Utf8 simInserted 
.const [331] = Utf8 Z 
.const [332] = Utf8 tetheringConnected 
.const [333] = Utf8 Z 
.const [334] = Utf8 eSimActive 
.const [335] = Utf8 Z 
.const [336] = Utf8 class$de$audi$app$bluetooth$core$online$IConnectAppSetup 
.const [337] = Utf8 Ljava/lang/Class; 
.const [338] = Utf8 Code 
.const [339] = Utf8 <init> 
.const [340] = Utf8 (Lde/audi/app/bluetooth/core/IBluetoothApplication;)V 
.const [341] = Utf8 handleNewDevice 
.const [342] = Utf8 (Lorg/dsi/ifc/bluetooth/TrustedDevice;)V 
.const [343] = Utf8 isTetheringCoded 
.const [344] = Utf8 ()Z 
.const [345] = Utf8 deviceSupportsSapAndMap 
.const [346] = Utf8 (Lorg/dsi/ifc/bluetooth/TrustedDevice;)Z 
.const [347] = Utf8 isDataDeviceConnected 
.const [348] = Utf8 ()Z 
.const [349] = Utf8 deviceSupportsOnlyHfp 
.const [350] = Utf8 (Lorg/dsi/ifc/bluetooth/TrustedDevice;)Z 
.const [351] = Utf8 cleanupAfterPairing 
.const [352] = Utf8 ()V 
.const [353] = Utf8 updateSimState 
.const [354] = Utf8 (Z)V 
.const [355] = Utf8 updateESimState 
.const [356] = Utf8 (Z)V 
.const [357] = Utf8 updateWlanState 
.const [358] = Utf8 (Z)V 
.const [359] = Utf8 officeSetupLeft 
.const [360] = Utf8 ()V 
.const [361] = Utf8 init 
.const [362] = Utf8 ()V 
.const [363] = Utf8 deinit 
.const [364] = Utf8 ()V 
.const [365] = Utf8 class$ 
.const [366] = Utf8 (Ljava/lang/String;)Ljava/lang/Class; 
.end class 
