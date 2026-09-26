.version 50 0 
.class public super [266] 
.super [268] 
.field private final [269] [270] 
.field static synthetic [271] [272] 
.field static synthetic [273] [274] 
.field static synthetic [275] [276] 
.field static synthetic [277] [278] 

.method public [280] : [281] 
    .attribute [279] .code stack 3 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     aload_2 
L3:     invokespecial [51] 
L6:     aload_0 
L7:     aload_1 
L8:     invokevirtual [37] 
L11:    putfield [60] 
L14:    return 
L15:    nop 
L16:    
    .end code 
.end method 

.method public [282] : [283] 
    .attribute [279] .code stack 3 locals 1 
L0:     aload_0 
L1:     getfield [39] 
L4:     aload_1 
L5:     invokeinterface [61] 0 
L10:    astore_2 
L11:    aload_2 
L12:    instanceof [5] 
L15:    ifeq L56 
L18:    aload_0 
L19:    getfield [38] 
L22:    ldc [6] 
L24:    ldc [7] 
L26:    invokevirtual [40] 
L29:    pop 
L30:    aload_0 
L31:    getfield [41] 
L34:    invokevirtual [42] 
L37:    ldc [8] 
L39:    invokeinterface [62] 0 
L44:    checkcast [9] 
L47:    aload_2 
L48:    checkcast [5] 
L51:    invokevirtual [43] 
L54:    aload_2 
L55:    areturn 
L56:    aload_2 
L57:    instanceof [10] 
L60:    ifeq L91 
L63:    aload_0 
L64:    getfield [38] 
L67:    ldc [6] 
L69:    ldc [11] 
L71:    invokevirtual [40] 
L74:    pop 
L75:    aload_0 
L76:    getfield [41] 
L79:    checkcast [12] 
L82:    aload_2 
L83:    checkcast [10] 
L86:    invokevirtual [44] 
L89:    aload_2 
L90:    areturn 
L91:    aload_0 
L92:    getfield [39] 
L95:    aload_1 
L96:    invokeinterface [63] 0 
L101:   pop 
L102:   aload_0 
L103:   aload_1 
L104:   invokespecial [52] 
L107:   areturn 
L108:   
    .end code 
.end method 

.method public [284] : [285] 
    .attribute [279] .code stack 3 locals 0 
L0:     aload_2 
L1:     instanceof [5] 
L4:     ifeq L54 
L7:     aload_0 
L8:     getfield [38] 
L11:    ldc [6] 
L13:    ldc [13] 
L15:    invokevirtual [40] 
L18:    pop 
L19:    aload_0 
L20:    getfield [41] 
L23:    invokevirtual [42] 
L26:    ldc [8] 
L28:    invokeinterface [62] 0 
L33:    checkcast [9] 
L36:    aconst_null 
L37:    invokevirtual [43] 
L40:    aload_0 
L41:    getfield [39] 
L44:    aload_1 
L45:    invokeinterface [63] 0 
L50:    pop 
L51:    goto L60 
L54:    aload_0 
L55:    aload_1 
L56:    aload_2 
L57:    invokespecial [53] 
L60:    return 
L61:    nop 
L62:    nop 
L63:    nop 
L64:    
    .end code 
.end method 

.method public [286] : [287] 
    .attribute [279] .code stack 4 locals 0 
