.version 50 0 
.class public super [221] 
.super [223] 
.field private static final [224] [225] 
.field private [226] [227] 

.method public [229] : [230] 
    .attribute [228] .code stack 7 locals 0 
L0:     aload_0 
L1:     new [34] 
L4:     dup 
L5:     ldc [3] 
L7:     iload_1 
L8:     ldc [4] 
L10:    ldc [5] 
L12:    invokespecial [28] 
L15:    invokespecial [29] 
L18:    aload_0 
L19:    aload_2 
L20:    putfield [35] 
L23:    return 
L24:    
    .end code 
.end method 

.method public [231] : [232] 
    .attribute [228] .code stack 2 locals 0 
L0:     new [36] 
L3:     dup 
L4:     invokespecial [30] 
L7:     areturn 
L8:     
    .end code 
.end method 

.method public [233] : [234] 
    .attribute [228] .code stack 1 locals 0 
L0:     getstatic [7] 
L3:     areturn 
L4:     
    .end code 
.end method 

.method public [235] : [236] 
    .attribute [228] .code stack 5 locals 3 
        .catch [12] from L0 to L491 using L494 
L0:     iload_1 
L1:     tableswitch 6 
            L288 
            L350 
            L464 
            L464 
            L464 
            L464 
            L464 
            L412 
            L464 
            L386 
            L464 
            L464 
            L108 
            L154 
            L464 
            L464 
            L464 
            L314 
            L244 
            L200 
            L464 
            L464 
            L438 
            default : L464 

