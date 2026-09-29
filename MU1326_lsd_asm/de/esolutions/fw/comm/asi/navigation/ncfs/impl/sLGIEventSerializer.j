.version 50 0 
.class public super [271] 
.super [273] 

.method public annotation [275] : [276] 
    .attribute [274] .code stack 1 locals 0 
L0:     aload_0 
L1:     invokespecial [25] 
L4:     return 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public static [277] : [278] 
    .attribute [274] .code stack 3 locals 12 
L0:     aload_1 
L1:     ifnonnull L8 
L4:     iconst_1 
L5:     goto L9 
L8:     iconst_0 
L9:     istore_2 
L10:    aload_0 
L11:    iload_2 
L12:    invokeinterface [27] 0 
L17:    iload_2 
L18:    ifne L155 
L21:    aload_1 
L22:    invokevirtual [15] 
L25:    lstore_3 
L26:    aload_0 
L27:    lload_3 
L28:    invokeinterface [28] 0 
L33:    aload_1 
L34:    invokevirtual [16] 
L37:    istore 5 
L39:    aload_0 
L40:    iload 5 
L42:    invokeinterface [29] 0 
L47:    aload_1 
L48:    invokevirtual [17] 
L51:    astore 6 
L53:    aload_0 
L54:    aload 6 
L56:    invokestatic [2] 
L59:    aload_1 
L60:    invokevirtual [18] 
L63:    astore 7 
L65:    aload_0 
L66:    aload 7 
L68:    invokestatic [3] 
L71:    aload_1 
L72:    invokevirtual [19] 
L75:    istore 8 
L77:    aload_0 
L78:    iload 8 
L80:    invokeinterface [30] 0 
L85:    aload_1 
L86:    invokevirtual [20] 
L89:    istore 9 
L91:    aload_0 
L92:    iload 9 
L94:    invokeinterface [30] 0 
L99:    aload_1 
L100:   invokevirtual [21] 
L103:   istore 10 
L105:   aload_0 
L106:   iload 10 
L108:   invokeinterface [31] 0 
L113:   aload_1 
L114:   invokevirtual [22] 
L117:   istore 11 
L119:   aload_0 
L120:   iload 11 
L122:   invokeinterface [31] 0 
L127:   aload_1 
L128:   invokevirtual [23] 
L131:   astore 12 
L133:   aload_0 
L134:   aload 12 
L136:   invokeinterface [32] 0 
L141:   aload_1 
L142:   invokevirtual [24] 
L145:   istore 13 
L147:   aload_0 
L148:   iload 13 
L150:   invokeinterface [33] 0 
L155:   return 
L156:   
    .end code 
.end method 

.method public static [279] : [280] 
    .attribute [274] .code stack 3 locals 2 
L0:     aload_1 
L1:     ifnonnull L8 
L4:     iconst_1 
L5:     goto L9 
L8:     iconst_0 
L9:     istore_2 
L10:    aload_0 
L11:    iload_2 
L12:    invokeinterface [27] 0 
L17:    iload_2 
L18:    ifne L50 
L21:    aload_0 
L22:    aload_1 
L23:    arraylength 
L24:    invokeinterface [30] 0 
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

.method public static [281] : [282] 
    .attribute [274] .code stack 3 locals 13 
L0:     aconst_null 
L1:     astore_1 
L2:     aload_0 
L3:     invokeinterface [34] 0 
L8:     istore_2 
L9:     iload_2 
L10:    ifne L155 
L13:    new [35] 
L16:    dup 
L17:    invokespecial [26] 
L20:    astore_1 
L21:    aload_0 
L22:    invokeinterface [36] 0 
L27:    lstore_3 
L28:    aload_1 
L29:    lload_3 
L30:    putfield [37] 
L33:    aload_0 
L34:    invokeinterface [38] 0 
L39:    istore 5 
L41:    aload_1 
L42:    iload 5 
L44:    putfield [39] 
L47:    aload_0 
L48:    invokestatic [6] 
L51:    astore 6 
L53:    aload_1 
L54:    aload 6 
L56:    putfield [40] 
L59:    aload_0 
L60:    invokestatic [7] 
L63:    astore 7 
L65:    aload_1 
L66:    aload 7 
L68:    putfield [41] 
L71:    aload_0 
L72:    invokeinterface [42] 0 
L77:    istore 8 
L79:    aload_1 
L80:    iload 8 
L82:    putfield [43] 
L85:    aload_0 
L86:    invokeinterface [42] 0 
L91:    istore 9 
L93:    aload_1 
L94:    iload 9 
L96:    putfield [44] 
L99:    aload_0 
L100:   invokeinterface [45] 0 
L105:   istore 10 
L107:   aload_1 
L108:   iload 10 
L110:   putfield [46] 
L113:   aload_0 
L114:   invokeinterface [45] 0 
L119:   istore 11 
L121:   aload_1 
L122:   iload 11 
L124:   putfield [47] 
L127:   aload_0 
L128:   invokeinterface [48] 0 
L133:   astore 12 
L135:   aload_1 
L136:   aload 12 
L138:   putfield [49] 
L141:   aload_0 
L142:   invokeinterface [50] 0 
L147:   istore 13 
L149:   aload_1 
L150:   iload 13 
L152:   putfield [51] 
L155:   aload_1 
L156:   areturn 
L157:   nop 
L158:   nop 
L159:   nop 
L160:   
    .end code 
