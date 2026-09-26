.version 50 0 
.class public super [268] 
.super [270] 
.implements [272] 
.implements [274] 
.field private final [275] [276] 
.field private final [277] [278] 
.field private final [279] [280] 
.field private final [281] [282] 
.field static synthetic [283] [284] 

.method public [286] : [287] 
    .attribute [285] .code stack 8 locals 0 
L0:     aload_0 
L1:     invokespecial [43] 
L4:     aload_0 
L5:     aload_1 
L6:     putfield [51] 
L9:     aload_0 
L10:    new [54] 
L13:    dup 
L14:    getstatic [6] 
L17:    ifnonnull L32 
L20:    ldc [7] 
L22:    invokestatic [8] 
L25:    dup 
L26:    putstatic [44] 
L29:    goto L35 
L32:    getstatic [6] 
L35:    invokevirtual [30] 
L38:    aload_0 
L39:    new [55] 
L42:    dup 
L43:    iconst_0 
L44:    invokespecial [45] 
L47:    aload_2 
L48:    aload_1 
L49:    invokespecial [46] 
L52:    putfield [56] 
L55:    aload_0 
L56:    new [57] 
L59:    dup 
L60:    invokespecial [47] 
L63:    putfield [52] 
L66:    aload_0 
L67:    aload_3 
L68:    putfield [58] 
L71:    return 
L72:    
    .end code 
.end method 

.method public [288] : [289] 
    .attribute [285] .code stack 3 locals 0 
L0:     aload_0 
L1:     getfield [27] 
L4:     ldc [11] 
L6:     ldc [12] 
L8:     invokevirtual [33] 
L11:    pop 
L12:    aload_0 
L13:    getfield [31] 
L16:    invokevirtual [34] 
L19:    return 
L20:    
    .end code 
.end method 

.method public [290] : [291] 
    .attribute [285] .code stack 3 locals 2 
L0:     aload_0 
L1:     getfield [27] 
L4:     ldc [11] 
L6:     ldc [13] 
L8:     invokevirtual [33] 
L11:    pop 
L12:    aload_0 
L13:    getfield [31] 
L16:    invokevirtual [35] 
L19:    aload_0 
L20:    getfield [28] 
L23:    dup 
L24:    astore_1 
L25:    monitorenter 
        .catch [0] from L26 to L37 using L40 
L26:    aload_0 
L27:    getfield [28] 
L30:    invokeinterface [59] 0 
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

.method public [292] : [293] 
    .attribute [285] .code stack 5 locals 3 
L0:     aload_0 
L1:     getfield [27] 
L4:     ldc [11] 
L6:     ldc [14] 
L8:     iload_1 
L9:     invokestatic [15] 
L12:    aload_2 
L13:    invokevirtual [36] 
L16:    invokevirtual [37] 
L19:    aload_0 
L20:    getfield [28] 
L23:    dup 
L24:    astore_3 
L25:    monitorenter 
        .catch [0] from L26 to L105 using L118 
L26:    aload_0 
L27:    getfield [28] 
L30:    new [60] 
L33:    dup 
L34:    iload_1 
L35:    invokespecial [48] 
L38:    invokeinterface [61] 0 
L43:    checkcast [17] 
L46:    astore 4 
L48:    aload 4 
L50:    ifnonnull L82 
L53:    new [62] 
L56:    dup 
L57:    invokespecial [49] 
L60:    astore 4 
L62:    aload_0 
L63:    getfield [28] 
L66:    new [60] 
L69:    dup 
L70:    iload_1 
L71:    invokespecial [48] 
L74:    aload 4 
L76:    invokeinterface [63] 0 
L81:    pop 
L82:    aload 4 
L84:    aload_2 
L85:    invokevirtual [38] 
L88:    ifeq L106 
L91:    aload_0 
L92:    getfield [27] 
L95:    ldc [11] 
L97:    ldc [18] 
L99:    invokevirtual [33] 
L102:   pop 
L103:   aload_3 
L104:   monitorexit 
L105:   return 
        .catch [0] from L106 to L115 using L118 
L106:   aload 4 
L108:   aload_2 
L109:   invokevirtual [39] 
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

.method public [294] : [295] 
    .attribute [285] .code stack 5 locals 3 
