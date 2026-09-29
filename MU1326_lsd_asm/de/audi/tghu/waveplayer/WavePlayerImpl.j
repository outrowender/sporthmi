.version 50 0 
.class public super [293] 
.super [295] 
.implements [297] 
.field private final [298] [299] 
.field private [300] [301] 
.field private [302] [303] 
.field private [304] [305] 
.field private [306] [307] 
.field private [308] [309] 
.field static synthetic [310] [311] 

.method [313] : [314] 
    .attribute [312] .code stack 7 locals 0 
L0:     aload_0 
L1:     invokespecial [49] 
L4:     aload_0 
L5:     new [57] 
L8:     dup 
L9:     invokespecial [49] 
L12:    putfield [58] 
L15:    aload_0 
L16:    iconst_0 
L17:    putfield [59] 
L20:    aload_0 
L21:    aload_1 
L22:    putfield [60] 
L25:    aload_0 
L26:    iconst_m1 
L27:    putfield [61] 
L30:    aload_0 
L31:    new [62] 
L34:    dup 
L35:    aload_0 
L36:    aload_1 
L37:    aload_1 
L38:    ldc [7] 
L40:    invokeinterface [63] 0 
L45:    invokespecial [50] 
L48:    putfield [64] 
L51:    aload_0 
L52:    new [62] 
L55:    dup 
L56:    aload_0 
L57:    aload_1 
L58:    aload_1 
L59:    ldc [8] 
L61:    invokeinterface [63] 0 
L66:    invokespecial [50] 
L69:    putfield [65] 
L72:    return 
L73:    nop 
L74:    nop 
L75:    nop 
L76:    
    .end code 
.end method 

.method [315] : [316] 
    .attribute [312] .code stack 4 locals 2 
L0:     aload_0 
L1:     getfield [33] 
L4:     ifne L37 
L7:     aload_0 
L8:     getfield [36] 
L11:    getfield [38] 
L14:    ldc [9] 
L16:    ldc [10] 
L18:    invokevirtual [39] 
L21:    pop 
L22:    aload_0 
L23:    getfield [37] 
L26:    getfield [38] 
L29:    ldc [9] 
L31:    ldc [10] 
L33:    invokevirtual [39] 
L36:    pop 
L37:    aload_0 
L38:    getfield [32] 
L41:    dup 
L42:    astore_1 
L43:    monitorenter 
        .catch [0] from L44 to L99 using L102 
L44:    aload_0 
L45:    getfield [33] 
L48:    ifne L97 
L51:    aload_0 
L52:    getfield [34] 
L55:    invokeinterface [66] 0 
L60:    getstatic [11] 
L63:    ifnonnull L78 
L66:    ldc [12] 
L68:    invokestatic [13] 
L71:    dup 
L72:    putstatic [51] 
L75:    goto L81 
L78:    getstatic [11] 
L81:    invokevirtual [40] 
L84:    aload_0 
L85:    aconst_null 
L86:    invokeinterface [67] 0 
L91:    pop 
L92:    aload_0 
L93:    iconst_1 
L94:    putfield [59] 
L97:    aload_1 
L98:    monitorexit 
L99:    goto L107 
        .catch [0] from L102 to L105 using L102 
L102:   astore_2 
L103:   aload_1 
L104:   monitorexit 
L105:   aload_2 
L106:   athrow 
L107:   return 
L108:   
    .end code 
.end method 

.method public [317] : [318] 
    .attribute [312] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [36] 
L4:     invokevirtual [41] 
L7:     areturn 
L8:     
    .end code 
.end method 

.method public [319] : [320] 
    .attribute [312] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [37] 
L4:     invokevirtual [41] 
L7:     areturn 
L8:     
    .end code 
.end method 

.method public [321] : [322] 
    .attribute [312] .code stack 5 locals 1 
L0:     aload_0 
L1:     getfield [36] 
L4:     getfield [38] 
L7:     ldc [14] 
L9:     ldc [15] 
L11:    aload_1 
L12:    invokevirtual [42] 
L15:    pop 
L16:    aload_0 
L17:    getfield [36] 
L20:    aload_1 
L21:    invokevirtual [43] 
        .catch [16] from L24 to L48 using L51 
