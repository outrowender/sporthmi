.version 50 0 
.class public super [94] 
.super [96] 
.implements [98] 
.field private [99] [100] 
.field private [101] [102] 

.method public [104] : [105] 
    .attribute [103] .code stack 2 locals 0 
L0:     aload_0 
L1:     invokespecial [19] 
L4:     aload_0 
L5:     aload_1 
L6:     putfield [20] 
L9:     aload_0 
L10:    aload_2 
L11:    putfield [21] 
L14:    return 
L15:    nop 
L16:    
    .end code 
.end method 

.method public enum [106] : [107] 
    .attribute [103] .code stack 0 locals 0 
L0:     return 
L1:     nop 
L2:     nop 
L3:     nop 
L4:     
    .end code 
.end method 

.method public enum [108] : [109] 
    .attribute [103] .code stack 0 locals 0 
L0:     return 
L1:     nop 
L2:     nop 
L3:     nop 
L4:     
    .end code 
.end method 

.method public [110] : [111] 
    .attribute [103] .code stack 4 locals 1 
L0:     aload_0 
L1:     getfield [14] 
L4:     ldc [2] 
L6:     ldc [3] 
L8:     iload_1 
L9:     invokevirtual [15] 
L12:    pop 
L13:    iload_1 
L14:    ifeq L21 
L17:    iconst_0 
L18:    goto L22 
L21:    iconst_1 
L22:    istore_2 
L23:    aload_0 
L24:    getfield [13] 
L27:    ldc [4] 
L29:    invokevirtual [16] 
L32:    iload_2 
L33:    invokeinterface [22] 0 
L38:    return 
L39:    nop 
L40:    
    .end code 
.end method 

.method public [112] : [113] 
    .attribute [103] .code stack 1 locals 0 
L0:     iconst_0 
L1:     areturn 
L2:     nop 
L3:     nop 
L4:     
    .end code 
.end method 

.method public [114] : [115] 
    .attribute [103] .code stack 1 locals 0 
L0:     iconst_0 
L1:     areturn 
L2:     nop 
L3:     nop 
L4:     
    .end code 
.end method 

.method public enum [116] : [117] 
    .attribute [103] .code stack 0 locals 0 
L0:     return 
L1:     nop 
L2:     nop 
L3:     nop 
L4:     
    .end code 
.end method 

.method public enum [118] : [119] 
    .attribute [103] .code stack 0 locals 0 
L0:     return 
L1:     nop 
L2:     nop 
L3:     nop 
L4:     
    .end code 
.end method 

.method public enum [120] : [121] 
    .attribute [103] .code stack 0 locals 0 
L0:     return 
L1:     nop 
L2:     nop 
L3:     nop 
L4:     
    .end code 
.end method 

.method public enum [122] : [123] 
    .attribute [103] .code stack 0 locals 0 
L0:     return 
L1:     nop 
L2:     nop 
L3:     nop 
L4:     
    .end code 
.end method 

.method public [124] : [125] 
    .attribute [103] .code stack 1 locals 0 
L0:     iconst_0 
L1:     areturn 
L2:     nop 
L3:     nop 
L4:     
    .end code 
.end method 

.method public [126] : [127] 
    .attribute [103] .code stack 1 locals 0 
L0:     iconst_0 
L1:     areturn 
L2:     nop 
L3:     nop 
L4:     
    .end code 
.end method 

.method public enum [128] : [129] 
    .attribute [103] .code stack 0 locals 0 
L0:     return 
L1:     nop 
L2:     nop 
L3:     nop 
L4:     
    .end code 
.end method 

.method public enum [130] : [131] 
    .attribute [103] .code stack 0 locals 0 
L0:     return 
L1:     nop 
L2:     nop 
L3:     nop 
L4:     
    .end code 
.end method 

.method public enum [132] : [133] 
    .attribute [103] .code stack 0 locals 0 
L0:     return 
L1:     nop 
L2:     nop 
L3:     nop 
L4:     
    .end code 
.end method 

.method public [134] : [135] 
    .attribute [103] .code stack 7 locals 2 
