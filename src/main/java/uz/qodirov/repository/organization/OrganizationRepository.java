package uz.qodirov.repository.organization;

import com.google.gson.reflect.TypeToken;
import uz.qodirov.container.UNIContainer;
import uz.qodirov.criterias.GenericCriteria;
import uz.qodirov.dtos.organization.OrganizationCreateDto;
import uz.qodirov.dtos.organization.OrganizationDto;
import uz.qodirov.dtos.organization.OrganizationUpdateDto;
import uz.qodirov.property.DatabaseProperties;
import uz.qodirov.repository.AbstractRepository;
import uz.qodirov.repository.GenericCrudRepository;
import uz.qodirov.repository.GenericRepository;
import uz.qodirov.security.SecurityHolder;
import uz.qodirov.settings.Types;


import java.util.List;


public class OrganizationRepository extends AbstractRepository
        implements GenericCrudRepository
        <OrganizationDto,
                OrganizationCreateDto,
                OrganizationUpdateDto,
                Long>, GenericRepository<OrganizationDto, GenericCriteria> {


    @Override
    public Long create(OrganizationCreateDto dto) {
        prepareArguments(gson.toJson(dto), SecurityHolder.authUserSession.getId());
        return (long) callProcedure(property.get("organization.create"), Types.BIGINT);
    }

    @Override
    public Boolean update(OrganizationUpdateDto dto) {
        prepareArguments(gson.toJson(dto), SecurityHolder.authUserSession.getId());
        return (boolean) callProcedure(UNIContainer.
                getBean(DatabaseProperties.class).get("organization.update"), Types.BOOLEAN);
    }

    @Override
    public void delete(Long id) {
        prepareArguments(SecurityHolder.authUserSession.getOrganization().getId(), id);
        callProcedure(UNIContainer.
                getBean(DatabaseProperties.class).get("delete.organization"), Types.VARCHAR);
    }

    @Override
    public OrganizationDto get(Long id) {
        prepareArguments(id);
        String jsonData = (String) callProcedure(property.get("get.organization"), Types.VARCHAR);
        return gson.fromJson(jsonData, OrganizationDto.class);
    }

    @Override
    public List<OrganizationDto> list(GenericCriteria criteria) {
        prepareArguments(SecurityHolder.authUserSession.getId());
        String JsonData = (String) callProcedure(property.get("organization.list"), Types.VARCHAR);
        return gson.fromJson(JsonData, new TypeToken<List<OrganizationDto>>() {
        }.getType());
    }
}
