.version 50 0 
.class public super [319] 
.super [321] 

.method public annotation [323] : [324] 
    .attribute [322] .code stack 1 locals 0 
L0:     aload_0 
L1:     invokespecial [31] 
L4:     return 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public static [325] : [326] 
    .attribute [322] .code stack 3 locals 18 
L0:     aload_1 
L1:     ifnonnull L8 
L4:     iconst_1 
L5:     goto L9 
L8:     iconst_0 
L9:     istore_2 
L10:    aload_0 
L11:    iload_2 
L12:    invokeinterface [33] 0 
L17:    iload_2 
L18:    ifne L239 
L21:    aload_1 
L22:    invokevirtual [15] 
L25:    istore_3 
L26:    aload_0 
L27:    iload_3 
L28:    invokeinterface [34] 0 
L33:    aload_1 
L34:    invokevirtual [16] 
L37:    istore 4 
L39:    aload_0 
L40:    iload 4 
L42:    invokeinterface [35] 0 
L47:    aload_1 
L48:    invokevirtual [17] 
L51:    istore 5 
L53:    aload_0 
L54:    iload 5 
L56:    invokeinterface [35] 0 
L61:    aload_1 
L62:    invokevirtual [18] 
L65:    astore 6 
L67:    aload_0 
L68:    aload 6 
L70:    invokeinterface [36] 0 
L75:    aload_1 
L76:    invokevirtual [19] 
L79:    astore 7 
L81:    aload_0 
L82:    aload 7 
L84:    invokeinterface [36] 0 
L89:    aload_1 
L90:    invokevirtual [20] 
L93:    astore 8 
L95:    aload_0 
L96:    aload 8 
L98:    invokeinterface [36] 0 
L103:   aload_1 
L104:   invokevirtual [21] 
L107:   astore 9 
L109:   aload_0 
L110:   aload 9 
L112:   invokeinterface [36] 0 
L117:   aload_1 
L118:   invokevirtual [22] 
L121:   astore 10 
L123:   aload_0 
L124:   aload 10 
L126:   invokeinterface [36] 0 
L131:   aload_1 
L132:   invokevirtual [23] 
L135:   astore 11 
L137:   aload_0 
L138:   aload 11 
L140:   invokestatic [2] 
L143:   aload_1 
L144:   invokevirtual [24] 
L147:   istore 12 
L149:   aload_0 
L150:   iload 12 
L152:   invokeinterface [34] 0 
L157:   aload_1 
L158:   invokevirtual [25] 
L161:   istore 13 
L163:   aload_0 
L164:   iload 13 
L166:   invokeinterface [35] 0 
L171:   aload_1 
L172:   invokevirtual [26] 
L175:   lstore 14 
L177:   aload_0 
L178:   lload 14 
L180:   invokeinterface [37] 0 
L185:   aload_1 
L186:   invokevirtual [27] 
L189:   istore 16 
L191:   aload_0 
L192:   iload 16 
L194:   invokeinterface [35] 0 
L199:   aload_1 
L200:   invokevirtual [28] 
L203:   istore 17 
L205:   aload_0 
L206:   iload 17 
L208:   invokeinterface [35] 0 
L213:   aload_1 
L214:   invokevirtual [29] 
L217:   astore 18 
L219:   aload_0 
L220:   aload 18 
L222:   invokestatic [3] 
L225:   aload_1 
L226:   invokevirtual [30] 
L229:   istore 19 
L231:   aload_0 
L232:   iload 19 
L234:   invokeinterface [35] 0 
L239:   return 
L240:   
    .end code 
.end method 

.method public static [327] : [328] 
    .attribute [322] .code stack 3 locals 2 
L0:     aload_1 
L1:     ifnonnull L8 
L4:     iconst_1 
L5:     goto L9 
L8:     iconst_0 
L9:     istore_2 
L10:    aload_0 
L11:    iload_2 
L12:    invokeinterface [33] 0 
L17:    iload_2 
L18:    ifne L50 
L21:    aload_0 
L22:    aload_1 
L23:    arraylength 
L24:    invokeinterface [35] 0 
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

.method public static [329] : [330] 
    .attribute [322] .code stack 3 locals 19 
