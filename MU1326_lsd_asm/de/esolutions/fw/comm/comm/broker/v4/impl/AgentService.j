.version 50 0 
.class public super [145] 
.super [147] 
.field private static final [148] [149] 
.field private [150] [151] 

.method public [153] : [154] 
    .attribute [152] .code stack 7 locals 0 
L0:     aload_0 
L1:     new [33] 
L4:     dup 
L5:     ldc [3] 
L7:     iload_1 
L8:     ldc [4] 
L10:    ldc [5] 
L12:    invokespecial [28] 
L15:    invokespecial [29] 
L18:    aload_0 
L19:    aload_2 
L20:    putfield [34] 
L23:    return 
L24:    
    .end code 
.end method 

.method public [155] : [156] 
    .attribute [152] .code stack 1 locals 0 
L0:     getstatic [6] 
L3:     areturn 
L4:     
    .end code 
.end method 

.method public [157] : [158] 
    .attribute [152] .code stack 4 locals 1 
        .catch [12] from L0 to L95 using L98 
L0:     iload_1 
L1:     lookupswitch 
            0 : L48 
            2 : L28 
            default : L68 

L28:    aload_2 
L29:    invokestatic [7] 
L32:    astore 4 
L34:    aload_0 
L35:    getfield [23] 
L38:    aload 4 
L40:    invokeinterface [35] 0 
L45:    goto L95 
L48:    aload_2 
L49:    invokestatic [8] 
L52:    astore 4 
L54:    aload_0 
L55:    getfield [23] 
L58:    aload 4 
L60:    invokeinterface [36] 0 
L65:    goto L95 
L68:    new [37] 
L71:    dup 
L72:    new [38] 
L75:    dup 
L76:    invokespecial [31] 
L79:    ldc [11] 
L81:    invokevirtual [24] 
L84:    iload_1 
L85:    invokevirtual [25] 
L88:    invokevirtual [26] 
L91:    invokespecial [32] 
L94:    athrow 
L95:    goto L140 
L98:    astore 4 
L100:   new [37] 
L103:   dup 
L104:   new [38] 
L107:   dup 
L108:   invokespecial [31] 
L111:   ldc [13] 
L113:   invokevirtual [24] 
L116:   iload_1 
L117:   invokevirtual [25] 
L120:   ldc [14] 
L122:   invokevirtual [24] 
L125:   aload 4 
L127:   invokevirtual [27] 
L130:   invokevirtual [24] 
L133:   invokevirtual [26] 
L136:   invokespecial [32] 
L139:   athrow 
L140:   return 
L141:   nop 
L142:   nop 
L143:   nop 
L144:   
    .end code 
.end method 

.method static [159] : [160] 
    .attribute [152] .code stack 1 locals 0 
