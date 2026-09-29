.version 50 0 
.class public super abstract [333] 
.super [335] 
.implements [337] 
.field protected [338] [339] 
.field public static final [340] [341] 
.field public static final [342] [343] 
.field public static final [344] [345] 
.field public static final [346] [347] 
.field public static final [348] [349] 
.field public static final [350] [351] 
.field protected [352] [353] 
.field protected [354] [355] 
.field protected [356] [357] 
.field private [358] [359] 

.method public [361] : [362] 
    .attribute [360] .code stack 2 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     invokespecial [58] 
L5:     aload_0 
L6:     iconst_0 
L7:     putfield [63] 
L10:    return 
L11:    nop 
L12:    
    .end code 
.end method 

.method public [363] : [364] 
    .attribute [360] .code stack 2 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     invokespecial [58] 
L5:     aload_0 
L6:     iconst_0 
L7:     putfield [63] 
L10:    aload_0 
L11:    aload_2 
L12:    putfield [64] 
L15:    aload_0 
L16:    aload_3 
L17:    putfield [65] 
L20:    return 
L21:    nop 
L22:    nop 
L23:    nop 
L24:    
    .end code 
.end method 

.method public [365] : [366] 
    .attribute [360] .code stack 3 locals 1 
L0:     aload_0 
L1:     getfield [34] 
L4:     ldc [2] 
L6:     ldc [3] 
L8:     invokevirtual [35] 
L11:    pop 
L12:    aload_0 
L13:    aload_1 
L14:    invokespecial [59] 
L17:    aload_1 
L18:    instanceof [4] 
L21:    ifeq L40 
L24:    aload_1 
L25:    checkcast [4] 
L28:    astore_2 
L29:    aload_0 
L30:    aload_2 
L31:    invokevirtual [36] 
L34:    invokevirtual [37] 
L37:    goto L50 
L40:    new [66] 
L43:    dup 
L44:    ldc [6] 
L46:    invokespecial [60] 
L49:    athrow 
L50:    return 
L51:    nop 
L52:    
    .end code 
.end method 

.method protected [367] : [368] 
    .attribute [360] .code stack 3 locals 0 
L0:     aload_0 
L1:     getfield [34] 
L4:     ldc [2] 
L6:     ldc [7] 
L8:     invokevirtual [35] 
L11:    pop 
L12:    aload_0 
L13:    aload_1 
L14:    putfield [67] 
L17:    return 
L18:    nop 
L19:    nop 
L20:    
    .end code 
.end method 

.method public [369] : [370] 
    .attribute [360] .code stack 7 locals 1 
L0:     aload_0 
L1:     getfield [34] 
L4:     ldc [8] 
L6:     ldc [9] 
L8:     iload_2 
L9:     i2l 
L10:    iload_3 
L11:    i2l 
L12:    invokevirtual [38] 
L15:    pop 
L16:    aload_0 
L17:    iload_3 
L18:    putfield [63] 
L21:    iload_3 
L22:    bipush 10 
L24:    if_icmpeq L39 
L27:    iload_3 
L28:    bipush 11 
L30:    if_icmpeq L39 
L33:    iload_3 
L34:    bipush 12 
L36:    if_icmpne L40 
L39:    return 
L40:    aload_0 
L41:    iconst_0 
L42:    putfield [68] 
        .catch [11] from L45 to L63 using L66 
L45:    aload_0 
L46:    getfield [32] 
L49:    aload_0 
L50:    iload_3 
L51:    invokevirtual [40] 
L54:    iload_3 
L55:    invokestatic [10] 
L58:    invokeinterface [69] 0 
L63:    goto L82 
L66:    astore 4 
L68:    aload_0 
L69:    getfield [34] 
L72:    ldc [8] 
L74:    ldc [12] 
L76:    aload 4 
L78:    invokevirtual [41] 
L81:    pop 
L82:    return 
L83:    nop 
L84:    
    .end code 
