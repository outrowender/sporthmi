.version 50 0 
.class public super abstract [275] 
.super [277] 
.implements [279] 
.field protected final [280] [281] 
.field protected final [282] [283] 
.field protected final [284] [285] 
.field private [286] [287] 
.field protected [288] [289] 
.field private [290] [291] 
.field public static final [292] [293] 

.method public [295] : [296] 
    .attribute [294] .code stack 3 locals 0 
L0:     aload_0 
L1:     invokespecial [43] 
L4:     aload_0 
L5:     aload_1 
L6:     putfield [47] 
L9:     aload_0 
L10:    aload_2 
L11:    putfield [48] 
L14:    aload_0 
L15:    new [49] 
L18:    dup 
L19:    invokespecial [44] 
L22:    putfield [50] 
L25:    return 
L26:    nop 
L27:    nop 
L28:    
    .end code 
.end method 

.method public [297] : [298] 
    .attribute [294] .code stack 2 locals 0 
L0:     aload_0 
L1:     getfield [26] 
L4:     aload_1 
L5:     invokevirtual [27] 
L8:     pop 
L9:     return 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method public [299] : [300] 
    .attribute [294] .code stack 2 locals 0 
L0:     aload_0 
L1:     getfield [26] 
L4:     aload_1 
L5:     invokevirtual [28] 
L8:     pop 
L9:     return 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method public synchronized [301] : [302] 
    .attribute [294] .code stack 6 locals 0 
L0:     aload_0 
L1:     getfield [29] 
L4:     ifeq L9 
L7:     iconst_0 
L8:     areturn 
L9:     aload_0 
L10:    iconst_1 
L11:    putfield [52] 
L14:    aload_0 
L15:    iconst_1 
L16:    putfield [51] 
L19:    aload_0 
L20:    new [53] 
L23:    dup 
L24:    aload_0 
L25:    new [54] 
L28:    dup 
L29:    invokespecial [45] 
L32:    ldc [5] 
L34:    invokevirtual [31] 
L37:    aload_0 
L38:    getfield [25] 
L41:    invokevirtual [31] 
L44:    invokevirtual [32] 
L47:    invokespecial [46] 
L50:    putfield [55] 
L53:    aload_0 
L54:    getfield [33] 
L57:    invokevirtual [34] 
L60:    iconst_1 
L61:    areturn 
L62:    nop 
L63:    nop 
L64:    
    .end code 
.end method 

.method protected synchronized [303] : [304] 
    .attribute [294] .code stack 3 locals 1 
L0:     aload_0 
L1:     getfield [29] 
L4:     ifne L18 
L7:     getstatic [6] 
L10:    ldc [7] 
L12:    ldc [8] 
L14:    invokestatic [9] 
L17:    return 
L18:    getstatic [10] 
L21:    ldc [7] 
L23:    ldc [11] 
L25:    invokestatic [9] 
L28:    aload_0 
L29:    iconst_0 
L30:    putfield [52] 
L33:    aload_0 
L34:    iconst_0 
L35:    putfield [51] 
L38:    aload_1 
L39:    ifnull L56 
L42:    getstatic [10] 
L45:    ldc [7] 
L47:    ldc [12] 
L49:    invokestatic [9] 
L52:    aload_1 
L53:    invokevirtual [35] 
L56:    getstatic [10] 
L59:    ldc [7] 
L61:    ldc [13] 
L63:    invokestatic [9] 
L66:    aload_0 
L67:    getfield [33] 
L70:    invokevirtual [36] 
        .catch [14] from L73 to L80 using L83 
L73:    aload_0 
L74:    getfield [33] 
L77:    invokevirtual [37] 
L80:    goto L87 
L83:    astore_2 
L84:    goto L73 
L87:    getstatic [10] 
L90:    ldc [7] 
L92:    ldc [15] 
L94:    invokestatic [9] 
L97:    return 
L98:    nop 
L99:    nop 
L100:   
    .end code 
