.version 50 0 
.class public super [357] 
.super [359] 

.method public annotation [361] : [362] 
    .attribute [360] .code stack 1 locals 0 
L0:     aload_0 
L1:     invokespecial [37] 
L4:     return 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public static [363] : [364] 
    .attribute [360] .code stack 3 locals 19 
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
L18:    ifne L245 
L21:    aload_1 
L22:    invokevirtual [20] 
L25:    istore_3 
L26:    aload_0 
L27:    iload_3 
L28:    invokeinterface [40] 0 
L33:    aload_1 
L34:    invokevirtual [21] 
L37:    astore 4 
L39:    aload_0 
L40:    aload 4 
L42:    invokeinterface [41] 0 
L47:    aload_1 
L48:    invokevirtual [22] 
L51:    istore 5 
L53:    aload_0 
L54:    iload 5 
L56:    invokeinterface [40] 0 
L61:    aload_1 
L62:    invokevirtual [23] 
L65:    astore 6 
L67:    aload_0 
L68:    aload 6 
L70:    invokestatic [2] 
L73:    aload_1 
L74:    invokevirtual [24] 
L77:    astore 7 
L79:    aload_0 
L80:    aload 7 
L82:    invokestatic [3] 
L85:    aload_1 
L86:    invokevirtual [25] 
L89:    astore 8 
L91:    aload_0 
L92:    aload 8 
L94:    invokestatic [3] 
L97:    aload_1 
L98:    invokevirtual [26] 
L101:   astore 9 
L103:   aload_0 
L104:   aload 9 
L106:   invokestatic [3] 
L109:   aload_1 
L110:   invokevirtual [27] 
L113:   astore 10 
L115:   aload_0 
L116:   aload 10 
L118:   invokeinterface [41] 0 
L123:   aload_1 
L124:   invokevirtual [28] 
L127:   lstore 11 
L129:   aload_0 
L130:   lload 11 
L132:   invokeinterface [42] 0 
L137:   aload_1 
L138:   invokevirtual [29] 
L141:   istore 13 
L143:   aload_0 
L144:   iload 13 
L146:   invokeinterface [40] 0 
L151:   aload_1 
L152:   invokevirtual [30] 
L155:   astore 14 
L157:   aload_0 
L158:   aload 14 
L160:   invokeinterface [41] 0 
L165:   aload_1 
L166:   invokevirtual [31] 
L169:   astore 15 
L171:   aload_0 
L172:   aload 15 
L174:   invokeinterface [41] 0 
L179:   aload_1 
L180:   invokevirtual [32] 
L183:   astore 16 
L185:   aload_0 
L186:   aload 16 
L188:   invokestatic [4] 
L191:   aload_1 
L192:   invokevirtual [33] 
L195:   istore 17 
L197:   aload_0 
L198:   iload 17 
L200:   invokeinterface [40] 0 
L205:   aload_1 
L206:   invokevirtual [34] 
L209:   astore 18 
L211:   aload_0 
L212:   aload 18 
L214:   invokeinterface [43] 0 
L219:   aload_1 
L220:   invokevirtual [35] 
L223:   istore 19 
L225:   aload_0 
L226:   iload 19 
L228:   invokeinterface [40] 0 
L233:   aload_1 
L234:   invokevirtual [36] 
L237:   astore 20 
L239:   aload_0 
L240:   aload 20 
L242:   invokestatic [5] 
L245:   return 
L246:   nop 
L247:   nop 
L248:   
    .end code 
.end method 

.method public static [365] : [366] 
    .attribute [360] .code stack 3 locals 2 
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
L24:    invokeinterface [40] 0 
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

.method public static [367] : [368] 
    .attribute [360] .code stack 3 locals 20 
