.version 50 0 
.class public super [295] 
.super [297] 

.method public annotation [299] : [300] 
    .attribute [298] .code stack 1 locals 0 
L0:     aload_0 
L1:     invokespecial [30] 
L4:     return 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public static [301] : [302] 
    .attribute [298] .code stack 3 locals 17 
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
L18:    ifne L225 
L21:    aload_1 
L22:    invokevirtual [15] 
L25:    lstore_3 
L26:    aload_0 
L27:    lload_3 
L28:    invokeinterface [33] 0 
L33:    aload_1 
L34:    invokevirtual [16] 
L37:    istore 5 
L39:    aload_0 
L40:    iload 5 
L42:    invokeinterface [34] 0 
L47:    aload_1 
L48:    invokevirtual [17] 
L51:    istore 6 
L53:    aload_0 
L54:    iload 6 
L56:    invokeinterface [34] 0 
L61:    aload_1 
L62:    invokevirtual [18] 
L65:    astore 7 
L67:    aload_0 
L68:    aload 7 
L70:    invokeinterface [35] 0 
L75:    aload_1 
L76:    invokevirtual [19] 
L79:    astore 8 
L81:    aload_0 
L82:    aload 8 
L84:    invokeinterface [35] 0 
L89:    aload_1 
L90:    invokevirtual [20] 
L93:    istore 9 
L95:    aload_0 
L96:    iload 9 
L98:    invokeinterface [34] 0 
L103:   aload_1 
L104:   invokevirtual [21] 
L107:   istore 10 
L109:   aload_0 
L110:   iload 10 
L112:   invokeinterface [34] 0 
L117:   aload_1 
L118:   invokevirtual [22] 
L121:   istore 11 
L123:   aload_0 
L124:   iload 11 
L126:   invokeinterface [34] 0 
L131:   aload_1 
L132:   invokevirtual [23] 
L135:   istore 12 
L137:   aload_0 
L138:   iload 12 
L140:   invokeinterface [34] 0 
L145:   aload_1 
L146:   invokevirtual [24] 
L149:   istore 13 
L151:   aload_0 
L152:   iload 13 
L154:   invokeinterface [34] 0 
L159:   aload_1 
L160:   invokevirtual [25] 
L163:   astore 14 
L165:   aload_0 
L166:   aload 14 
L168:   invokestatic [2] 
L171:   aload_1 
L172:   invokevirtual [26] 
L175:   istore 15 
L177:   aload_0 
L178:   iload 15 
L180:   invokeinterface [34] 0 
L185:   aload_1 
L186:   invokevirtual [27] 
L189:   istore 16 
L191:   aload_0 
L192:   iload 16 
L194:   invokeinterface [34] 0 
L199:   aload_1 
L200:   invokevirtual [28] 
L203:   istore 17 
L205:   aload_0 
L206:   iload 17 
L208:   invokeinterface [34] 0 
L213:   aload_1 
L214:   invokevirtual [29] 
L217:   astore 18 
L219:   aload_0 
L220:   aload 18 
L222:   invokestatic [3] 
L225:   return 
L226:   nop 
L227:   nop 
L228:   
    .end code 
.end method 

.method public static [303] : [304] 
    .attribute [298] .code stack 3 locals 2 
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
L24:    invokeinterface [34] 0 
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

.method public static [305] : [306] 
    .attribute [298] .code stack 3 locals 18 
