.version 50 0 
.class public super [213] 
.super [215] 
.field private static final [216] [217] 
.field private static [218] [219] 
.field private [220] [221] 

.method public [223] : [224] 
    .attribute [222] .code stack 7 locals 0 
L0:     aload_0 
L1:     new [35] 
L4:     dup 
L5:     ldc [3] 
L7:     invokestatic [4] 
L10:    ldc [5] 
L12:    ldc [6] 
L14:    invokespecial [29] 
L17:    invokespecial [30] 
L20:    aload_0 
L21:    aload_1 
L22:    putfield [36] 
L25:    return 
L26:    nop 
L27:    nop 
L28:    
    .end code 
.end method 

.method private static synchronized [225] : [226] 
    .attribute [222] .code stack 2 locals 1 
L0:     getstatic [7] 
L3:     iconst_1 
L4:     iadd 
L5:     dup 
L6:     putstatic [31] 
L9:     istore_0 
L10:    iload_0 
L11:    areturn 
L12:    
    .end code 
.end method 

.method public [227] : [228] 
    .attribute [222] .code stack 1 locals 0 
L0:     getstatic [8] 
L3:     areturn 
L4:     
    .end code 
.end method 

.method public [229] : [230] 
    .attribute [222] .code stack 5 locals 7 
        .catch [14] from L0 to L391 using L394 
L0:     iload_1 
L1:     tableswitch 0 
            L206 
            L154 
            L364 
            L364 
            L322 
            L364 
            L102 
            L364 
            L364 
            L364 
            L60 
            default : L364 

L60:    aload_2 
L61:    invokeinterface [37] 0 
L66:    astore 7 
L68:    aload_2 
L69:    invokeinterface [37] 0 
L74:    astore 8 
L76:    aload_2 
L77:    invokeinterface [38] 0 
L82:    astore 9 
L84:    aload_0 
L85:    getfield [24] 
L88:    aload 7 
L90:    aload 8 
L92:    aload 9 
L94:    invokeinterface [39] 0 
L99:    goto L391 
L102:   aload_2 
L103:   invokeinterface [37] 0 
L108:   astore 7 
L110:   aload_2 
L111:   invokeinterface [37] 0 
L116:   astore 8 
L118:   aload_2 
L119:   invokeinterface [40] 0 
L124:   astore 9 
L126:   aload_2 
L127:   invokeinterface [38] 0 
L132:   astore 10 
L134:   aload_0 
L135:   getfield [24] 
L138:   aload 7 
L140:   aload 8 
L142:   aload 9 
L144:   aload 10 
L146:   invokeinterface [41] 0 
L151:   goto L391 
L154:   aload_2 
L155:   invokeinterface [37] 0 
L160:   astore 7 
L162:   aload_2 
L163:   invokeinterface [37] 0 
L168:   astore 8 
L170:   aload_2 
L171:   invokeinterface [42] 0 
L176:   astore 9 
L178:   aload_2 
L179:   invokeinterface [38] 0 
L184:   astore 10 
L186:   aload_0 
L187:   getfield [24] 
L190:   aload 7 
L192:   aload 8 
L194:   aload 9 
L196:   aload 10 
L198:   invokeinterface [43] 0 
L203:   goto L391 
L206:   aload_2 
L207:   invokeinterface [37] 0 
L212:   astore 7 
L214:   aload_2 
L215:   invokeinterface [37] 0 
L220:   astore 8 
L222:   aload_2 
L223:   invokeinterface [44] 0 
L228:   ifne L235 
L231:   iconst_1 
L232:   goto L236 
L235:   iconst_0 
L236:   istore 4 
L238:   aconst_null 
L239:   checkcast [9] 
L242:   astore 9 
L244:   iload 4 
L246:   ifeq L294 
L249:   aload_2 
L250:   invokeinterface [45] 0 
L255:   lstore 5 
L257:   lload 5 
L259:   l2i 
L260:   anewarray [10] 
L263:   astore 9 
L265:   iconst_0 
L266:   istore 10 
L268:   iload 10 
L270:   i2l 
L271:   lload 5 
L273:   lcmp 
L274:   ifge L294 
L277:   aload 9 
L279:   iload 10 
L281:   aload_2 
L282:   invokeinterface [46] 0 
L287:   aastore 
L288:   iinc 10 1 
L291:   goto L268 
L294:   aload_2 
L295:   invokeinterface [38] 0 
L300:   astore 10 
L302:   aload_0 
L303:   getfield [24] 
L306:   aload 7 
L308:   aload 8 
L310:   aload 9 
L312:   aload 10 
L314:   invokeinterface [47] 0 
L319:   goto L391 
L322:   aload_2 
L323:   invokeinterface [37] 0 
L328:   astore 7 
L330:   aload_2 
L331:   invokeinterface [37] 0 
L336:   astore 8 
L338:   aload_2 
L339:   invokeinterface [38] 0 
L344:   astore 9 
L346:   aload_0 
L347:   getfield [24] 
L350:   aload 7 
L352:   aload 8 
L354:   aload 9 
L356:   invokeinterface [48] 0 
L361:   goto L391 
L364:   new [49] 
L367:   dup 
L368:   new [50] 
L371:   dup 
L372:   invokespecial [33] 
L375:   ldc [13] 
L377:   invokevirtual [25] 
L380:   iload_1 
L381:   invokevirtual [26] 
L384:   invokevirtual [27] 
L387:   invokespecial [34] 
L390:   athrow 
L391:   goto L436 
L394:   astore 4 
L396:   new [49] 
L399:   dup 
L400:   new [50] 
L403:   dup 
L404:   invokespecial [33] 
L407:   ldc [15] 
L409:   invokevirtual [25] 
L412:   iload_1 
L413:   invokevirtual [26] 
L416:   ldc [16] 
L418:   invokevirtual [25] 
L421:   aload 4 
L423:   invokevirtual [28] 
L426:   invokevirtual [25] 
L429:   invokevirtual [27] 
L432:   invokespecial [34] 
L435:   athrow 
L436:   return 
L437:   nop 
L438:   nop 
L439:   nop 
L440:   
    .end code 
