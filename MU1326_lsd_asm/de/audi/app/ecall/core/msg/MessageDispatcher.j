.version 50 0 
.class public super [294] 
.super [296] 
.implements [298] 
.implements [300] 
.field private final [301] [302] 
.field private final [303] [304] 
.field private final [305] [306] 
.field static synthetic [307] [308] 

.method public [310] : [311] 
    .attribute [309] .code stack 8 locals 0 
L0:     aload_0 
L1:     invokespecial [50] 
L4:     aload_0 
L5:     aload_1 
L6:     putfield [58] 
L9:     aload_0 
L10:    new [59] 
L13:    dup 
L14:    getstatic [6] 
L17:    ifnonnull L32 
L20:    ldc [7] 
L22:    invokestatic [8] 
L25:    dup 
L26:    putstatic [51] 
L29:    goto L35 
L32:    getstatic [6] 
L35:    invokevirtual [35] 
L38:    aload_0 
L39:    new [60] 
L42:    dup 
L43:    iconst_0 
L44:    invokespecial [52] 
L47:    aload_2 
L48:    aload_1 
L49:    invokespecial [53] 
L52:    putfield [61] 
L55:    aload_0 
L56:    new [62] 
L59:    dup 
L60:    invokespecial [54] 
L63:    putfield [63] 
L66:    return 
L67:    nop 
L68:    
    .end code 
.end method 

.method public [312] : [313] 
    .attribute [309] .code stack 3 locals 0 
L0:     aload_0 
L1:     getfield [34] 
L4:     ldc [11] 
L6:     ldc [12] 
L8:     invokevirtual [38] 
L11:    pop 
L12:    aload_0 
L13:    getfield [36] 
L16:    invokevirtual [39] 
L19:    return 
L20:    
    .end code 
.end method 

.method public [314] : [315] 
    .attribute [309] .code stack 3 locals 2 
L0:     aload_0 
L1:     getfield [34] 
L4:     ldc [11] 
L6:     ldc [13] 
L8:     invokevirtual [38] 
L11:    pop 
L12:    aload_0 
L13:    getfield [36] 
L16:    invokevirtual [40] 
L19:    aload_0 
L20:    getfield [37] 
L23:    dup 
L24:    astore_1 
L25:    monitorenter 
        .catch [0] from L26 to L37 using L40 
L26:    aload_0 
L27:    getfield [37] 
L30:    invokeinterface [64] 0 
L35:    aload_1 
L36:    monitorexit 
L37:    goto L45 
        .catch [0] from L40 to L43 using L40 
L40:    astore_2 
L41:    aload_1 
L42:    monitorexit 
L43:    aload_2 
L44:    athrow 
L45:    return 
L46:    nop 
L47:    nop 
L48:    
    .end code 
.end method 

.method public [316] : [317] 
    .attribute [309] .code stack 5 locals 3 
L0:     aload_0 
L1:     getfield [34] 
L4:     ldc [11] 
L6:     ldc [14] 
L8:     iload_1 
L9:     invokestatic [15] 
L12:    aload_2 
L13:    invokevirtual [41] 
L16:    invokevirtual [42] 
L19:    aload_0 
L20:    getfield [37] 
L23:    dup 
L24:    astore_3 
L25:    monitorenter 
        .catch [0] from L26 to L105 using L118 
L26:    aload_0 
L27:    getfield [37] 
L30:    new [65] 
L33:    dup 
L34:    iload_1 
L35:    invokespecial [55] 
L38:    invokeinterface [66] 0 
L43:    checkcast [17] 
L46:    astore 4 
L48:    aload 4 
L50:    ifnonnull L82 
L53:    new [67] 
L56:    dup 
L57:    invokespecial [56] 
L60:    astore 4 
L62:    aload_0 
L63:    getfield [37] 
L66:    new [65] 
L69:    dup 
L70:    iload_1 
L71:    invokespecial [55] 
L74:    aload 4 
L76:    invokeinterface [68] 0 
L81:    pop 
L82:    aload 4 
L84:    aload_2 
L85:    invokevirtual [43] 
L88:    ifeq L106 
L91:    aload_0 
L92:    getfield [34] 
L95:    ldc [11] 
L97:    ldc [18] 
L99:    invokevirtual [38] 
L102:   pop 
L103:   aload_3 
L104:   monitorexit 
L105:   return 
        .catch [0] from L106 to L115 using L118 
