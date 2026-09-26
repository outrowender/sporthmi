.version 50 0 
.class public super [381] 
.super [383] 
.field private static final [384] [385] 
.field private final [386] [387] 
.field public static final [388] [389] 
.field public static final [390] [391] 
.field private static final [392] [393] 
.field private volatile [394] [395] 

.method public [397] : [398] 
    .attribute [396] .code stack 5 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     invokeinterface [80] 0 
L7:     invokeinterface [81] 0 
L12:    iconst_0 
L13:    sipush 1002 
L16:    sipush 250 
L19:    invokespecial [72] 
L22:    aload_0 
L23:    aload_1 
L24:    invokeinterface [82] 0 
L29:    invokeinterface [83] 0 
L34:    putfield [84] 
L37:    return 
L38:    nop 
L39:    nop 
L40:    
    .end code 
.end method 

.method public [399] : [400] 
    .attribute [396] .code stack 4 locals 0 
L0:     aload_0 
L1:     getfield [42] 
L4:     ldc [2] 
L6:     ldc [3] 
L8:     ldc [4] 
L10:    invokevirtual [43] 
L13:    pop 
L14:    aload_0 
L15:    invokevirtual [44] 
L18:    return 
L19:    nop 
L20:    
    .end code 
.end method 

.method public [401] : [402] 
    .attribute [396] .code stack 4 locals 0 
L0:     aload_0 
L1:     getfield [42] 
L4:     ldc [2] 
L6:     ldc [5] 
L8:     ldc [4] 
L10:    invokevirtual [43] 
L13:    pop 
L14:    aload_0 
L15:    invokevirtual [45] 
L18:    return 
L19:    nop 
L20:    
    .end code 
.end method 

.method public [403] : [404] 
    .attribute [396] .code stack 4 locals 0 
L0:     aload_0 
L1:     getfield [42] 
L4:     ldc [2] 
L6:     ldc [6] 
L8:     ldc [4] 
L10:    invokevirtual [43] 
L13:    pop 
L14:    aload_0 
L15:    new [85] 
L18:    dup 
L19:    invokespecial [73] 
L22:    putfield [86] 
L25:    aload_0 
L26:    invokevirtual [47] 
L29:    return 
L30:    nop 
L31:    nop 
L32:    
    .end code 
.end method 

.method public [405] : [406] 
    .attribute [396] .code stack 6 locals 2 
L0:     aload_0 
L1:     getfield [42] 
L4:     ldc [2] 
L6:     ldc [8] 
L8:     ldc [4] 
L10:    iload_1 
L11:    invokestatic [9] 
L14:    aload_2 
L15:    invokevirtual [48] 
L18:    aconst_null 
L19:    aload_0 
L20:    getfield [46] 
L23:    if_acmpne L42 
L26:    aload_0 
L27:    getfield [42] 
L30:    ldc [2] 
L32:    ldc [10] 
L34:    ldc [4] 
L36:    invokevirtual [43] 
L39:    pop 
L40:    iconst_m1 
L41:    areturn 
L42:    iconst_0 
L43:    istore_3 
L44:    iload_3 
L45:    aload_0 
L46:    getfield [46] 
L49:    invokevirtual [49] 
L52:    if_icmpge L114 
L55:    aload_0 
L56:    getfield [46] 
L59:    iload_3 
L60:    invokevirtual [50] 
L63:    checkcast [11] 
L66:    astore 4 
L68:    aconst_null 
L69:    aload 4 
L71:    if_acmpne L77 
L74:    goto L108 
L77:    aload 4 
L79:    invokevirtual [51] 
L82:    iload_1 
L83:    if_icmpne L108 
L86:    aload 4 
L88:    invokevirtual [52] 
L91:    aload_2 
L92:    invokevirtual [53] 
L95:    ifeq L108 
L98:    aload_0 
L99:    invokevirtual [45] 
L102:   aload 4 
L104:   invokevirtual [54] 
L107:   areturn 
L108:   iinc 3 1 
L111:   goto L44 
L114:   iconst_m1 
L115:   areturn 
L116:   
    .end code 
.end method 

.method public [407] : [408] 
    .attribute [396] .code stack 7 locals 5 
