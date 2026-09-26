.version 50 0 
.class public super [313] 
.super [315] 

.method public annotation [317] : [318] 
    .attribute [316] .code stack 1 locals 0 
L0:     aload_0 
L1:     invokespecial [37] 
L4:     return 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public static [319] : [320] 
    .attribute [316] .code stack 3 locals 18 
L0:     aload_1 
L1:     ifnonnull L8 
L4:     iconst_1 
L5:     goto L9 
L8:     iconst_0 
L9:     istore_2 
L10:    aload_0 
L11:    iload_2 
L12:    invokeinterface [39] 0 
L17:    iload_2 
L18:    ifne L191 
L21:    aload_1 
L22:    invokevirtual [24] 
L25:    lstore_3 
L26:    aload_0 
L27:    lload_3 
L28:    invokeinterface [40] 0 
L33:    aload_1 
L34:    invokevirtual [25] 
L37:    lstore 5 
L39:    aload_0 
L40:    lload 5 
L42:    invokeinterface [40] 0 
L47:    aload_1 
L48:    invokevirtual [26] 
L51:    astore 7 
L53:    aload_0 
L54:    aload 7 
L56:    invokeinterface [41] 0 
L61:    aload_1 
L62:    invokevirtual [27] 
L65:    astore 8 
L67:    aload_0 
L68:    aload 8 
L70:    invokeinterface [41] 0 
L75:    aload_1 
L76:    invokevirtual [28] 
L79:    istore 9 
L81:    aload_0 
L82:    iload 9 
L84:    invokeinterface [42] 0 
L89:    aload_1 
L90:    invokevirtual [29] 
L93:    istore 10 
L95:    aload_0 
L96:    iload 10 
L98:    invokeinterface [42] 0 
L103:   aload_1 
L104:   invokevirtual [30] 
L107:   lstore 11 
L109:   aload_0 
L110:   lload 11 
L112:   invokeinterface [40] 0 
L117:   aload_1 
L118:   invokevirtual [31] 
L121:   lstore 13 
L123:   aload_0 
L124:   lload 13 
L126:   invokeinterface [40] 0 
L131:   aload_1 
L132:   invokevirtual [32] 
L135:   astore 15 
L137:   aload_0 
L138:   aload 15 
L140:   invokestatic [2] 
L143:   aload_1 
L144:   invokevirtual [33] 
L147:   astore 16 
L149:   aload_0 
L150:   aload 16 
L152:   invokestatic [3] 
L155:   aload_1 
L156:   invokevirtual [34] 
L159:   astore 17 
L161:   aload_0 
L162:   aload 17 
L164:   invokestatic [4] 
L167:   aload_1 
L168:   invokevirtual [35] 
L171:   astore 18 
L173:   aload_0 
L174:   aload 18 
L176:   invokestatic [5] 
L179:   aload_1 
L180:   invokevirtual [36] 
L183:   astore 19 
L185:   aload_0 
L186:   aload 19 
L188:   invokestatic [6] 
L191:   return 
L192:   
    .end code 
.end method 

.method public static [321] : [322] 
    .attribute [316] .code stack 3 locals 2 
L0:     aload_1 
L1:     ifnonnull L8 
L4:     iconst_1 
L5:     goto L9 
L8:     iconst_0 
L9:     istore_2 
L10:    aload_0 
L11:    iload_2 
L12:    invokeinterface [39] 0 
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
L41:    invokestatic [7] 
L44:    iinc 3 1 
L47:    goto L31 
L50:    return 
L51:    nop 
L52:    
    .end code 
.end method 

.method public static [323] : [324] 
    .attribute [316] .code stack 3 locals 19 
