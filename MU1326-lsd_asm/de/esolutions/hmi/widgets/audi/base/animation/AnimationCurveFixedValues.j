.version 50 0 
.class public super [313] 
.super [315] 
.field public static final [316] [317] 
.field public static final [318] [319] 
.field public static final [320] [321] 
.field protected [322] [323] 
.field protected [324] [325] 
.field protected [326] [327] 
.field private [328] [329] 
.field private [330] [331] 

.method public [333] : [334] 
    .attribute [332] .code stack 8 locals 0 
L0:     aload_0 
L1:     iload_1 
L2:     iload_2 
L3:     fload_3 
L4:     fload 4 
L6:     iload 5 
L8:     aload 6 
L10:    iload 10 
L12:    invokespecial [47] 
L15:    aload_0 
L16:    iconst_0 
L17:    putfield [53] 
L20:    aload_0 
L21:    iconst_0 
L22:    putfield [54] 
L25:    aload_0 
L26:    aload 7 
L28:    putfield [55] 
L31:    aload_0 
L32:    aload 7 
L34:    iconst_3 
L35:    faload 
L36:    f2l 
L37:    putfield [56] 
L40:    aload_0 
L41:    aload 8 
L43:    putfield [57] 
L46:    aload_0 
L47:    iload 9 
L49:    putfield [53] 
L52:    return 
L53:    nop 
L54:    nop 
L55:    nop 
L56:    
    .end code 
.end method 

.method public [335] : [336] 
    .attribute [332] .code stack 4 locals 1 
L0:     aload_0 
L1:     lload_1 
L2:     putfield [58] 
L5:     aload_0 
L6:     lload_3 
L7:     putfield [59] 
L10:    aload_0 
L11:    getfield [19] 
L14:    ifne L107 
        .catch [2] from L17 to L25 using L28 
L17:    aload_0 
L18:    invokevirtual [25] 
L21:    aload_0 
L22:    invokevirtual [26] 
L25:    goto L44 
L28:    astore 5 
L30:    aload_0 
L31:    getfield [27] 
L34:    ldc [3] 
L36:    ldc [4] 
L38:    aload 5 
L40:    invokevirtual [28] 
L43:    pop 
L44:    aload_0 
L45:    getfield [29] 
L48:    iconst_2 
L49:    if_icmpne L97 
L52:    aload_0 
L53:    getfield [20] 
L56:    ifeq L72 
L59:    aload_0 
L60:    dup 
L61:    getfield [30] 
L64:    iconst_2 
L65:    isub 
L66:    putfield [60] 
L69:    goto L82 
L72:    aload_0 
L73:    dup 
L74:    getfield [30] 
L77:    iconst_1 
L78:    isub 
L79:    putfield [60] 
L82:    aload_0 
L83:    getfield [30] 
L86:    ifge L107 
L89:    aload_0 
L90:    iconst_0 
L91:    putfield [60] 
L94:    goto L107 
L97:    aload_0 
L98:    dup 
L99:    getfield [30] 
L102:   iconst_1 
L103:   iadd 
L104:   putfield [60] 
L107:   return 
L108:   
    .end code 
.end method 

.method protected [337] : [338] 
    .attribute [332] .code stack 4 locals 0 
