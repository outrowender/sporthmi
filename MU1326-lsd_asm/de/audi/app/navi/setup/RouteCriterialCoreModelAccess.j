.version 50 0 
.class public super abstract [275] 
.super [277] 
.implements [279] 
.field protected final [280] [281] 

.method public [283] : [284] 
    .attribute [282] .code stack 2 locals 0 
L0:     aload_0 
L1:     invokespecial [47] 
L4:     aload_0 
L5:     aload_1 
L6:     putfield [48] 
L9:     return 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method public [285] : [286] 
    .attribute [282] .code stack 4 locals 0 
L0:     aload_0 
L1:     getfield [26] 
L4:     invokevirtual [27] 
L7:     ldc [2] 
L9:     ldc [3] 
L11:    aload_1 
L12:    invokevirtual [28] 
L15:    pop 
L16:    aload_0 
L17:    aload_1 
L18:    invokevirtual [29] 
L21:    return 
L22:    nop 
L23:    nop 
L24:    
    .end code 
.end method 

.method protected [287] : [288] 
    .attribute [282] .code stack 4 locals 0 
L0:     aload_0 
L1:     getfield [26] 
L4:     invokevirtual [27] 
L7:     ldc [2] 
L9:     ldc [4] 
L11:    aload_1 
L12:    invokevirtual [28] 
L15:    pop 
L16:    aload_0 
L17:    aload_1 
L18:    invokeinterface [49] 0 
L23:    invokevirtual [30] 
L26:    aload_0 
L27:    aload_1 
L28:    invokeinterface [50] 0 
L33:    iconst_1 
L34:    if_icmpne L41 
L37:    iconst_1 
L38:    goto L42 
L41:    iconst_0 
L42:    invokevirtual [31] 
L45:    aload_0 
L46:    aload_1 
L47:    invokeinterface [51] 0 
L52:    invokevirtual [32] 
L55:    aload_0 
L56:    aload_1 
L57:    invokeinterface [52] 0 
L62:    iconst_1 
L63:    if_icmpne L70 
L66:    iconst_1 
L67:    goto L71 
L70:    iconst_0 
L71:    invokevirtual [33] 
L74:    aload_0 
L75:    aload_1 
L76:    invokeinterface [53] 0 
L81:    iconst_1 
L82:    if_icmpne L89 
L85:    iconst_1 
L86:    goto L90 
L89:    iconst_0 
L90:    invokevirtual [34] 
L93:    aload_0 
L94:    aload_1 
L95:    invokeinterface [54] 0 
L100:   iconst_1 
L101:   if_icmpne L108 
L104:   iconst_1 
L105:   goto L109 
L108:   iconst_0 
L109:   invokevirtual [35] 
L112:   aload_0 
L113:   aload_1 
L114:   invokeinterface [55] 0 
L119:   invokevirtual [36] 
L122:   aload_0 
L123:   aload_1 
L124:   invokeinterface [56] 0 
L129:   invokevirtual [37] 
L132:   aload_0 
L133:   aload_1 
L134:   invokeinterface [57] 0 
L139:   invokevirtual [38] 
L142:   aload_0 
L143:   aload_1 
L144:   iconst_1 
L145:   invokeinterface [58] 0 
L150:   iconst_0 
L151:   aaload 
L152:   invokevirtual [39] 
L155:   aload_0 
L156:   aload_1 
L157:   invokeinterface [59] 0 
L162:   iconst_1 
L163:   if_icmpne L170 
L166:   iconst_1 
L167:   goto L171 
L170:   iconst_0 
L171:   invokevirtual [40] 
L174:   aload_0 
L175:   aload_1 
L176:   invokeinterface [60] 0 
L181:   iconst_1 
L182:   if_icmpne L189 
L185:   iconst_1 
L186:   goto L190 
L189:   iconst_0 
L190:   invokevirtual [41] 
L193:   return 
L194:   nop 
L195:   nop 
L196:   
    .end code 
.end method 

.method protected [289] : [290] 
    .attribute [282] .code stack 5 locals 2 
L0:     aload_1 
L1:     invokevirtual [42] 
L4:     istore_2 
L5:     iload_2 
L6:     tableswitch 0 
            L64 
            L99 
            L127 
            L127 
            L127 
            L109 
            L127 
            L104 
            L127 
            L64 
            L104 
            default : L127 

