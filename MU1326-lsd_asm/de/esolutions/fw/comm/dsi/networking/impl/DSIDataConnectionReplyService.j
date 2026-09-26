.version 50 0 
.class public super [215] 
.super [217] 
.field private static final [218] [219] 
.field private static [220] [221] 
.field private [222] [223] 

.method public [225] : [226] 
    .attribute [224] .code stack 7 locals 0 
L0:     aload_0 
L1:     new [39] 
L4:     dup 
L5:     ldc [3] 
L7:     invokestatic [4] 
L10:    ldc [5] 
L12:    ldc [6] 
L14:    invokespecial [33] 
L17:    invokespecial [34] 
L20:    aload_0 
L21:    aload_1 
L22:    putfield [40] 
L25:    return 
L26:    nop 
L27:    nop 
L28:    
    .end code 
.end method 

.method private static synchronized [227] : [228] 
    .attribute [224] .code stack 2 locals 1 
L0:     getstatic [7] 
L3:     iconst_1 
L4:     iadd 
L5:     dup 
L6:     putstatic [35] 
L9:     istore_0 
L10:    iload_0 
L11:    areturn 
L12:    
    .end code 
.end method 

.method public [229] : [230] 
    .attribute [224] .code stack 1 locals 0 
L0:     getstatic [8] 
L3:     areturn 
L4:     
    .end code 
.end method 

.method public [231] : [232] 
    .attribute [224] .code stack 4 locals 3 
        .catch [15] from L0 to L333 using L336 
L0:     iload_1 
L1:     tableswitch 0 
            L232 
            L306 
            L306 
            L306 
            L306 
            L306 
            L306 
            L306 
            L306 
            L210 
            L306 
            L306 
            L306 
            L118 
            L180 
            L148 
            L88 
            L274 
            default : L306 

L88:    aload_2 
L89:    invokestatic [9] 
L92:    astore 4 
L94:    aload_2 
L95:    invokeinterface [41] 0 
L100:   istore 5 
L102:   aload_0 
L103:   getfield [28] 
L106:   aload 4 
L108:   iload 5 
L110:   invokeinterface [42] 0 
L115:   goto L333 
L118:   aload_2 
L119:   invokestatic [10] 
L122:   astore 4 
L124:   aload_2 
L125:   invokeinterface [41] 0 
L130:   istore 5 
L132:   aload_0 
L133:   getfield [28] 
L136:   aload 4 
L138:   iload 5 
L140:   invokeinterface [43] 0 
L145:   goto L333 
L148:   aload_2 
L149:   invokeinterface [41] 0 
L154:   istore 4 
L156:   aload_2 
L157:   invokeinterface [41] 0 
L162:   istore 5 
L164:   aload_0 
L165:   getfield [28] 
L168:   iload 4 
L170:   iload 5 
L172:   invokeinterface [44] 0 
L177:   goto L333 
L180:   aload_2 
L181:   invokestatic [11] 
L184:   astore 4 
L186:   aload_2 
L187:   invokeinterface [41] 0 
L192:   istore 5 
L194:   aload_0 
L195:   getfield [28] 
L198:   aload 4 
L200:   iload 5 
L202:   invokeinterface [45] 0 
L207:   goto L333 
L210:   aload_2 
L211:   invokeinterface [41] 0 
L216:   istore 4 
L218:   aload_0 
L219:   getfield [28] 
L222:   iload 4 
L224:   invokeinterface [46] 0 
L229:   goto L333 
L232:   aload_2 
L233:   invokeinterface [41] 0 
L238:   istore 4 
L240:   aload_2 
L241:   invokeinterface [47] 0 
L246:   astore 5 
L248:   aload_2 
L249:   invokeinterface [41] 0 
L254:   istore 6 
L256:   aload_0 
L257:   getfield [28] 
L260:   iload 4 
L262:   aload 5 
L264:   iload 6 
L266:   invokeinterface [48] 0 
L271:   goto L333 
L274:   aload_2 
L275:   invokeinterface [47] 0 
L280:   astore 4 
L282:   aload_2 
L283:   invokeinterface [47] 0 
L288:   astore 5 
L290:   aload_0 
L291:   getfield [28] 
L294:   aload 4 
L296:   aload 5 
L298:   invokeinterface [49] 0 
L303:   goto L333 
L306:   new [50] 
L309:   dup 
L310:   new [51] 
L313:   dup 
L314:   invokespecial [37] 
L317:   ldc [14] 
L319:   invokevirtual [29] 
L322:   iload_1 
L323:   invokevirtual [30] 
L326:   invokevirtual [31] 
L329:   invokespecial [38] 
L332:   athrow 
L333:   goto L378 
L336:   astore 4 
L338:   new [50] 
L341:   dup 
L342:   new [51] 
L345:   dup 
L346:   invokespecial [37] 
L349:   ldc [16] 
L351:   invokevirtual [29] 
L354:   iload_1 
L355:   invokevirtual [30] 
L358:   ldc [17] 
L360:   invokevirtual [29] 
L363:   aload 4 
L365:   invokevirtual [32] 
L368:   invokevirtual [29] 
L371:   invokevirtual [31] 
L374:   invokespecial [38] 
L377:   athrow 
L378:   return 
L379:   nop 
L380:   
    .end code 
