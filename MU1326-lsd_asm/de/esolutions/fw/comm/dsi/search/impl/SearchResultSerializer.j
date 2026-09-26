.version 50 0 
.class public super [311] 
.super [313] 

.method public annotation [315] : [316] 
    .attribute [314] .code stack 1 locals 0 
L0:     aload_0 
L1:     invokespecial [35] 
L4:     return 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public static [317] : [318] 
    .attribute [314] .code stack 3 locals 16 
L0:     aload_1 
L1:     ifnonnull L8 
L4:     iconst_1 
L5:     goto L9 
L8:     iconst_0 
L9:     istore_2 
L10:    aload_0 
L11:    iload_2 
L12:    invokeinterface [37] 0 
L17:    iload_2 
L18:    ifne L207 
L21:    aload_1 
L22:    invokevirtual [21] 
L25:    istore_3 
L26:    aload_0 
L27:    iload_3 
L28:    invokeinterface [38] 0 
L33:    aload_1 
L34:    invokevirtual [22] 
L37:    istore 4 
L39:    aload_0 
L40:    iload 4 
L42:    invokeinterface [38] 0 
L47:    aload_1 
L48:    invokevirtual [23] 
L51:    istore 5 
L53:    aload_0 
L54:    iload 5 
L56:    invokeinterface [38] 0 
L61:    aload_1 
L62:    invokevirtual [24] 
L65:    istore 6 
L67:    aload_0 
L68:    iload 6 
L70:    invokeinterface [38] 0 
L75:    aload_1 
L76:    invokevirtual [25] 
L79:    istore 7 
L81:    aload_0 
L82:    iload 7 
L84:    invokeinterface [38] 0 
L89:    aload_1 
L90:    invokevirtual [26] 
L93:    istore 8 
L95:    aload_0 
L96:    iload 8 
L98:    invokeinterface [38] 0 
L103:   aload_1 
L104:   invokevirtual [27] 
L107:   istore 9 
L109:   aload_0 
L110:   iload 9 
L112:   invokeinterface [38] 0 
L117:   aload_1 
L118:   invokevirtual [28] 
L121:   astore 10 
L123:   aload_0 
L124:   aload 10 
L126:   invokestatic [2] 
L129:   aload_1 
L130:   invokevirtual [29] 
L133:   istore 11 
L135:   aload_0 
L136:   iload 11 
L138:   invokeinterface [38] 0 
L143:   aload_1 
L144:   invokevirtual [30] 
L147:   lstore 12 
L149:   aload_0 
L150:   lload 12 
L152:   invokeinterface [39] 0 
L157:   aload_1 
L158:   invokevirtual [31] 
L161:   astore 14 
L163:   aload_0 
L164:   aload 14 
L166:   invokestatic [3] 
L169:   aload_1 
L170:   invokevirtual [32] 
L173:   astore 15 
L175:   aload_0 
L176:   aload 15 
L178:   invokestatic [4] 
L181:   aload_1 
L182:   invokevirtual [33] 
L185:   astore 16 
L187:   aload_0 
L188:   aload 16 
L190:   invokestatic [5] 
L193:   aload_1 
L194:   invokevirtual [34] 
L197:   astore 17 
L199:   aload_0 
L200:   aload 17 
L202:   invokeinterface [40] 0 
L207:   return 
L208:   
    .end code 
.end method 

.method public static [319] : [320] 
    .attribute [314] .code stack 3 locals 2 
L0:     aload_1 
L1:     ifnonnull L8 
L4:     iconst_1 
L5:     goto L9 
L8:     iconst_0 
L9:     istore_2 
L10:    aload_0 
L11:    iload_2 
L12:    invokeinterface [37] 0 
L17:    iload_2 
L18:    ifne L50 
L21:    aload_0 
L22:    aload_1 
L23:    arraylength 
L24:    invokeinterface [38] 0 
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
L41:    invokestatic [6] 
L44:    iinc 3 1 
L47:    goto L31 
L50:    return 
L51:    nop 
L52:    
    .end code 
.end method 

.method public static [321] : [322] 
    .attribute [314] .code stack 3 locals 17 
