.version 50 0 
.class public final super [259] 
.super [261] 
.implements [263] 
.field public static final [264] [265] 
.field private static [266] [267] 
.field private static [268] [269] 
.field private static [270] [271] 
.field private static [272] [273] 
.field private [274] [275] 
.field private [276] [277] 
.field private static [278] [279] 
.field static synthetic [280] [281] 
.field static synthetic [282] [283] 

.method public [285] : [286] 
    .attribute [284] .code stack 3 locals 2 
L0:     aload_0 
L1:     invokespecial [40] 
L4:     aload_0 
L5:     lconst_0 
L6:     putfield [52] 
L9:     getstatic [5] 
L12:    ifnonnull L60 
L15:    getstatic [6] 
L18:    ifnonnull L33 
L21:    ldc [7] 
L23:    invokestatic [8] 
L26:    dup 
L27:    putstatic [42] 
L30:    goto L36 
L33:    getstatic [6] 
L36:    dup 
L37:    astore_1 
L38:    monitorenter 
        .catch [0] from L39 to L52 using L55 
L39:    new [53] 
L42:    dup 
L43:    iconst_1 
L44:    invokespecial [43] 
L47:    putstatic [41] 
L50:    aload_1 
L51:    monitorexit 
L52:    goto L60 
        .catch [0] from L55 to L58 using L55 
L55:    astore_2 
L56:    aload_1 
L57:    monitorexit 
L58:    aload_2 
L59:    athrow 
L60:    return 
L61:    nop 
L62:    nop 
L63:    nop 
L64:    
    .end code 
.end method 

.method private [287] : [288] 
    .attribute [284] .code stack 3 locals 0 
L0:     aload_0 
L1:     invokespecial [40] 
L4:     aload_0 
L5:     lconst_0 
L6:     putfield [52] 
L9:     aload_0 
L10:    iconst_1 
L11:    invokevirtual [32] 
L14:    aload_0 
L15:    bipush 10 
L17:    invokevirtual [33] 
L20:    invokestatic [10] 
L23:    putstatic [44] 
L26:    aload_0 
L27:    iconst_0 
L28:    putfield [54] 
L31:    aload_0 
L32:    invokevirtual [35] 
L35:    return 
L36:    
    .end code 
.end method 

.method public static [289] : [290] 
    .attribute [284] .code stack 2 locals 0 
L0:     getstatic [12] 
L3:     freturn 
L4:     
    .end code 
.end method 

.method public static [291] : [292] 
    .attribute [284] .code stack 2 locals 0 
L0:     lload_0 
L1:     putstatic [45] 
L4:     return 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [293] : [294] 
    .attribute [284] .code stack 4 locals 2 
L0:     getstatic [13] 
L3:     lconst_1 
L4:     lsub 
L5:     dup2 
L6:     putstatic [46] 
L9:     lconst_0 
L10:    lcmp 
L11:    iflt L69 
L14:    getstatic [14] 
L17:    i2l 
L18:    invokestatic [15] 
L21:    getstatic [6] 
L24:    ifnonnull L39 
L27:    ldc [7] 
L29:    invokestatic [8] 
L32:    dup 
L33:    putstatic [42] 
L36:    goto L42 
L39:    getstatic [6] 
L42:    dup 
L43:    astore_1 
L44:    monitorenter 
        .catch [0] from L45 to L58 using L61 
L45:    getstatic [11] 
L48:    getstatic [14] 
L51:    i2l 
L52:    ladd 
L53:    putstatic [44] 
L56:    aload_1 
L57:    monitorexit 
L58:    goto L66 
        .catch [0] from L61 to L64 using L61 
        .catch [16] from L0 to L69 using L72 
L61:    astore_2 
L62:    aload_1 
L63:    monitorexit 
L64:    aload_2 
L65:    athrow 
L66:    goto L0 
L69:    goto L81 
L72:    astore_1 
L73:    getstatic [17] 
L76:    ldc [18] 
L78:    invokevirtual [36] 
L81:    return 
L82:    nop 
L83:    nop 
L84:    
    .end code 
