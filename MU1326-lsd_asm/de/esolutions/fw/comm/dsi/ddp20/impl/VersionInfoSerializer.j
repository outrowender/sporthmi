.version 50 0 
.class public super [305] 
.super [307] 

.method public annotation [309] : [310] 
    .attribute [308] .code stack 1 locals 0 
L0:     aload_0 
L1:     invokespecial [29] 
L4:     return 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public static [311] : [312] 
    .attribute [308] .code stack 2 locals 18 
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
L37:    istore 4 
L39:    aload_0 
L40:    iload 4 
L42:    invokeinterface [32] 0 
L47:    aload_1 
L48:    invokevirtual [14] 
L51:    astore 5 
L53:    aload_0 
L54:    aload 5 
L56:    invokeinterface [33] 0 
L61:    aload_1 
L62:    invokevirtual [15] 
L65:    astore 6 
L67:    aload_0 
L68:    aload 6 
L70:    invokestatic [2] 
L73:    aload_1 
L74:    invokevirtual [16] 
L77:    istore 7 
L79:    aload_0 
L80:    iload 7 
L82:    invokeinterface [32] 0 
L87:    aload_1 
L88:    invokevirtual [17] 
L91:    istore 8 
L93:    aload_0 
L94:    iload 8 
L96:    invokeinterface [32] 0 
L101:   aload_1 
L102:   invokevirtual [18] 
L105:   istore 9 
L107:   aload_0 
L108:   iload 9 
L110:   invokeinterface [32] 0 
L115:   aload_1 
L116:   invokevirtual [19] 
L119:   istore 10 
L121:   aload_0 
L122:   iload 10 
L124:   invokeinterface [32] 0 
L129:   aload_1 
L130:   invokevirtual [20] 
L133:   istore 11 
L135:   aload_0 
L136:   iload 11 
L138:   invokeinterface [32] 0 
L143:   aload_1 
L144:   invokevirtual [21] 
L147:   istore 12 
L149:   aload_0 
L150:   iload 12 
L152:   invokeinterface [32] 0 
L157:   aload_1 
L158:   invokevirtual [22] 
L161:   istore 13 
L163:   aload_0 
L164:   iload 13 
L166:   invokeinterface [31] 0 
L171:   aload_1 
L172:   invokevirtual [23] 
L175:   istore 14 
L177:   aload_0 
L178:   iload 14 
L180:   invokeinterface [32] 0 
L185:   aload_1 
L186:   invokevirtual [24] 
L189:   istore 15 
L191:   aload_0 
L192:   iload 15 
L194:   invokeinterface [32] 0 
L199:   aload_1 
L200:   invokevirtual [25] 
L203:   istore 16 
L205:   aload_0 
L206:   iload 16 
L208:   invokeinterface [32] 0 
L213:   aload_1 
L214:   invokevirtual [26] 
L217:   istore 17 
L219:   aload_0 
L220:   iload 17 
L222:   invokeinterface [32] 0 
L227:   aload_1 
L228:   invokevirtual [27] 
L231:   istore 18 
L233:   aload_0 
L234:   iload 18 
L236:   invokeinterface [32] 0 
L241:   aload_1 
L242:   invokevirtual [28] 
L245:   astore 19 
L247:   aload_0 
L248:   aload 19 
L250:   invokeinterface [34] 0 
L255:   return 
L256:   
    .end code 
.end method 

.method public static [313] : [314] 
    .attribute [308] .code stack 3 locals 2 
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

.method public static [315] : [316] 
    .attribute [308] .code stack 2 locals 19 
