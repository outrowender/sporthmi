.version 50 0 
.class public super [82] 
.super [84] 

.method public annotation [86] : [87] 
    .attribute [85] .code stack 1 locals 0 
L0:     aload_0 
L1:     invokespecial [18] 
L4:     return 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [88] : [89] 
    .attribute [85] .code stack 5 locals 1 
L0:     aload_0 
L1:     getfield [12] 
L4:     invokevirtual [13] 
L7:     astore_1 
L8:     aload_0 
L9:     getfield [14] 
L12:    ldc [2] 
L14:    ldc [3] 
L16:    aload_0 
L17:    getfield [15] 
L20:    aload_1 
L21:    invokestatic [4] 
L24:    invokevirtual [16] 
L27:    aload_0 
L28:    invokevirtual [17] 
L31:    new [20] 
L34:    dup 
L35:    aload_1 
L36:    invokespecial [19] 
L39:    invokeinterface [21] 0 
L44:    return 
L45:    nop 
L46:    nop 
L47:    nop 
L48:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Int -2137614336 
.const [3] = String [22] 
.const [4] = Method [23] [24] 
.const [5] = Class [25] 
.const [6] = Class [26] 
.const [7] = Class [27] 
.const [8] = Class [28] 
.const [9] = Class [29] 
.const [10] = Class [30] 
.const [11] = Class [31] 
.const [12] = Field [32] [33] 
.const [13] = Method [34] [35] 
.const [14] = Field [36] [37] 
.const [15] = Field [38] [39] 
.const [16] = Method [40] [41] 
.const [17] = Method [42] [43] 
.const [18] = Method [44] [45] 
.const [19] = Method [46] [47] 
.const [20] = Class [48] 
.const [21] = InterfaceMethod [49] [50] 
.const [22] = Utf8 '%1#execute() - calling LISetHistoryCommand with currentLD %2' 
.const [23] = Class [51] 
.const [24] = NameAndType [52] [53] 
.const [25] = Utf8 de/audi/tghu/navi/app/command/LISetHistoryCommand 
.const [26] = Utf8 de/audi/tghu/navi/app/addressinput/commands/SetHistoryContextWithCurrentLDCommand 
.const [27] = Utf8 de/audi/tghu/navi/app/command/NavCommand 
.const [28] = Utf8 de/audi/tghu/navi/app/command/DSIResponseContainer 
.const [29] = Utf8 de/audi/tghu/navi/app/util/LocationFormatter 
.const [30] = Utf8 de/audi/atip/log/LogChannel 
.const [31] = Utf8 de/audi/tghu/command/ICommandList 
.const [32] = Class [54] 
.const [33] = NameAndType [55] [56] 
.const [34] = Class [57] 
.const [35] = NameAndType [58] [59] 
.const [36] = Class [60] 
.const [37] = NameAndType [61] [62] 
.const [38] = Class [63] 
.const [39] = NameAndType [64] [65] 
.const [40] = Class [66] 
.const [41] = NameAndType [67] [68] 
.const [42] = Class [69] 
.const [43] = NameAndType [70] [71] 
.const [44] = Class [72] 
.const [45] = NameAndType [73] [74] 
.const [46] = Class [75] 
.const [47] = NameAndType [76] [77] 
.const [48] = Utf8 de/audi/tghu/navi/app/command/LISetHistoryCommand 
.const [49] = Class [78] 
.const [50] = NameAndType [79] [80] 
.const [51] = Utf8 de/audi/tghu/navi/app/util/LocationFormatter 
.const [52] = Utf8 formatLocationShort 
.const [53] = Utf8 (Lorg/dsi/ifc/global/NavLocation;)Ljava/lang/String; 
.const [54] = Utf8 de/audi/tghu/navi/app/addressinput/commands/SetHistoryContextWithCurrentLDCommand 
.const [55] = Utf8 dsiResponseContainer 
.const [56] = Utf8 Lde/audi/tghu/navi/app/command/DSIResponseContainer; 
.const [57] = Utf8 de/audi/tghu/navi/app/command/DSIResponseContainer 
.const [58] = Utf8 getLiCurrentLD 
.const [59] = Utf8 ()Lorg/dsi/ifc/global/NavLocation; 
.const [60] = Utf8 de/audi/tghu/navi/app/addressinput/commands/SetHistoryContextWithCurrentLDCommand 
.const [61] = Utf8 logger 
.const [62] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [63] = Utf8 de/audi/tghu/navi/app/addressinput/commands/SetHistoryContextWithCurrentLDCommand 
.const [64] = Utf8 CLASS_NAME 
.const [65] = Utf8 Ljava/lang/String; 
.const [66] = Utf8 de/audi/atip/log/LogChannel 
.const [67] = Utf8 log 
.const [68] = Utf8 (ILjava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V 
.const [69] = Utf8 de/audi/tghu/navi/app/addressinput/commands/SetHistoryContextWithCurrentLDCommand 
.const [70] = Utf8 getCommandList 
.const [71] = Utf8 ()Lde/audi/tghu/command/ICommandList; 
.const [72] = Utf8 de/audi/tghu/navi/app/command/NavCommand 
.const [73] = Utf8 <init> 
.const [74] = Utf8 ()V 
.const [75] = Utf8 de/audi/tghu/navi/app/command/LISetHistoryCommand 
.const [76] = Utf8 <init> 
.const [77] = Utf8 (Lorg/dsi/ifc/global/NavLocation;)V 
.const [78] = Utf8 de/audi/tghu/command/ICommandList 
.const [79] = Utf8 commandFinishedWithPostCommand 
.const [80] = Utf8 (Lde/audi/tghu/command/Command;)V 
.const [81] = Utf8 de/audi/tghu/navi/app/addressinput/commands/SetHistoryContextWithCurrentLDCommand 
.const [82] = Class [81] 
.const [83] = Utf8 de/audi/tghu/navi/app/command/NavCommand 
.const [84] = Class [83] 
.const [85] = Utf8 Code 
.const [86] = Utf8 <init> 
.const [87] = Utf8 ()V 
.const [88] = Utf8 execute 
.const [89] = Utf8 ()V 
.end class 
