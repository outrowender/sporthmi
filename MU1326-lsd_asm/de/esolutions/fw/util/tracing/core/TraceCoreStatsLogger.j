.version 50 0 
.class public super [213] 
.super [215] 
.implements [217] 
.field private final [218] [219] 
.field private final [220] [221] 
.field private final [222] [223] 
.field private final [224] [225] 
.field private final [226] [227] 
.field private final [228] [229] 

.method public [231] : [232] 
    .attribute [230] .code stack 3 locals 1 
L0:     aload_0 
L1:     invokespecial [38] 
L4:     aload_0 
L5:     aload_2 
L6:     putfield [41] 
L9:     aload_0 
L10:    aload_3 
L11:    putfield [42] 
L14:    aload_0 
L15:    aload_1 
L16:    putfield [43] 
L19:    aload_2 
L20:    ldc [2] 
L22:    iconst_0 
L23:    invokevirtual [22] 
L26:    astore 4 
L28:    aload 4 
L30:    ifnull L45 
L33:    aload_0 
L34:    aload 4 
L36:    invokevirtual [23] 
L39:    putfield [44] 
L42:    goto L50 
L45:    aload_0 
L46:    iconst_m1 
L47:    putfield [44] 
L50:    aload_2 
L51:    ldc [3] 
L53:    iconst_0 
L54:    invokevirtual [25] 
L57:    astore 4 
L59:    aload 4 
L61:    ifnull L76 
L64:    aload_0 
L65:    aload 4 
L67:    invokevirtual [23] 
L70:    putfield [45] 
L73:    goto L81 
L76:    aload_0 
L77:    iconst_m1 
L78:    putfield [45] 
L81:    aload_0 
L82:    aload_2 
L83:    ldc [4] 
L85:    invokevirtual [27] 
L88:    putfield [46] 
L91:    aload_2 
L92:    aload_0 
L93:    invokevirtual [29] 
L96:    return 
L97:    nop 
L98:    nop 
L99:    nop 
L100:   
    .end code 
.end method 

.method public [233] : [234] 
    .attribute [230] .code stack 6 locals 1 
L0:     aload_0 
L1:     getfield [24] 
L4:     iconst_m1 
L5:     if_icmpeq L47 
L8:     aload_0 
L9:     getfield [26] 
L12:    iconst_m1 
L13:    if_icmpeq L47 
L16:    aload_0 
L17:    getfield [20] 
L20:    invokevirtual [30] 
L23:    astore_1 
L24:    aload_1 
L25:    ifnull L47 
L28:    aload_0 
L29:    getfield [19] 
L32:    aload_0 
L33:    getfield [24] 
L36:    aload_0 
L37:    getfield [26] 
L40:    iconst_2 
L41:    iconst_0 
L42:    aload_1 
L43:    invokevirtual [31] 
L46:    pop 
L47:    return 
L48:    
    .end code 
.end method 

.method public [235] : [236] 
    .attribute [230] .code stack 7 locals 2 
L0:     iload_1 
L1:     aload_0 
L2:     getfield [28] 
L5:     if_icmpne L133 
        .catch [10] from L8 to L89 using L92 
L8:     new [47] 
L11:    dup 
L12:    aload_2 
L13:    ldc [6] 
L15:    invokespecial [39] 
L18:    astore_3 
L19:    aload_3 
L20:    invokestatic [7] 
L23:    istore 4 
L25:    iload 4 
L27:    iflt L89 
L30:    iload 4 
L32:    aload_0 
L33:    getfield [21] 
L36:    invokevirtual [32] 
L39:    if_icmpeq L89 
L42:    aload_0 
L43:    getfield [19] 
L46:    aload_0 
L47:    getfield [24] 
L50:    aload_0 
L51:    getfield [26] 
L54:    iconst_2 
L55:    iconst_0 
L56:    new [48] 
L59:    dup 
L60:    invokespecial [40] 
L63:    ldc [9] 
L65:    invokevirtual [33] 
L68:    iload 4 
L70:    invokevirtual [34] 
L73:    invokevirtual [35] 
L76:    invokevirtual [31] 
L79:    pop 
L80:    aload_0 
L81:    getfield [21] 
L84:    iload 4 
L86:    invokevirtual [36] 
L89:    goto L133 
L92:    astore_3 
L93:    aload_0 
L94:    getfield [19] 
L97:    aload_0 
L98:    getfield [24] 
L101:   aload_0 
L102:   getfield [26] 
L105:   iconst_4 
L106:   iconst_0 
L107:   new [48] 
L110:   dup 
L111:   invokespecial [40] 
L114:   ldc [11] 
L116:   invokevirtual [33] 
L119:   aload_3 
L120:   invokevirtual [37] 
L123:   invokevirtual [33] 
L126:   invokevirtual [35] 
L129:   invokevirtual [31] 
L132:   pop 
L133:   return 
L134:   nop 
L135:   nop 
L136:   
    .end code 