.end method 

.method public [305] : [306] 
    .attribute [294] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [30] 
L4:     ifeq L14 
L7:     aload_0 
L8:     invokevirtual [38] 
L11:    goto L0 
L14:    return 
L15:    nop 
L16:    
    .end code 
.end method 

.method protected [307] : [308] 
    .attribute [294] .code stack 2 locals 2 
L0:     aload_0 
L1:     getfield [26] 
L4:     invokevirtual [39] 
L7:     astore_2 
L8:     aload_2 
L9:     invokeinterface [56] 0 
L14:    ifeq L37 
L17:    aload_2 
L18:    invokeinterface [57] 0 
L23:    checkcast [16] 
L26:    astore_3 
L27:    aload_3 
L28:    aload_1 
L29:    invokeinterface [58] 0 
L34:    goto L8 
L37:    return 
L38:    nop 
L39:    nop 
L40:    
    .end code 
.end method 

.method protected [309] : [310] 
    .attribute [294] .code stack 4 locals 3 
L0:     getstatic [10] 
L3:     aload_1 
L4:     ldc [17] 
L6:     aload_2 
L7:     invokestatic [18] 
L10:    aload_0 
L11:    getfield [26] 
L14:    invokevirtual [39] 
L17:    astore_3 
L18:    aload_3 
L19:    invokeinterface [56] 0 
L24:    ifeq L49 
L27:    aload_3 
L28:    invokeinterface [57] 0 
L33:    checkcast [16] 
L36:    astore 4 
L38:    aload 4 
L40:    aload_2 
L41:    invokeinterface [59] 0 
L46:    goto L18 
L49:    aload_2 
L50:    invokevirtual [40] 
L53:    ifeq L121 
L56:    aload_2 
L57:    invokevirtual [41] 
L60:    astore 4 
L62:    aload 4 
L64:    ifnull L118 
L67:    aload_0 
L68:    getfield [26] 
L71:    invokevirtual [42] 
L74:    ifne L118 
L77:    aload_0 
L78:    getfield [26] 
L81:    invokevirtual [39] 
L84:    astore_3 
L85:    aload_3 
L86:    invokeinterface [56] 0 
L91:    ifeq L118 
L94:    aload_3 
L95:    invokeinterface [57] 0 
L100:   checkcast [16] 
L103:   astore 5 
L105:   aload 5 
L107:   aload_2 
L108:   aload 4 
L110:   invokeinterface [60] 0 
L115:   goto L85 
L118:   goto L49 
L121:   getstatic [10] 
L124:   aload_1 
L125:   ldc [19] 
L127:   aload_2 
L128:   invokestatic [18] 
L131:   aload_0 
L132:   getfield [26] 
L135:   invokevirtual [39] 
L138:   astore_3 
L139:   aload_3 
L140:   invokeinterface [56] 0 
L145:   ifeq L170 
L148:   aload_3 
L149:   invokeinterface [57] 0 
L154:   checkcast [16] 
L157:   astore 4 
L159:   aload 4 
L161:   aload_2 
L162:   invokeinterface [61] 0 
L167:   goto L139 
L170:   return 
L171:   nop 
L172:   
    .end code 
.end method 

.method protected abstract [311] : [312] 
    .attribute [294] .code stack 0 locals 0 
