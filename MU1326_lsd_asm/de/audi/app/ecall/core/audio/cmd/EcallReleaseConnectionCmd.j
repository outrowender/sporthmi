.version 50 0 
.class super [98] 
.super [100] 
.field private final [101] [102] 

.method [104] : [105] 
    .attribute [103] .code stack 3 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     aload_3 
L3:     invokespecial [17] 
L6:     aload_0 
L7:     iload_2 
L8:     putfield [20] 
L11:    return 
L12:    
    .end code 
.end method 

.method public [106] : [107] 
    .attribute [103] .code stack 5 locals 1 
L0:     aload_0 
L1:     getfield [12] 
L4:     ldc [2] 
L6:     ldc [3] 
L8:     aload_0 
L9:     getfield [11] 
L12:    i2l 
L13:    invokevirtual [13] 
L16:    pop 
L17:    aload_0 
L18:    aload_0 
L19:    getfield [11] 
L22:    invokespecial [18] 
L25:    istore_1 
L26:    aload_0 
L27:    getfield [14] 
L30:    aload_0 
L31:    getfield [11] 
L34:    invokeinterface [21] 0 
L39:    iload_1 
L40:    ifeq L55 
L43:    aload_0 
L44:    invokevirtual [15] 
L47:    invokeinterface [22] 0 
L52:    goto L67 
L55:    aload_0 
L56:    getfield [12] 
L59:    ldc [2] 
L61:    ldc [4] 
L63:    invokevirtual [16] 
L66:    pop 
L67:    return 
L68:    
    .end code 
.end method 

.method public [108] : [109] 
    .attribute [103] .code stack 5 locals 0 
L0:     iload_1 
L1:     aload_0 
L2:     getfield [11] 
L5:     if_icmpne L31 
L8:     aload_0 
L9:     getfield [12] 
L12:    ldc [2] 
L14:    ldc [5] 
L16:    iload_1 
L17:    i2l 
L18:    invokevirtual [13] 
L21:    pop 
L22:    aload_0 
L23:    invokevirtual [15] 
L26:    invokeinterface [22] 0 
L31:    return 
L32:    
    .end code 
.end method 

.method private [110] : [111] 
    .attribute [103] .code stack 2 locals 0 
L0:     aload_0 
L1:     iload_1 
L2:     invokespecial [19] 
L5:     iconst_5 
L6:     if_icmpne L13 
L9:     iconst_1 
L10:    goto L14 
L13:    iconst_0 
L14:    areturn 
L15:    nop 
L16:    
    .end code 
.end method 

.method private [112] : [113] 
    .attribute [103] .code stack 2 locals 0 