L0:     aconst_null 
L1:     astore_1 
L2:     aload_0 
L3:     invokeinterface [43] 0 
L8:     istore_2 
L9:     iload_2 
L10:    ifne L191 
L13:    new [44] 
L16:    dup 
L17:    invokespecial [38] 
L20:    astore_1 
L21:    aload_0 
L22:    invokeinterface [45] 0 
L27:    lstore_3 
L28:    aload_1 
L29:    lload_3 
L30:    putfield [46] 
L33:    aload_0 
L34:    invokeinterface [45] 0 
L39:    lstore 5 
L41:    aload_1 
L42:    lload 5 
L44:    putfield [47] 
L47:    aload_0 
L48:    invokeinterface [48] 0 
L53:    astore 7 
L55:    aload_1 
L56:    aload 7 
L58:    putfield [49] 
L61:    aload_0 
L62:    invokeinterface [48] 0 
L67:    astore 8 
L69:    aload_1 
L70:    aload 8 
L72:    putfield [50] 
L75:    aload_0 
L76:    invokeinterface [51] 0 
L81:    istore 9 
L83:    aload_1 
L84:    iload 9 
L86:    putfield [52] 
L89:    aload_0 
L90:    invokeinterface [51] 0 
L95:    istore 10 
L97:    aload_1 
L98:    iload 10 
L100:   putfield [53] 
L103:   aload_0 
L104:   invokeinterface [45] 0 
L109:   lstore 11 
L111:   aload_1 
L112:   lload 11 
L114:   putfield [54] 
L117:   aload_0 
L118:   invokeinterface [45] 0 
L123:   lstore 13 
L125:   aload_1 
L126:   lload 13 
L128:   putfield [55] 
L131:   aload_0 
L132:   invokestatic [9] 
L135:   astore 15 
L137:   aload_1 
L138:   aload 15 
L140:   putfield [56] 
L143:   aload_0 
L144:   invokestatic [10] 
L147:   astore 16 
L149:   aload_1 
L150:   aload 16 
L152:   putfield [57] 
L155:   aload_0 
L156:   invokestatic [11] 
L159:   astore 17 
L161:   aload_1 
L162:   aload 17 
L164:   putfield [58] 
L167:   aload_0 
L168:   invokestatic [12] 
L171:   astore 18 
L173:   aload_1 
L174:   aload 18 
L176:   putfield [59] 
L179:   aload_0 
L180:   invokestatic [13] 
L183:   astore 19 
L185:   aload_1 
L186:   aload 19 
L188:   putfield [60] 
L191:   aload_1 
L192:   areturn 
L193:   nop 
L194:   nop 
L195:   nop 
L196:   
    .end code 
.end method 

.method public static [325] : [326] 
    .attribute [316] .code stack 3 locals 4 