L0:     aload_0 
L1:     getfield [42] 
L4:     ldc [2] 
L6:     ldc [12] 
L8:     ldc [4] 
L10:    invokevirtual [43] 
L13:    pop 
L14:    aconst_null 
L15:    aload_0 
L16:    getfield [46] 
L19:    if_acmpne L47 
L22:    aload_0 
L23:    getfield [42] 
L26:    ldc [2] 
L28:    ldc [13] 
L30:    ldc [4] 
L32:    invokevirtual [43] 
L35:    pop 
L36:    aload_0 
L37:    new [85] 
L40:    dup 
L41:    invokespecial [73] 
L44:    putfield [86] 
L47:    aload_0 
L48:    getfield [46] 
L51:    invokevirtual [49] 
L54:    bipush 10 
L56:    if_icmpne L169 
L59:    iconst_m1 
L60:    istore 4 
L62:    aconst_null 
L63:    astore 5 
L65:    iconst_0 
L66:    istore 6 
L68:    iload 6 
L70:    aload_0 
L71:    getfield [46] 
L74:    invokevirtual [49] 
L77:    if_icmpge L136 
L80:    aload_0 
L81:    getfield [46] 
L84:    iload 6 
L86:    invokevirtual [50] 
L89:    checkcast [11] 
L92:    astore 7 
L94:    aconst_null 
L95:    aload 7 
L97:    if_acmpne L103 
L100:   goto L130 
L103:   aconst_null 
L104:   aload 5 
L106:   if_acmpeq L122 
L109:   aload 5 
L111:   invokevirtual [55] 
L114:   aload 7 
L116:   invokevirtual [55] 
L119:   if_icmple L130 
L122:   aload 7 
L124:   astore 5 
L126:   iload 6 
L128:   istore 4 
L130:   iinc 6 1 
L133:   goto L68 
L136:   aload_0 
L137:   getfield [46] 
L140:   iload 4 
L142:   new [87] 
L145:   dup 
L146:   aload 5 
L148:   invokevirtual [54] 
L151:   iload_1 
L152:   aload_2 
L153:   invokespecial [74] 
L156:   invokevirtual [56] 
L159:   pop 
L160:   aload 5 
L162:   invokevirtual [54] 
L165:   istore_3 
L166:   goto L204 
L169:   aload_0 
L170:   getfield [46] 
L173:   invokevirtual [49] 
L176:   invokestatic [14] 
L179:   istore_3 
L180:   aload_0 
L181:   getfield [46] 
L184:   aload_0 
L185:   getfield [46] 
L188:   invokevirtual [49] 
L191:   new [87] 
L194:   dup 
L195:   iload_3 
L196:   iload_1 
L197:   aload_2 
L198:   invokespecial [74] 
L201:   invokevirtual [57] 
L204:   aload_0 
L205:   invokevirtual [47] 
L208:   iload_3 
L209:   areturn 
L210:   nop 
L211:   nop 
L212:   
    .end code 
.end method 

.method public [409] : [410] 
    .attribute [396] .code stack 6 locals 4 
L0:     aload_0 
L1:     getfield [42] 
L4:     ldc [2] 
L6:     ldc [15] 
L8:     ldc [4] 
L10:    iload_1 
L11:    i2l 
L12:    invokevirtual [58] 
L15:    pop 
L16:    new [85] 
L19:    dup 
L20:    aload_0 
L21:    getfield [46] 
L24:    invokespecial [75] 
L27:    astore_2 
L28:    aload_2 
L29:    new [88] 
L32:    dup 
L33:    aload_0 
L34:    invokespecial [76] 
L37:    invokestatic [17] 
L40:    iconst_0 
L41:    istore_3 
L42:    iload_3 
L43:    aload_2 
L44:    invokevirtual [49] 
L47:    if_icmpge L97 
L50:    aload_2 
L51:    iload_3 
L52:    invokevirtual [50] 
L55:    checkcast [11] 
L58:    astore 4 
L60:    aconst_null 
L61:    aload 4 
L63:    if_acmpne L69 
L66:    goto L91 
L69:    aload 4 
L71:    invokevirtual [54] 
L74:    iload_1 
L75:    if_icmpne L91 
L78:    aload_2 
L79:    iload_3 
L80:    invokevirtual [59] 
L83:    pop 
L84:    aload_2 
L85:    iconst_0 
L86:    aload 4 
L88:    invokevirtual [57] 
L91:    iinc 3 1 
L94:    goto L42 
L97:    iconst_0 
L98:    istore_3 
L99:    bipush 9 
L101:   istore 4 
L103:   iload_3 
L104:   aload_2 
L105:   invokevirtual [49] 
L108:   if_icmpge L137 
L111:   aload_2 
L112:   iload_3 
L113:   invokevirtual [50] 
L116:   checkcast [11] 
L119:   astore 5 
L121:   aload 5 
L123:   iload 4 
L125:   invokevirtual [60] 
L128:   iinc 3 1 
L131:   iinc 4 -1 
L134:   goto L103 
L137:   return 
L138:   nop 
L139:   nop 
L140:   
    .end code 
