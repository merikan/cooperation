package se.skltp.cooperation.web.rest.v1.dto.cooperation;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * A ServiceContract Data Transfer Object
 *
 * @author Peter Merikan
 */
@JsonInclude(Include.NON_NULL)
public class ServiceContractDTO {

	private Long id;
	private String name;
	private String namespace;
	private Integer major;
	private Integer minor;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNamespace() {
		return namespace;
	}

	public void setNamespace(String namespace) {
		this.namespace = namespace;
	}

	public Integer getMajor() {
		return major;
	}

	public void setMajor(Integer major) {
		this.major = major;
	}

	public Integer getMinor() {
		return minor;
	}

	public void setMinor(Integer minor) {
		this.minor = minor;
	}

}