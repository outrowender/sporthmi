.version 50 0 
.class public super [235] 
.super [237] 
.field private static final [238] [239] 
.field private static [240] [241] 
.field private [242] [243] 

.method public [245] : [246] 
    .attribute [244] .code stack 7 locals 0 
L0:     aload_0 
L1:     new [36] 
L4:     dup 
L5:     ldc [3] 
L7:     invokestatic [4] 
L10:    ldc [5] 
L12:    ldc [6] 
L14:    invokespecial [30] 
L17:    invokespecial [31] 
L20:    aload_0 
L21:    aload_1 
L22:    putfield [37] 
L25:    return 
L26:    nop 
L27:    nop 
L28:    
    .end code 
.end method 

.method private static synchronized [247] : [248] 
    .attribute [244] .code stack 2 locals 1 
L0:     getstatic [7] 
L3:     iconst_1 
L4:     iadd 
L5:     dup 
L6:     putstatic [32] 
L9:     istore_0 
L10:    iload_0 
L11:    areturn 
L12:    
    .end code 
.end method 

.method public [249] : [250] 
    .attribute [244] .code stack 1 locals 0 
L0:     getstatic [8] 
L3:     areturn 
L4:     
    .end code 
.end method 

.method public [251] : [252] 
    .attribute [244] .code stack 6 locals 5 
        .catch [14] from L0 to L511 using L514 
L0:     iload_1 
L1:     tableswitch 2 
            L262 
            L484 
            L220 
            L484 
            L484 
            L484 
            L484 
            L484 
            L484 
            L484 
            L304 
            L484 
            L452 
            L484 
            L420 
            L358 
            L484 
            L484 
            L484 
            L484 
            L326 
            L484 
            L484 
            L484 
            L170 
            L120 
            default : L484 

