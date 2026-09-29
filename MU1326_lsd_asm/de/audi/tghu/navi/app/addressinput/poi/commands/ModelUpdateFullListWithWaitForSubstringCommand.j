.version 50 0 
.class public super [345] 
.super [347] 
.field private static final [348] [349] 
.field private final [350] [351] 
.field private final [352] [353] 
.field private final [354] [355] 
.field private [356] [357] 
.field private final [358] [359] 

.method public [361] : [362] 
    .attribute [360] .code stack 2 locals 0 
L0:     aload_0 
L1:     invokespecial [57] 
L4:     aload_0 
L5:     iconst_0 
L6:     putfield [68] 
L9:     aload_0 
L10:    aload_1 
L11:    putfield [69] 
L14:    aload_0 
L15:    aload_2 
L16:    putfield [70] 
L19:    aload_0 
L20:    iload_3 
L21:    putfield [71] 
L24:    aload_0 
L25:    aload 4 
L27:    putfield [72] 
L30:    return 
L31:    nop 
L32:    
    .end code 
.end method 

.method public [363] : [364] 
    .attribute [360] .code stack 4 locals 0 
L0:     aload_0 
L1:     getfield [41] 
L4:     ldc [2] 
L6:     ldc [3] 
L8:     aload_0 
L9:     getfield [42] 
L12:    invokevirtual [43] 
L15:    pop 
L16:    aload_0 
L17:    invokespecial [58] 
L20:    ifne L37 
L23:    aload_0 
L24:    aload_0 
L25:    getfield [44] 
L28:    invokevirtual [45] 
L31:    invokespecial [59] 
L34:    ifeq L57 
L37:    aload_0 
L38:    getfield [41] 
L41:    ldc [2] 
L43:    ldc [4] 
L45:    aload_0 
L46:    getfield [42] 
L49:    invokevirtual [43] 
L52:    pop 
L53:    aload_0 
L54:    invokespecial [60] 
L57:    return 
L58:    nop 
L59:    nop 
L60:    
    .end code 
.end method 

.method private [365] : [366] 
    .attribute [360] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [46] 
L4:     invokevirtual [47] 
L7:     invokeinterface [73] 0 
L12:    ifeq L25 
L15:    invokestatic [5] 
L18:    ifeq L25 
L21:    iconst_1 
L22:    goto L26 
L25:    iconst_0 
L26:    areturn 
L27:    nop 
L28:    
    .end code 
.end method 

.method private [367] : [368] 
    .attribute [360] .code stack 2 locals 0 
L0:     aload_1 
L1:     invokestatic [6] 
L4:     ifeq L18 
L7:     aload_0 
L8:     getfield [39] 
L11:    aload_1 
L12:    invokestatic [7] 
L15:    ifne L25 
L18:    aload_1 
L19:    invokestatic [8] 
L22:    ifeq L29 
L25:    iconst_1 
L26:    goto L30 
L29:    iconst_0 
L30:    areturn 
L31:    nop 
L32:    
    .end code 
.end method 

.method public [369] : [370] 
    .attribute [360] .code stack 5 locals 0 
L0:     aload_0 
L1:     getfield [41] 
L4:     ldc [2] 
L6:     ldc [9] 
L8:     aload_0 
L9:     getfield [42] 
L12:    aload_1 
L13:    invokevirtual [48] 
L16:    aload_0 
L17:    getfield [44] 
L20:    aload_1 
L21:    invokevirtual [49] 
L24:    aload_0 
L25:    getfield [40] 
L28:    aload_1 
L29:    invokeinterface [74] 0 
L34:    aload_0 
L35:    aload_1 
L36:    invokespecial [59] 
L39:    ifeq L56 
L42:    aload_0 
L43:    invokespecial [58] 
L46:    ifne L56 
L49:    aload_0 
L50:    invokespecial [60] 
L53:    goto L72 
L56:    aload_0 
L57:    getfield [41] 
L60:    ldc [2] 
L62:    ldc [10] 
L64:    aload_0 
L65:    getfield [42] 
L68:    aload_1 
L69:    invokevirtual [48] 
L72:    return 
L73:    nop 
L74:    nop 
L75:    nop 
L76:    
    .end code 