L0:     aconst_null 
L1:     astore_1 
L2:     aload_0 
L3:     invokeinterface [35] 0 
L8:     istore_2 
L9:     iload_2 
L10:    ifne L255 
L13:    new [36] 
L16:    dup 
L17:    invokespecial [30] 
L20:    astore_1 
L21:    aload_0 
L22:    invokeinterface [37] 0 
L27:    istore_3 
L28:    aload_1 
L29:    iload_3 
L30:    putfield [38] 
L33:    aload_0 
L34:    invokeinterface [37] 0 
L39:    istore 4 
L41:    aload_1 
L42:    iload 4 
L44:    putfield [39] 
L47:    aload_0 
L48:    invokeinterface [40] 0 
L53:    astore 5 
L55:    aload_1 
L56:    aload 5 
L58:    putfield [41] 
L61:    aload_0 
L62:    invokestatic [5] 
L65:    astore 6 
L67:    aload_1 
L68:    aload 6 
L70:    putfield [42] 
L73:    aload_0 
L74:    invokeinterface [37] 0 
L79:    istore 7 
L81:    aload_1 
L82:    iload 7 
L84:    putfield [43] 
L87:    aload_0 
L88:    invokeinterface [37] 0 
L93:    istore 8 
L95:    aload_1 
L96:    iload 8 
L98:    putfield [44] 
L101:   aload_0 
L102:   invokeinterface [37] 0 
L107:   istore 9 
L109:   aload_1 
L110:   iload 9 
L112:   putfield [45] 
L115:   aload_0 
L116:   invokeinterface [37] 0 
L121:   istore 10 
L123:   aload_1 
L124:   iload 10 
L126:   putfield [46] 
L129:   aload_0 
L130:   invokeinterface [37] 0 
L135:   istore 11 
L137:   aload_1 
L138:   iload 11 
L140:   putfield [47] 
L143:   aload_0 
L144:   invokeinterface [37] 0 
L149:   istore 12 
L151:   aload_1 
L152:   iload 12 
L154:   putfield [48] 
L157:   aload_0 
L158:   invokeinterface [35] 0 
L163:   istore 13 
L165:   aload_1 
L166:   iload 13 
L168:   putfield [49] 
L171:   aload_0 
L172:   invokeinterface [37] 0 
L177:   istore 14 
L179:   aload_1 
L180:   iload 14 
L182:   putfield [50] 
L185:   aload_0 
L186:   invokeinterface [37] 0 
L191:   istore 15 
L193:   aload_1 
L194:   iload 15 
L196:   putfield [51] 
L199:   aload_0 
L200:   invokeinterface [37] 0 
L205:   istore 16 
L207:   aload_1 
L208:   iload 16 
L210:   putfield [52] 
L213:   aload_0 
L214:   invokeinterface [37] 0 
L219:   istore 17 
L221:   aload_1 
L222:   iload 17 
L224:   putfield [53] 
L227:   aload_0 
L228:   invokeinterface [37] 0 
L233:   istore 18 
L235:   aload_1 
L236:   iload 18 
L238:   putfield [54] 
L241:   aload_0 
L242:   invokeinterface [55] 0 
L247:   astore 19 
L249:   aload_1 
L250:   aload 19 
L252:   putfield [56] 
L255:   aload_1 
L256:   areturn 
L257:   nop 
L258:   nop 
L259:   nop 
L260:   
    .end code 
.end method 

.method public static [317] : [318] 
    .attribute [308] .code stack 3 locals 4 
