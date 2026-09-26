.version 50 0 
.class public super [249] 
.super [251] 
.field private static final [252] [253] 
.field private static [254] [255] 
.field private [256] [257] 

.method public [259] : [260] 
    .attribute [258] .code stack 7 locals 0 
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

.method private static synchronized [261] : [262] 
    .attribute [258] .code stack 2 locals 1 
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

.method public [263] : [264] 
    .attribute [258] .code stack 1 locals 0 
L0:     getstatic [8] 
L3:     areturn 
L4:     
    .end code 
.end method 

.method public [265] : [266] 
    .attribute [258] .code stack 14 locals 13 
        .catch [14] from L0 to L611 using L614 
L0:     iload_1 
L1:     tableswitch 2 
            L510 
            L584 
            L584 
            L584 
            L488 
            L166 
            L584 
            L584 
            L584 
            L584 
            L584 
            L584 
            L584 
            L584 
            L584 
            L124 
            L416 
            L352 
            L384 
            L584 
            L320 
            L198 
            L446 
            L552 
            L584 
            L584 
            L280 
            default : L584 

L124:   aload_2 
L125:   invokeinterface [39] 0 
L130:   lstore 4 
L132:   aload_2 
L133:   invokeinterface [39] 0 
L138:   lstore 6 
L140:   aload_2 
L141:   invokeinterface [40] 0 
L146:   istore 8 
L148:   aload_0 
L149:   getfield [26] 
L152:   lload 4 
L154:   lload 6 
L156:   iload 8 
L158:   invokeinterface [41] 0 
L163:   goto L611 
L166:   aload_2 
L167:   invokeinterface [40] 0 
L172:   istore 4 
L174:   aload_2 
L175:   invokeinterface [42] 0 
L180:   istore 5 
L182:   aload_0 
L183:   getfield [26] 
L186:   iload 4 
L188:   iload 5 
L190:   invokeinterface [43] 0 
L195:   goto L611 
L198:   aload_2 
L199:   invokeinterface [39] 0 
L204:   lstore 4 
L206:   aload_2 
L207:   invokeinterface [39] 0 
L212:   lstore 6 
L214:   aload_2 
L215:   invokeinterface [39] 0 
L220:   lstore 8 
L222:   aload_2 
L223:   invokeinterface [39] 0 
L228:   lstore 10 
L230:   aload_2 
L231:   invokeinterface [39] 0 
L236:   lstore 12 
L238:   aload_2 
L239:   invokeinterface [39] 0 
L244:   lstore 14 
L246:   aload_2 
L247:   invokeinterface [40] 0 
L252:   istore 16 
L254:   aload_0 
L255:   getfield [26] 
L258:   lload 4 
L260:   lload 6 
L262:   lload 8 
L264:   lload 10 
L266:   lload 12 
L268:   lload 14 
L270:   iload 16 
L272:   invokeinterface [44] 0 
L277:   goto L611 
L280:   aload_2 
L281:   invokeinterface [39] 0 
L286:   lstore 4 
L288:   aload_2 
L289:   invokestatic [9] 
L292:   astore 6 
L294:   aload_2 
L295:   invokeinterface [40] 0 
L300:   istore 7 
L302:   aload_0 
L303:   getfield [26] 
L306:   lload 4 
L308:   aload 6 
L310:   iload 7 
L312:   invokeinterface [45] 0 
L317:   goto L611 
L320:   aload_2 
L321:   invokeinterface [40] 0 
L326:   istore 4 
L328:   aload_2 
L329:   invokeinterface [40] 0 
L334:   istore 5 
L336:   aload_0 
L337:   getfield [26] 
L340:   iload 4 
L342:   iload 5 
L344:   invokeinterface [46] 0 
L349:   goto L611 
L352:   aload_2 
L353:   invokeinterface [39] 0 
L358:   lstore 4 
L360:   aload_2 
L361:   invokeinterface [40] 0 
L366:   istore 6 
L368:   aload_0 
L369:   getfield [26] 
L372:   lload 4 
L374:   iload 6 
L376:   invokeinterface [47] 0 
L381:   goto L611 
L384:   aload_2 
L385:   invokeinterface [40] 0 
L390:   istore 4 
L392:   aload_2 
L393:   invokeinterface [40] 0 
L398:   istore 5 
L400:   aload_0 
L401:   getfield [26] 
L404:   iload 4 
L406:   iload 5 
L408:   invokeinterface [48] 0 
L413:   goto L611 
L416:   aload_2 
L417:   invokestatic [10] 
L420:   astore 4 
L422:   aload_2 
L423:   invokeinterface [40] 0 
L428:   istore 5 
L430:   aload_0 
L431:   getfield [26] 
L434:   aload 4 
L436:   iload 5 
L438:   invokeinterface [49] 0 
L443:   goto L611 
L446:   aload_2 
L447:   invokeinterface [39] 0 
L452:   lstore 4 
L454:   aload_2 
L455:   invokeinterface [39] 0 
L460:   lstore 6 
L462:   aload_2 
L463:   invokeinterface [40] 0 
L468:   istore 8 
L470:   aload_0 
L471:   getfield [26] 
L474:   lload 4 
L476:   lload 6 
L478:   iload 8 
L480:   invokeinterface [50] 0 
L485:   goto L611 
L488:   aload_2 
L489:   invokeinterface [40] 0 
L494:   istore 4 
L496:   aload_0 
L497:   getfield [26] 
L500:   iload 4 
L502:   invokeinterface [51] 0 
L507:   goto L611 
L510:   aload_2 
L511:   invokeinterface [40] 0 
L516:   istore 4 
L518:   aload_2 
L519:   invokeinterface [52] 0 
L524:   astore 5 
L526:   aload_2 
L527:   invokeinterface [40] 0 
L532:   istore 6 
L534:   aload_0 
L535:   getfield [26] 
L538:   iload 4 
L540:   aload 5 
L542:   iload 6 
L544:   invokeinterface [53] 0 
L549:   goto L611 
L552:   aload_2 
L553:   invokeinterface [52] 0 
L558:   astore 4 
L560:   aload_2 
L561:   invokeinterface [52] 0 
L566:   astore 5 
L568:   aload_0 
L569:   getfield [26] 
L572:   aload 4 
L574:   aload 5 
L576:   invokeinterface [54] 0 
L581:   goto L611 
L584:   new [55] 
L587:   dup 
L588:   new [56] 
L591:   dup 
L592:   invokespecial [35] 
L595:   ldc [13] 
L597:   invokevirtual [27] 
L600:   iload_1 
L601:   invokevirtual [28] 
L604:   invokevirtual [29] 
L607:   invokespecial [36] 
L610:   athrow 
L611:   goto L656 
L614:   astore 4 
L616:   new [55] 
L619:   dup 
L620:   new [56] 
L623:   dup 
L624:   invokespecial [35] 
L627:   ldc [15] 
L629:   invokevirtual [27] 
L632:   iload_1 
L633:   invokevirtual [28] 
L636:   ldc [16] 
L638:   invokevirtual [27] 
L641:   aload 4 
L643:   invokevirtual [30] 
L646:   invokevirtual [27] 
L649:   invokevirtual [29] 
L652:   invokespecial [36] 
L655:   athrow 
L656:   return 
L657:   nop 
L658:   nop 
L659:   nop 
L660:   
    .end code 
