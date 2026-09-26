.version 50 0 
.class public super abstract [395] 
.super [397] 
.field public static final [398] [399] 
.field protected [400] [401] 
.field protected [402] [403] 
.field protected [404] [405] 
.field protected final [406] [407] 
.field protected [408] [409] 
.field protected [410] [411] 
.field protected [412] [413] 
.field protected [414] [415] 
.field protected [416] [417] 
.field private [418] [419] 

.method protected abstract [421] : [422] 
    .attribute [420] .code stack 0 locals 0 
L0:     
    .end code 
.end method 

.method public [423] : [424] 
    .attribute [420] .code stack 2 locals 0 
L0:     aload_0 
L1:     invokespecial [64] 
L4:     aload_0 
L5:     invokestatic [2] 
L8:     invokevirtual [24] 
L11:    putfield [69] 
L14:    aload_0 
L15:    iconst_m1 
L16:    putfield [70] 
L19:    aload_0 
L20:    aload_1 
L21:    putfield [71] 
L24:    aload_0 
L25:    aload_2 
L26:    putfield [72] 
L29:    aload_0 
L30:    aload_3 
L31:    putfield [73] 
L34:    aload_0 
L35:    aload 4 
L37:    putfield [74] 
L40:    aload_0 
L41:    aload 5 
L43:    putfield [75] 
L46:    aload_0 
L47:    aload 6 
L49:    putfield [76] 
L52:    aload_0 
L53:    invokespecial [65] 
L56:    return 
L57:    nop 
L58:    nop 
L59:    nop 
L60:    
    .end code 
.end method 

.method public final [425] : [426] 
    .attribute [420] .code stack 3 locals 0 
L0:     aload_0 
L1:     invokevirtual [32] 
L4:     aload_0 
L5:     aload_0 
L6:     getfield [30] 
L9:     aload_0 
L10:    getfield [31] 
L13:    invokevirtual [33] 
L16:    return 
L17:    nop 
L18:    nop 
L19:    nop 
L20:    
    .end code 
.end method 

.method public [427] : [428] 
    .attribute [420] .code stack 5 locals 1 
L0:     aload_0 
L1:     aload_0 
L2:     getfield [28] 
L5:     arraylength 
L6:     anewarray [3] 
L9:     putfield [78] 
L12:    iconst_0 
L13:    istore_1 
L14:    iload_1 
L15:    aload_0 
L16:    getfield [28] 
L19:    arraylength 
L20:    if_icmpge L45 
L23:    aload_0 
L24:    getfield [34] 
L27:    iload_1 
L28:    aload_0 
L29:    aload_0 
L30:    getfield [28] 
L33:    iload_1 
L34:    aaload 
L35:    invokevirtual [35] 
L38:    aastore 
L39:    iinc 1 1 
L42:    goto L14 
L45:    return 
L46:    nop 
L47:    nop 
L48:    
    .end code 
.end method 

.method protected [429] : [430] 
    .attribute [420] .code stack 5 locals 0 
L0:     new [77] 
L3:     dup 
L4:     aload_1 
L5:     aload_0 
L6:     getfield [27] 
L9:     aload_0 
L10:    invokespecial [66] 
L13:    areturn 
L14:    nop 
L15:    nop 
L16:    
    .end code 
.end method 

.method public [431] : [432] 
    .attribute [420] .code stack 3 locals 1 
L0:     aload_0 
L1:     getfield [28] 
L4:     arraylength 
L5:     iconst_1 
L6:     if_icmple L14 
L9:     iconst_0 
L10:    istore_3 
L11:    goto L16 
L14:    iconst_1 
L15:    istore_3 
L16:    aload_1 
L17:    ifnonnull L33 
L20:    aload_0 
L21:    aload_0 
L22:    getfield [28] 
L25:    iconst_0 
L26:    aaload 
L27:    invokevirtual [36] 
L30:    putfield [75] 
L33:    aload_0 
L34:    aload_0 
L35:    iload_3 
L36:    invokevirtual [37] 
L39:    putfield [79] 
L42:    return 
L43:    nop 
L44:    
    .end code 
.end method 

.method public interface [433] : [434] 
    .attribute [420] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [38] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [435] : [436] 
    .attribute [420] .code stack 1 locals 0 
L0:     aload_0 
L1:     invokevirtual [39] 
L4:     aload_0 
L5:     getfield [34] 
L8:     areturn 
L9:     nop 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method protected [437] : [438] 
    .attribute [420] .code stack 2 locals 1 