L120:   aload_2 
L121:   invokeinterface [38] 0 
L126:   istore 4 
L128:   aload_2 
L129:   invokestatic [9] 
L132:   astore 5 
L134:   aload_2 
L135:   invokeinterface [39] 0 
L140:   istore 6 
L142:   aload_2 
L143:   invokeinterface [39] 0 
L148:   istore 7 
L150:   aload_0 
L151:   getfield [25] 
L154:   iload 4 
L156:   aload 5 
L158:   iload 6 
L160:   iload 7 
L162:   invokeinterface [40] 0 
L167:   goto L511 
L170:   aload_2 
L171:   invokeinterface [38] 0 
L176:   istore 4 
L178:   aload_2 
L179:   invokestatic [10] 
L182:   astore 5 
L184:   aload_2 
L185:   invokeinterface [39] 0 
L190:   istore 6 
L192:   aload_2 
L193:   invokeinterface [39] 0 
L198:   istore 7 
L200:   aload_0 
L201:   getfield [25] 
L204:   iload 4 
L206:   aload 5 
L208:   iload 6 
L210:   iload 7 
L212:   invokeinterface [41] 0 
L217:   goto L511 
L220:   aload_2 
L221:   invokeinterface [38] 0 
L226:   istore 4 
L228:   aload_2 
L229:   invokeinterface [42] 0 
L234:   astore 5 
L236:   aload_2 
L237:   invokeinterface [39] 0 
L242:   istore 6 
L244:   aload_0 
L245:   getfield [25] 
L248:   iload 4 
L250:   aload 5 
L252:   iload 6 
L254:   invokeinterface [43] 0 
L259:   goto L511 
L262:   aload_2 
L263:   invokeinterface [38] 0 
L268:   istore 4 
L270:   aload_2 
L271:   invokeinterface [42] 0 
L276:   astore 5 
L278:   aload_2 
L279:   invokeinterface [39] 0 
L284:   istore 6 
L286:   aload_0 
L287:   getfield [25] 
L290:   iload 4 
L292:   aload 5 
L294:   iload 6 
L296:   invokeinterface [44] 0 
L301:   goto L511 
L304:   aload_2 
L305:   invokeinterface [39] 0 
L310:   istore 4 
L312:   aload_0 
L313:   getfield [25] 
L316:   iload 4 
L318:   invokeinterface [45] 0 
L323:   goto L511 
L326:   aload_2 
L327:   invokeinterface [39] 0 
L332:   istore 4 
L334:   aload_2 
L335:   invokeinterface [39] 0 
L340:   istore 5 
L342:   aload_0 
L343:   getfield [25] 
L346:   iload 4 
L348:   iload 5 
L350:   invokeinterface [46] 0 
L355:   goto L511 
L358:   aload_2 
L359:   invokeinterface [38] 0 
L364:   istore 4 
L366:   aload_2 
L367:   invokeinterface [47] 0 
L372:   astore 5 
L374:   aload_2 
L375:   invokeinterface [39] 0 
L380:   istore 6 
L382:   aload_2 
L383:   invokeinterface [42] 0 
L388:   astore 7 
L390:   aload_2 
L391:   invokeinterface [39] 0 
L396:   istore 8 
L398:   aload_0 
L399:   getfield [25] 
L402:   iload 4 
L404:   aload 5 
L406:   iload 6 
L408:   aload 7 
L410:   iload 8 
L412:   invokeinterface [48] 0 
L417:   goto L511 
L420:   aload_2 
L421:   invokeinterface [38] 0 
L426:   istore 4 
L428:   aload_2 
L429:   invokeinterface [42] 0 
L434:   astore 5 
L436:   aload_0 
L437:   getfield [25] 
L440:   iload 4 
L442:   aload 5 
L444:   invokeinterface [49] 0 
L449:   goto L511 
L452:   aload_2 
L453:   invokeinterface [38] 0 
L458:   istore 4 
L460:   aload_2 
L461:   invokeinterface [50] 0 
L466:   lstore 5 
L468:   aload_0 
L469:   getfield [25] 
L472:   iload 4 
L474:   lload 5 
L476:   invokeinterface [51] 0 
L481:   goto L511 
L484:   new [52] 
L487:   dup 
L488:   new [53] 
L491:   dup 
L492:   invokespecial [34] 
L495:   ldc [13] 
L497:   invokevirtual [26] 
L500:   iload_1 
L501:   invokevirtual [27] 
L504:   invokevirtual [28] 
L507:   invokespecial [35] 
L510:   athrow 
L511:   goto L556 
L514:   astore 4 
L516:   new [52] 
L519:   dup 
L520:   new [53] 
L523:   dup 
L524:   invokespecial [34] 
L527:   ldc [15] 
L529:   invokevirtual [26] 
L532:   iload_1 
L533:   invokevirtual [27] 
L536:   ldc [16] 
L538:   invokevirtual [26] 
L541:   aload 4 
L543:   invokevirtual [29] 
L546:   invokevirtual [26] 
L549:   invokevirtual [28] 
L552:   invokespecial [35] 
L555:   athrow 
L556:   return 
L557:   nop 
L558:   nop 
L559:   nop 
L560:   
    .end code 
.end method 

.method static [253] : [254] 
    .attribute [244] .code stack 1 locals 0 