.end method 

.method public [371] : [372] 
    .attribute [360] .code stack 9 locals 2 
L0:     aload_0 
L1:     getfield [34] 
L4:     ldc [2] 
L6:     ldc [13] 
L8:     invokevirtual [35] 
L11:    pop 
L12:    new [70] 
L15:    dup 
L16:    invokespecial [61] 
L19:    astore 6 
L21:    aload 6 
L23:    ldc [15] 
L25:    invokevirtual [42] 
L28:    aload_3 
L29:    invokevirtual [43] 
L32:    invokevirtual [42] 
L35:    ldc [16] 
L37:    invokevirtual [42] 
L40:    iload 5 
L42:    invokevirtual [44] 
L45:    ldc [17] 
L47:    invokevirtual [42] 
L50:    iload 4 
L52:    invokevirtual [44] 
L55:    ldc [18] 
L57:    invokevirtual [42] 
L60:    aload_0 
L61:    getfield [31] 
L64:    invokevirtual [44] 
L67:    ldc [19] 
L69:    invokevirtual [42] 
L72:    pop 
L73:    aload_0 
L74:    getfield [34] 
L77:    ldc [8] 
L79:    aload 6 
L81:    invokevirtual [45] 
L84:    invokevirtual [35] 
L87:    pop 
L88:    iconst_m1 
L89:    istore 7 
L91:    aload_0 
L92:    getfield [31] 
L95:    bipush 11 
L97:    if_icmpne L260 
L100:   aload_0 
L101:   getfield [32] 
L104:   iload_2 
L105:   aload_3 
L106:   getfield [46] 
L109:   aload_3 
L110:   getfield [47] 
L113:   aload_3 
L114:   getfield [48] 
L117:   aload_3 
L118:   getfield [49] 
L121:   aload_3 
L122:   getfield [50] 
L125:   aload_3 
L126:   getfield [51] 
L129:   aload_3 
L130:   getfield [52] 
L133:   invokeinterface [71] 0 
L138:   aload_0 
L139:   getfield [33] 
L142:   iload_2 
L143:   aload_3 
L144:   iload 4 
L146:   iload 5 
L148:   iconst_1 
L149:   aload_0 
L150:   getfield [33] 
L153:   invokevirtual [53] 
L156:   invokevirtual [54] 
L159:   aload_0 
L160:   getfield [32] 
L163:   iload_2 
L164:   aload_3 
L165:   iload 4 
L167:   iload 5 
L169:   iconst_1 
L170:   aload_0 
L171:   getfield [33] 
L174:   invokevirtual [53] 
L177:   invokeinterface [72] 0 
L182:   istore 7 
L184:   aload_0 
L185:   getfield [33] 
L188:   iload 7 
L190:   invokevirtual [55] 
L193:   aload_0 
L194:   getfield [39] 
L197:   ifeq L239 
L200:   aload_0 
L201:   getfield [34] 
L204:   ldc [8] 
L206:   ldc [20] 
L208:   invokevirtual [35] 
L211:   pop 
L212:   aload_0 
L213:   invokevirtual [56] 
L216:   new [73] 
L219:   dup 
L220:   aload_0 
L221:   getfield [34] 
L224:   aload_0 
L225:   getfield [32] 
L228:   invokespecial [62] 
L231:   invokeinterface [74] 0 
L236:   goto L269 
L239:   aload_0 
L240:   getfield [32] 
L243:   invokeinterface [75] 0 
L248:   aload_0 
L249:   invokevirtual [56] 
L252:   invokeinterface [76] 0 
L257:   goto L269 
L260:   aload_0 
L261:   invokevirtual [56] 
L264:   invokeinterface [76] 0 
L269:   aload_0 
L270:   getfield [32] 
L273:   sipush 4160 
L276:   iload 7 
L278:   ifgt L285 
L281:   iconst_0 
L282:   goto L286 
L285:   iconst_1 
L286:   iconst_1 
L287:   invokeinterface [77] 0 
L292:   return 
L293:   nop 
L294:   nop 
L295:   nop 
L296:   
    .end code 
