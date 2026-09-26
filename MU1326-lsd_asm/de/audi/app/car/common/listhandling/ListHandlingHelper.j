.version 50 0 
.class public super [312] 
.super [314] 
.field private static [315] [316] 

.method public annotation [318] : [319] 
    .attribute [317] .code stack 1 locals 0 
L0:     aload_0 
L1:     invokespecial [58] 
L4:     return 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public static synchronized [320] : [321] 
    .attribute [317] .code stack 1 locals 0 
L0:     getstatic [2] 
L3:     ifnonnull L10 
L6:     aload_0 
L7:     putstatic [59] 
L10:    return 
L11:    nop 
L12:    
    .end code 
.end method 

.method public static synchronized [322] : [323] 
    .attribute [317] .code stack 6 locals 1 
L0:     aconst_null 
L1:     astore_2 
L2:     iload_1 
L3:     tableswitch 0 
            L48 
            L59 
            L70 
            L81 
            L92 
            L103 
            L114 
            L125 
            default : L136 

L48:    new [71] 
L51:    dup 
L52:    invokespecial [60] 
L55:    astore_2 
L56:    goto L136 
L59:    new [72] 
L62:    dup 
L63:    invokespecial [61] 
L66:    astore_2 
L67:    goto L136 
L70:    new [73] 
L73:    dup 
L74:    invokespecial [62] 
L77:    astore_2 
L78:    goto L136 
L81:    new [74] 
L84:    dup 
L85:    invokespecial [63] 
L88:    astore_2 
L89:    goto L136 
L92:    new [75] 
L95:    dup 
L96:    invokespecial [64] 
L99:    astore_2 
L100:   goto L136 
L103:   new [76] 
L106:   dup 
L107:   invokespecial [65] 
L110:   astore_2 
L111:   goto L136 
L114:   new [77] 
L117:   dup 
L118:   invokespecial [66] 
L121:   astore_2 
L122:   goto L136 
L125:   new [78] 
L128:   dup 
L129:   invokespecial [67] 
L132:   astore_2 
L133:   goto L136 
L136:   getstatic [2] 
L139:   ldc [11] 
L141:   ldc [12] 
L143:   aload_0 
L144:   iload_1 
L145:   i2l 
L146:   invokevirtual [40] 
L149:   pop 
L150:   aload_0 
L151:   aload_2 
L152:   invokestatic [13] 
L155:   areturn 
L156:   
    .end code 
.end method 

.method public static synchronized [324] : [325] 
    .attribute [317] .code stack 5 locals 7 
L0:     aload_1 
L1:     invokespecial [68] 
L4:     astore_2 
L5:     aload_0 
L6:     invokespecial [68] 
L9:     astore_3 
L10:    aload_3 
L11:    invokevirtual [41] 
L14:    astore 4 
L16:    iconst_0 
L17:    istore 5 
L19:    iload 5 
L21:    aload 4 
L23:    arraylength 
L24:    if_icmpge L127 
L27:    aload 4 
L29:    iload 5 
L31:    aaload 
L32:    invokevirtual [42] 
L35:    astore 6 
        .catch [15] from L37 to L81 using L84 
        .catch [16] from L37 to L81 using L94 
        .catch [17] from L37 to L81 using L104 
        .catch [18] from L37 to L81 using L114 
L37:    aload_3 
L38:    aload 4 
L40:    iload 5 
L42:    aaload 
L43:    invokevirtual [42] 
L46:    invokevirtual [43] 
L49:    aload_0 
L50:    invokevirtual [44] 
L53:    astore 7 
L55:    getstatic [2] 
L58:    ldc [11] 
L60:    ldc [14] 
L62:    aload 6 
L64:    aload 7 
L66:    invokevirtual [45] 
L69:    aload_2 
L70:    aload 6 
L72:    invokevirtual [43] 
L75:    aload_1 
L76:    aload 7 
L78:    invokevirtual [46] 
L81:    goto L121 
L84:    astore 8 
L86:    aload 8 
L88:    invokevirtual [47] 
L91:    goto L121 
L94:    astore 8 
L96:    aload 8 
L98:    invokevirtual [48] 
L101:   goto L121 
L104:   astore 8 
L106:   aload 8 
L108:   invokevirtual [49] 
L111:   goto L121 
L114:   astore 8 
L116:   aload 8 
L118:   invokevirtual [50] 
L121:   iinc 5 1 
L124:   goto L19 
L127:   aload_1 
L128:   areturn 
L129:   nop 
L130:   nop 
L131:   nop 
L132:   
    .end code 
