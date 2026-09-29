.version 50 0 
.class public super [107] 
.super [109] 
.field private static final [110] [111] 
.field private [112] [113] 

.method public [115] : [116] 
    .attribute [114] .code stack 7 locals 0 
L0:     aload_0 
L1:     new [25] 
L4:     dup 
L5:     ldc [3] 
L7:     iload_1 
L8:     ldc [4] 
L10:    ldc [5] 
L12:    invokespecial [19] 
L15:    invokespecial [20] 
L18:    aload_0 
L19:    aload_2 
L20:    putfield [26] 
L23:    return 
L24:    
    .end code 
.end method 

.method public [117] : [118] 
    .attribute [114] .code stack 2 locals 0 
L0:     new [27] 
L3:     dup 
L4:     invokespecial [21] 
L7:     areturn 
L8:     
    .end code 
.end method 

.method public [119] : [120] 
    .attribute [114] .code stack 1 locals 0 
L0:     getstatic [7] 
L3:     areturn 
L4:     
    .end code 
.end method 

.method public [121] : [122] 
    .attribute [114] .code stack 4 locals 0 
L0:     iload_1 
L1:     lookupswitch 
            default : L12 

L12:    new [28] 
L15:    dup 
L16:    new [29] 
L19:    dup 
L20:    invokespecial [23] 
L23:    ldc [10] 
L25:    invokevirtual [16] 
L28:    iload_1 
L29:    invokevirtual [17] 
L32:    invokevirtual [18] 
L35:    invokespecial [24] 
L38:    athrow 
L39:    nop 
L40:    
    .end code 
.end method 

.method static [123] : [124] 
    .attribute [114] .code stack 1 locals 0 