.end method 

.method protected [373] : [374] 
    .attribute [360] .code stack 5 locals 2 
L0:     aload_0 
L1:     getfield [34] 
L4:     ldc [8] 
L6:     ldc [22] 
L8:     iload_1 
L9:     i2l 
L10:    invokevirtual [57] 
L13:    pop 
L14:    iload_1 
L15:    bipush 44 
L17:    if_icmpne L22 
L20:    iconst_4 
L21:    areturn 
L22:    iload_1 
L23:    bipush 10 
L25:    idiv 
L26:    istore_2 
L27:    iload_2 
L28:    tableswitch 0 
            L68 
            L73 
            L78 
            L83 
            L88 
            L93 
            default : L98 

L68:    iconst_0 
L69:    istore_3 
L70:    goto L100 
L73:    iconst_0 
L74:    istore_3 
L75:    goto L100 
L78:    iconst_1 
L79:    istore_3 
L80:    goto L100 
L83:    iconst_2 
L84:    istore_3 
L85:    goto L100 
L88:    iconst_3 
L89:    istore_3 
L90:    goto L100 
L93:    iconst_4 
L94:    istore_3 
L95:    goto L100 
L98:    iconst_0 
L99:    istore_3 
L100:   iload_3 
L101:   areturn 
L102:   nop 
L103:   nop 
L104:   
    .end code 
.end method 

.method public enum [375] : [376] 
    .attribute [360] .code stack 0 locals 0 
L0:     return 
L1:     nop 
L2:     nop 
L3:     nop 
L4:     
    .end code 
.end method 

.method public enum [377] : [378] 
    .attribute [360] .code stack 0 locals 0 