L0:     aconst_null 
L1:     astore_1 
L2:     aload_0 
L3:     invokeinterface [38] 0 
L8:     istore_2 
L9:     iload_2 
L10:    ifne L239 
L13:    new [39] 
L16:    dup 
L17:    invokespecial [32] 
L20:    astore_1 
L21:    aload_0 
L22:    invokeinterface [40] 0 
L27:    istore_3 
L28:    aload_1 
L29:    iload_3 
L30:    putfield [41] 
L33:    aload_0 
L34:    invokeinterface [42] 0 
L39:    istore 4 
L41:    aload_1 
L42:    iload 4 
L44:    putfield [43] 
L47:    aload_0 
L48:    invokeinterface [42] 0 
L53:    istore 5 
L55:    aload_1 
L56:    iload 5 
L58:    putfield [44] 
L61:    aload_0 
L62:    invokeinterface [45] 0 
L67:    astore 6 
L69:    aload_1 
L70:    aload 6 
L72:    putfield [46] 
L75:    aload_0 
L76:    invokeinterface [45] 0 
L81:    astore 7 
L83:    aload_1 
L84:    aload 7 
L86:    putfield [47] 
L89:    aload_0 
L90:    invokeinterface [45] 0 
L95:    astore 8 
L97:    aload_1 
L98:    aload 8 
L100:   putfield [48] 
L103:   aload_0 
L104:   invokeinterface [45] 0 
L109:   astore 9 
L111:   aload_1 
L112:   aload 9 
L114:   putfield [49] 
L117:   aload_0 
L118:   invokeinterface [45] 0 
L123:   astore 10 
L125:   aload_1 
L126:   aload 10 
L128:   putfield [50] 
L131:   aload_0 
L132:   invokestatic [6] 
L135:   astore 11 
L137:   aload_1 
L138:   aload 11 
L140:   putfield [51] 
L143:   aload_0 
L144:   invokeinterface [40] 0 
L149:   istore 12 
L151:   aload_1 
L152:   iload 12 
L154:   putfield [52] 
L157:   aload_0 
L158:   invokeinterface [42] 0 
L163:   istore 13 
L165:   aload_1 
L166:   iload 13 
L168:   putfield [53] 
L171:   aload_0 
L172:   invokeinterface [54] 0 
L177:   lstore 14 
L179:   aload_1 
L180:   lload 14 
L182:   putfield [55] 
L185:   aload_0 
L186:   invokeinterface [42] 0 
L191:   istore 16 
L193:   aload_1 
L194:   iload 16 
L196:   putfield [56] 
L199:   aload_0 
L200:   invokeinterface [42] 0 
L205:   istore 17 
L207:   aload_1 
L208:   iload 17 
L210:   putfield [57] 
L213:   aload_0 
L214:   invokestatic [7] 
L217:   astore 18 
L219:   aload_1 
L220:   aload 18 
L222:   putfield [58] 
L225:   aload_0 
L226:   invokeinterface [42] 0 
L231:   istore 19 
L233:   aload_1 
L234:   iload 19 
L236:   putfield [59] 
L239:   aload_1 
L240:   areturn 
L241:   nop 
L242:   nop 
L243:   nop 
L244:   
    .end code 
.end method 

.method public static [331] : [332] 
    .attribute [322] .code stack 3 locals 4 
