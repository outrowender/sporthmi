.version 50 0 
.class public super [221] 
.super [223] 
.field private static final [224] [225] 
.field private static [226] [227] 
.field private [228] [229] 

.method public [231] : [232] 
    .attribute [230] .code stack 7 locals 0 
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

.method private static synchronized [233] : [234] 
    .attribute [230] .code stack 2 locals 1 
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

.method public [235] : [236] 
    .attribute [230] .code stack 1 locals 0 
L0:     getstatic [8] 
L3:     areturn 
L4:     
    .end code 
.end method 

.method public [237] : [238] 
    .attribute [230] .code stack 4 locals 3 
        .catch [12] from L0 to L551 using L554 
L0:     iload_1 
L1:     tableswitch 0 
            L450 
            L524 
            L524 
            L524 
            L112 
            L524 
            L154 
            L524 
            L524 
            L524 
            L186 
            L524 
            L524 
            L408 
            L524 
            L524 
            L524 
            L524 
            L302 
            L334 
            L366 
            L218 
            L260 
            L492 
            default : L524 

L112:   aload_2 
L113:   invokeinterface [35] 0 
L118:   istore 4 
L120:   aload_2 
L121:   invokeinterface [35] 0 
L126:   istore 5 
L128:   aload_2 
L129:   invokeinterface [35] 0 
L134:   istore 6 
L136:   aload_0 
L137:   getfield [22] 
L140:   iload 4 
L142:   iload 5 
L144:   iload 6 
L146:   invokeinterface [36] 0 
L151:   goto L551 
L154:   aload_2 
L155:   invokeinterface [35] 0 
L160:   istore 4 
L162:   aload_2 
L163:   invokeinterface [35] 0 
L168:   istore 5 
L170:   aload_0 
L171:   getfield [22] 
L174:   iload 4 
L176:   iload 5 
L178:   invokeinterface [37] 0 
L183:   goto L551 
L186:   aload_2 
L187:   invokeinterface [35] 0 
L192:   istore 4 
L194:   aload_2 
L195:   invokeinterface [35] 0 
L200:   istore 5 
L202:   aload_0 
L203:   getfield [22] 
L206:   iload 4 
L208:   iload 5 
L210:   invokeinterface [38] 0 
L215:   goto L551 
L218:   aload_2 
L219:   invokeinterface [35] 0 
L224:   istore 4 
L226:   aload_2 
L227:   invokeinterface [35] 0 
L232:   istore 5 
L234:   aload_2 
L235:   invokeinterface [35] 0 
L240:   istore 6 
L242:   aload_0 
L243:   getfield [22] 
L246:   iload 4 
L248:   iload 5 
L250:   iload 6 
L252:   invokeinterface [39] 0 
L257:   goto L551 
L260:   aload_2 
L261:   invokeinterface [35] 0 
L266:   istore 4 
L268:   aload_2 
L269:   invokeinterface [35] 0 
L274:   istore 5 
L276:   aload_2 
L277:   invokeinterface [35] 0 
L282:   istore 6 
L284:   aload_0 
L285:   getfield [22] 
L288:   iload 4 
L290:   iload 5 
L292:   iload 6 
L294:   invokeinterface [40] 0 
L299:   goto L551 
L302:   aload_2 
L303:   invokeinterface [35] 0 
L308:   istore 4 
L310:   aload_2 
L311:   invokeinterface [35] 0 
L316:   istore 5 
L318:   aload_0 
L319:   getfield [22] 
L322:   iload 4 
L324:   iload 5 
L326:   invokeinterface [41] 0 
L331:   goto L551 
L334:   aload_2 
L335:   invokeinterface [35] 0 
L340:   istore 4 
L342:   aload_2 
L343:   invokeinterface [35] 0 
L348:   istore 5 
L350:   aload_0 
L351:   getfield [22] 
L354:   iload 4 
L356:   iload 5 
L358:   invokeinterface [42] 0 
L363:   goto L551 
L366:   aload_2 
L367:   invokeinterface [35] 0 
L372:   istore 4 
L374:   aload_2 
L375:   invokeinterface [35] 0 
L380:   istore 5 
L382:   aload_2 
L383:   invokeinterface [35] 0 
L388:   istore 6 
L390:   aload_0 
L391:   getfield [22] 
L394:   iload 4 
L396:   iload 5 
L398:   iload 6 
L400:   invokeinterface [43] 0 
L405:   goto L551 
L408:   aload_2 
L409:   invokeinterface [35] 0 
L414:   istore 4 
L416:   aload_2 
L417:   invokeinterface [35] 0 
L422:   istore 5 
L424:   aload_2 
L425:   invokeinterface [44] 0 
L430:   istore 6 
L432:   aload_0 
L433:   getfield [22] 
L436:   iload 4 
L438:   iload 5 
L440:   iload 6 
L442:   invokeinterface [45] 0 
L447:   goto L551 
L450:   aload_2 
L451:   invokeinterface [35] 0 
L456:   istore 4 
L458:   aload_2 
L459:   invokeinterface [46] 0 
L464:   astore 5 
L466:   aload_2 
L467:   invokeinterface [35] 0 
L472:   istore 6 
L474:   aload_0 
L475:   getfield [22] 
L478:   iload 4 
L480:   aload 5 
L482:   iload 6 
L484:   invokeinterface [47] 0 
L489:   goto L551 
L492:   aload_2 
L493:   invokeinterface [46] 0 
L498:   astore 4 
L500:   aload_2 
L501:   invokeinterface [46] 0 
L506:   astore 5 
L508:   aload_0 
L509:   getfield [22] 
L512:   aload 4 
L514:   aload 5 
L516:   invokeinterface [48] 0 
L521:   goto L551 
L524:   new [49] 
L527:   dup 
L528:   new [50] 
L531:   dup 
L532:   invokespecial [31] 
L535:   ldc [11] 
L537:   invokevirtual [23] 
L540:   iload_1 
L541:   invokevirtual [24] 
L544:   invokevirtual [25] 
L547:   invokespecial [32] 
L550:   athrow 
L551:   goto L596 
L554:   astore 4 
L556:   new [49] 
L559:   dup 
L560:   new [50] 
L563:   dup 
L564:   invokespecial [31] 
L567:   ldc [13] 
L569:   invokevirtual [23] 
L572:   iload_1 
L573:   invokevirtual [24] 
L576:   ldc [14] 
L578:   invokevirtual [23] 
L581:   aload 4 
L583:   invokevirtual [26] 
L586:   invokevirtual [23] 
L589:   invokevirtual [25] 
L592:   invokespecial [32] 
L595:   athrow 
L596:   return 
L597:   nop 
L598:   nop 
L599:   nop 
L600:   
    .end code 
