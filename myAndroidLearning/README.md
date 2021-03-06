# 2020.08.11
## 学习内容
### 1. AlertDialog、ProgressBar、ProgressDialog
学习AlertDialog默认、单选、多选、自定义样式
其中自定义样式与ProgressBar、ProgressDialog相结合实现Dialog中登录以及进度条的加载
横向进度条使用Handler+Runnable进行处理，其实就是开了一条进程
目前Handler与ProgressDialog已经弃用了似乎

### 2. 横竖屏切换，Home，Back键触发后Activity的生命周期变化
横竖屏切换和Back键一样都是直接销毁当前活动，横竖屏切换会重建一个活动
Home键则是挂起，活动不可见，重新进入重新onRestart

### 3. Activity的四中启动模式
Activity主要依靠返回栈进行操作
Standard、SingleTop、SingleTask、SingleInstance四种模式
- Standard：不作判断，有活动跳转就压栈
- SingleTop：判断栈顶是否是当前活动，不是则继续压栈，是则不压栈
- SingleTask: 判断活动是否在栈内，在则活动前所有活动出栈，否则压栈
- SingInstance:单例模式，只会有一个活动实例，且被所有程序共享，其实现是将该活动单独放入到一个栈内，进行被调用

# 2020.08.12
## 学习内容
### 1. DIY自定义标题栏和Dialog
#### 1.1自定义标题栏
自定义标题栏较为简单，相当于创建一个新的布局，在其他布局中进行引入操作，加上
```
<include layout=…>
```
并且在活动中需要将ActionBar隐藏起来。

在自定义标题栏时，ImageButton作为返回键的控件在引入background相对友好一些，图片不会拉伸太多。 
#### 1.2自定义Dialog
Dialog自定义需要继承Dialog，这样，其实只要引入新的布局即可。
 
### 2. ListView的使用以及适配器的构造 
ListView因为内存泄漏以及内存占用大的问题已经很少使用了，但是通过静态内部类进行缓存的机制可以减少内存使用，同时可以学习到适配器模式的内容。 

#### 2.1 简单应用 

直接调用ArrayAdpter，将数组形式data在new ArrayAdpter时传入，最后list_view进行setAdpter操作即可。 
#### 2.2 适配器模式 

主要分四步， 

第一步，先构造所需要的对象类 

第二步，继承BaseAdapter或者ArrayAdapter，进行myAdapter类的构造，其主要实现所继承的方法，在myAdapter的构造方法中引入Object的List数据，用于各种需要重写方法使用。 

学习：R.Layout.XXXX以及R.drawable.XXX均是int型数据，这样，构造传参、后续LayoutInflater找寻布局文件以及对象类保存图片都会有很大的方便。 

第三步，静态内部类的使用 

第四步，主活动中初始化对象类List，然后调用adapter和List View即可

###  Service初步接触 

Service是多用于后台运行的服务，不需要与用户进行交互，在程序后台进行运行，因此这也就引入了多线程在Service中的应用。 

内容还没有深入了解，主要看了下多线程使用，onBind(), onStartCommond()函数。 

# 2020.08.13
## 学习内容
### 1. Fragment 

碎片学习，碎片是一种可以嵌入到活动中的UI片段，能让程序更加合理和充分的利用屏幕空间。 

#### 1.1 碎片的简单用法 

在布局中引入Fargment模块，在name处指定自己新建的Fragment类。 

#### 1.2 动态添加碎片 

布局中引入FrameLayout元素，在主活动中对FrameLayout进行碎片引入。其主要有五个步骤： 

（1）创建待添加的碎片实例 

（2）获取FrameManager：在活动中直接通过调用getSupportFragmentManager()方法 

（3）开启一个事务：bebeginTanscation方式 

（4）向容器内添加或者替换碎片，add()或者replace()方式 
```
add(framlayout, fragment)、 replace(framlayout, fragment) 
```

（5）提交事务，调用commit()方法来完成 

#### 1.3 在碎片中模拟返回栈 

返回栈即将其前一个碎片隐藏压入栈中，这样另一个碎片对其进行替代时，返回键会将另一个碎片弹出恢复前一个碎片。 

　hide()隐藏前一个碎片，addToBackStack() 将碎片加入到返回栈中。 

#### 1.4 碎片与活动之间的通信 

一种方式通过主活动定义方法，碎片中使用getActivity()获取活动进行通信。 

另一种则是通过构造碎片类的传参构造函数引入数据。 

#### 1.5 碎片的生命周期 

四种状态： 

运行状态：碎片可见且所关联的活动处于运行状态 

暂停状态：一个活动进入暂停状态时，与其相关的碎片进入暂停状态 

停止状态：FragmentTransaction进行remove、replace、addToBackStack操作时会进入停止状态。 

