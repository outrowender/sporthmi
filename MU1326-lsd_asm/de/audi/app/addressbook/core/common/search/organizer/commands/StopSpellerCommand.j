.version 50 0 
.class public super [107] 
.super [109] 
.field private [110] [111] 

.method protected [113] : [114] 
    .attribute [112] .code stack 2 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     invokespecial [25] 
L5:     aload_0 
L6:     aload_2 
L7:     putfield [26] 
L10:    return 
L11:    nop 
L12:    
    .end code 
.end method 

.method public [115] : [116] 
    .attribute [112] .code stack 5 locals 2 
L0:     aload_0 
L1:     getfield [18] 
L4:     ldc [2] 
L6:     ldc [3] 
L8:     invokevirtual [19] 
L11:    pop 
L12:    aload_0 
L13:    getfield [17] 
L16:    invokeinterface [27] 0 
L21:    istore_1 
L22:    iload_1 
L23:    iconst_m1 
L24:    if_icmpeq L79 
L27:    aload_0 
L28:    getfield [18] 
L31:    ldc [4] 
L33:    ldc [5] 
L35:    iload_1 
L36:    i2l 
L37:    invokevirtual [20] 
L40:    pop 
L41:    aload_0 
L42:    getfield [21] 
L45:    iload_1 
L46:    invokevirtual [22] 
L49:    istore_2 
L50:    iload_2 
L51:    ifne L76 
L54:    aload_0 
L55:    getfield [18] 
L58:    sipush 10000 
L61:    ldc [6] 
L63:    invokevirtual [19] 
L66:    pop 
L67:    aload_0 
L68:    getfield [23] 
L71:    invokeinterface [28] 0 
L76:    goto L100 
L79:    aload_0 
L80:    getfield [18] 
L83:    ldc [4] 
L85:    ldc [7] 
L87:    invokevirtual [19] 
L90:    pop 
L91:    aload_0 
L92:    getfield [23] 
L95:    invokeinterface [28] 0 
L100:   return 
L101:   nop 
L102:   nop 
L103:   nop 
L104:   
    .end code 
.end method 

.method public [117] : [118] 
    .attribute [112] .code stack 6 locals 0 
