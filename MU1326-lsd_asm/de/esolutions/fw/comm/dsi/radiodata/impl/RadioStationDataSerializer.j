.version 50 0 
.class public super [255] 
.super [257] 

.method public annotation [259] : [260] 
    .attribute [258] .code stack 1 locals 0 
L0:     aload_0 
L1:     invokespecial [23] 
L4:     return 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public static [261] : [262] 
    .attribute [258] .code stack 3 locals 17 
L0:     aload_1 
L1:     ifnonnull L8 
L4:     iconst_1 
L5:     goto L9 
L8:     iconst_0 
L9:     istore_2 
L10:    aload_0 
L11:    iload_2 
L12:    invokeinterface [25] 0 
L17:    iload_2 
L18:    ifne L215 
L21:    aload_1 
L22:    invokevirtual [9] 
L25:    istore_3 
L26:    aload_0 
L27:    iload_3 
L28:    invokeinterface [26] 0 
L33:    aload_1 
L34:    invokevirtual [10] 
L37:    istore 4 
L39:    aload_0 
L40:    iload 4 
L42:    invokeinterface [26] 0 
L47:    aload_1 
L48:    invokevirtual [11] 
L51:    istore 5 
L53:    aload_0 
L54:    iload 5 
L56:    invokeinterface [26] 0 
L61:    aload_1 
L62:    invokevirtual [12] 
L65:    istore 6 
L67:    aload_0 
L68:    iload 6 
L70:    invokeinterface [26] 0 
L75:    aload_1 
L76:    invokevirtual [13] 
L79:    istore 7 
L81:    aload_0 
L82:    iload 7 
L84:    invokeinterface [26] 0 
L89:    aload_1 
L90:    invokevirtual [14] 
L93:    istore 8 
L95:    aload_0 
L96:    iload 8 
L98:    invokeinterface [26] 0 
L103:   aload_1 
L104:   invokevirtual [15] 
L107:   istore 9 
L109:   aload_0 
L110:   iload 9 
L112:   invokeinterface [26] 0 
L117:   aload_1 
L118:   invokevirtual [16] 
L121:   astore 10 
L123:   aload_0 
L124:   aload 10 
L126:   invokeinterface [27] 0 
L131:   aload_1 
L132:   invokevirtual [17] 
L135:   astore 11 
L137:   aload_0 
L138:   aload 11 
L140:   invokeinterface [27] 0 
L145:   aload_1 
L146:   invokevirtual [18] 
L149:   lstore 12 
L151:   aload_0 
L152:   lload 12 
L154:   invokeinterface [28] 0 
L159:   aload_1 
L160:   invokevirtual [19] 
L163:   istore 14 
L165:   aload_0 
L166:   iload 14 
L168:   invokeinterface [26] 0 
L173:   aload_1 
L174:   invokevirtual [20] 
L177:   astore 15 
L179:   aload_0 
L180:   aload 15 
L182:   invokeinterface [27] 0 
L187:   aload_1 
L188:   invokevirtual [21] 
L191:   lstore 16 
L193:   aload_0 
L194:   lload 16 
L196:   invokeinterface [28] 0 
L201:   aload_1 
L202:   invokevirtual [22] 
L205:   istore 18 
L207:   aload_0 
L208:   iload 18 
L210:   invokeinterface [26] 0 
L215:   return 
L216:   
    .end code 
.end method 

.method public static [263] : [264] 
    .attribute [258] .code stack 3 locals 2 
L0:     aload_1 
L1:     ifnonnull L8 
L4:     iconst_1 
L5:     goto L9 
L8:     iconst_0 
L9:     istore_2 
L10:    aload_0 
L11:    iload_2 
L12:    invokeinterface [25] 0 
L17:    iload_2 
L18:    ifne L50 
L21:    aload_0 
L22:    aload_1 
L23:    arraylength 
L24:    invokeinterface [26] 0 
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
L41:    invokestatic [2] 
L44:    iinc 3 1 
L47:    goto L31 
L50:    return 
L51:    nop 
L52:    
    .end code 
.end method 

.method public static [265] : [266] 
    .attribute [258] .code stack 3 locals 18 
