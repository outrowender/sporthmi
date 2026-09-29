.version 50 0 
.class public super [197] 
.super [199] 
.implements [201] 
.field private static final [202] [203] 
.field private final [204] [205] 
.field private final [206] [207] 
.field private [208] [209] 
.field private [210] [211] 

.method public [213] : [214] 
    .attribute [212] .code stack 3 locals 0 
L0:     aload_0 
L1:     invokespecial [32] 
L4:     aload_0 
L5:     new [36] 
L8:     dup 
L9:     invokespecial [32] 
L12:    putfield [37] 
L15:    aload_0 
L16:    aconst_null 
L17:    putfield [38] 
L20:    aload_0 
L21:    iconst_0 
L22:    putfield [39] 
L25:    aload_0 
L26:    aload_1 
L27:    putfield [40] 
L30:    return 
L31:    nop 
L32:    
    .end code 
.end method 

.method public [215] : [216] 
    .attribute [212] .code stack 4 locals 2 
L0:     aload_0 
L1:     getfield [18] 
L4:     dup 
L5:     astore_2 
L6:     monitorenter 
        .catch [0] from L7 to L81 using L84 
L7:     aload_0 
L8:     aload_1 
L9:     putfield [38] 
L12:    aload_0 
L13:    invokespecial [33] 
L16:    invokevirtual [22] 
L19:    ifeq L64 
L22:    aload_0 
L23:    invokespecial [34] 
L26:    invokevirtual [23] 
L29:    invokeinterface [41] 0 
L34:    ifgt L64 
L37:    aload_0 
L38:    invokespecial [35] 
L41:    ldc [3] 
L43:    ldc [4] 
L45:    ldc [5] 
L47:    invokevirtual [24] 
L50:    pop 
L51:    aload_0 
L52:    iconst_3 
L53:    invokevirtual [25] 
L56:    aload_0 
L57:    iconst_3 
L58:    putfield [39] 
L61:    goto L79 
L64:    aload_0 
L65:    getfield [20] 
L68:    ifeq L79 
L71:    aload_0 
L72:    aload_0 
L73:    getfield [20] 
L76:    invokevirtual [25] 
L79:    aload_2 
L80:    monitorexit 
L81:    goto L89 
        .catch [0] from L84 to L87 using L84 
L84:    astore_3 
L85:    aload_2 
L86:    monitorexit 
L87:    aload_3 
L88:    athrow 
L89:    return 
L90:    nop 
L91:    nop 
L92:    
    .end code 
.end method 

.method public [217] : [218] 
    .attribute [212] .code stack 5 locals 3 
L0:     aload_0 
L1:     getfield [18] 
L4:     dup 
L5:     astore_2 
L6:     monitorenter 
L7:     aload_0 
L8:     getfield [20] 
L11:    iconst_3 
L12:    if_icmpeq L67 
L15:    aconst_null 
L16:    aload_0 
L17:    getfield [19] 
L20:    if_acmpeq L62 
        .catch [6] from L23 to L34 using L37 
        .catch [0] from L7 to L69 using L72 
L23:    aload_0 
L24:    getfield [19] 
L27:    aload_0 
L28:    iload_1 
L29:    invokeinterface [42] 0 
L34:    goto L54 
L37:    astore_3 
L38:    aload_0 
L39:    invokespecial [35] 
L42:    sipush 10000 
L45:    ldc [7] 
L47:    ldc [5] 
L49:    aload_3 
L50:    invokevirtual [26] 
L53:    pop 
L54:    aload_0 
L55:    iconst_0 
L56:    putfield [39] 
L59:    goto L67 
L62:    aload_0 
L63:    iload_1 
L64:    putfield [39] 
L67:    aload_2 
L68:    monitorexit 
L69:    goto L79 
        .catch [0] from L72 to L76 using L72 
L72:    astore 4 
L74:    aload_2 
L75:    monitorexit 
L76:    aload 4 
L78:    athrow 
L79:    return 
L80:    
    .end code 
.end method 

.method public [219] : [220] 
    .attribute [212] .code stack 2 locals 0 
