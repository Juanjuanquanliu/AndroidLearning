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

