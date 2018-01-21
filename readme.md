

在引用项目中的web.xml配置过滤器：
```
    <filter>
		<filter-name>sophia</filter-name>
		<filter-class>com.tfss.sophia.SophiaFilter</filter-class>
		<init-param>
			<param-name>bootstrap</param-name>
			<param-value>你的初始化类</param-value>
		</init-param>
	</filter>
	<filter-mapping>
		<filter-name>sophia</filter-name>
		<url-pattern>/*</url-pattern>
	</filter-mapping>
```