L108:   aload_2 
L109:   invokeinterface [37] 0 
L114:   astore 4 
L116:   aload_2 
L117:   invokeinterface [38] 0 
L122:   istore 5 
L124:   aload_2 
L125:   invokeinterface [38] 0 
L130:   istore 6 
L132:   aload_0 
L133:   getfield [23] 
L136:   aload 4 
L138:   iload 5 
L140:   iload 6 
L142:   aload_3 
L143:   checkcast [6] 
L146:   invokeinterface [39] 0 
L151:   goto L491 
L154:   aload_2 
L155:   invokeinterface [37] 0 
L160:   astore 4 
L162:   aload_2 
L163:   invokeinterface [38] 0 
L168:   istore 5 
L170:   aload_2 
L171:   invokeinterface [38] 0 
L176:   istore 6 
L178:   aload_0 
L179:   getfield [23] 
L182:   aload 4 
L184:   iload 5 
L186:   iload 6 
L188:   aload_3 
L189:   checkcast [6] 
L192:   invokeinterface [40] 0 
L197:   goto L491 
L200:   aload_2 
L201:   invokestatic [8] 
L204:   astore 4 
L206:   aload_2 
L207:   invokeinterface [37] 0 
L212:   astore 5 
L214:   aload_2 
L215:   invokeinterface [38] 0 
L220:   istore 6 
L222:   aload_0 
L223:   getfield [23] 
L226:   aload 4 
L228:   aload 5 
L230:   iload 6 
L232:   aload_3 
L233:   checkcast [6] 
L236:   invokeinterface [41] 0 
L241:   goto L491 
L244:   aload_2 
L245:   invokestatic [8] 
L248:   astore 4 
L250:   aload_2 
L251:   invokeinterface [37] 0 
L256:   astore 5 
L258:   aload_2 
L259:   invokeinterface [38] 0 
L264:   istore 6 
L266:   aload_0 
L267:   getfield [23] 
L270:   aload 4 
L272:   aload 5 
L274:   iload 6 
L276:   aload_3 
L277:   checkcast [6] 
L280:   invokeinterface [42] 0 
L285:   goto L491 
L288:   aload_2 
L289:   invokeinterface [38] 0 
L294:   istore 4 
L296:   aload_0 
L297:   getfield [23] 
L300:   iload 4 
L302:   aload_3 
L303:   checkcast [6] 
L306:   invokeinterface [43] 0 
L311:   goto L491 
L314:   aload_2 
L315:   invokeinterface [38] 0 
L320:   istore 4 
L322:   aload_2 
L323:   invokeinterface [38] 0 
L328:   istore 5 
L330:   aload_0 
L331:   getfield [23] 
L334:   iload 4 
L336:   iload 5 
L338:   aload_3 
L339:   checkcast [6] 
L342:   invokeinterface [44] 0 
L347:   goto L491 
L350:   aload_2 
L351:   invokeinterface [37] 0 
L356:   astore 4 
L358:   aload_2 
L359:   invokeinterface [38] 0 
L364:   istore 5 
L366:   aload_0 
L367:   getfield [23] 
L370:   aload 4 
L372:   iload 5 
L374:   aload_3 
L375:   checkcast [6] 
L378:   invokeinterface [45] 0 
L383:   goto L491 
L386:   aload_2 
L387:   invokeinterface [37] 0 
L392:   astore 4 
L394:   aload_0 
L395:   getfield [23] 
L398:   aload 4 
L400:   aload_3 
L401:   checkcast [6] 
L404:   invokeinterface [46] 0 
L409:   goto L491 
L412:   aload_2 
L413:   invokeinterface [47] 0 
L418:   lstore 4 
L420:   aload_0 
L421:   getfield [23] 
L424:   lload 4 
L426:   aload_3 
L427:   checkcast [6] 
L430:   invokeinterface [48] 0 
L435:   goto L491 
L438:   aload_2 
L439:   invokeinterface [49] 0 
L444:   istore 4 
L446:   aload_0 
L447:   getfield [23] 
L450:   iload 4 
L452:   aload_3 
L453:   checkcast [6] 
L456:   invokeinterface [50] 0 
L461:   goto L491 
L464:   new [51] 
L467:   dup 
L468:   new [52] 
L471:   dup 
L472:   invokespecial [32] 
L475:   ldc [11] 
L477:   invokevirtual [24] 
L480:   iload_1 
L481:   invokevirtual [25] 
L484:   invokevirtual [26] 
L487:   invokespecial [33] 
L490:   athrow 
L491:   goto L536 
L494:   astore 4 
L496:   new [51] 
L499:   dup 
L500:   new [52] 
L503:   dup 
L504:   invokespecial [32] 
L507:   ldc [13] 
L509:   invokevirtual [24] 
L512:   iload_1 
L513:   invokevirtual [25] 
L516:   ldc [14] 
L518:   invokevirtual [24] 
L521:   aload 4 
L523:   invokevirtual [27] 
L526:   invokevirtual [24] 
L529:   invokevirtual [26] 
L532:   invokespecial [33] 
L535:   athrow 
L536:   return 
L537:   nop 
L538:   nop 
L539:   nop 
L540:   
    .end code 
.end method 

.method static [237] : [238] 
    .attribute [228] .code stack 1 locals 0 
