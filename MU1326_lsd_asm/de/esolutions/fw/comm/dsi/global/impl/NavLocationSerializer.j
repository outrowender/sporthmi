.version 50 0 
.class public super [293] 
.super [295] 

.method public annotation [297] : [298] 
    .attribute [296] .code stack 1 locals 0 
L0:     aload_0 
L1:     invokespecial [29] 
L4:     return 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public static [299] : [300] 
    .attribute [296] .code stack 2 locals 18 
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
L25:    astore_3 
L26:    aload_0 
L27:    aload_3 
L28:    invokeinterface [32] 0 
L33:    aload_1 
L34:    invokevirtual [13] 
L37:    istore 4 
L39:    aload_0 
L40:    iload 4 
L42:    invokeinterface [31] 0 
L47:    aload_1 
L48:    invokevirtual [14] 
L51:    istore 5 
L53:    aload_0 
L54:    iload 5 
L56:    invokeinterface [31] 0 
L61:    aload_1 
L62:    invokevirtual [15] 
L65:    istore 6 
L67:    aload_0 
L68:    iload 6 
L70:    invokeinterface [33] 0 
L75:    aload_1 
L76:    invokevirtual [16] 
L79:    istore 7 
L81:    aload_0 
L82:    iload 7 
L84:    invokeinterface [33] 0 
L89:    aload_1 
L90:    invokevirtual [17] 
L93:    istore 8 
L95:    aload_0 
L96:    iload 8 
L98:    invokeinterface [33] 0 
L103:   aload_1 
L104:   invokevirtual [18] 
L107:   astore 9 
L109:   aload_0 
L110:   aload 9 
L112:   invokeinterface [32] 0 
L117:   aload_1 
L118:   invokevirtual [19] 
L121:   astore 10 
L123:   aload_0 
L124:   aload 10 
L126:   invokeinterface [32] 0 
L131:   aload_1 
L132:   invokevirtual [20] 
L135:   astore 11 
L137:   aload_0 
L138:   aload 11 
L140:   invokeinterface [32] 0 
L145:   aload_1 
L146:   invokevirtual [21] 
L149:   astore 12 
L151:   aload_0 
L152:   aload 12 
L154:   invokeinterface [32] 0 
L159:   aload_1 
L160:   invokevirtual [22] 
L163:   astore 13 
L165:   aload_0 
L166:   aload 13 
L168:   invokeinterface [32] 0 
L173:   aload_1 
L174:   invokevirtual [23] 
L177:   astore 14 
L179:   aload_0 
L180:   aload 14 
L182:   invokeinterface [32] 0 
L187:   aload_1 
L188:   invokevirtual [24] 
L191:   astore 15 
L193:   aload_0 
L194:   aload 15 
L196:   invokeinterface [32] 0 
L201:   aload_1 
L202:   invokevirtual [25] 
L205:   astore 16 
L207:   aload_0 
L208:   aload 16 
L210:   invokeinterface [32] 0 
L215:   aload_1 
L216:   invokevirtual [26] 
L219:   astore 17 
L221:   aload_0 
L222:   aload 17 
L224:   invokeinterface [32] 0 
L229:   aload_1 
L230:   invokevirtual [27] 
L233:   astore 18 
L235:   aload_0 
L236:   aload 18 
L238:   invokeinterface [32] 0 
L243:   aload_1 
L244:   invokevirtual [28] 
L247:   astore 19 
L249:   aload_0 
L250:   aload 19 
L252:   invokestatic [2] 
L255:   return 
L256:   
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
L12:    invokeinterface [31] 0 
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
    .attribute [296] .code stack 2 locals 19 
