.version 50 0 
.class public super [269] 
.super [271] 
.field private static final [272] [273] 
.field private static [274] [275] 
.field private [276] [277] 

.method public [279] : [280] 
    .attribute [278] .code stack 7 locals 0 
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

.method private static synchronized [281] : [282] 
    .attribute [278] .code stack 2 locals 1 
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

.method public [283] : [284] 
    .attribute [278] .code stack 1 locals 0 
L0:     getstatic [8] 
L3:     areturn 
L4:     
    .end code 
.end method 

.method public [285] : [286] 
    .attribute [278] .code stack 4 locals 3 
        .catch [16] from L0 to L663 using L666 
L0:     iload_1 
L1:     tableswitch 1 
            L188 
            L562 
            L176 
            L636 
            L636 
            L636 
            L636 
            L278 
            L636 
            L248 
            L636 
            L308 
            L636 
            L218 
            L636 
            L372 
            L636 
            L520 
            L636 
            L442 
            L636 
            L136 
            L636 
            L340 
            L636 
            L636 
            L636 
            L402 
            L480 
            L604 
            default : L636 

L136:   aload_2 
L137:   invokeinterface [42] 0 
L142:   astore 4 
L144:   aload_2 
L145:   invokestatic [9] 
L148:   astore 5 
L150:   aload_2 
L151:   invokeinterface [43] 0 
L156:   istore 6 
L158:   aload_0 
L159:   getfield [29] 
L162:   aload 4 
L164:   aload 5 
L166:   iload 6 
L168:   invokeinterface [44] 0 
L173:   goto L663 
L176:   aload_0 
L177:   getfield [29] 
L180:   invokeinterface [45] 0 
L185:   goto L663 
L188:   aload_2 
L189:   invokestatic [10] 
L192:   astore 4 
L194:   aload_2 
L195:   invokeinterface [43] 0 
L200:   istore 5 
L202:   aload_0 
L203:   getfield [29] 
L206:   aload 4 
L208:   iload 5 
L210:   invokeinterface [46] 0 
L215:   goto L663 
L218:   aload_2 
L219:   invokestatic [10] 
L222:   astore 4 
L224:   aload_2 
L225:   invokeinterface [43] 0 
L230:   istore 5 
L232:   aload_0 
L233:   getfield [29] 
L236:   aload 4 
L238:   iload 5 
L240:   invokeinterface [47] 0 
L245:   goto L663 
L248:   aload_2 
L249:   invokestatic [10] 
L252:   astore 4 
L254:   aload_2 
L255:   invokeinterface [43] 0 
L260:   istore 5 
L262:   aload_0 
L263:   getfield [29] 
L266:   aload 4 
L268:   iload 5 
L270:   invokeinterface [48] 0 
L275:   goto L663 
L278:   aload_2 
L279:   invokestatic [10] 
L282:   astore 4 
L284:   aload_2 
L285:   invokeinterface [43] 0 
L290:   istore 5 
L292:   aload_0 
L293:   getfield [29] 
L296:   aload 4 
L298:   iload 5 
L300:   invokeinterface [49] 0 
L305:   goto L663 
L308:   aload_2 
L309:   invokeinterface [42] 0 
L314:   astore 4 
L316:   aload_2 
L317:   invokeinterface [43] 0 
L322:   istore 5 
L324:   aload_0 
L325:   getfield [29] 
L328:   aload 4 
L330:   iload 5 
L332:   invokeinterface [50] 0 
L337:   goto L663 
L340:   aload_2 
L341:   invokeinterface [42] 0 
L346:   astore 4 
L348:   aload_2 
L349:   invokeinterface [43] 0 
L354:   istore 5 
L356:   aload_0 
L357:   getfield [29] 
L360:   aload 4 
L362:   iload 5 
L364:   invokeinterface [51] 0 
L369:   goto L663 
L372:   aload_2 
L373:   invokestatic [11] 
L376:   astore 4 
L378:   aload_2 
L379:   invokeinterface [43] 0 
L384:   istore 5 
L386:   aload_0 
L387:   getfield [29] 
L390:   aload 4 
L392:   iload 5 
L394:   invokeinterface [52] 0 
L399:   goto L663 
L402:   aload_2 
L403:   invokestatic [11] 
L406:   astore 4 
L408:   aload_2 
L409:   invokeinterface [43] 0 
L414:   istore 5 
L416:   aload_2 
L417:   invokeinterface [43] 0 
L422:   istore 6 
L424:   aload_0 
L425:   getfield [29] 
L428:   aload 4 
L430:   iload 5 
L432:   iload 6 
L434:   invokeinterface [53] 0 
L439:   goto L663 
L442:   aload_2 
L443:   invokestatic [11] 
L446:   astore 4 
L448:   aload_2 
L449:   invokestatic [12] 
L452:   astore 5 
L454:   aload_2 
L455:   invokeinterface [43] 0 
L460:   istore 6 
L462:   aload_0 
L463:   getfield [29] 
L466:   aload 4 
L468:   aload 5 
L470:   iload 6 
L472:   invokeinterface [54] 0 
L477:   goto L663 
L480:   aload_2 
L481:   invokestatic [11] 
L484:   astore 4 
L486:   aload_2 
L487:   invokeinterface [43] 0 
L492:   istore 5 
L494:   aload_2 
L495:   invokeinterface [43] 0 
L500:   istore 6 
L502:   aload_0 
L503:   getfield [29] 
L506:   aload 4 
L508:   iload 5 
L510:   iload 6 
L512:   invokeinterface [55] 0 
L517:   goto L663 
L520:   aload_2 
L521:   invokeinterface [43] 0 
L526:   istore 4 
L528:   aload_2 
L529:   invokeinterface [43] 0 
L534:   istore 5 
L536:   aload_2 
L537:   invokeinterface [43] 0 
L542:   istore 6 
L544:   aload_0 
L545:   getfield [29] 
L548:   iload 4 
L550:   iload 5 
L552:   iload 6 
L554:   invokeinterface [56] 0 
L559:   goto L663 
L562:   aload_2 
L563:   invokeinterface [43] 0 
L568:   istore 4 
L570:   aload_2 
L571:   invokeinterface [42] 0 
L576:   astore 5 
L578:   aload_2 
L579:   invokeinterface [43] 0 
L584:   istore 6 
L586:   aload_0 
L587:   getfield [29] 
L590:   iload 4 
L592:   aload 5 
L594:   iload 6 
L596:   invokeinterface [57] 0 
L601:   goto L663 
L604:   aload_2 
L605:   invokeinterface [42] 0 
L610:   astore 4 
L612:   aload_2 
L613:   invokeinterface [42] 0 
L618:   astore 5 
L620:   aload_0 
L621:   getfield [29] 
L624:   aload 4 
L626:   aload 5 
L628:   invokeinterface [58] 0 
L633:   goto L663 
L636:   new [59] 
L639:   dup 
L640:   new [60] 
L643:   dup 
L644:   invokespecial [38] 
L647:   ldc [15] 
L649:   invokevirtual [30] 
L652:   iload_1 
L653:   invokevirtual [31] 
L656:   invokevirtual [32] 
L659:   invokespecial [39] 
L662:   athrow 
L663:   goto L708 
L666:   astore 4 
L668:   new [59] 
L671:   dup 
L672:   new [60] 
L675:   dup 
L676:   invokespecial [38] 
L679:   ldc [17] 
L681:   invokevirtual [30] 
L684:   iload_1 
L685:   invokevirtual [31] 
L688:   ldc [18] 
L690:   invokevirtual [30] 
L693:   aload 4 
L695:   invokevirtual [33] 
L698:   invokevirtual [30] 
L701:   invokevirtual [32] 
L704:   invokespecial [39] 
L707:   athrow 
L708:   return 
L709:   nop 
L710:   nop 
L711:   nop 
L712:   
    .end code 
