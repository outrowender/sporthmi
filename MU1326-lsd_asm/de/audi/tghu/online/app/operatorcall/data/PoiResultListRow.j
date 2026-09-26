.version 50 0 
.class public super [337] 
.super [339] 
.field public static final [340] [341] 
.field public static final [342] [343] 
.field protected static final [344] [345] 
.field protected static final [346] [347] 
.field protected static final [348] [349] 
.field protected static final [350] [351] 
.field protected static [352] [353] 
.field protected final [354] [355] 
.field protected [356] [357] 
.field protected [358] [359] 
.field protected [360] [361] 

.method public [363] : [364] 
    .attribute [362] .code stack 4 locals 0 
L0:     aload_0 
L1:     getstatic [2] 
L4:     iconst_5 
L5:     invokespecial [64] 
L8:     aload_0 
L9:     invokestatic [3] 
L12:    invokevirtual [31] 
L15:    putfield [69] 
L18:    aload_0 
L19:    aconst_null 
L20:    putfield [70] 
L23:    aload_0 
L24:    aload_2 
L25:    putfield [71] 
L28:    getstatic [2] 
L31:    lconst_1 
L32:    ladd 
L33:    putstatic [63] 
L36:    aload_0 
L37:    aload_1 
L38:    putfield [70] 
L41:    aload_0 
L42:    aload_3 
L43:    putfield [72] 
L46:    aload_0 
L47:    iconst_1 
L48:    invokevirtual [36] 
L51:    return 
L52:    
    .end code 
.end method 

.method public enum [365] : [366] 
    .attribute [362] .code stack 0 locals 0 
L0:     return 
L1:     nop 
L2:     nop 
L3:     nop 
L4:     
    .end code 
.end method 

.method public [367] : [368] 
    .attribute [362] .code stack 2 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     invokespecial [65] 
L5:     aload_0 
L6:     invokestatic [3] 
L9:     invokevirtual [31] 
L12:    putfield [69] 
L15:    aload_0 
L16:    aconst_null 
L17:    putfield [70] 
L20:    aload_0 
L21:    aload_1 
L22:    getfield [34] 
L25:    putfield [71] 
L28:    aload_0 
L29:    aload_1 
L30:    getfield [33] 
L33:    putfield [70] 
L36:    aload_0 
L37:    aload_1 
L38:    getfield [35] 
L41:    putfield [72] 
L44:    return 
L45:    nop 
L46:    nop 
L47:    nop 
L48:    
    .end code 
.end method 

.method public [369] : [370] 
    .attribute [362] .code stack 5 locals 6 
L0:     aload_0 
L1:     getfield [33] 
L4:     invokevirtual [37] 
L7:     astore_2 
L8:     aload_2 
L9:     invokevirtual [38] 
L12:    istore_3 
L13:    aload_2 
L14:    invokevirtual [39] 
L17:    istore 4 
L19:    aload_0 
L20:    getfield [34] 
L23:    invokevirtual [40] 
L26:    astore 5 
L28:    aload 5 
L30:    ifnonnull L46 
L33:    aload_0 
L34:    getfield [32] 
L37:    ldc [4] 
L39:    ldc [5] 
L41:    invokevirtual [41] 
L44:    pop 
L45:    return 
L46:    iload_1 
L47:    lookupswitch 
            2 : L64 
            default : L91 

L64:    aload 5 
L66:    iload 4 
L68:    iload_3 
L69:    invokeinterface [73] 0 
L74:    istore 6 
L76:    aload 5 
L78:    iload 4 
L80:    iload_3 
L81:    invokeinterface [74] 0 
L86:    istore 7 
L88:    goto L115 
L91:    aload 5 
L93:    iload 4 
L95:    iload_3 
L96:    invokeinterface [73] 0 
L101:   istore 6 
L103:   aload 5 
L105:   iload 4 
L107:   iload_3 
L108:   invokeinterface [74] 0 
L113:   istore 7 
L115:   aload_0 
L116:   getfield [32] 
L119:   ldc [6] 
L121:   ldc [7] 
L123:   iload 6 
L125:   i2l 
L126:   invokevirtual [42] 
L129:   pop 
L130:   aload_0 
L131:   getfield [32] 
L134:   ldc [6] 
L136:   ldc [8] 
L138:   iload 7 
L140:   i2l 
L141:   invokevirtual [42] 
L144:   pop 
L145:   aload_0 
L146:   iload 6 
L148:   iload 7 
L150:   invokevirtual [43] 
L153:   return 
L154:   nop 
L155:   nop 
L156:   
    .end code 
