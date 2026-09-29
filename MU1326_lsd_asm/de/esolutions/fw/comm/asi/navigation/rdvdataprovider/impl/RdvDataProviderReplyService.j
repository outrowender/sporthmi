.version 50 0 
.class public super [233] 
.super [235] 
.field private static final [236] [237] 
.field private static [238] [239] 
.field private [240] [241] 

.method public [243] : [244] 
    .attribute [242] .code stack 7 locals 0 
L0:     aload_0 
L1:     new [40] 
L4:     dup 
L5:     ldc [3] 
L7:     invokestatic [4] 
L10:    ldc [5] 
L12:    ldc [6] 
L14:    invokespecial [34] 
L17:    invokespecial [35] 
L20:    aload_0 
L21:    aload_1 
L22:    putfield [41] 
L25:    return 
L26:    nop 
L27:    nop 
L28:    
    .end code 
.end method 

.method private static synchronized [245] : [246] 
    .attribute [242] .code stack 2 locals 1 
L0:     getstatic [7] 
L3:     iconst_1 
L4:     iadd 
L5:     dup 
L6:     putstatic [36] 
L9:     istore_0 
L10:    iload_0 
L11:    areturn 
L12:    
    .end code 
.end method 

.method public [247] : [248] 
    .attribute [242] .code stack 1 locals 0 
L0:     getstatic [8] 
L3:     areturn 
L4:     
    .end code 
.end method 

.method public [249] : [250] 
    .attribute [242] .code stack 4 locals 2 
        .catch [16] from L0 to L293 using L296 
L0:     iload_1 
L1:     tableswitch 1 
            L246 
            L266 
            L68 
            L266 
            L90 
            L176 
            L266 
            L112 
            L134 
            L156 
            L196 
            L266 
            L216 
            default : L266 

L68:    aload_2 
L69:    invokeinterface [42] 0 
L74:    istore 4 
L76:    aload_0 
L77:    getfield [29] 
L80:    iload 4 
L82:    invokeinterface [43] 0 
L87:    goto L293 
L90:    aload_2 
L91:    invokeinterface [42] 0 
L96:    istore 4 
L98:    aload_0 
L99:    getfield [29] 
L102:   iload 4 
L104:   invokeinterface [44] 0 
L109:   goto L293 
L112:   aload_2 
L113:   invokeinterface [45] 0 
L118:   istore 4 
L120:   aload_0 
L121:   getfield [29] 
L124:   iload 4 
L126:   invokeinterface [46] 0 
L131:   goto L293 
L134:   aload_2 
L135:   invokeinterface [45] 0 
L140:   istore 4 
L142:   aload_0 
L143:   getfield [29] 
L146:   iload 4 
L148:   invokeinterface [47] 0 
L153:   goto L293 
L156:   aload_2 
L157:   invokestatic [9] 
L160:   astore 4 
L162:   aload_0 
L163:   getfield [29] 
L166:   aload 4 
L168:   invokeinterface [48] 0 
L173:   goto L293 
L176:   aload_2 
L177:   invokestatic [10] 
L180:   astore 4 
L182:   aload_0 
L183:   getfield [29] 
L186:   aload 4 
L188:   invokeinterface [49] 0 
L193:   goto L293 
L196:   aload_2 
L197:   invokestatic [10] 
L200:   astore 4 
L202:   aload_0 
L203:   getfield [29] 
L206:   aload 4 
L208:   invokeinterface [50] 0 
L213:   goto L293 
L216:   aload_2 
L217:   invokestatic [11] 
L220:   astore 4 
L222:   aload_2 
L223:   invokeinterface [42] 0 
L228:   istore 5 
L230:   aload_0 
L231:   getfield [29] 
L234:   aload 4 
L236:   iload 5 
L238:   invokeinterface [51] 0 
L243:   goto L293 
L246:   aload_2 
L247:   invokestatic [12] 
L250:   astore 4 
L252:   aload_0 
L253:   getfield [29] 
L256:   aload 4 
L258:   invokeinterface [52] 0 
L263:   goto L293 
L266:   new [53] 
L269:   dup 
L270:   new [54] 
L273:   dup 
L274:   invokespecial [38] 
L277:   ldc [15] 
L279:   invokevirtual [30] 
L282:   iload_1 
L283:   invokevirtual [31] 
L286:   invokevirtual [32] 
L289:   invokespecial [39] 
L292:   athrow 
L293:   goto L338 
L296:   astore 4 
L298:   new [53] 
L301:   dup 
L302:   new [54] 
L305:   dup 
L306:   invokespecial [38] 
L309:   ldc [17] 
L311:   invokevirtual [30] 
L314:   iload_1 
L315:   invokevirtual [31] 
L318:   ldc [18] 
L320:   invokevirtual [30] 
L323:   aload 4 
L325:   invokevirtual [33] 
L328:   invokevirtual [30] 
L331:   invokevirtual [32] 
L334:   invokespecial [39] 
L337:   athrow 
L338:   return 
L339:   nop 
L340:   
    .end code 
