.version 50 0 
.class public super [378] 
.super [380] 
.implements [382] 
.field private final [383] [384] 
.field private [385] [386] 
.field private [387] [388] 
.field private [389] [390] 
.field private [391] [392] 
.field private [393] [394] 
.field private [395] [396] 

.method public [398] : [399] 
    .attribute [397] .code stack 7 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     aload_3 
L3:     invokeinterface [57] 0 
L8:     i2f 
L9:     aload_3 
L10:    invokeinterface [58] 0 
L15:    i2f 
L16:    iconst_0 
L17:    iload_2 
L18:    iload 6 
L20:    invokespecial [52] 
L23:    aload_0 
L24:    iconst_1 
L25:    putfield [59] 
L28:    aload_0 
L29:    aload_1 
L30:    putfield [60] 
L33:    aload_0 
L34:    aload_3 
L35:    putfield [61] 
L38:    aload_0 
L39:    iload 4 
L41:    putfield [62] 
L44:    aload_1 
L45:    ldc [2] 
L47:    invokevirtual [24] 
L50:    pop 
L51:    aload_0 
L52:    invokevirtual [25] 
L55:    aload_0 
L56:    fconst_1 
L57:    fconst_1 
L58:    fconst_1 
L59:    invokevirtual [26] 
L62:    aload_0 
L63:    aload 5 
L65:    putfield [63] 
L68:    return 
L69:    nop 
L70:    nop 
L71:    nop 
L72:    
    .end code 
.end method 

.method public [400] : [401] 
    .attribute [397] .code stack 2 locals 0 
L0:     aload_0 
L1:     getfield [28] 
L4:     ifnull L12 
L7:     aload_0 
L8:     getfield [28] 
L11:    areturn 
L12:    aload_0 
L13:    aload_0 
L14:    getfield [21] 
L17:    invokevirtual [29] 
L20:    putfield [64] 
L23:    aload_0 
L24:    getfield [28] 
L27:    areturn 
L28:    
    .end code 
.end method 

.method public interface [402] : [403] 
    .attribute [397] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [21] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [404] : [405] 
    .attribute [397] .code stack 1 locals 0 
L0:     fconst_0 
L1:     areturn 
L2:     nop 
L3:     nop 
L4:     
    .end code 
.end method 

.method public [406] : [407] 
    .attribute [397] .code stack 2 locals 0 
L0:     aload_0 
L1:     getfield [30] 
L4:     aload_0 
L5:     getfield [31] 
L8:     fmul 
L9:     areturn 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method protected [408] : [409] 
    .attribute [397] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [22] 
L4:     ifnonnull L9 
L7:     iconst_0 
L8:     areturn 
L9:     aload_0 
L10:    getfield [20] 
L13:    ifeq L44 
L16:    aload_0 
L17:    getfield [32] 
L20:    ifne L44 
L23:    aload_0 
L24:    getfield [22] 
L27:    invokeinterface [66] 0 
L32:    invokeinterface [67] 0 
L37:    ifeq L44 
L40:    iconst_1 
L41:    goto L45 
L44:    iconst_0 
L45:    areturn 
L46:    nop 
L47:    nop 
L48:    
    .end code 
.end method 

.method public [410] : [411] 
    .attribute [397] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [22] 
L4:     ifnonnull L10 
L7:     ldc [3] 
L9:     areturn 
L10:    aload_0 
L11:    getfield [22] 
L14:    invokeinterface [66] 0 
L19:    invokeinterface [68] 0 
L24:    invokestatic [4] 
L27:    areturn 
L28:    
    .end code 
.end method 

.method public [412] : [413] 
    .attribute [397] .code stack 3 locals 0 
L0:     aload_0 
L1:     invokespecial [53] 
L4:     aload_0 
L5:     getfield [21] 
L8:     ldc [2] 
L10:    invokevirtual [24] 
L13:    pop 
L14:    aload_0 
L15:    invokevirtual [25] 
L18:    aload_0 
L19:    getfield [21] 
L22:    ldc2_w [75] 
L25:    invokevirtual [33] 
L28:    pop 
L29:    return 
L30:    nop 
L31:    nop 
L32:    
    .end code 
.end method 

.method public [414] : [415] 
    .attribute [397] .code stack 2 locals 0 
