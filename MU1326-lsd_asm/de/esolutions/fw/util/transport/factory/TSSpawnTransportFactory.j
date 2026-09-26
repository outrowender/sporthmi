.version 50 0 
.class public super [255] 
.super [257] 
.implements [259] 
.implements [261] 
.field protected [262] [263] 
.field protected [264] [265] 
.field protected [266] [267] 
.field protected [268] [269] 
.field protected [270] [271] 
.field protected [272] [273] 
.field protected [274] [275] 
.field protected [276] [277] 

.method public [279] : [280] 
    .attribute [278] .code stack 3 locals 0 
L0:     aload_0 
L1:     invokespecial [36] 
L4:     aload_0 
L5:     aconst_null 
L6:     putfield [43] 
L9:     aload_0 
L10:    aload_1 
L11:    putfield [44] 
L14:    aload_0 
L15:    aload_2 
L16:    putfield [45] 
L19:    aload_0 
L20:    new [46] 
L23:    dup 
L24:    invokespecial [37] 
L27:    aload_1 
L28:    invokevirtual [23] 
L31:    ldc [3] 
L33:    invokevirtual [23] 
L36:    aload_2 
L37:    invokevirtual [23] 
L40:    invokevirtual [24] 
L43:    putfield [47] 
L46:    return 
L47:    nop 
L48:    
    .end code 
.end method 

.method public [281] : [282] 
    .attribute [278] .code stack 5 locals 1 
L0:     aload_0 
L1:     getfield [26] 
L4:     ifeq L8 
L7:     return 
L8:     new [49] 
L11:    dup 
L12:    aload_0 
L13:    getfield [22] 
L16:    invokespecial [38] 
L19:    astore_1 
L20:    aload_1 
L21:    invokevirtual [27] 
L24:    ifne L35 
L27:    new [50] 
L30:    dup 
L31:    invokespecial [39] 
L34:    athrow 
L35:    aload_0 
L36:    new [51] 
L39:    dup 
L40:    aload_0 
L41:    ldc [7] 
L43:    invokespecial [40] 
L46:    putfield [52] 
L49:    aload_0 
L50:    getfield [28] 
L53:    invokevirtual [29] 
L56:    aload_0 
L57:    iconst_1 
L58:    putfield [48] 
L61:    return 
L62:    nop 
L63:    nop 
L64:    
    .end code 
.end method 

.method public [283] : [284] 
    .attribute [278] .code stack 2 locals 1 
L0:     aload_0 
L1:     getfield [26] 
L4:     ifne L8 
L7:     return 
L8:     aload_0 
L9:     getfield [21] 
L12:    ifnonnull L16 
L15:    return 
L16:    aload_0 
L17:    iconst_1 
L18:    putfield [53] 
        .catch [8] from L21 to L50 using L53 
        .catch [5] from L21 to L50 using L57 
L21:    aload_0 
L22:    getfield [21] 
L25:    iconst_0 
L26:    invokeinterface [54] 0 
L31:    aload_0 
L32:    getfield [28] 
L35:    invokevirtual [31] 
L38:    aload_0 
L39:    getfield [28] 
L42:    invokevirtual [32] 
L45:    aload_0 
L46:    iconst_0 
L47:    putfield [48] 
L50:    goto L58 
L53:    astore_1 
L54:    goto L58 
L57:    astore_1 
L58:    return 
L59:    nop 
L60:    
    .end code 
.end method 

.method public [285] : [286] 
    .attribute [278] .code stack 2 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     putfield [55] 
L5:     return 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [287] : [288] 
    .attribute [278] .code stack 4 locals 1 
L0:     aload_0 
L1:     getfield [30] 
L4:     ifne L90 
        .catch [5] from L7 to L83 using L86 
