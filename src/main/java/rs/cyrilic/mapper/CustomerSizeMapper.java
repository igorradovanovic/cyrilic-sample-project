package rs.cyrilic.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import rs.cyrilic.controller.dto.CustomerSizeDTO;
import rs.cyrilic.model.CustomerSize;

@Mapper(componentModel = "spring")
public interface CustomerSizeMapper {
	
	CustomerSizeDTO entityToDTO(CustomerSize account);
	CustomerSize dtoToEntity(CustomerSizeDTO accountDTO);
    
    List<CustomerSizeDTO> enitiesToDtos(List<CustomerSize> list);
    List<CustomerSize>dtosToEntities(List<CustomerSizeDTO> list);
    CustomerSize updateEntityFromDto(CustomerSizeDTO dto, @MappingTarget CustomerSize entity);

}