L106:   aload 4 
L108:   aload_2 
L109:   invokevirtual [44] 
L112:   pop 
L113:   aload_3 
L114:   monitorexit 
L115:   goto L125 
        .catch [0] from L118 to L122 using L118 
L118:   astore 5 
L120:   aload_3 
L121:   monitorexit 
L122:   aload 5 
L124:   athrow 
L125:   return 
L126:   nop 
L127:   nop 
L128:   
    .end code 
.end method 

.method public [318] : [319] 
    .attribute [309] .code stack 5 locals 3 
L0:     aload_0 
L1:     getfield [34] 
L4:     ldc [11] 
L6:     ldc [19] 
L8:     iload_1 
L9:     invokestatic [15] 
L12:    aload_2 
L13:    invokevirtual [41] 
L16:    invokevirtual [42] 
L19:    aload_0 
L20:    getfield [37] 
L23:    dup 
L24:    astore_3 
L25:    monitorenter 
        .catch [0] from L26 to L55 using L68 
L26:    aload_0 
L27:    getfield [37] 
L30:    new [65] 
L33:    dup 
L34:    iload_1 
L35:    invokespecial [55] 
L38:    invokeinterface [66] 0 
L43:    checkcast [17] 
L46:    astore 4 
L48:    aload 4 
L50:    ifnonnull L56 
L53:    aload_3 
L54:    monitorexit 
L55:    return 
        .catch [0] from L56 to L65 using L68 
L56:    aload 4 
L58:    aload_2 
L59:    invokevirtual [45] 
L62:    pop 
L63:    aload_3 
L64:    monitorexit 
L65:    goto L75 
        .catch [0] from L68 to L72 using L68 
L68:    astore 5 
L70:    aload_3 
L71:    monitorexit 
L72:    aload 5 
L74:    athrow 
L75:    return 
L76:    
    .end code 
.end method 

.method public [320] : [321] 
    .attribute [309] .code stack 5 locals 4 
L0:     aload_0 
L1:     getfield [37] 
L4:     dup 
L5:     astore_3 
L6:     monitorenter 
        .catch [0] from L7 to L36 using L51 
L7:     aload_0 
L8:     getfield [37] 
L11:    new [65] 
L14:    dup 
L15:    iload_1 
L16:    invokespecial [55] 
L19:    invokeinterface [66] 0 
L24:    checkcast [17] 
L27:    astore 4 
L29:    aload 4 
L31:    ifnonnull L37 
L34:    aload_3 
L35:    monitorexit 
L36:    return 
        .catch [0] from L37 to L48 using L51 
L37:    aload 4 
L39:    invokevirtual [46] 
L42:    checkcast [17] 
L45:    astore_2 
L46:    aload_3 
L47:    monitorexit 
L48:    goto L58 
        .catch [0] from L51 to L55 using L51 
L51:    astore 5 
L53:    aload_3 
L54:    monitorexit 
L55:    aload 5 
L57:    athrow 
L58:    aload_2 
L59:    invokeinterface [69] 0 
L64:    astore_3 
L65:    aload_3 
L66:    invokeinterface [70] 0 
L71:    ifeq L125 
        .catch [23] from L74 to L103 using L106 
L74:    aload_0 
L75:    getfield [34] 
L78:    ldc [20] 
L80:    ldc [21] 
L82:    iload_1 
L83:    i2l 
L84:    invokevirtual [47] 
L87:    pop 
L88:    aload_3 
L89:    invokeinterface [71] 0 
L94:    checkcast [22] 
L97:    iload_1 
L98:    invokeinterface [72] 0 
L103:   goto L65 
L106:   astore 4 
L108:   aload_0 
L109:   getfield [34] 
L112:   ldc [24] 
L114:   ldc [25] 
L116:   aload 4 
L118:   invokevirtual [48] 
L121:   pop 
L122:   goto L65 
L125:   return 
L126:   nop 
L127:   nop 
L128:   
    .end code 
