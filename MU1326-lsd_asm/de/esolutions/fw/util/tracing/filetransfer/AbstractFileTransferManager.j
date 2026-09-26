.version 50 0 
.class public super abstract [129] 
.super [131] 
.implements [133] 
.field protected [134] [135] 
.field protected [136] [137] 
.field protected [138] [139] 
.field protected [140] [141] 
.field protected [142] [143] 
.field protected [144] [145] 

.method public [147] : [148] 
    .attribute [146] .code stack 3 locals 0 
L0:     aload_0 
L1:     invokespecial [13] 
L4:     aload_0 
L5:     aconst_null 
L6:     putfield [15] 
L9:     aload_0 
L10:    aconst_null 
L11:    putfield [16] 
L14:    aload_0 
L15:    new [17] 
L18:    dup 
L19:    invokespecial [14] 
L22:    putfield [18] 
L25:    return 
L26:    nop 
L27:    nop 
L28:    
    .end code 
.end method 

.method public interface [149] : [150] 
    .attribute [146] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [8] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [151] : [152] 
    .attribute [146] .code stack 2 locals 0 
L0:     aload_0 
L1:     getfield [7] 
L4:     aload_1 
L5:     invokevirtual [9] 
L8:     ifne L20 
L11:    aload_0 
L12:    getfield [7] 
L15:    aload_1 
L16:    invokevirtual [10] 
L19:    pop 
L20:    return 
L21:    nop 
L22:    nop 
L23:    nop 
L24:    
    .end code 
.end method 

.method public [153] : [154] 
    .attribute [146] .code stack 2 locals 0 
L0:     aload_0 
L1:     getfield [7] 
L4:     aload_1 
L5:     invokevirtual [9] 
L8:     ifeq L20 
L11:    aload_0 
L12:    getfield [7] 
L15:    aload_1 
L16:    invokevirtual [11] 
L19:    pop 
L20:    return 
L21:    nop 
L22:    nop 
L23:    nop 
L24:    
    .end code 
.end method 

.method protected [155] : [156] 
    .attribute [146] .code stack 2 locals 1 
L0:     aload_0 
L1:     getfield [7] 
L4:     invokevirtual [12] 
L7:     astore_2 
L8:     aload_2 
L9:     invokeinterface [19] 0 
L14:    ifeq L35 
L17:    aload_2 
L18:    invokeinterface [20] 0 
L23:    checkcast [3] 
L26:    aload_1 
L27:    invokeinterface [21] 0 
L32:    goto L8 
L35:    return 
L36:    
    .end code 
.end method 

.method protected [157] : [158] 
    .attribute [146] .code stack 2 locals 1 
L0:     aload_0 
L1:     getfield [7] 
L4:     invokevirtual [12] 
L7:     astore_2 
L8:     aload_2 
L9:     invokeinterface [19] 0 
L14:    ifeq L35 
L17:    aload_2 
L18:    invokeinterface [20] 0 
L23:    checkcast [3] 
L26:    aload_1 
L27:    invokeinterface [22] 0 
L32:    goto L8 
L35:    return 
L36:    
    .end code 
.end method 

.method protected [159] : [160] 
    .attribute [146] .code stack 2 locals 1 
L0:     aload_0 
L1:     getfield [7] 
L4:     invokevirtual [12] 
L7:     astore_2 
L8:     aload_2 
L9:     invokeinterface [19] 0 
L14:    ifeq L35 
L17:    aload_2 
L18:    invokeinterface [20] 0 
L23:    checkcast [3] 
L26:    aload_1 
L27:    invokeinterface [23] 0 
L32:    goto L8 
L35:    return 
L36:    
    .end code 
.end method 

.method protected [161] : [162] 
    .attribute [146] .code stack 2 locals 1 
L0:     aload_0 
L1:     getfield [7] 
L4:     invokevirtual [12] 
L7:     astore_2 
L8:     aload_2 
L9:     invokeinterface [19] 0 
L14:    ifeq L35 
L17:    aload_2 
L18:    invokeinterface [20] 0 
L23:    checkcast [3] 
L26:    aload_1 
L27:    invokeinterface [24] 0 
L32:    goto L8 
L35:    return 
L36:    
    .end code 
.end method 

.method protected [163] : [164] 
    .attribute [146] .code stack 2 locals 1 
