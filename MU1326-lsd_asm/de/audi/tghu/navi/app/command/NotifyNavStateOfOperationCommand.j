.version 50 0 
.class public super [146] 
.super [148] 
.field private [149] [150] 

.method public [152] : [153] 
    .attribute [151] .code stack 2 locals 0 
L0:     aload_0 
L1:     invokespecial [29] 
L4:     aload_0 
L5:     iconst_0 
L6:     putfield [32] 
L9:     aload_0 
L10:    iload_1 
L11:    putfield [32] 
L14:    return 
L15:    nop 
L16:    
    .end code 
.end method 

.method public [154] : [155] 
    .attribute [151] .code stack 2 locals 0 
L0:     aload_0 
L1:     getfield [17] 
L4:     ifeq L13 
L7:     ldc2_w [35] 
L10:    goto L17 
L13:    aload_0 
L14:    invokespecial [30] 
L17:    freturn 
L18:    nop 
L19:    nop 
L20:    
    .end code 
.end method 

.method public [156] : [157] 
    .attribute [151] .code stack 5 locals 0 
L0:     aload_0 
L1:     getfield [18] 
L4:     ldc [2] 
L6:     ldc [3] 
L8:     invokevirtual [19] 
L11:    pop 
L12:    aload_0 
L13:    invokevirtual [20] 
L16:    iconst_1 
L17:    newarray int 
L19:    dup 
L20:    iconst_0 
L21:    bipush 52 
L23:    iastore 
L24:    aload_0 
L25:    invokevirtual [21] 
L28:    invokeinterface [33] 0 
L33:    return 
L34:    nop 
L35:    nop 
L36:    
    .end code 
.end method 

.method public [158] : [159] 
    .attribute [151] .code stack 5 locals 0 
