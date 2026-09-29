.version 50 0 
.class public super [283] 
.super [285] 

.method public annotation [287] : [288] 
    .attribute [286] .code stack 1 locals 0 
L0:     aload_0 
L1:     invokespecial [28] 
L4:     return 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public static [289] : [290] 
    .attribute [286] .code stack 3 locals 15 
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
L18:    ifne L197 
L21:    aload_1 
L22:    invokevirtual [15] 
L25:    istore_3 
L26:    aload_0 
L27:    iload_3 
L28:    invokeinterface [31] 0 
L33:    aload_1 
L34:    invokevirtual [16] 
L37:    istore 4 
L39:    aload_0 
L40:    iload 4 
L42:    invokeinterface [32] 0 
L47:    aload_1 
L48:    invokevirtual [17] 
L51:    istore 5 
L53:    aload_0 
L54:    iload 5 
L56:    invokeinterface [32] 0 
L61:    aload_1 
L62:    invokevirtual [18] 
L65:    astore 6 
L67:    aload_0 
L68:    aload 6 
L70:    invokeinterface [33] 0 
L75:    aload_1 
L76:    invokevirtual [19] 
L79:    astore 7 
L81:    aload_0 
L82:    aload 7 
L84:    invokeinterface [33] 0 
L89:    aload_1 
L90:    invokevirtual [20] 
L93:    astore 8 
L95:    aload_0 
L96:    aload 8 
L98:    invokestatic [2] 
L101:   aload_1 
L102:   invokevirtual [21] 
L105:   istore 9 
L107:   aload_0 
L108:   iload 9 
L110:   invokeinterface [31] 0 
L115:   aload_1 
L116:   invokevirtual [22] 
L119:   istore 10 
L121:   aload_0 
L122:   iload 10 
L124:   invokeinterface [32] 0 
L129:   aload_1 
L130:   invokevirtual [23] 
L133:   lstore 11 
L135:   aload_0 
L136:   lload 11 
L138:   invokeinterface [34] 0 
L143:   aload_1 
L144:   invokevirtual [24] 
L147:   istore 13 
L149:   aload_0 
L150:   iload 13 
L152:   invokeinterface [32] 0 
L157:   aload_1 
L158:   invokevirtual [25] 
L161:   istore 14 
L163:   aload_0 
L164:   iload 14 
L166:   invokeinterface [32] 0 
L171:   aload_1 
L172:   invokevirtual [26] 
L175:   astore 15 
L177:   aload_0 
L178:   aload 15 
L180:   invokestatic [3] 
L183:   aload_1 
L184:   invokevirtual [27] 
L187:   istore 16 
L189:   aload_0 
L190:   iload 16 
L192:   invokeinterface [32] 0 
L197:   return 
L198:   nop 
L199:   nop 
L200:   
    .end code 
.end method 

.method public static [291] : [292] 
    .attribute [286] .code stack 3 locals 2 
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
L41:    invokestatic [4] 
L44:    iinc 3 1 
L47:    goto L31 
L50:    return 
L51:    nop 
L52:    
    .end code 
.end method 

.method public static [293] : [294] 
    .attribute [286] .code stack 3 locals 16 
