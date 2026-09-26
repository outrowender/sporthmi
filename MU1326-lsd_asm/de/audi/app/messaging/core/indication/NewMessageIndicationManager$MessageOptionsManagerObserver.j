.version 50 0 
.class final super [100] 
.super [102] 
.field private final synthetic [103] [104] 

.method private [106] : [107] 
    .attribute [105] .code stack 2 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     putfield [24] 
L5:     aload_0 
L6:     invokespecial [23] 
L9:     return 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method public [108] : [109] 
    .attribute [105] .code stack 3 locals 3 
L0:     aload_0 
L1:     getfield [16] 
L4:     invokestatic [2] 
L7:     invokevirtual [17] 
L10:    dup 
L11:    astore_1 
L12:    monitorenter 
        .catch [0] from L13 to L59 using L62 
L13:    aload_0 
L14:    getfield [16] 
L17:    invokestatic [3] 
L20:    ldc [4] 
L22:    ldc [5] 
L24:    invokevirtual [18] 
L27:    pop 
L28:    aload_0 
L29:    getfield [16] 
L32:    invokestatic [6] 
L35:    invokevirtual [19] 
L38:    invokevirtual [20] 
L41:    astore_2 
L42:    aload_2 
L43:    ifnull L57 
L46:    aload_0 
L47:    getfield [16] 
L50:    aload_2 
L51:    invokevirtual [21] 
L54:    invokestatic [7] 
L57:    aload_1 
L58:    monitorexit 
L59:    goto L67 
        .catch [0] from L62 to L65 using L62 
L62:    astore_3 
L63:    aload_1 
L64:    monitorexit 
L65:    aload_3 
L66:    athrow 
L67:    return 
L68:    
    .end code 
.end method 

.method synthetic [110] : [111] 
    .attribute [105] .code stack 2 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     invokespecial [22] 
