.version 50 0 
.class public super [133] 
.super [135] 
.implements [137] 
.implements [139] 
.field private static final [140] [141] 
.field private [142] [143] 

.method public [145] : [146] 
    .attribute [144] .code stack 6 locals 2 
L0:     aload_0 
L1:     invokespecial [22] 
L4:     new [30] 
L7:     dup 
L8:     ldc [3] 
L10:    iload_1 
L11:    ldc [4] 
L13:    ldc [5] 
L15:    invokespecial [23] 
L18:    astore_3 
L19:    new [31] 
L22:    dup 
L23:    aload_2 
L24:    invokespecial [24] 
L27:    astore 4 
L29:    aload_0 
L30:    new [32] 
L33:    dup 
L34:    aload_3 
L35:    aload 4 
L37:    getstatic [8] 
L40:    invokespecial [26] 
L43:    putfield [33] 
L46:    return 
L47:    nop 
L48:    
    .end code 
.end method 

.method public interface [147] : [148] 
    .attribute [144] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [18] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [149] : [150] 
    .attribute [144] .code stack 3 locals 2 
L0:     new [34] 
L3:     dup 
L4:     invokespecial [27] 
L7:     astore_2 
        .catch [10] from L8 to L13 using L16 
L8:     aload_2 
L9:     iload_1 
L10:    invokevirtual [19] 
L13:    goto L29 
L16:    astore_3 
L17:    new [35] 
L20:    dup 
L21:    aload_3 
L22:    invokevirtual [20] 
L25:    invokespecial [28] 
L28:    athrow 
L29:    aload_0 
L30:    getfield [18] 
L33:    iconst_1 
L34:    aload_2 
L35:    invokevirtual [21] 
L38:    return 
L39:    nop 
L40:    
    .end code 
.end method 

.method public [151] : [152] 
    .attribute [144] .code stack 6 locals 1 
L0:     new [36] 
L3:     dup 
L4:     aload_0 
L5:     iload_1 
L6:     aload_2 
L7:     iload_3 
L8:     invokespecial [29] 
L11:    astore 4 
L13:    aload_0 
L14:    getfield [18] 
L17:    iconst_2 
L18:    aload 4 
L20:    invokevirtual [21] 
L23:    return 
L24:    
    .end code 
.end method 

.method static [153] : [154] 
    .attribute [144] .code stack 1 locals 0 
