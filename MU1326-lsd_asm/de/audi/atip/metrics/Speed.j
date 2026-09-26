.version 50 0 
.class public super [275] 
.super [277] 
.field private static final [278] [279] 
.field private static final [280] [281] 
.field private static [282] [283] 
.field public static final [284] [285] 
.field public static final [286] [287] 
.field public static final [288] [289] 
.field public static final [290] [291] 
.field public static final [292] [293] 
.field private static final [294] [295] 
.field public static final [296] [297] 
.field public static final [298] [299] 
.field private static [300] [301] 
.field private [302] [303] 

.method public [305] : [306] 
    .attribute [304] .code stack 3 locals 0 
L0:     aload_0 
L1:     fload_1 
L2:     iload_2 
L3:     invokespecial [43] 
L6:     aload_0 
L7:     invokespecial [44] 
L10:    aload_0 
L11:    iconst_0 
L12:    putfield [53] 
L15:    return 
L16:    
    .end code 
.end method 

.method protected final [307] : [308] 
    .attribute [304] .code stack 2 locals 0 
L0:     fload_1 
L1:     ldc [2] 
L3:     fdiv 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method protected final [309] : [310] 
    .attribute [304] .code stack 2 locals 0 
L0:     fload_1 
L1:     ldc [2] 
L3:     fmul 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method protected final [311] : [312] 
    .attribute [304] .code stack 3 locals 0 
L0:     aload_0 
L1:     getfield [24] 
L4:     lookupswitch 
            2 : L24 
            default : L39 

L24:    aload_0 
L25:    aload_0 
L26:    aload_0 
L27:    getfield [25] 
L30:    invokespecial [45] 
L33:    putfield [54] 
L36:    goto L39 
L39:    return 
L40:    
    .end code 
.end method 

.method public static [313] : [314] 
    .attribute [304] .code stack 2 locals 0 
L0:     iload_0 
L1:     iconst_1 
L2:     if_icmpeq L10 
L5:     iload_0 
L6:     iconst_2 
L7:     if_icmpne L14 
L10:    iconst_1 
L11:    goto L15 
L14:    iconst_0 
L15:    areturn 
L16:    
    .end code 
.end method 

.method public static [315] : [316] 
    .attribute [304] .code stack 2 locals 0 
L0:     iload_0 
L1:     bipush 10 
L3:     if_icmpeq L18 
L6:     iload_0 
L7:     bipush 12 
L9:     if_icmpeq L18 
L12:    iload_0 
L13:    bipush 11 
L15:    if_icmpne L22 
L18:    iconst_1 
L19:    goto L23 
L22:    iconst_0 
L23:    areturn 
L24:    
    .end code 
.end method 

.method public static [317] : [318] 
    .attribute [304] .code stack 2 locals 0 
L0:     iload_0 
L1:     invokestatic [3] 
L4:     ifne L15 
L7:     new [55] 
L10:    dup 
L11:    invokespecial [46] 
L14:    athrow 
L15:    iload_0 
L16:    putstatic [47] 
L19:    return 
L20:    
    .end code 
.end method 

.method public static [319] : [320] 
    .attribute [304] .code stack 1 locals 0 
L0:     getstatic [5] 
L3:     areturn 
L4:     
    .end code 
.end method 

.method public [321] : [322] 
    .attribute [304] .code stack 2 locals 0 
L0:     aload_0 
L1:     iload_1 
L2:     putfield [53] 
L5:     return 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [323] : [324] 
    .attribute [304] .code stack 2 locals 0 
L0:     aload_0 
L1:     fload_1 
L2:     putfield [54] 
L5:     aload_0 
L6:     invokespecial [44] 
L9:     return 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method public [325] : [326] 
    .attribute [304] .code stack 2 locals 0 
L0:     aload_0 
L1:     getstatic [5] 
L4:     invokevirtual [26] 
L7:     areturn 
L8:     
    .end code 
.end method 

.method public [327] : [328] 
    .attribute [304] .code stack 2 locals 0 
