.version 50 0 
.class public super [220] 
.super [222] 
.implements [224] 
.field private static final [225] [226] 
.field private final [227] [228] 
.field private final [229] [230] 
.field private final [231] [232] 
.field private volatile [233] [234] 
.field private [235] [236] 
.field static synthetic [237] [238] 

.method public [240] : [241] 
    .attribute [239] .code stack 2 locals 0 
L0:     aload_0 
L1:     invokespecial [39] 
L4:     aload_0 
L5:     aconst_null 
L6:     putfield [44] 
L9:     aload_0 
L10:    aload_1 
L11:    putfield [45] 
L14:    aload_0 
L15:    aload_2 
L16:    putfield [46] 
L19:    aload_0 
L20:    aload_3 
L21:    putfield [47] 
L24:    return 
L25:    nop 
L26:    nop 
L27:    nop 
L28:    
    .end code 
.end method 

.method public [242] : [243] 
    .attribute [239] .code stack 7 locals 0 
L0:     aload_0 
L1:     getfield [26] 
L4:     ldc [5] 
L6:     ldc [6] 
L8:     ldc [7] 
L10:    invokevirtual [29] 
L13:    pop 
L14:    aload_0 
L15:    aload_0 
L16:    getfield [27] 
L19:    getstatic [8] 
L22:    ifnonnull L37 
L25:    ldc [9] 
L27:    invokestatic [10] 
L30:    dup 
L31:    putstatic [40] 
L34:    goto L40 
L37:    getstatic [8] 
L40:    aload_0 
L41:    new [48] 
L44:    dup 
L45:    iconst_0 
L46:    invokespecial [41] 
L49:    invokeinterface [49] 0 
L54:    putfield [50] 
L57:    return 
L58:    nop 
L59:    nop 
L60:    
    .end code 
.end method 

.method public [244] : [245] 
    .attribute [239] .code stack 4 locals 0 
L0:     aload_0 
L1:     getfield [26] 
L4:     ldc [5] 
L6:     ldc [12] 
L8:     ldc [7] 
L10:    invokevirtual [29] 
L13:    pop 
L14:    aload_0 
L15:    getfield [27] 
L18:    aload_0 
L19:    getfield [30] 
L22:    invokeinterface [51] 0 
L27:    return 
L28:    
    .end code 
.end method 

.method public [246] : [247] 
    .attribute [239] .code stack 5 locals 0 
L0:     aload_0 
L1:     getfield [26] 
L4:     ldc [5] 
L6:     ldc [13] 
L8:     ldc [7] 
L10:    aload_1 
L11:    invokevirtual [31] 
L14:    aload_0 
L15:    getfield [28] 
L18:    aload_1 
L19:    iconst_1 
L20:    iconst_0 
L21:    invokevirtual [32] 
L24:    aload_0 
L25:    aload_1 
L26:    putfield [44] 
L29:    return 
L30:    nop 
L31:    nop 
L32:    
    .end code 
.end method 

.method public [248] : [249] 
    .attribute [239] .code stack 6 locals 0 
L0:     aload_0 
L1:     getfield [26] 
L4:     ldc [5] 
L6:     ldc [14] 
L8:     ldc [7] 
L10:    iload_1 
L11:    i2l 
L12:    invokevirtual [33] 
L15:    pop 
L16:    aload_0 
L17:    getfield [28] 
L20:    aload_0 
L21:    getfield [25] 
L24:    iconst_1 
L25:    iload_1 
L26:    invokevirtual [32] 
L29:    return 
L30:    nop 
L31:    nop 
L32:    
    .end code 
.end method 

.method public [250] : [251] 
    .attribute [239] .code stack 4 locals 0 
L0:     aload_0 
L1:     getfield [26] 
L4:     ldc [5] 
L6:     ldc [15] 
L8:     ldc [7] 
L10:    invokevirtual [29] 
L13:    pop 
L14:    aload_0 
L15:    getfield [28] 
L18:    aload_0 
L19:    getfield [25] 
L22:    iconst_0 
L23:    iconst_0 
L24:    invokevirtual [32] 
L27:    aload_0 
L28:    aconst_null 
L29:    putfield [44] 
L32:    return 
L33:    nop 
L34:    nop 
L35:    nop 
L36:    
    .end code 
.end method 

.method public [252] : [253] 
    .attribute [239] .code stack 3 locals 1 
L0:     new [52] 
L3:     dup 
L4:     bipush 20 
L6:     invokespecial [42] 
L9:     astore_1 
L10:    aload_1 
L11:    ldc [7] 
L13:    invokevirtual [34] 
L16:    ldc [17] 
L18:    invokevirtual [34] 
L21:    aload_0 
L22:    invokevirtual [35] 
L25:    invokevirtual [36] 
L28:    pop 
L29:    aload_1 
L30:    invokevirtual [37] 
L33:    areturn 
L34:    nop 
L35:    nop 
L36:    
    .end code 