L0:     aconst_null 
L1:     astore_1 
L2:     aload_0 
L3:     invokeinterface [41] 0 
L8:     istore_2 
L9:     iload_2 
L10:    ifne L207 
L13:    new [42] 
L16:    dup 
L17:    invokespecial [36] 
L20:    astore_1 
L21:    aload_0 
L22:    invokeinterface [43] 0 
L27:    istore_3 
L28:    aload_1 
L29:    iload_3 
L30:    putfield [44] 
L33:    aload_0 
L34:    invokeinterface [43] 0 
L39:    istore 4 
L41:    aload_1 
L42:    iload 4 
L44:    putfield [45] 
L47:    aload_0 
L48:    invokeinterface [43] 0 
L53:    istore 5 
L55:    aload_1 
L56:    iload 5 
L58:    putfield [46] 
L61:    aload_0 
L62:    invokeinterface [43] 0 
L67:    istore 6 
L69:    aload_1 
L70:    iload 6 
L72:    putfield [47] 
L75:    aload_0 
L76:    invokeinterface [43] 0 
L81:    istore 7 
L83:    aload_1 
L84:    iload 7 
L86:    putfield [48] 
L89:    aload_0 
L90:    invokeinterface [43] 0 
L95:    istore 8 
L97:    aload_1 
L98:    iload 8 
L100:   putfield [49] 
L103:   aload_0 
L104:   invokeinterface [43] 0 
L109:   istore 9 
L111:   aload_1 
L112:   iload 9 
L114:   putfield [50] 
L117:   aload_0 
L118:   invokestatic [8] 
L121:   astore 10 
L123:   aload_1 
L124:   aload 10 
L126:   putfield [51] 
L129:   aload_0 
L130:   invokeinterface [43] 0 
L135:   istore 11 
L137:   aload_1 
L138:   iload 11 
L140:   putfield [52] 
L143:   aload_0 
L144:   invokeinterface [53] 0 
L149:   lstore 12 
L151:   aload_1 
L152:   lload 12 
L154:   putfield [54] 
L157:   aload_0 
L158:   invokestatic [9] 
L161:   astore 14 
L163:   aload_1 
L164:   aload 14 
L166:   putfield [55] 
L169:   aload_0 
L170:   invokestatic [10] 
L173:   astore 15 
L175:   aload_1 
L176:   aload 15 
L178:   putfield [56] 
L181:   aload_0 
L182:   invokestatic [11] 
L185:   astore 16 
L187:   aload_1 
L188:   aload 16 
L190:   putfield [57] 
L193:   aload_0 
L194:   invokeinterface [58] 0 
L199:   astore 17 
L201:   aload_1 
L202:   aload 17 
L204:   putfield [59] 
L207:   aload_1 
L208:   areturn 
L209:   nop 
L210:   nop 
L211:   nop 
L212:   
    .end code 
.end method 

.method public static [323] : [324] 
    .attribute [314] .code stack 3 locals 4 
