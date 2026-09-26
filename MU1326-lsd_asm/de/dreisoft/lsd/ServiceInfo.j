.version 50 0 
.class public super [315] 
.super [317] 
.implements [319] 
.implements [321] 
.field private static [322] [323] 
.field private static [324] [325] 
.field private [326] [327] 
.field private [328] [329] 
.field private [330] [331] 
.field private [332] [333] 
.field private [334] [335] 
.field private [336] [337] 

.method static [339] : [340] 
    .attribute [338] .code stack 1 locals 0 
L0:     aload_0 
L1:     putstatic [49] 
L4:     return 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [341] : [342] 
    .attribute [338] .code stack 6 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     iconst_1 
L3:     anewarray [3] 
L6:     dup 
L7:     iconst_0 
L8:     aload_2 
L9:     aastore 
L10:    aload_3 
L11:    aload 4 
L13:    invokespecial [50] 
L16:    return 
L17:    nop 
L18:    nop 
L19:    nop 
L20:    
    .end code 
.end method 

.method public [343] : [344] 
    .attribute [338] .code stack 6 locals 0 
L0:     aload_0 
L1:     invokespecial [51] 
L4:     aload_0 
L5:     iconst_0 
L6:     putfield [60] 
L9:     aload_0 
L10:    aload_1 
L11:    putfield [61] 
L14:    aload_0 
L15:    getstatic [4] 
L18:    lconst_1 
L19:    ladd 
L20:    dup2 
L21:    putstatic [52] 
L24:    putfield [62] 
L27:    aload_0 
L28:    aload_2 
L29:    putfield [63] 
L32:    aload_0 
L33:    aload 4 
L35:    putfield [64] 
L38:    aload_0 
L39:    getfield [32] 
L42:    ifnonnull L56 
L45:    aload_0 
L46:    new [65] 
L49:    dup 
L50:    invokespecial [53] 
L53:    putfield [64] 
L56:    aload_0 
L57:    aload_3 
L58:    putfield [66] 
L61:    aload_0 
L62:    getfield [32] 
L65:    ldc [6] 
L67:    new [67] 
L70:    dup 
L71:    aload_0 
L72:    getfield [30] 
L75:    invokespecial [54] 
L78:    invokevirtual [34] 
L81:    pop 
L82:    aload_0 
L83:    getfield [32] 
L86:    ldc [8] 
L88:    aload_0 
L89:    getfield [31] 
L92:    invokevirtual [34] 
L95:    pop 
L96:    aload_0 
L97:    getfield [29] 
L100:   ifnull L111 
L103:   aload_0 
L104:   getfield [29] 
L107:   aload_0 
L108:   invokevirtual [35] 
L111:   getstatic [2] 
L114:   aload_0 
L115:   invokevirtual [36] 
L118:   aload_0 
L119:   iconst_1 
L120:   putfield [60] 
L123:   return 
L124:   
    .end code 
.end method 

.method public interface [345] : [346] 
    .attribute [338] .code stack 2 locals 0 
L0:     aload_0 
L1:     getfield [30] 
L4:     freturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public interface [347] : [348] 
    .attribute [338] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [33] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public interface [349] : [350] 
    .attribute [338] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [31] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public interface [351] : [352] 
    .attribute [338] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [32] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [353] : [354] 
    .attribute [338] .code stack 3 locals 3 
L0:     aload_0 
L1:     getfield [32] 
L4:     invokevirtual [37] 
L7:     anewarray [3] 
L10:    astore_1 
L11:    aload_0 
L12:    getfield [32] 
L15:    invokevirtual [38] 
L18:    astore_2 
L19:    iconst_0 
L20:    istore_3 
L21:    aload_2 
L22:    invokeinterface [68] 0 
L27:    ifeq L48 
L30:    aload_1 
L31:    iload_3 
L32:    aload_2 
L33:    invokeinterface [69] 0 
L38:    checkcast [3] 
L41:    aastore 
L42:    iinc 3 1 
L45:    goto L21 
L48:    aload_1 
L49:    areturn 
L50:    nop 
L51:    nop 
L52:    
    .end code 
