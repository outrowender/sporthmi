.version 50 0 
.class public final super [331] 
.super [333] 
.implements [335] 
.field public [336] [337] 
.field public static final [338] [339] 
.field public [340] [341] 
.field public static final [342] [343] 
.field public [344] [345] 
.field public [346] [347] 
.field public [348] [349] 
.field public [350] [351] 
.field public static final [352] [353] 
.field public [354] [355] 
.field public static final [356] [357] 
.field public [358] [359] 
.field public static final [360] [361] 

.method public [363] : [364] 
    .attribute [362] .code stack 3 locals 0 
L0:     aload_0 
L1:     invokespecial [46] 
L4:     aload_0 
L5:     new [54] 
L8:     dup 
L9:     invokespecial [47] 
L12:    putfield [55] 
L15:    aload_0 
L16:    new [56] 
L19:    dup 
L20:    invokespecial [48] 
L23:    putfield [57] 
L26:    aload_0 
L27:    new [58] 
L30:    dup 
L31:    invokespecial [49] 
L34:    putfield [59] 
L37:    aload_0 
L38:    invokespecial [50] 
L41:    aload_0 
L42:    invokespecial [51] 
L45:    return 
L46:    nop 
L47:    nop 
L48:    
    .end code 
.end method 

.method public [365] : [366] 
    .attribute [362] .code stack 2 locals 0 
L0:     aload_0 
L1:     invokespecial [52] 
L4:     aload_0 
L5:     aload_1 
L6:     invokevirtual [22] 
L9:     return 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method private [367] : [368] 
    .attribute [362] .code stack 2 locals 0 
L0:     aload_0 
L1:     iconst_0 
L2:     putfield [60] 
L5:     aload_0 
L6:     iconst_0 
L7:     putfield [61] 
L10:    aload_0 
L11:    iconst_1 
L12:    putfield [62] 
L15:    aload_0 
L16:    iconst_0 
L17:    putfield [63] 
L20:    aload_0 
L21:    iconst_0 
L22:    putfield [64] 
L25:    return 
L26:    nop 
L27:    nop 
L28:    
    .end code 
.end method 

.method public [369] : [370] 
    .attribute [362] .code stack 1 locals 0 
L0:     aload_0 
L1:     invokespecial [50] 
L4:     aload_0 
L5:     getfield [19] 
L8:     invokevirtual [28] 
L11:    aload_0 
L12:    getfield [20] 
L15:    invokevirtual [29] 
L18:    aload_0 
L19:    getfield [21] 
L22:    invokevirtual [30] 
L25:    return 
L26:    nop 
L27:    nop 
L28:    
    .end code 
.end method 

.method public [371] : [372] 
    .attribute [362] .code stack 2 locals 1 
L0:     aload_1 
L1:     checkcast [5] 
L4:     astore_2 
L5:     aload_0 
L6:     getfield [23] 
L9:     aload_2 
L10:    getfield [23] 
L13:    if_icmpne L106 
L16:    aload_0 
L17:    getfield [24] 
L20:    aload_2 
L21:    getfield [24] 
L24:    if_icmpne L106 
L27:    aload_0 
L28:    getfield [19] 
L31:    aload_2 
L32:    getfield [19] 
L35:    invokevirtual [31] 
L38:    ifeq L106 
L41:    aload_0 
L42:    getfield [20] 
L45:    aload_2 
L46:    getfield [20] 
L49:    invokevirtual [32] 
L52:    ifeq L106 
L55:    aload_0 
L56:    getfield [21] 
L59:    aload_2 
L60:    getfield [21] 
L63:    invokevirtual [33] 
L66:    ifeq L106 
L69:    aload_0 
L70:    getfield [25] 
L73:    aload_2 
L74:    getfield [25] 
L77:    if_icmpne L106 
L80:    aload_0 
L81:    getfield [26] 
L84:    aload_2 
L85:    getfield [26] 
L88:    if_icmpne L106 
L91:    aload_0 
L92:    getfield [27] 
L95:    aload_2 
L96:    getfield [27] 
L99:    if_icmpne L106 
L102:   iconst_1 
L103:   goto L107 
L106:   iconst_0 
L107:   areturn 
L108:   
    .end code 