.end method 

.method static [267] : [268] 
    .attribute [258] .code stack 1 locals 0 
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
.const [2] = Class [57] 
.const [3] = String [58] 
.const [4] = Method [59] [60] 
.const [5] = String [61] 
.const [6] = String [62] 
.const [7] = Field [63] [64] 
.const [8] = Field [65] [66] 
.const [9] = Method [67] [68] 
.const [10] = Method [69] [70] 
.const [11] = Class [71] 
.const [12] = Class [72] 
.const [13] = String [73] 
.const [14] = Class [74] 
.const [15] = String [75] 
.const [16] = String [76] 
.const [17] = String [77] 
.const [18] = Method [78] [79] 
.const [19] = Class [80] 
.const [20] = Class [81] 
.const [21] = Class [82] 
.const [22] = Class [83] 
.const [23] = Class [84] 
.const [24] = Class [85] 
.const [25] = Class [86] 
.const [26] = Field [87] [88] 
.const [27] = Method [89] [90] 
.const [28] = Method [91] [92] 
.const [29] = Method [93] [94] 
.const [30] = Method [95] [96] 
.const [31] = Method [97] [98] 
.const [32] = Method [99] [100] 
.const [33] = Field [101] [102] 
.const [34] = Field [103] [104] 
.const [35] = Method [105] [106] 
.const [36] = Method [107] [108] 
.const [37] = Class [109] 
.const [38] = Field [110] [111] 
.const [39] = InterfaceMethod [112] [113] 
.const [40] = InterfaceMethod [114] [115] 
.const [41] = InterfaceMethod [116] [117] 
.const [42] = InterfaceMethod [118] [119] 
.const [43] = InterfaceMethod [120] [121] 
.const [44] = InterfaceMethod [122] [123] 
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
.const [55] = Class [144] 
.const [56] = Class [145] 
.const [57] = Utf8 de/esolutions/fw/comm/core/ServiceInstanceID 
.const [58] = Utf8 '53731708-ed5a-5568-9cc2-de4fb8d324ab' 
.const [59] = Class [146] 
.const [60] = NameAndType [147] [148] 
.const [61] = Utf8 c64e24f0-2106-5742-87b0-661dfecd5ce0 
.const [62] = Utf8 'dsi.media.DSIMediaRecorder' 
.const [63] = Class [149] 
.const [64] = NameAndType [150] [151] 
.const [65] = Class [152] 
.const [66] = NameAndType [153] [154] 
.const [67] = Class [155] 
.const [68] = NameAndType [156] [157] 
.const [69] = Class [158] 
.const [70] = NameAndType [159] [160] 
.const [71] = Utf8 de/esolutions/fw/comm/core/method/MethodException 
.const [72] = Utf8 java/lang/StringBuffer 
.const [73] = Utf8 'Invalid Method Id ' 
.const [74] = Utf8 de/esolutions/fw/util/serializer/exception/SerializerException 
.const [75] = Utf8 'Deserialization failed: method=' 
.const [76] = Utf8 ', error=' 
.const [77] = Utf8 'STUB.dsi.media.DSIMediaRecorder' 
.const [78] = Class [161] 
.const [79] = NameAndType [162] [163] 
.const [80] = Utf8 de/esolutions/fw/comm/dsi/media/impl/DSIMediaRecorderReplyService 
.const [81] = Utf8 de/esolutions/fw/comm/core/AbstractReplyService 
.const [82] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [83] = Utf8 de/esolutions/fw/comm/dsi/media/DSIMediaRecorderReply 
.const [84] = Utf8 de/esolutions/fw/comm/dsi/media/impl/ListEntrySerializer 
.const [85] = Utf8 de/esolutions/fw/comm/dsi/media/impl/DatabaseSpaceSerializer 
.const [86] = Utf8 de/esolutions/fw/comm/core/CallContext 
.const [87] = Class [164] 
.const [88] = NameAndType [165] [166] 
.const [89] = Class [167] 
.const [90] = NameAndType [168] [169] 
.const [91] = Class [170] 
.const [92] = NameAndType [171] [172] 
.const [93] = Class [173] 
.const [94] = NameAndType [174] [175] 
.const [95] = Class [176] 
.const [96] = NameAndType [177] [178] 
.const [97] = Class [179] 
.const [98] = NameAndType [180] [181] 
.const [99] = Class [182] 
.const [100] = NameAndType [183] [184] 
.const [101] = Class [185] 
.const [102] = NameAndType [186] [187] 
.const [103] = Class [188] 
.const [104] = NameAndType [189] [190] 
.const [105] = Class [191] 
.const [106] = NameAndType [192] [193] 
.const [107] = Class [194] 
.const [108] = NameAndType [195] [196] 
.const [109] = Utf8 de/esolutions/fw/comm/core/ServiceInstanceID 
.const [110] = Class [197] 
.const [111] = NameAndType [198] [199] 
.const [112] = Class [200] 
.const [113] = NameAndType [201] [202] 
.const [114] = Class [203] 
.const [115] = NameAndType [204] [205] 
.const [116] = Class [206] 
.const [117] = NameAndType [207] [208] 
.const [118] = Class [209] 
.const [119] = NameAndType [210] [211] 
.const [120] = Class [212] 
.const [121] = NameAndType [213] [214] 
.const [122] = Class [215] 
.const [123] = NameAndType [216] [217] 
.const [124] = Class [218] 
.const [125] = NameAndType [219] [220] 
.const [126] = Class [221] 
.const [127] = NameAndType [222] [223] 
.const [128] = Class [224] 
.const [129] = NameAndType [225] [226] 
.const [130] = Class [227] 
.const [131] = NameAndType [228] [229] 
.const [132] = Class [230] 
.const [133] = NameAndType [231] [232] 
.const [134] = Class [233] 
.const [135] = NameAndType [234] [235] 
.const [136] = Class [236] 
.const [137] = NameAndType [237] [238] 
.const [138] = Class [239] 
.const [139] = NameAndType [240] [241] 
.const [140] = Class [242] 
.const [141] = NameAndType [243] [244] 
.const [142] = Class [245] 
.const [143] = NameAndType [246] [247] 
.const [144] = Utf8 de/esolutions/fw/comm/core/method/MethodException 
.const [145] = Utf8 java/lang/StringBuffer 
.const [146] = Utf8 de/esolutions/fw/comm/dsi/media/impl/DSIMediaRecorderReplyService 
.const [147] = Utf8 nextDynamicHandle 
.const [148] = Utf8 ()I 
.const [149] = Utf8 de/esolutions/fw/comm/dsi/media/impl/DSIMediaRecorderReplyService 
.const [150] = Utf8 dynamicHandle 
.const [151] = Utf8 I 
.const [152] = Utf8 de/esolutions/fw/comm/dsi/media/impl/DSIMediaRecorderReplyService 
.const [153] = Utf8 context 
.const [154] = Utf8 Lde/esolutions/fw/comm/core/CallContext; 
.const [155] = Utf8 de/esolutions/fw/comm/dsi/media/impl/ListEntrySerializer 
.const [156] = Utf8 getOptionalListEntry 
.const [157] = Utf8 (Lde/esolutions/fw/util/serializer/IDeserializer;)Lorg/dsi/ifc/media/ListEntry; 
.const [158] = Utf8 de/esolutions/fw/comm/dsi/media/impl/DatabaseSpaceSerializer 
.const [159] = Utf8 getOptionalDatabaseSpace 
.const [160] = Utf8 (Lde/esolutions/fw/util/serializer/IDeserializer;)Lorg/dsi/ifc/media/DatabaseSpace; 
.const [161] = Utf8 de/esolutions/fw/comm/core/CallContext 
.const [162] = Utf8 getContext 
.const [163] = Utf8 (Ljava/lang/String;)Lde/esolutions/fw/comm/core/CallContext; 
.const [164] = Utf8 de/esolutions/fw/comm/dsi/media/impl/DSIMediaRecorderReplyService 
.const [165] = Utf8 p_DSIMediaRecorderReply 
.const [166] = Utf8 Lde/esolutions/fw/comm/dsi/media/DSIMediaRecorderReply; 
.const [167] = Utf8 java/lang/StringBuffer 
.const [168] = Utf8 append 
.const [169] = Utf8 (Ljava/lang/String;)Ljava/lang/StringBuffer; 
.const [170] = Utf8 java/lang/StringBuffer 
.const [171] = Utf8 append 
.const [172] = Utf8 (I)Ljava/lang/StringBuffer; 
.const [173] = Utf8 java/lang/StringBuffer 
.const [174] = Utf8 toString 
.const [175] = Utf8 ()Ljava/lang/String; 
.const [176] = Utf8 de/esolutions/fw/util/serializer/exception/SerializerException 
.const [177] = Utf8 getMessage 
.const [178] = Utf8 ()Ljava/lang/String; 
.const [179] = Utf8 de/esolutions/fw/comm/core/ServiceInstanceID 
.const [180] = Utf8 <init> 
.const [181] = Utf8 (Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V 
.const [182] = Utf8 de/esolutions/fw/comm/core/AbstractReplyService 
.const [183] = Utf8 <init> 
.const [184] = Utf8 (Lde/esolutions/fw/comm/core/ServiceInstanceID;)V 
.const [185] = Utf8 de/esolutions/fw/comm/dsi/media/impl/DSIMediaRecorderReplyService 
.const [186] = Utf8 dynamicHandle 
.const [187] = Utf8 I 
.const [188] = Utf8 de/esolutions/fw/comm/dsi/media/impl/DSIMediaRecorderReplyService 
.const [189] = Utf8 context 
.const [190] = Utf8 Lde/esolutions/fw/comm/core/CallContext; 
.const [191] = Utf8 java/lang/StringBuffer 
.const [192] = Utf8 <init> 
.const [193] = Utf8 ()V 
.const [194] = Utf8 de/esolutions/fw/comm/core/method/MethodException 
.const [195] = Utf8 <init> 
.const [196] = Utf8 (Ljava/lang/String;)V 
.const [197] = Utf8 de/esolutions/fw/comm/dsi/media/impl/DSIMediaRecorderReplyService 
.const [198] = Utf8 p_DSIMediaRecorderReply 
.const [199] = Utf8 Lde/esolutions/fw/comm/dsi/media/DSIMediaRecorderReply; 
.const [200] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [201] = Utf8 getInt64 
.const [202] = Utf8 ()J 
.const [203] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [204] = Utf8 getInt32 
.const [205] = Utf8 ()I 
.const [206] = Utf8 de/esolutions/fw/comm/dsi/media/DSIMediaRecorderReply 
.const [207] = Utf8 updateActiveMedia 
.const [208] = Utf8 (JJI)V 
.const [209] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [210] = Utf8 getBool 
.const [211] = Utf8 ()Z 
.const [212] = Utf8 de/esolutions/fw/comm/dsi/media/DSIMediaRecorderReply 
.const [213] = Utf8 responseSetSelection 
.const [214] = Utf8 (IZ)V 
.const [215] = Utf8 de/esolutions/fw/comm/dsi/media/DSIMediaRecorderReply 
.const [216] = Utf8 updateImportSummary 
.const [217] = Utf8 (JJJJJJI)V 
.const [218] = Utf8 de/esolutions/fw/comm/dsi/media/DSIMediaRecorderReply 
.const [219] = Utf8 updateImportProgress 
.const [220] = Utf8 (JLorg/dsi/ifc/media/ListEntry;I)V 
.const [221] = Utf8 de/esolutions/fw/comm/dsi/media/DSIMediaRecorderReply 
.const [222] = Utf8 updateImportStatus 
.const [223] = Utf8 (II)V 
.const [224] = Utf8 de/esolutions/fw/comm/dsi/media/DSIMediaRecorderReply 
.const [225] = Utf8 updateDeletionProgress 
.const [226] = Utf8 (JI)V 
.const [227] = Utf8 de/esolutions/fw/comm/dsi/media/DSIMediaRecorderReply 
.const [228] = Utf8 updateDeletionStatus 
.const [229] = Utf8 (II)V 
.const [230] = Utf8 de/esolutions/fw/comm/dsi/media/DSIMediaRecorderReply 
.const [231] = Utf8 updateDatabaseSpace 
.const [232] = Utf8 (Lorg/dsi/ifc/media/DatabaseSpace;I)V 
.const [233] = Utf8 de/esolutions/fw/comm/dsi/media/DSIMediaRecorderReply 
.const [234] = Utf8 updateTargetMedia 
.const [235] = Utf8 (JJI)V 
.const [236] = Utf8 de/esolutions/fw/comm/dsi/media/DSIMediaRecorderReply 
.const [237] = Utf8 responseSetEncodingQuality 
.const [238] = Utf8 (I)V 
.const [239] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [240] = Utf8 getOptionalString 
.const [241] = Utf8 ()Ljava/lang/String; 
.const [242] = Utf8 de/esolutions/fw/comm/dsi/media/DSIMediaRecorderReply 
.const [243] = Utf8 asyncException 
.const [244] = Utf8 (ILjava/lang/String;I)V 
.const [245] = Utf8 de/esolutions/fw/comm/dsi/media/DSIMediaRecorderReply 
.const [246] = Utf8 yyIndication 
.const [247] = Utf8 (Ljava/lang/String;Ljava/lang/String;)V 
.const [248] = Utf8 de/esolutions/fw/comm/dsi/media/impl/DSIMediaRecorderReplyService 
.const [249] = Class [248] 
.const [250] = Utf8 de/esolutions/fw/comm/core/AbstractReplyService 
.const [251] = Class [250] 
.const [252] = Utf8 context 
.const [253] = Utf8 Lde/esolutions/fw/comm/core/CallContext; 
.const [254] = Utf8 dynamicHandle 
.const [255] = Utf8 I 
.const [256] = Utf8 p_DSIMediaRecorderReply 
.const [257] = Utf8 Lde/esolutions/fw/comm/dsi/media/DSIMediaRecorderReply; 
.const [258] = Utf8 Code 
.const [259] = Utf8 <init> 
.const [260] = Utf8 (Lde/esolutions/fw/comm/dsi/media/DSIMediaRecorderReply;)V 
.const [261] = Utf8 nextDynamicHandle 
.const [262] = Utf8 ()I 
.const [263] = Utf8 getCallContext 
.const [264] = Utf8 ()Lde/esolutions/fw/comm/core/CallContext; 
.const [265] = Utf8 handleCallMethod 
.const [266] = Utf8 (SLde/esolutions/fw/util/serializer/IDeserializer;Lde/esolutions/fw/comm/core/IProxyFrontend;)V 
.const [267] = Utf8 <clinit> 
.const [268] = Utf8 ()V 
.end class 
