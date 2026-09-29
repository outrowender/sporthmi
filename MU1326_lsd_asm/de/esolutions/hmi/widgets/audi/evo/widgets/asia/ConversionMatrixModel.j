.version 50 0 
.class public super [321] 
.super [323] 
.implements [325] 
.implements [327] 
.implements [329] 
.field private static final [330] [331] 
.field private [332] [333] 
.field private [334] [335] 
.field private [336] [337] 
.field public [338] [339] 
.field private [340] [341] 
.field private final [342] [343] 
.field private [344] [345] 
.field private [346] [347] 

.method public [349] : [350] 
    .attribute [348] .code stack 4 locals 0 
L0:     aload_0 
L1:     invokespecial [37] 
L4:     aload_0 
L5:     new [40] 
L8:     dup 
L9:     iconst_1 
L10:    invokespecial [38] 
L13:    putfield [41] 
L16:    aload_0 
L17:    getstatic [3] 
L20:    putfield [42] 
L23:    aload_0 
L24:    getstatic [4] 
L27:    putfield [43] 
L30:    aload_0 
L31:    iconst_0 
L32:    putfield [44] 
L35:    return 
L36:    
    .end code 
.end method 

.method public [351] : [352] 
    .attribute [348] .code stack 3 locals 3 
L0:     iconst_0 
L1:     istore_2 
L2:     aload_0 
L3:     getfield [26] 
L6:     invokeinterface [45] 0 
L11:    ifne L59 
L14:    aload_0 
L15:    getfield [26] 
L18:    invokeinterface [46] 0 
L23:    istore_3 
L24:    iconst_0 
L25:    istore 4 
L27:    iload 4 
L29:    iload_3 
L30:    if_icmpge L59 
L33:    aload_1 
L34:    aload_0 
L35:    getfield [26] 
L38:    iload 4 
L40:    invokeinterface [47] 0 
L45:    if_acmpne L53 
L48:    iconst_1 
L49:    istore_2 
L50:    goto L59 
L53:    iinc 4 1 
L56:    goto L27 
L59:    iload_2 
L60:    ifne L74 
L63:    aload_0 
L64:    getfield [26] 
L67:    aload_1 
L68:    invokeinterface [48] 0 
L73:    pop 
L74:    return 
L75:    nop 
L76:    
    .end code 
.end method 

.method public [353] : [354] 
    .attribute [348] .code stack 3 locals 2 
L0:     aload_0 
L1:     getfield [26] 
L4:     invokeinterface [45] 0 
L9:     ifne L63 
L12:    aload_0 
L13:    getfield [26] 
L16:    invokeinterface [46] 0 
L21:    istore_2 
L22:    iconst_0 
L23:    istore_3 
L24:    iload_3 
L25:    iload_2 
L26:    if_icmpge L63 
L29:    aload_1 
L30:    aload_0 
L31:    getfield [26] 
L34:    iload_3 
L35:    invokeinterface [47] 0 
L40:    if_acmpne L57 
L43:    aload_0 
L44:    getfield [26] 
L47:    iload_3 
L48:    invokeinterface [49] 0 
L53:    pop 
L54:    goto L63 
L57:    iinc 3 1 
L60:    goto L24 
L63:    return 
L64:    
    .end code 
.end method 

.method public [355] : [356] 
    .attribute [348] .code stack 6 locals 2 
L0:     aload_0 
L1:     aload_2 
L2:     putfield [50] 
L5:     aload_0 
L6:     getfield [31] 
L9:     astore_3 
L10:    aload_0 
L11:    aload_1 
L12:    putfield [51] 
L15:    aload_0 
L16:    getfield [32] 
L19:    ifnull L62 
L22:    aload_1 
L23:    invokestatic [5] 
L26:    ifeq L39 
L29:    aload_0 
L30:    getfield [32] 
L33:    instanceof [6] 
L36:    ifeq L62 
L39:    aload_3 
L40:    aload_1 
L41:    invokestatic [7] 
L44:    istore 4 
L46:    aload_0 
L47:    getfield [32] 
L50:    aload_1 
L51:    iload 4 
L53:    iconst_0 
L54:    ldc [8] 
L56:    iconst_0 
L57:    invokeinterface [53] 0 
L62:    return 
L63:    nop 
L64:    
    .end code 
