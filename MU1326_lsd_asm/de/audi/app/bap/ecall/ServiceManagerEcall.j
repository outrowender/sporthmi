.version 50 0 
.class public super [255] 
.super [257] 
.field private [258] [259] 
.field static synthetic [260] [261] 
.field static synthetic [262] [263] 
.field static synthetic [264] [265] 

.method public [267] : [268] 
    .attribute [266] .code stack 3 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     aload_2 
L3:     invokespecial [48] 
L6:     aload_0 
L7:     aload_1 
L8:     invokevirtual [34] 
L11:    putfield [56] 
L14:    return 
L15:    nop 
L16:    
    .end code 
.end method 

.method public [269] : [270] 
    .attribute [266] .code stack 3 locals 1 
L0:     aload_0 
L1:     getfield [36] 
L4:     aload_1 
L5:     invokeinterface [57] 0 
L10:    astore_2 
L11:    aload_2 
L12:    instanceof [5] 
L15:    ifeq L69 
L18:    aload_0 
L19:    getfield [35] 
L22:    ldc [6] 
L24:    ldc [7] 
L26:    invokevirtual [37] 
L29:    pop 
L30:    aload_0 
L31:    getfield [38] 
L34:    invokevirtual [39] 
L37:    ldc [8] 
L39:    invokeinterface [58] 0 
L44:    checkcast [9] 
L47:    aload_2 
L48:    checkcast [10] 
L51:    invokevirtual [40] 
L54:    aload_0 
L55:    getfield [38] 
L58:    invokevirtual [41] 
L61:    iconst_1 
L62:    invokeinterface [59] 0 
L67:    aload_2 
L68:    areturn 
L69:    aload_0 
L70:    getfield [36] 
L73:    aload_1 
L74:    invokeinterface [60] 0 
L79:    pop 
L80:    aload_0 
L81:    aload_1 
L82:    invokespecial [49] 
L85:    areturn 
L86:    nop 
L87:    nop 
L88:    
    .end code 
.end method 

.method public [271] : [272] 
    .attribute [266] .code stack 3 locals 0 
L0:     aload_2 
L1:     instanceof [5] 
L4:     ifeq L54 
L7:     aload_0 
L8:     getfield [35] 
L11:    ldc [11] 
L13:    ldc [12] 
L15:    invokevirtual [37] 
L18:    pop 
L19:    aload_0 
L20:    getfield [38] 
L23:    invokevirtual [39] 
L26:    ldc [8] 
L28:    invokeinterface [58] 0 
L33:    checkcast [9] 
L36:    aconst_null 
L37:    invokevirtual [40] 
L40:    aload_0 
L41:    getfield [36] 
L44:    aload_1 
L45:    invokeinterface [60] 0 
L50:    pop 
L51:    goto L60 
L54:    aload_0 
L55:    aload_1 
L56:    aload_2 
L57:    invokespecial [50] 
L60:    return 
L61:    nop 
L62:    nop 
L63:    nop 
L64:    
    .end code 
.end method 

.method public [273] : [274] 
    .attribute [266] .code stack 4 locals 0 
L0:     aload_0 
L1:     getfield [35] 
L4:     ldc [6] 
L6:     ldc [13] 
L8:     aload_1 
L9:     invokevirtual [42] 
L12:    pop 
L13:    aload_1 
L14:    getstatic [14] 
L17:    ifnonnull L32 
L20:    ldc [15] 
L22:    invokestatic [16] 
L25:    dup 
L26:    putstatic [51] 
L29:    goto L35 
L32:    getstatic [14] 
L35:    invokevirtual [43] 
L38:    aload_0 
L39:    getfield [38] 
L42:    invokevirtual [39] 
L45:    ldc [8] 
L47:    invokeinterface [58] 0 
L52:    aconst_null 
L53:    invokevirtual [44] 
L56:    return 
L57:    nop 
L58:    nop 
L59:    nop 
L60:    
    .end code 
.end method 

.method public [275] : [276] 
    .attribute [266] .code stack 6 locals 1 