L64:    invokestatic [5] 
L67:    ifne L76 
L70:    invokestatic [6] 
L73:    ifeq L94 
L76:    aload_0 
L77:    getfield [26] 
L80:    invokevirtual [43] 
L83:    invokestatic [7] 
L86:    ifne L94 
L89:    iconst_5 
L90:    istore_3 
L91:    goto L145 
L94:    iconst_1 
L95:    istore_3 
L96:    goto L145 
L99:    iconst_2 
L100:   istore_3 
L101:   goto L145 
L104:   iconst_0 
L105:   istore_3 
L106:   goto L145 
L109:   aload_1 
L110:   invokevirtual [44] 
L113:   iconst_1 
L114:   if_icmpne L122 
L117:   iconst_3 
L118:   istore_3 
L119:   goto L145 
L122:   iconst_4 
L123:   istore_3 
L124:   goto L145 
L127:   aload_0 
L128:   getfield [26] 
L131:   invokevirtual [27] 
L134:   ldc [2] 
L136:   ldc [8] 
L138:   iload_2 
L139:   i2l 
L140:   invokevirtual [45] 
L143:   pop 
L144:   return 
L145:   aload_0 
L146:   getfield [26] 
L149:   ldc [9] 
L151:   invokevirtual [46] 
L154:   iload_3 
L155:   invokeinterface [61] 0 
L160:   return 
L161:   nop 
L162:   nop 
L163:   nop 
L164:   
    .end code 
.end method 

.method protected [291] : [292] 
    .attribute [282] .code stack 2 locals 1 
L0:     iconst_0 
L1:     istore_2 
L2:     iload_1 
L3:     iconst_1 
L4:     if_icmpne L12 
L7:     iconst_0 
L8:     istore_2 
L9:     goto L30 
L12:    iload_1 
L13:    iconst_2 
L14:    if_icmpne L22 
L17:    iconst_1 
L18:    istore_2 
L19:    goto L30 
L22:    iload_1 
L23:    bipush 7 
L25:    if_icmpne L30 
L28:    iconst_2 
L29:    istore_2 
L30:    aload_0 
L31:    getfield [26] 
L34:    ldc [10] 
L36:    invokevirtual [46] 
L39:    invokeinterface [62] 0 
L44:    iload_2 
L45:    if_icmpeq L63 
L48:    aload_0 
L49:    getfield [26] 
L52:    ldc [10] 
L54:    invokevirtual [46] 
L57:    iload_2 
L58:    invokeinterface [61] 0 
L63:    return 
L64:    
    .end code 
.end method 

.method protected [293] : [294] 
    .attribute [282] .code stack 2 locals 1 
L0:     iload_1 
L1:     ifeq L8 
L4:     iconst_0 
L5:     goto L9 
L8:     iconst_1 
L9:     istore_2 
L10:    aload_0 
L11:    getfield [26] 
L14:    ldc [11] 
L16:    invokevirtual [46] 
L19:    invokeinterface [62] 0 
L24:    iload_2 
L25:    if_icmpeq L43 
L28:    aload_0 
L29:    getfield [26] 
L32:    ldc [11] 
L34:    invokevirtual [46] 
L37:    iload_2 
L38:    invokeinterface [61] 0 
L43:    return 
L44:    
    .end code 
.end method 

.method protected [295] : [296] 
    .attribute [282] .code stack 2 locals 1 
L0:     iload_1 
L1:     ifeq L8 
L4:     iconst_0 
L5:     goto L9 
L8:     iconst_1 
L9:     istore_2 
L10:    aload_0 
L11:    getfield [26] 
L14:    ldc [12] 
L16:    invokevirtual [46] 
L19:    invokeinterface [62] 0 
L24:    iload_2 
L25:    if_icmpeq L43 
L28:    aload_0 
L29:    getfield [26] 
L32:    ldc [12] 
L34:    invokevirtual [46] 
L37:    iload_2 
L38:    invokeinterface [61] 0 
L43:    return 
L44:    
    .end code 
.end method 

.method protected [297] : [298] 
    .attribute [282] .code stack 2 locals 1 
