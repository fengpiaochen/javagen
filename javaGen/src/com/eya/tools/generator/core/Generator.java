package com.eya.tools.generator.core;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.eya.tools.generator.util.FieldUtils;
import com.eya.tools.generator.util.TableInfo;

public class Generator {

	protected String url;
	protected String username;
	protected String password;

	// 顶层包名
	protected String parent_package;
	// 模块（加上顶层包名，最后生成如：com.eya.test）
	protected String module_name;

	/** 存放生成的JAVA文件的目录 */
	protected String src_folder ;
	/** 存放生成的jsp文件的目录 */
	protected String web_folder;
	
	public Generator(){}

	public Generator(String url, String username, String password){
		this.url = url;
		this.username = username;
		this.password = password;
	}
	
	public Generator(String url, String username, String password, String parentPackage, String module){
		this.url = url;
		this.username = username;
		this.password = password;
		this.parent_package = parentPackage;
		this.module_name = module;
	}

	/**
     * 获得表信息
     * @param tableNames 表集合
     * @return
     * @throws SQLException
     */
    protected List<TableInfo> getTableInfo(Map<String, String> tableNames) throws SQLException {
        List<TableInfo> tables = new ArrayList<TableInfo>();
        for (String key : tableNames.keySet()) {
            TableInfo ti = new TableInfo(key, tableNames.get(key), FieldUtils.getMysqlFieldInfo(key, url, username,
                password));
            tables.add(ti);
        }
        return tables;
    }
	
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getParent_package() {
		return parent_package;
	}

	public void setParent_package(String parent_package) {
		this.parent_package = parent_package;
	}

	public String getModule_name() {
		return module_name;
	}

	public void setModule_name(String module_name) {
		this.module_name = module_name;
	}

	public String getSrc_folder() {
		return src_folder;
	}

	public void setSrc_folder(String src_folder) {
		this.src_folder = src_folder;
	}

	public String getWeb_folder() {
		return web_folder;
	}

	public void setWeb_folder(String web_folder) {
		this.web_folder = web_folder;
	}
	
}