L0:     aconst_null 
L1:     aload_0 
L2:     getfield [19] 
L5:     if_acmpeq L19 
L8:     aload_0 
L9:     getfield [19] 
L12:    aload_0 
L13:    invokeinterface [43] 0 
L18:    areturn 
L19:    iconst_0 
L20:    areturn 
L21:    nop 
L22:    nop 
L23:    nop 
L24:    
    .end code 
.end method 

.method public [221] : [222] 
    .attribute [212] .code stack 2 locals 0 
L0:     aconst_null 
L1:     aload_0 
L2:     getfield [19] 
L5:     if_acmpeq L19 
L8:     aload_0 
L9:     getfield [19] 
L12:    aload_0 
L13:    invokeinterface [44] 0 
L18:    areturn 
L19:    iconst_0 
L20:    areturn 
L21:    nop 
L22:    nop 
L23:    nop 
L24:    
    .end code 
.end method 

.method public [223] : [224] 
    .attribute [212] .code stack 1 locals 0 
L0:     iconst_1 
L1:     areturn 
L2:     nop 
L3:     nop 
L4:     
    .end code 
.end method 

.method public [225] : [226] 
    .attribute [212] .code stack 8 locals 0 
L0:     aload_0 
L1:     invokespecial [35] 
L4:     ldc [3] 
L6:     ldc [8] 
L8:     ldc [5] 
L10:    iload_1 
L11:    i2l 
L12:    iload_2 
L13:    i2l 
L14:    invokevirtual [27] 
L17:    pop 
L18:    iconst_4 
L19:    iload_1 
L20:    if_icmpeq L33 
L23:    aload_0 
L24:    invokespecial [33] 
L27:    invokevirtual [28] 
L30:    ifeq L64 
L33:    aload_0 
L34:    invokespecial [35] 
L37:    ldc [9] 
L39:    ldc [10] 
L41:    ldc [5] 
L43:    invokevirtual [24] 
L46:    pop 
L47:    aload_0 
L48:    invokespecial [34] 
L51:    iconst_0 
L52:    invokevirtual [29] 
L55:    iconst_0 
L56:    invokeinterface [45] 0 
L61:    goto L92 
L64:    aload_0 
L65:    invokespecial [35] 
L68:    ldc [9] 
L70:    ldc [11] 
L72:    ldc [5] 
L74:    invokevirtual [24] 
L77:    pop 
L78:    aload_0 
L79:    invokespecial [34] 
L82:    iconst_0 
L83:    invokevirtual [29] 
L86:    iconst_1 
L87:    invokeinterface [45] 0 
L92:    return 
L93:    nop 
L94:    nop 
L95:    nop 
L96:    
    .end code 
.end method 

.method private interface [227] : [228] 
    .attribute [212] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [21] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method private [229] : [230] 
    .attribute [212] .code stack 1 locals 0 
L0:     aload_0 
L1:     invokespecial [33] 
L4:     invokevirtual [30] 
L7:     areturn 
L8:     
    .end code 
.end method 

.method private [231] : [232] 
    .attribute [212] .code stack 1 locals 0 