.end method 

.method static synthetic [322] : [323] 
    .attribute [309] .code stack 2 locals 1 
        .catch [3] from L0 to L4 using L5 
L0:     aload_0 
L1:     invokestatic [2] 
L4:     areturn 
L5:     astore_1 
L6:     new [57] 
L9:     dup 
L10:    invokespecial [49] 
L13:    aload_1 
L14:    invokevirtual [33] 
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
.const [5] = Class [77] 
.const [6] = Field [78] [79] 
.const [7] = String [80] 
.const [8] = Method [81] [82] 
.const [9] = Class [83] 
.const [10] = Class [84] 
.const [11] = Int -2137614336 
.const [12] = String [85] 
.const [13] = String [86] 
.const [14] = String [87] 
.const [15] = Method [88] [89] 
.const [16] = Class [90] 
.const [17] = Class [91] 
.const [18] = String [92] 
.const [19] = String [93] 
.const [20] = Int 1078071040 
.const [21] = String [94] 
.const [22] = Class [95] 
.const [23] = Class [96] 
.const [24] = Int -1601830656 
.const [25] = String [97] 
.const [26] = Class [98] 
.const [27] = Class [99] 
.const [28] = Class [100] 
.const [29] = Class [101] 
.const [30] = Class [102] 
.const [31] = Class [103] 
.const [32] = Class [104] 
.const [33] = Method [105] [106] 
.const [34] = Field [107] [108] 
.const [35] = Method [109] [110] 
.const [36] = Field [111] [112] 
.const [37] = Field [113] [114] 
.const [38] = Method [115] [116] 
.const [39] = Method [117] [118] 
.const [40] = Method [119] [120] 
.const [41] = Method [121] [122] 
.const [42] = Method [123] [124] 
.const [43] = Method [125] [126] 
.const [44] = Method [127] [128] 
.const [45] = Method [129] [130] 
.const [46] = Method [131] [132] 
.const [47] = Method [133] [134] 
.const [48] = Method [135] [136] 
.const [49] = Method [137] [138] 
.const [50] = Method [139] [140] 
.const [51] = Field [141] [142] 
.const [52] = Method [143] [144] 
.const [53] = Method [145] [146] 
.const [54] = Method [147] [148] 
.const [55] = Method [149] [150] 
.const [56] = Method [151] [152] 
.const [57] = Class [153] 
.const [58] = Field [154] [155] 
.const [59] = Class [156] 
.const [60] = Class [157] 
.const [61] = Field [158] [159] 
.const [62] = Class [160] 
.const [63] = Field [161] [162] 
.const [64] = InterfaceMethod [163] [164] 
.const [65] = Class [165] 
.const [66] = InterfaceMethod [166] [167] 
.const [67] = Class [168] 
.const [68] = InterfaceMethod [169] [170] 
.const [69] = InterfaceMethod [171] [172] 
.const [70] = InterfaceMethod [173] [174] 
.const [71] = InterfaceMethod [175] [176] 
.const [72] = InterfaceMethod [177] [178] 
.const [73] = Class [179] 
.const [74] = NameAndType [180] [181] 
.const [75] = Utf8 java/lang/ClassNotFoundException 
.const [76] = Utf8 java/lang/NoClassDefFoundError 
.const [77] = Utf8 de/audi/app/ecall/core/osgi/EcallServiceProvider 
.const [78] = Class [182] 
.const [79] = NameAndType [183] [184] 
.const [80] = Utf8 'de.audi.atip.msg.MsgListener' 
.const [81] = Class [185] 
.const [82] = NameAndType [186] [187] 
.const [83] = Utf8 java/util/Hashtable 
.const [84] = Utf8 java/util/HashMap 
.const [85] = Utf8 '[MessageDispatcher#init] called' 
.const [86] = Utf8 '[MessageDispatcher#deinit] called' 
.const [87] = Utf8 "[MessageDispatcher#addMessageListener] msgID='%1', listener='%2'" 
.const [88] = Class [188] 
.const [89] = NameAndType [189] [190] 
.const [90] = Utf8 java/lang/Integer 
.const [91] = Utf8 java/util/LinkedList 
.const [92] = Utf8 '[MessageDispatcher#addMessageListener] Listener is already added.' 
.const [93] = Utf8 "[MessageDispatcher#removeMessageListener] msgID='%1', listener='%2'" 
.const [94] = Utf8 "[MessageDispatcher#processMsg] msgID='%1'" 
.const [95] = Utf8 de/audi/atip/msg/MsgListener 
.const [96] = Utf8 java/lang/Exception 
.const [97] = Utf8 '[MessageDispatcher#processMsg] exception occured: ' 
.const [98] = Utf8 de/audi/app/ecall/core/msg/MessageDispatcher 
.const [99] = Utf8 java/lang/Object 
.const [100] = Utf8 java/lang/Class 
.const [101] = Utf8 de/audi/atip/log/LogChannel 
.const [102] = Utf8 java/util/Map 
.const [103] = Utf8 java/util/List 
.const [104] = Utf8 java/util/Iterator 
.const [105] = Class [191] 
.const [106] = NameAndType [192] [193] 
.const [107] = Class [194] 
.const [108] = NameAndType [195] [196] 
.const [109] = Class [197] 
.const [110] = NameAndType [198] [199] 
.const [111] = Class [200] 
.const [112] = NameAndType [201] [202] 
.const [113] = Class [203] 
.const [114] = NameAndType [204] [205] 
.const [115] = Class [206] 
.const [116] = NameAndType [207] [208] 
.const [117] = Class [209] 
.const [118] = NameAndType [210] [211] 
.const [119] = Class [212] 
.const [120] = NameAndType [213] [214] 
.const [121] = Class [215] 
.const [122] = NameAndType [216] [217] 
.const [123] = Class [218] 
.const [124] = NameAndType [219] [220] 
.const [125] = Class [221] 
.const [126] = NameAndType [222] [223] 
.const [127] = Class [224] 
.const [128] = NameAndType [225] [226] 
.const [129] = Class [227] 
.const [130] = NameAndType [228] [229] 
.const [131] = Class [230] 
.const [132] = NameAndType [231] [232] 
.const [133] = Class [233] 
.const [134] = NameAndType [234] [235] 
.const [135] = Class [236] 
.const [136] = NameAndType [237] [238] 
.const [137] = Class [239] 
.const [138] = NameAndType [240] [241] 
.const [139] = Class [242] 
.const [140] = NameAndType [243] [244] 
.const [141] = Class [245] 
.const [142] = NameAndType [246] [247] 
.const [143] = Class [248] 
.const [144] = NameAndType [249] [250] 
.const [145] = Class [251] 
.const [146] = NameAndType [252] [253] 
.const [147] = Class [254] 
.const [148] = NameAndType [255] [256] 
.const [149] = Class [257] 
.const [150] = NameAndType [258] [259] 
.const [151] = Class [260] 
.const [152] = NameAndType [261] [262] 
.const [153] = Utf8 java/lang/NoClassDefFoundError 
.const [154] = Class [263] 
.const [155] = NameAndType [264] [265] 
.const [156] = Utf8 de/audi/app/ecall/core/osgi/EcallServiceProvider 
.const [157] = Utf8 java/util/Hashtable 
.const [158] = Class [266] 
.const [159] = NameAndType [267] [268] 
.const [160] = Utf8 java/util/HashMap 
.const [161] = Class [269] 
.const [162] = NameAndType [270] [271] 
.const [163] = Class [272] 
.const [164] = NameAndType [273] [274] 
.const [165] = Utf8 java/lang/Integer 
.const [166] = Class [275] 
.const [167] = NameAndType [276] [277] 
.const [168] = Utf8 java/util/LinkedList 
.const [169] = Class [278] 
.const [170] = NameAndType [279] [280] 
.const [171] = Class [281] 
.const [172] = NameAndType [282] [283] 
.const [173] = Class [284] 
.const [174] = NameAndType [285] [286] 
.const [175] = Class [287] 
.const [176] = NameAndType [288] [289] 
.const [177] = Class [290] 
.const [178] = NameAndType [291] [292] 
.const [179] = Utf8 java/lang/Class 
.const [180] = Utf8 forName 
.const [181] = Utf8 (Ljava/lang/String;)Ljava/lang/Class; 
.const [182] = Utf8 de/audi/app/ecall/core/msg/MessageDispatcher 
.const [183] = Utf8 class$de$audi$atip$msg$MsgListener 
.const [184] = Utf8 Ljava/lang/Class; 
.const [185] = Utf8 de/audi/app/ecall/core/msg/MessageDispatcher 
.const [186] = Utf8 class$ 
.const [187] = Utf8 (Ljava/lang/String;)Ljava/lang/Class; 
.const [188] = Utf8 java/lang/Integer 
.const [189] = Utf8 toString 
.const [190] = Utf8 (I)Ljava/lang/String; 
.const [191] = Utf8 java/lang/NoClassDefFoundError 
.const [192] = Utf8 initCause 
.const [193] = Utf8 (Ljava/lang/Throwable;)Ljava/lang/Throwable; 
.const [194] = Utf8 de/audi/app/ecall/core/msg/MessageDispatcher 
.const [195] = Utf8 logChannel 
.const [196] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [197] = Utf8 java/lang/Class 
.const [198] = Utf8 getName 
.const [199] = Utf8 ()Ljava/lang/String; 
.const [200] = Utf8 de/audi/app/ecall/core/msg/MessageDispatcher 
.const [201] = Utf8 msgListenerProvider 
.const [202] = Utf8 Lde/audi/app/ecall/core/osgi/EcallServiceProvider; 
.const [203] = Utf8 de/audi/app/ecall/core/msg/MessageDispatcher 
.const [204] = Utf8 listeners 
.const [205] = Utf8 Ljava/util/Map; 
.const [206] = Utf8 de/audi/atip/log/LogChannel 
.const [207] = Utf8 log 
.const [208] = Utf8 (ILjava/lang/String;)Z 
.const [209] = Utf8 de/audi/app/ecall/core/osgi/EcallServiceProvider 
.const [210] = Utf8 startService 
.const [211] = Utf8 ()V 
.const [212] = Utf8 de/audi/app/ecall/core/osgi/EcallServiceProvider 
.const [213] = Utf8 stopService 
.const [214] = Utf8 ()V 
.const [215] = Utf8 java/lang/Object 
.const [216] = Utf8 toString 
.const [217] = Utf8 ()Ljava/lang/String; 
.const [218] = Utf8 de/audi/atip/log/LogChannel 
.const [219] = Utf8 log 
.const [220] = Utf8 (ILjava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V 
.const [221] = Utf8 java/util/LinkedList 
.const [222] = Utf8 contains 
.const [223] = Utf8 (Ljava/lang/Object;)Z 
.const [224] = Utf8 java/util/LinkedList 
.const [225] = Utf8 add 
.const [226] = Utf8 (Ljava/lang/Object;)Z 
.const [227] = Utf8 java/util/LinkedList 
.const [228] = Utf8 remove 
.const [229] = Utf8 (Ljava/lang/Object;)Z 
.const [230] = Utf8 java/util/LinkedList 
.const [231] = Utf8 clone 
.const [232] = Utf8 ()Ljava/lang/Object; 
.const [233] = Utf8 de/audi/atip/log/LogChannel 
.const [234] = Utf8 log 
.const [235] = Utf8 (ILjava/lang/String;J)Z 
.const [236] = Utf8 de/audi/atip/log/LogChannel 
.const [237] = Utf8 log 
.const [238] = Utf8 (ILjava/lang/String;Ljava/lang/Throwable;)Z 
.const [239] = Utf8 java/lang/NoClassDefFoundError 
.const [240] = Utf8 <init> 
.const [241] = Utf8 ()V 
.const [242] = Utf8 java/lang/Object 
.const [243] = Utf8 <init> 
.const [244] = Utf8 ()V 
.const [245] = Utf8 de/audi/app/ecall/core/msg/MessageDispatcher 
.const [246] = Utf8 class$de$audi$atip$msg$MsgListener 
.const [247] = Utf8 Ljava/lang/Class; 
.const [248] = Utf8 java/util/Hashtable 
.const [249] = Utf8 <init> 
.const [250] = Utf8 (I)V 
.const [251] = Utf8 de/audi/app/ecall/core/osgi/EcallServiceProvider 
.const [252] = Utf8 <init> 
.const [253] = Utf8 (Ljava/lang/String;Ljava/lang/Object;Ljava/util/Hashtable;Lorg/osgi/framework/BundleContext;Lde/audi/atip/log/LogChannel;)V 
.const [254] = Utf8 java/util/HashMap 
.const [255] = Utf8 <init> 
.const [256] = Utf8 ()V 
.const [257] = Utf8 java/lang/Integer 
.const [258] = Utf8 <init> 
.const [259] = Utf8 (I)V 
.const [260] = Utf8 java/util/LinkedList 
.const [261] = Utf8 <init> 
.const [262] = Utf8 ()V 
.const [263] = Utf8 de/audi/app/ecall/core/msg/MessageDispatcher 
.const [264] = Utf8 logChannel 
.const [265] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [266] = Utf8 de/audi/app/ecall/core/msg/MessageDispatcher 
.const [267] = Utf8 msgListenerProvider 
.const [268] = Utf8 Lde/audi/app/ecall/core/osgi/EcallServiceProvider; 
.const [269] = Utf8 de/audi/app/ecall/core/msg/MessageDispatcher 
.const [270] = Utf8 listeners 
.const [271] = Utf8 Ljava/util/Map; 
.const [272] = Utf8 java/util/Map 
.const [273] = Utf8 clear 
.const [274] = Utf8 ()V 
.const [275] = Utf8 java/util/Map 
.const [276] = Utf8 get 
.const [277] = Utf8 (Ljava/lang/Object;)Ljava/lang/Object; 
.const [278] = Utf8 java/util/Map 
.const [279] = Utf8 put 
.const [280] = Utf8 (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object; 
.const [281] = Utf8 java/util/List 
.const [282] = Utf8 iterator 
.const [283] = Utf8 ()Ljava/util/Iterator; 
.const [284] = Utf8 java/util/Iterator 
.const [285] = Utf8 hasNext 
.const [286] = Utf8 ()Z 
.const [287] = Utf8 java/util/Iterator 
.const [288] = Utf8 next 
.const [289] = Utf8 ()Ljava/lang/Object; 
.const [290] = Utf8 de/audi/atip/msg/MsgListener 
.const [291] = Utf8 processMsg 
.const [292] = Utf8 (I)V 
.const [293] = Utf8 de/audi/app/ecall/core/msg/MessageDispatcher 
.const [294] = Class [293] 
.const [295] = Utf8 java/lang/Object 
.const [296] = Class [295] 
.const [297] = Utf8 de/audi/app/ecall/core/msg/IMessageDispatcher 
.const [298] = Class [297] 
.const [299] = Utf8 de/audi/atip/msg/MsgListener 
.const [300] = Class [299] 
.const [301] = Utf8 logChannel 
.const [302] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [303] = Utf8 listeners 
.const [304] = Utf8 Ljava/util/Map; 
.const [305] = Utf8 msgListenerProvider 
.const [306] = Utf8 Lde/audi/app/ecall/core/osgi/EcallServiceProvider; 
.const [307] = Utf8 class$de$audi$atip$msg$MsgListener 
.const [308] = Utf8 Ljava/lang/Class; 
.const [309] = Utf8 Code 
.const [310] = Utf8 <init> 
.const [311] = Utf8 (Lde/audi/atip/log/LogChannel;Lorg/osgi/framework/BundleContext;)V 
.const [312] = Utf8 init 
.const [313] = Utf8 ()V 
.const [314] = Utf8 deinit 
.const [315] = Utf8 ()V 
.const [316] = Utf8 addMessageListener 
.const [317] = Utf8 (ILde/audi/atip/msg/MsgListener;)V 
.const [318] = Utf8 removeMessageListener 
.const [319] = Utf8 (ILde/audi/atip/msg/MsgListener;)V 
.const [320] = Utf8 processMsg 
.const [321] = Utf8 (I)V 
.const [322] = Utf8 class$ 
.const [323] = Utf8 (Ljava/lang/String;)Ljava/lang/Class; 
.end class 