L0:     aload_0 
L1:     getfield [27] 
L4:     ldc [11] 
L6:     ldc [19] 
L8:     iload_1 
L9:     invokestatic [15] 
L12:    aload_2 
L13:    invokevirtual [36] 
L16:    invokevirtual [37] 
L19:    aload_0 
L20:    getfield [28] 
L23:    dup 
L24:    astore_3 
L25:    monitorenter 
        .catch [0] from L26 to L55 using L68 
L26:    aload_0 
L27:    getfield [28] 
L30:    new [60] 
L33:    dup 
L34:    iload_1 
L35:    invokespecial [48] 
L38:    invokeinterface [61] 0 
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
L59:    invokevirtual [40] 
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

.method public [296] : [297] 
    .attribute [285] .code stack 6 locals 0 
L0:     aload_0 
L1:     getfield [32] 
L4:     new [64] 
L7:     dup 
L8:     aload_0 
L9:     iload_1 
L10:    iload_1 
L11:    invokespecial [50] 
L14:    invokevirtual [41] 
L17:    return 
L18:    nop 
L19:    nop 
L20:    
    .end code 
.end method 

.method static synthetic [298] : [299] 
    .attribute [285] .code stack 2 locals 1 
        .catch [3] from L0 to L4 using L5 
L0:     aload_0 
L1:     invokestatic [2] 
L4:     areturn 
L5:     astore_1 
L6:     new [53] 
L9:     dup 
L10:    invokespecial [42] 
L13:    aload_1 
L14:    invokevirtual [29] 
L17:    athrow 
L18:    nop 
L19:    nop 
L20:    
    .end code 
.end method 

.method static synthetic [300] : [301] 
    .attribute [285] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [28] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method static synthetic [302] : [303] 
    .attribute [285] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [27] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Method [65] [66] 
