package se.skltp.cooperation.web.rest.v1.listdto;


import java.util.ArrayList;
import java.util.List;

import se.skltp.cooperation.web.rest.v1.dto.CooperationDTO;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

/**
 * A wrapper object to hold a list of {@link se.skltp.cooperation.web.rest.v1.dto.CooperationDTO} objects.
 *
 * @author Peter Merikan
 */
@JacksonXmlRootElement(localName="cooperations")
public class CooperationListDTO {

	@JacksonXmlElementWrapper(useWrapping = false)
	@JacksonXmlProperty(localName = "cooperation")
	private List<CooperationDTO> cooperations = new ArrayList<>();

	public List<CooperationDTO> getCooperations() {
		return cooperations;
	}

	public void setCooperations(List<CooperationDTO> cooperations) {
		this.cooperations = cooperations;
	}


}
