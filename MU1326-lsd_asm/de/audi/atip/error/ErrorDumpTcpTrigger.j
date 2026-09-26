.version 50 0 
.class public super [333] 
.super [335] 
.implements [337] 
.field private final [338] [339] 
.field private final [340] [341] 
.field private [342] [343] 
.field private volatile [344] [345] 

.method public [347] : [348] 
    .attribute [346] .code stack 3 locals 0 
L0:     aload_0 
L1:     invokespecial [69] 
L4:     aload_0 
L5:     aload_1 
L6:     putfield [72] 
L9:     aload_0 
L10:    aload_1 
L11:    ldc [2] 
L13:    invokeinterface [73] 0 
L18:    putfield [74] 
L21:    return 
L22:    nop 
L23:    nop 
L24:    
    .end code 
.end method 

.method public final [349] : [350] 
    .attribute [346] .code stack 2 locals 0 
L0:     new [75] 
L3:     dup 
L4:     invokespecial [70] 
L7:     ldc [4] 
L9:     invokevirtual [45] 
L12:    aload_0 
L13:    getfield [46] 
L16:    invokevirtual [47] 
L19:    invokevirtual [48] 
L22:    areturn 
L23:    nop 
L24:    
    .end code 
.end method 

.method public [351] : [352] 
    .attribute [346] .code stack 3 locals 1 
L0:     ldc [5] 
L2:     invokestatic [6] 
L5:     astore_1 
L6:     aload_1 
L7:     ifnull L59 
L10:    aload_0 
L11:    aload_1 
L12:    invokevirtual [49] 
L15:    putfield [76] 
L18:    getstatic [7] 
L21:    new [75] 
L24:    dup 
L25:    invokespecial [70] 
L28:    ldc [8] 
L30:    invokevirtual [45] 
L33:    aload_0 
L34:    getfield [46] 
L37:    invokevirtual [47] 
L40:    invokevirtual [48] 
L43:    invokevirtual [50] 
L46:    aload_0 
L47:    getfield [43] 
L50:    invokeinterface [77] 0 
L55:    aload_0 
L56:    invokevirtual [51] 
L59:    return 
L60:    
    .end code 
.end method 

.method public [353] : [354] 
    .attribute [346] .code stack 5 locals 1 
L0:     aload_0 
L1:     getfield [52] 
L4:     ifnull L53 
L7:     aload_0 
L8:     getfield [44] 
L11:    ldc [9] 
L13:    ldc [10] 
L15:    aload_0 
L16:    getfield [46] 
L19:    i2l 
L20:    invokevirtual [53] 
L23:    pop 
        .catch [11] from L24 to L36 using L39 
L24:    aload_0 
L25:    getfield [52] 
L28:    invokevirtual [54] 
L31:    aload_0 
L32:    aconst_null 
L33:    putfield [78] 
L36:    goto L53 
L39:    astore_1 
L40:    aload_0 
L41:    getfield [44] 
L44:    ldc [12] 
L46:    ldc [13] 
L48:    aload_1 
L49:    invokevirtual [55] 
L52:    pop 
L53:    return 
L54:    nop 
L55:    nop 
L56:    
    .end code 
.end method 

.method public [355] : [356] 
    .attribute [346] .code stack 6 locals 4 
L0:     iconst_0 
L1:     istore_2 
L2:     invokestatic [14] 
L5:     new [75] 
L8:     dup 
L9:     invokespecial [70] 
L12:    invokestatic [14] 
L15:    invokevirtual [56] 
L18:    invokevirtual [45] 
L21:    aload_0 
L22:    invokevirtual [57] 
L25:    invokevirtual [48] 
L28:    invokevirtual [58] 
        .catch [11] from L31 to L75 using L78 
