.version 50 0 
.class public super [231] 
.super [233] 
.field private static final [234] [235] 
.field private static [236] [237] 
.field private [238] [239] 

.method public [241] : [242] 
    .attribute [240] .code stack 7 locals 0 
L0:     aload_0 
L1:     new [37] 
L4:     dup 
L5:     ldc [3] 
L7:     invokestatic [4] 
L10:    ldc [5] 
L12:    ldc [6] 
L14:    invokespecial [31] 
L17:    invokespecial [32] 
L20:    aload_0 
L21:    aload_1 
L22:    putfield [38] 
L25:    return 
L26:    nop 
L27:    nop 
L28:    
    .end code 
.end method 

.method private static synchronized [243] : [244] 
    .attribute [240] .code stack 2 locals 1 
L0:     getstatic [7] 
L3:     iconst_1 
L4:     iadd 
L5:     dup 
L6:     putstatic [33] 
L9:     istore_0 
L10:    iload_0 
L11:    areturn 
L12:    
    .end code 
.end method 

.method public [245] : [246] 
    .attribute [240] .code stack 1 locals 0 
L0:     getstatic [8] 
L3:     areturn 
L4:     
    .end code 
.end method 

.method public [247] : [248] 
    .attribute [240] .code stack 5 locals 4 
        .catch [14] from L0 to L415 using L418 
L0:     iload_1 
L1:     tableswitch 0 
            L314 
            L388 
            L388 
            L388 
            L388 
            L176 
            L388 
            L126 
            L388 
            L250 
            L388 
            L282 
            L388 
            L388 
            L218 
            L388 
            L388 
            L388 
            L96 
            L356 
            default : L388 

L96:    aload_2 
L97:    invokestatic [9] 
L100:   astore 4 
L102:   aload_2 
L103:   invokeinterface [39] 0 
L108:   istore 5 
L110:   aload_0 
L111:   getfield [26] 
L114:   aload 4 
L116:   iload 5 
L118:   invokeinterface [40] 0 
L123:   goto L415 
L126:   aload_2 
L127:   invokestatic [10] 
L130:   astore 4 
L132:   aload_2 
L133:   invokeinterface [39] 0 
L138:   istore 5 
L140:   aload_2 
L141:   invokeinterface [41] 0 
L146:   astore 6 
L148:   aload_2 
L149:   invokeinterface [39] 0 
L154:   istore 7 
L156:   aload_0 
L157:   getfield [26] 
L160:   aload 4 
L162:   iload 5 
L164:   aload 6 
L166:   iload 7 
L168:   invokeinterface [42] 0 
L173:   goto L415 
L176:   aload_2 
L177:   invokeinterface [41] 0 
L182:   astore 4 
L184:   aload_2 
L185:   invokeinterface [43] 0 
L190:   istore 5 
L192:   aload_2 
L193:   invokeinterface [39] 0 
L198:   istore 6 
L200:   aload_0 
L201:   getfield [26] 
L204:   aload 4 
L206:   iload 5 
L208:   iload 6 
L210:   invokeinterface [44] 0 
L215:   goto L415 
L218:   aload_2 
L219:   invokeinterface [45] 0 
L224:   lstore 4 
L226:   aload_2 
L227:   invokeinterface [39] 0 
L232:   istore 6 
L234:   aload_0 
L235:   getfield [26] 
L238:   lload 4 
L240:   iload 6 
L242:   invokeinterface [46] 0 
L247:   goto L415 
L250:   aload_2 
L251:   invokeinterface [45] 0 
L256:   lstore 4 
L258:   aload_2 
L259:   invokeinterface [39] 0 
L264:   istore 6 
L266:   aload_0 
L267:   getfield [26] 
L270:   lload 4 
L272:   iload 6 
L274:   invokeinterface [47] 0 
L279:   goto L415 
L282:   aload_2 
L283:   invokeinterface [45] 0 
L288:   lstore 4 
L290:   aload_2 
L291:   invokeinterface [39] 0 
L296:   istore 6 
L298:   aload_0 
L299:   getfield [26] 
L302:   lload 4 
L304:   iload 6 
L306:   invokeinterface [48] 0 
L311:   goto L415 
L314:   aload_2 
L315:   invokeinterface [39] 0 
L320:   istore 4 
L322:   aload_2 
L323:   invokeinterface [49] 0 
L328:   astore 5 
L330:   aload_2 
L331:   invokeinterface [39] 0 
L336:   istore 6 
L338:   aload_0 
L339:   getfield [26] 
L342:   iload 4 
L344:   aload 5 
L346:   iload 6 
L348:   invokeinterface [50] 0 
L353:   goto L415 
L356:   aload_2 
L357:   invokeinterface [49] 0 
L362:   astore 4 
L364:   aload_2 
L365:   invokeinterface [49] 0 
L370:   astore 5 
L372:   aload_0 
L373:   getfield [26] 
L376:   aload 4 
L378:   aload 5 
L380:   invokeinterface [51] 0 
L385:   goto L415 
L388:   new [52] 
L391:   dup 
L392:   new [53] 
L395:   dup 
L396:   invokespecial [35] 
L399:   ldc [13] 
L401:   invokevirtual [27] 
L404:   iload_1 
L405:   invokevirtual [28] 
L408:   invokevirtual [29] 
L411:   invokespecial [36] 
L414:   athrow 
L415:   goto L460 
L418:   astore 4 
L420:   new [52] 
L423:   dup 
L424:   new [53] 
L427:   dup 
L428:   invokespecial [35] 
L431:   ldc [15] 
L433:   invokevirtual [27] 
L436:   iload_1 
L437:   invokevirtual [28] 
L440:   ldc [16] 
L442:   invokevirtual [27] 
L445:   aload 4 
L447:   invokevirtual [30] 
L450:   invokevirtual [27] 
L453:   invokevirtual [29] 
L456:   invokespecial [36] 
L459:   athrow 
L460:   return 
L461:   nop 
L462:   nop 
L463:   nop 
L464:   
    .end code 