L0:     aload_0 
L1:     getfield [7] 
L4:     invokevirtual [12] 
L7:     astore_2 
L8:     aload_2 
L9:     invokeinterface [19] 0 
L14:    ifeq L35 
L17:    aload_2 
L18:    invokeinterface [20] 0 
L23:    checkcast [3] 
L26:    aload_1 
L27:    invokeinterface [25] 0 
L32:    goto L8 
L35:    return 
L36:    
    .end code 
.end method 

.method protected [165] : [166] 
    .attribute [146] .code stack 2 locals 3 
L0:     iconst_0 
L1:     istore_2 
L2:     aload_0 
L3:     getfield [7] 
L6:     invokevirtual [12] 
L9:     astore_3 
L10:    aload_3 
L11:    invokeinterface [19] 0 
L16:    ifeq L51 
L19:    aload_3 
L20:    invokeinterface [20] 0 
L25:    checkcast [3] 
L28:    astore 4 
L30:    aload 4 
L32:    ifnull L48 
L35:    aload 4 
L37:    aload_1 
L38:    invokeinterface [26] 0 
L43:    ifeq L48 
L46:    iconst_1 
L47:    istore_2 
L48:    goto L10 
L51:    iload_2 
L52:    areturn 
L53:    nop 
L54:    nop 
L55:    nop 
L56:    
    .end code 
.end method 

.method public [167] : [168] 
    .attribute [146] .code stack 2 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     putfield [15] 
L5:     return 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [169] : [170] 
    .attribute [146] .code stack 2 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     putfield [16] 
L5:     return 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public abstract [171] : [172] 
    .attribute [146] .code stack 0 locals 0 
L0:     
    .end code 
.end method 

.method public abstract [173] : [174] 
    .attribute [146] .code stack 0 locals 0 
L0:     
    .end code 
.end method 

.method public abstract [175] : [176] 
    .attribute [146] .code stack 0 locals 0 
L0:     
    .end code 
.end method 

.method public abstract [177] : [178] 
    .attribute [146] .code stack 0 locals 0 
L0:     
    .end code 
.end method 

.method public abstract [179] : [180] 
    .attribute [146] .code stack 0 locals 0 
L0:     
    .end code 
.end method 

.method public abstract [181] : [182] 
    .attribute [146] .code stack 0 locals 0 