L0:     iload_1 
L1:     invokestatic [3] 
L4:     ifne L15 
L7:     new [55] 
L10:    dup 
L11:    invokespecial [46] 
L14:    athrow 
L15:    aload_0 
L16:    iload_1 
L17:    invokevirtual [26] 
L20:    areturn 
L21:    nop 
L22:    nop 
L23:    nop 
L24:    
    .end code 
.end method 

.method protected [329] : [330] 
    .attribute [304] .code stack 2 locals 0 
L0:     iload_1 
L1:     lookupswitch 
            2 : L20 
            default : L29 

L20:    aload_0 
L21:    aload_0 
L22:    getfield [25] 
L25:    invokespecial [48] 
L28:    areturn 
L29:    aload_0 
L30:    getfield [25] 
L33:    areturn 
L34:    nop 
L35:    nop 
L36:    
    .end code 
.end method 

.method public [331] : [332] 
    .attribute [304] .code stack 2 locals 0 
L0:     aload_0 
L1:     bipush 10 
L3:     invokevirtual [27] 
L6:     areturn 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [333] : [334] 
    .attribute [304] .code stack 3 locals 0 
L0:     aload_0 
L1:     aload_0 
L2:     getfield [28] 
L5:     ifeq L15 
L8:     aload_0 
L9:     getfield [24] 
L12:    goto L18 
L15:    getstatic [5] 
L18:    iload_1 
L19:    invokevirtual [29] 
L22:    areturn 
L23:    nop 
L24:    
    .end code 
.end method 

.method public [335] : [336] 
    .attribute [304] .code stack 3 locals 0 
L0:     aload_0 
L1:     iload_1 
L2:     bipush 10 
L4:     invokevirtual [29] 
L7:     areturn 
L8:     
    .end code 
.end method 

.method public [337] : [338] 
    .attribute [304] .code stack 4 locals 3 
L0:     iload_2 
L1:     invokestatic [6] 
L4:     ifeq L14 
L7:     iload_1 
L8:     invokestatic [3] 
L11:    ifne L50 
L14:    new [55] 
L17:    dup 
L18:    new [56] 
L21:    dup 
L22:    invokespecial [49] 
L25:    ldc [8] 
L27:    invokevirtual [30] 
L30:    iload_2 
L31:    invokevirtual [31] 
L34:    ldc [9] 
L36:    invokevirtual [30] 
L39:    iload_1 
L40:    invokevirtual [31] 
L43:    invokevirtual [32] 
L46:    invokespecial [50] 
L49:    athrow 
L50:    new [57] 
L53:    dup 
L54:    invokespecial [51] 
L57:    astore_3 
L58:    iload_2 
L59:    bipush 10 
L61:    if_icmpeq L70 
L64:    iload_2 
L65:    bipush 11 
L67:    if_icmpne L117 
L70:    aload_0 
L71:    iload_1 
L72:    invokevirtual [33] 
L75:    fstore 5 
L77:    fload 5 
L79:    ldc [11] 
L81:    fadd 
L82:    f2i 
L83:    istore 4 
L85:    iload 4 
L87:    ifne L110 
L90:    aload_0 
L91:    getfield [23] 
L94:    iconst_1 
L95:    if_icmpne L110 
L98:    aload_3 
L99:    aload_0 
L100:   invokevirtual [34] 
L103:   invokevirtual [35] 
L106:   pop 
L107:   goto L117 
L110:   aload_3 
L111:   iload 4 
L113:   invokevirtual [36] 
L116:   pop 
L117:   iload_2 
L118:   bipush 10 
L120:   if_icmpeq L129 
L123:   iload_2 
L124:   bipush 12 
L126:   if_icmpne L166 
L129:   iload_1 
L130:   iconst_1 
L131:   if_icmpne L139 
L134:   bipush 31 
L136:   goto L141 
L139:   bipush 32 
L141:   invokestatic [12] 
L144:   astore 4 
L146:   iload_2 
L147:   bipush 12 
L149:   if_icmpne L159 
L152:   aload 4 
L154:   invokevirtual [37] 
L157:   astore 4 
L159:   aload_3 
L160:   aload 4 
L162:   invokevirtual [35] 
L165:   pop 
L166:   aload_0 
L167:   getfield [38] 
L170:   aload_3 
L171:   invokestatic [13] 
L174:   ifne L185 
L177:   aload_0 
L178:   aload_3 
L179:   invokevirtual [39] 
L182:   putfield [58] 
L185:   aload_0 
L186:   getfield [38] 
L189:   areturn 
L190:   nop 
L191:   nop 
L192:   
    .end code 
