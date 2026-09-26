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
    .attribute [254] .code stack 7 locals 6 
        .catch [15] from L0 to L603 using L606 
L0:     iload_1 
L1:     tableswitch 15 
            L502 
            L576 
            L576 
            L122 
            L450 
            L576 
            L144 
            L576 
            L246 
            L544 
            L576 
            L576 
            L388 
            L338 
            L298 
            L176 
            L576 
            L92 
            L472 
            default : L576 

L92:    aload_2 
L93:    invokestatic [9] 
L96:    astore 4 
L98:    aload_2 
L99:    invokeinterface [41] 0 
L104:   istore 5 
L106:   aload_0 
L107:   getfield [28] 
L110:   aload 4 
L112:   iload 5 
L114:   invokeinterface [42] 0 
L119:   goto L603 
L122:   aload_2 
L123:   invokeinterface [41] 0 
L128:   istore 4 
L130:   aload_0 
L131:   getfield [28] 
L134:   iload 4 
L136:   invokeinterface [43] 0 
L141:   goto L603 
L144:   aload_2 
L145:   invokeinterface [41] 0 
L150:   istore 4 
L152:   aload_2 
L153:   invokeinterface [41] 0 
L158:   istore 5 
L160:   aload_0 
L161:   getfield [28] 
L164:   iload 4 
L166:   iload 5 
L168:   invokeinterface [44] 0 
L173:   goto L603 
L176:   aload_2 
L177:   invokeinterface [41] 0 
L182:   istore 4 
L184:   aload_2 
L185:   invokeinterface [41] 0 
L190:   istore 5 
L192:   aload_2 
L193:   invokestatic [10] 
L196:   astore 6 
L198:   aload_2 
L199:   invokeinterface [41] 0 
L204:   istore 7 
L206:   aload_2 
L207:   invokeinterface [45] 0 
L212:   astore 8 
L214:   aload_2 
L215:   invokeinterface [45] 0 
L220:   astore 9 
L222:   aload_0 
L223:   getfield [28] 
L226:   iload 4 
L228:   iload 5 
L230:   aload 6 
L232:   iload 7 
L234:   aload 8 
L236:   aload 9 
L238:   invokeinterface [46] 0 
L243:   goto L603 
L246:   aload_2 
L247:   invokeinterface [41] 0 
L252:   istore 4 
L254:   aload_2 
L255:   invokeinterface [41] 0 
L260:   istore 5 
L262:   aload_2 
L263:   invokeinterface [45] 0 
L268:   astore 6 
L270:   aload_2 
L271:   invokeinterface [45] 0 
L276:   astore 7 
L278:   aload_0 
L279:   getfield [28] 
L282:   iload 4 
L284:   iload 5 
L286:   aload 6 
L288:   aload 7 
L290:   invokeinterface [47] 0 
L295:   goto L603 
L298:   aload_2 
L299:   invokeinterface [41] 0 
L304:   istore 4 
L306:   aload_2 
L307:   invokestatic [10] 
L310:   astore 5 
L312:   aload_2 
L313:   invokeinterface [41] 0 
L318:   istore 6 
L320:   aload_0 
L321:   getfield [28] 
L324:   iload 4 
L326:   aload 5 
L328:   iload 6 
L330:   invokeinterface [48] 0 
L335:   goto L603 
L338:   aload_2 
L339:   invokeinterface [41] 0 
L344:   istore 4 
L346:   aload_2 
L347:   invokeinterface [41] 0 
L352:   istore 5 
L354:   aload_2 
L355:   invokestatic [10] 
L358:   astore 6 
L360:   aload_2 
L361:   invokeinterface [41] 0 
L366:   istore 7 
L368:   aload_0 
L369:   getfield [28] 
L372:   iload 4 
L374:   iload 5 
L376:   aload 6 
L378:   iload 7 
L380:   invokeinterface [49] 0 
L385:   goto L603 
L388:   aload_2 
L389:   invokeinterface [41] 0 
L394:   istore 4 
L396:   aload_2 
L397:   invokeinterface [41] 0 
L402:   istore 5 
L404:   aload_2 
L405:   invokeinterface [41] 0 
L410:   istore 6 
L412:   aload_2 
L413:   invokeinterface [45] 0 
L418:   astore 7 
L420:   aload_2 
L421:   invokeinterface [41] 0 
L426:   istore 8 
L428:   aload_0 
L429:   getfield [28] 
L432:   iload 4 
L434:   iload 5 
L436:   iload 6 
L438:   aload 7 
L440:   iload 8 
L442:   invokeinterface [50] 0 
L447:   goto L603 
L450:   aload_2 
L451:   invokeinterface [41] 0 
L456:   istore 4 
L458:   aload_0 
L459:   getfield [28] 
L462:   iload 4 
L464:   invokeinterface [51] 0 
L469:   goto L603 
L472:   aload_2 
L473:   invokestatic [11] 
L476:   astore 4 
L478:   aload_2 
L479:   invokeinterface [41] 0 
L484:   istore 5 
L486:   aload_0 
L487:   getfield [28] 
L490:   aload 4 
L492:   iload 5 
L494:   invokeinterface [52] 0 
L499:   goto L603 
L502:   aload_2 
L503:   invokeinterface [41] 0 
L508:   istore 4 
L510:   aload_2 
L511:   invokeinterface [45] 0 
L516:   astore 5 
L518:   aload_2 
L519:   invokeinterface [41] 0 
L524:   istore 6 
L526:   aload_0 
L527:   getfield [28] 
L530:   iload 4 
L532:   aload 5 
L534:   iload 6 
L536:   invokeinterface [53] 0 
L541:   goto L603 
L544:   aload_2 
L545:   invokeinterface [45] 0 
L550:   astore 4 
L552:   aload_2 
L553:   invokeinterface [45] 0 
L558:   astore 5 
L560:   aload_0 
L561:   getfield [28] 
L564:   aload 4 
L566:   aload 5 
L568:   invokeinterface [54] 0 
L573:   goto L603 
L576:   new [55] 
L579:   dup 
L580:   new [56] 
L583:   dup 
L584:   invokespecial [37] 
L587:   ldc [14] 
L589:   invokevirtual [29] 
L592:   iload_1 
L593:   invokevirtual [30] 
L596:   invokevirtual [31] 
L599:   invokespecial [38] 
L602:   athrow 
L603:   goto L648 
L606:   astore 4 
L608:   new [55] 
L611:   dup 
L612:   new [56] 
L615:   dup 
L616:   invokespecial [37] 
L619:   ldc [16] 
L621:   invokevirtual [29] 
L624:   iload_1 
L625:   invokevirtual [30] 
L628:   ldc [17] 
L630:   invokevirtual [29] 
L633:   aload 4 
L635:   invokevirtual [32] 
L638:   invokevirtual [29] 
L641:   invokevirtual [31] 
L644:   invokespecial [38] 
L647:   athrow 
L648:   return 
L649:   nop 
L650:   nop 
L651:   nop 
L652:   
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
.const [58] = Utf8 '42dbbcd2-3ea6-5bd5-bf1c-1688f4fb8458' 
.const [59] = Class [145] 
.const [60] = NameAndType [146] [147] 
.const [61] = Utf8 '1f064d36-4f05-57d2-af73-a3c0a190b478' 
.const [62] = Utf8 'dsi.organizer.DSIAdbList' 
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
.const [79] = Utf8 'STUB.dsi.organizer.DSIAdbList' 
.const [80] = Class [163] 
.const [81] = NameAndType [164] [165] 
.const [82] = Utf8 de/esolutions/fw/comm/dsi/organizer/impl/DSIAdbListReplyService 
.const [83] = Utf8 de/esolutions/fw/comm/core/AbstractReplyService 
.const [84] = Utf8 de/esolutions/fw/comm/dsi/organizer/impl/AdbViewSizeSerializer 
.const [85] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [86] = Utf8 de/esolutions/fw/comm/dsi/organizer/DSIAdbListReply 
.const [87] = Utf8 de/esolutions/fw/comm/dsi/organizer/impl/DataSetSerializer 
.const [88] = Utf8 de/esolutions/fw/comm/dsi/organizer/impl/IndexInformationSerializer 
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
.const [145] = Utf8 de/esolutions/fw/comm/dsi/organizer/impl/DSIAdbListReplyService 
.const [146] = Utf8 nextDynamicHandle 
.const [147] = Utf8 ()I 
.const [148] = Utf8 de/esolutions/fw/comm/dsi/organizer/impl/DSIAdbListReplyService 
.const [149] = Utf8 dynamicHandle 
.const [150] = Utf8 I 
.const [151] = Utf8 de/esolutions/fw/comm/dsi/organizer/impl/DSIAdbListReplyService 
.const [152] = Utf8 context 
.const [153] = Utf8 Lde/esolutions/fw/comm/core/CallContext; 
.const [154] = Utf8 de/esolutions/fw/comm/dsi/organizer/impl/AdbViewSizeSerializer 
.const [155] = Utf8 getOptionalAdbViewSize 
.const [156] = Utf8 (Lde/esolutions/fw/util/serializer/IDeserializer;)Lorg/dsi/ifc/organizer/AdbViewSize; 
.const [157] = Utf8 de/esolutions/fw/comm/dsi/organizer/impl/DataSetSerializer 
.const [158] = Utf8 getOptionalDataSetVarArray 
.const [159] = Utf8 (Lde/esolutions/fw/util/serializer/IDeserializer;)[Lorg/dsi/ifc/organizer/DataSet; 
.const [160] = Utf8 de/esolutions/fw/comm/dsi/organizer/impl/IndexInformationSerializer 
.const [161] = Utf8 getOptionalIndexInformationVarArray 
.const [162] = Utf8 (Lde/esolutions/fw/util/serializer/IDeserializer;)[Lorg/dsi/ifc/organizer/IndexInformation; 
.const [163] = Utf8 de/esolutions/fw/comm/core/CallContext 
.const [164] = Utf8 getContext 
.const [165] = Utf8 (Ljava/lang/String;)Lde/esolutions/fw/comm/core/CallContext; 
.const [166] = Utf8 de/esolutions/fw/comm/dsi/organizer/impl/DSIAdbListReplyService 
.const [167] = Utf8 p_DSIAdbListReply 
.const [168] = Utf8 Lde/esolutions/fw/comm/dsi/organizer/DSIAdbListReply; 
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
.const [187] = Utf8 de/esolutions/fw/comm/dsi/organizer/impl/DSIAdbListReplyService 
.const [188] = Utf8 dynamicHandle 
.const [189] = Utf8 I 
.const [190] = Utf8 de/esolutions/fw/comm/dsi/organizer/impl/DSIAdbListReplyService 
.const [191] = Utf8 context 
.const [192] = Utf8 Lde/esolutions/fw/comm/core/CallContext; 
.const [193] = Utf8 java/lang/StringBuffer 
.const [194] = Utf8 <init> 
.const [195] = Utf8 ()V 
.const [196] = Utf8 de/esolutions/fw/comm/core/method/MethodException 
.const [197] = Utf8 <init> 
.const [198] = Utf8 (Ljava/lang/String;)V 
.const [199] = Utf8 de/esolutions/fw/comm/dsi/organizer/impl/DSIAdbListReplyService 
.const [200] = Utf8 p_DSIAdbListReply 
.const [201] = Utf8 Lde/esolutions/fw/comm/dsi/organizer/DSIAdbListReply; 
.const [202] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [203] = Utf8 getInt32 
.const [204] = Utf8 ()I 
.const [205] = Utf8 de/esolutions/fw/comm/dsi/organizer/DSIAdbListReply 
.const [206] = Utf8 updateViewSize 
.const [207] = Utf8 (Lorg/dsi/ifc/organizer/AdbViewSize;I)V 
.const [208] = Utf8 de/esolutions/fw/comm/dsi/organizer/DSIAdbListReply 
.const [209] = Utf8 invalidData 
.const [210] = Utf8 (I)V 
.const [211] = Utf8 de/esolutions/fw/comm/dsi/organizer/DSIAdbListReply 
.const [212] = Utf8 stopSpellerResult 
.const [213] = Utf8 (II)V 
.const [214] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [215] = Utf8 getOptionalString 
.const [216] = Utf8 ()Ljava/lang/String; 
.const [217] = Utf8 de/esolutions/fw/comm/dsi/organizer/DSIAdbListReply 
.const [218] = Utf8 spellerResult 
.const [219] = Utf8 (II[Lorg/dsi/ifc/organizer/DataSet;ILjava/lang/String;Ljava/lang/String;)V 
.const [220] = Utf8 de/esolutions/fw/comm/dsi/organizer/DSIAdbListReply 
.const [221] = Utf8 validateSpellerCharsResult 
.const [222] = Utf8 (IILjava/lang/String;Ljava/lang/String;)V 
.const [223] = Utf8 de/esolutions/fw/comm/dsi/organizer/DSIAdbListReply 
.const [224] = Utf8 getViewWindowResult 
.const [225] = Utf8 (I[Lorg/dsi/ifc/organizer/DataSet;I)V 
.const [226] = Utf8 de/esolutions/fw/comm/dsi/organizer/DSIAdbListReply 
.const [227] = Utf8 getSpellerViewWindowResult 
.const [228] = Utf8 (II[Lorg/dsi/ifc/organizer/DataSet;I)V 
.const [229] = Utf8 de/esolutions/fw/comm/dsi/organizer/DSIAdbListReply 
.const [230] = Utf8 getValidHanziCharsWindowResult 
.const [231] = Utf8 (IIILjava/lang/String;I)V 
.const [232] = Utf8 de/esolutions/fw/comm/dsi/organizer/DSIAdbListReply 
.const [233] = Utf8 setListStyleResult 
.const [234] = Utf8 (I)V 
.const [235] = Utf8 de/esolutions/fw/comm/dsi/organizer/DSIAdbListReply 
.const [236] = Utf8 updateAlphabeticalIndex 
.const [237] = Utf8 ([Lorg/dsi/ifc/organizer/IndexInformation;I)V 
.const [238] = Utf8 de/esolutions/fw/comm/dsi/organizer/DSIAdbListReply 
.const [239] = Utf8 asyncException 
.const [240] = Utf8 (ILjava/lang/String;I)V 
.const [241] = Utf8 de/esolutions/fw/comm/dsi/organizer/DSIAdbListReply 
.const [242] = Utf8 yyIndication 
.const [243] = Utf8 (Ljava/lang/String;Ljava/lang/String;)V 
.const [244] = Utf8 de/esolutions/fw/comm/dsi/organizer/impl/DSIAdbListReplyService 
.const [245] = Class [244] 
.const [246] = Utf8 de/esolutions/fw/comm/core/AbstractReplyService 
.const [247] = Class [246] 
.const [248] = Utf8 context 
.const [249] = Utf8 Lde/esolutions/fw/comm/core/CallContext; 
.const [250] = Utf8 dynamicHandle 
.const [251] = Utf8 I 
.const [252] = Utf8 p_DSIAdbListReply 
.const [253] = Utf8 Lde/esolutions/fw/comm/dsi/organizer/DSIAdbListReply; 
.const [254] = Utf8 Code 
.const [255] = Utf8 <init> 
.const [256] = Utf8 (Lde/esolutions/fw/comm/dsi/organizer/DSIAdbListReply;)V 
.const [257] = Utf8 nextDynamicHandle 
.const [258] = Utf8 ()I 
.const [259] = Utf8 getCallContext 
.const [260] = Utf8 ()Lde/esolutions/fw/comm/core/CallContext; 
.const [261] = Utf8 handleCallMethod 
.const [262] = Utf8 (SLde/esolutions/fw/util/serializer/IDeserializer;Lde/esolutions/fw/comm/core/IProxyFrontend;)V 
.const [263] = Utf8 <clinit> 
.const [264] = Utf8 ()V 
.end class 
