package se.skltp.cooperation.web.rest.v1.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

/**
 * A Cooperation Data Transfer Object with associations
 *
 * @author Peter Merikan
 */

@JacksonXmlRootElement(localName = "cooperation")
@JsonInclude(Include.NON_EMPTY)
public class CooperationDTO {
	private Long id;

	private ServiceConsumerDTO serviceConsumer;
	private LogicalAddressDTO logicalAddress;
	private ConnectionPointDTO connectionPoint;
	private ServiceContractDTO serviceContract;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public ServiceConsumerDTO getServiceConsumer() {
		return serviceConsumer;
	}

	public void setServiceConsumer(ServiceConsumerDTO serviceConsumer) {
		this.serviceConsumer = serviceConsumer;
	}

	public LogicalAddressDTO getLogicalAddress() {
		return logicalAddress;
	}

	public void setLogicalAddress(LogicalAddressDTO logicalAddress) {
		this.logicalAddress = logicalAddress;
	}

	public ConnectionPointDTO getConnectionPoint() {
		return connectionPoint;
	}

	public void setConnectionPoint(ConnectionPointDTO connectionPoint) {
		this.connectionPoint = connectionPoint;
	}

	public ServiceContractDTO getServiceContract() {
		return serviceContract;
	}

	public void setServiceContract(ServiceContractDTO serviceContract) {
		this.serviceContract = serviceContract;
	}
}
