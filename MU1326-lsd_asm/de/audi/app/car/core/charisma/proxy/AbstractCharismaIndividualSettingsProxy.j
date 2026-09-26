.version 50 0 
.class public super abstract [227] 
.super [229] 
.implements [231] 
.field private final [232] [233] 
.field private final [234] [235] 
.field private final [236] [237] 
.field private final [238] [239] 
.field static synthetic [240] [241] 

.method public [243] : [244] 
    .attribute [242] .code stack 8 locals 0 
L0:     aload_0 
L1:     invokespecial [41] 
L4:     aload_0 
L5:     new [46] 
L8:     dup 
L9:     iconst_1 
L10:    invokespecial [42] 
L13:    putfield [47] 
L16:    aload_0 
L17:    new [48] 
L20:    dup 
L21:    invokespecial [41] 
L24:    putfield [49] 
L27:    aload_0 
L28:    aload_2 
L29:    putfield [50] 
L32:    aload_0 
L33:    new [51] 
L36:    dup 
L37:    getstatic [8] 
L40:    ifnonnull L55 
L43:    ldc [9] 
L45:    invokestatic [10] 
L48:    dup 
L49:    putstatic [43] 
L52:    goto L58 
L55:    getstatic [8] 
L58:    invokevirtual [28] 
L61:    aload_0 
L62:    aconst_null 
L63:    aload_1 
L64:    invokeinterface [52] 0 
L69:    aload_2 
L70:    invokespecial [44] 
L73:    putfield [53] 
L76:    return 
L77:    nop 
L78:    nop 
L79:    nop 
L80:    
    .end code 
.end method 

.method public [245] : [246] 
    .attribute [242] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [29] 
L4:     invokevirtual [30] 
L7:     return 
L8:     
    .end code 
.end method 

.method public [247] : [248] 
    .attribute [242] .code stack 2 locals 2 
L0:     aload_0 
L1:     getfield [29] 
L4:     invokevirtual [31] 
L7:     aload_0 
L8:     getfield [26] 
L11:    dup 
L12:    astore_1 
L13:    monitorenter 
        .catch [0] from L14 to L23 using L26 
L14:    aload_0 
L15:    getfield [25] 
L18:    invokevirtual [32] 
L21:    aload_1 
L22:    monitorexit 
L23:    goto L31 
        .catch [0] from L26 to L29 using L26 
L26:    astore_2 
L27:    aload_1 
L28:    monitorexit 
L29:    aload_2 
L30:    athrow 
L31:    return 
L32:    
    .end code 
.end method 

.method public [249] : [250] 
    .attribute [242] .code stack 2 locals 0 
L0:     iconst_0 
L1:     aload_0 
L2:     getfield [25] 
L5:     invokevirtual [33] 
L8:     if_icmpge L15 
L11:    iconst_1 
L12:    goto L16 
L15:    iconst_0 
L16:    areturn 
L17:    nop 
L18:    nop 
L19:    nop 
L20:    
    .end code 
.end method 

.method public [251] : [252] 
    .attribute [242] .code stack 3 locals 2 
L0:     aload_0 
L1:     getfield [27] 
L4:     invokevirtual [34] 
L7:     ifeq L22 
L10:    aload_0 
L11:    getfield [27] 
L14:    ldc [11] 
L16:    ldc [12] 
L18:    invokevirtual [35] 
L21:    pop 
L22:    aload_0 
L23:    getfield [26] 
L26:    dup 
L27:    astore_2 
L28:    monitorenter 
        .catch [0] from L29 to L66 using L69 
L29:    aload_0 
L30:    getfield [25] 
L33:    aload_1 
L34:    invokevirtual [36] 
L37:    ifne L52 
L40:    aload_0 
L41:    getfield [25] 
L44:    aload_1 
L45:    invokevirtual [37] 
L48:    pop 
L49:    goto L64 
L52:    aload_0 
L53:    getfield [27] 
L56:    ldc [13] 
L58:    ldc [14] 
L60:    invokevirtual [35] 
L63:    pop 
L64:    aload_2 
L65:    monitorexit 
L66:    goto L74 
        .catch [0] from L69 to L72 using L69 
L69:    astore_3 
L70:    aload_2 
L71:    monitorexit 
L72:    aload_3 
L73:    athrow 
L74:    return 
L75:    nop 
L76:    
    .end code 
.end method 