.end method 

.method public [355] : [356] 
    .attribute [338] .code stack 2 locals 0 
L0:     aload_0 
L1:     getfield [32] 
L4:     aload_1 
L5:     invokevirtual [39] 
L8:     areturn 
L9:     nop 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method public interface [357] : [358] 
    .attribute [338] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [29] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [359] : [360] 
    .attribute [338] .code stack 3 locals 0 
L0:     new [70] 
L3:     dup 
L4:     ldc [10] 
L6:     invokespecial [55] 
L9:     athrow 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method public [361] : [362] 
    .attribute [338] .code stack 1 locals 0 
L0:     aload_0 
L1:     areturn 
L2:     nop 
L3:     nop 
L4:     
    .end code 
.end method 

.method public [363] : [364] 
    .attribute [338] .code stack 3 locals 0 
L0:     new [70] 
L3:     dup 
L4:     ldc [11] 
L6:     invokespecial [55] 
L9:     athrow 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method public [365] : [366] 
    .attribute [338] .code stack 3 locals 0 
L0:     aload_0 
L1:     getfield [28] 
L4:     ifne L17 
L7:     new [71] 
L10:    dup 
L11:    ldc [13] 
L13:    invokespecial [56] 
L16:    athrow 
L17:    aload_0 
L18:    getfield [29] 
L21:    ifnull L32 
L24:    aload_0 
L25:    getfield [29] 
L28:    aload_0 
L29:    invokevirtual [40] 
L32:    getstatic [2] 
L35:    aload_0 
L36:    invokevirtual [41] 
L39:    aload_0 
L40:    iconst_0 
L41:    putfield [60] 
L44:    aload_0 
L45:    aconst_null 
L46:    putfield [66] 
L49:    return 
L50:    nop 
L51:    nop 
L52:    
    .end code 
.end method 

.method public [367] : [368] 
    .attribute [338] .code stack 3 locals 3 
L0:     new [72] 
L3:     dup 
L4:     sipush 500 
L7:     invokespecial [57] 
L10:    astore_1 
L11:    aload_1 
L12:    bipush 91 
L14:    invokevirtual [42] 
L17:    aload_0 
L18:    getfield [30] 
L21:    invokevirtual [43] 
L24:    ldc [15] 
L26:    invokevirtual [44] 
L29:    pop 
L30:    aload_0 
L31:    getfield [33] 
L34:    ifnull L52 
L37:    aload_1 
L38:    aload_0 
L39:    getfield [33] 
L42:    invokespecial [58] 
L45:    invokevirtual [45] 
L48:    invokevirtual [44] 
L51:    pop 
L52:    aload_1 
L53:    ldc [16] 
L55:    invokevirtual [44] 
L58:    pop 
L59:    iconst_0 
L60:    istore_2 
L61:    iload_2 
L62:    aload_0 
L63:    getfield [31] 
L66:    arraylength 
L67:    if_icmpge L105 
L70:    iload_2 
L71:    ifle L81 
L74:    aload_1 
L75:    ldc [17] 
L77:    invokevirtual [44] 
L80:    pop 
L81:    aload_1 
L82:    ldc [18] 
L84:    invokevirtual [44] 
L87:    pop 
L88:    aload_1 
L89:    aload_0 
L90:    getfield [31] 
L93:    iload_2 
L94:    aaload 
L95:    invokevirtual [44] 
L98:    pop 
L99:    iinc 2 1 
L102:   goto L61 
L105:   aload_0 
L106:   getfield [32] 
L109:   invokevirtual [38] 
L112:   astore_2 
L113:   aload_2 
L114:   invokeinterface [68] 0 
L119:   ifeq L173 
L122:   aload_2 
L123:   invokeinterface [69] 0 
L128:   checkcast [3] 
L131:   astore_3 
L132:   aload_3 
L133:   ldc [8] 
L135:   invokevirtual [46] 
L138:   ifne L170 
L141:   aload_1 
L142:   ldc [19] 
L144:   invokevirtual [44] 
L147:   pop 
L148:   aload_1 
L149:   aload_3 
L150:   invokevirtual [44] 
L153:   bipush 61 
L155:   invokevirtual [42] 
L158:   aload_0 
L159:   getfield [32] 
L162:   aload_3 
L163:   invokevirtual [39] 
L166:   invokevirtual [47] 
L169:   pop 
L170:   goto L113 
L173:   aload_1 
L174:   ldc [20] 
L176:   invokevirtual [44] 
L179:   pop 
L180:   aload_1 
L181:   invokevirtual [48] 
L184:   areturn 
L185:   nop 
L186:   nop 
L187:   nop 
L188:   
    .end code 