L0:     aload_0 
L1:     invokespecial [33] 
L4:     invokevirtual [31] 
L7:     areturn 
L8:     
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [46] 
.const [3] = Int 1078071040 
.const [4] = String [47] 
.const [5] = String [48] 
.const [6] = Class [49] 
.const [7] = String [50] 
.const [8] = String [51] 
.const [9] = Int -2137614336 
.const [10] = String [52] 
.const [11] = String [53] 
.const [12] = Class [54] 
.const [13] = Class [55] 
.const [14] = Class [56] 
.const [15] = Class [57] 
.const [16] = Class [58] 
.const [17] = Class [59] 
.const [18] = Field [60] [61] 
.const [19] = Field [62] [63] 
.const [20] = Field [64] [65] 
.const [21] = Field [66] [67] 
.const [22] = Method [68] [69] 
.const [23] = Method [70] [71] 
.const [24] = Method [72] [73] 
.const [25] = Method [74] [75] 
.const [26] = Method [76] [77] 
.const [27] = Method [78] [79] 
.const [28] = Method [80] [81] 
.const [29] = Method [82] [83] 
.const [30] = Method [84] [85] 
.const [31] = Method [86] [87] 
.const [32] = Method [88] [89] 
.const [33] = Method [90] [91] 
.const [34] = Method [92] [93] 
.const [35] = Method [94] [95] 
.const [36] = Class [96] 
.const [37] = Field [97] [98] 
.const [38] = Field [99] [100] 
.const [39] = Field [101] [102] 
.const [40] = Field [103] [104] 
.const [41] = InterfaceMethod [105] [106] 
.const [42] = InterfaceMethod [107] [108] 
.const [43] = InterfaceMethod [109] [110] 
.const [44] = InterfaceMethod [111] [112] 
.const [45] = InterfaceMethod [113] [114] 
.const [46] = Utf8 java/lang/Object 
.const [47] = Utf8 '%1.setBulkCopyManager(): Uota is allowed, lock bulkCopyManager' 
.const [48] = Utf8 BulkCopyAccess 
.const [49] = Utf8 de/audi/atip/bulkcopy/BulkCopyException 
.const [50] = Utf8 '%1.setInitialBulkCopyClientState: Failed to set client state of BulkCopyClient!' 
.const [51] = Utf8 '%1 onChangeStateBulkCopy(%2, %3)' 
.const [52] = Utf8 '%1 onChangeStateBulkCopy: enable customer update button' 
.const [53] = Utf8 '%1 onChangeStateBulkCopy: disable customer update button' 
.const [54] = Utf8 de/audi/tghu/swdl/app/BulkCopyAccess 
.const [55] = Utf8 de/audi/tghu/swdl/app/SwdlEnv 
.const [56] = Utf8 de/audi/tghu/swdl/app/SwdlModels 
.const [57] = Utf8 de/audi/atip/hmi/modelaccess/ChoiceModelApp 
.const [58] = Utf8 de/audi/atip/log/LogChannel 
.const [59] = Utf8 de/audi/atip/bulkcopy/IBulkCopyManager 
.const [60] = Class [115] 
.const [61] = NameAndType [116] [117] 
.const [62] = Class [118] 
.const [63] = NameAndType [119] [120] 
.const [64] = Class [121] 
.const [65] = NameAndType [122] [123] 
.const [66] = Class [124] 
.const [67] = NameAndType [125] [126] 
.const [68] = Class [127] 
.const [69] = NameAndType [128] [129] 
.const [70] = Class [130] 
.const [71] = NameAndType [131] [132] 
.const [72] = Class [133] 
.const [73] = NameAndType [134] [135] 
.const [74] = Class [136] 
.const [75] = NameAndType [137] [138] 
.const [76] = Class [139] 
.const [77] = NameAndType [140] [141] 
.const [78] = Class [142] 
.const [79] = NameAndType [143] [144] 
.const [80] = Class [145] 
.const [81] = NameAndType [146] [147] 
.const [82] = Class [148] 
.const [83] = NameAndType [149] [150] 
.const [84] = Class [151] 
.const [85] = NameAndType [152] [153] 
.const [86] = Class [154] 
.const [87] = NameAndType [155] [156] 
.const [88] = Class [157] 
.const [89] = NameAndType [158] [159] 
.const [90] = Class [160] 
.const [91] = NameAndType [161] [162] 
.const [92] = Class [163] 
.const [93] = NameAndType [164] [165] 
.const [94] = Class [166] 
.const [95] = NameAndType [167] [168] 
.const [96] = Utf8 java/lang/Object 
.const [97] = Class [169] 
.const [98] = NameAndType [170] [171] 
.const [99] = Class [172] 
.const [100] = NameAndType [173] [174] 
.const [101] = Class [175] 
.const [102] = NameAndType [176] [177] 
.const [103] = Class [178] 
.const [104] = NameAndType [179] [180] 
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
.const [115] = Utf8 de/audi/tghu/swdl/app/BulkCopyAccess 
.const [116] = Utf8 bulkCopySync 
.const [117] = Utf8 Ljava/lang/Object; 
.const [118] = Utf8 de/audi/tghu/swdl/app/BulkCopyAccess 
.const [119] = Utf8 bulkCopyManager 
.const [120] = Utf8 Lde/audi/atip/bulkcopy/IBulkCopyManager; 
.const [121] = Utf8 de/audi/tghu/swdl/app/BulkCopyAccess 
.const [122] = Utf8 bulkCopyClientStateCache 
.const [123] = Utf8 I 
.const [124] = Utf8 de/audi/tghu/swdl/app/BulkCopyAccess 
.const [125] = Utf8 swdlEnv 
.const [126] = Utf8 Lde/audi/tghu/swdl/app/SwdlEnv; 
.const [127] = Utf8 de/audi/tghu/swdl/app/SwdlEnv 
.const [128] = Utf8 isUpdateOverTheAirFeatureEnabled 
.const [129] = Utf8 ()Z 
.const [130] = Utf8 de/audi/tghu/swdl/app/SwdlModels 
.const [131] = Utf8 getSwdlInProgressChoice 
.const [132] = Utf8 ()Lde/audi/atip/hmi/modelaccess/ChoiceModelApp; 
.const [133] = Utf8 de/audi/atip/log/LogChannel 
.const [134] = Utf8 log 
.const [135] = Utf8 (ILjava/lang/String;Ljava/lang/Object;)Z 
.const [136] = Utf8 de/audi/tghu/swdl/app/BulkCopyAccess 
.const [137] = Utf8 setInitialBulkCopyClientState 
.const [138] = Utf8 (I)V 
.const [139] = Utf8 de/audi/atip/log/LogChannel 
.const [140] = Utf8 log 
.const [141] = Utf8 (ILjava/lang/String;Ljava/lang/Object;Ljava/lang/Throwable;)Z 
.const [142] = Utf8 de/audi/atip/log/LogChannel 
.const [143] = Utf8 log 
.const [144] = Utf8 (ILjava/lang/String;Ljava/lang/Object;JJ)Z 
.const [145] = Utf8 de/audi/tghu/swdl/app/SwdlEnv 
.const [146] = Utf8 isCustomerDownloadActive 
.const [147] = Utf8 ()Z 
.const [148] = Utf8 de/audi/tghu/swdl/app/SwdlModels 
.const [149] = Utf8 getCustDlDisabledChoice 
.const [150] = Utf8 (I)Lde/audi/atip/hmi/modelaccess/ChoiceModelApp; 
.const [151] = Utf8 de/audi/tghu/swdl/app/SwdlEnv 
.const [152] = Utf8 getLogMain 
.const [153] = Utf8 ()Lde/audi/atip/log/LogChannel; 
.const [154] = Utf8 de/audi/tghu/swdl/app/SwdlEnv 
.const [155] = Utf8 getSwdlModels 
.const [156] = Utf8 ()Lde/audi/tghu/swdl/app/SwdlModels; 
.const [157] = Utf8 java/lang/Object 
.const [158] = Utf8 <init> 
.const [159] = Utf8 ()V 
.const [160] = Utf8 de/audi/tghu/swdl/app/BulkCopyAccess 
.const [161] = Utf8 getSwdlEnv 
.const [162] = Utf8 ()Lde/audi/tghu/swdl/app/SwdlEnv; 
.const [163] = Utf8 de/audi/tghu/swdl/app/BulkCopyAccess 
.const [164] = Utf8 getSwdlModels 
.const [165] = Utf8 ()Lde/audi/tghu/swdl/app/SwdlModels; 
.const [166] = Utf8 de/audi/tghu/swdl/app/BulkCopyAccess 
.const [167] = Utf8 getLogMain 
.const [168] = Utf8 ()Lde/audi/atip/log/LogChannel; 
.const [169] = Utf8 de/audi/tghu/swdl/app/BulkCopyAccess 
.const [170] = Utf8 bulkCopySync 
.const [171] = Utf8 Ljava/lang/Object; 
.const [172] = Utf8 de/audi/tghu/swdl/app/BulkCopyAccess 
.const [173] = Utf8 bulkCopyManager 
.const [174] = Utf8 Lde/audi/atip/bulkcopy/IBulkCopyManager; 
.const [175] = Utf8 de/audi/tghu/swdl/app/BulkCopyAccess 
.const [176] = Utf8 bulkCopyClientStateCache 
.const [177] = Utf8 I 
.const [178] = Utf8 de/audi/tghu/swdl/app/BulkCopyAccess 
.const [179] = Utf8 swdlEnv 
.const [180] = Utf8 Lde/audi/tghu/swdl/app/SwdlEnv; 
.const [181] = Utf8 de/audi/atip/hmi/modelaccess/ChoiceModelApp 
.const [182] = Utf8 getValue 
.const [183] = Utf8 ()I 
.const [184] = Utf8 de/audi/atip/bulkcopy/IBulkCopyManager 
.const [185] = Utf8 setClientState 
.const [186] = Utf8 (Lde/audi/atip/bulkcopy/IBulkCopyClient;I)V 
.const [187] = Utf8 de/audi/atip/bulkcopy/IBulkCopyManager 
.const [188] = Utf8 lock 
.const [189] = Utf8 (Lde/audi/atip/bulkcopy/IBulkCopyClient;)Z 
.const [190] = Utf8 de/audi/atip/bulkcopy/IBulkCopyManager 
.const [191] = Utf8 unlock 
.const [192] = Utf8 (Lde/audi/atip/bulkcopy/IBulkCopyClient;)Z 
.const [193] = Utf8 de/audi/atip/hmi/modelaccess/ChoiceModelApp 
.const [194] = Utf8 setValue 
.const [195] = Utf8 (I)V 
.const [196] = Utf8 de/audi/tghu/swdl/app/BulkCopyAccess 
.const [197] = Class [196] 
.const [198] = Utf8 java/lang/Object 
.const [199] = Class [198] 
.const [200] = Utf8 de/audi/atip/bulkcopy/IBulkCopyClient 
.const [201] = Class [200] 
.const [202] = Utf8 CLASSNAME 
.const [203] = Utf8 Ljava/lang/String; 
.const [204] = Utf8 swdlEnv 
.const [205] = Utf8 Lde/audi/tghu/swdl/app/SwdlEnv; 
.const [206] = Utf8 bulkCopySync 
.const [207] = Utf8 Ljava/lang/Object; 
.const [208] = Utf8 bulkCopyManager 
.const [209] = Utf8 Lde/audi/atip/bulkcopy/IBulkCopyManager; 
.const [210] = Utf8 bulkCopyClientStateCache 
.const [211] = Utf8 I 
.const [212] = Utf8 Code 
.const [213] = Utf8 <init> 
.const [214] = Utf8 (Lde/audi/tghu/swdl/app/SwdlEnv;)V 
.const [215] = Utf8 setBulkCopyManager 
.const [216] = Utf8 (Lde/audi/atip/bulkcopy/IBulkCopyManager;)V 
.const [217] = Utf8 setInitialBulkCopyClientState 
.const [218] = Utf8 (I)V 
.const [219] = Utf8 bulkCopyLock 
.const [220] = Utf8 ()Z 
.const [221] = Utf8 bulkCopyUnlock 
.const [222] = Utf8 ()Z 
.const [223] = Utf8 getClientType 
.const [224] = Utf8 ()I 
.const [225] = Utf8 onChangeStateBulkCopy 
.const [226] = Utf8 (II)V 
.const [227] = Utf8 getSwdlEnv 
.const [228] = Utf8 ()Lde/audi/tghu/swdl/app/SwdlEnv; 
.const [229] = Utf8 getLogMain 
.const [230] = Utf8 ()Lde/audi/atip/log/LogChannel; 
.const [231] = Utf8 getSwdlModels 
.const [232] = Utf8 ()Lde/audi/tghu/swdl/app/SwdlModels; 
.end class 