.end method 

.method protected static [339] : [340] 
    .attribute [304] .code stack 1 locals 1 
L0:     iload_0 
L1:     invokestatic [14] 
L4:     astore_1 
L5:     aload_1 
L6:     ifnonnull L51 
L9:     iload_0 
L10:    lookupswitch 
            31 : L36 
            32 : L42 
            default : L48 

L36:    ldc [15] 
L38:    astore_1 
L39:    goto L51 
L42:    ldc [16] 
L44:    astore_1 
L45:    goto L51 
L48:    ldc [17] 
L50:    astore_1 
L51:    aload_1 
L52:    areturn 
L53:    nop 
L54:    nop 
L55:    nop 
L56:    
    .end code 
.end method 

.method public [341] : [342] 
    .attribute [304] .code stack 2 locals 0 
L0:     aload_0 
L1:     aload_0 
L2:     getfield [28] 
L5:     ifeq L15 
L8:     aload_0 
L9:     getfield [24] 
L12:    goto L18 
L15:    getstatic [5] 
L18:    invokevirtual [40] 
L21:    areturn 
L22:    nop 
L23:    nop 
L24:    
    .end code 
.end method 

.method public [343] : [344] 
    .attribute [304] .code stack 3 locals 0 
L0:     aload_0 
L1:     iload_1 
L2:     bipush 12 
L4:     invokevirtual [29] 
L7:     areturn 
L8:     
    .end code 
.end method 

.method public [345] : [346] 
    .attribute [304] .code stack 2 locals 0 
L0:     aload_0 
L1:     aload_0 
L2:     getfield [28] 
L5:     ifeq L15 
L8:     aload_0 
L9:     getfield [24] 
L12:    goto L18 
L15:    getstatic [5] 
L18:    invokevirtual [41] 
L21:    areturn 
L22:    nop 
L23:    nop 
L24:    
    .end code 
.end method 

.method public [347] : [348] 
    .attribute [304] .code stack 3 locals 0 
L0:     aload_0 
L1:     invokevirtual [42] 
L4:     ifeq L17 
L7:     aload_0 
L8:     iload_1 
L9:     bipush 11 
L11:    invokevirtual [29] 
L14:    goto L21 
L17:    aload_0 
L18:    invokevirtual [34] 
L21:    areturn 
L22:    nop 
L23:    nop 
L24:    
    .end code 
.end method 

.method public [349] : [350] 
    .attribute [304] .code stack 1 locals 0 
L0:     getstatic [18] 
L3:     areturn 
L4:     
    .end code 
.end method 

.method static [351] : [352] 
    .attribute [304] .code stack 1 locals 0 
