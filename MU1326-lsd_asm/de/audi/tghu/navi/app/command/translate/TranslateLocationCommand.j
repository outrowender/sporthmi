.version 50 0 
.class public super abstract [111] 
.super [113] 

.method public [115] : [116] 
    .attribute [114] .code stack 2 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     ifnonnull L9 
L5:     aconst_null 
L6:     goto L13 
L9:     aload_1 
L10:    invokestatic [2] 
L13:    invokespecial [18] 
L16:    return 
L17:    nop 
L18:    nop 
L19:    nop 
L20:    
    .end code 
.end method 

.method public abstract [117] : [118] 
    .attribute [114] .code stack 0 locals 0 
L0:     
    .end code 
.end method 

.method public [119] : [120] 
    .attribute [114] .code stack 3 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     invokevirtual [14] 
L5:     ifeq L28 
L8:     aload_0 
L9:     invokevirtual [15] 
L12:    aload_0 
L13:    aload_0 
L14:    invokespecial [19] 
L17:    invokevirtual [16] 
L20:    invokeinterface [23] 0 
L25:    goto L39 
L28:    aload_0 
L29:    invokevirtual [15] 
L32:    ldc [3] 
L34:    invokeinterface [24] 0 
L39:    return 
L40:    
    .end code 
.end method 

.method private [121] : [122] 
    .attribute [114] .code stack 1 locals 0 
L0:     aload_0 
L1:     invokevirtual [17] 
L4:     invokestatic [4] 
L7:     areturn 
L8:     
    .end code 
.end method 

.method protected static [123] : [124] 
    .attribute [114] .code stack 9 locals 1 