.end method 

.method public [357] : [358] 
    .attribute [348] .code stack 3 locals 2 
L0:     aload_0 
L1:     getfield [33] 
L4:     ifnull L17 
L7:     aload_0 
L8:     getfield [33] 
L11:    aload_1 
L12:    invokeinterface [55] 0 
L17:    aload_0 
L18:    getfield [26] 
L21:    invokeinterface [45] 0 
L26:    ifne L71 
L29:    aload_0 
L30:    getfield [26] 
L33:    invokeinterface [56] 0 
L38:    astore_3 
L39:    aload_3 
L40:    invokeinterface [57] 0 
L45:    ifeq L71 
L48:    aload_3 
L49:    invokeinterface [58] 0 
L54:    checkcast [9] 
L57:    astore 4 
L59:    aload 4 
L61:    aload_1 
L62:    iload_2 
L63:    invokeinterface [59] 0 
L68:    goto L39 
L71:    return 
L72:    
    .end code 
.end method 

.method public interface [359] : [360] 
    .attribute [348] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [31] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [361] : [362] 
    .attribute [348] .code stack 2 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     putfield [54] 
L5:     return 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [363] : [364] 
    .attribute [348] .code stack 2 locals 1 
L0:     aconst_null 
L1:     aload_0 
L2:     getfield [26] 
L5:     if_acmpeq L60 
L8:     aload_0 
L9:     getfield [26] 
L12:    invokeinterface [45] 0 
L17:    ifne L60 
L20:    iconst_0 
L21:    istore_2 
L22:    iload_2 
L23:    aload_0 
L24:    getfield [26] 
L27:    invokeinterface [46] 0 
L32:    if_icmpge L60 
L35:    aload_0 
L36:    getfield [26] 
L39:    iload_2 
L40:    invokeinterface [47] 0 
L45:    checkcast [9] 
L48:    aload_1 
L49:    invokeinterface [60] 0 
L54:    iinc 2 1 
L57:    goto L22 
L60:    return 
L61:    nop 
L62:    nop 
L63:    nop 
L64:    
    .end code 
.end method 

.method public [365] : [366] 
    .attribute [348] .code stack 2 locals 0 
L0:     aload_1 
L1:     ifnull L16 
L4:     aload_1 
L5:     aload_0 
L6:     invokeinterface [61] 0 
L11:    aload_0 
L12:    aload_1 
L13:    putfield [52] 
L16:    return 
L17:    nop 
L18:    nop 
L19:    nop 
L20:    
    .end code 
.end method 

.method public [367] : [368] 
    .attribute [348] .code stack 6 locals 0 
L0:     aload_0 
L1:     getfield [28] 
L4:     invokevirtual [34] 
L7:     ifeq L27 
L10:    aload_0 
L11:    getfield [28] 
L14:    ldc [10] 
L16:    ldc [11] 
L18:    aload_1 
L19:    aload_0 
L20:    invokevirtual [35] 
L23:    aload_2 
L24:    invokevirtual [36] 
L27:    aload_0 
L28:    aload_2 
L29:    putfield [42] 
L32:    aload_0 
L33:    getfield [33] 
L36:    ifnull L53 
L39:    aload_2 
L40:    ifnull L53 
L43:    aload_0 
L44:    getfield [33] 
L47:    aload_2 
L48:    invokeinterface [62] 0 
L53:    aconst_null 
L54:    aload_0 
L55:    getfield [30] 
L58:    if_acmpeq L101 
L61:    aconst_null 
L62:    aload_2 
L63:    if_acmpeq L87 
L66:    aload_2 
L67:    invokeinterface [45] 0 
L72:    ifne L87 
L75:    aload_0 
L76:    getfield [30] 
L79:    invokeinterface [63] 0 
L84:    goto L96 
L87:    aload_0 
L88:    getfield [30] 
L91:    invokeinterface [64] 0 
L96:    aload_0 
L97:    aconst_null 
L98:    putfield [50] 
L101:   return 
L102:   nop 
L103:   nop 
L104:   
    .end code 
