.version 50 0 
.class public super [285] 
.super [287] 
.field private static final [288] [289] 
.field private static [290] [291] 
.field private [292] [293] 

.method public [295] : [296] 
    .attribute [294] .code stack 7 locals 0 
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

.method private static synchronized [297] : [298] 
    .attribute [294] .code stack 2 locals 1 
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

.method public [299] : [300] 
    .attribute [294] .code stack 1 locals 0 
L0:     getstatic [8] 
L3:     areturn 
L4:     
    .end code 
.end method 

.method public [301] : [302] 
    .attribute [294] .code stack 4 locals 3 
        .catch [14] from L0 to L771 using L774 
L0:     iload_1 
L1:     tableswitch 0 
            L670 
            L744 
            L416 
            L744 
            L480 
            L744 
            L512 
            L744 
            L448 
            L744 
            L744 
            L744 
            L744 
            L576 
            L744 
            L744 
            L744 
            L544 
            L744 
            L608 
            L744 
            L744 
            L744 
            L152 
            L310 
            L384 
            L214 
            L278 
            L246 
            L352 
            L182 
            L712 
            L744 
            L640 
            default : L744 

L152:   aload_2 
L153:   invokestatic [9] 
L156:   astore 4 
L158:   aload_2 
L159:   invokeinterface [39] 0 
L164:   istore 5 
L166:   aload_0 
L167:   getfield [26] 
L170:   aload 4 
L172:   iload 5 
L174:   invokeinterface [40] 0 
L179:   goto L771 
L182:   aload_2 
L183:   invokeinterface [39] 0 
L188:   istore 4 
L190:   aload_2 
L191:   invokeinterface [39] 0 
L196:   istore 5 
L198:   aload_0 
L199:   getfield [26] 
L202:   iload 4 
L204:   iload 5 
L206:   invokeinterface [41] 0 
L211:   goto L771 
L214:   aload_2 
L215:   invokeinterface [39] 0 
L220:   istore 4 
L222:   aload_2 
L223:   invokeinterface [39] 0 
L228:   istore 5 
L230:   aload_0 
L231:   getfield [26] 
L234:   iload 4 
L236:   iload 5 
L238:   invokeinterface [42] 0 
L243:   goto L771 
L246:   aload_2 
L247:   invokeinterface [39] 0 
L252:   istore 4 
L254:   aload_2 
L255:   invokeinterface [39] 0 
L260:   istore 5 
L262:   aload_0 
L263:   getfield [26] 
L266:   iload 4 
L268:   iload 5 
L270:   invokeinterface [43] 0 
L275:   goto L771 
L278:   aload_2 
L279:   invokeinterface [39] 0 
L284:   istore 4 
L286:   aload_2 
L287:   invokeinterface [39] 0 
L292:   istore 5 
L294:   aload_0 
L295:   getfield [26] 
L298:   iload 4 
L300:   iload 5 
L302:   invokeinterface [44] 0 
L307:   goto L771 
L310:   aload_2 
L311:   invokeinterface [39] 0 
L316:   istore 4 
L318:   aload_2 
L319:   invokeinterface [39] 0 
L324:   istore 5 
L326:   aload_2 
L327:   invokeinterface [39] 0 
L332:   istore 6 
L334:   aload_0 
L335:   getfield [26] 
L338:   iload 4 
L340:   iload 5 
L342:   iload 6 
L344:   invokeinterface [45] 0 
L349:   goto L771 
L352:   aload_2 
L353:   invokeinterface [39] 0 
L358:   istore 4 
L360:   aload_2 
L361:   invokeinterface [39] 0 
L366:   istore 5 
L368:   aload_0 
L369:   getfield [26] 
L372:   iload 4 
L374:   iload 5 
L376:   invokeinterface [46] 0 
L381:   goto L771 
L384:   aload_2 
L385:   invokeinterface [39] 0 
L390:   istore 4 
L392:   aload_2 
L393:   invokeinterface [39] 0 
L398:   istore 5 
L400:   aload_0 
L401:   getfield [26] 
L404:   iload 4 
L406:   iload 5 
L408:   invokeinterface [47] 0 
L413:   goto L771 
L416:   aload_2 
L417:   invokeinterface [48] 0 
L422:   lstore 4 
L424:   aload_2 
L425:   invokeinterface [39] 0 
L430:   istore 6 
L432:   aload_0 
L433:   getfield [26] 
L436:   lload 4 
L438:   iload 6 
L440:   invokeinterface [49] 0 
L445:   goto L771 
L448:   aload_2 
L449:   invokeinterface [48] 0 
L454:   lstore 4 
L456:   aload_2 
L457:   invokeinterface [39] 0 
L462:   istore 6 
L464:   aload_0 
L465:   getfield [26] 
L468:   lload 4 
L470:   iload 6 
L472:   invokeinterface [50] 0 
L477:   goto L771 
L480:   aload_2 
L481:   invokeinterface [48] 0 
L486:   lstore 4 
L488:   aload_2 
L489:   invokeinterface [39] 0 
L494:   istore 6 
L496:   aload_0 
L497:   getfield [26] 
L500:   lload 4 
L502:   iload 6 
L504:   invokeinterface [51] 0 
L509:   goto L771 
L512:   aload_2 
L513:   invokeinterface [48] 0 
L518:   lstore 4 
L520:   aload_2 
L521:   invokeinterface [39] 0 
L526:   istore 6 
L528:   aload_0 
L529:   getfield [26] 
L532:   lload 4 
L534:   iload 6 
L536:   invokeinterface [52] 0 
L541:   goto L771 
L544:   aload_2 
L545:   invokeinterface [53] 0 
L550:   astore 4 
L552:   aload_2 
L553:   invokeinterface [39] 0 
L558:   istore 5 
L560:   aload_0 
L561:   getfield [26] 
L564:   aload 4 
L566:   iload 5 
L568:   invokeinterface [54] 0 
L573:   goto L771 
L576:   aload_2 
L577:   invokeinterface [53] 0 
L582:   astore 4 
L584:   aload_2 
L585:   invokeinterface [39] 0 
L590:   istore 5 
L592:   aload_0 
L593:   getfield [26] 
L596:   aload 4 
L598:   iload 5 
L600:   invokeinterface [55] 0 
L605:   goto L771 
L608:   aload_2 
L609:   invokeinterface [53] 0 
L614:   astore 4 
L616:   aload_2 
L617:   invokeinterface [39] 0 
L622:   istore 5 
L624:   aload_0 
L625:   getfield [26] 
L628:   aload 4 
L630:   iload 5 
L632:   invokeinterface [56] 0 
L637:   goto L771 
L640:   aload_2 
L641:   invokeinterface [53] 0 
L646:   astore 4 
L648:   aload_2 
L649:   invokestatic [10] 
L652:   astore 5 
L654:   aload_0 
L655:   getfield [26] 
L658:   aload 4 
L660:   aload 5 
L662:   invokeinterface [57] 0 
L667:   goto L771 
L670:   aload_2 
L671:   invokeinterface [39] 0 
L676:   istore 4 
L678:   aload_2 
L679:   invokeinterface [58] 0 
L684:   astore 5 
L686:   aload_2 
L687:   invokeinterface [39] 0 
L692:   istore 6 
L694:   aload_0 
L695:   getfield [26] 
L698:   iload 4 
L700:   aload 5 
L702:   iload 6 
L704:   invokeinterface [59] 0 
L709:   goto L771 
L712:   aload_2 
L713:   invokeinterface [58] 0 
L718:   astore 4 
L720:   aload_2 
L721:   invokeinterface [58] 0 
L726:   astore 5 
L728:   aload_0 
L729:   getfield [26] 
L732:   aload 4 
L734:   aload 5 
L736:   invokeinterface [60] 0 
L741:   goto L771 
L744:   new [61] 
L747:   dup 
L748:   new [62] 
L751:   dup 
L752:   invokespecial [35] 
L755:   ldc [13] 
L757:   invokevirtual [27] 
L760:   iload_1 
L761:   invokevirtual [28] 
L764:   invokevirtual [29] 
L767:   invokespecial [36] 
L770:   athrow 
L771:   goto L816 
L774:   astore 4 
L776:   new [61] 
L779:   dup 
L780:   new [62] 
L783:   dup 
L784:   invokespecial [35] 
L787:   ldc [15] 
L789:   invokevirtual [27] 
L792:   iload_1 
L793:   invokevirtual [28] 
L796:   ldc [16] 
L798:   invokevirtual [27] 
L801:   aload 4 
L803:   invokevirtual [30] 
L806:   invokevirtual [27] 
L809:   invokevirtual [29] 
L812:   invokespecial [36] 
L815:   athrow 
L816:   return 
L817:   nop 
L818:   nop 
L819:   nop 
L820:   
    .end code 
