.version 50 0 
.class public final super [89] 
.super [91] 
.implements [93] 

.method public [95] : [96] 
    .attribute [94] .code stack 3 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     ldc [2] 
L4:     invokespecial [20] 
L7:     return 
L8:     
    .end code 
.end method 

.method public [97] : [98] 
    .attribute [94] .code stack 3 locals 3 
L0:     aload_0 
L1:     getfield [15] 
L4:     invokevirtual [16] 
L7:     invokevirtual [17] 
L10:    invokevirtual [18] 
L13:    istore_2 
L14:    aload_1 
L15:    invokestatic [3] 
L18:    istore_3 
L19:    new [22] 
L22:    dup 
L23:    invokespecial [21] 
L26:    astore 4 
L28:    aload 4 
L30:    iload_2 
L31:    invokestatic [5] 
L34:    aload 4 
L36:    aconst_null 
L37:    aload_1 
L38:    invokevirtual [19] 
L41:    invokestatic [6] 
L44:    iload_3 
L45:    aload 4 
L47:    invokestatic [7] 
L50:    areturn 
L51:    nop 
L52:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = String [23] 
.const [3] = Method [24] [25] 
.const [4] = Class [26] 
.const [5] = Method [27] [28] 
.const [6] = Method [29] [30] 
.const [7] = Method [31] [32] 
.const [8] = Class [33] 
.const [9] = Class [34] 
.const [10] = Class [35] 
.const [11] = Class [36] 
.const [12] = Class [37] 
.const [13] = Class [38] 
.const [14] = Class [39] 
.const [15] = Field [40] [41] 
.const [16] = Method [42] [43] 
.const [17] = Method [44] [45] 
.const [18] = Method [46] [47] 
.const [19] = Method [48] [49] 
.const [20] = Method [50] [51] 
.const [21] = Method [52] [53] 
.const [22] = Class [54] 
.const [23] = Utf8 'App.Messaging.Main' 
.const [24] = Class [55] 
.const [25] = NameAndType [56] [57] 
.const [26] = Utf8 java/util/ArrayList 
.const [27] = Class [58] 
.const [28] = NameAndType [59] [60] 
.const [29] = Class [61] 
.const [30] = NameAndType [62] [63] 
.const [31] = Class [64] 
.const [32] = NameAndType [65] [66] 
.const [33] = Utf8 de/audi/app/messaging/evo/folderbrowsing/EntryPropertyFactoryEvo 
.const [34] = Utf8 de/audi/app/messaging/core/component/AbstractMessagingComponent 
.const [35] = Utf8 de/audi/app/messaging/core/application/AbstractMsgApplication 
.const [36] = Utf8 de/audi/app/messaging/core/folderbrowsing/FolderNavigator 
.const [37] = Utf8 de/audi/app/messaging/core/folderbrowsing/Folder 
.const [38] = Utf8 de/audi/app/messaging/evo/drawer/DrawerOptions 
.const [39] = Utf8 org/dsi/ifc/messaging/ListEntry 
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
.const [52] = Class [85] 
.const [53] = NameAndType [86] [87] 
.const [54] = Utf8 java/util/ArrayList 
.const [55] = Utf8 de/audi/app/messaging/evo/drawer/DrawerOptions 
.const [56] = Utf8 getCategory 
.const [57] = Utf8 (Lorg/dsi/ifc/messaging/ListEntry;)I 
.const [58] = Utf8 de/audi/app/messaging/evo/drawer/DrawerOptions 
.const [59] = Utf8 tryAddPropertyFolderType 
.const [60] = Utf8 (Ljava/util/Collection;I)V 
.const [61] = Utf8 de/audi/app/messaging/evo/drawer/DrawerOptions 
.const [62] = Utf8 tryAddPropertyAttachmentsAvailable 
.const [63] = Utf8 (Ljava/util/Collection;Lorg/dsi/ifc/messaging/MessageDetails;Lorg/dsi/ifc/messaging/MessageListEntry;)V 
.const [64] = Utf8 de/audi/app/messaging/evo/drawer/DrawerOptions 
.const [65] = Utf8 createPropertyListCell 
.const [66] = Utf8 (ILjava/util/Collection;)Lde/audi/atip/hmi/model/PropertyListCell; 
.const [67] = Utf8 de/audi/app/messaging/evo/folderbrowsing/EntryPropertyFactoryEvo 
.const [68] = Utf8 msgApp 
.const [69] = Utf8 Lde/audi/app/messaging/core/application/AbstractMsgApplication; 
.const [70] = Utf8 de/audi/app/messaging/core/application/AbstractMsgApplication 
.const [71] = Utf8 getFolderNavigator 
.const [72] = Utf8 ()Lde/audi/app/messaging/core/folderbrowsing/FolderNavigator; 
.const [73] = Utf8 de/audi/app/messaging/core/folderbrowsing/FolderNavigator 
.const [74] = Utf8 getCurrentFolder 
.const [75] = Utf8 ()Lde/audi/app/messaging/core/folderbrowsing/Folder; 
.const [76] = Utf8 de/audi/app/messaging/core/folderbrowsing/Folder 
.const [77] = Utf8 getHmiFolderType 
.const [78] = Utf8 ()I 
.const [79] = Utf8 org/dsi/ifc/messaging/ListEntry 
.const [80] = Utf8 getMessageListEntry 
.const [81] = Utf8 ()Lorg/dsi/ifc/messaging/MessageListEntry; 
.const [82] = Utf8 de/audi/app/messaging/core/component/AbstractMessagingComponent 
.const [83] = Utf8 <init> 
.const [84] = Utf8 (Lde/audi/app/messaging/core/osgi/MessagingBundleContext;Ljava/lang/String;)V 
.const [85] = Utf8 java/util/ArrayList 
.const [86] = Utf8 <init> 
.const [87] = Utf8 ()V 
.const [88] = Utf8 de/audi/app/messaging/evo/folderbrowsing/EntryPropertyFactoryEvo 
.const [89] = Class [88] 
.const [90] = Utf8 de/audi/app/messaging/core/component/AbstractMessagingComponent 
.const [91] = Class [90] 
.const [92] = Utf8 de/audi/app/messaging/core/folderbrowsing/IEntryPropertyFactory 
.const [93] = Class [92] 
.const [94] = Utf8 Code 
.const [95] = Utf8 <init> 
.const [96] = Utf8 (Lde/audi/app/messaging/core/osgi/MessagingBundleContext;)V 
.const [97] = Utf8 create 
.const [98] = Utf8 (Lorg/dsi/ifc/messaging/ListEntry;)Lde/audi/atip/hmi/model/PropertyListCell; 
.end class 
