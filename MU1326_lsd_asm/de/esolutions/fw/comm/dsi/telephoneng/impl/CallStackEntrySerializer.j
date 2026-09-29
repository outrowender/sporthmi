.version 50 0 
.class public super [353] 
.super [355] 

.method public annotation [357] : [358] 
    .attribute [356] .code stack 1 locals 0 
L0:     aload_0 
L1:     invokespecial [32] 
L4:     return 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public static [359] : [360] 
    .attribute [356] .code stack 3 locals 22 
L0:     aload_1 
L1:     ifnonnull L8 
L4:     iconst_1 
L5:     goto L9 
L8:     iconst_0 
L9:     istore_2 
L10:    aload_0 
L11:    iload_2 
L12:    invokeinterface [34] 0 
L17:    iload_2 
L18:    ifne L297 
L21:    aload_1 
L22:    invokevirtual [12] 
L25:    istore_3 
L26:    aload_0 
L27:    iload_3 
L28:    invokeinterface [35] 0 
L33:    aload_1 
L34:    invokevirtual [13] 
L37:    astore 4 
L39:    aload_0 
L40:    aload 4 
L42:    invokeinterface [36] 0 
L47:    aload_1 
L48:    invokevirtual [14] 
L51:    astore 5 
L53:    aload_0 
L54:    aload 5 
L56:    invokeinterface [36] 0 
L61:    aload_1 
L62:    invokevirtual [15] 
L65:    astore 6 
L67:    aload_0 
L68:    aload 6 
L70:    invokeinterface [36] 0 
L75:    aload_1 
L76:    invokevirtual [16] 
L79:    astore 7 
L81:    aload_0 
L82:    aload 7 
L84:    invokeinterface [36] 0 
L89:    aload_1 
L90:    invokevirtual [17] 
L93:    astore 8 
L95:    aload_0 
L96:    aload 8 
L98:    invokeinterface [36] 0 
L103:   aload_1 
L104:   invokevirtual [18] 
L107:   istore 9 
L109:   aload_0 
L110:   iload 9 
L112:   invokeinterface [35] 0 
L117:   aload_1 
L118:   invokevirtual [19] 
L121:   istore 10 
L123:   aload_0 
L124:   iload 10 
L126:   invokeinterface [35] 0 
L131:   aload_1 
L132:   invokevirtual [20] 
L135:   istore 11 
L137:   aload_0 
L138:   iload 11 
L140:   invokeinterface [37] 0 
L145:   aload_1 
L146:   invokevirtual [21] 
L149:   istore 12 
L151:   aload_0 
L152:   iload 12 
L154:   invokeinterface [37] 0 
L159:   aload_1 
L160:   invokevirtual [22] 
L163:   istore 13 
L165:   aload_0 
L166:   iload 13 
L168:   invokeinterface [37] 0 
L173:   aload_1 
L174:   invokevirtual [23] 
L177:   istore 14 
L179:   aload_0 
L180:   iload 14 
L182:   invokeinterface [37] 0 
L187:   aload_1 
L188:   invokevirtual [24] 
L191:   istore 15 
L193:   aload_0 
L194:   iload 15 
L196:   invokeinterface [37] 0 
L201:   aload_1 
L202:   invokevirtual [25] 
L205:   istore 16 
L207:   aload_0 
L208:   iload 16 
L210:   invokeinterface [37] 0 
L215:   aload_1 
L216:   invokevirtual [26] 
L219:   astore 17 
L221:   aload_0 
L222:   aload 17 
L224:   invokestatic [2] 
L227:   aload_1 
L228:   invokevirtual [27] 
L231:   lstore 18 
L233:   aload_0 
L234:   lload 18 
L236:   invokeinterface [38] 0 
L241:   aload_1 
L242:   invokevirtual [28] 
L245:   istore 20 
L247:   aload_0 
L248:   iload 20 
L250:   invokeinterface [35] 0 
L255:   aload_1 
L256:   invokevirtual [29] 
L259:   istore 21 
L261:   aload_0 
L262:   iload 21 
L264:   invokeinterface [35] 0 
L269:   aload_1 
L270:   invokevirtual [30] 
L273:   istore 22 
L275:   aload_0 
L276:   iload 22 
L278:   invokeinterface [35] 0 
L283:   aload_1 
L284:   invokevirtual [31] 
L287:   istore 23 
L289:   aload_0 
L290:   iload 23 
L292:   invokeinterface [35] 0 
L297:   return 
L298:   nop 
L299:   nop 
L300:   
    .end code 