L0:     ldc [15] 
L2:     invokestatic [16] 
L5:     putstatic [31] 
L8:     return 
L9:     nop 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [53] 
.const [3] = String [54] 
.const [4] = String [55] 
.const [5] = String [56] 
.const [6] = Class [57] 
.const [7] = Field [58] [59] 
.const [8] = Method [60] [61] 
.const [9] = Class [62] 
.const [10] = Class [63] 
.const [11] = String [64] 
.const [12] = Class [65] 
.const [13] = String [66] 
.const [14] = String [67] 
.const [15] = String [68] 
.const [16] = Method [69] [70] 
.const [17] = Class [71] 
.const [18] = Class [72] 
.const [19] = Class [73] 
.const [20] = Class [74] 
.const [21] = Class [75] 
.const [22] = Class [76] 
.const [23] = Field [77] [78] 
.const [24] = Method [79] [80] 
.const [25] = Method [81] [82] 
.const [26] = Method [83] [84] 
.const [27] = Method [85] [86] 
.const [28] = Method [87] [88] 
.const [29] = Method [89] [90] 
.const [30] = Method [91] [92] 
.const [31] = Field [93] [94] 
.const [32] = Method [95] [96] 
.const [33] = Method [97] [98] 
.const [34] = Class [99] 
.const [35] = Field [100] [101] 
.const [36] = Class [102] 
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
.const [48] = InterfaceMethod [125] [126] 
.const [49] = InterfaceMethod [127] [128] 
.const [50] = InterfaceMethod [129] [130] 
.const [51] = Class [131] 
.const [52] = Class [132] 
.const [53] = Utf8 de/esolutions/fw/comm/core/ServiceInstanceID 
.const [54] = Utf8 ac51e9cb-58ff-4a94-82b2-348bedfdc513 
.const [55] = Utf8 '4d2de5a1-2ec1-5014-915d-ced43ea78aaf' 
.const [56] = Utf8 'asi.organizer.vcardexchange.VCardParser' 
.const [57] = Utf8 de/esolutions/fw/comm/asi/organizer/vcardexchange/impl/VCardParserReplyProxy 
.const [58] = Class [133] 
.const [59] = NameAndType [134] [135] 
.const [60] = Class [136] 
.const [61] = NameAndType [137] [138] 
.const [62] = Utf8 de/esolutions/fw/comm/core/method/MethodException 
.const [63] = Utf8 java/lang/StringBuffer 
.const [64] = Utf8 'Invalid Method Id ' 
.const [65] = Utf8 de/esolutions/fw/util/serializer/exception/SerializerException 
.const [66] = Utf8 'Deserialization failed: method=' 
.const [67] = Utf8 ', error=' 
.const [68] = Utf8 'STUB.asi.organizer.vcardexchange.VCardParser' 
.const [69] = Class [139] 
.const [70] = NameAndType [140] [141] 
.const [71] = Utf8 de/esolutions/fw/comm/asi/organizer/vcardexchange/impl/VCardParserService 
.const [72] = Utf8 de/esolutions/fw/comm/core/AbstractService 
.const [73] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [74] = Utf8 de/esolutions/fw/comm/asi/organizer/vcardexchange/VCardParserS 
.const [75] = Utf8 de/esolutions/fw/comm/dsi/organizer/impl/AdbEntrySerializer 
.const [76] = Utf8 de/esolutions/fw/comm/core/CallContext 
.const [77] = Class [142] 
.const [78] = NameAndType [143] [144] 
.const [79] = Class [145] 
.const [80] = NameAndType [146] [147] 
.const [81] = Class [148] 
.const [82] = NameAndType [149] [150] 
.const [83] = Class [151] 
.const [84] = NameAndType [152] [153] 
.const [85] = Class [154] 
.const [86] = NameAndType [155] [156] 
.const [87] = Class [157] 
.const [88] = NameAndType [158] [159] 
.const [89] = Class [160] 
.const [90] = NameAndType [161] [162] 
.const [91] = Class [163] 
.const [92] = NameAndType [164] [165] 
.const [93] = Class [166] 
.const [94] = NameAndType [167] [168] 
.const [95] = Class [169] 
.const [96] = NameAndType [170] [171] 
.const [97] = Class [172] 
.const [98] = NameAndType [173] [174] 
.const [99] = Utf8 de/esolutions/fw/comm/core/ServiceInstanceID 
.const [100] = Class [175] 
.const [101] = NameAndType [176] [177] 
.const [102] = Utf8 de/esolutions/fw/comm/asi/organizer/vcardexchange/impl/VCardParserReplyProxy 
.const [103] = Class [178] 
.const [104] = NameAndType [179] [180] 
.const [105] = Class [181] 
.const [106] = NameAndType [182] [183] 
.const [107] = Class [184] 
.const [108] = NameAndType [185] [186] 
.const [109] = Class [187] 
.const [110] = NameAndType [188] [189] 
.const [111] = Class [190] 
.const [112] = NameAndType [191] [192] 
.const [113] = Class [193] 
.const [114] = NameAndType [194] [195] 
.const [115] = Class [196] 
.const [116] = NameAndType [197] [198] 
.const [117] = Class [199] 
.const [118] = NameAndType [200] [201] 
.const [119] = Class [202] 
.const [120] = NameAndType [203] [204] 
.const [121] = Class [205] 
.const [122] = NameAndType [206] [207] 
.const [123] = Class [208] 
.const [124] = NameAndType [209] [210] 
.const [125] = Class [211] 
.const [126] = NameAndType [212] [213] 
.const [127] = Class [214] 
.const [128] = NameAndType [215] [216] 
.const [129] = Class [217] 
.const [130] = NameAndType [218] [219] 
.const [131] = Utf8 de/esolutions/fw/comm/core/method/MethodException 
.const [132] = Utf8 java/lang/StringBuffer 
.const [133] = Utf8 de/esolutions/fw/comm/asi/organizer/vcardexchange/impl/VCardParserService 
.const [134] = Utf8 context 
.const [135] = Utf8 Lde/esolutions/fw/comm/core/CallContext; 
.const [136] = Utf8 de/esolutions/fw/comm/dsi/organizer/impl/AdbEntrySerializer 
.const [137] = Utf8 getOptionalAdbEntry 
.const [138] = Utf8 (Lde/esolutions/fw/util/serializer/IDeserializer;)Lorg/dsi/ifc/organizer/AdbEntry; 
.const [139] = Utf8 de/esolutions/fw/comm/core/CallContext 
.const [140] = Utf8 getContext 
.const [141] = Utf8 (Ljava/lang/String;)Lde/esolutions/fw/comm/core/CallContext; 
.const [142] = Utf8 de/esolutions/fw/comm/asi/organizer/vcardexchange/impl/VCardParserService 
.const [143] = Utf8 p_VCardParser 
.const [144] = Utf8 Lde/esolutions/fw/comm/asi/organizer/vcardexchange/VCardParserS; 
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
.const [160] = Utf8 de/esolutions/fw/comm/core/AbstractService 
.const [161] = Utf8 <init> 
.const [162] = Utf8 (Lde/esolutions/fw/comm/core/ServiceInstanceID;)V 
.const [163] = Utf8 de/esolutions/fw/comm/asi/organizer/vcardexchange/impl/VCardParserReplyProxy 
.const [164] = Utf8 <init> 
.const [165] = Utf8 ()V 
.const [166] = Utf8 de/esolutions/fw/comm/asi/organizer/vcardexchange/impl/VCardParserService 
.const [167] = Utf8 context 
.const [168] = Utf8 Lde/esolutions/fw/comm/core/CallContext; 
.const [169] = Utf8 java/lang/StringBuffer 
.const [170] = Utf8 <init> 
.const [171] = Utf8 ()V 
.const [172] = Utf8 de/esolutions/fw/comm/core/method/MethodException 
.const [173] = Utf8 <init> 
.const [174] = Utf8 (Ljava/lang/String;)V 
.const [175] = Utf8 de/esolutions/fw/comm/asi/organizer/vcardexchange/impl/VCardParserService 
.const [176] = Utf8 p_VCardParser 
.const [177] = Utf8 Lde/esolutions/fw/comm/asi/organizer/vcardexchange/VCardParserS; 
.const [178] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [179] = Utf8 getOptionalString 
.const [180] = Utf8 ()Ljava/lang/String; 
.const [181] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [182] = Utf8 getInt32 
.const [183] = Utf8 ()I 
.const [184] = Utf8 de/esolutions/fw/comm/asi/organizer/vcardexchange/VCardParserS 
.const [185] = Utf8 parseVCard 
.const [186] = Utf8 (Ljava/lang/String;IILde/esolutions/fw/comm/asi/organizer/vcardexchange/VCardParserReply;)V 
.const [187] = Utf8 de/esolutions/fw/comm/asi/organizer/vcardexchange/VCardParserS 
.const [188] = Utf8 parseVCardDirectory 
.const [189] = Utf8 (Ljava/lang/String;IILde/esolutions/fw/comm/asi/organizer/vcardexchange/VCardParserReply;)V 
.const [190] = Utf8 de/esolutions/fw/comm/asi/organizer/vcardexchange/VCardParserS 
.const [191] = Utf8 exportVCard 
.const [192] = Utf8 (Lorg/dsi/ifc/organizer/AdbEntry;Ljava/lang/String;ILde/esolutions/fw/comm/asi/organizer/vcardexchange/VCardParserReply;)V 
.const [193] = Utf8 de/esolutions/fw/comm/asi/organizer/vcardexchange/VCardParserS 
.const [194] = Utf8 exportSmallVCard 
.const [195] = Utf8 (Lorg/dsi/ifc/organizer/AdbEntry;Ljava/lang/String;ILde/esolutions/fw/comm/asi/organizer/vcardexchange/VCardParserReply;)V 
.const [196] = Utf8 de/esolutions/fw/comm/asi/organizer/vcardexchange/VCardParserS 
.const [197] = Utf8 finishParsing 
.const [198] = Utf8 (ILde/esolutions/fw/comm/asi/organizer/vcardexchange/VCardParserReply;)V 
.const [199] = Utf8 de/esolutions/fw/comm/asi/organizer/vcardexchange/VCardParserS 
.const [200] = Utf8 finishExport 
.const [201] = Utf8 (IILde/esolutions/fw/comm/asi/organizer/vcardexchange/VCardParserReply;)V 
.const [202] = Utf8 de/esolutions/fw/comm/asi/organizer/vcardexchange/VCardParserS 
.const [203] = Utf8 finishSmallExport 
.const [204] = Utf8 (Ljava/lang/String;ILde/esolutions/fw/comm/asi/organizer/vcardexchange/VCardParserReply;)V 
.const [205] = Utf8 de/esolutions/fw/comm/asi/organizer/vcardexchange/VCardParserS 
.const [206] = Utf8 setBinaryContentTempPath 
.const [207] = Utf8 (Ljava/lang/String;Lde/esolutions/fw/comm/asi/organizer/vcardexchange/VCardParserReply;)V 
.const [208] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [209] = Utf8 getInt64 
.const [210] = Utf8 ()J 
.const [211] = Utf8 de/esolutions/fw/comm/asi/organizer/vcardexchange/VCardParserS 
.const [212] = Utf8 setBinaryContentQuotaPerFile 
.const [213] = Utf8 (JLde/esolutions/fw/comm/asi/organizer/vcardexchange/VCardParserReply;)V 
.const [214] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [215] = Utf8 getBool 
.const [216] = Utf8 ()Z 
.const [217] = Utf8 de/esolutions/fw/comm/asi/organizer/vcardexchange/VCardParserS 
.const [218] = Utf8 setExtendedAddressHandling 
.const [219] = Utf8 (ZLde/esolutions/fw/comm/asi/organizer/vcardexchange/VCardParserReply;)V 
.const [220] = Utf8 de/esolutions/fw/comm/asi/organizer/vcardexchange/impl/VCardParserService 
.const [221] = Class [220] 
.const [222] = Utf8 de/esolutions/fw/comm/core/AbstractService 
.const [223] = Class [222] 
.const [224] = Utf8 context 
.const [225] = Utf8 Lde/esolutions/fw/comm/core/CallContext; 
.const [226] = Utf8 p_VCardParser 
.const [227] = Utf8 Lde/esolutions/fw/comm/asi/organizer/vcardexchange/VCardParserS; 
.const [228] = Utf8 Code 
.const [229] = Utf8 <init> 
.const [230] = Utf8 (ILde/esolutions/fw/comm/asi/organizer/vcardexchange/VCardParserS;)V 
.const [231] = Utf8 createReplyProxy 
.const [232] = Utf8 ()Lde/esolutions/fw/comm/core/IProxyFrontend; 
.const [233] = Utf8 getCallContext 
.const [234] = Utf8 ()Lde/esolutions/fw/comm/core/CallContext; 
.const [235] = Utf8 handleCallMethod 
.const [236] = Utf8 (SLde/esolutions/fw/util/serializer/IDeserializer;Lde/esolutions/fw/comm/core/IProxyFrontend;)V 
.const [237] = Utf8 <clinit> 
.const [238] = Utf8 ()V 
.end class 
