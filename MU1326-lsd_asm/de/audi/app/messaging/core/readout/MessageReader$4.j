.version 50 0 
.class super [84] 
.super [86] 
.implements [88] 
.field private final synthetic [89] [90] 

.method [92] : [93] 
    .attribute [91] .code stack 2 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     putfield [20] 
L5:     aload_0 
L6:     invokespecial [18] 
L9:     return 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method public [94] : [95] 
    .attribute [91] .code stack 3 locals 1 
L0:     aload_0 
L1:     getfield [16] 
L4:     invokestatic [2] 
L7:     ldc [3] 
L9:     ldc [4] 
L11:    invokevirtual [17] 
L14:    pop 
L15:    aload_0 
L16:    getfield [16] 
L19:    invokestatic [5] 
L22:    iconst_1 
L23:    if_icmpeq L36 
L26:    new [21] 
L29:    dup 
L30:    ldc [7] 
L32:    invokespecial [19] 
L35:    athrow 
L36:    aload_0 
L37:    getfield [16] 
L40:    invokestatic [8] 
L43:    invokeinterface [22] 0 
L48:    astore_1 
L49:    aload_1 
L50:    ifnonnull L63 
L53:    new [21] 
L56:    dup 
L57:    ldc [9] 
L59:    invokespecial [19] 
L62:    athrow 
L63:    aload_0 
L64:    getfield [16] 
L67:    aload_1 
L68:    invokestatic [10] 
L71:    return 
L72:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Method [23] [24] 
.const [3] = Int -2137614336 
.const [4] = String [25] 
.const [5] = Method [26] [27] 
.const [6] = Class [28] 
.const [7] = String [29] 
.const [8] = Method [30] [31] 
.const [9] = String [32] 
.const [10] = Method [33] [34] 
.const [11] = Class [35] 
.const [12] = Class [36] 
.const [13] = Class [37] 
.const [14] = Class [38] 
.const [15] = Class [39] 
.const [16] = Field [40] [41] 
.const [17] = Method [42] [43] 
.const [18] = Method [44] [45] 
.const [19] = Method [46] [47] 
.const [20] = Field [48] [49] 
.const [21] = Class [50] 
.const [22] = InterfaceMethod [51] [52] 
.const [23] = Class [53] 
.const [24] = NameAndType [54] [55] 
.const [25] = Utf8 '[MessageReader#start]' 
.const [26] = Class [56] 
.const [27] = NameAndType [57] [58] 
.const [28] = Utf8 java/lang/IllegalStateException 
.const [29] = Utf8 'A message is already being read.' 
.const [30] = Class [59] 
.const [31] = NameAndType [60] [61] 
.const [32] = Utf8 'Could not obtain a readable job.' 
.const [33] = Class [62] 
.const [34] = NameAndType [63] [64] 
.const [35] = Utf8 de/audi/app/messaging/core/readout/MessageReader$4 
.const [36] = Utf8 java/lang/Object 
.const [37] = Utf8 de/audi/app/messaging/core/readout/MessageReader 
.const [38] = Utf8 de/audi/atip/log/LogChannel 
.const [39] = Utf8 de/audi/app/messaging/core/readout/IReadableProvider 
.const [40] = Class [65] 
.const [41] = NameAndType [66] [67] 
.const [42] = Class [68] 
.const [43] = NameAndType [69] [70] 
.const [44] = Class [71] 
.const [45] = NameAndType [72] [73] 
.const [46] = Class [74] 
.const [47] = NameAndType [75] [76] 
.const [48] = Class [77] 
.const [49] = NameAndType [78] [79] 
.const [50] = Utf8 java/lang/IllegalStateException 
.const [51] = Class [80] 
.const [52] = NameAndType [81] [82] 
.const [53] = Utf8 de/audi/app/messaging/core/readout/MessageReader 
.const [54] = Utf8 access$1300 
.const [55] = Utf8 (Lde/audi/app/messaging/core/readout/MessageReader;)Lde/audi/atip/log/LogChannel; 
.const [56] = Utf8 de/audi/app/messaging/core/readout/MessageReader 
.const [57] = Utf8 access$1400 
.const [58] = Utf8 (Lde/audi/app/messaging/core/readout/MessageReader;)I 
.const [59] = Utf8 de/audi/app/messaging/core/readout/MessageReader 
.const [60] = Utf8 access$1000 
.const [61] = Utf8 (Lde/audi/app/messaging/core/readout/MessageReader;)Lde/audi/app/messaging/core/readout/IReadableProvider; 
.const [62] = Utf8 de/audi/app/messaging/core/readout/MessageReader 
.const [63] = Utf8 access$1100 
.const [64] = Utf8 (Lde/audi/app/messaging/core/readout/MessageReader;Lde/audi/app/messaging/core/readout/IReadable;)V 
.const [65] = Utf8 de/audi/app/messaging/core/readout/MessageReader$4 
.const [66] = Utf8 this$0 
.const [67] = Utf8 Lde/audi/app/messaging/core/readout/MessageReader; 
.const [68] = Utf8 de/audi/atip/log/LogChannel 
.const [69] = Utf8 log 
.const [70] = Utf8 (ILjava/lang/String;)Z 
.const [71] = Utf8 java/lang/Object 
.const [72] = Utf8 <init> 
.const [73] = Utf8 ()V 
.const [74] = Utf8 java/lang/IllegalStateException 
.const [75] = Utf8 <init> 
.const [76] = Utf8 (Ljava/lang/String;)V 
.const [77] = Utf8 de/audi/app/messaging/core/readout/MessageReader$4 
.const [78] = Utf8 this$0 
.const [79] = Utf8 Lde/audi/app/messaging/core/readout/MessageReader; 
.const [80] = Utf8 de/audi/app/messaging/core/readout/IReadableProvider 
.const [81] = Utf8 getReadable 
.const [82] = Utf8 ()Lde/audi/app/messaging/core/readout/IReadable; 
.const [83] = Utf8 de/audi/app/messaging/core/readout/MessageReader$4 
.const [84] = Class [83] 
.const [85] = Utf8 java/lang/Object 
.const [86] = Class [85] 
.const [87] = Utf8 java/lang/Runnable 
.const [88] = Class [87] 
.const [89] = Utf8 this$0 
.const [90] = Utf8 Lde/audi/app/messaging/core/readout/MessageReader; 
.const [91] = Utf8 Code 
.const [92] = Utf8 <init> 
.const [93] = Utf8 (Lde/audi/app/messaging/core/readout/MessageReader;)V 
.const [94] = Utf8 run 
.const [95] = Utf8 ()V 
.end class 
