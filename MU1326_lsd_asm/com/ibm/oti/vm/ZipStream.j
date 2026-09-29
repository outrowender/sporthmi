.version 50 0 
.class public super [255] 
.super [257] 
.field private [258] [259] 
.field private [260] [261] 
.field private [262] [263] 
.field private [264] [265] 
.field private [266] [267] 
.field private [268] [269] 
.field private static [270] [271] 
.field private static [272] [273] 
.field static synthetic [274] [275] 

.method static [277] : [278] 
    .attribute [276] .code stack 2 locals 0 
L0:     new [45] 
L3:     dup 
L4:     invokespecial [30] 
L7:     invokestatic [6] 
L10:    pop 
L11:    return 
L12:    
    .end code 
.end method 

.method [279] : [280] 
    .attribute [276] .code stack 4 locals 0 
L0:     aload_0 
L1:     invokespecial [31] 
L4:     aload_0 
L5:     lconst_0 
L6:     putfield [47] 
L9:     aload_0 
L10:    lload_1 
L11:    putfield [48] 
L14:    aload_0 
L15:    aload_0 
L16:    aload_0 
L17:    getfield [21] 
L20:    invokespecial [32] 
L23:    putfield [49] 
L26:    return 
L27:    nop 
L28:    
    .end code 
.end method 

.method public static [281] : [282] 
    .attribute [276] .code stack 4 locals 7 
        .catch [12] from L0 to L11 using L11 
L0:     getstatic [8] 
L3:     aload_0 
L4:     invokevirtual [23] 
L7:     astore_2 
L8:     goto L14 
L11:    pop 
L12:    aconst_null 
L13:    areturn 
L14:    aload_2 
L15:    dup 
L16:    astore_3 
L17:    monitorenter 
        .catch [0] from L18 to L42 using L66 
L18:    aload_0 
L19:    invokestatic [10] 
L22:    lstore 4 
L24:    lload 4 
L26:    aload_1 
L27:    invokestatic [11] 
L30:    lstore 6 
L32:    lload 6 
L34:    lconst_0 
L35:    lcmp 
L36:    ifne L43 
L39:    aconst_null 
L40:    aload_3 
L41:    monitorexit 
L42:    areturn 
        .catch [0] from L43 to L65 using L66 
L43:    new [44] 
L46:    dup 
L47:    lload 6 
L49:    invokespecial [34] 
L52:    astore 8 
L54:    aload 8 
L56:    aload_0 
L57:    aload_2 
L58:    invokespecial [35] 
L61:    aload 8 
L63:    aload_3 
L64:    monitorexit 
L65:    areturn 
        .catch [0] from L66 to L68 using L66 
L66:    aload_3 
L67:    monitorexit 
L68:    athrow 
L69:    nop 
L70:    nop 
L71:    nop 
L72:    
    .end code 
.end method 

.method private [283] : [284] 
    .attribute [276] .code stack 2 locals 0 
L0:     aload_0 
L1:     aload_2 
L2:     putfield [50] 
L5:     aload_0 
L6:     aload_1 
L7:     putfield [51] 
L10:    return 
L11:    nop 
L12:    
    .end code 
.end method 

.method private static [285] : [286] 
    .attribute [276] .code stack 4 locals 2 
L0:     ldc2_w [55] 
L3:     lstore_1 
        .catch [12] from L4 to L15 using L15 
L4:     getstatic [13] 
L7:     aload_0 
L8:     invokevirtual [26] 
L11:    lstore_1 
L12:    goto L16 
L15:    pop 
L16:    lload_1 
L17:    ldc2_w [55] 
L20:    lcmp 
L21:    ifne L37 
L24:    new [52] 
L27:    dup 
L28:    ldc [15] 
L30:    invokestatic [17] 
L33:    invokespecial [37] 
L36:    athrow 
L37:    lload_1 
L38:    freturn 
L39:    nop 
L40:    
    .end code 
.end method 

.method protected [287] : [288] 
    .attribute [276] .code stack 1 locals 0 
