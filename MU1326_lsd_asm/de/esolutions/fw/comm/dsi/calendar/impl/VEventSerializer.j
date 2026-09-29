.version 50 0 
.class public super [367] 
.super [369] 

.method public annotation [371] : [372] 
    .attribute [370] .code stack 1 locals 0 
L0:     aload_0 
L1:     invokespecial [38] 
L4:     return 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public static [373] : [374] 
    .attribute [370] .code stack 2 locals 22 
L0:     aload_1 
L1:     ifnonnull L8 
L4:     iconst_1 
L5:     goto L9 
L8:     iconst_0 
L9:     istore_2 
L10:    aload_0 
L11:    iload_2 
L12:    invokeinterface [40] 0 
L17:    iload_2 
L18:    ifne L307 
L21:    aload_1 
L22:    invokevirtual [17] 
L25:    astore_3 
L26:    aload_0 
L27:    aload_3 
L28:    invokestatic [2] 
L31:    aload_1 
L32:    invokevirtual [18] 
L35:    astore 4 
L37:    aload_0 
L38:    aload 4 
L40:    invokestatic [3] 
L43:    aload_1 
L44:    invokevirtual [19] 
L47:    astore 5 
L49:    aload_0 
L50:    aload 5 
L52:    invokeinterface [41] 0 
L57:    aload_1 
L58:    invokevirtual [20] 
L61:    astore 6 
L63:    aload_0 
L64:    aload 6 
L66:    invokeinterface [41] 0 
L71:    aload_1 
L72:    invokevirtual [21] 
L75:    astore 7 
L77:    aload_0 
L78:    aload 7 
L80:    invokeinterface [41] 0 
L85:    aload_1 
L86:    invokevirtual [22] 
L89:    astore 8 
L91:    aload_0 
L92:    aload 8 
L94:    invokeinterface [41] 0 
L99:    aload_1 
L100:   invokevirtual [23] 
L103:   astore 9 
L105:   aload_0 
L106:   aload 9 
L108:   invokeinterface [41] 0 
L113:   aload_1 
L114:   invokevirtual [24] 
L117:   astore 10 
L119:   aload_0 
L120:   aload 10 
L122:   invokeinterface [41] 0 
L127:   aload_1 
L128:   invokevirtual [25] 
L131:   astore 11 
L133:   aload_0 
L134:   aload 11 
L136:   invokeinterface [41] 0 
L141:   aload_1 
L142:   invokevirtual [26] 
L145:   astore 12 
L147:   aload_0 
L148:   aload 12 
L150:   invokeinterface [41] 0 
L155:   aload_1 
L156:   invokevirtual [27] 
L159:   astore 13 
L161:   aload_0 
L162:   aload 13 
L164:   invokeinterface [41] 0 
L169:   aload_1 
L170:   invokevirtual [28] 
L173:   astore 14 
L175:   aload_0 
L176:   aload 14 
L178:   invokeinterface [41] 0 
L183:   aload_1 
L184:   invokevirtual [29] 
L187:   astore 15 
L189:   aload_0 
L190:   aload 15 
L192:   invokeinterface [41] 0 
L197:   aload_1 
L198:   invokevirtual [30] 
L201:   astore 16 
L203:   aload_0 
L204:   aload 16 
L206:   invokestatic [4] 
L209:   aload_1 
L210:   invokevirtual [31] 
L213:   astore 17 
L215:   aload_0 
L216:   aload 17 
L218:   invokeinterface [41] 0 
L223:   aload_1 
L224:   invokevirtual [32] 
L227:   astore 18 
L229:   aload_0 
L230:   aload 18 
L232:   invokeinterface [41] 0 
L237:   aload_1 
L238:   invokevirtual [33] 
L241:   astore 19 
L243:   aload_0 
L244:   aload 19 
L246:   invokeinterface [41] 0 
L251:   aload_1 
L252:   invokevirtual [34] 
L255:   astore 20 
L257:   aload_0 
L258:   aload 20 
L260:   invokeinterface [41] 0 
L265:   aload_1 
L266:   invokevirtual [35] 
L269:   astore 21 
L271:   aload_0 
L272:   aload 21 
L274:   invokeinterface [41] 0 
L279:   aload_1 
L280:   invokevirtual [36] 
L283:   astore 22 
L285:   aload_0 
L286:   aload 22 
L288:   invokeinterface [41] 0 
L293:   aload_1 
L294:   invokevirtual [37] 
L297:   astore 23 
L299:   aload_0 
L300:   aload 23 
L302:   invokeinterface [41] 0 
L307:   return 
L308:   
    .end code 
