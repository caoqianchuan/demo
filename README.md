# Demo Project
为了复习Java相关组件，使用这个Demo进行复习，并且最后产生一个适合所有组件的一个项目，并且发布出去
# 项目介绍
当前项目使用Java版本JDK17，Springboot 3.3.5，Mysql 9.0.1,redis_version:7.4.1,RabbitMQ version: 4.0.4
# 项目集成情况
当前版本：springboot web,rabbit mq,mysql,cache,jpa,redis,lombok,druid
# 后台服务
WSL ubuntu,安装docker
- 获取docker资源<br/>
`curl -fsSL https://download.docker.com/linux/ubuntu/gpg | sudo apt-key add -` <br />
`curl -fsSL https://download.docker.com/linux/ubuntu/gpg | sudo gpg --dearmor -o /etc/apt/keyrings/docker.gpg` <br />
`curl -fsSl https://get.docker.com | bash -s docker --mirror Aliyun`<br/>
`curl -fsSL https://mirrors.aliyun.com/docker-ce/linux/ubuntu/gpg | sudo apt-key add -`<br/>
`sudo add-apt-repository "deb [arch=amd64] https://mirrors.aliyun.com/docker-ce/linux/ubuntu $(lsb_release -cs) stable"` <br/>
`sudo apt-get install docker-ce`<br/>
`sudo systemctl status docker`<br/>
` sudo systemctl restart docker`
## Docker 
- 安装MYSQL <br/>
`docker pull mysql` <br/>
`docker run --name mysql -e MYSQ L_ROOT_PASSWORD=root -e MYSQL_DATABASE=baodane -e MYSQL_USER=baodane -e MYSQL_PASSWORD=123456 -e MYSQL_ROOT_HOST=% -p 3306:3306 -d mysql:latest`
- 安装redis<br/>
`docker pull redis`<br/>
`mkdir -p /data/dockerData/redis/conf`<br/>
`vi /data/dockerData/redis/conf/redis.conf`<br/>
`# Redis服务器配置`<br/>
`port 6379`<br/>
`# 配置密码（可选）`<br/>
`requirepass 123456`<br/>
`user baodane on >123456 ~* +@all`<br/>
`#setuser baodane +@pubsub`<br/>
`# 服务器运行模式，以守护进程方式运行（可选）`<br/>
`daemonize no`<br/>
`# 持久化配置（可选）`<br/>
`appendonly yes`<br/>
`# 其他配置...`<br/>
`protected-mode no`<br/>
`docker run -d -v /data/dockerData/redis/conf/redis.conf:/etc/redis/redis.conf -p 6379:6379 --name redis redis redis-server /etc/redis/redis.conf`
- 安装RabbitMQ<br/>
`docker pull rabbitmq`<br/>
`docker run -d --name rabbitmq -p 5672:5672 -p 15672:15672 -e RABBITMQ_DEFAULT_USER=baodane -e RABBITMQ_DEFAULT_PASS=123456 rabbitmq`
- 查看docker内images运行状况<br/>
`docker ps`

