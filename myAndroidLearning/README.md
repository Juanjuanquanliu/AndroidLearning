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

### 单例模式 

仅仅实例化一次，分为<code>懒汉与饿汉</code>模式，总共有八种写法，其中饿汉式一般在类被加载时就实例化对象，懒汉试图在使用时候再实例化，另外，八种写法只有两种是完美的，一种加锁双重排查，一种直接写成枚举形式。 