L0:     aconst_null 
L1:     astore_1 
L2:     aload_0 
L3:     invokeinterface [36] 0 
L8:     istore_2 
L9:     iload_2 
L10:    ifne L225 
L13:    new [37] 
L16:    dup 
L17:    invokespecial [31] 
L20:    astore_1 
L21:    aload_0 
L22:    invokeinterface [38] 0 
L27:    lstore_3 
L28:    aload_1 
L29:    lload_3 
L30:    putfield [39] 
L33:    aload_0 
L34:    invokeinterface [40] 0 
L39:    istore 5 
L41:    aload_1 
L42:    iload 5 
L44:    putfield [41] 
L47:    aload_0 
L48:    invokeinterface [40] 0 
L53:    istore 6 
L55:    aload_1 
L56:    iload 6 
L58:    putfield [42] 
L61:    aload_0 
L62:    invokeinterface [43] 0 
L67:    astore 7 
L69:    aload_1 
L70:    aload 7 
L72:    putfield [44] 
L75:    aload_0 
L76:    invokeinterface [43] 0 
L81:    astore 8 
L83:    aload_1 
L84:    aload 8 
L86:    putfield [45] 
L89:    aload_0 
L90:    invokeinterface [40] 0 
L95:    istore 9 
L97:    aload_1 
L98:    iload 9 
L100:   putfield [46] 
L103:   aload_0 
L104:   invokeinterface [40] 0 
L109:   istore 10 
L111:   aload_1 
L112:   iload 10 
L114:   putfield [47] 
L117:   aload_0 
L118:   invokeinterface [40] 0 
L123:   istore 11 
L125:   aload_1 
L126:   iload 11 
L128:   putfield [48] 
L131:   aload_0 
L132:   invokeinterface [40] 0 
L137:   istore 12 
L139:   aload_1 
L140:   iload 12 
L142:   putfield [49] 
L145:   aload_0 
L146:   invokeinterface [40] 0 
L151:   istore 13 
L153:   aload_1 
L154:   iload 13 
L156:   putfield [50] 
L159:   aload_0 
L160:   invokestatic [6] 
L163:   astore 14 
L165:   aload_1 
L166:   aload 14 
L168:   putfield [51] 
L171:   aload_0 
L172:   invokeinterface [40] 0 
L177:   istore 15 
L179:   aload_1 
L180:   iload 15 
L182:   putfield [52] 
L185:   aload_0 
L186:   invokeinterface [40] 0 
L191:   istore 16 
L193:   aload_1 
L194:   iload 16 
L196:   putfield [53] 
L199:   aload_0 
L200:   invokeinterface [40] 0 
L205:   istore 17 
L207:   aload_1 
L208:   iload 17 
L210:   putfield [54] 
L213:   aload_0 
L214:   invokestatic [7] 
L217:   astore 18 
L219:   aload_1 
L220:   aload 18 
L222:   putfield [55] 
L225:   aload_1 
L226:   areturn 
L227:   nop 
L228:   
    .end code 
.end method 

.method public static [307] : [308] 
    .attribute [298] .code stack 3 locals 4 