.end method 

.method public [369] : [370] 
    .attribute [348] .code stack 2 locals 0 
L0:     aload_0 
L1:     aconst_null 
L2:     putfield [50] 
L5:     return 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public enum [371] : [372] 
    .attribute [348] .code stack 0 locals 0 
L0:     return 
L1:     nop 
L2:     nop 
L3:     nop 
L4:     
    .end code 
.end method 

.method public [373] : [374] 
    .attribute [348] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [27] 
L4:     invokestatic [12] 
L7:     areturn 
L8:     
    .end code 
.end method 

.method public [375] : [376] 
    .attribute [348] .code stack 2 locals 0 
L0:     aload_1 
L1:     ifnull L12 
L4:     aload_1 
L5:     aload_0 
L6:     invokeinterface [65] 0 
L11:    pop 
L12:    aload_0 
L13:    aconst_null 
L14:    putfield [52] 
L17:    return 
L18:    nop 
L19:    nop 
L20:    
    .end code 
.end method 

.method public [377] : [378] 
    .attribute [348] .code stack 2 locals 0 
L0:     aload_0 
L1:     getfield [33] 
L4:     ifnull L17 
L7:     aload_0 
L8:     getfield [33] 
L11:    iconst_1 
L12:    invokeinterface [66] 0 
L17:    return 
L18:    nop 
L19:    nop 
L20:    
    .end code 
.end method 

.method public [379] : [380] 
    .attribute [348] .code stack 2 locals 0 
L0:     aload_0 
L1:     getfield [33] 
L4:     ifnull L17 
L7:     aload_0 
L8:     getfield [33] 
L11:    iconst_0 
L12:    invokeinterface [66] 0 
L17:    return 
L18:    nop 
L19:    nop 
L20:    
    .end code 
.end method 

.method public [381] : [382] 
    .attribute [348] .code stack 1 locals 0 
L0:     getstatic [13] 
L3:     areturn 
L4:     
    .end code 
.end method 

.method public enum [383] : [384] 
    .attribute [348] .code stack 0 locals 0 
L0:     return 
L1:     nop 
L2:     nop 
L3:     nop 
L4:     
    .end code 
.end method 

.method public [385] : [386] 
    .attribute [348] .code stack 2 locals 0 
L0:     aload_0 
L1:     iload_1 
L2:     putfield [44] 
L5:     return 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public interface [387] : [388] 
    .attribute [348] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [29] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [389] : [390] 
    .attribute [348] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [26] 
L4:     invokeinterface [45] 0 
L9:     ifne L21 
L12:    aload_0 
L13:    getfield [26] 
L16:    invokeinterface [67] 0 
L21:    return 
L22:    nop 
L23:    nop 
L24:    
    .end code 
.end method 

.method public [391] : [392] 
    .attribute [348] .code stack 2 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     putfield [51] 
L5:     return 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public enum [393] : [394] 
    .attribute [348] .code stack 0 locals 0 
L0:     return 
L1:     nop 
L2:     nop 
L3:     nop 
L4:     
    .end code 
.end method 

.method public enum [395] : [396] 
    .attribute [348] .code stack 0 locals 0 
L0:     return 
L1:     nop 
L2:     nop 
L3:     nop 
L4:     
    .end code 
.end method 

.method static [397] : [398] 
    .attribute [348] .code stack 4 locals 0 
