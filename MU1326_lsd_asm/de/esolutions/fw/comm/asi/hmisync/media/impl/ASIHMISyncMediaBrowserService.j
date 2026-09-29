.version 50 0 
.class public super [247] 
.super [249] 
.field private static final [250] [251] 
.field private [252] [253] 

.method public [255] : [256] 
    .attribute [254] .code stack 7 locals 0 
L0:     aload_0 
L1:     new [37] 
L4:     dup 
L5:     ldc [3] 
L7:     iload_1 
L8:     ldc [4] 
L10:    ldc [5] 
L12:    invokespecial [31] 
L15:    invokespecial [32] 
L18:    aload_0 
L19:    aload_2 
L20:    putfield [38] 
L23:    return 
L24:    
    .end code 
.end method 

.method public [257] : [258] 
    .attribute [254] .code stack 2 locals 0 
L0:     new [39] 
L3:     dup 
L4:     invokespecial [33] 
L7:     areturn 
L8:     
    .end code 
.end method 

.method public [259] : [260] 
    .attribute [254] .code stack 1 locals 0 
L0:     getstatic [7] 
L3:     areturn 
L4:     
    .end code 
.end method 

.method public [261] : [262] 
    .attribute [254] .code stack 7 locals 5 
        .catch [14] from L0 to L419 using L422 
L0:     iload_1 
L1:     tableswitch 0 
            L76 
            L166 
            L142 
            L324 
            L366 
            L340 
            L100 
            L200 
            L392 
            L392 
            L392 
            L116 
            L256 
            L298 
            L272 
            default : L392 

L76:    aload_2 
L77:    invokestatic [8] 
L80:    astore 4 
L82:    aload_0 
L83:    getfield [26] 
L86:    aload 4 
L88:    aload_3 
L89:    checkcast [6] 
L92:    invokeinterface [40] 0 
L97:    goto L419 
L100:   aload_0 
L101:   getfield [26] 
L104:   aload_3 
L105:   checkcast [6] 
L108:   invokeinterface [41] 0 
L113:   goto L419 
L116:   aload_2 
L117:   invokeinterface [42] 0 
L122:   istore 4 
L124:   aload_0 
L125:   getfield [26] 
L128:   iload 4 
L130:   aload_3 
L131:   checkcast [6] 
L134:   invokeinterface [43] 0 
L139:   goto L419 
L142:   aload_2 
L143:   invokestatic [9] 
L146:   astore 4 
L148:   aload_0 
L149:   getfield [26] 
L152:   aload 4 
L154:   aload_3 
L155:   checkcast [6] 
L158:   invokeinterface [44] 0 
L163:   goto L419 
L166:   aload_2 
L167:   invokeinterface [42] 0 
L172:   istore 4 
L174:   aload_2 
L175:   invokestatic [10] 
L178:   astore 5 
L180:   aload_0 
L181:   getfield [26] 
L184:   iload 4 
L186:   aload 5 
L188:   aload_3 
L189:   checkcast [6] 
L192:   invokeinterface [45] 0 
L197:   goto L419 
L200:   aload_2 
L201:   invokeinterface [42] 0 
L206:   istore 4 
L208:   aload_2 
L209:   invokeinterface [46] 0 
L214:   lstore 5 
L216:   aload_2 
L217:   invokeinterface [42] 0 
L222:   istore 7 
L224:   aload_2 
L225:   invokeinterface [42] 0 
L230:   istore 8 
L232:   aload_0 
L233:   getfield [26] 
L236:   iload 4 
L238:   lload 5 
L240:   iload 7 
L242:   iload 8 
L244:   aload_3 
L245:   checkcast [6] 
L248:   invokeinterface [47] 0 
L253:   goto L419 
L256:   aload_0 
L257:   getfield [26] 
L260:   aload_3 
L261:   checkcast [6] 
L264:   invokeinterface [48] 0 
L269:   goto L419 
L272:   aload_2 
L273:   invokeinterface [49] 0 
L278:   lstore 4 
L280:   aload_0 
L281:   getfield [26] 
L284:   lload 4 
L286:   aload_3 
L287:   checkcast [6] 
L290:   invokeinterface [50] 0 
L295:   goto L419 
L298:   aload_2 
L299:   invokeinterface [51] 0 
L304:   astore 4 
L306:   aload_0 
L307:   getfield [26] 
L310:   aload 4 
L312:   aload_3 
L313:   checkcast [6] 
L316:   invokeinterface [52] 0 
L321:   goto L419 
L324:   aload_0 
L325:   getfield [26] 
L328:   aload_3 
L329:   checkcast [6] 
L332:   invokeinterface [53] 0 
L337:   goto L419 
L340:   aload_2 
L341:   invokeinterface [49] 0 
L346:   lstore 4 
L348:   aload_0 
L349:   getfield [26] 
L352:   lload 4 
L354:   aload_3 
L355:   checkcast [6] 
L358:   invokeinterface [54] 0 
L363:   goto L419 
L366:   aload_2 
L367:   invokeinterface [51] 0 
L372:   astore 4 
L374:   aload_0 
L375:   getfield [26] 
L378:   aload 4 
L380:   aload_3 
L381:   checkcast [6] 
L384:   invokeinterface [55] 0 
L389:   goto L419 
L392:   new [56] 
L395:   dup 
L396:   new [57] 
L399:   dup 
L400:   invokespecial [35] 
L403:   ldc [13] 
L405:   invokevirtual [27] 
L408:   iload_1 
L409:   invokevirtual [28] 
L412:   invokevirtual [29] 
L415:   invokespecial [36] 
L418:   athrow 
L419:   goto L464 
L422:   astore 4 
L424:   new [56] 
L427:   dup 
L428:   new [57] 
L431:   dup 
L432:   invokespecial [35] 
L435:   ldc [15] 
L437:   invokevirtual [27] 
L440:   iload_1 
L441:   invokevirtual [28] 
L444:   ldc [16] 
L446:   invokevirtual [27] 
L449:   aload 4 
L451:   invokevirtual [30] 
L454:   invokevirtual [27] 
L457:   invokevirtual [29] 
L460:   invokespecial [36] 
L463:   athrow 
L464:   return 
L465:   nop 
L466:   nop 
L467:   nop 
L468:   
    .end code 
