.version 50 0 
.class public super [157] 
.super [159] 
.field private static final [160] [161] 
.field private [162] [163] 

.method public [165] : [166] 
    .attribute [164] .code stack 7 locals 0 
L0:     aload_0 
L1:     new [32] 
L4:     dup 
L5:     ldc [3] 
L7:     iload_1 
L8:     ldc [4] 
L10:    ldc [5] 
L12:    invokespecial [27] 
L15:    invokespecial [28] 
L18:    aload_0 
L19:    aload_2 
L20:    putfield [33] 
L23:    return 
L24:    
    .end code 
.end method 

.method public [167] : [168] 
    .attribute [164] .code stack 1 locals 0 
L0:     getstatic [6] 
L3:     areturn 
L4:     
    .end code 
.end method 

.method public [169] : [170] 
    .attribute [164] .code stack 4 locals 2 
        .catch [11] from L0 to L169 using L172 
L0:     iload_1 
L1:     tableswitch 0 
            L32 
            L112 
            L52 
            L82 
            default : L142 

L32:    aload_2 
L33:    invokestatic [7] 
L36:    astore 4 
L38:    aload_0 
L39:    getfield [22] 
L42:    aload 4 
L44:    invokeinterface [34] 0 
L49:    goto L169 
L52:    aload_2 
L53:    invokestatic [7] 
L56:    astore 4 
L58:    aload_2 
L59:    invokeinterface [35] 0 
L64:    istore 5 
L66:    aload_0 
L67:    getfield [22] 
L70:    aload 4 
L72:    iload 5 
L74:    invokeinterface [36] 0 
L79:    goto L169 
L82:    aload_2 
L83:    invokestatic [7] 
L86:    astore 4 
L88:    aload_2 
L89:    invokeinterface [35] 0 
L94:    istore 5 
L96:    aload_0 
L97:    getfield [22] 
L100:   aload 4 
L102:   iload 5 
L104:   invokeinterface [37] 0 
L109:   goto L169 
L112:   aload_2 
L113:   invokestatic [7] 
L116:   astore 4 
L118:   aload_2 
L119:   invokeinterface [35] 0 
L124:   istore 5 
L126:   aload_0 
L127:   getfield [22] 
L130:   aload 4 
L132:   iload 5 
L134:   invokeinterface [38] 0 
L139:   goto L169 
L142:   new [39] 
L145:   dup 
L146:   new [40] 
L149:   dup 
L150:   invokespecial [30] 
L153:   ldc [10] 
L155:   invokevirtual [23] 
L158:   iload_1 
L159:   invokevirtual [24] 
L162:   invokevirtual [25] 
L165:   invokespecial [31] 
L168:   athrow 
L169:   goto L214 
L172:   astore 4 
L174:   new [39] 
L177:   dup 
L178:   new [40] 
L181:   dup 
L182:   invokespecial [30] 
L185:   ldc [12] 
L187:   invokevirtual [23] 
L190:   iload_1 
L191:   invokevirtual [24] 
L194:   ldc [13] 
L196:   invokevirtual [23] 
L199:   aload 4 
L201:   invokevirtual [26] 
L204:   invokevirtual [23] 
L207:   invokevirtual [25] 
L210:   invokespecial [31] 
L213:   athrow 
L214:   return 
L215:   nop 
L216:   
    .end code 
.end method 

.method static [171] : [172] 
    .attribute [164] .code stack 1 locals 0 
