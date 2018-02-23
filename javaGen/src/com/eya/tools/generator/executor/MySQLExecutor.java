package com.eya.tools.generator.executor;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import com.eya.tools.generator.core.Gen;
import com.eya.tools.generator.core.Generator;
import com.eya.tools.generator.util.MyFile;
import com.eya.tools.generator.util.TableInfo;

public class MySQLExecutor extends Generator {
	
	private Properties properties = new Properties();
	
	{
		InputStream inputStream = MySQLExecutor.class.getClassLoader().getResourceAsStream("gen.properties");
		try {
			properties.load(inputStream);
			this.url = properties.getProperty("dataSource.url");
			this.username = properties.getProperty("dataSource.username");
			this.password = properties.getProperty("dataSource.password");
			this.parent_package = properties.getProperty("package.parent");
			this.src_folder = properties.getProperty("src.folder");
			this.web_folder = properties.getProperty("web.folder");
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	public MySQLExecutor(){}
	
	public void execute(){
		Gen tool = new Gen();
		try {
			// 用于建立目录和写文件
			// MyFile myfile = new MyFile(SRC_FOLDER, WEB_FOLDER);
			MyFile myfile = new MyFile(this.src_folder, this.web_folder);

			// 将需要添加的表存入map中，key为表名，value为生成的实体类的注释
			Map<String, String> map = new HashMap<String, String>();
			map.put("user".toLowerCase(), "用户表");
			map.put("material".toLowerCase(), "物料表");
			map.put("detection".toLowerCase(), "检测表");

			// 准备表对象
			List<TableInfo> tables = getTableInfo(map);
			tool.gen(tables, myfile, this.parent_package);
			System.out.println("=======共计生成表：========" + tables.size() + "张");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		MySQLExecutor executor = new MySQLExecutor();
		executor.execute();
		
	}

}