L0:     ldc [17] 
L2:     invokestatic [18] 
L5:     putstatic [33] 
L8:     iconst_0 
L9:     putstatic [32] 
L12:    return 
L13:    nop 
L14:    nop 
L15:    nop 
L16:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [54] 
.const [3] = String [55] 
.const [4] = Method [56] [57] 
.const [5] = String [58] 
.const [6] = String [59] 
.const [7] = Field [60] [61] 
.const [8] = Field [62] [63] 
.const [9] = Method [64] [65] 
.const [10] = Method [66] [67] 
.const [11] = Class [68] 
.const [12] = Class [69] 
.const [13] = String [70] 
.const [14] = Class [71] 
.const [15] = String [72] 
.const [16] = String [73] 
.const [17] = String [74] 
.const [18] = Method [75] [76] 
.const [19] = Class [77] 
.const [20] = Class [78] 
.const [21] = Class [79] 
.const [22] = Class [80] 
.const [23] = Class [81] 
.const [24] = Class [82] 
.const [25] = Field [83] [84] 
.const [26] = Method [85] [86] 
.const [27] = Method [87] [88] 
.const [28] = Method [89] [90] 
.const [29] = Method [91] [92] 
.const [30] = Method [93] [94] 
.const [31] = Method [95] [96] 
.const [32] = Field [97] [98] 
.const [33] = Field [99] [100] 
.const [34] = Method [101] [102] 
.const [35] = Method [103] [104] 
.const [36] = Class [105] 
.const [37] = Field [106] [107] 
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
.const [51] = InterfaceMethod [134] [135] 
.const [52] = Class [136] 
.const [53] = Class [137] 
.const [54] = Utf8 de/esolutions/fw/comm/core/ServiceInstanceID 
.const [55] = Utf8 c4084aff-df82-4408-b56c-2aef1da8ec7e 
.const [56] = Class [138] 
.const [57] = NameAndType [139] [140] 
.const [58] = Utf8 '167912de-3ac1-5a6e-8756-89022777b8bc' 
.const [59] = Utf8 'asi.organizer.vcardexchange.VCardParser' 
.const [60] = Class [141] 
.const [61] = NameAndType [142] [143] 
.const [62] = Class [144] 
.const [63] = NameAndType [145] [146] 
.const [64] = Class [147] 
.const [65] = NameAndType [148] [149] 
.const [66] = Class [150] 
.const [67] = NameAndType [151] [152] 
.const [68] = Utf8 de/esolutions/fw/comm/core/method/MethodException 
.const [69] = Utf8 java/lang/StringBuffer 
.const [70] = Utf8 'Invalid Method Id ' 
.const [71] = Utf8 de/esolutions/fw/util/serializer/exception/SerializerException 
.const [72] = Utf8 'Deserialization failed: method=' 
.const [73] = Utf8 ', error=' 
.const [74] = Utf8 'STUB.asi.organizer.vcardexchange.VCardParser' 
.const [75] = Class [153] 
.const [76] = NameAndType [154] [155] 
.const [77] = Utf8 de/esolutions/fw/comm/asi/organizer/vcardexchange/impl/VCardParserReplyService 
.const [78] = Utf8 de/esolutions/fw/comm/core/AbstractReplyService 
.const [79] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [80] = Utf8 de/esolutions/fw/comm/dsi/organizer/impl/AdbEntrySerializer 
.const [81] = Utf8 de/esolutions/fw/comm/asi/organizer/vcardexchange/VCardParserReply 
.const [82] = Utf8 de/esolutions/fw/comm/core/CallContext 
.const [83] = Class [156] 
.const [84] = NameAndType [157] [158] 
.const [85] = Class [159] 
.const [86] = NameAndType [160] [161] 
.const [87] = Class [162] 
.const [88] = NameAndType [163] [164] 
.const [89] = Class [165] 
.const [90] = NameAndType [166] [167] 
.const [91] = Class [168] 
.const [92] = NameAndType [169] [170] 
.const [93] = Class [171] 
.const [94] = NameAndType [172] [173] 
.const [95] = Class [174] 
.const [96] = NameAndType [175] [176] 
.const [97] = Class [177] 
.const [98] = NameAndType [178] [179] 
.const [99] = Class [180] 
.const [100] = NameAndType [181] [182] 
.const [101] = Class [183] 
.const [102] = NameAndType [184] [185] 
.const [103] = Class [186] 
.const [104] = NameAndType [187] [188] 
.const [105] = Utf8 de/esolutions/fw/comm/core/ServiceInstanceID 
.const [106] = Class [189] 
.const [107] = NameAndType [190] [191] 
.const [108] = Class [192] 
.const [109] = NameAndType [193] [194] 
.const [110] = Class [195] 
.const [111] = NameAndType [196] [197] 
.const [112] = Class [198] 
.const [113] = NameAndType [199] [200] 
.const [114] = Class [201] 
.const [115] = NameAndType [202] [203] 
.const [116] = Class [204] 
.const [117] = NameAndType [205] [206] 
.const [118] = Class [207] 
.const [119] = NameAndType [208] [209] 
.const [120] = Class [210] 
.const [121] = NameAndType [211] [212] 
.const [122] = Class [213] 
.const [123] = NameAndType [214] [215] 
.const [124] = Class [216] 
.const [125] = NameAndType [217] [218] 
.const [126] = Class [219] 
.const [127] = NameAndType [220] [221] 
.const [128] = Class [222] 
.const [129] = NameAndType [223] [224] 
.const [130] = Class [225] 
.const [131] = NameAndType [226] [227] 
.const [132] = Class [228] 
.const [133] = NameAndType [229] [230] 
.const [134] = Class [231] 
.const [135] = NameAndType [232] [233] 
.const [136] = Utf8 de/esolutions/fw/comm/core/method/MethodException 
.const [137] = Utf8 java/lang/StringBuffer 
.const [138] = Utf8 de/esolutions/fw/comm/asi/organizer/vcardexchange/impl/VCardParserReplyService 
.const [139] = Utf8 nextDynamicHandle 
.const [140] = Utf8 ()I 
.const [141] = Utf8 de/esolutions/fw/comm/asi/organizer/vcardexchange/impl/VCardParserReplyService 
.const [142] = Utf8 dynamicHandle 
.const [143] = Utf8 I 
.const [144] = Utf8 de/esolutions/fw/comm/asi/organizer/vcardexchange/impl/VCardParserReplyService 
.const [145] = Utf8 context 
.const [146] = Utf8 Lde/esolutions/fw/comm/core/CallContext; 
.const [147] = Utf8 de/esolutions/fw/comm/dsi/organizer/impl/AdbEntrySerializer 
.const [148] = Utf8 getOptionalAdbEntry 
.const [149] = Utf8 (Lde/esolutions/fw/util/serializer/IDeserializer;)Lorg/dsi/ifc/organizer/AdbEntry; 
.const [150] = Utf8 de/esolutions/fw/comm/dsi/organizer/impl/AdbEntrySerializer 
.const [151] = Utf8 getOptionalAdbEntryVarArray 
.const [152] = Utf8 (Lde/esolutions/fw/util/serializer/IDeserializer;)[Lorg/dsi/ifc/organizer/AdbEntry; 
.const [153] = Utf8 de/esolutions/fw/comm/core/CallContext 
.const [154] = Utf8 getContext 
.const [155] = Utf8 (Ljava/lang/String;)Lde/esolutions/fw/comm/core/CallContext; 
.const [156] = Utf8 de/esolutions/fw/comm/asi/organizer/vcardexchange/impl/VCardParserReplyService 
.const [157] = Utf8 p_VCardParserReply 
.const [158] = Utf8 Lde/esolutions/fw/comm/asi/organizer/vcardexchange/VCardParserReply; 
.const [159] = Utf8 java/lang/StringBuffer 
.const [160] = Utf8 append 
.const [161] = Utf8 (Ljava/lang/String;)Ljava/lang/StringBuffer; 
.const [162] = Utf8 java/lang/StringBuffer 
.const [163] = Utf8 append 
.const [164] = Utf8 (I)Ljava/lang/StringBuffer; 
.const [165] = Utf8 java/lang/StringBuffer 
.const [166] = Utf8 toString 
.const [167] = Utf8 ()Ljava/lang/String; 
.const [168] = Utf8 de/esolutions/fw/util/serializer/exception/SerializerException 
.const [169] = Utf8 getMessage 
.const [170] = Utf8 ()Ljava/lang/String; 
.const [171] = Utf8 de/esolutions/fw/comm/core/ServiceInstanceID 
.const [172] = Utf8 <init> 
.const [173] = Utf8 (Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V 
.const [174] = Utf8 de/esolutions/fw/comm/core/AbstractReplyService 
.const [175] = Utf8 <init> 
.const [176] = Utf8 (Lde/esolutions/fw/comm/core/ServiceInstanceID;)V 
.const [177] = Utf8 de/esolutions/fw/comm/asi/organizer/vcardexchange/impl/VCardParserReplyService 
.const [178] = Utf8 dynamicHandle 
.const [179] = Utf8 I 
.const [180] = Utf8 de/esolutions/fw/comm/asi/organizer/vcardexchange/impl/VCardParserReplyService 
.const [181] = Utf8 context 
.const [182] = Utf8 Lde/esolutions/fw/comm/core/CallContext; 
.const [183] = Utf8 java/lang/StringBuffer 
.const [184] = Utf8 <init> 
.const [185] = Utf8 ()V 
.const [186] = Utf8 de/esolutions/fw/comm/core/method/MethodException 
.const [187] = Utf8 <init> 
.const [188] = Utf8 (Ljava/lang/String;)V 
.const [189] = Utf8 de/esolutions/fw/comm/asi/organizer/vcardexchange/impl/VCardParserReplyService 
.const [190] = Utf8 p_VCardParserReply 
.const [191] = Utf8 Lde/esolutions/fw/comm/asi/organizer/vcardexchange/VCardParserReply; 
.const [192] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [193] = Utf8 getEnum 
.const [194] = Utf8 ()I 
.const [195] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [196] = Utf8 getInt32 
.const [197] = Utf8 ()I 
.const [198] = Utf8 de/esolutions/fw/comm/asi/organizer/vcardexchange/VCardParserReply 
.const [199] = Utf8 parseVCardResult 
.const [200] = Utf8 (ILorg/dsi/ifc/organizer/AdbEntry;II)V 
.const [201] = Utf8 de/esolutions/fw/comm/asi/organizer/vcardexchange/VCardParserReply 
.const [202] = Utf8 parseVCardDirectoryResult 
.const [203] = Utf8 (I[Lorg/dsi/ifc/organizer/AdbEntry;II)V 
.const [204] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [205] = Utf8 getOptionalString 
.const [206] = Utf8 ()Ljava/lang/String; 
.const [207] = Utf8 de/esolutions/fw/comm/asi/organizer/vcardexchange/VCardParserReply 
.const [208] = Utf8 exportVCardResult 
.const [209] = Utf8 (ILjava/lang/String;I)V 
.const [210] = Utf8 de/esolutions/fw/comm/asi/organizer/vcardexchange/VCardParserReply 
.const [211] = Utf8 exportSmallVCardResult 
.const [212] = Utf8 (ILjava/lang/String;I)V 
.const [213] = Utf8 de/esolutions/fw/comm/asi/organizer/vcardexchange/VCardParserReply 
.const [214] = Utf8 parsingFinished 
.const [215] = Utf8 (I)V 
.const [216] = Utf8 de/esolutions/fw/comm/asi/organizer/vcardexchange/VCardParserReply 
.const [217] = Utf8 exportFinished 
.const [218] = Utf8 (II)V 
.const [219] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [220] = Utf8 getOptionalInt64VarArray 
.const [221] = Utf8 ()[J 
.const [222] = Utf8 de/esolutions/fw/comm/asi/organizer/vcardexchange/VCardParserReply 
.const [223] = Utf8 smallExportFinished 
.const [224] = Utf8 (I[JILjava/lang/String;I)V 
.const [225] = Utf8 de/esolutions/fw/comm/asi/organizer/vcardexchange/VCardParserReply 
.const [226] = Utf8 setBinaryContentTempPathResult 
.const [227] = Utf8 (ILjava/lang/String;)V 
.const [228] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [229] = Utf8 getInt64 
.const [230] = Utf8 ()J 
.const [231] = Utf8 de/esolutions/fw/comm/asi/organizer/vcardexchange/VCardParserReply 
.const [232] = Utf8 setBinaryContentQuotaPerFileResult 
.const [233] = Utf8 (IJ)V 
.const [234] = Utf8 de/esolutions/fw/comm/asi/organizer/vcardexchange/impl/VCardParserReplyService 
.const [235] = Class [234] 
.const [236] = Utf8 de/esolutions/fw/comm/core/AbstractReplyService 
.const [237] = Class [236] 
.const [238] = Utf8 context 
.const [239] = Utf8 Lde/esolutions/fw/comm/core/CallContext; 
.const [240] = Utf8 dynamicHandle 
.const [241] = Utf8 I 
.const [242] = Utf8 p_VCardParserReply 
.const [243] = Utf8 Lde/esolutions/fw/comm/asi/organizer/vcardexchange/VCardParserReply; 
.const [244] = Utf8 Code 
.const [245] = Utf8 <init> 
.const [246] = Utf8 (Lde/esolutions/fw/comm/asi/organizer/vcardexchange/VCardParserReply;)V 
.const [247] = Utf8 nextDynamicHandle 
.const [248] = Utf8 ()I 
.const [249] = Utf8 getCallContext 
.const [250] = Utf8 ()Lde/esolutions/fw/comm/core/CallContext; 
.const [251] = Utf8 handleCallMethod 
.const [252] = Utf8 (SLde/esolutions/fw/util/serializer/IDeserializer;Lde/esolutions/fw/comm/core/IProxyFrontend;)V 
.const [253] = Utf8 <clinit> 
.const [254] = Utf8 ()V 
.end class 
