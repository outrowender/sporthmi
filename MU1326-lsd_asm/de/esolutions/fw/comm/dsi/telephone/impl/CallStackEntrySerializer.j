.version 50 0 
.class public super [317] 
.super [319] 

.method public annotation [321] : [322] 
    .attribute [320] .code stack 1 locals 0 
L0:     aload_0 
L1:     invokespecial [29] 
L4:     return 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public static [323] : [324] 
    .attribute [320] .code stack 3 locals 19 
L0:     aload_1 
L1:     ifnonnull L8 
L4:     iconst_1 
L5:     goto L9 
L8:     iconst_0 
L9:     istore_2 
L10:    aload_0 
L11:    iload_2 
L12:    invokeinterface [31] 0 
L17:    iload_2 
L18:    ifne L255 
L21:    aload_1 
L22:    invokevirtual [12] 
L25:    istore_3 
L26:    aload_0 
L27:    iload_3 
L28:    invokeinterface [32] 0 
L33:    aload_1 
L34:    invokevirtual [13] 
L37:    astore 4 
L39:    aload_0 
L40:    aload 4 
L42:    invokeinterface [33] 0 
L47:    aload_1 
L48:    invokevirtual [14] 
L51:    astore 5 
L53:    aload_0 
L54:    aload 5 
L56:    invokeinterface [33] 0 
L61:    aload_1 
L62:    invokevirtual [15] 
L65:    istore 6 
L67:    aload_0 
L68:    iload 6 
L70:    invokeinterface [32] 0 
L75:    aload_1 
L76:    invokevirtual [16] 
L79:    istore 7 
L81:    aload_0 
L82:    iload 7 
L84:    invokeinterface [32] 0 
L89:    aload_1 
L90:    invokevirtual [17] 
L93:    istore 8 
L95:    aload_0 
L96:    iload 8 
L98:    invokeinterface [34] 0 
L103:   aload_1 
L104:   invokevirtual [18] 
L107:   istore 9 
L109:   aload_0 
L110:   iload 9 
L112:   invokeinterface [34] 0 
L117:   aload_1 
L118:   invokevirtual [19] 
L121:   istore 10 
L123:   aload_0 
L124:   iload 10 
L126:   invokeinterface [34] 0 
L131:   aload_1 
L132:   invokevirtual [20] 
L135:   istore 11 
L137:   aload_0 
L138:   iload 11 
L140:   invokeinterface [34] 0 
L145:   aload_1 
L146:   invokevirtual [21] 
L149:   istore 12 
L151:   aload_0 
L152:   iload 12 
L154:   invokeinterface [34] 0 
L159:   aload_1 
L160:   invokevirtual [22] 
L163:   istore 13 
L165:   aload_0 
L166:   iload 13 
L168:   invokeinterface [34] 0 
L173:   aload_1 
L174:   invokevirtual [23] 
L177:   astore 14 
L179:   aload_0 
L180:   aload 14 
L182:   invokestatic [2] 
L185:   aload_1 
L186:   invokevirtual [24] 
L189:   lstore 15 
L191:   aload_0 
L192:   lload 15 
L194:   invokeinterface [35] 0 
L199:   aload_1 
L200:   invokevirtual [25] 
L203:   istore 17 
L205:   aload_0 
L206:   iload 17 
L208:   invokeinterface [32] 0 
L213:   aload_1 
L214:   invokevirtual [26] 
L217:   istore 18 
L219:   aload_0 
L220:   iload 18 
L222:   invokeinterface [32] 0 
L227:   aload_1 
L228:   invokevirtual [27] 
L231:   istore 19 
L233:   aload_0 
L234:   iload 19 
L236:   invokeinterface [32] 0 
L241:   aload_1 
L242:   invokevirtual [28] 
L245:   istore 20 
L247:   aload_0 
L248:   iload 20 
L250:   invokeinterface [32] 0 
L255:   return 
L256:   
    .end code 
.end method 

.method public static [325] : [326] 
    .attribute [320] .code stack 3 locals 2 