L0:     ldc [13] 
L2:     invokestatic [14] 
L5:     putstatic [25] 
L8:     return 
L9:     nop 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [37] 
.const [3] = String [38] 
.const [4] = String [39] 
.const [5] = String [40] 
.const [6] = Class [41] 
.const [7] = Class [42] 
.const [8] = Field [43] [44] 
.const [9] = Class [45] 
.const [10] = Class [46] 
.const [11] = Class [47] 
.const [12] = Class [48] 
.const [13] = String [49] 
.const [14] = Method [50] [51] 
.const [15] = Class [52] 
.const [16] = Class [53] 
.const [17] = Class [54] 
.const [18] = Field [55] [56] 
.const [19] = Method [57] [58] 
.const [20] = Method [59] [60] 
.const [21] = Method [61] [62] 
.const [22] = Method [63] [64] 
.const [23] = Method [65] [66] 
.const [24] = Method [67] [68] 
.const [25] = Field [69] [70] 
.const [26] = Method [71] [72] 
.const [27] = Method [73] [74] 
.const [28] = Method [75] [76] 
.const [29] = Method [77] [78] 
.const [30] = Class [79] 
.const [31] = Class [80] 
.const [32] = Class [81] 
.const [33] = Field [82] [83] 
.const [34] = Class [84] 
.const [35] = Class [85] 
.const [36] = Class [86] 
.const [37] = Utf8 de/esolutions/fw/comm/core/ServiceInstanceID 
.const [38] = Utf8 '761c5633-4d14-4d62-9410-2cefd2161346' 
.const [39] = Utf8 '4530e019-1027-5e9c-a559-78a464b914fe' 
.const [40] = Utf8 'asi.navigation.uotanaviservice.UOTANaviService' 
.const [41] = Utf8 de/esolutions/fw/comm/asi/navigation/uotanaviservice/impl/UOTANaviServiceReplyService 
.const [42] = Utf8 de/esolutions/fw/comm/core/Proxy 
.const [43] = Class [87] 
.const [44] = NameAndType [88] [89] 
.const [45] = Utf8 de/esolutions/fw/util/serializer/adapter/GenericSerializable 
.const [46] = Utf8 de/esolutions/fw/util/serializer/exception/SerializerException 
.const [47] = Utf8 de/esolutions/fw/comm/core/method/MethodException 
.const [48] = Utf8 de/esolutions/fw/comm/asi/navigation/uotanaviservice/impl/UOTANaviServiceProxy$1 
.const [49] = Utf8 'PROXY.asi.navigation.uotanaviservice.UOTANaviService' 
.const [50] = Class [90] 
.const [51] = NameAndType [91] [92] 
.const [52] = Utf8 de/esolutions/fw/comm/asi/navigation/uotanaviservice/impl/UOTANaviServiceProxy 
.const [53] = Utf8 java/lang/Object 
.const [54] = Utf8 de/esolutions/fw/comm/core/CallContext 
.const [55] = Class [93] 
.const [56] = NameAndType [94] [95] 
.const [57] = Class [96] 
.const [58] = NameAndType [97] [98] 
.const [59] = Class [99] 
.const [60] = NameAndType [100] [101] 
.const [61] = Class [102] 
.const [62] = NameAndType [103] [104] 
.const [63] = Class [105] 
.const [64] = NameAndType [106] [107] 
.const [65] = Class [108] 
.const [66] = NameAndType [109] [110] 
.const [67] = Class [111] 
.const [68] = NameAndType [112] [113] 
.const [69] = Class [114] 
.const [70] = NameAndType [115] [116] 
.const [71] = Class [117] 
.const [72] = NameAndType [118] [119] 
.const [73] = Class [120] 
.const [74] = NameAndType [121] [122] 
.const [75] = Class [123] 
.const [76] = NameAndType [124] [125] 
.const [77] = Class [126] 
.const [78] = NameAndType [127] [128] 
.const [79] = Utf8 de/esolutions/fw/comm/core/ServiceInstanceID 
.const [80] = Utf8 de/esolutions/fw/comm/asi/navigation/uotanaviservice/impl/UOTANaviServiceReplyService 
.const [81] = Utf8 de/esolutions/fw/comm/core/Proxy 
.const [82] = Class [129] 
.const [83] = NameAndType [130] [131] 
.const [84] = Utf8 de/esolutions/fw/util/serializer/adapter/GenericSerializable 
.const [85] = Utf8 de/esolutions/fw/comm/core/method/MethodException 
.const [86] = Utf8 de/esolutions/fw/comm/asi/navigation/uotanaviservice/impl/UOTANaviServiceProxy$1 
.const [87] = Utf8 de/esolutions/fw/comm/asi/navigation/uotanaviservice/impl/UOTANaviServiceProxy 
.const [88] = Utf8 context 
.const [89] = Utf8 Lde/esolutions/fw/comm/core/CallContext; 
.const [90] = Utf8 de/esolutions/fw/comm/core/CallContext 
.const [91] = Utf8 getContext 
.const [92] = Utf8 (Ljava/lang/String;)Lde/esolutions/fw/comm/core/CallContext; 
.const [93] = Utf8 de/esolutions/fw/comm/asi/navigation/uotanaviservice/impl/UOTANaviServiceProxy 
.const [94] = Utf8 proxy 
.const [95] = Utf8 Lde/esolutions/fw/comm/core/Proxy; 
.const [96] = Utf8 de/esolutions/fw/util/serializer/adapter/GenericSerializable 
.const [97] = Utf8 putEnum 
.const [98] = Utf8 (I)V 
.const [99] = Utf8 de/esolutions/fw/util/serializer/exception/SerializerException 
.const [100] = Utf8 getMessage 
.const [101] = Utf8 ()Ljava/lang/String; 
.const [102] = Utf8 de/esolutions/fw/comm/core/Proxy 
.const [103] = Utf8 remoteCallMethod 
.const [104] = Utf8 (SLde/esolutions/fw/util/serializer/ISerializable;)V 
.const [105] = Utf8 java/lang/Object 
.const [106] = Utf8 <init> 
.const [107] = Utf8 ()V 
.const [108] = Utf8 de/esolutions/fw/comm/core/ServiceInstanceID 
.const [109] = Utf8 <init> 
.const [110] = Utf8 (Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V 
.const [111] = Utf8 de/esolutions/fw/comm/asi/navigation/uotanaviservice/impl/UOTANaviServiceReplyService 
.const [112] = Utf8 <init> 
.const [113] = Utf8 (Lde/esolutions/fw/comm/asi/navigation/uotanaviservice/UOTANaviServiceReply;)V 
.const [114] = Utf8 de/esolutions/fw/comm/asi/navigation/uotanaviservice/impl/UOTANaviServiceProxy 
.const [115] = Utf8 context 
.const [116] = Utf8 Lde/esolutions/fw/comm/core/CallContext; 
.const [117] = Utf8 de/esolutions/fw/comm/core/Proxy 
.const [118] = Utf8 <init> 
.const [119] = Utf8 (Lde/esolutions/fw/comm/core/ServiceInstanceID;Lde/esolutions/fw/comm/core/IReplyService;Lde/esolutions/fw/comm/core/CallContext;)V 
.const [120] = Utf8 de/esolutions/fw/util/serializer/adapter/GenericSerializable 
.const [121] = Utf8 <init> 
.const [122] = Utf8 ()V 
.const [123] = Utf8 de/esolutions/fw/comm/core/method/MethodException 
.const [124] = Utf8 <init> 
.const [125] = Utf8 (Ljava/lang/String;)V 
.const [126] = Utf8 de/esolutions/fw/comm/asi/navigation/uotanaviservice/impl/UOTANaviServiceProxy$1 
.const [127] = Utf8 <init> 
.const [128] = Utf8 (Lde/esolutions/fw/comm/asi/navigation/uotanaviservice/impl/UOTANaviServiceProxy;S[Lde/esolutions/fw/comm/asi/navigation/mapregioninfo/ComponentInfo;I)V 
.const [129] = Utf8 de/esolutions/fw/comm/asi/navigation/uotanaviservice/impl/UOTANaviServiceProxy 
.const [130] = Utf8 proxy 
.const [131] = Utf8 Lde/esolutions/fw/comm/core/Proxy; 
.const [132] = Utf8 de/esolutions/fw/comm/asi/navigation/uotanaviservice/impl/UOTANaviServiceProxy 
.const [133] = Class [132] 
.const [134] = Utf8 java/lang/Object 
.const [135] = Class [134] 
.const [136] = Utf8 de/esolutions/fw/comm/asi/navigation/uotanaviservice/UOTANaviService 
.const [137] = Class [136] 
.const [138] = Utf8 de/esolutions/fw/comm/asi/navigation/uotanaviservice/UOTANaviServiceC 
.const [139] = Class [138] 
.const [140] = Utf8 context 
.const [141] = Utf8 Lde/esolutions/fw/comm/core/CallContext; 
.const [142] = Utf8 proxy 
.const [143] = Utf8 Lde/esolutions/fw/comm/core/Proxy; 
.const [144] = Utf8 Code 
.const [145] = Utf8 <init> 
.const [146] = Utf8 (ILde/esolutions/fw/comm/asi/navigation/uotanaviservice/UOTANaviServiceReply;)V 
.const [147] = Utf8 getProxy 
.const [148] = Utf8 ()Lde/esolutions/fw/comm/core/Proxy; 
.const [149] = Utf8 registerClient 
.const [150] = Utf8 (I)V 
.const [151] = Utf8 respondVersionInfo 
.const [152] = Utf8 (S[Lde/esolutions/fw/comm/asi/navigation/mapregioninfo/ComponentInfo;I)V 
.const [153] = Utf8 <clinit> 
.const [154] = Utf8 ()V 
.end class 
