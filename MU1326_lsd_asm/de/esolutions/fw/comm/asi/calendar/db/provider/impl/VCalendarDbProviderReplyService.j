.version 50 0 
.class public super [263] 
.super [265] 
.field private static final [266] [267] 
.field private static [268] [269] 
.field private [270] [271] 

.method public [273] : [274] 
    .attribute [272] .code stack 7 locals 0 
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

.method private static synchronized [275] : [276] 
    .attribute [272] .code stack 2 locals 1 
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

.method public [277] : [278] 
    .attribute [272] .code stack 1 locals 0 
L0:     getstatic [8] 
L3:     areturn 
L4:     
    .end code 
.end method 

.method public [279] : [280] 
    .attribute [272] .code stack 4 locals 2 
        .catch [16] from L0 to L505 using L508 
L0:     iload_1 
L1:     tableswitch 1 
            L180 
            L478 
            L136 
            L478 
            L158 
            L310 
            L478 
            L478 
            L268 
            L478 
            L246 
            L478 
            L202 
            L478 
            L224 
            L478 
            L288 
            L478 
            L478 
            L456 
            L478 
            L344 
            L478 
            L396 
            L478 
            L426 
            L478 
            L374 
            L478 
            L322 
            default : L478 

L136:   aload_2 
L137:   invokeinterface [42] 0 
L142:   istore 4 
L144:   aload_0 
L145:   getfield [29] 
L148:   iload 4 
L150:   invokeinterface [43] 0 
L155:   goto L505 
L158:   aload_2 
L159:   invokeinterface [42] 0 
L164:   istore 4 
L166:   aload_0 
L167:   getfield [29] 
L170:   iload 4 
L172:   invokeinterface [44] 0 
L177:   goto L505 
L180:   aload_2 
L181:   invokeinterface [42] 0 
L186:   istore 4 
L188:   aload_0 
L189:   getfield [29] 
L192:   iload 4 
L194:   invokeinterface [45] 0 
L199:   goto L505 
L202:   aload_2 
L203:   invokeinterface [42] 0 
L208:   istore 4 
L210:   aload_0 
L211:   getfield [29] 
L214:   iload 4 
L216:   invokeinterface [46] 0 
L221:   goto L505 
L224:   aload_2 
L225:   invokeinterface [42] 0 
L230:   istore 4 
L232:   aload_0 
L233:   getfield [29] 
L236:   iload 4 
L238:   invokeinterface [47] 0 
L243:   goto L505 
L246:   aload_2 
L247:   invokeinterface [42] 0 
L252:   istore 4 
L254:   aload_0 
L255:   getfield [29] 
L258:   iload 4 
L260:   invokeinterface [48] 0 
L265:   goto L505 
L268:   aload_2 
L269:   invokestatic [9] 
L272:   astore 4 
L274:   aload_0 
L275:   getfield [29] 
L278:   aload 4 
L280:   invokeinterface [49] 0 
L285:   goto L505 
L288:   aload_2 
L289:   invokeinterface [42] 0 
L294:   istore 4 
L296:   aload_0 
L297:   getfield [29] 
L300:   iload 4 
L302:   invokeinterface [50] 0 
L307:   goto L505 
L310:   aload_0 
L311:   getfield [29] 
L314:   invokeinterface [51] 0 
L319:   goto L505 
L322:   aload_2 
L323:   invokeinterface [42] 0 
L328:   istore 4 
L330:   aload_0 
L331:   getfield [29] 
L334:   iload 4 
L336:   invokeinterface [52] 0 
L341:   goto L505 
L344:   aload_2 
L345:   invokeinterface [42] 0 
L350:   istore 4 
L352:   aload_2 
L353:   invokestatic [10] 
L356:   astore 5 
L358:   aload_0 
L359:   getfield [29] 
L362:   iload 4 
L364:   aload 5 
L366:   invokeinterface [53] 0 
L371:   goto L505 
L374:   aload_2 
L375:   invokeinterface [42] 0 
L380:   istore 4 
L382:   aload_0 
L383:   getfield [29] 
L386:   iload 4 
L388:   invokeinterface [54] 0 
L393:   goto L505 
L396:   aload_2 
L397:   invokeinterface [42] 0 
L402:   istore 4 
L404:   aload_2 
L405:   invokestatic [11] 
L408:   astore 5 
L410:   aload_0 
L411:   getfield [29] 
L414:   iload 4 
L416:   aload 5 
L418:   invokeinterface [55] 0 
L423:   goto L505 
L426:   aload_2 
L427:   invokeinterface [42] 0 
L432:   istore 4 
L434:   aload_2 
L435:   invokestatic [12] 
L438:   astore 5 
L440:   aload_0 
L441:   getfield [29] 
L444:   iload 4 
L446:   aload 5 
L448:   invokeinterface [56] 0 
L453:   goto L505 
L456:   aload_2 
L457:   invokeinterface [42] 0 
L462:   istore 4 
L464:   aload_0 
L465:   getfield [29] 
L468:   iload 4 
L470:   invokeinterface [57] 0 
L475:   goto L505 
L478:   new [58] 
L481:   dup 
L482:   new [59] 
L485:   dup 
L486:   invokespecial [38] 
L489:   ldc [15] 
L491:   invokevirtual [30] 
L494:   iload_1 
L495:   invokevirtual [31] 
L498:   invokevirtual [32] 
L501:   invokespecial [39] 
L504:   athrow 
L505:   goto L550 
L508:   astore 4 
L510:   new [58] 
L513:   dup 
L514:   new [59] 
L517:   dup 
L518:   invokespecial [38] 
L521:   ldc [17] 
L523:   invokevirtual [30] 
L526:   iload_1 
L527:   invokevirtual [31] 
L530:   ldc [18] 
L532:   invokevirtual [30] 
L535:   aload 4 
L537:   invokevirtual [33] 
L540:   invokevirtual [30] 
L543:   invokevirtual [32] 
L546:   invokespecial [39] 
L549:   athrow 
L550:   return 
L551:   nop 
L552:   
    .end code 