L0:     aload_0 
L1:     getfield [35] 
L4:     ldc [6] 
L6:     ldc [17] 
L8:     invokevirtual [37] 
L11:    pop 
L12:    iconst_2 
L13:    anewarray [18] 
L16:    dup 
L17:    iconst_0 
L18:    getstatic [19] 
L21:    ifnonnull L36 
L24:    ldc [20] 
L26:    invokestatic [16] 
L29:    dup 
L30:    putstatic [52] 
L33:    goto L39 
L36:    getstatic [19] 
L39:    invokevirtual [43] 
L42:    aastore 
L43:    dup 
L44:    iconst_1 
L45:    getstatic [21] 
L48:    ifnonnull L63 
L51:    ldc [22] 
L53:    invokestatic [16] 
L56:    dup 
L57:    putstatic [53] 
L60:    goto L66 
L63:    getstatic [21] 
L66:    invokevirtual [43] 
L69:    aastore 
L70:    astore_1 
L71:    aload_0 
L72:    new [61] 
L75:    dup 
L76:    aload_0 
L77:    getfield [36] 
L80:    aload_1 
L81:    aload_0 
L82:    invokespecial [54] 
L85:    putfield [62] 
L88:    aload_0 
L89:    getfield [45] 
L92:    invokevirtual [46] 
L95:    return 
L96:    
    .end code 
.end method 

.method static synthetic [277] : [278] 
    .attribute [266] .code stack 2 locals 1 
        .catch [3] from L0 to L4 using L5 
