.version 50 0 
.class public super [293] 
.super [295] 

.method public annotation [297] : [298] 
    .attribute [296] .code stack 1 locals 0 
L0:     aload_0 
L1:     invokespecial [25] 
L4:     return 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public static [299] : [300] 
    .attribute [296] .code stack 3 locals 15 
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
L18:    ifne L199 
L21:    aload_1 
L22:    invokevirtual [12] 
L25:    astore_3 
L26:    aload_0 
L27:    aload_3 
L28:    invokestatic [2] 
L31:    aload_1 
L32:    invokevirtual [13] 
L35:    fstore 4 
L37:    aload_0 
L38:    fload 4 
L40:    invokeinterface [28] 0 
L45:    aload_1 
L46:    invokevirtual [14] 
L49:    fstore 5 
L51:    aload_0 
L52:    fload 5 
L54:    invokeinterface [28] 0 
L59:    aload_1 
L60:    invokevirtual [15] 
L63:    fstore 6 
L65:    aload_0 
L66:    fload 6 
L68:    invokeinterface [28] 0 
L73:    aload_1 
L74:    invokevirtual [16] 
L77:    fstore 7 
L79:    aload_0 
L80:    fload 7 
L82:    invokeinterface [28] 0 
L87:    aload_1 
L88:    invokevirtual [17] 
L91:    fstore 8 
L93:    aload_0 
L94:    fload 8 
L96:    invokeinterface [28] 0 
L101:   aload_1 
L102:   invokevirtual [18] 
L105:   lstore 9 
L107:   aload_0 
L108:   lload 9 
L110:   invokeinterface [29] 0 
L115:   aload_1 
L116:   invokevirtual [19] 
L119:   istore 11 
L121:   aload_0 
L122:   iload 11 
L124:   invokeinterface [30] 0 
L129:   aload_1 
L130:   invokevirtual [20] 
L133:   istore 12 
L135:   aload_0 
L136:   iload 12 
L138:   invokeinterface [30] 0 
L143:   aload_1 
L144:   invokevirtual [21] 
L147:   istore 13 
L149:   aload_0 
L150:   iload 13 
L152:   invokeinterface [30] 0 
L157:   aload_1 
L158:   invokevirtual [22] 
L161:   astore 14 
L163:   aload_0 
L164:   aload 14 
L166:   invokeinterface [31] 0 
L171:   aload_1 
L172:   invokevirtual [23] 
L175:   istore 15 
L177:   aload_0 
L178:   iload 15 
L180:   invokeinterface [32] 0 
L185:   aload_1 
L186:   invokevirtual [24] 
L189:   istore 16 
L191:   aload_0 
L192:   iload 16 
L194:   invokeinterface [32] 0 
L199:   return 
L200:   
    .end code 
.end method 

.method public static [301] : [302] 
    .attribute [296] .code stack 3 locals 2 
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
L41:    invokestatic [3] 
L44:    iinc 3 1 
L47:    goto L31 
L50:    return 
L51:    nop 
L52:    
    .end code 
.end method 

.method public static [303] : [304] 
    .attribute [296] .code stack 3 locals 16 