.end method 

.method static [281] : [282] 
    .attribute [272] .code stack 1 locals 0 
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
.const [2] = Class [60] 
.const [3] = String [61] 
.const [4] = Method [62] [63] 
.const [5] = String [64] 
.const [6] = String [65] 
.const [7] = Field [66] [67] 
.const [8] = Field [68] [69] 
.const [9] = Method [70] [71] 
.const [10] = Method [72] [73] 
.const [11] = Method [74] [75] 
.const [12] = Method [76] [77] 
.const [13] = Class [78] 
.const [14] = Class [79] 
.const [15] = String [80] 
.const [16] = Class [81] 
.const [17] = String [82] 
.const [18] = String [83] 
.const [19] = String [84] 
.const [20] = Method [85] [86] 
.const [21] = Class [87] 
.const [22] = Class [88] 
.const [23] = Class [89] 
.const [24] = Class [90] 
.const [25] = Class [91] 
.const [26] = Class [92] 
.const [27] = Class [93] 
.const [28] = Class [94] 
.const [29] = Field [95] [96] 
.const [30] = Method [97] [98] 
.const [31] = Method [99] [100] 
.const [32] = Method [101] [102] 
.const [33] = Method [103] [104] 
.const [34] = Method [105] [106] 
.const [35] = Method [107] [108] 
.const [36] = Field [109] [110] 
.const [37] = Field [111] [112] 
.const [38] = Method [113] [114] 
.const [39] = Method [115] [116] 
.const [40] = Class [117] 
.const [41] = Field [118] [119] 
.const [42] = InterfaceMethod [120] [121] 
.const [43] = InterfaceMethod [122] [123] 
.const [44] = InterfaceMethod [124] [125] 
.const [45] = InterfaceMethod [126] [127] 
.const [46] = InterfaceMethod [128] [129] 
.const [47] = InterfaceMethod [130] [131] 
.const [48] = InterfaceMethod [132] [133] 
.const [49] = InterfaceMethod [134] [135] 
.const [50] = InterfaceMethod [136] [137] 
.const [51] = InterfaceMethod [138] [139] 
.const [52] = InterfaceMethod [140] [141] 
.const [53] = InterfaceMethod [142] [143] 
.const [54] = InterfaceMethod [144] [145] 
.const [55] = InterfaceMethod [146] [147] 
.const [56] = InterfaceMethod [148] [149] 
.const [57] = InterfaceMethod [150] [151] 
.const [58] = Class [152] 
.const [59] = Class [153] 
.const [60] = Utf8 de/esolutions/fw/comm/core/ServiceInstanceID 
.const [61] = Utf8 '958eeab9-87d2-470a-b62e-bd9bdd6070f6' 
.const [62] = Class [154] 
.const [63] = NameAndType [155] [156] 
.const [64] = Utf8 c499e56b-0fd0-59f4-9181-c70e221b3299 
.const [65] = Utf8 'asi.calendar.db.provider.VCalendarDbProvider' 
.const [66] = Class [157] 
.const [67] = NameAndType [158] [159] 
.const [68] = Class [160] 
.const [69] = NameAndType [161] [162] 
.const [70] = Class [163] 
.const [71] = NameAndType [164] [165] 
.const [72] = Class [166] 
.const [73] = NameAndType [167] [168] 
.const [74] = Class [169] 
.const [75] = NameAndType [170] [171] 
.const [76] = Class [172] 
.const [77] = NameAndType [173] [174] 
.const [78] = Utf8 de/esolutions/fw/comm/core/method/MethodException 
.const [79] = Utf8 java/lang/StringBuffer 
.const [80] = Utf8 'Invalid Method Id ' 
.const [81] = Utf8 de/esolutions/fw/util/serializer/exception/SerializerException 
.const [82] = Utf8 'Deserialization failed: method=' 
.const [83] = Utf8 ', error=' 
.const [84] = Utf8 'STUB.asi.calendar.db.provider.VCalendarDbProvider' 
.const [85] = Class [175] 
.const [86] = NameAndType [176] [177] 
.const [87] = Utf8 de/esolutions/fw/comm/asi/calendar/db/provider/impl/VCalendarDbProviderReplyService 
.const [88] = Utf8 de/esolutions/fw/comm/core/AbstractReplyService 
.const [89] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [90] = Utf8 de/esolutions/fw/comm/asi/calendar/db/provider/VCalendarDbProviderReply 
.const [91] = Utf8 de/esolutions/fw/comm/asi/calendar/db/provider/impl/VersionInfoSerializer 
.const [92] = Utf8 de/esolutions/fw/comm/dsi/calendar/impl/CalendarConfigSerializer 
.const [93] = Utf8 de/esolutions/fw/comm/dsi/calendar/impl/VEventSerializer 
.const [94] = Utf8 de/esolutions/fw/comm/core/CallContext 
.const [95] = Class [178] 
.const [96] = NameAndType [179] [180] 
.const [97] = Class [181] 
.const [98] = NameAndType [182] [183] 
.const [99] = Class [184] 
.const [100] = NameAndType [185] [186] 
.const [101] = Class [187] 
.const [102] = NameAndType [188] [189] 
.const [103] = Class [190] 
.const [104] = NameAndType [191] [192] 
.const [105] = Class [193] 
.const [106] = NameAndType [194] [195] 
.const [107] = Class [196] 
.const [108] = NameAndType [197] [198] 
.const [109] = Class [199] 
.const [110] = NameAndType [200] [201] 
.const [111] = Class [202] 
.const [112] = NameAndType [203] [204] 
.const [113] = Class [205] 
.const [114] = NameAndType [206] [207] 
.const [115] = Class [208] 
.const [116] = NameAndType [209] [210] 
.const [117] = Utf8 de/esolutions/fw/comm/core/ServiceInstanceID 
.const [118] = Class [211] 
.const [119] = NameAndType [212] [213] 
.const [120] = Class [214] 
.const [121] = NameAndType [215] [216] 
.const [122] = Class [217] 
.const [123] = NameAndType [218] [219] 
.const [124] = Class [220] 
.const [125] = NameAndType [221] [222] 
.const [126] = Class [223] 
.const [127] = NameAndType [224] [225] 
.const [128] = Class [226] 
.const [129] = NameAndType [227] [228] 
.const [130] = Class [229] 
.const [131] = NameAndType [230] [231] 
.const [132] = Class [232] 
.const [133] = NameAndType [233] [234] 
.const [134] = Class [235] 
.const [135] = NameAndType [236] [237] 
.const [136] = Class [238] 
.const [137] = NameAndType [239] [240] 
.const [138] = Class [241] 
.const [139] = NameAndType [242] [243] 
.const [140] = Class [244] 
.const [141] = NameAndType [245] [246] 
.const [142] = Class [247] 
.const [143] = NameAndType [248] [249] 
.const [144] = Class [250] 
.const [145] = NameAndType [251] [252] 
.const [146] = Class [253] 
.const [147] = NameAndType [254] [255] 
.const [148] = Class [256] 
.const [149] = NameAndType [257] [258] 
.const [150] = Class [259] 
.const [151] = NameAndType [260] [261] 
.const [152] = Utf8 de/esolutions/fw/comm/core/method/MethodException 
.const [153] = Utf8 java/lang/StringBuffer 
.const [154] = Utf8 de/esolutions/fw/comm/asi/calendar/db/provider/impl/VCalendarDbProviderReplyService 
.const [155] = Utf8 nextDynamicHandle 
.const [156] = Utf8 ()I 
.const [157] = Utf8 de/esolutions/fw/comm/asi/calendar/db/provider/impl/VCalendarDbProviderReplyService 
.const [158] = Utf8 dynamicHandle 
.const [159] = Utf8 I 
.const [160] = Utf8 de/esolutions/fw/comm/asi/calendar/db/provider/impl/VCalendarDbProviderReplyService 
.const [161] = Utf8 context 
.const [162] = Utf8 Lde/esolutions/fw/comm/core/CallContext; 
.const [163] = Utf8 de/esolutions/fw/comm/asi/calendar/db/provider/impl/VersionInfoSerializer 
.const [164] = Utf8 getOptionalVersionInfoVarArray 
.const [165] = Utf8 (Lde/esolutions/fw/util/serializer/IDeserializer;)[Lde/esolutions/fw/comm/asi/calendar/db/provider/VersionInfo; 
.const [166] = Utf8 de/esolutions/fw/comm/dsi/calendar/impl/CalendarConfigSerializer 
.const [167] = Utf8 getOptionalCalendarConfig 
.const [168] = Utf8 (Lde/esolutions/fw/util/serializer/IDeserializer;)Lorg/dsi/ifc/calendar/CalendarConfig; 
.const [169] = Utf8 de/esolutions/fw/comm/dsi/calendar/impl/VEventSerializer 
.const [170] = Utf8 getOptionalVEvent 
.const [171] = Utf8 (Lde/esolutions/fw/util/serializer/IDeserializer;)Lorg/dsi/ifc/calendar/VEvent; 
.const [172] = Utf8 de/esolutions/fw/comm/dsi/calendar/impl/VEventSerializer 
.const [173] = Utf8 getOptionalVEventVarArray 
.const [174] = Utf8 (Lde/esolutions/fw/util/serializer/IDeserializer;)[Lorg/dsi/ifc/calendar/VEvent; 
.const [175] = Utf8 de/esolutions/fw/comm/core/CallContext 
.const [176] = Utf8 getContext 
.const [177] = Utf8 (Ljava/lang/String;)Lde/esolutions/fw/comm/core/CallContext; 
.const [178] = Utf8 de/esolutions/fw/comm/asi/calendar/db/provider/impl/VCalendarDbProviderReplyService 
.const [179] = Utf8 p_VCalendarDbProviderReply 
.const [180] = Utf8 Lde/esolutions/fw/comm/asi/calendar/db/provider/VCalendarDbProviderReply; 
.const [181] = Utf8 java/lang/StringBuffer 
.const [182] = Utf8 append 
.const [183] = Utf8 (Ljava/lang/String;)Ljava/lang/StringBuffer; 
.const [184] = Utf8 java/lang/StringBuffer 
.const [185] = Utf8 append 
.const [186] = Utf8 (I)Ljava/lang/StringBuffer; 
.const [187] = Utf8 java/lang/StringBuffer 
.const [188] = Utf8 toString 
.const [189] = Utf8 ()Ljava/lang/String; 
.const [190] = Utf8 de/esolutions/fw/util/serializer/exception/SerializerException 
.const [191] = Utf8 getMessage 
.const [192] = Utf8 ()Ljava/lang/String; 
.const [193] = Utf8 de/esolutions/fw/comm/core/ServiceInstanceID 
.const [194] = Utf8 <init> 
.const [195] = Utf8 (Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V 
.const [196] = Utf8 de/esolutions/fw/comm/core/AbstractReplyService 
.const [197] = Utf8 <init> 
.const [198] = Utf8 (Lde/esolutions/fw/comm/core/ServiceInstanceID;)V 
.const [199] = Utf8 de/esolutions/fw/comm/asi/calendar/db/provider/impl/VCalendarDbProviderReplyService 
.const [200] = Utf8 dynamicHandle 
.const [201] = Utf8 I 
.const [202] = Utf8 de/esolutions/fw/comm/asi/calendar/db/provider/impl/VCalendarDbProviderReplyService 
.const [203] = Utf8 context 
.const [204] = Utf8 Lde/esolutions/fw/comm/core/CallContext; 
.const [205] = Utf8 java/lang/StringBuffer 
.const [206] = Utf8 <init> 
.const [207] = Utf8 ()V 
.const [208] = Utf8 de/esolutions/fw/comm/core/method/MethodException 
.const [209] = Utf8 <init> 
.const [210] = Utf8 (Ljava/lang/String;)V 
.const [211] = Utf8 de/esolutions/fw/comm/asi/calendar/db/provider/impl/VCalendarDbProviderReplyService 
.const [212] = Utf8 p_VCalendarDbProviderReply 
.const [213] = Utf8 Lde/esolutions/fw/comm/asi/calendar/db/provider/VCalendarDbProviderReply; 
.const [214] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [215] = Utf8 getEnum 
.const [216] = Utf8 ()I 
.const [217] = Utf8 de/esolutions/fw/comm/asi/calendar/db/provider/VCalendarDbProviderReply 
.const [218] = Utf8 beginTransactionResult 
.const [219] = Utf8 (I)V 
.const [220] = Utf8 de/esolutions/fw/comm/asi/calendar/db/provider/VCalendarDbProviderReply 
.const [221] = Utf8 commitTransactionResult 
.const [222] = Utf8 (I)V 
.const [223] = Utf8 de/esolutions/fw/comm/asi/calendar/db/provider/VCalendarDbProviderReply 
.const [224] = Utf8 addEntriesResult 
.const [225] = Utf8 (I)V 
.const [226] = Utf8 de/esolutions/fw/comm/asi/calendar/db/provider/VCalendarDbProviderReply 
.const [227] = Utf8 removeEntriesResult 
.const [228] = Utf8 (I)V 
.const [229] = Utf8 de/esolutions/fw/comm/asi/calendar/db/provider/VCalendarDbProviderReply 
.const [230] = Utf8 removeProfileResult 
.const [231] = Utf8 (I)V 
.const [232] = Utf8 de/esolutions/fw/comm/asi/calendar/db/provider/VCalendarDbProviderReply 
.const [233] = Utf8 removeAllResult 
.const [234] = Utf8 (I)V 
.const [235] = Utf8 de/esolutions/fw/comm/asi/calendar/db/provider/VCalendarDbProviderReply 
.const [236] = Utf8 getVersionResult 
.const [237] = Utf8 ([Lde/esolutions/fw/comm/asi/calendar/db/provider/VersionInfo;)V 
.const [238] = Utf8 de/esolutions/fw/comm/asi/calendar/db/provider/VCalendarDbProviderReply 
.const [239] = Utf8 setActiveProfilesResult 
.const [240] = Utf8 (I)V 
.const [241] = Utf8 de/esolutions/fw/comm/asi/calendar/db/provider/VCalendarDbProviderReply 
.const [242] = Utf8 forceGetData 
.const [243] = Utf8 ()V 
.const [244] = Utf8 de/esolutions/fw/comm/asi/calendar/db/provider/VCalendarDbProviderReply 
.const [245] = Utf8 setCalendarConfigResult 
.const [246] = Utf8 (I)V 
.const [247] = Utf8 de/esolutions/fw/comm/asi/calendar/db/provider/VCalendarDbProviderReply 
.const [248] = Utf8 getCalendarConfigResult 
.const [249] = Utf8 (ILorg/dsi/ifc/calendar/CalendarConfig;)V 
.const [250] = Utf8 de/esolutions/fw/comm/asi/calendar/db/provider/VCalendarDbProviderReply 
.const [251] = Utf8 insertProfileResult 
.const [252] = Utf8 (I)V 
.const [253] = Utf8 de/esolutions/fw/comm/asi/calendar/db/provider/VCalendarDbProviderReply 
.const [254] = Utf8 getCalendarEntryResult 
.const [255] = Utf8 (ILorg/dsi/ifc/calendar/VEvent;)V 
.const [256] = Utf8 de/esolutions/fw/comm/asi/calendar/db/provider/VCalendarDbProviderReply 
.const [257] = Utf8 getCalendarSummariesResult 
.const [258] = Utf8 (I[Lorg/dsi/ifc/calendar/VEvent;)V 
.const [259] = Utf8 de/esolutions/fw/comm/asi/calendar/db/provider/VCalendarDbProviderReply 
.const [260] = Utf8 deleteProfileResult 
.const [261] = Utf8 (I)V 
.const [262] = Utf8 de/esolutions/fw/comm/asi/calendar/db/provider/impl/VCalendarDbProviderReplyService 
.const [263] = Class [262] 
.const [264] = Utf8 de/esolutions/fw/comm/core/AbstractReplyService 
.const [265] = Class [264] 
.const [266] = Utf8 context 
.const [267] = Utf8 Lde/esolutions/fw/comm/core/CallContext; 
.const [268] = Utf8 dynamicHandle 
.const [269] = Utf8 I 
.const [270] = Utf8 p_VCalendarDbProviderReply 
.const [271] = Utf8 Lde/esolutions/fw/comm/asi/calendar/db/provider/VCalendarDbProviderReply; 
.const [272] = Utf8 Code 
.const [273] = Utf8 <init> 
.const [274] = Utf8 (Lde/esolutions/fw/comm/asi/calendar/db/provider/VCalendarDbProviderReply;)V 
.const [275] = Utf8 nextDynamicHandle 
.const [276] = Utf8 ()I 
.const [277] = Utf8 getCallContext 
.const [278] = Utf8 ()Lde/esolutions/fw/comm/core/CallContext; 
.const [279] = Utf8 handleCallMethod 
.const [280] = Utf8 (SLde/esolutions/fw/util/serializer/IDeserializer;Lde/esolutions/fw/comm/core/IProxyFrontend;)V 
.const [281] = Utf8 <clinit> 
.const [282] = Utf8 ()V 
.end class 
