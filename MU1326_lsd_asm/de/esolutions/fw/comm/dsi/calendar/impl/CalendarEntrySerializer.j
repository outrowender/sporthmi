.version 50 0 
.class public super [329] 
.super [331] 

.method public annotation [333] : [334] 
    .attribute [332] .code stack 1 locals 0 
L0:     aload_0 
L1:     invokespecial [30] 
L4:     return 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public static [335] : [336] 
    .attribute [332] .code stack 3 locals 20 
L0:     aload_1 
L1:     ifnonnull L8 
L4:     iconst_1 
L5:     goto L9 
L8:     iconst_0 
L9:     istore_2 
L10:    aload_0 
L11:    iload_2 
L12:    invokeinterface [32] 0 
L17:    iload_2 
L18:    ifne L263 
L21:    aload_1 
L22:    invokevirtual [12] 
L25:    lstore_3 
L26:    aload_0 
L27:    lload_3 
L28:    invokeinterface [33] 0 
L33:    aload_1 
L34:    invokevirtual [13] 
L37:    astore 5 
L39:    aload_0 
L40:    aload 5 
L42:    invokeinterface [34] 0 
L47:    aload_1 
L48:    invokevirtual [14] 
L51:    astore 6 
L53:    aload_0 
L54:    aload 6 
L56:    invokeinterface [34] 0 
L61:    aload_1 
L62:    invokevirtual [15] 
L65:    astore 7 
L67:    aload_0 
L68:    aload 7 
L70:    invokeinterface [34] 0 
L75:    aload_1 
L76:    invokevirtual [16] 
L79:    astore 8 
L81:    aload_0 
L82:    aload 8 
L84:    invokeinterface [35] 0 
L89:    aload_1 
L90:    invokevirtual [17] 
L93:    astore 9 
L95:    aload_0 
L96:    aload 9 
L98:    invokeinterface [34] 0 
L103:   aload_1 
L104:   invokevirtual [18] 
L107:   astore 10 
L109:   aload_0 
L110:   aload 10 
L112:   invokestatic [2] 
L115:   aload_1 
L116:   invokevirtual [19] 
L119:   astore 11 
L121:   aload_0 
L122:   aload 11 
L124:   invokestatic [2] 
L127:   aload_1 
L128:   invokevirtual [20] 
L131:   astore 12 
L133:   aload_0 
L134:   aload 12 
L136:   invokeinterface [34] 0 
L141:   aload_1 
L142:   invokevirtual [21] 
L145:   istore 13 
L147:   aload_0 
L148:   iload 13 
L150:   invokeinterface [36] 0 
L155:   aload_1 
L156:   invokevirtual [22] 
L159:   astore 14 
L161:   aload_0 
L162:   aload 14 
L164:   invokeinterface [34] 0 
L169:   aload_1 
L170:   invokevirtual [23] 
L173:   astore 15 
L175:   aload_0 
L176:   aload 15 
L178:   invokeinterface [35] 0 
L183:   aload_1 
L184:   invokevirtual [24] 
L187:   istore 16 
L189:   aload_0 
L190:   iload 16 
L192:   invokeinterface [36] 0 
L197:   aload_1 
L198:   invokevirtual [25] 
L201:   astore 17 
L203:   aload_0 
L204:   aload 17 
L206:   invokeinterface [34] 0 
L211:   aload_1 
L212:   invokevirtual [26] 
L215:   astore 18 
L217:   aload_0 
L218:   aload 18 
L220:   invokeinterface [34] 0 
L225:   aload_1 
L226:   invokevirtual [27] 
L229:   astore 19 
L231:   aload_0 
L232:   aload 19 
L234:   invokeinterface [34] 0 
L239:   aload_1 
L240:   invokevirtual [28] 
L243:   astore 20 
L245:   aload_0 
L246:   aload 20 
L248:   invokestatic [2] 
L251:   aload_1 
L252:   invokevirtual [29] 
L255:   astore 21 
L257:   aload_0 
L258:   aload 21 
L260:   invokestatic [2] 
L263:   return 
L264:   
    .end code 