L0:     aconst_null 
L1:     astore_1 
L2:     aload_0 
L3:     invokeinterface [44] 0 
L8:     istore_2 
L9:     iload_2 
L10:    ifne L245 
L13:    new [45] 
L16:    dup 
L17:    invokespecial [38] 
L20:    astore_1 
L21:    aload_0 
L22:    invokeinterface [46] 0 
L27:    istore_3 
L28:    aload_1 
L29:    iload_3 
L30:    putfield [47] 
L33:    aload_0 
L34:    invokeinterface [48] 0 
L39:    astore 4 
L41:    aload_1 
L42:    aload 4 
L44:    putfield [49] 
L47:    aload_0 
L48:    invokeinterface [46] 0 
L53:    istore 5 
L55:    aload_1 
L56:    iload 5 
L58:    putfield [50] 
L61:    aload_0 
L62:    invokestatic [8] 
L65:    astore 6 
L67:    aload_1 
L68:    aload 6 
L70:    putfield [51] 
L73:    aload_0 
L74:    invokestatic [9] 
L77:    astore 7 
L79:    aload_1 
L80:    aload 7 
L82:    putfield [52] 
L85:    aload_0 
L86:    invokestatic [9] 
L89:    astore 8 
L91:    aload_1 
L92:    aload 8 
L94:    putfield [53] 
L97:    aload_0 
L98:    invokestatic [9] 
L101:   astore 9 
L103:   aload_1 
L104:   aload 9 
L106:   putfield [54] 
L109:   aload_0 
L110:   invokeinterface [48] 0 
L115:   astore 10 
L117:   aload_1 
L118:   aload 10 
L120:   putfield [55] 
L123:   aload_0 
L124:   invokeinterface [56] 0 
L129:   lstore 11 
L131:   aload_1 
L132:   lload 11 
L134:   putfield [57] 
L137:   aload_0 
L138:   invokeinterface [46] 0 
L143:   istore 13 
L145:   aload_1 
L146:   iload 13 
L148:   putfield [58] 
L151:   aload_0 
L152:   invokeinterface [48] 0 
L157:   astore 14 
L159:   aload_1 
L160:   aload 14 
L162:   putfield [59] 
L165:   aload_0 
L166:   invokeinterface [48] 0 
L171:   astore 15 
L173:   aload_1 
L174:   aload 15 
L176:   putfield [60] 
L179:   aload_0 
L180:   invokestatic [10] 
L183:   astore 16 
L185:   aload_1 
L186:   aload 16 
L188:   putfield [61] 
L191:   aload_0 
L192:   invokeinterface [46] 0 
L197:   istore 17 
L199:   aload_1 
L200:   iload 17 
L202:   putfield [62] 
L205:   aload_0 
L206:   invokeinterface [63] 0 
L211:   astore 18 
L213:   aload_1 
L214:   aload 18 
L216:   putfield [64] 
L219:   aload_0 
L220:   invokeinterface [46] 0 
L225:   istore 19 
L227:   aload_1 
L228:   iload 19 
L230:   putfield [65] 
L233:   aload_0 
L234:   invokestatic [11] 
L237:   astore 20 
L239:   aload_1 
L240:   aload 20 
L242:   putfield [66] 
L245:   aload_1 
L246:   areturn 
L247:   nop 
L248:   
    .end code 
.end method 

.method public static [369] : [370] 
    .attribute [360] .code stack 3 locals 4 