.end method 

.method private synchronized [295] : [296] 
    .attribute [284] .code stack 6 locals 4 
L0:     lconst_0 
L1:     lstore_1 
L2:     getstatic [6] 
L5:     ifnonnull L20 
L8:     ldc [7] 
L10:    invokestatic [8] 
L13:    dup 
L14:    putstatic [42] 
L17:    goto L23 
L20:    getstatic [6] 
L23:    dup 
L24:    astore_3 
L25:    monitorenter 
        .catch [0] from L26 to L32 using L35 
L26:    getstatic [11] 
L29:    lstore_1 
L30:    aload_3 
L31:    monitorexit 
L32:    goto L42 
        .catch [0] from L35 to L39 using L35 
L35:    astore 4 
L37:    aload_3 
L38:    monitorexit 
L39:    aload 4 
L41:    athrow 
L42:    lload_1 
L43:    aload_0 
L44:    getfield [31] 
L47:    lcmp 
L48:    ifeq L61 
L51:    aload_0 
L52:    iconst_0 
L53:    putfield [54] 
L56:    aload_0 
L57:    lload_1 
L58:    putfield [52] 
L61:    aload_0 
L62:    getfield [34] 
L65:    iconst_1 
L66:    iadd 
L67:    i2l 
L68:    ldc_w [1] 
L71:    getstatic [14] 
L74:    i2l 
L75:    lmul 
L76:    lcmp 
L77:    iflt L88 
L80:    new [55] 
L83:    dup 
L84:    invokespecial [48] 
L87:    athrow 
L88:    lload_1 
L89:    ldc2_w [57] 
L92:    ladd 
L93:    ldc_w [1] 
L96:    lmul 
L97:    aload_0 
L98:    dup 
L99:    getfield [34] 
L102:   dup_x1 
L103:   iconst_1 
L104:   iadd 
L105:   putfield [54] 
L108:   i2l 
L109:   ladd 
L110:   return 
L111:   nop 
L112:   
    .end code 
.end method 

.method public [297] : [298] 
    .attribute [284] .code stack 2 locals 2 
L0:     getstatic [5] 
L3:     invokevirtual [37] 
L6:     ifne L60 
L9:     getstatic [20] 
L12:    ifnonnull L27 
L15:    ldc [21] 
L17:    invokestatic [8] 
L20:    dup 
L21:    putstatic [49] 
L24:    goto L30 
L27:    getstatic [20] 
L30:    dup 
L31:    astore_1 
L32:    monitorenter 
        .catch [0] from L33 to L47 using L50 
L33:    invokestatic [10] 
L36:    putstatic [44] 
L39:    getstatic [5] 
L42:    invokevirtual [35] 
L45:    aload_1 
L46:    monitorexit 
L47:    goto L55 
        .catch [0] from L50 to L53 using L50 
L50:    astore_2 
L51:    aload_1 
L52:    monitorexit 
L53:    aload_2 
L54:    athrow 
L55:    aload_0 
L56:    iconst_0 
L57:    putfield [54] 
L60:    aload_0 
L61:    invokespecial [50] 
L64:    freturn 
L65:    nop 
L66:    nop 
L67:    nop 
L68:    
    .end code 
.end method 

.method static synthetic [299] : [300] 
    .attribute [284] .code stack 3 locals 1 
        .catch [3] from L0 to L4 using L5 
L0:     aload_0 
L1:     invokestatic [2] 
L4:     areturn 
L5:     astore_1 
L6:     new [51] 
L9:     dup 
L10:    aload_1 
L11:    invokevirtual [30] 
L14:    invokespecial [39] 
L17:    athrow 
L18:    nop 
L19:    nop 
L20:    
    .end code 
.end method 

.method static [301] : [302] 
    .attribute [284] .code stack 2 locals 0 