.end method 

.method static [233] : [234] 
    .attribute [224] .code stack 1 locals 0 
L0:     ldc [18] 
L2:     invokestatic [19] 
L5:     putstatic [36] 
L8:     iconst_0 
L9:     putstatic [35] 
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
.const [11] = Method [66] [67] 
.const [12] = Class [68] 
.const [13] = Class [69] 
.const [14] = String [70] 
.const [15] = Class [71] 
.const [16] = String [72] 
.const [17] = String [73] 
.const [18] = String [74] 
.const [19] = Method [75] [76] 
.const [20] = Class [77] 
.const [21] = Class [78] 
.const [22] = Class [79] 
.const [23] = Class [80] 
.const [24] = Class [81] 
.const [25] = Class [82] 
.const [26] = Class [83] 
.const [27] = Class [84] 
.const [28] = Field [85] [86] 
.const [29] = Method [87] [88] 
.const [30] = Method [89] [90] 
.const [31] = Method [91] [92] 
.const [32] = Method [93] [94] 
.const [33] = Method [95] [96] 
.const [34] = Method [97] [98] 
.const [35] = Field [99] [100] 
.const [36] = Field [101] [102] 
.const [37] = Method [103] [104] 
.const [38] = Method [105] [106] 
.const [39] = Class [107] 
.const [40] = Field [108] [109] 
.const [41] = InterfaceMethod [110] [111] 
.const [42] = InterfaceMethod [112] [113] 
.const [43] = InterfaceMethod [114] [115] 
.const [44] = InterfaceMethod [116] [117] 
.const [45] = InterfaceMethod [118] [119] 
.const [46] = InterfaceMethod [120] [121] 
.const [47] = InterfaceMethod [122] [123] 
.const [48] = InterfaceMethod [124] [125] 
.const [49] = InterfaceMethod [126] [127] 
.const [50] = Class [128] 
.const [51] = Class [129] 
.const [52] = Utf8 de/esolutions/fw/comm/core/ServiceInstanceID 
.const [53] = Utf8 f6749804-3a69-5465-9822-1d5ccfd38720 
.const [54] = Class [130] 
.const [55] = NameAndType [131] [132] 
.const [56] = Utf8 ac66c0fa-deb7-50a6-834e-d94bf9a5b7ea 
.const [57] = Utf8 'dsi.networking.DSIDataConnection' 
.const [58] = Class [133] 
.const [59] = NameAndType [134] [135] 
.const [60] = Class [136] 
.const [61] = NameAndType [137] [138] 
.const [62] = Class [139] 
.const [63] = NameAndType [140] [141] 
.const [64] = Class [142] 
.const [65] = NameAndType [143] [144] 
.const [66] = Class [145] 
.const [67] = NameAndType [146] [147] 
.const [68] = Utf8 de/esolutions/fw/comm/core/method/MethodException 
.const [69] = Utf8 java/lang/StringBuffer 
.const [70] = Utf8 'Invalid Method Id ' 
.const [71] = Utf8 de/esolutions/fw/util/serializer/exception/SerializerException 
.const [72] = Utf8 'Deserialization failed: method=' 
.const [73] = Utf8 ', error=' 
.const [74] = Utf8 'STUB.dsi.networking.DSIDataConnection' 
.const [75] = Class [148] 
.const [76] = NameAndType [149] [150] 
.const [77] = Utf8 de/esolutions/fw/comm/dsi/networking/impl/DSIDataConnectionReplyService 
.const [78] = Utf8 de/esolutions/fw/comm/core/AbstractReplyService 
.const [79] = Utf8 de/esolutions/fw/comm/dsi/networking/impl/DataConnectionStateStructSerializer 
.const [80] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [81] = Utf8 de/esolutions/fw/comm/dsi/networking/DSIDataConnectionReply 
.const [82] = Utf8 de/esolutions/fw/comm/dsi/networking/impl/ConnectionStateInformationStructSerializer 
.const [83] = Utf8 de/esolutions/fw/comm/dsi/networking/impl/ApplicationErrorStructSerializer 
.const [84] = Utf8 de/esolutions/fw/comm/core/CallContext 
.const [85] = Class [151] 
.const [86] = NameAndType [152] [153] 
.const [87] = Class [154] 
.const [88] = NameAndType [155] [156] 
.const [89] = Class [157] 
.const [90] = NameAndType [158] [159] 
.const [91] = Class [160] 
.const [92] = NameAndType [161] [162] 
.const [93] = Class [163] 
.const [94] = NameAndType [164] [165] 
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
.const [107] = Utf8 de/esolutions/fw/comm/core/ServiceInstanceID 
.const [108] = Class [184] 
.const [109] = NameAndType [185] [186] 
.const [110] = Class [187] 
.const [111] = NameAndType [188] [189] 
.const [112] = Class [190] 
.const [113] = NameAndType [191] [192] 
.const [114] = Class [193] 
.const [115] = NameAndType [194] [195] 
.const [116] = Class [196] 
.const [117] = NameAndType [197] [198] 
.const [118] = Class [199] 
.const [119] = NameAndType [200] [201] 
.const [120] = Class [202] 
.const [121] = NameAndType [203] [204] 
.const [122] = Class [205] 
.const [123] = NameAndType [206] [207] 
.const [124] = Class [208] 
.const [125] = NameAndType [209] [210] 
.const [126] = Class [211] 
.const [127] = NameAndType [212] [213] 
.const [128] = Utf8 de/esolutions/fw/comm/core/method/MethodException 
.const [129] = Utf8 java/lang/StringBuffer 
.const [130] = Utf8 de/esolutions/fw/comm/dsi/networking/impl/DSIDataConnectionReplyService 
.const [131] = Utf8 nextDynamicHandle 
.const [132] = Utf8 ()I 
.const [133] = Utf8 de/esolutions/fw/comm/dsi/networking/impl/DSIDataConnectionReplyService 
.const [134] = Utf8 dynamicHandle 
.const [135] = Utf8 I 
.const [136] = Utf8 de/esolutions/fw/comm/dsi/networking/impl/DSIDataConnectionReplyService 
.const [137] = Utf8 context 
.const [138] = Utf8 Lde/esolutions/fw/comm/core/CallContext; 
.const [139] = Utf8 de/esolutions/fw/comm/dsi/networking/impl/DataConnectionStateStructSerializer 
.const [140] = Utf8 getOptionalDataConnectionStateStruct 
.const [141] = Utf8 (Lde/esolutions/fw/util/serializer/IDeserializer;)Lorg/dsi/ifc/networking/DataConnectionStateStruct; 
.const [142] = Utf8 de/esolutions/fw/comm/dsi/networking/impl/ConnectionStateInformationStructSerializer 
.const [143] = Utf8 getOptionalConnectionStateInformationStruct 
.const [144] = Utf8 (Lde/esolutions/fw/util/serializer/IDeserializer;)Lorg/dsi/ifc/networking/ConnectionStateInformationStruct; 
.const [145] = Utf8 de/esolutions/fw/comm/dsi/networking/impl/ApplicationErrorStructSerializer 
.const [146] = Utf8 getOptionalApplicationErrorStruct 
.const [147] = Utf8 (Lde/esolutions/fw/util/serializer/IDeserializer;)Lorg/dsi/ifc/networking/ApplicationErrorStruct; 
.const [148] = Utf8 de/esolutions/fw/comm/core/CallContext 
.const [149] = Utf8 getContext 
.const [150] = Utf8 (Ljava/lang/String;)Lde/esolutions/fw/comm/core/CallContext; 
.const [151] = Utf8 de/esolutions/fw/comm/dsi/networking/impl/DSIDataConnectionReplyService 
.const [152] = Utf8 p_DSIDataConnectionReply 
.const [153] = Utf8 Lde/esolutions/fw/comm/dsi/networking/DSIDataConnectionReply; 
.const [154] = Utf8 java/lang/StringBuffer 
.const [155] = Utf8 append 
.const [156] = Utf8 (Ljava/lang/String;)Ljava/lang/StringBuffer; 
.const [157] = Utf8 java/lang/StringBuffer 
.const [158] = Utf8 append 
.const [159] = Utf8 (I)Ljava/lang/StringBuffer; 
.const [160] = Utf8 java/lang/StringBuffer 
.const [161] = Utf8 toString 
.const [162] = Utf8 ()Ljava/lang/String; 
.const [163] = Utf8 de/esolutions/fw/util/serializer/exception/SerializerException 
.const [164] = Utf8 getMessage 
.const [165] = Utf8 ()Ljava/lang/String; 
.const [166] = Utf8 de/esolutions/fw/comm/core/ServiceInstanceID 
.const [167] = Utf8 <init> 
.const [168] = Utf8 (Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V 
.const [169] = Utf8 de/esolutions/fw/comm/core/AbstractReplyService 
.const [170] = Utf8 <init> 
.const [171] = Utf8 (Lde/esolutions/fw/comm/core/ServiceInstanceID;)V 
.const [172] = Utf8 de/esolutions/fw/comm/dsi/networking/impl/DSIDataConnectionReplyService 
.const [173] = Utf8 dynamicHandle 
.const [174] = Utf8 I 
.const [175] = Utf8 de/esolutions/fw/comm/dsi/networking/impl/DSIDataConnectionReplyService 
.const [176] = Utf8 context 
.const [177] = Utf8 Lde/esolutions/fw/comm/core/CallContext; 
.const [178] = Utf8 java/lang/StringBuffer 
.const [179] = Utf8 <init> 
.const [180] = Utf8 ()V 
.const [181] = Utf8 de/esolutions/fw/comm/core/method/MethodException 
.const [182] = Utf8 <init> 
.const [183] = Utf8 (Ljava/lang/String;)V 
.const [184] = Utf8 de/esolutions/fw/comm/dsi/networking/impl/DSIDataConnectionReplyService 
.const [185] = Utf8 p_DSIDataConnectionReply 
.const [186] = Utf8 Lde/esolutions/fw/comm/dsi/networking/DSIDataConnectionReply; 
.const [187] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [188] = Utf8 getInt32 
.const [189] = Utf8 ()I 
.const [190] = Utf8 de/esolutions/fw/comm/dsi/networking/DSIDataConnectionReply 
.const [191] = Utf8 updateStateDataConnection 
.const [192] = Utf8 (Lorg/dsi/ifc/networking/DataConnectionStateStruct;I)V 
.const [193] = Utf8 de/esolutions/fw/comm/dsi/networking/DSIDataConnectionReply 
.const [194] = Utf8 updateConnectionStateInformation 
.const [195] = Utf8 (Lorg/dsi/ifc/networking/ConnectionStateInformationStruct;I)V 
.const [196] = Utf8 de/esolutions/fw/comm/dsi/networking/DSIDataConnectionReply 
.const [197] = Utf8 updateRoamingState 
.const [198] = Utf8 (II)V 
.const [199] = Utf8 de/esolutions/fw/comm/dsi/networking/DSIDataConnectionReply 
.const [200] = Utf8 updateErrorState 
.const [201] = Utf8 (Lorg/dsi/ifc/networking/ApplicationErrorStruct;I)V 
.const [202] = Utf8 de/esolutions/fw/comm/dsi/networking/DSIDataConnectionReply 
.const [203] = Utf8 forceDisconnectResponse 
.const [204] = Utf8 (I)V 
.const [205] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [206] = Utf8 getOptionalString 
.const [207] = Utf8 ()Ljava/lang/String; 
.const [208] = Utf8 de/esolutions/fw/comm/dsi/networking/DSIDataConnectionReply 
.const [209] = Utf8 asyncException 
.const [210] = Utf8 (ILjava/lang/String;I)V 
.const [211] = Utf8 de/esolutions/fw/comm/dsi/networking/DSIDataConnectionReply 
.const [212] = Utf8 yyIndication 
.const [213] = Utf8 (Ljava/lang/String;Ljava/lang/String;)V 
.const [214] = Utf8 de/esolutions/fw/comm/dsi/networking/impl/DSIDataConnectionReplyService 
.const [215] = Class [214] 
.const [216] = Utf8 de/esolutions/fw/comm/core/AbstractReplyService 
.const [217] = Class [216] 
.const [218] = Utf8 context 
.const [219] = Utf8 Lde/esolutions/fw/comm/core/CallContext; 
.const [220] = Utf8 dynamicHandle 
.const [221] = Utf8 I 
.const [222] = Utf8 p_DSIDataConnectionReply 
.const [223] = Utf8 Lde/esolutions/fw/comm/dsi/networking/DSIDataConnectionReply; 
.const [224] = Utf8 Code 
.const [225] = Utf8 <init> 
.const [226] = Utf8 (Lde/esolutions/fw/comm/dsi/networking/DSIDataConnectionReply;)V 
.const [227] = Utf8 nextDynamicHandle 
.const [228] = Utf8 ()I 
.const [229] = Utf8 getCallContext 
.const [230] = Utf8 ()Lde/esolutions/fw/comm/core/CallContext; 
.const [231] = Utf8 handleCallMethod 
.const [232] = Utf8 (SLde/esolutions/fw/util/serializer/IDeserializer;Lde/esolutions/fw/comm/core/IProxyFrontend;)V 
.const [233] = Utf8 <clinit> 
.const [234] = Utf8 ()V 
.end class 