L0:     iload_1 
L1:     ifeq L8 
L4:     iconst_0 
L5:     goto L9 
L8:     iconst_1 
L9:     istore_2 
L10:    aload_0 
L11:    getfield [26] 
L14:    ldc [13] 
L16:    invokevirtual [46] 
L19:    invokeinterface [62] 0 
L24:    iload_2 
L25:    if_icmpeq L43 
L28:    aload_0 
L29:    getfield [26] 
L32:    ldc [13] 
L34:    invokevirtual [46] 
L37:    iload_2 
L38:    invokeinterface [61] 0 
L43:    return 
L44:    
    .end code 
.end method 

.method protected [299] : [300] 
    .attribute [282] .code stack 2 locals 1 
L0:     iload_1 
L1:     ifeq L8 
L4:     iconst_0 
L5:     goto L9 
L8:     iconst_1 
L9:     istore_2 
L10:    aload_0 
L11:    getfield [26] 
L14:    ldc [14] 
L16:    invokevirtual [46] 
L19:    invokeinterface [62] 0 
L24:    iload_2 
L25:    if_icmpeq L43 
L28:    aload_0 
L29:    getfield [26] 
L32:    ldc [14] 
L34:    invokevirtual [46] 
L37:    iload_2 
L38:    invokeinterface [61] 0 
L43:    return 
L44:    
    .end code 
.end method 

.method protected [301] : [302] 
    .attribute [282] .code stack 2 locals 1 
L0:     iload_1 
L1:     ifeq L8 
L4:     iconst_0 
L5:     goto L9 
L8:     iconst_1 
L9:     istore_2 
L10:    aload_0 
L11:    getfield [26] 
L14:    ldc [15] 
L16:    invokevirtual [46] 
L19:    invokeinterface [62] 0 
L24:    iload_2 
L25:    if_icmpeq L43 
L28:    aload_0 
L29:    getfield [26] 
L32:    ldc [15] 
L34:    invokevirtual [46] 
L37:    iload_2 
L38:    invokeinterface [61] 0 
L43:    return 
L44:    
    .end code 
.end method 

.method protected [303] : [304] 
    .attribute [282] .code stack 2 locals 1 
L0:     iconst_0 
L1:     istore_2 
L2:     iload_1 
L3:     iconst_1 
L4:     if_icmpne L12 
L7:     iconst_1 
L8:     istore_2 
L9:     goto L29 
L12:    iload_1 
L13:    iconst_2 
L14:    if_icmpne L22 
L17:    iconst_2 
L18:    istore_2 
L19:    goto L29 
L22:    iload_1 
L23:    iconst_3 
L24:    if_icmpne L29 
L27:    iconst_0 
L28:    istore_2 
L29:    aload_0 
L30:    getfield [26] 
L33:    ldc [16] 
L35:    invokevirtual [46] 
L38:    invokeinterface [62] 0 
L43:    iload_2 
L44:    if_icmpeq L62 
L47:    aload_0 
L48:    getfield [26] 
L51:    ldc [16] 
L53:    invokevirtual [46] 
L56:    iload_2 
L57:    invokeinterface [61] 0 
L62:    return 
L63:    nop 
L64:    
    .end code 
.end method 

.method protected [305] : [306] 
    .attribute [282] .code stack 2 locals 0 
L0:     aload_0 
L1:     getfield [26] 
L4:     ldc [17] 
L6:     invokevirtual [46] 
L9:     invokeinterface [62] 0 
L14:    iload_1 
L15:    if_icmpeq L33 
L18:    aload_0 
L19:    getfield [26] 
L22:    ldc [17] 
L24:    invokevirtual [46] 
L27:    iload_1 
L28:    invokeinterface [61] 0 
L33:    return 
L34:    nop 
L35:    nop 
L36:    
    .end code 
.end method 

.method protected abstract [307] : [308] 
    .attribute [282] .code stack 0 locals 0 
L0:     
    .end code 
.end method 

.method protected abstract [309] : [310] 
    .attribute [282] .code stack 0 locals 0 
L0:     
    .end code 
.end method 

.method protected abstract [311] : [312] 
    .attribute [282] .code stack 0 locals 0 
