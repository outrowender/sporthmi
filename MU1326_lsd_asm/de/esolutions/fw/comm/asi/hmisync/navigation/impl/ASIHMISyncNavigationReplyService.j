.version 50 0 
.class public super [245] 
.super [247] 
.field private static final [248] [249] 
.field private static [250] [251] 
.field private [252] [253] 

.method public [255] : [256] 
    .attribute [254] .code stack 7 locals 0 
L0:     aload_0 
L1:     new [39] 
L4:     dup 
L5:     ldc [3] 
L7:     invokestatic [4] 
L10:    ldc [5] 
L12:    ldc [6] 
L14:    invokespecial [33] 
L17:    invokespecial [34] 
L20:    aload_0 
L21:    aload_1 
L22:    putfield [40] 
L25:    return 
L26:    nop 
L27:    nop 
L28:    
    .end code 
.end method 

.method private static synchronized [257] : [258] 
    .attribute [254] .code stack 2 locals 1 
L0:     getstatic [7] 
L3:     iconst_1 
L4:     iadd 
L5:     dup 
L6:     putstatic [35] 
L9:     istore_0 
L10:    iload_0 
L11:    areturn 
L12:    
    .end code 
.end method 

.method public [259] : [260] 
    .attribute [254] .code stack 1 locals 0 
L0:     getstatic [8] 
L3:     areturn 
L4:     
    .end code 
.end method 

.method public [261] : [262] 
    .attribute [254] .code stack 4 locals 2 
        .catch [15] from L0 to L389 using L392 
L0:     iload_1 
L1:     tableswitch 9 
            L60 
            L82 
            L210 
            L240 
            L270 
            L362 
            L300 
            L178 
            L330 
            L146 
            L114 
            default : L362 

L60:    aload_2 
L61:    invokeinterface [41] 0 
L66:    istore 4 
L68:    aload_0 
L69:    getfield [28] 
L72:    iload 4 
L74:    invokeinterface [42] 0 
L79:    goto L389 
L82:    aload_2 
L83:    invokeinterface [43] 0 
L88:    astore 4 
L90:    aload_2 
L91:    invokeinterface [44] 0 
L96:    istore 5 
L98:    aload_0 
L99:    getfield [28] 
L102:   aload 4 
L104:   iload 5 
L106:   invokeinterface [45] 0 
L111:   goto L389 
L114:   aload_2 
L115:   invokeinterface [46] 0 
L120:   astore 4 
L122:   aload_2 
L123:   invokeinterface [44] 0 
L128:   istore 5 
L130:   aload_0 
L131:   getfield [28] 
L134:   aload 4 
L136:   iload 5 
L138:   invokeinterface [47] 0 
L143:   goto L389 
L146:   aload_2 
L147:   invokeinterface [46] 0 
L152:   astore 4 
L154:   aload_2 
L155:   invokeinterface [44] 0 
L160:   istore 5 
L162:   aload_0 
L163:   getfield [28] 
L166:   aload 4 
L168:   iload 5 
L170:   invokeinterface [48] 0 
L175:   goto L389 
L178:   aload_2 
L179:   invokeinterface [44] 0 
L184:   istore 4 
L186:   aload_2 
L187:   invokeinterface [44] 0 
L192:   istore 5 
L194:   aload_0 
L195:   getfield [28] 
L198:   iload 4 
L200:   iload 5 
L202:   invokeinterface [49] 0 
L207:   goto L389 
L210:   aload_2 
L211:   invokestatic [9] 
L214:   astore 4 
L216:   aload_2 
L217:   invokeinterface [44] 0 
L222:   istore 5 
L224:   aload_0 
L225:   getfield [28] 
L228:   aload 4 
L230:   iload 5 
L232:   invokeinterface [50] 0 
L237:   goto L389 
L240:   aload_2 
L241:   invokestatic [10] 
L244:   astore 4 
L246:   aload_2 
L247:   invokeinterface [44] 0 
L252:   istore 5 
L254:   aload_0 
L255:   getfield [28] 
L258:   aload 4 
L260:   iload 5 
L262:   invokeinterface [51] 0 
L267:   goto L389 
L270:   aload_2 
L271:   invokestatic [10] 
L274:   astore 4 
L276:   aload_2 
L277:   invokeinterface [44] 0 
L282:   istore 5 
L284:   aload_0 
L285:   getfield [28] 
L288:   aload 4 
L290:   iload 5 
L292:   invokeinterface [52] 0 
L297:   goto L389 
L300:   aload_2 
L301:   invokestatic [11] 
L304:   astore 4 
L306:   aload_2 
L307:   invokeinterface [44] 0 
L312:   istore 5 
L314:   aload_0 
L315:   getfield [28] 
L318:   aload 4 
L320:   iload 5 
L322:   invokeinterface [53] 0 
L327:   goto L389 
L330:   aload_2 
L331:   invokeinterface [44] 0 
L336:   istore 4 
L338:   aload_2 
L339:   invokeinterface [44] 0 
L344:   istore 5 
L346:   aload_0 
L347:   getfield [28] 
L350:   iload 4 
L352:   iload 5 
L354:   invokeinterface [54] 0 
L359:   goto L389 
L362:   new [55] 
L365:   dup 
L366:   new [56] 
L369:   dup 
L370:   invokespecial [37] 
L373:   ldc [14] 
L375:   invokevirtual [29] 
L378:   iload_1 
L379:   invokevirtual [30] 
L382:   invokevirtual [31] 
L385:   invokespecial [38] 
L388:   athrow 
L389:   goto L434 
L392:   astore 4 
L394:   new [55] 
L397:   dup 
L398:   new [56] 
L401:   dup 
L402:   invokespecial [37] 
L405:   ldc [16] 
L407:   invokevirtual [29] 
L410:   iload_1 
L411:   invokevirtual [30] 
L414:   ldc [17] 
L416:   invokevirtual [29] 
L419:   aload 4 
L421:   invokevirtual [32] 
L424:   invokevirtual [29] 
L427:   invokevirtual [31] 
L430:   invokespecial [38] 
L433:   athrow 
L434:   return 
L435:   nop 
L436:   
    .end code 