.end method 

.method private enum [373] : [374] 
    .attribute [362] .code stack 0 locals 0 
L0:     return 
L1:     nop 
L2:     nop 
L3:     nop 
L4:     
    .end code 
.end method 

.method public [375] : [376] 
    .attribute [362] .code stack 3 locals 1 
L0:     new [65] 
L3:     dup 
L4:     invokespecial [53] 
L7:     astore_1 
L8:     aload_1 
L9:     ldc [7] 
L11:    invokevirtual [34] 
L14:    pop 
L15:    aload_1 
L16:    new [65] 
L19:    dup 
L20:    invokespecial [53] 
L23:    ldc [8] 
L25:    invokevirtual [34] 
L28:    aload_0 
L29:    getfield [23] 
L32:    invokevirtual [35] 
L35:    invokevirtual [36] 
L38:    invokevirtual [34] 
L41:    pop 
L42:    aload_1 
L43:    new [65] 
L46:    dup 
L47:    invokespecial [53] 
L50:    ldc [9] 
L52:    invokevirtual [34] 
L55:    aload_0 
L56:    getfield [24] 
L59:    invokevirtual [35] 
L62:    invokevirtual [36] 
L65:    invokevirtual [34] 
L68:    pop 
L69:    aload_1 
L70:    new [65] 
L73:    dup 
L74:    invokespecial [53] 
L77:    ldc [10] 
L79:    invokevirtual [34] 
L82:    aload_0 
L83:    getfield [19] 
L86:    invokevirtual [37] 
L89:    invokevirtual [34] 
L92:    invokevirtual [36] 
L95:    invokevirtual [34] 
L98:    pop 
L99:    aload_1 
L100:   new [65] 
L103:   dup 
L104:   invokespecial [53] 
L107:   ldc [11] 
L109:   invokevirtual [34] 
L112:   aload_0 
L113:   getfield [20] 
L116:   invokevirtual [38] 
L119:   invokevirtual [34] 
L122:   invokevirtual [36] 
L125:   invokevirtual [34] 
L128:   pop 
L129:   aload_1 
L130:   new [65] 
L133:   dup 
L134:   invokespecial [53] 
L137:   ldc [12] 
L139:   invokevirtual [34] 
L142:   aload_0 
L143:   getfield [21] 
L146:   invokevirtual [39] 
L149:   invokevirtual [34] 
L152:   invokevirtual [36] 
L155:   invokevirtual [34] 
L158:   pop 
L159:   aload_1 
L160:   new [65] 
L163:   dup 
L164:   invokespecial [53] 
L167:   ldc [13] 
L169:   invokevirtual [34] 
L172:   aload_0 
L173:   getfield [25] 
L176:   invokevirtual [35] 
L179:   invokevirtual [36] 
L182:   invokevirtual [34] 
L185:   pop 
L186:   aload_1 
L187:   new [65] 
L190:   dup 
L191:   invokespecial [53] 
L194:   ldc [14] 
L196:   invokevirtual [34] 
L199:   aload_0 
L200:   getfield [26] 
L203:   invokevirtual [35] 
L206:   invokevirtual [36] 
L209:   invokevirtual [34] 
L212:   pop 
L213:   aload_1 
L214:   new [65] 
L217:   dup 
L218:   invokespecial [53] 
L221:   ldc [15] 
L223:   invokevirtual [34] 
L226:   aload_0 
L227:   getfield [27] 
L230:   invokevirtual [35] 
L233:   invokevirtual [36] 
L236:   invokevirtual [34] 
L239:   pop 
L240:   aload_1 
L241:   invokevirtual [36] 
L244:   areturn 
L245:   nop 
L246:   nop 
L247:   nop 
L248:   
    .end code 
.end method 

.method public [377] : [378] 
    .attribute [362] .code stack 1 locals 0 
