.version 50 0 
.class public super [203] 
.super [205] 
.field private static final [206] [207] 
.field private static [208] [209] 
.field private [210] [211] 

.method public [213] : [214] 
    .attribute [212] .code stack 7 locals 0 
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

.method private static synchronized [215] : [216] 
    .attribute [212] .code stack 2 locals 1 
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

.method public [217] : [218] 
    .attribute [212] .code stack 1 locals 0 
L0:     getstatic [8] 
L3:     areturn 
L4:     
    .end code 
.end method 

.method public [219] : [220] 
    .attribute [212] .code stack 5 locals 4 
        .catch [12] from L0 to L395 using L398 
L0:     iload_1 
L1:     tableswitch 0 
            L124 
            L294 
            L368 
            L368 
            L368 
            L368 
            L252 
            L368 
            L146 
            L178 
            L368 
            L92 
            L368 
            L368 
            L368 
            L368 
            L368 
            L220 
            L336 
            default : L368 

L92:    aload_2 
L93:    invokeinterface [35] 0 
L98:    istore 4 
L100:   aload_2 
L101:   invokeinterface [35] 0 
L106:   istore 5 
L108:   aload_0 
L109:   getfield [22] 
L112:   iload 4 
L114:   iload 5 
L116:   invokeinterface [36] 0 
L121:   goto L395 
L124:   aload_2 
L125:   invokeinterface [35] 0 
L130:   istore 4 
L132:   aload_0 
L133:   getfield [22] 
L136:   iload 4 
L138:   invokeinterface [37] 0 
L143:   goto L395 
L146:   aload_2 
L147:   invokeinterface [35] 0 
L152:   istore 4 
L154:   aload_2 
L155:   invokeinterface [35] 0 
L160:   istore 5 
L162:   aload_0 
L163:   getfield [22] 
L166:   iload 4 
L168:   iload 5 
L170:   invokeinterface [38] 0 
L175:   goto L395 
L178:   aload_2 
L179:   invokeinterface [35] 0 
L184:   istore 4 
L186:   aload_2 
L187:   invokeinterface [35] 0 
L192:   istore 5 
L194:   aload_2 
L195:   invokeinterface [35] 0 
L200:   istore 6 
L202:   aload_0 
L203:   getfield [22] 
L206:   iload 4 
L208:   iload 5 
L210:   iload 6 
L212:   invokeinterface [39] 0 
L217:   goto L395 
L220:   aload_2 
L221:   invokeinterface [35] 0 
L226:   istore 4 
L228:   aload_2 
L229:   invokeinterface [35] 0 
L234:   istore 5 
L236:   aload_0 
L237:   getfield [22] 
L240:   iload 4 
L242:   iload 5 
L244:   invokeinterface [40] 0 
L249:   goto L395 
L252:   aload_2 
L253:   invokeinterface [35] 0 
L258:   istore 4 
L260:   aload_2 
L261:   invokeinterface [35] 0 
L266:   istore 5 
L268:   aload_2 
L269:   invokeinterface [41] 0 
L274:   lstore 6 
L276:   aload_0 
L277:   getfield [22] 
L280:   iload 4 
L282:   iload 5 
L284:   lload 6 
L286:   invokeinterface [42] 0 
L291:   goto L395 
L294:   aload_2 
L295:   invokeinterface [35] 0 
L300:   istore 4 
L302:   aload_2 
L303:   invokeinterface [43] 0 
L308:   astore 5 
L310:   aload_2 
L311:   invokeinterface [35] 0 
L316:   istore 6 
L318:   aload_0 
L319:   getfield [22] 
L322:   iload 4 
L324:   aload 5 
L326:   iload 6 
L328:   invokeinterface [44] 0 
L333:   goto L395 
L336:   aload_2 
L337:   invokeinterface [43] 0 
L342:   astore 4 
L344:   aload_2 
L345:   invokeinterface [43] 0 
L350:   astore 5 
L352:   aload_0 
L353:   getfield [22] 
L356:   aload 4 
L358:   aload 5 
L360:   invokeinterface [45] 0 
L365:   goto L395 
L368:   new [46] 
L371:   dup 
L372:   new [47] 
L375:   dup 
L376:   invokespecial [31] 
L379:   ldc [11] 
L381:   invokevirtual [23] 
L384:   iload_1 
L385:   invokevirtual [24] 
L388:   invokevirtual [25] 
L391:   invokespecial [32] 
L394:   athrow 
L395:   goto L440 
L398:   astore 4 
L400:   new [46] 
L403:   dup 
L404:   new [47] 
L407:   dup 
L408:   invokespecial [31] 
L411:   ldc [13] 
L413:   invokevirtual [23] 
L416:   iload_1 
L417:   invokevirtual [24] 
L420:   ldc [14] 
L422:   invokevirtual [23] 
L425:   aload 4 
L427:   invokevirtual [26] 
L430:   invokevirtual [23] 
L433:   invokevirtual [25] 
L436:   invokespecial [32] 
L439:   athrow 
L440:   return 
L441:   nop 
L442:   nop 
L443:   nop 
L444:   
    .end code 