.end method 

.method static synthetic [254] : [255] 
    .attribute [239] .code stack 2 locals 1 
        .catch [3] from L0 to L4 using L5 
L0:     aload_0 
L1:     invokestatic [2] 
L4:     areturn 
L5:     astore_1 
L6:     new [43] 
L9:     dup 
L10:    invokespecial [38] 
L13:    aload_1 
L14:    invokevirtual [24] 
L17:    athrow 
L18:    nop 
L19:    nop 
L20:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Method [53] [54] 
.const [3] = Class [55] 
.const [4] = Class [56] 
.const [5] = Int 1078071040 
.const [6] = String [57] 
.const [7] = String [58] 
.const [8] = Field [59] [60] 
.const [9] = String [61] 
.const [10] = Method [62] [63] 
.const [11] = Class [64] 
.const [12] = String [65] 
.const [13] = String [66] 
.const [14] = String [67] 
.const [15] = String [68] 
.const [16] = Class [69] 
.const [17] = String [70] 
.const [18] = Class [71] 
.const [19] = Class [72] 
.const [20] = Class [73] 
.const [21] = Class [74] 
.const [22] = Class [75] 
.const [23] = Class [76] 
.const [24] = Method [77] [78] 
.const [25] = Field [79] [80] 
.const [26] = Field [81] [82] 
.const [27] = Field [83] [84] 
.const [28] = Field [85] [86] 
.const [29] = Method [87] [88] 
.const [30] = Field [89] [90] 
.const [31] = Method [91] [92] 
.const [32] = Method [93] [94] 
.const [33] = Method [95] [96] 
.const [34] = Method [97] [98] 
.const [35] = Method [99] [100] 
.const [36] = Method [101] [102] 
.const [37] = Method [103] [104] 
.const [38] = Method [105] [106] 
.const [39] = Method [107] [108] 
.const [40] = Field [109] [110] 
.const [41] = Method [111] [112] 
.const [42] = Method [113] [114] 
.const [43] = Class [115] 
.const [44] = Field [116] [117] 
.const [45] = Field [118] [119] 
.const [46] = Field [120] [121] 
.const [47] = Field [122] [123] 
.const [48] = Class [124] 
.const [49] = InterfaceMethod [125] [126] 
.const [50] = Field [127] [128] 
.const [51] = InterfaceMethod [129] [130] 
.const [52] = Class [131] 
.const [53] = Class [132] 
.const [54] = NameAndType [133] [134] 
.const [55] = Utf8 java/lang/ClassNotFoundException 
.const [56] = Utf8 java/lang/NoClassDefFoundError 
.const [57] = Utf8 '[%1.init]' 
.const [58] = Utf8 CombiBAPTransferStateListener 
.const [59] = Class [135] 
.const [60] = NameAndType [136] [137] 
.const [61] = Utf8 'de.audi.app.media.interapp.ITransferStateListener' 
.const [62] = Class [138] 
.const [63] = NameAndType [139] [140] 
.const [64] = Utf8 java/util/Hashtable 
.const [65] = Utf8 '[%1.deinit]' 
.const [66] = Utf8 "[%1.importStarted] '%2'" 
.const [67] = Utf8 "[%1.importProgressChanged] '%2'" 
.const [68] = Utf8 '[%1.importStopped]' 
.const [69] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [70] = Utf8 '@' 
.const [71] = Utf8 de/audi/app/media/combi/bap/CombiBAPTransferStateListener 
.const [72] = Utf8 java/lang/Object 
.const [73] = Utf8 java/lang/Class 
.const [74] = Utf8 de/audi/atip/log/LogChannel 
.const [75] = Utf8 de/audi/app/media/osgi/IServiceManager 
.const [76] = Utf8 de/audi/app/media/combi/bap/CombiBAPController 
.const [77] = Class [141] 
.const [78] = NameAndType [142] [143] 
.const [79] = Class [144] 
.const [80] = NameAndType [145] [146] 
.const [81] = Class [147] 
.const [82] = NameAndType [148] [149] 
.const [83] = Class [150] 
.const [84] = NameAndType [151] [152] 
.const [85] = Class [153] 
.const [86] = NameAndType [154] [155] 
.const [87] = Class [156] 
.const [88] = NameAndType [157] [158] 
.const [89] = Class [159] 
.const [90] = NameAndType [160] [161] 
.const [91] = Class [162] 
.const [92] = NameAndType [163] [164] 
.const [93] = Class [165] 
.const [94] = NameAndType [166] [167] 
.const [95] = Class [168] 
.const [96] = NameAndType [169] [170] 
.const [97] = Class [171] 
.const [98] = NameAndType [172] [173] 
.const [99] = Class [174] 
.const [100] = NameAndType [175] [176] 
.const [101] = Class [177] 
.const [102] = NameAndType [178] [179] 
.const [103] = Class [180] 
.const [104] = NameAndType [181] [182] 
.const [105] = Class [183] 
.const [106] = NameAndType [184] [185] 
.const [107] = Class [186] 
.const [108] = NameAndType [187] [188] 
.const [109] = Class [189] 
.const [110] = NameAndType [190] [191] 
.const [111] = Class [192] 
.const [112] = NameAndType [193] [194] 
.const [113] = Class [195] 
.const [114] = NameAndType [196] [197] 
.const [115] = Utf8 java/lang/NoClassDefFoundError 
.const [116] = Class [198] 
.const [117] = NameAndType [199] [200] 
.const [118] = Class [201] 
.const [119] = NameAndType [202] [203] 
.const [120] = Class [204] 
.const [121] = NameAndType [205] [206] 
.const [122] = Class [207] 
.const [123] = NameAndType [208] [209] 
.const [124] = Utf8 java/util/Hashtable 
.const [125] = Class [210] 
.const [126] = NameAndType [211] [212] 
.const [127] = Class [213] 
.const [128] = NameAndType [214] [215] 
.const [129] = Class [216] 
.const [130] = NameAndType [217] [218] 
.const [131] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [132] = Utf8 java/lang/Class 
.const [133] = Utf8 forName 
.const [134] = Utf8 (Ljava/lang/String;)Ljava/lang/Class; 
.const [135] = Utf8 de/audi/app/media/combi/bap/CombiBAPTransferStateListener 
.const [136] = Utf8 class$de$audi$app$media$interapp$ITransferStateListener 
.const [137] = Utf8 Ljava/lang/Class; 
.const [138] = Utf8 de/audi/app/media/combi/bap/CombiBAPTransferStateListener 
.const [139] = Utf8 class$ 
.const [140] = Utf8 (Ljava/lang/String;)Ljava/lang/Class; 
.const [141] = Utf8 java/lang/NoClassDefFoundError 
.const [142] = Utf8 initCause 
.const [143] = Utf8 (Ljava/lang/Throwable;)Ljava/lang/Throwable; 
.const [144] = Utf8 de/audi/app/media/combi/bap/CombiBAPTransferStateListener 
.const [145] = Utf8 activeImportSlot 
.const [146] = Utf8 Lde/audi/app/media/source/ISourceSlot; 
.const [147] = Utf8 de/audi/app/media/combi/bap/CombiBAPTransferStateListener 
.const [148] = Utf8 logger 
.const [149] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [150] = Utf8 de/audi/app/media/combi/bap/CombiBAPTransferStateListener 
.const [151] = Utf8 serviceManager 
.const [152] = Utf8 Lde/audi/app/media/osgi/IServiceManager; 
.const [153] = Utf8 de/audi/app/media/combi/bap/CombiBAPTransferStateListener 
.const [154] = Utf8 bapController 
.const [155] = Utf8 Lde/audi/app/media/combi/bap/CombiBAPController; 
.const [156] = Utf8 de/audi/atip/log/LogChannel 
.const [157] = Utf8 log 
.const [158] = Utf8 (ILjava/lang/String;Ljava/lang/Object;)Z 
.const [159] = Utf8 de/audi/app/media/combi/bap/CombiBAPTransferStateListener 
.const [160] = Utf8 serviceRegistration 
.const [161] = Utf8 Lorg/osgi/framework/ServiceRegistration; 
.const [162] = Utf8 de/audi/atip/log/LogChannel 
.const [163] = Utf8 log 
.const [164] = Utf8 (ILjava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V 
.const [165] = Utf8 de/audi/app/media/combi/bap/CombiBAPController 
.const [166] = Utf8 updateImportState 
.const [167] = Utf8 (Lde/audi/app/media/source/ISourceSlot;ZI)V 
.const [168] = Utf8 de/audi/atip/log/LogChannel 
.const [169] = Utf8 log 
.const [170] = Utf8 (ILjava/lang/String;Ljava/lang/Object;J)Z 
.const [171] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [172] = Utf8 append 
.const [173] = Utf8 (Ljava/lang/String;)Lde/esolutions/fw/util/commons/Buffer; 
.const [174] = Utf8 java/lang/Object 
.const [175] = Utf8 hashCode 
.const [176] = Utf8 ()I 
.const [177] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [178] = Utf8 append 
.const [179] = Utf8 (I)Lde/esolutions/fw/util/commons/Buffer; 
.const [180] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [181] = Utf8 toString 
.const [182] = Utf8 ()Ljava/lang/String; 
.const [183] = Utf8 java/lang/NoClassDefFoundError 
.const [184] = Utf8 <init> 
.const [185] = Utf8 ()V 
.const [186] = Utf8 java/lang/Object 
.const [187] = Utf8 <init> 
.const [188] = Utf8 ()V 
.const [189] = Utf8 de/audi/app/media/combi/bap/CombiBAPTransferStateListener 
.const [190] = Utf8 class$de$audi$app$media$interapp$ITransferStateListener 
.const [191] = Utf8 Ljava/lang/Class; 
.const [192] = Utf8 java/util/Hashtable 
.const [193] = Utf8 <init> 
.const [194] = Utf8 (I)V 
.const [195] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [196] = Utf8 <init> 
.const [197] = Utf8 (I)V 
.const [198] = Utf8 de/audi/app/media/combi/bap/CombiBAPTransferStateListener 
.const [199] = Utf8 activeImportSlot 
.const [200] = Utf8 Lde/audi/app/media/source/ISourceSlot; 
.const [201] = Utf8 de/audi/app/media/combi/bap/CombiBAPTransferStateListener 
.const [202] = Utf8 logger 
.const [203] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [204] = Utf8 de/audi/app/media/combi/bap/CombiBAPTransferStateListener 
.const [205] = Utf8 serviceManager 
.const [206] = Utf8 Lde/audi/app/media/osgi/IServiceManager; 
.const [207] = Utf8 de/audi/app/media/combi/bap/CombiBAPTransferStateListener 
.const [208] = Utf8 bapController 
.const [209] = Utf8 Lde/audi/app/media/combi/bap/CombiBAPController; 
.const [210] = Utf8 de/audi/app/media/osgi/IServiceManager 
.const [211] = Utf8 registerService 
.const [212] = Utf8 (Ljava/lang/Class;Ljava/lang/Object;Ljava/util/Dictionary;)Lorg/osgi/framework/ServiceRegistration; 
.const [213] = Utf8 de/audi/app/media/combi/bap/CombiBAPTransferStateListener 
.const [214] = Utf8 serviceRegistration 
.const [215] = Utf8 Lorg/osgi/framework/ServiceRegistration; 
.const [216] = Utf8 de/audi/app/media/osgi/IServiceManager 
.const [217] = Utf8 unregisterService 
.const [218] = Utf8 (Lorg/osgi/framework/ServiceRegistration;)V 
.const [219] = Utf8 de/audi/app/media/combi/bap/CombiBAPTransferStateListener 
.const [220] = Class [219] 
.const [221] = Utf8 java/lang/Object 
.const [222] = Class [221] 
.const [223] = Utf8 de/audi/app/media/interapp/ITransferStateListener 
.const [224] = Class [223] 
.const [225] = Utf8 LOGCLASS 
.const [226] = Utf8 Ljava/lang/String; 
.const [227] = Utf8 logger 
.const [228] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [229] = Utf8 serviceManager 
.const [230] = Utf8 Lde/audi/app/media/osgi/IServiceManager; 
.const [231] = Utf8 bapController 
.const [232] = Utf8 Lde/audi/app/media/combi/bap/CombiBAPController; 
.const [233] = Utf8 serviceRegistration 
.const [234] = Utf8 Lorg/osgi/framework/ServiceRegistration; 
.const [235] = Utf8 activeImportSlot 
.const [236] = Utf8 Lde/audi/app/media/source/ISourceSlot; 
.const [237] = Utf8 class$de$audi$app$media$interapp$ITransferStateListener 
.const [238] = Utf8 Ljava/lang/Class; 
.const [239] = Utf8 Code 
.const [240] = Utf8 <init> 
.const [241] = Utf8 (Lde/audi/atip/log/LogChannel;Lde/audi/app/media/osgi/IServiceManager;Lde/audi/app/media/combi/bap/CombiBAPController;)V 
.const [242] = Utf8 init 
.const [243] = Utf8 ()V 
.const [244] = Utf8 deinit 
.const [245] = Utf8 ()V 
.const [246] = Utf8 importStarted 
.const [247] = Utf8 (Lde/audi/app/media/source/ISourceSlot;)V 
.const [248] = Utf8 importProgressChanged 
.const [249] = Utf8 (I)V 
.const [250] = Utf8 importStopped 
.const [251] = Utf8 ()V 
.const [252] = Utf8 toString 
.const [253] = Utf8 ()Ljava/lang/String; 
.const [254] = Utf8 class$ 
.const [255] = Utf8 (Ljava/lang/String;)Ljava/lang/Class; 
.end class 
