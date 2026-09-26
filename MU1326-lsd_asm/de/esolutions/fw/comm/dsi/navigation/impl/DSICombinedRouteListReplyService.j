.version 50 0 
.class public super [255] 
.super [257] 
.field private static final [258] [259] 
.field private static [260] [261] 
.field private [262] [263] 

.method public [265] : [266] 
    .attribute [264] .code stack 7 locals 0 
L0:     aload_0 
L1:     new [43] 
L4:     dup 
L5:     ldc [3] 
L7:     invokestatic [4] 
L10:    ldc [5] 
L12:    ldc [6] 
L14:    invokespecial [37] 
L17:    invokespecial [38] 
L20:    aload_0 
L21:    aload_1 
L22:    putfield [44] 
L25:    return 
L26:    nop 
L27:    nop 
L28:    
    .end code 
.end method 

.method private static synchronized [267] : [268] 
    .attribute [264] .code stack 2 locals 1 
L0:     getstatic [7] 
L3:     iconst_1 
L4:     iadd 
L5:     dup 
L6:     putstatic [39] 
L9:     istore_0 
L10:    iload_0 
L11:    areturn 
L12:    
    .end code 
.end method 

.method public [269] : [270] 
    .attribute [264] .code stack 1 locals 0 
L0:     getstatic [8] 
L3:     areturn 
L4:     
    .end code 
.end method 

.method public [271] : [272] 
    .attribute [264] .code stack 6 locals 5 
        .catch [17] from L0 to L481 using L484 
L0:     iload_1 
L1:     tableswitch 0 
            L380 
            L454 
            L454 
            L454 
            L454 
            L454 
            L454 
            L454 
            L454 
            L454 
            L454 
            L454 
            L454 
            L454 
            L454 
            L278 
            L156 
            L422 
            L454 
            L454 
            L454 
            L454 
            L454 
            L454 
            L454 
            L454 
            L454 
            L454 
            L248 
            L178 
            L454 
            L350 
            L454 
            L320 
            L218 
            default : L454 