L0:     iconst_0 
L1:     istore_1 
L2:     iload_1 
L3:     aload_0 
L4:     getfield [34] 
L7:     arraylength 
L8:     if_icmpge L27 
L11:    aload_0 
L12:    getfield [34] 
L15:    iload_1 
L16:    aaload 
L17:    iconst_1 
L18:    invokevirtual [40] 
L21:    iinc 1 1 
L24:    goto L2 
L27:    return 
L28:    
    .end code 
.end method 

.method public [439] : [440] 
    .attribute [420] .code stack 3 locals 0 
L0:     iload_1 
L1:     aload_0 
L2:     getfield [28] 
L5:     arraylength 
L6:     if_icmpge L16 
L9:     aload_0 
L10:    getfield [28] 
L13:    iload_1 
L14:    aaload 
L15:    areturn 
L16:    aload_0 
L17:    getfield [25] 
L20:    sipush 10000 
L23:    ldc [4] 
L25:    invokevirtual [41] 
L28:    pop 
L29:    aconst_null 
L30:    areturn 
L31:    nop 
L32:    
    .end code 
.end method 

.method public interface [441] : [442] 
    .attribute [420] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [28] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [443] : [444] 
    .attribute [420] .code stack 7 locals 0 
L0:     iload_1 
L1:     aload_0 
L2:     getfield [28] 
L5:     arraylength 
L6:     iconst_1 
L7:     isub 
L8:     if_icmple L31 
L11:    aload_0 
L12:    getfield [25] 
L15:    ldc [5] 
L17:    ldc [6] 
L19:    iload_1 
L20:    i2l 
L21:    aload_0 
L22:    getfield [28] 
L25:    arraylength 
L26:    i2l 
L27:    invokevirtual [42] 
L30:    pop 
L31:    aload_0 
L32:    getfield [28] 
L35:    iload_1 
L36:    aaload 
L37:    areturn 
L38:    nop 
L39:    nop 
L40:    
    .end code 
.end method 

.method public [445] : [446] 
    .attribute [420] .code stack 3 locals 10 
L0:     aload_0 
L1:     iload_1 
L2:     invokevirtual [43] 
L5:     astore_2 
L6:     new [80] 
L9:     dup 
L10:    invokespecial [67] 
L13:    astore_3 
L14:    aload_2 
L15:    invokevirtual [44] 
L18:    astore 4 
L20:    aload_3 
L21:    aload 4 
L23:    invokevirtual [45] 
L26:    invokevirtual [46] 
L29:    aload_2 
L30:    invokevirtual [47] 
L33:    invokevirtual [48] 
L36:    istore 5 
L38:    aload_2 
L39:    invokevirtual [47] 
L42:    invokevirtual [49] 
L45:    istore 6 
L47:    aload_0 
L48:    iload 5 
L50:    i2l 
L51:    invokevirtual [50] 
L54:    dstore 7 
L56:    aload_0 
L57:    iload 6 
L59:    i2l 
L60:    invokevirtual [50] 
L63:    dstore 9 
L65:    new [81] 
L68:    dup 
L69:    ldc [9] 
L71:    invokespecial [68] 
L74:    astore 11 
L76:    aload 11 
L78:    dload 7 
L80:    invokevirtual [51] 
L83:    invokestatic [10] 
L86:    dstore 7 
L88:    aload 11 
L90:    dload 9 
L92:    invokevirtual [51] 
L95:    invokestatic [10] 
L98:    dstore 9 
L100:   aload_3 
L101:   dload 7 
L103:   invokevirtual [52] 
L106:   aload_3 
L107:   dload 9 
L109:   invokevirtual [53] 
L112:   aload_3 
L113:   aload 4 
L115:   invokevirtual [54] 
L118:   invokevirtual [55] 
L121:   aload_3 
L122:   aload 4 
L124:   invokevirtual [56] 
L127:   invokevirtual [57] 
L130:   aload_3 
L131:   areturn 
L132:   
    .end code 
.end method 

.method protected [447] : [448] 
    .attribute [420] .code stack 4 locals 0 
L0:     lload_1 
L1:     l2d 
L2:     ldc2_w [82] 
L5:     ddiv 
L6:     freturn 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [449] : [450] 
    .attribute [420] .code stack 2 locals 1 
L0:     aload_0 
L1:     getfield [29] 
L4:     aload_0 
L5:     invokevirtual [58] 
L8:     istore_1 
L9:     aload_0 
L10:    getfield [29] 
L13:    invokevirtual [59] 
L16:    iconst_1 
L17:    isub 
L18:    iload_1 
L19:    isub 
L20:    areturn 
L21:    nop 
L22:    nop 
L23:    nop 
L24:    
    .end code 
.end method 

.method public [451] : [452] 
    .attribute [420] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [38] 