L0:     aconst_null 
L1:     astore_1 
L2:     aload_0 
L3:     invokeinterface [34] 0 
L8:     istore_2 
L9:     iload_2 
L10:    ifne L199 
L13:    new [35] 
L16:    dup 
L17:    invokespecial [26] 
L20:    astore_1 
L21:    aload_0 
L22:    invokestatic [5] 
L25:    astore_3 
L26:    aload_1 
L27:    aload_3 
L28:    putfield [36] 
L31:    aload_0 
L32:    invokeinterface [37] 0 
L37:    fstore 4 
L39:    aload_1 
L40:    fload 4 
L42:    putfield [38] 
L45:    aload_0 
L46:    invokeinterface [37] 0 
L51:    fstore 5 
L53:    aload_1 
L54:    fload 5 
L56:    putfield [39] 
L59:    aload_0 
L60:    invokeinterface [37] 0 
L65:    fstore 6 
L67:    aload_1 
L68:    fload 6 
L70:    putfield [40] 
L73:    aload_0 
L74:    invokeinterface [37] 0 
L79:    fstore 7 
L81:    aload_1 
L82:    fload 7 
L84:    putfield [41] 
L87:    aload_0 
L88:    invokeinterface [37] 0 
L93:    fstore 8 
L95:    aload_1 
L96:    fload 8 
L98:    putfield [42] 
L101:   aload_0 
L102:   invokeinterface [43] 0 
L107:   lstore 9 
L109:   aload_1 
L110:   lload 9 
L112:   putfield [44] 
L115:   aload_0 
L116:   invokeinterface [45] 0 
L121:   istore 11 
L123:   aload_1 
L124:   iload 11 
L126:   putfield [46] 
L129:   aload_0 
L130:   invokeinterface [45] 0 
L135:   istore 12 
L137:   aload_1 
L138:   iload 12 
L140:   putfield [47] 
L143:   aload_0 
L144:   invokeinterface [45] 0 
L149:   istore 13 
L151:   aload_1 
L152:   iload 13 
L154:   putfield [48] 
L157:   aload_0 
L158:   invokeinterface [49] 0 
L163:   astore 14 
L165:   aload_1 
L166:   aload 14 
L168:   putfield [50] 
L171:   aload_0 
L172:   invokeinterface [51] 0 
L177:   istore 15 
L179:   aload_1 
L180:   iload 15 
L182:   putfield [52] 
L185:   aload_0 
L186:   invokeinterface [51] 0 
L191:   istore 16 
L193:   aload_1 
L194:   iload 16 
L196:   putfield [53] 
L199:   aload_1 
L200:   areturn 
L201:   nop 
L202:   nop 
L203:   nop 
L204:   
    .end code 
.end method 

.method public static [305] : [306] 
    .attribute [296] .code stack 3 locals 4 