L0:     aload_0 
L1:     invokespecial [54] 
L4:     aload_0 
L5:     getfield [28] 
L8:     ifnull L23 
L11:    aload_0 
L12:    getfield [28] 
L15:    invokevirtual [34] 
L18:    aload_0 
L19:    aconst_null 
L20:    putfield [64] 
L23:    return 
L24:    
    .end code 
.end method 

.method public [416] : [417] 
    .attribute [397] .code stack 3 locals 0 
L0:     aload_0 
L1:     iload_1 
L2:     invokespecial [55] 
L5:     ifeq L10 
L8:     iconst_1 
L9:     areturn 
L10:    aload_0 
L11:    iload_1 
L12:    invokespecial [56] 
L15:    aload_0 
L16:    getfield [21] 
L19:    iload_1 
L20:    i2l 
L21:    invokevirtual [33] 
L24:    areturn 
L25:    nop 
L26:    nop 
L27:    nop 
L28:    
    .end code 
.end method 

.method private [418] : [419] 
    .attribute [397] .code stack 2 locals 0 
L0:     aload_0 
L1:     iload_1 
L2:     putfield [69] 
L5:     return 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method private [420] : [421] 
    .attribute [397] .code stack 2 locals 0 
L0:     aload_0 
L1:     getfield [35] 
L4:     iload_1 
L5:     if_icmpne L12 
L8:     iconst_1 
L9:     goto L13 
L12:    iconst_0 
L13:    areturn 
L14:    nop 
L15:    nop 
L16:    
    .end code 
.end method 

.method public [422] : [423] 
    .attribute [397] .code stack 2 locals 0 
L0:     aload_0 
L1:     getfield [36] 
L4:     ifnull L20 
L7:     aload_0 
L8:     getfield [36] 
L11:    aload_1 
L12:    invokevirtual [37] 
L15:    ifeq L20 
L18:    iconst_1 
L19:    areturn 
L20:    aload_0 
L21:    aload_1 
L22:    putfield [70] 
L25:    aload_0 
L26:    getfield [21] 
L29:    aload_1 
L30:    invokevirtual [38] 
L33:    areturn 
L34:    nop 
L35:    nop 
L36:    
    .end code 
.end method 

.method public [424] : [425] 
    .attribute [397] .code stack 3 locals 2 
L0:     aload_0 
L1:     getfield [22] 
L4:     ifnull L25 
L7:     aload_0 
L8:     getfield [22] 
L11:    aload_1 
L12:    invokevirtual [39] 
L15:    ifeq L25 
L18:    aload_0 
L19:    iload_2 
L20:    putfield [62] 
L23:    iconst_1 
L24:    areturn 
L25:    aload_0 
L26:    invokevirtual [40] 
L29:    aload_0 
L30:    iload_2 
L31:    putfield [62] 
L34:    aload_0 
L35:    aload_1 
L36:    putfield [61] 
L39:    aload_1 
L40:    ifnonnull L49 
L43:    aconst_null 
L44:    astore 4 
L46:    goto L75 
L49:    aload_1 
L50:    invokeinterface [66] 0 
L55:    aload_3 
L56:    invokeinterface [71] 0 
L61:    pop 
L62:    aload_0 
L63:    aload_3 
L64:    putfield [63] 
L67:    aload_1 
L68:    invokeinterface [72] 0 
L73:    astore 4 
L75:    aload_0 
L76:    getfield [21] 
L79:    aload 4 
L81:    invokevirtual [41] 
L84:    istore 5 
L86:    iload 5 
L88:    ifeq L133 
L91:    aload 4 
L93:    ifnonnull L109 
L96:    aload_0 
L97:    fconst_0 
L98:    putfield [73] 
L101:   aload_0 
L102:   fconst_0 
L103:   putfield [65] 
L106:   goto L129 
L109:   aload_0 
L110:   aload 4 
L112:   invokevirtual [42] 
L115:   l2f 
L116:   putfield [73] 
L119:   aload_0 
L120:   aload 4 
L122:   invokevirtual [43] 
L125:   l2f 
L126:   putfield [65] 
L129:   aload_0 
L130:   invokevirtual [25] 
L133:   iload 5 
L135:   areturn 
L136:   
    .end code 
.end method 

.method public interface [426] : [427] 
    .attribute [397] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [22] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [428] : [429] 
    .attribute [397] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [21] 
