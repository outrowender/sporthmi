.version 50 0 
.class public super [219] 
.super [221] 
.field private static final [222] [223] 
.field private static [224] [225] 
.field private [226] [227] 

.method public [229] : [230] 
    .attribute [228] .code stack 7 locals 0 
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

.method private static synchronized [231] : [232] 
    .attribute [228] .code stack 2 locals 1 
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

.method public [233] : [234] 
    .attribute [228] .code stack 1 locals 0 
L0:     getstatic [8] 
L3:     areturn 
L4:     
    .end code 
.end method 

.method public [235] : [236] 
    .attribute [228] .code stack 4 locals 3 
        .catch [14] from L0 to L377 using L380 
L0:     iload_1 
L1:     tableswitch 0 
            L276 
            L350 
            L350 
            L350 
            L350 
            L350 
            L350 
            L350 
            L350 
            L350 
            L350 
            L350 
            L92 
            L124 
            L154 
            L214 
            L246 
            L184 
            L318 
            default : L350 

L92:    aload_2 
L93:    invokeinterface [39] 0 
L98:    istore 4 
L100:   aload_2 
L101:   invokeinterface [40] 0 
L106:   istore 5 
L108:   aload_0 
L109:   getfield [26] 
L112:   iload 4 
L114:   iload 5 
L116:   invokeinterface [41] 0 
L121:   goto L377 
L124:   aload_2 
L125:   invokestatic [9] 
L128:   astore 4 
L130:   aload_2 
L131:   invokeinterface [40] 0 
L136:   istore 5 
L138:   aload_0 
L139:   getfield [26] 
L142:   aload 4 
L144:   iload 5 
L146:   invokeinterface [42] 0 
L151:   goto L377 
L154:   aload_2 
L155:   invokestatic [9] 
L158:   astore 4 
L160:   aload_2 
L161:   invokeinterface [40] 0 
L166:   istore 5 
L168:   aload_0 
L169:   getfield [26] 
L172:   aload 4 
L174:   iload 5 
L176:   invokeinterface [43] 0 
L181:   goto L377 
L184:   aload_2 
L185:   invokestatic [9] 
L188:   astore 4 
L190:   aload_2 
L191:   invokeinterface [40] 0 
L196:   istore 5 
L198:   aload_0 
L199:   getfield [26] 
L202:   aload 4 
L204:   iload 5 
L206:   invokeinterface [44] 0 
L211:   goto L377 
L214:   aload_2 
L215:   invokeinterface [40] 0 
L220:   istore 4 
L222:   aload_2 
L223:   invokeinterface [40] 0 
L228:   istore 5 
L230:   aload_0 
L231:   getfield [26] 
L234:   iload 4 
L236:   iload 5 
L238:   invokeinterface [45] 0 
L243:   goto L377 
L246:   aload_2 
L247:   invokestatic [10] 
L250:   astore 4 
L252:   aload_2 
L253:   invokeinterface [40] 0 
L258:   istore 5 
L260:   aload_0 
L261:   getfield [26] 
L264:   aload 4 
L266:   iload 5 
L268:   invokeinterface [46] 0 
L273:   goto L377 
L276:   aload_2 
L277:   invokeinterface [40] 0 
L282:   istore 4 
L284:   aload_2 
L285:   invokeinterface [47] 0 
L290:   astore 5 
L292:   aload_2 
L293:   invokeinterface [40] 0 
L298:   istore 6 
L300:   aload_0 
L301:   getfield [26] 
L304:   iload 4 
L306:   aload 5 
L308:   iload 6 
L310:   invokeinterface [48] 0 
L315:   goto L377 
L318:   aload_2 
L319:   invokeinterface [47] 0 
L324:   astore 4 
L326:   aload_2 
L327:   invokeinterface [47] 0 
L332:   astore 5 
L334:   aload_0 
L335:   getfield [26] 
L338:   aload 4 
L340:   aload 5 
L342:   invokeinterface [49] 0 
L347:   goto L377 
L350:   new [50] 
L353:   dup 
L354:   new [51] 
L357:   dup 
L358:   invokespecial [35] 
L361:   ldc [13] 
L363:   invokevirtual [27] 
L366:   iload_1 
L367:   invokevirtual [28] 
L370:   invokevirtual [29] 
L373:   invokespecial [36] 
L376:   athrow 
L377:   goto L422 
L380:   astore 4 
L382:   new [50] 
L385:   dup 
L386:   new [51] 
L389:   dup 
L390:   invokespecial [35] 
L393:   ldc [15] 
L395:   invokevirtual [27] 
L398:   iload_1 
L399:   invokevirtual [28] 
L402:   ldc [16] 
L404:   invokevirtual [27] 
L407:   aload 4 
L409:   invokevirtual [30] 
L412:   invokevirtual [27] 
L415:   invokevirtual [29] 
L418:   invokespecial [36] 
L421:   athrow 
L422:   return 
L423:   nop 
L424:   
    .end code 