L0:     aconst_null 
L1:     astore_1 
L2:     aload_0 
L3:     invokeinterface [35] 0 
L8:     istore_2 
L9:     iload_2 
L10:    ifne L48 
L13:    aload_0 
L14:    invokeinterface [37] 0 
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
.const [2] = Method [57] [58] 
.const [3] = Method [59] [60] 
.const [4] = Class [61] 
.const [5] = Method [62] [63] 
.const [6] = Method [64] [65] 
.const [7] = Class [66] 
.const [8] = Class [67] 
.const [9] = Class [68] 
.const [10] = Class [69] 
.const [11] = Class [70] 
.const [12] = Method [71] [72] 
.const [13] = Method [73] [74] 
.const [14] = Method [75] [76] 
.const [15] = Method [77] [78] 
.const [16] = Method [79] [80] 
.const [17] = Method [81] [82] 
.const [18] = Method [83] [84] 
.const [19] = Method [85] [86] 
.const [20] = Method [87] [88] 
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
.const [31] = InterfaceMethod [109] [110] 
.const [32] = InterfaceMethod [111] [112] 
.const [33] = InterfaceMethod [113] [114] 
.const [34] = InterfaceMethod [115] [116] 
.const [35] = InterfaceMethod [117] [118] 
.const [36] = Class [119] 
.const [37] = InterfaceMethod [120] [121] 
.const [38] = Field [122] [123] 
.const [39] = Field [124] [125] 
.const [40] = InterfaceMethod [126] [127] 
.const [41] = Field [128] [129] 
.const [42] = Field [130] [131] 
.const [43] = Field [132] [133] 
.const [44] = Field [134] [135] 
.const [45] = Field [136] [137] 
.const [46] = Field [138] [139] 
.const [47] = Field [140] [141] 
.const [48] = Field [142] [143] 
.const [49] = Field [144] [145] 
.const [50] = Field [146] [147] 
.const [51] = Field [148] [149] 
.const [52] = Field [150] [151] 
.const [53] = Field [152] [153] 
.const [54] = Field [154] [155] 
.const [55] = InterfaceMethod [156] [157] 
.const [56] = Field [158] [159] 
.const [57] = Class [160] 
.const [58] = NameAndType [161] [162] 
.const [59] = Class [163] 
.const [60] = NameAndType [164] [165] 
.const [61] = Utf8 org/dsi/ifc/ddp20/VersionInfo 
.const [62] = Class [166] 
.const [63] = NameAndType [167] [168] 
.const [64] = Class [169] 
.const [65] = NameAndType [170] [171] 
.const [66] = Utf8 de/esolutions/fw/comm/dsi/ddp20/impl/VersionInfoSerializer 
.const [67] = Utf8 java/lang/Object 
.const [68] = Utf8 de/esolutions/fw/util/serializer/ISerializer 
.const [69] = Utf8 de/esolutions/fw/comm/dsi/ddp20/impl/ProjectInfoSerializer 
.const [70] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [71] = Class [172] 
.const [72] = NameAndType [173] [174] 
.const [73] = Class [175] 
.const [74] = NameAndType [176] [177] 
.const [75] = Class [178] 
.const [76] = NameAndType [179] [180] 
.const [77] = Class [181] 
.const [78] = NameAndType [182] [183] 
.const [79] = Class [184] 
.const [80] = NameAndType [185] [186] 
.const [81] = Class [187] 
.const [82] = NameAndType [188] [189] 
.const [83] = Class [190] 
.const [84] = NameAndType [191] [192] 
.const [85] = Class [193] 
.const [86] = NameAndType [194] [195] 
.const [87] = Class [196] 
.const [88] = NameAndType [197] [198] 
.const [89] = Class [199] 
.const [90] = NameAndType [200] [201] 
.const [91] = Class [202] 
.const [92] = NameAndType [203] [204] 
.const [93] = Class [205] 
.const [94] = NameAndType [206] [207] 
.const [95] = Class [208] 
.const [96] = NameAndType [209] [210] 
.const [97] = Class [211] 
.const [98] = NameAndType [212] [213] 
.const [99] = Class [214] 
.const [100] = NameAndType [215] [216] 
.const [101] = Class [217] 
.const [102] = NameAndType [218] [219] 
.const [103] = Class [220] 
.const [104] = NameAndType [221] [222] 
.const [105] = Class [223] 
.const [106] = NameAndType [224] [225] 
.const [107] = Class [226] 
.const [108] = NameAndType [227] [228] 
.const [109] = Class [229] 
.const [110] = NameAndType [230] [231] 
.const [111] = Class [232] 
.const [112] = NameAndType [233] [234] 
.const [113] = Class [235] 
.const [114] = NameAndType [236] [237] 
.const [115] = Class [238] 
.const [116] = NameAndType [239] [240] 
.const [117] = Class [241] 
.const [118] = NameAndType [242] [243] 
.const [119] = Utf8 org/dsi/ifc/ddp20/VersionInfo 
.const [120] = Class [244] 
.const [121] = NameAndType [245] [246] 
.const [122] = Class [247] 
.const [123] = NameAndType [248] [249] 
.const [124] = Class [250] 
.const [125] = NameAndType [251] [252] 
.const [126] = Class [253] 
.const [127] = NameAndType [254] [255] 
.const [128] = Class [256] 
.const [129] = NameAndType [257] [258] 
.const [130] = Class [259] 
.const [131] = NameAndType [260] [261] 
.const [132] = Class [262] 
.const [133] = NameAndType [263] [264] 
.const [134] = Class [265] 
.const [135] = NameAndType [266] [267] 
.const [136] = Class [268] 
.const [137] = NameAndType [269] [270] 
.const [138] = Class [271] 
.const [139] = NameAndType [272] [273] 
.const [140] = Class [274] 
.const [141] = NameAndType [275] [276] 
.const [142] = Class [277] 
.const [143] = NameAndType [278] [279] 
.const [144] = Class [280] 
.const [145] = NameAndType [281] [282] 
.const [146] = Class [283] 
.const [147] = NameAndType [284] [285] 
.const [148] = Class [286] 
.const [149] = NameAndType [287] [288] 
.const [150] = Class [289] 
.const [151] = NameAndType [290] [291] 
.const [152] = Class [292] 
.const [153] = NameAndType [293] [294] 
.const [154] = Class [295] 
.const [155] = NameAndType [296] [297] 
.const [156] = Class [298] 
.const [157] = NameAndType [299] [300] 
.const [158] = Class [301] 
.const [159] = NameAndType [302] [303] 
.const [160] = Utf8 de/esolutions/fw/comm/dsi/ddp20/impl/ProjectInfoSerializer 
.const [161] = Utf8 putOptionalProjectInfo 
.const [162] = Utf8 (Lde/esolutions/fw/util/serializer/ISerializer;Lorg/dsi/ifc/ddp20/ProjectInfo;)V 
.const [163] = Utf8 de/esolutions/fw/comm/dsi/ddp20/impl/VersionInfoSerializer 
.const [164] = Utf8 putOptionalVersionInfo 
.const [165] = Utf8 (Lde/esolutions/fw/util/serializer/ISerializer;Lorg/dsi/ifc/ddp20/VersionInfo;)V 
.const [166] = Utf8 de/esolutions/fw/comm/dsi/ddp20/impl/ProjectInfoSerializer 
.const [167] = Utf8 getOptionalProjectInfo 
.const [168] = Utf8 (Lde/esolutions/fw/util/serializer/IDeserializer;)Lorg/dsi/ifc/ddp20/ProjectInfo; 
.const [169] = Utf8 de/esolutions/fw/comm/dsi/ddp20/impl/VersionInfoSerializer 
.const [170] = Utf8 getOptionalVersionInfo 
.const [171] = Utf8 (Lde/esolutions/fw/util/serializer/IDeserializer;)Lorg/dsi/ifc/ddp20/VersionInfo; 
.const [172] = Utf8 org/dsi/ifc/ddp20/VersionInfo 
.const [173] = Utf8 getIdent 
.const [174] = Utf8 ()I 
.const [175] = Utf8 org/dsi/ifc/ddp20/VersionInfo 
.const [176] = Utf8 getManufacturer 
.const [177] = Utf8 ()I 
.const [178] = Utf8 org/dsi/ifc/ddp20/VersionInfo 
.const [179] = Utf8 getSwInfo 
.const [180] = Utf8 ()Ljava/lang/String; 
.const [181] = Utf8 org/dsi/ifc/ddp20/VersionInfo 
.const [182] = Utf8 getProjectInfo 
.const [183] = Utf8 ()Lorg/dsi/ifc/ddp20/ProjectInfo; 
.const [184] = Utf8 org/dsi/ifc/ddp20/VersionInfo 
.const [185] = Utf8 getProtocolVersion 
.const [186] = Utf8 ()I 
.const [187] = Utf8 org/dsi/ifc/ddp20/VersionInfo 
.const [188] = Utf8 getCharacterVersion 
.const [189] = Utf8 ()I 
.const [190] = Utf8 org/dsi/ifc/ddp20/VersionInfo 
.const [191] = Utf8 getSymbolVersion 
.const [192] = Utf8 ()I 
.const [193] = Utf8 org/dsi/ifc/ddp20/VersionInfo 
.const [194] = Utf8 getFrameVersion 
.const [195] = Utf8 ()I 
.const [196] = Utf8 org/dsi/ifc/ddp20/VersionInfo 
.const [197] = Utf8 getBitmapVersion 
.const [198] = Utf8 ()I 
.const [199] = Utf8 org/dsi/ifc/ddp20/VersionInfo 
.const [200] = Utf8 getDisplayInfo 
.const [201] = Utf8 ()I 
.const [202] = Utf8 org/dsi/ifc/ddp20/VersionInfo 
.const [203] = Utf8 isWindowCaching 
.const [204] = Utf8 ()Z 
.const [205] = Utf8 org/dsi/ifc/ddp20/VersionInfo 
.const [206] = Utf8 getNumEntriesMenu 
.const [207] = Utf8 ()I 
.const [208] = Utf8 org/dsi/ifc/ddp20/VersionInfo 
.const [209] = Utf8 getNumEntriesSubmenu 
.const [210] = Utf8 ()I 
.const [211] = Utf8 org/dsi/ifc/ddp20/VersionInfo 
.const [212] = Utf8 getNumEntriesPopup 
.const [213] = Utf8 ()I 
.const [214] = Utf8 org/dsi/ifc/ddp20/VersionInfo 
.const [215] = Utf8 getNumLaneGuidanceBoxes 
.const [216] = Utf8 ()I 
.const [217] = Utf8 org/dsi/ifc/ddp20/VersionInfo 
.const [218] = Utf8 getNumFrameIDs 
.const [219] = Utf8 ()I 
.const [220] = Utf8 org/dsi/ifc/ddp20/VersionInfo 
.const [221] = Utf8 getFrameIDs 
.const [222] = Utf8 ()[I 
.const [223] = Utf8 java/lang/Object 
.const [224] = Utf8 <init> 
.const [225] = Utf8 ()V 
.const [226] = Utf8 org/dsi/ifc/ddp20/VersionInfo 
.const [227] = Utf8 <init> 
.const [228] = Utf8 ()V 
.const [229] = Utf8 de/esolutions/fw/util/serializer/ISerializer 
.const [230] = Utf8 putBool 
.const [231] = Utf8 (Z)V 
.const [232] = Utf8 de/esolutions/fw/util/serializer/ISerializer 
.const [233] = Utf8 putInt32 
.const [234] = Utf8 (I)V 
.const [235] = Utf8 de/esolutions/fw/util/serializer/ISerializer 
.const [236] = Utf8 putOptionalString 
.const [237] = Utf8 (Ljava/lang/String;)V 
.const [238] = Utf8 de/esolutions/fw/util/serializer/ISerializer 
.const [239] = Utf8 putOptionalInt32VarArray 
.const [240] = Utf8 ([I)V 
.const [241] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [242] = Utf8 getBool 
.const [243] = Utf8 ()Z 
.const [244] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [245] = Utf8 getInt32 
.const [246] = Utf8 ()I 
.const [247] = Utf8 org/dsi/ifc/ddp20/VersionInfo 
.const [248] = Utf8 ident 
.const [249] = Utf8 I 
.const [250] = Utf8 org/dsi/ifc/ddp20/VersionInfo 
.const [251] = Utf8 manufacturer 
.const [252] = Utf8 I 
.const [253] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [254] = Utf8 getOptionalString 
.const [255] = Utf8 ()Ljava/lang/String; 
.const [256] = Utf8 org/dsi/ifc/ddp20/VersionInfo 
.const [257] = Utf8 swInfo 
.const [258] = Utf8 Ljava/lang/String; 
.const [259] = Utf8 org/dsi/ifc/ddp20/VersionInfo 
.const [260] = Utf8 projectInfo 
.const [261] = Utf8 Lorg/dsi/ifc/ddp20/ProjectInfo; 
.const [262] = Utf8 org/dsi/ifc/ddp20/VersionInfo 
.const [263] = Utf8 protocolVersion 
.const [264] = Utf8 I 
.const [265] = Utf8 org/dsi/ifc/ddp20/VersionInfo 
.const [266] = Utf8 characterVersion 
.const [267] = Utf8 I 
.const [268] = Utf8 org/dsi/ifc/ddp20/VersionInfo 
.const [269] = Utf8 symbolVersion 
.const [270] = Utf8 I 
.const [271] = Utf8 org/dsi/ifc/ddp20/VersionInfo 
.const [272] = Utf8 frameVersion 
.const [273] = Utf8 I 
.const [274] = Utf8 org/dsi/ifc/ddp20/VersionInfo 
.const [275] = Utf8 bitmapVersion 
.const [276] = Utf8 I 
.const [277] = Utf8 org/dsi/ifc/ddp20/VersionInfo 
.const [278] = Utf8 displayInfo 
.const [279] = Utf8 I 
.const [280] = Utf8 org/dsi/ifc/ddp20/VersionInfo 
.const [281] = Utf8 windowCaching 
.const [282] = Utf8 Z 
.const [283] = Utf8 org/dsi/ifc/ddp20/VersionInfo 
.const [284] = Utf8 numEntriesMenu 
.const [285] = Utf8 I 
.const [286] = Utf8 org/dsi/ifc/ddp20/VersionInfo 
.const [287] = Utf8 numEntriesSubmenu 
.const [288] = Utf8 I 
.const [289] = Utf8 org/dsi/ifc/ddp20/VersionInfo 
.const [290] = Utf8 numEntriesPopup 
.const [291] = Utf8 I 
.const [292] = Utf8 org/dsi/ifc/ddp20/VersionInfo 
.const [293] = Utf8 numLaneGuidanceBoxes 
.const [294] = Utf8 I 
.const [295] = Utf8 org/dsi/ifc/ddp20/VersionInfo 
.const [296] = Utf8 numFrameIDs 
.const [297] = Utf8 I 
.const [298] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [299] = Utf8 getOptionalInt32VarArray 
.const [300] = Utf8 ()[I 
.const [301] = Utf8 org/dsi/ifc/ddp20/VersionInfo 
.const [302] = Utf8 frameIDs 
.const [303] = Utf8 [I 
.const [304] = Utf8 de/esolutions/fw/comm/dsi/ddp20/impl/VersionInfoSerializer 
.const [305] = Class [304] 
.const [306] = Utf8 java/lang/Object 
.const [307] = Class [306] 
.const [308] = Utf8 Code 
.const [309] = Utf8 <init> 
.const [310] = Utf8 ()V 
.const [311] = Utf8 putOptionalVersionInfo 
.const [312] = Utf8 (Lde/esolutions/fw/util/serializer/ISerializer;Lorg/dsi/ifc/ddp20/VersionInfo;)V 
.const [313] = Utf8 putOptionalVersionInfoVarArray 
.const [314] = Utf8 (Lde/esolutions/fw/util/serializer/ISerializer;[Lorg/dsi/ifc/ddp20/VersionInfo;)V 
.const [315] = Utf8 getOptionalVersionInfo 
.const [316] = Utf8 (Lde/esolutions/fw/util/serializer/IDeserializer;)Lorg/dsi/ifc/ddp20/VersionInfo; 
.const [317] = Utf8 getOptionalVersionInfoVarArray 
.const [318] = Utf8 (Lde/esolutions/fw/util/serializer/IDeserializer;)[Lorg/dsi/ifc/ddp20/VersionInfo; 
.end class 
