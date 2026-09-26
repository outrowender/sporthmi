.version 50 0 
.class public super [167] 
.super [169] 
.field private static final [170] [171] 
.field private static [172] [173] 
.field private [174] [175] 

.method public [177] : [178] 
    .attribute [176] .code stack 7 locals 0 
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

.method private static synchronized [179] : [180] 
    .attribute [176] .code stack 2 locals 1 
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

.method public [181] : [182] 
    .attribute [176] .code stack 1 locals 0 
L0:     getstatic [8] 
L3:     areturn 
L4:     
    .end code 
.end method 

.method public [183] : [184] 
    .attribute [176] .code stack 5 locals 4 
        .catch [12] from L0 to L139 using L142 
L0:     iload_1 
L1:     lookupswitch 
            0 : L28 
            1 : L70 
            default : L112 

L28:    aload_2 
L29:    invokeinterface [35] 0 
L34:    lstore 4 
L36:    aload_2 
L37:    invokeinterface [36] 0 
L42:    istore 6 
L44:    aload_2 
L45:    invokeinterface [36] 0 
L50:    istore 7 
L52:    aload_0 
L53:    getfield [22] 
L56:    lload 4 
L58:    iload 6 
L60:    iload 7 
L62:    invokeinterface [37] 0 
L67:    goto L139 
L70:    aload_2 
L71:    invokeinterface [35] 0 
L76:    lstore 4 
L78:    aload_2 
L79:    invokeinterface [36] 0 
L84:    istore 6 
L86:    aload_2 
L87:    invokeinterface [38] 0 
L92:    istore 7 
L94:    aload_0 
L95:    getfield [22] 
L98:    lload 4 
L100:   iload 6 
L102:   iload 7 
L104:   invokeinterface [39] 0 
L109:   goto L139 
L112:   new [40] 
L115:   dup 
L116:   new [41] 
L119:   dup 
L120:   invokespecial [31] 
L123:   ldc [11] 
L125:   invokevirtual [23] 
L128:   iload_1 
L129:   invokevirtual [24] 
L132:   invokevirtual [25] 
L135:   invokespecial [32] 
L138:   athrow 
L139:   goto L184 
L142:   astore 4 
L144:   new [40] 
L147:   dup 
L148:   new [41] 
L151:   dup 
L152:   invokespecial [31] 
L155:   ldc [13] 
L157:   invokevirtual [23] 
L160:   iload_1 
L161:   invokevirtual [24] 
L164:   ldc [14] 
L166:   invokevirtual [23] 
L169:   aload 4 
L171:   invokevirtual [26] 
L174:   invokevirtual [23] 
L177:   invokevirtual [25] 
L180:   invokespecial [32] 
L183:   athrow 
L184:   return 
L185:   nop 
L186:   nop 
L187:   nop 
L188:   
    .end code 
.end method 