.end method 

.method static [251] : [252] 
    .attribute [242] .code stack 1 locals 0 
L0:     ldc [19] 
L2:     invokestatic [20] 
L5:     putstatic [37] 
L8:     iconst_0 
L9:     putstatic [36] 
L12:    return 
L13:    nop 
L14:    nop 
L15:    nop 
L16:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [55] 
.const [3] = String [56] 
.const [4] = Method [57] [58] 
.const [5] = String [59] 
.const [6] = String [60] 
.const [7] = Field [61] [62] 
.const [8] = Field [63] [64] 
.const [9] = Method [65] [66] 
.const [10] = Method [67] [68] 
.const [11] = Method [69] [70] 
.const [12] = Method [71] [72] 
.const [13] = Class [73] 
.const [14] = Class [74] 
.const [15] = String [75] 
.const [16] = Class [76] 
.const [17] = String [77] 
.const [18] = String [78] 
.const [19] = String [79] 
.const [20] = Method [80] [81] 
.const [21] = Class [82] 
.const [22] = Class [83] 
.const [23] = Class [84] 
.const [24] = Class [85] 
.const [25] = Class [86] 
.const [26] = Class [87] 
.const [27] = Class [88] 
.const [28] = Class [89] 
.const [29] = Field [90] [91] 
.const [30] = Method [92] [93] 
.const [31] = Method [94] [95] 
.const [32] = Method [96] [97] 
.const [33] = Method [98] [99] 
.const [34] = Method [100] [101] 
.const [35] = Method [102] [103] 
.const [36] = Field [104] [105] 
.const [37] = Field [106] [107] 
.const [38] = Method [108] [109] 
.const [39] = Method [110] [111] 
.const [40] = Class [112] 
.const [41] = Field [113] [114] 
.const [42] = InterfaceMethod [115] [116] 
.const [43] = InterfaceMethod [117] [118] 
.const [44] = InterfaceMethod [119] [120] 
.const [45] = InterfaceMethod [121] [122] 
.const [46] = InterfaceMethod [123] [124] 
.const [47] = InterfaceMethod [125] [126] 
.const [48] = InterfaceMethod [127] [128] 
.const [49] = InterfaceMethod [129] [130] 
.const [50] = InterfaceMethod [131] [132] 
.const [51] = InterfaceMethod [133] [134] 
.const [52] = InterfaceMethod [135] [136] 
.const [53] = Class [137] 
.const [54] = Class [138] 
.const [55] = Utf8 de/esolutions/fw/comm/core/ServiceInstanceID 
.const [56] = Utf8 '3ee92857-84ba-4dfa-9faf-1d67977f4b5d' 
.const [57] = Class [139] 
.const [58] = NameAndType [140] [141] 
.const [59] = Utf8 '0b921357-9ff8-587c-9c54-67ccfc58e880' 
.const [60] = Utf8 'asi.navigation.rdvdataprovider.RdvDataProvider' 
.const [61] = Class [142] 
.const [62] = NameAndType [143] [144] 
.const [63] = Class [145] 
.const [64] = NameAndType [146] [147] 
.const [65] = Class [148] 
.const [66] = NameAndType [149] [150] 
.const [67] = Class [151] 
.const [68] = NameAndType [152] [153] 
.const [69] = Class [154] 
.const [70] = NameAndType [155] [156] 
.const [71] = Class [157] 
.const [72] = NameAndType [158] [159] 
.const [73] = Utf8 de/esolutions/fw/comm/core/method/MethodException 
.const [74] = Utf8 java/lang/StringBuffer 
.const [75] = Utf8 'Invalid Method Id ' 
.const [76] = Utf8 de/esolutions/fw/util/serializer/exception/SerializerException 
.const [77] = Utf8 'Deserialization failed: method=' 
.const [78] = Utf8 ', error=' 
.const [79] = Utf8 'STUB.asi.navigation.rdvdataprovider.RdvDataProvider' 
.const [80] = Class [160] 
.const [81] = NameAndType [161] [162] 
.const [82] = Utf8 de/esolutions/fw/comm/asi/navigation/rdvdataprovider/impl/RdvDataProviderReplyService 
.const [83] = Utf8 de/esolutions/fw/comm/core/AbstractReplyService 
.const [84] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [85] = Utf8 de/esolutions/fw/comm/asi/navigation/rdvdataprovider/RdvDataProviderReply 
.const [86] = Utf8 de/esolutions/fw/comm/asi/navigation/rdvtypes/impl/RdvRouteOptionsSerializer 
.const [87] = Utf8 de/esolutions/fw/comm/dsi/global/impl/NavLocationWgs84Serializer 
.const [88] = Utf8 de/esolutions/fw/comm/asi/navigation/rdvdataprovider/impl/RouteProviderSettingSerializer 
.const [89] = Utf8 de/esolutions/fw/comm/core/CallContext 
.const [90] = Class [163] 
.const [91] = NameAndType [164] [165] 
.const [92] = Class [166] 
.const [93] = NameAndType [167] [168] 
.const [94] = Class [169] 
.const [95] = NameAndType [170] [171] 
.const [96] = Class [172] 
.const [97] = NameAndType [173] [174] 
.const [98] = Class [175] 
.const [99] = NameAndType [176] [177] 
.const [100] = Class [178] 
.const [101] = NameAndType [179] [180] 
.const [102] = Class [181] 
.const [103] = NameAndType [182] [183] 
.const [104] = Class [184] 
.const [105] = NameAndType [185] [186] 
.const [106] = Class [187] 
.const [107] = NameAndType [188] [189] 
.const [108] = Class [190] 
.const [109] = NameAndType [191] [192] 
.const [110] = Class [193] 
.const [111] = NameAndType [194] [195] 
.const [112] = Utf8 de/esolutions/fw/comm/core/ServiceInstanceID 
.const [113] = Class [196] 
.const [114] = NameAndType [197] [198] 
.const [115] = Class [199] 
.const [116] = NameAndType [200] [201] 
.const [117] = Class [202] 
.const [118] = NameAndType [203] [204] 
.const [119] = Class [205] 
.const [120] = NameAndType [206] [207] 
.const [121] = Class [208] 
.const [122] = NameAndType [209] [210] 
.const [123] = Class [211] 
.const [124] = NameAndType [212] [213] 
.const [125] = Class [214] 
.const [126] = NameAndType [215] [216] 
.const [127] = Class [217] 
.const [128] = NameAndType [218] [219] 
.const [129] = Class [220] 
.const [130] = NameAndType [221] [222] 
.const [131] = Class [223] 
.const [132] = NameAndType [224] [225] 
.const [133] = Class [226] 
.const [134] = NameAndType [227] [228] 
.const [135] = Class [229] 
.const [136] = NameAndType [230] [231] 
.const [137] = Utf8 de/esolutions/fw/comm/core/method/MethodException 
.const [138] = Utf8 java/lang/StringBuffer 
.const [139] = Utf8 de/esolutions/fw/comm/asi/navigation/rdvdataprovider/impl/RdvDataProviderReplyService 
.const [140] = Utf8 nextDynamicHandle 
.const [141] = Utf8 ()I 
.const [142] = Utf8 de/esolutions/fw/comm/asi/navigation/rdvdataprovider/impl/RdvDataProviderReplyService 
.const [143] = Utf8 dynamicHandle 
.const [144] = Utf8 I 
.const [145] = Utf8 de/esolutions/fw/comm/asi/navigation/rdvdataprovider/impl/RdvDataProviderReplyService 
.const [146] = Utf8 context 
.const [147] = Utf8 Lde/esolutions/fw/comm/core/CallContext; 
.const [148] = Utf8 de/esolutions/fw/comm/asi/navigation/rdvtypes/impl/RdvRouteOptionsSerializer 
.const [149] = Utf8 getOptionalRdvRouteOptions 
.const [150] = Utf8 (Lde/esolutions/fw/util/serializer/IDeserializer;)Lde/esolutions/fw/comm/asi/navigation/rdvtypes/RdvRouteOptions; 
.const [151] = Utf8 de/esolutions/fw/comm/dsi/global/impl/NavLocationWgs84Serializer 
.const [152] = Utf8 getOptionalNavLocationWgs84VarArray 
.const [153] = Utf8 (Lde/esolutions/fw/util/serializer/IDeserializer;)[Lorg/dsi/ifc/global/NavLocationWgs84; 
.const [154] = Utf8 de/esolutions/fw/comm/asi/navigation/rdvdataprovider/impl/RouteProviderSettingSerializer 
.const [155] = Utf8 getOptionalRouteProviderSetting 
.const [156] = Utf8 (Lde/esolutions/fw/util/serializer/IDeserializer;)Lde/esolutions/fw/comm/asi/navigation/rdvdataprovider/RouteProviderSetting; 
.const [157] = Utf8 de/esolutions/fw/comm/dsi/global/impl/NavLocationWgs84Serializer 
.const [158] = Utf8 getOptionalNavLocationWgs84 
.const [159] = Utf8 (Lde/esolutions/fw/util/serializer/IDeserializer;)Lorg/dsi/ifc/global/NavLocationWgs84; 
.const [160] = Utf8 de/esolutions/fw/comm/core/CallContext 
.const [161] = Utf8 getContext 
.const [162] = Utf8 (Ljava/lang/String;)Lde/esolutions/fw/comm/core/CallContext; 
.const [163] = Utf8 de/esolutions/fw/comm/asi/navigation/rdvdataprovider/impl/RdvDataProviderReplyService 
.const [164] = Utf8 p_RdvDataProviderReply 
.const [165] = Utf8 Lde/esolutions/fw/comm/asi/navigation/rdvdataprovider/RdvDataProviderReply; 
.const [166] = Utf8 java/lang/StringBuffer 
.const [167] = Utf8 append 
.const [168] = Utf8 (Ljava/lang/String;)Ljava/lang/StringBuffer; 
.const [169] = Utf8 java/lang/StringBuffer 
.const [170] = Utf8 append 
.const [171] = Utf8 (I)Ljava/lang/StringBuffer; 
.const [172] = Utf8 java/lang/StringBuffer 
.const [173] = Utf8 toString 
.const [174] = Utf8 ()Ljava/lang/String; 
.const [175] = Utf8 de/esolutions/fw/util/serializer/exception/SerializerException 
.const [176] = Utf8 getMessage 
.const [177] = Utf8 ()Ljava/lang/String; 
.const [178] = Utf8 de/esolutions/fw/comm/core/ServiceInstanceID 
.const [179] = Utf8 <init> 
.const [180] = Utf8 (Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V 
.const [181] = Utf8 de/esolutions/fw/comm/core/AbstractReplyService 
.const [182] = Utf8 <init> 
.const [183] = Utf8 (Lde/esolutions/fw/comm/core/ServiceInstanceID;)V 
.const [184] = Utf8 de/esolutions/fw/comm/asi/navigation/rdvdataprovider/impl/RdvDataProviderReplyService 
.const [185] = Utf8 dynamicHandle 
.const [186] = Utf8 I 
.const [187] = Utf8 de/esolutions/fw/comm/asi/navigation/rdvdataprovider/impl/RdvDataProviderReplyService 
.const [188] = Utf8 context 
.const [189] = Utf8 Lde/esolutions/fw/comm/core/CallContext; 
.const [190] = Utf8 java/lang/StringBuffer 
.const [191] = Utf8 <init> 
.const [192] = Utf8 ()V 
.const [193] = Utf8 de/esolutions/fw/comm/core/method/MethodException 
.const [194] = Utf8 <init> 
.const [195] = Utf8 (Ljava/lang/String;)V 
.const [196] = Utf8 de/esolutions/fw/comm/asi/navigation/rdvdataprovider/impl/RdvDataProviderReplyService 
.const [197] = Utf8 p_RdvDataProviderReply 
.const [198] = Utf8 Lde/esolutions/fw/comm/asi/navigation/rdvdataprovider/RdvDataProviderReply; 
.const [199] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [200] = Utf8 getEnum 
.const [201] = Utf8 ()I 
.const [202] = Utf8 de/esolutions/fw/comm/asi/navigation/rdvdataprovider/RdvDataProviderReply 
.const [203] = Utf8 registerForDataUpdateResult 
.const [204] = Utf8 (I)V 
.const [205] = Utf8 de/esolutions/fw/comm/asi/navigation/rdvdataprovider/RdvDataProviderReply 
.const [206] = Utf8 unregisterForDataUpdateResult 
.const [207] = Utf8 (I)V 
.const [208] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [209] = Utf8 getBool 
.const [210] = Utf8 ()Z 
.const [211] = Utf8 de/esolutions/fw/comm/asi/navigation/rdvdataprovider/RdvDataProviderReply 
.const [212] = Utf8 updateDemoModeStatus 
.const [213] = Utf8 (Z)V 
.const [214] = Utf8 de/esolutions/fw/comm/asi/navigation/rdvdataprovider/RdvDataProviderReply 
.const [215] = Utf8 updateRouteGuidanceStatus 
.const [216] = Utf8 (Z)V 
.const [217] = Utf8 de/esolutions/fw/comm/asi/navigation/rdvdataprovider/RdvDataProviderReply 
.const [218] = Utf8 updateCurrentRouteOptions 
.const [219] = Utf8 (Lde/esolutions/fw/comm/asi/navigation/rdvtypes/RdvRouteOptions;)V 
.const [220] = Utf8 de/esolutions/fw/comm/asi/navigation/rdvdataprovider/RdvDataProviderReply 
.const [221] = Utf8 updateCurrentRoute 
.const [222] = Utf8 ([Lorg/dsi/ifc/global/NavLocationWgs84;)V 
.const [223] = Utf8 de/esolutions/fw/comm/asi/navigation/rdvdataprovider/RdvDataProviderReply 
.const [224] = Utf8 updateStopovers 
.const [225] = Utf8 ([Lorg/dsi/ifc/global/NavLocationWgs84;)V 
.const [226] = Utf8 de/esolutions/fw/comm/asi/navigation/rdvdataprovider/RdvDataProviderReply 
.const [227] = Utf8 setRouteProviderSettingResult 
.const [228] = Utf8 (Lde/esolutions/fw/comm/asi/navigation/rdvdataprovider/RouteProviderSetting;I)V 
.const [229] = Utf8 de/esolutions/fw/comm/asi/navigation/rdvdataprovider/RdvDataProviderReply 
.const [230] = Utf8 getCurrentPositionResult 
.const [231] = Utf8 (Lorg/dsi/ifc/global/NavLocationWgs84;)V 
.const [232] = Utf8 de/esolutions/fw/comm/asi/navigation/rdvdataprovider/impl/RdvDataProviderReplyService 
.const [233] = Class [232] 
.const [234] = Utf8 de/esolutions/fw/comm/core/AbstractReplyService 
.const [235] = Class [234] 
.const [236] = Utf8 context 
.const [237] = Utf8 Lde/esolutions/fw/comm/core/CallContext; 
.const [238] = Utf8 dynamicHandle 
.const [239] = Utf8 I 
.const [240] = Utf8 p_RdvDataProviderReply 
.const [241] = Utf8 Lde/esolutions/fw/comm/asi/navigation/rdvdataprovider/RdvDataProviderReply; 
.const [242] = Utf8 Code 
.const [243] = Utf8 <init> 
.const [244] = Utf8 (Lde/esolutions/fw/comm/asi/navigation/rdvdataprovider/RdvDataProviderReply;)V 
.const [245] = Utf8 nextDynamicHandle 
.const [246] = Utf8 ()I 
.const [247] = Utf8 getCallContext 
.const [248] = Utf8 ()Lde/esolutions/fw/comm/core/CallContext; 
.const [249] = Utf8 handleCallMethod 
.const [250] = Utf8 (SLde/esolutions/fw/util/serializer/IDeserializer;Lde/esolutions/fw/comm/core/IProxyFrontend;)V 
.const [251] = Utf8 <clinit> 
.const [252] = Utf8 ()V 
.end class 
