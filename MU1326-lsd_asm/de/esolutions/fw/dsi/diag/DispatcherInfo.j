.version 50 0 
.class public super [125] 
.super [127] 
.field public final [128] [129] 
.field public final [130] [131] 
.field public final [132] [133] 
.field public final [134] [135] 
.field public final [136] [137] 
.field public [138] [139] 
.field private static final [140] [141] 

.method protected [143] : [144] 
    .attribute [142] .code stack 2 locals 1 
L0:     aload_1 
L1:     ifnonnull L6 
L4:     aconst_null 
L5:     areturn 
L6:     aload_1 
L7:     invokevirtual [12] 
L10:    astore_2 
L11:    aload_2 
L12:    ldc [2] 
L14:    invokevirtual [13] 
L17:    ifeq L29 
L20:    aload_0 
L21:    getfield [14] 
L24:    ifne L29 
L27:    aconst_null 
L28:    areturn 
L29:    aload_0 
L30:    aload_1 
L31:    invokespecial [17] 
L34:    areturn 
L35:    nop 
L36:    
    .end code 
.end method 

.method public [145] : [146] 
    .attribute [142] .code stack 2 locals 0 
L0:     aload_0 
L1:     iload_1 
L2:     invokespecial [18] 
L5:     aload_2 
L6:     ifnull L23 
L9:     aload_0 
L10:    aload_2 
L11:    invokespecial [19] 
L14:    invokevirtual [15] 
L17:    putfield [22] 
L20:    goto L29 
L23:    aload_0 
L24:    ldc [3] 
L26:    putfield [22] 
L29:    aload_0 
L30:    iload_3 
L31:    putfield [21] 
L34:    aload_0 
L35:    aload 4 
L37:    putfield [23] 
L40:    aload_2 
L41:    ifnull L71 
L44:    aload_2 
L45:    invokeinterface [24] 0 
L50:    ifnull L71 
L53:    aload_0 
L54:    aload_2 
L55:    invokeinterface [24] 0 
L60:    invokeinterface [25] 0 
L65:    putfield [26] 
L68:    goto L76 
L71:    aload_0 
L72:    aconst_null 
L73:    putfield [26] 
L76:    aload_0 
L77:    aload 5 
L79:    putfield [27] 
L82:    aload 5 
L84:    ifnull L95 
L87:    aload_0 
L88:    aload_0 
L89:    invokespecial [20] 
L92:    putfield [28] 
L95:    return 
L96:    
    .end code 
.end method 

.method public interface [147] : [148] 
    .attribute [142] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [16] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = String [29] 