L0:     aload_0 
L1:     getfield [14] 
L4:     ifnull L18 
L7:     aload_0 
L8:     getfield [14] 
L11:    iload_1 
L12:    invokeinterface [23] 0 
L17:    areturn 
L18:    iconst_m1 
L19:    areturn 
L20:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Int 1078071040 
.const [3] = String [24] 
.const [4] = String [25] 
.const [5] = String [26] 
.const [6] = Class [27] 
.const [7] = Class [28] 
.const [8] = Class [29] 
.const [9] = Class [30] 
.const [10] = Class [31] 
.const [11] = Field [32] [33] 
.const [12] = Field [34] [35] 
.const [13] = Method [36] [37] 
.const [14] = Field [38] [39] 
.const [15] = Method [40] [41] 
.const [16] = Method [42] [43] 
.const [17] = Method [44] [45] 
.const [18] = Method [46] [47] 
.const [19] = Method [48] [49] 
.const [20] = Field [50] [51] 
.const [21] = InterfaceMethod [52] [53] 
.const [22] = InterfaceMethod [54] [55] 
.const [23] = InterfaceMethod [56] [57] 
.const [24] = Utf8 'EcallReleaseConnectionCmd#execute(): release connection: %1 ' 
.const [25] = Utf8 'EcallReleaseConnectionCmd#execute(): waiting for stopConnection' 
.const [26] = Utf8 '[EcallReleaseConnectionCmd#stopConnection] AC:%1' 
.const [27] = Utf8 de/audi/app/ecall/core/audio/cmd/EcallReleaseConnectionCmd 
.const [28] = Utf8 de/audi/app/ecall/core/audio/cmd/AbstractEcallAudioCmd 
.const [29] = Utf8 de/audi/atip/log/LogChannel 
.const [30] = Utf8 de/audi/atip/audio/HMIAudioService 
.const [31] = Utf8 de/audi/tghu/command/ICommandList 
.const [32] = Class [58] 
.const [33] = NameAndType [59] [60] 
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
.const [58] = Utf8 de/audi/app/ecall/core/audio/cmd/EcallReleaseConnectionCmd 
.const [59] = Utf8 connection 
.const [60] = Utf8 I 
.const [61] = Utf8 de/audi/app/ecall/core/audio/cmd/EcallReleaseConnectionCmd 
.const [62] = Utf8 logger 
.const [63] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [64] = Utf8 de/audi/atip/log/LogChannel 
.const [65] = Utf8 log 
.const [66] = Utf8 (ILjava/lang/String;J)Z 
.const [67] = Utf8 de/audi/app/ecall/core/audio/cmd/EcallReleaseConnectionCmd 
.const [68] = Utf8 audioService 
.const [69] = Utf8 Lde/audi/atip/audio/HMIAudioService; 
.const [70] = Utf8 de/audi/app/ecall/core/audio/cmd/EcallReleaseConnectionCmd 
.const [71] = Utf8 getCommandList 
.const [72] = Utf8 ()Lde/audi/tghu/command/ICommandList; 
.const [73] = Utf8 de/audi/atip/log/LogChannel 
.const [74] = Utf8 log 
.const [75] = Utf8 (ILjava/lang/String;)Z 
.const [76] = Utf8 de/audi/app/ecall/core/audio/cmd/AbstractEcallAudioCmd 
.const [77] = Utf8 <init> 
.const [78] = Utf8 (Lde/audi/atip/log/LogChannel;Lde/audi/atip/audio/HMIAudioService;)V 
.const [79] = Utf8 de/audi/app/ecall/core/audio/cmd/EcallReleaseConnectionCmd 
.const [80] = Utf8 isStopped 
.const [81] = Utf8 (I)Z 
.const [82] = Utf8 de/audi/app/ecall/core/audio/cmd/EcallReleaseConnectionCmd 
.const [83] = Utf8 getConnectionStatus 
.const [84] = Utf8 (I)I 
.const [85] = Utf8 de/audi/app/ecall/core/audio/cmd/EcallReleaseConnectionCmd 
.const [86] = Utf8 connection 
.const [87] = Utf8 I 
.const [88] = Utf8 de/audi/atip/audio/HMIAudioService 
.const [89] = Utf8 releaseConnection 
.const [90] = Utf8 (I)V 
.const [91] = Utf8 de/audi/tghu/command/ICommandList 
.const [92] = Utf8 commandFinished 
.const [93] = Utf8 ()V 
.const [94] = Utf8 de/audi/atip/audio/HMIAudioService 
.const [95] = Utf8 getStatus 
.const [96] = Utf8 (I)I 
.const [97] = Utf8 de/audi/app/ecall/core/audio/cmd/EcallReleaseConnectionCmd 
.const [98] = Class [97] 
.const [99] = Utf8 de/audi/app/ecall/core/audio/cmd/AbstractEcallAudioCmd 
.const [100] = Class [99] 
.const [101] = Utf8 connection 
.const [102] = Utf8 I 
.const [103] = Utf8 Code 
.const [104] = Utf8 <init> 
.const [105] = Utf8 (Lde/audi/atip/log/LogChannel;ILde/audi/atip/audio/HMIAudioService;)V 
.const [106] = Utf8 execute 
.const [107] = Utf8 ()V 
.const [108] = Utf8 stopConnection 
.const [109] = Utf8 (II)V 
.const [110] = Utf8 isStopped 
.const [111] = Utf8 (I)Z 
.const [112] = Utf8 getConnectionStatus 
.const [113] = Utf8 (I)I 
.end class 