L0:     return 
L1:     nop 
L2:     nop 
L3:     nop 
L4:     
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Int 1078071040 
.const [3] = String [78] 
.const [4] = Class [79] 
.const [5] = Class [80] 
.const [6] = String [81] 
.const [7] = String [82] 
.const [8] = Int -2137614336 
.const [9] = String [83] 
.const [10] = Method [84] [85] 
.const [11] = Class [86] 
.const [12] = String [87] 
.const [13] = String [88] 
.const [14] = Class [89] 
.const [15] = String [90] 
.const [16] = String [91] 
.const [17] = String [92] 
.const [18] = String [93] 
.const [19] = String [94] 
.const [20] = String [95] 
.const [21] = Class [96] 
.const [22] = String [97] 
.const [23] = Class [98] 
.const [24] = Class [99] 
.const [25] = Class [100] 
.const [26] = Class [101] 
.const [27] = Class [102] 
.const [28] = Class [103] 
.const [29] = Class [104] 
.const [30] = Class [105] 
.const [31] = Field [106] [107] 
.const [32] = Field [108] [109] 
.const [33] = Field [110] [111] 
.const [34] = Field [112] [113] 
.const [35] = Method [114] [115] 
.const [36] = Method [116] [117] 
.const [37] = Method [118] [119] 
.const [38] = Method [120] [121] 
.const [39] = Field [122] [123] 
.const [40] = Method [124] [125] 
.const [41] = Method [126] [127] 
.const [42] = Method [128] [129] 
.const [43] = Method [130] [131] 
.const [44] = Method [132] [133] 
.const [45] = Method [134] [135] 
.const [46] = Field [136] [137] 
.const [47] = Field [138] [139] 
.const [48] = Field [140] [141] 
.const [49] = Field [142] [143] 
.const [50] = Field [144] [145] 
.const [51] = Field [146] [147] 
.const [52] = Field [148] [149] 
.const [53] = Method [150] [151] 
.const [54] = Method [152] [153] 
.const [55] = Method [154] [155] 
.const [56] = Method [156] [157] 
.const [57] = Method [158] [159] 
.const [58] = Method [160] [161] 
.const [59] = Method [162] [163] 
.const [60] = Method [164] [165] 
.const [61] = Method [166] [167] 
.const [62] = Method [168] [169] 
.const [63] = Field [170] [171] 
.const [64] = Field [172] [173] 
.const [65] = Field [174] [175] 
.const [66] = Class [176] 
.const [67] = Field [177] [178] 
.const [68] = Field [179] [180] 
.const [69] = InterfaceMethod [181] [182] 
.const [70] = Class [183] 
.const [71] = InterfaceMethod [184] [185] 
.const [72] = InterfaceMethod [186] [187] 
.const [73] = Class [188] 
.const [74] = InterfaceMethod [189] [190] 
.const [75] = InterfaceMethod [191] [192] 
.const [76] = InterfaceMethod [193] [194] 
.const [77] = InterfaceMethod [195] [196] 
.const [78] = Utf8 'OnlinePoiCommand#setCommandList()' 
.const [79] = Utf8 de/audi/tghu/navi/app/command/poi/online/OnlinePoiCommandList 
.const [80] = Utf8 java/lang/ClassCastException 
.const [81] = Utf8 'Expected OnlinePoiCommandList!' 
.const [82] = Utf8 'OnlinePoiCommand#init()' 
.const [83] = Utf8 'AbstractOnlineSearchCommand#poiResult( %1, %2 )' 
.const [84] = Class [197] 
.const [85] = NameAndType [198] [199] 
.const [86] = Utf8 java/lang/Exception 
.const [87] = Utf8 'AbstractOnlineSearchCommand#poiResult: exception occured %1' 
.const [88] = Utf8 'AbstractOnlineSearchCommand#poiValueList()' 
.const [89] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [90] = Utf8 "AbstractOnlineSearchCommand#poiValueList  valueList='" 
.const [91] = Utf8 "',totalItems='" 
.const [92] = Utf8 "', indexOfFirstItem='" 
.const [93] = Utf8 "', returnCode='" 
.const [94] = Utf8 "'" 
.const [95] = Utf8 'AbstractOnlineSearchCommand#poiValueList() Sending spelling suggestion request.' 
.const [96] = Utf8 de/audi/tghu/navi/app/command/poi/online/SpellingSuggestionCommand 
.const [97] = Utf8 'AbstractOnlineSearchCommand#statusToErrorCode() status : %1' 
.const [98] = Utf8 de/audi/tghu/navi/app/command/poi/online/AbstractOnlineSearchCommand 
.const [99] = Utf8 de/audi/tghu/command/Command 
.const [100] = Utf8 de/audi/atip/log/LogChannel 
.const [101] = Utf8 java/lang/Integer 
.const [102] = Utf8 de/audi/tghu/navi/app/poi/online/IOnlineSearchForm 
.const [103] = Utf8 org/dsi/ifc/online/PoiOnlineSearchValuelist 
.const [104] = Utf8 de/audi/tghu/navi/app/poi/online/OnlineSearchContext 
.const [105] = Utf8 de/audi/tghu/command/ICommandList 
.const [106] = Class [200] 
.const [107] = NameAndType [201] [202] 
.const [108] = Class [203] 
.const [109] = NameAndType [204] [205] 
.const [110] = Class [206] 
.const [111] = NameAndType [207] [208] 
.const [112] = Class [209] 
.const [113] = NameAndType [210] [211] 
.const [114] = Class [212] 
.const [115] = NameAndType [213] [214] 
.const [116] = Class [215] 
.const [117] = NameAndType [216] [217] 
.const [118] = Class [218] 
.const [119] = NameAndType [219] [220] 
.const [120] = Class [221] 
.const [121] = NameAndType [222] [223] 
.const [122] = Class [224] 
.const [123] = NameAndType [225] [226] 
.const [124] = Class [227] 
.const [125] = NameAndType [228] [229] 
.const [126] = Class [230] 
.const [127] = NameAndType [231] [232] 
.const [128] = Class [233] 
.const [129] = NameAndType [234] [235] 
.const [130] = Class [236] 
.const [131] = NameAndType [237] [238] 
.const [132] = Class [239] 
.const [133] = NameAndType [240] [241] 
.const [134] = Class [242] 
.const [135] = NameAndType [243] [244] 
.const [136] = Class [245] 
.const [137] = NameAndType [246] [247] 
.const [138] = Class [248] 
.const [139] = NameAndType [249] [250] 
.const [140] = Class [251] 
.const [141] = NameAndType [252] [253] 
.const [142] = Class [254] 
.const [143] = NameAndType [255] [256] 
.const [144] = Class [257] 
.const [145] = NameAndType [258] [259] 
.const [146] = Class [260] 
.const [147] = NameAndType [261] [262] 
.const [148] = Class [263] 
.const [149] = NameAndType [264] [265] 
.const [150] = Class [266] 
.const [151] = NameAndType [267] [268] 
.const [152] = Class [269] 
.const [153] = NameAndType [270] [271] 
.const [154] = Class [272] 
.const [155] = NameAndType [273] [274] 
.const [156] = Class [275] 
.const [157] = NameAndType [276] [277] 
.const [158] = Class [278] 
.const [159] = NameAndType [279] [280] 
.const [160] = Class [281] 
.const [161] = NameAndType [282] [283] 
.const [162] = Class [284] 
.const [163] = NameAndType [285] [286] 
.const [164] = Class [287] 
.const [165] = NameAndType [288] [289] 
.const [166] = Class [290] 
.const [167] = NameAndType [291] [292] 
.const [168] = Class [293] 
.const [169] = NameAndType [294] [295] 
.const [170] = Class [296] 
.const [171] = NameAndType [297] [298] 
.const [172] = Class [299] 
.const [173] = NameAndType [300] [301] 
.const [174] = Class [302] 
.const [175] = NameAndType [303] [304] 
.const [176] = Utf8 java/lang/ClassCastException 
.const [177] = Class [305] 
.const [178] = NameAndType [306] [307] 
.const [179] = Class [308] 
.const [180] = NameAndType [309] [310] 
.const [181] = Class [311] 
.const [182] = NameAndType [312] [313] 
.const [183] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [184] = Class [314] 
.const [185] = NameAndType [315] [316] 
.const [186] = Class [317] 
.const [187] = NameAndType [318] [319] 
.const [188] = Utf8 de/audi/tghu/navi/app/command/poi/online/SpellingSuggestionCommand 
.const [189] = Class [320] 
.const [190] = NameAndType [321] [322] 
.const [191] = Class [323] 
.const [192] = NameAndType [324] [325] 
.const [193] = Class [326] 
.const [194] = NameAndType [327] [328] 
.const [195] = Class [329] 
.const [196] = NameAndType [330] [331] 
.const [197] = Utf8 java/lang/Integer 
.const [198] = Utf8 toString 
.const [199] = Utf8 (I)Ljava/lang/String; 
.const [200] = Utf8 de/audi/tghu/navi/app/command/poi/online/AbstractOnlineSearchCommand 
.const [201] = Utf8 returnCode 
.const [202] = Utf8 I 
.const [203] = Utf8 de/audi/tghu/navi/app/command/poi/online/AbstractOnlineSearchCommand 
.const [204] = Utf8 form 
.const [205] = Utf8 Lde/audi/tghu/navi/app/poi/online/IOnlineSearchForm; 
.const [206] = Utf8 de/audi/tghu/navi/app/command/poi/online/AbstractOnlineSearchCommand 
.const [207] = Utf8 onlineSearchStatus 
.const [208] = Utf8 Lde/audi/tghu/navi/app/poi/online/OnlineSearchContext; 
.const [209] = Utf8 de/audi/tghu/navi/app/command/poi/online/AbstractOnlineSearchCommand 
.const [210] = Utf8 logger 
.const [211] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [212] = Utf8 de/audi/atip/log/LogChannel 
.const [213] = Utf8 log 
.const [214] = Utf8 (ILjava/lang/String;)Z 
.const [215] = Utf8 de/audi/tghu/navi/app/command/poi/online/OnlinePoiCommandList 
.const [216] = Utf8 getOnlineSearch 
.const [217] = Utf8 ()Lorg/dsi/ifc/online/DSIPoiOnlineSearch; 
.const [218] = Utf8 de/audi/tghu/navi/app/command/poi/online/AbstractOnlineSearchCommand 
.const [219] = Utf8 init 
.const [220] = Utf8 (Lorg/dsi/ifc/online/DSIPoiOnlineSearch;)V 
.const [221] = Utf8 de/audi/atip/log/LogChannel 
.const [222] = Utf8 log 
.const [223] = Utf8 (ILjava/lang/String;JJ)Z 
.const [224] = Utf8 de/audi/tghu/navi/app/command/poi/online/AbstractOnlineSearchCommand 
.const [225] = Utf8 spellingSuggestion 
.const [226] = Utf8 Z 
.const [227] = Utf8 de/audi/tghu/navi/app/command/poi/online/AbstractOnlineSearchCommand 
.const [228] = Utf8 statusToErrorCode 
.const [229] = Utf8 (I)I 
.const [230] = Utf8 de/audi/atip/log/LogChannel 
.const [231] = Utf8 log 
.const [232] = Utf8 (ILjava/lang/String;Ljava/lang/Throwable;)Z 
.const [233] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [234] = Utf8 append 
.const [235] = Utf8 (Ljava/lang/String;)Lde/esolutions/fw/util/commons/Buffer; 
.const [236] = Utf8 org/dsi/ifc/online/PoiOnlineSearchValuelist 
.const [237] = Utf8 toString 
.const [238] = Utf8 ()Ljava/lang/String; 
.const [239] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [240] = Utf8 append 
.const [241] = Utf8 (I)Lde/esolutions/fw/util/commons/Buffer; 
.const [242] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [243] = Utf8 toString 
.const [244] = Utf8 ()Ljava/lang/String; 
.const [245] = Utf8 org/dsi/ifc/online/PoiOnlineSearchValuelist 
.const [246] = Utf8 sourceName 
.const [247] = Utf8 Ljava/lang/String; 
.const [248] = Utf8 org/dsi/ifc/online/PoiOnlineSearchValuelist 
.const [249] = Utf8 imageUrl 
.const [250] = Utf8 Ljava/lang/String; 
.const [251] = Utf8 org/dsi/ifc/online/PoiOnlineSearchValuelist 
.const [252] = Utf8 imageCheckSum 
.const [253] = Utf8 Ljava/lang/String; 
.const [254] = Utf8 org/dsi/ifc/online/PoiOnlineSearchValuelist 
.const [255] = Utf8 imageMapUrl 
.const [256] = Utf8 Ljava/lang/String; 
.const [257] = Utf8 org/dsi/ifc/online/PoiOnlineSearchValuelist 
.const [258] = Utf8 imageMapCheckSum 
.const [259] = Utf8 Ljava/lang/String; 
.const [260] = Utf8 org/dsi/ifc/online/PoiOnlineSearchValuelist 
.const [261] = Utf8 imageVoiceUrl 
.const [262] = Utf8 Ljava/lang/String; 
.const [263] = Utf8 org/dsi/ifc/online/PoiOnlineSearchValuelist 
.const [264] = Utf8 imageVoiceCheckSum 
.const [265] = Utf8 Ljava/lang/String; 
.const [266] = Utf8 de/audi/tghu/navi/app/poi/online/OnlineSearchContext 
.const [267] = Utf8 getResultList 
.const [268] = Utf8 ()Lde/audi/tghu/navi/app/poi/online/OnlinePOIResultList; 
.const [269] = Utf8 de/audi/tghu/navi/app/poi/online/OnlineSearchContext 
.const [270] = Utf8 updateResults 
.const [271] = Utf8 (ILorg/dsi/ifc/online/PoiOnlineSearchValuelist;IIZLde/audi/tghu/navi/app/poi/online/OnlinePOIResultList;)V 
.const [272] = Utf8 de/audi/tghu/navi/app/poi/online/OnlineSearchContext 
.const [273] = Utf8 setResultsLength 
.const [274] = Utf8 (I)V 
.const [275] = Utf8 de/audi/tghu/navi/app/command/poi/online/AbstractOnlineSearchCommand 
.const [276] = Utf8 getCommandList 
.const [277] = Utf8 ()Lde/audi/tghu/command/ICommandList; 
.const [278] = Utf8 de/audi/atip/log/LogChannel 
.const [279] = Utf8 log 
.const [280] = Utf8 (ILjava/lang/String;J)Z 
.const [281] = Utf8 de/audi/tghu/command/Command 
.const [282] = Utf8 <init> 
.const [283] = Utf8 (Lde/audi/atip/log/LogChannel;)V 
.const [284] = Utf8 de/audi/tghu/command/Command 
.const [285] = Utf8 setCommandList 
.const [286] = Utf8 (Lde/audi/tghu/command/ICommandList;)V 
.const [287] = Utf8 java/lang/ClassCastException 
.const [288] = Utf8 <init> 
.const [289] = Utf8 (Ljava/lang/String;)V 
.const [290] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [291] = Utf8 <init> 
.const [292] = Utf8 ()V 
.const [293] = Utf8 de/audi/tghu/navi/app/command/poi/online/SpellingSuggestionCommand 
.const [294] = Utf8 <init> 
.const [295] = Utf8 (Lde/audi/atip/log/LogChannel;Lde/audi/tghu/navi/app/poi/online/IOnlineSearchForm;)V 
.const [296] = Utf8 de/audi/tghu/navi/app/command/poi/online/AbstractOnlineSearchCommand 
.const [297] = Utf8 returnCode 
.const [298] = Utf8 I 
.const [299] = Utf8 de/audi/tghu/navi/app/command/poi/online/AbstractOnlineSearchCommand 
.const [300] = Utf8 form 
.const [301] = Utf8 Lde/audi/tghu/navi/app/poi/online/IOnlineSearchForm; 
.const [302] = Utf8 de/audi/tghu/navi/app/command/poi/online/AbstractOnlineSearchCommand 
.const [303] = Utf8 onlineSearchStatus 
.const [304] = Utf8 Lde/audi/tghu/navi/app/poi/online/OnlineSearchContext; 
.const [305] = Utf8 de/audi/tghu/navi/app/command/poi/online/AbstractOnlineSearchCommand 
.const [306] = Utf8 dsiOnlineSearch 
.const [307] = Utf8 Lorg/dsi/ifc/online/DSIPoiOnlineSearch; 
.const [308] = Utf8 de/audi/tghu/navi/app/command/poi/online/AbstractOnlineSearchCommand 
.const [309] = Utf8 spellingSuggestion 
.const [310] = Utf8 Z 
.const [311] = Utf8 de/audi/tghu/navi/app/poi/online/IOnlineSearchForm 
.const [312] = Utf8 indicateError 
.const [313] = Utf8 (ILjava/lang/String;)V 
.const [314] = Utf8 de/audi/tghu/navi/app/poi/online/IOnlineSearchForm 
.const [315] = Utf8 updateProvider 
.const [316] = Utf8 (ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V 
.const [317] = Utf8 de/audi/tghu/navi/app/poi/online/IOnlineSearchForm 
.const [318] = Utf8 updateResults 
.const [319] = Utf8 (ILorg/dsi/ifc/online/PoiOnlineSearchValuelist;IIZLde/audi/tghu/navi/app/poi/online/OnlinePOIResultList;)I 
.const [320] = Utf8 de/audi/tghu/command/ICommandList 
.const [321] = Utf8 commandFinishedWithPostCommand 
.const [322] = Utf8 (Lde/audi/tghu/command/Command;)V 
.const [323] = Utf8 de/audi/tghu/navi/app/poi/online/IOnlineSearchForm 
.const [324] = Utf8 setResultsComplete 
.const [325] = Utf8 ()V 
.const [326] = Utf8 de/audi/tghu/command/ICommandList 
.const [327] = Utf8 commandFinished 
.const [328] = Utf8 ()V 
.const [329] = Utf8 de/audi/tghu/navi/app/poi/online/IOnlineSearchForm 
.const [330] = Utf8 setResultLengthValue 
.const [331] = Utf8 (III)V 
.const [332] = Utf8 de/audi/tghu/navi/app/command/poi/online/AbstractOnlineSearchCommand 
.const [333] = Class [332] 
.const [334] = Utf8 de/audi/tghu/command/Command 
.const [335] = Class [334] 
.const [336] = Utf8 org/dsi/ifc/online/DSIPoiOnlineSearchListener 
.const [337] = Class [336] 
.const [338] = Utf8 dsiOnlineSearch 
.const [339] = Utf8 Lorg/dsi/ifc/online/DSIPoiOnlineSearch; 
.const [340] = Utf8 SEARCH_RADIUS_KM 
.const [341] = Utf8 I 
.const [342] = Utf8 ERRORCODE_UNDEFINED 
.const [343] = Utf8 I 
.const [344] = Utf8 ERRORCODE_NOSIGNAL 
.const [345] = Utf8 I 
.const [346] = Utf8 ERRORCODE_CONNECTIONFAILED 
.const [347] = Utf8 I 
.const [348] = Utf8 ERRORCODE_PROXYDOWN 
.const [349] = Utf8 I 
.const [350] = Utf8 ERRORCODE_THIRDPARTYDOWN 
.const [351] = Utf8 I 
.const [352] = Utf8 returnCode 
.const [353] = Utf8 I 
.const [354] = Utf8 spellingSuggestion 
.const [355] = Utf8 Z 
.const [356] = Utf8 form 
.const [357] = Utf8 Lde/audi/tghu/navi/app/poi/online/IOnlineSearchForm; 
.const [358] = Utf8 onlineSearchStatus 
.const [359] = Utf8 Lde/audi/tghu/navi/app/poi/online/OnlineSearchContext; 
.const [360] = Utf8 Code 
.const [361] = Utf8 <init> 
.const [362] = Utf8 (Lde/audi/atip/log/LogChannel;)V 
.const [363] = Utf8 <init> 
.const [364] = Utf8 (Lde/audi/atip/log/LogChannel;Lde/audi/tghu/navi/app/poi/online/IOnlineSearchForm;Lde/audi/tghu/navi/app/poi/online/OnlineSearchContext;)V 
.const [365] = Utf8 setCommandList 
.const [366] = Utf8 (Lde/audi/tghu/command/ICommandList;)V 
.const [367] = Utf8 init 
.const [368] = Utf8 (Lorg/dsi/ifc/online/DSIPoiOnlineSearch;)V 
.const [369] = Utf8 poiResult 
.const [370] = Utf8 (III)V 
.const [371] = Utf8 poiValueList 
.const [372] = Utf8 (IILorg/dsi/ifc/online/PoiOnlineSearchValuelist;II)V 
.const [373] = Utf8 statusToErrorCode 
.const [374] = Utf8 (I)I 
.const [375] = Utf8 poiSpellingSuggestion 
.const [376] = Utf8 (ILjava/lang/String;[Ljava/lang/String;)V 
.const [377] = Utf8 precheckDynamicPOICategoryResponse 
.const [378] = Utf8 (ILorg/dsi/ifc/online/OSRServiceState;)V 
.end class 