.end method 

.method public static [337] : [338] 
    .attribute [332] .code stack 3 locals 2 
L0:     aload_1 
L1:     ifnonnull L8 
L4:     iconst_1 
L5:     goto L9 
L8:     iconst_0 
L9:     istore_2 
L10:    aload_0 
L11:    iload_2 
L12:    invokeinterface [32] 0 
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
L41:    invokestatic [3] 
L44:    iinc 3 1 
L47:    goto L31 
L50:    return 
L51:    nop 
L52:    
    .end code 
.end method 

.method public static [339] : [340] 
    .attribute [332] .code stack 3 locals 21 
L0:     aconst_null 
L1:     astore_1 
L2:     aload_0 
L3:     invokeinterface [37] 0 
L8:     istore_2 
L9:     iload_2 
L10:    ifne L263 
L13:    new [38] 
L16:    dup 
L17:    invokespecial [31] 
L20:    astore_1 
L21:    aload_0 
L22:    invokeinterface [39] 0 
L27:    lstore_3 
L28:    aload_1 
L29:    lload_3 
L30:    putfield [40] 
L33:    aload_0 
L34:    invokeinterface [41] 0 
L39:    astore 5 
L41:    aload_1 
L42:    aload 5 
L44:    putfield [42] 
L47:    aload_0 
L48:    invokeinterface [41] 0 
L53:    astore 6 
L55:    aload_1 
L56:    aload 6 
L58:    putfield [43] 
L61:    aload_0 
L62:    invokeinterface [41] 0 
L67:    astore 7 
L69:    aload_1 
L70:    aload 7 
L72:    putfield [44] 
L75:    aload_0 
L76:    invokeinterface [45] 0 
L81:    astore 8 
L83:    aload_1 
L84:    aload 8 
L86:    putfield [46] 
L89:    aload_0 
L90:    invokeinterface [41] 0 
L95:    astore 9 
L97:    aload_1 
L98:    aload 9 
L100:   putfield [47] 
L103:   aload_0 
L104:   invokestatic [5] 
L107:   astore 10 
L109:   aload_1 
L110:   aload 10 
L112:   putfield [48] 
L115:   aload_0 
L116:   invokestatic [5] 
L119:   astore 11 
L121:   aload_1 
L122:   aload 11 
L124:   putfield [49] 
L127:   aload_0 
L128:   invokeinterface [41] 0 
L133:   astore 12 
L135:   aload_1 
L136:   aload 12 
L138:   putfield [50] 
L141:   aload_0 
L142:   invokeinterface [51] 0 
L147:   istore 13 
L149:   aload_1 
L150:   iload 13 
L152:   putfield [52] 
L155:   aload_0 
L156:   invokeinterface [41] 0 
L161:   astore 14 
L163:   aload_1 
L164:   aload 14 
L166:   putfield [53] 
L169:   aload_0 
L170:   invokeinterface [45] 0 
L175:   astore 15 
L177:   aload_1 
L178:   aload 15 
L180:   putfield [54] 
L183:   aload_0 
L184:   invokeinterface [51] 0 
L189:   istore 16 
L191:   aload_1 
L192:   iload 16 
L194:   putfield [55] 
L197:   aload_0 
L198:   invokeinterface [41] 0 
L203:   astore 17 
L205:   aload_1 
L206:   aload 17 
L208:   putfield [56] 
L211:   aload_0 
L212:   invokeinterface [41] 0 
L217:   astore 18 
L219:   aload_1 
L220:   aload 18 
L222:   putfield [57] 
L225:   aload_0 
L226:   invokeinterface [41] 0 
L231:   astore 19 
L233:   aload_1 
L234:   aload 19 
L236:   putfield [58] 
L239:   aload_0 
L240:   invokestatic [5] 
L243:   astore 20 
L245:   aload_1 
L246:   aload 20 
L248:   putfield [59] 
L251:   aload_0 
L252:   invokestatic [5] 
L255:   astore 21 
L257:   aload_1 
L258:   aload 21 
L260:   putfield [60] 
L263:   aload_1 
L264:   areturn 
L265:   nop 
L266:   nop 
L267:   nop 
L268:   
    .end code 