销毁状态：活动被销毁，那么碎片也就销毁， FragmentTransaction进行remove、replace没有加入addToBackStack操作时会进入销毁状态。 

五种回调： 

onAttach():碎片与活动建立关联时候调用 

onCreateView():为碎片创建视图时调用 

onActivityCreated():确保碎片相关活动已经创建完毕时候调用 

onDestroyView():当与碎片相关联视图被移除时候调用 

onDetach():当碎片与活动解除关联时候调用 

 
### 2. RecyclerView三种形式 

一种竖直排列，一种横向排列，还有一种是瀑布流即大小可以不一。 

与ListView不同，RecyclerView的Adapter的实现需要继承RecyclerView.adapter,并且需要自写ViewHolder继承RecyclerView.ViewHolder，并且，与ListView不同，RecyclerView点击事件是通过view自身来注册点击事件。 


# 2020.08.14
## 学习内容
### 1. RecyclerView 两类形式实现以及适配器模式 

昨天主要看了理论，今天进行了实现。 

#### 1.1 竖直、水平方向滚动 

竖直方向与水平方向其实一直，都是用到了LinearLayoutManager，只不过水平方向需要设置LinearLayoutManager的 orientation属性为水平方向即可。 

其实现主要依靠继承RecyclerView.Adapter<Object>的自定义适配器，并且适配器中使用ViewHolder进行操作，后续说明。 

#### 1.2 RecyclerView的网格形式和瀑布流形式 

与竖直或者水平方向RecyclerView区别主要在于列数，代码上为滚动控件的布局方式不同，网格型调用 GridLayoutManager，瀑布流则为StaggeredGridLayoutManager。瀑布流意味着每个Item可以布局不一致。 

#### 1.3 适配器模式 

myAdapter继承RecyclerView.Adapter<myAdapter.ViewHolder>，这也意味着myAdapter中必须声明继承 RecyclerView.ViewHolder的ViewHolder进行操作。 

与ListView不同，onCreateViewHolder，onBindViewHolder，getItemCount是最为主要的三个函数，第一个函数创建容器来包含RecyclerView的Item，第二个函数绑定Item进行各种操作，第三个函数返回总数。 

### 2. 通过RecyclerView实现了一个没有数据交互的聊天窗口 

尝试跟着书实现了一个聊天窗口，可以发送消息，接收消息。 

#### 2.1 定义消息类 

定义消息类，包括消息类型（接收还是发送类型 ）、消息内容。 

#### 2.2 定义消息界面 

使用9patch文件作为聊天对话框的背景，这样可以避免由于图片被均匀拉伸从而导致的用户体验差。 

消息界面底端是输入框以及发送按钮。 


#### 2.3 适配器模式 

根据上述1.3所述，建立一个消息的适配器，对于滚动控件来说，适配器模式继承到了一种通知更新方法 notifyItemInserted，然后通过 scrollToPosition定位到新加入的消息。 

### 3. Fragment学习 

#### 3.1 不同像素大小设备展示同一界面的不同展示内容 

在此处学习到了动态加载布局的技巧，限定符是其中一种，如新建layout-large文件夹，将同名布局放入，修改其中内容，当设备满足这一个 layout-large 的设备大小限定后，会显示 layout-large 下的同名布局而不是原始布局。 

#### 3.2 实现简易新闻 

主要分三步， 

- 构造新闻类News 

包括标题和内容。 

- 构建各类布局 

（１）新闻主页：手机设备仅显示标题（加载碎片），平板设备左侧标题（加载碎片），右侧具体内容（FramLayout　初始化没有内容项） 

（２）新闻具体展示页面的布局：包括标题以及内容 

（３）新闻标题碎片的布局：采用RecyclerView竖直形式 

（４）新闻标题Item的布局：采用RecyclerView对应的Item项的布局 

（５）新闻内容碎片的布局：即标题＋内容 

- 实现新闻适配器模式 

新闻的内容设置是采用Intent传数据的方式，Intent.putExtra以及Intent.getStringExtra来进行数据交互，以及Intent的界面跳转功能，点击标题跳转到具体页面。 

适配器根据设备来决定是采用哪种显示方式。

# 2020.08.17
## 学习内容
### 1. Service深入学习 

#### 1.1 多线程学习 

基本就是两种方式，继承Thread或者实现Runnable接口。 
注意：UI控件的更新只能在主线程，而不能在子线程中进行更新。 

#### 1.2 异步消息处理机制 

一种使用Handler进行处理，一种是使用Asynck进行处理，但是似乎两种处理方法都被弃用了。 

这两者都可以在主线程对UI进行操作。 

- Handler主要通过Message的发送接收来处理异步消息，handleMessge + sendMessage。 