.end method 

.method public static synchronized [326] : [327] 
    .attribute [317] .code stack 4 locals 0 
L0:     getstatic [2] 
L3:     ldc [11] 
L5:     ldc [19] 
L7:     aload_0 
L8:     invokevirtual [51] 
L11:    pop 
L12:    aload_1 
L13:    ifnonnull L24 
L16:    new [79] 
L19:    dup 
L20:    invokespecial [69] 
L23:    astore_1 
L24:    aload_0 
L25:    aload_1 
L26:    invokestatic [13] 
L29:    checkcast [20] 
L32:    areturn 
L33:    nop 
L34:    nop 
L35:    nop 
L36:    
    .end code 
.end method 

.method public static synchronized [328] : [329] 
    .attribute [317] .code stack 6 locals 4 
L0:     aload_0 
L1:     arraylength 
L2:     anewarray [20] 
L5:     astore_2 
L6:     iconst_0 
L7:     istore_3 
L8:     iload_3 
L9:     aload_0 
L10:    arraylength 
L11:    if_icmpge L160 
L14:    iconst_m1 
L15:    istore 4 
L17:    aload_0 
L18:    iload_3 
L19:    aaload 
L20:    instanceof [8] 
L23:    ifeq L40 
L26:    aload_0 
L27:    iload_3 
L28:    aaload 
L29:    checkcast [8] 
L32:    invokevirtual [52] 
L35:    istore 4 
L37:    goto L109 
L40:    aload_0 
L41:    iload_3 
L42:    aaload 
L43:    instanceof [9] 
L46:    ifeq L63 
L49:    aload_0 
L50:    iload_3 
L51:    aaload 
L52:    checkcast [9] 
L55:    invokevirtual [53] 
L58:    istore 4 
L60:    goto L109 
L63:    ldc [21] 
L65:    aload_0 
L66:    iload_3 
L67:    aaload 
L68:    invokestatic [22] 
L71:    astore 5 
L73:    aload 5 
L75:    ifnull L91 
L78:    aload 5 
L80:    checkcast [23] 
L83:    invokevirtual [54] 
L86:    istore 4 
L88:    goto L109 
L91:    getstatic [2] 
L94:    sipush 10000 
L97:    ldc [24] 
L99:    iload_3 
L100:   invokestatic [25] 
L103:   aload_0 
L104:   iload_3 
L105:   aaload 
L106:   invokevirtual [45] 
L109:   iload 4 
L111:   aload_1 
L112:   invokestatic [26] 
L115:   ifne L136 
L118:   aload_2 
L119:   iload_3 
L120:   aload_0 
L121:   iload_3 
L122:   aaload 
L123:   aload_1 
L124:   iload 4 
L126:   invokevirtual [55] 
L129:   invokestatic [27] 
L132:   aastore 
L133:   goto L154 
L136:   getstatic [2] 
L139:   sipush 10000 
L142:   ldc [28] 
L144:   iload_3 
L145:   invokestatic [25] 
L148:   invokevirtual [51] 
L151:   pop 
L152:   aconst_null 
L153:   areturn 
L154:   iinc 3 1 
L157:   goto L8 
L160:   aload_2 
L161:   areturn 
L162:   nop 
L163:   nop 
L164:   
    .end code 
.end method 

.method private static [330] : [331] 
    .attribute [317] .code stack 2 locals 0 
L0:     iload_0 
L1:     aload_1 
L2:     invokevirtual [56] 
L5:     if_icmpge L12 
L8:     iload_0 
L9:     ifge L16 
L12:    iconst_1 
L13:    goto L17 
L16:    iconst_0 
L17:    areturn 
L18:    nop 
L19:    nop 
L20:    
    .end code 
.end method 

.method public static synchronized [332] : [333] 
    .attribute [317] .code stack 5 locals 2 