L0:     ldc [15] 
L2:     invokestatic [16] 
L5:     putstatic [30] 
L8:     return 
L9:     nop 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [39] 
.const [3] = String [40] 
.const [4] = String [41] 
.const [5] = String [42] 
.const [6] = Field [43] [44] 
.const [7] = Method [45] [46] 
.const [8] = Method [47] [48] 
.const [9] = Class [49] 
.const [10] = Class [50] 
.const [11] = String [51] 
.const [12] = Class [52] 
.const [13] = String [53] 
.const [14] = String [54] 
.const [15] = String [55] 
.const [16] = Method [56] [57] 
.const [17] = Class [58] 
.const [18] = Class [59] 
.const [19] = Class [60] 
.const [20] = Class [61] 
.const [21] = Class [62] 
.const [22] = Class [63] 
.const [23] = Field [64] [65] 
.const [24] = Method [66] [67] 
.const [25] = Method [68] [69] 
.const [26] = Method [70] [71] 
.const [27] = Method [72] [73] 
.const [28] = Method [74] [75] 
.const [29] = Method [76] [77] 
.const [30] = Field [78] [79] 
.const [31] = Method [80] [81] 
.const [32] = Method [82] [83] 
.const [33] = Class [84] 
.const [34] = Field [85] [86] 
.const [35] = InterfaceMethod [87] [88] 
.const [36] = InterfaceMethod [89] [90] 
.const [37] = Class [91] 
.const [38] = Class [92] 
.const [39] = Utf8 de/esolutions/fw/comm/core/ServiceInstanceID 
.const [40] = Utf8 '78a07e56-255a-4309-8bde-b1e1c73bc71c' 
.const [41] = Utf8 '299585a3-5e89-5854-a716-dafd54af2e50' 
.const [42] = Utf8 'comm.broker.Agent' 
.const [43] = Class [93] 
.const [44] = NameAndType [94] [95] 
.const [45] = Class [96] 
.const [46] = NameAndType [97] [98] 
.const [47] = Class [99] 
.const [48] = NameAndType [100] [101] 
.const [49] = Utf8 de/esolutions/fw/comm/core/method/MethodException 
.const [50] = Utf8 java/lang/StringBuffer 
.const [51] = Utf8 'Invalid Method Id ' 
.const [52] = Utf8 de/esolutions/fw/util/serializer/exception/SerializerException 
.const [53] = Utf8 'Deserialization failed: method=' 
.const [54] = Utf8 ', error=' 
.const [55] = Utf8 'STUB.comm.broker.Agent' 
.const [56] = Class [102] 
.const [57] = NameAndType [103] [104] 
.const [58] = Utf8 de/esolutions/fw/comm/comm/broker/v4/impl/AgentService 
.const [59] = Utf8 de/esolutions/fw/comm/core/AbstractService 
.const [60] = Utf8 de/esolutions/fw/comm/comm/broker/v4/impl/UpdateEventSerializer 
.const [61] = Utf8 de/esolutions/fw/comm/comm/broker/v4/Agent 
.const [62] = Utf8 de/esolutions/fw/comm/comm/broker/v4/impl/AgentUpdateEventSerializer 
.const [63] = Utf8 de/esolutions/fw/comm/core/CallContext 
.const [64] = Class [105] 
.const [65] = NameAndType [106] [107] 
.const [66] = Class [108] 
.const [67] = NameAndType [109] [110] 
.const [68] = Class [111] 
.const [69] = NameAndType [112] [113] 
.const [70] = Class [114] 
.const [71] = NameAndType [115] [116] 
.const [72] = Class [117] 
.const [73] = NameAndType [118] [119] 
.const [74] = Class [120] 
.const [75] = NameAndType [121] [122] 
.const [76] = Class [123] 
.const [77] = NameAndType [124] [125] 
.const [78] = Class [126] 
.const [79] = NameAndType [127] [128] 
.const [80] = Class [129] 
.const [81] = NameAndType [130] [131] 
.const [82] = Class [132] 
.const [83] = NameAndType [133] [134] 
.const [84] = Utf8 de/esolutions/fw/comm/core/ServiceInstanceID 
.const [85] = Class [135] 
.const [86] = NameAndType [136] [137] 
.const [87] = Class [138] 
.const [88] = NameAndType [139] [140] 
.const [89] = Class [141] 
.const [90] = NameAndType [142] [143] 
.const [91] = Utf8 de/esolutions/fw/comm/core/method/MethodException 
.const [92] = Utf8 java/lang/StringBuffer 
.const [93] = Utf8 de/esolutions/fw/comm/comm/broker/v4/impl/AgentService 
.const [94] = Utf8 context 
.const [95] = Utf8 Lde/esolutions/fw/comm/core/CallContext; 
.const [96] = Utf8 de/esolutions/fw/comm/comm/broker/v4/impl/UpdateEventSerializer 
.const [97] = Utf8 getOptionalUpdateEventVarArray 
.const [98] = Utf8 (Lde/esolutions/fw/util/serializer/IDeserializer;)[Lde/esolutions/fw/comm/comm/broker/v4/UpdateEvent; 
.const [99] = Utf8 de/esolutions/fw/comm/comm/broker/v4/impl/AgentUpdateEventSerializer 
.const [100] = Utf8 getOptionalAgentUpdateEventVarArray 
.const [101] = Utf8 (Lde/esolutions/fw/util/serializer/IDeserializer;)[Lde/esolutions/fw/comm/comm/broker/v4/AgentUpdateEvent; 
.const [102] = Utf8 de/esolutions/fw/comm/core/CallContext 
.const [103] = Utf8 getContext 
.const [104] = Utf8 (Ljava/lang/String;)Lde/esolutions/fw/comm/core/CallContext; 
.const [105] = Utf8 de/esolutions/fw/comm/comm/broker/v4/impl/AgentService 
.const [106] = Utf8 p_Agent 
.const [107] = Utf8 Lde/esolutions/fw/comm/comm/broker/v4/Agent; 
.const [108] = Utf8 java/lang/StringBuffer 
.const [109] = Utf8 append 
.const [110] = Utf8 (Ljava/lang/String;)Ljava/lang/StringBuffer; 
.const [111] = Utf8 java/lang/StringBuffer 
.const [112] = Utf8 append 
.const [113] = Utf8 (I)Ljava/lang/StringBuffer; 
.const [114] = Utf8 java/lang/StringBuffer 
.const [115] = Utf8 toString 
.const [116] = Utf8 ()Ljava/lang/String; 
.const [117] = Utf8 de/esolutions/fw/util/serializer/exception/SerializerException 
.const [118] = Utf8 getMessage 
.const [119] = Utf8 ()Ljava/lang/String; 
.const [120] = Utf8 de/esolutions/fw/comm/core/ServiceInstanceID 
.const [121] = Utf8 <init> 
.const [122] = Utf8 (Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V 
.const [123] = Utf8 de/esolutions/fw/comm/core/AbstractService 
.const [124] = Utf8 <init> 
.const [125] = Utf8 (Lde/esolutions/fw/comm/core/ServiceInstanceID;)V 
.const [126] = Utf8 de/esolutions/fw/comm/comm/broker/v4/impl/AgentService 
.const [127] = Utf8 context 
.const [128] = Utf8 Lde/esolutions/fw/comm/core/CallContext; 
.const [129] = Utf8 java/lang/StringBuffer 
.const [130] = Utf8 <init> 
.const [131] = Utf8 ()V 
.const [132] = Utf8 de/esolutions/fw/comm/core/method/MethodException 
.const [133] = Utf8 <init> 
.const [134] = Utf8 (Ljava/lang/String;)V 
.const [135] = Utf8 de/esolutions/fw/comm/comm/broker/v4/impl/AgentService 
.const [136] = Utf8 p_Agent 
.const [137] = Utf8 Lde/esolutions/fw/comm/comm/broker/v4/Agent; 
.const [138] = Utf8 de/esolutions/fw/comm/comm/broker/v4/Agent 
.const [139] = Utf8 serviceUpdate 
.const [140] = Utf8 ([Lde/esolutions/fw/comm/comm/broker/v4/UpdateEvent;)V 
.const [141] = Utf8 de/esolutions/fw/comm/comm/broker/v4/Agent 
.const [142] = Utf8 agentUpdate 
.const [143] = Utf8 ([Lde/esolutions/fw/comm/comm/broker/v4/AgentUpdateEvent;)V 
.const [144] = Utf8 de/esolutions/fw/comm/comm/broker/v4/impl/AgentService 
.const [145] = Class [144] 
.const [146] = Utf8 de/esolutions/fw/comm/core/AbstractService 
.const [147] = Class [146] 
.const [148] = Utf8 context 
.const [149] = Utf8 Lde/esolutions/fw/comm/core/CallContext; 
.const [150] = Utf8 p_Agent 
.const [151] = Utf8 Lde/esolutions/fw/comm/comm/broker/v4/Agent; 
.const [152] = Utf8 Code 
.const [153] = Utf8 <init> 
.const [154] = Utf8 (ILde/esolutions/fw/comm/comm/broker/v4/Agent;)V 
.const [155] = Utf8 getCallContext 
.const [156] = Utf8 ()Lde/esolutions/fw/comm/core/CallContext; 
.const [157] = Utf8 handleCallMethod 
.const [158] = Utf8 (SLde/esolutions/fw/util/serializer/IDeserializer;Lde/esolutions/fw/comm/core/IProxyFrontend;)V 
.const [159] = Utf8 <clinit> 
.const [160] = Utf8 ()V 
.end class 