L0:     aconst_null 
L1:     astore_1 
L2:     aload_0 
L3:     invokeinterface [34] 0 
L8:     istore_2 
L9:     iload_2 
L10:    ifne L48 
L13:    aload_0 
L14:    invokeinterface [54] 0 
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
.const [2] = Method [55] [56] 
.const [3] = Method [57] [58] 
.const [4] = Class [59] 
.const [5] = Method [60] [61] 
.const [6] = Method [62] [63] 
.const [7] = Class [64] 
.const [8] = Class [65] 
.const [9] = Class [66] 
.const [10] = Class [67] 
.const [11] = Class [68] 
.const [12] = Method [69] [70] 
.const [13] = Method [71] [72] 
.const [14] = Method [73] [74] 
.const [15] = Method [75] [76] 
.const [16] = Method [77] [78] 
.const [17] = Method [79] [80] 
.const [18] = Method [81] [82] 
.const [19] = Method [83] [84] 
.const [20] = Method [85] [86] 
.const [21] = Method [87] [88] 
.const [22] = Method [89] [90] 
.const [23] = Method [91] [92] 
.const [24] = Method [93] [94] 
.const [25] = Method [95] [96] 
.const [26] = Method [97] [98] 
.const [27] = InterfaceMethod [99] [100] 
.const [28] = InterfaceMethod [101] [102] 
.const [29] = InterfaceMethod [103] [104] 
.const [30] = InterfaceMethod [105] [106] 
.const [31] = InterfaceMethod [107] [108] 
.const [32] = InterfaceMethod [109] [110] 
.const [33] = InterfaceMethod [111] [112] 
.const [34] = InterfaceMethod [113] [114] 
.const [35] = Class [115] 
.const [36] = Field [116] [117] 
.const [37] = InterfaceMethod [118] [119] 
.const [38] = Field [120] [121] 
.const [39] = Field [122] [123] 
.const [40] = Field [124] [125] 
.const [41] = Field [126] [127] 
.const [42] = Field [128] [129] 
.const [43] = InterfaceMethod [130] [131] 
.const [44] = Field [132] [133] 
.const [45] = InterfaceMethod [134] [135] 
.const [46] = Field [136] [137] 
.const [47] = Field [138] [139] 
.const [48] = Field [140] [141] 
.const [49] = InterfaceMethod [142] [143] 
.const [50] = Field [144] [145] 
.const [51] = InterfaceMethod [146] [147] 
.const [52] = Field [148] [149] 
.const [53] = Field [150] [151] 
.const [54] = InterfaceMethod [152] [153] 
.const [55] = Class [154] 
.const [56] = NameAndType [155] [156] 
.const [57] = Class [157] 
.const [58] = NameAndType [158] [159] 
.const [59] = Utf8 de/esolutions/fw/comm/asi/navigation/esoposproviderfull/sMapPosition 
.const [60] = Class [160] 
.const [61] = NameAndType [161] [162] 
.const [62] = Class [163] 
.const [63] = NameAndType [164] [165] 
.const [64] = Utf8 de/esolutions/fw/comm/asi/navigation/esoposproviderfull/impl/sMapPositionSerializer 
.const [65] = Utf8 java/lang/Object 
.const [66] = Utf8 de/esolutions/fw/util/serializer/ISerializer 
.const [67] = Utf8 de/esolutions/fw/comm/asi/navigation/esoposproviderfull/impl/sPositionSerializer 
.const [68] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [69] = Class [166] 
.const [70] = NameAndType [167] [168] 
.const [71] = Class [169] 
.const [72] = NameAndType [170] [171] 
.const [73] = Class [172] 
.const [74] = NameAndType [173] [174] 
.const [75] = Class [175] 
.const [76] = NameAndType [176] [177] 
.const [77] = Class [178] 
.const [78] = NameAndType [179] [180] 
.const [79] = Class [181] 
.const [80] = NameAndType [182] [183] 
.const [81] = Class [184] 
.const [82] = NameAndType [185] [186] 
.const [83] = Class [187] 
.const [84] = NameAndType [188] [189] 
.const [85] = Class [190] 
.const [86] = NameAndType [191] [192] 
.const [87] = Class [193] 
.const [88] = NameAndType [194] [195] 
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
.const [115] = Utf8 de/esolutions/fw/comm/asi/navigation/esoposproviderfull/sMapPosition 
.const [116] = Class [235] 
.const [117] = NameAndType [236] [237] 
.const [118] = Class [238] 
.const [119] = NameAndType [239] [240] 
.const [120] = Class [241] 
.const [121] = NameAndType [242] [243] 
.const [122] = Class [244] 
.const [123] = NameAndType [245] [246] 
.const [124] = Class [247] 
.const [125] = NameAndType [248] [249] 
.const [126] = Class [250] 
.const [127] = NameAndType [251] [252] 
.const [128] = Class [253] 
.const [129] = NameAndType [254] [255] 
.const [130] = Class [256] 
.const [131] = NameAndType [257] [258] 
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
.const [154] = Utf8 de/esolutions/fw/comm/asi/navigation/esoposproviderfull/impl/sPositionSerializer 
.const [155] = Utf8 putOptionalsPosition 
.const [156] = Utf8 (Lde/esolutions/fw/util/serializer/ISerializer;Lde/esolutions/fw/comm/asi/navigation/esoposproviderfull/sPosition;)V 
.const [157] = Utf8 de/esolutions/fw/comm/asi/navigation/esoposproviderfull/impl/sMapPositionSerializer 
.const [158] = Utf8 putOptionalsMapPosition 
.const [159] = Utf8 (Lde/esolutions/fw/util/serializer/ISerializer;Lde/esolutions/fw/comm/asi/navigation/esoposproviderfull/sMapPosition;)V 
.const [160] = Utf8 de/esolutions/fw/comm/asi/navigation/esoposproviderfull/impl/sPositionSerializer 
.const [161] = Utf8 getOptionalsPosition 
.const [162] = Utf8 (Lde/esolutions/fw/util/serializer/IDeserializer;)Lde/esolutions/fw/comm/asi/navigation/esoposproviderfull/sPosition; 
.const [163] = Utf8 de/esolutions/fw/comm/asi/navigation/esoposproviderfull/impl/sMapPositionSerializer 
.const [164] = Utf8 getOptionalsMapPosition 
.const [165] = Utf8 (Lde/esolutions/fw/util/serializer/IDeserializer;)Lde/esolutions/fw/comm/asi/navigation/esoposproviderfull/sMapPosition; 
.const [166] = Utf8 de/esolutions/fw/comm/asi/navigation/esoposproviderfull/sMapPosition 
.const [167] = Utf8 getPosition 
.const [168] = Utf8 ()Lde/esolutions/fw/comm/asi/navigation/esoposproviderfull/sPosition; 
.const [169] = Utf8 de/esolutions/fw/comm/asi/navigation/esoposproviderfull/sMapPosition 
.const [170] = Utf8 getHorzStdDev 
.const [171] = Utf8 ()F 
.const [172] = Utf8 de/esolutions/fw/comm/asi/navigation/esoposproviderfull/sMapPosition 
.const [173] = Utf8 getHeadingStdDev 
.const [174] = Utf8 ()F 
.const [175] = Utf8 de/esolutions/fw/comm/asi/navigation/esoposproviderfull/sMapPosition 
.const [176] = Utf8 getAltitude 
.const [177] = Utf8 ()F 
.const [178] = Utf8 de/esolutions/fw/comm/asi/navigation/esoposproviderfull/sMapPosition 
.const [179] = Utf8 getVelocity 
.const [180] = Utf8 ()F 
.const [181] = Utf8 de/esolutions/fw/comm/asi/navigation/esoposproviderfull/sMapPosition 
.const [182] = Utf8 getVelocityStdDev 
.const [183] = Utf8 ()F 
.const [184] = Utf8 de/esolutions/fw/comm/asi/navigation/esoposproviderfull/sMapPosition 
.const [185] = Utf8 getOdometer 
.const [186] = Utf8 ()J 
.const [187] = Utf8 de/esolutions/fw/comm/asi/navigation/esoposproviderfull/sMapPosition 
.const [188] = Utf8 getIsOnMap 
.const [189] = Utf8 ()I 
.const [190] = Utf8 de/esolutions/fw/comm/asi/navigation/esoposproviderfull/sMapPosition 
.const [191] = Utf8 getIsOnRoad 
.const [192] = Utf8 ()I 
.const [193] = Utf8 de/esolutions/fw/comm/asi/navigation/esoposproviderfull/sMapPosition 
.const [194] = Utf8 getIsInTunnel 
.const [195] = Utf8 ()I 
.const [196] = Utf8 de/esolutions/fw/comm/asi/navigation/esoposproviderfull/sMapPosition 
.const [197] = Utf8 getStreetName 
.const [198] = Utf8 ()Ljava/lang/String; 
.const [199] = Utf8 de/esolutions/fw/comm/asi/navigation/esoposproviderfull/sMapPosition 
.const [200] = Utf8 getNumSatInView 
.const [201] = Utf8 ()S 
.const [202] = Utf8 de/esolutions/fw/comm/asi/navigation/esoposproviderfull/sMapPosition 
.const [203] = Utf8 getNumSatInUse 
.const [204] = Utf8 ()S 
.const [205] = Utf8 java/lang/Object 
.const [206] = Utf8 <init> 
.const [207] = Utf8 ()V 
.const [208] = Utf8 de/esolutions/fw/comm/asi/navigation/esoposproviderfull/sMapPosition 
.const [209] = Utf8 <init> 
.const [210] = Utf8 ()V 
.const [211] = Utf8 de/esolutions/fw/util/serializer/ISerializer 
.const [212] = Utf8 putBool 
.const [213] = Utf8 (Z)V 
.const [214] = Utf8 de/esolutions/fw/util/serializer/ISerializer 
.const [215] = Utf8 putFloat 
.const [216] = Utf8 (F)V 
.const [217] = Utf8 de/esolutions/fw/util/serializer/ISerializer 
.const [218] = Utf8 putUInt32 
.const [219] = Utf8 (J)V 
.const [220] = Utf8 de/esolutions/fw/util/serializer/ISerializer 
.const [221] = Utf8 putEnum 
.const [222] = Utf8 (I)V 
.const [223] = Utf8 de/esolutions/fw/util/serializer/ISerializer 
.const [224] = Utf8 putOptionalString 
.const [225] = Utf8 (Ljava/lang/String;)V 
.const [226] = Utf8 de/esolutions/fw/util/serializer/ISerializer 
.const [227] = Utf8 putUInt8 
.const [228] = Utf8 (S)V 
.const [229] = Utf8 de/esolutions/fw/util/serializer/ISerializer 
.const [230] = Utf8 putInt32 
.const [231] = Utf8 (I)V 
.const [232] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [233] = Utf8 getBool 
.const [234] = Utf8 ()Z 
.const [235] = Utf8 de/esolutions/fw/comm/asi/navigation/esoposproviderfull/sMapPosition 
.const [236] = Utf8 position 
.const [237] = Utf8 Lde/esolutions/fw/comm/asi/navigation/esoposproviderfull/sPosition; 
.const [238] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [239] = Utf8 getFloat 
.const [240] = Utf8 ()F 
.const [241] = Utf8 de/esolutions/fw/comm/asi/navigation/esoposproviderfull/sMapPosition 
.const [242] = Utf8 horzStdDev 
.const [243] = Utf8 F 
.const [244] = Utf8 de/esolutions/fw/comm/asi/navigation/esoposproviderfull/sMapPosition 
.const [245] = Utf8 headingStdDev 
.const [246] = Utf8 F 
.const [247] = Utf8 de/esolutions/fw/comm/asi/navigation/esoposproviderfull/sMapPosition 
.const [248] = Utf8 altitude 
.const [249] = Utf8 F 
.const [250] = Utf8 de/esolutions/fw/comm/asi/navigation/esoposproviderfull/sMapPosition 
.const [251] = Utf8 velocity 
.const [252] = Utf8 F 
.const [253] = Utf8 de/esolutions/fw/comm/asi/navigation/esoposproviderfull/sMapPosition 
.const [254] = Utf8 velocityStdDev 
.const [255] = Utf8 F 
.const [256] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [257] = Utf8 getUInt32 
.const [258] = Utf8 ()J 
.const [259] = Utf8 de/esolutions/fw/comm/asi/navigation/esoposproviderfull/sMapPosition 
.const [260] = Utf8 odometer 
.const [261] = Utf8 J 
.const [262] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [263] = Utf8 getEnum 
.const [264] = Utf8 ()I 
.const [265] = Utf8 de/esolutions/fw/comm/asi/navigation/esoposproviderfull/sMapPosition 
.const [266] = Utf8 isOnMap 
.const [267] = Utf8 I 
.const [268] = Utf8 de/esolutions/fw/comm/asi/navigation/esoposproviderfull/sMapPosition 
.const [269] = Utf8 isOnRoad 
.const [270] = Utf8 I 
.const [271] = Utf8 de/esolutions/fw/comm/asi/navigation/esoposproviderfull/sMapPosition 
.const [272] = Utf8 isInTunnel 
.const [273] = Utf8 I 
.const [274] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [275] = Utf8 getOptionalString 
.const [276] = Utf8 ()Ljava/lang/String; 
.const [277] = Utf8 de/esolutions/fw/comm/asi/navigation/esoposproviderfull/sMapPosition 
.const [278] = Utf8 streetName 
.const [279] = Utf8 Ljava/lang/String; 
.const [280] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [281] = Utf8 getUInt8 
.const [282] = Utf8 ()S 
.const [283] = Utf8 de/esolutions/fw/comm/asi/navigation/esoposproviderfull/sMapPosition 
.const [284] = Utf8 numSatInView 
.const [285] = Utf8 S 
.const [286] = Utf8 de/esolutions/fw/comm/asi/navigation/esoposproviderfull/sMapPosition 
.const [287] = Utf8 numSatInUse 
.const [288] = Utf8 S 
.const [289] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [290] = Utf8 getInt32 
.const [291] = Utf8 ()I 
.const [292] = Utf8 de/esolutions/fw/comm/asi/navigation/esoposproviderfull/impl/sMapPositionSerializer 
.const [293] = Class [292] 
.const [294] = Utf8 java/lang/Object 
.const [295] = Class [294] 
.const [296] = Utf8 Code 
.const [297] = Utf8 <init> 
.const [298] = Utf8 ()V 
.const [299] = Utf8 putOptionalsMapPosition 
.const [300] = Utf8 (Lde/esolutions/fw/util/serializer/ISerializer;Lde/esolutions/fw/comm/asi/navigation/esoposproviderfull/sMapPosition;)V 
.const [301] = Utf8 putOptionalsMapPositionVarArray 
.const [302] = Utf8 (Lde/esolutions/fw/util/serializer/ISerializer;[Lde/esolutions/fw/comm/asi/navigation/esoposproviderfull/sMapPosition;)V 
.const [303] = Utf8 getOptionalsMapPosition 
.const [304] = Utf8 (Lde/esolutions/fw/util/serializer/IDeserializer;)Lde/esolutions/fw/comm/asi/navigation/esoposproviderfull/sMapPosition; 
.const [305] = Utf8 getOptionalsMapPositionVarArray 
.const [306] = Utf8 (Lde/esolutions/fw/util/serializer/IDeserializer;)[Lde/esolutions/fw/comm/asi/navigation/esoposproviderfull/sMapPosition; 
.end class 