.end method 

.method static [221] : [222] 
    .attribute [212] .code stack 1 locals 0 
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
.const [2] = Class [48] 
.const [3] = String [49] 
.const [4] = Method [50] [51] 
.const [5] = String [52] 
.const [6] = String [53] 
.const [7] = Field [54] [55] 
.const [8] = Field [56] [57] 
.const [9] = Class [58] 
.const [10] = Class [59] 
.const [11] = String [60] 
.const [12] = Class [61] 
.const [13] = String [62] 
.const [14] = String [63] 
.const [15] = String [64] 
.const [16] = Method [65] [66] 
.const [17] = Class [67] 
.const [18] = Class [68] 
.const [19] = Class [69] 
.const [20] = Class [70] 
.const [21] = Class [71] 
.const [22] = Field [72] [73] 
.const [23] = Method [74] [75] 
.const [24] = Method [76] [77] 
.const [25] = Method [78] [79] 
.const [26] = Method [80] [81] 
.const [27] = Method [82] [83] 
.const [28] = Method [84] [85] 
.const [29] = Field [86] [87] 
.const [30] = Field [88] [89] 
.const [31] = Method [90] [91] 
.const [32] = Method [92] [93] 
.const [33] = Class [94] 
.const [34] = Field [95] [96] 
.const [35] = InterfaceMethod [97] [98] 
.const [36] = InterfaceMethod [99] [100] 
.const [37] = InterfaceMethod [101] [102] 
.const [38] = InterfaceMethod [103] [104] 
.const [39] = InterfaceMethod [105] [106] 
.const [40] = InterfaceMethod [107] [108] 
.const [41] = InterfaceMethod [109] [110] 
.const [42] = InterfaceMethod [111] [112] 
.const [43] = InterfaceMethod [113] [114] 
.const [44] = InterfaceMethod [115] [116] 
.const [45] = InterfaceMethod [117] [118] 
.const [46] = Class [119] 
.const [47] = Class [120] 
.const [48] = Utf8 de/esolutions/fw/comm/core/ServiceInstanceID 
.const [49] = Utf8 e807d634-9ea2-5397-904a-1df1e52b3d2c 
.const [50] = Class [121] 
.const [51] = NameAndType [122] [123] 
.const [52] = Utf8 a3cc537e-0364-51f9-bde3-953f3ce486e9 
.const [53] = Utf8 'dsi.search.DSISearchDataProvider' 
.const [54] = Class [124] 
.const [55] = NameAndType [125] [126] 
.const [56] = Class [127] 
.const [57] = NameAndType [128] [129] 
.const [58] = Utf8 de/esolutions/fw/comm/core/method/MethodException 
.const [59] = Utf8 java/lang/StringBuffer 
.const [60] = Utf8 'Invalid Method Id ' 
.const [61] = Utf8 de/esolutions/fw/util/serializer/exception/SerializerException 
.const [62] = Utf8 'Deserialization failed: method=' 
.const [63] = Utf8 ', error=' 
.const [64] = Utf8 'STUB.dsi.search.DSISearchDataProvider' 
.const [65] = Class [130] 
.const [66] = NameAndType [131] [132] 
.const [67] = Utf8 de/esolutions/fw/comm/dsi/search/impl/DSISearchDataProviderReplyService 
.const [68] = Utf8 de/esolutions/fw/comm/core/AbstractReplyService 
.const [69] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [70] = Utf8 de/esolutions/fw/comm/dsi/search/DSISearchDataProviderReply 
.const [71] = Utf8 de/esolutions/fw/comm/core/CallContext 
.const [72] = Class [133] 
.const [73] = NameAndType [134] [135] 
.const [74] = Class [136] 
.const [75] = NameAndType [137] [138] 
.const [76] = Class [139] 
.const [77] = NameAndType [140] [141] 
.const [78] = Class [142] 
.const [79] = NameAndType [143] [144] 
.const [80] = Class [145] 
.const [81] = NameAndType [146] [147] 
.const [82] = Class [148] 
.const [83] = NameAndType [149] [150] 
.const [84] = Class [151] 
.const [85] = NameAndType [152] [153] 
.const [86] = Class [154] 
.const [87] = NameAndType [155] [156] 
.const [88] = Class [157] 
.const [89] = NameAndType [158] [159] 
.const [90] = Class [160] 
.const [91] = NameAndType [161] [162] 
.const [92] = Class [163] 
.const [93] = NameAndType [164] [165] 
.const [94] = Utf8 de/esolutions/fw/comm/core/ServiceInstanceID 
.const [95] = Class [166] 
.const [96] = NameAndType [167] [168] 
.const [97] = Class [169] 
.const [98] = NameAndType [170] [171] 
.const [99] = Class [172] 
.const [100] = NameAndType [173] [174] 
.const [101] = Class [175] 
.const [102] = NameAndType [176] [177] 
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
.const [119] = Utf8 de/esolutions/fw/comm/core/method/MethodException 
.const [120] = Utf8 java/lang/StringBuffer 
.const [121] = Utf8 de/esolutions/fw/comm/dsi/search/impl/DSISearchDataProviderReplyService 
.const [122] = Utf8 nextDynamicHandle 
.const [123] = Utf8 ()I 
.const [124] = Utf8 de/esolutions/fw/comm/dsi/search/impl/DSISearchDataProviderReplyService 
.const [125] = Utf8 dynamicHandle 
.const [126] = Utf8 I 
.const [127] = Utf8 de/esolutions/fw/comm/dsi/search/impl/DSISearchDataProviderReplyService 
.const [128] = Utf8 context 
.const [129] = Utf8 Lde/esolutions/fw/comm/core/CallContext; 
.const [130] = Utf8 de/esolutions/fw/comm/core/CallContext 
.const [131] = Utf8 getContext 
.const [132] = Utf8 (Ljava/lang/String;)Lde/esolutions/fw/comm/core/CallContext; 
.const [133] = Utf8 de/esolutions/fw/comm/dsi/search/impl/DSISearchDataProviderReplyService 
.const [134] = Utf8 p_DSISearchDataProviderReply 
.const [135] = Utf8 Lde/esolutions/fw/comm/dsi/search/DSISearchDataProviderReply; 
.const [136] = Utf8 java/lang/StringBuffer 
.const [137] = Utf8 append 
.const [138] = Utf8 (Ljava/lang/String;)Ljava/lang/StringBuffer; 
.const [139] = Utf8 java/lang/StringBuffer 
.const [140] = Utf8 append 
.const [141] = Utf8 (I)Ljava/lang/StringBuffer; 
.const [142] = Utf8 java/lang/StringBuffer 
.const [143] = Utf8 toString 
.const [144] = Utf8 ()Ljava/lang/String; 
.const [145] = Utf8 de/esolutions/fw/util/serializer/exception/SerializerException 
.const [146] = Utf8 getMessage 
.const [147] = Utf8 ()Ljava/lang/String; 
.const [148] = Utf8 de/esolutions/fw/comm/core/ServiceInstanceID 
.const [149] = Utf8 <init> 
.const [150] = Utf8 (Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V 
.const [151] = Utf8 de/esolutions/fw/comm/core/AbstractReplyService 
.const [152] = Utf8 <init> 
.const [153] = Utf8 (Lde/esolutions/fw/comm/core/ServiceInstanceID;)V 
.const [154] = Utf8 de/esolutions/fw/comm/dsi/search/impl/DSISearchDataProviderReplyService 
.const [155] = Utf8 dynamicHandle 
.const [156] = Utf8 I 
.const [157] = Utf8 de/esolutions/fw/comm/dsi/search/impl/DSISearchDataProviderReplyService 
.const [158] = Utf8 context 
.const [159] = Utf8 Lde/esolutions/fw/comm/core/CallContext; 
.const [160] = Utf8 java/lang/StringBuffer 
.const [161] = Utf8 <init> 
.const [162] = Utf8 ()V 
.const [163] = Utf8 de/esolutions/fw/comm/core/method/MethodException 
.const [164] = Utf8 <init> 
.const [165] = Utf8 (Ljava/lang/String;)V 
.const [166] = Utf8 de/esolutions/fw/comm/dsi/search/impl/DSISearchDataProviderReplyService 
.const [167] = Utf8 p_DSISearchDataProviderReply 
.const [168] = Utf8 Lde/esolutions/fw/comm/dsi/search/DSISearchDataProviderReply; 
.const [169] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [170] = Utf8 getInt32 
.const [171] = Utf8 ()I 
.const [172] = Utf8 de/esolutions/fw/comm/dsi/search/DSISearchDataProviderReply 
.const [173] = Utf8 registerProviderSourceResult 
.const [174] = Utf8 (II)V 
.const [175] = Utf8 de/esolutions/fw/comm/dsi/search/DSISearchDataProviderReply 
.const [176] = Utf8 activateProviderSource 
.const [177] = Utf8 (I)V 
.const [178] = Utf8 de/esolutions/fw/comm/dsi/search/DSISearchDataProviderReply 
.const [179] = Utf8 invalidateAllDataResult 
.const [180] = Utf8 (II)V 
.const [181] = Utf8 de/esolutions/fw/comm/dsi/search/DSISearchDataProviderReply 
.const [182] = Utf8 provideData 
.const [183] = Utf8 (III)V 
.const [184] = Utf8 de/esolutions/fw/comm/dsi/search/DSISearchDataProviderReply 
.const [185] = Utf8 storeDataSetsResult 
.const [186] = Utf8 (II)V 
.const [187] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [188] = Utf8 getInt64 
.const [189] = Utf8 ()J 
.const [190] = Utf8 de/esolutions/fw/comm/dsi/search/DSISearchDataProviderReply 
.const [191] = Utf8 deleteDataSetResult 
.const [192] = Utf8 (IIJ)V 
.const [193] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [194] = Utf8 getOptionalString 
.const [195] = Utf8 ()Ljava/lang/String; 
.const [196] = Utf8 de/esolutions/fw/comm/dsi/search/DSISearchDataProviderReply 
.const [197] = Utf8 asyncException 
.const [198] = Utf8 (ILjava/lang/String;I)V 
.const [199] = Utf8 de/esolutions/fw/comm/dsi/search/DSISearchDataProviderReply 
.const [200] = Utf8 yyIndication 
.const [201] = Utf8 (Ljava/lang/String;Ljava/lang/String;)V 
.const [202] = Utf8 de/esolutions/fw/comm/dsi/search/impl/DSISearchDataProviderReplyService 
.const [203] = Class [202] 
.const [204] = Utf8 de/esolutions/fw/comm/core/AbstractReplyService 
.const [205] = Class [204] 
.const [206] = Utf8 context 
.const [207] = Utf8 Lde/esolutions/fw/comm/core/CallContext; 
.const [208] = Utf8 dynamicHandle 
.const [209] = Utf8 I 
.const [210] = Utf8 p_DSISearchDataProviderReply 
.const [211] = Utf8 Lde/esolutions/fw/comm/dsi/search/DSISearchDataProviderReply; 
.const [212] = Utf8 Code 
.const [213] = Utf8 <init> 
.const [214] = Utf8 (Lde/esolutions/fw/comm/dsi/search/DSISearchDataProviderReply;)V 
.const [215] = Utf8 nextDynamicHandle 
.const [216] = Utf8 ()I 
.const [217] = Utf8 getCallContext 
.const [218] = Utf8 ()Lde/esolutions/fw/comm/core/CallContext; 
.const [219] = Utf8 handleCallMethod 
.const [220] = Utf8 (SLde/esolutions/fw/util/serializer/IDeserializer;Lde/esolutions/fw/comm/core/IProxyFrontend;)V 
.const [221] = Utf8 <clinit> 
.const [222] = Utf8 ()V 
.end class 
