.version 50 0 
.class public super [231] 
.super [233] 
.field private static final [234] [235] 
.field private [236] [237] 

.method public [239] : [240] 
    .attribute [238] .code stack 7 locals 0 
L0:     aload_0 
L1:     new [32] 
L4:     dup 
L5:     ldc [3] 
L7:     iload_1 
L8:     ldc [4] 
L10:    ldc [5] 
L12:    invokespecial [26] 
L15:    invokespecial [27] 
L18:    aload_0 
L19:    aload_2 
L20:    putfield [33] 
L23:    return 
L24:    
    .end code 
.end method 

.method public [241] : [242] 
    .attribute [238] .code stack 2 locals 0 
L0:     new [34] 
L3:     dup 
L4:     invokespecial [28] 
L7:     areturn 
L8:     
    .end code 
.end method 

.method public [243] : [244] 
    .attribute [238] .code stack 1 locals 0 
L0:     getstatic [7] 
L3:     areturn 
L4:     
    .end code 
.end method 

.method public [245] : [246] 
    .attribute [238] .code stack 4 locals 2 
        .catch [11] from L0 to L443 using L446 
L0:     iload_1 
L1:     tableswitch 0 
            L348 
            L390 
            L364 
            L254 
            L186 
            L416 
            L228 
            L416 
            L108 
            L280 
            L322 
            L296 
            L202 
            L416 
            L416 
            L416 
            L416 
            L416 
            L416 
            L416 
            L416 
            L134 
            L160 
            default : L416 

L108:   aload_2 
L109:   invokeinterface [35] 0 
L114:   istore 4 
L116:   aload_0 
L117:   getfield [21] 
L120:   iload 4 
L122:   aload_3 
L123:   checkcast [6] 
L126:   invokeinterface [36] 0 
L131:   goto L443 
L134:   aload_2 
L135:   invokeinterface [35] 0 
L140:   istore 4 
L142:   aload_0 
L143:   getfield [21] 
L146:   iload 4 
L148:   aload_3 
L149:   checkcast [6] 
L152:   invokeinterface [37] 0 
L157:   goto L443 
L160:   aload_2 
L161:   invokeinterface [38] 0 
L166:   astore 4 
L168:   aload_0 
L169:   getfield [21] 
L172:   aload 4 
L174:   aload_3 
L175:   checkcast [6] 
L178:   invokeinterface [39] 0 
L183:   goto L443 
L186:   aload_0 
L187:   getfield [21] 
L190:   aload_3 
L191:   checkcast [6] 
L194:   invokeinterface [40] 0 
L199:   goto L443 
L202:   aload_2 
L203:   invokeinterface [35] 0 
L208:   istore 4 
L210:   aload_0 
L211:   getfield [21] 
L214:   iload 4 
L216:   aload_3 
L217:   checkcast [6] 
L220:   invokeinterface [41] 0 
L225:   goto L443 
L228:   aload_2 
L229:   invokeinterface [35] 0 
L234:   istore 4 
L236:   aload_0 
L237:   getfield [21] 
L240:   iload 4 
L242:   aload_3 
L243:   checkcast [6] 
L246:   invokeinterface [42] 0 
L251:   goto L443 
L254:   aload_2 
L255:   invokeinterface [35] 0 
L260:   istore 4 
L262:   aload_0 
L263:   getfield [21] 
L266:   iload 4 
L268:   aload_3 
L269:   checkcast [6] 
L272:   invokeinterface [43] 0 
L277:   goto L443 
L280:   aload_0 
L281:   getfield [21] 
L284:   aload_3 
L285:   checkcast [6] 
L288:   invokeinterface [44] 0 
L293:   goto L443 
L296:   aload_2 
L297:   invokeinterface [45] 0 
L302:   lstore 4 
L304:   aload_0 
L305:   getfield [21] 
L308:   lload 4 
L310:   aload_3 
L311:   checkcast [6] 
L314:   invokeinterface [46] 0 
L319:   goto L443 
L322:   aload_2 
L323:   invokeinterface [47] 0 
L328:   astore 4 
L330:   aload_0 
L331:   getfield [21] 
L334:   aload 4 
L336:   aload_3 
L337:   checkcast [6] 
L340:   invokeinterface [48] 0 
L345:   goto L443 
L348:   aload_0 
L349:   getfield [21] 
L352:   aload_3 
L353:   checkcast [6] 
L356:   invokeinterface [49] 0 
L361:   goto L443 
L364:   aload_2 
L365:   invokeinterface [45] 0 
L370:   lstore 4 
L372:   aload_0 
L373:   getfield [21] 
L376:   lload 4 
L378:   aload_3 
L379:   checkcast [6] 
L382:   invokeinterface [50] 0 
L387:   goto L443 
L390:   aload_2 
L391:   invokeinterface [47] 0 
L396:   astore 4 
L398:   aload_0 
L399:   getfield [21] 
L402:   aload 4 
L404:   aload_3 
L405:   checkcast [6] 
L408:   invokeinterface [51] 0 
L413:   goto L443 
L416:   new [52] 
L419:   dup 
L420:   new [53] 
L423:   dup 
L424:   invokespecial [30] 
L427:   ldc [10] 
L429:   invokevirtual [22] 
L432:   iload_1 
L433:   invokevirtual [23] 
L436:   invokevirtual [24] 
L439:   invokespecial [31] 
L442:   athrow 
L443:   goto L488 
L446:   astore 4 
L448:   new [52] 
L451:   dup 
L452:   new [53] 
L455:   dup 
L456:   invokespecial [30] 
L459:   ldc [12] 
L461:   invokevirtual [22] 
L464:   iload_1 
L465:   invokevirtual [23] 
L468:   ldc [13] 
L470:   invokevirtual [22] 
L473:   aload 4 
L475:   invokevirtual [25] 
L478:   invokevirtual [22] 
L481:   invokevirtual [24] 
L484:   invokespecial [31] 
L487:   athrow 
L488:   return 
L489:   nop 
L490:   nop 
L491:   nop 
L492:   
    .end code 
