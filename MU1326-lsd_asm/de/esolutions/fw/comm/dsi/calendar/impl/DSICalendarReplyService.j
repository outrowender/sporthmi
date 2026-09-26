.version 50 0 
.class public super [263] 
.super [265] 
.field private static final [266] [267] 
.field private static [268] [269] 
.field private [270] [271] 

.method public [273] : [274] 
    .attribute [272] .code stack 7 locals 0 
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

.method private static synchronized [275] : [276] 
    .attribute [272] .code stack 2 locals 1 
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

.method public [277] : [278] 
    .attribute [272] .code stack 1 locals 0 
L0:     getstatic [8] 
L3:     areturn 
L4:     
    .end code 
.end method 

.method public [279] : [280] 
    .attribute [272] .code stack 4 locals 3 
        .catch [15] from L0 to L465 using L468 
L0:     iload_1 
L1:     tableswitch 17 
            L364 
            L342 
            L224 
            L172 
            L98 
            L68 
            L256 
            L288 
            L128 
            L320 
            L202 
            L150 
            L406 
            default : L438 

L68:    aload_2 
L69:    invokeinterface [41] 0 
L74:    istore 4 
L76:    aload_2 
L77:    invokestatic [9] 
L80:    astore 5 
L82:    aload_0 
L83:    getfield [28] 
L86:    iload 4 
L88:    aload 5 
L90:    invokeinterface [42] 0 
L95:    goto L465 
L98:    aload_2 
L99:    invokeinterface [41] 0 
L104:   istore 4 
L106:   aload_2 
L107:   invokestatic [10] 
L110:   astore 5 
L112:   aload_0 
L113:   getfield [28] 
L116:   iload 4 
L118:   aload 5 
L120:   invokeinterface [43] 0 
L125:   goto L465 
L128:   aload_2 
L129:   invokeinterface [44] 0 
L134:   lstore 4 
L136:   aload_0 
L137:   getfield [28] 
L140:   lload 4 
L142:   invokeinterface [45] 0 
L147:   goto L465 
L150:   aload_2 
L151:   invokeinterface [41] 0 
L156:   istore 4 
L158:   aload_0 
L159:   getfield [28] 
L162:   iload 4 
L164:   invokeinterface [46] 0 
L169:   goto L465 
L172:   aload_2 
L173:   invokeinterface [41] 0 
L178:   istore 4 
L180:   aload_2 
L181:   invokestatic [11] 
L184:   astore 5 
L186:   aload_0 
L187:   getfield [28] 
L190:   iload 4 
L192:   aload 5 
L194:   invokeinterface [47] 0 
L199:   goto L465 
L202:   aload_2 
L203:   invokeinterface [41] 0 
L208:   istore 4 
L210:   aload_0 
L211:   getfield [28] 
L214:   iload 4 
L216:   invokeinterface [48] 0 
L221:   goto L465 
L224:   aload_2 
L225:   invokeinterface [41] 0 
L230:   istore 4 
L232:   aload_2 
L233:   invokeinterface [44] 0 
L238:   lstore 5 
L240:   aload_0 
L241:   getfield [28] 
L244:   iload 4 
L246:   lload 5 
L248:   invokeinterface [49] 0 
L253:   goto L465 
L256:   aload_2 
L257:   invokeinterface [41] 0 
L262:   istore 4 
L264:   aload_2 
L265:   invokeinterface [50] 0 
L270:   astore 5 
L272:   aload_0 
L273:   getfield [28] 
L276:   iload 4 
L278:   aload 5 
L280:   invokeinterface [51] 0 
L285:   goto L465 
L288:   aload_2 
L289:   invokeinterface [41] 0 
L294:   istore 4 
L296:   aload_2 
L297:   invokeinterface [50] 0 
L302:   astore 5 
L304:   aload_0 
L305:   getfield [28] 
L308:   iload 4 
L310:   aload 5 
L312:   invokeinterface [52] 0 
L317:   goto L465 
L320:   aload_2 
L321:   invokeinterface [41] 0 
L326:   istore 4 
L328:   aload_0 
L329:   getfield [28] 
L332:   iload 4 
L334:   invokeinterface [53] 0 
L339:   goto L465 
L342:   aload_2 
L343:   invokeinterface [41] 0 
L348:   istore 4 
L350:   aload_0 
L351:   getfield [28] 
L354:   iload 4 
L356:   invokeinterface [54] 0 
L361:   goto L465 
L364:   aload_2 
L365:   invokeinterface [41] 0 
L370:   istore 4 
L372:   aload_2 
L373:   invokeinterface [55] 0 
L378:   astore 5 
L380:   aload_2 
L381:   invokeinterface [41] 0 
L386:   istore 6 
L388:   aload_0 
L389:   getfield [28] 
L392:   iload 4 
L394:   aload 5 
L396:   iload 6 
L398:   invokeinterface [56] 0 
L403:   goto L465 
L406:   aload_2 
L407:   invokeinterface [55] 0 
L412:   astore 4 
L414:   aload_2 
L415:   invokeinterface [55] 0 
L420:   astore 5 
L422:   aload_0 
L423:   getfield [28] 
L426:   aload 4 
L428:   aload 5 
L430:   invokeinterface [57] 0 
L435:   goto L465 
L438:   new [58] 
L441:   dup 
L442:   new [59] 
L445:   dup 
L446:   invokespecial [37] 
L449:   ldc [14] 
L451:   invokevirtual [29] 
L454:   iload_1 
L455:   invokevirtual [30] 
L458:   invokevirtual [31] 
L461:   invokespecial [38] 
L464:   athrow 
L465:   goto L510 
L468:   astore 4 
L470:   new [58] 
L473:   dup 
L474:   new [59] 
L477:   dup 
L478:   invokespecial [37] 
L481:   ldc [16] 
L483:   invokevirtual [29] 
L486:   iload_1 
L487:   invokevirtual [30] 
L490:   ldc [17] 
L492:   invokevirtual [29] 
L495:   aload 4 
L497:   invokevirtual [32] 
L500:   invokevirtual [29] 
L503:   invokevirtual [31] 
L506:   invokespecial [38] 
L509:   athrow 
L510:   return 
L511:   nop 
L512:   
    .end code 
