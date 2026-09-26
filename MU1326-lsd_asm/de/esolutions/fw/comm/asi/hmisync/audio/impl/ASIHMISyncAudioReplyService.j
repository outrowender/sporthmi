.version 50 0 
.class public super [259] 
.super [261] 
.field private static final [262] [263] 
.field private static [264] [265] 
.field private [266] [267] 

.method public [269] : [270] 
    .attribute [268] .code stack 7 locals 0 
L0:     aload_0 
L1:     new [41] 
L4:     dup 
L5:     ldc [3] 
L7:     invokestatic [4] 
L10:    ldc [5] 
L12:    ldc [6] 
L14:    invokespecial [35] 
L17:    invokespecial [36] 
L20:    aload_0 
L21:    aload_1 
L22:    putfield [42] 
L25:    return 
L26:    nop 
L27:    nop 
L28:    
    .end code 
.end method 

.method private static synchronized [271] : [272] 
    .attribute [268] .code stack 2 locals 1 
L0:     getstatic [7] 
L3:     iconst_1 
L4:     iadd 
L5:     dup 
L6:     putstatic [37] 
L9:     istore_0 
L10:    iload_0 
L11:    areturn 
L12:    
    .end code 
.end method 

.method public [273] : [274] 
    .attribute [268] .code stack 1 locals 0 
L0:     getstatic [8] 
L3:     areturn 
L4:     
    .end code 
.end method 

.method public [275] : [276] 
    .attribute [268] .code stack 4 locals 2 
        .catch [16] from L0 to L451 using L454 
L0:     iload_1 
L1:     tableswitch 7 
            L92 
            L424 
            L424 
            L424 
            L424 
            L424 
            L114 
            L210 
            L240 
            L424 
            L360 
            L330 
            L178 
            L146 
            L424 
            L424 
            L300 
            L392 
            L270 
            default : L424 