.end method 

.method protected [411] : [412] 
    .attribute [396] .code stack 3 locals 0 
L0:     aload_0 
L1:     new [85] 
L4:     dup 
L5:     invokespecial [73] 
L8:     putfield [86] 
L11:    return 
L12:    
    .end code 
.end method 

.method protected [413] : [414] 
    .attribute [396] .code stack 3 locals 0 
L0:     aload_1 
L1:     instanceof [18] 
L4:     ifeq L18 
L7:     aload_0 
L8:     new [85] 
L11:    dup 
L12:    invokespecial [73] 
L15:    putfield [86] 
L18:    return 
L19:    nop 
L20:    
    .end code 
.end method 

.method protected enum [415] : [416] 
    .attribute [396] .code stack 0 locals 0 
L0:     return 
L1:     nop 
L2:     nop 
L3:     nop 
L4:     
    .end code 
.end method 

.method protected [417] : [418] 
    .attribute [396] .code stack 4 locals 1 
L0:     aload_0 
L1:     getfield [42] 
L4:     ldc [2] 
L6:     ldc [19] 
L8:     ldc [4] 
L10:    invokevirtual [43] 
L13:    pop 
L14:    new [89] 
L17:    dup 
L18:    aload_1 
L19:    invokespecial [77] 
L22:    astore_2 
L23:    aload_2 
L24:    aload_0 
L25:    getfield [46] 
L28:    invokevirtual [61] 
L31:    return 
L32:    
    .end code 
.end method 

.method protected [419] : [420] 
    .attribute [396] .code stack 5 locals 2 
L0:     aload_0 
L1:     getfield [42] 
L4:     ldc [2] 
L6:     ldc [21] 
L8:     ldc [4] 
L10:    invokevirtual [43] 
L13:    pop 
L14:    new [90] 
L17:    dup 
L18:    aload_1 
L19:    invokespecial [78] 
L22:    astore_2 
        .catch [23] from L23 to L34 using L37 
L23:    aload_0 
L24:    aload_2 
L25:    invokevirtual [62] 
L28:    checkcast [7] 
L31:    putfield [86] 
L34:    goto L54 
L37:    astore_3 
L38:    aload_0 
L39:    getfield [42] 
L42:    sipush 10000 
L45:    ldc [21] 
L47:    ldc [4] 
L49:    aload_3 
L50:    invokevirtual [63] 
L53:    pop 
L54:    aconst_null 
L55:    aload_0 
L56:    getfield [46] 
L59:    if_acmpne L73 
L62:    aload_0 
L63:    new [85] 
L66:    dup 
L67:    invokespecial [73] 
L70:    putfield [86] 
L73:    aload_0 
L74:    getfield [42] 
L77:    invokevirtual [64] 
L80:    ifeq L100 
L83:    aload_0 
L84:    getfield [42] 
L87:    ldc [24] 
L89:    ldc [25] 
L91:    ldc [4] 
L93:    aload_0 
L94:    invokevirtual [65] 
L97:    invokevirtual [66] 
L100:   return 
L101:   nop 
L102:   nop 
L103:   nop 
L104:   
    .end code 
.end method 

.method public static [421] : [422] 
    .attribute [396] .code stack 1 locals 0 
L0:     iload_0 
L1:     tableswitch 0 
            L56 
            L60 
            L64 
            L68 
            L72 
            L76 
            L80 
            L84 
            L88 
            L92 
            default : L96 

L56:    sipush 260 
L59:    areturn 
L60:    sipush 261 
L63:    areturn 
L64:    sipush 262 
L67:    areturn 
L68:    sipush 263 
L71:    areturn 
L72:    sipush 264 
L75:    areturn 
L76:    sipush 265 
L79:    areturn 
L80:    sipush 266 
L83:    areturn 
L84:    sipush 267 
L87:    areturn 
L88:    sipush 268 
L91:    areturn 
L92:    sipush 269 
L95:    areturn 
L96:    iconst_m1 
L97:    areturn 
L98:    nop 
L99:    nop 
L100:   
    .end code 
