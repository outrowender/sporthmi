.version 50 0 
.class public final super [315] 
.super [317] 
.implements [319] 
.field public [320] [321] 
.field private static final [322] [323] 
.field public [324] [325] 
.field private static final [326] [327] 
.field public static final [328] [329] 
.field public static final [330] [331] 
.field public static final [332] [333] 
.field public static final [334] [335] 
.field public final [336] [337] 
.field public [338] [339] 
.field private static final [340] [341] 
.field public [342] [343] 
.field private static final [344] [345] 
.field public static final [346] [347] 
.field public static final [348] [349] 
.field public static final [350] [351] 
.field public static final [352] [353] 
.field public static final [354] [355] 
.field public static final [356] [357] 
.field public static final [358] [359] 
.field public static final [360] [361] 
.field public static final [362] [363] 
.field public final [364] [365] 

.method public [367] : [368] 
    .attribute [366] .code stack 3 locals 0 
L0:     aload_0 
L1:     invokespecial [52] 
L4:     aload_0 
L5:     new [59] 
L8:     dup 
L9:     invokespecial [53] 
L12:    putfield [60] 
L15:    aload_0 
L16:    new [61] 
L19:    dup 
L20:    invokespecial [54] 
L23:    putfield [62] 
L26:    aload_0 
L27:    invokespecial [55] 
L30:    aload_0 
L31:    invokespecial [56] 
L34:    return 
L35:    nop 
L36:    
    .end code 
.end method 

.method public [369] : [370] 
    .attribute [366] .code stack 2 locals 0 
L0:     aload_0 
L1:     invokespecial [57] 
L4:     aload_0 
L5:     aload_1 
L6:     invokevirtual [32] 
L9:     return 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method private [371] : [372] 
    .attribute [366] .code stack 2 locals 0 
L0:     aload_0 
L1:     iconst_0 
L2:     putfield [63] 
L5:     aload_0 
L6:     iconst_0 
L7:     putfield [64] 
L10:    aload_0 
L11:    iconst_0 
L12:    putfield [65] 
L15:    aload_0 
L16:    iconst_0 
L17:    putfield [66] 
L20:    return 
L21:    nop 
L22:    nop 
L23:    nop 
L24:    
    .end code 
.end method 

.method public [373] : [374] 
    .attribute [366] .code stack 1 locals 0 
L0:     aload_0 
L1:     invokespecial [55] 
L4:     aload_0 
L5:     getfield [30] 
L8:     invokevirtual [37] 
L11:    aload_0 
L12:    getfield [31] 
L15:    invokevirtual [38] 
L18:    return 
L19:    nop 
L20:    
    .end code 
.end method 

.method public [375] : [376] 
    .attribute [366] .code stack 2 locals 1 
L0:     aload_1 
L1:     checkcast [4] 
L4:     astore_2 
L5:     aload_0 
L6:     getfield [33] 
L9:     aload_2 
L10:    getfield [33] 
L13:    if_icmpne L81 
L16:    aload_0 
L17:    getfield [34] 
L20:    aload_2 
L21:    getfield [34] 
L24:    if_icmpne L81 
L27:    aload_0 
L28:    getfield [30] 
L31:    aload_2 
L32:    getfield [30] 
L35:    invokevirtual [39] 
L38:    ifeq L81 
L41:    aload_0 
L42:    getfield [35] 
L45:    aload_2 
L46:    getfield [35] 
L49:    if_icmpne L81 
L52:    aload_0 
L53:    getfield [36] 
L56:    aload_2 
L57:    getfield [36] 
L60:    if_icmpne L81 
L63:    aload_0 
L64:    getfield [31] 
L67:    aload_2 
L68:    getfield [31] 
L71:    invokevirtual [40] 
L74:    ifeq L81 
L77:    iconst_1 
L78:    goto L82 
L81:    iconst_0 
L82:    areturn 
L83:    nop 
L84:    
    .end code 
.end method 

.method private enum [377] : [378] 
    .attribute [366] .code stack 0 locals 0 
L0:     return 
L1:     nop 
L2:     nop 
L3:     nop 
L4:     
    .end code 