L0:     aconst_null 
L1:     astore_1 
L2:     aload_0 
L3:     invokeinterface [35] 0 
L8:     istore_2 
L9:     iload_2 
L10:    ifne L197 
L13:    new [36] 
L16:    dup 
L17:    invokespecial [29] 
L20:    astore_1 
L21:    aload_0 
L22:    invokeinterface [37] 0 
L27:    istore_3 
L28:    aload_1 
L29:    iload_3 
L30:    putfield [38] 
L33:    aload_0 
L34:    invokeinterface [39] 0 
L39:    istore 4 
L41:    aload_1 
L42:    iload 4 
L44:    putfield [40] 
L47:    aload_0 
L48:    invokeinterface [39] 0 
L53:    istore 5 
L55:    aload_1 
L56:    iload 5 
L58:    putfield [41] 
L61:    aload_0 
L62:    invokeinterface [42] 0 
L67:    astore 6 
L69:    aload_1 
L70:    aload 6 
L72:    putfield [43] 
L75:    aload_0 
L76:    invokeinterface [42] 0 
L81:    astore 7 
L83:    aload_1 
L84:    aload 7 
L86:    putfield [44] 
L89:    aload_0 
L90:    invokestatic [6] 
L93:    astore 8 
L95:    aload_1 
L96:    aload 8 
L98:    putfield [45] 
L101:   aload_0 
L102:   invokeinterface [37] 0 
L107:   istore 9 
L109:   aload_1 
L110:   iload 9 
L112:   putfield [46] 
L115:   aload_0 
L116:   invokeinterface [39] 0 
L121:   istore 10 
L123:   aload_1 
L124:   iload 10 
L126:   putfield [47] 
L129:   aload_0 
L130:   invokeinterface [48] 0 
L135:   lstore 11 
L137:   aload_1 
L138:   lload 11 
L140:   putfield [49] 
L143:   aload_0 
L144:   invokeinterface [39] 0 
L149:   istore 13 
L151:   aload_1 
L152:   iload 13 
L154:   putfield [50] 
L157:   aload_0 
L158:   invokeinterface [39] 0 
L163:   istore 14 
L165:   aload_1 
L166:   iload 14 
L168:   putfield [51] 
L171:   aload_0 
L172:   invokestatic [7] 
L175:   astore 15 
L177:   aload_1 
L178:   aload 15 
L180:   putfield [52] 
L183:   aload_0 
L184:   invokeinterface [39] 0 
L189:   istore 16 
L191:   aload_1 
L192:   iload 16 
L194:   putfield [53] 
L197:   aload_1 
L198:   areturn 
L199:   nop 
L200:   
    .end code 
.end method 

.method public static [295] : [296] 
    .attribute [286] .code stack 3 locals 4 