L31:    aload_0 
L32:    new [79] 
L35:    dup 
L36:    aload_0 
L37:    getfield [46] 
L40:    bipush 50 
L42:    aconst_null 
L43:    checkcast [16] 
L46:    invokestatic [17] 
L49:    invokespecial [71] 
L52:    putfield [78] 
L55:    aload_0 
L56:    getfield [44] 
L59:    ldc [9] 
L61:    ldc [18] 
L63:    aload_0 
L64:    getfield [52] 
L67:    invokevirtual [59] 
L70:    i2l 
L71:    invokevirtual [53] 
L74:    pop 
L75:    goto L93 
L78:    astore_3 
L79:    aload_0 
L80:    getfield [44] 
L83:    ldc [12] 
L85:    ldc [19] 
L87:    aload_3 
L88:    invokevirtual [55] 
L91:    pop 
L92:    return 
L93:    aload_0 
L94:    getfield [52] 
L97:    ifnull L232 
L100:   aload_0 
L101:   getfield [52] 
L104:   invokevirtual [60] 
L107:   astore_1 
L108:   aload_0 
L109:   getfield [44] 
L112:   ldc [20] 
L114:   ldc [21] 
L116:   aload_1 
L117:   invokevirtual [61] 
L120:   aload_1 
L121:   invokevirtual [62] 
L124:   i2l 
L125:   invokevirtual [63] 
L128:   pop 
L129:   iconst_0 
L130:   istore_2 
L131:   aload_0 
L132:   getfield [43] 
L135:   invokeinterface [80] 0 
L140:   aconst_null 
L141:   ldc [22] 
L143:   iconst_0 
L144:   iconst_0 
L145:   iconst_4 
L146:   invokeinterface [81] 0 
        .catch [24] from L151 to L167 using L170 
        .catch [11] from L100 to L184 using L187 
L151:   aload_1 
L152:   invokevirtual [64] 
L155:   ldc [23] 
L157:   invokevirtual [65] 
L160:   invokevirtual [66] 
L163:   aload_1 
L164:   invokevirtual [67] 
L167:   goto L184 
L170:   astore_3 
L171:   aload_0 
L172:   getfield [44] 
L175:   ldc [12] 
L177:   ldc [25] 
L179:   aload_3 
L180:   invokevirtual [55] 
L183:   pop 
L184:   goto L93 
L187:   astore_3 
L188:   iinc 2 1 
L191:   iload_2 
L192:   iconst_5 
L193:   if_icmple L214 
L196:   aload_0 
L197:   getfield [44] 
L200:   ldc [12] 
L202:   ldc [26] 
L204:   aload_3 
L205:   invokevirtual [55] 
L208:   pop 
L209:   aload_0 
L210:   invokevirtual [68] 
L213:   return 
        .catch [28] from L214 to L220 using L223 
