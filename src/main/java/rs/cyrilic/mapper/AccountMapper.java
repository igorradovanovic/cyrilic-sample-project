package rs.cyrilic.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;
import rs.cyrilic.controller.dto.AccountDTO;
import rs.cyrilic.model.Account;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface AccountMapper {
	
	
	    AccountDTO entityToDTO(Account entity);
	    Account dtoToEntity(AccountDTO dto);
	    
	    List<Account> dtoToEntities(List<AccountDTO> list);
	    List<AccountDTO> enitiesToDtos(List<Account> list);
	    
	    Account updateEntityFromDto(AccountDTO dto, @MappingTarget Account entity);
	
}
