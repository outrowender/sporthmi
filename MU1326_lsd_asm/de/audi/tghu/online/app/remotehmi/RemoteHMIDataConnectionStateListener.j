.version 50 0 
.class public super [78] 
.super [80] 
.implements [82] 
.field private final [83] [84] 
.field private final [85] [86] 

.method public [88] : [89] 
    .attribute [87] .code stack 2 locals 0 
L0:     aload_0 
L1:     invokespecial [17] 
L4:     aload_0 
L5:     aload_1 
L6:     putfield [18] 
L9:     aload_0 
L10:    aload_2 
L11:    putfield [19] 
L14:    return 
L15:    nop 
L16:    
    .end code 
.end method 

.method public [90] : [91] 
    .attribute [87] .code stack 4 locals 1 
L0:     aload_0 
L1:     getfield [11] 
L4:     ldc [2] 
L6:     ldc [3] 
L8:     iload_1 
L9:     invokestatic [4] 
L12:    invokevirtual [13] 
L15:    pop 
L16:    aload_0 
L17:    sipush 1600 
L20:    invokevirtual [14] 
L23:    astore_2 
L24:    aload_0 
L25:    getfield [12] 
L28:    aload_2 
L29:    invokevirtual [15] 
L32:    return 
L33:    nop 
L34:    nop 
L35:    nop 
L36:    
    .end code 
.end method 

.method public [92] : [93] 
    .attribute [87] .code stack 4 locals 0 
L0:     aload_0 
L1:     getfield [11] 
L4:     ldc [2] 
L6:     ldc [5] 
L8:     iload_1 
L9:     invokestatic [4] 
L12:    invokevirtual [13] 
L15:    pop 
L16:    return 
L17:    nop 
L18:    nop 
L19:    nop 
L20:    
    .end code 
.end method 

.method public enum [94] : [95] 
    .attribute [87] .code stack 0 locals 0 
L0:     return 
L1:     nop 
L2:     nop 
L3:     nop 
L4:     
    .end code 
.end method 

.method protected [96] : [97] 
    .attribute [87] .code stack 2 locals 0 