.const [3] = String [30] 
.const [4] = Class [31] 
.const [5] = Class [32] 
.const [6] = Class [33] 
.const [7] = Class [34] 
.const [8] = Class [35] 
.const [9] = Class [36] 
.const [10] = Class [37] 
.const [11] = Class [38] 
.const [12] = Method [39] [40] 
.const [13] = Method [41] [42] 
.const [14] = Field [43] [44] 
.const [15] = Method [45] [46] 
.const [16] = Field [47] [48] 
.const [17] = Method [49] [50] 
.const [18] = Method [51] [52] 
.const [19] = Method [53] [54] 
.const [20] = Method [55] [56] 
.const [21] = Field [57] [58] 
.const [22] = Field [59] [60] 
.const [23] = Field [61] [62] 
.const [24] = InterfaceMethod [63] [64] 
.const [25] = InterfaceMethod [65] [66] 
.const [26] = Field [67] [68] 
.const [27] = Field [69] [70] 
.const [28] = Field [71] [72] 
.const [29] = Utf8 instance 
.const [30] = Utf8 unknown 
.const [31] = Utf8 de/esolutions/fw/dsi/diag/DispatcherInfo 
.const [32] = Utf8 de/esolutions/fw/comm/agent/diag/AbstractInfoBase 
.const [33] = Utf8 java/lang/reflect/Field 
.const [34] = Utf8 java/lang/String 
.const [35] = Utf8 java/lang/Object 
.const [36] = Utf8 java/lang/Class 
.const [37] = Utf8 de/esolutions/fw/dsi/base/IDispatcher 
.const [38] = Utf8 de/esolutions/fw/comm/core/IReplyService 
.const [39] = Class [73] 
.const [40] = NameAndType [74] [75] 
.const [41] = Class [76] 
.const [42] = NameAndType [77] [78] 
.const [43] = Class [79] 
.const [44] = NameAndType [80] [81] 
.const [45] = Class [82] 
.const [46] = NameAndType [83] [84] 
.const [47] = Class [85] 
.const [48] = NameAndType [86] [87] 
.const [49] = Class [88] 
.const [50] = NameAndType [89] [90] 
.const [51] = Class [91] 
.const [52] = NameAndType [92] [93] 
.const [53] = Class [94] 
.const [54] = NameAndType [95] [96] 
.const [55] = Class [97] 
.const [56] = NameAndType [98] [99] 
.const [57] = Class [100] 
.const [58] = NameAndType [101] [102] 
.const [59] = Class [103] 
.const [60] = NameAndType [104] [105] 
.const [61] = Class [106] 
.const [62] = NameAndType [107] [108] 
.const [63] = Class [109] 
.const [64] = NameAndType [110] [111] 
.const [65] = Class [112] 
.const [66] = NameAndType [113] [114] 
.const [67] = Class [115] 
.const [68] = NameAndType [116] [117] 
.const [69] = Class [118] 
.const [70] = NameAndType [119] [120] 
.const [71] = Class [121] 
.const [72] = NameAndType [122] [123] 
.const [73] = Utf8 java/lang/reflect/Field 
.const [74] = Utf8 getName 
.const [75] = Utf8 ()Ljava/lang/String; 
.const [76] = Utf8 java/lang/String 
.const [77] = Utf8 equals 
.const [78] = Utf8 (Ljava/lang/Object;)Z 
.const [79] = Utf8 de/esolutions/fw/dsi/diag/DispatcherInfo 
.const [80] = Utf8 instance 
.const [81] = Utf8 I 
.const [82] = Utf8 java/lang/Class 
.const [83] = Utf8 getName 
.const [84] = Utf8 ()Ljava/lang/String; 
.const [85] = Utf8 de/esolutions/fw/dsi/diag/DispatcherInfo 
.const [86] = Utf8 serviceInstanceId 
.const [87] = Utf8 Lde/esolutions/fw/comm/core/ServiceInstanceID; 
.const [88] = Utf8 de/esolutions/fw/comm/agent/diag/AbstractInfoBase 
.const [89] = Utf8 fieldValueToObject 
.const [90] = Utf8 (Ljava/lang/reflect/Field;)Ljava/lang/Object; 
.const [91] = Utf8 de/esolutions/fw/comm/agent/diag/AbstractInfoBase 
.const [92] = Utf8 <init> 
.const [93] = Utf8 (I)V 
.const [94] = Utf8 java/lang/Object 
.const [95] = Utf8 getClass 
.const [96] = Utf8 ()Ljava/lang/Class; 
.const [97] = Utf8 de/esolutions/fw/comm/agent/diag/AbstractInfoBase 
.const [98] = Utf8 getTimeStampString 
.const [99] = Utf8 ()Ljava/lang/String; 
.const [100] = Utf8 de/esolutions/fw/dsi/diag/DispatcherInfo 
.const [101] = Utf8 instance 
.const [102] = Utf8 I 
.const [103] = Utf8 de/esolutions/fw/dsi/diag/DispatcherInfo 
.const [104] = Utf8 dispatcherClassName 
.const [105] = Utf8 Ljava/lang/String; 
.const [106] = Utf8 de/esolutions/fw/dsi/diag/DispatcherInfo 
.const [107] = Utf8 listenerClassName 
.const [108] = Utf8 Ljava/lang/String; 
.const [109] = Utf8 de/esolutions/fw/dsi/base/IDispatcher 
.const [110] = Utf8 getService 
.const [111] = Utf8 ()Lde/esolutions/fw/comm/core/IReplyService; 
.const [112] = Utf8 de/esolutions/fw/comm/core/IReplyService 
.const [113] = Utf8 getInstanceID 
.const [114] = Utf8 ()Lde/esolutions/fw/comm/core/ServiceInstanceID; 
.const [115] = Utf8 de/esolutions/fw/dsi/diag/DispatcherInfo 
.const [116] = Utf8 serviceInstanceId 
.const [117] = Utf8 Lde/esolutions/fw/comm/core/ServiceInstanceID; 
.const [118] = Utf8 de/esolutions/fw/dsi/diag/DispatcherInfo 
.const [119] = Utf8 errorMessage 
.const [120] = Utf8 Ljava/lang/String; 
.const [121] = Utf8 de/esolutions/fw/dsi/diag/DispatcherInfo 
.const [122] = Utf8 errorTimeStamp 
.const [123] = Utf8 Ljava/lang/String; 
.const [124] = Utf8 de/esolutions/fw/dsi/diag/DispatcherInfo 
.const [125] = Class [124] 
.const [126] = Utf8 de/esolutions/fw/comm/agent/diag/AbstractInfoBase 
.const [127] = Class [126] 
.const [128] = Utf8 instance 
.const [129] = Utf8 I 
.const [130] = Utf8 listenerClassName 
.const [131] = Utf8 Ljava/lang/String; 
.const [132] = Utf8 dispatcherClassName 
.const [133] = Utf8 Ljava/lang/String; 
.const [134] = Utf8 errorMessage 
.const [135] = Utf8 Ljava/lang/String; 
.const [136] = Utf8 serviceInstanceId 
.const [137] = Utf8 Lde/esolutions/fw/comm/core/ServiceInstanceID; 
.const [138] = Utf8 errorTimeStamp 
.const [139] = Utf8 Ljava/lang/String; 
.const [140] = Utf8 DEFAULT_INSTANCE 
.const [141] = Utf8 I 
.const [142] = Utf8 Code 
.const [143] = Utf8 fieldValueToObject 
.const [144] = Utf8 (Ljava/lang/reflect/Field;)Ljava/lang/Object; 
.const [145] = Utf8 <init> 
.const [146] = Utf8 (ILde/esolutions/fw/dsi/base/IDispatcher;ILjava/lang/String;Ljava/lang/String;)V 
.const [147] = Utf8 getServiceInstanceID 
.const [148] = Utf8 ()Lde/esolutions/fw/comm/core/ServiceInstanceID; 
.end class 
