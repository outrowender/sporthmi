.version 50 0 
.class public super [293] 
.super [295] 
.implements [297] 
.implements [299] 
.field private final [300] [301] 
.field private final [302] [303] 
.field private final [304] [305] 
.field static synthetic [306] [307] 

.method public [309] : [310] 
    .attribute [308] .code stack 8 locals 0 
L0:     aload_0 
L1:     invokespecial [49] 
L4:     aload_0 
L5:     aload_1 
L6:     putfield [57] 
L9:     aload_0 
L10:    new [58] 
L13:    dup 
L14:    getstatic [6] 
L17:    ifnonnull L32 
L20:    ldc [7] 
L22:    invokestatic [8] 
L25:    dup 
L26:    putstatic [50] 
L29:    goto L35 
L32:    getstatic [6] 
L35:    invokevirtual [34] 
L38:    aload_0 
L39:    new [59] 
L42:    dup 
L43:    iconst_0 
L44:    invokespecial [51] 
L47:    aload_2 
L48:    aload_1 
L49:    invokespecial [52] 
L52:    putfield [60] 
L55:    aload_0 
L56:    new [61] 
L59:    dup 
L60:    invokespecial [53] 
L63:    putfield [62] 
L66:    return 
L67:    nop 
L68:    
    .end code 
.end method 

.method public [311] : [312] 
    .attribute [308] .code stack 3 locals 0 
L0:     aload_0 
L1:     getfield [33] 
L4:     ldc [11] 
L6:     ldc [12] 
L8:     invokevirtual [37] 
L11:    pop 
L12:    aload_0 
L13:    getfield [35] 
L16:    invokevirtual [38] 
L19:    return 
L20:    
    .end code 
.end method 

.method public [313] : [314] 
    .attribute [308] .code stack 3 locals 2 
L0:     aload_0 
L1:     getfield [33] 
L4:     ldc [11] 
L6:     ldc [13] 
L8:     invokevirtual [37] 
L11:    pop 
L12:    aload_0 
L13:    getfield [35] 
L16:    invokevirtual [39] 
L19:    aload_0 
L20:    getfield [36] 
L23:    dup 
L24:    astore_1 
L25:    monitorenter 
        .catch [0] from L26 to L37 using L40 
L26:    aload_0 
L27:    getfield [36] 
L30:    invokeinterface [63] 0 
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

.method public [315] : [316] 
    .attribute [308] .code stack 5 locals 3 
L0:     aload_0 
L1:     getfield [33] 
L4:     ldc [11] 
L6:     ldc [14] 
L8:     iload_1 
L9:     invokestatic [15] 
L12:    aload_2 
L13:    invokevirtual [40] 
L16:    invokevirtual [41] 
L19:    aload_0 
L20:    getfield [36] 
L23:    dup 
L24:    astore_3 
L25:    monitorenter 
        .catch [0] from L26 to L105 using L118 
L26:    aload_0 
L27:    getfield [36] 
L30:    new [64] 
L33:    dup 
L34:    iload_1 
L35:    invokespecial [54] 
L38:    invokeinterface [65] 0 
L43:    checkcast [17] 
L46:    astore 4 
L48:    aload 4 
L50:    ifnonnull L82 
L53:    new [66] 
L56:    dup 
L57:    invokespecial [55] 
L60:    astore 4 
L62:    aload_0 
L63:    getfield [36] 
L66:    new [64] 
L69:    dup 
L70:    iload_1 
L71:    invokespecial [54] 
L74:    aload 4 
L76:    invokeinterface [67] 0 
L81:    pop 
L82:    aload 4 
L84:    aload_2 
L85:    invokevirtual [42] 
L88:    ifeq L106 
L91:    aload_0 
L92:    getfield [33] 
L95:    ldc [11] 
L97:    ldc [18] 
L99:    invokevirtual [37] 
L102:   pop 
L103:   aload_3 
L104:   monitorexit 
L105:   return 
        .catch [0] from L106 to L115 using L118 
L106:   aload 4 
L108:   aload_2 
L109:   invokevirtual [43] 
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

.method public [317] : [318] 
    .attribute [308] .code stack 5 locals 3 
L0:     aload_0 
L1:     getfield [33] 
L4:     ldc [11] 
L6:     ldc [19] 
L8:     iload_1 
L9:     invokestatic [15] 
L12:    aload_2 
L13:    invokevirtual [40] 
L16:    invokevirtual [41] 
L19:    aload_0 
L20:    getfield [36] 
L23:    dup 
L24:    astore_3 
L25:    monitorenter 
        .catch [0] from L26 to L55 using L68 
