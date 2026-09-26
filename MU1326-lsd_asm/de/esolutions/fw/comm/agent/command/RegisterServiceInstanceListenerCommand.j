.version 50 0 
.class public super [93] 
.super [95] 
.field protected [96] [97] 
.field protected [98] [99] 
.field protected [100] [101] 

.method public [103] : [104] 
    .attribute [102] .code stack 2 locals 0 
L0:     aload_0 
L1:     ldc [2] 
L3:     invokespecial [16] 
L6:     aload_0 
L7:     aload_1 
L8:     putfield [18] 
L11:    aload_0 
L12:    aload_2 
L13:    putfield [19] 
L16:    aload_0 
L17:    iload_3 
L18:    putfield [20] 
L21:    return 
L22:    nop 
L23:    nop 
L24:    
    .end code 
.end method 

.method public [105] : [106] 
    .attribute [102] .code stack 4 locals 0 
L0:     aload_1 
L1:     aload_0 
L2:     getfield [10] 
L5:     aload_0 
L6:     getfield [11] 
L9:     aload_0 
L10:    getfield [12] 
L13:    invokeinterface [21] 0 
L18:    areturn 
L19:    nop 
L20:    
    .end code 
.end method 

.method public [107] : [108] 
    .attribute [102] .code stack 1 locals 0 
L0:     aconst_null 
L1:     areturn 
L2:     nop 
L3:     nop 
L4:     
    .end code 
.end method 

.method public [109] : [110] 
    .attribute [102] .code stack 2 locals 0 
