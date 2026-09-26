.version 50 0 
.class public super [205] 
.super [207] 
.field private static final [208] [209] 
.field private [210] [211] 

.method public [213] : [214] 
    .attribute [212] .code stack 7 locals 0 
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

.method public [215] : [216] 
    .attribute [212] .code stack 2 locals 0 
L0:     new [36] 
L3:     dup 
L4:     invokespecial [30] 
L7:     areturn 
L8:     
    .end code 
.end method 

.method public [217] : [218] 
    .attribute [212] .code stack 1 locals 0 
L0:     getstatic [7] 
L3:     areturn 
L4:     
    .end code 
.end method 

.method public [219] : [220] 
    .attribute [212] .code stack 5 locals 7 
        .catch [13] from L0 to L365 using L368 
L0:     iload_1 
L1:     tableswitch 2 
            L228 
            L136 
            L338 
            L182 
            L338 
            L48 
            L84 
            L120 
            default : L338 

L48:    aload_2 
L49:    invokeinterface [37] 0 
L54:    astore 7 
L56:    aload_2 
L57:    invokeinterface [37] 0 
L62:    astore 8 
L64:    aload_0 
L65:    getfield [23] 
L68:    aload 7 
L70:    aload 8 
L72:    aload_3 
L73:    checkcast [6] 
L76:    invokeinterface [38] 0 
L81:    goto L365 
L84:    aload_2 
L85:    invokeinterface [37] 0 
L90:    astore 7 
L92:    aload_2 
L93:    invokeinterface [37] 0 
L98:    astore 8 
L100:   aload_0 
L101:   getfield [23] 
L104:   aload 7 
L106:   aload 8 
L108:   aload_3 
L109:   checkcast [6] 
L112:   invokeinterface [39] 0 
L117:   goto L365 
L120:   aload_0 
L121:   getfield [23] 
L124:   aload_3 
L125:   checkcast [6] 
L128:   invokeinterface [40] 0 
L133:   goto L365 
L136:   aload_2 
L137:   invokeinterface [37] 0 
L142:   astore 7 
L144:   aload_2 
L145:   invokeinterface [37] 0 
L150:   astore 8 
L152:   aload_2 
L153:   invokeinterface [41] 0 
L158:   astore 9 
L160:   aload_0 
L161:   getfield [23] 
L164:   aload 7 
L166:   aload 8 
L168:   aload 9 
L170:   aload_3 
L171:   checkcast [6] 
L174:   invokeinterface [42] 0 
L179:   goto L365 
L182:   aload_2 
L183:   invokeinterface [37] 0 
L188:   astore 7 
L190:   aload_2 
L191:   invokeinterface [37] 0 
L196:   astore 8 
L198:   aload_2 
L199:   invokeinterface [43] 0 
L204:   astore 9 
L206:   aload_0 
L207:   getfield [23] 
L210:   aload 7 
L212:   aload 8 
L214:   aload 9 
L216:   aload_3 
L217:   checkcast [6] 
L220:   invokeinterface [44] 0 
L225:   goto L365 
L228:   aload_2 
L229:   invokeinterface [37] 0 
L234:   astore 7 
L236:   aload_2 
L237:   invokeinterface [37] 0 
L242:   astore 8 
L244:   aload_2 
L245:   invokeinterface [45] 0 
L250:   ifne L257 
L253:   iconst_1 
L254:   goto L258 
L257:   iconst_0 
L258:   istore 4 
L260:   aconst_null 
L261:   checkcast [8] 
L264:   astore 9 
L266:   iload 4 
L268:   ifeq L316 
L271:   aload_2 
L272:   invokeinterface [46] 0 
L277:   lstore 5 
L279:   lload 5 
L281:   l2i 
L282:   anewarray [9] 
L285:   astore 9 
L287:   iconst_0 
L288:   istore 10 
L290:   iload 10 
L292:   i2l 
L293:   lload 5 
L295:   lcmp 
L296:   ifge L316 
L299:   aload 9 
L301:   iload 10 
L303:   aload_2 
L304:   invokeinterface [47] 0 
L309:   aastore 
L310:   iinc 10 1 
L313:   goto L290 
L316:   aload_0 
L317:   getfield [23] 
L320:   aload 7 
L322:   aload 8 
L324:   aload 9 
L326:   aload_3 
L327:   checkcast [6] 
L330:   invokeinterface [48] 0 
L335:   goto L365 
L338:   new [49] 
L341:   dup 
L342:   new [50] 
L345:   dup 
L346:   invokespecial [32] 
L349:   ldc [12] 
L351:   invokevirtual [24] 
L354:   iload_1 
L355:   invokevirtual [25] 
L358:   invokevirtual [26] 
L361:   invokespecial [33] 
L364:   athrow 
L365:   goto L410 
L368:   astore 7 
L370:   new [49] 
L373:   dup 
L374:   new [50] 
L377:   dup 
L378:   invokespecial [32] 
L381:   ldc [14] 
L383:   invokevirtual [24] 
L386:   iload_1 
L387:   invokevirtual [25] 
L390:   ldc [15] 
L392:   invokevirtual [24] 
L395:   aload 7 
L397:   invokevirtual [27] 
L400:   invokevirtual [24] 
L403:   invokevirtual [26] 
L406:   invokespecial [33] 
L409:   athrow 
L410:   return 
L411:   nop 
L412:   
    .end code 