L0:     aconst_null 
L1:     astore_1 
L2:     aload_0 
L3:     invokeinterface [43] 0 
L8:     istore_2 
L9:     iload_2 
L10:    ifne L48 
L13:    aload_0 
L14:    invokeinterface [51] 0 
L19:    istore_3 
L20:    iload_3 
L21:    anewarray [8] 
L24:    astore_1 
L25:    iconst_0 
L26:    istore 4 
L28:    iload 4 
L30:    iload_3 
L31:    if_icmpge L48 
L34:    aload_1 
L35:    iload 4 
L37:    aload_0 
L38:    invokestatic [14] 
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
.const [4] = Method [65] [66] 
.const [5] = Method [67] [68] 
.const [6] = Method [69] [70] 
.const [7] = Method [71] [72] 
.const [8] = Class [73] 
.const [9] = Method [74] [75] 
.const [10] = Method [76] [77] 
.const [11] = Method [78] [79] 
.const [12] = Method [80] [81] 
.const [13] = Method [82] [83] 
.const [14] = Method [84] [85] 
.const [15] = Class [86] 
.const [16] = Class [87] 
.const [17] = Class [88] 
.const [18] = Class [89] 
.const [19] = Class [90] 
.const [20] = Class [91] 
.const [21] = Class [92] 
.const [22] = Class [93] 
.const [23] = Class [94] 
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
.const [37] = Method [121] [122] 
.const [38] = Method [123] [124] 
.const [39] = InterfaceMethod [125] [126] 
.const [40] = InterfaceMethod [127] [128] 
.const [41] = InterfaceMethod [129] [130] 
.const [42] = InterfaceMethod [131] [132] 
.const [43] = InterfaceMethod [133] [134] 
.const [44] = Class [135] 
.const [45] = InterfaceMethod [136] [137] 
.const [46] = Field [138] [139] 
.const [47] = Field [140] [141] 
.const [48] = InterfaceMethod [142] [143] 
.const [49] = Field [144] [145] 
.const [50] = Field [146] [147] 
.const [51] = InterfaceMethod [148] [149] 
.const [52] = Field [150] [151] 
.const [53] = Field [152] [153] 
.const [54] = Field [154] [155] 
.const [55] = Field [156] [157] 
.const [56] = Field [158] [159] 
.const [57] = Field [160] [161] 
.const [58] = Field [162] [163] 
.const [59] = Field [164] [165] 
.const [60] = Field [166] [167] 
.const [61] = Class [168] 
.const [62] = NameAndType [169] [170] 
.const [63] = Class [171] 
.const [64] = NameAndType [172] [173] 
.const [65] = Class [174] 
.const [66] = NameAndType [175] [176] 
.const [67] = Class [177] 
.const [68] = NameAndType [178] [179] 
.const [69] = Class [180] 
.const [70] = NameAndType [181] [182] 
.const [71] = Class [183] 
.const [72] = NameAndType [184] [185] 
.const [73] = Utf8 org/dsi/ifc/online/PortalADBEntry 
.const [74] = Class [186] 
.const [75] = NameAndType [187] [188] 
.const [76] = Class [189] 
.const [77] = NameAndType [190] [191] 
.const [78] = Class [192] 
.const [79] = NameAndType [193] [194] 
.const [80] = Class [195] 
.const [81] = NameAndType [196] [197] 
.const [82] = Class [198] 
.const [83] = NameAndType [199] [200] 
.const [84] = Class [201] 
.const [85] = NameAndType [202] [203] 
.const [86] = Utf8 de/esolutions/fw/comm/dsi/online/impl/PortalADBEntrySerializer 
.const [87] = Utf8 java/lang/Object 
.const [88] = Utf8 de/esolutions/fw/util/serializer/ISerializer 
.const [89] = Utf8 de/esolutions/fw/comm/dsi/online/impl/PortalPersonalDataSerializer 
.const [90] = Utf8 de/esolutions/fw/comm/dsi/online/impl/PortalPhoneDataSerializer 
.const [91] = Utf8 de/esolutions/fw/comm/dsi/online/impl/PortalAddressDataSerializer 
.const [92] = Utf8 de/esolutions/fw/comm/dsi/online/impl/PortalNavigationDataSerializer 
.const [93] = Utf8 de/esolutions/fw/comm/dsi/online/impl/PortalMessagingDataSerializer 
.const [94] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [95] = Class [204] 
.const [96] = NameAndType [205] [206] 
.const [97] = Class [207] 
.const [98] = NameAndType [208] [209] 
.const [99] = Class [210] 
.const [100] = NameAndType [211] [212] 
.const [101] = Class [213] 
.const [102] = NameAndType [214] [215] 
.const [103] = Class [216] 
.const [104] = NameAndType [217] [218] 
.const [105] = Class [219] 
.const [106] = NameAndType [220] [221] 
.const [107] = Class [222] 
.const [108] = NameAndType [223] [224] 
.const [109] = Class [225] 
.const [110] = NameAndType [226] [227] 
.const [111] = Class [228] 
.const [112] = NameAndType [229] [230] 
.const [113] = Class [231] 
.const [114] = NameAndType [232] [233] 
.const [115] = Class [234] 
.const [116] = NameAndType [235] [236] 
.const [117] = Class [237] 
.const [118] = NameAndType [238] [239] 
.const [119] = Class [240] 
.const [120] = NameAndType [241] [242] 
.const [121] = Class [243] 
.const [122] = NameAndType [244] [245] 
.const [123] = Class [246] 
.const [124] = NameAndType [247] [248] 
.const [125] = Class [249] 
.const [126] = NameAndType [250] [251] 
.const [127] = Class [252] 
.const [128] = NameAndType [253] [254] 
.const [129] = Class [255] 
.const [130] = NameAndType [256] [257] 
.const [131] = Class [258] 
.const [132] = NameAndType [259] [260] 
.const [133] = Class [261] 
.const [134] = NameAndType [262] [263] 
.const [135] = Utf8 org/dsi/ifc/online/PortalADBEntry 
.const [136] = Class [264] 
.const [137] = NameAndType [265] [266] 
.const [138] = Class [267] 
.const [139] = NameAndType [268] [269] 
.const [140] = Class [270] 
.const [141] = NameAndType [271] [272] 
.const [142] = Class [273] 
.const [143] = NameAndType [274] [275] 
.const [144] = Class [276] 
.const [145] = NameAndType [277] [278] 
.const [146] = Class [279] 
.const [147] = NameAndType [280] [281] 
.const [148] = Class [282] 
.const [149] = NameAndType [283] [284] 
.const [150] = Class [285] 
.const [151] = NameAndType [286] [287] 
.const [152] = Class [288] 
.const [153] = NameAndType [289] [290] 
.const [154] = Class [291] 
.const [155] = NameAndType [292] [293] 
.const [156] = Class [294] 
.const [157] = NameAndType [295] [296] 
.const [158] = Class [297] 
.const [159] = NameAndType [298] [299] 
.const [160] = Class [300] 
.const [161] = NameAndType [301] [302] 
.const [162] = Class [303] 
.const [163] = NameAndType [304] [305] 
.const [164] = Class [306] 
.const [165] = NameAndType [307] [308] 
.const [166] = Class [309] 
.const [167] = NameAndType [310] [311] 
.const [168] = Utf8 de/esolutions/fw/comm/dsi/online/impl/PortalPersonalDataSerializer 
.const [169] = Utf8 putOptionalPortalPersonalData 
.const [170] = Utf8 (Lde/esolutions/fw/util/serializer/ISerializer;Lorg/dsi/ifc/online/PortalPersonalData;)V 
.const [171] = Utf8 de/esolutions/fw/comm/dsi/online/impl/PortalPhoneDataSerializer 
.const [172] = Utf8 putOptionalPortalPhoneDataVarArray 
.const [173] = Utf8 (Lde/esolutions/fw/util/serializer/ISerializer;[Lorg/dsi/ifc/online/PortalPhoneData;)V 
.const [174] = Utf8 de/esolutions/fw/comm/dsi/online/impl/PortalAddressDataSerializer 
.const [175] = Utf8 putOptionalPortalAddressDataVarArray 
.const [176] = Utf8 (Lde/esolutions/fw/util/serializer/ISerializer;[Lorg/dsi/ifc/online/PortalAddressData;)V 
.const [177] = Utf8 de/esolutions/fw/comm/dsi/online/impl/PortalNavigationDataSerializer 
.const [178] = Utf8 putOptionalPortalNavigationDataVarArray 
.const [179] = Utf8 (Lde/esolutions/fw/util/serializer/ISerializer;[Lorg/dsi/ifc/online/PortalNavigationData;)V 
.const [180] = Utf8 de/esolutions/fw/comm/dsi/online/impl/PortalMessagingDataSerializer 
.const [181] = Utf8 putOptionalPortalMessagingDataVarArray 
.const [182] = Utf8 (Lde/esolutions/fw/util/serializer/ISerializer;[Lorg/dsi/ifc/online/PortalMessagingData;)V 
.const [183] = Utf8 de/esolutions/fw/comm/dsi/online/impl/PortalADBEntrySerializer 
.const [184] = Utf8 putOptionalPortalADBEntry 
.const [185] = Utf8 (Lde/esolutions/fw/util/serializer/ISerializer;Lorg/dsi/ifc/online/PortalADBEntry;)V 
.const [186] = Utf8 de/esolutions/fw/comm/dsi/online/impl/PortalPersonalDataSerializer 
.const [187] = Utf8 getOptionalPortalPersonalData 
.const [188] = Utf8 (Lde/esolutions/fw/util/serializer/IDeserializer;)Lorg/dsi/ifc/online/PortalPersonalData; 
.const [189] = Utf8 de/esolutions/fw/comm/dsi/online/impl/PortalPhoneDataSerializer 
.const [190] = Utf8 getOptionalPortalPhoneDataVarArray 
.const [191] = Utf8 (Lde/esolutions/fw/util/serializer/IDeserializer;)[Lorg/dsi/ifc/online/PortalPhoneData; 
.const [192] = Utf8 de/esolutions/fw/comm/dsi/online/impl/PortalAddressDataSerializer 
.const [193] = Utf8 getOptionalPortalAddressDataVarArray 
.const [194] = Utf8 (Lde/esolutions/fw/util/serializer/IDeserializer;)[Lorg/dsi/ifc/online/PortalAddressData; 
.const [195] = Utf8 de/esolutions/fw/comm/dsi/online/impl/PortalNavigationDataSerializer 
.const [196] = Utf8 getOptionalPortalNavigationDataVarArray 
.const [197] = Utf8 (Lde/esolutions/fw/util/serializer/IDeserializer;)[Lorg/dsi/ifc/online/PortalNavigationData; 
.const [198] = Utf8 de/esolutions/fw/comm/dsi/online/impl/PortalMessagingDataSerializer 
.const [199] = Utf8 getOptionalPortalMessagingDataVarArray 
.const [200] = Utf8 (Lde/esolutions/fw/util/serializer/IDeserializer;)[Lorg/dsi/ifc/online/PortalMessagingData; 
.const [201] = Utf8 de/esolutions/fw/comm/dsi/online/impl/PortalADBEntrySerializer 
.const [202] = Utf8 getOptionalPortalADBEntry 
.const [203] = Utf8 (Lde/esolutions/fw/util/serializer/IDeserializer;)Lorg/dsi/ifc/online/PortalADBEntry; 
.const [204] = Utf8 org/dsi/ifc/online/PortalADBEntry 
.const [205] = Utf8 getEntryID 
.const [206] = Utf8 ()J 
.const [207] = Utf8 org/dsi/ifc/online/PortalADBEntry 
.const [208] = Utf8 getEntryType 
.const [209] = Utf8 ()J 
.const [210] = Utf8 org/dsi/ifc/online/PortalADBEntry 
.const [211] = Utf8 getGeneralDescription 
.const [212] = Utf8 ()Ljava/lang/String; 
.const [213] = Utf8 org/dsi/ifc/online/PortalADBEntry 
.const [214] = Utf8 getAdditionalDescription 
.const [215] = Utf8 ()Ljava/lang/String; 
.const [216] = Utf8 org/dsi/ifc/online/PortalADBEntry 
.const [217] = Utf8 getVoiceTagID 
.const [218] = Utf8 ()I 
.const [219] = Utf8 org/dsi/ifc/online/PortalADBEntry 
.const [220] = Utf8 getPreferedNumber 
.const [221] = Utf8 ()I 
.const [222] = Utf8 org/dsi/ifc/online/PortalADBEntry 
.const [223] = Utf8 getOadbHashcode 
.const [224] = Utf8 ()J 
.const [225] = Utf8 org/dsi/ifc/online/PortalADBEntry 
.const [226] = Utf8 getInitialNoNavHashcode 
.const [227] = Utf8 ()J 
.const [228] = Utf8 org/dsi/ifc/online/PortalADBEntry 
.const [229] = Utf8 getPersonalData 
.const [230] = Utf8 ()Lorg/dsi/ifc/online/PortalPersonalData; 
.const [231] = Utf8 org/dsi/ifc/online/PortalADBEntry 
.const [232] = Utf8 getPhoneData 
.const [233] = Utf8 ()[Lorg/dsi/ifc/online/PortalPhoneData; 
.const [234] = Utf8 org/dsi/ifc/online/PortalADBEntry 
.const [235] = Utf8 getAddressData 
.const [236] = Utf8 ()[Lorg/dsi/ifc/online/PortalAddressData; 
.const [237] = Utf8 org/dsi/ifc/online/PortalADBEntry 
.const [238] = Utf8 getNavigationData 
.const [239] = Utf8 ()[Lorg/dsi/ifc/online/PortalNavigationData; 
.const [240] = Utf8 org/dsi/ifc/online/PortalADBEntry 
.const [241] = Utf8 getMessagingData 
.const [242] = Utf8 ()[Lorg/dsi/ifc/online/PortalMessagingData; 
.const [243] = Utf8 java/lang/Object 
.const [244] = Utf8 <init> 
.const [245] = Utf8 ()V 
.const [246] = Utf8 org/dsi/ifc/online/PortalADBEntry 
.const [247] = Utf8 <init> 
.const [248] = Utf8 ()V 
.const [249] = Utf8 de/esolutions/fw/util/serializer/ISerializer 
.const [250] = Utf8 putBool 
.const [251] = Utf8 (Z)V 
.const [252] = Utf8 de/esolutions/fw/util/serializer/ISerializer 
.const [253] = Utf8 putInt64 
.const [254] = Utf8 (J)V 
.const [255] = Utf8 de/esolutions/fw/util/serializer/ISerializer 
.const [256] = Utf8 putOptionalString 
.const [257] = Utf8 (Ljava/lang/String;)V 
.const [258] = Utf8 de/esolutions/fw/util/serializer/ISerializer 
.const [259] = Utf8 putInt32 
.const [260] = Utf8 (I)V 
.const [261] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [262] = Utf8 getBool 
.const [263] = Utf8 ()Z 
.const [264] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [265] = Utf8 getInt64 
.const [266] = Utf8 ()J 
.const [267] = Utf8 org/dsi/ifc/online/PortalADBEntry 
.const [268] = Utf8 entryID 
.const [269] = Utf8 J 
.const [270] = Utf8 org/dsi/ifc/online/PortalADBEntry 
.const [271] = Utf8 entryType 
.const [272] = Utf8 J 
.const [273] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [274] = Utf8 getOptionalString 
.const [275] = Utf8 ()Ljava/lang/String; 
.const [276] = Utf8 org/dsi/ifc/online/PortalADBEntry 
.const [277] = Utf8 generalDescription 
.const [278] = Utf8 Ljava/lang/String; 
.const [279] = Utf8 org/dsi/ifc/online/PortalADBEntry 
.const [280] = Utf8 additionalDescription 
.const [281] = Utf8 Ljava/lang/String; 
.const [282] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [283] = Utf8 getInt32 
.const [284] = Utf8 ()I 
.const [285] = Utf8 org/dsi/ifc/online/PortalADBEntry 
.const [286] = Utf8 voiceTagID 
.const [287] = Utf8 I 
.const [288] = Utf8 org/dsi/ifc/online/PortalADBEntry 
.const [289] = Utf8 preferedNumber 
.const [290] = Utf8 I 
.const [291] = Utf8 org/dsi/ifc/online/PortalADBEntry 
.const [292] = Utf8 oadbHashcode 
.const [293] = Utf8 J 
.const [294] = Utf8 org/dsi/ifc/online/PortalADBEntry 
.const [295] = Utf8 initialNoNavHashcode 
.const [296] = Utf8 J 
.const [297] = Utf8 org/dsi/ifc/online/PortalADBEntry 
.const [298] = Utf8 personalData 
.const [299] = Utf8 Lorg/dsi/ifc/online/PortalPersonalData; 
.const [300] = Utf8 org/dsi/ifc/online/PortalADBEntry 
.const [301] = Utf8 phoneData 
.const [302] = Utf8 [Lorg/dsi/ifc/online/PortalPhoneData; 
.const [303] = Utf8 org/dsi/ifc/online/PortalADBEntry 
.const [304] = Utf8 addressData 
.const [305] = Utf8 [Lorg/dsi/ifc/online/PortalAddressData; 
.const [306] = Utf8 org/dsi/ifc/online/PortalADBEntry 
.const [307] = Utf8 navigationData 
.const [308] = Utf8 [Lorg/dsi/ifc/online/PortalNavigationData; 
.const [309] = Utf8 org/dsi/ifc/online/PortalADBEntry 
.const [310] = Utf8 messagingData 
.const [311] = Utf8 [Lorg/dsi/ifc/online/PortalMessagingData; 
.const [312] = Utf8 de/esolutions/fw/comm/dsi/online/impl/PortalADBEntrySerializer 
.const [313] = Class [312] 
.const [314] = Utf8 java/lang/Object 
.const [315] = Class [314] 
.const [316] = Utf8 Code 
.const [317] = Utf8 <init> 
.const [318] = Utf8 ()V 
.const [319] = Utf8 putOptionalPortalADBEntry 
.const [320] = Utf8 (Lde/esolutions/fw/util/serializer/ISerializer;Lorg/dsi/ifc/online/PortalADBEntry;)V 
.const [321] = Utf8 putOptionalPortalADBEntryVarArray 
.const [322] = Utf8 (Lde/esolutions/fw/util/serializer/ISerializer;[Lorg/dsi/ifc/online/PortalADBEntry;)V 
.const [323] = Utf8 getOptionalPortalADBEntry 
.const [324] = Utf8 (Lde/esolutions/fw/util/serializer/IDeserializer;)Lorg/dsi/ifc/online/PortalADBEntry; 
.const [325] = Utf8 getOptionalPortalADBEntryVarArray 
.const [326] = Utf8 (Lde/esolutions/fw/util/serializer/IDeserializer;)[Lorg/dsi/ifc/online/PortalADBEntry; 
.end class 