.end method 

.method private synchronized [371] : [372] 
    .attribute [360] .code stack 8 locals 4 
L0:     aload_0 
L1:     getfield [41] 
L4:     ldc [2] 
L6:     ldc [11] 
L8:     aload_0 
L9:     getfield [42] 
L12:    aload_0 
L13:    getfield [36] 
L16:    invokestatic [12] 
L19:    invokevirtual [48] 
L22:    aload_0 
L23:    getfield [36] 
L26:    ifne L239 
L29:    aload_0 
L30:    getfield [41] 
L33:    ldc [13] 
L35:    ldc [14] 
L37:    aload_0 
L38:    getfield [42] 
L41:    aload_0 
L42:    getfield [39] 
L45:    i2l 
L46:    invokevirtual [50] 
L49:    pop 
L50:    aload_0 
L51:    iconst_1 
L52:    putfield [68] 
L55:    aload_0 
L56:    getfield [38] 
L59:    invokeinterface [75] 0 
L64:    astore_1 
L65:    aload_0 
L66:    aload_0 
L67:    getfield [39] 
L70:    aload_0 
L71:    getfield [44] 
L74:    invokevirtual [45] 
L77:    invokespecial [61] 
L80:    istore_2 
L81:    aload_0 
L82:    iload_2 
L83:    aload_0 
L84:    getfield [44] 
L87:    invokevirtual [45] 
L90:    invokespecial [62] 
L93:    istore_3 
L94:    aload_0 
L95:    getfield [41] 
L98:    ldc [13] 
L100:   ldc [15] 
L102:   aload_0 
L103:   getfield [42] 
L106:   iload_2 
L107:   i2l 
L108:   iload_3 
L109:   i2l 
L110:   invokevirtual [51] 
L113:   pop 
L114:   aload_1 
L115:   new [76] 
L118:   dup 
L119:   iload_2 
L120:   invokespecial [63] 
L123:   invokevirtual [52] 
L126:   pop 
L127:   iconst_0 
L128:   istore 4 
L130:   iload 4 
L132:   iload_3 
L133:   if_icmpge L216 
L136:   iload 4 
L138:   ifne L159 
L141:   aload_1 
L142:   new [77] 
L145:   dup 
L146:   iload 4 
L148:   iconst_1 
L149:   invokespecial [64] 
L152:   invokevirtual [52] 
L155:   pop 
L156:   goto L194 
L159:   aload_1 
L160:   new [78] 
L163:   dup 
L164:   aload_0 
L165:   new [79] 
L168:   dup 
L169:   invokespecial [65] 
L172:   aload_0 
L173:   getfield [42] 
L176:   invokevirtual [53] 
L179:   ldc [20] 
L181:   invokevirtual [53] 
L184:   invokevirtual [54] 
L187:   invokespecial [66] 
L190:   invokevirtual [52] 
L193:   pop 
L194:   aload_1 
L195:   new [80] 
L198:   dup 
L199:   aload_0 
L200:   getfield [37] 
L203:   invokespecial [67] 
L206:   invokevirtual [52] 
L209:   pop 
L210:   iinc 4 1 
L213:   goto L130 
L216:   aload_1 
L217:   new [76] 
L220:   dup 
L221:   iconst_m1 
L222:   invokespecial [63] 
L225:   invokevirtual [52] 
L228:   pop 
L229:   aload_0 
L230:   invokevirtual [55] 
L233:   aload_1 
L234:   invokeinterface [81] 0 
L239:   return 
L240:   
    .end code 
.end method 

.method private [373] : [374] 
    .attribute [360] .code stack 1 locals 0 
L0:     bipush 10 
L2:     areturn 
L3:     nop 
L4:     
    .end code 
.end method 

.method private [375] : [376] 
    .attribute [360] .code stack 2 locals 2 