L0:     aload_0 
L1:     getfield [29] 
L4:     iconst_2 
L5:     if_icmpne L15 
L8:     aload_0 
L9:     getfield [30] 
L12:    ifeq L22 
L15:    aload_0 
L16:    invokevirtual [31] 
L19:    ifeq L31 
L22:    aload_0 
L23:    aload_0 
L24:    getfield [32] 
L27:    putfield [61] 
L30:    return 
L31:    aload_0 
L32:    getfield [34] 
L35:    ifne L89 
L38:    aload_0 
L39:    getfield [23] 
L42:    aload_0 
L43:    getfield [24] 
L46:    lsub 
L47:    ldc_w [1] 
L50:    ladd 
L51:    aload_0 
L52:    getfield [35] 
L55:    i2l 
L56:    ladd 
L57:    l2f 
L58:    aload_0 
L59:    invokevirtual [36] 
L62:    fcmpl 
L63:    ifle L89 
L66:    aload_0 
L67:    aload_0 
L68:    getfield [37] 
L71:    putfield [61] 
L74:    aload_0 
L75:    getfield [27] 
L78:    ldc [3] 
L80:    ldc [5] 
L82:    invokevirtual [38] 
L85:    pop 
L86:    goto L157 
L89:    aload_0 
L90:    getfield [23] 
L93:    aload_0 
L94:    getfield [24] 
L97:    lsub 
L98:    aload_0 
L99:    getfield [35] 
L102:   i2l 
L103:   lcmp 
L104:   ifle L114 
L107:   aload_0 
L108:   getfield [34] 
L111:   ifeq L141 
L114:   aload_0 
L115:   aload_0 
L116:   aload_0 
L117:   getfield [30] 
L120:   invokespecial [48] 
L123:   putfield [61] 
L126:   aload_0 
L127:   getfield [27] 
L130:   ldc [3] 
L132:   ldc [6] 
L134:   invokevirtual [38] 
L137:   pop 
L138:   goto L157 
L141:   aload_0 
L142:   invokespecial [49] 
L145:   aload_0 
L146:   getfield [27] 
L149:   ldc [3] 
L151:   ldc [7] 
L153:   invokevirtual [38] 
L156:   pop 
L157:   ldc [3] 
L159:   aload_0 
L160:   getfield [27] 
L163:   invokevirtual [39] 
L166:   if_icmpgt L188 
L169:   aload_0 
L170:   getfield [27] 
L173:   ldc [3] 
L175:   ldc [8] 
L177:   aload_0 
L178:   getfield [33] 
L181:   invokestatic [9] 
L184:   invokevirtual [40] 
L187:   pop 
L188:   return 
L189:   nop 
L190:   nop 
L191:   nop 
L192:   
    .end code 
.end method 

.method private [339] : [340] 
    .attribute [332] .code stack 4 locals 1 
L0:     aload_0 
L1:     getfield [23] 
L4:     aload_0 
L5:     getfield [24] 
L8:     lsub 
L9:     aload_0 
L10:    getfield [35] 
L13:    i2l 
L14:    ldiv 
L15:    l2i 
L16:    istore_1 
L17:    aload_0 
L18:    getfield [29] 
L21:    iconst_2 
L22:    if_icmpne L50 
L25:    aload_0 
L26:    dup 
L27:    getfield [30] 
L30:    iload_1 
L31:    isub 
L32:    putfield [60] 
L35:    aload_0 
L36:    getfield [30] 
L39:    ifge L60 
L42:    aload_0 
L43:    iconst_0 
L44:    putfield [60] 
L47:    goto L60 
L50:    aload_0 
L51:    dup 
L52:    getfield [30] 
L55:    iload_1 
L56:    iadd 
L57:    putfield [60] 
L60:    aload_0 
L61:    aload_0 
L62:    aload_0 
L63:    getfield [30] 
L66:    invokespecial [48] 
L69:    putfield [61] 
L72:    return 
L73:    nop 
L74:    nop 
L75:    nop 
L76:    
    .end code 
.end method 

.method public [341] : [342] 
    .attribute [332] .code stack 4 locals 0 
L0:     aload_0 
L1:     fload_1 
L2:     fload_2 
L3:     iload_3 
L4:     invokespecial [50] 
L7:     aload_0 
L8:     invokevirtual [41] 
L11:    aload_0 
L12:    iconst_0 
L13:    putfield [60] 
L16:    return 
L17:    nop 
L18:    nop 
L19:    nop 
L20:    
    .end code 
.end method 

.method public [343] : [344] 
    .attribute [332] .code stack 2 locals 0 
L0:     aload_0 
L1:     iconst_0 
L2:     putfield [60] 
L5:     return 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method private [345] : [346] 
    .attribute [332] .code stack 3 locals 1 
