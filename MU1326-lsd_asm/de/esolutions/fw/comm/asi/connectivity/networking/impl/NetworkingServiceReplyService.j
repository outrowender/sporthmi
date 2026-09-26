.version 50 0 
.class public super [185] 
.super [187] 
.field private static final [188] [189] 
.field private static [190] [191] 
.field private [192] [193] 

.method public [195] : [196] 
    .attribute [194] .code stack 7 locals 0 
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

.method private static synchronized [197] : [198] 
    .attribute [194] .code stack 2 locals 1 
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

.method public [199] : [200] 
    .attribute [194] .code stack 1 locals 0 
L0:     getstatic [8] 
L3:     areturn 
L4:     
    .end code 
.end method 

.method public [201] : [202] 
    .attribute [194] .code stack 5 locals 4 
        .catch [12] from L0 to L233 using L236 
L0:     iload_1 
L1:     tableswitch 0 
            L66 
            L44 
            L110 
            L88 
            L132 
            L206 
            L154 
            default : L206 

L44:    aload_2 
L45:    invokeinterface [35] 0 
L50:    istore 4 
L52:    aload_0 
L53:    getfield [22] 
L56:    iload 4 
L58:    invokeinterface [36] 0 
L63:    goto L233 
L66:    aload_2 
L67:    invokeinterface [35] 0 
L72:    istore 4 
L74:    aload_0 
L75:    getfield [22] 
L78:    iload 4 
L80:    invokeinterface [37] 0 
L85:    goto L233 
L88:    aload_2 
L89:    invokeinterface [35] 0 
L94:    istore 4 
L96:    aload_0 
L97:    getfield [22] 
L100:   iload 4 
L102:   invokeinterface [38] 0 
L107:   goto L233 
L110:   aload_2 
L111:   invokeinterface [39] 0 
L116:   astore 4 
L118:   aload_0 
L119:   getfield [22] 
L122:   aload 4 
L124:   invokeinterface [40] 0 
L129:   goto L233 
L132:   aload_2 
L133:   invokeinterface [35] 0 
L138:   istore 4 
L140:   aload_0 
L141:   getfield [22] 
L144:   iload 4 
L146:   invokeinterface [41] 0 
L151:   goto L233 
L154:   aload_2 
L155:   invokeinterface [39] 0 
L160:   astore 4 
L162:   aload_2 
L163:   invokeinterface [39] 0 
L168:   astore 5 
L170:   aload_2 
L171:   invokeinterface [39] 0 
L176:   astore 6 
L178:   aload_2 
L179:   invokeinterface [39] 0 
L184:   astore 7 
L186:   aload_0 
L187:   getfield [22] 
L190:   aload 4 
L192:   aload 5 
L194:   aload 6 
L196:   aload 7 
L198:   invokeinterface [42] 0 
L203:   goto L233 
L206:   new [43] 
L209:   dup 
L210:   new [44] 
L213:   dup 
L214:   invokespecial [31] 
L217:   ldc [11] 
L219:   invokevirtual [23] 
L222:   iload_1 
L223:   invokevirtual [24] 
L226:   invokevirtual [25] 
L229:   invokespecial [32] 
L232:   athrow 
L233:   goto L278 
L236:   astore 4 
L238:   new [43] 
L241:   dup 
L242:   new [44] 
L245:   dup 
L246:   invokespecial [31] 
L249:   ldc [13] 
L251:   invokevirtual [23] 
L254:   iload_1 
L255:   invokevirtual [24] 
L258:   ldc [14] 
L260:   invokevirtual [23] 
L263:   aload 4 
L265:   invokevirtual [26] 
L268:   invokevirtual [23] 
L271:   invokevirtual [25] 
L274:   invokespecial [32] 
L277:   athrow 
L278:   return 
L279:   nop 
L280:   
    .end code 
.end method 

