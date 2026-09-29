.version 50 0 
.class public super [319] 
.super [321] 

.method public annotation [323] : [324] 
    .attribute [322] .code stack 1 locals 0 
L0:     aload_0 
L1:     invokespecial [33] 
L4:     return 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public static [325] : [326] 
    .attribute [322] .code stack 2 locals 19 
L0:     aload_1 
L1:     ifnonnull L8 
L4:     iconst_1 
L5:     goto L9 
L8:     iconst_0 
L9:     istore_2 
L10:    aload_0 
L11:    iload_2 
L12:    invokeinterface [35] 0 
L17:    iload_2 
L18:    ifne L267 
L21:    aload_1 
L22:    invokevirtual [15] 
L25:    istore_3 
L26:    aload_0 
L27:    iload_3 
L28:    invokeinterface [36] 0 
L33:    aload_1 
L34:    invokevirtual [16] 
L37:    astore 4 
L39:    aload_0 
L40:    aload 4 
L42:    invokestatic [2] 
L45:    aload_1 
L46:    invokevirtual [17] 
L49:    astore 5 
L51:    aload_0 
L52:    aload 5 
L54:    invokestatic [3] 
L57:    aload_1 
L58:    invokevirtual [18] 
L61:    istore 6 
L63:    aload_0 
L64:    iload 6 
L66:    invokeinterface [36] 0 
L71:    aload_1 
L72:    invokevirtual [19] 
L75:    istore 7 
L77:    aload_0 
L78:    iload 7 
L80:    invokeinterface [36] 0 
L85:    aload_1 
L86:    invokevirtual [20] 
L89:    istore 8 
L91:    aload_0 
L92:    iload 8 
L94:    invokeinterface [36] 0 
L99:    aload_1 
L100:   invokevirtual [21] 
L103:   istore 9 
L105:   aload_0 
L106:   iload 9 
L108:   invokeinterface [36] 0 
L113:   aload_1 
L114:   invokevirtual [22] 
L117:   istore 10 
L119:   aload_0 
L120:   iload 10 
L122:   invokeinterface [36] 0 
L127:   aload_1 
L128:   invokevirtual [23] 
L131:   istore 11 
L133:   aload_0 
L134:   iload 11 
L136:   invokeinterface [36] 0 
L141:   aload_1 
L142:   invokevirtual [24] 
L145:   istore 12 
L147:   aload_0 
L148:   iload 12 
L150:   invokeinterface [36] 0 
L155:   aload_1 
L156:   invokevirtual [25] 
L159:   istore 13 
L161:   aload_0 
L162:   iload 13 
L164:   invokeinterface [35] 0 
L169:   aload_1 
L170:   invokevirtual [26] 
L173:   istore 14 
L175:   aload_0 
L176:   iload 14 
L178:   invokeinterface [36] 0 
L183:   aload_1 
L184:   invokevirtual [27] 
L187:   istore 15 
L189:   aload_0 
L190:   iload 15 
L192:   invokeinterface [36] 0 
L197:   aload_1 
L198:   invokevirtual [28] 
L201:   istore 16 
L203:   aload_0 
L204:   iload 16 
L206:   invokeinterface [36] 0 
L211:   aload_1 
L212:   invokevirtual [29] 
L215:   istore 17 
L217:   aload_0 
L218:   iload 17 
L220:   invokeinterface [36] 0 
L225:   aload_1 
L226:   invokevirtual [30] 
L229:   istore 18 
L231:   aload_0 
L232:   iload 18 
L234:   invokeinterface [36] 0 
L239:   aload_1 
L240:   invokevirtual [31] 
L243:   istore 19 
L245:   aload_0 
L246:   iload 19 
L248:   invokeinterface [36] 0 
L253:   aload_1 
L254:   invokevirtual [32] 
L257:   astore 20 
L259:   aload_0 
L260:   aload 20 
L262:   invokeinterface [37] 0 
L267:   return 
L268:   
    .end code 
.end method 

.method public static [327] : [328] 
    .attribute [322] .code stack 3 locals 2 