.end method 

.method static [287] : [288] 
    .attribute [278] .code stack 1 locals 0 
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
.const [2] = Class [61] 
.const [3] = String [62] 
.const [4] = Method [63] [64] 
.const [5] = String [65] 
.const [6] = String [66] 
.const [7] = Field [67] [68] 
.const [8] = Field [69] [70] 
.const [9] = Method [71] [72] 
.const [10] = Method [73] [74] 
.const [11] = Method [75] [76] 
.const [12] = Method [77] [78] 
.const [13] = Class [79] 
.const [14] = Class [80] 
.const [15] = String [81] 
.const [16] = Class [82] 
.const [17] = String [83] 
.const [18] = String [84] 
.const [19] = String [85] 
.const [20] = Method [86] [87] 
.const [21] = Class [88] 
.const [22] = Class [89] 
.const [23] = Class [90] 
.const [24] = Class [91] 
.const [25] = Class [92] 
.const [26] = Class [93] 
.const [27] = Class [94] 
.const [28] = Class [95] 
.const [29] = Field [96] [97] 
.const [30] = Method [98] [99] 
.const [31] = Method [100] [101] 
.const [32] = Method [102] [103] 
.const [33] = Method [104] [105] 
.const [34] = Method [106] [107] 
.const [35] = Method [108] [109] 
.const [36] = Field [110] [111] 
.const [37] = Field [112] [113] 
.const [38] = Method [114] [115] 
.const [39] = Method [116] [117] 
.const [40] = Class [118] 
.const [41] = Field [119] [120] 
.const [42] = InterfaceMethod [121] [122] 
.const [43] = InterfaceMethod [123] [124] 
.const [44] = InterfaceMethod [125] [126] 
.const [45] = InterfaceMethod [127] [128] 
.const [46] = InterfaceMethod [129] [130] 
.const [47] = InterfaceMethod [131] [132] 
.const [48] = InterfaceMethod [133] [134] 
.const [49] = InterfaceMethod [135] [136] 
.const [50] = InterfaceMethod [137] [138] 
.const [51] = InterfaceMethod [139] [140] 
.const [52] = InterfaceMethod [141] [142] 
.const [53] = InterfaceMethod [143] [144] 
.const [54] = InterfaceMethod [145] [146] 
.const [55] = InterfaceMethod [147] [148] 
.const [56] = InterfaceMethod [149] [150] 
.const [57] = InterfaceMethod [151] [152] 
.const [58] = InterfaceMethod [153] [154] 
.const [59] = Class [155] 
.const [60] = Class [156] 
.const [61] = Utf8 de/esolutions/fw/comm/core/ServiceInstanceID 
.const [62] = Utf8 '86539966-2a35-53bb-8c25-e66e780f75eb' 
.const [63] = Class [157] 
.const [64] = NameAndType [158] [159] 
.const [65] = Utf8 c2fe38b4-9c45-5465-b247-db69a6a5f0e2 
.const [66] = Utf8 'dsi.browser.DSIBrowserBookmark' 
.const [67] = Class [160] 
.const [68] = NameAndType [161] [162] 
.const [69] = Class [163] 
.const [70] = NameAndType [164] [165] 
.const [71] = Class [166] 
.const [72] = NameAndType [167] [168] 
.const [73] = Class [169] 
.const [74] = NameAndType [170] [171] 
.const [75] = Class [172] 
.const [76] = NameAndType [173] [174] 
.const [77] = Class [175] 
.const [78] = NameAndType [176] [177] 
.const [79] = Utf8 de/esolutions/fw/comm/core/method/MethodException 
.const [80] = Utf8 java/lang/StringBuffer 
.const [81] = Utf8 'Invalid Method Id ' 
.const [82] = Utf8 de/esolutions/fw/util/serializer/exception/SerializerException 
.const [83] = Utf8 'Deserialization failed: method=' 
.const [84] = Utf8 ', error=' 
.const [85] = Utf8 'STUB.dsi.browser.DSIBrowserBookmark' 
.const [86] = Class [178] 
.const [87] = NameAndType [179] [180] 
.const [88] = Utf8 de/esolutions/fw/comm/dsi/browser/impl/DSIBrowserBookmarkReplyService 
.const [89] = Utf8 de/esolutions/fw/comm/core/AbstractReplyService 
.const [90] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [91] = Utf8 de/esolutions/fw/comm/dsi/browser/impl/BookmarkSerializer 
.const [92] = Utf8 de/esolutions/fw/comm/dsi/browser/DSIBrowserBookmarkReply 
.const [93] = Utf8 de/esolutions/fw/comm/dsi/browser/impl/PathInfoSerializer 
.const [94] = Utf8 de/esolutions/fw/comm/dsi/browser/impl/ImportReportSerializer 
.const [95] = Utf8 de/esolutions/fw/comm/core/CallContext 
.const [96] = Class [181] 
.const [97] = NameAndType [182] [183] 
.const [98] = Class [184] 
.const [99] = NameAndType [185] [186] 
.const [100] = Class [187] 
.const [101] = NameAndType [188] [189] 
.const [102] = Class [190] 
.const [103] = NameAndType [191] [192] 
.const [104] = Class [193] 
.const [105] = NameAndType [194] [195] 
.const [106] = Class [196] 
.const [107] = NameAndType [197] [198] 
.const [108] = Class [199] 
.const [109] = NameAndType [200] [201] 
.const [110] = Class [202] 
.const [111] = NameAndType [203] [204] 
.const [112] = Class [205] 
.const [113] = NameAndType [206] [207] 
.const [114] = Class [208] 
.const [115] = NameAndType [209] [210] 
.const [116] = Class [211] 
.const [117] = NameAndType [212] [213] 
.const [118] = Utf8 de/esolutions/fw/comm/core/ServiceInstanceID 
.const [119] = Class [214] 
.const [120] = NameAndType [215] [216] 
.const [121] = Class [217] 
.const [122] = NameAndType [218] [219] 
.const [123] = Class [220] 
.const [124] = NameAndType [221] [222] 
.const [125] = Class [223] 
.const [126] = NameAndType [224] [225] 
.const [127] = Class [226] 
.const [128] = NameAndType [227] [228] 
.const [129] = Class [229] 
.const [130] = NameAndType [230] [231] 
.const [131] = Class [232] 
.const [132] = NameAndType [233] [234] 
.const [133] = Class [235] 
.const [134] = NameAndType [236] [237] 
.const [135] = Class [238] 
.const [136] = NameAndType [239] [240] 
.const [137] = Class [241] 
.const [138] = NameAndType [242] [243] 
.const [139] = Class [244] 
.const [140] = NameAndType [245] [246] 
.const [141] = Class [247] 
.const [142] = NameAndType [248] [249] 
.const [143] = Class [250] 
.const [144] = NameAndType [251] [252] 
.const [145] = Class [253] 
.const [146] = NameAndType [254] [255] 
.const [147] = Class [256] 
.const [148] = NameAndType [257] [258] 
.const [149] = Class [259] 
.const [150] = NameAndType [260] [261] 
.const [151] = Class [262] 
.const [152] = NameAndType [263] [264] 
.const [153] = Class [265] 
.const [154] = NameAndType [266] [267] 
.const [155] = Utf8 de/esolutions/fw/comm/core/method/MethodException 
.const [156] = Utf8 java/lang/StringBuffer 
.const [157] = Utf8 de/esolutions/fw/comm/dsi/browser/impl/DSIBrowserBookmarkReplyService 
.const [158] = Utf8 nextDynamicHandle 
.const [159] = Utf8 ()I 
.const [160] = Utf8 de/esolutions/fw/comm/dsi/browser/impl/DSIBrowserBookmarkReplyService 
.const [161] = Utf8 dynamicHandle 
.const [162] = Utf8 I 
.const [163] = Utf8 de/esolutions/fw/comm/dsi/browser/impl/DSIBrowserBookmarkReplyService 
.const [164] = Utf8 context 
.const [165] = Utf8 Lde/esolutions/fw/comm/core/CallContext; 
.const [166] = Utf8 de/esolutions/fw/comm/dsi/browser/impl/BookmarkSerializer 
.const [167] = Utf8 getOptionalBookmarkVarArray 
.const [168] = Utf8 (Lde/esolutions/fw/util/serializer/IDeserializer;)[Lorg/dsi/ifc/browser/Bookmark; 
.const [169] = Utf8 de/esolutions/fw/comm/dsi/browser/impl/BookmarkSerializer 
.const [170] = Utf8 getOptionalBookmark 
.const [171] = Utf8 (Lde/esolutions/fw/util/serializer/IDeserializer;)Lorg/dsi/ifc/browser/Bookmark; 
.const [172] = Utf8 de/esolutions/fw/comm/dsi/browser/impl/PathInfoSerializer 
.const [173] = Utf8 getOptionalPathInfo 
.const [174] = Utf8 (Lde/esolutions/fw/util/serializer/IDeserializer;)Lorg/dsi/ifc/browser/PathInfo; 
.const [175] = Utf8 de/esolutions/fw/comm/dsi/browser/impl/ImportReportSerializer 
.const [176] = Utf8 getOptionalImportReport 
.const [177] = Utf8 (Lde/esolutions/fw/util/serializer/IDeserializer;)Lorg/dsi/ifc/browser/ImportReport; 
.const [178] = Utf8 de/esolutions/fw/comm/core/CallContext 
.const [179] = Utf8 getContext 
.const [180] = Utf8 (Ljava/lang/String;)Lde/esolutions/fw/comm/core/CallContext; 
.const [181] = Utf8 de/esolutions/fw/comm/dsi/browser/impl/DSIBrowserBookmarkReplyService 
.const [182] = Utf8 p_DSIBrowserBookmarkReply 
.const [183] = Utf8 Lde/esolutions/fw/comm/dsi/browser/DSIBrowserBookmarkReply; 
.const [184] = Utf8 java/lang/StringBuffer 
.const [185] = Utf8 append 
.const [186] = Utf8 (Ljava/lang/String;)Ljava/lang/StringBuffer; 
.const [187] = Utf8 java/lang/StringBuffer 
.const [188] = Utf8 append 
.const [189] = Utf8 (I)Ljava/lang/StringBuffer; 
.const [190] = Utf8 java/lang/StringBuffer 
.const [191] = Utf8 toString 
.const [192] = Utf8 ()Ljava/lang/String; 
.const [193] = Utf8 de/esolutions/fw/util/serializer/exception/SerializerException 
.const [194] = Utf8 getMessage 
.const [195] = Utf8 ()Ljava/lang/String; 
.const [196] = Utf8 de/esolutions/fw/comm/core/ServiceInstanceID 
.const [197] = Utf8 <init> 
.const [198] = Utf8 (Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V 
.const [199] = Utf8 de/esolutions/fw/comm/core/AbstractReplyService 
.const [200] = Utf8 <init> 
.const [201] = Utf8 (Lde/esolutions/fw/comm/core/ServiceInstanceID;)V 
.const [202] = Utf8 de/esolutions/fw/comm/dsi/browser/impl/DSIBrowserBookmarkReplyService 
.const [203] = Utf8 dynamicHandle 
.const [204] = Utf8 I 
.const [205] = Utf8 de/esolutions/fw/comm/dsi/browser/impl/DSIBrowserBookmarkReplyService 
.const [206] = Utf8 context 
.const [207] = Utf8 Lde/esolutions/fw/comm/core/CallContext; 
.const [208] = Utf8 java/lang/StringBuffer 
.const [209] = Utf8 <init> 
.const [210] = Utf8 ()V 
.const [211] = Utf8 de/esolutions/fw/comm/core/method/MethodException 
.const [212] = Utf8 <init> 
.const [213] = Utf8 (Ljava/lang/String;)V 
.const [214] = Utf8 de/esolutions/fw/comm/dsi/browser/impl/DSIBrowserBookmarkReplyService 
.const [215] = Utf8 p_DSIBrowserBookmarkReply 
.const [216] = Utf8 Lde/esolutions/fw/comm/dsi/browser/DSIBrowserBookmarkReply; 
.const [217] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [218] = Utf8 getOptionalString 
.const [219] = Utf8 ()Ljava/lang/String; 
.const [220] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [221] = Utf8 getInt32 
.const [222] = Utf8 ()I 
.const [223] = Utf8 de/esolutions/fw/comm/dsi/browser/DSIBrowserBookmarkReply 
.const [224] = Utf8 listBookmarksResult 
.const [225] = Utf8 (Ljava/lang/String;[Lorg/dsi/ifc/browser/Bookmark;I)V 
.const [226] = Utf8 de/esolutions/fw/comm/dsi/browser/DSIBrowserBookmarkReply 
.const [227] = Utf8 bookmarkListInvalid 
.const [228] = Utf8 ()V 
.const [229] = Utf8 de/esolutions/fw/comm/dsi/browser/DSIBrowserBookmarkReply 
.const [230] = Utf8 addBookmarkResult 
.const [231] = Utf8 (Lorg/dsi/ifc/browser/Bookmark;I)V 
.const [232] = Utf8 de/esolutions/fw/comm/dsi/browser/DSIBrowserBookmarkReply 
.const [233] = Utf8 editBookmarkResult 
.const [234] = Utf8 (Lorg/dsi/ifc/browser/Bookmark;I)V 
.const [235] = Utf8 de/esolutions/fw/comm/dsi/browser/DSIBrowserBookmarkReply 
.const [236] = Utf8 deleteBookmarkResult 
.const [237] = Utf8 (Lorg/dsi/ifc/browser/Bookmark;I)V 
.const [238] = Utf8 de/esolutions/fw/comm/dsi/browser/DSIBrowserBookmarkReply 
.const [239] = Utf8 createFolderResult 
.const [240] = Utf8 (Lorg/dsi/ifc/browser/Bookmark;I)V 
.const [241] = Utf8 de/esolutions/fw/comm/dsi/browser/DSIBrowserBookmarkReply 
.const [242] = Utf8 deleteFolderResult 
.const [243] = Utf8 (Ljava/lang/String;I)V 
.const [244] = Utf8 de/esolutions/fw/comm/dsi/browser/DSIBrowserBookmarkReply 
.const [245] = Utf8 renameFolderResult 
.const [246] = Utf8 (Ljava/lang/String;I)V 
.const [247] = Utf8 de/esolutions/fw/comm/dsi/browser/DSIBrowserBookmarkReply 
.const [248] = Utf8 exportBookmarksResult 
.const [249] = Utf8 (Lorg/dsi/ifc/browser/PathInfo;I)V 
.const [250] = Utf8 de/esolutions/fw/comm/dsi/browser/DSIBrowserBookmarkReply 
.const [251] = Utf8 updateExportBookmarksProgress 
.const [252] = Utf8 (Lorg/dsi/ifc/browser/PathInfo;II)V 
.const [253] = Utf8 de/esolutions/fw/comm/dsi/browser/DSIBrowserBookmarkReply 
.const [254] = Utf8 importBookmarksResult 
.const [255] = Utf8 (Lorg/dsi/ifc/browser/PathInfo;Lorg/dsi/ifc/browser/ImportReport;I)V 
.const [256] = Utf8 de/esolutions/fw/comm/dsi/browser/DSIBrowserBookmarkReply 
.const [257] = Utf8 updateImportBookmarksProgress 
.const [258] = Utf8 (Lorg/dsi/ifc/browser/PathInfo;II)V 
.const [259] = Utf8 de/esolutions/fw/comm/dsi/browser/DSIBrowserBookmarkReply 
.const [260] = Utf8 getQuotaInformationResult 
.const [261] = Utf8 (III)V 
.const [262] = Utf8 de/esolutions/fw/comm/dsi/browser/DSIBrowserBookmarkReply 
.const [263] = Utf8 asyncException 
.const [264] = Utf8 (ILjava/lang/String;I)V 
.const [265] = Utf8 de/esolutions/fw/comm/dsi/browser/DSIBrowserBookmarkReply 
.const [266] = Utf8 yyIndication 
.const [267] = Utf8 (Ljava/lang/String;Ljava/lang/String;)V 
.const [268] = Utf8 de/esolutions/fw/comm/dsi/browser/impl/DSIBrowserBookmarkReplyService 
.const [269] = Class [268] 
.const [270] = Utf8 de/esolutions/fw/comm/core/AbstractReplyService 
.const [271] = Class [270] 
.const [272] = Utf8 context 
.const [273] = Utf8 Lde/esolutions/fw/comm/core/CallContext; 
.const [274] = Utf8 dynamicHandle 
.const [275] = Utf8 I 
.const [276] = Utf8 p_DSIBrowserBookmarkReply 
.const [277] = Utf8 Lde/esolutions/fw/comm/dsi/browser/DSIBrowserBookmarkReply; 
.const [278] = Utf8 Code 
.const [279] = Utf8 <init> 
.const [280] = Utf8 (Lde/esolutions/fw/comm/dsi/browser/DSIBrowserBookmarkReply;)V 
.const [281] = Utf8 nextDynamicHandle 
.const [282] = Utf8 ()I 
.const [283] = Utf8 getCallContext 
.const [284] = Utf8 ()Lde/esolutions/fw/comm/core/CallContext; 
.const [285] = Utf8 handleCallMethod 
.const [286] = Utf8 (SLde/esolutions/fw/util/serializer/IDeserializer;Lde/esolutions/fw/comm/core/IProxyFrontend;)V 
.const [287] = Utf8 <clinit> 
.const [288] = Utf8 ()V 
.end class 