L92:    aload_2 
L93:    invokeinterface [43] 0 
L98:    istore 4 
L100:   aload_0 
L101:   getfield [30] 
L104:   iload 4 
L106:   invokeinterface [44] 0 
L111:   goto L451 
L114:   aload_2 
L115:   invokeinterface [45] 0 
L120:   astore 4 
L122:   aload_2 
L123:   invokeinterface [46] 0 
L128:   istore 5 
L130:   aload_0 
L131:   getfield [30] 
L134:   aload 4 
L136:   iload 5 
L138:   invokeinterface [47] 0 
L143:   goto L451 
L146:   aload_2 
L147:   invokeinterface [48] 0 
L152:   astore 4 
L154:   aload_2 
L155:   invokeinterface [46] 0 
L160:   istore 5 
L162:   aload_0 
L163:   getfield [30] 
L166:   aload 4 
L168:   iload 5 
L170:   invokeinterface [49] 0 
L175:   goto L451 
L178:   aload_2 
L179:   invokeinterface [48] 0 
L184:   astore 4 
L186:   aload_2 
L187:   invokeinterface [46] 0 
L192:   istore 5 
L194:   aload_0 
L195:   getfield [30] 
L198:   aload 4 
L200:   iload 5 
L202:   invokeinterface [50] 0 
L207:   goto L451 
L210:   aload_2 
L211:   invokestatic [9] 
L214:   astore 4 
L216:   aload_2 
L217:   invokeinterface [46] 0 
L222:   istore 5 
L224:   aload_0 
L225:   getfield [30] 
L228:   aload 4 
L230:   iload 5 
L232:   invokeinterface [51] 0 
L237:   goto L451 
L240:   aload_2 
L241:   invokestatic [9] 
L244:   astore 4 
L246:   aload_2 
L247:   invokeinterface [46] 0 
L252:   istore 5 
L254:   aload_0 
L255:   getfield [30] 
L258:   aload 4 
L260:   iload 5 
L262:   invokeinterface [52] 0 
L267:   goto L451 
L270:   aload_2 
L271:   invokestatic [10] 
L274:   astore 4 
L276:   aload_2 
L277:   invokeinterface [46] 0 
L282:   istore 5 
L284:   aload_0 
L285:   getfield [30] 
L288:   aload 4 
L290:   iload 5 
L292:   invokeinterface [53] 0 
L297:   goto L451 
L300:   aload_2 
L301:   invokestatic [11] 
L304:   astore 4 
L306:   aload_2 
L307:   invokeinterface [46] 0 
L312:   istore 5 
L314:   aload_0 
L315:   getfield [30] 
L318:   aload 4 
L320:   iload 5 
L322:   invokeinterface [54] 0 
L327:   goto L451 
L330:   aload_2 
L331:   invokestatic [12] 
L334:   astore 4 
L336:   aload_2 
L337:   invokeinterface [46] 0 
L342:   istore 5 
L344:   aload_0 
L345:   getfield [30] 
L348:   aload 4 
L350:   iload 5 
L352:   invokeinterface [55] 0 
L357:   goto L451 
L360:   aload_2 
L361:   invokeinterface [43] 0 
L366:   istore 4 
L368:   aload_2 
L369:   invokeinterface [46] 0 
L374:   istore 5 
L376:   aload_0 
L377:   getfield [30] 
L380:   iload 4 
L382:   iload 5 
L384:   invokeinterface [56] 0 
L389:   goto L451 
L392:   aload_2 
L393:   invokeinterface [43] 0 
L398:   istore 4 
L400:   aload_2 
L401:   invokeinterface [46] 0 
L406:   istore 5 
L408:   aload_0 
L409:   getfield [30] 
L412:   iload 4 
L414:   iload 5 
L416:   invokeinterface [57] 0 
L421:   goto L451 
L424:   new [58] 
L427:   dup 
L428:   new [59] 
L431:   dup 
L432:   invokespecial [39] 
L435:   ldc [15] 
L437:   invokevirtual [31] 
L440:   iload_1 
L441:   invokevirtual [32] 
L444:   invokevirtual [33] 
L447:   invokespecial [40] 
L450:   athrow 
L451:   goto L496 
L454:   astore 4 
L456:   new [58] 
L459:   dup 
L460:   new [59] 
L463:   dup 
L464:   invokespecial [39] 
L467:   ldc [17] 
L469:   invokevirtual [31] 
L472:   iload_1 
L473:   invokevirtual [32] 
L476:   ldc [18] 
L478:   invokevirtual [31] 
L481:   aload 4 
L483:   invokevirtual [34] 
L486:   invokevirtual [31] 
L489:   invokevirtual [33] 
L492:   invokespecial [40] 
L495:   athrow 
L496:   return 
L497:   nop 
L498:   nop 
L499:   nop 
L500:   
    .end code 
.end method 

.method static [277] : [278] 
    .attribute [268] .code stack 1 locals 0 
