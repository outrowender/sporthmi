.version 50 0 
.class public super [254] 
.super [256] 
.field private final [257] [258] 
.field static synthetic [259] [260] 
.field static synthetic [261] [262] 
.field static synthetic [263] [264] 
.field static synthetic [265] [266] 

.method public [268] : [269] 
    .attribute [267] .code stack 3 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     aload_2 
L3:     invokespecial [47] 
L6:     aload_0 
L7:     aload_1 
L8:     invokevirtual [34] 
L11:    putfield [56] 
L14:    return 
L15:    nop 
L16:    
    .end code 
.end method 

.method public [270] : [271] 
    .attribute [267] .code stack 3 locals 1 
L0:     aload_0 
L1:     getfield [36] 
L4:     aload_1 
L5:     invokeinterface [57] 0 
L10:    astore_2 
L11:    aload_2 
L12:    instanceof [5] 
L15:    ifeq L56 
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
L48:    checkcast [5] 
L51:    invokevirtual [40] 
L54:    aload_2 
L55:    areturn 
L56:    aload_0 
L57:    getfield [36] 
L60:    aload_1 
L61:    invokeinterface [59] 0 
L66:    pop 
L67:    aload_0 
L68:    aload_1 
L69:    invokespecial [48] 
L72:    areturn 
L73:    nop 
L74:    nop 
L75:    nop 
L76:    
    .end code 
.end method 

.method public [272] : [273] 
    .attribute [267] .code stack 3 locals 0 
L0:     aload_2 
L1:     instanceof [5] 
L4:     ifeq L54 
L7:     aload_0 
L8:     getfield [35] 
L11:    ldc [6] 
L13:    ldc [10] 
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
L45:    invokeinterface [59] 0 
L50:    pop 
L51:    goto L60 
L54:    aload_0 
L55:    aload_1 
L56:    aload_2 
L57:    invokespecial [49] 
L60:    return 
L61:    nop 
L62:    nop 
L63:    nop 
L64:    
    .end code 
.end method 

.method public [274] : [275] 
    .attribute [267] .code stack 4 locals 0 
L0:     aload_0 
L1:     getfield [35] 
L4:     ldc [6] 
L6:     ldc [11] 
L8:     invokevirtual [37] 
L11:    pop 
L12:    aload_1 
L13:    getstatic [12] 
L16:    ifnonnull L31 
L19:    ldc [13] 
L21:    invokestatic [14] 
L24:    dup 
L25:    putstatic [50] 
L28:    goto L34 
L31:    getstatic [12] 
L34:    invokevirtual [41] 
L37:    aload_0 
L38:    getfield [38] 
L41:    invokevirtual [39] 
L44:    ldc [8] 
L46:    invokeinterface [58] 0 
L51:    aconst_null 
L52:    invokevirtual [42] 
L55:    aload_0 
L56:    getfield [35] 
L59:    ldc [6] 
L61:    ldc [15] 
L63:    invokevirtual [37] 
L66:    pop 
L67:    aload_1 
L68:    getstatic [16] 
L71:    ifnonnull L86 
L74:    ldc [17] 
L76:    invokestatic [14] 
L79:    dup 
L80:    putstatic [51] 
L83:    goto L89 
L86:    getstatic [16] 
L89:    invokevirtual [41] 
L92:    aload_0 
L93:    getfield [38] 
L96:    invokevirtual [43] 
L99:    aconst_null 
L100:   invokevirtual [42] 
L103:   return 
L104:   
    .end code 
.end method 

.method public [276] : [277] 
    .attribute [267] .code stack 6 locals 1 
L0:     iconst_2 
L1:     anewarray [18] 
L4:     dup 
L5:     iconst_0 
L6:     getstatic [19] 
L9:     ifnonnull L24 
L12:    ldc [20] 
L14:    invokestatic [14] 
L17:    dup 
L18:    putstatic [52] 
L21:    goto L27 
L24:    getstatic [19] 
L27:    invokevirtual [41] 
L30:    aastore 
L31:    dup 
L32:    iconst_1 
L33:    getstatic [21] 
L36:    ifnonnull L51 
L39:    ldc [22] 
L41:    invokestatic [14] 
L44:    dup 
L45:    putstatic [53] 
L48:    goto L54 
L51:    getstatic [21] 
L54:    invokevirtual [41] 
L57:    aastore 
L58:    astore_1 
L59:    aload_0 
L60:    new [60] 
L63:    dup 
L64:    aload_0 
L65:    getfield [36] 
L68:    aload_1 
L69:    aload_0 
L70:    invokespecial [54] 
L73:    putfield [61] 
L76:    aload_0 
L77:    getfield [44] 
L80:    invokevirtual [45] 
L83:    return 
L84:    
    .end code 
