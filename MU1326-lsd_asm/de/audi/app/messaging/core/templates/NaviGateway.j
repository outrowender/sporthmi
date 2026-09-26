.version 50 0 
.class public final super [350] 
.super [352] 
.field private volatile [353] [354] 
.field private final [355] [356] 
.field static synthetic [357] [358] 
.field static synthetic [359] [360] 

.method public [362] : [363] 
    .attribute [361] .code stack 3 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     ldc [5] 
L4:     invokespecial [61] 
L7:     aload_0 
L8:     aload_1 
L9:     invokevirtual [44] 
L12:    invokeinterface [73] 0 
L17:    ldc [6] 
L19:    invokeinterface [74] 0 
L24:    putfield [75] 
L27:    return 
L28:    
    .end code 
.end method 

.method public [364] : [365] 
    .attribute [361] .code stack 6 locals 1 
        .catch [12] from L0 to L58 using L61 
L0:     aload_0 
L1:     aload_1 
L2:     invokespecial [62] 
L5:     aload_1 
L6:     getstatic [7] 
L9:     ifnonnull L24 
L12:    ldc [8] 
L14:    invokestatic [9] 
L17:    dup 
L18:    putstatic [63] 
L21:    goto L27 
L24:    getstatic [7] 
L27:    invokevirtual [46] 
L30:    new [76] 
L33:    dup 
L34:    aload_0 
L35:    aconst_null 
L36:    invokespecial [64] 
L39:    invokestatic [11] 
L42:    invokeinterface [77] 0 
L47:    pop 
L48:    aload_1 
L49:    aload_0 
L50:    invokespecial [65] 
L53:    invokeinterface [78] 0 
L58:    goto L76 
L61:    astore_2 
L62:    aload_0 
L63:    getfield [47] 
L66:    sipush 10000 
L69:    ldc [13] 
L71:    aload_2 
L72:    invokevirtual [48] 
L75:    pop 
L76:    return 
L77:    nop 
L78:    nop 
L79:    nop 
L80:    
    .end code 
.end method 

.method private [366] : [367] 
    .attribute [361] .code stack 5 locals 4 
L0:     new [79] 
L3:     dup 
L4:     invokespecial [66] 
L7:     astore_1 
L8:     aload_1 
L9:     ldc [15] 
L11:    getstatic [16] 
L14:    ifnonnull L29 
L17:    ldc [17] 
L19:    invokestatic [9] 
L22:    dup 
L23:    putstatic [67] 
L26:    goto L32 
L29:    getstatic [16] 
L32:    invokevirtual [46] 
L35:    invokevirtual [49] 
L38:    pop 
L39:    aload_1 
L40:    invokevirtual [50] 
L43:    astore_2 
L44:    aload_0 
L45:    getfield [51] 
L48:    aload_2 
L49:    invokeinterface [80] 0 
L54:    astore_3 
L55:    new [81] 
L58:    dup 
L59:    aload_0 
L60:    aload_0 
L61:    getfield [47] 
L64:    aload_0 
L65:    getfield [51] 
L68:    invokespecial [68] 
L71:    astore 4 
L73:    new [82] 
L76:    dup 
L77:    aload_0 
L78:    getfield [51] 
L81:    aload_3 
L82:    aload 4 
L84:    invokespecial [69] 
L87:    areturn 
L88:    
    .end code 
.end method 

.method protected [368] : [369] 
    .attribute [361] .code stack 2 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     putfield [83] 
L5:     return 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [370] : [371] 
    .attribute [361] .code stack 6 locals 2 
L0:     aconst_null 
L1:     astore_1 
L2:     aload_0 
L3:     getfield [52] 
L6:     ifnull L39 
L9:     aload_0 
L10:    getfield [52] 
L13:    invokeinterface [84] 0 
L18:    astore_2 
L19:    new [85] 
L22:    dup 
L23:    new [86] 
L26:    dup 
L27:    aload_2 
L28:    getfield [53] 
L31:    invokespecial [70] 
L34:    iconst_1 
L35:    invokespecial [71] 
L38:    astore_1 
L39:    aload_0 
L40:    getfield [47] 
L43:    ldc [22] 
L45:    ldc [23] 
L47:    aload_1 
L48:    invokevirtual [54] 
L51:    pop 
L52:    aload_1 
L53:    areturn 
L54:    nop 
L55:    nop 
L56:    
    .end code 
