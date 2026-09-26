.version 50 0 
.class public super [297] 
.super [299] 
.implements [301] 
.implements [303] 
.field private [304] [305] 
.field private [306] [307] 
.field private [308] [309] 
.field private [310] [311] 
.field private [312] [313] 
.field private [314] [315] 
.field private [316] [317] 

.method public [319] : [320] 
    .attribute [318] .code stack 5 locals 0 
L0:     aload_0 
L1:     invokespecial [39] 
L4:     aload_0 
L5:     iload_3 
L6:     putfield [46] 
L9:     aload_0 
L10:    aload_2 
L11:    putfield [47] 
L14:    aload_0 
L15:    aload_1 
L16:    checkcast [2] 
L19:    putfield [48] 
L22:    aload_0 
L23:    invokevirtual [22] 
L26:    aload_0 
L27:    new [49] 
L30:    dup 
L31:    aload_0 
L32:    getfield [21] 
L35:    invokeinterface [50] 0 
L40:    i2f 
L41:    aload_0 
L42:    getfield [21] 
L45:    invokeinterface [51] 0 
L50:    i2f 
L51:    invokespecial [40] 
L54:    putfield [52] 
L57:    return 
L58:    nop 
L59:    nop 
L60:    
    .end code 
.end method 

.method public [321] : [322] 
    .attribute [318] .code stack 1 locals 0 
L0:     aload_0 
L1:     invokespecial [41] 
L4:     aload_0 
L5:     invokespecial [42] 
L8:     return 
L9:     nop 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method private [323] : [324] 
    .attribute [318] .code stack 5 locals 2 
L0:     aload_0 
L1:     getfield [21] 
L4:     invokeinterface [53] 0 
L9:     aload_0 
L10:    getfield [21] 
L13:    invokeinterface [54] 0 
L18:    isub 
L19:    i2f 
L20:    fstore_1 
L21:    aload_0 
L22:    getfield [21] 
L25:    invokeinterface [55] 0 
L30:    aload_0 
L31:    getfield [21] 
L34:    invokeinterface [56] 0 
L39:    isub 
L40:    i2f 
L41:    fstore_2 
L42:    aload_0 
L43:    new [49] 
L46:    dup 
L47:    fload_1 
L48:    fload_2 
L49:    invokespecial [40] 
L52:    putfield [57] 
L55:    aload_0 
L56:    new [49] 
L59:    dup 
L60:    aload_0 
L61:    getfield [21] 
L64:    invokeinterface [54] 0 
L69:    i2f 
L70:    aload_0 
L71:    getfield [21] 
L74:    invokeinterface [56] 0 
L79:    i2f 
L80:    invokespecial [40] 
L83:    putfield [58] 
L86:    aload_0 
L87:    getfield [20] 
L90:    ldc [4] 
L92:    ldc [5] 
L94:    aload_0 
L95:    getfield [24] 
L98:    invokevirtual [26] 
L101:   pop 
L102:   return 
L103:   nop 
L104:   
    .end code 
.end method 

.method private [325] : [326] 
    .attribute [318] .code stack 5 locals 0 
L0:     aload_0 
L1:     new [49] 
L4:     dup 
L5:     aload_0 
L6:     getfield [21] 
L9:     invokeinterface [59] 0 
L14:    i2f 
L15:    aload_0 
L16:    getfield [21] 
L19:    invokeinterface [60] 0 
L24:    i2f 
L25:    invokespecial [40] 
L28:    putfield [61] 
L31:    aload_0 
L32:    aload_0 
L33:    getfield [27] 
L36:    aload_0 
L37:    getfield [24] 
L40:    invokevirtual [28] 
L43:    putfield [61] 
L46:    aload_0 
L47:    getfield [20] 
L50:    ldc [4] 
L52:    ldc [6] 
L54:    aload_0 
L55:    getfield [27] 
L58:    invokevirtual [26] 
L61:    pop 
L62:    return 
L63:    nop 
L64:    
    .end code 
