.version 50 0 
.class public final super [357] 
.super [359] 
.field private final [360] [361] 
.field private final [362] [363] 
.field private final [364] [365] 

.method static [367] : [368] 
    .attribute [366] .code stack 1 locals 0 
L0:     ldc [4] 
L2:     invokestatic [5] 
L5:     invokestatic [7] 
L8:     return 
L9:     nop 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method public [369] : [370] 
    .attribute [366] .code stack 5 locals 5 
L0:     aload_0 
L1:     invokespecial [58] 
L4:     aload_0 
L5:     new [70] 
L8:     dup 
L9:     invokespecial [59] 
L12:    putfield [71] 
L15:    aload_0 
L16:    new [72] 
L19:    dup 
L20:    invokespecial [60] 
L23:    putfield [73] 
L26:    aload_0 
L27:    aload_1 
L28:    arraylength 
L29:    anewarray [10] 
L32:    putfield [75] 
L35:    iconst_0 
L36:    istore_2 
L37:    goto L150 
L40:    aload_1 
L41:    iload_2 
L42:    aaload 
L43:    astore_3 
L44:    aload_3 
L45:    ifnonnull L51 
L48:    goto L147 
L51:    aload_3 
L52:    invokevirtual [35] 
L55:    astore 4 
L57:    ldc [12] 
L59:    aload 4 
L61:    invokevirtual [36] 
L64:    ifeq L147 
L67:    aload_3 
L68:    invokevirtual [37] 
L71:    astore 5 
L73:    aload_3 
L74:    invokevirtual [38] 
L77:    astore 6 
L79:    aload 6 
L81:    ifnull L132 
L84:    aload 6 
L86:    invokevirtual [39] 
L89:    ifle L132 
L92:    new [76] 
L95:    dup 
L96:    aload 6 
L98:    invokevirtual [39] 
L101:   aload 5 
L103:   invokevirtual [39] 
L106:   iadd 
L107:   iconst_2 
L108:   iadd 
L109:   invokespecial [61] 
L112:   ldc [15] 
L114:   invokevirtual [40] 
L117:   aload 6 
L119:   invokevirtual [40] 
L122:   aload 5 
L124:   invokevirtual [40] 
L127:   invokevirtual [41] 
L130:   astore 5 
L132:   aload_0 
L133:   getfield [34] 
L136:   iload_2 
L137:   new [74] 
L140:   dup 
L141:   aload 5 
L143:   invokespecial [62] 
L146:   aastore 
L147:   iinc 2 1 
L150:   iload_2 
L151:   aload_1 
L152:   arraylength 
L153:   if_icmplt L40 
L156:   return 
L157:   nop 
L158:   nop 
L159:   nop 
L160:   
    .end code 
.end method 

.method private static native [371] : [372] 
    .attribute [366] .code stack 0 locals 0 
L0:     
    .end code 
.end method 

.method synchronized [373] : [374] 
    .attribute [366] .code stack 6 locals 6 
L0:     aload_0 
L1:     getfield [32] 
L4:     aload_1 
L5:     invokevirtual [42] 
L8:     ifeq L35 
L11:    new [77] 
L14:    dup 
L15:    new [76] 
L18:    dup 
L19:    ldc [17] 
L21:    invokespecial [63] 
L24:    aload_1 
L25:    invokevirtual [40] 
L28:    invokevirtual [41] 
L31:    invokespecial [64] 
L34:    athrow 
L35:    iconst_0 
L36:    istore_2 
L37:    goto L190 
L40:    aload_0 
L41:    getfield [34] 
L44:    iload_2 
L45:    aaload 
L46:    astore_3 
L47:    aload_3 
L48:    ifnonnull L54 
L51:    goto L187 
L54:    new [78] 
L57:    dup 
L58:    aload_3 
L59:    invokevirtual [43] 
L62:    invokespecial [65] 
L65:    astore 4 
L67:    aload 4 
L69:    invokevirtual [44] 
L72:    ifeq L187 
L75:    aconst_null 
L76:    astore 5 
        .catch [25] from L78 to L144 using L148 