.end method 

.method public [372] : [373] 
    .attribute [361] .code stack 6 locals 3 
L0:     aconst_null 
L1:     astore_1 
L2:     aload_0 
L3:     getfield [52] 
L6:     ifnull L51 
L9:     aload_0 
L10:    getfield [52] 
L13:    invokeinterface [84] 0 
L18:    astore_2 
L19:    new [86] 
L22:    dup 
L23:    aload_2 
L24:    getfield [53] 
L27:    aload_0 
L28:    getfield [55] 
L31:    invokeinterface [87] 0 
L36:    lsub 
L37:    invokespecial [70] 
L40:    astore_3 
L41:    new [85] 
L44:    dup 
L45:    aload_3 
L46:    iconst_5 
L47:    invokespecial [71] 
L50:    astore_1 
L51:    aload_0 
L52:    getfield [47] 
L55:    ldc [22] 
L57:    ldc [24] 
L59:    aload_1 
L60:    invokevirtual [54] 
L63:    pop 
L64:    aload_1 
L65:    areturn 
L66:    nop 
L67:    nop 
L68:    
    .end code 
.end method 

.method public [374] : [375] 
    .attribute [361] .code stack 4 locals 2 
L0:     aconst_null 
L1:     astore_1 
L2:     aload_0 
L3:     getfield [52] 
L6:     ifnull L24 
L9:     aload_0 
L10:    getfield [52] 
L13:    invokeinterface [84] 0 
L18:    astore_2 
L19:    aload_2 
L20:    getfield [56] 
L23:    astore_1 
L24:    aload_0 
L25:    getfield [47] 
L28:    ldc [22] 
L30:    ldc [25] 
L32:    aload_1 
L33:    invokevirtual [54] 
L36:    pop 
L37:    aload_1 
L38:    areturn 
L39:    nop 
L40:    
    .end code 
.end method 

.method public [376] : [377] 
    .attribute [361] .code stack 4 locals 2 
L0:     aconst_null 
L1:     astore_1 
L2:     aload_0 
L3:     getfield [52] 
L6:     ifnull L24 
L9:     aload_0 
L10:    getfield [52] 
L13:    invokeinterface [84] 0 
L18:    astore_2 
L19:    aload_2 
L20:    getfield [57] 
L23:    astore_1 
L24:    aload_0 
L25:    getfield [47] 
L28:    ldc [22] 
L30:    ldc [26] 
L32:    aload_1 
L33:    invokevirtual [54] 
L36:    pop 
L37:    aload_1 
L38:    areturn 
L39:    nop 
L40:    
    .end code 
.end method 

.method public [378] : [379] 
    .attribute [361] .code stack 3 locals 1 
L0:     aconst_null 
L1:     astore_1 
L2:     aload_0 
L3:     getfield [52] 
L6:     ifnull L19 
L9:     aload_0 
L10:    getfield [52] 
L13:    invokeinterface [84] 0 
L18:    astore_1 
L19:    aload_0 
L20:    getfield [47] 
L23:    ldc [22] 
L25:    ldc [27] 
L27:    invokevirtual [58] 
L30:    pop 
L31:    aload_1 
L32:    areturn 
L33:    nop 
L34:    nop 
L35:    nop 
L36:    
    .end code 
.end method 

.method public [380] : [381] 
    .attribute [361] .code stack 4 locals 0 
L0:     aload_0 
L1:     getfield [45] 
L4:     iload_1 
L5:     ifeq L12 
L8:     iconst_1 
L9:     goto L13 
L12:    iconst_0 
L13:    invokeinterface [88] 0 
L18:    aload_0 
L19:    getfield [47] 
L22:    ldc [28] 
L24:    ldc [29] 
L26:    iload_1 
L27:    invokevirtual [59] 
L30:    pop 
L31:    return 
L32:    
    .end code 
.end method 

.method static synthetic [382] : [383] 
    .attribute [361] .code stack 2 locals 1 
        .catch [3] from L0 to L4 using L5 
