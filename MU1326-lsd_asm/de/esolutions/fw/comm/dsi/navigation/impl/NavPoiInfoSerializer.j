.version 50 0 
.class public super [259] 
.super [261] 

.method public annotation [263] : [264] 
    .attribute [262] .code stack 1 locals 0 
L0:     aload_0 
L1:     invokespecial [28] 
L4:     return 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public static [265] : [266] 
    .attribute [262] .code stack 3 locals 14 
L0:     aload_1 
L1:     ifnonnull L8 
L4:     iconst_1 
L5:     goto L9 
L8:     iconst_0 
L9:     istore_2 
L10:    aload_0 
L11:    iload_2 
L12:    invokeinterface [30] 0 
L17:    iload_2 
L18:    ifne L167 
L21:    aload_1 
L22:    invokevirtual [17] 
L25:    lstore_3 
L26:    aload_0 
L27:    lload_3 
L28:    invokeinterface [31] 0 
L33:    aload_1 
L34:    invokevirtual [18] 
L37:    lstore 5 
L39:    aload_0 
L40:    lload 5 
L42:    invokeinterface [31] 0 
L47:    aload_1 
L48:    invokevirtual [19] 
L51:    astore 7 
L53:    aload_0 
L54:    aload 7 
L56:    invokestatic [2] 
L59:    aload_1 
L60:    invokevirtual [20] 
L63:    astore 8 
L65:    aload_0 
L66:    aload 8 
L68:    invokeinterface [32] 0 
L73:    aload_1 
L74:    invokevirtual [21] 
L77:    astore 9 
L79:    aload_0 
L80:    aload 9 
L82:    invokeinterface [32] 0 
L87:    aload_1 
L88:    invokevirtual [22] 
L91:    istore 10 
L93:    aload_0 
L94:    iload 10 
L96:    invokeinterface [33] 0 
L101:   aload_1 
L102:   invokevirtual [23] 
L105:   istore 11 
L107:   aload_0 
L108:   iload 11 
L110:   invokeinterface [30] 0 
L115:   aload_1 
L116:   invokevirtual [24] 
L119:   istore 12 
L121:   aload_0 
L122:   iload 12 
L124:   invokeinterface [33] 0 
L129:   aload_1 
L130:   invokevirtual [25] 
L133:   istore 13 
L135:   aload_0 
L136:   iload 13 
L138:   invokeinterface [33] 0 
L143:   aload_1 
L144:   invokevirtual [26] 
L147:   astore 14 
L149:   aload_0 
L150:   aload 14 
L152:   invokestatic [3] 
L155:   aload_1 
L156:   invokevirtual [27] 
L159:   astore 15 
L161:   aload_0 
L162:   aload 15 
L164:   invokestatic [4] 
L167:   return 
L168:   
    .end code 
.end method 

.method public static [267] : [268] 
    .attribute [262] .code stack 3 locals 2 
L0:     aload_1 
L1:     ifnonnull L8 
L4:     iconst_1 
L5:     goto L9 
L8:     iconst_0 
L9:     istore_2 
L10:    aload_0 
L11:    iload_2 
L12:    invokeinterface [30] 0 
L17:    iload_2 
L18:    ifne L50 
L21:    aload_0 
L22:    aload_1 
L23:    arraylength 
L24:    invokeinterface [33] 0 
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

.method public static [269] : [270] 
    .attribute [262] .code stack 3 locals 15 