.end method 

.method public static [375] : [376] 
    .attribute [370] .code stack 3 locals 2 
L0:     aload_1 
L1:     ifnonnull L8 
L4:     iconst_1 
L5:     goto L9 
L8:     iconst_0 
L9:     istore_2 
L10:    aload_0 
L11:    iload_2 
L12:    invokeinterface [40] 0 
L17:    iload_2 
L18:    ifne L50 
L21:    aload_0 
L22:    aload_1 
L23:    arraylength 
L24:    invokeinterface [42] 0 
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
L41:    invokestatic [5] 
L44:    iinc 3 1 
L47:    goto L31 
L50:    return 
L51:    nop 
L52:    
    .end code 
.end method 

.method public static [377] : [378] 
    .attribute [370] .code stack 2 locals 23 
L0:     aconst_null 
L1:     astore_1 
L2:     aload_0 
L3:     invokeinterface [43] 0 
L8:     istore_2 
L9:     iload_2 
L10:    ifne L307 
L13:    new [44] 
L16:    dup 
L17:    invokespecial [39] 
L20:    astore_1 
L21:    aload_0 
L22:    invokestatic [7] 
L25:    astore_3 
L26:    aload_1 
L27:    aload_3 
L28:    putfield [45] 
L31:    aload_0 
L32:    invokestatic [8] 
L35:    astore 4 
L37:    aload_1 
L38:    aload 4 
L40:    putfield [46] 
L43:    aload_0 
L44:    invokeinterface [47] 0 
L49:    astore 5 
L51:    aload_1 
L52:    aload 5 
L54:    putfield [48] 
L57:    aload_0 
L58:    invokeinterface [47] 0 
L63:    astore 6 
L65:    aload_1 
L66:    aload 6 
L68:    putfield [49] 
L71:    aload_0 
L72:    invokeinterface [47] 0 
L77:    astore 7 
L79:    aload_1 
L80:    aload 7 
L82:    putfield [50] 
L85:    aload_0 
L86:    invokeinterface [47] 0 
L91:    astore 8 
L93:    aload_1 
L94:    aload 8 
L96:    putfield [51] 
L99:    aload_0 
L100:   invokeinterface [47] 0 
L105:   astore 9 
L107:   aload_1 
L108:   aload 9 
L110:   putfield [52] 
L113:   aload_0 
L114:   invokeinterface [47] 0 
L119:   astore 10 
L121:   aload_1 
L122:   aload 10 
L124:   putfield [53] 
L127:   aload_0 
L128:   invokeinterface [47] 0 
L133:   astore 11 
L135:   aload_1 
L136:   aload 11 
L138:   putfield [54] 
L141:   aload_0 
L142:   invokeinterface [47] 0 
L147:   astore 12 
L149:   aload_1 
L150:   aload 12 
L152:   putfield [55] 
L155:   aload_0 
L156:   invokeinterface [47] 0 
L161:   astore 13 
L163:   aload_1 
L164:   aload 13 
L166:   putfield [56] 
L169:   aload_0 
L170:   invokeinterface [47] 0 
L175:   astore 14 
L177:   aload_1 
L178:   aload 14 
L180:   putfield [57] 
L183:   aload_0 
L184:   invokeinterface [47] 0 
L189:   astore 15 
L191:   aload_1 
L192:   aload 15 
L194:   putfield [58] 
L197:   aload_0 
L198:   invokestatic [9] 
L201:   astore 16 
L203:   aload_1 
L204:   aload 16 
L206:   putfield [59] 
L209:   aload_0 
L210:   invokeinterface [47] 0 
L215:   astore 17 
L217:   aload_1 
L218:   aload 17 
L220:   putfield [60] 
L223:   aload_0 
L224:   invokeinterface [47] 0 
L229:   astore 18 
L231:   aload_1 
L232:   aload 18 
L234:   putfield [61] 
L237:   aload_0 
L238:   invokeinterface [47] 0 
L243:   astore 19 
L245:   aload_1 
L246:   aload 19 
L248:   putfield [62] 
L251:   aload_0 
L252:   invokeinterface [47] 0 
L257:   astore 20 
L259:   aload_1 
L260:   aload 20 
L262:   putfield [63] 
L265:   aload_0 
L266:   invokeinterface [47] 0 
L271:   astore 21 
L273:   aload_1 
L274:   aload 21 
L276:   putfield [64] 
L279:   aload_0 
L280:   invokeinterface [47] 0 
L285:   astore 22 
L287:   aload_1 
L288:   aload 22 
L290:   putfield [65] 
L293:   aload_0 
L294:   invokeinterface [47] 0 
L299:   astore 23 
L301:   aload_1 
L302:   aload 23 
L304:   putfield [66] 
L307:   aload_1 
L308:   areturn 
L309:   nop 
L310:   nop 
L311:   nop 
L312:   
    .end code 
