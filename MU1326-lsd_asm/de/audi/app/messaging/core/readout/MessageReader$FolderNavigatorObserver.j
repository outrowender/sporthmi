.version 50 0 
.class final super [86] 
.super [88] 
.field private final synthetic [89] [90] 

.method private [92] : [93] 
    .attribute [91] .code stack 2 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     putfield [21] 
L5:     aload_0 
L6:     invokespecial [20] 
L9:     return 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method public [94] : [95] 
    .attribute [91] .code stack 4 locals 1 
L0:     aload_0 
L1:     getfield [14] 
L4:     invokestatic [2] 
L7:     ldc [3] 
L9:     ldc [4] 
L11:    iload_1 
L12:    invokevirtual [15] 
L15:    pop 
L16:    iload_1 
L17:    ifne L54 
L20:    aload_0 
L21:    getfield [14] 
L24:    invokestatic [5] 
L27:    invokevirtual [16] 
L30:    invokevirtual [17] 
L33:    invokevirtual [18] 
L36:    istore_2 
L37:    aload_0 
L38:    getfield [14] 
L41:    iload_2 
L42:    iconst_4 
L43:    if_icmpne L50 
L46:    iconst_1 
L47:    goto L51 
L50:    iconst_0 
L51:    invokestatic [6] 
L54:    return 
L55:    nop 
L56:    
    .end code 
.end method 

.method synthetic [96] : [97] 
    .attribute [91] .code stack 2 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     invokespecial [19] 
L5:     return 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Method [22] [23] 
.const [3] = Int -2137614336 
.const [4] = String [24] 
.const [5] = Method [25] [26] 
.const [6] = Method [27] [28] 
.const [7] = Class [29] 
.const [8] = Class [30] 
.const [9] = Class [31] 
.const [10] = Class [32] 
.const [11] = Class [33] 
.const [12] = Class [34] 
.const [13] = Class [35] 
.const [14] = Field [36] [37] 
.const [15] = Method [38] [39] 
.const [16] = Method [40] [41] 
.const [17] = Method [42] [43] 
.const [18] = Method [44] [45] 
.const [19] = Method [46] [47] 
.const [20] = Method [48] [49] 
.const [21] = Field [50] [51] 
.const [22] = Class [52] 
.const [23] = NameAndType [53] [54] 
.const [24] = Utf8 '[MessageReader#indicateFolderChange] inProgress = %1' 
.const [25] = Class [55] 
.const [26] = NameAndType [56] [57] 
.const [27] = Class [58] 
.const [28] = NameAndType [59] [60] 
.const [29] = Utf8 de/audi/app/messaging/core/readout/MessageReader$FolderNavigatorObserver 
.const [30] = Utf8 de/audi/app/messaging/core/folderbrowsing/IFolderNavigatorObserver$EmptyImplementation 
.const [31] = Utf8 de/audi/app/messaging/core/readout/MessageReader 
.const [32] = Utf8 de/audi/atip/log/LogChannel 
.const [33] = Utf8 de/audi/app/messaging/core/application/AbstractMsgApplication 
.const [34] = Utf8 de/audi/app/messaging/core/folderbrowsing/FolderNavigator 
.const [35] = Utf8 de/audi/app/messaging/core/folderbrowsing/Folder 
.const [36] = Class [61] 
.const [37] = NameAndType [62] [63] 
.const [38] = Class [64] 
.const [39] = NameAndType [65] [66] 
.const [40] = Class [67] 
.const [41] = NameAndType [68] [69] 
.const [42] = Class [70] 
.const [43] = NameAndType [71] [72] 
.const [44] = Class [73] 
.const [45] = NameAndType [74] [75] 
.const [46] = Class [76] 
.const [47] = NameAndType [77] [78] 
.const [48] = Class [79] 
.const [49] = NameAndType [80] [81] 
.const [50] = Class [82] 
.const [51] = NameAndType [83] [84] 
.const [52] = Utf8 de/audi/app/messaging/core/readout/MessageReader 
.const [53] = Utf8 access$4100 
.const [54] = Utf8 (Lde/audi/app/messaging/core/readout/MessageReader;)Lde/audi/atip/log/LogChannel; 
.const [55] = Utf8 de/audi/app/messaging/core/readout/MessageReader 
.const [56] = Utf8 access$4200 
.const [57] = Utf8 (Lde/audi/app/messaging/core/readout/MessageReader;)Lde/audi/app/messaging/core/application/AbstractMsgApplication; 
.const [58] = Utf8 de/audi/app/messaging/core/readout/MessageReader 
.const [59] = Utf8 access$4300 
.const [60] = Utf8 (Lde/audi/app/messaging/core/readout/MessageReader;Z)V 
.const [61] = Utf8 de/audi/app/messaging/core/readout/MessageReader$FolderNavigatorObserver 
.const [62] = Utf8 this$0 
.const [63] = Utf8 Lde/audi/app/messaging/core/readout/MessageReader; 
.const [64] = Utf8 de/audi/atip/log/LogChannel 
.const [65] = Utf8 log 
.const [66] = Utf8 (ILjava/lang/String;Z)Z 
.const [67] = Utf8 de/audi/app/messaging/core/application/AbstractMsgApplication 
.const [68] = Utf8 getFolderNavigator 
.const [69] = Utf8 ()Lde/audi/app/messaging/core/folderbrowsing/FolderNavigator; 
.const [70] = Utf8 de/audi/app/messaging/core/folderbrowsing/FolderNavigator 
.const [71] = Utf8 getCurrentFolder 
.const [72] = Utf8 ()Lde/audi/app/messaging/core/folderbrowsing/Folder; 
.const [73] = Utf8 de/audi/app/messaging/core/folderbrowsing/Folder 
.const [74] = Utf8 getHmiFolderType 
.const [75] = Utf8 ()I 
.const [76] = Utf8 de/audi/app/messaging/core/readout/MessageReader$FolderNavigatorObserver 
.const [77] = Utf8 <init> 
.const [78] = Utf8 (Lde/audi/app/messaging/core/readout/MessageReader;)V 
.const [79] = Utf8 de/audi/app/messaging/core/folderbrowsing/IFolderNavigatorObserver$EmptyImplementation 
.const [80] = Utf8 <init> 
.const [81] = Utf8 ()V 
.const [82] = Utf8 de/audi/app/messaging/core/readout/MessageReader$FolderNavigatorObserver 
.const [83] = Utf8 this$0 
.const [84] = Utf8 Lde/audi/app/messaging/core/readout/MessageReader; 
.const [85] = Utf8 de/audi/app/messaging/core/readout/MessageReader$FolderNavigatorObserver 
.const [86] = Class [85] 
.const [87] = Utf8 de/audi/app/messaging/core/folderbrowsing/IFolderNavigatorObserver$EmptyImplementation 
.const [88] = Class [87] 
.const [89] = Utf8 this$0 
.const [90] = Utf8 Lde/audi/app/messaging/core/readout/MessageReader; 
.const [91] = Utf8 Code 
.const [92] = Utf8 <init> 
.const [93] = Utf8 (Lde/audi/app/messaging/core/readout/MessageReader;)V 
.const [94] = Utf8 indicateFolderChange 
.const [95] = Utf8 (Z)V 
.const [96] = Utf8 <init> 
.const [97] = Utf8 (Lde/audi/app/messaging/core/readout/MessageReader;Lde/audi/app/messaging/core/readout/MessageReader$1;)V 
.end class 