L0:     aload_0 
L1:     invokevirtual [27] 
L4:     return 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [289] : [290] 
    .attribute [276] .code stack 4 locals 1 
L0:     aload_0 
L1:     getfield [24] 
L4:     dup 
L5:     astore_1 
L6:     monitorenter 
        .catch [0] from L7 to L31 using L34 
L7:     aload_0 
L8:     getfield [21] 
L11:    lconst_0 
L12:    lcmp 
L13:    ifeq L29 
L16:    aload_0 
L17:    aload_0 
L18:    getfield [21] 
L21:    invokespecial [38] 
L24:    aload_0 
L25:    lconst_0 
L26:    putfield [48] 
L29:    aload_1 
L30:    monitorexit 
L31:    goto L37 
        .catch [0] from L34 to L36 using L34 
L34:    aload_1 
L35:    monitorexit 
L36:    athrow 
L37:    return 
L38:    nop 
L39:    nop 
L40:    
    .end code 
.end method 

.method public [291] : [292] 
    .attribute [276] .code stack 4 locals 0 
L0:     aload_0 
L1:     getfield [22] 
L4:     aload_0 
L5:     getfield [28] 
L8:     lsub 
L9:     l2i 
L10:    areturn 
L11:    nop 
L12:    
    .end code 
.end method 

.method public [293] : [294] 
    .attribute [276] .code stack 6 locals 3 
L0:     iload_2 
L1:     aload_1 
L2:     arraylength 
L3:     if_icmpgt L131 
L6:     iload_2 
L7:     iflt L131 
L10:    iload_3 
L11:    iflt L131 
L14:    iload_3 
L15:    aload_1 
L16:    arraylength 
L17:    iload_2 
L18:    isub 
L19:    if_icmpgt L131 
L22:    aload_0 
L23:    getfield [24] 
L26:    dup 
L27:    astore 4 
L29:    monitorenter 
        .catch [0] from L30 to L75 using L127 
L30:    aload_0 
L31:    getfield [25] 
L34:    invokestatic [10] 
L37:    pop2 
L38:    aload_0 
L39:    getfield [21] 
L42:    lconst_0 
L43:    lcmp 
L44:    ifne L60 
L47:    new [46] 
L50:    dup 
L51:    ldc [18] 
L53:    invokestatic [17] 
L56:    invokespecial [39] 
L59:    athrow 
L60:    aload_0 
L61:    getfield [28] 
L64:    aload_0 
L65:    getfield [22] 
L68:    lcmp 
L69:    ifne L77 
L72:    aload 4 
L74:    monitorexit 
L75:    iconst_m1 
L76:    areturn 
        .catch [0] from L77 to L126 using L127 
L77:    aload_0 
L78:    getfield [22] 
L81:    aload_0 
L82:    getfield [28] 
L85:    lsub 
L86:    lstore 5 
L88:    iload_3 
L89:    i2l 
L90:    lload 5 
L92:    lcmp 
L93:    ifle L100 
L96:    lload 5 
L98:    l2i 
L99:    istore_3 
L100:   aload_0 
L101:   aload_0 
L102:   getfield [21] 
L105:   aload_1 
L106:   iload_2 
L107:   iload_3 
L108:   invokespecial [40] 
L111:   aload_0 
L112:   dup 
L113:   getfield [28] 
L116:   iload_3 
L117:   i2l 
L118:   ladd 
L119:   putfield [53] 
L122:   iload_3 
L123:   aload 4 
L125:   monitorexit 
L126:   areturn 
        .catch [0] from L127 to L130 using L127 
L127:   aload 4 
L129:   monitorexit 
L130:   athrow 
L131:   new [54] 
L134:   dup 
L135:   invokespecial [41] 
L138:   athrow 
L139:   nop 
L140:   
    .end code 
.end method 

.method public [295] : [296] 
    .attribute [276] .code stack 4 locals 1 