L0:     aconst_null 
L1:     astore_1 
L2:     aload_0 
L3:     invokeinterface [38] 0 
L8:     istore_2 
L9:     iload_2 
L10:    ifne L48 
L13:    aload_0 
L14:    invokeinterface [42] 0 
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
.const [2] = Method [60] [61] 
.const [3] = Method [62] [63] 
.const [4] = Method [64] [65] 
.const [5] = Class [66] 
.const [6] = Method [67] [68] 
.const [7] = Method [69] [70] 
.const [8] = Method [71] [72] 
.const [9] = Class [73] 
.const [10] = Class [74] 
.const [11] = Class [75] 
.const [12] = Class [76] 
.const [13] = Class [77] 
.const [14] = Class [78] 
.const [15] = Method [79] [80] 
.const [16] = Method [81] [82] 
.const [17] = Method [83] [84] 
.const [18] = Method [85] [86] 
.const [19] = Method [87] [88] 
.const [20] = Method [89] [90] 
.const [21] = Method [91] [92] 
.const [22] = Method [93] [94] 
.const [23] = Method [95] [96] 
.const [24] = Method [97] [98] 
.const [25] = Method [99] [100] 
.const [26] = Method [101] [102] 
.const [27] = Method [103] [104] 
.const [28] = Method [105] [106] 
.const [29] = Method [107] [108] 
.const [30] = Method [109] [110] 
.const [31] = Method [111] [112] 
.const [32] = Method [113] [114] 
.const [33] = InterfaceMethod [115] [116] 
.const [34] = InterfaceMethod [117] [118] 
.const [35] = InterfaceMethod [119] [120] 
.const [36] = InterfaceMethod [121] [122] 
.const [37] = InterfaceMethod [123] [124] 
.const [38] = InterfaceMethod [125] [126] 
.const [39] = Class [127] 
.const [40] = InterfaceMethod [128] [129] 
.const [41] = Field [130] [131] 
.const [42] = InterfaceMethod [132] [133] 
.const [43] = Field [134] [135] 
.const [44] = Field [136] [137] 
.const [45] = InterfaceMethod [138] [139] 
.const [46] = Field [140] [141] 
.const [47] = Field [142] [143] 
.const [48] = Field [144] [145] 
.const [49] = Field [146] [147] 
.const [50] = Field [148] [149] 
.const [51] = Field [150] [151] 
.const [52] = Field [152] [153] 
.const [53] = Field [154] [155] 
.const [54] = InterfaceMethod [156] [157] 
.const [55] = Field [158] [159] 
.const [56] = Field [160] [161] 
.const [57] = Field [162] [163] 
.const [58] = Field [164] [165] 
.const [59] = Field [166] [167] 
.const [60] = Class [168] 
.const [61] = NameAndType [169] [170] 
.const [62] = Class [171] 
.const [63] = NameAndType [172] [173] 
.const [64] = Class [174] 
.const [65] = NameAndType [175] [176] 
.const [66] = Utf8 org/dsi/ifc/telephoneng/CallInformation 
.const [67] = Class [177] 
.const [68] = NameAndType [178] [179] 
.const [69] = Class [180] 
.const [70] = NameAndType [181] [182] 
.const [71] = Class [183] 
.const [72] = NameAndType [184] [185] 
.const [73] = Utf8 de/esolutions/fw/comm/dsi/telephoneng/impl/CallInformationSerializer 
.const [74] = Utf8 java/lang/Object 
.const [75] = Utf8 de/esolutions/fw/util/serializer/ISerializer 
.const [76] = Utf8 de/esolutions/fw/comm/dsi/global/impl/ResourceLocatorSerializer 
.const [77] = Utf8 de/esolutions/fw/comm/dsi/telephoneng/impl/CallInformationExtSerializer 
.const [78] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [79] = Class [186] 
.const [80] = NameAndType [187] [188] 
.const [81] = Class [189] 
.const [82] = NameAndType [190] [191] 
.const [83] = Class [192] 
.const [84] = NameAndType [193] [194] 
.const [85] = Class [195] 
.const [86] = NameAndType [196] [197] 
.const [87] = Class [198] 
.const [88] = NameAndType [199] [200] 
.const [89] = Class [201] 
.const [90] = NameAndType [202] [203] 
.const [91] = Class [204] 
.const [92] = NameAndType [205] [206] 
.const [93] = Class [207] 
.const [94] = NameAndType [208] [209] 
.const [95] = Class [210] 
.const [96] = NameAndType [211] [212] 
.const [97] = Class [213] 
.const [98] = NameAndType [214] [215] 
.const [99] = Class [216] 
.const [100] = NameAndType [217] [218] 
.const [101] = Class [219] 
.const [102] = NameAndType [220] [221] 
.const [103] = Class [222] 
.const [104] = NameAndType [223] [224] 
.const [105] = Class [225] 
.const [106] = NameAndType [226] [227] 
.const [107] = Class [228] 
.const [108] = NameAndType [229] [230] 
.const [109] = Class [231] 
.const [110] = NameAndType [232] [233] 
.const [111] = Class [234] 
.const [112] = NameAndType [235] [236] 
.const [113] = Class [237] 
.const [114] = NameAndType [238] [239] 
.const [115] = Class [240] 
.const [116] = NameAndType [241] [242] 
.const [117] = Class [243] 
.const [118] = NameAndType [244] [245] 
.const [119] = Class [246] 
.const [120] = NameAndType [247] [248] 
.const [121] = Class [249] 
.const [122] = NameAndType [250] [251] 
.const [123] = Class [252] 
.const [124] = NameAndType [253] [254] 
.const [125] = Class [255] 
.const [126] = NameAndType [256] [257] 
.const [127] = Utf8 org/dsi/ifc/telephoneng/CallInformation 
.const [128] = Class [258] 
.const [129] = NameAndType [259] [260] 
.const [130] = Class [261] 
.const [131] = NameAndType [262] [263] 
.const [132] = Class [264] 
.const [133] = NameAndType [265] [266] 
.const [134] = Class [267] 
.const [135] = NameAndType [268] [269] 
.const [136] = Class [270] 
.const [137] = NameAndType [271] [272] 
.const [138] = Class [273] 
.const [139] = NameAndType [274] [275] 
.const [140] = Class [276] 
.const [141] = NameAndType [277] [278] 
.const [142] = Class [279] 
.const [143] = NameAndType [280] [281] 
.const [144] = Class [282] 
.const [145] = NameAndType [283] [284] 
.const [146] = Class [285] 
.const [147] = NameAndType [286] [287] 
.const [148] = Class [288] 
.const [149] = NameAndType [289] [290] 
.const [150] = Class [291] 
.const [151] = NameAndType [292] [293] 
.const [152] = Class [294] 
.const [153] = NameAndType [295] [296] 
.const [154] = Class [297] 
.const [155] = NameAndType [298] [299] 
.const [156] = Class [300] 
.const [157] = NameAndType [301] [302] 
.const [158] = Class [303] 
.const [159] = NameAndType [304] [305] 
.const [160] = Class [306] 
.const [161] = NameAndType [307] [308] 
.const [162] = Class [309] 
.const [163] = NameAndType [310] [311] 
.const [164] = Class [312] 
.const [165] = NameAndType [313] [314] 
.const [166] = Class [315] 
.const [167] = NameAndType [316] [317] 
.const [168] = Utf8 de/esolutions/fw/comm/dsi/global/impl/ResourceLocatorSerializer 
.const [169] = Utf8 putOptionalResourceLocator 
.const [170] = Utf8 (Lde/esolutions/fw/util/serializer/ISerializer;Lorg/dsi/ifc/global/ResourceLocator;)V 
.const [171] = Utf8 de/esolutions/fw/comm/dsi/telephoneng/impl/CallInformationExtSerializer 
.const [172] = Utf8 putOptionalCallInformationExt 
.const [173] = Utf8 (Lde/esolutions/fw/util/serializer/ISerializer;Lorg/dsi/ifc/telephoneng/CallInformationExt;)V 
.const [174] = Utf8 de/esolutions/fw/comm/dsi/telephoneng/impl/CallInformationSerializer 
.const [175] = Utf8 putOptionalCallInformation 
.const [176] = Utf8 (Lde/esolutions/fw/util/serializer/ISerializer;Lorg/dsi/ifc/telephoneng/CallInformation;)V 
.const [177] = Utf8 de/esolutions/fw/comm/dsi/global/impl/ResourceLocatorSerializer 
.const [178] = Utf8 getOptionalResourceLocator 
.const [179] = Utf8 (Lde/esolutions/fw/util/serializer/IDeserializer;)Lorg/dsi/ifc/global/ResourceLocator; 
.const [180] = Utf8 de/esolutions/fw/comm/dsi/telephoneng/impl/CallInformationExtSerializer 
.const [181] = Utf8 getOptionalCallInformationExt 
.const [182] = Utf8 (Lde/esolutions/fw/util/serializer/IDeserializer;)Lorg/dsi/ifc/telephoneng/CallInformationExt; 
.const [183] = Utf8 de/esolutions/fw/comm/dsi/telephoneng/impl/CallInformationSerializer 
.const [184] = Utf8 getOptionalCallInformation 
.const [185] = Utf8 (Lde/esolutions/fw/util/serializer/IDeserializer;)Lorg/dsi/ifc/telephoneng/CallInformation; 
.const [186] = Utf8 org/dsi/ifc/telephoneng/CallInformation 
.const [187] = Utf8 getTelCallID 
.const [188] = Utf8 ()S 
.const [189] = Utf8 org/dsi/ifc/telephoneng/CallInformation 
.const [190] = Utf8 getTelCallState 
.const [191] = Utf8 ()I 
.const [192] = Utf8 org/dsi/ifc/telephoneng/CallInformation 
.const [193] = Utf8 getTelMpty 
.const [194] = Utf8 ()I 
.const [195] = Utf8 org/dsi/ifc/telephoneng/CallInformation 
.const [196] = Utf8 getTelRemName 
.const [197] = Utf8 ()Ljava/lang/String; 
.const [198] = Utf8 org/dsi/ifc/telephoneng/CallInformation 
.const [199] = Utf8 getTelRemLastName 
.const [200] = Utf8 ()Ljava/lang/String; 
.const [201] = Utf8 org/dsi/ifc/telephoneng/CallInformation 
.const [202] = Utf8 getTelRemFirstName 
.const [203] = Utf8 ()Ljava/lang/String; 
.const [204] = Utf8 org/dsi/ifc/telephoneng/CallInformation 
.const [205] = Utf8 getTelRemOrganization 
.const [206] = Utf8 ()Ljava/lang/String; 
.const [207] = Utf8 org/dsi/ifc/telephoneng/CallInformation 
.const [208] = Utf8 getTelRemNumber 
.const [209] = Utf8 ()Ljava/lang/String; 
.const [210] = Utf8 org/dsi/ifc/telephoneng/CallInformation 
.const [211] = Utf8 getTelRemPictureId 
.const [212] = Utf8 ()Lorg/dsi/ifc/global/ResourceLocator; 
.const [213] = Utf8 org/dsi/ifc/telephoneng/CallInformation 
.const [214] = Utf8 getTelNumType 
.const [215] = Utf8 ()S 
.const [216] = Utf8 org/dsi/ifc/telephoneng/CallInformation 
.const [217] = Utf8 getTelCallType 
.const [218] = Utf8 ()I 
.const [219] = Utf8 org/dsi/ifc/telephoneng/CallInformation 
.const [220] = Utf8 getTelRemEntryId 
.const [221] = Utf8 ()J 
.const [222] = Utf8 org/dsi/ifc/telephoneng/CallInformation 
.const [223] = Utf8 getTelRemNumberType 
.const [224] = Utf8 ()I 
.const [225] = Utf8 org/dsi/ifc/telephoneng/CallInformation 
.const [226] = Utf8 getTelCallStartingTime 
.const [227] = Utf8 ()I 
.const [228] = Utf8 org/dsi/ifc/telephoneng/CallInformation 
.const [229] = Utf8 getExtendedCallInformation 
.const [230] = Utf8 ()Lorg/dsi/ifc/telephoneng/CallInformationExt; 
.const [231] = Utf8 org/dsi/ifc/telephoneng/CallInformation 
.const [232] = Utf8 getTelCallCarrier 
.const [233] = Utf8 ()I 
.const [234] = Utf8 java/lang/Object 
.const [235] = Utf8 <init> 
.const [236] = Utf8 ()V 
.const [237] = Utf8 org/dsi/ifc/telephoneng/CallInformation 
.const [238] = Utf8 <init> 
.const [239] = Utf8 ()V 
.const [240] = Utf8 de/esolutions/fw/util/serializer/ISerializer 
.const [241] = Utf8 putBool 
.const [242] = Utf8 (Z)V 
.const [243] = Utf8 de/esolutions/fw/util/serializer/ISerializer 
.const [244] = Utf8 putInt16 
.const [245] = Utf8 (S)V 
.const [246] = Utf8 de/esolutions/fw/util/serializer/ISerializer 
.const [247] = Utf8 putInt32 
.const [248] = Utf8 (I)V 
.const [249] = Utf8 de/esolutions/fw/util/serializer/ISerializer 
.const [250] = Utf8 putOptionalString 
.const [251] = Utf8 (Ljava/lang/String;)V 
.const [252] = Utf8 de/esolutions/fw/util/serializer/ISerializer 
.const [253] = Utf8 putInt64 
.const [254] = Utf8 (J)V 
.const [255] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [256] = Utf8 getBool 
.const [257] = Utf8 ()Z 
.const [258] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [259] = Utf8 getInt16 
.const [260] = Utf8 ()S 
.const [261] = Utf8 org/dsi/ifc/telephoneng/CallInformation 
.const [262] = Utf8 telCallID 
.const [263] = Utf8 S 
.const [264] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [265] = Utf8 getInt32 
.const [266] = Utf8 ()I 
.const [267] = Utf8 org/dsi/ifc/telephoneng/CallInformation 
.const [268] = Utf8 telCallState 
.const [269] = Utf8 I 
.const [270] = Utf8 org/dsi/ifc/telephoneng/CallInformation 
.const [271] = Utf8 telMpty 
.const [272] = Utf8 I 
.const [273] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [274] = Utf8 getOptionalString 
.const [275] = Utf8 ()Ljava/lang/String; 
.const [276] = Utf8 org/dsi/ifc/telephoneng/CallInformation 
.const [277] = Utf8 telRemName 
.const [278] = Utf8 Ljava/lang/String; 
.const [279] = Utf8 org/dsi/ifc/telephoneng/CallInformation 
.const [280] = Utf8 telRemLastName 
.const [281] = Utf8 Ljava/lang/String; 
.const [282] = Utf8 org/dsi/ifc/telephoneng/CallInformation 
.const [283] = Utf8 telRemFirstName 
.const [284] = Utf8 Ljava/lang/String; 
.const [285] = Utf8 org/dsi/ifc/telephoneng/CallInformation 
.const [286] = Utf8 telRemOrganization 
.const [287] = Utf8 Ljava/lang/String; 
.const [288] = Utf8 org/dsi/ifc/telephoneng/CallInformation 
.const [289] = Utf8 telRemNumber 
.const [290] = Utf8 Ljava/lang/String; 
.const [291] = Utf8 org/dsi/ifc/telephoneng/CallInformation 
.const [292] = Utf8 telRemPictureId 
.const [293] = Utf8 Lorg/dsi/ifc/global/ResourceLocator; 
.const [294] = Utf8 org/dsi/ifc/telephoneng/CallInformation 
.const [295] = Utf8 telNumType 
.const [296] = Utf8 S 
.const [297] = Utf8 org/dsi/ifc/telephoneng/CallInformation 
.const [298] = Utf8 telCallType 
.const [299] = Utf8 I 
.const [300] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [301] = Utf8 getInt64 
.const [302] = Utf8 ()J 
.const [303] = Utf8 org/dsi/ifc/telephoneng/CallInformation 
.const [304] = Utf8 telRemEntryId 
.const [305] = Utf8 J 
.const [306] = Utf8 org/dsi/ifc/telephoneng/CallInformation 
.const [307] = Utf8 telRemNumberType 
.const [308] = Utf8 I 
.const [309] = Utf8 org/dsi/ifc/telephoneng/CallInformation 
.const [310] = Utf8 telCallStartingTime 
.const [311] = Utf8 I 
.const [312] = Utf8 org/dsi/ifc/telephoneng/CallInformation 
.const [313] = Utf8 extendedCallInformation 
.const [314] = Utf8 Lorg/dsi/ifc/telephoneng/CallInformationExt; 
.const [315] = Utf8 org/dsi/ifc/telephoneng/CallInformation 
.const [316] = Utf8 telCallCarrier 
.const [317] = Utf8 I 
.const [318] = Utf8 de/esolutions/fw/comm/dsi/telephoneng/impl/CallInformationSerializer 
.const [319] = Class [318] 
.const [320] = Utf8 java/lang/Object 
.const [321] = Class [320] 
.const [322] = Utf8 Code 
.const [323] = Utf8 <init> 
.const [324] = Utf8 ()V 
.const [325] = Utf8 putOptionalCallInformation 
.const [326] = Utf8 (Lde/esolutions/fw/util/serializer/ISerializer;Lorg/dsi/ifc/telephoneng/CallInformation;)V 
.const [327] = Utf8 putOptionalCallInformationVarArray 
.const [328] = Utf8 (Lde/esolutions/fw/util/serializer/ISerializer;[Lorg/dsi/ifc/telephoneng/CallInformation;)V 
.const [329] = Utf8 getOptionalCallInformation 
.const [330] = Utf8 (Lde/esolutions/fw/util/serializer/IDeserializer;)Lorg/dsi/ifc/telephoneng/CallInformation; 
.const [331] = Utf8 getOptionalCallInformationVarArray 
.const [332] = Utf8 (Lde/esolutions/fw/util/serializer/IDeserializer;)[Lorg/dsi/ifc/telephoneng/CallInformation; 
.end class 
