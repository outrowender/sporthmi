.version 50 0 
.class public super [215] 
.super [217] 
.field private static final [218] [219] 
.field private static [220] [221] 
.field private [222] [223] 

.method public [225] : [226] 
    .attribute [224] .code stack 7 locals 0 
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

.method private static synchronized [227] : [228] 
    .attribute [224] .code stack 2 locals 1 
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

.method public [229] : [230] 
    .attribute [224] .code stack 1 locals 0 
L0:     getstatic [8] 
L3:     areturn 
L4:     
    .end code 
.end method 

.method public [231] : [232] 
    .attribute [224] .code stack 11 locals 10 
        .catch [12] from L0 to L471 using L474 
L0:     iload_1 
L1:     tableswitch 0 
            L370 
            L444 
            L444 
            L444 
            L444 
            L444 
            L444 
            L100 
            L444 
            L298 
            L444 
            L266 
            L444 
            L444 
            L444 
            L444 
            L132 
            L444 
            L412 
            L444 
            L154 
            default : L444 

L100:   aload_2 
L101:   invokeinterface [35] 0 
L106:   astore 4 
L108:   aload_2 
L109:   invokeinterface [36] 0 
L114:   astore 5 
L116:   aload_0 
L117:   getfield [22] 
L120:   aload 4 
L122:   aload 5 
L124:   invokeinterface [37] 0 
L129:   goto L471 
L132:   aload_2 
L133:   invokeinterface [38] 0 
L138:   istore 4 
L140:   aload_0 
L141:   getfield [22] 
L144:   iload 4 
L146:   invokeinterface [39] 0 
L151:   goto L471 
L154:   aload_2 
L155:   invokeinterface [40] 0 
L160:   istore 4 
L162:   aload_2 
L163:   invokeinterface [41] 0 
L168:   astore 5 
L170:   aload_2 
L171:   invokeinterface [41] 0 
L176:   astore 6 
L178:   aload_2 
L179:   invokeinterface [40] 0 
L184:   istore 7 
L186:   aload_2 
L187:   invokeinterface [41] 0 
L192:   astore 8 
L194:   aload_2 
L195:   invokeinterface [41] 0 
L200:   astore 9 
L202:   aload_2 
L203:   invokeinterface [36] 0 
L208:   astore 10 
L210:   aload_2 
L211:   invokeinterface [40] 0 
L216:   istore 11 
L218:   aload_2 
L219:   invokeinterface [38] 0 
L224:   istore 12 
L226:   aload_2 
L227:   invokeinterface [36] 0 
L232:   astore 13 
L234:   aload_0 
L235:   getfield [22] 
L238:   iload 4 
L240:   aload 5 
L242:   aload 6 
L244:   iload 7 
L246:   aload 8 
L248:   aload 9 
L250:   aload 10 
L252:   iload 11 
L254:   iload 12 
L256:   aload 13 
L258:   invokeinterface [42] 0 
L263:   goto L471 
L266:   aload_2 
L267:   invokeinterface [36] 0 
L272:   astore 4 
L274:   aload_2 
L275:   invokeinterface [35] 0 
L280:   astore 5 
L282:   aload_0 
L283:   getfield [22] 
L286:   aload 4 
L288:   aload 5 
L290:   invokeinterface [43] 0 
L295:   goto L471 
L298:   aload_2 
L299:   invokeinterface [38] 0 
L304:   istore 4 
L306:   aload_2 
L307:   invokeinterface [41] 0 
L312:   astore 5 
L314:   aload_2 
L315:   invokeinterface [41] 0 
L320:   astore 6 
L322:   aload_2 
L323:   invokeinterface [41] 0 
L328:   astore 7 
L330:   aload_2 
L331:   invokeinterface [44] 0 
L336:   istore 8 
L338:   aload_2 
L339:   invokeinterface [38] 0 
L344:   istore 9 
L346:   aload_0 
L347:   getfield [22] 
L350:   iload 4 
L352:   aload 5 
L354:   aload 6 
L356:   aload 7 
L358:   iload 8 
L360:   iload 9 
L362:   invokeinterface [45] 0 
L367:   goto L471 
L370:   aload_2 
L371:   invokeinterface [38] 0 
L376:   istore 4 
L378:   aload_2 
L379:   invokeinterface [41] 0 
L384:   astore 5 
L386:   aload_2 
L387:   invokeinterface [38] 0 
L392:   istore 6 
L394:   aload_0 
L395:   getfield [22] 
L398:   iload 4 
L400:   aload 5 
L402:   iload 6 
L404:   invokeinterface [46] 0 
L409:   goto L471 
L412:   aload_2 
L413:   invokeinterface [41] 0 
L418:   astore 4 
L420:   aload_2 
L421:   invokeinterface [41] 0 
L426:   astore 5 
L428:   aload_0 
L429:   getfield [22] 
L432:   aload 4 
L434:   aload 5 
L436:   invokeinterface [47] 0 
L441:   goto L471 
L444:   new [48] 
L447:   dup 
L448:   new [49] 
L451:   dup 
L452:   invokespecial [31] 
L455:   ldc [11] 
L457:   invokevirtual [23] 
L460:   iload_1 
L461:   invokevirtual [24] 
L464:   invokevirtual [25] 
L467:   invokespecial [32] 
L470:   athrow 
L471:   goto L516 
L474:   astore 4 
L476:   new [48] 
L479:   dup 
L480:   new [49] 
L483:   dup 
L484:   invokespecial [31] 
L487:   ldc [13] 
L489:   invokevirtual [23] 
L492:   iload_1 
L493:   invokevirtual [24] 
L496:   ldc [14] 
L498:   invokevirtual [23] 
L501:   aload 4 
L503:   invokevirtual [26] 
L506:   invokevirtual [23] 
L509:   invokevirtual [25] 
L512:   invokespecial [32] 
L515:   athrow 
L516:   return 
L517:   nop 
L518:   nop 
L519:   nop 
L520:   
    .end code 
