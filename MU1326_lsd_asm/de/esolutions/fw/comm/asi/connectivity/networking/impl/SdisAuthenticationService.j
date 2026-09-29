.version 50 0 
.class public super [131] 
.super [133] 
.field private static final [134] [135] 
.field private [136] [137] 

.method public [139] : [140] 
    .attribute [138] .code stack 7 locals 0 
L0:     aload_0 
L1:     new [30] 
L4:     dup 
L5:     ldc [3] 
L7:     iload_1 
L8:     ldc [4] 
L10:    ldc [5] 
L12:    invokespecial [25] 
L15:    invokespecial [26] 
L18:    aload_0 
L19:    aload_2 
L20:    putfield [31] 
L23:    return 
L24:    
    .end code 
.end method 

.method public [141] : [142] 
    .attribute [138] .code stack 1 locals 0 
L0:     getstatic [6] 
L3:     areturn 
L4:     
    .end code 
.end method 

.method public [143] : [144] 
    .attribute [138] .code stack 4 locals 1 
        .catch [10] from L0 to L69 using L72 
L0:     iload_1 
L1:     lookupswitch 
            0 : L20 
            default : L42 

L20:    aload_2 
L21:    invokeinterface [32] 0 
L26:    astore 4 
L28:    aload_0 
L29:    getfield [20] 
L32:    aload 4 
L34:    invokeinterface [33] 0 
L39:    goto L69 
L42:    new [34] 
L45:    dup 
L46:    new [35] 
L49:    dup 
L50:    invokespecial [28] 
L53:    ldc [9] 
L55:    invokevirtual [21] 
L58:    iload_1 
L59:    invokevirtual [22] 
L62:    invokevirtual [23] 
L65:    invokespecial [29] 
L68:    athrow 
L69:    goto L114 
L72:    astore 4 
L74:    new [34] 
L77:    dup 
L78:    new [35] 
L81:    dup 
L82:    invokespecial [28] 
L85:    ldc [11] 
L87:    invokevirtual [21] 
L90:    iload_1 
L91:    invokevirtual [22] 
L94:    ldc [12] 
L96:    invokevirtual [21] 
L99:    aload 4 
L101:   invokevirtual [24] 
L104:   invokevirtual [21] 
L107:   invokevirtual [23] 
L110:   invokespecial [29] 
L113:   athrow 
L114:   return 
L115:   nop 
L116:   
    .end code 
.end method 

.method static [145] : [146] 
    .attribute [138] .code stack 1 locals 0 
