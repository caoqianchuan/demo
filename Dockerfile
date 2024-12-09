# 使用官方的 oracle 基础镜像
FROM oracle:17.0.13

# 设置工作目录
WORKDIR /app

# 将本地的 JAR 文件复制到容器内的工作目录
COPY target/your-project-name.jar /app/app.jar

# 设置容器启动时运行的命令
ENTRYPOINT ["java", "-jar", "app.jar"]

# 设置容器暴露的端口（可选，视你的应用需求而定）
EXPOSE 8080