L0:     aconst_null 
L1:     astore_1 
L2:     aload_0 
L3:     invokeinterface [35] 0 
L8:     istore_2 
L9:     iload_2 
L10:    ifne L48 
L13:    aload_0 
L14:    invokeinterface [39] 0 
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
.const [2] = Method [54] [55] 
.const [3] = Method [56] [57] 
.const [4] = Method [58] [59] 
.const [5] = Class [60] 
.const [6] = Method [61] [62] 
.const [7] = Method [63] [64] 
.const [8] = Method [65] [66] 
.const [9] = Class [67] 
.const [10] = Class [68] 
.const [11] = Class [69] 
.const [12] = Class [70] 
.const [13] = Class [71] 
.const [14] = Class [72] 
.const [15] = Method [73] [74] 
.const [16] = Method [75] [76] 
.const [17] = Method [77] [78] 
.const [18] = Method [79] [80] 
.const [19] = Method [81] [82] 
.const [20] = Method [83] [84] 
.const [21] = Method [85] [86] 
.const [22] = Method [87] [88] 
.const [23] = Method [89] [90] 
.const [24] = Method [91] [92] 
.const [25] = Method [93] [94] 
.const [26] = Method [95] [96] 
.const [27] = Method [97] [98] 
.const [28] = Method [99] [100] 
.const [29] = Method [101] [102] 
.const [30] = InterfaceMethod [103] [104] 
.const [31] = InterfaceMethod [105] [106] 
.const [32] = InterfaceMethod [107] [108] 
.const [33] = InterfaceMethod [109] [110] 
.const [34] = InterfaceMethod [111] [112] 
.const [35] = InterfaceMethod [113] [114] 
.const [36] = Class [115] 
.const [37] = InterfaceMethod [116] [117] 
.const [38] = Field [118] [119] 
.const [39] = InterfaceMethod [120] [121] 
.const [40] = Field [122] [123] 
.const [41] = Field [124] [125] 
.const [42] = InterfaceMethod [126] [127] 
.const [43] = Field [128] [129] 
.const [44] = Field [130] [131] 
.const [45] = Field [132] [133] 
.const [46] = Field [134] [135] 
.const [47] = Field [136] [137] 
.const [48] = InterfaceMethod [138] [139] 
.const [49] = Field [140] [141] 
.const [50] = Field [142] [143] 
.const [51] = Field [144] [145] 
.const [52] = Field [146] [147] 
.const [53] = Field [148] [149] 
.const [54] = Class [150] 
.const [55] = NameAndType [151] [152] 
.const [56] = Class [153] 
.const [57] = NameAndType [154] [155] 
.const [58] = Class [156] 
.const [59] = NameAndType [157] [158] 
.const [60] = Utf8 org/dsi/ifc/telephone/CallInformation 
.const [61] = Class [159] 
.const [62] = NameAndType [160] [161] 
.const [63] = Class [162] 
.const [64] = NameAndType [163] [164] 
.const [65] = Class [165] 
.const [66] = NameAndType [166] [167] 
.const [67] = Utf8 de/esolutions/fw/comm/dsi/telephone/impl/CallInformationSerializer 
.const [68] = Utf8 java/lang/Object 
.const [69] = Utf8 de/esolutions/fw/util/serializer/ISerializer 
.const [70] = Utf8 de/esolutions/fw/comm/dsi/global/impl/ResourceLocatorSerializer 
.const [71] = Utf8 de/esolutions/fw/comm/dsi/telephone/impl/CallInformationExtSerializer 
.const [72] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [73] = Class [168] 
.const [74] = NameAndType [169] [170] 
.const [75] = Class [171] 
.const [76] = NameAndType [172] [173] 
.const [77] = Class [174] 
.const [78] = NameAndType [175] [176] 
.const [79] = Class [177] 
.const [80] = NameAndType [178] [179] 
.const [81] = Class [180] 
.const [82] = NameAndType [181] [182] 
.const [83] = Class [183] 
.const [84] = NameAndType [184] [185] 
.const [85] = Class [186] 
.const [86] = NameAndType [187] [188] 
.const [87] = Class [189] 
.const [88] = NameAndType [190] [191] 
.const [89] = Class [192] 
.const [90] = NameAndType [193] [194] 
.const [91] = Class [195] 
.const [92] = NameAndType [196] [197] 
.const [93] = Class [198] 
.const [94] = NameAndType [199] [200] 
.const [95] = Class [201] 
.const [96] = NameAndType [202] [203] 
.const [97] = Class [204] 
.const [98] = NameAndType [205] [206] 
.const [99] = Class [207] 
.const [100] = NameAndType [208] [209] 
.const [101] = Class [210] 
.const [102] = NameAndType [211] [212] 
.const [103] = Class [213] 
.const [104] = NameAndType [214] [215] 
.const [105] = Class [216] 
.const [106] = NameAndType [217] [218] 
.const [107] = Class [219] 
.const [108] = NameAndType [220] [221] 
.const [109] = Class [222] 
.const [110] = NameAndType [223] [224] 
.const [111] = Class [225] 
.const [112] = NameAndType [226] [227] 
.const [113] = Class [228] 
.const [114] = NameAndType [229] [230] 
.const [115] = Utf8 org/dsi/ifc/telephone/CallInformation 
.const [116] = Class [231] 
.const [117] = NameAndType [232] [233] 
.const [118] = Class [234] 
.const [119] = NameAndType [235] [236] 
.const [120] = Class [237] 
.const [121] = NameAndType [238] [239] 
.const [122] = Class [240] 
.const [123] = NameAndType [241] [242] 
.const [124] = Class [243] 
.const [125] = NameAndType [244] [245] 
.const [126] = Class [246] 
.const [127] = NameAndType [247] [248] 
.const [128] = Class [249] 
.const [129] = NameAndType [250] [251] 
.const [130] = Class [252] 
.const [131] = NameAndType [253] [254] 
.const [132] = Class [255] 
.const [133] = NameAndType [256] [257] 
.const [134] = Class [258] 
.const [135] = NameAndType [259] [260] 
.const [136] = Class [261] 
.const [137] = NameAndType [262] [263] 
.const [138] = Class [264] 
.const [139] = NameAndType [265] [266] 
.const [140] = Class [267] 
.const [141] = NameAndType [268] [269] 
.const [142] = Class [270] 
.const [143] = NameAndType [271] [272] 
.const [144] = Class [273] 
.const [145] = NameAndType [274] [275] 
.const [146] = Class [276] 
.const [147] = NameAndType [277] [278] 
.const [148] = Class [279] 
.const [149] = NameAndType [280] [281] 
.const [150] = Utf8 de/esolutions/fw/comm/dsi/global/impl/ResourceLocatorSerializer 
.const [151] = Utf8 putOptionalResourceLocator 
.const [152] = Utf8 (Lde/esolutions/fw/util/serializer/ISerializer;Lorg/dsi/ifc/global/ResourceLocator;)V 
.const [153] = Utf8 de/esolutions/fw/comm/dsi/telephone/impl/CallInformationExtSerializer 
.const [154] = Utf8 putOptionalCallInformationExt 
.const [155] = Utf8 (Lde/esolutions/fw/util/serializer/ISerializer;Lorg/dsi/ifc/telephone/CallInformationExt;)V 
.const [156] = Utf8 de/esolutions/fw/comm/dsi/telephone/impl/CallInformationSerializer 
.const [157] = Utf8 putOptionalCallInformation 
.const [158] = Utf8 (Lde/esolutions/fw/util/serializer/ISerializer;Lorg/dsi/ifc/telephone/CallInformation;)V 
.const [159] = Utf8 de/esolutions/fw/comm/dsi/global/impl/ResourceLocatorSerializer 
.const [160] = Utf8 getOptionalResourceLocator 
.const [161] = Utf8 (Lde/esolutions/fw/util/serializer/IDeserializer;)Lorg/dsi/ifc/global/ResourceLocator; 
.const [162] = Utf8 de/esolutions/fw/comm/dsi/telephone/impl/CallInformationExtSerializer 
.const [163] = Utf8 getOptionalCallInformationExt 
.const [164] = Utf8 (Lde/esolutions/fw/util/serializer/IDeserializer;)Lorg/dsi/ifc/telephone/CallInformationExt; 
.const [165] = Utf8 de/esolutions/fw/comm/dsi/telephone/impl/CallInformationSerializer 
.const [166] = Utf8 getOptionalCallInformation 
.const [167] = Utf8 (Lde/esolutions/fw/util/serializer/IDeserializer;)Lorg/dsi/ifc/telephone/CallInformation; 
.const [168] = Utf8 org/dsi/ifc/telephone/CallInformation 
.const [169] = Utf8 getTelCallID 
.const [170] = Utf8 ()S 
.const [171] = Utf8 org/dsi/ifc/telephone/CallInformation 
.const [172] = Utf8 getTelCallState 
.const [173] = Utf8 ()I 
.const [174] = Utf8 org/dsi/ifc/telephone/CallInformation 
.const [175] = Utf8 getTelMpty 
.const [176] = Utf8 ()I 
.const [177] = Utf8 org/dsi/ifc/telephone/CallInformation 
.const [178] = Utf8 getTelRemName 
.const [179] = Utf8 ()Ljava/lang/String; 
.const [180] = Utf8 org/dsi/ifc/telephone/CallInformation 
.const [181] = Utf8 getTelRemNumber 
.const [182] = Utf8 ()Ljava/lang/String; 
.const [183] = Utf8 org/dsi/ifc/telephone/CallInformation 
.const [184] = Utf8 getTelRemPictureId 
.const [185] = Utf8 ()Lorg/dsi/ifc/global/ResourceLocator; 
.const [186] = Utf8 org/dsi/ifc/telephone/CallInformation 
.const [187] = Utf8 getTelNumType 
.const [188] = Utf8 ()S 
.const [189] = Utf8 org/dsi/ifc/telephone/CallInformation 
.const [190] = Utf8 getTelCallType 
.const [191] = Utf8 ()I 
.const [192] = Utf8 org/dsi/ifc/telephone/CallInformation 
.const [193] = Utf8 getTelRemEntryId 
.const [194] = Utf8 ()J 
.const [195] = Utf8 org/dsi/ifc/telephone/CallInformation 
.const [196] = Utf8 getTelRemNumberType 
.const [197] = Utf8 ()I 
.const [198] = Utf8 org/dsi/ifc/telephone/CallInformation 
.const [199] = Utf8 getTelCallStartingTime 
.const [200] = Utf8 ()I 
.const [201] = Utf8 org/dsi/ifc/telephone/CallInformation 
.const [202] = Utf8 getExtendedCallInformation 
.const [203] = Utf8 ()Lorg/dsi/ifc/telephone/CallInformationExt; 
.const [204] = Utf8 org/dsi/ifc/telephone/CallInformation 
.const [205] = Utf8 getTelCallCarrier 
.const [206] = Utf8 ()I 
.const [207] = Utf8 java/lang/Object 
.const [208] = Utf8 <init> 
.const [209] = Utf8 ()V 
.const [210] = Utf8 org/dsi/ifc/telephone/CallInformation 
.const [211] = Utf8 <init> 
.const [212] = Utf8 ()V 
.const [213] = Utf8 de/esolutions/fw/util/serializer/ISerializer 
.const [214] = Utf8 putBool 
.const [215] = Utf8 (Z)V 
.const [216] = Utf8 de/esolutions/fw/util/serializer/ISerializer 
.const [217] = Utf8 putInt16 
.const [218] = Utf8 (S)V 
.const [219] = Utf8 de/esolutions/fw/util/serializer/ISerializer 
.const [220] = Utf8 putInt32 
.const [221] = Utf8 (I)V 
.const [222] = Utf8 de/esolutions/fw/util/serializer/ISerializer 
.const [223] = Utf8 putOptionalString 
.const [224] = Utf8 (Ljava/lang/String;)V 
.const [225] = Utf8 de/esolutions/fw/util/serializer/ISerializer 
.const [226] = Utf8 putInt64 
.const [227] = Utf8 (J)V 
.const [228] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [229] = Utf8 getBool 
.const [230] = Utf8 ()Z 
.const [231] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [232] = Utf8 getInt16 
.const [233] = Utf8 ()S 
.const [234] = Utf8 org/dsi/ifc/telephone/CallInformation 
.const [235] = Utf8 telCallID 
.const [236] = Utf8 S 
.const [237] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [238] = Utf8 getInt32 
.const [239] = Utf8 ()I 
.const [240] = Utf8 org/dsi/ifc/telephone/CallInformation 
.const [241] = Utf8 telCallState 
.const [242] = Utf8 I 
.const [243] = Utf8 org/dsi/ifc/telephone/CallInformation 
.const [244] = Utf8 telMpty 
.const [245] = Utf8 I 
.const [246] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [247] = Utf8 getOptionalString 
.const [248] = Utf8 ()Ljava/lang/String; 
.const [249] = Utf8 org/dsi/ifc/telephone/CallInformation 
.const [250] = Utf8 telRemName 
.const [251] = Utf8 Ljava/lang/String; 
.const [252] = Utf8 org/dsi/ifc/telephone/CallInformation 
.const [253] = Utf8 telRemNumber 
.const [254] = Utf8 Ljava/lang/String; 
.const [255] = Utf8 org/dsi/ifc/telephone/CallInformation 
.const [256] = Utf8 telRemPictureId 
.const [257] = Utf8 Lorg/dsi/ifc/global/ResourceLocator; 
.const [258] = Utf8 org/dsi/ifc/telephone/CallInformation 
.const [259] = Utf8 telNumType 
.const [260] = Utf8 S 
.const [261] = Utf8 org/dsi/ifc/telephone/CallInformation 
.const [262] = Utf8 telCallType 
.const [263] = Utf8 I 
.const [264] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [265] = Utf8 getInt64 
.const [266] = Utf8 ()J 
.const [267] = Utf8 org/dsi/ifc/telephone/CallInformation 
.const [268] = Utf8 telRemEntryId 
.const [269] = Utf8 J 
.const [270] = Utf8 org/dsi/ifc/telephone/CallInformation 
.const [271] = Utf8 telRemNumberType 
.const [272] = Utf8 I 
.const [273] = Utf8 org/dsi/ifc/telephone/CallInformation 
.const [274] = Utf8 telCallStartingTime 
.const [275] = Utf8 I 
.const [276] = Utf8 org/dsi/ifc/telephone/CallInformation 
.const [277] = Utf8 extendedCallInformation 
.const [278] = Utf8 Lorg/dsi/ifc/telephone/CallInformationExt; 
.const [279] = Utf8 org/dsi/ifc/telephone/CallInformation 
.const [280] = Utf8 telCallCarrier 
.const [281] = Utf8 I 
.const [282] = Utf8 de/esolutions/fw/comm/dsi/telephone/impl/CallInformationSerializer 
.const [283] = Class [282] 
.const [284] = Utf8 java/lang/Object 
.const [285] = Class [284] 
.const [286] = Utf8 Code 
.const [287] = Utf8 <init> 
.const [288] = Utf8 ()V 
.const [289] = Utf8 putOptionalCallInformation 
.const [290] = Utf8 (Lde/esolutions/fw/util/serializer/ISerializer;Lorg/dsi/ifc/telephone/CallInformation;)V 
.const [291] = Utf8 putOptionalCallInformationVarArray 
.const [292] = Utf8 (Lde/esolutions/fw/util/serializer/ISerializer;[Lorg/dsi/ifc/telephone/CallInformation;)V 
.const [293] = Utf8 getOptionalCallInformation 
.const [294] = Utf8 (Lde/esolutions/fw/util/serializer/IDeserializer;)Lorg/dsi/ifc/telephone/CallInformation; 
.const [295] = Utf8 getOptionalCallInformationVarArray 
.const [296] = Utf8 (Lde/esolutions/fw/util/serializer/IDeserializer;)[Lorg/dsi/ifc/telephone/CallInformation; 
.end class 