L0:     new [22] 
L3:     dup 
L4:     invokespecial [17] 
L7:     ldc [4] 
L9:     invokevirtual [13] 
L12:    aload_0 
L13:    getfield [10] 
L16:    invokevirtual [14] 
L19:    aload_0 
L20:    getfield [12] 
L23:    ifeq L31 
L26:    ldc [5] 
L28:    goto L33 
L31:    ldc [6] 
L33:    invokevirtual [13] 
L36:    invokevirtual [15] 
L39:    areturn 
L40:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = String [23] 
.const [3] = Class [24] 
.const [4] = String [25] 
.const [5] = String [26] 
.const [6] = String [27] 
.const [7] = Class [28] 
.const [8] = Class [29] 
.const [9] = Class [30] 
.const [10] = Field [31] [32] 
.const [11] = Field [33] [34] 
.const [12] = Field [35] [36] 
.const [13] = Method [37] [38] 
.const [14] = Method [39] [40] 
.const [15] = Method [41] [42] 
.const [16] = Method [43] [44] 
.const [17] = Method [45] [46] 
.const [18] = Field [47] [48] 
.const [19] = Field [49] [50] 
.const [20] = Field [51] [52] 
.const [21] = InterfaceMethod [53] [54] 
.const [22] = Class [55] 
.const [23] = Utf8 RegisterServiceInstanceListener 
.const [24] = Utf8 java/lang/StringBuffer 
.const [25] = Utf8 'instance=' 
.const [26] = Utf8 ' register' 
.const [27] = Utf8 ' unregister' 
.const [28] = Utf8 de/esolutions/fw/comm/agent/command/RegisterServiceInstanceListenerCommand 
.const [29] = Utf8 de/esolutions/fw/comm/agent/command/Command 
.const [30] = Utf8 de/esolutions/fw/comm/agent/command/ICommandExecutor 
.const [31] = Class [56] 
.const [32] = NameAndType [57] [58] 
.const [33] = Class [59] 
.const [34] = NameAndType [60] [61] 
.const [35] = Class [62] 
.const [36] = NameAndType [63] [64] 
.const [37] = Class [65] 
.const [38] = NameAndType [66] [67] 
.const [39] = Class [68] 
.const [40] = NameAndType [69] [70] 
.const [41] = Class [71] 
.const [42] = NameAndType [72] [73] 
.const [43] = Class [74] 
.const [44] = NameAndType [75] [76] 
.const [45] = Class [77] 
.const [46] = NameAndType [78] [79] 
.const [47] = Class [80] 
.const [48] = NameAndType [81] [82] 
.const [49] = Class [83] 
.const [50] = NameAndType [84] [85] 
.const [51] = Class [86] 
.const [52] = NameAndType [87] [88] 
.const [53] = Class [89] 
.const [54] = NameAndType [90] [91] 
.const [55] = Utf8 java/lang/StringBuffer 
.const [56] = Utf8 de/esolutions/fw/comm/agent/command/RegisterServiceInstanceListenerCommand 
.const [57] = Utf8 instanceID 
.const [58] = Utf8 Lde/esolutions/fw/comm/core/ServiceInstanceID; 
.const [59] = Utf8 de/esolutions/fw/comm/agent/command/RegisterServiceInstanceListenerCommand 
.const [60] = Utf8 listener 
.const [61] = Utf8 Lde/esolutions/fw/comm/core/IServiceInstanceListener; 
.const [62] = Utf8 de/esolutions/fw/comm/agent/command/RegisterServiceInstanceListenerCommand 
.const [63] = Utf8 doRegister 
.const [64] = Utf8 Z 
.const [65] = Utf8 java/lang/StringBuffer 
.const [66] = Utf8 append 
.const [67] = Utf8 (Ljava/lang/String;)Ljava/lang/StringBuffer; 
.const [68] = Utf8 java/lang/StringBuffer 
.const [69] = Utf8 append 
.const [70] = Utf8 (Ljava/lang/Object;)Ljava/lang/StringBuffer; 
.const [71] = Utf8 java/lang/StringBuffer 
.const [72] = Utf8 toString 
.const [73] = Utf8 ()Ljava/lang/String; 
.const [74] = Utf8 de/esolutions/fw/comm/agent/command/Command 
.const [75] = Utf8 <init> 
.const [76] = Utf8 (Ljava/lang/String;)V 
.const [77] = Utf8 java/lang/StringBuffer 
.const [78] = Utf8 <init> 
.const [79] = Utf8 ()V 
.const [80] = Utf8 de/esolutions/fw/comm/agent/command/RegisterServiceInstanceListenerCommand 
.const [81] = Utf8 instanceID 
.const [82] = Utf8 Lde/esolutions/fw/comm/core/ServiceInstanceID; 
.const [83] = Utf8 de/esolutions/fw/comm/agent/command/RegisterServiceInstanceListenerCommand 
.const [84] = Utf8 listener 
.const [85] = Utf8 Lde/esolutions/fw/comm/core/IServiceInstanceListener; 
.const [86] = Utf8 de/esolutions/fw/comm/agent/command/RegisterServiceInstanceListenerCommand 
.const [87] = Utf8 doRegister 
.const [88] = Utf8 Z 
.const [89] = Utf8 de/esolutions/fw/comm/agent/command/ICommandExecutor 
.const [90] = Utf8 doRegisterServiceInstanceListener 
.const [91] = Utf8 (Lde/esolutions/fw/comm/core/ServiceInstanceID;Lde/esolutions/fw/comm/core/IServiceInstanceListener;Z)Z 
.const [92] = Utf8 de/esolutions/fw/comm/agent/command/RegisterServiceInstanceListenerCommand 
.const [93] = Class [92] 
.const [94] = Utf8 de/esolutions/fw/comm/agent/command/Command 
.const [95] = Class [94] 
.const [96] = Utf8 instanceID 
.const [97] = Utf8 Lde/esolutions/fw/comm/core/ServiceInstanceID; 
.const [98] = Utf8 listener 
.const [99] = Utf8 Lde/esolutions/fw/comm/core/IServiceInstanceListener; 
.const [100] = Utf8 doRegister 
.const [101] = Utf8 Z 
.const [102] = Utf8 Code 
.const [103] = Utf8 <init> 
.const [104] = Utf8 (Lde/esolutions/fw/comm/core/ServiceInstanceID;Lde/esolutions/fw/comm/core/IServiceInstanceListener;Z)V 
.const [105] = Utf8 handle 
.const [106] = Utf8 (Lde/esolutions/fw/comm/agent/command/ICommandExecutor;)Z 
.const [107] = Utf8 getDependentInstanceID 
.const [108] = Utf8 ()Lde/esolutions/fw/comm/core/ServiceInstanceID; 
.const [109] = Utf8 getArgsString 
.const [110] = Utf8 ()Ljava/lang/String; 
.end class 