L78:    aload_0 
L79:    aload 4 
L81:    invokevirtual [45] 
L84:    aload_3 
L85:    aload_1 
L86:    invokespecial [66] 
L89:    astore 5 
L91:    aload 5 
L93:    ifnull L187 
L96:    aload 5 
L98:    invokevirtual [46] 
L101:   astore 6 
L103:   new [79] 
L106:   dup 
L107:   aload_0 
L108:   aload_3 
L109:   aload 5 
L111:   aload_1 
L112:   invokespecial [67] 
L115:   astore 7 
L117:   aload 6 
L119:   aload_0 
L120:   invokestatic [21] 
L123:   aload_0 
L124:   getfield [32] 
L127:   aload_1 
L128:   aload 7 
L130:   invokevirtual [47] 
L133:   pop 
L134:   aload_0 
L135:   getfield [33] 
L138:   aload 7 
L140:   invokevirtual [48] 
L143:   pop 
L144:   return 
L145:   goto L187 
L148:   astore 6 
L150:   new [77] 
L153:   dup 
L154:   new [76] 
L157:   dup 
L158:   ldc [23] 
L160:   invokespecial [63] 
L163:   aload_1 
L164:   invokevirtual [40] 
L167:   ldc [24] 
L169:   invokevirtual [40] 
L172:   aload 6 
L174:   invokevirtual [49] 
L177:   invokevirtual [40] 
L180:   invokevirtual [41] 
L183:   invokespecial [64] 
L186:   athrow 
L187:   iinc 2 1 
L190:   iload_2 
L191:   aload_0 
L192:   getfield [34] 
L195:   arraylength 
L196:   if_icmplt L40 
L199:   new [77] 
L202:   dup 
L203:   new [76] 
L206:   dup 
L207:   ldc [26] 
L209:   invokespecial [63] 
L212:   aload_1 
L213:   invokevirtual [40] 
L216:   invokevirtual [41] 
L219:   invokespecial [64] 
L222:   athrow 
L223:   nop 
L224:   
    .end code 
.end method 

.method private native [375] : [376] 
    .attribute [366] .code stack 0 locals 0 
L0:     
    .end code 
.end method 

.method synchronized [377] : [378] 
    .attribute [366] .code stack 2 locals 1 
L0:     aload_0 
L1:     getfield [32] 
L4:     aload_1 
L5:     invokevirtual [50] 
L8:     astore_2 
L9:     aload_2 
L10:    ifnull L22 
L13:    aload_0 
L14:    getfield [33] 
L17:    aload_2 
L18:    invokevirtual [51] 
L21:    pop 
L22:    return 
L23:    nop 
L24:    
    .end code 
.end method 

.method static native [379] : [380] 
    .attribute [366] .code stack 0 locals 0 
L0:     
    .end code 
.end method 

.method [381] : [382] 
    .attribute [366] .code stack 2 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     invokespecial [68] 
L5:     return 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method private native [383] : [384] 
    .attribute [366] .code stack 0 locals 0 
L0:     
    .end code 
.end method 

.method public [385] : [386] 
    .attribute [366] .code stack 3 locals 1 
        .catch [27] from L0 to L7 using L8 
L0:     aload_0 
L1:     aload_1 
L2:     invokespecial [69] 
L5:     astore_2 
L6:     aload_2 
L7:     areturn 
L8:     astore_2 
L9:     aload_0 
L10:    aload_1 
L11:    aconst_null 
L12:    invokevirtual [52] 
L15:    areturn 
L16:    
    .end code 
.end method 

.method public [387] : [388] 
    .attribute [366] .code stack 2 locals 3 
L0:     aload_0 
L1:     getfield [33] 
L4:     invokevirtual [53] 
L7:     astore_3 
L8:     goto L47 
L11:    aload_3 
L12:    invokeinterface [80] 0 
L17:    checkcast [20] 
L20:    astore 4 
L22:    aload 4 
L24:    aload_2 
L25:    if_acmpne L31 
L28:    goto L47 
L31:    aload 4 
L33:    aload_1 
L34:    invokevirtual [54] 
L37:    astore 5 
L39:    aload 5 
L41:    ifnull L47 
L44:    aload 5 
L46:    areturn 
L47:    aload_3 
L48:    invokeinterface [81] 0 
L53:    ifne L11 
L56:    aconst_null 
L57:    areturn 
L58:    nop 
L59:    nop 
L60:    
    .end code 