.end method 

.method public static [361] : [362] 
    .attribute [356] .code stack 3 locals 2 
L0:     aload_1 
L1:     ifnonnull L8 
L4:     iconst_1 
L5:     goto L9 
L8:     iconst_0 
L9:     istore_2 
L10:    aload_0 
L11:    iload_2 
L12:    invokeinterface [34] 0 
L17:    iload_2 
L18:    ifne L50 
L21:    aload_0 
L22:    aload_1 
L23:    arraylength 
L24:    invokeinterface [35] 0 
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

.method public static [363] : [364] 
    .attribute [356] .code stack 3 locals 23 
L0:     aconst_null 
L1:     astore_1 
L2:     aload_0 
L3:     invokeinterface [39] 0 
L8:     istore_2 
L9:     iload_2 
L10:    ifne L297 
L13:    new [40] 
L16:    dup 
L17:    invokespecial [33] 
L20:    astore_1 
L21:    aload_0 
L22:    invokeinterface [41] 0 
L27:    istore_3 
L28:    aload_1 
L29:    iload_3 
L30:    putfield [42] 
L33:    aload_0 
L34:    invokeinterface [43] 0 
L39:    astore 4 
L41:    aload_1 
L42:    aload 4 
L44:    putfield [44] 
L47:    aload_0 
L48:    invokeinterface [43] 0 
L53:    astore 5 
L55:    aload_1 
L56:    aload 5 
L58:    putfield [45] 
L61:    aload_0 
L62:    invokeinterface [43] 0 
L67:    astore 6 
L69:    aload_1 
L70:    aload 6 
L72:    putfield [46] 
L75:    aload_0 
L76:    invokeinterface [43] 0 
L81:    astore 7 
L83:    aload_1 
L84:    aload 7 
L86:    putfield [47] 
L89:    aload_0 
L90:    invokeinterface [43] 0 
L95:    astore 8 
L97:    aload_1 
L98:    aload 8 
L100:   putfield [48] 
L103:   aload_0 
L104:   invokeinterface [41] 0 
L109:   istore 9 
L111:   aload_1 
L112:   iload 9 
L114:   putfield [49] 
L117:   aload_0 
L118:   invokeinterface [41] 0 
L123:   istore 10 
L125:   aload_1 
L126:   iload 10 
L128:   putfield [50] 
L131:   aload_0 
L132:   invokeinterface [51] 0 
L137:   istore 11 
L139:   aload_1 
L140:   iload 11 
L142:   putfield [52] 
L145:   aload_0 
L146:   invokeinterface [51] 0 
L151:   istore 12 
L153:   aload_1 
L154:   iload 12 
L156:   putfield [53] 
L159:   aload_0 
L160:   invokeinterface [51] 0 
L165:   istore 13 
L167:   aload_1 
L168:   iload 13 
L170:   putfield [54] 
L173:   aload_0 
L174:   invokeinterface [51] 0 
L179:   istore 14 
L181:   aload_1 
L182:   iload 14 
L184:   putfield [55] 
L187:   aload_0 
L188:   invokeinterface [51] 0 
L193:   istore 15 
L195:   aload_1 
L196:   iload 15 
L198:   putfield [56] 
L201:   aload_0 
L202:   invokeinterface [51] 0 
L207:   istore 16 
L209:   aload_1 
L210:   iload 16 
L212:   putfield [57] 
L215:   aload_0 
L216:   invokestatic [5] 
L219:   astore 17 
L221:   aload_1 
L222:   aload 17 
L224:   putfield [58] 
L227:   aload_0 
L228:   invokeinterface [59] 0 
L233:   lstore 18 
L235:   aload_1 
L236:   lload 18 
L238:   putfield [60] 
L241:   aload_0 
L242:   invokeinterface [41] 0 
L247:   istore 20 
L249:   aload_1 
L250:   iload 20 
L252:   putfield [61] 
L255:   aload_0 
L256:   invokeinterface [41] 0 
L261:   istore 21 
L263:   aload_1 
L264:   iload 21 
L266:   putfield [62] 
L269:   aload_0 
L270:   invokeinterface [41] 0 
L275:   istore 22 
L277:   aload_1 
L278:   iload 22 
L280:   putfield [63] 
L283:   aload_0 
L284:   invokeinterface [41] 0 
L289:   istore 23 
L291:   aload_1 
L292:   iload 23 
L294:   putfield [64] 
L297:   aload_1 
L298:   areturn 
L299:   nop 
L300:   
    .end code 
