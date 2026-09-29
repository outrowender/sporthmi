.version 50 0 
.class public super [101] 
.super [103] 
.field protected [104] [105] 
.field protected [106] [107] 
.field protected [108] [109] 

.method public [111] : [112] 
    .attribute [110] .code stack 2 locals 0 
L0:     aload_0 
L1:     ldc [2] 
L3:     invokespecial [17] 
L6:     aload_0 
L7:     aload_1 
L8:     putfield [19] 
L11:    aload_0 
L12:    aload_2 
L13:    putfield [20] 
L16:    aload_0 
L17:    iload_3 
L18:    putfield [21] 
L21:    return 
L22:    nop 
L23:    nop 
L24:    
    .end code 
.end method 

.method public [113] : [114] 
    .attribute [110] .code stack 4 locals 0 
L0:     aload_1 
L1:     aload_0 
L2:     getfield [11] 
L5:     aload_0 
L6:     getfield [12] 
L9:     aload_0 
L10:    getfield [13] 
L13:    invokeinterface [22] 0 
L18:    areturn 
L19:    nop 
L20:    
    .end code 
.end method 

.method public [115] : [116] 
    .attribute [110] .code stack 1 locals 0 
L0:     aconst_null 
L1:     areturn 
L2:     nop 
L3:     nop 
L4:     
    .end code 
.end method 

.method public [117] : [118] 
    .attribute [110] .code stack 2 locals 0 