.end method 

.method protected [371] : [372] 
    .attribute [362] .code stack 6 locals 0 
L0:     aload_0 
L1:     iconst_0 
L2:     aload_0 
L3:     invokevirtual [44] 
L6:     invokevirtual [45] 
L9:     pop 
L10:    aload_0 
L11:    iconst_1 
L12:    aload_0 
L13:    getfield [33] 
L16:    invokevirtual [46] 
L19:    invokevirtual [47] 
L22:    pop 
L23:    aload_0 
L24:    iconst_2 
L25:    iload_2 
L26:    invokevirtual [48] 
L29:    pop 
L30:    aload_0 
L31:    iconst_3 
L32:    new [75] 
L35:    dup 
L36:    iload_1 
L37:    i2f 
L38:    iconst_5 
L39:    invokespecial [66] 
L42:    invokevirtual [49] 
L45:    pop 
L46:    aload_0 
L47:    invokevirtual [50] 
L50:    return 
L51:    nop 
L52:    
    .end code 
.end method 

.method public [373] : [374] 
    .attribute [362] .code stack 1 locals 0 
L0:     iconst_m1 
L1:     areturn 
L2:     nop 
L3:     nop 
L4:     
    .end code 
.end method 

.method protected [375] : [376] 
    .attribute [362] .code stack 3 locals 1 
L0:     new [76] 
L3:     dup 
L4:     invokespecial [67] 
L7:     astore_2 
L8:     iload_1 
L9:     sipush 1000 
L12:    if_icmpge L31 
L15:    aload_2 
L16:    iload_1 
L17:    invokevirtual [51] 
L20:    pop 
L21:    aload_2 
L22:    ldc [11] 
L24:    invokevirtual [52] 
L27:    pop 
L28:    goto L68 
L31:    aload_2 
L32:    iload_1 
L33:    sipush 1000 
L36:    idiv 
L37:    invokevirtual [51] 
L40:    pop 
L41:    aload_2 
L42:    ldc [12] 
L44:    invokevirtual [52] 
L47:    pop 
L48:    aload_2 
L49:    iload_1 
L50:    sipush 1000 
L53:    irem 
L54:    bipush 100 
L56:    idiv 
L57:    invokevirtual [51] 
L60:    pop 
L61:    aload_2 
L62:    ldc [13] 
L64:    invokevirtual [52] 
L67:    pop 
L68:    aload_2 
L69:    invokevirtual [53] 
L72:    areturn 
L73:    nop 
L74:    nop 
L75:    nop 
L76:    
    .end code 
.end method 

.method public [377] : [378] 
    .attribute [362] .code stack 2 locals 0 
L0:     aload_0 
L1:     iconst_2 
L2:     invokevirtual [54] 
L5:     areturn 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [379] : [380] 
    .attribute [362] .code stack 2 locals 0 
L0:     aload_0 
L1:     iconst_3 
L2:     invokevirtual [55] 
L5:     invokevirtual [56] 
L8:     areturn 
L9:     nop 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method public [381] : [382] 
    .attribute [362] .code stack 3 locals 0 
L0:     aload_0 
L1:     getfield [32] 
L4:     ldc [6] 
L6:     ldc [14] 
L8:     invokevirtual [41] 
L11:    pop 
L12:    new [77] 
L15:    dup 
L16:    aload_0 
L17:    invokespecial [68] 
L20:    areturn 
L21:    nop 
L22:    nop 
L23:    nop 
L24:    
    .end code 
.end method 

.method public [383] : [384] 
    .attribute [362] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [33] 
