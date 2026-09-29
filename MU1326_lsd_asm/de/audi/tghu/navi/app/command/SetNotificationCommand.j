.version 50 0 
.class public super [76] 
.super [78] 
.field private [79] [80] 

.method public [82] : [83] 
    .attribute [81] .code stack 2 locals 0 
L0:     aload_0 
L1:     invokespecial [15] 
L4:     aload_0 
L5:     aload_1 
L6:     putfield [16] 
L9:     return 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method public [84] : [85] 
    .attribute [81] .code stack 5 locals 0 
L0:     aload_0 
L1:     getfield [9] 
L4:     ifnull L50 
L7:     aload_0 
L8:     getfield [9] 
L11:    arraylength 
L12:    ifle L50 
L15:    aload_0 
L16:    getfield [10] 
L19:    ldc [2] 
L21:    ldc [3] 
L23:    aload_0 
L24:    getfield [9] 
L27:    arraylength 
L28:    i2l 
L29:    invokevirtual [11] 
L32:    pop 
L33:    aload_0 
L34:    invokevirtual [12] 
L37:    aload_0 
L38:    getfield [9] 
L41:    aload_0 
L42:    invokevirtual [13] 
L45:    invokeinterface [17] 0 
L50:    aload_0 
L51:    invokevirtual [14] 
L54:    invokeinterface [18] 0 
L59:    return 
L60:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Int -2137614336 
.const [3] = String [19] 
.const [4] = Class [20] 
.const [5] = Class [21] 
.const [6] = Class [22] 
.const [7] = Class [23] 
.const [8] = Class [24] 
.const [9] = Field [25] [26] 
.const [10] = Field [27] [28] 
.const [11] = Method [29] [30] 
.const [12] = Method [31] [32] 
.const [13] = Method [33] [34] 
.const [14] = Method [35] [36] 
.const [15] = Method [37] [38] 
.const [16] = Field [39] [40] 
.const [17] = InterfaceMethod [41] [42] 
.const [18] = InterfaceMethod [43] [44] 
.const [19] = Utf8 'NotifyRestCommand#execute() - calling setNotification( %1 )' 
.const [20] = Utf8 de/audi/tghu/navi/app/command/SetNotificationCommand 
.const [21] = Utf8 de/audi/tghu/navi/app/command/NavCommand 
.const [22] = Utf8 de/audi/atip/log/LogChannel 
.const [23] = Utf8 org/dsi/ifc/navigation/DSINavigation 
.const [24] = Utf8 de/audi/tghu/command/ICommandList 
.const [25] = Class [45] 
.const [26] = NameAndType [46] [47] 
.const [27] = Class [48] 
.const [28] = NameAndType [49] [50] 
.const [29] = Class [51] 
.const [30] = NameAndType [52] [53] 
.const [31] = Class [54] 
.const [32] = NameAndType [55] [56] 
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
.const [45] = Utf8 de/audi/tghu/navi/app/command/SetNotificationCommand 
.const [46] = Utf8 attributes 
.const [47] = Utf8 [I 
.const [48] = Utf8 de/audi/tghu/navi/app/command/SetNotificationCommand 
.const [49] = Utf8 logger 
.const [50] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [51] = Utf8 de/audi/atip/log/LogChannel 
.const [52] = Utf8 log 
.const [53] = Utf8 (ILjava/lang/String;J)Z 
.const [54] = Utf8 de/audi/tghu/navi/app/command/SetNotificationCommand 
.const [55] = Utf8 getDSINavigation 
.const [56] = Utf8 ()Lorg/dsi/ifc/navigation/DSINavigation; 
.const [57] = Utf8 de/audi/tghu/navi/app/command/SetNotificationCommand 
.const [58] = Utf8 getDispatcher 
.const [59] = Utf8 ()Lde/audi/tghu/navi/app/dsi/DSINavigationDispatcher; 
.const [60] = Utf8 de/audi/tghu/navi/app/command/SetNotificationCommand 
.const [61] = Utf8 getCommandList 
.const [62] = Utf8 ()Lde/audi/tghu/command/ICommandList; 
.const [63] = Utf8 de/audi/tghu/navi/app/command/NavCommand 
.const [64] = Utf8 <init> 
.const [65] = Utf8 ()V 
.const [66] = Utf8 de/audi/tghu/navi/app/command/SetNotificationCommand 
.const [67] = Utf8 attributes 
.const [68] = Utf8 [I 
.const [69] = Utf8 org/dsi/ifc/navigation/DSINavigation 
.const [70] = Utf8 setNotification 
.const [71] = Utf8 ([ILorg/dsi/ifc/base/DSIListener;)V 
.const [72] = Utf8 de/audi/tghu/command/ICommandList 
.const [73] = Utf8 commandFinished 
.const [74] = Utf8 ()V 
.const [75] = Utf8 de/audi/tghu/navi/app/command/SetNotificationCommand 
.const [76] = Class [75] 
.const [77] = Utf8 de/audi/tghu/navi/app/command/NavCommand 
.const [78] = Class [77] 
.const [79] = Utf8 attributes 
.const [80] = Utf8 [I 
.const [81] = Utf8 Code 
.const [82] = Utf8 <init> 
.const [83] = Utf8 ([I)V 
.const [84] = Utf8 execute 
.const [85] = Utf8 ()V 
.end class 