L24:    aload_1 
L25:    iconst_2 
L26:    newarray int 
L28:    dup 
L29:    iconst_0 
L30:    iconst_2 
L31:    iastore 
L32:    dup 
L33:    iconst_1 
L34:    iconst_1 
L35:    iastore 
L36:    aload_0 
L37:    getfield [36] 
L40:    invokevirtual [41] 
L43:    invokeinterface [68] 0 
L48:    goto L70 
L51:    astore_2 
L52:    aload_0 
L53:    getfield [36] 
L56:    getfield [38] 
L59:    sipush 10000 
L62:    ldc [17] 
L64:    aload_1 
L65:    aload_2 
L66:    invokevirtual [44] 
L69:    pop 
L70:    return 
L71:    nop 
L72:    
    .end code 
.end method 

.method public [323] : [324] 
    .attribute [312] .code stack 5 locals 1 
L0:     aload_0 
L1:     getfield [37] 
L4:     getfield [38] 
L7:     ldc [14] 
L9:     ldc [18] 
L11:    aload_1 
L12:    invokevirtual [42] 
L15:    pop 
L16:    aload_0 
L17:    getfield [37] 
L20:    aload_1 
L21:    invokevirtual [43] 
        .catch [16] from L24 to L48 using L51 
L24:    aload_1 
L25:    iconst_2 
L26:    newarray int 
L28:    dup 
L29:    iconst_0 
L30:    iconst_2 
L31:    iastore 
L32:    dup 
L33:    iconst_1 
L34:    iconst_1 
L35:    iastore 
L36:    aload_0 
L37:    getfield [37] 
L40:    invokevirtual [41] 
L43:    invokeinterface [68] 0 
L48:    goto L70 
L51:    astore_2 
L52:    aload_0 
L53:    getfield [36] 
L56:    getfield [38] 
L59:    sipush 10000 
L62:    ldc [19] 
L64:    aload_1 
L65:    aload_2 
L66:    invokevirtual [44] 
L69:    pop 
L70:    return 
L71:    nop 
L72:    
    .end code 
.end method 

.method public [325] : [326] 
    .attribute [312] .code stack 4 locals 0 
L0:     new [69] 
L3:     dup 
L4:     aload_0 
L5:     getfield [36] 
L8:     aload_0 
L9:     invokespecial [52] 
L12:    invokespecial [53] 
L15:    areturn 
L16:    
    .end code 
.end method 

.method public [327] : [328] 
    .attribute [312] .code stack 4 locals 0 
L0:     new [69] 
L3:     dup 
L4:     aload_0 
L5:     getfield [37] 
L8:     aload_0 
L9:     invokespecial [52] 
L12:    invokespecial [53] 
L15:    areturn 
L16:    
    .end code 
.end method 

.method public [329] : [330] 
    .attribute [312] .code stack 4 locals 2 
L0:     aload_0 
L1:     dup 
L2:     astore_2 
L3:     monitorenter 
        .catch [0] from L4 to L46 using L49 
L4:     iload_1 
L5:     aload_0 
L6:     getfield [35] 
L9:     if_icmpgt L44 
L12:    new [70] 
L15:    dup 
L16:    new [71] 
L19:    dup 
L20:    invokespecial [54] 
L23:    ldc [23] 
L25:    invokevirtual [45] 
L28:    iload_1 
L29:    invokevirtual [46] 
L32:    ldc [24] 
L34:    invokevirtual [45] 
L37:    invokevirtual [47] 
L40:    invokespecial [55] 
L43:    athrow 
L44:    aload_2 
L45:    monitorexit 
L46:    goto L54 
        .catch [0] from L49 to L52 using L49 
L49:    astore_3 
L50:    aload_2 
L51:    monitorexit 
L52:    aload_3 
L53:    athrow 
L54:    new [69] 
L57:    dup 
L58:    aload_0 
L59:    getfield [36] 
L62:    iload_1 
L63:    invokespecial [53] 
L66:    areturn 
L67:    nop 
L68:    
    .end code 
.end method 

.method private synchronized [331] : [332] 
    .attribute [312] .code stack 3 locals 0 