.end method 

.method public static [365] : [366] 
    .attribute [356] .code stack 3 locals 4 
L0:     aconst_null 
L1:     astore_1 
L2:     aload_0 
L3:     invokeinterface [39] 0 
L8:     istore_2 
L9:     iload_2 
L10:    ifne L48 
L13:    aload_0 
L14:    invokeinterface [41] 0 
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
.const [2] = Method [65] [66] 
.const [3] = Method [67] [68] 
.const [4] = Class [69] 
.const [5] = Method [70] [71] 
.const [6] = Method [72] [73] 
.const [7] = Class [74] 
.const [8] = Class [75] 
.const [9] = Class [76] 
.const [10] = Class [77] 
.const [11] = Class [78] 
.const [12] = Method [79] [80] 
.const [13] = Method [81] [82] 
.const [14] = Method [83] [84] 
.const [15] = Method [85] [86] 
.const [16] = Method [87] [88] 
.const [17] = Method [89] [90] 
.const [18] = Method [91] [92] 
.const [19] = Method [93] [94] 
.const [20] = Method [95] [96] 
.const [21] = Method [97] [98] 
.const [22] = Method [99] [100] 
.const [23] = Method [101] [102] 
.const [24] = Method [103] [104] 
.const [25] = Method [105] [106] 
.const [26] = Method [107] [108] 
.const [27] = Method [109] [110] 
.const [28] = Method [111] [112] 
.const [29] = Method [113] [114] 
.const [30] = Method [115] [116] 
.const [31] = Method [117] [118] 
.const [32] = Method [119] [120] 
.const [33] = Method [121] [122] 
.const [34] = InterfaceMethod [123] [124] 
.const [35] = InterfaceMethod [125] [126] 
.const [36] = InterfaceMethod [127] [128] 
.const [37] = InterfaceMethod [129] [130] 
.const [38] = InterfaceMethod [131] [132] 
.const [39] = InterfaceMethod [133] [134] 
.const [40] = Class [135] 
.const [41] = InterfaceMethod [136] [137] 
.const [42] = Field [138] [139] 
.const [43] = InterfaceMethod [140] [141] 
.const [44] = Field [142] [143] 
.const [45] = Field [144] [145] 
.const [46] = Field [146] [147] 
.const [47] = Field [148] [149] 
.const [48] = Field [150] [151] 
.const [49] = Field [152] [153] 
.const [50] = Field [154] [155] 
.const [51] = InterfaceMethod [156] [157] 
.const [52] = Field [158] [159] 
.const [53] = Field [160] [161] 
.const [54] = Field [162] [163] 
.const [55] = Field [164] [165] 
.const [56] = Field [166] [167] 
.const [57] = Field [168] [169] 
.const [58] = Field [170] [171] 
.const [59] = InterfaceMethod [172] [173] 
.const [60] = Field [174] [175] 
.const [61] = Field [176] [177] 
.const [62] = Field [178] [179] 
.const [63] = Field [180] [181] 
.const [64] = Field [182] [183] 
.const [65] = Class [184] 
.const [66] = NameAndType [185] [186] 
.const [67] = Class [187] 
.const [68] = NameAndType [188] [189] 
.const [69] = Utf8 org/dsi/ifc/telephoneng/CallStackEntry 
.const [70] = Class [190] 
.const [71] = NameAndType [191] [192] 
.const [72] = Class [193] 
.const [73] = NameAndType [194] [195] 
.const [74] = Utf8 de/esolutions/fw/comm/dsi/telephoneng/impl/CallStackEntrySerializer 
.const [75] = Utf8 java/lang/Object 
.const [76] = Utf8 de/esolutions/fw/util/serializer/ISerializer 
.const [77] = Utf8 de/esolutions/fw/comm/dsi/global/impl/ResourceLocatorSerializer 
.const [78] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [79] = Class [196] 
.const [80] = NameAndType [197] [198] 
.const [81] = Class [199] 
.const [82] = NameAndType [200] [201] 
.const [83] = Class [202] 
.const [84] = NameAndType [203] [204] 
.const [85] = Class [205] 
.const [86] = NameAndType [206] [207] 
.const [87] = Class [208] 
.const [88] = NameAndType [209] [210] 
.const [89] = Class [211] 
.const [90] = NameAndType [212] [213] 
.const [91] = Class [214] 
.const [92] = NameAndType [215] [216] 
.const [93] = Class [217] 
.const [94] = NameAndType [218] [219] 
.const [95] = Class [220] 
.const [96] = NameAndType [221] [222] 
.const [97] = Class [223] 
.const [98] = NameAndType [224] [225] 
.const [99] = Class [226] 
.const [100] = NameAndType [227] [228] 
.const [101] = Class [229] 
.const [102] = NameAndType [230] [231] 
.const [103] = Class [232] 
.const [104] = NameAndType [233] [234] 
.const [105] = Class [235] 
.const [106] = NameAndType [236] [237] 
.const [107] = Class [238] 
.const [108] = NameAndType [239] [240] 
.const [109] = Class [241] 
.const [110] = NameAndType [242] [243] 
.const [111] = Class [244] 
.const [112] = NameAndType [245] [246] 
.const [113] = Class [247] 
.const [114] = NameAndType [248] [249] 
.const [115] = Class [250] 
.const [116] = NameAndType [251] [252] 
.const [117] = Class [253] 
.const [118] = NameAndType [254] [255] 
.const [119] = Class [256] 
.const [120] = NameAndType [257] [258] 
.const [121] = Class [259] 
.const [122] = NameAndType [260] [261] 
.const [123] = Class [262] 
.const [124] = NameAndType [263] [264] 
.const [125] = Class [265] 
.const [126] = NameAndType [266] [267] 
.const [127] = Class [268] 
.const [128] = NameAndType [269] [270] 
.const [129] = Class [271] 
.const [130] = NameAndType [272] [273] 
.const [131] = Class [274] 
.const [132] = NameAndType [275] [276] 
.const [133] = Class [277] 
.const [134] = NameAndType [278] [279] 
.const [135] = Utf8 org/dsi/ifc/telephoneng/CallStackEntry 
.const [136] = Class [280] 
.const [137] = NameAndType [281] [282] 
.const [138] = Class [283] 
.const [139] = NameAndType [284] [285] 
.const [140] = Class [286] 
.const [141] = NameAndType [287] [288] 
.const [142] = Class [289] 
.const [143] = NameAndType [290] [291] 
.const [144] = Class [292] 
.const [145] = NameAndType [293] [294] 
.const [146] = Class [295] 
.const [147] = NameAndType [296] [297] 
.const [148] = Class [298] 
.const [149] = NameAndType [299] [300] 
.const [150] = Class [301] 
.const [151] = NameAndType [302] [303] 
.const [152] = Class [304] 
.const [153] = NameAndType [305] [306] 
.const [154] = Class [307] 
.const [155] = NameAndType [308] [309] 
.const [156] = Class [310] 
.const [157] = NameAndType [311] [312] 
.const [158] = Class [313] 
.const [159] = NameAndType [314] [315] 
.const [160] = Class [316] 
.const [161] = NameAndType [317] [318] 
.const [162] = Class [319] 
.const [163] = NameAndType [320] [321] 
.const [164] = Class [322] 
.const [165] = NameAndType [323] [324] 
.const [166] = Class [325] 
.const [167] = NameAndType [326] [327] 
.const [168] = Class [328] 
.const [169] = NameAndType [329] [330] 
.const [170] = Class [331] 
.const [171] = NameAndType [332] [333] 
.const [172] = Class [334] 
.const [173] = NameAndType [335] [336] 
.const [174] = Class [337] 
.const [175] = NameAndType [338] [339] 
.const [176] = Class [340] 
.const [177] = NameAndType [341] [342] 
.const [178] = Class [343] 
.const [179] = NameAndType [344] [345] 
.const [180] = Class [346] 
.const [181] = NameAndType [347] [348] 
.const [182] = Class [349] 
.const [183] = NameAndType [350] [351] 
.const [184] = Utf8 de/esolutions/fw/comm/dsi/global/impl/ResourceLocatorSerializer 
.const [185] = Utf8 putOptionalResourceLocator 
.const [186] = Utf8 (Lde/esolutions/fw/util/serializer/ISerializer;Lorg/dsi/ifc/global/ResourceLocator;)V 
.const [187] = Utf8 de/esolutions/fw/comm/dsi/telephoneng/impl/CallStackEntrySerializer 
.const [188] = Utf8 putOptionalCallStackEntry 
.const [189] = Utf8 (Lde/esolutions/fw/util/serializer/ISerializer;Lorg/dsi/ifc/telephoneng/CallStackEntry;)V 
.const [190] = Utf8 de/esolutions/fw/comm/dsi/global/impl/ResourceLocatorSerializer 
.const [191] = Utf8 getOptionalResourceLocator 
.const [192] = Utf8 (Lde/esolutions/fw/util/serializer/IDeserializer;)Lorg/dsi/ifc/global/ResourceLocator; 
.const [193] = Utf8 de/esolutions/fw/comm/dsi/telephoneng/impl/CallStackEntrySerializer 
.const [194] = Utf8 getOptionalCallStackEntry 
.const [195] = Utf8 (Lde/esolutions/fw/util/serializer/IDeserializer;)Lorg/dsi/ifc/telephoneng/CallStackEntry; 
.const [196] = Utf8 org/dsi/ifc/telephoneng/CallStackEntry 
.const [197] = Utf8 getClEntryID 
.const [198] = Utf8 ()I 
.const [199] = Utf8 org/dsi/ifc/telephoneng/CallStackEntry 
.const [200] = Utf8 getClNumber 
.const [201] = Utf8 ()Ljava/lang/String; 
.const [202] = Utf8 org/dsi/ifc/telephoneng/CallStackEntry 
.const [203] = Utf8 getClName 
.const [204] = Utf8 ()Ljava/lang/String; 
.const [205] = Utf8 org/dsi/ifc/telephoneng/CallStackEntry 
.const [206] = Utf8 getLastName 
.const [207] = Utf8 ()Ljava/lang/String; 
.const [208] = Utf8 org/dsi/ifc/telephoneng/CallStackEntry 
.const [209] = Utf8 getFirstName 
.const [210] = Utf8 ()Ljava/lang/String; 
.const [211] = Utf8 org/dsi/ifc/telephoneng/CallStackEntry 
.const [212] = Utf8 getOrganization 
.const [213] = Utf8 ()Ljava/lang/String; 
.const [214] = Utf8 org/dsi/ifc/telephoneng/CallStackEntry 
.const [215] = Utf8 getClEntryOrigin 
.const [216] = Utf8 ()I 
.const [217] = Utf8 org/dsi/ifc/telephoneng/CallStackEntry 
.const [218] = Utf8 getClEntryType 
.const [219] = Utf8 ()I 
.const [220] = Utf8 org/dsi/ifc/telephoneng/CallStackEntry 
.const [221] = Utf8 getClYear 
.const [222] = Utf8 ()S 
.const [223] = Utf8 org/dsi/ifc/telephoneng/CallStackEntry 
.const [224] = Utf8 getClMonth 
.const [225] = Utf8 ()S 
.const [226] = Utf8 org/dsi/ifc/telephoneng/CallStackEntry 
.const [227] = Utf8 getClDay 
.const [228] = Utf8 ()S 
.const [229] = Utf8 org/dsi/ifc/telephoneng/CallStackEntry 
.const [230] = Utf8 getClHour 
.const [231] = Utf8 ()S 
.const [232] = Utf8 org/dsi/ifc/telephoneng/CallStackEntry 
.const [233] = Utf8 getClMinute 
.const [234] = Utf8 ()S 
.const [235] = Utf8 org/dsi/ifc/telephoneng/CallStackEntry 
.const [236] = Utf8 getClSecond 
.const [237] = Utf8 ()S 
.const [238] = Utf8 org/dsi/ifc/telephoneng/CallStackEntry 
.const [239] = Utf8 getAdbPictureID 
.const [240] = Utf8 ()Lorg/dsi/ifc/global/ResourceLocator; 
.const [241] = Utf8 org/dsi/ifc/telephoneng/CallStackEntry 
.const [242] = Utf8 getAdbEntryID 
.const [243] = Utf8 ()J 
.const [244] = Utf8 org/dsi/ifc/telephoneng/CallStackEntry 
.const [245] = Utf8 getAdbPhoneDataIndex 
.const [246] = Utf8 ()I 
.const [247] = Utf8 org/dsi/ifc/telephoneng/CallStackEntry 
.const [248] = Utf8 getAdbPhoneDataCount 
.const [249] = Utf8 ()I 
.const [250] = Utf8 org/dsi/ifc/telephoneng/CallStackEntry 
.const [251] = Utf8 getNewMissedCallAttempts 
.const [252] = Utf8 ()I 
.const [253] = Utf8 org/dsi/ifc/telephoneng/CallStackEntry 
.const [254] = Utf8 getAdbNumberType 
.const [255] = Utf8 ()I 
.const [256] = Utf8 java/lang/Object 
.const [257] = Utf8 <init> 
.const [258] = Utf8 ()V 
.const [259] = Utf8 org/dsi/ifc/telephoneng/CallStackEntry 
.const [260] = Utf8 <init> 
.const [261] = Utf8 ()V 
.const [262] = Utf8 de/esolutions/fw/util/serializer/ISerializer 
.const [263] = Utf8 putBool 
.const [264] = Utf8 (Z)V 
.const [265] = Utf8 de/esolutions/fw/util/serializer/ISerializer 
.const [266] = Utf8 putInt32 
.const [267] = Utf8 (I)V 
.const [268] = Utf8 de/esolutions/fw/util/serializer/ISerializer 
.const [269] = Utf8 putOptionalString 
.const [270] = Utf8 (Ljava/lang/String;)V 
.const [271] = Utf8 de/esolutions/fw/util/serializer/ISerializer 
.const [272] = Utf8 putInt16 
.const [273] = Utf8 (S)V 
.const [274] = Utf8 de/esolutions/fw/util/serializer/ISerializer 
.const [275] = Utf8 putInt64 
.const [276] = Utf8 (J)V 
.const [277] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [278] = Utf8 getBool 
.const [279] = Utf8 ()Z 
.const [280] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [281] = Utf8 getInt32 
.const [282] = Utf8 ()I 
.const [283] = Utf8 org/dsi/ifc/telephoneng/CallStackEntry 
.const [284] = Utf8 clEntryID 
.const [285] = Utf8 I 
.const [286] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [287] = Utf8 getOptionalString 
.const [288] = Utf8 ()Ljava/lang/String; 
.const [289] = Utf8 org/dsi/ifc/telephoneng/CallStackEntry 
.const [290] = Utf8 clNumber 
.const [291] = Utf8 Ljava/lang/String; 
.const [292] = Utf8 org/dsi/ifc/telephoneng/CallStackEntry 
.const [293] = Utf8 clName 
.const [294] = Utf8 Ljava/lang/String; 
.const [295] = Utf8 org/dsi/ifc/telephoneng/CallStackEntry 
.const [296] = Utf8 lastName 
.const [297] = Utf8 Ljava/lang/String; 
.const [298] = Utf8 org/dsi/ifc/telephoneng/CallStackEntry 
.const [299] = Utf8 firstName 
.const [300] = Utf8 Ljava/lang/String; 
.const [301] = Utf8 org/dsi/ifc/telephoneng/CallStackEntry 
.const [302] = Utf8 organization 
.const [303] = Utf8 Ljava/lang/String; 
.const [304] = Utf8 org/dsi/ifc/telephoneng/CallStackEntry 
.const [305] = Utf8 clEntryOrigin 
.const [306] = Utf8 I 
.const [307] = Utf8 org/dsi/ifc/telephoneng/CallStackEntry 
.const [308] = Utf8 clEntryType 
.const [309] = Utf8 I 
.const [310] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [311] = Utf8 getInt16 
.const [312] = Utf8 ()S 
.const [313] = Utf8 org/dsi/ifc/telephoneng/CallStackEntry 
.const [314] = Utf8 clYear 
.const [315] = Utf8 S 
.const [316] = Utf8 org/dsi/ifc/telephoneng/CallStackEntry 
.const [317] = Utf8 clMonth 
.const [318] = Utf8 S 
.const [319] = Utf8 org/dsi/ifc/telephoneng/CallStackEntry 
.const [320] = Utf8 clDay 
.const [321] = Utf8 S 
.const [322] = Utf8 org/dsi/ifc/telephoneng/CallStackEntry 
.const [323] = Utf8 clHour 
.const [324] = Utf8 S 
.const [325] = Utf8 org/dsi/ifc/telephoneng/CallStackEntry 
.const [326] = Utf8 clMinute 
.const [327] = Utf8 S 
.const [328] = Utf8 org/dsi/ifc/telephoneng/CallStackEntry 
.const [329] = Utf8 clSecond 
.const [330] = Utf8 S 
.const [331] = Utf8 org/dsi/ifc/telephoneng/CallStackEntry 
.const [332] = Utf8 adbPictureID 
.const [333] = Utf8 Lorg/dsi/ifc/global/ResourceLocator; 
.const [334] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [335] = Utf8 getInt64 
.const [336] = Utf8 ()J 
.const [337] = Utf8 org/dsi/ifc/telephoneng/CallStackEntry 
.const [338] = Utf8 adbEntryID 
.const [339] = Utf8 J 
.const [340] = Utf8 org/dsi/ifc/telephoneng/CallStackEntry 
.const [341] = Utf8 adbPhoneDataIndex 
.const [342] = Utf8 I 
.const [343] = Utf8 org/dsi/ifc/telephoneng/CallStackEntry 
.const [344] = Utf8 adbPhoneDataCount 
.const [345] = Utf8 I 
.const [346] = Utf8 org/dsi/ifc/telephoneng/CallStackEntry 
.const [347] = Utf8 newMissedCallAttempts 
.const [348] = Utf8 I 
.const [349] = Utf8 org/dsi/ifc/telephoneng/CallStackEntry 
.const [350] = Utf8 adbNumberType 
.const [351] = Utf8 I 
.const [352] = Utf8 de/esolutions/fw/comm/dsi/telephoneng/impl/CallStackEntrySerializer 
.const [353] = Class [352] 
.const [354] = Utf8 java/lang/Object 
.const [355] = Class [354] 
.const [356] = Utf8 Code 
.const [357] = Utf8 <init> 
.const [358] = Utf8 ()V 
.const [359] = Utf8 putOptionalCallStackEntry 
.const [360] = Utf8 (Lde/esolutions/fw/util/serializer/ISerializer;Lorg/dsi/ifc/telephoneng/CallStackEntry;)V 
.const [361] = Utf8 putOptionalCallStackEntryVarArray 
.const [362] = Utf8 (Lde/esolutions/fw/util/serializer/ISerializer;[Lorg/dsi/ifc/telephoneng/CallStackEntry;)V 
.const [363] = Utf8 getOptionalCallStackEntry 
.const [364] = Utf8 (Lde/esolutions/fw/util/serializer/IDeserializer;)Lorg/dsi/ifc/telephoneng/CallStackEntry; 
.const [365] = Utf8 getOptionalCallStackEntryVarArray 
.const [366] = Utf8 (Lde/esolutions/fw/util/serializer/IDeserializer;)[Lorg/dsi/ifc/telephoneng/CallStackEntry; 
.end class 
