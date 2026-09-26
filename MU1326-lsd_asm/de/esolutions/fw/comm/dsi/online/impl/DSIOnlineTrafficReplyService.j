.version 50 0 
.class public super [231] 
.super [233] 
.field private static final [234] [235] 
.field private static [236] [237] 
.field private [238] [239] 

.method public [241] : [242] 
    .attribute [240] .code stack 7 locals 0 
L0:     aload_0 
L1:     new [37] 
L4:     dup 
L5:     ldc [3] 
L7:     invokestatic [4] 
L10:    ldc [5] 
L12:    ldc [6] 
L14:    invokespecial [31] 
L17:    invokespecial [32] 
L20:    aload_0 
L21:    aload_1 
L22:    putfield [38] 
L25:    return 
L26:    nop 
L27:    nop 
L28:    
    .end code 
.end method 

.method private static synchronized [243] : [244] 
    .attribute [240] .code stack 2 locals 1 
L0:     getstatic [7] 
L3:     iconst_1 
L4:     iadd 
L5:     dup 
L6:     putstatic [33] 
L9:     istore_0 
L10:    iload_0 
L11:    areturn 
L12:    
    .end code 
.end method 

.method public [245] : [246] 
    .attribute [240] .code stack 1 locals 0 
L0:     getstatic [8] 
L3:     areturn 
L4:     
    .end code 
.end method 

.method public [247] : [248] 
    .attribute [240] .code stack 4 locals 3 
        .catch [14] from L0 to L385 using L388 
L0:     iload_1 
L1:     tableswitch 16 
            L284 
            L240 
            L124 
            L220 
            L186 
            L154 
            L198 
            L60 
            L92 
            L326 
            L262 
            default : L358 

L60:    aload_2 
L61:    invokeinterface [39] 0 
L66:    istore 4 
L68:    aload_2 
L69:    invokeinterface [39] 0 
L74:    istore 5 
L76:    aload_0 
L77:    getfield [26] 
L80:    iload 4 
L82:    iload 5 
L84:    invokeinterface [40] 0 
L89:    goto L385 
L92:    aload_2 
L93:    invokeinterface [39] 0 
L98:    istore 4 
L100:   aload_2 
L101:   invokeinterface [39] 0 
L106:   istore 5 
L108:   aload_0 
L109:   getfield [26] 
L112:   iload 4 
L114:   iload 5 
L116:   invokeinterface [41] 0 
L121:   goto L385 
L124:   aload_2 
L125:   invokeinterface [39] 0 
L130:   istore 4 
L132:   aload_2 
L133:   invokestatic [9] 
L136:   astore 5 
L138:   aload_0 
L139:   getfield [26] 
L142:   iload 4 
L144:   aload 5 
L146:   invokeinterface [42] 0 
L151:   goto L385 
L154:   aload_2 
L155:   invokeinterface [43] 0 
L160:   astore 4 
L162:   aload_2 
L163:   invokeinterface [39] 0 
L168:   istore 5 
L170:   aload_0 
L171:   getfield [26] 
L174:   aload 4 
L176:   iload 5 
L178:   invokeinterface [44] 0 
L183:   goto L385 
L186:   aload_0 
L187:   getfield [26] 
L190:   invokeinterface [45] 0 
L195:   goto L385 
L198:   aload_2 
L199:   invokeinterface [39] 0 
L204:   istore 4 
L206:   aload_0 
L207:   getfield [26] 
L210:   iload 4 
L212:   invokeinterface [46] 0 
L217:   goto L385 
L220:   aload_2 
L221:   invokestatic [10] 
L224:   astore 4 
L226:   aload_0 
L227:   getfield [26] 
L230:   aload 4 
L232:   invokeinterface [47] 0 
L237:   goto L385 
L240:   aload_2 
L241:   invokeinterface [43] 0 
L246:   astore 4 
L248:   aload_0 
L249:   getfield [26] 
L252:   aload 4 
L254:   invokeinterface [48] 0 
L259:   goto L385 
L262:   aload_2 
L263:   invokeinterface [43] 0 
L268:   astore 4 
L270:   aload_0 
L271:   getfield [26] 
L274:   aload 4 
L276:   invokeinterface [49] 0 
L281:   goto L385 
L284:   aload_2 
L285:   invokeinterface [39] 0 
L290:   istore 4 
L292:   aload_2 
L293:   invokeinterface [43] 0 
L298:   astore 5 
L300:   aload_2 
L301:   invokeinterface [39] 0 
L306:   istore 6 
L308:   aload_0 
L309:   getfield [26] 
L312:   iload 4 
L314:   aload 5 
L316:   iload 6 
L318:   invokeinterface [50] 0 
L323:   goto L385 
L326:   aload_2 
L327:   invokeinterface [43] 0 
L332:   astore 4 
L334:   aload_2 
L335:   invokeinterface [43] 0 
L340:   astore 5 
L342:   aload_0 
L343:   getfield [26] 
L346:   aload 4 
L348:   aload 5 
L350:   invokeinterface [51] 0 
L355:   goto L385 
L358:   new [52] 
L361:   dup 
L362:   new [53] 
L365:   dup 
L366:   invokespecial [35] 
L369:   ldc [13] 
L371:   invokevirtual [27] 
L374:   iload_1 
L375:   invokevirtual [28] 
L378:   invokevirtual [29] 
L381:   invokespecial [36] 
L384:   athrow 
L385:   goto L430 
L388:   astore 4 
L390:   new [52] 
L393:   dup 
L394:   new [53] 
L397:   dup 
L398:   invokespecial [35] 
L401:   ldc [15] 
L403:   invokevirtual [27] 
L406:   iload_1 
L407:   invokevirtual [28] 
L410:   ldc [16] 
L412:   invokevirtual [27] 
L415:   aload 4 
L417:   invokevirtual [30] 
L420:   invokevirtual [27] 
L423:   invokevirtual [29] 
L426:   invokespecial [36] 
L429:   athrow 
L430:   return 
L431:   nop 
L432:   
    .end code 
