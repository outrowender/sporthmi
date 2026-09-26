.version 50 0 
.class super [117] 
.super [119] 
.field private final synthetic [120] [121] 

.method [123] : [124] 
    .attribute [122] .code stack 2 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     putfield [24] 
L5:     aload_0 
L6:     aload_2 
L7:     invokespecial [21] 
L10:    return 
L11:    nop 
L12:    
    .end code 
.end method 

.method public [125] : [126] 
    .attribute [122] .code stack 8 locals 4 
L0:     aload_0 
L1:     invokevirtual [18] 
L4:     ldc [2] 
L6:     invokeinterface [25] 0 
L11:    astore_1 
L12:    aload_1 
L13:    ifnonnull L28 
L16:    aload_0 
L17:    invokevirtual [18] 
L20:    ldc [3] 
L22:    invokeinterface [26] 0 
L27:    return 
L28:    aload_1 
L29:    checkcast [4] 
L32:    invokevirtual [19] 
L35:    lstore_2 
L36:    aload_0 
L37:    getfield [17] 
L40:    invokestatic [5] 
L43:    invokeinterface [27] 0 
L48:    astore 4 
L50:    ldc [6] 
L52:    invokestatic [7] 
L55:    ifne L80 
L58:    aload 4 
L60:    new [28] 
L63:    dup 
L64:    iconst_1 
L65:    newarray long 
L67:    dup 
L68:    iconst_0 
L69:    lload_2 
L70:    lastore 
L71:    ldc [6] 
L73:    invokespecial [22] 
L76:    invokevirtual [20] 
L79:    pop 
L80:    aload 4 
L82:    new [29] 
L85:    dup 
L86:    iconst_1 
L87:    newarray long 
L89:    dup 
L90:    iconst_0 
L91:    lload_2 
L92:    lastore 
L93:    invokespecial [23] 
L96:    invokevirtual [20] 
L99:    pop 
L100:   aload_0 
L101:   invokevirtual [18] 
L104:   aload 4 
L106:   invokeinterface [30] 0 
L111:   return 
L112:   
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = String [31] 
.const [3] = String [32] 
.const [4] = Class [33] 
.const [5] = Method [34] [35] 
.const [6] = String [36] 
.const [7] = Method [37] [38] 
.const [8] = Class [39] 
.const [9] = Class [40] 
.const [10] = Class [41] 
.const [11] = Class [42] 
.const [12] = Class [43] 
.const [13] = Class [44] 
.const [14] = Class [45] 
.const [15] = Class [46] 
.const [16] = Class [47] 
.const [17] = Field [48] [49] 
.const [18] = Method [50] [51] 
.const [19] = Method [52] [53] 
.const [20] = Method [54] [55] 
.const [21] = Method [56] [57] 
.const [22] = Method [58] [59] 
.const [23] = Method [60] [61] 
.const [24] = Field [62] [63] 
.const [25] = InterfaceMethod [64] [65] 
.const [26] = InterfaceMethod [66] [67] 
.const [27] = InterfaceMethod [68] [69] 
.const [28] = Class [70] 
.const [29] = Class [71] 
.const [30] = InterfaceMethod [72] [73] 
.const [31] = Utf8 BLOCK_UID 
.const [32] = Utf8 'No UID put into CommandList, abort!!!' 
.const [33] = Utf8 java/lang/Long 
.const [34] = Class [74] 
.const [35] = NameAndType [75] [76] 
.const [36] = Utf8 '@@TRAFFIC_AHEAD@@' 
.const [37] = Class [77] 
.const [38] = NameAndType [78] [79] 
.const [39] = Utf8 de/audi/tghu/navi/app/command/block/SetBlockDescriptionCommand 
.const [40] = Utf8 de/audi/tghu/navi/app/command/block/PersistBlockCommand 
.const [41] = Utf8 de/audi/tghu/navi/app/guidance/SimpleDetourHandler$1 
.const [42] = Utf8 de/audi/tghu/navi/app/command/NavCommand 
.const [43] = Utf8 de/audi/tghu/command/ICommandList 
.const [44] = Utf8 de/audi/tghu/navi/app/guidance/SimpleDetourHandler 
.const [45] = Utf8 de/audi/tghu/command/ICommandListFactory 
.const [46] = Utf8 de/audi/tghu/navi/app/util/Util 
.const [47] = Utf8 de/audi/tghu/command/CommandList 
.const [48] = Class [80] 
.const [49] = NameAndType [81] [82] 
.const [50] = Class [83] 
.const [51] = NameAndType [84] [85] 
.const [52] = Class [86] 
.const [53] = NameAndType [87] [88] 
.const [54] = Class [89] 
.const [55] = NameAndType [90] [91] 
.const [56] = Class [92] 
.const [57] = NameAndType [93] [94] 
.const [58] = Class [95] 
.const [59] = NameAndType [96] [97] 
.const [60] = Class [98] 
.const [61] = NameAndType [99] [100] 
.const [62] = Class [101] 
.const [63] = NameAndType [102] [103] 
.const [64] = Class [104] 
.const [65] = NameAndType [105] [106] 
.const [66] = Class [107] 
.const [67] = NameAndType [108] [109] 
.const [68] = Class [110] 
.const [69] = NameAndType [111] [112] 
.const [70] = Utf8 de/audi/tghu/navi/app/command/block/SetBlockDescriptionCommand 
.const [71] = Utf8 de/audi/tghu/navi/app/command/block/PersistBlockCommand 
.const [72] = Class [113] 
.const [73] = NameAndType [114] [115] 
.const [74] = Utf8 de/audi/tghu/navi/app/guidance/SimpleDetourHandler 
.const [75] = Utf8 access$000 
.const [76] = Utf8 (Lde/audi/tghu/navi/app/guidance/SimpleDetourHandler;)Lde/audi/tghu/command/ICommandListFactory; 
.const [77] = Utf8 de/audi/tghu/navi/app/util/Util 
.const [78] = Utf8 isEmpty 
.const [79] = Utf8 (Ljava/lang/String;)Z 
.const [80] = Utf8 de/audi/tghu/navi/app/guidance/SimpleDetourHandler$1 
.const [81] = Utf8 this$0 
.const [82] = Utf8 Lde/audi/tghu/navi/app/guidance/SimpleDetourHandler; 
.const [83] = Utf8 de/audi/tghu/navi/app/guidance/SimpleDetourHandler$1 
.const [84] = Utf8 getCommandList 
.const [85] = Utf8 ()Lde/audi/tghu/command/ICommandList; 
.const [86] = Utf8 java/lang/Long 
.const [87] = Utf8 longValue 
.const [88] = Utf8 ()J 
.const [89] = Utf8 de/audi/tghu/command/CommandList 
.const [90] = Utf8 add 
.const [91] = Utf8 (Lde/audi/tghu/command/Command;)Lde/audi/tghu/command/ICommandList; 
.const [92] = Utf8 de/audi/tghu/navi/app/command/NavCommand 
.const [93] = Utf8 <init> 
.const [94] = Utf8 (Ljava/lang/String;)V 
.const [95] = Utf8 de/audi/tghu/navi/app/command/block/SetBlockDescriptionCommand 
.const [96] = Utf8 <init> 
.const [97] = Utf8 ([JLjava/lang/String;)V 
.const [98] = Utf8 de/audi/tghu/navi/app/command/block/PersistBlockCommand 
.const [99] = Utf8 <init> 
.const [100] = Utf8 ([J)V 
.const [101] = Utf8 de/audi/tghu/navi/app/guidance/SimpleDetourHandler$1 
.const [102] = Utf8 this$0 
.const [103] = Utf8 Lde/audi/tghu/navi/app/guidance/SimpleDetourHandler; 
.const [104] = Utf8 de/audi/tghu/command/ICommandList 
.const [105] = Utf8 get 
.const [106] = Utf8 (Ljava/lang/Object;)Ljava/lang/Object; 
.const [107] = Utf8 de/audi/tghu/command/ICommandList 
.const [108] = Utf8 commandAborted 
.const [109] = Utf8 (Ljava/lang/String;)V 
.const [110] = Utf8 de/audi/tghu/command/ICommandListFactory 
.const [111] = Utf8 createCommandList 
.const [112] = Utf8 ()Lde/audi/tghu/command/CommandList; 
.const [113] = Utf8 de/audi/tghu/command/ICommandList 
.const [114] = Utf8 commandFinishedWithPostSequence 
.const [115] = Utf8 (Lde/audi/tghu/command/CommandList;)V 
.const [116] = Utf8 de/audi/tghu/navi/app/guidance/SimpleDetourHandler$1 
.const [117] = Class [116] 
.const [118] = Utf8 de/audi/tghu/navi/app/command/NavCommand 
.const [119] = Class [118] 
.const [120] = Utf8 this$0 
.const [121] = Utf8 Lde/audi/tghu/navi/app/guidance/SimpleDetourHandler; 
.const [122] = Utf8 Code 
.const [123] = Utf8 <init> 
.const [124] = Utf8 (Lde/audi/tghu/navi/app/guidance/SimpleDetourHandler;Ljava/lang/String;)V 
.const [125] = Utf8 execute 
.const [126] = Utf8 ()V 
.end class 