L0:     aload_0 
L1:     getfield [38] 
L4:     ldc [6] 
L6:     ldc [14] 
L8:     invokevirtual [40] 
L11:    pop 
L12:    aload_1 
L13:    getstatic [15] 
L16:    ifnonnull L31 
L19:    ldc [16] 
L21:    invokestatic [17] 
L24:    dup 
L25:    putstatic [54] 
L28:    goto L34 
L31:    getstatic [15] 
L34:    invokevirtual [45] 
L37:    aload_0 
L38:    getfield [41] 
L41:    invokevirtual [42] 
L44:    ldc [8] 
L46:    invokeinterface [62] 0 
L51:    aconst_null 
L52:    invokevirtual [46] 
L55:    aload_0 
L56:    getfield [38] 
L59:    ldc [6] 
L61:    ldc [18] 
L63:    invokevirtual [40] 
L66:    pop 
L67:    aload_1 
L68:    getstatic [19] 
L71:    ifnonnull L86 
L74:    ldc [20] 
L76:    invokestatic [17] 
L79:    dup 
L80:    putstatic [55] 
L83:    goto L89 
L86:    getstatic [19] 
L89:    invokevirtual [45] 
L92:    aload_0 
L93:    getfield [41] 
L96:    invokevirtual [47] 
L99:    aconst_null 
L100:   invokevirtual [46] 
L103:   return 
L104:   
    .end code 
.end method 

.method public [288] : [289] 
    .attribute [279] .code stack 6 locals 1 
L0:     iconst_2 
L1:     anewarray [21] 
L4:     dup 
L5:     iconst_0 
L6:     getstatic [22] 
L9:     ifnonnull L24 
L12:    ldc [23] 
L14:    invokestatic [17] 
L17:    dup 
L18:    putstatic [56] 
L21:    goto L27 
L24:    getstatic [22] 
L27:    invokevirtual [45] 
L30:    aastore 
L31:    dup 
L32:    iconst_1 
L33:    getstatic [24] 
L36:    ifnonnull L51 
L39:    ldc [25] 
L41:    invokestatic [17] 
L44:    dup 
L45:    putstatic [57] 
L48:    goto L54 
L51:    getstatic [24] 
L54:    invokevirtual [45] 
L57:    aastore 
L58:    astore_1 
L59:    aload_0 
L60:    new [64] 
L63:    dup 
L64:    aload_0 
L65:    getfield [39] 
L68:    aload_1 
L69:    aload_0 
L70:    invokespecial [58] 
L73:    putfield [65] 
L76:    aload_0 
L77:    getfield [48] 
L80:    invokevirtual [49] 
L83:    return 
L84:    
    .end code 
.end method 

.method static synthetic [290] : [291] 
    .attribute [279] .code stack 2 locals 1 
        .catch [3] from L0 to L4 using L5 