L156:   aload_2 
L157:   invokeinterface [45] 0 
L162:   istore 4 
L164:   aload_0 
L165:   getfield [32] 
L168:   iload 4 
L170:   invokeinterface [46] 0 
L175:   goto L481 
L178:   aload_2 
L179:   invokeinterface [47] 0 
L184:   lstore 4 
L186:   aload_2 
L187:   invokestatic [9] 
L190:   astore 6 
L192:   aload_2 
L193:   invokeinterface [45] 0 
L198:   istore 7 
L200:   aload_0 
L201:   getfield [32] 
L204:   lload 4 
L206:   aload 6 
L208:   iload 7 
L210:   invokeinterface [48] 0 
L215:   goto L481 
L218:   aload_2 
L219:   invokestatic [10] 
L222:   astore 4 
L224:   aload_2 
L225:   invokeinterface [45] 0 
L230:   istore 5 
L232:   aload_0 
L233:   getfield [32] 
L236:   aload 4 
L238:   iload 5 
L240:   invokeinterface [49] 0 
L245:   goto L481 
L248:   aload_2 
L249:   invokestatic [11] 
L252:   astore 4 
L254:   aload_2 
L255:   invokeinterface [45] 0 
L260:   istore 5 
L262:   aload_0 
L263:   getfield [32] 
L266:   aload 4 
L268:   iload 5 
L270:   invokeinterface [50] 0 
L275:   goto L481 
L278:   aload_2 
L279:   invokeinterface [47] 0 
L284:   lstore 4 
L286:   aload_2 
L287:   invokeinterface [47] 0 
L292:   lstore 6 
L294:   aload_2 
L295:   invokeinterface [45] 0 
L300:   istore 8 
L302:   aload_0 
L303:   getfield [32] 
L306:   lload 4 
L308:   lload 6 
L310:   iload 8 
L312:   invokeinterface [51] 0 
L317:   goto L481 
L320:   aload_2 
L321:   invokeinterface [52] 0 
L326:   astore 4 
L328:   aload_2 
L329:   invokestatic [12] 
L332:   astore 5 
L334:   aload_0 
L335:   getfield [32] 
L338:   aload 4 
L340:   aload 5 
L342:   invokeinterface [53] 0 
L347:   goto L481 
L350:   aload_2 
L351:   invokestatic [13] 
L354:   astore 4 
L356:   aload_2 
L357:   invokeinterface [45] 0 
L362:   istore 5 
L364:   aload_0 
L365:   getfield [32] 
L368:   aload 4 
L370:   iload 5 
L372:   invokeinterface [54] 0 
L377:   goto L481 
L380:   aload_2 
L381:   invokeinterface [45] 0 
L386:   istore 4 
L388:   aload_2 
L389:   invokeinterface [55] 0 
L394:   astore 5 
L396:   aload_2 
L397:   invokeinterface [45] 0 
L402:   istore 6 
L404:   aload_0 
L405:   getfield [32] 
L408:   iload 4 
L410:   aload 5 
L412:   iload 6 
L414:   invokeinterface [56] 0 
L419:   goto L481 
L422:   aload_2 
L423:   invokeinterface [55] 0 
L428:   astore 4 
L430:   aload_2 
L431:   invokeinterface [55] 0 
L436:   astore 5 
L438:   aload_0 
L439:   getfield [32] 
L442:   aload 4 
L444:   aload 5 
L446:   invokeinterface [57] 0 
L451:   goto L481 
L454:   new [58] 
L457:   dup 
L458:   new [59] 
L461:   dup 
L462:   invokespecial [41] 
L465:   ldc [16] 
L467:   invokevirtual [33] 
L470:   iload_1 
L471:   invokevirtual [34] 
L474:   invokevirtual [35] 
L477:   invokespecial [42] 
L480:   athrow 
L481:   goto L526 
L484:   astore 4 
L486:   new [58] 
L489:   dup 
L490:   new [59] 
L493:   dup 
L494:   invokespecial [41] 
L497:   ldc [18] 
L499:   invokevirtual [33] 
L502:   iload_1 
L503:   invokevirtual [34] 
L506:   ldc [19] 
L508:   invokevirtual [33] 
L511:   aload 4 
L513:   invokevirtual [36] 
L516:   invokevirtual [33] 
L519:   invokevirtual [35] 
L522:   invokespecial [42] 
L525:   athrow 
L526:   return 
L527:   nop 
L528:   
    .end code 
.end method 

.method static [273] : [274] 
    .attribute [264] .code stack 1 locals 0 