.method static [185] : [186] 
    .attribute [176] .code stack 1 locals 0 
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
.const [2] = Class [42] 
.const [3] = String [43] 
.const [4] = Method [44] [45] 
.const [5] = String [46] 
.const [6] = String [47] 
.const [7] = Field [48] [49] 
.const [8] = Field [50] [51] 
.const [9] = Class [52] 
.const [10] = Class [53] 
.const [11] = String [54] 
.const [12] = Class [55] 
.const [13] = String [56] 
.const [14] = String [57] 
.const [15] = String [58] 
.const [16] = Method [59] [60] 
.const [17] = Class [61] 
.const [18] = Class [62] 
.const [19] = Class [63] 
.const [20] = Class [64] 
.const [21] = Class [65] 
.const [22] = Field [66] [67] 
.const [23] = Method [68] [69] 
.const [24] = Method [70] [71] 
.const [25] = Method [72] [73] 
.const [26] = Method [74] [75] 
.const [27] = Method [76] [77] 
.const [28] = Method [78] [79] 
.const [29] = Field [80] [81] 
.const [30] = Field [82] [83] 
.const [31] = Method [84] [85] 
.const [32] = Method [86] [87] 
.const [33] = Class [88] 
.const [34] = Field [89] [90] 
.const [35] = InterfaceMethod [91] [92] 
.const [36] = InterfaceMethod [93] [94] 
.const [37] = InterfaceMethod [95] [96] 
.const [38] = InterfaceMethod [97] [98] 
.const [39] = InterfaceMethod [99] [100] 
.const [40] = Class [101] 
.const [41] = Class [102] 
.const [42] = Utf8 de/esolutions/fw/comm/core/ServiceInstanceID 
.const [43] = Utf8 '455c3e9a-730d-4285-979c-61c4a9648fa2' 
.const [44] = Class [103] 
.const [45] = NameAndType [104] [105] 
.const [46] = Utf8 '473aed0f-a08a-5fd6-ab32-16d904233133' 
.const [47] = Utf8 'asi.connectivity.networking.NetworkingBluetoothBridge' 
.const [48] = Class [106] 
.const [49] = NameAndType [107] [108] 
.const [50] = Class [109] 
.const [51] = NameAndType [110] [111] 
.const [52] = Utf8 de/esolutions/fw/comm/core/method/MethodException 
.const [53] = Utf8 java/lang/StringBuffer 
.const [54] = Utf8 'Invalid Method Id ' 
.const [55] = Utf8 de/esolutions/fw/util/serializer/exception/SerializerException 
.const [56] = Utf8 'Deserialization failed: method=' 
.const [57] = Utf8 ', error=' 
.const [58] = Utf8 'STUB.asi.connectivity.networking.NetworkingBluetoothBridge' 
.const [59] = Class [112] 
.const [60] = NameAndType [113] [114] 
.const [61] = Utf8 de/esolutions/fw/comm/asi/connectivity/networking/impl/NetworkingBluetoothBridgeReplyService 
.const [62] = Utf8 de/esolutions/fw/comm/core/AbstractReplyService 
.const [63] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [64] = Utf8 de/esolutions/fw/comm/asi/connectivity/networking/NetworkingBluetoothBridgeReply 
.const [65] = Utf8 de/esolutions/fw/comm/core/CallContext 
.const [66] = Class [115] 
.const [67] = NameAndType [116] [117] 
.const [68] = Class [118] 
.const [69] = NameAndType [119] [120] 
.const [70] = Class [121] 
.const [71] = NameAndType [122] [123] 
.const [72] = Class [124] 
.const [73] = NameAndType [125] [126] 
.const [74] = Class [127] 
.const [75] = NameAndType [128] [129] 
.const [76] = Class [130] 
.const [77] = NameAndType [131] [132] 
.const [78] = Class [133] 
.const [79] = NameAndType [134] [135] 
.const [80] = Class [136] 
.const [81] = NameAndType [137] [138] 
.const [82] = Class [139] 
.const [83] = NameAndType [140] [141] 
.const [84] = Class [142] 
.const [85] = NameAndType [143] [144] 
.const [86] = Class [145] 
.const [87] = NameAndType [146] [147] 
.const [88] = Utf8 de/esolutions/fw/comm/core/ServiceInstanceID 
.const [89] = Class [148] 
.const [90] = NameAndType [149] [150] 
.const [91] = Class [151] 
.const [92] = NameAndType [152] [153] 
.const [93] = Class [154] 
.const [94] = NameAndType [155] [156] 
.const [95] = Class [157] 
.const [96] = NameAndType [158] [159] 
.const [97] = Class [160] 
.const [98] = NameAndType [161] [162] 
.const [99] = Class [163] 
.const [100] = NameAndType [164] [165] 
.const [101] = Utf8 de/esolutions/fw/comm/core/method/MethodException 
.const [102] = Utf8 java/lang/StringBuffer 
.const [103] = Utf8 de/esolutions/fw/comm/asi/connectivity/networking/impl/NetworkingBluetoothBridgeReplyService 
.const [104] = Utf8 nextDynamicHandle 
.const [105] = Utf8 ()I 
.const [106] = Utf8 de/esolutions/fw/comm/asi/connectivity/networking/impl/NetworkingBluetoothBridgeReplyService 
.const [107] = Utf8 dynamicHandle 
.const [108] = Utf8 I 
.const [109] = Utf8 de/esolutions/fw/comm/asi/connectivity/networking/impl/NetworkingBluetoothBridgeReplyService 
.const [110] = Utf8 context 
.const [111] = Utf8 Lde/esolutions/fw/comm/core/CallContext; 
.const [112] = Utf8 de/esolutions/fw/comm/core/CallContext 
.const [113] = Utf8 getContext 
.const [114] = Utf8 (Ljava/lang/String;)Lde/esolutions/fw/comm/core/CallContext; 
.const [115] = Utf8 de/esolutions/fw/comm/asi/connectivity/networking/impl/NetworkingBluetoothBridgeReplyService 
.const [116] = Utf8 p_NetworkingBluetoothBridgeReply 
.const [117] = Utf8 Lde/esolutions/fw/comm/asi/connectivity/networking/NetworkingBluetoothBridgeReply; 
.const [118] = Utf8 java/lang/StringBuffer 
.const [119] = Utf8 append 
.const [120] = Utf8 (Ljava/lang/String;)Ljava/lang/StringBuffer; 
.const [121] = Utf8 java/lang/StringBuffer 
.const [122] = Utf8 append 
.const [123] = Utf8 (I)Ljava/lang/StringBuffer; 
.const [124] = Utf8 java/lang/StringBuffer 
.const [125] = Utf8 toString 
.const [126] = Utf8 ()Ljava/lang/String; 
.const [127] = Utf8 de/esolutions/fw/util/serializer/exception/SerializerException 
.const [128] = Utf8 getMessage 
.const [129] = Utf8 ()Ljava/lang/String; 
.const [130] = Utf8 de/esolutions/fw/comm/core/ServiceInstanceID 
.const [131] = Utf8 <init> 
.const [132] = Utf8 (Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V 
.const [133] = Utf8 de/esolutions/fw/comm/core/AbstractReplyService 
.const [134] = Utf8 <init> 
.const [135] = Utf8 (Lde/esolutions/fw/comm/core/ServiceInstanceID;)V 
.const [136] = Utf8 de/esolutions/fw/comm/asi/connectivity/networking/impl/NetworkingBluetoothBridgeReplyService 
.const [137] = Utf8 dynamicHandle 
.const [138] = Utf8 I 
.const [139] = Utf8 de/esolutions/fw/comm/asi/connectivity/networking/impl/NetworkingBluetoothBridgeReplyService 
.const [140] = Utf8 context 
.const [141] = Utf8 Lde/esolutions/fw/comm/core/CallContext; 
.const [142] = Utf8 java/lang/StringBuffer 
.const [143] = Utf8 <init> 
.const [144] = Utf8 ()V 
.const [145] = Utf8 de/esolutions/fw/comm/core/method/MethodException 
.const [146] = Utf8 <init> 
.const [147] = Utf8 (Ljava/lang/String;)V 
.const [148] = Utf8 de/esolutions/fw/comm/asi/connectivity/networking/impl/NetworkingBluetoothBridgeReplyService 
.const [149] = Utf8 p_NetworkingBluetoothBridgeReply 
.const [150] = Utf8 Lde/esolutions/fw/comm/asi/connectivity/networking/NetworkingBluetoothBridgeReply; 
.const [151] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [152] = Utf8 getInt64 
.const [153] = Utf8 ()J 
.const [154] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [155] = Utf8 getEnum 
.const [156] = Utf8 ()I 
.const [157] = Utf8 de/esolutions/fw/comm/asi/connectivity/networking/NetworkingBluetoothBridgeReply 
.const [158] = Utf8 setConnectionState 
.const [159] = Utf8 (JII)V 
.const [160] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [161] = Utf8 getBool 
.const [162] = Utf8 ()Z 
.const [163] = Utf8 de/esolutions/fw/comm/asi/connectivity/networking/NetworkingBluetoothBridgeReply 
.const [164] = Utf8 setProfileConnectable 
.const [165] = Utf8 (JIZ)V 
.const [166] = Utf8 de/esolutions/fw/comm/asi/connectivity/networking/impl/NetworkingBluetoothBridgeReplyService 
.const [167] = Class [166] 
.const [168] = Utf8 de/esolutions/fw/comm/core/AbstractReplyService 
.const [169] = Class [168] 
.const [170] = Utf8 context 
.const [171] = Utf8 Lde/esolutions/fw/comm/core/CallContext; 
.const [172] = Utf8 dynamicHandle 
.const [173] = Utf8 I 
.const [174] = Utf8 p_NetworkingBluetoothBridgeReply 
.const [175] = Utf8 Lde/esolutions/fw/comm/asi/connectivity/networking/NetworkingBluetoothBridgeReply; 
.const [176] = Utf8 Code 
.const [177] = Utf8 <init> 
.const [178] = Utf8 (Lde/esolutions/fw/comm/asi/connectivity/networking/NetworkingBluetoothBridgeReply;)V 
.const [179] = Utf8 nextDynamicHandle 
.const [180] = Utf8 ()I 
.const [181] = Utf8 getCallContext 
.const [182] = Utf8 ()Lde/esolutions/fw/comm/core/CallContext; 
.const [183] = Utf8 handleCallMethod 
.const [184] = Utf8 (SLde/esolutions/fw/util/serializer/IDeserializer;Lde/esolutions/fw/comm/core/IProxyFrontend;)V 
.const [185] = Utf8 <clinit> 
.const [186] = Utf8 ()V 
.end class 
