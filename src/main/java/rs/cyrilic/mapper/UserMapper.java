package rs.cyrilic.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import rs.cyrilic.controller.dto.UserDTO;
import rs.cyrilic.model.User;

@Mapper(componentModel = "spring")
public interface UserMapper {
	
	UserDTO entityToDTO(User account);
	User dtoToEntity(UserDTO accountDTO);
    
    List<UserDTO> enitiesToDtos(List<User> list);
    List<User> dtosToEntities(List<UserDTO> list);
    User updateEntityFromDto(UserDTO dto, @MappingTarget User entity);

}
