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
    .attribute [240] .code stack 6 locals 5 
        .catch [14] from L0 to L499 using L502 
L0:     iload_1 
L1:     tableswitch 14 
            L398 
            L294 
            L232 
            L180 
            L128 
            L346 
            L376 
            L68 
            L98 
            L472 
            L472 
            L472 
            L440 
            default : L472 

L68:    aload_2 
L69:    invokestatic [9] 
L72:    astore 4 
L74:    aload_2 
L75:    invokeinterface [39] 0 
L80:    istore 5 
L82:    aload_0 
L83:    getfield [26] 
L86:    aload 4 
L88:    iload 5 
L90:    invokeinterface [40] 0 
L95:    goto L499 
L98:    aload_2 
L99:    invokestatic [9] 
L102:   astore 4 
L104:   aload_2 
L105:   invokeinterface [39] 0 
L110:   istore 5 
L112:   aload_0 
L113:   getfield [26] 
L116:   aload 4 
L118:   iload 5 
L120:   invokeinterface [41] 0 
L125:   goto L499 
L128:   aload_2 
L129:   invokeinterface [39] 0 
L134:   istore 4 
L136:   aload_2 
L137:   invokeinterface [39] 0 
L142:   istore 5 
L144:   aload_2 
L145:   invokeinterface [39] 0 
L150:   istore 6 
L152:   aload_2 
L153:   invokeinterface [39] 0 
L158:   istore 7 
L160:   aload_0 
L161:   getfield [26] 
L164:   iload 4 
L166:   iload 5 
L168:   iload 6 
L170:   iload 7 
L172:   invokeinterface [42] 0 
L177:   goto L499 
L180:   aload_2 
L181:   invokeinterface [39] 0 
L186:   istore 4 
L188:   aload_2 
L189:   invokeinterface [39] 0 
L194:   istore 5 
L196:   aload_2 
L197:   invokeinterface [39] 0 
L202:   istore 6 
L204:   aload_2 
L205:   invokeinterface [39] 0 
L210:   istore 7 
L212:   aload_0 
L213:   getfield [26] 
L216:   iload 4 
L218:   iload 5 
L220:   iload 6 
L222:   iload 7 
L224:   invokeinterface [43] 0 
L229:   goto L499 
L232:   aload_2 
L233:   invokeinterface [39] 0 
L238:   istore 4 
L240:   aload_2 
L241:   invokeinterface [39] 0 
L246:   istore 5 
L248:   aload_2 
L249:   invokeinterface [39] 0 
L254:   istore 6 
L256:   aload_2 
L257:   invokeinterface [39] 0 
L262:   istore 7 
L264:   aload_2 
L265:   invokeinterface [39] 0 
L270:   istore 8 
L272:   aload_0 
L273:   getfield [26] 
L276:   iload 4 
L278:   iload 5 
L280:   iload 6 
L282:   iload 7 
L284:   iload 8 
L286:   invokeinterface [44] 0 
L291:   goto L499 
L294:   aload_2 
L295:   invokeinterface [39] 0 
L300:   istore 4 
L302:   aload_2 
L303:   invokeinterface [45] 0 
L308:   astore 5 
L310:   aload_2 
L311:   invokeinterface [39] 0 
L316:   istore 6 
L318:   aload_2 
L319:   invokeinterface [46] 0 
L324:   astore 7 
L326:   aload_0 
L327:   getfield [26] 
L330:   iload 4 
L332:   aload 5 
L334:   iload 6 
L336:   aload 7 
L338:   invokeinterface [47] 0 
L343:   goto L499 
L346:   aload_2 
L347:   invokeinterface [39] 0 
L352:   istore 4 
L354:   aload_2 
L355:   invokestatic [10] 
L358:   astore 5 
L360:   aload_0 
L361:   getfield [26] 
L364:   iload 4 
L366:   aload 5 
L368:   invokeinterface [48] 0 
L373:   goto L499 
L376:   aload_2 
L377:   invokeinterface [39] 0 
L382:   istore 4 
L384:   aload_0 
L385:   getfield [26] 
L388:   iload 4 
L390:   invokeinterface [49] 0 
L395:   goto L499 
L398:   aload_2 
L399:   invokeinterface [39] 0 
L404:   istore 4 
L406:   aload_2 
L407:   invokeinterface [46] 0 
L412:   astore 5 
L414:   aload_2 
L415:   invokeinterface [39] 0 
L420:   istore 6 
L422:   aload_0 
L423:   getfield [26] 
L426:   iload 4 
L428:   aload 5 
L430:   iload 6 
L432:   invokeinterface [50] 0 
L437:   goto L499 
L440:   aload_2 
L441:   invokeinterface [46] 0 
L446:   astore 4 
L448:   aload_2 
L449:   invokeinterface [46] 0 
L454:   astore 5 
L456:   aload_0 
L457:   getfield [26] 
L460:   aload 4 
L462:   aload 5 
L464:   invokeinterface [51] 0 
L469:   goto L499 
L472:   new [52] 
L475:   dup 
L476:   new [53] 
L479:   dup 
L480:   invokespecial [35] 
L483:   ldc [13] 
L485:   invokevirtual [27] 
L488:   iload_1 
L489:   invokevirtual [28] 
L492:   invokevirtual [29] 
L495:   invokespecial [36] 
L498:   athrow 
L499:   goto L544 
L502:   astore 4 
L504:   new [52] 
L507:   dup 
L508:   new [53] 
L511:   dup 
L512:   invokespecial [35] 
L515:   ldc [15] 
L517:   invokevirtual [27] 
L520:   iload_1 
L521:   invokevirtual [28] 
L524:   ldc [16] 
L526:   invokevirtual [27] 
L529:   aload 4 
L531:   invokevirtual [30] 
L534:   invokevirtual [27] 
L537:   invokevirtual [29] 
L540:   invokespecial [36] 
L543:   athrow 
L544:   return 
L545:   nop 
L546:   nop 
L547:   nop 
L548:   
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
.const [55] = Utf8 '652febaf-81ba-5aba-890b-6fa0da6c390d' 
.const [56] = Class [137] 
.const [57] = NameAndType [138] [139] 
.const [58] = Utf8 '8eb87df5-6b8c-54e8-9d1e-dbfd4bda2e56' 
.const [59] = Utf8 'dsi.organizer.DSIAdbVCardExchange' 
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
.const [74] = Utf8 'STUB.dsi.organizer.DSIAdbVCardExchange' 
.const [75] = Class [152] 
.const [76] = NameAndType [153] [154] 
.const [77] = Utf8 de/esolutions/fw/comm/dsi/organizer/impl/DSIAdbVCardExchangeReplyService 
.const [78] = Utf8 de/esolutions/fw/comm/core/AbstractReplyService 
.const [79] = Utf8 de/esolutions/fw/comm/dsi/organizer/impl/DownloadInfoSerializer 
.const [80] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [81] = Utf8 de/esolutions/fw/comm/dsi/organizer/DSIAdbVCardExchangeReply 
.const [82] = Utf8 de/esolutions/fw/comm/dsi/organizer/impl/AdbEntrySerializer 
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
.const [137] = Utf8 de/esolutions/fw/comm/dsi/organizer/impl/DSIAdbVCardExchangeReplyService 
.const [138] = Utf8 nextDynamicHandle 
.const [139] = Utf8 ()I 
.const [140] = Utf8 de/esolutions/fw/comm/dsi/organizer/impl/DSIAdbVCardExchangeReplyService 
.const [141] = Utf8 dynamicHandle 
.const [142] = Utf8 I 
.const [143] = Utf8 de/esolutions/fw/comm/dsi/organizer/impl/DSIAdbVCardExchangeReplyService 
.const [144] = Utf8 context 
.const [145] = Utf8 Lde/esolutions/fw/comm/core/CallContext; 
.const [146] = Utf8 de/esolutions/fw/comm/dsi/organizer/impl/DownloadInfoSerializer 
.const [147] = Utf8 getOptionalDownloadInfo 
.const [148] = Utf8 (Lde/esolutions/fw/util/serializer/IDeserializer;)Lorg/dsi/ifc/organizer/DownloadInfo; 
.const [149] = Utf8 de/esolutions/fw/comm/dsi/organizer/impl/AdbEntrySerializer 
.const [150] = Utf8 getOptionalAdbEntryVarArray 
.const [151] = Utf8 (Lde/esolutions/fw/util/serializer/IDeserializer;)[Lorg/dsi/ifc/organizer/AdbEntry; 
.const [152] = Utf8 de/esolutions/fw/comm/core/CallContext 
.const [153] = Utf8 getContext 
.const [154] = Utf8 (Ljava/lang/String;)Lde/esolutions/fw/comm/core/CallContext; 
.const [155] = Utf8 de/esolutions/fw/comm/dsi/organizer/impl/DSIAdbVCardExchangeReplyService 
.const [156] = Utf8 p_DSIAdbVCardExchangeReply 
.const [157] = Utf8 Lde/esolutions/fw/comm/dsi/organizer/DSIAdbVCardExchangeReply; 
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
.const [176] = Utf8 de/esolutions/fw/comm/dsi/organizer/impl/DSIAdbVCardExchangeReplyService 
.const [177] = Utf8 dynamicHandle 
.const [178] = Utf8 I 
.const [179] = Utf8 de/esolutions/fw/comm/dsi/organizer/impl/DSIAdbVCardExchangeReplyService 
.const [180] = Utf8 context 
.const [181] = Utf8 Lde/esolutions/fw/comm/core/CallContext; 
.const [182] = Utf8 java/lang/StringBuffer 
.const [183] = Utf8 <init> 
.const [184] = Utf8 ()V 
.const [185] = Utf8 de/esolutions/fw/comm/core/method/MethodException 
.const [186] = Utf8 <init> 
.const [187] = Utf8 (Ljava/lang/String;)V 
.const [188] = Utf8 de/esolutions/fw/comm/dsi/organizer/impl/DSIAdbVCardExchangeReplyService 
.const [189] = Utf8 p_DSIAdbVCardExchangeReply 
.const [190] = Utf8 Lde/esolutions/fw/comm/dsi/organizer/DSIAdbVCardExchangeReply; 
.const [191] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [192] = Utf8 getInt32 
.const [193] = Utf8 ()I 
.const [194] = Utf8 de/esolutions/fw/comm/dsi/organizer/DSIAdbVCardExchangeReply 
.const [195] = Utf8 updateExportCount 
.const [196] = Utf8 (Lorg/dsi/ifc/organizer/DownloadInfo;I)V 
.const [197] = Utf8 de/esolutions/fw/comm/dsi/organizer/DSIAdbVCardExchangeReply 
.const [198] = Utf8 updateImportCount 
.const [199] = Utf8 (Lorg/dsi/ifc/organizer/DownloadInfo;I)V 
.const [200] = Utf8 de/esolutions/fw/comm/dsi/organizer/DSIAdbVCardExchangeReply 
.const [201] = Utf8 importVCardResult 
.const [202] = Utf8 (IIII)V 
.const [203] = Utf8 de/esolutions/fw/comm/dsi/organizer/DSIAdbVCardExchangeReply 
.const [204] = Utf8 exportVCardResult 
.const [205] = Utf8 (IIII)V 
.const [206] = Utf8 de/esolutions/fw/comm/dsi/organizer/DSIAdbVCardExchangeReply 
.const [207] = Utf8 exportSpellerVCardResult 
.const [208] = Utf8 (IIIII)V 
.const [209] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [210] = Utf8 getOptionalInt64VarArray 
.const [211] = Utf8 ()[J 
.const [212] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [213] = Utf8 getOptionalString 
.const [214] = Utf8 ()Ljava/lang/String; 
.const [215] = Utf8 de/esolutions/fw/comm/dsi/organizer/DSIAdbVCardExchangeReply 
.const [216] = Utf8 createVCardResult 
.const [217] = Utf8 (I[JILjava/lang/String;)V 
.const [218] = Utf8 de/esolutions/fw/comm/dsi/organizer/DSIAdbVCardExchangeReply 
.const [219] = Utf8 parseVCardResult 
.const [220] = Utf8 (I[Lorg/dsi/ifc/organizer/AdbEntry;)V 
.const [221] = Utf8 de/esolutions/fw/comm/dsi/organizer/DSIAdbVCardExchangeReply 
.const [222] = Utf8 responseAbort 
.const [223] = Utf8 (I)V 
.const [224] = Utf8 de/esolutions/fw/comm/dsi/organizer/DSIAdbVCardExchangeReply 
.const [225] = Utf8 asyncException 
.const [226] = Utf8 (ILjava/lang/String;I)V 
.const [227] = Utf8 de/esolutions/fw/comm/dsi/organizer/DSIAdbVCardExchangeReply 
.const [228] = Utf8 yyIndication 
.const [229] = Utf8 (Ljava/lang/String;Ljava/lang/String;)V 
.const [230] = Utf8 de/esolutions/fw/comm/dsi/organizer/impl/DSIAdbVCardExchangeReplyService 
.const [231] = Class [230] 
.const [232] = Utf8 de/esolutions/fw/comm/core/AbstractReplyService 
.const [233] = Class [232] 
.const [234] = Utf8 context 
.const [235] = Utf8 Lde/esolutions/fw/comm/core/CallContext; 
.const [236] = Utf8 dynamicHandle 
.const [237] = Utf8 I 
.const [238] = Utf8 p_DSIAdbVCardExchangeReply 
.const [239] = Utf8 Lde/esolutions/fw/comm/dsi/organizer/DSIAdbVCardExchangeReply; 
.const [240] = Utf8 Code 
.const [241] = Utf8 <init> 
.const [242] = Utf8 (Lde/esolutions/fw/comm/dsi/organizer/DSIAdbVCardExchangeReply;)V 
.const [243] = Utf8 nextDynamicHandle 
.const [244] = Utf8 ()I 
.const [245] = Utf8 getCallContext 
.const [246] = Utf8 ()Lde/esolutions/fw/comm/core/CallContext; 
.const [247] = Utf8 handleCallMethod 
.const [248] = Utf8 (SLde/esolutions/fw/util/serializer/IDeserializer;Lde/esolutions/fw/comm/core/IProxyFrontend;)V 
.const [249] = Utf8 <clinit> 
.const [250] = Utf8 ()V 
.end class 