L0:     iload_1 
L1:     aload_0 
L2:     getfield [22] 
L5:     arraylength 
L6:     if_icmpge L19 
L9:     aload_0 
L10:    getfield [22] 
L13:    iload_1 
L14:    faload 
L15:    fstore_2 
L16:    goto L21 
L19:    fconst_1 
L20:    fstore_2 
L21:    aload_0 
L22:    getfield [32] 
L25:    aload_0 
L26:    getfield [37] 
L29:    aload_0 
L30:    getfield [32] 
L33:    fsub 
L34:    fload_2 
L35:    fmul 
L36:    fadd 
L37:    areturn 
L38:    nop 
L39:    nop 
L40:    
    .end code 
.end method 

.method public [347] : [348] 
    .attribute [332] .code stack 2 locals 0 
L0:     aload_0 
L1:     getfield [21] 
L4:     iconst_4 
L5:     faload 
L6:     areturn 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [349] : [350] 
    .attribute [332] .code stack 7 locals 3 
L0:     aload_0 
L1:     getfield [19] 
L4:     ifne L133 
L7:     aload_0 
L8:     getfield [21] 
L11:    iconst_3 
L12:    faload 
L13:    fstore_1 
L14:    aload_0 
L15:    getfield [21] 
L18:    iconst_4 
L19:    faload 
L20:    fstore_2 
L21:    aload_0 
L22:    getfield [22] 
L25:    arraylength 
L26:    istore_3 
L27:    iload_3 
L28:    iconst_1 
L29:    if_icmple L75 
L32:    aload_0 
L33:    fload_1 
L34:    ldc [10] 
L36:    fsub 
L37:    aload_0 
L38:    getfield [21] 
L41:    iconst_5 
L42:    faload 
L43:    fsub 
L44:    f2i 
L45:    iload_3 
L46:    iconst_1 
L47:    isub 
L48:    idiv 
L49:    putfield [63] 
L52:    aload_0 
L53:    fload_2 
L54:    ldc [10] 
L56:    fsub 
L57:    aload_0 
L58:    getfield [21] 
L61:    iconst_5 
L62:    faload 
L63:    fsub 
L64:    f2i 
L65:    iload_3 
L66:    iconst_1 
L67:    isub 
L68:    idiv 
L69:    putfield [62] 
L72:    goto L93 
L75:    aload_0 
L76:    fload_1 
L77:    ldc [10] 
L79:    fsub 
L80:    f2i 
L81:    putfield [63] 
L84:    aload_0 
L85:    fload_2 
L86:    ldc [10] 
L88:    fsub 
L89:    f2i 
L90:    putfield [62] 
L93:    aload_0 
L94:    getfield [42] 
L97:    aload_0 
L98:    getfield [35] 
L101:   if_icmplt L114 
L104:   aload_0 
L105:   aload_0 
L106:   getfield [42] 
L109:   iconst_5 
L110:   iadd 
L111:   putfield [62] 
L114:   aload_0 
L115:   getfield [27] 
L118:   ldc [3] 
L120:   ldc [11] 
L122:   aload_0 
L123:   getfield [43] 
L126:   i2l 
L127:   iload_3 
L128:   i2l 
L129:   invokevirtual [44] 
L132:   pop 
L133:   aload_0 
L134:   invokevirtual [45] 
L137:   return 
L138:   nop 
L139:   nop 
L140:   
    .end code 
.end method 

.method protected [351] : [352] 
    .attribute [332] .code stack 2 locals 0 
L0:     aload_0 
L1:     getfield [29] 
L4:     iconst_2 
L5:     if_icmpne L34 
L8:     aload_0 
L9:     getfield [33] 
L12:    aload_0 
L13:    getfield [32] 
L16:    fsub 
L17:    invokestatic [12] 
L20:    ldc [13] 
L22:    fcmpg 
L23:    ifge L34 
L26:    aload_0 
L27:    iconst_1 
L28:    invokevirtual [46] 
L31:    goto L38 
L34:    aload_0 
L35:    invokespecial [51] 
L38:    return 
L39:    nop 
L40:    
    .end code 
.end method 

.method public [353] : [354] 
    .attribute [332] .code stack 3 locals 0 
