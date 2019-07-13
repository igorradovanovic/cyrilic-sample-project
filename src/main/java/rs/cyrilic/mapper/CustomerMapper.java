package rs.cyrilic.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import rs.cyrilic.controller.dto.CustomerDTO;
import rs.cyrilic.model.Customer;

@Mapper(componentModel = "spring")
public interface CustomerMapper {
		
		
		    CustomerDTO entityToDTO(Customer account);
		    Customer dtoToEntity(CustomerDTO accountDTO);
		    
		    List<Customer> dtoToEntities(List<CustomerDTO> list);
		    List<CustomerDTO> enitiesToDtos(List<Customer> list);
		    
		    Customer updateEntityFromDto(CustomerDTO dto, @MappingTarget Customer entity);
}