L0:     aload_0 
L1:     invokestatic [2] 
L4:     areturn 
L5:     astore_1 
L6:     new [59] 
L9:     dup 
L10:    invokespecial [50] 
L13:    aload_1 
L14:    invokevirtual [36] 
L17:    athrow 
L18:    nop 
L19:    nop 
L20:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Method [66] [67] 
.const [3] = Class [68] 
.const [4] = Class [69] 
.const [5] = Class [70] 
.const [6] = Int -2137614336 
.const [7] = String [71] 
.const [8] = String [72] 
.const [9] = Class [73] 
.const [10] = Class [74] 
.const [11] = String [75] 
.const [12] = Class [76] 
.const [13] = String [77] 
.const [14] = String [78] 
.const [15] = Field [79] [80] 
.const [16] = String [81] 
.const [17] = Method [82] [83] 
.const [18] = String [84] 
.const [19] = Field [85] [86] 
.const [20] = String [87] 
.const [21] = Class [88] 
.const [22] = Field [89] [90] 
.const [23] = String [91] 
.const [24] = Field [92] [93] 
.const [25] = String [94] 
.const [26] = Class [95] 
.const [27] = Class [96] 
.const [28] = Class [97] 
.const [29] = Class [98] 
.const [30] = Class [99] 
.const [31] = Class [100] 
.const [32] = Class [101] 
.const [33] = Class [102] 
.const [34] = Class [103] 
.const [35] = Class [104] 
.const [36] = Method [105] [106] 
.const [37] = Method [107] [108] 
.const [38] = Field [109] [110] 
.const [39] = Field [111] [112] 
.const [40] = Method [113] [114] 
.const [41] = Field [115] [116] 
.const [42] = Method [117] [118] 
.const [43] = Method [119] [120] 
.const [44] = Method [121] [122] 
.const [45] = Method [123] [124] 
.const [46] = Method [125] [126] 
.const [47] = Method [127] [128] 
.const [48] = Field [129] [130] 
.const [49] = Method [131] [132] 
.const [50] = Method [133] [134] 
.const [51] = Method [135] [136] 
.const [52] = Method [137] [138] 
.const [53] = Method [139] [140] 
.const [54] = Field [141] [142] 
.const [55] = Field [143] [144] 
.const [56] = Field [145] [146] 
.const [57] = Field [147] [148] 
.const [58] = Method [149] [150] 
.const [59] = Class [151] 
.const [60] = Field [152] [153] 
.const [61] = InterfaceMethod [154] [155] 
.const [62] = InterfaceMethod [156] [157] 
.const [63] = InterfaceMethod [158] [159] 
.const [64] = Class [160] 
.const [65] = Field [161] [162] 
.const [66] = Class [163] 
.const [67] = NameAndType [164] [165] 
.const [68] = Utf8 java/lang/ClassNotFoundException 
.const [69] = Utf8 java/lang/NoClassDefFoundError 
.const [70] = Utf8 de/audi/atip/interapp/combi/bap/navi/CombiBAPServiceNaviListener 
.const [71] = Utf8 '[ServiceManagerNavi#addingService] CombiBAPServiceNaviListener found' 
.const [72] = Utf8 Navi 
.const [73] = Utf8 de/audi/app/combi/bap/app/navi/AppConnectorNavi 
.const [74] = Utf8 de/audi/atip/interapp/ExternalKeyListener 
.const [75] = Utf8 '[ServiceManagerNavi#addingService] ExternalKeyListener found' 
.const [76] = Utf8 de/audi/app/combi/bap/app/navi/CombiModuleNavi 
.const [77] = Utf8 '[ServiceManagerNavi#removedService] CombiBAPServiceNaviListener removed' 
.const [78] = Utf8 '[ServiceManagerNavi#registerServices] Registering AppConnectorNavi as CombiBAPServiceNavi' 
.const [79] = Class [166] 
.const [80] = NameAndType [167] [168] 
.const [81] = Utf8 'de.audi.atip.interapp.combi.bap.navi.CombiBAPServiceNavi' 
.const [82] = Class [169] 
.const [83] = NameAndType [170] [171] 
.const [84] = Utf8 '[ServiceManagerNavi#registerServices] Registering InitializationManagerNavi as MessageListener' 
.const [85] = Class [172] 
.const [86] = NameAndType [173] [174] 
.const [87] = Utf8 'de.audi.atip.msg.MsgListener' 
.const [88] = Utf8 java/lang/String 
.const [89] = Class [175] 
.const [90] = NameAndType [176] [177] 
.const [91] = Utf8 'de.audi.atip.interapp.combi.bap.navi.CombiBAPServiceNaviListener' 
.const [92] = Class [178] 
.const [93] = NameAndType [179] [180] 
.const [94] = Utf8 'de.audi.atip.diag.sw.SwDiagnosisManager' 
.const [95] = Utf8 org/osgi/util/tracker/ServiceTracker 
.const [96] = Utf8 de/audi/app/combi/bap/app/navi/ServiceManagerNavi 
.const [97] = Utf8 de/audi/app/bap/fw/AbstractBAPModuleServiceManager 
.const [98] = Utf8 java/lang/Class 
.const [99] = Utf8 de/audi/app/combi/bap/fw/AbstractCombiModule 
.const [100] = Utf8 org/osgi/framework/BundleContext 
.const [101] = Utf8 de/audi/atip/log/LogChannel 
.const [102] = Utf8 de/audi/app/bap/fw/AbstractBAPModule 
.const [103] = Utf8 java/util/Map 
.const [104] = Utf8 de/audi/atip/activator/AbstractActivator 
.const [105] = Class [181] 
.const [106] = NameAndType [182] [183] 
.const [107] = Class [184] 
.const [108] = NameAndType [185] [186] 
.const [109] = Class [187] 
.const [110] = NameAndType [188] [189] 
.const [111] = Class [190] 
.const [112] = NameAndType [191] [192] 
.const [113] = Class [193] 
.const [114] = NameAndType [194] [195] 
.const [115] = Class [196] 
.const [116] = NameAndType [197] [198] 
.const [117] = Class [199] 
.const [118] = NameAndType [200] [201] 
.const [119] = Class [202] 
.const [120] = NameAndType [203] [204] 
.const [121] = Class [205] 
.const [122] = NameAndType [206] [207] 
.const [123] = Class [208] 
.const [124] = NameAndType [209] [210] 
.const [125] = Class [211] 
.const [126] = NameAndType [212] [213] 
.const [127] = Class [214] 
.const [128] = NameAndType [215] [216] 
.const [129] = Class [217] 
.const [130] = NameAndType [218] [219] 
.const [131] = Class [220] 
.const [132] = NameAndType [221] [222] 
.const [133] = Class [223] 
.const [134] = NameAndType [224] [225] 
.const [135] = Class [226] 
.const [136] = NameAndType [227] [228] 
.const [137] = Class [229] 
.const [138] = NameAndType [230] [231] 
.const [139] = Class [232] 
.const [140] = NameAndType [233] [234] 
.const [141] = Class [235] 
.const [142] = NameAndType [236] [237] 
.const [143] = Class [238] 
.const [144] = NameAndType [239] [240] 
.const [145] = Class [241] 
.const [146] = NameAndType [242] [243] 
.const [147] = Class [244] 
.const [148] = NameAndType [245] [246] 
.const [149] = Class [247] 
.const [150] = NameAndType [248] [249] 
.const [151] = Utf8 java/lang/NoClassDefFoundError 
.const [152] = Class [250] 
.const [153] = NameAndType [251] [252] 
.const [154] = Class [253] 
.const [155] = NameAndType [254] [255] 
.const [156] = Class [256] 
.const [157] = NameAndType [257] [258] 
.const [158] = Class [259] 
.const [159] = NameAndType [260] [261] 
.const [160] = Utf8 org/osgi/util/tracker/ServiceTracker 
.const [161] = Class [262] 
.const [162] = NameAndType [263] [264] 
.const [163] = Utf8 java/lang/Class 
.const [164] = Utf8 forName 
.const [165] = Utf8 (Ljava/lang/String;)Ljava/lang/Class; 
.const [166] = Utf8 de/audi/app/combi/bap/app/navi/ServiceManagerNavi 
.const [167] = Utf8 class$de$audi$atip$interapp$combi$bap$navi$CombiBAPServiceNavi 
.const [168] = Utf8 Ljava/lang/Class; 
.const [169] = Utf8 de/audi/app/combi/bap/app/navi/ServiceManagerNavi 
.const [170] = Utf8 class$ 
.const [171] = Utf8 (Ljava/lang/String;)Ljava/lang/Class; 
.const [172] = Utf8 de/audi/app/combi/bap/app/navi/ServiceManagerNavi 
.const [173] = Utf8 class$de$audi$atip$msg$MsgListener 
.const [174] = Utf8 Ljava/lang/Class; 
.const [175] = Utf8 de/audi/app/combi/bap/app/navi/ServiceManagerNavi 
.const [176] = Utf8 class$de$audi$atip$interapp$combi$bap$navi$CombiBAPServiceNaviListener 
.const [177] = Utf8 Ljava/lang/Class; 
.const [178] = Utf8 de/audi/app/combi/bap/app/navi/ServiceManagerNavi 
.const [179] = Utf8 class$de$audi$atip$diag$sw$SwDiagnosisManager 
.const [180] = Utf8 Ljava/lang/Class; 
.const [181] = Utf8 java/lang/NoClassDefFoundError 
.const [182] = Utf8 initCause 
.const [183] = Utf8 (Ljava/lang/Throwable;)Ljava/lang/Throwable; 
.const [184] = Utf8 de/audi/app/combi/bap/fw/AbstractCombiModule 
.const [185] = Utf8 getLogChannel 
.const [186] = Utf8 ()Lde/audi/atip/log/LogChannel; 
.const [187] = Utf8 de/audi/app/combi/bap/app/navi/ServiceManagerNavi 
.const [188] = Utf8 logChannel 
.const [189] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [190] = Utf8 de/audi/app/combi/bap/app/navi/ServiceManagerNavi 
.const [191] = Utf8 bundleContext 
.const [192] = Utf8 Lorg/osgi/framework/BundleContext; 
.const [193] = Utf8 de/audi/atip/log/LogChannel 
.const [194] = Utf8 log 
.const [195] = Utf8 (ILjava/lang/String;)Z 
.const [196] = Utf8 de/audi/app/combi/bap/app/navi/ServiceManagerNavi 
.const [197] = Utf8 'module' 
.const [198] = Utf8 Lde/audi/app/bap/fw/AbstractBAPModule; 
.const [199] = Utf8 de/audi/app/bap/fw/AbstractBAPModule 
.const [200] = Utf8 getAppConnectors 
.const [201] = Utf8 ()Ljava/util/Map; 
.const [202] = Utf8 de/audi/app/combi/bap/app/navi/AppConnectorNavi 
.const [203] = Utf8 setAppServiceListener 
.const [204] = Utf8 (Lde/audi/atip/interapp/bap/BAPServiceListener;)V 
.const [205] = Utf8 de/audi/app/combi/bap/app/navi/CombiModuleNavi 
.const [206] = Utf8 setExternalKeyListener 
.const [207] = Utf8 (Lde/audi/atip/interapp/ExternalKeyListener;)V 
.const [208] = Utf8 java/lang/Class 
.const [209] = Utf8 getName 
.const [210] = Utf8 ()Ljava/lang/String; 
.const [211] = Utf8 de/audi/atip/activator/AbstractActivator 
.const [212] = Utf8 registerService 
.const [213] = Utf8 (Ljava/lang/String;Ljava/lang/Object;Ljava/util/Dictionary;)V 
.const [214] = Utf8 de/audi/app/bap/fw/AbstractBAPModule 
.const [215] = Utf8 getInitializationManager 
.const [216] = Utf8 ()Lde/audi/app/bap/fw/IBAPModuleInitializationManager; 
.const [217] = Utf8 de/audi/app/combi/bap/app/navi/ServiceManagerNavi 
.const [218] = Utf8 serviceTracker 
.const [219] = Utf8 Lorg/osgi/util/tracker/ServiceTracker; 
.const [220] = Utf8 org/osgi/util/tracker/ServiceTracker 
.const [221] = Utf8 'open' 
.const [222] = Utf8 ()V 
.const [223] = Utf8 java/lang/NoClassDefFoundError 
.const [224] = Utf8 <init> 
.const [225] = Utf8 ()V 
.const [226] = Utf8 de/audi/app/bap/fw/AbstractBAPModuleServiceManager 
.const [227] = Utf8 <init> 
.const [228] = Utf8 (Lde/audi/app/bap/fw/AbstractBAPModule;Lorg/osgi/framework/BundleContext;)V 
.const [229] = Utf8 de/audi/app/bap/fw/AbstractBAPModuleServiceManager 
.const [230] = Utf8 addingService 
.const [231] = Utf8 (Lorg/osgi/framework/ServiceReference;)Ljava/lang/Object; 
.const [232] = Utf8 de/audi/app/bap/fw/AbstractBAPModuleServiceManager 
.const [233] = Utf8 removedService 
.const [234] = Utf8 (Lorg/osgi/framework/ServiceReference;Ljava/lang/Object;)V 
.const [235] = Utf8 de/audi/app/combi/bap/app/navi/ServiceManagerNavi 
.const [236] = Utf8 class$de$audi$atip$interapp$combi$bap$navi$CombiBAPServiceNavi 
.const [237] = Utf8 Ljava/lang/Class; 
.const [238] = Utf8 de/audi/app/combi/bap/app/navi/ServiceManagerNavi 
.const [239] = Utf8 class$de$audi$atip$msg$MsgListener 
.const [240] = Utf8 Ljava/lang/Class; 
.const [241] = Utf8 de/audi/app/combi/bap/app/navi/ServiceManagerNavi 
.const [242] = Utf8 class$de$audi$atip$interapp$combi$bap$navi$CombiBAPServiceNaviListener 
.const [243] = Utf8 Ljava/lang/Class; 
.const [244] = Utf8 de/audi/app/combi/bap/app/navi/ServiceManagerNavi 
.const [245] = Utf8 class$de$audi$atip$diag$sw$SwDiagnosisManager 
.const [246] = Utf8 Ljava/lang/Class; 
.const [247] = Utf8 org/osgi/util/tracker/ServiceTracker 
.const [248] = Utf8 <init> 
.const [249] = Utf8 (Lorg/osgi/framework/BundleContext;[Ljava/lang/String;Lorg/osgi/util/tracker/ServiceTrackerCustomizer;)V 
.const [250] = Utf8 de/audi/app/combi/bap/app/navi/ServiceManagerNavi 
.const [251] = Utf8 logChannel 
.const [252] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [253] = Utf8 org/osgi/framework/BundleContext 
.const [254] = Utf8 getService 
.const [255] = Utf8 (Lorg/osgi/framework/ServiceReference;)Ljava/lang/Object; 
.const [256] = Utf8 java/util/Map 
.const [257] = Utf8 get 
.const [258] = Utf8 (Ljava/lang/Object;)Ljava/lang/Object; 
.const [259] = Utf8 org/osgi/framework/BundleContext 
.const [260] = Utf8 ungetService 
.const [261] = Utf8 (Lorg/osgi/framework/ServiceReference;)Z 
.const [262] = Utf8 de/audi/app/combi/bap/app/navi/ServiceManagerNavi 
.const [263] = Utf8 serviceTracker 
.const [264] = Utf8 Lorg/osgi/util/tracker/ServiceTracker; 
.const [265] = Utf8 de/audi/app/combi/bap/app/navi/ServiceManagerNavi 
.const [266] = Class [265] 
.const [267] = Utf8 de/audi/app/bap/fw/AbstractBAPModuleServiceManager 
.const [268] = Class [267] 
.const [269] = Utf8 logChannel 
.const [270] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [271] = Utf8 class$de$audi$atip$interapp$combi$bap$navi$CombiBAPServiceNavi 
.const [272] = Utf8 Ljava/lang/Class; 
.const [273] = Utf8 class$de$audi$atip$msg$MsgListener 
.const [274] = Utf8 Ljava/lang/Class; 
.const [275] = Utf8 class$de$audi$atip$interapp$combi$bap$navi$CombiBAPServiceNaviListener 
.const [276] = Utf8 Ljava/lang/Class; 
.const [277] = Utf8 class$de$audi$atip$diag$sw$SwDiagnosisManager 
.const [278] = Utf8 Ljava/lang/Class; 
.const [279] = Utf8 Code 
.const [280] = Utf8 <init> 
.const [281] = Utf8 (Lde/audi/app/combi/bap/fw/AbstractCombiModule;Lorg/osgi/framework/BundleContext;)V 
.const [282] = Utf8 addingService 
.const [283] = Utf8 (Lorg/osgi/framework/ServiceReference;)Ljava/lang/Object; 
.const [284] = Utf8 removedService 
.const [285] = Utf8 (Lorg/osgi/framework/ServiceReference;Ljava/lang/Object;)V 
.const [286] = Utf8 registerServices 
.const [287] = Utf8 (Lde/audi/atip/activator/AbstractActivator;)V 
.const [288] = Utf8 trackServices 
.const [289] = Utf8 ()V 
.const [290] = Utf8 class$ 
.const [291] = Utf8 (Ljava/lang/String;)Ljava/lang/Class; 
.end class 