L0:     
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Int -2137614336 
.const [3] = String [63] 
.const [4] = String [64] 
.const [5] = Method [65] [66] 
.const [6] = Method [67] [68] 
.const [7] = Method [69] [70] 
.const [8] = String [71] 
.const [9] = Int 1025312256 
.const [10] = Int 924648960 
.const [11] = Int 874317312 
.const [12] = Int 907871744 
.const [13] = Int 857540096 
.const [14] = Int 823985664 
.const [15] = Int 891094528 
.const [16] = Int 790431232 
.const [17] = Int 1042089472 
.const [18] = Class [72] 
.const [19] = Class [73] 
.const [20] = Class [74] 
.const [21] = Class [75] 
.const [22] = Class [76] 
.const [23] = Class [77] 
.const [24] = Class [78] 
.const [25] = Class [79] 
.const [26] = Field [80] [81] 
.const [27] = Method [82] [83] 
.const [28] = Method [84] [85] 
.const [29] = Method [86] [87] 
.const [30] = Method [88] [89] 
.const [31] = Method [90] [91] 
.const [32] = Method [92] [93] 
.const [33] = Method [94] [95] 
.const [34] = Method [96] [97] 
.const [35] = Method [98] [99] 
.const [36] = Method [100] [101] 
.const [37] = Method [102] [103] 
.const [38] = Method [104] [105] 
.const [39] = Method [106] [107] 
.const [40] = Method [108] [109] 
.const [41] = Method [110] [111] 
.const [42] = Method [112] [113] 
.const [43] = Method [114] [115] 
.const [44] = Method [116] [117] 
.const [45] = Method [118] [119] 
.const [46] = Method [120] [121] 
.const [47] = Method [122] [123] 
.const [48] = Field [124] [125] 
.const [49] = InterfaceMethod [126] [127] 
.const [50] = InterfaceMethod [128] [129] 
.const [51] = InterfaceMethod [130] [131] 
.const [52] = InterfaceMethod [132] [133] 
.const [53] = InterfaceMethod [134] [135] 
.const [54] = InterfaceMethod [136] [137] 
.const [55] = InterfaceMethod [138] [139] 
.const [56] = InterfaceMethod [140] [141] 
.const [57] = InterfaceMethod [142] [143] 
.const [58] = InterfaceMethod [144] [145] 
.const [59] = InterfaceMethod [146] [147] 
.const [60] = InterfaceMethod [148] [149] 
.const [61] = InterfaceMethod [150] [151] 
.const [62] = InterfaceMethod [152] [153] 
.const [63] = Utf8 'RouteCriteriaModelAccess#onStart() - %1' 
.const [64] = Utf8 'RouteCriteriaModelAccess#onUpdateCriteria() - %1' 
.const [65] = Class [154] 
.const [66] = NameAndType [155] [156] 
.const [67] = Class [157] 
.const [68] = NameAndType [158] [159] 
.const [69] = Class [160] 
.const [70] = NameAndType [161] [162] 
.const [71] = Utf8 'RouteCriterialCoreModelAccess#setRouteCalcType - unknown route calculation type: %1, ignoring call' 
.const [72] = Utf8 de/audi/app/navi/setup/RouteCriterialCoreModelAccess 
.const [73] = Utf8 java/lang/Object 
.const [74] = Utf8 de/audi/tghu/navi/app/NavigationEnv 
.const [75] = Utf8 de/audi/atip/log/LogChannel 
.const [76] = Utf8 de/audi/tghu/navi/app/setup/IRouteCriteria 
.const [77] = Utf8 org/dsi/ifc/navigation/RouteOptions 
.const [78] = Utf8 de/audi/tghu/navi/app/util/Util 
.const [79] = Utf8 de/audi/atip/hmi/modelaccess/ChoiceModelApp 
.const [80] = Class [163] 
.const [81] = NameAndType [164] [165] 
.const [82] = Class [166] 
.const [83] = NameAndType [167] [168] 
.const [84] = Class [169] 
.const [85] = NameAndType [170] [171] 
.const [86] = Class [172] 
.const [87] = NameAndType [173] [174] 
.const [88] = Class [175] 
.const [89] = NameAndType [176] [177] 
.const [90] = Class [178] 
.const [91] = NameAndType [179] [180] 
.const [92] = Class [181] 
.const [93] = NameAndType [182] [183] 
.const [94] = Class [184] 
.const [95] = NameAndType [185] [186] 
.const [96] = Class [187] 
.const [97] = NameAndType [188] [189] 
.const [98] = Class [190] 
.const [99] = NameAndType [191] [192] 
.const [100] = Class [193] 
.const [101] = NameAndType [194] [195] 
.const [102] = Class [196] 
.const [103] = NameAndType [197] [198] 
.const [104] = Class [199] 
.const [105] = NameAndType [200] [201] 
.const [106] = Class [202] 
.const [107] = NameAndType [203] [204] 
.const [108] = Class [205] 
.const [109] = NameAndType [206] [207] 
.const [110] = Class [208] 
.const [111] = NameAndType [209] [210] 
.const [112] = Class [211] 
.const [113] = NameAndType [212] [213] 
.const [114] = Class [214] 
.const [115] = NameAndType [215] [216] 
.const [116] = Class [217] 
.const [117] = NameAndType [218] [219] 
.const [118] = Class [220] 
.const [119] = NameAndType [221] [222] 
.const [120] = Class [223] 
.const [121] = NameAndType [224] [225] 
.const [122] = Class [226] 
.const [123] = NameAndType [227] [228] 
.const [124] = Class [229] 
.const [125] = NameAndType [230] [231] 
.const [126] = Class [232] 
.const [127] = NameAndType [233] [234] 
.const [128] = Class [235] 
.const [129] = NameAndType [236] [237] 
.const [130] = Class [238] 
.const [131] = NameAndType [239] [240] 
.const [132] = Class [241] 
.const [133] = NameAndType [242] [243] 
.const [134] = Class [244] 
.const [135] = NameAndType [245] [246] 
.const [136] = Class [247] 
.const [137] = NameAndType [248] [249] 
.const [138] = Class [250] 
.const [139] = NameAndType [251] [252] 
.const [140] = Class [253] 
.const [141] = NameAndType [254] [255] 
.const [142] = Class [256] 
.const [143] = NameAndType [257] [258] 
.const [144] = Class [259] 
.const [145] = NameAndType [260] [261] 
.const [146] = Class [262] 
.const [147] = NameAndType [263] [264] 
.const [148] = Class [265] 
.const [149] = NameAndType [266] [267] 
.const [150] = Class [268] 
.const [151] = NameAndType [269] [270] 
.const [152] = Class [271] 
.const [153] = NameAndType [272] [273] 
.const [154] = Utf8 de/audi/tghu/navi/app/util/Util 
.const [155] = Utf8 isHURegionJP 
.const [156] = Utf8 ()Z 
.const [157] = Utf8 de/audi/tghu/navi/app/util/Util 
.const [158] = Utf8 isHURegionKR 
.const [159] = Utf8 ()Z 
.const [160] = Utf8 de/audi/tghu/navi/app/util/Util 
.const [161] = Utf8 isPorsche 
.const [162] = Utf8 (Lde/audi/atip/base/IFrameworkAccess;)Z 
.const [163] = Utf8 de/audi/app/navi/setup/RouteCriterialCoreModelAccess 
.const [164] = Utf8 env 
.const [165] = Utf8 Lde/audi/tghu/navi/app/NavigationEnv; 
.const [166] = Utf8 de/audi/tghu/navi/app/NavigationEnv 
.const [167] = Utf8 getLogChannel 
.const [168] = Utf8 ()Lde/audi/atip/log/LogChannel; 
.const [169] = Utf8 de/audi/atip/log/LogChannel 
.const [170] = Utf8 log 
.const [171] = Utf8 (ILjava/lang/String;Ljava/lang/Object;)Z 
.const [172] = Utf8 de/audi/app/navi/setup/RouteCriterialCoreModelAccess 
.const [173] = Utf8 onUpdateCriteria 
.const [174] = Utf8 (Lde/audi/tghu/navi/app/setup/IRouteCriteria;)V 
.const [175] = Utf8 de/audi/app/navi/setup/RouteCriterialCoreModelAccess 
.const [176] = Utf8 setTrafficReroutingModel 
.const [177] = Utf8 (I)V 
.const [178] = Utf8 de/audi/app/navi/setup/RouteCriterialCoreModelAccess 
.const [179] = Utf8 setFreewaysModel 
.const [180] = Utf8 (Z)V 
.const [181] = Utf8 de/audi/app/navi/setup/RouteCriterialCoreModelAccess 
.const [182] = Utf8 setVignetteChoiceModel 
.const [183] = Utf8 (I)V 
.const [184] = Utf8 de/audi/app/navi/setup/RouteCriterialCoreModelAccess 
.const [185] = Utf8 setTollRoadsModel 
.const [186] = Utf8 (Z)V 
.const [187] = Utf8 de/audi/app/navi/setup/RouteCriterialCoreModelAccess 
.const [188] = Utf8 setFerriesModel 
.const [189] = Utf8 (Z)V 
.const [190] = Utf8 de/audi/app/navi/setup/RouteCriterialCoreModelAccess 
.const [191] = Utf8 setMotorrail 
.const [192] = Utf8 (Z)V 
.const [193] = Utf8 de/audi/app/navi/setup/RouteCriterialCoreModelAccess 
.const [194] = Utf8 setTimeRestricted 
.const [195] = Utf8 (I)V 
.const [196] = Utf8 de/audi/app/navi/setup/RouteCriterialCoreModelAccess 
.const [197] = Utf8 setSeasonalRestricted 
.const [198] = Utf8 (I)V 
.const [199] = Utf8 de/audi/app/navi/setup/RouteCriterialCoreModelAccess 
.const [200] = Utf8 setTrailerModel 
.const [201] = Utf8 (I)V 
.const [202] = Utf8 de/audi/app/navi/setup/RouteCriterialCoreModelAccess 
.const [203] = Utf8 setRouteCalcType 
.const [204] = Utf8 (Lorg/dsi/ifc/navigation/RouteOptions;)V 
.const [205] = Utf8 de/audi/app/navi/setup/RouteCriterialCoreModelAccess 
.const [206] = Utf8 setTunnelsModel 
.const [207] = Utf8 (Z)V 
.const [208] = Utf8 de/audi/app/navi/setup/RouteCriterialCoreModelAccess 
.const [209] = Utf8 setHovLanesModel 
.const [210] = Utf8 (Z)V 
.const [211] = Utf8 org/dsi/ifc/navigation/RouteOptions 
.const [212] = Utf8 getRouteType 
.const [213] = Utf8 ()I 
.const [214] = Utf8 de/audi/tghu/navi/app/NavigationEnv 
.const [215] = Utf8 getFramework 
.const [216] = Utf8 ()Lde/audi/atip/base/IFrameworkAccess; 
.const [217] = Utf8 org/dsi/ifc/navigation/RouteOptions 
.const [218] = Utf8 getTollroads 
.const [219] = Utf8 ()I 
.const [220] = Utf8 de/audi/atip/log/LogChannel 
.const [221] = Utf8 log 
.const [222] = Utf8 (ILjava/lang/String;J)Z 
.const [223] = Utf8 de/audi/tghu/navi/app/NavigationEnv 
.const [224] = Utf8 getChoiceModel 
.const [225] = Utf8 (I)Lde/audi/atip/hmi/modelaccess/ChoiceModelApp; 
.const [226] = Utf8 java/lang/Object 
.const [227] = Utf8 <init> 
.const [228] = Utf8 ()V 
.const [229] = Utf8 de/audi/app/navi/setup/RouteCriterialCoreModelAccess 
.const [230] = Utf8 env 
.const [231] = Utf8 Lde/audi/tghu/navi/app/NavigationEnv; 
.const [232] = Utf8 de/audi/tghu/navi/app/setup/IRouteCriteria 
.const [233] = Utf8 getTrafficRerouting 
.const [234] = Utf8 ()I 
.const [235] = Utf8 de/audi/tghu/navi/app/setup/IRouteCriteria 
.const [236] = Utf8 getFreeways 
.const [237] = Utf8 ()I 
.const [238] = Utf8 de/audi/tghu/navi/app/setup/IRouteCriteria 
.const [239] = Utf8 getVignettes 
.const [240] = Utf8 ()I 
.const [241] = Utf8 de/audi/tghu/navi/app/setup/IRouteCriteria 
.const [242] = Utf8 getTollRoads 
.const [243] = Utf8 ()I 
.const [244] = Utf8 de/audi/tghu/navi/app/setup/IRouteCriteria 
.const [245] = Utf8 getFerries 
.const [246] = Utf8 ()I 
.const [247] = Utf8 de/audi/tghu/navi/app/setup/IRouteCriteria 
.const [248] = Utf8 getMotorrail 
.const [249] = Utf8 ()I 
.const [250] = Utf8 de/audi/tghu/navi/app/setup/IRouteCriteria 
.const [251] = Utf8 getTimeRestrictedRoads 
.const [252] = Utf8 ()I 
.const [253] = Utf8 de/audi/tghu/navi/app/setup/IRouteCriteria 
.const [254] = Utf8 getSeasonRestricted 
.const [255] = Utf8 ()I 
.const [256] = Utf8 de/audi/tghu/navi/app/setup/IRouteCriteria 
.const [257] = Utf8 getTrailer 
.const [258] = Utf8 ()I 
.const [259] = Utf8 de/audi/tghu/navi/app/setup/IRouteCriteria 
.const [260] = Utf8 getRouteOptions 
.const [261] = Utf8 (Z)[Lorg/dsi/ifc/navigation/RouteOptions; 
.const [262] = Utf8 de/audi/tghu/navi/app/setup/IRouteCriteria 
.const [263] = Utf8 getTunnels 
.const [264] = Utf8 ()I 
.const [265] = Utf8 de/audi/tghu/navi/app/setup/IRouteCriteria 
.const [266] = Utf8 getHovLanes 
.const [267] = Utf8 ()I 
.const [268] = Utf8 de/audi/atip/hmi/modelaccess/ChoiceModelApp 
.const [269] = Utf8 setValue 
.const [270] = Utf8 (I)V 
.const [271] = Utf8 de/audi/atip/hmi/modelaccess/ChoiceModelApp 
.const [272] = Utf8 getValue 
.const [273] = Utf8 ()I 
.const [274] = Utf8 de/audi/app/navi/setup/RouteCriterialCoreModelAccess 
.const [275] = Class [274] 
.const [276] = Utf8 java/lang/Object 
.const [277] = Class [276] 
.const [278] = Utf8 de/audi/tghu/navi/app/setup/IRouteCriteriaModelAccess 
.const [279] = Class [278] 
.const [280] = Utf8 env 
.const [281] = Utf8 Lde/audi/tghu/navi/app/NavigationEnv; 
.const [282] = Utf8 Code 
.const [283] = Utf8 <init> 
.const [284] = Utf8 (Lde/audi/tghu/navi/app/NavigationEnv;)V 
.const [285] = Utf8 onStart 
.const [286] = Utf8 (Lde/audi/tghu/navi/app/setup/IRouteCriteria;)V 
.const [287] = Utf8 onUpdateCriteria 
.const [288] = Utf8 (Lde/audi/tghu/navi/app/setup/IRouteCriteria;)V 
.const [289] = Utf8 setRouteCalcType 
.const [290] = Utf8 (Lorg/dsi/ifc/navigation/RouteOptions;)V 
.const [291] = Utf8 setVignetteChoiceModel 
.const [292] = Utf8 (I)V 
.const [293] = Utf8 setTollRoadsModel 
.const [294] = Utf8 (Z)V 
.const [295] = Utf8 setTunnelsModel 
.const [296] = Utf8 (Z)V 
.const [297] = Utf8 setHovLanesModel 
.const [298] = Utf8 (Z)V 
.const [299] = Utf8 setFerriesModel 
.const [300] = Utf8 (Z)V 
.const [301] = Utf8 setMotorrail 
.const [302] = Utf8 (Z)V 
.const [303] = Utf8 setTimeRestricted 
.const [304] = Utf8 (I)V 
.const [305] = Utf8 setSeasonalRestricted 
.const [306] = Utf8 (I)V 
.const [307] = Utf8 setTrailerModel 
.const [308] = Utf8 (I)V 
.const [309] = Utf8 setFreewaysModel 
.const [310] = Utf8 (Z)V 
.const [311] = Utf8 setTrafficReroutingModel 
.const [312] = Utf8 (I)V 
.end class 
