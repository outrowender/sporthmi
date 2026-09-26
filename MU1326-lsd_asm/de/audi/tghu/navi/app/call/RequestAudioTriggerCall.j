.version 50 0 
.class public super [94] 
.super [96] 
.field private final [97] [98] 
.field private final [99] [100] 

.method public [102] : [103] 
    .attribute [101] .code stack 2 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     invokevirtual [12] 
L5:     invokespecial [20] 
L8:     aload_0 
L9:     iload_3 
L10:    putfield [21] 
L13:    aload_0 
L14:    aload_2 
L15:    putfield [22] 
L18:    return 
L19:    nop 
L20:    
    .end code 
.end method 

.method public [104] : [105] 
    .attribute [101] .code stack 5 locals 0 
L0:     aload_0 
L1:     getfield [14] 
L4:     ifnonnull L25 
L7:     aload_0 
L8:     getfield [15] 
L11:    sipush 10000 
L14:    ldc [2] 
L16:    aload_0 
L17:    getfield [14] 
L20:    invokevirtual [16] 
L23:    pop 
L24:    return 
L25:    aload_0 
L26:    getfield [14] 
L29:    iconst_0 
L30:    invokevirtual [17] 
L33:    ifnonnull L50 
L36:    aload_0 
L37:    getfield [15] 
L40:    sipush 10000 
L43:    ldc [3] 
L45:    invokevirtual [18] 
L48:    pop 
L49:    return 
L50:    aload_0 
L51:    getfield [15] 
L54:    ldc [4] 
L56:    ldc [5] 
L58:    aload_0 
L59:    getfield [13] 
L62:    i2l 
L63:    invokevirtual [19] 
L66:    pop 
L67:    aload_0 
L68:    getfield [14] 
L71:    iconst_0 
L72:    invokevirtual [17] 
L75:    aload_0 
L76:    getfield [13] 
L79:    invokeinterface [23] 0 
L84:    return 
L85:    nop 
L86:    nop 
L87:    nop 
L88:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = String [24] 
.const [3] = String [25] 
.const [4] = Int -2137614336 
.const [5] = String [26] 
.const [6] = Class [27] 
.const [7] = Class [28] 
.const [8] = Class [29] 
.const [9] = Class [30] 
.const [10] = Class [31] 
.const [11] = Class [32] 
.const [12] = Method [33] [34] 
.const [13] = Field [35] [36] 
.const [14] = Field [37] [38] 
.const [15] = Field [39] [40] 
.const [16] = Method [41] [42] 
.const [17] = Method [43] [44] 
.const [18] = Method [45] [46] 
.const [19] = Method [47] [48] 
.const [20] = Method [49] [50] 
.const [21] = Field [51] [52] 
.const [22] = Field [53] [54] 
.const [23] = InterfaceMethod [55] [56] 
.const [24] = Utf8 'RequestAudioTriggerCall#execute() - dsiNavigationManager is null %1' 
.const [25] = Utf8 'RequestAudioTriggerCall#execute() - dsiNavigation is null' 
.const [26] = Utf8 'RequestAudioTriggerCall#execute() - calling requestAudioTrigger( %1 )' 
.const [27] = Utf8 de/audi/tghu/navi/app/call/RequestAudioTriggerCall 
.const [28] = Utf8 de/audi/tghu/navi/app/call/NavSimpleCall 
.const [29] = Utf8 de/audi/tghu/navi/app/NavigationEnv 
.const [30] = Utf8 de/audi/atip/log/LogChannel 
.const [31] = Utf8 de/audi/tghu/navi/app/dsi/DSINavigationManager 
.const [32] = Utf8 org/dsi/ifc/navigation/DSINavigation 
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
.const [57] = Utf8 de/audi/tghu/navi/app/NavigationEnv 
.const [58] = Utf8 getCommandLogChannel 
.const [59] = Utf8 ()Lde/audi/atip/log/LogChannel; 
.const [60] = Utf8 de/audi/tghu/navi/app/call/RequestAudioTriggerCall 
.const [61] = Utf8 audioMode 
.const [62] = Utf8 I 
.const [63] = Utf8 de/audi/tghu/navi/app/call/RequestAudioTriggerCall 
.const [64] = Utf8 dsiNavigationManager 
.const [65] = Utf8 Lde/audi/tghu/navi/app/dsi/DSINavigationManager; 
.const [66] = Utf8 de/audi/tghu/navi/app/call/RequestAudioTriggerCall 
.const [67] = Utf8 logger 
.const [68] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [69] = Utf8 de/audi/atip/log/LogChannel 
.const [70] = Utf8 log 
.const [71] = Utf8 (ILjava/lang/String;Ljava/lang/Object;)Z 
.const [72] = Utf8 de/audi/tghu/navi/app/dsi/DSINavigationManager 
.const [73] = Utf8 getDSINavigation 
.const [74] = Utf8 (I)Lorg/dsi/ifc/navigation/DSINavigation; 
.const [75] = Utf8 de/audi/atip/log/LogChannel 
.const [76] = Utf8 log 
.const [77] = Utf8 (ILjava/lang/String;)Z 
.const [78] = Utf8 de/audi/atip/log/LogChannel 
.const [79] = Utf8 log 
.const [80] = Utf8 (ILjava/lang/String;J)Z 
.const [81] = Utf8 de/audi/tghu/navi/app/call/NavSimpleCall 
.const [82] = Utf8 <init> 
.const [83] = Utf8 (Lde/audi/atip/log/LogChannel;)V 
.const [84] = Utf8 de/audi/tghu/navi/app/call/RequestAudioTriggerCall 
.const [85] = Utf8 audioMode 
.const [86] = Utf8 I 
.const [87] = Utf8 de/audi/tghu/navi/app/call/RequestAudioTriggerCall 
.const [88] = Utf8 dsiNavigationManager 
.const [89] = Utf8 Lde/audi/tghu/navi/app/dsi/DSINavigationManager; 
.const [90] = Utf8 org/dsi/ifc/navigation/DSINavigation 
.const [91] = Utf8 requestAudioTrigger 
.const [92] = Utf8 (I)V 
.const [93] = Utf8 de/audi/tghu/navi/app/call/RequestAudioTriggerCall 
.const [94] = Class [93] 
.const [95] = Utf8 de/audi/tghu/navi/app/call/NavSimpleCall 
.const [96] = Class [95] 
.const [97] = Utf8 audioMode 
.const [98] = Utf8 I 
.const [99] = Utf8 dsiNavigationManager 
.const [100] = Utf8 Lde/audi/tghu/navi/app/dsi/DSINavigationManager; 
.const [101] = Utf8 Code 
.const [102] = Utf8 <init> 
.const [103] = Utf8 (Lde/audi/tghu/navi/app/NavigationEnv;Lde/audi/tghu/navi/app/dsi/DSINavigationManager;I)V 
.const [104] = Utf8 execute 
.const [105] = Utf8 ()V 
.end class 
