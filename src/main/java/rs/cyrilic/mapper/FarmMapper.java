package rs.cyrilic.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import rs.cyrilic.controller.dto.FarmDTO;
import rs.cyrilic.model.Farm;

@Mapper(componentModel = "spring")
public interface FarmMapper {
	
	FarmDTO entityToDTO(Farm account);
	Farm dtoToEntity(FarmDTO accountDTO);
    
    List<FarmDTO> enitiesToDtos(List<Farm> list);
    List<Farm> dtoToEntities (List<FarmDTO> list);
    Farm updateEntityFromDto(FarmDTO dto, @MappingTarget Farm entity);

}
