package com.mycompany.myapp.service.mapper;

import com.mycompany.myapp.domain.Clans;
import com.mycompany.myapp.domain.InfoPaid;
import com.mycompany.myapp.domain.TelegramAccount;
import com.mycompany.myapp.service.dto.ClansDTO;
import com.mycompany.myapp.service.dto.InfoPaidDTO;
import com.mycompany.myapp.service.dto.TelegramAccountDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link TelegramAccount} and its DTO {@link TelegramAccountDTO}.
 */
@Mapper(componentModel = "spring")
public interface TelegramAccountMapper extends EntityMapper<TelegramAccountDTO, TelegramAccount> {
    @Mapping(target = "clans", source = "clans", qualifiedByName = "clansId")
    @Mapping(target = "infoPaid", source = "infoPaid", qualifiedByName = "infoPaidId")
    TelegramAccountDTO toDto(TelegramAccount s);

    @Named("clansId")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    ClansDTO toDtoClansId(Clans clans);

    @Named("infoPaidId")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    InfoPaidDTO toDtoInfoPaidId(InfoPaid infoPaid);
}