.end method 

.method public [379] : [380] 
    .attribute [366] .code stack 2 locals 1 
L0:     new [67] 
L3:     dup 
L4:     invokespecial [58] 
L7:     astore_1 
L8:     aload_1 
L9:     ldc [6] 
L11:    invokevirtual [41] 
L14:    pop 
L15:    aload_1 
L16:    ldc [7] 
L18:    invokevirtual [41] 
L21:    pop 
L22:    aload_1 
L23:    aload_0 
L24:    getfield [33] 
L27:    invokevirtual [42] 
L30:    pop 
L31:    aload_1 
L32:    ldc [8] 
L34:    invokevirtual [41] 
L37:    pop 
L38:    aload_0 
L39:    getfield [34] 
L42:    lookupswitch 
            0 : L84 
            1 : L94 
            2 : L104 
            15 : L114 
            default : L124 

L84:    aload_1 
L85:    ldc [9] 
L87:    invokevirtual [41] 
L90:    pop 
L91:    goto L131 
L94:    aload_1 
L95:    ldc [10] 
L97:    invokevirtual [41] 
L100:   pop 
L101:   goto L131 
L104:   aload_1 
L105:   ldc [11] 
L107:   invokevirtual [41] 
L110:   pop 
L111:   goto L131 
L114:   aload_1 
L115:   ldc [12] 
L117:   invokevirtual [41] 
L120:   pop 
L121:   goto L131 
L124:   aload_1 
L125:   ldc [13] 
L127:   invokevirtual [41] 
L130:   pop 
L131:   aload_1 
L132:   ldc [14] 
L134:   invokevirtual [41] 
L137:   pop 
L138:   aload_1 
L139:   aload_0 
L140:   getfield [30] 
L143:   invokevirtual [43] 
L146:   invokevirtual [41] 
L149:   pop 
L150:   aload_1 
L151:   ldc [15] 
L153:   invokevirtual [41] 
L156:   pop 
L157:   aload_1 
L158:   aload_0 
L159:   getfield [35] 
L162:   invokevirtual [42] 
L165:   pop 
L166:   aload_1 
L167:   ldc [16] 
L169:   invokevirtual [41] 
L172:   pop 
L173:   aload_0 
L174:   getfield [36] 
L177:   lookupswitch 
            0 : L260 
            1 : L270 
            2 : L280 
            3 : L290 
            4 : L300 
            5 : L310 
            6 : L320 
            7 : L330 
            255 : L340 
            default : L350 

L260:   aload_1 
L261:   ldc [17] 
L263:   invokevirtual [41] 
L266:   pop 
L267:   goto L357 
L270:   aload_1 
L271:   ldc [18] 
L273:   invokevirtual [41] 
L276:   pop 
L277:   goto L357 
L280:   aload_1 
L281:   ldc [19] 
L283:   invokevirtual [41] 
L286:   pop 
L287:   goto L357 
L290:   aload_1 
L291:   ldc [20] 
L293:   invokevirtual [41] 
L296:   pop 
L297:   goto L357 
L300:   aload_1 
L301:   ldc [21] 
L303:   invokevirtual [41] 
L306:   pop 
L307:   goto L357 
L310:   aload_1 
L311:   ldc [22] 
L313:   invokevirtual [41] 
L316:   pop 
L317:   goto L357 
L320:   aload_1 
L321:   ldc [23] 
L323:   invokevirtual [41] 
L326:   pop 
L327:   goto L357 
L330:   aload_1 
L331:   ldc [24] 
L333:   invokevirtual [41] 
L336:   pop 
L337:   goto L357 
L340:   aload_1 
L341:   ldc [25] 
L343:   invokevirtual [41] 
L346:   pop 
L347:   goto L357 
L350:   aload_1 
L351:   ldc [13] 
L353:   invokevirtual [41] 
L356:   pop 
L357:   aload_1 
L358:   ldc [26] 
L360:   invokevirtual [41] 
L363:   pop 
L364:   aload_1 
L365:   aload_0 
L366:   getfield [31] 
L369:   invokevirtual [44] 
L372:   invokevirtual [41] 
L375:   pop 
L376:   aload_1 
L377:   invokevirtual [45] 
L380:   areturn 
L381:   nop 
L382:   nop 
L383:   nop 
L384:   
    .end code 
