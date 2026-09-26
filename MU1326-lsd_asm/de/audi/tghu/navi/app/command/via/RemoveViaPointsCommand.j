.version 50 0 
.class public super [122] 
.super [124] 

.method public annotation [126] : [127] 
    .attribute [125] .code stack 1 locals 0 
L0:     aload_0 
L1:     invokespecial [25] 
L4:     return 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [128] : [129] 
    .attribute [125] .code stack 4 locals 3 
L0:     aload_0 
L1:     getfield [18] 
L4:     ldc [2] 
L6:     ldc [3] 
L8:     invokevirtual [19] 
L11:    pop 
L12:    aload_0 
L13:    getfield [20] 
L16:    invokevirtual [21] 
L19:    invokeinterface [27] 0 
L24:    astore_1 
L25:    aload_1 
L26:    ifnull L92 
L29:    aload_1 
L30:    invokestatic [4] 
L33:    ifeq L92 
L36:    aload_0 
L37:    getfield [18] 
L40:    ldc [2] 
L42:    ldc [5] 
L44:    invokevirtual [19] 
L47:    pop 
L48:    aload_1 
L49:    invokestatic [6] 
L52:    astore_2 
L53:    aload_0 
L54:    getfield [20] 
L57:    invokevirtual [22] 
L60:    invokeinterface [28] 0 
L65:    astore_3 
L66:    aload_3 
L67:    new [29] 
L70:    dup 
L71:    aload_2 
L72:    invokespecial [26] 
L75:    invokevirtual [23] 
L78:    pop 
L79:    aload_0 
L80:    invokevirtual [24] 
L83:    aload_3 
L84:    invokeinterface [30] 0 
L89:    goto L113 
L92:    aload_0 
L93:    getfield [18] 
L96:    ldc [2] 
L98:    ldc [8] 
L100:   invokevirtual [19] 
L103:   pop 
L104:   aload_0 
L105:   invokevirtual [24] 
L108:   invokeinterface [31] 0 
L113:   return 
L114:   nop 
L115:   nop 
L116:   
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Int -2137614336 
.const [3] = String [32] 
.const [4] = Method [33] [34] 
.const [5] = String [35] 
.const [6] = Method [36] [37] 
.const [7] = Class [38] 
.const [8] = String [39] 
.const [9] = Class [40] 
.const [10] = Class [41] 
.const [11] = Class [42] 
.const [12] = Class [43] 
.const [13] = Class [44] 
.const [14] = Class [45] 
.const [15] = Class [46] 
.const [16] = Class [47] 
.const [17] = Class [48] 
.const [18] = Field [49] [50] 
.const [19] = Method [51] [52] 
.const [20] = Field [53] [54] 
.const [21] = Method [55] [56] 
.const [22] = Method [57] [58] 
.const [23] = Method [59] [60] 
.const [24] = Method [61] [62] 
.const [25] = Method [63] [64] 
.const [26] = Method [65] [66] 
.const [27] = InterfaceMethod [67] [68] 
.const [28] = InterfaceMethod [69] [70] 
.const [29] = Class [71] 
.const [30] = InterfaceMethod [72] [73] 
.const [31] = InterfaceMethod [74] [75] 
.const [32] = Utf8 'RemoveViaPointsCommand#execute()' 
.const [33] = Class [76] 
.const [34] = NameAndType [77] [78] 
.const [35] = Utf8 'RemoveViaPointsCommand#execute() - found via points, stripping them from route' 
.const [36] = Class [79] 
.const [37] = NameAndType [80] [81] 
.const [38] = Utf8 de/audi/tghu/navi/app/command/RmMakeRoutePersistentCommand 
.const [39] = Utf8 'RemoveViaPointsCommand#execute() - no via points found, do nothing' 
.const [40] = Utf8 de/audi/tghu/navi/app/command/via/RemoveViaPointsCommand 
.const [41] = Utf8 de/audi/tghu/navi/app/command/NavCommand 
.const [42] = Utf8 de/audi/atip/log/LogChannel 
.const [43] = Utf8 de/audi/tghu/navi/app/Navigation 
.const [44] = Utf8 de/audi/tghu/navi/app/routeguidance/IRouteManager 
.const [45] = Utf8 de/audi/tghu/navi/app/hierarchiclist/via/ViaRouteUtil 
.const [46] = Utf8 de/audi/tghu/command/ICommandListFactory 
.const [47] = Utf8 de/audi/tghu/command/CommandList 
.const [48] = Utf8 de/audi/tghu/command/ICommandList 
.const [49] = Class [82] 
.const [50] = NameAndType [83] [84] 
.const [51] = Class [85] 
.const [52] = NameAndType [86] [87] 
.const [53] = Class [88] 
.const [54] = NameAndType [89] [90] 
.const [55] = Class [91] 
.const [56] = NameAndType [92] [93] 
.const [57] = Class [94] 
.const [58] = NameAndType [95] [96] 
.const [59] = Class [97] 
.const [60] = NameAndType [98] [99] 
.const [61] = Class [100] 
.const [62] = NameAndType [101] [102] 
.const [63] = Class [103] 
.const [64] = NameAndType [104] [105] 
.const [65] = Class [106] 
.const [66] = NameAndType [107] [108] 
.const [67] = Class [109] 
.const [68] = NameAndType [110] [111] 
.const [69] = Class [112] 
.const [70] = NameAndType [113] [114] 
.const [71] = Utf8 de/audi/tghu/navi/app/command/RmMakeRoutePersistentCommand 
.const [72] = Class [115] 
.const [73] = NameAndType [116] [117] 
.const [74] = Class [118] 
.const [75] = NameAndType [119] [120] 
.const [76] = Utf8 de/audi/tghu/navi/app/hierarchiclist/via/ViaRouteUtil 
.const [77] = Utf8 isViaRoute 
.const [78] = Utf8 (Lorg/dsi/ifc/navigation/Route;)Z 
.const [79] = Utf8 de/audi/tghu/navi/app/hierarchiclist/via/ViaRouteUtil 
.const [80] = Utf8 filterViaFromRoute 
.const [81] = Utf8 (Lorg/dsi/ifc/navigation/Route;)Lorg/dsi/ifc/navigation/Route; 
.const [82] = Utf8 de/audi/tghu/navi/app/command/via/RemoveViaPointsCommand 
.const [83] = Utf8 logger 
.const [84] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [85] = Utf8 de/audi/atip/log/LogChannel 
.const [86] = Utf8 log 
.const [87] = Utf8 (ILjava/lang/String;)Z 
.const [88] = Utf8 de/audi/tghu/navi/app/command/via/RemoveViaPointsCommand 
.const [89] = Utf8 navigation 
.const [90] = Utf8 Lde/audi/tghu/navi/app/Navigation; 
.const [91] = Utf8 de/audi/tghu/navi/app/Navigation 
.const [92] = Utf8 getRouteManager 
.const [93] = Utf8 ()Lde/audi/tghu/navi/app/routeguidance/IRouteManager; 
.const [94] = Utf8 de/audi/tghu/navi/app/Navigation 
.const [95] = Utf8 getCommandListFactory 
.const [96] = Utf8 ()Lde/audi/tghu/command/ICommandListFactory; 
.const [97] = Utf8 de/audi/tghu/command/CommandList 
.const [98] = Utf8 add 
.const [99] = Utf8 (Lde/audi/tghu/command/Command;)Lde/audi/tghu/command/ICommandList; 
.const [100] = Utf8 de/audi/tghu/navi/app/command/via/RemoveViaPointsCommand 
.const [101] = Utf8 getCommandList 
.const [102] = Utf8 ()Lde/audi/tghu/command/ICommandList; 
.const [103] = Utf8 de/audi/tghu/navi/app/command/NavCommand 
.const [104] = Utf8 <init> 
.const [105] = Utf8 ()V 
.const [106] = Utf8 de/audi/tghu/navi/app/command/RmMakeRoutePersistentCommand 
.const [107] = Utf8 <init> 
.const [108] = Utf8 (Lorg/dsi/ifc/navigation/Route;)V 
.const [109] = Utf8 de/audi/tghu/navi/app/routeguidance/IRouteManager 
.const [110] = Utf8 getRoute 
.const [111] = Utf8 ()Lorg/dsi/ifc/navigation/Route; 
.const [112] = Utf8 de/audi/tghu/command/ICommandListFactory 
.const [113] = Utf8 createCommandList 
.const [114] = Utf8 ()Lde/audi/tghu/command/CommandList; 
.const [115] = Utf8 de/audi/tghu/command/ICommandList 
.const [116] = Utf8 commandFinishedWithPostSequence 
.const [117] = Utf8 (Lde/audi/tghu/command/CommandList;)V 
.const [118] = Utf8 de/audi/tghu/command/ICommandList 
.const [119] = Utf8 commandFinished 
.const [120] = Utf8 ()V 
.const [121] = Utf8 de/audi/tghu/navi/app/command/via/RemoveViaPointsCommand 
.const [122] = Class [121] 
.const [123] = Utf8 de/audi/tghu/navi/app/command/NavCommand 
.const [124] = Class [123] 
.const [125] = Utf8 Code 
.const [126] = Utf8 <init> 
.const [127] = Utf8 ()V 
.const [128] = Utf8 execute 
.const [129] = Utf8 ()V 
.end class 
