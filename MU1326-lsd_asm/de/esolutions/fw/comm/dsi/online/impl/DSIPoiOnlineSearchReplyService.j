.version 50 0 
.class public super [207] 
.super [209] 
.field private static final [210] [211] 
.field private static [212] [213] 
.field private [214] [215] 

.method public [217] : [218] 
    .attribute [216] .code stack 7 locals 0 
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

.method private static synchronized [219] : [220] 
    .attribute [216] .code stack 2 locals 1 
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

.method public [221] : [222] 
    .attribute [216] .code stack 1 locals 0 
L0:     getstatic [8] 
L3:     areturn 
L4:     
    .end code 
.end method 

.method public [223] : [224] 
    .attribute [216] .code stack 6 locals 5 
        .catch [14] from L0 to L347 using L350 
L0:     iload_1 
L1:     tableswitch 21 
            L246 
            L320 
            L114 
            L320 
            L288 
            L320 
            L320 
            L72 
            L156 
            L320 
            L320 
            L320 
            L320 
            L216 
            default : L320 

L72:    aload_2 
L73:    invokeinterface [39] 0 
L78:    istore 4 
L80:    aload_2 
L81:    invokeinterface [39] 0 
L86:    istore 5 
L88:    aload_2 
L89:    invokeinterface [39] 0 
L94:    istore 6 
L96:    aload_0 
L97:    getfield [26] 
L100:   iload 4 
L102:   iload 5 
L104:   iload 6 
L106:   invokeinterface [40] 0 
L111:   goto L347 
L114:   aload_2 
L115:   invokeinterface [39] 0 
L120:   istore 4 
L122:   aload_2 
L123:   invokeinterface [41] 0 
L128:   astore 5 
L130:   aload_2 
L131:   invokeinterface [42] 0 
L136:   astore 6 
L138:   aload_0 
L139:   getfield [26] 
L142:   iload 4 
L144:   aload 5 
L146:   aload 6 
L148:   invokeinterface [43] 0 
L153:   goto L347 
L156:   aload_2 
L157:   invokeinterface [39] 0 
L162:   istore 4 
L164:   aload_2 
L165:   invokeinterface [39] 0 
L170:   istore 5 
L172:   aload_2 
L173:   invokestatic [9] 
L176:   astore 6 
L178:   aload_2 
L179:   invokeinterface [39] 0 
L184:   istore 7 
L186:   aload_2 
L187:   invokeinterface [39] 0 
L192:   istore 8 
L194:   aload_0 
L195:   getfield [26] 
L198:   iload 4 
L200:   iload 5 
L202:   aload 6 
L204:   iload 7 
L206:   iload 8 
L208:   invokeinterface [44] 0 
L213:   goto L347 
L216:   aload_2 
L217:   invokeinterface [39] 0 
L222:   istore 4 
L224:   aload_2 
L225:   invokestatic [10] 
L228:   astore 5 
L230:   aload_0 
L231:   getfield [26] 
L234:   iload 4 
L236:   aload 5 
L238:   invokeinterface [45] 0 
L243:   goto L347 
L246:   aload_2 
L247:   invokeinterface [39] 0 
L252:   istore 4 
L254:   aload_2 
L255:   invokeinterface [41] 0 
L260:   astore 5 
L262:   aload_2 
L263:   invokeinterface [39] 0 
L268:   istore 6 
L270:   aload_0 
L271:   getfield [26] 
L274:   iload 4 
L276:   aload 5 
L278:   iload 6 
L280:   invokeinterface [46] 0 
L285:   goto L347 
L288:   aload_2 
L289:   invokeinterface [41] 0 
L294:   astore 4 
L296:   aload_2 
L297:   invokeinterface [41] 0 
L302:   astore 5 
L304:   aload_0 
L305:   getfield [26] 
L308:   aload 4 
L310:   aload 5 
L312:   invokeinterface [47] 0 
L317:   goto L347 
L320:   new [48] 
L323:   dup 
L324:   new [49] 
L327:   dup 
L328:   invokespecial [35] 
L331:   ldc [13] 
L333:   invokevirtual [27] 
L336:   iload_1 
L337:   invokevirtual [28] 
L340:   invokevirtual [29] 
L343:   invokespecial [36] 
L346:   athrow 
L347:   goto L392 
L350:   astore 4 
L352:   new [48] 
L355:   dup 
L356:   new [49] 
L359:   dup 
L360:   invokespecial [35] 
L363:   ldc [15] 
L365:   invokevirtual [27] 
L368:   iload_1 
L369:   invokevirtual [28] 
L372:   ldc [16] 
L374:   invokevirtual [27] 
L377:   aload 4 
L379:   invokevirtual [30] 
L382:   invokevirtual [27] 
L385:   invokevirtual [29] 
L388:   invokespecial [36] 
L391:   athrow 
L392:   return 
L393:   nop 
L394:   nop 
L395:   nop 
L396:   
    .end code 