.method public [253] : [254] 
    .attribute [242] .code stack 3 locals 2 
L0:     aload_0 
L1:     getfield [27] 
L4:     invokevirtual [34] 
L7:     ifeq L22 
L10:    aload_0 
L11:    getfield [27] 
L14:    ldc [11] 
L16:    ldc [15] 
L18:    invokevirtual [35] 
L21:    pop 
L22:    aload_0 
L23:    getfield [26] 
L26:    dup 
L27:    astore_2 
L28:    monitorenter 
        .catch [0] from L29 to L40 using L43 
L29:    aload_0 
L30:    getfield [25] 
L33:    aload_1 
L34:    invokevirtual [38] 
L37:    pop 
L38:    aload_2 
L39:    monitorexit 
L40:    goto L48 
        .catch [0] from L43 to L46 using L43 
L43:    astore_3 
L44:    aload_2 
L45:    monitorexit 
L46:    aload_3 
L47:    athrow 
L48:    return 
L49:    nop 
L50:    nop 
L51:    nop 
L52:    
    .end code 
.end method 

.method public [255] : [256] 
    .attribute [242] .code stack 3 locals 5 
L0:     aload_0 
L1:     getfield [27] 
L4:     invokevirtual [34] 
L7:     ifeq L22 
L10:    aload_0 
L11:    getfield [27] 
L14:    ldc [11] 
L16:    ldc [16] 
L18:    invokevirtual [35] 
L21:    pop 
L22:    aload_0 
L23:    getfield [26] 
L26:    dup 
L27:    astore_1 
L28:    monitorenter 
L29:    iconst_0 
L30:    istore_2 
L31:    iload_2 
L32:    aload_0 
L33:    getfield [25] 
L36:    invokevirtual [33] 
L39:    if_icmpge L84 
L42:    aload_0 
L43:    getfield [25] 
L46:    iload_2 
L47:    invokevirtual [39] 
L50:    checkcast [17] 
L53:    astore_3 
        .catch [18] from L54 to L60 using L63 
        .catch [0] from L29 to L86 using L89 
L54:    aload_3 
L55:    invokeinterface [54] 0 
L60:    goto L78 
L63:    astore 4 
L65:    aload_0 
L66:    getfield [27] 
L69:    sipush 1000 
L72:    ldc [19] 
L74:    invokevirtual [35] 
L77:    pop 
L78:    iinc 2 1 
L81:    goto L31 
L84:    aload_1 
L85:    monitorexit 
L86:    goto L96 
        .catch [0] from L89 to L93 using L89 
L89:    astore 5 
L91:    aload_1 
L92:    monitorexit 
L93:    aload 5 
L95:    athrow 
L96:    return 
L97:    nop 
L98:    nop 
L99:    nop 
L100:   
    .end code 
.end method 

.method static synthetic [257] : [258] 
    .attribute [242] .code stack 2 locals 1 
        .catch [3] from L0 to L4 using L5 
