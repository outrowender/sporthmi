.version 50 0 
.class public final super [405] 
.super [407] 
.field [408] [409] 
.field private [410] [411] 
.field private [412] [413] 
.field private [414] [415] 
.field private [416] [417] 
.field static final [418] [419] 
.field static final [420] [421] 

.method public static [423] : [424] 
    .attribute [422] .code stack 5 locals 7 
L0:     iload_1 
L1:     bipush 7 
L3:     iadd 
L4:     invokestatic [6] 
L7:     lstore_2 
L8:     lconst_0 
L9:     lload_2 
L10:    lcmp 
L11:    ifne L31 
L14:    new [82] 
L17:    dup 
L18:    ldc [8] 
L20:    iload_1 
L21:    bipush 7 
L23:    iadd 
L24:    invokestatic [10] 
L27:    invokespecial [64] 
L30:    athrow 
L31:    lload_2 
L32:    ldc_w [1] 
L35:    land 
L36:    l2i 
L37:    istore 4 
L39:    iload 4 
L41:    ifne L48 
L44:    lload_2 
L45:    goto L56 
L48:    lload_2 
L49:    bipush 8 
L51:    iload 4 
L53:    isub 
L54:    i2l 
L55:    ladd 
L56:    lstore 5 
        .catch [5] from L58 to L68 using L68 
L58:    aload_0 
L59:    iload_1 
L60:    lload 5 
L62:    invokestatic [11] 
L65:    goto L77 
L68:    astore 7 
L70:    lload_2 
L71:    invokestatic [12] 
L74:    aload 7 
L76:    athrow 
        .catch [4] from L77 to L113 using L113 
L77:    new [79] 
L80:    dup 
L81:    lload_2 
L82:    iconst_1 
L83:    invokespecial [65] 
L86:    astore 7 
L88:    aload 7 
L90:    invokevirtual [43] 
L93:    astore 8 
L95:    lload 5 
L97:    invokestatic [14] 
L100:   aload 7 
L102:   aload 8 
L104:   invokevirtual [44] 
L107:   putfield [84] 
L110:   goto L122 
L113:   astore 8 
L115:   lload_2 
L116:   invokestatic [12] 
L119:   aload 8 
L121:   athrow 
L122:   aload 7 
L124:   invokestatic [16] 
L127:   pop 
L128:   aload 7 
L130:   areturn 
L131:   nop 
L132:   
    .end code 
.end method 

.method static [425] : [426] 
    .attribute [422] .code stack 5 locals 4 
L0:     iload_1 
L1:     sipush 4096 
L4:     if_icmpge L11 
L7:     iload_1 
L8:     goto L14 
L11:    sipush 4096 
L14:    newarray byte 
L16:    astore 4 
L18:    iconst_0 
L19:    istore 5 
L21:    goto L96 
L24:    iload_1 
L25:    iload 5 
L27:    isub 
L28:    istore 6 
L30:    aload_0 
L31:    aload 4 
L33:    iconst_0 
L34:    iload 6 
L36:    aload 4 
L38:    arraylength 
L39:    if_icmpgt L47 
L42:    iload 6 
L44:    goto L50 
L47:    aload 4 
L49:    arraylength 
L50:    invokevirtual [46] 
L53:    istore 7 
L55:    iconst_m1 
L56:    iload 7 
L58:    if_icmpne L76 
L61:    new [81] 
L64:    dup 
L65:    ldc [18] 
L67:    iload 5 
L69:    invokestatic [10] 
L72:    invokespecial [66] 
L75:    athrow 
L76:    lload_2 
L77:    iload 5 
L79:    i2l 
L80:    ladd 
L81:    aload 4 
L83:    iconst_0 
L84:    iload 7 
L86:    invokestatic [19] 
L89:    iload 5 
L91:    iload 7 
L93:    iadd 
L94:    istore 5 
L96:    iload 5 
L98:    iload_1 
L99:    if_icmplt L24 
L102:   return 
L103:   nop 
L104:   
    .end code 
.end method 

.method public static [427] : [428] 
    .attribute [422] .code stack 5 locals 5 
