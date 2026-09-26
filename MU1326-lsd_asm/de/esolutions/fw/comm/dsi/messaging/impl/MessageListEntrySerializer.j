.version 50 0 
.class public super [257] 
.super [259] 

.method public annotation [261] : [262] 
    .attribute [260] .code stack 1 locals 0 
L0:     aload_0 
L1:     invokespecial [24] 
L4:     return 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public static [263] : [264] 
    .attribute [260] .code stack 3 locals 14 
L0:     aload_1 
L1:     ifnonnull L8 
L4:     iconst_1 
L5:     goto L9 
L8:     iconst_0 
L9:     istore_2 
L10:    aload_0 
L11:    iload_2 
L12:    invokeinterface [26] 0 
L17:    iload_2 
L18:    ifne L185 
L21:    aload_1 
L22:    invokevirtual [12] 
L25:    astore_3 
L26:    aload_0 
L27:    aload_3 
L28:    invokestatic [2] 
L31:    aload_1 
L32:    invokevirtual [13] 
L35:    astore 4 
L37:    aload_0 
L38:    aload 4 
L40:    invokeinterface [27] 0 
L45:    aload_1 
L46:    invokevirtual [14] 
L49:    istore 5 
L51:    aload_0 
L52:    iload 5 
L54:    invokeinterface [28] 0 
L59:    aload_1 
L60:    invokevirtual [15] 
L63:    astore 6 
L65:    aload_0 
L66:    aload 6 
L68:    invokeinterface [27] 0 
L73:    aload_1 
L74:    invokevirtual [16] 
L77:    astore 7 
L79:    aload_0 
L80:    aload 7 
L82:    invokeinterface [29] 0 
L87:    aload_1 
L88:    invokevirtual [17] 
L91:    lstore 8 
L93:    aload_0 
L94:    lload 8 
L96:    invokeinterface [30] 0 
L101:   aload_1 
L102:   invokevirtual [18] 
L105:   istore 10 
L107:   aload_0 
L108:   iload 10 
L110:   invokeinterface [28] 0 
L115:   aload_1 
L116:   invokevirtual [19] 
L119:   astore 11 
L121:   aload_0 
L122:   aload 11 
L124:   invokeinterface [27] 0 
L129:   aload_1 
L130:   invokevirtual [20] 
L133:   istore 12 
L135:   aload_0 
L136:   iload 12 
L138:   invokeinterface [28] 0 
L143:   aload_1 
L144:   invokevirtual [21] 
L147:   istore 13 
L149:   aload_0 
L150:   iload 13 
L152:   invokeinterface [28] 0 
L157:   aload_1 
L158:   invokevirtual [22] 
L161:   istore 14 
L163:   aload_0 
L164:   iload 14 
L166:   invokeinterface [28] 0 
L171:   aload_1 
L172:   invokevirtual [23] 
L175:   istore 15 
L177:   aload_0 
L178:   iload 15 
L180:   invokeinterface [28] 0 
L185:   return 
L186:   nop 
L187:   nop 
L188:   
    .end code 
.end method 

.method public static [265] : [266] 
    .attribute [260] .code stack 3 locals 2 
L0:     aload_1 
L1:     ifnonnull L8 
L4:     iconst_1 
L5:     goto L9 
L8:     iconst_0 
L9:     istore_2 
L10:    aload_0 
L11:    iload_2 
L12:    invokeinterface [26] 0 
L17:    iload_2 
L18:    ifne L50 
L21:    aload_0 
L22:    aload_1 
L23:    arraylength 
L24:    invokeinterface [28] 0 
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

.method public static [267] : [268] 
    .attribute [260] .code stack 3 locals 15 