L0:     iconst_1 
L1:     newarray int 
L3:     dup 
L4:     iconst_0 
L5:     bipush 119 
L7:     iastore 
L8:     putstatic [39] 
L11:    return 
L12:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [68] 
.const [3] = Field [69] [70] 
.const [4] = Field [71] [72] 
.const [5] = Method [73] [74] 
.const [6] = Class [75] 
.const [7] = Method [76] [77] 
.const [8] = Int -129 
.const [9] = Class [78] 
.const [10] = Int -2137614336 
.const [11] = String [79] 
.const [12] = Method [80] [81] 
.const [13] = Field [82] [83] 
.const [14] = Class [84] 
.const [15] = Class [85] 
.const [16] = Class [86] 
.const [17] = Class [87] 
.const [18] = Class [88] 
.const [19] = Class [89] 
.const [20] = Class [90] 
.const [21] = Class [91] 
.const [22] = Class [92] 
.const [23] = Class [93] 
.const [24] = Class [94] 
.const [25] = Class [95] 
.const [26] = Field [96] [97] 
.const [27] = Field [98] [99] 
.const [28] = Field [100] [101] 
.const [29] = Field [102] [103] 
.const [30] = Field [104] [105] 
.const [31] = Field [106] [107] 
.const [32] = Field [108] [109] 
.const [33] = Field [110] [111] 
.const [34] = Method [112] [113] 
.const [35] = Method [114] [115] 
.const [36] = Method [116] [117] 
.const [37] = Method [118] [119] 
.const [38] = Method [120] [121] 
.const [39] = Field [122] [123] 
.const [40] = Class [124] 
.const [41] = Field [125] [126] 
.const [42] = Field [127] [128] 
.const [43] = Field [129] [130] 
.const [44] = Field [131] [132] 
.const [45] = InterfaceMethod [133] [134] 
.const [46] = InterfaceMethod [135] [136] 
.const [47] = InterfaceMethod [137] [138] 
.const [48] = InterfaceMethod [139] [140] 
.const [49] = InterfaceMethod [141] [142] 
.const [50] = Field [143] [144] 
.const [51] = Field [145] [146] 
.const [52] = Field [147] [148] 
.const [53] = InterfaceMethod [149] [150] 
.const [54] = Field [151] [152] 
.const [55] = InterfaceMethod [153] [154] 
.const [56] = InterfaceMethod [155] [156] 
.const [57] = InterfaceMethod [157] [158] 
.const [58] = InterfaceMethod [159] [160] 
.const [59] = InterfaceMethod [161] [162] 
.const [60] = InterfaceMethod [163] [164] 
.const [61] = InterfaceMethod [165] [166] 
.const [62] = InterfaceMethod [167] [168] 
.const [63] = InterfaceMethod [169] [170] 
.const [64] = InterfaceMethod [171] [172] 
.const [65] = InterfaceMethod [173] [174] 
.const [66] = InterfaceMethod [175] [176] 
.const [67] = InterfaceMethod [177] [178] 
.const [68] = Utf8 java/util/ArrayList 
.const [69] = Class [179] 
.const [70] = NameAndType [180] [181] 
.const [71] = Class [182] 
.const [72] = NameAndType [183] [184] 
.const [73] = Class [185] 
.const [74] = NameAndType [186] [187] 
.const [75] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/asia/ConversionDataFetcherWordPrediction 
.const [76] = Class [188] 
.const [77] = NameAndType [189] [190] 
.const [78] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/asia/IConversionCandidateSelectionHandler 
.const [79] = Utf8 'ConversionMatrixModel#onConversionAvailableChange rawInput = %1 UnconvertedCharacters = %2 conversion = %3' 
.const [80] = Class [191] 
.const [81] = NameAndType [192] [193] 
.const [82] = Class [194] 
.const [83] = NameAndType [195] [196] 
.const [84] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/asia/ConversionMatrixModel 
.const [85] = Utf8 java/lang/Object 
.const [86] = Utf8 java/util/Collections 
.const [87] = Utf8 de/esolutions/hmi/widgets/audi/base/IWidgetLogChannel 
.const [88] = Utf8 java/util/List 
.const [89] = Utf8 de/audi/atip/util/StringUtilities 
.const [90] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/TouchControllerListenerFactory 
.const [91] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/asia/IConversionDataFetcher 
.const [92] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/asia/IConversionMatrixModelUpdateHandler 
.const [93] = Utf8 java/util/Iterator 
.const [94] = Utf8 de/audi/atip/log/LogChannel 
.const [95] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/asia/IConversionMatrixPreparationFinishedListener 
.const [96] = Class [197] 
.const [97] = NameAndType [198] [199] 
.const [98] = Class [200] 
.const [99] = NameAndType [201] [202] 
.const [100] = Class [203] 
.const [101] = NameAndType [204] [205] 
.const [102] = Class [206] 
.const [103] = NameAndType [207] [208] 
.const [104] = Class [209] 
.const [105] = NameAndType [210] [211] 
.const [106] = Class [212] 
.const [107] = NameAndType [213] [214] 
.const [108] = Class [215] 
.const [109] = NameAndType [216] [217] 
.const [110] = Class [218] 
.const [111] = NameAndType [219] [220] 
.const [112] = Class [221] 
.const [113] = NameAndType [222] [223] 
.const [114] = Class [224] 
.const [115] = NameAndType [225] [226] 
.const [116] = Class [227] 
.const [117] = NameAndType [228] [229] 
.const [118] = Class [230] 
.const [119] = NameAndType [231] [232] 
.const [120] = Class [233] 
.const [121] = NameAndType [234] [235] 
.const [122] = Class [236] 
.const [123] = NameAndType [237] [238] 
.const [124] = Utf8 java/util/ArrayList 
.const [125] = Class [239] 
.const [126] = NameAndType [240] [241] 
.const [127] = Class [242] 
.const [128] = NameAndType [243] [244] 
.const [129] = Class [245] 
.const [130] = NameAndType [246] [247] 
.const [131] = Class [248] 
.const [132] = NameAndType [249] [250] 
.const [133] = Class [251] 
.const [134] = NameAndType [252] [253] 
.const [135] = Class [254] 
.const [136] = NameAndType [255] [256] 
.const [137] = Class [257] 
.const [138] = NameAndType [258] [259] 
.const [139] = Class [260] 
.const [140] = NameAndType [261] [262] 
.const [141] = Class [263] 
.const [142] = NameAndType [264] [265] 
.const [143] = Class [266] 
.const [144] = NameAndType [267] [268] 
.const [145] = Class [269] 
.const [146] = NameAndType [270] [271] 
.const [147] = Class [272] 
.const [148] = NameAndType [273] [274] 
.const [149] = Class [275] 
.const [150] = NameAndType [276] [277] 
.const [151] = Class [278] 
.const [152] = NameAndType [279] [280] 
.const [153] = Class [281] 
.const [154] = NameAndType [282] [283] 
.const [155] = Class [284] 
.const [156] = NameAndType [285] [286] 
.const [157] = Class [287] 
.const [158] = NameAndType [288] [289] 
.const [159] = Class [290] 
.const [160] = NameAndType [291] [292] 
.const [161] = Class [293] 
.const [162] = NameAndType [294] [295] 
.const [163] = Class [296] 
.const [164] = NameAndType [297] [298] 
.const [165] = Class [299] 
.const [166] = NameAndType [300] [301] 
.const [167] = Class [302] 
.const [168] = NameAndType [303] [304] 
.const [169] = Class [305] 
.const [170] = NameAndType [306] [307] 
.const [171] = Class [308] 
.const [172] = NameAndType [309] [310] 
.const [173] = Class [311] 
.const [174] = NameAndType [312] [313] 
.const [175] = Class [314] 
.const [176] = NameAndType [315] [316] 
.const [177] = Class [317] 
.const [178] = NameAndType [318] [319] 
.const [179] = Utf8 java/util/Collections 
.const [180] = Utf8 EMPTY_LIST 
.const [181] = Utf8 Ljava/util/List; 
.const [182] = Utf8 de/esolutions/hmi/widgets/audi/base/IWidgetLogChannel 
.const [183] = Utf8 tpLogChannelInternal 
.const [184] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [185] = Utf8 de/audi/atip/util/StringUtilities 
.const [186] = Utf8 isNullOrEmpty 
.const [187] = Utf8 (Ljava/lang/CharSequence;)Z 
.const [188] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/TouchControllerListenerFactory 
.const [189] = Utf8 calculateLastInputChar 
.const [190] = Utf8 (Ljava/lang/String;Ljava/lang/String;)C 
.const [191] = Utf8 java/util/Collections 
.const [192] = Utf8 unmodifiableList 
.const [193] = Utf8 (Ljava/util/List;)Ljava/util/List; 
.const [194] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/asia/ConversionMatrixModel 
.const [195] = Utf8 PARTIAL_POPUP_IDS_TO_LISTEN_FOR 
.const [196] = Utf8 [I 
.const [197] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/asia/ConversionMatrixModel 
.const [198] = Utf8 registeredSelectionHandlers 
.const [199] = Utf8 Ljava/util/List; 
.const [200] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/asia/ConversionMatrixModel 
.const [201] = Utf8 conversionlist 
.const [202] = Utf8 Ljava/util/List; 
.const [203] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/asia/ConversionMatrixModel 
.const [204] = Utf8 logChannel 
.const [205] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [206] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/asia/ConversionMatrixModel 
.const [207] = Utf8 isActive 
.const [208] = Utf8 Z 
.const [209] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/asia/ConversionMatrixModel 
.const [210] = Utf8 finishedListener 
.const [211] = Utf8 Lde/esolutions/hmi/widgets/audi/evo/widgets/asia/IConversionMatrixPreparationFinishedListener; 
.const [212] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/asia/ConversionMatrixModel 
.const [213] = Utf8 currentUnconvertedCharacters 
.const [214] = Utf8 Ljava/lang/String; 
.const [215] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/asia/ConversionMatrixModel 
.const [216] = Utf8 conversionFetcher 
.const [217] = Utf8 Lde/esolutions/hmi/widgets/audi/evo/widgets/asia/IConversionDataFetcher; 
.const [218] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/asia/ConversionMatrixModel 
.const [219] = Utf8 updateHandler 
.const [220] = Utf8 Lde/esolutions/hmi/widgets/audi/evo/widgets/asia/IConversionMatrixModelUpdateHandler; 
.const [221] = Utf8 de/audi/atip/log/LogChannel 
.const [222] = Utf8 isDebug 
.const [223] = Utf8 ()Z 
.const [224] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/asia/ConversionMatrixModel 
.const [225] = Utf8 getUnconvertedCharacters 
.const [226] = Utf8 ()Ljava/lang/String; 
.const [227] = Utf8 de/audi/atip/log/LogChannel 
.const [228] = Utf8 log 
.const [229] = Utf8 (ILjava/lang/String;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V 
.const [230] = Utf8 java/lang/Object 
.const [231] = Utf8 <init> 
.const [232] = Utf8 ()V 
.const [233] = Utf8 java/util/ArrayList 
.const [234] = Utf8 <init> 
.const [235] = Utf8 (I)V 
.const [236] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/asia/ConversionMatrixModel 
.const [237] = Utf8 PARTIAL_POPUP_IDS_TO_LISTEN_FOR 
.const [238] = Utf8 [I 
.const [239] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/asia/ConversionMatrixModel 
.const [240] = Utf8 registeredSelectionHandlers 
.const [241] = Utf8 Ljava/util/List; 
.const [242] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/asia/ConversionMatrixModel 
.const [243] = Utf8 conversionlist 
.const [244] = Utf8 Ljava/util/List; 
.const [245] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/asia/ConversionMatrixModel 
.const [246] = Utf8 logChannel 
.const [247] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [248] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/asia/ConversionMatrixModel 
.const [249] = Utf8 isActive 
.const [250] = Utf8 Z 
.const [251] = Utf8 java/util/List 
.const [252] = Utf8 isEmpty 
.const [253] = Utf8 ()Z 
.const [254] = Utf8 java/util/List 
.const [255] = Utf8 size 
.const [256] = Utf8 ()I 
.const [257] = Utf8 java/util/List 
.const [258] = Utf8 get 
.const [259] = Utf8 (I)Ljava/lang/Object; 
.const [260] = Utf8 java/util/List 
.const [261] = Utf8 add 
.const [262] = Utf8 (Ljava/lang/Object;)Z 
.const [263] = Utf8 java/util/List 
.const [264] = Utf8 remove 
.const [265] = Utf8 (I)Ljava/lang/Object; 
.const [266] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/asia/ConversionMatrixModel 
.const [267] = Utf8 finishedListener 
.const [268] = Utf8 Lde/esolutions/hmi/widgets/audi/evo/widgets/asia/IConversionMatrixPreparationFinishedListener; 
.const [269] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/asia/ConversionMatrixModel 
.const [270] = Utf8 currentUnconvertedCharacters 
.const [271] = Utf8 Ljava/lang/String; 
.const [272] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/asia/ConversionMatrixModel 
.const [273] = Utf8 conversionFetcher 
.const [274] = Utf8 Lde/esolutions/hmi/widgets/audi/evo/widgets/asia/IConversionDataFetcher; 
.const [275] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/asia/IConversionDataFetcher 
.const [276] = Utf8 requestConversions 
.const [277] = Utf8 (Ljava/lang/String;CIIZ)V 
.const [278] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/asia/ConversionMatrixModel 
.const [279] = Utf8 updateHandler 
.const [280] = Utf8 Lde/esolutions/hmi/widgets/audi/evo/widgets/asia/IConversionMatrixModelUpdateHandler; 
.const [281] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/asia/IConversionMatrixModelUpdateHandler 
.const [282] = Utf8 candidateSelected 
.const [283] = Utf8 (Ljava/lang/String;)V 
.const [284] = Utf8 java/util/List 
.const [285] = Utf8 iterator 
.const [286] = Utf8 ()Ljava/util/Iterator; 
.const [287] = Utf8 java/util/Iterator 
.const [288] = Utf8 hasNext 
.const [289] = Utf8 ()Z 
.const [290] = Utf8 java/util/Iterator 
.const [291] = Utf8 next 
.const [292] = Utf8 ()Ljava/lang/Object; 
.const [293] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/asia/IConversionCandidateSelectionHandler 
.const [294] = Utf8 acceptConversionCandidateSelection 
.const [295] = Utf8 (Ljava/lang/String;I)V 
.const [296] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/asia/IConversionCandidateSelectionHandler 
.const [297] = Utf8 acceptKeyEventInConversionMatrix 
.const [298] = Utf8 (Lde/audi/atip/hmi/event/KeyEvent;)V 
.const [299] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/asia/IConversionDataFetcher 
.const [300] = Utf8 registerConversionFetcherListener 
.const [301] = Utf8 (Lde/esolutions/hmi/widgets/audi/evo/widgets/asia/IConversionDataFetcherListener;)V 
.const [302] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/asia/IConversionMatrixModelUpdateHandler 
.const [303] = Utf8 sourceDataChanged 
.const [304] = Utf8 (Ljava/util/List;)V 
.const [305] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/asia/IConversionMatrixPreparationFinishedListener 
.const [306] = Utf8 matrixPreparationFinished 
.const [307] = Utf8 ()V 
.const [308] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/asia/IConversionMatrixPreparationFinishedListener 
.const [309] = Utf8 keepCloseMatrix 
.const [310] = Utf8 ()V 
.const [311] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/asia/IConversionDataFetcher 
.const [312] = Utf8 unregisterConversionFetcherListener 
.const [313] = Utf8 (Lde/esolutions/hmi/widgets/audi/evo/widgets/asia/IConversionDataFetcherListener;)Z 
.const [314] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/asia/IConversionMatrixModelUpdateHandler 
.const [315] = Utf8 onPopupVisibilityChange 
.const [316] = Utf8 (Z)V 
.const [317] = Utf8 java/util/List 
.const [318] = Utf8 clear 
.const [319] = Utf8 ()V 
.const [320] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/asia/ConversionMatrixModel 
.const [321] = Class [320] 
.const [322] = Utf8 java/lang/Object 
.const [323] = Class [322] 
.const [324] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/asia/IConversionMatrixModel 
.const [325] = Class [324] 
.const [326] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/asia/IConversionDataFetcherListener 
.const [327] = Class [326] 
.const [328] = Utf8 de/audi/atip/hmi/view/IPartialPopupListener 
.const [329] = Class [328] 
.const [330] = Utf8 PARTIAL_POPUP_IDS_TO_LISTEN_FOR 
.const [331] = Utf8 [I 
.const [332] = Utf8 registeredSelectionHandlers 
.const [333] = Utf8 Ljava/util/List; 
.const [334] = Utf8 updateHandler 
.const [335] = Utf8 Lde/esolutions/hmi/widgets/audi/evo/widgets/asia/IConversionMatrixModelUpdateHandler; 
.const [336] = Utf8 currentUnconvertedCharacters 
.const [337] = Utf8 Ljava/lang/String; 
.const [338] = Utf8 conversionFetcher 
.const [339] = Utf8 Lde/esolutions/hmi/widgets/audi/evo/widgets/asia/IConversionDataFetcher; 
.const [340] = Utf8 conversionlist 
.const [341] = Utf8 Ljava/util/List; 
.const [342] = Utf8 logChannel 
.const [343] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [344] = Utf8 isActive 
.const [345] = Utf8 Z 
.const [346] = Utf8 finishedListener 
.const [347] = Utf8 Lde/esolutions/hmi/widgets/audi/evo/widgets/asia/IConversionMatrixPreparationFinishedListener; 
.const [348] = Utf8 Code 
.const [349] = Utf8 <init> 
.const [350] = Utf8 ()V 
.const [351] = Utf8 registerConversionCandidateSelectionHandler 
.const [352] = Utf8 (Lde/esolutions/hmi/widgets/audi/evo/widgets/asia/IConversionCandidateSelectionHandler;)V 
.const [353] = Utf8 unRegisterConversionCandidateSelectionHandler 
.const [354] = Utf8 (Lde/esolutions/hmi/widgets/audi/evo/widgets/asia/IConversionCandidateSelectionHandler;)V 
.const [355] = Utf8 setUnconvertedCharacters 
.const [356] = Utf8 (Ljava/lang/String;Lde/esolutions/hmi/widgets/audi/evo/widgets/asia/IConversionMatrixPreparationFinishedListener;)V 
.const [357] = Utf8 setSelected 
.const [358] = Utf8 (Ljava/lang/String;I)V 
.const [359] = Utf8 getUnconvertedCharacters 
.const [360] = Utf8 ()Ljava/lang/String; 
.const [361] = Utf8 setUpdateHandler 
.const [362] = Utf8 (Lde/esolutions/hmi/widgets/audi/evo/widgets/asia/IConversionMatrixModelUpdateHandler;)V 
.const [363] = Utf8 handleMatrixKeyEvent 
.const [364] = Utf8 (Lde/audi/atip/hmi/event/KeyEvent;)V 
.const [365] = Utf8 setConversionDataFetcher 
.const [366] = Utf8 (Lde/esolutions/hmi/widgets/audi/evo/widgets/asia/IConversionDataFetcher;)V 
.const [367] = Utf8 onConversionAvailableChange 
.const [368] = Utf8 (Ljava/lang/String;Ljava/util/List;)V 
.const [369] = Utf8 removeConversionMatrixPreparationFinishedListener 
.const [370] = Utf8 ()V 
.const [371] = Utf8 onNextValidCharactersChange 
.const [372] = Utf8 (Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V 
.const [373] = Utf8 getConversionData 
.const [374] = Utf8 ()Ljava/util/List; 
.const [375] = Utf8 removeConversionFetcher 
.const [376] = Utf8 (Lde/esolutions/hmi/widgets/audi/evo/widgets/asia/IConversionDataFetcher;)V 
.const [377] = Utf8 partialPopupVisible 
.const [378] = Utf8 (II)V 
.const [379] = Utf8 partialPopupHidden 
.const [380] = Utf8 (II)V 
.const [381] = Utf8 getPPIDsForCallbacks 
.const [382] = Utf8 ()[I 
.const [383] = Utf8 partialPopupRemoved 
.const [384] = Utf8 (II)V 
.const [385] = Utf8 setIsActivated 
.const [386] = Utf8 (Z)V 
.const [387] = Utf8 isActivated 
.const [388] = Utf8 ()Z 
.const [389] = Utf8 unRegisterAllConversionCandidateSelectionHandler 
.const [390] = Utf8 ()V 
.const [391] = Utf8 updateUnconvertedChars 
.const [392] = Utf8 (Ljava/lang/String;)V 
.const [393] = Utf8 partialPopupListenerRegistered 
.const [394] = Utf8 (IIZ)V 
.const [395] = Utf8 informAboutPPCoordinates 
.const [396] = Utf8 (IIIIII)V 
.const [397] = Utf8 <clinit> 
.const [398] = Utf8 ()V 
.end class 