.end method 

.method public [423] : [424] 
    .attribute [396] .code stack 3 locals 3 
L0:     aload_0 
L1:     getfield [46] 
L4:     ifnonnull L10 
L7:     ldc [26] 
L9:     areturn 
L10:    new [91] 
L13:    dup 
L14:    bipush 70 
L16:    invokespecial [79] 
L19:    astore_1 
L20:    aload_1 
L21:    ldc [28] 
L23:    invokevirtual [67] 
L26:    pop 
L27:    aload_1 
L28:    aload_0 
L29:    getfield [46] 
L32:    invokevirtual [49] 
L35:    invokevirtual [68] 
L38:    pop 
L39:    aload_1 
L40:    ldc [29] 
L42:    invokevirtual [67] 
L45:    pop 
L46:    aload_0 
L47:    getfield [46] 
L50:    invokevirtual [69] 
L53:    astore_2 
L54:    aload_2 
L55:    invokeinterface [92] 0 
L60:    ifeq L99 
L63:    aload_2 
L64:    invokeinterface [93] 0 
L69:    checkcast [11] 
L72:    astore_3 
L73:    aload_1 
L74:    ldc [30] 
L76:    invokevirtual [67] 
L79:    pop 
L80:    aload_1 
L81:    aload_3 
L82:    invokevirtual [70] 
L85:    invokevirtual [67] 
L88:    pop 
L89:    aload_1 
L90:    ldc [31] 
L92:    invokevirtual [67] 
L95:    pop 
L96:    goto L54 
L99:    aload_1 
L100:   invokevirtual [71] 
L103:   areturn 
L104:   
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Int 1078071040 
.const [3] = String [94] 
.const [4] = String [95] 
.const [5] = String [96] 
.const [6] = String [97] 
.const [7] = Class [98] 
.const [8] = String [99] 
.const [9] = Method [100] [101] 
.const [10] = String [102] 
.const [11] = Class [103] 
.const [12] = String [104] 
.const [13] = String [105] 
.const [14] = Method [106] [107] 
.const [15] = String [108] 
.const [16] = Class [109] 
.const [17] = Method [110] [111] 
.const [18] = Class [112] 
.const [19] = String [113] 
.const [20] = Class [114] 
.const [21] = String [115] 
.const [22] = Class [116] 
.const [23] = Class [117] 
.const [24] = Int -2137614336 
.const [25] = String [118] 
.const [26] = String [119] 
.const [27] = Class [120] 
.const [28] = String [121] 
.const [29] = String [122] 
.const [30] = String [123] 
.const [31] = String [124] 
.const [32] = Class [125] 
.const [33] = Class [126] 
.const [34] = Class [127] 
.const [35] = Class [128] 
.const [36] = Class [129] 
.const [37] = Class [130] 
.const [38] = Class [131] 
.const [39] = Class [132] 
.const [40] = Class [133] 
.const [41] = Class [134] 
.const [42] = Field [135] [136] 
.const [43] = Method [137] [138] 
.const [44] = Method [139] [140] 
.const [45] = Method [141] [142] 
.const [46] = Field [143] [144] 
.const [47] = Method [145] [146] 
.const [48] = Method [147] [148] 
.const [49] = Method [149] [150] 
.const [50] = Method [151] [152] 
.const [51] = Method [153] [154] 
.const [52] = Method [155] [156] 
.const [53] = Method [157] [158] 
.const [54] = Method [159] [160] 
.const [55] = Method [161] [162] 
.const [56] = Method [163] [164] 
.const [57] = Method [165] [166] 
.const [58] = Method [167] [168] 
.const [59] = Method [169] [170] 
.const [60] = Method [171] [172] 
.const [61] = Method [173] [174] 
.const [62] = Method [175] [176] 
.const [63] = Method [177] [178] 
.const [64] = Method [179] [180] 
.const [65] = Method [181] [182] 
.const [66] = Method [183] [184] 
.const [67] = Method [185] [186] 
.const [68] = Method [187] [188] 
.const [69] = Method [189] [190] 
.const [70] = Method [191] [192] 
.const [71] = Method [193] [194] 
.const [72] = Method [195] [196] 
.const [73] = Method [197] [198] 
.const [74] = Method [199] [200] 
.const [75] = Method [201] [202] 
.const [76] = Method [203] [204] 
.const [77] = Method [205] [206] 
.const [78] = Method [207] [208] 
.const [79] = Method [209] [210] 
.const [80] = InterfaceMethod [211] [212] 
.const [81] = InterfaceMethod [213] [214] 
.const [82] = InterfaceMethod [215] [216] 
.const [83] = InterfaceMethod [217] [218] 
.const [84] = Field [219] [220] 
.const [85] = Class [221] 
.const [86] = Field [222] [223] 
.const [87] = Class [224] 
.const [88] = Class [225] 
.const [89] = Class [226] 
.const [90] = Class [227] 
.const [91] = Class [228] 
.const [92] = InterfaceMethod [229] [230] 
.const [93] = InterfaceMethod [231] [232] 
.const [94] = Utf8 '[%1.loadFavoriteHeader]' 
.const [95] = Utf8 FavoriteHeaderStorage 
.const [96] = Utf8 '[%1.saveFavoriteHeader]' 
.const [97] = Utf8 '[%1.resetFavoriteHeader]' 
.const [98] = Utf8 java/util/ArrayList 
.const [99] = Utf8 "[%1.getPersistentKey] '%2' '%3'" 
.const [100] = Class [233] 
.const [101] = NameAndType [234] [235] 
.const [102] = Utf8 '[%1.getPersistentKey] Empty list.' 
.const [103] = Utf8 de/audi/app/media/evo/content/data/favorites/persistent/FavoriteHeaderData 
.const [104] = Utf8 '[%1.getNewPersistentKey]' 
.const [105] = Utf8 '[%1.getPersistentKey] Create new header list' 
.const [106] = Class [236] 
.const [107] = NameAndType [237] [238] 
.const [108] = Utf8 "[%1.updateLastUsed] key='%2'" 
.const [109] = Utf8 de/audi/app/media/evo/content/data/favorites/persistent/FavoriteHeaderStorage$1 
.const [110] = Class [239] 
.const [111] = NameAndType [240] [241] 
.const [112] = Utf8 de/audi/atip/storage/ValueMissingException 
.const [113] = Utf8 '[%1.serialize]' 
.const [114] = Utf8 java/io/ObjectOutputStream 
.const [115] = Utf8 '[%1.deserialize]' 
.const [116] = Utf8 java/io/ObjectInputStream 
.const [117] = Utf8 java/lang/ClassNotFoundException 
.const [118] = Utf8 '[%1.deserialize] %2' 
.const [119] = Utf8 'No header data list.' 
.const [120] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [121] = Utf8 "size='" 
.const [122] = Utf8 "' " 
.const [123] = Utf8 '[' 
.const [124] = Utf8 ']\n' 
.const [125] = Utf8 de/audi/app/media/evo/content/data/favorites/persistent/FavoriteHeaderStorage 
.const [126] = Utf8 de/audi/atip/storage/AbstractStorageDataContainer 
.const [127] = Utf8 de/audi/app/media/IMediaTerminal 
.const [128] = Utf8 de/audi/atip/base/IFrameworkAccess 
.const [129] = Utf8 de/audi/app/media/logger/IMediaLogger 
.const [130] = Utf8 de/audi/atip/log/LogChannel 
.const [131] = Utf8 java/lang/Integer 
.const [132] = Utf8 java/lang/String 
.const [133] = Utf8 java/util/Collections 
.const [134] = Utf8 java/util/Iterator 
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
.const [177] = Class [305] 
.const [178] = NameAndType [306] [307] 
.const [179] = Class [308] 
.const [180] = NameAndType [309] [310] 
.const [181] = Class [311] 
.const [182] = NameAndType [312] [313] 
.const [183] = Class [314] 
.const [184] = NameAndType [315] [316] 
.const [185] = Class [317] 
.const [186] = NameAndType [318] [319] 
.const [187] = Class [320] 
.const [188] = NameAndType [321] [322] 
.const [189] = Class [323] 
.const [190] = NameAndType [324] [325] 
.const [191] = Class [326] 
.const [192] = NameAndType [327] [328] 
.const [193] = Class [329] 
.const [194] = NameAndType [330] [331] 
.const [195] = Class [332] 
.const [196] = NameAndType [333] [334] 
.const [197] = Class [335] 
.const [198] = NameAndType [336] [337] 
.const [199] = Class [338] 
.const [200] = NameAndType [339] [340] 
.const [201] = Class [341] 
.const [202] = NameAndType [342] [343] 
.const [203] = Class [344] 
.const [204] = NameAndType [345] [346] 
.const [205] = Class [347] 
.const [206] = NameAndType [348] [349] 
.const [207] = Class [350] 
.const [208] = NameAndType [351] [352] 
.const [209] = Class [353] 
.const [210] = NameAndType [354] [355] 
.const [211] = Class [356] 
.const [212] = NameAndType [357] [358] 
.const [213] = Class [359] 
.const [214] = NameAndType [360] [361] 
.const [215] = Class [362] 
.const [216] = NameAndType [363] [364] 
.const [217] = Class [365] 
.const [218] = NameAndType [366] [367] 
.const [219] = Class [368] 
.const [220] = NameAndType [369] [370] 
.const [221] = Utf8 java/util/ArrayList 
.const [222] = Class [371] 
.const [223] = NameAndType [372] [373] 
.const [224] = Utf8 de/audi/app/media/evo/content/data/favorites/persistent/FavoriteHeaderData 
.const [225] = Utf8 de/audi/app/media/evo/content/data/favorites/persistent/FavoriteHeaderStorage$1 
.const [226] = Utf8 java/io/ObjectOutputStream 
.const [227] = Utf8 java/io/ObjectInputStream 
.const [228] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [229] = Class [374] 
.const [230] = NameAndType [375] [376] 
.const [231] = Class [377] 
.const [232] = NameAndType [378] [379] 
.const [233] = Utf8 java/lang/Integer 
.const [234] = Utf8 toString 
.const [235] = Utf8 (I)Ljava/lang/String; 
.const [236] = Utf8 de/audi/app/media/evo/content/data/favorites/persistent/FavoriteHeaderStorage 
.const [237] = Utf8 getPersistentKeyByIndex 
.const [238] = Utf8 (I)I 
.const [239] = Utf8 java/util/Collections 
.const [240] = Utf8 sort 
.const [241] = Utf8 (Ljava/util/List;Ljava/util/Comparator;)V 
.const [242] = Utf8 de/audi/app/media/evo/content/data/favorites/persistent/FavoriteHeaderStorage 
.const [243] = Utf8 logger 
.const [244] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [245] = Utf8 de/audi/atip/log/LogChannel 
.const [246] = Utf8 log 
.const [247] = Utf8 (ILjava/lang/String;Ljava/lang/Object;)Z 
.const [248] = Utf8 de/audi/app/media/evo/content/data/favorites/persistent/FavoriteHeaderStorage 
.const [249] = Utf8 readAndDeserialize 
.const [250] = Utf8 ()V 
.const [251] = Utf8 de/audi/app/media/evo/content/data/favorites/persistent/FavoriteHeaderStorage 
.const [252] = Utf8 serializeAndWrite 
.const [253] = Utf8 ()V 
.const [254] = Utf8 de/audi/app/media/evo/content/data/favorites/persistent/FavoriteHeaderStorage 
.const [255] = Utf8 favoriteHeaderDataList 
.const [256] = Utf8 Ljava/util/ArrayList; 
.const [257] = Utf8 de/audi/app/media/evo/content/data/favorites/persistent/FavoriteHeaderStorage 
.const [258] = Utf8 saveFavoriteHeader 
.const [259] = Utf8 ()V 
.const [260] = Utf8 de/audi/atip/log/LogChannel 
.const [261] = Utf8 log 
.const [262] = Utf8 (ILjava/lang/String;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V 
.const [263] = Utf8 java/util/ArrayList 
.const [264] = Utf8 size 
.const [265] = Utf8 ()I 
.const [266] = Utf8 java/util/ArrayList 
.const [267] = Utf8 get 
.const [268] = Utf8 (I)Ljava/lang/Object; 
.const [269] = Utf8 de/audi/app/media/evo/content/data/favorites/persistent/FavoriteHeaderData 
.const [270] = Utf8 getSourceType 
.const [271] = Utf8 ()I 
.const [272] = Utf8 de/audi/app/media/evo/content/data/favorites/persistent/FavoriteHeaderData 
.const [273] = Utf8 getMediaId 
.const [274] = Utf8 ()Ljava/lang/String; 
.const [275] = Utf8 java/lang/String 
.const [276] = Utf8 equals 
.const [277] = Utf8 (Ljava/lang/Object;)Z 
.const [278] = Utf8 de/audi/app/media/evo/content/data/favorites/persistent/FavoriteHeaderData 
.const [279] = Utf8 getPersistentKey 
.const [280] = Utf8 ()I 
.const [281] = Utf8 de/audi/app/media/evo/content/data/favorites/persistent/FavoriteHeaderData 
.const [282] = Utf8 getLastUsed 
.const [283] = Utf8 ()I 
.const [284] = Utf8 java/util/ArrayList 
.const [285] = Utf8 set 
.const [286] = Utf8 (ILjava/lang/Object;)Ljava/lang/Object; 
.const [287] = Utf8 java/util/ArrayList 
.const [288] = Utf8 add 
.const [289] = Utf8 (ILjava/lang/Object;)V 
.const [290] = Utf8 de/audi/atip/log/LogChannel 
.const [291] = Utf8 log 
.const [292] = Utf8 (ILjava/lang/String;Ljava/lang/Object;J)Z 
.const [293] = Utf8 java/util/ArrayList 
.const [294] = Utf8 remove 
.const [295] = Utf8 (I)Ljava/lang/Object; 
.const [296] = Utf8 de/audi/app/media/evo/content/data/favorites/persistent/FavoriteHeaderData 
.const [297] = Utf8 setLastUsed 
.const [298] = Utf8 (I)V 
.const [299] = Utf8 java/io/ObjectOutputStream 
.const [300] = Utf8 writeObject 
.const [301] = Utf8 (Ljava/lang/Object;)V 
.const [302] = Utf8 java/io/ObjectInputStream 
.const [303] = Utf8 readObject 
.const [304] = Utf8 ()Ljava/lang/Object; 
.const [305] = Utf8 de/audi/atip/log/LogChannel 
.const [306] = Utf8 log 
.const [307] = Utf8 (ILjava/lang/String;Ljava/lang/Object;Ljava/lang/Throwable;)Z 
.const [308] = Utf8 de/audi/atip/log/LogChannel 
.const [309] = Utf8 isDebug 
.const [310] = Utf8 ()Z 
.const [311] = Utf8 de/audi/app/media/evo/content/data/favorites/persistent/FavoriteHeaderStorage 
.const [312] = Utf8 toString 
.const [313] = Utf8 ()Ljava/lang/String; 
.const [314] = Utf8 de/audi/atip/log/LogChannel 
.const [315] = Utf8 log 
.const [316] = Utf8 (ILjava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V 
.const [317] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [318] = Utf8 append 
.const [319] = Utf8 (Ljava/lang/String;)Lde/esolutions/fw/util/commons/Buffer; 
.const [320] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [321] = Utf8 append 
.const [322] = Utf8 (I)Lde/esolutions/fw/util/commons/Buffer; 
.const [323] = Utf8 java/util/ArrayList 
.const [324] = Utf8 iterator 
.const [325] = Utf8 ()Ljava/util/Iterator; 
.const [326] = Utf8 de/audi/app/media/evo/content/data/favorites/persistent/FavoriteHeaderData 
.const [327] = Utf8 toString 
.const [328] = Utf8 ()Ljava/lang/String; 
.const [329] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [330] = Utf8 toString 
.const [331] = Utf8 ()Ljava/lang/String; 
.const [332] = Utf8 de/audi/atip/storage/AbstractStorageDataContainer 
.const [333] = Utf8 <init> 
.const [334] = Utf8 (Lde/audi/atip/storage/IStorageAccess;III)V 
.const [335] = Utf8 java/util/ArrayList 
.const [336] = Utf8 <init> 
.const [337] = Utf8 ()V 
.const [338] = Utf8 de/audi/app/media/evo/content/data/favorites/persistent/FavoriteHeaderData 
.const [339] = Utf8 <init> 
.const [340] = Utf8 (IILjava/lang/String;)V 
.const [341] = Utf8 java/util/ArrayList 
.const [342] = Utf8 <init> 
.const [343] = Utf8 (Ljava/util/Collection;)V 
.const [344] = Utf8 de/audi/app/media/evo/content/data/favorites/persistent/FavoriteHeaderStorage$1 
.const [345] = Utf8 <init> 
.const [346] = Utf8 (Lde/audi/app/media/evo/content/data/favorites/persistent/FavoriteHeaderStorage;)V 
.const [347] = Utf8 java/io/ObjectOutputStream 
.const [348] = Utf8 <init> 
.const [349] = Utf8 (Ljava/io/OutputStream;)V 
.const [350] = Utf8 java/io/ObjectInputStream 
.const [351] = Utf8 <init> 
.const [352] = Utf8 (Ljava/io/InputStream;)V 
.const [353] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [354] = Utf8 <init> 
.const [355] = Utf8 (I)V 
.const [356] = Utf8 de/audi/app/media/IMediaTerminal 
.const [357] = Utf8 getFramework 
.const [358] = Utf8 ()Lde/audi/atip/base/IFrameworkAccess; 
.const [359] = Utf8 de/audi/atip/base/IFrameworkAccess 
.const [360] = Utf8 getStorageMgr 
.const [361] = Utf8 ()Lde/audi/atip/storage/IStorageAccess; 
.const [362] = Utf8 de/audi/app/media/IMediaTerminal 
.const [363] = Utf8 getLogger 
.const [364] = Utf8 ()Lde/audi/app/media/logger/IMediaLogger; 
.const [365] = Utf8 de/audi/app/media/logger/IMediaLogger 
.const [366] = Utf8 main 
.const [367] = Utf8 ()Lde/audi/atip/log/LogChannel; 
.const [368] = Utf8 de/audi/app/media/evo/content/data/favorites/persistent/FavoriteHeaderStorage 
.const [369] = Utf8 logger 
.const [370] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [371] = Utf8 de/audi/app/media/evo/content/data/favorites/persistent/FavoriteHeaderStorage 
.const [372] = Utf8 favoriteHeaderDataList 
.const [373] = Utf8 Ljava/util/ArrayList; 
.const [374] = Utf8 java/util/Iterator 
.const [375] = Utf8 hasNext 
.const [376] = Utf8 ()Z 
.const [377] = Utf8 java/util/Iterator 
.const [378] = Utf8 next 
.const [379] = Utf8 ()Ljava/lang/Object; 
.const [380] = Utf8 de/audi/app/media/evo/content/data/favorites/persistent/FavoriteHeaderStorage 
.const [381] = Class [380] 
.const [382] = Utf8 de/audi/atip/storage/AbstractStorageDataContainer 
.const [383] = Class [382] 
.const [384] = Utf8 LOGCLASS 
.const [385] = Utf8 Ljava/lang/String; 
.const [386] = Utf8 logger 
.const [387] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [388] = Utf8 INVALID_PERSISTENT_KEY 
.const [389] = Utf8 I 
.const [390] = Utf8 MAX_HEADER_DATA 
.const [391] = Utf8 I 
.const [392] = Utf8 LIST_LAST_USED 
.const [393] = Utf8 I 
.const [394] = Utf8 favoriteHeaderDataList 
.const [395] = Utf8 Ljava/util/ArrayList; 
.const [396] = Utf8 Code 
.const [397] = Utf8 <init> 
.const [398] = Utf8 (Lde/audi/app/media/IMediaTerminal;)V 
.const [399] = Utf8 loadFavoriteHeader 
.const [400] = Utf8 ()V 
.const [401] = Utf8 saveFavoriteHeader 
.const [402] = Utf8 ()V 
.const [403] = Utf8 resetFavoriteHeader 
.const [404] = Utf8 ()V 
.const [405] = Utf8 getPersistentKey 
.const [406] = Utf8 (ILjava/lang/String;)I 
.const [407] = Utf8 getNewPersistentKey 
.const [408] = Utf8 (ILjava/lang/String;)I 
.const [409] = Utf8 updateLastUsed 
.const [410] = Utf8 (I)V 
.const [411] = Utf8 handleCRC32Error 
.const [412] = Utf8 ()V 
.const [413] = Utf8 handleStorageReadError 
.const [414] = Utf8 (Ljava/lang/Exception;)V 
.const [415] = Utf8 convertContainer 
.const [416] = Utf8 (IILjava/io/DataInputStream;)V 
.const [417] = Utf8 serialize 
.const [418] = Utf8 (Ljava/io/DataOutputStream;)V 
.const [419] = Utf8 deserialize 
.const [420] = Utf8 (Ljava/io/DataInputStream;)V 
.const [421] = Utf8 getPersistentKeyByIndex 
.const [422] = Utf8 (I)I 
.const [423] = Utf8 toString 
.const [424] = Utf8 ()Ljava/lang/String; 
.end class 