L0:     ldc [20] 
L2:     invokestatic [21] 
L5:     putstatic [40] 
L8:     iconst_0 
L9:     putstatic [39] 
L12:    return 
L13:    nop 
L14:    nop 
L15:    nop 
L16:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [60] 
.const [3] = String [61] 
.const [4] = Method [62] [63] 
.const [5] = String [64] 
.const [6] = String [65] 
.const [7] = Field [66] [67] 
.const [8] = Field [68] [69] 
.const [9] = Method [70] [71] 
.const [10] = Method [72] [73] 
.const [11] = Method [74] [75] 
.const [12] = Method [76] [77] 
.const [13] = Method [78] [79] 
.const [14] = Class [80] 
.const [15] = Class [81] 
.const [16] = String [82] 
.const [17] = Class [83] 
.const [18] = String [84] 
.const [19] = String [85] 
.const [20] = String [86] 
.const [21] = Method [87] [88] 
.const [22] = Class [89] 
.const [23] = Class [90] 
.const [24] = Class [91] 
.const [25] = Class [92] 
.const [26] = Class [93] 
.const [27] = Class [94] 
.const [28] = Class [95] 
.const [29] = Class [96] 
.const [30] = Class [97] 
.const [31] = Class [98] 
.const [32] = Field [99] [100] 
.const [33] = Method [101] [102] 
.const [34] = Method [103] [104] 
.const [35] = Method [105] [106] 
.const [36] = Method [107] [108] 
.const [37] = Method [109] [110] 
.const [38] = Method [111] [112] 
.const [39] = Field [113] [114] 
.const [40] = Field [115] [116] 
.const [41] = Method [117] [118] 
.const [42] = Method [119] [120] 
.const [43] = Class [121] 
.const [44] = Field [122] [123] 
.const [45] = InterfaceMethod [124] [125] 
.const [46] = InterfaceMethod [126] [127] 
.const [47] = InterfaceMethod [128] [129] 
.const [48] = InterfaceMethod [130] [131] 
.const [49] = InterfaceMethod [132] [133] 
.const [50] = InterfaceMethod [134] [135] 
.const [51] = InterfaceMethod [136] [137] 
.const [52] = InterfaceMethod [138] [139] 
.const [53] = InterfaceMethod [140] [141] 
.const [54] = InterfaceMethod [142] [143] 
.const [55] = InterfaceMethod [144] [145] 
.const [56] = InterfaceMethod [146] [147] 
.const [57] = InterfaceMethod [148] [149] 
.const [58] = Class [150] 
.const [59] = Class [151] 
.const [60] = Utf8 de/esolutions/fw/comm/core/ServiceInstanceID 
.const [61] = Utf8 fc4f32e5-c610-5f8f-b354-15f3e219f8d2 
.const [62] = Class [152] 
.const [63] = NameAndType [153] [154] 
.const [64] = Utf8 '643fcaa1-9066-5b01-b59d-a05810f472eb' 
.const [65] = Utf8 'dsi.navigation.DSICombinedRouteList' 
.const [66] = Class [155] 
.const [67] = NameAndType [156] [157] 
.const [68] = Class [158] 
.const [69] = NameAndType [159] [160] 
.const [70] = Class [161] 
.const [71] = NameAndType [162] [163] 
.const [72] = Class [164] 
.const [73] = NameAndType [165] [166] 
.const [74] = Class [167] 
.const [75] = NameAndType [168] [169] 
.const [76] = Class [170] 
.const [77] = NameAndType [171] [172] 
.const [78] = Class [173] 
.const [79] = NameAndType [174] [175] 
.const [80] = Utf8 de/esolutions/fw/comm/core/method/MethodException 
.const [81] = Utf8 java/lang/StringBuffer 
.const [82] = Utf8 'Invalid Method Id ' 
.const [83] = Utf8 de/esolutions/fw/util/serializer/exception/SerializerException 
.const [84] = Utf8 'Deserialization failed: method=' 
.const [85] = Utf8 ', error=' 
.const [86] = Utf8 'STUB.dsi.navigation.DSICombinedRouteList' 
.const [87] = Class [176] 
.const [88] = NameAndType [177] [178] 
.const [89] = Utf8 de/esolutions/fw/comm/dsi/navigation/impl/DSICombinedRouteListReplyService 
.const [90] = Utf8 de/esolutions/fw/comm/core/AbstractReplyService 
.const [91] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [92] = Utf8 de/esolutions/fw/comm/dsi/navigation/DSICombinedRouteListReply 
.const [93] = Utf8 de/esolutions/fw/comm/dsi/navigation/impl/CombinedRouteListElementSerializer 
.const [94] = Utf8 de/esolutions/fw/comm/dsi/tmc/impl/TmcMessageSerializer 
.const [95] = Utf8 de/esolutions/fw/comm/dsi/navigation/impl/NavPoiInfoSerializer 
.const [96] = Utf8 de/esolutions/fw/comm/dsi/global/impl/NavRectangleSerializer 
.const [97] = Utf8 de/esolutions/fw/comm/dsi/global/impl/NavPriceInfoSerializer 
.const [98] = Utf8 de/esolutions/fw/comm/core/CallContext 
.const [99] = Class [179] 
.const [100] = NameAndType [180] [181] 
.const [101] = Class [182] 
.const [102] = NameAndType [183] [184] 
.const [103] = Class [185] 
.const [104] = NameAndType [186] [187] 
.const [105] = Class [188] 
.const [106] = NameAndType [189] [190] 
.const [107] = Class [191] 
.const [108] = NameAndType [192] [193] 
.const [109] = Class [194] 
.const [110] = NameAndType [195] [196] 
.const [111] = Class [197] 
.const [112] = NameAndType [198] [199] 
.const [113] = Class [200] 
.const [114] = NameAndType [201] [202] 
.const [115] = Class [203] 
.const [116] = NameAndType [204] [205] 
.const [117] = Class [206] 
.const [118] = NameAndType [207] [208] 
.const [119] = Class [209] 
.const [120] = NameAndType [210] [211] 
.const [121] = Utf8 de/esolutions/fw/comm/core/ServiceInstanceID 
.const [122] = Class [212] 
.const [123] = NameAndType [213] [214] 
.const [124] = Class [215] 
.const [125] = NameAndType [216] [217] 
.const [126] = Class [218] 
.const [127] = NameAndType [219] [220] 
.const [128] = Class [221] 
.const [129] = NameAndType [222] [223] 
.const [130] = Class [224] 
.const [131] = NameAndType [225] [226] 
.const [132] = Class [227] 
.const [133] = NameAndType [228] [229] 
.const [134] = Class [230] 
.const [135] = NameAndType [231] [232] 
.const [136] = Class [233] 
.const [137] = NameAndType [234] [235] 
.const [138] = Class [236] 
.const [139] = NameAndType [237] [238] 
.const [140] = Class [239] 
.const [141] = NameAndType [240] [241] 
.const [142] = Class [242] 
.const [143] = NameAndType [243] [244] 
.const [144] = Class [245] 
.const [145] = NameAndType [246] [247] 
.const [146] = Class [248] 
.const [147] = NameAndType [249] [250] 
.const [148] = Class [251] 
.const [149] = NameAndType [252] [253] 
.const [150] = Utf8 de/esolutions/fw/comm/core/method/MethodException 
.const [151] = Utf8 java/lang/StringBuffer 
.const [152] = Utf8 de/esolutions/fw/comm/dsi/navigation/impl/DSICombinedRouteListReplyService 
.const [153] = Utf8 nextDynamicHandle 
.const [154] = Utf8 ()I 
.const [155] = Utf8 de/esolutions/fw/comm/dsi/navigation/impl/DSICombinedRouteListReplyService 
.const [156] = Utf8 dynamicHandle 
.const [157] = Utf8 I 
.const [158] = Utf8 de/esolutions/fw/comm/dsi/navigation/impl/DSICombinedRouteListReplyService 
.const [159] = Utf8 context 
.const [160] = Utf8 Lde/esolutions/fw/comm/core/CallContext; 
.const [161] = Utf8 de/esolutions/fw/comm/dsi/navigation/impl/CombinedRouteListElementSerializer 
.const [162] = Utf8 getOptionalCombinedRouteListElementVarArray 
.const [163] = Utf8 (Lde/esolutions/fw/util/serializer/IDeserializer;)[Lorg/dsi/ifc/navigation/CombinedRouteListElement; 
.const [164] = Utf8 de/esolutions/fw/comm/dsi/tmc/impl/TmcMessageSerializer 
.const [165] = Utf8 getOptionalTmcMessage 
.const [166] = Utf8 (Lde/esolutions/fw/util/serializer/IDeserializer;)Lorg/dsi/ifc/tmc/TmcMessage; 
.const [167] = Utf8 de/esolutions/fw/comm/dsi/navigation/impl/NavPoiInfoSerializer 
.const [168] = Utf8 getOptionalNavPoiInfo 
.const [169] = Utf8 (Lde/esolutions/fw/util/serializer/IDeserializer;)Lorg/dsi/ifc/navigation/NavPoiInfo; 
.const [170] = Utf8 de/esolutions/fw/comm/dsi/global/impl/NavRectangleSerializer 
.const [171] = Utf8 getOptionalNavRectangle 
.const [172] = Utf8 (Lde/esolutions/fw/util/serializer/IDeserializer;)Lorg/dsi/ifc/global/NavRectangle; 
.const [173] = Utf8 de/esolutions/fw/comm/dsi/global/impl/NavPriceInfoSerializer 
.const [174] = Utf8 getOptionalNavPriceInfo 
.const [175] = Utf8 (Lde/esolutions/fw/util/serializer/IDeserializer;)Lorg/dsi/ifc/global/NavPriceInfo; 
.const [176] = Utf8 de/esolutions/fw/comm/core/CallContext 
.const [177] = Utf8 getContext 
.const [178] = Utf8 (Ljava/lang/String;)Lde/esolutions/fw/comm/core/CallContext; 
.const [179] = Utf8 de/esolutions/fw/comm/dsi/navigation/impl/DSICombinedRouteListReplyService 
.const [180] = Utf8 p_DSICombinedRouteListReply 
.const [181] = Utf8 Lde/esolutions/fw/comm/dsi/navigation/DSICombinedRouteListReply; 
.const [182] = Utf8 java/lang/StringBuffer 
.const [183] = Utf8 append 
.const [184] = Utf8 (Ljava/lang/String;)Ljava/lang/StringBuffer; 
.const [185] = Utf8 java/lang/StringBuffer 
.const [186] = Utf8 append 
.const [187] = Utf8 (I)Ljava/lang/StringBuffer; 
.const [188] = Utf8 java/lang/StringBuffer 
.const [189] = Utf8 toString 
.const [190] = Utf8 ()Ljava/lang/String; 
.const [191] = Utf8 de/esolutions/fw/util/serializer/exception/SerializerException 
.const [192] = Utf8 getMessage 
.const [193] = Utf8 ()Ljava/lang/String; 
.const [194] = Utf8 de/esolutions/fw/comm/core/ServiceInstanceID 
.const [195] = Utf8 <init> 
.const [196] = Utf8 (Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V 
.const [197] = Utf8 de/esolutions/fw/comm/core/AbstractReplyService 
.const [198] = Utf8 <init> 
.const [199] = Utf8 (Lde/esolutions/fw/comm/core/ServiceInstanceID;)V 
.const [200] = Utf8 de/esolutions/fw/comm/dsi/navigation/impl/DSICombinedRouteListReplyService 
.const [201] = Utf8 dynamicHandle 
.const [202] = Utf8 I 
.const [203] = Utf8 de/esolutions/fw/comm/dsi/navigation/impl/DSICombinedRouteListReplyService 
.const [204] = Utf8 context 
.const [205] = Utf8 Lde/esolutions/fw/comm/core/CallContext; 
.const [206] = Utf8 java/lang/StringBuffer 
.const [207] = Utf8 <init> 
.const [208] = Utf8 ()V 
.const [209] = Utf8 de/esolutions/fw/comm/core/method/MethodException 
.const [210] = Utf8 <init> 
.const [211] = Utf8 (Ljava/lang/String;)V 
.const [212] = Utf8 de/esolutions/fw/comm/dsi/navigation/impl/DSICombinedRouteListReplyService 
.const [213] = Utf8 p_DSICombinedRouteListReply 
.const [214] = Utf8 Lde/esolutions/fw/comm/dsi/navigation/DSICombinedRouteListReply; 
.const [215] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [216] = Utf8 getInt32 
.const [217] = Utf8 ()I 
.const [218] = Utf8 de/esolutions/fw/comm/dsi/navigation/DSICombinedRouteListReply 
.const [219] = Utf8 windowChanged 
.const [220] = Utf8 (I)V 
.const [221] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [222] = Utf8 getInt64 
.const [223] = Utf8 ()J 
.const [224] = Utf8 de/esolutions/fw/comm/dsi/navigation/DSICombinedRouteListReply 
.const [225] = Utf8 combinedRouteListResult 
.const [226] = Utf8 (J[Lorg/dsi/ifc/navigation/CombinedRouteListElement;I)V 
.const [227] = Utf8 de/esolutions/fw/comm/dsi/navigation/DSICombinedRouteListReply 
.const [228] = Utf8 trafficInformationResult 
.const [229] = Utf8 (Lorg/dsi/ifc/tmc/TmcMessage;I)V 
.const [230] = Utf8 de/esolutions/fw/comm/dsi/navigation/DSICombinedRouteListReply 
.const [231] = Utf8 poiInformationResult 
.const [232] = Utf8 (Lorg/dsi/ifc/navigation/NavPoiInfo;I)V 
.const [233] = Utf8 de/esolutions/fw/comm/dsi/navigation/DSICombinedRouteListReply 
.const [234] = Utf8 updateElementsTotal 
.const [235] = Utf8 (JJI)V 
.const [236] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [237] = Utf8 getOptionalInt64VarArray 
.const [238] = Utf8 ()[J 
.const [239] = Utf8 de/esolutions/fw/comm/dsi/navigation/DSICombinedRouteListReply 
.const [240] = Utf8 getBoundingRectangleOfCombinedRouteListElementsResult 
.const [241] = Utf8 ([JLorg/dsi/ifc/global/NavRectangle;)V 
.const [242] = Utf8 de/esolutions/fw/comm/dsi/navigation/DSICombinedRouteListReply 
.const [243] = Utf8 requestPriceInfoResult 
.const [244] = Utf8 (Lorg/dsi/ifc/global/NavPriceInfo;I)V 
.const [245] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [246] = Utf8 getOptionalString 
.const [247] = Utf8 ()Ljava/lang/String; 
.const [248] = Utf8 de/esolutions/fw/comm/dsi/navigation/DSICombinedRouteListReply 
.const [249] = Utf8 asyncException 
.const [250] = Utf8 (ILjava/lang/String;I)V 
.const [251] = Utf8 de/esolutions/fw/comm/dsi/navigation/DSICombinedRouteListReply 
.const [252] = Utf8 yyIndication 
.const [253] = Utf8 (Ljava/lang/String;Ljava/lang/String;)V 
.const [254] = Utf8 de/esolutions/fw/comm/dsi/navigation/impl/DSICombinedRouteListReplyService 
.const [255] = Class [254] 
.const [256] = Utf8 de/esolutions/fw/comm/core/AbstractReplyService 
.const [257] = Class [256] 
.const [258] = Utf8 context 
.const [259] = Utf8 Lde/esolutions/fw/comm/core/CallContext; 
.const [260] = Utf8 dynamicHandle 
.const [261] = Utf8 I 
.const [262] = Utf8 p_DSICombinedRouteListReply 
.const [263] = Utf8 Lde/esolutions/fw/comm/dsi/navigation/DSICombinedRouteListReply; 
.const [264] = Utf8 Code 
.const [265] = Utf8 <init> 
.const [266] = Utf8 (Lde/esolutions/fw/comm/dsi/navigation/DSICombinedRouteListReply;)V 
.const [267] = Utf8 nextDynamicHandle 
.const [268] = Utf8 ()I 
.const [269] = Utf8 getCallContext 
.const [270] = Utf8 ()Lde/esolutions/fw/comm/core/CallContext; 
.const [271] = Utf8 handleCallMethod 
.const [272] = Utf8 (SLde/esolutions/fw/util/serializer/IDeserializer;Lde/esolutions/fw/comm/core/IProxyFrontend;)V 
.const [273] = Utf8 <clinit> 
.const [274] = Utf8 ()V 
.end class 