L0:     iconst_1 
L1:     newarray byte 
L3:     astore_1 
L4:     aload_0 
L5:     aload_1 
L6:     iconst_0 
L7:     iconst_1 
L8:     invokevirtual [29] 
L11:    iconst_m1 
L12:    if_icmpne L17 
L15:    iconst_m1 
L16:    areturn 
L17:    aload_1 
L18:    iconst_0 
L19:    baload 
L20:    sipush 255 
L23:    iand 
L24:    areturn 
L25:    nop 
L26:    nop 
L27:    nop 
L28:    
    .end code 
.end method 

.method public [297] : [298] 
    .attribute [276] .code stack 1 locals 0 
L0:     iconst_1 
L1:     areturn 
L2:     nop 
L3:     nop 
L4:     
    .end code 
.end method 

.method public [299] : [300] 
    .attribute [276] .code stack 4 locals 1 
L0:     aload_0 
L1:     getfield [24] 
L4:     dup 
L5:     astore_2 
L6:     monitorenter 
        .catch [7] from L7 to L35 using L35 
        .catch [0] from L7 to L38 using L41 
L7:     aload_0 
L8:     getfield [21] 
L11:    lconst_0 
L12:    lcmp 
L13:    ifeq L24 
L16:    aload_0 
L17:    aload_0 
L18:    getfield [21] 
L21:    invokespecial [42] 
L24:    aload_0 
L25:    aload_0 
L26:    getfield [28] 
L29:    putfield [47] 
L32:    goto L36 
L35:    pop 
L36:    aload_2 
L37:    monitorexit 
L38:    goto L44 
        .catch [0] from L41 to L43 using L41 
L41:    aload_2 
L42:    monitorexit 
L43:    athrow 
L44:    return 
L45:    nop 
L46:    nop 
L47:    nop 
L48:    
    .end code 
.end method 

.method public [301] : [302] 
    .attribute [276] .code stack 4 locals 1 
L0:     aload_0 
L1:     getfield [24] 
L4:     dup 
L5:     astore_1 
L6:     monitorenter 
        .catch [0] from L7 to L55 using L58 
L7:     aload_0 
L8:     getfield [25] 
L11:    invokestatic [10] 
L14:    pop2 
L15:    aload_0 
L16:    getfield [21] 
L19:    lconst_0 
L20:    lcmp 
L21:    ifne L37 
L24:    new [46] 
L27:    dup 
L28:    ldc [18] 
L30:    invokestatic [17] 
L33:    invokespecial [39] 
L36:    athrow 
L37:    aload_0 
L38:    aload_0 
L39:    getfield [21] 
L42:    invokespecial [43] 
L45:    aload_0 
L46:    aload_0 
L47:    getfield [20] 
L50:    putfield [53] 
L53:    aload_1 
L54:    monitorexit 
L55:    goto L61 
        .catch [0] from L58 to L60 using L58 
L58:    aload_1 
L59:    monitorexit 
L60:    athrow 
L61:    return 
L62:    nop 
L63:    nop 
L64:    
    .end code 
.end method 

.method private static native [303] : [304] 
    .attribute [276] .code stack 0 locals 0 
L0:     
    .end code 
.end method 

.method private native [305] : [306] 
    .attribute [276] .code stack 0 locals 0 
L0:     
    .end code 
.end method 

.method private native [307] : [308] 
    .attribute [276] .code stack 0 locals 0 
L0:     
    .end code 
.end method 

.method private native [309] : [310] 
    .attribute [276] .code stack 0 locals 0 
L0:     
    .end code 
.end method 

.method private native [311] : [312] 
    .attribute [276] .code stack 0 locals 0 
L0:     
    .end code 
.end method 

.method private native [313] : [314] 
    .attribute [276] .code stack 0 locals 0 
L0:     
    .end code 
.end method 

.method static synthetic [315] : [316] 
    .attribute [276] .code stack 1 locals 0 
L0:     aload_0 
L1:     putstatic [36] 
L4:     return 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method static synthetic [317] : [318] 
    .attribute [276] .code stack 1 locals 0 
L0:     getstatic [13] 
L3:     areturn 
L4:     
    .end code 