L0:     aload_1 
L1:     ifnonnull L8 
L4:     iconst_1 
L5:     goto L9 
L8:     iconst_0 
L9:     istore_2 
L10:    aload_0 
L11:    iload_2 
L12:    invokeinterface [35] 0 
L17:    iload_2 
L18:    ifne L50 
L21:    aload_0 
L22:    aload_1 
L23:    arraylength 
L24:    invokeinterface [36] 0 
L29:    iconst_0 
L30:    istore_3 
L31:    iload_3 
L32:    aload_1 
L33:    arraylength 
L34:    if_icmpge L50 
L37:    aload_0 
L38:    aload_1 
L39:    iload_3 
L40:    aaload 
L41:    invokestatic [4] 
L44:    iinc 3 1 
L47:    goto L31 
L50:    return 
L51:    nop 
L52:    
    .end code 
.end method 

.method public static [329] : [330] 
    .attribute [322] .code stack 2 locals 20 
L0:     aconst_null 
L1:     astore_1 
L2:     aload_0 
L3:     invokeinterface [38] 0 
L8:     istore_2 
L9:     iload_2 
L10:    ifne L267 
L13:    new [39] 
L16:    dup 
L17:    invokespecial [34] 
L20:    astore_1 
L21:    aload_0 
L22:    invokeinterface [40] 0 
L27:    istore_3 
L28:    aload_1 
L29:    iload_3 
L30:    putfield [41] 
L33:    aload_0 
L34:    invokestatic [6] 
L37:    astore 4 
L39:    aload_1 
L40:    aload 4 
L42:    putfield [42] 
L45:    aload_0 
L46:    invokestatic [7] 
L49:    astore 5 
L51:    aload_1 
L52:    aload 5 
L54:    putfield [43] 
L57:    aload_0 
L58:    invokeinterface [40] 0 
L63:    istore 6 
L65:    aload_1 
L66:    iload 6 
L68:    putfield [44] 
L71:    aload_0 
L72:    invokeinterface [40] 0 
L77:    istore 7 
L79:    aload_1 
L80:    iload 7 
L82:    putfield [45] 
L85:    aload_0 
L86:    invokeinterface [40] 0 
L91:    istore 8 
L93:    aload_1 
L94:    iload 8 
L96:    putfield [46] 
L99:    aload_0 
L100:   invokeinterface [40] 0 
L105:   istore 9 
L107:   aload_1 
L108:   iload 9 
L110:   putfield [47] 
L113:   aload_0 
L114:   invokeinterface [40] 0 
L119:   istore 10 
L121:   aload_1 
L122:   iload 10 
L124:   putfield [48] 
L127:   aload_0 
L128:   invokeinterface [40] 0 
L133:   istore 11 
L135:   aload_1 
L136:   iload 11 
L138:   putfield [49] 
L141:   aload_0 
L142:   invokeinterface [40] 0 
L147:   istore 12 
L149:   aload_1 
L150:   iload 12 
L152:   putfield [50] 
L155:   aload_0 
L156:   invokeinterface [38] 0 
L161:   istore 13 
L163:   aload_1 
L164:   iload 13 
L166:   putfield [51] 
L169:   aload_0 
L170:   invokeinterface [40] 0 
L175:   istore 14 
L177:   aload_1 
L178:   iload 14 
L180:   putfield [52] 
L183:   aload_0 
L184:   invokeinterface [40] 0 
L189:   istore 15 
L191:   aload_1 
L192:   iload 15 
L194:   putfield [53] 
L197:   aload_0 
L198:   invokeinterface [40] 0 
L203:   istore 16 
L205:   aload_1 
L206:   iload 16 
L208:   putfield [54] 
L211:   aload_0 
L212:   invokeinterface [40] 0 
L217:   istore 17 
L219:   aload_1 
L220:   iload 17 
L222:   putfield [55] 
L225:   aload_0 
L226:   invokeinterface [40] 0 
L231:   istore 18 
L233:   aload_1 
L234:   iload 18 
L236:   putfield [56] 
L239:   aload_0 
L240:   invokeinterface [40] 0 
L245:   istore 19 
L247:   aload_1 
L248:   iload 19 
L250:   putfield [57] 
L253:   aload_0 
L254:   invokeinterface [58] 0 
L259:   astore 20 
L261:   aload_1 
L262:   aload 20 
L264:   putfield [59] 
L267:   aload_1 
L268:   areturn 
L269:   nop 
L270:   nop 
L271:   nop 
L272:   
    .end code 