L0:     aconst_null 
L1:     astore_1 
L2:     aload_0 
L3:     invokeinterface [29] 0 
L8:     istore_2 
L9:     iload_2 
L10:    ifne L215 
L13:    new [30] 
L16:    dup 
L17:    invokespecial [24] 
L20:    astore_1 
L21:    aload_0 
L22:    invokeinterface [31] 0 
L27:    istore_3 
L28:    aload_1 
L29:    iload_3 
L30:    putfield [32] 
L33:    aload_0 
L34:    invokeinterface [31] 0 
L39:    istore 4 
L41:    aload_1 
L42:    iload 4 
L44:    putfield [33] 
L47:    aload_0 
L48:    invokeinterface [31] 0 
L53:    istore 5 
L55:    aload_1 
L56:    iload 5 
L58:    putfield [34] 
L61:    aload_0 
L62:    invokeinterface [31] 0 
L67:    istore 6 
L69:    aload_1 
L70:    iload 6 
L72:    putfield [35] 
L75:    aload_0 
L76:    invokeinterface [31] 0 
L81:    istore 7 
L83:    aload_1 
L84:    iload 7 
L86:    putfield [36] 
L89:    aload_0 
L90:    invokeinterface [31] 0 
L95:    istore 8 
L97:    aload_1 
L98:    iload 8 
L100:   putfield [37] 
L103:   aload_0 
L104:   invokeinterface [31] 0 
L109:   istore 9 
L111:   aload_1 
L112:   iload 9 
L114:   putfield [38] 
L117:   aload_0 
L118:   invokeinterface [39] 0 
L123:   astore 10 
L125:   aload_1 
L126:   aload 10 
L128:   putfield [40] 
L131:   aload_0 
L132:   invokeinterface [39] 0 
L137:   astore 11 
L139:   aload_1 
L140:   aload 11 
L142:   putfield [41] 
L145:   aload_0 
L146:   invokeinterface [42] 0 
L151:   lstore 12 
L153:   aload_1 
L154:   lload 12 
L156:   putfield [43] 
L159:   aload_0 
L160:   invokeinterface [31] 0 
L165:   istore 14 
L167:   aload_1 
L168:   iload 14 
L170:   putfield [44] 
L173:   aload_0 
L174:   invokeinterface [39] 0 
L179:   astore 15 
L181:   aload_1 
L182:   aload 15 
L184:   putfield [45] 
L187:   aload_0 
L188:   invokeinterface [42] 0 
L193:   lstore 16 
L195:   aload_1 
L196:   lload 16 
L198:   putfield [46] 
L201:   aload_0 
L202:   invokeinterface [31] 0 
L207:   istore 18 
L209:   aload_1 
L210:   iload 18 
L212:   putfield [47] 
L215:   aload_1 
L216:   areturn 
L217:   nop 
L218:   nop 
L219:   nop 
L220:   
    .end code 
.end method 

.method public static [267] : [268] 
    .attribute [258] .code stack 3 locals 4 