L4:     invokevirtual [46] 
L7:     areturn 
L8:     
    .end code 
.end method 

.method public [385] : [386] 
    .attribute [362] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [33] 
L4:     invokevirtual [37] 
L7:     areturn 
L8:     
    .end code 
.end method 

.method public [387] : [388] 
    .attribute [362] .code stack 2 locals 2 
L0:     new [76] 
L3:     dup 
L4:     invokespecial [67] 
L7:     astore_1 
L8:     aload_1 
L9:     ldc [16] 
L11:    invokevirtual [52] 
L14:    pop 
L15:    aload_1 
L16:    aload_0 
L17:    invokevirtual [57] 
L20:    invokevirtual [52] 
L23:    pop 
L24:    aload_1 
L25:    ldc [17] 
L27:    invokevirtual [52] 
L30:    pop 
L31:    aload_1 
L32:    aload_0 
L33:    invokevirtual [58] 
L36:    invokevirtual [38] 
L39:    invokevirtual [51] 
L42:    pop 
L43:    aload_1 
L44:    ldc [18] 
L46:    invokevirtual [52] 
L49:    pop 
L50:    aload_1 
L51:    aload_0 
L52:    invokevirtual [58] 
L55:    invokevirtual [39] 
L58:    invokevirtual [51] 
L61:    pop 
L62:    aload_1 
L63:    ldc [19] 
L65:    invokevirtual [52] 
L68:    pop 
L69:    aload_1 
L70:    aload_0 
L71:    invokevirtual [59] 
L74:    invokevirtual [51] 
L77:    pop 
L78:    aload_1 
L79:    ldc [20] 
L81:    invokevirtual [52] 
L84:    pop 
L85:    aload_1 
L86:    aload_0 
L87:    invokevirtual [60] 
L90:    invokevirtual [52] 
L93:    pop 
L94:    aload_1 
L95:    ldc [21] 
L97:    invokevirtual [52] 
L100:   pop 
L101:   aload_0 
L102:   invokevirtual [61] 
L105:   istore_2 
L106:   aload_1 
L107:   iload_2 
L108:   invokevirtual [51] 
L111:   pop 
L112:   aload_1 
L113:   ldc [20] 
L115:   invokevirtual [52] 
L118:   pop 
L119:   aload_1 
L120:   invokevirtual [53] 
L123:   areturn 
L124:   
    .end code 
.end method 

.method public [389] : [390] 
    .attribute [362] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [35] 
L4:     invokevirtual [62] 
L7:     areturn 
L8:     
    .end code 
.end method 

.method public interface [391] : [392] 
    .attribute [362] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [33] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method static [393] : [394] 
    .attribute [362] .code stack 2 locals 0 