.end method 

.method static [249] : [250] 
    .attribute [240] .code stack 1 locals 0 
L0:     ldc [17] 
L2:     invokestatic [18] 
L5:     putstatic [34] 
L8:     iconst_0 
L9:     putstatic [33] 
L12:    return 
L13:    nop 
L14:    nop 
L15:    nop 
L16:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [54] 
.const [3] = String [55] 
.const [4] = Method [56] [57] 
.const [5] = String [58] 
.const [6] = String [59] 
.const [7] = Field [60] [61] 
.const [8] = Field [62] [63] 
.const [9] = Method [64] [65] 
.const [10] = Method [66] [67] 
.const [11] = Class [68] 
.const [12] = Class [69] 
.const [13] = String [70] 
.const [14] = Class [71] 
.const [15] = String [72] 
.const [16] = String [73] 
.const [17] = String [74] 
.const [18] = Method [75] [76] 
.const [19] = Class [77] 
.const [20] = Class [78] 
.const [21] = Class [79] 
.const [22] = Class [80] 
.const [23] = Class [81] 
.const [24] = Class [82] 
.const [25] = Class [83] 
.const [26] = Field [84] [85] 
.const [27] = Method [86] [87] 
.const [28] = Method [88] [89] 
.const [29] = Method [90] [91] 
.const [30] = Method [92] [93] 
.const [31] = Method [94] [95] 
.const [32] = Method [96] [97] 
.const [33] = Field [98] [99] 
.const [34] = Field [100] [101] 
.const [35] = Method [102] [103] 
.const [36] = Method [104] [105] 
.const [37] = Class [106] 
.const [38] = Field [107] [108] 
.const [39] = InterfaceMethod [109] [110] 
.const [40] = InterfaceMethod [111] [112] 
.const [41] = InterfaceMethod [113] [114] 
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
.const [52] = Class [135] 
.const [53] = Class [136] 
.const [54] = Utf8 de/esolutions/fw/comm/core/ServiceInstanceID 
.const [55] = Utf8 a6541574-206f-51ef-b0df-9f6f80e9edfb 
.const [56] = Class [137] 
.const [57] = NameAndType [138] [139] 
.const [58] = Utf8 a94f3724-0361-547e-b190-41d13b2282ad 
.const [59] = Utf8 'dsi.online.DSIOnlineTraffic' 
.const [60] = Class [140] 
.const [61] = NameAndType [141] [142] 
.const [62] = Class [143] 
.const [63] = NameAndType [144] [145] 
.const [64] = Class [146] 
.const [65] = NameAndType [147] [148] 
.const [66] = Class [149] 
.const [67] = NameAndType [150] [151] 
.const [68] = Utf8 de/esolutions/fw/comm/core/method/MethodException 
.const [69] = Utf8 java/lang/StringBuffer 
.const [70] = Utf8 'Invalid Method Id ' 
.const [71] = Utf8 de/esolutions/fw/util/serializer/exception/SerializerException 
.const [72] = Utf8 'Deserialization failed: method=' 
.const [73] = Utf8 ', error=' 
.const [74] = Utf8 'STUB.dsi.online.DSIOnlineTraffic' 
.const [75] = Class [152] 
.const [76] = NameAndType [153] [154] 
.const [77] = Utf8 de/esolutions/fw/comm/dsi/online/impl/DSIOnlineTrafficReplyService 
.const [78] = Utf8 de/esolutions/fw/comm/core/AbstractReplyService 
.const [79] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [80] = Utf8 de/esolutions/fw/comm/dsi/online/DSIOnlineTrafficReply 
.const [81] = Utf8 de/esolutions/fw/comm/dsi/online/impl/LocatablePositionSerializer 
.const [82] = Utf8 de/esolutions/fw/comm/dsi/online/impl/FCDPositionSerializer 
.const [83] = Utf8 de/esolutions/fw/comm/core/CallContext 
.const [84] = Class [155] 
.const [85] = NameAndType [156] [157] 
.const [86] = Class [158] 
.const [87] = NameAndType [159] [160] 
.const [88] = Class [161] 
.const [89] = NameAndType [162] [163] 
.const [90] = Class [164] 
.const [91] = NameAndType [165] [166] 
.const [92] = Class [167] 
.const [93] = NameAndType [168] [169] 
.const [94] = Class [170] 
.const [95] = NameAndType [171] [172] 
.const [96] = Class [173] 
.const [97] = NameAndType [174] [175] 
.const [98] = Class [176] 
.const [99] = NameAndType [177] [178] 
.const [100] = Class [179] 
.const [101] = NameAndType [180] [181] 
.const [102] = Class [182] 
.const [103] = NameAndType [183] [184] 
.const [104] = Class [185] 
.const [105] = NameAndType [186] [187] 
.const [106] = Utf8 de/esolutions/fw/comm/core/ServiceInstanceID 
.const [107] = Class [188] 
.const [108] = NameAndType [189] [190] 
.const [109] = Class [191] 
.const [110] = NameAndType [192] [193] 
.const [111] = Class [194] 
.const [112] = NameAndType [195] [196] 
.const [113] = Class [197] 
.const [114] = NameAndType [198] [199] 
.const [115] = Class [200] 
.const [116] = NameAndType [201] [202] 
.const [117] = Class [203] 
.const [118] = NameAndType [204] [205] 
.const [119] = Class [206] 
.const [120] = NameAndType [207] [208] 
.const [121] = Class [209] 
.const [122] = NameAndType [210] [211] 
.const [123] = Class [212] 
.const [124] = NameAndType [213] [214] 
.const [125] = Class [215] 
.const [126] = NameAndType [216] [217] 
.const [127] = Class [218] 
.const [128] = NameAndType [219] [220] 
.const [129] = Class [221] 
.const [130] = NameAndType [222] [223] 
.const [131] = Class [224] 
.const [132] = NameAndType [225] [226] 
.const [133] = Class [227] 
.const [134] = NameAndType [228] [229] 
.const [135] = Utf8 de/esolutions/fw/comm/core/method/MethodException 
.const [136] = Utf8 java/lang/StringBuffer 
.const [137] = Utf8 de/esolutions/fw/comm/dsi/online/impl/DSIOnlineTrafficReplyService 
.const [138] = Utf8 nextDynamicHandle 
.const [139] = Utf8 ()I 
.const [140] = Utf8 de/esolutions/fw/comm/dsi/online/impl/DSIOnlineTrafficReplyService 
.const [141] = Utf8 dynamicHandle 
.const [142] = Utf8 I 
.const [143] = Utf8 de/esolutions/fw/comm/dsi/online/impl/DSIOnlineTrafficReplyService 
.const [144] = Utf8 context 
.const [145] = Utf8 Lde/esolutions/fw/comm/core/CallContext; 
.const [146] = Utf8 de/esolutions/fw/comm/dsi/online/impl/LocatablePositionSerializer 
.const [147] = Utf8 getOptionalLocatablePositionVarArray 
.const [148] = Utf8 (Lde/esolutions/fw/util/serializer/IDeserializer;)[Lorg/dsi/ifc/online/LocatablePosition; 
.const [149] = Utf8 de/esolutions/fw/comm/dsi/online/impl/FCDPositionSerializer 
.const [150] = Utf8 getOptionalFCDPosition 
.const [151] = Utf8 (Lde/esolutions/fw/util/serializer/IDeserializer;)Lorg/dsi/ifc/online/FCDPosition; 
.const [152] = Utf8 de/esolutions/fw/comm/core/CallContext 
.const [153] = Utf8 getContext 
.const [154] = Utf8 (Ljava/lang/String;)Lde/esolutions/fw/comm/core/CallContext; 
.const [155] = Utf8 de/esolutions/fw/comm/dsi/online/impl/DSIOnlineTrafficReplyService 
.const [156] = Utf8 p_DSIOnlineTrafficReply 
.const [157] = Utf8 Lde/esolutions/fw/comm/dsi/online/DSIOnlineTrafficReply; 
.const [158] = Utf8 java/lang/StringBuffer 
.const [159] = Utf8 append 
.const [160] = Utf8 (Ljava/lang/String;)Ljava/lang/StringBuffer; 
.const [161] = Utf8 java/lang/StringBuffer 
.const [162] = Utf8 append 
.const [163] = Utf8 (I)Ljava/lang/StringBuffer; 
.const [164] = Utf8 java/lang/StringBuffer 
.const [165] = Utf8 toString 
.const [166] = Utf8 ()Ljava/lang/String; 
.const [167] = Utf8 de/esolutions/fw/util/serializer/exception/SerializerException 
.const [168] = Utf8 getMessage 
.const [169] = Utf8 ()Ljava/lang/String; 
.const [170] = Utf8 de/esolutions/fw/comm/core/ServiceInstanceID 
.const [171] = Utf8 <init> 
.const [172] = Utf8 (Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V 
.const [173] = Utf8 de/esolutions/fw/comm/core/AbstractReplyService 
.const [174] = Utf8 <init> 
.const [175] = Utf8 (Lde/esolutions/fw/comm/core/ServiceInstanceID;)V 
.const [176] = Utf8 de/esolutions/fw/comm/dsi/online/impl/DSIOnlineTrafficReplyService 
.const [177] = Utf8 dynamicHandle 
.const [178] = Utf8 I 
.const [179] = Utf8 de/esolutions/fw/comm/dsi/online/impl/DSIOnlineTrafficReplyService 
.const [180] = Utf8 context 
.const [181] = Utf8 Lde/esolutions/fw/comm/core/CallContext; 
.const [182] = Utf8 java/lang/StringBuffer 
.const [183] = Utf8 <init> 
.const [184] = Utf8 ()V 
.const [185] = Utf8 de/esolutions/fw/comm/core/method/MethodException 
.const [186] = Utf8 <init> 
.const [187] = Utf8 (Ljava/lang/String;)V 
.const [188] = Utf8 de/esolutions/fw/comm/dsi/online/impl/DSIOnlineTrafficReplyService 
.const [189] = Utf8 p_DSIOnlineTrafficReply 
.const [190] = Utf8 Lde/esolutions/fw/comm/dsi/online/DSIOnlineTrafficReply; 
.const [191] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [192] = Utf8 getInt32 
.const [193] = Utf8 ()I 
.const [194] = Utf8 de/esolutions/fw/comm/dsi/online/DSIOnlineTrafficReply 
.const [195] = Utf8 updateConsumerReady 
.const [196] = Utf8 (II)V 
.const [197] = Utf8 de/esolutions/fw/comm/dsi/online/DSIOnlineTrafficReply 
.const [198] = Utf8 updateWantOnlineTrafficData 
.const [199] = Utf8 (II)V 
.const [200] = Utf8 de/esolutions/fw/comm/dsi/online/DSIOnlineTrafficReply 
.const [201] = Utf8 getNewDataResult 
.const [202] = Utf8 (I[Lorg/dsi/ifc/online/LocatablePosition;)V 
.const [203] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [204] = Utf8 getOptionalString 
.const [205] = Utf8 ()Ljava/lang/String; 
.const [206] = Utf8 de/esolutions/fw/comm/dsi/online/DSIOnlineTrafficReply 
.const [207] = Utf8 setNewDataResult 
.const [208] = Utf8 (Ljava/lang/String;I)V 
.const [209] = Utf8 de/esolutions/fw/comm/dsi/online/DSIOnlineTrafficReply 
.const [210] = Utf8 getNewSession 
.const [211] = Utf8 ()V 
.const [212] = Utf8 de/esolutions/fw/comm/dsi/online/DSIOnlineTrafficReply 
.const [213] = Utf8 setTimeoutForFallbackResult 
.const [214] = Utf8 (I)V 
.const [215] = Utf8 de/esolutions/fw/comm/dsi/online/DSIOnlineTrafficReply 
.const [216] = Utf8 getNewFCDInformationResult 
.const [217] = Utf8 (Lorg/dsi/ifc/online/FCDPosition;)V 
.const [218] = Utf8 de/esolutions/fw/comm/dsi/online/DSIOnlineTrafficReply 
.const [219] = Utf8 getInventoryResult 
.const [220] = Utf8 (Ljava/lang/String;)V 
.const [221] = Utf8 de/esolutions/fw/comm/dsi/online/DSIOnlineTrafficReply 
.const [222] = Utf8 getDownloadFileResult 
.const [223] = Utf8 (Ljava/lang/String;)V 
.const [224] = Utf8 de/esolutions/fw/comm/dsi/online/DSIOnlineTrafficReply 
.const [225] = Utf8 asyncException 
.const [226] = Utf8 (ILjava/lang/String;I)V 
.const [227] = Utf8 de/esolutions/fw/comm/dsi/online/DSIOnlineTrafficReply 
.const [228] = Utf8 yyIndication 
.const [229] = Utf8 (Ljava/lang/String;Ljava/lang/String;)V 
.const [230] = Utf8 de/esolutions/fw/comm/dsi/online/impl/DSIOnlineTrafficReplyService 
.const [231] = Class [230] 
.const [232] = Utf8 de/esolutions/fw/comm/core/AbstractReplyService 
.const [233] = Class [232] 
.const [234] = Utf8 context 
.const [235] = Utf8 Lde/esolutions/fw/comm/core/CallContext; 
.const [236] = Utf8 dynamicHandle 
.const [237] = Utf8 I 
.const [238] = Utf8 p_DSIOnlineTrafficReply 
.const [239] = Utf8 Lde/esolutions/fw/comm/dsi/online/DSIOnlineTrafficReply; 
.const [240] = Utf8 Code 
.const [241] = Utf8 <init> 
.const [242] = Utf8 (Lde/esolutions/fw/comm/dsi/online/DSIOnlineTrafficReply;)V 
.const [243] = Utf8 nextDynamicHandle 
.const [244] = Utf8 ()I 
.const [245] = Utf8 getCallContext 
.const [246] = Utf8 ()Lde/esolutions/fw/comm/core/CallContext; 
.const [247] = Utf8 handleCallMethod 
.const [248] = Utf8 (SLde/esolutions/fw/util/serializer/IDeserializer;Lde/esolutions/fw/comm/core/IProxyFrontend;)V 
.const [249] = Utf8 <clinit> 
.const [250] = Utf8 ()V 
.end class 
