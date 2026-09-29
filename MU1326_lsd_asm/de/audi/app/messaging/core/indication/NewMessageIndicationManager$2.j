.version 50 0 
.class super [88] 
.super [90] 
.implements [92] 
.field private final synthetic [93] [94] 
.field private final synthetic [95] [96] 

.method [98] : [99] 
    .attribute [97] .code stack 2 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     putfield [20] 
L5:     aload_0 
L6:     iload_2 
L7:     putfield [21] 
L10:    aload_0 
L11:    invokespecial [19] 
L14:    return 
L15:    nop 
L16:    
    .end code 
.end method 

.method public [100] : [101] 
    .attribute [97] .code stack 5 locals 3 
L0:     aload_0 
L1:     getfield [16] 
L4:     invokestatic [2] 
L7:     ldc [3] 
L9:     ldc [4] 
L11:    aload_0 
L12:    getfield [17] 
L15:    i2l 
L16:    invokevirtual [18] 
L19:    pop 
L20:    aload_0 
L21:    getfield [16] 
L24:    invokestatic [5] 
L27:    astore_1 
L28:    iconst_0 
L29:    istore_2 
L30:    iload_2 
L31:    aload_1 
L32:    arraylength 
L33:    if_icmpge L71 
        .catch [6] from L36 to L48 using L51 
L36:    aload_1 
L37:    iload_2 
L38:    aaload 
L39:    aload_0 
L40:    getfield [17] 
L43:    invokeinterface [22] 0 
L48:    goto L65 
L51:    astore_3 
L52:    aload_0 
L53:    getfield [16] 
L56:    invokestatic [7] 
L59:    aload_3 
L60:    ldc [8] 
L62:    invokestatic [9] 
L65:    iinc 2 1 
L68:    goto L30 
L71:    return 
L72:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Method [23] [24] 
.const [3] = Int -2137614336 
.const [4] = String [25] 
.const [5] = Method [26] [27] 
.const [6] = Class [28] 
.const [7] = Method [29] [30] 
.const [8] = String [31] 
.const [9] = Method [32] [33] 
.const [10] = Class [34] 
.const [11] = Class [35] 
.const [12] = Class [36] 
.const [13] = Class [37] 
.const [14] = Class [38] 
.const [15] = Class [39] 
.const [16] = Field [40] [41] 
.const [17] = Field [42] [43] 
.const [18] = Method [44] [45] 
.const [19] = Method [46] [47] 
.const [20] = Field [48] [49] 
.const [21] = Field [50] [51] 
.const [22] = InterfaceMethod [52] [53] 
.const [23] = Class [54] 
.const [24] = NameAndType [55] [56] 
.const [25] = Utf8 '[NewMessageIndicationManager#notifyObservers] stateAspect = %1' 
.const [26] = Class [57] 
.const [27] = NameAndType [58] [59] 
.const [28] = Utf8 java/lang/Exception 
.const [29] = Class [60] 
.const [30] = NameAndType [61] [62] 
.const [31] = Utf8 '[NewMessageIndicationManager#notifyObservers]' 
.const [32] = Class [63] 
.const [33] = NameAndType [64] [65] 
.const [34] = Utf8 de/audi/app/messaging/core/indication/NewMessageIndicationManager$2 
.const [35] = Utf8 java/lang/Object 
.const [36] = Utf8 de/audi/app/messaging/core/indication/NewMessageIndicationManager 
.const [37] = Utf8 de/audi/atip/log/LogChannel 
.const [38] = Utf8 de/audi/app/messaging/core/indication/INewMessageIndicationManagerObserver 
.const [39] = Utf8 de/audi/app/messaging/core/util/Logs 
.const [40] = Class [66] 
.const [41] = NameAndType [67] [68] 
.const [42] = Class [69] 
.const [43] = NameAndType [70] [71] 
.const [44] = Class [72] 
.const [45] = NameAndType [73] [74] 
.const [46] = Class [75] 
.const [47] = NameAndType [76] [77] 
.const [48] = Class [78] 
.const [49] = NameAndType [79] [80] 
.const [50] = Class [81] 
.const [51] = NameAndType [82] [83] 
.const [52] = Class [84] 
.const [53] = NameAndType [85] [86] 
.const [54] = Utf8 de/audi/app/messaging/core/indication/NewMessageIndicationManager 
.const [55] = Utf8 access$200 
.const [56] = Utf8 (Lde/audi/app/messaging/core/indication/NewMessageIndicationManager;)Lde/audi/atip/log/LogChannel; 
.const [57] = Utf8 de/audi/app/messaging/core/indication/NewMessageIndicationManager 
.const [58] = Utf8 access$300 
.const [59] = Utf8 (Lde/audi/app/messaging/core/indication/NewMessageIndicationManager;)[Lde/audi/app/messaging/core/indication/INewMessageIndicationManagerObserver; 
.const [60] = Utf8 de/audi/app/messaging/core/indication/NewMessageIndicationManager 
.const [61] = Utf8 access$400 
.const [62] = Utf8 (Lde/audi/app/messaging/core/indication/NewMessageIndicationManager;)Lde/audi/atip/log/LogChannel; 
.const [63] = Utf8 de/audi/app/messaging/core/util/Logs 
.const [64] = Utf8 logException 
.const [65] = Utf8 (Lde/audi/atip/log/LogChannel;Ljava/lang/Throwable;Ljava/lang/String;)V 
.const [66] = Utf8 de/audi/app/messaging/core/indication/NewMessageIndicationManager$2 
.const [67] = Utf8 this$0 
.const [68] = Utf8 Lde/audi/app/messaging/core/indication/NewMessageIndicationManager; 
.const [69] = Utf8 de/audi/app/messaging/core/indication/NewMessageIndicationManager$2 
.const [70] = Utf8 val$stateAspect 
.const [71] = Utf8 I 
.const [72] = Utf8 de/audi/atip/log/LogChannel 
.const [73] = Utf8 log 
.const [74] = Utf8 (ILjava/lang/String;J)Z 
.const [75] = Utf8 java/lang/Object 
.const [76] = Utf8 <init> 
.const [77] = Utf8 ()V 
.const [78] = Utf8 de/audi/app/messaging/core/indication/NewMessageIndicationManager$2 
.const [79] = Utf8 this$0 
.const [80] = Utf8 Lde/audi/app/messaging/core/indication/NewMessageIndicationManager; 
.const [81] = Utf8 de/audi/app/messaging/core/indication/NewMessageIndicationManager$2 
.const [82] = Utf8 val$stateAspect 
.const [83] = Utf8 I 
.const [84] = Utf8 de/audi/app/messaging/core/indication/INewMessageIndicationManagerObserver 
.const [85] = Utf8 indicateIndicationStateChanged 
.const [86] = Utf8 (I)V 
.const [87] = Utf8 de/audi/app/messaging/core/indication/NewMessageIndicationManager$2 
.const [88] = Class [87] 
.const [89] = Utf8 java/lang/Object 
.const [90] = Class [89] 
.const [91] = Utf8 java/lang/Runnable 
.const [92] = Class [91] 
.const [93] = Utf8 val$stateAspect 
.const [94] = Utf8 I 
.const [95] = Utf8 this$0 
.const [96] = Utf8 Lde/audi/app/messaging/core/indication/NewMessageIndicationManager; 
.const [97] = Utf8 Code 
.const [98] = Utf8 <init> 
.const [99] = Utf8 (Lde/audi/app/messaging/core/indication/NewMessageIndicationManager;I)V 
.const [100] = Utf8 run 
.const [101] = Utf8 ()V 
.end class 