L0:     aload_0 
L1:     invokestatic [2] 
L4:     areturn 
L5:     astore_1 
L6:     new [55] 
L9:     dup 
L10:    invokespecial [47] 
L13:    aload_1 
L14:    invokevirtual [33] 
L17:    athrow 
L18:    nop 
L19:    nop 
L20:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Method [63] [64] 
.const [3] = Class [65] 
.const [4] = Class [66] 
.const [5] = Class [67] 
.const [6] = Int 1078071040 
.const [7] = String [68] 
.const [8] = String [69] 
.const [9] = Class [70] 
.const [10] = Class [71] 
.const [11] = Int -2137614336 
.const [12] = String [72] 
.const [13] = String [73] 
.const [14] = Field [74] [75] 
.const [15] = String [76] 
.const [16] = Method [77] [78] 
.const [17] = String [79] 
.const [18] = Class [80] 
.const [19] = Field [81] [82] 
.const [20] = String [83] 
.const [21] = Field [84] [85] 
.const [22] = String [86] 
.const [23] = Class [87] 
.const [24] = Class [88] 
.const [25] = Class [89] 
.const [26] = Class [90] 
.const [27] = Class [91] 
.const [28] = Class [92] 
.const [29] = Class [93] 
.const [30] = Class [94] 
.const [31] = Class [95] 
.const [32] = Class [96] 
.const [33] = Method [97] [98] 
.const [34] = Method [99] [100] 
.const [35] = Field [101] [102] 
.const [36] = Field [103] [104] 
.const [37] = Method [105] [106] 
.const [38] = Field [107] [108] 
.const [39] = Method [109] [110] 
.const [40] = Method [111] [112] 
.const [41] = Method [113] [114] 
.const [42] = Method [115] [116] 
.const [43] = Method [117] [118] 
.const [44] = Method [119] [120] 
.const [45] = Field [121] [122] 
.const [46] = Method [123] [124] 
.const [47] = Method [125] [126] 
.const [48] = Method [127] [128] 
.const [49] = Method [129] [130] 
.const [50] = Method [131] [132] 
.const [51] = Field [133] [134] 
.const [52] = Field [135] [136] 
.const [53] = Field [137] [138] 
.const [54] = Method [139] [140] 
.const [55] = Class [141] 
.const [56] = Field [142] [143] 
.const [57] = InterfaceMethod [144] [145] 
.const [58] = InterfaceMethod [146] [147] 
.const [59] = InterfaceMethod [148] [149] 
.const [60] = InterfaceMethod [150] [151] 
.const [61] = Class [152] 
.const [62] = Field [153] [154] 
.const [63] = Class [155] 
.const [64] = NameAndType [156] [157] 
.const [65] = Utf8 java/lang/ClassNotFoundException 
.const [66] = Utf8 java/lang/NoClassDefFoundError 
.const [67] = Utf8 de/audi/atip/interapp/bap/ecall/BAPServiceEcallListener 
.const [68] = Utf8 '[ServiceManagerEcall#addingService] BAPServiceEcallListener found' 
.const [69] = Utf8 AppBapEcall 
.const [70] = Utf8 de/audi/app/bap/ecall/AppConnectorEcall 
.const [71] = Utf8 de/audi/atip/interapp/bap/BAPServiceListener 
.const [72] = Utf8 '[ServiceManagerEcall#removedService] BAPServiceEcallListener removed' 
.const [73] = Utf8 '[ServiceManagerEcall#registerServices] activator: %1' 
.const [74] = Class [158] 
.const [75] = NameAndType [159] [160] 
.const [76] = Utf8 'de.audi.atip.interapp.bap.ecall.BAPServiceEcall' 
.const [77] = Class [161] 
.const [78] = NameAndType [162] [163] 
.const [79] = Utf8 '[ServiceManagerEcall#trackServices]' 
.const [80] = Utf8 java/lang/String 
.const [81] = Class [164] 
.const [82] = NameAndType [165] [166] 
.const [83] = Utf8 'de.audi.atip.interapp.bap.ecall.BAPServiceEcallListener' 
.const [84] = Class [167] 
.const [85] = NameAndType [168] [169] 
.const [86] = Utf8 'de.audi.atip.diag.sw.SwDiagnosisManager' 
.const [87] = Utf8 org/osgi/util/tracker/ServiceTracker 
.const [88] = Utf8 de/audi/app/bap/ecall/ServiceManagerEcall 
.const [89] = Utf8 de/audi/app/bap/fw/AbstractBAPModuleServiceManager 
.const [90] = Utf8 java/lang/Class 
.const [91] = Utf8 de/audi/app/bap/fw/AbstractBAPModule 
.const [92] = Utf8 org/osgi/framework/BundleContext 
.const [93] = Utf8 de/audi/atip/log/LogChannel 
.const [94] = Utf8 java/util/Map 
.const [95] = Utf8 de/audi/app/bap/fw/IBAPModuleInitializationManager 
.const [96] = Utf8 de/audi/atip/activator/AbstractActivator 
.const [97] = Class [170] 
.const [98] = NameAndType [171] [172] 
.const [99] = Class [173] 
.const [100] = NameAndType [174] [175] 
.const [101] = Class [176] 
.const [102] = NameAndType [177] [178] 
.const [103] = Class [179] 
.const [104] = NameAndType [180] [181] 
.const [105] = Class [182] 
.const [106] = NameAndType [183] [184] 
.const [107] = Class [185] 
.const [108] = NameAndType [186] [187] 
.const [109] = Class [188] 
.const [110] = NameAndType [189] [190] 
.const [111] = Class [191] 
.const [112] = NameAndType [192] [193] 
.const [113] = Class [194] 
.const [114] = NameAndType [195] [196] 
.const [115] = Class [197] 
.const [116] = NameAndType [198] [199] 
.const [117] = Class [200] 
.const [118] = NameAndType [201] [202] 
.const [119] = Class [203] 
.const [120] = NameAndType [204] [205] 
.const [121] = Class [206] 
.const [122] = NameAndType [207] [208] 
.const [123] = Class [209] 
.const [124] = NameAndType [210] [211] 
.const [125] = Class [212] 
.const [126] = NameAndType [213] [214] 
.const [127] = Class [215] 
.const [128] = NameAndType [216] [217] 
.const [129] = Class [218] 
.const [130] = NameAndType [219] [220] 
.const [131] = Class [221] 
.const [132] = NameAndType [222] [223] 
.const [133] = Class [224] 
.const [134] = NameAndType [225] [226] 
.const [135] = Class [227] 
.const [136] = NameAndType [228] [229] 
.const [137] = Class [230] 
.const [138] = NameAndType [231] [232] 
.const [139] = Class [233] 
.const [140] = NameAndType [234] [235] 
.const [141] = Utf8 java/lang/NoClassDefFoundError 
.const [142] = Class [236] 
.const [143] = NameAndType [237] [238] 
.const [144] = Class [239] 
.const [145] = NameAndType [240] [241] 
.const [146] = Class [242] 
.const [147] = NameAndType [243] [244] 
.const [148] = Class [245] 
.const [149] = NameAndType [246] [247] 
.const [150] = Class [248] 
.const [151] = NameAndType [249] [250] 
.const [152] = Utf8 org/osgi/util/tracker/ServiceTracker 
.const [153] = Class [251] 
.const [154] = NameAndType [252] [253] 
.const [155] = Utf8 java/lang/Class 
.const [156] = Utf8 forName 
.const [157] = Utf8 (Ljava/lang/String;)Ljava/lang/Class; 
.const [158] = Utf8 de/audi/app/bap/ecall/ServiceManagerEcall 
.const [159] = Utf8 class$de$audi$atip$interapp$bap$ecall$BAPServiceEcall 
.const [160] = Utf8 Ljava/lang/Class; 
.const [161] = Utf8 de/audi/app/bap/ecall/ServiceManagerEcall 
.const [162] = Utf8 class$ 
.const [163] = Utf8 (Ljava/lang/String;)Ljava/lang/Class; 
.const [164] = Utf8 de/audi/app/bap/ecall/ServiceManagerEcall 
.const [165] = Utf8 class$de$audi$atip$interapp$bap$ecall$BAPServiceEcallListener 
.const [166] = Utf8 Ljava/lang/Class; 
.const [167] = Utf8 de/audi/app/bap/ecall/ServiceManagerEcall 
.const [168] = Utf8 class$de$audi$atip$diag$sw$SwDiagnosisManager 
.const [169] = Utf8 Ljava/lang/Class; 
.const [170] = Utf8 java/lang/NoClassDefFoundError 
.const [171] = Utf8 initCause 
.const [172] = Utf8 (Ljava/lang/Throwable;)Ljava/lang/Throwable; 
.const [173] = Utf8 de/audi/app/bap/fw/AbstractBAPModule 
.const [174] = Utf8 getLogChannel 
.const [175] = Utf8 ()Lde/audi/atip/log/LogChannel; 
.const [176] = Utf8 de/audi/app/bap/ecall/ServiceManagerEcall 
.const [177] = Utf8 logChannel 
.const [178] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [179] = Utf8 de/audi/app/bap/ecall/ServiceManagerEcall 
.const [180] = Utf8 bundleContext 
.const [181] = Utf8 Lorg/osgi/framework/BundleContext; 
.const [182] = Utf8 de/audi/atip/log/LogChannel 
.const [183] = Utf8 log 
.const [184] = Utf8 (ILjava/lang/String;)Z 
.const [185] = Utf8 de/audi/app/bap/ecall/ServiceManagerEcall 
.const [186] = Utf8 'module' 
.const [187] = Utf8 Lde/audi/app/bap/fw/AbstractBAPModule; 
.const [188] = Utf8 de/audi/app/bap/fw/AbstractBAPModule 
.const [189] = Utf8 getAppConnectors 
.const [190] = Utf8 ()Ljava/util/Map; 
.const [191] = Utf8 de/audi/app/bap/ecall/AppConnectorEcall 
.const [192] = Utf8 setAppServiceListener 
.const [193] = Utf8 (Lde/audi/atip/interapp/bap/BAPServiceListener;)V 
.const [194] = Utf8 de/audi/app/bap/fw/AbstractBAPModule 
.const [195] = Utf8 getInitializationManager 
.const [196] = Utf8 ()Lde/audi/app/bap/fw/IBAPModuleInitializationManager; 
.const [197] = Utf8 de/audi/atip/log/LogChannel 
.const [198] = Utf8 log 
.const [199] = Utf8 (ILjava/lang/String;Ljava/lang/Object;)Z 
.const [200] = Utf8 java/lang/Class 
.const [201] = Utf8 getName 
.const [202] = Utf8 ()Ljava/lang/String; 
.const [203] = Utf8 de/audi/atip/activator/AbstractActivator 
.const [204] = Utf8 registerService 
.const [205] = Utf8 (Ljava/lang/String;Ljava/lang/Object;Ljava/util/Dictionary;)V 
.const [206] = Utf8 de/audi/app/bap/ecall/ServiceManagerEcall 
.const [207] = Utf8 serviceTracker 
.const [208] = Utf8 Lorg/osgi/util/tracker/ServiceTracker; 
.const [209] = Utf8 org/osgi/util/tracker/ServiceTracker 
.const [210] = Utf8 'open' 
.const [211] = Utf8 ()V 
.const [212] = Utf8 java/lang/NoClassDefFoundError 
.const [213] = Utf8 <init> 
.const [214] = Utf8 ()V 
.const [215] = Utf8 de/audi/app/bap/fw/AbstractBAPModuleServiceManager 
.const [216] = Utf8 <init> 
.const [217] = Utf8 (Lde/audi/app/bap/fw/AbstractBAPModule;Lorg/osgi/framework/BundleContext;)V 
.const [218] = Utf8 de/audi/app/bap/fw/AbstractBAPModuleServiceManager 
.const [219] = Utf8 addingService 
.const [220] = Utf8 (Lorg/osgi/framework/ServiceReference;)Ljava/lang/Object; 
.const [221] = Utf8 de/audi/app/bap/fw/AbstractBAPModuleServiceManager 
.const [222] = Utf8 removedService 
.const [223] = Utf8 (Lorg/osgi/framework/ServiceReference;Ljava/lang/Object;)V 
.const [224] = Utf8 de/audi/app/bap/ecall/ServiceManagerEcall 
.const [225] = Utf8 class$de$audi$atip$interapp$bap$ecall$BAPServiceEcall 
.const [226] = Utf8 Ljava/lang/Class; 
.const [227] = Utf8 de/audi/app/bap/ecall/ServiceManagerEcall 
.const [228] = Utf8 class$de$audi$atip$interapp$bap$ecall$BAPServiceEcallListener 
.const [229] = Utf8 Ljava/lang/Class; 
.const [230] = Utf8 de/audi/app/bap/ecall/ServiceManagerEcall 
.const [231] = Utf8 class$de$audi$atip$diag$sw$SwDiagnosisManager 
.const [232] = Utf8 Ljava/lang/Class; 
.const [233] = Utf8 org/osgi/util/tracker/ServiceTracker 
.const [234] = Utf8 <init> 
.const [235] = Utf8 (Lorg/osgi/framework/BundleContext;[Ljava/lang/String;Lorg/osgi/util/tracker/ServiceTrackerCustomizer;)V 
.const [236] = Utf8 de/audi/app/bap/ecall/ServiceManagerEcall 
.const [237] = Utf8 logChannel 
.const [238] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [239] = Utf8 org/osgi/framework/BundleContext 
.const [240] = Utf8 getService 
.const [241] = Utf8 (Lorg/osgi/framework/ServiceReference;)Ljava/lang/Object; 
.const [242] = Utf8 java/util/Map 
.const [243] = Utf8 get 
.const [244] = Utf8 (Ljava/lang/Object;)Ljava/lang/Object; 
.const [245] = Utf8 de/audi/app/bap/fw/IBAPModuleInitializationManager 
.const [246] = Utf8 notifyAppServiceChanged 
.const [247] = Utf8 (Z)V 
.const [248] = Utf8 org/osgi/framework/BundleContext 
.const [249] = Utf8 ungetService 
.const [250] = Utf8 (Lorg/osgi/framework/ServiceReference;)Z 
.const [251] = Utf8 de/audi/app/bap/ecall/ServiceManagerEcall 
.const [252] = Utf8 serviceTracker 
.const [253] = Utf8 Lorg/osgi/util/tracker/ServiceTracker; 
.const [254] = Utf8 de/audi/app/bap/ecall/ServiceManagerEcall 
.const [255] = Class [254] 
.const [256] = Utf8 de/audi/app/bap/fw/AbstractBAPModuleServiceManager 
.const [257] = Class [256] 
.const [258] = Utf8 logChannel 
.const [259] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [260] = Utf8 class$de$audi$atip$interapp$bap$ecall$BAPServiceEcall 
.const [261] = Utf8 Ljava/lang/Class; 
.const [262] = Utf8 class$de$audi$atip$interapp$bap$ecall$BAPServiceEcallListener 
.const [263] = Utf8 Ljava/lang/Class; 
.const [264] = Utf8 class$de$audi$atip$diag$sw$SwDiagnosisManager 
.const [265] = Utf8 Ljava/lang/Class; 
.const [266] = Utf8 Code 
.const [267] = Utf8 <init> 
.const [268] = Utf8 (Lde/audi/app/bap/fw/AbstractBAPModule;Lorg/osgi/framework/BundleContext;)V 
.const [269] = Utf8 addingService 
.const [270] = Utf8 (Lorg/osgi/framework/ServiceReference;)Ljava/lang/Object; 
.const [271] = Utf8 removedService 
.const [272] = Utf8 (Lorg/osgi/framework/ServiceReference;Ljava/lang/Object;)V 
.const [273] = Utf8 registerServices 
.const [274] = Utf8 (Lde/audi/atip/activator/AbstractActivator;)V 
.const [275] = Utf8 trackServices 
.const [276] = Utf8 ()V 
.const [277] = Utf8 class$ 
.const [278] = Utf8 (Ljava/lang/String;)Ljava/lang/Class; 
.end class 