L0:     aload_1 
L1:     ifnonnull L8 
L4:     iconst_1 
L5:     goto L9 
L8:     iconst_0 
L9:     istore_2 
L10:    aload_0 
L11:    iload_2 
L12:    invokeinterface [31] 0 
L17:    iload_2 
L18:    ifne L50 
L21:    aload_0 
L22:    aload_1 
L23:    arraylength 
L24:    invokeinterface [32] 0 
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

.method public static [327] : [328] 
    .attribute [320] .code stack 3 locals 20 
L0:     aconst_null 
L1:     astore_1 
L2:     aload_0 
L3:     invokeinterface [36] 0 
L8:     istore_2 
L9:     iload_2 
L10:    ifne L255 
L13:    new [37] 
L16:    dup 
L17:    invokespecial [30] 
L20:    astore_1 
L21:    aload_0 
L22:    invokeinterface [38] 0 
L27:    istore_3 
L28:    aload_1 
L29:    iload_3 
L30:    putfield [39] 
L33:    aload_0 
L34:    invokeinterface [40] 0 
L39:    astore 4 
L41:    aload_1 
L42:    aload 4 
L44:    putfield [41] 
L47:    aload_0 
L48:    invokeinterface [40] 0 
L53:    astore 5 
L55:    aload_1 
L56:    aload 5 
L58:    putfield [42] 
L61:    aload_0 
L62:    invokeinterface [38] 0 
L67:    istore 6 
L69:    aload_1 
L70:    iload 6 
L72:    putfield [43] 
L75:    aload_0 
L76:    invokeinterface [38] 0 
L81:    istore 7 
L83:    aload_1 
L84:    iload 7 
L86:    putfield [44] 
L89:    aload_0 
L90:    invokeinterface [45] 0 
L95:    istore 8 
L97:    aload_1 
L98:    iload 8 
L100:   putfield [46] 
L103:   aload_0 
L104:   invokeinterface [45] 0 
L109:   istore 9 
L111:   aload_1 
L112:   iload 9 
L114:   putfield [47] 
L117:   aload_0 
L118:   invokeinterface [45] 0 
L123:   istore 10 
L125:   aload_1 
L126:   iload 10 
L128:   putfield [48] 
L131:   aload_0 
L132:   invokeinterface [45] 0 
L137:   istore 11 
L139:   aload_1 
L140:   iload 11 
L142:   putfield [49] 
L145:   aload_0 
L146:   invokeinterface [45] 0 
L151:   istore 12 
L153:   aload_1 
L154:   iload 12 
L156:   putfield [50] 
L159:   aload_0 
L160:   invokeinterface [45] 0 
L165:   istore 13 
L167:   aload_1 
L168:   iload 13 
L170:   putfield [51] 
L173:   aload_0 
L174:   invokestatic [5] 
L177:   astore 14 
L179:   aload_1 
L180:   aload 14 
L182:   putfield [52] 
L185:   aload_0 
L186:   invokeinterface [53] 0 
L191:   lstore 15 
L193:   aload_1 
L194:   lload 15 
L196:   putfield [54] 
L199:   aload_0 
L200:   invokeinterface [38] 0 
L205:   istore 17 
L207:   aload_1 
L208:   iload 17 
L210:   putfield [55] 
L213:   aload_0 
L214:   invokeinterface [38] 0 
L219:   istore 18 
L221:   aload_1 
L222:   iload 18 
L224:   putfield [56] 
L227:   aload_0 
L228:   invokeinterface [38] 0 
L233:   istore 19 
L235:   aload_1 
L236:   iload 19 
L238:   putfield [57] 
L241:   aload_0 
L242:   invokeinterface [38] 0 
L247:   istore 20 
L249:   aload_1 
L250:   iload 20 
L252:   putfield [58] 
L255:   aload_1 
L256:   areturn 
L257:   nop 
L258:   nop 
L259:   nop 
L260:   
    .end code 
.end method 

.method public static [329] : [330] 
    .attribute [320] .code stack 3 locals 4 