L4:     ifnull L15 
L7:     aload_0 
L8:     getfield [21] 
L11:    invokevirtual [44] 
L14:    pop 
L15:    return 
L16:    
    .end code 
.end method 

.method public [430] : [431] 
    .attribute [397] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [21] 
L4:     ifnull L15 
L7:     aload_0 
L8:     getfield [21] 
L11:    invokevirtual [45] 
L14:    pop 
L15:    return 
L16:    
    .end code 
.end method 

.method public [432] : [433] 
    .attribute [397] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [21] 
L4:     ifnull L15 
L7:     aload_0 
L8:     getfield [21] 
L11:    invokevirtual [46] 
L14:    pop 
L15:    return 
L16:    
    .end code 
.end method 

.method public [434] : [435] 
    .attribute [397] .code stack 4 locals 1 
L0:     aload_0 
L1:     getfield [21] 
L4:     ldc [5] 
L6:     invokevirtual [47] 
L9:     astore_1 
L10:    aload_1 
L11:    invokevirtual [48] 
L14:    ifeq L25 
L17:    aload_1 
L18:    invokevirtual [49] 
L21:    pop 
L22:    goto L38 
L25:    getstatic [6] 
L28:    sipush 10000 
L31:    ldc [7] 
L33:    aload_0 
L34:    invokevirtual [50] 
L37:    pop 
L38:    aload_1 
L39:    invokevirtual [51] 
L42:    aload_0 
L43:    getfield [22] 
L46:    ifnull L72 
L49:    aload_0 
L50:    getfield [22] 
L53:    aload_0 
L54:    getfield [23] 
L57:    aload_0 
L58:    getfield [27] 
L61:    invokeinterface [74] 0 
L66:    pop 
L67:    aload_0 
L68:    aconst_null 
L69:    putfield [61] 
L72:    return 
L73:    nop 
L74:    nop 
L75:    nop 
L76:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Int 13379 
.const [3] = String [77] 
.const [4] = Method [78] [79] 
.const [5] = String [80] 
.const [6] = Field [81] [82] 
.const [7] = String [83] 
.const [8] = Class [84] 
.const [9] = Class [85] 
.const [10] = Class [86] 
.const [11] = Class [87] 
.const [12] = Class [88] 
.const [13] = Class [89] 
.const [14] = Class [90] 
.const [15] = Class [91] 
.const [16] = Class [92] 
.const [17] = Class [93] 
.const [18] = Class [94] 
.const [19] = Class [95] 
.const [20] = Field [96] [97] 
.const [21] = Field [98] [99] 
.const [22] = Field [100] [101] 
.const [23] = Field [102] [103] 
.const [24] = Method [104] [105] 
.const [25] = Method [106] [107] 
.const [26] = Method [108] [109] 
.const [27] = Field [110] [111] 
.const [28] = Field [112] [113] 
.const [29] = Method [114] [115] 
.const [30] = Field [116] [117] 
.const [31] = Field [118] [119] 
.const [32] = Field [120] [121] 
.const [33] = Method [122] [123] 
.const [34] = Method [124] [125] 
.const [35] = Field [126] [127] 
.const [36] = Field [128] [129] 
.const [37] = Method [130] [131] 
.const [38] = Method [132] [133] 
.const [39] = Method [134] [135] 
.const [40] = Method [136] [137] 
.const [41] = Method [138] [139] 
.const [42] = Method [140] [141] 
.const [43] = Method [142] [143] 
.const [44] = Method [144] [145] 
.const [45] = Method [146] [147] 
.const [46] = Method [148] [149] 
.const [47] = Method [150] [151] 
.const [48] = Method [152] [153] 
.const [49] = Method [154] [155] 
.const [50] = Method [156] [157] 
.const [51] = Method [158] [159] 
.const [52] = Method [160] [161] 
.const [53] = Method [162] [163] 
.const [54] = Method [164] [165] 
.const [55] = Method [166] [167] 
.const [56] = Method [168] [169] 
.const [57] = InterfaceMethod [170] [171] 
.const [58] = InterfaceMethod [172] [173] 
.const [59] = Field [174] [175] 
.const [60] = Field [176] [177] 
.const [61] = Field [178] [179] 
.const [62] = Field [180] [181] 
.const [63] = Field [182] [183] 
.const [64] = Field [184] [185] 
.const [65] = Field [186] [187] 
.const [66] = InterfaceMethod [188] [189] 
.const [67] = InterfaceMethod [190] [191] 
.const [68] = InterfaceMethod [192] [193] 
.const [69] = Field [194] [195] 
.const [70] = Field [196] [197] 
.const [71] = InterfaceMethod [198] [199] 
.const [72] = InterfaceMethod [200] [201] 
.const [73] = Field [202] [203] 
.const [74] = InterfaceMethod [204] [205] 
.const [75] = Long -1L 
.const [77] = Utf8 '<no texture>' 
.const [78] = Class [206] 
.const [79] = NameAndType [207] [208] 
.const [80] = Utf8 Texture 
.const [81] = Class [209] 
.const [82] = NameAndType [210] [211] 
.const [83] = Utf8 'WrappedNode3DImage#releaseTexture property invalid in %1' 
.const [84] = Utf8 de/esolutions/hmi/widgets/audi/base/eal/WrappedNode3DImage 
.const [85] = Utf8 de/esolutions/hmi/widgets/audi/base/eal/WrappedNode3D 
.const [86] = Utf8 de/esolutions/hmi/widgets/audi/base/eal/IWrappedTexture 
.const [87] = Utf8 de/esolutions/graphics/eal/api/INode3DImage 
.const [88] = Utf8 de/esolutions/hmi/widgets/audi/base/eal/TextureDescription 
.const [89] = Utf8 java/lang/String 
.const [90] = Utf8 de/esolutions/graphics/eal/api/IINodeImage 
.const [91] = Utf8 de/esolutions/graphics/eal/api/IMaterial 
.const [92] = Utf8 java/lang/Object 
.const [93] = Utf8 de/esolutions/graphics/eal/api/ITexture 
.const [94] = Utf8 de/esolutions/graphics/eal/api/IProperty 
.const [95] = Utf8 de/audi/atip/log/LogChannel 
.const [96] = Class [212] 
.const [97] = NameAndType [213] [214] 
.const [98] = Class [215] 
.const [99] = NameAndType [216] [217] 
.const [100] = Class [218] 
.const [101] = NameAndType [219] [220] 
.const [102] = Class [221] 
.const [103] = NameAndType [222] [223] 
.const [104] = Class [224] 
.const [105] = NameAndType [225] [226] 
.const [106] = Class [227] 
.const [107] = NameAndType [228] [229] 
.const [108] = Class [230] 
.const [109] = NameAndType [231] [232] 
.const [110] = Class [233] 
.const [111] = NameAndType [234] [235] 
.const [112] = Class [236] 
.const [113] = NameAndType [237] [238] 
.const [114] = Class [239] 
.const [115] = NameAndType [240] [241] 
.const [116] = Class [242] 
.const [117] = NameAndType [243] [244] 
.const [118] = Class [245] 
.const [119] = NameAndType [246] [247] 
.const [120] = Class [248] 
.const [121] = NameAndType [249] [250] 
.const [122] = Class [251] 
.const [123] = NameAndType [252] [253] 
.const [124] = Class [254] 
.const [125] = NameAndType [255] [256] 
.const [126] = Class [257] 
.const [127] = NameAndType [258] [259] 
.const [128] = Class [260] 
.const [129] = NameAndType [261] [262] 
.const [130] = Class [263] 
.const [131] = NameAndType [264] [265] 
.const [132] = Class [266] 
.const [133] = NameAndType [267] [268] 
.const [134] = Class [269] 
.const [135] = NameAndType [270] [271] 
.const [136] = Class [272] 
.const [137] = NameAndType [273] [274] 
.const [138] = Class [275] 
.const [139] = NameAndType [276] [277] 
.const [140] = Class [278] 
.const [141] = NameAndType [279] [280] 
.const [142] = Class [281] 
.const [143] = NameAndType [282] [283] 
.const [144] = Class [284] 
.const [145] = NameAndType [285] [286] 
.const [146] = Class [287] 
.const [147] = NameAndType [288] [289] 
.const [148] = Class [290] 
.const [149] = NameAndType [291] [292] 
.const [150] = Class [293] 
.const [151] = NameAndType [294] [295] 
.const [152] = Class [296] 
.const [153] = NameAndType [297] [298] 
.const [154] = Class [299] 
.const [155] = NameAndType [300] [301] 
.const [156] = Class [302] 
.const [157] = NameAndType [303] [304] 
.const [158] = Class [305] 
.const [159] = NameAndType [306] [307] 
.const [160] = Class [308] 
.const [161] = NameAndType [309] [310] 
.const [162] = Class [311] 
.const [163] = NameAndType [312] [313] 
.const [164] = Class [314] 
.const [165] = NameAndType [315] [316] 
.const [166] = Class [317] 
.const [167] = NameAndType [318] [319] 
.const [168] = Class [320] 
.const [169] = NameAndType [321] [322] 
.const [170] = Class [323] 
.const [171] = NameAndType [324] [325] 
.const [172] = Class [326] 
.const [173] = NameAndType [327] [328] 
.const [174] = Class [329] 
.const [175] = NameAndType [330] [331] 
.const [176] = Class [332] 
.const [177] = NameAndType [333] [334] 
.const [178] = Class [335] 
.const [179] = NameAndType [336] [337] 
.const [180] = Class [338] 
.const [181] = NameAndType [339] [340] 
.const [182] = Class [341] 
.const [183] = NameAndType [342] [343] 
.const [184] = Class [344] 
.const [185] = NameAndType [345] [346] 
.const [186] = Class [347] 
.const [187] = NameAndType [348] [349] 
.const [188] = Class [350] 
.const [189] = NameAndType [351] [352] 
.const [190] = Class [353] 
.const [191] = NameAndType [354] [355] 
.const [192] = Class [356] 
.const [193] = NameAndType [357] [358] 
.const [194] = Class [359] 
.const [195] = NameAndType [360] [361] 
.const [196] = Class [362] 
.const [197] = NameAndType [363] [364] 
.const [198] = Class [365] 
.const [199] = NameAndType [366] [367] 
.const [200] = Class [368] 
.const [201] = NameAndType [369] [370] 
.const [202] = Class [371] 
.const [203] = NameAndType [372] [373] 
.const [204] = Class [374] 
.const [205] = NameAndType [375] [376] 
.const [206] = Utf8 java/lang/String 
.const [207] = Utf8 valueOf 
.const [208] = Utf8 (Ljava/lang/Object;)Ljava/lang/String; 
.const [209] = Utf8 de/esolutions/hmi/widgets/audi/base/eal/WrappedNode3DImage 
.const [210] = Utf8 logChannel3DEngine 
.const [211] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [212] = Utf8 de/esolutions/hmi/widgets/audi/base/eal/WrappedNode3DImage 
.const [213] = Utf8 shouldFlipBack 
.const [214] = Utf8 Z 
.const [215] = Utf8 de/esolutions/hmi/widgets/audi/base/eal/WrappedNode3DImage 
.const [216] = Utf8 node 
.const [217] = Utf8 Lde/esolutions/graphics/eal/api/INode3DImage; 
.const [218] = Utf8 de/esolutions/hmi/widgets/audi/base/eal/WrappedNode3DImage 
.const [219] = Utf8 texture 
.const [220] = Utf8 Lde/esolutions/hmi/widgets/audi/base/eal/IWrappedTexture; 
.const [221] = Utf8 de/esolutions/hmi/widgets/audi/base/eal/WrappedNode3DImage 
.const [222] = Utf8 deleteIfNoCache 
.const [223] = Utf8 Z 
.const [224] = Utf8 de/esolutions/graphics/eal/api/INode3DImage 
.const [225] = Utf8 rotateX 
.const [226] = Utf8 (F)Z 
.const [227] = Utf8 de/esolutions/hmi/widgets/audi/base/eal/WrappedNode3DImage 
.const [228] = Utf8 storePosition 
.const [229] = Utf8 ()V 
.const [230] = Utf8 de/esolutions/hmi/widgets/audi/base/eal/WrappedNode3DImage 
.const [231] = Utf8 setScale 
.const [232] = Utf8 (FFF)V 
.const [233] = Utf8 de/esolutions/hmi/widgets/audi/base/eal/WrappedNode3DImage 
.const [234] = Utf8 oldReference 
.const [235] = Utf8 Ljava/lang/Object; 
.const [236] = Utf8 de/esolutions/hmi/widgets/audi/base/eal/WrappedNode3DImage 
.const [237] = Utf8 interfaceImage 
.const [238] = Utf8 Lde/esolutions/graphics/eal/api/IINodeImage; 
.const [239] = Utf8 de/esolutions/graphics/eal/api/INode3DImage 
.const [240] = Utf8 getInterfaceImage 
.const [241] = Utf8 ()Lde/esolutions/graphics/eal/api/IINodeImage; 
.const [242] = Utf8 de/esolutions/hmi/widgets/audi/base/eal/WrappedNode3DImage 
.const [243] = Utf8 scaleY 
.const [244] = Utf8 F 
.const [245] = Utf8 de/esolutions/hmi/widgets/audi/base/eal/WrappedNode3DImage 
.const [246] = Utf8 unscaledHeight 
.const [247] = Utf8 F 
.const [248] = Utf8 de/esolutions/hmi/widgets/audi/base/eal/WrappedNode3DImage 
.const [249] = Utf8 isLtr 
.const [250] = Utf8 Z 
.const [251] = Utf8 de/esolutions/graphics/eal/api/INode3DImage 
.const [252] = Utf8 setModulateColor 
.const [253] = Utf8 (J)Z 
.const [254] = Utf8 de/esolutions/graphics/eal/api/IINodeImage 
.const [255] = Utf8 dispose 
.const [256] = Utf8 ()V 
.const [257] = Utf8 de/esolutions/hmi/widgets/audi/base/eal/WrappedNode3DImage 
.const [258] = Utf8 color 
.const [259] = Utf8 I 
.const [260] = Utf8 de/esolutions/hmi/widgets/audi/base/eal/WrappedNode3DImage 
.const [261] = Utf8 material 
.const [262] = Utf8 Lde/esolutions/graphics/eal/api/IMaterial; 
.const [263] = Utf8 de/esolutions/graphics/eal/api/IMaterial 
.const [264] = Utf8 equals 
.const [265] = Utf8 (Lde/esolutions/graphics/eal/api/IObject;)Z 
.const [266] = Utf8 de/esolutions/graphics/eal/api/INode3DImage 
.const [267] = Utf8 setMaterial 
.const [268] = Utf8 (Lde/esolutions/graphics/eal/api/IMaterial;)Z 
.const [269] = Utf8 java/lang/Object 
.const [270] = Utf8 equals 
.const [271] = Utf8 (Ljava/lang/Object;)Z 
.const [272] = Utf8 de/esolutions/hmi/widgets/audi/base/eal/WrappedNode3DImage 
.const [273] = Utf8 releaseTexture 
.const [274] = Utf8 ()V 
.const [275] = Utf8 de/esolutions/graphics/eal/api/INode3DImage 
.const [276] = Utf8 setTexture 
.const [277] = Utf8 (Lde/esolutions/graphics/eal/api/ITexture;)Z 
.const [278] = Utf8 de/esolutions/graphics/eal/api/ITexture 
.const [279] = Utf8 getWidth 
.const [280] = Utf8 ()J 
.const [281] = Utf8 de/esolutions/graphics/eal/api/ITexture 
.const [282] = Utf8 getHeight 
.const [283] = Utf8 ()J 
.const [284] = Utf8 de/esolutions/graphics/eal/api/INode3DImage 
.const [285] = Utf8 flipX 
.const [286] = Utf8 ()Z 
.const [287] = Utf8 de/esolutions/graphics/eal/api/INode3DImage 
.const [288] = Utf8 flipY 
.const [289] = Utf8 ()Z 
.const [290] = Utf8 de/esolutions/graphics/eal/api/INode3DImage 
.const [291] = Utf8 flipXY 
.const [292] = Utf8 ()Z 
.const [293] = Utf8 de/esolutions/graphics/eal/api/INode3DImage 
.const [294] = Utf8 getProperty 
.const [295] = Utf8 (Ljava/lang/String;)Lde/esolutions/graphics/eal/api/IProperty; 
.const [296] = Utf8 de/esolutions/graphics/eal/api/IProperty 
.const [297] = Utf8 isValid 
.const [298] = Utf8 ()Z 
.const [299] = Utf8 de/esolutions/graphics/eal/api/IProperty 
.const [300] = Utf8 setDefault 
.const [301] = Utf8 ()Z 
.const [302] = Utf8 de/audi/atip/log/LogChannel 
.const [303] = Utf8 log 
.const [304] = Utf8 (ILjava/lang/String;Ljava/lang/Object;)Z 
.const [305] = Utf8 de/esolutions/graphics/eal/api/IProperty 
.const [306] = Utf8 dispose 
.const [307] = Utf8 ()V 
.const [308] = Utf8 de/esolutions/hmi/widgets/audi/base/eal/WrappedNode3D 
.const [309] = Utf8 <init> 
.const [310] = Utf8 (Lde/esolutions/graphics/eal/api/INode3D;FFZIZ)V 
.const [311] = Utf8 de/esolutions/hmi/widgets/audi/base/eal/WrappedNode3D 
.const [312] = Utf8 resetTransformation 
.const [313] = Utf8 ()V 
.const [314] = Utf8 de/esolutions/hmi/widgets/audi/base/eal/WrappedNode3D 
.const [315] = Utf8 dispose 
.const [316] = Utf8 ()V 
.const [317] = Utf8 de/esolutions/hmi/widgets/audi/base/eal/WrappedNode3DImage 
.const [318] = Utf8 equalsColor 
.const [319] = Utf8 (I)Z 
.const [320] = Utf8 de/esolutions/hmi/widgets/audi/base/eal/WrappedNode3DImage 
.const [321] = Utf8 storeColor 
.const [322] = Utf8 (I)V 
.const [323] = Utf8 de/esolutions/hmi/widgets/audi/base/eal/IWrappedTexture 
.const [324] = Utf8 getWidth 
.const [325] = Utf8 ()I 
.const [326] = Utf8 de/esolutions/hmi/widgets/audi/base/eal/IWrappedTexture 
.const [327] = Utf8 getHeight 
.const [328] = Utf8 ()I 
.const [329] = Utf8 de/esolutions/hmi/widgets/audi/base/eal/WrappedNode3DImage 
.const [330] = Utf8 shouldFlipBack 
.const [331] = Utf8 Z 
.const [332] = Utf8 de/esolutions/hmi/widgets/audi/base/eal/WrappedNode3DImage 
.const [333] = Utf8 node 
.const [334] = Utf8 Lde/esolutions/graphics/eal/api/INode3DImage; 
.const [335] = Utf8 de/esolutions/hmi/widgets/audi/base/eal/WrappedNode3DImage 
.const [336] = Utf8 texture 
.const [337] = Utf8 Lde/esolutions/hmi/widgets/audi/base/eal/IWrappedTexture; 
.const [338] = Utf8 de/esolutions/hmi/widgets/audi/base/eal/WrappedNode3DImage 
.const [339] = Utf8 deleteIfNoCache 
.const [340] = Utf8 Z 
.const [341] = Utf8 de/esolutions/hmi/widgets/audi/base/eal/WrappedNode3DImage 
.const [342] = Utf8 oldReference 
.const [343] = Utf8 Ljava/lang/Object; 
.const [344] = Utf8 de/esolutions/hmi/widgets/audi/base/eal/WrappedNode3DImage 
.const [345] = Utf8 interfaceImage 
.const [346] = Utf8 Lde/esolutions/graphics/eal/api/IINodeImage; 
.const [347] = Utf8 de/esolutions/hmi/widgets/audi/base/eal/WrappedNode3DImage 
.const [348] = Utf8 unscaledHeight 
.const [349] = Utf8 F 
.const [350] = Utf8 de/esolutions/hmi/widgets/audi/base/eal/IWrappedTexture 
.const [351] = Utf8 getDescription 
.const [352] = Utf8 ()Lde/esolutions/hmi/widgets/audi/base/eal/TextureDescription; 
.const [353] = Utf8 de/esolutions/hmi/widgets/audi/base/eal/TextureDescription 
.const [354] = Utf8 preventRTLFlip 
.const [355] = Utf8 ()Z 
.const [356] = Utf8 de/esolutions/hmi/widgets/audi/base/eal/TextureDescription 
.const [357] = Utf8 getCacheKey 
.const [358] = Utf8 ()Ljava/lang/Object; 
.const [359] = Utf8 de/esolutions/hmi/widgets/audi/base/eal/WrappedNode3DImage 
.const [360] = Utf8 color 
.const [361] = Utf8 I 
.const [362] = Utf8 de/esolutions/hmi/widgets/audi/base/eal/WrappedNode3DImage 
.const [363] = Utf8 material 
.const [364] = Utf8 Lde/esolutions/graphics/eal/api/IMaterial; 
.const [365] = Utf8 de/esolutions/hmi/widgets/audi/base/eal/TextureDescription 
.const [366] = Utf8 getCachedTexture 
.const [367] = Utf8 (Ljava/lang/Object;)Lde/esolutions/hmi/widgets/audi/base/eal/IWrappedTexture; 
.const [368] = Utf8 de/esolutions/hmi/widgets/audi/base/eal/IWrappedTexture 
.const [369] = Utf8 getTexture 
.const [370] = Utf8 ()Lde/esolutions/graphics/eal/api/ITexture; 
.const [371] = Utf8 de/esolutions/hmi/widgets/audi/base/eal/WrappedNode3DImage 
.const [372] = Utf8 unscaledWidth 
.const [373] = Utf8 F 
.const [374] = Utf8 de/esolutions/hmi/widgets/audi/base/eal/IWrappedTexture 
.const [375] = Utf8 releaseTexture 
.const [376] = Utf8 (ZLjava/lang/Object;)I 
.const [377] = Utf8 de/esolutions/hmi/widgets/audi/base/eal/WrappedNode3DImage 
.const [378] = Class [377] 
.const [379] = Utf8 de/esolutions/hmi/widgets/audi/base/eal/WrappedNode3D 
.const [380] = Class [379] 
.const [381] = Utf8 de/esolutions/hmi/widgets/audi/base/eal/IWrappedNode3DImage 
.const [382] = Class [381] 
.const [383] = Utf8 node 
.const [384] = Utf8 Lde/esolutions/graphics/eal/api/INode3DImage; 
.const [385] = Utf8 interfaceImage 
.const [386] = Utf8 Lde/esolutions/graphics/eal/api/IINodeImage; 
.const [387] = Utf8 texture 
.const [388] = Utf8 Lde/esolutions/hmi/widgets/audi/base/eal/IWrappedTexture; 
.const [389] = Utf8 material 
.const [390] = Utf8 Lde/esolutions/graphics/eal/api/IMaterial; 
.const [391] = Utf8 color 
.const [392] = Utf8 I 
.const [393] = Utf8 deleteIfNoCache 
.const [394] = Utf8 Z 
.const [395] = Utf8 oldReference 
.const [396] = Utf8 Ljava/lang/Object; 
.const [397] = Utf8 Code 
.const [398] = Utf8 <init> 
.const [399] = Utf8 (Lde/esolutions/graphics/eal/api/INode3DImage;ILde/esolutions/hmi/widgets/audi/base/eal/IWrappedTexture;ZLjava/lang/Object;Z)V 
.const [400] = Utf8 getInterfaceImage 
.const [401] = Utf8 ()Lde/esolutions/graphics/eal/api/IINodeImage; 
.const [402] = Utf8 getImageNode 
.const [403] = Utf8 ()Lde/esolutions/graphics/eal/api/INode3DImage; 
.const [404] = Utf8 getOriginX 
.const [405] = Utf8 ()F 
.const [406] = Utf8 getOriginY 
.const [407] = Utf8 ()F 
.const [408] = Utf8 shouldFlipBack 
.const [409] = Utf8 ()Z 
.const [410] = Utf8 getFilename 
.const [411] = Utf8 ()Ljava/lang/String; 
.const [412] = Utf8 resetTransformation 
.const [413] = Utf8 ()V 
.const [414] = Utf8 dispose 
.const [415] = Utf8 ()V 
.const [416] = Utf8 setModulateColor 
.const [417] = Utf8 (I)Z 
.const [418] = Utf8 storeColor 
.const [419] = Utf8 (I)V 
.const [420] = Utf8 equalsColor 
.const [421] = Utf8 (I)Z 
.const [422] = Utf8 setMaterial 
.const [423] = Utf8 (Lde/esolutions/graphics/eal/api/IMaterial;)Z 
.const [424] = Utf8 setTexture 
.const [425] = Utf8 (Lde/esolutions/hmi/widgets/audi/base/eal/IWrappedTexture;ZLjava/lang/Object;)Z 
.const [426] = Utf8 getTexture 
.const [427] = Utf8 ()Lde/esolutions/hmi/widgets/audi/base/eal/IWrappedTexture; 
.const [428] = Utf8 mirrorX 
.const [429] = Utf8 ()V 
.const [430] = Utf8 mirrorY 
.const [431] = Utf8 ()V 
.const [432] = Utf8 mirrorXY 
.const [433] = Utf8 ()V 
.const [434] = Utf8 releaseTexture 
.const [435] = Utf8 ()V 
.end class 
