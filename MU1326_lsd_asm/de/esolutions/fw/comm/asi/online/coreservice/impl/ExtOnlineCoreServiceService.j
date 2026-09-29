.version 50 0 
.class public super [235] 
.super [237] 
.field private static final [238] [239] 
.field private [240] [241] 

.method public [243] : [244] 
    .attribute [242] .code stack 7 locals 0 
L0:     aload_0 
L1:     new [36] 
L4:     dup 
L5:     ldc [3] 
L7:     iload_1 
L8:     ldc [4] 
L10:    ldc [5] 
L12:    invokespecial [30] 
L15:    invokespecial [31] 
L18:    aload_0 
L19:    aload_2 
L20:    putfield [37] 
L23:    return 
L24:    
    .end code 
.end method 

.method public [245] : [246] 
    .attribute [242] .code stack 2 locals 0 
L0:     new [38] 
L3:     dup 
L4:     invokespecial [32] 
L7:     areturn 
L8:     
    .end code 
.end method 

.method public [247] : [248] 
    .attribute [242] .code stack 1 locals 0 
L0:     getstatic [7] 
L3:     areturn 
L4:     
    .end code 
.end method 

.method public [249] : [250] 
    .attribute [242] .code stack 7 locals 5 
        .catch [13] from L0 to L465 using L468 
L0:     iload_1 
L1:     tableswitch 4 
            L124 
            L438 
            L438 
            L438 
            L438 
            L438 
            L352 
            L438 
            L438 
            L438 
            L300 
            L412 
            L438 
            L438 
            L438 
            L438 
            L232 
            L438 
            L316 
            L438 
            L150 
            L438 
            L284 
            L438 
            L258 
            L438 
            L186 
            default : L438 

L124:   aload_2 
L125:   invokeinterface [39] 0 
L130:   astore 4 
L132:   aload_0 
L133:   getfield [25] 
L136:   aload 4 
L138:   aload_3 
L139:   checkcast [6] 
L142:   invokeinterface [40] 0 
L147:   goto L465 
L150:   aload_2 
L151:   invokeinterface [39] 0 
L156:   astore 4 
L158:   aload_2 
L159:   invokeinterface [39] 0 
L164:   astore 5 
L166:   aload_0 
L167:   getfield [25] 
L170:   aload 4 
L172:   aload 5 
L174:   aload_3 
L175:   checkcast [6] 
L178:   invokeinterface [41] 0 
L183:   goto L465 
L186:   aload_2 
L187:   invokeinterface [39] 0 
L192:   astore 4 
L194:   aload_2 
L195:   invokeinterface [39] 0 
L200:   astore 5 
L202:   aload_2 
L203:   invokeinterface [42] 0 
L208:   istore 6 
L210:   aload_0 
L211:   getfield [25] 
L214:   aload 4 
L216:   aload 5 
L218:   iload 6 
L220:   aload_3 
L221:   checkcast [6] 
L224:   invokeinterface [43] 0 
L229:   goto L465 
L232:   aload_2 
L233:   invokeinterface [39] 0 
L238:   astore 4 
L240:   aload_0 
L241:   getfield [25] 
L244:   aload 4 
L246:   aload_3 
L247:   checkcast [6] 
L250:   invokeinterface [44] 0 
L255:   goto L465 
L258:   aload_2 
L259:   invokeinterface [39] 0 
L264:   astore 4 
L266:   aload_0 
L267:   getfield [25] 
L270:   aload 4 
L272:   aload_3 
L273:   checkcast [6] 
L276:   invokeinterface [45] 0 
L281:   goto L465 
L284:   aload_0 
L285:   getfield [25] 
L288:   aload_3 
L289:   checkcast [6] 
L292:   invokeinterface [46] 0 
L297:   goto L465 
L300:   aload_0 
L301:   getfield [25] 
L304:   aload_3 
L305:   checkcast [6] 
L308:   invokeinterface [47] 0 
L313:   goto L465 
L316:   aload_2 
L317:   invokeinterface [39] 0 
L322:   astore 4 
L324:   aload_2 
L325:   invokeinterface [42] 0 
L330:   istore 5 
L332:   aload_0 
L333:   getfield [25] 
L336:   aload 4 
L338:   iload 5 
L340:   aload_3 
L341:   checkcast [6] 
L344:   invokeinterface [48] 0 
L349:   goto L465 
L352:   aload_2 
L353:   invokestatic [8] 
L356:   astore 4 
L358:   aload_2 
L359:   invokeinterface [49] 0 
L364:   istore 5 
L366:   aload_2 
L367:   invokestatic [9] 
L370:   astore 6 
L372:   aload_2 
L373:   invokestatic [9] 
L376:   astore 7 
L378:   aload_2 
L379:   invokeinterface [50] 0 
L384:   astore 8 
L386:   aload_0 
L387:   getfield [25] 
L390:   aload 4 
L392:   iload 5 
L394:   aload 6 
L396:   aload 7 
L398:   aload 8 
L400:   aload_3 
L401:   checkcast [6] 
L404:   invokeinterface [51] 0 
L409:   goto L465 
L412:   aload_2 
L413:   invokeinterface [52] 0 
L418:   astore 4 
L420:   aload_0 
L421:   getfield [25] 
L424:   aload 4 
L426:   aload_3 
L427:   checkcast [6] 
L430:   invokeinterface [53] 0 
L435:   goto L465 
L438:   new [54] 
L441:   dup 
L442:   new [55] 
L445:   dup 
L446:   invokespecial [34] 
L449:   ldc [12] 
L451:   invokevirtual [26] 
L454:   iload_1 
L455:   invokevirtual [27] 
L458:   invokevirtual [28] 
L461:   invokespecial [35] 
L464:   athrow 
L465:   goto L510 
L468:   astore 4 
L470:   new [54] 
L473:   dup 
L474:   new [55] 
L477:   dup 
L478:   invokespecial [34] 
L481:   ldc [14] 
L483:   invokevirtual [26] 
L486:   iload_1 
L487:   invokevirtual [27] 
L490:   ldc [15] 
L492:   invokevirtual [26] 
L495:   aload 4 
L497:   invokevirtual [29] 
L500:   invokevirtual [26] 
L503:   invokevirtual [28] 
L506:   invokespecial [35] 
L509:   athrow 
L510:   return 
L511:   nop 
L512:   
    .end code 