L0:     
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [62] 
.const [3] = Class [63] 
.const [4] = Class [64] 
.const [5] = String [65] 
.const [6] = Field [66] [67] 
.const [7] = String [68] 
.const [8] = String [69] 
.const [9] = Method [70] [71] 
.const [10] = Field [72] [73] 
.const [11] = String [74] 
.const [12] = String [75] 
.const [13] = String [76] 
.const [14] = Class [77] 
.const [15] = String [78] 
.const [16] = Class [79] 
.const [17] = String [80] 
.const [18] = Method [81] [82] 
.const [19] = String [83] 
.const [20] = Class [84] 
.const [21] = Class [85] 
.const [22] = Class [86] 
.const [23] = Class [87] 
.const [24] = Class [88] 
.const [25] = Field [89] [90] 
.const [26] = Field [91] [92] 
.const [27] = Method [93] [94] 
.const [28] = Method [95] [96] 
.const [29] = Field [97] [98] 
.const [30] = Field [99] [100] 
.const [31] = Method [101] [102] 
.const [32] = Method [103] [104] 
.const [33] = Field [105] [106] 
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
.const [44] = Method [127] [128] 
.const [45] = Method [129] [130] 
.const [46] = Method [131] [132] 
.const [47] = Field [133] [134] 
.const [48] = Field [135] [136] 
.const [49] = Class [137] 
.const [50] = Field [138] [139] 
.const [51] = Field [140] [141] 
.const [52] = Field [142] [143] 
.const [53] = Class [144] 
.const [54] = Class [145] 
.const [55] = Field [146] [147] 
.const [56] = InterfaceMethod [148] [149] 
.const [57] = InterfaceMethod [150] [151] 
.const [58] = InterfaceMethod [152] [153] 
.const [59] = InterfaceMethod [154] [155] 
.const [60] = InterfaceMethod [156] [157] 
.const [61] = InterfaceMethod [158] [159] 
.const [62] = Utf8 java/util/ArrayList 
.const [63] = Utf8 java/lang/Thread 
.const [64] = Utf8 java/lang/StringBuffer 
.const [65] = Utf8 ConWorker_ 
.const [66] = Class [160] 
.const [67] = NameAndType [161] [162] 
.const [68] = Utf8 ConnectionFrontendHandler 
.const [69] = Utf8 'stop but not started!' 
.const [70] = Class [163] 
.const [71] = NameAndType [164] [165] 
.const [72] = Class [166] 
.const [73] = NameAndType [167] [168] 
.const [74] = Utf8 stop 
.const [75] = Utf8 disconnect 
.const [76] = Utf8 interrupt 
.const [77] = Utf8 java/lang/InterruptedException 
.const [78] = Utf8 joined 
.const [79] = Utf8 de/esolutions/fw/util/tracing/remote/IConnectionFrontendListener 
.const [80] = Utf8 'connected: %1' 
.const [81] = Class [169] 
.const [82] = NameAndType [170] [171] 
.const [83] = Utf8 'disconnected: %1' 
.const [84] = Utf8 de/esolutions/fw/util/tracing/remote/ConnectionFrontendWorkerBase 
.const [85] = Utf8 java/lang/Object 
.const [86] = Utf8 de/esolutions/fw/util/commons/traceme/TraceMe 
.const [87] = Utf8 de/esolutions/fw/util/tracing/remote/ConnectionFrontendHandler 
.const [88] = Utf8 java/util/Iterator 
.const [89] = Class [172] 
.const [90] = NameAndType [173] [174] 
.const [91] = Class [175] 
.const [92] = NameAndType [176] [177] 
.const [93] = Class [178] 
.const [94] = NameAndType [179] [180] 
.const [95] = Class [181] 
.const [96] = NameAndType [182] [183] 
.const [97] = Class [184] 
.const [98] = NameAndType [185] [186] 
.const [99] = Class [187] 
.const [100] = NameAndType [188] [189] 
.const [101] = Class [190] 
.const [102] = NameAndType [191] [192] 
.const [103] = Class [193] 
.const [104] = NameAndType [194] [195] 
.const [105] = Class [196] 
.const [106] = NameAndType [197] [198] 
.const [107] = Class [199] 
.const [108] = NameAndType [200] [201] 
.const [109] = Class [202] 
.const [110] = NameAndType [203] [204] 
.const [111] = Class [205] 
.const [112] = NameAndType [206] [207] 
.const [113] = Class [208] 
.const [114] = NameAndType [209] [210] 
.const [115] = Class [211] 
.const [116] = NameAndType [212] [213] 
.const [117] = Class [214] 
.const [118] = NameAndType [215] [216] 
.const [119] = Class [217] 
.const [120] = NameAndType [218] [219] 
.const [121] = Class [220] 
.const [122] = NameAndType [221] [222] 
.const [123] = Class [223] 
.const [124] = NameAndType [224] [225] 
.const [125] = Class [226] 
.const [126] = NameAndType [227] [228] 
.const [127] = Class [229] 
.const [128] = NameAndType [230] [231] 
.const [129] = Class [232] 
.const [130] = NameAndType [233] [234] 
.const [131] = Class [235] 
.const [132] = NameAndType [236] [237] 
.const [133] = Class [238] 
.const [134] = NameAndType [239] [240] 
.const [135] = Class [241] 
.const [136] = NameAndType [242] [243] 
.const [137] = Utf8 java/util/ArrayList 
.const [138] = Class [244] 
.const [139] = NameAndType [245] [246] 
.const [140] = Class [247] 
.const [141] = NameAndType [248] [249] 
.const [142] = Class [250] 
.const [143] = NameAndType [251] [252] 
.const [144] = Utf8 java/lang/Thread 
.const [145] = Utf8 java/lang/StringBuffer 
.const [146] = Class [253] 
.const [147] = NameAndType [254] [255] 
.const [148] = Class [256] 
.const [149] = NameAndType [257] [258] 
.const [150] = Class [259] 
.const [151] = NameAndType [260] [261] 
.const [152] = Class [262] 
.const [153] = NameAndType [263] [264] 
.const [154] = Class [265] 
.const [155] = NameAndType [266] [267] 
.const [156] = Class [268] 
.const [157] = NameAndType [269] [270] 
.const [158] = Class [271] 
.const [159] = NameAndType [272] [273] 
.const [160] = Utf8 de/esolutions/fw/util/commons/traceme/TraceMe 
.const [161] = Utf8 ERROR 
.const [162] = Utf8 I 
.const [163] = Utf8 de/esolutions/fw/util/commons/traceme/TraceMe 
.const [164] = Utf8 msg 
.const [165] = Utf8 (ILjava/lang/String;Ljava/lang/String;)V 
.const [166] = Utf8 de/esolutions/fw/util/commons/traceme/TraceMe 
.const [167] = Utf8 INFO 
.const [168] = Utf8 I 
.const [169] = Utf8 de/esolutions/fw/util/commons/traceme/TraceMe 
.const [170] = Utf8 msg 
.const [171] = Utf8 (ILjava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V 
.const [172] = Utf8 de/esolutions/fw/util/tracing/remote/ConnectionFrontendWorkerBase 
.const [173] = Utf8 myName 
.const [174] = Utf8 Ljava/lang/String; 
.const [175] = Utf8 de/esolutions/fw/util/tracing/remote/ConnectionFrontendWorkerBase 
.const [176] = Utf8 listeners 
.const [177] = Utf8 Ljava/util/ArrayList; 
.const [178] = Utf8 java/util/ArrayList 
.const [179] = Utf8 add 
.const [180] = Utf8 (Ljava/lang/Object;)Z 
.const [181] = Utf8 java/util/ArrayList 
.const [182] = Utf8 remove 
.const [183] = Utf8 (Ljava/lang/Object;)Z 
.const [184] = Utf8 de/esolutions/fw/util/tracing/remote/ConnectionFrontendWorkerBase 
.const [185] = Utf8 isStarted 
.const [186] = Utf8 Z 
.const [187] = Utf8 de/esolutions/fw/util/tracing/remote/ConnectionFrontendWorkerBase 
.const [188] = Utf8 keepRunning 
.const [189] = Utf8 Z 
.const [190] = Utf8 java/lang/StringBuffer 
.const [191] = Utf8 append 
.const [192] = Utf8 (Ljava/lang/String;)Ljava/lang/StringBuffer; 
.const [193] = Utf8 java/lang/StringBuffer 
.const [194] = Utf8 toString 
.const [195] = Utf8 ()Ljava/lang/String; 
.const [196] = Utf8 de/esolutions/fw/util/tracing/remote/ConnectionFrontendWorkerBase 
.const [197] = Utf8 thread 
.const [198] = Utf8 Ljava/lang/Thread; 
.const [199] = Utf8 java/lang/Thread 
.const [200] = Utf8 start 
.const [201] = Utf8 ()V 
.const [202] = Utf8 de/esolutions/fw/util/tracing/remote/ConnectionFrontendHandler 
.const [203] = Utf8 disconnect 
.const [204] = Utf8 ()V 
.const [205] = Utf8 java/lang/Thread 
.const [206] = Utf8 interrupt 
.const [207] = Utf8 ()V 
.const [208] = Utf8 java/lang/Thread 
.const [209] = Utf8 join 
.const [210] = Utf8 ()V 
.const [211] = Utf8 de/esolutions/fw/util/tracing/remote/ConnectionFrontendWorkerBase 
.const [212] = Utf8 doRun 
.const [213] = Utf8 ()V 
.const [214] = Utf8 java/util/ArrayList 
.const [215] = Utf8 listIterator 
.const [216] = Utf8 ()Ljava/util/ListIterator; 
.const [217] = Utf8 de/esolutions/fw/util/tracing/remote/ConnectionFrontendHandler 
.const [218] = Utf8 isValid 
.const [219] = Utf8 ()Z 
.const [220] = Utf8 de/esolutions/fw/util/tracing/remote/ConnectionFrontendHandler 
.const [221] = Utf8 handleIncomingMessage 
.const [222] = Utf8 ()Lde/esolutions/fw/util/tracing/protocol/message/AbstractMessage; 
.const [223] = Utf8 java/util/ArrayList 
.const [224] = Utf8 isEmpty 
.const [225] = Utf8 ()Z 
.const [226] = Utf8 java/lang/Object 
.const [227] = Utf8 <init> 
.const [228] = Utf8 ()V 
.const [229] = Utf8 java/util/ArrayList 
.const [230] = Utf8 <init> 
.const [231] = Utf8 ()V 
.const [232] = Utf8 java/lang/StringBuffer 
.const [233] = Utf8 <init> 
.const [234] = Utf8 ()V 
.const [235] = Utf8 java/lang/Thread 
.const [236] = Utf8 <init> 
.const [237] = Utf8 (Ljava/lang/Runnable;Ljava/lang/String;)V 
.const [238] = Utf8 de/esolutions/fw/util/tracing/remote/ConnectionFrontendWorkerBase 
.const [239] = Utf8 myName 
.const [240] = Utf8 Ljava/lang/String; 
.const [241] = Utf8 de/esolutions/fw/util/tracing/remote/ConnectionFrontendWorkerBase 
.const [242] = Utf8 frontend 
.const [243] = Utf8 Lde/esolutions/fw/util/tracing/frontend/TraceFrontend; 
.const [244] = Utf8 de/esolutions/fw/util/tracing/remote/ConnectionFrontendWorkerBase 
.const [245] = Utf8 listeners 
.const [246] = Utf8 Ljava/util/ArrayList; 
.const [247] = Utf8 de/esolutions/fw/util/tracing/remote/ConnectionFrontendWorkerBase 
.const [248] = Utf8 isStarted 
.const [249] = Utf8 Z 
.const [250] = Utf8 de/esolutions/fw/util/tracing/remote/ConnectionFrontendWorkerBase 
.const [251] = Utf8 keepRunning 
.const [252] = Utf8 Z 
.const [253] = Utf8 de/esolutions/fw/util/tracing/remote/ConnectionFrontendWorkerBase 
.const [254] = Utf8 thread 
.const [255] = Utf8 Ljava/lang/Thread; 
.const [256] = Utf8 java/util/Iterator 
.const [257] = Utf8 hasNext 
.const [258] = Utf8 ()Z 
.const [259] = Utf8 java/util/Iterator 
.const [260] = Utf8 next 
.const [261] = Utf8 ()Ljava/lang/Object; 
.const [262] = Utf8 de/esolutions/fw/util/tracing/remote/IConnectionFrontendListener 
.const [263] = Utf8 configureHandler 
.const [264] = Utf8 (Lde/esolutions/fw/util/tracing/remote/ConnectionFrontendHandler;)V 
.const [265] = Utf8 de/esolutions/fw/util/tracing/remote/IConnectionFrontendListener 
.const [266] = Utf8 registerConnection 
.const [267] = Utf8 (Lde/esolutions/fw/util/tracing/remote/ConnectionFrontendHandler;)V 
.const [268] = Utf8 de/esolutions/fw/util/tracing/remote/IConnectionFrontendListener 
.const [269] = Utf8 handleMessage 
.const [270] = Utf8 (Lde/esolutions/fw/util/tracing/remote/ConnectionFrontendHandler;Lde/esolutions/fw/util/tracing/protocol/message/AbstractMessage;)V 
.const [271] = Utf8 de/esolutions/fw/util/tracing/remote/IConnectionFrontendListener 
.const [272] = Utf8 unregisterConnection 
.const [273] = Utf8 (Lde/esolutions/fw/util/tracing/remote/ConnectionFrontendHandler;)V 
.const [274] = Utf8 de/esolutions/fw/util/tracing/remote/ConnectionFrontendWorkerBase 
.const [275] = Class [274] 
.const [276] = Utf8 java/lang/Object 
.const [277] = Class [276] 
.const [278] = Utf8 java/lang/Runnable 
.const [279] = Class [278] 
.const [280] = Utf8 myName 
.const [281] = Utf8 Ljava/lang/String; 
.const [282] = Utf8 frontend 
.const [283] = Utf8 Lde/esolutions/fw/util/tracing/frontend/TraceFrontend; 
.const [284] = Utf8 listeners 
.const [285] = Utf8 Ljava/util/ArrayList; 
.const [286] = Utf8 isStarted 
.const [287] = Utf8 Z 
.const [288] = Utf8 keepRunning 
.const [289] = Utf8 Z 
.const [290] = Utf8 thread 
.const [291] = Utf8 Ljava/lang/Thread; 
.const [292] = Utf8 chn 
.const [293] = Utf8 Ljava/lang/String; 
.const [294] = Utf8 Code 
.const [295] = Utf8 <init> 
.const [296] = Utf8 (Ljava/lang/String;Lde/esolutions/fw/util/tracing/frontend/TraceFrontend;)V 
.const [297] = Utf8 addListener 
.const [298] = Utf8 (Lde/esolutions/fw/util/tracing/remote/IConnectionFrontendListener;)V 
.const [299] = Utf8 removeListener 
.const [300] = Utf8 (Lde/esolutions/fw/util/tracing/remote/IConnectionFrontendListener;)V 
.const [301] = Utf8 start 
.const [302] = Utf8 ()Z 
.const [303] = Utf8 stop 
.const [304] = Utf8 (Lde/esolutions/fw/util/tracing/remote/ConnectionFrontendHandler;)V 
.const [305] = Utf8 run 
.const [306] = Utf8 ()V 
.const [307] = Utf8 configureHandler 
.const [308] = Utf8 (Lde/esolutions/fw/util/tracing/remote/ConnectionFrontendHandler;)V 
.const [309] = Utf8 messageLoop 
.const [310] = Utf8 (Ljava/lang/String;Lde/esolutions/fw/util/tracing/remote/ConnectionFrontendHandler;)V 
.const [311] = Utf8 doRun 
.const [312] = Utf8 ()V 
.end class 
