.version 50 0 
.class public super [87] 
.super [89] 
.field private [90] [91] 

.method public [93] : [94] 
    .attribute [92] .code stack 2 locals 0 
L0:     aload_0 
L1:     invokespecial [18] 
L4:     aload_0 
L5:     iload_1 
L6:     putfield [19] 
L9:     return 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method public [95] : [96] 
    .attribute [92] .code stack 5 locals 3 
L0:     aload_0 
L1:     getfield [13] 
L4:     aload_0 
L5:     getfield [12] 
L8:     invokevirtual [14] 
L11:    astore_1 
L12:    aload_1 
L13:    ifnull L60 
L16:    aload_0 
L17:    getfield [15] 
L20:    ldc [2] 
L22:    ldc [3] 
L24:    aload_0 
L25:    getfield [12] 
L28:    i2l 
L29:    invokevirtual [16] 
L32:    pop 
L33:    aload_1 
L34:    invokeinterface [20] 0 
L39:    istore_2 
L40:    iload_2 
L41:    ifne L48 
L44:    iconst_1 
L45:    goto L49 
L48:    iconst_0 
L49:    istore_3 
L50:    aload_1 
L51:    iload_3 
L52:    invokeinterface [21] 0 
L57:    goto L77 
L60:    aload_0 
L61:    getfield [15] 
L64:    ldc [4] 
L66:    ldc [5] 
L68:    aload_0 
L69:    getfield [12] 
L72:    i2l 
L73:    invokevirtual [16] 
L76:    pop 
L77:    aload_0 
L78:    invokevirtual [17] 
L81:    invokeinterface [22] 0 
L86:    return 
L87:    nop 
L88:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Int -2137614336 
.const [3] = String [23] 
.const [4] = Int -1601830656 
.const [5] = String [24] 
.const [6] = Class [25] 
.const [7] = Class [26] 
.const [8] = Class [27] 
.const [9] = Class [28] 
.const [10] = Class [29] 
.const [11] = Class [30] 
.const [12] = Field [31] [32] 
.const [13] = Field [33] [34] 
.const [14] = Method [35] [36] 
.const [15] = Field [37] [38] 
.const [16] = Method [39] [40] 
.const [17] = Method [41] [42] 
.const [18] = Method [43] [44] 
.const [19] = Field [45] [46] 
.const [20] = InterfaceMethod [47] [48] 
.const [21] = InterfaceMethod [49] [50] 
.const [22] = InterfaceMethod [51] [52] 
.const [23] = Utf8 'ToggleMediatorCommand#execute() - toggle mediator: %1' 
.const [24] = Utf8 'ToggleMediatorCommand#execute() - failed to resolve modelID: %1' 
.const [25] = Utf8 de/audi/tghu/navi/app/command/ToggleMediatorCommand 
.const [26] = Utf8 de/audi/tghu/navi/app/command/NavCommand 
.const [27] = Utf8 de/audi/tghu/navi/app/NavigationEnv 
.const [28] = Utf8 de/audi/atip/log/LogChannel 
.const [29] = Utf8 de/audi/atip/hmi/modelaccess/ChoiceModelApp 
.const [30] = Utf8 de/audi/tghu/command/ICommandList 
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
.const [47] = Class [77] 
.const [48] = NameAndType [78] [79] 
.const [49] = Class [80] 
.const [50] = NameAndType [81] [82] 
.const [51] = Class [83] 
.const [52] = NameAndType [84] [85] 
.const [53] = Utf8 de/audi/tghu/navi/app/command/ToggleMediatorCommand 
.const [54] = Utf8 modelID 
.const [55] = Utf8 I 
.const [56] = Utf8 de/audi/tghu/navi/app/command/ToggleMediatorCommand 
.const [57] = Utf8 env 
.const [58] = Utf8 Lde/audi/tghu/navi/app/NavigationEnv; 
.const [59] = Utf8 de/audi/tghu/navi/app/NavigationEnv 
.const [60] = Utf8 getChoiceModel 
.const [61] = Utf8 (I)Lde/audi/atip/hmi/modelaccess/ChoiceModelApp; 
.const [62] = Utf8 de/audi/tghu/navi/app/command/ToggleMediatorCommand 
.const [63] = Utf8 logger 
.const [64] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [65] = Utf8 de/audi/atip/log/LogChannel 
.const [66] = Utf8 log 
.const [67] = Utf8 (ILjava/lang/String;J)Z 
.const [68] = Utf8 de/audi/tghu/navi/app/command/ToggleMediatorCommand 
.const [69] = Utf8 getCommandList 
.const [70] = Utf8 ()Lde/audi/tghu/command/ICommandList; 
.const [71] = Utf8 de/audi/tghu/navi/app/command/NavCommand 
.const [72] = Utf8 <init> 
.const [73] = Utf8 ()V 
.const [74] = Utf8 de/audi/tghu/navi/app/command/ToggleMediatorCommand 
.const [75] = Utf8 modelID 
.const [76] = Utf8 I 
.const [77] = Utf8 de/audi/atip/hmi/modelaccess/ChoiceModelApp 
.const [78] = Utf8 getValue 
.const [79] = Utf8 ()I 
.const [80] = Utf8 de/audi/atip/hmi/modelaccess/ChoiceModelApp 
.const [81] = Utf8 setValue 
.const [82] = Utf8 (I)V 
.const [83] = Utf8 de/audi/tghu/command/ICommandList 
.const [84] = Utf8 commandFinished 
.const [85] = Utf8 ()V 
.const [86] = Utf8 de/audi/tghu/navi/app/command/ToggleMediatorCommand 
.const [87] = Class [86] 
.const [88] = Utf8 de/audi/tghu/navi/app/command/NavCommand 
.const [89] = Class [88] 
.const [90] = Utf8 modelID 
.const [91] = Utf8 I 
.const [92] = Utf8 Code 
.const [93] = Utf8 <init> 
.const [94] = Utf8 (I)V 
.const [95] = Utf8 execute 
.const [96] = Utf8 ()V 
.end class 