L0:     new [23] 
L3:     dup 
L4:     invokespecial [18] 
L7:     ldc [4] 
L9:     invokevirtual [14] 
L12:    aload_0 
L13:    getfield [11] 
L16:    invokeinterface [24] 0 
L21:    invokevirtual [15] 
L24:    aload_0 
L25:    getfield [13] 
L28:    ifeq L36 
L31:    ldc [5] 
L33:    goto L38 
L36:    ldc [6] 
L38:    invokevirtual [14] 
L41:    invokevirtual [16] 
L44:    areturn 
L45:    nop 
L46:    nop 
L47:    nop 
L48:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = String [25] 
.const [3] = Class [26] 
.const [4] = String [27] 
.const [5] = String [28] 
.const [6] = String [29] 
.const [7] = Class [30] 
.const [8] = Class [31] 
.const [9] = Class [32] 
.const [10] = Class [33] 
.const [11] = Field [34] [35] 
.const [12] = Field [36] [37] 
.const [13] = Field [38] [39] 
.const [14] = Method [40] [41] 
.const [15] = Method [42] [43] 
.const [16] = Method [44] [45] 
.const [17] = Method [46] [47] 
.const [18] = Method [48] [49] 
.const [19] = Field [50] [51] 
.const [20] = Field [52] [53] 
.const [21] = Field [54] [55] 
.const [22] = InterfaceMethod [56] [57] 
.const [23] = Class [58] 
.const [24] = InterfaceMethod [59] [60] 
.const [25] = Utf8 RegisterService 
.const [26] = Utf8 java/lang/StringBuffer 
.const [27] = Utf8 'instance=' 
.const [28] = Utf8 ' register' 
.const [29] = Utf8 ' unregister' 
.const [30] = Utf8 de/esolutions/fw/comm/agent/command/RegisterServiceCommand 
.const [31] = Utf8 de/esolutions/fw/comm/agent/command/Command 
.const [32] = Utf8 de/esolutions/fw/comm/agent/command/ICommandExecutor 
.const [33] = Utf8 de/esolutions/fw/comm/core/IService 
.const [34] = Class [61] 
.const [35] = NameAndType [62] [63] 
.const [36] = Class [64] 
.const [37] = NameAndType [65] [66] 
.const [38] = Class [67] 
.const [39] = NameAndType [68] [69] 
.const [40] = Class [70] 
.const [41] = NameAndType [71] [72] 
.const [42] = Class [73] 
.const [43] = NameAndType [74] [75] 
.const [44] = Class [76] 
.const [45] = NameAndType [77] [78] 
.const [46] = Class [79] 
.const [47] = NameAndType [80] [81] 
.const [48] = Class [82] 
.const [49] = NameAndType [83] [84] 
.const [50] = Class [85] 
.const [51] = NameAndType [86] [87] 
.const [52] = Class [88] 
.const [53] = NameAndType [89] [90] 
.const [54] = Class [91] 
.const [55] = NameAndType [92] [93] 
.const [56] = Class [94] 
.const [57] = NameAndType [95] [96] 
.const [58] = Utf8 java/lang/StringBuffer 
.const [59] = Class [97] 
.const [60] = NameAndType [98] [99] 
.const [61] = Utf8 de/esolutions/fw/comm/agent/command/RegisterServiceCommand 
.const [62] = Utf8 service 
.const [63] = Utf8 Lde/esolutions/fw/comm/core/IService; 
.const [64] = Utf8 de/esolutions/fw/comm/agent/command/RegisterServiceCommand 
.const [65] = Utf8 worker 
.const [66] = Utf8 Lde/esolutions/fw/comm/core/IServiceWorker; 
.const [67] = Utf8 de/esolutions/fw/comm/agent/command/RegisterServiceCommand 
.const [68] = Utf8 doRegister 
.const [69] = Utf8 Z 
.const [70] = Utf8 java/lang/StringBuffer 
.const [71] = Utf8 append 
.const [72] = Utf8 (Ljava/lang/String;)Ljava/lang/StringBuffer; 
.const [73] = Utf8 java/lang/StringBuffer 
.const [74] = Utf8 append 
.const [75] = Utf8 (Ljava/lang/Object;)Ljava/lang/StringBuffer; 
.const [76] = Utf8 java/lang/StringBuffer 
.const [77] = Utf8 toString 
.const [78] = Utf8 ()Ljava/lang/String; 
.const [79] = Utf8 de/esolutions/fw/comm/agent/command/Command 
.const [80] = Utf8 <init> 
.const [81] = Utf8 (Ljava/lang/String;)V 
.const [82] = Utf8 java/lang/StringBuffer 
.const [83] = Utf8 <init> 
.const [84] = Utf8 ()V 
.const [85] = Utf8 de/esolutions/fw/comm/agent/command/RegisterServiceCommand 
.const [86] = Utf8 service 
.const [87] = Utf8 Lde/esolutions/fw/comm/core/IService; 
.const [88] = Utf8 de/esolutions/fw/comm/agent/command/RegisterServiceCommand 
.const [89] = Utf8 worker 
.const [90] = Utf8 Lde/esolutions/fw/comm/core/IServiceWorker; 
.const [91] = Utf8 de/esolutions/fw/comm/agent/command/RegisterServiceCommand 
.const [92] = Utf8 doRegister 
.const [93] = Utf8 Z 
.const [94] = Utf8 de/esolutions/fw/comm/agent/command/ICommandExecutor 
.const [95] = Utf8 doRegisterService 
.const [96] = Utf8 (Lde/esolutions/fw/comm/core/IService;Lde/esolutions/fw/comm/core/IServiceWorker;Z)Z 
.const [97] = Utf8 de/esolutions/fw/comm/core/IService 
.const [98] = Utf8 getInstanceID 
.const [99] = Utf8 ()Lde/esolutions/fw/comm/core/ServiceInstanceID; 
.const [100] = Utf8 de/esolutions/fw/comm/agent/command/RegisterServiceCommand 
.const [101] = Class [100] 
.const [102] = Utf8 de/esolutions/fw/comm/agent/command/Command 
.const [103] = Class [102] 
.const [104] = Utf8 service 
.const [105] = Utf8 Lde/esolutions/fw/comm/core/IService; 
.const [106] = Utf8 worker 
.const [107] = Utf8 Lde/esolutions/fw/comm/core/IServiceWorker; 
.const [108] = Utf8 doRegister 
.const [109] = Utf8 Z 
.const [110] = Utf8 Code 
.const [111] = Utf8 <init> 
.const [112] = Utf8 (Lde/esolutions/fw/comm/core/IService;Lde/esolutions/fw/comm/core/IServiceWorker;Z)V 
.const [113] = Utf8 handle 
.const [114] = Utf8 (Lde/esolutions/fw/comm/agent/command/ICommandExecutor;)Z 
.const [115] = Utf8 getDependentInstanceID 
.const [116] = Utf8 ()Lde/esolutions/fw/comm/core/ServiceInstanceID; 
.const [117] = Utf8 getArgsString 
.const [118] = Utf8 ()Ljava/lang/String; 
.end class 
