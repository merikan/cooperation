package se.skltp.cooperation.web.rest.v1.controller;

import java.util.ArrayList;
import java.util.List;

import org.dozer.DozerBeanMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import se.skltp.cooperation.domain.ServiceConsumer;
import se.skltp.cooperation.service.ServiceConsumerCriteria;
import se.skltp.cooperation.service.ServiceConsumerService;
import se.skltp.cooperation.web.rest.exception.ResourceNotFoundException;
import se.skltp.cooperation.web.rest.v1.dto.ServiceConsumerDTO;
import se.skltp.cooperation.web.rest.v1.listdto.ServiceConsumerListDTO;

/**
 * REST controller for managing ServiceConsumer.
 *
 * @author Peter Merikan
 */
@RestController
@RequestMapping(value = { "/api/v1/serviceConsumers", "/api/v1/serviceConsumers.json",
		"/api/v1/serviceConsumers.xlm" })
public class ServiceConsumerController {

	private final Logger log = LoggerFactory.getLogger(ServiceConsumerController.class);

	private final ServiceConsumerService serviceConsumerService;
	private final DozerBeanMapper mapper;

	@Autowired
	public ServiceConsumerController(ServiceConsumerService serviceConsumerService,
			DozerBeanMapper mapper) {
		this.serviceConsumerService = serviceConsumerService;
		this.mapper = mapper;
	}

	/**
	 * GET /connectionPoints -> get all the connectionPoints. Content type: JSON
	 */
	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<ServiceConsumerDTO> getAllAsJson(
			@RequestParam(required = false) Long connectionPointId,
			@RequestParam(required = false) Long logicalAddressId,
			@RequestParam(required = false) Long serviceContractId) {
		log.debug("REST request to get all ServiceConsumers as json");

		List<ServiceConsumerDTO> result = getAll(connectionPointId, logicalAddressId,
				serviceContractId);
		return result;

	}

	/**
	 * GET /connectionPoints -> get all the connectionPoints. Content type: XML
	 * <p/>
	 * TODO: add request param connectionPointId
	 */
	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_XML_VALUE)
	public ServiceConsumerListDTO getAllAsXml(
			@RequestParam(required = false) Long connectionPointId,
			@RequestParam(required = false) Long logicalAddressId,
			@RequestParam(required = false) Long serviceContractId) {
		log.debug("REST request to get all ServiceConsumers as xml");

		ServiceConsumerListDTO result = new ServiceConsumerListDTO();
		result.setServiceConsumers(getAll(connectionPointId, logicalAddressId, serviceContractId));
		return result;

	}

	/**
	 * GET /serviceConsumers/:id -> get the "id" serviceConsumer.
	 */
	@RequestMapping(value = { "/{id}", "/{id}.json", "/{id}.xml" }, method = RequestMethod.GET, produces = {
			MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public ServiceConsumerDTO get(@PathVariable Long id) {
		log.debug("REST request to get ConnectionPoint : {}", id);

		ServiceConsumer serviceConsumer = serviceConsumerService.find(id);
		if (serviceConsumer == null) {
			log.debug("Service consumer with id {} not found", id);
			throw new ResourceNotFoundException("Service consumer with id " + id + " not found");

		}
		return toDTO(serviceConsumer);
	}

	private List<ServiceConsumerDTO> getAll(Long connectionPointId, Long logicalAddressId,
			Long serviceContractId) {

		ServiceConsumerCriteria criteria = new ServiceConsumerCriteria(connectionPointId,
				logicalAddressId, serviceContractId);
		criteria.setConnectionPointId(connectionPointId);
		List<ServiceConsumer> consumers = serviceConsumerService.findAll(criteria);

		List<ServiceConsumerDTO> result = new ArrayList<>();
		for (ServiceConsumer consumer : consumers) {
			result.add(toDTO(consumer));
		}
		return result;
	}

	private ServiceConsumerDTO toDTO(ServiceConsumer consumer) {
		return mapper.map(consumer, ServiceConsumerDTO.class);
	}

}