.end method 

.method public static [341] : [342] 
    .attribute [332] .code stack 3 locals 4 
L0:     aconst_null 
L1:     astore_1 
L2:     aload_0 
L3:     invokeinterface [37] 0 
L8:     istore_2 
L9:     iload_2 
L10:    ifne L48 
L13:    aload_0 
L14:    invokeinterface [51] 0 
L19:    istore_3 
L20:    iload_3 
L21:    anewarray [4] 
L24:    astore_1 
L25:    iconst_0 
L26:    istore 4 
L28:    iload 4 
L30:    iload_3 
L31:    if_icmpge L48 
L34:    aload_1 
L35:    iload 4 
L37:    aload_0 
L38:    invokestatic [6] 
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
.const [2] = Method [61] [62] 
.const [3] = Method [63] [64] 
.const [4] = Class [65] 
.const [5] = Method [66] [67] 
.const [6] = Method [68] [69] 
.const [7] = Class [70] 
.const [8] = Class [71] 
.const [9] = Class [72] 
.const [10] = Class [73] 
.const [11] = Class [74] 
.const [12] = Method [75] [76] 
.const [13] = Method [77] [78] 
.const [14] = Method [79] [80] 
.const [15] = Method [81] [82] 
.const [16] = Method [83] [84] 
.const [17] = Method [85] [86] 
.const [18] = Method [87] [88] 
.const [19] = Method [89] [90] 
.const [20] = Method [91] [92] 
.const [21] = Method [93] [94] 
.const [22] = Method [95] [96] 
.const [23] = Method [97] [98] 
.const [24] = Method [99] [100] 
.const [25] = Method [101] [102] 
.const [26] = Method [103] [104] 
.const [27] = Method [105] [106] 
.const [28] = Method [107] [108] 
.const [29] = Method [109] [110] 
.const [30] = Method [111] [112] 
.const [31] = Method [113] [114] 
.const [32] = InterfaceMethod [115] [116] 
.const [33] = InterfaceMethod [117] [118] 
.const [34] = InterfaceMethod [119] [120] 
.const [35] = InterfaceMethod [121] [122] 
.const [36] = InterfaceMethod [123] [124] 
.const [37] = InterfaceMethod [125] [126] 
.const [38] = Class [127] 
.const [39] = InterfaceMethod [128] [129] 
.const [40] = Field [130] [131] 
.const [41] = InterfaceMethod [132] [133] 
.const [42] = Field [134] [135] 
.const [43] = Field [136] [137] 
.const [44] = Field [138] [139] 
.const [45] = InterfaceMethod [140] [141] 
.const [46] = Field [142] [143] 
.const [47] = Field [144] [145] 
.const [48] = Field [146] [147] 
.const [49] = Field [148] [149] 
.const [50] = Field [150] [151] 
.const [51] = InterfaceMethod [152] [153] 
.const [52] = Field [154] [155] 
.const [53] = Field [156] [157] 
.const [54] = Field [158] [159] 
.const [55] = Field [160] [161] 
.const [56] = Field [162] [163] 
.const [57] = Field [164] [165] 
.const [58] = Field [166] [167] 
.const [59] = Field [168] [169] 
.const [60] = Field [170] [171] 
.const [61] = Class [172] 
.const [62] = NameAndType [173] [174] 
.const [63] = Class [175] 
.const [64] = NameAndType [176] [177] 
.const [65] = Utf8 org/dsi/ifc/calendar/CalendarEntry 
.const [66] = Class [178] 
.const [67] = NameAndType [179] [180] 
.const [68] = Class [181] 
.const [69] = NameAndType [182] [183] 
.const [70] = Utf8 de/esolutions/fw/comm/dsi/calendar/impl/CalendarEntrySerializer 
.const [71] = Utf8 java/lang/Object 
.const [72] = Utf8 de/esolutions/fw/util/serializer/ISerializer 
.const [73] = Utf8 de/esolutions/fw/comm/dsi/global/impl/DateTimeSerializer 
.const [74] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [75] = Class [184] 
.const [76] = NameAndType [185] [186] 
.const [77] = Class [187] 
.const [78] = NameAndType [188] [189] 
.const [79] = Class [190] 
.const [80] = NameAndType [191] [192] 
.const [81] = Class [193] 
.const [82] = NameAndType [194] [195] 
.const [83] = Class [196] 
.const [84] = NameAndType [197] [198] 
.const [85] = Class [199] 
.const [86] = NameAndType [200] [201] 
.const [87] = Class [202] 
.const [88] = NameAndType [203] [204] 
.const [89] = Class [205] 
.const [90] = NameAndType [206] [207] 
.const [91] = Class [208] 
.const [92] = NameAndType [209] [210] 
.const [93] = Class [211] 
.const [94] = NameAndType [212] [213] 
.const [95] = Class [214] 
.const [96] = NameAndType [215] [216] 
.const [97] = Class [217] 
.const [98] = NameAndType [218] [219] 
.const [99] = Class [220] 
.const [100] = NameAndType [221] [222] 
.const [101] = Class [223] 
.const [102] = NameAndType [224] [225] 
.const [103] = Class [226] 
.const [104] = NameAndType [227] [228] 
.const [105] = Class [229] 
.const [106] = NameAndType [230] [231] 
.const [107] = Class [232] 
.const [108] = NameAndType [233] [234] 
.const [109] = Class [235] 
.const [110] = NameAndType [236] [237] 
.const [111] = Class [238] 
.const [112] = NameAndType [239] [240] 
.const [113] = Class [241] 
.const [114] = NameAndType [242] [243] 
.const [115] = Class [244] 
.const [116] = NameAndType [245] [246] 
.const [117] = Class [247] 
.const [118] = NameAndType [248] [249] 
.const [119] = Class [250] 
.const [120] = NameAndType [251] [252] 
.const [121] = Class [253] 
.const [122] = NameAndType [254] [255] 
.const [123] = Class [256] 
.const [124] = NameAndType [257] [258] 
.const [125] = Class [259] 
.const [126] = NameAndType [260] [261] 
.const [127] = Utf8 org/dsi/ifc/calendar/CalendarEntry 
.const [128] = Class [262] 
.const [129] = NameAndType [263] [264] 
.const [130] = Class [265] 
.const [131] = NameAndType [266] [267] 
.const [132] = Class [268] 
.const [133] = NameAndType [269] [270] 
.const [134] = Class [271] 
.const [135] = NameAndType [272] [273] 
.const [136] = Class [274] 
.const [137] = NameAndType [275] [276] 
.const [138] = Class [277] 
.const [139] = NameAndType [278] [279] 
.const [140] = Class [280] 
.const [141] = NameAndType [281] [282] 
.const [142] = Class [283] 
.const [143] = NameAndType [284] [285] 
.const [144] = Class [286] 
.const [145] = NameAndType [287] [288] 
.const [146] = Class [289] 
.const [147] = NameAndType [290] [291] 
.const [148] = Class [292] 
.const [149] = NameAndType [293] [294] 
.const [150] = Class [295] 
.const [151] = NameAndType [296] [297] 
.const [152] = Class [298] 
.const [153] = NameAndType [299] [300] 
.const [154] = Class [301] 
.const [155] = NameAndType [302] [303] 
.const [156] = Class [304] 
.const [157] = NameAndType [305] [306] 
.const [158] = Class [307] 
.const [159] = NameAndType [308] [309] 
.const [160] = Class [310] 
.const [161] = NameAndType [311] [312] 
.const [162] = Class [313] 
.const [163] = NameAndType [314] [315] 
.const [164] = Class [316] 
.const [165] = NameAndType [317] [318] 
.const [166] = Class [319] 
.const [167] = NameAndType [320] [321] 
.const [168] = Class [322] 
.const [169] = NameAndType [323] [324] 
.const [170] = Class [325] 
.const [171] = NameAndType [326] [327] 
.const [172] = Utf8 de/esolutions/fw/comm/dsi/global/impl/DateTimeSerializer 
.const [173] = Utf8 putOptionalDateTime 
.const [174] = Utf8 (Lde/esolutions/fw/util/serializer/ISerializer;Lorg/dsi/ifc/global/DateTime;)V 
.const [175] = Utf8 de/esolutions/fw/comm/dsi/calendar/impl/CalendarEntrySerializer 
.const [176] = Utf8 putOptionalCalendarEntry 
.const [177] = Utf8 (Lde/esolutions/fw/util/serializer/ISerializer;Lorg/dsi/ifc/calendar/CalendarEntry;)V 
.const [178] = Utf8 de/esolutions/fw/comm/dsi/global/impl/DateTimeSerializer 
.const [179] = Utf8 getOptionalDateTime 
.const [180] = Utf8 (Lde/esolutions/fw/util/serializer/IDeserializer;)Lorg/dsi/ifc/global/DateTime; 
.const [181] = Utf8 de/esolutions/fw/comm/dsi/calendar/impl/CalendarEntrySerializer 
.const [182] = Utf8 getOptionalCalendarEntry 
.const [183] = Utf8 (Lde/esolutions/fw/util/serializer/IDeserializer;)Lorg/dsi/ifc/calendar/CalendarEntry; 
.const [184] = Utf8 org/dsi/ifc/calendar/CalendarEntry 
.const [185] = Utf8 getEventID 
.const [186] = Utf8 ()J 
.const [187] = Utf8 org/dsi/ifc/calendar/CalendarEntry 
.const [188] = Utf8 getOrganizer 
.const [189] = Utf8 ()Ljava/lang/String; 
.const [190] = Utf8 org/dsi/ifc/calendar/CalendarEntry 
.const [191] = Utf8 getSummary 
.const [192] = Utf8 ()Ljava/lang/String; 
.const [193] = Utf8 org/dsi/ifc/calendar/CalendarEntry 
.const [194] = Utf8 getLocation 
.const [195] = Utf8 ()Ljava/lang/String; 
.const [196] = Utf8 org/dsi/ifc/calendar/CalendarEntry 
.const [197] = Utf8 getAttendee 
.const [198] = Utf8 ()[Ljava/lang/String; 
.const [199] = Utf8 org/dsi/ifc/calendar/CalendarEntry 
.const [200] = Utf8 getDescription 
.const [201] = Utf8 ()Ljava/lang/String; 
.const [202] = Utf8 org/dsi/ifc/calendar/CalendarEntry 
.const [203] = Utf8 getStart 
.const [204] = Utf8 ()Lorg/dsi/ifc/global/DateTime; 
.const [205] = Utf8 org/dsi/ifc/calendar/CalendarEntry 
.const [206] = Utf8 getEnd 
.const [207] = Utf8 ()Lorg/dsi/ifc/global/DateTime; 
.const [208] = Utf8 org/dsi/ifc/calendar/CalendarEntry 
.const [209] = Utf8 getEntryClass 
.const [210] = Utf8 ()Ljava/lang/String; 
.const [211] = Utf8 org/dsi/ifc/calendar/CalendarEntry 
.const [212] = Utf8 getPriority 
.const [213] = Utf8 ()I 
.const [214] = Utf8 org/dsi/ifc/calendar/CalendarEntry 
.const [215] = Utf8 getStatus 
.const [216] = Utf8 ()Ljava/lang/String; 
.const [217] = Utf8 org/dsi/ifc/calendar/CalendarEntry 
.const [218] = Utf8 getCategories 
.const [219] = Utf8 ()[Ljava/lang/String; 
.const [220] = Utf8 org/dsi/ifc/calendar/CalendarEntry 
.const [221] = Utf8 getSequence 
.const [222] = Utf8 ()I 
.const [223] = Utf8 org/dsi/ifc/calendar/CalendarEntry 
.const [224] = Utf8 getProdID 
.const [225] = Utf8 ()Ljava/lang/String; 
.const [226] = Utf8 org/dsi/ifc/calendar/CalendarEntry 
.const [227] = Utf8 getIcalUID 
.const [228] = Utf8 ()Ljava/lang/String; 
.const [229] = Utf8 org/dsi/ifc/calendar/CalendarEntry 
.const [230] = Utf8 getVersion 
.const [231] = Utf8 ()Ljava/lang/String; 
.const [232] = Utf8 org/dsi/ifc/calendar/CalendarEntry 
.const [233] = Utf8 getCreated 
.const [234] = Utf8 ()Lorg/dsi/ifc/global/DateTime; 
.const [235] = Utf8 org/dsi/ifc/calendar/CalendarEntry 
.const [236] = Utf8 getLastModified 
.const [237] = Utf8 ()Lorg/dsi/ifc/global/DateTime; 
.const [238] = Utf8 java/lang/Object 
.const [239] = Utf8 <init> 
.const [240] = Utf8 ()V 
.const [241] = Utf8 org/dsi/ifc/calendar/CalendarEntry 
.const [242] = Utf8 <init> 
.const [243] = Utf8 ()V 
.const [244] = Utf8 de/esolutions/fw/util/serializer/ISerializer 
.const [245] = Utf8 putBool 
.const [246] = Utf8 (Z)V 
.const [247] = Utf8 de/esolutions/fw/util/serializer/ISerializer 
.const [248] = Utf8 putInt64 
.const [249] = Utf8 (J)V 
.const [250] = Utf8 de/esolutions/fw/util/serializer/ISerializer 
.const [251] = Utf8 putOptionalString 
.const [252] = Utf8 (Ljava/lang/String;)V 
.const [253] = Utf8 de/esolutions/fw/util/serializer/ISerializer 
.const [254] = Utf8 putOptionalStringVarArray 
.const [255] = Utf8 ([Ljava/lang/String;)V 
.const [256] = Utf8 de/esolutions/fw/util/serializer/ISerializer 
.const [257] = Utf8 putInt32 
.const [258] = Utf8 (I)V 
.const [259] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [260] = Utf8 getBool 
.const [261] = Utf8 ()Z 
.const [262] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [263] = Utf8 getInt64 
.const [264] = Utf8 ()J 
.const [265] = Utf8 org/dsi/ifc/calendar/CalendarEntry 
.const [266] = Utf8 eventID 
.const [267] = Utf8 J 
.const [268] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [269] = Utf8 getOptionalString 
.const [270] = Utf8 ()Ljava/lang/String; 
.const [271] = Utf8 org/dsi/ifc/calendar/CalendarEntry 
.const [272] = Utf8 organizer 
.const [273] = Utf8 Ljava/lang/String; 
.const [274] = Utf8 org/dsi/ifc/calendar/CalendarEntry 
.const [275] = Utf8 summary 
.const [276] = Utf8 Ljava/lang/String; 
.const [277] = Utf8 org/dsi/ifc/calendar/CalendarEntry 
.const [278] = Utf8 location 
.const [279] = Utf8 Ljava/lang/String; 
.const [280] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [281] = Utf8 getOptionalStringVarArray 
.const [282] = Utf8 ()[Ljava/lang/String; 
.const [283] = Utf8 org/dsi/ifc/calendar/CalendarEntry 
.const [284] = Utf8 attendee 
.const [285] = Utf8 [Ljava/lang/String; 
.const [286] = Utf8 org/dsi/ifc/calendar/CalendarEntry 
.const [287] = Utf8 description 
.const [288] = Utf8 Ljava/lang/String; 
.const [289] = Utf8 org/dsi/ifc/calendar/CalendarEntry 
.const [290] = Utf8 start 
.const [291] = Utf8 Lorg/dsi/ifc/global/DateTime; 
.const [292] = Utf8 org/dsi/ifc/calendar/CalendarEntry 
.const [293] = Utf8 end 
.const [294] = Utf8 Lorg/dsi/ifc/global/DateTime; 
.const [295] = Utf8 org/dsi/ifc/calendar/CalendarEntry 
.const [296] = Utf8 entryClass 
.const [297] = Utf8 Ljava/lang/String; 
.const [298] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [299] = Utf8 getInt32 
.const [300] = Utf8 ()I 
.const [301] = Utf8 org/dsi/ifc/calendar/CalendarEntry 
.const [302] = Utf8 priority 
.const [303] = Utf8 I 
.const [304] = Utf8 org/dsi/ifc/calendar/CalendarEntry 
.const [305] = Utf8 status 
.const [306] = Utf8 Ljava/lang/String; 
.const [307] = Utf8 org/dsi/ifc/calendar/CalendarEntry 
.const [308] = Utf8 categories 
.const [309] = Utf8 [Ljava/lang/String; 
.const [310] = Utf8 org/dsi/ifc/calendar/CalendarEntry 
.const [311] = Utf8 sequence 
.const [312] = Utf8 I 
.const [313] = Utf8 org/dsi/ifc/calendar/CalendarEntry 
.const [314] = Utf8 prodID 
.const [315] = Utf8 Ljava/lang/String; 
.const [316] = Utf8 org/dsi/ifc/calendar/CalendarEntry 
.const [317] = Utf8 icalUID 
.const [318] = Utf8 Ljava/lang/String; 
.const [319] = Utf8 org/dsi/ifc/calendar/CalendarEntry 
.const [320] = Utf8 version 
.const [321] = Utf8 Ljava/lang/String; 
.const [322] = Utf8 org/dsi/ifc/calendar/CalendarEntry 
.const [323] = Utf8 created 
.const [324] = Utf8 Lorg/dsi/ifc/global/DateTime; 
.const [325] = Utf8 org/dsi/ifc/calendar/CalendarEntry 
.const [326] = Utf8 lastModified 
.const [327] = Utf8 Lorg/dsi/ifc/global/DateTime; 
.const [328] = Utf8 de/esolutions/fw/comm/dsi/calendar/impl/CalendarEntrySerializer 
.const [329] = Class [328] 
.const [330] = Utf8 java/lang/Object 
.const [331] = Class [330] 
.const [332] = Utf8 Code 
.const [333] = Utf8 <init> 
.const [334] = Utf8 ()V 
.const [335] = Utf8 putOptionalCalendarEntry 
.const [336] = Utf8 (Lde/esolutions/fw/util/serializer/ISerializer;Lorg/dsi/ifc/calendar/CalendarEntry;)V 
.const [337] = Utf8 putOptionalCalendarEntryVarArray 
.const [338] = Utf8 (Lde/esolutions/fw/util/serializer/ISerializer;[Lorg/dsi/ifc/calendar/CalendarEntry;)V 
.const [339] = Utf8 getOptionalCalendarEntry 
.const [340] = Utf8 (Lde/esolutions/fw/util/serializer/IDeserializer;)Lorg/dsi/ifc/calendar/CalendarEntry; 
.const [341] = Utf8 getOptionalCalendarEntryVarArray 
.const [342] = Utf8 (Lde/esolutions/fw/util/serializer/IDeserializer;)[Lorg/dsi/ifc/calendar/CalendarEntry; 
.end class 
