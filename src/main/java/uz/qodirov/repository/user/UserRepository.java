package uz.qodirov.repository.user;

import uz.qodirov.criterias.GenericCriteria;
import uz.qodirov.dtos.GenericDto;
import uz.qodirov.dtos.auth.UserCreateDto;
import uz.qodirov.dtos.auth.UserUpdateDto;
import uz.qodirov.dtos.user.BlockDto;
import uz.qodirov.exception.ApiRuntimeException;
import uz.qodirov.exception.CustomerSQLException;
import uz.qodirov.repository.AbstractRepository;
import uz.qodirov.repository.GenericCrudRepository;
import uz.qodirov.repository.GenericRepository;
import uz.qodirov.security.SecurityHolder;
import uz.qodirov.utils.BaseUtils;

import java.sql.Types;
import java.util.List;

public class UserRepository extends AbstractRepository implements
        GenericCrudRepository<GenericDto, UserCreateDto, UserUpdateDto, Long>,
        GenericRepository<GenericDto, GenericCriteria> {

    @Override
    public Long create(UserCreateDto dto) {
        String json = BaseUtils.gson.toJson(dto);
        prepareArguments(json, SecurityHolder.authUserSession.getId());
        return (long) callProcedure(property.get("user.create"), Types.BIGINT);
    }

    @Override
    public GenericDto get(Long id) {
        return null;
    }

    @Override
    public Boolean update(UserUpdateDto dto) {
        return false;
    }

    @Override
    public void delete(Long id) {
        try {
            prepareArguments(id, SecurityHolder.authUserSession.getId());
            callProcedure(property.get("user.delete"), Types.BOOLEAN);
        } catch (CustomerSQLException e) {
            throw new ApiRuntimeException(e.getFriendlyMessage(), e.getStatus());
        }
    }

    @Override
    public List<GenericDto> list(GenericCriteria criteria) {
        return null;
    }

    public void block(BlockDto dto) {
        prepareArguments(gson.toJson(dto), SecurityHolder.authUserSession.getId());
        callProcedure(property.get("user.block"), Types.BOOLEAN);
    }
}