L0:     getstatic [2] 
L3:     ldc [11] 
L5:     ldc [29] 
L7:     iload_1 
L8:     i2l 
L9:     invokevirtual [57] 
L12:    pop 
L13:    aload_0 
L14:    arraylength 
L15:    anewarray [30] 
L18:    astore_2 
L19:    iconst_0 
L20:    istore_3 
L21:    iload_3 
L22:    aload_0 
L23:    arraylength 
L24:    if_icmpge L43 
L27:    aload_2 
L28:    iload_3 
L29:    aload_0 
L30:    iload_3 
L31:    aaload 
L32:    iload_1 
L33:    invokestatic [31] 
L36:    aastore 
L37:    iinc 3 1 
L40:    goto L21 
L43:    aload_2 
L44:    areturn 
L45:    nop 
L46:    nop 
L47:    nop 
L48:    
    .end code 
.end method 

.method public static synchronized [334] : [335] 
    .attribute [317] .code stack 6 locals 1 
L0:     new [80] 
L3:     dup 
L4:     invokespecial [70] 
L7:     astore_2 
L8:     getstatic [2] 
L11:    ldc [11] 
L13:    ldc [32] 
L15:    aload_0 
L16:    iload_1 
L17:    i2l 
L18:    invokevirtual [40] 
L21:    pop 
L22:    aload_0 
L23:    aload_2 
L24:    invokestatic [13] 
L27:    checkcast [30] 
L30:    areturn 
L31:    nop 
L32:    
    .end code 
.end method 

.method private static [336] : [337] 
    .attribute [317] .code stack 2 locals 3 
L0:     aload_1 
L1:     invokespecial [68] 
L4:     astore_2 
L5:     aconst_null 
L6:     astore_3 
        .catch [16] from L7 to L17 using L20 
        .catch [18] from L7 to L17 using L30 
        .catch [15] from L7 to L17 using L40 
        .catch [17] from L7 to L17 using L50 
L7:     aload_2 
L8:     aload_0 
L9:     invokevirtual [43] 
L12:    aload_1 
L13:    invokevirtual [44] 
L16:    astore_3 
L17:    goto L57 
L20:    astore 4 
L22:    aload 4 
L24:    invokevirtual [48] 
L27:    goto L57 
L30:    astore 4 
L32:    aload 4 
L34:    invokevirtual [50] 
L37:    goto L57 
L40:    astore 4 
L42:    aload 4 
L44:    invokevirtual [47] 
L47:    goto L57 
L50:    astore 4 
L52:    aload 4 
L54:    invokevirtual [49] 
L57:    aload_3 
L58:    areturn 
L59:    nop 
L60:    
    .end code 
.end method 

.method static [338] : [339] 
    .attribute [317] .code stack 1 locals 0 