L214:   ldc_w [1] 
L217:   invokestatic [27] 
L220:   goto L229 
L223:   astore 4 
L225:   invokestatic [29] 
L228:   pop 
L229:   goto L93 
L232:   return 
L233:   nop 
L234:   nop 
L235:   nop 
L236:   
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = String [83] 
.const [3] = Class [84] 
.const [4] = String [85] 
.const [5] = String [86] 
.const [6] = Method [87] [88] 
.const [7] = Field [89] [90] 
.const [8] = String [91] 
.const [9] = Int 1078071040 
.const [10] = String [92] 
.const [11] = Class [93] 
.const [12] = Int -1601830656 
.const [13] = String [94] 
.const [14] = Method [95] [96] 
.const [15] = Class [97] 
.const [16] = Class [98] 
.const [17] = Method [99] [100] 
.const [18] = String [101] 
.const [19] = String [102] 
.const [20] = Int -2137614336 
.const [21] = String [103] 
.const [22] = String [104] 
.const [23] = String [105] 
.const [24] = Class [106] 
.const [25] = String [107] 
.const [26] = String [108] 
.const [27] = Method [109] [110] 
.const [28] = Class [111] 
.const [29] = Method [112] [113] 
.const [30] = Class [114] 
.const [31] = Class [115] 
.const [32] = Class [116] 
.const [33] = Class [117] 
.const [34] = Class [118] 
.const [35] = Class [119] 
.const [36] = Class [120] 
.const [37] = Class [121] 
.const [38] = Class [122] 
.const [39] = Class [123] 
.const [40] = Class [124] 
.const [41] = Class [125] 
.const [42] = Class [126] 
.const [43] = Field [127] [128] 
.const [44] = Field [129] [130] 
.const [45] = Method [131] [132] 
.const [46] = Field [133] [134] 
.const [47] = Method [135] [136] 
.const [48] = Method [137] [138] 
.const [49] = Method [139] [140] 
.const [50] = Method [141] [142] 
.const [51] = Method [143] [144] 
.const [52] = Field [145] [146] 
.const [53] = Method [147] [148] 
.const [54] = Method [149] [150] 
.const [55] = Method [151] [152] 
.const [56] = Method [153] [154] 
.const [57] = Method [155] [156] 
.const [58] = Method [157] [158] 
.const [59] = Method [159] [160] 
.const [60] = Method [161] [162] 
.const [61] = Method [163] [164] 
.const [62] = Method [165] [166] 
.const [63] = Method [167] [168] 
.const [64] = Method [169] [170] 
.const [65] = Method [171] [172] 
.const [66] = Method [173] [174] 
.const [67] = Method [175] [176] 
.const [68] = Method [177] [178] 
.const [69] = Method [179] [180] 
.const [70] = Method [181] [182] 
.const [71] = Method [183] [184] 
.const [72] = Field [185] [186] 
.const [73] = InterfaceMethod [187] [188] 
.const [74] = Field [189] [190] 
.const [75] = Class [191] 
.const [76] = Field [192] [193] 
.const [77] = InterfaceMethod [194] [195] 
.const [78] = Field [196] [197] 
.const [79] = Class [198] 
.const [80] = InterfaceMethod [199] [200] 
.const [81] = InterfaceMethod [201] [202] 
.const [82] = Int -402456576 
.const [83] = Utf8 'Fw.Error.Trigger' 
.const [84] = Utf8 java/lang/StringBuffer 
.const [85] = Utf8 'ErrorDumpTcpTrigger:' 
.const [86] = Utf8 ErrorDumpTriggerPort 
.const [87] = Class [203] 
.const [88] = NameAndType [204] [205] 
.const [89] = Class [206] 
.const [90] = NameAndType [207] [208] 
.const [91] = Utf8 'Open ErrorDump Trigger Port on ' 
.const [92] = Utf8 'Closing ErrorDump Trigger Port on %1' 
.const [93] = Utf8 java/io/IOException 
.const [94] = Utf8 'Closing ErrorDump Trigger Port failed!' 
.const [95] = Class [209] 
.const [96] = NameAndType [210] [211] 
.const [97] = Utf8 java/net/ServerSocket 
.const [98] = Utf8 java/lang/String 
.const [99] = Class [212] 
.const [100] = NameAndType [213] [214] 
.const [101] = Utf8 'ErrorDump Trigger waiting for client on port %1' 
.const [102] = Utf8 'ErrorDump Trigger failed to create Server Socket' 
.const [103] = Utf8 'ErrorDump Trigger accepted %1:%2' 
.const [104] = Utf8 'error dump triggered manually' 
.const [105] = Utf8 'ErrorDump written!\r\n\r\n' 
.const [106] = Utf8 java/lang/Exception 
.const [107] = Utf8 'ErrorDump Trigger failed to close client socket' 
.const [108] = Utf8 'ErrorDump Trigger too many failures' 
.const [109] = Class [215] 
.const [110] = NameAndType [216] [217] 
.const [111] = Utf8 java/lang/InterruptedException 
.const [112] = Class [218] 
.const [113] = NameAndType [219] [220] 
.const [114] = Utf8 de/audi/atip/error/ErrorDumpTcpTrigger 
.const [115] = Utf8 java/lang/Object 
.const [116] = Utf8 de/audi/atip/base/IFrameworkAccess 
.const [117] = Utf8 java/lang/Integer 
.const [118] = Utf8 java/lang/System 
.const [119] = Utf8 java/io/PrintStream 
.const [120] = Utf8 de/esolutions/fw/util/commons/threading/ThreadPool 
.const [121] = Utf8 de/audi/atip/log/LogChannel 
.const [122] = Utf8 java/lang/Thread 
.const [123] = Utf8 java/net/InetAddress 
.const [124] = Utf8 java/net/Socket 
.const [125] = Utf8 de/audi/atip/error/IErrorManager 
.const [126] = Utf8 java/io/OutputStream 
.const [127] = Class [221] 
.const [128] = NameAndType [222] [223] 
.const [129] = Class [224] 
.const [130] = NameAndType [225] [226] 
.const [131] = Class [227] 
.const [132] = NameAndType [228] [229] 
.const [133] = Class [230] 
.const [134] = NameAndType [231] [232] 
.const [135] = Class [233] 
.const [136] = NameAndType [234] [235] 
.const [137] = Class [236] 
.const [138] = NameAndType [237] [238] 
.const [139] = Class [239] 
.const [140] = NameAndType [240] [241] 
.const [141] = Class [242] 
.const [142] = NameAndType [243] [244] 
.const [143] = Class [245] 
.const [144] = NameAndType [246] [247] 
.const [145] = Class [248] 
.const [146] = NameAndType [249] [250] 
.const [147] = Class [251] 
.const [148] = NameAndType [252] [253] 
.const [149] = Class [254] 
.const [150] = NameAndType [255] [256] 
.const [151] = Class [257] 
.const [152] = NameAndType [258] [259] 
.const [153] = Class [260] 
.const [154] = NameAndType [261] [262] 
.const [155] = Class [263] 
.const [156] = NameAndType [264] [265] 
.const [157] = Class [266] 
.const [158] = NameAndType [267] [268] 
.const [159] = Class [269] 
.const [160] = NameAndType [270] [271] 
.const [161] = Class [272] 
.const [162] = NameAndType [273] [274] 
.const [163] = Class [275] 
.const [164] = NameAndType [276] [277] 
.const [165] = Class [278] 
.const [166] = NameAndType [279] [280] 
.const [167] = Class [281] 
.const [168] = NameAndType [282] [283] 
.const [169] = Class [284] 
.const [170] = NameAndType [285] [286] 
.const [171] = Class [287] 
.const [172] = NameAndType [288] [289] 
.const [173] = Class [290] 
.const [174] = NameAndType [291] [292] 
.const [175] = Class [293] 
.const [176] = NameAndType [294] [295] 
.const [177] = Class [296] 
.const [178] = NameAndType [297] [298] 
.const [179] = Class [299] 
.const [180] = NameAndType [300] [301] 
.const [181] = Class [302] 
.const [182] = NameAndType [303] [304] 
.const [183] = Class [305] 
.const [184] = NameAndType [306] [307] 
.const [185] = Class [308] 
.const [186] = NameAndType [309] [310] 
.const [187] = Class [311] 
.const [188] = NameAndType [312] [313] 
.const [189] = Class [314] 
.const [190] = NameAndType [315] [316] 
.const [191] = Utf8 java/lang/StringBuffer 
.const [192] = Class [317] 
.const [193] = NameAndType [318] [319] 
.const [194] = Class [320] 
.const [195] = NameAndType [321] [322] 
.const [196] = Class [323] 
.const [197] = NameAndType [324] [325] 
.const [198] = Utf8 java/net/ServerSocket 
.const [199] = Class [326] 
.const [200] = NameAndType [327] [328] 
.const [201] = Class [329] 
.const [202] = NameAndType [330] [331] 
.const [203] = Utf8 java/lang/Integer 
.const [204] = Utf8 getInteger 
.const [205] = Utf8 (Ljava/lang/String;)Ljava/lang/Integer; 
.const [206] = Utf8 java/lang/System 
.const [207] = Utf8 out 
.const [208] = Utf8 Ljava/io/PrintStream; 
.const [209] = Utf8 java/lang/Thread 
.const [210] = Utf8 currentThread 
.const [211] = Utf8 ()Ljava/lang/Thread; 
.const [212] = Utf8 java/net/InetAddress 
.const [213] = Utf8 getByName 
.const [214] = Utf8 (Ljava/lang/String;)Ljava/net/InetAddress; 
.const [215] = Utf8 java/lang/Thread 
.const [216] = Utf8 sleep 
.const [217] = Utf8 (J)V 
.const [218] = Utf8 java/lang/Thread 
.const [219] = Utf8 interrupted 
.const [220] = Utf8 ()Z 
.const [221] = Utf8 de/audi/atip/error/ErrorDumpTcpTrigger 
.const [222] = Utf8 framework 
.const [223] = Utf8 Lde/audi/atip/base/IFrameworkAccess; 
.const [224] = Utf8 de/audi/atip/error/ErrorDumpTcpTrigger 
.const [225] = Utf8 logCh 
.const [226] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [227] = Utf8 java/lang/StringBuffer 
.const [228] = Utf8 append 
.const [229] = Utf8 (Ljava/lang/String;)Ljava/lang/StringBuffer; 
.const [230] = Utf8 de/audi/atip/error/ErrorDumpTcpTrigger 
.const [231] = Utf8 port 
.const [232] = Utf8 I 
.const [233] = Utf8 java/lang/StringBuffer 
.const [234] = Utf8 append 
.const [235] = Utf8 (I)Ljava/lang/StringBuffer; 
.const [236] = Utf8 java/lang/StringBuffer 
.const [237] = Utf8 toString 
.const [238] = Utf8 ()Ljava/lang/String; 
.const [239] = Utf8 java/lang/Integer 
.const [240] = Utf8 intValue 
.const [241] = Utf8 ()I 
.const [242] = Utf8 java/io/PrintStream 
.const [243] = Utf8 println 
.const [244] = Utf8 (Ljava/lang/String;)V 
.const [245] = Utf8 de/esolutions/fw/util/commons/threading/ThreadPool 
.const [246] = Utf8 execute 
.const [247] = Utf8 (Ljava/lang/Runnable;)V 
.const [248] = Utf8 de/audi/atip/error/ErrorDumpTcpTrigger 
.const [249] = Utf8 serverSocket 
.const [250] = Utf8 Ljava/net/ServerSocket; 
.const [251] = Utf8 de/audi/atip/log/LogChannel 
.const [252] = Utf8 log 
.const [253] = Utf8 (ILjava/lang/String;J)Z 
.const [254] = Utf8 java/net/ServerSocket 
.const [255] = Utf8 close 
.const [256] = Utf8 ()V 
.const [257] = Utf8 de/audi/atip/log/LogChannel 
.const [258] = Utf8 log 
.const [259] = Utf8 (ILjava/lang/String;Ljava/lang/Throwable;)Z 
.const [260] = Utf8 java/lang/Thread 
.const [261] = Utf8 getName 
.const [262] = Utf8 ()Ljava/lang/String; 
.const [263] = Utf8 java/lang/StringBuffer 
.const [264] = Utf8 append 
.const [265] = Utf8 (Ljava/lang/Object;)Ljava/lang/StringBuffer; 
.const [266] = Utf8 java/lang/Thread 
.const [267] = Utf8 setName 
.const [268] = Utf8 (Ljava/lang/String;)V 
.const [269] = Utf8 java/net/ServerSocket 
.const [270] = Utf8 getLocalPort 
.const [271] = Utf8 ()I 
.const [272] = Utf8 java/net/ServerSocket 
.const [273] = Utf8 accept 
.const [274] = Utf8 ()Ljava/net/Socket; 
.const [275] = Utf8 java/net/Socket 
.const [276] = Utf8 getInetAddress 
.const [277] = Utf8 ()Ljava/net/InetAddress; 
.const [278] = Utf8 java/net/Socket 
.const [279] = Utf8 getPort 
.const [280] = Utf8 ()I 
.const [281] = Utf8 de/audi/atip/log/LogChannel 
.const [282] = Utf8 log 
.const [283] = Utf8 (ILjava/lang/String;Ljava/lang/Object;J)Z 
.const [284] = Utf8 java/net/Socket 
.const [285] = Utf8 getOutputStream 
.const [286] = Utf8 ()Ljava/io/OutputStream; 
.const [287] = Utf8 java/lang/String 
.const [288] = Utf8 getBytes 
.const [289] = Utf8 ()[B 
.const [290] = Utf8 java/io/OutputStream 
.const [291] = Utf8 write 
.const [292] = Utf8 ([B)V 
.const [293] = Utf8 java/net/Socket 
.const [294] = Utf8 close 
.const [295] = Utf8 ()V 
.const [296] = Utf8 de/audi/atip/error/ErrorDumpTcpTrigger 
.const [297] = Utf8 stop 
.const [298] = Utf8 ()V 
.const [299] = Utf8 java/lang/Object 
.const [300] = Utf8 <init> 
.const [301] = Utf8 ()V 
.const [302] = Utf8 java/lang/StringBuffer 
.const [303] = Utf8 <init> 
.const [304] = Utf8 ()V 
.const [305] = Utf8 java/net/ServerSocket 
.const [306] = Utf8 <init> 
.const [307] = Utf8 (IILjava/net/InetAddress;)V 
.const [308] = Utf8 de/audi/atip/error/ErrorDumpTcpTrigger 
.const [309] = Utf8 framework 
.const [310] = Utf8 Lde/audi/atip/base/IFrameworkAccess; 
.const [311] = Utf8 de/audi/atip/base/IFrameworkAccess 
.const [312] = Utf8 getLogChannel 
.const [313] = Utf8 (Ljava/lang/String;)Lde/audi/atip/log/LogChannel; 
.const [314] = Utf8 de/audi/atip/error/ErrorDumpTcpTrigger 
.const [315] = Utf8 logCh 
.const [316] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [317] = Utf8 de/audi/atip/error/ErrorDumpTcpTrigger 
.const [318] = Utf8 port 
.const [319] = Utf8 I 
.const [320] = Utf8 de/audi/atip/base/IFrameworkAccess 
.const [321] = Utf8 getHMIThreadPool 
.const [322] = Utf8 ()Lde/esolutions/fw/util/commons/threading/ThreadPool; 
.const [323] = Utf8 de/audi/atip/error/ErrorDumpTcpTrigger 
.const [324] = Utf8 serverSocket 
.const [325] = Utf8 Ljava/net/ServerSocket; 
.const [326] = Utf8 de/audi/atip/base/IFrameworkAccess 
.const [327] = Utf8 getErrorMgr 
.const [328] = Utf8 ()Lde/audi/atip/error/IErrorManager; 
.const [329] = Utf8 de/audi/atip/error/IErrorManager 
.const [330] = Utf8 handleError 
.const [331] = Utf8 (Ljava/lang/Throwable;Ljava/lang/String;III)V 
.const [332] = Utf8 de/audi/atip/error/ErrorDumpTcpTrigger 
.const [333] = Class [332] 
.const [334] = Utf8 java/lang/Object 
.const [335] = Class [334] 
.const [336] = Utf8 java/lang/Runnable 
.const [337] = Class [336] 
.const [338] = Utf8 framework 
.const [339] = Utf8 Lde/audi/atip/base/IFrameworkAccess; 
.const [340] = Utf8 logCh 
.const [341] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [342] = Utf8 port 
.const [343] = Utf8 I 
.const [344] = Utf8 serverSocket 
.const [345] = Utf8 Ljava/net/ServerSocket; 
.const [346] = Utf8 Code 
.const [347] = Utf8 <init> 
.const [348] = Utf8 (Lde/audi/atip/base/IFrameworkAccess;)V 
.const [349] = Utf8 toString 
.const [350] = Utf8 ()Ljava/lang/String; 
.const [351] = Utf8 start 
.const [352] = Utf8 ()V 
.const [353] = Utf8 stop 
.const [354] = Utf8 ()V 
.const [355] = Utf8 run 
.const [356] = Utf8 ()V 
.end class 