L0:     
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [27] 
.const [3] = Class [28] 
.const [4] = Class [29] 
.const [5] = Class [30] 
.const [6] = Class [31] 
.const [7] = Field [32] [33] 
.const [8] = Field [34] [35] 
.const [9] = Method [36] [37] 
.const [10] = Method [38] [39] 
.const [11] = Method [40] [41] 
.const [12] = Method [42] [43] 
.const [13] = Method [44] [45] 
.const [14] = Method [46] [47] 
.const [15] = Field [48] [49] 
.const [16] = Field [50] [51] 
.const [17] = Class [52] 
.const [18] = Field [53] [54] 
.const [19] = InterfaceMethod [55] [56] 
.const [20] = InterfaceMethod [57] [58] 
.const [21] = InterfaceMethod [59] [60] 
.const [22] = InterfaceMethod [61] [62] 
.const [23] = InterfaceMethod [63] [64] 
.const [24] = InterfaceMethod [65] [66] 
.const [25] = InterfaceMethod [67] [68] 
.const [26] = InterfaceMethod [69] [70] 
.const [27] = Utf8 java/util/ArrayList 
.const [28] = Utf8 de/esolutions/fw/util/tracing/filetransfer/IFileTransferListener 
.const [29] = Utf8 de/esolutions/fw/util/tracing/filetransfer/AbstractFileTransferManager 
.const [30] = Utf8 java/lang/Object 
.const [31] = Utf8 java/util/Iterator 
.const [32] = Class [71] 
.const [33] = NameAndType [72] [73] 
.const [34] = Class [74] 
.const [35] = NameAndType [75] [76] 
.const [36] = Class [77] 
.const [37] = NameAndType [78] [79] 
.const [38] = Class [80] 
.const [39] = NameAndType [81] [82] 
.const [40] = Class [83] 
.const [41] = NameAndType [84] [85] 
.const [42] = Class [86] 
.const [43] = NameAndType [87] [88] 
.const [44] = Class [89] 
.const [45] = NameAndType [90] [91] 
.const [46] = Class [92] 
.const [47] = NameAndType [93] [94] 
.const [48] = Class [95] 
.const [49] = NameAndType [96] [97] 
.const [50] = Class [98] 
.const [51] = NameAndType [99] [100] 
.const [52] = Utf8 java/util/ArrayList 
.const [53] = Class [101] 
.const [54] = NameAndType [102] [103] 
.const [55] = Class [104] 
.const [56] = NameAndType [105] [106] 
.const [57] = Class [107] 
.const [58] = NameAndType [108] [109] 
.const [59] = Class [110] 
.const [60] = NameAndType [111] [112] 
.const [61] = Class [113] 
.const [62] = NameAndType [114] [115] 
.const [63] = Class [116] 
.const [64] = NameAndType [117] [118] 
.const [65] = Class [119] 
.const [66] = NameAndType [120] [121] 
.const [67] = Class [122] 
.const [68] = NameAndType [123] [124] 
.const [69] = Class [125] 
.const [70] = NameAndType [126] [127] 
.const [71] = Utf8 de/esolutions/fw/util/tracing/filetransfer/AbstractFileTransferManager 
.const [72] = Utf8 listeners 
.const [73] = Utf8 Ljava/util/ArrayList; 
.const [74] = Utf8 de/esolutions/fw/util/tracing/filetransfer/AbstractFileTransferManager 
.const [75] = Utf8 downloadDirectory 
.const [76] = Utf8 Ljava/lang/String; 
.const [77] = Utf8 java/util/ArrayList 
.const [78] = Utf8 contains 
.const [79] = Utf8 (Ljava/lang/Object;)Z 
.const [80] = Utf8 java/util/ArrayList 
.const [81] = Utf8 add 
.const [82] = Utf8 (Ljava/lang/Object;)Z 
.const [83] = Utf8 java/util/ArrayList 
.const [84] = Utf8 remove 
.const [85] = Utf8 (Ljava/lang/Object;)Z 
.const [86] = Utf8 java/util/ArrayList 
.const [87] = Utf8 iterator 
.const [88] = Utf8 ()Ljava/util/Iterator; 
.const [89] = Utf8 java/lang/Object 
.const [90] = Utf8 <init> 
.const [91] = Utf8 ()V 
.const [92] = Utf8 java/util/ArrayList 
.const [93] = Utf8 <init> 
.const [94] = Utf8 ()V 
.const [95] = Utf8 de/esolutions/fw/util/tracing/filetransfer/AbstractFileTransferManager 
.const [96] = Utf8 fileTransferSender 
.const [97] = Utf8 Lde/esolutions/fw/util/tracing/filetransfer/IFileTransferSender; 
.const [98] = Utf8 de/esolutions/fw/util/tracing/filetransfer/AbstractFileTransferManager 
.const [99] = Utf8 fileFactory 
.const [100] = Utf8 Lde/esolutions/fw/util/tracing/filetransfer/file/IFileFactory; 
.const [101] = Utf8 de/esolutions/fw/util/tracing/filetransfer/AbstractFileTransferManager 
.const [102] = Utf8 listeners 
.const [103] = Utf8 Ljava/util/ArrayList; 
.const [104] = Utf8 java/util/Iterator 
.const [105] = Utf8 hasNext 
.const [106] = Utf8 ()Z 
.const [107] = Utf8 java/util/Iterator 
.const [108] = Utf8 next 
.const [109] = Utf8 ()Ljava/lang/Object; 
.const [110] = Utf8 de/esolutions/fw/util/tracing/filetransfer/IFileTransferListener 
.const [111] = Utf8 fileTransferBegin 
.const [112] = Utf8 (Lde/esolutions/fw/util/tracing/filetransfer/file/IFile;)V 
.const [113] = Utf8 de/esolutions/fw/util/tracing/filetransfer/IFileTransferListener 
.const [114] = Utf8 fileTransferComplete 
.const [115] = Utf8 (Lde/esolutions/fw/util/tracing/filetransfer/file/IFile;)V 
.const [116] = Utf8 de/esolutions/fw/util/tracing/filetransfer/IFileTransferListener 
.const [117] = Utf8 fileTransferError 
.const [118] = Utf8 (Lde/esolutions/fw/util/tracing/filetransfer/file/IFile;)V 
.const [119] = Utf8 de/esolutions/fw/util/tracing/filetransfer/IFileTransferListener 
.const [120] = Utf8 fileTransferStatus 
.const [121] = Utf8 (Lde/esolutions/fw/util/tracing/filetransfer/file/IFile;)V 
.const [122] = Utf8 de/esolutions/fw/util/tracing/filetransfer/IFileTransferListener 
.const [123] = Utf8 fileTransferProgress 
.const [124] = Utf8 (Lde/esolutions/fw/util/tracing/filetransfer/file/IFile;)V 
.const [125] = Utf8 de/esolutions/fw/util/tracing/filetransfer/IFileTransferListener 
.const [126] = Utf8 confirmFileTransfer 
.const [127] = Utf8 (Lde/esolutions/fw/util/tracing/filetransfer/file/IFile;)Z 
.const [128] = Utf8 de/esolutions/fw/util/tracing/filetransfer/AbstractFileTransferManager 
.const [129] = Class [128] 
.const [130] = Utf8 java/lang/Object 
.const [131] = Class [130] 
.const [132] = Utf8 de/esolutions/fw/util/tracing/filetransfer/IFileTransferReceiver 
.const [133] = Class [132] 
.const [134] = Utf8 blockSize 
.const [135] = Utf8 I 
.const [136] = Utf8 hashType 
.const [137] = Utf8 B 
.const [138] = Utf8 downloadDirectory 
.const [139] = Utf8 Ljava/lang/String; 
.const [140] = Utf8 fileTransferSender 
.const [141] = Utf8 Lde/esolutions/fw/util/tracing/filetransfer/IFileTransferSender; 
.const [142] = Utf8 fileFactory 
.const [143] = Utf8 Lde/esolutions/fw/util/tracing/filetransfer/file/IFileFactory; 
.const [144] = Utf8 listeners 
.const [145] = Utf8 Ljava/util/ArrayList; 
.const [146] = Utf8 Code 
.const [147] = Utf8 <init> 
.const [148] = Utf8 ()V 
.const [149] = Utf8 getDownloadDirectory 
.const [150] = Utf8 ()Ljava/lang/String; 
.const [151] = Utf8 registerListener 
.const [152] = Utf8 (Lde/esolutions/fw/util/tracing/filetransfer/IFileTransferListener;)V 
.const [153] = Utf8 unregisterListener 
.const [154] = Utf8 (Lde/esolutions/fw/util/tracing/filetransfer/IFileTransferListener;)V 
.const [155] = Utf8 notifyListenerFileTransferBegin 
.const [156] = Utf8 (Lde/esolutions/fw/util/tracing/filetransfer/file/IFile;)V 
.const [157] = Utf8 notifyListenerFileTransferComplete 
.const [158] = Utf8 (Lde/esolutions/fw/util/tracing/filetransfer/file/IFile;)V 
.const [159] = Utf8 notifyListenerFileTransferError 
.const [160] = Utf8 (Lde/esolutions/fw/util/tracing/filetransfer/file/IFile;)V 
.const [161] = Utf8 notifyListenerFileTransferStatus 
.const [162] = Utf8 (Lde/esolutions/fw/util/tracing/filetransfer/file/IFile;)V 
.const [163] = Utf8 notifyListenerFileTransferProgress 
.const [164] = Utf8 (Lde/esolutions/fw/util/tracing/filetransfer/file/IFile;)V 
.const [165] = Utf8 confirmFileTransfer 
.const [166] = Utf8 (Lde/esolutions/fw/util/tracing/filetransfer/file/IFile;)Z 
.const [167] = Utf8 setFileTransferSender 
.const [168] = Utf8 (Lde/esolutions/fw/util/tracing/filetransfer/IFileTransferSender;)V 
.const [169] = Utf8 setFileFactory 
.const [170] = Utf8 (Lde/esolutions/fw/util/tracing/filetransfer/file/IFileFactory;)V 
.const [171] = Utf8 uploadFile 
.const [172] = Utf8 (Lde/esolutions/fw/util/tracing/filetransfer/file/IFile;)Z 
.const [173] = Utf8 requestFileStatus 
.const [174] = Utf8 (Ljava/lang/String;Lde/esolutions/fw/util/tracing/filetransfer/file/IFile;)Z 
.const [175] = Utf8 requestFileDownload 
.const [176] = Utf8 (Ljava/lang/String;Lde/esolutions/fw/util/tracing/filetransfer/file/IFile;)Z 
.const [177] = Utf8 handleFileRequestMessage 
.const [178] = Utf8 (ILjava/lang/String;B)Z 
.const [179] = Utf8 handleFileStatusMessage 
.const [180] = Utf8 (ILjava/lang/String;BJJB[B)Z 
.const [181] = Utf8 handleFileTransferMessage 
.const [182] = Utf8 (IIBI[B)Z 
.end class 