.end method 

.method static [239] : [240] 
    .attribute [230] .code stack 1 locals 0 
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
.const [2] = Class [51] 
.const [3] = String [52] 
.const [4] = Method [53] [54] 
.const [5] = String [55] 
.const [6] = String [56] 
.const [7] = Field [57] [58] 
.const [8] = Field [59] [60] 
.const [9] = Class [61] 
.const [10] = Class [62] 
.const [11] = String [63] 
.const [12] = Class [64] 
.const [13] = String [65] 
.const [14] = String [66] 
.const [15] = String [67] 
.const [16] = Method [68] [69] 
.const [17] = Class [70] 
.const [18] = Class [71] 
.const [19] = Class [72] 
.const [20] = Class [73] 
.const [21] = Class [74] 
.const [22] = Field [75] [76] 
.const [23] = Method [77] [78] 
.const [24] = Method [79] [80] 
.const [25] = Method [81] [82] 
.const [26] = Method [83] [84] 
.const [27] = Method [85] [86] 
.const [28] = Method [87] [88] 
.const [29] = Field [89] [90] 
.const [30] = Field [91] [92] 
.const [31] = Method [93] [94] 
.const [32] = Method [95] [96] 
.const [33] = Class [97] 
.const [34] = Field [98] [99] 
.const [35] = InterfaceMethod [100] [101] 
.const [36] = InterfaceMethod [102] [103] 
.const [37] = InterfaceMethod [104] [105] 
.const [38] = InterfaceMethod [106] [107] 
.const [39] = InterfaceMethod [108] [109] 
.const [40] = InterfaceMethod [110] [111] 
.const [41] = InterfaceMethod [112] [113] 
.const [42] = InterfaceMethod [114] [115] 
.const [43] = InterfaceMethod [116] [117] 
.const [44] = InterfaceMethod [118] [119] 
.const [45] = InterfaceMethod [120] [121] 
.const [46] = InterfaceMethod [122] [123] 
.const [47] = InterfaceMethod [124] [125] 
.const [48] = InterfaceMethod [126] [127] 
.const [49] = Class [128] 
.const [50] = Class [129] 
.const [51] = Utf8 de/esolutions/fw/comm/core/ServiceInstanceID 
.const [52] = Utf8 '55183b6f-9e82-5a18-bfde-ed5ae24f6c1c' 
.const [53] = Class [130] 
.const [54] = NameAndType [131] [132] 
.const [55] = Utf8 db006bf0-acd2-5747-8415-366ba32075fe 
.const [56] = Utf8 'dsi.audio.DSIAudioManagement' 
.const [57] = Class [133] 
.const [58] = NameAndType [134] [135] 
.const [59] = Class [136] 
.const [60] = NameAndType [137] [138] 
.const [61] = Utf8 de/esolutions/fw/comm/core/method/MethodException 
.const [62] = Utf8 java/lang/StringBuffer 
.const [63] = Utf8 'Invalid Method Id ' 
.const [64] = Utf8 de/esolutions/fw/util/serializer/exception/SerializerException 
.const [65] = Utf8 'Deserialization failed: method=' 
.const [66] = Utf8 ', error=' 
.const [67] = Utf8 'STUB.dsi.audio.DSIAudioManagement' 
.const [68] = Class [139] 
.const [69] = NameAndType [140] [141] 
.const [70] = Utf8 de/esolutions/fw/comm/dsi/audio/impl/DSIAudioManagementReplyService 
.const [71] = Utf8 de/esolutions/fw/comm/core/AbstractReplyService 
.const [72] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [73] = Utf8 de/esolutions/fw/comm/dsi/audio/DSIAudioManagementReply 
.const [74] = Utf8 de/esolutions/fw/comm/core/CallContext 
.const [75] = Class [142] 
.const [76] = NameAndType [143] [144] 
.const [77] = Class [145] 
.const [78] = NameAndType [146] [147] 
.const [79] = Class [148] 
.const [80] = NameAndType [149] [150] 
.const [81] = Class [151] 
.const [82] = NameAndType [152] [153] 
.const [83] = Class [154] 
.const [84] = NameAndType [155] [156] 
.const [85] = Class [157] 
.const [86] = NameAndType [158] [159] 
.const [87] = Class [160] 
.const [88] = NameAndType [161] [162] 
.const [89] = Class [163] 
.const [90] = NameAndType [164] [165] 
.const [91] = Class [166] 
.const [92] = NameAndType [167] [168] 
.const [93] = Class [169] 
.const [94] = NameAndType [170] [171] 
.const [95] = Class [172] 
.const [96] = NameAndType [173] [174] 
.const [97] = Utf8 de/esolutions/fw/comm/core/ServiceInstanceID 
.const [98] = Class [175] 
.const [99] = NameAndType [176] [177] 
.const [100] = Class [178] 
.const [101] = NameAndType [179] [180] 
.const [102] = Class [181] 
.const [103] = NameAndType [182] [183] 
.const [104] = Class [184] 
.const [105] = NameAndType [185] [186] 
.const [106] = Class [187] 
.const [107] = NameAndType [188] [189] 
.const [108] = Class [190] 
.const [109] = NameAndType [191] [192] 
.const [110] = Class [193] 
.const [111] = NameAndType [194] [195] 
.const [112] = Class [196] 
.const [113] = NameAndType [197] [198] 
.const [114] = Class [199] 
.const [115] = NameAndType [200] [201] 
.const [116] = Class [202] 
.const [117] = NameAndType [203] [204] 
.const [118] = Class [205] 
.const [119] = NameAndType [206] [207] 
.const [120] = Class [208] 
.const [121] = NameAndType [209] [210] 
.const [122] = Class [211] 
.const [123] = NameAndType [212] [213] 
.const [124] = Class [214] 
.const [125] = NameAndType [215] [216] 
.const [126] = Class [217] 
.const [127] = NameAndType [218] [219] 
.const [128] = Utf8 de/esolutions/fw/comm/core/method/MethodException 
.const [129] = Utf8 java/lang/StringBuffer 
.const [130] = Utf8 de/esolutions/fw/comm/dsi/audio/impl/DSIAudioManagementReplyService 
.const [131] = Utf8 nextDynamicHandle 
.const [132] = Utf8 ()I 
.const [133] = Utf8 de/esolutions/fw/comm/dsi/audio/impl/DSIAudioManagementReplyService 
.const [134] = Utf8 dynamicHandle 
.const [135] = Utf8 I 
.const [136] = Utf8 de/esolutions/fw/comm/dsi/audio/impl/DSIAudioManagementReplyService 
.const [137] = Utf8 context 
.const [138] = Utf8 Lde/esolutions/fw/comm/core/CallContext; 
.const [139] = Utf8 de/esolutions/fw/comm/core/CallContext 
.const [140] = Utf8 getContext 
.const [141] = Utf8 (Ljava/lang/String;)Lde/esolutions/fw/comm/core/CallContext; 
.const [142] = Utf8 de/esolutions/fw/comm/dsi/audio/impl/DSIAudioManagementReplyService 
.const [143] = Utf8 p_DSIAudioManagementReply 
.const [144] = Utf8 Lde/esolutions/fw/comm/dsi/audio/DSIAudioManagementReply; 
.const [145] = Utf8 java/lang/StringBuffer 
.const [146] = Utf8 append 
.const [147] = Utf8 (Ljava/lang/String;)Ljava/lang/StringBuffer; 
.const [148] = Utf8 java/lang/StringBuffer 
.const [149] = Utf8 append 
.const [150] = Utf8 (I)Ljava/lang/StringBuffer; 
.const [151] = Utf8 java/lang/StringBuffer 
.const [152] = Utf8 toString 
.const [153] = Utf8 ()Ljava/lang/String; 
.const [154] = Utf8 de/esolutions/fw/util/serializer/exception/SerializerException 
.const [155] = Utf8 getMessage 
.const [156] = Utf8 ()Ljava/lang/String; 
.const [157] = Utf8 de/esolutions/fw/comm/core/ServiceInstanceID 
.const [158] = Utf8 <init> 
.const [159] = Utf8 (Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V 
.const [160] = Utf8 de/esolutions/fw/comm/core/AbstractReplyService 
.const [161] = Utf8 <init> 
.const [162] = Utf8 (Lde/esolutions/fw/comm/core/ServiceInstanceID;)V 
.const [163] = Utf8 de/esolutions/fw/comm/dsi/audio/impl/DSIAudioManagementReplyService 
.const [164] = Utf8 dynamicHandle 
.const [165] = Utf8 I 
.const [166] = Utf8 de/esolutions/fw/comm/dsi/audio/impl/DSIAudioManagementReplyService 
.const [167] = Utf8 context 
.const [168] = Utf8 Lde/esolutions/fw/comm/core/CallContext; 
.const [169] = Utf8 java/lang/StringBuffer 
.const [170] = Utf8 <init> 
.const [171] = Utf8 ()V 
.const [172] = Utf8 de/esolutions/fw/comm/core/method/MethodException 
.const [173] = Utf8 <init> 
.const [174] = Utf8 (Ljava/lang/String;)V 
.const [175] = Utf8 de/esolutions/fw/comm/dsi/audio/impl/DSIAudioManagementReplyService 
.const [176] = Utf8 p_DSIAudioManagementReply 
.const [177] = Utf8 Lde/esolutions/fw/comm/dsi/audio/DSIAudioManagementReply; 
.const [178] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [179] = Utf8 getInt32 
.const [180] = Utf8 ()I 
.const [181] = Utf8 de/esolutions/fw/comm/dsi/audio/DSIAudioManagementReply 
.const [182] = Utf8 errorConnection 
.const [183] = Utf8 (III)V 
.const [184] = Utf8 de/esolutions/fw/comm/dsi/audio/DSIAudioManagementReply 
.const [185] = Utf8 fadedIn 
.const [186] = Utf8 (II)V 
.const [187] = Utf8 de/esolutions/fw/comm/dsi/audio/DSIAudioManagementReply 
.const [188] = Utf8 pauseConnection 
.const [189] = Utf8 (II)V 
.const [190] = Utf8 de/esolutions/fw/comm/dsi/audio/DSIAudioManagementReply 
.const [191] = Utf8 updateActiveConnection 
.const [192] = Utf8 (III)V 
.const [193] = Utf8 de/esolutions/fw/comm/dsi/audio/DSIAudioManagementReply 
.const [194] = Utf8 updateActiveEntertainmentConnection 
.const [195] = Utf8 (III)V 
.const [196] = Utf8 de/esolutions/fw/comm/dsi/audio/DSIAudioManagementReply 
.const [197] = Utf8 startConnection 
.const [198] = Utf8 (II)V 
.const [199] = Utf8 de/esolutions/fw/comm/dsi/audio/DSIAudioManagementReply 
.const [200] = Utf8 stopConnection 
.const [201] = Utf8 (II)V 
.const [202] = Utf8 de/esolutions/fw/comm/dsi/audio/DSIAudioManagementReply 
.const [203] = Utf8 updateAMAvailable 
.const [204] = Utf8 (III)V 
.const [205] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [206] = Utf8 getBool 
.const [207] = Utf8 ()Z 
.const [208] = Utf8 de/esolutions/fw/comm/dsi/audio/DSIAudioManagementReply 
.const [209] = Utf8 responseVolumelock 
.const [210] = Utf8 (IIZ)V 
.const [211] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [212] = Utf8 getOptionalString 
.const [213] = Utf8 ()Ljava/lang/String; 
.const [214] = Utf8 de/esolutions/fw/comm/dsi/audio/DSIAudioManagementReply 
.const [215] = Utf8 asyncException 
.const [216] = Utf8 (ILjava/lang/String;I)V 
.const [217] = Utf8 de/esolutions/fw/comm/dsi/audio/DSIAudioManagementReply 
.const [218] = Utf8 yyIndication 
.const [219] = Utf8 (Ljava/lang/String;Ljava/lang/String;)V 
.const [220] = Utf8 de/esolutions/fw/comm/dsi/audio/impl/DSIAudioManagementReplyService 
.const [221] = Class [220] 
.const [222] = Utf8 de/esolutions/fw/comm/core/AbstractReplyService 
.const [223] = Class [222] 
.const [224] = Utf8 context 
.const [225] = Utf8 Lde/esolutions/fw/comm/core/CallContext; 
.const [226] = Utf8 dynamicHandle 
.const [227] = Utf8 I 
.const [228] = Utf8 p_DSIAudioManagementReply 
.const [229] = Utf8 Lde/esolutions/fw/comm/dsi/audio/DSIAudioManagementReply; 
.const [230] = Utf8 Code 
.const [231] = Utf8 <init> 
.const [232] = Utf8 (Lde/esolutions/fw/comm/dsi/audio/DSIAudioManagementReply;)V 
.const [233] = Utf8 nextDynamicHandle 
.const [234] = Utf8 ()I 
.const [235] = Utf8 getCallContext 
.const [236] = Utf8 ()Lde/esolutions/fw/comm/core/CallContext; 
.const [237] = Utf8 handleCallMethod 
.const [238] = Utf8 (SLde/esolutions/fw/util/serializer/IDeserializer;Lde/esolutions/fw/comm/core/IProxyFrontend;)V 
.const [239] = Utf8 <clinit> 
.const [240] = Utf8 ()V 
.end class 