.end method 

.method public enum [237] : [238] 
    .attribute [230] .code stack 0 locals 0 
L0:     return 
L1:     nop 
L2:     nop 
L3:     nop 
L4:     
    .end code 
.end method 

.method public enum [239] : [240] 
    .attribute [230] .code stack 0 locals 0 
L0:     return 
L1:     nop 
L2:     nop 
L3:     nop 
L4:     
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = String [49] 
.const [3] = String [50] 
.const [4] = String [51] 
.const [5] = Class [52] 
.const [6] = String [53] 
.const [7] = Method [54] [55] 
.const [8] = Class [56] 
.const [9] = String [57] 
.const [10] = Class [58] 
.const [11] = String [59] 
.const [12] = Class [60] 
.const [13] = Class [61] 
.const [14] = Class [62] 
.const [15] = Class [63] 
.const [16] = Class [64] 
.const [17] = Class [65] 
.const [18] = Class [66] 
.const [19] = Field [67] [68] 
.const [20] = Field [69] [70] 
.const [21] = Field [71] [72] 
.const [22] = Method [73] [74] 
.const [23] = Method [75] [76] 
.const [24] = Field [77] [78] 
.const [25] = Method [79] [80] 
.const [26] = Field [81] [82] 
.const [27] = Method [83] [84] 
.const [28] = Field [85] [86] 
.const [29] = Method [87] [88] 
.const [30] = Method [89] [90] 
.const [31] = Method [91] [92] 
.const [32] = Method [93] [94] 
.const [33] = Method [95] [96] 
.const [34] = Method [97] [98] 
.const [35] = Method [99] [100] 
.const [36] = Method [101] [102] 
.const [37] = Method [103] [104] 
.const [38] = Method [105] [106] 
.const [39] = Method [107] [108] 
.const [40] = Method [109] [110] 
.const [41] = Field [111] [112] 
.const [42] = Field [113] [114] 
.const [43] = Field [115] [116] 
.const [44] = Field [117] [118] 
.const [45] = Field [119] [120] 
.const [46] = Field [121] [122] 
.const [47] = Class [123] 
.const [48] = Class [124] 
.const [49] = Utf8 'FW.Tracing.Statistics' 
.const [50] = Utf8 traceCore 
.const [51] = Utf8 setCoreStatisticsInterval 
.const [52] = Utf8 java/lang/String 
.const [53] = Utf8 UTF-8 
.const [54] = Class [125] 
.const [55] = NameAndType [126] [127] 
.const [56] = Utf8 java/lang/StringBuffer 
.const [57] = Utf8 'new coreStatisticsInterval=' 
.const [58] = Utf8 java/lang/Exception 
.const [59] = Utf8 'callback failed: ' 
.const [60] = Utf8 de/esolutions/fw/util/tracing/core/TraceCoreStatsLogger 
.const [61] = Utf8 java/lang/Object 
.const [62] = Utf8 de/esolutions/fw/util/tracing/frontend/TraceFrontend 
.const [63] = Utf8 de/esolutions/fw/util/tracing/entity/TraceEntityURIWithLevel 
.const [64] = Utf8 de/esolutions/fw/util/tracing/core/TraceCoreStats 
.const [65] = Utf8 java/lang/Integer 
.const [66] = Utf8 de/esolutions/fw/util/tracing/config/TraceConfig 
.const [67] = Class [128] 
.const [68] = NameAndType [129] [130] 
.const [69] = Class [131] 
.const [70] = NameAndType [132] [133] 
.const [71] = Class [134] 
.const [72] = NameAndType [135] [136] 
.const [73] = Class [137] 
.const [74] = NameAndType [138] [139] 
.const [75] = Class [140] 
.const [76] = NameAndType [141] [142] 
.const [77] = Class [143] 
.const [78] = NameAndType [144] [145] 
.const [79] = Class [146] 
.const [80] = NameAndType [147] [148] 
.const [81] = Class [149] 
.const [82] = NameAndType [150] [151] 
.const [83] = Class [152] 
.const [84] = NameAndType [153] [154] 
.const [85] = Class [155] 
.const [86] = NameAndType [156] [157] 
.const [87] = Class [158] 
.const [88] = NameAndType [159] [160] 
.const [89] = Class [161] 
.const [90] = NameAndType [162] [163] 
.const [91] = Class [164] 
.const [92] = NameAndType [165] [166] 
.const [93] = Class [167] 
.const [94] = NameAndType [168] [169] 
.const [95] = Class [170] 
.const [96] = NameAndType [171] [172] 
.const [97] = Class [173] 
.const [98] = NameAndType [174] [175] 
.const [99] = Class [176] 
.const [100] = NameAndType [177] [178] 
.const [101] = Class [179] 
.const [102] = NameAndType [180] [181] 
.const [103] = Class [182] 
.const [104] = NameAndType [183] [184] 
.const [105] = Class [185] 
.const [106] = NameAndType [186] [187] 
.const [107] = Class [188] 
.const [108] = NameAndType [189] [190] 
.const [109] = Class [191] 
.const [110] = NameAndType [192] [193] 
.const [111] = Class [194] 
.const [112] = NameAndType [195] [196] 
.const [113] = Class [197] 
.const [114] = NameAndType [198] [199] 
.const [115] = Class [200] 
.const [116] = NameAndType [201] [202] 
.const [117] = Class [203] 
.const [118] = NameAndType [204] [205] 
.const [119] = Class [206] 
.const [120] = NameAndType [207] [208] 
.const [121] = Class [209] 
.const [122] = NameAndType [210] [211] 
.const [123] = Utf8 java/lang/String 
.const [124] = Utf8 java/lang/StringBuffer 
.const [125] = Utf8 java/lang/Integer 
.const [126] = Utf8 parseInt 
.const [127] = Utf8 (Ljava/lang/String;)I 
.const [128] = Utf8 de/esolutions/fw/util/tracing/core/TraceCoreStatsLogger 
.const [129] = Utf8 frontend 
.const [130] = Utf8 Lde/esolutions/fw/util/tracing/frontend/TraceFrontend; 
.const [131] = Utf8 de/esolutions/fw/util/tracing/core/TraceCoreStatsLogger 
.const [132] = Utf8 stats 
.const [133] = Utf8 Lde/esolutions/fw/util/tracing/core/TraceCoreStats; 
.const [134] = Utf8 de/esolutions/fw/util/tracing/core/TraceCoreStatsLogger 
.const [135] = Utf8 config 
.const [136] = Utf8 Lde/esolutions/fw/util/tracing/config/TraceConfig; 
.const [137] = Utf8 de/esolutions/fw/util/tracing/frontend/TraceFrontend 
.const [138] = Utf8 createChannelPath 
.const [139] = Utf8 (Ljava/lang/String;S)Lde/esolutions/fw/util/tracing/entity/TraceEntityURIWithLevel; 
.const [140] = Utf8 de/esolutions/fw/util/tracing/entity/TraceEntityURIWithLevel 
.const [141] = Utf8 getId 
.const [142] = Utf8 ()I 
.const [143] = Utf8 de/esolutions/fw/util/tracing/core/TraceCoreStatsLogger 
.const [144] = Utf8 channel 
.const [145] = Utf8 I 
.const [146] = Utf8 de/esolutions/fw/util/tracing/frontend/TraceFrontend 
.const [147] = Utf8 createThread 
.const [148] = Utf8 (Ljava/lang/String;S)Lde/esolutions/fw/util/tracing/entity/TraceEntityURIWithLevel; 
.const [149] = Utf8 de/esolutions/fw/util/tracing/core/TraceCoreStatsLogger 
.const [150] = Utf8 thread 
.const [151] = Utf8 I 
.const [152] = Utf8 de/esolutions/fw/util/tracing/frontend/TraceFrontend 
.const [153] = Utf8 createCallback 
.const [154] = Utf8 (Ljava/lang/String;)I 
.const [155] = Utf8 de/esolutions/fw/util/tracing/core/TraceCoreStatsLogger 
.const [156] = Utf8 callback 
.const [157] = Utf8 I 
.const [158] = Utf8 de/esolutions/fw/util/tracing/frontend/TraceFrontend 
.const [159] = Utf8 registerListener 
.const [160] = Utf8 (Lde/esolutions/fw/util/tracing/frontend/ITraceFrontendListener;)V 
.const [161] = Utf8 de/esolutions/fw/util/tracing/core/TraceCoreStats 
.const [162] = Utf8 readValues 
.const [163] = Utf8 ()Ljava/lang/String; 
.const [164] = Utf8 de/esolutions/fw/util/tracing/frontend/TraceFrontend 
.const [165] = Utf8 log 
.const [166] = Utf8 (IISSLjava/lang/String;)Z 
.const [167] = Utf8 de/esolutions/fw/util/tracing/config/TraceConfig 
.const [168] = Utf8 getCoreStatisticsInterval 
.const [169] = Utf8 ()I 
.const [170] = Utf8 java/lang/StringBuffer 
.const [171] = Utf8 append 
.const [172] = Utf8 (Ljava/lang/String;)Ljava/lang/StringBuffer; 
.const [173] = Utf8 java/lang/StringBuffer 
.const [174] = Utf8 append 
.const [175] = Utf8 (I)Ljava/lang/StringBuffer; 
.const [176] = Utf8 java/lang/StringBuffer 
.const [177] = Utf8 toString 
.const [178] = Utf8 ()Ljava/lang/String; 
.const [179] = Utf8 de/esolutions/fw/util/tracing/config/TraceConfig 
.const [180] = Utf8 setCoreStatisticsInterval 
.const [181] = Utf8 (I)V 
.const [182] = Utf8 java/lang/Exception 
.const [183] = Utf8 getMessage 
.const [184] = Utf8 ()Ljava/lang/String; 
.const [185] = Utf8 java/lang/Object 
.const [186] = Utf8 <init> 
.const [187] = Utf8 ()V 
.const [188] = Utf8 java/lang/String 
.const [189] = Utf8 <init> 
.const [190] = Utf8 ([BLjava/lang/String;)V 
.const [191] = Utf8 java/lang/StringBuffer 
.const [192] = Utf8 <init> 
.const [193] = Utf8 ()V 
.const [194] = Utf8 de/esolutions/fw/util/tracing/core/TraceCoreStatsLogger 
.const [195] = Utf8 frontend 
.const [196] = Utf8 Lde/esolutions/fw/util/tracing/frontend/TraceFrontend; 
.const [197] = Utf8 de/esolutions/fw/util/tracing/core/TraceCoreStatsLogger 
.const [198] = Utf8 stats 
.const [199] = Utf8 Lde/esolutions/fw/util/tracing/core/TraceCoreStats; 
.const [200] = Utf8 de/esolutions/fw/util/tracing/core/TraceCoreStatsLogger 
.const [201] = Utf8 config 
.const [202] = Utf8 Lde/esolutions/fw/util/tracing/config/TraceConfig; 
.const [203] = Utf8 de/esolutions/fw/util/tracing/core/TraceCoreStatsLogger 
.const [204] = Utf8 channel 
.const [205] = Utf8 I 
.const [206] = Utf8 de/esolutions/fw/util/tracing/core/TraceCoreStatsLogger 
.const [207] = Utf8 thread 
.const [208] = Utf8 I 
.const [209] = Utf8 de/esolutions/fw/util/tracing/core/TraceCoreStatsLogger 
.const [210] = Utf8 callback 
.const [211] = Utf8 I 
.const [212] = Utf8 de/esolutions/fw/util/tracing/core/TraceCoreStatsLogger 
.const [213] = Class [212] 
.const [214] = Utf8 java/lang/Object 
.const [215] = Class [214] 
.const [216] = Utf8 de/esolutions/fw/util/tracing/frontend/ITraceFrontendListener 
.const [217] = Class [216] 
.const [218] = Utf8 frontend 
.const [219] = Utf8 Lde/esolutions/fw/util/tracing/frontend/TraceFrontend; 
.const [220] = Utf8 stats 
.const [221] = Utf8 Lde/esolutions/fw/util/tracing/core/TraceCoreStats; 
.const [222] = Utf8 config 
.const [223] = Utf8 Lde/esolutions/fw/util/tracing/config/TraceConfig; 
.const [224] = Utf8 channel 
.const [225] = Utf8 I 
.const [226] = Utf8 thread 
.const [227] = Utf8 I 
.const [228] = Utf8 callback 
.const [229] = Utf8 I 
.const [230] = Utf8 Code 
.const [231] = Utf8 <init> 
.const [232] = Utf8 (Lde/esolutions/fw/util/tracing/config/TraceConfig;Lde/esolutions/fw/util/tracing/frontend/TraceFrontend;Lde/esolutions/fw/util/tracing/core/TraceCoreStats;)V 
.const [233] = Utf8 log 
.const [234] = Utf8 ()V 
.const [235] = Utf8 executeCallback 
.const [236] = Utf8 (I[B)V 
.const [237] = Utf8 requestFilterLevel 
.const [238] = Utf8 (Lde/esolutions/fw/util/tracing/entity/TraceEntityURI;S)V 
.const [239] = Utf8 requestQuit 
.const [240] = Utf8 ()V 
.end class 
