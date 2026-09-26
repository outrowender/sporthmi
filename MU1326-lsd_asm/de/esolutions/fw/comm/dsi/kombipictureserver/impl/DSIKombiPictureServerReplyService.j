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
    .attribute [242] .code stack 9 locals 8 
        .catch [12] from L0 to L599 using L602 
L0:     iload_1 
L1:     tableswitch 0 
            L498 
            L572 
            L572 
            L572 
            L572 
            L572 
            L572 
            L572 
            L572 
            L572 
            L572 
            L572 
            L572 
            L572 
            L572 
            L572 
            L572 
            L572 
            L572 
            L540 
            L572 
            L244 
            L362 
            L160 
            L330 
            L202 
            L572 
            L572 
            L572 
            L572 
            L406 
            L394 
            L572 
            L572 
            L266 
            L298 
            default : L572 

L160:   aload_2 
L161:   invokeinterface [35] 0 
L166:   lstore 4 
L168:   aload_2 
L169:   invokeinterface [36] 0 
L174:   istore 6 
L176:   aload_2 
L177:   invokeinterface [36] 0 
L182:   istore 7 
L184:   aload_0 
L185:   getfield [22] 
L188:   lload 4 
L190:   iload 6 
L192:   iload 7 
L194:   invokeinterface [37] 0 
L199:   goto L599 
L202:   aload_2 
L203:   invokeinterface [35] 0 
L208:   lstore 4 
L210:   aload_2 
L211:   invokeinterface [36] 0 
L216:   istore 6 
L218:   aload_2 
L219:   invokeinterface [36] 0 
L224:   istore 7 
L226:   aload_0 
L227:   getfield [22] 
L230:   lload 4 
L232:   iload 6 
L234:   iload 7 
L236:   invokeinterface [38] 0 
L241:   goto L599 
L244:   aload_2 
L245:   invokeinterface [36] 0 
L250:   istore 4 
L252:   aload_0 
L253:   getfield [22] 
L256:   iload 4 
L258:   invokeinterface [39] 0 
L263:   goto L599 
L266:   aload_2 
L267:   invokeinterface [36] 0 
L272:   istore 4 
L274:   aload_2 
L275:   invokeinterface [36] 0 
L280:   istore 5 
L282:   aload_0 
L283:   getfield [22] 
L286:   iload 4 
L288:   iload 5 
L290:   invokeinterface [40] 0 
L295:   goto L599 
L298:   aload_2 
L299:   invokeinterface [36] 0 
L304:   istore 4 
L306:   aload_2 
L307:   invokeinterface [36] 0 
L312:   istore 5 
L314:   aload_0 
L315:   getfield [22] 
L318:   iload 4 
L320:   iload 5 
L322:   invokeinterface [41] 0 
L327:   goto L599 
L330:   aload_2 
L331:   invokeinterface [35] 0 
L336:   lstore 4 
L338:   aload_2 
L339:   invokeinterface [36] 0 
L344:   istore 6 
L346:   aload_0 
L347:   getfield [22] 
L350:   lload 4 
L352:   iload 6 
L354:   invokeinterface [42] 0 
L359:   goto L599 
L362:   aload_2 
L363:   invokeinterface [35] 0 
L368:   lstore 4 
L370:   aload_2 
L371:   invokeinterface [36] 0 
L376:   istore 6 
L378:   aload_0 
L379:   getfield [22] 
L382:   lload 4 
L384:   iload 6 
L386:   invokeinterface [43] 0 
L391:   goto L599 
L394:   aload_0 
L395:   getfield [22] 
L398:   invokeinterface [44] 0 
L403:   goto L599 
L406:   aload_2 
L407:   invokeinterface [36] 0 
L412:   istore 4 
L414:   aload_2 
L415:   invokeinterface [45] 0 
L420:   istore 5 
L422:   aload_2 
L423:   invokeinterface [45] 0 
L428:   istore 6 
L430:   aload_2 
L431:   invokeinterface [36] 0 
L436:   istore 7 
L438:   aload_2 
L439:   invokeinterface [36] 0 
L444:   istore 8 
L446:   aload_2 
L447:   invokeinterface [36] 0 
L452:   istore 9 
L454:   aload_2 
L455:   invokeinterface [36] 0 
L460:   istore 10 
L462:   aload_2 
L463:   invokeinterface [46] 0 
L468:   astore 11 
L470:   aload_0 
L471:   getfield [22] 
L474:   iload 4 
L476:   iload 5 
L478:   iload 6 
L480:   iload 7 
L482:   iload 8 
L484:   iload 9 
L486:   iload 10 
L488:   aload 11 
L490:   invokeinterface [47] 0 
L495:   goto L599 
L498:   aload_2 
L499:   invokeinterface [36] 0 
L504:   istore 4 
L506:   aload_2 
L507:   invokeinterface [48] 0 
L512:   astore 5 
L514:   aload_2 
L515:   invokeinterface [36] 0 
L520:   istore 6 
L522:   aload_0 
L523:   getfield [22] 
L526:   iload 4 
L528:   aload 5 
L530:   iload 6 
L532:   invokeinterface [49] 0 
L537:   goto L599 
L540:   aload_2 
L541:   invokeinterface [48] 0 
L546:   astore 4 
L548:   aload_2 
L549:   invokeinterface [48] 0 
L554:   astore 5 
L556:   aload_0 
L557:   getfield [22] 
L560:   aload 4 
L562:   aload 5 
L564:   invokeinterface [50] 0 
L569:   goto L599 
L572:   new [51] 
L575:   dup 
L576:   new [52] 
L579:   dup 
L580:   invokespecial [31] 
L583:   ldc [11] 
L585:   invokevirtual [23] 
L588:   iload_1 
L589:   invokevirtual [24] 
L592:   invokevirtual [25] 
L595:   invokespecial [32] 
L598:   athrow 
L599:   goto L644 
L602:   astore 4 
L604:   new [51] 
L607:   dup 
L608:   new [52] 
L611:   dup 
L612:   invokespecial [31] 
L615:   ldc [13] 
L617:   invokevirtual [23] 
L620:   iload_1 
L621:   invokevirtual [24] 
L624:   ldc [14] 
L626:   invokevirtual [23] 
L629:   aload 4 
L631:   invokevirtual [26] 
L634:   invokevirtual [23] 
L637:   invokevirtual [25] 
L640:   invokespecial [32] 
L643:   athrow 
L644:   return 
L645:   nop 
L646:   nop 
L647:   nop 
L648:   
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
.const [54] = Utf8 ea6b5949-422e-560a-a7d3-c20920d9da4d 
.const [55] = Class [136] 
.const [56] = NameAndType [137] [138] 
.const [57] = Utf8 ce643631-ba2b-51a2-9c51-5163c3e28c2a 
.const [58] = Utf8 'dsi.kombipictureserver.DSIKombiPictureServer' 
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
.const [69] = Utf8 'STUB.dsi.kombipictureserver.DSIKombiPictureServer' 
.const [70] = Class [145] 
.const [71] = NameAndType [146] [147] 
.const [72] = Utf8 de/esolutions/fw/comm/dsi/kombipictureserver/impl/DSIKombiPictureServerReplyService 
.const [73] = Utf8 de/esolutions/fw/comm/core/AbstractReplyService 
.const [74] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [75] = Utf8 de/esolutions/fw/comm/dsi/kombipictureserver/DSIKombiPictureServerReply 
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
.const [136] = Utf8 de/esolutions/fw/comm/dsi/kombipictureserver/impl/DSIKombiPictureServerReplyService 
.const [137] = Utf8 nextDynamicHandle 
.const [138] = Utf8 ()I 
.const [139] = Utf8 de/esolutions/fw/comm/dsi/kombipictureserver/impl/DSIKombiPictureServerReplyService 
.const [140] = Utf8 dynamicHandle 
.const [141] = Utf8 I 
.const [142] = Utf8 de/esolutions/fw/comm/dsi/kombipictureserver/impl/DSIKombiPictureServerReplyService 
.const [143] = Utf8 context 
.const [144] = Utf8 Lde/esolutions/fw/comm/core/CallContext; 
.const [145] = Utf8 de/esolutions/fw/comm/core/CallContext 
.const [146] = Utf8 getContext 
.const [147] = Utf8 (Ljava/lang/String;)Lde/esolutions/fw/comm/core/CallContext; 
.const [148] = Utf8 de/esolutions/fw/comm/dsi/kombipictureserver/impl/DSIKombiPictureServerReplyService 
.const [149] = Utf8 p_DSIKombiPictureServerReply 
.const [150] = Utf8 Lde/esolutions/fw/comm/dsi/kombipictureserver/DSIKombiPictureServerReply; 
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
.const [169] = Utf8 de/esolutions/fw/comm/dsi/kombipictureserver/impl/DSIKombiPictureServerReplyService 
.const [170] = Utf8 dynamicHandle 
.const [171] = Utf8 I 
.const [172] = Utf8 de/esolutions/fw/comm/dsi/kombipictureserver/impl/DSIKombiPictureServerReplyService 
.const [173] = Utf8 context 
.const [174] = Utf8 Lde/esolutions/fw/comm/core/CallContext; 
.const [175] = Utf8 java/lang/StringBuffer 
.const [176] = Utf8 <init> 
.const [177] = Utf8 ()V 
.const [178] = Utf8 de/esolutions/fw/comm/core/method/MethodException 
.const [179] = Utf8 <init> 
.const [180] = Utf8 (Ljava/lang/String;)V 
.const [181] = Utf8 de/esolutions/fw/comm/dsi/kombipictureserver/impl/DSIKombiPictureServerReplyService 
.const [182] = Utf8 p_DSIKombiPictureServerReply 
.const [183] = Utf8 Lde/esolutions/fw/comm/dsi/kombipictureserver/DSIKombiPictureServerReply; 
.const [184] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [185] = Utf8 getInt64 
.const [186] = Utf8 ()J 
.const [187] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [188] = Utf8 getInt32 
.const [189] = Utf8 ()I 
.const [190] = Utf8 de/esolutions/fw/comm/dsi/kombipictureserver/DSIKombiPictureServerReply 
.const [191] = Utf8 indicationCoverArt 
.const [192] = Utf8 (JII)V 
.const [193] = Utf8 de/esolutions/fw/comm/dsi/kombipictureserver/DSIKombiPictureServerReply 
.const [194] = Utf8 indicationStationArt 
.const [195] = Utf8 (JII)V 
.const [196] = Utf8 de/esolutions/fw/comm/dsi/kombipictureserver/DSIKombiPictureServerReply 
.const [197] = Utf8 indicationActiveCallPicture 
.const [198] = Utf8 (I)V 
.const [199] = Utf8 de/esolutions/fw/comm/dsi/kombipictureserver/DSIKombiPictureServerReply 
.const [200] = Utf8 indicationActiveCallPictureInstance 
.const [201] = Utf8 (II)V 
.const [202] = Utf8 de/esolutions/fw/comm/dsi/kombipictureserver/DSIKombiPictureServerReply 
.const [203] = Utf8 indicationDynamicIcon 
.const [204] = Utf8 (II)V 
.const [205] = Utf8 de/esolutions/fw/comm/dsi/kombipictureserver/DSIKombiPictureServerReply 
.const [206] = Utf8 indicationInternalAddressID 
.const [207] = Utf8 (JI)V 
.const [208] = Utf8 de/esolutions/fw/comm/dsi/kombipictureserver/DSIKombiPictureServerReply 
.const [209] = Utf8 indicationAdbContactPicture 
.const [210] = Utf8 (JI)V 
.const [211] = Utf8 de/esolutions/fw/comm/dsi/kombipictureserver/DSIKombiPictureServerReply 
.const [212] = Utf8 indicationPictureStreamAbilities 
.const [213] = Utf8 ()V 
.const [214] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [215] = Utf8 getInt16 
.const [216] = Utf8 ()S 
.const [217] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [218] = Utf8 getOptionalInt8VarArray 
.const [219] = Utf8 ()[B 
.const [220] = Utf8 de/esolutions/fw/comm/dsi/kombipictureserver/DSIKombiPictureServerReply 
.const [221] = Utf8 indicationPictureStream 
.const [222] = Utf8 (ISSIIII[B)V 
.const [223] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [224] = Utf8 getOptionalString 
.const [225] = Utf8 ()Ljava/lang/String; 
.const [226] = Utf8 de/esolutions/fw/comm/dsi/kombipictureserver/DSIKombiPictureServerReply 
.const [227] = Utf8 asyncException 
.const [228] = Utf8 (ILjava/lang/String;I)V 
.const [229] = Utf8 de/esolutions/fw/comm/dsi/kombipictureserver/DSIKombiPictureServerReply 
.const [230] = Utf8 yyIndication 
.const [231] = Utf8 (Ljava/lang/String;Ljava/lang/String;)V 
.const [232] = Utf8 de/esolutions/fw/comm/dsi/kombipictureserver/impl/DSIKombiPictureServerReplyService 
.const [233] = Class [232] 
.const [234] = Utf8 de/esolutions/fw/comm/core/AbstractReplyService 
.const [235] = Class [234] 
.const [236] = Utf8 context 
.const [237] = Utf8 Lde/esolutions/fw/comm/core/CallContext; 
.const [238] = Utf8 dynamicHandle 
.const [239] = Utf8 I 
.const [240] = Utf8 p_DSIKombiPictureServerReply 
.const [241] = Utf8 Lde/esolutions/fw/comm/dsi/kombipictureserver/DSIKombiPictureServerReply; 
.const [242] = Utf8 Code 
.const [243] = Utf8 <init> 
.const [244] = Utf8 (Lde/esolutions/fw/comm/dsi/kombipictureserver/DSIKombiPictureServerReply;)V 
.const [245] = Utf8 nextDynamicHandle 
.const [246] = Utf8 ()I 
.const [247] = Utf8 getCallContext 
.const [248] = Utf8 ()Lde/esolutions/fw/comm/core/CallContext; 
.const [249] = Utf8 handleCallMethod 
.const [250] = Utf8 (SLde/esolutions/fw/util/serializer/IDeserializer;Lde/esolutions/fw/comm/core/IProxyFrontend;)V 
.const [251] = Utf8 <clinit> 
.const [252] = Utf8 ()V 
.end class 