L0:     aload_0 
L1:     invokestatic [2] 
L4:     areturn 
L5:     astore_1 
L6:     new [72] 
L9:     dup 
L10:    invokespecial [60] 
L13:    aload_1 
L14:    invokevirtual [43] 
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
.const [5] = String [93] 
.const [6] = Int -1483529984 
.const [7] = Field [94] [95] 
.const [8] = String [96] 
.const [9] = Method [97] [98] 
.const [10] = Class [99] 
.const [11] = Method [100] [101] 
.const [12] = Class [102] 
.const [13] = String [103] 
.const [14] = Class [104] 
.const [15] = String [105] 
.const [16] = Field [106] [107] 
.const [17] = String [108] 
.const [18] = Class [109] 
.const [19] = Class [110] 
.const [20] = Class [111] 
.const [21] = Class [112] 
.const [22] = Int -2137614336 
.const [23] = String [113] 
.const [24] = String [114] 
.const [25] = String [115] 
.const [26] = String [116] 
.const [27] = String [117] 
.const [28] = Int 1078071040 
.const [29] = String [118] 
.const [30] = Class [119] 
.const [31] = Class [120] 
.const [32] = Class [121] 
.const [33] = Class [122] 
.const [34] = Class [123] 
.const [35] = Class [124] 
.const [36] = Class [125] 
.const [37] = Class [126] 
.const [38] = Class [127] 
.const [39] = Class [128] 
.const [40] = Class [129] 
.const [41] = Class [130] 
.const [42] = Class [131] 
.const [43] = Method [132] [133] 
.const [44] = Method [134] [135] 
.const [45] = Field [136] [137] 
.const [46] = Method [138] [139] 
.const [47] = Field [140] [141] 
.const [48] = Method [142] [143] 
.const [49] = Method [144] [145] 
.const [50] = Method [146] [147] 
.const [51] = Field [148] [149] 
.const [52] = Field [150] [151] 
.const [53] = Field [152] [153] 
.const [54] = Method [154] [155] 
.const [55] = Field [156] [157] 
.const [56] = Field [158] [159] 
.const [57] = Field [160] [161] 
.const [58] = Method [162] [163] 
.const [59] = Method [164] [165] 
.const [60] = Method [166] [167] 
.const [61] = Method [168] [169] 
.const [62] = Method [170] [171] 
.const [63] = Field [172] [173] 
.const [64] = Method [174] [175] 
.const [65] = Method [176] [177] 
.const [66] = Method [178] [179] 
.const [67] = Field [180] [181] 
.const [68] = Method [182] [183] 
.const [69] = Method [184] [185] 
.const [70] = Method [186] [187] 
.const [71] = Method [188] [189] 
.const [72] = Class [190] 
.const [73] = InterfaceMethod [191] [192] 
.const [74] = InterfaceMethod [193] [194] 
.const [75] = Field [195] [196] 
.const [76] = Class [197] 
.const [77] = InterfaceMethod [198] [199] 
.const [78] = InterfaceMethod [200] [201] 
.const [79] = Class [202] 
.const [80] = InterfaceMethod [203] [204] 
.const [81] = Class [205] 
.const [82] = Class [206] 
.const [83] = Field [207] [208] 
.const [84] = InterfaceMethod [209] [210] 
.const [85] = Class [211] 
.const [86] = Class [212] 
.const [87] = InterfaceMethod [213] [214] 
.const [88] = InterfaceMethod [215] [216] 
.const [89] = Class [217] 
.const [90] = NameAndType [218] [219] 
.const [91] = Utf8 java/lang/ClassNotFoundException 
.const [92] = Utf8 java/lang/NoClassDefFoundError 
.const [93] = Utf8 'App.Messaging.Main' 
.const [94] = Class [220] 
.const [95] = NameAndType [221] [222] 
.const [96] = Utf8 'de.audi.atip.interapp.NaviServiceListener' 
.const [97] = Class [223] 
.const [98] = NameAndType [224] [225] 
.const [99] = Utf8 de/audi/app/messaging/core/templates/NaviGateway$NaviDefaultListener 
.const [100] = Class [226] 
.const [101] = NameAndType [227] [228] 
.const [102] = Utf8 java/lang/Exception 
.const [103] = Utf8 '[NaviGateway#connect] An error occurred: ' 
.const [104] = Utf8 de/audi/app/messaging/core/osgi/ServiceFilterBuilder 
.const [105] = Utf8 objectClass 
.const [106] = Class [229] 
.const [107] = NameAndType [230] [231] 
.const [108] = Utf8 'de.audi.atip.interapp.NaviService' 
.const [109] = Utf8 de/audi/app/messaging/core/templates/NaviGateway$1 
.const [110] = Utf8 org/osgi/util/tracker/ServiceTracker 
.const [111] = Utf8 de/audi/atip/metrics/DateMetric 
.const [112] = Utf8 java/util/Date 
.const [113] = Utf8 '[NaviGateway#getEta] ETA = %1' 
.const [114] = Utf8 '[NaviGateway#getDuration] Duration = %1' 
.const [115] = Utf8 '[NaviGateway#getDestination] Destination = %1' 
.const [116] = Utf8 '[NaviGateway#getCurrentPosition] Current position = %1' 
.const [117] = Utf8 '[NaviGateway#getNaviDetails' 
.const [118] = Utf8 '[NaviGateway#toggleRouteGuidance] Route guidance active = %1' 
.const [119] = Utf8 de/audi/app/messaging/core/templates/NaviGateway 
.const [120] = Utf8 de/audi/app/messaging/core/component/AbstractMessagingComponent 
.const [121] = Utf8 java/lang/Class 
.const [122] = Utf8 de/audi/app/messaging/core/osgi/MessagingBundleContext 
.const [123] = Utf8 de/audi/atip/base/IFrameworkAccess 
.const [124] = Utf8 de/audi/atip/hmi/IHMIServiceApp 
.const [125] = Utf8 de/audi/app/messaging/core/osgi/ServiceProperties 
.const [126] = Utf8 de/audi/app/messaging/core/osgi/IServiceRegistry 
.const [127] = Utf8 de/audi/atip/log/LogChannel 
.const [128] = Utf8 org/osgi/framework/BundleContext 
.const [129] = Utf8 de/audi/atip/interapp/NaviService 
.const [130] = Utf8 de/audi/atip/interapp/NaviMsgDetails 
.const [131] = Utf8 de/audi/atip/hmi/modelaccess/ChoiceModelApp 
.const [132] = Class [232] 
.const [133] = NameAndType [233] [234] 
.const [134] = Class [235] 
.const [135] = NameAndType [236] [237] 
.const [136] = Class [238] 
.const [137] = NameAndType [239] [240] 
.const [138] = Class [241] 
.const [139] = NameAndType [242] [243] 
.const [140] = Class [244] 
.const [141] = NameAndType [245] [246] 
.const [142] = Class [247] 
.const [143] = NameAndType [248] [249] 
.const [144] = Class [250] 
.const [145] = NameAndType [251] [252] 
.const [146] = Class [253] 
.const [147] = NameAndType [254] [255] 
.const [148] = Class [256] 
.const [149] = NameAndType [257] [258] 
.const [150] = Class [259] 
.const [151] = NameAndType [260] [261] 
.const [152] = Class [262] 
.const [153] = NameAndType [263] [264] 
.const [154] = Class [265] 
.const [155] = NameAndType [266] [267] 
.const [156] = Class [268] 
.const [157] = NameAndType [269] [270] 
.const [158] = Class [271] 
.const [159] = NameAndType [272] [273] 
.const [160] = Class [274] 
.const [161] = NameAndType [275] [276] 
.const [162] = Class [277] 
.const [163] = NameAndType [278] [279] 
.const [164] = Class [280] 
.const [165] = NameAndType [281] [282] 
.const [166] = Class [283] 
.const [167] = NameAndType [284] [285] 
.const [168] = Class [286] 
.const [169] = NameAndType [287] [288] 
.const [170] = Class [289] 
.const [171] = NameAndType [290] [291] 
.const [172] = Class [292] 
.const [173] = NameAndType [293] [294] 
.const [174] = Class [295] 
.const [175] = NameAndType [296] [297] 
.const [176] = Class [298] 
.const [177] = NameAndType [299] [300] 
.const [178] = Class [301] 
.const [179] = NameAndType [302] [303] 
.const [180] = Class [304] 
.const [181] = NameAndType [305] [306] 
.const [182] = Class [307] 
.const [183] = NameAndType [308] [309] 
.const [184] = Class [310] 
.const [185] = NameAndType [311] [312] 
.const [186] = Class [313] 
.const [187] = NameAndType [314] [315] 
.const [188] = Class [316] 
.const [189] = NameAndType [317] [318] 
.const [190] = Utf8 java/lang/NoClassDefFoundError 
.const [191] = Class [319] 
.const [192] = NameAndType [320] [321] 
.const [193] = Class [322] 
.const [194] = NameAndType [323] [324] 
.const [195] = Class [325] 
.const [196] = NameAndType [326] [327] 
.const [197] = Utf8 de/audi/app/messaging/core/templates/NaviGateway$NaviDefaultListener 
.const [198] = Class [328] 
.const [199] = NameAndType [329] [330] 
.const [200] = Class [331] 
.const [201] = NameAndType [332] [333] 
.const [202] = Utf8 de/audi/app/messaging/core/osgi/ServiceFilterBuilder 
.const [203] = Class [334] 
.const [204] = NameAndType [335] [336] 
.const [205] = Utf8 de/audi/app/messaging/core/templates/NaviGateway$1 
.const [206] = Utf8 org/osgi/util/tracker/ServiceTracker 
.const [207] = Class [337] 
.const [208] = NameAndType [338] [339] 
.const [209] = Class [340] 
.const [210] = NameAndType [341] [342] 
.const [211] = Utf8 de/audi/atip/metrics/DateMetric 
.const [212] = Utf8 java/util/Date 
.const [213] = Class [343] 
.const [214] = NameAndType [344] [345] 
.const [215] = Class [346] 
.const [216] = NameAndType [347] [348] 
.const [217] = Utf8 java/lang/Class 
.const [218] = Utf8 forName 
.const [219] = Utf8 (Ljava/lang/String;)Ljava/lang/Class; 
.const [220] = Utf8 de/audi/app/messaging/core/templates/NaviGateway 
.const [221] = Utf8 class$de$audi$atip$interapp$NaviServiceListener 
.const [222] = Utf8 Ljava/lang/Class; 
.const [223] = Utf8 de/audi/app/messaging/core/templates/NaviGateway 
.const [224] = Utf8 class$ 
.const [225] = Utf8 (Ljava/lang/String;)Ljava/lang/Class; 
.const [226] = Utf8 de/audi/app/messaging/core/osgi/ServiceProperties 
.const [227] = Utf8 createServiceProperties 
.const [228] = Utf8 ()Ljava/util/Dictionary; 
.const [229] = Utf8 de/audi/app/messaging/core/templates/NaviGateway 
.const [230] = Utf8 class$de$audi$atip$interapp$NaviService 
.const [231] = Utf8 Ljava/lang/Class; 
.const [232] = Utf8 java/lang/NoClassDefFoundError 
.const [233] = Utf8 initCause 
.const [234] = Utf8 (Ljava/lang/Throwable;)Ljava/lang/Throwable; 
.const [235] = Utf8 de/audi/app/messaging/core/osgi/MessagingBundleContext 
.const [236] = Utf8 getFramework 
.const [237] = Utf8 ()Lde/audi/atip/base/IFrameworkAccess; 
.const [238] = Utf8 de/audi/app/messaging/core/templates/NaviGateway 
.const [239] = Utf8 rgActive 
.const [240] = Utf8 Lde/audi/atip/hmi/modelaccess/ChoiceModelApp; 
.const [241] = Utf8 java/lang/Class 
.const [242] = Utf8 getName 
.const [243] = Utf8 ()Ljava/lang/String; 
.const [244] = Utf8 de/audi/app/messaging/core/templates/NaviGateway 
.const [245] = Utf8 log 
.const [246] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [247] = Utf8 de/audi/atip/log/LogChannel 
.const [248] = Utf8 log 
.const [249] = Utf8 (ILjava/lang/String;Ljava/lang/Throwable;)Z 
.const [250] = Utf8 de/audi/app/messaging/core/osgi/ServiceFilterBuilder 
.const [251] = Utf8 addProperty 
.const [252] = Utf8 (Ljava/lang/String;Ljava/lang/String;)Lde/audi/app/messaging/core/osgi/ServiceFilterBuilder; 
.const [253] = Utf8 de/audi/app/messaging/core/osgi/ServiceFilterBuilder 
.const [254] = Utf8 createFilterString 
.const [255] = Utf8 ()Ljava/lang/String; 
.const [256] = Utf8 de/audi/app/messaging/core/templates/NaviGateway 
.const [257] = Utf8 bundleContext 
.const [258] = Utf8 Lorg/osgi/framework/BundleContext; 
.const [259] = Utf8 de/audi/app/messaging/core/templates/NaviGateway 
.const [260] = Utf8 naviService 
.const [261] = Utf8 Lde/audi/atip/interapp/NaviService; 
.const [262] = Utf8 de/audi/atip/interapp/NaviMsgDetails 
.const [263] = Utf8 eta 
.const [264] = Utf8 J 
.const [265] = Utf8 de/audi/atip/log/LogChannel 
.const [266] = Utf8 log 
.const [267] = Utf8 (ILjava/lang/String;Ljava/lang/Object;)Z 
.const [268] = Utf8 de/audi/app/messaging/core/templates/NaviGateway 
.const [269] = Utf8 framework 
.const [270] = Utf8 Lde/audi/atip/base/IFrameworkAccess; 
.const [271] = Utf8 de/audi/atip/interapp/NaviMsgDetails 
.const [272] = Utf8 formattedDestination 
.const [273] = Utf8 Ljava/lang/String; 
.const [274] = Utf8 de/audi/atip/interapp/NaviMsgDetails 
.const [275] = Utf8 formattedCurrentPosition 
.const [276] = Utf8 Ljava/lang/String; 
.const [277] = Utf8 de/audi/atip/log/LogChannel 
.const [278] = Utf8 log 
.const [279] = Utf8 (ILjava/lang/String;)Z 
.const [280] = Utf8 de/audi/atip/log/LogChannel 
.const [281] = Utf8 log 
.const [282] = Utf8 (ILjava/lang/String;Z)Z 
.const [283] = Utf8 java/lang/NoClassDefFoundError 
.const [284] = Utf8 <init> 
.const [285] = Utf8 ()V 
.const [286] = Utf8 de/audi/app/messaging/core/component/AbstractMessagingComponent 
.const [287] = Utf8 <init> 
.const [288] = Utf8 (Lde/audi/app/messaging/core/osgi/MessagingBundleContext;Ljava/lang/String;)V 
.const [289] = Utf8 de/audi/app/messaging/core/component/AbstractMessagingComponent 
.const [290] = Utf8 connect 
.const [291] = Utf8 (Lde/audi/app/messaging/core/osgi/IServiceRegistry;)V 
.const [292] = Utf8 de/audi/app/messaging/core/templates/NaviGateway 
.const [293] = Utf8 class$de$audi$atip$interapp$NaviServiceListener 
.const [294] = Utf8 Ljava/lang/Class; 
.const [295] = Utf8 de/audi/app/messaging/core/templates/NaviGateway$NaviDefaultListener 
.const [296] = Utf8 <init> 
.const [297] = Utf8 (Lde/audi/app/messaging/core/templates/NaviGateway;Lde/audi/app/messaging/core/templates/NaviGateway$1;)V 
.const [298] = Utf8 de/audi/app/messaging/core/templates/NaviGateway 
.const [299] = Utf8 createServiceTracker 
.const [300] = Utf8 ()Lorg/osgi/util/tracker/ServiceTracker; 
.const [301] = Utf8 de/audi/app/messaging/core/osgi/ServiceFilterBuilder 
.const [302] = Utf8 <init> 
.const [303] = Utf8 ()V 
.const [304] = Utf8 de/audi/app/messaging/core/templates/NaviGateway 
.const [305] = Utf8 class$de$audi$atip$interapp$NaviService 
.const [306] = Utf8 Ljava/lang/Class; 
.const [307] = Utf8 de/audi/app/messaging/core/templates/NaviGateway$1 
.const [308] = Utf8 <init> 
.const [309] = Utf8 (Lde/audi/app/messaging/core/templates/NaviGateway;Lde/audi/atip/log/LogChannel;Lorg/osgi/framework/BundleContext;)V 
.const [310] = Utf8 org/osgi/util/tracker/ServiceTracker 
.const [311] = Utf8 <init> 
.const [312] = Utf8 (Lorg/osgi/framework/BundleContext;Lorg/osgi/framework/Filter;Lorg/osgi/util/tracker/ServiceTrackerCustomizer;)V 
.const [313] = Utf8 java/util/Date 
.const [314] = Utf8 <init> 
.const [315] = Utf8 (J)V 
.const [316] = Utf8 de/audi/atip/metrics/DateMetric 
.const [317] = Utf8 <init> 
.const [318] = Utf8 (Ljava/util/Date;I)V 
.const [319] = Utf8 de/audi/atip/base/IFrameworkAccess 
.const [320] = Utf8 getHmiServiceApp 
.const [321] = Utf8 ()Lde/audi/atip/hmi/IHMIServiceApp; 
.const [322] = Utf8 de/audi/atip/hmi/IHMIServiceApp 
.const [323] = Utf8 getChoiceModel 
.const [324] = Utf8 (I)Lde/audi/atip/hmi/modelaccess/ChoiceModelApp; 
.const [325] = Utf8 de/audi/app/messaging/core/templates/NaviGateway 
.const [326] = Utf8 rgActive 
.const [327] = Utf8 Lde/audi/atip/hmi/modelaccess/ChoiceModelApp; 
.const [328] = Utf8 de/audi/app/messaging/core/osgi/IServiceRegistry 
.const [329] = Utf8 registerService 
.const [330] = Utf8 (Ljava/lang/String;Ljava/lang/Object;Ljava/util/Dictionary;)Lorg/osgi/framework/ServiceRegistration; 
.const [331] = Utf8 de/audi/app/messaging/core/osgi/IServiceRegistry 
.const [332] = Utf8 addTracker 
.const [333] = Utf8 (Lorg/osgi/util/tracker/ServiceTracker;)V 
.const [334] = Utf8 org/osgi/framework/BundleContext 
.const [335] = Utf8 createFilter 
.const [336] = Utf8 (Ljava/lang/String;)Lorg/osgi/framework/Filter; 
.const [337] = Utf8 de/audi/app/messaging/core/templates/NaviGateway 
.const [338] = Utf8 naviService 
.const [339] = Utf8 Lde/audi/atip/interapp/NaviService; 
.const [340] = Utf8 de/audi/atip/interapp/NaviService 
.const [341] = Utf8 requestCurrentNaviDataforMessage 
.const [342] = Utf8 ()Lde/audi/atip/interapp/NaviMsgDetails; 
.const [343] = Utf8 de/audi/atip/base/IFrameworkAccess 
.const [344] = Utf8 getKombiTime 
.const [345] = Utf8 ()J 
.const [346] = Utf8 de/audi/atip/hmi/modelaccess/ChoiceModelApp 
.const [347] = Utf8 setValue 
.const [348] = Utf8 (I)V 
.const [349] = Utf8 de/audi/app/messaging/core/templates/NaviGateway 
.const [350] = Class [349] 
.const [351] = Utf8 de/audi/app/messaging/core/component/AbstractMessagingComponent 
.const [352] = Class [351] 
.const [353] = Utf8 naviService 
.const [354] = Utf8 Lde/audi/atip/interapp/NaviService; 
.const [355] = Utf8 rgActive 
.const [356] = Utf8 Lde/audi/atip/hmi/modelaccess/ChoiceModelApp; 
.const [357] = Utf8 class$de$audi$atip$interapp$NaviServiceListener 
.const [358] = Utf8 Ljava/lang/Class; 
.const [359] = Utf8 class$de$audi$atip$interapp$NaviService 
.const [360] = Utf8 Ljava/lang/Class; 
.const [361] = Utf8 Code 
.const [362] = Utf8 <init> 
.const [363] = Utf8 (Lde/audi/app/messaging/core/osgi/MessagingBundleContext;)V 
.const [364] = Utf8 connect 
.const [365] = Utf8 (Lde/audi/app/messaging/core/osgi/IServiceRegistry;)V 
.const [366] = Utf8 createServiceTracker 
.const [367] = Utf8 ()Lorg/osgi/util/tracker/ServiceTracker; 
.const [368] = Utf8 setNaviService 
.const [369] = Utf8 (Lde/audi/atip/interapp/NaviService;)V 
.const [370] = Utf8 getEta 
.const [371] = Utf8 ()Lde/audi/atip/metrics/DateMetric; 
.const [372] = Utf8 getDuration 
.const [373] = Utf8 ()Lde/audi/atip/metrics/DateMetric; 
.const [374] = Utf8 getFormattedDestination 
.const [375] = Utf8 ()Ljava/lang/String; 
.const [376] = Utf8 getFormattedCurrentPosition 
.const [377] = Utf8 ()Ljava/lang/String; 
.const [378] = Utf8 getNaviDetails 
.const [379] = Utf8 ()Lde/audi/atip/interapp/NaviMsgDetails; 
.const [380] = Utf8 toggleRouteGuidance 
.const [381] = Utf8 (Z)V 
.const [382] = Utf8 class$ 
.const [383] = Utf8 (Ljava/lang/String;)Ljava/lang/Class; 
.end class 