L0:     aload_0 
L1:     invokevirtual [47] 
L4:     ifne L19 
L7:     new [85] 
L10:    dup 
L11:    aload_0 
L12:    invokevirtual [48] 
L15:    invokespecial [67] 
L18:    athrow 
L19:    aload_0 
L20:    invokevirtual [48] 
L23:    invokestatic [23] 
L26:    astore_2 
L27:    aload_2 
L28:    invokestatic [24] 
L31:    lstore_3 
L32:    lload_3 
L33:    lconst_0 
L34:    lcmp 
L35:    ifne L55 
L38:    new [80] 
L41:    dup 
L42:    ldc [25] 
L44:    aload_0 
L45:    invokevirtual [48] 
L48:    invokestatic [26] 
L51:    invokespecial [68] 
L54:    athrow 
L55:    new [79] 
L58:    dup 
L59:    lload_3 
L60:    iconst_0 
L61:    invokespecial [65] 
L64:    astore_1 
L65:    aload_1 
L66:    invokevirtual [43] 
L69:    astore 5 
L71:    aload_1 
L72:    aload 5 
L74:    invokevirtual [44] 
L77:    putfield [84] 
L80:    aload_1 
L81:    areturn 
L82:    nop 
L83:    nop 
L84:    
    .end code 
.end method 

.method public static [429] : [430] 
    .attribute [422] .code stack 5 locals 4 
L0:     aload_0 
L1:     invokestatic [23] 
L4:     invokestatic [27] 
L7:     lstore_1 
L8:     lload_1 
L9:     lconst_0 
L10:    lcmp 
L11:    ifne L28 
L14:    new [80] 
L17:    dup 
L18:    ldc [25] 
L20:    aload_0 
L21:    invokestatic [26] 
L24:    invokespecial [68] 
L27:    athrow 
L28:    new [79] 
L31:    dup 
L32:    lload_1 
L33:    iconst_0 
L34:    invokespecial [65] 
L37:    astore_3 
L38:    aload_3 
L39:    invokevirtual [43] 
L42:    astore 4 
L44:    aload_3 
L45:    aload 4 
L47:    invokevirtual [44] 
L50:    putfield [84] 
L53:    aload_3 
L54:    areturn 
L55:    nop 
L56:    
    .end code 
.end method 

.method [431] : [432] 
    .attribute [422] .code stack 3 locals 0 
L0:     aload_0 
L1:     invokespecial [69] 
L4:     aload_0 
L5:     lload_1 
L6:     putfield [86] 
L9:     aload_0 
L10:    iload_3 
L11:    putfield [87] 
L14:    return 
L15:    nop 
L16:    
    .end code 
.end method 

.method public static [433] : [434] 
    .attribute [422] .code stack 5 locals 0 
L0:     lload_0 
L1:     invokestatic [14] 
L4:     new [79] 
L7:     dup 
L8:     lload_0 
L9:     iconst_0 
L10:    invokespecial [65] 
L13:    areturn 
L14:    nop 
L15:    nop 
L16:    
    .end code 
.end method 

.method [435] : [436] 
    .attribute [422] .code stack 4 locals 1 
L0:     aload_0 
L1:     getfield [50] 
L4:     ifeq L32 
L7:     aload_0 
L8:     getfield [49] 
L11:    ldc_w [1] 
L14:    land 
L15:    l2i 
L16:    istore_1 
L17:    iload_1 
L18:    ifeq L32 
L21:    aload_0 
L22:    getfield [49] 
L25:    bipush 8 
L27:    iload_1 
L28:    isub 
L29:    i2l 
L30:    ladd 
L31:    freturn 
L32:    aload_0 
L33:    getfield [49] 
L36:    freturn 
L37:    nop 
L38:    nop 
L39:    nop 
L40:    
    .end code 
.end method 

.method [437] : [438] 
    .attribute [422] .code stack 2 locals 0 
L0:     aload_0 
L1:     getfield [50] 
L4:     ifeq L14 
L7:     aload_0 
L8:     getfield [49] 
L11:    goto L15 
L14:    lconst_0 
L15:    freturn 
L16:    
    .end code 
.end method 

.method public [439] : [440] 
    .attribute [422] .code stack 3 locals 0 
L0:     new [83] 
L3:     dup 
L4:     aload_0 
L5:     invokespecial [70] 
L8:     areturn 
L9:     nop 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method public [441] : [442] 
    .attribute [422] .code stack 2 locals 0 
L0:     aload_0 
L1:     getfield [49] 
L4:     invokestatic [28] 
L7:     areturn 
L8:     
    .end code 
.end method 

.method public [443] : [444] 
    .attribute [422] .code stack 4 locals 1 
L0:     invokestatic [30] 
L3:     astore_2 
L4:     aload_2 
L5:     ifnull L23 
L8:     aload_2 
L9:     new [88] 
L12:    dup 
L13:    aload_0 
L14:    invokevirtual [51] 
L17:    invokespecial [71] 
L20:    invokevirtual [52] 
L23:    aload_0 
L24:    aload_1 
L25:    invokevirtual [53] 
L28:    areturn 
L29:    nop 
L30:    nop 
L31:    nop 
L32:    
    .end code 