.end method 

.method static [231] : [232] 
    .attribute [222] .code stack 1 locals 0 
L0:     ldc [17] 
L2:     invokestatic [18] 
L5:     putstatic [32] 
L8:     iconst_0 
L9:     putstatic [31] 
L12:    return 
L13:    nop 
L14:    nop 
L15:    nop 
L16:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [51] 
.const [3] = String [52] 
.const [4] = Method [53] [54] 
.const [5] = String [55] 
.const [6] = String [56] 
.const [7] = Field [57] [58] 
.const [8] = Field [59] [60] 
.const [9] = Class [61] 
.const [10] = Class [62] 
.const [11] = Class [63] 
.const [12] = Class [64] 
.const [13] = String [65] 
.const [14] = Class [66] 
.const [15] = String [67] 
.const [16] = String [68] 
.const [17] = String [69] 
.const [18] = Method [70] [71] 
.const [19] = Class [72] 
.const [20] = Class [73] 
.const [21] = Class [74] 
.const [22] = Class [75] 
.const [23] = Class [76] 
.const [24] = Field [77] [78] 
.const [25] = Method [79] [80] 
.const [26] = Method [81] [82] 
.const [27] = Method [83] [84] 
.const [28] = Method [85] [86] 
.const [29] = Method [87] [88] 
.const [30] = Method [89] [90] 
.const [31] = Field [91] [92] 
.const [32] = Field [93] [94] 
.const [33] = Method [95] [96] 
.const [34] = Method [97] [98] 
.const [35] = Class [99] 
.const [36] = Field [100] [101] 
.const [37] = InterfaceMethod [102] [103] 
.const [38] = InterfaceMethod [104] [105] 
.const [39] = InterfaceMethod [106] [107] 
.const [40] = InterfaceMethod [108] [109] 
.const [41] = InterfaceMethod [110] [111] 
.const [42] = InterfaceMethod [112] [113] 
.const [43] = InterfaceMethod [114] [115] 
.const [44] = InterfaceMethod [116] [117] 
.const [45] = InterfaceMethod [118] [119] 
.const [46] = InterfaceMethod [120] [121] 
.const [47] = InterfaceMethod [122] [123] 
.const [48] = InterfaceMethod [124] [125] 
.const [49] = Class [126] 
.const [50] = Class [127] 
.const [51] = Utf8 de/esolutions/fw/comm/core/ServiceInstanceID 
.const [52] = Utf8 f423654f-fed2-59d3-be18-59e9a9b2d05f 
.const [53] = Class [128] 
.const [54] = NameAndType [129] [130] 
.const [55] = Utf8 e5e426dc-4f2a-56e5-9b1b-8beaf406be7a 
.const [56] = Utf8 'asi.persistence.Attributes' 
.const [57] = Class [131] 
.const [58] = NameAndType [132] [133] 
.const [59] = Class [134] 
.const [60] = NameAndType [135] [136] 
.const [61] = Utf8 [[S 
.const [62] = Utf8 [S 
.const [63] = Utf8 de/esolutions/fw/comm/core/method/MethodException 
.const [64] = Utf8 java/lang/StringBuffer 
.const [65] = Utf8 'Invalid Method Id ' 
.const [66] = Utf8 de/esolutions/fw/util/serializer/exception/SerializerException 
.const [67] = Utf8 'Deserialization failed: method=' 
.const [68] = Utf8 ', error=' 
.const [69] = Utf8 'STUB.asi.persistence.Attributes' 
.const [70] = Class [137] 
.const [71] = NameAndType [138] [139] 
.const [72] = Utf8 de/esolutions/fw/comm/asi/persistence/impl/AttributesReplyService 
.const [73] = Utf8 de/esolutions/fw/comm/core/AbstractReplyService 
.const [74] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [75] = Utf8 de/esolutions/fw/comm/asi/persistence/AttributesReply 
.const [76] = Utf8 de/esolutions/fw/comm/core/CallContext 
.const [77] = Class [140] 
.const [78] = NameAndType [141] [142] 
.const [79] = Class [143] 
.const [80] = NameAndType [144] [145] 
.const [81] = Class [146] 
.const [82] = NameAndType [147] [148] 
.const [83] = Class [149] 
.const [84] = NameAndType [150] [151] 
.const [85] = Class [152] 
.const [86] = NameAndType [153] [154] 
.const [87] = Class [155] 
.const [88] = NameAndType [156] [157] 
.const [89] = Class [158] 
.const [90] = NameAndType [159] [160] 
.const [91] = Class [161] 
.const [92] = NameAndType [162] [163] 
.const [93] = Class [164] 
.const [94] = NameAndType [165] [166] 
.const [95] = Class [167] 
.const [96] = NameAndType [168] [169] 
.const [97] = Class [170] 
.const [98] = NameAndType [171] [172] 
.const [99] = Utf8 de/esolutions/fw/comm/core/ServiceInstanceID 
.const [100] = Class [173] 
.const [101] = NameAndType [174] [175] 
.const [102] = Class [176] 
.const [103] = NameAndType [177] [178] 
.const [104] = Class [179] 
.const [105] = NameAndType [180] [181] 
.const [106] = Class [182] 
.const [107] = NameAndType [183] [184] 
.const [108] = Class [185] 
.const [109] = NameAndType [186] [187] 
.const [110] = Class [188] 
.const [111] = NameAndType [189] [190] 
.const [112] = Class [191] 
.const [113] = NameAndType [192] [193] 
.const [114] = Class [194] 
.const [115] = NameAndType [195] [196] 
.const [116] = Class [197] 
.const [117] = NameAndType [198] [199] 
.const [118] = Class [200] 
.const [119] = NameAndType [201] [202] 
.const [120] = Class [203] 
.const [121] = NameAndType [204] [205] 
.const [122] = Class [206] 
.const [123] = NameAndType [207] [208] 
.const [124] = Class [209] 
.const [125] = NameAndType [210] [211] 
.const [126] = Utf8 de/esolutions/fw/comm/core/method/MethodException 
.const [127] = Utf8 java/lang/StringBuffer 
.const [128] = Utf8 de/esolutions/fw/comm/asi/persistence/impl/AttributesReplyService 
.const [129] = Utf8 nextDynamicHandle 
.const [130] = Utf8 ()I 
.const [131] = Utf8 de/esolutions/fw/comm/asi/persistence/impl/AttributesReplyService 
.const [132] = Utf8 dynamicHandle 
.const [133] = Utf8 I 
.const [134] = Utf8 de/esolutions/fw/comm/asi/persistence/impl/AttributesReplyService 
.const [135] = Utf8 context 
.const [136] = Utf8 Lde/esolutions/fw/comm/core/CallContext; 
.const [137] = Utf8 de/esolutions/fw/comm/core/CallContext 
.const [138] = Utf8 getContext 
.const [139] = Utf8 (Ljava/lang/String;)Lde/esolutions/fw/comm/core/CallContext; 
.const [140] = Utf8 de/esolutions/fw/comm/asi/persistence/impl/AttributesReplyService 
.const [141] = Utf8 p_AttributesReply 
.const [142] = Utf8 Lde/esolutions/fw/comm/asi/persistence/AttributesReply; 
.const [143] = Utf8 java/lang/StringBuffer 
.const [144] = Utf8 append 
.const [145] = Utf8 (Ljava/lang/String;)Ljava/lang/StringBuffer; 
.const [146] = Utf8 java/lang/StringBuffer 
.const [147] = Utf8 append 
.const [148] = Utf8 (I)Ljava/lang/StringBuffer; 
.const [149] = Utf8 java/lang/StringBuffer 
.const [150] = Utf8 toString 
.const [151] = Utf8 ()Ljava/lang/String; 
.const [152] = Utf8 de/esolutions/fw/util/serializer/exception/SerializerException 
.const [153] = Utf8 getMessage 
.const [154] = Utf8 ()Ljava/lang/String; 
.const [155] = Utf8 de/esolutions/fw/comm/core/ServiceInstanceID 
.const [156] = Utf8 <init> 
.const [157] = Utf8 (Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V 
.const [158] = Utf8 de/esolutions/fw/comm/core/AbstractReplyService 
.const [159] = Utf8 <init> 
.const [160] = Utf8 (Lde/esolutions/fw/comm/core/ServiceInstanceID;)V 
.const [161] = Utf8 de/esolutions/fw/comm/asi/persistence/impl/AttributesReplyService 
.const [162] = Utf8 dynamicHandle 
.const [163] = Utf8 I 
.const [164] = Utf8 de/esolutions/fw/comm/asi/persistence/impl/AttributesReplyService 
.const [165] = Utf8 context 
.const [166] = Utf8 Lde/esolutions/fw/comm/core/CallContext; 
.const [167] = Utf8 java/lang/StringBuffer 
.const [168] = Utf8 <init> 
.const [169] = Utf8 ()V 
.const [170] = Utf8 de/esolutions/fw/comm/core/method/MethodException 
.const [171] = Utf8 <init> 
.const [172] = Utf8 (Ljava/lang/String;)V 
.const [173] = Utf8 de/esolutions/fw/comm/asi/persistence/impl/AttributesReplyService 
.const [174] = Utf8 p_AttributesReply 
.const [175] = Utf8 Lde/esolutions/fw/comm/asi/persistence/AttributesReply; 
.const [176] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [177] = Utf8 getOptionalUInt32VarArray 
.const [178] = Utf8 ()[J 
.const [179] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [180] = Utf8 getOptionalEnumVarArray 
.const [181] = Utf8 ()[I 
.const [182] = Utf8 de/esolutions/fw/comm/asi/persistence/AttributesReply 
.const [183] = Utf8 unsubscribeResults 
.const [184] = Utf8 ([J[J[I)V 
.const [185] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [186] = Utf8 getOptionalStringVarArray 
.const [187] = Utf8 ()[Ljava/lang/String; 
.const [188] = Utf8 de/esolutions/fw/comm/asi/persistence/AttributesReply 
.const [189] = Utf8 stringValues 
.const [190] = Utf8 ([J[J[Ljava/lang/String;[I)V 
.const [191] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [192] = Utf8 getOptionalInt32VarArray 
.const [193] = Utf8 ()[I 
.const [194] = Utf8 de/esolutions/fw/comm/asi/persistence/AttributesReply 
.const [195] = Utf8 intValues 
.const [196] = Utf8 ([J[J[I[I)V 
.const [197] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [198] = Utf8 getBool 
.const [199] = Utf8 ()Z 
.const [200] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [201] = Utf8 getUInt32 
.const [202] = Utf8 ()J 
.const [203] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [204] = Utf8 getOptionalUInt8VarArray 
.const [205] = Utf8 ()[S 
.const [206] = Utf8 de/esolutions/fw/comm/asi/persistence/AttributesReply 
.const [207] = Utf8 blobValues 
.const [208] = Utf8 ([J[J[[S[I)V 
.const [209] = Utf8 de/esolutions/fw/comm/asi/persistence/AttributesReply 
.const [210] = Utf8 putResults 
.const [211] = Utf8 ([J[J[I)V 
.const [212] = Utf8 de/esolutions/fw/comm/asi/persistence/impl/AttributesReplyService 
.const [213] = Class [212] 
.const [214] = Utf8 de/esolutions/fw/comm/core/AbstractReplyService 
.const [215] = Class [214] 
.const [216] = Utf8 context 
.const [217] = Utf8 Lde/esolutions/fw/comm/core/CallContext; 
.const [218] = Utf8 dynamicHandle 
.const [219] = Utf8 I 
.const [220] = Utf8 p_AttributesReply 
.const [221] = Utf8 Lde/esolutions/fw/comm/asi/persistence/AttributesReply; 
.const [222] = Utf8 Code 
.const [223] = Utf8 <init> 
.const [224] = Utf8 (Lde/esolutions/fw/comm/asi/persistence/AttributesReply;)V 
.const [225] = Utf8 nextDynamicHandle 
.const [226] = Utf8 ()I 
.const [227] = Utf8 getCallContext 
.const [228] = Utf8 ()Lde/esolutions/fw/comm/core/CallContext; 
.const [229] = Utf8 handleCallMethod 
.const [230] = Utf8 (SLde/esolutions/fw/util/serializer/IDeserializer;Lde/esolutions/fw/comm/core/IProxyFrontend;)V 
.const [231] = Utf8 <clinit> 
.const [232] = Utf8 ()V 
.end class 