L0:     aload_0 
L1:     getfield [18] 
L4:     ldc [2] 
L6:     ldc [4] 
L8:     iload_1 
L9:     i2l 
L10:    invokevirtual [22] 
L13:    pop 
L14:    aload_0 
L15:    iload_1 
L16:    invokespecial [31] 
L19:    aload_0 
L20:    getfield [17] 
L23:    ifeq L78 
L26:    iload_1 
L27:    iconst_5 
L28:    if_icmpne L87 
L31:    aload_0 
L32:    getfield [18] 
L35:    ldc [2] 
L37:    ldc [5] 
L39:    invokevirtual [19] 
L42:    pop 
L43:    aload_0 
L44:    getfield [23] 
L47:    invokevirtual [24] 
L50:    ldc [6] 
L52:    invokestatic [7] 
L55:    aload_0 
L56:    getfield [25] 
L59:    invokevirtual [26] 
L62:    iconst_2 
L63:    invokevirtual [27] 
L66:    aload_0 
L67:    invokevirtual [28] 
L70:    invokeinterface [34] 0 
L75:    goto L87 
L78:    aload_0 
L79:    invokevirtual [28] 
L82:    invokeinterface [34] 0 
L87:    return 
L88:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Int -2137614336 
.const [3] = String [37] 
.const [4] = String [38] 
.const [5] = String [39] 
.const [6] = String [40] 
.const [7] = Method [41] [42] 
.const [8] = Class [43] 
.const [9] = Class [44] 
.const [10] = Class [45] 
.const [11] = Class [46] 
.const [12] = Class [47] 
.const [13] = Class [48] 
.const [14] = Class [49] 
.const [15] = Class [50] 
.const [16] = Class [51] 
.const [17] = Field [52] [53] 
.const [18] = Field [54] [55] 
.const [19] = Method [56] [57] 
.const [20] = Method [58] [59] 
.const [21] = Method [60] [61] 
.const [22] = Method [62] [63] 
.const [23] = Field [64] [65] 
.const [24] = Method [66] [67] 
.const [25] = Field [68] [69] 
.const [26] = Method [70] [71] 
.const [27] = Method [72] [73] 
.const [28] = Method [74] [75] 
.const [29] = Method [76] [77] 
.const [30] = Method [78] [79] 
.const [31] = Method [80] [81] 
.const [32] = Field [82] [83] 
.const [33] = InterfaceMethod [84] [85] 
.const [34] = InterfaceMethod [86] [87] 
.const [35] = Long -1L 
.const [37] = Utf8 'NotifyNavStateOfOperationCommand#execute() - command setNotification() for ATTR_NAVSTATEOFOPERATION ' 
.const [38] = Utf8 'NotifyNavStateOfOperationCommand#updateNavstateOfOperation( %1 ) ' 
.const [39] = Utf8 'NotifyNavStateOfOperationCommand#updateNavstateOfOperation() - navigation is fully operable ' 
.const [40] = Utf8 '[Startup] NotifyNavStateOfOperationCommand#updateNavstateOfOperation() - navigation is fully operable ' 
.const [41] = Class [88] 
.const [42] = NameAndType [89] [90] 
.const [43] = Utf8 de/audi/tghu/navi/app/command/NotifyNavStateOfOperationCommand 
.const [44] = Utf8 de/audi/tghu/navi/app/command/NavCommand 
.const [45] = Utf8 de/audi/atip/log/LogChannel 
.const [46] = Utf8 org/dsi/ifc/navigation/DSINavigation 
.const [47] = Utf8 de/audi/tghu/navi/app/NavigationEnv 
.const [48] = Utf8 de/audi/tghu/navi/app/util/Util 
.const [49] = Utf8 de/audi/tghu/navi/app/Navigation 
.const [50] = Utf8 de/audi/tghu/navi/app/OperationManager 
.const [51] = Utf8 de/audi/tghu/command/ICommandList 
.const [52] = Class [91] 
.const [53] = NameAndType [92] [93] 
.const [54] = Class [94] 
.const [55] = NameAndType [95] [96] 
.const [56] = Class [97] 
.const [57] = NameAndType [98] [99] 
.const [58] = Class [100] 
.const [59] = NameAndType [101] [102] 
.const [60] = Class [103] 
.const [61] = NameAndType [104] [105] 
.const [62] = Class [106] 
.const [63] = NameAndType [107] [108] 
.const [64] = Class [109] 
.const [65] = NameAndType [110] [111] 
.const [66] = Class [112] 
.const [67] = NameAndType [113] [114] 
.const [68] = Class [115] 
.const [69] = NameAndType [116] [117] 
.const [70] = Class [118] 
.const [71] = NameAndType [119] [120] 
.const [72] = Class [121] 
.const [73] = NameAndType [122] [123] 
.const [74] = Class [124] 
.const [75] = NameAndType [125] [126] 
.const [76] = Class [127] 
.const [77] = NameAndType [128] [129] 
.const [78] = Class [130] 
.const [79] = NameAndType [131] [132] 
.const [80] = Class [133] 
.const [81] = NameAndType [134] [135] 
.const [82] = Class [136] 
.const [83] = NameAndType [137] [138] 
.const [84] = Class [139] 
.const [85] = NameAndType [140] [141] 
.const [86] = Class [142] 
.const [87] = NameAndType [143] [144] 
.const [88] = Utf8 de/audi/tghu/navi/app/util/Util 
.const [89] = Utf8 logStartupEvent 
.const [90] = Utf8 (Lde/audi/atip/base/IFrameworkAccess;Ljava/lang/String;)V 
.const [91] = Utf8 de/audi/tghu/navi/app/command/NotifyNavStateOfOperationCommand 
.const [92] = Utf8 waitForFullyOperable 
.const [93] = Utf8 Z 
.const [94] = Utf8 de/audi/tghu/navi/app/command/NotifyNavStateOfOperationCommand 
.const [95] = Utf8 logger 
.const [96] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [97] = Utf8 de/audi/atip/log/LogChannel 
.const [98] = Utf8 log 
.const [99] = Utf8 (ILjava/lang/String;)Z 
.const [100] = Utf8 de/audi/tghu/navi/app/command/NotifyNavStateOfOperationCommand 
.const [101] = Utf8 getDSINavigation 
.const [102] = Utf8 ()Lorg/dsi/ifc/navigation/DSINavigation; 
.const [103] = Utf8 de/audi/tghu/navi/app/command/NotifyNavStateOfOperationCommand 
.const [104] = Utf8 getDispatcher 
.const [105] = Utf8 ()Lde/audi/tghu/navi/app/dsi/DSINavigationDispatcher; 
.const [106] = Utf8 de/audi/atip/log/LogChannel 
.const [107] = Utf8 log 
.const [108] = Utf8 (ILjava/lang/String;J)Z 
.const [109] = Utf8 de/audi/tghu/navi/app/command/NotifyNavStateOfOperationCommand 
.const [110] = Utf8 env 
.const [111] = Utf8 Lde/audi/tghu/navi/app/NavigationEnv; 
.const [112] = Utf8 de/audi/tghu/navi/app/NavigationEnv 
.const [113] = Utf8 getFramework 
.const [114] = Utf8 ()Lde/audi/atip/base/IFrameworkAccess; 
.const [115] = Utf8 de/audi/tghu/navi/app/command/NotifyNavStateOfOperationCommand 
.const [116] = Utf8 navigation 
.const [117] = Utf8 Lde/audi/tghu/navi/app/Navigation; 
.const [118] = Utf8 de/audi/tghu/navi/app/Navigation 
.const [119] = Utf8 getOperationManager 
.const [120] = Utf8 ()Lde/audi/tghu/navi/app/OperationManager; 
.const [121] = Utf8 de/audi/tghu/navi/app/OperationManager 
.const [122] = Utf8 taskCompleted 
.const [123] = Utf8 (I)V 
.const [124] = Utf8 de/audi/tghu/navi/app/command/NotifyNavStateOfOperationCommand 
.const [125] = Utf8 getCommandList 
.const [126] = Utf8 ()Lde/audi/tghu/command/ICommandList; 
.const [127] = Utf8 de/audi/tghu/navi/app/command/NavCommand 
.const [128] = Utf8 <init> 
.const [129] = Utf8 ()V 
.const [130] = Utf8 de/audi/tghu/navi/app/command/NavCommand 
.const [131] = Utf8 getTimeout 
.const [132] = Utf8 ()J 
.const [133] = Utf8 de/audi/tghu/navi/app/command/NavCommand 
.const [134] = Utf8 updateNavstateOfOperation 
.const [135] = Utf8 (I)V 
.const [136] = Utf8 de/audi/tghu/navi/app/command/NotifyNavStateOfOperationCommand 
.const [137] = Utf8 waitForFullyOperable 
.const [138] = Utf8 Z 
.const [139] = Utf8 org/dsi/ifc/navigation/DSINavigation 
.const [140] = Utf8 setNotification 
.const [141] = Utf8 ([ILorg/dsi/ifc/base/DSIListener;)V 
.const [142] = Utf8 de/audi/tghu/command/ICommandList 
.const [143] = Utf8 commandFinished 
.const [144] = Utf8 ()V 
.const [145] = Utf8 de/audi/tghu/navi/app/command/NotifyNavStateOfOperationCommand 
.const [146] = Class [145] 
.const [147] = Utf8 de/audi/tghu/navi/app/command/NavCommand 
.const [148] = Class [147] 
.const [149] = Utf8 waitForFullyOperable 
.const [150] = Utf8 Z 
.const [151] = Utf8 Code 
.const [152] = Utf8 <init> 
.const [153] = Utf8 (Z)V 
.const [154] = Utf8 getTimeout 
.const [155] = Utf8 ()J 
.const [156] = Utf8 execute 
.const [157] = Utf8 ()V 
.const [158] = Utf8 updateNavstateOfOperation 
.const [159] = Utf8 (I)V 
.end class 