L0:     aload_0 
L1:     dup 
L2:     getfield [35] 
L5:     iconst_1 
L6:     iadd 
L7:     putfield [61] 
L10:    aload_0 
L11:    getfield [35] 
L14:    areturn 
L15:    nop 
L16:    
    .end code 
.end method 

.method static synthetic [333] : [334] 
    .attribute [312] .code stack 2 locals 1 
        .catch [3] from L0 to L4 using L5 
L0:     aload_0 
L1:     invokestatic [2] 
L4:     areturn 
L5:     astore_1 
L6:     new [56] 
L9:     dup 
L10:    invokespecial [48] 
L13:    aload_1 
L14:    invokevirtual [31] 
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
.const [6] = Class [77] 
.const [7] = String [78] 
.const [8] = String [79] 
.const [9] = Int 1078071040 
.const [10] = String [80] 
.const [11] = Field [81] [82] 
.const [12] = String [83] 
.const [13] = Method [84] [85] 
.const [14] = Int -2137614336 
.const [15] = String [86] 
.const [16] = Class [87] 
.const [17] = String [88] 
.const [18] = String [89] 
.const [19] = String [90] 
.const [20] = Class [91] 
.const [21] = Class [92] 
.const [22] = Class [93] 
.const [23] = String [94] 
.const [24] = String [95] 
.const [25] = Class [96] 
.const [26] = Class [97] 
.const [27] = Class [98] 
.const [28] = Class [99] 
.const [29] = Class [100] 
.const [30] = Class [101] 
.const [31] = Method [102] [103] 
.const [32] = Field [104] [105] 
.const [33] = Field [106] [107] 
.const [34] = Field [108] [109] 
.const [35] = Field [110] [111] 
.const [36] = Field [112] [113] 
.const [37] = Field [114] [115] 
.const [38] = Field [116] [117] 
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
.const [50] = Method [140] [141] 
.const [51] = Field [142] [143] 
.const [52] = Method [144] [145] 
.const [53] = Method [146] [147] 
.const [54] = Method [148] [149] 
.const [55] = Method [150] [151] 
.const [56] = Class [152] 
.const [57] = Class [153] 
.const [58] = Field [154] [155] 
.const [59] = Field [156] [157] 
.const [60] = Field [158] [159] 
.const [61] = Field [160] [161] 
.const [62] = Class [162] 
.const [63] = InterfaceMethod [163] [164] 
.const [64] = Field [165] [166] 
.const [65] = Field [167] [168] 
.const [66] = InterfaceMethod [169] [170] 
.const [67] = InterfaceMethod [171] [172] 
.const [68] = InterfaceMethod [173] [174] 
.const [69] = Class [175] 
.const [70] = Class [176] 
.const [71] = Class [177] 
.const [72] = Class [178] 
.const [73] = NameAndType [179] [180] 
.const [74] = Utf8 java/lang/ClassNotFoundException 
.const [75] = Utf8 java/lang/NoClassDefFoundError 
.const [76] = Utf8 java/lang/Object 
.const [77] = Utf8 de/audi/tghu/waveplayer/WavePlayerMaster 
.const [78] = Utf8 'Fw.Waveplayer.Ringtone' 
.const [79] = Utf8 'Fw.Waveplayer.Systemtone' 
.const [80] = Utf8 'WavePlayerImpl.registerWaveplayerService()' 
.const [81] = Class [181] 
.const [82] = NameAndType [182] [183] 
.const [83] = Utf8 'de.audi.tghu.waveplayer.WavePlayer' 
.const [84] = Class [184] 
.const [85] = NameAndType [185] [186] 
.const [86] = Utf8 'WavePlayerImpl.registerRingTonePlayer( %1 ) ' 
.const [87] = Utf8 java/lang/Exception 
.const [88] = Utf8 'WavePlayerImpl.registerRingTonePlayer( %1 ): Setting notifications failed! ' 
.const [89] = Utf8 'WavePlayerImpl.registerSystemTonePlayer( %1 ) ' 
.const [90] = Utf8 'WavePlayerImpl.registerSystemTonePlayer( %1 ): Setting notifications failed! ' 
.const [91] = Utf8 de/audi/tghu/waveplayer/WavePlayerClient 
.const [92] = Utf8 java/lang/IllegalArgumentException 
.const [93] = Utf8 java/lang/StringBuffer 
.const [94] = Utf8 'SessionID ' 
.const [95] = Utf8 ' already in use!' 
.const [96] = Utf8 de/audi/tghu/waveplayer/WavePlayerImpl 
.const [97] = Utf8 java/lang/Class 
.const [98] = Utf8 de/audi/atip/base/IFrameworkAccess 
.const [99] = Utf8 de/audi/atip/log/LogChannel 
.const [100] = Utf8 org/osgi/framework/BundleContext 
.const [101] = Utf8 org/dsi/ifc/waveplayer/DSIWavePlayer 
.const [102] = Class [187] 
.const [103] = NameAndType [188] [189] 
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
.const [153] = Utf8 java/lang/Object 
.const [154] = Class [262] 
.const [155] = NameAndType [263] [264] 
.const [156] = Class [265] 
.const [157] = NameAndType [266] [267] 
.const [158] = Class [268] 
.const [159] = NameAndType [269] [270] 
.const [160] = Class [271] 
.const [161] = NameAndType [272] [273] 
.const [162] = Utf8 de/audi/tghu/waveplayer/WavePlayerMaster 
.const [163] = Class [274] 
.const [164] = NameAndType [275] [276] 
.const [165] = Class [277] 
.const [166] = NameAndType [278] [279] 
.const [167] = Class [280] 
.const [168] = NameAndType [281] [282] 
.const [169] = Class [283] 
.const [170] = NameAndType [284] [285] 
.const [171] = Class [286] 
.const [172] = NameAndType [287] [288] 
.const [173] = Class [289] 
.const [174] = NameAndType [290] [291] 
.const [175] = Utf8 de/audi/tghu/waveplayer/WavePlayerClient 
.const [176] = Utf8 java/lang/IllegalArgumentException 
.const [177] = Utf8 java/lang/StringBuffer 
.const [178] = Utf8 java/lang/Class 
.const [179] = Utf8 forName 
.const [180] = Utf8 (Ljava/lang/String;)Ljava/lang/Class; 
.const [181] = Utf8 de/audi/tghu/waveplayer/WavePlayerImpl 
.const [182] = Utf8 class$de$audi$tghu$waveplayer$WavePlayer 
.const [183] = Utf8 Ljava/lang/Class; 
.const [184] = Utf8 de/audi/tghu/waveplayer/WavePlayerImpl 
.const [185] = Utf8 class$ 
.const [186] = Utf8 (Ljava/lang/String;)Ljava/lang/Class; 
.const [187] = Utf8 java/lang/NoClassDefFoundError 
.const [188] = Utf8 initCause 
.const [189] = Utf8 (Ljava/lang/Throwable;)Ljava/lang/Throwable; 
.const [190] = Utf8 de/audi/tghu/waveplayer/WavePlayerImpl 
.const [191] = Utf8 mutex 
.const [192] = Utf8 Ljava/lang/Object; 
.const [193] = Utf8 de/audi/tghu/waveplayer/WavePlayerImpl 
.const [194] = Utf8 waveplayerServiceRegistered 
.const [195] = Utf8 Z 
.const [196] = Utf8 de/audi/tghu/waveplayer/WavePlayerImpl 
.const [197] = Utf8 fw 
.const [198] = Utf8 Lde/audi/atip/base/IFrameworkAccess; 
.const [199] = Utf8 de/audi/tghu/waveplayer/WavePlayerImpl 
.const [200] = Utf8 lastSessionID 
.const [201] = Utf8 I 
.const [202] = Utf8 de/audi/tghu/waveplayer/WavePlayerImpl 
.const [203] = Utf8 ringToneMaster 
.const [204] = Utf8 Lde/audi/tghu/waveplayer/WavePlayerMaster; 
.const [205] = Utf8 de/audi/tghu/waveplayer/WavePlayerImpl 
.const [206] = Utf8 systemToneMaster 
.const [207] = Utf8 Lde/audi/tghu/waveplayer/WavePlayerMaster; 
.const [208] = Utf8 de/audi/tghu/waveplayer/WavePlayerMaster 
.const [209] = Utf8 lc 
.const [210] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [211] = Utf8 de/audi/atip/log/LogChannel 
.const [212] = Utf8 log 
.const [213] = Utf8 (ILjava/lang/String;)Z 
.const [214] = Utf8 java/lang/Class 
.const [215] = Utf8 getName 
.const [216] = Utf8 ()Ljava/lang/String; 
.const [217] = Utf8 de/audi/tghu/waveplayer/WavePlayerMaster 
.const [218] = Utf8 getDSIListener 
.const [219] = Utf8 ()Lorg/dsi/ifc/waveplayer/DSIWavePlayerListener; 
.const [220] = Utf8 de/audi/atip/log/LogChannel 
.const [221] = Utf8 log 
.const [222] = Utf8 (ILjava/lang/String;Ljava/lang/Object;)Z 
.const [223] = Utf8 de/audi/tghu/waveplayer/WavePlayerMaster 
.const [224] = Utf8 registerDSI 
.const [225] = Utf8 (Lorg/dsi/ifc/waveplayer/DSIWavePlayer;)V 
.const [226] = Utf8 de/audi/atip/log/LogChannel 
.const [227] = Utf8 log 
.const [228] = Utf8 (ILjava/lang/String;Ljava/lang/Object;Ljava/lang/Throwable;)Z 
.const [229] = Utf8 java/lang/StringBuffer 
.const [230] = Utf8 append 
.const [231] = Utf8 (Ljava/lang/String;)Ljava/lang/StringBuffer; 
.const [232] = Utf8 java/lang/StringBuffer 
.const [233] = Utf8 append 
.const [234] = Utf8 (I)Ljava/lang/StringBuffer; 
.const [235] = Utf8 java/lang/StringBuffer 
.const [236] = Utf8 toString 
.const [237] = Utf8 ()Ljava/lang/String; 
.const [238] = Utf8 java/lang/NoClassDefFoundError 
.const [239] = Utf8 <init> 
.const [240] = Utf8 ()V 
.const [241] = Utf8 java/lang/Object 
.const [242] = Utf8 <init> 
.const [243] = Utf8 ()V 
.const [244] = Utf8 de/audi/tghu/waveplayer/WavePlayerMaster 
.const [245] = Utf8 <init> 
.const [246] = Utf8 (Lde/audi/tghu/waveplayer/WavePlayerImpl;Lde/audi/atip/base/IFrameworkAccess;Lde/audi/atip/log/LogChannel;)V 
.const [247] = Utf8 de/audi/tghu/waveplayer/WavePlayerImpl 
.const [248] = Utf8 class$de$audi$tghu$waveplayer$WavePlayer 
.const [249] = Utf8 Ljava/lang/Class; 
.const [250] = Utf8 de/audi/tghu/waveplayer/WavePlayerImpl 
.const [251] = Utf8 nextSessionID 
.const [252] = Utf8 ()I 
.const [253] = Utf8 de/audi/tghu/waveplayer/WavePlayerClient 
.const [254] = Utf8 <init> 
.const [255] = Utf8 (Lde/audi/tghu/waveplayer/WavePlayerMaster;I)V 
.const [256] = Utf8 java/lang/StringBuffer 
.const [257] = Utf8 <init> 
.const [258] = Utf8 ()V 
.const [259] = Utf8 java/lang/IllegalArgumentException 
.const [260] = Utf8 <init> 
.const [261] = Utf8 (Ljava/lang/String;)V 
.const [262] = Utf8 de/audi/tghu/waveplayer/WavePlayerImpl 
.const [263] = Utf8 mutex 
.const [264] = Utf8 Ljava/lang/Object; 
.const [265] = Utf8 de/audi/tghu/waveplayer/WavePlayerImpl 
.const [266] = Utf8 waveplayerServiceRegistered 
.const [267] = Utf8 Z 
.const [268] = Utf8 de/audi/tghu/waveplayer/WavePlayerImpl 
.const [269] = Utf8 fw 
.const [270] = Utf8 Lde/audi/atip/base/IFrameworkAccess; 
.const [271] = Utf8 de/audi/tghu/waveplayer/WavePlayerImpl 
.const [272] = Utf8 lastSessionID 
.const [273] = Utf8 I 
.const [274] = Utf8 de/audi/atip/base/IFrameworkAccess 
.const [275] = Utf8 getLogChannel 
.const [276] = Utf8 (Ljava/lang/String;)Lde/audi/atip/log/LogChannel; 
.const [277] = Utf8 de/audi/tghu/waveplayer/WavePlayerImpl 
.const [278] = Utf8 ringToneMaster 
.const [279] = Utf8 Lde/audi/tghu/waveplayer/WavePlayerMaster; 
.const [280] = Utf8 de/audi/tghu/waveplayer/WavePlayerImpl 
.const [281] = Utf8 systemToneMaster 
.const [282] = Utf8 Lde/audi/tghu/waveplayer/WavePlayerMaster; 
.const [283] = Utf8 de/audi/atip/base/IFrameworkAccess 
.const [284] = Utf8 getBundleCxt 
.const [285] = Utf8 ()Lorg/osgi/framework/BundleContext; 
.const [286] = Utf8 org/osgi/framework/BundleContext 
.const [287] = Utf8 registerService 
.const [288] = Utf8 (Ljava/lang/String;Ljava/lang/Object;Ljava/util/Dictionary;)Lorg/osgi/framework/ServiceRegistration; 
.const [289] = Utf8 org/dsi/ifc/waveplayer/DSIWavePlayer 
.const [290] = Utf8 setNotification 
.const [291] = Utf8 ([ILorg/dsi/ifc/base/DSIListener;)V 
.const [292] = Utf8 de/audi/tghu/waveplayer/WavePlayerImpl 
.const [293] = Class [292] 
.const [294] = Utf8 java/lang/Object 
.const [295] = Class [294] 
.const [296] = Utf8 de/audi/tghu/waveplayer/WavePlayer 
.const [297] = Class [296] 
.const [298] = Utf8 mutex 
.const [299] = Utf8 Ljava/lang/Object; 
.const [300] = Utf8 ringToneMaster 
.const [301] = Utf8 Lde/audi/tghu/waveplayer/WavePlayerMaster; 
.const [302] = Utf8 systemToneMaster 
.const [303] = Utf8 Lde/audi/tghu/waveplayer/WavePlayerMaster; 
.const [304] = Utf8 lastSessionID 
.const [305] = Utf8 I 
.const [306] = Utf8 waveplayerServiceRegistered 
.const [307] = Utf8 Z 
.const [308] = Utf8 fw 
.const [309] = Utf8 Lde/audi/atip/base/IFrameworkAccess; 
.const [310] = Utf8 class$de$audi$tghu$waveplayer$WavePlayer 
.const [311] = Utf8 Ljava/lang/Class; 
.const [312] = Utf8 Code 
.const [313] = Utf8 <init> 
.const [314] = Utf8 (Lde/audi/atip/base/IFrameworkAccess;)V 
.const [315] = Utf8 registerWaveplayerService 
.const [316] = Utf8 ()V 
.const [317] = Utf8 getRingToneListener 
.const [318] = Utf8 ()Lorg/dsi/ifc/waveplayer/DSIWavePlayerListener; 
.const [319] = Utf8 getSystemToneListener 
.const [320] = Utf8 ()Lorg/dsi/ifc/waveplayer/DSIWavePlayerListener; 
.const [321] = Utf8 registerRingTonePlayer 
.const [322] = Utf8 (Lorg/dsi/ifc/waveplayer/DSIWavePlayer;)V 
.const [323] = Utf8 registerSystemTonePlayer 
.const [324] = Utf8 (Lorg/dsi/ifc/waveplayer/DSIWavePlayer;)V 
.const [325] = Utf8 getRingTonePlayer 
.const [326] = Utf8 ()Lde/audi/tghu/waveplayer/RingTonePlayer; 
.const [327] = Utf8 getSystemTonePlayer 
.const [328] = Utf8 ()Lde/audi/tghu/waveplayer/SystemTonePlayer; 
.const [329] = Utf8 getRingTonePlayer 
.const [330] = Utf8 (I)Lde/audi/tghu/waveplayer/RingTonePlayer; 
.const [331] = Utf8 nextSessionID 
.const [332] = Utf8 ()I 
.const [333] = Utf8 class$ 
.const [334] = Utf8 (Ljava/lang/String;)Ljava/lang/Class; 
.end class 