L0:     aload_2 
L1:     invokevirtual [56] 
L4:     aload_0 
L5:     getfield [39] 
L8:     if_icmple L22 
L11:    aload_0 
L12:    getfield [39] 
L15:    bipush 10 
L17:    if_icmpge L22 
L20:    iconst_1 
L21:    areturn 
L22:    iconst_0 
L23:    istore_3 
L24:    aload_2 
L25:    invokevirtual [56] 
L28:    iload_1 
L29:    irem 
L30:    ifle L45 
L33:    aload_2 
L34:    invokevirtual [56] 
L37:    iload_1 
L38:    idiv 
L39:    iconst_1 
L40:    iadd 
L41:    istore_3 
L42:    goto L52 
L45:    aload_2 
L46:    invokevirtual [56] 
L49:    iload_1 
L50:    idiv 
L51:    istore_3 
L52:    aload_0 
L53:    getfield [39] 
L56:    iload_1 
L57:    if_icmple L77 
L60:    aload_0 
L61:    getfield [39] 
L64:    iload_1 
L65:    idiv 
L66:    istore 4 
L68:    iload_3 
L69:    iload 4 
L71:    if_icmple L77 
L74:    iload 4 
L76:    areturn 
L77:    iload_3 
L78:    areturn 
L79:    nop 
L80:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Int -2137614336 
.const [3] = String [82] 
.const [4] = String [83] 
.const [5] = Method [84] [85] 
.const [6] = Method [86] [87] 
.const [7] = Method [88] [89] 
.const [8] = Method [90] [91] 
.const [9] = String [92] 
.const [10] = String [93] 
.const [11] = String [94] 
.const [12] = Method [95] [96] 
.const [13] = Int 1078071040 
.const [14] = String [97] 
.const [15] = String [98] 
.const [16] = Class [99] 
.const [17] = Class [100] 
.const [18] = Class [101] 
.const [19] = Class [102] 
.const [20] = String [103] 
.const [21] = Class [104] 
.const [22] = Class [105] 
.const [23] = Class [106] 
.const [24] = Class [107] 
.const [25] = Class [108] 
.const [26] = Class [109] 
.const [27] = Class [110] 
.const [28] = Class [111] 
.const [29] = Class [112] 
.const [30] = Class [113] 
.const [31] = Class [114] 
.const [32] = Class [115] 
.const [33] = Class [116] 
.const [34] = Class [117] 
.const [35] = Class [118] 
.const [36] = Field [119] [120] 
.const [37] = Field [121] [122] 
.const [38] = Field [123] [124] 
.const [39] = Field [125] [126] 
.const [40] = Field [127] [128] 
.const [41] = Field [129] [130] 
.const [42] = Field [131] [132] 
.const [43] = Method [133] [134] 
.const [44] = Field [135] [136] 
.const [45] = Method [137] [138] 
.const [46] = Field [139] [140] 
.const [47] = Method [141] [142] 
.const [48] = Method [143] [144] 
.const [49] = Method [145] [146] 
.const [50] = Method [147] [148] 
.const [51] = Method [149] [150] 
.const [52] = Method [151] [152] 
.const [53] = Method [153] [154] 
.const [54] = Method [155] [156] 
.const [55] = Method [157] [158] 
.const [56] = Method [159] [160] 
.const [57] = Method [161] [162] 
.const [58] = Method [163] [164] 
.const [59] = Method [165] [166] 
.const [60] = Method [167] [168] 
.const [61] = Method [169] [170] 
.const [62] = Method [171] [172] 
.const [63] = Method [173] [174] 
.const [64] = Method [175] [176] 
.const [65] = Method [177] [178] 
.const [66] = Method [179] [180] 
.const [67] = Method [181] [182] 
.const [68] = Field [183] [184] 
.const [69] = Field [185] [186] 
.const [70] = Field [187] [188] 
.const [71] = Field [189] [190] 
.const [72] = Field [191] [192] 
.const [73] = InterfaceMethod [193] [194] 
.const [74] = InterfaceMethod [195] [196] 
.const [75] = InterfaceMethod [197] [198] 
.const [76] = Class [199] 
.const [77] = Class [200] 
.const [78] = Class [201] 
.const [79] = Class [202] 
.const [80] = Class [203] 
.const [81] = InterfaceMethod [204] [205] 
.const [82] = Utf8 '%1#execute' 
.const [83] = Utf8 '%1#execute - search looks good - starting to request items!' 
.const [84] = Class [206] 
.const [85] = NameAndType [207] [208] 
.const [86] = Class [209] 
.const [87] = NameAndType [210] [211] 
.const [88] = Class [212] 
.const [89] = NameAndType [213] [214] 
.const [90] = Class [215] 
.const [91] = NameAndType [216] [217] 
.const [92] = Utf8 '%1#updatePoiSubstringSearchStatus - valueListStatus=%2' 
.const [93] = Utf8 '%1#updatePoiSubstringSearchStatus - no result found yet, keep on waiting. poiSubstringSearchStatus=%2' 
.const [94] = Utf8 '%1#requestItems - alreadyQueriedResults=%2' 
.const [95] = Class [218] 
.const [96] = NameAndType [219] [220] 
.const [97] = Utf8 '%1#requestItems - minResults: %2' 
.const [98] = Utf8 '%1#requestItems - windowSize = %2, requestTimes = %3' 
.const [99] = Utf8 de/audi/tghu/navi/app/command/LIValueListWindowSizeCommand 
.const [100] = Utf8 de/audi/tghu/navi/app/addressinput/commands/LISPRequestValueListByListIndexCommand 
.const [101] = Utf8 de/audi/tghu/navi/app/addressinput/poi/commands/ModelUpdateFullListWithWaitForSubstringCommand$1 
.const [102] = Utf8 java/lang/StringBuffer 
.const [103] = Utf8 '#requestItems --> Enqueue further requests' 
.const [104] = Utf8 de/audi/tghu/navi/app/addressinput/poi/commands/NewModelUpdateResultScreenWithSpellerListCommand 
.const [105] = Utf8 de/audi/tghu/navi/app/addressinput/poi/commands/ModelUpdateFullListWithWaitForSubstringCommand 
.const [106] = Utf8 de/audi/tghu/navi/app/command/NavCommand 
.const [107] = Utf8 de/audi/atip/log/LogChannel 
.const [108] = Utf8 de/audi/tghu/navi/app/command/DSIResponseContainer 
.const [109] = Utf8 de/audi/tghu/navi/app/NavigationEnv 
.const [110] = Utf8 de/audi/tghu/navi/app/INavigationInputModeManager 
.const [111] = Utf8 de/audi/tghu/navi/app/util/Util 
.const [112] = Utf8 de/audi/tghu/navi/app/addressinput/poi/PoiUtil 
.const [113] = Utf8 de/audi/tghu/navi/app/addressinput/poi/IUpdatePoiSubstringSearchStatus 
.const [114] = Utf8 java/lang/Boolean 
.const [115] = Utf8 de/audi/tghu/command/ICommandListFactory 
.const [116] = Utf8 de/audi/tghu/command/CommandList 
.const [117] = Utf8 de/audi/tghu/command/ICommandList 
.const [118] = Utf8 org/dsi/ifc/navigation/ValueListStatus 
.const [119] = Class [221] 
.const [120] = NameAndType [222] [223] 
.const [121] = Class [224] 
.const [122] = NameAndType [225] [226] 
.const [123] = Class [227] 
.const [124] = NameAndType [228] [229] 
.const [125] = Class [230] 
.const [126] = NameAndType [231] [232] 
.const [127] = Class [233] 
.const [128] = NameAndType [234] [235] 
.const [129] = Class [236] 
.const [130] = NameAndType [237] [238] 
.const [131] = Class [239] 
.const [132] = NameAndType [240] [241] 
.const [133] = Class [242] 
.const [134] = NameAndType [243] [244] 
.const [135] = Class [245] 
.const [136] = NameAndType [246] [247] 
.const [137] = Class [248] 
.const [138] = NameAndType [249] [250] 
.const [139] = Class [251] 
.const [140] = NameAndType [252] [253] 
.const [141] = Class [254] 
.const [142] = NameAndType [255] [256] 
.const [143] = Class [257] 
.const [144] = NameAndType [258] [259] 
.const [145] = Class [260] 
.const [146] = NameAndType [261] [262] 
.const [147] = Class [263] 
.const [148] = NameAndType [264] [265] 
.const [149] = Class [266] 
.const [150] = NameAndType [267] [268] 
.const [151] = Class [269] 
.const [152] = NameAndType [270] [271] 
.const [153] = Class [272] 
.const [154] = NameAndType [273] [274] 
.const [155] = Class [275] 
.const [156] = NameAndType [276] [277] 
.const [157] = Class [278] 
.const [158] = NameAndType [279] [280] 
.const [159] = Class [281] 
.const [160] = NameAndType [282] [283] 
.const [161] = Class [284] 
.const [162] = NameAndType [285] [286] 
.const [163] = Class [287] 
.const [164] = NameAndType [288] [289] 
.const [165] = Class [290] 
.const [166] = NameAndType [291] [292] 
.const [167] = Class [293] 
.const [168] = NameAndType [294] [295] 
.const [169] = Class [296] 
.const [170] = NameAndType [297] [298] 
.const [171] = Class [299] 
.const [172] = NameAndType [300] [301] 
.const [173] = Class [302] 
.const [174] = NameAndType [303] [304] 
.const [175] = Class [305] 
.const [176] = NameAndType [306] [307] 
.const [177] = Class [308] 
.const [178] = NameAndType [309] [310] 
.const [179] = Class [311] 
.const [180] = NameAndType [312] [313] 
.const [181] = Class [314] 
.const [182] = NameAndType [315] [316] 
.const [183] = Class [317] 
.const [184] = NameAndType [318] [319] 
.const [185] = Class [320] 
.const [186] = NameAndType [321] [322] 
.const [187] = Class [323] 
.const [188] = NameAndType [324] [325] 
.const [189] = Class [326] 
.const [190] = NameAndType [327] [328] 
.const [191] = Class [329] 
.const [192] = NameAndType [330] [331] 
.const [193] = Class [332] 
.const [194] = NameAndType [333] [334] 
.const [195] = Class [335] 
.const [196] = NameAndType [336] [337] 
.const [197] = Class [338] 
.const [198] = NameAndType [339] [340] 
.const [199] = Utf8 de/audi/tghu/navi/app/command/LIValueListWindowSizeCommand 
.const [200] = Utf8 de/audi/tghu/navi/app/addressinput/commands/LISPRequestValueListByListIndexCommand 
.const [201] = Utf8 de/audi/tghu/navi/app/addressinput/poi/commands/ModelUpdateFullListWithWaitForSubstringCommand$1 
.const [202] = Utf8 java/lang/StringBuffer 
.const [203] = Utf8 de/audi/tghu/navi/app/addressinput/poi/commands/NewModelUpdateResultScreenWithSpellerListCommand 
.const [204] = Class [341] 
.const [205] = NameAndType [342] [343] 
.const [206] = Utf8 de/audi/tghu/navi/app/util/Util 
.const [207] = Utf8 isHURegionAsia 
.const [208] = Utf8 ()Z 
.const [209] = Utf8 de/audi/tghu/navi/app/addressinput/poi/PoiUtil 
.const [210] = Utf8 substringSearchIsRunning 
.const [211] = Utf8 (Lorg/dsi/ifc/navigation/ValueListStatus;)Z 
.const [212] = Utf8 de/audi/tghu/navi/app/addressinput/poi/PoiUtil 
.const [213] = Utf8 substringSearchHasItems 
.const [214] = Utf8 (ILorg/dsi/ifc/navigation/ValueListStatus;)Z 
.const [215] = Utf8 de/audi/tghu/navi/app/addressinput/poi/PoiUtil 
.const [216] = Utf8 substringSearchEnded 
.const [217] = Utf8 (Lorg/dsi/ifc/navigation/ValueListStatus;)Z 
.const [218] = Utf8 java/lang/Boolean 
.const [219] = Utf8 toString 
.const [220] = Utf8 (Z)Ljava/lang/String; 
.const [221] = Utf8 de/audi/tghu/navi/app/addressinput/poi/commands/ModelUpdateFullListWithWaitForSubstringCommand 
.const [222] = Utf8 alreadyQueriedResults 
.const [223] = Utf8 Z 
.const [224] = Utf8 de/audi/tghu/navi/app/addressinput/poi/commands/ModelUpdateFullListWithWaitForSubstringCommand 
.const [225] = Utf8 modelAccess 
.const [226] = Utf8 Lde/audi/tghu/navi/app/addressinput/poi/models/IPoiScreenUpdateResultList; 
.const [227] = Utf8 de/audi/tghu/navi/app/addressinput/poi/commands/ModelUpdateFullListWithWaitForSubstringCommand 
.const [228] = Utf8 commandListFactory 
.const [229] = Utf8 Lde/audi/tghu/command/ICommandListFactory; 
.const [230] = Utf8 de/audi/tghu/navi/app/addressinput/poi/commands/ModelUpdateFullListWithWaitForSubstringCommand 
.const [231] = Utf8 minimumResultsToGoOn 
.const [232] = Utf8 I 
.const [233] = Utf8 de/audi/tghu/navi/app/addressinput/poi/commands/ModelUpdateFullListWithWaitForSubstringCommand 
.const [234] = Utf8 poiManager 
.const [235] = Utf8 Lde/audi/tghu/navi/app/addressinput/poi/IUpdatePoiSubstringSearchStatus; 
.const [236] = Utf8 de/audi/tghu/navi/app/addressinput/poi/commands/ModelUpdateFullListWithWaitForSubstringCommand 
.const [237] = Utf8 logger 
.const [238] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [239] = Utf8 de/audi/tghu/navi/app/addressinput/poi/commands/ModelUpdateFullListWithWaitForSubstringCommand 
.const [240] = Utf8 CLASS_NAME 
.const [241] = Utf8 Ljava/lang/String; 
.const [242] = Utf8 de/audi/atip/log/LogChannel 
.const [243] = Utf8 log 
.const [244] = Utf8 (ILjava/lang/String;Ljava/lang/Object;)Z 
.const [245] = Utf8 de/audi/tghu/navi/app/addressinput/poi/commands/ModelUpdateFullListWithWaitForSubstringCommand 
.const [246] = Utf8 dsiResponseContainer 
.const [247] = Utf8 Lde/audi/tghu/navi/app/command/DSIResponseContainer; 
.const [248] = Utf8 de/audi/tghu/navi/app/command/DSIResponseContainer 
.const [249] = Utf8 getPoiSubstringSearchStatus 
.const [250] = Utf8 ()Lorg/dsi/ifc/navigation/ValueListStatus; 
.const [251] = Utf8 de/audi/tghu/navi/app/addressinput/poi/commands/ModelUpdateFullListWithWaitForSubstringCommand 
.const [252] = Utf8 env 
.const [253] = Utf8 Lde/audi/tghu/navi/app/NavigationEnv; 
.const [254] = Utf8 de/audi/tghu/navi/app/NavigationEnv 
.const [255] = Utf8 getInputModeManager 
.const [256] = Utf8 ()Lde/audi/tghu/navi/app/INavigationInputModeManager; 
.const [257] = Utf8 de/audi/atip/log/LogChannel 
.const [258] = Utf8 log 
.const [259] = Utf8 (ILjava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V 
.const [260] = Utf8 de/audi/tghu/navi/app/command/DSIResponseContainer 
.const [261] = Utf8 setPoiSubstringSearchStatus 
.const [262] = Utf8 (Lorg/dsi/ifc/navigation/ValueListStatus;)V 
.const [263] = Utf8 de/audi/atip/log/LogChannel 
.const [264] = Utf8 log 
.const [265] = Utf8 (ILjava/lang/String;Ljava/lang/Object;J)Z 
.const [266] = Utf8 de/audi/atip/log/LogChannel 
.const [267] = Utf8 log 
.const [268] = Utf8 (ILjava/lang/String;Ljava/lang/Object;JJ)Z 
.const [269] = Utf8 de/audi/tghu/command/CommandList 
.const [270] = Utf8 add 
.const [271] = Utf8 (Lde/audi/tghu/command/Command;)Lde/audi/tghu/command/ICommandList; 
.const [272] = Utf8 java/lang/StringBuffer 
.const [273] = Utf8 append 
.const [274] = Utf8 (Ljava/lang/String;)Ljava/lang/StringBuffer; 
.const [275] = Utf8 java/lang/StringBuffer 
.const [276] = Utf8 toString 
.const [277] = Utf8 ()Ljava/lang/String; 
.const [278] = Utf8 de/audi/tghu/navi/app/addressinput/poi/commands/ModelUpdateFullListWithWaitForSubstringCommand 
.const [279] = Utf8 getCommandList 
.const [280] = Utf8 ()Lde/audi/tghu/command/ICommandList; 
.const [281] = Utf8 org/dsi/ifc/navigation/ValueListStatus 
.const [282] = Utf8 getNumberOfAvailableItems 
.const [283] = Utf8 ()I 
.const [284] = Utf8 de/audi/tghu/navi/app/command/NavCommand 
.const [285] = Utf8 <init> 
.const [286] = Utf8 ()V 
.const [287] = Utf8 de/audi/tghu/navi/app/addressinput/poi/commands/ModelUpdateFullListWithWaitForSubstringCommand 
.const [288] = Utf8 sdsIsActiveAndRegionIsAsia 
.const [289] = Utf8 ()Z 
.const [290] = Utf8 de/audi/tghu/navi/app/addressinput/poi/commands/ModelUpdateFullListWithWaitForSubstringCommand 
.const [291] = Utf8 searchLooksGood 
.const [292] = Utf8 (Lorg/dsi/ifc/navigation/ValueListStatus;)Z 
.const [293] = Utf8 de/audi/tghu/navi/app/addressinput/poi/commands/ModelUpdateFullListWithWaitForSubstringCommand 
.const [294] = Utf8 requestItems 
.const [295] = Utf8 ()V 
.const [296] = Utf8 de/audi/tghu/navi/app/addressinput/poi/commands/ModelUpdateFullListWithWaitForSubstringCommand 
.const [297] = Utf8 calculateLiValueListWindowSize 
.const [298] = Utf8 (ILorg/dsi/ifc/navigation/ValueListStatus;)I 
.const [299] = Utf8 de/audi/tghu/navi/app/addressinput/poi/commands/ModelUpdateFullListWithWaitForSubstringCommand 
.const [300] = Utf8 calculateHowOftenRequestHasToBeDone 
.const [301] = Utf8 (ILorg/dsi/ifc/navigation/ValueListStatus;)I 
.const [302] = Utf8 de/audi/tghu/navi/app/command/LIValueListWindowSizeCommand 
.const [303] = Utf8 <init> 
.const [304] = Utf8 (I)V 
.const [305] = Utf8 de/audi/tghu/navi/app/addressinput/commands/LISPRequestValueListByListIndexCommand 
.const [306] = Utf8 <init> 
.const [307] = Utf8 (IZ)V 
.const [308] = Utf8 java/lang/StringBuffer 
.const [309] = Utf8 <init> 
.const [310] = Utf8 ()V 
.const [311] = Utf8 de/audi/tghu/navi/app/addressinput/poi/commands/ModelUpdateFullListWithWaitForSubstringCommand$1 
.const [312] = Utf8 <init> 
.const [313] = Utf8 (Lde/audi/tghu/navi/app/addressinput/poi/commands/ModelUpdateFullListWithWaitForSubstringCommand;Ljava/lang/String;)V 
.const [314] = Utf8 de/audi/tghu/navi/app/addressinput/poi/commands/NewModelUpdateResultScreenWithSpellerListCommand 
.const [315] = Utf8 <init> 
.const [316] = Utf8 (Lde/audi/tghu/navi/app/addressinput/poi/models/IPoiScreenUpdateResultList;)V 
.const [317] = Utf8 de/audi/tghu/navi/app/addressinput/poi/commands/ModelUpdateFullListWithWaitForSubstringCommand 
.const [318] = Utf8 alreadyQueriedResults 
.const [319] = Utf8 Z 
.const [320] = Utf8 de/audi/tghu/navi/app/addressinput/poi/commands/ModelUpdateFullListWithWaitForSubstringCommand 
.const [321] = Utf8 modelAccess 
.const [322] = Utf8 Lde/audi/tghu/navi/app/addressinput/poi/models/IPoiScreenUpdateResultList; 
.const [323] = Utf8 de/audi/tghu/navi/app/addressinput/poi/commands/ModelUpdateFullListWithWaitForSubstringCommand 
.const [324] = Utf8 commandListFactory 
.const [325] = Utf8 Lde/audi/tghu/command/ICommandListFactory; 
.const [326] = Utf8 de/audi/tghu/navi/app/addressinput/poi/commands/ModelUpdateFullListWithWaitForSubstringCommand 
.const [327] = Utf8 minimumResultsToGoOn 
.const [328] = Utf8 I 
.const [329] = Utf8 de/audi/tghu/navi/app/addressinput/poi/commands/ModelUpdateFullListWithWaitForSubstringCommand 
.const [330] = Utf8 poiManager 
.const [331] = Utf8 Lde/audi/tghu/navi/app/addressinput/poi/IUpdatePoiSubstringSearchStatus; 
.const [332] = Utf8 de/audi/tghu/navi/app/INavigationInputModeManager 
.const [333] = Utf8 isSdsActive 
.const [334] = Utf8 ()Z 
.const [335] = Utf8 de/audi/tghu/navi/app/addressinput/poi/IUpdatePoiSubstringSearchStatus 
.const [336] = Utf8 updatePoiSubstringSearchStatus 
.const [337] = Utf8 (Lorg/dsi/ifc/navigation/ValueListStatus;)V 
.const [338] = Utf8 de/audi/tghu/command/ICommandListFactory 
.const [339] = Utf8 createCommandList 
.const [340] = Utf8 ()Lde/audi/tghu/command/CommandList; 
.const [341] = Utf8 de/audi/tghu/command/ICommandList 
.const [342] = Utf8 commandFinishedWithPostSequence 
.const [343] = Utf8 (Lde/audi/tghu/command/CommandList;)V 
.const [344] = Utf8 de/audi/tghu/navi/app/addressinput/poi/commands/ModelUpdateFullListWithWaitForSubstringCommand 
.const [345] = Class [344] 
.const [346] = Utf8 de/audi/tghu/navi/app/command/NavCommand 
.const [347] = Class [346] 
.const [348] = Utf8 MAXIMUM_VALUE_LIST_SIZE 
.const [349] = Utf8 I 
.const [350] = Utf8 minimumResultsToGoOn 
.const [351] = Utf8 I 
.const [352] = Utf8 modelAccess 
.const [353] = Utf8 Lde/audi/tghu/navi/app/addressinput/poi/models/IPoiScreenUpdateResultList; 
.const [354] = Utf8 commandListFactory 
.const [355] = Utf8 Lde/audi/tghu/command/ICommandListFactory; 
.const [356] = Utf8 alreadyQueriedResults 
.const [357] = Utf8 Z 
.const [358] = Utf8 poiManager 
.const [359] = Utf8 Lde/audi/tghu/navi/app/addressinput/poi/IUpdatePoiSubstringSearchStatus; 
.const [360] = Utf8 Code 
.const [361] = Utf8 <init> 
.const [362] = Utf8 (Lde/audi/tghu/navi/app/addressinput/poi/models/IPoiScreenUpdateResultList;Lde/audi/tghu/command/ICommandListFactory;ILde/audi/tghu/navi/app/addressinput/poi/IUpdatePoiSubstringSearchStatus;)V 
.const [363] = Utf8 execute 
.const [364] = Utf8 ()V 
.const [365] = Utf8 sdsIsActiveAndRegionIsAsia 
.const [366] = Utf8 ()Z 
.const [367] = Utf8 searchLooksGood 
.const [368] = Utf8 (Lorg/dsi/ifc/navigation/ValueListStatus;)Z 
.const [369] = Utf8 updatePoiSubstringSearchStatus 
.const [370] = Utf8 (Lorg/dsi/ifc/navigation/ValueListStatus;)V 
.const [371] = Utf8 requestItems 
.const [372] = Utf8 ()V 
.const [373] = Utf8 calculateLiValueListWindowSize 
.const [374] = Utf8 (ILorg/dsi/ifc/navigation/ValueListStatus;)I 
.const [375] = Utf8 calculateHowOftenRequestHasToBeDone 
.const [376] = Utf8 (ILorg/dsi/ifc/navigation/ValueListStatus;)I 
.end class 