L0:     ldc [13] 
L2:     invokestatic [14] 
L5:     putstatic [27] 
L8:     return 
L9:     nop 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [36] 
.const [3] = String [37] 
.const [4] = String [38] 
.const [5] = String [39] 
.const [6] = Field [40] [41] 
.const [7] = Class [42] 
.const [8] = Class [43] 
.const [9] = String [44] 
.const [10] = Class [45] 
.const [11] = String [46] 
.const [12] = String [47] 
.const [13] = String [48] 
.const [14] = Method [49] [50] 
.const [15] = Class [51] 
.const [16] = Class [52] 
.const [17] = Class [53] 
.const [18] = Class [54] 
.const [19] = Class [55] 
.const [20] = Field [56] [57] 
.const [21] = Method [58] [59] 
.const [22] = Method [60] [61] 
.const [23] = Method [62] [63] 
.const [24] = Method [64] [65] 
.const [25] = Method [66] [67] 
.const [26] = Method [68] [69] 
.const [27] = Field [70] [71] 
.const [28] = Method [72] [73] 
.const [29] = Method [74] [75] 
.const [30] = Class [76] 
.const [31] = Field [77] [78] 
.const [32] = InterfaceMethod [79] [80] 
.const [33] = InterfaceMethod [81] [82] 
.const [34] = Class [83] 
.const [35] = Class [84] 
.const [36] = Utf8 de/esolutions/fw/comm/core/ServiceInstanceID 
.const [37] = Utf8 '4403e802-2d1f-11e4-8e5e-9b52416440fb' 
.const [38] = Utf8 a7fca16c-045c-5224-a8af-1013489e690d 
.const [39] = Utf8 'asi.connectivity.networking.SdisAuthentication' 
.const [40] = Class [85] 
.const [41] = NameAndType [86] [87] 
.const [42] = Utf8 de/esolutions/fw/comm/core/method/MethodException 
.const [43] = Utf8 java/lang/StringBuffer 
.const [44] = Utf8 'Invalid Method Id ' 
.const [45] = Utf8 de/esolutions/fw/util/serializer/exception/SerializerException 
.const [46] = Utf8 'Deserialization failed: method=' 
.const [47] = Utf8 ', error=' 
.const [48] = Utf8 'STUB.asi.connectivity.networking.SdisAuthentication' 
.const [49] = Class [88] 
.const [50] = NameAndType [89] [90] 
.const [51] = Utf8 de/esolutions/fw/comm/asi/connectivity/networking/impl/SdisAuthenticationService 
.const [52] = Utf8 de/esolutions/fw/comm/core/AbstractService 
.const [53] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [54] = Utf8 de/esolutions/fw/comm/asi/connectivity/networking/SdisAuthentication 
.const [55] = Utf8 de/esolutions/fw/comm/core/CallContext 
.const [56] = Class [91] 
.const [57] = NameAndType [92] [93] 
.const [58] = Class [94] 
.const [59] = NameAndType [95] [96] 
.const [60] = Class [97] 
.const [61] = NameAndType [98] [99] 
.const [62] = Class [100] 
.const [63] = NameAndType [101] [102] 
.const [64] = Class [103] 
.const [65] = NameAndType [104] [105] 
.const [66] = Class [106] 
.const [67] = NameAndType [107] [108] 
.const [68] = Class [109] 
.const [69] = NameAndType [110] [111] 
.const [70] = Class [112] 
.const [71] = NameAndType [113] [114] 
.const [72] = Class [115] 
.const [73] = NameAndType [116] [117] 
.const [74] = Class [118] 
.const [75] = NameAndType [119] [120] 
.const [76] = Utf8 de/esolutions/fw/comm/core/ServiceInstanceID 
.const [77] = Class [121] 
.const [78] = NameAndType [122] [123] 
.const [79] = Class [124] 
.const [80] = NameAndType [125] [126] 
.const [81] = Class [127] 
.const [82] = NameAndType [128] [129] 
.const [83] = Utf8 de/esolutions/fw/comm/core/method/MethodException 
.const [84] = Utf8 java/lang/StringBuffer 
.const [85] = Utf8 de/esolutions/fw/comm/asi/connectivity/networking/impl/SdisAuthenticationService 
.const [86] = Utf8 context 
.const [87] = Utf8 Lde/esolutions/fw/comm/core/CallContext; 
.const [88] = Utf8 de/esolutions/fw/comm/core/CallContext 
.const [89] = Utf8 getContext 
.const [90] = Utf8 (Ljava/lang/String;)Lde/esolutions/fw/comm/core/CallContext; 
.const [91] = Utf8 de/esolutions/fw/comm/asi/connectivity/networking/impl/SdisAuthenticationService 
.const [92] = Utf8 p_SdisAuthentication 
.const [93] = Utf8 Lde/esolutions/fw/comm/asi/connectivity/networking/SdisAuthentication; 
.const [94] = Utf8 java/lang/StringBuffer 
.const [95] = Utf8 append 
.const [96] = Utf8 (Ljava/lang/String;)Ljava/lang/StringBuffer; 
.const [97] = Utf8 java/lang/StringBuffer 
.const [98] = Utf8 append 
.const [99] = Utf8 (I)Ljava/lang/StringBuffer; 
.const [100] = Utf8 java/lang/StringBuffer 
.const [101] = Utf8 toString 
.const [102] = Utf8 ()Ljava/lang/String; 
.const [103] = Utf8 de/esolutions/fw/util/serializer/exception/SerializerException 
.const [104] = Utf8 getMessage 
.const [105] = Utf8 ()Ljava/lang/String; 
.const [106] = Utf8 de/esolutions/fw/comm/core/ServiceInstanceID 
.const [107] = Utf8 <init> 
.const [108] = Utf8 (Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V 
.const [109] = Utf8 de/esolutions/fw/comm/core/AbstractService 
.const [110] = Utf8 <init> 
.const [111] = Utf8 (Lde/esolutions/fw/comm/core/ServiceInstanceID;)V 
.const [112] = Utf8 de/esolutions/fw/comm/asi/connectivity/networking/impl/SdisAuthenticationService 
.const [113] = Utf8 context 
.const [114] = Utf8 Lde/esolutions/fw/comm/core/CallContext; 
.const [115] = Utf8 java/lang/StringBuffer 
.const [116] = Utf8 <init> 
.const [117] = Utf8 ()V 
.const [118] = Utf8 de/esolutions/fw/comm/core/method/MethodException 
.const [119] = Utf8 <init> 
.const [120] = Utf8 (Ljava/lang/String;)V 
.const [121] = Utf8 de/esolutions/fw/comm/asi/connectivity/networking/impl/SdisAuthenticationService 
.const [122] = Utf8 p_SdisAuthentication 
.const [123] = Utf8 Lde/esolutions/fw/comm/asi/connectivity/networking/SdisAuthentication; 
.const [124] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [125] = Utf8 getOptionalString 
.const [126] = Utf8 ()Ljava/lang/String; 
.const [127] = Utf8 de/esolutions/fw/comm/asi/connectivity/networking/SdisAuthentication 
.const [128] = Utf8 sdisAuthenticationSuccessful 
.const [129] = Utf8 (Ljava/lang/String;)V 
.const [130] = Utf8 de/esolutions/fw/comm/asi/connectivity/networking/impl/SdisAuthenticationService 
.const [131] = Class [130] 
.const [132] = Utf8 de/esolutions/fw/comm/core/AbstractService 
.const [133] = Class [132] 
.const [134] = Utf8 context 
.const [135] = Utf8 Lde/esolutions/fw/comm/core/CallContext; 
.const [136] = Utf8 p_SdisAuthentication 
.const [137] = Utf8 Lde/esolutions/fw/comm/asi/connectivity/networking/SdisAuthentication; 
.const [138] = Utf8 Code 
.const [139] = Utf8 <init> 
.const [140] = Utf8 (ILde/esolutions/fw/comm/asi/connectivity/networking/SdisAuthentication;)V 
.const [141] = Utf8 getCallContext 
.const [142] = Utf8 ()Lde/esolutions/fw/comm/core/CallContext; 
.const [143] = Utf8 handleCallMethod 
.const [144] = Utf8 (SLde/esolutions/fw/util/serializer/IDeserializer;Lde/esolutions/fw/comm/core/IProxyFrontend;)V 
.const [145] = Utf8 <clinit> 
.const [146] = Utf8 ()V 
.end class 