.const [3] = Class [67] 
.const [4] = Class [68] 
.const [5] = Class [69] 
.const [6] = Field [70] [71] 
.const [7] = String [72] 
.const [8] = Method [73] [74] 
.const [9] = Class [75] 
.const [10] = Class [76] 
.const [11] = Int -2137614336 
.const [12] = String [77] 
.const [13] = String [78] 
.const [14] = String [79] 
.const [15] = Method [80] [81] 
.const [16] = Class [82] 
.const [17] = Class [83] 
.const [18] = String [84] 
.const [19] = String [85] 
.const [20] = Class [86] 
.const [21] = Class [87] 
.const [22] = Class [88] 
.const [23] = Class [89] 
.const [24] = Class [90] 
.const [25] = Class [91] 
.const [26] = Class [92] 
.const [27] = Field [93] [94] 
.const [28] = Field [95] [96] 
.const [29] = Method [97] [98] 
.const [30] = Method [99] [100] 
.const [31] = Field [101] [102] 
.const [32] = Field [103] [104] 
.const [33] = Method [105] [106] 
.const [34] = Method [107] [108] 
.const [35] = Method [109] [110] 
.const [36] = Method [111] [112] 
.const [37] = Method [113] [114] 
.const [38] = Method [115] [116] 
.const [39] = Method [117] [118] 
.const [40] = Method [119] [120] 
.const [41] = Method [121] [122] 
.const [42] = Method [123] [124] 
.const [43] = Method [125] [126] 
.const [44] = Field [127] [128] 
.const [45] = Method [129] [130] 
.const [46] = Method [131] [132] 
.const [47] = Method [133] [134] 
.const [48] = Method [135] [136] 
.const [49] = Method [137] [138] 
.const [50] = Method [139] [140] 
.const [51] = Field [141] [142] 
.const [52] = Field [143] [144] 
.const [53] = Class [145] 
.const [54] = Class [146] 
.const [55] = Class [147] 
.const [56] = Field [148] [149] 
.const [57] = Class [150] 
.const [58] = Field [151] [152] 
.const [59] = InterfaceMethod [153] [154] 
.const [60] = Class [155] 
.const [61] = InterfaceMethod [156] [157] 
.const [62] = Class [158] 
.const [63] = InterfaceMethod [159] [160] 
.const [64] = Class [161] 
.const [65] = Class [162] 
.const [66] = NameAndType [163] [164] 
.const [67] = Utf8 java/lang/ClassNotFoundException 
.const [68] = Utf8 java/lang/NoClassDefFoundError 
.const [69] = Utf8 de/audi/app/phone/core/PhoneServiceProvider 
.const [70] = Class [165] 
.const [71] = NameAndType [166] [167] 
.const [72] = Utf8 'de.audi.atip.msg.MsgListener' 
.const [73] = Class [168] 
.const [74] = NameAndType [169] [170] 
.const [75] = Utf8 java/util/Hashtable 
.const [76] = Utf8 java/util/HashMap 
.const [77] = Utf8 '[MessageDispatcher#init] called' 
.const [78] = Utf8 '[MessageDispatcher#deinit] called' 
.const [79] = Utf8 "[MessageDispatcher#addMessageListener] msgID='%1', listener='%2'" 
.const [80] = Class [171] 
.const [81] = NameAndType [172] [173] 
.const [82] = Utf8 java/lang/Integer 
.const [83] = Utf8 java/util/LinkedList 
.const [84] = Utf8 '[MessageDispatcher#addMessageListener] Listener is already added.' 
.const [85] = Utf8 "[MessageDispatcher#removeMessageListener] msgID='%1', listener='%2'" 
.const [86] = Utf8 de/audi/app/phone/core/msg/MessageDispatcher$1 
.const [87] = Utf8 de/audi/app/phone/core/msg/MessageDispatcher 
.const [88] = Utf8 java/lang/Object 
.const [89] = Utf8 java/lang/Class 
.const [90] = Utf8 de/audi/atip/log/LogChannel 
.const [91] = Utf8 java/util/Map 
.const [92] = Utf8 de/audi/app/phone/core/event/TelEventQueue 
.const [93] = Class [174] 
.const [94] = NameAndType [175] [176] 
.const [95] = Class [177] 
.const [96] = NameAndType [178] [179] 
.const [97] = Class [180] 
.const [98] = NameAndType [181] [182] 
.const [99] = Class [183] 
.const [100] = NameAndType [184] [185] 
.const [101] = Class [186] 
.const [102] = NameAndType [187] [188] 
.const [103] = Class [189] 
.const [104] = NameAndType [190] [191] 
.const [105] = Class [192] 
.const [106] = NameAndType [193] [194] 
.const [107] = Class [195] 
.const [108] = NameAndType [196] [197] 
.const [109] = Class [198] 
.const [110] = NameAndType [199] [200] 
.const [111] = Class [201] 
.const [112] = NameAndType [202] [203] 
.const [113] = Class [204] 
.const [114] = NameAndType [205] [206] 
.const [115] = Class [207] 
.const [116] = NameAndType [208] [209] 
.const [117] = Class [210] 
.const [118] = NameAndType [211] [212] 
.const [119] = Class [213] 
.const [120] = NameAndType [214] [215] 
.const [121] = Class [216] 
.const [122] = NameAndType [217] [218] 
.const [123] = Class [219] 
.const [124] = NameAndType [220] [221] 
.const [125] = Class [222] 
.const [126] = NameAndType [223] [224] 
.const [127] = Class [225] 
.const [128] = NameAndType [226] [227] 
.const [129] = Class [228] 
.const [130] = NameAndType [229] [230] 
.const [131] = Class [231] 
.const [132] = NameAndType [232] [233] 
.const [133] = Class [234] 
.const [134] = NameAndType [235] [236] 
.const [135] = Class [237] 
.const [136] = NameAndType [238] [239] 
.const [137] = Class [240] 
.const [138] = NameAndType [241] [242] 
.const [139] = Class [243] 
.const [140] = NameAndType [244] [245] 
.const [141] = Class [246] 
.const [142] = NameAndType [247] [248] 
.const [143] = Class [249] 
.const [144] = NameAndType [250] [251] 
.const [145] = Utf8 java/lang/NoClassDefFoundError 
.const [146] = Utf8 de/audi/app/phone/core/PhoneServiceProvider 
.const [147] = Utf8 java/util/Hashtable 
.const [148] = Class [252] 
.const [149] = NameAndType [253] [254] 
.const [150] = Utf8 java/util/HashMap 
.const [151] = Class [255] 
.const [152] = NameAndType [256] [257] 
.const [153] = Class [258] 
.const [154] = NameAndType [259] [260] 
.const [155] = Utf8 java/lang/Integer 
.const [156] = Class [261] 
.const [157] = NameAndType [262] [263] 
.const [158] = Utf8 java/util/LinkedList 
.const [159] = Class [264] 
.const [160] = NameAndType [265] [266] 
.const [161] = Utf8 de/audi/app/phone/core/msg/MessageDispatcher$1 
.const [162] = Utf8 java/lang/Class 
.const [163] = Utf8 forName 
.const [164] = Utf8 (Ljava/lang/String;)Ljava/lang/Class; 
.const [165] = Utf8 de/audi/app/phone/core/msg/MessageDispatcher 
.const [166] = Utf8 class$de$audi$atip$msg$MsgListener 
.const [167] = Utf8 Ljava/lang/Class; 
.const [168] = Utf8 de/audi/app/phone/core/msg/MessageDispatcher 
.const [169] = Utf8 class$ 
.const [170] = Utf8 (Ljava/lang/String;)Ljava/lang/Class; 
.const [171] = Utf8 java/lang/Integer 
.const [172] = Utf8 toString 
.const [173] = Utf8 (I)Ljava/lang/String; 
.const [174] = Utf8 de/audi/app/phone/core/msg/MessageDispatcher 
.const [175] = Utf8 logChannel 
.const [176] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [177] = Utf8 de/audi/app/phone/core/msg/MessageDispatcher 
.const [178] = Utf8 listeners 
.const [179] = Utf8 Ljava/util/Map; 
.const [180] = Utf8 java/lang/NoClassDefFoundError 
.const [181] = Utf8 initCause 
.const [182] = Utf8 (Ljava/lang/Throwable;)Ljava/lang/Throwable; 
.const [183] = Utf8 java/lang/Class 
.const [184] = Utf8 getName 
.const [185] = Utf8 ()Ljava/lang/String; 
.const [186] = Utf8 de/audi/app/phone/core/msg/MessageDispatcher 
.const [187] = Utf8 msgListenerProvider 
.const [188] = Utf8 Lde/audi/app/phone/core/PhoneServiceProvider; 
.const [189] = Utf8 de/audi/app/phone/core/msg/MessageDispatcher 
.const [190] = Utf8 telEventQueue 
.const [191] = Utf8 Lde/audi/app/phone/core/event/TelEventQueue; 
.const [192] = Utf8 de/audi/atip/log/LogChannel 
.const [193] = Utf8 log 
.const [194] = Utf8 (ILjava/lang/String;)Z 
.const [195] = Utf8 de/audi/app/phone/core/PhoneServiceProvider 
.const [196] = Utf8 startService 
.const [197] = Utf8 ()V 
.const [198] = Utf8 de/audi/app/phone/core/PhoneServiceProvider 
.const [199] = Utf8 stopService 
.const [200] = Utf8 ()V 
.const [201] = Utf8 java/lang/Object 
.const [202] = Utf8 toString 
.const [203] = Utf8 ()Ljava/lang/String; 
.const [204] = Utf8 de/audi/atip/log/LogChannel 
.const [205] = Utf8 log 
.const [206] = Utf8 (ILjava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V 
.const [207] = Utf8 java/util/LinkedList 
.const [208] = Utf8 contains 
.const [209] = Utf8 (Ljava/lang/Object;)Z 
.const [210] = Utf8 java/util/LinkedList 
.const [211] = Utf8 add 
.const [212] = Utf8 (Ljava/lang/Object;)Z 
.const [213] = Utf8 java/util/LinkedList 
.const [214] = Utf8 remove 
.const [215] = Utf8 (Ljava/lang/Object;)Z 
.const [216] = Utf8 de/audi/app/phone/core/event/TelEventQueue 
.const [217] = Utf8 enqueue 
.const [218] = Utf8 (Lde/audi/app/phone/core/event/AbstractTelEvent;)V 
.const [219] = Utf8 java/lang/NoClassDefFoundError 
.const [220] = Utf8 <init> 
.const [221] = Utf8 ()V 
.const [222] = Utf8 java/lang/Object 
.const [223] = Utf8 <init> 
.const [224] = Utf8 ()V 
.const [225] = Utf8 de/audi/app/phone/core/msg/MessageDispatcher 
.const [226] = Utf8 class$de$audi$atip$msg$MsgListener 
.const [227] = Utf8 Ljava/lang/Class; 
.const [228] = Utf8 java/util/Hashtable 
.const [229] = Utf8 <init> 
.const [230] = Utf8 (I)V 
.const [231] = Utf8 de/audi/app/phone/core/PhoneServiceProvider 
.const [232] = Utf8 <init> 
.const [233] = Utf8 (Ljava/lang/String;Ljava/lang/Object;Ljava/util/Hashtable;Lorg/osgi/framework/BundleContext;Lde/audi/atip/log/LogChannel;)V 
.const [234] = Utf8 java/util/HashMap 
.const [235] = Utf8 <init> 
.const [236] = Utf8 ()V 
.const [237] = Utf8 java/lang/Integer 
.const [238] = Utf8 <init> 
.const [239] = Utf8 (I)V 
.const [240] = Utf8 java/util/LinkedList 
.const [241] = Utf8 <init> 
.const [242] = Utf8 ()V 
.const [243] = Utf8 de/audi/app/phone/core/msg/MessageDispatcher$1 
.const [244] = Utf8 <init> 
.const [245] = Utf8 (Lde/audi/app/phone/core/msg/MessageDispatcher;II)V 
.const [246] = Utf8 de/audi/app/phone/core/msg/MessageDispatcher 
.const [247] = Utf8 logChannel 
.const [248] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [249] = Utf8 de/audi/app/phone/core/msg/MessageDispatcher 
.const [250] = Utf8 listeners 
.const [251] = Utf8 Ljava/util/Map; 
.const [252] = Utf8 de/audi/app/phone/core/msg/MessageDispatcher 
.const [253] = Utf8 msgListenerProvider 
.const [254] = Utf8 Lde/audi/app/phone/core/PhoneServiceProvider; 
.const [255] = Utf8 de/audi/app/phone/core/msg/MessageDispatcher 
.const [256] = Utf8 telEventQueue 
.const [257] = Utf8 Lde/audi/app/phone/core/event/TelEventQueue; 
.const [258] = Utf8 java/util/Map 
.const [259] = Utf8 clear 
.const [260] = Utf8 ()V 
.const [261] = Utf8 java/util/Map 
.const [262] = Utf8 get 
.const [263] = Utf8 (Ljava/lang/Object;)Ljava/lang/Object; 
.const [264] = Utf8 java/util/Map 
.const [265] = Utf8 put 
.const [266] = Utf8 (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object; 
.const [267] = Utf8 de/audi/app/phone/core/msg/MessageDispatcher 
.const [268] = Class [267] 
.const [269] = Utf8 java/lang/Object 
.const [270] = Class [269] 
.const [271] = Utf8 de/audi/app/phone/core/msg/IMessageDispatcher 
.const [272] = Class [271] 
.const [273] = Utf8 de/audi/atip/msg/MsgListener 
.const [274] = Class [273] 
.const [275] = Utf8 logChannel 
.const [276] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [277] = Utf8 listeners 
.const [278] = Utf8 Ljava/util/Map; 
.const [279] = Utf8 msgListenerProvider 
.const [280] = Utf8 Lde/audi/app/phone/core/PhoneServiceProvider; 
.const [281] = Utf8 telEventQueue 
.const [282] = Utf8 Lde/audi/app/phone/core/event/TelEventQueue; 
.const [283] = Utf8 class$de$audi$atip$msg$MsgListener 
.const [284] = Utf8 Ljava/lang/Class; 
.const [285] = Utf8 Code 
.const [286] = Utf8 <init> 
.const [287] = Utf8 (Lde/audi/atip/log/LogChannel;Lorg/osgi/framework/BundleContext;Lde/audi/app/phone/core/event/TelEventQueue;)V 
.const [288] = Utf8 init 
.const [289] = Utf8 ()V 
.const [290] = Utf8 deinit 
.const [291] = Utf8 ()V 
.const [292] = Utf8 addMessageListener 
.const [293] = Utf8 (ILde/audi/atip/msg/MsgListener;)V 
.const [294] = Utf8 removeMessageListener 
.const [295] = Utf8 (ILde/audi/atip/msg/MsgListener;)V 
.const [296] = Utf8 processMsg 
.const [297] = Utf8 (I)V 
.const [298] = Utf8 class$ 
.const [299] = Utf8 (Ljava/lang/String;)Ljava/lang/Class; 
.const [300] = Utf8 access$000 
.const [301] = Utf8 (Lde/audi/app/phone/core/msg/MessageDispatcher;)Ljava/util/Map; 
.const [302] = Utf8 access$100 
.const [303] = Utf8 (Lde/audi/app/phone/core/msg/MessageDispatcher;)Lde/audi/atip/log/LogChannel; 
.end class 