.end method 

.method static [225] : [226] 
    .attribute [216] .code stack 1 locals 0 
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
.const [2] = Class [50] 
.const [3] = String [51] 
.const [4] = Method [52] [53] 
.const [5] = String [54] 
.const [6] = String [55] 
.const [7] = Field [56] [57] 
.const [8] = Field [58] [59] 
.const [9] = Method [60] [61] 
.const [10] = Method [62] [63] 
.const [11] = Class [64] 
.const [12] = Class [65] 
.const [13] = String [66] 
.const [14] = Class [67] 
.const [15] = String [68] 
.const [16] = String [69] 
.const [17] = String [70] 
.const [18] = Method [71] [72] 
.const [19] = Class [73] 
.const [20] = Class [74] 
.const [21] = Class [75] 
.const [22] = Class [76] 
.const [23] = Class [77] 
.const [24] = Class [78] 
.const [25] = Class [79] 
.const [26] = Field [80] [81] 
.const [27] = Method [82] [83] 
.const [28] = Method [84] [85] 
.const [29] = Method [86] [87] 
.const [30] = Method [88] [89] 
.const [31] = Method [90] [91] 
.const [32] = Method [92] [93] 
.const [33] = Field [94] [95] 
.const [34] = Field [96] [97] 
.const [35] = Method [98] [99] 
.const [36] = Method [100] [101] 
.const [37] = Class [102] 
.const [38] = Field [103] [104] 
.const [39] = InterfaceMethod [105] [106] 
.const [40] = InterfaceMethod [107] [108] 
.const [41] = InterfaceMethod [109] [110] 
.const [42] = InterfaceMethod [111] [112] 
.const [43] = InterfaceMethod [113] [114] 
.const [44] = InterfaceMethod [115] [116] 
.const [45] = InterfaceMethod [117] [118] 
.const [46] = InterfaceMethod [119] [120] 
.const [47] = InterfaceMethod [121] [122] 
.const [48] = Class [123] 
.const [49] = Class [124] 
.const [50] = Utf8 de/esolutions/fw/comm/core/ServiceInstanceID 
.const [51] = Utf8 '66cd10bd-7fcb-5257-a3b3-fb17ef89a84c' 
.const [52] = Class [125] 
.const [53] = NameAndType [126] [127] 
.const [54] = Utf8 '570d8158-1fca-541c-bb86-991022902795' 
.const [55] = Utf8 'dsi.online.DSIPoiOnlineSearch' 
.const [56] = Class [128] 
.const [57] = NameAndType [129] [130] 
.const [58] = Class [131] 
.const [59] = NameAndType [132] [133] 
.const [60] = Class [134] 
.const [61] = NameAndType [135] [136] 
.const [62] = Class [137] 
.const [63] = NameAndType [138] [139] 
.const [64] = Utf8 de/esolutions/fw/comm/core/method/MethodException 
.const [65] = Utf8 java/lang/StringBuffer 
.const [66] = Utf8 'Invalid Method Id ' 
.const [67] = Utf8 de/esolutions/fw/util/serializer/exception/SerializerException 
.const [68] = Utf8 'Deserialization failed: method=' 
.const [69] = Utf8 ', error=' 
.const [70] = Utf8 'STUB.dsi.online.DSIPoiOnlineSearch' 
.const [71] = Class [140] 
.const [72] = NameAndType [141] [142] 
.const [73] = Utf8 de/esolutions/fw/comm/dsi/online/impl/DSIPoiOnlineSearchReplyService 
.const [74] = Utf8 de/esolutions/fw/comm/core/AbstractReplyService 
.const [75] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [76] = Utf8 de/esolutions/fw/comm/dsi/online/DSIPoiOnlineSearchReply 
.const [77] = Utf8 de/esolutions/fw/comm/dsi/online/impl/PoiOnlineSearchValuelistSerializer 
.const [78] = Utf8 de/esolutions/fw/comm/dsi/online/impl/OSRServiceStateSerializer 
.const [79] = Utf8 de/esolutions/fw/comm/core/CallContext 
.const [80] = Class [143] 
.const [81] = NameAndType [144] [145] 
.const [82] = Class [146] 
.const [83] = NameAndType [147] [148] 
.const [84] = Class [149] 
.const [85] = NameAndType [150] [151] 
.const [86] = Class [152] 
.const [87] = NameAndType [153] [154] 
.const [88] = Class [155] 
.const [89] = NameAndType [156] [157] 
.const [90] = Class [158] 
.const [91] = NameAndType [159] [160] 
.const [92] = Class [161] 
.const [93] = NameAndType [162] [163] 
.const [94] = Class [164] 
.const [95] = NameAndType [165] [166] 
.const [96] = Class [167] 
.const [97] = NameAndType [168] [169] 
.const [98] = Class [170] 
.const [99] = NameAndType [171] [172] 
.const [100] = Class [173] 
.const [101] = NameAndType [174] [175] 
.const [102] = Utf8 de/esolutions/fw/comm/core/ServiceInstanceID 
.const [103] = Class [176] 
.const [104] = NameAndType [177] [178] 
.const [105] = Class [179] 
.const [106] = NameAndType [180] [181] 
.const [107] = Class [182] 
.const [108] = NameAndType [183] [184] 
.const [109] = Class [185] 
.const [110] = NameAndType [186] [187] 
.const [111] = Class [188] 
.const [112] = NameAndType [189] [190] 
.const [113] = Class [191] 
.const [114] = NameAndType [192] [193] 
.const [115] = Class [194] 
.const [116] = NameAndType [195] [196] 
.const [117] = Class [197] 
.const [118] = NameAndType [198] [199] 
.const [119] = Class [200] 
.const [120] = NameAndType [201] [202] 
.const [121] = Class [203] 
.const [122] = NameAndType [204] [205] 
.const [123] = Utf8 de/esolutions/fw/comm/core/method/MethodException 
.const [124] = Utf8 java/lang/StringBuffer 
.const [125] = Utf8 de/esolutions/fw/comm/dsi/online/impl/DSIPoiOnlineSearchReplyService 
.const [126] = Utf8 nextDynamicHandle 
.const [127] = Utf8 ()I 
.const [128] = Utf8 de/esolutions/fw/comm/dsi/online/impl/DSIPoiOnlineSearchReplyService 
.const [129] = Utf8 dynamicHandle 
.const [130] = Utf8 I 
.const [131] = Utf8 de/esolutions/fw/comm/dsi/online/impl/DSIPoiOnlineSearchReplyService 
.const [132] = Utf8 context 
.const [133] = Utf8 Lde/esolutions/fw/comm/core/CallContext; 
.const [134] = Utf8 de/esolutions/fw/comm/dsi/online/impl/PoiOnlineSearchValuelistSerializer 
.const [135] = Utf8 getOptionalPoiOnlineSearchValuelist 
.const [136] = Utf8 (Lde/esolutions/fw/util/serializer/IDeserializer;)Lorg/dsi/ifc/online/PoiOnlineSearchValuelist; 
.const [137] = Utf8 de/esolutions/fw/comm/dsi/online/impl/OSRServiceStateSerializer 
.const [138] = Utf8 getOptionalOSRServiceState 
.const [139] = Utf8 (Lde/esolutions/fw/util/serializer/IDeserializer;)Lorg/dsi/ifc/online/OSRServiceState; 
.const [140] = Utf8 de/esolutions/fw/comm/core/CallContext 
.const [141] = Utf8 getContext 
.const [142] = Utf8 (Ljava/lang/String;)Lde/esolutions/fw/comm/core/CallContext; 
.const [143] = Utf8 de/esolutions/fw/comm/dsi/online/impl/DSIPoiOnlineSearchReplyService 
.const [144] = Utf8 p_DSIPoiOnlineSearchReply 
.const [145] = Utf8 Lde/esolutions/fw/comm/dsi/online/DSIPoiOnlineSearchReply; 
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
.const [161] = Utf8 de/esolutions/fw/comm/core/AbstractReplyService 
.const [162] = Utf8 <init> 
.const [163] = Utf8 (Lde/esolutions/fw/comm/core/ServiceInstanceID;)V 
.const [164] = Utf8 de/esolutions/fw/comm/dsi/online/impl/DSIPoiOnlineSearchReplyService 
.const [165] = Utf8 dynamicHandle 
.const [166] = Utf8 I 
.const [167] = Utf8 de/esolutions/fw/comm/dsi/online/impl/DSIPoiOnlineSearchReplyService 
.const [168] = Utf8 context 
.const [169] = Utf8 Lde/esolutions/fw/comm/core/CallContext; 
.const [170] = Utf8 java/lang/StringBuffer 
.const [171] = Utf8 <init> 
.const [172] = Utf8 ()V 
.const [173] = Utf8 de/esolutions/fw/comm/core/method/MethodException 
.const [174] = Utf8 <init> 
.const [175] = Utf8 (Ljava/lang/String;)V 
.const [176] = Utf8 de/esolutions/fw/comm/dsi/online/impl/DSIPoiOnlineSearchReplyService 
.const [177] = Utf8 p_DSIPoiOnlineSearchReply 
.const [178] = Utf8 Lde/esolutions/fw/comm/dsi/online/DSIPoiOnlineSearchReply; 
.const [179] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [180] = Utf8 getInt32 
.const [181] = Utf8 ()I 
.const [182] = Utf8 de/esolutions/fw/comm/dsi/online/DSIPoiOnlineSearchReply 
.const [183] = Utf8 poiResult 
.const [184] = Utf8 (III)V 
.const [185] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [186] = Utf8 getOptionalString 
.const [187] = Utf8 ()Ljava/lang/String; 
.const [188] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [189] = Utf8 getOptionalStringVarArray 
.const [190] = Utf8 ()[Ljava/lang/String; 
.const [191] = Utf8 de/esolutions/fw/comm/dsi/online/DSIPoiOnlineSearchReply 
.const [192] = Utf8 poiSpellingSuggestion 
.const [193] = Utf8 (ILjava/lang/String;[Ljava/lang/String;)V 
.const [194] = Utf8 de/esolutions/fw/comm/dsi/online/DSIPoiOnlineSearchReply 
.const [195] = Utf8 poiValueList 
.const [196] = Utf8 (IILorg/dsi/ifc/online/PoiOnlineSearchValuelist;II)V 
.const [197] = Utf8 de/esolutions/fw/comm/dsi/online/DSIPoiOnlineSearchReply 
.const [198] = Utf8 precheckDynamicPOICategoryResponse 
.const [199] = Utf8 (ILorg/dsi/ifc/online/OSRServiceState;)V 
.const [200] = Utf8 de/esolutions/fw/comm/dsi/online/DSIPoiOnlineSearchReply 
.const [201] = Utf8 asyncException 
.const [202] = Utf8 (ILjava/lang/String;I)V 
.const [203] = Utf8 de/esolutions/fw/comm/dsi/online/DSIPoiOnlineSearchReply 
.const [204] = Utf8 yyIndication 
.const [205] = Utf8 (Ljava/lang/String;Ljava/lang/String;)V 
.const [206] = Utf8 de/esolutions/fw/comm/dsi/online/impl/DSIPoiOnlineSearchReplyService 
.const [207] = Class [206] 
.const [208] = Utf8 de/esolutions/fw/comm/core/AbstractReplyService 
.const [209] = Class [208] 
.const [210] = Utf8 context 
.const [211] = Utf8 Lde/esolutions/fw/comm/core/CallContext; 
.const [212] = Utf8 dynamicHandle 
.const [213] = Utf8 I 
.const [214] = Utf8 p_DSIPoiOnlineSearchReply 
.const [215] = Utf8 Lde/esolutions/fw/comm/dsi/online/DSIPoiOnlineSearchReply; 
.const [216] = Utf8 Code 
.const [217] = Utf8 <init> 
.const [218] = Utf8 (Lde/esolutions/fw/comm/dsi/online/DSIPoiOnlineSearchReply;)V 
.const [219] = Utf8 nextDynamicHandle 
.const [220] = Utf8 ()I 
.const [221] = Utf8 getCallContext 
.const [222] = Utf8 ()Lde/esolutions/fw/comm/core/CallContext; 
.const [223] = Utf8 handleCallMethod 
.const [224] = Utf8 (SLde/esolutions/fw/util/serializer/IDeserializer;Lde/esolutions/fw/comm/core/IProxyFrontend;)V 
.const [225] = Utf8 <clinit> 
.const [226] = Utf8 ()V 
.end class 