L0:     aconst_null 
L1:     astore_1 
L2:     aload_0 
L3:     invokeinterface [44] 0 
L8:     istore_2 
L9:     iload_2 
L10:    ifne L48 
L13:    aload_0 
L14:    invokeinterface [46] 0 
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
.const [2] = Method [67] [68] 
.const [3] = Method [69] [70] 
.const [4] = Method [71] [72] 
.const [5] = Method [73] [74] 
.const [6] = Method [75] [76] 
.const [7] = Class [77] 
.const [8] = Method [78] [79] 
.const [9] = Method [80] [81] 
.const [10] = Method [82] [83] 
.const [11] = Method [84] [85] 
.const [12] = Method [86] [87] 
.const [13] = Class [88] 
.const [14] = Class [89] 
.const [15] = Class [90] 
.const [16] = Class [91] 
.const [17] = Class [92] 
.const [18] = Class [93] 
.const [19] = Class [94] 
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
.const [34] = Method [123] [124] 
.const [35] = Method [125] [126] 
.const [36] = Method [127] [128] 
.const [37] = Method [129] [130] 
.const [38] = Method [131] [132] 
.const [39] = InterfaceMethod [133] [134] 
.const [40] = InterfaceMethod [135] [136] 
.const [41] = InterfaceMethod [137] [138] 
.const [42] = InterfaceMethod [139] [140] 
.const [43] = InterfaceMethod [141] [142] 
.const [44] = InterfaceMethod [143] [144] 
.const [45] = Class [145] 
.const [46] = InterfaceMethod [146] [147] 
.const [47] = Field [148] [149] 
.const [48] = InterfaceMethod [150] [151] 
.const [49] = Field [152] [153] 
.const [50] = Field [154] [155] 
.const [51] = Field [156] [157] 
.const [52] = Field [158] [159] 
.const [53] = Field [160] [161] 
.const [54] = Field [162] [163] 
.const [55] = Field [164] [165] 
.const [56] = InterfaceMethod [166] [167] 
.const [57] = Field [168] [169] 
.const [58] = Field [170] [171] 
.const [59] = Field [172] [173] 
.const [60] = Field [174] [175] 
.const [61] = Field [176] [177] 
.const [62] = Field [178] [179] 
.const [63] = InterfaceMethod [180] [181] 
.const [64] = Field [182] [183] 
.const [65] = Field [184] [185] 
.const [66] = Field [186] [187] 
.const [67] = Class [188] 
.const [68] = NameAndType [189] [190] 
.const [69] = Class [191] 
.const [70] = NameAndType [192] [193] 
.const [71] = Class [194] 
.const [72] = NameAndType [195] [196] 
.const [73] = Class [197] 
.const [74] = NameAndType [198] [199] 
.const [75] = Class [200] 
.const [76] = NameAndType [201] [202] 
.const [77] = Utf8 org/dsi/ifc/messaging/MessageDetails 
.const [78] = Class [203] 
.const [79] = NameAndType [204] [205] 
.const [80] = Class [206] 
.const [81] = NameAndType [207] [208] 
.const [82] = Class [209] 
.const [83] = NameAndType [210] [211] 
.const [84] = Class [212] 
.const [85] = NameAndType [213] [214] 
.const [86] = Class [215] 
.const [87] = NameAndType [216] [217] 
.const [88] = Utf8 de/esolutions/fw/comm/dsi/messaging/impl/MessageDetailsSerializer 
.const [89] = Utf8 java/lang/Object 
.const [90] = Utf8 de/esolutions/fw/util/serializer/ISerializer 
.const [91] = Utf8 de/esolutions/fw/comm/dsi/messaging/impl/MatchedAddressSerializer 
.const [92] = Utf8 de/esolutions/fw/comm/dsi/messaging/impl/AttachmentInformationSerializer 
.const [93] = Utf8 de/esolutions/fw/comm/dsi/messaging/impl/ExtractedItemSerializer 
.const [94] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [95] = Class [218] 
.const [96] = NameAndType [219] [220] 
.const [97] = Class [221] 
.const [98] = NameAndType [222] [223] 
.const [99] = Class [224] 
.const [100] = NameAndType [225] [226] 
.const [101] = Class [227] 
.const [102] = NameAndType [228] [229] 
.const [103] = Class [230] 
.const [104] = NameAndType [231] [232] 
.const [105] = Class [233] 
.const [106] = NameAndType [234] [235] 
.const [107] = Class [236] 
.const [108] = NameAndType [237] [238] 
.const [109] = Class [239] 
.const [110] = NameAndType [240] [241] 
.const [111] = Class [242] 
.const [112] = NameAndType [243] [244] 
.const [113] = Class [245] 
.const [114] = NameAndType [246] [247] 
.const [115] = Class [248] 
.const [116] = NameAndType [249] [250] 
.const [117] = Class [251] 
.const [118] = NameAndType [252] [253] 
.const [119] = Class [254] 
.const [120] = NameAndType [255] [256] 
.const [121] = Class [257] 
.const [122] = NameAndType [258] [259] 
.const [123] = Class [260] 
.const [124] = NameAndType [261] [262] 
.const [125] = Class [263] 
.const [126] = NameAndType [264] [265] 
.const [127] = Class [266] 
.const [128] = NameAndType [267] [268] 
.const [129] = Class [269] 
.const [130] = NameAndType [270] [271] 
.const [131] = Class [272] 
.const [132] = NameAndType [273] [274] 
.const [133] = Class [275] 
.const [134] = NameAndType [276] [277] 
.const [135] = Class [278] 
.const [136] = NameAndType [279] [280] 
.const [137] = Class [281] 
.const [138] = NameAndType [282] [283] 
.const [139] = Class [284] 
.const [140] = NameAndType [285] [286] 
.const [141] = Class [287] 
.const [142] = NameAndType [288] [289] 
.const [143] = Class [290] 
.const [144] = NameAndType [291] [292] 
.const [145] = Utf8 org/dsi/ifc/messaging/MessageDetails 
.const [146] = Class [293] 
.const [147] = NameAndType [294] [295] 
.const [148] = Class [296] 
.const [149] = NameAndType [297] [298] 
.const [150] = Class [299] 
.const [151] = NameAndType [300] [301] 
.const [152] = Class [302] 
.const [153] = NameAndType [303] [304] 
.const [154] = Class [305] 
.const [155] = NameAndType [306] [307] 
.const [156] = Class [308] 
.const [157] = NameAndType [309] [310] 
.const [158] = Class [311] 
.const [159] = NameAndType [312] [313] 
.const [160] = Class [314] 
.const [161] = NameAndType [315] [316] 
.const [162] = Class [317] 
.const [163] = NameAndType [318] [319] 
.const [164] = Class [320] 
.const [165] = NameAndType [321] [322] 
.const [166] = Class [323] 
.const [167] = NameAndType [324] [325] 
.const [168] = Class [326] 
.const [169] = NameAndType [327] [328] 
.const [170] = Class [329] 
.const [171] = NameAndType [330] [331] 
.const [172] = Class [332] 
.const [173] = NameAndType [333] [334] 
.const [174] = Class [335] 
.const [175] = NameAndType [336] [337] 
.const [176] = Class [338] 
.const [177] = NameAndType [339] [340] 
.const [178] = Class [341] 
.const [179] = NameAndType [342] [343] 
.const [180] = Class [344] 
.const [181] = NameAndType [345] [346] 
.const [182] = Class [347] 
.const [183] = NameAndType [348] [349] 
.const [184] = Class [350] 
.const [185] = NameAndType [351] [352] 
.const [186] = Class [353] 
.const [187] = NameAndType [354] [355] 
.const [188] = Utf8 de/esolutions/fw/comm/dsi/messaging/impl/MatchedAddressSerializer 
.const [189] = Utf8 putOptionalMatchedAddress 
.const [190] = Utf8 (Lde/esolutions/fw/util/serializer/ISerializer;Lorg/dsi/ifc/messaging/MatchedAddress;)V 
.const [191] = Utf8 de/esolutions/fw/comm/dsi/messaging/impl/MatchedAddressSerializer 
.const [192] = Utf8 putOptionalMatchedAddressVarArray 
.const [193] = Utf8 (Lde/esolutions/fw/util/serializer/ISerializer;[Lorg/dsi/ifc/messaging/MatchedAddress;)V 
.const [194] = Utf8 de/esolutions/fw/comm/dsi/messaging/impl/AttachmentInformationSerializer 
.const [195] = Utf8 putOptionalAttachmentInformationVarArray 
.const [196] = Utf8 (Lde/esolutions/fw/util/serializer/ISerializer;[Lorg/dsi/ifc/messaging/AttachmentInformation;)V 
.const [197] = Utf8 de/esolutions/fw/comm/dsi/messaging/impl/ExtractedItemSerializer 
.const [198] = Utf8 putOptionalExtractedItemVarArray 
.const [199] = Utf8 (Lde/esolutions/fw/util/serializer/ISerializer;[Lorg/dsi/ifc/messaging/ExtractedItem;)V 
.const [200] = Utf8 de/esolutions/fw/comm/dsi/messaging/impl/MessageDetailsSerializer 
.const [201] = Utf8 putOptionalMessageDetails 
.const [202] = Utf8 (Lde/esolutions/fw/util/serializer/ISerializer;Lorg/dsi/ifc/messaging/MessageDetails;)V 
.const [203] = Utf8 de/esolutions/fw/comm/dsi/messaging/impl/MatchedAddressSerializer 
.const [204] = Utf8 getOptionalMatchedAddress 
.const [205] = Utf8 (Lde/esolutions/fw/util/serializer/IDeserializer;)Lorg/dsi/ifc/messaging/MatchedAddress; 
.const [206] = Utf8 de/esolutions/fw/comm/dsi/messaging/impl/MatchedAddressSerializer 
.const [207] = Utf8 getOptionalMatchedAddressVarArray 
.const [208] = Utf8 (Lde/esolutions/fw/util/serializer/IDeserializer;)[Lorg/dsi/ifc/messaging/MatchedAddress; 
.const [209] = Utf8 de/esolutions/fw/comm/dsi/messaging/impl/AttachmentInformationSerializer 
.const [210] = Utf8 getOptionalAttachmentInformationVarArray 
.const [211] = Utf8 (Lde/esolutions/fw/util/serializer/IDeserializer;)[Lorg/dsi/ifc/messaging/AttachmentInformation; 
.const [212] = Utf8 de/esolutions/fw/comm/dsi/messaging/impl/ExtractedItemSerializer 
.const [213] = Utf8 getOptionalExtractedItemVarArray 
.const [214] = Utf8 (Lde/esolutions/fw/util/serializer/IDeserializer;)[Lorg/dsi/ifc/messaging/ExtractedItem; 
.const [215] = Utf8 de/esolutions/fw/comm/dsi/messaging/impl/MessageDetailsSerializer 
.const [216] = Utf8 getOptionalMessageDetails 
.const [217] = Utf8 (Lde/esolutions/fw/util/serializer/IDeserializer;)Lorg/dsi/ifc/messaging/MessageDetails; 
.const [218] = Utf8 org/dsi/ifc/messaging/MessageDetails 
.const [219] = Utf8 getMessagingAccountID 
.const [220] = Utf8 ()I 
.const [221] = Utf8 org/dsi/ifc/messaging/MessageDetails 
.const [222] = Utf8 getMessageID 
.const [223] = Utf8 ()Ljava/lang/String; 
.const [224] = Utf8 org/dsi/ifc/messaging/MessageDetails 
.const [225] = Utf8 getType 
.const [226] = Utf8 ()I 
.const [227] = Utf8 org/dsi/ifc/messaging/MessageDetails 
.const [228] = Utf8 getSender 
.const [229] = Utf8 ()Lorg/dsi/ifc/messaging/MatchedAddress; 
.const [230] = Utf8 org/dsi/ifc/messaging/MessageDetails 
.const [231] = Utf8 getRecipientsTo 
.const [232] = Utf8 ()[Lorg/dsi/ifc/messaging/MatchedAddress; 
.const [233] = Utf8 org/dsi/ifc/messaging/MessageDetails 
.const [234] = Utf8 getRecipientsCc 
.const [235] = Utf8 ()[Lorg/dsi/ifc/messaging/MatchedAddress; 
.const [236] = Utf8 org/dsi/ifc/messaging/MessageDetails 
.const [237] = Utf8 getRecipientsBcc 
.const [238] = Utf8 ()[Lorg/dsi/ifc/messaging/MatchedAddress; 
.const [239] = Utf8 org/dsi/ifc/messaging/MessageDetails 
.const [240] = Utf8 getSubject 
.const [241] = Utf8 ()Ljava/lang/String; 
.const [242] = Utf8 org/dsi/ifc/messaging/MessageDetails 
.const [243] = Utf8 getDateTime 
.const [244] = Utf8 ()J 
.const [245] = Utf8 org/dsi/ifc/messaging/MessageDetails 
.const [246] = Utf8 getMessageStatus 
.const [247] = Utf8 ()I 
.const [248] = Utf8 org/dsi/ifc/messaging/MessageDetails 
.const [249] = Utf8 getReplyTo 
.const [250] = Utf8 ()Ljava/lang/String; 
.const [251] = Utf8 org/dsi/ifc/messaging/MessageDetails 
.const [252] = Utf8 getBody 
.const [253] = Utf8 ()Ljava/lang/String; 
.const [254] = Utf8 org/dsi/ifc/messaging/MessageDetails 
.const [255] = Utf8 getAttachments 
.const [256] = Utf8 ()[Lorg/dsi/ifc/messaging/AttachmentInformation; 
.const [257] = Utf8 org/dsi/ifc/messaging/MessageDetails 
.const [258] = Utf8 getPriority 
.const [259] = Utf8 ()I 
.const [260] = Utf8 org/dsi/ifc/messaging/MessageDetails 
.const [261] = Utf8 getSegmentLengths 
.const [262] = Utf8 ()[I 
.const [263] = Utf8 org/dsi/ifc/messaging/MessageDetails 
.const [264] = Utf8 getStorageLocation 
.const [265] = Utf8 ()I 
.const [266] = Utf8 org/dsi/ifc/messaging/MessageDetails 
.const [267] = Utf8 getExtractedItems 
.const [268] = Utf8 ()[Lorg/dsi/ifc/messaging/ExtractedItem; 
.const [269] = Utf8 java/lang/Object 
.const [270] = Utf8 <init> 
.const [271] = Utf8 ()V 
.const [272] = Utf8 org/dsi/ifc/messaging/MessageDetails 
.const [273] = Utf8 <init> 
.const [274] = Utf8 ()V 
.const [275] = Utf8 de/esolutions/fw/util/serializer/ISerializer 
.const [276] = Utf8 putBool 
.const [277] = Utf8 (Z)V 
.const [278] = Utf8 de/esolutions/fw/util/serializer/ISerializer 
.const [279] = Utf8 putInt32 
.const [280] = Utf8 (I)V 
.const [281] = Utf8 de/esolutions/fw/util/serializer/ISerializer 
.const [282] = Utf8 putOptionalString 
.const [283] = Utf8 (Ljava/lang/String;)V 
.const [284] = Utf8 de/esolutions/fw/util/serializer/ISerializer 
.const [285] = Utf8 putInt64 
.const [286] = Utf8 (J)V 
.const [287] = Utf8 de/esolutions/fw/util/serializer/ISerializer 
.const [288] = Utf8 putOptionalInt32VarArray 
.const [289] = Utf8 ([I)V 
.const [290] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [291] = Utf8 getBool 
.const [292] = Utf8 ()Z 
.const [293] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [294] = Utf8 getInt32 
.const [295] = Utf8 ()I 
.const [296] = Utf8 org/dsi/ifc/messaging/MessageDetails 
.const [297] = Utf8 messagingAccountID 
.const [298] = Utf8 I 
.const [299] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [300] = Utf8 getOptionalString 
.const [301] = Utf8 ()Ljava/lang/String; 
.const [302] = Utf8 org/dsi/ifc/messaging/MessageDetails 
.const [303] = Utf8 messageID 
.const [304] = Utf8 Ljava/lang/String; 
.const [305] = Utf8 org/dsi/ifc/messaging/MessageDetails 
.const [306] = Utf8 type 
.const [307] = Utf8 I 
.const [308] = Utf8 org/dsi/ifc/messaging/MessageDetails 
.const [309] = Utf8 sender 
.const [310] = Utf8 Lorg/dsi/ifc/messaging/MatchedAddress; 
.const [311] = Utf8 org/dsi/ifc/messaging/MessageDetails 
.const [312] = Utf8 recipientsTo 
.const [313] = Utf8 [Lorg/dsi/ifc/messaging/MatchedAddress; 
.const [314] = Utf8 org/dsi/ifc/messaging/MessageDetails 
.const [315] = Utf8 recipientsCc 
.const [316] = Utf8 [Lorg/dsi/ifc/messaging/MatchedAddress; 
.const [317] = Utf8 org/dsi/ifc/messaging/MessageDetails 
.const [318] = Utf8 recipientsBcc 
.const [319] = Utf8 [Lorg/dsi/ifc/messaging/MatchedAddress; 
.const [320] = Utf8 org/dsi/ifc/messaging/MessageDetails 
.const [321] = Utf8 subject 
.const [322] = Utf8 Ljava/lang/String; 
.const [323] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [324] = Utf8 getInt64 
.const [325] = Utf8 ()J 
.const [326] = Utf8 org/dsi/ifc/messaging/MessageDetails 
.const [327] = Utf8 dateTime 
.const [328] = Utf8 J 
.const [329] = Utf8 org/dsi/ifc/messaging/MessageDetails 
.const [330] = Utf8 messageStatus 
.const [331] = Utf8 I 
.const [332] = Utf8 org/dsi/ifc/messaging/MessageDetails 
.const [333] = Utf8 replyTo 
.const [334] = Utf8 Ljava/lang/String; 
.const [335] = Utf8 org/dsi/ifc/messaging/MessageDetails 
.const [336] = Utf8 body 
.const [337] = Utf8 Ljava/lang/String; 
.const [338] = Utf8 org/dsi/ifc/messaging/MessageDetails 
.const [339] = Utf8 attachments 
.const [340] = Utf8 [Lorg/dsi/ifc/messaging/AttachmentInformation; 
.const [341] = Utf8 org/dsi/ifc/messaging/MessageDetails 
.const [342] = Utf8 priority 
.const [343] = Utf8 I 
.const [344] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [345] = Utf8 getOptionalInt32VarArray 
.const [346] = Utf8 ()[I 
.const [347] = Utf8 org/dsi/ifc/messaging/MessageDetails 
.const [348] = Utf8 segmentLengths 
.const [349] = Utf8 [I 
.const [350] = Utf8 org/dsi/ifc/messaging/MessageDetails 
.const [351] = Utf8 storageLocation 
.const [352] = Utf8 I 
.const [353] = Utf8 org/dsi/ifc/messaging/MessageDetails 
.const [354] = Utf8 extractedItems 
.const [355] = Utf8 [Lorg/dsi/ifc/messaging/ExtractedItem; 
.const [356] = Utf8 de/esolutions/fw/comm/dsi/messaging/impl/MessageDetailsSerializer 
.const [357] = Class [356] 
.const [358] = Utf8 java/lang/Object 
.const [359] = Class [358] 
.const [360] = Utf8 Code 
.const [361] = Utf8 <init> 
.const [362] = Utf8 ()V 
.const [363] = Utf8 putOptionalMessageDetails 
.const [364] = Utf8 (Lde/esolutions/fw/util/serializer/ISerializer;Lorg/dsi/ifc/messaging/MessageDetails;)V 
.const [365] = Utf8 putOptionalMessageDetailsVarArray 
.const [366] = Utf8 (Lde/esolutions/fw/util/serializer/ISerializer;[Lorg/dsi/ifc/messaging/MessageDetails;)V 
.const [367] = Utf8 getOptionalMessageDetails 
.const [368] = Utf8 (Lde/esolutions/fw/util/serializer/IDeserializer;)Lorg/dsi/ifc/messaging/MessageDetails; 
.const [369] = Utf8 getOptionalMessageDetailsVarArray 
.const [370] = Utf8 (Lde/esolutions/fw/util/serializer/IDeserializer;)[Lorg/dsi/ifc/messaging/MessageDetails; 
.end class 