L0:     aconst_null 
L1:     astore_1 
L2:     aload_0 
L3:     invokeinterface [36] 0 
L8:     istore_2 
L9:     iload_2 
L10:    ifne L48 
L13:    aload_0 
L14:    invokeinterface [40] 0 
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
.const [2] = Method [56] [57] 
.const [3] = Method [58] [59] 
.const [4] = Method [60] [61] 
.const [5] = Class [62] 
.const [6] = Method [63] [64] 
.const [7] = Method [65] [66] 
.const [8] = Method [67] [68] 
.const [9] = Class [69] 
.const [10] = Class [70] 
.const [11] = Class [71] 
.const [12] = Class [72] 
.const [13] = Class [73] 
.const [14] = Class [74] 
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
.const [27] = Method [99] [100] 
.const [28] = Method [101] [102] 
.const [29] = Method [103] [104] 
.const [30] = Method [105] [106] 
.const [31] = Method [107] [108] 
.const [32] = InterfaceMethod [109] [110] 
.const [33] = InterfaceMethod [111] [112] 
.const [34] = InterfaceMethod [113] [114] 
.const [35] = InterfaceMethod [115] [116] 
.const [36] = InterfaceMethod [117] [118] 
.const [37] = Class [119] 
.const [38] = InterfaceMethod [120] [121] 
.const [39] = Field [122] [123] 
.const [40] = InterfaceMethod [124] [125] 
.const [41] = Field [126] [127] 
.const [42] = Field [128] [129] 
.const [43] = InterfaceMethod [130] [131] 
.const [44] = Field [132] [133] 
.const [45] = Field [134] [135] 
.const [46] = Field [136] [137] 
.const [47] = Field [138] [139] 
.const [48] = Field [140] [141] 
.const [49] = Field [142] [143] 
.const [50] = Field [144] [145] 
.const [51] = Field [146] [147] 
.const [52] = Field [148] [149] 
.const [53] = Field [150] [151] 
.const [54] = Field [152] [153] 
.const [55] = Field [154] [155] 
.const [56] = Class [156] 
.const [57] = NameAndType [157] [158] 
.const [58] = Class [159] 
.const [59] = NameAndType [160] [161] 
.const [60] = Class [162] 
.const [61] = NameAndType [163] [164] 
.const [62] = Utf8 org/dsi/ifc/organizer/DataSet 
.const [63] = Class [165] 
.const [64] = NameAndType [166] [167] 
.const [65] = Class [168] 
.const [66] = NameAndType [169] [170] 
.const [67] = Class [171] 
.const [68] = NameAndType [172] [173] 
.const [69] = Utf8 de/esolutions/fw/comm/dsi/organizer/impl/DataSetSerializer 
.const [70] = Utf8 java/lang/Object 
.const [71] = Utf8 de/esolutions/fw/util/serializer/ISerializer 
.const [72] = Utf8 de/esolutions/fw/comm/dsi/global/impl/ResourceLocatorSerializer 
.const [73] = Utf8 de/esolutions/fw/comm/dsi/organizer/impl/HighlightSerializer 
.const [74] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [75] = Class [174] 
.const [76] = NameAndType [175] [176] 
.const [77] = Class [177] 
.const [78] = NameAndType [178] [179] 
.const [79] = Class [180] 
.const [80] = NameAndType [181] [182] 
.const [81] = Class [183] 
.const [82] = NameAndType [184] [185] 
.const [83] = Class [186] 
.const [84] = NameAndType [187] [188] 
.const [85] = Class [189] 
.const [86] = NameAndType [190] [191] 
.const [87] = Class [192] 
.const [88] = NameAndType [193] [194] 
.const [89] = Class [195] 
.const [90] = NameAndType [196] [197] 
.const [91] = Class [198] 
.const [92] = NameAndType [199] [200] 
.const [93] = Class [201] 
.const [94] = NameAndType [202] [203] 
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
.const [119] = Utf8 org/dsi/ifc/organizer/DataSet 
.const [120] = Class [240] 
.const [121] = NameAndType [241] [242] 
.const [122] = Class [243] 
.const [123] = NameAndType [244] [245] 
.const [124] = Class [246] 
.const [125] = NameAndType [247] [248] 
.const [126] = Class [249] 
.const [127] = NameAndType [250] [251] 
.const [128] = Class [252] 
.const [129] = NameAndType [253] [254] 
.const [130] = Class [255] 
.const [131] = NameAndType [256] [257] 
.const [132] = Class [258] 
.const [133] = NameAndType [259] [260] 
.const [134] = Class [261] 
.const [135] = NameAndType [262] [263] 
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
.const [156] = Utf8 de/esolutions/fw/comm/dsi/global/impl/ResourceLocatorSerializer 
.const [157] = Utf8 putOptionalResourceLocator 
.const [158] = Utf8 (Lde/esolutions/fw/util/serializer/ISerializer;Lorg/dsi/ifc/global/ResourceLocator;)V 
.const [159] = Utf8 de/esolutions/fw/comm/dsi/organizer/impl/HighlightSerializer 
.const [160] = Utf8 putOptionalHighlightVarArray 
.const [161] = Utf8 (Lde/esolutions/fw/util/serializer/ISerializer;[Lorg/dsi/ifc/organizer/Highlight;)V 
.const [162] = Utf8 de/esolutions/fw/comm/dsi/organizer/impl/DataSetSerializer 
.const [163] = Utf8 putOptionalDataSet 
.const [164] = Utf8 (Lde/esolutions/fw/util/serializer/ISerializer;Lorg/dsi/ifc/organizer/DataSet;)V 
.const [165] = Utf8 de/esolutions/fw/comm/dsi/global/impl/ResourceLocatorSerializer 
.const [166] = Utf8 getOptionalResourceLocator 
.const [167] = Utf8 (Lde/esolutions/fw/util/serializer/IDeserializer;)Lorg/dsi/ifc/global/ResourceLocator; 
.const [168] = Utf8 de/esolutions/fw/comm/dsi/organizer/impl/HighlightSerializer 
.const [169] = Utf8 getOptionalHighlightVarArray 
.const [170] = Utf8 (Lde/esolutions/fw/util/serializer/IDeserializer;)[Lorg/dsi/ifc/organizer/Highlight; 
.const [171] = Utf8 de/esolutions/fw/comm/dsi/organizer/impl/DataSetSerializer 
.const [172] = Utf8 getOptionalDataSet 
.const [173] = Utf8 (Lde/esolutions/fw/util/serializer/IDeserializer;)Lorg/dsi/ifc/organizer/DataSet; 
.const [174] = Utf8 org/dsi/ifc/organizer/DataSet 
.const [175] = Utf8 getEntryId 
.const [176] = Utf8 ()J 
.const [177] = Utf8 org/dsi/ifc/organizer/DataSet 
.const [178] = Utf8 getEntryPosition 
.const [179] = Utf8 ()I 
.const [180] = Utf8 org/dsi/ifc/organizer/DataSet 
.const [181] = Utf8 getEntryType 
.const [182] = Utf8 ()I 
.const [183] = Utf8 org/dsi/ifc/organizer/DataSet 
.const [184] = Utf8 getGeneralDescription1 
.const [185] = Utf8 ()Ljava/lang/String; 
.const [186] = Utf8 org/dsi/ifc/organizer/DataSet 
.const [187] = Utf8 getGeneralDescription2 
.const [188] = Utf8 ()Ljava/lang/String; 
.const [189] = Utf8 org/dsi/ifc/organizer/DataSet 
.const [190] = Utf8 getVoiceTagId 
.const [191] = Utf8 ()I 
.const [192] = Utf8 org/dsi/ifc/organizer/DataSet 
.const [193] = Utf8 getPhoneCount 
.const [194] = Utf8 ()I 
.const [195] = Utf8 org/dsi/ifc/organizer/DataSet 
.const [196] = Utf8 getProbNavigable 
.const [197] = Utf8 ()I 
.const [198] = Utf8 org/dsi/ifc/organizer/DataSet 
.const [199] = Utf8 getNavigable 
.const [200] = Utf8 ()I 
.const [201] = Utf8 org/dsi/ifc/organizer/DataSet 
.const [202] = Utf8 getTopDestination 
.const [203] = Utf8 ()I 
.const [204] = Utf8 org/dsi/ifc/organizer/DataSet 
.const [205] = Utf8 getContactPicture 
.const [206] = Utf8 ()Lorg/dsi/ifc/global/ResourceLocator; 
.const [207] = Utf8 org/dsi/ifc/organizer/DataSet 
.const [208] = Utf8 getWebAddressCount 
.const [209] = Utf8 ()I 
.const [210] = Utf8 org/dsi/ifc/organizer/DataSet 
.const [211] = Utf8 getEmailCount 
.const [212] = Utf8 ()I 
.const [213] = Utf8 org/dsi/ifc/organizer/DataSet 
.const [214] = Utf8 getNumberType 
.const [215] = Utf8 ()I 
.const [216] = Utf8 org/dsi/ifc/organizer/DataSet 
.const [217] = Utf8 getHighlight 
.const [218] = Utf8 ()[Lorg/dsi/ifc/organizer/Highlight; 
.const [219] = Utf8 java/lang/Object 
.const [220] = Utf8 <init> 
.const [221] = Utf8 ()V 
.const [222] = Utf8 org/dsi/ifc/organizer/DataSet 
.const [223] = Utf8 <init> 
.const [224] = Utf8 ()V 
.const [225] = Utf8 de/esolutions/fw/util/serializer/ISerializer 
.const [226] = Utf8 putBool 
.const [227] = Utf8 (Z)V 
.const [228] = Utf8 de/esolutions/fw/util/serializer/ISerializer 
.const [229] = Utf8 putInt64 
.const [230] = Utf8 (J)V 
.const [231] = Utf8 de/esolutions/fw/util/serializer/ISerializer 
.const [232] = Utf8 putInt32 
.const [233] = Utf8 (I)V 
.const [234] = Utf8 de/esolutions/fw/util/serializer/ISerializer 
.const [235] = Utf8 putOptionalString 
.const [236] = Utf8 (Ljava/lang/String;)V 
.const [237] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [238] = Utf8 getBool 
.const [239] = Utf8 ()Z 
.const [240] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [241] = Utf8 getInt64 
.const [242] = Utf8 ()J 
.const [243] = Utf8 org/dsi/ifc/organizer/DataSet 
.const [244] = Utf8 entryId 
.const [245] = Utf8 J 
.const [246] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [247] = Utf8 getInt32 
.const [248] = Utf8 ()I 
.const [249] = Utf8 org/dsi/ifc/organizer/DataSet 
.const [250] = Utf8 entryPosition 
.const [251] = Utf8 I 
.const [252] = Utf8 org/dsi/ifc/organizer/DataSet 
.const [253] = Utf8 entryType 
.const [254] = Utf8 I 
.const [255] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [256] = Utf8 getOptionalString 
.const [257] = Utf8 ()Ljava/lang/String; 
.const [258] = Utf8 org/dsi/ifc/organizer/DataSet 
.const [259] = Utf8 generalDescription1 
.const [260] = Utf8 Ljava/lang/String; 
.const [261] = Utf8 org/dsi/ifc/organizer/DataSet 
.const [262] = Utf8 generalDescription2 
.const [263] = Utf8 Ljava/lang/String; 
.const [264] = Utf8 org/dsi/ifc/organizer/DataSet 
.const [265] = Utf8 voiceTagId 
.const [266] = Utf8 I 
.const [267] = Utf8 org/dsi/ifc/organizer/DataSet 
.const [268] = Utf8 phoneCount 
.const [269] = Utf8 I 
.const [270] = Utf8 org/dsi/ifc/organizer/DataSet 
.const [271] = Utf8 probNavigable 
.const [272] = Utf8 I 
.const [273] = Utf8 org/dsi/ifc/organizer/DataSet 
.const [274] = Utf8 navigable 
.const [275] = Utf8 I 
.const [276] = Utf8 org/dsi/ifc/organizer/DataSet 
.const [277] = Utf8 topDestination 
.const [278] = Utf8 I 
.const [279] = Utf8 org/dsi/ifc/organizer/DataSet 
.const [280] = Utf8 contactPicture 
.const [281] = Utf8 Lorg/dsi/ifc/global/ResourceLocator; 
.const [282] = Utf8 org/dsi/ifc/organizer/DataSet 
.const [283] = Utf8 webAddressCount 
.const [284] = Utf8 I 
.const [285] = Utf8 org/dsi/ifc/organizer/DataSet 
.const [286] = Utf8 emailCount 
.const [287] = Utf8 I 
.const [288] = Utf8 org/dsi/ifc/organizer/DataSet 
.const [289] = Utf8 numberType 
.const [290] = Utf8 I 
.const [291] = Utf8 org/dsi/ifc/organizer/DataSet 
.const [292] = Utf8 highlight 
.const [293] = Utf8 [Lorg/dsi/ifc/organizer/Highlight; 
.const [294] = Utf8 de/esolutions/fw/comm/dsi/organizer/impl/DataSetSerializer 
.const [295] = Class [294] 
.const [296] = Utf8 java/lang/Object 
.const [297] = Class [296] 
.const [298] = Utf8 Code 
.const [299] = Utf8 <init> 
.const [300] = Utf8 ()V 
.const [301] = Utf8 putOptionalDataSet 
.const [302] = Utf8 (Lde/esolutions/fw/util/serializer/ISerializer;Lorg/dsi/ifc/organizer/DataSet;)V 
.const [303] = Utf8 putOptionalDataSetVarArray 
.const [304] = Utf8 (Lde/esolutions/fw/util/serializer/ISerializer;[Lorg/dsi/ifc/organizer/DataSet;)V 
.const [305] = Utf8 getOptionalDataSet 
.const [306] = Utf8 (Lde/esolutions/fw/util/serializer/IDeserializer;)Lorg/dsi/ifc/organizer/DataSet; 
.const [307] = Utf8 getOptionalDataSetVarArray 
.const [308] = Utf8 (Lde/esolutions/fw/util/serializer/IDeserializer;)[Lorg/dsi/ifc/organizer/DataSet; 
.end class 
