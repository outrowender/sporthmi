.version 50 0 
.class super [112] 
.super [114] 
.implements [116] 
.field private final synthetic [117] [118] 

.method [120] : [121] 
    .attribute [119] .code stack 2 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     putfield [22] 
L5:     aload_0 
L6:     invokespecial [21] 
L9:     return 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method public [122] : [123] 
    .attribute [119] .code stack 4 locals 0 
L0:     aload_0 
L1:     getfield [19] 
L4:     invokestatic [2] 
L7:     ldc [3] 
L9:     ldc [4] 
L11:    ldc [5] 
L13:    invokevirtual [20] 
L16:    pop 
L17:    aload_2 
L18:    instanceof [6] 
L21:    ifeq L58 
L24:    aload_0 
L25:    getfield [19] 
L28:    invokestatic [2] 
L31:    ldc [3] 
L33:    ldc [7] 
L35:    ldc [5] 
L37:    invokevirtual [20] 
L40:    pop 
L41:    aload_0 
L42:    getfield [19] 
L45:    invokestatic [8] 
L48:    aload_2 
L49:    checkcast [6] 
L52:    invokeinterface [23] 0 
L57:    pop 
L58:    aload_0 
L59:    getfield [19] 
L62:    invokestatic [9] 
L65:    invokeinterface [24] 0 
L70:    aload_1 
L71:    invokeinterface [25] 0 
L76:    return 
L77:    nop 
L78:    nop 
L79:    nop 
L80:    
    .end code 
.end method 

.method public enum [124] : [125] 
    .attribute [119] .code stack 0 locals 0 
L0:     return 
L1:     nop 
L2:     nop 
L3:     nop 
L4:     
    .end code 
.end method 

.method public [126] : [127] 
    .attribute [119] .code stack 4 locals 2 