.end method 

.method static synthetic [319] : [320] 
    .attribute [276] .code stack 1 locals 0 
L0:     aload_0 
L1:     putstatic [33] 
L4:     return 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method static synthetic [321] : [322] 
    .attribute [276] .code stack 1 locals 0 
L0:     getstatic [8] 
L3:     areturn 
L4:     
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [57] 
.const [3] = Class [58] 
.const [4] = Class [59] 
.const [5] = Class [60] 
.const [6] = Method [61] [62] 
.const [7] = Class [63] 
.const [8] = Field [64] [65] 
.const [9] = Class [66] 
.const [10] = Method [67] [68] 
.const [11] = Method [69] [70] 
.const [12] = Class [71] 
.const [13] = Field [72] [73] 
.const [14] = Class [74] 
.const [15] = String [75] 
.const [16] = Class [76] 
.const [17] = Method [77] [78] 
.const [18] = String [79] 
.const [19] = Class [80] 
.const [20] = Field [81] [82] 
.const [21] = Field [83] [84] 
.const [22] = Field [85] [86] 
.const [23] = Method [87] [88] 
.const [24] = Field [89] [90] 
.const [25] = Field [91] [92] 
.const [26] = Method [93] [94] 
.const [27] = Method [95] [96] 
.const [28] = Field [97] [98] 
.const [29] = Method [99] [100] 
.const [30] = Method [101] [102] 
.const [31] = Method [103] [104] 
.const [32] = Method [105] [106] 
.const [33] = Field [107] [108] 
.const [34] = Method [109] [110] 
.const [35] = Method [111] [112] 
.const [36] = Field [113] [114] 
.const [37] = Method [115] [116] 
.const [38] = Method [117] [118] 
.const [39] = Method [119] [120] 
.const [40] = Method [121] [122] 
.const [41] = Method [123] [124] 
.const [42] = Method [125] [126] 
.const [43] = Method [127] [128] 
.const [44] = Class [129] 
.const [45] = Class [130] 
.const [46] = Class [131] 
.const [47] = Field [132] [133] 
.const [48] = Field [134] [135] 
.const [49] = Field [136] [137] 
.const [50] = Field [138] [139] 
.const [51] = Field [140] [141] 
.const [52] = Class [142] 
.const [53] = Field [143] [144] 
.const [54] = Class [145] 
.const [55] = Long -1L 
.const [57] = Utf8 com/ibm/oti/vm/ZipStream 
.const [58] = Utf8 java/io/InputStream 
.const [59] = Utf8 com/ibm/oti/vm/ZipStream$1 
.const [60] = Utf8 java/security/AccessController 
.const [61] = Class [146] 
.const [62] = NameAndType [147] [148] 
.const [63] = Utf8 java/io/IOException 
.const [64] = Class [149] 
.const [65] = NameAndType [150] [151] 
.const [66] = Utf8 java/lang/reflect/Field 
.const [67] = Class [152] 
.const [68] = NameAndType [153] [154] 
.const [69] = Class [155] 
.const [70] = NameAndType [156] [157] 
.const [71] = Utf8 java/lang/IllegalAccessException 
.const [72] = Class [158] 
.const [73] = NameAndType [159] [160] 
.const [74] = Utf8 java/lang/IllegalStateException 
.const [75] = Utf8 K00b7 
.const [76] = Utf8 com/ibm/oti/util/Msg 
.const [77] = Class [161] 
.const [78] = NameAndType [162] [163] 
.const [79] = Utf8 K0059 
.const [80] = Utf8 java/lang/ArrayIndexOutOfBoundsException 
.const [81] = Class [164] 
.const [82] = NameAndType [165] [166] 
.const [83] = Class [167] 
.const [84] = NameAndType [168] [169] 
.const [85] = Class [170] 
.const [86] = NameAndType [171] [172] 
.const [87] = Class [173] 
.const [88] = NameAndType [174] [175] 
.const [89] = Class [176] 
.const [90] = NameAndType [177] [178] 
.const [91] = Class [179] 
.const [92] = NameAndType [180] [181] 
.const [93] = Class [182] 
.const [94] = NameAndType [183] [184] 
.const [95] = Class [185] 
.const [96] = NameAndType [186] [187] 
.const [97] = Class [188] 
.const [98] = NameAndType [189] [190] 
.const [99] = Class [191] 
.const [100] = NameAndType [192] [193] 
.const [101] = Class [194] 
.const [102] = NameAndType [195] [196] 
.const [103] = Class [197] 
.const [104] = NameAndType [198] [199] 
.const [105] = Class [200] 
.const [106] = NameAndType [201] [202] 
.const [107] = Class [203] 
.const [108] = NameAndType [204] [205] 
.const [109] = Class [206] 
.const [110] = NameAndType [207] [208] 
.const [111] = Class [209] 
.const [112] = NameAndType [210] [211] 
.const [113] = Class [212] 
.const [114] = NameAndType [213] [214] 
.const [115] = Class [215] 
.const [116] = NameAndType [216] [217] 
.const [117] = Class [218] 
.const [118] = NameAndType [219] [220] 
.const [119] = Class [221] 
.const [120] = NameAndType [222] [223] 
.const [121] = Class [224] 
.const [122] = NameAndType [225] [226] 
.const [123] = Class [227] 
.const [124] = NameAndType [228] [229] 
.const [125] = Class [230] 
.const [126] = NameAndType [231] [232] 
.const [127] = Class [233] 
.const [128] = NameAndType [234] [235] 
.const [129] = Utf8 com/ibm/oti/vm/ZipStream 
.const [130] = Utf8 com/ibm/oti/vm/ZipStream$1 
.const [131] = Utf8 java/io/IOException 
.const [132] = Class [236] 
.const [133] = NameAndType [237] [238] 
.const [134] = Class [239] 
.const [135] = NameAndType [240] [241] 
.const [136] = Class [242] 
.const [137] = NameAndType [243] [244] 
.const [138] = Class [245] 
.const [139] = NameAndType [246] [247] 
.const [140] = Class [248] 
.const [141] = NameAndType [249] [250] 
.const [142] = Utf8 java/lang/IllegalStateException 
.const [143] = Class [251] 
.const [144] = NameAndType [252] [253] 
.const [145] = Utf8 java/lang/ArrayIndexOutOfBoundsException 
.const [146] = Utf8 java/security/AccessController 
.const [147] = Utf8 doPrivileged 
.const [148] = Utf8 (Ljava/security/PrivilegedAction;)Ljava/lang/Object; 
.const [149] = Utf8 com/ibm/oti/vm/ZipStream 
.const [150] = Utf8 lockField 
.const [151] = Utf8 Ljava/lang/reflect/Field; 
.const [152] = Utf8 com/ibm/oti/vm/ZipStream 
.const [153] = Utf8 checkDescriptor 
.const [154] = Utf8 (Ljava/util/zip/ZipFile;)J 
.const [155] = Utf8 com/ibm/oti/vm/ZipStream 
.const [156] = Utf8 openZipFileImpl 
.const [157] = Utf8 (JLjava/lang/String;)J 
.const [158] = Utf8 com/ibm/oti/vm/ZipStream 
.const [159] = Utf8 descriptorField 
.const [160] = Utf8 Ljava/lang/reflect/Field; 
.const [161] = Utf8 com/ibm/oti/util/Msg 
.const [162] = Utf8 getString 
.const [163] = Utf8 (Ljava/lang/String;)Ljava/lang/String; 
.const [164] = Utf8 com/ibm/oti/vm/ZipStream 
.const [165] = Utf8 markPos 
.const [166] = Utf8 J 
.const [167] = Utf8 com/ibm/oti/vm/ZipStream 
.const [168] = Utf8 streamHandle 
.const [169] = Utf8 J 
.const [170] = Utf8 com/ibm/oti/vm/ZipStream 
.const [171] = Utf8 uncompressedSize 
.const [172] = Utf8 J 
.const [173] = Utf8 java/lang/reflect/Field 
.const [174] = Utf8 get 
.const [175] = Utf8 (Ljava/lang/Object;)Ljava/lang/Object; 
.const [176] = Utf8 com/ibm/oti/vm/ZipStream 
.const [177] = Utf8 lock 
.const [178] = Utf8 Ljava/lang/Object; 
.const [179] = Utf8 com/ibm/oti/vm/ZipStream 
.const [180] = Utf8 zipFile 
.const [181] = Utf8 Ljava/util/zip/ZipFile; 
.const [182] = Utf8 java/lang/reflect/Field 
.const [183] = Utf8 getLong 
.const [184] = Utf8 (Ljava/lang/Object;)J 
.const [185] = Utf8 com/ibm/oti/vm/ZipStream 
.const [186] = Utf8 close 
.const [187] = Utf8 ()V 
.const [188] = Utf8 com/ibm/oti/vm/ZipStream 
.const [189] = Utf8 pos 
.const [190] = Utf8 J 
.const [191] = Utf8 com/ibm/oti/vm/ZipStream 
.const [192] = Utf8 read 
.const [193] = Utf8 ([BII)I 
.const [194] = Utf8 com/ibm/oti/vm/ZipStream$1 
.const [195] = Utf8 <init> 
.const [196] = Utf8 ()V 
.const [197] = Utf8 java/io/InputStream 
.const [198] = Utf8 <init> 
.const [199] = Utf8 ()V 
.const [200] = Utf8 com/ibm/oti/vm/ZipStream 
.const [201] = Utf8 streamSizeImpl 
.const [202] = Utf8 (J)J 
.const [203] = Utf8 com/ibm/oti/vm/ZipStream 
.const [204] = Utf8 lockField 
.const [205] = Utf8 Ljava/lang/reflect/Field; 
.const [206] = Utf8 com/ibm/oti/vm/ZipStream 
.const [207] = Utf8 <init> 
.const [208] = Utf8 (J)V 
.const [209] = Utf8 com/ibm/oti/vm/ZipStream 
.const [210] = Utf8 setInternals 
.const [211] = Utf8 (Ljava/util/zip/ZipFile;Ljava/lang/Object;)V 
.const [212] = Utf8 com/ibm/oti/vm/ZipStream 
.const [213] = Utf8 descriptorField 
.const [214] = Utf8 Ljava/lang/reflect/Field; 
.const [215] = Utf8 java/lang/IllegalStateException 
.const [216] = Utf8 <init> 
.const [217] = Utf8 (Ljava/lang/String;)V 
.const [218] = Utf8 com/ibm/oti/vm/ZipStream 
.const [219] = Utf8 closeStreamImpl 
.const [220] = Utf8 (J)V 
.const [221] = Utf8 java/io/IOException 
.const [222] = Utf8 <init> 
.const [223] = Utf8 (Ljava/lang/String;)V 
.const [224] = Utf8 com/ibm/oti/vm/ZipStream 
.const [225] = Utf8 readStreamImpl 
.const [226] = Utf8 (J[BII)V 
.const [227] = Utf8 java/lang/ArrayIndexOutOfBoundsException 
.const [228] = Utf8 <init> 
.const [229] = Utf8 ()V 
.const [230] = Utf8 com/ibm/oti/vm/ZipStream 
.const [231] = Utf8 markStreamImpl 
.const [232] = Utf8 (J)V 
.const [233] = Utf8 com/ibm/oti/vm/ZipStream 
.const [234] = Utf8 resetStreamImpl 
.const [235] = Utf8 (J)V 
.const [236] = Utf8 com/ibm/oti/vm/ZipStream 
.const [237] = Utf8 markPos 
.const [238] = Utf8 J 
.const [239] = Utf8 com/ibm/oti/vm/ZipStream 
.const [240] = Utf8 streamHandle 
.const [241] = Utf8 J 
.const [242] = Utf8 com/ibm/oti/vm/ZipStream 
.const [243] = Utf8 uncompressedSize 
.const [244] = Utf8 J 
.const [245] = Utf8 com/ibm/oti/vm/ZipStream 
.const [246] = Utf8 lock 
.const [247] = Utf8 Ljava/lang/Object; 
.const [248] = Utf8 com/ibm/oti/vm/ZipStream 
.const [249] = Utf8 zipFile 
.const [250] = Utf8 Ljava/util/zip/ZipFile; 
.const [251] = Utf8 com/ibm/oti/vm/ZipStream 
.const [252] = Utf8 pos 
.const [253] = Utf8 J 
.const [254] = Utf8 com/ibm/oti/vm/ZipStream 
.const [255] = Class [254] 
.const [256] = Utf8 java/io/InputStream 
.const [257] = Class [256] 
.const [258] = Utf8 streamHandle 
.const [259] = Utf8 J 
.const [260] = Utf8 uncompressedSize 
.const [261] = Utf8 J 
.const [262] = Utf8 pos 
.const [263] = Utf8 J 
.const [264] = Utf8 markPos 
.const [265] = Utf8 J 
.const [266] = Utf8 lock 
.const [267] = Utf8 Ljava/lang/Object; 
.const [268] = Utf8 zipFile 
.const [269] = Utf8 Ljava/util/zip/ZipFile; 
.const [270] = Utf8 descriptorField 
.const [271] = Utf8 Ljava/lang/reflect/Field; 
.const [272] = Utf8 lockField 
.const [273] = Utf8 Ljava/lang/reflect/Field; 
.const [274] = Utf8 class$0 
.const [275] = Utf8 Ljava/lang/Class; 
.const [276] = Utf8 Code 
.const [277] = Utf8 <clinit> 
.const [278] = Utf8 ()V 
.const [279] = Utf8 <init> 
.const [280] = Utf8 (J)V 
.const [281] = Utf8 getZipStream 
.const [282] = Utf8 (Ljava/util/zip/ZipFile;Ljava/lang/String;)Ljava/io/InputStream; 
.const [283] = Utf8 setInternals 
.const [284] = Utf8 (Ljava/util/zip/ZipFile;Ljava/lang/Object;)V 
.const [285] = Utf8 checkDescriptor 
.const [286] = Utf8 (Ljava/util/zip/ZipFile;)J 
.const [287] = Utf8 finalize 
.const [288] = Utf8 ()V 
.const [289] = Utf8 close 
.const [290] = Utf8 ()V 
.const [291] = Utf8 available 
.const [292] = Utf8 ()I 
.const [293] = Utf8 read 
.const [294] = Utf8 ([BII)I 
.const [295] = Utf8 read 
.const [296] = Utf8 ()I 
.const [297] = Utf8 markSupported 
.const [298] = Utf8 ()Z 
.const [299] = Utf8 mark 
.const [300] = Utf8 (I)V 
.const [301] = Utf8 reset 
.const [302] = Utf8 ()V 
.const [303] = Utf8 openZipFileImpl 
.const [304] = Utf8 (JLjava/lang/String;)J 
.const [305] = Utf8 streamSizeImpl 
.const [306] = Utf8 (J)J 
.const [307] = Utf8 readStreamImpl 
.const [308] = Utf8 (J[BII)V 
.const [309] = Utf8 markStreamImpl 
.const [310] = Utf8 (J)V 
.const [311] = Utf8 resetStreamImpl 
.const [312] = Utf8 (J)V 
.const [313] = Utf8 closeStreamImpl 
.const [314] = Utf8 (J)V 
.const [315] = Utf8 access$0 
.const [316] = Utf8 (Ljava/lang/reflect/Field;)V 
.const [317] = Utf8 access$1 
.const [318] = Utf8 ()Ljava/lang/reflect/Field; 
.const [319] = Utf8 access$2 
.const [320] = Utf8 (Ljava/lang/reflect/Field;)V 
.const [321] = Utf8 access$3 
.const [322] = Utf8 ()Ljava/lang/reflect/Field; 
.end class 