L4:     invokevirtual [60] 
L7:     areturn 
L8:     
    .end code 
.end method 

.method public [453] : [454] 
    .attribute [420] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [38] 
L4:     invokevirtual [61] 
L7:     areturn 
L8:     
    .end code 
.end method 

.method public [455] : [456] 
    .attribute [420] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [38] 
L4:     invokevirtual [62] 
L7:     areturn 
L8:     
    .end code 
.end method 

.method public static [457] : [458] 
    .attribute [420] .code stack 2 locals 0 
L0:     lload_0 
L1:     invokestatic [11] 
L4:     return 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [459] : [460] 
    .attribute [420] .code stack 7 locals 0 
L0:     aload_0 
L1:     getfield [25] 
L4:     ldc [12] 
L6:     ldc [13] 
L8:     aload_0 
L9:     getfield [26] 
L12:    i2l 
L13:    iload_1 
L14:    i2l 
L15:    invokevirtual [42] 
L18:    pop 
L19:    aload_0 
L20:    iload_1 
L21:    putfield [70] 
L24:    aload_0 
L25:    getfield [38] 
L28:    iload_1 
L29:    invokevirtual [63] 
L32:    return 
L33:    nop 
L34:    nop 
L35:    nop 
L36:    
    .end code 
.end method 

.method public interface [461] : [462] 
    .attribute [420] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [26] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Method [84] [85] 