.end method 

.method public [381] : [382] 
    .attribute [366] .code stack 2 locals 1 
L0:     iconst_0 
L1:     istore_1 
L2:     iinc 1 8 
L5:     iinc 1 4 
L8:     iload_1 
L9:     aload_0 
L10:    getfield [30] 
L13:    invokevirtual [46] 
L16:    iadd 
L17:    istore_1 
L18:    iinc 1 16 
L21:    iinc 1 8 
L24:    iload_1 
L25:    aload_0 
L26:    getfield [31] 
L29:    invokevirtual [47] 
L32:    iadd 
L33:    istore_1 
L34:    iload_1 
L35:    areturn 
L36:    
    .end code 
.end method 

.method public [383] : [384] 
    .attribute [366] .code stack 3 locals 0 
L0:     aload_1 
L1:     aload_0 
L2:     getfield [33] 
L5:     i2b 
L6:     invokeinterface [68] 0 
L11:    aload_1 
L12:    iconst_4 
L13:    aload_0 
L14:    getfield [34] 
L17:    invokeinterface [69] 0 
L22:    aload_0 
L23:    getfield [30] 
L26:    aload_1 
L27:    invokevirtual [48] 
L30:    aload_1 
L31:    aload_0 
L32:    getfield [35] 
L35:    i2s 
L36:    invokeinterface [70] 0 
L41:    aload_1 
L42:    aload_0 
L43:    getfield [36] 
L46:    i2b 
L47:    invokeinterface [68] 0 
L52:    aload_0 
L53:    getfield [31] 
L56:    aload_1 
L57:    invokevirtual [49] 
L60:    return 
L61:    nop 
L62:    nop 
L63:    nop 
L64:    
    .end code 
.end method 

.method public [385] : [386] 
    .attribute [366] .code stack 3 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     invokeinterface [71] 0 
L7:     putfield [63] 
L10:    aload_0 
L11:    aload_1 
L12:    iconst_4 
L13:    invokeinterface [72] 0 
L18:    putfield [64] 
L21:    aload_0 
L22:    getfield [30] 
L25:    aload_1 
L26:    invokevirtual [50] 
L29:    aload_0 
L30:    aload_1 
L31:    invokeinterface [73] 0 
L36:    putfield [65] 
L39:    aload_0 
L40:    aload_1 
L41:    invokeinterface [71] 0 
L46:    putfield [66] 
L49:    aload_0 
L50:    getfield [31] 
L53:    aload_1 
L54:    invokevirtual [51] 
L57:    return 
L58:    nop 
L59:    nop 
L60:    
    .end code 
.end method 

.method public static [387] : [388] 
    .attribute [366] .code stack 1 locals 0 
L0:     bipush 45 
L2:     areturn 
L3:     nop 
L4:     
    .end code 
.end method 

.method public [389] : [390] 
    .attribute [366] .code stack 1 locals 0 