.end method 

.method public static [283] : [284] 
    .attribute [274] .code stack 3 locals 4 
L0:     aconst_null 
L1:     astore_1 
L2:     aload_0 
L3:     invokeinterface [34] 0 
L8:     istore_2 
L9:     iload_2 
L10:    ifne L48 
L13:    aload_0 
L14:    invokeinterface [42] 0 
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
.const [2] = Method [52] [53] 
.const [3] = Method [54] [55] 
.const [4] = Method [56] [57] 
.const [5] = Class [58] 
.const [6] = Method [59] [60] 
.const [7] = Method [61] [62] 
.const [8] = Method [63] [64] 
.const [9] = Class [65] 
.const [10] = Class [66] 
.const [11] = Class [67] 
.const [12] = Class [68] 
.const [13] = Class [69] 
.const [14] = Class [70] 
.const [15] = Method [71] [72] 
.const [16] = Method [73] [74] 
.const [17] = Method [75] [76] 
.const [18] = Method [77] [78] 
.const [19] = Method [79] [80] 
.const [20] = Method [81] [82] 
.const [21] = Method [83] [84] 
.const [22] = Method [85] [86] 
.const [23] = Method [87] [88] 
.const [24] = Method [89] [90] 
.const [25] = Method [91] [92] 
.const [26] = Method [93] [94] 
.const [27] = InterfaceMethod [95] [96] 
.const [28] = InterfaceMethod [97] [98] 
.const [29] = InterfaceMethod [99] [100] 
.const [30] = InterfaceMethod [101] [102] 
.const [31] = InterfaceMethod [103] [104] 
.const [32] = InterfaceMethod [105] [106] 
.const [33] = InterfaceMethod [107] [108] 
.const [34] = InterfaceMethod [109] [110] 
.const [35] = Class [111] 
.const [36] = InterfaceMethod [112] [113] 
.const [37] = Field [114] [115] 
.const [38] = InterfaceMethod [116] [117] 
.const [39] = Field [118] [119] 
.const [40] = Field [120] [121] 
.const [41] = Field [122] [123] 
.const [42] = InterfaceMethod [124] [125] 
.const [43] = Field [126] [127] 
.const [44] = Field [128] [129] 
.const [45] = InterfaceMethod [130] [131] 
.const [46] = Field [132] [133] 
.const [47] = Field [134] [135] 
.const [48] = InterfaceMethod [136] [137] 
.const [49] = Field [138] [139] 
.const [50] = InterfaceMethod [140] [141] 
.const [51] = Field [142] [143] 
.const [52] = Class [144] 
.const [53] = NameAndType [145] [146] 
.const [54] = Class [147] 
.const [55] = NameAndType [148] [149] 
.const [56] = Class [150] 
.const [57] = NameAndType [151] [152] 
.const [58] = Utf8 de/esolutions/fw/comm/asi/navigation/ncfs/sLGIEvent 
.const [59] = Class [153] 
.const [60] = NameAndType [154] [155] 
.const [61] = Class [156] 
.const [62] = NameAndType [157] [158] 
.const [63] = Class [159] 
.const [64] = NameAndType [160] [161] 
.const [65] = Utf8 de/esolutions/fw/comm/asi/navigation/ncfs/impl/sLGIEventSerializer 
.const [66] = Utf8 java/lang/Object 
.const [67] = Utf8 de/esolutions/fw/util/serializer/ISerializer 
.const [68] = Utf8 de/esolutions/fw/comm/asi/navigation/ncfs/impl/sBoundingBoxSerializer 
.const [69] = Utf8 de/esolutions/fw/comm/asi/navigation/ncfs/impl/sLocationContainerSerializer 
.const [70] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [71] = Class [162] 
.const [72] = NameAndType [163] [164] 
.const [73] = Class [165] 
.const [74] = NameAndType [166] [167] 
.const [75] = Class [168] 
.const [76] = NameAndType [169] [170] 
.const [77] = Class [171] 
.const [78] = NameAndType [172] [173] 
.const [79] = Class [174] 
.const [80] = NameAndType [175] [176] 
.const [81] = Class [177] 
.const [82] = NameAndType [178] [179] 
.const [83] = Class [180] 
.const [84] = NameAndType [181] [182] 
.const [85] = Class [183] 
.const [86] = NameAndType [184] [185] 
.const [87] = Class [186] 
.const [88] = NameAndType [187] [188] 
.const [89] = Class [189] 
.const [90] = NameAndType [190] [191] 
.const [91] = Class [192] 
.const [92] = NameAndType [193] [194] 
.const [93] = Class [195] 
.const [94] = NameAndType [196] [197] 
.const [95] = Class [198] 
.const [96] = NameAndType [199] [200] 
.const [97] = Class [201] 
.const [98] = NameAndType [202] [203] 
.const [99] = Class [204] 
.const [100] = NameAndType [205] [206] 
.const [101] = Class [207] 
.const [102] = NameAndType [208] [209] 
.const [103] = Class [210] 
.const [104] = NameAndType [211] [212] 
.const [105] = Class [213] 
.const [106] = NameAndType [214] [215] 
.const [107] = Class [216] 
.const [108] = NameAndType [217] [218] 
.const [109] = Class [219] 
.const [110] = NameAndType [220] [221] 
.const [111] = Utf8 de/esolutions/fw/comm/asi/navigation/ncfs/sLGIEvent 
.const [112] = Class [222] 
.const [113] = NameAndType [223] [224] 
.const [114] = Class [225] 
.const [115] = NameAndType [226] [227] 
.const [116] = Class [228] 
.const [117] = NameAndType [229] [230] 
.const [118] = Class [231] 
.const [119] = NameAndType [232] [233] 
.const [120] = Class [234] 
.const [121] = NameAndType [235] [236] 
.const [122] = Class [237] 
.const [123] = NameAndType [238] [239] 
.const [124] = Class [240] 
.const [125] = NameAndType [241] [242] 
.const [126] = Class [243] 
.const [127] = NameAndType [244] [245] 
.const [128] = Class [246] 
.const [129] = NameAndType [247] [248] 
.const [130] = Class [249] 
.const [131] = NameAndType [250] [251] 
.const [132] = Class [252] 
.const [133] = NameAndType [253] [254] 
.const [134] = Class [255] 
.const [135] = NameAndType [256] [257] 
.const [136] = Class [258] 
.const [137] = NameAndType [259] [260] 
.const [138] = Class [261] 
.const [139] = NameAndType [262] [263] 
.const [140] = Class [264] 
.const [141] = NameAndType [265] [266] 
.const [142] = Class [267] 
.const [143] = NameAndType [268] [269] 
.const [144] = Utf8 de/esolutions/fw/comm/asi/navigation/ncfs/impl/sBoundingBoxSerializer 
.const [145] = Utf8 putOptionalsBoundingBox 
.const [146] = Utf8 (Lde/esolutions/fw/util/serializer/ISerializer;Lde/esolutions/fw/comm/asi/navigation/ncfs/sBoundingBox;)V 
.const [147] = Utf8 de/esolutions/fw/comm/asi/navigation/ncfs/impl/sLocationContainerSerializer 
.const [148] = Utf8 putOptionalsLocationContainer 
.const [149] = Utf8 (Lde/esolutions/fw/util/serializer/ISerializer;Lde/esolutions/fw/comm/asi/navigation/ncfs/sLocationContainer;)V 
.const [150] = Utf8 de/esolutions/fw/comm/asi/navigation/ncfs/impl/sLGIEventSerializer 
.const [151] = Utf8 putOptionalsLGIEvent 
.const [152] = Utf8 (Lde/esolutions/fw/util/serializer/ISerializer;Lde/esolutions/fw/comm/asi/navigation/ncfs/sLGIEvent;)V 
.const [153] = Utf8 de/esolutions/fw/comm/asi/navigation/ncfs/impl/sBoundingBoxSerializer 
.const [154] = Utf8 getOptionalsBoundingBox 
.const [155] = Utf8 (Lde/esolutions/fw/util/serializer/IDeserializer;)Lde/esolutions/fw/comm/asi/navigation/ncfs/sBoundingBox; 
.const [156] = Utf8 de/esolutions/fw/comm/asi/navigation/ncfs/impl/sLocationContainerSerializer 
.const [157] = Utf8 getOptionalsLocationContainer 
.const [158] = Utf8 (Lde/esolutions/fw/util/serializer/IDeserializer;)Lde/esolutions/fw/comm/asi/navigation/ncfs/sLocationContainer; 
.const [159] = Utf8 de/esolutions/fw/comm/asi/navigation/ncfs/impl/sLGIEventSerializer 
.const [160] = Utf8 getOptionalsLGIEvent 
.const [161] = Utf8 (Lde/esolutions/fw/util/serializer/IDeserializer;)Lde/esolutions/fw/comm/asi/navigation/ncfs/sLGIEvent; 
.const [162] = Utf8 de/esolutions/fw/comm/asi/navigation/ncfs/sLGIEvent 
.const [163] = Utf8 getId 
.const [164] = Utf8 ()J 
.const [165] = Utf8 de/esolutions/fw/comm/asi/navigation/ncfs/sLGIEvent 
.const [166] = Utf8 getVersion 
.const [167] = Utf8 ()S 
.const [168] = Utf8 de/esolutions/fw/comm/asi/navigation/ncfs/sLGIEvent 
.const [169] = Utf8 getBoundaries 
.const [170] = Utf8 ()Lde/esolutions/fw/comm/asi/navigation/ncfs/sBoundingBox; 
.const [171] = Utf8 de/esolutions/fw/comm/asi/navigation/ncfs/sLGIEvent 
.const [172] = Utf8 getLocation 
.const [173] = Utf8 ()Lde/esolutions/fw/comm/asi/navigation/ncfs/sLocationContainer; 
.const [174] = Utf8 de/esolutions/fw/comm/asi/navigation/ncfs/sLGIEvent 
.const [175] = Utf8 getStartAt 
.const [176] = Utf8 ()I 
.const [177] = Utf8 de/esolutions/fw/comm/asi/navigation/ncfs/sLGIEvent 
.const [178] = Utf8 getEndAt 
.const [179] = Utf8 ()I 
.const [180] = Utf8 de/esolutions/fw/comm/asi/navigation/ncfs/sLGIEvent 
.const [181] = Utf8 getEventType 
.const [182] = Utf8 ()I 
.const [183] = Utf8 de/esolutions/fw/comm/asi/navigation/ncfs/sLGIEvent 
.const [184] = Utf8 getEventQuality 
.const [185] = Utf8 ()I 
.const [186] = Utf8 de/esolutions/fw/comm/asi/navigation/ncfs/sLGIEvent 
.const [187] = Utf8 getTileIds 
.const [188] = Utf8 ()[I 
.const [189] = Utf8 de/esolutions/fw/comm/asi/navigation/ncfs/sLGIEvent 
.const [190] = Utf8 getMinRoadclass 
.const [191] = Utf8 ()B 
.const [192] = Utf8 java/lang/Object 
.const [193] = Utf8 <init> 
.const [194] = Utf8 ()V 
.const [195] = Utf8 de/esolutions/fw/comm/asi/navigation/ncfs/sLGIEvent 
.const [196] = Utf8 <init> 
.const [197] = Utf8 ()V 
.const [198] = Utf8 de/esolutions/fw/util/serializer/ISerializer 
.const [199] = Utf8 putBool 
.const [200] = Utf8 (Z)V 
.const [201] = Utf8 de/esolutions/fw/util/serializer/ISerializer 
.const [202] = Utf8 putInt64 
.const [203] = Utf8 (J)V 
.const [204] = Utf8 de/esolutions/fw/util/serializer/ISerializer 
.const [205] = Utf8 putInt16 
.const [206] = Utf8 (S)V 
.const [207] = Utf8 de/esolutions/fw/util/serializer/ISerializer 
.const [208] = Utf8 putInt32 
.const [209] = Utf8 (I)V 
.const [210] = Utf8 de/esolutions/fw/util/serializer/ISerializer 
.const [211] = Utf8 putEnum 
.const [212] = Utf8 (I)V 
.const [213] = Utf8 de/esolutions/fw/util/serializer/ISerializer 
.const [214] = Utf8 putOptionalInt32VarArray 
.const [215] = Utf8 ([I)V 
.const [216] = Utf8 de/esolutions/fw/util/serializer/ISerializer 
.const [217] = Utf8 putInt8 
.const [218] = Utf8 (B)V 
.const [219] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [220] = Utf8 getBool 
.const [221] = Utf8 ()Z 
.const [222] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [223] = Utf8 getInt64 
.const [224] = Utf8 ()J 
.const [225] = Utf8 de/esolutions/fw/comm/asi/navigation/ncfs/sLGIEvent 
.const [226] = Utf8 id 
.const [227] = Utf8 J 
.const [228] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [229] = Utf8 getInt16 
.const [230] = Utf8 ()S 
.const [231] = Utf8 de/esolutions/fw/comm/asi/navigation/ncfs/sLGIEvent 
.const [232] = Utf8 version 
.const [233] = Utf8 S 
.const [234] = Utf8 de/esolutions/fw/comm/asi/navigation/ncfs/sLGIEvent 
.const [235] = Utf8 boundaries 
.const [236] = Utf8 Lde/esolutions/fw/comm/asi/navigation/ncfs/sBoundingBox; 
.const [237] = Utf8 de/esolutions/fw/comm/asi/navigation/ncfs/sLGIEvent 
.const [238] = Utf8 location 
.const [239] = Utf8 Lde/esolutions/fw/comm/asi/navigation/ncfs/sLocationContainer; 
.const [240] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [241] = Utf8 getInt32 
.const [242] = Utf8 ()I 
.const [243] = Utf8 de/esolutions/fw/comm/asi/navigation/ncfs/sLGIEvent 
.const [244] = Utf8 startAt 
.const [245] = Utf8 I 
.const [246] = Utf8 de/esolutions/fw/comm/asi/navigation/ncfs/sLGIEvent 
.const [247] = Utf8 endAt 
.const [248] = Utf8 I 
.const [249] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [250] = Utf8 getEnum 
.const [251] = Utf8 ()I 
.const [252] = Utf8 de/esolutions/fw/comm/asi/navigation/ncfs/sLGIEvent 
.const [253] = Utf8 eventType 
.const [254] = Utf8 I 
.const [255] = Utf8 de/esolutions/fw/comm/asi/navigation/ncfs/sLGIEvent 
.const [256] = Utf8 eventQuality 
.const [257] = Utf8 I 
.const [258] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [259] = Utf8 getOptionalInt32VarArray 
.const [260] = Utf8 ()[I 
.const [261] = Utf8 de/esolutions/fw/comm/asi/navigation/ncfs/sLGIEvent 
.const [262] = Utf8 tileIds 
.const [263] = Utf8 [I 
.const [264] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [265] = Utf8 getInt8 
.const [266] = Utf8 ()B 
.const [267] = Utf8 de/esolutions/fw/comm/asi/navigation/ncfs/sLGIEvent 
.const [268] = Utf8 minRoadclass 
.const [269] = Utf8 B 
.const [270] = Utf8 de/esolutions/fw/comm/asi/navigation/ncfs/impl/sLGIEventSerializer 
.const [271] = Class [270] 
.const [272] = Utf8 java/lang/Object 
.const [273] = Class [272] 
.const [274] = Utf8 Code 
.const [275] = Utf8 <init> 
.const [276] = Utf8 ()V 
.const [277] = Utf8 putOptionalsLGIEvent 
.const [278] = Utf8 (Lde/esolutions/fw/util/serializer/ISerializer;Lde/esolutions/fw/comm/asi/navigation/ncfs/sLGIEvent;)V 
.const [279] = Utf8 putOptionalsLGIEventVarArray 
.const [280] = Utf8 (Lde/esolutions/fw/util/serializer/ISerializer;[Lde/esolutions/fw/comm/asi/navigation/ncfs/sLGIEvent;)V 
.const [281] = Utf8 getOptionalsLGIEvent 
.const [282] = Utf8 (Lde/esolutions/fw/util/serializer/IDeserializer;)Lde/esolutions/fw/comm/asi/navigation/ncfs/sLGIEvent; 
.const [283] = Utf8 getOptionalsLGIEventVarArray 
.const [284] = Utf8 (Lde/esolutions/fw/util/serializer/IDeserializer;)[Lde/esolutions/fw/comm/asi/navigation/ncfs/sLGIEvent; 
.end class 