.end method 

.method static [233] : [234] 
    .attribute [224] .code stack 1 locals 0 
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
.const [2] = Class [50] 
.const [3] = String [51] 
.const [4] = Method [52] [53] 
.const [5] = String [54] 
.const [6] = String [55] 
.const [7] = Field [56] [57] 
.const [8] = Field [58] [59] 
.const [9] = Class [60] 
.const [10] = Class [61] 
.const [11] = String [62] 
.const [12] = Class [63] 
.const [13] = String [64] 
.const [14] = String [65] 
.const [15] = String [66] 
.const [16] = Method [67] [68] 
.const [17] = Class [69] 
.const [18] = Class [70] 
.const [19] = Class [71] 
.const [20] = Class [72] 
.const [21] = Class [73] 
.const [22] = Field [74] [75] 
.const [23] = Method [76] [77] 
.const [24] = Method [78] [79] 
.const [25] = Method [80] [81] 
.const [26] = Method [82] [83] 
.const [27] = Method [84] [85] 
.const [28] = Method [86] [87] 
.const [29] = Field [88] [89] 
.const [30] = Field [90] [91] 
.const [31] = Method [92] [93] 
.const [32] = Method [94] [95] 
.const [33] = Class [96] 
.const [34] = Field [97] [98] 
.const [35] = InterfaceMethod [99] [100] 
.const [36] = InterfaceMethod [101] [102] 
.const [37] = InterfaceMethod [103] [104] 
.const [38] = InterfaceMethod [105] [106] 
.const [39] = InterfaceMethod [107] [108] 
.const [40] = InterfaceMethod [109] [110] 
.const [41] = InterfaceMethod [111] [112] 
.const [42] = InterfaceMethod [113] [114] 
.const [43] = InterfaceMethod [115] [116] 
.const [44] = InterfaceMethod [117] [118] 
.const [45] = InterfaceMethod [119] [120] 
.const [46] = InterfaceMethod [121] [122] 
.const [47] = InterfaceMethod [123] [124] 
.const [48] = Class [125] 
.const [49] = Class [126] 
.const [50] = Utf8 de/esolutions/fw/comm/core/ServiceInstanceID 
.const [51] = Utf8 d4701228-4c5f-56da-b0bf-05699002e833 
.const [52] = Class [127] 
.const [53] = NameAndType [128] [129] 
.const [54] = Utf8 b02bd6b4-bef1-5aba-9811-dee9d4328506 
.const [55] = Utf8 'dsi.swdllogging.DSISwdlLogging' 
.const [56] = Class [130] 
.const [57] = NameAndType [131] [132] 
.const [58] = Class [133] 
.const [59] = NameAndType [134] [135] 
.const [60] = Utf8 de/esolutions/fw/comm/core/method/MethodException 
.const [61] = Utf8 java/lang/StringBuffer 
.const [62] = Utf8 'Invalid Method Id ' 
.const [63] = Utf8 de/esolutions/fw/util/serializer/exception/SerializerException 
.const [64] = Utf8 'Deserialization failed: method=' 
.const [65] = Utf8 ', error=' 
.const [66] = Utf8 'STUB.dsi.swdllogging.DSISwdlLogging' 
.const [67] = Class [136] 
.const [68] = NameAndType [137] [138] 
.const [69] = Utf8 de/esolutions/fw/comm/dsi/swdllogging/impl/DSISwdlLoggingReplyService 
.const [70] = Utf8 de/esolutions/fw/comm/core/AbstractReplyService 
.const [71] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [72] = Utf8 de/esolutions/fw/comm/dsi/swdllogging/DSISwdlLoggingReply 
.const [73] = Utf8 de/esolutions/fw/comm/core/CallContext 
.const [74] = Class [139] 
.const [75] = NameAndType [140] [141] 
.const [76] = Class [142] 
.const [77] = NameAndType [143] [144] 
.const [78] = Class [145] 
.const [79] = NameAndType [146] [147] 
.const [80] = Class [148] 
.const [81] = NameAndType [149] [150] 
.const [82] = Class [151] 
.const [83] = NameAndType [152] [153] 
.const [84] = Class [154] 
.const [85] = NameAndType [155] [156] 
.const [86] = Class [157] 
.const [87] = NameAndType [158] [159] 
.const [88] = Class [160] 
.const [89] = NameAndType [161] [162] 
.const [90] = Class [163] 
.const [91] = NameAndType [164] [165] 
.const [92] = Class [166] 
.const [93] = NameAndType [167] [168] 
.const [94] = Class [169] 
.const [95] = NameAndType [170] [171] 
.const [96] = Utf8 de/esolutions/fw/comm/core/ServiceInstanceID 
.const [97] = Class [172] 
.const [98] = NameAndType [173] [174] 
.const [99] = Class [175] 
.const [100] = NameAndType [176] [177] 
.const [101] = Class [178] 
.const [102] = NameAndType [179] [180] 
.const [103] = Class [181] 
.const [104] = NameAndType [182] [183] 
.const [105] = Class [184] 
.const [106] = NameAndType [185] [186] 
.const [107] = Class [187] 
.const [108] = NameAndType [188] [189] 
.const [109] = Class [190] 
.const [110] = NameAndType [191] [192] 
.const [111] = Class [193] 
.const [112] = NameAndType [194] [195] 
.const [113] = Class [196] 
.const [114] = NameAndType [197] [198] 
.const [115] = Class [199] 
.const [116] = NameAndType [200] [201] 
.const [117] = Class [202] 
.const [118] = NameAndType [203] [204] 
.const [119] = Class [205] 
.const [120] = NameAndType [206] [207] 
.const [121] = Class [208] 
.const [122] = NameAndType [209] [210] 
.const [123] = Class [211] 
.const [124] = NameAndType [212] [213] 
.const [125] = Utf8 de/esolutions/fw/comm/core/method/MethodException 
.const [126] = Utf8 java/lang/StringBuffer 
.const [127] = Utf8 de/esolutions/fw/comm/dsi/swdllogging/impl/DSISwdlLoggingReplyService 
.const [128] = Utf8 nextDynamicHandle 
.const [129] = Utf8 ()I 
.const [130] = Utf8 de/esolutions/fw/comm/dsi/swdllogging/impl/DSISwdlLoggingReplyService 
.const [131] = Utf8 dynamicHandle 
.const [132] = Utf8 I 
.const [133] = Utf8 de/esolutions/fw/comm/dsi/swdllogging/impl/DSISwdlLoggingReplyService 
.const [134] = Utf8 context 
.const [135] = Utf8 Lde/esolutions/fw/comm/core/CallContext; 
.const [136] = Utf8 de/esolutions/fw/comm/core/CallContext 
.const [137] = Utf8 getContext 
.const [138] = Utf8 (Ljava/lang/String;)Lde/esolutions/fw/comm/core/CallContext; 
.const [139] = Utf8 de/esolutions/fw/comm/dsi/swdllogging/impl/DSISwdlLoggingReplyService 
.const [140] = Utf8 p_DSISwdlLoggingReply 
.const [141] = Utf8 Lde/esolutions/fw/comm/dsi/swdllogging/DSISwdlLoggingReply; 
.const [142] = Utf8 java/lang/StringBuffer 
.const [143] = Utf8 append 
.const [144] = Utf8 (Ljava/lang/String;)Ljava/lang/StringBuffer; 
.const [145] = Utf8 java/lang/StringBuffer 
.const [146] = Utf8 append 
.const [147] = Utf8 (I)Ljava/lang/StringBuffer; 
.const [148] = Utf8 java/lang/StringBuffer 
.const [149] = Utf8 toString 
.const [150] = Utf8 ()Ljava/lang/String; 
.const [151] = Utf8 de/esolutions/fw/util/serializer/exception/SerializerException 
.const [152] = Utf8 getMessage 
.const [153] = Utf8 ()Ljava/lang/String; 
.const [154] = Utf8 de/esolutions/fw/comm/core/ServiceInstanceID 
.const [155] = Utf8 <init> 
.const [156] = Utf8 (Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V 
.const [157] = Utf8 de/esolutions/fw/comm/core/AbstractReplyService 
.const [158] = Utf8 <init> 
.const [159] = Utf8 (Lde/esolutions/fw/comm/core/ServiceInstanceID;)V 
.const [160] = Utf8 de/esolutions/fw/comm/dsi/swdllogging/impl/DSISwdlLoggingReplyService 
.const [161] = Utf8 dynamicHandle 
.const [162] = Utf8 I 
.const [163] = Utf8 de/esolutions/fw/comm/dsi/swdllogging/impl/DSISwdlLoggingReplyService 
.const [164] = Utf8 context 
.const [165] = Utf8 Lde/esolutions/fw/comm/core/CallContext; 
.const [166] = Utf8 java/lang/StringBuffer 
.const [167] = Utf8 <init> 
.const [168] = Utf8 ()V 
.const [169] = Utf8 de/esolutions/fw/comm/core/method/MethodException 
.const [170] = Utf8 <init> 
.const [171] = Utf8 (Ljava/lang/String;)V 
.const [172] = Utf8 de/esolutions/fw/comm/dsi/swdllogging/impl/DSISwdlLoggingReplyService 
.const [173] = Utf8 p_DSISwdlLoggingReply 
.const [174] = Utf8 Lde/esolutions/fw/comm/dsi/swdllogging/DSISwdlLoggingReply; 
.const [175] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [176] = Utf8 getOptionalStringVarArray 
.const [177] = Utf8 ()[Ljava/lang/String; 
.const [178] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [179] = Utf8 getOptionalInt32VarArray 
.const [180] = Utf8 ()[I 
.const [181] = Utf8 de/esolutions/fw/comm/dsi/swdllogging/DSISwdlLoggingReply 
.const [182] = Utf8 getHistory 
.const [183] = Utf8 ([Ljava/lang/String;[I)V 
.const [184] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [185] = Utf8 getInt32 
.const [186] = Utf8 ()I 
.const [187] = Utf8 de/esolutions/fw/comm/dsi/swdllogging/DSISwdlLoggingReply 
.const [188] = Utf8 setUpdate 
.const [189] = Utf8 (I)V 
.const [190] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [191] = Utf8 getBool 
.const [192] = Utf8 ()Z 
.const [193] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [194] = Utf8 getOptionalString 
.const [195] = Utf8 ()Ljava/lang/String; 
.const [196] = Utf8 de/esolutions/fw/comm/dsi/swdllogging/DSISwdlLoggingReply 
.const [197] = Utf8 getGeneralInformation 
.const [198] = Utf8 (ZLjava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;[IZI[I)V 
.const [199] = Utf8 de/esolutions/fw/comm/dsi/swdllogging/DSISwdlLoggingReply 
.const [200] = Utf8 getUnusualEvents 
.const [201] = Utf8 ([I[Ljava/lang/String;)V 
.const [202] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [203] = Utf8 getInt8 
.const [204] = Utf8 ()B 
.const [205] = Utf8 de/esolutions/fw/comm/dsi/swdllogging/DSISwdlLoggingReply 
.const [206] = Utf8 getUnusualEvent 
.const [207] = Utf8 (ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;BI)V 
.const [208] = Utf8 de/esolutions/fw/comm/dsi/swdllogging/DSISwdlLoggingReply 
.const [209] = Utf8 asyncException 
.const [210] = Utf8 (ILjava/lang/String;I)V 
.const [211] = Utf8 de/esolutions/fw/comm/dsi/swdllogging/DSISwdlLoggingReply 
.const [212] = Utf8 yyIndication 
.const [213] = Utf8 (Ljava/lang/String;Ljava/lang/String;)V 
.const [214] = Utf8 de/esolutions/fw/comm/dsi/swdllogging/impl/DSISwdlLoggingReplyService 
.const [215] = Class [214] 
.const [216] = Utf8 de/esolutions/fw/comm/core/AbstractReplyService 
.const [217] = Class [216] 
.const [218] = Utf8 context 
.const [219] = Utf8 Lde/esolutions/fw/comm/core/CallContext; 
.const [220] = Utf8 dynamicHandle 
.const [221] = Utf8 I 
.const [222] = Utf8 p_DSISwdlLoggingReply 
.const [223] = Utf8 Lde/esolutions/fw/comm/dsi/swdllogging/DSISwdlLoggingReply; 
.const [224] = Utf8 Code 
.const [225] = Utf8 <init> 
.const [226] = Utf8 (Lde/esolutions/fw/comm/dsi/swdllogging/DSISwdlLoggingReply;)V 
.const [227] = Utf8 nextDynamicHandle 
.const [228] = Utf8 ()I 
.const [229] = Utf8 getCallContext 
.const [230] = Utf8 ()Lde/esolutions/fw/comm/core/CallContext; 
.const [231] = Utf8 handleCallMethod 
.const [232] = Utf8 (SLde/esolutions/fw/util/serializer/IDeserializer;Lde/esolutions/fw/comm/core/IProxyFrontend;)V 
.const [233] = Utf8 <clinit> 
.const [234] = Utf8 ()V 
.end class 