L0:     ldc [19] 
L2:     putstatic [52] 
L5:     iconst_1 
L6:     putstatic [47] 
L9:     return 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Int -1225536193 
.const [3] = Method [59] [60] 
.const [4] = Class [61] 
.const [5] = Field [62] [63] 
.const [6] = Method [64] [65] 
.const [7] = Class [66] 
.const [8] = String [67] 
.const [9] = String [68] 
.const [10] = Class [69] 
.const [11] = Int 63 
.const [12] = Method [70] [71] 
.const [13] = Method [72] [73] 
.const [14] = Method [74] [75] 
.const [15] = String [76] 
.const [16] = String [77] 
.const [17] = String [78] 
.const [18] = Field [79] [80] 
.const [19] = String [81] 
.const [20] = Class [82] 
.const [21] = Class [83] 
.const [22] = Class [84] 
.const [23] = Field [85] [86] 
.const [24] = Field [87] [88] 
.const [25] = Field [89] [90] 
.const [26] = Method [91] [92] 
.const [27] = Method [93] [94] 
.const [28] = Field [95] [96] 
.const [29] = Method [97] [98] 
.const [30] = Method [99] [100] 
.const [31] = Method [101] [102] 
.const [32] = Method [103] [104] 
.const [33] = Method [105] [106] 
.const [34] = Method [107] [108] 
.const [35] = Method [109] [110] 
.const [36] = Method [111] [112] 
.const [37] = Method [113] [114] 
.const [38] = Field [115] [116] 
.const [39] = Method [117] [118] 
.const [40] = Method [119] [120] 
.const [41] = Method [121] [122] 
.const [42] = Method [123] [124] 
.const [43] = Method [125] [126] 
.const [44] = Method [127] [128] 
.const [45] = Method [129] [130] 
.const [46] = Method [131] [132] 
.const [47] = Field [133] [134] 
.const [48] = Method [135] [136] 
.const [49] = Method [137] [138] 
.const [50] = Method [139] [140] 
.const [51] = Method [141] [142] 
.const [52] = Field [143] [144] 
.const [53] = Field [145] [146] 
.const [54] = Field [147] [148] 
.const [55] = Class [149] 
.const [56] = Class [150] 
.const [57] = Class [151] 
.const [58] = Field [152] [153] 
.const [59] = Class [154] 
.const [60] = NameAndType [155] [156] 
.const [61] = Utf8 java/lang/IllegalArgumentException 
.const [62] = Class [157] 
.const [63] = NameAndType [158] [159] 
.const [64] = Class [160] 
.const [65] = NameAndType [161] [162] 
.const [66] = Utf8 java/lang/StringBuffer 
.const [67] = Utf8 'Bad parameter mode:' 
.const [68] = Utf8 ' unit:' 
.const [69] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [70] = Class [163] 
.const [71] = NameAndType [164] [165] 
.const [72] = Class [166] 
.const [73] = NameAndType [167] [168] 
.const [74] = Class [169] 
.const [75] = NameAndType [170] [171] 
.const [76] = Utf8 ' km/h' 
.const [77] = Utf8 ' mph' 
.const [78] = Utf8 '' 
.const [79] = Class [172] 
.const [80] = NameAndType [173] [174] 
.const [81] = Utf8 '---' 
.const [82] = Utf8 de/audi/atip/metrics/Speed 
.const [83] = Utf8 de/audi/atip/metrics/AbstractMetrics 
.const [84] = Utf8 java/lang/String 
.const [85] = Class [175] 
.const [86] = NameAndType [176] [177] 
.const [87] = Class [178] 
.const [88] = NameAndType [179] [180] 
.const [89] = Class [181] 
.const [90] = NameAndType [182] [183] 
.const [91] = Class [184] 
.const [92] = NameAndType [185] [186] 
.const [93] = Class [187] 
.const [94] = NameAndType [188] [189] 
.const [95] = Class [190] 
.const [96] = NameAndType [191] [192] 
.const [97] = Class [193] 
.const [98] = NameAndType [194] [195] 
.const [99] = Class [196] 
.const [100] = NameAndType [197] [198] 
.const [101] = Class [199] 
.const [102] = NameAndType [200] [201] 
.const [103] = Class [202] 
.const [104] = NameAndType [203] [204] 
.const [105] = Class [205] 
.const [106] = NameAndType [206] [207] 
.const [107] = Class [208] 
.const [108] = NameAndType [209] [210] 
.const [109] = Class [211] 
.const [110] = NameAndType [212] [213] 
.const [111] = Class [214] 
.const [112] = NameAndType [215] [216] 
.const [113] = Class [217] 
.const [114] = NameAndType [218] [219] 
.const [115] = Class [220] 
.const [116] = NameAndType [221] [222] 
.const [117] = Class [223] 
.const [118] = NameAndType [224] [225] 
.const [119] = Class [226] 
.const [120] = NameAndType [227] [228] 
.const [121] = Class [229] 
.const [122] = NameAndType [230] [231] 
.const [123] = Class [232] 
.const [124] = NameAndType [233] [234] 
.const [125] = Class [235] 
.const [126] = NameAndType [236] [237] 
.const [127] = Class [238] 
.const [128] = NameAndType [239] [240] 
.const [129] = Class [241] 
.const [130] = NameAndType [242] [243] 
.const [131] = Class [244] 
.const [132] = NameAndType [245] [246] 
.const [133] = Class [247] 
.const [134] = NameAndType [248] [249] 
.const [135] = Class [250] 
.const [136] = NameAndType [251] [252] 
.const [137] = Class [253] 
.const [138] = NameAndType [254] [255] 
.const [139] = Class [256] 
.const [140] = NameAndType [257] [258] 
.const [141] = Class [259] 
.const [142] = NameAndType [260] [261] 
.const [143] = Class [262] 
.const [144] = NameAndType [263] [264] 
.const [145] = Class [265] 
.const [146] = NameAndType [266] [267] 
.const [147] = Class [268] 
.const [148] = NameAndType [269] [270] 
.const [149] = Utf8 java/lang/IllegalArgumentException 
.const [150] = Utf8 java/lang/StringBuffer 
.const [151] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [152] = Class [271] 
.const [153] = NameAndType [272] [273] 
.const [154] = Utf8 de/audi/atip/metrics/Speed 
.const [155] = Utf8 unitIsValid 
.const [156] = Utf8 (I)Z 
.const [157] = Utf8 de/audi/atip/metrics/Speed 
.const [158] = Utf8 systemUnit 
.const [159] = Utf8 I 
.const [160] = Utf8 de/audi/atip/metrics/Speed 
.const [161] = Utf8 modeIsValid 
.const [162] = Utf8 (I)Z 
.const [163] = Utf8 de/audi/atip/metrics/Speed 
.const [164] = Utf8 getText 
.const [165] = Utf8 (I)Ljava/lang/String; 
.const [166] = Utf8 de/audi/atip/metrics/Speed 
.const [167] = Utf8 contentEquals 
.const [168] = Utf8 (Ljava/lang/String;Lde/esolutions/fw/util/commons/Buffer;)Z 
.const [169] = Utf8 de/audi/atip/metrics/AbstractMetrics 
.const [170] = Utf8 getText 
.const [171] = Utf8 (I)Ljava/lang/String; 
.const [172] = Utf8 de/audi/atip/metrics/Speed 
.const [173] = Utf8 TEXT_INVALID 
.const [174] = Utf8 Ljava/lang/String; 
.const [175] = Utf8 de/audi/atip/metrics/Speed 
.const [176] = Utf8 zeroValueFormat 
.const [177] = Utf8 I 
.const [178] = Utf8 de/audi/atip/metrics/Speed 
.const [179] = Utf8 unit 
.const [180] = Utf8 I 
.const [181] = Utf8 de/audi/atip/metrics/Speed 
.const [182] = Utf8 value 
.const [183] = Utf8 F 
.const [184] = Utf8 de/audi/atip/metrics/Speed 
.const [185] = Utf8 getValueInUnit 
.const [186] = Utf8 (I)F 
.const [187] = Utf8 de/audi/atip/metrics/Speed 
.const [188] = Utf8 formatWithMetricsMode 
.const [189] = Utf8 (I)Ljava/lang/String; 
.const [190] = Utf8 de/audi/atip/metrics/Speed 
.const [191] = Utf8 useInstanceUnit 
.const [192] = Utf8 Z 
.const [193] = Utf8 de/audi/atip/metrics/Speed 
.const [194] = Utf8 format 
.const [195] = Utf8 (II)Ljava/lang/String; 
.const [196] = Utf8 java/lang/StringBuffer 
.const [197] = Utf8 append 
.const [198] = Utf8 (Ljava/lang/String;)Ljava/lang/StringBuffer; 
.const [199] = Utf8 java/lang/StringBuffer 
.const [200] = Utf8 append 
.const [201] = Utf8 (I)Ljava/lang/StringBuffer; 
.const [202] = Utf8 java/lang/StringBuffer 
.const [203] = Utf8 toString 
.const [204] = Utf8 ()Ljava/lang/String; 
.const [205] = Utf8 de/audi/atip/metrics/Speed 
.const [206] = Utf8 getValue 
.const [207] = Utf8 (I)F 
.const [208] = Utf8 de/audi/atip/metrics/Speed 
.const [209] = Utf8 getInvalidText 
.const [210] = Utf8 ()Ljava/lang/String; 
.const [211] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [212] = Utf8 append 
.const [213] = Utf8 (Ljava/lang/String;)Lde/esolutions/fw/util/commons/Buffer; 
.const [214] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [215] = Utf8 append 
.const [216] = Utf8 (I)Lde/esolutions/fw/util/commons/Buffer; 
.const [217] = Utf8 java/lang/String 
.const [218] = Utf8 trim 
.const [219] = Utf8 ()Ljava/lang/String; 
.const [220] = Utf8 de/audi/atip/metrics/Speed 
.const [221] = Utf8 lastFormat 
.const [222] = Utf8 Ljava/lang/String; 
.const [223] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [224] = Utf8 toString 
.const [225] = Utf8 ()Ljava/lang/String; 
.const [226] = Utf8 de/audi/atip/metrics/Speed 
.const [227] = Utf8 getFormattedUnit 
.const [228] = Utf8 (I)Ljava/lang/String; 
.const [229] = Utf8 de/audi/atip/metrics/Speed 
.const [230] = Utf8 getFormattedValue 
.const [231] = Utf8 (I)Ljava/lang/String; 
.const [232] = Utf8 de/audi/atip/metrics/Speed 
.const [233] = Utf8 isMetricvalid 
.const [234] = Utf8 ()Z 
.const [235] = Utf8 de/audi/atip/metrics/AbstractMetrics 
.const [236] = Utf8 <init> 
.const [237] = Utf8 (FI)V 
.const [238] = Utf8 de/audi/atip/metrics/Speed 
.const [239] = Utf8 importValue 
.const [240] = Utf8 ()V 
.const [241] = Utf8 de/audi/atip/metrics/Speed 
.const [242] = Utf8 mph2kmph 
.const [243] = Utf8 (F)F 
.const [244] = Utf8 java/lang/IllegalArgumentException 
.const [245] = Utf8 <init> 
.const [246] = Utf8 ()V 
.const [247] = Utf8 de/audi/atip/metrics/Speed 
.const [248] = Utf8 systemUnit 
.const [249] = Utf8 I 
.const [250] = Utf8 de/audi/atip/metrics/Speed 
.const [251] = Utf8 kmph2mph 
.const [252] = Utf8 (F)F 
.const [253] = Utf8 java/lang/StringBuffer 
.const [254] = Utf8 <init> 
.const [255] = Utf8 ()V 
.const [256] = Utf8 java/lang/IllegalArgumentException 
.const [257] = Utf8 <init> 
.const [258] = Utf8 (Ljava/lang/String;)V 
.const [259] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [260] = Utf8 <init> 
.const [261] = Utf8 ()V 
.const [262] = Utf8 de/audi/atip/metrics/Speed 
.const [263] = Utf8 TEXT_INVALID 
.const [264] = Utf8 Ljava/lang/String; 
.const [265] = Utf8 de/audi/atip/metrics/Speed 
.const [266] = Utf8 zeroValueFormat 
.const [267] = Utf8 I 
.const [268] = Utf8 de/audi/atip/metrics/Speed 
.const [269] = Utf8 value 
.const [270] = Utf8 F 
.const [271] = Utf8 de/audi/atip/metrics/Speed 
.const [272] = Utf8 lastFormat 
.const [273] = Utf8 Ljava/lang/String; 
.const [274] = Utf8 de/audi/atip/metrics/Speed 
.const [275] = Class [274] 
.const [276] = Utf8 de/audi/atip/metrics/AbstractMetrics 
.const [277] = Class [276] 
.const [278] = Utf8 TEXT_KM_PER_HOUR 
.const [279] = Utf8 Ljava/lang/String; 
.const [280] = Utf8 TEXT_MILES_PER_HOUR 
.const [281] = Utf8 Ljava/lang/String; 
.const [282] = Utf8 TEXT_INVALID 
.const [283] = Utf8 Ljava/lang/String; 
.const [284] = Utf8 KM_PER_HOUR 
.const [285] = Utf8 I 
.const [286] = Utf8 MILES_PER_HOUR 
.const [287] = Utf8 I 
.const [288] = Utf8 MODE_DEFAULT 
.const [289] = Utf8 I 
.const [290] = Utf8 MODE_VALUE 
.const [291] = Utf8 I 
.const [292] = Utf8 MODE_UNIT 
.const [293] = Utf8 I 
.const [294] = Utf8 MILES2KM 
.const [295] = Utf8 F 
.const [296] = Utf8 ZERO_VALUE_FORMAT_ZEROS 
.const [297] = Utf8 I 
.const [298] = Utf8 ZERO_VALUE_FORMAT_MINUS 
.const [299] = Utf8 I 
.const [300] = Utf8 systemUnit 
.const [301] = Utf8 I 
.const [302] = Utf8 zeroValueFormat 
.const [303] = Utf8 I 
.const [304] = Utf8 Code 
.const [305] = Utf8 <init> 
.const [306] = Utf8 (FI)V 
.const [307] = Utf8 kmph2mph 
.const [308] = Utf8 (F)F 
.const [309] = Utf8 mph2kmph 
.const [310] = Utf8 (F)F 
.const [311] = Utf8 importValue 
.const [312] = Utf8 ()V 
.const [313] = Utf8 unitIsValid 
.const [314] = Utf8 (I)Z 
.const [315] = Utf8 modeIsValid 
.const [316] = Utf8 (I)Z 
.const [317] = Utf8 setSystemUnit 
.const [318] = Utf8 (I)V 
.const [319] = Utf8 getSystemUnit 
.const [320] = Utf8 ()I 
.const [321] = Utf8 setZeroValueFormat 
.const [322] = Utf8 (I)V 
.const [323] = Utf8 setValue 
.const [324] = Utf8 (F)V 
.const [325] = Utf8 getValue 
.const [326] = Utf8 ()F 
.const [327] = Utf8 getValue 
.const [328] = Utf8 (I)F 
.const [329] = Utf8 getValueInUnit 
.const [330] = Utf8 (I)F 
.const [331] = Utf8 format 
.const [332] = Utf8 ()Ljava/lang/String; 
.const [333] = Utf8 formatWithMetricsMode 
.const [334] = Utf8 (I)Ljava/lang/String; 
.const [335] = Utf8 format 
.const [336] = Utf8 (I)Ljava/lang/String; 
.const [337] = Utf8 format 
.const [338] = Utf8 (II)Ljava/lang/String; 
.const [339] = Utf8 getText 
.const [340] = Utf8 (I)Ljava/lang/String; 
.const [341] = Utf8 getFormattedMetricUnit 
.const [342] = Utf8 ()Ljava/lang/String; 
.const [343] = Utf8 getFormattedUnit 
.const [344] = Utf8 (I)Ljava/lang/String; 
.const [345] = Utf8 getFormattedValue 
.const [346] = Utf8 ()Ljava/lang/String; 
.const [347] = Utf8 getFormattedValue 
.const [348] = Utf8 (I)Ljava/lang/String; 
.const [349] = Utf8 getInvalidText 
.const [350] = Utf8 ()Ljava/lang/String; 
.const [351] = Utf8 <clinit> 
.const [352] = Utf8 ()V 
.end class 