.end method 

.method [445] : [446] 
    .attribute [422] .code stack 6 locals 2 
L0:     aload_0 
L1:     getfield [49] 
L4:     lconst_0 
L5:     lcmp 
L6:     ifne L11 
L9:     aconst_null 
L10:    areturn 
L11:    aload_0 
L12:    invokespecial [72] 
L15:    aload_0 
L16:    getfield [54] 
L19:    aload_1 
L20:    invokevirtual [55] 
L23:    checkcast [34] 
L26:    astore_2 
L27:    aload_2 
L28:    ifnull L74 
L31:    new [91] 
L34:    dup 
L35:    aload_2 
L36:    invokevirtual [56] 
L39:    aload_2 
L40:    invokevirtual [57] 
L43:    aload_0 
L44:    invokespecial [73] 
L47:    astore_3 
L48:    aload_2 
L49:    invokevirtual [58] 
L52:    ifeq L72 
L55:    new [92] 
L58:    dup 
L59:    aload_3 
L60:    new [93] 
L63:    dup 
L64:    iconst_1 
L65:    invokespecial [74] 
L68:    invokespecial [75] 
L71:    areturn 
L72:    aload_3 
L73:    areturn 
L74:    aload_1 
L75:    ldc [38] 
L77:    iconst_0 
L78:    invokevirtual [59] 
L81:    ifne L86 
L84:    aconst_null 
L85:    areturn 
L86:    aload_1 
L87:    iconst_1 
L88:    invokevirtual [60] 
L91:    astore_1 
L92:    goto L15 
L95:    nop 
L96:    
    .end code 
.end method 

.method public [447] : [448] 
    .attribute [422] .code stack 2 locals 0 
L0:     aload_0 
L1:     getfield [45] 
L4:     ifnonnull L18 
L7:     aload_0 
L8:     aload_0 
L9:     invokevirtual [43] 
L12:    invokevirtual [44] 
L15:    putfield [84] 
L18:    aload_0 
L19:    getfield [45] 
L22:    areturn 
L23:    nop 
L24:    
    .end code 
.end method 

.method private [449] : [450] 
    .attribute [422] .code stack 4 locals 0 
L0:     aload_0 
L1:     getfield [50] 
L4:     ifeq L37 
L7:     aload_0 
L8:     getfield [49] 
L11:    lconst_0 
L12:    lcmp 
L13:    ifeq L37 
L16:    aload_0 
L17:    getfield [61] 
L20:    lconst_0 
L21:    lcmp 
L22:    ifne L37 
L25:    aload_0 
L26:    getfield [49] 
L29:    invokestatic [12] 
L32:    aload_0 
L33:    lconst_0 
L34:    putfield [86] 
L37:    return 
L38:    nop 
L39:    nop 
L40:    
    .end code 
.end method 

.method public [451] : [452] 
    .attribute [422] .code stack 1 locals 0 
L0:     aload_0 
L1:     invokestatic [40] 
L4:     ifne L11 
L7:     aload_0 
L8:     invokespecial [76] 
L11:    return 
L12:    
    .end code 
.end method 

.method private [453] : [454] 
    .attribute [422] .code stack 8 locals 1 
L0:     aload_0 
L1:     getfield [54] 
L4:     ifnull L8 
L7:     return 
        .catch [5] from L8 to L34 using L34 
L8:     new [94] 
L11:    dup 
L12:    new [91] 
L15:    dup 
L16:    aload_0 
L17:    invokevirtual [62] 
L20:    ldc_w [42] 
L23:    aconst_null 
L24:    invokespecial [73] 
L27:    invokespecial [77] 
L30:    astore_1 
L31:    goto L48 
L34:    pop 
L35:    aload_0 
L36:    new [90] 
L39:    dup 
L40:    iconst_0 
L41:    invokespecial [78] 
L44:    putfield [89] 
L47:    return 
L48:    aload_0 
L49:    aload_1 
L50:    invokevirtual [63] 
L53:    putfield [89] 
L56:    return 
L57:    nop 
L58:    nop 
L59:    nop 
L60:    
    .end code 
.end method 

.method private static native [455] : [456] 
    .attribute [422] .code stack 0 locals 0 
L0:     
    .end code 
.end method 

.method private static native [457] : [458] 
    .attribute [422] .code stack 0 locals 0 
L0:     
    .end code 
.end method 

.method private static native [459] : [460] 
    .attribute [422] .code stack 0 locals 0 
L0:     
    .end code 
.end method 

.method private static native [461] : [462] 
    .attribute [422] .code stack 0 locals 0 
L0:     
    .end code 
.end method 

.method private static native [463] : [464] 
    .attribute [422] .code stack 0 locals 0 