L0:     aload_0 
L1:     getfield [13] 
L4:     ldc [5] 
L6:     invokevirtual [16] 
L9:     invokeinterface [23] 0 
L14:    istore_2 
L15:    aload_0 
L16:    getfield [14] 
L19:    ldc [2] 
L21:    ldc [6] 
L23:    iload_1 
L24:    i2l 
L25:    iload_2 
L26:    i2l 
L27:    invokevirtual [17] 
L30:    pop 
L31:    iconst_m1 
L32:    istore_3 
L33:    iload_1 
L34:    ifne L42 
L37:    iconst_1 
L38:    istore_3 
L39:    goto L73 
L42:    iload_1 
L43:    bipush 6 
L45:    if_icmpne L58 
L48:    iload_2 
L49:    iconst_1 
L50:    if_icmpne L58 
L53:    iconst_2 
L54:    istore_3 
L55:    goto L73 
L58:    iload_1 
L59:    iconst_1 
L60:    if_icmpeq L73 
L63:    iload_1 
L64:    iconst_4 
L65:    if_icmpne L71 
L68:    goto L73 
L71:    iconst_0 
L72:    istore_3 
L73:    iload_3 
L74:    iflt L106 
L77:    aload_0 
L78:    getfield [14] 
L81:    ldc [2] 
L83:    ldc [7] 
L85:    iload_3 
L86:    i2l 
L87:    invokevirtual [18] 
L90:    pop 
L91:    aload_0 
L92:    getfield [13] 
L95:    ldc [5] 
L97:    invokevirtual [16] 
L100:   iload_3 
L101:   invokeinterface [24] 0 
L106:   return 
L107:   nop 
L108:   
    .end code 
.end method 

.method public [136] : [137] 
    .attribute [103] .code stack 2 locals 1 