L0:     aload_0 
L1:     invokestatic [2] 
L4:     areturn 
L5:     astore_1 
L6:     new [45] 
L9:     dup 
L10:    invokespecial [40] 
L13:    aload_1 
L14:    invokevirtual [24] 
L17:    athrow 
L18:    nop 
L19:    nop 
L20:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Method [55] [56] 
.const [3] = Class [57] 
.const [4] = Class [58] 
.const [5] = Class [59] 
.const [6] = Class [60] 
.const [7] = Class [61] 
.const [8] = Field [62] [63] 
.const [9] = String [64] 
.const [10] = Method [65] [66] 
.const [11] = Int 1078071040 
.const [12] = String [67] 
.const [13] = Int -1601830656 
.const [14] = String [68] 
.const [15] = String [69] 
.const [16] = String [70] 
.const [17] = Class [71] 
.const [18] = Class [72] 
.const [19] = String [73] 
.const [20] = Class [74] 
.const [21] = Class [75] 
.const [22] = Class [76] 
.const [23] = Class [77] 
.const [24] = Method [78] [79] 
.const [25] = Field [80] [81] 
.const [26] = Field [82] [83] 
.const [27] = Field [84] [85] 
.const [28] = Method [86] [87] 
.const [29] = Field [88] [89] 
.const [30] = Method [90] [91] 
.const [31] = Method [92] [93] 
.const [32] = Method [94] [95] 
.const [33] = Method [96] [97] 
.const [34] = Method [98] [99] 
.const [35] = Method [100] [101] 
.const [36] = Method [102] [103] 
.const [37] = Method [104] [105] 
.const [38] = Method [106] [107] 
.const [39] = Method [108] [109] 
.const [40] = Method [110] [111] 
.const [41] = Method [112] [113] 
.const [42] = Method [114] [115] 
.const [43] = Field [116] [117] 
.const [44] = Method [118] [119] 
.const [45] = Class [120] 
.const [46] = Class [121] 
.const [47] = Field [122] [123] 
.const [48] = Class [124] 
.const [49] = Field [125] [126] 
.const [50] = Field [127] [128] 
.const [51] = Class [129] 
.const [52] = InterfaceMethod [130] [131] 
.const [53] = Field [132] [133] 
.const [54] = InterfaceMethod [134] [135] 
.const [55] = Class [136] 
.const [56] = NameAndType [137] [138] 
.const [57] = Utf8 java/lang/ClassNotFoundException 
.const [58] = Utf8 java/lang/NoClassDefFoundError 
.const [59] = Utf8 java/util/ArrayList 
.const [60] = Utf8 java/lang/Object 
.const [61] = Utf8 de/audi/app/car/common/service/CarServiceProvider 
.const [62] = Class [139] 
.const [63] = NameAndType [140] [141] 
.const [64] = Utf8 'de.audi.app.car.core.charisma.proxy.ICharismaIndividualSettingsProxy' 
.const [65] = Class [142] 
.const [66] = NameAndType [143] [144] 
.const [67] = Utf8 '[CharismaIndividualSettingsProxy#registerClient] ...' 
.const [68] = Utf8 '[CharismaIndividualSettingsProxy#registerClient] Client already registered.' 
.const [69] = Utf8 '[CharismaIndividualSettingsProxy#unregisterClient] ...' 
.const [70] = Utf8 '[CharismaIndividualSettingsProxy#invokeSaveIndividualSettingsRequest] ...' 
.const [71] = Utf8 de/audi/app/car/core/charisma/proxy/ICharismaIndividualSettingsClient 
.const [72] = Utf8 java/lang/Exception 
.const [73] = Utf8 '[CharismaIndividualSettingsProxy#invokeSaveIndividualSettingsRequest] Exception occured within the client.' 
.const [74] = Utf8 de/audi/app/car/core/charisma/proxy/AbstractCharismaIndividualSettingsProxy 
.const [75] = Utf8 java/lang/Class 
.const [76] = Utf8 de/audi/app/car/common/app/ICarApplication 
.const [77] = Utf8 de/audi/atip/log/LogChannel 
.const [78] = Class [145] 
.const [79] = NameAndType [146] [147] 
.const [80] = Class [148] 
.const [81] = NameAndType [149] [150] 
.const [82] = Class [151] 
.const [83] = NameAndType [152] [153] 
.const [84] = Class [154] 
.const [85] = NameAndType [155] [156] 
.const [86] = Class [157] 
.const [87] = NameAndType [158] [159] 
.const [88] = Class [160] 
.const [89] = NameAndType [161] [162] 
.const [90] = Class [163] 
.const [91] = NameAndType [164] [165] 
.const [92] = Class [166] 
.const [93] = NameAndType [167] [168] 
.const [94] = Class [169] 
.const [95] = NameAndType [170] [171] 
.const [96] = Class [172] 
.const [97] = NameAndType [173] [174] 
.const [98] = Class [175] 
.const [99] = NameAndType [176] [177] 
.const [100] = Class [178] 
.const [101] = NameAndType [179] [180] 
.const [102] = Class [181] 
.const [103] = NameAndType [182] [183] 
.const [104] = Class [184] 
.const [105] = NameAndType [185] [186] 
.const [106] = Class [187] 
.const [107] = NameAndType [188] [189] 
.const [108] = Class [190] 
.const [109] = NameAndType [191] [192] 
.const [110] = Class [193] 
.const [111] = NameAndType [194] [195] 
.const [112] = Class [196] 
.const [113] = NameAndType [197] [198] 
.const [114] = Class [199] 
.const [115] = NameAndType [200] [201] 
.const [116] = Class [202] 
.const [117] = NameAndType [203] [204] 
.const [118] = Class [205] 
.const [119] = NameAndType [206] [207] 
.const [120] = Utf8 java/lang/NoClassDefFoundError 
.const [121] = Utf8 java/util/ArrayList 
.const [122] = Class [208] 
.const [123] = NameAndType [209] [210] 
.const [124] = Utf8 java/lang/Object 
.const [125] = Class [211] 
.const [126] = NameAndType [212] [213] 
.const [127] = Class [214] 
.const [128] = NameAndType [215] [216] 
.const [129] = Utf8 de/audi/app/car/common/service/CarServiceProvider 
.const [130] = Class [217] 
.const [131] = NameAndType [218] [219] 
.const [132] = Class [220] 
.const [133] = NameAndType [221] [222] 
.const [134] = Class [223] 
.const [135] = NameAndType [224] [225] 
.const [136] = Utf8 java/lang/Class 
.const [137] = Utf8 forName 
.const [138] = Utf8 (Ljava/lang/String;)Ljava/lang/Class; 
.const [139] = Utf8 de/audi/app/car/core/charisma/proxy/AbstractCharismaIndividualSettingsProxy 
.const [140] = Utf8 class$de$audi$app$car$core$charisma$proxy$ICharismaIndividualSettingsProxy 
.const [141] = Utf8 Ljava/lang/Class; 
.const [142] = Utf8 de/audi/app/car/core/charisma/proxy/AbstractCharismaIndividualSettingsProxy 
.const [143] = Utf8 class$ 
.const [144] = Utf8 (Ljava/lang/String;)Ljava/lang/Class; 
.const [145] = Utf8 java/lang/NoClassDefFoundError 
.const [146] = Utf8 initCause 
.const [147] = Utf8 (Ljava/lang/Throwable;)Ljava/lang/Throwable; 
.const [148] = Utf8 de/audi/app/car/core/charisma/proxy/AbstractCharismaIndividualSettingsProxy 
.const [149] = Utf8 clients 
.const [150] = Utf8 Ljava/util/ArrayList; 
.const [151] = Utf8 de/audi/app/car/core/charisma/proxy/AbstractCharismaIndividualSettingsProxy 
.const [152] = Utf8 mutex 
.const [153] = Utf8 Ljava/lang/Object; 
.const [154] = Utf8 de/audi/app/car/core/charisma/proxy/AbstractCharismaIndividualSettingsProxy 
.const [155] = Utf8 logChannel 
.const [156] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [157] = Utf8 java/lang/Class 
.const [158] = Utf8 getName 
.const [159] = Utf8 ()Ljava/lang/String; 
.const [160] = Utf8 de/audi/app/car/core/charisma/proxy/AbstractCharismaIndividualSettingsProxy 
.const [161] = Utf8 serviceProvider 
.const [162] = Utf8 Lde/audi/app/car/common/service/CarServiceProvider; 
.const [163] = Utf8 de/audi/app/car/common/service/CarServiceProvider 
.const [164] = Utf8 startService 
.const [165] = Utf8 ()V 
.const [166] = Utf8 de/audi/app/car/common/service/CarServiceProvider 
.const [167] = Utf8 stopService 
.const [168] = Utf8 ()V 
.const [169] = Utf8 java/util/ArrayList 
.const [170] = Utf8 clear 
.const [171] = Utf8 ()V 
.const [172] = Utf8 java/util/ArrayList 
.const [173] = Utf8 size 
.const [174] = Utf8 ()I 
.const [175] = Utf8 de/audi/atip/log/LogChannel 
.const [176] = Utf8 isInfo 
.const [177] = Utf8 ()Z 
.const [178] = Utf8 de/audi/atip/log/LogChannel 
.const [179] = Utf8 log 
.const [180] = Utf8 (ILjava/lang/String;)Z 
.const [181] = Utf8 java/util/ArrayList 
.const [182] = Utf8 contains 
.const [183] = Utf8 (Ljava/lang/Object;)Z 
.const [184] = Utf8 java/util/ArrayList 
.const [185] = Utf8 add 
.const [186] = Utf8 (Ljava/lang/Object;)Z 
.const [187] = Utf8 java/util/ArrayList 
.const [188] = Utf8 remove 
.const [189] = Utf8 (Ljava/lang/Object;)Z 
.const [190] = Utf8 java/util/ArrayList 
.const [191] = Utf8 get 
.const [192] = Utf8 (I)Ljava/lang/Object; 
.const [193] = Utf8 java/lang/NoClassDefFoundError 
.const [194] = Utf8 <init> 
.const [195] = Utf8 ()V 
.const [196] = Utf8 java/lang/Object 
.const [197] = Utf8 <init> 
.const [198] = Utf8 ()V 
.const [199] = Utf8 java/util/ArrayList 
.const [200] = Utf8 <init> 
.const [201] = Utf8 (I)V 
.const [202] = Utf8 de/audi/app/car/core/charisma/proxy/AbstractCharismaIndividualSettingsProxy 
.const [203] = Utf8 class$de$audi$app$car$core$charisma$proxy$ICharismaIndividualSettingsProxy 
.const [204] = Utf8 Ljava/lang/Class; 
.const [205] = Utf8 de/audi/app/car/common/service/CarServiceProvider 
.const [206] = Utf8 <init> 
.const [207] = Utf8 (Ljava/lang/String;Ljava/lang/Object;Ljava/util/Hashtable;Lorg/osgi/framework/BundleContext;Lde/audi/atip/log/LogChannel;)V 
.const [208] = Utf8 de/audi/app/car/core/charisma/proxy/AbstractCharismaIndividualSettingsProxy 
.const [209] = Utf8 clients 
.const [210] = Utf8 Ljava/util/ArrayList; 
.const [211] = Utf8 de/audi/app/car/core/charisma/proxy/AbstractCharismaIndividualSettingsProxy 
.const [212] = Utf8 mutex 
.const [213] = Utf8 Ljava/lang/Object; 
.const [214] = Utf8 de/audi/app/car/core/charisma/proxy/AbstractCharismaIndividualSettingsProxy 
.const [215] = Utf8 logChannel 
.const [216] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [217] = Utf8 de/audi/app/car/common/app/ICarApplication 
.const [218] = Utf8 getBundleContext 
.const [219] = Utf8 ()Lorg/osgi/framework/BundleContext; 
.const [220] = Utf8 de/audi/app/car/core/charisma/proxy/AbstractCharismaIndividualSettingsProxy 
.const [221] = Utf8 serviceProvider 
.const [222] = Utf8 Lde/audi/app/car/common/service/CarServiceProvider; 
.const [223] = Utf8 de/audi/app/car/core/charisma/proxy/ICharismaIndividualSettingsClient 
.const [224] = Utf8 notifySaveIndividualSettingsRequest 
.const [225] = Utf8 ()V 
.const [226] = Utf8 de/audi/app/car/core/charisma/proxy/AbstractCharismaIndividualSettingsProxy 
.const [227] = Class [226] 
.const [228] = Utf8 java/lang/Object 
.const [229] = Class [228] 
.const [230] = Utf8 de/audi/app/car/core/charisma/proxy/ICharismaIndividualSettingsProxy 
.const [231] = Class [230] 
.const [232] = Utf8 logChannel 
.const [233] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [234] = Utf8 serviceProvider 
.const [235] = Utf8 Lde/audi/app/car/common/service/CarServiceProvider; 
.const [236] = Utf8 clients 
.const [237] = Utf8 Ljava/util/ArrayList; 
.const [238] = Utf8 mutex 
.const [239] = Utf8 Ljava/lang/Object; 
.const [240] = Utf8 class$de$audi$app$car$core$charisma$proxy$ICharismaIndividualSettingsProxy 
.const [241] = Utf8 Ljava/lang/Class; 
.const [242] = Utf8 Code 
.const [243] = Utf8 <init> 
.const [244] = Utf8 (Lde/audi/app/car/common/app/ICarApplication;Lde/audi/atip/log/LogChannel;)V 
.const [245] = Utf8 init 
.const [246] = Utf8 ()V 
.const [247] = Utf8 deinit 
.const [248] = Utf8 ()V 
.const [249] = Utf8 hasClients 
.const [250] = Utf8 ()Z 
.const [251] = Utf8 registerClient 
.const [252] = Utf8 (Lde/audi/app/car/core/charisma/proxy/ICharismaIndividualSettingsClient;)V 
.const [253] = Utf8 unregisterClient 
.const [254] = Utf8 (Lde/audi/app/car/core/charisma/proxy/ICharismaIndividualSettingsClient;)V 
.const [255] = Utf8 invokeSaveIndividualSettingsRequest 
.const [256] = Utf8 ()V 
.const [257] = Utf8 class$ 
.const [258] = Utf8 (Ljava/lang/String;)Ljava/lang/Class; 
.end class 