L5:     return 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Method [25] [26] 
.const [3] = Method [27] [28] 
.const [4] = Int -2137614336 
.const [5] = String [29] 
.const [6] = Method [30] [31] 
.const [7] = Method [32] [33] 
.const [8] = Class [34] 
.const [9] = Class [35] 
.const [10] = Class [36] 
.const [11] = Class [37] 
.const [12] = Class [38] 
.const [13] = Class [39] 
.const [14] = Class [40] 
.const [15] = Class [41] 
.const [16] = Field [42] [43] 
.const [17] = Method [44] [45] 
.const [18] = Method [46] [47] 
.const [19] = Method [48] [49] 
.const [20] = Method [50] [51] 
.const [21] = Method [52] [53] 
.const [22] = Method [54] [55] 
.const [23] = Method [56] [57] 
.const [24] = Field [58] [59] 
.const [25] = Class [60] 
.const [26] = NameAndType [61] [62] 
.const [27] = Class [63] 
.const [28] = NameAndType [64] [65] 
.const [29] = Utf8 '[NewMessageIndicationManager#messageDetailsChanged]' 
.const [30] = Class [66] 
.const [31] = NameAndType [67] [68] 
.const [32] = Class [69] 
.const [33] = NameAndType [70] [71] 
.const [34] = Utf8 de/audi/app/messaging/core/indication/NewMessageIndicationManager$MessageOptionsManagerObserver 
.const [35] = Utf8 de/audi/app/messaging/core/viewmessage/IMessageOptionsManagerObserver$EmptyImplementation 
.const [36] = Utf8 de/audi/app/messaging/core/indication/NewMessageIndicationManager 
.const [37] = Utf8 de/audi/app/messaging/core/osgi/MessagingBundleContext 
.const [38] = Utf8 de/audi/atip/log/LogChannel 
.const [39] = Utf8 de/audi/app/messaging/core/application/AbstractMsgApplication 
.const [40] = Utf8 de/audi/app/messaging/core/viewmessage/SelectedMessage 
.const [41] = Utf8 org/dsi/ifc/messaging/MessageDetails 
.const [42] = Class [72] 
.const [43] = NameAndType [73] [74] 
.const [44] = Class [75] 
.const [45] = NameAndType [76] [77] 
.const [46] = Class [78] 
.const [47] = NameAndType [79] [80] 
.const [48] = Class [81] 
.const [49] = NameAndType [82] [83] 
.const [50] = Class [84] 
.const [51] = NameAndType [85] [86] 
.const [52] = Class [87] 
.const [53] = NameAndType [88] [89] 
.const [54] = Class [90] 
.const [55] = NameAndType [91] [92] 
.const [56] = Class [93] 
.const [57] = NameAndType [94] [95] 
.const [58] = Class [96] 
.const [59] = NameAndType [97] [98] 
.const [60] = Utf8 de/audi/app/messaging/core/indication/NewMessageIndicationManager 
.const [61] = Utf8 access$2700 
.const [62] = Utf8 (Lde/audi/app/messaging/core/indication/NewMessageIndicationManager;)Lde/audi/app/messaging/core/osgi/MessagingBundleContext; 
.const [63] = Utf8 de/audi/app/messaging/core/indication/NewMessageIndicationManager 
.const [64] = Utf8 access$2800 
.const [65] = Utf8 (Lde/audi/app/messaging/core/indication/NewMessageIndicationManager;)Lde/audi/atip/log/LogChannel; 
.const [66] = Utf8 de/audi/app/messaging/core/indication/NewMessageIndicationManager 
.const [67] = Utf8 access$2900 
.const [68] = Utf8 (Lde/audi/app/messaging/core/indication/NewMessageIndicationManager;)Lde/audi/app/messaging/core/application/AbstractMsgApplication; 
.const [69] = Utf8 de/audi/app/messaging/core/indication/NewMessageIndicationManager 
.const [70] = Utf8 access$2600 
.const [71] = Utf8 (Lde/audi/app/messaging/core/indication/NewMessageIndicationManager;Ljava/lang/String;)V 
.const [72] = Utf8 de/audi/app/messaging/core/indication/NewMessageIndicationManager$MessageOptionsManagerObserver 
.const [73] = Utf8 this$0 
.const [74] = Utf8 Lde/audi/app/messaging/core/indication/NewMessageIndicationManager; 
.const [75] = Utf8 de/audi/app/messaging/core/osgi/MessagingBundleContext 
.const [76] = Utf8 getMessagingHmiLock 
.const [77] = Utf8 ()Ljava/lang/Object; 
.const [78] = Utf8 de/audi/atip/log/LogChannel 
.const [79] = Utf8 log 
.const [80] = Utf8 (ILjava/lang/String;)Z 
.const [81] = Utf8 de/audi/app/messaging/core/application/AbstractMsgApplication 
.const [82] = Utf8 getSelectedMessage 
.const [83] = Utf8 ()Lde/audi/app/messaging/core/viewmessage/SelectedMessage; 
.const [84] = Utf8 de/audi/app/messaging/core/viewmessage/SelectedMessage 
.const [85] = Utf8 getMessageDetails 
.const [86] = Utf8 ()Lorg/dsi/ifc/messaging/MessageDetails; 
.const [87] = Utf8 org/dsi/ifc/messaging/MessageDetails 
.const [88] = Utf8 getMessageID 
.const [89] = Utf8 ()Ljava/lang/String; 
.const [90] = Utf8 de/audi/app/messaging/core/indication/NewMessageIndicationManager$MessageOptionsManagerObserver 
.const [91] = Utf8 <init> 
.const [92] = Utf8 (Lde/audi/app/messaging/core/indication/NewMessageIndicationManager;)V 
.const [93] = Utf8 de/audi/app/messaging/core/viewmessage/IMessageOptionsManagerObserver$EmptyImplementation 
.const [94] = Utf8 <init> 
.const [95] = Utf8 ()V 
.const [96] = Utf8 de/audi/app/messaging/core/indication/NewMessageIndicationManager$MessageOptionsManagerObserver 
.const [97] = Utf8 this$0 
.const [98] = Utf8 Lde/audi/app/messaging/core/indication/NewMessageIndicationManager; 
.const [99] = Utf8 de/audi/app/messaging/core/indication/NewMessageIndicationManager$MessageOptionsManagerObserver 
.const [100] = Class [99] 
.const [101] = Utf8 de/audi/app/messaging/core/viewmessage/IMessageOptionsManagerObserver$EmptyImplementation 
.const [102] = Class [101] 
.const [103] = Utf8 this$0 
.const [104] = Utf8 Lde/audi/app/messaging/core/indication/NewMessageIndicationManager; 
.const [105] = Utf8 Code 
.const [106] = Utf8 <init> 
.const [107] = Utf8 (Lde/audi/app/messaging/core/indication/NewMessageIndicationManager;)V 
.const [108] = Utf8 messageDetailsChanged 
.const [109] = Utf8 ()V 
.const [110] = Utf8 <init> 
.const [111] = Utf8 (Lde/audi/app/messaging/core/indication/NewMessageIndicationManager;Lde/audi/app/messaging/core/indication/NewMessageIndicationManager$1;)V 
.end class 