.end method 

.method static [281] : [282] 
    .attribute [272] .code stack 1 locals 0 
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
.const [12] = Class [76] 
.const [13] = Class [77] 
.const [14] = String [78] 
.const [15] = Class [79] 
.const [16] = String [80] 
.const [17] = String [81] 
.const [18] = String [82] 
.const [19] = Method [83] [84] 
.const [20] = Class [85] 
.const [21] = Class [86] 
.const [22] = Class [87] 
.const [23] = Class [88] 
.const [24] = Class [89] 
.const [25] = Class [90] 
.const [26] = Class [91] 
.const [27] = Class [92] 
.const [28] = Field [93] [94] 
.const [29] = Method [95] [96] 
.const [30] = Method [97] [98] 
.const [31] = Method [99] [100] 
.const [32] = Method [101] [102] 
.const [33] = Method [103] [104] 
.const [34] = Method [105] [106] 
.const [35] = Field [107] [108] 
.const [36] = Field [109] [110] 
.const [37] = Method [111] [112] 
.const [38] = Method [113] [114] 
.const [39] = Class [115] 
.const [40] = Field [116] [117] 
.const [41] = InterfaceMethod [118] [119] 
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
.const [61] = Utf8 b0c956ce-2978-5f05-a1c0-1c800024a427 
.const [62] = Class [154] 
.const [63] = NameAndType [155] [156] 
.const [64] = Utf8 '6a609309-2671-5e07-ae85-f93f7f5634b3' 
.const [65] = Utf8 'dsi.calendar.DSICalendar' 
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
.const [76] = Utf8 de/esolutions/fw/comm/core/method/MethodException 
.const [77] = Utf8 java/lang/StringBuffer 
.const [78] = Utf8 'Invalid Method Id ' 
.const [79] = Utf8 de/esolutions/fw/util/serializer/exception/SerializerException 
.const [80] = Utf8 'Deserialization failed: method=' 
.const [81] = Utf8 ', error=' 
.const [82] = Utf8 'STUB.dsi.calendar.DSICalendar' 
.const [83] = Class [172] 
.const [84] = NameAndType [173] [174] 
.const [85] = Utf8 de/esolutions/fw/comm/dsi/calendar/impl/DSICalendarReplyService 
.const [86] = Utf8 de/esolutions/fw/comm/core/AbstractReplyService 
.const [87] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [88] = Utf8 de/esolutions/fw/comm/dsi/calendar/impl/CalendarSummarySerializer 
.const [89] = Utf8 de/esolutions/fw/comm/dsi/calendar/DSICalendarReply 
.const [90] = Utf8 de/esolutions/fw/comm/dsi/calendar/impl/CalendarEntrySerializer 
.const [91] = Utf8 de/esolutions/fw/comm/dsi/calendar/impl/CalendarConfigSerializer 
.const [92] = Utf8 de/esolutions/fw/comm/core/CallContext 
.const [93] = Class [175] 
.const [94] = NameAndType [176] [177] 
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
.const [115] = Utf8 de/esolutions/fw/comm/core/ServiceInstanceID 
.const [116] = Class [208] 
.const [117] = NameAndType [209] [210] 
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
.const [154] = Utf8 de/esolutions/fw/comm/dsi/calendar/impl/DSICalendarReplyService 
.const [155] = Utf8 nextDynamicHandle 
.const [156] = Utf8 ()I 
.const [157] = Utf8 de/esolutions/fw/comm/dsi/calendar/impl/DSICalendarReplyService 
.const [158] = Utf8 dynamicHandle 
.const [159] = Utf8 I 
.const [160] = Utf8 de/esolutions/fw/comm/dsi/calendar/impl/DSICalendarReplyService 
.const [161] = Utf8 context 
.const [162] = Utf8 Lde/esolutions/fw/comm/core/CallContext; 
.const [163] = Utf8 de/esolutions/fw/comm/dsi/calendar/impl/CalendarSummarySerializer 
.const [164] = Utf8 getOptionalCalendarSummaryVarArray 
.const [165] = Utf8 (Lde/esolutions/fw/util/serializer/IDeserializer;)[Lorg/dsi/ifc/calendar/CalendarSummary; 
.const [166] = Utf8 de/esolutions/fw/comm/dsi/calendar/impl/CalendarEntrySerializer 
.const [167] = Utf8 getOptionalCalendarEntry 
.const [168] = Utf8 (Lde/esolutions/fw/util/serializer/IDeserializer;)Lorg/dsi/ifc/calendar/CalendarEntry; 
.const [169] = Utf8 de/esolutions/fw/comm/dsi/calendar/impl/CalendarConfigSerializer 
.const [170] = Utf8 getOptionalCalendarConfig 
.const [171] = Utf8 (Lde/esolutions/fw/util/serializer/IDeserializer;)Lorg/dsi/ifc/calendar/CalendarConfig; 
.const [172] = Utf8 de/esolutions/fw/comm/core/CallContext 
.const [173] = Utf8 getContext 
.const [174] = Utf8 (Ljava/lang/String;)Lde/esolutions/fw/comm/core/CallContext; 
.const [175] = Utf8 de/esolutions/fw/comm/dsi/calendar/impl/DSICalendarReplyService 
.const [176] = Utf8 p_DSICalendarReply 
.const [177] = Utf8 Lde/esolutions/fw/comm/dsi/calendar/DSICalendarReply; 
.const [178] = Utf8 java/lang/StringBuffer 
.const [179] = Utf8 append 
.const [180] = Utf8 (Ljava/lang/String;)Ljava/lang/StringBuffer; 
.const [181] = Utf8 java/lang/StringBuffer 
.const [182] = Utf8 append 
.const [183] = Utf8 (I)Ljava/lang/StringBuffer; 
.const [184] = Utf8 java/lang/StringBuffer 
.const [185] = Utf8 toString 
.const [186] = Utf8 ()Ljava/lang/String; 
.const [187] = Utf8 de/esolutions/fw/util/serializer/exception/SerializerException 
.const [188] = Utf8 getMessage 
.const [189] = Utf8 ()Ljava/lang/String; 
.const [190] = Utf8 de/esolutions/fw/comm/core/ServiceInstanceID 
.const [191] = Utf8 <init> 
.const [192] = Utf8 (Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V 
.const [193] = Utf8 de/esolutions/fw/comm/core/AbstractReplyService 
.const [194] = Utf8 <init> 
.const [195] = Utf8 (Lde/esolutions/fw/comm/core/ServiceInstanceID;)V 
.const [196] = Utf8 de/esolutions/fw/comm/dsi/calendar/impl/DSICalendarReplyService 
.const [197] = Utf8 dynamicHandle 
.const [198] = Utf8 I 
.const [199] = Utf8 de/esolutions/fw/comm/dsi/calendar/impl/DSICalendarReplyService 
.const [200] = Utf8 context 
.const [201] = Utf8 Lde/esolutions/fw/comm/core/CallContext; 
.const [202] = Utf8 java/lang/StringBuffer 
.const [203] = Utf8 <init> 
.const [204] = Utf8 ()V 
.const [205] = Utf8 de/esolutions/fw/comm/core/method/MethodException 
.const [206] = Utf8 <init> 
.const [207] = Utf8 (Ljava/lang/String;)V 
.const [208] = Utf8 de/esolutions/fw/comm/dsi/calendar/impl/DSICalendarReplyService 
.const [209] = Utf8 p_DSICalendarReply 
.const [210] = Utf8 Lde/esolutions/fw/comm/dsi/calendar/DSICalendarReply; 
.const [211] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [212] = Utf8 getInt32 
.const [213] = Utf8 ()I 
.const [214] = Utf8 de/esolutions/fw/comm/dsi/calendar/DSICalendarReply 
.const [215] = Utf8 getCalendarSummariesResult 
.const [216] = Utf8 (I[Lorg/dsi/ifc/calendar/CalendarSummary;)V 
.const [217] = Utf8 de/esolutions/fw/comm/dsi/calendar/DSICalendarReply 
.const [218] = Utf8 getCalendarEntryResult 
.const [219] = Utf8 (ILorg/dsi/ifc/calendar/CalendarEntry;)V 
.const [220] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [221] = Utf8 getInt64 
.const [222] = Utf8 ()J 
.const [223] = Utf8 de/esolutions/fw/comm/dsi/calendar/DSICalendarReply 
.const [224] = Utf8 indicateAlarm 
.const [225] = Utf8 (J)V 
.const [226] = Utf8 de/esolutions/fw/comm/dsi/calendar/DSICalendarReply 
.const [227] = Utf8 setCalendarConfigResult 
.const [228] = Utf8 (I)V 
.const [229] = Utf8 de/esolutions/fw/comm/dsi/calendar/DSICalendarReply 
.const [230] = Utf8 getCalendarConfigResult 
.const [231] = Utf8 (ILorg/dsi/ifc/calendar/CalendarConfig;)V 
.const [232] = Utf8 de/esolutions/fw/comm/dsi/calendar/DSICalendarReply 
.const [233] = Utf8 setAlarmRepeatResult 
.const [234] = Utf8 (I)V 
.const [235] = Utf8 de/esolutions/fw/comm/dsi/calendar/DSICalendarReply 
.const [236] = Utf8 getAlarmRepeatResult 
.const [237] = Utf8 (IJ)V 
.const [238] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [239] = Utf8 getOptionalStringVarArray 
.const [240] = Utf8 ()[Ljava/lang/String; 
.const [241] = Utf8 de/esolutions/fw/comm/dsi/calendar/DSICalendarReply 
.const [242] = Utf8 getEmailAddressesResult 
.const [243] = Utf8 (I[Ljava/lang/String;)V 
.const [244] = Utf8 de/esolutions/fw/comm/dsi/calendar/DSICalendarReply 
.const [245] = Utf8 getTelephoneNumbersResult 
.const [246] = Utf8 (I[Ljava/lang/String;)V 
.const [247] = Utf8 de/esolutions/fw/comm/dsi/calendar/DSICalendarReply 
.const [248] = Utf8 insertProfileResult 
.const [249] = Utf8 (I)V 
.const [250] = Utf8 de/esolutions/fw/comm/dsi/calendar/DSICalendarReply 
.const [251] = Utf8 deleteProfileResult 
.const [252] = Utf8 (I)V 
.const [253] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [254] = Utf8 getOptionalString 
.const [255] = Utf8 ()Ljava/lang/String; 
.const [256] = Utf8 de/esolutions/fw/comm/dsi/calendar/DSICalendarReply 
.const [257] = Utf8 asyncException 
.const [258] = Utf8 (ILjava/lang/String;I)V 
.const [259] = Utf8 de/esolutions/fw/comm/dsi/calendar/DSICalendarReply 
.const [260] = Utf8 yyIndication 
.const [261] = Utf8 (Ljava/lang/String;Ljava/lang/String;)V 
.const [262] = Utf8 de/esolutions/fw/comm/dsi/calendar/impl/DSICalendarReplyService 
.const [263] = Class [262] 
.const [264] = Utf8 de/esolutions/fw/comm/core/AbstractReplyService 
.const [265] = Class [264] 
.const [266] = Utf8 context 
.const [267] = Utf8 Lde/esolutions/fw/comm/core/CallContext; 
.const [268] = Utf8 dynamicHandle 
.const [269] = Utf8 I 
.const [270] = Utf8 p_DSICalendarReply 
.const [271] = Utf8 Lde/esolutions/fw/comm/dsi/calendar/DSICalendarReply; 
.const [272] = Utf8 Code 
.const [273] = Utf8 <init> 
.const [274] = Utf8 (Lde/esolutions/fw/comm/dsi/calendar/DSICalendarReply;)V 
.const [275] = Utf8 nextDynamicHandle 
.const [276] = Utf8 ()I 
.const [277] = Utf8 getCallContext 
.const [278] = Utf8 ()Lde/esolutions/fw/comm/core/CallContext; 
.const [279] = Utf8 handleCallMethod 
.const [280] = Utf8 (SLde/esolutions/fw/util/serializer/IDeserializer;Lde/esolutions/fw/comm/core/IProxyFrontend;)V 
.const [281] = Utf8 <clinit> 
.const [282] = Utf8 ()V 
.end class 