- AsyncTask四个函数是主导： 

* onPreExexcute()：后台任务开始前的界面初始化操作 

* doInBackground()：子线程任务执行的函数，所有后台任务在此执行 

* onProgressUpdate()：参数有后台传递过来 

* onPostExecute()：执行完毕后台任务后调用 

 

#### 1.3 Service生命周期 

Service 首先在Manifest上注册，Exported属性表示是否允许其他程序访问该服务，Enabled表示是否启用该服务。 

之后，调用Service时主要依赖startService、stopService、bindService、unbindService四个函数。 

Service的生命周期主要onCreate、 onStartCommond、onDestory三个函数。 

- startService 会调用onCreate以及onStartCommond函数 

- stopService会调用onDestory函数 

- bindService 会调用onCreate函数

- unbindService会调用onDestory函数

 

#### 1.4 活动与服务之间的通信学习 

主要是两种，一种通过Binder(),一种通过Bundle机制，还有一种是使用Intent进行通信。 

 

#### 1.5 前台服务 

前台服务主要是状态栏显示，主要用到了PendingIntent和Notification两个类，设置好参数以后，进行startForeground将服务设置前台显示即状态栏显示。 

 

#### 1.6 IntentService 

相当于一个可以创建异步且自动停止的服务，避免忘记使服务停下来或者ANR错误。IntentService类主要通过onHandleIntent函数进行操作。 

 

### 2. 实现后台下载器功能 

根据所学服务方面的内容，实现后台下载功能。 

主要有四大块： 

- 下载监听器(DownLoadListener)：接口；用于说明下载的四种状态：进行、成功、失败、暂停。 

- 下载任务 (DownLoadTask) ：类，继承异步处理消息机制(AsncTask)；用于实现下载流程：定义下载位置、现在名称、下载状态对应的相应操作、下载进度等 

- 下载服务 (DownLoadService) ：类，继承Service；用于前台显示以及执行下载任务类的操作。 

- 下载主活动 (DownLoadMainActivity) ：活动；主要是进行按钮操作实现下载。 

# 2020.08.18
## 学习内容
### 1. 跨应用Service 

#### 1.1 Intent定义

与之前的Intent使用不同，跨应用需要设置Component，指定所需要跨应用的Service所在包名以及 Service名称。 

之后即可调用startService、stopService、bindService 、unbindService。 

#### 1.2 跨应用Service通信 

主要用到了AIDL和Binder。 

AIDL是Android中IPC（Inter-Process Communication）方式中的一种，AIDL是Android Interface definition language的缩写。主要用于应用之间的传递数据与通信。通信涉及的函数主要在AIDL接口中进行声明，然后一边Service接收，一边发送。AIDL需要同包名的存在于两个需要通信的App中。 

### 2. BroadCast了解 

广播机制主要是为了方便于系统级别的消息通知。 

#### 2.1 标准广播与有序广播 

标准广播是一种完全异步执行的广播，所有广播几乎同时收到消息，这样效率最高同时意味着无法截断。 

有序广播则是一种同步执行的广播，同一时刻只有一个广播接收器可以接受到广播消息，当该广播接收器逻辑结束后，广播消息继续广播，因此广播接收器是有序的，且引入了截断。 

#### 2.2 动态注册与静态注册 

动态注册在代码中声明注册，静态注册则是在xml文件中直接注册
<receiver></receiver>
并进行
<intent-filter> </intent-filter> 

# 2020.08.18
## 学习内容
### 1.  BroadCast 

#### 1.1 昨日问题解决  

模拟器版本问题，Android8.0以上对于静态注册系统广播做了限制，为了节省电量做出的优化，代码在8.0以下版本正常。 

#### 1.2 自定义广播 

实现标准广播与有序广播，并简单调用了一下截断。

#### 1.3 本地广播机制

主要LocalBroadCastManager，对BroadCastReceiver进行 Intent-fileter 过滤注册。 

#### 1.4 强制下线 

实现了一个强制下线的功能，本地广播与全局广播皆可以，因为只要能够在应用程序内广播到即可。 

此处踩坑，强制下线功能想实现弹窗提醒，但是context是全局context，因此一直报错，所以重构Dialog的构造函数，传入当前context。 

### 2. 数据持久化技术 

广播机制主要是为了方便于系统级别的消息通知。 

#### 2.1 文件存储 

写入：OpenFileOutput + BufferedWriter 

读取：OpenFileInput + BufferedReader　 

#### 2.2 SharedPreferences存储 

三种形式　
Context getSharedPreferences() 

Activity  getPreferences() 

PreferenceManager getDefaultSharedPreferences() 

#### 2.3 实现一个记住密码的功能 

利用数据持久化技术，可以实现登录直接记住密码的功能 