L0:     ldc [19] 
L2:     invokestatic [20] 
L5:     putstatic [38] 
L8:     iconst_0 
L9:     putstatic [37] 
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
.const [29] = Class [95] 
.const [30] = Field [96] [97] 
.const [31] = Method [98] [99] 
.const [32] = Method [100] [101] 
.const [33] = Method [102] [103] 
.const [34] = Method [104] [105] 
.const [35] = Method [106] [107] 
.const [36] = Method [108] [109] 
.const [37] = Field [110] [111] 
.const [38] = Field [112] [113] 
.const [39] = Method [114] [115] 
.const [40] = Method [116] [117] 
.const [41] = Class [118] 
.const [42] = Field [119] [120] 
.const [43] = InterfaceMethod [121] [122] 
.const [44] = InterfaceMethod [123] [124] 
.const [45] = InterfaceMethod [125] [126] 
.const [46] = InterfaceMethod [127] [128] 
.const [47] = InterfaceMethod [129] [130] 
.const [48] = InterfaceMethod [131] [132] 
.const [49] = InterfaceMethod [133] [134] 
.const [50] = InterfaceMethod [135] [136] 
.const [51] = InterfaceMethod [137] [138] 
.const [52] = InterfaceMethod [139] [140] 
.const [53] = InterfaceMethod [141] [142] 
.const [54] = InterfaceMethod [143] [144] 
.const [55] = InterfaceMethod [145] [146] 
.const [56] = InterfaceMethod [147] [148] 
.const [57] = InterfaceMethod [149] [150] 
.const [58] = Class [151] 
.const [59] = Class [152] 
.const [60] = Utf8 de/esolutions/fw/comm/core/ServiceInstanceID 
.const [61] = Utf8 cd52f5cc-371d-43de-8bc4-c3df1c55f44a 
.const [62] = Class [153] 
.const [63] = NameAndType [154] [155] 
.const [64] = Utf8 '0c5e00e4-2cbf-5dfc-acd3-5499fe013c7f' 
.const [65] = Utf8 'asi.hmisync.audio.ASIHMISyncAudio' 
.const [66] = Class [156] 
.const [67] = NameAndType [157] [158] 
.const [68] = Class [159] 
.const [69] = NameAndType [160] [161] 
.const [70] = Class [162] 
.const [71] = NameAndType [163] [164] 
.const [72] = Class [165] 
.const [73] = NameAndType [166] [167] 
.const [74] = Class [168] 
.const [75] = NameAndType [169] [170] 
.const [76] = Class [171] 
.const [77] = NameAndType [172] [173] 
.const [78] = Utf8 de/esolutions/fw/comm/core/method/MethodException 
.const [79] = Utf8 java/lang/StringBuffer 
.const [80] = Utf8 'Invalid Method Id ' 
.const [81] = Utf8 de/esolutions/fw/util/serializer/exception/SerializerException 
.const [82] = Utf8 'Deserialization failed: method=' 
.const [83] = Utf8 ', error=' 
.const [84] = Utf8 'STUB.asi.hmisync.audio.ASIHMISyncAudio' 
.const [85] = Class [174] 
.const [86] = NameAndType [175] [176] 
.const [87] = Utf8 de/esolutions/fw/comm/asi/hmisync/audio/impl/ASIHMISyncAudioReplyService 
.const [88] = Utf8 de/esolutions/fw/comm/core/AbstractReplyService 
.const [89] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [90] = Utf8 de/esolutions/fw/comm/asi/hmisync/audio/ASIHMISyncAudioReply 
.const [91] = Utf8 de/esolutions/fw/comm/asi/hmisync/audio/impl/AudioStateSerializer 
.const [92] = Utf8 de/esolutions/fw/comm/asi/hmisync/audio/impl/VolumeLockStateSerializer 
.const [93] = Utf8 de/esolutions/fw/comm/asi/hmisync/audio/impl/A2LSStateSerializer 
.const [94] = Utf8 de/esolutions/fw/comm/asi/hmisync/audio/impl/VolumeRangeSerializer 
.const [95] = Utf8 de/esolutions/fw/comm/core/CallContext 
.const [96] = Class [177] 
.const [97] = NameAndType [178] [179] 
.const [98] = Class [180] 
.const [99] = NameAndType [181] [182] 
.const [100] = Class [183] 
.const [101] = NameAndType [184] [185] 
.const [102] = Class [186] 
.const [103] = NameAndType [187] [188] 
.const [104] = Class [189] 
.const [105] = NameAndType [190] [191] 
.const [106] = Class [192] 
.const [107] = NameAndType [193] [194] 
.const [108] = Class [195] 
.const [109] = NameAndType [196] [197] 
.const [110] = Class [198] 
.const [111] = NameAndType [199] [200] 
.const [112] = Class [201] 
.const [113] = NameAndType [202] [203] 
.const [114] = Class [204] 
.const [115] = NameAndType [205] [206] 
.const [116] = Class [207] 
.const [117] = NameAndType [208] [209] 
.const [118] = Utf8 de/esolutions/fw/comm/core/ServiceInstanceID 
.const [119] = Class [210] 
.const [120] = NameAndType [211] [212] 
.const [121] = Class [213] 
.const [122] = NameAndType [214] [215] 
.const [123] = Class [216] 
.const [124] = NameAndType [217] [218] 
.const [125] = Class [219] 
.const [126] = NameAndType [220] [221] 
.const [127] = Class [222] 
.const [128] = NameAndType [223] [224] 
.const [129] = Class [225] 
.const [130] = NameAndType [226] [227] 
.const [131] = Class [228] 
.const [132] = NameAndType [229] [230] 
.const [133] = Class [231] 
.const [134] = NameAndType [232] [233] 
.const [135] = Class [234] 
.const [136] = NameAndType [235] [236] 
.const [137] = Class [237] 
.const [138] = NameAndType [238] [239] 
.const [139] = Class [240] 
.const [140] = NameAndType [241] [242] 
.const [141] = Class [243] 
.const [142] = NameAndType [244] [245] 
.const [143] = Class [246] 
.const [144] = NameAndType [247] [248] 
.const [145] = Class [249] 
.const [146] = NameAndType [250] [251] 
.const [147] = Class [252] 
.const [148] = NameAndType [253] [254] 
.const [149] = Class [255] 
.const [150] = NameAndType [256] [257] 
.const [151] = Utf8 de/esolutions/fw/comm/core/method/MethodException 
.const [152] = Utf8 java/lang/StringBuffer 
.const [153] = Utf8 de/esolutions/fw/comm/asi/hmisync/audio/impl/ASIHMISyncAudioReplyService 
.const [154] = Utf8 nextDynamicHandle 
.const [155] = Utf8 ()I 
.const [156] = Utf8 de/esolutions/fw/comm/asi/hmisync/audio/impl/ASIHMISyncAudioReplyService 
.const [157] = Utf8 dynamicHandle 
.const [158] = Utf8 I 
.const [159] = Utf8 de/esolutions/fw/comm/asi/hmisync/audio/impl/ASIHMISyncAudioReplyService 
.const [160] = Utf8 context 
.const [161] = Utf8 Lde/esolutions/fw/comm/core/CallContext; 
.const [162] = Utf8 de/esolutions/fw/comm/asi/hmisync/audio/impl/AudioStateSerializer 
.const [163] = Utf8 getOptionalAudioState 
.const [164] = Utf8 (Lde/esolutions/fw/util/serializer/IDeserializer;)Lde/esolutions/fw/comm/asi/hmisync/audio/AudioState; 
.const [165] = Utf8 de/esolutions/fw/comm/asi/hmisync/audio/impl/VolumeLockStateSerializer 
.const [166] = Utf8 getOptionalVolumeLockState 
.const [167] = Utf8 (Lde/esolutions/fw/util/serializer/IDeserializer;)Lde/esolutions/fw/comm/asi/hmisync/audio/VolumeLockState; 
.const [168] = Utf8 de/esolutions/fw/comm/asi/hmisync/audio/impl/A2LSStateSerializer 
.const [169] = Utf8 getOptionalA2LSState 
.const [170] = Utf8 (Lde/esolutions/fw/util/serializer/IDeserializer;)Lde/esolutions/fw/comm/asi/hmisync/audio/A2LSState; 
.const [171] = Utf8 de/esolutions/fw/comm/asi/hmisync/audio/impl/VolumeRangeSerializer 
.const [172] = Utf8 getOptionalVolumeRange 
.const [173] = Utf8 (Lde/esolutions/fw/util/serializer/IDeserializer;)Lde/esolutions/fw/comm/asi/hmisync/audio/VolumeRange; 
.const [174] = Utf8 de/esolutions/fw/comm/core/CallContext 
.const [175] = Utf8 getContext 
.const [176] = Utf8 (Ljava/lang/String;)Lde/esolutions/fw/comm/core/CallContext; 
.const [177] = Utf8 de/esolutions/fw/comm/asi/hmisync/audio/impl/ASIHMISyncAudioReplyService 
.const [178] = Utf8 p_ASIHMISyncAudioReply 
.const [179] = Utf8 Lde/esolutions/fw/comm/asi/hmisync/audio/ASIHMISyncAudioReply; 
.const [180] = Utf8 java/lang/StringBuffer 
.const [181] = Utf8 append 
.const [182] = Utf8 (Ljava/lang/String;)Ljava/lang/StringBuffer; 
.const [183] = Utf8 java/lang/StringBuffer 
.const [184] = Utf8 append 
.const [185] = Utf8 (I)Ljava/lang/StringBuffer; 
.const [186] = Utf8 java/lang/StringBuffer 
.const [187] = Utf8 toString 
.const [188] = Utf8 ()Ljava/lang/String; 
.const [189] = Utf8 de/esolutions/fw/util/serializer/exception/SerializerException 
.const [190] = Utf8 getMessage 
.const [191] = Utf8 ()Ljava/lang/String; 
.const [192] = Utf8 de/esolutions/fw/comm/core/ServiceInstanceID 
.const [193] = Utf8 <init> 
.const [194] = Utf8 (Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V 
.const [195] = Utf8 de/esolutions/fw/comm/core/AbstractReplyService 
.const [196] = Utf8 <init> 
.const [197] = Utf8 (Lde/esolutions/fw/comm/core/ServiceInstanceID;)V 
.const [198] = Utf8 de/esolutions/fw/comm/asi/hmisync/audio/impl/ASIHMISyncAudioReplyService 
.const [199] = Utf8 dynamicHandle 
.const [200] = Utf8 I 
.const [201] = Utf8 de/esolutions/fw/comm/asi/hmisync/audio/impl/ASIHMISyncAudioReplyService 
.const [202] = Utf8 context 
.const [203] = Utf8 Lde/esolutions/fw/comm/core/CallContext; 
.const [204] = Utf8 java/lang/StringBuffer 
.const [205] = Utf8 <init> 
.const [206] = Utf8 ()V 
.const [207] = Utf8 de/esolutions/fw/comm/core/method/MethodException 
.const [208] = Utf8 <init> 
.const [209] = Utf8 (Ljava/lang/String;)V 
.const [210] = Utf8 de/esolutions/fw/comm/asi/hmisync/audio/impl/ASIHMISyncAudioReplyService 
.const [211] = Utf8 p_ASIHMISyncAudioReply 
.const [212] = Utf8 Lde/esolutions/fw/comm/asi/hmisync/audio/ASIHMISyncAudioReply; 
.const [213] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [214] = Utf8 getInt32 
.const [215] = Utf8 ()I 
.const [216] = Utf8 de/esolutions/fw/comm/asi/hmisync/audio/ASIHMISyncAudioReply 
.const [217] = Utf8 responseEnableA2LS 
.const [218] = Utf8 (I)V 
.const [219] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [220] = Utf8 getOptionalString 
.const [221] = Utf8 ()Ljava/lang/String; 
.const [222] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [223] = Utf8 getBool 
.const [224] = Utf8 ()Z 
.const [225] = Utf8 de/esolutions/fw/comm/asi/hmisync/audio/ASIHMISyncAudioReply 
.const [226] = Utf8 updateASIVersion 
.const [227] = Utf8 (Ljava/lang/String;Z)V 
.const [228] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [229] = Utf8 getOptionalInt16VarArray 
.const [230] = Utf8 ()[S 
.const [231] = Utf8 de/esolutions/fw/comm/asi/hmisync/audio/ASIHMISyncAudioReply 
.const [232] = Utf8 updateRequestIDs 
.const [233] = Utf8 ([SZ)V 
.const [234] = Utf8 de/esolutions/fw/comm/asi/hmisync/audio/ASIHMISyncAudioReply 
.const [235] = Utf8 updateReplyIDs 
.const [236] = Utf8 ([SZ)V 
.const [237] = Utf8 de/esolutions/fw/comm/asi/hmisync/audio/ASIHMISyncAudioReply 
.const [238] = Utf8 updateAudioContext 
.const [239] = Utf8 (Lde/esolutions/fw/comm/asi/hmisync/audio/AudioState;Z)V 
.const [240] = Utf8 de/esolutions/fw/comm/asi/hmisync/audio/ASIHMISyncAudioReply 
.const [241] = Utf8 updateFrontAudioContext 
.const [242] = Utf8 (Lde/esolutions/fw/comm/asi/hmisync/audio/AudioState;Z)V 
.const [243] = Utf8 de/esolutions/fw/comm/asi/hmisync/audio/ASIHMISyncAudioReply 
.const [244] = Utf8 updateVolumeLockState 
.const [245] = Utf8 (Lde/esolutions/fw/comm/asi/hmisync/audio/VolumeLockState;Z)V 
.const [246] = Utf8 de/esolutions/fw/comm/asi/hmisync/audio/ASIHMISyncAudioReply 
.const [247] = Utf8 updateA2LSState 
.const [248] = Utf8 (Lde/esolutions/fw/comm/asi/hmisync/audio/A2LSState;Z)V 
.const [249] = Utf8 de/esolutions/fw/comm/asi/hmisync/audio/ASIHMISyncAudioReply 
.const [250] = Utf8 updateVolumeRange 
.const [251] = Utf8 (Lde/esolutions/fw/comm/asi/hmisync/audio/VolumeRange;Z)V 
.const [252] = Utf8 de/esolutions/fw/comm/asi/hmisync/audio/ASIHMISyncAudioReply 
.const [253] = Utf8 updateVolume 
.const [254] = Utf8 (IZ)V 
.const [255] = Utf8 de/esolutions/fw/comm/asi/hmisync/audio/ASIHMISyncAudioReply 
.const [256] = Utf8 updateAudibleState 
.const [257] = Utf8 (IZ)V 
.const [258] = Utf8 de/esolutions/fw/comm/asi/hmisync/audio/impl/ASIHMISyncAudioReplyService 
.const [259] = Class [258] 
.const [260] = Utf8 de/esolutions/fw/comm/core/AbstractReplyService 
.const [261] = Class [260] 
.const [262] = Utf8 context 
.const [263] = Utf8 Lde/esolutions/fw/comm/core/CallContext; 
.const [264] = Utf8 dynamicHandle 
.const [265] = Utf8 I 
.const [266] = Utf8 p_ASIHMISyncAudioReply 
.const [267] = Utf8 Lde/esolutions/fw/comm/asi/hmisync/audio/ASIHMISyncAudioReply; 
.const [268] = Utf8 Code 
.const [269] = Utf8 <init> 
.const [270] = Utf8 (Lde/esolutions/fw/comm/asi/hmisync/audio/ASIHMISyncAudioReply;)V 
.const [271] = Utf8 nextDynamicHandle 
.const [272] = Utf8 ()I 
.const [273] = Utf8 getCallContext 
.const [274] = Utf8 ()Lde/esolutions/fw/comm/core/CallContext; 
.const [275] = Utf8 handleCallMethod 
.const [276] = Utf8 (SLde/esolutions/fw/util/serializer/IDeserializer;Lde/esolutions/fw/comm/core/IProxyFrontend;)V 
.const [277] = Utf8 <clinit> 
.const [278] = Utf8 ()V 
.end class 