L26:    aload_0 
L27:    getfield [36] 
L30:    new [64] 
L33:    dup 
L34:    iload_1 
L35:    invokespecial [54] 
L38:    invokeinterface [65] 0 
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
L59:    invokevirtual [44] 
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

.method public [319] : [320] 
    .attribute [308] .code stack 5 locals 4 
L0:     aload_0 
L1:     getfield [33] 
L4:     ldc [11] 
L6:     ldc [20] 
L8:     iload_1 
L9:     i2l 
L10:    invokevirtual [45] 
L13:    pop 
L14:    aload_0 
L15:    getfield [36] 
L18:    dup 
L19:    astore_3 
L20:    monitorenter 
        .catch [0] from L21 to L50 using L65 
L21:    aload_0 
L22:    getfield [36] 
L25:    new [64] 
L28:    dup 
L29:    iload_1 
L30:    invokespecial [54] 
L33:    invokeinterface [65] 0 
L38:    checkcast [17] 
L41:    astore 4 
L43:    aload 4 
L45:    ifnonnull L51 
L48:    aload_3 
L49:    monitorexit 
L50:    return 
        .catch [0] from L51 to L62 using L65 
L51:    aload 4 
L53:    invokevirtual [46] 
L56:    checkcast [17] 
L59:    astore_2 
L60:    aload_3 
L61:    monitorexit 
L62:    goto L72 
        .catch [0] from L65 to L69 using L65 
L65:    astore 5 
L67:    aload_3 
L68:    monitorexit 
L69:    aload 5 
L71:    athrow 
L72:    aload_2 
L73:    invokeinterface [68] 0 
L78:    astore_3 
L79:    aload_3 
L80:    invokeinterface [69] 0 
L85:    ifeq L125 
        .catch [22] from L88 to L103 using L106 
L88:    aload_3 
L89:    invokeinterface [70] 0 
L94:    checkcast [21] 
L97:    iload_1 
L98:    invokeinterface [71] 0 
L103:   goto L79 
L106:   astore 4 
L108:   aload_0 
L109:   getfield [33] 
L112:   ldc [23] 
L114:   ldc [24] 
L116:   aload 4 
L118:   invokevirtual [47] 
L121:   pop 
L122:   goto L79 
L125:   return 
L126:   nop 
L127:   nop 
L128:   
    .end code 
.end method 

.method static synthetic [321] : [322] 
    .attribute [308] .code stack 2 locals 1 
        .catch [3] from L0 to L4 using L5 