L0:     aconst_null 
L1:     astore_1 
L2:     aload_0 
L3:     invokeinterface [41] 0 
L8:     istore_2 
L9:     iload_2 
L10:    ifne L48 
L13:    aload_0 
L14:    invokeinterface [43] 0 
L19:    istore_3 
L20:    iload_3 
L21:    anewarray [7] 
L24:    astore_1 
L25:    iconst_0 
L26:    istore 4 
L28:    iload 4 
L30:    iload_3 
L31:    if_icmpge L48 
L34:    aload_1 
L35:    iload 4 
L37:    aload_0 
L38:    invokestatic [12] 
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
.const [5] = Method [66] [67] 
.const [6] = Method [68] [69] 
.const [7] = Class [70] 
.const [8] = Method [71] [72] 
.const [9] = Method [73] [74] 
.const [10] = Method [75] [76] 
.const [11] = Method [77] [78] 
.const [12] = Method [79] [80] 
.const [13] = Class [81] 
.const [14] = Class [82] 
.const [15] = Class [83] 
.const [16] = Class [84] 
.const [17] = Class [85] 
.const [18] = Class [86] 
.const [19] = Class [87] 
.const [20] = Class [88] 
.const [21] = Method [89] [90] 
.const [22] = Method [91] [92] 
.const [23] = Method [93] [94] 
.const [24] = Method [95] [96] 
.const [25] = Method [97] [98] 
.const [26] = Method [99] [100] 
.const [27] = Method [101] [102] 
.const [28] = Method [103] [104] 
.const [29] = Method [105] [106] 
.const [30] = Method [107] [108] 
.const [31] = Method [109] [110] 
.const [32] = Method [111] [112] 
.const [33] = Method [113] [114] 
.const [34] = Method [115] [116] 
.const [35] = Method [117] [118] 
.const [36] = Method [119] [120] 
.const [37] = InterfaceMethod [121] [122] 
.const [38] = InterfaceMethod [123] [124] 
.const [39] = InterfaceMethod [125] [126] 
.const [40] = InterfaceMethod [127] [128] 
.const [41] = InterfaceMethod [129] [130] 
.const [42] = Class [131] 
.const [43] = InterfaceMethod [132] [133] 
.const [44] = Field [134] [135] 
.const [45] = Field [136] [137] 
.const [46] = Field [138] [139] 
.const [47] = Field [140] [141] 
.const [48] = Field [142] [143] 
.const [49] = Field [144] [145] 
.const [50] = Field [146] [147] 
.const [51] = Field [148] [149] 
.const [52] = Field [150] [151] 
.const [53] = InterfaceMethod [152] [153] 
.const [54] = Field [154] [155] 
.const [55] = Field [156] [157] 
.const [56] = Field [158] [159] 
.const [57] = Field [160] [161] 
.const [58] = InterfaceMethod [162] [163] 
.const [59] = Field [164] [165] 
.const [60] = Class [166] 
.const [61] = NameAndType [167] [168] 
.const [62] = Class [169] 
.const [63] = NameAndType [170] [171] 
.const [64] = Class [172] 
.const [65] = NameAndType [173] [174] 
.const [66] = Class [175] 
.const [67] = NameAndType [176] [177] 
.const [68] = Class [178] 
.const [69] = NameAndType [179] [180] 
.const [70] = Utf8 org/dsi/ifc/search/SearchResult 
.const [71] = Class [181] 
.const [72] = NameAndType [182] [183] 
.const [73] = Class [184] 
.const [74] = NameAndType [185] [186] 
.const [75] = Class [187] 
.const [76] = NameAndType [188] [189] 
.const [77] = Class [190] 
.const [78] = NameAndType [191] [192] 
.const [79] = Class [193] 
.const [80] = NameAndType [194] [195] 
.const [81] = Utf8 de/esolutions/fw/comm/dsi/search/impl/SearchResultSerializer 
.const [82] = Utf8 java/lang/Object 
.const [83] = Utf8 de/esolutions/fw/util/serializer/ISerializer 
.const [84] = Utf8 de/esolutions/fw/comm/dsi/search/impl/NavPositionSerializer 
.const [85] = Utf8 de/esolutions/fw/comm/dsi/search/impl/TokenSerializer 
.const [86] = Utf8 de/esolutions/fw/comm/dsi/search/impl/SuggestionSerializer 
.const [87] = Utf8 de/esolutions/fw/comm/dsi/search/impl/CountrySerializer 
.const [88] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [89] = Class [196] 
.const [90] = NameAndType [197] [198] 
.const [91] = Class [199] 
.const [92] = NameAndType [200] [201] 
.const [93] = Class [202] 
.const [94] = NameAndType [203] [204] 
.const [95] = Class [205] 
.const [96] = NameAndType [206] [207] 
.const [97] = Class [208] 
.const [98] = NameAndType [209] [210] 
.const [99] = Class [211] 
.const [100] = NameAndType [212] [213] 
.const [101] = Class [214] 
.const [102] = NameAndType [215] [216] 
.const [103] = Class [217] 
.const [104] = NameAndType [218] [219] 
.const [105] = Class [220] 
.const [106] = NameAndType [221] [222] 
.const [107] = Class [223] 
.const [108] = NameAndType [224] [225] 
.const [109] = Class [226] 
.const [110] = NameAndType [227] [228] 
.const [111] = Class [229] 
.const [112] = NameAndType [230] [231] 
.const [113] = Class [232] 
.const [114] = NameAndType [233] [234] 
.const [115] = Class [235] 
.const [116] = NameAndType [236] [237] 
.const [117] = Class [238] 
.const [118] = NameAndType [239] [240] 
.const [119] = Class [241] 
.const [120] = NameAndType [242] [243] 
.const [121] = Class [244] 
.const [122] = NameAndType [245] [246] 
.const [123] = Class [247] 
.const [124] = NameAndType [248] [249] 
.const [125] = Class [250] 
.const [126] = NameAndType [251] [252] 
.const [127] = Class [253] 
.const [128] = NameAndType [254] [255] 
.const [129] = Class [256] 
.const [130] = NameAndType [257] [258] 
.const [131] = Utf8 org/dsi/ifc/search/SearchResult 
.const [132] = Class [259] 
.const [133] = NameAndType [260] [261] 
.const [134] = Class [262] 
.const [135] = NameAndType [263] [264] 
.const [136] = Class [265] 
.const [137] = NameAndType [266] [267] 
.const [138] = Class [268] 
.const [139] = NameAndType [269] [270] 
.const [140] = Class [271] 
.const [141] = NameAndType [272] [273] 
.const [142] = Class [274] 
.const [143] = NameAndType [275] [276] 
.const [144] = Class [277] 
.const [145] = NameAndType [278] [279] 
.const [146] = Class [280] 
.const [147] = NameAndType [281] [282] 
.const [148] = Class [283] 
.const [149] = NameAndType [284] [285] 
.const [150] = Class [286] 
.const [151] = NameAndType [287] [288] 
.const [152] = Class [289] 
.const [153] = NameAndType [290] [291] 
.const [154] = Class [292] 
.const [155] = NameAndType [293] [294] 
.const [156] = Class [295] 
.const [157] = NameAndType [296] [297] 
.const [158] = Class [298] 
.const [159] = NameAndType [299] [300] 
.const [160] = Class [301] 
.const [161] = NameAndType [302] [303] 
.const [162] = Class [304] 
.const [163] = NameAndType [305] [306] 
.const [164] = Class [307] 
.const [165] = NameAndType [308] [309] 
.const [166] = Utf8 de/esolutions/fw/comm/dsi/search/impl/NavPositionSerializer 
.const [167] = Utf8 putOptionalNavPosition 
.const [168] = Utf8 (Lde/esolutions/fw/util/serializer/ISerializer;Lorg/dsi/ifc/search/NavPosition;)V 
.const [169] = Utf8 de/esolutions/fw/comm/dsi/search/impl/TokenSerializer 
.const [170] = Utf8 putOptionalTokenVarArray 
.const [171] = Utf8 (Lde/esolutions/fw/util/serializer/ISerializer;[Lorg/dsi/ifc/search/Token;)V 
.const [172] = Utf8 de/esolutions/fw/comm/dsi/search/impl/SuggestionSerializer 
.const [173] = Utf8 putOptionalSuggestion 
.const [174] = Utf8 (Lde/esolutions/fw/util/serializer/ISerializer;Lorg/dsi/ifc/search/Suggestion;)V 
.const [175] = Utf8 de/esolutions/fw/comm/dsi/search/impl/CountrySerializer 
.const [176] = Utf8 putOptionalCountry 
.const [177] = Utf8 (Lde/esolutions/fw/util/serializer/ISerializer;Lorg/dsi/ifc/search/Country;)V 
.const [178] = Utf8 de/esolutions/fw/comm/dsi/search/impl/SearchResultSerializer 
.const [179] = Utf8 putOptionalSearchResult 
.const [180] = Utf8 (Lde/esolutions/fw/util/serializer/ISerializer;Lorg/dsi/ifc/search/SearchResult;)V 
.const [181] = Utf8 de/esolutions/fw/comm/dsi/search/impl/NavPositionSerializer 
.const [182] = Utf8 getOptionalNavPosition 
.const [183] = Utf8 (Lde/esolutions/fw/util/serializer/IDeserializer;)Lorg/dsi/ifc/search/NavPosition; 
.const [184] = Utf8 de/esolutions/fw/comm/dsi/search/impl/TokenSerializer 
.const [185] = Utf8 getOptionalTokenVarArray 
.const [186] = Utf8 (Lde/esolutions/fw/util/serializer/IDeserializer;)[Lorg/dsi/ifc/search/Token; 
.const [187] = Utf8 de/esolutions/fw/comm/dsi/search/impl/SuggestionSerializer 
.const [188] = Utf8 getOptionalSuggestion 
.const [189] = Utf8 (Lde/esolutions/fw/util/serializer/IDeserializer;)Lorg/dsi/ifc/search/Suggestion; 
.const [190] = Utf8 de/esolutions/fw/comm/dsi/search/impl/CountrySerializer 
.const [191] = Utf8 getOptionalCountry 
.const [192] = Utf8 (Lde/esolutions/fw/util/serializer/IDeserializer;)Lorg/dsi/ifc/search/Country; 
.const [193] = Utf8 de/esolutions/fw/comm/dsi/search/impl/SearchResultSerializer 
.const [194] = Utf8 getOptionalSearchResult 
.const [195] = Utf8 (Lde/esolutions/fw/util/serializer/IDeserializer;)Lorg/dsi/ifc/search/SearchResult; 
.const [196] = Utf8 org/dsi/ifc/search/SearchResult 
.const [197] = Utf8 getQueryId 
.const [198] = Utf8 ()I 
.const [199] = Utf8 org/dsi/ifc/search/SearchResult 
.const [200] = Utf8 getSource 
.const [201] = Utf8 ()I 
.const [202] = Utf8 org/dsi/ifc/search/SearchResult 
.const [203] = Utf8 getListPosition 
.const [204] = Utf8 ()I 
.const [205] = Utf8 org/dsi/ifc/search/SearchResult 
.const [206] = Utf8 getEntryType 
.const [207] = Utf8 ()I 
.const [208] = Utf8 org/dsi/ifc/search/SearchResult 
.const [209] = Utf8 getEntryFlags 
.const [210] = Utf8 ()I 
.const [211] = Utf8 org/dsi/ifc/search/SearchResult 
.const [212] = Utf8 getPoiType 
.const [213] = Utf8 ()I 
.const [214] = Utf8 org/dsi/ifc/search/SearchResult 
.const [215] = Utf8 getIconID 
.const [216] = Utf8 ()I 
.const [217] = Utf8 org/dsi/ifc/search/SearchResult 
.const [218] = Utf8 getPosition 
.const [219] = Utf8 ()Lorg/dsi/ifc/search/NavPosition; 
.const [220] = Utf8 org/dsi/ifc/search/SearchResult 
.const [221] = Utf8 getDistanceMeters 
.const [222] = Utf8 ()I 
.const [223] = Utf8 org/dsi/ifc/search/SearchResult 
.const [224] = Utf8 getDataId 
.const [225] = Utf8 ()J 
.const [226] = Utf8 org/dsi/ifc/search/SearchResult 
.const [227] = Utf8 getTokens 
.const [228] = Utf8 ()[Lorg/dsi/ifc/search/Token; 
.const [229] = Utf8 org/dsi/ifc/search/SearchResult 
.const [230] = Utf8 getSuggestion 
.const [231] = Utf8 ()Lorg/dsi/ifc/search/Suggestion; 
.const [232] = Utf8 org/dsi/ifc/search/SearchResult 
.const [233] = Utf8 getCountry 
.const [234] = Utf8 ()Lorg/dsi/ifc/search/Country; 
.const [235] = Utf8 org/dsi/ifc/search/SearchResult 
.const [236] = Utf8 getApplicationData 
.const [237] = Utf8 ()[B 
.const [238] = Utf8 java/lang/Object 
.const [239] = Utf8 <init> 
.const [240] = Utf8 ()V 
.const [241] = Utf8 org/dsi/ifc/search/SearchResult 
.const [242] = Utf8 <init> 
.const [243] = Utf8 ()V 
.const [244] = Utf8 de/esolutions/fw/util/serializer/ISerializer 
.const [245] = Utf8 putBool 
.const [246] = Utf8 (Z)V 
.const [247] = Utf8 de/esolutions/fw/util/serializer/ISerializer 
.const [248] = Utf8 putInt32 
.const [249] = Utf8 (I)V 
.const [250] = Utf8 de/esolutions/fw/util/serializer/ISerializer 
.const [251] = Utf8 putInt64 
.const [252] = Utf8 (J)V 
.const [253] = Utf8 de/esolutions/fw/util/serializer/ISerializer 
.const [254] = Utf8 putOptionalInt8VarArray 
.const [255] = Utf8 ([B)V 
.const [256] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [257] = Utf8 getBool 
.const [258] = Utf8 ()Z 
.const [259] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [260] = Utf8 getInt32 
.const [261] = Utf8 ()I 
.const [262] = Utf8 org/dsi/ifc/search/SearchResult 
.const [263] = Utf8 queryId 
.const [264] = Utf8 I 
.const [265] = Utf8 org/dsi/ifc/search/SearchResult 
.const [266] = Utf8 source 
.const [267] = Utf8 I 
.const [268] = Utf8 org/dsi/ifc/search/SearchResult 
.const [269] = Utf8 listPosition 
.const [270] = Utf8 I 
.const [271] = Utf8 org/dsi/ifc/search/SearchResult 
.const [272] = Utf8 entryType 
.const [273] = Utf8 I 
.const [274] = Utf8 org/dsi/ifc/search/SearchResult 
.const [275] = Utf8 entryFlags 
.const [276] = Utf8 I 
.const [277] = Utf8 org/dsi/ifc/search/SearchResult 
.const [278] = Utf8 poiType 
.const [279] = Utf8 I 
.const [280] = Utf8 org/dsi/ifc/search/SearchResult 
.const [281] = Utf8 iconID 
.const [282] = Utf8 I 
.const [283] = Utf8 org/dsi/ifc/search/SearchResult 
.const [284] = Utf8 position 
.const [285] = Utf8 Lorg/dsi/ifc/search/NavPosition; 
.const [286] = Utf8 org/dsi/ifc/search/SearchResult 
.const [287] = Utf8 distanceMeters 
.const [288] = Utf8 I 
.const [289] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [290] = Utf8 getInt64 
.const [291] = Utf8 ()J 
.const [292] = Utf8 org/dsi/ifc/search/SearchResult 
.const [293] = Utf8 dataId 
.const [294] = Utf8 J 
.const [295] = Utf8 org/dsi/ifc/search/SearchResult 
.const [296] = Utf8 tokens 
.const [297] = Utf8 [Lorg/dsi/ifc/search/Token; 
.const [298] = Utf8 org/dsi/ifc/search/SearchResult 
.const [299] = Utf8 suggestion 
.const [300] = Utf8 Lorg/dsi/ifc/search/Suggestion; 
.const [301] = Utf8 org/dsi/ifc/search/SearchResult 
.const [302] = Utf8 country 
.const [303] = Utf8 Lorg/dsi/ifc/search/Country; 
.const [304] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [305] = Utf8 getOptionalInt8VarArray 
.const [306] = Utf8 ()[B 
.const [307] = Utf8 org/dsi/ifc/search/SearchResult 
.const [308] = Utf8 applicationData 
.const [309] = Utf8 [B 
.const [310] = Utf8 de/esolutions/fw/comm/dsi/search/impl/SearchResultSerializer 
.const [311] = Class [310] 
.const [312] = Utf8 java/lang/Object 
.const [313] = Class [312] 
.const [314] = Utf8 Code 
.const [315] = Utf8 <init> 
.const [316] = Utf8 ()V 
.const [317] = Utf8 putOptionalSearchResult 
.const [318] = Utf8 (Lde/esolutions/fw/util/serializer/ISerializer;Lorg/dsi/ifc/search/SearchResult;)V 
.const [319] = Utf8 putOptionalSearchResultVarArray 
.const [320] = Utf8 (Lde/esolutions/fw/util/serializer/ISerializer;[Lorg/dsi/ifc/search/SearchResult;)V 
.const [321] = Utf8 getOptionalSearchResult 
.const [322] = Utf8 (Lde/esolutions/fw/util/serializer/IDeserializer;)Lorg/dsi/ifc/search/SearchResult; 
.const [323] = Utf8 getOptionalSearchResultVarArray 
.const [324] = Utf8 (Lde/esolutions/fw/util/serializer/IDeserializer;)[Lorg/dsi/ifc/search/SearchResult; 
.end class 