.end method 

.method static [263] : [264] 
    .attribute [254] .code stack 1 locals 0 
L0:     ldc [18] 
L2:     invokestatic [19] 
L5:     putstatic [36] 
L8:     iconst_0 
L9:     putstatic [35] 
L12:    return 
L13:    nop 
L14:    nop 
L15:    nop 
L16:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [57] 
.const [3] = String [58] 
.const [4] = Method [59] [60] 
.const [5] = String [61] 
.const [6] = String [62] 
.const [7] = Field [63] [64] 
.const [8] = Field [65] [66] 
.const [9] = Method [67] [68] 
.const [10] = Method [69] [70] 
.const [11] = Method [71] [72] 
.const [12] = Class [73] 
.const [13] = Class [74] 
.const [14] = String [75] 
.const [15] = Class [76] 
.const [16] = String [77] 
.const [17] = String [78] 
.const [18] = String [79] 
.const [19] = Method [80] [81] 
.const [20] = Class [82] 
.const [21] = Class [83] 
.const [22] = Class [84] 
.const [23] = Class [85] 
.const [24] = Class [86] 
.const [25] = Class [87] 
.const [26] = Class [88] 
.const [27] = Class [89] 
.const [28] = Field [90] [91] 
.const [29] = Method [92] [93] 
.const [30] = Method [94] [95] 
.const [31] = Method [96] [97] 
.const [32] = Method [98] [99] 
.const [33] = Method [100] [101] 
.const [34] = Method [102] [103] 
.const [35] = Field [104] [105] 
.const [36] = Field [106] [107] 
.const [37] = Method [108] [109] 
.const [38] = Method [110] [111] 
.const [39] = Class [112] 
.const [40] = Field [113] [114] 
.const [41] = InterfaceMethod [115] [116] 
.const [42] = InterfaceMethod [117] [118] 
.const [43] = InterfaceMethod [119] [120] 
.const [44] = InterfaceMethod [121] [122] 
.const [45] = InterfaceMethod [123] [124] 
.const [46] = InterfaceMethod [125] [126] 
.const [47] = InterfaceMethod [127] [128] 
.const [48] = InterfaceMethod [129] [130] 
.const [49] = InterfaceMethod [131] [132] 
.const [50] = InterfaceMethod [133] [134] 
.const [51] = InterfaceMethod [135] [136] 
.const [52] = InterfaceMethod [137] [138] 
.const [53] = InterfaceMethod [139] [140] 
.const [54] = InterfaceMethod [141] [142] 
.const [55] = Class [143] 
.const [56] = Class [144] 
.const [57] = Utf8 de/esolutions/fw/comm/core/ServiceInstanceID 
.const [58] = Utf8 '8d39242f-638c-434c-a3c2-23fe7dad4907' 
.const [59] = Class [145] 
.const [60] = NameAndType [146] [147] 
.const [61] = Utf8 '85677657-50cb-53c6-b534-c27796d5fb16' 
.const [62] = Utf8 'asi.hmisync.navigation.ASIHMISyncNavigation' 
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
.const [73] = Utf8 de/esolutions/fw/comm/core/method/MethodException 
.const [74] = Utf8 java/lang/StringBuffer 
.const [75] = Utf8 'Invalid Method Id ' 
.const [76] = Utf8 de/esolutions/fw/util/serializer/exception/SerializerException 
.const [77] = Utf8 'Deserialization failed: method=' 
.const [78] = Utf8 ', error=' 
.const [79] = Utf8 'STUB.asi.hmisync.navigation.ASIHMISyncNavigation' 
.const [80] = Class [163] 
.const [81] = NameAndType [164] [165] 
.const [82] = Utf8 de/esolutions/fw/comm/asi/hmisync/navigation/impl/ASIHMISyncNavigationReplyService 
.const [83] = Utf8 de/esolutions/fw/comm/core/AbstractReplyService 
.const [84] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [85] = Utf8 de/esolutions/fw/comm/asi/hmisync/navigation/ASIHMISyncNavigationReply 
.const [86] = Utf8 de/esolutions/fw/comm/asi/hmisync/navigation/impl/CarPositionSerializer 
.const [87] = Utf8 de/esolutions/fw/comm/asi/hmisync/navigation/impl/DestinationInfoSerializer 
.const [88] = Utf8 de/esolutions/fw/comm/asi/hmisync/navigation/impl/NextDestinationInfoSerializer 
.const [89] = Utf8 de/esolutions/fw/comm/core/CallContext 
.const [90] = Class [166] 
.const [91] = NameAndType [167] [168] 
.const [92] = Class [169] 
.const [93] = NameAndType [170] [171] 
.const [94] = Class [172] 
.const [95] = NameAndType [173] [174] 
.const [96] = Class [175] 
.const [97] = NameAndType [176] [177] 
.const [98] = Class [178] 
.const [99] = NameAndType [179] [180] 
.const [100] = Class [181] 
.const [101] = NameAndType [182] [183] 
.const [102] = Class [184] 
.const [103] = NameAndType [185] [186] 
.const [104] = Class [187] 
.const [105] = NameAndType [188] [189] 
.const [106] = Class [190] 
.const [107] = NameAndType [191] [192] 
.const [108] = Class [193] 
.const [109] = NameAndType [194] [195] 
.const [110] = Class [196] 
.const [111] = NameAndType [197] [198] 
.const [112] = Utf8 de/esolutions/fw/comm/core/ServiceInstanceID 
.const [113] = Class [199] 
.const [114] = NameAndType [200] [201] 
.const [115] = Class [202] 
.const [116] = NameAndType [203] [204] 
.const [117] = Class [205] 
.const [118] = NameAndType [206] [207] 
.const [119] = Class [208] 
.const [120] = NameAndType [209] [210] 
.const [121] = Class [211] 
.const [122] = NameAndType [212] [213] 
.const [123] = Class [214] 
.const [124] = NameAndType [215] [216] 
.const [125] = Class [217] 
.const [126] = NameAndType [218] [219] 
.const [127] = Class [220] 
.const [128] = NameAndType [221] [222] 
.const [129] = Class [223] 
.const [130] = NameAndType [224] [225] 
.const [131] = Class [226] 
.const [132] = NameAndType [227] [228] 
.const [133] = Class [229] 
.const [134] = NameAndType [230] [231] 
.const [135] = Class [232] 
.const [136] = NameAndType [233] [234] 
.const [137] = Class [235] 
.const [138] = NameAndType [236] [237] 
.const [139] = Class [238] 
.const [140] = NameAndType [239] [240] 
.const [141] = Class [241] 
.const [142] = NameAndType [242] [243] 
.const [143] = Utf8 de/esolutions/fw/comm/core/method/MethodException 
.const [144] = Utf8 java/lang/StringBuffer 
.const [145] = Utf8 de/esolutions/fw/comm/asi/hmisync/navigation/impl/ASIHMISyncNavigationReplyService 
.const [146] = Utf8 nextDynamicHandle 
.const [147] = Utf8 ()I 
.const [148] = Utf8 de/esolutions/fw/comm/asi/hmisync/navigation/impl/ASIHMISyncNavigationReplyService 
.const [149] = Utf8 dynamicHandle 
.const [150] = Utf8 I 
.const [151] = Utf8 de/esolutions/fw/comm/asi/hmisync/navigation/impl/ASIHMISyncNavigationReplyService 
.const [152] = Utf8 context 
.const [153] = Utf8 Lde/esolutions/fw/comm/core/CallContext; 
.const [154] = Utf8 de/esolutions/fw/comm/asi/hmisync/navigation/impl/CarPositionSerializer 
.const [155] = Utf8 getOptionalCarPosition 
.const [156] = Utf8 (Lde/esolutions/fw/util/serializer/IDeserializer;)Lde/esolutions/fw/comm/asi/hmisync/navigation/CarPosition; 
.const [157] = Utf8 de/esolutions/fw/comm/asi/hmisync/navigation/impl/DestinationInfoSerializer 
.const [158] = Utf8 getOptionalDestinationInfoVarArray 
.const [159] = Utf8 (Lde/esolutions/fw/util/serializer/IDeserializer;)[Lde/esolutions/fw/comm/asi/hmisync/navigation/DestinationInfo; 
.const [160] = Utf8 de/esolutions/fw/comm/asi/hmisync/navigation/impl/NextDestinationInfoSerializer 
.const [161] = Utf8 getOptionalNextDestinationInfo 
.const [162] = Utf8 (Lde/esolutions/fw/util/serializer/IDeserializer;)Lde/esolutions/fw/comm/asi/hmisync/navigation/NextDestinationInfo; 
.const [163] = Utf8 de/esolutions/fw/comm/core/CallContext 
.const [164] = Utf8 getContext 
.const [165] = Utf8 (Ljava/lang/String;)Lde/esolutions/fw/comm/core/CallContext; 
.const [166] = Utf8 de/esolutions/fw/comm/asi/hmisync/navigation/impl/ASIHMISyncNavigationReplyService 
.const [167] = Utf8 p_ASIHMISyncNavigationReply 
.const [168] = Utf8 Lde/esolutions/fw/comm/asi/hmisync/navigation/ASIHMISyncNavigationReply; 
.const [169] = Utf8 java/lang/StringBuffer 
.const [170] = Utf8 append 
.const [171] = Utf8 (Ljava/lang/String;)Ljava/lang/StringBuffer; 
.const [172] = Utf8 java/lang/StringBuffer 
.const [173] = Utf8 append 
.const [174] = Utf8 (I)Ljava/lang/StringBuffer; 
.const [175] = Utf8 java/lang/StringBuffer 
.const [176] = Utf8 toString 
.const [177] = Utf8 ()Ljava/lang/String; 
.const [178] = Utf8 de/esolutions/fw/util/serializer/exception/SerializerException 
.const [179] = Utf8 getMessage 
.const [180] = Utf8 ()Ljava/lang/String; 
.const [181] = Utf8 de/esolutions/fw/comm/core/ServiceInstanceID 
.const [182] = Utf8 <init> 
.const [183] = Utf8 (Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V 
.const [184] = Utf8 de/esolutions/fw/comm/core/AbstractReplyService 
.const [185] = Utf8 <init> 
.const [186] = Utf8 (Lde/esolutions/fw/comm/core/ServiceInstanceID;)V 
.const [187] = Utf8 de/esolutions/fw/comm/asi/hmisync/navigation/impl/ASIHMISyncNavigationReplyService 
.const [188] = Utf8 dynamicHandle 
.const [189] = Utf8 I 
.const [190] = Utf8 de/esolutions/fw/comm/asi/hmisync/navigation/impl/ASIHMISyncNavigationReplyService 
.const [191] = Utf8 context 
.const [192] = Utf8 Lde/esolutions/fw/comm/core/CallContext; 
.const [193] = Utf8 java/lang/StringBuffer 
.const [194] = Utf8 <init> 
.const [195] = Utf8 ()V 
.const [196] = Utf8 de/esolutions/fw/comm/core/method/MethodException 
.const [197] = Utf8 <init> 
.const [198] = Utf8 (Ljava/lang/String;)V 
.const [199] = Utf8 de/esolutions/fw/comm/asi/hmisync/navigation/impl/ASIHMISyncNavigationReplyService 
.const [200] = Utf8 p_ASIHMISyncNavigationReply 
.const [201] = Utf8 Lde/esolutions/fw/comm/asi/hmisync/navigation/ASIHMISyncNavigationReply; 
.const [202] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [203] = Utf8 getInt32 
.const [204] = Utf8 ()I 
.const [205] = Utf8 de/esolutions/fw/comm/asi/hmisync/navigation/ASIHMISyncNavigationReply 
.const [206] = Utf8 startGuidanceToDestinationsResult 
.const [207] = Utf8 (I)V 
.const [208] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [209] = Utf8 getOptionalString 
.const [210] = Utf8 ()Ljava/lang/String; 
.const [211] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [212] = Utf8 getBool 
.const [213] = Utf8 ()Z 
.const [214] = Utf8 de/esolutions/fw/comm/asi/hmisync/navigation/ASIHMISyncNavigationReply 
.const [215] = Utf8 updateASIVersion 
.const [216] = Utf8 (Ljava/lang/String;Z)V 
.const [217] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [218] = Utf8 getOptionalInt16VarArray 
.const [219] = Utf8 ()[S 
.const [220] = Utf8 de/esolutions/fw/comm/asi/hmisync/navigation/ASIHMISyncNavigationReply 
.const [221] = Utf8 updateRequestIDs 
.const [222] = Utf8 ([SZ)V 
.const [223] = Utf8 de/esolutions/fw/comm/asi/hmisync/navigation/ASIHMISyncNavigationReply 
.const [224] = Utf8 updateReplyIDs 
.const [225] = Utf8 ([SZ)V 
.const [226] = Utf8 de/esolutions/fw/comm/asi/hmisync/navigation/ASIHMISyncNavigationReply 
.const [227] = Utf8 updateRouteGuidanceActive 
.const [228] = Utf8 (ZZ)V 
.const [229] = Utf8 de/esolutions/fw/comm/asi/hmisync/navigation/ASIHMISyncNavigationReply 
.const [230] = Utf8 updateCarPosition 
.const [231] = Utf8 (Lde/esolutions/fw/comm/asi/hmisync/navigation/CarPosition;Z)V 
.const [232] = Utf8 de/esolutions/fw/comm/asi/hmisync/navigation/ASIHMISyncNavigationReply 
.const [233] = Utf8 updateDestinationInfo 
.const [234] = Utf8 ([Lde/esolutions/fw/comm/asi/hmisync/navigation/DestinationInfo;Z)V 
.const [235] = Utf8 de/esolutions/fw/comm/asi/hmisync/navigation/ASIHMISyncNavigationReply 
.const [236] = Utf8 updateDestinationsForGuidance 
.const [237] = Utf8 ([Lde/esolutions/fw/comm/asi/hmisync/navigation/DestinationInfo;Z)V 
.const [238] = Utf8 de/esolutions/fw/comm/asi/hmisync/navigation/ASIHMISyncNavigationReply 
.const [239] = Utf8 updateNextDestinationInfo 
.const [240] = Utf8 (Lde/esolutions/fw/comm/asi/hmisync/navigation/NextDestinationInfo;Z)V 
.const [241] = Utf8 de/esolutions/fw/comm/asi/hmisync/navigation/ASIHMISyncNavigationReply 
.const [242] = Utf8 updateNightDesignRequested 
.const [243] = Utf8 (ZZ)V 
.const [244] = Utf8 de/esolutions/fw/comm/asi/hmisync/navigation/impl/ASIHMISyncNavigationReplyService 
.const [245] = Class [244] 
.const [246] = Utf8 de/esolutions/fw/comm/core/AbstractReplyService 
.const [247] = Class [246] 
.const [248] = Utf8 context 
.const [249] = Utf8 Lde/esolutions/fw/comm/core/CallContext; 
.const [250] = Utf8 dynamicHandle 
.const [251] = Utf8 I 
.const [252] = Utf8 p_ASIHMISyncNavigationReply 
.const [253] = Utf8 Lde/esolutions/fw/comm/asi/hmisync/navigation/ASIHMISyncNavigationReply; 
.const [254] = Utf8 Code 
.const [255] = Utf8 <init> 
.const [256] = Utf8 (Lde/esolutions/fw/comm/asi/hmisync/navigation/ASIHMISyncNavigationReply;)V 
.const [257] = Utf8 nextDynamicHandle 
.const [258] = Utf8 ()I 
.const [259] = Utf8 getCallContext 
.const [260] = Utf8 ()Lde/esolutions/fw/comm/core/CallContext; 
.const [261] = Utf8 handleCallMethod 
.const [262] = Utf8 (SLde/esolutions/fw/util/serializer/IDeserializer;Lde/esolutions/fw/comm/core/IProxyFrontend;)V 
.const [263] = Utf8 <clinit> 
.const [264] = Utf8 ()V 
.end class 