L0:     iconst_0 
L1:     areturn 
L2:     nop 
L3:     nop 
L4:     
    .end code 
.end method 

.method public [379] : [380] 
    .attribute [362] .code stack 2 locals 0 
L0:     aload_1 
L1:     aload_0 
L2:     getfield [23] 
L5:     i2b 
L6:     invokeinterface [66] 0 
L11:    aload_1 
L12:    aload_0 
L13:    getfield [24] 
L16:    i2b 
L17:    invokeinterface [66] 0 
L22:    aload_0 
L23:    getfield [19] 
L26:    aload_1 
L27:    invokevirtual [40] 
L30:    aload_0 
L31:    getfield [20] 
L34:    aload_1 
L35:    invokevirtual [41] 
L38:    aload_0 
L39:    getfield [21] 
L42:    aload_1 
L43:    invokevirtual [42] 
L46:    aload_1 
L47:    aload_0 
L48:    getfield [25] 
L51:    invokeinterface [67] 0 
L56:    aload_1 
L57:    aload_0 
L58:    getfield [26] 
L61:    invokeinterface [67] 0 
L66:    aload_1 
L67:    aload_0 
L68:    getfield [27] 
L71:    i2b 
L72:    invokeinterface [66] 0 
L77:    return 
L78:    nop 
L79:    nop 
L80:    
    .end code 
.end method 

.method public [381] : [382] 
    .attribute [362] .code stack 2 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     invokeinterface [68] 0 
L7:     putfield [60] 
L10:    aload_0 
L11:    aload_1 
L12:    invokeinterface [68] 0 
L17:    putfield [61] 
L20:    aload_0 
L21:    getfield [19] 
L24:    aload_1 
L25:    invokevirtual [43] 
L28:    aload_0 
L29:    getfield [20] 
L32:    aload_1 
L33:    invokevirtual [44] 
L36:    aload_0 
L37:    getfield [21] 
L40:    aload_1 
L41:    invokevirtual [45] 
L44:    aload_0 
L45:    aload_1 
L46:    invokeinterface [69] 0 
L51:    putfield [62] 
L54:    aload_0 
L55:    aload_1 
L56:    invokeinterface [69] 0 
L61:    putfield [63] 
L64:    aload_0 
L65:    aload_1 
L66:    invokeinterface [68] 0 
L71:    putfield [64] 
L74:    return 
L75:    nop 
L76:    
    .end code 
.end method 

.method public static [383] : [384] 
    .attribute [362] .code stack 1 locals 0 
L0:     bipush 33 
L2:     areturn 
L3:     nop 
L4:     
    .end code 
.end method 

.method public [385] : [386] 
    .attribute [362] .code stack 1 locals 0 