L0:     aconst_null 
L1:     astore_1 
L2:     aload_0 
L3:     invokeinterface [29] 0 
L8:     istore_2 
L9:     iload_2 
L10:    ifne L48 
L13:    aload_0 
L14:    invokeinterface [31] 0 
L19:    istore_3 
L20:    iload_3 
L21:    anewarray [3] 
L24:    astore_1 
L25:    iconst_0 
L26:    istore 4 
L28:    iload 4 
L30:    iload_3 
L31:    if_icmpge L48 
L34:    aload_1 
L35:    iload 4 
L37:    aload_0 
L38:    invokestatic [4] 
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
.const [2] = Method [48] [49] 
.const [3] = Class [50] 
.const [4] = Method [51] [52] 
.const [5] = Class [53] 
.const [6] = Class [54] 
.const [7] = Class [55] 
.const [8] = Class [56] 
.const [9] = Method [57] [58] 
.const [10] = Method [59] [60] 
.const [11] = Method [61] [62] 
.const [12] = Method [63] [64] 
.const [13] = Method [65] [66] 
.const [14] = Method [67] [68] 
.const [15] = Method [69] [70] 
.const [16] = Method [71] [72] 
.const [17] = Method [73] [74] 
.const [18] = Method [75] [76] 
.const [19] = Method [77] [78] 
.const [20] = Method [79] [80] 
.const [21] = Method [81] [82] 
.const [22] = Method [83] [84] 
.const [23] = Method [85] [86] 
.const [24] = Method [87] [88] 
.const [25] = InterfaceMethod [89] [90] 
.const [26] = InterfaceMethod [91] [92] 
.const [27] = InterfaceMethod [93] [94] 
.const [28] = InterfaceMethod [95] [96] 
.const [29] = InterfaceMethod [97] [98] 
.const [30] = Class [99] 
.const [31] = InterfaceMethod [100] [101] 
.const [32] = Field [102] [103] 
.const [33] = Field [104] [105] 
.const [34] = Field [106] [107] 
.const [35] = Field [108] [109] 
.const [36] = Field [110] [111] 
.const [37] = Field [112] [113] 
.const [38] = Field [114] [115] 
.const [39] = InterfaceMethod [116] [117] 
.const [40] = Field [118] [119] 
.const [41] = Field [120] [121] 
.const [42] = InterfaceMethod [122] [123] 
.const [43] = Field [124] [125] 
.const [44] = Field [126] [127] 
.const [45] = Field [128] [129] 
.const [46] = Field [130] [131] 
.const [47] = Field [132] [133] 
.const [48] = Class [134] 
.const [49] = NameAndType [135] [136] 
.const [50] = Utf8 org/dsi/ifc/radiodata/RadioStationData 
.const [51] = Class [137] 
.const [52] = NameAndType [138] [139] 
.const [53] = Utf8 de/esolutions/fw/comm/dsi/radiodata/impl/RadioStationDataSerializer 
.const [54] = Utf8 java/lang/Object 
.const [55] = Utf8 de/esolutions/fw/util/serializer/ISerializer 
.const [56] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [57] = Class [140] 
.const [58] = NameAndType [141] [142] 
.const [59] = Class [143] 
.const [60] = NameAndType [144] [145] 
.const [61] = Class [146] 
.const [62] = NameAndType [147] [148] 
.const [63] = Class [149] 
.const [64] = NameAndType [150] [151] 
.const [65] = Class [152] 
.const [66] = NameAndType [153] [154] 
.const [67] = Class [155] 
.const [68] = NameAndType [156] [157] 
.const [69] = Class [158] 
.const [70] = NameAndType [159] [160] 
.const [71] = Class [161] 
.const [72] = NameAndType [162] [163] 
.const [73] = Class [164] 
.const [74] = NameAndType [165] [166] 
.const [75] = Class [167] 
.const [76] = NameAndType [168] [169] 
.const [77] = Class [170] 
.const [78] = NameAndType [171] [172] 
.const [79] = Class [173] 
.const [80] = NameAndType [174] [175] 
.const [81] = Class [176] 
.const [82] = NameAndType [177] [178] 
.const [83] = Class [179] 
.const [84] = NameAndType [180] [181] 
.const [85] = Class [182] 
.const [86] = NameAndType [183] [184] 
.const [87] = Class [185] 
.const [88] = NameAndType [186] [187] 
.const [89] = Class [188] 
.const [90] = NameAndType [189] [190] 
.const [91] = Class [191] 
.const [92] = NameAndType [192] [193] 
.const [93] = Class [194] 
.const [94] = NameAndType [195] [196] 
.const [95] = Class [197] 
.const [96] = NameAndType [198] [199] 
.const [97] = Class [200] 
.const [98] = NameAndType [201] [202] 
.const [99] = Utf8 org/dsi/ifc/radiodata/RadioStationData 
.const [100] = Class [203] 
.const [101] = NameAndType [204] [205] 
.const [102] = Class [206] 
.const [103] = NameAndType [207] [208] 
.const [104] = Class [209] 
.const [105] = NameAndType [210] [211] 
.const [106] = Class [212] 
.const [107] = NameAndType [213] [214] 
.const [108] = Class [215] 
.const [109] = NameAndType [216] [217] 
.const [110] = Class [218] 
.const [111] = NameAndType [219] [220] 
.const [112] = Class [221] 
.const [113] = NameAndType [222] [223] 
.const [114] = Class [224] 
.const [115] = NameAndType [225] [226] 
.const [116] = Class [227] 
.const [117] = NameAndType [228] [229] 
.const [118] = Class [230] 
.const [119] = NameAndType [231] [232] 
.const [120] = Class [233] 
.const [121] = NameAndType [234] [235] 
.const [122] = Class [236] 
.const [123] = NameAndType [237] [238] 
.const [124] = Class [239] 
.const [125] = NameAndType [240] [241] 
.const [126] = Class [242] 
.const [127] = NameAndType [243] [244] 
.const [128] = Class [245] 
.const [129] = NameAndType [246] [247] 
.const [130] = Class [248] 
.const [131] = NameAndType [249] [250] 
.const [132] = Class [251] 
.const [133] = NameAndType [252] [253] 
.const [134] = Utf8 de/esolutions/fw/comm/dsi/radiodata/impl/RadioStationDataSerializer 
.const [135] = Utf8 putOptionalRadioStationData 
.const [136] = Utf8 (Lde/esolutions/fw/util/serializer/ISerializer;Lorg/dsi/ifc/radiodata/RadioStationData;)V 
.const [137] = Utf8 de/esolutions/fw/comm/dsi/radiodata/impl/RadioStationDataSerializer 
.const [138] = Utf8 getOptionalRadioStationData 
.const [139] = Utf8 (Lde/esolutions/fw/util/serializer/IDeserializer;)Lorg/dsi/ifc/radiodata/RadioStationData; 
.const [140] = Utf8 org/dsi/ifc/radiodata/RadioStationData 
.const [141] = Utf8 getStationId 
.const [142] = Utf8 ()I 
.const [143] = Utf8 org/dsi/ifc/radiodata/RadioStationData 
.const [144] = Utf8 getCountry 
.const [145] = Utf8 ()I 
.const [146] = Utf8 org/dsi/ifc/radiodata/RadioStationData 
.const [147] = Utf8 getExtendedCountryCode 
.const [148] = Utf8 ()I 
.const [149] = Utf8 org/dsi/ifc/radiodata/RadioStationData 
.const [150] = Utf8 getPiSid 
.const [151] = Utf8 ()I 
.const [152] = Utf8 org/dsi/ifc/radiodata/RadioStationData 
.const [153] = Utf8 getLinkedPiSid 
.const [154] = Utf8 ()I 
.const [155] = Utf8 org/dsi/ifc/radiodata/RadioStationData 
.const [156] = Utf8 getEnsembleId 
.const [157] = Utf8 ()I 
.const [158] = Utf8 org/dsi/ifc/radiodata/RadioStationData 
.const [159] = Utf8 getScidi 
.const [160] = Utf8 ()I 
.const [161] = Utf8 org/dsi/ifc/radiodata/RadioStationData 
.const [162] = Utf8 getLongName 
.const [163] = Utf8 ()Ljava/lang/String; 
.const [164] = Utf8 org/dsi/ifc/radiodata/RadioStationData 
.const [165] = Utf8 getShortName 
.const [166] = Utf8 ()Ljava/lang/String; 
.const [167] = Utf8 org/dsi/ifc/radiodata/RadioStationData 
.const [168] = Utf8 getFrequency 
.const [169] = Utf8 ()J 
.const [170] = Utf8 org/dsi/ifc/radiodata/RadioStationData 
.const [171] = Utf8 getSubChannelId 
.const [172] = Utf8 ()I 
.const [173] = Utf8 org/dsi/ifc/radiodata/RadioStationData 
.const [174] = Utf8 getStationType 
.const [175] = Utf8 ()Ljava/lang/String; 
.const [176] = Utf8 org/dsi/ifc/radiodata/RadioStationData 
.const [177] = Utf8 getRadioSdsId 
.const [178] = Utf8 ()J 
.const [179] = Utf8 org/dsi/ifc/radiodata/RadioStationData 
.const [180] = Utf8 getLogoId 
.const [181] = Utf8 ()I 
.const [182] = Utf8 java/lang/Object 
.const [183] = Utf8 <init> 
.const [184] = Utf8 ()V 
.const [185] = Utf8 org/dsi/ifc/radiodata/RadioStationData 
.const [186] = Utf8 <init> 
.const [187] = Utf8 ()V 
.const [188] = Utf8 de/esolutions/fw/util/serializer/ISerializer 
.const [189] = Utf8 putBool 
.const [190] = Utf8 (Z)V 
.const [191] = Utf8 de/esolutions/fw/util/serializer/ISerializer 
.const [192] = Utf8 putInt32 
.const [193] = Utf8 (I)V 
.const [194] = Utf8 de/esolutions/fw/util/serializer/ISerializer 
.const [195] = Utf8 putOptionalString 
.const [196] = Utf8 (Ljava/lang/String;)V 
.const [197] = Utf8 de/esolutions/fw/util/serializer/ISerializer 
.const [198] = Utf8 putInt64 
.const [199] = Utf8 (J)V 
.const [200] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [201] = Utf8 getBool 
.const [202] = Utf8 ()Z 
.const [203] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [204] = Utf8 getInt32 
.const [205] = Utf8 ()I 
.const [206] = Utf8 org/dsi/ifc/radiodata/RadioStationData 
.const [207] = Utf8 stationId 
.const [208] = Utf8 I 
.const [209] = Utf8 org/dsi/ifc/radiodata/RadioStationData 
.const [210] = Utf8 country 
.const [211] = Utf8 I 
.const [212] = Utf8 org/dsi/ifc/radiodata/RadioStationData 
.const [213] = Utf8 extendedCountryCode 
.const [214] = Utf8 I 
.const [215] = Utf8 org/dsi/ifc/radiodata/RadioStationData 
.const [216] = Utf8 piSid 
.const [217] = Utf8 I 
.const [218] = Utf8 org/dsi/ifc/radiodata/RadioStationData 
.const [219] = Utf8 linkedPiSid 
.const [220] = Utf8 I 
.const [221] = Utf8 org/dsi/ifc/radiodata/RadioStationData 
.const [222] = Utf8 ensembleId 
.const [223] = Utf8 I 
.const [224] = Utf8 org/dsi/ifc/radiodata/RadioStationData 
.const [225] = Utf8 scidi 
.const [226] = Utf8 I 
.const [227] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [228] = Utf8 getOptionalString 
.const [229] = Utf8 ()Ljava/lang/String; 
.const [230] = Utf8 org/dsi/ifc/radiodata/RadioStationData 
.const [231] = Utf8 longName 
.const [232] = Utf8 Ljava/lang/String; 
.const [233] = Utf8 org/dsi/ifc/radiodata/RadioStationData 
.const [234] = Utf8 shortName 
.const [235] = Utf8 Ljava/lang/String; 
.const [236] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [237] = Utf8 getInt64 
.const [238] = Utf8 ()J 
.const [239] = Utf8 org/dsi/ifc/radiodata/RadioStationData 
.const [240] = Utf8 frequency 
.const [241] = Utf8 J 
.const [242] = Utf8 org/dsi/ifc/radiodata/RadioStationData 
.const [243] = Utf8 subChannelId 
.const [244] = Utf8 I 
.const [245] = Utf8 org/dsi/ifc/radiodata/RadioStationData 
.const [246] = Utf8 stationType 
.const [247] = Utf8 Ljava/lang/String; 
.const [248] = Utf8 org/dsi/ifc/radiodata/RadioStationData 
.const [249] = Utf8 radioSdsId 
.const [250] = Utf8 J 
.const [251] = Utf8 org/dsi/ifc/radiodata/RadioStationData 
.const [252] = Utf8 logoId 
.const [253] = Utf8 I 
.const [254] = Utf8 de/esolutions/fw/comm/dsi/radiodata/impl/RadioStationDataSerializer 
.const [255] = Class [254] 
.const [256] = Utf8 java/lang/Object 
.const [257] = Class [256] 
.const [258] = Utf8 Code 
.const [259] = Utf8 <init> 
.const [260] = Utf8 ()V 
.const [261] = Utf8 putOptionalRadioStationData 
.const [262] = Utf8 (Lde/esolutions/fw/util/serializer/ISerializer;Lorg/dsi/ifc/radiodata/RadioStationData;)V 
.const [263] = Utf8 putOptionalRadioStationDataVarArray 
.const [264] = Utf8 (Lde/esolutions/fw/util/serializer/ISerializer;[Lorg/dsi/ifc/radiodata/RadioStationData;)V 
.const [265] = Utf8 getOptionalRadioStationData 
.const [266] = Utf8 (Lde/esolutions/fw/util/serializer/IDeserializer;)Lorg/dsi/ifc/radiodata/RadioStationData; 
.const [267] = Utf8 getOptionalRadioStationDataVarArray 
.const [268] = Utf8 (Lde/esolutions/fw/util/serializer/IDeserializer;)[Lorg/dsi/ifc/radiodata/RadioStationData; 
.end class 