.end method 

.method public [327] : [328] 
    .attribute [318] .code stack 5 locals 1 
L0:     aload_1 
L1:     instanceof [7] 
L4:     ifeq L105 
L7:     aload_1 
L8:     checkcast [7] 
L11:    astore_2 
L12:    aload_2 
L13:    invokevirtual [29] 
L16:    iconst_4 
L17:    if_icmpne L39 
L20:    aload_0 
L21:    invokevirtual [22] 
L24:    aload_0 
L25:    getfield [20] 
L28:    ldc [4] 
L30:    ldc [8] 
L32:    invokevirtual [30] 
L35:    pop 
L36:    goto L105 
L39:    aload_2 
L40:    invokevirtual [29] 
L43:    iconst_1 
L44:    if_icmpne L93 
L47:    aload_0 
L48:    new [49] 
L51:    dup 
L52:    aload_0 
L53:    getfield [21] 
L56:    invokeinterface [50] 0 
L61:    i2f 
L62:    aload_0 
L63:    getfield [21] 
L66:    invokeinterface [51] 0 
L71:    i2f 
L72:    invokespecial [40] 
L75:    putfield [52] 
L78:    aload_0 
L79:    getfield [20] 
L82:    ldc [4] 
L84:    ldc [9] 
L86:    invokevirtual [30] 
L89:    pop 
L90:    goto L105 
L93:    aload_0 
L94:    getfield [20] 
L97:    ldc [10] 
L99:    ldc [11] 
L101:   invokevirtual [30] 
L104:   pop 
L105:   aload_0 
L106:   aload_0 
L107:   getfield [23] 
L110:   invokespecial [43] 
L113:   areturn 
L114:   nop 
L115:   nop 
L116:   
    .end code 
.end method 

.method public [329] : [330] 
    .attribute [318] .code stack 2 locals 0 
L0:     aload_0 
L1:     aload_0 
L2:     getfield [23] 
L5:     invokespecial [43] 
L8:     areturn 
L9:     nop 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method private [331] : [332] 
    .attribute [318] .code stack 5 locals 0 
L0:     aload_1 
L1:     aload_0 
L2:     getfield [24] 
L5:     invokevirtual [28] 
L8:     astore_1 
L9:     aload_1 
L10:    new [49] 
L13:    dup 
L14:    fconst_1 
L15:    ldc [12] 
L17:    invokespecial [40] 
L20:    invokevirtual [31] 
L23:    astore_1 
L24:    aload_1 
L25:    ldc [13] 
L27:    invokevirtual [32] 
L30:    areturn 
L31:    nop 
L32:    
    .end code 
.end method 

.method public [333] : [334] 
    .attribute [318] .code stack 3 locals 0 
L0:     aload_0 
L1:     aload_0 
L2:     aload_1 
L3:     invokespecial [44] 
L6:     putfield [52] 
L9:     aload_0 
L10:    invokespecial [45] 
L13:    return 
L14:    nop 
L15:    nop 
L16:    
    .end code 
.end method 

.method private [335] : [336] 
    .attribute [318] .code stack 5 locals 2 
L0:     aload_1 
L1:     fconst_0 
L2:     fconst_1 
L3:     invokevirtual [33] 
L6:     astore_1 
L7:     aload_1 
L8:     aload_0 
L9:     getfield [24] 
L12:    invokevirtual [31] 
L15:    astore_2 
L16:    aload_0 
L17:    getfield [25] 
L20:    aload_2 
L21:    invokevirtual [34] 
L24:    astore_3 
L25:    aload_3 
L26:    new [49] 
L29:    dup 
L30:    fconst_1 
L31:    ldc [12] 
L33:    invokespecial [40] 
L36:    invokevirtual [31] 
L39:    areturn 
L40:    
    .end code 
.end method 

.method private [337] : [338] 
    .attribute [318] .code stack 4 locals 4 