.end method 

.method static [251] : [252] 
    .attribute [242] .code stack 1 locals 0 
L0:     ldc [16] 
L2:     invokestatic [17] 
L5:     putstatic [33] 
L8:     return 
L9:     nop 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [56] 
.const [3] = String [57] 
.const [4] = String [58] 
.const [5] = String [59] 
.const [6] = Class [60] 
.const [7] = Field [61] [62] 
.const [8] = Method [63] [64] 
.const [9] = Method [65] [66] 
.const [10] = Class [67] 
.const [11] = Class [68] 
.const [12] = String [69] 
.const [13] = Class [70] 
.const [14] = String [71] 
.const [15] = String [72] 
.const [16] = String [73] 
.const [17] = Method [74] [75] 
.const [18] = Class [76] 
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
.const [32] = Method [97] [98] 
.const [33] = Field [99] [100] 
.const [34] = Method [101] [102] 
.const [35] = Method [103] [104] 
.const [36] = Class [105] 
.const [37] = Field [106] [107] 
.const [38] = Class [108] 
.const [39] = InterfaceMethod [109] [110] 
.const [40] = InterfaceMethod [111] [112] 
.const [41] = InterfaceMethod [113] [114] 
.const [42] = InterfaceMethod [115] [116] 
.const [43] = InterfaceMethod [117] [118] 
.const [44] = InterfaceMethod [119] [120] 
.const [45] = InterfaceMethod [121] [122] 
.const [46] = InterfaceMethod [123] [124] 
.const [47] = InterfaceMethod [125] [126] 
.const [48] = InterfaceMethod [127] [128] 
.const [49] = InterfaceMethod [129] [130] 
.const [50] = InterfaceMethod [131] [132] 
.const [51] = InterfaceMethod [133] [134] 
.const [52] = InterfaceMethod [135] [136] 
.const [53] = InterfaceMethod [137] [138] 
.const [54] = Class [139] 
.const [55] = Class [140] 
.const [56] = Utf8 de/esolutions/fw/comm/core/ServiceInstanceID 
.const [57] = Utf8 '4e35da00-907d-11e2-9e96-0800200c9a66' 
.const [58] = Utf8 '81036f67-c3c8-5bbe-adb0-befcec466919' 
.const [59] = Utf8 'asi.online.coreservice.ExtOnlineCoreService' 
.const [60] = Utf8 de/esolutions/fw/comm/asi/online/coreservice/impl/ExtOnlineCoreServiceReplyProxy 
.const [61] = Class [141] 
.const [62] = NameAndType [142] [143] 
.const [63] = Class [144] 
.const [64] = NameAndType [145] [146] 
.const [65] = Class [147] 
.const [66] = NameAndType [148] [149] 
.const [67] = Utf8 de/esolutions/fw/comm/core/method/MethodException 
.const [68] = Utf8 java/lang/StringBuffer 
.const [69] = Utf8 'Invalid Method Id ' 
.const [70] = Utf8 de/esolutions/fw/util/serializer/exception/SerializerException 
.const [71] = Utf8 'Deserialization failed: method=' 
.const [72] = Utf8 ', error=' 
.const [73] = Utf8 'STUB.asi.online.coreservice.ExtOnlineCoreService' 
.const [74] = Class [150] 
.const [75] = NameAndType [151] [152] 
.const [76] = Utf8 de/esolutions/fw/comm/asi/online/coreservice/impl/ExtOnlineCoreServiceService 
.const [77] = Utf8 de/esolutions/fw/comm/core/AbstractService 
.const [78] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [79] = Utf8 de/esolutions/fw/comm/asi/online/coreservice/ExtOnlineCoreServiceS 
.const [80] = Utf8 de/esolutions/fw/comm/asi/online/coreservice/impl/RequestDescriptorSerializer 
.const [81] = Utf8 de/esolutions/fw/comm/asi/online/coreservice/impl/KeyValPairSerializer 
.const [82] = Utf8 de/esolutions/fw/comm/core/CallContext 
.const [83] = Class [153] 
.const [84] = NameAndType [154] [155] 
.const [85] = Class [156] 
.const [86] = NameAndType [157] [158] 
.const [87] = Class [159] 
.const [88] = NameAndType [160] [161] 
.const [89] = Class [162] 
.const [90] = NameAndType [163] [164] 
.const [91] = Class [165] 
.const [92] = NameAndType [166] [167] 
.const [93] = Class [168] 
.const [94] = NameAndType [169] [170] 
.const [95] = Class [171] 
.const [96] = NameAndType [172] [173] 
.const [97] = Class [174] 
.const [98] = NameAndType [175] [176] 
.const [99] = Class [177] 
.const [100] = NameAndType [178] [179] 
.const [101] = Class [180] 
.const [102] = NameAndType [181] [182] 
.const [103] = Class [183] 
.const [104] = NameAndType [184] [185] 
.const [105] = Utf8 de/esolutions/fw/comm/core/ServiceInstanceID 
.const [106] = Class [186] 
.const [107] = NameAndType [187] [188] 
.const [108] = Utf8 de/esolutions/fw/comm/asi/online/coreservice/impl/ExtOnlineCoreServiceReplyProxy 
.const [109] = Class [189] 
.const [110] = NameAndType [190] [191] 
.const [111] = Class [192] 
.const [112] = NameAndType [193] [194] 
.const [113] = Class [195] 
.const [114] = NameAndType [196] [197] 
.const [115] = Class [198] 
.const [116] = NameAndType [199] [200] 
.const [117] = Class [201] 
.const [118] = NameAndType [202] [203] 
.const [119] = Class [204] 
.const [120] = NameAndType [205] [206] 
.const [121] = Class [207] 
.const [122] = NameAndType [208] [209] 
.const [123] = Class [210] 
.const [124] = NameAndType [211] [212] 
.const [125] = Class [213] 
.const [126] = NameAndType [214] [215] 
.const [127] = Class [216] 
.const [128] = NameAndType [217] [218] 
.const [129] = Class [219] 
.const [130] = NameAndType [220] [221] 
.const [131] = Class [222] 
.const [132] = NameAndType [223] [224] 
.const [133] = Class [225] 
.const [134] = NameAndType [226] [227] 
.const [135] = Class [228] 
.const [136] = NameAndType [229] [230] 
.const [137] = Class [231] 
.const [138] = NameAndType [232] [233] 
.const [139] = Utf8 de/esolutions/fw/comm/core/method/MethodException 
.const [140] = Utf8 java/lang/StringBuffer 
.const [141] = Utf8 de/esolutions/fw/comm/asi/online/coreservice/impl/ExtOnlineCoreServiceService 
.const [142] = Utf8 context 
.const [143] = Utf8 Lde/esolutions/fw/comm/core/CallContext; 
.const [144] = Utf8 de/esolutions/fw/comm/asi/online/coreservice/impl/RequestDescriptorSerializer 
.const [145] = Utf8 getOptionalRequestDescriptor 
.const [146] = Utf8 (Lde/esolutions/fw/util/serializer/IDeserializer;)Lde/esolutions/fw/comm/asi/online/coreservice/RequestDescriptor; 
.const [147] = Utf8 de/esolutions/fw/comm/asi/online/coreservice/impl/KeyValPairSerializer 
.const [148] = Utf8 getOptionalKeyValPairVarArray 
.const [149] = Utf8 (Lde/esolutions/fw/util/serializer/IDeserializer;)[Lde/esolutions/fw/comm/asi/online/coreservice/KeyValPair; 
.const [150] = Utf8 de/esolutions/fw/comm/core/CallContext 
.const [151] = Utf8 getContext 
.const [152] = Utf8 (Ljava/lang/String;)Lde/esolutions/fw/comm/core/CallContext; 
.const [153] = Utf8 de/esolutions/fw/comm/asi/online/coreservice/impl/ExtOnlineCoreServiceService 
.const [154] = Utf8 p_ExtOnlineCoreService 
.const [155] = Utf8 Lde/esolutions/fw/comm/asi/online/coreservice/ExtOnlineCoreServiceS; 
.const [156] = Utf8 java/lang/StringBuffer 
.const [157] = Utf8 append 
.const [158] = Utf8 (Ljava/lang/String;)Ljava/lang/StringBuffer; 
.const [159] = Utf8 java/lang/StringBuffer 
.const [160] = Utf8 append 
.const [161] = Utf8 (I)Ljava/lang/StringBuffer; 
.const [162] = Utf8 java/lang/StringBuffer 
.const [163] = Utf8 toString 
.const [164] = Utf8 ()Ljava/lang/String; 
.const [165] = Utf8 de/esolutions/fw/util/serializer/exception/SerializerException 
.const [166] = Utf8 getMessage 
.const [167] = Utf8 ()Ljava/lang/String; 
.const [168] = Utf8 de/esolutions/fw/comm/core/ServiceInstanceID 
.const [169] = Utf8 <init> 
.const [170] = Utf8 (Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V 
.const [171] = Utf8 de/esolutions/fw/comm/core/AbstractService 
.const [172] = Utf8 <init> 
.const [173] = Utf8 (Lde/esolutions/fw/comm/core/ServiceInstanceID;)V 
.const [174] = Utf8 de/esolutions/fw/comm/asi/online/coreservice/impl/ExtOnlineCoreServiceReplyProxy 
.const [175] = Utf8 <init> 
.const [176] = Utf8 ()V 
.const [177] = Utf8 de/esolutions/fw/comm/asi/online/coreservice/impl/ExtOnlineCoreServiceService 
.const [178] = Utf8 context 
.const [179] = Utf8 Lde/esolutions/fw/comm/core/CallContext; 
.const [180] = Utf8 java/lang/StringBuffer 
.const [181] = Utf8 <init> 
.const [182] = Utf8 ()V 
.const [183] = Utf8 de/esolutions/fw/comm/core/method/MethodException 
.const [184] = Utf8 <init> 
.const [185] = Utf8 (Ljava/lang/String;)V 
.const [186] = Utf8 de/esolutions/fw/comm/asi/online/coreservice/impl/ExtOnlineCoreServiceService 
.const [187] = Utf8 p_ExtOnlineCoreService 
.const [188] = Utf8 Lde/esolutions/fw/comm/asi/online/coreservice/ExtOnlineCoreServiceS; 
.const [189] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [190] = Utf8 getOptionalString 
.const [191] = Utf8 ()Ljava/lang/String; 
.const [192] = Utf8 de/esolutions/fw/comm/asi/online/coreservice/ExtOnlineCoreServiceS 
.const [193] = Utf8 init 
.const [194] = Utf8 (Ljava/lang/String;Lde/esolutions/fw/comm/asi/online/coreservice/ExtOnlineCoreServiceReply;)V 
.const [195] = Utf8 de/esolutions/fw/comm/asi/online/coreservice/ExtOnlineCoreServiceS 
.const [196] = Utf8 init 
.const [197] = Utf8 (Ljava/lang/String;Ljava/lang/String;Lde/esolutions/fw/comm/asi/online/coreservice/ExtOnlineCoreServiceReply;)V 
.const [198] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [199] = Utf8 getBool 
.const [200] = Utf8 ()Z 
.const [201] = Utf8 de/esolutions/fw/comm/asi/online/coreservice/ExtOnlineCoreServiceS 
.const [202] = Utf8 registerService 
.const [203] = Utf8 (Ljava/lang/String;Ljava/lang/String;ZLde/esolutions/fw/comm/asi/online/coreservice/ExtOnlineCoreServiceReply;)V 
.const [204] = Utf8 de/esolutions/fw/comm/asi/online/coreservice/ExtOnlineCoreServiceS 
.const [205] = Utf8 getServiceListEntry 
.const [206] = Utf8 (Ljava/lang/String;Lde/esolutions/fw/comm/asi/online/coreservice/ExtOnlineCoreServiceReply;)V 
.const [207] = Utf8 de/esolutions/fw/comm/asi/online/coreservice/ExtOnlineCoreServiceS 
.const [208] = Utf8 precheckOnlineServiceServiceID 
.const [209] = Utf8 (Ljava/lang/String;Lde/esolutions/fw/comm/asi/online/coreservice/ExtOnlineCoreServiceReply;)V 
.const [210] = Utf8 de/esolutions/fw/comm/asi/online/coreservice/ExtOnlineCoreServiceS 
.const [211] = Utf8 precheckOnlineService 
.const [212] = Utf8 (Lde/esolutions/fw/comm/asi/online/coreservice/ExtOnlineCoreServiceReply;)V 
.const [213] = Utf8 de/esolutions/fw/comm/asi/online/coreservice/ExtOnlineCoreServiceS 
.const [214] = Utf8 requestUpdateKeyStore 
.const [215] = Utf8 (Lde/esolutions/fw/comm/asi/online/coreservice/ExtOnlineCoreServiceReply;)V 
.const [216] = Utf8 de/esolutions/fw/comm/asi/online/coreservice/ExtOnlineCoreServiceS 
.const [217] = Utf8 getToken 
.const [218] = Utf8 (Ljava/lang/String;ZLde/esolutions/fw/comm/asi/online/coreservice/ExtOnlineCoreServiceReply;)V 
.const [219] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [220] = Utf8 getInt32 
.const [221] = Utf8 ()I 
.const [222] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [223] = Utf8 getOptionalInt8VarArray 
.const [224] = Utf8 ()[B 
.const [225] = Utf8 de/esolutions/fw/comm/asi/online/coreservice/ExtOnlineCoreServiceS 
.const [226] = Utf8 onlineRequest 
.const [227] = Utf8 (Lde/esolutions/fw/comm/asi/online/coreservice/RequestDescriptor;I[Lde/esolutions/fw/comm/asi/online/coreservice/KeyValPair;[Lde/esolutions/fw/comm/asi/online/coreservice/KeyValPair;[BLde/esolutions/fw/comm/asi/online/coreservice/ExtOnlineCoreServiceReply;)V 
.const [228] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [229] = Utf8 getOptionalEnumVarArray 
.const [230] = Utf8 ()[I 
.const [231] = Utf8 de/esolutions/fw/comm/asi/online/coreservice/ExtOnlineCoreServiceS 
.const [232] = Utf8 registerForCredentialUpdates 
.const [233] = Utf8 ([ILde/esolutions/fw/comm/asi/online/coreservice/ExtOnlineCoreServiceReply;)V 
.const [234] = Utf8 de/esolutions/fw/comm/asi/online/coreservice/impl/ExtOnlineCoreServiceService 
.const [235] = Class [234] 
.const [236] = Utf8 de/esolutions/fw/comm/core/AbstractService 
.const [237] = Class [236] 
.const [238] = Utf8 context 
.const [239] = Utf8 Lde/esolutions/fw/comm/core/CallContext; 
.const [240] = Utf8 p_ExtOnlineCoreService 
.const [241] = Utf8 Lde/esolutions/fw/comm/asi/online/coreservice/ExtOnlineCoreServiceS; 
.const [242] = Utf8 Code 
.const [243] = Utf8 <init> 
.const [244] = Utf8 (ILde/esolutions/fw/comm/asi/online/coreservice/ExtOnlineCoreServiceS;)V 
.const [245] = Utf8 createReplyProxy 
.const [246] = Utf8 ()Lde/esolutions/fw/comm/core/IProxyFrontend; 
.const [247] = Utf8 getCallContext 
.const [248] = Utf8 ()Lde/esolutions/fw/comm/core/CallContext; 
.const [249] = Utf8 handleCallMethod 
.const [250] = Utf8 (SLde/esolutions/fw/util/serializer/IDeserializer;Lde/esolutions/fw/comm/core/IProxyFrontend;)V 
.const [251] = Utf8 <clinit> 
.const [252] = Utf8 ()V 
.end class 
