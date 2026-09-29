.version 50 0 
.class public super [65] 
.super [67] 

.method public annotation [69] : [70] 
    .attribute [68] .code stack 1 locals 0 
L0:     aload_0 
L1:     invokespecial [17] 
L4:     return 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [71] : [72] 
    .attribute [68] .code stack 4 locals 0 
L0:     iconst_2 
L1:     anewarray [2] 
L4:     dup 
L5:     iconst_0 
L6:     ldc [3] 
L8:     aastore 
L9:     dup 
L10:    iconst_1 
L11:    ldc [4] 
L13:    aastore 
L14:    areturn 
L15:    nop 
L16:    
    .end code 
.end method 

.method public [73] : [74] 
    .attribute [68] .code stack 1 locals 0 
L0:     ldc [5] 
L2:     areturn 
L3:     nop 
L4:     
    .end code 
.end method 

.method public [75] : [76] 
    .attribute [68] .code stack 1 locals 0 
L0:     ldc [6] 
L2:     areturn 
L3:     nop 
L4:     
    .end code 
.end method 

.method public [77] : [78] 
    .attribute [68] .code stack 3 locals 5 
L0:     aload_2 
L1:     arraylength 
L2:     ifne L13 
L5:     aload_1 
L6:     aload_3 
L7:     invokevirtual [13] 
L10:    goto L90 
L13:    invokestatic [7] 
L16:    invokevirtual [14] 
L19:    astore 4 
L21:    iconst_0 
L22:    istore 5 
L24:    iload 5 
L26:    aload_2 
L27:    arraylength 
L28:    if_icmpge L90 
L31:    aload_2 
L32:    iload 5 
L34:    aaload 
L35:    astore 6 
L37:    iconst_0 
L38:    istore 7 
L40:    iload 7 
L42:    aload 4 
L44:    arraylength 
L45:    if_icmpge L84 
L48:    aload 4 
L50:    iload 7 
L52:    aaload 
L53:    astore 8 
L55:    aload 8 
L57:    aload 6 
L59:    invokeinterface [18] 0 
L64:    ifnull L78 
L67:    aload_1 
L68:    aload_3 
L69:    aload 8 
L71:    invokevirtual [15] 
L74:    aload_3 
L75:    invokevirtual [16] 
L78:    iinc 7 1 
L81:    goto L40 
L84:    iinc 5 1 
L87:    goto L24 
L90:    iconst_0 
L91:    areturn 
L92:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [19] 
.const [3] = String [20] 
.const [4] = String [21] 
.const [5] = String [22] 
.const [6] = String [23] 
.const [7] = Method [24] [25] 
.const [8] = Class [26] 
.const [9] = Class [27] 
.const [10] = Class [28] 
.const [11] = Class [29] 
.const [12] = Class [30] 
.const [13] = Method [31] [32] 
.const [14] = Method [33] [34] 
.const [15] = Method [35] [36] 
.const [16] = Method [37] [38] 
.const [17] = Method [39] [40] 
.const [18] = InterfaceMethod [41] [42] 
.const [19] = Utf8 java/lang/String 
.const [20] = Utf8 help 
.const [21] = Utf8 '?' 
.const [22] = Utf8 'give information on (all) command usage' 
.const [23] = Utf8 '[command]' 
.const [24] = Class [43] 
.const [25] = NameAndType [44] [45] 
.const [26] = Utf8 de/esolutions/fw/comm/agent/doctor/command/AbstractDoctorCommand 
.const [27] = Utf8 de/esolutions/fw/comm/agent/doctor/DoctorShell 
.const [28] = Utf8 de/esolutions/fw/comm/agent/doctor/command/DoctorCommandRegistry 
.const [29] = Utf8 de/esolutions/fw/comm/agent/doctor/command/IDoctorCommand 
.const [30] = Utf8 java/io/PrintStream 
.const [31] = Class [46] 
.const [32] = NameAndType [47] [48] 
.const [33] = Class [49] 
.const [34] = NameAndType [50] [51] 
.const [35] = Class [52] 
.const [36] = NameAndType [53] [54] 
.const [37] = Class [55] 
.const [38] = NameAndType [56] [57] 
.const [39] = Class [58] 
.const [40] = NameAndType [59] [60] 
.const [41] = Class [61] 
.const [42] = NameAndType [62] [63] 
.const [43] = Utf8 de/esolutions/fw/comm/agent/doctor/command/DoctorCommandRegistry 
.const [44] = Utf8 getInstance 
.const [45] = Utf8 ()Lde/esolutions/fw/comm/agent/doctor/command/DoctorCommandRegistry; 
.const [46] = Utf8 de/esolutions/fw/comm/agent/doctor/DoctorShell 
.const [47] = Utf8 showHelp 
.const [48] = Utf8 (Ljava/io/PrintStream;)V 
.const [49] = Utf8 de/esolutions/fw/comm/agent/doctor/command/DoctorCommandRegistry 
.const [50] = Utf8 getAllCommands 
.const [51] = Utf8 ()[Lde/esolutions/fw/comm/agent/doctor/command/IDoctorCommand; 
.const [52] = Utf8 de/esolutions/fw/comm/agent/doctor/DoctorShell 
.const [53] = Utf8 showCommandHelp 
.const [54] = Utf8 (Ljava/io/PrintStream;Lde/esolutions/fw/comm/agent/doctor/command/IDoctorCommand;)V 
.const [55] = Utf8 java/io/PrintStream 
.const [56] = Utf8 println 
.const [57] = Utf8 ()V 
.const [58] = Utf8 de/esolutions/fw/comm/agent/doctor/command/AbstractDoctorCommand 
.const [59] = Utf8 <init> 
.const [60] = Utf8 ()V 
.const [61] = Utf8 de/esolutions/fw/comm/agent/doctor/command/IDoctorCommand 
.const [62] = Utf8 matchCommandName 
.const [63] = Utf8 (Ljava/lang/String;)Ljava/lang/Boolean; 
.const [64] = Utf8 de/esolutions/fw/comm/agent/doctor/command/HelpCommand 
.const [65] = Class [64] 
.const [66] = Utf8 de/esolutions/fw/comm/agent/doctor/command/AbstractDoctorCommand 
.const [67] = Class [66] 
.const [68] = Utf8 Code 
.const [69] = Utf8 <init> 
.const [70] = Utf8 ()V 
.const [71] = Utf8 getNames 
.const [72] = Utf8 ()[Ljava/lang/String; 
.const [73] = Utf8 getDescription 
.const [74] = Utf8 ()Ljava/lang/String; 
.const [75] = Utf8 getUsage 
.const [76] = Utf8 ()Ljava/lang/String; 
.const [77] = Utf8 handle 
.const [78] = Utf8 (Lde/esolutions/fw/comm/agent/doctor/DoctorShell;[Ljava/lang/String;Ljava/io/PrintStream;)Z 
.end class 
