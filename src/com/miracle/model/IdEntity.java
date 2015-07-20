package com.miracle.model;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.TableGenerator;

import com.miracle.common.Constant;

/**
 * 统一定义id的entity基类.
 * 
 * 基类统一定义id的属性名称、数据类型、列名映射及生成策略.
 * Oracle需要每个Entity独立定义id的SEQUCENCE时，不继承于本类而改为实现一个Idable的接口。
 * 
 * @author calvin
 */
//JPA 基类的标识
@MappedSuperclass
public abstract class IdEntity implements Serializable {

	private static final long serialVersionUID = 8059906171286273841L;
	protected Long id;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	/**以下配置为一张表对Id进行管理(Oracle)*/
	//@TableGenerator(name = "common_id_generator", allocationSize = 1, table = Constant.GENERATOR_TABLE)
	//@GeneratedValue(strategy = GenerationType.TABLE, generator = "common_id_generator")
	public Long getId() {
		return id;
	}

	public void setId(final Long id) {
		this.id = id;
	}
}