.const [3] = Class [86] 
.const [4] = String [87] 
.const [5] = Int -1601830656 
.const [6] = String [88] 
.const [7] = Class [89] 
.const [8] = Class [90] 
.const [9] = String [91] 
.const [10] = Method [92] [93] 
.const [11] = Method [94] [95] 
.const [12] = Int -2137614336 
.const [13] = String [96] 
.const [14] = Class [97] 
.const [15] = Class [98] 
.const [16] = Class [99] 
.const [17] = Class [100] 
.const [18] = Class [101] 
.const [19] = Class [102] 
.const [20] = Class [103] 
.const [21] = Class [104] 
.const [22] = Class [105] 
.const [23] = Class [106] 
.const [24] = Method [107] [108] 
.const [25] = Field [109] [110] 
.const [26] = Field [111] [112] 
.const [27] = Field [113] [114] 
.const [28] = Field [115] [116] 
.const [29] = Field [117] [118] 
.const [30] = Field [119] [120] 
.const [31] = Field [121] [122] 
.const [32] = Method [123] [124] 
.const [33] = Method [125] [126] 
.const [34] = Field [127] [128] 
.const [35] = Method [129] [130] 
.const [36] = Method [131] [132] 
.const [37] = Method [133] [134] 
.const [38] = Field [135] [136] 
.const [39] = Method [137] [138] 
.const [40] = Method [139] [140] 
.const [41] = Method [141] [142] 
.const [42] = Method [143] [144] 
.const [43] = Method [145] [146] 
.const [44] = Method [147] [148] 
.const [45] = Method [149] [150] 
.const [46] = Method [151] [152] 
.const [47] = Method [153] [154] 
.const [48] = Method [155] [156] 
.const [49] = Method [157] [158] 
.const [50] = Method [159] [160] 
.const [51] = Method [161] [162] 
.const [52] = Method [163] [164] 
.const [53] = Method [165] [166] 
.const [54] = Method [167] [168] 
.const [55] = Method [169] [170] 
.const [56] = Method [171] [172] 
.const [57] = Method [173] [174] 
.const [58] = Method [175] [176] 
.const [59] = Method [177] [178] 
.const [60] = Method [179] [180] 
.const [61] = Method [181] [182] 
.const [62] = Method [183] [184] 
.const [63] = Method [185] [186] 
.const [64] = Method [187] [188] 
.const [65] = Method [189] [190] 
.const [66] = Method [191] [192] 
.const [67] = Method [193] [194] 
.const [68] = Method [195] [196] 
.const [69] = Field [197] [198] 
.const [70] = Field [199] [200] 
.const [71] = Field [201] [202] 
.const [72] = Field [203] [204] 
.const [73] = Field [205] [206] 
.const [74] = Field [207] [208] 
.const [75] = Field [209] [210] 
.const [76] = Field [211] [212] 
.const [77] = Class [213] 
.const [78] = Field [214] [215] 
.const [79] = Field [216] [217] 
.const [80] = Class [218] 
.const [81] = Class [219] 
.const [82] = Double +0x16C16C00000000p-29 
.const [84] = Class [220] 
.const [85] = NameAndType [221] [222] 
.const [86] = Utf8 de/audi/tghu/online/app/operatorcall/data/PoiResultListRow 
.const [87] = Utf8 'AbstractHistoryCallData#getPoiForSDS: poiIndex is illegal!' 
.const [88] = Utf8 'AbstractHistoryCallData#getPoi: index exceeds limits! Requested index = %1, poi list size = %2' 
.const [89] = Utf8 de/audi/remotehmi/RemoteHMILocation 
.const [90] = Utf8 java/text/DecimalFormat 
.const [91] = Utf8 '0.00000' 
.const [92] = Class [223] 
.const [93] = NameAndType [224] [225] 
.const [94] = Class [226] 
.const [95] = NameAndType [227] [228] 
.const [96] = Utf8 'AbstractHistoryCallData#setPersistenceUniqueId: %1 -> %2' 
.const [97] = Utf8 de/audi/tghu/online/app/operatorcall/data/AbstractHistoryCallData 
.const [98] = Utf8 java/lang/Object 
.const [99] = Utf8 de/audi/tghu/online/app/Online 
.const [100] = Utf8 org/dsi/ifc/online/OperatorCallResult 
.const [101] = Utf8 de/audi/atip/log/LogChannel 
.const [102] = Utf8 org/dsi/ifc/online/OperatorCallAddressEntry 
.const [103] = Utf8 org/dsi/ifc/global/NavLocationWgs84 
.const [104] = Utf8 java/lang/Double 
.const [105] = Utf8 java/util/ArrayList 
.const [106] = Utf8 de/audi/tghu/online/app/operatorcall/data/AbstractHistoryCallListRow 
.const [107] = Class [229] 
.const [108] = NameAndType [230] [231] 
.const [109] = Class [232] 
.const [110] = NameAndType [233] [234] 
.const [111] = Class [235] 
.const [112] = NameAndType [236] [237] 
.const [113] = Class [238] 
.const [114] = NameAndType [239] [240] 
.const [115] = Class [241] 
.const [116] = NameAndType [242] [243] 
.const [117] = Class [244] 
.const [118] = NameAndType [245] [246] 
.const [119] = Class [247] 
.const [120] = NameAndType [248] [249] 
.const [121] = Class [250] 
.const [122] = NameAndType [251] [252] 
.const [123] = Class [253] 
.const [124] = NameAndType [254] [255] 
.const [125] = Class [256] 
.const [126] = NameAndType [257] [258] 
.const [127] = Class [259] 
.const [128] = NameAndType [260] [261] 
.const [129] = Class [262] 
.const [130] = NameAndType [263] [264] 
.const [131] = Class [265] 
.const [132] = NameAndType [266] [267] 
.const [133] = Class [268] 
.const [134] = NameAndType [269] [270] 
.const [135] = Class [271] 
.const [136] = NameAndType [272] [273] 
.const [137] = Class [274] 
.const [138] = NameAndType [275] [276] 
.const [139] = Class [277] 
.const [140] = NameAndType [278] [279] 
.const [141] = Class [280] 
.const [142] = NameAndType [281] [282] 
.const [143] = Class [283] 
.const [144] = NameAndType [284] [285] 
.const [145] = Class [286] 
.const [146] = NameAndType [287] [288] 
.const [147] = Class [289] 
.const [148] = NameAndType [290] [291] 
.const [149] = Class [292] 
.const [150] = NameAndType [293] [294] 
.const [151] = Class [295] 
.const [152] = NameAndType [296] [297] 
.const [153] = Class [298] 
.const [154] = NameAndType [299] [300] 
.const [155] = Class [301] 
.const [156] = NameAndType [302] [303] 
.const [157] = Class [304] 
.const [158] = NameAndType [305] [306] 
.const [159] = Class [307] 
.const [160] = NameAndType [308] [309] 
.const [161] = Class [310] 
.const [162] = NameAndType [311] [312] 
.const [163] = Class [313] 
.const [164] = NameAndType [314] [315] 
.const [165] = Class [316] 
.const [166] = NameAndType [317] [318] 
.const [167] = Class [319] 
.const [168] = NameAndType [320] [321] 
.const [169] = Class [322] 
.const [170] = NameAndType [323] [324] 
.const [171] = Class [325] 
.const [172] = NameAndType [326] [327] 
.const [173] = Class [328] 
.const [174] = NameAndType [329] [330] 
.const [175] = Class [331] 
.const [176] = NameAndType [332] [333] 
.const [177] = Class [334] 
.const [178] = NameAndType [335] [336] 
.const [179] = Class [337] 
.const [180] = NameAndType [338] [339] 
.const [181] = Class [340] 
.const [182] = NameAndType [341] [342] 
.const [183] = Class [343] 
.const [184] = NameAndType [344] [345] 
.const [185] = Class [346] 
.const [186] = NameAndType [347] [348] 
.const [187] = Class [349] 
.const [188] = NameAndType [350] [351] 
.const [189] = Class [352] 
.const [190] = NameAndType [353] [354] 
.const [191] = Class [355] 
.const [192] = NameAndType [356] [357] 
.const [193] = Class [358] 
.const [194] = NameAndType [359] [360] 
.const [195] = Class [361] 
.const [196] = NameAndType [362] [363] 
.const [197] = Class [364] 
.const [198] = NameAndType [365] [366] 
.const [199] = Class [367] 
.const [200] = NameAndType [368] [369] 
.const [201] = Class [370] 
.const [202] = NameAndType [371] [372] 
.const [203] = Class [373] 
.const [204] = NameAndType [374] [375] 
.const [205] = Class [376] 
.const [206] = NameAndType [377] [378] 
.const [207] = Class [379] 
.const [208] = NameAndType [380] [381] 
.const [209] = Class [382] 
.const [210] = NameAndType [383] [384] 
.const [211] = Class [385] 
.const [212] = NameAndType [386] [387] 
.const [213] = Utf8 de/audi/tghu/online/app/operatorcall/data/PoiResultListRow 
.const [214] = Class [388] 
.const [215] = NameAndType [389] [390] 
.const [216] = Class [391] 
.const [217] = NameAndType [392] [393] 
.const [218] = Utf8 de/audi/remotehmi/RemoteHMILocation 
.const [219] = Utf8 java/text/DecimalFormat 
.const [220] = Utf8 de/audi/tghu/online/app/Online 
.const [221] = Utf8 getInstance 
.const [222] = Utf8 ()Lde/audi/tghu/online/app/Online; 
.const [223] = Utf8 java/lang/Double 
.const [224] = Utf8 parseDouble 
.const [225] = Utf8 (Ljava/lang/String;)D 
.const [226] = Utf8 de/audi/tghu/online/app/operatorcall/data/AbstractHistoryCallListRow 
.const [227] = Utf8 setNextFreeUniqueId 
.const [228] = Utf8 (J)V 
.const [229] = Utf8 de/audi/tghu/online/app/Online 
.const [230] = Utf8 getOperatorCallLogChannel 
.const [231] = Utf8 ()Lde/audi/atip/log/LogChannel; 
.const [232] = Utf8 de/audi/tghu/online/app/operatorcall/data/AbstractHistoryCallData 
.const [233] = Utf8 logChannel 
.const [234] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [235] = Utf8 de/audi/tghu/online/app/operatorcall/data/AbstractHistoryCallData 
.const [236] = Utf8 persistenceUniqueId 
.const [237] = Utf8 I 
.const [238] = Utf8 de/audi/tghu/online/app/operatorcall/data/AbstractHistoryCallData 
.const [239] = Utf8 naviHandler 
.const [240] = Utf8 Lde/audi/tghu/online/app/operatorcall/handler/NavigationHandler; 
.const [241] = Utf8 de/audi/tghu/online/app/operatorcall/data/AbstractHistoryCallData 
.const [242] = Utf8 operatorCallResults 
.const [243] = Utf8 [Lorg/dsi/ifc/online/OperatorCallResult; 
.const [244] = Utf8 de/audi/tghu/online/app/operatorcall/data/AbstractHistoryCallData 
.const [245] = Utf8 callsArray 
.const [246] = Utf8 Ljava/util/ArrayList; 
.const [247] = Utf8 de/audi/tghu/online/app/operatorcall/data/AbstractHistoryCallData 
.const [248] = Utf8 name 
.const [249] = Utf8 Ljava/lang/String; 
.const [250] = Utf8 de/audi/tghu/online/app/operatorcall/data/AbstractHistoryCallData 
.const [251] = Utf8 dateTime 
.const [252] = Utf8 Ljava/util/Date; 
.const [253] = Utf8 de/audi/tghu/online/app/operatorcall/data/AbstractHistoryCallData 
.const [254] = Utf8 createPoiResultItems 
.const [255] = Utf8 ()V 
.const [256] = Utf8 de/audi/tghu/online/app/operatorcall/data/AbstractHistoryCallData 
.const [257] = Utf8 createHistoryCallForGUIList 
.const [258] = Utf8 (Ljava/lang/String;Ljava/util/Date;)V 
.const [259] = Utf8 de/audi/tghu/online/app/operatorcall/data/AbstractHistoryCallData 
.const [260] = Utf8 poiResultItems 
.const [261] = Utf8 [Lde/audi/tghu/online/app/operatorcall/data/PoiResultListRow; 
.const [262] = Utf8 de/audi/tghu/online/app/operatorcall/data/AbstractHistoryCallData 
.const [263] = Utf8 createNewPoiResultListRow 
.const [264] = Utf8 (Lorg/dsi/ifc/online/OperatorCallResult;)Lde/audi/tghu/online/app/operatorcall/data/PoiResultListRow; 
.const [265] = Utf8 org/dsi/ifc/online/OperatorCallResult 
.const [266] = Utf8 getName 
.const [267] = Utf8 ()Ljava/lang/String; 
.const [268] = Utf8 de/audi/tghu/online/app/operatorcall/data/AbstractHistoryCallData 
.const [269] = Utf8 createHistoryCallListRow 
.const [270] = Utf8 (Z)Lde/audi/tghu/online/app/operatorcall/data/AbstractHistoryCallListRow; 
.const [271] = Utf8 de/audi/tghu/online/app/operatorcall/data/AbstractHistoryCallData 
.const [272] = Utf8 historyCallItem 
.const [273] = Utf8 Lde/audi/tghu/online/app/operatorcall/data/AbstractHistoryCallListRow; 
.const [274] = Utf8 de/audi/tghu/online/app/operatorcall/data/AbstractHistoryCallData 
.const [275] = Utf8 updateDistance 
.const [276] = Utf8 ()V 
.const [277] = Utf8 de/audi/tghu/online/app/operatorcall/data/PoiResultListRow 
.const [278] = Utf8 computeDistanceAndUpdateData 
.const [279] = Utf8 (I)V 
.const [280] = Utf8 de/audi/atip/log/LogChannel 
.const [281] = Utf8 log 
.const [282] = Utf8 (ILjava/lang/String;)Z 
.const [283] = Utf8 de/audi/atip/log/LogChannel 
.const [284] = Utf8 log 
.const [285] = Utf8 (ILjava/lang/String;JJ)Z 
.const [286] = Utf8 de/audi/tghu/online/app/operatorcall/data/AbstractHistoryCallData 
.const [287] = Utf8 getPoi 
.const [288] = Utf8 (I)Lorg/dsi/ifc/online/OperatorCallResult; 
.const [289] = Utf8 org/dsi/ifc/online/OperatorCallResult 
.const [290] = Utf8 getAddress 
.const [291] = Utf8 ()Lorg/dsi/ifc/online/OperatorCallAddressEntry; 
.const [292] = Utf8 org/dsi/ifc/online/OperatorCallAddressEntry 
.const [293] = Utf8 getCountry 
.const [294] = Utf8 ()Ljava/lang/String; 
.const [295] = Utf8 de/audi/remotehmi/RemoteHMILocation 
.const [296] = Utf8 setCountry 
.const [297] = Utf8 (Ljava/lang/String;)V 
.const [298] = Utf8 org/dsi/ifc/online/OperatorCallResult 
.const [299] = Utf8 getLocation 
.const [300] = Utf8 ()Lorg/dsi/ifc/global/NavLocationWgs84; 
.const [301] = Utf8 org/dsi/ifc/global/NavLocationWgs84 
.const [302] = Utf8 getLatitude 
.const [303] = Utf8 ()I 
.const [304] = Utf8 org/dsi/ifc/global/NavLocationWgs84 
.const [305] = Utf8 getLongitude 
.const [306] = Utf8 ()I 
.const [307] = Utf8 de/audi/tghu/online/app/operatorcall/data/AbstractHistoryCallData 
.const [308] = Utf8 convertToWgs 
.const [309] = Utf8 (J)D 
.const [310] = Utf8 java/text/DecimalFormat 
.const [311] = Utf8 format 
.const [312] = Utf8 (D)Ljava/lang/String; 
.const [313] = Utf8 de/audi/remotehmi/RemoteHMILocation 
.const [314] = Utf8 setLatitude 
.const [315] = Utf8 (D)V 
.const [316] = Utf8 de/audi/remotehmi/RemoteHMILocation 
.const [317] = Utf8 setLongitude 
.const [318] = Utf8 (D)V 
.const [319] = Utf8 org/dsi/ifc/online/OperatorCallAddressEntry 
.const [320] = Utf8 getStreet 
.const [321] = Utf8 ()Ljava/lang/String; 
.const [322] = Utf8 de/audi/remotehmi/RemoteHMILocation 
.const [323] = Utf8 setStreet 
.const [324] = Utf8 (Ljava/lang/String;)V 
.const [325] = Utf8 org/dsi/ifc/online/OperatorCallAddressEntry 
.const [326] = Utf8 getCity 
.const [327] = Utf8 ()Ljava/lang/String; 
.const [328] = Utf8 de/audi/remotehmi/RemoteHMILocation 
.const [329] = Utf8 setTown 
.const [330] = Utf8 (Ljava/lang/String;)V 
.const [331] = Utf8 java/util/ArrayList 
.const [332] = Utf8 indexOf 
.const [333] = Utf8 (Ljava/lang/Object;)I 
.const [334] = Utf8 java/util/ArrayList 
.const [335] = Utf8 size 
.const [336] = Utf8 ()I 
.const [337] = Utf8 de/audi/tghu/online/app/operatorcall/data/AbstractHistoryCallListRow 
.const [338] = Utf8 getName 
.const [339] = Utf8 ()Ljava/lang/String; 
.const [340] = Utf8 de/audi/tghu/online/app/operatorcall/data/AbstractHistoryCallListRow 
.const [341] = Utf8 getDateTime 
.const [342] = Utf8 ()Ljava/util/Date; 
.const [343] = Utf8 de/audi/tghu/online/app/operatorcall/data/AbstractHistoryCallListRow 
.const [344] = Utf8 getNumberOfPois 
.const [345] = Utf8 ()I 
.const [346] = Utf8 de/audi/tghu/online/app/operatorcall/data/AbstractHistoryCallListRow 
.const [347] = Utf8 setPersistenceUniqueId 
.const [348] = Utf8 (I)V 
.const [349] = Utf8 java/lang/Object 
.const [350] = Utf8 <init> 
.const [351] = Utf8 ()V 
.const [352] = Utf8 de/audi/tghu/online/app/operatorcall/data/AbstractHistoryCallData 
.const [353] = Utf8 init 
.const [354] = Utf8 ()V 
.const [355] = Utf8 de/audi/tghu/online/app/operatorcall/data/PoiResultListRow 
.const [356] = Utf8 <init> 
.const [357] = Utf8 (Lorg/dsi/ifc/online/OperatorCallResult;Lde/audi/tghu/online/app/operatorcall/handler/NavigationHandler;Lde/audi/tghu/online/app/operatorcall/data/AbstractHistoryCallData;)V 
.const [358] = Utf8 de/audi/remotehmi/RemoteHMILocation 
.const [359] = Utf8 <init> 
.const [360] = Utf8 ()V 
.const [361] = Utf8 java/text/DecimalFormat 
.const [362] = Utf8 <init> 
.const [363] = Utf8 (Ljava/lang/String;)V 
.const [364] = Utf8 de/audi/tghu/online/app/operatorcall/data/AbstractHistoryCallData 
.const [365] = Utf8 logChannel 
.const [366] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [367] = Utf8 de/audi/tghu/online/app/operatorcall/data/AbstractHistoryCallData 
.const [368] = Utf8 persistenceUniqueId 
.const [369] = Utf8 I 
.const [370] = Utf8 de/audi/tghu/online/app/operatorcall/data/AbstractHistoryCallData 
.const [371] = Utf8 framework 
.const [372] = Utf8 Lde/audi/atip/base/IFrameworkAccess; 
.const [373] = Utf8 de/audi/tghu/online/app/operatorcall/data/AbstractHistoryCallData 
.const [374] = Utf8 naviHandler 
.const [375] = Utf8 Lde/audi/tghu/online/app/operatorcall/handler/NavigationHandler; 
.const [376] = Utf8 de/audi/tghu/online/app/operatorcall/data/AbstractHistoryCallData 
.const [377] = Utf8 operatorCallResults 
.const [378] = Utf8 [Lorg/dsi/ifc/online/OperatorCallResult; 
.const [379] = Utf8 de/audi/tghu/online/app/operatorcall/data/AbstractHistoryCallData 
.const [380] = Utf8 callsArray 
.const [381] = Utf8 Ljava/util/ArrayList; 
.const [382] = Utf8 de/audi/tghu/online/app/operatorcall/data/AbstractHistoryCallData 
.const [383] = Utf8 name 
.const [384] = Utf8 Ljava/lang/String; 
.const [385] = Utf8 de/audi/tghu/online/app/operatorcall/data/AbstractHistoryCallData 
.const [386] = Utf8 dateTime 
.const [387] = Utf8 Ljava/util/Date; 
.const [388] = Utf8 de/audi/tghu/online/app/operatorcall/data/AbstractHistoryCallData 
.const [389] = Utf8 poiResultItems 
.const [390] = Utf8 [Lde/audi/tghu/online/app/operatorcall/data/PoiResultListRow; 
.const [391] = Utf8 de/audi/tghu/online/app/operatorcall/data/AbstractHistoryCallData 
.const [392] = Utf8 historyCallItem 
.const [393] = Utf8 Lde/audi/tghu/online/app/operatorcall/data/AbstractHistoryCallListRow; 
.const [394] = Utf8 de/audi/tghu/online/app/operatorcall/data/AbstractHistoryCallData 
.const [395] = Class [394] 
.const [396] = Utf8 java/lang/Object 
.const [397] = Class [396] 
.const [398] = Utf8 PERSISTENCE_UNIQUE_ID_NONE 
.const [399] = Utf8 I 
.const [400] = Utf8 operatorCallResults 
.const [401] = Utf8 [Lorg/dsi/ifc/online/OperatorCallResult; 
.const [402] = Utf8 poiResultItems 
.const [403] = Utf8 [Lde/audi/tghu/online/app/operatorcall/data/PoiResultListRow; 
.const [404] = Utf8 historyCallItem 
.const [405] = Utf8 Lde/audi/tghu/online/app/operatorcall/data/AbstractHistoryCallListRow; 
.const [406] = Utf8 logChannel 
.const [407] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [408] = Utf8 framework 
.const [409] = Utf8 Lde/audi/atip/base/IFrameworkAccess; 
.const [410] = Utf8 naviHandler 
.const [411] = Utf8 Lde/audi/tghu/online/app/operatorcall/handler/NavigationHandler; 
.const [412] = Utf8 callsArray 
.const [413] = Utf8 Ljava/util/ArrayList; 
.const [414] = Utf8 name 
.const [415] = Utf8 Ljava/lang/String; 
.const [416] = Utf8 dateTime 
.const [417] = Utf8 Ljava/util/Date; 
.const [418] = Utf8 persistenceUniqueId 
.const [419] = Utf8 I 
.const [420] = Utf8 Code 
.const [421] = Utf8 createHistoryCallListRow 
.const [422] = Utf8 (Z)Lde/audi/tghu/online/app/operatorcall/data/AbstractHistoryCallListRow; 
.const [423] = Utf8 <init> 
.const [424] = Utf8 (Lde/audi/atip/base/IFrameworkAccess;Lde/audi/tghu/online/app/operatorcall/handler/NavigationHandler;[Lorg/dsi/ifc/online/OperatorCallResult;Ljava/util/ArrayList;Ljava/lang/String;Ljava/util/Date;)V 
.const [425] = Utf8 init 
.const [426] = Utf8 ()V 
.const [427] = Utf8 createPoiResultItems 
.const [428] = Utf8 ()V 
.const [429] = Utf8 createNewPoiResultListRow 
.const [430] = Utf8 (Lorg/dsi/ifc/online/OperatorCallResult;)Lde/audi/tghu/online/app/operatorcall/data/PoiResultListRow; 
.const [431] = Utf8 createHistoryCallForGUIList 
.const [432] = Utf8 (Ljava/lang/String;Ljava/util/Date;)V 
.const [433] = Utf8 getHistoryCallForGUIList 
.const [434] = Utf8 ()Lde/audi/tghu/online/app/operatorcall/data/AbstractHistoryCallListRow; 
.const [435] = Utf8 getPoisForGUIList 
.const [436] = Utf8 ()[Lde/audi/tghu/online/app/operatorcall/data/PoiResultListRow; 
.const [437] = Utf8 updateDistance 
.const [438] = Utf8 ()V 
.const [439] = Utf8 getPoiForSDS 
.const [440] = Utf8 (I)Lorg/dsi/ifc/online/OperatorCallResult; 
.const [441] = Utf8 getPois 
.const [442] = Utf8 ()[Lorg/dsi/ifc/online/OperatorCallResult; 
.const [443] = Utf8 getPoi 
.const [444] = Utf8 (I)Lorg/dsi/ifc/online/OperatorCallResult; 
.const [445] = Utf8 getPoiForAudiConnect 
.const [446] = Utf8 (I)Lde/audi/remotehmi/RemoteHMILocation; 
.const [447] = Utf8 convertToWgs 
.const [448] = Utf8 (J)D 
.const [449] = Utf8 getCallIndexForGUI 
.const [450] = Utf8 ()I 
.const [451] = Utf8 getName 
.const [452] = Utf8 ()Ljava/lang/String; 
.const [453] = Utf8 getDateTime 
.const [454] = Utf8 ()Ljava/util/Date; 
.const [455] = Utf8 getNumberOfPois 
.const [456] = Utf8 ()I 
.const [457] = Utf8 setNextFreeUniqueId 
.const [458] = Utf8 (J)V 
.const [459] = Utf8 setPersistenceUniqueId 
.const [460] = Utf8 (I)V 
.const [461] = Utf8 getPersistenceUniqueId 
.const [462] = Utf8 ()I 
.end class 