.end method 

.method static [263] : [264] 
    .attribute [254] .code stack 1 locals 0 
L0:     ldc [17] 
L2:     invokestatic [18] 
L5:     putstatic [34] 
L8:     return 
L9:     nop 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [58] 
.const [3] = String [59] 
.const [4] = String [60] 
.const [5] = String [61] 
.const [6] = Class [62] 
.const [7] = Field [63] [64] 
.const [8] = Method [65] [66] 
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
.const [33] = Method [101] [102] 
.const [34] = Field [103] [104] 
.const [35] = Method [105] [106] 
.const [36] = Method [107] [108] 
.const [37] = Class [109] 
.const [38] = Field [110] [111] 
.const [39] = Class [112] 
.const [40] = InterfaceMethod [113] [114] 
.const [41] = InterfaceMethod [115] [116] 
.const [42] = InterfaceMethod [117] [118] 
.const [43] = InterfaceMethod [119] [120] 
.const [44] = InterfaceMethod [121] [122] 
.const [45] = InterfaceMethod [123] [124] 
.const [46] = InterfaceMethod [125] [126] 
.const [47] = InterfaceMethod [127] [128] 
.const [48] = InterfaceMethod [129] [130] 
.const [49] = InterfaceMethod [131] [132] 
.const [50] = InterfaceMethod [133] [134] 
.const [51] = InterfaceMethod [135] [136] 
.const [52] = InterfaceMethod [137] [138] 
.const [53] = InterfaceMethod [139] [140] 
.const [54] = InterfaceMethod [141] [142] 
.const [55] = InterfaceMethod [143] [144] 
.const [56] = Class [145] 
.const [57] = Class [146] 
.const [58] = Utf8 de/esolutions/fw/comm/core/ServiceInstanceID 
.const [59] = Utf8 '04780aa8-9662-4220-9900-4a1e11586d28' 
.const [60] = Utf8 '8f2aa3cc-0c22-5ffa-83d3-4e78162cf3e6' 
.const [61] = Utf8 'asi.hmisync.media.ASIHMISyncMediaBrowser' 
.const [62] = Utf8 de/esolutions/fw/comm/asi/hmisync/media/impl/ASIHMISyncMediaBrowserReplyProxy 
.const [63] = Class [147] 
.const [64] = NameAndType [148] [149] 
.const [65] = Class [150] 
.const [66] = NameAndType [151] [152] 
.const [67] = Class [153] 
.const [68] = NameAndType [154] [155] 
.const [69] = Class [156] 
.const [70] = NameAndType [157] [158] 
.const [71] = Utf8 de/esolutions/fw/comm/core/method/MethodException 
.const [72] = Utf8 java/lang/StringBuffer 
.const [73] = Utf8 'Invalid Method Id ' 
.const [74] = Utf8 de/esolutions/fw/util/serializer/exception/SerializerException 
.const [75] = Utf8 'Deserialization failed: method=' 
.const [76] = Utf8 ', error=' 
.const [77] = Utf8 'STUB.asi.hmisync.media.ASIHMISyncMediaBrowser' 
.const [78] = Class [159] 
.const [79] = NameAndType [160] [161] 
.const [80] = Utf8 de/esolutions/fw/comm/asi/hmisync/media/impl/ASIHMISyncMediaBrowserService 
.const [81] = Utf8 de/esolutions/fw/comm/core/AbstractService 
.const [82] = Utf8 de/esolutions/fw/comm/asi/hmisync/media/impl/MediaSourceSlotSerializer 
.const [83] = Utf8 de/esolutions/fw/comm/asi/hmisync/media/ASIHMISyncMediaBrowserS 
.const [84] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [85] = Utf8 de/esolutions/fw/comm/asi/hmisync/media/impl/MediaEntrySerializer 
.const [86] = Utf8 de/esolutions/fw/comm/core/CallContext 
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
.const [105] = Class [189] 
.const [106] = NameAndType [190] [191] 
.const [107] = Class [192] 
.const [108] = NameAndType [193] [194] 
.const [109] = Utf8 de/esolutions/fw/comm/core/ServiceInstanceID 
.const [110] = Class [195] 
.const [111] = NameAndType [196] [197] 
.const [112] = Utf8 de/esolutions/fw/comm/asi/hmisync/media/impl/ASIHMISyncMediaBrowserReplyProxy 
.const [113] = Class [198] 
.const [114] = NameAndType [199] [200] 
.const [115] = Class [201] 
.const [116] = NameAndType [202] [203] 
.const [117] = Class [204] 
.const [118] = NameAndType [205] [206] 
.const [119] = Class [207] 
.const [120] = NameAndType [208] [209] 
.const [121] = Class [210] 
.const [122] = NameAndType [211] [212] 
.const [123] = Class [213] 
.const [124] = NameAndType [214] [215] 
.const [125] = Class [216] 
.const [126] = NameAndType [217] [218] 
.const [127] = Class [219] 
.const [128] = NameAndType [220] [221] 
.const [129] = Class [222] 
.const [130] = NameAndType [223] [224] 
.const [131] = Class [225] 
.const [132] = NameAndType [226] [227] 
.const [133] = Class [228] 
.const [134] = NameAndType [229] [230] 
.const [135] = Class [231] 
.const [136] = NameAndType [232] [233] 
.const [137] = Class [234] 
.const [138] = NameAndType [235] [236] 
.const [139] = Class [237] 
.const [140] = NameAndType [238] [239] 
.const [141] = Class [240] 
.const [142] = NameAndType [241] [242] 
.const [143] = Class [243] 
.const [144] = NameAndType [244] [245] 
.const [145] = Utf8 de/esolutions/fw/comm/core/method/MethodException 
.const [146] = Utf8 java/lang/StringBuffer 
.const [147] = Utf8 de/esolutions/fw/comm/asi/hmisync/media/impl/ASIHMISyncMediaBrowserService 
.const [148] = Utf8 context 
.const [149] = Utf8 Lde/esolutions/fw/comm/core/CallContext; 
.const [150] = Utf8 de/esolutions/fw/comm/asi/hmisync/media/impl/MediaSourceSlotSerializer 
.const [151] = Utf8 getOptionalMediaSourceSlot 
.const [152] = Utf8 (Lde/esolutions/fw/util/serializer/IDeserializer;)Lde/esolutions/fw/comm/asi/hmisync/media/MediaSourceSlot; 
.const [153] = Utf8 de/esolutions/fw/comm/asi/hmisync/media/impl/MediaEntrySerializer 
.const [154] = Utf8 getOptionalMediaEntryVarArray 
.const [155] = Utf8 (Lde/esolutions/fw/util/serializer/IDeserializer;)[Lde/esolutions/fw/comm/asi/hmisync/media/MediaEntry; 
.const [156] = Utf8 de/esolutions/fw/comm/asi/hmisync/media/impl/MediaEntrySerializer 
.const [157] = Utf8 getOptionalMediaEntry 
.const [158] = Utf8 (Lde/esolutions/fw/util/serializer/IDeserializer;)Lde/esolutions/fw/comm/asi/hmisync/media/MediaEntry; 
.const [159] = Utf8 de/esolutions/fw/comm/core/CallContext 
.const [160] = Utf8 getContext 
.const [161] = Utf8 (Ljava/lang/String;)Lde/esolutions/fw/comm/core/CallContext; 
.const [162] = Utf8 de/esolutions/fw/comm/asi/hmisync/media/impl/ASIHMISyncMediaBrowserService 
.const [163] = Utf8 p_ASIHMISyncMediaBrowser 
.const [164] = Utf8 Lde/esolutions/fw/comm/asi/hmisync/media/ASIHMISyncMediaBrowserS; 
.const [165] = Utf8 java/lang/StringBuffer 
.const [166] = Utf8 append 
.const [167] = Utf8 (Ljava/lang/String;)Ljava/lang/StringBuffer; 
.const [168] = Utf8 java/lang/StringBuffer 
.const [169] = Utf8 append 
.const [170] = Utf8 (I)Ljava/lang/StringBuffer; 
.const [171] = Utf8 java/lang/StringBuffer 
.const [172] = Utf8 toString 
.const [173] = Utf8 ()Ljava/lang/String; 
.const [174] = Utf8 de/esolutions/fw/util/serializer/exception/SerializerException 
.const [175] = Utf8 getMessage 
.const [176] = Utf8 ()Ljava/lang/String; 
.const [177] = Utf8 de/esolutions/fw/comm/core/ServiceInstanceID 
.const [178] = Utf8 <init> 
.const [179] = Utf8 (Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V 
.const [180] = Utf8 de/esolutions/fw/comm/core/AbstractService 
.const [181] = Utf8 <init> 
.const [182] = Utf8 (Lde/esolutions/fw/comm/core/ServiceInstanceID;)V 
.const [183] = Utf8 de/esolutions/fw/comm/asi/hmisync/media/impl/ASIHMISyncMediaBrowserReplyProxy 
.const [184] = Utf8 <init> 
.const [185] = Utf8 ()V 
.const [186] = Utf8 de/esolutions/fw/comm/asi/hmisync/media/impl/ASIHMISyncMediaBrowserService 
.const [187] = Utf8 context 
.const [188] = Utf8 Lde/esolutions/fw/comm/core/CallContext; 
.const [189] = Utf8 java/lang/StringBuffer 
.const [190] = Utf8 <init> 
.const [191] = Utf8 ()V 
.const [192] = Utf8 de/esolutions/fw/comm/core/method/MethodException 
.const [193] = Utf8 <init> 
.const [194] = Utf8 (Ljava/lang/String;)V 
.const [195] = Utf8 de/esolutions/fw/comm/asi/hmisync/media/impl/ASIHMISyncMediaBrowserService 
.const [196] = Utf8 p_ASIHMISyncMediaBrowser 
.const [197] = Utf8 Lde/esolutions/fw/comm/asi/hmisync/media/ASIHMISyncMediaBrowserS; 
.const [198] = Utf8 de/esolutions/fw/comm/asi/hmisync/media/ASIHMISyncMediaBrowserS 
.const [199] = Utf8 activate 
.const [200] = Utf8 (Lde/esolutions/fw/comm/asi/hmisync/media/MediaSourceSlot;Lde/esolutions/fw/comm/asi/hmisync/media/ASIHMISyncMediaBrowserReply;)V 
.const [201] = Utf8 de/esolutions/fw/comm/asi/hmisync/media/ASIHMISyncMediaBrowserS 
.const [202] = Utf8 deactivate 
.const [203] = Utf8 (Lde/esolutions/fw/comm/asi/hmisync/media/ASIHMISyncMediaBrowserReply;)V 
.const [204] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [205] = Utf8 getInt32 
.const [206] = Utf8 ()I 
.const [207] = Utf8 de/esolutions/fw/comm/asi/hmisync/media/ASIHMISyncMediaBrowserS 
.const [208] = Utf8 setBrowseMode 
.const [209] = Utf8 (ILde/esolutions/fw/comm/asi/hmisync/media/ASIHMISyncMediaBrowserReply;)V 
.const [210] = Utf8 de/esolutions/fw/comm/asi/hmisync/media/ASIHMISyncMediaBrowserS 
.const [211] = Utf8 changeFolder 
.const [212] = Utf8 ([Lde/esolutions/fw/comm/asi/hmisync/media/MediaEntry;Lde/esolutions/fw/comm/asi/hmisync/media/ASIHMISyncMediaBrowserReply;)V 
.const [213] = Utf8 de/esolutions/fw/comm/asi/hmisync/media/ASIHMISyncMediaBrowserS 
.const [214] = Utf8 addSelection 
.const [215] = Utf8 (ILde/esolutions/fw/comm/asi/hmisync/media/MediaEntry;Lde/esolutions/fw/comm/asi/hmisync/media/ASIHMISyncMediaBrowserReply;)V 
.const [216] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [217] = Utf8 getInt64 
.const [218] = Utf8 ()J 
.const [219] = Utf8 de/esolutions/fw/comm/asi/hmisync/media/ASIHMISyncMediaBrowserS 
.const [220] = Utf8 requestList 
.const [221] = Utf8 (IJIILde/esolutions/fw/comm/asi/hmisync/media/ASIHMISyncMediaBrowserReply;)V 
.const [222] = Utf8 de/esolutions/fw/comm/asi/hmisync/media/ASIHMISyncMediaBrowserS 
.const [223] = Utf8 setNotification 
.const [224] = Utf8 (Lde/esolutions/fw/comm/asi/hmisync/media/ASIHMISyncMediaBrowserReply;)V 
.const [225] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [226] = Utf8 getUInt32 
.const [227] = Utf8 ()J 
.const [228] = Utf8 de/esolutions/fw/comm/asi/hmisync/media/ASIHMISyncMediaBrowserS 
.const [229] = Utf8 setNotification 
.const [230] = Utf8 (JLde/esolutions/fw/comm/asi/hmisync/media/ASIHMISyncMediaBrowserReply;)V 
.const [231] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [232] = Utf8 getOptionalUInt32VarArray 
.const [233] = Utf8 ()[J 
.const [234] = Utf8 de/esolutions/fw/comm/asi/hmisync/media/ASIHMISyncMediaBrowserS 
.const [235] = Utf8 setNotification 
.const [236] = Utf8 ([JLde/esolutions/fw/comm/asi/hmisync/media/ASIHMISyncMediaBrowserReply;)V 
.const [237] = Utf8 de/esolutions/fw/comm/asi/hmisync/media/ASIHMISyncMediaBrowserS 
.const [238] = Utf8 clearNotification 
.const [239] = Utf8 (Lde/esolutions/fw/comm/asi/hmisync/media/ASIHMISyncMediaBrowserReply;)V 
.const [240] = Utf8 de/esolutions/fw/comm/asi/hmisync/media/ASIHMISyncMediaBrowserS 
.const [241] = Utf8 clearNotification 
.const [242] = Utf8 (JLde/esolutions/fw/comm/asi/hmisync/media/ASIHMISyncMediaBrowserReply;)V 
.const [243] = Utf8 de/esolutions/fw/comm/asi/hmisync/media/ASIHMISyncMediaBrowserS 
.const [244] = Utf8 clearNotification 
.const [245] = Utf8 ([JLde/esolutions/fw/comm/asi/hmisync/media/ASIHMISyncMediaBrowserReply;)V 
.const [246] = Utf8 de/esolutions/fw/comm/asi/hmisync/media/impl/ASIHMISyncMediaBrowserService 
.const [247] = Class [246] 
.const [248] = Utf8 de/esolutions/fw/comm/core/AbstractService 
.const [249] = Class [248] 
.const [250] = Utf8 context 
.const [251] = Utf8 Lde/esolutions/fw/comm/core/CallContext; 
.const [252] = Utf8 p_ASIHMISyncMediaBrowser 
.const [253] = Utf8 Lde/esolutions/fw/comm/asi/hmisync/media/ASIHMISyncMediaBrowserS; 
.const [254] = Utf8 Code 
.const [255] = Utf8 <init> 
.const [256] = Utf8 (ILde/esolutions/fw/comm/asi/hmisync/media/ASIHMISyncMediaBrowserS;)V 
.const [257] = Utf8 createReplyProxy 
.const [258] = Utf8 ()Lde/esolutions/fw/comm/core/IProxyFrontend; 
.const [259] = Utf8 getCallContext 
.const [260] = Utf8 ()Lde/esolutions/fw/comm/core/CallContext; 
.const [261] = Utf8 handleCallMethod 
.const [262] = Utf8 (SLde/esolutions/fw/util/serializer/IDeserializer;Lde/esolutions/fw/comm/core/IProxyFrontend;)V 
.const [263] = Utf8 <clinit> 
.const [264] = Utf8 ()V 
.end class 