L0:     invokestatic [16] 
L3:     areturn 
L4:     
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [70] 
.const [3] = Class [71] 
.const [4] = Class [72] 
.const [5] = Class [73] 
.const [6] = Class [74] 
.const [7] = String [75] 
.const [8] = String [76] 
.const [9] = String [77] 
.const [10] = String [78] 
.const [11] = String [79] 
.const [12] = String [80] 
.const [13] = String [81] 
.const [14] = String [82] 
.const [15] = String [83] 
.const [16] = Method [84] [85] 
.const [17] = Class [86] 
.const [18] = Class [87] 
.const [19] = Field [88] [89] 
.const [20] = Field [90] [91] 
.const [21] = Field [92] [93] 
.const [22] = Method [94] [95] 
.const [23] = Field [96] [97] 
.const [24] = Field [98] [99] 
.const [25] = Field [100] [101] 
.const [26] = Field [102] [103] 
.const [27] = Field [104] [105] 
.const [28] = Method [106] [107] 
.const [29] = Method [108] [109] 
.const [30] = Method [110] [111] 
.const [31] = Method [112] [113] 
.const [32] = Method [114] [115] 
.const [33] = Method [116] [117] 
.const [34] = Method [118] [119] 
.const [35] = Method [120] [121] 
.const [36] = Method [122] [123] 
.const [37] = Method [124] [125] 
.const [38] = Method [126] [127] 
.const [39] = Method [128] [129] 
.const [40] = Method [130] [131] 
.const [41] = Method [132] [133] 
.const [42] = Method [134] [135] 
.const [43] = Method [136] [137] 
.const [44] = Method [138] [139] 
.const [45] = Method [140] [141] 
.const [46] = Method [142] [143] 
.const [47] = Method [144] [145] 
.const [48] = Method [146] [147] 
.const [49] = Method [148] [149] 
.const [50] = Method [150] [151] 
.const [51] = Method [152] [153] 
.const [52] = Method [154] [155] 
.const [53] = Method [156] [157] 
.const [54] = Class [158] 
.const [55] = Field [159] [160] 
.const [56] = Class [161] 
.const [57] = Field [162] [163] 
.const [58] = Class [164] 
.const [59] = Field [165] [166] 
.const [60] = Field [167] [168] 
.const [61] = Field [169] [170] 
.const [62] = Field [171] [172] 
.const [63] = Field [173] [174] 
.const [64] = Field [175] [176] 
.const [65] = Class [177] 
.const [66] = InterfaceMethod [178] [179] 
.const [67] = InterfaceMethod [180] [181] 
.const [68] = InterfaceMethod [182] [183] 
.const [69] = InterfaceMethod [184] [185] 
.const [70] = Utf8 de/vw/mib/bap/generated/eni/serializer/ActiveTrip_Reserve3 
.const [71] = Utf8 de/vw/mib/bap/generated/eni/serializer/ActiveTrip_StartTime 
.const [72] = Utf8 de/vw/mib/bap/generated/eni/serializer/ActiveTrip_StopTime 
.const [73] = Utf8 de/vw/mib/bap/generated/eni/serializer/ActiveTrip_SetGet 
.const [74] = Utf8 java/lang/StringBuffer 
.const [75] = Utf8 ActiveTrip_SetGet 
.const [76] = Utf8 '\n - reserve1:' 
.const [77] = Utf8 '\n - reserve2:' 
.const [78] = Utf8 '\n - reserve3:' 
.const [79] = Utf8 '\n - startTime:' 
.const [80] = Utf8 '\n - stopTime:' 
.const [81] = Utf8 '\n - mileageAtStart:' 
.const [82] = Utf8 '\n - reserve4:' 
.const [83] = Utf8 '\n - reserve5:' 
.const [84] = Class [186] 
.const [85] = NameAndType [187] [188] 
.const [86] = Utf8 java/lang/Object 
.const [87] = Utf8 de/vw/mib/bap/stream/BitStream 
.const [88] = Class [189] 
.const [89] = NameAndType [190] [191] 
.const [90] = Class [192] 
.const [91] = NameAndType [193] [194] 
.const [92] = Class [195] 
.const [93] = NameAndType [196] [197] 
.const [94] = Class [198] 
.const [95] = NameAndType [199] [200] 
.const [96] = Class [201] 
.const [97] = NameAndType [202] [203] 
.const [98] = Class [204] 
.const [99] = NameAndType [205] [206] 
.const [100] = Class [207] 
.const [101] = NameAndType [208] [209] 
.const [102] = Class [210] 
.const [103] = NameAndType [211] [212] 
.const [104] = Class [213] 
.const [105] = NameAndType [214] [215] 
.const [106] = Class [216] 
.const [107] = NameAndType [217] [218] 
.const [108] = Class [219] 
.const [109] = NameAndType [220] [221] 
.const [110] = Class [222] 
.const [111] = NameAndType [223] [224] 
.const [112] = Class [225] 
.const [113] = NameAndType [226] [227] 
.const [114] = Class [228] 
.const [115] = NameAndType [229] [230] 
.const [116] = Class [231] 
.const [117] = NameAndType [232] [233] 
.const [118] = Class [234] 
.const [119] = NameAndType [235] [236] 
.const [120] = Class [237] 
.const [121] = NameAndType [238] [239] 
.const [122] = Class [240] 
.const [123] = NameAndType [241] [242] 
.const [124] = Class [243] 
.const [125] = NameAndType [244] [245] 
.const [126] = Class [246] 
.const [127] = NameAndType [247] [248] 
.const [128] = Class [249] 
.const [129] = NameAndType [250] [251] 
.const [130] = Class [252] 
.const [131] = NameAndType [253] [254] 
.const [132] = Class [255] 
.const [133] = NameAndType [256] [257] 
.const [134] = Class [258] 
.const [135] = NameAndType [259] [260] 
.const [136] = Class [261] 
.const [137] = NameAndType [262] [263] 
.const [138] = Class [264] 
.const [139] = NameAndType [265] [266] 
.const [140] = Class [267] 
.const [141] = NameAndType [268] [269] 
.const [142] = Class [270] 
.const [143] = NameAndType [271] [272] 
.const [144] = Class [273] 
.const [145] = NameAndType [274] [275] 
.const [146] = Class [276] 
.const [147] = NameAndType [277] [278] 
.const [148] = Class [279] 
.const [149] = NameAndType [280] [281] 
.const [150] = Class [282] 
.const [151] = NameAndType [283] [284] 
.const [152] = Class [285] 
.const [153] = NameAndType [286] [287] 
.const [154] = Class [288] 
.const [155] = NameAndType [289] [290] 
.const [156] = Class [291] 
.const [157] = NameAndType [292] [293] 
.const [158] = Utf8 de/vw/mib/bap/generated/eni/serializer/ActiveTrip_Reserve3 
.const [159] = Class [294] 
.const [160] = NameAndType [295] [296] 
.const [161] = Utf8 de/vw/mib/bap/generated/eni/serializer/ActiveTrip_StartTime 
.const [162] = Class [297] 
.const [163] = NameAndType [298] [299] 
.const [164] = Utf8 de/vw/mib/bap/generated/eni/serializer/ActiveTrip_StopTime 
.const [165] = Class [300] 
.const [166] = NameAndType [301] [302] 
.const [167] = Class [303] 
.const [168] = NameAndType [304] [305] 
.const [169] = Class [306] 
.const [170] = NameAndType [307] [308] 
.const [171] = Class [309] 
.const [172] = NameAndType [310] [311] 
.const [173] = Class [312] 
.const [174] = NameAndType [313] [314] 
.const [175] = Class [315] 
.const [176] = NameAndType [316] [317] 
.const [177] = Utf8 java/lang/StringBuffer 
.const [178] = Class [318] 
.const [179] = NameAndType [319] [320] 
.const [180] = Class [321] 
.const [181] = NameAndType [322] [323] 
.const [182] = Class [324] 
.const [183] = NameAndType [325] [326] 
.const [184] = Class [327] 
.const [185] = NameAndType [328] [329] 
.const [186] = Utf8 de/vw/mib/bap/generated/eni/serializer/ActiveTrip_SetGet 
.const [187] = Utf8 functionId 
.const [188] = Utf8 ()I 
.const [189] = Utf8 de/vw/mib/bap/generated/eni/serializer/ActiveTrip_SetGet 
.const [190] = Utf8 reserve3 
.const [191] = Utf8 Lde/vw/mib/bap/generated/eni/serializer/ActiveTrip_Reserve3; 
.const [192] = Utf8 de/vw/mib/bap/generated/eni/serializer/ActiveTrip_SetGet 
.const [193] = Utf8 startTime 
.const [194] = Utf8 Lde/vw/mib/bap/generated/eni/serializer/ActiveTrip_StartTime; 
.const [195] = Utf8 de/vw/mib/bap/generated/eni/serializer/ActiveTrip_SetGet 
.const [196] = Utf8 stopTime 
.const [197] = Utf8 Lde/vw/mib/bap/generated/eni/serializer/ActiveTrip_StopTime; 
.const [198] = Utf8 de/vw/mib/bap/generated/eni/serializer/ActiveTrip_SetGet 
.const [199] = Utf8 deserialize 
.const [200] = Utf8 (Lde/vw/mib/bap/stream/BitStream;)V 
.const [201] = Utf8 de/vw/mib/bap/generated/eni/serializer/ActiveTrip_SetGet 
.const [202] = Utf8 reserve1 
.const [203] = Utf8 I 
.const [204] = Utf8 de/vw/mib/bap/generated/eni/serializer/ActiveTrip_SetGet 
.const [205] = Utf8 reserve2 
.const [206] = Utf8 I 
.const [207] = Utf8 de/vw/mib/bap/generated/eni/serializer/ActiveTrip_SetGet 
.const [208] = Utf8 mileageAtStart 
.const [209] = Utf8 I 
.const [210] = Utf8 de/vw/mib/bap/generated/eni/serializer/ActiveTrip_SetGet 
.const [211] = Utf8 reserve4 
.const [212] = Utf8 I 
.const [213] = Utf8 de/vw/mib/bap/generated/eni/serializer/ActiveTrip_SetGet 
.const [214] = Utf8 reserve5 
.const [215] = Utf8 I 
.const [216] = Utf8 de/vw/mib/bap/generated/eni/serializer/ActiveTrip_Reserve3 
.const [217] = Utf8 reset 
.const [218] = Utf8 ()V 
.const [219] = Utf8 de/vw/mib/bap/generated/eni/serializer/ActiveTrip_StartTime 
.const [220] = Utf8 reset 
.const [221] = Utf8 ()V 
.const [222] = Utf8 de/vw/mib/bap/generated/eni/serializer/ActiveTrip_StopTime 
.const [223] = Utf8 reset 
.const [224] = Utf8 ()V 
.const [225] = Utf8 de/vw/mib/bap/generated/eni/serializer/ActiveTrip_Reserve3 
.const [226] = Utf8 equalTo 
.const [227] = Utf8 (Lde/vw/mib/bap/datatypes/BAPEntity;)Z 
.const [228] = Utf8 de/vw/mib/bap/generated/eni/serializer/ActiveTrip_StartTime 
.const [229] = Utf8 equalTo 
.const [230] = Utf8 (Lde/vw/mib/bap/datatypes/BAPEntity;)Z 
.const [231] = Utf8 de/vw/mib/bap/generated/eni/serializer/ActiveTrip_StopTime 
.const [232] = Utf8 equalTo 
.const [233] = Utf8 (Lde/vw/mib/bap/datatypes/BAPEntity;)Z 
.const [234] = Utf8 java/lang/StringBuffer 
.const [235] = Utf8 append 
.const [236] = Utf8 (Ljava/lang/String;)Ljava/lang/StringBuffer; 
.const [237] = Utf8 java/lang/StringBuffer 
.const [238] = Utf8 append 
.const [239] = Utf8 (I)Ljava/lang/StringBuffer; 
.const [240] = Utf8 java/lang/StringBuffer 
.const [241] = Utf8 toString 
.const [242] = Utf8 ()Ljava/lang/String; 
.const [243] = Utf8 de/vw/mib/bap/generated/eni/serializer/ActiveTrip_Reserve3 
.const [244] = Utf8 toString 
.const [245] = Utf8 ()Ljava/lang/String; 
.const [246] = Utf8 de/vw/mib/bap/generated/eni/serializer/ActiveTrip_StartTime 
.const [247] = Utf8 toString 
.const [248] = Utf8 ()Ljava/lang/String; 
.const [249] = Utf8 de/vw/mib/bap/generated/eni/serializer/ActiveTrip_StopTime 
.const [250] = Utf8 toString 
.const [251] = Utf8 ()Ljava/lang/String; 
.const [252] = Utf8 de/vw/mib/bap/generated/eni/serializer/ActiveTrip_Reserve3 
.const [253] = Utf8 serialize 
.const [254] = Utf8 (Lde/vw/mib/bap/stream/BitStream;)V 
.const [255] = Utf8 de/vw/mib/bap/generated/eni/serializer/ActiveTrip_StartTime 
.const [256] = Utf8 serialize 
.const [257] = Utf8 (Lde/vw/mib/bap/stream/BitStream;)V 
.const [258] = Utf8 de/vw/mib/bap/generated/eni/serializer/ActiveTrip_StopTime 
.const [259] = Utf8 serialize 
.const [260] = Utf8 (Lde/vw/mib/bap/stream/BitStream;)V 
.const [261] = Utf8 de/vw/mib/bap/generated/eni/serializer/ActiveTrip_Reserve3 
.const [262] = Utf8 deserialize 
.const [263] = Utf8 (Lde/vw/mib/bap/stream/BitStream;)V 
.const [264] = Utf8 de/vw/mib/bap/generated/eni/serializer/ActiveTrip_StartTime 
.const [265] = Utf8 deserialize 
.const [266] = Utf8 (Lde/vw/mib/bap/stream/BitStream;)V 
.const [267] = Utf8 de/vw/mib/bap/generated/eni/serializer/ActiveTrip_StopTime 
.const [268] = Utf8 deserialize 
.const [269] = Utf8 (Lde/vw/mib/bap/stream/BitStream;)V 
.const [270] = Utf8 java/lang/Object 
.const [271] = Utf8 <init> 
.const [272] = Utf8 ()V 
.const [273] = Utf8 de/vw/mib/bap/generated/eni/serializer/ActiveTrip_Reserve3 
.const [274] = Utf8 <init> 
.const [275] = Utf8 ()V 
.const [276] = Utf8 de/vw/mib/bap/generated/eni/serializer/ActiveTrip_StartTime 
.const [277] = Utf8 <init> 
.const [278] = Utf8 ()V 
.const [279] = Utf8 de/vw/mib/bap/generated/eni/serializer/ActiveTrip_StopTime 
.const [280] = Utf8 <init> 
.const [281] = Utf8 ()V 
.const [282] = Utf8 de/vw/mib/bap/generated/eni/serializer/ActiveTrip_SetGet 
.const [283] = Utf8 internalReset 
.const [284] = Utf8 ()V 
.const [285] = Utf8 de/vw/mib/bap/generated/eni/serializer/ActiveTrip_SetGet 
.const [286] = Utf8 customInitialization 
.const [287] = Utf8 ()V 
.const [288] = Utf8 de/vw/mib/bap/generated/eni/serializer/ActiveTrip_SetGet 
.const [289] = Utf8 <init> 
.const [290] = Utf8 ()V 
.const [291] = Utf8 java/lang/StringBuffer 
.const [292] = Utf8 <init> 
.const [293] = Utf8 ()V 
.const [294] = Utf8 de/vw/mib/bap/generated/eni/serializer/ActiveTrip_SetGet 
.const [295] = Utf8 reserve3 
.const [296] = Utf8 Lde/vw/mib/bap/generated/eni/serializer/ActiveTrip_Reserve3; 
.const [297] = Utf8 de/vw/mib/bap/generated/eni/serializer/ActiveTrip_SetGet 
.const [298] = Utf8 startTime 
.const [299] = Utf8 Lde/vw/mib/bap/generated/eni/serializer/ActiveTrip_StartTime; 
.const [300] = Utf8 de/vw/mib/bap/generated/eni/serializer/ActiveTrip_SetGet 
.const [301] = Utf8 stopTime 
.const [302] = Utf8 Lde/vw/mib/bap/generated/eni/serializer/ActiveTrip_StopTime; 
.const [303] = Utf8 de/vw/mib/bap/generated/eni/serializer/ActiveTrip_SetGet 
.const [304] = Utf8 reserve1 
.const [305] = Utf8 I 
.const [306] = Utf8 de/vw/mib/bap/generated/eni/serializer/ActiveTrip_SetGet 
.const [307] = Utf8 reserve2 
.const [308] = Utf8 I 
.const [309] = Utf8 de/vw/mib/bap/generated/eni/serializer/ActiveTrip_SetGet 
.const [310] = Utf8 mileageAtStart 
.const [311] = Utf8 I 
.const [312] = Utf8 de/vw/mib/bap/generated/eni/serializer/ActiveTrip_SetGet 
.const [313] = Utf8 reserve4 
.const [314] = Utf8 I 
.const [315] = Utf8 de/vw/mib/bap/generated/eni/serializer/ActiveTrip_SetGet 
.const [316] = Utf8 reserve5 
.const [317] = Utf8 I 
.const [318] = Utf8 de/vw/mib/bap/stream/BitStream 
.const [319] = Utf8 pushByte 
.const [320] = Utf8 (B)V 
.const [321] = Utf8 de/vw/mib/bap/stream/BitStream 
.const [322] = Utf8 pushInt 
.const [323] = Utf8 (I)V 
.const [324] = Utf8 de/vw/mib/bap/stream/BitStream 
.const [325] = Utf8 popFrontByte 
.const [326] = Utf8 ()I 
.const [327] = Utf8 de/vw/mib/bap/stream/BitStream 
.const [328] = Utf8 popFrontInt 
.const [329] = Utf8 ()I 
.const [330] = Utf8 de/vw/mib/bap/generated/eni/serializer/ActiveTrip_SetGet 
.const [331] = Class [330] 
.const [332] = Utf8 java/lang/Object 
.const [333] = Class [332] 
.const [334] = Utf8 de/vw/mib/bap/requests/SetGetProperty 
.const [335] = Class [334] 
.const [336] = Utf8 reserve1 
.const [337] = Utf8 I 
.const [338] = Utf8 RESERVE1_MIN 
.const [339] = Utf8 I 
.const [340] = Utf8 reserve2 
.const [341] = Utf8 I 
.const [342] = Utf8 RESERVE2_MIN 
.const [343] = Utf8 I 
.const [344] = Utf8 reserve3 
.const [345] = Utf8 Lde/vw/mib/bap/generated/eni/serializer/ActiveTrip_Reserve3; 
.const [346] = Utf8 startTime 
.const [347] = Utf8 Lde/vw/mib/bap/generated/eni/serializer/ActiveTrip_StartTime; 
.const [348] = Utf8 stopTime 
.const [349] = Utf8 Lde/vw/mib/bap/generated/eni/serializer/ActiveTrip_StopTime; 
.const [350] = Utf8 mileageAtStart 
.const [351] = Utf8 I 
.const [352] = Utf8 MILEAGE_AT_START_MIN 
.const [353] = Utf8 I 
.const [354] = Utf8 reserve4 
.const [355] = Utf8 I 
.const [356] = Utf8 RESERVE4_MIN 
.const [357] = Utf8 I 
.const [358] = Utf8 reserve5 
.const [359] = Utf8 I 
.const [360] = Utf8 RESERVE5_MIN 
.const [361] = Utf8 I 
.const [362] = Utf8 Code 
.const [363] = Utf8 <init> 
.const [364] = Utf8 ()V 
.const [365] = Utf8 <init> 
.const [366] = Utf8 (Lde/vw/mib/bap/stream/BitStream;)V 
.const [367] = Utf8 internalReset 
.const [368] = Utf8 ()V 
.const [369] = Utf8 reset 
.const [370] = Utf8 ()V 
.const [371] = Utf8 equalTo 
.const [372] = Utf8 (Lde/vw/mib/bap/datatypes/BAPEntity;)Z 
.const [373] = Utf8 customInitialization 
.const [374] = Utf8 ()V 
.const [375] = Utf8 toString 
.const [376] = Utf8 ()Ljava/lang/String; 
.const [377] = Utf8 bitSize 
.const [378] = Utf8 ()I 
.const [379] = Utf8 serialize 
.const [380] = Utf8 (Lde/vw/mib/bap/stream/BitStream;)V 
.const [381] = Utf8 deserialize 
.const [382] = Utf8 (Lde/vw/mib/bap/stream/BitStream;)V 
.const [383] = Utf8 functionId 
.const [384] = Utf8 ()I 
.const [385] = Utf8 getFunctionId 
.const [386] = Utf8 ()I 
.end class 