L0:     new [49] 
L3:     dup 
L4:     aload_0 
L5:     getfield [21] 
L8:     invokeinterface [50] 0 
L13:    i2f 
L14:    aload_0 
L15:    getfield [21] 
L18:    invokeinterface [51] 0 
L23:    i2f 
L24:    invokespecial [40] 
L27:    astore_1 
L28:    aload_1 
L29:    aload_0 
L30:    getfield [23] 
L33:    invokevirtual [35] 
L36:    ifne L81 
L39:    aload_0 
L40:    getfield [23] 
L43:    aload_1 
L44:    invokevirtual [36] 
L47:    astore_2 
L48:    aload_2 
L49:    invokevirtual [37] 
L52:    invokestatic [14] 
L55:    istore_3 
L56:    aload_2 
L57:    invokevirtual [38] 
L60:    invokestatic [14] 
L63:    istore 4 
L65:    aload_0 
L66:    getfield [21] 
L69:    iload_3 
L70:    iload 4 
L72:    aload_0 
L73:    getfield [19] 
L76:    invokeinterface [62] 0 
L81:    return 
L82:    nop 
L83:    nop 
L84:    
    .end code 
.end method 

.method public interface [339] : [340] 
    .attribute [318] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [27] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [63] 
.const [3] = Class [64] 
.const [4] = Int -2137614336 
.const [5] = String [65] 
.const [6] = String [66] 
.const [7] = Class [67] 
.const [8] = String [68] 
.const [9] = String [69] 
.const [10] = Int -1601830656 
.const [11] = String [70] 
.const [12] = Int 32959 
.const [13] = Int 63 
.const [14] = Method [71] [72] 
.const [15] = Class [73] 
.const [16] = Class [74] 
.const [17] = Class [75] 
.const [18] = Class [76] 
.const [19] = Field [77] [78] 
.const [20] = Field [79] [80] 
.const [21] = Field [81] [82] 
.const [22] = Method [83] [84] 
.const [23] = Field [85] [86] 
.const [24] = Field [87] [88] 
.const [25] = Field [89] [90] 
.const [26] = Method [91] [92] 
.const [27] = Field [93] [94] 
.const [28] = Method [95] [96] 
.const [29] = Method [97] [98] 
.const [30] = Method [99] [100] 
.const [31] = Method [101] [102] 
.const [32] = Method [103] [104] 
.const [33] = Method [105] [106] 
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
.const [46] = Field [131] [132] 
.const [47] = Field [133] [134] 
.const [48] = Field [135] [136] 
.const [49] = Class [137] 
.const [50] = InterfaceMethod [138] [139] 
.const [51] = InterfaceMethod [140] [141] 
.const [52] = Field [142] [143] 
.const [53] = InterfaceMethod [144] [145] 
.const [54] = InterfaceMethod [146] [147] 
.const [55] = InterfaceMethod [148] [149] 
.const [56] = InterfaceMethod [150] [151] 
.const [57] = Field [152] [153] 
.const [58] = Field [154] [155] 
.const [59] = InterfaceMethod [156] [157] 
.const [60] = InterfaceMethod [158] [159] 
.const [61] = Field [160] [161] 
.const [62] = InterfaceMethod [162] [163] 
.const [63] = Utf8 de/audi/atip/hmi/modelaccess/RangeModel2DGUI 
.const [64] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/balancefader/ValuePair 
.const [65] = Utf8 'WrappedRangeModel2DGUI#updateModelSize modelSize = %1' 
.const [66] = Utf8 'WrappedRangeModel2DGUI#updateSteps steps = %1' 
.const [67] = Utf8 de/audi/atip/hmi/event/ModelUpdateEvent 
.const [68] = Utf8 'WrappedRangeModel2DGUI#processEvent LIMITS_CHANGED' 
.const [69] = Utf8 'WrappedRangeModel2DGUI#processEvent VALUE_UPDATED' 
.const [70] = Utf8 'WrappedRangeModel2DGUI#processEvent ModelUpdateEvent updateType not supported!' 
.const [71] = Class [164] 
.const [72] = NameAndType [165] [166] 
.const [73] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/balancefader/WrappedRangeModel2DGUI 
.const [74] = Utf8 java/lang/Object 
.const [75] = Utf8 de/audi/atip/log/LogChannel 
.const [76] = Utf8 java/lang/Math 
.const [77] = Class [167] 
.const [78] = NameAndType [168] [169] 
.const [79] = Class [170] 
.const [80] = NameAndType [171] [172] 
.const [81] = Class [173] 
.const [82] = NameAndType [174] [175] 
.const [83] = Class [176] 
.const [84] = NameAndType [177] [178] 
.const [85] = Class [179] 
.const [86] = NameAndType [180] [181] 
.const [87] = Class [182] 
.const [88] = NameAndType [183] [184] 
.const [89] = Class [185] 
.const [90] = NameAndType [186] [187] 
.const [91] = Class [188] 
.const [92] = NameAndType [189] [190] 
.const [93] = Class [191] 
.const [94] = NameAndType [192] [193] 
.const [95] = Class [194] 
.const [96] = NameAndType [195] [196] 
.const [97] = Class [197] 
.const [98] = NameAndType [198] [199] 
.const [99] = Class [200] 
.const [100] = NameAndType [201] [202] 
.const [101] = Class [203] 
.const [102] = NameAndType [204] [205] 
.const [103] = Class [206] 
.const [104] = NameAndType [207] [208] 
.const [105] = Class [209] 
.const [106] = NameAndType [210] [211] 
.const [107] = Class [212] 
.const [108] = NameAndType [213] [214] 
.const [109] = Class [215] 
.const [110] = NameAndType [216] [217] 
.const [111] = Class [218] 
.const [112] = NameAndType [219] [220] 
.const [113] = Class [221] 
.const [114] = NameAndType [222] [223] 
.const [115] = Class [224] 
.const [116] = NameAndType [225] [226] 
.const [117] = Class [227] 
.const [118] = NameAndType [228] [229] 
.const [119] = Class [230] 
.const [120] = NameAndType [231] [232] 
.const [121] = Class [233] 
.const [122] = NameAndType [234] [235] 
.const [123] = Class [236] 
.const [124] = NameAndType [237] [238] 
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
.const [137] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/balancefader/ValuePair 
.const [138] = Class [257] 
.const [139] = NameAndType [258] [259] 
.const [140] = Class [260] 
.const [141] = NameAndType [261] [262] 
.const [142] = Class [263] 
.const [143] = NameAndType [264] [265] 
.const [144] = Class [266] 
.const [145] = NameAndType [267] [268] 
.const [146] = Class [269] 
.const [147] = NameAndType [270] [271] 
.const [148] = Class [272] 
.const [149] = NameAndType [273] [274] 
.const [150] = Class [275] 
.const [151] = NameAndType [276] [277] 
.const [152] = Class [278] 
.const [153] = NameAndType [279] [280] 
.const [154] = Class [281] 
.const [155] = NameAndType [282] [283] 
.const [156] = Class [284] 
.const [157] = NameAndType [285] [286] 
.const [158] = Class [287] 
.const [159] = NameAndType [288] [289] 
.const [160] = Class [290] 
.const [161] = NameAndType [291] [292] 
.const [162] = Class [293] 
.const [163] = NameAndType [294] [295] 
.const [164] = Utf8 java/lang/Math 
.const [165] = Utf8 round 
.const [166] = Utf8 (F)I 
.const [167] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/balancefader/WrappedRangeModel2DGUI 
.const [168] = Utf8 terminalID 
.const [169] = Utf8 I 
.const [170] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/balancefader/WrappedRangeModel2DGUI 
.const [171] = Utf8 lc 
.const [172] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [173] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/balancefader/WrappedRangeModel2DGUI 
.const [174] = Utf8 rangeModel 
.const [175] = Utf8 Lde/audi/atip/hmi/modelaccess/RangeModel2DGUI; 
.const [176] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/balancefader/WrappedRangeModel2DGUI 
.const [177] = Utf8 updateModelSizeAndSteps 
.const [178] = Utf8 ()V 
.const [179] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/balancefader/WrappedRangeModel2DGUI 
.const [180] = Utf8 cachedPosition 
.const [181] = Utf8 Lde/esolutions/hmi/widgets/audi/evo/widgets/balancefader/ValuePair; 
.const [182] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/balancefader/WrappedRangeModel2DGUI 
.const [183] = Utf8 modelSize 
.const [184] = Utf8 Lde/esolutions/hmi/widgets/audi/evo/widgets/balancefader/ValuePair; 
.const [185] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/balancefader/WrappedRangeModel2DGUI 
.const [186] = Utf8 modelMinima 
.const [187] = Utf8 Lde/esolutions/hmi/widgets/audi/evo/widgets/balancefader/ValuePair; 
.const [188] = Utf8 de/audi/atip/log/LogChannel 
.const [189] = Utf8 log 
.const [190] = Utf8 (ILjava/lang/String;Ljava/lang/Object;)Z 
.const [191] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/balancefader/WrappedRangeModel2DGUI 
.const [192] = Utf8 steps 
.const [193] = Utf8 Lde/esolutions/hmi/widgets/audi/evo/widgets/balancefader/ValuePair; 
.const [194] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/balancefader/ValuePair 
.const [195] = Utf8 divideBy 
.const [196] = Utf8 (Lde/esolutions/hmi/widgets/audi/evo/widgets/balancefader/ValuePair;)Lde/esolutions/hmi/widgets/audi/evo/widgets/balancefader/ValuePair; 
.const [197] = Utf8 de/audi/atip/hmi/event/ModelUpdateEvent 
.const [198] = Utf8 getUpdateType 
.const [199] = Utf8 ()I 
.const [200] = Utf8 de/audi/atip/log/LogChannel 
.const [201] = Utf8 log 
.const [202] = Utf8 (ILjava/lang/String;)Z 
.const [203] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/balancefader/ValuePair 
.const [204] = Utf8 multiplyWith 
.const [205] = Utf8 (Lde/esolutions/hmi/widgets/audi/evo/widgets/balancefader/ValuePair;)Lde/esolutions/hmi/widgets/audi/evo/widgets/balancefader/ValuePair; 
.const [206] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/balancefader/ValuePair 
.const [207] = Utf8 add 
.const [208] = Utf8 (F)Lde/esolutions/hmi/widgets/audi/evo/widgets/balancefader/ValuePair; 
.const [209] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/balancefader/ValuePair 
.const [210] = Utf8 clamp 
.const [211] = Utf8 (FF)Lde/esolutions/hmi/widgets/audi/evo/widgets/balancefader/ValuePair; 
.const [212] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/balancefader/ValuePair 
.const [213] = Utf8 add 
.const [214] = Utf8 (Lde/esolutions/hmi/widgets/audi/evo/widgets/balancefader/ValuePair;)Lde/esolutions/hmi/widgets/audi/evo/widgets/balancefader/ValuePair; 
.const [215] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/balancefader/ValuePair 
.const [216] = Utf8 equals 
.const [217] = Utf8 (Ljava/lang/Object;)Z 
.const [218] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/balancefader/ValuePair 
.const [219] = Utf8 subtract 
.const [220] = Utf8 (Lde/esolutions/hmi/widgets/audi/evo/widgets/balancefader/ValuePair;)Lde/esolutions/hmi/widgets/audi/evo/widgets/balancefader/ValuePair; 
.const [221] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/balancefader/ValuePair 
.const [222] = Utf8 getX 
.const [223] = Utf8 ()F 
.const [224] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/balancefader/ValuePair 
.const [225] = Utf8 getY 
.const [226] = Utf8 ()F 
.const [227] = Utf8 java/lang/Object 
.const [228] = Utf8 <init> 
.const [229] = Utf8 ()V 
.const [230] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/balancefader/ValuePair 
.const [231] = Utf8 <init> 
.const [232] = Utf8 (FF)V 
.const [233] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/balancefader/WrappedRangeModel2DGUI 
.const [234] = Utf8 updateModelSize 
.const [235] = Utf8 ()V 
.const [236] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/balancefader/WrappedRangeModel2DGUI 
.const [237] = Utf8 updateSteps 
.const [238] = Utf8 ()V 
.const [239] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/balancefader/WrappedRangeModel2DGUI 
.const [240] = Utf8 normToInterval 
.const [241] = Utf8 (Lde/esolutions/hmi/widgets/audi/evo/widgets/balancefader/ValuePair;)Lde/esolutions/hmi/widgets/audi/evo/widgets/balancefader/ValuePair; 
.const [242] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/balancefader/WrappedRangeModel2DGUI 
.const [243] = Utf8 normToModel 
.const [244] = Utf8 (Lde/esolutions/hmi/widgets/audi/evo/widgets/balancefader/ValuePair;)Lde/esolutions/hmi/widgets/audi/evo/widgets/balancefader/ValuePair; 
.const [245] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/balancefader/WrappedRangeModel2DGUI 
.const [246] = Utf8 updateModel 
.const [247] = Utf8 ()V 
.const [248] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/balancefader/WrappedRangeModel2DGUI 
.const [249] = Utf8 terminalID 
.const [250] = Utf8 I 
.const [251] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/balancefader/WrappedRangeModel2DGUI 
.const [252] = Utf8 lc 
.const [253] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [254] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/balancefader/WrappedRangeModel2DGUI 
.const [255] = Utf8 rangeModel 
.const [256] = Utf8 Lde/audi/atip/hmi/modelaccess/RangeModel2DGUI; 
.const [257] = Utf8 de/audi/atip/hmi/modelaccess/RangeModel2DGUI 
.const [258] = Utf8 getValueX 
.const [259] = Utf8 ()I 
.const [260] = Utf8 de/audi/atip/hmi/modelaccess/RangeModel2DGUI 
.const [261] = Utf8 getValueY 
.const [262] = Utf8 ()I 
.const [263] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/balancefader/WrappedRangeModel2DGUI 
.const [264] = Utf8 cachedPosition 
.const [265] = Utf8 Lde/esolutions/hmi/widgets/audi/evo/widgets/balancefader/ValuePair; 
.const [266] = Utf8 de/audi/atip/hmi/modelaccess/RangeModel2DGUI 
.const [267] = Utf8 getMaximumX 
.const [268] = Utf8 ()I 
.const [269] = Utf8 de/audi/atip/hmi/modelaccess/RangeModel2DGUI 
.const [270] = Utf8 getMinimumX 
.const [271] = Utf8 ()I 
.const [272] = Utf8 de/audi/atip/hmi/modelaccess/RangeModel2DGUI 
.const [273] = Utf8 getMaximumY 
.const [274] = Utf8 ()I 
.const [275] = Utf8 de/audi/atip/hmi/modelaccess/RangeModel2DGUI 
.const [276] = Utf8 getMinimumY 
.const [277] = Utf8 ()I 
.const [278] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/balancefader/WrappedRangeModel2DGUI 
.const [279] = Utf8 modelSize 
.const [280] = Utf8 Lde/esolutions/hmi/widgets/audi/evo/widgets/balancefader/ValuePair; 
.const [281] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/balancefader/WrappedRangeModel2DGUI 
.const [282] = Utf8 modelMinima 
.const [283] = Utf8 Lde/esolutions/hmi/widgets/audi/evo/widgets/balancefader/ValuePair; 
.const [284] = Utf8 de/audi/atip/hmi/modelaccess/RangeModel2DGUI 
.const [285] = Utf8 getStepX 
.const [286] = Utf8 ()I 
.const [287] = Utf8 de/audi/atip/hmi/modelaccess/RangeModel2DGUI 
.const [288] = Utf8 getStepY 
.const [289] = Utf8 ()I 
.const [290] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/balancefader/WrappedRangeModel2DGUI 
.const [291] = Utf8 steps 
.const [292] = Utf8 Lde/esolutions/hmi/widgets/audi/evo/widgets/balancefader/ValuePair; 
.const [293] = Utf8 de/audi/atip/hmi/modelaccess/RangeModel2DGUI 
.const [294] = Utf8 setValueHit 
.const [295] = Utf8 (III)V 
.const [296] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/balancefader/WrappedRangeModel2DGUI 
.const [297] = Class [296] 
.const [298] = Utf8 java/lang/Object 
.const [299] = Class [298] 
.const [300] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/balancefader/IWrappedRangeModel2DGUI 
.const [301] = Class [300] 
.const [302] = Utf8 de/esolutions/hmi/widgets/audi/base/IWidgetLogChannel 
.const [303] = Class [302] 
.const [304] = Utf8 rangeModel 
.const [305] = Utf8 Lde/audi/atip/hmi/modelaccess/RangeModel2DGUI; 
.const [306] = Utf8 cachedPosition 
.const [307] = Utf8 Lde/esolutions/hmi/widgets/audi/evo/widgets/balancefader/ValuePair; 
.const [308] = Utf8 steps 
.const [309] = Utf8 Lde/esolutions/hmi/widgets/audi/evo/widgets/balancefader/ValuePair; 
.const [310] = Utf8 modelMinima 
.const [311] = Utf8 Lde/esolutions/hmi/widgets/audi/evo/widgets/balancefader/ValuePair; 
.const [312] = Utf8 modelSize 
.const [313] = Utf8 Lde/esolutions/hmi/widgets/audi/evo/widgets/balancefader/ValuePair; 
.const [314] = Utf8 terminalID 
.const [315] = Utf8 I 
.const [316] = Utf8 lc 
.const [317] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [318] = Utf8 Code 
.const [319] = Utf8 <init> 
.const [320] = Utf8 (Ljava/lang/Object;Lde/audi/atip/log/LogChannel;I)V 
.const [321] = Utf8 updateModelSizeAndSteps 
.const [322] = Utf8 ()V 
.const [323] = Utf8 updateModelSize 
.const [324] = Utf8 ()V 
.const [325] = Utf8 updateSteps 
.const [326] = Utf8 ()V 
.const [327] = Utf8 processEvent 
.const [328] = Utf8 (Lde/audi/atip/hmi/event/ATIPEvent;)Lde/esolutions/hmi/widgets/audi/evo/widgets/balancefader/ValuePair; 
.const [329] = Utf8 getPosition 
.const [330] = Utf8 ()Lde/esolutions/hmi/widgets/audi/evo/widgets/balancefader/ValuePair; 
.const [331] = Utf8 normToInterval 
.const [332] = Utf8 (Lde/esolutions/hmi/widgets/audi/evo/widgets/balancefader/ValuePair;)Lde/esolutions/hmi/widgets/audi/evo/widgets/balancefader/ValuePair; 
.const [333] = Utf8 setPosition 
.const [334] = Utf8 (Lde/esolutions/hmi/widgets/audi/evo/widgets/balancefader/ValuePair;)V 
.const [335] = Utf8 normToModel 
.const [336] = Utf8 (Lde/esolutions/hmi/widgets/audi/evo/widgets/balancefader/ValuePair;)Lde/esolutions/hmi/widgets/audi/evo/widgets/balancefader/ValuePair; 
.const [337] = Utf8 updateModel 
.const [338] = Utf8 ()V 
.const [339] = Utf8 getSteps 
.const [340] = Utf8 ()Lde/esolutions/hmi/widgets/audi/evo/widgets/balancefader/ValuePair; 
.end class 
