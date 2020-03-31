package spm.spring.world.restservice.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;
import spm.spring.world.dtos.UserMsDto;
import spm.spring.world.entities.User;

import java.util.List;

@Mapper(componentModel = "Spring")
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    // use To User UserMsDto
//    @Mapping(source = "emailId", target = "emailaddress") // if we do mapping for only one field
    @Mappings({@Mapping(source = "emailId", target = "emailaddress"),
            @Mapping(source = "role", target = "roleNumber")
    })
    UserMsDto userToUserMsDto(User user);

    // List<User> to List<UserMsDto>
    List<UserMsDto> usersToUserDtos(List<User> users);
}