.end method 

.method static [237] : [238] 
    .attribute [228] .code stack 1 locals 0 
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
.const [2] = Class [52] 
.const [3] = String [53] 
.const [4] = Method [54] [55] 
.const [5] = String [56] 
.const [6] = String [57] 
.const [7] = Field [58] [59] 
.const [8] = Field [60] [61] 
.const [9] = Method [62] [63] 
.const [10] = Method [64] [65] 
.const [11] = Class [66] 
.const [12] = Class [67] 
.const [13] = String [68] 
.const [14] = Class [69] 
.const [15] = String [70] 
.const [16] = String [71] 
.const [17] = String [72] 
.const [18] = Method [73] [74] 
.const [19] = Class [75] 
.const [20] = Class [76] 
.const [21] = Class [77] 
.const [22] = Class [78] 
.const [23] = Class [79] 
.const [24] = Class [80] 
.const [25] = Class [81] 
.const [26] = Field [82] [83] 
.const [27] = Method [84] [85] 
.const [28] = Method [86] [87] 
.const [29] = Method [88] [89] 
.const [30] = Method [90] [91] 
.const [31] = Method [92] [93] 
.const [32] = Method [94] [95] 
.const [33] = Field [96] [97] 
.const [34] = Field [98] [99] 
.const [35] = Method [100] [101] 
.const [36] = Method [102] [103] 
.const [37] = Class [104] 
.const [38] = Field [105] [106] 
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
.const [50] = Class [129] 
.const [51] = Class [130] 
.const [52] = Utf8 de/esolutions/fw/comm/core/ServiceInstanceID 
.const [53] = Utf8 b4d4a6fb-dbca-5e1d-942b-304e14e8354d 
.const [54] = Class [131] 
.const [55] = NameAndType [132] [133] 
.const [56] = Utf8 '77e0797d-7f62-56df-984f-75f67467400e' 
.const [57] = Utf8 'dsi.telephone.DSICallStacks' 
.const [58] = Class [134] 
.const [59] = NameAndType [135] [136] 
.const [60] = Class [137] 
.const [61] = NameAndType [138] [139] 
.const [62] = Class [140] 
.const [63] = NameAndType [141] [142] 
.const [64] = Class [143] 
.const [65] = NameAndType [144] [145] 
.const [66] = Utf8 de/esolutions/fw/comm/core/method/MethodException 
.const [67] = Utf8 java/lang/StringBuffer 
.const [68] = Utf8 'Invalid Method Id ' 
.const [69] = Utf8 de/esolutions/fw/util/serializer/exception/SerializerException 
.const [70] = Utf8 'Deserialization failed: method=' 
.const [71] = Utf8 ', error=' 
.const [72] = Utf8 'STUB.dsi.telephone.DSICallStacks' 
.const [73] = Class [146] 
.const [74] = NameAndType [147] [148] 
.const [75] = Utf8 de/esolutions/fw/comm/dsi/telephone/impl/DSICallStacksReplyService 
.const [76] = Utf8 de/esolutions/fw/comm/core/AbstractReplyService 
.const [77] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [78] = Utf8 de/esolutions/fw/comm/dsi/telephone/DSICallStacksReply 
.const [79] = Utf8 de/esolutions/fw/comm/dsi/telephone/impl/CallStackEntrySerializer 
.const [80] = Utf8 de/esolutions/fw/comm/dsi/telephone/impl/MissedCallIndicatorSerializer 
.const [81] = Utf8 de/esolutions/fw/comm/core/CallContext 
.const [82] = Class [149] 
.const [83] = NameAndType [150] [151] 
.const [84] = Class [152] 
.const [85] = NameAndType [153] [154] 
.const [86] = Class [155] 
.const [87] = NameAndType [156] [157] 
.const [88] = Class [158] 
.const [89] = NameAndType [159] [160] 
.const [90] = Class [161] 
.const [91] = NameAndType [162] [163] 
.const [92] = Class [164] 
.const [93] = NameAndType [165] [166] 
.const [94] = Class [167] 
.const [95] = NameAndType [168] [169] 
.const [96] = Class [170] 
.const [97] = NameAndType [171] [172] 
.const [98] = Class [173] 
.const [99] = NameAndType [174] [175] 
.const [100] = Class [176] 
.const [101] = NameAndType [177] [178] 
.const [102] = Class [179] 
.const [103] = NameAndType [180] [181] 
.const [104] = Utf8 de/esolutions/fw/comm/core/ServiceInstanceID 
.const [105] = Class [182] 
.const [106] = NameAndType [183] [184] 
.const [107] = Class [185] 
.const [108] = NameAndType [186] [187] 
.const [109] = Class [188] 
.const [110] = NameAndType [189] [190] 
.const [111] = Class [191] 
.const [112] = NameAndType [192] [193] 
.const [113] = Class [194] 
.const [114] = NameAndType [195] [196] 
.const [115] = Class [197] 
.const [116] = NameAndType [198] [199] 
.const [117] = Class [200] 
.const [118] = NameAndType [201] [202] 
.const [119] = Class [203] 
.const [120] = NameAndType [204] [205] 
.const [121] = Class [206] 
.const [122] = NameAndType [207] [208] 
.const [123] = Class [209] 
.const [124] = NameAndType [210] [211] 
.const [125] = Class [212] 
.const [126] = NameAndType [213] [214] 
.const [127] = Class [215] 
.const [128] = NameAndType [216] [217] 
.const [129] = Utf8 de/esolutions/fw/comm/core/method/MethodException 
.const [130] = Utf8 java/lang/StringBuffer 
.const [131] = Utf8 de/esolutions/fw/comm/dsi/telephone/impl/DSICallStacksReplyService 
.const [132] = Utf8 nextDynamicHandle 
.const [133] = Utf8 ()I 
.const [134] = Utf8 de/esolutions/fw/comm/dsi/telephone/impl/DSICallStacksReplyService 
.const [135] = Utf8 dynamicHandle 
.const [136] = Utf8 I 
.const [137] = Utf8 de/esolutions/fw/comm/dsi/telephone/impl/DSICallStacksReplyService 
.const [138] = Utf8 context 
.const [139] = Utf8 Lde/esolutions/fw/comm/core/CallContext; 
.const [140] = Utf8 de/esolutions/fw/comm/dsi/telephone/impl/CallStackEntrySerializer 
.const [141] = Utf8 getOptionalCallStackEntryVarArray 
.const [142] = Utf8 (Lde/esolutions/fw/util/serializer/IDeserializer;)[Lorg/dsi/ifc/telephone/CallStackEntry; 
.const [143] = Utf8 de/esolutions/fw/comm/dsi/telephone/impl/MissedCallIndicatorSerializer 
.const [144] = Utf8 getOptionalMissedCallIndicator 
.const [145] = Utf8 (Lde/esolutions/fw/util/serializer/IDeserializer;)Lorg/dsi/ifc/telephone/MissedCallIndicator; 
.const [146] = Utf8 de/esolutions/fw/comm/core/CallContext 
.const [147] = Utf8 getContext 
.const [148] = Utf8 (Ljava/lang/String;)Lde/esolutions/fw/comm/core/CallContext; 
.const [149] = Utf8 de/esolutions/fw/comm/dsi/telephone/impl/DSICallStacksReplyService 
.const [150] = Utf8 p_DSICallStacksReply 
.const [151] = Utf8 Lde/esolutions/fw/comm/dsi/telephone/DSICallStacksReply; 
.const [152] = Utf8 java/lang/StringBuffer 
.const [153] = Utf8 append 
.const [154] = Utf8 (Ljava/lang/String;)Ljava/lang/StringBuffer; 
.const [155] = Utf8 java/lang/StringBuffer 
.const [156] = Utf8 append 
.const [157] = Utf8 (I)Ljava/lang/StringBuffer; 
.const [158] = Utf8 java/lang/StringBuffer 
.const [159] = Utf8 toString 
.const [160] = Utf8 ()Ljava/lang/String; 
.const [161] = Utf8 de/esolutions/fw/util/serializer/exception/SerializerException 
.const [162] = Utf8 getMessage 
.const [163] = Utf8 ()Ljava/lang/String; 
.const [164] = Utf8 de/esolutions/fw/comm/core/ServiceInstanceID 
.const [165] = Utf8 <init> 
.const [166] = Utf8 (Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V 
.const [167] = Utf8 de/esolutions/fw/comm/core/AbstractReplyService 
.const [168] = Utf8 <init> 
.const [169] = Utf8 (Lde/esolutions/fw/comm/core/ServiceInstanceID;)V 
.const [170] = Utf8 de/esolutions/fw/comm/dsi/telephone/impl/DSICallStacksReplyService 
.const [171] = Utf8 dynamicHandle 
.const [172] = Utf8 I 
.const [173] = Utf8 de/esolutions/fw/comm/dsi/telephone/impl/DSICallStacksReplyService 
.const [174] = Utf8 context 
.const [175] = Utf8 Lde/esolutions/fw/comm/core/CallContext; 
.const [176] = Utf8 java/lang/StringBuffer 
.const [177] = Utf8 <init> 
.const [178] = Utf8 ()V 
.const [179] = Utf8 de/esolutions/fw/comm/core/method/MethodException 
.const [180] = Utf8 <init> 
.const [181] = Utf8 (Ljava/lang/String;)V 
.const [182] = Utf8 de/esolutions/fw/comm/dsi/telephone/impl/DSICallStacksReplyService 
.const [183] = Utf8 p_DSICallStacksReply 
.const [184] = Utf8 Lde/esolutions/fw/comm/dsi/telephone/DSICallStacksReply; 
.const [185] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [186] = Utf8 getBool 
.const [187] = Utf8 ()Z 
.const [188] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [189] = Utf8 getInt32 
.const [190] = Utf8 ()I 
.const [191] = Utf8 de/esolutions/fw/comm/dsi/telephone/DSICallStacksReply 
.const [192] = Utf8 updateIsReverted 
.const [193] = Utf8 (ZI)V 
.const [194] = Utf8 de/esolutions/fw/comm/dsi/telephone/DSICallStacksReply 
.const [195] = Utf8 updateLastAnsweredNumbers 
.const [196] = Utf8 ([Lorg/dsi/ifc/telephone/CallStackEntry;I)V 
.const [197] = Utf8 de/esolutions/fw/comm/dsi/telephone/DSICallStacksReply 
.const [198] = Utf8 updateLastDialedNumbers 
.const [199] = Utf8 ([Lorg/dsi/ifc/telephone/CallStackEntry;I)V 
.const [200] = Utf8 de/esolutions/fw/comm/dsi/telephone/DSICallStacksReply 
.const [201] = Utf8 updateMissedNumbers 
.const [202] = Utf8 ([Lorg/dsi/ifc/telephone/CallStackEntry;I)V 
.const [203] = Utf8 de/esolutions/fw/comm/dsi/telephone/DSICallStacksReply 
.const [204] = Utf8 updateMEDataValidity 
.const [205] = Utf8 (II)V 
.const [206] = Utf8 de/esolutions/fw/comm/dsi/telephone/DSICallStacksReply 
.const [207] = Utf8 updateMissedCallIndicator 
.const [208] = Utf8 (Lorg/dsi/ifc/telephone/MissedCallIndicator;I)V 
.const [209] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [210] = Utf8 getOptionalString 
.const [211] = Utf8 ()Ljava/lang/String; 
.const [212] = Utf8 de/esolutions/fw/comm/dsi/telephone/DSICallStacksReply 
.const [213] = Utf8 asyncException 
.const [214] = Utf8 (ILjava/lang/String;I)V 
.const [215] = Utf8 de/esolutions/fw/comm/dsi/telephone/DSICallStacksReply 
.const [216] = Utf8 yyIndication 
.const [217] = Utf8 (Ljava/lang/String;Ljava/lang/String;)V 
.const [218] = Utf8 de/esolutions/fw/comm/dsi/telephone/impl/DSICallStacksReplyService 
.const [219] = Class [218] 
.const [220] = Utf8 de/esolutions/fw/comm/core/AbstractReplyService 
.const [221] = Class [220] 
.const [222] = Utf8 context 
.const [223] = Utf8 Lde/esolutions/fw/comm/core/CallContext; 
.const [224] = Utf8 dynamicHandle 
.const [225] = Utf8 I 
.const [226] = Utf8 p_DSICallStacksReply 
.const [227] = Utf8 Lde/esolutions/fw/comm/dsi/telephone/DSICallStacksReply; 
.const [228] = Utf8 Code 
.const [229] = Utf8 <init> 
.const [230] = Utf8 (Lde/esolutions/fw/comm/dsi/telephone/DSICallStacksReply;)V 
.const [231] = Utf8 nextDynamicHandle 
.const [232] = Utf8 ()I 
.const [233] = Utf8 getCallContext 
.const [234] = Utf8 ()Lde/esolutions/fw/comm/core/CallContext; 
.const [235] = Utf8 handleCallMethod 
.const [236] = Utf8 (SLde/esolutions/fw/util/serializer/IDeserializer;Lde/esolutions/fw/comm/core/IProxyFrontend;)V 
.const [237] = Utf8 <clinit> 
.const [238] = Utf8 ()V 
.end class 
