package rs.cyrilic.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;

import rs.cyrilic.controller.dto.UserRolesDTO;
import rs.cyrilic.model.UserRoles;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface UserRolesMapper {

	UserRolesDTO entityToDTO(UserRoles entity);

	UserRoles dtoToEntity(UserRolesDTO dto);

	List<UserRoles> dtoToEntities(List<UserRolesDTO> list);

	List<UserRolesDTO> enitiesToDtos(List<UserRoles> list);

	UserRoles updateEntityFromDto(UserRolesDTO dto, @MappingTarget UserRoles entity);
}