L0:     aconst_null 
L1:     astore_1 
L2:     aload_0 
L3:     invokeinterface [34] 0 
L8:     istore_2 
L9:     iload_2 
L10:    ifne L167 
L13:    new [35] 
L16:    dup 
L17:    invokespecial [29] 
L20:    astore_1 
L21:    aload_0 
L22:    invokeinterface [36] 0 
L27:    lstore_3 
L28:    aload_1 
L29:    lload_3 
L30:    putfield [37] 
L33:    aload_0 
L34:    invokeinterface [36] 0 
L39:    lstore 5 
L41:    aload_1 
L42:    lload 5 
L44:    putfield [38] 
L47:    aload_0 
L48:    invokestatic [7] 
L51:    astore 7 
L53:    aload_1 
L54:    aload 7 
L56:    putfield [39] 
L59:    aload_0 
L60:    invokeinterface [40] 0 
L65:    astore 8 
L67:    aload_1 
L68:    aload 8 
L70:    putfield [41] 
L73:    aload_0 
L74:    invokeinterface [40] 0 
L79:    astore 9 
L81:    aload_1 
L82:    aload 9 
L84:    putfield [42] 
L87:    aload_0 
L88:    invokeinterface [43] 0 
L93:    istore 10 
L95:    aload_1 
L96:    iload 10 
L98:    putfield [44] 
L101:   aload_0 
L102:   invokeinterface [34] 0 
L107:   istore 11 
L109:   aload_1 
L110:   iload 11 
L112:   putfield [45] 
L115:   aload_0 
L116:   invokeinterface [43] 0 
L121:   istore 12 
L123:   aload_1 
L124:   iload 12 
L126:   putfield [46] 
L129:   aload_0 
L130:   invokeinterface [43] 0 
L135:   istore 13 
L137:   aload_1 
L138:   iload 13 
L140:   putfield [47] 
L143:   aload_0 
L144:   invokestatic [8] 
L147:   astore 14 
L149:   aload_1 
L150:   aload 14 
L152:   putfield [48] 
L155:   aload_0 
L156:   invokestatic [9] 
L159:   astore 15 
L161:   aload_1 
L162:   aload 15 
L164:   putfield [49] 
L167:   aload_1 
L168:   areturn 
L169:   nop 
L170:   nop 
L171:   nop 
L172:   
    .end code 
.end method 

.method public static [271] : [272] 
    .attribute [262] .code stack 3 locals 4 