.end method 

.method static [303] : [304] 
    .attribute [294] .code stack 1 locals 0 
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
.const [2] = Class [63] 
.const [3] = String [64] 
.const [4] = Method [65] [66] 
.const [5] = String [67] 
.const [6] = String [68] 
.const [7] = Field [69] [70] 
.const [8] = Field [71] [72] 
.const [9] = Method [73] [74] 
.const [10] = Method [75] [76] 
.const [11] = Class [77] 
.const [12] = Class [78] 
.const [13] = String [79] 
.const [14] = Class [80] 
.const [15] = String [81] 
.const [16] = String [82] 
.const [17] = String [83] 
.const [18] = Method [84] [85] 
.const [19] = Class [86] 
.const [20] = Class [87] 
.const [21] = Class [88] 
.const [22] = Class [89] 
.const [23] = Class [90] 
.const [24] = Class [91] 
.const [25] = Class [92] 
.const [26] = Field [93] [94] 
.const [27] = Method [95] [96] 
.const [28] = Method [97] [98] 
.const [29] = Method [99] [100] 
.const [30] = Method [101] [102] 
.const [31] = Method [103] [104] 
.const [32] = Method [105] [106] 
.const [33] = Field [107] [108] 
.const [34] = Field [109] [110] 
.const [35] = Method [111] [112] 
.const [36] = Method [113] [114] 
.const [37] = Class [115] 
.const [38] = Field [116] [117] 
.const [39] = InterfaceMethod [118] [119] 
.const [40] = InterfaceMethod [120] [121] 
.const [41] = InterfaceMethod [122] [123] 
.const [42] = InterfaceMethod [124] [125] 
.const [43] = InterfaceMethod [126] [127] 
.const [44] = InterfaceMethod [128] [129] 
.const [45] = InterfaceMethod [130] [131] 
.const [46] = InterfaceMethod [132] [133] 
.const [47] = InterfaceMethod [134] [135] 
.const [48] = InterfaceMethod [136] [137] 
.const [49] = InterfaceMethod [138] [139] 
.const [50] = InterfaceMethod [140] [141] 
.const [51] = InterfaceMethod [142] [143] 
.const [52] = InterfaceMethod [144] [145] 
.const [53] = InterfaceMethod [146] [147] 
.const [54] = InterfaceMethod [148] [149] 
.const [55] = InterfaceMethod [150] [151] 
.const [56] = InterfaceMethod [152] [153] 
.const [57] = InterfaceMethod [154] [155] 
.const [58] = InterfaceMethod [156] [157] 
.const [59] = InterfaceMethod [158] [159] 
.const [60] = InterfaceMethod [160] [161] 
.const [61] = Class [162] 
.const [62] = Class [163] 
.const [63] = Utf8 de/esolutions/fw/comm/core/ServiceInstanceID 
.const [64] = Utf8 '6afc3000-ee79-58d1-bd7b-c2ed0e0804bd' 
.const [65] = Class [164] 
.const [66] = NameAndType [165] [166] 
.const [67] = Utf8 '4d4866c8-b77a-58e3-89ce-99092a93d36f' 
.const [68] = Utf8 'dsi.navigation.DSIBlocking' 
.const [69] = Class [167] 
.const [70] = NameAndType [168] [169] 
.const [71] = Class [170] 
.const [72] = NameAndType [171] [172] 
.const [73] = Class [173] 
.const [74] = NameAndType [174] [175] 
.const [75] = Class [176] 
.const [76] = NameAndType [177] [178] 
.const [77] = Utf8 de/esolutions/fw/comm/core/method/MethodException 
.const [78] = Utf8 java/lang/StringBuffer 
.const [79] = Utf8 'Invalid Method Id ' 
.const [80] = Utf8 de/esolutions/fw/util/serializer/exception/SerializerException 
.const [81] = Utf8 'Deserialization failed: method=' 
.const [82] = Utf8 ', error=' 
.const [83] = Utf8 'STUB.dsi.navigation.DSIBlocking' 
.const [84] = Class [179] 
.const [85] = NameAndType [180] [181] 
.const [86] = Utf8 de/esolutions/fw/comm/dsi/navigation/impl/DSIBlockingReplyService 
.const [87] = Utf8 de/esolutions/fw/comm/core/AbstractReplyService 
.const [88] = Utf8 de/esolutions/fw/comm/dsi/navigation/impl/BlockElementSerializer 
.const [89] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [90] = Utf8 de/esolutions/fw/comm/dsi/navigation/DSIBlockingReply 
.const [91] = Utf8 de/esolutions/fw/comm/dsi/global/impl/NavRectangleSerializer 
.const [92] = Utf8 de/esolutions/fw/comm/core/CallContext 
.const [93] = Class [182] 
.const [94] = NameAndType [183] [184] 
.const [95] = Class [185] 
.const [96] = NameAndType [186] [187] 
.const [97] = Class [188] 
.const [98] = NameAndType [189] [190] 
.const [99] = Class [191] 
.const [100] = NameAndType [192] [193] 
.const [101] = Class [194] 
.const [102] = NameAndType [195] [196] 
.const [103] = Class [197] 
.const [104] = NameAndType [198] [199] 
.const [105] = Class [200] 
.const [106] = NameAndType [201] [202] 
.const [107] = Class [203] 
.const [108] = NameAndType [204] [205] 
.const [109] = Class [206] 
.const [110] = NameAndType [207] [208] 
.const [111] = Class [209] 
.const [112] = NameAndType [210] [211] 
.const [113] = Class [212] 
.const [114] = NameAndType [213] [214] 
.const [115] = Utf8 de/esolutions/fw/comm/core/ServiceInstanceID 
.const [116] = Class [215] 
.const [117] = NameAndType [216] [217] 
.const [118] = Class [218] 
.const [119] = NameAndType [219] [220] 
.const [120] = Class [221] 
.const [121] = NameAndType [222] [223] 
.const [122] = Class [224] 
.const [123] = NameAndType [225] [226] 
.const [124] = Class [227] 
.const [125] = NameAndType [228] [229] 
.const [126] = Class [230] 
.const [127] = NameAndType [231] [232] 
.const [128] = Class [233] 
.const [129] = NameAndType [234] [235] 
.const [130] = Class [236] 
.const [131] = NameAndType [237] [238] 
.const [132] = Class [239] 
.const [133] = NameAndType [240] [241] 
.const [134] = Class [242] 
.const [135] = NameAndType [243] [244] 
.const [136] = Class [245] 
.const [137] = NameAndType [246] [247] 
.const [138] = Class [248] 
.const [139] = NameAndType [249] [250] 
.const [140] = Class [251] 
.const [141] = NameAndType [252] [253] 
.const [142] = Class [254] 
.const [143] = NameAndType [255] [256] 
.const [144] = Class [257] 
.const [145] = NameAndType [258] [259] 
.const [146] = Class [260] 
.const [147] = NameAndType [261] [262] 
.const [148] = Class [263] 
.const [149] = NameAndType [264] [265] 
.const [150] = Class [266] 
.const [151] = NameAndType [267] [268] 
.const [152] = Class [269] 
.const [153] = NameAndType [270] [271] 
.const [154] = Class [272] 
.const [155] = NameAndType [273] [274] 
.const [156] = Class [275] 
.const [157] = NameAndType [276] [277] 
.const [158] = Class [278] 
.const [159] = NameAndType [279] [280] 
.const [160] = Class [281] 
.const [161] = NameAndType [282] [283] 
.const [162] = Utf8 de/esolutions/fw/comm/core/method/MethodException 
.const [163] = Utf8 java/lang/StringBuffer 
.const [164] = Utf8 de/esolutions/fw/comm/dsi/navigation/impl/DSIBlockingReplyService 
.const [165] = Utf8 nextDynamicHandle 
.const [166] = Utf8 ()I 
.const [167] = Utf8 de/esolutions/fw/comm/dsi/navigation/impl/DSIBlockingReplyService 
.const [168] = Utf8 dynamicHandle 
.const [169] = Utf8 I 
.const [170] = Utf8 de/esolutions/fw/comm/dsi/navigation/impl/DSIBlockingReplyService 
.const [171] = Utf8 context 
.const [172] = Utf8 Lde/esolutions/fw/comm/core/CallContext; 
.const [173] = Utf8 de/esolutions/fw/comm/dsi/navigation/impl/BlockElementSerializer 
.const [174] = Utf8 getOptionalBlockElementVarArray 
.const [175] = Utf8 (Lde/esolutions/fw/util/serializer/IDeserializer;)[Lorg/dsi/ifc/navigation/BlockElement; 
.const [176] = Utf8 de/esolutions/fw/comm/dsi/global/impl/NavRectangleSerializer 
.const [177] = Utf8 getOptionalNavRectangle 
.const [178] = Utf8 (Lde/esolutions/fw/util/serializer/IDeserializer;)Lorg/dsi/ifc/global/NavRectangle; 
.const [179] = Utf8 de/esolutions/fw/comm/core/CallContext 
.const [180] = Utf8 getContext 
.const [181] = Utf8 (Ljava/lang/String;)Lde/esolutions/fw/comm/core/CallContext; 
.const [182] = Utf8 de/esolutions/fw/comm/dsi/navigation/impl/DSIBlockingReplyService 
.const [183] = Utf8 p_DSIBlockingReply 
.const [184] = Utf8 Lde/esolutions/fw/comm/dsi/navigation/DSIBlockingReply; 
.const [185] = Utf8 java/lang/StringBuffer 
.const [186] = Utf8 append 
.const [187] = Utf8 (Ljava/lang/String;)Ljava/lang/StringBuffer; 
.const [188] = Utf8 java/lang/StringBuffer 
.const [189] = Utf8 append 
.const [190] = Utf8 (I)Ljava/lang/StringBuffer; 
.const [191] = Utf8 java/lang/StringBuffer 
.const [192] = Utf8 toString 
.const [193] = Utf8 ()Ljava/lang/String; 
.const [194] = Utf8 de/esolutions/fw/util/serializer/exception/SerializerException 
.const [195] = Utf8 getMessage 
.const [196] = Utf8 ()Ljava/lang/String; 
.const [197] = Utf8 de/esolutions/fw/comm/core/ServiceInstanceID 
.const [198] = Utf8 <init> 
.const [199] = Utf8 (Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V 
.const [200] = Utf8 de/esolutions/fw/comm/core/AbstractReplyService 
.const [201] = Utf8 <init> 
.const [202] = Utf8 (Lde/esolutions/fw/comm/core/ServiceInstanceID;)V 
.const [203] = Utf8 de/esolutions/fw/comm/dsi/navigation/impl/DSIBlockingReplyService 
.const [204] = Utf8 dynamicHandle 
.const [205] = Utf8 I 
.const [206] = Utf8 de/esolutions/fw/comm/dsi/navigation/impl/DSIBlockingReplyService 
.const [207] = Utf8 context 
.const [208] = Utf8 Lde/esolutions/fw/comm/core/CallContext; 
.const [209] = Utf8 java/lang/StringBuffer 
.const [210] = Utf8 <init> 
.const [211] = Utf8 ()V 
.const [212] = Utf8 de/esolutions/fw/comm/core/method/MethodException 
.const [213] = Utf8 <init> 
.const [214] = Utf8 (Ljava/lang/String;)V 
.const [215] = Utf8 de/esolutions/fw/comm/dsi/navigation/impl/DSIBlockingReplyService 
.const [216] = Utf8 p_DSIBlockingReply 
.const [217] = Utf8 Lde/esolutions/fw/comm/dsi/navigation/DSIBlockingReply; 
.const [218] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [219] = Utf8 getInt32 
.const [220] = Utf8 ()I 
.const [221] = Utf8 de/esolutions/fw/comm/dsi/navigation/DSIBlockingReply 
.const [222] = Utf8 updateListOfBlocks 
.const [223] = Utf8 ([Lorg/dsi/ifc/navigation/BlockElement;I)V 
.const [224] = Utf8 de/esolutions/fw/comm/dsi/navigation/DSIBlockingReply 
.const [225] = Utf8 updateNaviCoreAvailableToSetBlocks 
.const [226] = Utf8 (II)V 
.const [227] = Utf8 de/esolutions/fw/comm/dsi/navigation/DSIBlockingReply 
.const [228] = Utf8 updateMaximumNumberOfBlockedAreas 
.const [229] = Utf8 (II)V 
.const [230] = Utf8 de/esolutions/fw/comm/dsi/navigation/DSIBlockingReply 
.const [231] = Utf8 updateMaximumNumberOfBlockedRouteSegments 
.const [232] = Utf8 (II)V 
.const [233] = Utf8 de/esolutions/fw/comm/dsi/navigation/DSIBlockingReply 
.const [234] = Utf8 updateMaximumNumberOfBlockedRoadSegments 
.const [235] = Utf8 (II)V 
.const [236] = Utf8 de/esolutions/fw/comm/dsi/navigation/DSIBlockingReply 
.const [237] = Utf8 updateMaximumDimensionsOfBlockedArea 
.const [238] = Utf8 (III)V 
.const [239] = Utf8 de/esolutions/fw/comm/dsi/navigation/DSIBlockingReply 
.const [240] = Utf8 updateMaximumSegmentLengthOfBlockedRouteSegment 
.const [241] = Utf8 (II)V 
.const [242] = Utf8 de/esolutions/fw/comm/dsi/navigation/DSIBlockingReply 
.const [243] = Utf8 updateMaximumLengthOfBlockRouteBasedOnLength 
.const [244] = Utf8 (II)V 
.const [245] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [246] = Utf8 getInt64 
.const [247] = Utf8 ()J 
.const [248] = Utf8 de/esolutions/fw/comm/dsi/navigation/DSIBlockingReply 
.const [249] = Utf8 blockAreaResult 
.const [250] = Utf8 (JI)V 
.const [251] = Utf8 de/esolutions/fw/comm/dsi/navigation/DSIBlockingReply 
.const [252] = Utf8 blockRouteSegmentsResult 
.const [253] = Utf8 (JI)V 
.const [254] = Utf8 de/esolutions/fw/comm/dsi/navigation/DSIBlockingReply 
.const [255] = Utf8 blockRoadSegmentsResult 
.const [256] = Utf8 (JI)V 
.const [257] = Utf8 de/esolutions/fw/comm/dsi/navigation/DSIBlockingReply 
.const [258] = Utf8 blockRouteBasedOnLengthResult 
.const [259] = Utf8 (JI)V 
.const [260] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [261] = Utf8 getOptionalInt64VarArray 
.const [262] = Utf8 ()[J 
.const [263] = Utf8 de/esolutions/fw/comm/dsi/navigation/DSIBlockingReply 
.const [264] = Utf8 persistBlockResult 
.const [265] = Utf8 ([JI)V 
.const [266] = Utf8 de/esolutions/fw/comm/dsi/navigation/DSIBlockingReply 
.const [267] = Utf8 deleteBlockResult 
.const [268] = Utf8 ([JI)V 
.const [269] = Utf8 de/esolutions/fw/comm/dsi/navigation/DSIBlockingReply 
.const [270] = Utf8 setBlockDescriptionResult 
.const [271] = Utf8 ([JI)V 
.const [272] = Utf8 de/esolutions/fw/comm/dsi/navigation/DSIBlockingReply 
.const [273] = Utf8 getBoundingRectangleOfBlocksResult 
.const [274] = Utf8 ([JLorg/dsi/ifc/global/NavRectangle;)V 
.const [275] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [276] = Utf8 getOptionalString 
.const [277] = Utf8 ()Ljava/lang/String; 
.const [278] = Utf8 de/esolutions/fw/comm/dsi/navigation/DSIBlockingReply 
.const [279] = Utf8 asyncException 
.const [280] = Utf8 (ILjava/lang/String;I)V 
.const [281] = Utf8 de/esolutions/fw/comm/dsi/navigation/DSIBlockingReply 
.const [282] = Utf8 yyIndication 
.const [283] = Utf8 (Ljava/lang/String;Ljava/lang/String;)V 
.const [284] = Utf8 de/esolutions/fw/comm/dsi/navigation/impl/DSIBlockingReplyService 
.const [285] = Class [284] 
.const [286] = Utf8 de/esolutions/fw/comm/core/AbstractReplyService 
.const [287] = Class [286] 
.const [288] = Utf8 context 
.const [289] = Utf8 Lde/esolutions/fw/comm/core/CallContext; 
.const [290] = Utf8 dynamicHandle 
.const [291] = Utf8 I 
.const [292] = Utf8 p_DSIBlockingReply 
.const [293] = Utf8 Lde/esolutions/fw/comm/dsi/navigation/DSIBlockingReply; 
.const [294] = Utf8 Code 
.const [295] = Utf8 <init> 
.const [296] = Utf8 (Lde/esolutions/fw/comm/dsi/navigation/DSIBlockingReply;)V 
.const [297] = Utf8 nextDynamicHandle 
.const [298] = Utf8 ()I 
.const [299] = Utf8 getCallContext 
.const [300] = Utf8 ()Lde/esolutions/fw/comm/core/CallContext; 
.const [301] = Utf8 handleCallMethod 
.const [302] = Utf8 (SLde/esolutions/fw/util/serializer/IDeserializer;Lde/esolutions/fw/comm/core/IProxyFrontend;)V 
.const [303] = Utf8 <clinit> 
.const [304] = Utf8 ()V 
.end class 