L0:     new [25] 
L3:     dup 
L4:     invokespecial [20] 
L7:     astore_1 
L8:     aload_1 
L9:     new [26] 
L12:    dup 
L13:    aload_0 
L14:    iconst_1 
L15:    anewarray [7] 
L18:    dup 
L19:    iconst_0 
L20:    new [27] 
L23:    dup 
L24:    invokespecial [21] 
L27:    aastore 
L28:    iconst_1 
L29:    invokespecial [22] 
L32:    iconst_0 
L33:    invokestatic [8] 
L36:    aload_1 
L37:    areturn 
L38:    nop 
L39:    nop 
L40:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Method [28] [29] 
.const [3] = String [30] 
.const [4] = Method [31] [32] 
.const [5] = Class [33] 
.const [6] = Class [34] 
.const [7] = Class [35] 
.const [8] = Method [36] [37] 
.const [9] = Class [38] 
.const [10] = Class [39] 
.const [11] = Class [40] 
.const [12] = Class [41] 
.const [13] = Class [42] 
.const [14] = Method [43] [44] 
.const [15] = Method [45] [46] 
.const [16] = Method [47] [48] 
.const [17] = Method [49] [50] 
.const [18] = Method [51] [52] 
.const [19] = Method [53] [54] 
.const [20] = Method [55] [56] 
.const [21] = Method [57] [58] 
.const [22] = Method [59] [60] 
.const [23] = InterfaceMethod [61] [62] 
.const [24] = InterfaceMethod [63] [64] 
.const [25] = Class [65] 
.const [26] = Class [66] 
.const [27] = Class [67] 
.const [28] = Class [68] 
.const [29] = NameAndType [69] [70] 
.const [30] = Utf8 'translation not successful' 
.const [31] = Class [71] 
.const [32] = NameAndType [72] [73] 
.const [33] = Utf8 org/dsi/ifc/navigation/Route 
.const [34] = Utf8 org/dsi/ifc/navigation/RouteDestination 
.const [35] = Utf8 org/dsi/ifc/navigation/RouteOptions 
.const [36] = Class [74] 
.const [37] = NameAndType [75] [76] 
.const [38] = Utf8 de/audi/tghu/navi/app/command/translate/TranslateLocationCommand 
.const [39] = Utf8 de/audi/tghu/navi/app/command/translate/TranslateRouteCommand 
.const [40] = Utf8 de/audi/tghu/command/ICommandList 
.const [41] = Utf8 de/audi/tghu/navi/app/util/RouteUtil 
.const [42] = Utf8 org/dsi/ifc/navigation/util/RouteHelper 
.const [43] = Class [77] 
.const [44] = NameAndType [78] [79] 
.const [45] = Class [80] 
.const [46] = NameAndType [81] [82] 
.const [47] = Class [83] 
.const [48] = NameAndType [84] [85] 
.const [49] = Class [86] 
.const [50] = NameAndType [87] [88] 
.const [51] = Class [89] 
.const [52] = NameAndType [90] [91] 
.const [53] = Class [92] 
.const [54] = NameAndType [93] [94] 
.const [55] = Class [95] 
.const [56] = NameAndType [96] [97] 
.const [57] = Class [98] 
.const [58] = NameAndType [99] [100] 
.const [59] = Class [101] 
.const [60] = NameAndType [102] [103] 
.const [61] = Class [104] 
.const [62] = NameAndType [105] [106] 
.const [63] = Class [107] 
.const [64] = NameAndType [108] [109] 
.const [65] = Utf8 org/dsi/ifc/navigation/Route 
.const [66] = Utf8 org/dsi/ifc/navigation/RouteDestination 
.const [67] = Utf8 org/dsi/ifc/navigation/RouteOptions 
.const [68] = Utf8 de/audi/tghu/navi/app/command/translate/TranslateLocationCommand 
.const [69] = Utf8 constructRouteToTranslate 
.const [70] = Utf8 (Lorg/dsi/ifc/global/NavLocation;)Lorg/dsi/ifc/navigation/Route; 
.const [71] = Utf8 de/audi/tghu/navi/app/util/RouteUtil 
.const [72] = Utf8 getFinalDestination 
.const [73] = Utf8 (Lorg/dsi/ifc/navigation/Route;)Lorg/dsi/ifc/global/NavLocation; 
.const [74] = Utf8 org/dsi/ifc/navigation/util/RouteHelper 
.const [75] = Utf8 addDestinationAtPosition 
.const [76] = Utf8 (Lorg/dsi/ifc/navigation/Route;Lorg/dsi/ifc/navigation/RouteDestination;I)V 
.const [77] = Utf8 de/audi/tghu/navi/app/command/translate/TranslateLocationCommand 
.const [78] = Utf8 handleTranslatedRoute 
.const [79] = Utf8 (Lorg/dsi/ifc/navigation/Route;)Z 
.const [80] = Utf8 de/audi/tghu/navi/app/command/translate/TranslateLocationCommand 
.const [81] = Utf8 getCommandList 
.const [82] = Utf8 ()Lde/audi/tghu/command/ICommandList; 
.const [83] = Utf8 de/audi/tghu/navi/app/command/translate/TranslateLocationCommand 
.const [84] = Utf8 handleTranslatedLocation 
.const [85] = Utf8 (Lorg/dsi/ifc/global/NavLocation;)Lde/audi/tghu/command/CommandList; 
.const [86] = Utf8 de/audi/tghu/navi/app/command/translate/TranslateLocationCommand 
.const [87] = Utf8 getTranslatedRoute 
.const [88] = Utf8 ()Lorg/dsi/ifc/navigation/Route; 
.const [89] = Utf8 de/audi/tghu/navi/app/command/translate/TranslateRouteCommand 
.const [90] = Utf8 <init> 
.const [91] = Utf8 (Lorg/dsi/ifc/navigation/Route;)V 
.const [92] = Utf8 de/audi/tghu/navi/app/command/translate/TranslateLocationCommand 
.const [93] = Utf8 getTranslatedLocation 
.const [94] = Utf8 ()Lorg/dsi/ifc/global/NavLocation; 
.const [95] = Utf8 org/dsi/ifc/navigation/Route 
.const [96] = Utf8 <init> 
.const [97] = Utf8 ()V 
.const [98] = Utf8 org/dsi/ifc/navigation/RouteOptions 
.const [99] = Utf8 <init> 
.const [100] = Utf8 ()V 
.const [101] = Utf8 org/dsi/ifc/navigation/RouteDestination 
.const [102] = Utf8 <init> 
.const [103] = Utf8 (Lorg/dsi/ifc/global/NavLocation;[Lorg/dsi/ifc/navigation/RouteOptions;I)V 
.const [104] = Utf8 de/audi/tghu/command/ICommandList 
.const [105] = Utf8 commandFinishedWithPostSequence 
.const [106] = Utf8 (Lde/audi/tghu/command/CommandList;)V 
.const [107] = Utf8 de/audi/tghu/command/ICommandList 
.const [108] = Utf8 commandAborted 
.const [109] = Utf8 (Ljava/lang/String;)V 
.const [110] = Utf8 de/audi/tghu/navi/app/command/translate/TranslateLocationCommand 
.const [111] = Class [110] 
.const [112] = Utf8 de/audi/tghu/navi/app/command/translate/TranslateRouteCommand 
.const [113] = Class [112] 
.const [114] = Utf8 Code 
.const [115] = Utf8 <init> 
.const [116] = Utf8 (Lorg/dsi/ifc/global/NavLocation;)V 
.const [117] = Utf8 handleTranslatedLocation 
.const [118] = Utf8 (Lorg/dsi/ifc/global/NavLocation;)Lde/audi/tghu/command/CommandList; 
.const [119] = Utf8 translateRouteResult 
.const [120] = Utf8 (Lorg/dsi/ifc/navigation/Route;)V 
.const [121] = Utf8 getTranslatedLocation 
.const [122] = Utf8 ()Lorg/dsi/ifc/global/NavLocation; 
.const [123] = Utf8 constructRouteToTranslate 
.const [124] = Utf8 (Lorg/dsi/ifc/global/NavLocation;)Lorg/dsi/ifc/navigation/Route; 
.end class 