L0:     aconst_null 
L1:     putstatic [59] 
L4:     return 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Field [81] [82] 
.const [3] = Class [83] 
.const [4] = Class [84] 
.const [5] = Class [85] 
.const [6] = Class [86] 
.const [7] = Class [87] 
.const [8] = Class [88] 
.const [9] = Class [89] 
.const [10] = Class [90] 
.const [11] = Int 1078071040 
.const [12] = String [91] 
.const [13] = Method [92] [93] 
.const [14] = String [94] 
.const [15] = Class [95] 
.const [16] = Class [96] 
.const [17] = Class [97] 
.const [18] = Class [98] 
.const [19] = String [99] 
.const [20] = Class [100] 
.const [21] = String [101] 
.const [22] = Method [102] [103] 
.const [23] = Class [104] 
.const [24] = String [105] 
.const [25] = Method [106] [107] 
.const [26] = Method [108] [109] 
.const [27] = Method [110] [111] 
.const [28] = String [112] 
.const [29] = String [113] 
.const [30] = Class [114] 
.const [31] = Method [115] [116] 
.const [32] = String [117] 
.const [33] = Class [118] 
.const [34] = Class [119] 
.const [35] = Class [120] 
.const [36] = Class [121] 
.const [37] = Class [122] 
.const [38] = Class [123] 
.const [39] = Class [124] 
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
.const [59] = Field [163] [164] 
.const [60] = Method [165] [166] 
.const [61] = Method [167] [168] 
.const [62] = Method [169] [170] 
.const [63] = Method [171] [172] 
.const [64] = Method [173] [174] 
.const [65] = Method [175] [176] 
.const [66] = Method [177] [178] 
.const [67] = Method [179] [180] 
.const [68] = Method [181] [182] 
.const [69] = Method [183] [184] 
.const [70] = Method [185] [186] 
.const [71] = Class [187] 
.const [72] = Class [188] 
.const [73] = Class [189] 
.const [74] = Class [190] 
.const [75] = Class [191] 
.const [76] = Class [192] 
.const [77] = Class [193] 
.const [78] = Class [194] 
.const [79] = Class [195] 
.const [80] = Class [196] 
.const [81] = Class [197] 
.const [82] = NameAndType [198] [199] 
.const [83] = Utf8 org/dsi/ifc/carhybrid/BatteryControlProfileRA0 
.const [84] = Utf8 org/dsi/ifc/carhybrid/BatteryControlProfileRA1 
.const [85] = Utf8 org/dsi/ifc/carhybrid/BatteryControlProfileRA2 
.const [86] = Utf8 org/dsi/ifc/carhybrid/BatteryControlProfileRA3 
.const [87] = Utf8 org/dsi/ifc/carhybrid/BatteryControlProfileRA4 
.const [88] = Utf8 org/dsi/ifc/carhybrid/BatteryControlProfileRA5 
.const [89] = Utf8 org/dsi/ifc/carhybrid/BatteryControlProfileRA6 
.const [90] = Utf8 org/dsi/ifc/carhybrid/BatteryControlProfileRA7 
.const [91] = Utf8 'copyFromBatteryControlProfileRAx with params source=%1, recordAddress=%2 calls cloneTo()' 
.const [92] = Class [200] 
.const [93] = NameAndType [201] [202] 
.const [94] = Utf8 "set target field '%1' to value %2" 
.const [95] = Utf8 java/lang/IllegalArgumentException 
.const [96] = Utf8 java/lang/SecurityException 
.const [97] = Utf8 java/lang/IllegalAccessException 
.const [98] = Utf8 java/lang/NoSuchFieldException 
.const [99] = Utf8 'copyToBatteryControlProfileRAx with params source=%1 calls cloneTo()' 
.const [100] = Utf8 de/audi/app/car/common/listhandling/BatteryControlProfileRAx 
.const [101] = Utf8 pos 
.const [102] = Class [203] 
.const [103] = NameAndType [204] [205] 
.const [104] = Utf8 java/lang/Integer 
.const [105] = Utf8 "Something is REALLY, REALLY WRONG. sourceArray[%1]=%2 has no field 'pos' " 
.const [106] = Class [206] 
.const [107] = NameAndType [207] [208] 
.const [108] = Class [209] 
.const [109] = NameAndType [210] [211] 
.const [110] = Class [212] 
.const [111] = NameAndType [213] [214] 
.const [112] = Utf8 "profListArray[%1] has no index 'pos'" 
.const [113] = Utf8 'copyToBatteryControlPowerProviderArray: sourceArray=%1, sourceRecordAddress=%2' 
.const [114] = Utf8 de/audi/app/car/common/listhandling/BatteryControlPowerProviderRAx 
.const [115] = Class [215] 
.const [116] = NameAndType [216] [217] 
.const [117] = Utf8 'copyToBatteryControlPowerProviderRAx with params source=%1, recordAddress=%2 calls cloneTo()' 
.const [118] = Utf8 de/audi/app/car/common/listhandling/ListHandlingHelper 
.const [119] = Utf8 java/lang/Object 
.const [120] = Utf8 de/audi/atip/log/LogChannel 
.const [121] = Utf8 java/lang/Class 
.const [122] = Utf8 java/lang/reflect/Field 
.const [123] = Utf8 java/lang/String 
.const [124] = Utf8 de/audi/app/car/common/listhandling/SyncedBCProfileRAxArray 
.const [125] = Class [218] 
.const [126] = NameAndType [219] [220] 
.const [127] = Class [221] 
.const [128] = NameAndType [222] [223] 
.const [129] = Class [224] 
.const [130] = NameAndType [225] [226] 
.const [131] = Class [227] 
.const [132] = NameAndType [228] [229] 
.const [133] = Class [230] 
.const [134] = NameAndType [231] [232] 
.const [135] = Class [233] 
.const [136] = NameAndType [234] [235] 
.const [137] = Class [236] 
.const [138] = NameAndType [237] [238] 
.const [139] = Class [239] 
.const [140] = NameAndType [240] [241] 
.const [141] = Class [242] 
.const [142] = NameAndType [243] [244] 
.const [143] = Class [245] 
.const [144] = NameAndType [246] [247] 
.const [145] = Class [248] 
.const [146] = NameAndType [249] [250] 
.const [147] = Class [251] 
.const [148] = NameAndType [252] [253] 
.const [149] = Class [254] 
.const [150] = NameAndType [255] [256] 
.const [151] = Class [257] 
.const [152] = NameAndType [258] [259] 
.const [153] = Class [260] 
.const [154] = NameAndType [261] [262] 
.const [155] = Class [263] 
.const [156] = NameAndType [264] [265] 
.const [157] = Class [266] 
.const [158] = NameAndType [267] [268] 
.const [159] = Class [269] 
.const [160] = NameAndType [270] [271] 
.const [161] = Class [272] 
.const [162] = NameAndType [273] [274] 
.const [163] = Class [275] 
.const [164] = NameAndType [276] [277] 
.const [165] = Class [278] 
.const [166] = NameAndType [279] [280] 
.const [167] = Class [281] 
.const [168] = NameAndType [282] [283] 
.const [169] = Class [284] 
.const [170] = NameAndType [285] [286] 
.const [171] = Class [287] 
.const [172] = NameAndType [288] [289] 
.const [173] = Class [290] 
.const [174] = NameAndType [291] [292] 
.const [175] = Class [293] 
.const [176] = NameAndType [294] [295] 
.const [177] = Class [296] 
.const [178] = NameAndType [297] [298] 
.const [179] = Class [299] 
.const [180] = NameAndType [300] [301] 
.const [181] = Class [302] 
.const [182] = NameAndType [303] [304] 
.const [183] = Class [305] 
.const [184] = NameAndType [306] [307] 
.const [185] = Class [308] 
.const [186] = NameAndType [309] [310] 
.const [187] = Utf8 org/dsi/ifc/carhybrid/BatteryControlProfileRA0 
.const [188] = Utf8 org/dsi/ifc/carhybrid/BatteryControlProfileRA1 
.const [189] = Utf8 org/dsi/ifc/carhybrid/BatteryControlProfileRA2 
.const [190] = Utf8 org/dsi/ifc/carhybrid/BatteryControlProfileRA3 
.const [191] = Utf8 org/dsi/ifc/carhybrid/BatteryControlProfileRA4 
.const [192] = Utf8 org/dsi/ifc/carhybrid/BatteryControlProfileRA5 
.const [193] = Utf8 org/dsi/ifc/carhybrid/BatteryControlProfileRA6 
.const [194] = Utf8 org/dsi/ifc/carhybrid/BatteryControlProfileRA7 
.const [195] = Utf8 de/audi/app/car/common/listhandling/BatteryControlProfileRAx 
.const [196] = Utf8 de/audi/app/car/common/listhandling/BatteryControlPowerProviderRAx 
.const [197] = Utf8 de/audi/app/car/common/listhandling/ListHandlingHelper 
.const [198] = Utf8 logChannel 
.const [199] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [200] = Utf8 de/audi/app/car/common/listhandling/ListHandlingHelper 
.const [201] = Utf8 cloneTo 
.const [202] = Utf8 (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object; 
.const [203] = Utf8 de/audi/app/car/common/listhandling/ListHandlingHelper 
.const [204] = Utf8 getField 
.const [205] = Utf8 (Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object; 
.const [206] = Utf8 java/lang/String 
.const [207] = Utf8 valueOf 
.const [208] = Utf8 (I)Ljava/lang/String; 
.const [209] = Utf8 de/audi/app/car/common/listhandling/ListHandlingHelper 
.const [210] = Utf8 isIllegalIndex 
.const [211] = Utf8 (ILde/audi/app/car/common/listhandling/SyncedBCProfileRAxArray;)Z 
.const [212] = Utf8 de/audi/app/car/common/listhandling/ListHandlingHelper 
.const [213] = Utf8 copyToBatteryControlProfileRAx 
.const [214] = Utf8 (Ljava/lang/Object;Lde/audi/app/car/common/listhandling/BatteryControlProfileRAx;)Lde/audi/app/car/common/listhandling/BatteryControlProfileRAx; 
.const [215] = Utf8 de/audi/app/car/common/listhandling/ListHandlingHelper 
.const [216] = Utf8 copyToBatteryControlPowerProviderRAx 
.const [217] = Utf8 (Ljava/lang/Object;I)Lde/audi/app/car/common/listhandling/BatteryControlPowerProviderRAx; 
.const [218] = Utf8 de/audi/atip/log/LogChannel 
.const [219] = Utf8 log 
.const [220] = Utf8 (ILjava/lang/String;Ljava/lang/Object;J)Z 
.const [221] = Utf8 java/lang/Class 
.const [222] = Utf8 getDeclaredFields 
.const [223] = Utf8 ()[Ljava/lang/reflect/Field; 
.const [224] = Utf8 java/lang/reflect/Field 
.const [225] = Utf8 getName 
.const [226] = Utf8 ()Ljava/lang/String; 
.const [227] = Utf8 java/lang/Class 
.const [228] = Utf8 getField 
.const [229] = Utf8 (Ljava/lang/String;)Ljava/lang/reflect/Field; 
.const [230] = Utf8 java/lang/reflect/Field 
.const [231] = Utf8 get 
.const [232] = Utf8 (Ljava/lang/Object;)Ljava/lang/Object; 
.const [233] = Utf8 de/audi/atip/log/LogChannel 
.const [234] = Utf8 log 
.const [235] = Utf8 (ILjava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V 
.const [236] = Utf8 java/lang/reflect/Field 
.const [237] = Utf8 set 
.const [238] = Utf8 (Ljava/lang/Object;Ljava/lang/Object;)V 
.const [239] = Utf8 java/lang/IllegalArgumentException 
.const [240] = Utf8 printStackTrace 
.const [241] = Utf8 ()V 
.const [242] = Utf8 java/lang/SecurityException 
.const [243] = Utf8 printStackTrace 
.const [244] = Utf8 ()V 
.const [245] = Utf8 java/lang/IllegalAccessException 
.const [246] = Utf8 printStackTrace 
.const [247] = Utf8 ()V 
.const [248] = Utf8 java/lang/NoSuchFieldException 
.const [249] = Utf8 printStackTrace 
.const [250] = Utf8 ()V 
.const [251] = Utf8 de/audi/atip/log/LogChannel 
.const [252] = Utf8 log 
.const [253] = Utf8 (ILjava/lang/String;Ljava/lang/Object;)Z 
.const [254] = Utf8 org/dsi/ifc/carhybrid/BatteryControlProfileRA5 
.const [255] = Utf8 getPos 
.const [256] = Utf8 ()I 
.const [257] = Utf8 org/dsi/ifc/carhybrid/BatteryControlProfileRA6 
.const [258] = Utf8 getPos 
.const [259] = Utf8 ()I 
.const [260] = Utf8 java/lang/Integer 
.const [261] = Utf8 intValue 
.const [262] = Utf8 ()I 
.const [263] = Utf8 de/audi/app/car/common/listhandling/SyncedBCProfileRAxArray 
.const [264] = Utf8 get 
.const [265] = Utf8 (I)Lde/audi/app/car/common/listhandling/BatteryControlProfileRAx; 
.const [266] = Utf8 de/audi/app/car/common/listhandling/SyncedBCProfileRAxArray 
.const [267] = Utf8 length 
.const [268] = Utf8 ()I 
.const [269] = Utf8 de/audi/atip/log/LogChannel 
.const [270] = Utf8 log 
.const [271] = Utf8 (ILjava/lang/String;J)Z 
.const [272] = Utf8 java/lang/Object 
.const [273] = Utf8 <init> 
.const [274] = Utf8 ()V 
.const [275] = Utf8 de/audi/app/car/common/listhandling/ListHandlingHelper 
.const [276] = Utf8 logChannel 
.const [277] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [278] = Utf8 org/dsi/ifc/carhybrid/BatteryControlProfileRA0 
.const [279] = Utf8 <init> 
.const [280] = Utf8 ()V 
.const [281] = Utf8 org/dsi/ifc/carhybrid/BatteryControlProfileRA1 
.const [282] = Utf8 <init> 
.const [283] = Utf8 ()V 
.const [284] = Utf8 org/dsi/ifc/carhybrid/BatteryControlProfileRA2 
.const [285] = Utf8 <init> 
.const [286] = Utf8 ()V 
.const [287] = Utf8 org/dsi/ifc/carhybrid/BatteryControlProfileRA3 
.const [288] = Utf8 <init> 
.const [289] = Utf8 ()V 
.const [290] = Utf8 org/dsi/ifc/carhybrid/BatteryControlProfileRA4 
.const [291] = Utf8 <init> 
.const [292] = Utf8 ()V 
.const [293] = Utf8 org/dsi/ifc/carhybrid/BatteryControlProfileRA5 
.const [294] = Utf8 <init> 
.const [295] = Utf8 ()V 
.const [296] = Utf8 org/dsi/ifc/carhybrid/BatteryControlProfileRA6 
.const [297] = Utf8 <init> 
.const [298] = Utf8 ()V 
.const [299] = Utf8 org/dsi/ifc/carhybrid/BatteryControlProfileRA7 
.const [300] = Utf8 <init> 
.const [301] = Utf8 ()V 
.const [302] = Utf8 java/lang/Object 
.const [303] = Utf8 getClass 
.const [304] = Utf8 ()Ljava/lang/Class; 
.const [305] = Utf8 de/audi/app/car/common/listhandling/BatteryControlProfileRAx 
.const [306] = Utf8 <init> 
.const [307] = Utf8 ()V 
.const [308] = Utf8 de/audi/app/car/common/listhandling/BatteryControlPowerProviderRAx 
.const [309] = Utf8 <init> 
.const [310] = Utf8 ()V 
.const [311] = Utf8 de/audi/app/car/common/listhandling/ListHandlingHelper 
.const [312] = Class [311] 
.const [313] = Utf8 java/lang/Object 
.const [314] = Class [313] 
.const [315] = Utf8 logChannel 
.const [316] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [317] = Utf8 Code 
.const [318] = Utf8 <init> 
.const [319] = Utf8 ()V 
.const [320] = Utf8 init 
.const [321] = Utf8 (Lde/audi/atip/log/LogChannel;)V 
.const [322] = Utf8 copyFromBatteryControlProfileRAx 
.const [323] = Utf8 (Lde/audi/app/car/common/listhandling/BatteryControlProfileRAx;I)Ljava/lang/Object; 
.const [324] = Utf8 cloneTo 
.const [325] = Utf8 (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object; 
.const [326] = Utf8 copyToBatteryControlProfileRAx 
.const [327] = Utf8 (Ljava/lang/Object;Lde/audi/app/car/common/listhandling/BatteryControlProfileRAx;)Lde/audi/app/car/common/listhandling/BatteryControlProfileRAx; 
.const [328] = Utf8 mergeBatteryControlProfileArray 
.const [329] = Utf8 ([Ljava/lang/Object;Lde/audi/app/car/common/listhandling/SyncedBCProfileRAxArray;)[Lde/audi/app/car/common/listhandling/BatteryControlProfileRAx; 
.const [330] = Utf8 isIllegalIndex 
.const [331] = Utf8 (ILde/audi/app/car/common/listhandling/SyncedBCProfileRAxArray;)Z 
.const [332] = Utf8 copyToBatteryControlPowerProviderArray 
.const [333] = Utf8 ([Ljava/lang/Object;I)[Lde/audi/app/car/common/listhandling/BatteryControlPowerProviderRAx; 
.const [334] = Utf8 copyToBatteryControlPowerProviderRAx 
.const [335] = Utf8 (Ljava/lang/Object;I)Lde/audi/app/car/common/listhandling/BatteryControlPowerProviderRAx; 
.const [336] = Utf8 getField 
.const [337] = Utf8 (Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object; 
.const [338] = Utf8 <clinit> 
.const [339] = Utf8 ()V 
.end class 
