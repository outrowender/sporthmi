.version 50 0 
.class public super [233] 
.super [235] 
.field private static final [236] [237] 
.field private static [238] [239] 
.field private [240] [241] 

.method public [243] : [244] 
    .attribute [242] .code stack 7 locals 0 
L0:     aload_0 
L1:     new [33] 
L4:     dup 
L5:     ldc [3] 
L7:     invokestatic [4] 
L10:    ldc [5] 
L12:    ldc [6] 
L14:    invokespecial [27] 
L17:    invokespecial [28] 
L20:    aload_0 
L21:    aload_1 
L22:    putfield [34] 
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
L6:     putstatic [29] 
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
    .attribute [242] .code stack 4 locals 3 
        .catch [12] from L0 to L533 using L536 
L0:     iload_1 
L1:     tableswitch 0 
            L256 
            L506 
            L202 
            L288 
            L180 
            L506 
            L310 
            L506 
            L506 
            L506 
            L506 
            L506 
            L506 
            L506 
            L506 
            L506 
            L506 
            L506 
            L506 
            L332 
            L506 
            L506 
            L506 
            L506 
            L354 
            L506 
            L506 
            L506 
            L506 
            L506 
            L224 
            L506 
            L462 
            L430 
            L386 
            L408 
            L506 
            L506 
            L506 
            L506 
            L484 
            default : L506 

L180:   aload_2 
L181:   invokeinterface [35] 0 
L186:   lstore 4 
L188:   aload_0 
L189:   getfield [22] 
L192:   lload 4 
L194:   invokeinterface [36] 0 
L199:   goto L533 
L202:   aload_2 
L203:   invokeinterface [35] 0 
L208:   lstore 4 
L210:   aload_0 
L211:   getfield [22] 
L214:   lload 4 
L216:   invokeinterface [37] 0 
L221:   goto L533 
L224:   aload_2 
L225:   invokeinterface [35] 0 
L230:   lstore 4 
L232:   aload_2 
L233:   invokeinterface [38] 0 
L238:   istore 6 
L240:   aload_0 
L241:   getfield [22] 
L244:   lload 4 
L246:   iload 6 
L248:   invokeinterface [39] 0 
L253:   goto L533 
L256:   aload_2 
L257:   invokeinterface [35] 0 
L262:   lstore 4 
L264:   aload_2 
L265:   invokeinterface [38] 0 
L270:   istore 6 
L272:   aload_0 
L273:   getfield [22] 
L276:   lload 4 
L278:   iload 6 
L280:   invokeinterface [40] 0 
L285:   goto L533 
L288:   aload_2 
L289:   invokeinterface [35] 0 
L294:   lstore 4 
L296:   aload_0 
L297:   getfield [22] 
L300:   lload 4 
L302:   invokeinterface [41] 0 
L307:   goto L533 
L310:   aload_2 
L311:   invokeinterface [35] 0 
L316:   lstore 4 
L318:   aload_0 
L319:   getfield [22] 
L322:   lload 4 
L324:   invokeinterface [42] 0 
L329:   goto L533 
L332:   aload_2 
L333:   invokeinterface [35] 0 
L338:   lstore 4 
L340:   aload_0 
L341:   getfield [22] 
L344:   lload 4 
L346:   invokeinterface [43] 0 
L351:   goto L533 
L354:   aload_2 
L355:   invokeinterface [35] 0 
L360:   lstore 4 
L362:   aload_2 
L363:   invokeinterface [38] 0 
L368:   istore 6 
L370:   aload_0 
L371:   getfield [22] 
L374:   lload 4 
L376:   iload 6 
L378:   invokeinterface [44] 0 
L383:   goto L533 
L386:   aload_2 
L387:   invokeinterface [35] 0 
L392:   lstore 4 
L394:   aload_0 
L395:   getfield [22] 
L398:   lload 4 
L400:   invokeinterface [45] 0 
L405:   goto L533 
L408:   aload_2 
L409:   invokeinterface [35] 0 
L414:   lstore 4 
L416:   aload_0 
L417:   getfield [22] 
L420:   lload 4 
L422:   invokeinterface [46] 0 
L427:   goto L533 
L430:   aload_2 
L431:   invokeinterface [35] 0 
L436:   lstore 4 
L438:   aload_2 
L439:   invokeinterface [47] 0 
L444:   astore 6 
L446:   aload_0 
L447:   getfield [22] 
L450:   lload 4 
L452:   aload 6 
L454:   invokeinterface [48] 0 
L459:   goto L533 
L462:   aload_2 
L463:   invokeinterface [35] 0 
L468:   lstore 4 
L470:   aload_0 
L471:   getfield [22] 
L474:   lload 4 
L476:   invokeinterface [49] 0 
L481:   goto L533 
L484:   aload_2 
L485:   invokeinterface [35] 0 
L490:   lstore 4 
L492:   aload_0 
L493:   getfield [22] 
L496:   lload 4 
L498:   invokeinterface [50] 0 
L503:   goto L533 
L506:   new [51] 
L509:   dup 
L510:   new [52] 
L513:   dup 
L514:   invokespecial [31] 
L517:   ldc [11] 
L519:   invokevirtual [23] 
L522:   iload_1 
L523:   invokevirtual [24] 
L526:   invokevirtual [25] 
L529:   invokespecial [32] 
L532:   athrow 
L533:   goto L578 
L536:   astore 4 
L538:   new [51] 
L541:   dup 
L542:   new [52] 
L545:   dup 
L546:   invokespecial [31] 
L549:   ldc [13] 
L551:   invokevirtual [23] 
L554:   iload_1 
L555:   invokevirtual [24] 
L558:   ldc [14] 
L560:   invokevirtual [23] 
L563:   aload 4 
L565:   invokevirtual [26] 
L568:   invokevirtual [23] 
L571:   invokevirtual [25] 
L574:   invokespecial [32] 
L577:   athrow 
L578:   return 
L579:   nop 
L580:   
    .end code 