L0:     
    .end code 
.end method 

.method private static native [465] : [466] 
    .attribute [422] .code stack 0 locals 0 
L0:     
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [96] 
.const [3] = Class [97] 
.const [4] = Class [98] 
.const [5] = Class [99] 
.const [6] = Method [100] [101] 
.const [7] = Class [102] 
.const [8] = String [103] 
.const [9] = Class [104] 
.const [10] = Method [105] [106] 
.const [11] = Method [107] [108] 
.const [12] = Method [109] [110] 
.const [13] = Class [111] 
.const [14] = Method [112] [113] 
.const [15] = Class [114] 
.const [16] = Method [115] [116] 
.const [17] = Class [117] 
.const [18] = String [118] 
.const [19] = Method [119] [120] 
.const [20] = Class [121] 
.const [21] = Class [122] 
.const [22] = Class [123] 
.const [23] = Method [124] [125] 
.const [24] = Method [126] [127] 
.const [25] = String [128] 
.const [26] = Method [129] [130] 
.const [27] = Method [131] [132] 
.const [28] = Method [133] [134] 
.const [29] = Class [135] 
.const [30] = Method [136] [137] 
.const [31] = Class [138] 
.const [32] = Class [139] 
.const [33] = Class [140] 
.const [34] = Class [141] 
.const [35] = Class [142] 
.const [36] = Class [143] 
.const [37] = Class [144] 
.const [38] = String [145] 
.const [39] = Class [146] 
.const [40] = Method [147] [148] 
.const [41] = Class [149] 
.const [42] = Int -129 
.const [43] = Method [150] [151] 
.const [44] = Method [152] [153] 
.const [45] = Field [154] [155] 
.const [46] = Method [156] [157] 
.const [47] = Method [158] [159] 
.const [48] = Method [160] [161] 
.const [49] = Field [162] [163] 
.const [50] = Field [164] [165] 
.const [51] = Method [166] [167] 
.const [52] = Method [168] [169] 
.const [53] = Method [170] [171] 
.const [54] = Field [172] [173] 
.const [55] = Method [174] [175] 
.const [56] = Method [176] [177] 
.const [57] = Method [178] [179] 
.const [58] = Method [180] [181] 
.const [59] = Method [182] [183] 
.const [60] = Method [184] [185] 
.const [61] = Field [186] [187] 
.const [62] = Method [188] [189] 
.const [63] = Method [190] [191] 
.const [64] = Method [192] [193] 
.const [65] = Method [194] [195] 
.const [66] = Method [196] [197] 
.const [67] = Method [198] [199] 
.const [68] = Method [200] [201] 
.const [69] = Method [202] [203] 
.const [70] = Method [204] [205] 
.const [71] = Method [206] [207] 
.const [72] = Method [208] [209] 
.const [73] = Method [210] [211] 
.const [74] = Method [212] [213] 
.const [75] = Method [214] [215] 
.const [76] = Method [216] [217] 
.const [77] = Method [218] [219] 
.const [78] = Method [220] [221] 
.const [79] = Class [222] 
.const [80] = Class [223] 
.const [81] = Class [224] 
.const [82] = Class [225] 
.const [83] = Class [226] 
.const [84] = Field [227] [228] 
.const [85] = Class [229] 
.const [86] = Field [230] [231] 
.const [87] = Field [232] [233] 
.const [88] = Class [234] 
.const [89] = Field [235] [236] 
.const [90] = Class [237] 
.const [91] = Class [238] 
.const [92] = Class [239] 
.const [93] = Class [240] 
.const [94] = Class [241] 
.const [95] = Int 117440512 
.const [96] = Utf8 com/ibm/oti/vm/Jxe 
.const [97] = Utf8 java/lang/Object 
.const [98] = Utf8 com/ibm/oti/vm/JxeException 
.const [99] = Utf8 java/io/IOException 
.const [100] = Class [242] 
.const [101] = NameAndType [243] [244] 
.const [102] = Utf8 java/lang/OutOfMemoryError 
.const [103] = Utf8 K019a 
.const [104] = Utf8 com/ibm/oti/util/Msg 
.const [105] = Class [245] 
.const [106] = NameAndType [246] [247] 
.const [107] = Class [248] 
.const [108] = NameAndType [249] [250] 
.const [109] = Class [251] 
.const [110] = NameAndType [252] [253] 
.const [111] = Utf8 com/ibm/oti/vm/JxeUtil 
.const [112] = Class [254] 
.const [113] = NameAndType [255] [256] 
.const [114] = Utf8 com/ibm/oti/vm/JxeMetaData 
.const [115] = Class [257] 
.const [116] = NameAndType [258] [259] 
.const [117] = Utf8 java/io/InputStream 
.const [118] = Utf8 K019b 
.const [119] = Class [260] 
.const [120] = NameAndType [261] [262] 
.const [121] = Utf8 java/io/File 
.const [122] = Utf8 java/io/FileNotFoundException 
.const [123] = Utf8 com/ibm/oti/util/Util 
.const [124] = Class [263] 
.const [125] = NameAndType [264] [265] 
.const [126] = Class [266] 
.const [127] = NameAndType [267] [268] 
.const [128] = Utf8 K01c5 
.const [129] = Class [269] 
.const [130] = NameAndType [270] [271] 
.const [131] = Class [272] 
.const [132] = NameAndType [273] [274] 
.const [133] = Class [275] 
.const [134] = NameAndType [276] [277] 
.const [135] = Utf8 java/lang/System 
.const [136] = Class [278] 
.const [137] = NameAndType [279] [280] 
.const [138] = Utf8 com/ibm/oti/vm/JxePermission 
.const [139] = Utf8 java/lang/SecurityManager 
.const [140] = Utf8 java/util/Hashtable 
.const [141] = Utf8 com/ibm/oti/vm/JxeResource 
.const [142] = Utf8 com/ibm/oti/vm/MemInputStream 
.const [143] = Utf8 java/util/zip/InflaterInputStream 
.const [144] = Utf8 java/util/zip/Inflater 
.const [145] = Utf8 '/' 
.const [146] = Utf8 java/lang/String 
.const [147] = Class [281] 
.const [148] = NameAndType [282] [283] 
.const [149] = Utf8 com/ibm/oti/vm/JxeResourceTable 
.const [150] = Class [284] 
.const [151] = NameAndType [285] [286] 
.const [152] = Class [287] 
.const [153] = NameAndType [288] [289] 
.const [154] = Class [290] 
.const [155] = NameAndType [291] [292] 
.const [156] = Class [293] 
.const [157] = NameAndType [294] [295] 
.const [158] = Class [296] 
.const [159] = NameAndType [297] [298] 
.const [160] = Class [299] 
.const [161] = NameAndType [300] [301] 
.const [162] = Class [302] 
.const [163] = NameAndType [303] [304] 
.const [164] = Class [305] 
.const [165] = NameAndType [306] [307] 
.const [166] = Class [308] 
.const [167] = NameAndType [309] [310] 
.const [168] = Class [311] 
.const [169] = NameAndType [312] [313] 
.const [170] = Class [314] 
.const [171] = NameAndType [315] [316] 
.const [172] = Class [317] 
.const [173] = NameAndType [318] [319] 
.const [174] = Class [320] 
.const [175] = NameAndType [321] [322] 
.const [176] = Class [323] 
.const [177] = NameAndType [324] [325] 
.const [178] = Class [326] 
.const [179] = NameAndType [327] [328] 
.const [180] = Class [329] 
.const [181] = NameAndType [330] [331] 
.const [182] = Class [332] 
.const [183] = NameAndType [333] [334] 
.const [184] = Class [335] 
.const [185] = NameAndType [336] [337] 
.const [186] = Class [338] 
.const [187] = NameAndType [339] [340] 
.const [188] = Class [341] 
.const [189] = NameAndType [342] [343] 
.const [190] = Class [344] 
.const [191] = NameAndType [345] [346] 
.const [192] = Class [347] 
.const [193] = NameAndType [348] [349] 
.const [194] = Class [350] 
.const [195] = NameAndType [351] [352] 
.const [196] = Class [353] 
.const [197] = NameAndType [354] [355] 
.const [198] = Class [356] 
.const [199] = NameAndType [357] [358] 
.const [200] = Class [359] 
.const [201] = NameAndType [360] [361] 
.const [202] = Class [362] 
.const [203] = NameAndType [363] [364] 
.const [204] = Class [365] 
.const [205] = NameAndType [366] [367] 
.const [206] = Class [368] 
.const [207] = NameAndType [369] [370] 
.const [208] = Class [371] 
.const [209] = NameAndType [372] [373] 
.const [210] = Class [374] 
.const [211] = NameAndType [375] [376] 
.const [212] = Class [377] 
.const [213] = NameAndType [378] [379] 
.const [214] = Class [380] 
.const [215] = NameAndType [381] [382] 
.const [216] = Class [383] 
.const [217] = NameAndType [384] [385] 
.const [218] = Class [386] 
.const [219] = NameAndType [387] [388] 
.const [220] = Class [389] 
.const [221] = NameAndType [390] [391] 
.const [222] = Utf8 com/ibm/oti/vm/Jxe 
.const [223] = Utf8 com/ibm/oti/vm/JxeException 
.const [224] = Utf8 java/io/IOException 
.const [225] = Utf8 java/lang/OutOfMemoryError 
.const [226] = Utf8 com/ibm/oti/vm/JxeMetaData 
.const [227] = Class [392] 
.const [228] = NameAndType [393] [394] 
.const [229] = Utf8 java/io/FileNotFoundException 
.const [230] = Class [395] 
.const [231] = NameAndType [396] [397] 
.const [232] = Class [398] 
.const [233] = NameAndType [399] [400] 
.const [234] = Utf8 com/ibm/oti/vm/JxePermission 
.const [235] = Class [401] 
.const [236] = NameAndType [402] [403] 
.const [237] = Utf8 java/util/Hashtable 
.const [238] = Utf8 com/ibm/oti/vm/MemInputStream 
.const [239] = Utf8 java/util/zip/InflaterInputStream 
.const [240] = Utf8 java/util/zip/Inflater 
.const [241] = Utf8 com/ibm/oti/vm/JxeResourceTable 
.const [242] = Utf8 com/ibm/oti/vm/Jxe 
.const [243] = Utf8 nativeMalloc 
.const [244] = Utf8 (I)J 
.const [245] = Utf8 com/ibm/oti/util/Msg 
.const [246] = Utf8 getString 
.const [247] = Utf8 (Ljava/lang/String;I)Ljava/lang/String; 
.const [248] = Utf8 com/ibm/oti/vm/Jxe 
.const [249] = Utf8 copyStreamToMemory 
.const [250] = Utf8 (Ljava/io/InputStream;IJ)V 
.const [251] = Utf8 com/ibm/oti/vm/Jxe 
.const [252] = Utf8 nativeFree 
.const [253] = Utf8 (J)V 
.const [254] = Utf8 com/ibm/oti/vm/JxeUtil 
.const [255] = Utf8 relocateJxeInPlace 
.const [256] = Utf8 (J)V 
.const [257] = Utf8 com/ibm/oti/vm/JxeUtil 
.const [258] = Utf8 registerJxe 
.const [259] = Utf8 (Lcom/ibm/oti/vm/Jxe;)Z 
.const [260] = Utf8 com/ibm/oti/vm/Jxe 
.const [261] = Utf8 nativeMemcpy 
.const [262] = Utf8 (J[BII)V 
.const [263] = Utf8 com/ibm/oti/util/Util 
.const [264] = Utf8 getBytes 
.const [265] = Utf8 (Ljava/lang/String;)[B 
.const [266] = Utf8 com/ibm/oti/vm/Jxe 
.const [267] = Utf8 nativeLoadJxeFromFileByteArray 
.const [268] = Utf8 ([B)J 
.const [269] = Utf8 com/ibm/oti/util/Msg 
.const [270] = Utf8 getString 
.const [271] = Utf8 (Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/String; 
.const [272] = Utf8 com/ibm/oti/vm/Jxe 
.const [273] = Utf8 nativeLoadJxeFromSharedLibrary 
.const [274] = Utf8 ([B)J 
.const [275] = Utf8 com/ibm/oti/vm/Jxe 
.const [276] = Utf8 nativeGetClassList 
.const [277] = Utf8 (J)[Ljava/lang/String; 
.const [278] = Utf8 java/lang/System 
.const [279] = Utf8 getSecurityManager 
.const [280] = Utf8 ()Ljava/lang/SecurityManager; 
.const [281] = Utf8 com/ibm/oti/vm/JxeUtil 
.const [282] = Utf8 unregisterJxe 
.const [283] = Utf8 (Lcom/ibm/oti/vm/Jxe;)Z 
.const [284] = Utf8 com/ibm/oti/vm/Jxe 
.const [285] = Utf8 getJxeMetaData 
.const [286] = Utf8 ()Lcom/ibm/oti/vm/JxeMetaData; 
.const [287] = Utf8 com/ibm/oti/vm/JxeMetaData 
.const [288] = Utf8 getUuid 
.const [289] = Utf8 ()Ljava/lang/String; 
.const [290] = Utf8 com/ibm/oti/vm/Jxe 
.const [291] = Utf8 uuid 
.const [292] = Utf8 Ljava/lang/String; 
.const [293] = Utf8 java/io/InputStream 
.const [294] = Utf8 read 
.const [295] = Utf8 ([BII)I 
.const [296] = Utf8 java/io/File 
.const [297] = Utf8 exists 
.const [298] = Utf8 ()Z 
.const [299] = Utf8 java/io/File 
.const [300] = Utf8 getPath 
.const [301] = Utf8 ()Ljava/lang/String; 
.const [302] = Utf8 com/ibm/oti/vm/Jxe 
.const [303] = Utf8 jxePointer 
.const [304] = Utf8 J 
.const [305] = Utf8 com/ibm/oti/vm/Jxe 
.const [306] = Utf8 allocated 
.const [307] = Utf8 Z 
.const [308] = Utf8 com/ibm/oti/vm/Jxe 
.const [309] = Utf8 getUuid 
.const [310] = Utf8 ()Ljava/lang/String; 
.const [311] = Utf8 java/lang/SecurityManager 
.const [312] = Utf8 checkPermission 
.const [313] = Utf8 (Ljava/security/Permission;)V 
.const [314] = Utf8 com/ibm/oti/vm/Jxe 
.const [315] = Utf8 internalGetResourceAsStream 
.const [316] = Utf8 (Ljava/lang/String;)Ljava/io/InputStream; 
.const [317] = Utf8 com/ibm/oti/vm/Jxe 
.const [318] = Utf8 resTable 
.const [319] = Utf8 Ljava/util/Hashtable; 
.const [320] = Utf8 java/util/Hashtable 
.const [321] = Utf8 get 
.const [322] = Utf8 (Ljava/lang/Object;)Ljava/lang/Object; 
.const [323] = Utf8 com/ibm/oti/vm/JxeResource 
.const [324] = Utf8 getPointer 
.const [325] = Utf8 ()J 
.const [326] = Utf8 com/ibm/oti/vm/JxeResource 
.const [327] = Utf8 getSize 
.const [328] = Utf8 ()I 
.const [329] = Utf8 com/ibm/oti/vm/JxeResource 
.const [330] = Utf8 getMethod 
.const [331] = Utf8 ()I 
.const [332] = Utf8 java/lang/String 
.const [333] = Utf8 startsWith 
.const [334] = Utf8 (Ljava/lang/String;I)Z 
.const [335] = Utf8 java/lang/String 
.const [336] = Utf8 substring 
.const [337] = Utf8 (I)Ljava/lang/String; 
.const [338] = Utf8 com/ibm/oti/vm/Jxe 
.const [339] = Utf8 romSegmentPointer 
.const [340] = Utf8 J 
.const [341] = Utf8 com/ibm/oti/vm/Jxe 
.const [342] = Utf8 getJxePointer 
.const [343] = Utf8 ()J 
.const [344] = Utf8 com/ibm/oti/vm/JxeResourceTable 
.const [345] = Utf8 getTable 
.const [346] = Utf8 ()Ljava/util/Hashtable; 
.const [347] = Utf8 java/lang/OutOfMemoryError 
.const [348] = Utf8 <init> 
.const [349] = Utf8 (Ljava/lang/String;)V 
.const [350] = Utf8 com/ibm/oti/vm/Jxe 
.const [351] = Utf8 <init> 
.const [352] = Utf8 (JZ)V 
.const [353] = Utf8 java/io/IOException 
.const [354] = Utf8 <init> 
.const [355] = Utf8 (Ljava/lang/String;)V 
.const [356] = Utf8 java/io/FileNotFoundException 
.const [357] = Utf8 <init> 
.const [358] = Utf8 (Ljava/lang/String;)V 
.const [359] = Utf8 com/ibm/oti/vm/JxeException 
.const [360] = Utf8 <init> 
.const [361] = Utf8 (Ljava/lang/String;)V 
.const [362] = Utf8 java/lang/Object 
.const [363] = Utf8 <init> 
.const [364] = Utf8 ()V 
.const [365] = Utf8 com/ibm/oti/vm/JxeMetaData 
.const [366] = Utf8 <init> 
.const [367] = Utf8 (Lcom/ibm/oti/vm/Jxe;)V 
.const [368] = Utf8 com/ibm/oti/vm/JxePermission 
.const [369] = Utf8 <init> 
.const [370] = Utf8 (Ljava/lang/String;)V 
.const [371] = Utf8 com/ibm/oti/vm/Jxe 
.const [372] = Utf8 initializeResTable 
.const [373] = Utf8 ()V 
.const [374] = Utf8 com/ibm/oti/vm/MemInputStream 
.const [375] = Utf8 <init> 
.const [376] = Utf8 (JILcom/ibm/oti/vm/Jxe;)V 
.const [377] = Utf8 java/util/zip/Inflater 
.const [378] = Utf8 <init> 
.const [379] = Utf8 (Z)V 
.const [380] = Utf8 java/util/zip/InflaterInputStream 
.const [381] = Utf8 <init> 
.const [382] = Utf8 (Ljava/io/InputStream;Ljava/util/zip/Inflater;)V 
.const [383] = Utf8 com/ibm/oti/vm/Jxe 
.const [384] = Utf8 free 
.const [385] = Utf8 ()V 
.const [386] = Utf8 com/ibm/oti/vm/JxeResourceTable 
.const [387] = Utf8 <init> 
.const [388] = Utf8 (Lcom/ibm/oti/vm/MemInputStream;)V 
.const [389] = Utf8 java/util/Hashtable 
.const [390] = Utf8 <init> 
.const [391] = Utf8 (I)V 
.const [392] = Utf8 com/ibm/oti/vm/Jxe 
.const [393] = Utf8 uuid 
.const [394] = Utf8 Ljava/lang/String; 
.const [395] = Utf8 com/ibm/oti/vm/Jxe 
.const [396] = Utf8 jxePointer 
.const [397] = Utf8 J 
.const [398] = Utf8 com/ibm/oti/vm/Jxe 
.const [399] = Utf8 allocated 
.const [400] = Utf8 Z 
.const [401] = Utf8 com/ibm/oti/vm/Jxe 
.const [402] = Utf8 resTable 
.const [403] = Utf8 Ljava/util/Hashtable; 
.const [404] = Utf8 com/ibm/oti/vm/Jxe 
.const [405] = Class [404] 
.const [406] = Utf8 java/lang/Object 
.const [407] = Class [406] 
.const [408] = Utf8 romSegmentPointer 
.const [409] = Utf8 J 
.const [410] = Utf8 allocated 
.const [411] = Utf8 Z 
.const [412] = Utf8 uuid 
.const [413] = Utf8 Ljava/lang/String; 
.const [414] = Utf8 jxePointer 
.const [415] = Utf8 J 
.const [416] = Utf8 resTable 
.const [417] = Utf8 Ljava/util/Hashtable; 
.const [418] = Utf8 DEFLATED 
.const [419] = Utf8 I 
.const [420] = Utf8 STORED 
.const [421] = Utf8 I 
.const [422] = Utf8 Code 
.const [423] = Utf8 fromInputStream 
.const [424] = Utf8 (Ljava/io/InputStream;I)Lcom/ibm/oti/vm/Jxe; 
.const [425] = Utf8 copyStreamToMemory 
.const [426] = Utf8 (Ljava/io/InputStream;IJ)V 
.const [427] = Utf8 fromFile 
.const [428] = Utf8 (Ljava/io/File;)Lcom/ibm/oti/vm/Jxe; 
.const [429] = Utf8 fromSharedLibrary 
.const [430] = Utf8 (Ljava/lang/String;)Lcom/ibm/oti/vm/Jxe; 
.const [431] = Utf8 <init> 
.const [432] = Utf8 (JZ)V 
.const [433] = Utf8 fromPointer 
.const [434] = Utf8 (J)Lcom/ibm/oti/vm/Jxe; 
.const [435] = Utf8 getJxePointer 
.const [436] = Utf8 ()J 
.const [437] = Utf8 getJxeAlloc 
.const [438] = Utf8 ()J 
.const [439] = Utf8 getJxeMetaData 
.const [440] = Utf8 ()Lcom/ibm/oti/vm/JxeMetaData; 
.const [441] = Utf8 getClassList 
.const [442] = Utf8 ()[Ljava/lang/String; 
.const [443] = Utf8 getResourceAsStream 
.const [444] = Utf8 (Ljava/lang/String;)Ljava/io/InputStream; 
.const [445] = Utf8 internalGetResourceAsStream 
.const [446] = Utf8 (Ljava/lang/String;)Ljava/io/InputStream; 
.const [447] = Utf8 getUuid 
.const [448] = Utf8 ()Ljava/lang/String; 
.const [449] = Utf8 free 
.const [450] = Utf8 ()V 
.const [451] = Utf8 finalize 
.const [452] = Utf8 ()V 
.const [453] = Utf8 initializeResTable 
.const [454] = Utf8 ()V 
.const [455] = Utf8 nativeGetClassList 
.const [456] = Utf8 (J)[Ljava/lang/String; 
.const [457] = Utf8 nativeLoadJxeFromFileByteArray 
.const [458] = Utf8 ([B)J 
.const [459] = Utf8 nativeMemcpy 
.const [460] = Utf8 (J[BII)V 
.const [461] = Utf8 nativeMalloc 
.const [462] = Utf8 (I)J 
.const [463] = Utf8 nativeFree 
.const [464] = Utf8 (J)V 
.const [465] = Utf8 nativeLoadJxeFromSharedLibrary 
.const [466] = Utf8 ([B)J 
.end class 