L0:     iconst_0 
L1:     istore_1 
L2:     aload_0 
L3:     getfield [13] 
L6:     ldc [5] 
L8:     invokevirtual [16] 
L11:    iload_1 
L12:    invokeinterface [24] 0 
L17:    return 
L18:    nop 
L19:    nop 
L20:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Int 1078071040 
.const [3] = String [25] 
.const [4] = Int 371525120 
.const [5] = Int 1747125760 
.const [6] = String [26] 
.const [7] = String [27] 
.const [8] = Class [28] 
.const [9] = Class [29] 
.const [10] = Class [30] 
.const [11] = Class [31] 
.const [12] = Class [32] 
.const [13] = Field [33] [34] 
.const [14] = Field [35] [36] 
.const [15] = Method [37] [38] 
.const [16] = Method [39] [40] 
.const [17] = Method [41] [42] 
.const [18] = Method [43] [44] 
.const [19] = Method [45] [46] 
.const [20] = Field [47] [48] 
.const [21] = Field [49] [50] 
.const [22] = InterfaceMethod [51] [52] 
.const [23] = InterfaceMethod [53] [54] 
.const [24] = InterfaceMethod [55] [56] 
.const [25] = Utf8 'NavigationBrowserCallbackHandler#updateBrowserStateBusy busy=%1' 
.const [26] = Utf8 'NavigationBrowserCallbackHandler#updateBrowserState browserState : %1 currentHMIState: %2' 
.const [27] = Utf8 'NavigationBrowserCallbackHandler#updateBrowserState hmiState chnaged to %1' 
.const [28] = Utf8 de/audi/tghu/navi/app/NavigationBrowserCallbackHandler 
.const [29] = Utf8 java/lang/Object 
.const [30] = Utf8 de/audi/atip/log/LogChannel 
.const [31] = Utf8 de/audi/tghu/navi/app/NavigationEnv 
.const [32] = Utf8 de/audi/atip/hmi/modelaccess/ChoiceModelApp 
.const [33] = Class [57] 
.const [34] = NameAndType [58] [59] 
.const [35] = Class [60] 
.const [36] = NameAndType [61] [62] 
.const [37] = Class [63] 
.const [38] = NameAndType [64] [65] 
.const [39] = Class [66] 
.const [40] = NameAndType [67] [68] 
.const [41] = Class [69] 
.const [42] = NameAndType [70] [71] 
.const [43] = Class [72] 
.const [44] = NameAndType [73] [74] 
.const [45] = Class [75] 
.const [46] = NameAndType [76] [77] 
.const [47] = Class [78] 
.const [48] = NameAndType [79] [80] 
.const [49] = Class [81] 
.const [50] = NameAndType [82] [83] 
.const [51] = Class [84] 
.const [52] = NameAndType [85] [86] 
.const [53] = Class [87] 
.const [54] = NameAndType [88] [89] 
.const [55] = Class [90] 
.const [56] = NameAndType [91] [92] 
.const [57] = Utf8 de/audi/tghu/navi/app/NavigationBrowserCallbackHandler 
.const [58] = Utf8 env 
.const [59] = Utf8 Lde/audi/tghu/navi/app/NavigationEnv; 
.const [60] = Utf8 de/audi/tghu/navi/app/NavigationBrowserCallbackHandler 
.const [61] = Utf8 logChannel 
.const [62] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [63] = Utf8 de/audi/atip/log/LogChannel 
.const [64] = Utf8 log 
.const [65] = Utf8 (ILjava/lang/String;Z)Z 
.const [66] = Utf8 de/audi/tghu/navi/app/NavigationEnv 
.const [67] = Utf8 getChoiceModel 
.const [68] = Utf8 (I)Lde/audi/atip/hmi/modelaccess/ChoiceModelApp; 
.const [69] = Utf8 de/audi/atip/log/LogChannel 
.const [70] = Utf8 log 
.const [71] = Utf8 (ILjava/lang/String;JJ)Z 
.const [72] = Utf8 de/audi/atip/log/LogChannel 
.const [73] = Utf8 log 
.const [74] = Utf8 (ILjava/lang/String;J)Z 
.const [75] = Utf8 java/lang/Object 
.const [76] = Utf8 <init> 
.const [77] = Utf8 ()V 
.const [78] = Utf8 de/audi/tghu/navi/app/NavigationBrowserCallbackHandler 
.const [79] = Utf8 env 
.const [80] = Utf8 Lde/audi/tghu/navi/app/NavigationEnv; 
.const [81] = Utf8 de/audi/tghu/navi/app/NavigationBrowserCallbackHandler 
.const [82] = Utf8 logChannel 
.const [83] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [84] = Utf8 de/audi/atip/hmi/modelaccess/ChoiceModelApp 
.const [85] = Utf8 setStatus 
.const [86] = Utf8 (I)V 
.const [87] = Utf8 de/audi/atip/hmi/modelaccess/ChoiceModelApp 
.const [88] = Utf8 getValue 
.const [89] = Utf8 ()I 
.const [90] = Utf8 de/audi/atip/hmi/modelaccess/ChoiceModelApp 
.const [91] = Utf8 setValue 
.const [92] = Utf8 (I)V 
.const [93] = Utf8 de/audi/tghu/navi/app/NavigationBrowserCallbackHandler 
.const [94] = Class [93] 
.const [95] = Utf8 java/lang/Object 
.const [96] = Class [95] 
.const [97] = Utf8 de/audi/atip/browser/IBrowserCallbackHandler 
.const [98] = Class [97] 
.const [99] = Utf8 env 
.const [100] = Utf8 Lde/audi/tghu/navi/app/NavigationEnv; 
.const [101] = Utf8 logChannel 
.const [102] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [103] = Utf8 Code 
.const [104] = Utf8 <init> 
.const [105] = Utf8 (Lde/audi/tghu/navi/app/NavigationEnv;Lde/audi/atip/log/LogChannel;)V 
.const [106] = Utf8 updateScrollbarX 
.const [107] = Utf8 (IIII)V 
.const [108] = Utf8 updateScrollbarY 
.const [109] = Utf8 (IIII)V 
.const [110] = Utf8 updateBrowserStateBusy 
.const [111] = Utf8 (Z)V 
.const [112] = Utf8 scrollDown 
.const [113] = Utf8 (I)Z 
.const [114] = Utf8 scrollUp 
.const [115] = Utf8 (I)Z 
.const [116] = Utf8 indicateBrowserStateNotFound 
.const [117] = Utf8 ()V 
.const [118] = Utf8 indicateBrowserStateComplete 
.const [119] = Utf8 ()V 
.const [120] = Utf8 indicateBrowserStateTimeout 
.const [121] = Utf8 ()V 
.const [122] = Utf8 javascriptAlert 
.const [123] = Utf8 (Ljava/lang/String;)V 
.const [124] = Utf8 press 
.const [125] = Utf8 ()Z 
.const [126] = Utf8 indicateEfiUrl 
.const [127] = Utf8 (Ljava/lang/String;)Z 
.const [128] = Utf8 belowLowerThreshold 
.const [129] = Utf8 (I)V 
.const [130] = Utf8 exceedsUpperThreshold 
.const [131] = Utf8 (I)V 
.const [132] = Utf8 indicateBoardbookAvailable 
.const [133] = Utf8 (Z)V 
.const [134] = Utf8 updateBrowserState 
.const [135] = Utf8 (I)V 
.const [136] = Utf8 virtualButtonBack 
.const [137] = Utf8 ()V 
.end class 