L0:     aload_0 
L1:     getfield [12] 
L4:     iload_1 
L5:     invokevirtual [16] 
L8:     areturn 
L9:     nop 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Int 1078071040 
.const [3] = String [20] 
.const [4] = Method [21] [22] 
.const [5] = String [23] 
.const [6] = Class [24] 
.const [7] = Class [25] 
.const [8] = Class [26] 
.const [9] = Class [27] 
.const [10] = Class [28] 
.const [11] = Field [29] [30] 
.const [12] = Field [31] [32] 
.const [13] = Method [33] [34] 
.const [14] = Method [35] [36] 
.const [15] = Method [37] [38] 
.const [16] = Method [39] [40] 
.const [17] = Method [41] [42] 
.const [18] = Field [43] [44] 
.const [19] = Field [45] [46] 
.const [20] = Utf8 'RemoteHMIDataConnectionStateListener#updateDataConnectionErrorState: state %1' 
.const [21] = Class [47] 
.const [22] = NameAndType [48] [49] 
.const [23] = Utf8 'RemoteHMIDataConnectionStateListener#updateDataConnectionState: state %1' 
.const [24] = Utf8 de/audi/tghu/online/app/remotehmi/RemoteHMIDataConnectionStateListener 
.const [25] = Utf8 java/lang/Object 
.const [26] = Utf8 java/lang/Integer 
.const [27] = Utf8 de/audi/atip/log/LogChannel 
.const [28] = Utf8 de/audi/tghu/online/app/remotehmi/RemoteHMIService 
.const [29] = Class [50] 
.const [30] = NameAndType [51] [52] 
.const [31] = Class [53] 
.const [32] = NameAndType [54] [55] 
.const [33] = Class [56] 
.const [34] = NameAndType [57] [58] 
.const [35] = Class [59] 
.const [36] = NameAndType [60] [61] 
.const [37] = Class [62] 
.const [38] = NameAndType [63] [64] 
.const [39] = Class [65] 
.const [40] = NameAndType [66] [67] 
.const [41] = Class [68] 
.const [42] = NameAndType [69] [70] 
.const [43] = Class [71] 
.const [44] = NameAndType [72] [73] 
.const [45] = Class [74] 
.const [46] = NameAndType [75] [76] 
.const [47] = Utf8 java/lang/Integer 
.const [48] = Utf8 toString 
.const [49] = Utf8 (I)Ljava/lang/String; 
.const [50] = Utf8 de/audi/tghu/online/app/remotehmi/RemoteHMIDataConnectionStateListener 
.const [51] = Utf8 logger 
.const [52] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [53] = Utf8 de/audi/tghu/online/app/remotehmi/RemoteHMIDataConnectionStateListener 
.const [54] = Utf8 remoteHmiService 
.const [55] = Utf8 Lde/audi/tghu/online/app/remotehmi/RemoteHMIService; 
.const [56] = Utf8 de/audi/atip/log/LogChannel 
.const [57] = Utf8 log 
.const [58] = Utf8 (ILjava/lang/String;Ljava/lang/Object;)Z 
.const [59] = Utf8 de/audi/tghu/online/app/remotehmi/RemoteHMIDataConnectionStateListener 
.const [60] = Utf8 getAction 
.const [61] = Utf8 (I)Lde/audi/remotehmi/RemoteHMIAction; 
.const [62] = Utf8 de/audi/tghu/online/app/remotehmi/RemoteHMIService 
.const [63] = Utf8 invokeAction 
.const [64] = Utf8 (Lde/audi/remotehmi/RemoteHMIAction;)V 
.const [65] = Utf8 de/audi/tghu/online/app/remotehmi/RemoteHMIService 
.const [66] = Utf8 getAction 
.const [67] = Utf8 (I)Lde/audi/remotehmi/RemoteHMIAction; 
.const [68] = Utf8 java/lang/Object 
.const [69] = Utf8 <init> 
.const [70] = Utf8 ()V 
.const [71] = Utf8 de/audi/tghu/online/app/remotehmi/RemoteHMIDataConnectionStateListener 
.const [72] = Utf8 logger 
.const [73] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [74] = Utf8 de/audi/tghu/online/app/remotehmi/RemoteHMIDataConnectionStateListener 
.const [75] = Utf8 remoteHmiService 
.const [76] = Utf8 Lde/audi/tghu/online/app/remotehmi/RemoteHMIService; 
.const [77] = Utf8 de/audi/tghu/online/app/remotehmi/RemoteHMIDataConnectionStateListener 
.const [78] = Class [77] 
.const [79] = Utf8 java/lang/Object 
.const [80] = Class [79] 
.const [81] = Utf8 de/audi/atip/interapp/DataConnectionStateListener 
.const [82] = Class [81] 
.const [83] = Utf8 logger 
.const [84] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [85] = Utf8 remoteHmiService 
.const [86] = Utf8 Lde/audi/tghu/online/app/remotehmi/RemoteHMIService; 
.const [87] = Utf8 Code 
.const [88] = Utf8 <init> 
.const [89] = Utf8 (Lde/audi/atip/log/LogChannel;Lde/audi/tghu/online/app/remotehmi/RemoteHMIService;)V 
.const [90] = Utf8 updateDataConnectionErrorState 
.const [91] = Utf8 (I)V 
.const [92] = Utf8 updateDataConnectionState 
.const [93] = Utf8 (I)V 
.const [94] = Utf8 resetOfflineFlags 
.const [95] = Utf8 ()V 
.const [96] = Utf8 getAction 
.const [97] = Utf8 (I)Lde/audi/remotehmi/RemoteHMIAction; 
.end class 