.end method 

.method static [251] : [252] 
    .attribute [242] .code stack 1 locals 0 
L0:     ldc [15] 
L2:     invokestatic [16] 
L5:     putstatic [30] 
L8:     iconst_0 
L9:     putstatic [29] 
L12:    return 
L13:    nop 
L14:    nop 
L15:    nop 
L16:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [53] 
.const [3] = String [54] 
.const [4] = Method [55] [56] 
.const [5] = String [57] 
.const [6] = String [58] 
.const [7] = Field [59] [60] 
.const [8] = Field [61] [62] 
.const [9] = Class [63] 
.const [10] = Class [64] 
.const [11] = String [65] 
.const [12] = Class [66] 
.const [13] = String [67] 
.const [14] = String [68] 
.const [15] = String [69] 
.const [16] = Method [70] [71] 
.const [17] = Class [72] 
.const [18] = Class [73] 
.const [19] = Class [74] 
.const [20] = Class [75] 
.const [21] = Class [76] 
.const [22] = Field [77] [78] 
.const [23] = Method [79] [80] 
.const [24] = Method [81] [82] 
.const [25] = Method [83] [84] 
.const [26] = Method [85] [86] 
.const [27] = Method [87] [88] 
.const [28] = Method [89] [90] 
.const [29] = Field [91] [92] 
.const [30] = Field [93] [94] 
.const [31] = Method [95] [96] 
.const [32] = Method [97] [98] 
.const [33] = Class [99] 
.const [34] = Field [100] [101] 
.const [35] = InterfaceMethod [102] [103] 
.const [36] = InterfaceMethod [104] [105] 
.const [37] = InterfaceMethod [106] [107] 
.const [38] = InterfaceMethod [108] [109] 
.const [39] = InterfaceMethod [110] [111] 
.const [40] = InterfaceMethod [112] [113] 
.const [41] = InterfaceMethod [114] [115] 
.const [42] = InterfaceMethod [116] [117] 
.const [43] = InterfaceMethod [118] [119] 
.const [44] = InterfaceMethod [120] [121] 
.const [45] = InterfaceMethod [122] [123] 
.const [46] = InterfaceMethod [124] [125] 
.const [47] = InterfaceMethod [126] [127] 
.const [48] = InterfaceMethod [128] [129] 
.const [49] = InterfaceMethod [130] [131] 
.const [50] = InterfaceMethod [132] [133] 
.const [51] = Class [134] 
.const [52] = Class [135] 
.const [53] = Utf8 de/esolutions/fw/comm/core/ServiceInstanceID 
.const [54] = Utf8 '434ab88c-5027-40eb-92ee-df5658912e1a' 
.const [55] = Class [136] 
.const [56] = NameAndType [137] [138] 
.const [57] = Utf8 dd966f77-1703-5382-80a9-c2b428743ae7 
.const [58] = Utf8 'asi.diagnosis.mmx2app.MMX2TelephoneDiagService' 
.const [59] = Class [139] 
.const [60] = NameAndType [140] [141] 
.const [61] = Class [142] 
.const [62] = NameAndType [143] [144] 
.const [63] = Utf8 de/esolutions/fw/comm/core/method/MethodException 
.const [64] = Utf8 java/lang/StringBuffer 
.const [65] = Utf8 'Invalid Method Id ' 
.const [66] = Utf8 de/esolutions/fw/util/serializer/exception/SerializerException 
.const [67] = Utf8 'Deserialization failed: method=' 
.const [68] = Utf8 ', error=' 
.const [69] = Utf8 'STUB.asi.diagnosis.mmx2app.MMX2TelephoneDiagService' 
.const [70] = Class [145] 
.const [71] = NameAndType [146] [147] 
.const [72] = Utf8 de/esolutions/fw/comm/asi/diagnosis/mmx2app/impl/MMX2TelephoneDiagServiceReplyService 
.const [73] = Utf8 de/esolutions/fw/comm/core/AbstractReplyService 
.const [74] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [75] = Utf8 de/esolutions/fw/comm/asi/diagnosis/mmx2app/MMX2TelephoneDiagServiceReply 
.const [76] = Utf8 de/esolutions/fw/comm/core/CallContext 
.const [77] = Class [148] 
.const [78] = NameAndType [149] [150] 
.const [79] = Class [151] 
.const [80] = NameAndType [152] [153] 
.const [81] = Class [154] 
.const [82] = NameAndType [155] [156] 
.const [83] = Class [157] 
.const [84] = NameAndType [158] [159] 
.const [85] = Class [160] 
.const [86] = NameAndType [161] [162] 
.const [87] = Class [163] 
.const [88] = NameAndType [164] [165] 
.const [89] = Class [166] 
.const [90] = NameAndType [167] [168] 
.const [91] = Class [169] 
.const [92] = NameAndType [170] [171] 
.const [93] = Class [172] 
.const [94] = NameAndType [173] [174] 
.const [95] = Class [175] 
.const [96] = NameAndType [176] [177] 
.const [97] = Class [178] 
.const [98] = NameAndType [179] [180] 
.const [99] = Utf8 de/esolutions/fw/comm/core/ServiceInstanceID 
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
.const [112] = Class [199] 
.const [113] = NameAndType [200] [201] 
.const [114] = Class [202] 
.const [115] = NameAndType [203] [204] 
.const [116] = Class [205] 
.const [117] = NameAndType [206] [207] 
.const [118] = Class [208] 
.const [119] = NameAndType [209] [210] 
.const [120] = Class [211] 
.const [121] = NameAndType [212] [213] 
.const [122] = Class [214] 
.const [123] = NameAndType [215] [216] 
.const [124] = Class [217] 
.const [125] = NameAndType [218] [219] 
.const [126] = Class [220] 
.const [127] = NameAndType [221] [222] 
.const [128] = Class [223] 
.const [129] = NameAndType [224] [225] 
.const [130] = Class [226] 
.const [131] = NameAndType [227] [228] 
.const [132] = Class [229] 
.const [133] = NameAndType [230] [231] 
.const [134] = Utf8 de/esolutions/fw/comm/core/method/MethodException 
.const [135] = Utf8 java/lang/StringBuffer 
.const [136] = Utf8 de/esolutions/fw/comm/asi/diagnosis/mmx2app/impl/MMX2TelephoneDiagServiceReplyService 
.const [137] = Utf8 nextDynamicHandle 
.const [138] = Utf8 ()I 
.const [139] = Utf8 de/esolutions/fw/comm/asi/diagnosis/mmx2app/impl/MMX2TelephoneDiagServiceReplyService 
.const [140] = Utf8 dynamicHandle 
.const [141] = Utf8 I 
.const [142] = Utf8 de/esolutions/fw/comm/asi/diagnosis/mmx2app/impl/MMX2TelephoneDiagServiceReplyService 
.const [143] = Utf8 context 
.const [144] = Utf8 Lde/esolutions/fw/comm/core/CallContext; 
.const [145] = Utf8 de/esolutions/fw/comm/core/CallContext 
.const [146] = Utf8 getContext 
.const [147] = Utf8 (Ljava/lang/String;)Lde/esolutions/fw/comm/core/CallContext; 
.const [148] = Utf8 de/esolutions/fw/comm/asi/diagnosis/mmx2app/impl/MMX2TelephoneDiagServiceReplyService 
.const [149] = Utf8 p_MMX2TelephoneDiagServiceReply 
.const [150] = Utf8 Lde/esolutions/fw/comm/asi/diagnosis/mmx2app/MMX2TelephoneDiagServiceReply; 
.const [151] = Utf8 java/lang/StringBuffer 
.const [152] = Utf8 append 
.const [153] = Utf8 (Ljava/lang/String;)Ljava/lang/StringBuffer; 
.const [154] = Utf8 java/lang/StringBuffer 
.const [155] = Utf8 append 
.const [156] = Utf8 (I)Ljava/lang/StringBuffer; 
.const [157] = Utf8 java/lang/StringBuffer 
.const [158] = Utf8 toString 
.const [159] = Utf8 ()Ljava/lang/String; 
.const [160] = Utf8 de/esolutions/fw/util/serializer/exception/SerializerException 
.const [161] = Utf8 getMessage 
.const [162] = Utf8 ()Ljava/lang/String; 
.const [163] = Utf8 de/esolutions/fw/comm/core/ServiceInstanceID 
.const [164] = Utf8 <init> 
.const [165] = Utf8 (Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V 
.const [166] = Utf8 de/esolutions/fw/comm/core/AbstractReplyService 
.const [167] = Utf8 <init> 
.const [168] = Utf8 (Lde/esolutions/fw/comm/core/ServiceInstanceID;)V 
.const [169] = Utf8 de/esolutions/fw/comm/asi/diagnosis/mmx2app/impl/MMX2TelephoneDiagServiceReplyService 
.const [170] = Utf8 dynamicHandle 
.const [171] = Utf8 I 
.const [172] = Utf8 de/esolutions/fw/comm/asi/diagnosis/mmx2app/impl/MMX2TelephoneDiagServiceReplyService 
.const [173] = Utf8 context 
.const [174] = Utf8 Lde/esolutions/fw/comm/core/CallContext; 
.const [175] = Utf8 java/lang/StringBuffer 
.const [176] = Utf8 <init> 
.const [177] = Utf8 ()V 
.const [178] = Utf8 de/esolutions/fw/comm/core/method/MethodException 
.const [179] = Utf8 <init> 
.const [180] = Utf8 (Ljava/lang/String;)V 
.const [181] = Utf8 de/esolutions/fw/comm/asi/diagnosis/mmx2app/impl/MMX2TelephoneDiagServiceReplyService 
.const [182] = Utf8 p_MMX2TelephoneDiagServiceReply 
.const [183] = Utf8 Lde/esolutions/fw/comm/asi/diagnosis/mmx2app/MMX2TelephoneDiagServiceReply; 
.const [184] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [185] = Utf8 getUInt32 
.const [186] = Utf8 ()J 
.const [187] = Utf8 de/esolutions/fw/comm/asi/diagnosis/mmx2app/MMX2TelephoneDiagServiceReply 
.const [188] = Utf8 requestSimState 
.const [189] = Utf8 (J)V 
.const [190] = Utf8 de/esolutions/fw/comm/asi/diagnosis/mmx2app/MMX2TelephoneDiagServiceReply 
.const [191] = Utf8 requestNadIMEI 
.const [192] = Utf8 (J)V 
.const [193] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [194] = Utf8 getEnum 
.const [195] = Utf8 ()I 
.const [196] = Utf8 de/esolutions/fw/comm/asi/diagnosis/mmx2app/MMX2TelephoneDiagServiceReply 
.const [197] = Utf8 requestTelephoneAntennaState 
.const [198] = Utf8 (JI)V 
.const [199] = Utf8 de/esolutions/fw/comm/asi/diagnosis/mmx2app/MMX2TelephoneDiagServiceReply 
.const [200] = Utf8 requestConnectedBtHandset 
.const [201] = Utf8 (JI)V 
.const [202] = Utf8 de/esolutions/fw/comm/asi/diagnosis/mmx2app/MMX2TelephoneDiagServiceReply 
.const [203] = Utf8 requestNumberHandsetsHUCs 
.const [204] = Utf8 (J)V 
.const [205] = Utf8 de/esolutions/fw/comm/asi/diagnosis/mmx2app/MMX2TelephoneDiagServiceReply 
.const [206] = Utf8 requestTelephoneNetworkState 
.const [207] = Utf8 (J)V 
.const [208] = Utf8 de/esolutions/fw/comm/asi/diagnosis/mmx2app/MMX2TelephoneDiagServiceReply 
.const [209] = Utf8 requestTelephoneTemperature 
.const [210] = Utf8 (J)V 
.const [211] = Utf8 de/esolutions/fw/comm/asi/diagnosis/mmx2app/MMX2TelephoneDiagServiceReply 
.const [212] = Utf8 requestDeleteMemory 
.const [213] = Utf8 (JI)V 
.const [214] = Utf8 de/esolutions/fw/comm/asi/diagnosis/mmx2app/MMX2TelephoneDiagServiceReply 
.const [215] = Utf8 requestNetworkName 
.const [216] = Utf8 (J)V 
.const [217] = Utf8 de/esolutions/fw/comm/asi/diagnosis/mmx2app/MMX2TelephoneDiagServiceReply 
.const [218] = Utf8 requestNetworkType 
.const [219] = Utf8 (J)V 
.const [220] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [221] = Utf8 getOptionalString 
.const [222] = Utf8 ()Ljava/lang/String; 
.const [223] = Utf8 de/esolutions/fw/comm/asi/diagnosis/mmx2app/MMX2TelephoneDiagServiceReply 
.const [224] = Utf8 requestDialNumber 
.const [225] = Utf8 (JLjava/lang/String;)V 
.const [226] = Utf8 de/esolutions/fw/comm/asi/diagnosis/mmx2app/MMX2TelephoneDiagServiceReply 
.const [227] = Utf8 requestCallStatus 
.const [228] = Utf8 (J)V 
.const [229] = Utf8 de/esolutions/fw/comm/asi/diagnosis/mmx2app/MMX2TelephoneDiagServiceReply 
.const [230] = Utf8 requestInternalSimIdentification 
.const [231] = Utf8 (J)V 
.const [232] = Utf8 de/esolutions/fw/comm/asi/diagnosis/mmx2app/impl/MMX2TelephoneDiagServiceReplyService 
.const [233] = Class [232] 
.const [234] = Utf8 de/esolutions/fw/comm/core/AbstractReplyService 
.const [235] = Class [234] 
.const [236] = Utf8 context 
.const [237] = Utf8 Lde/esolutions/fw/comm/core/CallContext; 
.const [238] = Utf8 dynamicHandle 
.const [239] = Utf8 I 
.const [240] = Utf8 p_MMX2TelephoneDiagServiceReply 
.const [241] = Utf8 Lde/esolutions/fw/comm/asi/diagnosis/mmx2app/MMX2TelephoneDiagServiceReply; 
.const [242] = Utf8 Code 
.const [243] = Utf8 <init> 
.const [244] = Utf8 (Lde/esolutions/fw/comm/asi/diagnosis/mmx2app/MMX2TelephoneDiagServiceReply;)V 
.const [245] = Utf8 nextDynamicHandle 
.const [246] = Utf8 ()I 
.const [247] = Utf8 getCallContext 
.const [248] = Utf8 ()Lde/esolutions/fw/comm/core/CallContext; 
.const [249] = Utf8 handleCallMethod 
.const [250] = Utf8 (SLde/esolutions/fw/util/serializer/IDeserializer;Lde/esolutions/fw/comm/core/IProxyFrontend;)V 
.const [251] = Utf8 <clinit> 
.const [252] = Utf8 ()V 
.end class 