L0:     aload_0 
L1:     invokestatic [2] 
L4:     areturn 
L5:     astore_1 
L6:     new [56] 
L9:     dup 
L10:    invokespecial [48] 
L13:    aload_1 
L14:    invokevirtual [32] 
L17:    athrow 
L18:    nop 
L19:    nop 
L20:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Method [72] [73] 
.const [3] = Class [74] 
.const [4] = Class [75] 
.const [5] = Class [76] 
.const [6] = Field [77] [78] 
.const [7] = String [79] 
.const [8] = Method [80] [81] 
.const [9] = Class [82] 
.const [10] = Class [83] 
.const [11] = Int 1078071040 
.const [12] = String [84] 
.const [13] = String [85] 
.const [14] = String [86] 
.const [15] = Method [87] [88] 
.const [16] = Class [89] 
.const [17] = Class [90] 
.const [18] = String [91] 
.const [19] = String [92] 
.const [20] = String [93] 
.const [21] = Class [94] 
.const [22] = Class [95] 
.const [23] = Int -1601830656 
.const [24] = String [96] 
.const [25] = Class [97] 
.const [26] = Class [98] 
.const [27] = Class [99] 
.const [28] = Class [100] 
.const [29] = Class [101] 
.const [30] = Class [102] 
.const [31] = Class [103] 
.const [32] = Method [104] [105] 
.const [33] = Field [106] [107] 
.const [34] = Method [108] [109] 
.const [35] = Field [110] [111] 
.const [36] = Field [112] [113] 
.const [37] = Method [114] [115] 
.const [38] = Method [116] [117] 
.const [39] = Method [118] [119] 
.const [40] = Method [120] [121] 
.const [41] = Method [122] [123] 
.const [42] = Method [124] [125] 
.const [43] = Method [126] [127] 
.const [44] = Method [128] [129] 
.const [45] = Method [130] [131] 
.const [46] = Method [132] [133] 
.const [47] = Method [134] [135] 
.const [48] = Method [136] [137] 
.const [49] = Method [138] [139] 
.const [50] = Field [140] [141] 
.const [51] = Method [142] [143] 
.const [52] = Method [144] [145] 
.const [53] = Method [146] [147] 
.const [54] = Method [148] [149] 
.const [55] = Method [150] [151] 
.const [56] = Class [152] 
.const [57] = Field [153] [154] 
.const [58] = Class [155] 
.const [59] = Class [156] 
.const [60] = Field [157] [158] 
.const [61] = Class [159] 
.const [62] = Field [160] [161] 
.const [63] = InterfaceMethod [162] [163] 
.const [64] = Class [164] 
.const [65] = InterfaceMethod [165] [166] 
.const [66] = Class [167] 
.const [67] = InterfaceMethod [168] [169] 
.const [68] = InterfaceMethod [170] [171] 
.const [69] = InterfaceMethod [172] [173] 
.const [70] = InterfaceMethod [174] [175] 
.const [71] = InterfaceMethod [176] [177] 
.const [72] = Class [178] 
.const [73] = NameAndType [179] [180] 
.const [74] = Utf8 java/lang/ClassNotFoundException 
.const [75] = Utf8 java/lang/NoClassDefFoundError 
.const [76] = Utf8 de/audi/app/car/common/service/CarServiceProvider 
.const [77] = Class [181] 
.const [78] = NameAndType [182] [183] 
.const [79] = Utf8 'de.audi.atip.msg.MsgListener' 
.const [80] = Class [184] 
.const [81] = NameAndType [185] [186] 
.const [82] = Utf8 java/util/Hashtable 
.const [83] = Utf8 java/util/HashMap 
.const [84] = Utf8 '[MessageDispatcher#init] called' 
.const [85] = Utf8 '[MessageDispatcher#deinit] called' 
.const [86] = Utf8 "[MessageDispatcher#addMessageListener] msgID='%1', listener='%2'" 
.const [87] = Class [187] 
.const [88] = NameAndType [188] [189] 
.const [89] = Utf8 java/lang/Integer 
.const [90] = Utf8 java/util/LinkedList 
.const [91] = Utf8 '[MessageDispatcher#addMessageListener] Listener is already added.' 
.const [92] = Utf8 "[MessageDispatcher#removeMessageListener] msgID='%1', listener='%2'" 
.const [93] = Utf8 "[MessageDispatcher#processMsg] msgID='%1'" 
.const [94] = Utf8 de/audi/atip/msg/MsgListener 
.const [95] = Utf8 java/lang/Exception 
.const [96] = Utf8 '[MessageDispatcher#processMsg] exception occured: ' 
.const [97] = Utf8 de/audi/app/car/common/md/MessageDispatcher 
.const [98] = Utf8 java/lang/Object 
.const [99] = Utf8 java/lang/Class 
.const [100] = Utf8 de/audi/atip/log/LogChannel 
.const [101] = Utf8 java/util/Map 
.const [102] = Utf8 java/util/List 
.const [103] = Utf8 java/util/Iterator 
.const [104] = Class [190] 
.const [105] = NameAndType [191] [192] 
.const [106] = Class [193] 
.const [107] = NameAndType [194] [195] 
.const [108] = Class [196] 
.const [109] = NameAndType [197] [198] 
.const [110] = Class [199] 
.const [111] = NameAndType [200] [201] 
.const [112] = Class [202] 
.const [113] = NameAndType [203] [204] 
.const [114] = Class [205] 
.const [115] = NameAndType [206] [207] 
.const [116] = Class [208] 
.const [117] = NameAndType [209] [210] 
.const [118] = Class [211] 
.const [119] = NameAndType [212] [213] 
.const [120] = Class [214] 
.const [121] = NameAndType [215] [216] 
.const [122] = Class [217] 
.const [123] = NameAndType [218] [219] 
.const [124] = Class [220] 
.const [125] = NameAndType [221] [222] 
.const [126] = Class [223] 
.const [127] = NameAndType [224] [225] 
.const [128] = Class [226] 
.const [129] = NameAndType [227] [228] 
.const [130] = Class [229] 
.const [131] = NameAndType [230] [231] 
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
.const [152] = Utf8 java/lang/NoClassDefFoundError 
.const [153] = Class [262] 
.const [154] = NameAndType [263] [264] 
.const [155] = Utf8 de/audi/app/car/common/service/CarServiceProvider 
.const [156] = Utf8 java/util/Hashtable 
.const [157] = Class [265] 
.const [158] = NameAndType [266] [267] 
.const [159] = Utf8 java/util/HashMap 
.const [160] = Class [268] 
.const [161] = NameAndType [269] [270] 
.const [162] = Class [271] 
.const [163] = NameAndType [272] [273] 
.const [164] = Utf8 java/lang/Integer 
.const [165] = Class [274] 
.const [166] = NameAndType [275] [276] 
.const [167] = Utf8 java/util/LinkedList 
.const [168] = Class [277] 
.const [169] = NameAndType [278] [279] 
.const [170] = Class [280] 
.const [171] = NameAndType [281] [282] 
.const [172] = Class [283] 
.const [173] = NameAndType [284] [285] 
.const [174] = Class [286] 
.const [175] = NameAndType [287] [288] 
.const [176] = Class [289] 
.const [177] = NameAndType [290] [291] 
.const [178] = Utf8 java/lang/Class 
.const [179] = Utf8 forName 
.const [180] = Utf8 (Ljava/lang/String;)Ljava/lang/Class; 
.const [181] = Utf8 de/audi/app/car/common/md/MessageDispatcher 
.const [182] = Utf8 class$de$audi$atip$msg$MsgListener 
.const [183] = Utf8 Ljava/lang/Class; 
.const [184] = Utf8 de/audi/app/car/common/md/MessageDispatcher 
.const [185] = Utf8 class$ 
.const [186] = Utf8 (Ljava/lang/String;)Ljava/lang/Class; 
.const [187] = Utf8 java/lang/Integer 
.const [188] = Utf8 toString 
.const [189] = Utf8 (I)Ljava/lang/String; 
.const [190] = Utf8 java/lang/NoClassDefFoundError 
.const [191] = Utf8 initCause 
.const [192] = Utf8 (Ljava/lang/Throwable;)Ljava/lang/Throwable; 
.const [193] = Utf8 de/audi/app/car/common/md/MessageDispatcher 
.const [194] = Utf8 logChannel 
.const [195] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [196] = Utf8 java/lang/Class 
.const [197] = Utf8 getName 
.const [198] = Utf8 ()Ljava/lang/String; 
.const [199] = Utf8 de/audi/app/car/common/md/MessageDispatcher 
.const [200] = Utf8 msgListenerProvider 
.const [201] = Utf8 Lde/audi/app/car/common/service/CarServiceProvider; 
.const [202] = Utf8 de/audi/app/car/common/md/MessageDispatcher 
.const [203] = Utf8 listeners 
.const [204] = Utf8 Ljava/util/Map; 
.const [205] = Utf8 de/audi/atip/log/LogChannel 
.const [206] = Utf8 log 
.const [207] = Utf8 (ILjava/lang/String;)Z 
.const [208] = Utf8 de/audi/app/car/common/service/CarServiceProvider 
.const [209] = Utf8 startService 
.const [210] = Utf8 ()V 
.const [211] = Utf8 de/audi/app/car/common/service/CarServiceProvider 
.const [212] = Utf8 stopService 
.const [213] = Utf8 ()V 
.const [214] = Utf8 java/lang/Object 
.const [215] = Utf8 toString 
.const [216] = Utf8 ()Ljava/lang/String; 
.const [217] = Utf8 de/audi/atip/log/LogChannel 
.const [218] = Utf8 log 
.const [219] = Utf8 (ILjava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V 
.const [220] = Utf8 java/util/LinkedList 
.const [221] = Utf8 contains 
.const [222] = Utf8 (Ljava/lang/Object;)Z 
.const [223] = Utf8 java/util/LinkedList 
.const [224] = Utf8 add 
.const [225] = Utf8 (Ljava/lang/Object;)Z 
.const [226] = Utf8 java/util/LinkedList 
.const [227] = Utf8 remove 
.const [228] = Utf8 (Ljava/lang/Object;)Z 
.const [229] = Utf8 de/audi/atip/log/LogChannel 
.const [230] = Utf8 log 
.const [231] = Utf8 (ILjava/lang/String;J)Z 
.const [232] = Utf8 java/util/LinkedList 
.const [233] = Utf8 clone 
.const [234] = Utf8 ()Ljava/lang/Object; 
.const [235] = Utf8 de/audi/atip/log/LogChannel 
.const [236] = Utf8 log 
.const [237] = Utf8 (ILjava/lang/String;Ljava/lang/Throwable;)Z 
.const [238] = Utf8 java/lang/NoClassDefFoundError 
.const [239] = Utf8 <init> 
.const [240] = Utf8 ()V 
.const [241] = Utf8 java/lang/Object 
.const [242] = Utf8 <init> 
.const [243] = Utf8 ()V 
.const [244] = Utf8 de/audi/app/car/common/md/MessageDispatcher 
.const [245] = Utf8 class$de$audi$atip$msg$MsgListener 
.const [246] = Utf8 Ljava/lang/Class; 
.const [247] = Utf8 java/util/Hashtable 
.const [248] = Utf8 <init> 
.const [249] = Utf8 (I)V 
.const [250] = Utf8 de/audi/app/car/common/service/CarServiceProvider 
.const [251] = Utf8 <init> 
.const [252] = Utf8 (Ljava/lang/String;Ljava/lang/Object;Ljava/util/Hashtable;Lorg/osgi/framework/BundleContext;Lde/audi/atip/log/LogChannel;)V 
.const [253] = Utf8 java/util/HashMap 
.const [254] = Utf8 <init> 
.const [255] = Utf8 ()V 
.const [256] = Utf8 java/lang/Integer 
.const [257] = Utf8 <init> 
.const [258] = Utf8 (I)V 
.const [259] = Utf8 java/util/LinkedList 
.const [260] = Utf8 <init> 
.const [261] = Utf8 ()V 
.const [262] = Utf8 de/audi/app/car/common/md/MessageDispatcher 
.const [263] = Utf8 logChannel 
.const [264] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [265] = Utf8 de/audi/app/car/common/md/MessageDispatcher 
.const [266] = Utf8 msgListenerProvider 
.const [267] = Utf8 Lde/audi/app/car/common/service/CarServiceProvider; 
.const [268] = Utf8 de/audi/app/car/common/md/MessageDispatcher 
.const [269] = Utf8 listeners 
.const [270] = Utf8 Ljava/util/Map; 
.const [271] = Utf8 java/util/Map 
.const [272] = Utf8 clear 
.const [273] = Utf8 ()V 
.const [274] = Utf8 java/util/Map 
.const [275] = Utf8 get 
.const [276] = Utf8 (Ljava/lang/Object;)Ljava/lang/Object; 
.const [277] = Utf8 java/util/Map 
.const [278] = Utf8 put 
.const [279] = Utf8 (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object; 
.const [280] = Utf8 java/util/List 
.const [281] = Utf8 iterator 
.const [282] = Utf8 ()Ljava/util/Iterator; 
.const [283] = Utf8 java/util/Iterator 
.const [284] = Utf8 hasNext 
.const [285] = Utf8 ()Z 
.const [286] = Utf8 java/util/Iterator 
.const [287] = Utf8 next 
.const [288] = Utf8 ()Ljava/lang/Object; 
.const [289] = Utf8 de/audi/atip/msg/MsgListener 
.const [290] = Utf8 processMsg 
.const [291] = Utf8 (I)V 
.const [292] = Utf8 de/audi/app/car/common/md/MessageDispatcher 
.const [293] = Class [292] 
.const [294] = Utf8 java/lang/Object 
.const [295] = Class [294] 
.const [296] = Utf8 de/audi/app/car/common/md/IMessageDispatcher 
.const [297] = Class [296] 
.const [298] = Utf8 de/audi/atip/msg/MsgListener 
.const [299] = Class [298] 
.const [300] = Utf8 logChannel 
.const [301] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [302] = Utf8 listeners 
.const [303] = Utf8 Ljava/util/Map; 
.const [304] = Utf8 msgListenerProvider 
.const [305] = Utf8 Lde/audi/app/car/common/service/CarServiceProvider; 
.const [306] = Utf8 class$de$audi$atip$msg$MsgListener 
.const [307] = Utf8 Ljava/lang/Class; 
.const [308] = Utf8 Code 
.const [309] = Utf8 <init> 
.const [310] = Utf8 (Lde/audi/atip/log/LogChannel;Lorg/osgi/framework/BundleContext;)V 
.const [311] = Utf8 init 
.const [312] = Utf8 ()V 
.const [313] = Utf8 deinit 
.const [314] = Utf8 ()V 
.const [315] = Utf8 addMessageListener 
.const [316] = Utf8 (ILde/audi/atip/msg/MsgListener;)V 
.const [317] = Utf8 removeMessageListener 
.const [318] = Utf8 (ILde/audi/atip/msg/MsgListener;)V 
.const [319] = Utf8 processMsg 
.const [320] = Utf8 (I)V 
.const [321] = Utf8 class$ 
.const [322] = Utf8 (Ljava/lang/String;)Ljava/lang/Class; 
.end class 