.end method 

.method static synthetic [278] : [279] 
    .attribute [267] .code stack 2 locals 1 
        .catch [3] from L0 to L4 using L5 
L0:     aload_0 
L1:     invokestatic [2] 
L4:     areturn 
L5:     astore_1 
L6:     new [55] 
L9:     dup 
L10:    invokespecial [46] 
L13:    aload_1 
L14:    invokevirtual [33] 
L17:    athrow 
L18:    nop 
L19:    nop 
L20:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Method [62] [63] 
.const [3] = Class [64] 
.const [4] = Class [65] 
.const [5] = Class [66] 
.const [6] = Int -2137614336 
.const [7] = String [67] 
.const [8] = String [68] 
.const [9] = Class [69] 
.const [10] = String [70] 
.const [11] = String [71] 
.const [12] = Field [72] [73] 
.const [13] = String [74] 
.const [14] = Method [75] [76] 
.const [15] = String [77] 
.const [16] = Field [78] [79] 
.const [17] = String [80] 
.const [18] = Class [81] 
.const [19] = Field [82] [83] 
.const [20] = String [84] 
.const [21] = Field [85] [86] 
.const [22] = String [87] 
.const [23] = Class [88] 
.const [24] = Class [89] 
.const [25] = Class [90] 
.const [26] = Class [91] 
.const [27] = Class [92] 
.const [28] = Class [93] 
.const [29] = Class [94] 
.const [30] = Class [95] 
.const [31] = Class [96] 
.const [32] = Class [97] 
.const [33] = Method [98] [99] 
.const [34] = Method [100] [101] 
.const [35] = Field [102] [103] 
.const [36] = Field [104] [105] 
.const [37] = Method [106] [107] 
.const [38] = Field [108] [109] 
.const [39] = Method [110] [111] 
.const [40] = Method [112] [113] 
.const [41] = Method [114] [115] 
.const [42] = Method [116] [117] 
.const [43] = Method [118] [119] 
.const [44] = Field [120] [121] 
.const [45] = Method [122] [123] 
.const [46] = Method [124] [125] 
.const [47] = Method [126] [127] 
.const [48] = Method [128] [129] 
.const [49] = Method [130] [131] 
.const [50] = Field [132] [133] 
.const [51] = Field [134] [135] 
.const [52] = Field [136] [137] 
.const [53] = Field [138] [139] 
.const [54] = Method [140] [141] 
.const [55] = Class [142] 
.const [56] = Field [143] [144] 
.const [57] = InterfaceMethod [145] [146] 
.const [58] = InterfaceMethod [147] [148] 
.const [59] = InterfaceMethod [149] [150] 
.const [60] = Class [151] 
.const [61] = Field [152] [153] 
.const [62] = Class [154] 
.const [63] = NameAndType [155] [156] 
.const [64] = Utf8 java/lang/ClassNotFoundException 
.const [65] = Utf8 java/lang/NoClassDefFoundError 
.const [66] = Utf8 de/audi/atip/interapp/combi/bap/phone/CombiBAPServicePhone2Listener 
.const [67] = Utf8 '[ServiceManagerPhone2#addingService] CombiBAPServicePhoneListener found' 
.const [68] = Utf8 Phone 
.const [69] = Utf8 de/audi/app/combi/bap/app/phone2/AppConnectorPhone2 
.const [70] = Utf8 '[ServiceManagerPhone2#removedService] CombiBAPServicePhoneListener removed' 
.const [71] = Utf8 '[ServiceManagerPhone2#registerServices] Registering AppConnectorPhone as CombiBAPServicePhone' 
.const [72] = Class [157] 
.const [73] = NameAndType [158] [159] 
.const [74] = Utf8 'de.audi.atip.interapp.combi.bap.phone.CombiBAPServicePhone2' 
.const [75] = Class [160] 
.const [76] = NameAndType [161] [162] 
.const [77] = Utf8 '[ServiceManagerPhone2#registerServices] Registering InitializationManagerPhone2 as MessageListener' 
.const [78] = Class [163] 
.const [79] = NameAndType [164] [165] 
.const [80] = Utf8 'de.audi.atip.msg.MsgListener' 
.const [81] = Utf8 java/lang/String 
.const [82] = Class [166] 
.const [83] = NameAndType [167] [168] 
.const [84] = Utf8 'de.audi.atip.interapp.combi.bap.phone.CombiBAPServicePhone2Listener' 
.const [85] = Class [169] 
.const [86] = NameAndType [170] [171] 
.const [87] = Utf8 'de.audi.atip.diag.sw.SwDiagnosisManager' 
.const [88] = Utf8 org/osgi/util/tracker/ServiceTracker 
.const [89] = Utf8 de/audi/app/combi/bap/app/phone2/ServiceManagerPhone2 
.const [90] = Utf8 de/audi/app/bap/fw/AbstractBAPModuleServiceManager 
.const [91] = Utf8 java/lang/Class 
.const [92] = Utf8 de/audi/app/combi/bap/fw/AbstractCombiModule 
.const [93] = Utf8 org/osgi/framework/BundleContext 
.const [94] = Utf8 de/audi/atip/log/LogChannel 
.const [95] = Utf8 de/audi/app/bap/fw/AbstractBAPModule 
.const [96] = Utf8 java/util/Map 
.const [97] = Utf8 de/audi/atip/activator/AbstractActivator 
.const [98] = Class [172] 
.const [99] = NameAndType [173] [174] 
.const [100] = Class [175] 
.const [101] = NameAndType [176] [177] 
.const [102] = Class [178] 
.const [103] = NameAndType [179] [180] 
.const [104] = Class [181] 
.const [105] = NameAndType [182] [183] 
.const [106] = Class [184] 
.const [107] = NameAndType [185] [186] 
.const [108] = Class [187] 
.const [109] = NameAndType [188] [189] 
.const [110] = Class [190] 
.const [111] = NameAndType [191] [192] 
.const [112] = Class [193] 
.const [113] = NameAndType [194] [195] 
.const [114] = Class [196] 
.const [115] = NameAndType [197] [198] 
.const [116] = Class [199] 
.const [117] = NameAndType [200] [201] 
.const [118] = Class [202] 
.const [119] = NameAndType [203] [204] 
.const [120] = Class [205] 
.const [121] = NameAndType [206] [207] 
.const [122] = Class [208] 
.const [123] = NameAndType [209] [210] 
.const [124] = Class [211] 
.const [125] = NameAndType [212] [213] 
.const [126] = Class [214] 
.const [127] = NameAndType [215] [216] 
.const [128] = Class [217] 
.const [129] = NameAndType [218] [219] 
.const [130] = Class [220] 
.const [131] = NameAndType [221] [222] 
.const [132] = Class [223] 
.const [133] = NameAndType [224] [225] 
.const [134] = Class [226] 
.const [135] = NameAndType [227] [228] 
.const [136] = Class [229] 
.const [137] = NameAndType [230] [231] 
.const [138] = Class [232] 
.const [139] = NameAndType [233] [234] 
.const [140] = Class [235] 
.const [141] = NameAndType [236] [237] 
.const [142] = Utf8 java/lang/NoClassDefFoundError 
.const [143] = Class [238] 
.const [144] = NameAndType [239] [240] 
.const [145] = Class [241] 
.const [146] = NameAndType [242] [243] 
.const [147] = Class [244] 
.const [148] = NameAndType [245] [246] 
.const [149] = Class [247] 
.const [150] = NameAndType [248] [249] 
.const [151] = Utf8 org/osgi/util/tracker/ServiceTracker 
.const [152] = Class [250] 
.const [153] = NameAndType [251] [252] 
.const [154] = Utf8 java/lang/Class 
.const [155] = Utf8 forName 
.const [156] = Utf8 (Ljava/lang/String;)Ljava/lang/Class; 
.const [157] = Utf8 de/audi/app/combi/bap/app/phone2/ServiceManagerPhone2 
.const [158] = Utf8 class$de$audi$atip$interapp$combi$bap$phone$CombiBAPServicePhone2 
.const [159] = Utf8 Ljava/lang/Class; 
.const [160] = Utf8 de/audi/app/combi/bap/app/phone2/ServiceManagerPhone2 
.const [161] = Utf8 class$ 
.const [162] = Utf8 (Ljava/lang/String;)Ljava/lang/Class; 
.const [163] = Utf8 de/audi/app/combi/bap/app/phone2/ServiceManagerPhone2 
.const [164] = Utf8 class$de$audi$atip$msg$MsgListener 
.const [165] = Utf8 Ljava/lang/Class; 
.const [166] = Utf8 de/audi/app/combi/bap/app/phone2/ServiceManagerPhone2 
.const [167] = Utf8 class$de$audi$atip$interapp$combi$bap$phone$CombiBAPServicePhone2Listener 
.const [168] = Utf8 Ljava/lang/Class; 
.const [169] = Utf8 de/audi/app/combi/bap/app/phone2/ServiceManagerPhone2 
.const [170] = Utf8 class$de$audi$atip$diag$sw$SwDiagnosisManager 
.const [171] = Utf8 Ljava/lang/Class; 
.const [172] = Utf8 java/lang/NoClassDefFoundError 
.const [173] = Utf8 initCause 
.const [174] = Utf8 (Ljava/lang/Throwable;)Ljava/lang/Throwable; 
.const [175] = Utf8 de/audi/app/combi/bap/fw/AbstractCombiModule 
.const [176] = Utf8 getLogChannel 
.const [177] = Utf8 ()Lde/audi/atip/log/LogChannel; 
.const [178] = Utf8 de/audi/app/combi/bap/app/phone2/ServiceManagerPhone2 
.const [179] = Utf8 logChannel 
.const [180] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [181] = Utf8 de/audi/app/combi/bap/app/phone2/ServiceManagerPhone2 
.const [182] = Utf8 bundleContext 
.const [183] = Utf8 Lorg/osgi/framework/BundleContext; 
.const [184] = Utf8 de/audi/atip/log/LogChannel 
.const [185] = Utf8 log 
.const [186] = Utf8 (ILjava/lang/String;)Z 
.const [187] = Utf8 de/audi/app/combi/bap/app/phone2/ServiceManagerPhone2 
.const [188] = Utf8 'module' 
.const [189] = Utf8 Lde/audi/app/bap/fw/AbstractBAPModule; 
.const [190] = Utf8 de/audi/app/bap/fw/AbstractBAPModule 
.const [191] = Utf8 getAppConnectors 
.const [192] = Utf8 ()Ljava/util/Map; 
.const [193] = Utf8 de/audi/app/combi/bap/app/phone2/AppConnectorPhone2 
.const [194] = Utf8 setAppServiceListener 
.const [195] = Utf8 (Lde/audi/atip/interapp/bap/BAPServiceListener;)V 
.const [196] = Utf8 java/lang/Class 
.const [197] = Utf8 getName 
.const [198] = Utf8 ()Ljava/lang/String; 
.const [199] = Utf8 de/audi/atip/activator/AbstractActivator 
.const [200] = Utf8 registerService 
.const [201] = Utf8 (Ljava/lang/String;Ljava/lang/Object;Ljava/util/Dictionary;)V 
.const [202] = Utf8 de/audi/app/bap/fw/AbstractBAPModule 
.const [203] = Utf8 getInitializationManager 
.const [204] = Utf8 ()Lde/audi/app/bap/fw/IBAPModuleInitializationManager; 
.const [205] = Utf8 de/audi/app/combi/bap/app/phone2/ServiceManagerPhone2 
.const [206] = Utf8 serviceTracker 
.const [207] = Utf8 Lorg/osgi/util/tracker/ServiceTracker; 
.const [208] = Utf8 org/osgi/util/tracker/ServiceTracker 
.const [209] = Utf8 'open' 
.const [210] = Utf8 ()V 
.const [211] = Utf8 java/lang/NoClassDefFoundError 
.const [212] = Utf8 <init> 
.const [213] = Utf8 ()V 
.const [214] = Utf8 de/audi/app/bap/fw/AbstractBAPModuleServiceManager 
.const [215] = Utf8 <init> 
.const [216] = Utf8 (Lde/audi/app/bap/fw/AbstractBAPModule;Lorg/osgi/framework/BundleContext;)V 
.const [217] = Utf8 de/audi/app/bap/fw/AbstractBAPModuleServiceManager 
.const [218] = Utf8 addingService 
.const [219] = Utf8 (Lorg/osgi/framework/ServiceReference;)Ljava/lang/Object; 
.const [220] = Utf8 de/audi/app/bap/fw/AbstractBAPModuleServiceManager 
.const [221] = Utf8 removedService 
.const [222] = Utf8 (Lorg/osgi/framework/ServiceReference;Ljava/lang/Object;)V 
.const [223] = Utf8 de/audi/app/combi/bap/app/phone2/ServiceManagerPhone2 
.const [224] = Utf8 class$de$audi$atip$interapp$combi$bap$phone$CombiBAPServicePhone2 
.const [225] = Utf8 Ljava/lang/Class; 
.const [226] = Utf8 de/audi/app/combi/bap/app/phone2/ServiceManagerPhone2 
.const [227] = Utf8 class$de$audi$atip$msg$MsgListener 
.const [228] = Utf8 Ljava/lang/Class; 
.const [229] = Utf8 de/audi/app/combi/bap/app/phone2/ServiceManagerPhone2 
.const [230] = Utf8 class$de$audi$atip$interapp$combi$bap$phone$CombiBAPServicePhone2Listener 
.const [231] = Utf8 Ljava/lang/Class; 
.const [232] = Utf8 de/audi/app/combi/bap/app/phone2/ServiceManagerPhone2 
.const [233] = Utf8 class$de$audi$atip$diag$sw$SwDiagnosisManager 
.const [234] = Utf8 Ljava/lang/Class; 
.const [235] = Utf8 org/osgi/util/tracker/ServiceTracker 
.const [236] = Utf8 <init> 
.const [237] = Utf8 (Lorg/osgi/framework/BundleContext;[Ljava/lang/String;Lorg/osgi/util/tracker/ServiceTrackerCustomizer;)V 
.const [238] = Utf8 de/audi/app/combi/bap/app/phone2/ServiceManagerPhone2 
.const [239] = Utf8 logChannel 
.const [240] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [241] = Utf8 org/osgi/framework/BundleContext 
.const [242] = Utf8 getService 
.const [243] = Utf8 (Lorg/osgi/framework/ServiceReference;)Ljava/lang/Object; 
.const [244] = Utf8 java/util/Map 
.const [245] = Utf8 get 
.const [246] = Utf8 (Ljava/lang/Object;)Ljava/lang/Object; 
.const [247] = Utf8 org/osgi/framework/BundleContext 
.const [248] = Utf8 ungetService 
.const [249] = Utf8 (Lorg/osgi/framework/ServiceReference;)Z 
.const [250] = Utf8 de/audi/app/combi/bap/app/phone2/ServiceManagerPhone2 
.const [251] = Utf8 serviceTracker 
.const [252] = Utf8 Lorg/osgi/util/tracker/ServiceTracker; 
.const [253] = Utf8 de/audi/app/combi/bap/app/phone2/ServiceManagerPhone2 
.const [254] = Class [253] 
.const [255] = Utf8 de/audi/app/bap/fw/AbstractBAPModuleServiceManager 
.const [256] = Class [255] 
.const [257] = Utf8 logChannel 
.const [258] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [259] = Utf8 class$de$audi$atip$interapp$combi$bap$phone$CombiBAPServicePhone2 
.const [260] = Utf8 Ljava/lang/Class; 
.const [261] = Utf8 class$de$audi$atip$msg$MsgListener 
.const [262] = Utf8 Ljava/lang/Class; 
.const [263] = Utf8 class$de$audi$atip$interapp$combi$bap$phone$CombiBAPServicePhone2Listener 
.const [264] = Utf8 Ljava/lang/Class; 
.const [265] = Utf8 class$de$audi$atip$diag$sw$SwDiagnosisManager 
.const [266] = Utf8 Ljava/lang/Class; 
.const [267] = Utf8 Code 
.const [268] = Utf8 <init> 
.const [269] = Utf8 (Lde/audi/app/combi/bap/fw/AbstractCombiModule;Lorg/osgi/framework/BundleContext;)V 
.const [270] = Utf8 addingService 
.const [271] = Utf8 (Lorg/osgi/framework/ServiceReference;)Ljava/lang/Object; 
.const [272] = Utf8 removedService 
.const [273] = Utf8 (Lorg/osgi/framework/ServiceReference;Ljava/lang/Object;)V 
.const [274] = Utf8 registerServices 
.const [275] = Utf8 (Lde/audi/atip/activator/AbstractActivator;)V 
.const [276] = Utf8 trackServices 
.const [277] = Utf8 ()V 
.const [278] = Utf8 class$ 
.const [279] = Utf8 (Ljava/lang/String;)Ljava/lang/Class; 
.end class 