L0:     invokestatic [27] 
L3:     areturn 
L4:     
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [74] 
.const [3] = Class [75] 
.const [4] = Class [76] 
.const [5] = Class [77] 
.const [6] = String [78] 
.const [7] = String [79] 
.const [8] = String [80] 
.const [9] = String [81] 
.const [10] = String [82] 
.const [11] = String [83] 
.const [12] = String [84] 
.const [13] = String [85] 
.const [14] = String [86] 
.const [15] = String [87] 
.const [16] = String [88] 
.const [17] = String [89] 
.const [18] = String [90] 
.const [19] = String [91] 
.const [20] = String [92] 
.const [21] = String [93] 
.const [22] = String [94] 
.const [23] = String [95] 
.const [24] = String [96] 
.const [25] = String [97] 
.const [26] = String [98] 
.const [27] = Method [99] [100] 
.const [28] = Class [101] 
.const [29] = Class [102] 
.const [30] = Field [103] [104] 
.const [31] = Field [105] [106] 
.const [32] = Method [107] [108] 
.const [33] = Field [109] [110] 
.const [34] = Field [111] [112] 
.const [35] = Field [113] [114] 
.const [36] = Field [115] [116] 
.const [37] = Method [117] [118] 
.const [38] = Method [119] [120] 
.const [39] = Method [121] [122] 
.const [40] = Method [123] [124] 
.const [41] = Method [125] [126] 
.const [42] = Method [127] [128] 
.const [43] = Method [129] [130] 
.const [44] = Method [131] [132] 
.const [45] = Method [133] [134] 
.const [46] = Method [135] [136] 
.const [47] = Method [137] [138] 
.const [48] = Method [139] [140] 
.const [49] = Method [141] [142] 
.const [50] = Method [143] [144] 
.const [51] = Method [145] [146] 
.const [52] = Method [147] [148] 
.const [53] = Method [149] [150] 
.const [54] = Method [151] [152] 
.const [55] = Method [153] [154] 
.const [56] = Method [155] [156] 
.const [57] = Method [157] [158] 
.const [58] = Method [159] [160] 
.const [59] = Class [161] 
.const [60] = Field [162] [163] 
.const [61] = Class [164] 
.const [62] = Field [165] [166] 
.const [63] = Field [167] [168] 
.const [64] = Field [169] [170] 
.const [65] = Field [171] [172] 
.const [66] = Field [173] [174] 
.const [67] = Class [175] 
.const [68] = InterfaceMethod [176] [177] 
.const [69] = InterfaceMethod [178] [179] 
.const [70] = InterfaceMethod [180] [181] 
.const [71] = InterfaceMethod [182] [183] 
.const [72] = InterfaceMethod [184] [185] 
.const [73] = InterfaceMethod [186] [187] 
.const [74] = Utf8 de/vw/mib/bap/generated/navsd/serializer/MapScale_AutoZoomState 
.const [75] = Utf8 de/vw/mib/bap/generated/navsd/serializer/MapScale_Status$SupportedAutoZoom 
.const [76] = Utf8 de/vw/mib/bap/generated/navsd/serializer/MapScale_Status 
.const [77] = Utf8 java/lang/StringBuffer 
.const [78] = Utf8 'MapScale_Status:' 
.const [79] = Utf8 '\n - Reserve1 - ' 
.const [80] = Utf8 '\n - AutoZoom: ' 
.const [81] = Utf8 '0x0 (AutoZoom OFF)' 
.const [82] = Utf8 '0x1 (AutoZoom ON)' 
.const [83] = Utf8 '0x2 (AutoZoom ON for Intersection)' 
.const [84] = Utf8 '0xF (AutoZoom setting not supported)' 
.const [85] = Utf8 'UNKNOWN ENUM' 
.const [86] = Utf8 '\n - AutoZoomState - ' 
.const [87] = Utf8 '\n - Scale - ' 
.const [88] = Utf8 '\n - Unit: ' 
.const [89] = Utf8 '0x00 (meter)' 
.const [90] = Utf8 '0x01 (kilometer)' 
.const [91] = Utf8 '0x02 (yard)' 
.const [92] = Utf8 '0x03 (feet)' 
.const [93] = Utf8 '0x04 (mile (UK and US (statute mile)))' 
.const [94] = Utf8 '0x05 (quarter mile(s) (n* 1/4mile))' 
.const [95] = Utf8 '0x06 (kilometer (step 0.1))' 
.const [96] = Utf8 '0x07 (mile (UK and US (statute mile), (step 0.1)))' 
.const [97] = Utf8 '0xFF (not supported / no information available)' 
.const [98] = Utf8 '\n - SupportedAutoZoom - ' 
.const [99] = Class [188] 
.const [100] = NameAndType [189] [190] 
.const [101] = Utf8 java/lang/Object 
.const [102] = Utf8 de/vw/mib/bap/stream/BitStream 
.const [103] = Class [191] 
.const [104] = NameAndType [192] [193] 
.const [105] = Class [194] 
.const [106] = NameAndType [195] [196] 
.const [107] = Class [197] 
.const [108] = NameAndType [198] [199] 
.const [109] = Class [200] 
.const [110] = NameAndType [201] [202] 
.const [111] = Class [203] 
.const [112] = NameAndType [204] [205] 
.const [113] = Class [206] 
.const [114] = NameAndType [207] [208] 
.const [115] = Class [209] 
.const [116] = NameAndType [210] [211] 
.const [117] = Class [212] 
.const [118] = NameAndType [213] [214] 
.const [119] = Class [215] 
.const [120] = NameAndType [216] [217] 
.const [121] = Class [218] 
.const [122] = NameAndType [219] [220] 
.const [123] = Class [221] 
.const [124] = NameAndType [222] [223] 
.const [125] = Class [224] 
.const [126] = NameAndType [225] [226] 
.const [127] = Class [227] 
.const [128] = NameAndType [228] [229] 
.const [129] = Class [230] 
.const [130] = NameAndType [231] [232] 
.const [131] = Class [233] 
.const [132] = NameAndType [234] [235] 
.const [133] = Class [236] 
.const [134] = NameAndType [237] [238] 
.const [135] = Class [239] 
.const [136] = NameAndType [240] [241] 
.const [137] = Class [242] 
.const [138] = NameAndType [243] [244] 
.const [139] = Class [245] 
.const [140] = NameAndType [246] [247] 
.const [141] = Class [248] 
.const [142] = NameAndType [249] [250] 
.const [143] = Class [251] 
.const [144] = NameAndType [252] [253] 
.const [145] = Class [254] 
.const [146] = NameAndType [255] [256] 
.const [147] = Class [257] 
.const [148] = NameAndType [258] [259] 
.const [149] = Class [260] 
.const [150] = NameAndType [261] [262] 
.const [151] = Class [263] 
.const [152] = NameAndType [264] [265] 
.const [153] = Class [266] 
.const [154] = NameAndType [267] [268] 
.const [155] = Class [269] 
.const [156] = NameAndType [270] [271] 
.const [157] = Class [272] 
.const [158] = NameAndType [273] [274] 
.const [159] = Class [275] 
.const [160] = NameAndType [276] [277] 
.const [161] = Utf8 de/vw/mib/bap/generated/navsd/serializer/MapScale_AutoZoomState 
.const [162] = Class [278] 
.const [163] = NameAndType [279] [280] 
.const [164] = Utf8 de/vw/mib/bap/generated/navsd/serializer/MapScale_Status$SupportedAutoZoom 
.const [165] = Class [281] 
.const [166] = NameAndType [282] [283] 
.const [167] = Class [284] 
.const [168] = NameAndType [285] [286] 
.const [169] = Class [287] 
.const [170] = NameAndType [288] [289] 
.const [171] = Class [290] 
.const [172] = NameAndType [291] [292] 
.const [173] = Class [293] 
.const [174] = NameAndType [294] [295] 
.const [175] = Utf8 java/lang/StringBuffer 
.const [176] = Class [296] 
.const [177] = NameAndType [297] [298] 
.const [178] = Class [299] 
.const [179] = NameAndType [300] [301] 
.const [180] = Class [302] 
.const [181] = NameAndType [303] [304] 
.const [182] = Class [305] 
.const [183] = NameAndType [306] [307] 
.const [184] = Class [308] 
.const [185] = NameAndType [309] [310] 
.const [186] = Class [311] 
.const [187] = NameAndType [312] [313] 
.const [188] = Utf8 de/vw/mib/bap/generated/navsd/serializer/MapScale_Status 
.const [189] = Utf8 functionId 
.const [190] = Utf8 ()I 
.const [191] = Utf8 de/vw/mib/bap/generated/navsd/serializer/MapScale_Status 
.const [192] = Utf8 autoZoomState 
.const [193] = Utf8 Lde/vw/mib/bap/generated/navsd/serializer/MapScale_AutoZoomState; 
.const [194] = Utf8 de/vw/mib/bap/generated/navsd/serializer/MapScale_Status 
.const [195] = Utf8 supportedAutoZoom 
.const [196] = Utf8 Lde/vw/mib/bap/generated/navsd/serializer/MapScale_Status$SupportedAutoZoom; 
.const [197] = Utf8 de/vw/mib/bap/generated/navsd/serializer/MapScale_Status 
.const [198] = Utf8 deserialize 
.const [199] = Utf8 (Lde/vw/mib/bap/stream/BitStream;)V 
.const [200] = Utf8 de/vw/mib/bap/generated/navsd/serializer/MapScale_Status 
.const [201] = Utf8 reserve1 
.const [202] = Utf8 I 
.const [203] = Utf8 de/vw/mib/bap/generated/navsd/serializer/MapScale_Status 
.const [204] = Utf8 autoZoom 
.const [205] = Utf8 I 
.const [206] = Utf8 de/vw/mib/bap/generated/navsd/serializer/MapScale_Status 
.const [207] = Utf8 scale 
.const [208] = Utf8 I 
.const [209] = Utf8 de/vw/mib/bap/generated/navsd/serializer/MapScale_Status 
.const [210] = Utf8 unit 
.const [211] = Utf8 I 
.const [212] = Utf8 de/vw/mib/bap/generated/navsd/serializer/MapScale_AutoZoomState 
.const [213] = Utf8 reset 
.const [214] = Utf8 ()V 
.const [215] = Utf8 de/vw/mib/bap/generated/navsd/serializer/MapScale_Status$SupportedAutoZoom 
.const [216] = Utf8 reset 
.const [217] = Utf8 ()V 
.const [218] = Utf8 de/vw/mib/bap/generated/navsd/serializer/MapScale_AutoZoomState 
.const [219] = Utf8 equalTo 
.const [220] = Utf8 (Lde/vw/mib/bap/datatypes/BAPEntity;)Z 
.const [221] = Utf8 de/vw/mib/bap/generated/navsd/serializer/MapScale_Status$SupportedAutoZoom 
.const [222] = Utf8 equalTo 
.const [223] = Utf8 (Lde/vw/mib/bap/datatypes/BAPEntity;)Z 
.const [224] = Utf8 java/lang/StringBuffer 
.const [225] = Utf8 append 
.const [226] = Utf8 (Ljava/lang/String;)Ljava/lang/StringBuffer; 
.const [227] = Utf8 java/lang/StringBuffer 
.const [228] = Utf8 append 
.const [229] = Utf8 (I)Ljava/lang/StringBuffer; 
.const [230] = Utf8 de/vw/mib/bap/generated/navsd/serializer/MapScale_AutoZoomState 
.const [231] = Utf8 toString 
.const [232] = Utf8 ()Ljava/lang/String; 
.const [233] = Utf8 de/vw/mib/bap/generated/navsd/serializer/MapScale_Status$SupportedAutoZoom 
.const [234] = Utf8 toString 
.const [235] = Utf8 ()Ljava/lang/String; 
.const [236] = Utf8 java/lang/StringBuffer 
.const [237] = Utf8 toString 
.const [238] = Utf8 ()Ljava/lang/String; 
.const [239] = Utf8 de/vw/mib/bap/generated/navsd/serializer/MapScale_AutoZoomState 
.const [240] = Utf8 bitSize 
.const [241] = Utf8 ()I 
.const [242] = Utf8 de/vw/mib/bap/generated/navsd/serializer/MapScale_Status$SupportedAutoZoom 
.const [243] = Utf8 bitSize 
.const [244] = Utf8 ()I 
.const [245] = Utf8 de/vw/mib/bap/generated/navsd/serializer/MapScale_AutoZoomState 
.const [246] = Utf8 serialize 
.const [247] = Utf8 (Lde/vw/mib/bap/stream/BitStream;)V 
.const [248] = Utf8 de/vw/mib/bap/generated/navsd/serializer/MapScale_Status$SupportedAutoZoom 
.const [249] = Utf8 serialize 
.const [250] = Utf8 (Lde/vw/mib/bap/stream/BitStream;)V 
.const [251] = Utf8 de/vw/mib/bap/generated/navsd/serializer/MapScale_AutoZoomState 
.const [252] = Utf8 deserialize 
.const [253] = Utf8 (Lde/vw/mib/bap/stream/BitStream;)V 
.const [254] = Utf8 de/vw/mib/bap/generated/navsd/serializer/MapScale_Status$SupportedAutoZoom 
.const [255] = Utf8 deserialize 
.const [256] = Utf8 (Lde/vw/mib/bap/stream/BitStream;)V 
.const [257] = Utf8 java/lang/Object 
.const [258] = Utf8 <init> 
.const [259] = Utf8 ()V 
.const [260] = Utf8 de/vw/mib/bap/generated/navsd/serializer/MapScale_AutoZoomState 
.const [261] = Utf8 <init> 
.const [262] = Utf8 ()V 
.const [263] = Utf8 de/vw/mib/bap/generated/navsd/serializer/MapScale_Status$SupportedAutoZoom 
.const [264] = Utf8 <init> 
.const [265] = Utf8 ()V 
.const [266] = Utf8 de/vw/mib/bap/generated/navsd/serializer/MapScale_Status 
.const [267] = Utf8 internalReset 
.const [268] = Utf8 ()V 
.const [269] = Utf8 de/vw/mib/bap/generated/navsd/serializer/MapScale_Status 
.const [270] = Utf8 customInitialization 
.const [271] = Utf8 ()V 
.const [272] = Utf8 de/vw/mib/bap/generated/navsd/serializer/MapScale_Status 
.const [273] = Utf8 <init> 
.const [274] = Utf8 ()V 
.const [275] = Utf8 java/lang/StringBuffer 
.const [276] = Utf8 <init> 
.const [277] = Utf8 ()V 
.const [278] = Utf8 de/vw/mib/bap/generated/navsd/serializer/MapScale_Status 
.const [279] = Utf8 autoZoomState 
.const [280] = Utf8 Lde/vw/mib/bap/generated/navsd/serializer/MapScale_AutoZoomState; 
.const [281] = Utf8 de/vw/mib/bap/generated/navsd/serializer/MapScale_Status 
.const [282] = Utf8 supportedAutoZoom 
.const [283] = Utf8 Lde/vw/mib/bap/generated/navsd/serializer/MapScale_Status$SupportedAutoZoom; 
.const [284] = Utf8 de/vw/mib/bap/generated/navsd/serializer/MapScale_Status 
.const [285] = Utf8 reserve1 
.const [286] = Utf8 I 
.const [287] = Utf8 de/vw/mib/bap/generated/navsd/serializer/MapScale_Status 
.const [288] = Utf8 autoZoom 
.const [289] = Utf8 I 
.const [290] = Utf8 de/vw/mib/bap/generated/navsd/serializer/MapScale_Status 
.const [291] = Utf8 scale 
.const [292] = Utf8 I 
.const [293] = Utf8 de/vw/mib/bap/generated/navsd/serializer/MapScale_Status 
.const [294] = Utf8 unit 
.const [295] = Utf8 I 
.const [296] = Utf8 de/vw/mib/bap/stream/BitStream 
.const [297] = Utf8 pushByte 
.const [298] = Utf8 (B)V 
.const [299] = Utf8 de/vw/mib/bap/stream/BitStream 
.const [300] = Utf8 pushBits 
.const [301] = Utf8 (II)V 
.const [302] = Utf8 de/vw/mib/bap/stream/BitStream 
.const [303] = Utf8 pushShort 
.const [304] = Utf8 (S)V 
.const [305] = Utf8 de/vw/mib/bap/stream/BitStream 
.const [306] = Utf8 popFrontByte 
.const [307] = Utf8 ()I 
.const [308] = Utf8 de/vw/mib/bap/stream/BitStream 
.const [309] = Utf8 popFrontBits 
.const [310] = Utf8 (I)I 
.const [311] = Utf8 de/vw/mib/bap/stream/BitStream 
.const [312] = Utf8 popFrontShort 
.const [313] = Utf8 ()I 
.const [314] = Utf8 de/vw/mib/bap/generated/navsd/serializer/MapScale_Status 
.const [315] = Class [314] 
.const [316] = Utf8 java/lang/Object 
.const [317] = Class [316] 
.const [318] = Utf8 de/vw/mib/bap/requests/StatusProperty 
.const [319] = Class [318] 
.const [320] = Utf8 reserve1 
.const [321] = Utf8 I 
.const [322] = Utf8 RESERVE1_BITSIZE 
.const [323] = Utf8 I 
.const [324] = Utf8 autoZoom 
.const [325] = Utf8 I 
.const [326] = Utf8 AUTO_ZOOM_BITSIZE 
.const [327] = Utf8 I 
.const [328] = Utf8 AUTO_ZOOM_AUTO_ZOOM_OFF 
.const [329] = Utf8 I 
.const [330] = Utf8 AUTO_ZOOM_AUTO_ZOOM_ON 
.const [331] = Utf8 I 
.const [332] = Utf8 AUTO_ZOOM_AUTO_ZOOM_ON_FOR_INTERSECTION 
.const [333] = Utf8 I 
.const [334] = Utf8 AUTO_ZOOM_AUTO_ZOOM_SETTING_NOT_SUPPORTED 
.const [335] = Utf8 I 
.const [336] = Utf8 autoZoomState 
.const [337] = Utf8 Lde/vw/mib/bap/generated/navsd/serializer/MapScale_AutoZoomState; 
.const [338] = Utf8 scale 
.const [339] = Utf8 I 
.const [340] = Utf8 SCALE_BITSIZE 
.const [341] = Utf8 I 
.const [342] = Utf8 unit 
.const [343] = Utf8 I 
.const [344] = Utf8 UNIT_BITSIZE 
.const [345] = Utf8 I 
.const [346] = Utf8 UNIT_METER 
.const [347] = Utf8 I 
.const [348] = Utf8 UNIT_KILOMETER 
.const [349] = Utf8 I 
.const [350] = Utf8 UNIT_YARD 
.const [351] = Utf8 I 
.const [352] = Utf8 UNIT_FEET 
.const [353] = Utf8 I 
.const [354] = Utf8 UNIT_MILE_UK_AND_US_STATUTE_MILE 
.const [355] = Utf8 I 
.const [356] = Utf8 UNIT_QUARTER_MILES_N_1_4MILE 
.const [357] = Utf8 I 
.const [358] = Utf8 UNIT_KILOMETER_STEP_0_1 
.const [359] = Utf8 I 
.const [360] = Utf8 UNIT_MILE_UK_AND_US_STATUTE_MILE_STEP_0_1 
.const [361] = Utf8 I 
.const [362] = Utf8 UNIT_NOT_SUPPORTED_NO_INFORMATION_AVAILABLE 
.const [363] = Utf8 I 
.const [364] = Utf8 supportedAutoZoom 
.const [365] = Utf8 Lde/vw/mib/bap/generated/navsd/serializer/MapScale_Status$SupportedAutoZoom; 
.const [366] = Utf8 Code 
.const [367] = Utf8 <init> 
.const [368] = Utf8 ()V 
.const [369] = Utf8 <init> 
.const [370] = Utf8 (Lde/vw/mib/bap/stream/BitStream;)V 
.const [371] = Utf8 internalReset 
.const [372] = Utf8 ()V 
.const [373] = Utf8 reset 
.const [374] = Utf8 ()V 
.const [375] = Utf8 equalTo 
.const [376] = Utf8 (Lde/vw/mib/bap/datatypes/BAPEntity;)Z 
.const [377] = Utf8 customInitialization 
.const [378] = Utf8 ()V 
.const [379] = Utf8 toString 
.const [380] = Utf8 ()Ljava/lang/String; 
.const [381] = Utf8 bitSize 
.const [382] = Utf8 ()I 
.const [383] = Utf8 serialize 
.const [384] = Utf8 (Lde/vw/mib/bap/stream/BitStream;)V 
.const [385] = Utf8 deserialize 
.const [386] = Utf8 (Lde/vw/mib/bap/stream/BitStream;)V 
.const [387] = Utf8 functionId 
.const [388] = Utf8 ()I 
.const [389] = Utf8 getFunctionId 
.const [390] = Utf8 ()I 
.end class 