.end method 

.method public static [331] : [332] 
    .attribute [322] .code stack 3 locals 4 
L0:     aconst_null 
L1:     astore_1 
L2:     aload_0 
L3:     invokeinterface [38] 0 
L8:     istore_2 
L9:     iload_2 
L10:    ifne L48 
L13:    aload_0 
L14:    invokeinterface [40] 0 
L19:    istore_3 
L20:    iload_3 
L21:    anewarray [5] 
L24:    astore_1 
L25:    iconst_0 
L26:    istore 4 
L28:    iload 4 
L30:    iload_3 
L31:    if_icmpge L48 
L34:    aload_1 
L35:    iload 4 
L37:    aload_0 
L38:    invokestatic [8] 
L41:    aastore 
L42:    iinc 4 1 
L45:    goto L28 
L48:    aload_1 
L49:    areturn 
L50:    nop 
L51:    nop 
L52:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Method [60] [61] 
.const [3] = Method [62] [63] 
.const [4] = Method [64] [65] 
.const [5] = Class [66] 
.const [6] = Method [67] [68] 
.const [7] = Method [69] [70] 
.const [8] = Method [71] [72] 
.const [9] = Class [73] 
.const [10] = Class [74] 
.const [11] = Class [75] 
.const [12] = Class [76] 
.const [13] = Class [77] 
.const [14] = Class [78] 
.const [15] = Method [79] [80] 
.const [16] = Method [81] [82] 
.const [17] = Method [83] [84] 
.const [18] = Method [85] [86] 
.const [19] = Method [87] [88] 
.const [20] = Method [89] [90] 
.const [21] = Method [91] [92] 
.const [22] = Method [93] [94] 
.const [23] = Method [95] [96] 
.const [24] = Method [97] [98] 
.const [25] = Method [99] [100] 
.const [26] = Method [101] [102] 
.const [27] = Method [103] [104] 
.const [28] = Method [105] [106] 
.const [29] = Method [107] [108] 
.const [30] = Method [109] [110] 
.const [31] = Method [111] [112] 
.const [32] = Method [113] [114] 
.const [33] = Method [115] [116] 
.const [34] = Method [117] [118] 
.const [35] = InterfaceMethod [119] [120] 
.const [36] = InterfaceMethod [121] [122] 
.const [37] = InterfaceMethod [123] [124] 
.const [38] = InterfaceMethod [125] [126] 
.const [39] = Class [127] 
.const [40] = InterfaceMethod [128] [129] 
.const [41] = Field [130] [131] 
.const [42] = Field [132] [133] 
.const [43] = Field [134] [135] 
.const [44] = Field [136] [137] 
.const [45] = Field [138] [139] 
.const [46] = Field [140] [141] 
.const [47] = Field [142] [143] 
.const [48] = Field [144] [145] 
.const [49] = Field [146] [147] 
.const [50] = Field [148] [149] 
.const [51] = Field [150] [151] 
.const [52] = Field [152] [153] 
.const [53] = Field [154] [155] 
.const [54] = Field [156] [157] 
.const [55] = Field [158] [159] 
.const [56] = Field [160] [161] 
.const [57] = Field [162] [163] 
.const [58] = InterfaceMethod [164] [165] 
.const [59] = Field [166] [167] 
.const [60] = Class [168] 
.const [61] = NameAndType [169] [170] 
.const [62] = Class [171] 
.const [63] = NameAndType [172] [173] 
.const [64] = Class [174] 
.const [65] = NameAndType [175] [176] 
.const [66] = Utf8 org/dsi/ifc/carhybrid/BatteryControlProfileRA0 
.const [67] = Class [177] 
.const [68] = NameAndType [178] [179] 
.const [69] = Class [180] 
.const [70] = NameAndType [181] [182] 
.const [71] = Class [183] 
.const [72] = NameAndType [184] [185] 
.const [73] = Utf8 de/esolutions/fw/comm/dsi/carhybrid/impl/BatteryControlProfileRA0Serializer 
.const [74] = Utf8 java/lang/Object 
.const [75] = Utf8 de/esolutions/fw/util/serializer/ISerializer 
.const [76] = Utf8 de/esolutions/fw/comm/dsi/carhybrid/impl/BatteryControlProfileOperationSerializer 
.const [77] = Utf8 de/esolutions/fw/comm/dsi/carhybrid/impl/BatteryControlProfileOperation2Serializer 
.const [78] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [79] = Class [186] 
.const [80] = NameAndType [187] [188] 
.const [81] = Class [189] 
.const [82] = NameAndType [190] [191] 
.const [83] = Class [192] 
.const [84] = NameAndType [193] [194] 
.const [85] = Class [195] 
.const [86] = NameAndType [196] [197] 
.const [87] = Class [198] 
.const [88] = NameAndType [199] [200] 
.const [89] = Class [201] 
.const [90] = NameAndType [202] [203] 
.const [91] = Class [204] 
.const [92] = NameAndType [205] [206] 
.const [93] = Class [207] 
.const [94] = NameAndType [208] [209] 
.const [95] = Class [210] 
.const [96] = NameAndType [211] [212] 
.const [97] = Class [213] 
.const [98] = NameAndType [214] [215] 
.const [99] = Class [216] 
.const [100] = NameAndType [217] [218] 
.const [101] = Class [219] 
.const [102] = NameAndType [220] [221] 
.const [103] = Class [222] 
.const [104] = NameAndType [223] [224] 
.const [105] = Class [225] 
.const [106] = NameAndType [226] [227] 
.const [107] = Class [228] 
.const [108] = NameAndType [229] [230] 
.const [109] = Class [231] 
.const [110] = NameAndType [232] [233] 
.const [111] = Class [234] 
.const [112] = NameAndType [235] [236] 
.const [113] = Class [237] 
.const [114] = NameAndType [238] [239] 
.const [115] = Class [240] 
.const [116] = NameAndType [241] [242] 
.const [117] = Class [243] 
.const [118] = NameAndType [244] [245] 
.const [119] = Class [246] 
.const [120] = NameAndType [247] [248] 
.const [121] = Class [249] 
.const [122] = NameAndType [250] [251] 
.const [123] = Class [252] 
.const [124] = NameAndType [253] [254] 
.const [125] = Class [255] 
.const [126] = NameAndType [256] [257] 
.const [127] = Utf8 org/dsi/ifc/carhybrid/BatteryControlProfileRA0 
.const [128] = Class [258] 
.const [129] = NameAndType [259] [260] 
.const [130] = Class [261] 
.const [131] = NameAndType [262] [263] 
.const [132] = Class [264] 
.const [133] = NameAndType [265] [266] 
.const [134] = Class [267] 
.const [135] = NameAndType [268] [269] 
.const [136] = Class [270] 
.const [137] = NameAndType [271] [272] 
.const [138] = Class [273] 
.const [139] = NameAndType [274] [275] 
.const [140] = Class [276] 
.const [141] = NameAndType [277] [278] 
.const [142] = Class [279] 
.const [143] = NameAndType [280] [281] 
.const [144] = Class [282] 
.const [145] = NameAndType [283] [284] 
.const [146] = Class [285] 
.const [147] = NameAndType [286] [287] 
.const [148] = Class [288] 
.const [149] = NameAndType [289] [290] 
.const [150] = Class [291] 
.const [151] = NameAndType [292] [293] 
.const [152] = Class [294] 
.const [153] = NameAndType [295] [296] 
.const [154] = Class [297] 
.const [155] = NameAndType [298] [299] 
.const [156] = Class [300] 
.const [157] = NameAndType [301] [302] 
.const [158] = Class [303] 
.const [159] = NameAndType [304] [305] 
.const [160] = Class [306] 
.const [161] = NameAndType [307] [308] 
.const [162] = Class [309] 
.const [163] = NameAndType [310] [311] 
.const [164] = Class [312] 
.const [165] = NameAndType [313] [314] 
.const [166] = Class [315] 
.const [167] = NameAndType [316] [317] 
.const [168] = Utf8 de/esolutions/fw/comm/dsi/carhybrid/impl/BatteryControlProfileOperationSerializer 
.const [169] = Utf8 putOptionalBatteryControlProfileOperation 
.const [170] = Utf8 (Lde/esolutions/fw/util/serializer/ISerializer;Lorg/dsi/ifc/carhybrid/BatteryControlProfileOperation;)V 
.const [171] = Utf8 de/esolutions/fw/comm/dsi/carhybrid/impl/BatteryControlProfileOperation2Serializer 
.const [172] = Utf8 putOptionalBatteryControlProfileOperation2 
.const [173] = Utf8 (Lde/esolutions/fw/util/serializer/ISerializer;Lorg/dsi/ifc/carhybrid/BatteryControlProfileOperation2;)V 
.const [174] = Utf8 de/esolutions/fw/comm/dsi/carhybrid/impl/BatteryControlProfileRA0Serializer 
.const [175] = Utf8 putOptionalBatteryControlProfileRA0 
.const [176] = Utf8 (Lde/esolutions/fw/util/serializer/ISerializer;Lorg/dsi/ifc/carhybrid/BatteryControlProfileRA0;)V 
.const [177] = Utf8 de/esolutions/fw/comm/dsi/carhybrid/impl/BatteryControlProfileOperationSerializer 
.const [178] = Utf8 getOptionalBatteryControlProfileOperation 
.const [179] = Utf8 (Lde/esolutions/fw/util/serializer/IDeserializer;)Lorg/dsi/ifc/carhybrid/BatteryControlProfileOperation; 
.const [180] = Utf8 de/esolutions/fw/comm/dsi/carhybrid/impl/BatteryControlProfileOperation2Serializer 
.const [181] = Utf8 getOptionalBatteryControlProfileOperation2 
.const [182] = Utf8 (Lde/esolutions/fw/util/serializer/IDeserializer;)Lorg/dsi/ifc/carhybrid/BatteryControlProfileOperation2; 
.const [183] = Utf8 de/esolutions/fw/comm/dsi/carhybrid/impl/BatteryControlProfileRA0Serializer 
.const [184] = Utf8 getOptionalBatteryControlProfileRA0 
.const [185] = Utf8 (Lde/esolutions/fw/util/serializer/IDeserializer;)Lorg/dsi/ifc/carhybrid/BatteryControlProfileRA0; 
.const [186] = Utf8 org/dsi/ifc/carhybrid/BatteryControlProfileRA0 
.const [187] = Utf8 getPos 
.const [188] = Utf8 ()I 
.const [189] = Utf8 org/dsi/ifc/carhybrid/BatteryControlProfileRA0 
.const [190] = Utf8 getProfileOperation 
.const [191] = Utf8 ()Lorg/dsi/ifc/carhybrid/BatteryControlProfileOperation; 
.const [192] = Utf8 org/dsi/ifc/carhybrid/BatteryControlProfileRA0 
.const [193] = Utf8 getProfileOperation2 
.const [194] = Utf8 ()Lorg/dsi/ifc/carhybrid/BatteryControlProfileOperation2; 
.const [195] = Utf8 org/dsi/ifc/carhybrid/BatteryControlProfileRA0 
.const [196] = Utf8 getMaxCurrent 
.const [197] = Utf8 ()I 
.const [198] = Utf8 org/dsi/ifc/carhybrid/BatteryControlProfileRA0 
.const [199] = Utf8 getMinChargeLevel 
.const [200] = Utf8 ()I 
.const [201] = Utf8 org/dsi/ifc/carhybrid/BatteryControlProfileRA0 
.const [202] = Utf8 getMinRange 
.const [203] = Utf8 ()I 
.const [204] = Utf8 org/dsi/ifc/carhybrid/BatteryControlProfileRA0 
.const [205] = Utf8 getTargetChargeLevel 
.const [206] = Utf8 ()I 
.const [207] = Utf8 org/dsi/ifc/carhybrid/BatteryControlProfileRA0 
.const [208] = Utf8 getTargetChargeDuration 
.const [209] = Utf8 ()I 
.const [210] = Utf8 org/dsi/ifc/carhybrid/BatteryControlProfileRA0 
.const [211] = Utf8 getTargetChargeRange 
.const [212] = Utf8 ()I 
.const [213] = Utf8 org/dsi/ifc/carhybrid/BatteryControlProfileRA0 
.const [214] = Utf8 getUnitRange 
.const [215] = Utf8 ()I 
.const [216] = Utf8 org/dsi/ifc/carhybrid/BatteryControlProfileRA0 
.const [217] = Utf8 isRangeCalculationSetup 
.const [218] = Utf8 ()Z 
.const [219] = Utf8 org/dsi/ifc/carhybrid/BatteryControlProfileRA0 
.const [220] = Utf8 getTemperature 
.const [221] = Utf8 ()I 
.const [222] = Utf8 org/dsi/ifc/carhybrid/BatteryControlProfileRA0 
.const [223] = Utf8 getTemperatureUnit 
.const [224] = Utf8 ()I 
.const [225] = Utf8 org/dsi/ifc/carhybrid/BatteryControlProfileRA0 
.const [226] = Utf8 getLeadTime 
.const [227] = Utf8 ()I 
.const [228] = Utf8 org/dsi/ifc/carhybrid/BatteryControlProfileRA0 
.const [229] = Utf8 getHoldingTimePlug 
.const [230] = Utf8 ()I 
.const [231] = Utf8 org/dsi/ifc/carhybrid/BatteryControlProfileRA0 
.const [232] = Utf8 getHoldingTimeBattery 
.const [233] = Utf8 ()I 
.const [234] = Utf8 org/dsi/ifc/carhybrid/BatteryControlProfileRA0 
.const [235] = Utf8 getProviderDataId 
.const [236] = Utf8 ()I 
.const [237] = Utf8 org/dsi/ifc/carhybrid/BatteryControlProfileRA0 
.const [238] = Utf8 getName 
.const [239] = Utf8 ()Ljava/lang/String; 
.const [240] = Utf8 java/lang/Object 
.const [241] = Utf8 <init> 
.const [242] = Utf8 ()V 
.const [243] = Utf8 org/dsi/ifc/carhybrid/BatteryControlProfileRA0 
.const [244] = Utf8 <init> 
.const [245] = Utf8 ()V 
.const [246] = Utf8 de/esolutions/fw/util/serializer/ISerializer 
.const [247] = Utf8 putBool 
.const [248] = Utf8 (Z)V 
.const [249] = Utf8 de/esolutions/fw/util/serializer/ISerializer 
.const [250] = Utf8 putInt32 
.const [251] = Utf8 (I)V 
.const [252] = Utf8 de/esolutions/fw/util/serializer/ISerializer 
.const [253] = Utf8 putOptionalString 
.const [254] = Utf8 (Ljava/lang/String;)V 
.const [255] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [256] = Utf8 getBool 
.const [257] = Utf8 ()Z 
.const [258] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [259] = Utf8 getInt32 
.const [260] = Utf8 ()I 
.const [261] = Utf8 org/dsi/ifc/carhybrid/BatteryControlProfileRA0 
.const [262] = Utf8 pos 
.const [263] = Utf8 I 
.const [264] = Utf8 org/dsi/ifc/carhybrid/BatteryControlProfileRA0 
.const [265] = Utf8 profileOperation 
.const [266] = Utf8 Lorg/dsi/ifc/carhybrid/BatteryControlProfileOperation; 
.const [267] = Utf8 org/dsi/ifc/carhybrid/BatteryControlProfileRA0 
.const [268] = Utf8 profileOperation2 
.const [269] = Utf8 Lorg/dsi/ifc/carhybrid/BatteryControlProfileOperation2; 
.const [270] = Utf8 org/dsi/ifc/carhybrid/BatteryControlProfileRA0 
.const [271] = Utf8 maxCurrent 
.const [272] = Utf8 I 
.const [273] = Utf8 org/dsi/ifc/carhybrid/BatteryControlProfileRA0 
.const [274] = Utf8 minChargeLevel 
.const [275] = Utf8 I 
.const [276] = Utf8 org/dsi/ifc/carhybrid/BatteryControlProfileRA0 
.const [277] = Utf8 minRange 
.const [278] = Utf8 I 
.const [279] = Utf8 org/dsi/ifc/carhybrid/BatteryControlProfileRA0 
.const [280] = Utf8 targetChargeLevel 
.const [281] = Utf8 I 
.const [282] = Utf8 org/dsi/ifc/carhybrid/BatteryControlProfileRA0 
.const [283] = Utf8 targetChargeDuration 
.const [284] = Utf8 I 
.const [285] = Utf8 org/dsi/ifc/carhybrid/BatteryControlProfileRA0 
.const [286] = Utf8 targetChargeRange 
.const [287] = Utf8 I 
.const [288] = Utf8 org/dsi/ifc/carhybrid/BatteryControlProfileRA0 
.const [289] = Utf8 unitRange 
.const [290] = Utf8 I 
.const [291] = Utf8 org/dsi/ifc/carhybrid/BatteryControlProfileRA0 
.const [292] = Utf8 rangeCalculationSetup 
.const [293] = Utf8 Z 
.const [294] = Utf8 org/dsi/ifc/carhybrid/BatteryControlProfileRA0 
.const [295] = Utf8 temperature 
.const [296] = Utf8 I 
.const [297] = Utf8 org/dsi/ifc/carhybrid/BatteryControlProfileRA0 
.const [298] = Utf8 temperatureUnit 
.const [299] = Utf8 I 
.const [300] = Utf8 org/dsi/ifc/carhybrid/BatteryControlProfileRA0 
.const [301] = Utf8 leadTime 
.const [302] = Utf8 I 
.const [303] = Utf8 org/dsi/ifc/carhybrid/BatteryControlProfileRA0 
.const [304] = Utf8 holdingTimePlug 
.const [305] = Utf8 I 
.const [306] = Utf8 org/dsi/ifc/carhybrid/BatteryControlProfileRA0 
.const [307] = Utf8 holdingTimeBattery 
.const [308] = Utf8 I 
.const [309] = Utf8 org/dsi/ifc/carhybrid/BatteryControlProfileRA0 
.const [310] = Utf8 providerDataId 
.const [311] = Utf8 I 
.const [312] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [313] = Utf8 getOptionalString 
.const [314] = Utf8 ()Ljava/lang/String; 
.const [315] = Utf8 org/dsi/ifc/carhybrid/BatteryControlProfileRA0 
.const [316] = Utf8 name 
.const [317] = Utf8 Ljava/lang/String; 
.const [318] = Utf8 de/esolutions/fw/comm/dsi/carhybrid/impl/BatteryControlProfileRA0Serializer 
.const [319] = Class [318] 
.const [320] = Utf8 java/lang/Object 
.const [321] = Class [320] 
.const [322] = Utf8 Code 
.const [323] = Utf8 <init> 
.const [324] = Utf8 ()V 
.const [325] = Utf8 putOptionalBatteryControlProfileRA0 
.const [326] = Utf8 (Lde/esolutions/fw/util/serializer/ISerializer;Lorg/dsi/ifc/carhybrid/BatteryControlProfileRA0;)V 
.const [327] = Utf8 putOptionalBatteryControlProfileRA0VarArray 
.const [328] = Utf8 (Lde/esolutions/fw/util/serializer/ISerializer;[Lorg/dsi/ifc/carhybrid/BatteryControlProfileRA0;)V 
.const [329] = Utf8 getOptionalBatteryControlProfileRA0 
.const [330] = Utf8 (Lde/esolutions/fw/util/serializer/IDeserializer;)Lorg/dsi/ifc/carhybrid/BatteryControlProfileRA0; 
.const [331] = Utf8 getOptionalBatteryControlProfileRA0VarArray 
.const [332] = Utf8 (Lde/esolutions/fw/util/serializer/IDeserializer;)[Lorg/dsi/ifc/carhybrid/BatteryControlProfileRA0; 
.end class 