L0:     ldc [14] 
L2:     invokestatic [15] 
L5:     putstatic [29] 
L8:     return 
L9:     nop 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [41] 
.const [3] = String [42] 
.const [4] = String [43] 
.const [5] = String [44] 
.const [6] = Field [45] [46] 
.const [7] = Method [47] [48] 
.const [8] = Class [49] 
.const [9] = Class [50] 
.const [10] = String [51] 
.const [11] = Class [52] 
.const [12] = String [53] 
.const [13] = String [54] 
.const [14] = String [55] 
.const [15] = Method [56] [57] 
.const [16] = Class [58] 
.const [17] = Class [59] 
.const [18] = Class [60] 
.const [19] = Class [61] 
.const [20] = Class [62] 
.const [21] = Class [63] 
.const [22] = Field [64] [65] 
.const [23] = Method [66] [67] 
.const [24] = Method [68] [69] 
.const [25] = Method [70] [71] 
.const [26] = Method [72] [73] 
.const [27] = Method [74] [75] 
.const [28] = Method [76] [77] 
.const [29] = Field [78] [79] 
.const [30] = Method [80] [81] 
.const [31] = Method [82] [83] 
.const [32] = Class [84] 
.const [33] = Field [85] [86] 
.const [34] = InterfaceMethod [87] [88] 
.const [35] = InterfaceMethod [89] [90] 
.const [36] = InterfaceMethod [91] [92] 
.const [37] = InterfaceMethod [93] [94] 
.const [38] = InterfaceMethod [95] [96] 
.const [39] = Class [97] 
.const [40] = Class [98] 
.const [41] = Utf8 de/esolutions/fw/comm/core/ServiceInstanceID 
.const [42] = Utf8 '8d4f7cec-be0c-49b7-b1b6-1e3e4c26b847' 
.const [43] = Utf8 '8935d19b-313a-5d23-bf1f-64bc869ad5a7' 
.const [44] = Utf8 'comm.broker.Broker' 
.const [45] = Class [99] 
.const [46] = NameAndType [100] [101] 
.const [47] = Class [102] 
.const [48] = NameAndType [103] [104] 
.const [49] = Utf8 de/esolutions/fw/comm/core/method/MethodException 
.const [50] = Utf8 java/lang/StringBuffer 
.const [51] = Utf8 'Invalid Method Id ' 
.const [52] = Utf8 de/esolutions/fw/util/serializer/exception/SerializerException 
.const [53] = Utf8 'Deserialization failed: method=' 
.const [54] = Utf8 ', error=' 
.const [55] = Utf8 'STUB.comm.broker.Broker' 
.const [56] = Class [105] 
.const [57] = NameAndType [106] [107] 
.const [58] = Utf8 de/esolutions/fw/comm/comm/broker/v4/impl/BrokerService 
.const [59] = Utf8 de/esolutions/fw/comm/core/AbstractService 
.const [60] = Utf8 de/esolutions/fw/comm/comm/broker/v4/impl/InstanceIDSerializer 
.const [61] = Utf8 de/esolutions/fw/comm/comm/broker/v4/Broker 
.const [62] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [63] = Utf8 de/esolutions/fw/comm/core/CallContext 
.const [64] = Class [108] 
.const [65] = NameAndType [109] [110] 
.const [66] = Class [111] 
.const [67] = NameAndType [112] [113] 
.const [68] = Class [114] 
.const [69] = NameAndType [115] [116] 
.const [70] = Class [117] 
.const [71] = NameAndType [118] [119] 
.const [72] = Class [120] 
.const [73] = NameAndType [121] [122] 
.const [74] = Class [123] 
.const [75] = NameAndType [124] [125] 
.const [76] = Class [126] 
.const [77] = NameAndType [127] [128] 
.const [78] = Class [129] 
.const [79] = NameAndType [130] [131] 
.const [80] = Class [132] 
.const [81] = NameAndType [133] [134] 
.const [82] = Class [135] 
.const [83] = NameAndType [136] [137] 
.const [84] = Utf8 de/esolutions/fw/comm/core/ServiceInstanceID 
.const [85] = Class [138] 
.const [86] = NameAndType [139] [140] 
.const [87] = Class [141] 
.const [88] = NameAndType [142] [143] 
.const [89] = Class [144] 
.const [90] = NameAndType [145] [146] 
.const [91] = Class [147] 
.const [92] = NameAndType [148] [149] 
.const [93] = Class [150] 
.const [94] = NameAndType [151] [152] 
.const [95] = Class [153] 
.const [96] = NameAndType [154] [155] 
.const [97] = Utf8 de/esolutions/fw/comm/core/method/MethodException 
.const [98] = Utf8 java/lang/StringBuffer 
.const [99] = Utf8 de/esolutions/fw/comm/comm/broker/v4/impl/BrokerService 
.const [100] = Utf8 context 
.const [101] = Utf8 Lde/esolutions/fw/comm/core/CallContext; 
.const [102] = Utf8 de/esolutions/fw/comm/comm/broker/v4/impl/InstanceIDSerializer 
.const [103] = Utf8 getOptionalInstanceID 
.const [104] = Utf8 (Lde/esolutions/fw/util/serializer/IDeserializer;)Lde/esolutions/fw/comm/comm/broker/v4/InstanceID; 
.const [105] = Utf8 de/esolutions/fw/comm/core/CallContext 
.const [106] = Utf8 getContext 
.const [107] = Utf8 (Ljava/lang/String;)Lde/esolutions/fw/comm/core/CallContext; 
.const [108] = Utf8 de/esolutions/fw/comm/comm/broker/v4/impl/BrokerService 
.const [109] = Utf8 p_Broker 
.const [110] = Utf8 Lde/esolutions/fw/comm/comm/broker/v4/Broker; 
.const [111] = Utf8 java/lang/StringBuffer 
.const [112] = Utf8 append 
.const [113] = Utf8 (Ljava/lang/String;)Ljava/lang/StringBuffer; 
.const [114] = Utf8 java/lang/StringBuffer 
.const [115] = Utf8 append 
.const [116] = Utf8 (I)Ljava/lang/StringBuffer; 
.const [117] = Utf8 java/lang/StringBuffer 
.const [118] = Utf8 toString 
.const [119] = Utf8 ()Ljava/lang/String; 
.const [120] = Utf8 de/esolutions/fw/util/serializer/exception/SerializerException 
.const [121] = Utf8 getMessage 
.const [122] = Utf8 ()Ljava/lang/String; 
.const [123] = Utf8 de/esolutions/fw/comm/core/ServiceInstanceID 
.const [124] = Utf8 <init> 
.const [125] = Utf8 (Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V 
.const [126] = Utf8 de/esolutions/fw/comm/core/AbstractService 
.const [127] = Utf8 <init> 
.const [128] = Utf8 (Lde/esolutions/fw/comm/core/ServiceInstanceID;)V 
.const [129] = Utf8 de/esolutions/fw/comm/comm/broker/v4/impl/BrokerService 
.const [130] = Utf8 context 
.const [131] = Utf8 Lde/esolutions/fw/comm/core/CallContext; 
.const [132] = Utf8 java/lang/StringBuffer 
.const [133] = Utf8 <init> 
.const [134] = Utf8 ()V 
.const [135] = Utf8 de/esolutions/fw/comm/core/method/MethodException 
.const [136] = Utf8 <init> 
.const [137] = Utf8 (Ljava/lang/String;)V 
.const [138] = Utf8 de/esolutions/fw/comm/comm/broker/v4/impl/BrokerService 
.const [139] = Utf8 p_Broker 
.const [140] = Utf8 Lde/esolutions/fw/comm/comm/broker/v4/Broker; 
.const [141] = Utf8 de/esolutions/fw/comm/comm/broker/v4/Broker 
.const [142] = Utf8 announce 
.const [143] = Utf8 (Lde/esolutions/fw/comm/comm/broker/v4/InstanceID;)V 
.const [144] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [145] = Utf8 getUInt16 
.const [146] = Utf8 ()I 
.const [147] = Utf8 de/esolutions/fw/comm/comm/broker/v4/Broker 
.const [148] = Utf8 registerService 
.const [149] = Utf8 (Lde/esolutions/fw/comm/comm/broker/v4/InstanceID;I)V 
.const [150] = Utf8 de/esolutions/fw/comm/comm/broker/v4/Broker 
.const [151] = Utf8 unregisterService 
.const [152] = Utf8 (Lde/esolutions/fw/comm/comm/broker/v4/InstanceID;I)V 
.const [153] = Utf8 de/esolutions/fw/comm/comm/broker/v4/Broker 
.const [154] = Utf8 lookupService 
.const [155] = Utf8 (Lde/esolutions/fw/comm/comm/broker/v4/InstanceID;I)V 
.const [156] = Utf8 de/esolutions/fw/comm/comm/broker/v4/impl/BrokerService 
.const [157] = Class [156] 
.const [158] = Utf8 de/esolutions/fw/comm/core/AbstractService 
.const [159] = Class [158] 
.const [160] = Utf8 context 
.const [161] = Utf8 Lde/esolutions/fw/comm/core/CallContext; 
.const [162] = Utf8 p_Broker 
.const [163] = Utf8 Lde/esolutions/fw/comm/comm/broker/v4/Broker; 
.const [164] = Utf8 Code 
.const [165] = Utf8 <init> 
.const [166] = Utf8 (ILde/esolutions/fw/comm/comm/broker/v4/Broker;)V 
.const [167] = Utf8 getCallContext 
.const [168] = Utf8 ()Lde/esolutions/fw/comm/core/CallContext; 
.const [169] = Utf8 handleCallMethod 
.const [170] = Utf8 (SLde/esolutions/fw/util/serializer/IDeserializer;Lde/esolutions/fw/comm/core/IProxyFrontend;)V 
.const [171] = Utf8 <clinit> 
.const [172] = Utf8 ()V 
.end class 