L0:     aload_0 
L1:     getfield [18] 
L4:     ldc [4] 
L6:     ldc [8] 
L8:     iload_1 
L9:     invokestatic [9] 
L12:    iload_2 
L13:    i2l 
L14:    invokevirtual [24] 
L17:    pop 
L18:    aload_0 
L19:    getfield [23] 
L22:    invokeinterface [28] 0 
L27:    return 
L28:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Int -2137614336 
.const [3] = String [29] 
.const [4] = Int 1078071040 
.const [5] = String [30] 
.const [6] = String [31] 
.const [7] = String [32] 
.const [8] = String [33] 
.const [9] = Method [34] [35] 
.const [10] = Class [36] 
.const [11] = Class [37] 
.const [12] = Class [38] 
.const [13] = Class [39] 
.const [14] = Class [40] 
.const [15] = Class [41] 
.const [16] = Class [42] 
.const [17] = Field [43] [44] 
.const [18] = Field [45] [46] 
.const [19] = Method [47] [48] 
.const [20] = Method [49] [50] 
.const [21] = Field [51] [52] 
.const [22] = Method [53] [54] 
.const [23] = Field [55] [56] 
.const [24] = Method [57] [58] 
.const [25] = Method [59] [60] 
.const [26] = Field [61] [62] 
.const [27] = InterfaceMethod [63] [64] 
.const [28] = InterfaceMethod [65] [66] 
.const [29] = Utf8 'StopSpellerCommand#execute()' 
.const [30] = Utf8 'StopSpellerCommand#execute(): stopping speller with spellerHandle %1.' 
.const [31] = Utf8 'StopSpellerCommand#execute(): dsi call was not successful, finishing command.' 
.const [32] = Utf8 'StopSpellerCommand#execute(): nothing to do, no speller active currently.' 
.const [33] = Utf8 'StopSpellerCommand#stopSpellerResult(): success: %1, spellerHandle: %2' 
.const [34] = Class [67] 
.const [35] = NameAndType [68] [69] 
.const [36] = Utf8 de/audi/app/addressbook/core/common/search/organizer/commands/StopSpellerCommand 
.const [37] = Utf8 de/audi/app/addressbook/core/common/commands/AbstractADBCommand 
.const [38] = Utf8 de/audi/atip/log/LogChannel 
.const [39] = Utf8 de/audi/app/addressbook/core/common/search/organizer/ADBOrganizerSearch 
.const [40] = Utf8 de/audi/app/addressbook/core/common/commands/ADBDSIAccess 
.const [41] = Utf8 de/audi/tghu/command/ICommandList 
.const [42] = Utf8 de/audi/app/addressbook/core/common/ADBDbgUtils 
.const [43] = Class [70] 
.const [44] = NameAndType [71] [72] 
.const [45] = Class [73] 
.const [46] = NameAndType [74] [75] 
.const [47] = Class [76] 
.const [48] = NameAndType [77] [78] 
.const [49] = Class [79] 
.const [50] = NameAndType [80] [81] 
.const [51] = Class [82] 
.const [52] = NameAndType [83] [84] 
.const [53] = Class [85] 
.const [54] = NameAndType [86] [87] 
.const [55] = Class [88] 
.const [56] = NameAndType [89] [90] 
.const [57] = Class [91] 
.const [58] = NameAndType [92] [93] 
.const [59] = Class [94] 
.const [60] = NameAndType [95] [96] 
.const [61] = Class [97] 
.const [62] = NameAndType [98] [99] 
.const [63] = Class [100] 
.const [64] = NameAndType [101] [102] 
.const [65] = Class [103] 
.const [66] = NameAndType [104] [105] 
.const [67] = Utf8 de/audi/app/addressbook/core/common/ADBDbgUtils 
.const [68] = Utf8 dbgSuccessFlag 
.const [69] = Utf8 (I)Ljava/lang/String; 
.const [70] = Utf8 de/audi/app/addressbook/core/common/search/organizer/commands/StopSpellerCommand 
.const [71] = Utf8 adbSearch 
.const [72] = Utf8 Lde/audi/app/addressbook/core/common/search/organizer/ADBOrganizerSearch; 
.const [73] = Utf8 de/audi/app/addressbook/core/common/search/organizer/commands/StopSpellerCommand 
.const [74] = Utf8 logger 
.const [75] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [76] = Utf8 de/audi/atip/log/LogChannel 
.const [77] = Utf8 log 
.const [78] = Utf8 (ILjava/lang/String;)Z 
.const [79] = Utf8 de/audi/atip/log/LogChannel 
.const [80] = Utf8 log 
.const [81] = Utf8 (ILjava/lang/String;J)Z 
.const [82] = Utf8 de/audi/app/addressbook/core/common/search/organizer/commands/StopSpellerCommand 
.const [83] = Utf8 adbDSIAccess 
.const [84] = Utf8 Lde/audi/app/addressbook/core/common/commands/ADBDSIAccess; 
.const [85] = Utf8 de/audi/app/addressbook/core/common/commands/ADBDSIAccess 
.const [86] = Utf8 stopSpeller 
.const [87] = Utf8 (I)Z 
.const [88] = Utf8 de/audi/app/addressbook/core/common/search/organizer/commands/StopSpellerCommand 
.const [89] = Utf8 commandList 
.const [90] = Utf8 Lde/audi/tghu/command/ICommandList; 
.const [91] = Utf8 de/audi/atip/log/LogChannel 
.const [92] = Utf8 log 
.const [93] = Utf8 (ILjava/lang/String;Ljava/lang/Object;J)Z 
.const [94] = Utf8 de/audi/app/addressbook/core/common/commands/AbstractADBCommand 
.const [95] = Utf8 <init> 
.const [96] = Utf8 (Lde/audi/app/addressbook/core/common/ADBApplication;)V 
.const [97] = Utf8 de/audi/app/addressbook/core/common/search/organizer/commands/StopSpellerCommand 
.const [98] = Utf8 adbSearch 
.const [99] = Utf8 Lde/audi/app/addressbook/core/common/search/organizer/ADBOrganizerSearch; 
.const [100] = Utf8 de/audi/app/addressbook/core/common/search/organizer/ADBOrganizerSearch 
.const [101] = Utf8 getCurrentSpellerHandle 
.const [102] = Utf8 ()I 
.const [103] = Utf8 de/audi/tghu/command/ICommandList 
.const [104] = Utf8 commandFinished 
.const [105] = Utf8 ()V 
.const [106] = Utf8 de/audi/app/addressbook/core/common/search/organizer/commands/StopSpellerCommand 
.const [107] = Class [106] 
.const [108] = Utf8 de/audi/app/addressbook/core/common/commands/AbstractADBCommand 
.const [109] = Class [108] 
.const [110] = Utf8 adbSearch 
.const [111] = Utf8 Lde/audi/app/addressbook/core/common/search/organizer/ADBOrganizerSearch; 
.const [112] = Utf8 Code 
.const [113] = Utf8 <init> 
.const [114] = Utf8 (Lde/audi/app/addressbook/core/common/ADBApplication;Lde/audi/app/addressbook/core/common/search/organizer/ADBOrganizerSearch;)V 
.const [115] = Utf8 execute 
.const [116] = Utf8 ()V 
.const [117] = Utf8 stopSpellerResult 
.const [118] = Utf8 (II)V 
.end class 