.method static [203] : [204] 
    .attribute [194] .code stack 1 locals 0 
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
.const [2] = Class [45] 
.const [3] = String [46] 
.const [4] = Method [47] [48] 
.const [5] = String [49] 
.const [6] = String [50] 
.const [7] = Field [51] [52] 
.const [8] = Field [53] [54] 
.const [9] = Class [55] 
.const [10] = Class [56] 
.const [11] = String [57] 
.const [12] = Class [58] 
.const [13] = String [59] 
.const [14] = String [60] 
.const [15] = String [61] 
.const [16] = Method [62] [63] 
.const [17] = Class [64] 
.const [18] = Class [65] 
.const [19] = Class [66] 
.const [20] = Class [67] 
.const [21] = Class [68] 
.const [22] = Field [69] [70] 
.const [23] = Method [71] [72] 
.const [24] = Method [73] [74] 
.const [25] = Method [75] [76] 
.const [26] = Method [77] [78] 
.const [27] = Method [79] [80] 
.const [28] = Method [81] [82] 
.const [29] = Field [83] [84] 
.const [30] = Field [85] [86] 
.const [31] = Method [87] [88] 
.const [32] = Method [89] [90] 
.const [33] = Class [91] 
.const [34] = Field [92] [93] 
.const [35] = InterfaceMethod [94] [95] 
.const [36] = InterfaceMethod [96] [97] 
.const [37] = InterfaceMethod [98] [99] 
.const [38] = InterfaceMethod [100] [101] 
.const [39] = InterfaceMethod [102] [103] 
.const [40] = InterfaceMethod [104] [105] 
.const [41] = InterfaceMethod [106] [107] 
.const [42] = InterfaceMethod [108] [109] 
.const [43] = Class [110] 
.const [44] = Class [111] 
.const [45] = Utf8 de/esolutions/fw/comm/core/ServiceInstanceID 
.const [46] = Utf8 '54bd523b-eece-4101-9c88-53bb869c6b64' 
.const [47] = Class [112] 
.const [48] = NameAndType [113] [114] 
.const [49] = Utf8 '9d2b4f14-42b2-506b-aae0-1904af2be1f8' 
.const [50] = Utf8 'asi.connectivity.networking.NetworkingService' 
.const [51] = Class [115] 
.const [52] = NameAndType [116] [117] 
.const [53] = Class [118] 
.const [54] = NameAndType [119] [120] 
.const [55] = Utf8 de/esolutions/fw/comm/core/method/MethodException 
.const [56] = Utf8 java/lang/StringBuffer 
.const [57] = Utf8 'Invalid Method Id ' 
.const [58] = Utf8 de/esolutions/fw/util/serializer/exception/SerializerException 
.const [59] = Utf8 'Deserialization failed: method=' 
.const [60] = Utf8 ', error=' 
.const [61] = Utf8 'STUB.asi.connectivity.networking.NetworkingService' 
.const [62] = Class [121] 
.const [63] = NameAndType [122] [123] 
.const [64] = Utf8 de/esolutions/fw/comm/asi/connectivity/networking/impl/NetworkingServiceReplyService 
.const [65] = Utf8 de/esolutions/fw/comm/core/AbstractReplyService 
.const [66] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [67] = Utf8 de/esolutions/fw/comm/asi/connectivity/networking/NetworkingServiceReply 
.const [68] = Utf8 de/esolutions/fw/comm/core/CallContext 
.const [69] = Class [124] 
.const [70] = NameAndType [125] [126] 
.const [71] = Class [127] 
.const [72] = NameAndType [128] [129] 
.const [73] = Class [130] 
.const [74] = NameAndType [131] [132] 
.const [75] = Class [133] 
.const [76] = NameAndType [134] [135] 
.const [77] = Class [136] 
.const [78] = NameAndType [137] [138] 
.const [79] = Class [139] 
.const [80] = NameAndType [140] [141] 
.const [81] = Class [142] 
.const [82] = NameAndType [143] [144] 
.const [83] = Class [145] 
.const [84] = NameAndType [146] [147] 
.const [85] = Class [148] 
.const [86] = NameAndType [149] [150] 
.const [87] = Class [151] 
.const [88] = NameAndType [152] [153] 
.const [89] = Class [154] 
.const [90] = NameAndType [155] [156] 
.const [91] = Utf8 de/esolutions/fw/comm/core/ServiceInstanceID 
.const [92] = Class [157] 
.const [93] = NameAndType [158] [159] 
.const [94] = Class [160] 
.const [95] = NameAndType [161] [162] 
.const [96] = Class [163] 
.const [97] = NameAndType [164] [165] 
.const [98] = Class [166] 
.const [99] = NameAndType [167] [168] 
.const [100] = Class [169] 
.const [101] = NameAndType [170] [171] 
.const [102] = Class [172] 
.const [103] = NameAndType [173] [174] 
.const [104] = Class [175] 
.const [105] = NameAndType [176] [177] 
.const [106] = Class [178] 
.const [107] = NameAndType [179] [180] 
.const [108] = Class [181] 
.const [109] = NameAndType [182] [183] 
.const [110] = Utf8 de/esolutions/fw/comm/core/method/MethodException 
.const [111] = Utf8 java/lang/StringBuffer 
.const [112] = Utf8 de/esolutions/fw/comm/asi/connectivity/networking/impl/NetworkingServiceReplyService 
.const [113] = Utf8 nextDynamicHandle 
.const [114] = Utf8 ()I 
.const [115] = Utf8 de/esolutions/fw/comm/asi/connectivity/networking/impl/NetworkingServiceReplyService 
.const [116] = Utf8 dynamicHandle 
.const [117] = Utf8 I 
.const [118] = Utf8 de/esolutions/fw/comm/asi/connectivity/networking/impl/NetworkingServiceReplyService 
.const [119] = Utf8 context 
.const [120] = Utf8 Lde/esolutions/fw/comm/core/CallContext; 
.const [121] = Utf8 de/esolutions/fw/comm/core/CallContext 
.const [122] = Utf8 getContext 
.const [123] = Utf8 (Ljava/lang/String;)Lde/esolutions/fw/comm/core/CallContext; 
.const [124] = Utf8 de/esolutions/fw/comm/asi/connectivity/networking/impl/NetworkingServiceReplyService 
.const [125] = Utf8 p_NetworkingServiceReply 
.const [126] = Utf8 Lde/esolutions/fw/comm/asi/connectivity/networking/NetworkingServiceReply; 
.const [127] = Utf8 java/lang/StringBuffer 
.const [128] = Utf8 append 
.const [129] = Utf8 (Ljava/lang/String;)Ljava/lang/StringBuffer; 
.const [130] = Utf8 java/lang/StringBuffer 
.const [131] = Utf8 append 
.const [132] = Utf8 (I)Ljava/lang/StringBuffer; 
.const [133] = Utf8 java/lang/StringBuffer 
.const [134] = Utf8 toString 
.const [135] = Utf8 ()Ljava/lang/String; 
.const [136] = Utf8 de/esolutions/fw/util/serializer/exception/SerializerException 
.const [137] = Utf8 getMessage 
.const [138] = Utf8 ()Ljava/lang/String; 
.const [139] = Utf8 de/esolutions/fw/comm/core/ServiceInstanceID 
.const [140] = Utf8 <init> 
.const [141] = Utf8 (Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V 
.const [142] = Utf8 de/esolutions/fw/comm/core/AbstractReplyService 
.const [143] = Utf8 <init> 
.const [144] = Utf8 (Lde/esolutions/fw/comm/core/ServiceInstanceID;)V 
.const [145] = Utf8 de/esolutions/fw/comm/asi/connectivity/networking/impl/NetworkingServiceReplyService 
.const [146] = Utf8 dynamicHandle 
.const [147] = Utf8 I 
.const [148] = Utf8 de/esolutions/fw/comm/asi/connectivity/networking/impl/NetworkingServiceReplyService 
.const [149] = Utf8 context 
.const [150] = Utf8 Lde/esolutions/fw/comm/core/CallContext; 
.const [151] = Utf8 java/lang/StringBuffer 
.const [152] = Utf8 <init> 
.const [153] = Utf8 ()V 
.const [154] = Utf8 de/esolutions/fw/comm/core/method/MethodException 
.const [155] = Utf8 <init> 
.const [156] = Utf8 (Ljava/lang/String;)V 
.const [157] = Utf8 de/esolutions/fw/comm/asi/connectivity/networking/impl/NetworkingServiceReplyService 
.const [158] = Utf8 p_NetworkingServiceReply 
.const [159] = Utf8 Lde/esolutions/fw/comm/asi/connectivity/networking/NetworkingServiceReply; 
.const [160] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [161] = Utf8 getEnum 
.const [162] = Utf8 ()I 
.const [163] = Utf8 de/esolutions/fw/comm/asi/connectivity/networking/NetworkingServiceReply 
.const [164] = Utf8 updateRoamingState 
.const [165] = Utf8 (I)V 
.const [166] = Utf8 de/esolutions/fw/comm/asi/connectivity/networking/NetworkingServiceReply 
.const [167] = Utf8 updateOnlineState 
.const [168] = Utf8 (I)V 
.const [169] = Utf8 de/esolutions/fw/comm/asi/connectivity/networking/NetworkingServiceReply 
.const [170] = Utf8 updateThrottlingState 
.const [171] = Utf8 (I)V 
.const [172] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [173] = Utf8 getOptionalString 
.const [174] = Utf8 ()Ljava/lang/String; 
.const [175] = Utf8 de/esolutions/fw/comm/asi/connectivity/networking/NetworkingServiceReply 
.const [176] = Utf8 updateServiceIdentifier 
.const [177] = Utf8 (Ljava/lang/String;)V 
.const [178] = Utf8 de/esolutions/fw/comm/asi/connectivity/networking/NetworkingServiceReply 
.const [179] = Utf8 updateSimCardType 
.const [180] = Utf8 (I)V 
.const [181] = Utf8 de/esolutions/fw/comm/asi/connectivity/networking/NetworkingServiceReply 
.const [182] = Utf8 updateSim 
.const [183] = Utf8 (Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V 
.const [184] = Utf8 de/esolutions/fw/comm/asi/connectivity/networking/impl/NetworkingServiceReplyService 
.const [185] = Class [184] 
.const [186] = Utf8 de/esolutions/fw/comm/core/AbstractReplyService 
.const [187] = Class [186] 
.const [188] = Utf8 context 
.const [189] = Utf8 Lde/esolutions/fw/comm/core/CallContext; 
.const [190] = Utf8 dynamicHandle 
.const [191] = Utf8 I 
.const [192] = Utf8 p_NetworkingServiceReply 
.const [193] = Utf8 Lde/esolutions/fw/comm/asi/connectivity/networking/NetworkingServiceReply; 
.const [194] = Utf8 Code 
.const [195] = Utf8 <init> 
.const [196] = Utf8 (Lde/esolutions/fw/comm/asi/connectivity/networking/NetworkingServiceReply;)V 
.const [197] = Utf8 nextDynamicHandle 
.const [198] = Utf8 ()I 
.const [199] = Utf8 getCallContext 
.const [200] = Utf8 ()Lde/esolutions/fw/comm/core/CallContext; 
.const [201] = Utf8 handleCallMethod 
.const [202] = Utf8 (SLde/esolutions/fw/util/serializer/IDeserializer;Lde/esolutions/fw/comm/core/IProxyFrontend;)V 
.const [203] = Utf8 <clinit> 
.const [204] = Utf8 ()V 
.end class 