L0:     iload_1 
L1:     iconst_2 
L2:     if_icmpne L50 
L5:     aload_0 
L6:     getfield [20] 
L9:     ifeq L25 
L12:    aload_0 
L13:    dup 
L14:    getfield [30] 
L17:    iconst_2 
L18:    isub 
L19:    putfield [60] 
L22:    goto L35 
L25:    aload_0 
L26:    dup 
L27:    getfield [30] 
L30:    iconst_1 
L31:    isub 
L32:    putfield [60] 
L35:    aload_0 
L36:    getfield [30] 
L39:    ifge L60 
L42:    aload_0 
L43:    iconst_0 
L44:    putfield [60] 
L47:    goto L60 
L50:    aload_0 
L51:    dup 
L52:    getfield [30] 
L55:    iconst_1 
L56:    iadd 
L57:    putfield [60] 
L60:    aload_0 
L61:    iload_1 
L62:    invokespecial [52] 
L65:    return 
L66:    nop 
L67:    nop 
L68:    
    .end code 
.end method 

.method public [355] : [356] 
    .attribute [332] .code stack 2 locals 0 
L0:     aload_0 
L1:     iload_1 
L2:     putfield [54] 
L5:     return 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [65] 
.const [3] = Int -2137614336 
.const [4] = String [66] 
.const [5] = String [67] 
.const [6] = String [68] 
.const [7] = String [69] 
.const [8] = String [70] 
.const [9] = Method [71] [72] 
.const [10] = Int 41025 
.const [11] = String [73] 
.const [12] = Method [74] [75] 
.const [13] = Int -1782589901 
.const [14] = Class [76] 
.const [15] = Class [77] 
.const [16] = Class [78] 
.const [17] = Class [79] 
.const [18] = Class [80] 
.const [19] = Field [81] [82] 
.const [20] = Field [83] [84] 
.const [21] = Field [85] [86] 
.const [22] = Field [87] [88] 
.const [23] = Field [89] [90] 
.const [24] = Field [91] [92] 
.const [25] = Method [93] [94] 
.const [26] = Method [95] [96] 
.const [27] = Field [97] [98] 
.const [28] = Method [99] [100] 
.const [29] = Field [101] [102] 
.const [30] = Field [103] [104] 
.const [31] = Method [105] [106] 
.const [32] = Field [107] [108] 
.const [33] = Field [109] [110] 
.const [34] = Field [111] [112] 
.const [35] = Field [113] [114] 
.const [36] = Method [115] [116] 
.const [37] = Field [117] [118] 
.const [38] = Method [119] [120] 
.const [39] = Method [121] [122] 
.const [40] = Method [123] [124] 
.const [41] = Method [125] [126] 
.const [42] = Field [127] [128] 
.const [43] = Field [129] [130] 
.const [44] = Method [131] [132] 
.const [45] = Method [133] [134] 
.const [46] = Method [135] [136] 
.const [47] = Method [137] [138] 
.const [48] = Method [139] [140] 
.const [49] = Method [141] [142] 
.const [50] = Method [143] [144] 
.const [51] = Method [145] [146] 
.const [52] = Method [147] [148] 
.const [53] = Field [149] [150] 
.const [54] = Field [151] [152] 
.const [55] = Field [153] [154] 
.const [56] = Field [155] [156] 
.const [57] = Field [157] [158] 
.const [58] = Field [159] [160] 
.const [59] = Field [161] [162] 
.const [60] = Field [163] [164] 
.const [61] = Field [165] [166] 
.const [62] = Field [167] [168] 
.const [63] = Field [169] [170] 
.const [64] = Int 335544320 
.const [65] = Utf8 java/lang/Exception 
.const [66] = Utf8 'AnimationCurveFixedValues#computeNextStep catching exception, ensure that animationstep is correctly increased' 
.const [67] = Utf8 'AnimationCurveFixedValues#approachDynamic 1: value = target' 
.const [68] = Utf8 'AnimationCurveFixedValues#approachDynamic 2: value = calculateNewValue( value )' 
.const [69] = Utf8 'AnimationCurveFixedValues#approachDynamic 3: regainTime()' 
.const [70] = Utf8 'AnimationCurveFixedValues#approachDynamic new value: %1' 
.const [71] = Class [171] 
.const [72] = NameAndType [172] [173] 
.const [73] = Utf8 'AnimationCurveFixedValues#calculateDelays animation with type: %1, needs: %2 steps' 
.const [74] = Class [174] 
.const [75] = NameAndType [175] [176] 
.const [76] = Utf8 de/esolutions/hmi/widgets/audi/base/animation/AnimationCurveFixedValues 
.const [77] = Utf8 de/esolutions/hmi/widgets/audi/base/animation/AbstractAnimationCurve 
.const [78] = Utf8 de/audi/atip/log/LogChannel 
.const [79] = Utf8 java/lang/Float 
.const [80] = Utf8 java/lang/Math 
.const [81] = Class [177] 
.const [82] = NameAndType [178] [179] 
.const [83] = Class [180] 
.const [84] = NameAndType [181] [182] 
.const [85] = Class [183] 
.const [86] = NameAndType [184] [185] 
.const [87] = Class [186] 
.const [88] = NameAndType [187] [188] 
.const [89] = Class [189] 
.const [90] = NameAndType [190] [191] 
.const [91] = Class [192] 
.const [92] = NameAndType [193] [194] 
.const [93] = Class [195] 
.const [94] = NameAndType [196] [197] 
.const [95] = Class [198] 
.const [96] = NameAndType [199] [200] 
.const [97] = Class [201] 
.const [98] = NameAndType [202] [203] 
.const [99] = Class [204] 
.const [100] = NameAndType [205] [206] 
.const [101] = Class [207] 
.const [102] = NameAndType [208] [209] 
.const [103] = Class [210] 
.const [104] = NameAndType [211] [212] 
.const [105] = Class [213] 
.const [106] = NameAndType [214] [215] 
.const [107] = Class [216] 
.const [108] = NameAndType [217] [218] 
.const [109] = Class [219] 
.const [110] = NameAndType [220] [221] 
.const [111] = Class [222] 
.const [112] = NameAndType [223] [224] 
.const [113] = Class [225] 
.const [114] = NameAndType [226] [227] 
.const [115] = Class [228] 
.const [116] = NameAndType [229] [230] 
.const [117] = Class [231] 
.const [118] = NameAndType [232] [233] 
.const [119] = Class [234] 
.const [120] = NameAndType [235] [236] 
.const [121] = Class [237] 
.const [122] = NameAndType [238] [239] 
.const [123] = Class [240] 
.const [124] = NameAndType [241] [242] 
.const [125] = Class [243] 
.const [126] = NameAndType [244] [245] 
.const [127] = Class [246] 
.const [128] = NameAndType [247] [248] 
.const [129] = Class [249] 
.const [130] = NameAndType [250] [251] 
.const [131] = Class [252] 
.const [132] = NameAndType [253] [254] 
.const [133] = Class [255] 
.const [134] = NameAndType [256] [257] 
.const [135] = Class [258] 
.const [136] = NameAndType [259] [260] 
.const [137] = Class [261] 
.const [138] = NameAndType [262] [263] 
.const [139] = Class [264] 
.const [140] = NameAndType [265] [266] 
.const [141] = Class [267] 
.const [142] = NameAndType [268] [269] 
.const [143] = Class [270] 
.const [144] = NameAndType [271] [272] 
.const [145] = Class [273] 
.const [146] = NameAndType [274] [275] 
.const [147] = Class [276] 
.const [148] = NameAndType [277] [278] 
.const [149] = Class [279] 
.const [150] = NameAndType [280] [281] 
.const [151] = Class [282] 
.const [152] = NameAndType [283] [284] 
.const [153] = Class [285] 
.const [154] = NameAndType [286] [287] 
.const [155] = Class [288] 
.const [156] = NameAndType [289] [290] 
.const [157] = Class [291] 
.const [158] = NameAndType [292] [293] 
.const [159] = Class [294] 
.const [160] = NameAndType [295] [296] 
.const [161] = Class [297] 
.const [162] = NameAndType [298] [299] 
.const [163] = Class [300] 
.const [164] = NameAndType [301] [302] 
.const [165] = Class [303] 
.const [166] = NameAndType [304] [305] 
.const [167] = Class [306] 
.const [168] = NameAndType [307] [308] 
.const [169] = Class [309] 
.const [170] = NameAndType [310] [311] 
.const [171] = Utf8 java/lang/Float 
.const [172] = Utf8 toString 
.const [173] = Utf8 (F)Ljava/lang/String; 
.const [174] = Utf8 java/lang/Math 
.const [175] = Utf8 abs 
.const [176] = Utf8 (F)F 
.const [177] = Utf8 de/esolutions/hmi/widgets/audi/base/animation/AnimationCurveFixedValues 
.const [178] = Utf8 isEndlessAnimation 
.const [179] = Utf8 Z 
.const [180] = Utf8 de/esolutions/hmi/widgets/audi/base/animation/AnimationCurveFixedValues 
.const [181] = Utf8 fastRollBack 
.const [182] = Utf8 Z 
.const [183] = Utf8 de/esolutions/hmi/widgets/audi/base/animation/AnimationCurveFixedValues 
.const [184] = Utf8 animationParameters 
.const [185] = Utf8 [F 
.const [186] = Utf8 de/esolutions/hmi/widgets/audi/base/animation/AnimationCurveFixedValues 
.const [187] = Utf8 fixedValues 
.const [188] = Utf8 [F 
.const [189] = Utf8 de/esolutions/hmi/widgets/audi/base/animation/AnimationCurveFixedValues 
.const [190] = Utf8 animationStepStart 
.const [191] = Utf8 J 
.const [192] = Utf8 de/esolutions/hmi/widgets/audi/base/animation/AnimationCurveFixedValues 
.const [193] = Utf8 lastAnimationStepStart 
.const [194] = Utf8 J 
.const [195] = Utf8 de/esolutions/hmi/widgets/audi/base/animation/AnimationCurveFixedValues 
.const [196] = Utf8 approachDynamic 
.const [197] = Utf8 ()V 
.const [198] = Utf8 de/esolutions/hmi/widgets/audi/base/animation/AnimationCurveFixedValues 
.const [199] = Utf8 calculateProgress 
.const [200] = Utf8 ()V 
.const [201] = Utf8 de/esolutions/hmi/widgets/audi/base/animation/AnimationCurveFixedValues 
.const [202] = Utf8 logAnimation 
.const [203] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [204] = Utf8 de/audi/atip/log/LogChannel 
.const [205] = Utf8 log 
.const [206] = Utf8 (ILjava/lang/String;Ljava/lang/Throwable;)Z 
.const [207] = Utf8 de/esolutions/hmi/widgets/audi/base/animation/AnimationCurveFixedValues 
.const [208] = Utf8 animationDirection 
.const [209] = Utf8 I 
.const [210] = Utf8 de/esolutions/hmi/widgets/audi/base/animation/AnimationCurveFixedValues 
.const [211] = Utf8 fixedValueStep 
.const [212] = Utf8 I 
.const [213] = Utf8 de/esolutions/hmi/widgets/audi/base/animation/AnimationCurveFixedValues 
.const [214] = Utf8 isFinished 
.const [215] = Utf8 ()Z 
.const [216] = Utf8 de/esolutions/hmi/widgets/audi/base/animation/AnimationCurveFixedValues 
.const [217] = Utf8 start 
.const [218] = Utf8 F 
.const [219] = Utf8 de/esolutions/hmi/widgets/audi/base/animation/AnimationCurveFixedValues 
.const [220] = Utf8 value 
.const [221] = Utf8 F 
.const [222] = Utf8 de/esolutions/hmi/widgets/audi/base/animation/AnimationCurveFixedValues 
.const [223] = Utf8 renderEachStep 
.const [224] = Utf8 Z 
.const [225] = Utf8 de/esolutions/hmi/widgets/audi/base/animation/AnimationCurveFixedValues 
.const [226] = Utf8 maxTimerIntervall 
.const [227] = Utf8 I 
.const [228] = Utf8 de/esolutions/hmi/widgets/audi/base/animation/AnimationCurveFixedValues 
.const [229] = Utf8 getMaxDuration 
.const [230] = Utf8 ()F 
.const [231] = Utf8 de/esolutions/hmi/widgets/audi/base/animation/AnimationCurveFixedValues 
.const [232] = Utf8 target 
.const [233] = Utf8 F 
.const [234] = Utf8 de/audi/atip/log/LogChannel 
.const [235] = Utf8 log 
.const [236] = Utf8 (ILjava/lang/String;)Z 
.const [237] = Utf8 de/audi/atip/log/LogChannel 
.const [238] = Utf8 getCurrentLogThreshold 
.const [239] = Utf8 ()I 
.const [240] = Utf8 de/audi/atip/log/LogChannel 
.const [241] = Utf8 log 
.const [242] = Utf8 (ILjava/lang/String;Ljava/lang/Object;)Z 
.const [243] = Utf8 de/esolutions/hmi/widgets/audi/base/animation/AnimationCurveFixedValues 
.const [244] = Utf8 calculateDelays 
.const [245] = Utf8 ()V 
.const [246] = Utf8 de/esolutions/hmi/widgets/audi/base/animation/AnimationCurveFixedValues 
.const [247] = Utf8 timerIntervall 
.const [248] = Utf8 I 
.const [249] = Utf8 de/esolutions/hmi/widgets/audi/base/animation/AnimationCurveFixedValues 
.const [250] = Utf8 type 
.const [251] = Utf8 I 
.const [252] = Utf8 de/audi/atip/log/LogChannel 
.const [253] = Utf8 log 
.const [254] = Utf8 (ILjava/lang/String;JJ)Z 
.const [255] = Utf8 de/esolutions/hmi/widgets/audi/base/animation/AnimationCurveFixedValues 
.const [256] = Utf8 checkDelays 
.const [257] = Utf8 ()V 
.const [258] = Utf8 de/esolutions/hmi/widgets/audi/base/animation/AnimationCurveFixedValues 
.const [259] = Utf8 setFinished 
.const [260] = Utf8 (Z)V 
.const [261] = Utf8 de/esolutions/hmi/widgets/audi/base/animation/AbstractAnimationCurve 
.const [262] = Utf8 <init> 
.const [263] = Utf8 (IIFFZLde/audi/atip/log/LogChannel;I)V 
.const [264] = Utf8 de/esolutions/hmi/widgets/audi/base/animation/AnimationCurveFixedValues 
.const [265] = Utf8 getFixedValue 
.const [266] = Utf8 (I)F 
.const [267] = Utf8 de/esolutions/hmi/widgets/audi/base/animation/AnimationCurveFixedValues 
.const [268] = Utf8 regainTime 
.const [269] = Utf8 ()V 
.const [270] = Utf8 de/esolutions/hmi/widgets/audi/base/animation/AbstractAnimationCurve 
.const [271] = Utf8 initialize 
.const [272] = Utf8 (FFI)V 
.const [273] = Utf8 de/esolutions/hmi/widgets/audi/base/animation/AbstractAnimationCurve 
.const [274] = Utf8 calculateProgress 
.const [275] = Utf8 ()V 
.const [276] = Utf8 de/esolutions/hmi/widgets/audi/base/animation/AbstractAnimationCurve 
.const [277] = Utf8 setAnimationDirection 
.const [278] = Utf8 (I)V 
.const [279] = Utf8 de/esolutions/hmi/widgets/audi/base/animation/AnimationCurveFixedValues 
.const [280] = Utf8 isEndlessAnimation 
.const [281] = Utf8 Z 
.const [282] = Utf8 de/esolutions/hmi/widgets/audi/base/animation/AnimationCurveFixedValues 
.const [283] = Utf8 fastRollBack 
.const [284] = Utf8 Z 
.const [285] = Utf8 de/esolutions/hmi/widgets/audi/base/animation/AnimationCurveFixedValues 
.const [286] = Utf8 animationParameters 
.const [287] = Utf8 [F 
.const [288] = Utf8 de/esolutions/hmi/widgets/audi/base/animation/AnimationCurveFixedValues 
.const [289] = Utf8 plannedDuration 
.const [290] = Utf8 J 
.const [291] = Utf8 de/esolutions/hmi/widgets/audi/base/animation/AnimationCurveFixedValues 
.const [292] = Utf8 fixedValues 
.const [293] = Utf8 [F 
.const [294] = Utf8 de/esolutions/hmi/widgets/audi/base/animation/AnimationCurveFixedValues 
.const [295] = Utf8 animationStepStart 
.const [296] = Utf8 J 
.const [297] = Utf8 de/esolutions/hmi/widgets/audi/base/animation/AnimationCurveFixedValues 
.const [298] = Utf8 lastAnimationStepStart 
.const [299] = Utf8 J 
.const [300] = Utf8 de/esolutions/hmi/widgets/audi/base/animation/AnimationCurveFixedValues 
.const [301] = Utf8 fixedValueStep 
.const [302] = Utf8 I 
.const [303] = Utf8 de/esolutions/hmi/widgets/audi/base/animation/AnimationCurveFixedValues 
.const [304] = Utf8 value 
.const [305] = Utf8 F 
.const [306] = Utf8 de/esolutions/hmi/widgets/audi/base/animation/AnimationCurveFixedValues 
.const [307] = Utf8 maxTimerIntervall 
.const [308] = Utf8 I 
.const [309] = Utf8 de/esolutions/hmi/widgets/audi/base/animation/AnimationCurveFixedValues 
.const [310] = Utf8 timerIntervall 
.const [311] = Utf8 I 
.const [312] = Utf8 de/esolutions/hmi/widgets/audi/base/animation/AnimationCurveFixedValues 
.const [313] = Class [312] 
.const [314] = Utf8 de/esolutions/hmi/widgets/audi/base/animation/AbstractAnimationCurve 
.const [315] = Class [314] 
.const [316] = Utf8 POS_MIN_DURATION 
.const [317] = Utf8 I 
.const [318] = Utf8 POS_MAX_DURATION 
.const [319] = Utf8 I 
.const [320] = Utf8 POS_INITIAL_DELAY 
.const [321] = Utf8 I 
.const [322] = Utf8 fixedValueStep 
.const [323] = Utf8 I 
.const [324] = Utf8 animationParameters 
.const [325] = Utf8 [F 
.const [326] = Utf8 fixedValues 
.const [327] = Utf8 [F 
.const [328] = Utf8 isEndlessAnimation 
.const [329] = Utf8 Z 
.const [330] = Utf8 fastRollBack 
.const [331] = Utf8 Z 
.const [332] = Utf8 Code 
.const [333] = Utf8 <init> 
.const [334] = Utf8 (IIFFZLde/audi/atip/log/LogChannel;[F[FZI)V 
.const [335] = Utf8 computeNextStep 
.const [336] = Utf8 (JJ)V 
.const [337] = Utf8 approachDynamic 
.const [338] = Utf8 ()V 
.const [339] = Utf8 regainTime 
.const [340] = Utf8 ()V 
.const [341] = Utf8 initialize 
.const [342] = Utf8 (FFI)V 
.const [343] = Utf8 recalculateParameters 
.const [344] = Utf8 ()V 
.const [345] = Utf8 getFixedValue 
.const [346] = Utf8 (I)F 
.const [347] = Utf8 getMaxDuration 
.const [348] = Utf8 ()F 
.const [349] = Utf8 calculateDelays 
.const [350] = Utf8 ()V 
.const [351] = Utf8 calculateProgress 
.const [352] = Utf8 ()V 
.const [353] = Utf8 setAnimationDirection 
.const [354] = Utf8 (I)V 
.const [355] = Utf8 setFastRollBack 
.const [356] = Utf8 (Z)V 
.end class 
