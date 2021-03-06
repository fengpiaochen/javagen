/**
 * Eya.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package ${actionPackage};

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest; 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping; 
import com.eya.core.controller.BaseController;
import com.eya.core.vo.PageData;
import ${servicePackage}.${className}Service; 
import ${packageName}.${className};
 
/**
 *  ${tablecomment}控制器
 * @author   ${author}
 * @version $Id: ${classObjectName}Service.java, v 0.1  ${date?datetime}  ${author} Exp $
 */
@Controller 
@RequestMapping("${folderName}")
public class ${className}Ctrl extends BaseController{
    /**唯一标识**/
	private static final String rel="_${folderName}_list";
  
	/**${tablecomment}业务接口**/
	@Autowired
	private ${className}Service ${classObjectName}Service;
	
	
	@RequestMapping("/list")
	public String list(PageData<${className}> pageData,Model model){ 
		${classObjectName}Service.selectByPaging(pageData);
		return "${folderName}/list";
	}
	
	@RequestMapping("/add")
	public String add(${className} entity, Model model){ 
		${classObjectName}Service.add(entity);
		return "${folderName}/list";
	}
	
	@RequestMapping("/update")
	public String update(${className} entity, Model model){ 
		${classObjectName}Service.update(entity);
		return "${folderName}/list";
	}
 
 	@RequestMapping("/delete")
	public String delete(${className} entity, Model model){ 
		${classObjectName}Service.delete(entity);
		return "${folderName}/list";
	}
 	
 
 
} 