L0:     aload_0 
L1:     getfield [19] 
L4:     invokestatic [9] 
L7:     invokeinterface [24] 0 
L12:    aload_1 
L13:    invokeinterface [26] 0 
L18:    astore_2 
L19:    aload_2 
L20:    instanceof [6] 
L23:    ifne L63 
L26:    aload_0 
L27:    getfield [19] 
L30:    invokestatic [2] 
L33:    ldc [3] 
L35:    ldc [10] 
L37:    ldc [5] 
L39:    invokevirtual [20] 
L42:    pop 
L43:    aload_0 
L44:    getfield [19] 
L47:    invokestatic [9] 
L50:    invokeinterface [24] 0 
L55:    aload_1 
L56:    invokeinterface [25] 0 
L61:    aload_2 
L62:    areturn 
L63:    aload_2 
L64:    checkcast [6] 
L67:    astore_3 
L68:    aload_3 
L69:    aload_0 
L70:    getfield [19] 
L73:    invokestatic [11] 
L76:    invokeinterface [27] 0 
L81:    aload_0 
L82:    getfield [19] 
L85:    invokestatic [8] 
L88:    aload_3 
L89:    invokeinterface [28] 0 
L94:    pop 
L95:    aload_3 
L96:    areturn 
L97:    nop 
L98:    nop 
L99:    nop 
L100:   
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Method [29] [30] 
.const [3] = Int 1078071040 
.const [4] = String [31] 
.const [5] = String [32] 
.const [6] = Class [33] 
.const [7] = String [34] 
.const [8] = Method [35] [36] 
.const [9] = Method [37] [38] 
.const [10] = String [39] 
.const [11] = Method [40] [41] 
.const [12] = Class [42] 
.const [13] = Class [43] 
.const [14] = Class [44] 
.const [15] = Class [45] 
.const [16] = Class [46] 
.const [17] = Class [47] 
.const [18] = Class [48] 
.const [19] = Field [49] [50] 
.const [20] = Method [51] [52] 
.const [21] = Method [53] [54] 
.const [22] = Field [55] [56] 
.const [23] = InterfaceMethod [57] [58] 
.const [24] = InterfaceMethod [59] [60] 
.const [25] = InterfaceMethod [61] [62] 
.const [26] = InterfaceMethod [63] [64] 
.const [27] = InterfaceMethod [65] [66] 
.const [28] = InterfaceMethod [67] [68] 
.const [29] = Class [69] 
.const [30] = NameAndType [70] [71] 
.const [31] = Utf8 '[%1.removedService]' 
.const [32] = Utf8 PhoneAppHandler 
.const [33] = Utf8 de/audi/atip/interapp/terminalmode/ITerminalModeService 
.const [34] = Utf8 '[%1.addingService] removed service' 
.const [35] = Class [72] 
.const [36] = NameAndType [73] [74] 
.const [37] = Class [75] 
.const [38] = NameAndType [76] [77] 
.const [39] = Utf8 '[%1.addingService] unwanted service' 
.const [40] = Class [78] 
.const [41] = NameAndType [79] [80] 
.const [42] = Utf8 de/audi/app/terminalmode/PhoneAppHandler$1 
.const [43] = Utf8 java/lang/Object 
.const [44] = Utf8 de/audi/app/terminalmode/PhoneAppHandler 
.const [45] = Utf8 de/audi/atip/log/LogChannel 
.const [46] = Utf8 de/audi/atip/utils/generics/GCopyOnWriteList 
.const [47] = Utf8 de/audi/app/terminalmode/IContext 
.const [48] = Utf8 de/audi/app/terminalmode/osgi/IServiceManager 
.const [49] = Class [81] 
.const [50] = NameAndType [82] [83] 
.const [51] = Class [84] 
.const [52] = NameAndType [85] [86] 
.const [53] = Class [87] 
.const [54] = NameAndType [88] [89] 
.const [55] = Class [90] 
.const [56] = NameAndType [91] [92] 
.const [57] = Class [93] 
.const [58] = NameAndType [94] [95] 
.const [59] = Class [96] 
.const [60] = NameAndType [97] [98] 
.const [61] = Class [99] 
.const [62] = NameAndType [100] [101] 
.const [63] = Class [102] 
.const [64] = NameAndType [103] [104] 
.const [65] = Class [105] 
.const [66] = NameAndType [106] [107] 
.const [67] = Class [108] 
.const [68] = NameAndType [109] [110] 
.const [69] = Utf8 de/audi/app/terminalmode/PhoneAppHandler 
.const [70] = Utf8 access$000 
.const [71] = Utf8 (Lde/audi/app/terminalmode/PhoneAppHandler;)Lde/audi/atip/log/LogChannel; 
.const [72] = Utf8 de/audi/app/terminalmode/PhoneAppHandler 
.const [73] = Utf8 access$100 
.const [74] = Utf8 (Lde/audi/app/terminalmode/PhoneAppHandler;)Lde/audi/atip/utils/generics/GCopyOnWriteList; 
.const [75] = Utf8 de/audi/app/terminalmode/PhoneAppHandler 
.const [76] = Utf8 access$200 
.const [77] = Utf8 (Lde/audi/app/terminalmode/PhoneAppHandler;)Lde/audi/app/terminalmode/IContext; 
.const [78] = Utf8 de/audi/app/terminalmode/PhoneAppHandler 
.const [79] = Utf8 access$300 
.const [80] = Utf8 (Lde/audi/app/terminalmode/PhoneAppHandler;)Z 
.const [81] = Utf8 de/audi/app/terminalmode/PhoneAppHandler$1 
.const [82] = Utf8 this$0 
.const [83] = Utf8 Lde/audi/app/terminalmode/PhoneAppHandler; 
.const [84] = Utf8 de/audi/atip/log/LogChannel 
.const [85] = Utf8 log 
.const [86] = Utf8 (ILjava/lang/String;Ljava/lang/Object;)Z 
.const [87] = Utf8 java/lang/Object 
.const [88] = Utf8 <init> 
.const [89] = Utf8 ()V 
.const [90] = Utf8 de/audi/app/terminalmode/PhoneAppHandler$1 
.const [91] = Utf8 this$0 
.const [92] = Utf8 Lde/audi/app/terminalmode/PhoneAppHandler; 
.const [93] = Utf8 de/audi/atip/utils/generics/GCopyOnWriteList 
.const [94] = Utf8 remove 
.const [95] = Utf8 (Ljava/lang/Object;)Z 
.const [96] = Utf8 de/audi/app/terminalmode/IContext 
.const [97] = Utf8 getServiceManager 
.const [98] = Utf8 ()Lde/audi/app/terminalmode/osgi/IServiceManager; 
.const [99] = Utf8 de/audi/app/terminalmode/osgi/IServiceManager 
.const [100] = Utf8 releaseService 
.const [101] = Utf8 (Lorg/osgi/framework/ServiceReference;)V 
.const [102] = Utf8 de/audi/app/terminalmode/osgi/IServiceManager 
.const [103] = Utf8 getService 
.const [104] = Utf8 (Lorg/osgi/framework/ServiceReference;)Ljava/lang/Object; 
.const [105] = Utf8 de/audi/atip/interapp/terminalmode/ITerminalModeService 
.const [106] = Utf8 updateTMVideoFocus 
.const [107] = Utf8 (Z)V 
.const [108] = Utf8 de/audi/atip/utils/generics/GCopyOnWriteList 
.const [109] = Utf8 add 
.const [110] = Utf8 (Ljava/lang/Object;)Z 
.const [111] = Utf8 de/audi/app/terminalmode/PhoneAppHandler$1 
.const [112] = Class [111] 
.const [113] = Utf8 java/lang/Object 
.const [114] = Class [113] 
.const [115] = Utf8 org/osgi/util/tracker/ServiceTrackerCustomizer 
.const [116] = Class [115] 
.const [117] = Utf8 this$0 
.const [118] = Utf8 Lde/audi/app/terminalmode/PhoneAppHandler; 
.const [119] = Utf8 Code 
.const [120] = Utf8 <init> 
.const [121] = Utf8 (Lde/audi/app/terminalmode/PhoneAppHandler;)V 
.const [122] = Utf8 removedService 
.const [123] = Utf8 (Lorg/osgi/framework/ServiceReference;Ljava/lang/Object;)V 
.const [124] = Utf8 modifiedService 
.const [125] = Utf8 (Lorg/osgi/framework/ServiceReference;Ljava/lang/Object;)V 
.const [126] = Utf8 addingService 
.const [127] = Utf8 (Lorg/osgi/framework/ServiceReference;)Ljava/lang/Object; 
.end class 