L0:     aconst_null 
L1:     astore_1 
L2:     aload_0 
L3:     invokeinterface [31] 0 
L8:     istore_2 
L9:     iload_2 
L10:    ifne L185 
L13:    new [32] 
L16:    dup 
L17:    invokespecial [25] 
L20:    astore_1 
L21:    aload_0 
L22:    invokestatic [5] 
L25:    astore_3 
L26:    aload_1 
L27:    aload_3 
L28:    putfield [33] 
L31:    aload_0 
L32:    invokeinterface [34] 0 
L37:    astore 4 
L39:    aload_1 
L40:    aload 4 
L42:    putfield [35] 
L45:    aload_0 
L46:    invokeinterface [36] 0 
L51:    istore 5 
L53:    aload_1 
L54:    iload 5 
L56:    putfield [37] 
L59:    aload_0 
L60:    invokeinterface [34] 0 
L65:    astore 6 
L67:    aload_1 
L68:    aload 6 
L70:    putfield [38] 
L73:    aload_0 
L74:    invokeinterface [39] 0 
L79:    astore 7 
L81:    aload_1 
L82:    aload 7 
L84:    putfield [40] 
L87:    aload_0 
L88:    invokeinterface [41] 0 
L93:    lstore 8 
L95:    aload_1 
L96:    lload 8 
L98:    putfield [42] 
L101:   aload_0 
L102:   invokeinterface [36] 0 
L107:   istore 10 
L109:   aload_1 
L110:   iload 10 
L112:   putfield [43] 
L115:   aload_0 
L116:   invokeinterface [34] 0 
L121:   astore 11 
L123:   aload_1 
L124:   aload 11 
L126:   putfield [44] 
L129:   aload_0 
L130:   invokeinterface [36] 0 
L135:   istore 12 
L137:   aload_1 
L138:   iload 12 
L140:   putfield [45] 
L143:   aload_0 
L144:   invokeinterface [36] 0 
L149:   istore 13 
L151:   aload_1 
L152:   iload 13 
L154:   putfield [46] 
L157:   aload_0 
L158:   invokeinterface [36] 0 
L163:   istore 14 
L165:   aload_1 
L166:   iload 14 
L168:   putfield [47] 
L171:   aload_0 
L172:   invokeinterface [36] 0 
L177:   istore 15 
L179:   aload_1 
L180:   iload 15 
L182:   putfield [48] 
L185:   aload_1 
L186:   areturn 
L187:   nop 
L188:   
    .end code 
.end method 

.method public static [269] : [270] 
    .attribute [260] .code stack 3 locals 4 