L0:     lconst_1 
L1:     putstatic [63] 
L4:     return 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Field [78] [79] 
.const [3] = Method [80] [81] 
.const [4] = Int -1601830656 
.const [5] = String [82] 
.const [6] = Int -2137614336 
.const [7] = String [83] 
.const [8] = String [84] 
.const [9] = Class [85] 
.const [10] = Class [86] 
.const [11] = String [87] 
.const [12] = String [88] 
.const [13] = String [89] 
.const [14] = String [90] 
.const [15] = Class [91] 
.const [16] = String [92] 
.const [17] = String [93] 
.const [18] = String [94] 
.const [19] = String [95] 
.const [20] = String [96] 
.const [21] = String [97] 
.const [22] = Class [98] 
.const [23] = Class [99] 
.const [24] = Class [100] 
.const [25] = Class [101] 
.const [26] = Class [102] 
.const [27] = Class [103] 
.const [28] = Class [104] 
.const [29] = Class [105] 
.const [30] = Class [106] 
.const [31] = Method [107] [108] 
.const [32] = Field [109] [110] 
.const [33] = Field [111] [112] 
.const [34] = Field [113] [114] 
.const [35] = Field [115] [116] 
.const [36] = Method [117] [118] 
.const [37] = Method [119] [120] 
.const [38] = Method [121] [122] 
.const [39] = Method [123] [124] 
.const [40] = Method [125] [126] 
.const [41] = Method [127] [128] 
.const [42] = Method [129] [130] 
.const [43] = Method [131] [132] 
.const [44] = Method [133] [134] 
.const [45] = Method [135] [136] 
.const [46] = Method [137] [138] 
.const [47] = Method [139] [140] 
.const [48] = Method [141] [142] 
.const [49] = Method [143] [144] 
.const [50] = Method [145] [146] 
.const [51] = Method [147] [148] 
.const [52] = Method [149] [150] 
.const [53] = Method [151] [152] 
.const [54] = Method [153] [154] 
.const [55] = Method [155] [156] 
.const [56] = Method [157] [158] 
.const [57] = Method [159] [160] 
.const [58] = Method [161] [162] 
.const [59] = Method [163] [164] 
.const [60] = Method [165] [166] 
.const [61] = Method [167] [168] 
.const [62] = Method [169] [170] 
.const [63] = Field [171] [172] 
.const [64] = Method [173] [174] 
.const [65] = Method [175] [176] 
.const [66] = Method [177] [178] 
.const [67] = Method [179] [180] 
.const [68] = Method [181] [182] 
.const [69] = Field [183] [184] 
.const [70] = Field [185] [186] 
.const [71] = Field [187] [188] 
.const [72] = Field [189] [190] 
.const [73] = InterfaceMethod [191] [192] 
.const [74] = InterfaceMethod [193] [194] 
.const [75] = Class [195] 
.const [76] = Class [196] 
.const [77] = Class [197] 
.const [78] = Class [198] 
.const [79] = NameAndType [199] [200] 
.const [80] = Class [201] 
.const [81] = NameAndType [202] [203] 
.const [82] = Utf8 'PoiResultListRow#computeNaviStuffAndUpdate: naviService is null. Cannot update Information in the list.' 
.const [83] = Utf8 'PoiResultListRow#computeNaviStuffAndUpdate: distance = %1' 
.const [84] = Utf8 'PoiResultListRow#computeNaviStuffAndUpdate: directionArrow = %1' 
.const [85] = Utf8 de/audi/atip/metrics/Distance 
.const [86] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [87] = Utf8 ' m' 
.const [88] = Utf8 ',' 
.const [89] = Utf8 ' km' 
.const [90] = Utf8 'PoiResultListRow#copy: called!' 
.const [91] = Utf8 de/audi/tghu/online/app/operatorcall/data/PoiResultListRow 
.const [92] = Utf8 '\nName = ' 
.const [93] = Utf8 '\nLatitude = ' 
.const [94] = Utf8 '\nLongitude = ' 
.const [95] = Utf8 '\nArrow = ' 
.const [96] = Utf8 '\n' 
.const [97] = Utf8 '\nCategory = ' 
.const [98] = Utf8 de/audi/atip/hmi/model/list/EvoListRow 
.const [99] = Utf8 de/audi/tghu/online/app/Online 
.const [100] = Utf8 org/dsi/ifc/online/OperatorCallResult 
.const [101] = Utf8 org/dsi/ifc/global/NavLocationWgs84 
.const [102] = Utf8 de/audi/tghu/online/app/operatorcall/handler/NavigationHandler 
.const [103] = Utf8 de/audi/atip/log/LogChannel 
.const [104] = Utf8 de/audi/atip/interapp/NaviService 
.const [105] = Utf8 java/lang/Object 
.const [106] = Utf8 de/audi/tghu/online/app/operatorcall/data/AbstractHistoryCallData 
.const [107] = Class [204] 
.const [108] = NameAndType [205] [206] 
.const [109] = Class [207] 
.const [110] = NameAndType [208] [209] 
.const [111] = Class [210] 
.const [112] = NameAndType [211] [212] 
.const [113] = Class [213] 
.const [114] = NameAndType [214] [215] 
.const [115] = Class [216] 
.const [116] = NameAndType [217] [218] 
.const [117] = Class [219] 
.const [118] = NameAndType [220] [221] 
.const [119] = Class [222] 
.const [120] = NameAndType [223] [224] 
.const [121] = Class [225] 
.const [122] = NameAndType [226] [227] 
.const [123] = Class [228] 
.const [124] = NameAndType [229] [230] 
.const [125] = Class [231] 
.const [126] = NameAndType [232] [233] 
.const [127] = Class [234] 
.const [128] = NameAndType [235] [236] 
.const [129] = Class [237] 
.const [130] = NameAndType [238] [239] 
.const [131] = Class [240] 
.const [132] = NameAndType [241] [242] 
.const [133] = Class [243] 
.const [134] = NameAndType [244] [245] 
.const [135] = Class [246] 
.const [136] = NameAndType [247] [248] 
.const [137] = Class [249] 
.const [138] = NameAndType [250] [251] 
.const [139] = Class [252] 
.const [140] = NameAndType [253] [254] 
.const [141] = Class [255] 
.const [142] = NameAndType [256] [257] 
.const [143] = Class [258] 
.const [144] = NameAndType [259] [260] 
.const [145] = Class [261] 
.const [146] = NameAndType [262] [263] 
.const [147] = Class [264] 
.const [148] = NameAndType [265] [266] 
.const [149] = Class [267] 
.const [150] = NameAndType [268] [269] 
.const [151] = Class [270] 
.const [152] = NameAndType [271] [272] 
.const [153] = Class [273] 
.const [154] = NameAndType [274] [275] 
.const [155] = Class [276] 
.const [156] = NameAndType [277] [278] 
.const [157] = Class [279] 
.const [158] = NameAndType [280] [281] 
.const [159] = Class [282] 
.const [160] = NameAndType [283] [284] 
.const [161] = Class [285] 
.const [162] = NameAndType [286] [287] 
.const [163] = Class [288] 
.const [164] = NameAndType [289] [290] 
.const [165] = Class [291] 
.const [166] = NameAndType [292] [293] 
.const [167] = Class [294] 
.const [168] = NameAndType [295] [296] 
.const [169] = Class [297] 
.const [170] = NameAndType [298] [299] 
.const [171] = Class [300] 
.const [172] = NameAndType [301] [302] 
.const [173] = Class [303] 
.const [174] = NameAndType [304] [305] 
.const [175] = Class [306] 
.const [176] = NameAndType [307] [308] 
.const [177] = Class [309] 
.const [178] = NameAndType [310] [311] 
.const [179] = Class [312] 
.const [180] = NameAndType [313] [314] 
.const [181] = Class [315] 
.const [182] = NameAndType [316] [317] 
.const [183] = Class [318] 
.const [184] = NameAndType [319] [320] 
.const [185] = Class [321] 
.const [186] = NameAndType [322] [323] 
.const [187] = Class [324] 
.const [188] = NameAndType [325] [326] 
.const [189] = Class [327] 
.const [190] = NameAndType [328] [329] 
.const [191] = Class [330] 
.const [192] = NameAndType [331] [332] 
.const [193] = Class [333] 
.const [194] = NameAndType [334] [335] 
.const [195] = Utf8 de/audi/atip/metrics/Distance 
.const [196] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [197] = Utf8 de/audi/tghu/online/app/operatorcall/data/PoiResultListRow 
.const [198] = Utf8 de/audi/tghu/online/app/operatorcall/data/PoiResultListRow 
.const [199] = Utf8 idCounter 
.const [200] = Utf8 J 
.const [201] = Utf8 de/audi/tghu/online/app/Online 
.const [202] = Utf8 getInstance 
.const [203] = Utf8 ()Lde/audi/tghu/online/app/Online; 
.const [204] = Utf8 de/audi/tghu/online/app/Online 
.const [205] = Utf8 getOperatorCallLogChannel 
.const [206] = Utf8 ()Lde/audi/atip/log/LogChannel; 
.const [207] = Utf8 de/audi/tghu/online/app/operatorcall/data/PoiResultListRow 
.const [208] = Utf8 logChannel 
.const [209] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [210] = Utf8 de/audi/tghu/online/app/operatorcall/data/PoiResultListRow 
.const [211] = Utf8 result 
.const [212] = Utf8 Lorg/dsi/ifc/online/OperatorCallResult; 
.const [213] = Utf8 de/audi/tghu/online/app/operatorcall/data/PoiResultListRow 
.const [214] = Utf8 naviHandler 
.const [215] = Utf8 Lde/audi/tghu/online/app/operatorcall/handler/NavigationHandler; 
.const [216] = Utf8 de/audi/tghu/online/app/operatorcall/data/PoiResultListRow 
.const [217] = Utf8 historyCallData 
.const [218] = Utf8 Lde/audi/tghu/online/app/operatorcall/data/AbstractHistoryCallData; 
.const [219] = Utf8 de/audi/tghu/online/app/operatorcall/data/PoiResultListRow 
.const [220] = Utf8 computeDistanceAndUpdateData 
.const [221] = Utf8 (I)V 
.const [222] = Utf8 org/dsi/ifc/online/OperatorCallResult 
.const [223] = Utf8 getLocation 
.const [224] = Utf8 ()Lorg/dsi/ifc/global/NavLocationWgs84; 
.const [225] = Utf8 org/dsi/ifc/global/NavLocationWgs84 
.const [226] = Utf8 getLatitude 
.const [227] = Utf8 ()I 
.const [228] = Utf8 org/dsi/ifc/global/NavLocationWgs84 
.const [229] = Utf8 getLongitude 
.const [230] = Utf8 ()I 
.const [231] = Utf8 de/audi/tghu/online/app/operatorcall/handler/NavigationHandler 
.const [232] = Utf8 getNaviService 
.const [233] = Utf8 ()Lde/audi/atip/interapp/NaviService; 
.const [234] = Utf8 de/audi/atip/log/LogChannel 
.const [235] = Utf8 log 
.const [236] = Utf8 (ILjava/lang/String;)Z 
.const [237] = Utf8 de/audi/atip/log/LogChannel 
.const [238] = Utf8 log 
.const [239] = Utf8 (ILjava/lang/String;J)Z 
.const [240] = Utf8 de/audi/tghu/online/app/operatorcall/data/PoiResultListRow 
.const [241] = Utf8 updateInformation 
.const [242] = Utf8 (II)V 
.const [243] = Utf8 de/audi/tghu/online/app/operatorcall/data/PoiResultListRow 
.const [244] = Utf8 getUniqueID 
.const [245] = Utf8 ()J 
.const [246] = Utf8 de/audi/tghu/online/app/operatorcall/data/PoiResultListRow 
.const [247] = Utf8 setLong 
.const [248] = Utf8 (IJ)Lde/audi/atip/hmi/model/list/EvoListRow; 
.const [249] = Utf8 org/dsi/ifc/online/OperatorCallResult 
.const [250] = Utf8 getName 
.const [251] = Utf8 ()Ljava/lang/String; 
.const [252] = Utf8 de/audi/tghu/online/app/operatorcall/data/PoiResultListRow 
.const [253] = Utf8 setText 
.const [254] = Utf8 (ILjava/lang/String;)Lde/audi/atip/hmi/model/list/EvoListRow; 
.const [255] = Utf8 de/audi/tghu/online/app/operatorcall/data/PoiResultListRow 
.const [256] = Utf8 setInteger 
.const [257] = Utf8 (II)Lde/audi/atip/hmi/model/list/EvoListRow; 
.const [258] = Utf8 de/audi/tghu/online/app/operatorcall/data/PoiResultListRow 
.const [259] = Utf8 setMetrics 
.const [260] = Utf8 (ILde/audi/atip/metrics/AbstractMetrics;)Lde/audi/atip/hmi/model/list/EvoListRow; 
.const [261] = Utf8 de/audi/tghu/online/app/operatorcall/data/PoiResultListRow 
.const [262] = Utf8 createPropertyListCell 
.const [263] = Utf8 ()V 
.const [264] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [265] = Utf8 append 
.const [266] = Utf8 (I)Lde/esolutions/fw/util/commons/Buffer; 
.const [267] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [268] = Utf8 append 
.const [269] = Utf8 (Ljava/lang/String;)Lde/esolutions/fw/util/commons/Buffer; 
.const [270] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [271] = Utf8 toString 
.const [272] = Utf8 ()Ljava/lang/String; 
.const [273] = Utf8 de/audi/tghu/online/app/operatorcall/data/PoiResultListRow 
.const [274] = Utf8 getInteger 
.const [275] = Utf8 (I)I 
.const [276] = Utf8 de/audi/tghu/online/app/operatorcall/data/PoiResultListRow 
.const [277] = Utf8 getMetrics 
.const [278] = Utf8 (I)Lde/audi/atip/metrics/AbstractMetrics; 
.const [279] = Utf8 java/lang/Object 
.const [280] = Utf8 toString 
.const [281] = Utf8 ()Ljava/lang/String; 
.const [282] = Utf8 de/audi/tghu/online/app/operatorcall/data/PoiResultListRow 
.const [283] = Utf8 getName 
.const [284] = Utf8 ()Ljava/lang/String; 
.const [285] = Utf8 de/audi/tghu/online/app/operatorcall/data/PoiResultListRow 
.const [286] = Utf8 getLocation 
.const [287] = Utf8 ()Lorg/dsi/ifc/global/NavLocationWgs84; 
.const [288] = Utf8 de/audi/tghu/online/app/operatorcall/data/PoiResultListRow 
.const [289] = Utf8 getDirectionArrow 
.const [290] = Utf8 ()I 
.const [291] = Utf8 de/audi/tghu/online/app/operatorcall/data/PoiResultListRow 
.const [292] = Utf8 getDistance 
.const [293] = Utf8 ()Ljava/lang/String; 
.const [294] = Utf8 de/audi/tghu/online/app/operatorcall/data/PoiResultListRow 
.const [295] = Utf8 getCategory 
.const [296] = Utf8 ()I 
.const [297] = Utf8 de/audi/tghu/online/app/operatorcall/data/AbstractHistoryCallData 
.const [298] = Utf8 getCallIndexForGUI 
.const [299] = Utf8 ()I 
.const [300] = Utf8 de/audi/tghu/online/app/operatorcall/data/PoiResultListRow 
.const [301] = Utf8 idCounter 
.const [302] = Utf8 J 
.const [303] = Utf8 de/audi/atip/hmi/model/list/EvoListRow 
.const [304] = Utf8 <init> 
.const [305] = Utf8 (JI)V 
.const [306] = Utf8 de/audi/atip/hmi/model/list/EvoListRow 
.const [307] = Utf8 <init> 
.const [308] = Utf8 (Lde/audi/atip/hmi/model/list/EvoListRow;)V 
.const [309] = Utf8 de/audi/atip/metrics/Distance 
.const [310] = Utf8 <init> 
.const [311] = Utf8 (FI)V 
.const [312] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [313] = Utf8 <init> 
.const [314] = Utf8 ()V 
.const [315] = Utf8 de/audi/tghu/online/app/operatorcall/data/PoiResultListRow 
.const [316] = Utf8 <init> 
.const [317] = Utf8 (Lde/audi/tghu/online/app/operatorcall/data/PoiResultListRow;)V 
.const [318] = Utf8 de/audi/tghu/online/app/operatorcall/data/PoiResultListRow 
.const [319] = Utf8 logChannel 
.const [320] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [321] = Utf8 de/audi/tghu/online/app/operatorcall/data/PoiResultListRow 
.const [322] = Utf8 result 
.const [323] = Utf8 Lorg/dsi/ifc/online/OperatorCallResult; 
.const [324] = Utf8 de/audi/tghu/online/app/operatorcall/data/PoiResultListRow 
.const [325] = Utf8 naviHandler 
.const [326] = Utf8 Lde/audi/tghu/online/app/operatorcall/handler/NavigationHandler; 
.const [327] = Utf8 de/audi/tghu/online/app/operatorcall/data/PoiResultListRow 
.const [328] = Utf8 historyCallData 
.const [329] = Utf8 Lde/audi/tghu/online/app/operatorcall/data/AbstractHistoryCallData; 
.const [330] = Utf8 de/audi/atip/interapp/NaviService 
.const [331] = Utf8 computeRelativeAirDistance 
.const [332] = Utf8 (II)I 
.const [333] = Utf8 de/audi/atip/interapp/NaviService 
.const [334] = Utf8 computeRelativeDirection 
.const [335] = Utf8 (II)I 
.const [336] = Utf8 de/audi/tghu/online/app/operatorcall/data/PoiResultListRow 
.const [337] = Class [336] 
.const [338] = Utf8 de/audi/atip/hmi/model/list/EvoListRow 
.const [339] = Class [338] 
.const [340] = Utf8 MODE_RELATIVE_AIR_DISTANCE 
.const [341] = Utf8 I 
.const [342] = Utf8 MODE_REAL_ROAD_DISTANCE 
.const [343] = Utf8 I 
.const [344] = Utf8 COLUMN_ID 
.const [345] = Utf8 I 
.const [346] = Utf8 COLUMN_POI_NAME 
.const [347] = Utf8 I 
.const [348] = Utf8 COLUMN_DIRECTION_ARROW 
.const [349] = Utf8 I 
.const [350] = Utf8 COLUMN_DISTANCE 
.const [351] = Utf8 I 
.const [352] = Utf8 idCounter 
.const [353] = Utf8 J 
.const [354] = Utf8 logChannel 
.const [355] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [356] = Utf8 result 
.const [357] = Utf8 Lorg/dsi/ifc/online/OperatorCallResult; 
.const [358] = Utf8 naviHandler 
.const [359] = Utf8 Lde/audi/tghu/online/app/operatorcall/handler/NavigationHandler; 
.const [360] = Utf8 historyCallData 
.const [361] = Utf8 Lde/audi/tghu/online/app/operatorcall/data/AbstractHistoryCallData; 
.const [362] = Utf8 Code 
.const [363] = Utf8 <init> 
.const [364] = Utf8 (Lorg/dsi/ifc/online/OperatorCallResult;Lde/audi/tghu/online/app/operatorcall/handler/NavigationHandler;Lde/audi/tghu/online/app/operatorcall/data/AbstractHistoryCallData;)V 
.const [365] = Utf8 createPropertyListCell 
.const [366] = Utf8 ()V 
.const [367] = Utf8 <init> 
.const [368] = Utf8 (Lde/audi/tghu/online/app/operatorcall/data/PoiResultListRow;)V 
.const [369] = Utf8 computeDistanceAndUpdateData 
.const [370] = Utf8 (I)V 
.const [371] = Utf8 updateInformation 
.const [372] = Utf8 (II)V 
.const [373] = Utf8 getCategory 
.const [374] = Utf8 ()I 
.const [375] = Utf8 getDistanceAsString 
.const [376] = Utf8 (I)Ljava/lang/String; 
.const [377] = Utf8 getDirectionArrow 
.const [378] = Utf8 ()I 
.const [379] = Utf8 getDistance 
.const [380] = Utf8 ()Ljava/lang/String; 
.const [381] = Utf8 copy 
.const [382] = Utf8 ()Lde/audi/atip/hmi/model/list/EvoListRow; 
.const [383] = Utf8 getName 
.const [384] = Utf8 ()Ljava/lang/String; 
.const [385] = Utf8 getLocation 
.const [386] = Utf8 ()Lorg/dsi/ifc/global/NavLocationWgs84; 
.const [387] = Utf8 toString 
.const [388] = Utf8 ()Ljava/lang/String; 
.const [389] = Utf8 getHistoryCallIndex 
.const [390] = Utf8 ()I 
.const [391] = Utf8 getOperatorCallResult 
.const [392] = Utf8 ()Lorg/dsi/ifc/online/OperatorCallResult; 
.const [393] = Utf8 <clinit> 
.const [394] = Utf8 ()V 
.end class 