.end method 

.method public [369] : [370] 
    .attribute [338] .code stack 1 locals 0 
L0:     aload_0 
L1:     invokespecial [59] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method static [371] : [372] 
    .attribute [338] .code stack 2 locals 0 
L0:     ldc2_w [73] 
L3:     putstatic [52] 
L6:     return 
L7:     nop 
L8:     
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Field [75] [76] 
.const [3] = Class [77] 
.const [4] = Field [78] [79] 
.const [5] = Class [80] 
.const [6] = String [81] 
.const [7] = Class [82] 
.const [8] = String [83] 
.const [9] = Class [84] 
.const [10] = String [85] 
.const [11] = String [86] 
.const [12] = Class [87] 
.const [13] = String [88] 
.const [14] = Class [89] 
.const [15] = String [90] 
.const [16] = String [91] 
.const [17] = String [92] 
.const [18] = String [93] 
.const [19] = String [94] 
.const [20] = String [95] 
.const [21] = Class [96] 
.const [22] = Class [97] 
.const [23] = Class [98] 
.const [24] = Class [99] 
.const [25] = Class [100] 
.const [26] = Class [101] 
.const [27] = Class [102] 
.const [28] = Field [103] [104] 
.const [29] = Field [105] [106] 
.const [30] = Field [107] [108] 
.const [31] = Field [109] [110] 
.const [32] = Field [111] [112] 
.const [33] = Field [113] [114] 
.const [34] = Method [115] [116] 
.const [35] = Method [117] [118] 
.const [36] = Method [119] [120] 
.const [37] = Method [121] [122] 
.const [38] = Method [123] [124] 
.const [39] = Method [125] [126] 
.const [40] = Method [127] [128] 
.const [41] = Method [129] [130] 
.const [42] = Method [131] [132] 
.const [43] = Method [133] [134] 
.const [44] = Method [135] [136] 
.const [45] = Method [137] [138] 
.const [46] = Method [139] [140] 
.const [47] = Method [141] [142] 
.const [48] = Method [143] [144] 
.const [49] = Field [145] [146] 
.const [50] = Method [147] [148] 
.const [51] = Method [149] [150] 
.const [52] = Field [151] [152] 
.const [53] = Method [153] [154] 
.const [54] = Method [155] [156] 
.const [55] = Method [157] [158] 
.const [56] = Method [159] [160] 
.const [57] = Method [161] [162] 
.const [58] = Method [163] [164] 
.const [59] = Method [165] [166] 
.const [60] = Field [167] [168] 
.const [61] = Field [169] [170] 
.const [62] = Field [171] [172] 
.const [63] = Field [173] [174] 
.const [64] = Field [175] [176] 
.const [65] = Class [177] 
.const [66] = Field [178] [179] 
.const [67] = Class [180] 
.const [68] = InterfaceMethod [181] [182] 
.const [69] = InterfaceMethod [183] [184] 
.const [70] = Class [185] 
.const [71] = Class [186] 
.const [72] = Class [187] 
.const [73] = Long -1L 
.const [75] = Class [188] 
.const [76] = NameAndType [189] [190] 
.const [77] = Utf8 java/lang/String 
.const [78] = Class [191] 
.const [79] = NameAndType [192] [193] 
.const [80] = Utf8 java/util/Hashtable 
.const [81] = Utf8 'service.id' 
.const [82] = Utf8 java/lang/Long 
.const [83] = Utf8 objectClass 
.const [84] = Utf8 java/lang/UnsupportedOperationException 
.const [85] = Utf8 'ServiceReference.getUsingBundles is not supported' 
.const [86] = Utf8 'ServiceRegistration.setProperties is not supported' 
.const [87] = Utf8 java/lang/IllegalStateException 
.const [88] = Utf8 'service already unregistered' 
.const [89] = Utf8 java/lang/StringBuffer 
.const [90] = Utf8 '] ' 
.const [91] = Utf8 '( ' 
.const [92] = Utf8 ', ' 
.const [93] = Utf8 'Interface=' 
.const [94] = Utf8 ' | ' 
.const [95] = Utf8 ' )' 
.const [96] = Utf8 de/dreisoft/lsd/ServiceInfo 
.const [97] = Utf8 java/lang/Object 
.const [98] = Utf8 java/util/Dictionary 
.const [99] = Utf8 de/dreisoft/lsd/BundleInfo 
.const [100] = Utf8 de/dreisoft/lsd/ServiceRegistry 
.const [101] = Utf8 java/util/Enumeration 
.const [102] = Utf8 java/lang/Class 
.const [103] = Class [194] 
.const [104] = NameAndType [195] [196] 
.const [105] = Class [197] 
.const [106] = NameAndType [198] [199] 
.const [107] = Class [200] 
.const [108] = NameAndType [201] [202] 
.const [109] = Class [203] 
.const [110] = NameAndType [204] [205] 
.const [111] = Class [206] 
.const [112] = NameAndType [207] [208] 
.const [113] = Class [209] 
.const [114] = NameAndType [210] [211] 
.const [115] = Class [212] 
.const [116] = NameAndType [213] [214] 
.const [117] = Class [215] 
.const [118] = NameAndType [216] [217] 
.const [119] = Class [218] 
.const [120] = NameAndType [219] [220] 
.const [121] = Class [221] 
.const [122] = NameAndType [222] [223] 
.const [123] = Class [224] 
.const [124] = NameAndType [225] [226] 
.const [125] = Class [227] 
.const [126] = NameAndType [228] [229] 
.const [127] = Class [230] 
.const [128] = NameAndType [231] [232] 
.const [129] = Class [233] 
.const [130] = NameAndType [234] [235] 
.const [131] = Class [236] 
.const [132] = NameAndType [237] [238] 
.const [133] = Class [239] 
.const [134] = NameAndType [240] [241] 
.const [135] = Class [242] 
.const [136] = NameAndType [243] [244] 
.const [137] = Class [245] 
.const [138] = NameAndType [246] [247] 
.const [139] = Class [248] 
.const [140] = NameAndType [249] [250] 
.const [141] = Class [251] 
.const [142] = NameAndType [252] [253] 
.const [143] = Class [254] 
.const [144] = NameAndType [255] [256] 
.const [145] = Class [257] 
.const [146] = NameAndType [258] [259] 
.const [147] = Class [260] 
.const [148] = NameAndType [261] [262] 
.const [149] = Class [263] 
.const [150] = NameAndType [264] [265] 
.const [151] = Class [266] 
.const [152] = NameAndType [267] [268] 
.const [153] = Class [269] 
.const [154] = NameAndType [270] [271] 
.const [155] = Class [272] 
.const [156] = NameAndType [273] [274] 
.const [157] = Class [275] 
.const [158] = NameAndType [276] [277] 
.const [159] = Class [278] 
.const [160] = NameAndType [279] [280] 
.const [161] = Class [281] 
.const [162] = NameAndType [282] [283] 
.const [163] = Class [284] 
.const [164] = NameAndType [285] [286] 
.const [165] = Class [287] 
.const [166] = NameAndType [288] [289] 
.const [167] = Class [290] 
.const [168] = NameAndType [291] [292] 
.const [169] = Class [293] 
.const [170] = NameAndType [294] [295] 
.const [171] = Class [296] 
.const [172] = NameAndType [297] [298] 
.const [173] = Class [299] 
.const [174] = NameAndType [300] [301] 
.const [175] = Class [302] 
.const [176] = NameAndType [303] [304] 
.const [177] = Utf8 java/util/Hashtable 
.const [178] = Class [305] 
.const [179] = NameAndType [306] [307] 
.const [180] = Utf8 java/lang/Long 
.const [181] = Class [308] 
.const [182] = NameAndType [309] [310] 
.const [183] = Class [311] 
.const [184] = NameAndType [312] [313] 
.const [185] = Utf8 java/lang/UnsupportedOperationException 
.const [186] = Utf8 java/lang/IllegalStateException 
.const [187] = Utf8 java/lang/StringBuffer 
.const [188] = Utf8 de/dreisoft/lsd/ServiceInfo 
.const [189] = Utf8 svcRegistry 
.const [190] = Utf8 Lde/dreisoft/lsd/ServiceRegistry; 
.const [191] = Utf8 de/dreisoft/lsd/ServiceInfo 
.const [192] = Utf8 highestSvcID 
.const [193] = Utf8 J 
.const [194] = Utf8 de/dreisoft/lsd/ServiceInfo 
.const [195] = Utf8 registered 
.const [196] = Utf8 Z 
.const [197] = Utf8 de/dreisoft/lsd/ServiceInfo 
.const [198] = Utf8 bdlInfo 
.const [199] = Utf8 Lde/dreisoft/lsd/BundleInfo; 
.const [200] = Utf8 de/dreisoft/lsd/ServiceInfo 
.const [201] = Utf8 svcID 
.const [202] = Utf8 J 
.const [203] = Utf8 de/dreisoft/lsd/ServiceInfo 
.const [204] = Utf8 svcInterfaces 
.const [205] = Utf8 [Ljava/lang/String; 
.const [206] = Utf8 de/dreisoft/lsd/ServiceInfo 
.const [207] = Utf8 svcProperties 
.const [208] = Utf8 Ljava/util/Dictionary; 
.const [209] = Utf8 de/dreisoft/lsd/ServiceInfo 
.const [210] = Utf8 svcObject 
.const [211] = Utf8 Ljava/lang/Object; 
.const [212] = Utf8 java/util/Dictionary 
.const [213] = Utf8 put 
.const [214] = Utf8 (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object; 
.const [215] = Utf8 de/dreisoft/lsd/BundleInfo 
.const [216] = Utf8 addService 
.const [217] = Utf8 (Lde/dreisoft/lsd/ServiceInfo;)V 
.const [218] = Utf8 de/dreisoft/lsd/ServiceRegistry 
.const [219] = Utf8 registerService 
.const [220] = Utf8 (Lde/dreisoft/lsd/ServiceInfo;)V 
.const [221] = Utf8 java/util/Dictionary 
.const [222] = Utf8 size 
.const [223] = Utf8 ()I 
.const [224] = Utf8 java/util/Dictionary 
.const [225] = Utf8 keys 
.const [226] = Utf8 ()Ljava/util/Enumeration; 
.const [227] = Utf8 java/util/Dictionary 
.const [228] = Utf8 get 
.const [229] = Utf8 (Ljava/lang/Object;)Ljava/lang/Object; 
.const [230] = Utf8 de/dreisoft/lsd/BundleInfo 
.const [231] = Utf8 removeService 
.const [232] = Utf8 (Lde/dreisoft/lsd/ServiceInfo;)V 
.const [233] = Utf8 de/dreisoft/lsd/ServiceRegistry 
.const [234] = Utf8 unregisterService 
.const [235] = Utf8 (Lde/dreisoft/lsd/ServiceInfo;)V 
.const [236] = Utf8 java/lang/StringBuffer 
.const [237] = Utf8 append 
.const [238] = Utf8 (C)Ljava/lang/StringBuffer; 
.const [239] = Utf8 java/lang/StringBuffer 
.const [240] = Utf8 append 
.const [241] = Utf8 (J)Ljava/lang/StringBuffer; 
.const [242] = Utf8 java/lang/StringBuffer 
.const [243] = Utf8 append 
.const [244] = Utf8 (Ljava/lang/String;)Ljava/lang/StringBuffer; 
.const [245] = Utf8 java/lang/Class 
.const [246] = Utf8 getName 
.const [247] = Utf8 ()Ljava/lang/String; 
.const [248] = Utf8 java/lang/String 
.const [249] = Utf8 equals 
.const [250] = Utf8 (Ljava/lang/Object;)Z 
.const [251] = Utf8 java/lang/StringBuffer 
.const [252] = Utf8 append 
.const [253] = Utf8 (Ljava/lang/Object;)Ljava/lang/StringBuffer; 
.const [254] = Utf8 java/lang/StringBuffer 
.const [255] = Utf8 toString 
.const [256] = Utf8 ()Ljava/lang/String; 
.const [257] = Utf8 de/dreisoft/lsd/ServiceInfo 
.const [258] = Utf8 svcRegistry 
.const [259] = Utf8 Lde/dreisoft/lsd/ServiceRegistry; 
.const [260] = Utf8 de/dreisoft/lsd/ServiceInfo 
.const [261] = Utf8 <init> 
.const [262] = Utf8 (Lde/dreisoft/lsd/BundleInfo;[Ljava/lang/String;Ljava/lang/Object;Ljava/util/Dictionary;)V 
.const [263] = Utf8 java/lang/Object 
.const [264] = Utf8 <init> 
.const [265] = Utf8 ()V 
.const [266] = Utf8 de/dreisoft/lsd/ServiceInfo 
.const [267] = Utf8 highestSvcID 
.const [268] = Utf8 J 
.const [269] = Utf8 java/util/Hashtable 
.const [270] = Utf8 <init> 
.const [271] = Utf8 ()V 
.const [272] = Utf8 java/lang/Long 
.const [273] = Utf8 <init> 
.const [274] = Utf8 (J)V 
.const [275] = Utf8 java/lang/UnsupportedOperationException 
.const [276] = Utf8 <init> 
.const [277] = Utf8 (Ljava/lang/String;)V 
.const [278] = Utf8 java/lang/IllegalStateException 
.const [279] = Utf8 <init> 
.const [280] = Utf8 (Ljava/lang/String;)V 
.const [281] = Utf8 java/lang/StringBuffer 
.const [282] = Utf8 <init> 
.const [283] = Utf8 (I)V 
.const [284] = Utf8 java/lang/Object 
.const [285] = Utf8 getClass 
.const [286] = Utf8 ()Ljava/lang/Class; 
.const [287] = Utf8 java/lang/Object 
.const [288] = Utf8 hashCode 
.const [289] = Utf8 ()I 
.const [290] = Utf8 de/dreisoft/lsd/ServiceInfo 
.const [291] = Utf8 registered 
.const [292] = Utf8 Z 
.const [293] = Utf8 de/dreisoft/lsd/ServiceInfo 
.const [294] = Utf8 bdlInfo 
.const [295] = Utf8 Lde/dreisoft/lsd/BundleInfo; 
.const [296] = Utf8 de/dreisoft/lsd/ServiceInfo 
.const [297] = Utf8 svcID 
.const [298] = Utf8 J 
.const [299] = Utf8 de/dreisoft/lsd/ServiceInfo 
.const [300] = Utf8 svcInterfaces 
.const [301] = Utf8 [Ljava/lang/String; 
.const [302] = Utf8 de/dreisoft/lsd/ServiceInfo 
.const [303] = Utf8 svcProperties 
.const [304] = Utf8 Ljava/util/Dictionary; 
.const [305] = Utf8 de/dreisoft/lsd/ServiceInfo 
.const [306] = Utf8 svcObject 
.const [307] = Utf8 Ljava/lang/Object; 
.const [308] = Utf8 java/util/Enumeration 
.const [309] = Utf8 hasMoreElements 
.const [310] = Utf8 ()Z 
.const [311] = Utf8 java/util/Enumeration 
.const [312] = Utf8 nextElement 
.const [313] = Utf8 ()Ljava/lang/Object; 
.const [314] = Utf8 de/dreisoft/lsd/ServiceInfo 
.const [315] = Class [314] 
.const [316] = Utf8 java/lang/Object 
.const [317] = Class [316] 
.const [318] = Utf8 org/osgi/framework/ServiceReference 
.const [319] = Class [318] 
.const [320] = Utf8 org/osgi/framework/ServiceRegistration 
.const [321] = Class [320] 
.const [322] = Utf8 svcRegistry 
.const [323] = Utf8 Lde/dreisoft/lsd/ServiceRegistry; 
.const [324] = Utf8 highestSvcID 
.const [325] = Utf8 J 
.const [326] = Utf8 bdlInfo 
.const [327] = Utf8 Lde/dreisoft/lsd/BundleInfo; 
.const [328] = Utf8 svcID 
.const [329] = Utf8 J 
.const [330] = Utf8 svcInterfaces 
.const [331] = Utf8 [Ljava/lang/String; 
.const [332] = Utf8 svcProperties 
.const [333] = Utf8 Ljava/util/Dictionary; 
.const [334] = Utf8 svcObject 
.const [335] = Utf8 Ljava/lang/Object; 
.const [336] = Utf8 registered 
.const [337] = Utf8 Z 
.const [338] = Utf8 Code 
.const [339] = Utf8 setServiceRegistry 
.const [340] = Utf8 (Lde/dreisoft/lsd/ServiceRegistry;)V 
.const [341] = Utf8 <init> 
.const [342] = Utf8 (Lde/dreisoft/lsd/BundleInfo;Ljava/lang/String;Ljava/lang/Object;Ljava/util/Dictionary;)V 
.const [343] = Utf8 <init> 
.const [344] = Utf8 (Lde/dreisoft/lsd/BundleInfo;[Ljava/lang/String;Ljava/lang/Object;Ljava/util/Dictionary;)V 
.const [345] = Utf8 getServiceID 
.const [346] = Utf8 ()J 
.const [347] = Utf8 getService 
.const [348] = Utf8 ()Ljava/lang/Object; 
.const [349] = Utf8 getServiceInterfaces 
.const [350] = Utf8 ()[Ljava/lang/String; 
.const [351] = Utf8 getProperties 
.const [352] = Utf8 ()Ljava/util/Dictionary; 
.const [353] = Utf8 getPropertyKeys 
.const [354] = Utf8 ()[Ljava/lang/String; 
.const [355] = Utf8 getProperty 
.const [356] = Utf8 (Ljava/lang/String;)Ljava/lang/Object; 
.const [357] = Utf8 getBundle 
.const [358] = Utf8 ()Lorg/osgi/framework/Bundle; 
.const [359] = Utf8 getUsingBundles 
.const [360] = Utf8 ()[Lorg/osgi/framework/Bundle; 
.const [361] = Utf8 getReference 
.const [362] = Utf8 ()Lorg/osgi/framework/ServiceReference; 
.const [363] = Utf8 setProperties 
.const [364] = Utf8 (Ljava/util/Dictionary;)V 
.const [365] = Utf8 unregister 
.const [366] = Utf8 ()V 
.const [367] = Utf8 toString 
.const [368] = Utf8 ()Ljava/lang/String; 
.const [369] = Utf8 hashCode 
.const [370] = Utf8 ()I 
.const [371] = Utf8 <clinit> 
.const [372] = Utf8 ()V 
.end class 
