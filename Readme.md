## Chiikwa讨伐大作战
1. 窗口的创建
    - 设置宽高
      - 设置为横版游戏
    - 设置Icon
    - 设置图片背景
      - 利用PPT和画图，对图片进行裁剪，消除，改变尺寸
      - 这里遇到了相当大的困难，JFrame重写paint方法不管用
        - 困难已经解决，虽然还没有知道bug出在哪里，但是反复repaint就行
    - 设置游戏开始界面
   


2. 设置游戏的开始，暂停，退出
   - 开始：按空格键或者鼠标指针点击窗口任意位置开始
   - 暂停：按空格键暂停
   - 退出：按下exit键退出，点击窗口按钮退出


3. 滚轮切换武器或者装备之类的


4. 游戏物体
   - 公有属性
      - 物体所在的x轴
      - 物体所在的y轴
      - 物体本身的图片
      - 物体的宽度
      - 物体的高度
      - 物体的移动速度
   - 公共方法
     - 绘制方法
     - 计算物体所在方框方法
   - 包含物体
     - 游戏角色
     - 角色攻击子弹，用集合批量添加
     - 敌方角色，用集合批量添加
       - 随机生成
6. 已解决bug
   - 背景图片的无缝衔接问题，利用两张图片实现无缝衔接，已解决
   - 出现严重闪烁问题，利用双缓存技术，已解决
7. 待解决bug
   - 暂停后恢复游戏，以及第一次启动游戏应该将鼠标指针定位到上一次或者刚开始的位置