L7:     new [56] 
L10:    dup 
L11:    aload_0 
L12:    getfield [25] 
L15:    invokespecial [41] 
L18:    astore_1 
L19:    aload_0 
L20:    new [57] 
L23:    dup 
L24:    aload_1 
L25:    invokespecial [42] 
L28:    putfield [43] 
L31:    aload_0 
L32:    aload_0 
L33:    aload_0 
L34:    getfield [21] 
L37:    invokevirtual [34] 
L40:    putfield [43] 
L43:    aload_0 
L44:    getfield [21] 
L47:    invokeinterface [58] 0 
L52:    aload_0 
L53:    getfield [33] 
L56:    ifnull L75 
L59:    aload_0 
L60:    getfield [33] 
L63:    aload_0 
L64:    getfield [21] 
L67:    invokeinterface [59] 0 
L72:    goto L83 
L75:    getstatic [11] 
L78:    ldc [12] 
L80:    invokevirtual [35] 
L83:    goto L0 
L86:    astore_1 
L87:    goto L0 
L90:    return 
L91:    nop 
L92:    
    .end code 
.end method 

.method public [289] : [290] 
    .attribute [278] .code stack 2 locals 0 
L0:     new [46] 
L3:     dup 
L4:     invokespecial [37] 
L7:     ldc [13] 
L9:     invokevirtual [23] 
L12:    aload_0 
L13:    getfield [25] 
L16:    invokevirtual [23] 
L19:    ldc [14] 
L21:    invokevirtual [23] 
L24:    invokevirtual [24] 
L27:    areturn 
L28:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [60] 
.const [3] = String [61] 
.const [4] = Class [62] 
.const [5] = Class [63] 
.const [6] = Class [64] 
.const [7] = String [65] 
.const [8] = Class [66] 
.const [9] = Class [67] 
.const [10] = Class [68] 
.const [11] = Field [69] [70] 
.const [12] = String [71] 
.const [13] = String [72] 
.const [14] = String [73] 
.const [15] = Class [74] 
.const [16] = Class [75] 
.const [17] = Class [76] 
.const [18] = Class [77] 
.const [19] = Class [78] 
.const [20] = Class [79] 
.const [21] = Field [80] [81] 
.const [22] = Field [82] [83] 
.const [23] = Method [84] [85] 
.const [24] = Method [86] [87] 
.const [25] = Field [88] [89] 
.const [26] = Field [90] [91] 
.const [27] = Method [92] [93] 
.const [28] = Field [94] [95] 
.const [29] = Method [96] [97] 
.const [30] = Field [98] [99] 
.const [31] = Method [100] [101] 
.const [32] = Method [102] [103] 
.const [33] = Field [104] [105] 
.const [34] = Method [106] [107] 
.const [35] = Method [108] [109] 
.const [36] = Method [110] [111] 
.const [37] = Method [112] [113] 
.const [38] = Method [114] [115] 
.const [39] = Method [116] [117] 
.const [40] = Method [118] [119] 
.const [41] = Method [120] [121] 
.const [42] = Method [122] [123] 
.const [43] = Field [124] [125] 
.const [44] = Field [126] [127] 
.const [45] = Field [128] [129] 
.const [46] = Class [130] 
.const [47] = Field [131] [132] 
.const [48] = Field [133] [134] 
.const [49] = Class [135] 
.const [50] = Class [136] 
.const [51] = Class [137] 
.const [52] = Field [138] [139] 
.const [53] = Field [140] [141] 
.const [54] = InterfaceMethod [142] [143] 
.const [55] = Field [144] [145] 
.const [56] = Class [146] 
.const [57] = Class [147] 
.const [58] = InterfaceMethod [148] [149] 
.const [59] = InterfaceMethod [150] [151] 
.const [60] = Utf8 java/lang/StringBuffer 
.const [61] = Utf8 '/spawn/' 
.const [62] = Utf8 java/io/File 
.const [63] = Utf8 java/io/IOException 
.const [64] = Utf8 java/lang/Thread 
.const [65] = Utf8 TSSpawnTransportFactory 
.const [66] = Utf8 java/lang/InterruptedException 
.const [67] = Utf8 de/esolutions/fw/util/transport/socket/TSTransport 
.const [68] = Utf8 de/esolutions/fw/util/transport/packet/PacketTransport 
.const [69] = Class [152] 
.const [70] = NameAndType [153] [154] 
.const [71] = Utf8 'TSSpawnTransportFactory: spawned transport but no listener!' 
.const [72] = Utf8 '[TSP:listen=' 
.const [73] = Utf8 ']' 
.const [74] = Utf8 de/esolutions/fw/util/transport/factory/TSSpawnTransportFactory 
.const [75] = Utf8 de/esolutions/fw/util/transport/factory/BaseTransportFactory 
.const [76] = Utf8 de/esolutions/fw/util/transport/ITransport 
.const [77] = Utf8 de/esolutions/fw/util/transport/factory/ISpawnedTransportListener 
.const [78] = Utf8 java/lang/System 
.const [79] = Utf8 java/io/PrintStream 
.const [80] = Class [155] 
.const [81] = NameAndType [156] [157] 
.const [82] = Class [158] 
.const [83] = NameAndType [159] [160] 
.const [84] = Class [161] 
.const [85] = NameAndType [162] [163] 
.const [86] = Class [164] 
.const [87] = NameAndType [165] [166] 
.const [88] = Class [167] 
.const [89] = NameAndType [168] [169] 
.const [90] = Class [170] 
.const [91] = NameAndType [171] [172] 
.const [92] = Class [173] 
.const [93] = NameAndType [174] [175] 
.const [94] = Class [176] 
.const [95] = NameAndType [177] [178] 
.const [96] = Class [179] 
.const [97] = NameAndType [180] [181] 
.const [98] = Class [182] 
.const [99] = NameAndType [183] [184] 
.const [100] = Class [185] 
.const [101] = NameAndType [186] [187] 
.const [102] = Class [188] 
.const [103] = NameAndType [189] [190] 
.const [104] = Class [191] 
.const [105] = NameAndType [192] [193] 
.const [106] = Class [194] 
.const [107] = NameAndType [195] [196] 
.const [108] = Class [197] 
.const [109] = NameAndType [198] [199] 
.const [110] = Class [200] 
.const [111] = NameAndType [201] [202] 
.const [112] = Class [203] 
.const [113] = NameAndType [204] [205] 
.const [114] = Class [206] 
.const [115] = NameAndType [207] [208] 
.const [116] = Class [209] 
.const [117] = NameAndType [210] [211] 
.const [118] = Class [212] 
.const [119] = NameAndType [213] [214] 
.const [120] = Class [215] 
.const [121] = NameAndType [216] [217] 
.const [122] = Class [218] 
.const [123] = NameAndType [219] [220] 
.const [124] = Class [221] 
.const [125] = NameAndType [222] [223] 
.const [126] = Class [224] 
.const [127] = NameAndType [225] [226] 
.const [128] = Class [227] 
.const [129] = NameAndType [228] [229] 
.const [130] = Utf8 java/lang/StringBuffer 
.const [131] = Class [230] 
.const [132] = NameAndType [231] [232] 
.const [133] = Class [233] 
.const [134] = NameAndType [234] [235] 
.const [135] = Utf8 java/io/File 
.const [136] = Utf8 java/io/IOException 
.const [137] = Utf8 java/lang/Thread 
.const [138] = Class [236] 
.const [139] = NameAndType [237] [238] 
.const [140] = Class [239] 
.const [141] = NameAndType [240] [241] 
.const [142] = Class [242] 
.const [143] = NameAndType [243] [244] 
.const [144] = Class [245] 
.const [145] = NameAndType [246] [247] 
.const [146] = Utf8 de/esolutions/fw/util/transport/socket/TSTransport 
.const [147] = Utf8 de/esolutions/fw/util/transport/packet/PacketTransport 
.const [148] = Class [248] 
.const [149] = NameAndType [249] [250] 
.const [150] = Class [251] 
.const [151] = NameAndType [252] [253] 
.const [152] = Utf8 java/lang/System 
.const [153] = Utf8 out 
.const [154] = Utf8 Ljava/io/PrintStream; 
.const [155] = Utf8 de/esolutions/fw/util/transport/factory/TSSpawnTransportFactory 
.const [156] = Utf8 transport 
.const [157] = Utf8 Lde/esolutions/fw/util/transport/ITransport; 
.const [158] = Utf8 de/esolutions/fw/util/transport/factory/TSSpawnTransportFactory 
.const [159] = Utf8 mountPoint 
.const [160] = Utf8 Ljava/lang/String; 
.const [161] = Utf8 java/lang/StringBuffer 
.const [162] = Utf8 append 
.const [163] = Utf8 (Ljava/lang/String;)Ljava/lang/StringBuffer; 
.const [164] = Utf8 java/lang/StringBuffer 
.const [165] = Utf8 toString 
.const [166] = Utf8 ()Ljava/lang/String; 
.const [167] = Utf8 de/esolutions/fw/util/transport/factory/TSSpawnTransportFactory 
.const [168] = Utf8 path 
.const [169] = Utf8 Ljava/lang/String; 
.const [170] = Utf8 de/esolutions/fw/util/transport/factory/TSSpawnTransportFactory 
.const [171] = Utf8 isEnabled 
.const [172] = Utf8 Z 
.const [173] = Utf8 java/io/File 
.const [174] = Utf8 exists 
.const [175] = Utf8 ()Z 
.const [176] = Utf8 de/esolutions/fw/util/transport/factory/TSSpawnTransportFactory 
.const [177] = Utf8 thread 
.const [178] = Utf8 Ljava/lang/Thread; 
.const [179] = Utf8 java/lang/Thread 
.const [180] = Utf8 start 
.const [181] = Utf8 ()V 
.const [182] = Utf8 de/esolutions/fw/util/transport/factory/TSSpawnTransportFactory 
.const [183] = Utf8 stopNow 
.const [184] = Utf8 Z 
.const [185] = Utf8 java/lang/Thread 
.const [186] = Utf8 interrupt 
.const [187] = Utf8 ()V 
.const [188] = Utf8 java/lang/Thread 
.const [189] = Utf8 join 
.const [190] = Utf8 ()V 
.const [191] = Utf8 de/esolutions/fw/util/transport/factory/TSSpawnTransportFactory 
.const [192] = Utf8 listener 
.const [193] = Utf8 Lde/esolutions/fw/util/transport/factory/ISpawnedTransportListener; 
.const [194] = Utf8 de/esolutions/fw/util/transport/factory/TSSpawnTransportFactory 
.const [195] = Utf8 enrichTransport 
.const [196] = Utf8 (Lde/esolutions/fw/util/transport/ITransport;)Lde/esolutions/fw/util/transport/ITransport; 
.const [197] = Utf8 java/io/PrintStream 
.const [198] = Utf8 println 
.const [199] = Utf8 (Ljava/lang/String;)V 
.const [200] = Utf8 de/esolutions/fw/util/transport/factory/BaseTransportFactory 
.const [201] = Utf8 <init> 
.const [202] = Utf8 ()V 
.const [203] = Utf8 java/lang/StringBuffer 
.const [204] = Utf8 <init> 
.const [205] = Utf8 ()V 
.const [206] = Utf8 java/io/File 
.const [207] = Utf8 <init> 
.const [208] = Utf8 (Ljava/lang/String;)V 
.const [209] = Utf8 java/io/IOException 
.const [210] = Utf8 <init> 
.const [211] = Utf8 ()V 
.const [212] = Utf8 java/lang/Thread 
.const [213] = Utf8 <init> 
.const [214] = Utf8 (Ljava/lang/Runnable;Ljava/lang/String;)V 
.const [215] = Utf8 de/esolutions/fw/util/transport/socket/TSTransport 
.const [216] = Utf8 <init> 
.const [217] = Utf8 (Ljava/lang/String;)V 
.const [218] = Utf8 de/esolutions/fw/util/transport/packet/PacketTransport 
.const [219] = Utf8 <init> 
.const [220] = Utf8 (Lde/esolutions/fw/util/transport/socket/IByteTransport;)V 
.const [221] = Utf8 de/esolutions/fw/util/transport/factory/TSSpawnTransportFactory 
.const [222] = Utf8 transport 
.const [223] = Utf8 Lde/esolutions/fw/util/transport/ITransport; 
.const [224] = Utf8 de/esolutions/fw/util/transport/factory/TSSpawnTransportFactory 
.const [225] = Utf8 mountPoint 
.const [226] = Utf8 Ljava/lang/String; 
.const [227] = Utf8 de/esolutions/fw/util/transport/factory/TSSpawnTransportFactory 
.const [228] = Utf8 fileName 
.const [229] = Utf8 Ljava/lang/String; 
.const [230] = Utf8 de/esolutions/fw/util/transport/factory/TSSpawnTransportFactory 
.const [231] = Utf8 path 
.const [232] = Utf8 Ljava/lang/String; 
.const [233] = Utf8 de/esolutions/fw/util/transport/factory/TSSpawnTransportFactory 
.const [234] = Utf8 isEnabled 
.const [235] = Utf8 Z 
.const [236] = Utf8 de/esolutions/fw/util/transport/factory/TSSpawnTransportFactory 
.const [237] = Utf8 thread 
.const [238] = Utf8 Ljava/lang/Thread; 
.const [239] = Utf8 de/esolutions/fw/util/transport/factory/TSSpawnTransportFactory 
.const [240] = Utf8 stopNow 
.const [241] = Utf8 Z 
.const [242] = Utf8 de/esolutions/fw/util/transport/ITransport 
.const [243] = Utf8 close 
.const [244] = Utf8 (Z)V 
.const [245] = Utf8 de/esolutions/fw/util/transport/factory/TSSpawnTransportFactory 
.const [246] = Utf8 listener 
.const [247] = Utf8 Lde/esolutions/fw/util/transport/factory/ISpawnedTransportListener; 
.const [248] = Utf8 de/esolutions/fw/util/transport/ITransport 
.const [249] = Utf8 'open' 
.const [250] = Utf8 ()V 
.const [251] = Utf8 de/esolutions/fw/util/transport/factory/ISpawnedTransportListener 
.const [252] = Utf8 spawnedTransport 
.const [253] = Utf8 (Lde/esolutions/fw/util/transport/ITransport;)V 
.const [254] = Utf8 de/esolutions/fw/util/transport/factory/TSSpawnTransportFactory 
.const [255] = Class [254] 
.const [256] = Utf8 de/esolutions/fw/util/transport/factory/BaseTransportFactory 
.const [257] = Class [256] 
.const [258] = Utf8 de/esolutions/fw/util/transport/factory/ISpawnTransportFactory 
.const [259] = Class [258] 
.const [260] = Utf8 java/lang/Runnable 
.const [261] = Class [260] 
.const [262] = Utf8 listener 
.const [263] = Utf8 Lde/esolutions/fw/util/transport/factory/ISpawnedTransportListener; 
.const [264] = Utf8 transport 
.const [265] = Utf8 Lde/esolutions/fw/util/transport/ITransport; 
.const [266] = Utf8 thread 
.const [267] = Utf8 Ljava/lang/Thread; 
.const [268] = Utf8 stopNow 
.const [269] = Utf8 Z 
.const [270] = Utf8 isEnabled 
.const [271] = Utf8 Z 
.const [272] = Utf8 path 
.const [273] = Utf8 Ljava/lang/String; 
.const [274] = Utf8 mountPoint 
.const [275] = Utf8 Ljava/lang/String; 
.const [276] = Utf8 fileName 
.const [277] = Utf8 Ljava/lang/String; 
.const [278] = Utf8 Code 
.const [279] = Utf8 <init> 
.const [280] = Utf8 (Ljava/lang/String;Ljava/lang/String;)V 
.const [281] = Utf8 enableSpawning 
.const [282] = Utf8 ()V 
.const [283] = Utf8 disableSpawning 
.const [284] = Utf8 ()V 
.const [285] = Utf8 setListener 
.const [286] = Utf8 (Lde/esolutions/fw/util/transport/factory/ISpawnedTransportListener;)V 
.const [287] = Utf8 run 
.const [288] = Utf8 ()V 
.const [289] = Utf8 getDescription 
.const [290] = Utf8 ()Ljava/lang/String; 
.end class 