L0:     aconst_null 
L1:     astore_1 
L2:     aload_0 
L3:     invokeinterface [34] 0 
L8:     istore_2 
L9:     iload_2 
L10:    ifne L48 
L13:    aload_0 
L14:    invokeinterface [43] 0 
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
.const [2] = Method [50] [51] 
.const [3] = Method [52] [53] 
.const [4] = Method [54] [55] 
.const [5] = Method [56] [57] 
.const [6] = Class [58] 
.const [7] = Method [59] [60] 
.const [8] = Method [61] [62] 
.const [9] = Method [63] [64] 
.const [10] = Method [65] [66] 
.const [11] = Class [67] 
.const [12] = Class [68] 
.const [13] = Class [69] 
.const [14] = Class [70] 
.const [15] = Class [71] 
.const [16] = Class [72] 
.const [17] = Method [73] [74] 
.const [18] = Method [75] [76] 
.const [19] = Method [77] [78] 
.const [20] = Method [79] [80] 
.const [21] = Method [81] [82] 
.const [22] = Method [83] [84] 
.const [23] = Method [85] [86] 
.const [24] = Method [87] [88] 
.const [25] = Method [89] [90] 
.const [26] = Method [91] [92] 
.const [27] = Method [93] [94] 
.const [28] = Method [95] [96] 
.const [29] = Method [97] [98] 
.const [30] = InterfaceMethod [99] [100] 
.const [31] = InterfaceMethod [101] [102] 
.const [32] = InterfaceMethod [103] [104] 
.const [33] = InterfaceMethod [105] [106] 
.const [34] = InterfaceMethod [107] [108] 
.const [35] = Class [109] 
.const [36] = InterfaceMethod [110] [111] 
.const [37] = Field [112] [113] 
.const [38] = Field [114] [115] 
.const [39] = Field [116] [117] 
.const [40] = InterfaceMethod [118] [119] 
.const [41] = Field [120] [121] 
.const [42] = Field [122] [123] 
.const [43] = InterfaceMethod [124] [125] 
.const [44] = Field [126] [127] 
.const [45] = Field [128] [129] 
.const [46] = Field [130] [131] 
.const [47] = Field [132] [133] 
.const [48] = Field [134] [135] 
.const [49] = Field [136] [137] 
.const [50] = Class [138] 
.const [51] = NameAndType [139] [140] 
.const [52] = Class [141] 
.const [53] = NameAndType [142] [143] 
.const [54] = Class [144] 
.const [55] = NameAndType [145] [146] 
.const [56] = Class [147] 
.const [57] = NameAndType [148] [149] 
.const [58] = Utf8 org/dsi/ifc/navigation/NavPoiInfo 
.const [59] = Class [150] 
.const [60] = NameAndType [151] [152] 
.const [61] = Class [153] 
.const [62] = NameAndType [154] [155] 
.const [63] = Class [156] 
.const [64] = NameAndType [157] [158] 
.const [65] = Class [159] 
.const [66] = NameAndType [160] [161] 
.const [67] = Utf8 de/esolutions/fw/comm/dsi/navigation/impl/NavPoiInfoSerializer 
.const [68] = Utf8 java/lang/Object 
.const [69] = Utf8 de/esolutions/fw/util/serializer/ISerializer 
.const [70] = Utf8 de/esolutions/fw/comm/dsi/global/impl/NavLocationSerializer 
.const [71] = Utf8 de/esolutions/fw/comm/dsi/navigation/impl/NavRouteListDataIconSerializer 
.const [72] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [73] = Class [162] 
.const [74] = NameAndType [163] [164] 
.const [75] = Class [165] 
.const [76] = NameAndType [166] [167] 
.const [77] = Class [168] 
.const [78] = NameAndType [169] [170] 
.const [79] = Class [171] 
.const [80] = NameAndType [172] [173] 
.const [81] = Class [174] 
.const [82] = NameAndType [175] [176] 
.const [83] = Class [177] 
.const [84] = NameAndType [178] [179] 
.const [85] = Class [180] 
.const [86] = NameAndType [181] [182] 
.const [87] = Class [183] 
.const [88] = NameAndType [184] [185] 
.const [89] = Class [186] 
.const [90] = NameAndType [187] [188] 
.const [91] = Class [189] 
.const [92] = NameAndType [190] [191] 
.const [93] = Class [192] 
.const [94] = NameAndType [193] [194] 
.const [95] = Class [195] 
.const [96] = NameAndType [196] [197] 
.const [97] = Class [198] 
.const [98] = NameAndType [199] [200] 
.const [99] = Class [201] 
.const [100] = NameAndType [202] [203] 
.const [101] = Class [204] 
.const [102] = NameAndType [205] [206] 
.const [103] = Class [207] 
.const [104] = NameAndType [208] [209] 
.const [105] = Class [210] 
.const [106] = NameAndType [211] [212] 
.const [107] = Class [213] 
.const [108] = NameAndType [214] [215] 
.const [109] = Utf8 org/dsi/ifc/navigation/NavPoiInfo 
.const [110] = Class [216] 
.const [111] = NameAndType [217] [218] 
.const [112] = Class [219] 
.const [113] = NameAndType [220] [221] 
.const [114] = Class [222] 
.const [115] = NameAndType [223] [224] 
.const [116] = Class [225] 
.const [117] = NameAndType [226] [227] 
.const [118] = Class [228] 
.const [119] = NameAndType [229] [230] 
.const [120] = Class [231] 
.const [121] = NameAndType [232] [233] 
.const [122] = Class [234] 
.const [123] = NameAndType [235] [236] 
.const [124] = Class [237] 
.const [125] = NameAndType [238] [239] 
.const [126] = Class [240] 
.const [127] = NameAndType [241] [242] 
.const [128] = Class [243] 
.const [129] = NameAndType [244] [245] 
.const [130] = Class [246] 
.const [131] = NameAndType [247] [248] 
.const [132] = Class [249] 
.const [133] = NameAndType [250] [251] 
.const [134] = Class [252] 
.const [135] = NameAndType [253] [254] 
.const [136] = Class [255] 
.const [137] = NameAndType [256] [257] 
.const [138] = Utf8 de/esolutions/fw/comm/dsi/global/impl/NavLocationSerializer 
.const [139] = Utf8 putOptionalNavLocationVarArray 
.const [140] = Utf8 (Lde/esolutions/fw/util/serializer/ISerializer;[Lorg/dsi/ifc/global/NavLocation;)V 
.const [141] = Utf8 de/esolutions/fw/comm/dsi/global/impl/NavLocationSerializer 
.const [142] = Utf8 putOptionalNavLocation 
.const [143] = Utf8 (Lde/esolutions/fw/util/serializer/ISerializer;Lorg/dsi/ifc/global/NavLocation;)V 
.const [144] = Utf8 de/esolutions/fw/comm/dsi/navigation/impl/NavRouteListDataIconSerializer 
.const [145] = Utf8 putOptionalNavRouteListDataIconVarArray 
.const [146] = Utf8 (Lde/esolutions/fw/util/serializer/ISerializer;[Lorg/dsi/ifc/navigation/NavRouteListDataIcon;)V 
.const [147] = Utf8 de/esolutions/fw/comm/dsi/navigation/impl/NavPoiInfoSerializer 
.const [148] = Utf8 putOptionalNavPoiInfo 
.const [149] = Utf8 (Lde/esolutions/fw/util/serializer/ISerializer;Lorg/dsi/ifc/navigation/NavPoiInfo;)V 
.const [150] = Utf8 de/esolutions/fw/comm/dsi/global/impl/NavLocationSerializer 
.const [151] = Utf8 getOptionalNavLocationVarArray 
.const [152] = Utf8 (Lde/esolutions/fw/util/serializer/IDeserializer;)[Lorg/dsi/ifc/global/NavLocation; 
.const [153] = Utf8 de/esolutions/fw/comm/dsi/global/impl/NavLocationSerializer 
.const [154] = Utf8 getOptionalNavLocation 
.const [155] = Utf8 (Lde/esolutions/fw/util/serializer/IDeserializer;)Lorg/dsi/ifc/global/NavLocation; 
.const [156] = Utf8 de/esolutions/fw/comm/dsi/navigation/impl/NavRouteListDataIconSerializer 
.const [157] = Utf8 getOptionalNavRouteListDataIconVarArray 
.const [158] = Utf8 (Lde/esolutions/fw/util/serializer/IDeserializer;)[Lorg/dsi/ifc/navigation/NavRouteListDataIcon; 
.const [159] = Utf8 de/esolutions/fw/comm/dsi/navigation/impl/NavPoiInfoSerializer 
.const [160] = Utf8 getOptionalNavPoiInfo 
.const [161] = Utf8 (Lde/esolutions/fw/util/serializer/IDeserializer;)Lorg/dsi/ifc/navigation/NavPoiInfo; 
.const [162] = Utf8 org/dsi/ifc/navigation/NavPoiInfo 
.const [163] = Utf8 getDistance 
.const [164] = Utf8 ()J 
.const [165] = Utf8 org/dsi/ifc/navigation/NavPoiInfo 
.const [166] = Utf8 getRemainingTime 
.const [167] = Utf8 ()J 
.const [168] = Utf8 org/dsi/ifc/navigation/NavPoiInfo 
.const [169] = Utf8 getPoiLocations 
.const [170] = Utf8 ()[Lorg/dsi/ifc/global/NavLocation; 
.const [171] = Utf8 org/dsi/ifc/navigation/NavPoiInfo 
.const [172] = Utf8 getExitNumber 
.const [173] = Utf8 ()Ljava/lang/String; 
.const [174] = Utf8 org/dsi/ifc/navigation/NavPoiInfo 
.const [175] = Utf8 getSignpostInfo 
.const [176] = Utf8 ()Ljava/lang/String; 
.const [177] = Utf8 org/dsi/ifc/navigation/NavPoiInfo 
.const [178] = Utf8 getExitIconId 
.const [179] = Utf8 ()I 
.const [180] = Utf8 org/dsi/ifc/navigation/NavPoiInfo 
.const [181] = Utf8 isSideOfStreet 
.const [182] = Utf8 ()Z 
.const [183] = Utf8 org/dsi/ifc/navigation/NavPoiInfo 
.const [184] = Utf8 getDestinationIndex 
.const [185] = Utf8 ()I 
.const [186] = Utf8 org/dsi/ifc/navigation/NavPoiInfo 
.const [187] = Utf8 getType 
.const [188] = Utf8 ()I 
.const [189] = Utf8 org/dsi/ifc/navigation/NavPoiInfo 
.const [190] = Utf8 getExitPoiLocation 
.const [191] = Utf8 ()Lorg/dsi/ifc/global/NavLocation; 
.const [192] = Utf8 org/dsi/ifc/navigation/NavPoiInfo 
.const [193] = Utf8 getPoiIcons 
.const [194] = Utf8 ()[Lorg/dsi/ifc/navigation/NavRouteListDataIcon; 
.const [195] = Utf8 java/lang/Object 
.const [196] = Utf8 <init> 
.const [197] = Utf8 ()V 
.const [198] = Utf8 org/dsi/ifc/navigation/NavPoiInfo 
.const [199] = Utf8 <init> 
.const [200] = Utf8 ()V 
.const [201] = Utf8 de/esolutions/fw/util/serializer/ISerializer 
.const [202] = Utf8 putBool 
.const [203] = Utf8 (Z)V 
.const [204] = Utf8 de/esolutions/fw/util/serializer/ISerializer 
.const [205] = Utf8 putInt64 
.const [206] = Utf8 (J)V 
.const [207] = Utf8 de/esolutions/fw/util/serializer/ISerializer 
.const [208] = Utf8 putOptionalString 
.const [209] = Utf8 (Ljava/lang/String;)V 
.const [210] = Utf8 de/esolutions/fw/util/serializer/ISerializer 
.const [211] = Utf8 putInt32 
.const [212] = Utf8 (I)V 
.const [213] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [214] = Utf8 getBool 
.const [215] = Utf8 ()Z 
.const [216] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [217] = Utf8 getInt64 
.const [218] = Utf8 ()J 
.const [219] = Utf8 org/dsi/ifc/navigation/NavPoiInfo 
.const [220] = Utf8 distance 
.const [221] = Utf8 J 
.const [222] = Utf8 org/dsi/ifc/navigation/NavPoiInfo 
.const [223] = Utf8 remainingTime 
.const [224] = Utf8 J 
.const [225] = Utf8 org/dsi/ifc/navigation/NavPoiInfo 
.const [226] = Utf8 poiLocations 
.const [227] = Utf8 [Lorg/dsi/ifc/global/NavLocation; 
.const [228] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [229] = Utf8 getOptionalString 
.const [230] = Utf8 ()Ljava/lang/String; 
.const [231] = Utf8 org/dsi/ifc/navigation/NavPoiInfo 
.const [232] = Utf8 exitNumber 
.const [233] = Utf8 Ljava/lang/String; 
.const [234] = Utf8 org/dsi/ifc/navigation/NavPoiInfo 
.const [235] = Utf8 signpostInfo 
.const [236] = Utf8 Ljava/lang/String; 
.const [237] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [238] = Utf8 getInt32 
.const [239] = Utf8 ()I 
.const [240] = Utf8 org/dsi/ifc/navigation/NavPoiInfo 
.const [241] = Utf8 exitIconId 
.const [242] = Utf8 I 
.const [243] = Utf8 org/dsi/ifc/navigation/NavPoiInfo 
.const [244] = Utf8 sideOfStreet 
.const [245] = Utf8 Z 
.const [246] = Utf8 org/dsi/ifc/navigation/NavPoiInfo 
.const [247] = Utf8 destinationIndex 
.const [248] = Utf8 I 
.const [249] = Utf8 org/dsi/ifc/navigation/NavPoiInfo 
.const [250] = Utf8 type 
.const [251] = Utf8 I 
.const [252] = Utf8 org/dsi/ifc/navigation/NavPoiInfo 
.const [253] = Utf8 exitPoiLocation 
.const [254] = Utf8 Lorg/dsi/ifc/global/NavLocation; 
.const [255] = Utf8 org/dsi/ifc/navigation/NavPoiInfo 
.const [256] = Utf8 poiIcons 
.const [257] = Utf8 [Lorg/dsi/ifc/navigation/NavRouteListDataIcon; 
.const [258] = Utf8 de/esolutions/fw/comm/dsi/navigation/impl/NavPoiInfoSerializer 
.const [259] = Class [258] 
.const [260] = Utf8 java/lang/Object 
.const [261] = Class [260] 
.const [262] = Utf8 Code 
.const [263] = Utf8 <init> 
.const [264] = Utf8 ()V 
.const [265] = Utf8 putOptionalNavPoiInfo 
.const [266] = Utf8 (Lde/esolutions/fw/util/serializer/ISerializer;Lorg/dsi/ifc/navigation/NavPoiInfo;)V 
.const [267] = Utf8 putOptionalNavPoiInfoVarArray 
.const [268] = Utf8 (Lde/esolutions/fw/util/serializer/ISerializer;[Lorg/dsi/ifc/navigation/NavPoiInfo;)V 
.const [269] = Utf8 getOptionalNavPoiInfo 
.const [270] = Utf8 (Lde/esolutions/fw/util/serializer/IDeserializer;)Lorg/dsi/ifc/navigation/NavPoiInfo; 
.const [271] = Utf8 getOptionalNavPoiInfoVarArray 
.const [272] = Utf8 (Lde/esolutions/fw/util/serializer/IDeserializer;)[Lorg/dsi/ifc/navigation/NavPoiInfo; 
.end class 