L0:     aconst_null 
L1:     astore_1 
L2:     aload_0 
L3:     invokeinterface [36] 0 
L8:     istore_2 
L9:     iload_2 
L10:    ifne L48 
L13:    aload_0 
L14:    invokeinterface [38] 0 
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
.const [2] = Method [59] [60] 
.const [3] = Method [61] [62] 
.const [4] = Class [63] 
.const [5] = Method [64] [65] 
.const [6] = Method [66] [67] 
.const [7] = Class [68] 
.const [8] = Class [69] 
.const [9] = Class [70] 
.const [10] = Class [71] 
.const [11] = Class [72] 
.const [12] = Method [73] [74] 
.const [13] = Method [75] [76] 
.const [14] = Method [77] [78] 
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
.const [31] = InterfaceMethod [111] [112] 
.const [32] = InterfaceMethod [113] [114] 
.const [33] = InterfaceMethod [115] [116] 
.const [34] = InterfaceMethod [117] [118] 
.const [35] = InterfaceMethod [119] [120] 
.const [36] = InterfaceMethod [121] [122] 
.const [37] = Class [123] 
.const [38] = InterfaceMethod [124] [125] 
.const [39] = Field [126] [127] 
.const [40] = InterfaceMethod [128] [129] 
.const [41] = Field [130] [131] 
.const [42] = Field [132] [133] 
.const [43] = Field [134] [135] 
.const [44] = Field [136] [137] 
.const [45] = InterfaceMethod [138] [139] 
.const [46] = Field [140] [141] 
.const [47] = Field [142] [143] 
.const [48] = Field [144] [145] 
.const [49] = Field [146] [147] 
.const [50] = Field [148] [149] 
.const [51] = Field [150] [151] 
.const [52] = Field [152] [153] 
.const [53] = InterfaceMethod [154] [155] 
.const [54] = Field [156] [157] 
.const [55] = Field [158] [159] 
.const [56] = Field [160] [161] 
.const [57] = Field [162] [163] 
.const [58] = Field [164] [165] 
.const [59] = Class [166] 
.const [60] = NameAndType [167] [168] 
.const [61] = Class [169] 
.const [62] = NameAndType [170] [171] 
.const [63] = Utf8 org/dsi/ifc/telephone/CallStackEntry 
.const [64] = Class [172] 
.const [65] = NameAndType [173] [174] 
.const [66] = Class [175] 
.const [67] = NameAndType [176] [177] 
.const [68] = Utf8 de/esolutions/fw/comm/dsi/telephone/impl/CallStackEntrySerializer 
.const [69] = Utf8 java/lang/Object 
.const [70] = Utf8 de/esolutions/fw/util/serializer/ISerializer 
.const [71] = Utf8 de/esolutions/fw/comm/dsi/global/impl/ResourceLocatorSerializer 
.const [72] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [73] = Class [178] 
.const [74] = NameAndType [179] [180] 
.const [75] = Class [181] 
.const [76] = NameAndType [182] [183] 
.const [77] = Class [184] 
.const [78] = NameAndType [185] [186] 
.const [79] = Class [187] 
.const [80] = NameAndType [188] [189] 
.const [81] = Class [190] 
.const [82] = NameAndType [191] [192] 
.const [83] = Class [193] 
.const [84] = NameAndType [194] [195] 
.const [85] = Class [196] 
.const [86] = NameAndType [197] [198] 
.const [87] = Class [199] 
.const [88] = NameAndType [200] [201] 
.const [89] = Class [202] 
.const [90] = NameAndType [203] [204] 
.const [91] = Class [205] 
.const [92] = NameAndType [206] [207] 
.const [93] = Class [208] 
.const [94] = NameAndType [209] [210] 
.const [95] = Class [211] 
.const [96] = NameAndType [212] [213] 
.const [97] = Class [214] 
.const [98] = NameAndType [215] [216] 
.const [99] = Class [217] 
.const [100] = NameAndType [218] [219] 
.const [101] = Class [220] 
.const [102] = NameAndType [221] [222] 
.const [103] = Class [223] 
.const [104] = NameAndType [224] [225] 
.const [105] = Class [226] 
.const [106] = NameAndType [227] [228] 
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
.const [123] = Utf8 org/dsi/ifc/telephone/CallStackEntry 
.const [124] = Class [253] 
.const [125] = NameAndType [254] [255] 
.const [126] = Class [256] 
.const [127] = NameAndType [257] [258] 
.const [128] = Class [259] 
.const [129] = NameAndType [260] [261] 
.const [130] = Class [262] 
.const [131] = NameAndType [263] [264] 
.const [132] = Class [265] 
.const [133] = NameAndType [266] [267] 
.const [134] = Class [268] 
.const [135] = NameAndType [269] [270] 
.const [136] = Class [271] 
.const [137] = NameAndType [272] [273] 
.const [138] = Class [274] 
.const [139] = NameAndType [275] [276] 
.const [140] = Class [277] 
.const [141] = NameAndType [278] [279] 
.const [142] = Class [280] 
.const [143] = NameAndType [281] [282] 
.const [144] = Class [283] 
.const [145] = NameAndType [284] [285] 
.const [146] = Class [286] 
.const [147] = NameAndType [287] [288] 
.const [148] = Class [289] 
.const [149] = NameAndType [290] [291] 
.const [150] = Class [292] 
.const [151] = NameAndType [293] [294] 
.const [152] = Class [295] 
.const [153] = NameAndType [296] [297] 
.const [154] = Class [298] 
.const [155] = NameAndType [299] [300] 
.const [156] = Class [301] 
.const [157] = NameAndType [302] [303] 
.const [158] = Class [304] 
.const [159] = NameAndType [305] [306] 
.const [160] = Class [307] 
.const [161] = NameAndType [308] [309] 
.const [162] = Class [310] 
.const [163] = NameAndType [311] [312] 
.const [164] = Class [313] 
.const [165] = NameAndType [314] [315] 
.const [166] = Utf8 de/esolutions/fw/comm/dsi/global/impl/ResourceLocatorSerializer 
.const [167] = Utf8 putOptionalResourceLocator 
.const [168] = Utf8 (Lde/esolutions/fw/util/serializer/ISerializer;Lorg/dsi/ifc/global/ResourceLocator;)V 
.const [169] = Utf8 de/esolutions/fw/comm/dsi/telephone/impl/CallStackEntrySerializer 
.const [170] = Utf8 putOptionalCallStackEntry 
.const [171] = Utf8 (Lde/esolutions/fw/util/serializer/ISerializer;Lorg/dsi/ifc/telephone/CallStackEntry;)V 
.const [172] = Utf8 de/esolutions/fw/comm/dsi/global/impl/ResourceLocatorSerializer 
.const [173] = Utf8 getOptionalResourceLocator 
.const [174] = Utf8 (Lde/esolutions/fw/util/serializer/IDeserializer;)Lorg/dsi/ifc/global/ResourceLocator; 
.const [175] = Utf8 de/esolutions/fw/comm/dsi/telephone/impl/CallStackEntrySerializer 
.const [176] = Utf8 getOptionalCallStackEntry 
.const [177] = Utf8 (Lde/esolutions/fw/util/serializer/IDeserializer;)Lorg/dsi/ifc/telephone/CallStackEntry; 
.const [178] = Utf8 org/dsi/ifc/telephone/CallStackEntry 
.const [179] = Utf8 getClEntryID 
.const [180] = Utf8 ()I 
.const [181] = Utf8 org/dsi/ifc/telephone/CallStackEntry 
.const [182] = Utf8 getClNumber 
.const [183] = Utf8 ()Ljava/lang/String; 
.const [184] = Utf8 org/dsi/ifc/telephone/CallStackEntry 
.const [185] = Utf8 getClName 
.const [186] = Utf8 ()Ljava/lang/String; 
.const [187] = Utf8 org/dsi/ifc/telephone/CallStackEntry 
.const [188] = Utf8 getClEntryOrigin 
.const [189] = Utf8 ()I 
.const [190] = Utf8 org/dsi/ifc/telephone/CallStackEntry 
.const [191] = Utf8 getClEntryType 
.const [192] = Utf8 ()I 
.const [193] = Utf8 org/dsi/ifc/telephone/CallStackEntry 
.const [194] = Utf8 getClYear 
.const [195] = Utf8 ()S 
.const [196] = Utf8 org/dsi/ifc/telephone/CallStackEntry 
.const [197] = Utf8 getClMonth 
.const [198] = Utf8 ()S 
.const [199] = Utf8 org/dsi/ifc/telephone/CallStackEntry 
.const [200] = Utf8 getClDay 
.const [201] = Utf8 ()S 
.const [202] = Utf8 org/dsi/ifc/telephone/CallStackEntry 
.const [203] = Utf8 getClHour 
.const [204] = Utf8 ()S 
.const [205] = Utf8 org/dsi/ifc/telephone/CallStackEntry 
.const [206] = Utf8 getClMinute 
.const [207] = Utf8 ()S 
.const [208] = Utf8 org/dsi/ifc/telephone/CallStackEntry 
.const [209] = Utf8 getClSecond 
.const [210] = Utf8 ()S 
.const [211] = Utf8 org/dsi/ifc/telephone/CallStackEntry 
.const [212] = Utf8 getAdbPictureID 
.const [213] = Utf8 ()Lorg/dsi/ifc/global/ResourceLocator; 
.const [214] = Utf8 org/dsi/ifc/telephone/CallStackEntry 
.const [215] = Utf8 getAdbEntryID 
.const [216] = Utf8 ()J 
.const [217] = Utf8 org/dsi/ifc/telephone/CallStackEntry 
.const [218] = Utf8 getAdbPhoneDataIndex 
.const [219] = Utf8 ()I 
.const [220] = Utf8 org/dsi/ifc/telephone/CallStackEntry 
.const [221] = Utf8 getAdbPhoneDataCount 
.const [222] = Utf8 ()I 
.const [223] = Utf8 org/dsi/ifc/telephone/CallStackEntry 
.const [224] = Utf8 getNewMissedCallAttempts 
.const [225] = Utf8 ()I 
.const [226] = Utf8 org/dsi/ifc/telephone/CallStackEntry 
.const [227] = Utf8 getAdbNumberType 
.const [228] = Utf8 ()I 
.const [229] = Utf8 java/lang/Object 
.const [230] = Utf8 <init> 
.const [231] = Utf8 ()V 
.const [232] = Utf8 org/dsi/ifc/telephone/CallStackEntry 
.const [233] = Utf8 <init> 
.const [234] = Utf8 ()V 
.const [235] = Utf8 de/esolutions/fw/util/serializer/ISerializer 
.const [236] = Utf8 putBool 
.const [237] = Utf8 (Z)V 
.const [238] = Utf8 de/esolutions/fw/util/serializer/ISerializer 
.const [239] = Utf8 putInt32 
.const [240] = Utf8 (I)V 
.const [241] = Utf8 de/esolutions/fw/util/serializer/ISerializer 
.const [242] = Utf8 putOptionalString 
.const [243] = Utf8 (Ljava/lang/String;)V 
.const [244] = Utf8 de/esolutions/fw/util/serializer/ISerializer 
.const [245] = Utf8 putInt16 
.const [246] = Utf8 (S)V 
.const [247] = Utf8 de/esolutions/fw/util/serializer/ISerializer 
.const [248] = Utf8 putInt64 
.const [249] = Utf8 (J)V 
.const [250] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [251] = Utf8 getBool 
.const [252] = Utf8 ()Z 
.const [253] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [254] = Utf8 getInt32 
.const [255] = Utf8 ()I 
.const [256] = Utf8 org/dsi/ifc/telephone/CallStackEntry 
.const [257] = Utf8 clEntryID 
.const [258] = Utf8 I 
.const [259] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [260] = Utf8 getOptionalString 
.const [261] = Utf8 ()Ljava/lang/String; 
.const [262] = Utf8 org/dsi/ifc/telephone/CallStackEntry 
.const [263] = Utf8 clNumber 
.const [264] = Utf8 Ljava/lang/String; 
.const [265] = Utf8 org/dsi/ifc/telephone/CallStackEntry 
.const [266] = Utf8 clName 
.const [267] = Utf8 Ljava/lang/String; 
.const [268] = Utf8 org/dsi/ifc/telephone/CallStackEntry 
.const [269] = Utf8 clEntryOrigin 
.const [270] = Utf8 I 
.const [271] = Utf8 org/dsi/ifc/telephone/CallStackEntry 
.const [272] = Utf8 clEntryType 
.const [273] = Utf8 I 
.const [274] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [275] = Utf8 getInt16 
.const [276] = Utf8 ()S 
.const [277] = Utf8 org/dsi/ifc/telephone/CallStackEntry 
.const [278] = Utf8 clYear 
.const [279] = Utf8 S 
.const [280] = Utf8 org/dsi/ifc/telephone/CallStackEntry 
.const [281] = Utf8 clMonth 
.const [282] = Utf8 S 
.const [283] = Utf8 org/dsi/ifc/telephone/CallStackEntry 
.const [284] = Utf8 clDay 
.const [285] = Utf8 S 
.const [286] = Utf8 org/dsi/ifc/telephone/CallStackEntry 
.const [287] = Utf8 clHour 
.const [288] = Utf8 S 
.const [289] = Utf8 org/dsi/ifc/telephone/CallStackEntry 
.const [290] = Utf8 clMinute 
.const [291] = Utf8 S 
.const [292] = Utf8 org/dsi/ifc/telephone/CallStackEntry 
.const [293] = Utf8 clSecond 
.const [294] = Utf8 S 
.const [295] = Utf8 org/dsi/ifc/telephone/CallStackEntry 
.const [296] = Utf8 adbPictureID 
.const [297] = Utf8 Lorg/dsi/ifc/global/ResourceLocator; 
.const [298] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [299] = Utf8 getInt64 
.const [300] = Utf8 ()J 
.const [301] = Utf8 org/dsi/ifc/telephone/CallStackEntry 
.const [302] = Utf8 adbEntryID 
.const [303] = Utf8 J 
.const [304] = Utf8 org/dsi/ifc/telephone/CallStackEntry 
.const [305] = Utf8 adbPhoneDataIndex 
.const [306] = Utf8 I 
.const [307] = Utf8 org/dsi/ifc/telephone/CallStackEntry 
.const [308] = Utf8 adbPhoneDataCount 
.const [309] = Utf8 I 
.const [310] = Utf8 org/dsi/ifc/telephone/CallStackEntry 
.const [311] = Utf8 newMissedCallAttempts 
.const [312] = Utf8 I 
.const [313] = Utf8 org/dsi/ifc/telephone/CallStackEntry 
.const [314] = Utf8 adbNumberType 
.const [315] = Utf8 I 
.const [316] = Utf8 de/esolutions/fw/comm/dsi/telephone/impl/CallStackEntrySerializer 
.const [317] = Class [316] 
.const [318] = Utf8 java/lang/Object 
.const [319] = Class [318] 
.const [320] = Utf8 Code 
.const [321] = Utf8 <init> 
.const [322] = Utf8 ()V 
.const [323] = Utf8 putOptionalCallStackEntry 
.const [324] = Utf8 (Lde/esolutions/fw/util/serializer/ISerializer;Lorg/dsi/ifc/telephone/CallStackEntry;)V 
.const [325] = Utf8 putOptionalCallStackEntryVarArray 
.const [326] = Utf8 (Lde/esolutions/fw/util/serializer/ISerializer;[Lorg/dsi/ifc/telephone/CallStackEntry;)V 
.const [327] = Utf8 getOptionalCallStackEntry 
.const [328] = Utf8 (Lde/esolutions/fw/util/serializer/IDeserializer;)Lorg/dsi/ifc/telephone/CallStackEntry; 
.const [329] = Utf8 getOptionalCallStackEntryVarArray 
.const [330] = Utf8 (Lde/esolutions/fw/util/serializer/IDeserializer;)[Lorg/dsi/ifc/telephone/CallStackEntry; 
.end class 