.end method 

.method public [389] : [390] 
    .attribute [366] .code stack 2 locals 0 
L0:     aload_0 
L1:     getfield [32] 
L4:     invokevirtual [55] 
L7:     aload_0 
L8:     getfield [32] 
L11:    invokevirtual [56] 
L14:    anewarray [13] 
L17:    invokeinterface [82] 0 
L22:    checkcast [30] 
L25:    areturn 
L26:    nop 
L27:    nop 
L28:    
    .end code 
.end method 

.method public [391] : [392] 
    .attribute [366] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [32] 
L4:     invokevirtual [57] 
L7:     return 
L8:     
    .end code 
.end method 

.method static [393] : [394] 
    .attribute [366] .code stack 1 locals 0 
L0:     aload_0 
L1:     invokestatic [31] 
L4:     return 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method private static native [395] : [396] 
    .attribute [366] .code stack 0 locals 0 
L0:     
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [83] 
.const [3] = Class [84] 
.const [4] = String [85] 
.const [5] = Method [86] [87] 
.const [6] = Class [88] 
.const [7] = Method [89] [90] 
.const [8] = Class [91] 
.const [9] = Class [92] 
.const [10] = Class [93] 
.const [11] = Class [94] 
.const [12] = String [95] 
.const [13] = Class [96] 
.const [14] = Class [97] 
.const [15] = String [98] 
.const [16] = Class [99] 
.const [17] = String [100] 
.const [18] = Class [101] 
.const [19] = Class [102] 
.const [20] = Class [103] 
.const [21] = Method [104] [105] 
.const [22] = Class [106] 
.const [23] = String [107] 
.const [24] = String [108] 
.const [25] = Class [109] 
.const [26] = String [110] 
.const [27] = Class [111] 
.const [28] = Class [112] 
.const [29] = Class [113] 
.const [30] = Class [114] 
.const [31] = Method [115] [116] 
.const [32] = Field [117] [118] 
.const [33] = Field [119] [120] 
.const [34] = Field [121] [122] 
.const [35] = Method [123] [124] 
.const [36] = Method [125] [126] 
.const [37] = Method [127] [128] 
.const [38] = Method [129] [130] 
.const [39] = Method [131] [132] 
.const [40] = Method [133] [134] 
.const [41] = Method [135] [136] 
.const [42] = Method [137] [138] 
.const [43] = Method [139] [140] 
.const [44] = Method [141] [142] 
.const [45] = Method [143] [144] 
.const [46] = Method [145] [146] 
.const [47] = Method [147] [148] 
.const [48] = Method [149] [150] 
.const [49] = Method [151] [152] 
.const [50] = Method [153] [154] 
.const [51] = Method [155] [156] 
.const [52] = Method [157] [158] 
.const [53] = Method [159] [160] 
.const [54] = Method [161] [162] 
.const [55] = Method [163] [164] 
.const [56] = Method [165] [166] 
.const [57] = Method [167] [168] 
.const [58] = Method [169] [170] 
.const [59] = Method [171] [172] 
.const [60] = Method [173] [174] 
.const [61] = Method [175] [176] 
.const [62] = Method [177] [178] 
.const [63] = Method [179] [180] 
.const [64] = Method [181] [182] 
.const [65] = Method [183] [184] 
.const [66] = Method [185] [186] 
.const [67] = Method [187] [188] 
.const [68] = Method [189] [190] 
.const [69] = Method [191] [192] 
.const [70] = Class [193] 
.const [71] = Field [194] [195] 
.const [72] = Class [196] 
.const [73] = Field [197] [198] 
.const [74] = Class [199] 
.const [75] = Field [200] [201] 
.const [76] = Class [202] 
.const [77] = Class [203] 
.const [78] = Class [204] 
.const [79] = Class [205] 
.const [80] = InterfaceMethod [206] [207] 
.const [81] = InterfaceMethod [208] [209] 
.const [82] = InterfaceMethod [210] [211] 
.const [83] = Utf8 com/microdoc/j9/xip/XIPClassLoader 
.const [84] = Utf8 java/lang/ClassLoader 
.const [85] = Utf8 xip 
.const [86] = Class [212] 
.const [87] = NameAndType [213] [214] 
.const [88] = Utf8 java/lang/System 
.const [89] = Class [215] 
.const [90] = NameAndType [216] [217] 
.const [91] = Utf8 java/util/Hashtable 
.const [92] = Utf8 java/util/ArrayList 
.const [93] = Utf8 com/microdoc/j9/xip/Archive 
.const [94] = Utf8 java/net/URL 
.const [95] = Utf8 file 
.const [96] = Utf8 java/lang/String 
.const [97] = Utf8 java/lang/StringBuffer 
.const [98] = Utf8 '//' 
.const [99] = Utf8 java/lang/IllegalArgumentException 
.const [100] = Utf8 'Already loaded this container name: ' 
.const [101] = Utf8 java/io/File 
.const [102] = Utf8 com/microdoc/j9/xip/JxeData 
.const [103] = Utf8 com/microdoc/j9/xip/JxeClassLoader 
.const [104] = Class [218] 
.const [105] = NameAndType [219] [220] 
.const [106] = Utf8 com/ibm/oti/vm/JxeUtil 
.const [107] = Utf8 'Error loading ' 
.const [108] = Utf8 ': ' 
.const [109] = Utf8 java/lang/Exception 
.const [110] = Utf8 'Container name not found in the class path: ' 
.const [111] = Utf8 java/lang/ClassNotFoundException 
.const [112] = Utf8 java/util/Iterator 
.const [113] = Utf8 java/util/Set 
.const [114] = Utf8 [Ljava/lang/String; 
.const [115] = Class [221] 
.const [116] = NameAndType [222] [223] 
.const [117] = Class [224] 
.const [118] = NameAndType [225] [226] 
.const [119] = Class [227] 
.const [120] = NameAndType [228] [229] 
.const [121] = Class [230] 
.const [122] = NameAndType [231] [232] 
.const [123] = Class [233] 
.const [124] = NameAndType [234] [235] 
.const [125] = Class [236] 
.const [126] = NameAndType [237] [238] 
.const [127] = Class [239] 
.const [128] = NameAndType [240] [241] 
.const [129] = Class [242] 
.const [130] = NameAndType [243] [244] 
.const [131] = Class [245] 
.const [132] = NameAndType [246] [247] 
.const [133] = Class [248] 
.const [134] = NameAndType [249] [250] 
.const [135] = Class [251] 
.const [136] = NameAndType [252] [253] 
.const [137] = Class [254] 
.const [138] = NameAndType [255] [256] 
.const [139] = Class [257] 
.const [140] = NameAndType [258] [259] 
.const [141] = Class [260] 
.const [142] = NameAndType [261] [262] 
.const [143] = Class [263] 
.const [144] = NameAndType [264] [265] 
.const [145] = Class [266] 
.const [146] = NameAndType [267] [268] 
.const [147] = Class [269] 
.const [148] = NameAndType [270] [271] 
.const [149] = Class [272] 
.const [150] = NameAndType [273] [274] 
.const [151] = Class [275] 
.const [152] = NameAndType [276] [277] 
.const [153] = Class [278] 
.const [154] = NameAndType [279] [280] 
.const [155] = Class [281] 
.const [156] = NameAndType [282] [283] 
.const [157] = Class [284] 
.const [158] = NameAndType [285] [286] 
.const [159] = Class [287] 
.const [160] = NameAndType [288] [289] 
.const [161] = Class [290] 
.const [162] = NameAndType [291] [292] 
.const [163] = Class [293] 
.const [164] = NameAndType [294] [295] 
.const [165] = Class [296] 
.const [166] = NameAndType [297] [298] 
.const [167] = Class [299] 
.const [168] = NameAndType [300] [301] 
.const [169] = Class [302] 
.const [170] = NameAndType [303] [304] 
.const [171] = Class [305] 
.const [172] = NameAndType [306] [307] 
.const [173] = Class [308] 
.const [174] = NameAndType [309] [310] 
.const [175] = Class [311] 
.const [176] = NameAndType [312] [313] 
.const [177] = Class [314] 
.const [178] = NameAndType [315] [316] 
.const [179] = Class [317] 
.const [180] = NameAndType [318] [319] 
.const [181] = Class [320] 
.const [182] = NameAndType [321] [322] 
.const [183] = Class [323] 
.const [184] = NameAndType [324] [325] 
.const [185] = Class [326] 
.const [186] = NameAndType [327] [328] 
.const [187] = Class [329] 
.const [188] = NameAndType [330] [331] 
.const [189] = Class [332] 
.const [190] = NameAndType [333] [334] 
.const [191] = Class [335] 
.const [192] = NameAndType [336] [337] 
.const [193] = Utf8 java/util/Hashtable 
.const [194] = Class [338] 
.const [195] = NameAndType [339] [340] 
.const [196] = Utf8 java/util/ArrayList 
.const [197] = Class [341] 
.const [198] = NameAndType [342] [343] 
.const [199] = Utf8 com/microdoc/j9/xip/Archive 
.const [200] = Class [344] 
.const [201] = NameAndType [345] [346] 
.const [202] = Utf8 java/lang/StringBuffer 
.const [203] = Utf8 java/lang/IllegalArgumentException 
.const [204] = Utf8 java/io/File 
.const [205] = Utf8 com/microdoc/j9/xip/JxeClassLoader 
.const [206] = Class [347] 
.const [207] = NameAndType [348] [349] 
.const [208] = Class [350] 
.const [209] = NameAndType [351] [352] 
.const [210] = Class [353] 
.const [211] = NameAndType [354] [355] 
.const [212] = Utf8 java/lang/System 
.const [213] = Utf8 loadLibrary 
.const [214] = Utf8 (Ljava/lang/String;)V 
.const [215] = Utf8 com/microdoc/j9/xip/XIPClassLoader 
.const [216] = Utf8 nativeinit 
.const [217] = Utf8 ()V 
.const [218] = Utf8 com/ibm/oti/vm/JxeUtil 
.const [219] = Utf8 romImageLoad 
.const [220] = Utf8 (Lcom/ibm/oti/vm/Jxe;Ljava/lang/ClassLoader;)V 
.const [221] = Utf8 com/microdoc/j9/xip/XIPClassLoader 
.const [222] = Utf8 unloadArchiveImpl 
.const [223] = Utf8 (Lcom/microdoc/j9/xip/Archive;)V 
.const [224] = Utf8 com/microdoc/j9/xip/XIPClassLoader 
.const [225] = Utf8 fJxesByName 
.const [226] = Utf8 Ljava/util/Hashtable; 
.const [227] = Utf8 com/microdoc/j9/xip/XIPClassLoader 
.const [228] = Utf8 fJxesList 
.const [229] = Utf8 Ljava/util/ArrayList; 
.const [230] = Utf8 com/microdoc/j9/xip/XIPClassLoader 
.const [231] = Utf8 fClasspath 
.const [232] = Utf8 [Lcom/microdoc/j9/xip/Archive; 
.const [233] = Utf8 java/net/URL 
.const [234] = Utf8 getProtocol 
.const [235] = Utf8 ()Ljava/lang/String; 
.const [236] = Utf8 java/lang/String 
.const [237] = Utf8 equals 
.const [238] = Utf8 (Ljava/lang/Object;)Z 
.const [239] = Utf8 java/net/URL 
.const [240] = Utf8 getFile 
.const [241] = Utf8 ()Ljava/lang/String; 
.const [242] = Utf8 java/net/URL 
.const [243] = Utf8 getHost 
.const [244] = Utf8 ()Ljava/lang/String; 
.const [245] = Utf8 java/lang/String 
.const [246] = Utf8 length 
.const [247] = Utf8 ()I 
.const [248] = Utf8 java/lang/StringBuffer 
.const [249] = Utf8 append 
.const [250] = Utf8 (Ljava/lang/String;)Ljava/lang/StringBuffer; 
.const [251] = Utf8 java/lang/StringBuffer 
.const [252] = Utf8 toString 
.const [253] = Utf8 ()Ljava/lang/String; 
.const [254] = Utf8 java/util/Hashtable 
.const [255] = Utf8 contains 
.const [256] = Utf8 (Ljava/lang/Object;)Z 
.const [257] = Utf8 com/microdoc/j9/xip/Archive 
.const [258] = Utf8 getFilename 
.const [259] = Utf8 ()Ljava/lang/String; 
.const [260] = Utf8 java/io/File 
.const [261] = Utf8 exists 
.const [262] = Utf8 ()Z 
.const [263] = Utf8 java/io/File 
.const [264] = Utf8 getAbsolutePath 
.const [265] = Utf8 ()Ljava/lang/String; 
.const [266] = Utf8 com/microdoc/j9/xip/JxeData 
.const [267] = Utf8 getJxe 
.const [268] = Utf8 ()Lcom/ibm/oti/vm/Jxe; 
.const [269] = Utf8 java/util/Hashtable 
.const [270] = Utf8 put 
.const [271] = Utf8 (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object; 
.const [272] = Utf8 java/util/ArrayList 
.const [273] = Utf8 add 
.const [274] = Utf8 (Ljava/lang/Object;)Z 
.const [275] = Utf8 java/lang/Exception 
.const [276] = Utf8 getMessage 
.const [277] = Utf8 ()Ljava/lang/String; 
.const [278] = Utf8 java/util/Hashtable 
.const [279] = Utf8 remove 
.const [280] = Utf8 (Ljava/lang/Object;)Ljava/lang/Object; 
.const [281] = Utf8 java/util/ArrayList 
.const [282] = Utf8 remove 
.const [283] = Utf8 (Ljava/lang/Object;)Z 
.const [284] = Utf8 com/microdoc/j9/xip/XIPClassLoader 
.const [285] = Utf8 loadClassFromJxe 
.const [286] = Utf8 (Ljava/lang/String;Lcom/microdoc/j9/xip/JxeClassLoader;)Ljava/lang/Class; 
.const [287] = Utf8 java/util/ArrayList 
.const [288] = Utf8 iterator 
.const [289] = Utf8 ()Ljava/util/Iterator; 
.const [290] = Utf8 com/microdoc/j9/xip/JxeClassLoader 
.const [291] = Utf8 loadClassFromJxe 
.const [292] = Utf8 (Ljava/lang/String;)Ljava/lang/Class; 
.const [293] = Utf8 java/util/Hashtable 
.const [294] = Utf8 keySet 
.const [295] = Utf8 ()Ljava/util/Set; 
.const [296] = Utf8 java/util/Hashtable 
.const [297] = Utf8 size 
.const [298] = Utf8 ()I 
.const [299] = Utf8 java/util/Hashtable 
.const [300] = Utf8 clear 
.const [301] = Utf8 ()V 
.const [302] = Utf8 java/lang/ClassLoader 
.const [303] = Utf8 <init> 
.const [304] = Utf8 ()V 
.const [305] = Utf8 java/util/Hashtable 
.const [306] = Utf8 <init> 
.const [307] = Utf8 ()V 
.const [308] = Utf8 java/util/ArrayList 
.const [309] = Utf8 <init> 
.const [310] = Utf8 ()V 
.const [311] = Utf8 java/lang/StringBuffer 
.const [312] = Utf8 <init> 
.const [313] = Utf8 (I)V 
.const [314] = Utf8 com/microdoc/j9/xip/Archive 
.const [315] = Utf8 <init> 
.const [316] = Utf8 (Ljava/lang/String;)V 
.const [317] = Utf8 java/lang/StringBuffer 
.const [318] = Utf8 <init> 
.const [319] = Utf8 (Ljava/lang/String;)V 
.const [320] = Utf8 java/lang/IllegalArgumentException 
.const [321] = Utf8 <init> 
.const [322] = Utf8 (Ljava/lang/String;)V 
.const [323] = Utf8 java/io/File 
.const [324] = Utf8 <init> 
.const [325] = Utf8 (Ljava/lang/String;)V 
.const [326] = Utf8 com/microdoc/j9/xip/XIPClassLoader 
.const [327] = Utf8 loadJXEimpl 
.const [328] = Utf8 (Ljava/lang/String;Lcom/microdoc/j9/xip/Archive;Ljava/lang/String;)Lcom/microdoc/j9/xip/JxeData; 
.const [329] = Utf8 com/microdoc/j9/xip/JxeClassLoader 
.const [330] = Utf8 <init> 
.const [331] = Utf8 (Lcom/microdoc/j9/xip/XIPClassLoader;Lcom/microdoc/j9/xip/Archive;Lcom/microdoc/j9/xip/JxeData;Ljava/lang/String;)V 
.const [332] = Utf8 com/microdoc/j9/xip/XIPClassLoader 
.const [333] = Utf8 freeJxeSegmentImpl 
.const [334] = Utf8 (Lcom/ibm/oti/vm/Jxe;)V 
.const [335] = Utf8 java/lang/ClassLoader 
.const [336] = Utf8 loadClass 
.const [337] = Utf8 (Ljava/lang/String;)Ljava/lang/Class; 
.const [338] = Utf8 com/microdoc/j9/xip/XIPClassLoader 
.const [339] = Utf8 fJxesByName 
.const [340] = Utf8 Ljava/util/Hashtable; 
.const [341] = Utf8 com/microdoc/j9/xip/XIPClassLoader 
.const [342] = Utf8 fJxesList 
.const [343] = Utf8 Ljava/util/ArrayList; 
.const [344] = Utf8 com/microdoc/j9/xip/XIPClassLoader 
.const [345] = Utf8 fClasspath 
.const [346] = Utf8 [Lcom/microdoc/j9/xip/Archive; 
.const [347] = Utf8 java/util/Iterator 
.const [348] = Utf8 next 
.const [349] = Utf8 ()Ljava/lang/Object; 
.const [350] = Utf8 java/util/Iterator 
.const [351] = Utf8 hasNext 
.const [352] = Utf8 ()Z 
.const [353] = Utf8 java/util/Set 
.const [354] = Utf8 toArray 
.const [355] = Utf8 ([Ljava/lang/Object;)[Ljava/lang/Object; 
.const [356] = Utf8 com/microdoc/j9/xip/XIPClassLoader 
.const [357] = Class [356] 
.const [358] = Utf8 java/lang/ClassLoader 
.const [359] = Class [358] 
.const [360] = Utf8 fClasspath 
.const [361] = Utf8 [Lcom/microdoc/j9/xip/Archive; 
.const [362] = Utf8 fJxesByName 
.const [363] = Utf8 Ljava/util/Hashtable; 
.const [364] = Utf8 fJxesList 
.const [365] = Utf8 Ljava/util/ArrayList; 
.const [366] = Utf8 Code 
.const [367] = Utf8 <clinit> 
.const [368] = Utf8 ()V 
.const [369] = Utf8 <init> 
.const [370] = Utf8 ([Ljava/net/URL;)V 
.const [371] = Utf8 nativeinit 
.const [372] = Utf8 ()V 
.const [373] = Utf8 loadJXE 
.const [374] = Utf8 (Ljava/lang/String;)V 
.const [375] = Utf8 loadJXEimpl 
.const [376] = Utf8 (Ljava/lang/String;Lcom/microdoc/j9/xip/Archive;Ljava/lang/String;)Lcom/microdoc/j9/xip/JxeData; 
.const [377] = Utf8 unloadJXE 
.const [378] = Utf8 (Ljava/lang/String;)V 
.const [379] = Utf8 unloadJXEDataimpl 
.const [380] = Utf8 (J)V 
.const [381] = Utf8 freeJxeSegment 
.const [382] = Utf8 (Lcom/ibm/oti/vm/Jxe;)V 
.const [383] = Utf8 freeJxeSegmentImpl 
.const [384] = Utf8 (Lcom/ibm/oti/vm/Jxe;)V 
.const [385] = Utf8 loadClass 
.const [386] = Utf8 (Ljava/lang/String;)Ljava/lang/Class; 
.const [387] = Utf8 loadClassFromJxe 
.const [388] = Utf8 (Ljava/lang/String;Lcom/microdoc/j9/xip/JxeClassLoader;)Ljava/lang/Class; 
.const [389] = Utf8 getLoadedJXEs 
.const [390] = Utf8 ()[Ljava/lang/String; 
.const [391] = Utf8 dispose 
.const [392] = Utf8 ()V 
.const [393] = Utf8 unloadArchive 
.const [394] = Utf8 (Lcom/microdoc/j9/xip/Archive;)V 
.const [395] = Utf8 unloadArchiveImpl 
.const [396] = Utf8 (Lcom/microdoc/j9/xip/Archive;)V 
.end class 
