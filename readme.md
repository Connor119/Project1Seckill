# 秒杀系统

### 项目简介
该项目模拟了电商平台秒杀活动界面与基本逻辑。为适应高并发情境下，系统可以正常运行在基础的功能基础上做了多处优化。

### 项目效果展示

该网页的门户网站为登录页面地址为/login/tologin
![1666630793047](https://user-images.githubusercontent.com/62894592/197583227-c1bda7a4-e3a1-47a0-897e-22e58d9b0340.png)
<hr>

用户登录后会跳转到商品列表页面
![1666630928581](https://user-images.githubusercontent.com/62894592/197583574-fdc0afeb-130d-4b90-830c-22325470bd73.png)
<hr>

点击详情可以看见商品秒杀的信息
![1666630970850](https://user-images.githubusercontent.com/62894592/197583689-f67508ae-6e08-4835-b343-71f06e204f3e.png)
<hr>

如上图所示为当秒杀进行中的时候用户可以通过填写验证码点击立即秒杀进行商品的秒杀

当已经过了秒杀时间的时候秒杀按钮不能进行点击并展示秒杀已结束如下图所示
![1666631105668](https://user-images.githubusercontent.com/62894592/197584148-da6cc0fe-d2ce-43b7-a204-1563aa7891b1.png)
<hr>

当秒杀未开始的时候展示倒计时的时间
![1666631163517](https://user-images.githubusercontent.com/62894592/197584441-5aa4576d-04d9-4411-94b7-5a631bfb4fae.png)
<hr>

当秒杀可以进行的时候我们填写正确的验证码才会成功秒杀，而当验证码错误的时候则会出现如下提示
![1666631376682](https://user-images.githubusercontent.com/62894592/197585186-8c09f84c-aaef-41d7-bf1e-d26e58ee3155.png)
<hr>

当输入的验证码正确则会出现如下提示
![1666631644343](https://user-images.githubusercontent.com/62894592/197585962-852d84a6-3285-4ce9-a447-0960c3c5d0ce.png)
<hr>

点击查看订单则可以获取自己的完整订单
![1666631687249](https://user-images.githubusercontent.com/62894592/197586096-30158cac-0278-424c-8b65-e9cc18ee588b.png)
<hr>


在抢购的时候我们需要限制每个人的购买数量，下图所示是当我们已经对商品进行过秒杀后所展示的效果
![1666631256057](https://user-images.githubusercontent.com/62894592/197584700-105ecade-d8c8-4127-b397-5bef6c550714.png)
<hr>

### 项目技术亮点
- 登录优化
  - 使用jsr303校验
  - 全局异常处理
  - redis实现分布式session
  - 自定义参数解析（addArdumentResolver）
- 接口优化
  - 使用redis预减库存
  - 使用redis缓存秒杀订单
  - 使用RabbitMQ实现消息的异步处理
- 接口安全优化
  - 使用动态接口生成技术
  - 使用验证码屏蔽恶意访问，以及将请求进行消峰填谷
  