.end method 

.method static [221] : [222] 
    .attribute [212] .code stack 1 locals 0 
L0:     ldc [16] 
L2:     invokestatic [17] 
L5:     putstatic [31] 
L8:     return 
L9:     nop 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [51] 
.const [3] = String [52] 
.const [4] = String [53] 
.const [5] = String [54] 
.const [6] = Class [55] 
.const [7] = Field [56] [57] 
.const [8] = Class [58] 
.const [9] = Class [59] 
.const [10] = Class [60] 
.const [11] = Class [61] 
.const [12] = String [62] 
.const [13] = Class [63] 
.const [14] = String [64] 
.const [15] = String [65] 
.const [16] = String [66] 
.const [17] = Method [67] [68] 
.const [18] = Class [69] 
.const [19] = Class [70] 
.const [20] = Class [71] 
.const [21] = Class [72] 
.const [22] = Class [73] 
.const [23] = Field [74] [75] 
.const [24] = Method [76] [77] 
.const [25] = Method [78] [79] 
.const [26] = Method [80] [81] 
.const [27] = Method [82] [83] 
.const [28] = Method [84] [85] 
.const [29] = Method [86] [87] 
.const [30] = Method [88] [89] 
.const [31] = Field [90] [91] 
.const [32] = Method [92] [93] 
.const [33] = Method [94] [95] 
.const [34] = Class [96] 
.const [35] = Field [97] [98] 
.const [36] = Class [99] 
.const [37] = InterfaceMethod [100] [101] 
.const [38] = InterfaceMethod [102] [103] 
.const [39] = InterfaceMethod [104] [105] 
.const [40] = InterfaceMethod [106] [107] 
.const [41] = InterfaceMethod [108] [109] 
.const [42] = InterfaceMethod [110] [111] 
.const [43] = InterfaceMethod [112] [113] 
.const [44] = InterfaceMethod [114] [115] 
.const [45] = InterfaceMethod [116] [117] 
.const [46] = InterfaceMethod [118] [119] 
.const [47] = InterfaceMethod [120] [121] 
.const [48] = InterfaceMethod [122] [123] 
.const [49] = Class [124] 
.const [50] = Class [125] 
.const [51] = Utf8 de/esolutions/fw/comm/core/ServiceInstanceID 
.const [52] = Utf8 a58995e5-3a88-5f1a-9a3c-1786b9a38589 
.const [53] = Utf8 '8a7ea0fe-3e4b-5398-9204-ca052de05566' 
.const [54] = Utf8 'asi.persistence.Attributes' 
.const [55] = Utf8 de/esolutions/fw/comm/asi/persistence/impl/AttributesReplyProxy 
.const [56] = Class [126] 
.const [57] = NameAndType [127] [128] 
.const [58] = Utf8 [[S 
.const [59] = Utf8 [S 
.const [60] = Utf8 de/esolutions/fw/comm/core/method/MethodException 
.const [61] = Utf8 java/lang/StringBuffer 
.const [62] = Utf8 'Invalid Method Id ' 
.const [63] = Utf8 de/esolutions/fw/util/serializer/exception/SerializerException 
.const [64] = Utf8 'Deserialization failed: method=' 
.const [65] = Utf8 ', error=' 
.const [66] = Utf8 'STUB.asi.persistence.Attributes' 
.const [67] = Class [129] 
.const [68] = NameAndType [130] [131] 
.const [69] = Utf8 de/esolutions/fw/comm/asi/persistence/impl/AttributesService 
.const [70] = Utf8 de/esolutions/fw/comm/core/AbstractService 
.const [71] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [72] = Utf8 de/esolutions/fw/comm/asi/persistence/AttributesS 
.const [73] = Utf8 de/esolutions/fw/comm/core/CallContext 
.const [74] = Class [132] 
.const [75] = NameAndType [133] [134] 
.const [76] = Class [135] 
.const [77] = NameAndType [136] [137] 
.const [78] = Class [138] 
.const [79] = NameAndType [139] [140] 
.const [80] = Class [141] 
.const [81] = NameAndType [142] [143] 
.const [82] = Class [144] 
.const [83] = NameAndType [145] [146] 
.const [84] = Class [147] 
.const [85] = NameAndType [148] [149] 
.const [86] = Class [150] 
.const [87] = NameAndType [151] [152] 
.const [88] = Class [153] 
.const [89] = NameAndType [154] [155] 
.const [90] = Class [156] 
.const [91] = NameAndType [157] [158] 
.const [92] = Class [159] 
.const [93] = NameAndType [160] [161] 
.const [94] = Class [162] 
.const [95] = NameAndType [163] [164] 
.const [96] = Utf8 de/esolutions/fw/comm/core/ServiceInstanceID 
.const [97] = Class [165] 
.const [98] = NameAndType [166] [167] 
.const [99] = Utf8 de/esolutions/fw/comm/asi/persistence/impl/AttributesReplyProxy 
.const [100] = Class [168] 
.const [101] = NameAndType [169] [170] 
.const [102] = Class [171] 
.const [103] = NameAndType [172] [173] 
.const [104] = Class [174] 
.const [105] = NameAndType [175] [176] 
.const [106] = Class [177] 
.const [107] = NameAndType [178] [179] 
.const [108] = Class [180] 
.const [109] = NameAndType [181] [182] 
.const [110] = Class [183] 
.const [111] = NameAndType [184] [185] 
.const [112] = Class [186] 
.const [113] = NameAndType [187] [188] 
.const [114] = Class [189] 
.const [115] = NameAndType [190] [191] 
.const [116] = Class [192] 
.const [117] = NameAndType [193] [194] 
.const [118] = Class [195] 
.const [119] = NameAndType [196] [197] 
.const [120] = Class [198] 
.const [121] = NameAndType [199] [200] 
.const [122] = Class [201] 
.const [123] = NameAndType [202] [203] 
.const [124] = Utf8 de/esolutions/fw/comm/core/method/MethodException 
.const [125] = Utf8 java/lang/StringBuffer 
.const [126] = Utf8 de/esolutions/fw/comm/asi/persistence/impl/AttributesService 
.const [127] = Utf8 context 
.const [128] = Utf8 Lde/esolutions/fw/comm/core/CallContext; 
.const [129] = Utf8 de/esolutions/fw/comm/core/CallContext 
.const [130] = Utf8 getContext 
.const [131] = Utf8 (Ljava/lang/String;)Lde/esolutions/fw/comm/core/CallContext; 
.const [132] = Utf8 de/esolutions/fw/comm/asi/persistence/impl/AttributesService 
.const [133] = Utf8 p_Attributes 
.const [134] = Utf8 Lde/esolutions/fw/comm/asi/persistence/AttributesS; 
.const [135] = Utf8 java/lang/StringBuffer 
.const [136] = Utf8 append 
.const [137] = Utf8 (Ljava/lang/String;)Ljava/lang/StringBuffer; 
.const [138] = Utf8 java/lang/StringBuffer 
.const [139] = Utf8 append 
.const [140] = Utf8 (I)Ljava/lang/StringBuffer; 
.const [141] = Utf8 java/lang/StringBuffer 
.const [142] = Utf8 toString 
.const [143] = Utf8 ()Ljava/lang/String; 
.const [144] = Utf8 de/esolutions/fw/util/serializer/exception/SerializerException 
.const [145] = Utf8 getMessage 
.const [146] = Utf8 ()Ljava/lang/String; 
.const [147] = Utf8 de/esolutions/fw/comm/core/ServiceInstanceID 
.const [148] = Utf8 <init> 
.const [149] = Utf8 (Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V 
.const [150] = Utf8 de/esolutions/fw/comm/core/AbstractService 
.const [151] = Utf8 <init> 
.const [152] = Utf8 (Lde/esolutions/fw/comm/core/ServiceInstanceID;)V 
.const [153] = Utf8 de/esolutions/fw/comm/asi/persistence/impl/AttributesReplyProxy 
.const [154] = Utf8 <init> 
.const [155] = Utf8 ()V 
.const [156] = Utf8 de/esolutions/fw/comm/asi/persistence/impl/AttributesService 
.const [157] = Utf8 context 
.const [158] = Utf8 Lde/esolutions/fw/comm/core/CallContext; 
.const [159] = Utf8 java/lang/StringBuffer 
.const [160] = Utf8 <init> 
.const [161] = Utf8 ()V 
.const [162] = Utf8 de/esolutions/fw/comm/core/method/MethodException 
.const [163] = Utf8 <init> 
.const [164] = Utf8 (Ljava/lang/String;)V 
.const [165] = Utf8 de/esolutions/fw/comm/asi/persistence/impl/AttributesService 
.const [166] = Utf8 p_Attributes 
.const [167] = Utf8 Lde/esolutions/fw/comm/asi/persistence/AttributesS; 
.const [168] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [169] = Utf8 getOptionalUInt32VarArray 
.const [170] = Utf8 ()[J 
.const [171] = Utf8 de/esolutions/fw/comm/asi/persistence/AttributesS 
.const [172] = Utf8 subscribe 
.const [173] = Utf8 ([J[JLde/esolutions/fw/comm/asi/persistence/AttributesReply;)V 
.const [174] = Utf8 de/esolutions/fw/comm/asi/persistence/AttributesS 
.const [175] = Utf8 unsubscribe 
.const [176] = Utf8 ([J[JLde/esolutions/fw/comm/asi/persistence/AttributesReply;)V 
.const [177] = Utf8 de/esolutions/fw/comm/asi/persistence/AttributesS 
.const [178] = Utf8 unsubscribeAll 
.const [179] = Utf8 (Lde/esolutions/fw/comm/asi/persistence/AttributesReply;)V 
.const [180] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [181] = Utf8 getOptionalInt32VarArray 
.const [182] = Utf8 ()[I 
.const [183] = Utf8 de/esolutions/fw/comm/asi/persistence/AttributesS 
.const [184] = Utf8 putInts 
.const [185] = Utf8 ([J[J[ILde/esolutions/fw/comm/asi/persistence/AttributesReply;)V 
.const [186] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [187] = Utf8 getOptionalStringVarArray 
.const [188] = Utf8 ()[Ljava/lang/String; 
.const [189] = Utf8 de/esolutions/fw/comm/asi/persistence/AttributesS 
.const [190] = Utf8 putStrings 
.const [191] = Utf8 ([J[J[Ljava/lang/String;Lde/esolutions/fw/comm/asi/persistence/AttributesReply;)V 
.const [192] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [193] = Utf8 getBool 
.const [194] = Utf8 ()Z 
.const [195] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [196] = Utf8 getUInt32 
.const [197] = Utf8 ()J 
.const [198] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [199] = Utf8 getOptionalUInt8VarArray 
.const [200] = Utf8 ()[S 
.const [201] = Utf8 de/esolutions/fw/comm/asi/persistence/AttributesS 
.const [202] = Utf8 putBlobs 
.const [203] = Utf8 ([J[J[[SLde/esolutions/fw/comm/asi/persistence/AttributesReply;)V 
.const [204] = Utf8 de/esolutions/fw/comm/asi/persistence/impl/AttributesService 
.const [205] = Class [204] 
.const [206] = Utf8 de/esolutions/fw/comm/core/AbstractService 
.const [207] = Class [206] 
.const [208] = Utf8 context 
.const [209] = Utf8 Lde/esolutions/fw/comm/core/CallContext; 
.const [210] = Utf8 p_Attributes 
.const [211] = Utf8 Lde/esolutions/fw/comm/asi/persistence/AttributesS; 
.const [212] = Utf8 Code 
.const [213] = Utf8 <init> 
.const [214] = Utf8 (ILde/esolutions/fw/comm/asi/persistence/AttributesS;)V 
.const [215] = Utf8 createReplyProxy 
.const [216] = Utf8 ()Lde/esolutions/fw/comm/core/IProxyFrontend; 
.const [217] = Utf8 getCallContext 
.const [218] = Utf8 ()Lde/esolutions/fw/comm/core/CallContext; 
.const [219] = Utf8 handleCallMethod 
.const [220] = Utf8 (SLde/esolutions/fw/util/serializer/IDeserializer;Lde/esolutions/fw/comm/core/IProxyFrontend;)V 
.const [221] = Utf8 <clinit> 
.const [222] = Utf8 ()V 
.end class 