.end method 

.method public static [379] : [380] 
    .attribute [370] .code stack 3 locals 4 
L0:     aconst_null 
L1:     astore_1 
L2:     aload_0 
L3:     invokeinterface [43] 0 
L8:     istore_2 
L9:     iload_2 
L10:    ifne L48 
L13:    aload_0 
L14:    invokeinterface [67] 0 
L19:    istore_3 
L20:    iload_3 
L21:    anewarray [6] 
L24:    astore_1 
L25:    iconst_0 
L26:    istore 4 
L28:    iload 4 
L30:    iload_3 
L31:    if_icmpge L48 
L34:    aload_1 
L35:    iload 4 
L37:    aload_0 
L38:    invokestatic [10] 
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
.const [2] = Method [68] [69] 
.const [3] = Method [70] [71] 
.const [4] = Method [72] [73] 
.const [5] = Method [74] [75] 
.const [6] = Class [76] 
.const [7] = Method [77] [78] 
.const [8] = Method [79] [80] 
.const [9] = Method [81] [82] 
.const [10] = Method [83] [84] 
.const [11] = Class [85] 
.const [12] = Class [86] 
.const [13] = Class [87] 
.const [14] = Class [88] 
.const [15] = Class [89] 
.const [16] = Class [90] 
.const [17] = Method [91] [92] 
.const [18] = Method [93] [94] 
.const [19] = Method [95] [96] 
.const [20] = Method [97] [98] 
.const [21] = Method [99] [100] 
.const [22] = Method [101] [102] 
.const [23] = Method [103] [104] 
.const [24] = Method [105] [106] 
.const [25] = Method [107] [108] 
.const [26] = Method [109] [110] 
.const [27] = Method [111] [112] 
.const [28] = Method [113] [114] 
.const [29] = Method [115] [116] 
.const [30] = Method [117] [118] 
.const [31] = Method [119] [120] 
.const [32] = Method [121] [122] 
.const [33] = Method [123] [124] 
.const [34] = Method [125] [126] 
.const [35] = Method [127] [128] 
.const [36] = Method [129] [130] 
.const [37] = Method [131] [132] 
.const [38] = Method [133] [134] 
.const [39] = Method [135] [136] 
.const [40] = InterfaceMethod [137] [138] 
.const [41] = InterfaceMethod [139] [140] 
.const [42] = InterfaceMethod [141] [142] 
.const [43] = InterfaceMethod [143] [144] 
.const [44] = Class [145] 
.const [45] = Field [146] [147] 
.const [46] = Field [148] [149] 
.const [47] = InterfaceMethod [150] [151] 
.const [48] = Field [152] [153] 
.const [49] = Field [154] [155] 
.const [50] = Field [156] [157] 
.const [51] = Field [158] [159] 
.const [52] = Field [160] [161] 
.const [53] = Field [162] [163] 
.const [54] = Field [164] [165] 
.const [55] = Field [166] [167] 
.const [56] = Field [168] [169] 
.const [57] = Field [170] [171] 
.const [58] = Field [172] [173] 
.const [59] = Field [174] [175] 
.const [60] = Field [176] [177] 
.const [61] = Field [178] [179] 
.const [62] = Field [180] [181] 
.const [63] = Field [182] [183] 
.const [64] = Field [184] [185] 
.const [65] = Field [186] [187] 
.const [66] = Field [188] [189] 
.const [67] = InterfaceMethod [190] [191] 
.const [68] = Class [192] 
.const [69] = NameAndType [193] [194] 
.const [70] = Class [195] 
.const [71] = NameAndType [196] [197] 
.const [72] = Class [198] 
.const [73] = NameAndType [199] [200] 
.const [74] = Class [201] 
.const [75] = NameAndType [202] [203] 
.const [76] = Utf8 org/dsi/ifc/calendar/VEvent 
.const [77] = Class [204] 
.const [78] = NameAndType [205] [206] 
.const [79] = Class [207] 
.const [80] = NameAndType [208] [209] 
.const [81] = Class [210] 
.const [82] = NameAndType [211] [212] 
.const [83] = Class [213] 
.const [84] = NameAndType [214] [215] 
.const [85] = Utf8 de/esolutions/fw/comm/dsi/calendar/impl/VEventSerializer 
.const [86] = Utf8 java/lang/Object 
.const [87] = Utf8 de/esolutions/fw/util/serializer/ISerializer 
.const [88] = Utf8 de/esolutions/fw/comm/dsi/calendar/impl/VAlarmSerializer 
.const [89] = Utf8 de/esolutions/fw/comm/dsi/calendar/impl/VAttendeeSerializer 
.const [90] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [91] = Class [216] 
.const [92] = NameAndType [217] [218] 
.const [93] = Class [219] 
.const [94] = NameAndType [220] [221] 
.const [95] = Class [222] 
.const [96] = NameAndType [223] [224] 
.const [97] = Class [225] 
.const [98] = NameAndType [226] [227] 
.const [99] = Class [228] 
.const [100] = NameAndType [229] [230] 
.const [101] = Class [231] 
.const [102] = NameAndType [232] [233] 
.const [103] = Class [234] 
.const [104] = NameAndType [235] [236] 
.const [105] = Class [237] 
.const [106] = NameAndType [238] [239] 
.const [107] = Class [240] 
.const [108] = NameAndType [241] [242] 
.const [109] = Class [243] 
.const [110] = NameAndType [244] [245] 
.const [111] = Class [246] 
.const [112] = NameAndType [247] [248] 
.const [113] = Class [249] 
.const [114] = NameAndType [250] [251] 
.const [115] = Class [252] 
.const [116] = NameAndType [253] [254] 
.const [117] = Class [255] 
.const [118] = NameAndType [256] [257] 
.const [119] = Class [258] 
.const [120] = NameAndType [259] [260] 
.const [121] = Class [261] 
.const [122] = NameAndType [262] [263] 
.const [123] = Class [264] 
.const [124] = NameAndType [265] [266] 
.const [125] = Class [267] 
.const [126] = NameAndType [268] [269] 
.const [127] = Class [270] 
.const [128] = NameAndType [271] [272] 
.const [129] = Class [273] 
.const [130] = NameAndType [274] [275] 
.const [131] = Class [276] 
.const [132] = NameAndType [277] [278] 
.const [133] = Class [279] 
.const [134] = NameAndType [280] [281] 
.const [135] = Class [282] 
.const [136] = NameAndType [283] [284] 
.const [137] = Class [285] 
.const [138] = NameAndType [286] [287] 
.const [139] = Class [288] 
.const [140] = NameAndType [289] [290] 
.const [141] = Class [291] 
.const [142] = NameAndType [292] [293] 
.const [143] = Class [294] 
.const [144] = NameAndType [295] [296] 
.const [145] = Utf8 org/dsi/ifc/calendar/VEvent 
.const [146] = Class [297] 
.const [147] = NameAndType [298] [299] 
.const [148] = Class [300] 
.const [149] = NameAndType [301] [302] 
.const [150] = Class [303] 
.const [151] = NameAndType [304] [305] 
.const [152] = Class [306] 
.const [153] = NameAndType [307] [308] 
.const [154] = Class [309] 
.const [155] = NameAndType [310] [311] 
.const [156] = Class [312] 
.const [157] = NameAndType [313] [314] 
.const [158] = Class [315] 
.const [159] = NameAndType [316] [317] 
.const [160] = Class [318] 
.const [161] = NameAndType [319] [320] 
.const [162] = Class [321] 
.const [163] = NameAndType [322] [323] 
.const [164] = Class [324] 
.const [165] = NameAndType [325] [326] 
.const [166] = Class [327] 
.const [167] = NameAndType [328] [329] 
.const [168] = Class [330] 
.const [169] = NameAndType [331] [332] 
.const [170] = Class [333] 
.const [171] = NameAndType [334] [335] 
.const [172] = Class [336] 
.const [173] = NameAndType [337] [338] 
.const [174] = Class [339] 
.const [175] = NameAndType [340] [341] 
.const [176] = Class [342] 
.const [177] = NameAndType [343] [344] 
.const [178] = Class [345] 
.const [179] = NameAndType [346] [347] 
.const [180] = Class [348] 
.const [181] = NameAndType [349] [350] 
.const [182] = Class [351] 
.const [183] = NameAndType [352] [353] 
.const [184] = Class [354] 
.const [185] = NameAndType [355] [356] 
.const [186] = Class [357] 
.const [187] = NameAndType [358] [359] 
.const [188] = Class [360] 
.const [189] = NameAndType [361] [362] 
.const [190] = Class [363] 
.const [191] = NameAndType [364] [365] 
.const [192] = Utf8 de/esolutions/fw/comm/dsi/calendar/impl/VAlarmSerializer 
.const [193] = Utf8 putOptionalVAlarm 
.const [194] = Utf8 (Lde/esolutions/fw/util/serializer/ISerializer;Lorg/dsi/ifc/calendar/VAlarm;)V 
.const [195] = Utf8 de/esolutions/fw/comm/dsi/calendar/impl/VAttendeeSerializer 
.const [196] = Utf8 putOptionalVAttendeeVarArray 
.const [197] = Utf8 (Lde/esolutions/fw/util/serializer/ISerializer;[Lorg/dsi/ifc/calendar/VAttendee;)V 
.const [198] = Utf8 de/esolutions/fw/comm/dsi/calendar/impl/VAttendeeSerializer 
.const [199] = Utf8 putOptionalVAttendee 
.const [200] = Utf8 (Lde/esolutions/fw/util/serializer/ISerializer;Lorg/dsi/ifc/calendar/VAttendee;)V 
.const [201] = Utf8 de/esolutions/fw/comm/dsi/calendar/impl/VEventSerializer 
.const [202] = Utf8 putOptionalVEvent 
.const [203] = Utf8 (Lde/esolutions/fw/util/serializer/ISerializer;Lorg/dsi/ifc/calendar/VEvent;)V 
.const [204] = Utf8 de/esolutions/fw/comm/dsi/calendar/impl/VAlarmSerializer 
.const [205] = Utf8 getOptionalVAlarm 
.const [206] = Utf8 (Lde/esolutions/fw/util/serializer/IDeserializer;)Lorg/dsi/ifc/calendar/VAlarm; 
.const [207] = Utf8 de/esolutions/fw/comm/dsi/calendar/impl/VAttendeeSerializer 
.const [208] = Utf8 getOptionalVAttendeeVarArray 
.const [209] = Utf8 (Lde/esolutions/fw/util/serializer/IDeserializer;)[Lorg/dsi/ifc/calendar/VAttendee; 
.const [210] = Utf8 de/esolutions/fw/comm/dsi/calendar/impl/VAttendeeSerializer 
.const [211] = Utf8 getOptionalVAttendee 
.const [212] = Utf8 (Lde/esolutions/fw/util/serializer/IDeserializer;)Lorg/dsi/ifc/calendar/VAttendee; 
.const [213] = Utf8 de/esolutions/fw/comm/dsi/calendar/impl/VEventSerializer 
.const [214] = Utf8 getOptionalVEvent 
.const [215] = Utf8 (Lde/esolutions/fw/util/serializer/IDeserializer;)Lorg/dsi/ifc/calendar/VEvent; 
.const [216] = Utf8 org/dsi/ifc/calendar/VEvent 
.const [217] = Utf8 getAlarm 
.const [218] = Utf8 ()Lorg/dsi/ifc/calendar/VAlarm; 
.const [219] = Utf8 org/dsi/ifc/calendar/VEvent 
.const [220] = Utf8 getAttendeeList 
.const [221] = Utf8 ()[Lorg/dsi/ifc/calendar/VAttendee; 
.const [222] = Utf8 org/dsi/ifc/calendar/VEvent 
.const [223] = Utf8 getCategories 
.const [224] = Utf8 ()Ljava/lang/String; 
.const [225] = Utf8 org/dsi/ifc/calendar/VEvent 
.const [226] = Utf8 getClassTyp 
.const [227] = Utf8 ()Ljava/lang/String; 
.const [228] = Utf8 org/dsi/ifc/calendar/VEvent 
.const [229] = Utf8 getCreated 
.const [230] = Utf8 ()Ljava/lang/String; 
.const [231] = Utf8 org/dsi/ifc/calendar/VEvent 
.const [232] = Utf8 getDescription 
.const [233] = Utf8 ()Ljava/lang/String; 
.const [234] = Utf8 org/dsi/ifc/calendar/VEvent 
.const [235] = Utf8 getDtEnd 
.const [236] = Utf8 ()Ljava/lang/String; 
.const [237] = Utf8 org/dsi/ifc/calendar/VEvent 
.const [238] = Utf8 getDtStart 
.const [239] = Utf8 ()Ljava/lang/String; 
.const [240] = Utf8 org/dsi/ifc/calendar/VEvent 
.const [241] = Utf8 getDtStamp 
.const [242] = Utf8 ()Ljava/lang/String; 
.const [243] = Utf8 org/dsi/ifc/calendar/VEvent 
.const [244] = Utf8 getDuration 
.const [245] = Utf8 ()Ljava/lang/String; 
.const [246] = Utf8 org/dsi/ifc/calendar/VEvent 
.const [247] = Utf8 getLastModified 
.const [248] = Utf8 ()Ljava/lang/String; 
.const [249] = Utf8 org/dsi/ifc/calendar/VEvent 
.const [250] = Utf8 getLocation 
.const [251] = Utf8 ()Ljava/lang/String; 
.const [252] = Utf8 org/dsi/ifc/calendar/VEvent 
.const [253] = Utf8 getPriority 
.const [254] = Utf8 ()Ljava/lang/String; 
.const [255] = Utf8 org/dsi/ifc/calendar/VEvent 
.const [256] = Utf8 getOrganizer 
.const [257] = Utf8 ()Lorg/dsi/ifc/calendar/VAttendee; 
.const [258] = Utf8 org/dsi/ifc/calendar/VEvent 
.const [259] = Utf8 getSummary 
.const [260] = Utf8 ()Ljava/lang/String; 
.const [261] = Utf8 org/dsi/ifc/calendar/VEvent 
.const [262] = Utf8 getUid 
.const [263] = Utf8 ()Ljava/lang/String; 
.const [264] = Utf8 org/dsi/ifc/calendar/VEvent 
.const [265] = Utf8 getRrule 
.const [266] = Utf8 ()Ljava/lang/String; 
.const [267] = Utf8 org/dsi/ifc/calendar/VEvent 
.const [268] = Utf8 getSequence 
.const [269] = Utf8 ()Ljava/lang/String; 
.const [270] = Utf8 org/dsi/ifc/calendar/VEvent 
.const [271] = Utf8 getTransp 
.const [272] = Utf8 ()Ljava/lang/String; 
.const [273] = Utf8 org/dsi/ifc/calendar/VEvent 
.const [274] = Utf8 getUrl 
.const [275] = Utf8 ()Ljava/lang/String; 
.const [276] = Utf8 org/dsi/ifc/calendar/VEvent 
.const [277] = Utf8 getEntryType 
.const [278] = Utf8 ()Ljava/lang/String; 
.const [279] = Utf8 java/lang/Object 
.const [280] = Utf8 <init> 
.const [281] = Utf8 ()V 
.const [282] = Utf8 org/dsi/ifc/calendar/VEvent 
.const [283] = Utf8 <init> 
.const [284] = Utf8 ()V 
.const [285] = Utf8 de/esolutions/fw/util/serializer/ISerializer 
.const [286] = Utf8 putBool 
.const [287] = Utf8 (Z)V 
.const [288] = Utf8 de/esolutions/fw/util/serializer/ISerializer 
.const [289] = Utf8 putOptionalString 
.const [290] = Utf8 (Ljava/lang/String;)V 
.const [291] = Utf8 de/esolutions/fw/util/serializer/ISerializer 
.const [292] = Utf8 putInt32 
.const [293] = Utf8 (I)V 
.const [294] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [295] = Utf8 getBool 
.const [296] = Utf8 ()Z 
.const [297] = Utf8 org/dsi/ifc/calendar/VEvent 
.const [298] = Utf8 alarm 
.const [299] = Utf8 Lorg/dsi/ifc/calendar/VAlarm; 
.const [300] = Utf8 org/dsi/ifc/calendar/VEvent 
.const [301] = Utf8 attendeeList 
.const [302] = Utf8 [Lorg/dsi/ifc/calendar/VAttendee; 
.const [303] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [304] = Utf8 getOptionalString 
.const [305] = Utf8 ()Ljava/lang/String; 
.const [306] = Utf8 org/dsi/ifc/calendar/VEvent 
.const [307] = Utf8 categories 
.const [308] = Utf8 Ljava/lang/String; 
.const [309] = Utf8 org/dsi/ifc/calendar/VEvent 
.const [310] = Utf8 classTyp 
.const [311] = Utf8 Ljava/lang/String; 
.const [312] = Utf8 org/dsi/ifc/calendar/VEvent 
.const [313] = Utf8 created 
.const [314] = Utf8 Ljava/lang/String; 
.const [315] = Utf8 org/dsi/ifc/calendar/VEvent 
.const [316] = Utf8 description 
.const [317] = Utf8 Ljava/lang/String; 
.const [318] = Utf8 org/dsi/ifc/calendar/VEvent 
.const [319] = Utf8 dtEnd 
.const [320] = Utf8 Ljava/lang/String; 
.const [321] = Utf8 org/dsi/ifc/calendar/VEvent 
.const [322] = Utf8 dtStart 
.const [323] = Utf8 Ljava/lang/String; 
.const [324] = Utf8 org/dsi/ifc/calendar/VEvent 
.const [325] = Utf8 dtStamp 
.const [326] = Utf8 Ljava/lang/String; 
.const [327] = Utf8 org/dsi/ifc/calendar/VEvent 
.const [328] = Utf8 duration 
.const [329] = Utf8 Ljava/lang/String; 
.const [330] = Utf8 org/dsi/ifc/calendar/VEvent 
.const [331] = Utf8 lastModified 
.const [332] = Utf8 Ljava/lang/String; 
.const [333] = Utf8 org/dsi/ifc/calendar/VEvent 
.const [334] = Utf8 location 
.const [335] = Utf8 Ljava/lang/String; 
.const [336] = Utf8 org/dsi/ifc/calendar/VEvent 
.const [337] = Utf8 priority 
.const [338] = Utf8 Ljava/lang/String; 
.const [339] = Utf8 org/dsi/ifc/calendar/VEvent 
.const [340] = Utf8 organizer 
.const [341] = Utf8 Lorg/dsi/ifc/calendar/VAttendee; 
.const [342] = Utf8 org/dsi/ifc/calendar/VEvent 
.const [343] = Utf8 summary 
.const [344] = Utf8 Ljava/lang/String; 
.const [345] = Utf8 org/dsi/ifc/calendar/VEvent 
.const [346] = Utf8 uid 
.const [347] = Utf8 Ljava/lang/String; 
.const [348] = Utf8 org/dsi/ifc/calendar/VEvent 
.const [349] = Utf8 rrule 
.const [350] = Utf8 Ljava/lang/String; 
.const [351] = Utf8 org/dsi/ifc/calendar/VEvent 
.const [352] = Utf8 sequence 
.const [353] = Utf8 Ljava/lang/String; 
.const [354] = Utf8 org/dsi/ifc/calendar/VEvent 
.const [355] = Utf8 transp 
.const [356] = Utf8 Ljava/lang/String; 
.const [357] = Utf8 org/dsi/ifc/calendar/VEvent 
.const [358] = Utf8 url 
.const [359] = Utf8 Ljava/lang/String; 
.const [360] = Utf8 org/dsi/ifc/calendar/VEvent 
.const [361] = Utf8 entryType 
.const [362] = Utf8 Ljava/lang/String; 
.const [363] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [364] = Utf8 getInt32 
.const [365] = Utf8 ()I 
.const [366] = Utf8 de/esolutions/fw/comm/dsi/calendar/impl/VEventSerializer 
.const [367] = Class [366] 
.const [368] = Utf8 java/lang/Object 
.const [369] = Class [368] 
.const [370] = Utf8 Code 
.const [371] = Utf8 <init> 
.const [372] = Utf8 ()V 
.const [373] = Utf8 putOptionalVEvent 
.const [374] = Utf8 (Lde/esolutions/fw/util/serializer/ISerializer;Lorg/dsi/ifc/calendar/VEvent;)V 
.const [375] = Utf8 putOptionalVEventVarArray 
.const [376] = Utf8 (Lde/esolutions/fw/util/serializer/ISerializer;[Lorg/dsi/ifc/calendar/VEvent;)V 
.const [377] = Utf8 getOptionalVEvent 
.const [378] = Utf8 (Lde/esolutions/fw/util/serializer/IDeserializer;)Lorg/dsi/ifc/calendar/VEvent; 
.const [379] = Utf8 getOptionalVEventVarArray 
.const [380] = Utf8 (Lde/esolutions/fw/util/serializer/IDeserializer;)[Lorg/dsi/ifc/calendar/VEvent; 
.end class 