L0:     ldc_w [1] 
L3:     putstatic [45] 
L6:     aconst_null 
L7:     putstatic [41] 
L10:    getstatic [12] 
L13:    putstatic [46] 
L16:    iconst_1 
L17:    putstatic [47] 
L20:    ldc [22] 
L22:    invokestatic [23] 
L25:    ldc [24] 
L27:    invokevirtual [38] 
L30:    iconst_m1 
L31:    if_icmpeq L39 
L34:    bipush 10 
L36:    putstatic [47] 
L39:    return 
L40:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Method [60] [61] 
.const [3] = Class [62] 
.const [4] = Class [63] 
.const [5] = Field [64] [65] 
.const [6] = Field [66] [67] 
.const [7] = String [68] 
.const [8] = Method [69] [70] 
.const [9] = Class [71] 
.const [10] = Method [72] [73] 
.const [11] = Field [74] [75] 
.const [12] = Field [76] [77] 
.const [13] = Field [78] [79] 
.const [14] = Field [80] [81] 
.const [15] = Method [82] [83] 
.const [16] = Class [84] 
.const [17] = Field [85] [86] 
.const [18] = String [87] 
.const [19] = Class [88] 
.const [20] = Field [89] [90] 
.const [21] = String [91] 
.const [22] = String [92] 
.const [23] = Method [93] [94] 
.const [24] = String [95] 
.const [25] = Class [96] 
.const [26] = Class [97] 
.const [27] = Class [98] 
.const [28] = Class [99] 
.const [29] = Class [100] 
.const [30] = Method [101] [102] 
.const [31] = Field [103] [104] 
.const [32] = Method [105] [106] 
.const [33] = Method [107] [108] 
.const [34] = Field [109] [110] 
.const [35] = Method [111] [112] 
.const [36] = Method [113] [114] 
.const [37] = Method [115] [116] 
.const [38] = Method [117] [118] 
.const [39] = Method [119] [120] 
.const [40] = Method [121] [122] 
.const [41] = Field [123] [124] 
.const [42] = Field [125] [126] 
.const [43] = Method [127] [128] 
.const [44] = Field [129] [130] 
.const [45] = Field [131] [132] 
.const [46] = Field [133] [134] 
.const [47] = Field [135] [136] 
.const [48] = Method [137] [138] 
.const [49] = Field [139] [140] 
.const [50] = Method [141] [142] 
.const [51] = Class [143] 
.const [52] = Field [144] [145] 
.const [53] = Class [146] 
.const [54] = Field [147] [148] 
.const [55] = Class [149] 
.const [56] = Int 270991360 
.const [57] = Long 12219292800000L 
.const [59] = Int -939524096 
.const [60] = Class [150] 
.const [61] = NameAndType [151] [152] 
.const [62] = Utf8 java/lang/ClassNotFoundException 
.const [63] = Utf8 java/lang/NoClassDefFoundError 
.const [64] = Class [153] 
.const [65] = NameAndType [154] [155] 
.const [66] = Class [156] 
.const [67] = NameAndType [157] [158] 
.const [68] = Utf8 'org.apache.commons.id.uuid.clock.ThreadClockImpl' 
.const [69] = Class [159] 
.const [70] = NameAndType [160] [161] 
.const [71] = Utf8 org/apache/commons/id/uuid/clock/ThreadClockImpl 
.const [72] = Class [162] 
.const [73] = NameAndType [163] [164] 
.const [74] = Class [165] 
.const [75] = NameAndType [166] [167] 
.const [76] = Class [168] 
.const [77] = NameAndType [169] [170] 
.const [78] = Class [171] 
.const [79] = NameAndType [172] [173] 
.const [80] = Class [174] 
.const [81] = NameAndType [175] [176] 
.const [82] = Class [177] 
.const [83] = NameAndType [178] [179] 
.const [84] = Utf8 java/lang/InterruptedException 
.const [85] = Class [180] 
.const [86] = NameAndType [181] [182] 
.const [87] = Utf8 'Clock thread interrupted' 
.const [88] = Utf8 org/apache/commons/id/uuid/clock/OverClockedException 
.const [89] = Class [183] 
.const [90] = NameAndType [184] [185] 
.const [91] = Utf8 'org.apache.commons.id.uuid.clock.SystemClockImpl' 
.const [92] = Utf8 'os.name' 
.const [93] = Class [186] 
.const [94] = NameAndType [187] [188] 
.const [95] = Utf8 Windows 
.const [96] = Utf8 java/lang/Thread 
.const [97] = Utf8 java/lang/Class 
.const [98] = Utf8 java/lang/System 
.const [99] = Utf8 java/io/PrintStream 
.const [100] = Utf8 java/lang/String 
.const [101] = Class [189] 
.const [102] = NameAndType [190] [191] 
.const [103] = Class [192] 
.const [104] = NameAndType [193] [194] 
.const [105] = Class [195] 
.const [106] = NameAndType [196] [197] 
.const [107] = Class [198] 
.const [108] = NameAndType [199] [200] 
.const [109] = Class [201] 
.const [110] = NameAndType [202] [203] 
.const [111] = Class [204] 
.const [112] = NameAndType [205] [206] 
.const [113] = Class [207] 
.const [114] = NameAndType [208] [209] 
.const [115] = Class [210] 
.const [116] = NameAndType [211] [212] 
.const [117] = Class [213] 
.const [118] = NameAndType [214] [215] 
.const [119] = Class [216] 
.const [120] = NameAndType [217] [218] 
.const [121] = Class [219] 
.const [122] = NameAndType [220] [221] 
.const [123] = Class [222] 
.const [124] = NameAndType [223] [224] 
.const [125] = Class [225] 
.const [126] = NameAndType [226] [227] 
.const [127] = Class [228] 
.const [128] = NameAndType [229] [230] 
.const [129] = Class [231] 
.const [130] = NameAndType [232] [233] 
.const [131] = Class [234] 
.const [132] = NameAndType [235] [236] 
.const [133] = Class [237] 
.const [134] = NameAndType [238] [239] 
.const [135] = Class [240] 
.const [136] = NameAndType [241] [242] 
.const [137] = Class [243] 
.const [138] = NameAndType [244] [245] 
.const [139] = Class [246] 
.const [140] = NameAndType [247] [248] 
.const [141] = Class [249] 
.const [142] = NameAndType [250] [251] 
.const [143] = Utf8 java/lang/NoClassDefFoundError 
.const [144] = Class [252] 
.const [145] = NameAndType [253] [254] 
.const [146] = Utf8 org/apache/commons/id/uuid/clock/ThreadClockImpl 
.const [147] = Class [255] 
.const [148] = NameAndType [256] [257] 
.const [149] = Utf8 org/apache/commons/id/uuid/clock/OverClockedException 
.const [150] = Utf8 java/lang/Class 
.const [151] = Utf8 forName 
.const [152] = Utf8 (Ljava/lang/String;)Ljava/lang/Class; 
.const [153] = Utf8 org/apache/commons/id/uuid/clock/ThreadClockImpl 
.const [154] = Utf8 worker 
.const [155] = Utf8 Lorg/apache/commons/id/uuid/clock/ThreadClockImpl; 
.const [156] = Utf8 org/apache/commons/id/uuid/clock/ThreadClockImpl 
.const [157] = Utf8 class$org$apache$commons$id$uuid$clock$ThreadClockImpl 
.const [158] = Utf8 Ljava/lang/Class; 
.const [159] = Utf8 org/apache/commons/id/uuid/clock/ThreadClockImpl 
.const [160] = Utf8 class$ 
.const [161] = Utf8 (Ljava/lang/String;)Ljava/lang/Class; 
.const [162] = Utf8 java/lang/System 
.const [163] = Utf8 currentTimeMillis 
.const [164] = Utf8 ()J 
.const [165] = Utf8 org/apache/commons/id/uuid/clock/ThreadClockImpl 
.const [166] = Utf8 currentTimeMillis 
.const [167] = Utf8 J 
.const [168] = Utf8 org/apache/commons/id/uuid/clock/ThreadClockImpl 
.const [169] = Utf8 threadLife 
.const [170] = Utf8 J 
.const [171] = Utf8 org/apache/commons/id/uuid/clock/ThreadClockImpl 
.const [172] = Utf8 expires 
.const [173] = Utf8 J 
.const [174] = Utf8 org/apache/commons/id/uuid/clock/ThreadClockImpl 
.const [175] = Utf8 sysInterval 
.const [176] = Utf8 S 
.const [177] = Utf8 org/apache/commons/id/uuid/clock/ThreadClockImpl 
.const [178] = Utf8 sleep 
.const [179] = Utf8 (J)V 
.const [180] = Utf8 java/lang/System 
.const [181] = Utf8 out 
.const [182] = Utf8 Ljava/io/PrintStream; 
.const [183] = Utf8 org/apache/commons/id/uuid/clock/ThreadClockImpl 
.const [184] = Utf8 class$org$apache$commons$id$uuid$clock$SystemClockImpl 
.const [185] = Utf8 Ljava/lang/Class; 
.const [186] = Utf8 java/lang/System 
.const [187] = Utf8 getProperty 
.const [188] = Utf8 (Ljava/lang/String;)Ljava/lang/String; 
.const [189] = Utf8 java/lang/ClassNotFoundException 
.const [190] = Utf8 getMessage 
.const [191] = Utf8 ()Ljava/lang/String; 
.const [192] = Utf8 org/apache/commons/id/uuid/clock/ThreadClockImpl 
.const [193] = Utf8 lastTimeMs 
.const [194] = Utf8 J 
.const [195] = Utf8 org/apache/commons/id/uuid/clock/ThreadClockImpl 
.const [196] = Utf8 setDaemon 
.const [197] = Utf8 (Z)V 
.const [198] = Utf8 org/apache/commons/id/uuid/clock/ThreadClockImpl 
.const [199] = Utf8 setPriority 
.const [200] = Utf8 (I)V 
.const [201] = Utf8 org/apache/commons/id/uuid/clock/ThreadClockImpl 
.const [202] = Utf8 generatedThisInterval 
.const [203] = Utf8 I 
.const [204] = Utf8 org/apache/commons/id/uuid/clock/ThreadClockImpl 
.const [205] = Utf8 start 
.const [206] = Utf8 ()V 
.const [207] = Utf8 java/io/PrintStream 
.const [208] = Utf8 println 
.const [209] = Utf8 (Ljava/lang/String;)V 
.const [210] = Utf8 org/apache/commons/id/uuid/clock/ThreadClockImpl 
.const [211] = Utf8 isAlive 
.const [212] = Utf8 ()Z 
.const [213] = Utf8 java/lang/String 
.const [214] = Utf8 indexOf 
.const [215] = Utf8 (Ljava/lang/String;)I 
.const [216] = Utf8 java/lang/NoClassDefFoundError 
.const [217] = Utf8 <init> 
.const [218] = Utf8 (Ljava/lang/String;)V 
.const [219] = Utf8 java/lang/Thread 
.const [220] = Utf8 <init> 
.const [221] = Utf8 ()V 
.const [222] = Utf8 org/apache/commons/id/uuid/clock/ThreadClockImpl 
.const [223] = Utf8 worker 
.const [224] = Utf8 Lorg/apache/commons/id/uuid/clock/ThreadClockImpl; 
.const [225] = Utf8 org/apache/commons/id/uuid/clock/ThreadClockImpl 
.const [226] = Utf8 class$org$apache$commons$id$uuid$clock$ThreadClockImpl 
.const [227] = Utf8 Ljava/lang/Class; 
.const [228] = Utf8 org/apache/commons/id/uuid/clock/ThreadClockImpl 
.const [229] = Utf8 <init> 
.const [230] = Utf8 (Z)V 
.const [231] = Utf8 org/apache/commons/id/uuid/clock/ThreadClockImpl 
.const [232] = Utf8 currentTimeMillis 
.const [233] = Utf8 J 
.const [234] = Utf8 org/apache/commons/id/uuid/clock/ThreadClockImpl 
.const [235] = Utf8 threadLife 
.const [236] = Utf8 J 
.const [237] = Utf8 org/apache/commons/id/uuid/clock/ThreadClockImpl 
.const [238] = Utf8 expires 
.const [239] = Utf8 J 
.const [240] = Utf8 org/apache/commons/id/uuid/clock/ThreadClockImpl 
.const [241] = Utf8 sysInterval 
.const [242] = Utf8 S 
.const [243] = Utf8 org/apache/commons/id/uuid/clock/OverClockedException 
.const [244] = Utf8 <init> 
.const [245] = Utf8 ()V 
.const [246] = Utf8 org/apache/commons/id/uuid/clock/ThreadClockImpl 
.const [247] = Utf8 class$org$apache$commons$id$uuid$clock$SystemClockImpl 
.const [248] = Utf8 Ljava/lang/Class; 
.const [249] = Utf8 org/apache/commons/id/uuid/clock/ThreadClockImpl 
.const [250] = Utf8 getTimeSynchronized 
.const [251] = Utf8 ()J 
.const [252] = Utf8 org/apache/commons/id/uuid/clock/ThreadClockImpl 
.const [253] = Utf8 lastTimeMs 
.const [254] = Utf8 J 
.const [255] = Utf8 org/apache/commons/id/uuid/clock/ThreadClockImpl 
.const [256] = Utf8 generatedThisInterval 
.const [257] = Utf8 I 
.const [258] = Utf8 org/apache/commons/id/uuid/clock/ThreadClockImpl 
.const [259] = Class [258] 
.const [260] = Utf8 java/lang/Thread 
.const [261] = Class [260] 
.const [262] = Utf8 org/apache/commons/id/uuid/clock/Clock 
.const [263] = Class [262] 
.const [264] = Utf8 DEFAULT_THREAD_LIFE 
.const [265] = Utf8 J 
.const [266] = Utf8 threadLife 
.const [267] = Utf8 J 
.const [268] = Utf8 worker 
.const [269] = Utf8 Lorg/apache/commons/id/uuid/clock/ThreadClockImpl; 
.const [270] = Utf8 currentTimeMillis 
.const [271] = Utf8 J 
.const [272] = Utf8 expires 
.const [273] = Utf8 J 
.const [274] = Utf8 lastTimeMs 
.const [275] = Utf8 J 
.const [276] = Utf8 generatedThisInterval 
.const [277] = Utf8 I 
.const [278] = Utf8 sysInterval 
.const [279] = Utf8 S 
.const [280] = Utf8 class$org$apache$commons$id$uuid$clock$ThreadClockImpl 
.const [281] = Utf8 Ljava/lang/Class; 
.const [282] = Utf8 class$org$apache$commons$id$uuid$clock$SystemClockImpl 
.const [283] = Utf8 Ljava/lang/Class; 
.const [284] = Utf8 Code 
.const [285] = Utf8 <init> 
.const [286] = Utf8 ()V 
.const [287] = Utf8 <init> 
.const [288] = Utf8 (Z)V 
.const [289] = Utf8 getThreadLife 
.const [290] = Utf8 ()J 
.const [291] = Utf8 setThreadLife 
.const [292] = Utf8 (J)V 
.const [293] = Utf8 run 
.const [294] = Utf8 ()V 
.const [295] = Utf8 getTimeSynchronized 
.const [296] = Utf8 ()J 
.const [297] = Utf8 getUUIDTime 
.const [298] = Utf8 ()J 
.const [299] = Utf8 class$ 
.const [300] = Utf8 (Ljava/lang/String;)Ljava/lang/Class; 
.const [301] = Utf8 <clinit> 
.const [302] = Utf8 ()V 
.end class 