L0:     aconst_null 
L1:     astore_1 
L2:     aload_0 
L3:     invokeinterface [34] 0 
L8:     istore_2 
L9:     iload_2 
L10:    ifne L255 
L13:    new [35] 
L16:    dup 
L17:    invokespecial [30] 
L20:    astore_1 
L21:    aload_0 
L22:    invokeinterface [36] 0 
L27:    astore_3 
L28:    aload_1 
L29:    aload_3 
L30:    putfield [37] 
L33:    aload_0 
L34:    invokeinterface [34] 0 
L39:    istore 4 
L41:    aload_1 
L42:    iload 4 
L44:    putfield [38] 
L47:    aload_0 
L48:    invokeinterface [34] 0 
L53:    istore 5 
L55:    aload_1 
L56:    iload 5 
L58:    putfield [39] 
L61:    aload_0 
L62:    invokeinterface [40] 0 
L67:    istore 6 
L69:    aload_1 
L70:    iload 6 
L72:    putfield [41] 
L75:    aload_0 
L76:    invokeinterface [40] 0 
L81:    istore 7 
L83:    aload_1 
L84:    iload 7 
L86:    putfield [42] 
L89:    aload_0 
L90:    invokeinterface [40] 0 
L95:    istore 8 
L97:    aload_1 
L98:    iload 8 
L100:   putfield [43] 
L103:   aload_0 
L104:   invokeinterface [36] 0 
L109:   astore 9 
L111:   aload_1 
L112:   aload 9 
L114:   putfield [44] 
L117:   aload_0 
L118:   invokeinterface [36] 0 
L123:   astore 10 
L125:   aload_1 
L126:   aload 10 
L128:   putfield [45] 
L131:   aload_0 
L132:   invokeinterface [36] 0 
L137:   astore 11 
L139:   aload_1 
L140:   aload 11 
L142:   putfield [46] 
L145:   aload_0 
L146:   invokeinterface [36] 0 
L151:   astore 12 
L153:   aload_1 
L154:   aload 12 
L156:   putfield [47] 
L159:   aload_0 
L160:   invokeinterface [36] 0 
L165:   astore 13 
L167:   aload_1 
L168:   aload 13 
L170:   putfield [48] 
L173:   aload_0 
L174:   invokeinterface [36] 0 
L179:   astore 14 
L181:   aload_1 
L182:   aload 14 
L184:   putfield [49] 
L187:   aload_0 
L188:   invokeinterface [36] 0 
L193:   astore 15 
L195:   aload_1 
L196:   aload 15 
L198:   putfield [50] 
L201:   aload_0 
L202:   invokeinterface [36] 0 
L207:   astore 16 
L209:   aload_1 
L210:   aload 16 
L212:   putfield [51] 
L215:   aload_0 
L216:   invokeinterface [36] 0 
L221:   astore 17 
L223:   aload_1 
L224:   aload 17 
L226:   putfield [52] 
L229:   aload_0 
L230:   invokeinterface [36] 0 
L235:   astore 18 
L237:   aload_1 
L238:   aload 18 
L240:   putfield [53] 
L243:   aload_0 
L244:   invokestatic [5] 
L247:   astore 19 
L249:   aload_1 
L250:   aload 19 
L252:   putfield [54] 
L255:   aload_1 
L256:   areturn 
L257:   nop 
L258:   nop 
L259:   nop 
L260:   
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
L14:    invokeinterface [40] 0 
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
.const [27] = Method [99] [100] 
.const [28] = Method [101] [102] 
.const [29] = Method [103] [104] 
.const [30] = Method [105] [106] 
.const [31] = InterfaceMethod [107] [108] 
.const [32] = InterfaceMethod [109] [110] 
.const [33] = InterfaceMethod [111] [112] 
.const [34] = InterfaceMethod [113] [114] 
.const [35] = Class [115] 
.const [36] = InterfaceMethod [116] [117] 
.const [37] = Field [118] [119] 
.const [38] = Field [120] [121] 
.const [39] = Field [122] [123] 
.const [40] = InterfaceMethod [124] [125] 
.const [41] = Field [126] [127] 
.const [42] = Field [128] [129] 
.const [43] = Field [130] [131] 
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
.const [55] = Class [154] 
.const [56] = NameAndType [155] [156] 
.const [57] = Class [157] 
.const [58] = NameAndType [158] [159] 
.const [59] = Utf8 org/dsi/ifc/global/NavLocation 
.const [60] = Class [160] 
.const [61] = NameAndType [161] [162] 
.const [62] = Class [163] 
.const [63] = NameAndType [164] [165] 
.const [64] = Utf8 de/esolutions/fw/comm/dsi/global/impl/NavLocationSerializer 
.const [65] = Utf8 java/lang/Object 
.const [66] = Utf8 de/esolutions/fw/util/serializer/ISerializer 
.const [67] = Utf8 de/esolutions/fw/comm/dsi/global/impl/NavLocationDescriptorSerializer 
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
.const [115] = Utf8 org/dsi/ifc/global/NavLocation 
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
.const [154] = Utf8 de/esolutions/fw/comm/dsi/global/impl/NavLocationDescriptorSerializer 
.const [155] = Utf8 putOptionalNavLocationDescriptorVarArray 
.const [156] = Utf8 (Lde/esolutions/fw/util/serializer/ISerializer;[Lorg/dsi/ifc/global/NavLocationDescriptor;)V 
.const [157] = Utf8 de/esolutions/fw/comm/dsi/global/impl/NavLocationSerializer 
.const [158] = Utf8 putOptionalNavLocation 
.const [159] = Utf8 (Lde/esolutions/fw/util/serializer/ISerializer;Lorg/dsi/ifc/global/NavLocation;)V 
.const [160] = Utf8 de/esolutions/fw/comm/dsi/global/impl/NavLocationDescriptorSerializer 
.const [161] = Utf8 getOptionalNavLocationDescriptorVarArray 
.const [162] = Utf8 (Lde/esolutions/fw/util/serializer/IDeserializer;)[Lorg/dsi/ifc/global/NavLocationDescriptor; 
.const [163] = Utf8 de/esolutions/fw/comm/dsi/global/impl/NavLocationSerializer 
.const [164] = Utf8 getOptionalNavLocation 
.const [165] = Utf8 (Lde/esolutions/fw/util/serializer/IDeserializer;)Lorg/dsi/ifc/global/NavLocation; 
.const [166] = Utf8 org/dsi/ifc/global/NavLocation 
.const [167] = Utf8 getVersion 
.const [168] = Utf8 ()Ljava/lang/String; 
.const [169] = Utf8 org/dsi/ifc/global/NavLocation 
.const [170] = Utf8 isVersionOfLocationStructureValid 
.const [171] = Utf8 ()Z 
.const [172] = Utf8 org/dsi/ifc/global/NavLocation 
.const [173] = Utf8 isPositionValid 
.const [174] = Utf8 ()Z 
.const [175] = Utf8 org/dsi/ifc/global/NavLocation 
.const [176] = Utf8 getLongitude 
.const [177] = Utf8 ()I 
.const [178] = Utf8 org/dsi/ifc/global/NavLocation 
.const [179] = Utf8 getLatitude 
.const [180] = Utf8 ()I 
.const [181] = Utf8 org/dsi/ifc/global/NavLocation 
.const [182] = Utf8 getAltitude 
.const [183] = Utf8 ()I 
.const [184] = Utf8 org/dsi/ifc/global/NavLocation 
.const [185] = Utf8 getCountry 
.const [186] = Utf8 ()Ljava/lang/String; 
.const [187] = Utf8 org/dsi/ifc/global/NavLocation 
.const [188] = Utf8 getCountryAbbreviation 
.const [189] = Utf8 ()Ljava/lang/String; 
.const [190] = Utf8 org/dsi/ifc/global/NavLocation 
.const [191] = Utf8 getHousenumber 
.const [192] = Utf8 ()Ljava/lang/String; 
.const [193] = Utf8 org/dsi/ifc/global/NavLocation 
.const [194] = Utf8 getJunction 
.const [195] = Utf8 ()Ljava/lang/String; 
.const [196] = Utf8 org/dsi/ifc/global/NavLocation 
.const [197] = Utf8 getStreet 
.const [198] = Utf8 ()Ljava/lang/String; 
.const [199] = Utf8 org/dsi/ifc/global/NavLocation 
.const [200] = Utf8 getStreetRefinement 
.const [201] = Utf8 ()Ljava/lang/String; 
.const [202] = Utf8 org/dsi/ifc/global/NavLocation 
.const [203] = Utf8 getTown 
.const [204] = Utf8 ()Ljava/lang/String; 
.const [205] = Utf8 org/dsi/ifc/global/NavLocation 
.const [206] = Utf8 getTowncenter 
.const [207] = Utf8 ()Ljava/lang/String; 
.const [208] = Utf8 org/dsi/ifc/global/NavLocation 
.const [209] = Utf8 getTownRefinement 
.const [210] = Utf8 ()Ljava/lang/String; 
.const [211] = Utf8 org/dsi/ifc/global/NavLocation 
.const [212] = Utf8 getZipCode 
.const [213] = Utf8 ()Ljava/lang/String; 
.const [214] = Utf8 org/dsi/ifc/global/NavLocation 
.const [215] = Utf8 getProprietaryData 
.const [216] = Utf8 ()[Lorg/dsi/ifc/global/NavLocationDescriptor; 
.const [217] = Utf8 java/lang/Object 
.const [218] = Utf8 <init> 
.const [219] = Utf8 ()V 
.const [220] = Utf8 org/dsi/ifc/global/NavLocation 
.const [221] = Utf8 <init> 
.const [222] = Utf8 ()V 
.const [223] = Utf8 de/esolutions/fw/util/serializer/ISerializer 
.const [224] = Utf8 putBool 
.const [225] = Utf8 (Z)V 
.const [226] = Utf8 de/esolutions/fw/util/serializer/ISerializer 
.const [227] = Utf8 putOptionalString 
.const [228] = Utf8 (Ljava/lang/String;)V 
.const [229] = Utf8 de/esolutions/fw/util/serializer/ISerializer 
.const [230] = Utf8 putInt32 
.const [231] = Utf8 (I)V 
.const [232] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [233] = Utf8 getBool 
.const [234] = Utf8 ()Z 
.const [235] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [236] = Utf8 getOptionalString 
.const [237] = Utf8 ()Ljava/lang/String; 
.const [238] = Utf8 org/dsi/ifc/global/NavLocation 
.const [239] = Utf8 version 
.const [240] = Utf8 Ljava/lang/String; 
.const [241] = Utf8 org/dsi/ifc/global/NavLocation 
.const [242] = Utf8 versionOfLocationStructureValid 
.const [243] = Utf8 Z 
.const [244] = Utf8 org/dsi/ifc/global/NavLocation 
.const [245] = Utf8 positionValid 
.const [246] = Utf8 Z 
.const [247] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [248] = Utf8 getInt32 
.const [249] = Utf8 ()I 
.const [250] = Utf8 org/dsi/ifc/global/NavLocation 
.const [251] = Utf8 longitude 
.const [252] = Utf8 I 
.const [253] = Utf8 org/dsi/ifc/global/NavLocation 
.const [254] = Utf8 latitude 
.const [255] = Utf8 I 
.const [256] = Utf8 org/dsi/ifc/global/NavLocation 
.const [257] = Utf8 altitude 
.const [258] = Utf8 I 
.const [259] = Utf8 org/dsi/ifc/global/NavLocation 
.const [260] = Utf8 country 
.const [261] = Utf8 Ljava/lang/String; 
.const [262] = Utf8 org/dsi/ifc/global/NavLocation 
.const [263] = Utf8 countryAbbreviation 
.const [264] = Utf8 Ljava/lang/String; 
.const [265] = Utf8 org/dsi/ifc/global/NavLocation 
.const [266] = Utf8 housenumber 
.const [267] = Utf8 Ljava/lang/String; 
.const [268] = Utf8 org/dsi/ifc/global/NavLocation 
.const [269] = Utf8 junction 
.const [270] = Utf8 Ljava/lang/String; 
.const [271] = Utf8 org/dsi/ifc/global/NavLocation 
.const [272] = Utf8 street 
.const [273] = Utf8 Ljava/lang/String; 
.const [274] = Utf8 org/dsi/ifc/global/NavLocation 
.const [275] = Utf8 streetRefinement 
.const [276] = Utf8 Ljava/lang/String; 
.const [277] = Utf8 org/dsi/ifc/global/NavLocation 
.const [278] = Utf8 town 
.const [279] = Utf8 Ljava/lang/String; 
.const [280] = Utf8 org/dsi/ifc/global/NavLocation 
.const [281] = Utf8 towncenter 
.const [282] = Utf8 Ljava/lang/String; 
.const [283] = Utf8 org/dsi/ifc/global/NavLocation 
.const [284] = Utf8 townRefinement 
.const [285] = Utf8 Ljava/lang/String; 
.const [286] = Utf8 org/dsi/ifc/global/NavLocation 
.const [287] = Utf8 zipCode 
.const [288] = Utf8 Ljava/lang/String; 
.const [289] = Utf8 org/dsi/ifc/global/NavLocation 
.const [290] = Utf8 proprietaryData 
.const [291] = Utf8 [Lorg/dsi/ifc/global/NavLocationDescriptor; 
.const [292] = Utf8 de/esolutions/fw/comm/dsi/global/impl/NavLocationSerializer 
.const [293] = Class [292] 
.const [294] = Utf8 java/lang/Object 
.const [295] = Class [294] 
.const [296] = Utf8 Code 
.const [297] = Utf8 <init> 
.const [298] = Utf8 ()V 
.const [299] = Utf8 putOptionalNavLocation 
.const [300] = Utf8 (Lde/esolutions/fw/util/serializer/ISerializer;Lorg/dsi/ifc/global/NavLocation;)V 
.const [301] = Utf8 putOptionalNavLocationVarArray 
.const [302] = Utf8 (Lde/esolutions/fw/util/serializer/ISerializer;[Lorg/dsi/ifc/global/NavLocation;)V 
.const [303] = Utf8 getOptionalNavLocation 
.const [304] = Utf8 (Lde/esolutions/fw/util/serializer/IDeserializer;)Lorg/dsi/ifc/global/NavLocation; 
.const [305] = Utf8 getOptionalNavLocationVarArray 
.const [306] = Utf8 (Lde/esolutions/fw/util/serializer/IDeserializer;)[Lorg/dsi/ifc/global/NavLocation; 
.end class 