L0:     aconst_null 
L1:     astore_1 
L2:     aload_0 
L3:     invokeinterface [31] 0 
L8:     istore_2 
L9:     iload_2 
L10:    ifne L48 
L13:    aload_0 
L14:    invokeinterface [36] 0 
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
.const [2] = Method [49] [50] 
.const [3] = Method [51] [52] 
.const [4] = Class [53] 
.const [5] = Method [54] [55] 
.const [6] = Method [56] [57] 
.const [7] = Class [58] 
.const [8] = Class [59] 
.const [9] = Class [60] 
.const [10] = Class [61] 
.const [11] = Class [62] 
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
.const [25] = Method [89] [90] 
.const [26] = InterfaceMethod [91] [92] 
.const [27] = InterfaceMethod [93] [94] 
.const [28] = InterfaceMethod [95] [96] 
.const [29] = InterfaceMethod [97] [98] 
.const [30] = InterfaceMethod [99] [100] 
.const [31] = InterfaceMethod [101] [102] 
.const [32] = Class [103] 
.const [33] = Field [104] [105] 
.const [34] = InterfaceMethod [106] [107] 
.const [35] = Field [108] [109] 
.const [36] = InterfaceMethod [110] [111] 
.const [37] = Field [112] [113] 
.const [38] = Field [114] [115] 
.const [39] = InterfaceMethod [116] [117] 
.const [40] = Field [118] [119] 
.const [41] = InterfaceMethod [120] [121] 
.const [42] = Field [122] [123] 
.const [43] = Field [124] [125] 
.const [44] = Field [126] [127] 
.const [45] = Field [128] [129] 
.const [46] = Field [130] [131] 
.const [47] = Field [132] [133] 
.const [48] = Field [134] [135] 
.const [49] = Class [136] 
.const [50] = NameAndType [137] [138] 
.const [51] = Class [139] 
.const [52] = NameAndType [140] [141] 
.const [53] = Utf8 org/dsi/ifc/messaging/MessageListEntry 
.const [54] = Class [142] 
.const [55] = NameAndType [143] [144] 
.const [56] = Class [145] 
.const [57] = NameAndType [146] [147] 
.const [58] = Utf8 de/esolutions/fw/comm/dsi/messaging/impl/MessageListEntrySerializer 
.const [59] = Utf8 java/lang/Object 
.const [60] = Utf8 de/esolutions/fw/util/serializer/ISerializer 
.const [61] = Utf8 de/esolutions/fw/comm/dsi/messaging/impl/MatchedAddressSerializer 
.const [62] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [63] = Class [148] 
.const [64] = NameAndType [149] [150] 
.const [65] = Class [151] 
.const [66] = NameAndType [152] [153] 
.const [67] = Class [154] 
.const [68] = NameAndType [155] [156] 
.const [69] = Class [157] 
.const [70] = NameAndType [158] [159] 
.const [71] = Class [160] 
.const [72] = NameAndType [161] [162] 
.const [73] = Class [163] 
.const [74] = NameAndType [164] [165] 
.const [75] = Class [166] 
.const [76] = NameAndType [167] [168] 
.const [77] = Class [169] 
.const [78] = NameAndType [170] [171] 
.const [79] = Class [172] 
.const [80] = NameAndType [173] [174] 
.const [81] = Class [175] 
.const [82] = NameAndType [176] [177] 
.const [83] = Class [178] 
.const [84] = NameAndType [179] [180] 
.const [85] = Class [181] 
.const [86] = NameAndType [182] [183] 
.const [87] = Class [184] 
.const [88] = NameAndType [185] [186] 
.const [89] = Class [187] 
.const [90] = NameAndType [188] [189] 
.const [91] = Class [190] 
.const [92] = NameAndType [191] [192] 
.const [93] = Class [193] 
.const [94] = NameAndType [194] [195] 
.const [95] = Class [196] 
.const [96] = NameAndType [197] [198] 
.const [97] = Class [199] 
.const [98] = NameAndType [200] [201] 
.const [99] = Class [202] 
.const [100] = NameAndType [203] [204] 
.const [101] = Class [205] 
.const [102] = NameAndType [206] [207] 
.const [103] = Utf8 org/dsi/ifc/messaging/MessageListEntry 
.const [104] = Class [208] 
.const [105] = NameAndType [209] [210] 
.const [106] = Class [211] 
.const [107] = NameAndType [212] [213] 
.const [108] = Class [214] 
.const [109] = NameAndType [215] [216] 
.const [110] = Class [217] 
.const [111] = NameAndType [218] [219] 
.const [112] = Class [220] 
.const [113] = NameAndType [221] [222] 
.const [114] = Class [223] 
.const [115] = NameAndType [224] [225] 
.const [116] = Class [226] 
.const [117] = NameAndType [227] [228] 
.const [118] = Class [229] 
.const [119] = NameAndType [230] [231] 
.const [120] = Class [232] 
.const [121] = NameAndType [233] [234] 
.const [122] = Class [235] 
.const [123] = NameAndType [236] [237] 
.const [124] = Class [238] 
.const [125] = NameAndType [239] [240] 
.const [126] = Class [241] 
.const [127] = NameAndType [242] [243] 
.const [128] = Class [244] 
.const [129] = NameAndType [245] [246] 
.const [130] = Class [247] 
.const [131] = NameAndType [248] [249] 
.const [132] = Class [250] 
.const [133] = NameAndType [251] [252] 
.const [134] = Class [253] 
.const [135] = NameAndType [254] [255] 
.const [136] = Utf8 de/esolutions/fw/comm/dsi/messaging/impl/MatchedAddressSerializer 
.const [137] = Utf8 putOptionalMatchedAddress 
.const [138] = Utf8 (Lde/esolutions/fw/util/serializer/ISerializer;Lorg/dsi/ifc/messaging/MatchedAddress;)V 
.const [139] = Utf8 de/esolutions/fw/comm/dsi/messaging/impl/MessageListEntrySerializer 
.const [140] = Utf8 putOptionalMessageListEntry 
.const [141] = Utf8 (Lde/esolutions/fw/util/serializer/ISerializer;Lorg/dsi/ifc/messaging/MessageListEntry;)V 
.const [142] = Utf8 de/esolutions/fw/comm/dsi/messaging/impl/MatchedAddressSerializer 
.const [143] = Utf8 getOptionalMatchedAddress 
.const [144] = Utf8 (Lde/esolutions/fw/util/serializer/IDeserializer;)Lorg/dsi/ifc/messaging/MatchedAddress; 
.const [145] = Utf8 de/esolutions/fw/comm/dsi/messaging/impl/MessageListEntrySerializer 
.const [146] = Utf8 getOptionalMessageListEntry 
.const [147] = Utf8 (Lde/esolutions/fw/util/serializer/IDeserializer;)Lorg/dsi/ifc/messaging/MessageListEntry; 
.const [148] = Utf8 org/dsi/ifc/messaging/MessageListEntry 
.const [149] = Utf8 getMatchedAddress 
.const [150] = Utf8 ()Lorg/dsi/ifc/messaging/MatchedAddress; 
.const [151] = Utf8 org/dsi/ifc/messaging/MessageListEntry 
.const [152] = Utf8 getMessageID 
.const [153] = Utf8 ()Ljava/lang/String; 
.const [154] = Utf8 org/dsi/ifc/messaging/MessageListEntry 
.const [155] = Utf8 getMessagingAccountID 
.const [156] = Utf8 ()I 
.const [157] = Utf8 org/dsi/ifc/messaging/MessageListEntry 
.const [158] = Utf8 getSender 
.const [159] = Utf8 ()Ljava/lang/String; 
.const [160] = Utf8 org/dsi/ifc/messaging/MessageListEntry 
.const [161] = Utf8 getRecipients 
.const [162] = Utf8 ()[Ljava/lang/String; 
.const [163] = Utf8 org/dsi/ifc/messaging/MessageListEntry 
.const [164] = Utf8 getDateTime 
.const [165] = Utf8 ()J 
.const [166] = Utf8 org/dsi/ifc/messaging/MessageListEntry 
.const [167] = Utf8 getMessageStatus 
.const [168] = Utf8 ()I 
.const [169] = Utf8 org/dsi/ifc/messaging/MessageListEntry 
.const [170] = Utf8 getSubject 
.const [171] = Utf8 ()Ljava/lang/String; 
.const [172] = Utf8 org/dsi/ifc/messaging/MessageListEntry 
.const [173] = Utf8 getAttachmentSize 
.const [174] = Utf8 ()I 
.const [175] = Utf8 org/dsi/ifc/messaging/MessageListEntry 
.const [176] = Utf8 getPriority 
.const [177] = Utf8 ()I 
.const [178] = Utf8 org/dsi/ifc/messaging/MessageListEntry 
.const [179] = Utf8 getType 
.const [180] = Utf8 ()I 
.const [181] = Utf8 org/dsi/ifc/messaging/MessageListEntry 
.const [182] = Utf8 getStorageLocation 
.const [183] = Utf8 ()I 
.const [184] = Utf8 java/lang/Object 
.const [185] = Utf8 <init> 
.const [186] = Utf8 ()V 
.const [187] = Utf8 org/dsi/ifc/messaging/MessageListEntry 
.const [188] = Utf8 <init> 
.const [189] = Utf8 ()V 
.const [190] = Utf8 de/esolutions/fw/util/serializer/ISerializer 
.const [191] = Utf8 putBool 
.const [192] = Utf8 (Z)V 
.const [193] = Utf8 de/esolutions/fw/util/serializer/ISerializer 
.const [194] = Utf8 putOptionalString 
.const [195] = Utf8 (Ljava/lang/String;)V 
.const [196] = Utf8 de/esolutions/fw/util/serializer/ISerializer 
.const [197] = Utf8 putInt32 
.const [198] = Utf8 (I)V 
.const [199] = Utf8 de/esolutions/fw/util/serializer/ISerializer 
.const [200] = Utf8 putOptionalStringVarArray 
.const [201] = Utf8 ([Ljava/lang/String;)V 
.const [202] = Utf8 de/esolutions/fw/util/serializer/ISerializer 
.const [203] = Utf8 putInt64 
.const [204] = Utf8 (J)V 
.const [205] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [206] = Utf8 getBool 
.const [207] = Utf8 ()Z 
.const [208] = Utf8 org/dsi/ifc/messaging/MessageListEntry 
.const [209] = Utf8 matchedAddress 
.const [210] = Utf8 Lorg/dsi/ifc/messaging/MatchedAddress; 
.const [211] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [212] = Utf8 getOptionalString 
.const [213] = Utf8 ()Ljava/lang/String; 
.const [214] = Utf8 org/dsi/ifc/messaging/MessageListEntry 
.const [215] = Utf8 messageID 
.const [216] = Utf8 Ljava/lang/String; 
.const [217] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [218] = Utf8 getInt32 
.const [219] = Utf8 ()I 
.const [220] = Utf8 org/dsi/ifc/messaging/MessageListEntry 
.const [221] = Utf8 messagingAccountID 
.const [222] = Utf8 I 
.const [223] = Utf8 org/dsi/ifc/messaging/MessageListEntry 
.const [224] = Utf8 sender 
.const [225] = Utf8 Ljava/lang/String; 
.const [226] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [227] = Utf8 getOptionalStringVarArray 
.const [228] = Utf8 ()[Ljava/lang/String; 
.const [229] = Utf8 org/dsi/ifc/messaging/MessageListEntry 
.const [230] = Utf8 recipients 
.const [231] = Utf8 [Ljava/lang/String; 
.const [232] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [233] = Utf8 getInt64 
.const [234] = Utf8 ()J 
.const [235] = Utf8 org/dsi/ifc/messaging/MessageListEntry 
.const [236] = Utf8 dateTime 
.const [237] = Utf8 J 
.const [238] = Utf8 org/dsi/ifc/messaging/MessageListEntry 
.const [239] = Utf8 messageStatus 
.const [240] = Utf8 I 
.const [241] = Utf8 org/dsi/ifc/messaging/MessageListEntry 
.const [242] = Utf8 subject 
.const [243] = Utf8 Ljava/lang/String; 
.const [244] = Utf8 org/dsi/ifc/messaging/MessageListEntry 
.const [245] = Utf8 attachmentSize 
.const [246] = Utf8 I 
.const [247] = Utf8 org/dsi/ifc/messaging/MessageListEntry 
.const [248] = Utf8 priority 
.const [249] = Utf8 I 
.const [250] = Utf8 org/dsi/ifc/messaging/MessageListEntry 
.const [251] = Utf8 type 
.const [252] = Utf8 I 
.const [253] = Utf8 org/dsi/ifc/messaging/MessageListEntry 
.const [254] = Utf8 storageLocation 
.const [255] = Utf8 I 
.const [256] = Utf8 de/esolutions/fw/comm/dsi/messaging/impl/MessageListEntrySerializer 
.const [257] = Class [256] 
.const [258] = Utf8 java/lang/Object 
.const [259] = Class [258] 
.const [260] = Utf8 Code 
.const [261] = Utf8 <init> 
.const [262] = Utf8 ()V 
.const [263] = Utf8 putOptionalMessageListEntry 
.const [264] = Utf8 (Lde/esolutions/fw/util/serializer/ISerializer;Lorg/dsi/ifc/messaging/MessageListEntry;)V 
.const [265] = Utf8 putOptionalMessageListEntryVarArray 
.const [266] = Utf8 (Lde/esolutions/fw/util/serializer/ISerializer;[Lorg/dsi/ifc/messaging/MessageListEntry;)V 
.const [267] = Utf8 getOptionalMessageListEntry 
.const [268] = Utf8 (Lde/esolutions/fw/util/serializer/IDeserializer;)Lorg/dsi/ifc/messaging/MessageListEntry; 
.const [269] = Utf8 getOptionalMessageListEntryVarArray 
.const [270] = Utf8 (Lde/esolutions/fw/util/serializer/IDeserializer;)[Lorg/dsi/ifc/messaging/MessageListEntry; 
.end class 