.end method 

.method static [247] : [248] 
    .attribute [238] .code stack 1 locals 0 
L0:     ldc [14] 
L2:     invokestatic [15] 
L5:     putstatic [29] 
L8:     return 
L9:     nop 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [54] 
.const [3] = String [55] 
.const [4] = String [56] 
.const [5] = String [57] 
.const [6] = Class [58] 
.const [7] = Field [59] [60] 
.const [8] = Class [61] 
.const [9] = Class [62] 
.const [10] = String [63] 
.const [11] = Class [64] 
.const [12] = String [65] 
.const [13] = String [66] 
.const [14] = String [67] 
.const [15] = Method [68] [69] 
.const [16] = Class [70] 
.const [17] = Class [71] 
.const [18] = Class [72] 
.const [19] = Class [73] 
.const [20] = Class [74] 
.const [21] = Field [75] [76] 
.const [22] = Method [77] [78] 
.const [23] = Method [79] [80] 
.const [24] = Method [81] [82] 
.const [25] = Method [83] [84] 
.const [26] = Method [85] [86] 
.const [27] = Method [87] [88] 
.const [28] = Method [89] [90] 
.const [29] = Field [91] [92] 
.const [30] = Method [93] [94] 
.const [31] = Method [95] [96] 
.const [32] = Class [97] 
.const [33] = Field [98] [99] 
.const [34] = Class [100] 
.const [35] = InterfaceMethod [101] [102] 
.const [36] = InterfaceMethod [103] [104] 
.const [37] = InterfaceMethod [105] [106] 
.const [38] = InterfaceMethod [107] [108] 
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
.const [52] = Class [135] 
.const [53] = Class [136] 
.const [54] = Utf8 de/esolutions/fw/comm/core/ServiceInstanceID 
.const [55] = Utf8 '0f18f39e-8ba2-4652-9298-39ffbea5b9fe' 
.const [56] = Utf8 f10bdb8c-3351-5035-a073-26fb210dd987 
.const [57] = Utf8 'asi.hmisync.audio.ASIHMISyncAudio' 
.const [58] = Utf8 de/esolutions/fw/comm/asi/hmisync/audio/impl/ASIHMISyncAudioReplyProxy 
.const [59] = Class [137] 
.const [60] = NameAndType [138] [139] 
.const [61] = Utf8 de/esolutions/fw/comm/core/method/MethodException 
.const [62] = Utf8 java/lang/StringBuffer 
.const [63] = Utf8 'Invalid Method Id ' 
.const [64] = Utf8 de/esolutions/fw/util/serializer/exception/SerializerException 
.const [65] = Utf8 'Deserialization failed: method=' 
.const [66] = Utf8 ', error=' 
.const [67] = Utf8 'STUB.asi.hmisync.audio.ASIHMISyncAudio' 
.const [68] = Class [140] 
.const [69] = NameAndType [141] [142] 
.const [70] = Utf8 de/esolutions/fw/comm/asi/hmisync/audio/impl/ASIHMISyncAudioService 
.const [71] = Utf8 de/esolutions/fw/comm/core/AbstractService 
.const [72] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [73] = Utf8 de/esolutions/fw/comm/asi/hmisync/audio/ASIHMISyncAudioS 
.const [74] = Utf8 de/esolutions/fw/comm/core/CallContext 
.const [75] = Class [143] 
.const [76] = NameAndType [144] [145] 
.const [77] = Class [146] 
.const [78] = NameAndType [147] [148] 
.const [79] = Class [149] 
.const [80] = NameAndType [150] [151] 
.const [81] = Class [152] 
.const [82] = NameAndType [153] [154] 
.const [83] = Class [155] 
.const [84] = NameAndType [156] [157] 
.const [85] = Class [158] 
.const [86] = NameAndType [159] [160] 
.const [87] = Class [161] 
.const [88] = NameAndType [162] [163] 
.const [89] = Class [164] 
.const [90] = NameAndType [165] [166] 
.const [91] = Class [167] 
.const [92] = NameAndType [168] [169] 
.const [93] = Class [170] 
.const [94] = NameAndType [171] [172] 
.const [95] = Class [173] 
.const [96] = NameAndType [174] [175] 
.const [97] = Utf8 de/esolutions/fw/comm/core/ServiceInstanceID 
.const [98] = Class [176] 
.const [99] = NameAndType [177] [178] 
.const [100] = Utf8 de/esolutions/fw/comm/asi/hmisync/audio/impl/ASIHMISyncAudioReplyProxy 
.const [101] = Class [179] 
.const [102] = NameAndType [180] [181] 
.const [103] = Class [182] 
.const [104] = NameAndType [183] [184] 
.const [105] = Class [185] 
.const [106] = NameAndType [186] [187] 
.const [107] = Class [188] 
.const [108] = NameAndType [189] [190] 
.const [109] = Class [191] 
.const [110] = NameAndType [192] [193] 
.const [111] = Class [194] 
.const [112] = NameAndType [195] [196] 
.const [113] = Class [197] 
.const [114] = NameAndType [198] [199] 
.const [115] = Class [200] 
.const [116] = NameAndType [201] [202] 
.const [117] = Class [203] 
.const [118] = NameAndType [204] [205] 
.const [119] = Class [206] 
.const [120] = NameAndType [207] [208] 
.const [121] = Class [209] 
.const [122] = NameAndType [210] [211] 
.const [123] = Class [212] 
.const [124] = NameAndType [213] [214] 
.const [125] = Class [215] 
.const [126] = NameAndType [216] [217] 
.const [127] = Class [218] 
.const [128] = NameAndType [219] [220] 
.const [129] = Class [221] 
.const [130] = NameAndType [222] [223] 
.const [131] = Class [224] 
.const [132] = NameAndType [225] [226] 
.const [133] = Class [227] 
.const [134] = NameAndType [228] [229] 
.const [135] = Utf8 de/esolutions/fw/comm/core/method/MethodException 
.const [136] = Utf8 java/lang/StringBuffer 
.const [137] = Utf8 de/esolutions/fw/comm/asi/hmisync/audio/impl/ASIHMISyncAudioService 
.const [138] = Utf8 context 
.const [139] = Utf8 Lde/esolutions/fw/comm/core/CallContext; 
.const [140] = Utf8 de/esolutions/fw/comm/core/CallContext 
.const [141] = Utf8 getContext 
.const [142] = Utf8 (Ljava/lang/String;)Lde/esolutions/fw/comm/core/CallContext; 
.const [143] = Utf8 de/esolutions/fw/comm/asi/hmisync/audio/impl/ASIHMISyncAudioService 
.const [144] = Utf8 p_ASIHMISyncAudio 
.const [145] = Utf8 Lde/esolutions/fw/comm/asi/hmisync/audio/ASIHMISyncAudioS; 
.const [146] = Utf8 java/lang/StringBuffer 
.const [147] = Utf8 append 
.const [148] = Utf8 (Ljava/lang/String;)Ljava/lang/StringBuffer; 
.const [149] = Utf8 java/lang/StringBuffer 
.const [150] = Utf8 append 
.const [151] = Utf8 (I)Ljava/lang/StringBuffer; 
.const [152] = Utf8 java/lang/StringBuffer 
.const [153] = Utf8 toString 
.const [154] = Utf8 ()Ljava/lang/String; 
.const [155] = Utf8 de/esolutions/fw/util/serializer/exception/SerializerException 
.const [156] = Utf8 getMessage 
.const [157] = Utf8 ()Ljava/lang/String; 
.const [158] = Utf8 de/esolutions/fw/comm/core/ServiceInstanceID 
.const [159] = Utf8 <init> 
.const [160] = Utf8 (Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V 
.const [161] = Utf8 de/esolutions/fw/comm/core/AbstractService 
.const [162] = Utf8 <init> 
.const [163] = Utf8 (Lde/esolutions/fw/comm/core/ServiceInstanceID;)V 
.const [164] = Utf8 de/esolutions/fw/comm/asi/hmisync/audio/impl/ASIHMISyncAudioReplyProxy 
.const [165] = Utf8 <init> 
.const [166] = Utf8 ()V 
.const [167] = Utf8 de/esolutions/fw/comm/asi/hmisync/audio/impl/ASIHMISyncAudioService 
.const [168] = Utf8 context 
.const [169] = Utf8 Lde/esolutions/fw/comm/core/CallContext; 
.const [170] = Utf8 java/lang/StringBuffer 
.const [171] = Utf8 <init> 
.const [172] = Utf8 ()V 
.const [173] = Utf8 de/esolutions/fw/comm/core/method/MethodException 
.const [174] = Utf8 <init> 
.const [175] = Utf8 (Ljava/lang/String;)V 
.const [176] = Utf8 de/esolutions/fw/comm/asi/hmisync/audio/impl/ASIHMISyncAudioService 
.const [177] = Utf8 p_ASIHMISyncAudio 
.const [178] = Utf8 Lde/esolutions/fw/comm/asi/hmisync/audio/ASIHMISyncAudioS; 
.const [179] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [180] = Utf8 getInt32 
.const [181] = Utf8 ()I 
.const [182] = Utf8 de/esolutions/fw/comm/asi/hmisync/audio/ASIHMISyncAudioS 
.const [183] = Utf8 setAudioContext 
.const [184] = Utf8 (ILde/esolutions/fw/comm/asi/hmisync/audio/ASIHMISyncAudioReply;)V 
.const [185] = Utf8 de/esolutions/fw/comm/asi/hmisync/audio/ASIHMISyncAudioS 
.const [186] = Utf8 forceFrontAudioContext 
.const [187] = Utf8 (ILde/esolutions/fw/comm/asi/hmisync/audio/ASIHMISyncAudioReply;)V 
.const [188] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [189] = Utf8 getOptionalString 
.const [190] = Utf8 ()Ljava/lang/String; 
.const [191] = Utf8 de/esolutions/fw/comm/asi/hmisync/audio/ASIHMISyncAudioS 
.const [192] = Utf8 requestEnableA2LS 
.const [193] = Utf8 (Ljava/lang/String;Lde/esolutions/fw/comm/asi/hmisync/audio/ASIHMISyncAudioReply;)V 
.const [194] = Utf8 de/esolutions/fw/comm/asi/hmisync/audio/ASIHMISyncAudioS 
.const [195] = Utf8 disableA2LS 
.const [196] = Utf8 (Lde/esolutions/fw/comm/asi/hmisync/audio/ASIHMISyncAudioReply;)V 
.const [197] = Utf8 de/esolutions/fw/comm/asi/hmisync/audio/ASIHMISyncAudioS 
.const [198] = Utf8 setVolume 
.const [199] = Utf8 (ILde/esolutions/fw/comm/asi/hmisync/audio/ASIHMISyncAudioReply;)V 
.const [200] = Utf8 de/esolutions/fw/comm/asi/hmisync/audio/ASIHMISyncAudioS 
.const [201] = Utf8 increaseVolume 
.const [202] = Utf8 (ILde/esolutions/fw/comm/asi/hmisync/audio/ASIHMISyncAudioReply;)V 
.const [203] = Utf8 de/esolutions/fw/comm/asi/hmisync/audio/ASIHMISyncAudioS 
.const [204] = Utf8 decreaseVolume 
.const [205] = Utf8 (ILde/esolutions/fw/comm/asi/hmisync/audio/ASIHMISyncAudioReply;)V 
.const [206] = Utf8 de/esolutions/fw/comm/asi/hmisync/audio/ASIHMISyncAudioS 
.const [207] = Utf8 setNotification 
.const [208] = Utf8 (Lde/esolutions/fw/comm/asi/hmisync/audio/ASIHMISyncAudioReply;)V 
.const [209] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [210] = Utf8 getUInt32 
.const [211] = Utf8 ()J 
.const [212] = Utf8 de/esolutions/fw/comm/asi/hmisync/audio/ASIHMISyncAudioS 
.const [213] = Utf8 setNotification 
.const [214] = Utf8 (JLde/esolutions/fw/comm/asi/hmisync/audio/ASIHMISyncAudioReply;)V 
.const [215] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [216] = Utf8 getOptionalUInt32VarArray 
.const [217] = Utf8 ()[J 
.const [218] = Utf8 de/esolutions/fw/comm/asi/hmisync/audio/ASIHMISyncAudioS 
.const [219] = Utf8 setNotification 
.const [220] = Utf8 ([JLde/esolutions/fw/comm/asi/hmisync/audio/ASIHMISyncAudioReply;)V 
.const [221] = Utf8 de/esolutions/fw/comm/asi/hmisync/audio/ASIHMISyncAudioS 
.const [222] = Utf8 clearNotification 
.const [223] = Utf8 (Lde/esolutions/fw/comm/asi/hmisync/audio/ASIHMISyncAudioReply;)V 
.const [224] = Utf8 de/esolutions/fw/comm/asi/hmisync/audio/ASIHMISyncAudioS 
.const [225] = Utf8 clearNotification 
.const [226] = Utf8 (JLde/esolutions/fw/comm/asi/hmisync/audio/ASIHMISyncAudioReply;)V 
.const [227] = Utf8 de/esolutions/fw/comm/asi/hmisync/audio/ASIHMISyncAudioS 
.const [228] = Utf8 clearNotification 
.const [229] = Utf8 ([JLde/esolutions/fw/comm/asi/hmisync/audio/ASIHMISyncAudioReply;)V 
.const [230] = Utf8 de/esolutions/fw/comm/asi/hmisync/audio/impl/ASIHMISyncAudioService 
.const [231] = Class [230] 
.const [232] = Utf8 de/esolutions/fw/comm/core/AbstractService 
.const [233] = Class [232] 
.const [234] = Utf8 context 
.const [235] = Utf8 Lde/esolutions/fw/comm/core/CallContext; 
.const [236] = Utf8 p_ASIHMISyncAudio 
.const [237] = Utf8 Lde/esolutions/fw/comm/asi/hmisync/audio/ASIHMISyncAudioS; 
.const [238] = Utf8 Code 
.const [239] = Utf8 <init> 
.const [240] = Utf8 (ILde/esolutions/fw/comm/asi/hmisync/audio/ASIHMISyncAudioS;)V 
.const [241] = Utf8 createReplyProxy 
.const [242] = Utf8 ()Lde/esolutions/fw/comm/core/IProxyFrontend; 
.const [243] = Utf8 getCallContext 
.const [244] = Utf8 ()Lde/esolutions/fw/comm/core/CallContext; 
.const [245] = Utf8 handleCallMethod 
.const [246] = Utf8 (SLde/esolutions/fw/util/serializer/IDeserializer;Lde/esolutions/fw/comm/core/IProxyFrontend;)V 
.const [247] = Utf8 <clinit> 
.const [248] = Utf8 ()V 
.end class 