L0:     ldc [11] 
L2:     invokestatic [12] 
L5:     putstatic [22] 
L8:     return 
L9:     nop 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [30] 
.const [3] = String [31] 
.const [4] = String [32] 
.const [5] = String [33] 
.const [6] = Class [34] 
.const [7] = Field [35] [36] 
.const [8] = Class [37] 
.const [9] = Class [38] 
.const [10] = String [39] 
.const [11] = String [40] 
.const [12] = Method [41] [42] 
.const [13] = Class [43] 
.const [14] = Class [44] 
.const [15] = Class [45] 
.const [16] = Method [46] [47] 
.const [17] = Method [48] [49] 
.const [18] = Method [50] [51] 
.const [19] = Method [52] [53] 
.const [20] = Method [54] [55] 
.const [21] = Method [56] [57] 
.const [22] = Field [58] [59] 
.const [23] = Method [60] [61] 
.const [24] = Method [62] [63] 
.const [25] = Class [64] 
.const [26] = Field [65] [66] 
.const [27] = Class [67] 
.const [28] = Class [68] 
.const [29] = Class [69] 
.const [30] = Utf8 de/esolutions/fw/comm/core/ServiceInstanceID 
.const [31] = Utf8 c7f869df-1be1-5090-ba2d-aed8a69db8ea 
.const [32] = Utf8 d40de8e3-b01e-505f-bf5f-eaeb5f97a86f 
.const [33] = Utf8 'asi.persistence.GEM' 
.const [34] = Utf8 de/esolutions/fw/comm/asi/persistence/impl/GEMReplyProxy 
.const [35] = Class [70] 
.const [36] = NameAndType [71] [72] 
.const [37] = Utf8 de/esolutions/fw/comm/core/method/MethodException 
.const [38] = Utf8 java/lang/StringBuffer 
.const [39] = Utf8 'Invalid Method Id ' 
.const [40] = Utf8 'STUB.asi.persistence.GEM' 
.const [41] = Class [73] 
.const [42] = NameAndType [74] [75] 
.const [43] = Utf8 de/esolutions/fw/comm/asi/persistence/impl/GEMService 
.const [44] = Utf8 de/esolutions/fw/comm/core/AbstractService 
.const [45] = Utf8 de/esolutions/fw/comm/core/CallContext 
.const [46] = Class [76] 
.const [47] = NameAndType [77] [78] 
.const [48] = Class [79] 
.const [49] = NameAndType [80] [81] 
.const [50] = Class [82] 
.const [51] = NameAndType [83] [84] 
.const [52] = Class [85] 
.const [53] = NameAndType [86] [87] 
.const [54] = Class [88] 
.const [55] = NameAndType [89] [90] 
.const [56] = Class [91] 
.const [57] = NameAndType [92] [93] 
.const [58] = Class [94] 
.const [59] = NameAndType [95] [96] 
.const [60] = Class [97] 
.const [61] = NameAndType [98] [99] 
.const [62] = Class [100] 
.const [63] = NameAndType [101] [102] 
.const [64] = Utf8 de/esolutions/fw/comm/core/ServiceInstanceID 
.const [65] = Class [103] 
.const [66] = NameAndType [104] [105] 
.const [67] = Utf8 de/esolutions/fw/comm/asi/persistence/impl/GEMReplyProxy 
.const [68] = Utf8 de/esolutions/fw/comm/core/method/MethodException 
.const [69] = Utf8 java/lang/StringBuffer 
.const [70] = Utf8 de/esolutions/fw/comm/asi/persistence/impl/GEMService 
.const [71] = Utf8 context 
.const [72] = Utf8 Lde/esolutions/fw/comm/core/CallContext; 
.const [73] = Utf8 de/esolutions/fw/comm/core/CallContext 
.const [74] = Utf8 getContext 
.const [75] = Utf8 (Ljava/lang/String;)Lde/esolutions/fw/comm/core/CallContext; 
.const [76] = Utf8 java/lang/StringBuffer 
.const [77] = Utf8 append 
.const [78] = Utf8 (Ljava/lang/String;)Ljava/lang/StringBuffer; 
.const [79] = Utf8 java/lang/StringBuffer 
.const [80] = Utf8 append 
.const [81] = Utf8 (I)Ljava/lang/StringBuffer; 
.const [82] = Utf8 java/lang/StringBuffer 
.const [83] = Utf8 toString 
.const [84] = Utf8 ()Ljava/lang/String; 
.const [85] = Utf8 de/esolutions/fw/comm/core/ServiceInstanceID 
.const [86] = Utf8 <init> 
.const [87] = Utf8 (Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V 
.const [88] = Utf8 de/esolutions/fw/comm/core/AbstractService 
.const [89] = Utf8 <init> 
.const [90] = Utf8 (Lde/esolutions/fw/comm/core/ServiceInstanceID;)V 
.const [91] = Utf8 de/esolutions/fw/comm/asi/persistence/impl/GEMReplyProxy 
.const [92] = Utf8 <init> 
.const [93] = Utf8 ()V 
.const [94] = Utf8 de/esolutions/fw/comm/asi/persistence/impl/GEMService 
.const [95] = Utf8 context 
.const [96] = Utf8 Lde/esolutions/fw/comm/core/CallContext; 
.const [97] = Utf8 java/lang/StringBuffer 
.const [98] = Utf8 <init> 
.const [99] = Utf8 ()V 
.const [100] = Utf8 de/esolutions/fw/comm/core/method/MethodException 
.const [101] = Utf8 <init> 
.const [102] = Utf8 (Ljava/lang/String;)V 
.const [103] = Utf8 de/esolutions/fw/comm/asi/persistence/impl/GEMService 
.const [104] = Utf8 p_GEM 
.const [105] = Utf8 Lde/esolutions/fw/comm/asi/persistence/GEMS; 
.const [106] = Utf8 de/esolutions/fw/comm/asi/persistence/impl/GEMService 
.const [107] = Class [106] 
.const [108] = Utf8 de/esolutions/fw/comm/core/AbstractService 
.const [109] = Class [108] 
.const [110] = Utf8 context 
.const [111] = Utf8 Lde/esolutions/fw/comm/core/CallContext; 
.const [112] = Utf8 p_GEM 
.const [113] = Utf8 Lde/esolutions/fw/comm/asi/persistence/GEMS; 
.const [114] = Utf8 Code 
.const [115] = Utf8 <init> 
.const [116] = Utf8 (ILde/esolutions/fw/comm/asi/persistence/GEMS;)V 
.const [117] = Utf8 createReplyProxy 
.const [118] = Utf8 ()Lde/esolutions/fw/comm/core/IProxyFrontend; 
.const [119] = Utf8 getCallContext 
.const [120] = Utf8 ()Lde/esolutions/fw/comm/core/CallContext; 
.const [121] = Utf8 handleCallMethod 
.const [122] = Utf8 (SLde/esolutions/fw/util/serializer/IDeserializer;Lde/esolutions/fw/comm/core/IProxyFrontend;)V 
.const [123] = Utf8 <clinit> 
.const [124] = Utf8 ()V 
.end class 