.end method 

.method static [249] : [250] 
    .attribute [240] .code stack 1 locals 0 
L0:     ldc [17] 
L2:     invokestatic [18] 
L5:     putstatic [34] 
L8:     iconst_0 
L9:     putstatic [33] 
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
.const [25] = Class [83] 
.const [26] = Field [84] [85] 
.const [27] = Method [86] [87] 
.const [28] = Method [88] [89] 
.const [29] = Method [90] [91] 
.const [30] = Method [92] [93] 
.const [31] = Method [94] [95] 
.const [32] = Method [96] [97] 
.const [33] = Field [98] [99] 
.const [34] = Field [100] [101] 
.const [35] = Method [102] [103] 
.const [36] = Method [104] [105] 
.const [37] = Class [106] 
.const [38] = Field [107] [108] 
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
.const [55] = Utf8 e35a4736-beb5-5ae2-b7ef-1987f635d39c 
.const [56] = Class [137] 
.const [57] = NameAndType [138] [139] 
.const [58] = Utf8 '6ffac28d-c4f7-5a0f-abce-6daaf18ea937' 
.const [59] = Utf8 'dsi.map.DSIMapViewerRouteBlock' 
.const [60] = Class [140] 
.const [61] = NameAndType [141] [142] 
.const [62] = Class [143] 
.const [63] = NameAndType [144] [145] 
.const [64] = Class [146] 
.const [65] = NameAndType [147] [148] 
.const [66] = Class [149] 
.const [67] = NameAndType [150] [151] 
.const [68] = Utf8 de/esolutions/fw/comm/core/method/MethodException 
.const [69] = Utf8 java/lang/StringBuffer 
.const [70] = Utf8 'Invalid Method Id ' 
.const [71] = Utf8 de/esolutions/fw/util/serializer/exception/SerializerException 
.const [72] = Utf8 'Deserialization failed: method=' 
.const [73] = Utf8 ', error=' 
.const [74] = Utf8 'STUB.dsi.map.DSIMapViewerRouteBlock' 
.const [75] = Class [152] 
.const [76] = NameAndType [153] [154] 
.const [77] = Utf8 de/esolutions/fw/comm/dsi/map/impl/DSIMapViewerRouteBlockReplyService 
.const [78] = Utf8 de/esolutions/fw/comm/core/AbstractReplyService 
.const [79] = Utf8 de/esolutions/fw/comm/dsi/map/impl/RouteBrowserInfoSerializer 
.const [80] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [81] = Utf8 de/esolutions/fw/comm/dsi/map/DSIMapViewerRouteBlockReply 
.const [82] = Utf8 de/esolutions/fw/comm/dsi/map/impl/PointSerializer 
.const [83] = Utf8 de/esolutions/fw/comm/core/CallContext 
.const [84] = Class [155] 
.const [85] = NameAndType [156] [157] 
.const [86] = Class [158] 
.const [87] = NameAndType [159] [160] 
.const [88] = Class [161] 
.const [89] = NameAndType [162] [163] 
.const [90] = Class [164] 
.const [91] = NameAndType [165] [166] 
.const [92] = Class [167] 
.const [93] = NameAndType [168] [169] 
.const [94] = Class [170] 
.const [95] = NameAndType [171] [172] 
.const [96] = Class [173] 
.const [97] = NameAndType [174] [175] 
.const [98] = Class [176] 
.const [99] = NameAndType [177] [178] 
.const [100] = Class [179] 
.const [101] = NameAndType [180] [181] 
.const [102] = Class [182] 
.const [103] = NameAndType [183] [184] 
.const [104] = Class [185] 
.const [105] = NameAndType [186] [187] 
.const [106] = Utf8 de/esolutions/fw/comm/core/ServiceInstanceID 
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
.const [137] = Utf8 de/esolutions/fw/comm/dsi/map/impl/DSIMapViewerRouteBlockReplyService 
.const [138] = Utf8 nextDynamicHandle 
.const [139] = Utf8 ()I 
.const [140] = Utf8 de/esolutions/fw/comm/dsi/map/impl/DSIMapViewerRouteBlockReplyService 
.const [141] = Utf8 dynamicHandle 
.const [142] = Utf8 I 
.const [143] = Utf8 de/esolutions/fw/comm/dsi/map/impl/DSIMapViewerRouteBlockReplyService 
.const [144] = Utf8 context 
.const [145] = Utf8 Lde/esolutions/fw/comm/core/CallContext; 
.const [146] = Utf8 de/esolutions/fw/comm/dsi/map/impl/RouteBrowserInfoSerializer 
.const [147] = Utf8 getOptionalRouteBrowserInfo 
.const [148] = Utf8 (Lde/esolutions/fw/util/serializer/IDeserializer;)Lorg/dsi/ifc/map/RouteBrowserInfo; 
.const [149] = Utf8 de/esolutions/fw/comm/dsi/map/impl/PointSerializer 
.const [150] = Utf8 getOptionalPoint 
.const [151] = Utf8 (Lde/esolutions/fw/util/serializer/IDeserializer;)Lorg/dsi/ifc/map/Point; 
.const [152] = Utf8 de/esolutions/fw/comm/core/CallContext 
.const [153] = Utf8 getContext 
.const [154] = Utf8 (Ljava/lang/String;)Lde/esolutions/fw/comm/core/CallContext; 
.const [155] = Utf8 de/esolutions/fw/comm/dsi/map/impl/DSIMapViewerRouteBlockReplyService 
.const [156] = Utf8 p_DSIMapViewerRouteBlockReply 
.const [157] = Utf8 Lde/esolutions/fw/comm/dsi/map/DSIMapViewerRouteBlockReply; 
.const [158] = Utf8 java/lang/StringBuffer 
.const [159] = Utf8 append 
.const [160] = Utf8 (Ljava/lang/String;)Ljava/lang/StringBuffer; 
.const [161] = Utf8 java/lang/StringBuffer 
.const [162] = Utf8 append 
.const [163] = Utf8 (I)Ljava/lang/StringBuffer; 
.const [164] = Utf8 java/lang/StringBuffer 
.const [165] = Utf8 toString 
.const [166] = Utf8 ()Ljava/lang/String; 
.const [167] = Utf8 de/esolutions/fw/util/serializer/exception/SerializerException 
.const [168] = Utf8 getMessage 
.const [169] = Utf8 ()Ljava/lang/String; 
.const [170] = Utf8 de/esolutions/fw/comm/core/ServiceInstanceID 
.const [171] = Utf8 <init> 
.const [172] = Utf8 (Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V 
.const [173] = Utf8 de/esolutions/fw/comm/core/AbstractReplyService 
.const [174] = Utf8 <init> 
.const [175] = Utf8 (Lde/esolutions/fw/comm/core/ServiceInstanceID;)V 
.const [176] = Utf8 de/esolutions/fw/comm/dsi/map/impl/DSIMapViewerRouteBlockReplyService 
.const [177] = Utf8 dynamicHandle 
.const [178] = Utf8 I 
.const [179] = Utf8 de/esolutions/fw/comm/dsi/map/impl/DSIMapViewerRouteBlockReplyService 
.const [180] = Utf8 context 
.const [181] = Utf8 Lde/esolutions/fw/comm/core/CallContext; 
.const [182] = Utf8 java/lang/StringBuffer 
.const [183] = Utf8 <init> 
.const [184] = Utf8 ()V 
.const [185] = Utf8 de/esolutions/fw/comm/core/method/MethodException 
.const [186] = Utf8 <init> 
.const [187] = Utf8 (Ljava/lang/String;)V 
.const [188] = Utf8 de/esolutions/fw/comm/dsi/map/impl/DSIMapViewerRouteBlockReplyService 
.const [189] = Utf8 p_DSIMapViewerRouteBlockReply 
.const [190] = Utf8 Lde/esolutions/fw/comm/dsi/map/DSIMapViewerRouteBlockReply; 
.const [191] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [192] = Utf8 getInt32 
.const [193] = Utf8 ()I 
.const [194] = Utf8 de/esolutions/fw/comm/dsi/map/DSIMapViewerRouteBlockReply 
.const [195] = Utf8 updateRBInfoOfSelectedSegments 
.const [196] = Utf8 (Lorg/dsi/ifc/map/RouteBrowserInfo;I)V 
.const [197] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [198] = Utf8 getOptionalInt64VarArray 
.const [199] = Utf8 ()[J 
.const [200] = Utf8 de/esolutions/fw/comm/dsi/map/DSIMapViewerRouteBlockReply 
.const [201] = Utf8 pickSegmentUidsInScreenSpaceResult 
.const [202] = Utf8 (Lorg/dsi/ifc/map/Point;I[JI)V 
.const [203] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [204] = Utf8 getBool 
.const [205] = Utf8 ()Z 
.const [206] = Utf8 de/esolutions/fw/comm/dsi/map/DSIMapViewerRouteBlockReply 
.const [207] = Utf8 highLightSegmentUidsInMapResult 
.const [208] = Utf8 ([JZI)V 
.const [209] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [210] = Utf8 getInt64 
.const [211] = Utf8 ()J 
.const [212] = Utf8 de/esolutions/fw/comm/dsi/map/DSIMapViewerRouteBlockReply 
.const [213] = Utf8 rBStartOfSelectionResult 
.const [214] = Utf8 (JI)V 
.const [215] = Utf8 de/esolutions/fw/comm/dsi/map/DSIMapViewerRouteBlockReply 
.const [216] = Utf8 rBMarkNextSegmentResult 
.const [217] = Utf8 (JI)V 
.const [218] = Utf8 de/esolutions/fw/comm/dsi/map/DSIMapViewerRouteBlockReply 
.const [219] = Utf8 rBMarkPreviousSegmentResult 
.const [220] = Utf8 (JI)V 
.const [221] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [222] = Utf8 getOptionalString 
.const [223] = Utf8 ()Ljava/lang/String; 
.const [224] = Utf8 de/esolutions/fw/comm/dsi/map/DSIMapViewerRouteBlockReply 
.const [225] = Utf8 asyncException 
.const [226] = Utf8 (ILjava/lang/String;I)V 
.const [227] = Utf8 de/esolutions/fw/comm/dsi/map/DSIMapViewerRouteBlockReply 
.const [228] = Utf8 yyIndication 
.const [229] = Utf8 (Ljava/lang/String;Ljava/lang/String;)V 
.const [230] = Utf8 de/esolutions/fw/comm/dsi/map/impl/DSIMapViewerRouteBlockReplyService 
.const [231] = Class [230] 
.const [232] = Utf8 de/esolutions/fw/comm/core/AbstractReplyService 
.const [233] = Class [232] 
.const [234] = Utf8 context 
.const [235] = Utf8 Lde/esolutions/fw/comm/core/CallContext; 
.const [236] = Utf8 dynamicHandle 
.const [237] = Utf8 I 
.const [238] = Utf8 p_DSIMapViewerRouteBlockReply 
.const [239] = Utf8 Lde/esolutions/fw/comm/dsi/map/DSIMapViewerRouteBlockReply; 
.const [240] = Utf8 Code 
.const [241] = Utf8 <init> 
.const [242] = Utf8 (Lde/esolutions/fw/comm/dsi/map/DSIMapViewerRouteBlockReply;)V 
.const [243] = Utf8 nextDynamicHandle 
.const [244] = Utf8 ()I 
.const [245] = Utf8 getCallContext 
.const [246] = Utf8 ()Lde/esolutions/fw/comm/core/CallContext; 
.const [247] = Utf8 handleCallMethod 
.const [248] = Utf8 (SLde/esolutions/fw/util/serializer/IDeserializer;Lde/esolutions/fw/comm/core/IProxyFrontend;)V 
.const [249] = Utf8 <clinit> 
.const [250] = Utf8 ()V 
.end class 
